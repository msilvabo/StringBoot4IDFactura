package com.moises.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
@JsonIgnoreProperties({"targetSource","advisors"})
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description.office}")    
    private String description;

    @Autowired
    // @Qualifier("itemsInvoiceOffice")
    private List<Item> items;
 
    public Invoice(){
        System.out.println("creando el componente de la factura -INVOICE");
        System.out.println(client);
        System.out.println(description);
    }

    @PostConstruct
    public void iniciar(){
        System.out.println("creando el componente de la factura -INIT");
        client.setName(client.getName().concat("-Pepe"));
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ").concat(client.getLast());
        System.out.println(client);
        System.out.println(description); 
    }

    @PreDestroy
    public void destruir(){
        System.out.println("Destruyendo compomente Invoice");
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
 
    public int getTotal(){
        // int total = 0;
        // for(Item item : items){
        //     total += item.getAmount();
        // }

        int total = items.stream().
            map(item -> item.getAmount()).
            reduce(0, (sum,importe) -> sum + importe);
        return total;

    }
}
