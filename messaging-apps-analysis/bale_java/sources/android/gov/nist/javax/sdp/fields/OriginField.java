package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Host;
import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.AM4;

/* loaded from: classes.dex */
public class OriginField extends SDPField implements AM4 {
    protected Host address;
    protected String addrtype;
    protected String nettype;
    private String sessIdString;
    private String sessVersionString;
    protected String username;

    public OriginField() {
        super(SDPFieldNames.ORIGIN_FIELD);
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        OriginField originField = (OriginField) super.clone();
        Host host = this.address;
        if (host != null) {
            originField.address = (Host) host.clone();
        }
        return originField;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String strEncode;
        Host host = this.address;
        if (host != null) {
            strEncode = host.encode();
            if (Host.isIPv6Reference(strEncode)) {
                strEncode = strEncode.substring(1, strEncode.length() - 1);
            }
        } else {
            strEncode = null;
        }
        return SDPFieldNames.ORIGIN_FIELD + this.username + Separators.SP + this.sessIdString + Separators.SP + this.sessVersionString + Separators.SP + this.nettype + Separators.SP + this.addrtype + Separators.SP + strEncode + Separators.NEWLINE;
    }

    public String getAddress() {
        Host host = getHost();
        if (host == null) {
            return null;
        }
        return host.getAddress();
    }

    public String getAddressType() {
        return getAddrtype();
    }

    public String getAddrtype() {
        return this.addrtype;
    }

    public Host getHost() {
        return this.address;
    }

    public String getNettype() {
        return this.nettype;
    }

    public String getNetworkType() {
        return getNettype();
    }

    public long getSessId() {
        return Long.valueOf(this.sessIdString).longValue();
    }

    public String getSessIdAsString() {
        return this.sessIdString;
    }

    public long getSessVersion() {
        return Long.valueOf(this.sessVersionString).longValue();
    }

    public String getSessVersionAsString() {
        return this.sessVersionString;
    }

    public long getSessionId() {
        return getSessId();
    }

    public long getSessionVersion() {
        return getSessVersion();
    }

    public String getUsername() {
        return this.username;
    }

    public void setAddress(Host host) {
        this.address = host;
    }

    public void setAddressType(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The type parameter is <0");
        }
        setAddrtype(str);
    }

    public void setAddrtype(String str) {
        this.addrtype = str;
    }

    public void setNettype(String str) {
        this.nettype = str;
    }

    public void setNetworkType(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The type parameter is <0");
        }
        setNettype(str);
    }

    public void setSessId(long j) {
        this.sessIdString = Long.toString(j);
    }

    public void setSessVersion(long j) {
        this.sessVersionString = Long.toString(j);
    }

    public void setSessionId(String str) {
        this.sessIdString = str;
    }

    public void setSessionVersion(long j) throws SdpException {
        if (j < 0) {
            throw new SdpException("The version parameter is <0");
        }
        setSessVersion(j);
    }

    public void setUsername(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The user parameter is null");
        }
        this.username = str;
    }

    public void setAddress(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The addr parameter is null");
        }
        Host host = getHost();
        if (host == null) {
            host = new Host();
        }
        host.setAddress(str);
        setAddress(host);
    }

    public void setSessVersion(String str) {
        this.sessVersionString = str;
    }

    public void setSessionId(long j) throws SdpException {
        if (j < 0) {
            throw new SdpException("The is parameter is <0");
        }
        setSessId(j);
    }
}
