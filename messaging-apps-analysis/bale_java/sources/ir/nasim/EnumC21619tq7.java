package ir.nasim;

import java.util.TimeZone;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.tq7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC21619tq7 {
    public static final EnumC21619tq7 b;
    public static final EnumC21619tq7 c;
    public static final EnumC21619tq7 d;
    private static final /* synthetic */ EnumC21619tq7[] e;
    private static final /* synthetic */ F92 f;
    private final TimeZone a;

    static {
        TimeZone timeZone = TimeZone.getDefault();
        AbstractC13042fc3.h(timeZone, "getDefault(...)");
        b = new EnumC21619tq7("DEFAULT", 0, timeZone);
        TimeZone timeZone2 = TimeZone.getTimeZone("Asia/Tehran");
        AbstractC13042fc3.h(timeZone2, "getTimeZone(...)");
        c = new EnumC21619tq7("ASIA_TEHRAN", 1, timeZone2);
        TimeZone timeZone3 = TimeZone.getTimeZone("Iran");
        AbstractC13042fc3.h(timeZone3, "getTimeZone(...)");
        d = new EnumC21619tq7("IRAN", 2, timeZone3);
        EnumC21619tq7[] enumC21619tq7ArrA = a();
        e = enumC21619tq7ArrA;
        f = G92.a(enumC21619tq7ArrA);
    }

    private EnumC21619tq7(String str, int i, TimeZone timeZone) {
        this.a = timeZone;
    }

    private static final /* synthetic */ EnumC21619tq7[] a() {
        return new EnumC21619tq7[]{b, c, d};
    }

    public static EnumC21619tq7 valueOf(String str) {
        return (EnumC21619tq7) Enum.valueOf(EnumC21619tq7.class, str);
    }

    public static EnumC21619tq7[] values() {
        return (EnumC21619tq7[]) e.clone();
    }

    public final TimeZone j() {
        return this.a;
    }
}
