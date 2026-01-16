package ir.nasim;

import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.sB1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20541sB1 {
    private final Drawable a;
    private final boolean b;

    public C20541sB1(Drawable drawable, boolean z) {
        this.a = drawable;
        this.b = z;
    }

    public final Drawable a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C20541sB1) {
            C20541sB1 c20541sB1 = (C20541sB1) obj;
            if (AbstractC13042fc3.d(this.a, c20541sB1.a) && this.b == c20541sB1.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }
}
