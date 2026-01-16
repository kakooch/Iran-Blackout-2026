package ir.nasim;

/* renamed from: ir.nasim.Wk0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC8539Wk0 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.Wk0$a */
    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final InterfaceC5766Kt b = AbstractC5999Lt.j(0.0f, 0.0f, null, 7, null);
        private static final InterfaceC8539Wk0 c = new C0735a();

        /* renamed from: ir.nasim.Wk0$a$a, reason: collision with other inner class name */
        public static final class C0735a implements InterfaceC8539Wk0 {
            C0735a() {
            }
        }

        private a() {
        }

        public final float a(float f, float f2, float f3) {
            float f4 = f2 + f;
            if ((f >= 0.0f && f4 <= f3) || (f < 0.0f && f4 > f3)) {
                return 0.0f;
            }
            float f5 = f4 - f3;
            return Math.abs(f) < Math.abs(f5) ? f : f5;
        }

        public final InterfaceC8539Wk0 b() {
            return c;
        }

        public final InterfaceC5766Kt c() {
            return b;
        }
    }

    default float a(float f, float f2, float f3) {
        return a.a(f, f2, f3);
    }
}
