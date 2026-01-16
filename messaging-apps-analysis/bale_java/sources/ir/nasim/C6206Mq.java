package ir.nasim;

/* renamed from: ir.nasim.Mq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6206Mq implements InterfaceC4953Hg5 {
    private final int b;

    public C6206Mq(int i) {
        this.b = i;
    }

    public final int a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C6206Mq.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIconType");
        return this.b == ((C6206Mq) obj).b;
    }

    public int hashCode() {
        return this.b;
    }

    public String toString() {
        return "AndroidPointerIcon(type=" + this.b + ')';
    }
}
