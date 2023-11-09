package kz.dkazi.airastana.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "kz.dkazi.airastana.repository.elasticsearch")
@ComponentScan(basePackages = { "kz.dkazi.airastana.entity.elasticsearch" })
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Value(value = "${elasticsearch.host}")
    private String host;
    @Value(value = "${elasticsearch.username}")
    private String username;
    @Value(value = "${elasticsearch.password}")
    private String password;

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(host)
                .build();

        return RestClients.create(clientConfiguration)
                .rest();
    }
}

