package ir.nasim;

import ir.nasim.HY1;
import ir.nasim.LY1;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/* loaded from: classes6.dex */
public final class HY1 {
    private final InterfaceC9336Zm4 a;

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            a aVar = (a) this.c;
            return AbstractC15401jX0.f1(aVar.c(), aVar.b());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HY1(int i) {
        this.a = AbstractC12281eL6.a(new a(i, null, 2, 0 == true ? 1 : 0));
    }

    public static /* synthetic */ void e(HY1 hy1, MX1 mx1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        hy1.c(mx1, z);
    }

    public final void a(NX1 nx1) {
        Object value;
        a aVar;
        TreeSet treeSet;
        Object next;
        AbstractC13042fc3.i(nx1, "downloadItem");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
        do {
            value = interfaceC9336Zm4.getValue();
            aVar = (a) value;
            treeSet = new TreeSet((SortedSet) aVar.f());
            Iterator it = treeSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (AbstractC13042fc3.d((NX1) next, nx1)) {
                        break;
                    }
                }
            }
            NX1 nx12 = (NX1) next;
            if (nx12 != null) {
                treeSet.remove(nx12);
                treeSet.add(nx1.p(nx12.j()));
            } else {
                treeSet.add(nx1);
            }
        } while (!interfaceC9336Zm4.f(value, a.e(aVar, 0, treeSet, 1, null)));
    }

    public final Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = AbstractC6459Nq2.v(AbstractC6459Nq2.X(this.a, new b(null))).b(interfaceC4806Gq2, interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public final void c(MX1 mx1, boolean z) {
        Object value;
        a aVarE;
        Object next;
        AbstractC13042fc3.i(mx1, "input");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
        do {
            value = interfaceC9336Zm4.getValue();
            aVarE = (a) value;
            Iterator it = aVarE.f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (AbstractC13042fc3.d(((NX1) next).i(), mx1)) {
                        break;
                    }
                }
            }
            NX1 nx1 = (NX1) next;
            if (nx1 == null) {
                OX1.a(101, "cancelAutoDownload not success, item not found", mx1);
            } else if (!z || (nx1.j() instanceof LY1.a)) {
                TreeSet treeSet = new TreeSet((SortedSet) aVarE.f());
                treeSet.remove(nx1);
                OX1.a(101, "cancelAutoDownload success", mx1);
                aVarE = a.e(aVarE, 0, treeSet, 1, null);
            } else {
                OX1.a(101, "cancelAutoDownload not success, item is not AutoStart", mx1);
            }
        } while (!interfaceC9336Zm4.f(value, aVarE));
    }

    public final void d(C4995Hl2 c4995Hl2) {
        Object value;
        a aVarE;
        Object next;
        AbstractC13042fc3.i(c4995Hl2, "location");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
        do {
            value = interfaceC9336Zm4.getValue();
            aVarE = (a) value;
            Iterator it = aVarE.f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (AbstractC13042fc3.d(((NX1) next).i().c(), c4995Hl2)) {
                        break;
                    }
                }
            }
            NX1 nx1 = (NX1) next;
            if (nx1 != null) {
                TreeSet treeSet = new TreeSet((SortedSet) aVarE.f());
                treeSet.remove(nx1);
                aVarE = a.e(aVarE, 0, treeSet, 1, null);
            }
        } while (!interfaceC9336Zm4.f(value, aVarE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        private final int a;
        private final TreeSet b;

        public a(int i, TreeSet treeSet) {
            AbstractC13042fc3.i(treeSet, "sortedDownloadItems");
            this.a = i;
            this.b = treeSet;
        }

        public static /* synthetic */ a e(a aVar, int i, TreeSet treeSet, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = aVar.a;
            }
            if ((i2 & 2) != 0) {
                treeSet = aVar.b;
            }
            return aVar.d(i, treeSet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence g(NX1 nx1) {
            AbstractC13042fc3.i(nx1, "it");
            return nx1.toString();
        }

        public final int b() {
            return this.a;
        }

        public final TreeSet c() {
            return this.b;
        }

        public final a d(int i, TreeSet treeSet) {
            AbstractC13042fc3.i(treeSet, "sortedDownloadItems");
            return new a(i, treeSet);
        }

        public boolean equals(Object obj) {
            return this == obj;
        }

        public final TreeSet f() {
            return this.b;
        }

        public int hashCode() {
            return System.identityHashCode(this);
        }

        public String toString() {
            return "QueueState: concurrentDownloads=" + this.a + "\nsortedDownloadItems=" + AbstractC15401jX0.A0(this.b, ",", null, null, 0, null, new UA2() { // from class: ir.nasim.GY1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return HY1.a.g((NX1) obj);
                }
            }, 30, null);
        }

        public /* synthetic */ a(int i, TreeSet treeSet, int i2, ED1 ed1) {
            this(i, (i2 & 2) != 0 ? new TreeSet() : treeSet);
        }
    }
}
