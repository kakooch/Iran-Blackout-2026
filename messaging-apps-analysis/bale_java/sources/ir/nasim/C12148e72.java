package ir.nasim;

/* renamed from: ir.nasim.e72, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C12148e72 implements W53 {
    private final boolean a;

    public C12148e72(boolean z) {
        this.a = z;
    }

    @Override // ir.nasim.W53
    public boolean b() {
        return this.a;
    }

    @Override // ir.nasim.W53
    public C10782cB4 c() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(b() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
