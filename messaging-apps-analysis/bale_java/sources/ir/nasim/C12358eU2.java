package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;

/* renamed from: ir.nasim.eU2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12358eU2 {
    public static final C12358eU2 a = new C12358eU2();

    /* renamed from: ir.nasim.eU2$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C11637dL5 e;
        final /* synthetic */ C11637dL5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C11637dL5 c11637dL5, C11637dL5 c11637dL52) {
            super(1);
            this.e = c11637dL5;
            this.f = c11637dL52;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(OU3 ou3) {
            C11637dL5 c11637dL5 = this.e;
            if (c11637dL5.a == -1) {
                c11637dL5.a = ou3.c().o();
            }
            this.f.a = ou3.c().t() + 1;
            return "";
        }
    }

    private C12358eU2() {
    }

    private final int b(HandwritingGesture handwritingGesture, UA2 ua2) {
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        ua2.invoke(new UZ0(fallbackText, 1));
        return 5;
    }

    private final int c(C6542Ny3 c6542Ny3, DeleteGesture deleteGesture, C13245fu c13245fu, UA2 ua2) {
        int iT = t(deleteGesture.getGranularity());
        long jR = AbstractC12967fU2.r(c6542Ny3, EK5.f(deleteGesture.getDeletionArea()), iT, InterfaceC5243Im7.a.h());
        if (C4301En7.h(jR)) {
            return a.b(OT2.a(deleteGesture), ua2);
        }
        e(jR, c13245fu, AbstractC4058Dm7.d(iT, AbstractC4058Dm7.a.b()), ua2);
        return 1;
    }

    private final int d(C6542Ny3 c6542Ny3, DeleteRangeGesture deleteRangeGesture, C13245fu c13245fu, UA2 ua2) {
        int iT = t(deleteRangeGesture.getGranularity());
        long jS = AbstractC12967fU2.s(c6542Ny3, EK5.f(deleteRangeGesture.getDeletionStartArea()), EK5.f(deleteRangeGesture.getDeletionEndArea()), iT, InterfaceC5243Im7.a.h());
        if (C4301En7.h(jS)) {
            return a.b(OT2.a(deleteRangeGesture), ua2);
        }
        e(jS, c13245fu, AbstractC4058Dm7.d(iT, AbstractC4058Dm7.a.b()), ua2);
        return 1;
    }

    private final void e(long j, C13245fu c13245fu, boolean z, UA2 ua2) {
        if (z) {
            j = AbstractC12967fU2.j(j, c13245fu);
        }
        ua2.invoke(AbstractC12967fU2.k(new C24024xu6(C4301En7.i(j), C4301En7.i(j)), new KH1(C4301En7.j(j), 0)));
    }

    private final int g(C6542Ny3 c6542Ny3, InsertGesture insertGesture, InterfaceC18354oW7 interfaceC18354oW7, UA2 ua2) {
        C14367hn7 c14367hn7L;
        C13774gn7 c13774gn7F;
        if (interfaceC18354oW7 == null) {
            return b(OT2.a(insertGesture), ua2);
        }
        int iN = AbstractC12967fU2.n(c6542Ny3, AbstractC12967fU2.z(insertGesture.getInsertionPoint()), interfaceC18354oW7);
        if (iN == -1 || !((c14367hn7L = c6542Ny3.l()) == null || (c13774gn7F = c14367hn7L.f()) == null || !AbstractC12967fU2.t(c13774gn7F, iN))) {
            return b(OT2.a(insertGesture), ua2);
        }
        h(iN, insertGesture.getTextToInsert(), ua2);
        return 1;
    }

    private final void h(int i, String str, UA2 ua2) {
        ua2.invoke(AbstractC12967fU2.k(new C24024xu6(i, i), new UZ0(str, 1)));
    }

    private final int i(C6542Ny3 c6542Ny3, JoinOrSplitGesture joinOrSplitGesture, C13245fu c13245fu, InterfaceC18354oW7 interfaceC18354oW7, UA2 ua2) {
        C14367hn7 c14367hn7L;
        C13774gn7 c13774gn7F;
        if (interfaceC18354oW7 == null) {
            return b(OT2.a(joinOrSplitGesture), ua2);
        }
        int iN = AbstractC12967fU2.n(c6542Ny3, AbstractC12967fU2.z(joinOrSplitGesture.getJoinOrSplitPoint()), interfaceC18354oW7);
        if (iN == -1 || !((c14367hn7L = c6542Ny3.l()) == null || (c13774gn7F = c14367hn7L.f()) == null || !AbstractC12967fU2.t(c13774gn7F, iN))) {
            return b(OT2.a(joinOrSplitGesture), ua2);
        }
        long jY = AbstractC12967fU2.y(c13245fu, iN);
        if (C4301En7.h(jY)) {
            h(C4301En7.n(jY), Separators.SP, ua2);
        } else {
            e(jY, c13245fu, false, ua2);
        }
        return 1;
    }

    private final int j(C6542Ny3 c6542Ny3, RemoveSpaceGesture removeSpaceGesture, C13245fu c13245fu, InterfaceC18354oW7 interfaceC18354oW7, UA2 ua2) {
        C14367hn7 c14367hn7L = c6542Ny3.l();
        long jP = AbstractC12967fU2.p(c14367hn7L != null ? c14367hn7L.f() : null, AbstractC12967fU2.z(removeSpaceGesture.getStartPoint()), AbstractC12967fU2.z(removeSpaceGesture.getEndPoint()), c6542Ny3.k(), interfaceC18354oW7);
        if (C4301En7.h(jP)) {
            return a.b(OT2.a(removeSpaceGesture), ua2);
        }
        C11637dL5 c11637dL5 = new C11637dL5();
        c11637dL5.a = -1;
        C11637dL5 c11637dL52 = new C11637dL5();
        c11637dL52.a = -1;
        String strJ = new C20644sM5("\\s+").j(AbstractC4535Fn7.e(c13245fu, jP), new a(c11637dL5, c11637dL52));
        if (c11637dL5.a == -1 || c11637dL52.a == -1) {
            return b(OT2.a(removeSpaceGesture), ua2);
        }
        int iN = C4301En7.n(jP) + c11637dL5.a;
        int iN2 = C4301En7.n(jP) + c11637dL52.a;
        String strSubstring = strJ.substring(c11637dL5.a, strJ.length() - (C4301En7.j(jP) - c11637dL52.a));
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        ua2.invoke(AbstractC12967fU2.k(new C24024xu6(iN, iN2), new UZ0(strSubstring, 1)));
        return 1;
    }

    private final int k(C6542Ny3 c6542Ny3, SelectGesture selectGesture, C19101pm7 c19101pm7, UA2 ua2) {
        long jR = AbstractC12967fU2.r(c6542Ny3, EK5.f(selectGesture.getSelectionArea()), t(selectGesture.getGranularity()), InterfaceC5243Im7.a.h());
        if (C4301En7.h(jR)) {
            return a.b(OT2.a(selectGesture), ua2);
        }
        m(jR, c19101pm7, ua2);
        return 1;
    }

    private final int l(C6542Ny3 c6542Ny3, SelectRangeGesture selectRangeGesture, C19101pm7 c19101pm7, UA2 ua2) {
        long jS = AbstractC12967fU2.s(c6542Ny3, EK5.f(selectRangeGesture.getSelectionStartArea()), EK5.f(selectRangeGesture.getSelectionEndArea()), t(selectRangeGesture.getGranularity()), InterfaceC5243Im7.a.h());
        if (C4301En7.h(jS)) {
            return a.b(OT2.a(selectRangeGesture), ua2);
        }
        m(jS, c19101pm7, ua2);
        return 1;
    }

    private final void m(long j, C19101pm7 c19101pm7, UA2 ua2) {
        ua2.invoke(new C24024xu6(C4301En7.n(j), C4301En7.i(j)));
        if (c19101pm7 != null) {
            c19101pm7.x(true);
        }
    }

    private final void n(C6542Ny3 c6542Ny3, DeleteGesture deleteGesture, C19101pm7 c19101pm7) {
        if (c19101pm7 != null) {
            c19101pm7.e0(AbstractC12967fU2.r(c6542Ny3, EK5.f(deleteGesture.getDeletionArea()), t(deleteGesture.getGranularity()), InterfaceC5243Im7.a.h()));
        }
    }

    private final void o(C6542Ny3 c6542Ny3, DeleteRangeGesture deleteRangeGesture, C19101pm7 c19101pm7) {
        if (c19101pm7 != null) {
            c19101pm7.e0(AbstractC12967fU2.s(c6542Ny3, EK5.f(deleteRangeGesture.getDeletionStartArea()), EK5.f(deleteRangeGesture.getDeletionEndArea()), t(deleteRangeGesture.getGranularity()), InterfaceC5243Im7.a.h()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(C19101pm7 c19101pm7) {
        if (c19101pm7 != null) {
            c19101pm7.p();
        }
    }

    private final void r(C6542Ny3 c6542Ny3, SelectGesture selectGesture, C19101pm7 c19101pm7) {
        if (c19101pm7 != null) {
            c19101pm7.o0(AbstractC12967fU2.r(c6542Ny3, EK5.f(selectGesture.getSelectionArea()), t(selectGesture.getGranularity()), InterfaceC5243Im7.a.h()));
        }
    }

    private final void s(C6542Ny3 c6542Ny3, SelectRangeGesture selectRangeGesture, C19101pm7 c19101pm7) {
        if (c19101pm7 != null) {
            c19101pm7.o0(AbstractC12967fU2.s(c6542Ny3, EK5.f(selectRangeGesture.getSelectionStartArea()), EK5.f(selectRangeGesture.getSelectionEndArea()), t(selectRangeGesture.getGranularity()), InterfaceC5243Im7.a.h()));
        }
    }

    private final int t(int i) {
        return i != 1 ? i != 2 ? AbstractC4058Dm7.a.a() : AbstractC4058Dm7.a.a() : AbstractC4058Dm7.a.b();
    }

    public final int f(C6542Ny3 c6542Ny3, HandwritingGesture handwritingGesture, C19101pm7 c19101pm7, InterfaceC18354oW7 interfaceC18354oW7, UA2 ua2) {
        C13774gn7 c13774gn7F;
        C13183fn7 c13183fn7L;
        C13245fu c13245fuY = c6542Ny3.y();
        if (c13245fuY == null) {
            return 3;
        }
        C14367hn7 c14367hn7L = c6542Ny3.l();
        if (!AbstractC13042fc3.d(c13245fuY, (c14367hn7L == null || (c13774gn7F = c14367hn7L.f()) == null || (c13183fn7L = c13774gn7F.l()) == null) ? null : c13183fn7L.j())) {
            return 3;
        }
        if (AbstractC24347yT2.a(handwritingGesture)) {
            return k(c6542Ny3, JT2.a(handwritingGesture), c19101pm7, ua2);
        }
        if (UT2.a(handwritingGesture)) {
            return c(c6542Ny3, WT2.a(handwritingGesture), c13245fuY, ua2);
        }
        if (XT2.a(handwritingGesture)) {
            return l(c6542Ny3, YT2.a(handwritingGesture), c19101pm7, ua2);
        }
        if (ZT2.a(handwritingGesture)) {
            return d(c6542Ny3, AbstractC9741aU2.a(handwritingGesture), c13245fuY, ua2);
        }
        if (GT2.a(handwritingGesture)) {
            return i(c6542Ny3, HT2.a(handwritingGesture), c13245fuY, interfaceC18354oW7, ua2);
        }
        if (CT2.a(handwritingGesture)) {
            return g(c6542Ny3, DT2.a(handwritingGesture), interfaceC18354oW7, ua2);
        }
        if (ET2.a(handwritingGesture)) {
            return j(c6542Ny3, FT2.a(handwritingGesture), c13245fuY, interfaceC18354oW7, ua2);
        }
        return 2;
    }

    public final boolean p(C6542Ny3 c6542Ny3, PreviewableHandwritingGesture previewableHandwritingGesture, final C19101pm7 c19101pm7, CancellationSignal cancellationSignal) {
        C13774gn7 c13774gn7F;
        C13183fn7 c13183fn7L;
        C13245fu c13245fuY = c6542Ny3.y();
        if (c13245fuY == null) {
            return false;
        }
        C14367hn7 c14367hn7L = c6542Ny3.l();
        if (!AbstractC13042fc3.d(c13245fuY, (c14367hn7L == null || (c13774gn7F = c14367hn7L.f()) == null || (c13183fn7L = c13774gn7F.l()) == null) ? null : c13183fn7L.j())) {
            return false;
        }
        if (AbstractC24347yT2.a(previewableHandwritingGesture)) {
            r(c6542Ny3, JT2.a(previewableHandwritingGesture), c19101pm7);
        } else if (UT2.a(previewableHandwritingGesture)) {
            n(c6542Ny3, WT2.a(previewableHandwritingGesture), c19101pm7);
        } else if (XT2.a(previewableHandwritingGesture)) {
            s(c6542Ny3, YT2.a(previewableHandwritingGesture), c19101pm7);
        } else {
            if (!ZT2.a(previewableHandwritingGesture)) {
                return false;
            }
            o(c6542Ny3, AbstractC9741aU2.a(previewableHandwritingGesture), c19101pm7);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: ir.nasim.dU2
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                C12358eU2.q(c19101pm7);
            }
        });
        return true;
    }
}
