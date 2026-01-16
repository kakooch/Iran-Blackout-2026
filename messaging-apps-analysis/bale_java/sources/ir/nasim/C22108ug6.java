package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ug6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22108ug6 implements InterfaceC14123hO3 {

    /* renamed from: ir.nasim.ug6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC20831sg6.values().length];
            try {
                iArr[EnumC20831sg6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC20831sg6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC20831sg6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EnumC19631qg6 a(EnumC20831sg6 enumC20831sg6) {
        AbstractC13042fc3.i(enumC20831sg6, "input");
        int i = a.a[enumC20831sg6.ordinal()];
        if (i == 1) {
            return EnumC19631qg6.a;
        }
        if (i == 2) {
            return EnumC19631qg6.b;
        }
        if (i == 3) {
            return EnumC19631qg6.c;
        }
        throw new NoWhenBranchMatchedException();
    }
}
