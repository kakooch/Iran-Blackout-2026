package android.gov.nist.javax.sip.stack;

import java.util.EventListener;

/* loaded from: classes.dex */
public interface SIPTransactionEventListener extends EventListener {
    void transactionErrorEvent(SIPTransactionErrorEvent sIPTransactionErrorEvent);
}
