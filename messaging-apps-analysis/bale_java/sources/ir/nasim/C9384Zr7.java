package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.C5234Il7;

/* renamed from: ir.nasim.Zr7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C9384Zr7 extends C10345bV3 implements C5234Il7.b {
    private static final int H0 = AbstractC21175tE5.Widget_MaterialComponents_Tooltip;
    private static final int I0 = AbstractC12181eA5.tooltipStyle;
    private final Context A;
    private int A0;
    private final Paint.FontMetrics B;
    private int B0;
    private float C0;
    private final C5234Il7 D;
    private float D0;
    private final float E0;
    private float F0;
    private final View.OnLayoutChangeListener G;
    private float G0;
    private final Rect H;
    private int J;
    private int Y;
    private int Z;
    private CharSequence z;
    private int z0;

    /* renamed from: ir.nasim.Zr7$a */
    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            C9384Zr7.this.E0(view);
        }
    }

    private C9384Zr7(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.B = new Paint.FontMetrics();
        C5234Il7 c5234Il7 = new C5234Il7(this);
        this.D = c5234Il7;
        this.G = new a();
        this.H = new Rect();
        this.C0 = 1.0f;
        this.D0 = 1.0f;
        this.E0 = 0.5f;
        this.F0 = 0.5f;
        this.G0 = 1.0f;
        this.A = context;
        c5234Il7.e().density = context.getResources().getDisplayMetrics().density;
        c5234Il7.e().setTextAlign(Paint.Align.CENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.B0 = iArr[0];
        view.getWindowVisibleDisplayFrame(this.H);
    }

    private float r0() {
        int i;
        if (((this.H.right - getBounds().right) - this.B0) - this.z0 < 0) {
            i = ((this.H.right - getBounds().right) - this.B0) - this.z0;
        } else {
            if (((this.H.left - getBounds().left) - this.B0) + this.z0 <= 0) {
                return 0.0f;
            }
            i = ((this.H.left - getBounds().left) - this.B0) + this.z0;
        }
        return i;
    }

    private float s0() {
        this.D.e().getFontMetrics(this.B);
        Paint.FontMetrics fontMetrics = this.B;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float t0(Rect rect) {
        return rect.centerY() - s0();
    }

    public static C9384Zr7 u0(Context context, AttributeSet attributeSet, int i, int i2) {
        C9384Zr7 c9384Zr7 = new C9384Zr7(context, attributeSet, i, i2);
        c9384Zr7.z0(attributeSet, i, i2);
        return c9384Zr7;
    }

    private C11465d32 v0() {
        float f = -r0();
        float fWidth = ((float) (getBounds().width() - (this.A0 * Math.sqrt(2.0d)))) / 2.0f;
        return new C10220bH4(new OO3(this.A0), Math.min(Math.max(f, -fWidth), fWidth));
    }

    private void x0(Canvas canvas) {
        if (this.z == null) {
            return;
        }
        int iT0 = (int) t0(getBounds());
        if (this.D.d() != null) {
            this.D.e().drawableState = getState();
            this.D.j(this.A);
            this.D.e().setAlpha((int) (this.G0 * 255.0f));
        }
        CharSequence charSequence = this.z;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), iT0, this.D.e());
    }

    private float y0() {
        CharSequence charSequence = this.z;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.D.f(charSequence.toString());
    }

    private void z0(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayH = AbstractC5729Ko7.h(this.A, attributeSet, GE5.Tooltip, i, i2, new int[0]);
        this.A0 = this.A.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(E().v().s(v0()).m());
        C0(typedArrayH.getText(GE5.Tooltip_android_text));
        C7605Sk7 c7605Sk7G = AbstractC9751aV3.g(this.A, typedArrayH, GE5.Tooltip_android_textAppearance);
        if (c7605Sk7G != null && typedArrayH.hasValue(GE5.Tooltip_android_textColor)) {
            c7605Sk7G.k(AbstractC9751aV3.a(this.A, typedArrayH, GE5.Tooltip_android_textColor));
        }
        D0(c7605Sk7G);
        b0(ColorStateList.valueOf(typedArrayH.getColor(GE5.Tooltip_backgroundTint, WU3.g(QY0.k(WU3.c(this.A, android.R.attr.colorBackground, C9384Zr7.class.getCanonicalName()), SetRpcStruct$ComposedRpc.NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER), QY0.k(WU3.c(this.A, AbstractC12181eA5.colorOnBackground, C9384Zr7.class.getCanonicalName()), SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER)))));
        l0(ColorStateList.valueOf(WU3.c(this.A, AbstractC12181eA5.colorSurface, C9384Zr7.class.getCanonicalName())));
        this.J = typedArrayH.getDimensionPixelSize(GE5.Tooltip_android_padding, 0);
        this.Y = typedArrayH.getDimensionPixelSize(GE5.Tooltip_android_minWidth, 0);
        this.Z = typedArrayH.getDimensionPixelSize(GE5.Tooltip_android_minHeight, 0);
        this.z0 = typedArrayH.getDimensionPixelSize(GE5.Tooltip_android_layout_margin, 0);
        typedArrayH.recycle();
    }

    public void A0(View view) {
        if (view == null) {
            return;
        }
        E0(view);
        view.addOnLayoutChangeListener(this.G);
    }

    public void B0(float f) {
        this.F0 = 1.2f;
        this.C0 = f;
        this.D0 = f;
        this.G0 = AbstractC6732Ot.b(0.0f, 1.0f, 0.19f, 1.0f, f);
        invalidateSelf();
    }

    public void C0(CharSequence charSequence) {
        if (TextUtils.equals(this.z, charSequence)) {
            return;
        }
        this.z = charSequence;
        this.D.i(true);
        invalidateSelf();
    }

    public void D0(C7605Sk7 c7605Sk7) {
        this.D.h(c7605Sk7, this.A);
    }

    @Override // ir.nasim.C5234Il7.b
    public void a() {
        invalidateSelf();
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        float fR0 = r0();
        float f = (float) (-((this.A0 * Math.sqrt(2.0d)) - this.A0));
        canvas.scale(this.C0, this.D0, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.F0));
        canvas.translate(fR0, f);
        super.draw(canvas);
        x0(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.D.e().getTextSize(), this.Z);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.J * 2) + y0(), this.Y);
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(E().v().s(v0()).m());
    }

    @Override // ir.nasim.C10345bV3, android.graphics.drawable.Drawable, ir.nasim.C5234Il7.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void w0(View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.G);
    }
}
