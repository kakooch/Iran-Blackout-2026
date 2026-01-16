package android.gov.nist.javax.sdp.fields;

/* loaded from: classes.dex */
public abstract class SDPField extends SDPObject {
    protected String fieldName;

    protected SDPField(String str) {
        this.fieldName = str;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public abstract String encode();

    public String getFieldName() {
        return this.fieldName;
    }

    public char getTypeChar() {
        String str = this.fieldName;
        if (str == null) {
            return (char) 0;
        }
        return str.charAt(0);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPObject
    public String toString() {
        return encode();
    }

    public SDPField() {
    }
}
