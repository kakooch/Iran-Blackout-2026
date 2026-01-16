package ir.nasim;

import java.util.TimeZone;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.sq7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC20932sq7 {
    public static final EnumC20932sq7 b;
    public static final EnumC20932sq7 c;
    public static final EnumC20932sq7 d;
    private static final /* synthetic */ EnumC20932sq7[] e;
    private static final /* synthetic */ F92 f;
    private final TimeZone a;

    static {
        TimeZone timeZone = TimeZone.getDefault();
        AbstractC13042fc3.h(timeZone, "getDefault(...)");
        b = new EnumC20932sq7("DEFAULT", 0, timeZone);
        TimeZone timeZone2 = TimeZone.getTimeZone("Asia/Tehran");
        AbstractC13042fc3.h(timeZone2, "getTimeZone(...)");
        c = new EnumC20932sq7("ASIA_TEHRAN", 1, timeZone2);
        TimeZone timeZone3 = TimeZone.getTimeZone("Iran");
        AbstractC13042fc3.h(timeZone3, "getTimeZone(...)");
        d = new EnumC20932sq7("IRAN", 2, timeZone3);
        EnumC20932sq7[] enumC20932sq7ArrA = a();
        e = enumC20932sq7ArrA;
        f = G92.a(enumC20932sq7ArrA);
    }

    private EnumC20932sq7(String str, int i, TimeZone timeZone) {
        this.a = timeZone;
    }

    private static final /* synthetic */ EnumC20932sq7[] a() {
        return new EnumC20932sq7[]{b, c, d};
    }

    public static EnumC20932sq7 valueOf(String str) {
        return (EnumC20932sq7) Enum.valueOf(EnumC20932sq7.class, str);
    }

    public static EnumC20932sq7[] values() {
        return (EnumC20932sq7[]) e.clone();
    }

    public final TimeZone j() {
        return this.a;
    }
}
