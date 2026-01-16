package ir.nasim;

import ir.nasim.AbstractC10528bl5;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.el5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC12525el5 {
    private static final InterfaceC8230Vb6 a = WN3.a(new InterfaceC14603iB2() { // from class: ir.nasim.cl5
        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(Object obj, Object obj2) {
            return AbstractC12525el5.c((InterfaceC8730Xb6) obj, (AbstractC10528bl5) obj2);
        }
    }, new UA2() { // from class: ir.nasim.dl5
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return AbstractC12525el5.d((Map) obj);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map c(InterfaceC8730Xb6 interfaceC8730Xb6, AbstractC10528bl5 abstractC10528bl5) {
        AbstractC13042fc3.i(interfaceC8730Xb6, "$this$mapSaver");
        AbstractC13042fc3.i(abstractC10528bl5, "state");
        if (abstractC10528bl5 instanceof AbstractC10528bl5.a) {
            return AbstractC19460qO3.g(AbstractC4616Fw7.a("StateType", "Hidden"));
        }
        if (abstractC10528bl5 instanceof AbstractC10528bl5.b) {
            return AbstractC19460qO3.g(AbstractC4616Fw7.a("StateType", "Premium"));
        }
        if (abstractC10528bl5 instanceof AbstractC10528bl5.d) {
            return AbstractC19460qO3.g(AbstractC4616Fw7.a("StateType", "Select"));
        }
        if (abstractC10528bl5 instanceof AbstractC10528bl5.c) {
            return AbstractC20051rO3.n(AbstractC4616Fw7.a("StateType", "Purchase"), AbstractC4616Fw7.a("PackageId", Long.valueOf(((AbstractC10528bl5.c) abstractC10528bl5).a())));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC10528bl5 d(Map map) {
        AbstractC13042fc3.i(map, "map");
        Object obj = map.get("StateType");
        if (AbstractC13042fc3.d(obj, "Hidden")) {
            return AbstractC10528bl5.a.a;
        }
        if (AbstractC13042fc3.d(obj, "Premium")) {
            return AbstractC10528bl5.b.a;
        }
        if (AbstractC13042fc3.d(obj, "Select")) {
            return AbstractC10528bl5.d.a;
        }
        if (!AbstractC13042fc3.d(obj, "Purchase")) {
            return AbstractC10528bl5.a.a;
        }
        Object obj2 = map.get("PackageId");
        AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Long");
        return new AbstractC10528bl5.c(((Long) obj2).longValue());
    }

    public static final InterfaceC8230Vb6 e() {
        return a;
    }
}
