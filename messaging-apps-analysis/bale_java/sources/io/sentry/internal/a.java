package io.sentry.internal;

import io.sentry.InterfaceC3102d0;
import io.sentry.W2;
import io.sentry.util.C3202a;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/* loaded from: classes3.dex */
public final class a {
    private static volatile a d;
    private static final C3202a e = new C3202a();
    private volatile boolean a = false;
    private final C0247a b = new C0247a();
    private C3202a c = new C3202a();

    /* renamed from: io.sentry.internal.a$a, reason: collision with other inner class name */
    public static final class C0247a {
        private volatile String a;
        private volatile String b;
    }

    private a() {
    }

    public static a a() {
        if (d == null) {
            InterfaceC3102d0 interfaceC3102d0A = e.a();
            try {
                if (d == null) {
                    d = new a();
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } catch (Throwable th) {
                if (interfaceC3102d0A != null) {
                    try {
                        interfaceC3102d0A.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return d;
    }

    public void b() {
        InterfaceC3102d0 interfaceC3102d0A;
        if (this.a) {
            return;
        }
        try {
            interfaceC3102d0A = this.c.a();
            try {
            } finally {
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.a = true;
            throw th;
        }
        if (this.a) {
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            this.a = true;
            return;
        }
        Enumeration<URL> resources = ClassLoader.getSystemClassLoader().getResources("META-INF/MANIFEST.MF");
        while (resources.hasMoreElements()) {
            try {
                Attributes mainAttributes = new Manifest(resources.nextElement().openStream()).getMainAttributes();
                if (mainAttributes != null) {
                    String value = mainAttributes.getValue("Sentry-Opentelemetry-SDK-Name");
                    String value2 = mainAttributes.getValue("Implementation-Version");
                    String value3 = mainAttributes.getValue("Sentry-SDK-Name");
                    String value4 = mainAttributes.getValue("Sentry-SDK-Package-Name");
                    if (value != null && value2 != null) {
                        this.b.a = value;
                        this.b.b = value2;
                        String value5 = mainAttributes.getValue("Sentry-Opentelemetry-Version-Name");
                        if (value5 != null) {
                            W2.d().b("maven:io.opentelemetry:opentelemetry-sdk", value5);
                            W2.d().a("OpenTelemetry");
                        }
                        String value6 = mainAttributes.getValue("Sentry-Opentelemetry-Javaagent-Version-Name");
                        if (value6 != null) {
                            W2.d().b("maven:io.opentelemetry.javaagent:opentelemetry-javaagent", value6);
                            W2.d().a("OpenTelemetry-Agent");
                        }
                        if (value.equals("sentry.java.opentelemetry.agentless")) {
                            W2.d().a("OpenTelemetry-Agentless");
                        }
                        if (value.equals("sentry.java.opentelemetry.agentless-spring")) {
                            W2.d().a("OpenTelemetry-Agentless-Spring");
                        }
                    }
                    if (value3 != null && value2 != null && value4 != null && value3.startsWith("sentry.java")) {
                        W2.d().b(value4, value2);
                    }
                }
            } catch (Exception unused2) {
            }
        }
        if (interfaceC3102d0A != null) {
            interfaceC3102d0A.close();
        }
        this.a = true;
    }
}
