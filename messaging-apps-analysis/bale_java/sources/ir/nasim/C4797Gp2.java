package ir.nasim;

import android.util.SparseBooleanArray;

/* renamed from: ir.nasim.Gp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4797Gp2 {
    private final SparseBooleanArray a;

    /* renamed from: ir.nasim.Gp2$b */
    public static final class b {
        private final SparseBooleanArray a = new SparseBooleanArray();
        private boolean b;

        public b a(int i) {
            AbstractC20011rK.g(!this.b);
            this.a.append(i, true);
            return this;
        }

        public b b(C4797Gp2 c4797Gp2) {
            for (int i = 0; i < c4797Gp2.d(); i++) {
                a(c4797Gp2.c(i));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i : iArr) {
                a(i);
            }
            return this;
        }

        public b d(int i, boolean z) {
            return z ? a(i) : this;
        }

        public C4797Gp2 e() {
            AbstractC20011rK.g(!this.b);
            this.b = true;
            return new C4797Gp2(this.a);
        }
    }

    public boolean a(int i) {
        return this.a.get(i);
    }

    public boolean b(int... iArr) {
        for (int i : iArr) {
            if (a(i)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i) {
        AbstractC20011rK.c(i, 0, d());
        return this.a.keyAt(i);
    }

    public int d() {
        return this.a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4797Gp2)) {
            return false;
        }
        C4797Gp2 c4797Gp2 = (C4797Gp2) obj;
        if (AbstractC9683aN7.a >= 24) {
            return this.a.equals(c4797Gp2.a);
        }
        if (d() != c4797Gp2.d()) {
            return false;
        }
        for (int i = 0; i < d(); i++) {
            if (c(i) != c4797Gp2.c(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (AbstractC9683aN7.a >= 24) {
            return this.a.hashCode();
        }
        int iD = d();
        for (int i = 0; i < d(); i++) {
            iD = (iD * 31) + c(i);
        }
        return iD;
    }

    private C4797Gp2(SparseBooleanArray sparseBooleanArray) {
        this.a = sparseBooleanArray;
    }
}
