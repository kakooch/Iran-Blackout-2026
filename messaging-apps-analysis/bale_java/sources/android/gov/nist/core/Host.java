package android.gov.nist.core;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes.dex */
public class Host extends GenericObject {
    protected static final int HOSTNAME = 1;
    protected static final int IPV4ADDRESS = 2;
    protected static final int IPV6ADDRESS = 3;
    private static final long serialVersionUID = -7233564517978323344L;
    private static boolean stripAddressScopeZones = Boolean.getBoolean("android.gov.nist.core.STRIP_ADDR_SCOPES");
    protected int addressType;
    protected String hostname;
    private InetAddress inetAddress;

    public Host() {
        this.addressType = 1;
    }

    private boolean isIPv6Address(String str) {
        return (str == null || str.indexOf(58) == -1) ? false : true;
    }

    public static boolean isIPv6Reference(String str) {
        return str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']';
    }

    private void setHost(String str, int i) {
        int iIndexOf;
        this.inetAddress = null;
        if (isIPv6Address(str)) {
            this.addressType = 3;
        } else {
            this.addressType = i;
        }
        if (str != null) {
            String strTrim = str.trim();
            this.hostname = strTrim;
            if (this.addressType == 1) {
                this.hostname = strTrim.toLowerCase();
            }
            if (this.addressType == 3 && stripAddressScopeZones && (iIndexOf = this.hostname.indexOf(37)) != -1) {
                String strSubstring = this.hostname.substring(0, iIndexOf);
                this.hostname = strSubstring;
                if (!strSubstring.startsWith("[") || this.hostname.endsWith("]")) {
                    return;
                }
                this.hostname += ']';
            }
        }
    }

    @Override // android.gov.nist.core.GenericObject
    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (obj != null && getClass().equals(obj.getClass())) {
            return ((Host) obj).hostname.equals(this.hostname);
        }
        return false;
    }

    public String getAddress() {
        return this.hostname;
    }

    public String getHostname() {
        return this.hostname;
    }

    public InetAddress getInetAddress() throws UnknownHostException {
        String str = this.hostname;
        if (str == null) {
            return null;
        }
        InetAddress inetAddress = this.inetAddress;
        if (inetAddress != null) {
            return inetAddress;
        }
        InetAddress byName = InetAddress.getByName(str);
        this.inetAddress = byName;
        return byName;
    }

    public String getIpAddress() {
        String str = this.hostname;
        if (str == null) {
            return null;
        }
        int i = this.addressType;
        if (i == 1) {
            try {
                if (this.inetAddress == null) {
                    this.inetAddress = InetAddress.getByName(str);
                }
                return this.inetAddress.getHostAddress();
            } catch (UnknownHostException e) {
                dbgPrint("Could not resolve hostname " + e);
            }
        } else {
            if (i != 3) {
                return str;
            }
            try {
                String string = getInetAddress().toString();
                int iIndexOf = string.indexOf(Separators.SLASH);
                if (iIndexOf != -1) {
                    string = string.substring(iIndexOf + 1, string.length());
                }
                if (!this.hostname.startsWith("[")) {
                    return string;
                }
                return '[' + string + ']';
            } catch (UnknownHostException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public int hashCode() {
        return getHostname().hashCode();
    }

    public boolean isHostname() {
        return this.addressType == 1;
    }

    public boolean isIPAddress() {
        return this.addressType != 1;
    }

    public void setAddress(String str) {
        setHostAddress(str);
    }

    public void setHostAddress(String str) {
        setHost(str, 2);
    }

    public void setHostname(String str) {
        setHost(str, 1);
    }

    @Override // android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        if (this.addressType != 3 || isIPv6Reference(this.hostname)) {
            sb.append(this.hostname);
        } else {
            sb.append('[');
            sb.append(this.hostname);
            sb.append(']');
        }
        return sb;
    }

    public Host(String str) {
        if (str != null) {
            setHost(str, 2);
            return;
        }
        throw new IllegalArgumentException("null host name");
    }

    public Host(String str, int i) {
        setHost(str, i);
    }
}
