package android.gov.nist.javax.sip.header.extensions;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.CallIdentifier;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.header.ParametersHeader;
import ir.nasim.InterfaceC5634Ke2;
import java.text.ParseException;

/* loaded from: classes.dex */
public class Join extends ParametersHeader implements InterfaceC5634Ke2, JoinHeader {
    public static final String NAME = "Join";
    private static final long serialVersionUID = -840116548918120056L;
    public String callId;
    public CallIdentifier callIdentifier;

    public Join() {
        super("Join");
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        String str = this.callId;
        if (str == null) {
            return sb;
        }
        sb.append(str);
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }

    @Override // android.gov.nist.javax.sip.header.extensions.JoinHeader
    public String getCallId() {
        return this.callId;
    }

    public CallIdentifier getCallIdentifer() {
        return this.callIdentifier;
    }

    @Override // android.gov.nist.javax.sip.header.extensions.JoinHeader
    public String getFromTag() {
        if (this.parameters == null) {
            return null;
        }
        return getParameter(ParameterNames.FROM_TAG);
    }

    @Override // android.gov.nist.javax.sip.header.extensions.JoinHeader
    public String getToTag() {
        if (this.parameters == null) {
            return null;
        }
        return getParameter(ParameterNames.TO_TAG);
    }

    public boolean hasFromTag() {
        return hasParameter(ParameterNames.FROM_TAG);
    }

    public boolean hasToTag() {
        return hasParameter(ParameterNames.TO_TAG);
    }

    public void removeFromTag() {
        this.parameters.delete(ParameterNames.FROM_TAG);
    }

    public void removeToTag() {
        this.parameters.delete(ParameterNames.TO_TAG);
    }

    @Override // android.gov.nist.javax.sip.header.extensions.JoinHeader
    public void setCallId(String str) {
        this.callId = str;
    }

    public void setCallIdentifier(CallIdentifier callIdentifier) {
        this.callIdentifier = callIdentifier;
    }

    @Override // android.gov.nist.javax.sip.header.extensions.JoinHeader
    public void setFromTag(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null tag ");
        }
        if (str.trim().equals("")) {
            throw new ParseException("bad tag", 0);
        }
        setParameter(ParameterNames.FROM_TAG, str);
    }

    @Override // android.gov.nist.javax.sip.header.extensions.JoinHeader
    public void setToTag(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null tag ");
        }
        if (str.trim().equals("")) {
            throw new ParseException("bad tag", 0);
        }
        setParameter(ParameterNames.TO_TAG, str);
    }

    public void setValue(String str) throws ParseException {
        throw new ParseException(str, 0);
    }

    public Join(String str) {
        super("Join");
        this.callIdentifier = new CallIdentifier(str);
    }
}
