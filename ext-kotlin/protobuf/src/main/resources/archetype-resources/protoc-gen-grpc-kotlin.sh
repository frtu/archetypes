# https://github.com/grpc/grpc-kotlin/blob/master/compiler/README.md
#!/usr/bin/env sh

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
java -jar $DIR/protoc-gen-grpc-kotlin-SOME_VERSION-jdk7.jar "$@

protoc --plugin=protoc-gen-grpckt=protoc-gen-grpc-kotlin.sh \
  --grpckt_out="$OUTPUT_FILE" --proto_path="$DIR_OF_PROTO_FILE" "$PROTO_FILE"