package com.exam.boot.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exam.boot.dto.FarmerEntity;
import com.exam.boot.dto.Retailer;

@RestController
@RequestMapping("/farmerController")
public class FarmerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getFarmers")
	public String getFarmers() {
		/*
		 * HttpHeaders headers=new HttpHeaders();
		 * headers.setContentType(MediaType.APPLICATION_JSON); HttpEntity<FarmerEntity>
		 * entity=new HttpEntity<FarmerEntity>(headers); //return restTemplate.exchange(
		 * "http://localhost:8082/api/assistance/farmer/findFarmerList", HttpMethod.GET,
		 * entity, FarmerEntity.class);
		 */		
		return restTemplate.getForObject("http://localhost:8082/api/assistance/farmer/findFarmerList", String.class);
	}
	
	// ********************** get farmer by id **************************** //
		@GetMapping("/getFarmer/{farmerId}")
		public FarmerEntity getFarmer(@PathVariable Long farmerId) {
			return restTemplate.getForObject("http://localhost:8082/api/assistance/farmer/getFarmerById?farmerId="+farmerId , FarmerEntity.class);
		}

		// ********************** add farmer **************************** //
		@PostMapping(value = "/addFarmer")
		public FarmerEntity addFarmer(@RequestBody FarmerEntity farmer) {
			/*
			 * System.out.println(retailer); HttpHeaders headers = new HttpHeaders();
			 * headers.setContentType(MediaType.APPLICATION_JSON); HttpEntity<Retailer>
			 * httpEntity = new HttpEntity<>( headers);
			 */
			return restTemplate.postForObject("http://localhost:8082/api/assistance/farmer/addFarmer", farmer,
					FarmerEntity.class,farmer);
		}

		// ********************** update farmer by id **************************** //
		@PutMapping("/updateFarmer/{id}")
		 public ResponseEntity<FarmerEntity> updateFarmer(@RequestBody FarmerEntity farmer, @PathVariable Long id) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON); 
			HttpEntity<FarmerEntity> httpEntity = new HttpEntity<>(farmer,headers);
		  return restTemplate.exchange("http://localhost:8082/api/assistance/farmer/updateFarmer/"+id, HttpMethod.PUT,httpEntity, FarmerEntity.class,id);
		}
		// ********************** delete farmer by id **************************** //
		@DeleteMapping("/deleteFarmer/{id}")
		public ResponseEntity<String> deleteFarmer(@PathVariable Long id){
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON); 
			HttpEntity<Long> httpEntity = new HttpEntity<>(id,headers);
			return restTemplate.exchange("http://localhost:8082/api/assistance/farmer/deleteFarmer?id="+id ,HttpMethod.DELETE,httpEntity, String.class);
		}

}
