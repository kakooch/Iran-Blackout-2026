package ir.nasim;

import java.util.concurrent.CancellationException;

/* loaded from: classes8.dex */
public interface VI5 {

    public static final class a {
        public static /* synthetic */ void a(VI5 vi5, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            vi5.g(cancellationException);
        }
    }

    void g(CancellationException cancellationException);

    Object i(InterfaceC20295rm1 interfaceC20295rm1);

    CJ0 iterator();

    InterfaceC13763gm6 r();

    InterfaceC13763gm6 t();

    Object v();

    Object x(InterfaceC20295rm1 interfaceC20295rm1);
}
