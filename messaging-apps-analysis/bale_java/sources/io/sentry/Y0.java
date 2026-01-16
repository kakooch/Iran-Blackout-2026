package io.sentry;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

/* loaded from: classes3.dex */
final class Y0 implements InterfaceC3107e0 {
    private static final Y0 a = new Y0();

    private Y0() {
    }

    public static Y0 g() {
        return a;
    }

    @Override // io.sentry.InterfaceC3107e0
    public void a(Object obj, Writer writer) {
    }

    @Override // io.sentry.InterfaceC3107e0
    public void b(C3134j2 c3134j2, OutputStream outputStream) {
    }

    @Override // io.sentry.InterfaceC3107e0
    public Object c(Reader reader, Class cls) {
        return null;
    }

    @Override // io.sentry.InterfaceC3107e0
    public C3134j2 d(InputStream inputStream) {
        return null;
    }

    @Override // io.sentry.InterfaceC3107e0
    public Object e(Reader reader, Class cls, InterfaceC3176q0 interfaceC3176q0) {
        return null;
    }

    @Override // io.sentry.InterfaceC3107e0
    public String f(Map map) {
        return "";
    }
}
