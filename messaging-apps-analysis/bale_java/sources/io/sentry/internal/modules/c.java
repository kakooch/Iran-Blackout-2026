package io.sentry.internal.modules;

import io.sentry.ILogger;
import io.sentry.Y2;
import io.sentry.util.AbstractC3203b;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class c extends d {
    private final Pattern e;
    private final Pattern f;
    private final ClassLoader g;

    private static final class a {
        private final String a;
        private final String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    public c(ILogger iLogger) {
        this(c.class.getClassLoader(), iLogger);
    }

    private a d(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = this.f.matcher(str);
        if (matcher.matches() && matcher.groupCount() == 2) {
            return new a(matcher.group(1), matcher.group(2));
        }
        return null;
    }

    private List e() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<URL> resources = this.g.getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                a aVarD = d(f(resources.nextElement()));
                if (aVarD != null) {
                    arrayList.add(aVarD);
                }
            }
        } catch (Throwable th) {
            this.a.b(Y2.ERROR, "Unable to detect modules via manifest files.", th);
        }
        return arrayList;
    }

    private String f(URL url) {
        Matcher matcher = this.e.matcher(url.toString());
        if (matcher.matches() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        return null;
    }

    @Override // io.sentry.internal.modules.d
    protected Map b() {
        HashMap map = new HashMap();
        for (a aVar : e()) {
            map.put(aVar.a, aVar.b);
        }
        return map;
    }

    c(ClassLoader classLoader, ILogger iLogger) {
        super(iLogger);
        this.e = Pattern.compile(".*/(.+)!/META-INF/MANIFEST.MF");
        this.f = Pattern.compile("(.*?)-(\\d+\\.\\d+.*).jar");
        this.g = AbstractC3203b.a(classLoader);
    }
}
