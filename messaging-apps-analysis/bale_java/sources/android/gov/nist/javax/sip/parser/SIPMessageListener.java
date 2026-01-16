package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.message.SIPMessage;

/* loaded from: classes.dex */
public interface SIPMessageListener extends ParseExceptionListener {
    void processMessage(SIPMessage sIPMessage);

    void sendSingleCLRF();
}
