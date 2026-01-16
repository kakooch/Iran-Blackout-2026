package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.networktasks.internal.DefaultNetworkResponseHandler;
import io.appmetrica.analytics.networktasks.internal.FullUrlFormer;
import io.appmetrica.analytics.networktasks.internal.RequestBodyEncrypter;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import io.appmetrica.analytics.networktasks.internal.SendingDataTaskHelper;
import io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Mg implements UnderlyingNetworkTask {
    public final C2484d5 a;
    public final LinkedHashMap b;
    public C2630j7 c;
    public C2513e9 d;
    public final I6 e;
    public List f;
    public int g;
    public int h;
    public int i;
    public Lg j;
    public final C2794q3 k;
    public final PublicLogger l;
    public final tn m;
    public final La n;
    public final C2830rg o;
    public final FullUrlFormer p;
    public final C2778pb q;
    public final RequestDataHolder r;
    public final ResponseDataHolder s;
    public final SendingDataTaskHelper t;
    public int u;

    public Mg(C2484d5 c2484d5, C2830rg c2830rg, C2778pb c2778pb, FullUrlFormer<Cg> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(c2484d5, c2830rg, c2778pb, fullUrlFormer, requestDataHolder, responseDataHolder, c2484d5.h(), c2484d5.o(), c2484d5.u(), requestBodyEncrypter);
    }

    public final C2513e9 a(Lg lg, List list, Cg cg) {
        C2513e9 c2513e9 = new C2513e9();
        W8 w8 = new W8();
        w8.a = WrapUtils.getOrDefaultIfEmpty(this.c.b, cg.getUuid());
        w8.b = WrapUtils.getOrDefaultIfEmpty(this.c.a, cg.getDeviceId());
        this.g = CodedOutputByteBufferNano.computeMessageSize(4, w8) + this.g;
        c2513e9.b = w8;
        C2669km c2669kmZ = C2586ha.C.z();
        Jg jg = new Jg(this, c2513e9);
        synchronized (c2669kmZ) {
            c2669kmZ.a.a(jg);
        }
        List list2 = lg.a;
        c2513e9.a = (C2438b9[]) list2.toArray(new C2438b9[list2.size()]);
        c2513e9.c = a(lg.c);
        c2513e9.e = (String[]) list.toArray(new String[list.size()]);
        this.g = CodedOutputByteBufferNano.computeTagSize(8) + this.g;
        return c2513e9;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.a.b.b);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final FullUrlFormer<?> getFullUrlFormer() {
        return this.p;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final RequestDataHolder getRequestDataHolder() {
        return this.r;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final ResponseDataHolder getResponseDataHolder() {
        return this.s;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final RetryPolicyConfig getRetryPolicyConfig() {
        return ((Cg) this.a.l.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((C3026zk) C2586ha.C.x()).getClass();
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onCreateTask() {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Mg.onCreateTask():boolean");
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onPerformRequest() {
        this.t.onPerformRequest();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onPostRequestComplete(boolean z) {
        String strA;
        if (z) {
            a(false);
        } else if (this.s.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (int i = 0; i < this.j.a.size(); i++) {
                for (Z8 z8 : ((C2438b9) this.j.a.get(i)).c) {
                    if (z8 != null && (strA = AbstractC2469cf.a(z8)) != null) {
                        this.l.info(strA, new Object[0]);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final boolean onRequestComplete() {
        return this.t.isResponseValid();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onRequestError(Throwable th) {
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onShouldNotExecute() {
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
        this.a.q.b();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        this.a.q.c.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
        SQLiteDatabase writableDatabase;
        I6 i6 = this.a.f;
        i6.getClass();
        try {
            i6.b.lock();
            if (i6.i.get() > ((Cg) i6.h.l.a()).w && (writableDatabase = i6.c.getWritableDatabase()) != null) {
                int iA = i6.a(writableDatabase);
                i6.i.addAndGet(-iA);
                if (iA != 0) {
                    Iterator it = i6.j.iterator();
                    while (it.hasNext()) {
                        ((L8) it.next()).a();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        i6.b.unlock();
        this.a.q.c.set(true);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        this.a.q.c.set(true);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }

    public Mg(C2484d5 c2484d5, C2830rg c2830rg, C2778pb c2778pb, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, I6 i6, PublicLogger publicLogger, tn tnVar, RequestBodyEncrypter requestBodyEncrypter) {
        this(c2484d5, publicLogger, i6, c2830rg, tnVar, c2778pb, new C2794q3(1024000, "event value in ReportTask", publicLogger), AbstractC2648k1.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    public Mg(C2484d5 c2484d5, PublicLogger publicLogger, I6 i6, C2830rg c2830rg, tn tnVar, C2778pb c2778pb, C2794q3 c2794q3, C2523ej c2523ej, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.t = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.o = c2830rg;
        this.a = c2484d5;
        this.e = i6;
        this.l = publicLogger;
        this.k = c2794q3;
        this.m = tnVar;
        this.q = c2778pb;
        this.n = c2523ej;
        this.r = requestDataHolder;
        this.s = responseDataHolder;
        this.p = fullUrlFormer;
    }

    public static T8[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length <= 0) {
            return null;
        }
        T8[] t8Arr = new T8[length];
        Iterator<String> itKeys = jSONObject.keys();
        int i = 0;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                T8 t8 = new T8();
                t8.a = next;
                t8.b = jSONObject.getString(next);
                t8Arr[i] = t8;
            } catch (Throwable unused) {
            }
            i++;
        }
        return t8Arr;
    }

    public final void a(boolean z) {
        tn tnVar = this.m;
        int i = this.u;
        synchronized (tnVar) {
            un unVar = tnVar.a;
            unVar.a(unVar.a().put("report_request_id", i));
        }
        C2438b9[] c2438b9Arr = this.d.a;
        for (int i2 = 0; i2 < c2438b9Arr.length; i2++) {
            try {
                C2438b9 c2438b9 = c2438b9Arr[i2];
                long jLongValue = ((Long) this.f.get(i2)).longValue();
                Wj wj = (Wj) AbstractC2444bf.b.get(c2438b9.b.c);
                if (wj == null) {
                    wj = Wj.FOREGROUND;
                }
                this.e.a(jLongValue, wj.a, c2438b9.c.length, z);
                AbstractC2444bf.a(c2438b9);
            } catch (Throwable unused) {
            }
        }
        I6 i6 = this.e;
        long jA = this.a.k.a();
        i6.b.lock();
        try {
            if (AbstractC3011z5.a.booleanValue()) {
                i6.c();
            }
            SQLiteDatabase writableDatabase = i6.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("sessions", AbstractC2963x5.c, new String[]{String.valueOf(jA)});
            }
        } catch (Throwable unused2) {
        }
        i6.b.unlock();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ea A[LOOP:1: B:44:0x00e4->B:46:0x00ea, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.appmetrica.analytics.impl.Lg a(io.appmetrica.analytics.impl.Cg r17) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Mg.a(io.appmetrica.analytics.impl.Cg):io.appmetrica.analytics.impl.Lg");
    }

    public static C2404a0 a(ContentValues contentValues) {
        C2461c7 model = new C2486d7(null, 1, null).toModel(contentValues);
        return new C2404a0((String) WrapUtils.getOrDefault(model.g.g, ""), ((Long) WrapUtils.getOrDefault(model.g.h, 0L)).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c A[Catch: all -> 0x009b, TryCatch #4 {all -> 0x009b, blocks: (B:7:0x0026, B:8:0x002c, B:10:0x0033, B:12:0x0039, B:27:0x006c, B:29:0x0072, B:38:0x0093, B:45:0x00a7, B:47:0x00b6, B:54:0x00c2, B:53:0x00c1, B:50:0x00bc, B:55:0x00c8, B:58:0x00da, B:61:0x00e1, B:42:0x00a0, B:65:0x00f4, B:67:0x00fa, B:64:0x00ea, B:25:0x0066), top: B:88:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ea A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.appmetrica.analytics.impl.Kg a(long r17, io.appmetrica.analytics.impl.C2413a9 r19, io.appmetrica.analytics.impl.Cg r20, java.util.ArrayList r21, int r22) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Mg.a(long, io.appmetrica.analytics.impl.a9, io.appmetrica.analytics.impl.Cg, java.util.ArrayList, int):io.appmetrica.analytics.impl.Kg");
    }

    public final Cursor a() {
        SQLiteDatabase readableDatabase;
        I6 i6 = this.e;
        LinkedHashMap linkedHashMap = this.b;
        i6.a.lock();
        try {
            readableDatabase = i6.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        Cursor cursorQuery = readableDatabase != null ? readableDatabase.query("sessions", null, I6.a(linkedHashMap), I6.a(new String[]{Long.toString(0L)}, linkedHashMap), null, null, "id ASC", null) : null;
        i6.a.unlock();
        return cursorQuery;
    }

    public final Cursor a(long j, Wj wj) {
        SQLiteDatabase readableDatabase;
        I6 i6 = this.e;
        i6.a.lock();
        try {
            readableDatabase = i6.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        Cursor cursorQuery = readableDatabase != null ? readableDatabase.query("events", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(wj.a)}, null, null, "number_in_session ASC", null) : null;
        i6.a.unlock();
        return cursorQuery;
    }
}
