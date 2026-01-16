package android.gov.nist.javax.sip.stack;

import android.javax.sip.SipException;

/* loaded from: classes.dex */
public class IllegalTransactionStateException extends SipException {
    Reason reason;

    public enum Reason {
        RequestAlreadySent,
        MissingRequiredHeader,
        UnmatchingCSeq,
        ExpiresHeaderMandatory,
        ContactHeaderMandatory,
        GenericReason
    }

    public IllegalTransactionStateException(Reason reason) {
        Reason reason2 = Reason.RequestAlreadySent;
        this.reason = reason;
    }

    public Reason getReason() {
        return this.reason;
    }

    public IllegalTransactionStateException(String str, Reason reason) {
        super(str);
        Reason reason2 = Reason.RequestAlreadySent;
        this.reason = reason;
    }

    public IllegalTransactionStateException(String str, Throwable th, Reason reason) {
        super(str, th);
        Reason reason2 = Reason.RequestAlreadySent;
        this.reason = reason;
    }
}
