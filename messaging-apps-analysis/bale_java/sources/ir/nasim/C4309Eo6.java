package ir.nasim;

/* renamed from: ir.nasim.Eo6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4309Eo6 {
    private final InterfaceC19567qa2 a;
    private final JE2 b;

    public C4309Eo6(InterfaceC19567qa2 interfaceC19567qa2, JE2 je2) {
        AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
        AbstractC13042fc3.i(je2, "generateFileHashUseCase");
        this.a = interfaceC19567qa2;
        this.b = je2;
    }

    public final void a(long j, EnumC8893Xt7 enumC8893Xt7, long j2, long j3, String str) {
        AbstractC13042fc3.i(enumC8893Xt7, "origin");
        AbstractC13042fc3.i(str, "mimeTypes");
        this.a.a("download_traffic", AbstractC20051rO3.n(AbstractC4616Fw7.a("origin", Integer.valueOf(enumC8893Xt7.p())), AbstractC4616Fw7.a("file_hash", this.b.a(j2, j3)), AbstractC4616Fw7.a("file_mime_type", str), AbstractC4616Fw7.a("file_size", Long.valueOf(j))));
    }
}
