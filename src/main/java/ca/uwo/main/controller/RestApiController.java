package ca.uwo.main.controller;

import org.json.simple.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
	
	@RequestMapping("/robot")
	public String getRobotData() {
		JSONObject data = new JSONObject();
		
		data.put("id", 123);
		data.put("temperature", 60);
		data.put("vibration", 20);
		data.put("torque", 100);
		
		return data.toJSONString();
	}
	
	@RequestMapping("/controller")
	public String getControllerData() {
		JSONObject data = new JSONObject();
		
		data.put("control_signal", 30);
		
		return data.toJSONString();
	}
	
	@RequestMapping("/condition")
	public boolean evaluateCondition(@RequestParam("temperature") int temperature, 
									@RequestParam("vibration") int vibration,
									@RequestParam("torque") int torque,
									@RequestParam("control_signal") int control_signal) {
		
		//Call to Mario's code
		
		return Math.random() < 0.5;
	}
	
	@RequestMapping("/action")
	public String evaluateAction(@RequestParam("condition") boolean condition, 
								 @RequestParam("id") int id) {
		
		if (condition) {
		//Call to Hao's code
		}
		
		return "A1 A2 A3";
	}
}
