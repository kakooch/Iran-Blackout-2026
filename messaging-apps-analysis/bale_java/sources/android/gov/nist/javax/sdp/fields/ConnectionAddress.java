package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Host;
import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public class ConnectionAddress extends SDPObject {
    protected Host address;
    protected int port;
    protected int ttl;

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        ConnectionAddress connectionAddress = (ConnectionAddress) super.clone();
        Host host = this.address;
        if (host != null) {
            connectionAddress.address = (Host) host.clone();
        }
        return connectionAddress;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String strEncode;
        Host host = this.address;
        if (host != null) {
            strEncode = host.encode();
            if (Host.isIPv6Reference(strEncode)) {
                strEncode = strEncode.substring(1, strEncode.length() - 1);
            }
        } else {
            strEncode = "";
        }
        int i = this.ttl;
        if (i == 0 || this.port == 0) {
            if (i == 0) {
                return strEncode;
            }
            return strEncode + Separators.SLASH + this.ttl;
        }
        return strEncode + Separators.SLASH + this.ttl + Separators.SLASH + this.port;
    }

    public Host getAddress() {
        return this.address;
    }

    public int getPort() {
        return this.port;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setAddress(Host host) {
        this.address = host;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }
}
