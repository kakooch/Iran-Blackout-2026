package ir.nasim;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* renamed from: ir.nasim.Rf4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7323Rf4 {
    private static final PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean d(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    private static int e(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    static int f(float f, float f2) {
        return g((int) f, (int) f2);
    }

    private static int g(int i, int i2) {
        return i - (i2 * e(i, i2));
    }

    public static void h(C14465hx6 c14465hx6, Path path) {
        path.reset();
        PointF pointFB = c14465hx6.b();
        path.moveTo(pointFB.x, pointFB.y);
        a.set(pointFB.x, pointFB.y);
        for (int i = 0; i < c14465hx6.a().size(); i++) {
            C13267fw1 c13267fw1 = (C13267fw1) c14465hx6.a().get(i);
            PointF pointFA = c13267fw1.a();
            PointF pointFB2 = c13267fw1.b();
            PointF pointFC = c13267fw1.c();
            PointF pointF = a;
            if (pointFA.equals(pointF) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            pointF.set(pointFC.x, pointFC.y);
        }
        if (c14465hx6.d()) {
            path.close();
        }
    }

    public static float i(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int j(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static void k(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32, InterfaceC5491Jo3 interfaceC5491Jo3) {
        if (c5023Ho3.c(interfaceC5491Jo3.getName(), i)) {
            list.add(c5023Ho32.a(interfaceC5491Jo3.getName()).i(interfaceC5491Jo3));
        }
    }
}
