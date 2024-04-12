package com.example.elasticsearch.util;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;

@Slf4j
public class ElasticsearchExample {

    public static void main(String[] args) throws Exception {
        String serverUrl = "http://localhost:9200";
        String apiKey = "VnVhQ2ZHY0JDZGJrU...";

        RestClient restClient = RestClient.builder(HttpHost.create(serverUrl))
            .setDefaultHeaders(new Header[]{
                new BasicHeader("Authorization", "ApiKey " + apiKey)
            })
            .build();

        ElasticsearchTransport transport = new RestClientTransport(
            restClient, new JacksonJsonpMapper());
        ElasticsearchClient esClient = new ElasticsearchClient(transport);

        // Index new product
        indexProduct(esClient);

        // Execute search
        searchProducts(esClient);
    }

    private static void indexProduct(ElasticsearchClient esClient) throws IOException {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", "삼성 보조배터리");
        jsonMap.put("description", "든든 보조배터리 강력");

        IndexRequest<Map<String, Object>> indexRequest = IndexRequest.of(i -> i
            .index("product")
            .document(jsonMap)
        );
        esClient.index(indexRequest);
        log.info("Indexed new product");
    }

    private static void searchProducts(ElasticsearchClient esClient) throws IOException {
        SearchRequest searchRequest = SearchRequest.of(s -> s
            .index("product")
            .query(q -> q
                .matchAll(m -> m)
            )
        );
        SearchResponse<Object> searchResponse = esClient.search(searchRequest, Object.class);
        for (Hit<Object> hit : searchResponse.hits().hits()) {
            log.info("data={}", hit.source().toString());
        }
    }
}
