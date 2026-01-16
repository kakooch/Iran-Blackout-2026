package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ti6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21538ti6 {

    /* renamed from: ir.nasim.ti6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC20851si6.values().length];
            try {
                iArr[EnumC20851si6.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC20851si6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC20851si6.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final boolean a(EnumC20851si6 enumC20851si6, boolean z) {
        int i = a.a[enumC20851si6.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i == 3) {
            return z;
        }
        throw new NoWhenBranchMatchedException();
    }
}
