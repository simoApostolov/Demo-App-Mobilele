package bg.softuni.pathfinderDemo.service;

import bg.softuni.pathfinderDemo.model.binding.RouteBindingModel;
import bg.softuni.pathfinderDemo.model.view.RouteDetailsViewModel;
import bg.softuni.pathfinderDemo.model.view.RouteViewModel;

import java.io.IOException;
import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesViewModels();

    boolean addRoute(RouteBindingModel routeBindingModel) throws IOException;

    RouteDetailsViewModel findRouteById(Long id);
}
