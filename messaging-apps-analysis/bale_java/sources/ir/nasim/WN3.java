package ir.nasim;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class WN3 {

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(InterfaceC8730Xb6 interfaceC8730Xb6, Object obj) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : ((Map) this.e.invoke(interfaceC8730Xb6, obj)).entrySet()) {
                arrayList.add(entry.getKey());
                arrayList.add(entry.getValue());
            }
            return arrayList;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (list.size() % 2 != 0) {
                throw new IllegalStateException("non-zero remainder".toString());
            }
            for (int i = 0; i < list.size(); i += 2) {
                Object obj = list.get(i);
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, list.get(i + 1));
            }
            return this.e.invoke(linkedHashMap);
        }
    }

    public static final InterfaceC8230Vb6 a(InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2) {
        return WB3.a(new a(interfaceC14603iB2), new b(ua2));
    }
}
