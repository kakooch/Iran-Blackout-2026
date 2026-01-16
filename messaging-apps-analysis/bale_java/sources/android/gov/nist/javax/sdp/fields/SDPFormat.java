package android.gov.nist.javax.sdp.fields;

/* loaded from: classes.dex */
public class SDPFormat extends SDPObject {
    protected String format;

    public SDPFormat(String str) {
        this.format = str;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return this.format;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public SDPFormat() {
    }
}
