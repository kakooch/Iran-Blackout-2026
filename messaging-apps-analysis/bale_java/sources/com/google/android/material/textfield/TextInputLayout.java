package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.r;
import com.google.android.material.internal.CheckableImageButton;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC20604sI1;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.AbstractC23123wO3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC9594aE;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.C18423oe0;
import ir.nasim.C22317v2;
import ir.nasim.GE5;
import ir.nasim.LW0;
import ir.nasim.QA5;
import ir.nasim.WB5;
import ir.nasim.WU3;
import ir.nasim.X2;
import ir.nasim.YC5;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout {
    private static final int y1 = AbstractC21175tE5.Widget_Design_TextInputLayout;
    private CharSequence A;
    private C10345bV3 A0;
    private final TextView B;
    private C11411cx6 B0;
    private boolean C0;
    private boolean D;
    private final int D0;
    private int E0;
    private int F0;
    private CharSequence G;
    private int G0;
    private boolean H;
    private int H0;
    private int I0;
    private C10345bV3 J;
    private int J0;
    private int K0;
    private final Rect L0;
    private final Rect M0;
    private final RectF N0;
    private Typeface O0;
    private Drawable P0;
    private int Q0;
    private final LinkedHashSet R0;
    private int S0;
    private final SparseArray T0;
    private final CheckableImageButton U0;
    private final LinkedHashSet V0;
    private ColorStateList W0;
    private PorterDuff.Mode X0;
    private Drawable Y0;
    private int Z0;
    private final FrameLayout a;
    private Drawable a1;
    private final j b;
    private View.OnLongClickListener b1;
    private final LinearLayout c;
    private View.OnLongClickListener c1;
    private final FrameLayout d;
    private final CheckableImageButton d1;
    EditText e;
    private ColorStateList e1;
    private CharSequence f;
    private PorterDuff.Mode f1;
    private int g;
    private ColorStateList g1;
    private int h;
    private ColorStateList h1;
    private int i;
    private int i1;
    private int j;
    private int j1;
    private final com.google.android.material.textfield.g k;
    private int k1;
    boolean l;
    private ColorStateList l1;
    private int m;
    private int m1;
    private boolean n;
    private int n1;
    private TextView o;
    private int o1;
    private int p;
    private int p1;
    private int q;
    private int q1;
    private CharSequence r;
    private boolean r1;
    private boolean s;
    final LW0 s1;
    private TextView t;
    private boolean t1;
    private ColorStateList u;
    private boolean u1;
    private int v;
    private ValueAnimator v1;
    private Fade w;
    private boolean w1;
    private Fade x;
    private boolean x1;
    private ColorStateList y;
    private ColorStateList z;
    private C10345bV3 z0;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        CharSequence c;
        boolean d;
        CharSequence e;
        CharSequence f;
        CharSequence g;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.c) + " hint=" + ((Object) this.e) + " helperText=" + ((Object) this.f) + " placeholderText=" + ((Object) this.g) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.c, parcel, i);
            parcel.writeInt(this.d ? 1 : 0);
            TextUtils.writeToParcel(this.e, parcel, i);
            TextUtils.writeToParcel(this.f, parcel, i);
            TextUtils.writeToParcel(this.g, parcel, i);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.c = (CharSequence) creator.createFromParcel(parcel);
            this.d = parcel.readInt() == 1;
            this.e = (CharSequence) creator.createFromParcel(parcel);
            this.f = (CharSequence) creator.createFromParcel(parcel);
            this.g = (CharSequence) creator.createFromParcel(parcel);
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.v0(!r0.x1);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.l) {
                textInputLayout.l0(editable.length());
            }
            if (TextInputLayout.this.s) {
                TextInputLayout.this.z0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.U0.performClick();
            TextInputLayout.this.U0.jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.e.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.s1.u0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends C22317v2 {
        private final TextInputLayout d;

        public e(TextInputLayout textInputLayout) {
            this.d = textInputLayout;
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            EditText editText = this.d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.d.getHint();
            CharSequence error = this.d.getError();
            CharSequence placeholderText = this.d.getPlaceholderText();
            int counterMaxLength = this.d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.d.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean z = !zIsEmpty;
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(hint);
            boolean z4 = !this.d.N();
            boolean z5 = !TextUtils.isEmpty(error);
            if (!z5 && TextUtils.isEmpty(counterOverflowDescription)) {
                z2 = false;
            }
            String string = z3 ? hint.toString() : "";
            this.d.b.v(x2);
            if (z) {
                x2.X0(text);
            } else if (!TextUtils.isEmpty(string)) {
                x2.X0(string);
                if (z4 && placeholderText != null) {
                    x2.X0(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                x2.X0(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    x2.C0(string);
                } else {
                    if (z) {
                        string = ((Object) text) + ", " + string;
                    }
                    x2.X0(string);
                }
                x2.T0(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            x2.H0(counterMaxLength);
            if (z2) {
                if (!z5) {
                    error = counterOverflowDescription;
                }
                x2.y0(error);
            }
            View viewS = this.d.k.s();
            if (viewS != null) {
                x2.E0(viewS);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private boolean A() {
        return this.D && !TextUtils.isEmpty(this.G) && (this.J instanceof com.google.android.material.textfield.c);
    }

    private void A0(boolean z, boolean z2) {
        int defaultColor = this.l1.getDefaultColor();
        int colorForState = this.l1.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.l1.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.J0 = colorForState2;
        } else if (z2) {
            this.J0 = colorForState;
        } else {
            this.J0 = defaultColor;
        }
    }

    private void B() {
        Iterator it = this.R0.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(this);
        }
    }

    private void B0() {
        if (this.e == null) {
            return;
        }
        AbstractC12990fW7.F0(this.B, getContext().getResources().getDimensionPixelSize(AbstractC12799fB5.material_input_text_to_prefix_suffix_padding), this.e.getPaddingTop(), (K() || L()) ? 0 : AbstractC12990fW7.E(this.e), this.e.getPaddingBottom());
    }

    private void C(int i) {
        Iterator it = this.V0.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(this, i);
        }
    }

    private void C0() {
        int visibility = this.B.getVisibility();
        int i = (this.A == null || N()) ? 8 : 0;
        if (visibility != i) {
            getEndIconDelegate().c(i == 0);
        }
        s0();
        this.B.setVisibility(i);
        p0();
    }

    private void D(Canvas canvas) {
        C10345bV3 c10345bV3;
        if (this.A0 == null || (c10345bV3 = this.z0) == null) {
            return;
        }
        c10345bV3.draw(canvas);
        if (this.e.isFocused()) {
            Rect bounds = this.A0.getBounds();
            Rect bounds2 = this.z0.getBounds();
            float fD = this.s1.D();
            int iCenterX = bounds2.centerX();
            bounds.left = AbstractC6732Ot.c(iCenterX, bounds2.left, fD);
            bounds.right = AbstractC6732Ot.c(iCenterX, bounds2.right, fD);
            this.A0.draw(canvas);
        }
    }

    private void E(Canvas canvas) {
        if (this.D) {
            this.s1.l(canvas);
        }
    }

    private void F(boolean z) {
        ValueAnimator valueAnimator = this.v1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.v1.cancel();
        }
        if (z && this.u1) {
            k(0.0f);
        } else {
            this.s1.u0(0.0f);
        }
        if (A() && ((com.google.android.material.textfield.c) this.J).q0()) {
            x();
        }
        this.r1 = true;
        J();
        this.b.i(true);
        C0();
    }

    private int G(int i, boolean z) {
        int compoundPaddingLeft = i + this.e.getCompoundPaddingLeft();
        return (getPrefixText() == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    private int H(int i, boolean z) {
        int compoundPaddingRight = i - this.e.getCompoundPaddingRight();
        return (getPrefixText() == null || !z) ? compoundPaddingRight : compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    private boolean I() {
        return this.S0 != 0;
    }

    private void J() {
        TextView textView = this.t;
        if (textView == null || !this.s) {
            return;
        }
        textView.setText((CharSequence) null);
        r.a(this.a, this.x);
        this.t.setVisibility(4);
    }

    private boolean L() {
        return this.d1.getVisibility() == 0;
    }

    private boolean P() {
        return this.E0 == 1 && this.e.getMinLines() <= 1;
    }

    private void Q() {
        o();
        Y();
        D0();
        i0();
        j();
        if (this.E0 != 0) {
            u0();
        }
    }

    private void R() {
        if (A()) {
            RectF rectF = this.N0;
            this.s1.o(rectF, this.e.getWidth(), this.e.getGravity());
            n(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.G0);
            ((com.google.android.material.textfield.c) this.J).t0(rectF);
        }
    }

    private void S() {
        if (!A() || this.r1) {
            return;
        }
        x();
        R();
    }

    private static void T(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                T((ViewGroup) childAt, z);
            }
        }
    }

    private void X() {
        TextView textView = this.t;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void Y() {
        if (f0()) {
            AbstractC12990fW7.t0(this.e, this.J);
        }
    }

    private static void Z(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zO = AbstractC12990fW7.O(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = zO || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zO);
        checkableImageButton.setPressable(zO);
        checkableImageButton.setLongClickable(z);
        AbstractC12990fW7.A0(checkableImageButton, z2 ? 1 : 2);
    }

    private static void a0(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        Z(checkableImageButton, onLongClickListener);
    }

    private static void b0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        Z(checkableImageButton, onLongClickListener);
    }

    private boolean d0() {
        return (this.d1.getVisibility() == 0 || ((I() && K()) || this.A != null)) && this.c.getMeasuredWidth() > 0;
    }

    private boolean e0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.b.getMeasuredWidth() > 0;
    }

    private boolean f0() {
        EditText editText = this.e;
        return (editText == null || this.J == null || editText.getBackground() != null || this.E0 == 0) ? false : true;
    }

    private void g0() {
        if (this.t == null || !this.s || TextUtils.isEmpty(this.r)) {
            return;
        }
        this.t.setText(this.r);
        r.a(this.a, this.w);
        this.t.setVisibility(0);
        this.t.bringToFront();
        announceForAccessibility(this.r);
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = (com.google.android.material.textfield.e) this.T0.get(this.S0);
        return eVar != null ? eVar : (com.google.android.material.textfield.e) this.T0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.d1.getVisibility() == 0) {
            return this.d1;
        }
        if (I() && K()) {
            return this.U0;
        }
        return null;
    }

    private void h0(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            com.google.android.material.textfield.f.a(this, this.U0, this.W0, this.X0);
            return;
        }
        Drawable drawableMutate = AbstractC21710u02.l(getEndIconDrawable()).mutate();
        AbstractC21710u02.h(drawableMutate, this.k.p());
        this.U0.setImageDrawable(drawableMutate);
    }

    private void i() {
        TextView textView = this.t;
        if (textView != null) {
            this.a.addView(textView);
            this.t.setVisibility(0);
        }
    }

    private void i0() {
        if (this.E0 == 1) {
            if (AbstractC9751aV3.j(getContext())) {
                this.F0 = getResources().getDimensionPixelSize(AbstractC12799fB5.material_font_2_0_box_collapsed_padding_top);
            } else if (AbstractC9751aV3.i(getContext())) {
                this.F0 = getResources().getDimensionPixelSize(AbstractC12799fB5.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void j() {
        if (this.e == null || this.E0 != 1) {
            return;
        }
        if (AbstractC9751aV3.j(getContext())) {
            EditText editText = this.e;
            AbstractC12990fW7.F0(editText, AbstractC12990fW7.F(editText), getResources().getDimensionPixelSize(AbstractC12799fB5.material_filled_edittext_font_2_0_padding_top), AbstractC12990fW7.E(this.e), getResources().getDimensionPixelSize(AbstractC12799fB5.material_filled_edittext_font_2_0_padding_bottom));
        } else if (AbstractC9751aV3.i(getContext())) {
            EditText editText2 = this.e;
            AbstractC12990fW7.F0(editText2, AbstractC12990fW7.F(editText2), getResources().getDimensionPixelSize(AbstractC12799fB5.material_filled_edittext_font_1_3_padding_top), AbstractC12990fW7.E(this.e), getResources().getDimensionPixelSize(AbstractC12799fB5.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    private void j0(Rect rect) {
        C10345bV3 c10345bV3 = this.z0;
        if (c10345bV3 != null) {
            int i = rect.bottom;
            c10345bV3.setBounds(rect.left, i - this.H0, rect.right, i);
        }
        C10345bV3 c10345bV32 = this.A0;
        if (c10345bV32 != null) {
            int i2 = rect.bottom;
            c10345bV32.setBounds(rect.left, i2 - this.I0, rect.right, i2);
        }
    }

    private void k0() {
        if (this.o != null) {
            EditText editText = this.e;
            l0(editText == null ? 0 : editText.getText().length());
        }
    }

    private void l() {
        C10345bV3 c10345bV3 = this.J;
        if (c10345bV3 == null) {
            return;
        }
        C11411cx6 c11411cx6E = c10345bV3.E();
        C11411cx6 c11411cx6 = this.B0;
        if (c11411cx6E != c11411cx6) {
            this.J.setShapeAppearanceModel(c11411cx6);
            o0();
        }
        if (v()) {
            this.J.j0(this.G0, this.J0);
        }
        int iP = p();
        this.K0 = iP;
        this.J.b0(ColorStateList.valueOf(iP));
        if (this.S0 == 3) {
            this.e.getBackground().invalidateSelf();
        }
        m();
        invalidate();
    }

    private void m() {
        if (this.z0 == null || this.A0 == null) {
            return;
        }
        if (w()) {
            this.z0.b0(this.e.isFocused() ? ColorStateList.valueOf(this.i1) : ColorStateList.valueOf(this.J0));
            this.A0.b0(ColorStateList.valueOf(this.J0));
        }
        invalidate();
    }

    private static void m0(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? AbstractC23026wD5.character_counter_overflowed_content_description : AbstractC23026wD5.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    private void n(RectF rectF) {
        float f2 = rectF.left;
        int i = this.D0;
        rectF.left = f2 - i;
        rectF.right += i;
    }

    private void n0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.o;
        if (textView != null) {
            c0(textView, this.n ? this.p : this.q);
            if (!this.n && (colorStateList2 = this.y) != null) {
                this.o.setTextColor(colorStateList2);
            }
            if (!this.n || (colorStateList = this.z) == null) {
                return;
            }
            this.o.setTextColor(colorStateList);
        }
    }

    private void o() {
        int i = this.E0;
        if (i == 0) {
            this.J = null;
            this.z0 = null;
            this.A0 = null;
            return;
        }
        if (i == 1) {
            this.J = new C10345bV3(this.B0);
            this.z0 = new C10345bV3();
            this.A0 = new C10345bV3();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(this.E0 + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.D || (this.J instanceof com.google.android.material.textfield.c)) {
                this.J = new C10345bV3(this.B0);
            } else {
                this.J = new com.google.android.material.textfield.c(this.B0);
            }
            this.z0 = null;
            this.A0 = null;
        }
    }

    private void o0() {
        if (this.S0 == 3 && this.E0 == 2) {
            ((com.google.android.material.textfield.d) this.T0.get(3)).O((AutoCompleteTextView) this.e);
        }
    }

    private int p() {
        return this.E0 == 1 ? WU3.g(WU3.e(this, AbstractC12181eA5.colorSurface, 0), this.K0) : this.K0;
    }

    private Rect q(Rect rect) {
        if (this.e == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.M0;
        boolean zJ = AbstractC10402bY7.j(this);
        rect2.bottom = rect.bottom;
        int i = this.E0;
        if (i == 1) {
            rect2.left = G(rect.left, zJ);
            rect2.top = rect.top + this.F0;
            rect2.right = H(rect.right, zJ);
            return rect2;
        }
        if (i != 2) {
            rect2.left = G(rect.left, zJ);
            rect2.top = getPaddingTop();
            rect2.right = H(rect.right, zJ);
            return rect2;
        }
        rect2.left = rect.left + this.e.getPaddingLeft();
        rect2.top = rect.top - u();
        rect2.right = rect.right - this.e.getPaddingRight();
        return rect2;
    }

    private int r(Rect rect, Rect rect2, float f2) {
        return P() ? (int) (rect2.top + f2) : rect.bottom - this.e.getCompoundPaddingBottom();
    }

    private boolean r0() {
        int iMax;
        if (this.e == null || this.e.getMeasuredHeight() >= (iMax = Math.max(this.c.getMeasuredHeight(), this.b.getMeasuredHeight()))) {
            return false;
        }
        this.e.setMinimumHeight(iMax);
        return true;
    }

    private int s(Rect rect, float f2) {
        return P() ? (int) (rect.centerY() - (f2 / 2.0f)) : rect.top + this.e.getCompoundPaddingTop();
    }

    private void s0() {
        this.d.setVisibility((this.U0.getVisibility() != 0 || L()) ? 8 : 0);
        this.c.setVisibility(K() || L() || !((this.A == null || N()) ? 8 : false) ? 0 : 8);
    }

    private void setEditText(EditText editText) {
        if (this.e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.S0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.e = editText;
        int i = this.g;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.i);
        }
        int i2 = this.h;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.j);
        }
        Q();
        setTextInputAccessibilityDelegate(new e(this));
        this.s1.H0(this.e.getTypeface());
        this.s1.r0(this.e.getTextSize());
        this.s1.m0(this.e.getLetterSpacing());
        int gravity = this.e.getGravity();
        this.s1.g0((gravity & (-113)) | 48);
        this.s1.q0(gravity);
        this.e.addTextChangedListener(new a());
        if (this.g1 == null) {
            this.g1 = this.e.getHintTextColors();
        }
        if (this.D) {
            if (TextUtils.isEmpty(this.G)) {
                CharSequence hint = this.e.getHint();
                this.f = hint;
                setHint(hint);
                this.e.setHint((CharSequence) null);
            }
            this.H = true;
        }
        if (this.o != null) {
            l0(this.e.getText().length());
        }
        q0();
        this.k.f();
        this.b.bringToFront();
        this.c.bringToFront();
        this.d.bringToFront();
        this.d1.bringToFront();
        B();
        B0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.G)) {
            return;
        }
        this.G = charSequence;
        this.s1.F0(charSequence);
        if (this.r1) {
            return;
        }
        R();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.s == z) {
            return;
        }
        if (z) {
            i();
        } else {
            X();
            this.t = null;
        }
        this.s = z;
    }

    private Rect t(Rect rect) {
        if (this.e == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.M0;
        float fB = this.s1.B();
        rect2.left = rect.left + this.e.getCompoundPaddingLeft();
        rect2.top = s(rect, fB);
        rect2.right = rect.right - this.e.getCompoundPaddingRight();
        rect2.bottom = r(rect, rect2, fB);
        return rect2;
    }

    private void t0() {
        this.d1.setVisibility(getErrorIconDrawable() != null && this.k.z() && this.k.l() ? 0 : 8);
        s0();
        B0();
        if (I()) {
            return;
        }
        p0();
    }

    private int u() {
        float fR;
        if (!this.D) {
            return 0;
        }
        int i = this.E0;
        if (i == 0) {
            fR = this.s1.r();
        } else {
            if (i != 2) {
                return 0;
            }
            fR = this.s1.r() / 2.0f;
        }
        return (int) fR;
    }

    private void u0() {
        if (this.E0 != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            int iU = u();
            if (iU != layoutParams.topMargin) {
                layoutParams.topMargin = iU;
                this.a.requestLayout();
            }
        }
    }

    private boolean v() {
        return this.E0 == 2 && w();
    }

    private boolean w() {
        return this.G0 > -1 && this.J0 != 0;
    }

    private void w0(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.e;
        boolean z3 = false;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.e;
        if (editText2 != null && editText2.hasFocus()) {
            z3 = true;
        }
        boolean zL = this.k.l();
        ColorStateList colorStateList2 = this.g1;
        if (colorStateList2 != null) {
            this.s1.f0(colorStateList2);
            this.s1.p0(this.g1);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.g1;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.q1) : this.q1;
            this.s1.f0(ColorStateList.valueOf(colorForState));
            this.s1.p0(ColorStateList.valueOf(colorForState));
        } else if (zL) {
            this.s1.f0(this.k.q());
        } else if (this.n && (textView = this.o) != null) {
            this.s1.f0(textView.getTextColors());
        } else if (z3 && (colorStateList = this.h1) != null) {
            this.s1.f0(colorStateList);
        }
        if (z4 || !this.t1 || (isEnabled() && z3)) {
            if (z2 || this.r1) {
                y(z);
                return;
            }
            return;
        }
        if (z2 || !this.r1) {
            F(z);
        }
    }

    private void x() {
        if (A()) {
            ((com.google.android.material.textfield.c) this.J).r0();
        }
    }

    private void x0() {
        EditText editText;
        if (this.t == null || (editText = this.e) == null) {
            return;
        }
        this.t.setGravity(editText.getGravity());
        this.t.setPadding(this.e.getCompoundPaddingLeft(), this.e.getCompoundPaddingTop(), this.e.getCompoundPaddingRight(), this.e.getCompoundPaddingBottom());
    }

    private void y(boolean z) {
        ValueAnimator valueAnimator = this.v1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.v1.cancel();
        }
        if (z && this.u1) {
            k(1.0f);
        } else {
            this.s1.u0(1.0f);
        }
        this.r1 = false;
        if (A()) {
            R();
        }
        y0();
        this.b.i(false);
        C0();
    }

    private void y0() {
        EditText editText = this.e;
        z0(editText == null ? 0 : editText.getText().length());
    }

    private Fade z() {
        Fade fade = new Fade();
        fade.b0(87L);
        fade.e0(AbstractC6732Ot.a);
        return fade;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(int i) {
        if (i != 0 || this.r1) {
            J();
        } else {
            g0();
        }
    }

    void D0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.J == null || this.E0 == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.e) != null && editText.isHovered())) {
            z = true;
        }
        if (!isEnabled()) {
            this.J0 = this.q1;
        } else if (this.k.l()) {
            if (this.l1 != null) {
                A0(z2, z);
            } else {
                this.J0 = this.k.p();
            }
        } else if (!this.n || (textView = this.o) == null) {
            if (z2) {
                this.J0 = this.k1;
            } else if (z) {
                this.J0 = this.j1;
            } else {
                this.J0 = this.i1;
            }
        } else if (this.l1 != null) {
            A0(z2, z);
        } else {
            this.J0 = textView.getCurrentTextColor();
        }
        t0();
        V();
        W();
        U();
        if (getEndIconDelegate().d()) {
            h0(this.k.l());
        }
        if (this.E0 == 2) {
            int i = this.G0;
            if (z2 && isEnabled()) {
                this.G0 = this.I0;
            } else {
                this.G0 = this.H0;
            }
            if (this.G0 != i) {
                S();
            }
        }
        if (this.E0 == 1) {
            if (!isEnabled()) {
                this.K0 = this.n1;
            } else if (z && !z2) {
                this.K0 = this.p1;
            } else if (z2) {
                this.K0 = this.o1;
            } else {
                this.K0 = this.m1;
            }
        }
        l();
    }

    public boolean K() {
        return this.d.getVisibility() == 0 && this.U0.getVisibility() == 0;
    }

    public boolean M() {
        return this.k.A();
    }

    final boolean N() {
        return this.r1;
    }

    public boolean O() {
        return this.H;
    }

    public void U() {
        com.google.android.material.textfield.f.c(this, this.U0, this.W0);
    }

    public void V() {
        com.google.android.material.textfield.f.c(this, this.d1, this.e1);
    }

    public void W() {
        this.b.j();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.a.addView(view, layoutParams2);
        this.a.setLayoutParams(layoutParams);
        u0();
        setEditText((EditText) view);
    }

    void c0(TextView textView, int i) {
        try {
            AbstractC15575jo7.p(textView, i);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        AbstractC15575jo7.p(textView, AbstractC21175tE5.TextAppearance_AppCompat_Caption);
        textView.setTextColor(AbstractC4043Dl1.c(getContext(), QA5.design_error));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.f != null) {
            boolean z = this.H;
            this.H = false;
            CharSequence hint = editText.getHint();
            this.e.setHint(this.f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.e.setHint(hint);
                this.H = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        viewStructure.setChildCount(this.a.getChildCount());
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            View childAt = this.a.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.x1 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.x1 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.w1) {
            return;
        }
        this.w1 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        LW0 lw0 = this.s1;
        boolean zE0 = lw0 != null ? lw0.E0(drawableState) : false;
        if (this.e != null) {
            v0(AbstractC12990fW7.T(this) && isEnabled());
        }
        q0();
        D0();
        if (zE0) {
            invalidate();
        }
        this.w1 = false;
    }

    public void g(f fVar) {
        this.R0.add(fVar);
        if (this.e != null) {
            fVar.a(this);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.e;
        return editText != null ? editText.getBaseline() + getPaddingTop() + u() : super.getBaseline();
    }

    C10345bV3 getBoxBackground() {
        int i = this.E0;
        if (i == 1 || i == 2) {
            return this.J;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.K0;
    }

    public int getBoxBackgroundMode() {
        return this.E0;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.F0;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return AbstractC10402bY7.j(this) ? this.B0.j().a(this.N0) : this.B0.l().a(this.N0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return AbstractC10402bY7.j(this) ? this.B0.l().a(this.N0) : this.B0.j().a(this.N0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return AbstractC10402bY7.j(this) ? this.B0.r().a(this.N0) : this.B0.t().a(this.N0);
    }

    public float getBoxCornerRadiusTopStart() {
        return AbstractC10402bY7.j(this) ? this.B0.t().a(this.N0) : this.B0.r().a(this.N0);
    }

    public int getBoxStrokeColor() {
        return this.k1;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.l1;
    }

    public int getBoxStrokeWidth() {
        return this.H0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.I0;
    }

    public int getCounterMaxLength() {
        return this.m;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.l && this.n && (textView = this.o) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.y;
    }

    public ColorStateList getCounterTextColor() {
        return this.y;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.g1;
    }

    public EditText getEditText() {
        return this.e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.U0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.U0.getDrawable();
    }

    public int getEndIconMode() {
        return this.S0;
    }

    CheckableImageButton getEndIconView() {
        return this.U0;
    }

    public CharSequence getError() {
        if (this.k.z()) {
            return this.k.o();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.k.n();
    }

    public int getErrorCurrentTextColors() {
        return this.k.p();
    }

    public Drawable getErrorIconDrawable() {
        return this.d1.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.k.p();
    }

    public CharSequence getHelperText() {
        if (this.k.A()) {
            return this.k.r();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.k.t();
    }

    public CharSequence getHint() {
        if (this.D) {
            return this.G;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.s1.r();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.s1.v();
    }

    public ColorStateList getHintTextColor() {
        return this.h1;
    }

    public int getMaxEms() {
        return this.h;
    }

    public int getMaxWidth() {
        return this.j;
    }

    public int getMinEms() {
        return this.g;
    }

    public int getMinWidth() {
        return this.i;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.U0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.U0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.s) {
            return this.r;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.v;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.u;
    }

    public CharSequence getPrefixText() {
        return this.b.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.b.b();
    }

    public TextView getPrefixTextView() {
        return this.b.c();
    }

    public CharSequence getStartIconContentDescription() {
        return this.b.d();
    }

    public Drawable getStartIconDrawable() {
        return this.b.e();
    }

    public CharSequence getSuffixText() {
        return this.A;
    }

    public ColorStateList getSuffixTextColor() {
        return this.B.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.B;
    }

    public Typeface getTypeface() {
        return this.O0;
    }

    public void h(g gVar) {
        this.V0.add(gVar);
    }

    void k(float f2) {
        if (this.s1.D() == f2) {
            return;
        }
        if (this.v1 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.v1 = valueAnimator;
            valueAnimator.setInterpolator(AbstractC6732Ot.b);
            this.v1.setDuration(167L);
            this.v1.addUpdateListener(new d());
        }
        this.v1.setFloatValues(this.s1.D(), f2);
        this.v1.start();
    }

    void l0(int i) {
        boolean z = this.n;
        int i2 = this.m;
        if (i2 == -1) {
            this.o.setText(String.valueOf(i));
            this.o.setContentDescription(null);
            this.n = false;
        } else {
            this.n = i > i2;
            m0(getContext(), this.o, i, this.m, this.n);
            if (z != this.n) {
                n0();
            }
            this.o.setText(C18423oe0.c().k(getContext().getString(AbstractC23026wD5.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.m))));
        }
        if (this.e == null || z == this.n) {
            return;
        }
        v0(false);
        D0();
        q0();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.s1.V(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.e;
        if (editText != null) {
            Rect rect = this.L0;
            AbstractC20604sI1.a(this, editText, rect);
            j0(rect);
            if (this.D) {
                this.s1.r0(this.e.getTextSize());
                int gravity = this.e.getGravity();
                this.s1.g0((gravity & (-113)) | 48);
                this.s1.q0(gravity);
                this.s1.c0(q(rect));
                this.s1.l0(t(rect));
                this.s1.Y();
                if (!A() || this.r1) {
                    return;
                }
                R();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean zR0 = r0();
        boolean zP0 = p0();
        if (zR0 || zP0) {
            this.e.post(new c());
        }
        x0();
        B0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.c);
        if (savedState.d) {
            this.U0.post(new b());
        }
        setHint(savedState.e);
        setHelperText(savedState.f);
        setPlaceholderText(savedState.g);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = false;
        boolean z2 = i == 1;
        boolean z3 = this.C0;
        if (z2 != z3) {
            if (z2 && !z3) {
                z = true;
            }
            float fA = this.B0.r().a(this.N0);
            float fA2 = this.B0.t().a(this.N0);
            float fA3 = this.B0.j().a(this.N0);
            float fA4 = this.B0.l().a(this.N0);
            float f2 = z ? fA : fA2;
            if (z) {
                fA = fA2;
            }
            float f3 = z ? fA3 : fA4;
            if (z) {
                fA3 = fA4;
            }
            setBoxCornerRadii(f2, fA, f3, fA3);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.k.l()) {
            savedState.c = getError();
        }
        savedState.d = I() && this.U0.isChecked();
        savedState.e = getHint();
        savedState.f = getHelperText();
        savedState.g = getPlaceholderText();
        return savedState;
    }

    boolean p0() {
        boolean z;
        if (this.e == null) {
            return false;
        }
        boolean z2 = true;
        if (e0()) {
            int measuredWidth = this.b.getMeasuredWidth() - this.e.getPaddingLeft();
            if (this.P0 == null || this.Q0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.P0 = colorDrawable;
                this.Q0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrA = AbstractC15575jo7.a(this.e);
            Drawable drawable = drawableArrA[0];
            Drawable drawable2 = this.P0;
            if (drawable != drawable2) {
                AbstractC15575jo7.j(this.e, drawable2, drawableArrA[1], drawableArrA[2], drawableArrA[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.P0 != null) {
                Drawable[] drawableArrA2 = AbstractC15575jo7.a(this.e);
                AbstractC15575jo7.j(this.e, null, drawableArrA2[1], drawableArrA2[2], drawableArrA2[3]);
                this.P0 = null;
                z = true;
            }
            z = false;
        }
        if (d0()) {
            int measuredWidth2 = this.B.getMeasuredWidth() - this.e.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + AbstractC23123wO3.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] drawableArrA3 = AbstractC15575jo7.a(this.e);
            Drawable drawable3 = this.Y0;
            if (drawable3 == null || this.Z0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.Y0 = colorDrawable2;
                    this.Z0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrA3[2];
                Drawable drawable5 = this.Y0;
                if (drawable4 != drawable5) {
                    this.a1 = drawable4;
                    AbstractC15575jo7.j(this.e, drawableArrA3[0], drawableArrA3[1], drawable5, drawableArrA3[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.Z0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                AbstractC15575jo7.j(this.e, drawableArrA3[0], drawableArrA3[1], this.Y0, drawableArrA3[3]);
            }
        } else {
            if (this.Y0 == null) {
                return z;
            }
            Drawable[] drawableArrA4 = AbstractC15575jo7.a(this.e);
            if (drawableArrA4[2] == this.Y0) {
                AbstractC15575jo7.j(this.e, drawableArrA4[0], drawableArrA4[1], this.a1, drawableArrA4[3]);
            } else {
                z2 = z;
            }
            this.Y0 = null;
        }
        return z2;
    }

    void q0() {
        Drawable background;
        TextView textView;
        EditText editText = this.e;
        if (editText == null || this.E0 != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.r.a(background)) {
            background = background.mutate();
        }
        if (this.k.l()) {
            background.setColorFilter(androidx.appcompat.widget.g.e(this.k.p(), PorterDuff.Mode.SRC_IN));
        } else if (this.n && (textView = this.o) != null) {
            background.setColorFilter(androidx.appcompat.widget.g.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            AbstractC21710u02.a(background);
            this.e.refreshDrawableState();
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.K0 != i) {
            this.K0 = i;
            this.m1 = i;
            this.o1 = i;
            this.p1 = i;
            l();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(AbstractC4043Dl1.c(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.m1 = defaultColor;
        this.K0 = defaultColor;
        this.n1 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.o1 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.p1 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        l();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.E0) {
            return;
        }
        this.E0 = i;
        if (this.e != null) {
            Q();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.F0 = i;
    }

    public void setBoxCornerRadii(float f2, float f3, float f4, float f5) {
        boolean zJ = AbstractC10402bY7.j(this);
        this.C0 = zJ;
        float f6 = zJ ? f3 : f2;
        if (!zJ) {
            f2 = f3;
        }
        float f7 = zJ ? f5 : f4;
        if (!zJ) {
            f4 = f5;
        }
        C10345bV3 c10345bV3 = this.J;
        if (c10345bV3 != null && c10345bV3.J() == f6 && this.J.K() == f2 && this.J.s() == f7 && this.J.t() == f4) {
            return;
        }
        this.B0 = this.B0.v().H(f6).M(f2).w(f7).B(f4).m();
        l();
    }

    public void setBoxCornerRadiiResources(int i, int i2, int i3, int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i3));
    }

    public void setBoxStrokeColor(int i) {
        if (this.k1 != i) {
            this.k1 = i;
            D0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.i1 = colorStateList.getDefaultColor();
            this.q1 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.j1 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.k1 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.k1 != colorStateList.getDefaultColor()) {
            this.k1 = colorStateList.getDefaultColor();
        }
        D0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.l1 != colorStateList) {
            this.l1 = colorStateList;
            D0();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.H0 = i;
        D0();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.I0 = i;
        D0();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.l != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.o = appCompatTextView;
                appCompatTextView.setId(WB5.textinput_counter);
                Typeface typeface = this.O0;
                if (typeface != null) {
                    this.o.setTypeface(typeface);
                }
                this.o.setMaxLines(1);
                this.k.e(this.o, 2);
                AbstractC23123wO3.d((ViewGroup.MarginLayoutParams) this.o.getLayoutParams(), getResources().getDimensionPixelOffset(AbstractC12799fB5.mtrl_textinput_counter_margin_start));
                n0();
                k0();
            } else {
                this.k.B(this.o, 2);
                this.o = null;
            }
            this.l = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.m != i) {
            if (i > 0) {
                this.m = i;
            } else {
                this.m = -1;
            }
            if (this.l) {
                k0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.p != i) {
            this.p = i;
            n0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            n0();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.q != i) {
            this.q = i;
            n0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.y != colorStateList) {
            this.y = colorStateList;
            n0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.g1 = colorStateList;
        this.h1 = colorStateList;
        if (this.e != null) {
            v0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        T(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.U0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.U0.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? AbstractC9594aE.b(getContext(), i) : null);
    }

    public void setEndIconMode(int i) {
        int i2 = this.S0;
        if (i2 == i) {
            return;
        }
        this.S0 = i;
        C(i2);
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().b(this.E0)) {
            getEndIconDelegate().a();
            com.google.android.material.textfield.f.a(this, this.U0, this.W0, this.X0);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.E0 + " is not supported by the end icon mode " + i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        a0(this.U0, onClickListener, this.b1);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b1 = onLongClickListener;
        b0(this.U0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.W0 != colorStateList) {
            this.W0 = colorStateList;
            com.google.android.material.textfield.f.a(this, this.U0, colorStateList, this.X0);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.X0 != mode) {
            this.X0 = mode;
            com.google.android.material.textfield.f.a(this, this.U0, this.W0, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        if (K() != z) {
            this.U0.setVisibility(z ? 0 : 8);
            s0();
            B0();
            p0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.k.z()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.k.v();
        } else {
            this.k.O(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.k.D(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.k.E(z);
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? AbstractC9594aE.b(getContext(), i) : null);
        V();
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        a0(this.d1, onClickListener, this.c1);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.c1 = onLongClickListener;
        b0(this.d1, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        if (this.e1 != colorStateList) {
            this.e1 = colorStateList;
            com.google.android.material.textfield.f.a(this, this.d1, colorStateList, this.f1);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        if (this.f1 != mode) {
            this.f1 = mode;
            com.google.android.material.textfield.f.a(this, this.d1, this.e1, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        this.k.F(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.k.G(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.t1 != z) {
            this.t1 = z;
            v0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (M()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!M()) {
                setHelperTextEnabled(true);
            }
            this.k.P(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.k.J(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.k.I(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.k.H(i);
    }

    public void setHint(CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.u1 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.D) {
            this.D = z;
            if (z) {
                CharSequence hint = this.e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.G)) {
                        setHint(hint);
                    }
                    this.e.setHint((CharSequence) null);
                }
                this.H = true;
            } else {
                this.H = false;
                if (!TextUtils.isEmpty(this.G) && TextUtils.isEmpty(this.e.getHint())) {
                    this.e.setHint(this.G);
                }
                setHintInternal(null);
            }
            if (this.e != null) {
                u0();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.s1.d0(i);
        this.h1 = this.s1.p();
        if (this.e != null) {
            v0(false);
            u0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.h1 != colorStateList) {
            if (this.g1 == null) {
                this.s1.f0(colorStateList);
            }
            this.h1 = colorStateList;
            if (this.e != null) {
                v0(false);
            }
        }
    }

    public void setMaxEms(int i) {
        this.h = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.j = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.g = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.i = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AbstractC9594aE.b(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.S0 != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.W0 = colorStateList;
        com.google.android.material.textfield.f.a(this, this.U0, colorStateList, this.X0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.X0 = mode;
        com.google.android.material.textfield.f.a(this, this.U0, this.W0, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.t == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.t = appCompatTextView;
            appCompatTextView.setId(WB5.textinput_placeholder);
            AbstractC12990fW7.A0(this.t, 2);
            Fade fadeZ = z();
            this.w = fadeZ;
            fadeZ.i0(67L);
            this.x = z();
            setPlaceholderTextAppearance(this.v);
            setPlaceholderTextColor(this.u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.s) {
                setPlaceholderTextEnabled(true);
            }
            this.r = charSequence;
        }
        y0();
    }

    public void setPlaceholderTextAppearance(int i) {
        this.v = i;
        TextView textView = this.t;
        if (textView != null) {
            AbstractC15575jo7.p(textView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            TextView textView = this.t;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.b.k(charSequence);
    }

    public void setPrefixTextAppearance(int i) {
        this.b.l(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.b.m(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.b.n(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? AbstractC9594aE.b(getContext(), i) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.b.q(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b.r(onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.b.s(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.b.t(mode);
    }

    public void setStartIconVisible(boolean z) {
        this.b.u(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.A = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.B.setText(charSequence);
        C0();
    }

    public void setSuffixTextAppearance(int i) {
        AbstractC15575jo7.p(this.B, i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.B.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.e;
        if (editText != null) {
            AbstractC12990fW7.p0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.O0) {
            this.O0 = typeface;
            this.s1.H0(typeface);
            this.k.L(typeface);
            TextView textView = this.o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void v0(boolean z) {
        w0(z, false);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.textInputStyle);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.U0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.U0.setImageDrawable(drawable);
        if (drawable != null) {
            com.google.android.material.textfield.f.a(this, this.U0, this.W0, this.X0);
            U();
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.b.o(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.b.p(drawable);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v43 */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        int i2;
        ?? r4;
        View view;
        int iN;
        int i3 = y1;
        super(AbstractC17750nV3.c(context, attributeSet, i, i3), attributeSet, i);
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = new com.google.android.material.textfield.g(this);
        this.L0 = new Rect();
        this.M0 = new Rect();
        this.N0 = new RectF();
        this.R0 = new LinkedHashSet();
        this.S0 = 0;
        SparseArray sparseArray = new SparseArray();
        this.T0 = sparseArray;
        this.V0 = new LinkedHashSet();
        LW0 lw0 = new LW0(this);
        this.s1 = lw0;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.a = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.d = frameLayout2;
        LinearLayout linearLayout = new LinearLayout(context2);
        this.c = linearLayout;
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.B = appCompatTextView;
        linearLayout.setVisibility(8);
        frameLayout2.setVisibility(8);
        appCompatTextView.setVisibility(8);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context2);
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflaterFrom.inflate(YC5.design_text_input_end_icon, (ViewGroup) linearLayout, false);
        this.d1 = checkableImageButton;
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) layoutInflaterFrom.inflate(YC5.design_text_input_end_icon, (ViewGroup) frameLayout2, false);
        this.U0 = checkableImageButton2;
        frameLayout.setAddStatesFromChildren(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = AbstractC6732Ot.a;
        lw0.G0(timeInterpolator);
        lw0.C0(timeInterpolator);
        lw0.g0(8388659);
        C cI = AbstractC5729Ko7.i(context2, attributeSet, GE5.TextInputLayout, i, i3, GE5.TextInputLayout_counterTextAppearance, GE5.TextInputLayout_counterOverflowTextAppearance, GE5.TextInputLayout_errorTextAppearance, GE5.TextInputLayout_helperTextTextAppearance, GE5.TextInputLayout_hintTextAppearance);
        j jVar = new j(this, cI);
        this.b = jVar;
        this.D = cI.a(GE5.TextInputLayout_hintEnabled, true);
        setHint(cI.p(GE5.TextInputLayout_android_hint));
        this.u1 = cI.a(GE5.TextInputLayout_hintAnimationEnabled, true);
        this.t1 = cI.a(GE5.TextInputLayout_expandedHintEnabled, true);
        if (cI.s(GE5.TextInputLayout_android_minEms)) {
            i2 = -1;
            setMinEms(cI.k(GE5.TextInputLayout_android_minEms, -1));
        } else {
            i2 = -1;
            if (cI.s(GE5.TextInputLayout_android_minWidth)) {
                setMinWidth(cI.f(GE5.TextInputLayout_android_minWidth, -1));
            }
        }
        if (cI.s(GE5.TextInputLayout_android_maxEms)) {
            setMaxEms(cI.k(GE5.TextInputLayout_android_maxEms, i2));
        } else if (cI.s(GE5.TextInputLayout_android_maxWidth)) {
            setMaxWidth(cI.f(GE5.TextInputLayout_android_maxWidth, i2));
        }
        this.B0 = C11411cx6.e(context2, attributeSet, i, i3).m();
        this.D0 = context2.getResources().getDimensionPixelOffset(AbstractC12799fB5.mtrl_textinput_box_label_cutout_padding);
        this.F0 = cI.e(GE5.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.H0 = cI.f(GE5.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_textinput_box_stroke_width_default));
        this.I0 = cI.f(GE5.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_textinput_box_stroke_width_focused));
        this.G0 = this.H0;
        float fD = cI.d(GE5.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fD2 = cI.d(GE5.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fD3 = cI.d(GE5.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fD4 = cI.d(GE5.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        C11411cx6.b bVarV = this.B0.v();
        if (fD >= 0.0f) {
            bVarV.H(fD);
        }
        if (fD2 >= 0.0f) {
            bVarV.M(fD2);
        }
        if (fD3 >= 0.0f) {
            bVarV.B(fD3);
        }
        if (fD4 >= 0.0f) {
            bVarV.w(fD4);
        }
        this.B0 = bVarV.m();
        ColorStateList colorStateListB = AbstractC9751aV3.b(context2, cI, GE5.TextInputLayout_boxBackgroundColor);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.m1 = defaultColor;
            this.K0 = defaultColor;
            if (colorStateListB.isStateful()) {
                this.n1 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.o1 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.p1 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.o1 = this.m1;
                ColorStateList colorStateListA = AbstractC9594aE.a(context2, QA5.mtrl_filled_background_color);
                this.n1 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.p1 = colorStateListA.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.K0 = 0;
            this.m1 = 0;
            this.n1 = 0;
            this.o1 = 0;
            this.p1 = 0;
        }
        if (cI.s(GE5.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListC = cI.c(GE5.TextInputLayout_android_textColorHint);
            this.h1 = colorStateListC;
            this.g1 = colorStateListC;
        }
        ColorStateList colorStateListB2 = AbstractC9751aV3.b(context2, cI, GE5.TextInputLayout_boxStrokeColor);
        this.k1 = cI.b(GE5.TextInputLayout_boxStrokeColor, 0);
        this.i1 = AbstractC4043Dl1.c(context2, QA5.mtrl_textinput_default_box_stroke_color);
        this.q1 = AbstractC4043Dl1.c(context2, QA5.mtrl_textinput_disabled_color);
        this.j1 = AbstractC4043Dl1.c(context2, QA5.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        if (cI.s(GE5.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(AbstractC9751aV3.b(context2, cI, GE5.TextInputLayout_boxStrokeErrorColor));
        }
        if (cI.n(GE5.TextInputLayout_hintTextAppearance, -1) != -1) {
            r4 = 0;
            setHintTextAppearance(cI.n(GE5.TextInputLayout_hintTextAppearance, 0));
        } else {
            r4 = 0;
        }
        int iN2 = cI.n(GE5.TextInputLayout_errorTextAppearance, r4);
        CharSequence charSequenceP = cI.p(GE5.TextInputLayout_errorContentDescription);
        boolean zA = cI.a(GE5.TextInputLayout_errorEnabled, r4);
        checkableImageButton.setId(WB5.text_input_error_icon);
        if (AbstractC9751aV3.i(context2)) {
            AbstractC23123wO3.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), r4);
        }
        if (cI.s(GE5.TextInputLayout_errorIconTint)) {
            this.e1 = AbstractC9751aV3.b(context2, cI, GE5.TextInputLayout_errorIconTint);
        }
        if (cI.s(GE5.TextInputLayout_errorIconTintMode)) {
            this.f1 = AbstractC10402bY7.k(cI.k(GE5.TextInputLayout_errorIconTintMode, -1), null);
        }
        if (cI.s(GE5.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(cI.g(GE5.TextInputLayout_errorIconDrawable));
        }
        checkableImageButton.setContentDescription(getResources().getText(AbstractC23026wD5.error_icon_content_description));
        AbstractC12990fW7.A0(checkableImageButton, 2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int iN3 = cI.n(GE5.TextInputLayout_helperTextTextAppearance, 0);
        boolean zA2 = cI.a(GE5.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceP2 = cI.p(GE5.TextInputLayout_helperText);
        int iN4 = cI.n(GE5.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence charSequenceP3 = cI.p(GE5.TextInputLayout_placeholderText);
        int iN5 = cI.n(GE5.TextInputLayout_suffixTextAppearance, 0);
        CharSequence charSequenceP4 = cI.p(GE5.TextInputLayout_suffixText);
        boolean zA3 = cI.a(GE5.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(cI.k(GE5.TextInputLayout_counterMaxLength, -1));
        this.q = cI.n(GE5.TextInputLayout_counterTextAppearance, 0);
        this.p = cI.n(GE5.TextInputLayout_counterOverflowTextAppearance, 0);
        setBoxBackgroundMode(cI.k(GE5.TextInputLayout_boxBackgroundMode, 0));
        if (AbstractC9751aV3.i(context2)) {
            AbstractC23123wO3.d((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        int iN6 = cI.n(GE5.TextInputLayout_endIconDrawable, 0);
        sparseArray.append(-1, new com.google.android.material.textfield.b(this, iN6));
        sparseArray.append(0, new h(this));
        if (iN6 == 0) {
            view = checkableImageButton;
            iN = cI.n(GE5.TextInputLayout_passwordToggleDrawable, 0);
        } else {
            view = checkableImageButton;
            iN = iN6;
        }
        sparseArray.append(1, new i(this, iN));
        sparseArray.append(2, new com.google.android.material.textfield.a(this, iN6));
        sparseArray.append(3, new com.google.android.material.textfield.d(this, iN6));
        if (!cI.s(GE5.TextInputLayout_passwordToggleEnabled)) {
            if (cI.s(GE5.TextInputLayout_endIconTint)) {
                this.W0 = AbstractC9751aV3.b(context2, cI, GE5.TextInputLayout_endIconTint);
            }
            if (cI.s(GE5.TextInputLayout_endIconTintMode)) {
                this.X0 = AbstractC10402bY7.k(cI.k(GE5.TextInputLayout_endIconTintMode, -1), null);
            }
        }
        if (cI.s(GE5.TextInputLayout_endIconMode)) {
            setEndIconMode(cI.k(GE5.TextInputLayout_endIconMode, 0));
            if (cI.s(GE5.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(cI.p(GE5.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(cI.a(GE5.TextInputLayout_endIconCheckable, true));
        } else if (cI.s(GE5.TextInputLayout_passwordToggleEnabled)) {
            if (cI.s(GE5.TextInputLayout_passwordToggleTint)) {
                this.W0 = AbstractC9751aV3.b(context2, cI, GE5.TextInputLayout_passwordToggleTint);
            }
            if (cI.s(GE5.TextInputLayout_passwordToggleTintMode)) {
                this.X0 = AbstractC10402bY7.k(cI.k(GE5.TextInputLayout_passwordToggleTintMode, -1), null);
            }
            setEndIconMode(cI.a(GE5.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconContentDescription(cI.p(GE5.TextInputLayout_passwordToggleContentDescription));
        }
        appCompatTextView.setId(WB5.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        AbstractC12990fW7.r0(appCompatTextView, 1);
        setErrorContentDescription(charSequenceP);
        setCounterOverflowTextAppearance(this.p);
        setHelperTextTextAppearance(iN3);
        setErrorTextAppearance(iN2);
        setCounterTextAppearance(this.q);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN4);
        setSuffixTextAppearance(iN5);
        if (cI.s(GE5.TextInputLayout_errorTextColor)) {
            setErrorTextColor(cI.c(GE5.TextInputLayout_errorTextColor));
        }
        if (cI.s(GE5.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(cI.c(GE5.TextInputLayout_helperTextTextColor));
        }
        if (cI.s(GE5.TextInputLayout_hintTextColor)) {
            setHintTextColor(cI.c(GE5.TextInputLayout_hintTextColor));
        }
        if (cI.s(GE5.TextInputLayout_counterTextColor)) {
            setCounterTextColor(cI.c(GE5.TextInputLayout_counterTextColor));
        }
        if (cI.s(GE5.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(cI.c(GE5.TextInputLayout_counterOverflowTextColor));
        }
        if (cI.s(GE5.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(cI.c(GE5.TextInputLayout_placeholderTextColor));
        }
        if (cI.s(GE5.TextInputLayout_suffixTextColor)) {
            setSuffixTextColor(cI.c(GE5.TextInputLayout_suffixTextColor));
        }
        setEnabled(cI.a(GE5.TextInputLayout_android_enabled, true));
        cI.w();
        AbstractC12990fW7.A0(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            AbstractC12990fW7.C0(this, 1);
        }
        frameLayout2.addView(checkableImageButton2);
        linearLayout.addView(appCompatTextView);
        linearLayout.addView(view);
        linearLayout.addView(frameLayout2);
        frameLayout.addView(jVar);
        frameLayout.addView(linearLayout);
        addView(frameLayout);
        setHelperTextEnabled(zA2);
        setErrorEnabled(zA);
        setCounterEnabled(zA3);
        setHelperText(charSequenceP2);
        setSuffixText(charSequenceP4);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.d1.setImageDrawable(drawable);
        t0();
        com.google.android.material.textfield.f.a(this, this.d1, this.e1, this.f1);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.U0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.U0.setImageDrawable(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }
}
