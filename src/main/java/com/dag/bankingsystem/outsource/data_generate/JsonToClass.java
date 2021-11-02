package com.dag.bankingsystem.outsource.data_generate;

import com.dag.bankingsystem.outsource.model.Currency;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class JsonToClass {

    @SneakyThrows
    public List<Currency> parseJson(){
        List<Currency> currencies =new ArrayList<>();
        String dir = System.getProperty("user.dir")+"/src/main/java/com/dag/bankingsystem/outsource/data_generate/";
        File myObj = new File(dir+"Currencies.txt");
        Scanner myReader = new Scanner(myObj);
        String data="";
        while (myReader.hasNextLine()) {
            data += myReader.nextLine();
        }
        myReader.close();
        JSONArray jsonarray = new JSONArray(data);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            Currency currency = Currency.builder()
                    .name(jsonobject.getString("name"))
                    .symbol(jsonobject.getString("symbol"))
                    .build();
            currencies.add(currency);
        }

        return currencies;
    }

}
