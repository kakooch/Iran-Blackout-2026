package ir.nasim;

import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public final class E02 extends AbstractC22144uk2 {
    private final Drawable a;
    private final boolean b;
    private final EnumC21699tz1 c;

    public E02(Drawable drawable, boolean z, EnumC21699tz1 enumC21699tz1) {
        super(null);
        this.a = drawable;
        this.b = z;
        this.c = enumC21699tz1;
    }

    public final EnumC21699tz1 a() {
        return this.c;
    }

    public final Drawable b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof E02) {
            E02 e02 = (E02) obj;
            if (AbstractC13042fc3.d(this.a, e02.a) && this.b == e02.b && this.c == e02.c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + this.c.hashCode();
    }
}
