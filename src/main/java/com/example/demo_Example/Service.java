package com.example.demo_Example;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Service  {

    public List<String> getAllCountries(int pageNo, int pageSize, String partialName) throws Exception;
    public boolean saveCountry(String country) throws  Exception;
}
