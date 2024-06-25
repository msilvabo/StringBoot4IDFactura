package com.moises.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.moises.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.moises.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value="classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean("default")
    List<Item> itemsInvoice(){
        Product p1 = new Product("Camara Sony", 100);
        Product p2 = new Product("TV Samsung", 350);
        Product p3 = new Product("Bicicleta", 150);
        
        return Arrays.asList(new Item(p1,2),new Item(p2,5),new Item(p3,10));
    }
    
    @Bean
    @Primary
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("monitor Asus", 300);
        Product p2 = new Product("noteBook", 1150);

        return Arrays.asList(new Item(p1,4),new Item(p2,6));
    }
}
