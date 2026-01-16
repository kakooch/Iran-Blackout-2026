package ir.nasim;

import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.ne0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17832ne0 implements InterfaceC12529em {
    private final float b;
    private final float c;

    /* renamed from: ir.nasim.ne0$a */
    public static final class a implements InterfaceC12529em.b {
        private final float a;

        public a(float f) {
            this.a = f;
        }

        @Override // ir.nasim.InterfaceC12529em.b
        public int a(int i, int i2, EnumC12613eu3 enumC12613eu3) {
            return Math.round(((i2 - i) / 2.0f) * (1 + (enumC12613eu3 == EnumC12613eu3.a ? this.a : (-1) * this.a)));
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

    /* renamed from: ir.nasim.ne0$b */
    public static final class b implements InterfaceC12529em.c {
        private final float a;

        public b(float f) {
            this.a = f;
        }

        @Override // ir.nasim.InterfaceC12529em.c
        public int a(int i, int i2) {
            return Math.round(((i2 - i) / 2.0f) * (1 + this.a));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Float.compare(this.a, ((b) obj).a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.a);
        }

        public String toString() {
            return "Vertical(bias=" + this.a + ')';
        }
    }

    public C17832ne0(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    @Override // ir.nasim.InterfaceC12529em
    public long a(long j, long j2, EnumC12613eu3 enumC12613eu3) {
        float f = (((int) (j2 >> 32)) - ((int) (j >> 32))) / 2.0f;
        float f2 = (((int) (j2 & 4294967295L)) - ((int) (j & 4294967295L))) / 2.0f;
        float f3 = 1;
        return C22045ua3.f((Math.round(f * ((enumC12613eu3 == EnumC12613eu3.a ? this.b : (-1) * this.b) + f3)) << 32) | (Math.round(f2 * (f3 + this.c)) & 4294967295L));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17832ne0)) {
            return false;
        }
        C17832ne0 c17832ne0 = (C17832ne0) obj;
        return Float.compare(this.b, c17832ne0.b) == 0 && Float.compare(this.c, c17832ne0.c) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.b) * 31) + Float.hashCode(this.c);
    }

    public String toString() {
        return "BiasAlignment(horizontalBias=" + this.b + ", verticalBias=" + this.c + ')';
    }
}
