package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.URLSpanNoUnderline;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: ir.nasim.jU7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C15381jU7 {
    private static Paint V;
    private static Paint W;
    private static int X;
    private static float[] Y;
    private static Path Z;
    private float A;
    private int B;
    private int C;
    private C9151Ys F;
    private float G;
    private ArrayList H;
    private CharSequence I;
    private long J;
    private long L;
    private StaticLayout[] P;
    private TextPaint Q;
    private int S;
    private long T;
    private float a;
    private int h;
    private int i;
    private a j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean q;
    private float r;
    private boolean s;
    private float u;
    private float v;
    private long w;
    private View x;
    private int b = 0;
    private float c = 0.0f;
    private int d = 0;
    private int e = 0;
    private boolean f = false;
    private boolean g = false;
    private RectF p = new RectF();
    private float t = 1.0f;
    private int y = AbstractC21455b.F(4.0f);
    private int z = AbstractC21455b.F(2.0f);
    private int D = 0;
    private float E = 1.0f;
    private float K = 0.0f;
    private final float M = 1.0f;
    private int N = -1;
    private int O = -1;
    private float R = 1.0f;
    private float U = -1.0f;

    /* renamed from: ir.nasim.jU7$a */
    public interface a {
        void a(float f);

        void b(float f);
    }

    public C15381jU7(View view) {
        if (V == null) {
            V = new Paint(1);
            Paint paint = new Paint(1);
            W = paint;
            paint.setStyle(Paint.Style.STROKE);
            W.setColor(-16777216);
            W.setStrokeWidth(1.0f);
        }
        this.x = view;
        X = AbstractC21455b.F(24.0f);
        this.v = AbstractC21455b.F(6.0f);
        this.F = new C9151Ys(0.0f, view, 0L, 300L, InterpolatorC12631ew1.h);
    }

    private void e(Canvas canvas, RectF rectF, Paint paint) {
        int size;
        float f;
        int i = 1;
        float F = AbstractC21455b.F(AbstractC21455b.U0(2, 1, this.A));
        ArrayList arrayList = this.H;
        if (arrayList == null || arrayList.isEmpty()) {
            canvas.drawRoundRect(rectF, F, F, paint);
            return;
        }
        float f2 = rectF.bottom;
        float fT0 = this.B + AbstractC21455b.T0(X / 2.0f, 0.0f, this.A);
        float fT02 = this.B + AbstractC21455b.T0(this.h - (X / 2.0f), this.x.getWidth() - (this.B * 2.0f), this.A);
        AbstractC21455b.x.set(rectF);
        float F2 = AbstractC21455b.F(this.K * 1.0f) / 2.0f;
        if (Z == null) {
            Z = new Path();
        }
        Z.reset();
        float F3 = AbstractC21455b.F(4.0f) / (fT02 - fT0);
        int i2 = 0;
        while (true) {
            size = -1;
            if (i2 >= this.H.size()) {
                i2 = -1;
                break;
            } else if (((Float) ((Pair) this.H.get(i2)).first).floatValue() >= F3) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int size2 = this.H.size() - 1;
        while (true) {
            if (size2 < 0) {
                break;
            }
            if (1.0f - ((Float) ((Pair) this.H.get(size2)).first).floatValue() >= F3) {
                size = size2 + 1;
                break;
            }
            size2--;
        }
        if (size < 0) {
            size = this.H.size();
        }
        int i3 = size;
        int i4 = i2;
        while (i4 <= i3) {
            float fFloatValue = i4 == i2 ? 0.0f : ((Float) ((Pair) this.H.get(i4 - 1)).first).floatValue();
            float fFloatValue2 = i4 == i3 ? 1.0f : ((Float) ((Pair) this.H.get(i4)).first).floatValue();
            while (i4 != i3 && i4 != 0 && i4 < this.H.size() - i && ((Float) ((Pair) this.H.get(i4)).first).floatValue() - fFloatValue <= F3) {
                i4++;
                fFloatValue2 = ((Float) ((Pair) this.H.get(i4)).first).floatValue();
            }
            RectF rectF2 = AbstractC21455b.x;
            rectF2.left = AbstractC21455b.T0(fT0, fT02, fFloatValue) + (i4 > 0 ? F2 : 0.0f);
            float fT03 = AbstractC21455b.T0(fT0, fT02, fFloatValue2) - (i4 < i3 ? F2 : 0.0f);
            rectF2.right = fT03;
            float f3 = rectF.right;
            int i5 = fT03 > f3 ? i : 0;
            if (i5 != 0) {
                rectF2.right = f3;
            }
            float f4 = rectF2.right;
            float f5 = rectF.left;
            if (f4 < f5) {
                f = fT0;
            } else {
                if (rectF2.left < f5) {
                    rectF2.left = f5;
                }
                if (Y == null) {
                    Y = new float[8];
                }
                if (i4 == i2 || (i5 != 0 && rectF2.left >= rectF.left)) {
                    f = fT0;
                    float[] fArr = Y;
                    fArr[7] = F;
                    fArr[6] = F;
                    fArr[1] = F;
                    fArr[0] = F;
                    float f6 = 0.7f * F * this.K;
                    fArr[5] = f6;
                    fArr[4] = f6;
                    fArr[3] = f6;
                    fArr[2] = f6;
                } else if (i4 >= i3) {
                    float[] fArr2 = Y;
                    float f7 = 0.7f * F * this.K;
                    fArr2[7] = f7;
                    fArr2[6] = f7;
                    fArr2[1] = f7;
                    fArr2[0] = f7;
                    fArr2[5] = F;
                    fArr2[4] = F;
                    fArr2[3] = F;
                    fArr2[2] = F;
                    f = fT0;
                } else {
                    float[] fArr3 = Y;
                    f = fT0;
                    float f8 = 0.7f * F * this.K;
                    fArr3[5] = f8;
                    fArr3[4] = f8;
                    fArr3[3] = f8;
                    fArr3[2] = f8;
                    fArr3[7] = f8;
                    fArr3[6] = f8;
                    fArr3[1] = f8;
                    fArr3[0] = f8;
                }
                Z.addRoundRect(rectF2, Y, Path.Direction.CW);
                if (i5 != 0) {
                    break;
                }
            }
            i4++;
            fT0 = f;
            i = 1;
        }
        canvas.drawPath(Z, paint);
    }

    private void f(Canvas canvas) {
        float f;
        float f2;
        CharSequence charSequence;
        ArrayList arrayList = this.H;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        float f3 = ((this.f || this.g) ? this.d : this.c) / (this.h - X);
        int size = this.H.size() - 1;
        while (true) {
            if (size < 0) {
                size = -1;
                break;
            } else if (((Float) ((Pair) this.H.get(size)).first).floatValue() - 0.001f <= f3) {
                break;
            } else {
                size--;
            }
        }
        if (this.P == null) {
            this.P = new StaticLayout[2];
        }
        float fT0 = this.B + AbstractC21455b.T0(X / 2.0f, 0.0f, this.A);
        float fT02 = this.B + AbstractC21455b.T0(this.h - (X / 2.0f), this.x.getWidth() - (this.B * 2.0f), this.A);
        float f4 = this.B + (this.h - (X / 2.0f));
        float fAbs = Math.abs(fT0 - f4) - AbstractC21455b.F(16.0f);
        float f5 = this.U;
        if (f5 > 0.0f && Math.abs(f5 - fAbs) > 0.01f) {
            StaticLayout[] staticLayoutArr = this.P;
            StaticLayout staticLayout = staticLayoutArr[0];
            if (staticLayout != null) {
                staticLayoutArr[0] = l(staticLayout.getText(), (int) fAbs);
            }
            StaticLayout[] staticLayoutArr2 = this.P;
            StaticLayout staticLayout2 = staticLayoutArr2[1];
            if (staticLayout2 != null) {
                staticLayoutArr2[1] = l(staticLayout2.getText(), (int) fAbs);
            }
        }
        this.U = fAbs;
        if (size != this.N) {
            StaticLayout[] staticLayoutArr3 = this.P;
            staticLayoutArr3[1] = staticLayoutArr3[0];
            if (this.f) {
                try {
                    this.x.performHapticFeedback(9, 1);
                } catch (Exception unused) {
                }
            }
            if (size < 0 || size >= this.H.size() || (charSequence = (CharSequence) ((Pair) this.H.get(size)).second) == null) {
                this.P[0] = null;
            } else {
                this.P[0] = l(charSequence, (int) fAbs);
            }
            this.R = 0.0f;
            if (size == -1) {
                this.S = -1;
            } else {
                int i = this.N;
                if (i == -1) {
                    this.S = 1;
                } else if (size < i) {
                    this.S = -1;
                } else if (size > i) {
                    this.S = 1;
                }
            }
            this.O = this.N;
            this.N = size;
        }
        if (this.R < 1.0f) {
            this.R = Math.min(this.R + (Math.min(17L, Math.abs(SystemClock.elapsedRealtime() - this.T)) / (this.H.size() > 8 ? 160.0f : 220.0f)), 1.0f);
            this.x.invalidate();
            this.T = SystemClock.elapsedRealtime();
        }
        if (this.K < 1.0f) {
            this.K = Math.min(this.K + (Math.min(17L, Math.abs(SystemClock.elapsedRealtime() - this.T)) / 200.0f), 1.0f);
            this.x.invalidate();
            this.L = SystemClock.elapsedRealtime();
        }
        float interpolation = InterpolatorC12631ew1.f.getInterpolation(this.R);
        canvas.save();
        int i2 = this.i;
        canvas.translate(fT0 + ((fT02 - f4) * this.A), AbstractC21455b.T0((this.y + i2) / 2.0f, i2 - AbstractC21455b.F(3.0f), this.A) + AbstractC21455b.F(12.0f));
        if (this.P[1] != null) {
            canvas.save();
            if (this.S != 0) {
                f2 = 0.0f;
                canvas.translate(AbstractC21455b.F(8.0f) + (AbstractC21455b.F(16.0f) * (-this.S) * interpolation), 0.0f);
            } else {
                f2 = 0.0f;
            }
            canvas.translate(f2, (-this.P[1].getHeight()) / 2.0f);
            this.Q.setAlpha((int) ((1.0f - this.A) * 255.0f * (1.0f - interpolation) * this.K));
            this.P[1].draw(canvas);
            canvas.restore();
        }
        if (this.P[0] != null) {
            canvas.save();
            if (this.S != 0) {
                f = 0.0f;
                canvas.translate(AbstractC21455b.F(8.0f) + (AbstractC21455b.F(16.0f) * this.S * (1.0f - interpolation)), 0.0f);
            } else {
                f = 0.0f;
            }
            canvas.translate(f, (-this.P[0].getHeight()) / 2.0f);
            this.Q.setAlpha((int) ((1.0f - this.A) * 255.0f * interpolation * this.K));
            this.P[0].draw(canvas);
            canvas.restore();
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int k(Pair pair, Pair pair2) {
        if (((Float) pair.first).floatValue() > ((Float) pair2.first).floatValue()) {
            return 1;
        }
        return ((Float) pair2.first).floatValue() > ((Float) pair.first).floatValue() ? -1 : 0;
    }

    private StaticLayout l(CharSequence charSequence, int i) {
        if (this.Q == null) {
            TextPaint textPaint = new TextPaint(1);
            this.Q = textPaint;
            textPaint.setTextSize(AbstractC21455b.F(12.0f));
            this.Q.setColor(-1);
        }
        if (charSequence == null) {
            charSequence = "";
        }
        return StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.Q, i).setMaxLines(1).setAlignment(Layout.Alignment.ALIGN_CENTER).setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth(Math.min(AbstractC21455b.F(400.0f), i)).build();
    }

    private void r(int i, float f) {
        if (f < 1.0f) {
            i = QY0.k(i, (int) (Color.alpha(i) * f));
        }
        V.setColor(i);
    }

    public void c() {
        this.H = null;
        this.N = -1;
        this.K = 0.0f;
        StaticLayout[] staticLayoutArr = this.P;
        if (staticLayoutArr != null) {
            staticLayoutArr[1] = null;
            staticLayoutArr[0] = null;
        }
        this.I = null;
        this.J = -1L;
    }

    public void d(Canvas canvas, View view) {
        this.p.left = this.B + AbstractC21455b.T0(X / 2.0f, 0.0f, this.A);
        RectF rectF = this.p;
        int i = this.i;
        rectF.top = AbstractC21455b.T0((i - this.y) / 2.0f, (i - AbstractC21455b.F(3.0f)) - this.z, this.A);
        RectF rectF2 = this.p;
        int i2 = this.i;
        rectF2.bottom = AbstractC21455b.T0((this.y + i2) / 2.0f, i2 - AbstractC21455b.F(3.0f), this.A);
        float f = this.b;
        float fMin = Math.min(this.c, f);
        this.c = fMin;
        float fT0 = AbstractC21455b.T0(fMin, f, 0.5f);
        this.c = fT0;
        if (Math.abs(f - fT0) > 0.005f) {
            this.x.invalidate();
        }
        float f2 = this.c;
        float f3 = this.E;
        if (f3 != 1.0f) {
            float f4 = f3 + 0.07272727f;
            this.E = f4;
            if (f4 >= 1.0f) {
                this.E = 1.0f;
            } else {
                view.invalidate();
                float interpolation = InterpolatorC12631ew1.f.getInterpolation(this.E);
                f2 = (f2 * interpolation) + (this.D * (1.0f - interpolation));
            }
        }
        float fC = this.F.c(0.0f);
        if (this.f) {
            fC = 0.0f;
        }
        this.p.right = this.B + AbstractC21455b.T0(this.h - (X / 2.0f), this.x.getWidth() - (this.B * 2.0f), this.A);
        r(this.q ? this.o : this.k, 1.0f - this.A);
        e(canvas, this.p, V);
        float f5 = this.t;
        if (f5 != 1.0f) {
            float f6 = f5 + 0.16f;
            this.t = f6;
            if (f6 > 1.0f) {
                this.t = 1.0f;
            } else {
                this.x.invalidate();
            }
        }
        if (this.s) {
            float f7 = this.r;
            if (f7 > 0.0f) {
                this.p.right = this.B + AbstractC21455b.T0((X / 2.0f) + (f7 * (this.h - r10)), this.x.getWidth() - (this.B * 2.0f), this.A);
                r(this.q ? this.o : this.l, (1.0f - this.A) * (1.0f - this.t));
                e(canvas, this.p, V);
            }
            float f8 = this.u;
            if (f8 > 0.0f) {
                this.p.right = this.B + AbstractC21455b.T0((X / 2.0f) + (f8 * (this.h - r10)), this.x.getWidth() - (this.B * 2.0f), this.A);
                r(this.q ? this.o : this.l, 1.0f - this.A);
                e(canvas, this.p, V);
            }
        } else {
            float f9 = this.r;
            float f10 = this.t;
            float f11 = (f9 * (1.0f - f10)) + (this.u * f10);
            if (f11 > 0.0f) {
                this.p.right = this.B + AbstractC21455b.T0((X / 2.0f) + (f11 * (this.h - r10)), this.x.getWidth() - (this.B * 2.0f), this.A);
                r(this.q ? this.o : this.l, 1.0f - this.A);
                e(canvas, this.p, V);
            }
        }
        float F = AbstractC21455b.F(this.f ? 8.0f : 6.0f);
        if (this.v != F) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.w;
            this.w = jElapsedRealtime;
            if (j > 18) {
                j = 16;
            }
            float f12 = this.v;
            if (f12 < F) {
                float F2 = f12 + (AbstractC21455b.F(1.0f) * (j / 60.0f));
                this.v = F2;
                if (F2 > F) {
                    this.v = F;
                }
            } else {
                float F3 = f12 - (AbstractC21455b.F(1.0f) * (j / 60.0f));
                this.v = F3;
                if (F3 < F) {
                    this.v = F;
                }
            }
            View view2 = this.x;
            if (view2 != null) {
                view2.invalidate();
            }
        }
        float fT02 = AbstractC21455b.T0(this.v, 0.0f, this.A);
        if (fC > 0.0f) {
            RectF rectF3 = this.p;
            float f13 = rectF3.left;
            rectF3.right = this.B + AbstractC21455b.T0((X / 2.0f) + (this.h - r14), this.x.getWidth() - (this.B * 2.0f), this.A);
            RectF rectF4 = this.p;
            rectF4.left = AbstractC21455b.T0(f13, rectF4.right, 1.0f - fC);
            if (this.A > 0.0f && this.p.width() > 0.0f) {
                W.setAlpha((int) (this.A * 255.0f * 0.2f));
                e(canvas, this.p, W);
            }
            r(QY0.c(this.n, this.C, this.A), 1.0f);
            e(canvas, this.p, V);
            this.p.left = f13;
            r(QY0.c(this.m, g() == 0.0f ? 0 : this.C, this.A), 1.0f - this.A);
            canvas.drawCircle(this.B + AbstractC21455b.T0((X / 2.0f) + this.G, (this.x.getWidth() - (this.B * 2.0f)) * (this.G / (this.h - X)), this.A), this.p.centerY(), fT02 * fC, V);
        }
        RectF rectF5 = this.p;
        float f14 = this.B;
        float f15 = X / 2.0f;
        if (this.f) {
            f2 = this.d;
        }
        rectF5.right = f14 + AbstractC21455b.T0(f15 + f2, (this.x.getWidth() - (this.B * 2.0f)) * g(), this.A);
        if (this.A > 0.0f && this.p.width() > 0.0f) {
            W.setAlpha((int) (this.A * 255.0f * 0.2f));
            e(canvas, this.p, W);
        }
        r(QY0.c(this.n, this.C, this.A), 1.0f);
        e(canvas, this.p, V);
        r(QY0.c(this.m, g() == 0.0f ? 0 : this.C, this.A), 1.0f - this.A);
        RectF rectF6 = this.p;
        canvas.drawCircle(rectF6.right, rectF6.centerY(), fT02 * (1.0f - fC), V);
        f(canvas);
    }

    public float g() {
        return this.b / (this.h - X);
    }

    public int h() {
        return (this.f ? this.d : this.b) + (X / 2);
    }

    public int i() {
        return this.h - X;
    }

    public boolean m(int i, float f, float f2) {
        a aVar;
        if (i == 0) {
            if (this.A > 0.0f) {
                return false;
            }
            int i2 = this.i;
            int i3 = X;
            int i4 = (i2 - i3) / 2;
            if (f >= (-i4)) {
                int i5 = this.h;
                if (f <= i5 + i4 && f2 >= 0.0f && f2 <= i2) {
                    int i6 = this.b;
                    if (i6 - i4 > f || f > i6 + i3 + i4) {
                        int i7 = ((int) f) - (i3 / 2);
                        this.b = i7;
                        if (i7 < 0) {
                            this.b = 0;
                        } else if (i7 > i5 - i3) {
                            this.b = i3 - i5;
                        }
                        this.c = this.b;
                    }
                    this.g = true;
                    this.f = true;
                    int i8 = this.b;
                    this.d = i8;
                    this.e = (int) (f - i8);
                    return true;
                }
            }
        } else if (i == 1 || i == 3) {
            if (this.f) {
                int i9 = this.d;
                this.b = i9;
                this.c = i9;
                if (i == 1 && (aVar = this.j) != null) {
                    aVar.a(i9 / (this.h - X));
                }
                this.f = false;
                AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.iU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j();
                    }
                }, 50L);
                return true;
            }
        } else if (i == 2 && this.f) {
            int i10 = (int) (f - this.e);
            this.d = i10;
            if (i10 < 0) {
                this.d = 0;
            } else {
                int i11 = this.h;
                int i12 = X;
                if (i10 > i11 - i12) {
                    this.d = i11 - i12;
                }
            }
            a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.b(this.d / (this.h - X));
            }
            return true;
        }
        return false;
    }

    public void n(float f) {
        float f2 = this.u;
        if (f != f2) {
            this.r = f2;
            this.s = f < f2;
            this.u = f;
            this.t = 0.0f;
        }
    }

    public void o(int i, int i2, int i3, int i4, int i5, int i6) {
        this.k = i;
        this.l = i2;
        this.m = i4;
        this.n = i3;
        this.o = i5;
        this.C = i6;
    }

    public void p(a aVar) {
        this.j = aVar;
    }

    public void q(int i) {
        this.B = i;
    }

    public void s(float f) {
        t(f, false);
    }

    public void t(float f, boolean z) {
        if (Math.abs(this.a - 1.0f) < 0.04f && Math.abs(f) < 0.04f) {
            this.F.d(1.0f, true);
            this.G = this.b;
        }
        this.a = f;
        int iCeil = (int) Math.ceil((this.h - X) * f);
        if (z) {
            if (Math.abs(iCeil - this.b) > AbstractC21455b.F(10.0f)) {
                float interpolation = InterpolatorC12631ew1.f.getInterpolation(this.E);
                this.D = (int) ((this.b * interpolation) + (this.D * (1.0f - interpolation)));
                this.E = 0.0f;
            } else if (this.E == 1.0f) {
                this.E = 0.0f;
                this.D = this.b;
            }
        }
        this.b = iCeil;
        if (iCeil < 0) {
            this.b = 0;
        } else {
            int i = this.h;
            int i2 = X;
            if (iCeil > i - i2) {
                this.b = i - i2;
            }
        }
        if (Math.abs(this.c - this.b) > AbstractC21455b.F(8.0f)) {
            this.c = this.b;
        }
    }

    public void u(int i, int i2) {
        this.h = i;
        this.i = i2;
        View view = this.x;
        if (view != null) {
            view.invalidate();
        }
    }

    public void v(float f) {
        if (this.A != f) {
            this.A = f;
            this.x.invalidate();
        }
    }

    public void w(C10743c74 c10743c74, long j) {
        Integer numH;
        String str;
        if (c10743c74 == null || j < 0) {
            c();
            return;
        }
        CharSequence charSequence = c10743c74.j;
        if (c10743c74.o1()) {
            if (c10743c74.k == null && (str = c10743c74.e.h.B.j) != null) {
                c10743c74.k = SpannableString.valueOf(str);
                C10743c74.e(c10743c74.M0(), c10743c74.k, false, 3, (int) j, false);
            }
            charSequence = c10743c74.k;
        }
        if (charSequence == this.I && this.J == j) {
            return;
        }
        this.I = charSequence;
        this.J = j;
        if (!(charSequence instanceof Spanned)) {
            this.H = null;
            this.N = -1;
            this.K = 0.0f;
            StaticLayout[] staticLayoutArr = this.P;
            if (staticLayoutArr != null) {
                staticLayoutArr[1] = null;
                staticLayoutArr[0] = null;
                return;
            }
            return;
        }
        Spanned spanned = (Spanned) charSequence;
        try {
            URLSpanNoUnderline[] uRLSpanNoUnderlineArr = (URLSpanNoUnderline[]) spanned.getSpans(0, spanned.length(), URLSpanNoUnderline.class);
            this.H = new ArrayList();
            this.K = 0.0f;
            if (this.Q == null) {
                TextPaint textPaint = new TextPaint(1);
                this.Q = textPaint;
                textPaint.setTextSize(AbstractC21455b.F(12.0f));
                this.Q.setColor(-1);
            }
            for (URLSpanNoUnderline uRLSpanNoUnderline : uRLSpanNoUnderlineArr) {
                if (uRLSpanNoUnderline != null && uRLSpanNoUnderline.getURL() != null && uRLSpanNoUnderline.d != null && uRLSpanNoUnderline.getURL().startsWith("video?") && (numH = Utilities.h(uRLSpanNoUnderline.getURL().substring(6))) != null && numH.intValue() >= 0) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(uRLSpanNoUnderline.d);
                    R62.S(spannableStringBuilder, this.Q.getFontMetricsInt(), AbstractC21455b.F(14.0f), false);
                    this.H.add(new Pair(Float.valueOf((numH.intValue() * 1000) / j), spannableStringBuilder));
                }
            }
            Collections.sort(this.H, new Comparator() { // from class: ir.nasim.hU7
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C15381jU7.k((Pair) obj, (Pair) obj2);
                }
            });
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
            this.H = null;
            this.N = -1;
            this.K = 0.0f;
            StaticLayout[] staticLayoutArr2 = this.P;
            if (staticLayoutArr2 != null) {
                staticLayoutArr2[1] = null;
                staticLayoutArr2[0] = null;
            }
        }
    }
}
