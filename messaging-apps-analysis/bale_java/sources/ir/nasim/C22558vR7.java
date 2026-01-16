package ir.nasim;

/* renamed from: ir.nasim.vR7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22558vR7 extends AbstractC3914Cw7 {
    private final String a;

    public C22558vR7(String str) {
        super(null);
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C22558vR7) && AbstractC13042fc3.d(this.a, ((C22558vR7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "VerbatimTtsAnnotation(verbatim=" + this.a + ')';
    }
}
