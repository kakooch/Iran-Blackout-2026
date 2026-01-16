package ir.nasim;

/* renamed from: ir.nasim.Sz5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7741Sz5 {
    public static final C7741Sz5 a = new C7741Sz5();

    private C7741Sz5() {
    }

    private final InterfaceC7977Tz5 b(C8445Vz5 c8445Vz5) {
        C11458d25 c11458d25U = c8445Vz5.u();
        if (c11458d25U == null) {
            return new UA7();
        }
        int peerId = c11458d25U.getPeerId();
        if (c8445Vz5.w() <= 0) {
            return new C13416gB4(c8445Vz5);
        }
        C14697iL2 c14697iL2 = (C14697iL2) AbstractC5969Lp4.b().o().d(peerId);
        return c14697iL2 == null ? new UA7() : new FJ0(c14697iL2);
    }

    public final InterfaceC7977Tz5 a(C8445Vz5 c8445Vz5) {
        C11458d25 c11458d25U;
        return (c8445Vz5 == null || (c11458d25U = c8445Vz5.u()) == null) ? new UA7() : c11458d25U.z() ? b(c8445Vz5) : new C13416gB4(c8445Vz5);
    }
}
