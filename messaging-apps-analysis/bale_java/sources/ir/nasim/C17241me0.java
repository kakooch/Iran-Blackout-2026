package ir.nasim;

import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.me0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17241me0 implements InterfaceC12529em {
    private final float b;
    private final float c;

    /* renamed from: ir.nasim.me0$a */
    public static final class a implements InterfaceC12529em.b {
        private final float a;

        public a(float f) {
            this.a = f;
        }

        @Override // ir.nasim.InterfaceC12529em.b
        public int a(int i, int i2, EnumC12613eu3 enumC12613eu3) {
            return Math.round(((i2 - i) / 2.0f) * (1 + this.a));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Float.compare(this.a, ((a) obj).a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.a);
        }

        public String toString() {
            return "Horizontal(bias=" + this.a + ')';
        }
    }

    public C17241me0(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    @Override // ir.nasim.InterfaceC12529em
    public long a(long j, long j2, EnumC12613eu3 enumC12613eu3) {
        long jC = C4414Fa3.c(((((int) (j2 >> 32)) - ((int) (j >> 32))) << 32) | ((((int) (j2 & 4294967295L)) - ((int) (j & 4294967295L))) & 4294967295L));
        float f = 1;
        float f2 = (((int) (jC >> 32)) / 2.0f) * (this.b + f);
        float f3 = (((int) (jC & 4294967295L)) / 2.0f) * (f + this.c);
        return C22045ua3.f((Math.round(f2) << 32) | (Math.round(f3) & 4294967295L));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17241me0)) {
            return false;
        }
        C17241me0 c17241me0 = (C17241me0) obj;
        return Float.compare(this.b, c17241me0.b) == 0 && Float.compare(this.c, c17241me0.c) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.b) * 31) + Float.hashCode(this.c);
    }

    public String toString() {
        return "BiasAbsoluteAlignment(horizontalBias=" + this.b + ", verticalBias=" + this.c + ')';
    }
}
