package ir.nasim;

import java.io.Serializable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class OM2 implements Serializable {
    public static final OM2 b = new OM2("PRIVATE", 0, HD5.create_private_group);
    public static final OM2 c = new OM2("PUBLIC", 1, HD5.create_public_group);
    private static final /* synthetic */ OM2[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        OM2[] om2ArrA = a();
        d = om2ArrA;
        e = G92.a(om2ArrA);
    }

    private OM2(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ OM2[] a() {
        return new OM2[]{b, c};
    }

    public static OM2 valueOf(String str) {
        return (OM2) Enum.valueOf(OM2.class, str);
    }

    public static OM2[] values() {
        return (OM2[]) d.clone();
    }

    public final int j() {
        return this.a;
    }
}
