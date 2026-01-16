package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.GenericURI;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.Z92;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes.dex */
public final class ErrorInfo extends ParametersHeader implements Z92 {
    private static final long serialVersionUID = -6347702901964436362L;
    protected GenericURI errorInfo;

    public ErrorInfo() {
        super(SIPHeaderNames.ERROR_INFO);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.core.GenericObject
    public Object clone() {
        ErrorInfo errorInfo = (ErrorInfo) super.clone();
        GenericURI genericURI = this.errorInfo;
        if (genericURI != null) {
            errorInfo.errorInfo = (GenericURI) genericURI.clone();
        }
        return errorInfo;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(Separators.LESS_THAN);
        this.errorInfo.encode(sb);
        sb.append(Separators.GREATER_THAN);
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }

    public InterfaceC21815uA7 getErrorInfo() {
        return this.errorInfo;
    }

    public String getErrorMessage() {
        return getParameter(DialogEntity.COLUMN_MESSAGE);
    }

    public void setErrorInfo(InterfaceC21815uA7 interfaceC21815uA7) {
        this.errorInfo = (GenericURI) interfaceC21815uA7;
    }

    public void setErrorMessage(String str) {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception , ErrorInfoHeader, setErrorMessage(), the message parameter is null");
        }
        setParameter(DialogEntity.COLUMN_MESSAGE, str);
    }

    public ErrorInfo(GenericURI genericURI) {
        this();
        this.errorInfo = genericURI;
    }
}
