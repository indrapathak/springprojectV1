package com.SpringBootJavaProject.LearningProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootJavaProject.LearningProject.InputParameters;
import com.SpringBootJavaProject.LearningProject.model.NodeData;
import com.SpringBootJavaProject.LearningProject.service.NodeService;

@RestController
public class NodeDataController {

	@Autowired
	public NodeService nodeDataService;

	@CrossOrigin(origins = "https://springnewap.herokuapp.com/")

	@GetMapping("/")
	public String appStart() {

		return "WELCOME TO THE NEW SPRING BOOT APP";
	}

	// Taking Input from url of the request
	@GetMapping("/getByNodeId/{nodeId}")
	public List<NodeData> getDataByNodeId(@PathVariable("nodeId") String nodeId) {
		List<NodeData> data = nodeDataService.getListByNodeId(nodeId);
		System.out.print("The data that is recieved from the query is " + data);

		return data;

	}

	@GetMapping("/getAllData")
	public List<NodeData> getAll() {

		List<NodeData> data = nodeDataService.getAll();
		return data;
	}

	// API For returning the list of of Data For a Single NodeId
	@RequestMapping(path = "/getByBodyParamsPojo2", method = RequestMethod.GET)
	public List<NodeData> getDataValuesList(@RequestBody InputParameters inputParams) {

		String nodeId = inputParams.getNodeIdValue();
		List<NodeData> data = nodeDataService.getListByNodeId(nodeId);
		return data;
	}

	@RequestMapping(path = "/QueryObjectAPI", method = RequestMethod.GET)
	public List<NodeData> getDataValuesListByQuery(@RequestBody InputParameters inputParams) {

		String nodeId = inputParams.getNodeIdValue();
		List<NodeData> data = nodeDataService.getListByNodeIdUsingSpringData(nodeId);
		return data;
	}

//	// Aggregattion API of getting Details  NOT WORKING NEED TO BE CHANGED
//	@RequestMapping(path = "/AggregatedData", method = RequestMethod.GET)
//	public List<NodeData> getAggregatedData(@RequestBody InputParameters inputParams) {
//
//		String nodeId = inputParams.getNodeIdValue();
//		List<NodeData> data = nodeDataService.getAggregatedDataValues(nodeId);
//
//
//		return data;
//	}

	@PostMapping("/addNewData")
	@ResponseStatus(HttpStatus.CREATED)
	public NodeData addNewData(@RequestBody NodeData dataValues) {

		return nodeDataService.addNew(dataValues);
	}

}
