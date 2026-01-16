package ir.nasim;

/* renamed from: ir.nasim.Ly1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C6046Ly1 extends VK6 {
    private final Object a;
    private final int b;

    public C6046Ly1(Object obj, int i) {
        super(null);
        this.a = obj;
        this.b = i;
    }

    public final void a() {
        Object obj = this.a;
        if (!((obj != null ? obj.hashCode() : 0) == this.b)) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }

    public final Object b() {
        return this.a;
    }
}
