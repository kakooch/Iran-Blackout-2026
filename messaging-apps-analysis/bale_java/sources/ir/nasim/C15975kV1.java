package ir.nasim;

import android.graphics.Point;
import android.view.Display;

/* renamed from: ir.nasim.kV1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15975kV1 {
    public static final C15975kV1 a = new C15975kV1();

    private C15975kV1() {
    }

    public final void a(Display display, Point point) {
        AbstractC13042fc3.i(display, "display");
        AbstractC13042fc3.i(point, "point");
        display.getRealSize(point);
    }
}
