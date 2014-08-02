package com.victormiranda.liferay.sqleditor.sql;

/**
 * @author Victor Miranda
 */
public class SQLDialogFactory {

	public static SQLDialog getDialog(String driver) {
		SQLDialog dialog;

		if(MysqlDialog.getDriverClass().equals(driver)) {
			dialog = new MysqlDialog();
		}
		else if (OracleDialog.getDriverClass().equals(driver)) {
			dialog = new OracleDialog();
		}
		else if (HsqlDialog.getDriverClass().equals(driver)) {
			dialog = new HsqlDialog();
		}
		else if (PostgresDialog.getDriverClass().equals(driver)) {
			dialog = new PostgresDialog();
		}
		else {
			throw new IllegalStateException();
		}

		return dialog;
	}
}
