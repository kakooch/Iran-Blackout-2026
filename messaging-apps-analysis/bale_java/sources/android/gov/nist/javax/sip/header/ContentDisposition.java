package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC23329wk1;

/* loaded from: classes.dex */
public final class ContentDisposition extends ParametersHeader implements InterfaceC23329wk1 {
    private static final long serialVersionUID = 835596496276127003L;
    protected String dispositionType;

    public ContentDisposition() {
        super(SIPHeaderNames.CONTENT_DISPOSITION);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.dispositionType);
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            sb.append(this.parameters.encode());
        }
        return sb;
    }

    public String getContentDisposition() {
        return encodeBody(new StringBuilder()).toString();
    }

    public String getDispositionType() {
        return this.dispositionType;
    }

    public String getHandling() {
        return getParameter(ParameterNames.HANDLING);
    }

    public void setDispositionType(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception, ContentDisposition, setDispositionType(), the dispositionType parameter is null");
        }
        this.dispositionType = str;
    }

    public void setHandling(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception, ContentDisposition, setHandling(), the handling parameter is null");
        }
        setParameter(ParameterNames.HANDLING, str);
    }
}
