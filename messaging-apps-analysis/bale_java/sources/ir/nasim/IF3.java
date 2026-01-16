package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes4.dex */
public final class IF3 {
    private final InterfaceC20315ro1 a;
    private final F84 b;
    private final E84 c;
    private final OK7 d;
    private final AbstractC13778go1 e;
    private final C4275El f;
    private final ReentrantReadWriteLock g;
    private final HashSet h;
    private int i;
    private long j;
    private boolean k;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.IF3$a$a, reason: collision with other inner class name */
        static final class C0413a implements InterfaceC4806Gq2 {
            final /* synthetic */ IF3 a;

            C0413a(IF3 if3) {
                this.a = if3;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
                ReentrantReadWriteLock reentrantReadWriteLock = this.a.g;
                IF3 if3 = this.a;
                ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
                lock.lock();
                try {
                    ArrayList arrayList = new ArrayList(if3.h);
                    if3.h.clear();
                    lock.unlock();
                    if (arrayList.isEmpty()) {
                        return C19938rB7.a;
                    }
                    Object objF = this.a.f(arrayList, interfaceC20295rm1);
                    return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return IF3.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC6459Nq2.r(AbstractC3851Cp7.f(5000L, 1500L, null, null, 12, null));
                C0413a c0413a = new C0413a(IF3.this);
                this.b = 1;
                if (interfaceC4557Fq2R.b(c0413a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return IF3.this.f(null, this);
        }
    }

    public IF3(InterfaceC20315ro1 interfaceC20315ro1, F84 f84, E84 e84, OK7 ok7, AbstractC13778go1 abstractC13778go1, C4275El c4275El) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(f84, "messagesRepository");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        AbstractC13042fc3.i(c4275El, "albumDataStore");
        this.a = interfaceC20315ro1;
        this.b = f84;
        this.c = e84;
        this.d = ok7;
        this.e = abstractC13778go1;
        this.f = c4275El;
        this.g = new ReentrantReadWriteLock(true);
        this.h = new HashSet();
        this.k = true;
        e();
    }

    private final InterfaceC13730gj3 e() {
        return AbstractC10533bm0.d(this.a, this.e, null, new a(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0221 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.util.ArrayList r47, ir.nasim.InterfaceC20295rm1 r48) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IF3.f(java.util.ArrayList, ir.nasim.rm1):java.lang.Object");
    }

    public final void d(ArrayList arrayList, int i, long j, boolean z) {
        AbstractC13042fc3.i(arrayList, "messages");
        this.i = i;
        this.k = z;
        this.j = j;
        ReentrantReadWriteLock reentrantReadWriteLock = this.g;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            HashSet hashSet = this.h;
            ArrayList<J44> arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                J44 j44 = (J44) obj;
                if (j44.L() != EnumC23558x74.ERROR && j44.L() != EnumC23558x74.PENDING) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
            for (J44 j442 : arrayList2) {
                arrayList3.add(new Q64(j442.h(), j442.i()));
            }
            hashSet.addAll(arrayList3);
            while (i2 < readHoldCount) {
                lock.lock();
                i2++;
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i2 < readHoldCount) {
                lock.lock();
                i2++;
            }
            writeLock.unlock();
            throw th;
        }
    }
}
