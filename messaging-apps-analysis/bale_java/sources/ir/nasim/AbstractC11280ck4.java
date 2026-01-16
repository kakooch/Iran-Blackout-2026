package ir.nasim;

import android.view.MotionEvent;

/* renamed from: ir.nasim.ck4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11280ck4 {
    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
