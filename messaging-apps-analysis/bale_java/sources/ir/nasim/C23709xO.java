package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import ir.nasim.AbstractC18874pP;
import ir.nasim.AbstractC20029rM;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.features.audioplayer.service.MusicService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.xO, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23709xO implements InterfaceC16501lO {
    public static final C23709xO a;
    private static final PackageManager b;
    private static final C9327Zl4 c;
    private static MediaControllerCompat.e d;
    private static com.google.android.exoplayer2.audio.a e;
    private static boolean f;
    private static InterfaceC2037k g;
    private static TelephonyManager h;
    private static final C13585gU2 i;
    private static VL j;
    private static AbstractC18874pP k;
    private static final List l;
    private static DB6 m;
    private static final InterfaceC9173Yu3 n;
    private static final InterfaceC9173Yu3 o;
    private static final Handler p;
    private static Runnable q;
    private static boolean r;
    private static final QG4 s;
    private static InterfaceC13730gj3 t;
    public static final int u;

    /* renamed from: ir.nasim.xO$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[DB6.values().length];
            try {
                iArr[DB6.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DB6.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DB6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC21241tM.values().length];
            try {
                iArr2[EnumC21241tM.d.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC21241tM.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC21241tM.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC21241tM.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.xO$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC2037k c;
        final /* synthetic */ AppCompatActivity d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC2037k interfaceC2037k, AppCompatActivity appCompatActivity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC2037k;
            this.d = appCompatActivity;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                T37 t37X = C23709xO.a.X();
                InterfaceC2037k interfaceC2037k = this.c;
                AppCompatActivity appCompatActivity = this.d;
                this.b = 1;
                if (t37X.n(interfaceC2037k, appCompatActivity, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.xO$c */
    static final class c implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        c(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* renamed from: ir.nasim.xO$d */
    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VL vl = C23709xO.j;
            if (vl != null) {
                Iterator it = C23709xO.l.iterator();
                while (it.hasNext()) {
                    ((AbstractC17683nO) it.next()).h(vl, C23709xO.a.O());
                }
            }
            C23709xO.a.T().postDelayed(this, 250L);
        }
    }

    static {
        C23709xO c23709xO = new C23709xO();
        a = c23709xO;
        C5721Ko c5721Ko = C5721Ko.a;
        PackageManager packageManager = c5721Ko.d().getPackageManager();
        b = packageManager;
        c = new C9327Zl4(c5721Ko.d());
        com.google.android.exoplayer2.audio.a aVarA = new a.e().c(2).f(1).a();
        AbstractC13042fc3.h(aVarA, "build(...)");
        e = aVarA;
        i = new C13585gU2();
        k = new AbstractC18874pP.c();
        l = new ArrayList();
        m = DB6.b;
        n = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pO
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C23709xO.A();
            }
        });
        o = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qO
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C23709xO.w0();
            }
        });
        if (packageManager.hasSystemFeature("android.hardware.telephony")) {
            Object systemService = c5721Ko.d().getSystemService("phone");
            h = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        }
        k = c23709xO.W();
        p = new Handler();
        q = new d();
        s = new QG4() { // from class: ir.nasim.rO
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                C23709xO.G((MediaMetadataCompat) obj);
            }
        };
        u = 8;
    }

    private C23709xO() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC2037k A() {
        InterfaceC2037k interfaceC2037kI = new InterfaceC2037k.b(C5721Ko.a.d()).i();
        C2018a0 c2018a0E = C2018a0.e(RawResourceDataSource.buildRawResourceUri(AbstractC19954rD5.next_voice_audio_new));
        AbstractC13042fc3.h(c2018a0E, "fromUri(...)");
        interfaceC2037kI.W(c2018a0E);
        interfaceC2037kI.r();
        return interfaceC2037kI;
    }

    private final void B0(DB6 db6) {
        InterfaceC2037k interfaceC2037k = g;
        int iY = interfaceC2037k != null ? interfaceC2037k.y() : 0;
        int i2 = a.a[db6.ordinal()];
        if (i2 == 1) {
            InterfaceC2037k interfaceC2037k2 = g;
            if (interfaceC2037k2 != null) {
                interfaceC2037k2.Y(false);
            }
        } else if (i2 == 2) {
            InterfaceC2037k interfaceC2037k3 = g;
            if (interfaceC2037k3 != null) {
                interfaceC2037k3.q0(new ShuffleOrder.DefaultShuffleOrder(iY));
            }
            InterfaceC2037k interfaceC2037k4 = g;
            if (interfaceC2037k4 != null) {
                interfaceC2037k4.Y(true);
            }
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC2037k interfaceC2037k5 = g;
            if (interfaceC2037k5 != null) {
                interfaceC2037k5.q0(new D16(iY));
            }
            InterfaceC2037k interfaceC2037k6 = g;
            if (interfaceC2037k6 != null) {
                interfaceC2037k6.Y(true);
            }
        }
        Iterator it = l.iterator();
        while (it.hasNext()) {
            ((AbstractC17683nO) it.next()).i(db6);
        }
        C7183Qq.s().putInt("audio_player_shuffle_mode", db6.j());
    }

    private final void D(VL vl, boolean z, boolean z2, boolean z3, boolean z4) {
        VL vl2;
        for (AbstractC17683nO abstractC17683nO : l) {
            if (z && (vl2 = j) != null && !AbstractC13042fc3.d(vl2.c(), C18274oO.a.a())) {
                abstractC17683nO.c(vl2);
            }
            if (z2 && !AbstractC13042fc3.d(vl.c(), C18274oO.a.a())) {
                abstractC17683nO.g(vl);
            }
            if (z3) {
                abstractC17683nO.a(vl);
            }
        }
        if (z4) {
            j = vl;
        }
    }

    static /* synthetic */ void E(C23709xO c23709xO, VL vl, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        c23709xO.D(vl, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3, (i2 & 16) != 0 ? false : z4);
    }

    private final void F() {
        try {
            C9327Zl4 c9327Zl4 = c;
            if (c9327Zl4.f().d()) {
                return;
            }
            c9327Zl4.f().a();
        } catch (IllegalStateException e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            Log.d("MusicServiceConnection", message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(MediaMetadataCompat mediaMetadataCompat) {
        VL vlI = C13519gN.a.I(mediaMetadataCompat);
        if (vlI != null) {
            a0(a, vlI, false, 2, null);
        }
    }

    private final void I() {
        C5721Ko c5721Ko = C5721Ko.a;
        Context contextD = c5721Ko.d();
        Intent intent = new Intent(c5721Ko.d(), (Class<?>) MusicService.class);
        intent.putExtra("DISMISS_NOTIFICATION_COMMAND", true);
        contextD.startService(intent);
    }

    private final void J(VL vl) {
        VL vlR;
        VL vl2;
        String strC = vl.c();
        C18274oO c18274oO = C18274oO.a;
        if (!AbstractC13042fc3.d(strC, c18274oO.a())) {
            C13519gN c13519gN = C13519gN.a;
            if (c13519gN.M().size() <= 1) {
                return;
            }
            vlR = c13519gN.R();
            if (vlR != null) {
                c13519gN.D(vlR);
            }
            vl2 = j;
            if (vl2 == null && !AbstractC13042fc3.d(vl2, vlR) && AbstractC13042fc3.d(vl2.c(), c18274oO.a())) {
                C13519gN.a.e0(vl2);
                return;
            }
            return;
        }
        C13519gN.a.D(vl);
        vlR = null;
        vl2 = j;
        if (vl2 == null) {
        }
    }

    private final InterfaceC2037k L() {
        return (InterfaceC2037k) n.getValue();
    }

    private final int P() {
        int i2 = C7183Qq.s().getInt("audio_player_repeat_mode", 0);
        if (i2 == 0) {
            return 0;
        }
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2 && i2 != 3) {
                return 0;
            }
        }
        return i3;
    }

    private final DB6 S() {
        InterfaceC3570Bk5 interfaceC3570Bk5S = C7183Qq.s();
        DB6 db6 = DB6.b;
        int i2 = interfaceC3570Bk5S.getInt("audio_player_shuffle_mode", db6.j());
        if (i2 == db6.j()) {
            return db6;
        }
        DB6 db62 = DB6.c;
        if (i2 != db62.j()) {
            db62 = DB6.d;
            if (i2 != db62.j()) {
                return db6;
            }
        }
        return db62;
    }

    private final void U(QZ7 qz7) {
        InterfaceC2037k interfaceC2037k = g;
        Integer numValueOf = interfaceC2037k != null ? Integer.valueOf(interfaceC2037k.y()) : null;
        AbstractC13042fc3.f(numValueOf);
        int iIntValue = numValueOf.intValue();
        InterfaceC2037k interfaceC2037k2 = g;
        AbstractC13042fc3.f(interfaceC2037k2);
        if (iIntValue == interfaceC2037k2.A() + 1) {
            C13519gN.a.x(qz7);
        }
    }

    private final AbstractC18874pP W() {
        String strE = C7183Qq.s().e("AUDIO_SPEED");
        return AbstractC13042fc3.d(strE, String.valueOf(new AbstractC18874pP.c().a())) ? new AbstractC18874pP.c() : AbstractC13042fc3.d(strE, String.valueOf(new AbstractC18874pP.d().a())) ? new AbstractC18874pP.d() : AbstractC13042fc3.d(strE, String.valueOf(new AbstractC18874pP.b().a())) ? new AbstractC18874pP.b() : new AbstractC18874pP.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T37 X() {
        return (T37) o.getValue();
    }

    public static /* synthetic */ void a0(C23709xO c23709xO, VL vl, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        c23709xO.Z(vl, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b0(VL vl) {
        AbstractC13042fc3.i(vl, "$audio");
        C23709xO c23709xO = a;
        c23709xO.U((QZ7) vl);
        c23709xO.J(vl);
        E(c23709xO, vl, false, true, true, true, 2, null);
        return C19938rB7.a;
    }

    private final void f0(VL vl, final SA2 sa2) {
        C13519gN c13519gN = C13519gN.a;
        if (c13519gN.M().indexOf(vl) == AbstractC15401jX0.v0(c13519gN.M(), j) + 1) {
            InterfaceC2037k interfaceC2037k = g;
            Integer numValueOf = interfaceC2037k != null ? Integer.valueOf(interfaceC2037k.y()) : null;
            AbstractC13042fc3.f(numValueOf);
            int iIntValue = numValueOf.intValue();
            InterfaceC2037k interfaceC2037k2 = g;
            AbstractC13042fc3.f(interfaceC2037k2);
            int iA = interfaceC2037k2.A();
            if (iIntValue > 0 && iA > 0 && iA < iIntValue) {
                h();
                if (L().i()) {
                    L().h();
                }
                L().x(0L);
                L().q();
                AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.wO
                    @Override // java.lang.Runnable
                    public final void run() {
                        C23709xO.g0(sa2);
                    }
                }, 300L);
                return;
            }
            MediaControllerCompat.e eVar = d;
            if (eVar != null) {
                eVar.b();
            }
        }
        sa2.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$callback");
        MediaControllerCompat.e eVar = d;
        if (eVar != null) {
            eVar.b();
        }
        sa2.invoke();
    }

    private final void k0() {
        MediaControllerCompat.e eVar = d;
        if (eVar != null) {
            eVar.b();
        }
    }

    private final void l0() {
        C7183Qq.s().putString("AUDIO_SPEED", String.valueOf(k.a()));
    }

    private final void p(final AppCompatActivity appCompatActivity) {
        C9327Zl4 c9327Zl4 = c;
        c9327Zl4.e().k(s);
        c9327Zl4.j().j(appCompatActivity, new c(new UA2() { // from class: ir.nasim.uO
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C23709xO.z(appCompatActivity, (Boolean) obj);
            }
        }));
    }

    private final void r0() {
        if (r) {
            return;
        }
        r = true;
        C9327Zl4 c9327Zl4 = c;
        c9327Zl4.j().k(new c(new UA2() { // from class: ir.nasim.sO
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C23709xO.s0((Boolean) obj);
            }
        }));
        c9327Zl4.h().k(new c(new UA2() { // from class: ir.nasim.tO
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C23709xO.t0((Integer) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s0(Boolean bool) {
        d = bool.booleanValue() ? c.i() : null;
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t0(Integer num) {
        if (num != null && num.intValue() == 1) {
            VL vl = j;
            if (vl != null) {
                Iterator it = l.iterator();
                while (it.hasNext()) {
                    ((AbstractC17683nO) it.next()).c(vl);
                }
            }
            p.removeCallbacks(q);
        } else if (num != null && num.intValue() == 3) {
            VL vl2 = j;
            if (vl2 != null && !AbstractC13042fc3.d(vl2.c(), C18274oO.a.a())) {
                Iterator it2 = l.iterator();
                while (it2.hasNext()) {
                    ((AbstractC17683nO) it2.next()).g(vl2);
                }
            }
            Handler handler = p;
            handler.removeCallbacks(q);
            handler.postDelayed(q, 250L);
        } else if (num != null && num.intValue() == 2) {
            VL vl3 = j;
            if (vl3 != null) {
                for (AbstractC17683nO abstractC17683nO : l) {
                    if (AbstractC13042fc3.d(vl3.c(), C18274oO.a.a())) {
                        abstractC17683nO.d(vl3);
                    } else {
                        abstractC17683nO.f(vl3);
                    }
                }
            }
            p.removeCallbacks(q);
        }
        return C19938rB7.a;
    }

    private final void u0(MediaControllerCompat.e eVar, VL vl) {
        if (f) {
            if (vl instanceof QZ7) {
                f = false;
                eVar.f(0);
                o0(DB6.b);
                return;
            }
            return;
        }
        if (vl instanceof C8552Wl4) {
            f = true;
            eVar.f(P());
            o0(S());
        }
    }

    private final void v0() {
        MediaControllerCompat.e eVar = d;
        if (eVar != null) {
            eVar.e(k.a());
        }
        Iterator it = l.iterator();
        while (it.hasNext()) {
            ((AbstractC17683nO) it.next()).b(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final T37 w0() {
        return ((InterfaceC19086pl2) C92.a(C5721Ko.a.d(), InterfaceC19086pl2.class)).c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(AppCompatActivity appCompatActivity, Boolean bool) {
        AbstractC13042fc3.i(appCompatActivity, "$activity");
        InterfaceC2037k interfaceC2037k = g;
        if (interfaceC2037k == null) {
            InterfaceC13730gj3 interfaceC13730gj3 = t;
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            t = null;
            return C19938rB7.a;
        }
        if (!bool.booleanValue() || appCompatActivity.isDestroyed()) {
            InterfaceC13730gj3 interfaceC13730gj32 = t;
            if (interfaceC13730gj32 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj32, null, 1, null);
                t = null;
            }
        } else {
            InterfaceC13730gj3 interfaceC13730gj33 = t;
            if (interfaceC13730gj33 != null && interfaceC13730gj33.b()) {
                return C19938rB7.a;
            }
            t = AbstractC10533bm0.d(AbstractC19224pz3.a(appCompatActivity), null, null, new b(interfaceC2037k, appCompatActivity, null), 3, null);
        }
        return C19938rB7.a;
    }

    public final void A0() {
        TelephonyManager telephonyManager = h;
        if (telephonyManager == null || !(j instanceof QZ7)) {
            return;
        }
        try {
            if (C5505Jq.H()) {
                telephonyManager.listen(i, 0);
            }
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    public final void B(AppCompatActivity appCompatActivity) {
        AbstractC13042fc3.i(appCompatActivity, "activity");
        F();
        i0();
        p(appCompatActivity);
    }

    public final void C() {
        A0();
        InterfaceC2037k interfaceC2037k = g;
        if (interfaceC2037k != null && !interfaceC2037k.X()) {
            c.e().o(s);
        }
        InterfaceC13730gj3 interfaceC13730gj3 = t;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            t = null;
        }
    }

    public void H() {
        c.f().b();
    }

    public final AbstractC18874pP K() {
        return k;
    }

    public VL M() {
        return j;
    }

    public int N() {
        InterfaceC2037k interfaceC2037k = g;
        if (interfaceC2037k != null) {
            return interfaceC2037k.p();
        }
        return 1;
    }

    public long O() {
        InterfaceC2037k interfaceC2037k = g;
        if (interfaceC2037k != null) {
            return interfaceC2037k.D0();
        }
        return 0L;
    }

    public final DB6 Q() {
        return m;
    }

    public long R() {
        InterfaceC2037k interfaceC2037k = g;
        if (interfaceC2037k != null) {
            return interfaceC2037k.f();
        }
        return 0L;
    }

    public final Handler T() {
        return p;
    }

    public final InterfaceC2037k V() {
        return g;
    }

    public final void Y() {
        VL vl = j;
        if (vl != null && !AbstractC13042fc3.d(vl.c(), C18274oO.a.a())) {
            Iterator it = l.iterator();
            while (it.hasNext()) {
                ((AbstractC17683nO) it.next()).c(vl);
            }
        }
        j = null;
    }

    public final void Z(final VL vl, boolean z) {
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        if (!z) {
            T74 t74D = vl.d();
            VL vl2 = j;
            if (AbstractC13042fc3.d(t74D, vl2 != null ? vl2.d() : null)) {
                String strC = vl.c();
                VL vl3 = j;
                if (AbstractC13042fc3.d(strC, vl3 != null ? vl3.c() : null)) {
                    return;
                }
            }
        }
        if (AbstractC13042fc3.d(vl.c(), C18274oO.a.a())) {
            h();
        }
        if (vl instanceof QZ7) {
            E(this, vl, true, false, false, false, 28, null);
            f0(vl, new SA2() { // from class: ir.nasim.vO
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C23709xO.b0(vl);
                }
            });
        } else {
            J(vl);
            D(vl, true, true, true, true);
        }
    }

    public void c0(T74 t74) {
        AbstractC13042fc3.i(t74, "messageId");
        VL vl = j;
        if (AbstractC13042fc3.d(vl != null ? vl.d() : null, t74)) {
            InterfaceC16501lO.w(this, false, 1, null);
        }
    }

    public final void d0(C11458d25 c11458d25) {
        T74 t74D;
        AbstractC13042fc3.i(c11458d25, "peer");
        VL vl = j;
        if (AbstractC13042fc3.d(c11458d25, (vl == null || (t74D = vl.d()) == null) ? null : t74D.e())) {
            VL vl2 = j;
            if ((vl2 instanceof QZ7) && vl2 != null) {
                C23709xO c23709xO = a;
                AbstractC13042fc3.g(vl2, "null cannot be cast to non-null type ir.nasim.features.audioplayer.entity.Voice");
                c23709xO.U((QZ7) vl2);
            }
        }
    }

    public void e0(boolean z) {
        p.removeCallbacks(q);
        Iterator it = l.iterator();
        while (it.hasNext()) {
            ((AbstractC17683nO) it.next()).e();
        }
        C13519gN.a.z(z);
        if (z) {
            g = null;
        }
    }

    @Override // ir.nasim.InterfaceC16501lO
    public void h() {
        MediaControllerCompat.e eVar = d;
        if (eVar != null) {
            eVar.a();
        }
    }

    public final void h0(VL vl) {
        boolean zB0;
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        MediaControllerCompat.e eVar = d;
        if (eVar != null) {
            C13519gN c13519gN = C13519gN.a;
            if (c13519gN.c0(vl)) {
                a.s(true);
            }
            zB0 = c13519gN.b0(vl);
            c13519gN.p(vl);
            eVar.c(c13519gN.T(vl.d()), null);
            a.u0(eVar, vl);
        } else {
            zB0 = false;
        }
        if (vl instanceof C8552Wl4) {
            C13519gN.a.u(vl);
        } else if ((vl instanceof QZ7) && zB0) {
            C13519gN.a.x((QZ7) vl);
        }
    }

    @Override // ir.nasim.InterfaceC16501lO
    public boolean i() {
        InterfaceC2037k interfaceC2037k = g;
        if (interfaceC2037k != null) {
            return interfaceC2037k.i();
        }
        return false;
    }

    public final void i0() {
        TelephonyManager telephonyManager = h;
        if (telephonyManager != null && (j instanceof QZ7) && a.N() == 3) {
            try {
                if (C5505Jq.H()) {
                    telephonyManager.listen(i, 32);
                }
            } catch (Exception e2) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            }
        }
    }

    public final void j0() {
        v0();
    }

    @Override // ir.nasim.InterfaceC16501lO
    public void k(EnumC21241tM enumC21241tM) {
        AbstractC13042fc3.i(enumC21241tM, "speed");
        int i2 = a.b[enumC21241tM.ordinal()];
        if (i2 == 1) {
            t(new AbstractC18874pP.c());
            return;
        }
        if (i2 == 2) {
            t(new AbstractC18874pP.a());
        } else if (i2 == 3) {
            t(new AbstractC18874pP.b());
        } else {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            t(new AbstractC18874pP.d());
        }
    }

    @Override // ir.nasim.InterfaceC16501lO
    public T74 l() {
        VL vl = j;
        if (vl != null) {
            return vl.d();
        }
        return null;
    }

    public void m0(long j2) {
        MediaControllerCompat.e eVar = d;
        if (eVar != null) {
            eVar.d(j2);
        }
    }

    public void n0(long j2, T74 t74) {
        MediaControllerCompat.e eVar;
        VL vl = j;
        if (!AbstractC13042fc3.d(vl != null ? vl.d() : null, t74) || (eVar = d) == null) {
            return;
        }
        eVar.d(j2);
    }

    public final void o0(DB6 db6) {
        AbstractC13042fc3.i(db6, "value");
        m = db6;
        B0(db6);
    }

    public final void p0(InterfaceC2037k interfaceC2037k) {
        AbstractC13042fc3.i(interfaceC2037k, "exoPlayer");
        g = interfaceC2037k;
        r0();
    }

    @Override // ir.nasim.InterfaceC16501lO
    public void q() {
        MediaControllerCompat.e eVar = d;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void q0() {
        InterfaceC2037k interfaceC2037k = g;
        if (interfaceC2037k != null) {
            interfaceC2037k.S(e, true);
        }
    }

    @Override // ir.nasim.InterfaceC16501lO
    public void r(AbstractC20029rM abstractC20029rM) {
        AbstractC13042fc3.i(abstractC20029rM, "playbackState");
        if (AbstractC13042fc3.d(abstractC20029rM, AbstractC20029rM.b.c)) {
            h();
        } else {
            if (!AbstractC13042fc3.d(abstractC20029rM, AbstractC20029rM.a.c)) {
                throw new NoWhenBranchMatchedException();
            }
            q();
        }
    }

    @Override // ir.nasim.InterfaceC16501lO
    public void s(boolean z) {
        c.i().g();
        if (z) {
            I();
        }
        e0(false);
    }

    @Override // ir.nasim.InterfaceC16501lO
    public void t(AbstractC18874pP abstractC18874pP) {
        AbstractC13042fc3.i(abstractC18874pP, "speedMode");
        k = abstractC18874pP;
        v0();
        l0();
    }

    @Override // ir.nasim.InterfaceC16501lO
    public void u(AbstractC17683nO abstractC17683nO) {
        AbstractC13042fc3.i(abstractC17683nO, "audioPlayerCallback");
        List list = l;
        if (list.contains(abstractC17683nO)) {
            return;
        }
        list.add(abstractC17683nO);
    }

    @Override // ir.nasim.InterfaceC16501lO
    public void v(VL vl) {
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        if (AbstractC13042fc3.d(vl, j)) {
            h();
        }
    }

    @Override // ir.nasim.InterfaceC16501lO
    public boolean x(VL vl) {
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        return AbstractC13042fc3.d(vl, j) && i();
    }

    public void x0() {
        if (j != null) {
            C23709xO c23709xO = a;
            if (c23709xO.i()) {
                c23709xO.h();
            } else {
                c23709xO.k0();
            }
        }
    }

    @Override // ir.nasim.InterfaceC16501lO
    public void y(VL vl) {
        AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
        if (AbstractC13042fc3.d(vl, j)) {
            k0();
        } else {
            h0(vl);
        }
    }

    public final void y0() {
        AbstractC18874pP aVar;
        AbstractC18874pP abstractC18874pP = k;
        if (abstractC18874pP instanceof AbstractC18874pP.a) {
            aVar = new AbstractC18874pP.c();
        } else if (abstractC18874pP instanceof AbstractC18874pP.c) {
            aVar = new AbstractC18874pP.b();
        } else if (abstractC18874pP instanceof AbstractC18874pP.b) {
            aVar = new AbstractC18874pP.d();
        } else {
            if (!(abstractC18874pP instanceof AbstractC18874pP.d)) {
                throw new NoWhenBranchMatchedException();
            }
            aVar = new AbstractC18874pP.a();
        }
        t(aVar);
    }

    public void z0(AbstractC17683nO abstractC17683nO) {
        AbstractC13042fc3.i(abstractC17683nO, "audioPlayerCallback");
        l.remove(abstractC17683nO);
    }
}
