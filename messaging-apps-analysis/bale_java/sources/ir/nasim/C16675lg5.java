package ir.nasim;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import com.google.android.exoplayer2.z0;
import ir.nasim.AbstractC16407lD4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.lg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C16675lg5 {
    private static int N;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private boolean F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private boolean L;
    private String M;
    private final Context a;
    private final String b;
    private final int c;
    private final e d;
    private final g e;
    private final Handler f;
    private final AD4 g;
    private final IntentFilter h;
    private final z0.d i;
    private final f j;
    private final Map k;
    private final Map l;
    private final PendingIntent m;
    private final int n;
    private AbstractC16407lD4.e o;
    private List p;
    private com.google.android.exoplayer2.z0 q;
    private boolean r;
    private int s;
    private MediaSessionCompat.Token t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* renamed from: ir.nasim.lg5$b */
    public final class b {
        private final int a;

        private b(int i) {
            this.a = i;
        }
    }

    /* renamed from: ir.nasim.lg5$d */
    public interface d {
        Map a(Context context, int i);
    }

    /* renamed from: ir.nasim.lg5$e */
    public interface e {
        PendingIntent a(com.google.android.exoplayer2.z0 z0Var);

        CharSequence b(com.google.android.exoplayer2.z0 z0Var);

        CharSequence c(com.google.android.exoplayer2.z0 z0Var);

        default CharSequence d(com.google.android.exoplayer2.z0 z0Var) {
            return null;
        }

        Bitmap e(com.google.android.exoplayer2.z0 z0Var, b bVar);
    }

    /* renamed from: ir.nasim.lg5$f */
    private class f extends BroadcastReceiver {
        private f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.google.android.exoplayer2.z0 z0Var = C16675lg5.this.q;
            if (z0Var != null && C16675lg5.this.r && intent.getIntExtra("INSTANCE_ID", C16675lg5.this.n) == C16675lg5.this.n) {
                String action = intent.getAction();
                if ("com.google.android.exoplayer.play".equals(action)) {
                    if (z0Var.p() == 1 && z0Var.K(2)) {
                        z0Var.r();
                    } else if (z0Var.p() == 4 && z0Var.K(4)) {
                        z0Var.t();
                    }
                    if (z0Var.K(1)) {
                        z0Var.q();
                        return;
                    }
                    return;
                }
                if ("com.google.android.exoplayer.pause".equals(action)) {
                    if (z0Var.K(1)) {
                        z0Var.h();
                        return;
                    }
                    return;
                }
                if ("com.google.android.exoplayer.prev".equals(action)) {
                    if (z0Var.K(7)) {
                        z0Var.C();
                        return;
                    }
                    return;
                }
                if ("com.google.android.exoplayer.rewind".equals(action)) {
                    if (z0Var.K(11)) {
                        z0Var.y0();
                        return;
                    }
                    return;
                }
                if ("com.google.android.exoplayer.ffwd".equals(action)) {
                    if (z0Var.K(12)) {
                        z0Var.x0();
                        return;
                    }
                    return;
                }
                if ("com.google.android.exoplayer.next".equals(action)) {
                    if (z0Var.K(9)) {
                        z0Var.Q();
                    }
                } else {
                    if ("com.google.android.exoplayer.stop".equals(action)) {
                        if (z0Var.K(3)) {
                            z0Var.stop();
                        }
                        if (z0Var.K(20)) {
                            z0Var.m();
                            return;
                        }
                        return;
                    }
                    if ("com.google.android.exoplayer.dismiss".equals(action)) {
                        C16675lg5.this.A(true);
                    } else if (action != null) {
                        C16675lg5.g(C16675lg5.this);
                    }
                }
            }
        }
    }

    /* renamed from: ir.nasim.lg5$g */
    public interface g {
        void a(int i, Notification notification, boolean z);

        void b(int i, boolean z);
    }

    /* renamed from: ir.nasim.lg5$h */
    private class h implements z0.d {
        private h() {
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void M3(com.google.android.exoplayer2.z0 z0Var, z0.c cVar) {
            if (cVar.b(4, 5, 7, 0, 12, 11, 8, 9, 14)) {
                C16675lg5.this.p();
            }
        }
    }

    protected C16675lg5(Context context, String str, int i, e eVar, g gVar, d dVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str2) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = str;
        this.c = i;
        this.d = eVar;
        this.e = gVar;
        this.I = i2;
        this.M = str2;
        int i10 = N;
        N = i10 + 1;
        this.n = i10;
        this.f = AbstractC9683aN7.u(Looper.getMainLooper(), new Handler.Callback() { // from class: ir.nasim.kg5
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.n(message);
            }
        });
        this.g = AD4.e(applicationContext);
        this.i = new h();
        this.j = new f();
        this.h = new IntentFilter();
        this.u = true;
        this.v = true;
        this.C = true;
        this.y = true;
        this.z = true;
        this.F = true;
        this.L = true;
        this.H = 0;
        this.G = 0;
        this.K = -1;
        this.E = 1;
        this.J = 1;
        Map mapJ = j(applicationContext, i10, i3, i4, i5, i6, i7, i8, i9);
        this.k = mapJ;
        Iterator it = mapJ.keySet().iterator();
        while (it.hasNext()) {
            this.h.addAction((String) it.next());
        }
        Map mapA = dVar != null ? dVar.a(applicationContext, this.n) : Collections.emptyMap();
        this.l = mapA;
        Iterator it2 = mapA.keySet().iterator();
        while (it2.hasNext()) {
            this.h.addAction((String) it2.next());
        }
        this.m = h("com.google.android.exoplayer.dismiss", applicationContext, this.n);
        this.h.addAction("com.google.android.exoplayer.dismiss");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z) {
        if (this.r) {
            this.r = false;
            this.f.removeMessages(0);
            this.g.b(this.c);
            this.a.unregisterReceiver(this.j);
            g gVar = this.e;
            if (gVar != null) {
                gVar.b(this.c, z);
            }
        }
    }

    static /* synthetic */ d g(C16675lg5 c16675lg5) {
        c16675lg5.getClass();
        return null;
    }

    private static PendingIntent h(String str, Context context, int i) {
        Intent intent = new Intent(str).setPackage(context.getPackageName());
        intent.putExtra("INSTANCE_ID", i);
        return PendingIntent.getBroadcast(context, i, intent, AbstractC9683aN7.a >= 23 ? 201326592 : 134217728);
    }

    private static Map j(Context context, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        HashMap map = new HashMap();
        map.put("com.google.android.exoplayer.play", new AbstractC16407lD4.a(i2, context.getString(AbstractC20563sD5.exo_controls_play_description), h("com.google.android.exoplayer.play", context, i)));
        map.put("com.google.android.exoplayer.pause", new AbstractC16407lD4.a(i3, context.getString(AbstractC20563sD5.exo_controls_pause_description), h("com.google.android.exoplayer.pause", context, i)));
        map.put("com.google.android.exoplayer.stop", new AbstractC16407lD4.a(i4, context.getString(AbstractC20563sD5.exo_controls_stop_description), h("com.google.android.exoplayer.stop", context, i)));
        map.put("com.google.android.exoplayer.rewind", new AbstractC16407lD4.a(i5, context.getString(AbstractC20563sD5.exo_controls_rewind_description), h("com.google.android.exoplayer.rewind", context, i)));
        map.put("com.google.android.exoplayer.ffwd", new AbstractC16407lD4.a(i6, context.getString(AbstractC20563sD5.exo_controls_fastforward_description), h("com.google.android.exoplayer.ffwd", context, i)));
        map.put("com.google.android.exoplayer.prev", new AbstractC16407lD4.a(i7, context.getString(AbstractC20563sD5.exo_controls_previous_description), h("com.google.android.exoplayer.prev", context, i)));
        map.put("com.google.android.exoplayer.next", new AbstractC16407lD4.a(i8, context.getString(AbstractC20563sD5.exo_controls_next_description), h("com.google.android.exoplayer.next", context, i)));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(Message message) {
        int i = message.what;
        if (i == 0) {
            com.google.android.exoplayer2.z0 z0Var = this.q;
            if (z0Var != null) {
                z(z0Var, null);
            }
        } else {
            if (i != 1) {
                return false;
            }
            com.google.android.exoplayer2.z0 z0Var2 = this.q;
            if (z0Var2 != null && this.r && this.s == message.arg1) {
                z(z0Var2, (Bitmap) message.obj);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f.hasMessages(0)) {
            return;
        }
        this.f.sendEmptyMessage(0);
    }

    private static void s(AbstractC16407lD4.e eVar, Bitmap bitmap) {
        eVar.z(bitmap);
    }

    private boolean y(com.google.android.exoplayer2.z0 z0Var) {
        return (z0Var.p() == 4 || z0Var.p() == 1 || !z0Var.X()) ? false : true;
    }

    private void z(com.google.android.exoplayer2.z0 z0Var, Bitmap bitmap) {
        boolean zM = m(z0Var);
        AbstractC16407lD4.e eVarI = i(z0Var, this.o, zM, bitmap);
        this.o = eVarI;
        if (eVarI == null) {
            A(false);
            return;
        }
        Notification notificationC = eVarI.c();
        this.g.g(this.c, notificationC);
        if (!this.r) {
            AbstractC9683aN7.L0(this.a, this.j, this.h);
        }
        g gVar = this.e;
        if (gVar != null) {
            gVar.a(this.c, notificationC, zM || !this.r);
        }
        this.r = true;
    }

    protected AbstractC16407lD4.e i(com.google.android.exoplayer2.z0 z0Var, AbstractC16407lD4.e eVar, boolean z, Bitmap bitmap) {
        if (z0Var.p() == 1 && z0Var.K(17) && z0Var.N().v()) {
            this.p = null;
            return null;
        }
        List listL = l(z0Var);
        ArrayList arrayList = new ArrayList(listL.size());
        for (int i = 0; i < listL.size(); i++) {
            String str = (String) listL.get(i);
            AbstractC16407lD4.a aVar = this.k.containsKey(str) ? (AbstractC16407lD4.a) this.k.get(str) : (AbstractC16407lD4.a) this.l.get(str);
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        if (eVar == null || !arrayList.equals(this.p)) {
            eVar = new AbstractC16407lD4.e(this.a, this.b);
            this.p = arrayList;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                eVar.b((AbstractC16407lD4.a) arrayList.get(i2));
            }
        }
        C18771pD4 c18771pD4 = new C18771pD4();
        MediaSessionCompat.Token token = this.t;
        if (token != null) {
            c18771pD4.o(token);
        }
        c18771pD4.p(k(listL, z0Var));
        c18771pD4.q(!z);
        c18771pD4.n(this.m);
        eVar.M(c18771pD4);
        eVar.s(this.m);
        eVar.g(this.E).D(z).j(this.H).k(this.F).K(this.I).R(this.J).F(this.K).r(this.G);
        if (AbstractC9683aN7.a >= 21 && this.L && z0Var.K(16) && z0Var.i() && !z0Var.k() && !z0Var.L() && z0Var.c().a == 1.0f) {
            eVar.S(System.currentTimeMillis() - z0Var.l0()).I(true).P(true);
        } else {
            eVar.I(false).P(false);
        }
        eVar.n(this.d.b(z0Var));
        eVar.m(this.d.c(z0Var));
        eVar.N(this.d.d(z0Var));
        if (bitmap == null) {
            e eVar2 = this.d;
            int i3 = this.s + 1;
            this.s = i3;
            bitmap = eVar2.e(z0Var, new b(i3));
        }
        s(eVar, bitmap);
        eVar.l(this.d.a(z0Var));
        String str2 = this.M;
        if (str2 != null) {
            eVar.w(str2);
        }
        eVar.E(true);
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int[] k(java.util.List r7, com.google.android.exoplayer2.z0 r8) {
        /*
            r6 = this;
            java.lang.String r0 = "com.google.android.exoplayer.pause"
            int r0 = r7.indexOf(r0)
            java.lang.String r1 = "com.google.android.exoplayer.play"
            int r1 = r7.indexOf(r1)
            boolean r2 = r6.w
            r3 = -1
            if (r2 == 0) goto L18
            java.lang.String r2 = "com.google.android.exoplayer.prev"
            int r2 = r7.indexOf(r2)
            goto L24
        L18:
            boolean r2 = r6.A
            if (r2 == 0) goto L23
            java.lang.String r2 = "com.google.android.exoplayer.rewind"
            int r2 = r7.indexOf(r2)
            goto L24
        L23:
            r2 = r3
        L24:
            boolean r4 = r6.x
            if (r4 == 0) goto L2f
            java.lang.String r4 = "com.google.android.exoplayer.next"
            int r7 = r7.indexOf(r4)
            goto L3b
        L2f:
            boolean r4 = r6.B
            if (r4 == 0) goto L3a
            java.lang.String r4 = "com.google.android.exoplayer.ffwd"
            int r7 = r7.indexOf(r4)
            goto L3b
        L3a:
            r7 = r3
        L3b:
            r4 = 3
            int[] r4 = new int[r4]
            r5 = 0
            if (r2 == r3) goto L44
            r4[r5] = r2
            r5 = 1
        L44:
            boolean r8 = r6.y(r8)
            if (r0 == r3) goto L52
            if (r8 == 0) goto L52
            int r8 = r5 + 1
            r4[r5] = r0
        L50:
            r5 = r8
            goto L5b
        L52:
            if (r1 == r3) goto L5b
            if (r8 != 0) goto L5b
            int r8 = r5 + 1
            r4[r5] = r1
            goto L50
        L5b:
            if (r7 == r3) goto L62
            int r8 = r5 + 1
            r4[r5] = r7
            r5 = r8
        L62:
            int[] r7 = java.util.Arrays.copyOf(r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16675lg5.k(java.util.List, com.google.android.exoplayer2.z0):int[]");
    }

    protected List l(com.google.android.exoplayer2.z0 z0Var) {
        boolean zK = z0Var.K(7);
        boolean zK2 = z0Var.K(11);
        boolean zK3 = z0Var.K(12);
        boolean zK4 = z0Var.K(9);
        ArrayList arrayList = new ArrayList();
        if (this.u && zK) {
            arrayList.add("com.google.android.exoplayer.prev");
        }
        if (this.y && zK2) {
            arrayList.add("com.google.android.exoplayer.rewind");
        }
        if (this.C) {
            if (y(z0Var)) {
                arrayList.add("com.google.android.exoplayer.pause");
            } else {
                arrayList.add("com.google.android.exoplayer.play");
            }
        }
        if (this.z && zK3) {
            arrayList.add("com.google.android.exoplayer.ffwd");
        }
        if (this.v && zK4) {
            arrayList.add("com.google.android.exoplayer.next");
        }
        if (this.D) {
            arrayList.add("com.google.android.exoplayer.stop");
        }
        return arrayList;
    }

    protected boolean m(com.google.android.exoplayer2.z0 z0Var) {
        int iP = z0Var.p();
        return (iP == 2 || iP == 3) && z0Var.X();
    }

    public final void o() {
        if (this.r) {
            p();
        }
    }

    public final void q(int i) {
        if (this.H != i) {
            this.H = i;
            o();
        }
    }

    public final void r(boolean z) {
        if (this.F != z) {
            this.F = z;
            o();
        }
    }

    public final void t(MediaSessionCompat.Token token) {
        if (AbstractC9683aN7.c(this.t, token)) {
            return;
        }
        this.t = token;
        o();
    }

    public final void u(com.google.android.exoplayer2.z0 z0Var) {
        boolean z = true;
        AbstractC20011rK.g(Looper.myLooper() == Looper.getMainLooper());
        if (z0Var != null && z0Var.O() != Looper.getMainLooper()) {
            z = false;
        }
        AbstractC20011rK.a(z);
        com.google.android.exoplayer2.z0 z0Var2 = this.q;
        if (z0Var2 == z0Var) {
            return;
        }
        if (z0Var2 != null) {
            z0Var2.o(this.i);
            if (z0Var == null) {
                A(false);
            }
        }
        this.q = z0Var;
        if (z0Var != null) {
            z0Var.m0(this.i);
            p();
        }
    }

    public final void v(int i) {
        if (this.I != i) {
            this.I = i;
            o();
        }
    }

    public final void w(boolean z) {
        if (this.L != z) {
            this.L = z;
            o();
        }
    }

    public final void x(boolean z) {
        if (this.D == z) {
            return;
        }
        this.D = z;
        o();
    }

    /* renamed from: ir.nasim.lg5$c */
    public static class c {
        protected final Context a;
        protected final int b;
        protected final String c;
        protected g d;
        protected e e;
        protected int f;
        protected int g;
        protected int h;
        protected int i;
        protected int j;
        protected int k;
        protected int l;
        protected int m;
        protected int n;
        protected int o;
        protected int p;
        protected String q;

        public c(Context context, int i, String str, e eVar) {
            this(context, i, str);
            this.e = eVar;
        }

        public C16675lg5 a() {
            int i = this.f;
            if (i != 0) {
                FE4.a(this.a, this.c, i, this.g, this.h);
            }
            return new C16675lg5(this.a, this.c, this.b, this.e, this.d, null, this.i, this.k, this.l, this.m, this.j, this.n, this.o, this.p, this.q);
        }

        public c b(int i) {
            this.g = i;
            return this;
        }

        public c c(int i) {
            this.f = i;
            return this;
        }

        public c d(g gVar) {
            this.d = gVar;
            return this;
        }

        public c(Context context, int i, String str) {
            AbstractC20011rK.a(i > 0);
            this.a = context;
            this.b = i;
            this.c = str;
            this.h = 2;
            this.e = new C19368qE1(null);
            this.i = FB5.exo_notification_small_icon;
            this.k = FB5.exo_notification_play;
            this.l = FB5.exo_notification_pause;
            this.m = FB5.exo_notification_stop;
            this.j = FB5.exo_notification_rewind;
            this.n = FB5.exo_notification_fastforward;
            this.o = FB5.exo_notification_previous;
            this.p = FB5.exo_notification_next;
        }
    }
}
