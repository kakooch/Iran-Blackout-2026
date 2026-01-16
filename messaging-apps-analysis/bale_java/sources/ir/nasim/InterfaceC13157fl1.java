package ir.nasim;

/* renamed from: ir.nasim.fl1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC13157fl1 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.fl1$a */
    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final InterfaceC13157fl1 b = new C1239a();
        private static final InterfaceC13157fl1 c = new e();
        private static final InterfaceC13157fl1 d = new c();
        private static final InterfaceC13157fl1 e = new d();
        private static final InterfaceC13157fl1 f = new f();
        private static final C19126pp2 g = new C19126pp2(1.0f);
        private static final InterfaceC13157fl1 h = new b();

        /* renamed from: ir.nasim.fl1$a$a, reason: collision with other inner class name */
        public static final class C1239a implements InterfaceC13157fl1 {
            C1239a() {
            }

            @Override // ir.nasim.InterfaceC13157fl1
            public long a(long j, long j2) {
                float fC = AbstractC13748gl1.c(j, j2);
                return AbstractC16045kc6.a((Float.floatToRawIntBits(fC) << 32) | (4294967295L & Float.floatToRawIntBits(fC)));
            }
        }

        /* renamed from: ir.nasim.fl1$a$b */
        public static final class b implements InterfaceC13157fl1 {
            b() {
            }

            @Override // ir.nasim.InterfaceC13157fl1
            public long a(long j, long j2) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) / Float.intBitsToFloat((int) (j >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) / Float.intBitsToFloat((int) (j & 4294967295L));
                return AbstractC16045kc6.a((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
            }
        }

        /* renamed from: ir.nasim.fl1$a$c */
        public static final class c implements InterfaceC13157fl1 {
            c() {
            }

            @Override // ir.nasim.InterfaceC13157fl1
            public long a(long j, long j2) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 & 4294967295L)) / Float.intBitsToFloat((int) (j & 4294967295L));
                return AbstractC16045kc6.a((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L));
            }
        }

        /* renamed from: ir.nasim.fl1$a$d */
        public static final class d implements InterfaceC13157fl1 {
            d() {
            }

            @Override // ir.nasim.InterfaceC13157fl1
            public long a(long j, long j2) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) / Float.intBitsToFloat((int) (j >> 32));
                return AbstractC16045kc6.a((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L));
            }
        }

        /* renamed from: ir.nasim.fl1$a$e */
        public static final class e implements InterfaceC13157fl1 {
            e() {
            }

            @Override // ir.nasim.InterfaceC13157fl1
            public long a(long j, long j2) {
                float fD = AbstractC13748gl1.d(j, j2);
                return AbstractC16045kc6.a((Float.floatToRawIntBits(fD) << 32) | (4294967295L & Float.floatToRawIntBits(fD)));
            }
        }

        /* renamed from: ir.nasim.fl1$a$f */
        public static final class f implements InterfaceC13157fl1 {
            f() {
            }

            @Override // ir.nasim.InterfaceC13157fl1
            public long a(long j, long j2) {
                if (Float.intBitsToFloat((int) (j >> 32)) <= Float.intBitsToFloat((int) (j2 >> 32)) && Float.intBitsToFloat((int) (j & 4294967295L)) <= Float.intBitsToFloat((int) (j2 & 4294967295L))) {
                    return AbstractC16045kc6.a((Float.floatToRawIntBits(1.0f) << 32) | (Float.floatToRawIntBits(1.0f) & 4294967295L));
                }
                float fD = AbstractC13748gl1.d(j, j2);
                return AbstractC16045kc6.a((Float.floatToRawIntBits(fD) << 32) | (Float.floatToRawIntBits(fD) & 4294967295L));
            }
        }

        private a() {
        }

        public final InterfaceC13157fl1 a() {
            return b;
        }

        public final InterfaceC13157fl1 b() {
            return h;
        }

        public final InterfaceC13157fl1 c() {
            return d;
        }

        public final InterfaceC13157fl1 d() {
            return e;
        }

        public final InterfaceC13157fl1 e() {
            return c;
        }

        public final InterfaceC13157fl1 f() {
            return f;
        }

        public final C19126pp2 g() {
            return g;
        }
    }

    long a(long j, long j2);
}
