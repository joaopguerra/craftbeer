package com.beerhouse.controller;

import com.beerhouse.model.dto.BeerRequest;
import com.beerhouse.model.dto.BeerResponse;
import com.beerhouse.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/beers")
public class BeerController {

    @Autowired
    public BeerService beerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BeerResponse> findAll(){
        return beerService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BeerResponse findById(@PathVariable Long id){
        return beerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody BeerRequest beerRequest, HttpServletResponse response){
        BeerResponse beerResponse = beerService.insert(beerRequest);
        String uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(beerResponse.getId())
                .toUriString();
        response.addHeader("location", uri);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody BeerRequest beerRequest){
        beerService.update(id, beerRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        beerService.delete(id);
    }
}
