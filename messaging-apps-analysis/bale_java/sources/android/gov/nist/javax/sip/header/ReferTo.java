package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.AddressImpl;
import ir.nasim.InterfaceC14098hL5;

/* loaded from: classes.dex */
public final class ReferTo extends AddressParametersHeader implements InterfaceC14098hL5 {
    private static final long serialVersionUID = -1666700428440034851L;

    public ReferTo() {
        super("Refer-To");
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        AddressImpl addressImpl = this.address;
        if (addressImpl == null) {
            return null;
        }
        if (addressImpl.getAddressType() == 2) {
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
