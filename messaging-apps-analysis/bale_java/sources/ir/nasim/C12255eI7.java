package ir.nasim;

import ir.nasim.C13245fu;

/* renamed from: ir.nasim.eI7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12255eI7 implements C13245fu.a {
    private final String a;

    public C12255eI7(String str) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C12255eI7) && AbstractC13042fc3.d(this.a, ((C12255eI7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UrlAnnotation(url=" + this.a + ')';
    }
}
