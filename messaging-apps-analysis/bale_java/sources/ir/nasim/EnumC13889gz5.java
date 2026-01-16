package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.gz5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC13889gz5 {
    public static final EnumC13889gz5 a = new EnumC13889gz5("CALL", 0);
    public static final EnumC13889gz5 b = new EnumC13889gz5(TokenNames.MESSAGE, 1);
    public static final EnumC13889gz5 c = new EnumC13889gz5("DELETE", 2);
    public static final EnumC13889gz5 d = new EnumC13889gz5("EDIT", 3);
    public static final EnumC13889gz5 e = new EnumC13889gz5("READ", 4);
    public static final EnumC13889gz5 f = new EnumC13889gz5("REACTION", 5);
    public static final EnumC13889gz5 g = new EnumC13889gz5("STORY", 6);
    public static final EnumC13889gz5 h = new EnumC13889gz5("MENTION", 7);
    public static final EnumC13889gz5 i = new EnumC13889gz5("REPLY", 8);
    public static final EnumC13889gz5 j = new EnumC13889gz5("COMMENT_REPLY", 9);
    private static final /* synthetic */ EnumC13889gz5[] k;
    private static final /* synthetic */ F92 l;

    static {
        EnumC13889gz5[] enumC13889gz5ArrA = a();
        k = enumC13889gz5ArrA;
        l = G92.a(enumC13889gz5ArrA);
    }

    private EnumC13889gz5(String str, int i2) {
    }

    private static final /* synthetic */ EnumC13889gz5[] a() {
        return new EnumC13889gz5[]{a, b, c, d, e, f, g, h, i, j};
    }

    public static EnumC13889gz5 valueOf(String str) {
        return (EnumC13889gz5) Enum.valueOf(EnumC13889gz5.class, str);
    }

    public static EnumC13889gz5[] values() {
        return (EnumC13889gz5[]) k.clone();
    }
}
