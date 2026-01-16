package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ru4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20378ru4 extends AbstractC21707u0 implements InterfaceC25225zw4 {
    private final C9057Yh4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20378ru4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
    }

    public final C6517Nv5 A(C22993wA c22993wA, List list) {
        AbstractC13042fc3.i(c22993wA, "peer");
        AbstractC13042fc3.i(list, "messages");
        C6517Nv5 c6517Nv5Y = this.b.G().T0().y(C18732p92.o(c22993wA), list);
        AbstractC13042fc3.h(c6517Nv5Y, "onNewMessages(...)");
        return c6517Nv5Y;
    }

    @Override // ir.nasim.InterfaceC25225zw4
    public C6517Nv5 a(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if ((abstractC20556sC7 instanceof CE7) || (abstractC20556sC7 instanceof YC7) || (abstractC20556sC7 instanceof C9593aD7) || (abstractC20556sC7 instanceof C10803cD7) || (abstractC20556sC7 instanceof C15819kD7) || (abstractC20556sC7 instanceof C17001mD7) || (abstractC20556sC7 instanceof C18183oD7) || (abstractC20556sC7 instanceof C23618xD7) || (abstractC20556sC7 instanceof C24802zD7) || (abstractC20556sC7 instanceof BD7) || (abstractC20556sC7 instanceof DD7) || (abstractC20556sC7 instanceof AE7) || (abstractC20556sC7 instanceof DE7) || (abstractC20556sC7 instanceof FE7) || (abstractC20556sC7 instanceof IE7) || (abstractC20556sC7 instanceof KE7) || (abstractC20556sC7 instanceof OE7) || (abstractC20556sC7 instanceof YE7) || (abstractC20556sC7 instanceof WE7) || (abstractC20556sC7 instanceof C9611aF7) || (abstractC20556sC7 instanceof C15837kF7) || (abstractC20556sC7 instanceof EF7) || (abstractC20556sC7 instanceof QE7) || (abstractC20556sC7 instanceof RE7) || (abstractC20556sC7 instanceof UE7) || (abstractC20556sC7 instanceof C17019mF7)) {
            return this.b.G().T0().E(abstractC20556sC7);
        }
        return null;
    }
}
