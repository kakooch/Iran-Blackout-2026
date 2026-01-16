package ir.nasim;

import android.os.Handler;
import ir.nasim.InterfaceC10699c30;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.c30, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC10699c30 {

    /* renamed from: ir.nasim.c30$a */
    public interface a {

        /* renamed from: ir.nasim.c30$a$a, reason: collision with other inner class name */
        public static final class C0927a {
            private final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: ir.nasim.c30$a$a$a, reason: collision with other inner class name */
            static final class C0928a {
                private final Handler a;
                private final a b;
                private boolean c;

                public C0928a(Handler handler, a aVar) {
                    this.a = handler;
                    this.b = aVar;
                }

                public void d() {
                    this.c = true;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void d(C0928a c0928a, int i, long j, long j2) {
                c0928a.b.k(i, j, j2);
            }

            public void b(Handler handler, a aVar) {
                AbstractC20011rK.e(handler);
                AbstractC20011rK.e(aVar);
                e(aVar);
                this.a.add(new C0928a(handler, aVar));
            }

            public void c(final int i, final long j, final long j2) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    final C0928a c0928a = (C0928a) it.next();
                    if (!c0928a.c) {
                        c0928a.a.post(new Runnable() { // from class: ir.nasim.b30
                            @Override // java.lang.Runnable
                            public final void run() {
                                InterfaceC10699c30.a.C0927a.d(c0928a, i, j, j2);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    C0928a c0928a = (C0928a) it.next();
                    if (c0928a.b == aVar) {
                        c0928a.d();
                        this.a.remove(c0928a);
                    }
                }
            }
        }

        void k(int i, long j, long j2);
    }

    default long a() {
        return -9223372036854775807L;
    }

    void c(a aVar);

    InterfaceC25209zu7 d();

    long e();

    void f(Handler handler, a aVar);
}
