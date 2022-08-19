package nc.apps.controllers.web;

import nc.apps.model.Group;
import nc.apps.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping(path = "/viewAll")
    public ModelAndView viewAll() {
        return new ModelAndView("view_groups");
    }

    @GetMapping(path = "/new")
    public ModelAndView add() {
        Group group = new Group();
        group.setSpecId(0L);
        return new ModelAndView("edit_group", "group", group);
    }

    @GetMapping(path = "/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") String idPath) {
        Group group = groupService.get(Long.parseLong(idPath));

        if (group == null) throw new GroupNotFoundException(idPath);

        return new ModelAndView("edit_group", "group",group);
    }

}