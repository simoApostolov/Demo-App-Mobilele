package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.dto.OfferDetailDTO;
import org.softuni.mobilele.model.dto.OfferSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface OfferService {

    Long createOffer(CreateOfferDTO createOfferDTO);

    Page<OfferSummaryDTO> getAllOffers(Pageable pageable);

    Optional<OfferDetailDTO> getOfferDetail(Long id);
    void deleteOffer(Long id);
}
