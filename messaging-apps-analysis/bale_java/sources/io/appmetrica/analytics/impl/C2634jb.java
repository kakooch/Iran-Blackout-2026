package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: io.appmetrica.analytics.impl.jb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2634jb implements Ba, Closeable {
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final String c = "preferences";
    public final C2611ib d;
    public volatile boolean e;
    public final InterfaceC2916v6 f;

    public C2634jb(InterfaceC2916v6 interfaceC2916v6) {
        this.f = interfaceC2916v6;
        C2611ib c2611ib = new C2611ib(this, String.format(Locale.US, "IAA-DW-%s", Integer.valueOf(Zc.a())));
        this.d = c2611ib;
        c2611ib.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(io.appmetrica.analytics.impl.C2634jb r13) {
        /*
            java.lang.String r0 = "type"
            java.lang.String r1 = "value"
            java.lang.String r2 = "key"
            r13.getClass()
            r3 = 0
            io.appmetrica.analytics.impl.v6 r4 = r13.f     // Catch: java.lang.Throwable -> L85
            android.database.sqlite.SQLiteDatabase r4 = r4.a()     // Catch: java.lang.Throwable -> L85
            if (r4 == 0) goto L86
            java.lang.String r6 = r13.c     // Catch: java.lang.Throwable -> L86
            java.lang.String[] r7 = new java.lang.String[]{r2, r1, r0}     // Catch: java.lang.Throwable -> L86
            r11 = 0
            r12 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r5 = r4
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L86
        L22:
            boolean r6 = r5.moveToNext()     // Catch: java.lang.Throwable -> L83
            if (r6 == 0) goto L83
            int r6 = r5.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r6 = r5.getString(r6)     // Catch: java.lang.Throwable -> L83
            int r7 = r5.getColumnIndexOrThrow(r1)     // Catch: java.lang.Throwable -> L83
            java.lang.String r7 = r5.getString(r7)     // Catch: java.lang.Throwable -> L83
            int r8 = r5.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L83
            int r8 = r5.getInt(r8)     // Catch: java.lang.Throwable -> L83
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L83
            if (r9 != 0) goto L22
            r9 = 1
            if (r8 == r9) goto L66
            r9 = 2
            if (r8 == r9) goto L61
            r9 = 3
            if (r8 == r9) goto L5c
            r9 = 4
            if (r8 == r9) goto L7b
            r9 = 5
            if (r8 == r9) goto L57
        L55:
            r7 = r3
            goto L7b
        L57:
            java.lang.Float r7 = io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils.parseFloat(r7)     // Catch: java.lang.Throwable -> L83
            goto L7b
        L5c:
            java.lang.Long r7 = io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils.parseLong(r7)     // Catch: java.lang.Throwable -> L83
            goto L7b
        L61:
            java.lang.Integer r7 = io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils.parseInt(r7)     // Catch: java.lang.Throwable -> L83
            goto L7b
        L66:
            java.lang.String r8 = "true"
            boolean r8 = r8.equals(r7)     // Catch: java.lang.Throwable -> L83
            if (r8 == 0) goto L71
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L83
            goto L7b
        L71:
            java.lang.String r8 = "false"
            boolean r7 = r8.equals(r7)     // Catch: java.lang.Throwable -> L83
            if (r7 == 0) goto L55
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L83
        L7b:
            if (r7 == 0) goto L22
            java.util.HashMap r8 = r13.a     // Catch: java.lang.Throwable -> L83
            r8.put(r6, r7)     // Catch: java.lang.Throwable -> L83
            goto L22
        L83:
            r3 = r5
            goto L86
        L85:
            r4 = r3
        L86:
            io.appmetrica.analytics.impl.hn.a(r3)
            io.appmetrica.analytics.impl.v6 r13 = r13.f
            r13.a(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2634jb.a(io.appmetrica.analytics.impl.jb):void");
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final void b() {
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    public final void c() throws InterruptedException {
        if (this.e) {
            return;
        }
        try {
            this.a.wait();
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.d.isRunning()) {
            this.d.stopRunning();
        }
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final boolean getBoolean(String str, boolean z) {
        Object objB = b(str);
        return objB instanceof Boolean ? ((Boolean) objB).booleanValue() : z;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final int getInt(String str, int i) {
        Object objB = b(str);
        return objB instanceof Integer ? ((Integer) objB).intValue() : i;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final long getLong(String str, long j) {
        Object objB = b(str);
        return objB instanceof Long ? ((Long) objB).longValue() : j;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final String getString(String str, String str2) {
        Object objB = b(str);
        return objB instanceof String ? (String) objB : str2;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final Ba remove(String str) {
        synchronized (this.a) {
            c();
            this.a.remove(str);
        }
        synchronized (this.d) {
            this.b.put(str, this);
            this.d.notifyAll();
        }
        return this;
    }

    public final Object b(String str) {
        Object obj;
        synchronized (this.a) {
            c();
            obj = this.a.get(str);
        }
        return obj;
    }

    public static void a(C2634jb c2634jb, HashMap map) {
        SQLiteDatabase sQLiteDatabaseA;
        c2634jb.getClass();
        int size = map.size();
        ContentValues[] contentValuesArr = new ContentValues[size];
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            ContentValues contentValues = new ContentValues();
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            contentValues.put("key", str);
            if (value == c2634jb) {
                contentValues.putNull("value");
            } else if (value instanceof String) {
                contentValues.put("value", (String) value);
                contentValues.put("type", (Integer) 4);
            } else if (value instanceof Long) {
                contentValues.put("value", (Long) value);
                contentValues.put("type", (Integer) 3);
            } else if (value instanceof Integer) {
                contentValues.put("value", (Integer) value);
                contentValues.put("type", (Integer) 2);
            } else if (value instanceof Boolean) {
                contentValues.put("value", String.valueOf(((Boolean) value).booleanValue()));
                contentValues.put("type", (Integer) 1);
            } else if (value instanceof Float) {
                contentValues.put("value", (Float) value);
                contentValues.put("type", (Integer) 5);
            }
            contentValuesArr[i] = contentValues;
            i++;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseA = c2634jb.f.a();
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.beginTransaction();
                    for (int i2 = 0; i2 < size; i2++) {
                        ContentValues contentValues2 = contentValuesArr[i2];
                        if (contentValues2.getAsString("value") == null) {
                            sQLiteDatabaseA.delete(c2634jb.c, "key = ?", new String[]{contentValues2.getAsString("key")});
                        } else {
                            sQLiteDatabaseA.insertWithOnConflict(c2634jb.c, null, contentValues2, 5);
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (Throwable unused) {
                    sQLiteDatabase = sQLiteDatabaseA;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused2) {
                        }
                    }
                    sQLiteDatabaseA = sQLiteDatabase;
                    c2634jb.f.a(sQLiteDatabaseA);
                }
            }
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
        c2634jb.f.a(sQLiteDatabaseA);
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final synchronized Ba a(String str, String str2) {
        a(str, (Object) str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final Ba a(String str, long j) {
        a(str, Long.valueOf(j));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final synchronized Ba a(int i, String str) {
        a(str, Integer.valueOf(i));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final Ba a(String str, boolean z) {
        a(str, Boolean.valueOf(z));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final Ba a(String str, float f) {
        a(str, Float.valueOf(f));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final boolean a(String str) {
        boolean zContainsKey;
        synchronized (this.a) {
            c();
            zContainsKey = this.a.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // io.appmetrica.analytics.impl.Ba
    public final Set a() {
        HashSet hashSet;
        synchronized (this.a) {
            hashSet = new HashSet(this.a.keySet());
        }
        return hashSet;
    }

    public final void a(String str, Object obj) {
        synchronized (this.a) {
            c();
            this.a.put(str, obj);
        }
        synchronized (this.d) {
            this.b.put(str, obj);
            this.d.notifyAll();
        }
    }
}
