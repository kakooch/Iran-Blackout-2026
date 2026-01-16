package io.sentry;

import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: io.sentry.v0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3211v0 {
    private final ArrayList a = new ArrayList();

    /* renamed from: io.sentry.v0$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.sentry.vendor.gson.stream.b.values().length];
            a = iArr;
            try {
                iArr[io.sentry.vendor.gson.stream.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.sentry.v0$b */
    interface b {
        Object a();
    }

    /* renamed from: io.sentry.v0$c */
    private interface c {
        Object getValue();
    }

    /* renamed from: io.sentry.v0$f */
    private static final class f implements c {
        final String a;

        f(String str) {
            this.a = str;
        }

        @Override // io.sentry.C3211v0.c
        public Object getValue() {
            return this.a;
        }
    }

    /* renamed from: io.sentry.v0$g */
    private static final class g implements c {
        final Object a;

        g(Object obj) {
            this.a = obj;
        }

        @Override // io.sentry.C3211v0.c
        public Object getValue() {
            return this.a;
        }
    }

    private c f() {
        if (this.a.isEmpty()) {
            return null;
        }
        return (c) this.a.get(r0.size() - 1);
    }

    private boolean g() {
        if (i()) {
            return true;
        }
        c cVarF = f();
        p();
        if (!(f() instanceof f)) {
            if (!(f() instanceof d)) {
                return false;
            }
            d dVar = (d) f();
            if (cVarF == null || dVar == null) {
                return false;
            }
            dVar.a.add(cVarF.getValue());
            return false;
        }
        f fVar = (f) f();
        p();
        e eVar = (e) f();
        if (fVar == null || cVarF == null || eVar == null) {
            return false;
        }
        eVar.a.put(fVar.a, cVarF.getValue());
        return false;
    }

    private boolean h(b bVar) {
        Object objA = bVar.a();
        if (f() == null && objA != null) {
            q(new g(objA));
            return true;
        }
        if (f() instanceof f) {
            f fVar = (f) f();
            p();
            ((e) f()).a.put(fVar.a, objA);
            return false;
        }
        if (!(f() instanceof d)) {
            return false;
        }
        ((d) f()).a.add(objA);
        return false;
    }

    private boolean i() {
        return this.a.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object l(C3216w0 c3216w0) {
        return Boolean.valueOf(c3216w0.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object m() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object k(C3216w0 c3216w0) {
        try {
            try {
                return Integer.valueOf(c3216w0.r0());
            } catch (Exception unused) {
                return Double.valueOf(c3216w0.f1());
            }
        } catch (Exception unused2) {
            return Long.valueOf(c3216w0.K1());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void o(final C3216w0 c3216w0) {
        boolean zG;
        a aVar = null;
        switch (a.a[c3216w0.peek().ordinal()]) {
            case 1:
                c3216w0.a();
                q(new d(aVar));
                zG = false;
                break;
            case 2:
                c3216w0.b();
                zG = g();
                break;
            case 3:
                c3216w0.B();
                q(new e(aVar));
                zG = false;
                break;
            case 4:
                c3216w0.F();
                zG = g();
                break;
            case 5:
                q(new f(c3216w0.n0()));
                zG = false;
                break;
            case 6:
                zG = h(new b() { // from class: io.sentry.r0
                    @Override // io.sentry.C3211v0.b
                    public final Object a() {
                        return c3216w0.T0();
                    }
                });
                break;
            case 7:
                zG = h(new b() { // from class: io.sentry.s0
                    @Override // io.sentry.C3211v0.b
                    public final Object a() {
                        return this.a.k(c3216w0);
                    }
                });
                break;
            case 8:
                zG = h(new b() { // from class: io.sentry.t0
                    @Override // io.sentry.C3211v0.b
                    public final Object a() {
                        return C3211v0.l(c3216w0);
                    }
                });
                break;
            case 9:
                c3216w0.d();
                zG = h(new b() { // from class: io.sentry.u0
                    @Override // io.sentry.C3211v0.b
                    public final Object a() {
                        return C3211v0.m();
                    }
                });
                break;
            case 10:
                zG = true;
                break;
            default:
                zG = false;
                break;
        }
        if (zG) {
            return;
        }
        o(c3216w0);
    }

    private void p() {
        if (this.a.isEmpty()) {
            return;
        }
        this.a.remove(r0.size() - 1);
    }

    private void q(c cVar) {
        this.a.add(cVar);
    }

    public Object e(C3216w0 c3216w0) {
        o(c3216w0);
        c cVarF = f();
        if (cVarF != null) {
            return cVarF.getValue();
        }
        return null;
    }

    /* renamed from: io.sentry.v0$d */
    private static final class d implements c {
        final ArrayList a;

        private d() {
            this.a = new ArrayList();
        }

        @Override // io.sentry.C3211v0.c
        public Object getValue() {
            return this.a;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: io.sentry.v0$e */
    private static final class e implements c {
        final HashMap a;

        private e() {
            this.a = new HashMap();
        }

        @Override // io.sentry.C3211v0.c
        public Object getValue() {
            return this.a;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }
}
