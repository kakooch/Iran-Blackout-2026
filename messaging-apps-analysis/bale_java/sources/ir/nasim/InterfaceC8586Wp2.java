package ir.nasim;

/* renamed from: ir.nasim.Wp2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC8586Wp2 extends InterfaceC5766Kt {
    default float b(float f, float f2, float f3) {
        return d(e(f, f2, f3), f, f2, f3);
    }

    float c(long j, float f, float f2, float f3);

    float d(long j, float f, float f2, float f3);

    long e(float f, float f2, float f3);

    @Override // ir.nasim.InterfaceC5766Kt
    default C12336eR7 a(InterfaceC5342Ix7 interfaceC5342Ix7) {
        return new C12336eR7(this);
    }
}
