package ir.nasim;

import ir.nasim.C12697f30;
import ir.nasim.InterfaceC6473Nr7;

/* renamed from: ir.nasim.Nr7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC6473Nr7 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.Nr7$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PV f(InterfaceC9824ad1 interfaceC9824ad1) {
            AbstractC13042fc3.i(interfaceC9824ad1, "$configurationRepository");
            return AbstractC4679Gc1.l(interfaceC9824ad1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PV j(InterfaceC9824ad1 interfaceC9824ad1) {
            AbstractC13042fc3.i(interfaceC9824ad1, "$configurationRepository");
            return AbstractC4679Gc1.n(interfaceC9824ad1);
        }

        public final InterfaceC11463d30 c(InterfaceC7486Rx5 interfaceC7486Rx5) {
            AbstractC13042fc3.i(interfaceC7486Rx5, "optimizerConfigurationProvider");
            Object obj = interfaceC7486Rx5.get();
            AbstractC13042fc3.h(obj, "get(...)");
            return new OV((PV) obj, interfaceC7486Rx5);
        }

        public final C12697f30 d(C12697f30.a aVar, InterfaceC11463d30 interfaceC11463d30) {
            AbstractC13042fc3.i(aVar, "bandwidthOptimizerTrackerFactory");
            AbstractC13042fc3.i(interfaceC11463d30, "bandwidthOptimizer");
            return C12697f30.a.a(aVar, interfaceC11463d30, 0, 2, null);
        }

        public final InterfaceC7486Rx5 e(final InterfaceC9824ad1 interfaceC9824ad1) {
            AbstractC13042fc3.i(interfaceC9824ad1, "configurationRepository");
            return new InterfaceC7486Rx5() { // from class: ir.nasim.Mr7
                @Override // ir.nasim.InterfaceC7720Sx5
                public final Object get() {
                    return InterfaceC6473Nr7.a.f(interfaceC9824ad1);
                }
            };
        }

        public final InterfaceC11463d30 g(InterfaceC7486Rx5 interfaceC7486Rx5) {
            AbstractC13042fc3.i(interfaceC7486Rx5, "optimizerConfigurationProvider");
            Object obj = interfaceC7486Rx5.get();
            AbstractC13042fc3.h(obj, "get(...)");
            return new OV((PV) obj, interfaceC7486Rx5);
        }

        public final C12697f30 h(C12697f30.a aVar, InterfaceC11463d30 interfaceC11463d30) {
            AbstractC13042fc3.i(aVar, "bandwidthOptimizerTrackerFactory");
            AbstractC13042fc3.i(interfaceC11463d30, "bandwidthOptimizer");
            return C12697f30.a.a(aVar, interfaceC11463d30, 0, 2, null);
        }

        public final InterfaceC7486Rx5 i(final InterfaceC9824ad1 interfaceC9824ad1) {
            AbstractC13042fc3.i(interfaceC9824ad1, "configurationRepository");
            return new InterfaceC7486Rx5() { // from class: ir.nasim.Lr7
                @Override // ir.nasim.InterfaceC7720Sx5
                public final Object get() {
                    return InterfaceC6473Nr7.a.j(interfaceC9824ad1);
                }
            };
        }
    }
}
