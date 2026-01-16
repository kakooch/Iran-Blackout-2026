package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class H6 extends InterruptionSafeThread {
    public final C2484d5 a;
    public final /* synthetic */ I6 b;

    public H6(I6 i6, C2484d5 c2484d5) {
        this.b = i6;
        this.a = c2484d5;
    }

    public final synchronized void a(ArrayList arrayList) {
        try {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ContentValues contentValues = (ContentValues) it.next();
                this.b.getClass();
                Integer asInteger = contentValues.getAsInteger("type");
                asInteger.intValue();
                arrayList2.add(asInteger);
            }
            Iterator it2 = this.b.j.iterator();
            while (it2.hasNext()) {
                ((L8) it2.next()).a(arrayList2);
            }
            this.a.q.b();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        while (isRunning()) {
            try {
                synchronized (this) {
                    try {
                        if (I6.a(this.b)) {
                            wait();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable unused) {
                stopRunning();
            }
            synchronized (this.b.e) {
                arrayList = new ArrayList(this.b.f);
                this.b.f.clear();
            }
            I6 i6 = this.b;
            i6.getClass();
            if (!arrayList.isEmpty()) {
                i6.b.lock();
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase writableDatabase = i6.c.getWritableDatabase();
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.beginTransaction();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ContentValues contentValues = (ContentValues) it.next();
                                writableDatabase.insertOrThrow("events", null, contentValues);
                                i6.i.incrementAndGet();
                                i6.a(contentValues, "Event saved to db");
                            }
                            writableDatabase.setTransactionSuccessful();
                            i6.i.get();
                        } catch (Throwable unused2) {
                            sQLiteDatabase = writableDatabase;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            i6.b.unlock();
                            a(arrayList);
                        }
                    }
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Throwable unused3) {
                        }
                    }
                } catch (Throwable unused4) {
                }
                i6.b.unlock();
            }
            a(arrayList);
        }
    }
}
