package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.b;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C23773xV0;
import ir.nasim.Ie8;
import ir.nasim.InterfaceC17823nd1;
import ir.nasim.ZI4;
import java.util.Set;

/* loaded from: classes3.dex */
public final class a {
    private final AbstractC0169a a;
    private final g b;
    private final String c;

    /* renamed from: com.google.android.gms.common.api.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0169a extends e {
        public f a(Context context, Looper looper, C23773xV0 c23773xV0, Object obj, c.a aVar, c.b bVar) {
            return b(context, looper, c23773xV0, obj, aVar, bVar);
        }

        public f b(Context context, Looper looper, C23773xV0 c23773xV0, Object obj, InterfaceC17823nd1 interfaceC17823nd1, ZI4 zi4) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c {
    }

    public interface d {
        public static final C0170a P = new C0170a(null);

        /* renamed from: com.google.android.gms.common.api.a$d$a, reason: collision with other inner class name */
        public static final class C0170a implements d {
            /* synthetic */ C0170a(Ie8 ie8) {
            }
        }
    }

    public static abstract class e {
    }

    public interface f extends b {
        boolean a();

        void b(String str);

        void c();

        boolean d();

        String e();

        void f(b.c cVar);

        boolean h();

        boolean i();

        Set k();

        void l(com.google.android.gms.common.internal.e eVar, Set set);

        void m(b.e eVar);

        int n();

        Feature[] o();

        String p();
    }

    public static final class g extends c {
    }

    public a(String str, AbstractC0169a abstractC0169a, g gVar) {
        AbstractC3795Cj5.k(abstractC0169a, "Cannot construct an Api with a null ClientBuilder");
        AbstractC3795Cj5.k(gVar, "Cannot construct an Api with a null ClientKey");
        this.c = str;
        this.a = abstractC0169a;
        this.b = gVar;
    }

    public final AbstractC0169a a() {
        return this.a;
    }

    public final c b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
