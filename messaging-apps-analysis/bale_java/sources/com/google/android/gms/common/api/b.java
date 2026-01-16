package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.AbstractC2058b;
import com.google.android.gms.common.api.internal.AbstractC2064h;
import com.google.android.gms.common.api.internal.C2059c;
import com.google.android.gms.common.api.internal.C2060d;
import com.google.android.gms.common.api.internal.C2063g;
import com.google.android.gms.common.api.internal.C2069m;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.tasks.Task;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.AbstractC3993Df5;
import ir.nasim.AbstractServiceConnectionC15207jB4;
import ir.nasim.BinderC17850nf8;
import ir.nasim.C23773xV0;
import ir.nasim.C4982Hj7;
import ir.nasim.C9205Yy;
import ir.nasim.C9430Zx;
import ir.nasim.InterfaceC21248tM6;
import ir.nasim.Xe8;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

/* loaded from: classes3.dex */
public abstract class b {
    private final Context a;
    private final String b;
    private final com.google.android.gms.common.api.a c;
    private final a.d d;
    private final C9205Yy e;
    private final Looper f;
    private final int g;
    private final c h;
    private final InterfaceC21248tM6 i;
    protected final C2059c j;

    public static class a {
        public static final a c = new C0171a().a();
        public final InterfaceC21248tM6 a;
        public final Looper b;

        /* renamed from: com.google.android.gms.common.api.b$a$a, reason: collision with other inner class name */
        public static class C0171a {
            private InterfaceC21248tM6 a;
            private Looper b;

            /* JADX WARN: Multi-variable type inference failed */
            public a a() {
                if (this.a == null) {
                    this.a = new C9430Zx();
                }
                if (this.b == null) {
                    this.b = Looper.getMainLooper();
                }
                return new a(this.a, this.b);
            }

            public C0171a b(InterfaceC21248tM6 interfaceC21248tM6) {
                AbstractC3795Cj5.k(interfaceC21248tM6, "StatusExceptionMapper must not be null.");
                this.a = interfaceC21248tM6;
                return this;
            }
        }

        private a(InterfaceC21248tM6 interfaceC21248tM6, Account account, Looper looper) {
            this.a = interfaceC21248tM6;
            this.b = looper;
        }
    }

    public b(Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        this(activity, activity, aVar, dVar, aVar2);
    }

    private final AbstractC2058b x(int i, AbstractC2058b abstractC2058b) {
        abstractC2058b.zak();
        this.j.G(this, i, abstractC2058b);
        return abstractC2058b;
    }

    private final Task y(int i, AbstractC2064h abstractC2064h) {
        C4982Hj7 c4982Hj7 = new C4982Hj7();
        this.j.H(this, i, abstractC2064h, c4982Hj7, this.i);
        return c4982Hj7.a();
    }

    public c h() {
        return this.h;
    }

    protected C23773xV0.a i() {
        C23773xV0.a aVar = new C23773xV0.a();
        aVar.d(null);
        aVar.c(Collections.emptySet());
        aVar.e(this.a.getClass().getName());
        aVar.b(this.a.getPackageName());
        return aVar;
    }

    public AbstractC2058b j(AbstractC2058b abstractC2058b) {
        x(2, abstractC2058b);
        return abstractC2058b;
    }

    public Task k(AbstractC2064h abstractC2064h) {
        return y(2, abstractC2064h);
    }

    public Task l(AbstractC2064h abstractC2064h) {
        return y(0, abstractC2064h);
    }

    public Task m(C2063g c2063g) {
        AbstractC3795Cj5.j(c2063g);
        AbstractC3795Cj5.k(c2063g.a.b(), "Listener has already been released.");
        AbstractC3795Cj5.k(c2063g.b.a(), "Listener has already been released.");
        return this.j.A(this, c2063g.a, c2063g.b, c2063g.c);
    }

    public Task n(C2060d.a aVar, int i) {
        AbstractC3795Cj5.k(aVar, "Listener key cannot be null.");
        return this.j.B(this, aVar, i);
    }

    public AbstractC2058b o(AbstractC2058b abstractC2058b) {
        x(1, abstractC2058b);
        return abstractC2058b;
    }

    public Task p(AbstractC2064h abstractC2064h) {
        return y(1, abstractC2064h);
    }

    public final C9205Yy q() {
        return this.e;
    }

    public Context r() {
        return this.a;
    }

    protected String s() {
        return this.b;
    }

    public Looper t() {
        return this.f;
    }

    public final int u() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a.f v(Looper looper, s sVar) {
        a.f fVarA = ((a.AbstractC0169a) AbstractC3795Cj5.j(this.c.a())).a(this.a, looper, i().a(), this.d, sVar, sVar);
        String strS = s();
        if (strS != null && (fVarA instanceof com.google.android.gms.common.internal.b)) {
            ((com.google.android.gms.common.internal.b) fVarA).P(strS);
        }
        if (strS == null || !(fVarA instanceof AbstractServiceConnectionC15207jB4)) {
            return fVarA;
        }
        AbstractC18350oW3.a(fVarA);
        throw null;
    }

    public final BinderC17850nf8 w(Context context, Handler handler) {
        return new BinderC17850nf8(context, handler, i().a());
    }

    private b(Context context, Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        AbstractC3795Cj5.k(context, "Null context is not permitted.");
        AbstractC3795Cj5.k(aVar, "Api must not be null.");
        AbstractC3795Cj5.k(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.a = context.getApplicationContext();
        String str = null;
        if (AbstractC3993Df5.k()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", null).invoke(context, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.b = str;
        this.c = aVar;
        this.d = dVar;
        this.f = aVar2.b;
        C9205Yy c9205YyA = C9205Yy.a(aVar, dVar, str);
        this.e = c9205YyA;
        this.h = new Xe8(this);
        C2059c c2059cY = C2059c.y(this.a);
        this.j = c2059cY;
        this.g = c2059cY.n();
        this.i = aVar2.a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            C2069m.u(activity, c2059cY, c9205YyA);
        }
        c2059cY.c(this);
    }

    public b(Context context, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        this(context, null, aVar, dVar, aVar2);
    }

    public b(Context context, com.google.android.gms.common.api.a aVar, a.d dVar, InterfaceC21248tM6 interfaceC21248tM6) {
        a.C0171a c0171a = new a.C0171a();
        c0171a.b(interfaceC21248tM6);
        this(context, aVar, dVar, c0171a.a());
    }
}
