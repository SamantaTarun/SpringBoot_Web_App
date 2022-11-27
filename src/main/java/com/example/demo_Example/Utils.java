package com.example.demo_Example;
import java.util.ArrayList;
import java.util.List;
public  class Utils {
    public static List<String> calculateNosPage(int pageNo, int pageSize,String prefix){
        //these are default values for pageno and size please dont provide these through api call
        if(pageNo==0 && pageSize==0){
            pageNo=1;
            pageSize=Countries.getSize();
        }
        List<String> list=new ArrayList<String>();
        if(prefix!=null){
            for(String country: Countries.getCountries()){
                if(country.trim().toLowerCase().startsWith(prefix.toLowerCase())){
                    list.add(country);
                }
            }
        }
        if(prefix==null){
            list.addAll(Countries.getCountries());
        }
        int startIdx=(pageNo-1) * pageSize;
        int endIdx=startIdx+pageSize;
        if(startIdx>=list.size())
            return new ArrayList<String>();
        if(list.size()<=endIdx)
            return list.subList(startIdx, list.size());
        return list.subList(startIdx,endIdx);
    }

}