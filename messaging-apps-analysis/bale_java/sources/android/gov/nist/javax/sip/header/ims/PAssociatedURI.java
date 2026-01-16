package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.address.GenericURI;
import android.gov.nist.javax.sip.header.AddressParametersHeader;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC5634Ke2;
import java.text.ParseException;

/* loaded from: classes.dex */
public class PAssociatedURI extends AddressParametersHeader implements PAssociatedURIHeader, SIPHeaderNamesIms, InterfaceC5634Ke2 {
    public PAssociatedURI() {
        super("P-Associated-URI");
    }

    @Override // android.gov.nist.javax.sip.header.AddressParametersHeader, android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.core.GenericObject
    public Object clone() {
        PAssociatedURI pAssociatedURI = (PAssociatedURI) super.clone();
        AddressImpl addressImpl = this.address;
        if (addressImpl != null) {
            pAssociatedURI.address = (AddressImpl) addressImpl.clone();
        }
        return pAssociatedURI;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        if (this.address.getAddressType() == 2) {
            sb.append(Separators.LESS_THAN);
        }
        this.address.encode(sb);
        if (this.address.getAddressType() == 2) {
            sb.append(Separators.GREATER_THAN);
        }
        if (this.parameters.isEmpty()) {
            return sb;
        }
        sb.append(Separators.SEMICOLON);
        return this.parameters.encode(sb);
    }

    @Override // android.gov.nist.javax.sip.header.ims.PAssociatedURIHeader
    public InterfaceC21815uA7 getAssociatedURI() {
        return this.address.getURI();
    }

    @Override // android.gov.nist.javax.sip.header.ims.PAssociatedURIHeader
    public void setAssociatedURI(InterfaceC21815uA7 interfaceC21815uA7) {
        if (interfaceC21815uA7 == null) {
            throw new NullPointerException("null URI");
        }
        this.address.setURI(interfaceC21815uA7);
    }

    public void setValue(String str) throws ParseException {
        throw new ParseException(str, 0);
    }

    public PAssociatedURI(AddressImpl addressImpl) {
        super("P-Associated-URI");
        this.address = addressImpl;
    }

    public PAssociatedURI(GenericURI genericURI) {
        super("P-Associated-URI");
        AddressImpl addressImpl = new AddressImpl();
        this.address = addressImpl;
        addressImpl.setURI(genericURI);
    }
}
