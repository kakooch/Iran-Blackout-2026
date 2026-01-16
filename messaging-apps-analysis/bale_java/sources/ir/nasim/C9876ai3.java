package ir.nasim;

import java.util.Collection;

/* renamed from: ir.nasim.ai3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9876ai3 {
    private final C14645iF4 a;
    private final Collection b;
    private final boolean c;

    public C9876ai3(C14645iF4 c14645iF4, Collection collection, boolean z) {
        AbstractC13042fc3.i(c14645iF4, "nullabilityQualifier");
        AbstractC13042fc3.i(collection, "qualifierApplicabilityTypes");
        this.a = c14645iF4;
        this.b = collection;
        this.c = z;
    }

    public static /* synthetic */ C9876ai3 b(C9876ai3 c9876ai3, C14645iF4 c14645iF4, Collection collection, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            c14645iF4 = c9876ai3.a;
        }
        if ((i & 2) != 0) {
            collection = c9876ai3.b;
        }
        if ((i & 4) != 0) {
            z = c9876ai3.c;
        }
        return c9876ai3.a(c14645iF4, collection, z);
    }

    public final C9876ai3 a(C14645iF4 c14645iF4, Collection collection, boolean z) {
        AbstractC13042fc3.i(c14645iF4, "nullabilityQualifier");
        AbstractC13042fc3.i(collection, "qualifierApplicabilityTypes");
        return new C9876ai3(c14645iF4, collection, z);
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.a.c() == EnumC14043hF4.NOT_NULL && this.c;
    }

    public final C14645iF4 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9876ai3)) {
            return false;
        }
        C9876ai3 c9876ai3 = (C9876ai3) obj;
        return AbstractC13042fc3.d(this.a, c9876ai3.a) && AbstractC13042fc3.d(this.b, c9876ai3.b) && this.c == c9876ai3.c;
    }

    public final Collection f() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.a + ", qualifierApplicabilityTypes=" + this.b + ", affectsTypeParameterBasedTypes=" + this.c + ')';
    }

    public /* synthetic */ C9876ai3(C14645iF4 c14645iF4, Collection collection, boolean z, int i, ED1 ed1) {
        this(c14645iF4, collection, (i & 4) != 0 ? c14645iF4.c() == EnumC14043hF4.NOT_NULL : z);
    }
}
