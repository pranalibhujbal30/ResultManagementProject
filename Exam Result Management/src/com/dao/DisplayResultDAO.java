/**
 * 
 */
package com.dao;

import java.util.List;

import com.pojo.Result;

/**
 * @author janhavi
 *
 */
public interface DisplayResultDAO {
	public List<Result> getStudentResult(String id);
}
