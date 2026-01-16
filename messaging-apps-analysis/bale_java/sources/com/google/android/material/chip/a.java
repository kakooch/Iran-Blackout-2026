package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC24690z26;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9594aE;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C15532jk4;
import ir.nasim.C18423oe0;
import ir.nasim.C5234Il7;
import ir.nasim.C7605Sk7;
import ir.nasim.GE5;
import ir.nasim.M02;
import ir.nasim.QY0;
import ir.nasim.VE0;
import ir.nasim.WU3;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class a extends C10345bV3 implements Drawable.Callback, C5234Il7.b {
    private static final int[] A1 = {R.attr.state_enabled};
    private static final ShapeDrawable B1 = new ShapeDrawable(new OvalShape());
    private ColorStateList A;
    private ColorStateList A0;
    private float B;
    private float B0;
    private boolean C0;
    private float D;
    private boolean D0;
    private Drawable E0;
    private Drawable F0;
    private ColorStateList G;
    private ColorStateList G0;
    private float H;
    private float H0;
    private CharSequence I0;
    private ColorStateList J;
    private boolean J0;
    private boolean K0;
    private Drawable L0;
    private ColorStateList M0;
    private C15532jk4 N0;
    private C15532jk4 O0;
    private float P0;
    private float Q0;
    private float R0;
    private float S0;
    private float T0;
    private float U0;
    private float V0;
    private float W0;
    private final Context X0;
    private CharSequence Y;
    private final Paint Y0;
    private boolean Z;
    private final Paint Z0;
    private final Paint.FontMetrics a1;
    private final RectF b1;
    private final PointF c1;
    private final Path d1;
    private final C5234Il7 e1;
    private int f1;
    private int g1;
    private int h1;
    private int i1;
    private int j1;
    private int k1;
    private boolean l1;
    private int m1;
    private int n1;
    private ColorFilter o1;
    private PorterDuffColorFilter p1;
    private ColorStateList q1;
    private PorterDuff.Mode r1;
    private int[] s1;
    private boolean t1;
    private ColorStateList u1;
    private WeakReference v1;
    private TextUtils.TruncateAt w1;
    private boolean x1;
    private int y1;
    private ColorStateList z;
    private Drawable z0;
    private boolean z1;

    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0180a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.D = -1.0f;
        this.Y0 = new Paint(1);
        this.a1 = new Paint.FontMetrics();
        this.b1 = new RectF();
        this.c1 = new PointF();
        this.d1 = new Path();
        this.n1 = 255;
        this.r1 = PorterDuff.Mode.SRC_IN;
        this.v1 = new WeakReference(null);
        Q(context);
        this.X0 = context;
        C5234Il7 c5234Il7 = new C5234Il7(this);
        this.e1 = c5234Il7;
        this.Y = "";
        c5234Il7.e().density = context.getResources().getDisplayMetrics().density;
        this.Z0 = null;
        int[] iArr = A1;
        setState(iArr);
        r2(iArr);
        this.x1 = true;
        if (AbstractC24690z26.a) {
            B1.setTint(-1);
        }
    }

    private boolean A0() {
        return this.K0 && this.L0 != null && this.J0;
    }

    private void A1(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayH = AbstractC5729Ko7.h(this.X0, attributeSet, GE5.Chip, i, i2, new int[0]);
        this.z1 = typedArrayH.hasValue(GE5.Chip_shapeAppearance);
        h2(AbstractC9751aV3.a(this.X0, typedArrayH, GE5.Chip_chipSurfaceColor));
        L1(AbstractC9751aV3.a(this.X0, typedArrayH, GE5.Chip_chipBackgroundColor));
        Z1(typedArrayH.getDimension(GE5.Chip_chipMinHeight, 0.0f));
        if (typedArrayH.hasValue(GE5.Chip_chipCornerRadius)) {
            N1(typedArrayH.getDimension(GE5.Chip_chipCornerRadius, 0.0f));
        }
        d2(AbstractC9751aV3.a(this.X0, typedArrayH, GE5.Chip_chipStrokeColor));
        f2(typedArrayH.getDimension(GE5.Chip_chipStrokeWidth, 0.0f));
        E2(AbstractC9751aV3.a(this.X0, typedArrayH, GE5.Chip_rippleColor));
        J2(typedArrayH.getText(GE5.Chip_android_text));
        C7605Sk7 c7605Sk7G = AbstractC9751aV3.g(this.X0, typedArrayH, GE5.Chip_android_textAppearance);
        c7605Sk7G.l(typedArrayH.getDimension(GE5.Chip_android_textSize, c7605Sk7G.j()));
        K2(c7605Sk7G);
        int i3 = typedArrayH.getInt(GE5.Chip_android_ellipsize, 0);
        if (i3 == 1) {
            w2(TextUtils.TruncateAt.START);
        } else if (i3 == 2) {
            w2(TextUtils.TruncateAt.MIDDLE);
        } else if (i3 == 3) {
            w2(TextUtils.TruncateAt.END);
        }
        Y1(typedArrayH.getBoolean(GE5.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            Y1(typedArrayH.getBoolean(GE5.Chip_chipIconEnabled, false));
        }
        R1(AbstractC9751aV3.e(this.X0, typedArrayH, GE5.Chip_chipIcon));
        if (typedArrayH.hasValue(GE5.Chip_chipIconTint)) {
            V1(AbstractC9751aV3.a(this.X0, typedArrayH, GE5.Chip_chipIconTint));
        }
        T1(typedArrayH.getDimension(GE5.Chip_chipIconSize, -1.0f));
        u2(typedArrayH.getBoolean(GE5.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            u2(typedArrayH.getBoolean(GE5.Chip_closeIconEnabled, false));
        }
        i2(AbstractC9751aV3.e(this.X0, typedArrayH, GE5.Chip_closeIcon));
        s2(AbstractC9751aV3.a(this.X0, typedArrayH, GE5.Chip_closeIconTint));
        n2(typedArrayH.getDimension(GE5.Chip_closeIconSize, 0.0f));
        D1(typedArrayH.getBoolean(GE5.Chip_android_checkable, false));
        K1(typedArrayH.getBoolean(GE5.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            K1(typedArrayH.getBoolean(GE5.Chip_checkedIconEnabled, false));
        }
        F1(AbstractC9751aV3.e(this.X0, typedArrayH, GE5.Chip_checkedIcon));
        if (typedArrayH.hasValue(GE5.Chip_checkedIconTint)) {
            H1(AbstractC9751aV3.a(this.X0, typedArrayH, GE5.Chip_checkedIconTint));
        }
        H2(C15532jk4.c(this.X0, typedArrayH, GE5.Chip_showMotionSpec));
        x2(C15532jk4.c(this.X0, typedArrayH, GE5.Chip_hideMotionSpec));
        b2(typedArrayH.getDimension(GE5.Chip_chipStartPadding, 0.0f));
        B2(typedArrayH.getDimension(GE5.Chip_iconStartPadding, 0.0f));
        z2(typedArrayH.getDimension(GE5.Chip_iconEndPadding, 0.0f));
        O2(typedArrayH.getDimension(GE5.Chip_textStartPadding, 0.0f));
        M2(typedArrayH.getDimension(GE5.Chip_textEndPadding, 0.0f));
        p2(typedArrayH.getDimension(GE5.Chip_closeIconStartPadding, 0.0f));
        k2(typedArrayH.getDimension(GE5.Chip_closeIconEndPadding, 0.0f));
        P1(typedArrayH.getDimension(GE5.Chip_chipEndPadding, 0.0f));
        D2(typedArrayH.getDimensionPixelSize(GE5.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayH.recycle();
    }

    public static a B0(Context context, AttributeSet attributeSet, int i, int i2) {
        a aVar = new a(context, attributeSet, i, i2);
        aVar.A1(attributeSet, i, i2);
        return aVar;
    }

    private void C0(Canvas canvas, Rect rect) {
        if (S2()) {
            r0(rect, this.b1);
            RectF rectF = this.b1;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.L0.setBounds(0, 0, (int) this.b1.width(), (int) this.b1.height());
            this.L0.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private boolean C1(int[] iArr, int[] iArr2) {
        boolean z;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.z;
        int iL = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.f1) : 0);
        boolean state = true;
        if (this.f1 != iL) {
            this.f1 = iL;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.A;
        int iL2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.g1) : 0);
        if (this.g1 != iL2) {
            this.g1 = iL2;
            zOnStateChange = true;
        }
        int iG = WU3.g(iL, iL2);
        if ((this.h1 != iG) | (x() == null)) {
            this.h1 = iG;
            b0(ColorStateList.valueOf(iG));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.G;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.i1) : 0;
        if (this.i1 != colorForState) {
            this.i1 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.u1 == null || !AbstractC24690z26.e(iArr)) ? 0 : this.u1.getColorForState(iArr, this.j1);
        if (this.j1 != colorForState2) {
            this.j1 = colorForState2;
            if (this.t1) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.e1.d() == null || this.e1.d().i() == null) ? 0 : this.e1.d().i().getColorForState(iArr, this.k1);
        if (this.k1 != colorForState3) {
            this.k1 = colorForState3;
            zOnStateChange = true;
        }
        boolean z2 = t1(getState(), R.attr.state_checked) && this.J0;
        if (this.l1 == z2 || this.L0 == null) {
            z = false;
        } else {
            float fS0 = s0();
            this.l1 = z2;
            if (fS0 != s0()) {
                zOnStateChange = true;
                z = true;
            } else {
                z = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.q1;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.m1) : 0;
        if (this.m1 != colorForState4) {
            this.m1 = colorForState4;
            this.p1 = M02.c(this, this.q1, this.r1);
        } else {
            state = zOnStateChange;
        }
        if (y1(this.z0)) {
            state |= this.z0.setState(iArr);
        }
        if (y1(this.L0)) {
            state |= this.L0.setState(iArr);
        }
        if (y1(this.E0)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.E0.setState(iArr3);
        }
        if (AbstractC24690z26.a && y1(this.F0)) {
            state |= this.F0.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z) {
            B1();
        }
        return state;
    }

    private void D0(Canvas canvas, Rect rect) {
        if (this.z1) {
            return;
        }
        this.Y0.setColor(this.g1);
        this.Y0.setStyle(Paint.Style.FILL);
        this.Y0.setColorFilter(r1());
        this.b1.set(rect);
        canvas.drawRoundRect(this.b1, O0(), O0(), this.Y0);
    }

    private void E0(Canvas canvas, Rect rect) {
        if (T2()) {
            r0(rect, this.b1);
            RectF rectF = this.b1;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.z0.setBounds(0, 0, (int) this.b1.width(), (int) this.b1.height());
            this.z0.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void F0(Canvas canvas, Rect rect) {
        if (this.H <= 0.0f || this.z1) {
            return;
        }
        this.Y0.setColor(this.i1);
        this.Y0.setStyle(Paint.Style.STROKE);
        if (!this.z1) {
            this.Y0.setColorFilter(r1());
        }
        RectF rectF = this.b1;
        float f = rect.left;
        float f2 = this.H;
        rectF.set(f + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.D - (this.H / 2.0f);
        canvas.drawRoundRect(this.b1, f3, f3, this.Y0);
    }

    private void G0(Canvas canvas, Rect rect) {
        if (this.z1) {
            return;
        }
        this.Y0.setColor(this.f1);
        this.Y0.setStyle(Paint.Style.FILL);
        this.b1.set(rect);
        canvas.drawRoundRect(this.b1, O0(), O0(), this.Y0);
    }

    private void H0(Canvas canvas, Rect rect) {
        if (U2()) {
            u0(rect, this.b1);
            RectF rectF = this.b1;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.E0.setBounds(0, 0, (int) this.b1.width(), (int) this.b1.height());
            if (AbstractC24690z26.a) {
                this.F0.setBounds(this.E0.getBounds());
                this.F0.jumpToCurrentState();
                this.F0.draw(canvas);
            } else {
                this.E0.draw(canvas);
            }
            canvas.translate(-f, -f2);
        }
    }

    private void I0(Canvas canvas, Rect rect) {
        this.Y0.setColor(this.j1);
        this.Y0.setStyle(Paint.Style.FILL);
        this.b1.set(rect);
        if (!this.z1) {
            canvas.drawRoundRect(this.b1, O0(), O0(), this.Y0);
        } else {
            h(new RectF(rect), this.d1);
            super.p(canvas, this.Y0, this.d1, u());
        }
    }

    private void J0(Canvas canvas, Rect rect) {
        Paint paint = this.Z0;
        if (paint != null) {
            paint.setColor(QY0.k(-16777216, 127));
            canvas.drawRect(rect, this.Z0);
            if (T2() || S2()) {
                r0(rect, this.b1);
                canvas.drawRect(this.b1, this.Z0);
            }
            if (this.Y != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.Z0);
            }
            if (U2()) {
                u0(rect, this.b1);
                canvas.drawRect(this.b1, this.Z0);
            }
            this.Z0.setColor(QY0.k(-65536, 127));
            t0(rect, this.b1);
            canvas.drawRect(this.b1, this.Z0);
            this.Z0.setColor(QY0.k(-16711936, 127));
            v0(rect, this.b1);
            canvas.drawRect(this.b1, this.Z0);
        }
    }

    private void K0(Canvas canvas, Rect rect) {
        if (this.Y != null) {
            Paint.Align alignZ0 = z0(rect, this.c1);
            x0(rect, this.b1);
            if (this.e1.d() != null) {
                this.e1.e().drawableState = getState();
                this.e1.j(this.X0);
            }
            this.e1.e().setTextAlign(alignZ0);
            int iSave = 0;
            boolean z = Math.round(this.e1.f(n1().toString())) > Math.round(this.b1.width());
            if (z) {
                iSave = canvas.save();
                canvas.clipRect(this.b1);
            }
            CharSequence charSequenceEllipsize = this.Y;
            if (z && this.w1 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.e1.e(), this.b1.width(), this.w1);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.c1;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.e1.e());
            if (z) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private boolean S2() {
        return this.K0 && this.L0 != null && this.l1;
    }

    private boolean T2() {
        return this.Z && this.z0 != null;
    }

    private boolean U2() {
        return this.D0 && this.E0 != null;
    }

    private void V2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void W2() {
        this.u1 = this.t1 ? AbstractC24690z26.d(this.J) : null;
    }

    private void X2() {
        this.F0 = new RippleDrawable(AbstractC24690z26.d(l1()), this.E0, B1);
    }

    private float f1() {
        Drawable drawable = this.l1 ? this.L0 : this.z0;
        float fCeil = this.B0;
        if (fCeil <= 0.0f && drawable != null) {
            fCeil = (float) Math.ceil(AbstractC10402bY7.d(this.X0, 24));
            if (drawable.getIntrinsicHeight() <= fCeil) {
                return drawable.getIntrinsicHeight();
            }
        }
        return fCeil;
    }

    private float g1() {
        Drawable drawable = this.l1 ? this.L0 : this.z0;
        float f = this.B0;
        return (f > 0.0f || drawable == null) ? f : drawable.getIntrinsicWidth();
    }

    private void h2(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            onStateChange(getState());
        }
    }

    private void q0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        AbstractC21710u02.g(drawable, AbstractC21710u02.b(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.E0) {
            if (drawable.isStateful()) {
                drawable.setState(c1());
            }
            AbstractC21710u02.i(drawable, this.G0);
            return;
        }
        Drawable drawable2 = this.z0;
        if (drawable == drawable2 && this.C0) {
            AbstractC21710u02.i(drawable2, this.A0);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void r0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (T2() || S2()) {
            float f = this.P0 + this.Q0;
            float fG1 = g1();
            if (AbstractC21710u02.b(this) == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + fG1;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - fG1;
            }
            float fF1 = f1();
            float fExactCenterY = rect.exactCenterY() - (fF1 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fF1;
        }
    }

    private ColorFilter r1() {
        ColorFilter colorFilter = this.o1;
        return colorFilter != null ? colorFilter : this.p1;
    }

    private void t0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (U2()) {
            float f = this.W0 + this.V0 + this.H0 + this.U0 + this.T0;
            if (AbstractC21710u02.b(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    private static boolean t1(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void u0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (U2()) {
            float f = this.W0 + this.V0;
            if (AbstractC21710u02.b(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.H0;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.H0;
            }
            float fExactCenterY = rect.exactCenterY();
            float f4 = this.H0;
            float f5 = fExactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    private void v0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (U2()) {
            float f = this.W0 + this.V0 + this.H0 + this.U0 + this.T0;
            if (AbstractC21710u02.b(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void x0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.Y != null) {
            float fS0 = this.P0 + s0() + this.S0;
            float fW0 = this.W0 + w0() + this.T0;
            if (AbstractC21710u02.b(this) == 0) {
                rectF.left = rect.left + fS0;
                rectF.right = rect.right - fW0;
            } else {
                rectF.left = rect.left + fW0;
                rectF.right = rect.right - fS0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean x1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private float y0() {
        this.e1.e().getFontMetrics(this.a1);
        Paint.FontMetrics fontMetrics = this.a1;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean y1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean z1(C7605Sk7 c7605Sk7) {
        return (c7605Sk7 == null || c7605Sk7.i() == null || !c7605Sk7.i().isStateful()) ? false : true;
    }

    public void A2(int i) {
        z2(this.X0.getResources().getDimension(i));
    }

    protected void B1() {
        InterfaceC0180a interfaceC0180a = (InterfaceC0180a) this.v1.get();
        if (interfaceC0180a != null) {
            interfaceC0180a.a();
        }
    }

    public void B2(float f) {
        if (this.Q0 != f) {
            float fS0 = s0();
            this.Q0 = f;
            float fS02 = s0();
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }

    public void C2(int i) {
        B2(this.X0.getResources().getDimension(i));
    }

    public void D1(boolean z) {
        if (this.J0 != z) {
            this.J0 = z;
            float fS0 = s0();
            if (!z && this.l1) {
                this.l1 = false;
            }
            float fS02 = s0();
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }

    public void D2(int i) {
        this.y1 = i;
    }

    public void E1(int i) {
        D1(this.X0.getResources().getBoolean(i));
    }

    public void E2(ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            W2();
            onStateChange(getState());
        }
    }

    public void F1(Drawable drawable) {
        if (this.L0 != drawable) {
            float fS0 = s0();
            this.L0 = drawable;
            float fS02 = s0();
            V2(this.L0);
            q0(this.L0);
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }

    public void F2(int i) {
        E2(AbstractC9594aE.a(this.X0, i));
    }

    public void G1(int i) {
        F1(AbstractC9594aE.b(this.X0, i));
    }

    void G2(boolean z) {
        this.x1 = z;
    }

    public void H1(ColorStateList colorStateList) {
        if (this.M0 != colorStateList) {
            this.M0 = colorStateList;
            if (A0()) {
                AbstractC21710u02.i(this.L0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void H2(C15532jk4 c15532jk4) {
        this.N0 = c15532jk4;
    }

    public void I1(int i) {
        H1(AbstractC9594aE.a(this.X0, i));
    }

    public void I2(int i) {
        H2(C15532jk4.d(this.X0, i));
    }

    public void J1(int i) {
        K1(this.X0.getResources().getBoolean(i));
    }

    public void J2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.Y, charSequence)) {
            return;
        }
        this.Y = charSequence;
        this.e1.i(true);
        invalidateSelf();
        B1();
    }

    public void K1(boolean z) {
        if (this.K0 != z) {
            boolean zS2 = S2();
            this.K0 = z;
            boolean zS22 = S2();
            if (zS2 != zS22) {
                if (zS22) {
                    q0(this.L0);
                } else {
                    V2(this.L0);
                }
                invalidateSelf();
                B1();
            }
        }
    }

    public void K2(C7605Sk7 c7605Sk7) {
        this.e1.h(c7605Sk7, this.X0);
    }

    public Drawable L0() {
        return this.L0;
    }

    public void L1(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    public void L2(int i) {
        K2(new C7605Sk7(this.X0, i));
    }

    public ColorStateList M0() {
        return this.M0;
    }

    public void M1(int i) {
        L1(AbstractC9594aE.a(this.X0, i));
    }

    public void M2(float f) {
        if (this.T0 != f) {
            this.T0 = f;
            invalidateSelf();
            B1();
        }
    }

    public ColorStateList N0() {
        return this.A;
    }

    public void N1(float f) {
        if (this.D != f) {
            this.D = f;
            setShapeAppearanceModel(E().w(f));
        }
    }

    public void N2(int i) {
        M2(this.X0.getResources().getDimension(i));
    }

    public float O0() {
        return this.z1 ? J() : this.D;
    }

    public void O1(int i) {
        N1(this.X0.getResources().getDimension(i));
    }

    public void O2(float f) {
        if (this.S0 != f) {
            this.S0 = f;
            invalidateSelf();
            B1();
        }
    }

    public float P0() {
        return this.W0;
    }

    public void P1(float f) {
        if (this.W0 != f) {
            this.W0 = f;
            invalidateSelf();
            B1();
        }
    }

    public void P2(int i) {
        O2(this.X0.getResources().getDimension(i));
    }

    public Drawable Q0() {
        Drawable drawable = this.z0;
        if (drawable != null) {
            return AbstractC21710u02.k(drawable);
        }
        return null;
    }

    public void Q1(int i) {
        P1(this.X0.getResources().getDimension(i));
    }

    public void Q2(boolean z) {
        if (this.t1 != z) {
            this.t1 = z;
            W2();
            onStateChange(getState());
        }
    }

    public float R0() {
        return this.B0;
    }

    public void R1(Drawable drawable) {
        Drawable drawableQ0 = Q0();
        if (drawableQ0 != drawable) {
            float fS0 = s0();
            this.z0 = drawable != null ? AbstractC21710u02.l(drawable).mutate() : null;
            float fS02 = s0();
            V2(drawableQ0);
            if (T2()) {
                q0(this.z0);
            }
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }

    boolean R2() {
        return this.x1;
    }

    public ColorStateList S0() {
        return this.A0;
    }

    public void S1(int i) {
        R1(AbstractC9594aE.b(this.X0, i));
    }

    public float T0() {
        return this.B;
    }

    public void T1(float f) {
        if (this.B0 != f) {
            float fS0 = s0();
            this.B0 = f;
            float fS02 = s0();
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }

    public float U0() {
        return this.P0;
    }

    public void U1(int i) {
        T1(this.X0.getResources().getDimension(i));
    }

    public ColorStateList V0() {
        return this.G;
    }

    public void V1(ColorStateList colorStateList) {
        this.C0 = true;
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            if (T2()) {
                AbstractC21710u02.i(this.z0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float W0() {
        return this.H;
    }

    public void W1(int i) {
        V1(AbstractC9594aE.a(this.X0, i));
    }

    public Drawable X0() {
        Drawable drawable = this.E0;
        if (drawable != null) {
            return AbstractC21710u02.k(drawable);
        }
        return null;
    }

    public void X1(int i) {
        Y1(this.X0.getResources().getBoolean(i));
    }

    public CharSequence Y0() {
        return this.I0;
    }

    public void Y1(boolean z) {
        if (this.Z != z) {
            boolean zT2 = T2();
            this.Z = z;
            boolean zT22 = T2();
            if (zT2 != zT22) {
                if (zT22) {
                    q0(this.z0);
                } else {
                    V2(this.z0);
                }
                invalidateSelf();
                B1();
            }
        }
    }

    public float Z0() {
        return this.V0;
    }

    public void Z1(float f) {
        if (this.B != f) {
            this.B = f;
            invalidateSelf();
            B1();
        }
    }

    @Override // ir.nasim.C5234Il7.b
    public void a() {
        B1();
        invalidateSelf();
    }

    public float a1() {
        return this.H0;
    }

    public void a2(int i) {
        Z1(this.X0.getResources().getDimension(i));
    }

    public float b1() {
        return this.U0;
    }

    public void b2(float f) {
        if (this.P0 != f) {
            this.P0 = f;
            invalidateSelf();
            B1();
        }
    }

    public int[] c1() {
        return this.s1;
    }

    public void c2(int i) {
        b2(this.X0.getResources().getDimension(i));
    }

    public ColorStateList d1() {
        return this.G0;
    }

    public void d2(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            if (this.z1) {
                l0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.n1;
        int iA = i < 255 ? VE0.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i) : 0;
        G0(canvas, bounds);
        D0(canvas, bounds);
        if (this.z1) {
            super.draw(canvas);
        }
        F0(canvas, bounds);
        I0(canvas, bounds);
        E0(canvas, bounds);
        C0(canvas, bounds);
        if (this.x1) {
            K0(canvas, bounds);
        }
        H0(canvas, bounds);
        J0(canvas, bounds);
        if (this.n1 < 255) {
            canvas.restoreToCount(iA);
        }
    }

    public void e1(RectF rectF) {
        v0(getBounds(), rectF);
    }

    public void e2(int i) {
        d2(AbstractC9594aE.a(this.X0, i));
    }

    public void f2(float f) {
        if (this.H != f) {
            this.H = f;
            this.Y0.setStrokeWidth(f);
            if (this.z1) {
                super.m0(f);
            }
            invalidateSelf();
        }
    }

    public void g2(int i) {
        f2(this.X0.getResources().getDimension(i));
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.n1;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.o1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.P0 + s0() + this.S0 + this.e1.f(n1().toString()) + this.T0 + w0() + this.W0), this.y1);
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.z1) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.D);
        } else {
            outline.setRoundRect(bounds, this.D);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public TextUtils.TruncateAt h1() {
        return this.w1;
    }

    public C15532jk4 i1() {
        return this.O0;
    }

    public void i2(Drawable drawable) {
        Drawable drawableX0 = X0();
        if (drawableX0 != drawable) {
            float fW0 = w0();
            this.E0 = drawable != null ? AbstractC21710u02.l(drawable).mutate() : null;
            if (AbstractC24690z26.a) {
                X2();
            }
            float fW02 = w0();
            V2(drawableX0);
            if (U2()) {
                q0(this.E0);
            }
            invalidateSelf();
            if (fW0 != fW02) {
                B1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return x1(this.z) || x1(this.A) || x1(this.G) || (this.t1 && x1(this.u1)) || z1(this.e1.d()) || A0() || y1(this.z0) || y1(this.L0) || x1(this.q1);
    }

    public float j1() {
        return this.R0;
    }

    public void j2(CharSequence charSequence) {
        if (this.I0 != charSequence) {
            this.I0 = C18423oe0.c().i(charSequence);
            invalidateSelf();
        }
    }

    public float k1() {
        return this.Q0;
    }

    public void k2(float f) {
        if (this.V0 != f) {
            this.V0 = f;
            invalidateSelf();
            if (U2()) {
                B1();
            }
        }
    }

    public ColorStateList l1() {
        return this.J;
    }

    public void l2(int i) {
        k2(this.X0.getResources().getDimension(i));
    }

    public C15532jk4 m1() {
        return this.N0;
    }

    public void m2(int i) {
        i2(AbstractC9594aE.b(this.X0, i));
    }

    public CharSequence n1() {
        return this.Y;
    }

    public void n2(float f) {
        if (this.H0 != f) {
            this.H0 = f;
            invalidateSelf();
            if (U2()) {
                B1();
            }
        }
    }

    public C7605Sk7 o1() {
        return this.e1.d();
    }

    public void o2(int i) {
        n2(this.X0.getResources().getDimension(i));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (T2()) {
            zOnLayoutDirectionChanged |= AbstractC21710u02.g(this.z0, i);
        }
        if (S2()) {
            zOnLayoutDirectionChanged |= AbstractC21710u02.g(this.L0, i);
        }
        if (U2()) {
            zOnLayoutDirectionChanged |= AbstractC21710u02.g(this.E0, i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (T2()) {
            zOnLevelChange |= this.z0.setLevel(i);
        }
        if (S2()) {
            zOnLevelChange |= this.L0.setLevel(i);
        }
        if (U2()) {
            zOnLevelChange |= this.E0.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable, ir.nasim.C5234Il7.b
    public boolean onStateChange(int[] iArr) {
        if (this.z1) {
            super.onStateChange(iArr);
        }
        return C1(iArr, c1());
    }

    public float p1() {
        return this.T0;
    }

    public void p2(float f) {
        if (this.U0 != f) {
            this.U0 = f;
            invalidateSelf();
            if (U2()) {
                B1();
            }
        }
    }

    public float q1() {
        return this.S0;
    }

    public void q2(int i) {
        p2(this.X0.getResources().getDimension(i));
    }

    public boolean r2(int[] iArr) {
        if (Arrays.equals(this.s1, iArr)) {
            return false;
        }
        this.s1 = iArr;
        if (U2()) {
            return C1(getState(), iArr);
        }
        return false;
    }

    float s0() {
        if (T2() || S2()) {
            return this.Q0 + g1() + this.R0;
        }
        return 0.0f;
    }

    public boolean s1() {
        return this.t1;
    }

    public void s2(ColorStateList colorStateList) {
        if (this.G0 != colorStateList) {
            this.G0 = colorStateList;
            if (U2()) {
                AbstractC21710u02.i(this.E0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.n1 != i) {
            this.n1 = i;
            invalidateSelf();
        }
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.o1 != colorFilter) {
            this.o1 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.q1 != colorStateList) {
            this.q1 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.r1 != mode) {
            this.r1 = mode;
            this.p1 = M02.c(this, this.q1, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (T2()) {
            visible |= this.z0.setVisible(z, z2);
        }
        if (S2()) {
            visible |= this.L0.setVisible(z, z2);
        }
        if (U2()) {
            visible |= this.E0.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t2(int i) {
        s2(AbstractC9594aE.a(this.X0, i));
    }

    public boolean u1() {
        return this.J0;
    }

    public void u2(boolean z) {
        if (this.D0 != z) {
            boolean zU2 = U2();
            this.D0 = z;
            boolean zU22 = U2();
            if (zU2 != zU22) {
                if (zU22) {
                    q0(this.E0);
                } else {
                    V2(this.E0);
                }
                invalidateSelf();
                B1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public boolean v1() {
        return y1(this.E0);
    }

    public void v2(InterfaceC0180a interfaceC0180a) {
        this.v1 = new WeakReference(interfaceC0180a);
    }

    float w0() {
        if (U2()) {
            return this.U0 + this.H0 + this.V0;
        }
        return 0.0f;
    }

    public boolean w1() {
        return this.D0;
    }

    public void w2(TextUtils.TruncateAt truncateAt) {
        this.w1 = truncateAt;
    }

    public void x2(C15532jk4 c15532jk4) {
        this.O0 = c15532jk4;
    }

    public void y2(int i) {
        x2(C15532jk4.d(this.X0, i));
    }

    Paint.Align z0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.Y != null) {
            float fS0 = this.P0 + s0() + this.S0;
            if (AbstractC21710u02.b(this) == 0) {
                pointF.x = rect.left + fS0;
            } else {
                pointF.x = rect.right - fS0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - y0();
        }
        return align;
    }

    public void z2(float f) {
        if (this.R0 != f) {
            float fS0 = s0();
            this.R0 = f;
            float fS02 = s0();
            invalidateSelf();
            if (fS0 != fS02) {
                B1();
            }
        }
    }
}
