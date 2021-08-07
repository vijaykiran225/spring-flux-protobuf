package com.vijay.app.springboot.springbootserver.components;

import com.vijay.app.springboot.springbootserver.model.AddressBookProtos;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Base64;
import java.util.Random;

@Component
@RestController
@RequestMapping("/api/proto")
public class ProtoController {

    @PostMapping(value = "/exec",produces = {"application/x-protobuf"},consumes = {"application/x-protobuf"})
    public AddressBookProtos.AddressBook finaliz(@RequestBody AddressBookProtos.AddressBook request) {

        String mail = "resp-"+request.getPeople(0).getEmail();
        String name = "resp-"+request.getPeople(0).getName();

        System.out.println(mail);
        System.out.println(name);
        AddressBookProtos.AddressBook build = AddressBookProtos.AddressBook.newBuilder()
                .addPeople(AddressBookProtos.Person.newBuilder()
                        .setId(new Random().nextInt())
                        .setEmail(Base64.getEncoder().encodeToString(mail.getBytes()))
                        .setName(Base64.getEncoder().encodeToString(name.getBytes()))
                        .build())
                .build();

        System.out.println("sending resp"+build.toString());


        return build;
    }
}
