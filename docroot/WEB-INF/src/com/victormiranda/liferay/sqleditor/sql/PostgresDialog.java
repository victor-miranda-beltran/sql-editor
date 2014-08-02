package com.victormiranda.liferay.sqleditor.sql;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Victor Miranda
 */
public class PostgresDialog implements SQLDialog, Serializable {

	@Override
	public String getLimitQuery(String query, long start, long length) {
		return query + " LIMIT " + length + " OFFSET " + start + ";";
	}

	@Override
	public String getCountFromQuery(String query) {
		return "SELECT COUNT(*) FROM (" + query + ") as total;";
	}

	@Override
	public Map<String,List<String>> getTables(Connection conn)
			throws SQLException {

		SortedMap<String,List<String>> results = new TreeMap<String, List<String>>();

		DatabaseMetaData dbmd = conn.getMetaData();

		ResultSet tables = dbmd.getTables(null, null, null, TABLE_TYPES);

		while (tables.next()) {
			String tableName = tables.getString(TABLE_NAME);
			List<String> fieldsList = new ArrayList<String>();

			ResultSet fields = dbmd.getColumns(null, null, tableName, null);

			while (fields.next()) {
				fieldsList.add(fields.getString(COLUMN_NAME));
			}

			results.put(tableName, fieldsList);
		}

		return results;
	}

	public static String getDriverClass() {
		return "org.postgresql.Driver";
	}
}
