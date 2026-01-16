package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.lL2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC16477lL2 {
    public static final a a;
    public static final EnumC16477lL2 b = new EnumC16477lL2("SHOW", 0);
    public static final EnumC16477lL2 c = new EnumC16477lL2("JOIN", 1);
    public static final EnumC16477lL2 d = new EnumC16477lL2("PREVIEW", 2);
    private static final /* synthetic */ EnumC16477lL2[] e;
    private static final /* synthetic */ F92 f;

    /* renamed from: ir.nasim.lL2$a */
    public static final class a {

        /* renamed from: ir.nasim.lL2$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C1370a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC24338yS2.values().length];
                try {
                    iArr[EnumC24338yS2.GroupPreviewAction_SHOW_CHAT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC24338yS2.GroupPreviewAction_SHOW_PREVIEW.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC24338yS2.GroupPreviewAction_JOIN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EnumC24338yS2.UNRECOGNIZED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        public final EnumC16477lL2 a(EnumC24338yS2 enumC24338yS2) {
            AbstractC13042fc3.i(enumC24338yS2, "g");
            int i = C1370a.a[enumC24338yS2.ordinal()];
            if (i == 1) {
                return EnumC16477lL2.b;
            }
            if (i == 2) {
                return EnumC16477lL2.d;
            }
            if (i == 3) {
                return EnumC16477lL2.c;
            }
            if (i == 4) {
                return EnumC16477lL2.c;
            }
            throw new NoWhenBranchMatchedException();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC16477lL2[] enumC16477lL2ArrA = a();
        e = enumC16477lL2ArrA;
        f = G92.a(enumC16477lL2ArrA);
        a = new a(null);
    }

    private EnumC16477lL2(String str, int i) {
    }

    private static final /* synthetic */ EnumC16477lL2[] a() {
        return new EnumC16477lL2[]{b, c, d};
    }

    public static EnumC16477lL2 valueOf(String str) {
        return (EnumC16477lL2) Enum.valueOf(EnumC16477lL2.class, str);
    }

    public static EnumC16477lL2[] values() {
        return (EnumC16477lL2[]) e.clone();
    }
}
