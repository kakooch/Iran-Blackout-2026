package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class M72 {
    public static final M72 b = new M72("DIALOG_LIST", 0, "SHOULD_SHOW_EMPTY_STATE_ONBOARDING");
    public static final M72 c = new M72("CONTACT", 1, "SHOULD_SHOW_CONTACT_EMPTY_STATE_ONBOARDING");
    private static final /* synthetic */ M72[] d;
    private static final /* synthetic */ F92 e;
    private final String a;

    static {
        M72[] m72ArrA = a();
        d = m72ArrA;
        e = G92.a(m72ArrA);
    }

    private M72(String str, int i, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ M72[] a() {
        return new M72[]{b, c};
    }

    public static M72 valueOf(String str) {
        return (M72) Enum.valueOf(M72.class, str);
    }

    public static M72[] values() {
        return (M72[]) d.clone();
    }

    public final String j() {
        return this.a;
    }
}
