package android.gov.nist.javax.sip.address;

import ir.nasim.InterfaceC21815uA7;
import java.text.ParseException;

/* loaded from: classes.dex */
public class GenericURI extends NetObject implements InterfaceC21815uA7 {
    public static final String ISUB = "isub";
    public static final String PHONE_CONTEXT_TAG = "context-tag";
    public static final String POSTDIAL = "postdial";
    public static final String PROVIDER_TAG = "provider-tag";
    public static final String SIP = "sip";
    public static final String SIPS = "sips";
    public static final String TEL = "tel";
    private static final long serialVersionUID = 3237685256878068790L;
    protected String scheme;
    protected String uriString;

    protected GenericURI() {
    }

    @Override // android.gov.nist.core.GenericObject
    public String encode() {
        return this.uriString;
    }

    @Override // android.gov.nist.javax.sip.address.NetObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InterfaceC21815uA7) {
            return toString().equalsIgnoreCase(((InterfaceC21815uA7) obj).toString());
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC21815uA7
    public String getScheme() {
        return this.scheme;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // ir.nasim.InterfaceC21815uA7
    public boolean isSipURI() {
        return this instanceof SipUri;
    }

    @Override // android.gov.nist.javax.sip.address.NetObject, ir.nasim.InterfaceC21815uA7
    public String toString() {
        return encode();
    }

    public GenericURI(String str) throws ParseException {
        try {
            this.uriString = str;
            this.scheme = str.substring(0, str.indexOf(":"));
        } catch (Exception unused) {
            throw new ParseException("GenericURI, Bad URI format", 0);
        }
    }

    @Override // android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        sb.append(this.uriString);
        return sb;
    }
}
