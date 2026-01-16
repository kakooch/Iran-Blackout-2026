package ir.nasim;

import ir.nasim.AbstractC9252Zd1;

/* loaded from: classes2.dex */
public interface IY2 {

    public static final class a {
        public static /* synthetic */ void a(IY2 iy2, AbstractC9252Zd1.b bVar, float f, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkTo-VpY3zN4");
            }
            if ((i & 2) != 0) {
                f = C17784nZ1.q(0);
            }
            if ((i & 4) != 0) {
                f2 = C17784nZ1.q(0);
            }
            iy2.a(bVar, f, f2);
        }
    }

    void a(AbstractC9252Zd1.b bVar, float f, float f2);
}
