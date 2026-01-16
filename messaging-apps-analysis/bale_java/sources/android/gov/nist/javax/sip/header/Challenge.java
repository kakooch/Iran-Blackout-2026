package android.gov.nist.javax.sip.header;

import android.gov.nist.core.NameValue;
import android.gov.nist.core.NameValueList;
import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public class Challenge extends SIPObject {
    private static String ALGORITHM = "algorithm";
    private static String DOMAIN = "domain";
    private static String OPAQUE = "opaque";
    private static String QOP = "qop";
    private static String REALM = "realm";
    private static String RESPONSE = "response";
    private static String SIGNATURE = "signature";
    private static String SIGNED_BY = "signed-by";
    private static String STALE = "stale";
    private static String URI = "uri";
    private static final long serialVersionUID = 5944455875924336L;
    protected NameValueList authParams;
    protected String scheme;

    public Challenge() {
        NameValueList nameValueList = new NameValueList();
        this.authParams = nameValueList;
        nameValueList.setSeparator(",");
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        Challenge challenge = (Challenge) super.clone();
        NameValueList nameValueList = this.authParams;
        if (nameValueList != null) {
            challenge.authParams = (NameValueList) nameValueList.clone();
        }
        return challenge;
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return this.scheme + Separators.SP + this.authParams.encode();
    }

    public String getAlgorithm() {
        return (String) this.authParams.getValue(ALGORITHM);
    }

    public NameValueList getAuthParams() {
        return this.authParams;
    }

    public String getDomain() {
        return (String) this.authParams.getValue(DOMAIN);
    }

    public String getOpaque() {
        return (String) this.authParams.getValue(OPAQUE);
    }

    public String getParameter(String str) {
        return (String) this.authParams.getValue(str);
    }

    public String getQOP() {
        return (String) this.authParams.getValue(QOP);
    }

    public String getRealm() {
        return (String) this.authParams.getValue(REALM);
    }

    public String getResponse() {
        return (String) this.authParams.getValue(RESPONSE);
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getSignature() {
        return (String) this.authParams.getValue(SIGNATURE);
    }

    public String getSignedBy() {
        return (String) this.authParams.getValue(SIGNED_BY);
    }

    public String getStale() {
        return (String) this.authParams.getValue(STALE);
    }

    public String getURI() {
        return (String) this.authParams.getValue(URI);
    }

    public boolean hasParameter(String str) {
        return this.authParams.getNameValue(str) != null;
    }

    public boolean hasParameters() {
        return this.authParams.size() != 0;
    }

    public boolean removeParameter(String str) {
        return this.authParams.delete(str);
    }

    public void removeParameters() {
        this.authParams = new NameValueList();
    }

    public void setAuthParams(NameValueList nameValueList) {
        this.authParams = nameValueList;
    }

    public void setParameter(NameValue nameValue) {
        this.authParams.set(nameValue);
    }

    public void setScheme(String str) {
        this.scheme = str;
    }
}
