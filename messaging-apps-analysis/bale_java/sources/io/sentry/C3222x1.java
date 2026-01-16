package io.sentry;

import android.gov.nist.core.Separators;
import io.sentry.rrweb.d;
import java.util.List;
import java.util.Map;

/* renamed from: io.sentry.x1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3222x1 implements A0 {
    private Integer a;
    private List b;
    private Map c;

    /* renamed from: io.sentry.x1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[io.sentry.rrweb.c.values().length];
            b = iArr;
            try {
                iArr[io.sentry.rrweb.c.IncrementalSnapshot.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[io.sentry.rrweb.c.Meta.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[io.sentry.rrweb.c.Custom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.b.values().length];
            a = iArr2;
            try {
                iArr2[d.b.MouseInteraction.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.TouchMove.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: io.sentry.x1$b */
    public static final class b implements InterfaceC3176q0 {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00da  */
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public io.sentry.C3222x1 a(io.sentry.InterfaceC3118g1 r17, io.sentry.ILogger r18) {
            /*
                Method dump skipped, instructions count: 438
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.C3222x1.b.a(io.sentry.g1, io.sentry.ILogger):io.sentry.x1");
        }
    }

    public List a() {
        return this.b;
    }

    public void b(List list) {
        this.b = list;
    }

    public void c(Integer num) {
        this.a = num;
    }

    public void d(Map map) {
        this.c = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3222x1.class != obj.getClass()) {
            return false;
        }
        C3222x1 c3222x1 = (C3222x1) obj;
        return io.sentry.util.u.a(this.a, c3222x1.a) && io.sentry.util.u.a(this.b, c3222x1.b);
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b);
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("segment_id").k(this.a);
        }
        Map map = this.c;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.c.get(str));
            }
        }
        interfaceC3123h1.F();
        interfaceC3123h1.D(true);
        if (this.a != null) {
            interfaceC3123h1.i(Separators.RETURN);
        }
        List list = this.b;
        if (list != null) {
            interfaceC3123h1.l(iLogger, list);
        }
        interfaceC3123h1.D(false);
    }
}
