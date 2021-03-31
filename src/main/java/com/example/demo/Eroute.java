package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class Eroute {
    private Object result;

    @RequestMapping("/data")
        public Object getBiller(@RequestParam("input") String input){
        List<Eroute> billers=new ArrayList<Eroute>();
        final String url="http://103.210.73.96:8080/bbps/bbps/getBillers?agentID=AGT05082020064F67";
        RestTemplate restTemplate = new RestTemplate();
        List<HashMap> response=new ArrayList<>();
        HashMap result = restTemplate.postForObject(url, null, HashMap.class);
        List<HashMap> resultObj= (List<HashMap>) result.get("resultObj");
        for(HashMap map:resultObj){
            System.out.println(map.getClass());
            List<HashMap> map2= (List<HashMap>) map.get("Biller");
            for(HashMap map1:map2){
            if (String.valueOf(map1.get("BlrName")).startsWith(input)){
             response.add(map);
            }
        }}
        return response;
    }
}
