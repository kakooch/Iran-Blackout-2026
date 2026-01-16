package ir.nasim;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import ir.nasim.InterfaceC13330g27;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public abstract class D26 {
    public static final c o = new c(null);
    protected volatile InterfaceC12694f27 a;
    private Executor b;
    private Executor c;
    private InterfaceC13330g27 d;
    private boolean f;
    private boolean g;
    protected List h;
    private C15946kS k;
    private final Map m;
    private final Map n;
    private final androidx.room.d e = h();
    private Map i = new LinkedHashMap();
    private final ReentrantReadWriteLock j = new ReentrantReadWriteLock();
    private final ThreadLocal l = new ThreadLocal();

    public static class a {
        private final Context a;
        private final Class b;
        private final String c;
        private final List d;
        private final List e;
        private List f;
        private Executor g;
        private Executor h;
        private InterfaceC13330g27.c i;
        private boolean j;
        private d k;
        private Intent l;
        private boolean m;
        private boolean n;
        private long o;
        private TimeUnit p;
        private final e q;
        private Set r;
        private Set s;
        private String t;
        private File u;
        private Callable v;

        public a(Context context, Class cls, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(cls, "klass");
            this.a = context;
            this.b = cls;
            this.c = str;
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.k = d.AUTOMATIC;
            this.m = true;
            this.o = -1L;
            this.q = new e();
            this.r = new LinkedHashSet();
        }

        public a a(b bVar) {
            AbstractC13042fc3.i(bVar, "callback");
            this.d.add(bVar);
            return this;
        }

        public a b(AbstractC9264Ze4... abstractC9264Ze4Arr) {
            AbstractC13042fc3.i(abstractC9264Ze4Arr, "migrations");
            if (this.s == null) {
                this.s = new HashSet();
            }
            for (AbstractC9264Ze4 abstractC9264Ze4 : abstractC9264Ze4Arr) {
                Set set = this.s;
                AbstractC13042fc3.f(set);
                set.add(Integer.valueOf(abstractC9264Ze4.a));
                Set set2 = this.s;
                AbstractC13042fc3.f(set2);
                set2.add(Integer.valueOf(abstractC9264Ze4.b));
            }
            this.q.b((AbstractC9264Ze4[]) Arrays.copyOf(abstractC9264Ze4Arr, abstractC9264Ze4Arr.length));
            return this;
        }

        public a c(Object obj) {
            AbstractC13042fc3.i(obj, "typeConverter");
            this.e.add(obj);
            return this;
        }

        public a d() {
            this.j = true;
            return this;
        }

        public D26 e() {
            Executor executor = this.g;
            if (executor == null && this.h == null) {
                Executor executorF = TI.f();
                this.h = executorF;
                this.g = executorF;
            } else if (executor != null && this.h == null) {
                this.h = executor;
            } else if (executor == null) {
                this.g = this.h;
            }
            Set set = this.s;
            if (set != null) {
                AbstractC13042fc3.f(set);
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (!(!this.r.contains(Integer.valueOf(iIntValue)))) {
                        throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + iIntValue).toString());
                    }
                }
            }
            InterfaceC13330g27.c r76 = this.i;
            if (r76 == null) {
                r76 = new C13405gA2();
            }
            if (r76 != null) {
                if (this.o > 0) {
                    if (this.c == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
                    }
                    long j = this.o;
                    TimeUnit timeUnit = this.p;
                    if (timeUnit == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    Executor executor2 = this.g;
                    if (executor2 == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    r76 = new C17128mS(r76, new C15946kS(j, timeUnit, executor2));
                }
                String str = this.t;
                if (str != null || this.u != null || this.v != null) {
                    if (this.c == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.".toString());
                    }
                    int i = str == null ? 0 : 1;
                    File file = this.u;
                    int i2 = file == null ? 0 : 1;
                    Callable callable = this.v;
                    if (i + i2 + (callable != null ? 1 : 0) != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.".toString());
                    }
                    r76 = new R76(str, file, callable, r76);
                }
            } else {
                r76 = null;
            }
            InterfaceC13330g27.c cVar = r76;
            if (cVar == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            Context context = this.a;
            String str2 = this.c;
            e eVar = this.q;
            List list = this.d;
            boolean z = this.j;
            d dVarP = this.k.p(context);
            Executor executor3 = this.g;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            Executor executor4 = this.h;
            if (executor4 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            C5822Kz1 c5822Kz1 = new C5822Kz1(context, str2, cVar, eVar, list, z, dVarP, executor3, executor4, this.l, this.m, this.n, this.r, this.t, this.u, this.v, null, this.e, this.f);
            D26 d26 = (D26) C26.b(this.b, "_Impl");
            d26.w(c5822Kz1);
            return d26;
        }

        public a f(String str) {
            AbstractC13042fc3.i(str, "databaseFilePath");
            this.t = str;
            return this;
        }

        public a g() {
            this.m = false;
            this.n = true;
            return this;
        }

        public a h(InterfaceC13330g27.c cVar) {
            this.i = cVar;
            return this;
        }

        public a i(Executor executor) {
            AbstractC13042fc3.i(executor, "executor");
            this.g = executor;
            return this;
        }
    }

    public static abstract class b {
        public void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
        }

        public void b(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
        }

        public void c(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "db");
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    public enum d {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private final boolean j(ActivityManager activityManager) {
            return C10080b27.b(activityManager);
        }

        public final d p(Context context) {
            AbstractC13042fc3.i(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || j(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    public static class e {
        private final Map a = new LinkedHashMap();

        private final void a(AbstractC9264Ze4 abstractC9264Ze4) {
            int i = abstractC9264Ze4.a;
            int i2 = abstractC9264Ze4.b;
            Map map = this.a;
            Integer numValueOf = Integer.valueOf(i);
            Object treeMap = map.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                map.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i2))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i2)) + " with " + abstractC9264Ze4);
            }
            treeMap2.put(Integer.valueOf(i2), abstractC9264Ze4);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final java.util.List e(java.util.List r7, boolean r8, int r9, int r10) {
            /*
                r6 = this;
            L0:
                if (r8 == 0) goto L5
                if (r9 >= r10) goto L63
                goto L7
            L5:
                if (r9 <= r10) goto L63
            L7:
                java.util.Map r0 = r6.a
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
                java.lang.Object r0 = r0.get(r1)
                java.util.TreeMap r0 = (java.util.TreeMap) r0
                r1 = 0
                if (r0 != 0) goto L17
                return r1
            L17:
                if (r8 == 0) goto L1e
                java.util.NavigableSet r2 = r0.descendingKeySet()
                goto L22
            L1e:
                java.util.Set r2 = r0.keySet()
            L22:
                java.util.Iterator r2 = r2.iterator()
            L26:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L5f
                java.lang.Object r3 = r2.next()
                java.lang.Integer r3 = (java.lang.Integer) r3
                java.lang.String r4 = "targetVersion"
                if (r8 == 0) goto L44
                int r5 = r9 + 1
                ir.nasim.AbstractC13042fc3.h(r3, r4)
                int r4 = r3.intValue()
                if (r5 > r4) goto L26
                if (r4 > r10) goto L26
                goto L4f
            L44:
                ir.nasim.AbstractC13042fc3.h(r3, r4)
                int r4 = r3.intValue()
                if (r10 > r4) goto L26
                if (r4 >= r9) goto L26
            L4f:
                java.lang.Object r9 = r0.get(r3)
                ir.nasim.AbstractC13042fc3.f(r9)
                r7.add(r9)
                int r9 = r3.intValue()
                r0 = 1
                goto L60
            L5f:
                r0 = 0
            L60:
                if (r0 != 0) goto L0
                return r1
            L63:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.D26.e.e(java.util.List, boolean, int, int):java.util.List");
        }

        public void b(AbstractC9264Ze4... abstractC9264Ze4Arr) {
            AbstractC13042fc3.i(abstractC9264Ze4Arr, "migrations");
            for (AbstractC9264Ze4 abstractC9264Ze4 : abstractC9264Ze4Arr) {
                a(abstractC9264Ze4);
            }
        }

        public final boolean c(int i, int i2) {
            Map mapF = f();
            if (!mapF.containsKey(Integer.valueOf(i))) {
                return false;
            }
            Map mapK = (Map) mapF.get(Integer.valueOf(i));
            if (mapK == null) {
                mapK = AbstractC20051rO3.k();
            }
            return mapK.containsKey(Integer.valueOf(i2));
        }

        public List d(int i, int i2) {
            if (i == i2) {
                return AbstractC10360bX0.m();
            }
            return e(new ArrayList(), i2 > i, i, i2);
        }

        public Map f() {
            return this.a;
        }
    }

    public static abstract class f {
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "it");
            D26.this.x();
            return null;
        }
    }

    static final class h extends AbstractC8614Ws3 implements UA2 {
        h() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "it");
            D26.this.y();
            return null;
        }
    }

    public D26() {
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        AbstractC13042fc3.h(mapSynchronizedMap, "synchronizedMap(mutableMapOf())");
        this.m = mapSynchronizedMap;
        this.n = new LinkedHashMap();
    }

    public static /* synthetic */ Cursor E(D26 d26, InterfaceC14514i27 interfaceC14514i27, CancellationSignal cancellationSignal, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i & 2) != 0) {
            cancellationSignal = null;
        }
        return d26.D(interfaceC14514i27, cancellationSignal);
    }

    private final Object G(Class cls, InterfaceC13330g27 interfaceC13330g27) {
        if (cls.isInstance(interfaceC13330g27)) {
            return interfaceC13330g27;
        }
        if (interfaceC13330g27 instanceof SG1) {
            return G(cls, ((SG1) interfaceC13330g27).a());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        c();
        InterfaceC12694f27 interfaceC12694f27E = o().E();
        n().x(interfaceC12694f27E);
        if (interfaceC12694f27E.N1()) {
            interfaceC12694f27E.j0();
        } else {
            interfaceC12694f27E.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        o().E().t0();
        if (v()) {
            return;
        }
        n().n();
    }

    public final boolean A() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public boolean B() {
        Boolean boolValueOf;
        boolean zIsOpen;
        C15946kS c15946kS = this.k;
        if (c15946kS != null) {
            zIsOpen = c15946kS.l();
        } else {
            InterfaceC12694f27 interfaceC12694f27 = this.a;
            if (interfaceC12694f27 == null) {
                boolValueOf = null;
                return AbstractC13042fc3.d(boolValueOf, Boolean.TRUE);
            }
            zIsOpen = interfaceC12694f27.isOpen();
        }
        boolValueOf = Boolean.valueOf(zIsOpen);
        return AbstractC13042fc3.d(boolValueOf, Boolean.TRUE);
    }

    public final boolean C() {
        InterfaceC12694f27 interfaceC12694f27 = this.a;
        return interfaceC12694f27 != null && interfaceC12694f27.isOpen();
    }

    public Cursor D(InterfaceC14514i27 interfaceC14514i27, CancellationSignal cancellationSignal) {
        AbstractC13042fc3.i(interfaceC14514i27, "query");
        c();
        d();
        return cancellationSignal != null ? o().E().p0(interfaceC14514i27, cancellationSignal) : o().E().P1(interfaceC14514i27);
    }

    public void F() {
        o().E().h0();
    }

    public void c() {
        if (!this.f && !(!A())) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
        }
    }

    public void d() {
        if (!v() && this.l.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
        }
    }

    public void e() {
        c();
        C15946kS c15946kS = this.k;
        if (c15946kS == null) {
            x();
        } else {
            c15946kS.g(new g());
        }
    }

    public void f() {
        if (B()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.j.writeLock();
            AbstractC13042fc3.h(writeLock, "readWriteLock.writeLock()");
            writeLock.lock();
            try {
                n().u();
                o().close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public InterfaceC15121j27 g(String str) {
        AbstractC13042fc3.i(str, "sql");
        c();
        d();
        return o().E().Z0(str);
    }

    protected abstract androidx.room.d h();

    protected abstract InterfaceC13330g27 i(C5822Kz1 c5822Kz1);

    public void j() {
        C15946kS c15946kS = this.k;
        if (c15946kS == null) {
            y();
        } else {
            c15946kS.g(new h());
        }
    }

    public List k(Map map) {
        AbstractC13042fc3.i(map, "autoMigrationSpecs");
        return AbstractC10360bX0.m();
    }

    public final Map l() {
        return this.m;
    }

    public final Lock m() {
        ReentrantReadWriteLock.ReadLock lock = this.j.readLock();
        AbstractC13042fc3.h(lock, "readWriteLock.readLock()");
        return lock;
    }

    public androidx.room.d n() {
        return this.e;
    }

    public InterfaceC13330g27 o() {
        InterfaceC13330g27 interfaceC13330g27 = this.d;
        if (interfaceC13330g27 != null) {
            return interfaceC13330g27;
        }
        AbstractC13042fc3.y("internalOpenHelper");
        return null;
    }

    public Executor p() {
        Executor executor = this.b;
        if (executor != null) {
            return executor;
        }
        AbstractC13042fc3.y("internalQueryExecutor");
        return null;
    }

    public Set q() {
        return AbstractC4597Fu6.d();
    }

    protected Map r() {
        return AbstractC20051rO3.k();
    }

    public final ThreadLocal s() {
        return this.l;
    }

    public Executor t() {
        Executor executor = this.c;
        if (executor != null) {
            return executor;
        }
        AbstractC13042fc3.y("internalTransactionExecutor");
        return null;
    }

    public Object u(Class cls) {
        AbstractC13042fc3.i(cls, "klass");
        return this.n.get(cls);
    }

    public boolean v() {
        return o().E().D1();
    }

    public void w(C5822Kz1 c5822Kz1) {
        AbstractC13042fc3.i(c5822Kz1, "configuration");
        this.d = i(c5822Kz1);
        Set setQ = q();
        BitSet bitSet = new BitSet();
        Iterator it = setQ.iterator();
        while (true) {
            int i = -1;
            if (it.hasNext()) {
                Class cls = (Class) it.next();
                int size = c5822Kz1.r.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = size - 1;
                        if (cls.isAssignableFrom(c5822Kz1.r.get(size).getClass())) {
                            bitSet.set(size);
                            i = size;
                            break;
                        } else if (i2 < 0) {
                            break;
                        } else {
                            size = i2;
                        }
                    }
                }
                if (i < 0) {
                    throw new IllegalArgumentException(("A required auto migration spec (" + cls.getCanonicalName() + ") is missing in the database configuration.").toString());
                }
                this.i.put(cls, c5822Kz1.r.get(i));
            } else {
                int size2 = c5822Kz1.r.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i3 = size2 - 1;
                        if (!bitSet.get(size2)) {
                            throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
                        }
                        if (i3 < 0) {
                            break;
                        } else {
                            size2 = i3;
                        }
                    }
                }
                for (AbstractC9264Ze4 abstractC9264Ze4 : k(this.i)) {
                    if (!c5822Kz1.d.c(abstractC9264Ze4.a, abstractC9264Ze4.b)) {
                        c5822Kz1.d.b(abstractC9264Ze4);
                    }
                }
                Q76 q76 = (Q76) G(Q76.class, o());
                if (q76 != null) {
                    q76.d(c5822Kz1);
                }
                C16537lS c16537lS = (C16537lS) G(C16537lS.class, o());
                if (c16537lS != null) {
                    this.k = c16537lS.b;
                    n().r(c16537lS.b);
                }
                boolean z = c5822Kz1.g == d.WRITE_AHEAD_LOGGING;
                o().setWriteAheadLoggingEnabled(z);
                this.h = c5822Kz1.e;
                this.b = c5822Kz1.h;
                this.c = new ExecutorC12617eu7(c5822Kz1.i);
                this.f = c5822Kz1.f;
                this.g = z;
                if (c5822Kz1.j != null) {
                    if (c5822Kz1.b == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    n().s(c5822Kz1.a, c5822Kz1.b, c5822Kz1.j);
                }
                Map mapR = r();
                BitSet bitSet2 = new BitSet();
                for (Map.Entry entry : mapR.entrySet()) {
                    Class cls2 = (Class) entry.getKey();
                    for (Class cls3 : (List) entry.getValue()) {
                        int size3 = c5822Kz1.q.size() - 1;
                        if (size3 >= 0) {
                            while (true) {
                                int i4 = size3 - 1;
                                if (cls3.isAssignableFrom(c5822Kz1.q.get(size3).getClass())) {
                                    bitSet2.set(size3);
                                    break;
                                } else if (i4 < 0) {
                                    break;
                                } else {
                                    size3 = i4;
                                }
                            }
                            size3 = -1;
                        } else {
                            size3 = -1;
                        }
                        if (size3 < 0) {
                            throw new IllegalArgumentException(("A required type converter (" + cls3 + ") for " + cls2.getCanonicalName() + " is missing in the database configuration.").toString());
                        }
                        this.n.put(cls3, c5822Kz1.q.get(size3));
                    }
                }
                int size4 = c5822Kz1.q.size() - 1;
                if (size4 < 0) {
                    return;
                }
                while (true) {
                    int i5 = size4 - 1;
                    if (!bitSet2.get(size4)) {
                        throw new IllegalArgumentException("Unexpected type converter " + c5822Kz1.q.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                    }
                    if (i5 < 0) {
                        return;
                    } else {
                        size4 = i5;
                    }
                }
            }
        }
    }

    protected void z(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "db");
        n().k(interfaceC12694f27);
    }
}
