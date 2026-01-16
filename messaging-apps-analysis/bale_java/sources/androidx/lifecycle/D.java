package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.j;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC18633oz3;

/* loaded from: classes2.dex */
public class D {
    private final p a;
    private final Handler b;
    private a c;

    public static final class a implements Runnable {
        private final p a;
        private final j.a b;
        private boolean c;

        public a(p pVar, j.a aVar) {
            AbstractC13042fc3.i(pVar, "registry");
            AbstractC13042fc3.i(aVar, "event");
            this.a = pVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            this.a.i(this.b);
            this.c = true;
        }
    }

    public D(InterfaceC18633oz3 interfaceC18633oz3) {
        AbstractC13042fc3.i(interfaceC18633oz3, "provider");
        this.a = new p(interfaceC18633oz3);
        this.b = new Handler();
    }

    private final void f(j.a aVar) {
        a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.run();
        }
        a aVar3 = new a(this.a, aVar);
        this.c = aVar3;
        Handler handler = this.b;
        AbstractC13042fc3.f(aVar3);
        handler.postAtFrontOfQueue(aVar3);
    }

    public j a() {
        return this.a;
    }

    public void b() {
        f(j.a.ON_START);
    }

    public void c() {
        f(j.a.ON_CREATE);
    }

    public void d() {
        f(j.a.ON_STOP);
        f(j.a.ON_DESTROY);
    }

    public void e() {
        f(j.a.ON_START);
    }
}
