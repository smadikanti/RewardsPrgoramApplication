package com.jayasree.rewardsprogram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jayasree.rewardsprogram.dto.RewardsRequest;
import com.jayasree.rewardsprogram.repos.TransactionRepository;
import com.jayasree.rewardsprogram.services.CustomerTransactionService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@CrossOrigin
public class CustomerController {
	@Autowired
	CustomerTransactionService customerTransactionService;

	@Autowired
	TransactionRepository transactionRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@RequestMapping("/rewardsPage")
	public String showRewardsPage() {
		LOGGER.info("Inside showRewardsPage()");
		return "rewardsProgram";
	}

	@RequestMapping(value = "/calculateRewards", method = RequestMethod.POST)
	public String calculateRewards(RewardsRequest request, ModelMap modelMap) {
		LOGGER.info("Inside calculateRewards() For:" + request.getCustomerId());
		customerTransactionService.calculateRewards(request);
		return "/success";
	}

	@RequestMapping(value = "/showRewards", method = RequestMethod.GET)
	public String generateCustomerRewardPoints(ModelMap modelMap) {
		LOGGER.info("Inside generateCustomerRewardPoints()");
		List<Object[]> customerRewardsReport = transactionRepository.rewardsPointsPerMonth();
		List<Object[]> totalRewardsPoints = transactionRepository.totalRewardsPoints();
		modelMap.addAttribute("customerRewardsReport", customerRewardsReport);
		modelMap.addAttribute("totalRewardsPoints", totalRewardsPoints);
		return "displayRewards";

	}

}
