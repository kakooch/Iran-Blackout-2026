package android.gov.nist.javax.sdp.fields;

/* loaded from: classes.dex */
public class TypedTime extends SDPObject {
    int time;
    String unit;

    @Override // android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String str = "" + Integer.toString(this.time);
        if (this.unit == null) {
            return str;
        }
        return str + this.unit;
    }

    public int getTime() {
        return this.time;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void setUnit(String str) {
        this.unit = str;
    }
}
