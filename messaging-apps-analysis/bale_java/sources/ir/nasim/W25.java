package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class W25 {
    public static final W25 a = new W25("PRIVATE", 0);
    public static final W25 b = new W25("GROUP", 1);
    public static final W25 c = new W25("PRIVATE_ENCRYPTED", 2);
    private static final /* synthetic */ W25[] d;
    private static final /* synthetic */ F92 e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[W25.values().length];
            try {
                iArr[W25.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[W25.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[W25.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        W25[] w25ArrA = a();
        d = w25ArrA;
        e = G92.a(w25ArrA);
    }

    private W25(String str, int i) {
    }

    private static final /* synthetic */ W25[] a() {
        return new W25[]{a, b, c};
    }

    public static F92 j() {
        return e;
    }

    public static W25 valueOf(String str) {
        return (W25) Enum.valueOf(W25.class, str);
    }

    public static W25[] values() {
        return (W25[]) d.clone();
    }

    public final CA p() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return CA.GROUP;
        }
        if (i == 2) {
            return CA.PRIVATE;
        }
        if (i == 3) {
            return CA.ENCRYPTEDPRIVATE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final EnumC16311l35 q() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return EnumC16311l35.PeerType_GROUP;
        }
        if (i == 2) {
            return EnumC16311l35.PeerType_PRIVATE;
        }
        if (i == 3) {
            return EnumC16311l35.PeerType_ENCRYPTEDPRIVATE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
