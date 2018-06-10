package com.rest.client;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ClientConsumer {

	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value="")
	public String indexPage() {
		return "index";
	}
	@RequestMapping(value="/welcomeProduct")
	public String welcome(Model model) {

		String url = "http://localhost:8006/api/listProducts";
		List<LinkedHashMap> products = restTemplate.getForObject(url, List.class);
		model.addAttribute("products", products);
		return "listProduct";
	}

	@RequestMapping(value="/welcomePerson")
	public String showPersons(Model model) {
		String url = "http://localhost:8006/api/listPersons";
		List<LinkedHashMap> persons = restTemplate.getForObject(url, List.class);
		model.addAttribute("persons", persons);
		return "listPerson";
	}





}
