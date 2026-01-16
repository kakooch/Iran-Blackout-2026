package ir.nasim;

/* renamed from: ir.nasim.lb2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16622lb2 implements InterfaceC20817sf2 {

    /* renamed from: ir.nasim.lb2$a */
    private static final class a {
        private static final C16622lb2 a = new C16622lb2();
    }

    public static C16622lb2 a() {
        return a.a;
    }

    public static AbstractC13649gb2 c() {
        return (AbstractC13649gb2) AbstractC3561Bj5.c(AbstractC14240hb2.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC13649gb2 get() {
        return c();
    }
}
