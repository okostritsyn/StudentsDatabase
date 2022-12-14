package ok.apps.controllers.web;

import ok.apps.model.Specialization;
import ok.apps.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/spec")
public class SpecController {
    @Autowired
    private SpecService specService;

    @GetMapping(path = "/viewAll")
    public ModelAndView viewAll() {
        return new ModelAndView("view_spec");
    }

    @GetMapping(path = "/new")
    public ModelAndView add() {
        Specialization spec = new Specialization();
        spec.setParentId(0L);
        return new ModelAndView("edit_spec", "spec", spec);
    }

    @GetMapping(path = "/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") String idPath) {
        Specialization spec = specService.get(Long.parseLong(idPath));
        return new ModelAndView("edit_spec", "spec",spec);
    }
}