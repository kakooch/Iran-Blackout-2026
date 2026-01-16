package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.javax.sip.header.SIPHeaderList;

/* loaded from: classes.dex */
public class PrivacyList extends SIPHeaderList<Privacy> {
    private static final long serialVersionUID = 1798720509806307461L;

    public PrivacyList() {
        super(Privacy.class, "Privacy");
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new PrivacyList().clonehlist(this.hlist);
    }
}
