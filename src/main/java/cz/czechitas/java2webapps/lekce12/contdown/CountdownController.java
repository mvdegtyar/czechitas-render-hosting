package cz.czechitas.java2webapps.lekce12.contdown;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Odpočet do Vánoc.
 */
@Controller
public class CountdownController {

    private final CountdownService service;

    public CountdownController(CountdownService service) {
        this.service = service;
    }


    @GetMapping
    public ModelAndView christmas() {
        return new ModelAndView("index")
                .addObject("christmas", service.daysToChristmas());
    }
}
