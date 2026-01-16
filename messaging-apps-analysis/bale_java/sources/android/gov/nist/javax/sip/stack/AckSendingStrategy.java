package android.gov.nist.javax.sip.stack;

import android.gov.nist.javax.sip.message.SIPRequest;
import ir.nasim.FY2;

/* loaded from: classes.dex */
public interface AckSendingStrategy {
    FY2 getLastHop();

    void send(SIPRequest sIPRequest);
}
