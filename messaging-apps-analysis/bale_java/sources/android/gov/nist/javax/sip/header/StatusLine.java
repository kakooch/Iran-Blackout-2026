package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Match;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.SIPConstants;

/* loaded from: classes.dex */
public final class StatusLine extends SIPObject implements SipStatusLine {
    private static final long serialVersionUID = -4738092215519950414L;
    protected boolean matchStatusClass;
    protected String reasonPhrase = null;
    protected String sipVersion = SIPConstants.SIP_VERSION_STRING;
    protected int statusCode;

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String str = "SIP/2.0 " + this.statusCode;
        if (this.reasonPhrase != null) {
            str = str + Separators.SP + this.reasonPhrase;
        }
        return str + Separators.NEWLINE;
    }

    @Override // android.gov.nist.javax.sip.header.SipStatusLine
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    @Override // android.gov.nist.javax.sip.header.SipStatusLine
    public String getSipVersion() {
        return this.sipVersion;
    }

    @Override // android.gov.nist.javax.sip.header.SipStatusLine
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override // android.gov.nist.javax.sip.header.SipStatusLine
    public String getVersionMajor() {
        String str = null;
        if (this.sipVersion == null) {
            return null;
        }
        boolean z = false;
        for (int i = 0; i < this.sipVersion.length(); i++) {
            if (this.sipVersion.charAt(i) == '.') {
                z = false;
            }
            if (z) {
                str = str == null ? "" + this.sipVersion.charAt(i) : str + this.sipVersion.charAt(i);
            }
            if (this.sipVersion.charAt(i) == '/') {
                z = true;
            }
        }
        return str;
    }

    @Override // android.gov.nist.javax.sip.header.SipStatusLine
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

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean match(Object obj) {
        String str;
        if (!(obj instanceof StatusLine)) {
            return false;
        }
        StatusLine statusLine = (StatusLine) obj;
        Match match = statusLine.matchExpression;
        if (match != null) {
            return match.match(encode());
        }
        String str2 = statusLine.sipVersion;
        if (str2 != null && !str2.equals(this.sipVersion)) {
            return false;
        }
        int i = statusLine.statusCode;
        if (i != 0) {
            if (this.matchStatusClass) {
                if (Integer.toString(i).charAt(0) != Integer.toString(this.statusCode).charAt(0)) {
                    return false;
                }
            } else if (this.statusCode != i) {
                return false;
            }
        }
        Object obj2 = statusLine.reasonPhrase;
        if (obj2 == null || (str = this.reasonPhrase) == obj2) {
            return true;
        }
        return str.equals(obj2);
    }

    public void setMatchStatusClass(boolean z) {
        this.matchStatusClass = z;
    }

    @Override // android.gov.nist.javax.sip.header.SipStatusLine
    public void setReasonPhrase(String str) {
        this.reasonPhrase = str;
    }

    @Override // android.gov.nist.javax.sip.header.SipStatusLine
    public void setSipVersion(String str) {
        this.sipVersion = str;
    }

    @Override // android.gov.nist.javax.sip.header.SipStatusLine
    public void setStatusCode(int i) {
        this.statusCode = i;
    }
}
