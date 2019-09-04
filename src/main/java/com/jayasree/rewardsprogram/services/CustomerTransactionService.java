package com.jayasree.rewardsprogram.services;


import com.jayasree.rewardsprogram.dto.RewardsRequest;
import com.jayasree.rewardsprogram.entities.CustomerTransaction;

public interface CustomerTransactionService {

	public CustomerTransaction calculateRewards(RewardsRequest rewardsRequest);

	
}
