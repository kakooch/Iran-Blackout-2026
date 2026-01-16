package io.sentry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: io.sentry.s3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3188s3 {
    private final C3183r3 a;
    private final C3155n3 b;

    public C3188s3(C3183r3 c3183r3, C3155n3 c3155n3) {
        this.a = (C3183r3) io.sentry.util.u.c(c3183r3, "The SentryStackTraceFactory is required.");
        this.b = (C3155n3) io.sentry.util.u.c(c3155n3, "The SentryOptions is required");
    }

    private io.sentry.protocol.B d(boolean z, StackTraceElement[] stackTraceElementArr, Thread thread) {
        io.sentry.protocol.B b = new io.sentry.protocol.B();
        b.w(thread.getName());
        b.x(Integer.valueOf(thread.getPriority()));
        b.u(Long.valueOf(thread.getId()));
        b.s(Boolean.valueOf(thread.isDaemon()));
        b.z(thread.getState().name());
        b.q(Boolean.valueOf(z));
        List listA = this.a.a(stackTraceElementArr, false);
        if (this.b.isAttachStacktrace() && listA != null && !listA.isEmpty()) {
            io.sentry.protocol.A a = new io.sentry.protocol.A(listA);
            a.e(Boolean.TRUE);
            b.y(a);
        }
        return b;
    }

    List a() {
        HashMap map = new HashMap();
        Thread threadCurrentThread = Thread.currentThread();
        map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        return c(map, null, false);
    }

    List b(List list, boolean z) {
        return c(Thread.getAllStackTraces(), list, z);
    }

    List c(Map map, List list, boolean z) {
        Thread threadCurrentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(threadCurrentThread)) {
            map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        }
        for (Map.Entry entry : map.entrySet()) {
            Thread thread = (Thread) entry.getKey();
            arrayList.add(d((thread == threadCurrentThread && !z) || !(list == null || !list.contains(Long.valueOf(thread.getId())) || z), (StackTraceElement[]) entry.getValue(), (Thread) entry.getKey()));
        }
        return arrayList;
    }
}
