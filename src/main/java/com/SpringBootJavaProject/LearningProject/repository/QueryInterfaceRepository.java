package com.SpringBootJavaProject.LearningProject.repository;

import java.util.List;

import com.SpringBootJavaProject.LearningProject.model.NodeData;

public interface QueryInterfaceRepository {

	List<NodeData> findByQueryObject(String nodeId);

	// List<NodeData> AggregationQuery(String nodeId);

}
