package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.SIPConstants;
import ir.nasim.FY2;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class HopImpl implements FY2, Serializable {
    protected boolean defaultRoute;
    protected String host;
    protected int port;
    protected String transport;
    protected boolean uriRoute;

    public HopImpl(String str, int i, String str2) {
        this.host = str;
        if (str.indexOf(":") >= 0 && this.host.indexOf("[") < 0) {
            this.host = "[" + this.host + "]";
        }
        this.port = i;
        this.transport = str2;
    }

    @Override // ir.nasim.FY2
    public String getHost() {
        return this.host;
    }

    @Override // ir.nasim.FY2
    public int getPort() {
        return this.port;
    }

    @Override // ir.nasim.FY2
    public String getTransport() {
        return this.transport;
    }

    public boolean isURIRoute() {
        return this.uriRoute;
    }

    public void setURIRouteFlag() {
        this.uriRoute = true;
    }

    @Override // ir.nasim.FY2
    public String toString() {
        return this.host + ":" + this.port + Separators.SLASH + this.transport;
    }

    HopImpl(String str) {
        String strSubstring;
        if (str != null) {
            int iIndexOf = str.indexOf(93);
            int iIndexOf2 = str.indexOf(58, iIndexOf);
            int iIndexOf3 = str.indexOf(47, iIndexOf2);
            if (iIndexOf2 > 0) {
                this.host = str.substring(0, iIndexOf2);
                if (iIndexOf3 > 0) {
                    strSubstring = str.substring(iIndexOf2 + 1, iIndexOf3);
                    this.transport = str.substring(iIndexOf3 + 1);
                } else {
                    strSubstring = str.substring(iIndexOf2 + 1);
                    this.transport = "UDP";
                }
                try {
                    this.port = Integer.parseInt(strSubstring);
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("Bad port spec");
                }
            } else {
                int i = SIPConstants.DEFAULT_PORT;
                if (iIndexOf3 > 0) {
                    this.host = str.substring(0, iIndexOf3);
                    String strSubstring2 = str.substring(iIndexOf3 + 1);
                    this.transport = strSubstring2;
                    this.port = strSubstring2.equalsIgnoreCase("TLS") ? SIPConstants.DEFAULT_TLS_PORT : i;
                } else {
                    this.host = str;
                    this.transport = "UDP";
                    this.port = SIPConstants.DEFAULT_PORT;
                }
            }
            String str2 = this.host;
            if (str2 != null && str2.length() != 0) {
                this.host = this.host.trim();
                this.transport = this.transport.trim();
                if (iIndexOf > 0 && this.host.charAt(0) != '[') {
                    throw new IllegalArgumentException("Bad IPv6 reference spec");
                }
                return;
            }
            throw new IllegalArgumentException("no host!");
        }
        throw new IllegalArgumentException("Null arg!");
    }
}
