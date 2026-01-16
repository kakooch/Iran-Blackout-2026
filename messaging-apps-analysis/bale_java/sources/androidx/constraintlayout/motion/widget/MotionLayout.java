package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.i;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import ir.nasim.AbstractInterpolatorC13741gk4;
import ir.nasim.C11523d90;
import ir.nasim.C16651le1;
import ir.nasim.C17242me1;
import ir.nasim.C17663nL6;
import ir.nasim.C17935no3;
import ir.nasim.C18931pV2;
import ir.nasim.C21890uJ1;
import ir.nasim.C23273we5;
import ir.nasim.C4323Eq2;
import ir.nasim.DY7;
import ir.nasim.HN6;
import ir.nasim.InterfaceC17158mV2;
import ir.nasim.InterfaceC5744Kq4;
import ir.nasim.NS2;
import ir.nasim.OA1;
import ir.nasim.SE5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class MotionLayout extends ConstraintLayout implements InterfaceC5744Kq4 {
    public static boolean S1;
    Interpolator A;
    private boolean A0;
    private Runnable A1;
    float B;
    HashMap B0;
    private int[] B1;
    private long C0;
    int C1;
    private int D;
    private float D0;
    private boolean D1;
    float E0;
    int E1;
    float F0;
    HashMap F1;
    int G;
    private long G0;
    private int G1;
    private int H;
    float H0;
    private int H1;
    private boolean I0;
    private int I1;
    private int J;
    boolean J0;
    Rect J1;
    boolean K0;
    private boolean K1;
    private j L0;
    k L1;
    private float M0;
    f M1;
    private float N0;
    private boolean N1;
    int O0;
    private RectF O1;
    e P0;
    private View P1;
    private boolean Q0;
    private Matrix Q1;
    private HN6 R0;
    ArrayList R1;
    private d S0;
    private C21890uJ1 T0;
    boolean U0;
    int V0;
    int W0;
    int X0;
    int Y0;
    boolean Z0;
    float a1;
    float b1;
    long c1;
    float d1;
    private boolean e1;
    private ArrayList f1;
    private ArrayList g1;
    private ArrayList h1;
    private CopyOnWriteArrayList i1;
    private int j1;
    private long k1;
    private float l1;
    private int m1;
    private float n1;
    boolean o1;
    protected boolean p1;
    int q1;
    int r1;
    int s1;
    int t1;
    int u1;
    int v1;
    float w1;
    private C17935no3 x1;
    androidx.constraintlayout.motion.widget.i y;
    private boolean y1;
    Interpolator z;
    private int z0;
    private i z1;

    class a implements Runnable {
        final /* synthetic */ View a;

        a(MotionLayout motionLayout, View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setNestedScrollingEnabled(true);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.z1.a();
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k.values().length];
            a = iArr;
            try {
                iArr[k.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[k.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[k.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class d extends AbstractInterpolatorC13741gk4 {
        float a = 0.0f;
        float b = 0.0f;
        float c;

        d() {
        }

        @Override // ir.nasim.AbstractInterpolatorC13741gk4
        public float a() {
            return MotionLayout.this.B;
        }

        public void b(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2;
            float f3;
            float f4 = this.a;
            if (f4 > 0.0f) {
                float f5 = this.c;
                if (f4 / f5 < f) {
                    f = f4 / f5;
                }
                MotionLayout.this.B = f4 - (f5 * f);
                f2 = (f4 * f) - (((f5 * f) * f) / 2.0f);
                f3 = this.b;
            } else {
                float f6 = this.c;
                if ((-f4) / f6 < f) {
                    f = (-f4) / f6;
                }
                MotionLayout.this.B = (f6 * f) + f4;
                f2 = (f4 * f) + (((f6 * f) * f) / 2.0f);
                f3 = this.b;
            }
            return f2 + f3;
        }
    }

    private class e {
        float[] a;
        int[] b;
        float[] c;
        Path d;
        Paint e;
        Paint f;
        Paint g;
        Paint h;
        Paint i;
        private float[] j;
        DashPathEffect p;
        int q;
        int t;
        final int k = -21965;
        final int l = -2067046;
        final int m = -13391360;
        final int n = 1996488704;
        final int o = 10;
        Rect r = new Rect();
        boolean s = false;

        public e() {
            this.t = 1;
            Paint paint = new Paint();
            this.e = paint;
            paint.setAntiAlias(true);
            this.e.setColor(-21965);
            this.e.setStrokeWidth(2.0f);
            Paint paint2 = this.e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f = paint3;
            paint3.setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(style);
            Paint paint4 = new Paint();
            this.g = paint4;
            paint4.setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(style);
            Paint paint5 = new Paint();
            this.h = paint5;
            paint5.setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.j = new float[8];
            Paint paint6 = new Paint();
            this.i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.p = dashPathEffect;
            this.g.setPathEffect(dashPathEffect);
            this.c = new float[100];
            this.b = new int[50];
            if (this.s) {
                this.e.setStrokeWidth(8.0f);
                this.i.setStrokeWidth(8.0f);
                this.f.setStrokeWidth(8.0f);
                this.t = 4;
            }
        }

        private void c(Canvas canvas) {
            canvas.drawLines(this.a, this.e);
        }

        private void d(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.q; i++) {
                int i2 = this.b[i];
                if (i2 == 1) {
                    z = true;
                }
                if (i2 == 0) {
                    z2 = true;
                }
            }
            if (z) {
                g(canvas);
            }
            if (z2) {
                e(canvas);
            }
        }

        private void e(Canvas canvas) {
            float[] fArr = this.a;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.g);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.g);
        }

        private void f(Canvas canvas, float f, float f2) {
            float[] fArr = this.a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float fMin = Math.min(f3, f5);
            float fMax = Math.max(f4, f6);
            float fMin2 = f - Math.min(f3, f5);
            float fMax2 = Math.max(f4, f6) - f2;
            StringBuilder sb = new StringBuilder(15);
            sb.append(((int) (((fMin2 * 100.0f) / Math.abs(f5 - f3)) + 0.5d)) / 100.0f);
            String string = sb.toString();
            l(string, this.h);
            canvas.drawText(string, ((fMin2 / 2.0f) - (this.r.width() / 2)) + fMin, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.g);
            StringBuilder sb2 = new StringBuilder(15);
            sb2.append(((int) (((fMax2 * 100.0f) / Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
            String string2 = sb2.toString();
            l(string2, this.h);
            canvas.drawText(string2, f + 5.0f, fMax - ((fMax2 / 2.0f) - (this.r.height() / 2)), this.h);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.g);
        }

        private void g(Canvas canvas) {
            float[] fArr = this.a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.g);
        }

        private void h(Canvas canvas, float f, float f2) {
            float[] fArr = this.a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f3 - f5, f4 - f6);
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (fHypot * fHypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float fHypot2 = (float) Math.hypot(f10 - f, f11 - f2);
            StringBuilder sb = new StringBuilder(15);
            sb.append(((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            String string = sb.toString();
            l(string, this.h);
            canvas.drawTextOnPath(string, path, (fHypot2 / 2.0f) - (this.r.width() / 2), -20.0f, this.h);
            canvas.drawLine(f, f2, f10, f11, this.g);
        }

        private void i(Canvas canvas, float f, float f2, int i, int i2) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(((int) ((((f - (i / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i)) + 0.5d)) / 100.0f);
            String string = sb.toString();
            l(string, this.h);
            canvas.drawText(string, ((f / 2.0f) - (this.r.width() / 2)) + 0.0f, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.g);
            StringBuilder sb2 = new StringBuilder(15);
            sb2.append(((int) ((((f2 - (i2 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i2)) + 0.5d)) / 100.0f);
            String string2 = sb2.toString();
            l(string2, this.h);
            canvas.drawText(string2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.r.height() / 2)), this.h);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.g);
        }

        private void j(Canvas canvas, androidx.constraintlayout.motion.widget.g gVar) {
            this.d.reset();
            for (int i = 0; i <= 50; i++) {
                gVar.e(i / 50, this.j, 0);
                Path path = this.d;
                float[] fArr = this.j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.d;
                float[] fArr2 = this.j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.d;
                float[] fArr3 = this.j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.d;
                float[] fArr4 = this.j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.d.close();
            }
            this.e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.d, this.e);
            canvas.translate(-2.0f, -2.0f);
            this.e.setColor(-65536);
            canvas.drawPath(this.d, this.e);
        }

        private void k(Canvas canvas, int i, int i2, androidx.constraintlayout.motion.widget.g gVar) {
            int width;
            int height;
            float f;
            float f2;
            View view = gVar.b;
            if (view != null) {
                width = view.getWidth();
                height = gVar.b.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            for (int i3 = 1; i3 < i2 - 1; i3++) {
                if (i != 4 || this.b[i3 - 1] != 0) {
                    float[] fArr = this.c;
                    int i4 = i3 * 2;
                    float f3 = fArr[i4];
                    float f4 = fArr[i4 + 1];
                    this.d.reset();
                    this.d.moveTo(f3, f4 + 10.0f);
                    this.d.lineTo(f3 + 10.0f, f4);
                    this.d.lineTo(f3, f4 - 10.0f);
                    this.d.lineTo(f3 - 10.0f, f4);
                    this.d.close();
                    int i5 = i3 - 1;
                    gVar.q(i5);
                    if (i == 4) {
                        int i6 = this.b[i5];
                        if (i6 == 1) {
                            h(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (i6 == 0) {
                            f(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else {
                            if (i6 == 2) {
                                f = f4;
                                f2 = f3;
                                i(canvas, f3 - 0.0f, f4 - 0.0f, width, height);
                            }
                            canvas.drawPath(this.d, this.i);
                        }
                        f = f4;
                        f2 = f3;
                        canvas.drawPath(this.d, this.i);
                    } else {
                        f = f4;
                        f2 = f3;
                    }
                    if (i == 2) {
                        h(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 3) {
                        f(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 6) {
                        i(canvas, f2 - 0.0f, f - 0.0f, width, height);
                    }
                    canvas.drawPath(this.d, this.i);
                }
            }
            float[] fArr2 = this.a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f);
                float[] fArr3 = this.a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f);
            }
        }

        public void a(Canvas canvas, HashMap map, int i, int i2) throws Resources.NotFoundException {
            if (map == null || map.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i2 & 1) == 2) {
                String resourceName = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.H);
                float progress = MotionLayout.this.getProgress();
                StringBuilder sb = new StringBuilder(String.valueOf(resourceName).length() + 16);
                sb.append(resourceName);
                sb.append(":");
                sb.append(progress);
                String string = sb.toString();
                canvas.drawText(string, 10.0f, MotionLayout.this.getHeight() - 30, this.h);
                canvas.drawText(string, 11.0f, MotionLayout.this.getHeight() - 29, this.e);
            }
            for (androidx.constraintlayout.motion.widget.g gVar : map.values()) {
                int iM = gVar.m();
                if (i2 > 0 && iM == 0) {
                    iM = 1;
                }
                if (iM != 0) {
                    this.q = gVar.c(this.c, this.b);
                    if (iM >= 1) {
                        int i3 = i / 16;
                        float[] fArr = this.a;
                        if (fArr == null || fArr.length != i3 * 2) {
                            this.a = new float[i3 * 2];
                            this.d = new Path();
                        }
                        int i4 = this.t;
                        canvas.translate(i4, i4);
                        this.e.setColor(1996488704);
                        this.i.setColor(1996488704);
                        this.f.setColor(1996488704);
                        this.g.setColor(1996488704);
                        gVar.d(this.a, i3);
                        b(canvas, iM, this.q, gVar);
                        this.e.setColor(-21965);
                        this.f.setColor(-2067046);
                        this.i.setColor(-2067046);
                        this.g.setColor(-13391360);
                        int i5 = this.t;
                        canvas.translate(-i5, -i5);
                        b(canvas, iM, this.q, gVar);
                        if (iM == 5) {
                            j(canvas, gVar);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int i, int i2, androidx.constraintlayout.motion.widget.g gVar) {
            if (i == 4) {
                d(canvas);
            }
            if (i == 2) {
                g(canvas);
            }
            if (i == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i, i2, gVar);
        }

        void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.r);
        }
    }

    class f {
        C17242me1 a = new C17242me1();
        C17242me1 b = new C17242me1();
        androidx.constraintlayout.widget.c c = null;
        androidx.constraintlayout.widget.c d = null;
        int e;
        int f;

        f() {
        }

        private void b(int i, int i2) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.G == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                C17242me1 c17242me1 = this.b;
                androidx.constraintlayout.widget.c cVar = this.d;
                motionLayout2.Y(c17242me1, optimizationLevel, (cVar == null || cVar.d == 0) ? i : i2, (cVar == null || cVar.d == 0) ? i2 : i);
                androidx.constraintlayout.widget.c cVar2 = this.c;
                if (cVar2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    C17242me1 c17242me12 = this.a;
                    int i3 = cVar2.d;
                    int i4 = i3 == 0 ? i : i2;
                    if (i3 == 0) {
                        i = i2;
                    }
                    motionLayout3.Y(c17242me12, optimizationLevel, i4, i);
                    return;
                }
                return;
            }
            androidx.constraintlayout.widget.c cVar3 = this.c;
            if (cVar3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                C17242me1 c17242me13 = this.a;
                int i5 = cVar3.d;
                motionLayout4.Y(c17242me13, optimizationLevel, i5 == 0 ? i : i2, i5 == 0 ? i2 : i);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            C17242me1 c17242me14 = this.b;
            androidx.constraintlayout.widget.c cVar4 = this.d;
            int i6 = (cVar4 == null || cVar4.d == 0) ? i : i2;
            if (cVar4 == null || cVar4.d == 0) {
                i = i2;
            }
            motionLayout5.Y(c17242me14, optimizationLevel, i6, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void j(C17242me1 c17242me1, androidx.constraintlayout.widget.c cVar) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, c17242me1);
            sparseArray.put(MotionLayout.this.getId(), c17242me1);
            if (cVar != null && cVar.d != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.Y(this.b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator it = c17242me1.q1().iterator();
            while (it.hasNext()) {
                C16651le1 c16651le1 = (C16651le1) it.next();
                sparseArray.put(((View) c16651le1.u()).getId(), c16651le1);
            }
            Iterator it2 = c17242me1.q1().iterator();
            while (it2.hasNext()) {
                C16651le1 c16651le12 = (C16651le1) it2.next();
                View view = (View) c16651le12.u();
                cVar.l(view.getId(), layoutParams);
                c16651le12.j1(cVar.E(view.getId()));
                c16651le12.K0(cVar.z(view.getId()));
                if (view instanceof ConstraintHelper) {
                    cVar.j((ConstraintHelper) view, c16651le12, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).w();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.x(false, view, c16651le12, layoutParams, sparseArray);
                if (cVar.D(view.getId()) == 1) {
                    c16651le12.i1(view.getVisibility());
                } else {
                    c16651le12.i1(cVar.C(view.getId()));
                }
            }
            Iterator it3 = c17242me1.q1().iterator();
            while (it3.hasNext()) {
                C16651le1 c16651le13 = (C16651le1) it3.next();
                if (c16651le13 instanceof DY7) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) c16651le13.u();
                    InterfaceC17158mV2 interfaceC17158mV2 = (InterfaceC17158mV2) c16651le13;
                    constraintHelper.v(c17242me1, interfaceC17158mV2, sparseArray);
                    ((DY7) interfaceC17158mV2).t1();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x016c A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 399
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.f.a():void");
        }

        void c(C17242me1 c17242me1, C17242me1 c17242me12) {
            ArrayList arrayListQ1 = c17242me1.q1();
            HashMap map = new HashMap();
            map.put(c17242me1, c17242me12);
            c17242me12.q1().clear();
            c17242me12.n(c17242me1, map);
            Iterator it = arrayListQ1.iterator();
            while (it.hasNext()) {
                C16651le1 c16651le1 = (C16651le1) it.next();
                C16651le1 c11523d90 = c16651le1 instanceof C11523d90 ? new C11523d90() : c16651le1 instanceof NS2 ? new NS2() : c16651le1 instanceof C4323Eq2 ? new C4323Eq2() : c16651le1 instanceof C23273we5 ? new C23273we5() : c16651le1 instanceof InterfaceC17158mV2 ? new C18931pV2() : new C16651le1();
                c17242me12.a(c11523d90);
                map.put(c16651le1, c11523d90);
            }
            Iterator it2 = arrayListQ1.iterator();
            while (it2.hasNext()) {
                C16651le1 c16651le12 = (C16651le1) it2.next();
                ((C16651le1) map.get(c16651le12)).n(c16651le12, map);
            }
        }

        C16651le1 d(C17242me1 c17242me1, View view) {
            if (c17242me1.u() == view) {
                return c17242me1;
            }
            ArrayList arrayListQ1 = c17242me1.q1();
            int size = arrayListQ1.size();
            for (int i = 0; i < size; i++) {
                C16651le1 c16651le1 = (C16651le1) arrayListQ1.get(i);
                if (c16651le1.u() == view) {
                    return c16651le1;
                }
            }
            return null;
        }

        void e(C17242me1 c17242me1, androidx.constraintlayout.widget.c cVar, androidx.constraintlayout.widget.c cVar2) {
            this.c = cVar;
            this.d = cVar2;
            this.a = new C17242me1();
            this.b = new C17242me1();
            this.a.U1(((ConstraintLayout) MotionLayout.this).c.H1());
            this.b.U1(((ConstraintLayout) MotionLayout.this).c.H1());
            this.a.t1();
            this.b.t1();
            c(((ConstraintLayout) MotionLayout.this).c, this.a);
            c(((ConstraintLayout) MotionLayout.this).c, this.b);
            if (MotionLayout.this.F0 > 0.5d) {
                if (cVar != null) {
                    j(this.a, cVar);
                }
                j(this.b, cVar2);
            } else {
                j(this.b, cVar2);
                if (cVar != null) {
                    j(this.a, cVar);
                }
            }
            this.a.X1(MotionLayout.this.T());
            this.a.Z1();
            this.b.X1(MotionLayout.this.T());
            this.b.Z1();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    C17242me1 c17242me12 = this.a;
                    C16651le1.b bVar = C16651le1.b.WRAP_CONTENT;
                    c17242me12.O0(bVar);
                    this.b.O0(bVar);
                }
                if (layoutParams.height == -2) {
                    C17242me1 c17242me13 = this.a;
                    C16651le1.b bVar2 = C16651le1.b.WRAP_CONTENT;
                    c17242me13.f1(bVar2);
                    this.b.f1(bVar2);
                }
            }
        }

        public boolean f(int i, int i2) {
            return (i == this.e && i2 == this.f) ? false : true;
        }

        public void g(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.u1 = mode;
            motionLayout.v1 = mode2;
            motionLayout.getOptimizationLevel();
            b(i, i2);
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                b(i, i2);
                MotionLayout.this.q1 = this.a.X();
                MotionLayout.this.r1 = this.a.z();
                MotionLayout.this.s1 = this.b.X();
                MotionLayout.this.t1 = this.b.z();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.p1 = (motionLayout2.q1 == motionLayout2.s1 && motionLayout2.r1 == motionLayout2.t1) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i3 = motionLayout3.q1;
            int i4 = motionLayout3.r1;
            int i5 = motionLayout3.u1;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                i3 = (int) (i3 + (motionLayout3.w1 * (motionLayout3.s1 - i3)));
            }
            int i6 = i3;
            int i7 = motionLayout3.v1;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                i4 = (int) (i4 + (motionLayout3.w1 * (motionLayout3.t1 - i4)));
            }
            MotionLayout.this.W(i, i2, i6, i4, this.a.P1() || this.b.P1(), this.a.N1() || this.b.N1());
        }

        public void h() {
            g(MotionLayout.this.J, MotionLayout.this.z0);
            MotionLayout.this.f1();
        }

        public void i(int i, int i2) {
            this.e = i;
            this.f = i2;
        }
    }

    protected interface g {
        void a();

        void b(MotionEvent motionEvent);

        float c();

        float d();

        void e(int i);
    }

    private static class h implements g {
        private static h b = new h();
        VelocityTracker a;

        private h() {
        }

        public static h f() {
            b.a = VelocityTracker.obtain();
            return b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public void a() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.a = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public void b(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public float c() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public float d() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.g
        public void e(int i) {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }
    }

    class i {
        float a = Float.NaN;
        float b = Float.NaN;
        int c = -1;
        int d = -1;
        final String e = "motion.progress";
        final String f = "motion.velocity";
        final String g = "motion.StartState";
        final String h = "motion.EndState";

        i() {
        }

        void a() {
            int i = this.c;
            if (i != -1 || this.d != -1) {
                if (i == -1) {
                    MotionLayout.this.l1(this.d);
                } else {
                    int i2 = this.d;
                    if (i2 == -1) {
                        MotionLayout.this.setState(i, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i, i2);
                    }
                }
                MotionLayout.this.setState(k.SETUP);
            }
            if (Float.isNaN(this.b)) {
                if (Float.isNaN(this.a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.a);
            } else {
                MotionLayout.this.setProgress(this.a, this.b);
                this.a = Float.NaN;
                this.b = Float.NaN;
                this.c = -1;
                this.d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.a);
            bundle.putFloat("motion.velocity", this.b);
            bundle.putInt("motion.StartState", this.c);
            bundle.putInt("motion.EndState", this.d);
            return bundle;
        }

        public void c() {
            this.d = MotionLayout.this.H;
            this.c = MotionLayout.this.D;
            this.b = MotionLayout.this.getVelocity();
            this.a = MotionLayout.this.getProgress();
        }

        public void d(int i) {
            this.d = i;
        }

        public void e(float f) {
            this.a = f;
        }

        public void f(int i) {
            this.c = i;
        }

        public void g(Bundle bundle) {
            this.a = bundle.getFloat("motion.progress");
            this.b = bundle.getFloat("motion.velocity");
            this.c = bundle.getInt("motion.StartState");
            this.d = bundle.getInt("motion.EndState");
        }

        public void h(float f) {
            this.b = f;
        }
    }

    public interface j {
        void a(MotionLayout motionLayout, int i, int i2, float f);

        void b(MotionLayout motionLayout, int i);

        void c(MotionLayout motionLayout, int i, int i2);
    }

    enum k {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(Context context) {
        super(context);
        this.A = null;
        this.B = 0.0f;
        this.D = -1;
        this.G = -1;
        this.H = -1;
        this.J = 0;
        this.z0 = 0;
        this.A0 = true;
        this.B0 = new HashMap();
        this.C0 = 0L;
        this.D0 = 1.0f;
        this.E0 = 0.0f;
        this.F0 = 0.0f;
        this.H0 = 0.0f;
        this.J0 = false;
        this.K0 = false;
        this.O0 = 0;
        this.Q0 = false;
        this.R0 = new HN6();
        this.S0 = new d();
        this.U0 = true;
        this.Z0 = false;
        this.e1 = false;
        this.f1 = null;
        this.g1 = null;
        this.h1 = null;
        this.i1 = null;
        this.j1 = 0;
        this.k1 = -1L;
        this.l1 = 0.0f;
        this.m1 = 0;
        this.n1 = 0.0f;
        this.o1 = false;
        this.p1 = false;
        this.x1 = new C17935no3();
        this.y1 = false;
        this.A1 = null;
        this.B1 = null;
        this.C1 = 0;
        this.D1 = false;
        this.E1 = 0;
        this.F1 = new HashMap();
        this.J1 = new Rect();
        this.K1 = false;
        this.L1 = k.UNDEFINED;
        this.M1 = new f();
        this.N1 = false;
        this.O1 = new RectF();
        this.P1 = null;
        this.Q1 = null;
        this.R1 = new ArrayList();
        Z0(null);
    }

    private boolean F0(View view, MotionEvent motionEvent, float f2, float f3) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f2, f3);
            boolean zOnTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f2, -f3);
            return zOnTouchEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(f2, f3);
        if (this.Q1 == null) {
            this.Q1 = new Matrix();
        }
        matrix.invert(this.Q1);
        motionEventObtain.transform(this.Q1);
        boolean zOnTouchEvent2 = view.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zOnTouchEvent2;
    }

    private void G0() {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int iF = iVar.F();
        androidx.constraintlayout.motion.widget.i iVar2 = this.y;
        H0(iF, iVar2.l(iVar2.F()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator it = this.y.o().iterator();
        while (it.hasNext()) {
            i.b bVar = (i.b) it.next();
            if (bVar == this.y.c) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            I0(bVar);
            int iA = bVar.A();
            int iY = bVar.y();
            String strC = OA1.c(getContext(), iA);
            String strC2 = OA1.c(getContext(), iY);
            if (sparseIntArray.get(iA) == iY) {
                StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 53 + String.valueOf(strC2).length());
                sb.append("CHECK: two transitions with the same start and end ");
                sb.append(strC);
                sb.append("->");
                sb.append(strC2);
                Log.e("MotionLayout", sb.toString());
            }
            if (sparseIntArray2.get(iY) == iA) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(strC).length() + 43 + String.valueOf(strC2).length());
                sb2.append("CHECK: you can't have reverse transitions");
                sb2.append(strC);
                sb2.append("->");
                sb2.append(strC2);
                Log.e("MotionLayout", sb2.toString());
            }
            sparseIntArray.put(iA, iY);
            sparseIntArray2.put(iY, iA);
            if (this.y.l(iA) == null) {
                String strValueOf = String.valueOf(strC);
                Log.e("MotionLayout", strValueOf.length() != 0 ? " no such constraintSetStart ".concat(strValueOf) : new String(" no such constraintSetStart "));
            }
            if (this.y.l(iY) == null) {
                String strValueOf2 = String.valueOf(strC);
                Log.e("MotionLayout", strValueOf2.length() != 0 ? " no such constraintSetEnd ".concat(strValueOf2) : new String(" no such constraintSetEnd "));
            }
        }
    }

    private void H0(int i2, androidx.constraintlayout.widget.c cVar) {
        String strC = OA1.c(getContext(), i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            if (id == -1) {
                String name = childAt.getClass().getName();
                StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 45 + name.length());
                sb.append("CHECK: ");
                sb.append(strC);
                sb.append(" ALL VIEWS SHOULD HAVE ID's ");
                sb.append(name);
                sb.append(" does not!");
                Log.w("MotionLayout", sb.toString());
            }
            if (cVar.y(id) == null) {
                String strD = OA1.d(childAt);
                StringBuilder sb2 = new StringBuilder(String.valueOf(strC).length() + 27 + String.valueOf(strD).length());
                sb2.append("CHECK: ");
                sb2.append(strC);
                sb2.append(" NO CONSTRAINTS for ");
                sb2.append(strD);
                Log.w("MotionLayout", sb2.toString());
            }
        }
        int[] iArrA = cVar.A();
        for (int i4 = 0; i4 < iArrA.length; i4++) {
            int i5 = iArrA[i4];
            String strC2 = OA1.c(getContext(), i5);
            if (findViewById(iArrA[i4]) == null) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(strC).length() + 27 + String.valueOf(strC2).length());
                sb3.append("CHECK: ");
                sb3.append(strC);
                sb3.append(" NO View matches id ");
                sb3.append(strC2);
                Log.w("MotionLayout", sb3.toString());
            }
            if (cVar.z(i5) == -1) {
                StringBuilder sb4 = new StringBuilder(String.valueOf(strC).length() + 26 + String.valueOf(strC2).length());
                sb4.append("CHECK: ");
                sb4.append(strC);
                sb4.append(Separators.LPAREN);
                sb4.append(strC2);
                sb4.append(") no LAYOUT_HEIGHT");
                Log.w("MotionLayout", sb4.toString());
            }
            if (cVar.E(i5) == -1) {
                StringBuilder sb5 = new StringBuilder(String.valueOf(strC).length() + 26 + String.valueOf(strC2).length());
                sb5.append("CHECK: ");
                sb5.append(strC);
                sb5.append(Separators.LPAREN);
                sb5.append(strC2);
                sb5.append(") no LAYOUT_HEIGHT");
                Log.w("MotionLayout", sb5.toString());
            }
        }
    }

    private void I0(i.b bVar) {
        if (bVar.A() == bVar.y()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    private void J0() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.B0.get(childAt);
            if (gVar != null) {
                gVar.E(childAt);
            }
        }
    }

    private void P0() {
        boolean z;
        float fSignum = Math.signum(this.H0 - this.F0);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.z;
        float interpolation = this.F0 + (!(interpolator instanceof HN6) ? (((nanoTime - this.G0) * fSignum) * 1.0E-9f) / this.D0 : 0.0f);
        if (this.I0) {
            interpolation = this.H0;
        }
        if ((fSignum <= 0.0f || interpolation < this.H0) && (fSignum > 0.0f || interpolation > this.H0)) {
            z = false;
        } else {
            interpolation = this.H0;
            z = true;
        }
        if (interpolator != null && !z) {
            interpolation = this.Q0 ? interpolator.getInterpolation((nanoTime - this.C0) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.H0) || (fSignum <= 0.0f && interpolation <= this.H0)) {
            interpolation = this.H0;
        }
        this.w1 = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.A;
        if (interpolator2 != null) {
            interpolation = interpolator2.getInterpolation(interpolation);
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.B0.get(childAt);
            if (gVar != null) {
                gVar.x(childAt, interpolation, nanoTime2, this.x1);
            }
        }
        if (this.p1) {
            requestLayout();
        }
    }

    private void R0() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.L0 == null && ((copyOnWriteArrayList = this.i1) == null || copyOnWriteArrayList.isEmpty())) || this.n1 == this.E0) {
            return;
        }
        if (this.m1 != -1) {
            j jVar = this.L0;
            if (jVar != null) {
                jVar.c(this, this.D, this.H);
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.i1;
            if (copyOnWriteArrayList2 != null) {
                Iterator it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).c(this, this.D, this.H);
                }
            }
            this.o1 = true;
        }
        this.m1 = -1;
        float f2 = this.E0;
        this.n1 = f2;
        j jVar2 = this.L0;
        if (jVar2 != null) {
            jVar2.a(this, this.D, this.H, f2);
        }
        CopyOnWriteArrayList copyOnWriteArrayList3 = this.i1;
        if (copyOnWriteArrayList3 != null) {
            Iterator it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                ((j) it2.next()).a(this, this.D, this.H, this.E0);
            }
        }
        this.o1 = true;
    }

    private boolean Y0(float f2, float f3, View view, MotionEvent motionEvent) {
        boolean z;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (Y0((r3.getLeft() + f2) - view.getScrollX(), (r3.getTop() + f3) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (!z) {
            this.O1.set(f2, f3, (view.getRight() + f2) - view.getLeft(), (view.getBottom() + f3) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.O1.contains(motionEvent.getX(), motionEvent.getY())) && F0(view, motionEvent, -f2, -f3)) {
                return true;
            }
        }
        return z;
    }

    private void Z0(AttributeSet attributeSet) {
        androidx.constraintlayout.motion.widget.i iVar;
        S1 = isInEditMode();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, SE5.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == SE5.MotionLayout_layoutDescription) {
                    this.y = new androidx.constraintlayout.motion.widget.i(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == SE5.MotionLayout_currentState) {
                    this.G = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == SE5.MotionLayout_motionProgress) {
                    this.H0 = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.J0 = true;
                } else if (index == SE5.MotionLayout_applyMotionScene) {
                    z = typedArrayObtainStyledAttributes.getBoolean(index, z);
                } else if (index == SE5.MotionLayout_showPaths) {
                    if (this.O0 == 0) {
                        this.O0 = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == SE5.MotionLayout_motionDebug) {
                    this.O0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.y == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.y = null;
            }
        }
        if (this.O0 != 0) {
            G0();
        }
        if (this.G != -1 || (iVar = this.y) == null) {
            return;
        }
        this.G = iVar.F();
        this.D = this.y.F();
        this.H = this.y.q();
    }

    private void d1() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (this.L0 == null && ((copyOnWriteArrayList = this.i1) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.o1 = false;
        Iterator it = this.R1.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            j jVar = this.L0;
            if (jVar != null) {
                jVar.b(this, num.intValue());
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.i1;
            if (copyOnWriteArrayList2 != null) {
                Iterator it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    ((j) it2.next()).b(this, num.intValue());
                }
            }
        }
        this.R1.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        int childCount = getChildCount();
        this.M1.a();
        this.J0 = true;
        SparseArray sparseArray = new SparseArray();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            sparseArray.put(childAt.getId(), (androidx.constraintlayout.motion.widget.g) this.B0.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int iJ = this.y.j();
        if (iJ != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i4));
                if (gVar != null) {
                    gVar.D(iJ);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.B0.size()];
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            androidx.constraintlayout.motion.widget.g gVar2 = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i6));
            if (gVar2.h() != -1) {
                sparseBooleanArray.put(gVar2.h(), true);
                iArr[i5] = gVar2.h();
                i5++;
            }
        }
        if (this.h1 != null) {
            for (int i7 = 0; i7 < i5; i7++) {
                androidx.constraintlayout.motion.widget.g gVar3 = (androidx.constraintlayout.motion.widget.g) this.B0.get(findViewById(iArr[i7]));
                if (gVar3 != null) {
                    this.y.t(gVar3);
                }
            }
            Iterator it = this.h1.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).D(this, this.B0);
            }
            for (int i8 = 0; i8 < i5; i8++) {
                androidx.constraintlayout.motion.widget.g gVar4 = (androidx.constraintlayout.motion.widget.g) this.B0.get(findViewById(iArr[i8]));
                if (gVar4 != null) {
                    gVar4.I(width, height, this.D0, getNanoTime());
                }
            }
        } else {
            for (int i9 = 0; i9 < i5; i9++) {
                androidx.constraintlayout.motion.widget.g gVar5 = (androidx.constraintlayout.motion.widget.g) this.B0.get(findViewById(iArr[i9]));
                if (gVar5 != null) {
                    this.y.t(gVar5);
                    gVar5.I(width, height, this.D0, getNanoTime());
                }
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = getChildAt(i10);
            androidx.constraintlayout.motion.widget.g gVar6 = (androidx.constraintlayout.motion.widget.g) this.B0.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && gVar6 != null) {
                this.y.t(gVar6);
                gVar6.I(width, height, this.D0, getNanoTime());
            }
        }
        float fE = this.y.E();
        if (fE != 0.0f) {
            boolean z = ((double) fE) < 0.0d;
            float fAbs = Math.abs(fE);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            float fMin2 = Float.MAX_VALUE;
            for (int i11 = 0; i11 < childCount; i11++) {
                androidx.constraintlayout.motion.widget.g gVar7 = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i11));
                if (!Float.isNaN(gVar7.m)) {
                    for (int i12 = 0; i12 < childCount; i12++) {
                        androidx.constraintlayout.motion.widget.g gVar8 = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i12));
                        if (!Float.isNaN(gVar8.m)) {
                            fMin = Math.min(fMin, gVar8.m);
                            fMax = Math.max(fMax, gVar8.m);
                        }
                    }
                    while (i2 < childCount) {
                        androidx.constraintlayout.motion.widget.g gVar9 = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i2));
                        if (!Float.isNaN(gVar9.m)) {
                            gVar9.o = 1.0f / (1.0f - fAbs);
                            if (z) {
                                gVar9.n = fAbs - (((fMax - gVar9.m) / (fMax - fMin)) * fAbs);
                            } else {
                                gVar9.n = fAbs - (((gVar9.m - fMin) * fAbs) / (fMax - fMin));
                            }
                        }
                        i2++;
                    }
                    return;
                }
                float fN = gVar7.n();
                float fO = gVar7.o();
                float f2 = z ? fO - fN : fO + fN;
                fMin2 = Math.min(fMin2, f2);
                fMax2 = Math.max(fMax2, f2);
            }
            while (i2 < childCount) {
                androidx.constraintlayout.motion.widget.g gVar10 = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i2));
                float fN2 = gVar10.n();
                float fO2 = gVar10.o();
                float f3 = z ? fO2 - fN2 : fO2 + fN2;
                gVar10.o = 1.0f / (1.0f - fAbs);
                gVar10.n = fAbs - (((f3 - fMin2) * fAbs) / (fMax2 - fMin2));
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect g1(C16651le1 c16651le1) {
        this.J1.top = c16651le1.Z();
        this.J1.left = c16651le1.Y();
        Rect rect = this.J1;
        int iX = c16651le1.X();
        Rect rect2 = this.J1;
        rect.right = iX + rect2.left;
        int iZ = c16651le1.z();
        Rect rect3 = this.J1;
        rect2.bottom = iZ + rect3.top;
        return rect3;
    }

    private static boolean s1(float f2, float f3, float f4) {
        if (f2 > 0.0f) {
            float f5 = f2 / f4;
            return f3 + ((f2 * f5) - (((f4 * f5) * f5) / 2.0f)) > 1.0f;
        }
        float f6 = (-f2) / f4;
        return f3 + ((f2 * f6) + (((f4 * f6) * f6) / 2.0f)) < 0.0f;
    }

    void C0(float f2) {
        if (this.y == null) {
            return;
        }
        float f3 = this.F0;
        float f4 = this.E0;
        if (f3 != f4 && this.I0) {
            this.F0 = f4;
        }
        float f5 = this.F0;
        if (f5 == f2) {
            return;
        }
        this.Q0 = false;
        this.H0 = f2;
        this.D0 = r0.p() / 1000.0f;
        setProgress(this.H0);
        this.z = null;
        this.A = this.y.s();
        this.I0 = false;
        this.C0 = getNanoTime();
        this.J0 = true;
        this.E0 = f5;
        this.F0 = f5;
        invalidate();
    }

    public boolean D0(int i2, androidx.constraintlayout.motion.widget.g gVar) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            return iVar.g(i2, gVar);
        }
        return false;
    }

    void K0(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i2));
            if (gVar != null) {
                gVar.f(z);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2 A[PHI: r3
      0x00e2: PHI (r3v50 float) = (r3v49 float), (r3v51 float), (r3v51 float) binds: [B:47:0x00ab, B:58:0x00d6, B:60:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void L0(boolean r23) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.L0(boolean):void");
    }

    protected void S0() {
        int iIntValue;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.L0 != null || ((copyOnWriteArrayList = this.i1) != null && !copyOnWriteArrayList.isEmpty())) && this.m1 == -1) {
            this.m1 = this.G;
            if (this.R1.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList arrayList = this.R1;
                iIntValue = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            }
            int i2 = this.G;
            if (iIntValue != i2 && i2 != -1) {
                this.R1.add(Integer.valueOf(i2));
            }
        }
        d1();
        Runnable runnable = this.A1;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.B1;
        if (iArr == null || this.C1 <= 0) {
            return;
        }
        l1(iArr[0]);
        int[] iArr2 = this.B1;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.C1--;
    }

    void T0(int i2, float f2, float f3, float f4, float[] fArr) throws Resources.NotFoundException {
        String resourceName;
        HashMap map = this.B0;
        View viewK = K(i2);
        androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) map.get(viewK);
        if (gVar != null) {
            gVar.l(f2, f3, f4, fArr);
            float y = viewK.getY();
            this.M0 = f2;
            this.N0 = y;
            return;
        }
        if (viewK == null) {
            StringBuilder sb = new StringBuilder(11);
            sb.append(i2);
            resourceName = sb.toString();
        } else {
            resourceName = viewK.getContext().getResources().getResourceName(i2);
        }
        String strValueOf = String.valueOf(resourceName);
        Log.w("MotionLayout", strValueOf.length() != 0 ? "WARNING could not find view id ".concat(strValueOf) : new String("WARNING could not find view id "));
    }

    public androidx.constraintlayout.widget.c U0(int i2) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            return null;
        }
        return iVar.l(i2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void V(int i2) {
        this.k = null;
    }

    androidx.constraintlayout.motion.widget.g V0(int i2) {
        return (androidx.constraintlayout.motion.widget.g) this.B0.get(findViewById(i2));
    }

    public i.b W0(int i2) {
        return this.y.G(i2);
    }

    public void X0(View view, float f2, float f3, float[] fArr, int i2) {
        float interpolation;
        float fA = this.B;
        float f4 = this.F0;
        if (this.z != null) {
            float fSignum = Math.signum(this.H0 - f4);
            float interpolation2 = this.z.getInterpolation(this.F0 + 1.0E-5f);
            interpolation = this.z.getInterpolation(this.F0);
            fA = (fSignum * ((interpolation2 - interpolation) / 1.0E-5f)) / this.D0;
        } else {
            interpolation = f4;
        }
        Interpolator interpolator = this.z;
        if (interpolator instanceof AbstractInterpolatorC13741gk4) {
            fA = ((AbstractInterpolatorC13741gk4) interpolator).a();
        }
        androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.B0.get(view);
        if ((i2 & 1) == 0) {
            gVar.r(interpolation, view.getWidth(), view.getHeight(), f2, f3, fArr);
        } else {
            gVar.l(interpolation, f2, f3, fArr);
        }
        if (i2 < 2) {
            fArr[0] = fArr[0] * fA;
            fArr[1] = fArr[1] * fA;
        }
    }

    public boolean a1() {
        return this.A0;
    }

    protected g b1() {
        return h.f();
    }

    void c1() {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            return;
        }
        if (iVar.h(this, this.G)) {
            requestLayout();
            return;
        }
        int i2 = this.G;
        if (i2 != -1) {
            this.y.f(this, i2);
        }
        if (this.y.b0()) {
            this.y.Z();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) throws Resources.NotFoundException {
        l lVar;
        ArrayList arrayList = this.h1;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).C(canvas);
            }
        }
        L0(false);
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null && (lVar = iVar.s) != null) {
            lVar.c();
        }
        super.dispatchDraw(canvas);
        if (this.y == null) {
            return;
        }
        if ((this.O0 & 1) == 1 && !isInEditMode()) {
            this.j1++;
            long nanoTime = getNanoTime();
            long j2 = this.k1;
            if (j2 != -1) {
                if (nanoTime - j2 > 200000000) {
                    this.l1 = ((int) ((this.j1 / (r5 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.j1 = 0;
                    this.k1 = nanoTime;
                }
            } else {
                this.k1 = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            float progress = ((int) (getProgress() * 1000.0f)) / 10.0f;
            float f2 = this.l1;
            String strE = OA1.e(this, this.D);
            StringBuilder sb = new StringBuilder(String.valueOf(strE).length() + 24);
            sb.append(f2);
            sb.append(" fps ");
            sb.append(strE);
            sb.append(" -> ");
            String strValueOf = String.valueOf(sb.toString());
            String strE2 = OA1.e(this, this.H);
            int i2 = this.G;
            String strE3 = i2 == -1 ? StringUtils.UNDEFINED : OA1.e(this, i2);
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 36 + String.valueOf(strE2).length() + String.valueOf(strE3).length());
            sb2.append(strValueOf);
            sb2.append(strE2);
            sb2.append(" (progress: ");
            sb2.append(progress);
            sb2.append(" ) state=");
            sb2.append(strE3);
            String string = sb2.toString();
            paint.setColor(-16777216);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.O0 > 1) {
            if (this.P0 == null) {
                this.P0 = new e();
            }
            this.P0.a(canvas, this.B0, this.y.p(), this.O0);
        }
        ArrayList arrayList2 = this.h1;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((MotionHelper) it2.next()).B(canvas);
            }
        }
    }

    public void e1() {
        this.M1.h();
        invalidate();
    }

    public int[] getConstraintSetIds() {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            return null;
        }
        return iVar.n();
    }

    public int getCurrentState() {
        return this.G;
    }

    public ArrayList<i.b> getDefinedTransitions() {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            return null;
        }
        return iVar.o();
    }

    public C21890uJ1 getDesignTool() {
        if (this.T0 == null) {
            this.T0 = new C21890uJ1(this);
        }
        return this.T0;
    }

    public int getEndState() {
        return this.H;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.F0;
    }

    public androidx.constraintlayout.motion.widget.i getScene() {
        return this.y;
    }

    public int getStartState() {
        return this.D;
    }

    public float getTargetPosition() {
        return this.H0;
    }

    public Bundle getTransitionState() {
        if (this.z1 == null) {
            this.z1 = new i();
        }
        this.z1.c();
        return this.z1.b();
    }

    public long getTransitionTimeMs() {
        if (this.y != null) {
            this.D0 = r0.p() / 1000.0f;
        }
        return (long) (this.D0 * 1000.0f);
    }

    public float getVelocity() {
        return this.B;
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void h(View view, View view2, int i2, int i3) {
        this.c1 = getNanoTime();
        this.d1 = 0.0f;
        this.a1 = 0.0f;
        this.b1 = 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h1(int r10, float r11, float r12) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.h1(int, float, float):void");
    }

    public void i1() {
        C0(1.0f);
        this.A1 = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public void j1(Runnable runnable) {
        C0(1.0f);
        this.A1 = runnable;
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void k(View view, int i2) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            float f2 = this.d1;
            if (f2 == 0.0f) {
                return;
            }
            iVar.Q(this.a1 / f2, this.b1 / f2);
        }
    }

    public void k1() {
        C0(0.0f);
    }

    public void l1(int i2) {
        if (isAttachedToWindow()) {
            m1(i2, -1, -1);
            return;
        }
        if (this.z1 == null) {
            this.z1 = new i();
        }
        this.z1.d(i2);
    }

    public void m1(int i2, int i3, int i4) {
        o1(i2, i3, i4, -1);
    }

    public void o1(int i2, int i3, int i4, int i5) {
        C17663nL6 c17663nL6;
        int iA;
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null && (c17663nL6 = iVar.b) != null && (iA = c17663nL6.a(this.G, i2, i3, i4)) != -1) {
            i2 = iA;
        }
        int i6 = this.G;
        if (i6 == i2) {
            return;
        }
        if (this.D == i2) {
            C0(0.0f);
            if (i5 > 0) {
                this.D0 = i5 / 1000.0f;
                return;
            }
            return;
        }
        if (this.H == i2) {
            C0(1.0f);
            if (i5 > 0) {
                this.D0 = i5 / 1000.0f;
                return;
            }
            return;
        }
        this.H = i2;
        if (i6 != -1) {
            setTransition(i6, i2);
            C0(1.0f);
            this.F0 = 0.0f;
            i1();
            if (i5 > 0) {
                this.D0 = i5 / 1000.0f;
                return;
            }
            return;
        }
        this.Q0 = false;
        this.H0 = 1.0f;
        this.E0 = 0.0f;
        this.F0 = 0.0f;
        this.G0 = getNanoTime();
        this.C0 = getNanoTime();
        this.I0 = false;
        this.z = null;
        if (i5 == -1) {
            this.D0 = this.y.p() / 1000.0f;
        }
        this.D = -1;
        this.y.X(-1, this.H);
        SparseArray sparseArray = new SparseArray();
        if (i5 == 0) {
            this.D0 = this.y.p() / 1000.0f;
        } else if (i5 > 0) {
            this.D0 = i5 / 1000.0f;
        }
        int childCount = getChildCount();
        this.B0.clear();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            this.B0.put(childAt, new androidx.constraintlayout.motion.widget.g(childAt));
            sparseArray.put(childAt.getId(), (androidx.constraintlayout.motion.widget.g) this.B0.get(childAt));
        }
        this.J0 = true;
        this.M1.e(this.c, null, this.y.l(i2));
        e1();
        this.M1.a();
        J0();
        int width = getWidth();
        int height = getHeight();
        if (this.h1 != null) {
            for (int i8 = 0; i8 < childCount; i8++) {
                androidx.constraintlayout.motion.widget.g gVar = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i8));
                if (gVar != null) {
                    this.y.t(gVar);
                }
            }
            Iterator it = this.h1.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).D(this, this.B0);
            }
            for (int i9 = 0; i9 < childCount; i9++) {
                androidx.constraintlayout.motion.widget.g gVar2 = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i9));
                if (gVar2 != null) {
                    gVar2.I(width, height, this.D0, getNanoTime());
                }
            }
        } else {
            for (int i10 = 0; i10 < childCount; i10++) {
                androidx.constraintlayout.motion.widget.g gVar3 = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i10));
                if (gVar3 != null) {
                    this.y.t(gVar3);
                    gVar3.I(width, height, this.D0, getNanoTime());
                }
            }
        }
        float fE = this.y.E();
        if (fE != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i11 = 0; i11 < childCount; i11++) {
                androidx.constraintlayout.motion.widget.g gVar4 = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i11));
                float fO = gVar4.o() + gVar4.n();
                fMin = Math.min(fMin, fO);
                fMax = Math.max(fMax, fO);
            }
            for (int i12 = 0; i12 < childCount; i12++) {
                androidx.constraintlayout.motion.widget.g gVar5 = (androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i12));
                float fN = gVar5.n();
                float fO2 = gVar5.o();
                gVar5.o = 1.0f / (1.0f - fE);
                gVar5.n = fE - ((((fN + fO2) - fMin) * fE) / (fMax - fMin));
            }
        }
        this.E0 = 0.0f;
        this.F0 = 0.0f;
        this.J0 = true;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        i.b bVar;
        int i2;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.I1 = display.getRotation();
        }
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null && (i2 = this.G) != -1) {
            androidx.constraintlayout.widget.c cVarL = iVar.l(i2);
            this.y.T(this);
            ArrayList arrayList = this.h1;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((MotionHelper) it.next()).A(this);
                }
            }
            if (cVarL != null) {
                cVarL.i(this);
            }
            this.D = this.G;
        }
        c1();
        i iVar2 = this.z1;
        if (iVar2 != null) {
            if (this.K1) {
                post(new b());
                return;
            } else {
                iVar2.a();
                return;
            }
        }
        androidx.constraintlayout.motion.widget.i iVar3 = this.y;
        if (iVar3 == null || (bVar = iVar3.c) == null || bVar.x() != 4) {
            return;
        }
        i1();
        setState(k.SETUP);
        setState(k.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        androidx.constraintlayout.motion.widget.j jVarB;
        int iQ;
        RectF rectFP;
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null && this.A0) {
            l lVar = iVar.s;
            if (lVar != null) {
                lVar.h(motionEvent);
            }
            i.b bVar = this.y.c;
            if (bVar != null && bVar.C() && (jVarB = bVar.B()) != null && ((motionEvent.getAction() != 0 || (rectFP = jVarB.p(this, new RectF())) == null || rectFP.contains(motionEvent.getX(), motionEvent.getY())) && (iQ = jVarB.q()) != -1)) {
                View view = this.P1;
                if (view == null || view.getId() != iQ) {
                    this.P1 = findViewById(iQ);
                }
                if (this.P1 != null) {
                    this.O1.set(r0.getLeft(), this.P1.getTop(), this.P1.getRight(), this.P1.getBottom());
                    if (this.O1.contains(motionEvent.getX(), motionEvent.getY()) && !Y0(this.P1.getLeft(), this.P1.getTop(), this.P1, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.y1 = true;
        try {
            if (this.y == null) {
                super.onLayout(z, i2, i3, i4, i5);
                return;
            }
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (this.X0 != i6 || this.Y0 != i7) {
                e1();
                L0(true);
            }
            this.X0 = i6;
            this.Y0 = i7;
            this.V0 = i6;
            this.W0 = i7;
        } finally {
            this.y1 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.y == null) {
            super.onMeasure(i2, i3);
            return;
        }
        boolean z = false;
        boolean z2 = (this.J == i2 && this.z0 == i3) ? false : true;
        if (this.N1) {
            this.N1 = false;
            c1();
            d1();
            z2 = true;
        }
        if (this.h) {
            z2 = true;
        }
        this.J = i2;
        this.z0 = i3;
        int iF = this.y.F();
        int iQ = this.y.q();
        if ((z2 || this.M1.f(iF, iQ)) && this.D != -1) {
            super.onMeasure(i2, i3);
            this.M1.e(this.c, this.y.l(iF), this.y.l(iQ));
            this.M1.h();
            this.M1.i(iF, iQ);
        } else {
            if (z2) {
                super.onMeasure(i2, i3);
            }
            z = true;
        }
        if (this.p1 || z) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int iX = this.c.X() + getPaddingLeft() + getPaddingRight();
            int iZ = this.c.z() + paddingTop;
            int i4 = this.u1;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                iX = (int) (this.q1 + (this.w1 * (this.s1 - r8)));
                requestLayout();
            }
            int i5 = this.v1;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                iZ = (int) (this.r1 + (this.w1 * (this.t1 - r8)));
                requestLayout();
            }
            setMeasuredDimension(iX, iZ);
        }
        P0();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            iVar.W(T());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null || !this.A0 || !iVar.b0()) {
            return super.onTouchEvent(motionEvent);
        }
        i.b bVar = this.y.c;
        if (bVar != null && !bVar.C()) {
            return super.onTouchEvent(motionEvent);
        }
        this.y.R(motionEvent, getCurrentState(), this);
        if (this.y.c.D(4)) {
            return this.y.c.B().r();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.i1 == null) {
                this.i1 = new CopyOnWriteArrayList();
            }
            this.i1.add(motionHelper);
            if (motionHelper.z()) {
                if (this.f1 == null) {
                    this.f1 = new ArrayList();
                }
                this.f1.add(motionHelper);
            }
            if (motionHelper.y()) {
                if (this.g1 == null) {
                    this.g1 = new ArrayList();
                }
                this.g1.add(motionHelper);
            }
            if (motionHelper.x()) {
                if (this.h1 == null) {
                    this.h1 = new ArrayList();
                }
                this.h1.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.f1;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.g1;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void p(View view, int i2, int i3, int[] iArr, int i4) {
        i.b bVar;
        androidx.constraintlayout.motion.widget.j jVarB;
        int iQ;
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null || (bVar = iVar.c) == null || !bVar.C()) {
            return;
        }
        int i5 = -1;
        if (!bVar.C() || (jVarB = bVar.B()) == null || (iQ = jVarB.q()) == -1 || view.getId() == iQ) {
            if (iVar.w()) {
                androidx.constraintlayout.motion.widget.j jVarB2 = bVar.B();
                if (jVarB2 != null && (jVarB2.e() & 4) != 0) {
                    i5 = i3;
                }
                float f2 = this.E0;
                if ((f2 == 1.0f || f2 == 0.0f) && view.canScrollVertically(i5)) {
                    return;
                }
            }
            if (bVar.B() != null && (bVar.B().e() & 1) != 0) {
                float fX = iVar.x(i2, i3);
                float f3 = this.F0;
                if ((f3 <= 0.0f && fX < 0.0f) || (f3 >= 1.0f && fX > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new a(this, view));
                    return;
                }
            }
            float f4 = this.E0;
            long nanoTime = getNanoTime();
            float f5 = i2;
            this.a1 = f5;
            float f6 = i3;
            this.b1 = f6;
            this.d1 = (float) ((nanoTime - this.c1) * 1.0E-9d);
            this.c1 = nanoTime;
            iVar.P(f5, f6);
            if (f4 != this.E0) {
                iArr[0] = i2;
                iArr[1] = i3;
            }
            L0(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.Z0 = true;
        }
    }

    public void p1() {
        this.M1.e(this.c, this.y.l(this.D), this.y.l(this.H));
        e1();
    }

    public void q1(int i2, androidx.constraintlayout.widget.c cVar) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            iVar.U(i2, cVar);
        }
        p1();
        if (this.G == i2) {
            cVar.i(this);
        }
    }

    @Override // ir.nasim.InterfaceC5744Kq4
    public void r(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (this.Z0 || i2 != 0 || i3 != 0) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
        }
        this.Z0 = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        androidx.constraintlayout.motion.widget.i iVar;
        i.b bVar;
        if (!this.p1 && this.G == -1 && (iVar = this.y) != null && (bVar = iVar.c) != null) {
            int iZ = bVar.z();
            if (iZ == 0) {
                return;
            }
            if (iZ == 2) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    ((androidx.constraintlayout.motion.widget.g) this.B0.get(getChildAt(i2))).z();
                }
                return;
            }
        }
        super.requestLayout();
    }

    public void setDebugMode(int i2) {
        this.O0 = i2;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.K1 = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.A0 = z;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.y != null) {
            setState(k.MOVING);
            Interpolator interpolatorS = this.y.s();
            if (interpolatorS != null) {
                setProgress(interpolatorS.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList arrayList = this.g1;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((MotionHelper) this.g1.get(i2)).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList arrayList = this.f1;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((MotionHelper) this.f1.get(i2)).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2, float f3) {
        if (!isAttachedToWindow()) {
            if (this.z1 == null) {
                this.z1 = new i();
            }
            this.z1.e(f2);
            this.z1.h(f3);
            return;
        }
        setProgress(f2);
        setState(k.MOVING);
        this.B = f3;
        if (f3 != 0.0f) {
            C0(f3 > 0.0f ? 1.0f : 0.0f);
        } else {
            if (f2 == 0.0f || f2 == 1.0f) {
                return;
            }
            C0(f2 > 0.5f ? 1.0f : 0.0f);
        }
    }

    public void setScene(androidx.constraintlayout.motion.widget.i iVar) {
        this.y = iVar;
        iVar.W(T());
        e1();
    }

    void setStartState(int i2) {
        if (isAttachedToWindow()) {
            this.G = i2;
            return;
        }
        if (this.z1 == null) {
            this.z1 = new i();
        }
        this.z1.f(i2);
        this.z1.d(i2);
    }

    void setState(k kVar) {
        k kVar2 = k.FINISHED;
        if (kVar == kVar2 && this.G == -1) {
            return;
        }
        k kVar3 = this.L1;
        this.L1 = kVar;
        k kVar4 = k.MOVING;
        if (kVar3 == kVar4 && kVar == kVar4) {
            R0();
        }
        int i2 = c.a[kVar3.ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3 && kVar == kVar2) {
                S0();
                return;
            }
            return;
        }
        if (kVar == kVar4) {
            R0();
        }
        if (kVar == kVar2) {
            S0();
        }
    }

    public void setTransition(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.z1 == null) {
                this.z1 = new i();
            }
            this.z1.f(i2);
            this.z1.d(i3);
            return;
        }
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            this.D = i2;
            this.H = i3;
            iVar.X(i2, i3);
            this.M1.e(this.c, this.y.l(i2), this.y.l(i3));
            e1();
            this.F0 = 0.0f;
            k1();
        }
    }

    public void setTransitionDuration(int i2) {
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            iVar.V(i2);
        }
    }

    public void setTransitionListener(j jVar) {
        this.L0 = jVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.z1 == null) {
            this.z1 = new i();
        }
        this.z1.g(bundle);
        if (isAttachedToWindow()) {
            this.z1.a();
        }
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void t(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        String strC = OA1.c(context, this.D);
        String strC2 = OA1.c(context, this.H);
        float f2 = this.F0;
        float f3 = this.B;
        StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 47 + String.valueOf(strC2).length());
        sb.append(strC);
        sb.append("->");
        sb.append(strC2);
        sb.append(" (pos:");
        sb.append(f2);
        sb.append(" Dpos/Dt:");
        sb.append(f3);
        return sb.toString();
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public boolean v(View view, View view2, int i2, int i3) {
        i.b bVar;
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        return (iVar == null || (bVar = iVar.c) == null || bVar.B() == null || (this.y.c.B().e() & 2) != 0) ? false : true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i2, int i3, int i4) {
        setState(k.SETUP);
        this.G = i2;
        this.D = -1;
        this.H = -1;
        androidx.constraintlayout.widget.b bVar = this.k;
        if (bVar != null) {
            bVar.d(i2, i3, i4);
            return;
        }
        androidx.constraintlayout.motion.widget.i iVar = this.y;
        if (iVar != null) {
            iVar.l(i2).i(this);
        }
    }

    public void setProgress(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.z1 == null) {
                this.z1 = new i();
            }
            this.z1.e(f2);
            return;
        }
        if (f2 <= 0.0f) {
            if (this.F0 == 1.0f && this.G == this.H) {
                setState(k.MOVING);
            }
            this.G = this.D;
            if (this.F0 == 0.0f) {
                setState(k.FINISHED);
            }
        } else if (f2 >= 1.0f) {
            if (this.F0 == 0.0f && this.G == this.D) {
                setState(k.MOVING);
            }
            this.G = this.H;
            if (this.F0 == 1.0f) {
                setState(k.FINISHED);
            }
        } else {
            this.G = -1;
            setState(k.MOVING);
        }
        if (this.y == null) {
            return;
        }
        this.I0 = true;
        this.H0 = f2;
        this.E0 = f2;
        this.G0 = -1L;
        this.C0 = -1L;
        this.z = null;
        this.J0 = true;
        invalidate();
    }

    public void setTransition(int i2) {
        float f2;
        if (this.y != null) {
            i.b bVarW0 = W0(i2);
            this.D = bVarW0.A();
            this.H = bVarW0.y();
            if (!isAttachedToWindow()) {
                if (this.z1 == null) {
                    this.z1 = new i();
                }
                this.z1.f(this.D);
                this.z1.d(this.H);
                return;
            }
            int i3 = this.G;
            if (i3 == this.D) {
                f2 = 0.0f;
            } else {
                f2 = i3 == this.H ? 1.0f : Float.NaN;
            }
            this.y.Y(bVarW0);
            this.M1.e(this.c, this.y.l(this.D), this.y.l(this.H));
            e1();
            if (this.F0 != f2) {
                if (f2 == 0.0f) {
                    K0(true);
                    this.y.l(this.D).i(this);
                } else if (f2 == 1.0f) {
                    K0(false);
                    this.y.l(this.H).i(this);
                }
            }
            this.F0 = Float.isNaN(f2) ? 0.0f : f2;
            if (Float.isNaN(f2)) {
                Log.v("MotionLayout", String.valueOf(OA1.b()).concat(" transitionToStart "));
                k1();
            } else {
                setProgress(f2);
            }
        }
    }

    protected void setTransition(i.b bVar) {
        this.y.Y(bVar);
        setState(k.SETUP);
        if (this.G == this.y.q()) {
            this.F0 = 1.0f;
            this.E0 = 1.0f;
            this.H0 = 1.0f;
        } else {
            this.F0 = 0.0f;
            this.E0 = 0.0f;
            this.H0 = 0.0f;
        }
        this.G0 = bVar.D(1) ? -1L : getNanoTime();
        int iF = this.y.F();
        int iQ = this.y.q();
        if (iF == this.D && iQ == this.H) {
            return;
        }
        this.D = iF;
        this.H = iQ;
        this.y.X(iF, iQ);
        this.M1.e(this.c, this.y.l(this.D), this.y.l(this.H));
        this.M1.i(this.D, this.H);
        this.M1.h();
        e1();
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = null;
        this.B = 0.0f;
        this.D = -1;
        this.G = -1;
        this.H = -1;
        this.J = 0;
        this.z0 = 0;
        this.A0 = true;
        this.B0 = new HashMap();
        this.C0 = 0L;
        this.D0 = 1.0f;
        this.E0 = 0.0f;
        this.F0 = 0.0f;
        this.H0 = 0.0f;
        this.J0 = false;
        this.K0 = false;
        this.O0 = 0;
        this.Q0 = false;
        this.R0 = new HN6();
        this.S0 = new d();
        this.U0 = true;
        this.Z0 = false;
        this.e1 = false;
        this.f1 = null;
        this.g1 = null;
        this.h1 = null;
        this.i1 = null;
        this.j1 = 0;
        this.k1 = -1L;
        this.l1 = 0.0f;
        this.m1 = 0;
        this.n1 = 0.0f;
        this.o1 = false;
        this.p1 = false;
        this.x1 = new C17935no3();
        this.y1 = false;
        this.A1 = null;
        this.B1 = null;
        this.C1 = 0;
        this.D1 = false;
        this.E1 = 0;
        this.F1 = new HashMap();
        this.J1 = new Rect();
        this.K1 = false;
        this.L1 = k.UNDEFINED;
        this.M1 = new f();
        this.N1 = false;
        this.O1 = new RectF();
        this.P1 = null;
        this.Q1 = null;
        this.R1 = new ArrayList();
        Z0(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = null;
        this.B = 0.0f;
        this.D = -1;
        this.G = -1;
        this.H = -1;
        this.J = 0;
        this.z0 = 0;
        this.A0 = true;
        this.B0 = new HashMap();
        this.C0 = 0L;
        this.D0 = 1.0f;
        this.E0 = 0.0f;
        this.F0 = 0.0f;
        this.H0 = 0.0f;
        this.J0 = false;
        this.K0 = false;
        this.O0 = 0;
        this.Q0 = false;
        this.R0 = new HN6();
        this.S0 = new d();
        this.U0 = true;
        this.Z0 = false;
        this.e1 = false;
        this.f1 = null;
        this.g1 = null;
        this.h1 = null;
        this.i1 = null;
        this.j1 = 0;
        this.k1 = -1L;
        this.l1 = 0.0f;
        this.m1 = 0;
        this.n1 = 0.0f;
        this.o1 = false;
        this.p1 = false;
        this.x1 = new C17935no3();
        this.y1 = false;
        this.A1 = null;
        this.B1 = null;
        this.C1 = 0;
        this.D1 = false;
        this.E1 = 0;
        this.F1 = new HashMap();
        this.J1 = new Rect();
        this.K1 = false;
        this.L1 = k.UNDEFINED;
        this.M1 = new f();
        this.N1 = false;
        this.O1 = new RectF();
        this.P1 = null;
        this.Q1 = null;
        this.R1 = new ArrayList();
        Z0(attributeSet);
    }
}
