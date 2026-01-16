package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC4363Eu6;
import ir.nasim.AbstractC4597Fu6;
import ir.nasim.C10446bd3;
import ir.nasim.C15946kS;
import ir.nasim.C18145o96;
import ir.nasim.C19938rB7;
import ir.nasim.D26;
import ir.nasim.ED1;
import ir.nasim.InterfaceC12694f27;
import ir.nasim.InterfaceC15121j27;
import ir.nasim.TC6;
import ir.nasim.YV0;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public class d {
    public static final a q = new a(null);
    private static final String[] r = {"UPDATE", "DELETE", "INSERT"};
    private final D26 a;
    private final Map b;
    private final Map c;
    private final Map d;
    private final String[] e;
    private C15946kS f;
    private final AtomicBoolean g;
    private volatile boolean h;
    private volatile InterfaceC15121j27 i;
    private final b j;
    private final C10446bd3 k;
    private final C18145o96 l;
    private androidx.room.e m;
    private final Object n;
    private final Object o;
    public final Runnable p;

    public static final class a {
        private a() {
        }

        public final void a(InterfaceC12694f27 interfaceC12694f27) {
            AbstractC13042fc3.i(interfaceC12694f27, "database");
            if (interfaceC12694f27.N1()) {
                interfaceC12694f27.j0();
            } else {
                interfaceC12694f27.I();
            }
        }

        public final String b(String str, String str2) {
            AbstractC13042fc3.i(str, "tableName");
            AbstractC13042fc3.i(str2, "triggerType");
            return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
        public static final a e = new a(null);
        private final long[] a;
        private final boolean[] b;
        private final int[] c;
        private boolean d;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public b(int i) {
            this.a = new long[i];
            this.b = new boolean[i];
            this.c = new int[i];
        }

        public final int[] a() {
            synchronized (this) {
                try {
                    if (!this.d) {
                        return null;
                    }
                    long[] jArr = this.a;
                    int length = jArr.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        int i4 = 1;
                        boolean z = jArr[i] > 0;
                        boolean[] zArr = this.b;
                        if (z != zArr[i2]) {
                            int[] iArr = this.c;
                            if (!z) {
                                i4 = 2;
                            }
                            iArr[i2] = i4;
                        } else {
                            this.c[i2] = 0;
                        }
                        zArr[i2] = z;
                        i++;
                        i2 = i3;
                    }
                    this.d = false;
                    return (int[]) this.c.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean b(int... iArr) {
            boolean z;
            AbstractC13042fc3.i(iArr, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : iArr) {
                        long[] jArr = this.a;
                        long j = jArr[i];
                        jArr[i] = 1 + j;
                        if (j == 0) {
                            this.d = true;
                            z = true;
                        }
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public final boolean c(int... iArr) {
            boolean z;
            AbstractC13042fc3.i(iArr, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : iArr) {
                        long[] jArr = this.a;
                        long j = jArr[i];
                        jArr[i] = j - 1;
                        if (j == 1) {
                            this.d = true;
                            z = true;
                        }
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public final void d() {
            synchronized (this) {
                Arrays.fill(this.b, false);
                this.d = true;
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }
    }

    public static abstract class c {
        private final String[] a;

        public c(String[] strArr) {
            AbstractC13042fc3.i(strArr, "tables");
            this.a = strArr;
        }

        public final String[] a() {
            return this.a;
        }

        public boolean b() {
            return false;
        }

        public abstract void c(Set set);
    }

    /* renamed from: androidx.room.d$d, reason: collision with other inner class name */
    public static final class C0122d {
        private final c a;
        private final int[] b;
        private final String[] c;
        private final Set d;

        public C0122d(c cVar, int[] iArr, String[] strArr) {
            AbstractC13042fc3.i(cVar, "observer");
            AbstractC13042fc3.i(iArr, "tableIds");
            AbstractC13042fc3.i(strArr, "tableNames");
            this.a = cVar;
            this.b = iArr;
            this.c = strArr;
            this.d = (strArr.length == 0) ^ true ? AbstractC4363Eu6.c(strArr[0]) : AbstractC4597Fu6.d();
            if (iArr.length != strArr.length) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final int[] a() {
            return this.b;
        }

        public final void b(Set set) {
            Set setD;
            AbstractC13042fc3.i(set, "invalidatedTablesIds");
            int[] iArr = this.b;
            int length = iArr.length;
            if (length != 0) {
                int i = 0;
                if (length != 1) {
                    Set setB = AbstractC4363Eu6.b();
                    int[] iArr2 = this.b;
                    int length2 = iArr2.length;
                    int i2 = 0;
                    while (i < length2) {
                        int i3 = i2 + 1;
                        if (set.contains(Integer.valueOf(iArr2[i]))) {
                            setB.add(this.c[i2]);
                        }
                        i++;
                        i2 = i3;
                    }
                    setD = AbstractC4363Eu6.a(setB);
                } else {
                    setD = set.contains(Integer.valueOf(iArr[0])) ? this.d : AbstractC4597Fu6.d();
                }
            } else {
                setD = AbstractC4597Fu6.d();
            }
            if (!setD.isEmpty()) {
                this.a.c(setD);
            }
        }

        public final void c(String[] strArr) {
            Set setD;
            AbstractC13042fc3.i(strArr, "tables");
            int length = this.c.length;
            if (length == 0) {
                setD = AbstractC4597Fu6.d();
            } else if (length == 1) {
                int length2 = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length2) {
                        setD = AbstractC4597Fu6.d();
                        break;
                    } else {
                        if (AbstractC20153rZ6.D(strArr[i], this.c[0], true)) {
                            setD = this.d;
                            break;
                        }
                        i++;
                    }
                }
            } else {
                Set setB = AbstractC4363Eu6.b();
                for (String str : strArr) {
                    for (String str2 : this.c) {
                        if (AbstractC20153rZ6.D(str2, str, true)) {
                            setB.add(str2);
                        }
                    }
                }
                setD = AbstractC4363Eu6.a(setB);
            }
            if (!setD.isEmpty()) {
                this.a.c(setD);
            }
        }
    }

    public static final class e extends c {
        private final d b;
        private final WeakReference c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d dVar, c cVar) {
            super(cVar.a());
            AbstractC13042fc3.i(dVar, "tracker");
            AbstractC13042fc3.i(cVar, "delegate");
            this.b = dVar;
            this.c = new WeakReference(cVar);
        }

        @Override // androidx.room.d.c
        public void c(Set set) {
            AbstractC13042fc3.i(set, "tables");
            c cVar = (c) this.c.get();
            if (cVar == null) {
                this.b.p(this);
            } else {
                cVar.c(set);
            }
        }
    }

    public static final class f implements Runnable {
        f() {
        }

        private final Set a() throws IOException {
            d dVar = d.this;
            Set setB = AbstractC4363Eu6.b();
            Cursor cursorE = D26.E(dVar.g(), new TC6("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
            try {
                Cursor cursor = cursorE;
                while (cursor.moveToNext()) {
                    setB.add(Integer.valueOf(cursor.getInt(0)));
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                YV0.a(cursorE, null);
                Set setA = AbstractC4363Eu6.a(setB);
                if (!setA.isEmpty()) {
                    if (d.this.f() == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    InterfaceC15121j27 interfaceC15121j27F = d.this.f();
                    if (interfaceC15121j27F == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    interfaceC15121j27F.V();
                }
                return setA;
            } finally {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Set setD;
            C15946kS c15946kS;
            C15946kS c15946kS2;
            Lock lockM = d.this.g().m();
            lockM.lock();
            try {
                try {
                } finally {
                    lockM.unlock();
                    c15946kS2 = d.this.f;
                    if (c15946kS2 != null) {
                        c15946kS2.e();
                    }
                }
            } catch (SQLiteException e) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                setD = AbstractC4597Fu6.d();
                lockM.unlock();
                c15946kS = d.this.f;
                if (c15946kS != null) {
                }
            } catch (IllegalStateException e2) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                setD = AbstractC4597Fu6.d();
                lockM.unlock();
                c15946kS = d.this.f;
                if (c15946kS != null) {
                }
            }
            if (!d.this.e()) {
                if (c15946kS2 != null) {
                    return;
                } else {
                    return;
                }
            }
            if (!d.this.i().compareAndSet(true, false)) {
                lockM.unlock();
                C15946kS c15946kS3 = d.this.f;
                if (c15946kS3 != null) {
                    c15946kS3.e();
                    return;
                }
                return;
            }
            if (d.this.g().v()) {
                lockM.unlock();
                C15946kS c15946kS4 = d.this.f;
                if (c15946kS4 != null) {
                    c15946kS4.e();
                    return;
                }
                return;
            }
            InterfaceC12694f27 interfaceC12694f27E = d.this.g().o().E();
            interfaceC12694f27E.j0();
            try {
                setD = a();
                interfaceC12694f27E.h0();
                lockM.unlock();
                c15946kS = d.this.f;
                if (c15946kS != null) {
                    c15946kS.e();
                }
                if (!setD.isEmpty()) {
                    C18145o96 c18145o96H = d.this.h();
                    d dVar = d.this;
                    synchronized (c18145o96H) {
                        try {
                            Iterator it = dVar.h().iterator();
                            while (it.hasNext()) {
                                ((C0122d) ((Map.Entry) it.next()).getValue()).b(setD);
                            }
                            C19938rB7 c19938rB7 = C19938rB7.a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } finally {
                interfaceC12694f27E.t0();
            }
        }
    }

    public d(D26 d26, Map map, Map map2, String... strArr) {
        String lowerCase;
        AbstractC13042fc3.i(d26, "database");
        AbstractC13042fc3.i(map, "shadowTablesMap");
        AbstractC13042fc3.i(map2, "viewTables");
        AbstractC13042fc3.i(strArr, "tableNames");
        this.a = d26;
        this.b = map;
        this.c = map2;
        this.g = new AtomicBoolean(false);
        this.j = new b(strArr.length);
        this.k = new C10446bd3(d26);
        this.l = new C18145o96();
        this.n = new Object();
        this.o = new Object();
        this.d = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.US;
            AbstractC13042fc3.h(locale, "US");
            String lowerCase2 = str.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.d.put(lowerCase2, Integer.valueOf(i));
            String str2 = (String) this.b.get(strArr[i]);
            if (str2 != null) {
                AbstractC13042fc3.h(locale, "US");
                lowerCase = str2.toLowerCase(locale);
                AbstractC13042fc3.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i] = lowerCase2;
        }
        this.e = strArr2;
        for (Map.Entry entry : this.b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            AbstractC13042fc3.h(locale2, "US");
            String lowerCase3 = str3.toLowerCase(locale2);
            AbstractC13042fc3.h(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.d.containsKey(lowerCase3)) {
                String str4 = (String) entry.getKey();
                AbstractC13042fc3.h(locale2, "US");
                String lowerCase4 = str4.toLowerCase(locale2);
                AbstractC13042fc3.h(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                Map map3 = this.d;
                map3.put(lowerCase4, AbstractC20051rO3.l(map3, lowerCase3));
            }
        }
        this.p = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        synchronized (this.o) {
            this.h = false;
            this.j.d();
            InterfaceC15121j27 interfaceC15121j27 = this.i;
            if (interfaceC15121j27 != null) {
                interfaceC15121j27.close();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }
    }

    private final String[] q(String[] strArr) {
        Set setB = AbstractC4363Eu6.b();
        for (String str : strArr) {
            Map map = this.c;
            Locale locale = Locale.US;
            AbstractC13042fc3.h(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map map2 = this.c;
                AbstractC13042fc3.h(locale, "US");
                String lowerCase2 = str.toLowerCase(locale);
                AbstractC13042fc3.h(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Object obj = map2.get(lowerCase2);
                AbstractC13042fc3.f(obj);
                setB.addAll((Collection) obj);
            } else {
                setB.add(str);
            }
        }
        return (String[]) AbstractC4363Eu6.a(setB).toArray(new String[0]);
    }

    private final void t(InterfaceC12694f27 interfaceC12694f27, int i) {
        interfaceC12694f27.O("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.e[i];
        for (String str2 : r) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + q.b(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i + " AND invalidated = 0; END";
            AbstractC13042fc3.h(str3, "StringBuilder().apply(builderAction).toString()");
            interfaceC12694f27.O(str3);
        }
    }

    private final void v(InterfaceC12694f27 interfaceC12694f27, int i) {
        String str = this.e[i];
        for (String str2 : r) {
            String str3 = "DROP TRIGGER IF EXISTS " + q.b(str, str2);
            AbstractC13042fc3.h(str3, "StringBuilder().apply(builderAction).toString()");
            interfaceC12694f27.O(str3);
        }
    }

    public void c(c cVar) {
        C0122d c0122d;
        AbstractC13042fc3.i(cVar, "observer");
        String[] strArrQ = q(cVar.a());
        ArrayList arrayList = new ArrayList(strArrQ.length);
        for (String str : strArrQ) {
            Map map = this.d;
            Locale locale = Locale.US;
            AbstractC13042fc3.h(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = (Integer) map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            arrayList.add(num);
        }
        int[] iArrL1 = AbstractC15401jX0.l1(arrayList);
        C0122d c0122d2 = new C0122d(cVar, iArrL1, strArrQ);
        synchronized (this.l) {
            c0122d = (C0122d) this.l.r(cVar, c0122d2);
        }
        if (c0122d == null && this.j.b(Arrays.copyOf(iArrL1, iArrL1.length))) {
            w();
        }
    }

    public void d(c cVar) {
        AbstractC13042fc3.i(cVar, "observer");
        c(new e(this, cVar));
    }

    public final boolean e() {
        if (!this.a.C()) {
            return false;
        }
        if (!this.h) {
            this.a.o().E();
        }
        if (this.h) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final InterfaceC15121j27 f() {
        return this.i;
    }

    public final D26 g() {
        return this.a;
    }

    public final C18145o96 h() {
        return this.l;
    }

    public final AtomicBoolean i() {
        return this.g;
    }

    public final Map j() {
        return this.d;
    }

    public final void k(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "database");
        synchronized (this.o) {
            if (this.h) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            interfaceC12694f27.O("PRAGMA temp_store = MEMORY;");
            interfaceC12694f27.O("PRAGMA recursive_triggers='ON';");
            interfaceC12694f27.O("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            x(interfaceC12694f27);
            this.i = interfaceC12694f27.Z0("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            this.h = true;
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final void l(String... strArr) {
        AbstractC13042fc3.i(strArr, "tables");
        synchronized (this.l) {
            try {
                for (Map.Entry entry : this.l) {
                    AbstractC13042fc3.h(entry, "(observer, wrapper)");
                    c cVar = (c) entry.getKey();
                    C0122d c0122d = (C0122d) entry.getValue();
                    if (!cVar.b()) {
                        c0122d.c(strArr);
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n() {
        if (this.g.compareAndSet(false, true)) {
            C15946kS c15946kS = this.f;
            if (c15946kS != null) {
                c15946kS.j();
            }
            this.a.p().execute(this.p);
        }
    }

    public void o() {
        C15946kS c15946kS = this.f;
        if (c15946kS != null) {
            c15946kS.j();
        }
        w();
        this.p.run();
    }

    public void p(c cVar) {
        C0122d c0122d;
        AbstractC13042fc3.i(cVar, "observer");
        synchronized (this.l) {
            c0122d = (C0122d) this.l.t(cVar);
        }
        if (c0122d != null) {
            b bVar = this.j;
            int[] iArrA = c0122d.a();
            if (bVar.c(Arrays.copyOf(iArrA, iArrA.length))) {
                w();
            }
        }
    }

    public final void r(C15946kS c15946kS) {
        AbstractC13042fc3.i(c15946kS, "autoCloser");
        this.f = c15946kS;
        c15946kS.m(new Runnable() { // from class: ir.nasim.dd3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m();
            }
        });
    }

    public final void s(Context context, String str, Intent intent) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(intent, "serviceIntent");
        this.m = new androidx.room.e(context, str, intent, this, this.a.p());
    }

    public final void u() {
        androidx.room.e eVar = this.m;
        if (eVar != null) {
            eVar.o();
        }
        this.m = null;
    }

    public final void w() {
        if (this.a.C()) {
            x(this.a.o().E());
        }
    }

    public final void x(InterfaceC12694f27 interfaceC12694f27) {
        AbstractC13042fc3.i(interfaceC12694f27, "database");
        if (interfaceC12694f27.D1()) {
            return;
        }
        try {
            Lock lockM = this.a.m();
            lockM.lock();
            try {
                synchronized (this.n) {
                    int[] iArrA = this.j.a();
                    if (iArrA == null) {
                        return;
                    }
                    q.a(interfaceC12694f27);
                    try {
                        int length = iArrA.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            int i3 = iArrA[i];
                            int i4 = i2 + 1;
                            if (i3 == 1) {
                                t(interfaceC12694f27, i2);
                            } else if (i3 == 2) {
                                v(interfaceC12694f27, i2);
                            }
                            i++;
                            i2 = i4;
                        }
                        interfaceC12694f27.h0();
                        interfaceC12694f27.t0();
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    } catch (Throwable th) {
                        interfaceC12694f27.t0();
                        throw th;
                    }
                }
            } finally {
                lockM.unlock();
            }
        } catch (SQLiteException e2) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
        } catch (IllegalStateException e3) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
        }
    }
}
