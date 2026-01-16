package ir.nasim;

import android.view.MotionEvent;

/* renamed from: ir.nasim.bh5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10488bh5 {
    public static final void a(long j, UA2 ua2) {
        MotionEvent motionEventObtain = MotionEvent.obtain(j, j, 3, 0.0f, 0.0f, 0);
        motionEventObtain.setSource(0);
        ua2.invoke(motionEventObtain);
        motionEventObtain.recycle();
    }

    public static final void b(C3534Bg5 c3534Bg5, long j, UA2 ua2) {
        d(c3534Bg5, j, ua2, true);
    }

    public static final void c(C3534Bg5 c3534Bg5, long j, UA2 ua2) {
        d(c3534Bg5, j, ua2, false);
    }

    private static final void d(C3534Bg5 c3534Bg5, long j, UA2 ua2, boolean z) {
        MotionEvent motionEventF = c3534Bg5.f();
        if (motionEventF == null) {
            throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
        }
        int action = motionEventF.getAction();
        if (z) {
            motionEventF.setAction(3);
        }
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        motionEventF.offsetLocation(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
        ua2.invoke(motionEventF);
        motionEventF.offsetLocation(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
        motionEventF.setAction(action);
    }
}
