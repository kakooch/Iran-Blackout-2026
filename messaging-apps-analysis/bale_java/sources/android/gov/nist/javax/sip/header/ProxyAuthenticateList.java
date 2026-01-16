package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class ProxyAuthenticateList extends SIPHeaderList<ProxyAuthenticate> {
    private static final long serialVersionUID = 1;

    public ProxyAuthenticateList() {
        super(ProxyAuthenticate.class, SIPHeaderNames.PROXY_AUTHENTICATE);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        ProxyAuthenticateList proxyAuthenticateList = new ProxyAuthenticateList();
        proxyAuthenticateList.clonehlist(this.hlist);
        return proxyAuthenticateList;
    }
}
