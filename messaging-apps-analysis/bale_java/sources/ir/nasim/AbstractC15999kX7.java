package ir.nasim;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: ir.nasim.kX7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15999kX7 extends AbstractC19708qo3 {

    /* renamed from: ir.nasim.kX7$a */
    static class a extends AbstractC15999kX7 {
        a() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
            view.setAlpha(a(f));
        }
    }

    /* renamed from: ir.nasim.kX7$b */
    static class b extends AbstractC15999kX7 {
        float[] h = new float[1];
        protected androidx.constraintlayout.widget.a i;

        b() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            this.h[0] = a(f);
            this.i.i(view, this.h);
        }
    }

    /* renamed from: ir.nasim.kX7$c */
    static class c extends AbstractC15999kX7 {
        c() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
            view.setElevation(a(f));
        }
    }

    /* renamed from: ir.nasim.kX7$e */
    static class e extends AbstractC15999kX7 {
        boolean h = false;

        e() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f));
                return;
            }
            if (this.h) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.h = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f)));
                } catch (IllegalAccessException e) {
                    Log.e("ViewOscillator", "unable to setProgress", e);
                } catch (InvocationTargetException e2) {
                    Log.e("ViewOscillator", "unable to setProgress", e2);
                }
            }
        }
    }

    /* renamed from: ir.nasim.kX7$f */
    static class f extends AbstractC15999kX7 {
        f() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
            view.setRotation(a(f));
        }
    }

    /* renamed from: ir.nasim.kX7$g */
    static class g extends AbstractC15999kX7 {
        g() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
            view.setRotationX(a(f));
        }
    }

    /* renamed from: ir.nasim.kX7$h */
    static class h extends AbstractC15999kX7 {
        h() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
            view.setRotationY(a(f));
        }
    }

    /* renamed from: ir.nasim.kX7$i */
    static class i extends AbstractC15999kX7 {
        i() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
            view.setScaleX(a(f));
        }
    }

    /* renamed from: ir.nasim.kX7$j */
    static class j extends AbstractC15999kX7 {
        j() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
            view.setScaleY(a(f));
        }
    }

    /* renamed from: ir.nasim.kX7$k */
    static class k extends AbstractC15999kX7 {
        k() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
            view.setTranslationX(a(f));
        }
    }

    /* renamed from: ir.nasim.kX7$l */
    static class l extends AbstractC15999kX7 {
        l() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
            view.setTranslationY(a(f));
        }
    }

    /* renamed from: ir.nasim.kX7$m */
    static class m extends AbstractC15999kX7 {
        m() {
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
            view.setTranslationZ(a(f));
        }
    }

    public static AbstractC15999kX7 f(String str) {
        if (str.startsWith("CUSTOM")) {
            return new b();
        }
        switch (str) {
            case "rotationX":
                return new g();
            case "rotationY":
                return new h();
            case "translationX":
                return new k();
            case "translationY":
                return new l();
            case "translationZ":
                return new m();
            case "progress":
                return new e();
            case "scaleX":
                return new i();
            case "scaleY":
                return new j();
            case "waveVariesBy":
                return new a();
            case "rotation":
                return new f();
            case "elevation":
                return new c();
            case "transitionPathRotate":
                return new d();
            case "alpha":
                return new a();
            case "waveOffset":
                return new a();
            default:
                return null;
        }
    }

    public abstract void g(View view, float f2);

    /* renamed from: ir.nasim.kX7$d */
    public static class d extends AbstractC15999kX7 {
        public void h(View view, float f, double d, double d2) {
            view.setRotation(a(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // ir.nasim.AbstractC15999kX7
        public void g(View view, float f) {
        }
    }
}
