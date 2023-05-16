package ar.com.redlink.controllers.interfaces;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(
tags="Gender's Controller",
description = "Controller to manage requests and responses about Genres.")
@RequestMapping("/api/v1/gender")
public interface IGenderController extends IRestController{

}
