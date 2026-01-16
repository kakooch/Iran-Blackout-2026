package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.javax.sip.header.SIPHeaderList;

/* loaded from: classes.dex */
public class PMediaAuthorizationList extends SIPHeaderList<PMediaAuthorization> {
    private static final long serialVersionUID = -8226328073989632317L;

    public PMediaAuthorizationList() {
        super(PMediaAuthorization.class, "P-Media-Authorization");
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new PMediaAuthorizationList().clonehlist(this.hlist);
    }
}
