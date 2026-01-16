package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC20293rm;

/* loaded from: classes.dex */
public final class AllowEvents extends SIPHeader implements InterfaceC20293rm {
    private static final long serialVersionUID = 617962431813193114L;
    protected String eventType;

    public AllowEvents() {
        super(SIPHeaderNames.ALLOW_EVENTS);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.eventType);
        return sb;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception,AllowEvents, setEventType(), the eventType parameter is null");
        }
        this.eventType = str;
    }

    public AllowEvents(String str) {
        super(SIPHeaderNames.ALLOW_EVENTS);
        this.eventType = str;
    }
}
