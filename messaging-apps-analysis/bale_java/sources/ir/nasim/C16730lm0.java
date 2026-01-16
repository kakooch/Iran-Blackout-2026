package ir.nasim;

import java.io.InputStream;

/* renamed from: ir.nasim.lm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16730lm0 {
    public final InputStream a(String str) {
        AbstractC13042fc3.i(str, "path");
        ClassLoader classLoader = C16730lm0.class.getClassLoader();
        InputStream resourceAsStream = classLoader == null ? null : classLoader.getResourceAsStream(str);
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream(str) : resourceAsStream;
    }
}
