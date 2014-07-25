/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.victormiranda.liferay.sqleditor.service.base;

import com.victormiranda.liferay.sqleditor.service.SnippetEntryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SnippetEntryLocalServiceClpInvoker {
	public SnippetEntryLocalServiceClpInvoker() {
		_methodName0 = "addSnippetEntry";

		_methodParameterTypes0 = new String[] {
				"com.victormiranda.liferay.sqleditor.model.SnippetEntry"
			};

		_methodName1 = "createSnippetEntry";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSnippetEntry";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSnippetEntry";

		_methodParameterTypes3 = new String[] {
				"com.victormiranda.liferay.sqleditor.model.SnippetEntry"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchSnippetEntry";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchSnippetEntryByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchSnippetEntryByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getSnippetEntry";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getSnippetEntryByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getSnippetEntryByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getSnippetEntries";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getSnippetEntriesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateSnippetEntry";

		_methodParameterTypes19 = new String[] {
				"com.victormiranda.liferay.sqleditor.model.SnippetEntry"
			};

		_methodName44 = "getBeanIdentifier";

		_methodParameterTypes44 = new String[] {  };

		_methodName45 = "setBeanIdentifier";

		_methodParameterTypes45 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.addSnippetEntry((com.victormiranda.liferay.sqleditor.model.SnippetEntry)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.createSnippetEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.deleteSnippetEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.deleteSnippetEntry((com.victormiranda.liferay.sqleditor.model.SnippetEntry)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.fetchSnippetEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.fetchSnippetEntryByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.fetchSnippetEntryByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.getSnippetEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.getSnippetEntryByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.getSnippetEntryByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.getSnippetEntries(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.getSnippetEntriesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.updateSnippetEntry((com.victormiranda.liferay.sqleditor.model.SnippetEntry)arguments[0]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return SnippetEntryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			SnippetEntryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
}