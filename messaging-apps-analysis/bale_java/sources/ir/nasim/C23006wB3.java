package ir.nasim;

import ir.nasim.AbstractC21430te5;
import java.util.List;

/* renamed from: ir.nasim.wB3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C23006wB3 implements InterfaceC10970cW3 {
    private final SA2 a;

    /* renamed from: ir.nasim.wB3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;
        final /* synthetic */ C23006wB3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, C23006wB3 c23006wB3) {
            super(1);
            this.e = list;
            this.f = c23006wB3;
        }

        public final void a(AbstractC21430te5.a aVar) {
            List listK = AbstractC22072ud0.k(this.e, this.f.a);
            if (listK != null) {
                int size = listK.size();
                for (int i = 0; i < size; i++) {
                    XV4 xv4 = (XV4) listK.get(i);
                    AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) xv4.a();
                    SA2 sa2 = (SA2) xv4.b();
                    AbstractC21430te5.a.j(aVar, abstractC21430te5, sa2 != null ? ((C22045ua3) sa2.invoke()).r() : C22045ua3.b.b(), 0.0f, 2, null);
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public C23006wB3(SA2 sa2) {
        this.a = sa2;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.l(j), C17833ne1.k(j), null, new a(list, this), 4, null);
    }
}
