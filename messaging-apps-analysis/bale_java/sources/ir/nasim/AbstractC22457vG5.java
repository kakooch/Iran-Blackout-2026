package ir.nasim;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.vG5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22457vG5 {
    public static final void a(boolean z, Number number) {
        AbstractC13042fc3.i(number, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }

    public static InterfaceC10351bW0 b(float f, float f2) {
        return new C9757aW0(f, f2);
    }
}
