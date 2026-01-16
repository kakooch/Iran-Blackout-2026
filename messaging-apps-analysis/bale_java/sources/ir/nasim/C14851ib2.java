package ir.nasim;

/* renamed from: ir.nasim.ib2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14851ib2 implements InterfaceC20817sf2 {

    /* renamed from: ir.nasim.ib2$a */
    private static final class a {
        private static final C14851ib2 a = new C14851ib2();
    }

    public static C14851ib2 a() {
        return a.a;
    }

    public static String b() {
        return (String) AbstractC3561Bj5.c(AbstractC14240hb2.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get() {
        return b();
    }
}
