package ar.com.redlink.controllers.interfaces;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags="User Type Id's Controller",
        description = "Controller to manage requests and responses about User types ids.")
@RequestMapping("/api/v1/user-type-id")
public interface IUserTypeIdController extends IRestController {
}
