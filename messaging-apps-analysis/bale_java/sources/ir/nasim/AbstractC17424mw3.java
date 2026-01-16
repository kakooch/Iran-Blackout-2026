package ir.nasim;

import ir.nasim.InterfaceC8727Xb3;

/* renamed from: ir.nasim.mw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC17424mw3 {

    /* renamed from: ir.nasim.mw3$a */
    public interface a {

        /* renamed from: ir.nasim.mw3$a$a, reason: collision with other inner class name */
        static final class C1402a extends AbstractC8614Ws3 implements UA2 {
            public static final C1402a e = new C1402a();

            C1402a() {
                super(1);
            }

            public final Void a(int i) {
                return null;
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        UA2 getKey();

        default UA2 getType() {
            return C1402a.e;
        }
    }

    public final Object i(int i) {
        InterfaceC8727Xb3.a aVar = j().get(i);
        return ((a) aVar.c()).getType().invoke(Integer.valueOf(i - aVar.b()));
    }

    public abstract InterfaceC8727Xb3 j();

    public final int k() {
        return j().f();
    }

    public final Object l(int i) {
        Object objInvoke;
        InterfaceC8727Xb3.a aVar = j().get(i);
        int iB = i - aVar.b();
        UA2 key = ((a) aVar.c()).getKey();
        return (key == null || (objInvoke = key.invoke(Integer.valueOf(iB))) == null) ? androidx.compose.foundation.lazy.layout.h.a(i) : objInvoke;
    }
}
