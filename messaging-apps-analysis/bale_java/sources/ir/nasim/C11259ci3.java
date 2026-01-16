package ir.nasim;

import ir.nasim.PJ6;
import java.util.Map;

/* renamed from: ir.nasim.ci3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11259ci3 extends C4726Gh3 {
    static final /* synthetic */ InterfaceC5239Im3[] h = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C11259ci3.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final InterfaceC23016wC4 g;

    /* renamed from: ir.nasim.ci3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            return AbstractC19460qO3.g(AbstractC4616Fw7.a(C4960Hh3.a.b(), new C9790aZ6("Deprecated in Java")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11259ci3(InterfaceC4009Dh3 interfaceC4009Dh3, C9182Yv3 c9182Yv3) {
        super(c9182Yv3, interfaceC4009Dh3, PJ6.a.y);
        AbstractC13042fc3.i(c9182Yv3, "c");
        this.g = c9182Yv3.e().c(a.e);
    }

    @Override // ir.nasim.C4726Gh3, ir.nasim.InterfaceC21651tu
    public Map j() {
        return (Map) MN6.a(this.g, this, h[0]);
    }
}
