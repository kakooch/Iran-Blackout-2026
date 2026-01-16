package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Objects;

/* renamed from: ir.nasim.yy3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24648yy3 extends AbstractC4482Fi {
    private final String a;

    private C24648yy3(String str) {
        this.a = str;
    }

    public static C24648yy3 b(String str) {
        return new C24648yy3(str);
    }

    @Override // ir.nasim.AbstractC20124rW4
    public boolean a() {
        return false;
    }

    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C24648yy3) {
            return ((C24648yy3) obj).a.equals(this.a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(C24648yy3.class, this.a);
    }

    public String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.a + Separators.RPAREN;
    }
}
