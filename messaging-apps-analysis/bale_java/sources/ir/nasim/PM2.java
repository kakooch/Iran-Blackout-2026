package ir.nasim;

import java.io.Serializable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class PM2 implements Serializable {
    public static final PM2 b = new PM2("PRIVATE", 0, ED5.create_private_group);
    public static final PM2 c = new PM2("PUBLIC", 1, ED5.create_public_group);
    private static final /* synthetic */ PM2[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        PM2[] pm2ArrA = a();
        d = pm2ArrA;
        e = G92.a(pm2ArrA);
    }

    private PM2(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ PM2[] a() {
        return new PM2[]{b, c};
    }

    public static PM2 valueOf(String str) {
        return (PM2) Enum.valueOf(PM2.class, str);
    }

    public static PM2[] values() {
        return (PM2[]) d.clone();
    }
}
