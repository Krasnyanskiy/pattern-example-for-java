package ua.krasnyanskiy.pattern.strategy.config;

import ua.krasnyanskiy.pattern.strategy.config.annotation.ClientConfiguration;
import ua.krasnyanskiy.pattern.strategy.config.annotation.ClientCredentials;
import ua.krasnyanskiy.pattern.strategy.config.annotation.ClientRestVersion;
import ua.krasnyanskiy.pattern.strategy.config.annotation.ClientUri;

/**
 * @author Alexander Krasnyanskiy
 */
@ClientConfiguration
public class CustomClientConfiguration {

    @ClientUri
    private String uri;

    @ClientCredentials
    private Credentials credentials;

    @ClientRestVersion
    private String restVersion;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public String getRestVersion() {
        return restVersion;
    }

    public void setRestVersion(String restVersion) {
        this.restVersion = restVersion;
    }
}
