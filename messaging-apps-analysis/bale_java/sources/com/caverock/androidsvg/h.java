package com.caverock.androidsvg;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import com.caverock.androidsvg.b;
import com.caverock.androidsvg.e;
import com.caverock.androidsvg.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes2.dex */
class h {
    private static HashSet i;
    private Canvas a;
    private float b;
    private com.caverock.androidsvg.g c;
    private C0155h d;
    private Stack e;
    private Stack f;
    private Stack g;
    private b.q h = null;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[g.E.d.values().length];
            c = iArr;
            try {
                iArr[g.E.d.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[g.E.d.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[g.E.d.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[g.E.c.values().length];
            b = iArr2;
            try {
                iArr2[g.E.c.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[g.E.c.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[g.E.c.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[e.a.values().length];
            a = iArr3;
            try {
                iArr3[e.a.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[e.a.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[e.a.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[e.a.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[e.a.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[e.a.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[e.a.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[e.a.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    private class b implements g.InterfaceC2012x {
        private float b;
        private float c;
        private boolean h;
        private List a = new ArrayList();
        private c d = null;
        private boolean e = false;
        private boolean f = true;
        private int g = -1;

        b(g.C2011w c2011w) {
            if (c2011w == null) {
                return;
            }
            c2011w.h(this);
            if (this.h) {
                this.d.b((c) this.a.get(this.g));
                this.a.set(this.g, this.d);
                this.h = false;
            }
            c cVar = this.d;
            if (cVar != null) {
                this.a.add(cVar);
            }
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void a(float f, float f2) {
            if (this.h) {
                this.d.b((c) this.a.get(this.g));
                this.a.set(this.g, this.d);
                this.h = false;
            }
            c cVar = this.d;
            if (cVar != null) {
                this.a.add(cVar);
            }
            this.b = f;
            this.c = f2;
            this.d = h.this.new c(f, f2, 0.0f, 0.0f);
            this.g = this.a.size();
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.f || this.e) {
                this.d.a(f, f2);
                this.a.add(this.d);
                this.e = false;
            }
            this.d = h.this.new c(f5, f6, f5 - f3, f6 - f4);
            this.h = false;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void c(float f, float f2) {
            this.d.a(f, f2);
            this.a.add(this.d);
            h hVar = h.this;
            c cVar = this.d;
            this.d = hVar.new c(f, f2, f - cVar.a, f2 - cVar.b);
            this.h = false;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void close() {
            this.a.add(this.d);
            c(this.b, this.c);
            this.h = true;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void d(float f, float f2, float f3, float f4) {
            this.d.a(f, f2);
            this.a.add(this.d);
            this.d = h.this.new c(f3, f4, f3 - f, f4 - f2);
            this.h = false;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.e = true;
            this.f = false;
            c cVar = this.d;
            h.h(cVar.a, cVar.b, f, f2, f3, z, z2, f4, f5, this);
            this.f = true;
            this.h = false;
        }

        List f() {
            return this.a;
        }
    }

    private class c {
        float a;
        float b;
        float c;
        float d;
        boolean e = false;

        c(float f, float f2, float f3, float f4) {
            this.c = 0.0f;
            this.d = 0.0f;
            this.a = f;
            this.b = f2;
            double dSqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (dSqrt != 0.0d) {
                this.c = (float) (f3 / dSqrt);
                this.d = (float) (f4 / dSqrt);
            }
        }

        void a(float f, float f2) {
            float f3 = f - this.a;
            float f4 = f2 - this.b;
            double dSqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (dSqrt != 0.0d) {
                f3 = (float) (f3 / dSqrt);
                f4 = (float) (f4 / dSqrt);
            }
            float f5 = this.c;
            if (f3 != (-f5) || f4 != (-this.d)) {
                this.c = f5 + f3;
                this.d += f4;
            } else {
                this.e = true;
                this.c = -f4;
                this.d = f3;
            }
        }

        void b(c cVar) {
            float f = cVar.c;
            float f2 = this.c;
            if (f == (-f2)) {
                float f3 = cVar.d;
                if (f3 == (-this.d)) {
                    this.e = true;
                    this.c = -f3;
                    this.d = cVar.c;
                    return;
                }
            }
            this.c = f2 + f;
            this.d += cVar.d;
        }

        public String toString() {
            return Separators.LPAREN + this.a + "," + this.b + Separators.SP + this.c + "," + this.d + Separators.RPAREN;
        }
    }

    private class d implements g.InterfaceC2012x {
        Path a = new Path();
        float b;
        float c;

        d(g.C2011w c2011w) {
            if (c2011w == null) {
                return;
            }
            c2011w.h(this);
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void a(float f, float f2) {
            this.a.moveTo(f, f2);
            this.b = f;
            this.c = f2;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            this.a.cubicTo(f, f2, f3, f4, f5, f6);
            this.b = f5;
            this.c = f6;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void c(float f, float f2) {
            this.a.lineTo(f, f2);
            this.b = f;
            this.c = f2;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void close() {
            this.a.close();
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void d(float f, float f2, float f3, float f4) {
            this.a.quadTo(f, f2, f3, f4);
            this.b = f3;
            this.c = f4;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            h.h(this.b, this.c, f, f2, f3, z, z2, f4, f5, this);
            this.b = f4;
            this.c = f5;
        }

        Path f() {
            return this.a;
        }
    }

    private class e extends f {
        private Path e;

        e(Path path, float f, float f2) {
            super(f, f2);
            this.e = path;
        }

        @Override // com.caverock.androidsvg.h.f, com.caverock.androidsvg.h.j
        public void b(String str) {
            if (h.this.Y0()) {
                if (h.this.d.b) {
                    h.this.a.drawTextOnPath(str, this.e, this.b, this.c, h.this.d.d);
                }
                if (h.this.d.c) {
                    h.this.a.drawTextOnPath(str, this.e, this.b, this.c, h.this.d.e);
                }
            }
            this.b += h.this.d.d.measureText(str);
        }
    }

    private class f extends j {
        float b;
        float c;

        f(float f, float f2) {
            super(h.this, null);
            this.b = f;
            this.c = f2;
        }

        @Override // com.caverock.androidsvg.h.j
        public void b(String str) {
            h.y("TextSequence render", new Object[0]);
            if (h.this.Y0()) {
                if (h.this.d.b) {
                    h.this.a.drawText(str, this.b, this.c, h.this.d.d);
                }
                if (h.this.d.c) {
                    h.this.a.drawText(str, this.b, this.c, h.this.d.e);
                }
            }
            this.b += h.this.d.d.measureText(str);
        }
    }

    private class g extends j {
        float b;
        float c;
        Path d;

        g(float f, float f2, Path path) {
            super(h.this, null);
            this.b = f;
            this.c = f2;
            this.d = path;
        }

        @Override // com.caverock.androidsvg.h.j
        public boolean a(g.Y y) {
            if (!(y instanceof g.Z)) {
                return true;
            }
            h.Z0("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // com.caverock.androidsvg.h.j
        public void b(String str) {
            if (h.this.Y0()) {
                Path path = new Path();
                h.this.d.d.getTextPath(str, 0, str.length(), this.b, this.c, path);
                this.d.addPath(path);
            }
            this.b += h.this.d.d.measureText(str);
        }
    }

    private class i extends j {
        float b;
        float c;
        RectF d;

        i(float f, float f2) {
            super(h.this, null);
            this.d = new RectF();
            this.b = f;
            this.c = f2;
        }

        @Override // com.caverock.androidsvg.h.j
        public boolean a(g.Y y) {
            if (!(y instanceof g.Z)) {
                return true;
            }
            g.Z z = (g.Z) y;
            g.N nW = y.a.w(z.o);
            if (nW == null) {
                h.F("TextPath path reference '%s' not found", z.o);
                return false;
            }
            g.C2010v c2010v = (g.C2010v) nW;
            Path pathF = h.this.new d(c2010v.o).f();
            Matrix matrix = c2010v.n;
            if (matrix != null) {
                pathF.transform(matrix);
            }
            RectF rectF = new RectF();
            pathF.computeBounds(rectF, true);
            this.d.union(rectF);
            return false;
        }

        @Override // com.caverock.androidsvg.h.j
        public void b(String str) {
            if (h.this.Y0()) {
                Rect rect = new Rect();
                h.this.d.d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.b, this.c);
                this.d.union(rectF);
            }
            this.b += h.this.d.d.measureText(str);
        }
    }

    private abstract class j {
        private j() {
        }

        public boolean a(g.Y y) {
            return true;
        }

        public abstract void b(String str);

        /* synthetic */ j(h hVar, a aVar) {
            this();
        }
    }

    h(Canvas canvas, float f2) {
        this.a = canvas;
        this.b = f2;
    }

    private boolean A() {
        Boolean bool = this.d.a.A;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void A0(g.N n) {
        if (n instanceof g.InterfaceC2008t) {
            return;
        }
        S0();
        u(n);
        if (n instanceof g.F) {
            x0((g.F) n);
        } else if (n instanceof g.e0) {
            E0((g.e0) n);
        } else if (n instanceof g.S) {
            B0((g.S) n);
        } else if (n instanceof g.C2001m) {
            q0((g.C2001m) n);
        } else if (n instanceof g.C2003o) {
            r0((g.C2003o) n);
        } else if (n instanceof g.C2010v) {
            t0((g.C2010v) n);
        } else if (n instanceof g.B) {
            w0((g.B) n);
        } else if (n instanceof g.C1993d) {
            o0((g.C1993d) n);
        } else if (n instanceof g.C1997i) {
            p0((g.C1997i) n);
        } else if (n instanceof g.C2005q) {
            s0((g.C2005q) n);
        } else if (n instanceof g.A) {
            v0((g.A) n);
        } else if (n instanceof g.C2014z) {
            u0((g.C2014z) n);
        } else if (n instanceof g.W) {
            D0((g.W) n);
        }
        R0();
    }

    private void B(g.K k2, Path path) {
        g.O o = this.d.a.b;
        if (o instanceof g.C2009u) {
            g.N nW = this.c.w(((g.C2009u) o).a);
            if (nW instanceof g.C2013y) {
                L(k2, path, (g.C2013y) nW);
                return;
            }
        }
        this.a.drawPath(path, this.d.d);
    }

    private void B0(g.S s) {
        y("Switch render", new Object[0]);
        W0(this.d, s);
        if (A()) {
            Matrix matrix = s.o;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            p(s);
            boolean zM0 = m0();
            K0(s);
            if (zM0) {
                j0(s);
            }
            U0(s);
        }
    }

    private void C(Path path) {
        C0155h c0155h = this.d;
        if (c0155h.a.C0 != g.E.i.NonScalingStroke) {
            this.a.drawPath(path, c0155h.e);
            return;
        }
        Matrix matrix = this.a.getMatrix();
        Path path2 = new Path();
        path.transform(matrix, path2);
        this.a.setMatrix(new Matrix());
        Shader shader = this.d.e.getShader();
        Matrix matrix2 = new Matrix();
        if (shader != null) {
            shader.getLocalMatrix(matrix2);
            Matrix matrix3 = new Matrix(matrix2);
            matrix3.postConcat(matrix);
            shader.setLocalMatrix(matrix3);
        }
        this.a.drawPath(path2, this.d.e);
        this.a.setMatrix(matrix);
        if (shader != null) {
            shader.setLocalMatrix(matrix2);
        }
    }

    private void C0(g.T t, g.C1991b c1991b) {
        y("Symbol render", new Object[0]);
        if (c1991b.c == 0.0f || c1991b.d == 0.0f) {
            return;
        }
        com.caverock.androidsvg.e eVar = t.o;
        if (eVar == null) {
            eVar = com.caverock.androidsvg.e.e;
        }
        W0(this.d, t);
        C0155h c0155h = this.d;
        c0155h.f = c1991b;
        if (!c0155h.a.v.booleanValue()) {
            g.C1991b c1991b2 = this.d.f;
            O0(c1991b2.a, c1991b2.b, c1991b2.c, c1991b2.d);
        }
        g.C1991b c1991b3 = t.p;
        if (c1991b3 != null) {
            this.a.concat(o(this.d.f, c1991b3, eVar));
            this.d.g = t.p;
        } else {
            Canvas canvas = this.a;
            g.C1991b c1991b4 = this.d.f;
            canvas.translate(c1991b4.a, c1991b4.b);
        }
        boolean zM0 = m0();
        F0(t, true);
        if (zM0) {
            j0(t);
        }
        U0(t);
    }

    private float D(float f2, float f3, float f4, float f5) {
        return (f2 * f4) + (f3 * f5);
    }

    private void D0(g.W w) {
        y("Text render", new Object[0]);
        W0(this.d, w);
        if (A()) {
            Matrix matrix = w.s;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            List list = w.o;
            float fH = 0.0f;
            float f2 = (list == null || list.size() == 0) ? 0.0f : ((g.C2004p) w.o.get(0)).f(this);
            List list2 = w.p;
            float fH2 = (list2 == null || list2.size() == 0) ? 0.0f : ((g.C2004p) w.p.get(0)).h(this);
            List list3 = w.q;
            float f3 = (list3 == null || list3.size() == 0) ? 0.0f : ((g.C2004p) w.q.get(0)).f(this);
            List list4 = w.r;
            if (list4 != null && list4.size() != 0) {
                fH = ((g.C2004p) w.r.get(0)).h(this);
            }
            g.E.f fVarO = O();
            if (fVarO != g.E.f.Start) {
                float fN = n(w);
                if (fVarO == g.E.f.Middle) {
                    fN /= 2.0f;
                }
                f2 -= fN;
            }
            if (w.h == null) {
                i iVar = new i(f2, fH2);
                E(w, iVar);
                RectF rectF = iVar.d;
                w.h = new g.C1991b(rectF.left, rectF.top, rectF.width(), iVar.d.height());
            }
            U0(w);
            r(w);
            p(w);
            boolean zM0 = m0();
            E(w, new f(f2 + f3, fH2 + fH));
            if (zM0) {
                j0(w);
            }
        }
    }

    private void E(g.Y y, j jVar) {
        if (A()) {
            Iterator it = y.i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                g.N n = (g.N) it.next();
                if (n instanceof g.c0) {
                    jVar.b(T0(((g.c0) n).c, z, !it.hasNext()));
                } else {
                    l0(n, jVar);
                }
                z = false;
            }
        }
    }

    private void E0(g.e0 e0Var) {
        y("Use render", new Object[0]);
        g.C2004p c2004p = e0Var.s;
        if (c2004p == null || !c2004p.k()) {
            g.C2004p c2004p2 = e0Var.t;
            if (c2004p2 == null || !c2004p2.k()) {
                W0(this.d, e0Var);
                if (A()) {
                    g.N nW = e0Var.a.w(e0Var.p);
                    if (nW == null) {
                        F("Use reference '%s' not found", e0Var.p);
                        return;
                    }
                    Matrix matrix = e0Var.o;
                    if (matrix != null) {
                        this.a.concat(matrix);
                    }
                    g.C2004p c2004p3 = e0Var.q;
                    float f2 = c2004p3 != null ? c2004p3.f(this) : 0.0f;
                    g.C2004p c2004p4 = e0Var.r;
                    this.a.translate(f2, c2004p4 != null ? c2004p4.h(this) : 0.0f);
                    p(e0Var);
                    boolean zM0 = m0();
                    i0(e0Var);
                    if (nW instanceof g.F) {
                        g.C1991b c1991bF0 = f0(null, null, e0Var.s, e0Var.t);
                        S0();
                        y0((g.F) nW, c1991bF0);
                        R0();
                    } else if (nW instanceof g.T) {
                        g.C2004p c2004p5 = e0Var.s;
                        if (c2004p5 == null) {
                            c2004p5 = new g.C2004p(100.0f, g.d0.percent);
                        }
                        g.C2004p c2004p6 = e0Var.t;
                        if (c2004p6 == null) {
                            c2004p6 = new g.C2004p(100.0f, g.d0.percent);
                        }
                        g.C1991b c1991bF02 = f0(null, null, c2004p5, c2004p6);
                        S0();
                        C0((g.T) nW, c1991bF02);
                        R0();
                    } else {
                        A0(nW);
                    }
                    h0();
                    if (zM0) {
                        j0(e0Var);
                    }
                    U0(e0Var);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    private void F0(g.J j2, boolean z) {
        if (z) {
            i0(j2);
        }
        Iterator it = j2.d().iterator();
        while (it.hasNext()) {
            A0((g.N) it.next());
        }
        if (z) {
            h0();
        }
    }

    private void G(g.Y y, StringBuilder sb) {
        Iterator it = y.i.iterator();
        boolean z = true;
        while (it.hasNext()) {
            g.N n = (g.N) it.next();
            if (n instanceof g.Y) {
                G((g.Y) n, sb);
            } else if (n instanceof g.c0) {
                sb.append(T0(((g.c0) n).c, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private void H(g.AbstractC1998j abstractC1998j, String str) {
        g.N nW = abstractC1998j.a.w(str);
        if (nW == null) {
            Z0("Gradient reference '%s' not found", str);
            return;
        }
        if (!(nW instanceof g.AbstractC1998j)) {
            F("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (nW == abstractC1998j) {
            F("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        g.AbstractC1998j abstractC1998j2 = (g.AbstractC1998j) nW;
        if (abstractC1998j.i == null) {
            abstractC1998j.i = abstractC1998j2.i;
        }
        if (abstractC1998j.j == null) {
            abstractC1998j.j = abstractC1998j2.j;
        }
        if (abstractC1998j.k == null) {
            abstractC1998j.k = abstractC1998j2.k;
        }
        if (abstractC1998j.h.isEmpty()) {
            abstractC1998j.h = abstractC1998j2.h;
        }
        try {
            if (abstractC1998j instanceof g.M) {
                I((g.M) abstractC1998j, (g.M) nW);
            } else {
                J((g.Q) abstractC1998j, (g.Q) nW);
            }
        } catch (ClassCastException unused) {
        }
        String str2 = abstractC1998j2.l;
        if (str2 != null) {
            H(abstractC1998j, str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0101, code lost:
    
        if (r7 != 8) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void H0(com.caverock.androidsvg.g.C2006r r12, com.caverock.androidsvg.h.c r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.h.H0(com.caverock.androidsvg.g$r, com.caverock.androidsvg.h$c):void");
    }

    private void I(g.M m, g.M m2) {
        if (m.m == null) {
            m.m = m2.m;
        }
        if (m.n == null) {
            m.n = m2.n;
        }
        if (m.o == null) {
            m.o = m2.o;
        }
        if (m.p == null) {
            m.p = m2.p;
        }
    }

    private void I0(g.AbstractC2000l abstractC2000l) {
        g.C2006r c2006r;
        g.C2006r c2006r2;
        g.C2006r c2006r3;
        int size;
        g.E e2 = this.d.a;
        String str = e2.x;
        if (str == null && e2.y == null && e2.z == null) {
            return;
        }
        if (str == null) {
            c2006r = null;
        } else {
            g.N nW = abstractC2000l.a.w(str);
            if (nW != null) {
                c2006r = (g.C2006r) nW;
            } else {
                F("Marker reference '%s' not found", this.d.a.x);
                c2006r = null;
            }
        }
        String str2 = this.d.a.y;
        if (str2 == null) {
            c2006r2 = null;
        } else {
            g.N nW2 = abstractC2000l.a.w(str2);
            if (nW2 != null) {
                c2006r2 = (g.C2006r) nW2;
            } else {
                F("Marker reference '%s' not found", this.d.a.y);
                c2006r2 = null;
            }
        }
        String str3 = this.d.a.z;
        if (str3 == null) {
            c2006r3 = null;
        } else {
            g.N nW3 = abstractC2000l.a.w(str3);
            if (nW3 != null) {
                c2006r3 = (g.C2006r) nW3;
            } else {
                F("Marker reference '%s' not found", this.d.a.z);
                c2006r3 = null;
            }
        }
        List listF = abstractC2000l instanceof g.C2010v ? new b(((g.C2010v) abstractC2000l).o).f() : abstractC2000l instanceof g.C2005q ? k((g.C2005q) abstractC2000l) : l((g.C2014z) abstractC2000l);
        if (listF == null || (size = listF.size()) == 0) {
            return;
        }
        g.E e3 = this.d.a;
        e3.z = null;
        e3.y = null;
        e3.x = null;
        if (c2006r != null) {
            H0(c2006r, (c) listF.get(0));
        }
        if (c2006r2 != null && listF.size() > 2) {
            c cVarN0 = (c) listF.get(0);
            c cVar = (c) listF.get(1);
            int i2 = 1;
            while (i2 < size - 1) {
                i2++;
                c cVar2 = (c) listF.get(i2);
                cVarN0 = cVar.e ? n0(cVarN0, cVar, cVar2) : cVar;
                H0(c2006r2, cVarN0);
                cVar = cVar2;
            }
        }
        if (c2006r3 != null) {
            H0(c2006r3, (c) listF.get(size - 1));
        }
    }

    private void J(g.Q q, g.Q q2) {
        if (q.m == null) {
            q.m = q2.m;
        }
        if (q.n == null) {
            q.n = q2.n;
        }
        if (q.o == null) {
            q.o = q2.o;
        }
        if (q.p == null) {
            q.p = q2.p;
        }
        if (q.q == null) {
            q.q = q2.q;
        }
    }

    private void J0(g.C2007s c2007s, g.K k2, g.C1991b c1991b) {
        float f2;
        float fH;
        y("Mask render", new Object[0]);
        Boolean bool = c2007s.o;
        if (bool == null || !bool.booleanValue()) {
            g.C2004p c2004p = c2007s.s;
            float fE = c2004p != null ? c2004p.e(this, 1.0f) : 1.2f;
            g.C2004p c2004p2 = c2007s.t;
            float fE2 = c2004p2 != null ? c2004p2.e(this, 1.0f) : 1.2f;
            f2 = fE * c1991b.c;
            fH = fE2 * c1991b.d;
        } else {
            g.C2004p c2004p3 = c2007s.s;
            f2 = c2004p3 != null ? c2004p3.f(this) : c1991b.c;
            g.C2004p c2004p4 = c2007s.t;
            fH = c2004p4 != null ? c2004p4.h(this) : c1991b.d;
        }
        if (f2 == 0.0f || fH == 0.0f) {
            return;
        }
        S0();
        C0155h c0155hM = M(c2007s);
        this.d = c0155hM;
        c0155hM.a.m = Float.valueOf(1.0f);
        boolean zM0 = m0();
        this.a.save();
        Boolean bool2 = c2007s.p;
        if (bool2 != null && !bool2.booleanValue()) {
            this.a.translate(c1991b.a, c1991b.b);
            this.a.scale(c1991b.c, c1991b.d);
        }
        F0(c2007s, false);
        this.a.restore();
        if (zM0) {
            k0(k2, c1991b);
        }
        R0();
    }

    private void K(g.C2013y c2013y, String str) {
        g.N nW = c2013y.a.w(str);
        if (nW == null) {
            Z0("Pattern reference '%s' not found", str);
            return;
        }
        if (!(nW instanceof g.C2013y)) {
            F("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (nW == c2013y) {
            F("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        g.C2013y c2013y2 = (g.C2013y) nW;
        if (c2013y.q == null) {
            c2013y.q = c2013y2.q;
        }
        if (c2013y.r == null) {
            c2013y.r = c2013y2.r;
        }
        if (c2013y.s == null) {
            c2013y.s = c2013y2.s;
        }
        if (c2013y.t == null) {
            c2013y.t = c2013y2.t;
        }
        if (c2013y.u == null) {
            c2013y.u = c2013y2.u;
        }
        if (c2013y.v == null) {
            c2013y.v = c2013y2.v;
        }
        if (c2013y.w == null) {
            c2013y.w = c2013y2.w;
        }
        if (c2013y.i.isEmpty()) {
            c2013y.i = c2013y2.i;
        }
        if (c2013y.p == null) {
            c2013y.p = c2013y2.p;
        }
        if (c2013y.o == null) {
            c2013y.o = c2013y2.o;
        }
        String str2 = c2013y2.x;
        if (str2 != null) {
            K(c2013y, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K0(g.S s) {
        Set setA;
        String language = Locale.getDefault().getLanguage();
        com.caverock.androidsvg.g.k();
        for (g.N n : s.d()) {
            if (n instanceof g.G) {
                g.G g2 = (g.G) n;
                if (g2.b() == null && ((setA = g2.a()) == null || (!setA.isEmpty() && setA.contains(language)))) {
                    Set setG = g2.g();
                    if (setG != null) {
                        if (i == null) {
                            V();
                        }
                        if (setG.isEmpty() || !i.containsAll(setG)) {
                        }
                    }
                    Set setM = g2.m();
                    if (setM != null) {
                        setM.isEmpty();
                    } else {
                        Set setN = g2.n();
                        if (setN == null) {
                            A0(n);
                            return;
                        }
                        setN.isEmpty();
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01f6 A[LOOP:3: B:100:0x01f0->B:102:0x01f6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void L(com.caverock.androidsvg.g.K r20, android.graphics.Path r21, com.caverock.androidsvg.g.C2013y r22) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.h.L(com.caverock.androidsvg.g$K, android.graphics.Path, com.caverock.androidsvg.g$y):void");
    }

    private void L0(g.Z z) {
        y("TextPath render", new Object[0]);
        W0(this.d, z);
        if (A() && Y0()) {
            g.N nW = z.a.w(z.o);
            if (nW == null) {
                F("TextPath reference '%s' not found", z.o);
                return;
            }
            g.C2010v c2010v = (g.C2010v) nW;
            Path pathF = new d(c2010v.o).f();
            Matrix matrix = c2010v.n;
            if (matrix != null) {
                pathF.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(pathF, false);
            g.C2004p c2004p = z.p;
            float fE = c2004p != null ? c2004p.e(this, pathMeasure.getLength()) : 0.0f;
            g.E.f fVarO = O();
            if (fVarO != g.E.f.Start) {
                float fN = n(z);
                if (fVarO == g.E.f.Middle) {
                    fN /= 2.0f;
                }
                fE -= fN;
            }
            r((g.K) z.e());
            boolean zM0 = m0();
            E(z, new e(pathF, fE, 0.0f));
            if (zM0) {
                j0(z);
            }
        }
    }

    private C0155h M(g.N n) {
        C0155h c0155h = new C0155h();
        V0(c0155h, g.E.b());
        return N(n, c0155h);
    }

    private boolean M0() {
        return this.d.a.m.floatValue() < 1.0f || this.d.a.Y != null;
    }

    private C0155h N(g.N n, C0155h c0155h) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (n instanceof g.L) {
                arrayList.add(0, (g.L) n);
            }
            Object obj = n.b;
            if (obj == null) {
                break;
            }
            n = (g.N) obj;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            W0(c0155h, (g.L) it.next());
        }
        C0155h c0155h2 = this.d;
        c0155h.g = c0155h2.g;
        c0155h.f = c0155h2.f;
        return c0155h;
    }

    private void N0() {
        this.d = new C0155h();
        this.e = new Stack();
        V0(this.d, g.E.b());
        C0155h c0155h = this.d;
        c0155h.f = null;
        c0155h.h = false;
        this.e.push(new C0155h(c0155h));
        this.g = new Stack();
        this.f = new Stack();
    }

    private g.E.f O() {
        g.E.f fVar;
        g.E e2 = this.d.a;
        if (e2.t == g.E.h.LTR || (fVar = e2.u) == g.E.f.Middle) {
            return e2.u;
        }
        g.E.f fVar2 = g.E.f.Start;
        return fVar == fVar2 ? g.E.f.End : fVar2;
    }

    private void O0(float f2, float f3, float f4, float f5) {
        float f6 = f4 + f2;
        float fH = f5 + f3;
        g.C1992c c1992c = this.d.a.w;
        if (c1992c != null) {
            f2 += c1992c.d.f(this);
            f3 += this.d.a.w.a.h(this);
            f6 -= this.d.a.w.b.f(this);
            fH -= this.d.a.w.c.h(this);
        }
        this.a.clipRect(f2, f3, f6, fH);
    }

    private Path.FillType P() {
        g.E.a aVar = this.d.a.J;
        return (aVar == null || aVar != g.E.a.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    private void P0(C0155h c0155h, boolean z, g.O o) {
        int i2;
        g.E e2 = c0155h.a;
        float fFloatValue = (z ? e2.d : e2.f).floatValue();
        if (o instanceof g.C1995f) {
            i2 = ((g.C1995f) o).a;
        } else if (!(o instanceof g.C0154g)) {
            return;
        } else {
            i2 = c0155h.a.n.a;
        }
        int iX = x(i2, fFloatValue);
        if (z) {
            c0155h.d.setColor(iX);
        } else {
            c0155h.e.setColor(iX);
        }
    }

    private void Q0(boolean z, g.C c2) {
        if (z) {
            if (W(c2.e, 2147483648L)) {
                C0155h c0155h = this.d;
                g.E e2 = c0155h.a;
                g.O o = c2.e.Z;
                e2.b = o;
                c0155h.b = o != null;
            }
            if (W(c2.e, 4294967296L)) {
                this.d.a.d = c2.e.z0;
            }
            if (W(c2.e, 6442450944L)) {
                C0155h c0155h2 = this.d;
                P0(c0155h2, z, c0155h2.a.b);
                return;
            }
            return;
        }
        if (W(c2.e, 2147483648L)) {
            C0155h c0155h3 = this.d;
            g.E e3 = c0155h3.a;
            g.O o2 = c2.e.Z;
            e3.e = o2;
            c0155h3.c = o2 != null;
        }
        if (W(c2.e, 4294967296L)) {
            this.d.a.f = c2.e.z0;
        }
        if (W(c2.e, 6442450944L)) {
            C0155h c0155h4 = this.d;
            P0(c0155h4, z, c0155h4.a.e);
        }
    }

    private void R0() {
        this.a.restore();
        this.d = (C0155h) this.e.pop();
    }

    private void S0() {
        this.a.save();
        this.e.push(this.d);
        this.d = new C0155h(this.d);
    }

    private String T0(String str, boolean z, boolean z2) {
        if (this.d.h) {
            return str.replaceAll("[\\n\\t]", Separators.SP);
        }
        String strReplaceAll = str.replaceAll("\\n", "").replaceAll("\\t", Separators.SP);
        if (z) {
            strReplaceAll = strReplaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            strReplaceAll = strReplaceAll.replaceAll("\\s+$", "");
        }
        return strReplaceAll.replaceAll("\\s{2,}", Separators.SP);
    }

    private Path.FillType U() {
        g.E.a aVar = this.d.a.c;
        return (aVar == null || aVar != g.E.a.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    private void U0(g.K k2) {
        if (k2.b == null || k2.h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (((Matrix) this.g.peek()).invert(matrix)) {
            g.C1991b c1991b = k2.h;
            float f2 = c1991b.a;
            float f3 = c1991b.b;
            float fB = c1991b.b();
            g.C1991b c1991b2 = k2.h;
            float f4 = c1991b2.b;
            float fB2 = c1991b2.b();
            float fC = k2.h.c();
            g.C1991b c1991b3 = k2.h;
            float[] fArr = {f2, f3, fB, f4, fB2, fC, c1991b3.a, c1991b3.c()};
            matrix.preConcat(this.a.getMatrix());
            matrix.mapPoints(fArr);
            float f5 = fArr[0];
            float f6 = fArr[1];
            RectF rectF = new RectF(f5, f6, f5, f6);
            for (int i2 = 2; i2 <= 6; i2 += 2) {
                float f7 = fArr[i2];
                if (f7 < rectF.left) {
                    rectF.left = f7;
                }
                if (f7 > rectF.right) {
                    rectF.right = f7;
                }
                float f8 = fArr[i2 + 1];
                if (f8 < rectF.top) {
                    rectF.top = f8;
                }
                if (f8 > rectF.bottom) {
                    rectF.bottom = f8;
                }
            }
            g.K k3 = (g.K) this.f.peek();
            g.C1991b c1991b4 = k3.h;
            if (c1991b4 == null) {
                k3.h = g.C1991b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                c1991b4.e(g.C1991b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private static synchronized void V() {
        HashSet hashSet = new HashSet();
        i = hashSet;
        hashSet.add("Structure");
        i.add("BasicStructure");
        i.add("ConditionalProcessing");
        i.add("Image");
        i.add("Style");
        i.add("ViewportAttribute");
        i.add("Shape");
        i.add("BasicText");
        i.add("PaintAttribute");
        i.add("BasicPaintAttribute");
        i.add("OpacityAttribute");
        i.add("BasicGraphicsAttribute");
        i.add("Marker");
        i.add("Gradient");
        i.add("Pattern");
        i.add("Clip");
        i.add("BasicClip");
        i.add("Mask");
        i.add("View");
    }

    private void V0(C0155h c0155h, g.E e2) {
        if (W(e2, 4096L)) {
            c0155h.a.n = e2.n;
        }
        if (W(e2, 2048L)) {
            c0155h.a.m = e2.m;
        }
        if (W(e2, 1L)) {
            c0155h.a.b = e2.b;
            g.O o = e2.b;
            c0155h.b = (o == null || o == g.C1995f.c) ? false : true;
        }
        if (W(e2, 4L)) {
            c0155h.a.d = e2.d;
        }
        if (W(e2, 6149L)) {
            P0(c0155h, true, c0155h.a.b);
        }
        if (W(e2, 2L)) {
            c0155h.a.c = e2.c;
        }
        if (W(e2, 8L)) {
            c0155h.a.e = e2.e;
            g.O o2 = e2.e;
            c0155h.c = (o2 == null || o2 == g.C1995f.c) ? false : true;
        }
        if (W(e2, 16L)) {
            c0155h.a.f = e2.f;
        }
        if (W(e2, 6168L)) {
            P0(c0155h, false, c0155h.a.e);
        }
        if (W(e2, 34359738368L)) {
            c0155h.a.C0 = e2.C0;
        }
        if (W(e2, 32L)) {
            g.E e3 = c0155h.a;
            g.C2004p c2004p = e2.g;
            e3.g = c2004p;
            c0155h.e.setStrokeWidth(c2004p.d(this));
        }
        if (W(e2, 64L)) {
            c0155h.a.h = e2.h;
            int i2 = a.b[e2.h.ordinal()];
            if (i2 == 1) {
                c0155h.e.setStrokeCap(Paint.Cap.BUTT);
            } else if (i2 == 2) {
                c0155h.e.setStrokeCap(Paint.Cap.ROUND);
            } else if (i2 == 3) {
                c0155h.e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (W(e2, 128L)) {
            c0155h.a.i = e2.i;
            int i3 = a.c[e2.i.ordinal()];
            if (i3 == 1) {
                c0155h.e.setStrokeJoin(Paint.Join.MITER);
            } else if (i3 == 2) {
                c0155h.e.setStrokeJoin(Paint.Join.ROUND);
            } else if (i3 == 3) {
                c0155h.e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (W(e2, 256L)) {
            c0155h.a.j = e2.j;
            c0155h.e.setStrokeMiter(e2.j.floatValue());
        }
        if (W(e2, 512L)) {
            c0155h.a.k = e2.k;
        }
        if (W(e2, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE)) {
            c0155h.a.l = e2.l;
        }
        Typeface typefaceT = null;
        if (W(e2, 1536L)) {
            g.C2004p[] c2004pArr = c0155h.a.k;
            if (c2004pArr == null) {
                c0155h.e.setPathEffect(null);
            } else {
                int length = c2004pArr.length;
                int i4 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i4];
                float f2 = 0.0f;
                for (int i5 = 0; i5 < i4; i5++) {
                    float fD = c0155h.a.k[i5 % length].d(this);
                    fArr[i5] = fD;
                    f2 += fD;
                }
                if (f2 == 0.0f) {
                    c0155h.e.setPathEffect(null);
                } else {
                    float fD2 = c0155h.a.l.d(this);
                    if (fD2 < 0.0f) {
                        fD2 = (fD2 % f2) + f2;
                    }
                    c0155h.e.setPathEffect(new DashPathEffect(fArr, fD2));
                }
            }
        }
        if (W(e2, Http2Stream.EMIT_BUFFER_SIZE)) {
            float fQ = Q();
            c0155h.a.p = e2.p;
            c0155h.d.setTextSize(e2.p.e(this, fQ));
            c0155h.e.setTextSize(e2.p.e(this, fQ));
        }
        if (W(e2, 8192L)) {
            c0155h.a.o = e2.o;
        }
        if (W(e2, 32768L)) {
            if (e2.q.intValue() == -1 && c0155h.a.q.intValue() > 100) {
                g.E e4 = c0155h.a;
                e4.q = Integer.valueOf(e4.q.intValue() - 100);
            } else if (e2.q.intValue() != 1 || c0155h.a.q.intValue() >= 900) {
                c0155h.a.q = e2.q;
            } else {
                g.E e5 = c0155h.a;
                e5.q = Integer.valueOf(e5.q.intValue() + 100);
            }
        }
        if (W(e2, 65536L)) {
            c0155h.a.r = e2.r;
        }
        if (W(e2, 106496L)) {
            if (c0155h.a.o != null && this.c != null) {
                com.caverock.androidsvg.g.k();
                for (String str : c0155h.a.o) {
                    g.E e6 = c0155h.a;
                    typefaceT = t(str, e6.q, e6.r);
                    if (typefaceT != null) {
                        break;
                    }
                }
            }
            if (typefaceT == null) {
                g.E e7 = c0155h.a;
                typefaceT = t("serif", e7.q, e7.r);
            }
            c0155h.d.setTypeface(typefaceT);
            c0155h.e.setTypeface(typefaceT);
        }
        if (W(e2, 131072L)) {
            c0155h.a.s = e2.s;
            Paint paint = c0155h.d;
            g.E.EnumC0153g enumC0153g = e2.s;
            g.E.EnumC0153g enumC0153g2 = g.E.EnumC0153g.LineThrough;
            paint.setStrikeThruText(enumC0153g == enumC0153g2);
            Paint paint2 = c0155h.d;
            g.E.EnumC0153g enumC0153g3 = e2.s;
            g.E.EnumC0153g enumC0153g4 = g.E.EnumC0153g.Underline;
            paint2.setUnderlineText(enumC0153g3 == enumC0153g4);
            c0155h.e.setStrikeThruText(e2.s == enumC0153g2);
            c0155h.e.setUnderlineText(e2.s == enumC0153g4);
        }
        if (W(e2, 68719476736L)) {
            c0155h.a.t = e2.t;
        }
        if (W(e2, 262144L)) {
            c0155h.a.u = e2.u;
        }
        if (W(e2, 524288L)) {
            c0155h.a.v = e2.v;
        }
        if (W(e2, 2097152L)) {
            c0155h.a.x = e2.x;
        }
        if (W(e2, 4194304L)) {
            c0155h.a.y = e2.y;
        }
        if (W(e2, 8388608L)) {
            c0155h.a.z = e2.z;
        }
        if (W(e2, 16777216L)) {
            c0155h.a.A = e2.A;
        }
        if (W(e2, 33554432L)) {
            c0155h.a.B = e2.B;
        }
        if (W(e2, 1048576L)) {
            c0155h.a.w = e2.w;
        }
        if (W(e2, 268435456L)) {
            c0155h.a.H = e2.H;
        }
        if (W(e2, 536870912L)) {
            c0155h.a.J = e2.J;
        }
        if (W(e2, 1073741824L)) {
            c0155h.a.Y = e2.Y;
        }
        if (W(e2, 67108864L)) {
            c0155h.a.D = e2.D;
        }
        if (W(e2, 134217728L)) {
            c0155h.a.G = e2.G;
        }
        if (W(e2, 8589934592L)) {
            c0155h.a.A0 = e2.A0;
        }
        if (W(e2, 17179869184L)) {
            c0155h.a.B0 = e2.B0;
        }
        if (W(e2, 137438953472L)) {
            c0155h.a.D0 = e2.D0;
        }
    }

    private boolean W(g.E e2, long j2) {
        return (e2.a & j2) != 0;
    }

    private void W0(C0155h c0155h, g.L l) {
        c0155h.a.c(l.b == null);
        g.E e2 = l.e;
        if (e2 != null) {
            V0(c0155h, e2);
        }
        if (this.c.q()) {
            for (b.p pVar : this.c.d()) {
                if (com.caverock.androidsvg.b.l(this.h, pVar.a, l)) {
                    V0(c0155h, pVar.b);
                }
            }
        }
        g.E e3 = l.f;
        if (e3 != null) {
            V0(c0155h, e3);
        }
    }

    private void X(boolean z, g.C1991b c1991b, g.M m) {
        float f2;
        float fE;
        float f3;
        float f4;
        String str = m.l;
        if (str != null) {
            H(m, str);
        }
        Boolean bool = m.i;
        int i2 = 0;
        boolean z2 = bool != null && bool.booleanValue();
        C0155h c0155h = this.d;
        Paint paint = z ? c0155h.d : c0155h.e;
        if (z2) {
            g.C1991b c1991bS = S();
            g.C2004p c2004p = m.m;
            float f5 = c2004p != null ? c2004p.f(this) : 0.0f;
            g.C2004p c2004p2 = m.n;
            float fH = c2004p2 != null ? c2004p2.h(this) : 0.0f;
            g.C2004p c2004p3 = m.o;
            float f6 = c2004p3 != null ? c2004p3.f(this) : c1991bS.c;
            g.C2004p c2004p4 = m.p;
            f4 = f6;
            f2 = f5;
            f3 = fH;
            fE = c2004p4 != null ? c2004p4.h(this) : 0.0f;
        } else {
            g.C2004p c2004p5 = m.m;
            float fE2 = c2004p5 != null ? c2004p5.e(this, 1.0f) : 0.0f;
            g.C2004p c2004p6 = m.n;
            float fE3 = c2004p6 != null ? c2004p6.e(this, 1.0f) : 0.0f;
            g.C2004p c2004p7 = m.o;
            float fE4 = c2004p7 != null ? c2004p7.e(this, 1.0f) : 1.0f;
            g.C2004p c2004p8 = m.p;
            f2 = fE2;
            fE = c2004p8 != null ? c2004p8.e(this, 1.0f) : 0.0f;
            f3 = fE3;
            f4 = fE4;
        }
        S0();
        this.d = M(m);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(c1991b.a, c1991b.b);
            matrix.preScale(c1991b.c, c1991b.d);
        }
        Matrix matrix2 = m.j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = m.h.size();
        if (size == 0) {
            R0();
            if (z) {
                this.d.b = false;
                return;
            } else {
                this.d.c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator it = m.h.iterator();
        float f7 = -1.0f;
        while (it.hasNext()) {
            g.D d2 = (g.D) ((g.N) it.next());
            Float f8 = d2.h;
            float fFloatValue = f8 != null ? f8.floatValue() : 0.0f;
            if (i2 == 0 || fFloatValue >= f7) {
                fArr[i2] = fFloatValue;
                f7 = fFloatValue;
            } else {
                fArr[i2] = f7;
            }
            S0();
            W0(this.d, d2);
            g.E e2 = this.d.a;
            g.C1995f c1995f = (g.C1995f) e2.D;
            if (c1995f == null) {
                c1995f = g.C1995f.b;
            }
            iArr[i2] = x(c1995f.a, e2.G.floatValue());
            i2++;
            R0();
        }
        if ((f2 == f4 && f3 == fE) || size == 1) {
            R0();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        g.EnumC1999k enumC1999k = m.k;
        if (enumC1999k != null) {
            if (enumC1999k == g.EnumC1999k.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (enumC1999k == g.EnumC1999k.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Shader.TileMode tileMode2 = tileMode;
        R0();
        LinearGradient linearGradient = new LinearGradient(f2, f3, f4, fE, iArr, fArr, tileMode2);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(w(this.d.a.d.floatValue()));
    }

    private void X0() {
        int iX;
        g.E e2 = this.d.a;
        g.O o = e2.A0;
        if (o instanceof g.C1995f) {
            iX = ((g.C1995f) o).a;
        } else if (!(o instanceof g.C0154g)) {
            return;
        } else {
            iX = e2.n.a;
        }
        Float f2 = e2.B0;
        if (f2 != null) {
            iX = x(iX, f2.floatValue());
        }
        this.a.drawColor(iX);
    }

    private Path Y(g.C1993d c1993d) {
        g.C2004p c2004p = c1993d.o;
        float f2 = c2004p != null ? c2004p.f(this) : 0.0f;
        g.C2004p c2004p2 = c1993d.p;
        float fH = c2004p2 != null ? c2004p2.h(this) : 0.0f;
        float fD = c1993d.q.d(this);
        float f3 = f2 - fD;
        float f4 = fH - fD;
        float f5 = f2 + fD;
        float f6 = fH + fD;
        if (c1993d.h == null) {
            float f7 = 2.0f * fD;
            c1993d.h = new g.C1991b(f3, f4, f7, f7);
        }
        float f8 = 0.5522848f * fD;
        Path path = new Path();
        path.moveTo(f2, f4);
        float f9 = f2 + f8;
        float f10 = fH - f8;
        path.cubicTo(f9, f4, f5, f10, f5, fH);
        float f11 = fH + f8;
        path.cubicTo(f5, f11, f9, f6, f2, f6);
        float f12 = f2 - f8;
        path.cubicTo(f12, f6, f3, f11, f3, fH);
        path.cubicTo(f3, f10, f12, f4, f2, f4);
        path.close();
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y0() {
        Boolean bool = this.d.a.B;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private Path Z(g.C1997i c1997i) {
        g.C2004p c2004p = c1997i.o;
        float f2 = c2004p != null ? c2004p.f(this) : 0.0f;
        g.C2004p c2004p2 = c1997i.p;
        float fH = c2004p2 != null ? c2004p2.h(this) : 0.0f;
        float f3 = c1997i.q.f(this);
        float fH2 = c1997i.r.h(this);
        float f4 = f2 - f3;
        float f5 = fH - fH2;
        float f6 = f2 + f3;
        float f7 = fH + fH2;
        if (c1997i.h == null) {
            c1997i.h = new g.C1991b(f4, f5, f3 * 2.0f, 2.0f * fH2);
        }
        float f8 = f3 * 0.5522848f;
        float f9 = 0.5522848f * fH2;
        Path path = new Path();
        path.moveTo(f2, f5);
        float f10 = f2 + f8;
        float f11 = fH - f9;
        path.cubicTo(f10, f5, f6, f11, f6, fH);
        float f12 = f9 + fH;
        path.cubicTo(f6, f12, f10, f7, f2, f7);
        float f13 = f2 - f8;
        path.cubicTo(f13, f7, f4, f12, f4, fH);
        path.cubicTo(f4, f11, f13, f5, f2, f5);
        path.close();
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z0(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    private Path a0(g.C2005q c2005q) {
        g.C2004p c2004p = c2005q.o;
        float f2 = c2004p == null ? 0.0f : c2004p.f(this);
        g.C2004p c2004p2 = c2005q.p;
        float fH = c2004p2 == null ? 0.0f : c2004p2.h(this);
        g.C2004p c2004p3 = c2005q.q;
        float f3 = c2004p3 == null ? 0.0f : c2004p3.f(this);
        g.C2004p c2004p4 = c2005q.r;
        float fH2 = c2004p4 != null ? c2004p4.h(this) : 0.0f;
        if (c2005q.h == null) {
            c2005q.h = new g.C1991b(Math.min(f2, f3), Math.min(fH, fH2), Math.abs(f3 - f2), Math.abs(fH2 - fH));
        }
        Path path = new Path();
        path.moveTo(f2, fH);
        path.lineTo(f3, fH2);
        return path;
    }

    private Path b0(g.C2014z c2014z) {
        Path path = new Path();
        float[] fArr = c2014z.o;
        path.moveTo(fArr[0], fArr[1]);
        int i2 = 2;
        while (true) {
            float[] fArr2 = c2014z.o;
            if (i2 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i2], fArr2[i2 + 1]);
            i2 += 2;
        }
        if (c2014z instanceof g.A) {
            path.close();
        }
        if (c2014z.h == null) {
            c2014z.h = m(path);
        }
        return path;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Path c0(com.caverock.androidsvg.g.B r24) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.h.c0(com.caverock.androidsvg.g$B):android.graphics.Path");
    }

    private Path d0(g.W w) {
        List list = w.o;
        float fH = 0.0f;
        float f2 = (list == null || list.size() == 0) ? 0.0f : ((g.C2004p) w.o.get(0)).f(this);
        List list2 = w.p;
        float fH2 = (list2 == null || list2.size() == 0) ? 0.0f : ((g.C2004p) w.p.get(0)).h(this);
        List list3 = w.q;
        float f3 = (list3 == null || list3.size() == 0) ? 0.0f : ((g.C2004p) w.q.get(0)).f(this);
        List list4 = w.r;
        if (list4 != null && list4.size() != 0) {
            fH = ((g.C2004p) w.r.get(0)).h(this);
        }
        if (this.d.a.u != g.E.f.Start) {
            float fN = n(w);
            if (this.d.a.u == g.E.f.Middle) {
                fN /= 2.0f;
            }
            f2 -= fN;
        }
        if (w.h == null) {
            i iVar = new i(f2, fH2);
            E(w, iVar);
            RectF rectF = iVar.d;
            w.h = new g.C1991b(rectF.left, rectF.top, rectF.width(), iVar.d.height());
        }
        Path path = new Path();
        E(w, new g(f2 + f3, fH2 + fH, path));
        return path;
    }

    private void e0(boolean z, g.C1991b c1991b, g.Q q) {
        float f2;
        float fE;
        float f3;
        String str = q.l;
        if (str != null) {
            H(q, str);
        }
        Boolean bool = q.i;
        int i2 = 0;
        boolean z2 = bool != null && bool.booleanValue();
        C0155h c0155h = this.d;
        Paint paint = z ? c0155h.d : c0155h.e;
        if (z2) {
            g.C2004p c2004p = new g.C2004p(50.0f, g.d0.percent);
            g.C2004p c2004p2 = q.m;
            float f4 = c2004p2 != null ? c2004p2.f(this) : c2004p.f(this);
            g.C2004p c2004p3 = q.n;
            float fH = c2004p3 != null ? c2004p3.h(this) : c2004p.h(this);
            g.C2004p c2004p4 = q.o;
            fE = c2004p4 != null ? c2004p4.d(this) : c2004p.d(this);
            f2 = f4;
            f3 = fH;
        } else {
            g.C2004p c2004p5 = q.m;
            float fE2 = c2004p5 != null ? c2004p5.e(this, 1.0f) : 0.5f;
            g.C2004p c2004p6 = q.n;
            float fE3 = c2004p6 != null ? c2004p6.e(this, 1.0f) : 0.5f;
            g.C2004p c2004p7 = q.o;
            f2 = fE2;
            fE = c2004p7 != null ? c2004p7.e(this, 1.0f) : 0.5f;
            f3 = fE3;
        }
        S0();
        this.d = M(q);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(c1991b.a, c1991b.b);
            matrix.preScale(c1991b.c, c1991b.d);
        }
        Matrix matrix2 = q.j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = q.h.size();
        if (size == 0) {
            R0();
            if (z) {
                this.d.b = false;
                return;
            } else {
                this.d.c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator it = q.h.iterator();
        float f5 = -1.0f;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            g.D d2 = (g.D) ((g.N) it.next());
            Float f6 = d2.h;
            float fFloatValue = f6 != null ? f6.floatValue() : 0.0f;
            if (i2 == 0 || fFloatValue >= f5) {
                fArr[i2] = fFloatValue;
                f5 = fFloatValue;
            } else {
                fArr[i2] = f5;
            }
            S0();
            W0(this.d, d2);
            g.E e2 = this.d.a;
            g.C1995f c1995f = (g.C1995f) e2.D;
            if (c1995f == null) {
                c1995f = g.C1995f.b;
            }
            iArr[i2] = x(c1995f.a, e2.G.floatValue());
            i2++;
            R0();
        }
        if (fE == 0.0f || size == 1) {
            R0();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        g.EnumC1999k enumC1999k = q.k;
        if (enumC1999k != null) {
            if (enumC1999k == g.EnumC1999k.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (enumC1999k == g.EnumC1999k.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Shader.TileMode tileMode2 = tileMode;
        R0();
        RadialGradient radialGradient = new RadialGradient(f2, f3, fE, iArr, fArr, tileMode2);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        paint.setAlpha(w(this.d.a.d.floatValue()));
    }

    private g.C1991b f0(g.C2004p c2004p, g.C2004p c2004p2, g.C2004p c2004p3, g.C2004p c2004p4) {
        float f2 = c2004p != null ? c2004p.f(this) : 0.0f;
        float fH = c2004p2 != null ? c2004p2.h(this) : 0.0f;
        g.C1991b c1991bS = S();
        return new g.C1991b(f2, fH, c2004p3 != null ? c2004p3.f(this) : c1991bS.c, c2004p4 != null ? c2004p4.h(this) : c1991bS.d);
    }

    private Path g0(g.K k2, boolean z) {
        Path pathD0;
        Path pathJ;
        this.e.push(this.d);
        C0155h c0155h = new C0155h(this.d);
        this.d = c0155h;
        W0(c0155h, k2);
        if (!A() || !Y0()) {
            this.d = (C0155h) this.e.pop();
            return null;
        }
        if (k2 instanceof g.e0) {
            if (!z) {
                F("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            g.e0 e0Var = (g.e0) k2;
            g.N nW = k2.a.w(e0Var.p);
            if (nW == null) {
                F("Use reference '%s' not found", e0Var.p);
                this.d = (C0155h) this.e.pop();
                return null;
            }
            if (!(nW instanceof g.K)) {
                this.d = (C0155h) this.e.pop();
                return null;
            }
            pathD0 = g0((g.K) nW, false);
            if (pathD0 == null) {
                return null;
            }
            if (e0Var.h == null) {
                e0Var.h = m(pathD0);
            }
            Matrix matrix = e0Var.o;
            if (matrix != null) {
                pathD0.transform(matrix);
            }
        } else if (k2 instanceof g.AbstractC2000l) {
            g.AbstractC2000l abstractC2000l = (g.AbstractC2000l) k2;
            if (k2 instanceof g.C2010v) {
                pathD0 = new d(((g.C2010v) k2).o).f();
                if (k2.h == null) {
                    k2.h = m(pathD0);
                }
            } else {
                pathD0 = k2 instanceof g.B ? c0((g.B) k2) : k2 instanceof g.C1993d ? Y((g.C1993d) k2) : k2 instanceof g.C1997i ? Z((g.C1997i) k2) : k2 instanceof g.C2014z ? b0((g.C2014z) k2) : null;
            }
            if (pathD0 == null) {
                return null;
            }
            if (abstractC2000l.h == null) {
                abstractC2000l.h = m(pathD0);
            }
            Matrix matrix2 = abstractC2000l.n;
            if (matrix2 != null) {
                pathD0.transform(matrix2);
            }
            pathD0.setFillType(P());
        } else {
            if (!(k2 instanceof g.W)) {
                F("Invalid %s element found in clipPath definition", k2.o());
                return null;
            }
            g.W w = (g.W) k2;
            pathD0 = d0(w);
            if (pathD0 == null) {
                return null;
            }
            Matrix matrix3 = w.s;
            if (matrix3 != null) {
                pathD0.transform(matrix3);
            }
            pathD0.setFillType(P());
        }
        if (this.d.a.H != null && (pathJ = j(k2, k2.h)) != null) {
            pathD0.op(pathJ, Path.Op.INTERSECT);
        }
        this.d = (C0155h) this.e.pop();
        return pathD0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, g.InterfaceC2012x interfaceC2012x) {
        float f9;
        g.InterfaceC2012x interfaceC2012x2;
        if (f2 == f7 && f3 == f8) {
            return;
        }
        if (f4 == 0.0f) {
            f9 = f7;
            interfaceC2012x2 = interfaceC2012x;
        } else {
            if (f5 != 0.0f) {
                float fAbs = Math.abs(f4);
                float fAbs2 = Math.abs(f5);
                double radians = Math.toRadians(f6 % 360.0d);
                double dCos = Math.cos(radians);
                double dSin = Math.sin(radians);
                double d2 = (f2 - f7) / 2.0d;
                double d3 = (f3 - f8) / 2.0d;
                double d4 = (dCos * d2) + (dSin * d3);
                double d5 = ((-dSin) * d2) + (d3 * dCos);
                double d6 = fAbs * fAbs;
                double d7 = fAbs2 * fAbs2;
                double d8 = d4 * d4;
                double d9 = d5 * d5;
                double d10 = (d8 / d6) + (d9 / d7);
                if (d10 > 0.99999d) {
                    double dSqrt = Math.sqrt(d10) * 1.00001d;
                    fAbs = (float) (fAbs * dSqrt);
                    fAbs2 = (float) (dSqrt * fAbs2);
                    d6 = fAbs * fAbs;
                    d7 = fAbs2 * fAbs2;
                }
                double d11 = z == z2 ? -1.0d : 1.0d;
                double d12 = d6 * d7;
                double d13 = d6 * d9;
                double d14 = d7 * d8;
                double d15 = ((d12 - d13) - d14) / (d13 + d14);
                if (d15 < 0.0d) {
                    d15 = 0.0d;
                }
                double dSqrt2 = d11 * Math.sqrt(d15);
                double d16 = fAbs;
                double d17 = fAbs2;
                double d18 = ((d16 * d5) / d17) * dSqrt2;
                float f10 = fAbs;
                float f11 = fAbs2;
                double d19 = dSqrt2 * (-((d17 * d4) / d16));
                double d20 = ((f2 + f7) / 2.0d) + ((dCos * d18) - (dSin * d19));
                double d21 = ((f3 + f8) / 2.0d) + (dSin * d18) + (dCos * d19);
                double d22 = (d4 - d18) / d16;
                double d23 = (d5 - d19) / d17;
                double d24 = ((-d4) - d18) / d16;
                double d25 = ((-d5) - d19) / d17;
                double d26 = (d22 * d22) + (d23 * d23);
                double dAcos = (d23 < 0.0d ? -1.0d : 1.0d) * Math.acos(d22 / Math.sqrt(d26));
                double dV = ((d22 * d25) - (d23 * d24) < 0.0d ? -1.0d : 1.0d) * v(((d22 * d24) + (d23 * d25)) / Math.sqrt(d26 * ((d24 * d24) + (d25 * d25))));
                if (!z2 && dV > 0.0d) {
                    dV -= 6.283185307179586d;
                } else if (z2 && dV < 0.0d) {
                    dV += 6.283185307179586d;
                }
                float[] fArrI = i(dAcos % 6.283185307179586d, dV % 6.283185307179586d);
                Matrix matrix = new Matrix();
                matrix.postScale(f10, f11);
                matrix.postRotate(f6);
                matrix.postTranslate((float) d20, (float) d21);
                matrix.mapPoints(fArrI);
                fArrI[fArrI.length - 2] = f7;
                fArrI[fArrI.length - 1] = f8;
                for (int i2 = 0; i2 < fArrI.length; i2 += 6) {
                    interfaceC2012x.b(fArrI[i2], fArrI[i2 + 1], fArrI[i2 + 2], fArrI[i2 + 3], fArrI[i2 + 4], fArrI[i2 + 5]);
                }
                return;
            }
            interfaceC2012x2 = interfaceC2012x;
            f9 = f7;
        }
        interfaceC2012x2.c(f9, f8);
    }

    private void h0() {
        this.f.pop();
        this.g.pop();
    }

    private static float[] i(double d2, double d3) {
        int iCeil = (int) Math.ceil((Math.abs(d3) * 2.0d) / 3.141592653589793d);
        double d4 = d3 / iCeil;
        double d5 = d4 / 2.0d;
        double dSin = (Math.sin(d5) * 1.3333333333333333d) / (Math.cos(d5) + 1.0d);
        float[] fArr = new float[iCeil * 6];
        int i2 = 0;
        int i3 = 0;
        while (i2 < iCeil) {
            double d6 = d2 + (i2 * d4);
            double dCos = Math.cos(d6);
            double dSin2 = Math.sin(d6);
            double d7 = d4;
            fArr[i3] = (float) (dCos - (dSin * dSin2));
            fArr[i3 + 1] = (float) (dSin2 + (dCos * dSin));
            double d8 = d6 + d7;
            double dCos2 = Math.cos(d8);
            double dSin3 = Math.sin(d8);
            fArr[i3 + 2] = (float) ((dSin * dSin3) + dCos2);
            fArr[i3 + 3] = (float) (dSin3 - (dSin * dCos2));
            int i4 = i3 + 5;
            fArr[i3 + 4] = (float) dCos2;
            i3 += 6;
            fArr[i4] = (float) dSin3;
            i2++;
            d4 = d7;
        }
        return fArr;
    }

    private void i0(g.J j2) {
        this.f.push(j2);
        this.g.push(this.a.getMatrix());
    }

    private Path j(g.K k2, g.C1991b c1991b) {
        Path pathG0;
        g.N nW = k2.a.w(this.d.a.H);
        if (nW == null) {
            F("ClipPath reference '%s' not found", this.d.a.H);
            return null;
        }
        g.C1994e c1994e = (g.C1994e) nW;
        this.e.push(this.d);
        this.d = M(c1994e);
        Boolean bool = c1994e.p;
        boolean z = bool == null || bool.booleanValue();
        Matrix matrix = new Matrix();
        if (!z) {
            matrix.preTranslate(c1991b.a, c1991b.b);
            matrix.preScale(c1991b.c, c1991b.d);
        }
        Matrix matrix2 = c1994e.o;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (g.N n : c1994e.i) {
            if ((n instanceof g.K) && (pathG0 = g0((g.K) n, true)) != null) {
                path.op(pathG0, Path.Op.UNION);
            }
        }
        if (this.d.a.H != null) {
            if (c1994e.h == null) {
                c1994e.h = m(path);
            }
            Path pathJ = j(c1994e, c1994e.h);
            if (pathJ != null) {
                path.op(pathJ, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.d = (C0155h) this.e.pop();
        return path;
    }

    private void j0(g.K k2) {
        k0(k2, k2.h);
    }

    private List k(g.C2005q c2005q) {
        g.C2004p c2004p = c2005q.o;
        float f2 = c2004p != null ? c2004p.f(this) : 0.0f;
        g.C2004p c2004p2 = c2005q.p;
        float fH = c2004p2 != null ? c2004p2.h(this) : 0.0f;
        g.C2004p c2004p3 = c2005q.q;
        float f3 = c2004p3 != null ? c2004p3.f(this) : 0.0f;
        g.C2004p c2004p4 = c2005q.r;
        float fH2 = c2004p4 != null ? c2004p4.h(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f4 = f3 - f2;
        float f5 = fH2 - fH;
        arrayList.add(new c(f2, fH, f4, f5));
        arrayList.add(new c(f3, fH2, f4, f5));
        return arrayList;
    }

    private void k0(g.K k2, g.C1991b c1991b) {
        if (this.d.a.Y != null) {
            Paint paint = new Paint();
            PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
            paint.setXfermode(new PorterDuffXfermode(mode));
            this.a.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.a.saveLayer(null, paint2, 31);
            g.C2007s c2007s = (g.C2007s) this.c.w(this.d.a.Y);
            J0(c2007s, k2, c1991b);
            this.a.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(mode));
            this.a.saveLayer(null, paint3, 31);
            J0(c2007s, k2, c1991b);
            this.a.restore();
            this.a.restore();
        }
        R0();
    }

    private List l(g.C2014z c2014z) {
        int length = c2014z.o.length;
        int i2 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = c2014z.o;
        c cVar = new c(fArr[0], fArr[1], 0.0f, 0.0f);
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < length) {
            float[] fArr2 = c2014z.o;
            float f4 = fArr2[i2];
            float f5 = fArr2[i2 + 1];
            cVar.a(f4, f5);
            arrayList.add(cVar);
            i2 += 2;
            cVar = new c(f4, f5, f4 - cVar.a, f5 - cVar.b);
            f3 = f5;
            f2 = f4;
        }
        if (c2014z instanceof g.A) {
            float[] fArr3 = c2014z.o;
            float f6 = fArr3[0];
            if (f2 != f6) {
                float f7 = fArr3[1];
                if (f3 != f7) {
                    cVar.a(f6, f7);
                    arrayList.add(cVar);
                    c cVar2 = new c(f6, f7, f6 - cVar.a, f7 - cVar.b);
                    cVar2.b((c) arrayList.get(0));
                    arrayList.add(cVar2);
                    arrayList.set(0, cVar2);
                }
            }
        } else {
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private void l0(g.N n, j jVar) {
        float f2;
        float fH;
        float f3;
        g.E.f fVarO;
        if (jVar.a((g.Y) n)) {
            if (n instanceof g.Z) {
                S0();
                L0((g.Z) n);
                R0();
                return;
            }
            if (!(n instanceof g.V)) {
                if (n instanceof g.U) {
                    S0();
                    g.U u = (g.U) n;
                    W0(this.d, u);
                    if (A()) {
                        r((g.K) u.e());
                        g.N nW = n.a.w(u.o);
                        if (nW == null || !(nW instanceof g.Y)) {
                            F("Tref reference '%s' not found", u.o);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            G((g.Y) nW, sb);
                            if (sb.length() > 0) {
                                jVar.b(sb.toString());
                            }
                        }
                    }
                    R0();
                    return;
                }
                return;
            }
            y("TSpan render", new Object[0]);
            S0();
            g.V v = (g.V) n;
            W0(this.d, v);
            if (A()) {
                List list = v.o;
                boolean z = list != null && list.size() > 0;
                boolean z2 = jVar instanceof f;
                float fH2 = 0.0f;
                if (z2) {
                    float f4 = !z ? ((f) jVar).b : ((g.C2004p) v.o.get(0)).f(this);
                    List list2 = v.p;
                    fH = (list2 == null || list2.size() == 0) ? ((f) jVar).c : ((g.C2004p) v.p.get(0)).h(this);
                    List list3 = v.q;
                    f3 = (list3 == null || list3.size() == 0) ? 0.0f : ((g.C2004p) v.q.get(0)).f(this);
                    List list4 = v.r;
                    if (list4 != null && list4.size() != 0) {
                        fH2 = ((g.C2004p) v.r.get(0)).h(this);
                    }
                    f2 = fH2;
                    fH2 = f4;
                } else {
                    f2 = 0.0f;
                    fH = 0.0f;
                    f3 = 0.0f;
                }
                if (z && (fVarO = O()) != g.E.f.Start) {
                    float fN = n(v);
                    if (fVarO == g.E.f.Middle) {
                        fN /= 2.0f;
                    }
                    fH2 -= fN;
                }
                r((g.K) v.e());
                if (z2) {
                    f fVar = (f) jVar;
                    fVar.b = fH2 + f3;
                    fVar.c = fH + f2;
                }
                boolean zM0 = m0();
                E(v, jVar);
                if (zM0) {
                    j0(v);
                }
            }
            R0();
        }
    }

    private g.C1991b m(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new g.C1991b(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private boolean m0() {
        g.N nW;
        if (!M0()) {
            return false;
        }
        this.a.saveLayerAlpha(null, w(this.d.a.m.floatValue()), 31);
        this.e.push(this.d);
        C0155h c0155h = new C0155h(this.d);
        this.d = c0155h;
        String str = c0155h.a.Y;
        if (str != null && ((nW = this.c.w(str)) == null || !(nW instanceof g.C2007s))) {
            F("Mask reference '%s' not found", this.d.a.Y);
            this.d.a.Y = null;
        }
        return true;
    }

    private float n(g.Y y) {
        k kVar = new k(this, null);
        E(y, kVar);
        return kVar.b;
    }

    private c n0(c cVar, c cVar2, c cVar3) {
        float fD = D(cVar2.c, cVar2.d, cVar2.a - cVar.a, cVar2.b - cVar.b);
        if (fD == 0.0f) {
            fD = D(cVar2.c, cVar2.d, cVar3.a - cVar2.a, cVar3.b - cVar2.b);
        }
        if (fD > 0.0f) {
            return cVar2;
        }
        if (fD == 0.0f && (cVar2.c > 0.0f || cVar2.d >= 0.0f)) {
            return cVar2;
        }
        cVar2.c = -cVar2.c;
        cVar2.d = -cVar2.d;
        return cVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        if (r12 != 8) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Matrix o(com.caverock.androidsvg.g.C1991b r10, com.caverock.androidsvg.g.C1991b r11, com.caverock.androidsvg.e r12) {
        /*
            r9 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r12 == 0) goto L9d
            com.caverock.androidsvg.e$a r1 = r12.a()
            if (r1 != 0) goto Lf
            goto L9d
        Lf:
            float r1 = r10.c
            float r2 = r11.c
            float r1 = r1 / r2
            float r2 = r10.d
            float r3 = r11.d
            float r2 = r2 / r3
            float r3 = r11.a
            float r3 = -r3
            float r4 = r11.b
            float r4 = -r4
            com.caverock.androidsvg.e r5 = com.caverock.androidsvg.e.d
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L35
            float r11 = r10.a
            float r10 = r10.b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r2)
            r0.preTranslate(r3, r4)
            return r0
        L35:
            com.caverock.androidsvg.e$b r5 = r12.b()
            com.caverock.androidsvg.e$b r6 = com.caverock.androidsvg.e.b.slice
            if (r5 != r6) goto L42
            float r1 = java.lang.Math.max(r1, r2)
            goto L46
        L42:
            float r1 = java.lang.Math.min(r1, r2)
        L46:
            float r2 = r10.c
            float r2 = r2 / r1
            float r5 = r10.d
            float r5 = r5 / r1
            int[] r6 = com.caverock.androidsvg.h.a.a
            com.caverock.androidsvg.e$a r7 = r12.a()
            int r7 = r7.ordinal()
            r7 = r6[r7]
            r8 = 1073741824(0x40000000, float:2.0)
            switch(r7) {
                case 1: goto L63;
                case 2: goto L63;
                case 3: goto L63;
                case 4: goto L5e;
                case 5: goto L5e;
                case 6: goto L5e;
                default: goto L5d;
            }
        L5d:
            goto L68
        L5e:
            float r7 = r11.c
            float r7 = r7 - r2
        L61:
            float r3 = r3 - r7
            goto L68
        L63:
            float r7 = r11.c
            float r7 = r7 - r2
            float r7 = r7 / r8
            goto L61
        L68:
            com.caverock.androidsvg.e$a r12 = r12.a()
            int r12 = r12.ordinal()
            r12 = r6[r12]
            r2 = 2
            if (r12 == r2) goto L8b
            r2 = 3
            if (r12 == r2) goto L86
            r2 = 5
            if (r12 == r2) goto L8b
            r2 = 6
            if (r12 == r2) goto L86
            r2 = 7
            if (r12 == r2) goto L8b
            r2 = 8
            if (r12 == r2) goto L86
            goto L90
        L86:
            float r11 = r11.d
            float r11 = r11 - r5
        L89:
            float r4 = r4 - r11
            goto L90
        L8b:
            float r11 = r11.d
            float r11 = r11 - r5
            float r11 = r11 / r8
            goto L89
        L90:
            float r11 = r10.a
            float r10 = r10.b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r1)
            r0.preTranslate(r3, r4)
        L9d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.h.o(com.caverock.androidsvg.g$b, com.caverock.androidsvg.g$b, com.caverock.androidsvg.e):android.graphics.Matrix");
    }

    private void o0(g.C1993d c1993d) {
        y("Circle render", new Object[0]);
        g.C2004p c2004p = c1993d.q;
        if (c2004p == null || c2004p.k()) {
            return;
        }
        W0(this.d, c1993d);
        if (A() && Y0()) {
            Matrix matrix = c1993d.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path pathY = Y(c1993d);
            U0(c1993d);
            r(c1993d);
            p(c1993d);
            boolean zM0 = m0();
            if (this.d.b) {
                B(c1993d, pathY);
            }
            if (this.d.c) {
                C(pathY);
            }
            if (zM0) {
                j0(c1993d);
            }
        }
    }

    private void p(g.K k2) {
        q(k2, k2.h);
    }

    private void p0(g.C1997i c1997i) {
        y("Ellipse render", new Object[0]);
        g.C2004p c2004p = c1997i.q;
        if (c2004p == null || c1997i.r == null || c2004p.k() || c1997i.r.k()) {
            return;
        }
        W0(this.d, c1997i);
        if (A() && Y0()) {
            Matrix matrix = c1997i.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path pathZ = Z(c1997i);
            U0(c1997i);
            r(c1997i);
            p(c1997i);
            boolean zM0 = m0();
            if (this.d.b) {
                B(c1997i, pathZ);
            }
            if (this.d.c) {
                C(pathZ);
            }
            if (zM0) {
                j0(c1997i);
            }
        }
    }

    private void q(g.K k2, g.C1991b c1991b) {
        Path pathJ;
        if (this.d.a.H == null || (pathJ = j(k2, c1991b)) == null) {
            return;
        }
        this.a.clipPath(pathJ);
    }

    private void q0(g.C2001m c2001m) {
        y("Group render", new Object[0]);
        W0(this.d, c2001m);
        if (A()) {
            Matrix matrix = c2001m.o;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            p(c2001m);
            boolean zM0 = m0();
            F0(c2001m, true);
            if (zM0) {
                j0(c2001m);
            }
            U0(c2001m);
        }
    }

    private void r(g.K k2) {
        g.O o = this.d.a.b;
        if (o instanceof g.C2009u) {
            z(true, k2.h, (g.C2009u) o);
        }
        g.O o2 = this.d.a.e;
        if (o2 instanceof g.C2009u) {
            z(false, k2.h, (g.C2009u) o2);
        }
    }

    private void r0(g.C2003o c2003o) {
        g.C2004p c2004p;
        String str;
        y("Image render", new Object[0]);
        g.C2004p c2004p2 = c2003o.s;
        if (c2004p2 == null || c2004p2.k() || (c2004p = c2003o.t) == null || c2004p.k() || (str = c2003o.p) == null) {
            return;
        }
        com.caverock.androidsvg.e eVar = c2003o.o;
        if (eVar == null) {
            eVar = com.caverock.androidsvg.e.e;
        }
        Bitmap bitmapS = s(str);
        if (bitmapS == null) {
            com.caverock.androidsvg.g.k();
            return;
        }
        g.C1991b c1991b = new g.C1991b(0.0f, 0.0f, bitmapS.getWidth(), bitmapS.getHeight());
        W0(this.d, c2003o);
        if (A() && Y0()) {
            Matrix matrix = c2003o.u;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            g.C2004p c2004p3 = c2003o.q;
            float f2 = c2004p3 != null ? c2004p3.f(this) : 0.0f;
            g.C2004p c2004p4 = c2003o.r;
            this.d.f = new g.C1991b(f2, c2004p4 != null ? c2004p4.h(this) : 0.0f, c2003o.s.f(this), c2003o.t.f(this));
            if (!this.d.a.v.booleanValue()) {
                g.C1991b c1991b2 = this.d.f;
                O0(c1991b2.a, c1991b2.b, c1991b2.c, c1991b2.d);
            }
            c2003o.h = this.d.f;
            U0(c2003o);
            p(c2003o);
            boolean zM0 = m0();
            X0();
            this.a.save();
            this.a.concat(o(this.d.f, c1991b, eVar));
            this.a.drawBitmap(bitmapS, 0.0f, 0.0f, new Paint(this.d.a.D0 != g.E.e.optimizeSpeed ? 2 : 0));
            this.a.restore();
            if (zM0) {
                j0(c2003o);
            }
        }
    }

    private Bitmap s(String str) {
        int iIndexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (iIndexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(iIndexOf - 7, iIndexOf))) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str.substring(iIndexOf + 1), 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e2) {
            Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", e2);
            return null;
        }
    }

    private void s0(g.C2005q c2005q) {
        y("Line render", new Object[0]);
        W0(this.d, c2005q);
        if (A() && Y0() && this.d.c) {
            Matrix matrix = c2005q.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path pathA0 = a0(c2005q);
            U0(c2005q);
            r(c2005q);
            p(c2005q);
            boolean zM0 = m0();
            C(pathA0);
            I0(c2005q);
            if (zM0) {
                j0(c2005q);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Typeface t(java.lang.String r6, java.lang.Integer r7, com.caverock.androidsvg.g.E.b r8) {
        /*
            r5 = this;
            com.caverock.androidsvg.g$E$b r0 = com.caverock.androidsvg.g.E.b.Italic
            r1 = 0
            r2 = 1
            if (r8 != r0) goto L8
            r8 = r2
            goto L9
        L8:
            r8 = r1
        L9:
            int r7 = r7.intValue()
            r0 = 500(0x1f4, float:7.0E-43)
            r3 = 2
            r4 = 3
            if (r7 <= r0) goto L19
            if (r8 == 0) goto L17
            r7 = r4
            goto L1e
        L17:
            r7 = r2
            goto L1e
        L19:
            if (r8 == 0) goto L1d
            r7 = r3
            goto L1e
        L1d:
            r7 = r1
        L1e:
            r6.hashCode()
            int r8 = r6.hashCode()
            r0 = -1
            switch(r8) {
                case -1536685117: goto L57;
                case -1431958525: goto L4c;
                case -1081737434: goto L41;
                case 109326717: goto L36;
                case 1126973893: goto L2b;
                default: goto L29;
            }
        L29:
            r1 = r0
            goto L60
        L2b:
            java.lang.String r8 = "cursive"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L34
            goto L29
        L34:
            r1 = 4
            goto L60
        L36:
            java.lang.String r8 = "serif"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L3f
            goto L29
        L3f:
            r1 = r4
            goto L60
        L41:
            java.lang.String r8 = "fantasy"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L4a
            goto L29
        L4a:
            r1 = r3
            goto L60
        L4c:
            java.lang.String r8 = "monospace"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L55
            goto L29
        L55:
            r1 = r2
            goto L60
        L57:
            java.lang.String r8 = "sans-serif"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L60
            goto L29
        L60:
            switch(r1) {
                case 0: goto L81;
                case 1: goto L7a;
                case 2: goto L73;
                case 3: goto L6c;
                case 4: goto L65;
                default: goto L63;
            }
        L63:
            r6 = 0
            goto L87
        L65:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L87
        L6c:
            android.graphics.Typeface r6 = android.graphics.Typeface.SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L87
        L73:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L87
        L7a:
            android.graphics.Typeface r6 = android.graphics.Typeface.MONOSPACE
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L87
        L81:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
        L87:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.h.t(java.lang.String, java.lang.Integer, com.caverock.androidsvg.g$E$b):android.graphics.Typeface");
    }

    private void t0(g.C2010v c2010v) {
        y("Path render", new Object[0]);
        if (c2010v.o == null) {
            return;
        }
        W0(this.d, c2010v);
        if (A() && Y0()) {
            C0155h c0155h = this.d;
            if (c0155h.c || c0155h.b) {
                Matrix matrix = c2010v.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path pathF = new d(c2010v.o).f();
                if (c2010v.h == null) {
                    c2010v.h = m(pathF);
                }
                U0(c2010v);
                r(c2010v);
                p(c2010v);
                boolean zM0 = m0();
                if (this.d.b) {
                    pathF.setFillType(U());
                    B(c2010v, pathF);
                }
                if (this.d.c) {
                    C(pathF);
                }
                I0(c2010v);
                if (zM0) {
                    j0(c2010v);
                }
            }
        }
    }

    private void u(g.N n) {
        Boolean bool;
        if ((n instanceof g.L) && (bool = ((g.L) n).d) != null) {
            this.d.h = bool.booleanValue();
        }
    }

    private void u0(g.C2014z c2014z) {
        y("PolyLine render", new Object[0]);
        W0(this.d, c2014z);
        if (A() && Y0()) {
            C0155h c0155h = this.d;
            if (c0155h.c || c0155h.b) {
                Matrix matrix = c2014z.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                if (c2014z.o.length < 2) {
                    return;
                }
                Path pathB0 = b0(c2014z);
                U0(c2014z);
                pathB0.setFillType(U());
                r(c2014z);
                p(c2014z);
                boolean zM0 = m0();
                if (this.d.b) {
                    B(c2014z, pathB0);
                }
                if (this.d.c) {
                    C(pathB0);
                }
                I0(c2014z);
                if (zM0) {
                    j0(c2014z);
                }
            }
        }
    }

    private static double v(double d2) {
        if (d2 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d2 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d2);
    }

    private void v0(g.A a2) {
        y("Polygon render", new Object[0]);
        W0(this.d, a2);
        if (A() && Y0()) {
            C0155h c0155h = this.d;
            if (c0155h.c || c0155h.b) {
                Matrix matrix = a2.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                if (a2.o.length < 2) {
                    return;
                }
                Path pathB0 = b0(a2);
                U0(a2);
                r(a2);
                p(a2);
                boolean zM0 = m0();
                if (this.d.b) {
                    B(a2, pathB0);
                }
                if (this.d.c) {
                    C(pathB0);
                }
                I0(a2);
                if (zM0) {
                    j0(a2);
                }
            }
        }
    }

    private static int w(float f2) {
        int i2 = (int) (f2 * 256.0f);
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    private void w0(g.B b2) {
        y("Rect render", new Object[0]);
        g.C2004p c2004p = b2.q;
        if (c2004p == null || b2.r == null || c2004p.k() || b2.r.k()) {
            return;
        }
        W0(this.d, b2);
        if (A() && Y0()) {
            Matrix matrix = b2.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path pathC0 = c0(b2);
            U0(b2);
            r(b2);
            p(b2);
            boolean zM0 = m0();
            if (this.d.b) {
                B(b2, pathC0);
            }
            if (this.d.c) {
                C(pathC0);
            }
            if (zM0) {
                j0(b2);
            }
        }
    }

    private static int x(int i2, float f2) {
        int i3 = 255;
        int iRound = Math.round(((i2 >> 24) & 255) * f2);
        if (iRound < 0) {
            i3 = 0;
        } else if (iRound <= 255) {
            i3 = iRound;
        }
        return (i2 & 16777215) | (i3 << 24);
    }

    private void x0(g.F f2) {
        z0(f2, f0(f2.q, f2.r, f2.s, f2.t), f2.p, f2.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(String str, Object... objArr) {
    }

    private void y0(g.F f2, g.C1991b c1991b) {
        z0(f2, c1991b, f2.p, f2.o);
    }

    private void z(boolean z, g.C1991b c1991b, g.C2009u c2009u) {
        g.N nW = this.c.w(c2009u.a);
        if (nW == null) {
            F("%s reference '%s' not found", z ? "Fill" : "Stroke", c2009u.a);
            g.O o = c2009u.b;
            if (o != null) {
                P0(this.d, z, o);
                return;
            } else if (z) {
                this.d.b = false;
                return;
            } else {
                this.d.c = false;
                return;
            }
        }
        if (nW instanceof g.M) {
            X(z, c1991b, (g.M) nW);
        } else if (nW instanceof g.Q) {
            e0(z, c1991b, (g.Q) nW);
        } else if (nW instanceof g.C) {
            Q0(z, (g.C) nW);
        }
    }

    private void z0(g.F f2, g.C1991b c1991b, g.C1991b c1991b2, com.caverock.androidsvg.e eVar) {
        y("Svg render", new Object[0]);
        if (c1991b.c == 0.0f || c1991b.d == 0.0f) {
            return;
        }
        if (eVar == null && (eVar = f2.o) == null) {
            eVar = com.caverock.androidsvg.e.e;
        }
        W0(this.d, f2);
        if (A()) {
            C0155h c0155h = this.d;
            c0155h.f = c1991b;
            if (!c0155h.a.v.booleanValue()) {
                g.C1991b c1991b3 = this.d.f;
                O0(c1991b3.a, c1991b3.b, c1991b3.c, c1991b3.d);
            }
            q(f2, this.d.f);
            if (c1991b2 != null) {
                this.a.concat(o(this.d.f, c1991b2, eVar));
                this.d.g = f2.p;
            } else {
                Canvas canvas = this.a;
                g.C1991b c1991b4 = this.d.f;
                canvas.translate(c1991b4.a, c1991b4.b);
            }
            boolean zM0 = m0();
            X0();
            F0(f2, true);
            if (zM0) {
                j0(f2);
            }
            U0(f2);
        }
    }

    void G0(com.caverock.androidsvg.g gVar, com.caverock.androidsvg.f fVar) {
        g.C1991b c1991b;
        com.caverock.androidsvg.e eVar;
        if (fVar == null) {
            throw new NullPointerException("renderOptions shouldn't be null");
        }
        this.c = gVar;
        g.F fP = gVar.p();
        if (fP == null) {
            Z0("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (fVar.e()) {
            g.L lJ = this.c.j(fVar.e);
            if (lJ == null || !(lJ instanceof g.f0)) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", fVar.e));
                return;
            }
            g.f0 f0Var = (g.f0) lJ;
            c1991b = f0Var.p;
            if (c1991b == null) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", fVar.e));
                return;
            }
            eVar = f0Var.o;
        } else {
            c1991b = fVar.f() ? fVar.d : fP.p;
            eVar = fVar.c() ? fVar.b : fP.o;
        }
        if (fVar.b()) {
            gVar.a(fVar.a);
        }
        if (fVar.d()) {
            b.q qVar = new b.q();
            this.h = qVar;
            qVar.a = gVar.j(fVar.c);
        }
        N0();
        u(fP);
        S0();
        g.C1991b c1991b2 = new g.C1991b(fVar.f);
        g.C2004p c2004p = fP.s;
        if (c2004p != null) {
            c1991b2.c = c2004p.e(this, c1991b2.c);
        }
        g.C2004p c2004p2 = fP.t;
        if (c2004p2 != null) {
            c1991b2.d = c2004p2.e(this, c1991b2.d);
        }
        z0(fP, c1991b2, c1991b, eVar);
        R0();
        if (fVar.b()) {
            gVar.b();
        }
    }

    float Q() {
        return this.d.d.getTextSize();
    }

    float R() {
        return this.d.d.getTextSize() / 2.0f;
    }

    g.C1991b S() {
        C0155h c0155h = this.d;
        g.C1991b c1991b = c0155h.g;
        return c1991b != null ? c1991b : c0155h.f;
    }

    float T() {
        return this.b;
    }

    private class k extends j {
        float b;

        private k() {
            super(h.this, null);
            this.b = 0.0f;
        }

        @Override // com.caverock.androidsvg.h.j
        public void b(String str) {
            this.b += h.this.d.d.measureText(str);
        }

        /* synthetic */ k(h hVar, a aVar) {
            this();
        }
    }

    /* renamed from: com.caverock.androidsvg.h$h, reason: collision with other inner class name */
    private class C0155h {
        g.E a;
        boolean b;
        boolean c;
        Paint d;
        Paint e;
        g.C1991b f;
        g.C1991b g;
        boolean h;

        C0155h() {
            Paint paint = new Paint();
            this.d = paint;
            paint.setFlags(SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER);
            this.d.setHinting(0);
            this.d.setStyle(Paint.Style.FILL);
            Paint paint2 = this.d;
            Typeface typeface = Typeface.DEFAULT;
            paint2.setTypeface(typeface);
            Paint paint3 = new Paint();
            this.e = paint3;
            paint3.setFlags(SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER);
            this.e.setHinting(0);
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setTypeface(typeface);
            this.a = g.E.b();
        }

        C0155h(C0155h c0155h) {
            this.b = c0155h.b;
            this.c = c0155h.c;
            this.d = new Paint(c0155h.d);
            this.e = new Paint(c0155h.e);
            g.C1991b c1991b = c0155h.f;
            if (c1991b != null) {
                this.f = new g.C1991b(c1991b);
            }
            g.C1991b c1991b2 = c0155h.g;
            if (c1991b2 != null) {
                this.g = new g.C1991b(c1991b2);
            }
            this.h = c0155h.h;
            try {
                this.a = (g.E) c0155h.a.clone();
            } catch (CloneNotSupportedException e) {
                Log.e("SVGAndroidRenderer", "Unexpected clone error", e);
                this.a = g.E.b();
            }
        }
    }
}
