package ir.nasim;

import android.graphics.Rect;

/* loaded from: classes2.dex */
public final class Aa8 {
    private final C3565Bk0 a;

    public Aa8(C3565Bk0 c3565Bk0) {
        AbstractC13042fc3.i(c3565Bk0, "_bounds");
        this.a = c3565Bk0;
    }

    public final Rect a() {
        return this.a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !AbstractC13042fc3.d(Aa8.class, obj.getClass())) {
            return false;
        }
        return AbstractC13042fc3.d(this.a, ((Aa8) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Aa8(Rect rect) {
        this(new C3565Bk0(rect));
        AbstractC13042fc3.i(rect, "bounds");
    }
}
