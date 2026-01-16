package ir.nasim;

import androidx.camera.extensions.impl.ExtensionVersionImpl;

/* renamed from: ir.nasim.Oe2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6595Oe2 {
    private static volatile AbstractC6595Oe2 a;

    /* renamed from: ir.nasim.Oe2$a */
    private static class a extends AbstractC6595Oe2 {
        a() {
        }

        @Override // ir.nasim.AbstractC6595Oe2
        WR7 c() {
            return null;
        }
    }

    /* renamed from: ir.nasim.Oe2$b */
    private static class b extends AbstractC6595Oe2 {
        private static ExtensionVersionImpl c;
        private WR7 b;

        b() {
            if (c == null) {
                c = new ExtensionVersionImpl();
            }
            WR7 wr7S = WR7.s(c.checkApiVersion(DV0.a().d()));
            if (wr7S != null && DV0.a().b().p() == wr7S.p()) {
                this.b = wr7S;
            }
            PI3.a("ExtenderVersion", "Selected vendor runtime: " + this.b);
        }

        @Override // ir.nasim.AbstractC6595Oe2
        WR7 c() {
            return this.b;
        }
    }

    private static AbstractC6595Oe2 a() {
        if (a != null) {
            return a;
        }
        synchronized (AbstractC6595Oe2.class) {
            if (a == null) {
                try {
                    a = new b();
                } catch (NoClassDefFoundError unused) {
                    PI3.a("ExtenderVersion", "No versioning extender found. Falling back to default.");
                    a = new a();
                }
            }
        }
        return a;
    }

    public static WR7 b() {
        return a().c();
    }

    public static boolean d(WR7 wr7) {
        return b().a(wr7.p(), wr7.q()) >= 0;
    }

    abstract WR7 c();
}
