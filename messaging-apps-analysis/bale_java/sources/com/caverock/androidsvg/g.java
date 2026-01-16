package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import com.caverock.androidsvg.b;
import ir.nasim.N86;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class g {
    private static boolean g = true;
    private F a = null;
    private String b = "";
    private String c = "";
    private float d = 96.0f;
    private b.r e = new b.r();
    private Map f = new HashMap();

    static class A extends C2014z {
        A() {
        }

        @Override // com.caverock.androidsvg.g.C2014z, com.caverock.androidsvg.g.N
        String o() {
            return "polygon";
        }
    }

    static class B extends AbstractC2000l {
        C2004p o;
        C2004p p;
        C2004p q;
        C2004p r;
        C2004p s;
        C2004p t;

        B() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "rect";
        }
    }

    static class C extends L implements J {
        C() {
        }

        @Override // com.caverock.androidsvg.g.J
        public List d() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.g.J
        public void i(N n) {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "solidColor";
        }
    }

    static class D extends L implements J {
        Float h;

        D() {
        }

        @Override // com.caverock.androidsvg.g.J
        public List d() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.g.J
        public void i(N n) {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "stop";
        }
    }

    static class E implements Cloneable {
        Boolean A;
        O A0;
        Boolean B;
        Float B0;
        i C0;
        O D;
        e D0;
        Float G;
        String H;
        a J;
        String Y;
        O Z;
        long a = 0;
        O b;
        a c;
        Float d;
        O e;
        Float f;
        C2004p g;
        c h;
        d i;
        Float j;
        C2004p[] k;
        C2004p l;
        Float m;
        C1995f n;
        List o;
        C2004p p;
        Integer q;
        b r;
        EnumC0153g s;
        h t;
        f u;
        Boolean v;
        C1992c w;
        String x;
        String y;
        String z;
        Float z0;

        public enum a {
            NonZero,
            EvenOdd
        }

        public enum b {
            Normal,
            Italic,
            Oblique
        }

        public enum c {
            Butt,
            Round,
            Square
        }

        public enum d {
            Miter,
            Round,
            Bevel
        }

        public enum e {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        public enum f {
            Start,
            Middle,
            End
        }

        /* renamed from: com.caverock.androidsvg.g$E$g, reason: collision with other inner class name */
        public enum EnumC0153g {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        public enum h {
            LTR,
            RTL
        }

        public enum i {
            None,
            NonScalingStroke
        }

        E() {
        }

        static E b() {
            E e2 = new E();
            e2.a = -1L;
            C1995f c1995f = C1995f.b;
            e2.b = c1995f;
            a aVar = a.NonZero;
            e2.c = aVar;
            Float fValueOf = Float.valueOf(1.0f);
            e2.d = fValueOf;
            e2.e = null;
            e2.f = fValueOf;
            e2.g = new C2004p(1.0f);
            e2.h = c.Butt;
            e2.i = d.Miter;
            e2.j = Float.valueOf(4.0f);
            e2.k = null;
            e2.l = new C2004p(0.0f);
            e2.m = fValueOf;
            e2.n = c1995f;
            e2.o = null;
            e2.p = new C2004p(12.0f, d0.pt);
            e2.q = 400;
            e2.r = b.Normal;
            e2.s = EnumC0153g.None;
            e2.t = h.LTR;
            e2.u = f.Start;
            Boolean bool = Boolean.TRUE;
            e2.v = bool;
            e2.w = null;
            e2.x = null;
            e2.y = null;
            e2.z = null;
            e2.A = bool;
            e2.B = bool;
            e2.D = c1995f;
            e2.G = fValueOf;
            e2.H = null;
            e2.J = aVar;
            e2.Y = null;
            e2.Z = null;
            e2.z0 = fValueOf;
            e2.A0 = null;
            e2.B0 = fValueOf;
            e2.C0 = i.None;
            e2.D0 = e.auto;
            return e2;
        }

        void c(boolean z) {
            Boolean bool = Boolean.TRUE;
            this.A = bool;
            if (!z) {
                bool = Boolean.FALSE;
            }
            this.v = bool;
            this.w = null;
            this.H = null;
            this.m = Float.valueOf(1.0f);
            this.D = C1995f.b;
            this.G = Float.valueOf(1.0f);
            this.Y = null;
            this.Z = null;
            this.z0 = Float.valueOf(1.0f);
            this.A0 = null;
            this.B0 = Float.valueOf(1.0f);
            this.C0 = i.None;
        }

        protected Object clone() {
            E e2 = (E) super.clone();
            C2004p[] c2004pArr = this.k;
            if (c2004pArr != null) {
                e2.k = (C2004p[]) c2004pArr.clone();
            }
            return e2;
        }
    }

    static class F extends R {
        C2004p q;
        C2004p r;
        C2004p s;
        C2004p t;
        public String u;

        F() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "svg";
        }
    }

    interface G {
        Set a();

        String b();

        void c(Set set);

        void f(Set set);

        Set g();

        void h(Set set);

        void j(Set set);

        void k(String str);

        Set m();

        Set n();
    }

    static abstract class H extends K implements J, G {
        List i = new ArrayList();
        Set j = null;
        String k = null;
        Set l = null;
        Set m = null;
        Set n = null;

        H() {
        }

        @Override // com.caverock.androidsvg.g.G
        public Set a() {
            return null;
        }

        @Override // com.caverock.androidsvg.g.G
        public String b() {
            return this.k;
        }

        @Override // com.caverock.androidsvg.g.G
        public void c(Set set) {
            this.n = set;
        }

        @Override // com.caverock.androidsvg.g.J
        public List d() {
            return this.i;
        }

        @Override // com.caverock.androidsvg.g.G
        public void f(Set set) {
            this.j = set;
        }

        @Override // com.caverock.androidsvg.g.G
        public Set g() {
            return this.j;
        }

        @Override // com.caverock.androidsvg.g.G
        public void h(Set set) {
            this.l = set;
        }

        @Override // com.caverock.androidsvg.g.J
        public void i(N n) {
            this.i.add(n);
        }

        @Override // com.caverock.androidsvg.g.G
        public void j(Set set) {
            this.m = set;
        }

        @Override // com.caverock.androidsvg.g.G
        public void k(String str) {
            this.k = str;
        }

        @Override // com.caverock.androidsvg.g.G
        public Set m() {
            return this.m;
        }

        @Override // com.caverock.androidsvg.g.G
        public Set n() {
            return this.n;
        }
    }

    static abstract class I extends K implements G {
        Set i = null;
        String j = null;
        Set k = null;
        Set l = null;
        Set m = null;

        I() {
        }

        @Override // com.caverock.androidsvg.g.G
        public Set a() {
            return this.k;
        }

        @Override // com.caverock.androidsvg.g.G
        public String b() {
            return this.j;
        }

        @Override // com.caverock.androidsvg.g.G
        public void c(Set set) {
            this.m = set;
        }

        @Override // com.caverock.androidsvg.g.G
        public void f(Set set) {
            this.i = set;
        }

        @Override // com.caverock.androidsvg.g.G
        public Set g() {
            return this.i;
        }

        @Override // com.caverock.androidsvg.g.G
        public void h(Set set) {
            this.k = set;
        }

        @Override // com.caverock.androidsvg.g.G
        public void j(Set set) {
            this.l = set;
        }

        @Override // com.caverock.androidsvg.g.G
        public void k(String str) {
            this.j = str;
        }

        @Override // com.caverock.androidsvg.g.G
        public Set m() {
            return this.l;
        }

        @Override // com.caverock.androidsvg.g.G
        public Set n() {
            return this.m;
        }
    }

    interface J {
        List d();

        void i(N n);
    }

    static abstract class K extends L {
        C1991b h = null;

        K() {
        }
    }

    static abstract class L extends N {
        String c = null;
        Boolean d = null;
        E e = null;
        E f = null;
        List g = null;

        L() {
        }

        public String toString() {
            return o();
        }
    }

    static class M extends AbstractC1998j {
        C2004p m;
        C2004p n;
        C2004p o;
        C2004p p;

        M() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "linearGradient";
        }
    }

    static class N {
        g a;
        J b;

        N() {
        }

        abstract String o();
    }

    static abstract class O implements Cloneable {
        O() {
        }
    }

    static abstract class P extends H {
        e o = null;

        P() {
        }
    }

    static class Q extends AbstractC1998j {
        C2004p m;
        C2004p n;
        C2004p o;
        C2004p p;
        C2004p q;

        Q() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "radialGradient";
        }
    }

    static abstract class R extends P {
        C1991b p;

        R() {
        }
    }

    static class S extends C2001m {
        S() {
        }

        @Override // com.caverock.androidsvg.g.C2001m, com.caverock.androidsvg.g.N
        String o() {
            return "switch";
        }
    }

    static class T extends R implements InterfaceC2008t {
        T() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "symbol";
        }
    }

    static class U extends Y implements X {
        String o;
        private b0 p;

        U() {
        }

        @Override // com.caverock.androidsvg.g.X
        public b0 e() {
            return this.p;
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "tref";
        }

        public void p(b0 b0Var) {
            this.p = b0Var;
        }
    }

    static class V extends a0 implements X {
        private b0 s;

        V() {
        }

        @Override // com.caverock.androidsvg.g.X
        public b0 e() {
            return this.s;
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "tspan";
        }

        public void p(b0 b0Var) {
            this.s = b0Var;
        }
    }

    static class W extends a0 implements b0, InterfaceC2002n {
        Matrix s;

        W() {
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2002n
        public void l(Matrix matrix) {
            this.s = matrix;
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return ParameterNames.TEXT;
        }
    }

    interface X {
        b0 e();
    }

    static abstract class Y extends H {
        Y() {
        }

        @Override // com.caverock.androidsvg.g.H, com.caverock.androidsvg.g.J
        public void i(N n) throws SVGParseException {
            if (n instanceof X) {
                this.i.add(n);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + n + " elements.");
        }
    }

    static class Z extends Y implements X {
        String o;
        C2004p p;
        private b0 q;

        Z() {
        }

        @Override // com.caverock.androidsvg.g.X
        public b0 e() {
            return this.q;
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "textPath";
        }

        public void p(b0 b0Var) {
            this.q = b0Var;
        }
    }

    /* renamed from: com.caverock.androidsvg.g$a, reason: case insensitive filesystem */
    static /* synthetic */ class C1990a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d0.values().length];
            a = iArr;
            try {
                iArr[d0.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d0.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d0.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d0.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d0.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d0.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d0.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d0.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d0.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    static abstract class a0 extends Y {
        List o;
        List p;
        List q;
        List r;

        a0() {
        }
    }

    interface b0 {
    }

    /* renamed from: com.caverock.androidsvg.g$c, reason: case insensitive filesystem */
    static class C1992c {
        C2004p a;
        C2004p b;
        C2004p c;
        C2004p d;

        C1992c(C2004p c2004p, C2004p c2004p2, C2004p c2004p3, C2004p c2004p4) {
            this.a = c2004p;
            this.b = c2004p2;
            this.c = c2004p3;
            this.d = c2004p4;
        }
    }

    static class c0 extends N implements X {
        String c;
        private b0 d;

        c0(String str) {
            this.c = str;
        }

        @Override // com.caverock.androidsvg.g.X
        public b0 e() {
            return this.d;
        }

        public String toString() {
            return "TextChild: '" + this.c + Separators.QUOTE;
        }
    }

    /* renamed from: com.caverock.androidsvg.g$d, reason: case insensitive filesystem */
    static class C1993d extends AbstractC2000l {
        C2004p o;
        C2004p p;
        C2004p q;

        C1993d() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "circle";
        }
    }

    enum d0 {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    /* renamed from: com.caverock.androidsvg.g$e, reason: case insensitive filesystem */
    static class C1994e extends C2001m implements InterfaceC2008t {
        Boolean p;

        C1994e() {
        }

        @Override // com.caverock.androidsvg.g.C2001m, com.caverock.androidsvg.g.N
        String o() {
            return "clipPath";
        }
    }

    static class e0 extends C2001m {
        String p;
        C2004p q;
        C2004p r;
        C2004p s;
        C2004p t;

        e0() {
        }

        @Override // com.caverock.androidsvg.g.C2001m, com.caverock.androidsvg.g.N
        String o() {
            return "use";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$f, reason: case insensitive filesystem */
    static class C1995f extends O {
        static final C1995f b = new C1995f(-16777216);
        static final C1995f c = new C1995f(0);
        int a;

        C1995f(int i) {
            this.a = i;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.a));
        }
    }

    static class f0 extends R implements InterfaceC2008t {
        f0() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "view";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$g, reason: collision with other inner class name */
    static class C0154g extends O {
        private static C0154g a = new C0154g();

        private C0154g() {
        }

        static C0154g b() {
            return a;
        }
    }

    /* renamed from: com.caverock.androidsvg.g$h, reason: case insensitive filesystem */
    static class C1996h extends C2001m implements InterfaceC2008t {
        C1996h() {
        }

        @Override // com.caverock.androidsvg.g.C2001m, com.caverock.androidsvg.g.N
        String o() {
            return "defs";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$i, reason: case insensitive filesystem */
    static class C1997i extends AbstractC2000l {
        C2004p o;
        C2004p p;
        C2004p q;
        C2004p r;

        C1997i() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "ellipse";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$j, reason: case insensitive filesystem */
    static abstract class AbstractC1998j extends L implements J {
        List h = new ArrayList();
        Boolean i;
        Matrix j;
        EnumC1999k k;
        String l;

        AbstractC1998j() {
        }

        @Override // com.caverock.androidsvg.g.J
        public List d() {
            return this.h;
        }

        @Override // com.caverock.androidsvg.g.J
        public void i(N n) throws SVGParseException {
            if (n instanceof D) {
                this.h.add(n);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + n + " elements.");
        }
    }

    /* renamed from: com.caverock.androidsvg.g$k, reason: case insensitive filesystem */
    enum EnumC1999k {
        pad,
        reflect,
        repeat
    }

    /* renamed from: com.caverock.androidsvg.g$l, reason: case insensitive filesystem */
    static abstract class AbstractC2000l extends I implements InterfaceC2002n {
        Matrix n;

        AbstractC2000l() {
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2002n
        public void l(Matrix matrix) {
            this.n = matrix;
        }
    }

    /* renamed from: com.caverock.androidsvg.g$m, reason: case insensitive filesystem */
    static class C2001m extends H implements InterfaceC2002n {
        Matrix o;

        C2001m() {
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2002n
        public void l(Matrix matrix) {
            this.o = matrix;
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "group";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$n, reason: case insensitive filesystem */
    interface InterfaceC2002n {
        void l(Matrix matrix);
    }

    /* renamed from: com.caverock.androidsvg.g$o, reason: case insensitive filesystem */
    static class C2003o extends P implements InterfaceC2002n {
        String p;
        C2004p q;
        C2004p r;
        C2004p s;
        C2004p t;
        Matrix u;

        C2003o() {
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2002n
        public void l(Matrix matrix) {
            this.u = matrix;
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "image";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$q, reason: case insensitive filesystem */
    static class C2005q extends AbstractC2000l {
        C2004p o;
        C2004p p;
        C2004p q;
        C2004p r;

        C2005q() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "line";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$r, reason: case insensitive filesystem */
    static class C2006r extends R implements InterfaceC2008t {
        boolean q;
        C2004p r;
        C2004p s;
        C2004p t;
        C2004p u;
        Float v;

        C2006r() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "marker";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$s, reason: case insensitive filesystem */
    static class C2007s extends H implements InterfaceC2008t {
        Boolean o;
        Boolean p;
        C2004p q;
        C2004p r;
        C2004p s;
        C2004p t;

        C2007s() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "mask";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$t, reason: case insensitive filesystem */
    interface InterfaceC2008t {
    }

    /* renamed from: com.caverock.androidsvg.g$u, reason: case insensitive filesystem */
    static class C2009u extends O {
        String a;
        O b;

        C2009u(String str, O o) {
            this.a = str;
            this.b = o;
        }

        public String toString() {
            return this.a + Separators.SP + this.b;
        }
    }

    /* renamed from: com.caverock.androidsvg.g$v, reason: case insensitive filesystem */
    static class C2010v extends AbstractC2000l {
        C2011w o;
        Float p;

        C2010v() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "path";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$w, reason: case insensitive filesystem */
    static class C2011w implements InterfaceC2012x {
        private int b = 0;
        private int d = 0;
        private byte[] a = new byte[8];
        private float[] c = new float[16];

        C2011w() {
        }

        private void f(byte b) {
            int i = this.b;
            byte[] bArr = this.a;
            if (i == bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.a = bArr2;
            }
            byte[] bArr3 = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            bArr3[i2] = b;
        }

        private void g(int i) {
            float[] fArr = this.c;
            if (fArr.length < this.d + i) {
                float[] fArr2 = new float[fArr.length * 2];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.c = fArr2;
            }
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void a(float f, float f2) {
            f((byte) 0);
            g(2);
            float[] fArr = this.c;
            int i = this.d;
            fArr[i] = f;
            this.d = i + 2;
            fArr[i + 1] = f2;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            f((byte) 2);
            g(6);
            float[] fArr = this.c;
            int i = this.d;
            fArr[i] = f;
            fArr[i + 1] = f2;
            fArr[i + 2] = f3;
            fArr[i + 3] = f4;
            fArr[i + 4] = f5;
            this.d = i + 6;
            fArr[i + 5] = f6;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void c(float f, float f2) {
            f((byte) 1);
            g(2);
            float[] fArr = this.c;
            int i = this.d;
            fArr[i] = f;
            this.d = i + 2;
            fArr[i + 1] = f2;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void close() {
            f((byte) 8);
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void d(float f, float f2, float f3, float f4) {
            f((byte) 3);
            g(4);
            float[] fArr = this.c;
            int i = this.d;
            fArr[i] = f;
            fArr[i + 1] = f2;
            fArr[i + 2] = f3;
            this.d = i + 4;
            fArr[i + 3] = f4;
        }

        @Override // com.caverock.androidsvg.g.InterfaceC2012x
        public void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            f((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
            g(5);
            float[] fArr = this.c;
            int i = this.d;
            fArr[i] = f;
            fArr[i + 1] = f2;
            fArr[i + 2] = f3;
            fArr[i + 3] = f4;
            this.d = i + 5;
            fArr[i + 4] = f5;
        }

        void h(InterfaceC2012x interfaceC2012x) {
            int i = 0;
            for (int i2 = 0; i2 < this.b; i2++) {
                byte b = this.a[i2];
                if (b == 0) {
                    float[] fArr = this.c;
                    int i3 = i + 1;
                    float f = fArr[i];
                    i += 2;
                    interfaceC2012x.a(f, fArr[i3]);
                } else if (b == 1) {
                    float[] fArr2 = this.c;
                    int i4 = i + 1;
                    float f2 = fArr2[i];
                    i += 2;
                    interfaceC2012x.c(f2, fArr2[i4]);
                } else if (b == 2) {
                    float[] fArr3 = this.c;
                    float f3 = fArr3[i];
                    float f4 = fArr3[i + 1];
                    float f5 = fArr3[i + 2];
                    float f6 = fArr3[i + 3];
                    int i5 = i + 5;
                    float f7 = fArr3[i + 4];
                    i += 6;
                    interfaceC2012x.b(f3, f4, f5, f6, f7, fArr3[i5]);
                } else if (b == 3) {
                    float[] fArr4 = this.c;
                    float f8 = fArr4[i];
                    float f9 = fArr4[i + 1];
                    int i6 = i + 3;
                    float f10 = fArr4[i + 2];
                    i += 4;
                    interfaceC2012x.d(f8, f9, f10, fArr4[i6]);
                } else if (b != 8) {
                    boolean z = (b & 2) != 0;
                    boolean z2 = (b & 1) != 0;
                    float[] fArr5 = this.c;
                    float f11 = fArr5[i];
                    float f12 = fArr5[i + 1];
                    float f13 = fArr5[i + 2];
                    int i7 = i + 4;
                    float f14 = fArr5[i + 3];
                    i += 5;
                    interfaceC2012x.e(f11, f12, f13, z, z2, f14, fArr5[i7]);
                } else {
                    interfaceC2012x.close();
                }
            }
        }

        boolean i() {
            return this.b == 0;
        }
    }

    /* renamed from: com.caverock.androidsvg.g$x, reason: case insensitive filesystem */
    interface InterfaceC2012x {
        void a(float f, float f2);

        void b(float f, float f2, float f3, float f4, float f5, float f6);

        void c(float f, float f2);

        void close();

        void d(float f, float f2, float f3, float f4);

        void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);
    }

    /* renamed from: com.caverock.androidsvg.g$y, reason: case insensitive filesystem */
    static class C2013y extends R implements InterfaceC2008t {
        Boolean q;
        Boolean r;
        Matrix s;
        C2004p t;
        C2004p u;
        C2004p v;
        C2004p w;
        String x;

        C2013y() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "pattern";
        }
    }

    /* renamed from: com.caverock.androidsvg.g$z, reason: case insensitive filesystem */
    static class C2014z extends AbstractC2000l {
        float[] o;

        C2014z() {
        }

        @Override // com.caverock.androidsvg.g.N
        String o() {
            return "polyline";
        }
    }

    g() {
    }

    private String c(String str) {
        if (str.startsWith(Separators.DOUBLE_QUOTE) && str.endsWith(Separators.DOUBLE_QUOTE)) {
            str = str.substring(1, str.length() - 1).replace("\\\"", Separators.DOUBLE_QUOTE);
        } else if (str.startsWith(Separators.QUOTE) && str.endsWith(Separators.QUOTE)) {
            str = str.substring(1, str.length() - 1).replace("\\'", Separators.QUOTE);
        }
        return str.replace("\\\n", "").replace("\\A", Separators.RETURN);
    }

    private C1991b e(float f) {
        d0 d0Var;
        d0 d0Var2;
        d0 d0Var3;
        d0 d0Var4;
        float fC;
        d0 d0Var5;
        F f2 = this.a;
        C2004p c2004p = f2.s;
        C2004p c2004p2 = f2.t;
        if (c2004p == null || c2004p.k() || (d0Var = c2004p.b) == (d0Var2 = d0.percent) || d0Var == (d0Var3 = d0.em) || d0Var == (d0Var4 = d0.ex)) {
            return new C1991b(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float fC2 = c2004p.c(f);
        if (c2004p2 == null) {
            C1991b c1991b = this.a.p;
            fC = c1991b != null ? (c1991b.d * fC2) / c1991b.c : fC2;
        } else {
            if (c2004p2.k() || (d0Var5 = c2004p2.b) == d0Var2 || d0Var5 == d0Var3 || d0Var5 == d0Var4) {
                return new C1991b(-1.0f, -1.0f, -1.0f, -1.0f);
            }
            fC = c2004p2.c(f);
        }
        return new C1991b(0.0f, 0.0f, fC2, fC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private L i(J j, String str) {
        L lI;
        L l = (L) j;
        if (str.equals(l.c)) {
            return l;
        }
        for (Object obj : j.d()) {
            if (obj instanceof L) {
                L l2 = (L) obj;
                if (str.equals(l2.c)) {
                    return l2;
                }
                if ((obj instanceof J) && (lI = i((J) obj, str)) != null) {
                    return lI;
                }
            }
        }
        return null;
    }

    static N86 k() {
        return null;
    }

    public static g l(InputStream inputStream) {
        return new i().z(inputStream, g);
    }

    public static g m(Context context, int i) {
        return n(context.getResources(), i);
    }

    public static g n(Resources resources, int i) throws Resources.NotFoundException, IOException {
        i iVar = new i();
        InputStream inputStreamOpenRawResource = resources.openRawResource(i);
        try {
            return iVar.z(inputStreamOpenRawResource, g);
        } finally {
            try {
                inputStreamOpenRawResource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static g o(String str) {
        return new i().z(new ByteArrayInputStream(str.getBytes()), g);
    }

    public void A(float f, float f2, float f3, float f4) {
        F f5 = this.a;
        if (f5 == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        f5.p = new C1991b(f, f2, f3, f4);
    }

    public void B(float f) {
        F f2 = this.a;
        if (f2 == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        f2.s = new C2004p(f);
    }

    public void C(String str) {
        F f = this.a;
        if (f == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        f.s = i.o0(str);
    }

    void D(F f) {
        this.a = f;
    }

    void E(String str) {
        this.b = str;
    }

    void a(b.r rVar) {
        this.e.b(rVar);
    }

    void b() {
        this.e.e(b.u.RenderOptions);
    }

    List d() {
        return this.e.c();
    }

    public float f() {
        if (this.a != null) {
            return e(this.d).d;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public RectF g() {
        F f = this.a;
        if (f == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        C1991b c1991b = f.p;
        if (c1991b == null) {
            return null;
        }
        return c1991b.d();
    }

    public float h() {
        if (this.a != null) {
            return e(this.d).c;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    L j(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.a.c)) {
            return this.a;
        }
        if (this.f.containsKey(str)) {
            return (L) this.f.get(str);
        }
        L lI = i(this.a, str);
        this.f.put(str, lI);
        return lI;
    }

    F p() {
        return this.a;
    }

    boolean q() {
        return !this.e.d();
    }

    public void r(Canvas canvas) {
        s(canvas, null);
    }

    public void s(Canvas canvas, f fVar) {
        if (fVar == null) {
            fVar = new f();
        }
        if (!fVar.g()) {
            fVar.h(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        new h(canvas, this.d).G0(this, fVar);
    }

    public Picture t() {
        return v(null);
    }

    public Picture u(int i, int i2, f fVar) {
        Picture picture = new Picture();
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        if (fVar == null || fVar.f == null) {
            fVar = fVar == null ? new f() : new f(fVar);
            fVar.h(0.0f, 0.0f, i, i2);
        }
        new h(canvasBeginRecording, this.d).G0(this, fVar);
        picture.endRecording();
        return picture;
    }

    public Picture v(f fVar) {
        C2004p c2004p;
        C1991b c1991b = (fVar == null || !fVar.f()) ? this.a.p : fVar.d;
        if (fVar != null && fVar.g()) {
            return u((int) Math.ceil(fVar.f.b()), (int) Math.ceil(fVar.f.c()), fVar);
        }
        F f = this.a;
        C2004p c2004p2 = f.s;
        if (c2004p2 != null) {
            d0 d0Var = c2004p2.b;
            d0 d0Var2 = d0.percent;
            if (d0Var != d0Var2 && (c2004p = f.t) != null && c2004p.b != d0Var2) {
                return u((int) Math.ceil(c2004p2.c(this.d)), (int) Math.ceil(this.a.t.c(this.d)), fVar);
            }
        }
        if (c2004p2 != null && c1991b != null) {
            return u((int) Math.ceil(c2004p2.c(this.d)), (int) Math.ceil((c1991b.d * r1) / c1991b.c), fVar);
        }
        C2004p c2004p3 = f.t;
        if (c2004p3 == null || c1991b == null) {
            return u(512, 512, fVar);
        }
        return u((int) Math.ceil((c1991b.c * r1) / c1991b.d), (int) Math.ceil(c2004p3.c(this.d)), fVar);
    }

    N w(String str) {
        if (str == null) {
            return null;
        }
        String strC = c(str);
        if (strC.length() <= 1 || !strC.startsWith(Separators.POUND)) {
            return null;
        }
        return j(strC.substring(1));
    }

    void x(String str) {
        this.c = str;
    }

    public void y(float f) {
        F f2 = this.a;
        if (f2 == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        f2.t = new C2004p(f);
    }

    public void z(String str) {
        F f = this.a;
        if (f == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        f.t = i.o0(str);
    }

    /* renamed from: com.caverock.androidsvg.g$p, reason: case insensitive filesystem */
    static class C2004p implements Cloneable {
        float a;
        d0 b;

        C2004p(float f, d0 d0Var) {
            this.a = f;
            this.b = d0Var;
        }

        float b() {
            return this.a;
        }

        float c(float f) {
            int i = C1990a.a[this.b.ordinal()];
            if (i == 1) {
                return this.a;
            }
            switch (i) {
                case 4:
                    return this.a * f;
                case 5:
                    return (this.a * f) / 2.54f;
                case 6:
                    return (this.a * f) / 25.4f;
                case 7:
                    return (this.a * f) / 72.0f;
                case 8:
                    return (this.a * f) / 6.0f;
                default:
                    return this.a;
            }
        }

        float d(h hVar) {
            if (this.b != d0.percent) {
                return f(hVar);
            }
            C1991b c1991bS = hVar.S();
            if (c1991bS == null) {
                return this.a;
            }
            float f = c1991bS.c;
            if (f == c1991bS.d) {
                return (this.a * f) / 100.0f;
            }
            return (this.a * ((float) (Math.sqrt((f * f) + (r6 * r6)) / 1.414213562373095d))) / 100.0f;
        }

        float e(h hVar, float f) {
            return this.b == d0.percent ? (this.a * f) / 100.0f : f(hVar);
        }

        float f(h hVar) {
            switch (C1990a.a[this.b.ordinal()]) {
                case 9:
                    C1991b c1991bS = hVar.S();
                    if (c1991bS != null) {
                        break;
                    } else {
                        break;
                    }
            }
            return this.a;
        }

        float h(h hVar) {
            if (this.b != d0.percent) {
                return f(hVar);
            }
            C1991b c1991bS = hVar.S();
            return c1991bS == null ? this.a : (this.a * c1991bS.d) / 100.0f;
        }

        boolean i() {
            return this.a < 0.0f;
        }

        boolean k() {
            return this.a == 0.0f;
        }

        public String toString() {
            return String.valueOf(this.a) + this.b;
        }

        C2004p(float f) {
            this.a = f;
            this.b = d0.px;
        }
    }

    /* renamed from: com.caverock.androidsvg.g$b, reason: case insensitive filesystem */
    static class C1991b {
        float a;
        float b;
        float c;
        float d;

        C1991b(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        static C1991b a(float f, float f2, float f3, float f4) {
            return new C1991b(f, f2, f3 - f, f4 - f2);
        }

        float b() {
            return this.a + this.c;
        }

        float c() {
            return this.b + this.d;
        }

        RectF d() {
            return new RectF(this.a, this.b, b(), c());
        }

        void e(C1991b c1991b) {
            float f = c1991b.a;
            if (f < this.a) {
                this.a = f;
            }
            float f2 = c1991b.b;
            if (f2 < this.b) {
                this.b = f2;
            }
            if (c1991b.b() > b()) {
                this.c = c1991b.b() - this.a;
            }
            if (c1991b.c() > c()) {
                this.d = c1991b.c() - this.b;
            }
        }

        public String toString() {
            return "[" + this.a + Separators.SP + this.b + Separators.SP + this.c + Separators.SP + this.d + "]";
        }

        C1991b(C1991b c1991b) {
            this.a = c1991b.a;
            this.b = c1991b.b;
            this.c = c1991b.c;
            this.d = c1991b.d;
        }
    }
}
