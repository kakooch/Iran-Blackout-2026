package ir.nasim;

/* loaded from: classes.dex */
public abstract class R22 {
    private static final K22 a = new C11397cw1(0.25f, 0.1f, 0.25f, 1.0f);
    private static final K22 b = new C11397cw1(0.0f, 0.0f, 0.58f, 1.0f);
    private static final K22 c = new C11397cw1(0.42f, 0.0f, 1.0f, 1.0f);
    private static final K22 d = new C11397cw1(0.42f, 0.0f, 0.58f, 1.0f);
    private static final K22 e = new C11397cw1(0.12f, 0.0f, 0.39f, 0.0f);
    private static final K22 f = new C11397cw1(0.61f, 1.0f, 0.88f, 1.0f);
    private static final K22 g = new C11397cw1(0.37f, 0.0f, 0.63f, 1.0f);
    private static final K22 h = new C11397cw1(0.32f, 0.0f, 0.67f, 0.0f);
    private static final K22 i = new C11397cw1(0.33f, 1.0f, 0.68f, 1.0f);
    private static final K22 j = new C11397cw1(0.65f, 0.0f, 0.35f, 1.0f);
    private static final K22 k = new C11397cw1(0.64f, 0.0f, 0.78f, 0.0f);
    private static final K22 l = new C11397cw1(0.22f, 1.0f, 0.36f, 1.0f);
    private static final K22 m = new C11397cw1(0.83f, 0.0f, 0.17f, 1.0f);
    private static final K22 n = new C11397cw1(0.55f, 0.0f, 1.0f, 0.45f);
    private static final K22 o = new C11397cw1(0.0f, 0.55f, 0.45f, 1.0f);
    private static final K22 p = new C11397cw1(0.85f, 0.0f, 0.15f, 1.0f);
    private static final K22 q = new C11397cw1(0.11f, 0.0f, 0.5f, 0.0f);
    private static final K22 r = new C11397cw1(0.5f, 1.0f, 0.89f, 1.0f);
    private static final K22 s = new C11397cw1(0.45f, 0.0f, 0.55f, 1.0f);
    private static final K22 t = new C11397cw1(0.5f, 0.0f, 0.75f, 0.0f);
    private static final K22 u = new C11397cw1(0.25f, 1.0f, 0.5f, 1.0f);
    private static final K22 v = new C11397cw1(0.76f, 0.0f, 0.24f, 1.0f);
    private static final K22 w = new C11397cw1(0.7f, 0.0f, 0.84f, 0.0f);
    private static final K22 x = new C11397cw1(0.16f, 1.0f, 0.3f, 1.0f);
    private static final K22 y = new C11397cw1(0.87f, 0.0f, 0.13f, 1.0f);
    private static final K22 z = new C11397cw1(0.36f, 0.0f, 0.66f, -0.56f);
    private static final K22 A = new C11397cw1(0.34f, 1.56f, 0.64f, 1.0f);
    private static final K22 B = new C11397cw1(0.68f, -0.6f, 0.32f, 1.6f);
    private static final K22 C = new K22() { // from class: ir.nasim.L22
        @Override // ir.nasim.K22
        public final float a(float f2) {
            return R22.h(f2);
        }
    };
    private static final K22 D = new K22() { // from class: ir.nasim.M22
        @Override // ir.nasim.K22
        public final float a(float f2) {
            return R22.l(f2);
        }
    };
    private static final K22 E = new K22() { // from class: ir.nasim.N22
        @Override // ir.nasim.K22
        public final float a(float f2) {
            return R22.j(f2);
        }
    };
    private static final K22 F = new K22() { // from class: ir.nasim.O22
        @Override // ir.nasim.K22
        public final float a(float f2) {
            return R22.k(f2);
        }
    };
    private static final K22 G = new K22() { // from class: ir.nasim.P22
        @Override // ir.nasim.K22
        public final float a(float f2) {
            return R22.g(f2);
        }
    };
    private static final K22 H = new K22() { // from class: ir.nasim.Q22
        @Override // ir.nasim.K22
        public final float a(float f2) {
            return R22.i(f2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final float g(float f2) {
        return 1 - F.a(1.0f - f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        if (f2 == 1.0f) {
            return 1.0f;
        }
        float f3 = f2 * 10.0f;
        return (float) ((-((float) Math.pow(2.0f, f3 - 10.0f))) * Math.sin((f3 - 10.75f) * 2.0943951023931953d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float i(float f2) {
        return (((double) f2) < 0.5d ? 1 - F.a(1.0f - (f2 * 2.0f)) : 1 + F.a((f2 * 2.0f) - 1.0f)) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float j(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        if (f2 == 1.0f) {
            return 1.0f;
        }
        if (0.0f > f2 || f2 > 0.5f) {
            return ((float) ((((float) Math.pow(r8, ((-20.0f) * f2) + 10.0f)) * Math.sin(((f2 * 20.0f) - 11.125f) * 1.3962634015954636d)) / 2.0f)) + 1.0f;
        }
        float f3 = f2 * 20.0f;
        return (float) ((-(((float) Math.pow(r0, f3 - 10.0f)) * Math.sin((f3 - 11.125f) * 1.3962634015954636d))) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float k(float f2) {
        float f3;
        float f4;
        if (f2 < 0.36363637f) {
            return 7.5625f * f2 * f2;
        }
        if (f2 < 0.72727275f) {
            float f5 = f2 - 0.54545456f;
            f3 = 7.5625f * f5 * f5;
            f4 = 0.75f;
        } else if (f2 < 0.90909094f) {
            float f6 = f2 - 0.8181818f;
            f3 = 7.5625f * f6 * f6;
            f4 = 0.9375f;
        } else {
            float f7 = f2 - 0.95454544f;
            f3 = 7.5625f * f7 * f7;
            f4 = 0.984375f;
        }
        return f3 + f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float l(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        if (f2 == 1.0f) {
            return 1.0f;
        }
        return (float) ((((float) Math.pow(2.0f, (-10.0f) * f2)) * Math.sin(((f2 * 10.0f) - 0.75f) * 2.0943951023931953d)) + 1.0f);
    }

    public static final K22 m() {
        return i;
    }
}
