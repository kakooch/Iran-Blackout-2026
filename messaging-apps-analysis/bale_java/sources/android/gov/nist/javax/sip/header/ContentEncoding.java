package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC24509yk1;

/* loaded from: classes.dex */
public class ContentEncoding extends SIPHeader implements InterfaceC24509yk1 {
    private static final long serialVersionUID = 2034230276579558857L;
    protected String contentEncoding;

    public ContentEncoding() {
        super(SIPHeaderNames.CONTENT_ENCODING);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.contentEncoding);
        return sb;
    }

    public String getEncoding() {
        return this.contentEncoding;
    }

    public void setEncoding(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception,  encoding is null");
        }
        this.contentEncoding = str;
    }

    public ContentEncoding(String str) {
        super(SIPHeaderNames.CONTENT_ENCODING);
        this.contentEncoding = str;
    }
}
