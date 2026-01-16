package ir.nasim;

import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.wd2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23260wd2 {
    private static final Set a = AbstractC4597Fu6.i("image/jpeg", "image/webp", "image/heic", "image/heif");

    /* renamed from: ir.nasim.wd2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC19597qd2.values().length];
            try {
                iArr[EnumC19597qd2.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC19597qd2.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC19597qd2.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final boolean a(C16642ld2 c16642ld2) {
        return c16642ld2.a() > 0;
    }

    public static final boolean b(C16642ld2 c16642ld2) {
        return c16642ld2.a() == 90 || c16642ld2.a() == 270;
    }

    public static final boolean c(EnumC19597qd2 enumC19597qd2, String str) {
        int i = a.a[enumC19597qd2.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return false;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (str == null || !a.contains(str)) {
            return false;
        }
        return true;
    }
}
