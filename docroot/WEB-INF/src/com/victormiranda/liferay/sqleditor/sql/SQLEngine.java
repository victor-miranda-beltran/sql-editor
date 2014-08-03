package com.victormiranda.liferay.sqleditor.sql;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.victormiranda.liferay.sqleditor.beans.ExecutionResult;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * @author Victor Miranda
 */
public class SQLEngine implements Serializable {

	private SQLEngine() {
		_liferayDS = InfrastructureUtil.getDataSource();

		dialog = SQLDialogFactory.getDialog(
			PropsUtil.get(PropsKeys.JDBC_DEFAULT_DRIVER_CLASS_NAME));
	}

	public static synchronized SQLEngine getInstance() {
		if (_instance == null) {
			_instance = new SQLEngine();
		}

		return _instance;
	}

	public ExecutionResult runSQL(String query, int start, int length)
		throws SQLException {

		JSONArray results = JSONFactoryUtil.createJSONArray();

		Connection conn = _liferayDS.getConnection();

		long count = 0;
		long rows;
		ExecutionResult executionResult = new ExecutionResult();

		JSONObject obj = JSONFactoryUtil.createJSONObject();

		if (isSelectQuery(query)) {
			count = getCount(conn, query);

			String limitedQuery = getLimitedQuery(query, start, length);

			ResultSet rs = executeQuery(conn, limitedQuery);

			ResultSetMetaData md = rs.getMetaData();

			int columns = md.getColumnCount();

			while (rs.next()) {
				obj = JSONFactoryUtil.createJSONObject();

				for(int i=1; i<=columns; ++i) {
					String val = rs.getObject(i) != null ?
						rs.getObject(i).toString() :null;

					obj.put(md.getColumnName(i), val);
				}

				results.put(obj);
			}
		}
		else {
			rows = executeUpdate(conn, query);

			obj.put("Rows", rows);

			results.put(obj);
		}

		executionResult.setResults(results);
		executionResult.setNumElements(count);
		executionResult.setQuery(query);

		return executionResult;
	}

	public ResultSet executeQuery( String query)
			throws SQLException {

		Connection conn = _liferayDS.getConnection();

		Statement stmt = conn.createStatement();

		return  executeQuery(conn, query);
	}

	public int executeUpdate(Connection conn, String query)
			throws SQLException {

		Statement stmt = conn.createStatement();

		return  stmt.executeUpdate(query);
	}

	public JSONArray getTables() throws SQLException {

		JSONArray tableArray = JSONFactoryUtil.createJSONArray();

		Connection conn = _liferayDS.getConnection();

		Map<String,List<String>> tables = dialog.getTables(conn);

		for (Map.Entry<String,List<String>> e : tables.entrySet()) {
			String tableName = e.getKey();

			JSONObject tableObject = JSONFactoryUtil.createJSONObject();

			tableObject.put("label", tableName);
			tableObject.put("id", tableName);

			JSONArray children = JSONFactoryUtil.createJSONArray();

			List<String> tableFieldsList = e.getValue();

			for (String tableField : tableFieldsList) {
				JSONObject tableFieldObj = JSONFactoryUtil.createJSONObject();

				tableFieldObj.put("label", tableField);
				tableFieldObj.put("id", tableField);

				children.put(tableFieldObj);

			}
			tableObject.put("children", children);

			tableArray.put(tableObject);
		}

		return tableArray;
	}

	private ResultSet executeQuery(Connection conn, String query)
			throws SQLException {

		Statement stmt = conn.createStatement();

		return stmt.executeQuery(query);
	}

	private String getLimitedQuery(String query, int start, int length) {
		if (query.trim().endsWith(";")) {
			query = query.trim().substring(0,query.trim().length()-1);
		}

		if (start == -1) {
			start = 0;
			length = 10;
		}

		query = dialog.getLimitQuery(query, start, length);

		return query;
	}

	private long getCount(Connection conn, String query) throws SQLException {

		if (query.trim().endsWith(";")) {
			query = query.trim().substring(0,query.trim().length()-1);
		}

		String countQuery = dialog.getCountFromQuery(query);

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(countQuery);

		while(rs.next()) {
			return rs.getLong(1);
		}

		return 0;
	}

	private boolean isSelectQuery(String query) {
		if (query != null && query.trim().toLowerCase().startsWith("select")) {
			return true;
		}

		return false;
	}

	private final DataSource _liferayDS;

	private static SQLEngine _instance;

	private final SQLDialog dialog;

}
