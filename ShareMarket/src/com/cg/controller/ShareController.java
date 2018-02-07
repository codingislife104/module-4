package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bean.OrderBean;
import com.cg.bean.StockBean;
import com.cg.exception.ShareException;
import com.cg.service.IOrderService;
import com.cg.service.IServiceStock;

@Controller
public class ShareController {

	@Autowired
	private IServiceStock serviceStock;

	@Autowired
	private IOrderService serviceOrder;

	@RequestMapping("/showHome")
	public ModelAndView showHomePage(@ModelAttribute("stock") StockBean bean,
			BindingResult result) {

		ModelAndView mv = new ModelAndView();

		if (result.hasErrors()) {
			mv.setViewName("index");
			mv.addObject("message", "Binding Failed");
		} else {
			try {
				List<StockBean> list = serviceStock.retrieveAllStocks();
				mv.setViewName("index");
				mv.addObject("list", list);
			} catch (ShareException e) {
				mv.setViewName("error");
				mv.addObject("message", e.getMessage());
			}

		}
		return mv;

	}

	@RequestMapping("order")
	public ModelAndView OrderPage(@ModelAttribute("stock") StockBean bean,
			BindingResult result) {
		ModelAndView mv = new ModelAndView();

		try {
			StockBean tbean = serviceStock.displayStock(bean.getStockName());

			mv.setViewName("display");
			mv.addObject("stock", tbean);
		} catch (ShareException e) {
			mv.setViewName("error");
			mv.addObject("message", e.getMessage());
		}

		return (mv);
	}

	@RequestMapping(value = "/orderConfirm")
	public ModelAndView orderConfirm(
			@RequestParam("selectAction") String selectAction,
			@RequestParam("quantity") int quantity,
			@RequestParam("quote") double quote,
			@ModelAttribute("oBean") OrderBean oBean,
			@ModelAttribute("stock") StockBean sBean) {

		ModelAndView mv = new ModelAndView();
		if (selectAction.equals("Buy")) {
			double orderAmount = quantity * quote;
			double commission = 0.005 * orderAmount;
			try {
				/* OrderBean oBean = new OrderBean(); */

				oBean.setOrderAmount(orderAmount);
				oBean.setCommission(commission);

				int orderId = serviceOrder.addOrder(oBean);

				mv.addObject("orderId", orderId);
				mv.addObject("orderAmount", orderAmount);
				mv.addObject("commission", commission);
				mv.addObject("oBean", oBean);
				mv.setViewName("summary");
			} catch (ShareException e) {
				mv.setViewName("error");
				mv.addObject("message", e.getMessage());
			}

		} else {
			double orderAmount = quantity * quote;
			double commission = 0.01 * orderAmount;
			try {
				/* OrderBean oBean = new OrderBean(); */

				oBean.setOrderAmount(orderAmount);
				oBean.setCommission(commission);

				int orderId = serviceOrder.addOrder(oBean);

				mv.addObject("orderId", orderId);
				mv.addObject("orderAmount", orderAmount);
				mv.addObject("commission", commission);
				mv.addObject("oBean", oBean);
				mv.setViewName("summary");
			} catch (ShareException e) {
				mv.setViewName("error");
				mv.addObject("message", e.getMessage());

			}
		}

		return mv;
	}

}
