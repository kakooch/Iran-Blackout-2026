package ir.nasim;

import ir.nasim.AbstractC9252Zd1;
import java.util.List;

/* renamed from: ir.nasim.jd0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15458jd0 implements InterfaceC14163hS7 {
    private final List a;
    private final int b;

    /* renamed from: ir.nasim.jd0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC9252Zd1.c f;
        final /* synthetic */ float g;
        final /* synthetic */ float h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC9252Zd1.c cVar, float f, float f2) {
            super(1);
            this.f = cVar;
            this.g = f;
            this.h = f2;
        }

        public final void a(TK6 tk6) {
            AbstractC13042fc3.i(tk6, "state");
            EnumC12613eu3 enumC12613eu3P = tk6.p();
            C7381Rm c7381Rm = C7381Rm.a;
            int iG = c7381Rm.g(AbstractC15458jd0.this.b, enumC12613eu3P);
            int iG2 = c7381Rm.g(this.f.b(), enumC12613eu3P);
            ((C13060fe1) c7381Rm.f()[iG][iG2].q(AbstractC15458jd0.this.c(tk6), this.f.a(), tk6.p())).B(C17784nZ1.j(this.g)).D(C17784nZ1.j(this.h));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((TK6) obj);
            return C19938rB7.a;
        }
    }

    public AbstractC15458jd0(List list, int i) {
        AbstractC13042fc3.i(list, "tasks");
        this.a = list;
        this.b = i;
    }

    @Override // ir.nasim.InterfaceC14163hS7
    public final void a(AbstractC9252Zd1.c cVar, float f, float f2) {
        AbstractC13042fc3.i(cVar, "anchor");
        this.a.add(new a(cVar, f, f2));
    }

    public abstract C13060fe1 c(TK6 tk6);
}
