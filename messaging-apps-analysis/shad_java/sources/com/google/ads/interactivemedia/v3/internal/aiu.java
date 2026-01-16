package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aiu extends ald {
    private static final Writer a = new ait();
    private static final ago b = new ago("closed");
    private final List<agj> c;
    private String d;
    private agj e;

    public aiu() {
        super(a);
        this.c = new ArrayList();
        this.e = agl.a;
    }

    private final agj s() {
        return this.c.get(r0.size() - 1);
    }

    private final void t(agj agjVar) {
        if (this.d != null) {
            if (!(agjVar instanceof agl) || r()) {
                ((agm) s()).a(this.d, agjVar);
            }
            this.d = null;
            return;
        }
        if (this.c.isEmpty()) {
            this.e = agjVar;
            return;
        }
        agj agjVarS = s();
        if (!(agjVarS instanceof agh)) {
            throw new IllegalStateException();
        }
        ((agh) agjVarS).a(agjVar);
    }

    public final agj a() {
        if (this.c.isEmpty()) {
            return this.e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.c);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void b() throws IOException {
        agh aghVar = new agh();
        t(aghVar);
        this.c.add(aghVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void c() throws IOException {
        agm agmVar = new agm();
        t(agmVar);
        this.c.add(agmVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add(b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void d() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (!(s() instanceof agh)) {
            throw new IllegalStateException();
        }
        this.c.remove(r0.size() - 1);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void e() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (!(s() instanceof agm)) {
            throw new IllegalStateException();
        }
        this.c.remove(r0.size() - 1);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void f(String str) throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (!(s() instanceof agm)) {
            throw new IllegalStateException();
        }
        this.d = str;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald, java.io.Flushable
    public final void flush() throws IOException {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void g() throws IOException {
        t(agl.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void h(long j) throws IOException {
        t(new ago(Long.valueOf(j)));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void i(Boolean bool) throws IOException {
        if (bool == null) {
            g();
        } else {
            t(new ago(bool));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void j(Number number) throws IOException {
        if (number == null) {
            g();
            return;
        }
        if (!n()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        t(new ago(number));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void k(String str) throws IOException {
        if (str == null) {
            g();
        } else {
            t(new ago(str));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ald
    public final void l(boolean z) throws IOException {
        t(new ago(Boolean.valueOf(z)));
    }
}
