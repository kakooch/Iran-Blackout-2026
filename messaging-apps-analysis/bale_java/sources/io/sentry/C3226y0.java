package io.sentry;

import java.io.IOException;
import java.io.Writer;

/* renamed from: io.sentry.y0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3226y0 implements InterfaceC3123h1 {
    private final io.sentry.vendor.gson.stream.c a;
    private final C3221x0 b;

    public C3226y0(Writer writer, int i) {
        this.a = new io.sentry.vendor.gson.stream.c(writer);
        this.b = new C3221x0(i);
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public C3226y0 d(boolean z) throws IOException {
        this.a.S(z);
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    public void D(boolean z) {
        this.a.D(z);
    }

    @Override // io.sentry.InterfaceC3123h1
    public String a() {
        return this.a.k();
    }

    @Override // io.sentry.InterfaceC3123h1
    public InterfaceC3123h1 i(String str) throws IOException {
        this.a.l(str);
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    public void j(String str) {
        this.a.z(str);
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C3226y0 g() throws IOException {
        this.a.c();
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C3226y0 B() throws IOException {
        this.a.d();
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C3226y0 e() {
        this.a.g();
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C3226y0 F() {
        this.a.j();
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C3226y0 f(String str) {
        this.a.m(str);
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C3226y0 n() throws IOException {
        this.a.p();
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public C3226y0 c(double d) throws IOException {
        this.a.H(d);
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public C3226y0 b(long j) throws IOException {
        this.a.J(j);
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C3226y0 l(ILogger iLogger, Object obj) {
        this.b.a(this, iLogger, obj);
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C3226y0 m(Boolean bool) throws IOException {
        this.a.K(bool);
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C3226y0 k(Number number) throws IOException {
        this.a.M(number);
        return this;
    }

    @Override // io.sentry.InterfaceC3123h1
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public C3226y0 h(String str) throws IOException {
        this.a.P(str);
        return this;
    }
}
