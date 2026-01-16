package ir.nasim;

/* renamed from: ir.nasim.iF4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14645iF4 {
    private final EnumC14043hF4 a;
    private final boolean b;

    public C14645iF4(EnumC14043hF4 enumC14043hF4, boolean z) {
        AbstractC13042fc3.i(enumC14043hF4, "qualifier");
        this.a = enumC14043hF4;
        this.b = z;
    }

    public static /* synthetic */ C14645iF4 b(C14645iF4 c14645iF4, EnumC14043hF4 enumC14043hF4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC14043hF4 = c14645iF4.a;
        }
        if ((i & 2) != 0) {
            z = c14645iF4.b;
        }
        return c14645iF4.a(enumC14043hF4, z);
    }

    public final C14645iF4 a(EnumC14043hF4 enumC14043hF4, boolean z) {
        AbstractC13042fc3.i(enumC14043hF4, "qualifier");
        return new C14645iF4(enumC14043hF4, z);
    }

    public final EnumC14043hF4 c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14645iF4)) {
            return false;
        }
        C14645iF4 c14645iF4 = (C14645iF4) obj;
        return this.a == c14645iF4.a && this.b == c14645iF4.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.a + ", isForWarningOnly=" + this.b + ')';
    }

    public /* synthetic */ C14645iF4(EnumC14043hF4 enumC14043hF4, boolean z, int i, ED1 ed1) {
        this(enumC14043hF4, (i & 2) != 0 ? false : z);
    }
}
