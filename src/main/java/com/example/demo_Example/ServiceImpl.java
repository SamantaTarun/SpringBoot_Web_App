package com.example.demo_Example;

import org.springframework.util.StringUtils;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements  Service{
    @Override
    public List<String> getAllCountries(int pageNo, int pageSize, String partialName)throws  Exception {
        return Utils.calculateNosPage(pageNo,pageSize,partialName);
    }
    @Override
    public boolean saveCountry(String country) throws Exception {
        boolean isPresent=Countries.getCountries().contains(StringUtils.capitalize( country.toLowerCase()));
        if(isPresent)
            return false;
        Countries.addCountry(StringUtils.capitalize(country.toLowerCase()));
        return true;
    }
}
