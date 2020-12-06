package cn.itcast.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.IFoodTypeDao;
import cn.itcast.entity.FoodType;
import cn.itcast.utils.JdbcUtils;

/**
 * 2.菜系模块dao实现
 * @author Administrator
 *
 */
public class FoodTypeDao implements IFoodTypeDao {

	
	@Override
	public void delete(int id) {
		String sql = "delete from foodType where id=?";
		try{
			JdbcUtils.getQueryRunner().update(sql,id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public FoodType findById(int id) {
		String sql = "select * from foodType where id=?";
		try{
			return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<FoodType>(FoodType.class),id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll() {
		String sql = "select * from foodType";
		try{
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll(String typeName) {
		String sql = "select * from foodType where typeName like ?";
		try{
			return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class),"%"+typeName+"%");
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void save(FoodType foodType) {
		String sql = "insert into foodType(typeName) values(?)";
		try {
			JdbcUtils.getQueryRunner().update(sql, foodType.getTypeName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(FoodType foodType) {
		String sql = "update foodType set typeName = ? where id = ?";
		try {
			JdbcUtils.getQueryRunner().update(sql, foodType.getTypeName(),foodType.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}
