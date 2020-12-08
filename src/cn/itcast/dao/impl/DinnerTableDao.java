package cn.itcast.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.itcast.dao.IDinnerTableDao;
import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.TableStatus;
import cn.itcast.utils.JdbcUtils;

public class DinnerTableDao implements IDinnerTableDao {

	@Override
	public List<DinnerTable> findByStatus(TableStatus ts) {
		String sql = "select * from dinnerTable where tableStatus=?";
		/*int status = -1;
		//判断
		if(ts==TableStatus.Free){
			status=0;
		}else{
			status=1;
		}*/
		
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class),ts.ordinal());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public DinnerTable findById(int id) {
		String sql = "select * from dinnerTalbe where id = ?";
		try {
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<DinnerTable>(DinnerTable.class),id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
