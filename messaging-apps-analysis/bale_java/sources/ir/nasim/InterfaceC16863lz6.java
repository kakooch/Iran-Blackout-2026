package ir.nasim;

/* renamed from: ir.nasim.lz6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC16863lz6 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.lz6$a */
    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final InterfaceC16863lz6 b = new NK6();
        private static final InterfaceC16863lz6 c = new OK6();

        private a() {
        }

        public static /* synthetic */ InterfaceC16863lz6 b(a aVar, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 0;
            }
            if ((i & 2) != 0) {
                j2 = Long.MAX_VALUE;
            }
            return aVar.a(j, j2);
        }

        public final InterfaceC16863lz6 a(long j, long j2) {
            return new PK6(j, j2);
        }

        public final InterfaceC16863lz6 c() {
            return b;
        }

        public final InterfaceC16863lz6 d() {
            return c;
        }
    }

    InterfaceC4557Fq2 a(InterfaceC10258bL6 interfaceC10258bL6);
}
