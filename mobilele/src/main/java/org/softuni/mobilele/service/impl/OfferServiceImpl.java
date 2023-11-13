package org.softuni.mobilele.service.impl;

import jakarta.transaction.Transactional;
import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.dto.OfferDetailDTO;
import org.softuni.mobilele.model.dto.OfferSummaryDTO;
import org.softuni.mobilele.model.entity.Model;
import org.softuni.mobilele.model.entity.Offer;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.service.OfferService;
import org.softuni.mobilele.service.exception.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository) {

        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public Long createOffer(CreateOfferDTO createOfferDTO) {

        Offer newOffer = map(createOfferDTO);
        Model model =modelRepository.findById(createOfferDTO.getModelId()).orElseThrow(null);

        newOffer.setModel(model);
        newOffer = offerRepository.save(newOffer);

        return newOffer.getId();

    }

    @Override
    public Page<OfferSummaryDTO> getAllOffers(Pageable pageable) {
        return offerRepository
                .findAll(pageable)
                .map(OfferServiceImpl::mapAsSummary);
    }

    @Override
    public Optional<OfferDetailDTO> getOfferDetail(Long id) {
        return offerRepository.findById(id)
                .map(OfferServiceImpl::mapAsDetails);

    }

    @Override
    @Transactional
    public void deleteOffer(Long id) {
        offerRepository.deleteOfferById(id);
    }

    private static OfferDetailDTO mapAsDetails(Offer offer) {

        OfferDetailDTO newOfferSummary = new OfferDetailDTO();

        newOfferSummary.setId(offer.getId());
        newOfferSummary.setBrand(offer.getModel().getBrand().getName());
        newOfferSummary.setModel(offer.getModel().getName());
        newOfferSummary.setYear(offer.getYear());
        newOfferSummary.setMileage(offer.getMileage());
        newOfferSummary.setPrice(offer.getPrice());
        newOfferSummary.setEngine(offer.getEngine());
        newOfferSummary.setTransmission(offer.getTransmission());
        newOfferSummary.setImageUrl(offer.getImageUrl());

        return newOfferSummary;
    }
    private static OfferSummaryDTO mapAsSummary(Offer offer) {

        OfferSummaryDTO newOfferSummary = new OfferSummaryDTO();

        newOfferSummary.setId(offer.getId());
        newOfferSummary.setBrand(offer.getModel().getBrand().getName());
        newOfferSummary.setModel(offer.getModel().getName());
        newOfferSummary.setYear(offer.getYear());
        newOfferSummary.setMileage(offer.getMileage());
        newOfferSummary.setPrice(offer.getPrice());
        newOfferSummary.setEngine(offer.getEngine());
        newOfferSummary.setTransmission(offer.getTransmission());
        newOfferSummary.setImageUrl(offer.getImageUrl());

        return newOfferSummary;
    }

    private static Offer map(CreateOfferDTO createOfferDTO) {
        Offer offer = new Offer();
                offer.setEngine(createOfferDTO.getEngine());
                offer.setDescription(createOfferDTO.getDescription());
                offer.setTransmission(createOfferDTO.getTransmission());
                offer.setImageUrl(createOfferDTO.getImageUrl());
                offer.setMileage(createOfferDTO.getMileage());
                offer.setPrice(createOfferDTO.getPrice());
                offer.setYear(createOfferDTO.getYear());

        return offer;
    }
}


