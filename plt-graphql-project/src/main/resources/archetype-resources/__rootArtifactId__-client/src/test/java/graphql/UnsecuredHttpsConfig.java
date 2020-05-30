package ${groupId}.graphql;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UnsecuredHttpsConfig {
    /**
     * Returns a Dummy SSLContext, that won't check the server certificate. With a real check, an exception is thrown,
     * as it is self signed.<BR/>
     * DON'T USE IT IN PRODUCTION.
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @Bean
    public static SSLContext getNoCheckSslContext() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLSv1");

        // Very, very bad. Don't do that in production !
        KeyManager[] keyManagers = null;
        TrustManager[] trustManager = { new NoOpTrustManager() };
        SecureRandom secureRandom = new SecureRandom();

        sslContext.init(keyManagers, trustManager, secureRandom);

        return sslContext;
    }

    /**
     * A dummy checker. DON'T USE IT IN PRODUCTION. But we can't buy a real certificat for this project.
     *
     * @return
     */
    @Bean
    public static HostnameVerifier getHostnameVerifier() {
        // Very, very bad. Don't do that in production !
        return new NoOpHostnameVerifier();
    }

    public static class NoOpTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static class NoOpHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String s, SSLSession sslSession) {
            return true;
        }
    }
}
