package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DrmInitData;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC13937h43;
import ir.nasim.AbstractC17264mg3;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class HlsMediaPlaylist extends HlsPlaylist {
    public final int d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public final int j;
    public final long k;
    public final int l;
    public final long m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final DrmInitData q;
    public final List r;
    public final List s;
    public final Map t;
    public final long u;
    public final ServerControl v;

    public static final class Part extends SegmentBase {
        public final boolean l;
        public final boolean m;

        public Part(String str, Segment segment, long j, int i, long j2, DrmInitData drmInitData, String str2, String str3, long j3, long j4, boolean z, boolean z2, boolean z3) {
            super(str, segment, j, i, j2, drmInitData, str2, str3, j3, j4, z);
            this.l = z2;
            this.m = z3;
        }

        public Part h(long j, int i) {
            return new Part(this.a, this.b, this.c, i, j, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaylistType {
    }

    public static final class RenditionReport {
        public final Uri a;
        public final long b;
        public final int c;

        public RenditionReport(Uri uri, long j, int i) {
            this.a = uri;
            this.b = j;
            this.c = i;
        }
    }

    public static class SegmentBase implements Comparable<Long> {
        public final String a;
        public final Segment b;
        public final long c;
        public final int d;
        public final long e;
        public final DrmInitData f;
        public final String g;
        public final String h;
        public final long i;
        public final long j;
        public final boolean k;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l) {
            if (this.e > l.longValue()) {
                return 1;
            }
            return this.e < l.longValue() ? -1 : 0;
        }

        private SegmentBase(String str, Segment segment, long j, int i, long j2, DrmInitData drmInitData, String str2, String str3, long j3, long j4, boolean z) {
            this.a = str;
            this.b = segment;
            this.c = j;
            this.d = i;
            this.e = j2;
            this.f = drmInitData;
            this.g = str2;
            this.h = str3;
            this.i = j3;
            this.j = j4;
            this.k = z;
        }
    }

    public static final class ServerControl {
        public final long a;
        public final boolean b;
        public final long c;
        public final long d;
        public final boolean e;

        public ServerControl(long j, boolean z, long j2, long j3, boolean z2) {
            this.a = j;
            this.b = z;
            this.c = j2;
            this.d = j3;
            this.e = z2;
        }
    }

    public HlsMediaPlaylist(int i, String str, List list, long j, boolean z, long j2, boolean z2, int i2, long j3, int i3, long j4, long j5, boolean z3, boolean z4, boolean z5, DrmInitData drmInitData, List list2, List list3, ServerControl serverControl, Map map) {
        super(str, list, z3);
        this.d = i;
        this.h = j2;
        this.g = z;
        this.i = z2;
        this.j = i2;
        this.k = j3;
        this.l = i3;
        this.m = j4;
        this.n = j5;
        this.o = z4;
        this.p = z5;
        this.q = drmInitData;
        this.r = AbstractC12710f43.O(list2);
        this.s = AbstractC12710f43.O(list3);
        this.t = AbstractC13937h43.e(map);
        if (!list3.isEmpty()) {
            Part part = (Part) AbstractC17264mg3.c(list3);
            this.u = part.e + part.c;
        } else if (list2.isEmpty()) {
            this.u = 0L;
        } else {
            Segment segment = (Segment) AbstractC17264mg3.c(list2);
            this.u = segment.e + segment.c;
        }
        this.e = j != -9223372036854775807L ? j >= 0 ? Math.min(this.u, j) : Math.max(0L, this.u + j) : -9223372036854775807L;
        this.f = j >= 0;
        this.v = serverControl;
    }

    @Override // ir.nasim.InterfaceC18525oo2
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public HlsMediaPlaylist a(List list) {
        return this;
    }

    public HlsMediaPlaylist c(long j, int i) {
        return new HlsMediaPlaylist(this.d, this.a, this.b, this.e, this.g, j, true, i, this.k, this.l, this.m, this.n, this.c, this.o, this.p, this.q, this.r, this.s, this.v, this.t);
    }

    public HlsMediaPlaylist d() {
        return this.o ? this : new HlsMediaPlaylist(this.d, this.a, this.b, this.e, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.c, true, this.p, this.q, this.r, this.s, this.v, this.t);
    }

    public long e() {
        return this.h + this.u;
    }

    public boolean f(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist == null) {
            return true;
        }
        long j = this.k;
        long j2 = hlsMediaPlaylist.k;
        if (j > j2) {
            return true;
        }
        if (j < j2) {
            return false;
        }
        int size = this.r.size() - hlsMediaPlaylist.r.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.s.size();
        int size3 = hlsMediaPlaylist.s.size();
        if (size2 <= size3) {
            return size2 == size3 && this.o && !hlsMediaPlaylist.o;
        }
        return true;
    }

    public static final class Segment extends SegmentBase {
        public final String l;
        public final List m;

        public Segment(String str, long j, long j2, String str2, String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j, j2, false, AbstractC12710f43.V());
        }

        public Segment h(long j, int i) {
            ArrayList arrayList = new ArrayList();
            long j2 = j;
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                Part part = (Part) this.m.get(i2);
                arrayList.add(part.h(j2, i));
                j2 += part.c;
            }
            return new Segment(this.a, this.b, this.l, this.c, i, j, this.f, this.g, this.h, this.i, this.j, this.k, arrayList);
        }

        public Segment(String str, Segment segment, String str2, long j, int i, long j2, DrmInitData drmInitData, String str3, String str4, long j3, long j4, boolean z, List list) {
            super(str, segment, j, i, j2, drmInitData, str3, str4, j3, j4, z);
            this.l = str2;
            this.m = AbstractC12710f43.O(list);
        }
    }
}
