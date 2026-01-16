package android.gov.nist.javax.sip.header.extensions;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParametersHeader;
import ir.nasim.InterfaceC5634Ke2;
import java.util.Iterator;

/* loaded from: classes.dex */
public class References extends ParametersHeader implements ReferencesHeader, InterfaceC5634Ke2 {
    private static final long serialVersionUID = 8536961681006637622L;
    private String callId;

    public References() {
        super(ReferencesHeader.NAME);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        if (this.parameters.isEmpty()) {
            sb.append(this.callId);
            return sb;
        }
        sb.append(this.callId);
        sb.append(Separators.SEMICOLON);
        return this.parameters.encode(sb);
    }

    @Override // android.gov.nist.javax.sip.header.extensions.ReferencesHeader
    public String getCallId() {
        return this.callId;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader, android.gov.nist.javax.sip.header.HeaderExt
    public String getName() {
        return ReferencesHeader.NAME;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, ir.nasim.InterfaceC20733sW4
    public String getParameter(String str) {
        return super.getParameter(str);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, ir.nasim.InterfaceC20733sW4
    public Iterator getParameterNames() {
        return super.getParameterNames();
    }

    @Override // android.gov.nist.javax.sip.header.extensions.ReferencesHeader
    public String getRel() {
        return getParameter(ReferencesHeader.REL);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, ir.nasim.InterfaceC20733sW4
    public void removeParameter(String str) {
        super.removeParameter(str);
    }

    @Override // android.gov.nist.javax.sip.header.extensions.ReferencesHeader
    public void setCallId(String str) {
        this.callId = str;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, ir.nasim.InterfaceC20733sW4
    public void setParameter(String str, String str2) {
        super.setParameter(str, str2);
    }

    @Override // android.gov.nist.javax.sip.header.extensions.ReferencesHeader
    public void setRel(String str) {
        if (str != null) {
            setParameter(ReferencesHeader.REL, str);
        }
    }

    public void setValue(String str) {
        throw new UnsupportedOperationException("operation not supported");
    }
}
