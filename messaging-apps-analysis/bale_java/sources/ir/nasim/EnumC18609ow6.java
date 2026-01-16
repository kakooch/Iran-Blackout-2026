package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ow6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class EnumC18609ow6 {
    public static final b a;
    public static final EnumC18609ow6 b = new EnumC18609ow6("ALL_REACTIONS", 0) { // from class: ir.nasim.ow6.a
        private final int g = MD5.reaction_settings_option_all_reactions;
        private final int h = MD5.reaction_settings_option_all_reactions_description;

        {
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC18609ow6
        public int j() {
            return this.h;
        }

        @Override // ir.nasim.EnumC18609ow6
        public int q() {
            return this.g;
        }
    };
    public static final EnumC18609ow6 c = new EnumC18609ow6("SOME_REACTIONS", 1) { // from class: ir.nasim.ow6.d
        private final int g = MD5.reaction_settings_option_some_reactions;
        private final int h = MD5.reaction_settings_option_some_reactions_description;

        {
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC18609ow6
        public int j() {
            return this.h;
        }

        @Override // ir.nasim.EnumC18609ow6
        public int q() {
            return this.g;
        }
    };
    public static final EnumC18609ow6 d = new EnumC18609ow6("NO_REACTION", 2) { // from class: ir.nasim.ow6.c
        private final int g = MD5.reaction_settings_option_no_reactions;
        private final int h = MD5.reaction_settings_option_no_reactions_description;

        {
            ED1 ed1 = null;
        }

        @Override // ir.nasim.EnumC18609ow6
        public int j() {
            return this.h;
        }

        @Override // ir.nasim.EnumC18609ow6
        public int q() {
            return this.g;
        }
    };
    private static final /* synthetic */ EnumC18609ow6[] e;
    private static final /* synthetic */ F92 f;

    /* renamed from: ir.nasim.ow6$b */
    public static final class b {
        private b() {
        }

        public final EnumC18609ow6 a(int i) {
            return EnumC18609ow6.values()[i];
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC18609ow6[] enumC18609ow6ArrA = a();
        e = enumC18609ow6ArrA;
        f = G92.a(enumC18609ow6ArrA);
        a = new b(null);
    }

    public /* synthetic */ EnumC18609ow6(String str, int i, ED1 ed1) {
        this(str, i);
    }

    private static final /* synthetic */ EnumC18609ow6[] a() {
        return new EnumC18609ow6[]{b, c, d};
    }

    public static EnumC18609ow6 valueOf(String str) {
        return (EnumC18609ow6) Enum.valueOf(EnumC18609ow6.class, str);
    }

    public static EnumC18609ow6[] values() {
        return (EnumC18609ow6[]) e.clone();
    }

    public abstract int j();

    public final int p() {
        return ordinal();
    }

    public abstract int q();

    private EnumC18609ow6(String str, int i) {
    }
}
