package ir.nasim;

/* renamed from: ir.nasim.ag4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9857ag4 {
    private final EnumC20851si6 a;
    private final boolean b;

    public C9857ag4(EnumC20851si6 enumC20851si6, boolean z) {
        this.a = enumC20851si6;
        this.b = z;
    }

    public final EnumC20851si6 a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C9857ag4) && this.a == ((C9857ag4) obj).a;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public /* synthetic */ C9857ag4(boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? true : z);
    }

    public C9857ag4(boolean z) {
        this(EnumC20851si6.a, z);
    }
}
