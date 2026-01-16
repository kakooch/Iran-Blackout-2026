package j$.util.stream;

import j$.util.AbstractC0102a;
import java.util.Comparator;

/* renamed from: j$.util.stream.g4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0157g4 implements j$.util.t {
    final boolean a;
    final AbstractC0256y2 b;
    private j$.util.function.z c;
    j$.util.t d;
    InterfaceC0192m3 e;
    j$.util.function.c f;
    long g;
    AbstractC0140e h;
    boolean i;

    AbstractC0157g4(AbstractC0256y2 abstractC0256y2, j$.util.function.z zVar, boolean z) {
        this.b = abstractC0256y2;
        this.c = zVar;
        this.d = null;
        this.a = z;
    }

    AbstractC0157g4(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z) {
        this.b = abstractC0256y2;
        this.c = null;
        this.d = tVar;
        this.a = z;
    }

    private boolean f() {
        boolean zA;
        while (this.h.count() == 0) {
            if (!this.e.p()) {
                C0122b c0122b = (C0122b) this.f;
                switch (c0122b.a) {
                    case 4:
                        C0211p4 c0211p4 = (C0211p4) c0122b.b;
                        zA = c0211p4.d.a(c0211p4.e);
                        break;
                    case 5:
                        C0222r4 c0222r4 = (C0222r4) c0122b.b;
                        zA = c0222r4.d.a(c0222r4.e);
                        break;
                    case 6:
                        t4 t4Var = (t4) c0122b.b;
                        zA = t4Var.d.a(t4Var.e);
                        break;
                    default:
                        M4 m4 = (M4) c0122b.b;
                        zA = m4.d.a(m4.e);
                        break;
                }
                if (zA) {
                    continue;
                }
            }
            if (this.i) {
                return false;
            }
            this.e.n();
            this.i = true;
        }
        return true;
    }

    final boolean b() {
        AbstractC0140e abstractC0140e = this.h;
        if (abstractC0140e == null) {
            if (this.i) {
                return false;
            }
            i();
            k();
            this.g = 0L;
            this.e.o(this.d.getExactSizeIfKnown());
            return f();
        }
        long j = this.g + 1;
        this.g = j;
        boolean z = j < abstractC0140e.count();
        if (z) {
            return z;
        }
        this.g = 0L;
        this.h.clear();
        return f();
    }

    @Override // j$.util.t
    public final int characteristics() {
        i();
        int iG = EnumC0145e4.g(this.b.t0()) & EnumC0145e4.f;
        return (iG & 64) != 0 ? (iG & (-16449)) | (this.d.characteristics() & 16448) : iG;
    }

    @Override // j$.util.t
    public final long estimateSize() {
        i();
        return this.d.estimateSize();
    }

    @Override // j$.util.t
    public Comparator getComparator() {
        if (AbstractC0102a.f(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    @Override // j$.util.t
    public final long getExactSizeIfKnown() {
        i();
        if (EnumC0145e4.SIZED.d(this.b.t0())) {
            return this.d.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override // j$.util.t
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0102a.f(this, i);
    }

    final void i() {
        if (this.d == null) {
            this.d = (j$.util.t) this.c.get();
            this.c = null;
        }
    }

    abstract void k();

    abstract AbstractC0157g4 l(j$.util.t tVar);

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.d);
    }

    @Override // j$.util.t
    public j$.util.t trySplit() {
        if (!this.a || this.i) {
            return null;
        }
        i();
        j$.util.t tVarTrySplit = this.d.trySplit();
        if (tVarTrySplit == null) {
            return null;
        }
        return l(tVarTrySplit);
    }
}
