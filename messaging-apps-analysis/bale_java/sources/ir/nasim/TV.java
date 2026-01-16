package ir.nasim;

import android.window.BackEvent;

/* loaded from: classes.dex */
public final class TV {
    public static final a e = new a(null);
    private final float a;
    private final float b;
    private final float c;
    private final int d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public TV(float f, float f2, float f3, int i) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = i;
    }

    public final float a() {
        return this.c;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.a + ", touchY=" + this.b + ", progress=" + this.c + ", swipeEdge=" + this.d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TV(BackEvent backEvent) {
        AbstractC13042fc3.i(backEvent, "backEvent");
        C20974sv c20974sv = C20974sv.a;
        this(c20974sv.d(backEvent), c20974sv.e(backEvent), c20974sv.b(backEvent), c20974sv.c(backEvent));
    }
}
