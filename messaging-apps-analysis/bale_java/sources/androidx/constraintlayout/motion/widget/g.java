package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import ir.nasim.AbstractC15999kX7;
import ir.nasim.AbstractC6522Nw1;
import ir.nasim.AbstractC7637So3;
import ir.nasim.C17935no3;
import ir.nasim.C18900pR7;
import ir.nasim.GX7;
import ir.nasim.HX7;
import ir.nasim.J22;
import ir.nasim.MI6;
import ir.nasim.OA1;
import ir.nasim.QX7;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class g {
    private HashMap B;
    private HashMap C;
    private HashMap D;
    private AbstractC7637So3[] E;
    private int F;
    private int G;
    private View H;
    private int I;
    private float J;
    private Interpolator K;
    private boolean L;
    View b;
    int c;
    String e;
    private AbstractC6522Nw1[] k;
    private AbstractC6522Nw1 l;
    float p;
    float q;
    private int[] r;
    private double[] s;
    private double[] t;
    private String[] u;
    private int[] v;
    Rect a = new Rect();
    boolean d = false;
    private int f = -1;
    private h g = new h();
    private h h = new h();
    private f i = new f();
    private f j = new f();
    float m = Float.NaN;
    float n = 0.0f;
    float o = 1.0f;
    private int w = 4;
    private float[] x = new float[4];
    private ArrayList y = new ArrayList();
    private float[] z = new float[1];
    private ArrayList A = new ArrayList();

    class a implements Interpolator {
        final /* synthetic */ J22 a;

        a(J22 j22) {
            this.a = j22;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.a.a(f);
        }
    }

    g(View view) {
        int i = androidx.constraintlayout.motion.widget.a.f;
        this.F = i;
        this.G = i;
        this.H = null;
        this.I = i;
        this.J = Float.NaN;
        this.K = null;
        this.L = false;
        H(view);
    }

    private float g(float f, float[] fArr) {
        float f2 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f3 = this.o;
            if (f3 != 1.0d) {
                float f4 = this.n;
                if (f < f4) {
                    f = 0.0f;
                }
                if (f > f4 && f < 1.0d) {
                    f = Math.min((f - f4) * f3, 1.0f);
                }
            }
        }
        J22 j22 = this.g.a;
        Iterator it = this.y.iterator();
        float f5 = Float.NaN;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            J22 j222 = hVar.a;
            if (j222 != null) {
                float f6 = hVar.c;
                if (f6 < f) {
                    j22 = j222;
                    f2 = f6;
                } else if (Float.isNaN(f5)) {
                    f5 = hVar.c;
                }
            }
        }
        if (j22 != null) {
            float f7 = (Float.isNaN(f5) ? 1.0f : f5) - f2;
            double d = (f - f2) / f7;
            f = (((float) j22.a(d)) * f7) + f2;
            if (fArr != null) {
                fArr[0] = (float) j22.b(d);
            }
        }
        return f;
    }

    private static Interpolator p(Context context, int i, String str, int i2) {
        if (i == -2) {
            return AnimationUtils.loadInterpolator(context, i2);
        }
        if (i == -1) {
            return new a(J22.c(str));
        }
        if (i == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i == 1) {
            return new AccelerateInterpolator();
        }
        if (i == 2) {
            return new DecelerateInterpolator();
        }
        if (i == 4) {
            return new BounceInterpolator();
        }
        if (i != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    private float s() {
        char c;
        float fHypot;
        float[] fArr = new float[2];
        float f = 1.0f / 99;
        double d = 0.0d;
        double d2 = 0.0d;
        float f2 = 0.0f;
        int i = 0;
        while (i < 100) {
            float f3 = i * f;
            double dA = f3;
            J22 j22 = this.g.a;
            Iterator it = this.y.iterator();
            float f4 = Float.NaN;
            float f5 = 0.0f;
            while (it.hasNext()) {
                h hVar = (h) it.next();
                J22 j222 = hVar.a;
                if (j222 != null) {
                    float f6 = hVar.c;
                    if (f6 < f3) {
                        j22 = j222;
                        f5 = f6;
                    } else if (Float.isNaN(f4)) {
                        f4 = hVar.c;
                    }
                }
            }
            if (j22 != null) {
                if (Float.isNaN(f4)) {
                    f4 = 1.0f;
                }
                dA = (((float) j22.a((f3 - f5) / r17)) * (f4 - f5)) + f5;
            }
            this.k[0].d(dA, this.s);
            float f7 = f2;
            int i2 = i;
            this.g.p(dA, this.r, this.s, fArr, 0);
            if (i2 > 0) {
                c = 0;
                fHypot = (float) (f7 + Math.hypot(d2 - fArr[1], d - fArr[0]));
            } else {
                c = 0;
                fHypot = f7;
            }
            d = fArr[c];
            i = i2 + 1;
            f2 = fHypot;
            d2 = fArr[1];
        }
        return f2;
    }

    private void w(h hVar) {
        if (Collections.binarySearch(this.y, hVar) == 0) {
            float f = hVar.d;
            StringBuilder sb = new StringBuilder(52);
            sb.append(" KeyPath position \"");
            sb.append(f);
            sb.append("\" outside of range");
            Log.e("MotionController", sb.toString());
        }
        this.y.add((-r0) - 1, hVar);
    }

    private void y(h hVar) {
        hVar.z((int) this.b.getX(), (int) this.b.getY(), this.b.getWidth(), this.b.getHeight());
    }

    void A(Rect rect, Rect rect2, int i, int i2, int i3) {
        if (i == 1) {
            int i4 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i3 - ((i4 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i == 2) {
            int i5 = rect.left + rect.right;
            rect2.left = i2 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i5 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i == 3) {
            int i6 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i6 / 2);
            rect2.top = i3 - ((i6 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i != 4) {
            return;
        }
        int i7 = rect.left + rect.right;
        rect2.left = i2 - (((rect.bottom + rect.top) + rect.width()) / 2);
        rect2.top = (i7 - rect.height()) / 2;
        rect2.right = rect2.left + rect.width();
        rect2.bottom = rect2.top + rect.height();
    }

    void B(View view) {
        h hVar = this.g;
        hVar.c = 0.0f;
        hVar.d = 0.0f;
        this.L = true;
        hVar.z(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.h.z(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.i.s(view);
        this.j.s(view);
    }

    void C(Rect rect, androidx.constraintlayout.widget.c cVar, int i, int i2) {
        int i3 = cVar.d;
        if (i3 != 0) {
            A(rect, this.a, i3, i, i2);
            rect = this.a;
        }
        h hVar = this.h;
        hVar.c = 1.0f;
        hVar.d = 1.0f;
        y(hVar);
        this.h.z(rect.left, rect.top, rect.width(), rect.height());
        this.h.a(cVar.B(this.c));
        this.j.r(rect, cVar, i3, this.c);
    }

    public void D(int i) {
        this.F = i;
    }

    void E(View view) {
        h hVar = this.g;
        hVar.c = 0.0f;
        hVar.d = 0.0f;
        hVar.z(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.i.s(view);
    }

    void F(Rect rect, androidx.constraintlayout.widget.c cVar, int i, int i2) {
        int i3 = cVar.d;
        if (i3 != 0) {
            A(rect, this.a, i3, i, i2);
        }
        h hVar = this.g;
        hVar.c = 0.0f;
        hVar.d = 0.0f;
        y(hVar);
        this.g.z(rect.left, rect.top, rect.width(), rect.height());
        c.a aVarB = cVar.B(this.c);
        this.g.a(aVarB);
        this.m = aVarB.d.g;
        this.i.r(rect, cVar, i3, this.c);
        this.G = aVarB.f.i;
        c.C0078c c0078c = aVarB.d;
        this.I = c0078c.k;
        this.J = c0078c.j;
        Context context = this.b.getContext();
        c.C0078c c0078c2 = aVarB.d;
        this.K = p(context, c0078c2.m, c0078c2.l, c0078c2.n);
    }

    public void G(HX7 hx7, View view, int i, int i2, int i3) {
        h hVar = this.g;
        hVar.c = 0.0f;
        hVar.d = 0.0f;
        Rect rect = new Rect();
        if (i == 1 || i == 2) {
            throw null;
        }
        this.g.z(rect.left, rect.top, rect.width(), rect.height());
        throw null;
    }

    public void H(View view) {
        this.b = view;
        this.c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.e = ((ConstraintLayout.LayoutParams) layoutParams).a();
        }
    }

    public void I(int i, int i2, float f, long j) {
        String[] strArr;
        double[][] dArr;
        androidx.constraintlayout.widget.a aVar;
        QX7 qx7G;
        androidx.constraintlayout.widget.a aVar2;
        Integer num;
        GX7 gx7G;
        androidx.constraintlayout.widget.a aVar3;
        new HashSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashMap map = new HashMap();
        int i3 = this.F;
        if (i3 != androidx.constraintlayout.motion.widget.a.f) {
            this.g.k = i3;
        }
        this.i.p(this.j, hashSet2);
        ArrayList arrayList = this.A;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.motion.widget.a aVar4 = (androidx.constraintlayout.motion.widget.a) it.next();
                if (aVar4 instanceof d) {
                    d dVar = (d) aVar4;
                    w(new h(i, i2, dVar, this.g, this.h));
                    int i4 = dVar.g;
                    if (i4 != androidx.constraintlayout.motion.widget.a.f) {
                        this.f = i4;
                    }
                } else {
                    aVar4.h(map);
                    aVar4.d(hashSet2);
                }
            }
        }
        char c = 1;
        if (!hashSet2.isEmpty()) {
            this.C = new HashMap();
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    Iterator it3 = this.A.iterator();
                    while (it3.hasNext()) {
                        androidx.constraintlayout.motion.widget.a aVar5 = (androidx.constraintlayout.motion.widget.a) it3.next();
                        HashMap map2 = aVar5.e;
                        if (map2 != null && (aVar3 = (androidx.constraintlayout.widget.a) map2.get(str2)) != null) {
                            sparseArray.append(aVar5.a, aVar3);
                        }
                    }
                    gx7G = GX7.f(str, sparseArray);
                } else {
                    gx7G = GX7.g(str);
                }
                if (gx7G != null) {
                    gx7G.d(str);
                    this.C.put(str, gx7G);
                }
            }
            ArrayList arrayList2 = this.A;
            if (arrayList2 != null) {
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    androidx.constraintlayout.motion.widget.a aVar6 = (androidx.constraintlayout.motion.widget.a) it4.next();
                    if (aVar6 instanceof b) {
                        aVar6.a(this.C);
                    }
                }
            }
            this.i.a(this.C, 0);
            this.j.a(this.C, 100);
            for (String str3 : this.C.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = (Integer) map.get(str3)) == null) ? 0 : num.intValue();
                MI6 mi6 = (MI6) this.C.get(str3);
                if (mi6 != null) {
                    mi6.e(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.B == null) {
                this.B = new HashMap();
            }
            Iterator it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String str4 = (String) it5.next();
                if (!this.B.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(",")[1];
                        Iterator it6 = this.A.iterator();
                        while (it6.hasNext()) {
                            androidx.constraintlayout.motion.widget.a aVar7 = (androidx.constraintlayout.motion.widget.a) it6.next();
                            HashMap map3 = aVar7.e;
                            if (map3 != null && (aVar2 = (androidx.constraintlayout.widget.a) map3.get(str5)) != null) {
                                sparseArray2.append(aVar7.a, aVar2);
                            }
                        }
                        qx7G = QX7.f(str4, sparseArray2);
                    } else {
                        qx7G = QX7.g(str4, j);
                    }
                    if (qx7G != null) {
                        qx7G.c(str4);
                        this.B.put(str4, qx7G);
                    }
                }
            }
            ArrayList arrayList3 = this.A;
            if (arrayList3 != null) {
                Iterator it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                }
            }
            for (String str6 : this.B.keySet()) {
                ((QX7) this.B.get(str6)).d(map.containsKey(str6) ? ((Integer) map.get(str6)).intValue() : 0);
            }
        }
        int size = this.y.size();
        int i5 = size + 2;
        h[] hVarArr = new h[i5];
        hVarArr[0] = this.g;
        hVarArr[size + 1] = this.h;
        if (this.y.size() > 0 && this.f == -1) {
            this.f = 0;
        }
        Iterator it8 = this.y.iterator();
        int i6 = 1;
        while (it8.hasNext()) {
            hVarArr[i6] = (h) it8.next();
            i6++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.h.o.keySet()) {
            if (this.g.o.containsKey(str7)) {
                String strValueOf = String.valueOf(str7);
                if (!hashSet2.contains(strValueOf.length() != 0 ? "CUSTOM,".concat(strValueOf) : new String("CUSTOM,"))) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.u = strArr2;
        this.v = new int[strArr2.length];
        int i7 = 0;
        while (true) {
            strArr = this.u;
            if (i7 >= strArr.length) {
                break;
            }
            String str8 = strArr[i7];
            this.v[i7] = 0;
            int i8 = 0;
            while (true) {
                if (i8 >= i5) {
                    break;
                }
                if (hVarArr[i8].o.containsKey(str8) && (aVar = (androidx.constraintlayout.widget.a) hVarArr[i8].o.get(str8)) != null) {
                    int[] iArr = this.v;
                    iArr[i7] = iArr[i7] + aVar.f();
                    break;
                }
                i8++;
            }
            i7++;
        }
        boolean z = hVarArr[0].k != androidx.constraintlayout.motion.widget.a.f;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i9 = 1; i9 < i5; i9++) {
            hVarArr[i9].j(hVarArr[i9 - 1], zArr, this.u, z);
        }
        int i10 = 0;
        for (int i11 = 1; i11 < length; i11++) {
            if (zArr[i11]) {
                i10++;
            }
        }
        this.r = new int[i10];
        int i12 = 2;
        int iMax = Math.max(2, i10);
        this.s = new double[iMax];
        this.t = new double[iMax];
        int i13 = 0;
        for (int i14 = 1; i14 < length; i14++) {
            if (zArr[i14]) {
                this.r[i13] = i14;
                i13++;
            }
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, this.r.length);
        double[] dArr3 = new double[i5];
        for (int i15 = 0; i15 < i5; i15++) {
            hVarArr[i15].o(dArr2[i15], this.r);
            dArr3[i15] = hVarArr[i15].c;
        }
        int i16 = 0;
        while (true) {
            int[] iArr2 = this.r;
            if (i16 >= iArr2.length) {
                break;
            }
            int i17 = iArr2[i16];
            String[] strArr3 = h.t;
            if (i17 < strArr3.length) {
                String strConcat = String.valueOf(strArr3[i17]).concat(" [");
                for (int i18 = 0; i18 < i5; i18++) {
                    String strValueOf2 = String.valueOf(strConcat);
                    double d = dArr2[i18][i16];
                    StringBuilder sb = new StringBuilder(strValueOf2.length() + 24);
                    sb.append(strValueOf2);
                    sb.append(d);
                    strConcat = sb.toString();
                }
            }
            i16++;
        }
        this.k = new AbstractC6522Nw1[this.u.length + 1];
        int i19 = 0;
        while (true) {
            String[] strArr4 = this.u;
            if (i19 >= strArr4.length) {
                break;
            }
            String str9 = strArr4[i19];
            double[] dArr4 = null;
            int i20 = 0;
            int i21 = 0;
            double[][] dArr5 = null;
            while (i20 < i5) {
                if (hVarArr[i20].u(str9)) {
                    if (dArr5 == null) {
                        dArr4 = new double[i5];
                        int[] iArr3 = new int[i12];
                        iArr3[c] = hVarArr[i20].s(str9);
                        iArr3[0] = i5;
                        dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr3);
                    }
                    h hVar = hVarArr[i20];
                    dArr = dArr2;
                    dArr4[i21] = hVar.c;
                    hVar.r(str9, dArr5[i21], 0);
                    i21++;
                } else {
                    dArr = dArr2;
                }
                i20++;
                dArr2 = dArr;
                i12 = 2;
                c = 1;
            }
            i19++;
            this.k[i19] = AbstractC6522Nw1.a(this.f, Arrays.copyOf(dArr4, i21), (double[][]) Arrays.copyOf(dArr5, i21));
            dArr2 = dArr2;
            i12 = 2;
            c = 1;
        }
        this.k[0] = AbstractC6522Nw1.a(this.f, dArr3, dArr2);
        if (hVarArr[0].k != androidx.constraintlayout.motion.widget.a.f) {
            int[] iArr4 = new int[i5];
            double[] dArr6 = new double[i5];
            double[][] dArr7 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, 2);
            for (int i22 = 0; i22 < i5; i22++) {
                iArr4[i22] = hVarArr[i22].k;
                dArr6[i22] = r9.c;
                double[] dArr8 = dArr7[i22];
                dArr8[0] = r9.e;
                dArr8[1] = r9.f;
            }
            this.l = AbstractC6522Nw1.b(iArr4, dArr6, dArr7);
        }
        this.D = new HashMap();
        if (this.A != null) {
            Iterator it9 = hashSet3.iterator();
            float fS = Float.NaN;
            while (it9.hasNext()) {
                String str10 = (String) it9.next();
                AbstractC15999kX7 abstractC15999kX7F = AbstractC15999kX7.f(str10);
                if (abstractC15999kX7F != null) {
                    if (abstractC15999kX7F.e() && Float.isNaN(fS)) {
                        fS = s();
                    }
                    abstractC15999kX7F.c(str10);
                    this.D.put(str10, abstractC15999kX7F);
                }
            }
            Iterator it10 = this.A.iterator();
            while (it10.hasNext()) {
            }
            Iterator it11 = this.D.values().iterator();
            while (it11.hasNext()) {
                ((AbstractC15999kX7) it11.next()).d(fS);
            }
        }
    }

    public void J(g gVar) {
        this.g.C(gVar, gVar.g);
        this.h.C(gVar, gVar.h);
    }

    public void a(androidx.constraintlayout.motion.widget.a aVar) {
        this.A.add(aVar);
    }

    void b(ArrayList arrayList) {
        this.A.addAll(arrayList);
    }

    int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrH = this.k[0].h();
        if (iArr != null) {
            Iterator it = this.y.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = ((h) it.next()).p;
                i++;
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < dArrH.length; i3++) {
            this.k[0].d(dArrH[i3], this.s);
            this.g.p(dArrH[i3], this.r, this.s, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    void d(float[] fArr, int i) {
        double dA;
        float f = 1.0f;
        float f2 = 1.0f / (i - 1);
        HashMap map = this.C;
        MI6 mi6 = map == null ? null : (MI6) map.get("translationX");
        HashMap map2 = this.C;
        MI6 mi62 = map2 == null ? null : (MI6) map2.get("translationY");
        HashMap map3 = this.D;
        AbstractC15999kX7 abstractC15999kX7 = map3 == null ? null : (AbstractC15999kX7) map3.get("translationX");
        HashMap map4 = this.D;
        AbstractC15999kX7 abstractC15999kX72 = map4 != null ? (AbstractC15999kX7) map4.get("translationY") : null;
        int i2 = 0;
        while (i2 < i) {
            float fMin = i2 * f2;
            float f3 = this.o;
            float f4 = 0.0f;
            if (f3 != f) {
                float f5 = this.n;
                if (fMin < f5) {
                    fMin = 0.0f;
                }
                if (fMin > f5 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f5) * f3, f);
                }
            }
            float f6 = fMin;
            double d = f6;
            J22 j22 = this.g.a;
            Iterator it = this.y.iterator();
            float f7 = Float.NaN;
            while (it.hasNext()) {
                h hVar = (h) it.next();
                J22 j222 = hVar.a;
                double d2 = d;
                if (j222 != null) {
                    float f8 = hVar.c;
                    if (f8 < f6) {
                        f4 = f8;
                        j22 = j222;
                    } else if (Float.isNaN(f7)) {
                        f7 = hVar.c;
                    }
                }
                d = d2;
            }
            double d3 = d;
            if (j22 != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                dA = (((float) j22.a((f6 - f4) / r16)) * (f7 - f4)) + f4;
            } else {
                dA = d3;
            }
            this.k[0].d(dA, this.s);
            AbstractC6522Nw1 abstractC6522Nw1 = this.l;
            if (abstractC6522Nw1 != null) {
                double[] dArr = this.s;
                if (dArr.length > 0) {
                    abstractC6522Nw1.d(dA, dArr);
                }
            }
            int i3 = i2 * 2;
            int i4 = i2;
            this.g.p(dA, this.r, this.s, fArr, i3);
            if (abstractC15999kX7 != null) {
                fArr[i3] = fArr[i3] + abstractC15999kX7.a(f6);
            } else if (mi6 != null) {
                fArr[i3] = fArr[i3] + mi6.a(f6);
            }
            if (abstractC15999kX72 != null) {
                int i5 = i3 + 1;
                fArr[i5] = fArr[i5] + abstractC15999kX72.a(f6);
            } else if (mi62 != null) {
                int i6 = i3 + 1;
                fArr[i6] = fArr[i6] + mi62.a(f6);
            }
            i2 = i4 + 1;
            f = 1.0f;
        }
    }

    void e(float f, float[] fArr, int i) {
        this.k[0].d(g(f, null), this.s);
        this.g.t(this.r, this.s, fArr, i);
    }

    void f(boolean z) {
        AbstractC7637So3[] abstractC7637So3Arr;
        if (!"button".equals(OA1.d(this.b)) || (abstractC7637So3Arr = this.E) == null || abstractC7637So3Arr.length <= 0) {
            return;
        }
        AbstractC7637So3 abstractC7637So3 = abstractC7637So3Arr[0];
        throw null;
    }

    public int h() {
        return this.g.l;
    }

    public void i(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.k[0].d(d, dArr);
        this.k[0].g(d, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.g.q(d, this.r, dArr, fArr, dArr2, fArr2);
    }

    public float j() {
        return this.p;
    }

    public float k() {
        return this.q;
    }

    void l(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float fG = g(f, this.z);
        AbstractC6522Nw1[] abstractC6522Nw1Arr = this.k;
        int i = 0;
        if (abstractC6522Nw1Arr == null) {
            h hVar = this.h;
            float f4 = hVar.e;
            h hVar2 = this.g;
            float f5 = f4 - hVar2.e;
            float f6 = hVar.f - hVar2.f;
            float f7 = (hVar.g - hVar2.g) + f5;
            float f8 = (hVar.h - hVar2.h) + f6;
            fArr[0] = (f5 * (1.0f - f2)) + (f7 * f2);
            fArr[1] = (f6 * (1.0f - f3)) + (f8 * f3);
            return;
        }
        double d = fG;
        abstractC6522Nw1Arr[0].g(d, this.t);
        this.k[0].d(d, this.s);
        float f9 = this.z[0];
        while (true) {
            dArr = this.t;
            if (i >= dArr.length) {
                break;
            }
            dArr[i] = dArr[i] * f9;
            i++;
        }
        AbstractC6522Nw1 abstractC6522Nw1 = this.l;
        if (abstractC6522Nw1 == null) {
            this.g.A(f2, f3, fArr, this.r, dArr, this.s);
            return;
        }
        double[] dArr2 = this.s;
        if (dArr2.length > 0) {
            abstractC6522Nw1.d(d, dArr2);
            this.l.g(d, this.t);
            this.g.A(f2, f3, fArr, this.r, this.t, this.s);
        }
    }

    public int m() {
        int iMax = this.g.b;
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, ((h) it.next()).b);
        }
        return Math.max(iMax, this.h.b);
    }

    public float n() {
        return this.h.e;
    }

    public float o() {
        return this.h.f;
    }

    h q(int i) {
        return (h) this.y.get(i);
    }

    void r(float f, int i, int i2, float f2, float f3, float[] fArr) {
        float fG = g(f, this.z);
        HashMap map = this.C;
        MI6 mi6 = map == null ? null : (MI6) map.get("translationX");
        HashMap map2 = this.C;
        MI6 mi62 = map2 == null ? null : (MI6) map2.get("translationY");
        HashMap map3 = this.C;
        MI6 mi63 = map3 == null ? null : (MI6) map3.get("rotation");
        HashMap map4 = this.C;
        MI6 mi64 = map4 == null ? null : (MI6) map4.get("scaleX");
        HashMap map5 = this.C;
        MI6 mi65 = map5 == null ? null : (MI6) map5.get("scaleY");
        HashMap map6 = this.D;
        AbstractC15999kX7 abstractC15999kX7 = map6 == null ? null : (AbstractC15999kX7) map6.get("translationX");
        HashMap map7 = this.D;
        AbstractC15999kX7 abstractC15999kX72 = map7 == null ? null : (AbstractC15999kX7) map7.get("translationY");
        HashMap map8 = this.D;
        AbstractC15999kX7 abstractC15999kX73 = map8 == null ? null : (AbstractC15999kX7) map8.get("rotation");
        HashMap map9 = this.D;
        AbstractC15999kX7 abstractC15999kX74 = map9 == null ? null : (AbstractC15999kX7) map9.get("scaleX");
        HashMap map10 = this.D;
        AbstractC15999kX7 abstractC15999kX75 = map10 != null ? (AbstractC15999kX7) map10.get("scaleY") : null;
        C18900pR7 c18900pR7 = new C18900pR7();
        c18900pR7.b();
        c18900pR7.d(mi63, fG);
        c18900pR7.h(mi6, mi62, fG);
        c18900pR7.f(mi64, mi65, fG);
        c18900pR7.c(abstractC15999kX73, fG);
        c18900pR7.g(abstractC15999kX7, abstractC15999kX72, fG);
        c18900pR7.e(abstractC15999kX74, abstractC15999kX75, fG);
        AbstractC6522Nw1 abstractC6522Nw1 = this.l;
        if (abstractC6522Nw1 != null) {
            double[] dArr = this.s;
            if (dArr.length > 0) {
                double d = fG;
                abstractC6522Nw1.d(d, dArr);
                this.l.g(d, this.t);
                this.g.A(f2, f3, fArr, this.r, this.t, this.s);
            }
            c18900pR7.a(f2, f3, i, i2, fArr);
            return;
        }
        int i3 = 0;
        if (this.k == null) {
            h hVar = this.h;
            float f4 = hVar.e;
            h hVar2 = this.g;
            float f5 = f4 - hVar2.e;
            AbstractC15999kX7 abstractC15999kX76 = abstractC15999kX75;
            float f6 = hVar.f - hVar2.f;
            AbstractC15999kX7 abstractC15999kX77 = abstractC15999kX74;
            float f7 = (hVar.g - hVar2.g) + f5;
            float f8 = (hVar.h - hVar2.h) + f6;
            fArr[0] = (f5 * (1.0f - f2)) + (f7 * f2);
            fArr[1] = (f6 * (1.0f - f3)) + (f8 * f3);
            c18900pR7.b();
            c18900pR7.d(mi63, fG);
            c18900pR7.h(mi6, mi62, fG);
            c18900pR7.f(mi64, mi65, fG);
            c18900pR7.c(abstractC15999kX73, fG);
            c18900pR7.g(abstractC15999kX7, abstractC15999kX72, fG);
            c18900pR7.e(abstractC15999kX77, abstractC15999kX76, fG);
            c18900pR7.a(f2, f3, i, i2, fArr);
            return;
        }
        double dG = g(fG, this.z);
        this.k[0].g(dG, this.t);
        this.k[0].d(dG, this.s);
        float f9 = this.z[0];
        while (true) {
            double[] dArr2 = this.t;
            if (i3 >= dArr2.length) {
                this.g.A(f2, f3, fArr, this.r, dArr2, this.s);
                c18900pR7.a(f2, f3, i, i2, fArr);
                return;
            } else {
                dArr2[i3] = dArr2[i3] * f9;
                i3++;
            }
        }
    }

    public float t() {
        return this.g.e;
    }

    public String toString() {
        h hVar = this.g;
        float f = hVar.e;
        float f2 = hVar.f;
        h hVar2 = this.h;
        float f3 = hVar2.e;
        float f4 = hVar2.f;
        StringBuilder sb = new StringBuilder(88);
        sb.append(" start: x: ");
        sb.append(f);
        sb.append(" y: ");
        sb.append(f2);
        sb.append(" end: x: ");
        sb.append(f3);
        sb.append(" y: ");
        sb.append(f4);
        return sb.toString();
    }

    public float u() {
        return this.g.f;
    }

    public View v() {
        return this.b;
    }

    boolean x(View view, float f, long j, C17935no3 c17935no3) {
        boolean zI;
        QX7.d dVar;
        int i;
        double d;
        int i2;
        float fG = g(f, null);
        int i3 = this.I;
        if (i3 != androidx.constraintlayout.motion.widget.a.f) {
            float f2 = 1.0f / i3;
            float fFloor = ((float) Math.floor(fG / f2)) * f2;
            float f3 = (fG % f2) / f2;
            if (!Float.isNaN(this.J)) {
                f3 = (f3 + this.J) % 1.0f;
            }
            Interpolator interpolator = this.K;
            fG = ((interpolator != null ? interpolator.getInterpolation(f3) : ((double) f3) > 0.5d ? 1.0f : 0.0f) * f2) + fFloor;
        }
        float f4 = fG;
        HashMap map = this.C;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((GX7) it.next()).h(view, f4);
            }
        }
        HashMap map2 = this.B;
        if (map2 != null) {
            boolean zH = false;
            dVar = null;
            for (QX7 qx7 : map2.values()) {
                if (qx7 instanceof QX7.d) {
                    dVar = (QX7.d) qx7;
                } else {
                    zH |= qx7.h(view, f4, j, c17935no3);
                }
            }
            zI = zH;
        } else {
            zI = false;
            dVar = null;
        }
        AbstractC6522Nw1[] abstractC6522Nw1Arr = this.k;
        if (abstractC6522Nw1Arr != null) {
            double d2 = f4;
            abstractC6522Nw1Arr[0].d(d2, this.s);
            this.k[0].g(d2, this.t);
            AbstractC6522Nw1 abstractC6522Nw1 = this.l;
            if (abstractC6522Nw1 != null) {
                double[] dArr = this.s;
                if (dArr.length > 0) {
                    abstractC6522Nw1.d(d2, dArr);
                    this.l.g(d2, this.t);
                }
            }
            if (this.L) {
                d = d2;
                i2 = 1;
            } else {
                d = d2;
                i2 = 1;
                this.g.B(f4, view, this.r, this.s, this.t, null, this.d);
                this.d = false;
            }
            if (this.G != androidx.constraintlayout.motion.widget.a.f) {
                if (this.H == null) {
                    this.H = ((View) view.getParent()).findViewById(this.G);
                }
                if (this.H != null) {
                    float top = (r1.getTop() + this.H.getBottom()) / 2.0f;
                    float left = (this.H.getLeft() + this.H.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view.setPivotX(left - view.getLeft());
                        view.setPivotY(top - view.getTop());
                    }
                }
            }
            HashMap map3 = this.C;
            if (map3 != null) {
                for (MI6 mi6 : map3.values()) {
                    if (mi6 instanceof GX7.d) {
                        double[] dArr2 = this.t;
                        if (dArr2.length > i2) {
                            ((GX7.d) mi6).i(view, f4, dArr2[0], dArr2[i2]);
                        }
                    }
                }
            }
            if (dVar != null) {
                double[] dArr3 = this.t;
                double d3 = dArr3[0];
                double d4 = dArr3[i2];
                i = 0;
                zI |= dVar.i(view, c17935no3, f4, j, d3, d4);
            } else {
                i = 0;
            }
            int i4 = 1;
            while (true) {
                AbstractC6522Nw1[] abstractC6522Nw1Arr2 = this.k;
                if (i4 >= abstractC6522Nw1Arr2.length) {
                    break;
                }
                abstractC6522Nw1Arr2[i4].e(d, this.x);
                ((androidx.constraintlayout.widget.a) this.g.o.get(this.u[i4 - 1])).i(view, this.x);
                i4++;
            }
            f fVar = this.i;
            if (fVar.b == 0) {
                if (f4 <= 0.0f) {
                    view.setVisibility(fVar.c);
                } else if (f4 >= 1.0f) {
                    view.setVisibility(this.j.c);
                } else if (this.j.c != fVar.c) {
                    view.setVisibility(i);
                }
            }
            AbstractC7637So3[] abstractC7637So3Arr = this.E;
            if (abstractC7637So3Arr != null && abstractC7637So3Arr.length > 0) {
                AbstractC7637So3 abstractC7637So3 = abstractC7637So3Arr[i];
                throw null;
            }
        } else {
            i = 0;
            h hVar = this.g;
            float f5 = hVar.e;
            h hVar2 = this.h;
            float f6 = f5 + ((hVar2.e - f5) * f4);
            float f7 = hVar.f;
            float f8 = f7 + ((hVar2.f - f7) * f4);
            float f9 = hVar.g;
            float f10 = hVar2.g;
            float f11 = hVar.h;
            float f12 = hVar2.h;
            float f13 = f6 + 0.5f;
            int i5 = (int) f13;
            float f14 = f8 + 0.5f;
            int i6 = (int) f14;
            int i7 = (int) (f13 + ((f10 - f9) * f4) + f9);
            int i8 = (int) (f14 + ((f12 - f11) * f4) + f11);
            int i9 = i7 - i5;
            int i10 = i8 - i6;
            if (f10 != f9 || f12 != f11 || this.d) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
                this.d = false;
            }
            view.layout(i5, i6, i7, i8);
        }
        HashMap map4 = this.D;
        if (map4 != null) {
            for (AbstractC15999kX7 abstractC15999kX7 : map4.values()) {
                if (abstractC15999kX7 instanceof AbstractC15999kX7.d) {
                    double[] dArr4 = this.t;
                    ((AbstractC15999kX7.d) abstractC15999kX7).h(view, f4, dArr4[i], dArr4[1]);
                } else {
                    abstractC15999kX7.g(view, f4);
                }
            }
        }
        return zI;
    }

    public void z() {
        this.d = true;
    }
}
