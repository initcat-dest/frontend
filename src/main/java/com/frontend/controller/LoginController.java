package com.frontend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.frontend.common.Constant;
import com.frontend.model.LoginRequest;
import com.frontend.model.LoginResponse;
import com.frontend.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * class description
 *
 * @author libo
 * @package com.frontend.controller
 * @company xmiles
 * @date 2019/3/9
 */
@Controller
@RequestMapping(path = "/login")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

	@GetMapping(value = "/loginView")
	public String loginView() {
		logger.info(" access loginView");
		return "fore_jsp/UserLogin";
	}

	@ResponseBody
	@PostMapping(value = "/doLogin", consumes = "application/json")
	public String doLogin(@RequestBody LoginRequest loginRequest) {

		logger.info(" access doLogin");
		JSONObject json = new JSONObject();
		json.put("userNumber", loginRequest.getUserNumber());
		json.put("passward", loginRequest.getPassward());
		json.put("userType", loginRequest.getUserType());
		JSONObject jsonObject = HttpClientUtils.httpPost(
				Constant.HTTP_USER_LOCAL_PREFIX + "/user/login",
				json.toJSONString());
		logger.info(" doLogin result:" + jsonObject);
		// 将登录信息存储到session
		LoginResponse response = new LoginResponse();
		response.setLoginStatus(true);
		response.setMsg("登录成功");
		return JSON.toJSONString(response);
	}

}
