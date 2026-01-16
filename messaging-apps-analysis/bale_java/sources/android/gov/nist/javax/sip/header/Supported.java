package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC15712k27;

/* loaded from: classes.dex */
public class Supported extends SIPHeader implements InterfaceC15712k27 {
    private static final long serialVersionUID = -7679667592702854542L;
    protected String optionTag;

    public Supported() {
        super(SIPHeaderNames.SUPPORTED);
        this.optionTag = null;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader, android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String str = this.headerName + ":";
        if (this.optionTag != null) {
            str = str + Separators.SP + this.optionTag;
        }
        return str + Separators.NEWLINE;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        String str = this.optionTag;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb;
    }

    @Override // ir.nasim.CL4
    public String getOptionTag() {
        return this.optionTag;
    }

    public void setOptionTag(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception, Supported, setOptionTag(), the optionTag parameter is null");
        }
        this.optionTag = str;
    }

    public Supported(String str) {
        super(SIPHeaderNames.SUPPORTED);
        this.optionTag = str;
    }
}
