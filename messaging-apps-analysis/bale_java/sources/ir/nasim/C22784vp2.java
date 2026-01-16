package ir.nasim;

import ir.nasim.AbstractC24560yp2;
import ir.nasim.AbstractC7076Qe0;
import java.util.Objects;

/* renamed from: ir.nasim.vp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C22784vp2 extends AbstractC7076Qe0 {

    /* renamed from: ir.nasim.vp2$b */
    private static final class b implements AbstractC7076Qe0.f {
        private final C3846Cp2 a;
        private final int b;
        private final AbstractC24560yp2.a c;

        private long c(InterfaceC9845af2 interfaceC9845af2) {
            while (interfaceC9845af2.g() < interfaceC9845af2.getLength() - 6 && !AbstractC24560yp2.h(interfaceC9845af2, this.a, this.b, this.c)) {
                interfaceC9845af2.h(1);
            }
            if (interfaceC9845af2.g() < interfaceC9845af2.getLength() - 6) {
                return this.c.a;
            }
            interfaceC9845af2.h((int) (interfaceC9845af2.getLength() - interfaceC9845af2.g()));
            return this.a.j;
        }

        @Override // ir.nasim.AbstractC7076Qe0.f
        public AbstractC7076Qe0.e a(InterfaceC9845af2 interfaceC9845af2, long j) {
            long position = interfaceC9845af2.getPosition();
            long jC = c(interfaceC9845af2);
            long jG = interfaceC9845af2.g();
            interfaceC9845af2.h(Math.max(6, this.a.c));
            long jC2 = c(interfaceC9845af2);
            return (jC > j || jC2 <= j) ? jC2 <= j ? AbstractC7076Qe0.e.f(jC2, interfaceC9845af2.g()) : AbstractC7076Qe0.e.d(jC, position) : AbstractC7076Qe0.e.e(jG);
        }

        private b(C3846Cp2 c3846Cp2, int i) {
            this.a = c3846Cp2;
            this.b = i;
            this.c = new AbstractC24560yp2.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22784vp2(final C3846Cp2 c3846Cp2, int i, long j, long j2) {
        super(new AbstractC7076Qe0.d() { // from class: ir.nasim.up2
            @Override // ir.nasim.AbstractC7076Qe0.d
            public final long a(long j3) {
                return c3846Cp2.i(j3);
            }
        }, new b(c3846Cp2, i), c3846Cp2.f(), 0L, c3846Cp2.j, j, j2, c3846Cp2.d(), Math.max(6, c3846Cp2.c));
        Objects.requireNonNull(c3846Cp2);
    }
}
