package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.TableStatus;

public interface IDinnerTableService {
	/**
	 * 根据预定状态查询
	 * @return
	 */
	List<DinnerTable> findNoUseTable();
	
	/**
	 * 主键查询
	 * @param id
	 * @return
	 */
	DinnerTable findById(int id);
}
