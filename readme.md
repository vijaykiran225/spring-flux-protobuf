protoc --java_out=../java/  address_book.proto

protoc --js_out=import_style=commonjs:../node  address_book.proto