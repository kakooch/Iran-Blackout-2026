package android.gov.nist.javax.sip.header;

import android.gov.nist.core.NameValueList;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.Utils;
import ir.nasim.JI5;

/* loaded from: classes.dex */
public class Reason extends ParametersHeader implements JI5 {
    private static final long serialVersionUID = -8903376965568297388L;
    public final String CAUSE;
    public final String TEXT;
    protected String protocol;

    public Reason() {
        super(SIPHeaderNames.REASON);
        this.TEXT = ParameterNames.TEXT;
        this.CAUSE = ParameterNames.CAUSE;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(this.protocol);
        NameValueList nameValueList = this.parameters;
        if (nameValueList == null || nameValueList.isEmpty()) {
            return sb;
        }
        sb.append(Separators.SEMICOLON);
        return this.parameters.encode(sb);
    }

    public int getCause() {
        return getParameterAsInt(ParameterNames.CAUSE);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader, android.gov.nist.javax.sip.header.HeaderExt
    public String getName() {
        return SIPHeaderNames.REASON;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getText() {
        return this.parameters.getParameter(ParameterNames.TEXT);
    }

    @Override // ir.nasim.JI5
    public void setCause(int i) {
        this.parameters.set(ParameterNames.CAUSE, Integer.valueOf(i));
    }

    @Override // ir.nasim.JI5
    public void setProtocol(String str) {
        this.protocol = str;
    }

    @Override // ir.nasim.JI5
    public void setText(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        if (str.charAt(0) != '\"') {
            str = Utils.getQuotedString(str);
        }
        this.parameters.set(ParameterNames.TEXT, str);
    }
}
