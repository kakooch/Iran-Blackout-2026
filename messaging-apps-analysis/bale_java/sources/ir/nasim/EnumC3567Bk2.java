package ir.nasim;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Bk2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class EnumC3567Bk2 implements InterfaceC3801Ck2 {
    public static final EnumC3567Bk2 a;
    public static final EnumC3567Bk2 b;
    public static final EnumC3567Bk2 c;
    public static final EnumC3567Bk2 d;
    public static final EnumC3567Bk2 e;
    public static final EnumC3567Bk2 f;
    public static final EnumC3567Bk2 g;
    private static final /* synthetic */ EnumC3567Bk2[] h;

    /* renamed from: ir.nasim.Bk2$a */
    enum a extends EnumC3567Bk2 {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // ir.nasim.InterfaceC3801Ck2
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        a = aVar;
        EnumC3567Bk2 enumC3567Bk2 = new EnumC3567Bk2("UPPER_CAMEL_CASE", 1) { // from class: ir.nasim.Bk2.b
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.InterfaceC3801Ck2
            public String a(Field field) {
                return EnumC3567Bk2.p(field.getName());
            }
        };
        b = enumC3567Bk2;
        EnumC3567Bk2 enumC3567Bk22 = new EnumC3567Bk2("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: ir.nasim.Bk2.c
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.InterfaceC3801Ck2
            public String a(Field field) {
                return EnumC3567Bk2.p(EnumC3567Bk2.j(field.getName(), ' '));
            }
        };
        c = enumC3567Bk22;
        EnumC3567Bk2 enumC3567Bk23 = new EnumC3567Bk2("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: ir.nasim.Bk2.d
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.InterfaceC3801Ck2
            public String a(Field field) {
                return EnumC3567Bk2.j(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        };
        d = enumC3567Bk23;
        EnumC3567Bk2 enumC3567Bk24 = new EnumC3567Bk2("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: ir.nasim.Bk2.e
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.InterfaceC3801Ck2
            public String a(Field field) {
                return EnumC3567Bk2.j(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        };
        e = enumC3567Bk24;
        EnumC3567Bk2 enumC3567Bk25 = new EnumC3567Bk2("LOWER_CASE_WITH_DASHES", 5) { // from class: ir.nasim.Bk2.f
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.InterfaceC3801Ck2
            public String a(Field field) {
                return EnumC3567Bk2.j(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        f = enumC3567Bk25;
        EnumC3567Bk2 enumC3567Bk26 = new EnumC3567Bk2("LOWER_CASE_WITH_DOTS", 6) { // from class: ir.nasim.Bk2.g
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.InterfaceC3801Ck2
            public String a(Field field) {
                return EnumC3567Bk2.j(field.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        };
        g = enumC3567Bk26;
        h = new EnumC3567Bk2[]{aVar, enumC3567Bk2, enumC3567Bk22, enumC3567Bk23, enumC3567Bk24, enumC3567Bk25, enumC3567Bk26};
    }

    private EnumC3567Bk2(String str, int i) {
    }

    static String j(String str, char c2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String p(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i) + upperCase + str.substring(i + 1);
            }
        }
        return str;
    }

    public static EnumC3567Bk2 valueOf(String str) {
        return (EnumC3567Bk2) Enum.valueOf(EnumC3567Bk2.class, str);
    }

    public static EnumC3567Bk2[] values() {
        return (EnumC3567Bk2[]) h.clone();
    }

    /* synthetic */ EnumC3567Bk2(String str, int i, a aVar) {
        this(str, i);
    }
}
