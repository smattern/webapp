package com.smattern.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author smattern
 */
@Controller
public class IndexResource {

    /**
     * This method is returning the index page.
     *
     * @return index identifier
     */
    @RequestMapping("/home")
    public String home() {
        return "index";
    }
}
