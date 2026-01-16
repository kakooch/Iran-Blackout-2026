package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.InterfaceC0109b;

/* loaded from: classes2.dex */
final class H1 extends N1 {
    public static final /* synthetic */ int k = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H1(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, int i) {
        super(abstractC0256y2, tVar, new j$.util.function.r() { // from class: j$.util.stream.G1
            @Override // j$.util.function.r
            public final Object apply(long j) {
                return AbstractC0251x2.j(j);
            }
        }, new InterfaceC0109b() { // from class: j$.util.stream.F1
            @Override // j$.util.function.BiFunction
            public BiFunction andThen(Function function) {
                function.getClass();
                return new j$.util.concurrent.a(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return new O1((InterfaceC0235u1) obj, (InterfaceC0235u1) obj2);
            }
        });
        if (i == 1) {
            super(abstractC0256y2, tVar, new j$.util.function.r() { // from class: j$.util.stream.J1
                @Override // j$.util.function.r
                public final Object apply(long j) {
                    return AbstractC0251x2.p(j);
                }
            }, new InterfaceC0109b() { // from class: j$.util.stream.I1
                @Override // j$.util.function.BiFunction
                public BiFunction andThen(Function function) {
                    function.getClass();
                    return new j$.util.concurrent.a(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return new P1((InterfaceC0245w1) obj, (InterfaceC0245w1) obj2);
                }
            });
        } else if (i != 2) {
        } else {
            super(abstractC0256y2, tVar, new j$.util.function.r() { // from class: j$.util.stream.L1
                @Override // j$.util.function.r
                public final Object apply(long j) {
                    return AbstractC0251x2.q(j);
                }
            }, new InterfaceC0109b() { // from class: j$.util.stream.K1
                @Override // j$.util.function.BiFunction
                public BiFunction andThen(Function function) {
                    function.getClass();
                    return new j$.util.concurrent.a(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return new Q1((InterfaceC0255y1) obj, (InterfaceC0255y1) obj2);
                }
            });
        }
    }

    public H1(AbstractC0256y2 abstractC0256y2, j$.util.function.m mVar, j$.util.t tVar) {
        super(abstractC0256y2, tVar, new C0122b(mVar), new InterfaceC0109b() { // from class: j$.util.stream.M1
            @Override // j$.util.function.BiFunction
            public BiFunction andThen(Function function) {
                function.getClass();
                return new j$.util.concurrent.a(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return new S1((A1) obj, (A1) obj2);
            }
        });
    }
}
