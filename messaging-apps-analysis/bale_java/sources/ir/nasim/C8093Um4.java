package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.Um4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C8093Um4 extends AbstractC3422Au6 implements Set, InterfaceC24531ym3 {
    private final C7620Sm4 b;

    /* renamed from: ir.nasim.Um4$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private int a = -1;
        private final Iterator b;

        /* renamed from: ir.nasim.Um4$a$a, reason: collision with other inner class name */
        static final class C0693a extends V06 implements InterfaceC14603iB2 {
            Object a;
            Object b;
            Object c;
            int d;
            int e;
            int f;
            int g;
            long h;
            int i;
            private /* synthetic */ Object j;
            final /* synthetic */ C8093Um4 k;
            final /* synthetic */ a l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0693a(C8093Um4 c8093Um4, a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.k = c8093Um4;
                this.l = aVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0693a c0693a = new C0693a(this.k, this.l, interfaceC20295rm1);
                c0693a.j = obj;
                return c0693a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0693a) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x00ac  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x00b9  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005d -> B:23:0x00b7). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005f -> B:14:0x0075). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007e -> B:20:0x00a9). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00a6 -> B:20:0x00a9). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r23) {
                /*
                    Method dump skipped, instructions count: 191
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8093Um4.a.C0693a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        a() {
            this.b = AbstractC9131Yp6.a(new C0693a(C8093Um4.this, this, null));
        }

        public final void b(int i) {
            this.a = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.a != -1) {
                C8093Um4.this.b.A(this.a);
                this.a = -1;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8093Um4(C7620Sm4 c7620Sm4) {
        super(c7620Sm4);
        AbstractC13042fc3.i(c7620Sm4, "parent");
        this.b = c7620Sm4;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        return this.b.h(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        return this.b.j(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.b.m();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.b.y(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        return this.b.z(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        return this.b.C(collection);
    }
}
