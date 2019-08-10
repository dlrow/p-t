package com.pt.user.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pt.user.model.TaskMenu;

@Configuration
public interface TaskMenuRepository extends MongoRepository<TaskMenu, String> {


}