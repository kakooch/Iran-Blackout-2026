package android.gov.nist.javax.sip.address;

import android.gov.nist.core.HostPort;
import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC21815uA7;

/* loaded from: classes.dex */
public final class AddressImpl extends NetObject implements InterfaceC16609la {
    public static final int ADDRESS_SPEC = 2;
    public static final int NAME_ADDR = 1;
    public static final int WILD_CARD = 3;
    private static final long serialVersionUID = 429592779568617259L;
    protected GenericURI address;
    protected int addressType = 1;
    protected String displayName;

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        AddressImpl addressImpl = (AddressImpl) super.clone();
        GenericURI genericURI = this.address;
        if (genericURI != null) {
            addressImpl.address = (GenericURI) genericURI.clone();
        }
        return addressImpl;
    }

    @Override // android.gov.nist.core.GenericObject
    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.address.NetObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InterfaceC16609la) {
            return getURI().equals(((InterfaceC16609la) obj).getURI());
        }
        return false;
    }

    public int getAddressType() {
        return this.addressType;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getHost() {
        GenericURI genericURI = this.address;
        if (genericURI instanceof SipUri) {
            return ((SipUri) genericURI).getHostPort().getHost().getHostname();
        }
        throw new RuntimeException("address is not a SipUri");
    }

    public HostPort getHostPort() {
        GenericURI genericURI = this.address;
        if (genericURI instanceof SipUri) {
            return ((SipUri) genericURI).getHostPort();
        }
        throw new RuntimeException("address is not a SipUri");
    }

    public int getPort() {
        GenericURI genericURI = this.address;
        if (genericURI instanceof SipUri) {
            return ((SipUri) genericURI).getHostPort().getPort();
        }
        throw new RuntimeException("address is not a SipUri");
    }

    @Override // ir.nasim.InterfaceC16609la
    public InterfaceC21815uA7 getURI() {
        return this.address;
    }

    public String getUserAtHostPort() {
        GenericURI genericURI = this.address;
        return genericURI instanceof SipUri ? ((SipUri) genericURI).getUserAtHostPort() : genericURI.toString();
    }

    public boolean hasDisplayName() {
        return this.displayName != null;
    }

    public int hashCode() {
        return this.address.hashCode();
    }

    public boolean isSIPAddress() {
        return this.address instanceof SipUri;
    }

    public boolean isWildcard() {
        return this.addressType == 3;
    }

    @Override // android.gov.nist.javax.sip.address.NetObject, android.gov.nist.core.GenericObject
    public boolean match(Object obj) {
        if (obj == null) {
            return true;
        }
        if (!(obj instanceof InterfaceC16609la)) {
            return false;
        }
        AddressImpl addressImpl = (AddressImpl) obj;
        if (addressImpl.getMatcher() != null) {
            return addressImpl.getMatcher().match(encode());
        }
        String str = addressImpl.displayName;
        if (str == null || this.displayName != null) {
            return str == null ? this.address.match(addressImpl.address) : this.displayName.equalsIgnoreCase(str) && this.address.match(addressImpl.address);
        }
        return false;
    }

    public void removeDisplayName() {
        this.displayName = null;
    }

    public void removeParameter(String str) {
        GenericURI genericURI = this.address;
        if (!(genericURI instanceof SipUri)) {
            throw new RuntimeException("address is not a SipUri");
        }
        ((SipUri) genericURI).removeParameter(str);
    }

    public void setAddess(InterfaceC21815uA7 interfaceC21815uA7) {
        this.address = (GenericURI) interfaceC21815uA7;
    }

    public void setAddressType(int i) {
        this.addressType = i;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
        this.addressType = 1;
    }

    public void setURI(InterfaceC21815uA7 interfaceC21815uA7) {
        this.address = (GenericURI) interfaceC21815uA7;
    }

    public void setUser(String str) {
        ((SipUri) this.address).setUser(str);
    }

    public void setWildCardFlag() {
        this.addressType = 3;
        SipUri sipUri = new SipUri();
        this.address = sipUri;
        sipUri.setUser(Separators.STAR);
    }

    @Override // android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        if (this.addressType == 3) {
            sb.append('*');
        } else {
            if (this.displayName != null) {
                sb.append(Separators.DOUBLE_QUOTE);
                sb.append(this.displayName);
                sb.append(Separators.DOUBLE_QUOTE);
                sb.append(Separators.SP);
            }
            if (this.address != null) {
                if (this.addressType == 1 || this.displayName != null) {
                    sb.append(Separators.LESS_THAN);
                }
                this.address.encode(sb);
                if (this.addressType == 1 || this.displayName != null) {
                    sb.append(Separators.GREATER_THAN);
                }
            }
        }
        return sb;
    }
}
