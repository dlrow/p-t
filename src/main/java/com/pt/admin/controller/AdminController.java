package com.pt.admin.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Priyanshu Raj
 * @version 1.0
 * @Purpose
 * @since 2020-05-16
 **/


@Slf4j
@Api(value = "Admin", description = "Admin related apis")
@RestController
@RequestMapping("/pt/admin/")
public class AdminController {
}
