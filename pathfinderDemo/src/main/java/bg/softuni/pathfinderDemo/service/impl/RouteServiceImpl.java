package bg.softuni.pathfinderDemo.service.impl;

import bg.softuni.pathfinderDemo.model.binding.RouteBindingModel;
import bg.softuni.pathfinderDemo.model.entity.Route;
import bg.softuni.pathfinderDemo.model.view.RouteDetailsViewModel;
import bg.softuni.pathfinderDemo.model.view.RouteViewModel;
import bg.softuni.pathfinderDemo.repository.CategoryRepository;
import bg.softuni.pathfinderDemo.repository.RouteRepository;
import bg.softuni.pathfinderDemo.service.CategoryService;
import bg.softuni.pathfinderDemo.service.RouteService;
import bg.softuni.pathfinderDemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    private final UserService userService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, CategoryRepository categoryRepository, CategoryService categoryService, UserService userService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public List<RouteViewModel> findAllRoutesViewModels() {
        return routeRepository
                .findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel =
                            modelMapper.map(route, RouteViewModel.class);
                    if (route.getPictures().isEmpty()) {
                        routeViewModel.setPictureUrl("/images/pic4.jpg");
                    } else {
                        routeViewModel.setPictureUrl(route.getPictures().stream()
                                .findFirst().get().getUrl());
                    }
                    return  routeViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean addRoute(RouteBindingModel routeBindingModel) throws IOException {

        Optional<Route> optionalRoute = routeRepository
                .findByName(routeBindingModel.getName());

        if (optionalRoute.isPresent()) {
            return false;
        }

        Route route = modelMapper.map(routeBindingModel, Route.class);
        route.setGpxCoordinates(new String(routeBindingModel
                .getGpxCoordinates().getBytes()));
        route.setAuthor(userService.findCurrentUserId());
        route.setCategories(routeBindingModel.getCategories()
                .stream()
                .map(categoryName -> categoryService.findCategoryByName(categoryName))
                .collect(Collectors.toSet()));

        routeRepository.save(route);

        return true;
    }

    @Override
    public RouteDetailsViewModel findRouteById(Long id) {
        return routeRepository
                .findById(id)
                .map(route -> modelMapper.map(route,RouteDetailsViewModel.class))
                .orElse(null);
    }

}
