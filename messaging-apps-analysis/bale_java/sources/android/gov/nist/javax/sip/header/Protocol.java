package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.Utils;
import java.text.ParseException;

/* loaded from: classes.dex */
public class Protocol extends SIPObject {
    private static final long serialVersionUID = 2216758055974073280L;
    protected String protocolName = "SIP";
    protected String protocolVersion = "2.0";
    protected String transport = "UDP";

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    public String getProtocol() {
        return this.protocolName + '/' + this.protocolVersion;
    }

    public String getProtocolName() {
        return this.protocolName;
    }

    public String getProtocolVersion() {
        return this.protocolVersion;
    }

    public String getTransport() {
        return this.transport;
    }

    public void setProtocol(String str) {
        int iIndexOf = str.indexOf(47);
        if (iIndexOf <= 0) {
            throw new ParseException("Missing '/' in protocol", 0);
        }
        this.protocolName = str.substring(0, iIndexOf);
        this.protocolVersion = str.substring(iIndexOf + 1);
    }

    public void setProtocolName(String str) {
        this.protocolName = str;
    }

    public void setProtocolVersion(String str) {
        this.protocolVersion = str;
    }

    public void setTransport(String str) {
        this.transport = str;
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        sb.append(Utils.toUpperCase(this.protocolName));
        sb.append(Separators.SLASH);
        sb.append(this.protocolVersion);
        sb.append(Separators.SLASH);
        sb.append(this.transport.toUpperCase());
        return sb;
    }
}
