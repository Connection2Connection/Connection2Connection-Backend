package pe.edu.upc.connection2connection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.connection2connection.services.IUsuarioService;
import pe.edu.upc.connection2connection.entities.Role;
import pe.edu.upc.connection2connection.services.IRoleService;


@RestController
@SessionAttributes
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IUsuarioService uService;
    @Autowired
    private IRoleService rS;

    @GetMapping("/new")
    public String newRole(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("listaUsuarios", uService.list());
        return "role/role";
    }

    @PostMapping("/save")
    public String saveRole(@Validated Role role, BindingResult result, Model model, SessionStatus status) throws Exception {
        if (result.hasErrors()) {
            return "role/role";
        } else {
            rS.insert(role);
            model.addAttribute("mensaje", "Se guardó correctamente");
            status.setComplete();
        }
        model.addAttribute("listaRoles", rS.list());

        return "role/role";

    }

    @GetMapping("/list")
    public String listRole(Model model) {
        try {
            model.addAttribute("role", new Role());
            model.addAttribute("listaRoles", rS.list());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "role/listRole";
    }
}

