#set( $dollar = '$' )
package ${groupId}.graphql.builder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ${groupId}.${artifactId}.QueryType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Slf4j
@Configuration
public class QueryBuilder {
    @Value("${dollar}{graphql-base-url:}")
    private String graphqlBaseUrl;

    @Autowired(required = false)
    private SSLContext sslContext;

    @Autowired(required = false)
    private HostnameVerifier hostnameVerifier;

    @Bean
    public Client client() {
        final ClientBuilder clientBuilder = ClientBuilder.newBuilder();

        if (graphqlBaseUrl.startsWith("https://")) {
            if (sslContext != null) {
                LOGGER.debug("Register sslContext for URL:{}", graphqlBaseUrl);
                clientBuilder.sslContext(sslContext);
            } else {
                throw new IllegalArgumentException(
                        graphqlBaseUrl + " is secured and need a well configured sslContext!");
            }
        }
        if (hostnameVerifier != null) {
            clientBuilder.hostnameVerifier(hostnameVerifier);
        }

        return clientBuilder.build();
    }

    @Bean
    public QueryType queryType(Client client) {
        assertNotNull("graphql-base-url", graphqlBaseUrl);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        QueryType queryType = new QueryType(graphqlBaseUrl, client, objectMapper);
        return queryType;
    }

    private void logParameter(final String parameterName, final String parameterValue) {
        LOGGER.info("{}:{}", parameterName, parameterValue);
    }

    private void assertNotNull(String parameterName, String parameterValue) {
        logParameter(parameterName, parameterValue);

        if (StringUtils.isEmpty(parameterValue)) {
            throw new BeanInitializationException("Required attributes (" + parameterName + ") are missing.");
        }
    }
}
