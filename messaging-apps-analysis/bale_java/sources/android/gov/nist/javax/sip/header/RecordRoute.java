package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.AddressImpl;
import ir.nasim.InterfaceC9654aK5;

/* loaded from: classes.dex */
public class RecordRoute extends AddressParametersHeader implements InterfaceC9654aK5 {
    private static final long serialVersionUID = 2388023364181727205L;

    public RecordRoute(AddressImpl addressImpl) {
        super(SIPHeaderNames.RECORD_ROUTE);
        this.address = addressImpl;
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
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

    public RecordRoute() {
        super(SIPHeaderNames.RECORD_ROUTE);
    }
}
