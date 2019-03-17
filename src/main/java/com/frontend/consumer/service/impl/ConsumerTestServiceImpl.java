package com.frontend.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.frontend.consumer.service.ConsumerTestService;
import org.springframework.stereotype.Service;

/**
 * class description
 *
 * @author libo
 * @package com.frontend.consumer.service.impl
 * @company xmiles
 * @date 2019/3/12
 */
@Service
public class ConsumerTestServiceImpl implements ConsumerTestService {

	@Reference


	@Override
	public String consumerTest() {
		return null;
	}
}
