package com.driver.services;


import com.driver.EntryDto.ProductionHouseEntryDto;
import com.driver.model.ProductionHouse;
import com.driver.model.WebSeries;
import com.driver.repository.ProductionHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductionHouseService {

    @Autowired
    ProductionHouseRepository productionHouseRepository;

    public Integer addProductionHouseToDb(ProductionHouseEntryDto productionHouseEntryDto){
        ProductionHouse productionHouse = new ProductionHouse();

        productionHouse.setName(productionHouseEntryDto.getName());
        productionHouse.setRatings(0);

        List<WebSeries> list = new ArrayList<>();
        productionHouse.setWebSeriesList(list);
        return  productionHouseRepository.save(productionHouse).getId();
    }



}
