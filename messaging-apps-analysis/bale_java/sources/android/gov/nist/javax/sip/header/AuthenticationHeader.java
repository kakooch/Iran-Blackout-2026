package android.gov.nist.javax.sip.header;

import android.gov.nist.core.NameValue;
import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC21815uA7;
import java.text.ParseException;

/* loaded from: classes.dex */
public abstract class AuthenticationHeader extends ParametersHeader {
    public static final String ALGORITHM = "algorithm";
    public static final String CK = "ck";
    public static final String CNONCE = "cnonce";
    public static final String DOMAIN = "domain";
    public static final String IK = "ik";
    public static final String INTEGRITY_PROTECTED = "integrity-protected";
    public static final String NC = "nc";
    public static final String NONCE = "nonce";
    public static final String OPAQUE = "opaque";
    public static final String QOP = "qop";
    public static final String REALM = "realm";
    public static final String RESPONSE = "response";
    public static final String SIGNATURE = "signature";
    public static final String SIGNED_BY = "signed-by";
    public static final String STALE = "stale";
    public static final String URI = "uri";
    public static final String USERNAME = "username";
    protected String scheme;

    public AuthenticationHeader(String str) {
        super(str);
        this.parameters.setSeparator(",");
        this.scheme = "Digest";
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        this.parameters.setSeparator(",");
        sb.append(this.scheme);
        sb.append(Separators.SP);
        return this.parameters.encode(sb);
    }

    public String getAlgorithm() {
        return getParameter("algorithm");
    }

    public String getCK() {
        return getParameter("ck");
    }

    public String getCNonce() {
        return getParameter("cnonce");
    }

    public String getDomain() {
        return getParameter("domain");
    }

    public String getIK() {
        return getParameter("ik");
    }

    public String getIntegrityProtected() {
        return getParameter("integrity-protected");
    }

    public String getNonce() {
        return getParameter("nonce");
    }

    public int getNonceCount() {
        return getParameterAsHexInt("nc");
    }

    public String getOpaque() {
        return getParameter("opaque");
    }

    public String getQop() {
        return getParameter("qop");
    }

    public String getRealm() {
        return getParameter("realm");
    }

    public String getResponse() {
        return (String) getParameterValue("response");
    }

    public String getScheme() {
        return this.scheme;
    }

    public InterfaceC21815uA7 getURI() {
        return getParameterAsURI("uri");
    }

    public String getUsername() {
        return getParameter("username");
    }

    public boolean isStale() {
        return getParameterAsBoolean("stale");
    }

    public void setAlgorithm(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null arg");
        }
        setParameter("algorithm", str);
    }

    public void setCK(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception,  AuthenticationHeader, setCk(), The auth-param CK parameter is null");
        }
        setParameter("ck", str);
    }

    public void setCNonce(String str) throws ParseException {
        setParameter("cnonce", str);
    }

    public void setChallenge(Challenge challenge) {
        this.scheme = challenge.scheme;
        this.parameters = challenge.authParams;
    }

    public void setDomain(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null arg");
        }
        setParameter("domain", str);
    }

    public void setIK(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception,  AuthenticationHeader, setIk(), The auth-param IK parameter is null");
        }
        setParameter("ik", str);
    }

    public void setIntegrityProtected(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception,  AuthenticationHeader, setIntegrityProtected(), The integrity-protected parameter is null");
        }
        setParameter("integrity-protected", str);
    }

    public void setNonce(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception,  AuthenticationHeader, setNonce(), The nonce parameter is null");
        }
        setParameter("nonce", str);
    }

    public void setNonceCount(int i) throws ParseException {
        if (i < 0) {
            throw new ParseException("bad value", 0);
        }
        String hexString = Integer.toHexString(i);
        setParameter("nc", "00000000".substring(0, 8 - hexString.length()) + hexString);
    }

    public void setOpaque(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null arg");
        }
        setParameter("opaque", str);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, ir.nasim.InterfaceC20733sW4
    public void setParameter(String str, String str2) throws ParseException {
        NameValue nameValue = this.parameters.getNameValue(str.toLowerCase());
        if (nameValue != null) {
            nameValue.setValueAsObject(str2);
            return;
        }
        NameValue nameValue2 = new NameValue(str, str2);
        if (str.equalsIgnoreCase("qop") || str.equalsIgnoreCase("realm") || str.equalsIgnoreCase("cnonce") || str.equalsIgnoreCase("nonce") || str.equalsIgnoreCase("username") || str.equalsIgnoreCase("domain") || str.equalsIgnoreCase("opaque") || str.equalsIgnoreCase(ParameterNames.NEXT_NONCE) || str.equalsIgnoreCase("uri") || str.equalsIgnoreCase("response") || str.equalsIgnoreCase("ik") || str.equalsIgnoreCase("ck") || str.equalsIgnoreCase("integrity-protected")) {
            if ((!(this instanceof Authorization) && !(this instanceof ProxyAuthorization)) || !str.equalsIgnoreCase("qop")) {
                nameValue2.setQuotedValue();
            }
            if (str2 == null) {
                throw new NullPointerException("null value");
            }
            if (str2.startsWith(Separators.DOUBLE_QUOTE)) {
                throw new ParseException(str2 + " : Unexpected DOUBLE_QUOTE", 0);
            }
        }
        super.setParameter(nameValue2);
    }

    public void setQop(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("null arg");
        }
        setParameter("qop", str);
    }

    public void setRealm(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("JAIN-SIP Exception,  AuthenticationHeader, setRealm(), The realm parameter is null");
        }
        setParameter("realm", str);
    }

    public void setResponse(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("Null parameter");
        }
        setParameter("response", str);
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setStale(boolean z) {
        setParameter(new NameValue("stale", Boolean.valueOf(z)));
    }

    public void setURI(InterfaceC21815uA7 interfaceC21815uA7) {
        if (interfaceC21815uA7 == null) {
            throw new NullPointerException("Null URI");
        }
        NameValue nameValue = new NameValue("uri", interfaceC21815uA7);
        nameValue.setQuotedValue();
        this.parameters.set(nameValue);
    }

    public void setUsername(String str) throws ParseException {
        setParameter("username", str);
    }

    public AuthenticationHeader() {
        this.parameters.setSeparator(",");
    }
}
