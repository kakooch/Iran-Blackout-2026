package ir.nasim;

/* renamed from: ir.nasim.im1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14959im1 extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
    final /* synthetic */ EnumC23935xl7 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14959im1(EnumC23935xl7 enumC23935xl7) {
        super(2);
        this.e = enumC23935xl7;
    }

    public final String a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-1744780674);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1744780674, i, -1, "androidx.compose.foundation.text.TextItem.<anonymous> (ContextMenu.android.kt:143)");
        }
        String strJ = this.e.j(interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
        return strJ;
    }

    @Override // ir.nasim.InterfaceC14603iB2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
    }
}
