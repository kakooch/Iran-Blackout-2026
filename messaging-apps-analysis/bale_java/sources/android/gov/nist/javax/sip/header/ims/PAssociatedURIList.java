package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.javax.sip.header.SIPHeaderList;

/* loaded from: classes.dex */
public class PAssociatedURIList extends SIPHeaderList<PAssociatedURI> {
    private static final long serialVersionUID = 4454306052557362851L;

    public PAssociatedURIList() {
        super(PAssociatedURI.class, "P-Associated-URI");
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new PAssociatedURIList().clonehlist(this.hlist);
    }
}
