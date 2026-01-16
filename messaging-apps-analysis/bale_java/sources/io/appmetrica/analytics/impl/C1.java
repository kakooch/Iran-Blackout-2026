package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceConfig;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashServiceModule;
import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC9766aX0;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class C1 implements InterfaceC2744o1, InterfaceC2623j0 {
    public boolean a;
    public final Context b;
    public volatile InterfaceC2720n1 c;
    public final C2723n4 d;
    public final M1 e;
    public C2687lg f;
    public final Y9 g;
    public final C2636jd h;
    public final C2578h2 i;
    public final ICommonExecutor j;
    public final D1 k;
    public final A1 l;
    public final C2926vg m;
    public C2510e6 n;

    public C1(Context context, InterfaceC2720n1 interfaceC2720n1) {
        this(context, interfaceC2720n1, new C2628j5(context));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void a(Intent intent, int i) {
        b(intent, i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void b(Intent intent) throws NumberFormatException {
        this.e.e(intent);
        if (intent != null) {
            String action = intent.getAction();
            Uri data = intent.getData();
            String encodedAuthority = data == null ? null : data.getEncodedAuthority();
            if ("io.appmetrica.analytics.IAppMetricaService".equals(action) && data != null && data.getPath().equals("/client")) {
                int i = Integer.parseInt(data.getQueryParameter("pid"));
                this.d.a(i, encodedAuthority, data.getQueryParameter("psid"));
                this.i.a(i);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void c(Intent intent) {
        M1 m1 = this.e;
        if (intent == null) {
            m1.getClass();
            return;
        }
        m1.getClass();
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            m1.a.a(action, Integer.valueOf(M1.a(intent)));
        }
        for (Map.Entry entry : m1.b.entrySet()) {
            if (((K1) entry.getValue()).a(intent)) {
                ((L1) entry.getKey()).a(intent);
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void onConfigurationChanged(Configuration configuration) {
        C2586ha.C.s().a(configuration);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void onCreate() {
        if (this.a) {
            C2586ha.C.s().a(this.b.getResources().getConfiguration());
        } else {
            this.g.b(this.b);
            C2586ha c2586ha = C2586ha.C;
            synchronized (c2586ha) {
                c2586ha.B.initAsync();
                c2586ha.u.b(c2586ha.a);
                c2586ha.u.a(new fn(c2586ha.B));
                NetworkServiceLocator.init();
                c2586ha.i().a(c2586ha.q);
                c2586ha.B();
            }
            AbstractC2618ij.a.e();
            C2597hl c2597hl = C2586ha.C.u;
            C2549fl c2549flA = c2597hl.a();
            C2549fl c2549flA2 = c2597hl.a();
            C3001yj c3001yjM = C2586ha.C.m();
            c3001yjM.a(new C2714mj(new Hc(this.e)), c2549flA2);
            c2597hl.a(c3001yjM);
            ((C3026zk) C2586ha.C.x()).getClass();
            M1 m1 = this.e;
            m1.b.put(new B1(this), new I1(m1));
            C2586ha.C.j().init();
            S sV = C2586ha.C.v();
            Context context = this.b;
            sV.c = c2549flA;
            sV.b(context);
            D1 d1 = this.k;
            Context context2 = this.b;
            C2723n4 c2723n4 = this.d;
            d1.getClass();
            this.f = new C2687lg(context2, c2723n4, C2586ha.C.d.e(), new U9());
            AppMetrica.getReporter(this.b, "20799a27-fa80-4b36-b2db-0f8141f24180");
            File crashesDirectory = FileUtils.getCrashesDirectory(this.b);
            if (crashesDirectory != null) {
                D1 d12 = this.k;
                A1 a1 = this.l;
                d12.getClass();
                this.n = new C2510e6(new FileObserverC2534f6(crashesDirectory, a1, new U9()), crashesDirectory, new C2558g6());
                this.j.execute(new RunnableC2591hf(crashesDirectory, this.l, T9.a(this.b)));
                C2510e6 c2510e6 = this.n;
                C2558g6 c2558g6 = c2510e6.c;
                File file = c2510e6.b;
                c2558g6.getClass();
                if (file != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    } else if (!file.isDirectory() && file.delete()) {
                        file.mkdir();
                    }
                }
                c2510e6.a.startWatching();
            }
            C2636jd c2636jd = this.h;
            Context context3 = this.b;
            C2687lg c2687lg = this.f;
            c2636jd.getClass();
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context3);
            C2589hd c2589hd = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                c2636jd.a.init(context3, new NativeCrashServiceConfig(absolutePath));
                C2589hd c2589hd2 = new C2589hd(c2687lg, new C2613id(c2636jd));
                c2636jd.b = c2589hd2;
                c2589hd2.a(c2636jd.a.getAllCrashes());
                NativeCrashServiceModule nativeCrashServiceModule = c2636jd.a;
                C2589hd c2589hd3 = c2636jd.b;
                if (c2589hd3 == null) {
                    AbstractC13042fc3.y("crashReporter");
                } else {
                    c2589hd = c2589hd3;
                }
                nativeCrashServiceModule.setDefaultCrashHandler(c2589hd);
            }
            new J5(AbstractC9766aX0.e(new RunnableC2807qg())).run();
            this.a = true;
        }
        C2586ha.C.i().a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void onDestroy() {
        C2969xb c2969xbI = C2586ha.C.i();
        synchronized (c2969xbI) {
            Iterator it = c2969xbI.c.iterator();
            while (it.hasNext()) {
                ((InterfaceC2905uj) it.next()).onDestroy();
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void pauseUserSession(Bundle bundle) {
        Oe oe;
        bundle.setClassLoader(Oe.class.getClassLoader());
        String str = Oe.c;
        try {
            oe = (Oe) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            oe = null;
        }
        Integer asInteger = oe != null ? oe.a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.i.b(asInteger.intValue());
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void reportData(int i, Bundle bundle) {
        this.m.getClass();
        List listM = (List) C2586ha.C.v.a.get(Integer.valueOf(i));
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        if (listM.isEmpty()) {
            return;
        }
        Iterator it = listM.iterator();
        while (it.hasNext()) {
            ((InterfaceC2738nj) it.next()).reportData(i, bundle);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void resumeUserSession(Bundle bundle) {
        Oe oe;
        bundle.setClassLoader(Oe.class.getClassLoader());
        String str = Oe.c;
        try {
            oe = (Oe) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            oe = null;
        }
        Integer asInteger = oe != null ? oe.a.getAsInteger("PROCESS_CFG_PROCESS_ID") : null;
        if (asInteger != null) {
            this.i.c(asInteger.intValue());
        }
    }

    public C1(Context context, InterfaceC2720n1 interfaceC2720n1, C2628j5 c2628j5) {
        this(context, interfaceC2720n1, new C2723n4(context, c2628j5), new M1(), Y9.d, C2586ha.h().c(), C2586ha.h().u().e(), new D1());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void a(Intent intent, int i, int i2) {
        b(intent, i2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void a(Intent intent) {
        M1 m1 = this.e;
        if (intent != null) {
            m1.getClass();
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                m1.a.a(action, Integer.valueOf(M1.a(intent)));
            }
            for (Map.Entry entry : m1.b.entrySet()) {
                if (((K1) entry.getValue()).a(intent)) {
                    ((L1) entry.getKey()).a(intent);
                }
            }
            return;
        }
        m1.getClass();
    }

    public C1(Context context, InterfaceC2720n1 interfaceC2720n1, C2723n4 c2723n4, M1 m1, Y9 y9, C2578h2 c2578h2, IHandlerExecutor iHandlerExecutor, D1 d1) {
        this.a = false;
        this.l = new A1(this);
        this.b = context;
        this.c = interfaceC2720n1;
        this.d = c2723n4;
        this.e = m1;
        this.g = y9;
        this.i = c2578h2;
        this.j = iHandlerExecutor;
        this.k = d1;
        this.h = C2586ha.h().o();
        this.m = new C2926vg();
    }

    public final void b(Intent intent, int i) {
        Bundle extras;
        Y3 y3A;
        if (intent != null) {
            intent.getExtras().setClassLoader(CounterConfiguration.class.getClassLoader());
            if (intent.getData() != null && (y3A = Y3.a(this.b, (extras = intent.getExtras()))) != null) {
                Q5 q5B = Q5.b(extras);
                if (!(q5B.l() | q5B.m())) {
                    try {
                        C2687lg c2687lg = this.f;
                        C2508e4 c2508e4A = C2508e4.a(y3A);
                        A4 a4 = new A4(y3A);
                        c2687lg.c.a(c2508e4A, a4).a(q5B, a4);
                        c2687lg.c.a(c2508e4A.c.intValue(), c2508e4A.b, c2508e4A.d);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        ((C2672l1) this.c).a.stopSelfResult(i);
    }

    public final void a(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        Q5.b(bundle);
        C2687lg c2687lg = this.f;
        Q5 q5B = Q5.b(bundle);
        c2687lg.getClass();
        if (q5B.m()) {
            return;
        }
        c2687lg.b.execute(new Dg(c2687lg.a, q5B, bundle, c2687lg.c));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void a(InterfaceC2720n1 interfaceC2720n1) {
        this.c = interfaceC2720n1;
    }

    public final void a(File file) {
        C2687lg c2687lg = this.f;
        c2687lg.getClass();
        C2515eb c2515eb = new C2515eb();
        c2687lg.b.execute(new RunnableC2567gf(file, c2515eb, c2515eb, new C2592hg(c2687lg)));
    }
}
