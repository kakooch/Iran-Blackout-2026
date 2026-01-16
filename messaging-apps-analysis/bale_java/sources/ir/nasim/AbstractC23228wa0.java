package ir.nasim;

import ir.nasim.AbstractC9252Zd1;
import java.util.List;

/* renamed from: ir.nasim.wa0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23228wa0 implements IY2 {
    private final List a;
    private final int b;

    /* renamed from: ir.nasim.wa0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC9252Zd1.b f;
        final /* synthetic */ float g;
        final /* synthetic */ float h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC9252Zd1.b bVar, float f, float f2) {
            super(1);
            this.f = bVar;
            this.g = f;
            this.h = f2;
        }

        public final void a(TK6 tk6) {
            AbstractC13042fc3.i(tk6, "state");
            C13060fe1 c13060fe1C = AbstractC23228wa0.this.c(tk6);
            AbstractC23228wa0 abstractC23228wa0 = AbstractC23228wa0.this;
            AbstractC9252Zd1.b bVar = this.f;
            ((C13060fe1) C7381Rm.a.e()[abstractC23228wa0.b][bVar.b()].invoke(c13060fe1C, bVar.a())).B(C17784nZ1.j(this.g)).D(C17784nZ1.j(this.h));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((TK6) obj);
            return C19938rB7.a;
        }
    }

    public AbstractC23228wa0(List list, int i) {
        AbstractC13042fc3.i(list, "tasks");
        this.a = list;
        this.b = i;
    }

    @Override // ir.nasim.IY2
    public final void a(AbstractC9252Zd1.b bVar, float f, float f2) {
        AbstractC13042fc3.i(bVar, "anchor");
        this.a.add(new a(bVar, f, f2));
    }

    public abstract C13060fe1 c(TK6 tk6);
}
