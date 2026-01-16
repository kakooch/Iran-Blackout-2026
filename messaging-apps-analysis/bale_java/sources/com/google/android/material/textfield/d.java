package com.google.android.material.textfield;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17348mo7;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.B2;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.HB5;
import ir.nasim.WU3;
import ir.nasim.X2;

/* loaded from: classes3.dex */
class d extends com.google.android.material.textfield.e {
    private static final boolean t = true;
    private final TextWatcher e;
    private final View.OnFocusChangeListener f;
    private final TextInputLayout.e g;
    private final TextInputLayout.f h;
    private final TextInputLayout.g i;
    private final View.OnAttachStateChangeListener j;
    private final B2.a k;
    private boolean l;
    private boolean m;
    private long n;
    private StateListDrawable o;
    private C10345bV3 p;
    private AccessibilityManager q;
    private ValueAnimator r;
    private ValueAnimator s;

    class a extends AbstractC17348mo7 {

        /* renamed from: com.google.android.material.textfield.d$a$a, reason: collision with other inner class name */
        class RunnableC0191a implements Runnable {
            final /* synthetic */ AutoCompleteTextView a;

            RunnableC0191a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.a.isPopupShowing();
                d.this.J(zIsPopupShowing);
                d.this.l = zIsPopupShowing;
            }
        }

        a() {
        }

        @Override // ir.nasim.AbstractC17348mo7, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView autoCompleteTextViewC = d.C(d.this.a.getEditText());
            if (d.this.q.isTouchExplorationEnabled() && d.H(autoCompleteTextViewC) && !d.this.c.hasFocus()) {
                autoCompleteTextViewC.dismissDropDown();
            }
            autoCompleteTextViewC.post(new RunnableC0191a(autoCompleteTextViewC));
        }
    }

    class b implements AutoCompleteTextView.OnDismissListener {
        b() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.N();
            d.this.J(false);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.c.setChecked(dVar.m);
            d.this.s.start();
        }
    }

    /* renamed from: com.google.android.material.textfield.d$d, reason: collision with other inner class name */
    class C0192d implements ValueAnimator.AnimatorUpdateListener {
        C0192d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class e implements View.OnFocusChangeListener {
        e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            d.this.a.setEndIconActivated(z);
            if (z) {
                return;
            }
            d.this.J(false);
            d.this.l = false;
        }
    }

    class f extends TextInputLayout.e {
        f(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            if (!d.H(d.this.a.getEditText())) {
                x2.p0(Spinner.class.getName());
            }
            if (x2.X()) {
                x2.C0(null);
            }
        }

        @Override // ir.nasim.C22317v2
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            AutoCompleteTextView autoCompleteTextViewC = d.C(d.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.q.isEnabled() && !d.H(d.this.a.getEditText())) {
                d.this.M(autoCompleteTextViewC);
                d.this.N();
            }
        }
    }

    class g implements TextInputLayout.f {
        g() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextViewC = d.C(textInputLayout.getEditText());
            d.this.K(autoCompleteTextViewC);
            d.this.y(autoCompleteTextViewC);
            d.this.L(autoCompleteTextViewC);
            autoCompleteTextViewC.setThreshold(0);
            autoCompleteTextViewC.removeTextChangedListener(d.this.e);
            autoCompleteTextViewC.addTextChangedListener(d.this.e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.H(autoCompleteTextViewC) && d.this.q.isTouchExplorationEnabled()) {
                AbstractC12990fW7.A0(d.this.c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.g);
            textInputLayout.setEndIconVisible(true);
        }
    }

    class h implements TextInputLayout.g {

        class a implements Runnable {
            final /* synthetic */ AutoCompleteTextView a;

            a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(d.this.e);
            }
        }

        h() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i == 3) {
                autoCompleteTextView.post(new a(autoCompleteTextView));
                if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                if (d.t) {
                    autoCompleteTextView.setOnDismissListener(null);
                }
            }
            if (i == 3) {
                textInputLayout.removeOnAttachStateChangeListener(d.this.j);
                d.this.I();
            }
        }
    }

    class i implements View.OnAttachStateChangeListener {
        i() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            d.this.B();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            d.this.I();
        }
    }

    class j implements B2.a {
        j() {
        }

        @Override // ir.nasim.B2.a
        public void onTouchExplorationStateChanged(boolean z) {
            AutoCompleteTextView autoCompleteTextView;
            TextInputLayout textInputLayout = d.this.a;
            if (textInputLayout == null || (autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText()) == null || d.H(autoCompleteTextView)) {
                return;
            }
            AbstractC12990fW7.A0(d.this.c, z ? 2 : 1);
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.M((AutoCompleteTextView) d.this.a.getEditText());
        }
    }

    class l implements View.OnTouchListener {
        final /* synthetic */ AutoCompleteTextView a;

        l(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.G()) {
                    d.this.l = false;
                }
                d.this.M(this.a);
                d.this.N();
            }
            return false;
        }
    }

    d(TextInputLayout textInputLayout, int i2) {
        super(textInputLayout, i2);
        this.e = new a();
        this.f = new e();
        this.g = new f(this.a);
        this.h = new g();
        this.i = new h();
        this.j = new i();
        this.k = new j();
        this.l = false;
        this.m = false;
        this.n = Long.MAX_VALUE;
    }

    private void A(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, C10345bV3 c10345bV3) {
        LayerDrawable layerDrawable;
        int iD = WU3.d(autoCompleteTextView, AbstractC12181eA5.colorSurface);
        C10345bV3 c10345bV32 = new C10345bV3(c10345bV3.E());
        int iH = WU3.h(i2, iD, 0.1f);
        c10345bV32.b0(new ColorStateList(iArr, new int[]{iH, 0}));
        if (t) {
            c10345bV32.setTint(iD);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iH, iD});
            C10345bV3 c10345bV33 = new C10345bV3(c10345bV3.E());
            c10345bV33.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, c10345bV32, c10345bV33), c10345bV3});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{c10345bV32, c10345bV3});
        }
        AbstractC12990fW7.t0(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        TextInputLayout textInputLayout;
        if (this.q == null || (textInputLayout = this.a) == null || !AbstractC12990fW7.S(textInputLayout)) {
            return;
        }
        B2.a(this.q, this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AutoCompleteTextView C(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator D(int i2, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(AbstractC6732Ot.a);
        valueAnimatorOfFloat.setDuration(i2);
        valueAnimatorOfFloat.addUpdateListener(new C0192d());
        return valueAnimatorOfFloat;
    }

    private C10345bV3 E(float f2, float f3, float f4, int i2) {
        C11411cx6 c11411cx6M = C11411cx6.a().H(f2).M(f2).w(f3).B(f3).m();
        C10345bV3 c10345bV3M = C10345bV3.m(this.b, f4);
        c10345bV3M.setShapeAppearanceModel(c11411cx6M);
        c10345bV3M.d0(0, i2, 0, i2);
        return c10345bV3M;
    }

    private void F() {
        this.s = D(67, 0.0f, 1.0f);
        ValueAnimator valueAnimatorD = D(50, 1.0f, 0.0f);
        this.r = valueAnimatorD;
        valueAnimatorD.addListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.n;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean H(EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        AccessibilityManager accessibilityManager = this.q;
        if (accessibilityManager != null) {
            B2.b(accessibilityManager, this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z) {
        if (this.m != z) {
            this.m = z;
            this.s.cancel();
            this.r.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(AutoCompleteTextView autoCompleteTextView) {
        if (t) {
            int boxBackgroundMode = this.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.p);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.o);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new l(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f);
        if (t) {
            autoCompleteTextView.setOnDismissListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (G()) {
            this.l = false;
        }
        if (this.l) {
            this.l = false;
            return;
        }
        if (t) {
            J(!this.m);
        } else {
            this.m = !this.m;
            this.c.toggle();
        }
        if (!this.m) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.l = true;
        this.n = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(AutoCompleteTextView autoCompleteTextView) {
        if (H(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.a.getBoxBackgroundMode();
        C10345bV3 boxBackground = this.a.getBoxBackground();
        int iD = WU3.d(autoCompleteTextView, AbstractC12181eA5.colorControlHighlight);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            A(autoCompleteTextView, iD, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            z(autoCompleteTextView, iD, iArr, boxBackground);
        }
    }

    private void z(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, C10345bV3 c10345bV3) {
        int boxBackgroundColor = this.a.getBoxBackgroundColor();
        int[] iArr2 = {WU3.h(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (t) {
            AbstractC12990fW7.t0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), c10345bV3, c10345bV3));
            return;
        }
        C10345bV3 c10345bV32 = new C10345bV3(c10345bV3.E());
        c10345bV32.b0(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{c10345bV3, c10345bV32});
        int iF = AbstractC12990fW7.F(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int iE = AbstractC12990fW7.E(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        AbstractC12990fW7.t0(autoCompleteTextView, layerDrawable);
        AbstractC12990fW7.F0(autoCompleteTextView, iF, paddingTop, iE, paddingBottom);
    }

    void O(AutoCompleteTextView autoCompleteTextView) {
        if (!H(autoCompleteTextView) && this.a.getBoxBackgroundMode() == 2 && (autoCompleteTextView.getBackground() instanceof LayerDrawable)) {
            y(autoCompleteTextView);
        }
    }

    @Override // com.google.android.material.textfield.e
    void a() throws Resources.NotFoundException {
        float dimensionPixelOffset = this.b.getResources().getDimensionPixelOffset(AbstractC12799fB5.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.b.getResources().getDimensionPixelOffset(AbstractC12799fB5.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(AbstractC12799fB5.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        C10345bV3 c10345bV3E = E(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        C10345bV3 c10345bV3E2 = E(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.p = c10345bV3E;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.o = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, c10345bV3E);
        this.o.addState(new int[0], c10345bV3E2);
        int i2 = this.d;
        if (i2 == 0) {
            i2 = t ? HB5.mtrl_dropdown_arrow : HB5.mtrl_ic_arrow_drop_down;
        }
        this.a.setEndIconDrawable(i2);
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(AbstractC23026wD5.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new k());
        this.a.g(this.h);
        this.a.h(this.i);
        F();
        this.q = (AccessibilityManager) this.b.getSystemService("accessibility");
        this.a.addOnAttachStateChangeListener(this.j);
        B();
    }

    @Override // com.google.android.material.textfield.e
    boolean b(int i2) {
        return i2 != 0;
    }

    @Override // com.google.android.material.textfield.e
    boolean d() {
        return true;
    }
}
