package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Host;
import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC16641ld1;

/* loaded from: classes.dex */
public class ConnectionField extends SDPField implements InterfaceC16641ld1 {
    protected ConnectionAddress address;
    protected String addrtype;
    protected String nettype;

    public ConnectionField() {
        super(SDPFieldNames.CONNECTION_FIELD);
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        ConnectionField connectionField = (ConnectionField) super.clone();
        ConnectionAddress connectionAddress = this.address;
        if (connectionAddress != null) {
            connectionField.address = (ConnectionAddress) connectionAddress.clone();
        }
        return connectionField;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String str = this.nettype;
        String str2 = SDPFieldNames.CONNECTION_FIELD;
        if (str != null) {
            str2 = SDPFieldNames.CONNECTION_FIELD + this.nettype;
        }
        if (this.addrtype != null) {
            str2 = str2 + Separators.SP + this.addrtype;
        }
        if (this.address != null) {
            str2 = str2 + Separators.SP + this.address.encode();
        }
        return str2 + Separators.NEWLINE;
    }

    public String getAddress() {
        Host address;
        ConnectionAddress connectionAddress = getConnectionAddress();
        if (connectionAddress == null || (address = connectionAddress.getAddress()) == null) {
            return null;
        }
        return address.getAddress();
    }

    public String getAddressType() {
        return getAddrtype();
    }

    public String getAddrtype() {
        return this.addrtype;
    }

    public ConnectionAddress getConnectionAddress() {
        return this.address;
    }

    public String getNettype() {
        return this.nettype;
    }

    public String getNetworkType() {
        return getNettype();
    }

    public void setAddrType(String str) {
        this.addrtype = str;
    }

    public void setAddress(ConnectionAddress connectionAddress) {
        this.address = connectionAddress;
    }

    public void setAddressType(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("the type is null");
        }
        this.addrtype = str;
    }

    public void setNettype(String str) {
        this.nettype = str;
    }

    public void setNetworkType(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("the type is null");
        }
        setNettype(str);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject
    public String toString() {
        return encode();
    }

    public void setAddress(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("the addr is null");
        }
        ConnectionAddress connectionAddress = this.address;
        if (connectionAddress == null) {
            this.address = new ConnectionAddress();
            this.address.setAddress(new Host(str));
        } else {
            Host address = connectionAddress.getAddress();
            if (address == null) {
                this.address.setAddress(new Host(str));
            } else {
                address.setAddress(str);
            }
        }
        setAddress(this.address);
    }
}
