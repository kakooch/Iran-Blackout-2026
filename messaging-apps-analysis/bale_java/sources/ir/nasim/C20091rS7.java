package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.rS7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20091rS7 {
    private final EnumC21310tR6 a;
    private final float b;

    public C20091rS7(EnumC21310tR6 enumC21310tR6, float f) {
        AbstractC13042fc3.i(enumC21310tR6, "fileType");
        this.a = enumC21310tR6;
        this.b = f;
    }

    public final float a() {
        return this.b;
    }

    public final EnumC21310tR6 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20091rS7)) {
            return false;
        }
        C20091rS7 c20091rS7 = (C20091rS7) obj;
        return this.a == c20091rS7.a && Float.compare(this.b, c20091rS7.b) == 0;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Float.hashCode(this.b);
    }

    public String toString() {
        return "Video(fileType=" + this.a + ", durationInSec=" + this.b + Separators.RPAREN;
    }
}
