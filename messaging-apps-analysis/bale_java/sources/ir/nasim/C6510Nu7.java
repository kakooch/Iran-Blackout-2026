package ir.nasim;

import ai.bale.proto.WalletOuterClass$ResponseGetPaymentTokenByCard;
import ai.bale.proto.WalletOuterClass$ResponseVerifyQRCode;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: ir.nasim.Nu7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6510Nu7 {
    private C9057Yh4 a;
    private C19482qQ7 b = new C19482qQ7("wallet_balance", 0L);

    public C6510Nu7(final C9057Yh4 c9057Yh4) {
        this.a = c9057Yh4;
        c9057Yh4.Y().H().m0(new InterfaceC24449ye1() { // from class: ir.nasim.Du7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.m(c9057Yh4, (C14505i18) obj);
            }
        });
    }

    private void h(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ((W38) this.a.Y().E().n(str.hashCode())).d().f(new InterfaceC14756iQ7() { // from class: ir.nasim.Ku7
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.k((ArrayList) obj, abstractC13554gQ7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(ArrayList arrayList, AbstractC13554gQ7 abstractC13554gQ7) {
        long jQ = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            SW sw = (SW) arrayList.get(i);
            if (sw.r() == EnumC17422mw1.RIAL) {
                jQ = sw.q();
            }
        }
        this.b.i(Long.valueOf(jQ));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(String str, AbstractC13554gQ7 abstractC13554gQ7) {
        h(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(C9057Yh4 c9057Yh4, C14505i18 c14505i18) {
        c9057Yh4.Y().B().f(new InterfaceC14756iQ7() { // from class: ir.nasim.Hu7
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.l((String) obj, abstractC13554gQ7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(String str, C11458d25 c11458d25, long j, long j2, Long l, String str2, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5I = this.a.Y().I(str, c11458d25, j, j2, l, str2);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5I.m0(new C6016Lu7(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(String str, long j, String str2, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5C = this.a.Y().C(str, Long.valueOf(j), str2);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5C.m0(new InterfaceC24449ye1() { // from class: ir.nasim.Mu7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                interfaceC15419jZ0.a((WalletOuterClass$ResponseGetPaymentTokenByCard) obj);
            }
        }).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(String str, String str2, long j, EnumC17422mw1 enumC17422mw1, String str3, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5J = this.a.Y().J(str, str2, Long.valueOf(j), enumC17422mw1, str3);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5J.m0(new C6016Lu7(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(String str, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5M = this.a.Y().M(str);
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5M.m0(new InterfaceC24449ye1() { // from class: ir.nasim.Iu7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                interfaceC15419jZ0.a((WalletOuterClass$ResponseVerifyQRCode) obj);
            }
        }).E(new C12454ee4(interfaceC15419jZ0));
    }

    public C19482qQ7 i() {
        return this.b;
    }

    public C19482qQ7 j() {
        return this.a.Y().B();
    }

    public InterfaceC14830iZ0 r(final String str, final C11458d25 c11458d25, final long j, final long j2, final Long l, final String str2) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Fu7
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.n(str, c11458d25, j, j2, l, str2, interfaceC15419jZ0);
            }
        };
    }

    public InterfaceC14830iZ0 s(final String str, final long j, final String str2) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Gu7
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.o(str, j, str2, interfaceC15419jZ0);
            }
        };
    }

    public InterfaceC14830iZ0 t(final String str, final String str2, final long j, final EnumC17422mw1 enumC17422mw1, final String str3) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Ju7
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.p(str, str2, j, enumC17422mw1, str3, interfaceC15419jZ0);
            }
        };
    }

    public InterfaceC14830iZ0 u(final String str) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Eu7
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.q(str, interfaceC15419jZ0);
            }
        };
    }
}
