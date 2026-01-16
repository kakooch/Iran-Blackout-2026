package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC11938do1;

/* renamed from: ir.nasim.l96, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16372l96 {

    /* renamed from: ir.nasim.l96$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C15190j96 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C15190j96 c15190j96) {
            super(2);
            this.e = c15190j96;
        }

        public final Integer a(int i, InterfaceC11938do1.b bVar) {
            InterfaceC11938do1.c key = bVar.getKey();
            InterfaceC11938do1.b bVarA = this.e.b.a(key);
            if (key != InterfaceC13730gj3.n0) {
                return Integer.valueOf(bVar != bVarA ? RecyclerView.UNDEFINED_DURATION : i + 1);
            }
            InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) bVarA;
            AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            InterfaceC13730gj3 interfaceC13730gj3B = AbstractC16372l96.b((InterfaceC13730gj3) bVar, interfaceC13730gj3);
            if (interfaceC13730gj3B == interfaceC13730gj3) {
                if (interfaceC13730gj3 != null) {
                    i++;
                }
                return Integer.valueOf(i);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + interfaceC13730gj3B + ", expected child of " + interfaceC13730gj3 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (InterfaceC11938do1.b) obj2);
        }
    }

    public static final void a(C15190j96 c15190j96, InterfaceC11938do1 interfaceC11938do1) {
        if (((Number) interfaceC11938do1.f0(0, new a(c15190j96))).intValue() == c15190j96.c) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + c15190j96.b + ",\n\t\tbut emission happened in " + interfaceC11938do1 + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final InterfaceC13730gj3 b(InterfaceC13730gj3 interfaceC13730gj3, InterfaceC13730gj3 interfaceC13730gj32) {
        while (interfaceC13730gj3 != null) {
            if (interfaceC13730gj3 == interfaceC13730gj32) {
                return interfaceC13730gj3;
            }
            if (!(interfaceC13730gj3 instanceof C18419od6)) {
                return interfaceC13730gj3;
            }
            interfaceC13730gj3 = interfaceC13730gj3.getParent();
        }
        return null;
    }
}
