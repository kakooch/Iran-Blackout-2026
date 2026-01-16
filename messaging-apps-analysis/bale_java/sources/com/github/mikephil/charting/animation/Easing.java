package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;

/* loaded from: classes2.dex */
public class Easing {
    public static final EasingFunction Linear = new k();
    public static final EasingFunction EaseInQuad = new u();
    public static final EasingFunction EaseOutQuad = new v();
    public static final EasingFunction EaseInOutQuad = new w();
    public static final EasingFunction EaseInCubic = new x();
    public static final EasingFunction EaseOutCubic = new y();
    public static final EasingFunction EaseInOutCubic = new z();
    public static final EasingFunction EaseInQuart = new A();
    public static final EasingFunction EaseOutQuart = new B();
    public static final EasingFunction EaseInOutQuart = new C2015a();
    public static final EasingFunction EaseInSine = new C2016b();
    public static final EasingFunction EaseOutSine = new c();
    public static final EasingFunction EaseInOutSine = new d();
    public static final EasingFunction EaseInExpo = new e();
    public static final EasingFunction EaseOutExpo = new f();
    public static final EasingFunction EaseInOutExpo = new g();
    public static final EasingFunction EaseInCirc = new h();
    public static final EasingFunction EaseOutCirc = new i();
    public static final EasingFunction EaseInOutCirc = new j();
    public static final EasingFunction EaseInElastic = new l();
    public static final EasingFunction EaseOutElastic = new m();
    public static final EasingFunction EaseInOutElastic = new n();
    public static final EasingFunction EaseInBack = new o();
    public static final EasingFunction EaseOutBack = new p();
    public static final EasingFunction EaseInOutBack = new q();
    public static final EasingFunction EaseInBounce = new r();
    public static final EasingFunction EaseOutBounce = new s();
    public static final EasingFunction EaseInOutBounce = new t();

    static class A implements EasingFunction {
        A() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) Math.pow(f, 4.0d);
        }
    }

    static class B implements EasingFunction {
        B() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return -(((float) Math.pow(f - 1.0f, 4.0d)) - 1.0f);
        }
    }

    public interface EasingFunction extends TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        float getInterpolation(float f);
    }

    /* renamed from: com.github.mikephil.charting.animation.Easing$a, reason: case insensitive filesystem */
    static class C2015a implements EasingFunction {
        C2015a() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float fPow;
            float f2;
            float f3 = f * 2.0f;
            if (f3 < 1.0f) {
                fPow = (float) Math.pow(f3, 4.0d);
                f2 = 0.5f;
            } else {
                fPow = ((float) Math.pow(f3 - 2.0f, 4.0d)) - 2.0f;
                f2 = -0.5f;
            }
            return fPow * f2;
        }
    }

    /* renamed from: com.github.mikephil.charting.animation.Easing$b, reason: case insensitive filesystem */
    static class C2016b implements EasingFunction {
        C2016b() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (-((float) Math.cos(f * 1.5707963267948966d))) + 1.0f;
        }
    }

    static class c implements EasingFunction {
        c() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) Math.sin(f * 1.5707963267948966d);
        }
    }

    static class d implements EasingFunction {
        d() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (((float) Math.cos(f * 3.141592653589793d)) - 1.0f) * (-0.5f);
        }
    }

    static class e implements EasingFunction {
        e() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (f - 1.0f) * 10.0f);
        }
    }

    static class f implements EasingFunction {
        f() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (f + 1.0f) * (-10.0f)));
        }
    }

    static class g implements EasingFunction {
        g() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            return (f * 2.0f < 1.0f ? (float) Math.pow(2.0d, (r9 - 1.0f) * 10.0f) : (-((float) Math.pow(2.0d, (r9 - 1.0f) * (-10.0f)))) + 2.0f) * 0.5f;
        }
    }

    static class h implements EasingFunction {
        h() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return -(((float) Math.sqrt(1.0f - (f * f))) - 1.0f);
        }
    }

    static class i implements EasingFunction {
        i() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (float) Math.sqrt(1.0f - (f2 * f2));
        }
    }

    static class j implements EasingFunction {
        j() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float fSqrt;
            float f2;
            float f3 = f * 2.0f;
            if (f3 < 1.0f) {
                fSqrt = ((float) Math.sqrt(1.0f - (f3 * f3))) - 1.0f;
                f2 = -0.5f;
            } else {
                float f4 = f3 - 2.0f;
                fSqrt = ((float) Math.sqrt(1.0f - (f4 * f4))) + 1.0f;
                f2 = 0.5f;
            }
            return fSqrt * f2;
        }
    }

    static class k implements EasingFunction {
        k() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f;
        }
    }

    static class l implements EasingFunction {
        l() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            float f2 = f - 1.0f;
            return -(((float) Math.pow(2.0d, 10.0f * f2)) * ((float) Math.sin(((f2 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f)));
        }
    }

    static class m implements EasingFunction {
        m() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (-10.0f) * f)) * ((float) Math.sin(((f - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f))) + 1.0f;
        }
    }

    static class n implements EasingFunction {
        n() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            float f2 = f * 2.0f;
            if (f2 == 2.0f) {
                return 1.0f;
            }
            float fAsin = ((float) Math.asin(1.0d)) * 0.07161972f;
            if (f2 < 1.0f) {
                float f3 = f2 - 1.0f;
                return ((float) Math.pow(2.0d, 10.0f * f3)) * ((float) Math.sin(((f3 * 1.0f) - fAsin) * 6.2831855f * 2.2222223f)) * (-0.5f);
            }
            float f4 = f2 - 1.0f;
            return (((float) Math.pow(2.0d, (-10.0f) * f4)) * 0.5f * ((float) Math.sin(((f4 * 1.0f) - fAsin) * 6.2831855f * 2.2222223f))) + 1.0f;
        }
    }

    static class o implements EasingFunction {
        o() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f * f * ((f * 2.70158f) - 1.70158f);
        }
    }

    static class p implements EasingFunction {
        p() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * ((f2 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    }

    static class q implements EasingFunction {
        q() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                return f2 * f2 * ((3.5949094f * f2) - 2.5949094f) * 0.5f;
            }
            float f3 = f2 - 2.0f;
            return ((f3 * f3 * ((3.5949094f * f3) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    }

    static class r implements EasingFunction {
        r() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return 1.0f - Easing.EaseOutBounce.getInterpolation(1.0f - f);
        }
    }

    static class s implements EasingFunction {
        s() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f < 0.36363637f) {
                return 7.5625f * f * f;
            }
            if (f < 0.72727275f) {
                float f2 = f - 0.54545456f;
                return (7.5625f * f2 * f2) + 0.75f;
            }
            if (f < 0.90909094f) {
                float f3 = f - 0.8181818f;
                return (7.5625f * f3 * f3) + 0.9375f;
            }
            float f4 = f - 0.95454544f;
            return (7.5625f * f4 * f4) + 0.984375f;
        }
    }

    static class t implements EasingFunction {
        t() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f < 0.5f ? Easing.EaseInBounce.getInterpolation(f * 2.0f) * 0.5f : (Easing.EaseOutBounce.getInterpolation((f * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    }

    static class u implements EasingFunction {
        u() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f * f;
        }
    }

    static class v implements EasingFunction {
        v() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (-f) * (f - 2.0f);
        }
    }

    static class w implements EasingFunction {
        w() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                return 0.5f * f2 * f2;
            }
            float f3 = f2 - 1.0f;
            return ((f3 * (f3 - 2.0f)) - 1.0f) * (-0.5f);
        }
    }

    static class x implements EasingFunction {
        x() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) Math.pow(f, 3.0d);
        }
    }

    static class y implements EasingFunction {
        y() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return ((float) Math.pow(f - 1.0f, 3.0d)) + 1.0f;
        }
    }

    static class z implements EasingFunction {
        z() {
        }

        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f * 2.0f;
            return (f2 < 1.0f ? (float) Math.pow(f2, 3.0d) : ((float) Math.pow(f2 - 2.0f, 3.0d)) + 2.0f) * 0.5f;
        }
    }
}
