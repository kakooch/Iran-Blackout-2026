package ir.nasim;

/* renamed from: ir.nasim.w7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22963w7 {
    public static final d b = new d(null);
    private static final AbstractC22963w7 c = new a(new float[]{0.8951f, -0.7502f, 0.0389f, 0.2664f, 1.7135f, -0.0685f, -0.1614f, 0.0367f, 1.0296f});
    private static final AbstractC22963w7 d = new c(new float[]{0.40024f, -0.2263f, 0.0f, 0.7076f, 1.16532f, 0.0f, -0.08081f, 0.0457f, 0.91822f});
    private static final AbstractC22963w7 e = new b(new float[]{0.7328f, -0.7036f, 0.003f, 0.4296f, 1.6975f, 0.0136f, -0.1624f, 0.0061f, 0.9834f});
    private final float[] a;

    /* renamed from: ir.nasim.w7$a */
    public static final class a extends AbstractC22963w7 {
        a(float[] fArr) {
            super(fArr, null);
        }

        public String toString() {
            return "Bradford";
        }
    }

    /* renamed from: ir.nasim.w7$b */
    public static final class b extends AbstractC22963w7 {
        b(float[] fArr) {
            super(fArr, null);
        }

        public String toString() {
            return "Ciecat02";
        }
    }

    /* renamed from: ir.nasim.w7$c */
    public static final class c extends AbstractC22963w7 {
        c(float[] fArr) {
            super(fArr, null);
        }

        public String toString() {
            return "VonKries";
        }
    }

    /* renamed from: ir.nasim.w7$d */
    public static final class d {
        private d() {
        }

        public final AbstractC22963w7 a() {
            return AbstractC22963w7.c;
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ AbstractC22963w7(float[] fArr, ED1 ed1) {
        this(fArr);
    }

    public final float[] b() {
        return this.a;
    }

    private AbstractC22963w7(float[] fArr) {
        this.a = fArr;
    }
}
