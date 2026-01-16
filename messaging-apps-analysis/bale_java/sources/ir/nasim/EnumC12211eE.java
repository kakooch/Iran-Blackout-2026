package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.eE, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC12211eE {
    public static final EnumC12211eE d = new EnumC12211eE("OTP", 0, "otp_pref_key", true, true);
    public static final EnumC12211eE e = new EnumC12211eE("PREMIUM", 1, "premium_pref_key", true, true);
    public static final EnumC12211eE f = new EnumC12211eE("SERVICES_PAGE", 2, "services_page_perf_key", true, false);
    public static final EnumC12211eE g = new EnumC12211eE("UNLOCKED_PROTECTED_CONTENT", 3, "unlocked_protected_content_pref_key", true, false);
    private static final /* synthetic */ EnumC12211eE[] h;
    private static final /* synthetic */ F92 i;
    private final String a;
    private final boolean b;
    private final boolean c;

    static {
        EnumC12211eE[] enumC12211eEArrA = a();
        h = enumC12211eEArrA;
        i = G92.a(enumC12211eEArrA);
    }

    private EnumC12211eE(String str, int i2, String str2, boolean z, boolean z2) {
        this.a = str2;
        this.b = z;
        this.c = z2;
    }

    private static final /* synthetic */ EnumC12211eE[] a() {
        return new EnumC12211eE[]{d, e, f, g};
    }

    public static F92 j() {
        return i;
    }

    public static EnumC12211eE valueOf(String str) {
        return (EnumC12211eE) Enum.valueOf(EnumC12211eE.class, str);
    }

    public static EnumC12211eE[] values() {
        return (EnumC12211eE[]) h.clone();
    }

    public final String getKey() {
        if (!this.b) {
            return this.a;
        }
        Integer numValueOf = Integer.valueOf(C13923h3.a.m());
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return this.a;
        }
        return numValueOf.intValue() + "_" + this.a;
    }

    public final boolean p() {
        return this.c;
    }
}
