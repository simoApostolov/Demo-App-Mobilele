package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.OfferSummaryDTO;
import org.softuni.mobilele.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;

    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }
    @GetMapping("/all")
    public String allOffers(Model model,
                            @PageableDefault(
                  size = 5,
                  sort = "id"
          ) Pageable pageable) {

        Page<OfferSummaryDTO> allSummaryOffers = offerService.getAllOffers(pageable);

        model.addAttribute("offers",allSummaryOffers);

        return "offers";
    }

//    @GetMapping("/add")
//    public String add() {
//        return "offer-add";
//    }
//
//    @PostMapping
//    public String add(CreateOfferDTO createOfferDTO) {
//        offerService.createOffer(createOfferDTO);
//
//        return "index";
//    }
    @GetMapping("/{id}/details")
    public String details(@PathVariable ("id") Long id) {
        return "details";
    }
}
