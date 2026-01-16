package android.gov.nist.javax.sip.header;

import android.gov.nist.core.NameValueList;
import android.gov.nist.core.Separators;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC18659p2;

/* loaded from: classes.dex */
public final class AcceptEncoding extends ParametersHeader implements InterfaceC18659p2 {
    private static final long serialVersionUID = -1476807565552873525L;
    protected String contentCoding;

    public AcceptEncoding() {
        super(SIPHeaderNames.ACCEPT_ENCODING);
    }

    protected String encodeBody() {
        return encode(new StringBuilder()).toString();
    }

    public String getEncoding() {
        return this.contentCoding;
    }

    public float getQValue() {
        return getParameterAsFloat("q");
    }

    public void setEncoding(String str) {
        if (str == null) {
            throw new NullPointerException(" encoding parameter is null");
        }
        this.contentCoding = str;
    }

    public void setQValue(float f) throws InvalidArgumentException {
        double d = f;
        if (d < 0.0d || d > 1.0d) {
            throw new InvalidArgumentException("qvalue out of range!");
        }
        super.setParameter("q", f);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        String str = this.contentCoding;
        if (str != null) {
            sb.append(str);
        }
        NameValueList nameValueList = this.parameters;
        if (nameValueList != null && !nameValueList.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            sb.append(this.parameters.encode());
        }
        return sb;
    }
}
