package com.victormiranda.liferay.sqleditor.sql;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.PropsKeys;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	private JSONArray getTableFields(DatabaseMetaData dbmd, String tableName) throws SQLException {

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
