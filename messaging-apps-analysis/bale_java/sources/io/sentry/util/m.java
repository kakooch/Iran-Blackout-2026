package io.sentry.util;

import io.sentry.I;
import io.sentry.ILogger;

/* loaded from: classes3.dex */
public abstract class m {

    public interface a {
        void accept(Object obj);
    }

    public interface b {
        void a(Object obj, Class cls);
    }

    public interface c {
        void accept(Object obj);
    }

    public static I e(Object obj) {
        I i = new I();
        t(i, obj);
        return i;
    }

    public static io.sentry.hints.h f(I i) {
        return (io.sentry.hints.h) i.d("sentry:eventDropReason", io.sentry.hints.h.class);
    }

    public static Object g(I i) {
        return i.c("sentry:typeCheckHint");
    }

    public static boolean h(I i, Class cls) {
        return cls.isInstance(g(i));
    }

    public static boolean i(I i) {
        return Boolean.TRUE.equals(i.d("sentry:isFromHybridSdk", Boolean.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(Object obj, Class cls) {
    }

    public static void n(I i, Class cls, final c cVar) {
        p(i, cls, new a() { // from class: io.sentry.util.k
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                m.j(obj);
            }
        }, new b() { // from class: io.sentry.util.l
            @Override // io.sentry.util.m.b
            public final void a(Object obj, Class cls2) {
                cVar.accept(obj);
            }
        });
    }

    public static void o(I i, Class cls, a aVar) {
        p(i, cls, aVar, new b() { // from class: io.sentry.util.i
            @Override // io.sentry.util.m.b
            public final void a(Object obj, Class cls2) {
                m.l(obj, cls2);
            }
        });
    }

    public static void p(I i, Class cls, a aVar, b bVar) {
        Object objG = g(i);
        if (!h(i, cls) || objG == null) {
            bVar.a(objG, cls);
        } else {
            aVar.accept(objG);
        }
    }

    public static void q(I i, Class cls, final ILogger iLogger, a aVar) {
        p(i, cls, aVar, new b() { // from class: io.sentry.util.j
            @Override // io.sentry.util.m.b
            public final void a(Object obj, Class cls2) {
                s.a(cls2, obj, iLogger);
            }
        });
    }

    public static void r(I i, io.sentry.hints.h hVar) {
        i.k("sentry:eventDropReason", hVar);
    }

    public static void s(I i, String str) {
        if (str.startsWith("sentry.javascript") || str.startsWith("sentry.dart") || str.startsWith("sentry.dotnet")) {
            i.k("sentry:isFromHybridSdk", Boolean.TRUE);
        }
    }

    public static void t(I i, Object obj) {
        i.k("sentry:typeCheckHint", obj);
    }

    public static boolean u(I i) {
        return !(h(i, io.sentry.hints.e.class) || h(i, io.sentry.hints.c.class)) || h(i, io.sentry.hints.b.class);
    }
}
