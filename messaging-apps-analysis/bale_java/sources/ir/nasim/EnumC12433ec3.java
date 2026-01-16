package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ec3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC12433ec3 {
    public static final EnumC12433ec3 a = new EnumC12433ec3("Width", 0);
    public static final EnumC12433ec3 b = new EnumC12433ec3("Height", 1);
    private static final /* synthetic */ EnumC12433ec3[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC12433ec3[] enumC12433ec3ArrA = a();
        c = enumC12433ec3ArrA;
        d = G92.a(enumC12433ec3ArrA);
    }

    private EnumC12433ec3(String str, int i) {
    }

    private static final /* synthetic */ EnumC12433ec3[] a() {
        return new EnumC12433ec3[]{a, b};
    }

    public static EnumC12433ec3 valueOf(String str) {
        return (EnumC12433ec3) Enum.valueOf(EnumC12433ec3.class, str);
    }

    public static EnumC12433ec3[] values() {
        return (EnumC12433ec3[]) c.clone();
    }
}
