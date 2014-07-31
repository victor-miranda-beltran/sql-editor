package com.victormiranda.liferay.sqleditor.sql;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Victor Miranda
 */
public interface SQLDialog {

	public String getLimitQuery(String query, long start, long length);

	public String getCountFromQuery(String query);

	public Map<String,List<String>> getTables(Connection conn) throws SQLException;

	public static final String COLUMN_NAME = "COLUMN_NAME";

	public static final String TABLE_NAME = "TABLE_NAME";

	public static final String[] TABLE_TYPES = {"TABLE"};
}
