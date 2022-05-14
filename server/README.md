Save Our Faves - San Diego

Instructions to run Cassandra locally
Reference: https://cassandra.apache.org/_/quickstart.html
1. Create network called Cassandra `docker network create cassandra`
2. Pull cassandra image `docker pull cassandra:latest`
3. Attach Cassandra container to Cassandra network, and run in the background `docker run --rm -d --name cassandra --hostname cassandra --network cassandra -p 9042:9042 cassandra`
4. Load test data `docker run --rm --network cassandra -v "/home/ttruong/git/saveourfaves/server/impl/src/main/resources/cassandra-local-setup.cql:/scripts/data.cql" -e CQLSH_HOST=cassandra -e CQLSH_PORT=9042 -e CQLVERSION=3.4.5 nuvo/docker-cqlsh`
5. Start CQLSH `docker run --rm -it --network cassandra nuvo/docker-cqlsh cqlsh cassandra 9042 --cqlversion='3.4.5'`
6. Clean up `docker kill cassandra && docker network rm cassandra`

CURLs
1. Add a business `curl -X PUT -H "Content-Type: application/json" -d '{"name":"Pho Cow", "giftCardURL": "www.yahoo.com"}' localhost:8080/v1/business`
1. Get all businesses `curl -X GET localhost:8080/v1/business`

Problems
1. CQL delete by id doesn't work, had to truncate
2. GET all businesses fails with nosuchmethoderror after putting a record, version issue?