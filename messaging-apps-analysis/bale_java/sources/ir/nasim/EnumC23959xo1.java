package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.xo1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC23959xo1 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* renamed from: ir.nasim.xo1$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC23959xo1.values().length];
            try {
                iArr[EnumC23959xo1.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23959xo1.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC23959xo1.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC23959xo1.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public final void j(InterfaceC14603iB2 interfaceC14603iB2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        int i = a.a[ordinal()];
        if (i == 1) {
            NE0.d(interfaceC14603iB2, obj, interfaceC20295rm1, null, 4, null);
            return;
        }
        if (i == 2) {
            AbstractC23349wm1.b(interfaceC14603iB2, obj, interfaceC20295rm1);
        } else if (i == 3) {
            AbstractC13419gB7.a(interfaceC14603iB2, obj, interfaceC20295rm1);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean p() {
        return this == LAZY;
    }
}
