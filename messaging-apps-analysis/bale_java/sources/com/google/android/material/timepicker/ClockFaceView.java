package com.google.android.material.timepicker;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.google.android.material.timepicker.ClockHandView;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC9594aE;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C22317v2;
import ir.nasim.GE5;
import ir.nasim.QA5;
import ir.nasim.WB5;
import ir.nasim.X2;
import ir.nasim.YC5;
import java.util.Arrays;

/* loaded from: classes3.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.c {
    private final float[] A0;
    private final ClockHandView B;
    private final int B0;
    private final int C0;
    private final Rect D;
    private final int D0;
    private final int E0;
    private String[] F0;
    private final RectF G;
    private float G0;
    private final SparseArray H;
    private final ColorStateList H0;
    private final C22317v2 J;
    private final int[] z0;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.f0(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.B.g()) - ClockFaceView.this.B0);
            return true;
        }
    }

    class b extends C22317v2 {
        b() {
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            int iIntValue = ((Integer) view.getTag(WB5.material_value_index)).intValue();
            if (iIntValue > 0) {
                x2.Z0((View) ClockFaceView.this.H.get(iIntValue - 1));
            }
            x2.s0(X2.f.a(0, 1, iIntValue, 1, false, view.isSelected()));
            x2.q0(true);
            x2.b(X2.a.i);
        }

        @Override // ir.nasim.C22317v2
        public boolean j(View view, int i, Bundle bundle) {
            if (i != 16) {
                return super.j(view, i, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            float x = view.getX() + (view.getWidth() / 2.0f);
            float height = (view.getHeight() / 2.0f) + view.getY();
            ClockFaceView.this.B.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, x, height, 0));
            ClockFaceView.this.B.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, x, height, 0));
            return true;
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.materialClockStyle);
    }

    private void n0() {
        RectF rectFD = this.B.d();
        for (int i = 0; i < this.H.size(); i++) {
            TextView textView = (TextView) this.H.get(i);
            if (textView != null) {
                textView.getDrawingRect(this.D);
                offsetDescendantRectToMyCoords(textView, this.D);
                textView.setSelected(rectFD.contains(this.D.centerX(), this.D.centerY()));
                textView.getPaint().setShader(o0(rectFD, this.D, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient o0(RectF rectF, Rect rect, TextView textView) {
        this.G.set(rect);
        this.G.offset(textView.getPaddingLeft(), textView.getPaddingTop());
        if (RectF.intersects(rectF, this.G)) {
            return new RadialGradient(rectF.centerX() - this.G.left, rectF.centerY() - this.G.top, rectF.width() * 0.5f, this.z0, this.A0, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private static float p0(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    private void r0(int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.H.size();
        for (int i2 = 0; i2 < Math.max(this.F0.length, size); i2++) {
            TextView textView = (TextView) this.H.get(i2);
            if (i2 >= this.F0.length) {
                removeView(textView);
                this.H.remove(i2);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(YC5.material_clockface_textview, (ViewGroup) this, false);
                    this.H.put(i2, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.F0[i2]);
                textView.setTag(WB5.material_value_index, Integer.valueOf(i2));
                AbstractC12990fW7.p0(textView, this.J);
                textView.setTextColor(this.H0);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, this.F0[i2]));
                }
            }
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float f, boolean z) {
        if (Math.abs(this.G0 - f) > 0.001f) {
            this.G0 = f;
            n0();
        }
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void f0(int i) {
        if (i != e0()) {
            super.f0(i);
            this.B.j(e0());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        X2.g1(accessibilityNodeInfo).r0(X2.e.b(1, this.F0.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        n0();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iP0 = (int) (this.E0 / p0(this.C0 / displayMetrics.heightPixels, this.D0 / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iP0, 1073741824);
        setMeasuredDimension(iP0, iP0);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public void q0(String[] strArr, int i) {
        this.F0 = strArr;
        r0(i);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = new Rect();
        this.G = new RectF();
        this.H = new SparseArray();
        this.A0 = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GE5.ClockFaceView, i, AbstractC21175tE5.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.ClockFaceView_clockNumberTextColor);
        this.H0 = colorStateListA;
        LayoutInflater.from(context).inflate(YC5.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(WB5.material_clock_hand);
        this.B = clockHandView;
        this.B0 = resources.getDimensionPixelSize(AbstractC12799fB5.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.z0 = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AbstractC9594aE.a(context, QA5.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA2 = AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.J = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        q0(strArr, 0);
        this.C0 = resources.getDimensionPixelSize(AbstractC12799fB5.material_time_picker_minimum_screen_height);
        this.D0 = resources.getDimensionPixelSize(AbstractC12799fB5.material_time_picker_minimum_screen_width);
        this.E0 = resources.getDimensionPixelSize(AbstractC12799fB5.material_clock_size);
    }
}
