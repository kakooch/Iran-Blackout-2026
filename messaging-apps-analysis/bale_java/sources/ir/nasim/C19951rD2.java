package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.rD2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19951rD2 {
    private final EnumC20560sD2 a;
    private final List b;

    public C19951rD2(EnumC20560sD2 enumC20560sD2, List list) {
        AbstractC13042fc3.i(enumC20560sD2, "sendOption");
        AbstractC13042fc3.i(list, "mediaContents");
        this.a = enumC20560sD2;
        this.b = list;
    }

    public final List a() {
        return this.b;
    }

    public final EnumC20560sD2 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19951rD2)) {
            return false;
        }
        C19951rD2 c19951rD2 = (C19951rD2) obj;
        return this.a == c19951rD2.a && AbstractC13042fc3.d(this.b, c19951rD2.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "GalleryResult(sendOption=" + this.a + ", mediaContents=" + this.b + Separators.RPAREN;
    }
}
