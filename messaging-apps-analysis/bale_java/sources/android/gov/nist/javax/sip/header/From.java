package android.gov.nist.javax.sip.header;

import android.gov.nist.core.HostPort;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.parser.Parser;
import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC17560nA2;

/* loaded from: classes.dex */
public final class From extends AddressParametersHeader implements InterfaceC17560nA2 {
    private static final long serialVersionUID = -6312727234330643892L;

    public From() {
        super(SIPHeaderNames.FROM);
    }

    protected String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.header.AddressParametersHeader, android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        return (obj instanceof InterfaceC17560nA2) && super.equals(obj);
    }

    public String getDisplayName() {
        return this.address.getDisplayName();
    }

    public HostPort getHostPort() {
        return this.address.getHostPort();
    }

    @Override // ir.nasim.InterfaceC17560nA2
    public String getTag() {
        if (this.parameters == null) {
            return null;
        }
        return getParameter(ParameterNames.TAG);
    }

    public String getUserAtHostPort() {
        return this.address.getUserAtHostPort();
    }

    public boolean hasTag() {
        return hasParameter(ParameterNames.TAG);
    }

    public void removeTag() {
        this.parameters.delete(ParameterNames.TAG);
    }

    @Override // android.gov.nist.javax.sip.header.AddressParametersHeader
    public void setAddress(InterfaceC16609la interfaceC16609la) {
        this.address = (AddressImpl) interfaceC16609la;
    }

    @Override // ir.nasim.InterfaceC17560nA2
    public void setTag(String str) {
        Parser.checkToken(str);
        setParameter(ParameterNames.TAG, str);
    }

    public From(To to) {
        super(SIPHeaderNames.FROM);
        this.address = to.address;
        this.parameters = to.parameters;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        if (this.address.getAddressType() == 2) {
            sb.append(Separators.LESS_THAN);
        }
        this.address.encode(sb);
        if (this.address.getAddressType() == 2) {
            sb.append(Separators.GREATER_THAN);
        }
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }
}
