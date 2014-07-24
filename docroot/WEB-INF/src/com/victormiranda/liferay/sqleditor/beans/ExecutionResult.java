package com.victormiranda.liferay.sqleditor.beans;

import com.liferay.portal.kernel.json.JSONArray;

import java.io.Serializable;

/**
 * @author Victor Miranda
 */
public class ExecutionResult implements Serializable {

	public ExecutionResult() {
	}

	public String getQuery() {
		return _query;
	}

	public void setQuery(String query) {
		_query = query;
	}

	public JSONArray getResults() {
		return _results;
	}

	public void setResults(JSONArray results) {
		_results = results;
	}

	public long getNumElements() {
		return _numElements;
	}

	public void setNumElements(long numElements) {
		_numElements = numElements;
	}

	private String _query;
	private JSONArray _results;
	private long _numElements;
}
