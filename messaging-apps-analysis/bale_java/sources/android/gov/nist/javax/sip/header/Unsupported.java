package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC12201eC7;

/* loaded from: classes.dex */
public class Unsupported extends SIPHeader implements InterfaceC12201eC7 {
    private static final long serialVersionUID = -2479414149440236199L;
    protected String optionTag;

    public Unsupported() {
        super(SIPHeaderNames.UNSUPPORTED);
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
            throw new NullPointerException("JAIN-SIP Exception,  Unsupported, setOptionTag(), The option tag parameter is null");
        }
        this.optionTag = str;
    }

    public Unsupported(String str) {
        super(SIPHeaderNames.UNSUPPORTED);
        this.optionTag = str;
    }
}
