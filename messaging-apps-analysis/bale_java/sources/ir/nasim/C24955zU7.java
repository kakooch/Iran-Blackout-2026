package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.animation.AnimationUtils;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.X2;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* renamed from: ir.nasim.zU7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24955zU7 extends AbstractC6981Pu5 implements InterfaceC20718sU7 {
    private final int b;
    private final SA2 c;
    private final SA2 d;
    private final InterfaceC9173Yu3 e;
    private final InterfaceC9173Yu3 f;
    private final InterfaceC9173Yu3 g;
    private float h;
    private boolean i;
    private Float j;
    private long k;
    private float l;
    private a m;

    /* renamed from: ir.nasim.zU7$a */
    public static final class a implements Runnable {
        final /* synthetic */ BubbleTextView b;

        a(BubbleTextView bubbleTextView) {
            this.b = bubbleTextView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C24955zU7.this.j == null) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            int iMax = Math.max(17, (int) (jCurrentAnimationTimeMillis - C24955zU7.this.k));
            C24955zU7 c24955zU7 = C24955zU7.this;
            c24955zU7.h = (c24955zU7.h + ((iMax / 17.0f) * 5)) % 360;
            this.b.r(C24955zU7.N(C24955zU7.this, C24955zU7.this.j, C24955zU7.this.l, false, C24955zU7.this.i, C24955zU7.this.h, null, 32, null));
            C24955zU7.this.k = jCurrentAnimationTimeMillis;
            this.b.postDelayed(this, 17L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C24955zU7(final BubbleTextView bubbleTextView, int i, SA2 sa2, SA2 sa22) {
        super(bubbleTextView);
        AbstractC13042fc3.i(bubbleTextView, "progressTextView");
        AbstractC13042fc3.i(sa2, "resumeDownload");
        AbstractC13042fc3.i(sa22, "pauseDownload");
        this.b = i;
        this.c = sa2;
        this.d = sa22;
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.wU7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24955zU7.O(bubbleTextView);
            }
        });
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.xU7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C24955zU7.L(bubbleTextView));
            }
        });
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.yU7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C24955zU7.W(bubbleTextView));
            }
        });
        bubbleTextView.setImportantForAccessibility(1);
        bubbleTextView.setFocusable(true);
        bubbleTextView.setClickable(true);
        this.h = -90.0f;
        this.m = new a(bubbleTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int L(BubbleTextView bubbleTextView) {
        AbstractC13042fc3.i(bubbleTextView, "$progressTextView");
        Context context = bubbleTextView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return OY0.b(context, AbstractC21139tA5.bubble_background_icon);
    }

    private final Spannable M(Float f, float f2, boolean z, boolean z2, float f3, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        C24955zU7 c24955zU7;
        String str6;
        if (z2) {
            String strR = R();
            if (f != null) {
                str6 = AbstractC7426Rr.a.o(f.floatValue() * f2) + " / ";
            } else {
                str6 = null;
            }
            String str7 = str6 != null ? str6 : "";
            str5 = str7 + AbstractC7426Rr.a.o(f2);
            c24955zU7 = this;
            str4 = str5;
            str3 = strR;
            str2 = str;
        } else {
            str2 = str;
            str3 = "";
            str4 = str3;
            str5 = "loading progress";
            c24955zU7 = this;
        }
        c24955zU7.X(str2);
        SpannableString spannableString = new SpannableString(str5);
        spannableString.setSpan(new C22004uV7(str3, str4, f, JF5.g(), z, Q(), S(), P(), f3, 0.0f, 512, null), 0, spannableString.length(), 33);
        return spannableString;
    }

    static /* synthetic */ Spannable N(C24955zU7 c24955zU7, Float f, float f2, boolean z, boolean z2, float f3, String str, int i, Object obj) {
        return c24955zU7.M(f, f2, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? -90.0f : f3, (i & 32) != 0 ? null : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable O(BubbleTextView bubbleTextView) {
        AbstractC13042fc3.i(bubbleTextView, "$progressTextView");
        return AbstractC4043Dl1.f(bubbleTextView.getContext(), KB5.bubble_document_state_download);
    }

    private final int P() {
        return ((Number) this.f.getValue()).intValue();
    }

    private final Drawable Q() {
        return (Drawable) this.e.getValue();
    }

    private final String R() {
        return XY6.v(C17959nq7.a.a(this.b));
    }

    private final int S() {
        return ((Number) this.g.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(C24955zU7 c24955zU7, View view) {
        AbstractC13042fc3.i(c24955zU7, "this$0");
        c24955zU7.c.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(C24955zU7 c24955zU7, View view) {
        AbstractC13042fc3.i(c24955zU7, "this$0");
        c24955zU7.d.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(C24955zU7 c24955zU7, View view) {
        AbstractC13042fc3.i(c24955zU7, "this$0");
        c24955zU7.c.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int W(BubbleTextView bubbleTextView) {
        AbstractC13042fc3.i(bubbleTextView, "$progressTextView");
        Context context = bubbleTextView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return OY0.b(context, AbstractC21139tA5.colorOnPrimary);
    }

    private final void X(String str) {
        BubbleTextView bubbleTextViewX = x();
        C10082b3 c10082b3 = C10082b3.a;
        Context context = x().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        bubbleTextViewX.setContentDescription(c10082b3.a(context, this.b));
        View rootView = x().getRootView();
        X2.a aVar = X2.a.i;
        if (str == null) {
            str = x().getContext().getString(AbstractC12217eE5.accessibility_activate);
            AbstractC13042fc3.h(str, "getString(...)");
        }
        AbstractC12990fW7.l0(rootView, aVar, str, new C21347tV7(x()));
    }

    private final Spannable Y(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        Context context = x().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        AbstractC17636nI6.h(spannableStringBuilder, OY0.b(context, AbstractC21139tA5.bubble_background_icon), 0, 0, 0, 14, null);
        return spannableStringBuilder;
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
        this.h = -90.0f;
        BubbleTextView bubbleTextViewX = x();
        bubbleTextViewX.removeCallbacks(this.m);
        bubbleTextViewX.setOnClickListener(null);
        bubbleTextViewX.setVisibility(0);
        this.j = null;
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        x().r(Y(R()));
        x().setOnClickListener(null);
    }

    @Override // ir.nasim.InterfaceC20718sU7
    public void h(long j, boolean z) {
        this.j = null;
        x().r(Y(XY6.v(C17959nq7.a.a((int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)))));
    }

    @Override // ir.nasim.InterfaceC20718sU7
    public void j(float f, float f2) {
        boolean z;
        x().removeCallbacks(this.m);
        if (f >= 0.99f || f <= 0.05f) {
            f = 0.3f;
            z = false;
        } else {
            z = true;
        }
        this.i = z;
        this.j = Float.valueOf(f);
        this.l = f2;
        this.m.run();
    }

    @Override // ir.nasim.InterfaceC20718sU7
    public void l(com.google.android.exoplayer2.E0 e0, float f) {
        AbstractC13042fc3.i(e0, "player");
        x().setVisibility(8);
        this.l = f;
        this.j = null;
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        this.j = null;
        String strO = AbstractC7426Rr.a.o(f);
        x().r(Y(strO + "  " + R()));
        BubbleTextView bubbleTextViewX = x();
        C10082b3 c10082b3 = C10082b3.a;
        Context context = x().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        String strA = c10082b3.a(context, this.b);
        Context context2 = x().getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        bubbleTextViewX.setContentDescription(strA + C10082b3.b(context2, Float.valueOf(f * 1024)));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        this.j = null;
        x().r(Y(R()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void o(float f) {
        x().r(N(this, null, f, false, false, 0.0f, null, 60, null));
        x().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vU7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C24955zU7.T(this.a, view);
            }
        });
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void q(float f, float f2) {
        x().r(N(this, Float.valueOf(f), f2, false, false, 0.0f, x().getContext().getString(AbstractC12217eE5.cancel_download), 28, null));
        x().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tU7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C24955zU7.U(this.a, view);
            }
        });
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void r(float f) {
        x().r(N(this, null, f, false, false, 0.0f, x().getContext().getString(AbstractC12217eE5.download), 28, null));
        x().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.uU7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C24955zU7.V(this.a, view);
            }
        });
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void t(float f) {
        x().r(Y(R()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void u(float f, float f2) {
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        String strO = aVar.o(f * f2);
        String strO2 = aVar.o(f2);
        x().r(Y(strO + " / " + strO2 + "  " + R()));
    }

    @Override // ir.nasim.AbstractC6981Pu5
    public Spannable v(float f) {
        String strO = AbstractC7426Rr.a.o(f);
        return Y(strO + " / " + strO + "  " + R());
    }
}
