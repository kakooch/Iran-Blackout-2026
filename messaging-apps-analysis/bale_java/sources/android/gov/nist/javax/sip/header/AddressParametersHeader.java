package android.gov.nist.javax.sip.header;

import android.gov.nist.javax.sip.address.AddressImpl;
import ir.nasim.IU2;
import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC20733sW4;

/* loaded from: classes.dex */
public abstract class AddressParametersHeader extends ParametersHeader implements InterfaceC20733sW4 {
    protected AddressImpl address;

    protected AddressParametersHeader(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.core.GenericObject
    public Object clone() {
        AddressParametersHeader addressParametersHeader = (AddressParametersHeader) super.clone();
        AddressImpl addressImpl = this.address;
        if (addressImpl != null) {
            addressParametersHeader.address = (AddressImpl) addressImpl.clone();
        }
        return addressParametersHeader;
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IU2) || !(obj instanceof InterfaceC20733sW4)) {
            return false;
        }
        IU2 iu2 = (IU2) obj;
        return getAddress().equals(iu2.getAddress()) && equalParameters((InterfaceC20733sW4) iu2);
    }

    public InterfaceC16609la getAddress() {
        return this.address;
    }

    public void setAddress(InterfaceC16609la interfaceC16609la) {
        this.address = (AddressImpl) interfaceC16609la;
    }

    protected AddressParametersHeader(String str, boolean z) {
        super(str, z);
    }
}
