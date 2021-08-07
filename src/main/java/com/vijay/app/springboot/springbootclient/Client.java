package com.vijay.app.springboot.springbootclient;

import com.vijay.app.springboot.springbootserver.model.AddressBookProtos;
import com.vijay.app.springboot.springbootserver.model.AddressBookProtos.AddressBook;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class Client {
    public static void main(String[] args) {

        AddressBook req = AddressBook.newBuilder()
                .addPeople(AddressBookProtos.Person.newBuilder()
                        .setName("Vijay")
                        .setEmail("yoyo")
                        .build())
                .build();


        AddressBook data = WebClient.create("http://localhost:8080/api/proto/exec")
                .post()
                .accept(MediaType.valueOf("application/x-protobuf"))
                .contentType(MediaType.valueOf("application/x-protobuf"))
                .bodyValue(req)
                .retrieve()
                .bodyToMono(AddressBook.class)
                .block();

        System.out.println(data);


        System.out.println(data.getPeople(0).getId());
    }


}
