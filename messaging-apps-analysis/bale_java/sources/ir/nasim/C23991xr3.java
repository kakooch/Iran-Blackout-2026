package ir.nasim;

/* renamed from: ir.nasim.xr3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23991xr3 implements InterfaceC12258eJ1 {
    private final InterfaceC22805vr3 b;
    private final V53 c;
    private final boolean d;
    private final EnumC11615dJ1 e;

    public C23991xr3(InterfaceC22805vr3 interfaceC22805vr3, V53 v53, boolean z, EnumC11615dJ1 enumC11615dJ1) {
        AbstractC13042fc3.i(interfaceC22805vr3, "binaryClass");
        AbstractC13042fc3.i(enumC11615dJ1, "abiStability");
        this.b = interfaceC22805vr3;
        this.c = v53;
        this.d = z;
        this.e = enumC11615dJ1;
    }

    @Override // ir.nasim.InterfaceC12258eJ1
    public String a() {
        return "Class '" + this.b.f().b().b() + '\'';
    }

    @Override // ir.nasim.JH6
    public KH6 b() {
        KH6 kh6 = KH6.a;
        AbstractC13042fc3.h(kh6, "NO_SOURCE_FILE");
        return kh6;
    }

    public final InterfaceC22805vr3 d() {
        return this.b;
    }

    public String toString() {
        return ((Object) C23991xr3.class.getSimpleName()) + ": " + this.b;
    }
}
