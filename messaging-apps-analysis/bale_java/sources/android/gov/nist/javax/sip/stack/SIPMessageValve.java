package android.gov.nist.javax.sip.stack;

import android.gov.nist.javax.sip.message.SIPRequest;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.MD6;

/* loaded from: classes.dex */
public interface SIPMessageValve {
    void destroy();

    void init(MD6 md6);

    boolean processRequest(SIPRequest sIPRequest, MessageChannel messageChannel);

    boolean processResponse(InterfaceC10981cX5 interfaceC10981cX5, MessageChannel messageChannel);
}
