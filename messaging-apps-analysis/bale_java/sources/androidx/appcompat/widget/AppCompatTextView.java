package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import ir.nasim.AbstractC10050az7;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC25097zj5;
import ir.nasim.AbstractC9594aE;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView {
    private final C1917d a;
    private final p b;
    private final o c;
    private i d;
    private boolean e;
    private a f;
    private Future g;

    private interface a {
        void a(int[] iArr, int i);

        void b(int i);

        int c();

        int d();

        int[] e();

        TextClassifier f();

        int g();

        void h(TextClassifier textClassifier);

        void i(int i, int i2, int i3, int i4);

        void j(int i);

        int k();

        void l(int i);
    }

    class b implements a {
        b() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void a(int[] iArr, int i) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void b(int i) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public int c() {
            return AppCompatTextView.super.getAutoSizeTextType();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public int d() {
            return AppCompatTextView.super.getAutoSizeMinTextSize();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public int[] e() {
            return AppCompatTextView.super.getAutoSizeTextAvailableSizes();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public TextClassifier f() {
            return AppCompatTextView.super.getTextClassifier();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public int g() {
            return AppCompatTextView.super.getAutoSizeMaxTextSize();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void h(TextClassifier textClassifier) {
            AppCompatTextView.super.setTextClassifier(textClassifier);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void i(int i, int i2, int i3, int i4) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void j(int i) {
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public int k() {
            return AppCompatTextView.super.getAutoSizeStepGranularity();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.a
        public void l(int i) {
            AppCompatTextView.super.setAutoSizeTextTypeWithDefaults(i);
        }
    }

    class c extends b {
        c() {
            super();
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.b, androidx.appcompat.widget.AppCompatTextView.a
        public void b(int i) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(i);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.b, androidx.appcompat.widget.AppCompatTextView.a
        public void j(int i) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(i);
        }
    }

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private i getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new i(this);
        }
        return this.d;
    }

    private void q() {
        Future future = this.g;
        if (future != null) {
            try {
                this.g = null;
                AbstractC18350oW3.a(future.get());
                AbstractC15575jo7.o(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.b();
        }
        p pVar = this.b;
        if (pVar != null) {
            pVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (F.b) {
            return getSuperCaller().g();
        }
        p pVar = this.b;
        if (pVar != null) {
            return pVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (F.b) {
            return getSuperCaller().d();
        }
        p pVar = this.b;
        if (pVar != null) {
            return pVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (F.b) {
            return getSuperCaller().k();
        }
        p pVar = this.b;
        if (pVar != null) {
            return pVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (F.b) {
            return getSuperCaller().e();
        }
        p pVar = this.b;
        return pVar != null ? pVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (F.b) {
            return getSuperCaller().c() == 1 ? 1 : 0;
        }
        p pVar = this.b;
        if (pVar != null) {
            return pVar.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC15575jo7.r(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return AbstractC15575jo7.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return AbstractC15575jo7.c(this);
    }

    a getSuperCaller() {
        if (this.f == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                this.f = new c();
            } else if (i >= 26) {
                this.f = new b();
            }
        }
        return this.f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            return c1917d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            return c1917d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        q();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        o oVar;
        return (Build.VERSION.SDK_INT >= 28 || (oVar = this.c) == null) ? getSuperCaller().f() : oVar.a();
    }

    public AbstractC25097zj5.a getTextMetricsParamsCompat() {
        return AbstractC15575jo7.g(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return j.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        p pVar = this.b;
        if (pVar != null) {
            pVar.o(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        q();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        p pVar = this.b;
        if (pVar == null || F.b || !pVar.l()) {
            return;
        }
        this.b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (F.b) {
            getSuperCaller().i(i, i2, i3, i4);
            return;
        }
        p pVar = this.b;
        if (pVar != null) {
            pVar.t(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (F.b) {
            getSuperCaller().a(iArr, i);
            return;
        }
        p pVar = this.b;
        if (pVar != null) {
            pVar.u(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (F.b) {
            getSuperCaller().l(i);
            return;
        }
        p pVar = this.b;
        if (pVar != null) {
            pVar.v(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.g(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        p pVar = this.b;
        if (pVar != null) {
            pVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        p pVar = this.b;
        if (pVar != null) {
            pVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        p pVar = this.b;
        if (pVar != null) {
            pVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        p pVar = this.b;
        if (pVar != null) {
            pVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC15575jo7.s(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().j(i);
        } else {
            AbstractC15575jo7.l(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().b(i);
        } else {
            AbstractC15575jo7.m(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        AbstractC15575jo7.n(this, i);
    }

    public void setPrecomputedText(AbstractC25097zj5 abstractC25097zj5) {
        AbstractC15575jo7.o(this, abstractC25097zj5);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.b.w(colorStateList);
        this.b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.b.x(mode);
        this.b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        p pVar = this.b;
        if (pVar != null) {
            pVar.q(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        o oVar;
        if (Build.VERSION.SDK_INT >= 28 || (oVar = this.c) == null) {
            getSuperCaller().h(textClassifier);
        } else {
            oVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<AbstractC25097zj5> future) {
        this.g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(AbstractC25097zj5.a aVar) {
        AbstractC15575jo7.q(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (F.b) {
            super.setTextSize(i, f);
            return;
        }
        p pVar = this.b;
        if (pVar != null) {
            pVar.A(i, f);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        if (this.e) {
            return;
        }
        Typeface typefaceA = (typeface == null || i <= 0) ? null : AbstractC10050az7.a(getContext(), typeface, i);
        this.e = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.e = false;
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(z.b(context), attributeSet, i);
        this.e = false;
        this.f = null;
        y.a(this, getContext());
        C1917d c1917d = new C1917d(this);
        this.a = c1917d;
        c1917d.e(attributeSet, i);
        p pVar = new p(this);
        this.b = pVar;
        pVar.m(attributeSet, i);
        pVar.b();
        this.c = new o(this);
        getEmojiTextViewHelper().c(attributeSet, i);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? AbstractC9594aE.b(context, i) : null, i2 != 0 ? AbstractC9594aE.b(context, i2) : null, i3 != 0 ? AbstractC9594aE.b(context, i3) : null, i4 != 0 ? AbstractC9594aE.b(context, i4) : null);
        p pVar = this.b;
        if (pVar != null) {
            pVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? AbstractC9594aE.b(context, i) : null, i2 != 0 ? AbstractC9594aE.b(context, i2) : null, i3 != 0 ? AbstractC9594aE.b(context, i3) : null, i4 != 0 ? AbstractC9594aE.b(context, i4) : null);
        p pVar = this.b;
        if (pVar != null) {
            pVar.p();
        }
    }
}
