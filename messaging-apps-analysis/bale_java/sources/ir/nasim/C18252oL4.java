package ir.nasim;

/* renamed from: ir.nasim.oL4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18252oL4 {
    public static final C18252oL4 a = new C18252oL4();
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mL4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Boolean.valueOf(C18252oL4.d());
        }
    });
    private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.nL4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Boolean.valueOf(C18252oL4.f());
        }
    });
    public static final int d = 8;

    private C18252oL4() {
    }

    public static final boolean c() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d() {
        return C7183Qq.q(EnumC18608ow5.h).h("reactions", false);
    }

    public static final boolean e() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f() {
        return C7183Qq.q(EnumC18608ow5.h).h("views", false);
    }
}
