package io.sentry;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: io.sentry.w0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3216w0 implements InterfaceC3118g1 {
    private final io.sentry.vendor.gson.stream.a a;

    public C3216w0(Reader reader) {
        this.a = new io.sentry.vendor.gson.stream.a(reader);
    }

    @Override // io.sentry.InterfaceC3118g1
    public void B() {
        this.a.B();
    }

    @Override // io.sentry.InterfaceC3118g1
    public void D(boolean z) {
        this.a.D(z);
    }

    @Override // io.sentry.InterfaceC3118g1
    public Object E0(ILogger iLogger, InterfaceC3176q0 interfaceC3176q0) throws IOException {
        if (this.a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return interfaceC3176q0.a(this, iLogger);
        }
        this.a.p();
        return null;
    }

    @Override // io.sentry.InterfaceC3118g1
    public void F() {
        this.a.F();
    }

    @Override // io.sentry.InterfaceC3118g1
    public Object H1() {
        return new C3211v0().e(this);
    }

    @Override // io.sentry.InterfaceC3118g1
    public long K1() {
        return this.a.K1();
    }

    @Override // io.sentry.InterfaceC3118g1
    public List Q1(ILogger iLogger, InterfaceC3176q0 interfaceC3176q0) throws IOException {
        if (this.a.peek() == io.sentry.vendor.gson.stream.b.NULL) {
            this.a.p();
            return null;
        }
        this.a.a();
        ArrayList arrayList = new ArrayList();
        if (this.a.j()) {
            do {
                try {
                    arrayList.add(interfaceC3176q0.a(this, iLogger));
                } catch (Exception e) {
                    iLogger.b(Y2.WARNING, "Failed to deserialize object in list.", e);
                }
            } while (this.a.peek() == io.sentry.vendor.gson.stream.b.BEGIN_OBJECT);
        }
        this.a.e();
        return arrayList;
    }

    @Override // io.sentry.InterfaceC3118g1
    public void R() throws IOException {
        this.a.R();
    }

    @Override // io.sentry.InterfaceC3118g1
    public String T0() {
        return this.a.T0();
    }

    @Override // io.sentry.InterfaceC3118g1
    public Integer Y0() throws IOException {
        if (this.a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Integer.valueOf(this.a.r0());
        }
        this.a.p();
        return null;
    }

    public void a() {
        this.a.a();
    }

    @Override // io.sentry.InterfaceC3118g1
    public TimeZone a0(ILogger iLogger) throws IOException {
        if (this.a.peek() == io.sentry.vendor.gson.stream.b.NULL) {
            this.a.p();
            return null;
        }
        try {
            return TimeZone.getTimeZone(this.a.T0());
        } catch (Exception e) {
            iLogger.b(Y2.ERROR, "Error when deserializing TimeZone", e);
            return null;
        }
    }

    @Override // io.sentry.InterfaceC3118g1
    public Long a1() throws IOException {
        if (this.a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Long.valueOf(this.a.K1());
        }
        this.a.p();
        return null;
    }

    public void b() {
        this.a.e();
    }

    public boolean c() {
        return this.a.m();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public void d() {
        this.a.p();
    }

    @Override // io.sentry.InterfaceC3118g1
    public float e1() {
        return (float) this.a.f1();
    }

    @Override // io.sentry.InterfaceC3118g1
    public double f1() {
        return this.a.f1();
    }

    @Override // io.sentry.InterfaceC3118g1
    public String g1() throws IOException {
        if (this.a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return this.a.T0();
        }
        this.a.p();
        return null;
    }

    @Override // io.sentry.InterfaceC3118g1
    public Map i1(ILogger iLogger, InterfaceC3176q0 interfaceC3176q0) throws IOException {
        if (this.a.peek() == io.sentry.vendor.gson.stream.b.NULL) {
            this.a.p();
            return null;
        }
        this.a.B();
        HashMap map = new HashMap();
        if (this.a.j()) {
            while (true) {
                try {
                    map.put(this.a.n0(), interfaceC3176q0.a(this, iLogger));
                } catch (Exception e) {
                    iLogger.b(Y2.WARNING, "Failed to deserialize object in map.", e);
                }
                if (this.a.peek() != io.sentry.vendor.gson.stream.b.BEGIN_OBJECT && this.a.peek() != io.sentry.vendor.gson.stream.b.NAME) {
                    break;
                }
            }
        }
        this.a.F();
        return map;
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
        if (this.a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Double.valueOf(this.a.f1());
        }
        this.a.p();
        return null;
    }

    @Override // io.sentry.InterfaceC3118g1
    public String n0() {
        return this.a.n0();
    }

    @Override // io.sentry.InterfaceC3118g1
    public io.sentry.vendor.gson.stream.b peek() {
        return this.a.peek();
    }

    @Override // io.sentry.InterfaceC3118g1
    public Date q0(ILogger iLogger) throws IOException {
        if (this.a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return InterfaceC3118g1.H0(this.a.T0(), iLogger);
        }
        this.a.p();
        return null;
    }

    @Override // io.sentry.InterfaceC3118g1
    public int r0() {
        return this.a.r0();
    }

    @Override // io.sentry.InterfaceC3118g1
    public Boolean v0() throws IOException {
        if (this.a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Boolean.valueOf(this.a.m());
        }
        this.a.p();
        return null;
    }

    @Override // io.sentry.InterfaceC3118g1
    public Float x1() throws IOException {
        if (this.a.peek() != io.sentry.vendor.gson.stream.b.NULL) {
            return Float.valueOf(e1());
        }
        this.a.p();
        return null;
    }
}
