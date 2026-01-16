package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import ir.nasim.EE0;

/* loaded from: classes3.dex */
public final class LW0 {
    private static final boolean t0 = false;
    private static final Paint u0 = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private Typeface D;
    private EE0 E;
    private EE0 F;
    private CharSequence G;
    private CharSequence H;
    private boolean I;
    private boolean K;
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;
    private final TextPaint V;
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;
    private final View a;
    private float a0;
    private boolean b;
    private float b0;
    private float c;
    private ColorStateList c0;
    private boolean d;
    private float d0;
    private float e;
    private float e0;
    private float f;
    private float f0;
    private int g;
    private ColorStateList g0;
    private final Rect h;
    private float h0;
    private final Rect i;
    private float i0;
    private final RectF j;
    private float j0;
    private StaticLayout k0;
    private float l0;
    private float m0;
    private float n0;
    private ColorStateList o;
    private CharSequence o0;
    private ColorStateList p;
    private int q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private Typeface x;
    private Typeface y;
    private Typeface z;
    private int k = 16;
    private int l = 16;
    private float m = 15.0f;
    private float n = 15.0f;
    private boolean J = true;
    private int p0 = 1;
    private float q0 = 0.0f;
    private float r0 = 1.0f;
    private int s0 = VL6.n;

    class a implements EE0.a {
        a() {
        }

        @Override // ir.nasim.EE0.a
        public void a(Typeface typeface) {
            LW0.this.h0(typeface);
        }
    }

    class b implements EE0.a {
        b() {
        }

        @Override // ir.nasim.EE0.a
        public void a(Typeface typeface) {
            LW0.this.s0(typeface);
        }
    }

    public LW0(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.i = new Rect();
        this.h = new Rect();
        this.j = new RectF();
        this.f = e();
        V(view.getContext().getResources().getConfiguration());
    }

    private boolean I0() {
        return this.p0 > 1 && (!this.I || this.d) && !this.K;
    }

    private Layout.Alignment K() {
        int iB = YK2.b(this.k, this.I ? 1 : 0) & 7;
        return iB != 1 ? iB != 5 ? this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    private void N(TextPaint textPaint) {
        textPaint.setTextSize(this.n);
        textPaint.setTypeface(this.x);
        textPaint.setLetterSpacing(this.h0);
    }

    private void O(TextPaint textPaint) {
        textPaint.setTextSize(this.m);
        textPaint.setTypeface(this.A);
        textPaint.setLetterSpacing(this.i0);
    }

    private void P(float f) {
        if (this.d) {
            this.j.set(f < this.f ? this.h : this.i);
            return;
        }
        this.j.left = U(this.h.left, this.i.left, f, this.X);
        this.j.top = U(this.r, this.s, f, this.X);
        this.j.right = U(this.h.right, this.i.right, f, this.X);
        this.j.bottom = U(this.h.bottom, this.i.bottom, f, this.X);
    }

    private static boolean Q(float f, float f2) {
        return Math.abs(f - f2) < 1.0E-5f;
    }

    private boolean R() {
        return AbstractC12990fW7.A(this.a) == 1;
    }

    private boolean T(CharSequence charSequence, boolean z) {
        return (z ? AbstractC4517Fl7.d : AbstractC4517Fl7.c).a(charSequence, 0, charSequence.length());
    }

    private static float U(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return AbstractC6732Ot.a(f, f2, f3);
    }

    private float W(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), Math.round((Color.red(i) * f2) + (Color.red(i2) * f)), Math.round((Color.green(i) * f2) + (Color.green(i2) * f)), Math.round((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    private static boolean a0(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private void b(boolean z) {
        StaticLayout staticLayout;
        i(1.0f, z);
        CharSequence charSequence = this.H;
        if (charSequence != null && (staticLayout = this.k0) != null) {
            this.o0 = TextUtils.ellipsize(charSequence, this.V, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.o0;
        float fW = 0.0f;
        if (charSequence2 != null) {
            this.l0 = W(this.V, charSequence2);
        } else {
            this.l0 = 0.0f;
        }
        int iB = YK2.b(this.l, this.I ? 1 : 0);
        int i = iB & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
        if (i == 48) {
            this.s = this.i.top;
        } else if (i != 80) {
            this.s = this.i.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
        } else {
            this.s = this.i.bottom + this.V.ascent();
        }
        int i2 = iB & 8388615;
        if (i2 == 1) {
            this.u = this.i.centerX() - (this.l0 / 2.0f);
        } else if (i2 != 5) {
            this.u = this.i.left;
        } else {
            this.u = this.i.right - this.l0;
        }
        i(0.0f, z);
        float height = this.k0 != null ? r10.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.k0;
        if (staticLayout2 == null || this.p0 <= 1) {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                fW = W(this.V, charSequence3);
            }
        } else {
            fW = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.k0;
        this.q = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int iB2 = YK2.b(this.k, this.I ? 1 : 0);
        int i3 = iB2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
        if (i3 == 48) {
            this.r = this.h.top;
        } else if (i3 != 80) {
            this.r = this.h.centerY() - (height / 2.0f);
        } else {
            this.r = (this.h.bottom - height) + this.V.descent();
        }
        int i4 = iB2 & 8388615;
        if (i4 == 1) {
            this.t = this.h.centerX() - (fW / 2.0f);
        } else if (i4 != 5) {
            this.t = this.h.left;
        } else {
            this.t = this.h.right - fW;
        }
        j();
        y0(this.c);
    }

    private void c() {
        g(this.c);
    }

    private float d(float f) {
        float f2 = this.f;
        return f <= f2 ? AbstractC6732Ot.b(1.0f, 0.0f, this.e, f2, f) : AbstractC6732Ot.b(0.0f, 1.0f, f2, 1.0f, f);
    }

    private float e() {
        float f = this.e;
        return f + ((1.0f - f) * 0.5f);
    }

    private void e0(float f) {
        this.m0 = f;
        AbstractC12990fW7.g0(this.a);
    }

    private boolean f(CharSequence charSequence) {
        boolean zR = R();
        return this.J ? T(charSequence, zR) : zR;
    }

    private void g(float f) {
        float f2;
        P(f);
        if (!this.d) {
            this.v = U(this.t, this.u, f, this.X);
            this.w = U(this.r, this.s, f, this.X);
            y0(f);
            f2 = f;
        } else if (f < this.f) {
            this.v = this.t;
            this.w = this.r;
            y0(0.0f);
            f2 = 0.0f;
        } else {
            this.v = this.u;
            this.w = this.s - Math.max(0, this.g);
            y0(1.0f);
            f2 = 1.0f;
        }
        TimeInterpolator timeInterpolator = AbstractC6732Ot.b;
        e0(1.0f - U(0.0f, 1.0f, 1.0f - f, timeInterpolator));
        o0(U(1.0f, 0.0f, f, timeInterpolator));
        if (this.p != this.o) {
            this.V.setColor(a(x(), v(), f2));
        } else {
            this.V.setColor(v());
        }
        float f3 = this.h0;
        float f4 = this.i0;
        if (f3 != f4) {
            this.V.setLetterSpacing(U(f4, f3, f, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f3);
        }
        this.P = U(this.d0, this.Z, f, null);
        this.Q = U(this.e0, this.a0, f, null);
        this.R = U(this.f0, this.b0, f, null);
        int iA = a(w(this.g0), w(this.c0), f);
        this.S = iA;
        this.V.setShadowLayer(this.P, this.Q, this.R, iA);
        if (this.d) {
            this.V.setAlpha((int) (d(f) * this.V.getAlpha()));
        }
        AbstractC12990fW7.g0(this.a);
    }

    private void h(float f) {
        i(f, false);
    }

    private void i(float f, boolean z) {
        boolean z2;
        float f2;
        float f3;
        boolean z3;
        if (this.G == null) {
            return;
        }
        float fWidth = this.i.width();
        float fWidth2 = this.h.width();
        if (Q(f, 1.0f)) {
            f2 = this.n;
            f3 = this.h0;
            this.N = 1.0f;
            Typeface typeface = this.D;
            Typeface typeface2 = this.x;
            if (typeface != typeface2) {
                this.D = typeface2;
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            float f4 = this.m;
            float f5 = this.i0;
            Typeface typeface3 = this.D;
            Typeface typeface4 = this.A;
            if (typeface3 != typeface4) {
                this.D = typeface4;
                z2 = true;
            } else {
                z2 = false;
            }
            if (Q(f, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = U(this.m, this.n, f, this.Y) / this.m;
            }
            float f6 = this.n / this.m;
            fWidth = (!z && fWidth2 * f6 > fWidth) ? Math.min(fWidth / f6, fWidth2) : fWidth2;
            f2 = f4;
            f3 = f5;
            z3 = z2;
        }
        if (fWidth > 0.0f) {
            z3 = ((this.O > f2 ? 1 : (this.O == f2 ? 0 : -1)) != 0) || ((this.j0 > f3 ? 1 : (this.j0 == f3 ? 0 : -1)) != 0) || this.U || z3;
            this.O = f2;
            this.j0 = f3;
            this.U = false;
        }
        if (this.H == null || z3) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.D);
            this.V.setLetterSpacing(this.j0);
            this.V.setLinearText(this.N != 1.0f);
            this.I = f(this.G);
            StaticLayout staticLayoutK = k(I0() ? this.p0 : 1, fWidth, this.I);
            this.k0 = staticLayoutK;
            this.H = staticLayoutK.getText();
        }
    }

    private boolean i0(Typeface typeface) {
        EE0 ee0 = this.F;
        if (ee0 != null) {
            ee0.c();
        }
        if (this.z == typeface) {
            return false;
        }
        this.z = typeface;
        Typeface typefaceB = AbstractC22295uz7.b(this.a.getContext().getResources().getConfiguration(), typeface);
        this.y = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.z;
        }
        this.x = typefaceB;
        return true;
    }

    private void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    private StaticLayout k(int i, float f, boolean z) {
        return (StaticLayout) AbstractC4980Hj5.g(VL6.b(this.G, this.V, (int) f).d(TextUtils.TruncateAt.END).g(z).c(i == 1 ? Layout.Alignment.ALIGN_NORMAL : K()).f(false).i(i).h(this.q0, this.r0).e(this.s0).a());
    }

    private void m(Canvas canvas, float f, float f2) {
        int alpha = this.V.getAlpha();
        canvas.translate(f, f2);
        float f3 = alpha;
        this.V.setAlpha((int) (this.n0 * f3));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            TextPaint textPaint = this.V;
            textPaint.setShadowLayer(this.P, this.Q, this.R, WU3.a(this.S, textPaint.getAlpha()));
        }
        this.k0.draw(canvas);
        this.V.setAlpha((int) (this.m0 * f3));
        if (i >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, WU3.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.k0.getLineBaseline(0);
        CharSequence charSequence = this.o0;
        float f4 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f4, this.V);
        if (i >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (this.d) {
            return;
        }
        String strTrim = this.o0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.k0.getLineEnd(0), str.length()), 0.0f, f4, (Paint) this.V);
    }

    private void n() {
        if (this.L != null || this.h.isEmpty() || TextUtils.isEmpty(this.H)) {
            return;
        }
        g(0.0f);
        int width = this.k0.getWidth();
        int height = this.k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.k0.draw(new Canvas(this.L));
        if (this.M == null) {
            this.M = new Paint(3);
        }
    }

    private void o0(float f) {
        this.n0 = f;
        AbstractC12990fW7.g0(this.a);
    }

    private float s(int i, int i2) {
        return (i2 == 17 || (i2 & 7) == 1) ? (i / 2.0f) - (this.l0 / 2.0f) : ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) ? this.I ? this.i.left : this.i.right - this.l0 : this.I ? this.i.right - this.l0 : this.i.left;
    }

    private float t(RectF rectF, int i, int i2) {
        return (i2 == 17 || (i2 & 7) == 1) ? (i / 2.0f) + (this.l0 / 2.0f) : ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) ? this.I ? rectF.left + this.l0 : this.i.right : this.I ? this.i.right : rectF.left + this.l0;
    }

    private boolean t0(Typeface typeface) {
        EE0 ee0 = this.E;
        if (ee0 != null) {
            ee0.c();
        }
        if (this.C == typeface) {
            return false;
        }
        this.C = typeface;
        Typeface typefaceB = AbstractC22295uz7.b(this.a.getContext().getResources().getConfiguration(), typeface);
        this.B = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.C;
        }
        this.A = typefaceB;
        return true;
    }

    private int w(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int x() {
        return w(this.o);
    }

    private void y0(float f) {
        h(f);
        boolean z = t0 && this.N != 1.0f;
        this.K = z;
        if (z) {
            n();
        }
        AbstractC12990fW7.g0(this.a);
    }

    public int A() {
        return this.k;
    }

    public void A0(float f) {
        this.r0 = f;
    }

    public float B() {
        O(this.W);
        return -this.W.ascent();
    }

    public void B0(int i) {
        if (i != this.p0) {
            this.p0 = i;
            j();
            Y();
        }
    }

    public Typeface C() {
        Typeface typeface = this.A;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void C0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        Y();
    }

    public float D() {
        return this.c;
    }

    public void D0(boolean z) {
        this.J = z;
    }

    public float E() {
        return this.f;
    }

    public final boolean E0(int[] iArr) {
        this.T = iArr;
        if (!S()) {
            return false;
        }
        Y();
        return true;
    }

    public int F() {
        return this.s0;
    }

    public void F0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            Y();
        }
    }

    public int G() {
        StaticLayout staticLayout = this.k0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public void G0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        Y();
    }

    public float H() {
        return this.k0.getSpacingAdd();
    }

    public void H0(Typeface typeface) {
        boolean zI0 = i0(typeface);
        boolean zT0 = t0(typeface);
        if (zI0 || zT0) {
            Y();
        }
    }

    public float I() {
        return this.k0.getSpacingMultiplier();
    }

    public int J() {
        return this.p0;
    }

    public TimeInterpolator L() {
        return this.X;
    }

    public CharSequence M() {
        return this.G;
    }

    public final boolean S() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.p;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.o) != null && colorStateList.isStateful());
    }

    public void V(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.z;
            if (typeface != null) {
                this.y = AbstractC22295uz7.b(configuration, typeface);
            }
            Typeface typeface2 = this.C;
            if (typeface2 != null) {
                this.B = AbstractC22295uz7.b(configuration, typeface2);
            }
            Typeface typeface3 = this.y;
            if (typeface3 == null) {
                typeface3 = this.z;
            }
            this.x = typeface3;
            Typeface typeface4 = this.B;
            if (typeface4 == null) {
                typeface4 = this.C;
            }
            this.A = typeface4;
            Z(true);
        }
    }

    void X() {
        this.b = this.i.width() > 0 && this.i.height() > 0 && this.h.width() > 0 && this.h.height() > 0;
    }

    public void Y() {
        Z(false);
    }

    public void Z(boolean z) {
        if ((this.a.getHeight() <= 0 || this.a.getWidth() <= 0) && !z) {
            return;
        }
        b(z);
        c();
    }

    public void b0(int i, int i2, int i3, int i4) {
        if (a0(this.i, i, i2, i3, i4)) {
            return;
        }
        this.i.set(i, i2, i3, i4);
        this.U = true;
        X();
    }

    public void c0(Rect rect) {
        b0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void d0(int i) {
        C7605Sk7 c7605Sk7 = new C7605Sk7(this.a.getContext(), i);
        if (c7605Sk7.i() != null) {
            this.p = c7605Sk7.i();
        }
        if (c7605Sk7.j() != 0.0f) {
            this.n = c7605Sk7.j();
        }
        ColorStateList colorStateList = c7605Sk7.c;
        if (colorStateList != null) {
            this.c0 = colorStateList;
        }
        this.a0 = c7605Sk7.h;
        this.b0 = c7605Sk7.i;
        this.Z = c7605Sk7.j;
        this.h0 = c7605Sk7.l;
        EE0 ee0 = this.F;
        if (ee0 != null) {
            ee0.c();
        }
        this.F = new EE0(new a(), c7605Sk7.e());
        c7605Sk7.h(this.a.getContext(), this.F);
        Y();
    }

    public void f0(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            Y();
        }
    }

    public void g0(int i) {
        if (this.l != i) {
            this.l = i;
            Y();
        }
    }

    public void h0(Typeface typeface) {
        if (i0(typeface)) {
            Y();
        }
    }

    public void j0(int i) {
        this.g = i;
    }

    public void k0(int i, int i2, int i3, int i4) {
        if (a0(this.h, i, i2, i3, i4)) {
            return;
        }
        this.h.set(i, i2, i3, i4);
        this.U = true;
        X();
    }

    public void l(Canvas canvas) {
        int iSave = canvas.save();
        if (this.H == null || !this.b) {
            return;
        }
        this.V.setTextSize(this.O);
        float f = this.v;
        float f2 = this.w;
        boolean z = this.K && this.L != null;
        float f3 = this.N;
        if (f3 != 1.0f && !this.d) {
            canvas.scale(f3, f3, f, f2);
        }
        if (z) {
            canvas.drawBitmap(this.L, f, f2, this.M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!I0() || (this.d && this.c <= this.f)) {
            canvas.translate(f, f2);
            this.k0.draw(canvas);
        } else {
            m(canvas, this.v - this.k0.getLineStart(0), f2);
        }
        canvas.restoreToCount(iSave);
    }

    public void l0(Rect rect) {
        k0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void m0(float f) {
        if (this.i0 != f) {
            this.i0 = f;
            Y();
        }
    }

    public void n0(int i) {
        C7605Sk7 c7605Sk7 = new C7605Sk7(this.a.getContext(), i);
        if (c7605Sk7.i() != null) {
            this.o = c7605Sk7.i();
        }
        if (c7605Sk7.j() != 0.0f) {
            this.m = c7605Sk7.j();
        }
        ColorStateList colorStateList = c7605Sk7.c;
        if (colorStateList != null) {
            this.g0 = colorStateList;
        }
        this.e0 = c7605Sk7.h;
        this.f0 = c7605Sk7.i;
        this.d0 = c7605Sk7.j;
        this.i0 = c7605Sk7.l;
        EE0 ee0 = this.E;
        if (ee0 != null) {
            ee0.c();
        }
        this.E = new EE0(new b(), c7605Sk7.e());
        c7605Sk7.h(this.a.getContext(), this.E);
        Y();
    }

    public void o(RectF rectF, int i, int i2) {
        this.I = f(this.G);
        rectF.left = s(i, i2);
        rectF.top = this.i.top;
        rectF.right = t(rectF, i, i2);
        rectF.bottom = this.i.top + r();
    }

    public ColorStateList p() {
        return this.p;
    }

    public void p0(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            Y();
        }
    }

    public int q() {
        return this.l;
    }

    public void q0(int i) {
        if (this.k != i) {
            this.k = i;
            Y();
        }
    }

    public float r() {
        N(this.W);
        return -this.W.ascent();
    }

    public void r0(float f) {
        if (this.m != f) {
            this.m = f;
            Y();
        }
    }

    public void s0(Typeface typeface) {
        if (t0(typeface)) {
            Y();
        }
    }

    public Typeface u() {
        Typeface typeface = this.x;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void u0(float f) {
        float fA = AbstractC22000uV3.a(f, 0.0f, 1.0f);
        if (fA != this.c) {
            this.c = fA;
            c();
        }
    }

    public int v() {
        return w(this.p);
    }

    public void v0(boolean z) {
        this.d = z;
    }

    public void w0(float f) {
        this.e = f;
        this.f = e();
    }

    public void x0(int i) {
        this.s0 = i;
    }

    public int y() {
        return this.q;
    }

    public float z() {
        O(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    public void z0(float f) {
        this.q0 = f;
    }
}
