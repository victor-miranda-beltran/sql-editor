package com.victormiranda.liferay.sqleditor.sql;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.victormiranda.liferay.sqleditor.beans.ExecutionResult;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Victor Miranda
 */
public class SQLEngine implements Serializable {

	private SQLEngine() {
		_liferayDS = InfrastructureUtil.getDataSource();

		DRIVER = com.liferay.portal.kernel.util.PropsUtil.get(PropsKeys.JDBC_DEFAULT_DRIVER_CLASS_NAME);
	}

	public static synchronized SQLEngine getInstance() {
		if (_instance == null) {
			_instance = new SQLEngine();
		}
		return _instance;
	}

	public ExecutionResult runSQL(String query, int start, int length) throws SQLException {
		JSONArray results = JSONFactoryUtil.createJSONArray();

		Connection conn = _liferayDS.getConnection();

		long count = getCount(conn, query);

		ExecutionResult executionResult = new ExecutionResult();

		ResultSet rs = executeQuery(conn, getLimitedQuery(query, start, length));

		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();

		while (rs.next()) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();

			for(int i=1; i<=columns; ++i) {
				String val = rs.getObject(i) != null ?
						rs.getObject(i).toString() :null;

				obj.put(md.getColumnName(i), val);
			}

			results.put(obj);
		}
		executionResult.setResults(results);
		executionResult.setNumElements(count);
		executionResult.setQuery(query);

		return executionResult;
	}

	public ResultSet executeQuery(String query)
			throws SQLException {

		Connection conn = _liferayDS.getConnection();

		return executeQuery(conn, query);
	}

	public ResultSet executeQuery(Connection conn, String query)
			throws SQLException {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query);

		return rs;
	}

	public JSONArray getTables() throws SQLException {

		JSONArray tableArray = JSONFactoryUtil.createJSONArray();

		Connection conn = _liferayDS.getConnection();
		DatabaseMetaData dbmd = conn.getMetaData();

		ResultSet tables = dbmd.getTables(null, null, null, TABLE_TYPES);

		while (tables.next()) {
			String tableName = tables.getString(TABLE_NAME);

			JSONObject tableObject = JSONFactoryUtil.createJSONObject();

			tableObject.put("label", tableName);
			tableObject.put("id", tableName);
			tableObject.put("children", getTableFields(dbmd, tableName));

			tableArray.put(tableObject);
		}

		return tableArray;
	}

	private String getLimitedQuery(String query, int start, int length) {
		if (query.trim().endsWith(";")) {
			query = query.trim().substring(0,query.trim().length()-1);
		}
		if (start == -1) {
			start = 0;
			length = 10;
		}

		if ("com.mysql.jdbc.Driver".equals(DRIVER)) {
			query = query + " LIMIT " + start+ ", " + length + ";";

		}
		else if ("org.hsqldb.jdbcDriver".equals(DRIVER)) {
			query = query + " LIMIT " + length + " OFFSET " + start + ";";
		}


		System.out.println(query);
		return query;
	}

	private long getCount(Connection conn, String query) throws SQLException {

		if (query.trim().endsWith(";")) {
			query = query.trim().substring(0,query.trim().length()-1);
		}

		String countQuery = "SELECT COUNT(*) FROM (" + query + ") as total;";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(countQuery);
		while(rs.next()) {
			return rs.getLong(1);
		}

		return 0;
	}

	private JSONArray getTableFields(DatabaseMetaData dbmd, String tableName)
			throws SQLException {

		JSONArray fieldsArray = JSONFactoryUtil.createJSONArray();

		ResultSet fields = dbmd.getColumns(null, null, tableName, null);

		while (fields.next()) {
			JSONObject fieldObject = JSONFactoryUtil.createJSONObject();

			fieldObject.put("label", fields.getString(COLUMN_NAME));

			fieldsArray.put(fieldObject);
		}

		return fieldsArray;
	}

	private final DataSource _liferayDS;

	private static SQLEngine _instance;

	private final String DRIVER;

	private static final String COLUMN_NAME = "COLUMN_NAME";

	private static final String TABLE_NAME = "TABLE_NAME";

	private static final String[] TABLE_TYPES = {"TABLE"};


}
