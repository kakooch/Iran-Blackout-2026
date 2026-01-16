package com.google.android.exoplayer2.source.chunk;

import android.net.Uri;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C19445qM6;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class Chunk implements Loader.e {
    public final long a = LoadEventInfo.a();
    public final b b;
    public final int c;
    public final X d;
    public final int e;
    public final Object f;
    public final long g;
    public final long h;
    protected final C19445qM6 i;

    public Chunk(a aVar, b bVar, int i, X x, int i2, Object obj, long j, long j2) {
        this.i = new C19445qM6(aVar);
        this.b = (b) AbstractC20011rK.e(bVar);
        this.c = i;
        this.d = x;
        this.e = i2;
        this.f = obj;
        this.g = j;
        this.h = j2;
    }

    public final long b() {
        return this.i.n();
    }

    public final long d() {
        return this.h - this.g;
    }

    public final Map e() {
        return this.i.p();
    }

    public final Uri f() {
        return this.i.o();
    }
}
