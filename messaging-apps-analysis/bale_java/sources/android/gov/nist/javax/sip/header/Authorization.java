package android.gov.nist.javax.sip.header;

import android.gov.nist.javax.sip.header.ims.AuthorizationHeaderIms;
import ir.nasim.VR;

/* loaded from: classes.dex */
public class Authorization extends AuthenticationHeader implements VR, AuthorizationHeaderIms {
    private static final long serialVersionUID = -8897770321892281348L;

    public Authorization() {
        super(SIPHeaderNames.AUTHORIZATION);
    }
}
