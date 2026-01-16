package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC9436Zx5;

/* loaded from: classes.dex */
public class ProxyAuthenticate extends AuthenticationHeader implements InterfaceC9436Zx5 {
    private static final long serialVersionUID = 3826145955463251116L;

    public ProxyAuthenticate() {
        super(SIPHeaderNames.PROXY_AUTHENTICATE);
    }

    @Override // android.gov.nist.javax.sip.header.AuthenticationHeader
    public InterfaceC21815uA7 getURI() {
        return null;
    }

    @Override // android.gov.nist.javax.sip.header.AuthenticationHeader
    public void setURI(InterfaceC21815uA7 interfaceC21815uA7) {
    }
}
