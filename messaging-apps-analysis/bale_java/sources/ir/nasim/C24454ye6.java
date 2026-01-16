package ir.nasim;

import android.gov.nist.javax.sdp.fields.AttributeField;
import android.javax.sdp.SdpException;

/* renamed from: ir.nasim.ye6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24454ye6 {
    private final long a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public C24454ye6(long j, String str, String str2, String str3, String str4) {
        AbstractC13042fc3.i(str3, "uri");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    public final String a() {
        return this.d;
    }

    public final long b() {
        return this.a;
    }

    public final AttributeField c() throws SdpException {
        AttributeField attributeField = new AttributeField();
        attributeField.setName("extmap");
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        if (this.b != null) {
            sb.append(' ' + this.b);
        }
        if (this.c != null) {
            sb.append(' ' + this.c);
        }
        sb.append(' ' + this.d);
        if (this.e != null) {
            sb.append(' ' + this.e);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        attributeField.setValue(string);
        return attributeField;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24454ye6)) {
            return false;
        }
        C24454ye6 c24454ye6 = (C24454ye6) obj;
        return this.a == c24454ye6.a && AbstractC13042fc3.d(this.b, c24454ye6.b) && AbstractC13042fc3.d(this.c, c24454ye6.c) && AbstractC13042fc3.d(this.d, c24454ye6.d) && AbstractC13042fc3.d(this.e, c24454ye6.e);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.d.hashCode()) * 31;
        String str3 = this.e;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SdpExt(value=" + this.a + ", direction=" + this.b + ", encryptUri=" + this.c + ", uri=" + this.d + ", config=" + this.e + ')';
    }
}
