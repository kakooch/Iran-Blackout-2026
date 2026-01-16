package ir.nasim;

/* renamed from: ir.nasim.hZ1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14220hZ1 {
    public static final AbstractC14220hZ1 a = new a();
    public static final AbstractC14220hZ1 b = new b();
    public static final AbstractC14220hZ1 c = new e();
    public static final AbstractC14220hZ1 d = new c();
    public static final AbstractC14220hZ1 e;
    public static final AbstractC14220hZ1 f;
    public static final AbstractC14220hZ1 g;
    public static final C23097wL4 h;
    static final boolean i;

    /* renamed from: ir.nasim.hZ1$a */
    private static class a extends AbstractC14220hZ1 {
        a() {
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public g a(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public float b(int i, int i2, int i3, int i4) {
            if (Math.min(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* renamed from: ir.nasim.hZ1$b */
    private static class b extends AbstractC14220hZ1 {
        b() {
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public g a(int i, int i2, int i3, int i4) {
            return g.MEMORY;
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public float b(int i, int i2, int i3, int i4) {
            int iCeil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    /* renamed from: ir.nasim.hZ1$c */
    private static class c extends AbstractC14220hZ1 {
        c() {
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public g a(int i, int i2, int i3, int i4) {
            return b(i, i2, i3, i4) == 1.0f ? g.QUALITY : AbstractC14220hZ1.c.a(i, i2, i3, i4);
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, AbstractC14220hZ1.c.b(i, i2, i3, i4));
        }
    }

    /* renamed from: ir.nasim.hZ1$d */
    private static class d extends AbstractC14220hZ1 {
        d() {
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public g a(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public float b(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }
    }

    /* renamed from: ir.nasim.hZ1$e */
    private static class e extends AbstractC14220hZ1 {
        e() {
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public g a(int i, int i2, int i3, int i4) {
            return AbstractC14220hZ1.i ? g.QUALITY : g.MEMORY;
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public float b(int i, int i2, int i3, int i4) {
            if (AbstractC14220hZ1.i) {
                return Math.min(i3 / i, i4 / i2);
            }
            if (Math.max(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* renamed from: ir.nasim.hZ1$f */
    private static class f extends AbstractC14220hZ1 {
        f() {
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public g a(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }

        @Override // ir.nasim.AbstractC14220hZ1
        public float b(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    /* renamed from: ir.nasim.hZ1$g */
    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        d dVar = new d();
        e = dVar;
        f = new f();
        g = dVar;
        h = C23097wL4.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        i = true;
    }

    public abstract g a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
