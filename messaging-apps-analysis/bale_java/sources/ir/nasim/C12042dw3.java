package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.dw3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12042dw3 implements InterfaceC25246zy7 {
    private final C9182Yv3 a;
    private final InterfaceC12795fB1 b;
    private final int c;
    private final Map d;
    private final J34 e;

    /* renamed from: ir.nasim.dw3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C11399cw3 invoke(InterfaceC7583Si3 interfaceC7583Si3) {
            AbstractC13042fc3.i(interfaceC7583Si3, "typeParameter");
            Integer num = (Integer) C12042dw3.this.d.get(interfaceC7583Si3);
            if (num == null) {
                return null;
            }
            C12042dw3 c12042dw3 = C12042dw3.this;
            return new C11399cw3(AbstractC4760Gl1.h(AbstractC4760Gl1.b(c12042dw3.a, c12042dw3), c12042dw3.b.getAnnotations()), interfaceC7583Si3, c12042dw3.c + num.intValue(), c12042dw3.b);
        }
    }

    public C12042dw3(C9182Yv3 c9182Yv3, InterfaceC12795fB1 interfaceC12795fB1, InterfaceC7820Ti3 interfaceC7820Ti3, int i) {
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(interfaceC12795fB1, "containingDeclaration");
        AbstractC13042fc3.i(interfaceC7820Ti3, "typeParameterOwner");
        this.a = c9182Yv3;
        this.b = interfaceC12795fB1;
        this.c = i;
        this.d = YW0.d(interfaceC7820Ti3.getTypeParameters());
        this.e = c9182Yv3.e().b(new a());
    }

    @Override // ir.nasim.InterfaceC25246zy7
    public InterfaceC22882vy7 a(InterfaceC7583Si3 interfaceC7583Si3) {
        AbstractC13042fc3.i(interfaceC7583Si3, "javaTypeParameter");
        C11399cw3 c11399cw3 = (C11399cw3) this.e.invoke(interfaceC7583Si3);
        return c11399cw3 == null ? this.a.f().a(interfaceC7583Si3) : c11399cw3;
    }
}
