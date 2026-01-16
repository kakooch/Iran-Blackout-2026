package ir.nasim;

import java.util.Collection;
import java.util.LinkedList;

/* renamed from: ir.nasim.eO4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC12306eO4 {

    /* renamed from: ir.nasim.eO4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ DE6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(DE6 de6) {
            super(1);
            this.e = de6;
        }

        public final void a(Object obj) {
            DE6 de6 = this.e;
            AbstractC13042fc3.h(obj, "it");
            de6.add(obj);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    public static final Collection a(Collection collection, UA2 ua2) {
        AbstractC13042fc3.i(collection, "<this>");
        AbstractC13042fc3.i(ua2, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        DE6 de6A = DE6.c.a();
        while (!linkedList.isEmpty()) {
            Object objQ0 = AbstractC15401jX0.q0(linkedList);
            DE6 de6A2 = DE6.c.a();
            Collection collectionT = C11663dO4.t(objQ0, linkedList, ua2, new a(de6A2));
            AbstractC13042fc3.h(collectionT, "val conflictedHandles = SmartSet.create<H>()\n\n        val overridableGroup =\n            OverridingUtil.extractMembersOverridableInBothWays(nextHandle, queue, descriptorByHandle) { conflictedHandles.add(it) }");
            if (collectionT.size() == 1 && de6A2.isEmpty()) {
                Object objU0 = AbstractC15401jX0.U0(collectionT);
                AbstractC13042fc3.h(objU0, "overridableGroup.single()");
                de6A.add(objU0);
            } else {
                Object objO = C11663dO4.O(collectionT, ua2);
                AbstractC13042fc3.h(objO, "selectMostSpecificMember(overridableGroup, descriptorByHandle)");
                InterfaceC14592iA0 interfaceC14592iA0 = (InterfaceC14592iA0) ua2.invoke(objO);
                for (Object obj : collectionT) {
                    AbstractC13042fc3.h(obj, "it");
                    if (!C11663dO4.E(interfaceC14592iA0, (InterfaceC14592iA0) ua2.invoke(obj))) {
                        de6A2.add(obj);
                    }
                }
                if (!de6A2.isEmpty()) {
                    de6A.addAll(de6A2);
                }
                de6A.add(objO);
            }
        }
        return de6A;
    }
}
