package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.db.DBUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class I6 {
    public final ReentrantReadWriteLock.ReadLock a;
    public final ReentrantReadWriteLock.WriteLock b;
    public final V6 c;
    public final H6 d;
    public final Object e;
    public final ArrayList f;
    public final Context g;
    public final C2484d5 h;
    public final AtomicLong i;
    public final ArrayList j;
    public final E6 k;
    public final C2486d7 l;

    static {
        HashSet hashSet = new HashSet();
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        hashSet.add(0);
        hashSet.add(6400);
    }

    public I6(C2484d5 c2484d5, V6 v6, E6 e6, C2486d7 c2486d7) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.a = reentrantReadWriteLock.readLock();
        this.b = reentrantReadWriteLock.writeLock();
        this.e = new Object();
        this.f = new ArrayList(3);
        AtomicLong atomicLong = new AtomicLong();
        this.i = atomicLong;
        this.j = new ArrayList();
        this.c = v6;
        this.g = c2484d5.getContext();
        this.h = c2484d5;
        this.k = e6;
        this.l = c2486d7;
        atomicLong.set(b());
        H6 h6 = new H6(this, c2484d5);
        this.d = h6;
        h6.setName(a(c2484d5));
    }

    public final long a() {
        this.a.lock();
        try {
            return this.i.get();
        } finally {
            this.a.unlock();
        }
    }

    public final long b() {
        SQLiteDatabase readableDatabase;
        this.a.lock();
        try {
            readableDatabase = this.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        long jQueryRowsCount = readableDatabase != null ? DBUtils.queryRowsCount(readableDatabase, "events") : 0L;
        this.a.unlock();
        return jQueryRowsCount;
    }

    public final void c() {
        Cursor cursor;
        Cursor cursorRawQuery;
        this.a.lock();
        Cursor cursorRawQuery2 = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursorRawQuery = readableDatabase.rawQuery(" SELECT DISTINCT id From sessions order by id asc ", new String[0]);
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("All sessions in db: ");
                    while (cursorRawQuery.moveToNext()) {
                        stringBuffer.append(cursorRawQuery.getString(0));
                        stringBuffer.append(", ");
                    }
                    cursorRawQuery2 = readableDatabase.rawQuery(" SELECT DISTINCT session_id From events order by session_id asc ", new String[0]);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("All sessions in reports db: ");
                    while (cursorRawQuery2.moveToNext()) {
                        stringBuffer2.append(cursorRawQuery2.getString(0));
                        stringBuffer2.append(", ");
                    }
                } catch (Throwable unused) {
                    cursor = cursorRawQuery2;
                    cursorRawQuery2 = cursorRawQuery;
                    cursorRawQuery = cursorRawQuery2;
                    cursorRawQuery2 = cursor;
                    this.a.unlock();
                    hn.a(cursorRawQuery);
                    hn.a(cursorRawQuery2);
                }
            } else {
                cursorRawQuery = null;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        this.a.unlock();
        hn.a(cursorRawQuery);
        hn.a(cursorRawQuery2);
    }

    public final void d() {
        this.d.start();
    }

    public final long a(Set set) {
        this.a.lock();
        Cursor cursorRawQuery = null;
        long j = 0;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                StringBuilder sb = new StringBuilder("SELECT count() FROM events");
                if (!set.isEmpty()) {
                    sb.append(" WHERE ");
                }
                Iterator it = set.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    if (i > 0) {
                        sb.append(" OR ");
                    }
                    sb.append("type == " + num);
                    i++;
                }
                cursorRawQuery = readableDatabase.rawQuery(sb.toString(), null);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                }
            }
        } catch (Throwable unused) {
        }
        hn.a(cursorRawQuery);
        this.a.unlock();
        return j;
    }

    public final void a(L8 l8) {
        this.j.add(l8);
    }

    public static String a(InterfaceC2992ya interfaceC2992ya) {
        return "DatabaseWorker [" + interfaceC2992ya.b().e() + "]";
    }

    public final void a(long j, Wj wj, long j2) {
        JSONObject jSONObject;
        boolean zA;
        C2821r7 c2821r7 = new C2821r7(null, 1, null);
        Cg cg = (Cg) this.h.l.a();
        Long lValueOf = Long.valueOf(j);
        Long lValueOf2 = Long.valueOf(j2);
        try {
            jSONObject = new JSONObject().put("dId", cg.getDeviceId()).put("uId", cg.getUuid()).put("appVer", cg.getAppVersion()).put("appBuild", cg.getAppBuildNumber()).put("kitBuildType", cg.getAnalyticsSdkBuildType()).put("osVer", cg.getOsVersion()).put("osApiLev", cg.getOsApiLevel()).put("lang", cg.getLocale()).put("root", cg.getDeviceRootStatus()).put("app_debuggable", ((O5) cg).a).put(CommonUrlParts.APP_FRAMEWORK, cg.getAppFramework()).put("attribution_id", cg.s).put("analyticsSdkVersionName", cg.getAnalyticsSdkVersionName()).put("kitBuildNumber", cg.getAnalyticsSdkBuildNumber());
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        Long lValueOf3 = Long.valueOf(Em.a());
        C2642jj c2642jj = AbstractC2618ij.a;
        synchronized (c2642jj) {
            zA = c2642jj.b.a(true);
        }
        ContentValues contentValuesFromModel = c2821r7.fromModel(new C2798q7(lValueOf, wj, string, new C2774p7(lValueOf2, lValueOf3, Boolean.valueOf(zA))));
        if (contentValuesFromModel == null) {
            return;
        }
        this.b.lock();
        try {
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.insertOrThrow("sessions", null, contentValuesFromModel);
            }
        } catch (Throwable unused2) {
        }
        this.b.unlock();
    }

    public final void a(ContentValues contentValues) {
        synchronized (this.e) {
            this.f.add(contentValues);
        }
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    public final int a(SQLiteDatabase sQLiteDatabase) {
        try {
            return this.k.a(sQLiteDatabase, String.format("id IN (SELECT id FROM events ORDER BY CASE WHEN type IN (%1$s) THEN 2 WHEN type IN (%2$s) THEN 1 ELSE 0 END, id LIMIT (SELECT count() FROM events) / %3$s)", TextUtils.join(", ", AbstractC2776p9.i), TextUtils.join(", ", AbstractC2776p9.j), 10), 2, this.h.b.b, true).b;
        } catch (Throwable th) {
            C2523ej c2523ej = Ei.a;
            c2523ej.getClass();
            c2523ej.a(new C2498dj("deleteExcessiveReports exception", th));
            return 0;
        }
    }

    public final void a(long j, int i, int i2, boolean z) {
        if (i2 <= 0) {
            return;
        }
        this.b.lock();
        try {
            String str = String.format(Locale.US, "%1$s = %2$s AND %3$s = %4$s AND %5$s <= (SELECT %5$s FROM %6$s WHERE %1$s = %2$s AND %3$s = %4$s ORDER BY %5$s ASC LIMIT %7$s, 1)", "session_id", Long.toString(j), "session_type", Integer.toString(i), "id", "events", Integer.toString(i2 - 1));
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            if (writableDatabase != null) {
                C6 c6A = this.k.a(writableDatabase, str, 1, this.h.b.b, z);
                if (c6A.a != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = c6A.a.iterator();
                    while (it.hasNext()) {
                        Integer asInteger = ((ContentValues) it.next()).getAsInteger("type");
                        asInteger.intValue();
                        arrayList.add(asInteger);
                    }
                    Iterator it2 = this.j.iterator();
                    while (it2.hasNext()) {
                        ((L8) it2.next()).b(arrayList);
                    }
                }
                List list = c6A.a;
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        a((ContentValues) list.get(i3), "Event removed from db");
                    }
                }
                this.i.addAndGet(-c6A.b);
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
    }

    public final ContentValues a(long j, Wj wj) {
        ContentValues contentValues = new ContentValues();
        this.a.lock();
        Cursor cursorRawQuery = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursorRawQuery = readableDatabase.rawQuery(String.format(Locale.US, "SELECT report_request_parameters FROM sessions WHERE id = %s AND type = %s ORDER BY id DESC LIMIT 1", Long.valueOf(j), Integer.valueOf(wj.a)), null);
                if (cursorRawQuery.moveToNext()) {
                    ContentValues contentValues2 = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursorRawQuery, contentValues2);
                    contentValues = contentValues2;
                }
            }
        } catch (Throwable unused) {
        }
        hn.a(cursorRawQuery);
        this.a.unlock();
        return contentValues;
    }

    public static String a(LinkedHashMap linkedHashMap) {
        StringBuilder sb = new StringBuilder("id >= ?");
        for (String str : linkedHashMap.keySet()) {
            sb.append(sb.length() > 0 ? " AND " : "");
            sb.append(str + " = ? ");
        }
        if (TextUtils.isEmpty(sb.toString())) {
            return null;
        }
        return sb.toString();
    }

    public static String[] a(String[] strArr, LinkedHashMap linkedHashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(strArr));
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getValue());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final void a(ContentValues contentValues, String str) {
        Integer asInteger = contentValues.getAsInteger("type");
        if (AbstractC2776p9.d.contains(Ta.a(asInteger != null ? asInteger.intValue() : -1))) {
            C2461c7 model = new C2486d7(null, 1, null).toModel(contentValues);
            StringBuilder sb = new StringBuilder(str);
            sb.append(": ");
            sb.append(model.g.b);
            String str2 = model.g.c;
            if (AbstractC2776p9.f.contains(Ta.a(contentValues.getAsInteger("type").intValue())) && !TextUtils.isEmpty(str2)) {
                sb.append(" with value ");
                sb.append(str2);
            }
            this.h.n.info(sb.toString(), new Object[0]);
        }
    }

    public static boolean a(I6 i6) {
        boolean zIsEmpty;
        synchronized (i6.e) {
            zIsEmpty = i6.f.isEmpty();
        }
        return zIsEmpty;
    }
}
