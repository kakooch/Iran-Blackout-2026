package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.fK3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12878fK3 implements InterfaceC8121Up5 {
    private final int a;

    /* renamed from: ir.nasim.fK3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C11637dL5 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C11637dL5 c11637dL5, int i) {
            super(0);
            this.e = c11637dL5;
            this.f = i;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            List list = AbstractC13496gK3.a;
            C11637dL5 c11637dL5 = this.e;
            int i = c11637dL5.a;
            c11637dL5.a = i + 1;
            return (String) list.get(i % this.f);
        }
    }

    public C12878fK3(int i) {
        this.a = i;
    }

    private final String b(int i) {
        return AbstractC11342cq6.A(AbstractC11342cq6.H(AbstractC9962aq6.h(new a(new C11637dL5(), AbstractC13496gK3.a.size())), i), Separators.SP, null, null, 0, null, null, 62, null);
    }

    @Override // ir.nasim.InterfaceC8121Up5
    public InterfaceC23384wp6 a() {
        return AbstractC9962aq6.k(b(this.a));
    }
}
