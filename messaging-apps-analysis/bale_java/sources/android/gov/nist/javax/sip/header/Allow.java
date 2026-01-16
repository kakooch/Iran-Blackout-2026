package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC20884sm;

/* loaded from: classes.dex */
public final class Allow extends SIPHeader implements InterfaceC20884sm {
    private static final long serialVersionUID = -3105079479020693930L;
    protected String method;

    public Allow() {
        super(SIPHeaderNames.ALLOW);
        this.method = "";
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.method);
        return sb;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception, Allow, setMethod(), the method parameter is null.");
        }
        this.method = str;
    }

    public Allow(String str) {
        super(SIPHeaderNames.ALLOW);
        this.method = str;
    }
}
