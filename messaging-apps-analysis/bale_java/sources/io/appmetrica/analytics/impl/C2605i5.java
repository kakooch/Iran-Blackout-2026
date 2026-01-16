package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC4616Fw7;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* renamed from: io.appmetrica.analytics.impl.i5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2605i5 {
    public final C2557g5 a;
    public final C2581h5 b;
    protected final Context c;
    public final W4 d;
    public final C3010z4 e;
    public final AbstractC2434b5 f;
    protected final C2549fl g;
    public final InterfaceC3022zg h;
    public final A8 i;
    public final ICommonExecutor j;
    public final C2969xb k;
    public final int l;

    public C2605i5(Context context, W4 w4, C3010z4 c3010z4, AbstractC2434b5 abstractC2434b5, C2549fl c2549fl, InterfaceC3022zg interfaceC3022zg, ICommonExecutor iCommonExecutor, int i, C2969xb c2969xb) {
        this(context, w4, c3010z4, abstractC2434b5, c2549fl, interfaceC3022zg, iCommonExecutor, new A8(), i, new C2557g5(c3010z4.a), new C2581h5(context, w4), c2969xb);
    }

    public static S8 c(C2484d5 c2484d5) {
        return new S8(c2484d5);
    }

    public final F8 a() {
        Context context = this.c;
        W4 w4 = this.d;
        return new F8(new K8(context, w4), this.l);
    }

    public final I6 b(C2484d5 c2484d5) {
        return new I6(c2484d5, W6.a(this.c).c(this.d), new E6(c2484d5.c()), new C2486d7());
    }

    public final C2557g5 d() {
        return this.a;
    }

    public final C2581h5 e() {
        return this.b;
    }

    public final tn f() {
        tn tnVar;
        xn v9;
        wn wnVarA = C2586ha.C.A();
        W4 w4 = this.d;
        synchronized (wnVarA) {
            try {
                String strValueOf = String.valueOf(w4);
                LinkedHashMap linkedHashMap = wnVarA.b;
                Object tnVar2 = linkedHashMap.get(strValueOf);
                if (tnVar2 == null) {
                    C2661ke c2661ke = new C2661ke(W6.a(wnVarA.a).b(w4));
                    if (w4.d()) {
                        String str = "appmetrica_vital_" + w4.b + ".dat";
                        v9 = new C2652k5(AbstractC10360bX0.p(AbstractC4616Fw7.a(str, new V9(wnVarA.a, str)), AbstractC4616Fw7.a("appmetrica_vital_main.dat", new V9(wnVarA.a, "appmetrica_vital_main.dat"))));
                    } else {
                        v9 = new V9(wnVarA.a, "appmetrica_vital_" + w4.b + ".dat");
                    }
                    tnVar2 = new tn(c2661ke, v9, strValueOf);
                    linkedHashMap.put(strValueOf, tnVar2);
                }
                tnVar = (tn) tnVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tnVar;
    }

    public C2605i5(Context context, W4 w4, C3010z4 c3010z4, AbstractC2434b5 abstractC2434b5, C2549fl c2549fl, InterfaceC3022zg interfaceC3022zg, ICommonExecutor iCommonExecutor, A8 a8, int i, C2557g5 c2557g5, C2581h5 c2581h5, C2969xb c2969xb) {
        this.c = context;
        this.d = w4;
        this.e = c3010z4;
        this.f = abstractC2434b5;
        this.g = c2549fl;
        this.h = interfaceC3022zg;
        this.j = iCommonExecutor;
        this.i = a8;
        this.l = i;
        this.a = c2557g5;
        this.b = c2581h5;
        this.k = c2969xb;
    }

    public final Kj c() {
        return new Kj(this.c, this.d);
    }

    public final Kh d(C2484d5 c2484d5) {
        Kh kh = new Kh(c2484d5, this.f.a(), this.j);
        C2969xb c2969xb = this.k;
        synchronized (c2969xb) {
            c2969xb.c.add(kh);
        }
        return kh;
    }

    public final C2544fg a(C2484d5 c2484d5) {
        return new C2544fg(new Ag(c2484d5, this.h, new T3()), this.g, new C2974xg(this.e));
    }

    public static Sj a(C2484d5 c2484d5, tn tnVar, C2459c5 c2459c5) {
        Rj rj = new Rj(tnVar);
        return new Sj(c2484d5, rj, c2459c5, new C2439ba(c2484d5, rj, new Vj(c2484d5.g(), C2439ba.g), AbstractC2648k1.a(), new SystemTimeProvider()), new G2(c2484d5, rj, new Vj(c2484d5.g(), G2.g), AbstractC2648k1.a(), new SystemTimeProvider()), new G9(c2484d5.a));
    }

    public static Y4 b() {
        return new Y4();
    }

    public final C2537f9 a(C2661ke c2661ke, tn tnVar, Sj sj, I6 i6, C2429b0 c2429b0, Kj kj, Kh kh) {
        return new C2537f9(c2661ke, tnVar, sj, i6, c2429b0, this.i, kj, this.l, new C2533f5(kh), new M8(tnVar, new N8(tnVar)), new SystemTimeProvider());
    }

    public static Ih a(C2484d5 c2484d5, S8 s8) {
        return new Ih(s8, c2484d5);
    }

    public static A5 a(I6 i6) {
        return new A5(i6);
    }

    public static C2731nc a(I6 i6, C2544fg c2544fg) {
        return new C2731nc(i6, c2544fg);
    }

    public static C2680l9 a(ArrayList arrayList, InterfaceC2752o9 interfaceC2752o9) {
        return new C2680l9(arrayList, interfaceC2752o9);
    }

    public final D3 a(C2661ke c2661ke) {
        Context context = this.c;
        return new D3(context, c2661ke, context.getPackageName(), new SafePackageManager());
    }
}
