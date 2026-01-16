package ir.nasim;

import android.graphics.Point;
import android.view.ScrollCaptureTarget;
import android.view.View;
import ir.nasim.ScrollCaptureCallbackC13648gb1;
import java.util.function.Consumer;

/* renamed from: ir.nasim.Od6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6590Od6 implements ScrollCaptureCallbackC13648gb1.a {
    private final InterfaceC9102Ym4 a = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);

    /* renamed from: ir.nasim.Od6$a */
    /* synthetic */ class a extends C23553x7 implements UA2 {
        a(Object obj) {
            super(1, obj, C12544en4.class, "add", "add(Ljava/lang/Object;)Z", 8);
        }

        public final void a(C6829Pd6 c6829Pd6) {
            ((C12544en4) this.a).d(c6829Pd6);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C6829Pd6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Od6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Comparable invoke(C6829Pd6 c6829Pd6) {
            return Integer.valueOf(c6829Pd6.b());
        }
    }

    /* renamed from: ir.nasim.Od6$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Comparable invoke(C6829Pd6 c6829Pd6) {
            return Integer.valueOf(c6829Pd6.d().f());
        }
    }

    private final void e(boolean z) {
        this.a.setValue(Boolean.valueOf(z));
    }

    @Override // ir.nasim.ScrollCaptureCallbackC13648gb1.a
    public void a() {
        e(true);
    }

    @Override // ir.nasim.ScrollCaptureCallbackC13648gb1.a
    public void b() {
        e(false);
    }

    public final boolean c() {
        return ((Boolean) this.a.getValue()).booleanValue();
    }

    public final void d(View view, C8572Wn6 c8572Wn6, InterfaceC11938do1 interfaceC11938do1, Consumer consumer) {
        C12544en4 c12544en4 = new C12544en4(new C6829Pd6[16], 0);
        AbstractC7073Qd6.e(c8572Wn6.d(), 0, new a(c12544en4), 2, null);
        c12544en4.C(AbstractC18050o01.b(b.e, c.e));
        C6829Pd6 c6829Pd6 = (C6829Pd6) (c12544en4.o() != 0 ? c12544en4.a[c12544en4.o() - 1] : null);
        if (c6829Pd6 == null) {
            return;
        }
        ScrollCaptureCallbackC13648gb1 scrollCaptureCallbackC13648gb1 = new ScrollCaptureCallbackC13648gb1(c6829Pd6.c(), c6829Pd6.d(), AbstractC20906so1.a(interfaceC11938do1), this, view);
        CK5 ck5B = AbstractC12000du3.b(c6829Pd6.a());
        long jK = c6829Pd6.d().k();
        ScrollCaptureTarget scrollCaptureTargetA = AbstractC6335Nd6.a(view, EK5.a(AbstractC3239Aa3.b(ck5B)), new Point(C22045ua3.k(jK), C22045ua3.l(jK)), AbstractC5863Ld6.a(scrollCaptureCallbackC13648gb1));
        scrollCaptureTargetA.setScrollBounds(EK5.a(c6829Pd6.d()));
        consumer.accept(scrollCaptureTargetA);
    }
}
