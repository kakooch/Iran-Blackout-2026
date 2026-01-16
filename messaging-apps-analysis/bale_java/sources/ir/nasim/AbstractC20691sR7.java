package ir.nasim;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: ir.nasim.sR7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC20691sR7 {
    private static Map a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: ir.nasim.sR7$a */
    private static class a {
        static float a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getAxisVelocity(i);
        }

        static float b(VelocityTracker velocityTracker, int i, int i2) {
            return velocityTracker.getAxisVelocity(i, i2);
        }

        static boolean c(VelocityTracker velocityTracker, int i) {
            return velocityTracker.isAxisSupported(i);
        }
    }

    public static void a(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!a.containsKey(velocityTracker)) {
                a.put(velocityTracker, new C21311tR7());
            }
            ((C21311tR7) a.get(velocityTracker)).a(motionEvent);
        }
    }

    public static void b(VelocityTracker velocityTracker, int i) {
        c(velocityTracker, i, Float.MAX_VALUE);
    }

    public static void c(VelocityTracker velocityTracker, int i, float f) {
        velocityTracker.computeCurrentVelocity(i, f);
        C21311tR7 c21311tR7E = e(velocityTracker);
        if (c21311tR7E != null) {
            c21311tR7E.c(i, f);
        }
    }

    public static float d(VelocityTracker velocityTracker, int i) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(velocityTracker, i);
        }
        if (i == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i == 1) {
            return velocityTracker.getYVelocity();
        }
        C21311tR7 c21311tR7E = e(velocityTracker);
        if (c21311tR7E != null) {
            return c21311tR7E.d(i);
        }
        return 0.0f;
    }

    private static C21311tR7 e(VelocityTracker velocityTracker) {
        return (C21311tR7) a.get(velocityTracker);
    }
}
