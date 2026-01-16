package ir.nasim;

import android.gov.nist.javax.sdp.fields.AttributeField;
import android.javax.sdp.SdpException;

/* renamed from: ir.nasim.Ae6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3278Ae6 {
    private final long a;
    private final String b;

    public C3278Ae6(long j, String str) {
        AbstractC13042fc3.i(str, "config");
        this.a = j;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public final AttributeField c() throws SdpException {
        AttributeField attributeField = new AttributeField();
        attributeField.setName("fmtp");
        attributeField.setValue(this.a + ' ' + this.b);
        return attributeField;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3278Ae6)) {
            return false;
        }
        C3278Ae6 c3278Ae6 = (C3278Ae6) obj;
        return this.a == c3278Ae6.a && AbstractC13042fc3.d(this.b, c3278Ae6.b);
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SdpFmtp(payload=" + this.a + ", config=" + this.b + ')';
    }
}
