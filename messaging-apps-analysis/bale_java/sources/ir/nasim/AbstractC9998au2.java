package ir.nasim;

/* renamed from: ir.nasim.au2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9998au2 {
    public static final a b = new a(null);
    private static final L47 c = new XD1();
    private static final TE2 d = new TE2("sans-serif", "FontFamily.SansSerif");
    private static final TE2 e = new TE2("serif", "FontFamily.Serif");
    private static final TE2 f = new TE2("monospace", "FontFamily.Monospace");
    private static final TE2 g = new TE2("cursive", "FontFamily.Cursive");
    private final boolean a;

    /* renamed from: ir.nasim.au2$a */
    public static final class a {
        private a() {
        }

        public final L47 a() {
            return AbstractC9998au2.c;
        }

        public final TE2 b() {
            return AbstractC9998au2.f;
        }

        public final TE2 c() {
            return AbstractC9998au2.d;
        }

        public final TE2 d() {
            return AbstractC9998au2.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.au2$b */
    public interface b {
        static /* synthetic */ InterfaceC9664aL6 a(b bVar, AbstractC9998au2 abstractC9998au2, C4593Fu2 c4593Fu2, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve-DPcqOEQ");
            }
            if ((i3 & 1) != 0) {
                abstractC9998au2 = null;
            }
            if ((i3 & 2) != 0) {
                c4593Fu2 = C4593Fu2.b.d();
            }
            if ((i3 & 4) != 0) {
                i = C3418Au2.b.b();
            }
            if ((i3 & 8) != 0) {
                i2 = C3657Bu2.b.a();
            }
            return bVar.b(abstractC9998au2, c4593Fu2, i, i2);
        }

        InterfaceC9664aL6 b(AbstractC9998au2 abstractC9998au2, C4593Fu2 c4593Fu2, int i, int i2);
    }

    public /* synthetic */ AbstractC9998au2(boolean z, ED1 ed1) {
        this(z);
    }

    private AbstractC9998au2(boolean z) {
        this.a = z;
    }
}
