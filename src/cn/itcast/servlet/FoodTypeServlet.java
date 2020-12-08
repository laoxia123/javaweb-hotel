package cn.itcast.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.FoodType;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IFoodTypeService;
import cn.itcast.service.impl.FoodTypeService;
import cn.itcast.utils.WebUtils;

/**
 * 4.菜系管理Servlet开发
 * 
 * a.添加菜系
 * b.菜系列表展示
 * c.进入更新页面
 * d.删除
 * e.更新
 * @author Administrator
 *
 */
public class FoodTypeServlet extends HttpServlet {
	
	//调用的菜系service
	private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService", IFoodTypeService.class);

	//跳转资源
	private Object uri;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取操作类型
		String method = request.getParameter("method");
		//判断
		if("addFoodType".equals(method)){
			//添加
			addFoodType(request, response);
		}
		else if("list".equals(method)){
			//列表展示
			list(request, response);
		}
		else if("viewUpdate".equals(method)){
			//进入更新页面
			viewUpdate(request, response);
		}
		else if("delete".equals(method)){
			//删除
			delete(request, response);
		}
		else if("update".equals(method)){
			//删除
			update(request, response);
		}
	}
	
	//a.添加菜系
	public void addFoodType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				//1.获取请求数据封装
				String foodTypeName = request.getParameter("foodTypeName");
				FoodType ft = new FoodType();
				ft.setTypeName(foodTypeName);
				//2.调用service处理业务逻辑
				foodTypeService.save(ft);
				//3.跳转
//				uri = "/foodType?method=list";
				uri = request.getRequestDispatcher("/foodType?method=list");
			} catch (Exception e) {
				e.printStackTrace();
				uri = "/error/error.jsp";
			}
			//转发
//			request.getRequestDispatcher(uri).forward(request, response);
			WebUtils.goTo(request, response,uri);
	}

	
	
	//b.菜系列表展示
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			try {
				//调用Service查询所有的类别
				List<FoodType> list = foodTypeService.getAll();
				//保存
				request.setAttribute("listFoodType", list);
				//路径:跳转到菜系列表页面
//				uri = "/sys/type/foodtype_list.jsp";
				uri = request.getRequestDispatcher("/sys/type/foodtype_list.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				uri = "/error/error.jsp";
			}
			WebUtils.goTo(request, response,uri);
	}

//	c.进入更新页面
	public void viewUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				//1.获取请求id
				String id = request.getParameter("id");
				//2.根据id查询对象
				FoodType ft = foodTypeService.findById(Integer.parseInt(id));
				//3.保存
				request.setAttribute("foodType", ft);
				//4.跳转
//				uri = "/sys/type/foodtype_update.jsp";
				uri = request.getRequestDispatcher("/sys/type/foodtype_update.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				uri = "/error/error.jsp";
			}
			WebUtils.goTo(request, response,uri);
	}
	
	//d.删除
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//1.获取请求id
			String id = request.getParameter("id");
			foodTypeService.delete(Integer.parseInt(id));
			uri = request.getRequestDispatcher("/foodType?method=list");
		
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		//转发
		WebUtils.goTo(request, response,uri);
		
	}
	
	//e.更新
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//1.获取请求数据
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("foodTypeName");
			FoodType foodType = new FoodType();
			foodType.setId(id);
			foodType.setTypeName(name);
			//2.调用service更新
			foodTypeService.update(foodType);
			//3.跳转
			uri = "/foodType?method=list";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		//转发
//		request.getRequestDispatcher(uri).forward(request, response);
		WebUtils.goTo(request, response,uri);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			this.doGet(request, response);
	}

}

















