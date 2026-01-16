package android.gov.nist.javax.sip.header;

import android.gov.nist.core.NameValueList;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.GenericURI;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC22252uv0;
import java.text.ParseException;

/* loaded from: classes.dex */
public final class CallInfo extends ParametersHeader implements InterfaceC22252uv0 {
    private static final long serialVersionUID = -8179246487696752928L;
    protected GenericURI info;

    public CallInfo() {
        super(SIPHeaderNames.CALL_INFO);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.core.GenericObject
    public Object clone() {
        CallInfo callInfo = (CallInfo) super.clone();
        GenericURI genericURI = this.info;
        if (genericURI != null) {
            callInfo.info = (GenericURI) genericURI.clone();
        }
        return callInfo;
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    public InterfaceC21815uA7 getInfo() {
        return this.info;
    }

    public String getPurpose() {
        return getParameter(ParameterNames.PURPOSE);
    }

    public void setInfo(InterfaceC21815uA7 interfaceC21815uA7) {
        this.info = (GenericURI) interfaceC21815uA7;
    }

    public void setPurpose(String str) {
        if (str == null) {
            throw new NullPointerException("null arg");
        }
        try {
            setParameter(ParameterNames.PURPOSE, str);
        } catch (ParseException unused) {
        }
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        sb.append(Separators.LESS_THAN);
        this.info.encode(sb);
        sb.append(Separators.GREATER_THAN);
        NameValueList nameValueList = this.parameters;
        if (nameValueList != null && !nameValueList.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }
}
