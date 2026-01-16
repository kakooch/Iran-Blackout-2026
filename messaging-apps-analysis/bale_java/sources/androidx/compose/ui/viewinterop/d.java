package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.ui.e;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.h;
import androidx.compose.ui.focus.k;
import androidx.compose.ui.focus.s;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.C12544en4;
import ir.nasim.C15439jb1;
import ir.nasim.C19938rB7;
import ir.nasim.C6468Nr2;
import ir.nasim.InterfaceC20346rr2;
import ir.nasim.InterfaceC23714xO4;
import ir.nasim.InterfaceC4566Fr2;
import ir.nasim.InterfaceC4815Gr2;
import ir.nasim.KG1;
import ir.nasim.LG1;
import ir.nasim.M73;
import ir.nasim.RG1;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
final class d extends e.c implements InterfaceC4815Gr2, ViewTreeObserver.OnGlobalFocusChangeListener {
    private View o;
    private ViewTreeObserver p;
    private final UA2 q = new a();
    private final UA2 r = new b();

    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(InterfaceC20346rr2 interfaceC20346rr2) {
            View viewG = c.g(d.this);
            if (viewG.isFocused() || viewG.hasFocus()) {
                return;
            }
            if (h.b(viewG, h.c(interfaceC20346rr2.b()), c.f(KG1.p(d.this).getFocusOwner(), LG1.a(d.this), viewG))) {
                return;
            }
            interfaceC20346rr2.a();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC20346rr2) obj);
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(InterfaceC20346rr2 interfaceC20346rr2) {
            View viewFindNextFocusFromRect;
            View viewG = c.g(d.this);
            if (C15439jb1.e) {
                if (viewG.hasFocus() || viewG.isFocused()) {
                    viewG.clearFocus();
                    return;
                }
                return;
            }
            if (viewG.hasFocus()) {
                InterfaceC4566Fr2 focusOwner = KG1.p(d.this).getFocusOwner();
                View viewA = LG1.a(d.this);
                if (!(viewG instanceof ViewGroup)) {
                    if (!viewA.requestFocus()) {
                        throw new IllegalStateException("host view did not take focus".toString());
                    }
                    return;
                }
                Rect rectF = c.f(focusOwner, viewA, viewG);
                Integer numC = h.c(interfaceC20346rr2.b());
                int iIntValue = numC != null ? numC.intValue() : 130;
                FocusFinder focusFinder = FocusFinder.getInstance();
                d dVar = d.this;
                if (dVar.w2() != null) {
                    AbstractC13042fc3.g(viewA, "null cannot be cast to non-null type android.view.ViewGroup");
                    viewFindNextFocusFromRect = focusFinder.findNextFocus((ViewGroup) viewA, dVar.w2(), iIntValue);
                } else {
                    AbstractC13042fc3.g(viewA, "null cannot be cast to non-null type android.view.ViewGroup");
                    viewFindNextFocusFromRect = focusFinder.findNextFocusFromRect((ViewGroup) viewA, rectF, iIntValue);
                }
                if (viewFindNextFocusFromRect == null || !c.d(viewG, viewFindNextFocusFromRect)) {
                    if (!viewA.requestFocus()) {
                        throw new IllegalStateException("host view did not take focus".toString());
                    }
                } else {
                    viewFindNextFocusFromRect.requestFocus(iIntValue, rectF);
                    interfaceC20346rr2.a();
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC20346rr2) obj);
            return C19938rB7.a;
        }
    }

    private final FocusTargetNode v2() {
        int iA = AbstractC9572aB4.a(1024);
        if (!h().b2()) {
            M73.b("visitLocalDescendants called on an unattached node");
        }
        e.c cVarH = h();
        if ((cVarH.R1() & iA) != 0) {
            boolean z = false;
            for (e.c cVarS1 = cVarH.S1(); cVarS1 != null; cVarS1 = cVarS1.S1()) {
                if ((cVarS1.W1() & iA) != 0) {
                    e.c cVarH2 = cVarS1;
                    C12544en4 c12544en4 = null;
                    while (cVarH2 != null) {
                        if (cVarH2 instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) cVarH2;
                            if (z) {
                                return focusTargetNode;
                            }
                            z = true;
                        } else if ((cVarH2.W1() & iA) != 0 && (cVarH2 instanceof RG1)) {
                            int i = 0;
                            for (e.c cVarW2 = ((RG1) cVarH2).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                if ((cVarW2.W1() & iA) != 0) {
                                    i++;
                                    if (i == 1) {
                                        cVarH2 = cVarW2;
                                    } else {
                                        if (c12544en4 == null) {
                                            c12544en4 = new C12544en4(new e.c[16], 0);
                                        }
                                        if (cVarH2 != null) {
                                            c12544en4.d(cVarH2);
                                            cVarH2 = null;
                                        }
                                        c12544en4.d(cVarW2);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        cVarH2 = KG1.h(c12544en4);
                    }
                }
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper".toString());
    }

    @Override // ir.nasim.InterfaceC4815Gr2
    public void b1(k kVar) {
        kVar.u(false);
        kVar.q(this.q);
        kVar.x(this.r);
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        super.e2();
        ViewTreeObserver viewTreeObserver = LG1.a(this).getViewTreeObserver();
        this.p = viewTreeObserver;
        viewTreeObserver.addOnGlobalFocusChangeListener(this);
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        ViewTreeObserver viewTreeObserver = this.p;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalFocusChangeListener(this);
        }
        this.p = null;
        LG1.a(this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        this.o = null;
        super.f2();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view, View view2) {
        if (KG1.o(this).z0() == null) {
            return;
        }
        View viewG = c.g(this);
        InterfaceC4566Fr2 focusOwner = KG1.p(this).getFocusOwner();
        InterfaceC23714xO4 interfaceC23714xO4P = KG1.p(this);
        boolean z = (view == null || AbstractC13042fc3.d(view, interfaceC23714xO4P) || !c.d(viewG, view)) ? false : true;
        boolean z2 = (view2 == null || AbstractC13042fc3.d(view2, interfaceC23714xO4P) || !c.d(viewG, view2)) ? false : true;
        if (z && z2) {
            this.o = view2;
            return;
        }
        if (!z2) {
            if (!z) {
                this.o = null;
                return;
            }
            this.o = null;
            if (v2().W().a()) {
                focusOwner.o(false, true, false, androidx.compose.ui.focus.d.b.c());
                return;
            }
            return;
        }
        this.o = view2;
        FocusTargetNode focusTargetNodeV2 = v2();
        if (focusTargetNodeV2.W().j()) {
            return;
        }
        if (C15439jb1.g) {
            s.j(focusTargetNodeV2);
            return;
        }
        C6468Nr2 c6468Nr2E = focusOwner.e();
        try {
            if (c6468Nr2E.i()) {
                c6468Nr2E.f();
            }
            c6468Nr2E.e();
            s.j(focusTargetNodeV2);
            c6468Nr2E.g();
        } catch (Throwable th) {
            c6468Nr2E.g();
            throw th;
        }
    }

    public final View w2() {
        return this.o;
    }
}
