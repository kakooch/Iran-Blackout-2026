package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.AddressImpl;
import ir.nasim.V46;

/* loaded from: classes.dex */
public class Route extends AddressParametersHeader implements V46 {
    private static final long serialVersionUID = 5683577362998368846L;

    public Route() {
        super(SIPHeaderNames.ROUTE);
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.header.AddressParametersHeader, android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        return (obj instanceof V46) && super.equals(obj);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public int hashCode() {
        return this.address.getHostPort().encode().toLowerCase().hashCode();
    }

    public Route(AddressImpl addressImpl) {
        super(SIPHeaderNames.ROUTE);
        this.address = addressImpl;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        if (this.address.getAddressType() == 1) {
            this.address.encode(sb);
        } else {
            sb.append('<');
            this.address.encode(sb);
            sb.append('>');
        }
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }
}
