package ir.nasim;

import org.aspectj.lang.NoAspectBoundException;

/* renamed from: ir.nasim.pW5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C18943pW5 {
    private static /* synthetic */ Throwable a;
    public static final /* synthetic */ C18943pW5 b = null;

    static {
        try {
            a();
        } catch (Throwable th) {
            a = th;
        }
    }

    private static /* synthetic */ void a() {
        b = new C18943pW5();
    }

    public static C18943pW5 b() {
        C18943pW5 c18943pW5 = b;
        if (c18943pW5 != null) {
            return c18943pW5;
        }
        throw new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", a);
    }

    public void c(InterfaceC5446Jj3 interfaceC5446Jj3) {
        if (interfaceC5446Jj3.a() instanceof D0) {
            if (((D0) interfaceC5446Jj3.a()).i()) {
                return;
            }
            ((D0) interfaceC5446Jj3.a()).l();
        } else {
            throw new RuntimeException("Only methods in subclasses of " + D0.class.getName() + " can  be annotated with ParseDetail");
        }
    }
}
