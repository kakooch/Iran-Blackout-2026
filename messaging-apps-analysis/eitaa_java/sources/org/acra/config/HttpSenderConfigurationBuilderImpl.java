package org.acra.config;

import android.content.Context;
import java.util.Map;
import org.acra.annotation.AcraHttpSender;
import org.acra.security.KeyStoreFactory;
import org.acra.security.NoKeyStoreFactory;
import org.acra.sender.HttpSender;

/* loaded from: classes.dex */
final class HttpSenderConfigurationBuilderImpl implements HttpSenderConfigurationBuilder {
    private String basicAuthLogin;
    private String basicAuthPassword;
    private String certificatePath;
    private String certificateType;
    private boolean compress;
    private int connectionTimeout;
    private final Context context;
    private final BaseHttpConfigurationBuilder delegate;
    private boolean dropReportsOnTimeout;
    private boolean enabled;
    private HttpSender.Method httpMethod;
    private Class<? extends KeyStoreFactory> keyStoreFactoryClass;
    private int resCertificate;
    private int socketTimeout;
    private String uri;

    HttpSenderConfigurationBuilderImpl(Context context) {
        AcraHttpSender acraHttpSender = (AcraHttpSender) context.getClass().getAnnotation(AcraHttpSender.class);
        this.context = context;
        this.enabled = acraHttpSender != null;
        this.delegate = new BaseHttpConfigurationBuilder();
        if (this.enabled) {
            this.uri = acraHttpSender.uri();
            this.basicAuthLogin = acraHttpSender.basicAuthLogin();
            this.basicAuthPassword = acraHttpSender.basicAuthPassword();
            this.httpMethod = acraHttpSender.httpMethod();
            this.connectionTimeout = acraHttpSender.connectionTimeout();
            this.socketTimeout = acraHttpSender.socketTimeout();
            this.dropReportsOnTimeout = acraHttpSender.dropReportsOnTimeout();
            this.keyStoreFactoryClass = acraHttpSender.keyStoreFactoryClass();
            this.certificatePath = acraHttpSender.certificatePath();
            this.resCertificate = acraHttpSender.resCertificate();
            this.certificateType = acraHttpSender.certificateType();
            this.compress = acraHttpSender.compress();
            return;
        }
        this.basicAuthLogin = "ACRA-NULL-STRING";
        this.basicAuthPassword = "ACRA-NULL-STRING";
        this.connectionTimeout = 5000;
        this.socketTimeout = 20000;
        this.dropReportsOnTimeout = false;
        this.keyStoreFactoryClass = NoKeyStoreFactory.class;
        this.certificatePath = "";
        this.resCertificate = 0;
        this.certificateType = "X.509";
        this.compress = false;
    }

    @Override // org.acra.config.HttpSenderConfigurationBuilder
    public HttpSenderConfigurationBuilderImpl setEnabled(boolean z) {
        this.enabled = z;
        return this;
    }

    boolean enabled() {
        return this.enabled;
    }

    @Override // org.acra.config.HttpSenderConfigurationBuilder
    public HttpSenderConfigurationBuilderImpl setUri(String str) {
        this.uri = str;
        return this;
    }

    String uri() {
        return this.uri;
    }

    String basicAuthLogin() {
        return this.basicAuthLogin;
    }

    String basicAuthPassword() {
        return this.basicAuthPassword;
    }

    @Override // org.acra.config.HttpSenderConfigurationBuilder
    public HttpSenderConfigurationBuilderImpl setHttpMethod(HttpSender.Method method) {
        this.httpMethod = method;
        return this;
    }

    HttpSender.Method httpMethod() {
        return this.httpMethod;
    }

    int connectionTimeout() {
        return this.connectionTimeout;
    }

    int socketTimeout() {
        return this.socketTimeout;
    }

    boolean dropReportsOnTimeout() {
        return this.dropReportsOnTimeout;
    }

    Class<? extends KeyStoreFactory> keyStoreFactoryClass() {
        return this.keyStoreFactoryClass;
    }

    String certificatePath() {
        return this.certificatePath;
    }

    int resCertificate() {
        return this.resCertificate;
    }

    String certificateType() {
        return this.certificateType;
    }

    boolean compress() {
        return this.compress;
    }

    Map<String, String> httpHeaders() {
        return this.delegate.httpHeaders();
    }

    @Override // org.acra.config.ConfigurationBuilder
    public HttpSenderConfiguration build() throws ACRAConfigurationException {
        if (this.enabled) {
            if (this.uri == null) {
                throw new ACRAConfigurationException("uri has to be set");
            }
            if (this.httpMethod == null) {
                throw new ACRAConfigurationException("httpMethod has to be set");
            }
        }
        return new HttpSenderConfiguration(this);
    }
}
