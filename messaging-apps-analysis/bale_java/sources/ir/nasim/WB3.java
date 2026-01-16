package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class WB3 {

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8730Xb6 interfaceC8730Xb6, Object obj) {
            List list = (List) this.e.invoke(interfaceC8730Xb6, obj);
            List list2 = list;
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                if (obj2 != null && !interfaceC8730Xb6.a(obj2)) {
                    throw new IllegalArgumentException("item can't be saved".toString());
                }
            }
            if (!list2.isEmpty()) {
                return new ArrayList(list2);
            }
            return null;
        }
    }

    public static final InterfaceC8230Vb6 a(InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2) {
        a aVar = new a(interfaceC14603iB2);
        AbstractC13042fc3.g(ua2, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, Original of androidx.compose.runtime.saveable.ListSaverKt.listSaver?>");
        return AbstractC8464Wb6.a(aVar, (UA2) AbstractC19810qy7.g(ua2, 1));
    }
}
