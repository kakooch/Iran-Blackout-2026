package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.b;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C19445qM6;
import ir.nasim.C22289uz1;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k implements Loader.e {
    public final long a;
    public final b b;
    public final int c;
    private final C19445qM6 d;
    private final a e;
    private volatile Object f;

    public interface a {
        Object a(Uri uri, InputStream inputStream);
    }

    public k(com.google.android.exoplayer2.upstream.a aVar, Uri uri, int i, a aVar2) {
        this(aVar, new b.C0164b().i(uri).b(1).a(), i, aVar2);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void a() throws IOException {
        this.d.q();
        C22289uz1 c22289uz1 = new C22289uz1(this.d, this.b);
        try {
            c22289uz1.b();
            this.f = this.e.a((Uri) AbstractC20011rK.e(this.d.getUri()), c22289uz1);
        } finally {
            AbstractC9683aN7.m(c22289uz1);
        }
    }

    public long b() {
        return this.d.n();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void c() {
    }

    public Map d() {
        return this.d.p();
    }

    public final Object e() {
        return this.f;
    }

    public Uri f() {
        return this.d.o();
    }

    public k(com.google.android.exoplayer2.upstream.a aVar, b bVar, int i, a aVar2) {
        this.d = new C19445qM6(aVar);
        this.b = bVar;
        this.c = i;
        this.e = aVar2;
        this.a = LoadEventInfo.a();
    }
}
