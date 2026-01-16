package ir.nasim;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.in, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14967in extends AbstractC21987uU implements InterfaceC6425Nn6, InterfaceC3391Ar2 {
    private InterfaceC6598Oe5 a;
    private final C8572Wn6 b;
    private final View c;
    private final HK5 d;
    private final String e;
    private Rect f = new Rect();
    private AutofillId g;
    private C17325mm4 h;
    private boolean i;

    /* renamed from: ir.nasim.in$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i) {
            super(4);
            this.f = i;
        }

        public final void a(int i, int i2, int i3, int i4) {
            C14967in.this.e().e(C14967in.this.c, this.f, new Rect(i, i2, i3, i4));
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.in$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i) {
            super(4);
            this.f = i;
        }

        public final void a(int i, int i2, int i3, int i4) {
            C14967in.this.e().e(C14967in.this.c, this.f, new Rect(i, i2, i3, i4));
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.in$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC5953Ln6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC5953Ln6 interfaceC5953Ln6) {
            super(4);
            this.f = interfaceC5953Ln6;
        }

        public final void a(int i, int i2, int i3, int i4) {
            C14967in.this.f.set(i, i2, i3, i4);
            C14967in.this.e().c(C14967in.this.c, this.f.d(), C14967in.this.f);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public C14967in(InterfaceC6598Oe5 interfaceC6598Oe5, C8572Wn6 c8572Wn6, View view, HK5 hk5, String str) {
        this.a = interfaceC6598Oe5;
        this.b = c8572Wn6;
        this.c = view;
        this.d = hk5;
        this.e = str;
        view.setImportantForAutofill(1);
        C21330tU c21330tUA = AbstractC14199hW7.a(view);
        AutofillId autofillIdA = c21330tUA != null ? c21330tUA.a() : null;
        if (autofillIdA == null) {
            M73.c("Required value was null.");
            throw new KotlinNothingValueException();
        }
        this.g = autofillIdA;
        this.h = new C17325mm4(0, 1, null);
    }

    @Override // ir.nasim.InterfaceC6425Nn6
    public void a(InterfaceC5953Ln6 interfaceC5953Ln6, SemanticsConfiguration semanticsConfiguration) {
        C13245fu c13245fu;
        C13245fu c13245fu2;
        SemanticsConfiguration semanticsConfigurationE = interfaceC5953Ln6.e();
        int iD = interfaceC5953Ln6.d();
        String strK = (semanticsConfiguration == null || (c13245fu2 = (C13245fu) AbstractC5719Kn6.a(semanticsConfiguration, C8838Xn6.a.o())) == null) ? null : c13245fu2.k();
        String strK2 = (semanticsConfigurationE == null || (c13245fu = (C13245fu) AbstractC5719Kn6.a(semanticsConfigurationE, C8838Xn6.a.o())) == null) ? null : c13245fu.k();
        boolean z = false;
        if (strK != strK2) {
            if (strK == null) {
                this.a.d(this.c, iD, true);
            } else if (strK2 == null) {
                this.a.d(this.c, iD, false);
            } else if (AbstractC13042fc3.d((InterfaceC22143uk1) AbstractC5719Kn6.a(semanticsConfigurationE, C8838Xn6.a.c()), InterfaceC22143uk1.a.a())) {
                this.a.a(this.c, iD, C13582gU.a.b(strK2));
            }
        }
        if (!C15439jb1.g) {
            Boolean bool = semanticsConfiguration != null ? (Boolean) AbstractC5719Kn6.a(semanticsConfiguration, C8838Xn6.a.i()) : null;
            Boolean bool2 = semanticsConfigurationE != null ? (Boolean) AbstractC5719Kn6.a(semanticsConfigurationE, C8838Xn6.a.i()) : null;
            Boolean bool3 = Boolean.TRUE;
            if (!AbstractC13042fc3.d(bool, bool3) && AbstractC13042fc3.d(bool2, bool3) && AbstractC15557jn.d(semanticsConfigurationE)) {
                this.d.d().l(iD, new b(iD));
            }
            if (AbstractC13042fc3.d(bool, bool3) && !AbstractC13042fc3.d(bool2, bool3) && AbstractC15557jn.d(semanticsConfiguration)) {
                this.a.b(this.c, iD);
            }
        }
        boolean z2 = semanticsConfiguration != null && AbstractC15557jn.e(semanticsConfiguration);
        if (semanticsConfigurationE != null && AbstractC15557jn.e(semanticsConfigurationE)) {
            z = true;
        }
        if (z2 != z) {
            if (z) {
                this.h.g(iD);
            } else {
                this.h.r(iD);
            }
        }
    }

    @Override // ir.nasim.InterfaceC3391Ar2
    public void b(androidx.compose.ui.focus.q qVar, androidx.compose.ui.focus.q qVar2) {
        InterfaceC5953Ln6 interfaceC5953Ln6Q;
        SemanticsConfiguration semanticsConfigurationE;
        InterfaceC5953Ln6 interfaceC5953Ln6Q2;
        SemanticsConfiguration semanticsConfigurationE2;
        if (qVar != null && (interfaceC5953Ln6Q2 = KG1.q(qVar)) != null && (semanticsConfigurationE2 = interfaceC5953Ln6Q2.e()) != null && AbstractC15557jn.d(semanticsConfigurationE2)) {
            this.a.b(this.c, interfaceC5953Ln6Q2.d());
        }
        if (qVar2 == null || (interfaceC5953Ln6Q = KG1.q(qVar2)) == null || (semanticsConfigurationE = interfaceC5953Ln6Q.e()) == null || !AbstractC15557jn.d(semanticsConfigurationE)) {
            return;
        }
        int iD = interfaceC5953Ln6Q.d();
        this.d.d().l(iD, new a(iD));
    }

    public final InterfaceC6598Oe5 e() {
        return this.a;
    }

    public final void f(InterfaceC5953Ln6 interfaceC5953Ln6) {
        if (this.h.r(interfaceC5953Ln6.d())) {
            this.a.d(this.c, interfaceC5953Ln6.d(), false);
        }
    }

    public final void g() {
        if (this.h.c() && this.i) {
            this.a.commit();
            this.i = false;
        }
        if (this.h.d()) {
            this.i = true;
        }
    }

    public final void h(InterfaceC5953Ln6 interfaceC5953Ln6) {
        if (this.h.r(interfaceC5953Ln6.d())) {
            this.a.d(this.c, interfaceC5953Ln6.d(), false);
        }
    }

    public final void i(InterfaceC5953Ln6 interfaceC5953Ln6) {
        SemanticsConfiguration semanticsConfigurationE = interfaceC5953Ln6.e();
        if (semanticsConfigurationE == null || !AbstractC15557jn.e(semanticsConfigurationE)) {
            return;
        }
        this.h.g(interfaceC5953Ln6.d());
        this.a.d(this.c, interfaceC5953Ln6.d(), true);
    }

    public final void j(InterfaceC5953Ln6 interfaceC5953Ln6, int i) {
        if (this.h.r(i)) {
            this.a.d(this.c, i, false);
        }
        SemanticsConfiguration semanticsConfigurationE = interfaceC5953Ln6.e();
        if (semanticsConfigurationE == null || !AbstractC15557jn.e(semanticsConfigurationE)) {
            return;
        }
        this.h.g(interfaceC5953Ln6.d());
        this.a.d(this.c, interfaceC5953Ln6.d(), true);
    }

    public final void k(SparseArray sparseArray) {
        SemanticsConfiguration semanticsConfigurationE;
        C20450s2 c20450s2;
        UA2 ua2;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            AutofillValue autofillValueA = AbstractC14359hn.a(sparseArray.get(iKeyAt));
            C13582gU c13582gU = C13582gU.a;
            if (c13582gU.e(autofillValueA)) {
                InterfaceC5953Ln6 interfaceC5953Ln6A = this.b.a(iKeyAt);
                if (interfaceC5953Ln6A != null && (semanticsConfigurationE = interfaceC5953Ln6A.e()) != null && (c20450s2 = (C20450s2) AbstractC5719Kn6.a(semanticsConfigurationE, C5485Jn6.a.k())) != null && (ua2 = (UA2) c20450s2.a()) != null) {
                }
            } else if (c13582gU.c(autofillValueA)) {
                Log.w("ComposeAutofillManager", "Auto filling Date fields is not yet supported.");
            } else if (c13582gU.d(autofillValueA)) {
                Log.w("ComposeAutofillManager", "Auto filling dropdown lists is not yet supported.");
            } else if (c13582gU.f(autofillValueA)) {
                Log.w("ComposeAutofillManager", "Auto filling toggle fields are not yet supported.");
            }
        }
    }

    public final void l(ViewStructure viewStructure) {
        C13582gU c13582gU = C13582gU.a;
        InterfaceC5953Ln6 interfaceC5953Ln6C = this.b.c();
        AbstractC6140Mi5.a(viewStructure, interfaceC5953Ln6C, this.g, this.e, this.d);
        C3587Bm4 c3587Bm4H = AbstractC23642xG4.h(interfaceC5953Ln6C, viewStructure);
        while (c3587Bm4H.h()) {
            Object objA = c3587Bm4H.A(c3587Bm4H.b - 1);
            AbstractC13042fc3.g(objA, "null cannot be cast to non-null type android.view.ViewStructure");
            ViewStructure viewStructure2 = (ViewStructure) objA;
            Object objA2 = c3587Bm4H.A(c3587Bm4H.b - 1);
            AbstractC13042fc3.g(objA2, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsInfo");
            List listT = ((InterfaceC5953Ln6) objA2).t();
            int size = listT.size();
            for (int i = 0; i < size; i++) {
                InterfaceC5953Ln6 interfaceC5953Ln6 = (InterfaceC5953Ln6) listT.get(i);
                if (!interfaceC5953Ln6.u() && interfaceC5953Ln6.b() && interfaceC5953Ln6.o()) {
                    SemanticsConfiguration semanticsConfigurationE = interfaceC5953Ln6.e();
                    if (semanticsConfigurationE == null || !AbstractC15557jn.f(semanticsConfigurationE)) {
                        c3587Bm4H.n(interfaceC5953Ln6);
                        c3587Bm4H.n(viewStructure2);
                    } else {
                        ViewStructure viewStructureG = c13582gU.g(viewStructure2, c13582gU.a(viewStructure2, 1));
                        AbstractC6140Mi5.a(viewStructureG, interfaceC5953Ln6, this.g, this.e, this.d);
                        c3587Bm4H.n(interfaceC5953Ln6);
                        c3587Bm4H.n(viewStructureG);
                    }
                }
            }
        }
    }

    public final void m(InterfaceC5953Ln6 interfaceC5953Ln6) {
        this.d.d().l(interfaceC5953Ln6.d(), new c(interfaceC5953Ln6));
    }
}
