package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.az1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class EnumC10044az1 {
    public static final EnumC10044az1 a;
    public static final EnumC10044az1 b;
    public static final EnumC10044az1 c;
    public static final EnumC10044az1 d;
    public static final EnumC10044az1 e;
    public static final EnumC10044az1 f;
    public static final EnumC10044az1 g;
    public static final EnumC10044az1 h;
    private static final /* synthetic */ EnumC10044az1[] i;

    /* renamed from: ir.nasim.az1$a */
    enum a extends EnumC10044az1 {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // ir.nasim.EnumC10044az1
        boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        a = aVar;
        EnumC10044az1 enumC10044az1 = new EnumC10044az1("DATA_MASK_001", 1) { // from class: ir.nasim.az1.b
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.EnumC10044az1
            boolean a(int i2, int i3) {
                return (i2 & 1) == 0;
            }
        };
        b = enumC10044az1;
        EnumC10044az1 enumC10044az12 = new EnumC10044az1("DATA_MASK_010", 2) { // from class: ir.nasim.az1.c
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.EnumC10044az1
            boolean a(int i2, int i3) {
                return i3 % 3 == 0;
            }
        };
        c = enumC10044az12;
        EnumC10044az1 enumC10044az13 = new EnumC10044az1("DATA_MASK_011", 3) { // from class: ir.nasim.az1.d
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.EnumC10044az1
            boolean a(int i2, int i3) {
                return (i2 + i3) % 3 == 0;
            }
        };
        d = enumC10044az13;
        EnumC10044az1 enumC10044az14 = new EnumC10044az1("DATA_MASK_100", 4) { // from class: ir.nasim.az1.e
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.EnumC10044az1
            boolean a(int i2, int i3) {
                return (((i2 / 2) + (i3 / 3)) & 1) == 0;
            }
        };
        e = enumC10044az14;
        EnumC10044az1 enumC10044az15 = new EnumC10044az1("DATA_MASK_101", 5) { // from class: ir.nasim.az1.f
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.EnumC10044az1
            boolean a(int i2, int i3) {
                return (i2 * i3) % 6 == 0;
            }
        };
        f = enumC10044az15;
        EnumC10044az1 enumC10044az16 = new EnumC10044az1("DATA_MASK_110", 6) { // from class: ir.nasim.az1.g
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.EnumC10044az1
            boolean a(int i2, int i3) {
                return (i2 * i3) % 6 < 3;
            }
        };
        g = enumC10044az16;
        EnumC10044az1 enumC10044az17 = new EnumC10044az1("DATA_MASK_111", 7) { // from class: ir.nasim.az1.h
            {
                a aVar2 = null;
            }

            @Override // ir.nasim.EnumC10044az1
            boolean a(int i2, int i3) {
                return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
            }
        };
        h = enumC10044az17;
        i = new EnumC10044az1[]{aVar, enumC10044az1, enumC10044az12, enumC10044az13, enumC10044az14, enumC10044az15, enumC10044az16, enumC10044az17};
    }

    private EnumC10044az1(String str, int i2) {
    }

    public static EnumC10044az1 valueOf(String str) {
        return (EnumC10044az1) Enum.valueOf(EnumC10044az1.class, str);
    }

    public static EnumC10044az1[] values() {
        return (EnumC10044az1[]) i.clone();
    }

    abstract boolean a(int i2, int i3);

    final void j(C4705Gf0 c4705Gf0, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    c4705Gf0.d(i4, i3);
                }
            }
        }
    }

    /* synthetic */ EnumC10044az1(String str, int i2, a aVar) {
        this(str, i2);
    }
}
