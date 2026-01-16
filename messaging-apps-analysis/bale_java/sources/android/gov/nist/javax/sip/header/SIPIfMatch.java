package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC5634Ke2;
import ir.nasim.L76;

/* loaded from: classes.dex */
public class SIPIfMatch extends SIPHeader implements L76, InterfaceC5634Ke2 {
    private static final long serialVersionUID = 3833745477828359730L;
    protected String entityTag;

    public SIPIfMatch() {
        super(SIPHeaderNames.SIP_IF_MATCH);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.entityTag);
        return sb;
    }

    public String getETag() {
        return this.entityTag;
    }

    public void setETag(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception,SIP-If-Match, setETag(), the etag parameter is null");
        }
        this.entityTag = str;
    }

    public void setValue(String str) {
        setETag(str);
    }

    public SIPIfMatch(String str) {
        this();
        setETag(str);
    }
}
