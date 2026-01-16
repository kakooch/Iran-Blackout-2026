package ir.nasim;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import ir.nasim.AbstractC5581Jy3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Oy3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6781Oy3 implements InterfaceC20227rf5 {
    private final View a;
    private final InterfaceC19915r93 b;
    private C6542Ny3 e;
    private C19101pm7 f;
    private InterfaceC18354oW7 g;
    private Rect l;
    private final C22282uy3 m;
    private UA2 c = c.e;
    private UA2 d = d.e;
    private C23945xm7 h = new C23945xm7("", C4301En7.b.a(), (C4301En7) null, 4, (ED1) null);
    private T33 i = T33.g.a();
    private List j = new ArrayList();
    private final InterfaceC9173Yu3 k = AbstractC13269fw3.b(EnumC4870Gx3.c, new a());

    /* renamed from: ir.nasim.Oy3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BaseInputConnection invoke() {
            return new BaseInputConnection(C6781Oy3.this.i(), false);
        }
    }

    /* renamed from: ir.nasim.Oy3$b */
    public static final class b implements InterfaceC16960m93 {
        b() {
        }

        @Override // ir.nasim.InterfaceC16960m93
        public void a(KeyEvent keyEvent) {
            C6781Oy3.this.h().sendKeyEvent(keyEvent);
        }

        @Override // ir.nasim.InterfaceC16960m93
        public void b(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            C6781Oy3.this.m.b(z, z2, z3, z4, z5, z6);
        }

        @Override // ir.nasim.InterfaceC16960m93
        public void c(int i) {
            C6781Oy3.this.d.invoke(S33.j(i));
        }

        @Override // ir.nasim.InterfaceC16960m93
        public void d(List list) {
            C6781Oy3.this.c.invoke(list);
        }

        @Override // ir.nasim.InterfaceC16960m93
        public void e(InputConnectionC10864cK5 inputConnectionC10864cK5) {
            int size = C6781Oy3.this.j.size();
            for (int i = 0; i < size; i++) {
                if (AbstractC13042fc3.d(((WeakReference) C6781Oy3.this.j.get(i)).get(), inputConnectionC10864cK5)) {
                    C6781Oy3.this.j.remove(i);
                    return;
                }
            }
        }
    }

    public C6781Oy3(View view, UA2 ua2, InterfaceC19915r93 interfaceC19915r93) {
        this.a = view;
        this.b = interfaceC19915r93;
        this.m = new C22282uy3(ua2, interfaceC19915r93);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection h() {
        return (BaseInputConnection) this.k.getValue();
    }

    private final void k() {
        this.b.d();
    }

    @Override // ir.nasim.InterfaceC20227rf5
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public InputConnectionC10864cK5 a(EditorInfo editorInfo) {
        AbstractC10105b52.c(editorInfo, this.h.h(), this.h.g(), this.i, null, 8, null);
        AbstractC5815Ky3.d(editorInfo);
        InputConnectionC10864cK5 inputConnectionC10864cK5 = new InputConnectionC10864cK5(this.h, new b(), this.i.b(), this.e, this.f, this.g);
        this.j.add(new WeakReference(inputConnectionC10864cK5));
        return inputConnectionC10864cK5;
    }

    public final View i() {
        return this.a;
    }

    public final void j(CK5 ck5) {
        Rect rect;
        this.l = new Rect(AbstractC20723sV3.d(ck5.i()), AbstractC20723sV3.d(ck5.l()), AbstractC20723sV3.d(ck5.j()), AbstractC20723sV3.d(ck5.e()));
        if (!this.j.isEmpty() || (rect = this.l) == null) {
            return;
        }
        this.a.requestRectangleOnScreen(new Rect(rect));
    }

    public final void l(C23945xm7 c23945xm7, AbstractC5581Jy3.a aVar, T33 t33, UA2 ua2, UA2 ua22) {
        this.h = c23945xm7;
        this.i = t33;
        this.c = ua2;
        this.d = ua22;
        this.e = aVar != null ? aVar.K1() : null;
        this.f = aVar != null ? aVar.h1() : null;
        this.g = aVar != null ? aVar.getViewConfiguration() : null;
    }

    public final void m(C23945xm7 c23945xm7, C23945xm7 c23945xm72) {
        boolean z = (C4301En7.g(this.h.g(), c23945xm72.g()) && AbstractC13042fc3.d(this.h.f(), c23945xm72.f())) ? false : true;
        this.h = c23945xm72;
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            InputConnectionC10864cK5 inputConnectionC10864cK5 = (InputConnectionC10864cK5) ((WeakReference) this.j.get(i)).get();
            if (inputConnectionC10864cK5 != null) {
                inputConnectionC10864cK5.g(c23945xm72);
            }
        }
        this.m.a();
        if (AbstractC13042fc3.d(c23945xm7, c23945xm72)) {
            if (z) {
                InterfaceC19915r93 interfaceC19915r93 = this.b;
                int iL = C4301En7.l(c23945xm72.g());
                int iK = C4301En7.k(c23945xm72.g());
                C4301En7 c4301En7F = this.h.f();
                int iL2 = c4301En7F != null ? C4301En7.l(c4301En7F.r()) : -1;
                C4301En7 c4301En7F2 = this.h.f();
                interfaceC19915r93.c(iL, iK, iL2, c4301En7F2 != null ? C4301En7.k(c4301En7F2.r()) : -1);
                return;
            }
            return;
        }
        if (c23945xm7 != null && (!AbstractC13042fc3.d(c23945xm7.h(), c23945xm72.h()) || (C4301En7.g(c23945xm7.g(), c23945xm72.g()) && !AbstractC13042fc3.d(c23945xm7.f(), c23945xm72.f())))) {
            k();
            return;
        }
        int size2 = this.j.size();
        for (int i2 = 0; i2 < size2; i2++) {
            InputConnectionC10864cK5 inputConnectionC10864cK52 = (InputConnectionC10864cK5) ((WeakReference) this.j.get(i2)).get();
            if (inputConnectionC10864cK52 != null) {
                inputConnectionC10864cK52.h(this.h, this.b);
            }
        }
    }

    public final void n(C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, C13774gn7 c13774gn7, CK5 ck5, CK5 ck52) {
        this.m.d(c23945xm7, interfaceC11600dH4, c13774gn7, ck5, ck52);
    }

    /* renamed from: ir.nasim.Oy3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return C19938rB7.a;
        }

        public final void a(List list) {
        }
    }

    /* renamed from: ir.nasim.Oy3$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((S33) obj).p());
            return C19938rB7.a;
        }

        public final void a(int i) {
        }
    }
}
