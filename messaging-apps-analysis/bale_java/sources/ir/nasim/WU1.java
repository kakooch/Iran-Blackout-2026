package ir.nasim;

import ir.nasim.C9475a16;
import java.util.concurrent.CancellationException;

/* loaded from: classes8.dex */
public abstract class WU1 extends AbstractRunnableC4748Gj7 {
    public int c;

    public WU1(int i) {
        this.c = i;
    }

    public abstract void a(Object obj, Throwable th);

    public abstract InterfaceC20295rm1 c();

    public Throwable e(Object obj) {
        B01 b01 = obj instanceof B01 ? (B01) obj : null;
        if (b01 != null) {
            return b01.a;
        }
        return null;
    }

    public final void g(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            AbstractC16632lc2.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        AbstractC13042fc3.f(th);
        AbstractC16160ko1.a(c().getContext(), new C5021Ho1("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object h();

    @Override // java.lang.Runnable
    public final void run() {
        Object objB;
        Object objB2;
        InterfaceC5216Ij7 interfaceC5216Ij7 = this.b;
        try {
            InterfaceC20295rm1 interfaceC20295rm1C = c();
            AbstractC13042fc3.g(interfaceC20295rm1C, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            TU1 tu1 = (TU1) interfaceC20295rm1C;
            InterfaceC20295rm1 interfaceC20295rm1 = tu1.e;
            Object obj = tu1.g;
            InterfaceC11938do1 context = interfaceC20295rm1.getContext();
            Object objC = AbstractC7173Qo7.c(context, obj);
            C12801fB7 c12801fB7G = objC != AbstractC7173Qo7.a ? AbstractC12551eo1.g(interfaceC20295rm1, context, objC) : null;
            try {
                InterfaceC11938do1 context2 = interfaceC20295rm1.getContext();
                Object objH = h();
                Throwable thE = e(objH);
                InterfaceC13730gj3 interfaceC13730gj3 = (thE == null && XU1.b(this.c)) ? (InterfaceC13730gj3) context2.a(InterfaceC13730gj3.n0) : null;
                if (interfaceC13730gj3 != null && !interfaceC13730gj3.b()) {
                    CancellationException cancellationExceptionQ = interfaceC13730gj3.q();
                    a(objH, cancellationExceptionQ);
                    C9475a16.a aVar = C9475a16.b;
                    interfaceC20295rm1.resumeWith(C9475a16.b(AbstractC10685c16.a(cancellationExceptionQ)));
                } else if (thE != null) {
                    C9475a16.a aVar2 = C9475a16.b;
                    interfaceC20295rm1.resumeWith(C9475a16.b(AbstractC10685c16.a(thE)));
                } else {
                    C9475a16.a aVar3 = C9475a16.b;
                    interfaceC20295rm1.resumeWith(C9475a16.b(f(objH)));
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                if (c12801fB7G == null || c12801fB7G.h1()) {
                    AbstractC7173Qo7.a(context, objC);
                }
                try {
                    interfaceC5216Ij7.a();
                    objB2 = C9475a16.b(C19938rB7.a);
                } catch (Throwable th) {
                    C9475a16.a aVar4 = C9475a16.b;
                    objB2 = C9475a16.b(AbstractC10685c16.a(th));
                }
                g(null, C9475a16.e(objB2));
            } catch (Throwable th2) {
                if (c12801fB7G == null || c12801fB7G.h1()) {
                    AbstractC7173Qo7.a(context, objC);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                C9475a16.a aVar5 = C9475a16.b;
                interfaceC5216Ij7.a();
                objB = C9475a16.b(C19938rB7.a);
            } catch (Throwable th4) {
                C9475a16.a aVar6 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th4));
            }
            g(th3, C9475a16.e(objB));
        }
    }

    public Object f(Object obj) {
        return obj;
    }
}
