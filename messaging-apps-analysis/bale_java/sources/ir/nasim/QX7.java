package ir.nasim;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class QX7 extends AbstractC11343cq7 {

    static class a extends QX7 {
        a() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            view.setAlpha(e(f, j, view, c17935no3));
            return this.h;
        }
    }

    public static class b extends QX7 {
        String l;
        SparseArray m;
        SparseArray n = new SparseArray();
        float[] o;
        float[] p;

        public b(String str, SparseArray sparseArray) {
            this.l = str.split(",")[1];
            this.m = sparseArray;
        }

        @Override // ir.nasim.AbstractC11343cq7
        public void d(int i) {
            int size = this.m.size();
            int iF = ((androidx.constraintlayout.widget.a) this.m.valueAt(0)).f();
            double[] dArr = new double[size];
            int i2 = iF + 2;
            this.o = new float[i2];
            this.p = new float[iF];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int iKeyAt = this.m.keyAt(i3);
                androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) this.m.valueAt(i3);
                float[] fArr = (float[]) this.n.valueAt(i3);
                dArr[i3] = iKeyAt * 0.01d;
                aVar.d(this.o);
                int i4 = 0;
                while (true) {
                    if (i4 < this.o.length) {
                        dArr2[i3][i4] = r8[i4];
                        i4++;
                    }
                }
                double[] dArr3 = dArr2[i3];
                dArr3[iF] = fArr[0];
                dArr3[iF + 1] = fArr[1];
            }
            this.a = AbstractC6522Nw1.a(i, dArr, dArr2);
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            this.a.e(f, this.o);
            float[] fArr = this.o;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - this.i;
            if (Float.isNaN(this.j)) {
                float fA = c17935no3.a(view, this.l, 0);
                this.j = fA;
                if (Float.isNaN(fA)) {
                    this.j = 0.0f;
                }
            }
            float f4 = (float) ((this.j + ((j2 * 1.0E-9d) * f2)) % 1.0d);
            this.j = f4;
            this.i = j;
            float fA2 = a(f4);
            this.h = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.p;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z = this.h;
                float f5 = this.o[i];
                this.h = z | (((double) f5) != 0.0d);
                fArr2[i] = (f5 * fA2) + f3;
                i++;
            }
            ((androidx.constraintlayout.widget.a) this.m.valueAt(0)).i(view, this.p);
            if (f2 != 0.0f) {
                this.h = true;
            }
            return this.h;
        }
    }

    static class c extends QX7 {
        c() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            view.setElevation(e(f, j, view, c17935no3));
            return this.h;
        }
    }

    public static class d extends QX7 {
        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            return this.h;
        }

        public boolean i(View view, C17935no3 c17935no3, float f, long j, double d, double d2) {
            view.setRotation(e(f, j, view, c17935no3) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            return this.h;
        }
    }

    static class e extends QX7 {
        boolean l = false;

        e() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(e(f, j, view, c17935no3));
            } else {
                if (this.l) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.l = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(e(f, j, view, c17935no3)));
                    } catch (IllegalAccessException e) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e2);
                    }
                }
            }
            return this.h;
        }
    }

    static class f extends QX7 {
        f() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            view.setRotation(e(f, j, view, c17935no3));
            return this.h;
        }
    }

    static class g extends QX7 {
        g() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            view.setRotationX(e(f, j, view, c17935no3));
            return this.h;
        }
    }

    static class h extends QX7 {
        h() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            view.setRotationY(e(f, j, view, c17935no3));
            return this.h;
        }
    }

    static class i extends QX7 {
        i() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            view.setScaleX(e(f, j, view, c17935no3));
            return this.h;
        }
    }

    static class j extends QX7 {
        j() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            view.setScaleY(e(f, j, view, c17935no3));
            return this.h;
        }
    }

    static class k extends QX7 {
        k() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            view.setTranslationX(e(f, j, view, c17935no3));
            return this.h;
        }
    }

    static class l extends QX7 {
        l() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            view.setTranslationY(e(f, j, view, c17935no3));
            return this.h;
        }
    }

    static class m extends QX7 {
        m() {
        }

        @Override // ir.nasim.QX7
        public boolean h(View view, float f, long j, C17935no3 c17935no3) {
            view.setTranslationZ(e(f, j, view, c17935no3));
            return this.h;
        }
    }

    public static QX7 f(String str, SparseArray sparseArray) {
        return new b(str, sparseArray);
    }

    public static QX7 g(String str, long j2) {
        QX7 gVar;
        str.hashCode();
        switch (str) {
            case "rotationX":
                gVar = new g();
                break;
            case "rotationY":
                gVar = new h();
                break;
            case "translationX":
                gVar = new k();
                break;
            case "translationY":
                gVar = new l();
                break;
            case "translationZ":
                gVar = new m();
                break;
            case "progress":
                gVar = new e();
                break;
            case "scaleX":
                gVar = new i();
                break;
            case "scaleY":
                gVar = new j();
                break;
            case "rotation":
                gVar = new f();
                break;
            case "elevation":
                gVar = new c();
                break;
            case "transitionPathRotate":
                gVar = new d();
                break;
            case "alpha":
                gVar = new a();
                break;
            default:
                return null;
        }
        gVar.b(j2);
        return gVar;
    }

    public float e(float f2, long j2, View view, C17935no3 c17935no3) {
        this.a.e(f2, this.g);
        float[] fArr = this.g;
        float f3 = fArr[1];
        if (f3 == 0.0f) {
            this.h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.j)) {
            float fA = c17935no3.a(view, this.f, 0);
            this.j = fA;
            if (Float.isNaN(fA)) {
                this.j = 0.0f;
            }
        }
        float f4 = (float) ((this.j + (((j2 - this.i) * 1.0E-9d) * f3)) % 1.0d);
        this.j = f4;
        c17935no3.b(view, this.f, 0, f4);
        this.i = j2;
        float f5 = this.g[0];
        float fA2 = (a(this.j) * f5) + this.g[2];
        this.h = (f5 == 0.0f && f3 == 0.0f) ? false : true;
        return fA2;
    }

    public abstract boolean h(View view, float f2, long j2, C17935no3 c17935no3);
}
