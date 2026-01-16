package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.javax.sip.header.SIPHeaderList;

/* loaded from: classes.dex */
public class SecurityServerList extends SIPHeaderList<SecurityServer> {
    private static final long serialVersionUID = -1392066520803180238L;

    public SecurityServerList() {
        super(SecurityServer.class, "Security-Server");
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new SecurityServerList().clonehlist(this.hlist);
    }
}
