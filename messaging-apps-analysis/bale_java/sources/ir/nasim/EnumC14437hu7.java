package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.hu7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC14437hu7 {
    public static final EnumC14437hu7 a = new EnumC14437hu7("Deposit", 0);
    public static final EnumC14437hu7 b = new EnumC14437hu7("Withdraw", 1);
    private static final /* synthetic */ EnumC14437hu7[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC14437hu7[] enumC14437hu7ArrA = a();
        c = enumC14437hu7ArrA;
        d = G92.a(enumC14437hu7ArrA);
    }

    private EnumC14437hu7(String str, int i) {
    }

    private static final /* synthetic */ EnumC14437hu7[] a() {
        return new EnumC14437hu7[]{a, b};
    }

    public static EnumC14437hu7 valueOf(String str) {
        return (EnumC14437hu7) Enum.valueOf(EnumC14437hu7.class, str);
    }

    public static EnumC14437hu7[] values() {
        return (EnumC14437hu7[]) c.clone();
    }
}
