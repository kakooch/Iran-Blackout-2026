package ir.nasim;

import ai.bale.proto.WalletOuterClass$ResponseGetWalletChargeToken;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: ir.nasim.rK0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20012rK0 {
    private final C9057Yh4 a;
    private final C19482qQ7 b = new C19482qQ7("wallet_balance", 0L);

    public C20012rK0(final C9057Yh4 c9057Yh4) {
        this.a = c9057Yh4;
        c9057Yh4.Y().H().m0(new InterfaceC24449ye1() { // from class: ir.nasim.mK0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.l(c9057Yh4, (C14505i18) obj);
            }
        });
    }

    private void f(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ((W38) this.a.Y().E().n(str.hashCode())).d().f(new InterfaceC14756iQ7() { // from class: ir.nasim.pK0
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.j((ArrayList) obj, abstractC13554gQ7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(String str, long j, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5A = this.a.Y().A(str, Long.valueOf(j));
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5A.m0(new InterfaceC24449ye1() { // from class: ir.nasim.qK0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                interfaceC15419jZ0.a((WalletOuterClass$ResponseGetWalletChargeToken) obj);
            }
        }).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(ArrayList arrayList, AbstractC13554gQ7 abstractC13554gQ7) {
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
    public /* synthetic */ void k(String str, AbstractC13554gQ7 abstractC13554gQ7) {
        f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(C9057Yh4 c9057Yh4, C14505i18 c14505i18) {
        c9057Yh4.Y().B().f(new InterfaceC14756iQ7() { // from class: ir.nasim.nK0
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.k((String) obj, abstractC13554gQ7);
            }
        });
    }

    public InterfaceC14830iZ0 e(final String str, final long j) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.oK0
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.i(str, j, interfaceC15419jZ0);
            }
        };
    }

    public C19482qQ7 g() {
        return this.b;
    }

    public C19482qQ7 h() {
        return this.a.Y().B();
    }
}
