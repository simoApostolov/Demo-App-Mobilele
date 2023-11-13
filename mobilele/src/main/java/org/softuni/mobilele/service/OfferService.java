package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.CreateOfferDTO;
import org.softuni.mobilele.model.dto.OfferSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface OfferService {

    Long createOffer(CreateOfferDTO createOfferDTO);

    Page<OfferSummaryDTO> getAllOffers(Pageable pageable);
}
