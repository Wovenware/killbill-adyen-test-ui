package com.wovenware.adyentestui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntryController {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}
