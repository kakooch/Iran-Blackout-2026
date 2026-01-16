package ir.nasim;

/* renamed from: ir.nasim.Ba3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3478Ba3 {
    private int a;

    public C3478Ba3(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public final void b(int i) {
        this.a = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IntRef(element = ");
        sb.append(this.a);
        sb.append(")@");
        String string = Integer.toString(hashCode(), AbstractC10868cL0.a(16));
        AbstractC13042fc3.h(string, "toString(...)");
        sb.append(string);
        return sb.toString();
    }

    public /* synthetic */ C3478Ba3(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
