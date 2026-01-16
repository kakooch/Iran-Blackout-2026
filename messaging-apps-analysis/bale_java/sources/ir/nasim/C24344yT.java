package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.yT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C24344yT extends AbstractC4684Gc6 {
    private final QV0 a;
    private final Map b;

    C24344yT(QV0 qv0, Map map) {
        if (qv0 == null) {
            throw new NullPointerException("Null clock");
        }
        this.a = qv0;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.b = map;
    }

    @Override // ir.nasim.AbstractC4684Gc6
    QV0 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4684Gc6)) {
            return false;
        }
        AbstractC4684Gc6 abstractC4684Gc6 = (AbstractC4684Gc6) obj;
        return this.a.equals(abstractC4684Gc6.e()) && this.b.equals(abstractC4684Gc6.h());
    }

    @Override // ir.nasim.AbstractC4684Gc6
    Map h() {
        return this.b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.a + ", values=" + this.b + "}";
    }
}
