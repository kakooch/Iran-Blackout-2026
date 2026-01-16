package ir.nasim;

/* renamed from: ir.nasim.tv6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21668tv6 {
    private final int a;
    private final EnumC9185Yv6 b;
    private final CharSequence c;
    private final CharSequence d;
    private final int e;
    private final int f;
    private final int g;

    public C21668tv6(int i, EnumC9185Yv6 enumC9185Yv6, CharSequence charSequence, CharSequence charSequence2, int i2, int i3, int i4) {
        AbstractC13042fc3.i(enumC9185Yv6, "rowType");
        AbstractC13042fc3.i(charSequence, "title");
        AbstractC13042fc3.i(charSequence2, "subTitle");
        this.a = i;
        this.b = enumC9185Yv6;
        this.c = charSequence;
        this.d = charSequence2;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }

    public final int a() {
        return this.e;
    }

    public final int b() {
        return this.a;
    }

    public final EnumC9185Yv6 c() {
        return this.b;
    }

    public final CharSequence d() {
        return this.d;
    }

    public final CharSequence e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21668tv6)) {
            return false;
        }
        C21668tv6 c21668tv6 = (C21668tv6) obj;
        return this.a == c21668tv6.a && this.b == c21668tv6.b && AbstractC13042fc3.d(this.c, c21668tv6.c) && AbstractC13042fc3.d(this.d, c21668tv6.d) && this.e == c21668tv6.e && this.f == c21668tv6.f && this.g == c21668tv6.g;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g);
    }

    public String toString() {
        return this.c.toString();
    }

    public /* synthetic */ C21668tv6(int i, EnumC9185Yv6 enumC9185Yv6, CharSequence charSequence, CharSequence charSequence2, int i2, int i3, int i4, int i5, ED1 ed1) {
        this(i, enumC9185Yv6, (i5 & 4) != 0 ? "" : charSequence, (i5 & 8) != 0 ? "" : charSequence2, (i5 & 16) != 0 ? 0 : i2, (i5 & 32) != 0 ? 0 : i3, (i5 & 64) != 0 ? 0 : i4);
    }
}
