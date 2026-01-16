package ir.nasim;

import ir.nasim.C4049Dl7;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.bo7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10560bo7 {

    /* renamed from: ir.nasim.bo7$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC12613eu3.values().length];
            try {
                iArr[EnumC12613eu3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC12613eu3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C23283wf5 b(C19620qf5 c19620qf5, C17847nf5 c17847nf5) {
        if (c19620qf5 == null && c17847nf5 == null) {
            return null;
        }
        return AbstractC15007ir.a(c19620qf5, c17847nf5);
    }

    public static final C9348Zn7 c(C9348Zn7 c9348Zn7, C9348Zn7 c9348Zn72, float f) {
        return new C9348Zn7(AbstractC13481gI6.c(c9348Zn7.N(), c9348Zn72.N(), f), AbstractC15987kW4.b(c9348Zn7.M(), c9348Zn72.M(), f));
    }

    public static final C9348Zn7 d(C9348Zn7 c9348Zn7, EnumC12613eu3 enumC12613eu3) {
        return new C9348Zn7(AbstractC13481gI6.h(c9348Zn7.y()), AbstractC15987kW4.e(c9348Zn7.v(), enumC12613eu3), c9348Zn7.w());
    }

    public static final int e(EnumC12613eu3 enumC12613eu3, int i) {
        C4049Dl7.a aVar = C4049Dl7.b;
        if (C4049Dl7.j(i, aVar.a())) {
            int i2 = a.a[enumC12613eu3.ordinal()];
            if (i2 == 1) {
                return aVar.b();
            }
            if (i2 == 2) {
                return aVar.c();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!C4049Dl7.j(i, aVar.f())) {
            return i;
        }
        int i3 = a.a[enumC12613eu3.ordinal()];
        if (i3 == 1) {
            return aVar.d();
        }
        if (i3 == 2) {
            return aVar.e();
        }
        throw new NoWhenBranchMatchedException();
    }
}
