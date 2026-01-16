package ir.nasim;

import ir.nasim.PJ6;
import java.util.Map;

/* renamed from: ir.nasim.Hi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4969Hi3 extends C4726Gh3 {
    static final /* synthetic */ InterfaceC5239Im3[] h = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C4969Hi3.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final InterfaceC23016wC4 g;

    /* renamed from: ir.nasim.Hi3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            InterfaceC4243Eh3 interfaceC4243Eh3A = C4969Hi3.this.a();
            AbstractC7068Qd1 abstractC7068Qd1C = interfaceC4243Eh3A instanceof InterfaceC5662Kh3 ? C5428Jh3.a.c(((InterfaceC5662Kh3) C4969Hi3.this.a()).c()) : interfaceC4243Eh3A instanceof InterfaceC14311hi3 ? C5428Jh3.a.c(AbstractC9766aX0.e(C4969Hi3.this.a())) : null;
            Map mapG = abstractC7068Qd1C != null ? AbstractC19460qO3.g(AbstractC4616Fw7.a(C4960Hh3.a.d(), abstractC7068Qd1C)) : null;
            return mapG != null ? mapG : AbstractC20051rO3.k();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4969Hi3(InterfaceC4009Dh3 interfaceC4009Dh3, C9182Yv3 c9182Yv3) {
        super(c9182Yv3, interfaceC4009Dh3, PJ6.a.F);
        AbstractC13042fc3.i(interfaceC4009Dh3, "annotation");
        AbstractC13042fc3.i(c9182Yv3, "c");
        this.g = c9182Yv3.e().c(new a());
    }

    @Override // ir.nasim.C4726Gh3, ir.nasim.InterfaceC21651tu
    public Map j() {
        return (Map) MN6.a(this.g, this, h[0]);
    }
}
