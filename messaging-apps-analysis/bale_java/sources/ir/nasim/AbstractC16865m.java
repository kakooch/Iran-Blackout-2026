package ir.nasim;

import android.graphics.drawable.Drawable;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16865m {
    private static final NE1 a = new NE1(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32767, null);

    /* renamed from: ir.nasim.m$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC18478oj5.values().length];
            try {
                iArr[EnumC18478oj5.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18478oj5.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC18478oj5.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final boolean a(W23 w23) {
        int i = a.a[w23.H().ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (w23.q().m() != null || !(w23.K() instanceof DV1)) {
                w23.M();
                return false;
            }
        }
        return true;
    }

    public static final NE1 b() {
        return a;
    }

    public static final Drawable c(W23 w23, Drawable drawable, Integer num, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        return AbstractC12665f.a(w23.l(), num.intValue());
    }
}
