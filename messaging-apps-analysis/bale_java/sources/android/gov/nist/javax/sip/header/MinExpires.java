package android.gov.nist.javax.sip.header;

import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC3524Bf4;

/* loaded from: classes.dex */
public class MinExpires extends SIPHeader implements InterfaceC3524Bf4 {
    private static final long serialVersionUID = 7001828209606095801L;
    protected int expires;

    public MinExpires() {
        super(SIPHeaderNames.MIN_EXPIRES);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(Integer.toString(this.expires));
        return sb;
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
}
