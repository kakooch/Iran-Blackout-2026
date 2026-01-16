package ir.nasim;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes2.dex */
public class Z2 {
    private final AccessibilityRecord a;

    public Z2(Object obj) {
        this.a = (AccessibilityRecord) obj;
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        accessibilityRecord.setMaxScrollX(i);
    }

    public static void c(AccessibilityRecord accessibilityRecord, int i) {
        accessibilityRecord.setMaxScrollY(i);
    }

    public static void d(AccessibilityRecord accessibilityRecord, View view, int i) {
        accessibilityRecord.setSource(view, i);
    }

    public void a(int i) {
        this.a.setFromIndex(i);
    }

    public void e(int i) {
        this.a.setToIndex(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Z2)) {
            return false;
        }
        Z2 z2 = (Z2) obj;
        AccessibilityRecord accessibilityRecord = this.a;
        return accessibilityRecord == null ? z2.a == null : accessibilityRecord.equals(z2.a);
    }

    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }
}
