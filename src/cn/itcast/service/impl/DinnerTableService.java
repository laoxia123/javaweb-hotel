package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IDinnerTableDao;
import cn.itcast.dao.impl.DinnerTableDao;
import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.TableStatus;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IDinnerTableService;

public class DinnerTableService implements IDinnerTableService {
	
	//调用的dao,通常工厂创建实例
	private IDinnerTableDao dinnerTableDao = BeanFactory.getInstance(
			"dinnerTableDao", IDinnerTableDao.class);
	
	@Override
	public DinnerTable findById(int id) {
		
		try {
			return dinnerTableDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	public List<DinnerTable> findNoUseTable() {
		
		try {
			return dinnerTableDao.findByStatus(TableStatus.Free);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
