package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.tM, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC21241tM {
    public static final EnumC21241tM d = new EnumC21241tM("HALF_X", 0, AbstractC24188yB5.ic_half_x_speed_voice, new InterfaceC14603iB2() { // from class: ir.nasim.tM.a
        public final long a(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            interfaceC22053ub1.W(1174001401);
            long jI = G10.a.a(interfaceC22053ub1, 6).I();
            interfaceC22053ub1.Q();
            return jI;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return C24381yX0.k(a((InterfaceC22053ub1) obj, ((Number) obj2).intValue()));
        }
    }, UD5.halfx_speed_content_description);
    public static final EnumC21241tM e = new EnumC21241tM("ONE_X", 1, AbstractC24188yB5.icon_speed_one_x, new InterfaceC14603iB2() { // from class: ir.nasim.tM.b
        public final long a(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            interfaceC22053ub1.W(-1543221254);
            long jB = G10.a.a(interfaceC22053ub1, 6).B();
            interfaceC22053ub1.Q();
            return jB;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return C24381yX0.k(a((InterfaceC22053ub1) obj, ((Number) obj2).intValue()));
        }
    }, UD5.onex_speed_content_description);
    public static final EnumC21241tM f = new EnumC21241tM("ONE_AND_HALF_X", 2, AbstractC24188yB5.icon_speed_one_and_half_x, new InterfaceC14603iB2() { // from class: ir.nasim.tM.c
        public final long a(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            interfaceC22053ub1.W(1781259064);
            long jI = G10.a.a(interfaceC22053ub1, 6).I();
            interfaceC22053ub1.Q();
            return jI;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return C24381yX0.k(a((InterfaceC22053ub1) obj, ((Number) obj2).intValue()));
        }
    }, UD5.one_and_halfx_speed_content_description);
    public static final EnumC21241tM g = new EnumC21241tM("TWO_X", 3, AbstractC24188yB5.icon_speed_two_x, new InterfaceC14603iB2() { // from class: ir.nasim.tM.d
        public final long a(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            interfaceC22053ub1.W(876769748);
            long jI = G10.a.a(interfaceC22053ub1, 6).I();
            interfaceC22053ub1.Q();
            return jI;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return C24381yX0.k(a((InterfaceC22053ub1) obj, ((Number) obj2).intValue()));
        }
    }, UD5.twox_speed_content_description);
    private static final /* synthetic */ EnumC21241tM[] h;
    private static final /* synthetic */ F92 i;
    private final int a;
    private final InterfaceC14603iB2 b;
    private final int c;

    static {
        EnumC21241tM[] enumC21241tMArrA = a();
        h = enumC21241tMArrA;
        i = G92.a(enumC21241tMArrA);
    }

    private EnumC21241tM(String str, int i2, int i3, InterfaceC14603iB2 interfaceC14603iB2, int i4) {
        this.a = i3;
        this.b = interfaceC14603iB2;
        this.c = i4;
    }

    private static final /* synthetic */ EnumC21241tM[] a() {
        return new EnumC21241tM[]{d, e, f, g};
    }

    public static EnumC21241tM valueOf(String str) {
        return (EnumC21241tM) Enum.valueOf(EnumC21241tM.class, str);
    }

    public static EnumC21241tM[] values() {
        return (EnumC21241tM[]) h.clone();
    }

    public final int j() {
        return this.c;
    }

    public final int p() {
        return this.a;
    }

    public final InterfaceC14603iB2 q() {
        return this.b;
    }
}
