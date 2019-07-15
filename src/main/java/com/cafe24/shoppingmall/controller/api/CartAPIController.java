package com.cafe24.shoppingmall.controller.api;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiOperation;

@RestController("cartAPIController")
@RequestMapping("/api/cart")
public class CartAPIController {
	
	@Autowired
	private CartService cartService;

	@ApiOperation(value = "장바구니담기")
	@RequestMapping(value = "/put", method = RequestMethod.POST)
	public JSONResult put(@RequestBody CartVo cartVo, HttpServletRequest request, HttpServletResponse response,
			@CookieValue(value = "cookieId", defaultValue = "-1") String cookieId) {
		HttpSession session = request.getSession();

		UserVo userVo = null;
		
		if (session != null) {
			userVo = (UserVo) session.getAttribute("authUser");
		}
		
		if (userVo != null) {
			cartVo.setUserId(userVo.getId());
		} else {
			if ("-1".equals(cookieId)) {
				String newCookieId = getGenerateCookieId();
				Cookie newCookie = new Cookie("cookieId", newCookieId);
				newCookie.setMaxAge(60 * 60 * 24 * 7); // 쿠키 유효기간 = 1주일
				response.addCookie(newCookie);
				cartVo.setUserId(newCookieId);
			} else {
				cartVo.setUserId(cookieId);
			}
		}

		boolean putResult = cartService.put(cartVo);
		
		return JSONResult.success(putResult);
	}

	public String getGenerateCookieId() {
		String firstCookieId = UUID.randomUUID().toString();
		String secondCookieId = "" + Calendar.getInstance().getTimeInMillis();
		String completedCookieId = firstCookieId+"-"+secondCookieId;
		return completedCookieId;
	}

	
	@ApiOperation(value = "장바구니목록보기")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JSONResult list(HttpServletRequest request,
			@CookieValue(value = "cookieId", defaultValue = "-1") String cookieId) {
		HttpSession session = request.getSession();
		// session에서 값을 추출하지말고 넘어오는 값으로 사용 ? session의 개념은 프론트엔드에서 생성해서 값을 넘겨줘야한다.
		// Controller부터 페이지까지가 프론트엔드의 범위에 속한다 ?
		
		UserVo userVo = null;

		if (session != null) {
			userVo = (UserVo) session.getAttribute("authUser");
		}
		
		String userId = userVo != null ? userVo.getId() : cookieId;
		
		List<ProductVo> list = cartService.getProductListInCartByUserId(userId);

		return JSONResult.success(list);
	}
}
