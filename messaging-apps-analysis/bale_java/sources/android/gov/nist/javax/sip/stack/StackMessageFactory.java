package android.gov.nist.javax.sip.stack;

import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;

/* loaded from: classes.dex */
public interface StackMessageFactory {
    ServerRequestInterface newSIPServerRequest(SIPRequest sIPRequest, SIPTransaction sIPTransaction);

    ServerResponseInterface newSIPServerResponse(SIPResponse sIPResponse, MessageChannel messageChannel);
}
