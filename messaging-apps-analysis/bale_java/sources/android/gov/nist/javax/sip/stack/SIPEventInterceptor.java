package android.gov.nist.javax.sip.stack;

import ir.nasim.K44;
import ir.nasim.MD6;

/* loaded from: classes.dex */
public interface SIPEventInterceptor {
    void afterMessage(K44 k44);

    void beforeMessage(K44 k44);

    void destroy();

    void init(MD6 md6);
}
