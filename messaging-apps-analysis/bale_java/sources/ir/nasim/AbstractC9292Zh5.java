package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Zh5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC9292Zh5 {

    /* renamed from: ir.nasim.Zh5$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[EnumC9058Yh5.values().length];
            try {
                iArr[EnumC9058Yh5.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC9058Yh5.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC8283Vh5.values().length];
            try {
                iArr2[EnumC8283Vh5.PollType_SINGLECHOICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[EnumC8283Vh5.PollType_MULTIPLECHOICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC9567aB.values().length];
            try {
                iArr3[EnumC9567aB.SINGLECHOICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[EnumC9567aB.MULTIPLECHOICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            c = iArr3;
        }
    }

    public static final EnumC9058Yh5 a(EnumC9567aB enumC9567aB) {
        int i = enumC9567aB == null ? -1 : a.c[enumC9567aB.ordinal()];
        return i != 1 ? i != 2 ? EnumC9058Yh5.b : EnumC9058Yh5.a : EnumC9058Yh5.b;
    }

    public static final EnumC9567aB b(EnumC8283Vh5 enumC8283Vh5) {
        AbstractC13042fc3.i(enumC8283Vh5, "pollType");
        int i = a.b[enumC8283Vh5.ordinal()];
        return i != 1 ? i != 2 ? EnumC9567aB.UNSUPPORTED_VALUE : EnumC9567aB.MULTIPLECHOICE : EnumC9567aB.SINGLECHOICE;
    }

    public static final EnumC8283Vh5 c(EnumC9058Yh5 enumC9058Yh5) {
        AbstractC13042fc3.i(enumC9058Yh5, "pollType");
        int i = a.a[enumC9058Yh5.ordinal()];
        if (i == 1) {
            return EnumC8283Vh5.PollType_MULTIPLECHOICE;
        }
        if (i == 2) {
            return EnumC8283Vh5.PollType_SINGLECHOICE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
