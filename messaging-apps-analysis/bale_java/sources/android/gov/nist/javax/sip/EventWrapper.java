package android.gov.nist.javax.sip;

import android.gov.nist.javax.sip.stack.SIPTransaction;
import java.util.EventObject;

/* loaded from: classes.dex */
public class EventWrapper {
    protected EventObject sipEvent;
    protected SIPTransaction transaction;

    public EventWrapper(EventObject eventObject, SIPTransaction sIPTransaction) {
        this.sipEvent = eventObject;
        this.transaction = sIPTransaction;
    }
}
