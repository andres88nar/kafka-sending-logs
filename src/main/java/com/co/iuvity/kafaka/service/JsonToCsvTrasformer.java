package com.co.iuvity.kafaka.service;

import com.co.iuvity.kafaka.model.Kardex;
import com.co.iuvity.kafaka.producers.CsvProducer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

import static com.co.iuvity.kafaka.constan.Consntans.CSV_PATH;
import static com.co.iuvity.kafaka.constan.Consntans.HEADERS;
import static com.co.iuvity.kafaka.constan.Consntans.REPLACE;
import static com.co.iuvity.kafaka.constan.Consntans.COMPRA;
import static com.co.iuvity.kafaka.constan.Consntans.VENTA;



public class JsonToCsvTrasformer {
	
	private Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
	private StringBuilder data = new StringBuilder(HEADERS);
	
	public void jsonToCsv (String key, String value) {		
		Kardex kardex = gson.fromJson(value, Kardex.class);				
		kardex.getKardex().forEach(product -> {
			product.getIngresos().forEach(ingreso -> {				
				data.append(product.getId()+","+product.getName()+","+product.getInventario()+","+COMPRA+","+ingreso.getId()+","+ingreso.getDate().replace(",", " -")+","+ingreso.getProduct().getId() +","+ingreso.getProduct().getName()+","+ingreso.getAmount()+","+ingreso.getPurchasePrice()+"\n");				
			});		
			product.getEgresos().forEach(egreso -> {				
				data.append(product.getId()+","+product.getName()+","+product.getInventario()+","+VENTA+","+egreso.getId()+","+egreso.getDate().replace(",", " -")+","+egreso.getProduct().getId() +","+egreso.getProduct().getName()+","+egreso.getAmount()+","+egreso.getSalePrice()+"\n");				
			});			
		});		
		
		new CsvProducer().produceCsv(key,data.toString());
		
		//createFileCSV(key, data.toString() );
	}
	
	
	
    public void createFileCSV (String name, String data) {		
    	try (FileWriter writer = new FileWriter(CSV_PATH.replace(REPLACE, name))) {
            writer.write(data);            
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}
	
}
