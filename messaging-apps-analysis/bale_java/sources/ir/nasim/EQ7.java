package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/* loaded from: classes.dex */
final class EQ7 implements Collection, InterfaceC17915nm3 {
    private final AbstractC21411tc6 a;

    static final class a extends V06 implements InterfaceC14603iB2 {
        Object a;
        Object b;
        int c;
        int d;
        int e;
        int f;
        long g;
        int h;
        private /* synthetic */ Object i;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = EQ7.this.new a(interfaceC20295rm1);
            aVar.i = obj;
            return aVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0058 -> B:23:0x009d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005a -> B:14:0x006b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0074 -> B:20:0x0094). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0091 -> B:20:0x0094). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                r20 = this;
                r0 = r20
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.h
                r3 = 0
                r4 = 8
                r5 = 1
                if (r2 == 0) goto L33
                if (r2 != r5) goto L2b
                int r2 = r0.f
                int r6 = r0.e
                long r7 = r0.g
                int r9 = r0.d
                int r10 = r0.c
                java.lang.Object r11 = r0.b
                long[] r11 = (long[]) r11
                java.lang.Object r12 = r0.a
                java.lang.Object[] r12 = (java.lang.Object[]) r12
                java.lang.Object r13 = r0.i
                ir.nasim.Op6 r13 = (ir.nasim.AbstractC6703Op6) r13
                ir.nasim.AbstractC10685c16.b(r21)
                goto L94
            L2b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L33:
                ir.nasim.AbstractC10685c16.b(r21)
                java.lang.Object r2 = r0.i
                ir.nasim.Op6 r2 = (ir.nasim.AbstractC6703Op6) r2
                ir.nasim.EQ7 r6 = ir.nasim.EQ7.this
                ir.nasim.tc6 r6 = ir.nasim.EQ7.f(r6)
                java.lang.Object[] r7 = r6.c
                long[] r6 = r6.a
                int r8 = r6.length
                int r8 = r8 + (-2)
                if (r8 < 0) goto La2
                r9 = r3
            L4a:
                r10 = r6[r9]
                long r12 = ~r10
                r14 = 7
                long r12 = r12 << r14
                long r12 = r12 & r10
                r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r12 = r12 & r14
                int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r12 == 0) goto L9d
                int r12 = r9 - r8
                int r12 = ~r12
                int r12 = r12 >>> 31
                int r12 = 8 - r12
                r13 = r2
                r2 = r3
                r18 = r10
                r11 = r6
                r10 = r8
                r6 = r12
                r12 = r7
                r7 = r18
            L6b:
                if (r2 >= r6) goto L97
                r14 = 255(0xff, double:1.26E-321)
                long r14 = r14 & r7
                r16 = 128(0x80, double:6.3E-322)
                int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                if (r14 >= 0) goto L94
                int r14 = r9 << 3
                int r14 = r14 + r2
                r14 = r12[r14]
                r0.i = r13
                r0.a = r12
                r0.b = r11
                r0.c = r10
                r0.d = r9
                r0.g = r7
                r0.e = r6
                r0.f = r2
                r0.h = r5
                java.lang.Object r14 = r13.c(r14, r0)
                if (r14 != r1) goto L94
                return r1
            L94:
                long r7 = r7 >> r4
                int r2 = r2 + r5
                goto L6b
            L97:
                if (r6 != r4) goto La2
                r8 = r10
                r6 = r11
                r7 = r12
                r2 = r13
            L9d:
                if (r9 == r8) goto La2
                int r9 = r9 + 1
                goto L4a
            La2:
                ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EQ7.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public EQ7(AbstractC21411tc6 abstractC21411tc6) {
        AbstractC13042fc3.i(abstractC21411tc6, "parent");
        this.a = abstractC21411tc6;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.a.d(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!this.a.d(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int h() {
        return this.a.e;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.a.h();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return AbstractC9131Yp6.a(new a(null));
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return h();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return UW0.a(this);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "array");
        return UW0.b(this, objArr);
    }
}
