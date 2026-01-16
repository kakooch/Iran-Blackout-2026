package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.Dm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C4055Dm4 extends TL4 implements Set, InterfaceC24531ym3 {
    private final C3821Cm4 b;

    /* renamed from: ir.nasim.Dm4$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private int a = -1;
        private final Iterator b;

        /* renamed from: ir.nasim.Dm4$a$a, reason: collision with other inner class name */
        static final class C0326a extends V06 implements InterfaceC14603iB2 {
            Object a;
            Object b;
            Object c;
            int d;
            int e;
            private /* synthetic */ Object f;
            final /* synthetic */ C4055Dm4 g;
            final /* synthetic */ a h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0326a(C4055Dm4 c4055Dm4, a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.g = c4055Dm4;
                this.h = aVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0326a c0326a = new C0326a(this.g, this.h, interfaceC20295rm1);
                c0326a.f = obj;
                return c0326a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0326a) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                C4055Dm4 c4055Dm4;
                int i;
                AbstractC6703Op6 abstractC6703Op6;
                a aVar;
                long[] jArr;
                Object objE = AbstractC14862ic3.e();
                int i2 = this.e;
                if (i2 == 0) {
                    AbstractC10685c16.b(obj);
                    AbstractC6703Op6 abstractC6703Op62 = (AbstractC6703Op6) this.f;
                    C3821Cm4 c3821Cm4 = this.g.b;
                    a aVar2 = this.h;
                    c4055Dm4 = this.g;
                    long[] jArr2 = c3821Cm4.c;
                    i = c3821Cm4.e;
                    abstractC6703Op6 = abstractC6703Op62;
                    aVar = aVar2;
                    jArr = jArr2;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = this.d;
                    jArr = (long[]) this.c;
                    c4055Dm4 = (C4055Dm4) this.b;
                    aVar = (a) this.a;
                    abstractC6703Op6 = (AbstractC6703Op6) this.f;
                    AbstractC10685c16.b(obj);
                }
                while (i != Integer.MAX_VALUE) {
                    int i3 = (int) ((jArr[i] >> 31) & TTL.MAX_VALUE);
                    aVar.b(i);
                    Object obj2 = c4055Dm4.b.b[i];
                    this.f = abstractC6703Op6;
                    this.a = aVar;
                    this.b = c4055Dm4;
                    this.c = jArr;
                    this.d = i3;
                    this.e = 1;
                    if (abstractC6703Op6.c(obj2, this) == objE) {
                        return objE;
                    }
                    i = i3;
                }
                return C19938rB7.a;
            }
        }

        a() {
            this.b = AbstractC9131Yp6.a(new C0326a(C4055Dm4.this, this, null));
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
                C4055Dm4.this.b.z(this.a);
                this.a = -1;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4055Dm4(C3821Cm4 c3821Cm4) {
        super(c3821Cm4);
        AbstractC13042fc3.i(c3821Cm4, "parent");
        this.b = c3821Cm4;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        return this.b.g(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        return this.b.h(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.b.k();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.b.x(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        return this.b.y(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        return this.b.B(collection);
    }
}
