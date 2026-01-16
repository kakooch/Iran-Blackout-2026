package ir.nasim;

import java.util.Collection;

/* renamed from: ir.nasim.uW5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC22011uW5 {

    /* renamed from: ir.nasim.uW5$a */
    public static final class a {
        public static /* synthetic */ Collection a(InterfaceC22011uW5 interfaceC22011uW5, C24841zI1 c24841zI1, UA2 ua2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i & 1) != 0) {
                c24841zI1 = C24841zI1.o;
            }
            if ((i & 2) != 0) {
                ua2 = W24.a.a();
            }
            return interfaceC22011uW5.f(c24841zI1, ua2);
        }
    }

    MU0 e(C6432No4 c6432No4, IJ3 ij3);

    Collection f(C24841zI1 c24841zI1, UA2 ua2);
}
