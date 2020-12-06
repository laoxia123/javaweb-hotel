package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.FoodType;

/**
 * 菜系模块，业务逻辑层，接口设计
 * @author Administrator
 *
 */
public interface IFoodTypeService {
	/**
	 * 添加
	 */
	
	void save(FoodType foodType);
	/**
	 * 更新
	 */
	void update(FoodType foodType);
	
	/**
	 * 删除
	 */
	void delete(int id);
	
	/**
	 * 根据主键查询
	 */
	FoodType findById(int id);
	
	/**
	 * 查询全部
	 */
	List<FoodType> getAll();
	/**
	 * 根据菜系名称查询
	 */
	List<FoodType> getAll(String typeName);
}
