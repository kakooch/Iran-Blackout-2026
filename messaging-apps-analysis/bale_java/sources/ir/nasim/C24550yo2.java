package ir.nasim;

/* renamed from: ir.nasim.yo2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24550yo2 {
    private final int a;
    private final int[] b;
    private final C12092e16[] c;

    public C24550yo2(int i, int[] iArr, int i2, int i3, int i4) {
        this.a = i;
        this.b = iArr;
        float f = i2;
        float f2 = i4;
        this.c = new C12092e16[]{new C12092e16(f, f2), new C12092e16(i3, f2)};
    }

    public C12092e16[] a() {
        return this.c;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C24550yo2) && this.a == ((C24550yo2) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
