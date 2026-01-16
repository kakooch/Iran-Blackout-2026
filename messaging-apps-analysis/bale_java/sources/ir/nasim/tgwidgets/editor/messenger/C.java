package ir.nasim.tgwidgets.editor.messenger;

import android.content.SharedPreferences;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC15742k57;
import ir.nasim.AbstractC17515n57;
import ir.nasim.AbstractC19652qi7;
import ir.nasim.AbstractC20261ri7;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C5882Lf7;
import ir.nasim.F90;
import ir.nasim.UO6;
import ir.nasim.tgwidgets.editor.messenger.E;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class C extends F90 implements E.d {
    private static volatile C[] q = new C[1];
    private static final Object[] r = {new Object()};
    public int c;
    public int d;
    public ArrayList e;
    public boolean f;
    protected ArrayList g;
    public int h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    private SharedPreferences m;
    private SharedPreferences n;
    public UO6 o;
    private SharedPreferences p;

    public static class a {
        public int a;
        public String b;
        public int c;
        public int d;
        public ArrayList e = new ArrayList();
        public ArrayList f = null;
    }

    public C(int i) {
        super(i);
        this.c = 2;
        this.d = 5;
        this.e = new ArrayList();
        this.f = false;
        this.g = new ArrayList();
        this.h = 1024;
        this.i = 384;
        this.j = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        this.k = 64;
        this.l = false;
        C21457d.g0();
        d();
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.W74
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y();
            }
        });
        this.m = AbstractC14047hG.a.getSharedPreferences("Notifications", 0);
        this.n = AbstractC14047hG.a.getSharedPreferences("mainconfig", 0);
        this.p = AbstractC14047hG.a.getSharedPreferences("emoji", 0);
    }

    public static SharedPreferences l() {
        return n(0).p;
    }

    public static SharedPreferences m() {
        return AbstractC14047hG.a.getSharedPreferences("tg_widgets.ini", 0);
    }

    public static C n(int i) {
        C c = q[0];
        if (c == null) {
            synchronized (r[0]) {
                try {
                    c = q[0];
                    if (c == null) {
                        C[] cArr = q;
                        C c2 = new C(0);
                        cArr[0] = c2;
                        c = c2;
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static SharedPreferences p(int i) {
        return n(i).m;
    }

    public static String q(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C5882Lf7 c5882Lf7 = (C5882Lf7) arrayList.get(i);
            if ("all".equals(c5882Lf7.b) || (!AbstractC8814Xl0.a() && ConstantDeviceInfo.APP_PLATFORM.equals(c5882Lf7.b))) {
                return c5882Lf7.d;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        C c = c();
        e().e(c, E.I1);
        e().e(c, E.J1);
        e().e(c, E.K1);
        e().e(c, E.M1);
        e().e(c, E.N1);
        e().e(c, E.J);
        e().e(c, E.j0);
    }

    public void A(ArrayList arrayList, boolean z) {
    }

    public void B(ArrayList arrayList, boolean z) {
    }

    public void C(long j, boolean z, boolean z2) {
    }

    public AbstractC15742k57 i(Long l) {
        return null;
    }

    public ConcurrentHashMap j() {
        return null;
    }

    public int k(AbstractC17515n57 abstractC17515n57) {
        if (abstractC17515n57 == null) {
            return 0;
        }
        int i = abstractC17515n57.h;
        i(Long.valueOf(-abstractC17515n57.p));
        return i;
    }

    public SharedPreferences o() {
        return this.n;
    }

    public UO6 r() {
        UO6 uo6 = this.o;
        if (uo6 != null) {
            return uo6;
        }
        synchronized (r[this.a]) {
            try {
                UO6 uo62 = this.o;
                if (uo62 != null) {
                    return uo62;
                }
                UO6 uo63 = new UO6(this.a);
                this.o = uo63;
                return uo63;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AbstractC19652qi7 s(Long l) {
        return null;
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) {
    }

    public AbstractC20261ri7 u(long j) {
        return null;
    }

    public ConcurrentHashMap v() {
        return null;
    }

    public boolean w(long j) {
        return x(i(Long.valueOf(j)));
    }

    public boolean x(AbstractC15742k57 abstractC15742k57) {
        return false;
    }

    public void z(long j, int i, int i2, boolean z, int i3) {
    }
}
