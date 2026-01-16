package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.address.GenericURI;
import ir.nasim.InterfaceC21815uA7;

/* loaded from: classes.dex */
public class RequestLine extends SIPObject implements SipRequestLine {
    private static final long serialVersionUID = -3286426172326043129L;
    protected String method;
    protected String sipVersion = SIPConstants.SIP_VERSION_STRING;
    protected GenericURI uri;

    public RequestLine() {
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        RequestLine requestLine = (RequestLine) super.clone();
        GenericURI genericURI = this.uri;
        if (genericURI != null) {
            requestLine.uri = (GenericURI) genericURI.clone();
        }
        return requestLine;
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        RequestLine requestLine = (RequestLine) obj;
        String str = this.method;
        if (str == null) {
            if (requestLine.method != null) {
                return false;
            }
        } else if (!str.equals(requestLine.method)) {
            return false;
        }
        String str2 = this.sipVersion;
        if (str2 == null) {
            if (requestLine.sipVersion != null) {
                return false;
            }
        } else if (!str2.equals(requestLine.sipVersion)) {
            return false;
        }
        GenericURI genericURI = this.uri;
        if (genericURI == null) {
            if (requestLine.uri != null) {
                return false;
            }
        } else if (!genericURI.equals(requestLine.uri)) {
            return false;
        }
        return true;
    }

    @Override // android.gov.nist.javax.sip.header.SipRequestLine
    public String getMethod() {
        return this.method;
    }

    @Override // android.gov.nist.javax.sip.header.SipRequestLine
    public String getSipVersion() {
        return this.sipVersion;
    }

    @Override // android.gov.nist.javax.sip.header.SipRequestLine
    public String getVersionMajor() {
        if (this.sipVersion == null) {
            return null;
        }
        String str = null;
        boolean z = false;
        for (int i = 0; i < this.sipVersion.length() && this.sipVersion.charAt(i) != '.'; i++) {
            if (z) {
                str = str == null ? "" + this.sipVersion.charAt(i) : str + this.sipVersion.charAt(i);
            }
            if (this.sipVersion.charAt(i) == '/') {
                z = true;
            }
        }
        return str;
    }

    @Override // android.gov.nist.javax.sip.header.SipRequestLine
    public String getVersionMinor() {
        if (this.sipVersion == null) {
            return null;
        }
        String str = null;
        boolean z = false;
        for (int i = 0; i < this.sipVersion.length(); i++) {
            if (z) {
                str = str == null ? "" + this.sipVersion.charAt(i) : str + this.sipVersion.charAt(i);
            }
            if (this.sipVersion.charAt(i) == '.') {
                z = true;
            }
        }
        return str;
    }

    @Override // android.gov.nist.javax.sip.header.SipRequestLine
    public void setMethod(String str) {
        this.method = str;
    }

    @Override // android.gov.nist.javax.sip.header.SipRequestLine
    public void setSipVersion(String str) {
        this.sipVersion = str;
    }

    @Override // android.gov.nist.javax.sip.header.SipRequestLine
    public void setUri(InterfaceC21815uA7 interfaceC21815uA7) {
        this.uri = (GenericURI) interfaceC21815uA7;
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        String str = this.method;
        if (str != null) {
            sb.append(str);
            sb.append(Separators.SP);
        }
        GenericURI genericURI = this.uri;
        if (genericURI != null) {
            genericURI.encode(sb);
            sb.append(Separators.SP);
        }
        sb.append(this.sipVersion);
        sb.append(Separators.NEWLINE);
        return sb;
    }

    @Override // android.gov.nist.javax.sip.header.SipRequestLine
    public GenericURI getUri() {
        return this.uri;
    }

    public RequestLine(GenericURI genericURI, String str) {
        this.uri = genericURI;
        this.method = str;
    }
}
