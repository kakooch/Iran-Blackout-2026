package ir.nasim;

import ir.nasim.InterfaceC19286q55;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: ir.nasim.hH6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14063hH6 implements InterfaceC14710iL6, List, RandomAccess, InterfaceC19688qm3 {
    private AbstractC16481lL6 a;

    /* renamed from: ir.nasim.hH6$a */
    public static final class a extends AbstractC16481lL6 {
        private InterfaceC19286q55 c;
        private int d;
        private int e;

        public a(long j, InterfaceC19286q55 interfaceC19286q55) {
            super(j);
            this.c = interfaceC19286q55;
        }

        @Override // ir.nasim.AbstractC16481lL6
        public void c(AbstractC16481lL6 abstractC16481lL6) {
            synchronized (AbstractC14665iH6.a) {
                AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord>");
                this.c = ((a) abstractC16481lL6).c;
                this.d = ((a) abstractC16481lL6).d;
                this.e = ((a) abstractC16481lL6).e;
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }

        @Override // ir.nasim.AbstractC16481lL6
        public AbstractC16481lL6 d(long j) {
            return new a(j, this.c);
        }

        public final InterfaceC19286q55 i() {
            return this.c;
        }

        public final int j() {
            return this.d;
        }

        public final int k() {
            return this.e;
        }

        public final void l(InterfaceC19286q55 interfaceC19286q55) {
            this.c = interfaceC19286q55;
        }

        public final void m(int i) {
            this.d = i;
        }

        public final void n(int i) {
            this.e = i;
        }
    }

    /* renamed from: ir.nasim.hH6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;
        final /* synthetic */ Collection f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, Collection collection) {
            super(1);
            this.e = i;
            this.f = collection;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            return Boolean.valueOf(list.addAll(this.e, this.f));
        }
    }

    /* renamed from: ir.nasim.hH6$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Collection e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Collection collection) {
            super(1);
            this.e = collection;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            return Boolean.valueOf(list.retainAll(this.e));
        }
    }

    public C14063hH6(InterfaceC19286q55 interfaceC19286q55) {
        this.a = F(interfaceC19286q55);
    }

    private final boolean A(UA2 ua2) {
        int iJ;
        InterfaceC19286q55 interfaceC19286q55I;
        Object objInvoke;
        androidx.compose.runtime.snapshots.g gVarC;
        boolean zO;
        do {
            synchronized (AbstractC14665iH6.a) {
                AbstractC16481lL6 abstractC16481lL6J = j();
                AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J);
                iJ = aVar.j();
                interfaceC19286q55I = aVar.i();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC13042fc3.f(interfaceC19286q55I);
            InterfaceC19286q55.a aVarM = interfaceC19286q55I.m();
            objInvoke = ua2.invoke(aVarM);
            InterfaceC19286q55 interfaceC19286q55A = aVarM.a();
            if (AbstractC13042fc3.d(interfaceC19286q55A, interfaceC19286q55I)) {
                break;
            }
            AbstractC16481lL6 abstractC16481lL6J2 = j();
            AbstractC13042fc3.g(abstractC16481lL6J2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) abstractC16481lL6J2;
            synchronized (androidx.compose.runtime.snapshots.j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                zO = o((a) androidx.compose.runtime.snapshots.j.h0(aVar2, this, gVarC), iJ, interfaceC19286q55A, true);
            }
            androidx.compose.runtime.snapshots.j.Q(gVarC, this);
        } while (!zO);
        return ((Boolean) objInvoke).booleanValue();
    }

    private final AbstractC16481lL6 F(InterfaceC19286q55 interfaceC19286q55) {
        androidx.compose.runtime.snapshots.g gVarI = androidx.compose.runtime.snapshots.j.I();
        a aVar = new a(gVarI.i(), interfaceC19286q55);
        if (!(gVarI instanceof androidx.compose.runtime.snapshots.a)) {
            aVar.g(new a(SG6.c(1), interfaceC19286q55));
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(a aVar, int i, InterfaceC19286q55 interfaceC19286q55, boolean z) {
        boolean z2;
        synchronized (AbstractC14665iH6.a) {
            try {
                if (aVar.j() == i) {
                    aVar.l(interfaceC19286q55);
                    z2 = true;
                    if (z) {
                        aVar.n(aVar.k() + 1);
                    }
                    aVar.m(aVar.j() + 1);
                } else {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public Object B(int i) {
        int iJ;
        InterfaceC19286q55 interfaceC19286q55I;
        androidx.compose.runtime.snapshots.g gVarC;
        boolean zO;
        Object obj = get(i);
        do {
            synchronized (AbstractC14665iH6.a) {
                AbstractC16481lL6 abstractC16481lL6J = j();
                AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J);
                iJ = aVar.j();
                interfaceC19286q55I = aVar.i();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC13042fc3.f(interfaceC19286q55I);
            InterfaceC19286q55 interfaceC19286q55E0 = interfaceC19286q55I.e0(i);
            if (AbstractC13042fc3.d(interfaceC19286q55E0, interfaceC19286q55I)) {
                break;
            }
            AbstractC16481lL6 abstractC16481lL6J2 = j();
            AbstractC13042fc3.g(abstractC16481lL6J2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) abstractC16481lL6J2;
            synchronized (androidx.compose.runtime.snapshots.j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                zO = o((a) androidx.compose.runtime.snapshots.j.h0(aVar2, this, gVarC), iJ, interfaceC19286q55E0, true);
            }
            androidx.compose.runtime.snapshots.j.Q(gVarC, this);
        } while (!zO);
        return obj;
    }

    public final void C(int i, int i2) {
        int iJ;
        InterfaceC19286q55 interfaceC19286q55I;
        androidx.compose.runtime.snapshots.g gVarC;
        boolean zO;
        do {
            synchronized (AbstractC14665iH6.a) {
                AbstractC16481lL6 abstractC16481lL6J = j();
                AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J);
                iJ = aVar.j();
                interfaceC19286q55I = aVar.i();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC13042fc3.f(interfaceC19286q55I);
            InterfaceC19286q55.a aVarM = interfaceC19286q55I.m();
            aVarM.subList(i, i2).clear();
            InterfaceC19286q55 interfaceC19286q55A = aVarM.a();
            if (AbstractC13042fc3.d(interfaceC19286q55A, interfaceC19286q55I)) {
                return;
            }
            AbstractC16481lL6 abstractC16481lL6J2 = j();
            AbstractC13042fc3.g(abstractC16481lL6J2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) abstractC16481lL6J2;
            synchronized (androidx.compose.runtime.snapshots.j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                zO = o((a) androidx.compose.runtime.snapshots.j.h0(aVar2, this, gVarC), iJ, interfaceC19286q55A, true);
            }
            androidx.compose.runtime.snapshots.j.Q(gVarC, this);
        } while (!zO);
    }

    public final int E(Collection collection, int i, int i2) {
        int iJ;
        InterfaceC19286q55 interfaceC19286q55I;
        androidx.compose.runtime.snapshots.g gVarC;
        boolean zO;
        int size = size();
        do {
            synchronized (AbstractC14665iH6.a) {
                AbstractC16481lL6 abstractC16481lL6J = j();
                AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J);
                iJ = aVar.j();
                interfaceC19286q55I = aVar.i();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC13042fc3.f(interfaceC19286q55I);
            InterfaceC19286q55.a aVarM = interfaceC19286q55I.m();
            aVarM.subList(i, i2).retainAll(collection);
            InterfaceC19286q55 interfaceC19286q55A = aVarM.a();
            if (AbstractC13042fc3.d(interfaceC19286q55A, interfaceC19286q55I)) {
                break;
            }
            AbstractC16481lL6 abstractC16481lL6J2 = j();
            AbstractC13042fc3.g(abstractC16481lL6J2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) abstractC16481lL6J2;
            synchronized (androidx.compose.runtime.snapshots.j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                zO = o((a) androidx.compose.runtime.snapshots.j.h0(aVar2, this, gVarC), iJ, interfaceC19286q55A, true);
            }
            androidx.compose.runtime.snapshots.j.Q(gVarC, this);
        } while (!zO);
        return size - size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        int iJ;
        InterfaceC19286q55 interfaceC19286q55I;
        androidx.compose.runtime.snapshots.g gVarC;
        boolean zO;
        do {
            synchronized (AbstractC14665iH6.a) {
                AbstractC16481lL6 abstractC16481lL6J = j();
                AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J);
                iJ = aVar.j();
                interfaceC19286q55I = aVar.i();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC13042fc3.f(interfaceC19286q55I);
            InterfaceC19286q55 interfaceC19286q55Add = interfaceC19286q55I.add(obj);
            if (AbstractC13042fc3.d(interfaceC19286q55Add, interfaceC19286q55I)) {
                return false;
            }
            AbstractC16481lL6 abstractC16481lL6J2 = j();
            AbstractC13042fc3.g(abstractC16481lL6J2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) abstractC16481lL6J2;
            synchronized (androidx.compose.runtime.snapshots.j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                zO = o((a) androidx.compose.runtime.snapshots.j.h0(aVar2, this, gVarC), iJ, interfaceC19286q55Add, true);
            }
            androidx.compose.runtime.snapshots.j.Q(gVarC, this);
        } while (!zO);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        return A(new b(i, collection));
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        androidx.compose.runtime.snapshots.g gVarC;
        AbstractC16481lL6 abstractC16481lL6J = j();
        AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        a aVar = (a) abstractC16481lL6J;
        synchronized (androidx.compose.runtime.snapshots.j.J()) {
            gVarC = androidx.compose.runtime.snapshots.g.e.c();
            a aVar2 = (a) androidx.compose.runtime.snapshots.j.h0(aVar, this, gVarC);
            synchronized (AbstractC14665iH6.a) {
                aVar2.l(AbstractC7078Qe2.a());
                aVar2.m(aVar2.j() + 1);
                aVar2.n(aVar2.k() + 1);
            }
        }
        androidx.compose.runtime.snapshots.j.Q(gVarC, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return t().i().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        return t().i().containsAll(collection);
    }

    @Override // java.util.List
    public Object get(int i) {
        return t().i().get(i);
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public void i(AbstractC16481lL6 abstractC16481lL6) {
        abstractC16481lL6.g(j());
        AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.a = (a) abstractC16481lL6;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return t().i().indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return t().i().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator();
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public AbstractC16481lL6 j() {
        return this.a;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return t().i().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new C14099hL6(this, 0);
    }

    @Override // java.util.List
    public final /* bridge */ Object remove(int i) {
        return B(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        int iJ;
        InterfaceC19286q55 interfaceC19286q55I;
        androidx.compose.runtime.snapshots.g gVarC;
        boolean zO;
        do {
            synchronized (AbstractC14665iH6.a) {
                AbstractC16481lL6 abstractC16481lL6J = j();
                AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J);
                iJ = aVar.j();
                interfaceC19286q55I = aVar.i();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC13042fc3.f(interfaceC19286q55I);
            InterfaceC19286q55 interfaceC19286q55RemoveAll = interfaceC19286q55I.removeAll(collection);
            if (AbstractC13042fc3.d(interfaceC19286q55RemoveAll, interfaceC19286q55I)) {
                return false;
            }
            AbstractC16481lL6 abstractC16481lL6J2 = j();
            AbstractC13042fc3.g(abstractC16481lL6J2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) abstractC16481lL6J2;
            synchronized (androidx.compose.runtime.snapshots.j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                zO = o((a) androidx.compose.runtime.snapshots.j.h0(aVar2, this, gVarC), iJ, interfaceC19286q55RemoveAll, true);
            }
            androidx.compose.runtime.snapshots.j.Q(gVarC, this);
        } while (!zO);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        return A(new c(collection));
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        int iJ;
        InterfaceC19286q55 interfaceC19286q55I;
        androidx.compose.runtime.snapshots.g gVarC;
        boolean zO;
        Object obj2 = get(i);
        do {
            synchronized (AbstractC14665iH6.a) {
                AbstractC16481lL6 abstractC16481lL6J = j();
                AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J);
                iJ = aVar.j();
                interfaceC19286q55I = aVar.i();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC13042fc3.f(interfaceC19286q55I);
            InterfaceC19286q55 interfaceC19286q55 = interfaceC19286q55I.set(i, obj);
            if (AbstractC13042fc3.d(interfaceC19286q55, interfaceC19286q55I)) {
                break;
            }
            AbstractC16481lL6 abstractC16481lL6J2 = j();
            AbstractC13042fc3.g(abstractC16481lL6J2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) abstractC16481lL6J2;
            synchronized (androidx.compose.runtime.snapshots.j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                zO = o((a) androidx.compose.runtime.snapshots.j.h0(aVar2, this, gVarC), iJ, interfaceC19286q55, false);
            }
            androidx.compose.runtime.snapshots.j.Q(gVarC, this);
        } while (!zO);
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return v();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        if (!(i >= 0 && i <= i2 && i2 <= size())) {
            AbstractC5214Ij5.a("fromIndex or toIndex are out of bounds");
        }
        return new PZ6(this, i, i2);
    }

    public final a t() {
        AbstractC16481lL6 abstractC16481lL6J = j();
        AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (a) androidx.compose.runtime.snapshots.j.X((a) abstractC16481lL6J, this);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return UW0.a(this);
    }

    public String toString() {
        AbstractC16481lL6 abstractC16481lL6J = j();
        AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J)).i() + ")@" + hashCode();
    }

    public int v() {
        return t().i().size();
    }

    public final int x() {
        AbstractC16481lL6 abstractC16481lL6J = j();
        AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J)).k();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        int iJ;
        InterfaceC19286q55 interfaceC19286q55I;
        androidx.compose.runtime.snapshots.g gVarC;
        boolean zO;
        do {
            synchronized (AbstractC14665iH6.a) {
                AbstractC16481lL6 abstractC16481lL6J = j();
                AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J);
                iJ = aVar.j();
                interfaceC19286q55I = aVar.i();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC13042fc3.f(interfaceC19286q55I);
            InterfaceC19286q55 interfaceC19286q55AddAll = interfaceC19286q55I.addAll(collection);
            if (AbstractC13042fc3.d(interfaceC19286q55AddAll, interfaceC19286q55I)) {
                return false;
            }
            AbstractC16481lL6 abstractC16481lL6J2 = j();
            AbstractC13042fc3.g(abstractC16481lL6J2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) abstractC16481lL6J2;
            synchronized (androidx.compose.runtime.snapshots.j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                zO = o((a) androidx.compose.runtime.snapshots.j.h0(aVar2, this, gVarC), iJ, interfaceC19286q55AddAll, true);
            }
            androidx.compose.runtime.snapshots.j.Q(gVarC, this);
        } while (!zO);
        return true;
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return new C14099hL6(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int iJ;
        InterfaceC19286q55 interfaceC19286q55I;
        androidx.compose.runtime.snapshots.g gVarC;
        boolean zO;
        do {
            synchronized (AbstractC14665iH6.a) {
                AbstractC16481lL6 abstractC16481lL6J = j();
                AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J);
                iJ = aVar.j();
                interfaceC19286q55I = aVar.i();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC13042fc3.f(interfaceC19286q55I);
            InterfaceC19286q55 interfaceC19286q55Remove = interfaceC19286q55I.remove(obj);
            if (AbstractC13042fc3.d(interfaceC19286q55Remove, interfaceC19286q55I)) {
                return false;
            }
            AbstractC16481lL6 abstractC16481lL6J2 = j();
            AbstractC13042fc3.g(abstractC16481lL6J2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) abstractC16481lL6J2;
            synchronized (androidx.compose.runtime.snapshots.j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                zO = o((a) androidx.compose.runtime.snapshots.j.h0(aVar2, this, gVarC), iJ, interfaceC19286q55Remove, true);
            }
            androidx.compose.runtime.snapshots.j.Q(gVarC, this);
        } while (!zO);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return UW0.b(this, objArr);
    }

    public C14063hH6() {
        this(AbstractC7078Qe2.a());
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        int iJ;
        InterfaceC19286q55 interfaceC19286q55I;
        androidx.compose.runtime.snapshots.g gVarC;
        boolean zO;
        do {
            synchronized (AbstractC14665iH6.a) {
                AbstractC16481lL6 abstractC16481lL6J = j();
                AbstractC13042fc3.g(abstractC16481lL6J, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                a aVar = (a) androidx.compose.runtime.snapshots.j.G((a) abstractC16481lL6J);
                iJ = aVar.j();
                interfaceC19286q55I = aVar.i();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC13042fc3.f(interfaceC19286q55I);
            InterfaceC19286q55 interfaceC19286q55Add = interfaceC19286q55I.add(i, obj);
            if (AbstractC13042fc3.d(interfaceC19286q55Add, interfaceC19286q55I)) {
                return;
            }
            AbstractC16481lL6 abstractC16481lL6J2 = j();
            AbstractC13042fc3.g(abstractC16481lL6J2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            a aVar2 = (a) abstractC16481lL6J2;
            synchronized (androidx.compose.runtime.snapshots.j.J()) {
                gVarC = androidx.compose.runtime.snapshots.g.e.c();
                zO = o((a) androidx.compose.runtime.snapshots.j.h0(aVar2, this, gVarC), iJ, interfaceC19286q55Add, true);
            }
            androidx.compose.runtime.snapshots.j.Q(gVarC, this);
        } while (!zO);
    }
}
