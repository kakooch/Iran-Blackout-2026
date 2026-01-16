package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.AbstractC9511a52;
import ir.nasim.HE5;
import ir.nasim.VW5;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: classes.dex */
class p {
    private final TextView a;
    private A b;
    private A c;
    private A d;
    private A e;
    private A f;
    private A g;
    private A h;
    private final q i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    class a extends VW5.e {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ WeakReference c;

        a(int i, int i2, WeakReference weakReference) {
            this.a = i;
            this.b = i2;
            this.c = weakReference;
        }

        @Override // ir.nasim.VW5.e
        /* renamed from: h */
        public void f(int i) {
        }

        @Override // ir.nasim.VW5.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
                typeface = f.a(typeface, i, (this.b & 2) != 0);
            }
            p.this.n(this.c, typeface);
        }
    }

    class b implements Runnable {
        final /* synthetic */ TextView a;
        final /* synthetic */ Typeface b;
        final /* synthetic */ int c;

        b(TextView textView, Typeface typeface, int i) {
            this.a = textView;
            this.b = typeface;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setTypeface(this.b, this.c);
        }
    }

    static class c {
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    static class d {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    static class e {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        static void c(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    static class f {
        static Typeface a(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }

    p(TextView textView) {
        this.a = textView;
        this.i = new q(textView);
    }

    private void B(int i, float f2) {
        this.i.t(i, f2);
    }

    private void C(Context context, C c2) {
        String strO;
        this.j = c2.k(HE5.TextAppearance_android_textStyle, this.j);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int iK = c2.k(HE5.TextAppearance_android_textFontWeight, -1);
            this.k = iK;
            if (iK != -1) {
                this.j &= 2;
            }
        }
        if (!c2.s(HE5.TextAppearance_android_fontFamily) && !c2.s(HE5.TextAppearance_fontFamily)) {
            if (c2.s(HE5.TextAppearance_android_typeface)) {
                this.m = false;
                int iK2 = c2.k(HE5.TextAppearance_android_typeface, 1);
                if (iK2 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i2 = c2.s(HE5.TextAppearance_fontFamily) ? HE5.TextAppearance_fontFamily : HE5.TextAppearance_android_fontFamily;
        int i3 = this.k;
        int i4 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = c2.j(i2, this.j, new a(i3, i4, new WeakReference(this.a)));
                if (typefaceJ != null) {
                    if (i < 28 || this.k == -1) {
                        this.l = typefaceJ;
                    } else {
                        this.l = f.a(Typeface.create(typefaceJ, 0), this.k, (this.j & 2) != 0);
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (strO = c2.o(i2)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            this.l = Typeface.create(strO, this.j);
        } else {
            this.l = f.a(Typeface.create(strO, 0), this.k, (this.j & 2) != 0);
        }
    }

    private void a(Drawable drawable, A a2) {
        if (drawable == null || a2 == null) {
            return;
        }
        g.i(drawable, a2, this.a.getDrawableState());
    }

    private static A d(Context context, g gVar, int i) {
        ColorStateList colorStateListF = gVar.f(context, i);
        if (colorStateListF == null) {
            return null;
        }
        A a2 = new A();
        a2.d = true;
        a2.a = colorStateListF;
        return a2;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] drawableArrA = c.a(this.a);
            TextView textView = this.a;
            if (drawable5 == null) {
                drawable5 = drawableArrA[0];
            }
            if (drawable2 == null) {
                drawable2 = drawableArrA[1];
            }
            if (drawable6 == null) {
                drawable6 = drawableArrA[2];
            }
            if (drawable4 == null) {
                drawable4 = drawableArrA[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] drawableArrA2 = c.a(this.a);
        Drawable drawable7 = drawableArrA2[0];
        if (drawable7 != null || drawableArrA2[2] != null) {
            TextView textView2 = this.a;
            if (drawable2 == null) {
                drawable2 = drawableArrA2[1];
            }
            Drawable drawable8 = drawableArrA2[2];
            if (drawable4 == null) {
                drawable4 = drawableArrA2[3];
            }
            c.b(textView2, drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
        TextView textView3 = this.a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        A a2 = this.h;
        this.b = a2;
        this.c = a2;
        this.d = a2;
        this.e = a2;
        this.f = a2;
        this.g = a2;
    }

    void A(int i, float f2) {
        if (F.b || l()) {
            return;
        }
        B(i, f2);
    }

    void b() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] drawableArrA = c.a(this.a);
        a(drawableArrA[0], this.f);
        a(drawableArrA[2], this.g);
    }

    void c() {
        this.i.a();
    }

    int e() {
        return this.i.f();
    }

    int f() {
        return this.i.g();
    }

    int g() {
        return this.i.h();
    }

    int[] h() {
        return this.i.i();
    }

    int i() {
        return this.i.j();
    }

    ColorStateList j() {
        A a2 = this.h;
        if (a2 != null) {
            return a2.a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        A a2 = this.h;
        if (a2 != null) {
            return a2.b;
        }
        return null;
    }

    boolean l() {
        return this.i.n();
    }

    void m(AttributeSet attributeSet, int i) {
        boolean zA;
        boolean z;
        String strO;
        String strO2;
        boolean z2;
        Context context = this.a.getContext();
        g gVarB = g.b();
        C cV = C.v(context, attributeSet, HE5.AppCompatTextHelper, i, 0);
        TextView textView = this.a;
        AbstractC12990fW7.n0(textView, textView.getContext(), HE5.AppCompatTextHelper, attributeSet, cV.r(), i, 0);
        int iN = cV.n(HE5.AppCompatTextHelper_android_textAppearance, -1);
        if (cV.s(HE5.AppCompatTextHelper_android_drawableLeft)) {
            this.b = d(context, gVarB, cV.n(HE5.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (cV.s(HE5.AppCompatTextHelper_android_drawableTop)) {
            this.c = d(context, gVarB, cV.n(HE5.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (cV.s(HE5.AppCompatTextHelper_android_drawableRight)) {
            this.d = d(context, gVarB, cV.n(HE5.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (cV.s(HE5.AppCompatTextHelper_android_drawableBottom)) {
            this.e = d(context, gVarB, cV.n(HE5.AppCompatTextHelper_android_drawableBottom, 0));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (cV.s(HE5.AppCompatTextHelper_android_drawableStart)) {
            this.f = d(context, gVarB, cV.n(HE5.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (cV.s(HE5.AppCompatTextHelper_android_drawableEnd)) {
            this.g = d(context, gVarB, cV.n(HE5.AppCompatTextHelper_android_drawableEnd, 0));
        }
        cV.w();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iN != -1) {
            C cT = C.t(context, iN, HE5.TextAppearance);
            if (z3 || !cT.s(HE5.TextAppearance_textAllCaps)) {
                zA = false;
                z = false;
            } else {
                zA = cT.a(HE5.TextAppearance_textAllCaps, false);
                z = true;
            }
            C(context, cT);
            strO2 = cT.s(HE5.TextAppearance_textLocale) ? cT.o(HE5.TextAppearance_textLocale) : null;
            strO = (i2 < 26 || !cT.s(HE5.TextAppearance_fontVariationSettings)) ? null : cT.o(HE5.TextAppearance_fontVariationSettings);
            cT.w();
        } else {
            zA = false;
            z = false;
            strO = null;
            strO2 = null;
        }
        C cV2 = C.v(context, attributeSet, HE5.TextAppearance, i, 0);
        if (z3 || !cV2.s(HE5.TextAppearance_textAllCaps)) {
            z2 = z;
        } else {
            zA = cV2.a(HE5.TextAppearance_textAllCaps, false);
            z2 = true;
        }
        if (cV2.s(HE5.TextAppearance_textLocale)) {
            strO2 = cV2.o(HE5.TextAppearance_textLocale);
        }
        if (i2 >= 26 && cV2.s(HE5.TextAppearance_fontVariationSettings)) {
            strO = cV2.o(HE5.TextAppearance_fontVariationSettings);
        }
        if (i2 >= 28 && cV2.s(HE5.TextAppearance_android_textSize) && cV2.f(HE5.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        C(context, cV2);
        cV2.w();
        if (!z3 && z2) {
            s(zA);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.a.setTypeface(typeface, this.j);
            } else {
                this.a.setTypeface(typeface);
            }
        }
        if (strO != null) {
            e.d(this.a, strO);
        }
        if (strO2 != null) {
            d.b(this.a, d.a(strO2));
        }
        this.i.o(attributeSet, i);
        if (F.b && this.i.j() != 0) {
            int[] iArrI = this.i.i();
            if (iArrI.length > 0) {
                if (e.a(this.a) != -1.0f) {
                    e.b(this.a, this.i.g(), this.i.f(), this.i.h(), 0);
                } else {
                    e.c(this.a, iArrI, 0);
                }
            }
        }
        C cU = C.u(context, attributeSet, HE5.AppCompatTextView);
        int iN2 = cU.n(HE5.AppCompatTextView_drawableLeftCompat, -1);
        Drawable drawableC = iN2 != -1 ? gVarB.c(context, iN2) : null;
        int iN3 = cU.n(HE5.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawableC2 = iN3 != -1 ? gVarB.c(context, iN3) : null;
        int iN4 = cU.n(HE5.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawableC3 = iN4 != -1 ? gVarB.c(context, iN4) : null;
        int iN5 = cU.n(HE5.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawableC4 = iN5 != -1 ? gVarB.c(context, iN5) : null;
        int iN6 = cU.n(HE5.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawableC5 = iN6 != -1 ? gVarB.c(context, iN6) : null;
        int iN7 = cU.n(HE5.AppCompatTextView_drawableEndCompat, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iN7 != -1 ? gVarB.c(context, iN7) : null);
        if (cU.s(HE5.AppCompatTextView_drawableTint)) {
            AbstractC15575jo7.h(this.a, cU.c(HE5.AppCompatTextView_drawableTint));
        }
        if (cU.s(HE5.AppCompatTextView_drawableTintMode)) {
            AbstractC15575jo7.i(this.a, r.e(cU.k(HE5.AppCompatTextView_drawableTintMode, -1), null));
        }
        int iF = cU.f(HE5.AppCompatTextView_firstBaselineToTopHeight, -1);
        int iF2 = cU.f(HE5.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int iF3 = cU.f(HE5.AppCompatTextView_lineHeight, -1);
        cU.w();
        if (iF != -1) {
            AbstractC15575jo7.l(this.a, iF);
        }
        if (iF2 != -1) {
            AbstractC15575jo7.m(this.a, iF2);
        }
        if (iF3 != -1) {
            AbstractC15575jo7.n(this.a, iF3);
        }
    }

    void n(WeakReference weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (AbstractC12990fW7.S(textView)) {
                    textView.post(new b(textView, typeface, this.j));
                } else {
                    textView.setTypeface(typeface, this.j);
                }
            }
        }
    }

    void o(boolean z, int i, int i2, int i3, int i4) {
        if (F.b) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i) {
        String strO;
        C cT = C.t(context, i, HE5.TextAppearance);
        if (cT.s(HE5.TextAppearance_textAllCaps)) {
            s(cT.a(HE5.TextAppearance_textAllCaps, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (cT.s(HE5.TextAppearance_android_textSize) && cT.f(HE5.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        C(context, cT);
        if (i2 >= 26 && cT.s(HE5.TextAppearance_fontVariationSettings) && (strO = cT.o(HE5.TextAppearance_fontVariationSettings)) != null) {
            e.d(this.a, strO);
        }
        cT.w();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        AbstractC9511a52.f(editorInfo, textView.getText());
    }

    void s(boolean z) {
        this.a.setAllCaps(z);
    }

    void t(int i, int i2, int i3, int i4) {
        this.i.p(i, i2, i3, i4);
    }

    void u(int[] iArr, int i) {
        this.i.q(iArr, i);
    }

    void v(int i) {
        this.i.r(i);
    }

    void w(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new A();
        }
        A a2 = this.h;
        a2.a = colorStateList;
        a2.d = colorStateList != null;
        z();
    }

    void x(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new A();
        }
        A a2 = this.h;
        a2.b = mode;
        a2.c = mode != null;
        z();
    }
}
