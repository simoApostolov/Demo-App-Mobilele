package bg.softuni.pathfinderDemo.web;

import bg.softuni.pathfinderDemo.model.binding.RouteBindingModel;
import bg.softuni.pathfinderDemo.model.view.RouteViewModel;
import bg.softuni.pathfinderDemo.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;

    public RouteController(RouteService routeService, CurrentUser currentUser) {
        this.routeService = routeService;
        this.currentUser = currentUser;
    }

    @GetMapping("/all")
    public String allRoutes(Model model){

        List<RouteViewModel> routeViewModelList = routeService
                .findAllRoutesViewModels();

        model.addAttribute("routes", routeService.findAllRoutesViewModels());



        return "routes";
    }

    @GetMapping("/details/{id}")
    public String learnMore(@PathVariable Long id, Model model) {

        model.addAttribute("routes",
                routeService.findRouteById(id));

        return "route-details";
    }

    @GetMapping("/add")
    public String add() {

        if (currentUser.getId() == null) {
            return "redirect:/users/login";
        }

        return "add-route";
    }

    @PostMapping("/add")
    public String addRoute(@Valid RouteBindingModel routeBindingModel,
                           RedirectAttributes redirectAttributes,
                           BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("routeBindingModel", routeBindingModel);
            redirectAttributes.addAttribute("org.springframework.validation.BindingResult.routeBindingModel", bindingResult);

            return "redirect:all";
        }

        try {
            routeService.addRoute(routeBindingModel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:all";
    }

    @ModelAttribute
    public RouteBindingModel routeBindingModel() {
            return new RouteBindingModel();
    }

}
