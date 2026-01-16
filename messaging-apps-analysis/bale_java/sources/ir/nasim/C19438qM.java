package ir.nasim;

import ir.nasim.AbstractC20029rM;
import ir.nasim.InterfaceC10876cM;
import ir.nasim.JA7;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.qM, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C19438qM {
    public static final C19438qM a = new C19438qM();

    /* renamed from: ir.nasim.qM$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC21915uM.values().length];
            try {
                iArr[EnumC21915uM.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC21915uM.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC21915uM.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC21915uM.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC20638sM.values().length];
            try {
                iArr2[EnumC20638sM.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC20638sM.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    private C19438qM() {
    }

    public final AbstractC20029rM a(EnumC20638sM enumC20638sM) {
        AbstractC13042fc3.i(enumC20638sM, "<this>");
        int i = a.b[enumC20638sM.ordinal()];
        if (i == 1) {
            return AbstractC20029rM.b.c;
        }
        if (i == 2) {
            return AbstractC20029rM.a.c;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final EnumC21241tM b(EnumC21915uM enumC21915uM) {
        AbstractC13042fc3.i(enumC21915uM, "<this>");
        int i = a.a[enumC21915uM.ordinal()];
        if (i == 1) {
            return EnumC21241tM.d;
        }
        if (i == 2) {
            return EnumC21241tM.e;
        }
        if (i == 3) {
            return EnumC21241tM.f;
        }
        if (i == 4) {
            return EnumC21241tM.g;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final JA7 c(InterfaceC10876cM interfaceC10876cM) {
        AbstractC13042fc3.i(interfaceC10876cM, "<this>");
        if (interfaceC10876cM instanceof InterfaceC10876cM.b) {
            InterfaceC10876cM.b bVar = (InterfaceC10876cM.b) interfaceC10876cM;
            return new JA7.b(bVar.f(), bVar.e());
        }
        if (!(interfaceC10876cM instanceof InterfaceC10876cM.a)) {
            throw new NoWhenBranchMatchedException();
        }
        InterfaceC10876cM.a aVar = (InterfaceC10876cM.a) interfaceC10876cM;
        return new JA7.a(aVar.f(), aVar.e());
    }

    public final KA7 d(C22505vM c22505vM) {
        AbstractC13042fc3.i(c22505vM, "<this>");
        return new KA7(b(c22505vM.e()), c(c22505vM.c()), a(c22505vM.d()));
    }
}
