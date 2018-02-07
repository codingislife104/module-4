package com.capgemini.spring.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.spring.web.entities.Product;
import com.capgemini.spring.web.exception.ProductException;
import com.capgemini.spring.web.service.IProductService;


@Controller("ProductController")
public class ProductController 
{
	@Autowired
	private IProductService productService;

	public ProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductController(IProductService productService) {
		super();
		this.productService = productService;
	}

	/**
	 * @return the productService
	 */
	public IProductService getProductService() {
		return productService;
	}

	/**
	 * @param productService the productService to set
	 */
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	//===================================================================
	
	//Navitation Methods
	
	@RequestMapping("/Menu.obj")
	public String getMenuPage()
	{
		return "MenuPage";
	}
	
	@RequestMapping("/AddProduct.obj")
	public String getAddProductPage(Model model)
	{
		List<String> categories = new ArrayList<String>();
		
		categories.add("Electronics");
		categories.add("Clothes");
		categories.add("Shoes");
		categories.add("Mobiles");
		categories.add("Stationary");
		categories.add("Bags");
		categories.add("Books");
		categories.add("Watches");
		
		model.addAttribute("categories", categories);
		
		model.addAttribute("product", new Product());
		 
		return "AddProduct";
	}
	
	@RequestMapping("/GetProduct.obj")
	public String getProductPage()
	{
		
		return "GetProduct";
	}
	
	@RequestMapping("/UpdateProduct.obj")
	public String getUpdateProductPage()
	{
		return "UpdateProduct";
	}
	
	@RequestMapping("/RemoveProduct.obj")
	public String getRemoveProductPage()
	{
		return "RemoveProduct";
	}
	
	@RequestMapping("/ViewAllProduct.obj")
	public String getViewAllProductsPage(Model model)
	{
		try 
		{
			List<Product> products = productService.getAllProducts();
			
			model.addAttribute("products", products);
			
			return "ViewAllProducts";
		} 
		catch (ProductException e) 
		{
			model.addAttribute("errMsg", e.getMessage());
			
			return "ErrorPage";
		}
	}
	
	
	//Form handling Methods
	
	@RequestMapping(value="/ProcessAddProduct.obj", method=RequestMethod.POST)
	public ModelAndView processAddProductForm(
			@ModelAttribute("product") @Valid Product product,
			BindingResult result
			) 
	{
		List<String> categories = new ArrayList<String>();
		
		categories.add("Electronics");
		categories.add("Clothes");
		categories.add("Shoes");
		categories.add("Mobiles");
		categories.add("Stationary");
		categories.add("Bags");
		categories.add("Books");
		categories.add("Watches");
		
		if( result.hasErrors() )
		{			
			return new ModelAndView("AddProduct", "categories", categories);
		}
		
		try 
		{
			int productId = productService.addProductDetails( product );
			
			Map<String, Object> map = new HashMap<String, Object>();			
			map.put("categories", categories);
			map.put("productId", productId);
			
			return new ModelAndView("AddProduct", map);
		} 
		catch (ProductException e) 
		{
			return new ModelAndView("ErrorPage", "errMsg", e.getMessage() );
		}
	}
	
	@RequestMapping(value="/ProcessGetProduct.obj", method=RequestMethod.POST)
	public String processGetProductForm(
			@RequestParam("productId") int id, 
			Model model)
	{
		try 
		{
			Product product = productService.getProduct( id );
			
			model.addAttribute("product", product);
			return "GetProduct";
		} 
		catch (ProductException e) 
		{
			model.addAttribute("errMsg", e.getMessage());
			return "ErrorPage";
		}
	}
	
	@RequestMapping(value="/ProcessFetchForUpdate.obj", method=RequestMethod.POST)
	public String processFetchForUpdateForm(
			@RequestParam("productId") int id, 
			Model model)
	{
		try 
		{
			Product product = productService.getProduct( id );
			
			List<String> categories = new ArrayList<String>();
			
			categories.add("Electronics");
			categories.add("Clothes");
			categories.add("Shoes");
			categories.add("Mobiles");
			categories.add("Stationary");
			categories.add("Bags");
			categories.add("Books");
			categories.add("Watches");
			
			model.addAttribute("categories", categories);
			
			model.addAttribute("product", product);
			return "UpdateProduct";
		} 
		catch (ProductException e) 
		{
			model.addAttribute("errMsg", e.getMessage());
			return "ErrorPage";
		}
	}
	
	@RequestMapping(value="/ProcessUpdateProduct.obj", method=RequestMethod.POST)
	public String processUpdateForm(
			@ModelAttribute("product") @Valid Product product,
			BindingResult result, 
			Model model) 
	{
		if(result.hasErrors())
		{
			List<String> categories = new ArrayList<String>();
			
			categories.add("Electronics");
			categories.add("Clothes");
			categories.add("Shoes");
			categories.add("Mobiles");
			categories.add("Stationary");
			categories.add("Bags");
			categories.add("Books");
			categories.add("Watches");
			
			model.addAttribute("categories", categories);
			
			return "UpdatePage";
		}
		
		try 
		{
			productService.updateProduct( product );
			
			model.addAttribute("info", "Product Updated Successfully");
			
			return "InformationPage";
		} 
		catch (ProductException e) 
		{
			model.addAttribute("errMsg", e.getMessage());
			return "ErrorPage";
		}
	}
	
	@RequestMapping(value="/ProcessRemoveProduct.obj", method=RequestMethod.POST)
	public String processRemoveProductForm(
			@RequestParam("productId") int id, 
			Model model)
	{
		try 
		{
			Product product = productService.getProduct( id );
			
			productService.removeProduct(product);
			
			model.addAttribute("product", product);
			return "RemoveProduct";
		} 
		catch (ProductException e) 
		{
			model.addAttribute("errMsg", e.getMessage());
			return "ErrorPage";
		}
	}
}























