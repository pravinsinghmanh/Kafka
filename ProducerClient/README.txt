curl command to test it :


#with configuration:
curl --location 'http://localhost:9999/producer-app/publish/create-topic-by-config-and-publish/pravinwwdqasd' \
--header 'X-API-Key: ••••••'



# With already create topic :
curl --location 'http://localhost:9999/producer-app/publish/create-topic-and-publish/pravinwwdqasd' \
--header 'X-API-Key: ••••••'

#Without creating the topic :
curl --location 'http://localhost:9999/producer-app/publish/pravinwwdqasd' \
--header 'X-API-Key: ••••••'