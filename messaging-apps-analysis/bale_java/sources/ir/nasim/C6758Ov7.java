package ir.nasim;

/* renamed from: ir.nasim.Ov7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C6758Ov7 implements InterfaceC5324Iv7 {
    private final AbstractC5792Kv7 a;
    private final String b;
    private final C11515d82 c;
    private final InterfaceC19191pv7 d;
    private final InterfaceC6992Pv7 e;

    C6758Ov7(AbstractC5792Kv7 abstractC5792Kv7, String str, C11515d82 c11515d82, InterfaceC19191pv7 interfaceC19191pv7, InterfaceC6992Pv7 interfaceC6992Pv7) {
        this.a = abstractC5792Kv7;
        this.b = str;
        this.c = c11515d82;
        this.d = interfaceC19191pv7;
        this.e = interfaceC6992Pv7;
    }

    @Override // ir.nasim.InterfaceC5324Iv7
    public void a(AbstractC18976pa2 abstractC18976pa2) {
        d(abstractC18976pa2, new InterfaceC8177Uv7() { // from class: ir.nasim.Nv7
            @Override // ir.nasim.InterfaceC8177Uv7
            public final void a(Exception exc) {
                C6758Ov7.c(exc);
            }
        });
    }

    public void d(AbstractC18976pa2 abstractC18976pa2, InterfaceC8177Uv7 interfaceC8177Uv7) {
        this.e.a(AbstractC4075Do6.a().e(this.a).c(abstractC18976pa2).f(this.b).d(this.d).b(this.c).a(), interfaceC8177Uv7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Exception exc) {
    }
}
