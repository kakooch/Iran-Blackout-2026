package ir.nasim;

import java.util.AbstractCollection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Sl4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC7611Sl4 {

    /* renamed from: ir.nasim.Sl4$a */
    private static class a extends AbstractC13312g1 {
        transient Q17 g;

        a(Map map, Q17 q17) {
            super(map);
            this.g = (Q17) AbstractC4029Dj5.j(q17);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC14496i1
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public List y() {
            return (List) this.g.get();
        }

        @Override // ir.nasim.AbstractC18649p1
        Map e() {
            return C();
        }

        @Override // ir.nasim.AbstractC18649p1
        Set g() {
            return D();
        }
    }

    /* renamed from: ir.nasim.Sl4$b */
    static abstract class b extends AbstractCollection {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return f().c(entry.getKey(), entry.getValue());
        }

        abstract InterfaceC7143Ql4 f();

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return f().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return f().size();
        }
    }

    static boolean a(InterfaceC7143Ql4 interfaceC7143Ql4, Object obj) {
        if (obj == interfaceC7143Ql4) {
            return true;
        }
        if (obj instanceof InterfaceC7143Ql4) {
            return interfaceC7143Ql4.b().equals(((InterfaceC7143Ql4) obj).b());
        }
        return false;
    }

    public static TB3 b(Map map, Q17 q17) {
        return new a(map, q17);
    }
}
