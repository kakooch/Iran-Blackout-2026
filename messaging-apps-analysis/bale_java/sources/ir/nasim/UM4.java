package ir.nasim;

/* loaded from: classes3.dex */
public final class UM4 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public UM4(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static UM4 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new UM4(interfaceC7720Sx5);
    }

    public static TM4 c(io.livekit.android.room.f fVar) {
        return new TM4(fVar);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public TM4 get() {
        return c((io.livekit.android.room.f) this.a.get());
    }
}
