package ir.nasim;

/* renamed from: ir.nasim.k96, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15781k96 {
    private static final InterfaceC15796kB2 a;

    /* renamed from: ir.nasim.k96$a */
    /* synthetic */ class a extends EB2 implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
            super(3, InterfaceC4806Gq2.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return interfaceC4806Gq2.a(obj, interfaceC20295rm1);
        }
    }

    static {
        a aVar = a.a;
        AbstractC13042fc3.g(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        a = (InterfaceC15796kB2) AbstractC19810qy7.g(aVar, 3);
    }
}
