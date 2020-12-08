package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.TableStatus;

public interface IDinnerTableDao {
	/**
	 * 根据预定状态查询
	 * @return
	 */
	List<DinnerTable> findByStatus(TableStatus ts);
	
	/**
	 * 主键查询
	 * @param id
	 * @return
	 */
	DinnerTable findById(int id);
}
