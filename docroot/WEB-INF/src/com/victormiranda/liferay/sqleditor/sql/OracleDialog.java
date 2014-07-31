package com.victormiranda.liferay.sqleditor.sql;

import com.liferay.portal.kernel.nio.intraband.SystemDataType;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Victor Miranda
 */
public class OracleDialog implements SQLDialog, Serializable {

	@Override
	public String getLimitQuery(String query, long start, long length) {
		return "select * " +
				"  from ( select a.*, rownum rnum" +
				"     from ( "+ query+" ) a" +
				"     where rownum <= "+ (start + length) +" )\n" +
				" where rnum >= "+ start;
	}

	@Override
	public String getCountFromQuery(String query) {
		return "select MAX(rownum)" +
				"  from ( " + query + " )";
	}

	@Override
	public Map<String,List<String>> getTables(Connection conn)
		throws SQLException {

		SortedMap<String,List<String>> results = new TreeMap<String, List<String>>();

		String q = "SELECT USER_TABLES.TABLE_NAME, \n" +
				"USER_TAB_COLUMNS.COLUMN_NAME \n" +
				"FROM USER_TABLES,USER_TAB_COLUMNS \n" +
				"WHERE USER_TABLES.TABLE_NAME = \n" +
				"USER_TAB_COLUMNS.TABLE_NAME\n" +
				"ORDER BY USER_TABLES.TABLE_NAME";

		Statement stmt = conn.createStatement();

		ResultSet tables = stmt.executeQuery(q);

		while (tables.next()) {

			String tableName = tables.getString(1);
			String columnName = tables.getString(2);

			if (results.get(tableName) == null) {
				results.put(tableName, new ArrayList<String>());
			}

			results.get(tableName).add(columnName);
		}

		return results;
	}

	public static String getDriverClass() {
		return "oracle.jdbc.OracleDriver";
	}
}
