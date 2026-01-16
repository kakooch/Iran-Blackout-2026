package ir.nasim;

import ir.nasim.AbstractC19849r27;

/* loaded from: classes.dex */
final class DT extends AbstractC19849r27 {
    private final AbstractC19849r27.b a;
    private final AbstractC19849r27.a b;
    private final long c;

    DT(AbstractC19849r27.b bVar, AbstractC19849r27.a aVar, long j) {
        if (bVar == null) {
            throw new NullPointerException("Null configType");
        }
        this.a = bVar;
        if (aVar == null) {
            throw new NullPointerException("Null configSize");
        }
        this.b = aVar;
        this.c = j;
    }

    @Override // ir.nasim.AbstractC19849r27
    public AbstractC19849r27.a c() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC19849r27
    public AbstractC19849r27.b d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC19849r27)) {
            return false;
        }
        AbstractC19849r27 abstractC19849r27 = (AbstractC19849r27) obj;
        return this.a.equals(abstractC19849r27.d()) && this.b.equals(abstractC19849r27.c()) && this.c == abstractC19849r27.f();
    }

    @Override // ir.nasim.AbstractC19849r27
    public long f() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        long j = this.c;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "SurfaceConfig{configType=" + this.a + ", configSize=" + this.b + ", streamUseCase=" + this.c + "}";
    }
}
