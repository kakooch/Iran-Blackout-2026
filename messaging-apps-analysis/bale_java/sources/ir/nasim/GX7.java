package ir.nasim;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class GX7 extends MI6 {

    static class a extends GX7 {
        a() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setAlpha(a(f));
        }
    }

    public static class b extends GX7 {
        String f;
        SparseArray g;
        float[] h;

        public b(String str, SparseArray sparseArray) {
            this.f = str.split(",")[1];
            this.g = sparseArray;
        }

        @Override // ir.nasim.MI6
        public void c(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // ir.nasim.MI6
        public void e(int i) {
            int size = this.g.size();
            int iF = ((androidx.constraintlayout.widget.a) this.g.valueAt(0)).f();
            double[] dArr = new double[size];
            this.h = new float[iF];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iF);
            for (int i2 = 0; i2 < size; i2++) {
                int iKeyAt = this.g.keyAt(i2);
                androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) this.g.valueAt(i2);
                dArr[i2] = iKeyAt * 0.01d;
                aVar.d(this.h);
                int i3 = 0;
                while (true) {
                    if (i3 < this.h.length) {
                        dArr2[i2][i3] = r6[i3];
                        i3++;
                    }
                }
            }
            this.a = AbstractC6522Nw1.a(i, dArr, dArr2);
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            this.a.e(f, this.h);
            ((androidx.constraintlayout.widget.a) this.g.valueAt(0)).i(view, this.h);
        }

        public void i(int i, androidx.constraintlayout.widget.a aVar) {
            this.g.append(i, aVar);
        }
    }

    static class c extends GX7 {
        c() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setElevation(a(f));
        }
    }

    static class e extends GX7 {
        e() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setPivotX(a(f));
        }
    }

    static class f extends GX7 {
        f() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setPivotY(a(f));
        }
    }

    static class g extends GX7 {
        boolean f = false;

        g() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f));
                return;
            }
            if (this.f) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f)));
                } catch (IllegalAccessException e) {
                    Log.e("ViewSpline", "unable to setProgress", e);
                } catch (InvocationTargetException e2) {
                    Log.e("ViewSpline", "unable to setProgress", e2);
                }
            }
        }
    }

    static class h extends GX7 {
        h() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setRotation(a(f));
        }
    }

    static class i extends GX7 {
        i() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setRotationX(a(f));
        }
    }

    static class j extends GX7 {
        j() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setRotationY(a(f));
        }
    }

    static class k extends GX7 {
        k() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setScaleX(a(f));
        }
    }

    static class l extends GX7 {
        l() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setScaleY(a(f));
        }
    }

    static class m extends GX7 {
        m() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setTranslationX(a(f));
        }
    }

    static class n extends GX7 {
        n() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setTranslationY(a(f));
        }
    }

    static class o extends GX7 {
        o() {
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
            view.setTranslationZ(a(f));
        }
    }

    public static GX7 f(String str, SparseArray sparseArray) {
        return new b(str, sparseArray);
    }

    public static GX7 g(String str) {
        str.hashCode();
        switch (str) {
        }
        return new a();
    }

    public abstract void h(View view, float f2);

    public static class d extends GX7 {
        public void i(View view, float f, double d, double d2) {
            view.setRotation(a(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // ir.nasim.GX7
        public void h(View view, float f) {
        }
    }
}
