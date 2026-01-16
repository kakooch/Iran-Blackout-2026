package android.gov.nist.javax.sip.header;

import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC21427te2;

/* loaded from: classes.dex */
public class Expires extends SIPHeader implements InterfaceC21427te2 {
    private static final long serialVersionUID = 3134344915465784267L;
    protected int expires;

    public Expires() {
        super(SIPHeaderNames.EXPIRES);
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    public int getExpires() {
        return this.expires;
    }

    public void setExpires(int i) throws InvalidArgumentException {
        if (i >= 0) {
            this.expires = i;
            return;
        }
        throw new InvalidArgumentException("bad argument " + i);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.expires);
        return sb;
    }
}
