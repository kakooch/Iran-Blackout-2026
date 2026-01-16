package ir.nasim;

/* renamed from: ir.nasim.dW4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11735dW4 {
    private final InterfaceC12378eW4 a;
    private final int b;
    private final int c;

    public C11735dW4(InterfaceC12378eW4 interfaceC12378eW4, int i, int i2) {
        this.a = interfaceC12378eW4;
        this.b = i;
        this.c = i2;
    }

    public final int a() {
        return this.c;
    }

    public final InterfaceC12378eW4 b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11735dW4)) {
            return false;
        }
        C11735dW4 c11735dW4 = (C11735dW4) obj;
        return AbstractC13042fc3.d(this.a, c11735dW4.a) && this.b == c11735dW4.b && this.c == c11735dW4.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "ParagraphIntrinsicInfo(intrinsics=" + this.a + ", startIndex=" + this.b + ", endIndex=" + this.c + ')';
    }
}
