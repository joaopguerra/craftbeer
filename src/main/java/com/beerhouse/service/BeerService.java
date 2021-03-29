package com.beerhouse.service;

import com.beerhouse.exception.NotFoundException;
import com.beerhouse.model.dto.BeerRequest;
import com.beerhouse.model.dto.BeerResponse;
import com.beerhouse.model.entity.Beer;
import com.beerhouse.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public List<BeerResponse> findAll() {
        return beerRepository.findAll()
                .stream()
                .map(BeerResponse::valueOf)
                .collect(Collectors.toList());
    }

    public BeerResponse findById(Long id){
        return beerRepository.findById(id)
                .map(BeerResponse::valueOf)
                .orElseThrow(NotFoundException::new);
    }

    public BeerResponse insert(BeerRequest beerRequest){
        Beer newBeer = beerRepository.save(Beer.valueOf(beerRequest));
        return new BeerResponse(newBeer.getId());
    }

    public void update(Long id, BeerRequest beerRequest) {
        Beer beer = beerRepository.findById(id).orElseThrow(NotFoundException::new);
        updateData(beer, beerRequest);

        beerRepository.save(beer);
    }

    public void delete(Long id){
        beerRepository.findById(id).ifPresent(beer -> beerRepository.deleteById(beer.getId()));
    }

    public void updateData(Beer beer, BeerRequest beerRequest){
        beer.setName(beerRequest.getName());
        beer.setIngredients(beerRequest.getIngredients());
        beer.setAlcoholContent(beerRequest.getAlcoholContent());
        beer.setPrice(beerRequest.getPrice());
        beer.setCategory(beerRequest.getCategory());

    }
}
