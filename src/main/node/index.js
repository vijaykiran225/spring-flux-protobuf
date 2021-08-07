let axios = require('axios');

let AddressBook = require('./address_book_pb.js');
let ptr =AddressBook.AddressBook // stupid js ! 
// console.log(ptr)

let pers = new AddressBook.Person();

pers.setName("vijaykiran");
pers.setId(190);
pers.setEmail("vijay@vj.com");

let addr = new AddressBook.AddressBook();

addr.addPeople(pers);

let url = "http://localhost:8080/api/proto/exec"

axios({
        method: 'post',
        url: url,
        data: addr.serializeBinary(),
        headers: {
            'Content-Type': 'application/x-protobuf'
        }
    })
    .then(x => {
        let an = Uint8Array.from(x.data, c => c.charCodeAt(0))
        console.log(an);
        return an
    })
.then(resp => ptr.deserializeBinary(resp)) 
//took ages to replace AddressBook.AddressBook with ptr 
//AddressBook.AddressBook was undefined but ptr is recognized .. i mean are you kidding me ?
.then (e => console.log(e.getPeopleList()[0].getId()))
.catch (e => console.log(e))

