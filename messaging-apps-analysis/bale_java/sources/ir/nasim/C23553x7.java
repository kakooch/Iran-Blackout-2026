package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.x7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C23553x7 implements InterfaceC23005wB2, Serializable {
    protected final Object a;
    private final Class b;
    private final String c;
    private final String d;
    private final boolean e;
    private final int f;
    private final int g;

    public C23553x7(int i, Class cls, String str, String str2, int i2) {
        this(i, AbstractC15785kA0.NO_RECEIVER, cls, str, str2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23553x7)) {
            return false;
        }
        C23553x7 c23553x7 = (C23553x7) obj;
        return this.e == c23553x7.e && this.f == c23553x7.f && this.g == c23553x7.g && AbstractC13042fc3.d(this.a, c23553x7.a) && AbstractC13042fc3.d(this.b, c23553x7.b) && this.c.equals(c23553x7.c) && this.d.equals(c23553x7.d);
    }

    @Override // ir.nasim.InterfaceC23005wB2
    public int getArity() {
        return this.f;
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.b;
        return ((((((((((iHashCode + (cls != null ? cls.hashCode() : 0)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + (this.e ? 1231 : 1237)) * 31) + this.f) * 31) + this.g;
    }

    public String toString() {
        return AbstractC10882cM5.k(this);
    }

    public C23553x7(int i, Object obj, Class cls, String str, String str2, int i2) {
        this.a = obj;
        this.b = cls;
        this.c = str;
        this.d = str2;
        this.e = (i2 & 1) == 1;
        this.f = i;
        this.g = i2 >> 1;
    }
}
