package io.sentry.util;

import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3176q0;
import io.sentry.Y2;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public final class t implements InterfaceC3118g1 {
    private final Deque a;

    public t(Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.a = arrayDeque;
        arrayDeque.addLast(new AbstractMap.SimpleEntry(null, map));
    }

    private Object e() throws IOException {
        try {
            return g(null, null);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private Object g(ILogger iLogger, InterfaceC3176q0 interfaceC3176q0) {
        Map.Entry entry = (Map.Entry) this.a.peekLast();
        if (entry == null) {
            return null;
        }
        Object value = entry.getValue();
        if (interfaceC3176q0 != null && iLogger != null) {
            return interfaceC3176q0.a(this, iLogger);
        }
        this.a.removeLast();
        return value;
    }

    @Override // io.sentry.InterfaceC3118g1
    public void B() throws IOException {
        Map.Entry entry = (Map.Entry) this.a.removeLast();
        if (entry == null) {
            throw new IOException("No more entries");
        }
        Object value = entry.getValue();
        if (!(value instanceof Map)) {
            throw new IOException("Current token is not an object");
        }
        this.a.addLast(new AbstractMap.SimpleEntry(null, io.sentry.vendor.gson.stream.b.END_OBJECT));
        Iterator it = ((Map) value).entrySet().iterator();
        while (it.hasNext()) {
            this.a.addLast((Map.Entry) it.next());
        }
    }

    @Override // io.sentry.InterfaceC3118g1
    public void D(boolean z) {
    }

    @Override // io.sentry.InterfaceC3118g1
    public Object E0(ILogger iLogger, InterfaceC3176q0 interfaceC3176q0) {
        return g(iLogger, interfaceC3176q0);
    }

    @Override // io.sentry.InterfaceC3118g1
    public void F() {
        if (this.a.size() > 1) {
            this.a.removeLast();
        }
    }

    @Override // io.sentry.InterfaceC3118g1
    public Object H1() {
        return e();
    }

    @Override // io.sentry.InterfaceC3118g1
    public long K1() throws IOException {
        Object objE = e();
        if (objE instanceof Number) {
            return ((Number) objE).longValue();
        }
        throw new IOException("Expected long");
    }

    @Override // io.sentry.InterfaceC3118g1
    public List Q1(ILogger iLogger, InterfaceC3176q0 interfaceC3176q0) throws IOException {
        if (peek() == io.sentry.vendor.gson.stream.b.NULL) {
            d();
            return null;
        }
        try {
            a();
            ArrayList arrayList = new ArrayList();
            if (c()) {
                do {
                    try {
                        arrayList.add(interfaceC3176q0.a(this, iLogger));
                    } catch (Exception e) {
                        iLogger.b(Y2.WARNING, "Failed to deserialize object in list.", e);
                    }
                } while (peek() == io.sentry.vendor.gson.stream.b.BEGIN_OBJECT);
            }
            b();
            return arrayList;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    @Override // io.sentry.InterfaceC3118g1
    public void R() {
    }

    @Override // io.sentry.InterfaceC3118g1
    public String T0() throws IOException {
        String str = (String) e();
        if (str != null) {
            return str;
        }
        throw new IOException("Expected string");
    }

    @Override // io.sentry.InterfaceC3118g1
    public Integer Y0() throws IOException {
        Object objE = e();
        if (objE instanceof Number) {
            return Integer.valueOf(((Number) objE).intValue());
        }
        return null;
    }

    public void a() throws IOException {
        Map.Entry entry = (Map.Entry) this.a.removeLast();
        if (entry == null) {
            throw new IOException("No more entries");
        }
        Object value = entry.getValue();
        if (!(value instanceof List)) {
            throw new IOException("Current token is not an object");
        }
        this.a.addLast(new AbstractMap.SimpleEntry(null, io.sentry.vendor.gson.stream.b.END_ARRAY));
        List list = (List) value;
        for (int size = list.size() - 1; size >= 0; size--) {
            this.a.addLast(new AbstractMap.SimpleEntry(null, list.get(size)));
        }
    }

    @Override // io.sentry.InterfaceC3118g1
    public TimeZone a0(ILogger iLogger) {
        String strG1 = g1();
        if (strG1 != null) {
            return TimeZone.getTimeZone(strG1);
        }
        return null;
    }

    @Override // io.sentry.InterfaceC3118g1
    public Long a1() throws IOException {
        Object objE = e();
        if (objE instanceof Number) {
            return Long.valueOf(((Number) objE).longValue());
        }
        return null;
    }

    public void b() {
        if (this.a.size() > 1) {
            this.a.removeLast();
        }
    }

    public boolean c() {
        return !this.a.isEmpty();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.clear();
    }

    public void d() throws IOException {
        if (e() == null) {
            return;
        }
        throw new IOException("Expected null but was " + peek());
    }

    @Override // io.sentry.InterfaceC3118g1
    public float e1() throws IOException {
        Object objE = e();
        if (objE instanceof Number) {
            return ((Number) objE).floatValue();
        }
        throw new IOException("Expected float");
    }

    @Override // io.sentry.InterfaceC3118g1
    public double f1() throws IOException {
        Object objE = e();
        if (objE instanceof Number) {
            return ((Number) objE).doubleValue();
        }
        throw new IOException("Expected double");
    }

    @Override // io.sentry.InterfaceC3118g1
    public String g1() {
        return (String) e();
    }

    @Override // io.sentry.InterfaceC3118g1
    public Map i1(ILogger iLogger, InterfaceC3176q0 interfaceC3176q0) throws IOException {
        if (peek() == io.sentry.vendor.gson.stream.b.NULL) {
            d();
            return null;
        }
        try {
            B();
            HashMap map = new HashMap();
            if (c()) {
                while (true) {
                    try {
                        map.put(n0(), interfaceC3176q0.a(this, iLogger));
                    } catch (Exception e) {
                        iLogger.b(Y2.WARNING, "Failed to deserialize object in map.", e);
                    }
                    if (peek() != io.sentry.vendor.gson.stream.b.BEGIN_OBJECT && peek() != io.sentry.vendor.gson.stream.b.NAME) {
                        break;
                    }
                }
            }
            F();
            return map;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    @Override // io.sentry.InterfaceC3118g1
    public void j1(ILogger iLogger, Map map, String str) {
        try {
            map.put(str, H1());
        } catch (Exception e) {
            iLogger.a(Y2.ERROR, e, "Error deserializing unknown key: %s", str);
        }
    }

    @Override // io.sentry.InterfaceC3118g1
    public Double l0() throws IOException {
        Object objE = e();
        if (objE instanceof Number) {
            return Double.valueOf(((Number) objE).doubleValue());
        }
        return null;
    }

    @Override // io.sentry.InterfaceC3118g1
    public String n0() throws IOException {
        Map.Entry entry = (Map.Entry) this.a.peekLast();
        if (entry != null && entry.getKey() != null) {
            return (String) entry.getKey();
        }
        throw new IOException("Expected a name but was " + peek());
    }

    @Override // io.sentry.InterfaceC3118g1
    public io.sentry.vendor.gson.stream.b peek() {
        if (this.a.isEmpty()) {
            return io.sentry.vendor.gson.stream.b.END_DOCUMENT;
        }
        Map.Entry entry = (Map.Entry) this.a.peekLast();
        if (entry == null) {
            return io.sentry.vendor.gson.stream.b.END_DOCUMENT;
        }
        if (entry.getKey() != null) {
            return io.sentry.vendor.gson.stream.b.NAME;
        }
        Object value = entry.getValue();
        return value instanceof Map ? io.sentry.vendor.gson.stream.b.BEGIN_OBJECT : value instanceof List ? io.sentry.vendor.gson.stream.b.BEGIN_ARRAY : value instanceof String ? io.sentry.vendor.gson.stream.b.STRING : value instanceof Number ? io.sentry.vendor.gson.stream.b.NUMBER : value instanceof Boolean ? io.sentry.vendor.gson.stream.b.BOOLEAN : value instanceof io.sentry.vendor.gson.stream.b ? (io.sentry.vendor.gson.stream.b) value : io.sentry.vendor.gson.stream.b.END_DOCUMENT;
    }

    @Override // io.sentry.InterfaceC3118g1
    public Date q0(ILogger iLogger) {
        return InterfaceC3118g1.H0(g1(), iLogger);
    }

    @Override // io.sentry.InterfaceC3118g1
    public int r0() throws IOException {
        Object objE = e();
        if (objE instanceof Number) {
            return ((Number) objE).intValue();
        }
        throw new IOException("Expected int");
    }

    @Override // io.sentry.InterfaceC3118g1
    public Boolean v0() {
        return (Boolean) e();
    }

    @Override // io.sentry.InterfaceC3118g1
    public Float x1() throws IOException {
        Object objE = e();
        if (objE instanceof Number) {
            return Float.valueOf(((Number) objE).floatValue());
        }
        return null;
    }
}
