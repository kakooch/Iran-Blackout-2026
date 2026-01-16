package android.gov.nist.javax.sip.header.extensions;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParametersHeader;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC5634Ke2;
import java.text.ParseException;

/* loaded from: classes.dex */
public final class SessionExpires extends ParametersHeader implements InterfaceC5634Ke2, SessionExpiresHeader {
    public static final String NAME = "Session-Expires";
    public static final String REFRESHER = "refresher";
    private static final long serialVersionUID = 8765762413224043300L;
    public int expires;

    public SessionExpires() {
        super("Session-Expires");
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        sb.append(Integer.toString(this.expires));
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }

    @Override // android.gov.nist.javax.sip.header.extensions.SessionExpiresHeader
    public int getExpires() {
        return this.expires;
    }

    @Override // android.gov.nist.javax.sip.header.extensions.SessionExpiresHeader
    public String getRefresher() {
        return this.parameters.getParameter(REFRESHER);
    }

    @Override // android.gov.nist.javax.sip.header.extensions.SessionExpiresHeader
    public void setExpires(int i) throws InvalidArgumentException {
        if (i >= 0) {
            this.expires = i;
            return;
        }
        throw new InvalidArgumentException("bad argument " + i);
    }

    @Override // android.gov.nist.javax.sip.header.extensions.SessionExpiresHeader
    public void setRefresher(String str) {
        this.parameters.set(REFRESHER, str);
    }

    @Override // android.gov.nist.javax.sip.header.extensions.SessionExpiresHeader
    public void setValue(String str) throws ParseException {
        throw new ParseException(str, 0);
    }
}
