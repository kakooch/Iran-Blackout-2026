package android.gov.nist.core.net;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Properties;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes.dex */
public class DefaultSecurityManagerProvider implements SecurityManagerProvider {
    private static final StackLogger logger = CommonLogger.getLogger(DefaultSecurityManagerProvider.class);
    private KeyManagerFactory keyManagerFactory;
    private TrustManagerFactory trustManagerFactory;

    @Override // android.gov.nist.core.net.SecurityManagerProvider
    public KeyManager[] getKeyManagers(boolean z) {
        KeyManagerFactory keyManagerFactory = this.keyManagerFactory;
        if (keyManagerFactory == null) {
            return null;
        }
        return keyManagerFactory.getKeyManagers();
    }

    @Override // android.gov.nist.core.net.SecurityManagerProvider
    public TrustManager[] getTrustManagers(boolean z) {
        TrustManagerFactory trustManagerFactory = this.trustManagerFactory;
        if (trustManagerFactory == null) {
            return null;
        }
        return trustManagerFactory.getTrustManagers();
    }

    @Override // android.gov.nist.core.net.SecurityManagerProvider
    public void init(Properties properties) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        String property = properties.getProperty("javax.net.ssl.keyStore");
        String property2 = properties.getProperty("javax.net.ssl.keyStorePassword");
        String property3 = properties.getProperty("javax.net.ssl.keyStoreType");
        if (property3 == null) {
            property3 = KeyStore.getDefaultType();
            logger.logWarning("Using default keystore type " + property3);
        }
        if (property == null || property2 == null) {
            StackLogger stackLogger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("TLS server settings will be inactive - TLS key store will use JVM defaults keyStoreType=");
            sb.append(property3);
            sb.append(" javax.net.ssl.keyStore=");
            sb.append(property);
            sb.append(" javax.net.ssl.keyStorePassword=");
            sb.append(property2 == null ? null : "***");
            stackLogger.logWarning(sb.toString());
        }
        String property4 = properties.getProperty("javax.net.ssl.trustStore");
        String property5 = properties.getProperty("javax.net.ssl.trustStorePassword");
        if (property5 == null) {
            logger.logInfo("javax.net.ssl.trustStorePassword is null, using the password passed through javax.net.ssl.keyStorePassword");
            property5 = property2;
        }
        String property6 = properties.getProperty("javax.net.ssl.trustStoreType");
        if (property6 == null) {
            property6 = KeyStore.getDefaultType();
            logger.logWarning("Using default truststore type " + property6);
        }
        if (property4 == null || property5 == null) {
            StackLogger stackLogger2 = logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TLS trust settings will be inactive - TLS trust store will use JVM defaults. trustStoreType=");
            sb2.append(property6);
            sb2.append(" javax.net.ssl.trustStore=");
            sb2.append(property4);
            sb2.append(" javax.net.ssl.trustStorePassword=");
            sb2.append(property5 == null ? null : "***");
            stackLogger2.logWarning(sb2.toString());
        }
        String property7 = Security.getProperty("ssl.KeyManagerFactory.algorithm");
        if (property7 == null) {
            property7 = "SunX509";
        }
        StackLogger stackLogger3 = logger;
        if (stackLogger3.isLoggingEnabled(32)) {
            stackLogger3.logDebug("SecurityManagerProvider " + getClass().getCanonicalName() + " will use algorithm " + property7);
        }
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(property7);
        this.keyManagerFactory = keyManagerFactory;
        if (property != null) {
            KeyStore keyStore = KeyStore.getInstance(property3);
            keyStore.load(new FileInputStream(new File(property)), property2.toCharArray());
            this.keyManagerFactory.init(keyStore, property2.toCharArray());
        } else {
            keyManagerFactory.init(null, null);
        }
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(property7);
        this.trustManagerFactory = trustManagerFactory;
        if (property4 != null) {
            KeyStore keyStore2 = KeyStore.getInstance(property6);
            keyStore2.load(new FileInputStream(new File(property4)), property5.toCharArray());
            this.trustManagerFactory.init(keyStore2);
        } else {
            trustManagerFactory.init((KeyStore) null);
        }
        if (stackLogger3.isLoggingEnabled(32)) {
            stackLogger3.logDebug("TLS settings OK. SecurityManagerProvider " + getClass().getCanonicalName() + " initialized.");
        }
    }
}
