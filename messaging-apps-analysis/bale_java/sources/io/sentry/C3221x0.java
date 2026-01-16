package io.sentry;

import java.net.InetAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* renamed from: io.sentry.x0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3221x0 {
    public final C3231z0 a;

    public C3221x0(int i) {
        this.a = new C3231z0(i);
    }

    private void b(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger, Collection collection) {
        interfaceC3123h1.g();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            a(interfaceC3123h1, iLogger, it.next());
        }
        interfaceC3123h1.e();
    }

    private void c(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger, Date date) {
        try {
            interfaceC3123h1.h(AbstractC3141l.h(date));
        } catch (Exception e) {
            iLogger.b(Y2.ERROR, "Error when serializing Date", e);
            interfaceC3123h1.n();
        }
    }

    private void d(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger, Map map) {
        interfaceC3123h1.B();
        for (Object obj : map.keySet()) {
            if (obj instanceof String) {
                interfaceC3123h1.f((String) obj);
                a(interfaceC3123h1, iLogger, map.get(obj));
            }
        }
        interfaceC3123h1.F();
    }

    private void e(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger, TimeZone timeZone) {
        try {
            interfaceC3123h1.h(timeZone.getID());
        } catch (Exception e) {
            iLogger.b(Y2.ERROR, "Error when serializing TimeZone", e);
            interfaceC3123h1.n();
        }
    }

    public void a(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger, Object obj) {
        if (obj == null) {
            interfaceC3123h1.n();
            return;
        }
        if (obj instanceof Character) {
            interfaceC3123h1.h(Character.toString(((Character) obj).charValue()));
            return;
        }
        if (obj instanceof String) {
            interfaceC3123h1.h((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            interfaceC3123h1.d(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Number) {
            interfaceC3123h1.k((Number) obj);
            return;
        }
        if (obj instanceof Date) {
            c(interfaceC3123h1, iLogger, (Date) obj);
            return;
        }
        if (obj instanceof TimeZone) {
            e(interfaceC3123h1, iLogger, (TimeZone) obj);
            return;
        }
        if (obj instanceof A0) {
            ((A0) obj).serialize(interfaceC3123h1, iLogger);
            return;
        }
        if (obj instanceof Collection) {
            b(interfaceC3123h1, iLogger, (Collection) obj);
            return;
        }
        if (obj.getClass().isArray()) {
            b(interfaceC3123h1, iLogger, Arrays.asList((Object[]) obj));
            return;
        }
        if (obj instanceof Map) {
            d(interfaceC3123h1, iLogger, (Map) obj);
            return;
        }
        if (obj instanceof Locale) {
            interfaceC3123h1.h(obj.toString());
            return;
        }
        if (obj instanceof AtomicIntegerArray) {
            b(interfaceC3123h1, iLogger, io.sentry.util.p.a((AtomicIntegerArray) obj));
            return;
        }
        if (obj instanceof AtomicBoolean) {
            interfaceC3123h1.d(((AtomicBoolean) obj).get());
            return;
        }
        if (obj instanceof URI) {
            interfaceC3123h1.h(obj.toString());
            return;
        }
        if (obj instanceof InetAddress) {
            interfaceC3123h1.h(obj.toString());
            return;
        }
        if (obj instanceof UUID) {
            interfaceC3123h1.h(obj.toString());
            return;
        }
        if (obj instanceof Currency) {
            interfaceC3123h1.h(obj.toString());
            return;
        }
        if (obj instanceof Calendar) {
            d(interfaceC3123h1, iLogger, io.sentry.util.p.c((Calendar) obj));
            return;
        }
        if (obj.getClass().isEnum()) {
            interfaceC3123h1.h(obj.toString());
            return;
        }
        try {
            a(interfaceC3123h1, iLogger, this.a.d(obj, iLogger));
        } catch (Exception e) {
            iLogger.b(Y2.ERROR, "Failed serializing unknown object.", e);
            interfaceC3123h1.h("[OBJECT]");
        }
    }
}
