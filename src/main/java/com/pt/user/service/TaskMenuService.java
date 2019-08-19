package com.pt.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.user.config.DbChannel;
import com.pt.user.dto.TaskMenuDTO;
import com.pt.user.model.TaskMenu;
import com.pt.user.repository.TaskMenuRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskMenuService {

	@Autowired
	DbChannel dbChannel;

	@Autowired
	TaskMenuRepository tmRepository;

	public void addTaskMenu(TaskMenuDTO tmDTO) {
		log.info("TaskMenuService : addTaskMenu");
		TaskMenu tm = new TaskMenu();
		tm.setTask(tmDTO.getTask());
		tm.setDescription(tmDTO.getDescription());
		tm.setTaskImage(tmDTO.getTaskImage());
		tmRepository.save(tm);
	}

	public List<TaskMenu> getTaskMenu() {
		List<TaskMenu> tms = tmRepository.findAll();
		return tms;
	}

}
