package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC21662tv0;
import java.text.ParseException;

/* loaded from: classes.dex */
public class CallID extends SIPHeader implements InterfaceC21662tv0 {
    public static final String NAME_LOWER = SIPHeaderNames.CALL_ID.toLowerCase();
    private static final long serialVersionUID = -6463630258703731156L;
    protected CallIdentifier callIdentifier;

    public CallID() {
        super(SIPHeaderNames.CALL_ID);
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        CallID callID = (CallID) super.clone();
        CallIdentifier callIdentifier = this.callIdentifier;
        if (callIdentifier != null) {
            callID.callIdentifier = (CallIdentifier) callIdentifier.clone();
        }
        return callID;
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InterfaceC21662tv0) {
            return getCallId().equalsIgnoreCase(((InterfaceC21662tv0) obj).getCallId());
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC21662tv0
    public String getCallId() {
        return encodeBody();
    }

    public CallIdentifier getCallIdentifer() {
        return this.callIdentifier;
    }

    public void setCallId(String str) {
        try {
            this.callIdentifier = new CallIdentifier(str);
        } catch (IllegalArgumentException unused) {
            throw new ParseException(str, 0);
        }
    }

    public void setCallIdentifier(CallIdentifier callIdentifier) {
        this.callIdentifier = callIdentifier;
    }

    public CallID(String str) {
        super(SIPHeaderNames.CALL_ID);
        this.callIdentifier = new CallIdentifier(str);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        CallIdentifier callIdentifier = this.callIdentifier;
        if (callIdentifier != null) {
            callIdentifier.encode(sb);
        }
        return sb;
    }
}
