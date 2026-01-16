package ir.nasim;

import ir.nasim.HG4;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Kz5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5826Kz5 {
    public static final androidx.camera.core.impl.t b = androidx.camera.core.impl.t.b();
    private static final C5826Kz5 c = new C5826Kz5();
    private final C10547bn4 a = C10547bn4.h(b);

    /* renamed from: ir.nasim.Kz5$a */
    private static class a implements HG4.a {
        private final InterfaceC25043ze1 a;

        a(InterfaceC25043ze1 interfaceC25043ze1) {
            this.a = interfaceC25043ze1;
        }

        @Override // ir.nasim.HG4.a
        public void a(Throwable th) {
            PI3.d("ObserverToConsumerAdapter", "Unexpected error in Observable", th);
        }

        @Override // ir.nasim.HG4.a
        public void b(Object obj) {
            this.a.accept(obj);
        }
    }

    public static C5826Kz5 b() {
        return c;
    }

    public androidx.camera.core.impl.t a() {
        try {
            return (androidx.camera.core.impl.t) this.a.c().get();
        } catch (InterruptedException | ExecutionException e) {
            throw new AssertionError("Unexpected error in QuirkSettings StateObservable", e);
        }
    }

    public void c(Executor executor, InterfaceC25043ze1 interfaceC25043ze1) {
        this.a.a(executor, new a(interfaceC25043ze1));
    }

    public void d(androidx.camera.core.impl.t tVar) {
        this.a.g(tVar);
    }
}
