package j$.util.stream;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: j$.util.stream.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0223s extends AbstractC0132c3 {
    C0223s(AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i) {
        super(abstractC0128c, enumC0151f4, i);
    }

    @Override // j$.util.stream.AbstractC0128c
    A1 F0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, j$.util.function.m mVar) {
        if (EnumC0145e4.DISTINCT.d(abstractC0256y2.t0())) {
            return abstractC0256y2.q0(tVar, false, mVar);
        }
        if (EnumC0145e4.ORDERED.d(abstractC0256y2.t0())) {
            return M0(abstractC0256y2, tVar);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        new C0195n0(new C0200o(atomicBoolean, concurrentHashMap), false).c(abstractC0256y2, tVar);
        Collection collectionKeySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(collectionKeySet);
            hashSet.add(null);
            collectionKeySet = hashSet;
        }
        return new E1(collectionKeySet);
    }

    @Override // j$.util.stream.AbstractC0128c
    j$.util.t G0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        return EnumC0145e4.DISTINCT.d(abstractC0256y2.t0()) ? abstractC0256y2.x0(tVar) : EnumC0145e4.ORDERED.d(abstractC0256y2.t0()) ? ((E1) M0(abstractC0256y2, tVar)).spliterator() : new C0199n4(abstractC0256y2.x0(tVar));
    }

    @Override // j$.util.stream.AbstractC0128c
    InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        interfaceC0192m3.getClass();
        return EnumC0145e4.DISTINCT.d(i) ? interfaceC0192m3 : EnumC0145e4.SORTED.d(i) ? new C0212q(this, interfaceC0192m3) : new r(this, interfaceC0192m3);
    }

    A1 M0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        C0206p c0206p = new j$.util.function.z() { // from class: j$.util.stream.p
            @Override // j$.util.function.z
            public final Object get() {
                return new LinkedHashSet();
            }
        };
        C0188m c0188m = new BiConsumer() { // from class: j$.util.stream.m
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new j$.util.concurrent.a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LinkedHashSet) obj).add(obj2);
            }
        };
        return new E1((Collection) new C0261z2(EnumC0151f4.REFERENCE, new BiConsumer() { // from class: j$.util.stream.n
            @Override // j$.util.function.BiConsumer
            public BiConsumer a(BiConsumer biConsumer) {
                biConsumer.getClass();
                return new j$.util.concurrent.a(this, biConsumer);
            }

            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
            }
        }, c0188m, c0206p).c(abstractC0256y2, tVar));
    }
}
