package ir.nasim;

/* renamed from: ir.nasim.jT2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15367jT2 implements InterfaceC6873Pi5 {
    private final InterfaceC12529em a;
    private final InterfaceC12243eH4 b;
    private long c = ZG4.b.c();

    public C15367jT2(InterfaceC12529em interfaceC12529em, InterfaceC12243eH4 interfaceC12243eH4) {
        this.a = interfaceC12529em;
        this.b = interfaceC12243eH4;
    }

    @Override // ir.nasim.InterfaceC6873Pi5
    public long a(C25005za3 c25005za3, long j, EnumC12613eu3 enumC12613eu3, long j2) {
        long jA = this.b.a();
        if ((9223372034707292159L & jA) == 9205357640488583168L) {
            jA = this.c;
        }
        this.c = jA;
        return C22045ua3.o(C22045ua3.o(c25005za3.k(), AbstractC22635va3.d(jA)), this.a.a(j2, C4414Fa3.b.a(), enumC12613eu3));
    }
}
