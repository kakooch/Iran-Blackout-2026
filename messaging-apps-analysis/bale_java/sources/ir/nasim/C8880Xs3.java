package ir.nasim;

import io.reactivex.rxjava3.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.Xs3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C8880Xs3 extends AtomicReference implements PG4, GV1 {
    final InterfaceC23859xe1 a;
    final InterfaceC23859xe1 b;
    final H4 c;
    final InterfaceC23859xe1 d;

    public C8880Xs3(InterfaceC23859xe1 interfaceC23859xe1, InterfaceC23859xe1 interfaceC23859xe12, H4 h4, InterfaceC23859xe1 interfaceC23859xe13) {
        this.a = interfaceC23859xe1;
        this.b = interfaceC23859xe12;
        this.c = h4;
        this.d = interfaceC23859xe13;
    }

    @Override // ir.nasim.PG4
    public void a(Throwable th) {
        if (d()) {
            D76.d(th);
            return;
        }
        lazySet(OV1.DISPOSED);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            AbstractC14250hc2.b(th2);
            D76.d(new CompositeException(th, th2));
        }
    }

    @Override // ir.nasim.PG4
    public void b(GV1 gv1) {
        if (OV1.r(this, gv1)) {
            try {
                this.d.accept(this);
            } catch (Throwable th) {
                AbstractC14250hc2.b(th);
                gv1.dispose();
                a(th);
            }
        }
    }

    @Override // ir.nasim.PG4
    public void c() {
        if (d()) {
            return;
        }
        lazySet(OV1.DISPOSED);
        try {
            this.c.run();
        } catch (Throwable th) {
            AbstractC14250hc2.b(th);
            D76.d(th);
        }
    }

    public boolean d() {
        return get() == OV1.DISPOSED;
    }

    @Override // ir.nasim.GV1
    public void dispose() {
        OV1.a(this);
    }

    @Override // ir.nasim.PG4
    public void e(Object obj) {
        if (d()) {
            return;
        }
        try {
            this.a.accept(obj);
        } catch (Throwable th) {
            AbstractC14250hc2.b(th);
            ((GV1) get()).dispose();
            a(th);
        }
    }
}
