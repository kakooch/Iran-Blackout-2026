package ir.nasim;

import kotlin.Metadata;

/* renamed from: ir.nasim.lu4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16814lu4 implements InterfaceC25225zw4 {
    private final InterfaceC9173Yu3 a = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ku4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C16814lu4.d();
        }
    });

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lir/nasim/lu4$a;", "", "Lir/nasim/LD3;", "b", "()Lir/nasim/LD3;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    /* renamed from: ir.nasim.lu4$a */
    public interface a {
        LD3 b();
    }

    private final LD3 c() {
        return (LD3) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LD3 d() {
        return ((a) C92.a(C5721Ko.a.d(), a.class)).b();
    }

    @Override // ir.nasim.InterfaceC25225zw4
    public C6517Nv5 a(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if ((abstractC20556sC7 instanceof C24820zF7) || (abstractC20556sC7 instanceof C20565sD7)) {
            return c().a(abstractC20556sC7);
        }
        return null;
    }
}
