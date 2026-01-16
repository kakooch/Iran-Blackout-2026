package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.header.SIPHeader;
import ir.nasim.InterfaceC16609la;

/* loaded from: classes.dex */
public abstract class AddressHeaderIms extends SIPHeader {
    protected AddressImpl address;

    public AddressHeaderIms(String str) {
        super(str);
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        AddressHeaderIms addressHeaderIms = (AddressHeaderIms) super.clone();
        AddressImpl addressImpl = this.address;
        if (addressImpl != null) {
            addressHeaderIms.address = (AddressImpl) addressImpl.clone();
        }
        return addressHeaderIms;
    }

    public abstract String encodeBody();

    public InterfaceC16609la getAddress() {
        return this.address;
    }

    public void setAddress(InterfaceC16609la interfaceC16609la) {
        this.address = (AddressImpl) interfaceC16609la;
    }
}
