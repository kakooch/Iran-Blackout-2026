package ir.nasim;

/* renamed from: ir.nasim.gM5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C13516gM5 extends C12898fM5 {
    private static AbstractC16142km3 l(AbstractC15785kA0 abstractC15785kA0) {
        InterfaceC15551jm3 owner = abstractC15785kA0.getOwner();
        return owner instanceof AbstractC16142km3 ? (AbstractC16142km3) owner : C17530n72.d;
    }

    @Override // ir.nasim.C12898fM5
    public InterfaceC16733lm3 a(DB2 db2) {
        return new C17324mm3(l(db2), db2.getName(), db2.getSignature(), db2.getBoundReceiver());
    }

    @Override // ir.nasim.C12898fM5
    public InterfaceC11299cm3 b(Class cls) {
        return AbstractC11921dm3.a(cls);
    }

    @Override // ir.nasim.C12898fM5
    public InterfaceC15551jm3 c(Class cls, String str) {
        return new C25125zm3(cls, str);
    }

    @Override // ir.nasim.C12898fM5
    public InterfaceC20888sm3 d(AbstractC5240Im4 abstractC5240Im4) {
        return new C21575tm3(l(abstractC5240Im4), abstractC5240Im4.getName(), abstractC5240Im4.getSignature(), abstractC5240Im4.getBoundReceiver());
    }

    @Override // ir.nasim.C12898fM5
    public InterfaceC22165um3 e(AbstractC5708Km4 abstractC5708Km4) {
        return new C22755vm3(l(abstractC5708Km4), abstractC5708Km4.getName(), abstractC5708Km4.getSignature(), abstractC5708Km4.getBoundReceiver());
    }

    @Override // ir.nasim.C12898fM5
    public InterfaceC23351wm3 f(AbstractC6175Mm4 abstractC6175Mm4) {
        return new C23941xm3(l(abstractC6175Mm4), abstractC6175Mm4.getName(), abstractC6175Mm4.getSignature());
    }

    @Override // ir.nasim.C12898fM5
    public InterfaceC3820Cm3 g(AbstractC23452ww5 abstractC23452ww5) {
        return new C4054Dm3(l(abstractC23452ww5), abstractC23452ww5.getName(), abstractC23452ww5.getSignature(), abstractC23452ww5.getBoundReceiver());
    }

    @Override // ir.nasim.C12898fM5
    public InterfaceC4288Em3 h(AbstractC24632yw5 abstractC24632yw5) {
        return new C4522Fm3(l(abstractC24632yw5), abstractC24632yw5.getName(), abstractC24632yw5.getSignature(), abstractC24632yw5.getBoundReceiver());
    }

    @Override // ir.nasim.C12898fM5
    public InterfaceC4771Gm3 i(AbstractC3439Aw5 abstractC3439Aw5) {
        return new C5005Hm3(l(abstractC3439Aw5), abstractC3439Aw5.getName(), abstractC3439Aw5.getSignature());
    }

    @Override // ir.nasim.C12898fM5
    public String j(InterfaceC23005wB2 interfaceC23005wB2) {
        C17324mm3 c17324mm3A;
        InterfaceC16733lm3 interfaceC16733lm3A = AbstractC9672aM5.a(interfaceC23005wB2);
        return (interfaceC16733lm3A == null || (c17324mm3A = AbstractC14729iN7.a(interfaceC16733lm3A)) == null) ? super.j(interfaceC23005wB2) : C15307jM5.b.e(c17324mm3A.A());
    }

    @Override // ir.nasim.C12898fM5
    public String k(AbstractC8614Ws3 abstractC8614Ws3) {
        return j(abstractC8614Ws3);
    }
}
