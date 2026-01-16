package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.fw3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13269fw3 {

    /* renamed from: ir.nasim.fw3$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4870Gx3.values().length];
            try {
                iArr[EnumC4870Gx3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC4870Gx3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC4870Gx3.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static InterfaceC9173Yu3 a(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "initializer");
        return new A47(sa2, null, 2, null);
    }

    public static InterfaceC9173Yu3 b(EnumC4870Gx3 enumC4870Gx3, SA2 sa2) {
        AbstractC13042fc3.i(enumC4870Gx3, "mode");
        AbstractC13042fc3.i(sa2, "initializer");
        int i = a.a[enumC4870Gx3.ordinal()];
        if (i == 1) {
            return new A47(sa2, null, 2, null);
        }
        if (i == 2) {
            return new C22394v96(sa2);
        }
        if (i == 3) {
            return new TB7(sa2);
        }
        throw new NoWhenBranchMatchedException();
    }
}
