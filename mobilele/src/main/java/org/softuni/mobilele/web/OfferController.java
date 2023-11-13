package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.dto.OfferDetailDTO;
import org.softuni.mobilele.model.entity.enums.Engine;
import org.softuni.mobilele.service.BrandService;
import org.softuni.mobilele.service.OfferService;
import org.softuni.mobilele.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;


    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("engines")
    public Engine[] engines() {
        return Engine.values();
    }

    @ModelAttribute("brands")
    public List<BrandDTO> brand() {
        return brandService.getAllBrands();
    }

    @GetMapping("/add")
    public String add() {

//        if (!model.containsAttribute("createOfferDTO")) {
//            model.addAttribute("createOfferDTO", CreateOfferDTO.empty());
//        }
//
//        model.addAttribute("brands", brandService.getAllBrands());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(
            @Valid CreateOfferDTO createOfferDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("createOfferDTO", createOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return "redirect:/offer/add";
        }

        Long id = offerService.createOffer(createOfferDTO);


        return "redirect:/offer/" + id;
    }

    @GetMapping("/{id}")
    public String details(@PathVariable("id") Long id, Model model) {

        OfferDetailDTO offerDetailDTO = offerService
                .getOfferDetail(id)
                .orElseThrow(() -> new ObjectNotFoundException("Offer with id " + id + " not found"));

        model.addAttribute("offer", offerDetailDTO);

        return "details";
    }
    @ModelAttribute
    public CreateOfferDTO initCreateOfferDTO() {
        return new CreateOfferDTO();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }
}
