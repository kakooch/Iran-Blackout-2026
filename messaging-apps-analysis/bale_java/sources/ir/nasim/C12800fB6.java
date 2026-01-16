package ir.nasim;

import android.animation.LayoutTransition;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Color;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

/* renamed from: ir.nasim.fB6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12800fB6 {
    public static final b o = new b(null);
    public static final int p = 8;
    private static final String q = C12800fB6.class.getSimpleName();
    private final Context a;
    private c b;
    private final int c;
    private final int d;
    private final String e;
    private final String f;
    private final int g;
    private final int h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;

    /* renamed from: ir.nasim.fB6$a */
    public static final class a {
        private final Context a;
        private int b;
        private int c;
        private String d;
        private String e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;

        public a(Context context) {
            AbstractC13042fc3.i(context, "context");
            this.a = context;
            this.b = 100;
            this.c = 2;
            this.d = "";
            this.e = "";
            this.f = Color.parseColor("#ffffff");
            this.g = Color.parseColor("#ffffff");
        }

        public final C12800fB6 a() {
            return new C12800fB6(this, null);
        }

        public final a b(boolean z) {
            this.j = z;
            return this;
        }

        public final Context c() {
            return this.a;
        }

        public final boolean d() {
            return this.m;
        }

        public final boolean e() {
            return this.j;
        }

        public final boolean f() {
            return this.i;
        }

        public final boolean g() {
            return this.h;
        }

        public final String h() {
            return this.e;
        }

        public final int i() {
            return this.g;
        }

        public final String j() {
            return this.d;
        }

        public final int k() {
            return this.f;
        }

        public final boolean l() {
            return this.l;
        }

        public final boolean m() {
            return this.k;
        }

        public final int n() {
            return this.b;
        }

        public final int o() {
            return this.c;
        }

        public final a p(boolean z) {
            this.i = z;
            return this;
        }

        public final a q(String str) {
            AbstractC13042fc3.i(str, "moreLabel");
            this.d = str;
            return this;
        }

        public final a r(int i) {
            this.f = i;
            return this;
        }

        public final a s(boolean z, boolean z2) {
            this.k = z;
            this.l = z2;
            return this;
        }

        public final a t(int i, int i2) {
            this.b = i;
            this.c = i2;
            return this;
        }
    }

    /* renamed from: ir.nasim.fB6$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fB6$c */
    public interface c {
        void a();

        void b();
    }

    /* renamed from: ir.nasim.fB6$d */
    public static final class d extends ClickableSpan {
        final /* synthetic */ TextView b;
        final /* synthetic */ Spannable c;

        d(TextView textView, Spannable spannable) {
            this.b = textView;
            this.c = spannable;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "view");
            if (C12800fB6.this.f.length() > 0) {
                C12800fB6.this.q(this.b, this.c);
                c cVar = C12800fB6.this.b;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(C12800fB6.this.i);
            textPaint.setFakeBoldText(C12800fB6.this.j);
            textPaint.setColor(C12800fB6.this.h);
        }
    }

    /* renamed from: ir.nasim.fB6$e */
    public static final class e extends ClickableSpan {
        final /* synthetic */ TextView b;
        final /* synthetic */ Spannable c;

        e(TextView textView, Spannable spannable) {
            this.b = textView;
            this.c = spannable;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "view");
            C12800fB6.this.n(this.b, this.c);
            c cVar = C12800fB6.this.b;
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(C12800fB6.this.i);
            textPaint.setFakeBoldText(C12800fB6.this.j);
            textPaint.setColor(C12800fB6.this.g);
        }
    }

    public /* synthetic */ C12800fB6(a aVar, ED1 ed1) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final TextView textView, final Spannable spannable) {
        try {
            textView.setMaxLines(Integer.MAX_VALUE);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannable);
            if (this.f.length() > 0) {
                spannableStringBuilder.append((CharSequence) Separators.SP);
                spannableStringBuilder.append((CharSequence) this.f);
            }
            SpannableString spannableStringValueOf = SpannableString.valueOf(spannableStringBuilder);
            d dVar = new d(textView, spannable);
            if (this.f.length() > 0) {
                spannableStringValueOf.setSpan(dVar, spannableStringValueOf.length() - this.f.length(), spannableStringValueOf.length(), 33);
            }
            if (this.m && this.f.length() == 0) {
                new Handler().post(new Runnable() { // from class: ir.nasim.cB6
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12800fB6.o(textView, this, spannable);
                    }
                });
            }
            if (this.k) {
                LayoutTransition layoutTransition = new LayoutTransition();
                layoutTransition.enableTransitionType(4);
                ViewParent parent = textView.getParent();
                AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).setLayoutTransition(layoutTransition);
            }
            textView.setText(spannableStringValueOf, TextView.BufferType.SPANNABLE);
            textView.requestLayout();
            if (this.n) {
                Linkify.addLinks(textView, 15);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final TextView textView, final C12800fB6 c12800fB6, final Spannable spannable) {
        AbstractC13042fc3.i(textView, "$textView");
        AbstractC13042fc3.i(c12800fB6, "this$0");
        AbstractC13042fc3.i(spannable, "$trimText");
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.eB6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12800fB6.p(this.a, textView, spannable, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(C12800fB6 c12800fB6, TextView textView, Spannable spannable, View view) {
        AbstractC13042fc3.i(c12800fB6, "this$0");
        AbstractC13042fc3.i(textView, "$textView");
        AbstractC13042fc3.i(spannable, "$trimText");
        c12800fB6.q(textView, spannable);
        c cVar = c12800fB6.b;
        if (cVar != null) {
            cVar.a();
        }
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final TextView textView, final Spannable spannable) {
        CharSequence charSequenceSubSequence;
        int length = 0;
        try {
            if (this.d == 1) {
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                charSequenceSubSequence = spannable.subSequence(textView.getLayout().getLineStart(0), textView.getLayout().getLineEnd(this.c - 1));
                if (AbstractC20762sZ6.a0(charSequenceSubSequence, Separators.RETURN, false)) {
                    charSequenceSubSequence = AbstractC20762sZ6.D0(charSequenceSubSequence, Separators.RETURN);
                } else {
                    int length2 = charSequenceSubSequence.length() - ((this.e.length() + 4) + (marginLayoutParams.rightMargin / 6));
                    int length3 = charSequenceSubSequence.length();
                    if (length2 > 0) {
                        charSequenceSubSequence = TextUtils.concat(charSequenceSubSequence.subSequence(0, length2), charSequenceSubSequence.subSequence(length3, charSequenceSubSequence.length()));
                        AbstractC13042fc3.f(charSequenceSubSequence);
                    }
                }
            } else {
                charSequenceSubSequence = spannable.subSequence(0, this.c);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequenceSubSequence);
            spannableStringBuilder.append((CharSequence) Separators.SP);
            spannableStringBuilder.append((CharSequence) this.e);
            SpannableString spannableStringValueOf = SpannableString.valueOf(spannableStringBuilder);
            AbstractC13042fc3.h(spannableStringValueOf, "valueOf(...)");
            e eVar = new e(textView, spannable);
            if (!this.m) {
                length = spannableStringValueOf.length() - this.e.length();
            }
            spannableStringValueOf.setSpan(eVar, length, spannableStringValueOf.length(), 33);
            if (this.l && this.e.length() == 0) {
                new Handler().post(new Runnable() { // from class: ir.nasim.bB6
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12800fB6.r(textView, this, spannable);
                    }
                });
            }
            if (this.k) {
                LayoutTransition layoutTransition = new LayoutTransition();
                layoutTransition.enableTransitionType(4);
                ViewParent parent = textView.getParent();
                AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).setLayoutTransition(layoutTransition);
            }
            textView.setText(spannableStringValueOf, TextView.BufferType.SPANNABLE);
            textView.requestLayout();
            if (this.n) {
                Linkify.addLinks(textView, 15);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final TextView textView, final C12800fB6 c12800fB6, final Spannable spannable) {
        AbstractC13042fc3.i(textView, "$textView");
        AbstractC13042fc3.i(c12800fB6, "this$0");
        AbstractC13042fc3.i(spannable, "$trimText");
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.dB6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12800fB6.s(this.a, textView, spannable, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(C12800fB6 c12800fB6, TextView textView, Spannable spannable, View view) {
        AbstractC13042fc3.i(c12800fB6, "this$0");
        AbstractC13042fc3.i(textView, "$textView");
        AbstractC13042fc3.i(spannable, "$trimText");
        c12800fB6.n(textView, spannable);
        c cVar = c12800fB6.b;
        if (cVar != null) {
            cVar.b();
        }
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(C12800fB6 c12800fB6, CharSequence charSequence, TextView textView, boolean z) {
        AbstractC13042fc3.i(c12800fB6, "this$0");
        AbstractC13042fc3.i(charSequence, "$text");
        AbstractC13042fc3.i(textView, "$textView");
        try {
            Spannable spannableW = c12800fB6.w(charSequence);
            TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
            textView.setText(charSequence, bufferType);
            if (spannableW.length() == 0) {
                return;
            }
            if (c12800fB6.d != 1) {
                if (z) {
                    c12800fB6.n(textView, spannableW);
                    return;
                } else {
                    c12800fB6.q(textView, spannableW);
                    return;
                }
            }
            if (textView.getLayout() != null && textView.getLayout().getLineCount() <= c12800fB6.c) {
                textView.setText(charSequence, bufferType);
            } else if (z) {
                c12800fB6.n(textView, spannableW);
            } else {
                c12800fB6.q(textView, spannableW);
            }
        } catch (Exception unused) {
            String str = q;
            AbstractC13042fc3.h(str, "TAG");
            C19406qI3.b(str, "exception occurred in addShowMoreLess");
        }
    }

    private final Spannable w(CharSequence charSequence) {
        int length = charSequence.length();
        if (length <= TextUtils.getTrimmedLength(charSequence)) {
            return new SpannableString(charSequence);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int i = 0;
        while (i < length && AbstractC13042fc3.k(spannableStringBuilder.charAt(i), 32) <= 0) {
            i++;
        }
        spannableStringBuilder.delete(0, i);
        int i2 = length - i;
        int i3 = i2;
        while (i3 >= 0 && AbstractC13042fc3.k(spannableStringBuilder.charAt(i3 - 1), 32) <= 0) {
            i3--;
        }
        spannableStringBuilder.delete(i3, i2);
        return spannableStringBuilder;
    }

    public final void t(final TextView textView, final CharSequence charSequence, final boolean z) {
        AbstractC13042fc3.i(textView, "textView");
        AbstractC13042fc3.i(charSequence, ParameterNames.TEXT);
        if (this.d != 2) {
            textView.setMaxLines(this.c);
            textView.setText(charSequence, TextView.BufferType.SPANNABLE);
        } else if (charSequence.length() <= this.c) {
            textView.setText(charSequence, TextView.BufferType.SPANNABLE);
            return;
        }
        textView.post(new Runnable() { // from class: ir.nasim.aB6
            @Override // java.lang.Runnable
            public final void run() {
                C12800fB6.u(this.a, charSequence, textView, z);
            }
        });
    }

    public final void v(c cVar) {
        AbstractC13042fc3.i(cVar, "listener");
        this.b = cVar;
    }

    private C12800fB6(a aVar) {
        this.a = aVar.c();
        this.c = aVar.n();
        this.d = aVar.o();
        this.e = aVar.j();
        this.f = aVar.h();
        this.g = aVar.k();
        this.h = aVar.i();
        this.i = aVar.g();
        this.j = aVar.f();
        this.k = aVar.e();
        this.l = aVar.m();
        this.m = aVar.l();
        this.n = aVar.d();
    }
}
