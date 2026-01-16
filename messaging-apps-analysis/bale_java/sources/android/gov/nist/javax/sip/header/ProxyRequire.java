package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC12062dy5;

/* loaded from: classes.dex */
public class ProxyRequire extends SIPHeader implements InterfaceC12062dy5 {
    private static final long serialVersionUID = -3269274234851067893L;
    protected String optionTag;

    public ProxyRequire() {
        super(SIPHeaderNames.PROXY_REQUIRE);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.optionTag);
        return sb;
    }

    @Override // ir.nasim.CL4
    public String getOptionTag() {
        return this.optionTag;
    }

    public void setOptionTag(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception, ProxyRequire, setOptionTag(), the optionTag parameter is null");
        }
        this.optionTag = str;
    }

    public ProxyRequire(String str) {
        super(SIPHeaderNames.PROXY_REQUIRE);
        this.optionTag = str;
    }
}
