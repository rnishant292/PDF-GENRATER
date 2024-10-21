package com.example.pdfgenerator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import com.example.pdfgenerator.controller.PdfController;
import com.example.pdfgenerator.entity.Invoice;
import com.example.pdfgenerator.entity.Item;
import com.example.pdfgenerator.service.PdfGeneratorService;
import com.itextpdf.io.source.ByteArrayOutputStream;

@SpringBootApplication
public class PdfgeneratorApplication implements CommandLineRunner {
     
	@Autowired
	 private  PdfGeneratorService pdfGeneratorService;

	 @Autowired
	 private PdfController pdfController;
	public static void main(String[] args) {
		SpringApplication.run(PdfgeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        Invoice invoice = new Invoice();
        invoice.setSeller("Vikram Traders");
        invoice.setSellerGstin("29A888X2235");
        invoice.setSellerAddress("Mumbai, India");
        invoice.setBuyer("Adventure Tours");
        invoice.setBuyerGstin("77KJ435B67890");
        invoice.setBuyerAddress("Pune, India");

        List<Item> items = new ArrayList<>();

// Item 1
        Item item1 = new Item();
        item1.setName("Mountain Bike");
        item1.setQuantity("5 Nos");
        item1.setRate(25000.00);
        item1.setAmount(125000.00);
        items.add(item1);

// Item 2
        Item item2 = new Item();
        item2.setName("Camping Tent");
        item2.setQuantity("10 Nos");
        item2.setRate(1500.00);
        item2.setAmount(15000.00);
        items.add(item2);

// Item 3
        Item item3 = new Item();
        item3.setName("Hiking Boots");
        item3.setQuantity("15 Nos");
        item3.setRate(2000.00);
        item3.setAmount(30000.00);
        items.add(item3);

// Item 4
        Item item4 = new Item();
        item4.setName("Sleeping Bag");
        item4.setQuantity("8 Nos");
        item4.setRate(3000.00);
        item4.setAmount(24000.00);
        items.add(item4);

// Item 5
        Item item5 = new Item();
        item5.setName("Portable Stove");
        item5.setQuantity("6 Nos");
        item5.setRate(4500.00);
        item5.setAmount(27000.00);
        items.add(item5);

        invoice.setItems(items);


        //ByteArrayOutputStream arrayOutputStream=pdfGeneratorService.generateByteArray(invoice);
        ResponseEntity<byte[]> output=pdfController.generatePdf(invoice);
		System.out.println(output.getStatusCode());
	}

}
