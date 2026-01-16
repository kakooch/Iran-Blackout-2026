package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class ProxyRequireList extends SIPHeaderList<ProxyRequire> {
    private static final long serialVersionUID = 5648630649476486042L;

    public ProxyRequireList() {
        super(ProxyRequire.class, SIPHeaderNames.PROXY_REQUIRE);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        ProxyRequireList proxyRequireList = new ProxyRequireList();
        proxyRequireList.clonehlist(this.hlist);
        return proxyRequireList;
    }
}
