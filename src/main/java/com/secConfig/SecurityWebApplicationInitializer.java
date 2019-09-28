//package com.config;
package com.secConfig;

import org.springframework.security.web.context.*;
import org.springframework.core.annotation.Order;
//import com.config.SecurityConfig;
//import com.secConfig.*;

@Order(value = 2)
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
       super(SecurityConfig.class);}
}
