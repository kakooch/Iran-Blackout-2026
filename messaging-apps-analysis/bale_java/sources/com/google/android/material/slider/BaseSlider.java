package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.slider.BaseSlider;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC20604sI1;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC22084ue2;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC9594aE;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.C9384Zr7;
import ir.nasim.GE5;
import ir.nasim.InterfaceC17181mX7;
import ir.nasim.InterfaceC4342Es3;
import ir.nasim.InterfaceC5362Ja0;
import ir.nasim.M02;
import ir.nasim.QA5;
import ir.nasim.X2;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L, T extends InterfaceC5362Ja0> extends View {
    private static final String T0 = "BaseSlider";
    static final int U0 = AbstractC21175tE5.Widget_MaterialComponents_Slider;
    private int A;
    private int A0;
    private float B;
    private int B0;
    private float C0;
    private MotionEvent D;
    private float[] D0;
    private boolean E0;
    private int F0;
    private boolean G;
    private boolean G0;
    private float H;
    private boolean H0;
    private boolean I0;
    private float J;
    private ColorStateList J0;
    private ColorStateList K0;
    private ColorStateList L0;
    private ColorStateList M0;
    private ColorStateList N0;
    private final C10345bV3 O0;
    private Drawable P0;
    private List Q0;
    private float R0;
    private int S0;
    private final Paint a;
    private final Paint b;
    private final Paint c;
    private final Paint d;
    private final Paint e;
    private final Paint f;
    private final e g;
    private final AccessibilityManager h;
    private d i;
    private final f j;
    private final List k;
    private final List l;
    private final List m;
    private boolean n;
    private ValueAnimator o;
    private ValueAnimator p;
    private final int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;
    private ArrayList z0;

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();
        float a;
        float b;
        ArrayList c;
        float d;
        boolean e;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i) {
                return new SliderState[i];
            }
        }

        /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeList(this.c);
            parcel.writeFloat(this.d);
            parcel.writeBooleanArray(new boolean[]{this.e});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readFloat();
            this.b = parcel.readFloat();
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.d = parcel.readFloat();
            this.e = parcel.createBooleanArray()[0];
        }
    }

    class a implements f {
        final /* synthetic */ AttributeSet a;
        final /* synthetic */ int b;

        a(AttributeSet attributeSet, int i) {
            this.a = attributeSet;
            this.b = i;
        }

        @Override // com.google.android.material.slider.BaseSlider.f
        public C9384Zr7 a() {
            TypedArray typedArrayH = AbstractC5729Ko7.h(BaseSlider.this.getContext(), this.a, GE5.Slider, this.b, BaseSlider.U0, new int[0]);
            C9384Zr7 c9384Zr7Z = BaseSlider.Z(BaseSlider.this.getContext(), typedArrayH);
            typedArrayH.recycle();
            return c9384Zr7Z;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = BaseSlider.this.k.iterator();
            while (it.hasNext()) {
                ((C9384Zr7) it.next()).B0(fFloatValue);
            }
            AbstractC12990fW7.g0(BaseSlider.this);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Iterator it = BaseSlider.this.k.iterator();
            while (it.hasNext()) {
                AbstractC10402bY7.g(BaseSlider.this).b((C9384Zr7) it.next());
            }
        }
    }

    private static class e extends AbstractC22084ue2 {
        private final BaseSlider q;
        final Rect r;

        e(BaseSlider baseSlider) {
            super(baseSlider);
            this.r = new Rect();
            this.q = baseSlider;
        }

        private String Y(int i) {
            return i == this.q.getValues().size() + (-1) ? this.q.getContext().getString(AbstractC23026wD5.material_slider_range_end) : i == 0 ? this.q.getContext().getString(AbstractC23026wD5.material_slider_range_start) : "";
        }

        @Override // ir.nasim.AbstractC22084ue2
        protected int B(float f, float f2) {
            for (int i = 0; i < this.q.getValues().size(); i++) {
                this.q.m0(i, this.r);
                if (this.r.contains((int) f, (int) f2)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // ir.nasim.AbstractC22084ue2
        protected void C(List list) {
            for (int i = 0; i < this.q.getValues().size(); i++) {
                list.add(Integer.valueOf(i));
            }
        }

        @Override // ir.nasim.AbstractC22084ue2
        protected boolean L(int i, int i2, Bundle bundle) {
            if (!this.q.isEnabled()) {
                return false;
            }
            if (i2 != 4096 && i2 != 8192) {
                if (i2 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                    if (this.q.k0(i, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                        this.q.n0();
                        this.q.postInvalidate();
                        E(i);
                        return true;
                    }
                }
                return false;
            }
            float fM = this.q.m(20);
            if (i2 == 8192) {
                fM = -fM;
            }
            if (this.q.N()) {
                fM = -fM;
            }
            if (!this.q.k0(i, AbstractC22000uV3.a(this.q.getValues().get(i).floatValue() + fM, this.q.getValueFrom(), this.q.getValueTo()))) {
                return false;
            }
            this.q.n0();
            this.q.postInvalidate();
            E(i);
            return true;
        }

        @Override // ir.nasim.AbstractC22084ue2
        protected void P(int i, X2 x2) {
            x2.b(X2.a.L);
            List<Float> values = this.q.getValues();
            float fFloatValue = values.get(i).floatValue();
            float valueFrom = this.q.getValueFrom();
            float valueTo = this.q.getValueTo();
            if (this.q.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    x2.a(8192);
                }
                if (fFloatValue < valueTo) {
                    x2.a(4096);
                }
            }
            x2.O0(X2.g.a(1, valueFrom, valueTo, fFloatValue));
            x2.p0(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.q.getContentDescription() != null) {
                sb.append(this.q.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                sb.append(Y(i));
                sb.append(this.q.B(fFloatValue));
            }
            x2.t0(sb.toString());
            this.q.m0(i, this.r);
            x2.k0(this.r);
        }
    }

    private interface f {
        C9384Zr7 a();
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.sliderStyle);
    }

    private void A(int i) {
        if (i == 1) {
            T(Integer.MAX_VALUE);
            return;
        }
        if (i == 2) {
            T(RecyclerView.UNDEFINED_DURATION);
        } else if (i == 17) {
            U(Integer.MAX_VALUE);
        } else {
            if (i != 66) {
                return;
            }
            U(RecyclerView.UNDEFINED_DURATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String B(float f2) {
        if (I()) {
            throw null;
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
    }

    private float[] C() {
        float fFloatValue = ((Float) Collections.max(getValues())).floatValue();
        float fFloatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.z0.size() == 1) {
            fFloatValue2 = this.H;
        }
        float fV = V(fFloatValue2);
        float fV2 = V(fFloatValue);
        return N() ? new float[]{fV2, fV} : new float[]{fV, fV2};
    }

    private static float D(ValueAnimator valueAnimator, float f2) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f2;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return fFloatValue;
    }

    private float E(int i, float f2) {
        float minSeparation = getMinSeparation();
        if (this.S0 == 0) {
            minSeparation = r(minSeparation);
        }
        if (N()) {
            minSeparation = -minSeparation;
        }
        int i2 = i + 1;
        int i3 = i - 1;
        return AbstractC22000uV3.a(f2, i3 < 0 ? this.H : ((Float) this.z0.get(i3)).floatValue() + minSeparation, i2 >= this.z0.size() ? this.J : ((Float) this.z0.get(i2)).floatValue() - minSeparation);
    }

    private int F(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private float G() {
        double dJ0 = j0(this.R0);
        if (N()) {
            dJ0 = 1.0d - dJ0;
        }
        float f2 = this.J;
        return (float) ((dJ0 * (f2 - r3)) + this.H);
    }

    private float H() {
        float f2 = this.R0;
        if (N()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.J;
        float f4 = this.H;
        return (f2 * (f3 - f4)) + f4;
    }

    private Drawable J(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        i(drawableNewDrawable);
        return drawableNewDrawable;
    }

    private void K() {
        this.a.setStrokeWidth(this.v);
        this.b.setStrokeWidth(this.v);
        this.e.setStrokeWidth(this.v / 2.0f);
        this.f.setStrokeWidth(this.v / 2.0f);
    }

    private boolean L() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private boolean M(float f2) {
        double dDoubleValue = new BigDecimal(Float.toString(f2)).divide(new BigDecimal(Float.toString(this.C0)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    private void O(Resources resources) throws Resources.NotFoundException {
        this.t = resources.getDimensionPixelSize(AbstractC12799fB5.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(AbstractC12799fB5.mtrl_slider_track_side_padding);
        this.r = dimensionPixelOffset;
        this.w = dimensionPixelOffset;
        this.s = resources.getDimensionPixelSize(AbstractC12799fB5.mtrl_slider_thumb_radius);
        this.x = resources.getDimensionPixelOffset(AbstractC12799fB5.mtrl_slider_track_top);
        this.A = resources.getDimensionPixelSize(AbstractC12799fB5.mtrl_slider_label_padding);
    }

    private void P() {
        if (this.C0 <= 0.0f) {
            return;
        }
        p0();
        int iMin = Math.min((int) (((this.J - this.H) / this.C0) + 1.0f), (this.F0 / (this.v * 2)) + 1);
        float[] fArr = this.D0;
        if (fArr == null || fArr.length != iMin * 2) {
            this.D0 = new float[iMin * 2];
        }
        float f2 = this.F0 / (iMin - 1);
        for (int i = 0; i < iMin * 2; i += 2) {
            float[] fArr2 = this.D0;
            fArr2[i] = this.w + ((i / 2) * f2);
            fArr2[i + 1] = n();
        }
    }

    private void Q(Canvas canvas, int i, int i2) {
        if (h0()) {
            int iV = (int) (this.w + (V(((Float) this.z0.get(this.B0)).floatValue()) * i));
            if (Build.VERSION.SDK_INT < 28) {
                int i3 = this.z;
                canvas.clipRect(iV - i3, i2 - i3, iV + i3, i3 + i2, Region.Op.UNION);
            }
            canvas.drawCircle(iV, i2, this.z, this.d);
        }
    }

    private void R(Canvas canvas) {
        if (!this.E0 || this.C0 <= 0.0f) {
            return;
        }
        float[] fArrC = C();
        int iB0 = b0(this.D0, fArrC[0]);
        int iB02 = b0(this.D0, fArrC[1]);
        int i = iB0 * 2;
        canvas.drawPoints(this.D0, 0, i, this.e);
        int i2 = iB02 * 2;
        canvas.drawPoints(this.D0, i, i2 - i, this.f);
        float[] fArr = this.D0;
        canvas.drawPoints(fArr, i2, fArr.length - i2, this.e);
    }

    private void S() {
        this.w = this.r + Math.max(this.y - this.s, 0);
        if (AbstractC12990fW7.T(this)) {
            o0(getWidth());
        }
    }

    private boolean T(int i) {
        int i2 = this.B0;
        int iC = (int) AbstractC22000uV3.c(i2 + i, 0L, this.z0.size() - 1);
        this.B0 = iC;
        if (iC == i2) {
            return false;
        }
        if (this.A0 != -1) {
            this.A0 = iC;
        }
        n0();
        postInvalidate();
        return true;
    }

    private boolean U(int i) {
        if (N()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        return T(i);
    }

    private float V(float f2) {
        float f3 = this.H;
        float f4 = (f2 - f3) / (this.J - f3);
        return N() ? 1.0f - f4 : f4;
    }

    private Boolean W(int i, KeyEvent keyEvent) {
        if (i == 61) {
            return keyEvent.hasNoModifiers() ? Boolean.valueOf(T(1)) : keyEvent.isShiftPressed() ? Boolean.valueOf(T(-1)) : Boolean.FALSE;
        }
        if (i != 66) {
            if (i != 81) {
                if (i == 69) {
                    T(-1);
                    return Boolean.TRUE;
                }
                if (i != 70) {
                    switch (i) {
                        case 21:
                            U(-1);
                            break;
                        case 22:
                            U(1);
                            break;
                    }
                    return Boolean.TRUE;
                }
            }
            T(1);
            return Boolean.TRUE;
        }
        this.A0 = this.B0;
        postInvalidate();
        return Boolean.TRUE;
    }

    private void X() {
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((InterfaceC5362Ja0) it.next()).a(this);
        }
    }

    private void Y() {
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((InterfaceC5362Ja0) it.next()).b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C9384Zr7 Z(Context context, TypedArray typedArray) {
        return C9384Zr7.u0(context, null, 0, typedArray.getResourceId(GE5.Slider_labelStyle, AbstractC21175tE5.Widget_MaterialComponents_Tooltip));
    }

    private static int b0(float[] fArr, float f2) {
        return Math.round(f2 * ((fArr.length / 2) - 1));
    }

    private void c0(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayH = AbstractC5729Ko7.h(context, attributeSet, GE5.Slider, i, U0, new int[0]);
        this.H = typedArrayH.getFloat(GE5.Slider_android_valueFrom, 0.0f);
        this.J = typedArrayH.getFloat(GE5.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.H));
        this.C0 = typedArrayH.getFloat(GE5.Slider_android_stepSize, 0.0f);
        boolean zHasValue = typedArrayH.hasValue(GE5.Slider_trackColor);
        int i2 = zHasValue ? GE5.Slider_trackColor : GE5.Slider_trackColorInactive;
        int i3 = zHasValue ? GE5.Slider_trackColor : GE5.Slider_trackColorActive;
        ColorStateList colorStateListA = AbstractC9751aV3.a(context, typedArrayH, i2);
        if (colorStateListA == null) {
            colorStateListA = AbstractC9594aE.a(context, QA5.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateListA);
        ColorStateList colorStateListA2 = AbstractC9751aV3.a(context, typedArrayH, i3);
        if (colorStateListA2 == null) {
            colorStateListA2 = AbstractC9594aE.a(context, QA5.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateListA2);
        this.O0.b0(AbstractC9751aV3.a(context, typedArrayH, GE5.Slider_thumbColor));
        if (typedArrayH.hasValue(GE5.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(AbstractC9751aV3.a(context, typedArrayH, GE5.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(typedArrayH.getDimension(GE5.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateListA3 = AbstractC9751aV3.a(context, typedArrayH, GE5.Slider_haloColor);
        if (colorStateListA3 == null) {
            colorStateListA3 = AbstractC9594aE.a(context, QA5.material_slider_halo_color);
        }
        setHaloTintList(colorStateListA3);
        this.E0 = typedArrayH.getBoolean(GE5.Slider_tickVisible, true);
        boolean zHasValue2 = typedArrayH.hasValue(GE5.Slider_tickColor);
        int i4 = zHasValue2 ? GE5.Slider_tickColor : GE5.Slider_tickColorInactive;
        int i5 = zHasValue2 ? GE5.Slider_tickColor : GE5.Slider_tickColorActive;
        ColorStateList colorStateListA4 = AbstractC9751aV3.a(context, typedArrayH, i4);
        if (colorStateListA4 == null) {
            colorStateListA4 = AbstractC9594aE.a(context, QA5.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateListA4);
        ColorStateList colorStateListA5 = AbstractC9751aV3.a(context, typedArrayH, i5);
        if (colorStateListA5 == null) {
            colorStateListA5 = AbstractC9594aE.a(context, QA5.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateListA5);
        setThumbRadius(typedArrayH.getDimensionPixelSize(GE5.Slider_thumbRadius, 0));
        setHaloRadius(typedArrayH.getDimensionPixelSize(GE5.Slider_haloRadius, 0));
        setThumbElevation(typedArrayH.getDimension(GE5.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayH.getDimensionPixelSize(GE5.Slider_trackHeight, 0));
        setLabelBehavior(typedArrayH.getInt(GE5.Slider_labelBehavior, 0));
        if (!typedArrayH.getBoolean(GE5.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        typedArrayH.recycle();
    }

    private void d0(int i) {
        d dVar = this.i;
        if (dVar == null) {
            this.i = new d(this, null);
        } else {
            removeCallbacks(dVar);
        }
        this.i.a(i);
        postDelayed(this.i, 200L);
    }

    private void e0(C9384Zr7 c9384Zr7, float f2) {
        c9384Zr7.C0(B(f2));
        int iV = (this.w + ((int) (V(f2) * this.F0))) - (c9384Zr7.getIntrinsicWidth() / 2);
        int iN = n() - (this.A + this.y);
        c9384Zr7.setBounds(iV, iN - c9384Zr7.getIntrinsicHeight(), c9384Zr7.getIntrinsicWidth() + iV, iN);
        Rect rect = new Rect(c9384Zr7.getBounds());
        AbstractC20604sI1.c(AbstractC10402bY7.f(this), this, rect);
        c9384Zr7.setBounds(rect);
        AbstractC10402bY7.g(this).a(c9384Zr7);
    }

    private void f0(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.z0.size() == arrayList.size() && this.z0.equals(arrayList)) {
            return;
        }
        this.z0 = arrayList;
        this.I0 = true;
        this.B0 = 0;
        n0();
        p();
        t();
        postInvalidate();
    }

    private boolean g0() {
        return this.u == 3;
    }

    private boolean h0() {
        return this.G0 || !(getBackground() instanceof RippleDrawable);
    }

    private void i(Drawable drawable) {
        int i = this.y * 2;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i, i);
        } else {
            float fMax = i / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    private boolean i0(float f2) {
        return k0(this.A0, f2);
    }

    private void j(C9384Zr7 c9384Zr7) {
        c9384Zr7.A0(AbstractC10402bY7.f(this));
    }

    private double j0(float f2) {
        float f3 = this.C0;
        if (f3 <= 0.0f) {
            return f2;
        }
        return Math.round(f2 * r0) / ((int) ((this.J - this.H) / f3));
    }

    private Float k(int i) {
        float fM = this.H0 ? m(20) : l();
        if (i == 21) {
            if (!N()) {
                fM = -fM;
            }
            return Float.valueOf(fM);
        }
        if (i == 22) {
            if (N()) {
                fM = -fM;
            }
            return Float.valueOf(fM);
        }
        if (i == 69) {
            return Float.valueOf(-fM);
        }
        if (i == 70 || i == 81) {
            return Float.valueOf(fM);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k0(int i, float f2) {
        this.B0 = i;
        if (Math.abs(f2 - ((Float) this.z0.get(i)).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.z0.set(i, Float.valueOf(E(i, f2)));
        s(i);
        return true;
    }

    private float l() {
        float f2 = this.C0;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return f2;
    }

    private boolean l0() {
        return i0(G());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float m(int i) {
        float fL = l();
        return (this.J - this.H) / fL <= i ? fL : Math.round(r1 / r4) * fL;
    }

    private int n() {
        return this.x + ((this.u == 1 || g0()) ? ((C9384Zr7) this.k.get(0)).getIntrinsicHeight() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        if (h0() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iV = (int) ((V(((Float) this.z0.get(this.B0)).floatValue()) * this.F0) + this.w);
            int iN = n();
            int i = this.z;
            AbstractC21710u02.f(background, iV - i, iN - i, iV + i, iN + i);
        }
    }

    private ValueAnimator o(boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(D(z ? this.p : this.o, z ? 0.0f : 1.0f), z ? 1.0f : 0.0f);
        valueAnimatorOfFloat.setDuration(z ? 83L : 117L);
        valueAnimatorOfFloat.setInterpolator(z ? AbstractC6732Ot.e : AbstractC6732Ot.c);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    private void o0(int i) {
        this.F0 = Math.max(i - (this.w * 2), 0);
        P();
    }

    private void p() {
        if (this.k.size() > this.z0.size()) {
            List<C9384Zr7> listSubList = this.k.subList(this.z0.size(), this.k.size());
            for (C9384Zr7 c9384Zr7 : listSubList) {
                if (AbstractC12990fW7.S(this)) {
                    q(c9384Zr7);
                }
            }
            listSubList.clear();
        }
        while (this.k.size() < this.z0.size()) {
            C9384Zr7 c9384Zr7A = this.j.a();
            this.k.add(c9384Zr7A);
            if (AbstractC12990fW7.S(this)) {
                j(c9384Zr7A);
            }
        }
        int i = this.k.size() == 1 ? 0 : 1;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((C9384Zr7) it.next()).m0(i);
        }
    }

    private void p0() {
        if (this.I0) {
            s0();
            t0();
            r0();
            u0();
            q0();
            x0();
            this.I0 = false;
        }
    }

    private void q(C9384Zr7 c9384Zr7) {
        InterfaceC17181mX7 interfaceC17181mX7G = AbstractC10402bY7.g(this);
        if (interfaceC17181mX7G != null) {
            interfaceC17181mX7G.b(c9384Zr7);
            c9384Zr7.w0(AbstractC10402bY7.f(this));
        }
    }

    private void q0() {
        float minSeparation = getMinSeparation();
        if (minSeparation < 0.0f) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(minSeparation)));
        }
        float f2 = this.C0;
        if (f2 <= 0.0f || minSeparation <= 0.0f) {
            return;
        }
        if (this.S0 != 1) {
            throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.C0)));
        }
        if (minSeparation < f2 || !M(minSeparation)) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.C0), Float.valueOf(this.C0)));
        }
    }

    private float r(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f3 = (f2 - this.w) / this.F0;
        float f4 = this.H;
        return (f3 * (f4 - this.J)) + f4;
    }

    private void r0() {
        if (this.C0 > 0.0f && !v0(this.J)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.C0), Float.valueOf(this.H), Float.valueOf(this.J)));
        }
    }

    private void s(int i) {
        Iterator it = this.l.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            ((Float) this.z0.get(i)).floatValue();
            throw null;
        }
        AccessibilityManager accessibilityManager = this.h;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        d0(i);
    }

    private void s0() {
        if (this.H >= this.J) {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.H), Float.valueOf(this.J)));
        }
    }

    private void t() {
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            Iterator it2 = this.z0.iterator();
            if (it2.hasNext()) {
                ((Float) it2.next()).floatValue();
                throw null;
            }
        }
    }

    private void t0() {
        if (this.J <= this.H) {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.valueOf(this.J), Float.valueOf(this.H)));
        }
    }

    private void u(Canvas canvas, int i, int i2) {
        float[] fArrC = C();
        int i3 = this.w;
        float f2 = i;
        float f3 = i2;
        canvas.drawLine(i3 + (fArrC[0] * f2), f3, i3 + (fArrC[1] * f2), f3, this.b);
    }

    private void u0() {
        Iterator it = this.z0.iterator();
        while (it.hasNext()) {
            Float f2 = (Float) it.next();
            if (f2.floatValue() < this.H || f2.floatValue() > this.J) {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", f2, Float.valueOf(this.H), Float.valueOf(this.J)));
            }
            if (this.C0 > 0.0f && !v0(f2.floatValue())) {
                throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", f2, Float.valueOf(this.H), Float.valueOf(this.C0), Float.valueOf(this.C0)));
            }
        }
    }

    private void v(Canvas canvas, int i, int i2) {
        float[] fArrC = C();
        float f2 = i;
        float f3 = this.w + (fArrC[1] * f2);
        if (f3 < r1 + i) {
            float f4 = i2;
            canvas.drawLine(f3, f4, r1 + i, f4, this.a);
        }
        int i3 = this.w;
        float f5 = i3 + (fArrC[0] * f2);
        if (f5 > i3) {
            float f6 = i2;
            canvas.drawLine(i3, f6, f5, f6, this.a);
        }
    }

    private boolean v0(float f2) {
        return M(f2 - this.H);
    }

    private void w(Canvas canvas, int i, int i2, float f2, Drawable drawable) {
        canvas.save();
        canvas.translate((this.w + ((int) (V(f2) * i))) - (drawable.getBounds().width() / 2.0f), i2 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    private float w0(float f2) {
        return (V(f2) * this.F0) + this.w;
    }

    private void x(Canvas canvas, int i, int i2) {
        for (int i3 = 0; i3 < this.z0.size(); i3++) {
            float fFloatValue = ((Float) this.z0.get(i3)).floatValue();
            Drawable drawable = this.P0;
            if (drawable != null) {
                w(canvas, i, i2, fFloatValue, drawable);
            } else if (i3 < this.Q0.size()) {
                w(canvas, i, i2, fFloatValue, (Drawable) this.Q0.get(i3));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle(this.w + (V(fFloatValue) * i), i2, this.y, this.c);
                }
                w(canvas, i, i2, fFloatValue, this.O0);
            }
        }
    }

    private void x0() {
        float f2 = this.C0;
        if (f2 == 0.0f) {
            return;
        }
        if (((int) f2) != f2) {
            Log.w(T0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f2)));
        }
        float f3 = this.H;
        if (((int) f3) != f3) {
            Log.w(T0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f3)));
        }
        float f4 = this.J;
        if (((int) f4) != f4) {
            Log.w(T0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f4)));
        }
    }

    private void y() {
        if (this.u == 2) {
            return;
        }
        if (!this.n) {
            this.n = true;
            ValueAnimator valueAnimatorO = o(true);
            this.o = valueAnimatorO;
            this.p = null;
            valueAnimatorO.start();
        }
        Iterator it = this.k.iterator();
        for (int i = 0; i < this.z0.size() && it.hasNext(); i++) {
            if (i != this.B0) {
                e0((C9384Zr7) it.next(), ((Float) this.z0.get(i)).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.k.size()), Integer.valueOf(this.z0.size())));
        }
        e0((C9384Zr7) it.next(), ((Float) this.z0.get(this.B0)).floatValue());
    }

    private void z() {
        if (this.n) {
            this.n = false;
            ValueAnimator valueAnimatorO = o(false);
            this.p = valueAnimatorO;
            this.o = null;
            valueAnimatorO.addListener(new c());
            this.p.start();
        }
    }

    public boolean I() {
        return false;
    }

    final boolean N() {
        return AbstractC12990fW7.A(this) == 1;
    }

    protected boolean a0() {
        if (this.A0 != -1) {
            return true;
        }
        float fH = H();
        float fW0 = w0(fH);
        this.A0 = 0;
        float fAbs = Math.abs(((Float) this.z0.get(0)).floatValue() - fH);
        for (int i = 1; i < this.z0.size(); i++) {
            float fAbs2 = Math.abs(((Float) this.z0.get(i)).floatValue() - fH);
            float fW02 = w0(((Float) this.z0.get(i)).floatValue());
            if (Float.compare(fAbs2, fAbs) > 1) {
                break;
            }
            boolean z = !N() ? fW02 - fW0 >= 0.0f : fW02 - fW0 <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.A0 = i;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fW02 - fW0) < this.q) {
                        this.A0 = -1;
                        return false;
                    }
                    if (z) {
                        this.A0 = i;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.A0 != -1;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.g.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.setColor(F(this.N0));
        this.b.setColor(F(this.M0));
        this.e.setColor(F(this.L0));
        this.f.setColor(F(this.K0));
        for (C9384Zr7 c9384Zr7 : this.k) {
            if (c9384Zr7.isStateful()) {
                c9384Zr7.setState(getDrawableState());
            }
        }
        if (this.O0.isStateful()) {
            this.O0.setState(getDrawableState());
        }
        this.d.setColor(F(this.J0));
        this.d.setAlpha(63);
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    final int getAccessibilityFocusedVirtualViewId() {
        return this.g.x();
    }

    public int getActiveThumbIndex() {
        return this.A0;
    }

    public int getFocusedThumbIndex() {
        return this.B0;
    }

    public int getHaloRadius() {
        return this.z;
    }

    public ColorStateList getHaloTintList() {
        return this.J0;
    }

    public int getLabelBehavior() {
        return this.u;
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.C0;
    }

    public float getThumbElevation() {
        return this.O0.w();
    }

    public int getThumbRadius() {
        return this.y;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.O0.F();
    }

    public float getThumbStrokeWidth() {
        return this.O0.H();
    }

    public ColorStateList getThumbTintList() {
        return this.O0.x();
    }

    public ColorStateList getTickActiveTintList() {
        return this.K0;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.L0;
    }

    public ColorStateList getTickTintList() {
        if (this.L0.equals(this.K0)) {
            return this.K0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.M0;
    }

    public int getTrackHeight() {
        return this.v;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.N0;
    }

    public int getTrackSidePadding() {
        return this.w;
    }

    public ColorStateList getTrackTintList() {
        if (this.N0.equals(this.M0)) {
            return this.M0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.F0;
    }

    public float getValueFrom() {
        return this.H;
    }

    public float getValueTo() {
        return this.J;
    }

    List<Float> getValues() {
        return new ArrayList(this.z0);
    }

    public void h(InterfaceC5362Ja0 interfaceC5362Ja0) {
        this.m.add(interfaceC5362Ja0);
    }

    void m0(int i, Rect rect) {
        int iV = this.w + ((int) (V(getValues().get(i).floatValue()) * this.F0));
        int iN = n();
        int i2 = this.y;
        rect.set(iV - i2, iN - i2, iV + i2, iN + i2);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            j((C9384Zr7) it.next());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        d dVar = this.i;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.n = false;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            q((C9384Zr7) it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.I0) {
            p0();
            P();
        }
        super.onDraw(canvas);
        int iN = n();
        v(canvas, this.F0, iN);
        if (((Float) Collections.max(getValues())).floatValue() > this.H) {
            u(canvas, this.F0, iN);
        }
        R(canvas);
        if ((this.G || isFocused() || g0()) && isEnabled()) {
            Q(canvas, this.F0, iN);
            if (this.A0 != -1 || g0()) {
                y();
            } else {
                z();
            }
        } else {
            z();
        }
        x(canvas, this.F0, iN);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            A(i);
            this.g.V(this.B0);
        } else {
            this.A0 = -1;
            this.g.o(this.B0);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.z0.size() == 1) {
            this.A0 = 0;
        }
        if (this.A0 == -1) {
            Boolean boolW = W(i, keyEvent);
            return boolW != null ? boolW.booleanValue() : super.onKeyDown(i, keyEvent);
        }
        this.H0 |= keyEvent.isLongPress();
        Float fK = k(i);
        if (fK != null) {
            if (i0(((Float) this.z0.get(this.A0)).floatValue() + fK.floatValue())) {
                n0();
                postInvalidate();
            }
            return true;
        }
        if (i != 23) {
            if (i == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return T(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return T(-1);
                }
                return false;
            }
            if (i != 66) {
                return super.onKeyDown(i, keyEvent);
            }
        }
        this.A0 = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.H0 = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.t + ((this.u == 1 || g0()) ? ((C9384Zr7) this.k.get(0)).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.H = sliderState.a;
        this.J = sliderState.b;
        f0(sliderState.c);
        this.C0 = sliderState.d;
        if (sliderState.e) {
            requestFocus();
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.a = this.H;
        sliderState.b = this.J;
        sliderState.c = new ArrayList(this.z0);
        sliderState.d = this.C0;
        sliderState.e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        o0(i);
        n0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float f2 = (x - this.w) / this.F0;
        this.R0 = f2;
        float fMax = Math.max(0.0f, f2);
        this.R0 = fMax;
        this.R0 = Math.min(1.0f, fMax);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = x;
            if (!L()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (a0()) {
                    requestFocus();
                    this.G = true;
                    l0();
                    n0();
                    invalidate();
                    X();
                }
            }
        } else if (actionMasked == 1) {
            this.G = false;
            MotionEvent motionEvent2 = this.D;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.D.getX() - motionEvent.getX()) <= this.q && Math.abs(this.D.getY() - motionEvent.getY()) <= this.q && a0()) {
                X();
            }
            if (this.A0 != -1) {
                l0();
                this.A0 = -1;
                Y();
            }
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.G) {
                if (L() && Math.abs(x - this.B) < this.q) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                X();
            }
            if (a0()) {
                this.G = true;
                l0();
                n0();
                invalidate();
            }
        }
        setPressed(this.G);
        this.D = MotionEvent.obtain(motionEvent);
        return true;
    }

    protected void setActiveThumbIndex(int i) {
        this.A0 = i;
    }

    void setCustomThumbDrawable(int i) {
        setCustomThumbDrawable(getResources().getDrawable(i));
    }

    void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            drawableArr[i] = getResources().getDrawable(iArr[i]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.z0.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.B0 = i;
        this.g.V(i);
        postInvalidate();
    }

    public void setHaloRadius(int i) {
        if (i == this.z) {
            return;
        }
        this.z = i;
        Drawable background = getBackground();
        if (h0() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            M02.b((RippleDrawable) background, this.z);
        }
    }

    public void setHaloRadiusResource(int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.J0)) {
            return;
        }
        this.J0 = colorStateList;
        Drawable background = getBackground();
        if (!h0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.d.setColor(F(colorStateList));
        this.d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i) {
        if (this.u != i) {
            this.u = i;
            requestLayout();
        }
    }

    protected void setSeparationUnit(int i) {
        this.S0 = i;
        this.I0 = true;
        postInvalidate();
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f2), Float.valueOf(this.H), Float.valueOf(this.J)));
        }
        if (this.C0 != f2) {
            this.C0 = f2;
            this.I0 = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f2) {
        this.O0.a0(f2);
    }

    public void setThumbElevationResource(int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    public void setThumbRadius(int i) {
        if (i == this.y) {
            return;
        }
        this.y = i;
        S();
        this.O0.setShapeAppearanceModel(C11411cx6.a().q(0, this.y).m());
        C10345bV3 c10345bV3 = this.O0;
        int i2 = this.y;
        c10345bV3.setBounds(0, 0, i2 * 2, i2 * 2);
        Drawable drawable = this.P0;
        if (drawable != null) {
            i(drawable);
        }
        Iterator it = this.Q0.iterator();
        while (it.hasNext()) {
            i((Drawable) it.next());
        }
        postInvalidate();
    }

    public void setThumbRadiusResource(int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.O0.l0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i) {
        if (i != 0) {
            setThumbStrokeColor(AbstractC9594aE.a(getContext(), i));
        }
    }

    public void setThumbStrokeWidth(float f2) {
        this.O0.m0(f2);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.O0.x())) {
            return;
        }
        this.O0.b0(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.K0)) {
            return;
        }
        this.K0 = colorStateList;
        this.f.setColor(F(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.L0)) {
            return;
        }
        this.L0 = colorStateList;
        this.e.setColor(F(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z) {
        if (this.E0 != z) {
            this.E0 = z;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.M0)) {
            return;
        }
        this.M0 = colorStateList;
        this.b.setColor(F(colorStateList));
        invalidate();
    }

    public void setTrackHeight(int i) {
        if (this.v != i) {
            this.v = i;
            K();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.N0)) {
            return;
        }
        this.N0 = colorStateList;
        this.a.setColor(F(colorStateList));
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f2) {
        this.H = f2;
        this.I0 = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.J = f2;
        this.I0 = true;
        postInvalidate();
    }

    void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        f0(arrayList);
    }

    private class d implements Runnable {
        int a;

        private d() {
            this.a = -1;
        }

        void a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.g.W(this.a, 4);
        }

        /* synthetic */ d(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(AbstractC17750nV3.c(context, attributeSet, i, U0), attributeSet, i);
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = false;
        this.G = false;
        this.z0 = new ArrayList();
        this.A0 = -1;
        this.B0 = -1;
        this.C0 = 0.0f;
        this.E0 = true;
        this.H0 = false;
        C10345bV3 c10345bV3 = new C10345bV3();
        this.O0 = c10345bV3;
        this.Q0 = Collections.emptyList();
        this.S0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.a = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        Paint paint3 = new Paint(1);
        this.c = paint3;
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.d = paint4;
        paint4.setStyle(style2);
        Paint paint5 = new Paint();
        this.e = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Paint paint6 = new Paint();
        this.f = paint6;
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        O(context2.getResources());
        this.j = new a(attributeSet, i);
        c0(context2, attributeSet, i);
        setFocusable(true);
        setClickable(true);
        c10345bV3.i0(2);
        this.q = ViewConfiguration.get(context2).getScaledTouchSlop();
        e eVar = new e(this);
        this.g = eVar;
        AbstractC12990fW7.p0(this, eVar);
        this.h = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    void setCustomThumbDrawable(Drawable drawable) {
        this.P0 = J(drawable);
        this.Q0.clear();
        postInvalidate();
    }

    void setValues(List<Float> list) {
        f0(new ArrayList(list));
    }

    void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.P0 = null;
        this.Q0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.Q0.add(J(drawable));
        }
        postInvalidate();
    }

    public void setLabelFormatter(InterfaceC4342Es3 interfaceC4342Es3) {
    }
}
