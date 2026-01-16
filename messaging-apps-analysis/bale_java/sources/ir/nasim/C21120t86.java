package ir.nasim;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.gov.nist.core.Separators;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import ir.nasim.AbstractC7747Ta2;
import ir.nasim.C22473vI3;
import ir.nasim.C23183wV0;
import ir.nasim.InterfaceC17505n47;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: ir.nasim.t86, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C21120t86 implements InterfaceC13031fb2, InterfaceC17505n47, InterfaceC21340tV0 {
    private static final C11515d82 f = C11515d82.b("proto");
    private final C16646ld6 a;
    private final QV0 b;
    private final QV0 c;
    private final AbstractC13649gb2 d;
    private final InterfaceC7720Sx5 e;

    /* renamed from: ir.nasim.t86$b */
    interface b {
        Object apply(Object obj);
    }

    /* renamed from: ir.nasim.t86$c */
    private static class c {
        final String a;
        final String b;

        private c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    /* renamed from: ir.nasim.t86$d */
    interface d {
        Object a();
    }

    C21120t86(QV0 qv0, QV0 qv02, AbstractC13649gb2 abstractC13649gb2, C16646ld6 c16646ld6, InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = c16646ld6;
        this.b = qv0;
        this.c = qv02;
        this.d = abstractC13649gb2;
        this.e = interfaceC7720Sx5;
    }

    private long A0() {
        return s0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object A1(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    private C19141pq7 B0() {
        final long time = this.b.getTime();
        return (C19141pq7) D0(new b() { // from class: ir.nasim.j86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.X0(time, (SQLiteDatabase) obj);
            }
        });
    }

    private Long C0(SQLiteDatabase sQLiteDatabase, AbstractC5792Kv7 abstractC5792Kv7) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(abstractC5792Kv7.b(), String.valueOf(AbstractC6945Pq5.a(abstractC5792Kv7.d()))));
        if (abstractC5792Kv7.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(abstractC5792Kv7.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) d2(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: ir.nasim.f86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.b1((Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long E1(AbstractC7747Ta2 abstractC7747Ta2, AbstractC5792Kv7 abstractC5792Kv7, SQLiteDatabase sQLiteDatabase) {
        if (F0()) {
            c(1L, C22473vI3.b.CACHE_FULL, abstractC7747Ta2.j());
            return -1L;
        }
        long jK0 = k0(sQLiteDatabase, abstractC5792Kv7);
        int iE = this.d.e();
        byte[] bArrA = abstractC7747Ta2.e().a();
        boolean z = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jK0));
        contentValues.put("transport_name", abstractC7747Ta2.j());
        contentValues.put("timestamp_ms", Long.valueOf(abstractC7747Ta2.f()));
        contentValues.put("uptime_ms", Long.valueOf(abstractC7747Ta2.k()));
        contentValues.put("payload_encoding", abstractC7747Ta2.e().b().a());
        contentValues.put("code", abstractC7747Ta2.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put("payload", z ? bArrA : new byte[0]);
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z) {
            int iCeil = (int) Math.ceil(bArrA.length / iE);
            for (int i = 1; i <= iCeil; i++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i - 1) * iE, Math.min(i * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry entry : abstractC7747Ta2.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    private boolean F0() {
        return z0() * A0() >= this.d.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] G1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            byte[] bArr2 = (byte[]) arrayList.get(i);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    private List I0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            U45 u45 = (U45) listIterator.next();
            if (map.containsKey(Long.valueOf(u45.c()))) {
                AbstractC7747Ta2.a aVarL = u45.b().l();
                for (c cVar : (Set) map.get(Long.valueOf(u45.c()))) {
                    aVarL.c(cVar.a, cVar.b);
                }
                listIterator.set(U45.a(u45.c(), u45.d(), aVarL.d()));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object J0(Cursor cursor) {
        while (cursor.moveToNext()) {
            c(cursor.getInt(0), C22473vI3.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer L0(long j, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j)};
        d2(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: ir.nasim.X76
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return this.a.J0((Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object M1(Cursor cursor) {
        while (cursor.moveToNext()) {
            c(cursor.getInt(0), C22473vI3.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object N0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object O1(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        d2(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: ir.nasim.a86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return this.a.M1((Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object Q0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase R0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean R1(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long S0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object S1(String str, C22473vI3.b bVar, long j, SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (((Boolean) d2(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())}), new b() { // from class: ir.nasim.c86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.R1((Cursor) obj);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object T1(long j, AbstractC5792Kv7 abstractC5792Kv7, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{abstractC5792Kv7.b(), String.valueOf(AbstractC6945Pq5.a(abstractC5792Kv7.d()))}) < 1) {
            contentValues.put("backend_name", abstractC5792Kv7.b());
            contentValues.put("priority", Integer.valueOf(AbstractC6945Pq5.a(abstractC5792Kv7.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object U1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.b.getTime()).execute();
        return null;
    }

    private List V1(SQLiteDatabase sQLiteDatabase, final AbstractC5792Kv7 abstractC5792Kv7, int i) {
        final ArrayList arrayList = new ArrayList();
        Long lC0 = C0(sQLiteDatabase, abstractC5792Kv7);
        if (lC0 == null) {
            return arrayList;
        }
        d2(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lC0.toString()}, null, null, null, String.valueOf(i)), new b() { // from class: ir.nasim.b86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return this.a.z1(arrayList, abstractC5792Kv7, (Cursor) obj);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C19141pq7 W0(long j, Cursor cursor) {
        cursor.moveToNext();
        return C19141pq7.c().c(cursor.getLong(0)).b(j).a();
    }

    private Map W1(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(((U45) list.get(i)).c());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        d2(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new b() { // from class: ir.nasim.e86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.A1(map, (Cursor) obj);
            }
        });
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C19141pq7 X0(final long j, SQLiteDatabase sQLiteDatabase) {
        return (C19141pq7) d2(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: ir.nasim.k86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.W0(j, (Cursor) obj);
            }
        });
    }

    private static byte[] X1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void Y1(C23183wV0.a aVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            aVar.a(DI3.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    private byte[] Z1(long j) {
        return (byte[]) d2(s0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), new b() { // from class: ir.nasim.i86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.G1((Cursor) obj);
            }
        });
    }

    private Object a2(d dVar, b bVar) {
        long time = this.c.getTime();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.c.getTime() >= this.d.b() + time) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long b1(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    private static C11515d82 b2(String str) {
        return str == null ? f : C11515d82.b(str);
    }

    private static String c2(Iterable iterable) {
        StringBuilder sb = new StringBuilder(Separators.LPAREN);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((U45) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean d1(AbstractC5792Kv7 abstractC5792Kv7, SQLiteDatabase sQLiteDatabase) {
        Long lC0 = C0(sQLiteDatabase, abstractC5792Kv7);
        return lC0 == null ? Boolean.FALSE : (Boolean) d2(s0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lC0.toString()}), new b() { // from class: ir.nasim.Z76
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    static Object d2(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    private C22473vI3.b e0(int i) {
        C22473vI3.b bVar = C22473vI3.b.REASON_UNKNOWN;
        if (i == bVar.getNumber()) {
            return bVar;
        }
        C22473vI3.b bVar2 = C22473vI3.b.MESSAGE_TOO_OLD;
        if (i == bVar2.getNumber()) {
            return bVar2;
        }
        C22473vI3.b bVar3 = C22473vI3.b.CACHE_FULL;
        if (i == bVar3.getNumber()) {
            return bVar3;
        }
        C22473vI3.b bVar4 = C22473vI3.b.PAYLOAD_TOO_BIG;
        if (i == bVar4.getNumber()) {
            return bVar4;
        }
        C22473vI3.b bVar5 = C22473vI3.b.MAX_RETRIES_REACHED;
        if (i == bVar5.getNumber()) {
            return bVar5;
        }
        C22473vI3.b bVar6 = C22473vI3.b.INVALID_PAYLOD;
        if (i == bVar6.getNumber()) {
            return bVar6;
        }
        C22473vI3.b bVar7 = C22473vI3.b.SERVER_ERROR;
        if (i == bVar7.getNumber()) {
            return bVar7;
        }
        SI3.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i));
        return bVar;
    }

    private void f0(final SQLiteDatabase sQLiteDatabase) {
        a2(new d() { // from class: ir.nasim.S76
            @Override // ir.nasim.C21120t86.d
            public final Object a() {
                return C21120t86.N0(sQLiteDatabase);
            }
        }, new b() { // from class: ir.nasim.d86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.Q0((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List h1(SQLiteDatabase sQLiteDatabase) {
        return (List) d2(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: ir.nasim.q86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.l1((Cursor) obj);
            }
        });
    }

    private long k0(SQLiteDatabase sQLiteDatabase, AbstractC5792Kv7 abstractC5792Kv7) {
        Long lC0 = C0(sQLiteDatabase, abstractC5792Kv7);
        if (lC0 != null) {
            return lC0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", abstractC5792Kv7.b());
        contentValues.put("priority", Integer.valueOf(AbstractC6945Pq5.a(abstractC5792Kv7.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (abstractC5792Kv7.c() != null) {
            contentValues.put("extras", Base64.encodeToString(abstractC5792Kv7.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List l1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(AbstractC5792Kv7.a().b(cursor.getString(1)).d(AbstractC6945Pq5.b(cursor.getInt(2))).c(X1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List o1(AbstractC5792Kv7 abstractC5792Kv7, SQLiteDatabase sQLiteDatabase) {
        List listV1 = V1(sQLiteDatabase, abstractC5792Kv7, this.d.d());
        for (EnumC5979Lq5 enumC5979Lq5 : EnumC5979Lq5.values()) {
            if (enumC5979Lq5 != abstractC5792Kv7.d()) {
                int iD = this.d.d() - listV1.size();
                if (iD <= 0) {
                    break;
                }
                listV1.addAll(V1(sQLiteDatabase, abstractC5792Kv7.f(enumC5979Lq5), iD));
            }
        }
        return I0(listV1, W1(sQLiteDatabase, listV1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C23183wV0 s1(Map map, C23183wV0.a aVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            C22473vI3.b bVarE0 = e0(cursor.getInt(1));
            long j = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(C22473vI3.c().c(bVarE0).b(j).a());
        }
        Y1(aVar, map);
        aVar.e(B0());
        aVar.d(x0());
        aVar.c((String) this.e.get());
        return aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C23183wV0 w1(String str, final Map map, final C23183wV0.a aVar, SQLiteDatabase sQLiteDatabase) {
        return (C23183wV0) d2(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: ir.nasim.h86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return this.a.s1(map, aVar, (Cursor) obj);
            }
        });
    }

    private C15277jJ2 x0() {
        return C15277jJ2.b().b(KO6.c().b(m0()).c(AbstractC13649gb2.a.f()).a()).a();
    }

    private long z0() {
        return s0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object z1(List list, AbstractC5792Kv7 abstractC5792Kv7, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            AbstractC7747Ta2.a aVarK = AbstractC7747Ta2.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z) {
                aVarK.h(new X72(b2(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarK.h(new X72(b2(cursor.getString(4)), Z1(j)));
            }
            if (!cursor.isNull(6)) {
                aVarK.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(U45.a(j, abstractC5792Kv7, aVarK.d()));
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC13031fb2
    public boolean B1(final AbstractC5792Kv7 abstractC5792Kv7) {
        return ((Boolean) D0(new b() { // from class: ir.nasim.T76
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return this.a.d1(abstractC5792Kv7, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    Object D0(b bVar) {
        SQLiteDatabase sQLiteDatabaseS0 = s0();
        sQLiteDatabaseS0.beginTransaction();
        try {
            Object objApply = bVar.apply(sQLiteDatabaseS0);
            sQLiteDatabaseS0.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseS0.endTransaction();
        }
    }

    @Override // ir.nasim.InterfaceC13031fb2
    public U45 G0(final AbstractC5792Kv7 abstractC5792Kv7, final AbstractC7747Ta2 abstractC7747Ta2) {
        SI3.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", abstractC5792Kv7.d(), abstractC7747Ta2.j(), abstractC5792Kv7.b());
        long jLongValue = ((Long) D0(new b() { // from class: ir.nasim.g86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return this.a.E1(abstractC7747Ta2, abstractC5792Kv7, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return U45.a(jLongValue, abstractC5792Kv7, abstractC7747Ta2);
    }

    @Override // ir.nasim.InterfaceC13031fb2
    public Iterable I1(final AbstractC5792Kv7 abstractC5792Kv7) {
        return (Iterable) D0(new b() { // from class: ir.nasim.s86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return this.a.o1(abstractC5792Kv7, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC13031fb2
    public void K0(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + c2(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            D0(new b() { // from class: ir.nasim.r86
                @Override // ir.nasim.C21120t86.b
                public final Object apply(Object obj) {
                    return this.a.O1(str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    @Override // ir.nasim.InterfaceC13031fb2
    public void L(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            s0().compileStatement("DELETE FROM events WHERE _id in " + c2(iterable)).execute();
        }
    }

    @Override // ir.nasim.InterfaceC17505n47
    public Object a(InterfaceC17505n47.a aVar) {
        SQLiteDatabase sQLiteDatabaseS0 = s0();
        f0(sQLiteDatabaseS0);
        try {
            Object objExecute = aVar.execute();
            sQLiteDatabaseS0.setTransactionSuccessful();
            return objExecute;
        } finally {
            sQLiteDatabaseS0.endTransaction();
        }
    }

    @Override // ir.nasim.InterfaceC21340tV0
    public void b() {
        D0(new b() { // from class: ir.nasim.V76
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return this.a.U1((SQLiteDatabase) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC13031fb2
    public Iterable b0() {
        return (Iterable) D0(new b() { // from class: ir.nasim.n86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.h1((SQLiteDatabase) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC21340tV0
    public void c(final long j, final C22473vI3.b bVar, final String str) {
        D0(new b() { // from class: ir.nasim.W76
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.S1(str, bVar, j, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC13031fb2
    public long c1(AbstractC5792Kv7 abstractC5792Kv7) {
        return ((Long) d2(s0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{abstractC5792Kv7.b(), String.valueOf(AbstractC6945Pq5.a(abstractC5792Kv7.d()))}), new b() { // from class: ir.nasim.o86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.S0((Cursor) obj);
            }
        })).longValue();
    }

    @Override // ir.nasim.InterfaceC13031fb2
    public int cleanUp() {
        final long time = this.b.getTime() - this.d.c();
        return ((Integer) D0(new b() { // from class: ir.nasim.p86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return this.a.L0(time, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // ir.nasim.InterfaceC21340tV0
    public C23183wV0 d() {
        final C23183wV0.a aVarE = C23183wV0.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (C23183wV0) D0(new b() { // from class: ir.nasim.Y76
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return this.a.w1(str, map, aVarE, (SQLiteDatabase) obj);
            }
        });
    }

    long m0() {
        return z0() * A0();
    }

    SQLiteDatabase s0() {
        final C16646ld6 c16646ld6 = this.a;
        Objects.requireNonNull(c16646ld6);
        return (SQLiteDatabase) a2(new d() { // from class: ir.nasim.l86
            @Override // ir.nasim.C21120t86.d
            public final Object a() {
                return c16646ld6.getWritableDatabase();
            }
        }, new b() { // from class: ir.nasim.m86
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.R0((Throwable) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC13031fb2
    public void t1(final AbstractC5792Kv7 abstractC5792Kv7, final long j) {
        D0(new b() { // from class: ir.nasim.U76
            @Override // ir.nasim.C21120t86.b
            public final Object apply(Object obj) {
                return C21120t86.T1(j, abstractC5792Kv7, (SQLiteDatabase) obj);
            }
        });
    }
}
