package ir.nasim;

import ir.nasim.InterfaceC11938do1;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.gj3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC13730gj3 extends InterfaceC11938do1.b {
    public static final b n0 = b.a;

    /* renamed from: ir.nasim.gj3$a */
    public static final class a {
        public static /* synthetic */ void a(InterfaceC13730gj3 interfaceC13730gj3, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            interfaceC13730gj3.g(cancellationException);
        }

        public static Object b(InterfaceC13730gj3 interfaceC13730gj3, Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
            return InterfaceC11938do1.b.a.a(interfaceC13730gj3, obj, interfaceC14603iB2);
        }

        public static InterfaceC11938do1.b c(InterfaceC13730gj3 interfaceC13730gj3, InterfaceC11938do1.c cVar) {
            return InterfaceC11938do1.b.a.b(interfaceC13730gj3, cVar);
        }

        public static /* synthetic */ NV1 d(InterfaceC13730gj3 interfaceC13730gj3, boolean z, boolean z2, UA2 ua2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return interfaceC13730gj3.K(z, z2, ua2);
        }

        public static InterfaceC11938do1 e(InterfaceC13730gj3 interfaceC13730gj3, InterfaceC11938do1.c cVar) {
            return InterfaceC11938do1.b.a.c(interfaceC13730gj3, cVar);
        }

        public static InterfaceC11938do1 f(InterfaceC13730gj3 interfaceC13730gj3, InterfaceC11938do1 interfaceC11938do1) {
            return InterfaceC11938do1.b.a.d(interfaceC13730gj3, interfaceC11938do1);
        }
    }

    /* renamed from: ir.nasim.gj3$b */
    public static final class b implements InterfaceC11938do1.c {
        static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    CS0 H(ES0 es0);

    NV1 K(boolean z, boolean z2, UA2 ua2);

    boolean b();

    InterfaceC23384wp6 d();

    void g(CancellationException cancellationException);

    InterfaceC13730gj3 getParent();

    boolean isCancelled();

    Object k0(InterfaceC20295rm1 interfaceC20295rm1);

    boolean p();

    CancellationException q();

    NV1 s(UA2 ua2);

    boolean start();
}
