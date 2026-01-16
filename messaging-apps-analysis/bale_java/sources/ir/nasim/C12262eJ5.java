package ir.nasim;

/* renamed from: ir.nasim.eJ5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C12262eJ5 {
    private InterfaceC3570Bk5 a;
    private DB3 b = KN6.l("recent_card_masks", C13466gH0.i);

    public C12262eJ5(InterfaceC3570Bk5 interfaceC3570Bk5) {
        this.a = interfaceC3570Bk5;
    }

    public static String c(long j) {
        return "RECENT_DEST_CARD_" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(byte[] bArr, C7234Qv5 c7234Qv5) {
        c7234Qv5.b(new OG0(bArr).d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(C7234Qv5 c7234Qv5) {
        try {
            c7234Qv5.b(this.b.k());
        } catch (Exception e) {
            c7234Qv5.a(e);
        }
    }

    public C6517Nv5 d(C13466gH0 c13466gH0) {
        if (c13466gH0 == null) {
            return C6517Nv5.F(new Exception("NULL_CardMaskInfo"));
        }
        final byte[] bArrA = this.a.a(c(c13466gH0.s()));
        if (bArrA != null) {
            return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.dJ5
                @Override // ir.nasim.InterfaceC6990Pv5
                public final void a(C7234Qv5 c7234Qv5) {
                    C12262eJ5.f(bArrA, c7234Qv5);
                }
            });
        }
        h(c13466gH0);
        return C6517Nv5.F(new Exception("LOSTEDRecent_CardMaskInfo"));
    }

    public C6517Nv5 e() {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.cJ5
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.g(c7234Qv5);
            }
        });
    }

    public C6517Nv5 h(C13466gH0 c13466gH0) {
        if (c13466gH0 == null) {
            return C6517Nv5.F(new Exception("NULL_CardMaskInfo"));
        }
        this.a.remove(c(c13466gH0.s()));
        this.b.b(c13466gH0.s());
        return C6517Nv5.l0(C14505i18.a);
    }
}
