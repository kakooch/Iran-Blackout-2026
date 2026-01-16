package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.c;
import ir.nasim.GX7;
import ir.nasim.J22;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
class f implements Comparable {
    static String[] G = {"position", "x", "y", "width", "height", "pathRotate"};
    int c;
    private J22 p;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float a = 1.0f;
    int b = 0;
    private boolean d = false;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    public float h = 0.0f;
    private float i = 1.0f;
    private float j = 1.0f;
    private float k = Float.NaN;
    private float l = Float.NaN;
    private float m = 0.0f;
    private float n = 0.0f;
    private float o = 0.0f;
    private int q = 0;
    private float w = Float.NaN;
    private float x = Float.NaN;
    private int y = -1;
    LinkedHashMap z = new LinkedHashMap();
    int A = 0;
    double[] B = new double[18];
    double[] D = new double[18];

    private boolean o(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(HashMap map, int i) {
        for (String str : map.keySet()) {
            GX7 gx7 = (GX7) map.get(str);
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c = '\r';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    gx7.c(i, Float.isNaN(this.g) ? 0.0f : this.g);
                    break;
                case 1:
                    gx7.c(i, Float.isNaN(this.h) ? 0.0f : this.h);
                    break;
                case 2:
                    gx7.c(i, Float.isNaN(this.m) ? 0.0f : this.m);
                    break;
                case 3:
                    gx7.c(i, Float.isNaN(this.n) ? 0.0f : this.n);
                    break;
                case 4:
                    gx7.c(i, Float.isNaN(this.o) ? 0.0f : this.o);
                    break;
                case 5:
                    gx7.c(i, Float.isNaN(this.x) ? 0.0f : this.x);
                    break;
                case 6:
                    gx7.c(i, Float.isNaN(this.i) ? 1.0f : this.i);
                    break;
                case 7:
                    gx7.c(i, Float.isNaN(this.j) ? 1.0f : this.j);
                    break;
                case '\b':
                    gx7.c(i, Float.isNaN(this.k) ? 0.0f : this.k);
                    break;
                case '\t':
                    gx7.c(i, Float.isNaN(this.l) ? 0.0f : this.l);
                    break;
                case '\n':
                    gx7.c(i, Float.isNaN(this.f) ? 0.0f : this.f);
                    break;
                case 11:
                    gx7.c(i, Float.isNaN(this.e) ? 0.0f : this.e);
                    break;
                case '\f':
                    gx7.c(i, Float.isNaN(this.w) ? 0.0f : this.w);
                    break;
                case '\r':
                    gx7.c(i, Float.isNaN(this.a) ? 1.0f : this.a);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.z.containsKey(str2)) {
                            androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) this.z.get(str2);
                            if (gx7 instanceof GX7.b) {
                                ((GX7.b) gx7).i(i, aVar);
                                break;
                            } else {
                                float fC = aVar.c();
                                String strValueOf = String.valueOf(gx7);
                                StringBuilder sb = new StringBuilder(str.length() + 69 + strValueOf.length());
                                sb.append(str);
                                sb.append(" ViewSpline not a CustomSet frame = ");
                                sb.append(i);
                                sb.append(", value");
                                sb.append(fC);
                                sb.append(strValueOf);
                                Log.e("MotionPaths", sb.toString());
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        Log.e("MotionPaths", str.length() != 0 ? "UNKNOWN spline ".concat(str) : new String("UNKNOWN spline "));
                        break;
                    }
            }
        }
    }

    public void h(View view) {
        this.c = view.getVisibility();
        this.a = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.d = false;
        this.e = view.getElevation();
        this.f = view.getRotation();
        this.g = view.getRotationX();
        this.h = view.getRotationY();
        this.i = view.getScaleX();
        this.j = view.getScaleY();
        this.k = view.getPivotX();
        this.l = view.getPivotY();
        this.m = view.getTranslationX();
        this.n = view.getTranslationY();
        this.o = view.getTranslationZ();
    }

    public void i(c.a aVar) {
        c.d dVar = aVar.c;
        int i = dVar.c;
        this.b = i;
        int i2 = dVar.b;
        this.c = i2;
        this.a = (i2 == 0 || i != 0) ? dVar.d : 0.0f;
        c.e eVar = aVar.f;
        this.d = eVar.m;
        this.e = eVar.n;
        this.f = eVar.b;
        this.g = eVar.c;
        this.h = eVar.d;
        this.i = eVar.e;
        this.j = eVar.f;
        this.k = eVar.g;
        this.l = eVar.h;
        this.m = eVar.j;
        this.n = eVar.k;
        this.o = eVar.l;
        this.p = J22.c(aVar.d.d);
        c.C0078c c0078c = aVar.d;
        this.w = c0078c.i;
        this.q = c0078c.f;
        this.y = c0078c.b;
        this.x = aVar.c.e;
        for (String str : aVar.g.keySet()) {
            androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) aVar.g.get(str);
            if (aVar2.e()) {
                this.z.put(str, aVar2);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return Float.compare(this.r, fVar.r);
    }

    void p(f fVar, HashSet hashSet) {
        if (o(this.a, fVar.a)) {
            hashSet.add("alpha");
        }
        if (o(this.e, fVar.e)) {
            hashSet.add("elevation");
        }
        int i = this.c;
        int i2 = fVar.c;
        if (i != i2 && this.b == 0 && (i == 0 || i2 == 0)) {
            hashSet.add("alpha");
        }
        if (o(this.f, fVar.f)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.w) || !Float.isNaN(fVar.w)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.x) || !Float.isNaN(fVar.x)) {
            hashSet.add("progress");
        }
        if (o(this.g, fVar.g)) {
            hashSet.add("rotationX");
        }
        if (o(this.h, fVar.h)) {
            hashSet.add("rotationY");
        }
        if (o(this.k, fVar.k)) {
            hashSet.add("transformPivotX");
        }
        if (o(this.l, fVar.l)) {
            hashSet.add("transformPivotY");
        }
        if (o(this.i, fVar.i)) {
            hashSet.add("scaleX");
        }
        if (o(this.j, fVar.j)) {
            hashSet.add("scaleY");
        }
        if (o(this.m, fVar.m)) {
            hashSet.add("translationX");
        }
        if (o(this.n, fVar.n)) {
            hashSet.add("translationY");
        }
        if (o(this.o, fVar.o)) {
            hashSet.add("translationZ");
        }
    }

    void q(float f, float f2, float f3, float f4) {
        this.s = f;
        this.t = f2;
        this.u = f3;
        this.v = f4;
    }

    public void r(Rect rect, androidx.constraintlayout.widget.c cVar, int i, int i2) {
        q(rect.left, rect.top, rect.width(), rect.height());
        i(cVar.B(i2));
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                }
            }
            float f = this.f + 90.0f;
            this.f = f;
            if (f > 180.0f) {
                this.f = f - 360.0f;
                return;
            }
            return;
        }
        this.f -= 90.0f;
    }

    public void s(View view) {
        q(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        h(view);
    }
}
