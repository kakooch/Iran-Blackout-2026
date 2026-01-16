package ir.nasim;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import androidx.appcompat.widget.AppCompatSeekBar;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* loaded from: classes5.dex */
public final class YL extends AbstractC22597vW1 {
    private final C13519gN a;
    private final AbstractC17757nW1.a b;
    private final AppCompatSeekBar c;
    private final BubbleTextView d;
    private final BubbleTextView e;
    private final UA2 f;
    private final UA2 g;
    private String h;

    public YL(C13519gN c13519gN, AbstractC17757nW1.a aVar, AppCompatSeekBar appCompatSeekBar, BubbleTextView bubbleTextView, BubbleTextView bubbleTextView2, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(c13519gN, "audioDataBase");
        AbstractC13042fc3.i(aVar, "document");
        AbstractC13042fc3.i(appCompatSeekBar, "audioSeekbar");
        AbstractC13042fc3.i(bubbleTextView, "audioArtistTextView");
        AbstractC13042fc3.i(bubbleTextView2, "audioDetailsTextView");
        AbstractC13042fc3.i(ua2, "setSeekbarOnTouchListener");
        AbstractC13042fc3.i(ua22, "resetDurationMetaData");
        this.a = c13519gN;
        this.b = aVar;
        this.c = appCompatSeekBar;
        this.d = bubbleTextView;
        this.e = bubbleTextView2;
        this.f = ua2;
        this.g = ua22;
        this.h = A(aVar.e().b());
    }

    private final String A(long j) {
        return XY6.v(C17959nq7.a.a((int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)));
    }

    private final SpannableStringBuilder B() {
        long jO = C23709xO.a.O();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) XY6.v(C17959nq7.a.a((int) (jO / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT))));
        spannableStringBuilder.append((CharSequence) " / ");
        spannableStringBuilder.append((CharSequence) this.h);
        return spannableStringBuilder;
    }

    private final boolean C(VL vl) {
        VL vlM = C23709xO.a.M();
        return AbstractC13042fc3.d(vlM != null ? vlM.d() : null, vl.d());
    }

    private final void D(View view, boolean z, boolean z2) {
        if (z2) {
            view.setVisibility(z ? 0 : 8);
        } else {
            view.setVisibility(z ^ true ? 4 : 0);
        }
    }

    private final void E(String str, final float f) {
        if (this.b.g() && (this.b.e() instanceof C8552Wl4)) {
            this.a.K(str, new UA2() { // from class: ir.nasim.WL
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return YL.F(this.a, f, (QN) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(final YL yl, final float f, final QN qn) {
        AbstractC13042fc3.i(yl, "this$0");
        if (qn == null) {
            return C19938rB7.a;
        }
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.XL
            @Override // java.lang.Runnable
            public final void run() {
                YL.G(this.a, qn, f);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(YL yl, QN qn, float f) {
        AbstractC13042fc3.i(yl, "this$0");
        VL vlA = RN.a((C8552Wl4) yl.b.e(), qn);
        yl.g.invoke(Long.valueOf(vlA.b()));
        yl.h = yl.A(vlA.b());
        if (yl.C(yl.b.e())) {
            return;
        }
        String strO = AbstractC7426Rr.a.o(f);
        yl.e.r(AbstractC17636nI6.i(yl.h + " - " + strO));
    }

    private final void x(float f) {
        boolean z = !this.b.i();
        AppCompatSeekBar appCompatSeekBar = this.c;
        this.f.invoke(Boolean.FALSE);
        D(appCompatSeekBar, z, z);
        appCompatSeekBar.setProgress(0);
        BubbleTextView bubbleTextView = this.d;
        bubbleTextView.r(this.b.d());
        D(bubbleTextView, bubbleTextView.getVisibility() == 0, z);
        String strO = AbstractC7426Rr.a.o(f);
        this.e.r(AbstractC17636nI6.i(this.h + " - " + strO));
    }

    private final void y(float f) {
        Spannable spannableI;
        boolean zC = C(this.b.e());
        boolean z = !this.b.i();
        AppCompatSeekBar appCompatSeekBar = this.c;
        this.f.invoke(Boolean.valueOf(zC));
        D(appCompatSeekBar, z | zC, z);
        appCompatSeekBar.setProgress(zC ? (int) (C23709xO.a.O() / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) : 0);
        D(this.d, this.b.i() & (!zC), z);
        if (zC) {
            spannableI = B();
        } else {
            String strO = AbstractC7426Rr.a.o(f);
            spannableI = AbstractC17636nI6.i(this.h + " - " + strO);
        }
        this.e.r(spannableI);
    }

    private final void z() {
        boolean z = !this.b.i();
        AppCompatSeekBar appCompatSeekBar = this.c;
        this.f.invoke(Boolean.FALSE);
        D(appCompatSeekBar, z, z);
        D(this.d, this.b.i(), z);
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        this.b.e().e(interfaceC3346Am2.getDescriptor());
        float f = interfaceC3346Am2.f() / 1024.0f;
        E(interfaceC3346Am2.getDescriptor(), f);
        y(f);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        if (AbstractC3574Bl0.b(this.b.a())) {
            z();
        } else {
            x(f);
        }
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        this.b.e().e(c4512Fl2.c);
        y(f);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void o(float f) {
        x(f);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void p() {
        z();
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void q(float f, float f2) {
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        String strO = aVar.o(f * f2);
        String strO2 = aVar.o(f2);
        this.e.r(AbstractC17636nI6.i(strO + " / " + strO2));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void r(float f) {
        x(f);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void t(float f) {
        y(f);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void u(float f, float f2) {
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        String strO = aVar.o(f * f2);
        String strO2 = aVar.o(f2);
        this.e.r(AbstractC17636nI6.i(strO + " / " + strO2));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
    }
}
