package ir.nasim;

import android.view.animation.Interpolator;

/* loaded from: classes3.dex */
public final class YU3 implements Interpolator {
    public static final a a = new a(null);
    private static final YU3 b = new YU3();

    public static final class a {
        private a() {
        }

        public final YU3 a() {
            return YU3.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        double d = f;
        return (float) (((6 * Math.pow(d, 2)) - (8 * ((float) Math.pow(d, r4)))) + (3 * Math.pow(d, 4.0d)));
    }
}
