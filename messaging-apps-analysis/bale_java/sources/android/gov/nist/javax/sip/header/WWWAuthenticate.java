package android.gov.nist.javax.sip.header;

import android.gov.nist.javax.sip.header.ims.WWWAuthenticateHeaderIms;
import ir.nasim.InterfaceC21052t18;
import ir.nasim.InterfaceC21815uA7;

/* loaded from: classes.dex */
public class WWWAuthenticate extends AuthenticationHeader implements InterfaceC21052t18, WWWAuthenticateHeaderIms {
    private static final long serialVersionUID = 115378648697363486L;

    public WWWAuthenticate() {
        super(SIPHeaderNames.WWW_AUTHENTICATE);
    }

    @Override // android.gov.nist.javax.sip.header.AuthenticationHeader
    public InterfaceC21815uA7 getURI() {
        return null;
    }

    @Override // android.gov.nist.javax.sip.header.AuthenticationHeader
    public void setURI(InterfaceC21815uA7 interfaceC21815uA7) {
    }
}
