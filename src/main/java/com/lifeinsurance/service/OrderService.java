package com.lifeinsurance.service;

import com.lifeinsurance.exception.NotFoundException;

public interface OrderService {

	int add(int userId) throws NotFoundException;

}
