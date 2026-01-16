package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.javax.sip.header.SIPHeaderList;

/* loaded from: classes.dex */
public class PVisitedNetworkIDList extends SIPHeaderList<PVisitedNetworkID> {
    private static final long serialVersionUID = -4346667490341752478L;

    public PVisitedNetworkIDList() {
        super(PVisitedNetworkID.class, "P-Visited-Network-ID");
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new PVisitedNetworkIDList().clonehlist(this.hlist);
    }
}
