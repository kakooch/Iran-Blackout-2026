package android.gov.nist.javax.sip.header;

import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC7599Sk1;

/* loaded from: classes.dex */
public class ContentLength extends SIPHeader implements InterfaceC7599Sk1 {
    public static final String NAME_LOWER = SIPHeaderNames.CONTENT_LENGTH.toLowerCase();
    private static final long serialVersionUID = 1187190542411037027L;
    protected int contentLength;

    public ContentLength() {
        super(SIPHeaderNames.CONTENT_LENGTH);
        this.contentLength = -1;
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        return (obj instanceof InterfaceC7599Sk1) && getContentLength() == ((InterfaceC7599Sk1) obj).getContentLength();
    }

    @Override // ir.nasim.InterfaceC7599Sk1
    public int getContentLength() {
        return this.contentLength;
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean match(Object obj) {
        return obj instanceof ContentLength;
    }

    public void setContentLength(int i) throws InvalidArgumentException {
        if (i < 0) {
            throw new InvalidArgumentException("JAIN-SIP Exception, ContentLength, setContentLength(), the contentLength parameter is <0");
        }
        this.contentLength = i;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        int i = this.contentLength;
        if (i < 0) {
            sb.append("0");
        } else {
            sb.append(i);
        }
        return sb;
    }

    public ContentLength(int i) {
        super(SIPHeaderNames.CONTENT_LENGTH);
        this.contentLength = i;
    }
}
