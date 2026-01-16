package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC20484s53;
import java.text.ParseException;

/* loaded from: classes.dex */
public class InReplyTo extends SIPHeader implements InterfaceC20484s53 {
    private static final long serialVersionUID = 1682602905733508890L;
    protected CallIdentifier callId;

    public InReplyTo() {
        super(SIPHeaderNames.IN_REPLY_TO);
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        InReplyTo inReplyTo = (InReplyTo) super.clone();
        CallIdentifier callIdentifier = this.callId;
        if (callIdentifier != null) {
            inReplyTo.callId = (CallIdentifier) callIdentifier.clone();
        }
        return inReplyTo;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        return this.callId.encode(sb);
    }

    public String getCallId() {
        CallIdentifier callIdentifier = this.callId;
        if (callIdentifier == null) {
            return null;
        }
        return callIdentifier.encode();
    }

    public void setCallId(String str) throws ParseException {
        try {
            this.callId = new CallIdentifier(str);
        } catch (Exception e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    public InReplyTo(CallIdentifier callIdentifier) {
        super(SIPHeaderNames.IN_REPLY_TO);
        this.callId = callIdentifier;
    }
}
