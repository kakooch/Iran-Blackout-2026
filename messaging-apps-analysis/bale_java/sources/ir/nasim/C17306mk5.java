package ir.nasim;

import java.io.File;
import java.util.List;

/* renamed from: ir.nasim.mk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17306mk5 {
    public static final C17306mk5 a = new C17306mk5();

    /* renamed from: ir.nasim.mk5$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            File file = (File) this.e.invoke();
            String strQ = AbstractC12542en2.q(file);
            C3331Ak5 c3331Ak5 = C3331Ak5.a;
            if (AbstractC13042fc3.d(strQ, c3331Ak5.f())) {
                return file;
            }
            throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: " + c3331Ak5.f()).toString());
        }
    }

    private C17306mk5() {
    }

    public static /* synthetic */ InterfaceC23475wz1 b(C17306mk5 c17306mk5, KO5 ko5, List list, InterfaceC20315ro1 interfaceC20315ro1, SA2 sa2, int i, Object obj) {
        if ((i & 1) != 0) {
            ko5 = null;
        }
        if ((i & 2) != 0) {
            list = AbstractC10360bX0.m();
        }
        if ((i & 4) != 0) {
            interfaceC20315ro1 = AbstractC20906so1.a(C12366eV1.b().X(P17.b(null, 1, null)));
        }
        return c17306mk5.a(ko5, list, interfaceC20315ro1, sa2);
    }

    public final InterfaceC23475wz1 a(KO5 ko5, List list, InterfaceC20315ro1 interfaceC20315ro1, SA2 sa2) {
        AbstractC13042fc3.i(list, "migrations");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(sa2, "produceFile");
        return new C16124kk5(C24065xz1.a.a(C3331Ak5.a, ko5, list, interfaceC20315ro1, new a(sa2)));
    }
}
