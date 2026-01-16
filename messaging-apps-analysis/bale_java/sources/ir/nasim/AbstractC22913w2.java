package ir.nasim;

import android.view.accessibility.AccessibilityEvent;

/* renamed from: ir.nasim.w2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22913w2 {
    public static Z2 a(AccessibilityEvent accessibilityEvent) {
        return new Z2(accessibilityEvent);
    }

    public static int b(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void c(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }
}
