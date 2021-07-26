package com.exam.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exam.boot.dto.Retailer;

@RestController
@RequestMapping("/farmingAssist")
public class RetailerController {

	@Autowired
	private RestTemplate restTemplate;

	// ********************** get all retailer **************************** //
	@GetMapping("/getRetailers")
	public String getRetailers() {
		return restTemplate.getForObject("http://localhost:8085/api/assistance/retailer", String.class);
	}

	// ********************** get retailer by id **************************** //
	@GetMapping("getRetailer/{retailerId}")
	public Retailer getRetailer(@PathVariable int retailerId) {
		return restTemplate.getForObject("http://localhost:8085/api/assistance/retailer/" + retailerId, Retailer.class);
	}

	// ********************** add retailer **************************** //
	@PostMapping(value = "/addRetailer")
	public Retailer addRetailer(@RequestBody Retailer retailer) {
		/*
		 * System.out.println(retailer); HttpHeaders headers = new HttpHeaders();
		 * headers.setContentType(MediaType.APPLICATION_JSON); HttpEntity<Retailer>
		 * httpEntity = new HttpEntity<>( headers);
		 */
		return restTemplate.postForObject("http://localhost:8085/api/assistance/retailer/addRetailer/", retailer,
				Retailer.class);
	}

	// ********************** update retailer by id **************************** //
	@PutMapping("/updateRetailer/{retailerId}")
	 public ResponseEntity<Retailer> updateRetailer(@RequestBody Retailer retailer, @PathVariable int retailerId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); 
		HttpEntity<Retailer> httpEntity = new HttpEntity<>( retailer,headers);
	  return restTemplate.exchange("http://localhost:8085/api/assistance/retailer/"+retailerId, HttpMethod.PUT,httpEntity, Retailer.class);
	}
	
	@DeleteMapping("/{retailerId}")
	public ResponseEntity<String> deleteFarmer(@PathVariable int retailerId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); 
		HttpEntity<Retailer> httpEntity = new HttpEntity<>( headers);
		return restTemplate.exchange("http://localhost:8085/api/assistance/retailer/"+retailerId, HttpMethod.DELETE, httpEntity, String.class);
	}
	
	
}
