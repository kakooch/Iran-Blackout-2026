package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public class MediaRange extends SIPObject {
    private static final long serialVersionUID = -6297125815438079210L;
    protected String subtype;
    protected String type;

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    public String getSubtype() {
        return this.subtype;
    }

    public String getType() {
        return this.type;
    }

    public void setSubtype(String str) {
        this.subtype = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        sb.append(this.type);
        sb.append(Separators.SLASH);
        sb.append(this.subtype);
        return sb;
    }
}
