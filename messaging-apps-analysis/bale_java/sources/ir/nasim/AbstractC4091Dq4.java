package ir.nasim;

/* renamed from: ir.nasim.Dq4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4091Dq4 {

    /* renamed from: ir.nasim.Dq4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C12889fL5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C12889fL5 c12889fL5) {
            super(1);
            this.e = c12889fL5;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(InterfaceC8645Wv7 interfaceC8645Wv7) {
            boolean z;
            if (interfaceC8645Wv7.h().b2()) {
                this.e.a = interfaceC8645Wv7;
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC8645Wv7 b(InterfaceC8645Wv7 interfaceC8645Wv7) {
        C12889fL5 c12889fL5 = new C12889fL5();
        AbstractC8931Xv7.d(interfaceC8645Wv7, new a(c12889fL5));
        return (InterfaceC8645Wv7) c12889fL5.a;
    }

    public static final JG1 c(InterfaceC24572yq4 interfaceC24572yq4, C25166zq4 c25166zq4) {
        return new C3857Cq4(interfaceC24572yq4, c25166zq4);
    }
}
