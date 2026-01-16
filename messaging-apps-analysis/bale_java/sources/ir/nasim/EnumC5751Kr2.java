package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Kr2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC5751Kr2 implements InterfaceC5517Jr2 {
    public static final EnumC5751Kr2 a = new EnumC5751Kr2("Active", 0);
    public static final EnumC5751Kr2 b = new EnumC5751Kr2("ActiveParent", 1);
    public static final EnumC5751Kr2 c = new EnumC5751Kr2("Captured", 2);
    public static final EnumC5751Kr2 d = new EnumC5751Kr2("Inactive", 3);
    private static final /* synthetic */ EnumC5751Kr2[] e;
    private static final /* synthetic */ F92 f;

    /* renamed from: ir.nasim.Kr2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC5751Kr2.values().length];
            try {
                iArr[EnumC5751Kr2.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC5751Kr2.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC5751Kr2.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC5751Kr2.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static {
        EnumC5751Kr2[] enumC5751Kr2ArrP = p();
        e = enumC5751Kr2ArrP;
        f = G92.a(enumC5751Kr2ArrP);
    }

    private EnumC5751Kr2(String str, int i) {
    }

    private static final /* synthetic */ EnumC5751Kr2[] p() {
        return new EnumC5751Kr2[]{a, b, c, d};
    }

    public static EnumC5751Kr2 valueOf(String str) {
        return (EnumC5751Kr2) Enum.valueOf(EnumC5751Kr2.class, str);
    }

    public static EnumC5751Kr2[] values() {
        return (EnumC5751Kr2[]) e.clone();
    }

    @Override // ir.nasim.InterfaceC5517Jr2
    public boolean a() {
        int i = a.a[ordinal()];
        if (i == 1 || i == 2) {
            return true;
        }
        if (i == 3 || i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ir.nasim.InterfaceC5517Jr2
    public boolean j() {
        int i = a.a[ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return true;
        }
        if (i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}
