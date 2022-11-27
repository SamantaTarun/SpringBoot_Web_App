package com.example.demo_Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class Controller {
    @Autowired
    private Service service;
    @GetMapping("/countries")
    public ResponseEntity<Object> getAllCountries(
            @RequestParam(value="pageNo", defaultValue ="0", required = false) int pageNo,
            @RequestParam(value="pageSize", defaultValue ="0" ,required = false) int pageSize,
            @RequestParam(value = "partialName", required = false) String partialName
    ){
        try{
            if(service.getAllCountries(pageNo,pageSize,partialName).isEmpty())
                return ResponseHandler.generateResponse("please provide valid input for pagination or searchbyPartialName!", HttpStatus.MULTI_STATUS, service.getAllCountries(pageNo,pageSize,partialName));
            return ResponseHandler.generateResponse("fetched all countries!", HttpStatus.OK, service.getAllCountries(pageNo,pageSize,partialName));
        }
        catch (Exception e){
           return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
    @PostMapping("/save")
    public ResponseEntity<Object> saveCountry(@RequestParam(name="country") String country){
       try{
           if(service.saveCountry(country))
               return ResponseHandler.generateResponse("Save Country successfully!", HttpStatus.CREATED, Countries.getCountries());
           else
               return ResponseHandler.generateResponse("Country Already Exist!", HttpStatus.resolve(403), null);
       }
       catch (Exception e){
           return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
       }

    }

}
