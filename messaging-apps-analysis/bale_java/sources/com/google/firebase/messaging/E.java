package com.google.firebase.messaging;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import ir.nasim.AbstractC9078Yj7;
import ir.nasim.C4982Hj7;
import ir.nasim.KJ;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
class E {
    private static final long i = TimeUnit.HOURS.toSeconds(8);
    private final Context a;
    private final o b;
    private final C2376m c;
    private final FirebaseMessaging d;
    private final ScheduledExecutorService f;
    private final C h;
    private final Map e = new KJ();
    private boolean g = false;

    private E(FirebaseMessaging firebaseMessaging, o oVar, C c, C2376m c2376m, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.d = firebaseMessaging;
        this.b = oVar;
        this.h = c;
        this.c = c2376m;
        this.a = context;
        this.f = scheduledExecutorService;
    }

    private static void b(Task task) throws IOException {
        try {
            AbstractC9078Yj7.b(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e2);
            }
            throw ((RuntimeException) cause);
        } catch (TimeoutException e3) {
            e = e3;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    private void c(String str) throws IOException {
        b(this.c.l(this.d.j(), str));
    }

    private void d(String str) throws IOException {
        b(this.c.m(this.d.j(), str));
    }

    static Task e(final FirebaseMessaging firebaseMessaging, final o oVar, final C2376m c2376m, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return AbstractC9078Yj7.c(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.D
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return E.i(context, scheduledExecutorService, firebaseMessaging, oVar, c2376m);
            }
        });
    }

    static boolean g() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ E i(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, o oVar, C2376m c2376m) {
        return new E(firebaseMessaging, oVar, C.a(context, scheduledExecutorService), c2376m, context, scheduledExecutorService);
    }

    private void j(B b) {
        synchronized (this.e) {
            try {
                String strE = b.e();
                if (this.e.containsKey(strE)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.e.get(strE);
                    C4982Hj7 c4982Hj7 = (C4982Hj7) arrayDeque.poll();
                    if (c4982Hj7 != null) {
                        c4982Hj7.c(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.e.remove(strE);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void n() {
        if (h()) {
            return;
        }
        q(0L);
    }

    boolean f() {
        return this.h.b() != null;
    }

    synchronized boolean h() {
        return this.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean k(com.google.firebase.messaging.B r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "FirebaseMessaging"
            r1 = 0
            java.lang.String r2 = r7.b()     // Catch: java.io.IOException -> L1f
            int r3 = r2.hashCode()     // Catch: java.io.IOException -> L1f
            r4 = 83
            r5 = 1
            if (r3 == r4) goto L22
            r4 = 85
            if (r3 == r4) goto L15
            goto L2c
        L15:
            java.lang.String r3 = "U"
            boolean r2 = r2.equals(r3)     // Catch: java.io.IOException -> L1f
            if (r2 == 0) goto L2c
            r2 = r5
            goto L2d
        L1f:
            r7 = move-exception
            goto La5
        L22:
            java.lang.String r3 = "S"
            boolean r2 = r2.equals(r3)     // Catch: java.io.IOException -> L1f
            if (r2 == 0) goto L2c
            r2 = r1
            goto L2d
        L2c:
            r2 = -1
        L2d:
            java.lang.String r3 = " succeeded."
            if (r2 == 0) goto L7c
            if (r2 == r5) goto L53
            boolean r2 = g()     // Catch: java.io.IOException -> L1f
            if (r2 == 0) goto La4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L1f
            r2.<init>()     // Catch: java.io.IOException -> L1f
            java.lang.String r3 = "Unknown topic operation"
            r2.append(r3)     // Catch: java.io.IOException -> L1f
            r2.append(r7)     // Catch: java.io.IOException -> L1f
            java.lang.String r7 = "."
            r2.append(r7)     // Catch: java.io.IOException -> L1f
            java.lang.String r7 = r2.toString()     // Catch: java.io.IOException -> L1f
            android.util.Log.d(r0, r7)     // Catch: java.io.IOException -> L1f
            goto La4
        L53:
            java.lang.String r2 = r7.c()     // Catch: java.io.IOException -> L1f
            r6.d(r2)     // Catch: java.io.IOException -> L1f
            boolean r2 = g()     // Catch: java.io.IOException -> L1f
            if (r2 == 0) goto La4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L1f
            r2.<init>()     // Catch: java.io.IOException -> L1f
            java.lang.String r4 = "Unsubscribe from topic: "
            r2.append(r4)     // Catch: java.io.IOException -> L1f
            java.lang.String r7 = r7.c()     // Catch: java.io.IOException -> L1f
            r2.append(r7)     // Catch: java.io.IOException -> L1f
            r2.append(r3)     // Catch: java.io.IOException -> L1f
            java.lang.String r7 = r2.toString()     // Catch: java.io.IOException -> L1f
            android.util.Log.d(r0, r7)     // Catch: java.io.IOException -> L1f
            goto La4
        L7c:
            java.lang.String r2 = r7.c()     // Catch: java.io.IOException -> L1f
            r6.c(r2)     // Catch: java.io.IOException -> L1f
            boolean r2 = g()     // Catch: java.io.IOException -> L1f
            if (r2 == 0) goto La4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L1f
            r2.<init>()     // Catch: java.io.IOException -> L1f
            java.lang.String r4 = "Subscribe to topic: "
            r2.append(r4)     // Catch: java.io.IOException -> L1f
            java.lang.String r7 = r7.c()     // Catch: java.io.IOException -> L1f
            r2.append(r7)     // Catch: java.io.IOException -> L1f
            r2.append(r3)     // Catch: java.io.IOException -> L1f
            java.lang.String r7 = r2.toString()     // Catch: java.io.IOException -> L1f
            android.util.Log.d(r0, r7)     // Catch: java.io.IOException -> L1f
        La4:
            return r5
        La5:
            java.lang.String r2 = "SERVICE_NOT_AVAILABLE"
            java.lang.String r3 = r7.getMessage()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto Lcb
            java.lang.String r2 = "INTERNAL_SERVER_ERROR"
            java.lang.String r3 = r7.getMessage()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto Lbe
            goto Lcb
        Lbe:
            java.lang.String r2 = r7.getMessage()
            if (r2 != 0) goto Lca
            java.lang.String r7 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r0, r7)
            return r1
        Lca:
            throw r7
        Lcb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Topic operation failed: "
            r2.append(r3)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = ". Will retry Topic operation."
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.E.k(com.google.firebase.messaging.B):boolean");
    }

    void l(Runnable runnable, long j) {
        this.f.schedule(runnable, j, TimeUnit.SECONDS);
    }

    synchronized void m(boolean z) {
        this.g = z;
    }

    void o() {
        if (f()) {
            n();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (g() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean p() {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            com.google.firebase.messaging.C r0 = r2.h     // Catch: java.lang.Throwable -> L17
            com.google.firebase.messaging.B r0 = r0.b()     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L1c
            boolean r0 = g()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L19
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r0 = move-exception
            goto L2e
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            r0 = 1
            return r0
        L1c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            boolean r1 = r2.k(r0)
            if (r1 != 0) goto L25
            r0 = 0
            return r0
        L25:
            com.google.firebase.messaging.C r1 = r2.h
            r1.d(r0)
            r2.j(r0)
            goto L0
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.E.p():boolean");
    }

    void q(long j) {
        l(new F(this, this.a, this.b, Math.min(Math.max(30L, 2 * j), i)), j);
        m(true);
    }
}
