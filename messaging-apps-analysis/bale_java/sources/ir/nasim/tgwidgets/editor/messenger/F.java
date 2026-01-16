package ir.nasim.tgwidgets.editor.messenger;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import ir.nasim.AD4;
import ir.nasim.AbstractC13547gQ0;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC17515n57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C10743c74;
import ir.nasim.C15445jb7;
import ir.nasim.C20189rb7;
import ir.nasim.C21892uJ3;
import ir.nasim.C22477vI7;
import ir.nasim.C5837La7;
import ir.nasim.C6564Oa7;
import ir.nasim.EE4;
import ir.nasim.F90;
import ir.nasim.HU1;
import ir.nasim.L57;
import ir.nasim.M57;
import ir.nasim.P57;
import ir.nasim.TI6;
import ir.nasim.U00;
import ir.nasim.WE4;
import ir.nasim.Z57;
import ir.nasim.ZC4;
import ir.nasim.ZO1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import livekit.org.webrtc.MediaStreamTrack;

/* loaded from: classes7.dex */
public class F extends F90 {
    public static String B0;
    private static final HU1 C0 = new HU1("notificationsQueue");
    private static AD4 D0;
    private static NotificationManager E0;
    protected static AudioManager F0;
    private static volatile F[] G0;
    private static final Object[] H0;
    private static final C21892uJ3 I0;
    public boolean A;
    private Runnable A0;
    private Runnable B;
    private PowerManager.WakeLock D;
    private AlarmManager G;
    private int H;
    private String J;
    private TI6 Y;
    WE4 Z;
    private final ArrayList c;
    private final ArrayList d;
    private final C21892uJ3 e;
    private final C21892uJ3 f;
    private final C21892uJ3 g;
    private final C21892uJ3 h;
    private final C21892uJ3 i;
    private final C21892uJ3 j;
    private final C21892uJ3 k;
    public final ArrayList l;
    public ArrayList m;
    private final HashSet n;
    private final ArrayList o;
    private final C21892uJ3 p;
    private long q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private int x;
    public boolean y;
    public boolean z;
    char[] z0;

    class a {
        a() {
        }
    }

    public static class b {
        final long a;
        String b;
        final HashMap c;
        boolean d;
        public long e;

        public b(long j, String str, int i, long j2, long j3) {
            HashMap map = new HashMap();
            this.c = map;
            this.a = j;
            this.b = str;
            map.put(Integer.valueOf(i), new Pair(Long.valueOf(j2), Long.valueOf(j3)));
            this.e = j2;
        }

        public long a() {
            long jLongValue = -1;
            for (Pair pair : this.c.values()) {
                if (jLongValue == -1 || jLongValue > ((Long) pair.first).longValue()) {
                    jLongValue = ((Long) pair.first).longValue();
                }
            }
            return jLongValue;
        }
    }

    static {
        D0 = null;
        E0 = null;
        if (Build.VERSION.SDK_INT >= 26 && AbstractC14047hG.a != null) {
            D0 = AD4.e(AbstractC14047hG.a);
            E0 = (NotificationManager) AbstractC14047hG.a.getSystemService("notification");
            l();
        }
        F0 = (AudioManager) AbstractC14047hG.a.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        G0 = new F[1];
        H0 = new Object[]{new Object()};
        I0 = new C21892uJ3();
    }

    public F(int i) {
        super(i);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new C21892uJ3();
        this.f = new C21892uJ3();
        this.g = new C21892uJ3();
        this.h = new C21892uJ3();
        this.i = new C21892uJ3();
        this.j = new C21892uJ3();
        this.k = new C21892uJ3();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new HashSet();
        this.o = new ArrayList();
        this.p = new C21892uJ3();
        this.q = 0L;
        this.r = 0;
        this.s = 5000;
        this.t = 0;
        this.u = 0;
        this.v = false;
        this.x = -1;
        this.Y = new TI6();
        this.z0 = new char[]{10252, 10338, 10385, 10280};
        this.A0 = new Runnable() { // from class: ir.nasim.PE4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m();
            }
        };
        this.H = this.a + 1;
        StringBuilder sb = new StringBuilder();
        sb.append("messages");
        int i2 = this.a;
        sb.append(i2 == 0 ? "" : Integer.valueOf(i2));
        this.J = sb.toString();
        SharedPreferences sharedPreferencesG = a().g();
        this.w = sharedPreferencesG.getBoolean("EnableInChatSound", true);
        this.y = sharedPreferencesG.getBoolean("badgeNumber", true);
        this.z = sharedPreferencesG.getBoolean("badgeNumberMuted", false);
        this.A = sharedPreferencesG.getBoolean("badgeNumberMessages", true);
        D0 = AD4.e(AbstractC14047hG.a);
        E0 = (NotificationManager) AbstractC14047hG.a.getSystemService("notification");
        try {
            F0 = (AudioManager) AbstractC14047hG.a.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        try {
            this.G = (AlarmManager) AbstractC14047hG.a.getSystemService("alarm");
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
        try {
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) AbstractC14047hG.a.getSystemService("power")).newWakeLock(1, "telegram:notification_delay_lock");
            this.D = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
        } catch (Exception e3) {
            AbstractC6403Nl2.d(e3);
        }
        this.B = new Runnable() { // from class: ir.nasim.QE4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x();
            }
        };
        this.Z = new WE4(this.a);
    }

    private void B(int i) {
        if (this.x == i) {
            return;
        }
        this.x = i;
    }

    private void C(boolean z) {
        U00.d(AbstractC14047hG.a, "showOrUpdateNotification");
    }

    private void D() {
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < this.o.size(); i++) {
            Iterator it = ((b) this.o.get(i)).c.values().iterator();
            while (it.hasNext()) {
                jMin = Math.min(jMin, ((Long) ((Pair) it.next()).second).longValue());
            }
        }
        AbstractC21455b.t(this.A0);
        long jCurrentTimeMillis = jMin - System.currentTimeMillis();
        if (jMin != Long.MAX_VALUE) {
            AbstractC21455b.n1(this.A0, Math.max(0L, jCurrentTimeMillis));
        }
    }

    public static void l() {
        SharedPreferences sharedPreferences;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (B0 == null) {
            sharedPreferences = AbstractC14047hG.a.getSharedPreferences("Notifications", 0);
            B0 = sharedPreferences.getString("OtherKey", "Other3");
        } else {
            sharedPreferences = null;
        }
        NotificationChannel notificationChannel = E0.getNotificationChannel(B0);
        if (notificationChannel != null && notificationChannel.getImportance() == 0) {
            E0.deleteNotificationChannel(B0);
            B0 = null;
            notificationChannel = null;
        }
        if (B0 == null) {
            if (sharedPreferences == null) {
                sharedPreferences = AbstractC14047hG.a.getSharedPreferences("Notifications", 0);
            }
            B0 = "Other" + Utilities.b.nextLong();
            sharedPreferences.edit().putString("OtherKey", B0).commit();
        }
        if (notificationChannel == null) {
            EE4.a();
            NotificationChannel notificationChannelA = ZC4.a(B0, "Internal notifications", 3);
            notificationChannelA.enableLights(false);
            notificationChannelA.enableVibration(false);
            notificationChannelA.setSound(null, null);
            try {
                E0.createNotificationChannel(notificationChannelA);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = 0;
        boolean z = false;
        while (i < this.o.size()) {
            b bVar = (b) this.o.get(i);
            Iterator it = bVar.c.entrySet().iterator();
            while (it.hasNext()) {
                if (jCurrentTimeMillis >= ((Long) ((Pair) ((Map.Entry) it.next()).getValue()).second).longValue()) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                if (bVar.c.isEmpty()) {
                    d().A(bVar.a);
                    this.o.remove(i);
                    i--;
                } else {
                    d().b0(bVar);
                }
            }
            i++;
        }
        if (z) {
            C(false);
        }
        D();
    }

    public static String n(int i) {
        return i == 0 ? "EnableGroup2" : i == 1 ? "EnableAll2" : "EnableChannel2";
    }

    public static F o(int i) {
        F f = G0[i];
        if (f == null) {
            synchronized (H0[i]) {
                try {
                    f = G0[i];
                    if (f == null) {
                        F[] fArr = G0;
                        F f2 = new F(i);
                        fArr[i] = f2;
                        f = f2;
                    }
                } finally {
                }
            }
        }
        return f;
    }

    private int p(SharedPreferences sharedPreferences, long j, int i) {
        int iB = this.Z.b("notify2_", j, i, -1);
        if (iB != 3 || this.Z.b("notifyuntil_", j, i, 0) < b().j()) {
            return iB;
        }
        return 2;
    }

    public static String q(long j, int i) {
        long j2 = (i << 12) + j;
        C21892uJ3 c21892uJ3 = I0;
        int iH = c21892uJ3.h(j2);
        if (iH >= 0) {
            return (String) c21892uJ3.p(iH);
        }
        String strValueOf = i != 0 ? String.format(Locale.US, "%d_%d", Long.valueOf(j), Integer.valueOf(i)) : String.valueOf(j);
        c21892uJ3.l(j2, strValueOf);
        return strValueOf;
    }

    private int r() {
        int i;
        int iK;
        Exception e;
        if (!C22477vI7.j(0).k()) {
            return 0;
        }
        F fO = o(0);
        if (!fO.y) {
            return 0;
        }
        if (!fO.A) {
            if (!fO.z) {
                return fO.h.o();
            }
            try {
                int size = C.n(0).g.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        AbstractC17515n57 abstractC17515n57 = (AbstractC17515n57) C.n(0).g.get(i2);
                        if ((!ZO1.b(abstractC17515n57.p) || !AbstractC13547gQ0.i(c().i(Long.valueOf(-abstractC17515n57.p)))) && C.n(0).k(abstractC17515n57) != 0) {
                            i++;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        AbstractC6403Nl2.e(e, false);
                        return i;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                i = 0;
            }
            return i;
        }
        if (!fO.z) {
            return fO.t;
        }
        try {
            ArrayList arrayList = new ArrayList(C.n(0).g);
            int size2 = arrayList.size();
            iK = 0;
            for (int i3 = 0; i3 < size2; i3++) {
                try {
                    AbstractC17515n57 abstractC17515n572 = (AbstractC17515n57) arrayList.get(i3);
                    if ((abstractC17515n572 == null || !ZO1.b(abstractC17515n572.p) || !AbstractC13547gQ0.i(c().i(Long.valueOf(-abstractC17515n572.p)))) && abstractC17515n572 != null) {
                        iK += C.n(0).k(abstractC17515n572);
                    }
                } catch (Exception e4) {
                    e = e4;
                    AbstractC6403Nl2.d(e);
                    return iK;
                }
            }
        } catch (Exception e5) {
            iK = 0;
            e = e5;
        }
        return iK;
    }

    private boolean w(C10743c74 c10743c74) {
        M57 m57;
        L57 l57 = c10743c74.e;
        Z57 z57 = l57.d;
        return z57 != null && z57.c == 0 && z57.d == 0 && ((m57 = l57.f) == null || (m57 instanceof C6564Oa7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.a("delay reached");
        }
        if (!this.d.isEmpty()) {
            C(true);
            this.d.clear();
        }
        try {
            if (this.D.isHeld()) {
                this.D.release();
            }
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(int i) {
        if (this.t == 0) {
            this.l.clear();
            E.j().s(E.E2, new Object[0]);
        }
        E.j().s(E.i3, Integer.valueOf(this.a));
        e().s(E.R1, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(ArrayList arrayList, C21892uJ3 c21892uJ3, ArrayList arrayList2, Collection collection) {
        boolean zU;
        P57 p57;
        this.h.c();
        this.c.clear();
        this.e.c();
        this.o.clear();
        this.p.c();
        this.t = 0;
        this.u = 0;
        SharedPreferences sharedPreferencesG = a().g();
        C21892uJ3 c21892uJ32 = new C21892uJ3();
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                L57 l57 = (L57) arrayList.get(i);
                if (l57 != null && ((p57 = l57.A) == null || !p57.c)) {
                    M57 m57 = l57.f;
                    if (!(m57 instanceof C15445jb7) && (!l57.u || (!(m57 instanceof C5837La7) && !(m57 instanceof C20189rb7)))) {
                        long j = l57.d.d;
                        SparseArray sparseArray = (SparseArray) this.e.f(j != 0 ? -j : 0L);
                        if (sparseArray == null || sparseArray.indexOfKey(l57.b) < 0) {
                            C10743c74 c10743c74 = new C10743c74(this.a, l57, false, false);
                            if (w(c10743c74)) {
                                this.u++;
                            }
                            long jF = c10743c74.F();
                            if (c10743c74.e.j) {
                                jF = c10743c74.P();
                            }
                            c21892uJ32.h(jF);
                        }
                    }
                }
            }
        }
        for (int i2 = 0; i2 < c21892uJ3.o(); i2++) {
            long jK = c21892uJ3.k(i2);
            int iH = c21892uJ32.h(jK);
            if (iH >= 0) {
                zU = ((Boolean) c21892uJ32.p(iH)).booleanValue();
            } else {
                int iP = p(sharedPreferencesG, jK, 0);
                zU = iP == -1 ? u(jK) : iP != 2;
                c21892uJ32.l(jK, Boolean.valueOf(zU));
            }
            if (zU) {
                Integer num = (Integer) c21892uJ3.p(i2);
                int iIntValue = num.intValue();
                this.h.l(jK, num);
                this.t += iIntValue;
            }
        }
        if (arrayList2 != null) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                C10743c74 c10743c742 = (C10743c74) arrayList2.get(i3);
                if (this.e.h(c10743c742.T()) < 0) {
                    if (w(c10743c742)) {
                        this.u++;
                    }
                    long jF2 = c10743c742.F();
                    L57 l572 = c10743c742.e;
                    long j2 = l572.O;
                    if (l572.j) {
                        jF2 = c10743c742.P();
                    }
                    c21892uJ32.h(jF2);
                }
            }
        }
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                long j3 = bVar.a;
                b bVar2 = (b) this.p.f(j3);
                if (bVar2 != null) {
                    bVar2.c.putAll(bVar.c);
                } else {
                    this.o.add(bVar);
                    this.p.l(j3, bVar);
                }
            }
            new a();
        }
        final int iO = this.h.o();
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.SE4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y(iO);
            }
        });
        C(SystemClock.elapsedRealtime() / 1000 < 60);
        if (this.y) {
            B(r());
        }
    }

    public void A(final C21892uJ3 c21892uJ3, final ArrayList arrayList, final ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, final Collection collection) {
        c().B(arrayList3, true);
        c().A(arrayList4, true);
        C0.i(new Runnable() { // from class: ir.nasim.RE4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z(arrayList, c21892uJ3, arrayList2, collection);
            }
        });
    }

    public boolean s(int i) {
        return i == 3 ? a().g().getBoolean("EnableAllStories", true) : a().g().getInt(n(i), 0) < b().j();
    }

    public boolean u(long j) {
        return v(j, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean v(long r3, java.lang.Boolean r5) {
        /*
            r2 = this;
            boolean r0 = ir.nasim.ZO1.b(r3)
            if (r0 == 0) goto L2a
            r0 = 0
            r1 = 2
            if (r5 == 0) goto L12
            boolean r3 = r5.booleanValue()
            if (r3 == 0) goto L2b
        L10:
            r0 = r1
            goto L2b
        L12:
            ir.nasim.tgwidgets.editor.messenger.C r5 = r2.c()
            long r3 = -r3
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            ir.nasim.k57 r3 = r5.i(r3)
            boolean r4 = ir.nasim.AbstractC13547gQ0.e(r3)
            if (r4 == 0) goto L2b
            boolean r3 = r3.q
            if (r3 != 0) goto L2b
            goto L10
        L2a:
            r0 = 1
        L2b:
            boolean r3 = r2.s(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.F.v(long, java.lang.Boolean):boolean");
    }
}
