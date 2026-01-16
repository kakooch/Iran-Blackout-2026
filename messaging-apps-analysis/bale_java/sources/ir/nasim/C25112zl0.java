package ir.nasim;

import android.graphics.Rect;
import android.view.View;

/* renamed from: ir.nasim.zl0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C25112zl0 {
    private final View a;
    private final Rect b;
    private final int[] c;

    public C25112zl0(View view) {
        AbstractC13042fc3.i(view, "sensitiveView");
        this.a = view;
        this.b = new Rect();
        this.c = new int[2];
    }

    public final Rect a() {
        this.a.getLocationOnScreen(this.c);
        Rect rect = this.b;
        int[] iArr = this.c;
        int i = iArr[0];
        rect.set(i, iArr[1], this.a.getWidth() + i, this.c[1] + this.a.getHeight());
        return rect;
    }
}
