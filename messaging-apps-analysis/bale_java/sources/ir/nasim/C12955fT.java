package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.fT, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C12955fT extends AbstractC15385jV2 {
    private final String a;
    private final List b;

    C12955fT(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.b = list;
    }

    @Override // ir.nasim.AbstractC15385jV2
    public List b() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC15385jV2
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC15385jV2)) {
            return false;
        }
        AbstractC15385jV2 abstractC15385jV2 = (AbstractC15385jV2) obj;
        return this.a.equals(abstractC15385jV2.c()) && this.b.equals(abstractC15385jV2.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.a + ", usedDates=" + this.b + "}";
    }
}
