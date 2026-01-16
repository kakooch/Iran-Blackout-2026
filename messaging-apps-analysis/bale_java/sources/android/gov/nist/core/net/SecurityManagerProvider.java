package android.gov.nist.core.net;

import java.util.Properties;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

/* loaded from: classes.dex */
public interface SecurityManagerProvider {
    KeyManager[] getKeyManagers(boolean z);

    TrustManager[] getTrustManagers(boolean z);

    void init(Properties properties);
}
