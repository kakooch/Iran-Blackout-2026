package io.sentry.cache;

import io.sentry.C3155n3;
import io.sentry.InterfaceC3176q0;
import io.sentry.T;
import java.util.Map;

/* loaded from: classes3.dex */
public final class h implements T {
    private final C3155n3 a;

    public h(C3155n3 c3155n3) {
        this.a = c3155n3;
    }

    private void h(String str) {
        d.a(this.a, ".options-cache", str);
    }

    public static Object i(C3155n3 c3155n3, String str, Class cls) {
        return j(c3155n3, str, cls, null);
    }

    public static Object j(C3155n3 c3155n3, String str, Class cls, InterfaceC3176q0 interfaceC3176q0) {
        return d.c(c3155n3, ".options-cache", str, cls, interfaceC3176q0);
    }

    private void k(Object obj, String str) {
        d.d(this.a, obj, ".options-cache", str);
    }

    @Override // io.sentry.T
    public void a(Map map) {
        k(map, "tags.json");
    }

    @Override // io.sentry.T
    public void b(String str) {
        if (str == null) {
            h("dist.json");
        } else {
            k(str, "dist.json");
        }
    }

    @Override // io.sentry.T
    public void c(Double d) {
        if (d == null) {
            h("replay-error-sample-rate.json");
        } else {
            k(d.toString(), "replay-error-sample-rate.json");
        }
    }

    @Override // io.sentry.T
    public void d(String str) {
        if (str == null) {
            h("environment.json");
        } else {
            k(str, "environment.json");
        }
    }

    @Override // io.sentry.T
    public void e(String str) {
        if (str == null) {
            h("proguard-uuid.json");
        } else {
            k(str, "proguard-uuid.json");
        }
    }

    @Override // io.sentry.T
    public void f(io.sentry.protocol.p pVar) {
        if (pVar == null) {
            h("sdk-version.json");
        } else {
            k(pVar, "sdk-version.json");
        }
    }

    @Override // io.sentry.T
    public void g(String str) {
        if (str == null) {
            h("release.json");
        } else {
            k(str, "release.json");
        }
    }
}
