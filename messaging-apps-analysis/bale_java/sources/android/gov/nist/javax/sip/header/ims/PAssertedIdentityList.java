package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.javax.sip.header.SIPHeaderList;

/* loaded from: classes.dex */
public class PAssertedIdentityList extends SIPHeaderList<PAssertedIdentity> {
    private static final long serialVersionUID = -6465152445570308974L;

    public PAssertedIdentityList() {
        super(PAssertedIdentity.class, "P-Asserted-Identity");
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new PAssertedIdentityList().clonehlist(this.hlist);
    }
}
