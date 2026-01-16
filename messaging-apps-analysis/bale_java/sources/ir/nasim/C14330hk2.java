package ir.nasim;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14330hk2;
import ir.nasim.C15225jD4;
import ir.nasim.C21051t17;
import ir.nasim.C6622Oh2;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.jaryan.search.ui.fragment.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.hk2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14330hk2 extends HW2 implements C15225jD4.b {
    private C13628gZ0 A1;
    private InterfaceC13730gj3 B1;
    private long C1;
    private final InterfaceC8506Wg3 h1;
    private final InterfaceC10358bW7 i1;
    public InterfaceC24908zP5 j1;
    public InterfaceC6762Ow2 k1;
    public C15629ju1 l1;
    private final InterfaceC9173Yu3 m1;
    private EnumC14332b n1;
    private int o1;
    private C15372jT7 p1;
    private final InterfaceC9173Yu3 q1;
    private int r1;
    private int s1;
    private C6119Mg2 t1;
    private androidx.recyclerview.widget.f u1;
    private LinearLayoutManager v1;
    private C16731lm1 w1;
    private final SX7 x1;
    private boolean y1;
    private final InterfaceC9173Yu3 z1;
    static final /* synthetic */ InterfaceC5239Im3[] E1 = {AbstractC10882cM5.i(new C25226zw5(C14330hk2.class, "binding", "getBinding()Lir/nasim/jaryan/databinding/FragmentFeedsBinding;", 0))};
    public static final C14331a D1 = new C14331a(null);
    public static final int F1 = 8;

    /* renamed from: ir.nasim.hk2$A */
    /* synthetic */ class A extends EB2 implements InterfaceC14603iB2 {
        A(Object obj) {
            super(2, obj, C5679Kj2.class, "sendPostDurationEventSimple", "sendPostDurationEventSimple(ILir/nasim/jaryan/feed/model/network/Feed;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y(((Number) obj).intValue(), (C5886Lg2) obj2);
            return C19938rB7.a;
        }

        public final void y(int i, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "p1");
            ((C5679Kj2) this.receiver).g2(i, c5886Lg2);
        }
    }

    /* renamed from: ir.nasim.hk2$B */
    static final class B extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Context d;
        final /* synthetic */ C14330hk2 e;

        /* renamed from: ir.nasim.hk2$B$a */
        public static final class a extends ContentObserver {
            final /* synthetic */ AudioManager a;
            final /* synthetic */ C11637dL5 b;
            final /* synthetic */ C14330hk2 c;
            final /* synthetic */ InterfaceC16204ks5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Handler handler, AudioManager audioManager, C11637dL5 c11637dL5, C14330hk2 c14330hk2, InterfaceC16204ks5 interfaceC16204ks5) {
                super(handler);
                this.a = audioManager;
                this.b = c11637dL5;
                this.c = c14330hk2;
                this.d = interfaceC16204ks5;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                Boolean boolValueOf;
                Fragment fragmentU5;
                FragmentManager fragmentManagerV5;
                List listC0;
                super.onChange(z);
                int streamVolume = this.a.getStreamVolume(3);
                if (streamVolume > this.b.a) {
                    Fragment fragmentU52 = this.c.U5();
                    if (fragmentU52 == null || (fragmentU5 = fragmentU52.U5()) == null || (fragmentManagerV5 = fragmentU5.V5()) == null || (listC0 = fragmentManagerV5.C0()) == null) {
                        boolValueOf = null;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : listC0) {
                            if (obj instanceof MW6) {
                                arrayList.add(obj);
                            }
                        }
                        boolValueOf = Boolean.valueOf(!arrayList.isEmpty());
                    }
                    if (!AbstractC13042fc3.d(boolValueOf, Boolean.TRUE)) {
                        this.b.a = streamVolume;
                        GJ0.i(this.d.h(Integer.valueOf(streamVolume)));
                        return;
                    }
                }
                C11637dL5 c11637dL5 = this.b;
                if (streamVolume < c11637dL5.a) {
                    c11637dL5.a = streamVolume;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        B(Context context, C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = context;
            this.e = c14330hk2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(Context context, a aVar) {
            context.getContentResolver().unregisterContentObserver(aVar);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            B b = new B(this.d, this.e, interfaceC20295rm1);
            b.c = obj;
            return b;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                final Context applicationContext = this.d.getApplicationContext();
                Object systemService = applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                AudioManager audioManager = (AudioManager) systemService;
                Handler handler = new Handler(applicationContext.getMainLooper());
                C11637dL5 c11637dL5 = new C11637dL5();
                c11637dL5.a = audioManager.getStreamVolume(3);
                final a aVar = new a(handler, audioManager, c11637dL5, this.e, interfaceC16204ks5);
                applicationContext.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, aVar);
                SA2 sa2 = new SA2() { // from class: ir.nasim.rk2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C14330hk2.B.y(applicationContext, aVar);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((B) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$a, reason: case insensitive filesystem */
    public static final class C14331a {
        private C14331a() {
        }

        public final C14330hk2 a(InterfaceC8506Wg3 interfaceC8506Wg3) {
            AbstractC13042fc3.i(interfaceC8506Wg3, "jaryanScrollListener");
            return new C14330hk2(interfaceC8506Wg3);
        }

        public /* synthetic */ C14331a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.hk2$b, reason: case insensitive filesystem */
    public static final class EnumC14332b {
        public static final EnumC14332b a = new EnumC14332b("MUTE", 0);
        public static final EnumC14332b b = new EnumC14332b("UN_MUTE", 1);
        private static final /* synthetic */ EnumC14332b[] c;
        private static final /* synthetic */ F92 d;

        static {
            EnumC14332b[] enumC14332bArrA = a();
            c = enumC14332bArrA;
            d = G92.a(enumC14332bArrA);
        }

        private EnumC14332b(String str, int i) {
        }

        private static final /* synthetic */ EnumC14332b[] a() {
            return new EnumC14332b[]{a, b};
        }

        public static EnumC14332b valueOf(String str) {
            return (EnumC14332b) Enum.valueOf(EnumC14332b.class, str);
        }

        public static EnumC14332b[] values() {
            return (EnumC14332b[]) c.clone();
        }
    }

    /* renamed from: ir.nasim.hk2$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ ComposeView b;

        c(ComposeView composeView) {
            this.b = composeView;
        }

        private static final List d(InterfaceC9664aL6 interfaceC9664aL6) {
            return (List) interfaceC9664aL6.getValue();
        }

        private static final int f(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Number) interfaceC9664aL6.getValue()).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(C14330hk2 c14330hk2, List list, InterfaceC9664aL6 interfaceC9664aL6, int i) {
            View viewO6;
            View viewO62;
            AbstractC13042fc3.i(c14330hk2, "this$0");
            AbstractC13042fc3.i(list, "$categoryList");
            AbstractC13042fc3.i(interfaceC9664aL6, "$selectedIndex$delegate");
            if (f(interfaceC9664aL6) != i) {
                C5679Kj2 c5679Kj2Ya = c14330hk2.Ya();
                C6119Mg2 c6119Mg2 = c14330hk2.t1;
                TabLayout tabLayout = null;
                if (c6119Mg2 == null) {
                    AbstractC13042fc3.y("feedAdapter");
                    c6119Mg2 = null;
                }
                c5679Kj2Ya.q1(c6119Mg2);
                c14330hk2.Ya().p1(i);
                c14330hk2.Ya().k2(((C9046Yg2) list.get(i)).a());
                c14330hk2.Ya().d2(DH0.b.j());
                Fragment fragmentU5 = c14330hk2.U5();
                AppBarLayout appBarLayout = (fragmentU5 == null || (viewO62 = fragmentU5.o6()) == null) ? null : (AppBarLayout) viewO62.findViewById(AbstractC12808fC5.story_appbar);
                Fragment fragmentU52 = c14330hk2.U5();
                if (fragmentU52 != null && (viewO6 = fragmentU52.o6()) != null) {
                    tabLayout = (TabLayout) viewO6.findViewById(AbstractC12808fC5.jaryan_tab_layout);
                }
                c14330hk2.wb((appBarLayout == null || AbstractC14828iY7.i(appBarLayout) || tabLayout == null || AbstractC14828iY7.i(tabLayout)) ? false : true);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C14330hk2 c14330hk2) {
            AbstractC13042fc3.i(c14330hk2, "this$0");
            c14330hk2.Ya().d2(DH0.c.j());
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6A = AbstractC10222bH6.a(C14330hk2.this.Ya().x1(), AbstractC10360bX0.m(), null, interfaceC22053ub1, 48, 2);
            if (!d(interfaceC9664aL6A).isEmpty()) {
                String string = C14330hk2.this.S7().getString(ID5.all_dialog_tab_type_title);
                AbstractC13042fc3.h(string, "getString(...)");
                List listE = AbstractC9766aX0.e(new C9046Yg2(0, string, "All"));
                List listD = d(interfaceC9664aL6A);
                ArrayList arrayList = new ArrayList();
                for (Object obj : listD) {
                    if (!AbstractC20762sZ6.n0(((C9046Yg2) obj).c())) {
                        arrayList.add(obj);
                    }
                }
                final List listR0 = AbstractC15401jX0.R0(listE, arrayList);
                this.b.setVisibility(0);
                final InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(C14330hk2.this.Ya().F1(), null, interfaceC22053ub1, 0, 1);
                int iF = f(interfaceC9664aL6B);
                interfaceC22053ub1.W(-816197095);
                boolean zV = interfaceC22053ub1.V(interfaceC9664aL6B) | interfaceC22053ub1.D(C14330hk2.this) | interfaceC22053ub1.D(listR0);
                final C14330hk2 c14330hk2 = C14330hk2.this;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.ik2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return C14330hk2.c.h(c14330hk2, listR0, interfaceC9664aL6B, ((Integer) obj2).intValue());
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-816163454);
                boolean zD = interfaceC22053ub1.D(C14330hk2.this);
                final C14330hk2 c14330hk22 = C14330hk2.this;
                Object objB2 = interfaceC22053ub1.B();
                if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.jk2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C14330hk2.c.i(c14330hk22);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC13709gh2.g(null, listR0, ua2, iF, (SA2) objB2, interfaceC22053ub1, 0, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hk2$d */
    public static final class d implements InterfaceC13138fj2 {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 J(UA2 ua2, float f) {
            AbstractC13042fc3.i(ua2, "$onDownloading");
            ua2.invoke(Float.valueOf(f));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 K(InterfaceC14603iB2 interfaceC14603iB2, int i, InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC14603iB2, "$onDownLoaded");
            AbstractC13042fc3.i(interfaceC3346Am2, "fileSystemReference");
            interfaceC14603iB2.invoke(interfaceC3346Am2, Integer.valueOf(i));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 L(UA2 ua2, DX1 dx1) {
            AbstractC13042fc3.i(ua2, "$onNotDownloaded");
            ua2.invoke(dx1);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 M(C14330hk2 c14330hk2, C11458d25 c11458d25, C5886Lg2 c5886Lg2, XH6 xh6, List list) {
            AbstractC13042fc3.i(c14330hk2, "this$0");
            AbstractC13042fc3.i(c11458d25, "$forwardedPeer");
            AbstractC13042fc3.i(c5886Lg2, "$feed");
            AbstractC13042fc3.i(xh6, "$sourceType");
            AbstractC13042fc3.i(list, "peers");
            List<C7947Tw2> list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (C7947Tw2 c7947Tw2 : list2) {
                arrayList.add(new C11458d25(c7947Tw2.b().getPeerType(), c7947Tw2.c()));
            }
            c14330hk2.Hb(arrayList, c11458d25, c5886Lg2, xh6);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 N(C14330hk2 c14330hk2, C11458d25 c11458d25, C5886Lg2 c5886Lg2, XH6 xh6, List list) {
            AbstractC13042fc3.i(c14330hk2, "this$0");
            AbstractC13042fc3.i(c11458d25, "$forwardedPeer");
            AbstractC13042fc3.i(c5886Lg2, "$feed");
            AbstractC13042fc3.i(xh6, "$sourceType");
            AbstractC13042fc3.i(list, "peers");
            c14330hk2.Hb(list, c11458d25, c5886Lg2, xh6);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 O(C14330hk2 c14330hk2, J44 j44, C11458d25 c11458d25, C5886Lg2 c5886Lg2, OP5 op5) {
            AbstractC13042fc3.i(c14330hk2, "this$0");
            AbstractC13042fc3.i(j44, "$message");
            AbstractC13042fc3.i(c11458d25, "$peer");
            AbstractC13042fc3.i(c5886Lg2, "$feed");
            AbstractC13042fc3.i(op5, "reportType");
            c14330hk2.Db(AbstractC9766aX0.e(j44), op5, c11458d25, c5886Lg2);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void A(String str, C14697iL2 c14697iL2, boolean z, WH5 wh5, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(str, "reactionCode");
            AbstractC13042fc3.i(c14697iL2, "group");
            AbstractC13042fc3.i(wh5, "reactionType");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            if (z) {
                C14330hk2.this.Ya().Y1(str, c14697iL2, z, wh5, c5886Lg2);
            } else {
                C14330hk2.this.Ya().k1(str, c14697iL2, z, wh5, c5886Lg2);
            }
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void B(C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "feed");
            C21051t17.Companion companion = C21051t17.INSTANCE;
            Boolean boolQ = c5886Lg2.q();
            boolean zBooleanValue = boolQ != null ? boolQ.booleanValue() : false;
            Integer numP = c5886Lg2.p();
            C21051t17 c21051t17A = companion.a(zBooleanValue, numP != null ? numP.intValue() : 0, c5886Lg2.f().getPeerId(), c5886Lg2.m(), c5886Lg2.e());
            C5679Kj2.f2(C14330hk2.this.Ya(), c5886Lg2.f().getPeerId(), K5.j, null, null, null, c5886Lg2, 28, null);
            C22042ua0.A9(C14330hk2.this, c21051t17A, false, null, 6, null);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void C(C8755Xe4 c8755Xe4) {
            AbstractC13042fc3.i(c8755Xe4, "itemMid");
            C14330hk2.this.Ya().z1().x(0L);
            C14330hk2.this.Mb(c8755Xe4, false);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void b(long j, String str, long j2, long j3) {
            AbstractC13042fc3.i(str, "mimeType");
            C14330hk2.this.Ya().j2(j, str, j2, j3);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void c(C8755Xe4 c8755Xe4, C5886Lg2 c5886Lg2) {
            String name;
            AbstractC13042fc3.i(c8755Xe4, "itemMid");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            if (C14330hk2.this.y1) {
                if (d.class.isAnonymousClass()) {
                    name = d.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = d.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.g(name, "feed item touch disabled, returning", new Object[0]);
                return;
            }
            AbstractC15520jj2 abstractC15520jj2I = c5886Lg2.i();
            C8386Vt0 c8386Vt0 = C8386Vt0.a;
            if (c8386Vt0.G6()) {
                C14330hk2.this.Ya().U1(c8755Xe4, c5886Lg2);
                C14330hk2.this.Ub();
                if ((abstractC15520jj2I instanceof AbstractC15520jj2.e) && AbstractC13042fc3.d(((AbstractC15520jj2.e) abstractC15520jj2I).b(), "photo") && c8386Vt0.C7()) {
                    C14330hk2 c14330hk2 = C14330hk2.this;
                    C22042ua0.A9(c14330hk2, C6622Oh2.Companion.b(C6622Oh2.INSTANCE, c8755Xe4, ((Number) c14330hk2.Ya().y1().getValue()).intValue(), false, null, 12, null), false, null, 6, null);
                    return;
                }
                if ((abstractC15520jj2I instanceof AbstractC15520jj2.h) && c8386Vt0.G7()) {
                    C14330hk2.Nb(C14330hk2.this, c8755Xe4, false, 2, null);
                    return;
                }
                if ((abstractC15520jj2I instanceof AbstractC15520jj2.f) && c8386Vt0.E7()) {
                    C14330hk2 c14330hk22 = C14330hk2.this;
                    C22042ua0.A9(c14330hk22, C6622Oh2.Companion.b(C6622Oh2.INSTANCE, c8755Xe4, ((Number) c14330hk22.Ya().y1().getValue()).intValue(), false, null, 12, null), false, null, 6, null);
                } else if ((abstractC15520jj2I instanceof AbstractC15520jj2.c) && c8386Vt0.A7()) {
                    C14330hk2 c14330hk23 = C14330hk2.this;
                    C22042ua0.A9(c14330hk23, C6622Oh2.Companion.b(C6622Oh2.INSTANCE, c8755Xe4, ((Number) c14330hk23.Ya().y1().getValue()).intValue(), false, null, 12, null), false, null, 6, null);
                }
            }
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public boolean d() {
            return C14330hk2.this.Ya().l1();
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public boolean e(String str) {
            AbstractC13042fc3.i(str, "url");
            Intent intent = new Intent("android.intent.action.VIEW");
            Uri uri = Uri.parse(str);
            intent.setData(uri);
            C18987pb3 c18987pb3 = C18987pb3.a;
            FragmentActivity fragmentActivityQ7 = C14330hk2.this.Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            if (c18987pb3.k0(intent, fragmentActivityQ7) || !H15.h.matcher(uri.toString()).find()) {
                return false;
            }
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            AbstractC13042fc3.f(uri);
            aVar.B(uri);
            return true;
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void f(final J44 j44, final C11458d25 c11458d25, final C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            final C14330hk2 c14330hk2 = C14330hk2.this;
            c14330hk2.Fb(new UA2() { // from class: ir.nasim.pk2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C14330hk2.d.O(c14330hk2, j44, c11458d25, c5886Lg2, (OP5) obj);
                }
            });
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void g(AbstractC15520jj2.h hVar, AbstractC13019fa0 abstractC13019fa0) {
            AbstractC13042fc3.i(hVar, "videoFeed");
            AbstractC13042fc3.i(abstractC13019fa0, "holder");
            C15372jT7 c15372jT7 = abstractC13019fa0 instanceof C15372jT7 ? (C15372jT7) abstractC13019fa0 : null;
            if (c15372jT7 != null) {
                C14330hk2.this.Ya().T1(hVar, c15372jT7.g4());
            }
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void h(final C11458d25 c11458d25, List list, final XH6 xh6, final C5886Lg2 c5886Lg2, C4743Gj2 c4743Gj2) {
            AbstractC13042fc3.i(c11458d25, "forwardedPeer");
            AbstractC13042fc3.i(list, "messages");
            AbstractC13042fc3.i(xh6, "sourceType");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            if (C8386Vt0.a.x8()) {
                C14330hk2 c14330hk2 = C14330hk2.this;
                J44 j44 = (J44) AbstractC15401jX0.q0(list);
                final C14330hk2 c14330hk22 = C14330hk2.this;
                c14330hk2.Ia(c11458d25, list, c4743Gj2, j44, new UA2() { // from class: ir.nasim.kk2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C14330hk2.d.M(c14330hk22, c11458d25, c5886Lg2, xh6, (List) obj);
                    }
                });
                return;
            }
            C5679Kj2 c5679Kj2Ya = C14330hk2.this.Ya();
            Context contextS7 = C14330hk2.this.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            final C14330hk2 c14330hk23 = C14330hk2.this;
            C5679Kj2.u1(c5679Kj2Ya, c11458d25, list, contextS7, false, new UA2() { // from class: ir.nasim.lk2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C14330hk2.d.N(c14330hk23, c11458d25, c5886Lg2, xh6, (List) obj);
                }
            }, 8, null);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void i(C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "feed");
            C5679Kj2.f2(C14330hk2.this.Ya(), c5886Lg2.f().getPeerId(), K5.i, null, null, null, c5886Lg2, 28, null);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void j(J44 j44) {
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            if (C14330hk2.this.Ya().v1(j44) && KV0.b()) {
                C14330hk2 c14330hk2 = C14330hk2.this;
                String strH6 = c14330hk2.h6(ID5.toast_messages_copied);
                AbstractC13042fc3.h(strH6, "getString(...)");
                c14330hk2.Qb(strH6);
            }
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void k(C11458d25 c11458d25, long j, C8755Xe4 c8755Xe4) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(c8755Xe4, "mid");
            C14330hk2.this.Ya().R1(c11458d25, j, c8755Xe4);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void l(int i) {
            C14330hk2.this.Ya().m1(i);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void m(boolean z, C11458d25 c11458d25, XH6 xh6, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(xh6, "sourceType");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            if (z) {
                C14330hk2.this.Ya().W1(c11458d25, xh6, c5886Lg2);
            } else {
                C14330hk2.this.Ya().P1(c11458d25, xh6, c5886Lg2);
            }
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void n() {
            C14330hk2.this.Ya().O1();
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void o() {
            C14330hk2.this.Ya().z1().h();
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public InterfaceC13730gj3 p(AbstractC15520jj2.h hVar) {
            AbstractC13042fc3.i(hVar, "feedVideoMessage");
            return C14330hk2.this.Ya().X1(hVar);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public boolean q() {
            C14330hk2.this.Vb();
            return true;
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void r(FileReference fileReference, final int i, final UA2 ua2, final InterfaceC14603iB2 interfaceC14603iB2, final UA2 ua22) {
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(ua2, "onDownloading");
            AbstractC13042fc3.i(interfaceC14603iB2, "onDownLoaded");
            AbstractC13042fc3.i(ua22, "onNotDownloaded");
            C14330hk2.this.Ya().w1(fileReference, new UA2() { // from class: ir.nasim.mk2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C14330hk2.d.J(ua2, ((Float) obj).floatValue());
                }
            }, new UA2() { // from class: ir.nasim.nk2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C14330hk2.d.K(interfaceC14603iB2, i, (InterfaceC3346Am2) obj);
                }
            }, new UA2() { // from class: ir.nasim.ok2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C14330hk2.d.L(ua22, (DX1) obj);
                }
            }, i);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void s(String str) {
            AbstractC13042fc3.i(str, "url");
            C14330hk2 c14330hk2 = C14330hk2.this;
            a.Companion companion = ir.nasim.jaryan.search.ui.fragment.a.INSTANCE;
            String strSubstring = str.substring(1);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            c14330hk2.x9(a.Companion.b(companion, strSubstring, null, 2, null));
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void t() {
            C14330hk2.this.Ya().r2();
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void u() {
            C14330hk2.this.Ya().z1().q();
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void v(C8755Xe4 c8755Xe4, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c8755Xe4, "itemMid");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            C14330hk2.this.Mb(c8755Xe4, true);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void w(C4743Gj2 c4743Gj2) {
            AbstractC13042fc3.i(c4743Gj2, "feed");
            C14330hk2.this.Ya().V1(c4743Gj2);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void x(C11458d25 c11458d25, J44 j44, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c11458d25, "fromPeer");
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(c5886Lg2, "feed");
            C14330hk2.this.Ya().c2(c11458d25, j44, c5886Lg2);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void y(int i, C8755Xe4 c8755Xe4) {
            AbstractC13042fc3.i(c8755Xe4, "mid");
            C14330hk2.this.Ya().S1(i, c8755Xe4);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void z(C11458d25 c11458d25, XH6 xh6, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(xh6, "sourceType");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            C14330hk2.this.Ya().z1().h();
            C14330hk2.this.Ya().W1(c11458d25, xh6, c5886Lg2);
        }
    }

    /* renamed from: ir.nasim.hk2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hk2$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14330hk2 d;

            /* renamed from: ir.nasim.hk2$e$a$a, reason: collision with other inner class name */
            static final class C1273a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C14330hk2 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1273a(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c14330hk2;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1273a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        this.b = 1;
                        if (HG1.b(1000L, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    this.c.cb();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1273a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14330hk2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C4977Hj2 c4977Hj2 = (C4977Hj2) this.c;
                if (!c4977Hj2.c()) {
                    ShimmerFrameLayout shimmerFrameLayout = this.d.Ra().e;
                    AbstractC13042fc3.h(shimmerFrameLayout, "shimmerFeed");
                    shimmerFrameLayout.setVisibility(c4977Hj2.a() ^ true ? 0 : 8);
                    ShimmerFrameLayout shimmerFrameLayout2 = this.d.Ra().e;
                    AbstractC13042fc3.h(shimmerFrameLayout2, "shimmerFeed");
                    if (shimmerFrameLayout2.getVisibility() == 0) {
                        this.d.Xa().a();
                    } else {
                        AbstractC10533bm0.d(AbstractC19224pz3.a(this.d), null, null, new C1273a(this.d, null), 3, null);
                        this.d.Ya().i2(this.d.Xa().b());
                    }
                    RecyclerView recyclerView = this.d.Ra().d;
                    AbstractC13042fc3.h(recyclerView, "rvFeeds");
                    recyclerView.setVisibility(c4977Hj2.a() ? 0 : 8);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4977Hj2 c4977Hj2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c4977Hj2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean y(C4977Hj2 c4977Hj2, C4977Hj2 c4977Hj22) {
            return c4977Hj2.a() == c4977Hj22.a() && c4977Hj2.c() == c4977Hj22.c();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(C14330hk2.this.Ya().M1(), new InterfaceC14603iB2() { // from class: ir.nasim.qk2
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Boolean.valueOf(C14330hk2.e.y((C4977Hj2) obj2, (C4977Hj2) obj3));
                    }
                });
                a aVar = new a(C14330hk2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2W, aVar, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hk2$f$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14330hk2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14330hk2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                C6119Mg2 c6119Mg2 = null;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C4977Hj2 c4977Hj2 = (C4977Hj2) this.c;
                    C6119Mg2 c6119Mg22 = this.d.t1;
                    if (c6119Mg22 == null) {
                        AbstractC13042fc3.y("feedAdapter");
                        c6119Mg22 = null;
                    }
                    NT4 nt4B = c4977Hj2.b();
                    this.b = 1;
                    if (c6119Mg22.L(nt4B, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                C5679Kj2 c5679Kj2Ya = this.d.Ya();
                C6119Mg2 c6119Mg23 = this.d.t1;
                if (c6119Mg23 == null) {
                    AbstractC13042fc3.y("feedAdapter");
                } else {
                    c6119Mg2 = c6119Mg23;
                }
                c5679Kj2Ya.u2(c6119Mg2.getItemCount() > 0);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4977Hj2 c4977Hj2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c4977Hj2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C14330hk2.this.Ya().M1(), new C25226zw5() { // from class: ir.nasim.hk2.f.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return ((C4977Hj2) obj2).b();
                    }
                });
                b bVar = new b(C14330hk2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2X, bVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hk2$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14330hk2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14330hk2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C13628gZ0 c13628gZ0 = (C13628gZ0) this.c;
                ShimmerFrameLayout shimmerFrameLayout = this.d.Ra().e;
                AbstractC13042fc3.h(shimmerFrameLayout, "shimmerFeed");
                shimmerFrameLayout.setVisibility((c13628gZ0.d() instanceof AbstractC13460gG3.c) ^ true ? 0 : 8);
                if (c13628gZ0.d() instanceof AbstractC13460gG3.c) {
                    C13628gZ0 c13628gZ02 = this.d.A1;
                    if (AbstractC13042fc3.d(c13628gZ02 != null ? c13628gZ02.d() : null, AbstractC13460gG3.b.b)) {
                        C14330hk2 c14330hk2 = this.d;
                        RecyclerView recyclerView = c14330hk2.Ra().d;
                        AbstractC13042fc3.h(recyclerView, "rvFeeds");
                        c14330hk2.Rb(recyclerView, 10);
                    }
                }
                this.d.Ya().t2(c13628gZ0.d() instanceof AbstractC13460gG3.c);
                this.d.A1 = c13628gZ0;
                RecyclerView recyclerView2 = this.d.Ra().d;
                AbstractC13042fc3.h(recyclerView2, "rvFeeds");
                recyclerView2.setVisibility(c13628gZ0.d() instanceof AbstractC13460gG3.c ? 0 : 8);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C13628gZ0 c13628gZ0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c13628gZ0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6119Mg2 c6119Mg2 = C14330hk2.this.t1;
                if (c6119Mg2 == null) {
                    AbstractC13042fc3.y("feedAdapter");
                    c6119Mg2 = null;
                }
                InterfaceC4557Fq2 interfaceC4557Fq2E = c6119Mg2.E();
                a aVar = new a(C14330hk2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2E, aVar, this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.hk2$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C14330hk2 c;
            final /* synthetic */ InterfaceC20315ro1 d;

            /* renamed from: ir.nasim.hk2$h$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ InterfaceC20315ro1 d;
                final /* synthetic */ C14330hk2 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(InterfaceC20315ro1 interfaceC20315ro1, C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = interfaceC20315ro1;
                    this.e = c14330hk2;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    b bVar = new b(this.d, this.e, interfaceC20295rm1);
                    bVar.c = obj;
                    return bVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    h.y(this.d, this.e, ((C11863dg5) this.c).c());
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(C11863dg5 c11863dg5, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((b) create(c11863dg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14330hk2 c14330hk2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c14330hk2;
                this.d = interfaceC20315ro1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(this.c.Ya().E1(), new C25226zw5() { // from class: ir.nasim.hk2.h.a.a
                        @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                        public Object get(Object obj2) {
                            return Integer.valueOf(((C11863dg5) obj2).c());
                        }
                    });
                    b bVar = new b(this.d, this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2X, bVar, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0128  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final void y(ir.nasim.InterfaceC20315ro1 r8, ir.nasim.C14330hk2 r9, int r10) {
            /*
                Method dump skipped, instructions count: 529
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14330hk2.h.y(ir.nasim.ro1, ir.nasim.hk2, int):void");
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = C14330hk2.this.new h(interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(C14330hk2.this, interfaceC20315ro1, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hk2$i$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14330hk2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14330hk2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                C15372jT7 c15372jT7Va;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((C11863dg5) this.c).e() != null && (c15372jT7Va = this.d.Va()) != null) {
                    c15372jT7Va.A4();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C11863dg5 c11863dg5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c11863dg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(AbstractC6459Nq2.F(C14330hk2.this.Ya().E1()), new C25226zw5() { // from class: ir.nasim.hk2.i.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return ((C11863dg5) obj2).e();
                    }
                });
                b bVar = new b(C14330hk2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2X, bVar, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hk2$j$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14330hk2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14330hk2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                EnumC14332b enumC14332b = ((C11863dg5) this.c).f() > 0.0f ? EnumC14332b.b : EnumC14332b.a;
                this.d.Kb(enumC14332b);
                this.d.n1 = enumC14332b;
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C11863dg5 c11863dg5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c11863dg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.hk2$j$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ C14330hk2 b;

            /* renamed from: ir.nasim.hk2$j$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ C14330hk2 b;

                /* renamed from: ir.nasim.hk2$j$c$a$a, reason: collision with other inner class name */
                public static final class C1275a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1275a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, C14330hk2 c14330hk2) {
                    this.a = interfaceC4806Gq2;
                    this.b = c14330hk2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof ir.nasim.C14330hk2.j.c.a.C1275a
                        if (r0 == 0) goto L13
                        r0 = r9
                        ir.nasim.hk2$j$c$a$a r0 = (ir.nasim.C14330hk2.j.c.a.C1275a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.hk2$j$c$a$a r0 = new ir.nasim.hk2$j$c$a$a
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r9)
                        goto L8f
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        ir.nasim.AbstractC10685c16.b(r9)
                        ir.nasim.Gq2 r9 = r7.a
                        r2 = r8
                        ir.nasim.dg5 r2 = (ir.nasim.C11863dg5) r2
                        ir.nasim.hk2 r2 = r7.b
                        androidx.fragment.app.Fragment r2 = r2.U5()
                        if (r2 == 0) goto L7a
                        androidx.fragment.app.Fragment r2 = r2.U5()
                        if (r2 == 0) goto L7a
                        androidx.fragment.app.FragmentManager r2 = r2.V5()
                        if (r2 == 0) goto L7a
                        java.util.List r2 = r2.C0()
                        if (r2 == 0) goto L7a
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        java.util.ArrayList r4 = new java.util.ArrayList
                        r4.<init>()
                        java.util.Iterator r2 = r2.iterator()
                    L5e:
                        boolean r5 = r2.hasNext()
                        if (r5 == 0) goto L70
                        java.lang.Object r5 = r2.next()
                        boolean r6 = r5 instanceof ir.nasim.MW6
                        if (r6 == 0) goto L5e
                        r4.add(r5)
                        goto L5e
                    L70:
                        boolean r2 = r4.isEmpty()
                        r2 = r2 ^ r3
                        java.lang.Boolean r2 = ir.nasim.AbstractC6392Nk0.a(r2)
                        goto L7b
                    L7a:
                        r2 = 0
                    L7b:
                        r4 = 0
                        java.lang.Boolean r4 = ir.nasim.AbstractC6392Nk0.a(r4)
                        boolean r2 = ir.nasim.AbstractC13042fc3.d(r2, r4)
                        if (r2 == 0) goto L8f
                        r0.b = r3
                        java.lang.Object r8 = r9.a(r8, r0)
                        if (r8 != r1) goto L8f
                        return r1
                    L8f:
                        ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14330hk2.j.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2, C14330hk2 c14330hk2) {
                this.a = interfaceC4557Fq2;
                this.b = c14330hk2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                c cVar = new c(AbstractC6459Nq2.x(AbstractC6459Nq2.F(C14330hk2.this.Ya().E1()), new C25226zw5() { // from class: ir.nasim.hk2.j.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return Float.valueOf(((C11863dg5) obj2).f());
                    }
                }), C14330hk2.this);
                b bVar = new b(C14330hk2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(cVar, bVar, this) == objE) {
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hk2$k$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14330hk2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14330hk2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((C4977Hj2) this.c).c()) {
                    ShimmerFrameLayout shimmerFrameLayout = this.d.Ra().e;
                    AbstractC13042fc3.h(shimmerFrameLayout, "shimmerFeed");
                    C6119Mg2 c6119Mg2 = this.d.t1;
                    C6119Mg2 c6119Mg22 = null;
                    if (c6119Mg2 == null) {
                        AbstractC13042fc3.y("feedAdapter");
                        c6119Mg2 = null;
                    }
                    shimmerFrameLayout.setVisibility(c6119Mg2.getItemCount() > 0 ? 0 : 8);
                    RecyclerView recyclerView = this.d.Ra().d;
                    AbstractC13042fc3.h(recyclerView, "rvFeeds");
                    C6119Mg2 c6119Mg23 = this.d.t1;
                    if (c6119Mg23 == null) {
                        AbstractC13042fc3.y("feedAdapter");
                    } else {
                        c6119Mg22 = c6119Mg23;
                    }
                    recyclerView.setVisibility(c6119Mg22.getItemCount() != 0 ? 0 : 8);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4977Hj2 c4977Hj2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c4977Hj2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C14330hk2.this.Ya().M1(), new C25226zw5() { // from class: ir.nasim.hk2.k.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return Boolean.valueOf(((C4977Hj2) obj2).c());
                    }
                });
                b bVar = new b(C14330hk2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2X, bVar, this) == objE) {
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hk2$l$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14330hk2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14330hk2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C4977Hj2 c4977Hj2 = (C4977Hj2) this.c;
                C14330hk2 c14330hk2 = this.d;
                Integer numD = c4977Hj2.d();
                AbstractC13042fc3.f(numD);
                String strH6 = c14330hk2.h6(numD.intValue());
                AbstractC13042fc3.h(strH6, "getString(...)");
                c14330hk2.Qb(strH6);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4977Hj2 c4977Hj2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c4977Hj2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.hk2$l$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.hk2$l$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.hk2$l$c$a$a, reason: collision with other inner class name */
                public static final class C1276a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1276a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.C14330hk2.l.c.a.C1276a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.hk2$l$c$a$a r0 = (ir.nasim.C14330hk2.l.c.a.C1276a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.hk2$l$c$a$a r0 = new ir.nasim.hk2$l$c$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L55
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.Hj2 r2 = (ir.nasim.C4977Hj2) r2
                        java.lang.Integer r4 = r2.d()
                        if (r4 == 0) goto L55
                        java.lang.Integer r2 = r2.d()
                        if (r2 != 0) goto L46
                        goto L4c
                    L46:
                        int r2 = r2.intValue()
                        if (r2 == 0) goto L55
                    L4c:
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L55
                        return r1
                    L55:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14330hk2.l.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                c cVar = new c(AbstractC6459Nq2.x(C14330hk2.this.Ya().M1(), new C25226zw5() { // from class: ir.nasim.hk2.l.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return ((C4977Hj2) obj2).d();
                    }
                }));
                b bVar = new b(C14330hk2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(cVar, bVar, this) == objE) {
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
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hk2$m$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ int c;
            final /* synthetic */ C14330hk2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14330hk2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Number) obj).intValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).intValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.Kb(this.c > 0 ? EnumC14332b.b : EnumC14332b.a);
                return C19938rB7.a;
            }

            public final Object n(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Integer.valueOf(i), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.hk2$m$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ C14330hk2 b;

            /* renamed from: ir.nasim.hk2$m$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ C14330hk2 b;

                /* renamed from: ir.nasim.hk2$m$b$a$a, reason: collision with other inner class name */
                public static final class C1277a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1277a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, C14330hk2 c14330hk2) {
                    this.a = interfaceC4806Gq2;
                    this.b = c14330hk2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ir.nasim.C14330hk2.m.b.a.C1277a
                        if (r0 == 0) goto L13
                        r0 = r8
                        ir.nasim.hk2$m$b$a$a r0 = (ir.nasim.C14330hk2.m.b.a.C1277a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.hk2$m$b$a$a r0 = new ir.nasim.hk2$m$b$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L7d
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.Gq2 r8 = r6.a
                        r2 = r7
                        java.lang.Number r2 = (java.lang.Number) r2
                        r2.intValue()
                        ir.nasim.hk2 r2 = r6.b
                        androidx.fragment.app.Fragment r2 = r2.U5()
                        boolean r4 = r2 instanceof ir.nasim.AbstractC22105ug3
                        r5 = 0
                        if (r4 == 0) goto L4a
                        ir.nasim.ug3 r2 = (ir.nasim.AbstractC22105ug3) r2
                        goto L4b
                    L4a:
                        r2 = r5
                    L4b:
                        if (r2 == 0) goto L7d
                        boolean r2 = r2.w6()
                        if (r2 != 0) goto L7d
                        ir.nasim.hk2 r2 = r6.b
                        androidx.fragment.app.Fragment r2 = r2.U5()
                        boolean r4 = r2 instanceof ir.nasim.AbstractC22105ug3
                        if (r4 == 0) goto L60
                        r5 = r2
                        ir.nasim.ug3 r5 = (ir.nasim.AbstractC22105ug3) r5
                    L60:
                        if (r5 == 0) goto L7d
                        ir.nasim.Zm4 r2 = r5.getIsFeedActive()
                        if (r2 == 0) goto L7d
                        java.lang.Object r2 = r2.getValue()
                        java.lang.Boolean r2 = (java.lang.Boolean) r2
                        boolean r2 = r2.booleanValue()
                        if (r2 != r3) goto L7d
                        r0.b = r3
                        java.lang.Object r7 = r8.a(r7, r0)
                        if (r7 != r1) goto L7d
                        return r1
                    L7d:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14330hk2.m.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2, C14330hk2 c14330hk2) {
                this.a = interfaceC4557Fq2;
                this.b = c14330hk2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14330hk2 c14330hk2 = C14330hk2.this;
                Context contextS7 = c14330hk2.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                b bVar = new b(c14330hk2.Wb(contextS7), C14330hk2.this);
                a aVar = new a(C14330hk2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
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
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hk2$n$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ int c;
            final /* synthetic */ C14330hk2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14330hk2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Number) obj).intValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).intValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.d.Ya().p2(this.d.C1, this.c)) {
                    C14330hk2.Ab(this.d, false, 1, null);
                }
                return C19938rB7.a;
            }

            public final Object n(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Integer.valueOf(i), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new n(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2G1 = C14330hk2.this.Ya().G1();
                a aVar = new a(C14330hk2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2G1, aVar, this) == objE) {
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
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new o(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(500L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C14330hk2.this.cb();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$p */
    /* synthetic */ class p extends EB2 implements InterfaceC16978mB2 {
        p(Object obj) {
            super(4, obj, C5679Kj2.class, "sendPostDurationEventVideo", "sendPostDurationEventVideo(IIILir/nasim/jaryan/feed/model/network/Feed;)V", 0);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            y(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), (C5886Lg2) obj4);
            return C19938rB7.a;
        }

        public final void y(int i, int i2, int i3, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "p3");
            ((C5679Kj2) this.receiver).h2(i, i2, i3, c5886Lg2);
        }
    }

    /* renamed from: ir.nasim.hk2$q */
    /* synthetic */ class q extends EB2 implements InterfaceC14603iB2 {
        q(Object obj) {
            super(2, obj, C5679Kj2.class, "sendPostDurationEventSimple", "sendPostDurationEventSimple(ILir/nasim/jaryan/feed/model/network/Feed;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y(((Number) obj).intValue(), (C5886Lg2) obj2);
            return C19938rB7.a;
        }

        public final void y(int i, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "p1");
            ((C5679Kj2) this.receiver).g2(i, c5886Lg2);
        }
    }

    /* renamed from: ir.nasim.hk2$r */
    public static final class r extends androidx.recyclerview.widget.o {
        final /* synthetic */ float q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(float f, Context context) {
            super(context);
            this.q = f;
            p(0);
        }

        @Override // androidx.recyclerview.widget.o
        protected int B() {
            return -1;
        }

        @Override // androidx.recyclerview.widget.o
        protected float v(DisplayMetrics displayMetrics) {
            return super.v(displayMetrics) / this.q;
        }
    }

    /* renamed from: ir.nasim.hk2$s */
    public static final class s extends RecyclerView.t {
        private boolean b;
        private boolean a = true;
        private boolean c = true;

        s() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.a(recyclerView, i);
            if (i == 0) {
                this.a = true;
                C14330hk2.this.h1.I1();
            }
            if (i == 0 && this.b) {
                this.b = false;
                C14330hk2.this.h1.o2();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.b(recyclerView, i, i2);
            C14330hk2.this.h1.C1(recyclerView.computeVerticalScrollOffset(), this.c);
            boolean z = Math.abs((double) i2) > ((double) 18.0f);
            if (i2 < 0 && z && this.a) {
                this.a = false;
                this.b = true;
                this.c = false;
                C14330hk2.this.h1.C2(true);
            }
            if (i2 > 0) {
                this.b = false;
                C14330hk2.this.h1.C2(false);
            }
            C14330hk2.this.cb();
        }
    }

    /* renamed from: ir.nasim.hk2$t */
    public static final class t implements RecyclerView.q {
        t() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(View view) {
            String name;
            String name2;
            AbstractC13042fc3.i(view, "view");
            if (t.class.isAnonymousClass()) {
                name = t.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = t.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.g(name, "onChildViewDetachedFromWindow", new Object[0]);
            if (C14330hk2.this.p1 != null) {
                C15372jT7 c15372jT7 = C14330hk2.this.p1;
                if (AbstractC13042fc3.d(c15372jT7 != null ? c15372jT7.a : null, view)) {
                    if (t.class.isAnonymousClass()) {
                        name2 = t.class.getName();
                        int length3 = name2.length();
                        AbstractC13042fc3.f(name2);
                        if (length3 > 23) {
                            name2 = name2.substring(name2.length() - 23, name2.length());
                            AbstractC13042fc3.h(name2, "substring(...)");
                        }
                    } else {
                        name2 = t.class.getSimpleName();
                        int length4 = name2.length();
                        AbstractC13042fc3.f(name2);
                        if (length4 > 23) {
                            name2 = name2.substring(0, 23);
                            AbstractC13042fc3.h(name2, "substring(...)");
                        }
                    }
                    C19406qI3.g(name2, "pausing and stopping player, also seeking to 0", new Object[0]);
                    C14330hk2.this.o1 = -1;
                    C14330hk2.this.Ya().z1().D(false);
                    C14330hk2.this.Ya().z1().stop();
                    C14330hk2.this.Ya().z1().x(0L);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void d(View view) {
            AbstractC13042fc3.i(view, "view");
        }
    }

    /* renamed from: ir.nasim.hk2$u */
    public static final class u extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    /* renamed from: ir.nasim.hk2$v */
    public static final class v extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    /* renamed from: ir.nasim.hk2$w */
    public static final class w extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    /* renamed from: ir.nasim.hk2$x */
    public static final class x extends AbstractC8614Ws3 implements UA2 {
        public x() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C13877gy2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.hk2$y */
    static final class y extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C5886Lg2 d;

        /* renamed from: ir.nasim.hk2$y$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14330hk2 d;

            /* renamed from: ir.nasim.hk2$y$a$a, reason: collision with other inner class name */
            static final class C1278a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C14330hk2 c;
                final /* synthetic */ List d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1278a(C14330hk2 c14330hk2, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c14330hk2;
                    this.d = list;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1278a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    C5211Ij2 c5211Ij2H4;
                    TextView textView;
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    C15372jT7 c15372jT7Va = this.c.Va();
                    if (c15372jT7Va != null && (c5211Ij2H4 = c15372jT7Va.h4()) != null && (textView = c5211Ij2H4.l) != null) {
                        textView.setVisibility((this.d.isEmpty() ^ true) && C8386Vt0.A6() ? 0 : 8);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1278a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14330hk2 c14330hk2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14330hk2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    List list = (List) this.c;
                    WM3 wm3C = C12366eV1.c();
                    C1278a c1278a = new C1278a(this.d, list, null);
                    this.b = 1;
                    if (AbstractC9323Zl0.g(wm3C, c1278a, this) == objE) {
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
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(C5886Lg2 c5886Lg2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c5886Lg2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14330hk2.this.new y(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14330hk2.this.Ya().H1(new C8755Xe4(this.d.f().getPeerId(), this.d.e(), this.d.m(), 0, 8, null));
                InterfaceC9336Zm4 interfaceC9336Zm4I1 = C14330hk2.this.Ya().I1();
                a aVar = new a(C14330hk2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC9336Zm4I1, aVar, this) == objE) {
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
            return ((y) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hk2$z */
    /* synthetic */ class z extends EB2 implements InterfaceC16978mB2 {
        z(Object obj) {
            super(4, obj, C5679Kj2.class, "sendPostDurationEventVideo", "sendPostDurationEventVideo(IIILir/nasim/jaryan/feed/model/network/Feed;)V", 0);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            y(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), (C5886Lg2) obj4);
            return C19938rB7.a;
        }

        public final void y(int i, int i2, int i3, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "p3");
            ((C5679Kj2) this.receiver).h2(i, i2, i3, c5886Lg2);
        }
    }

    public C14330hk2(InterfaceC8506Wg3 interfaceC8506Wg3) {
        AbstractC13042fc3.i(interfaceC8506Wg3, "jaryanScrollListener");
        this.h1 = interfaceC8506Wg3;
        this.i1 = AbstractC6056Lz2.f(this, new x(), AbstractC20046rN7.c());
        this.m1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C5679Kj2.class), new u(this), new v(null, this), new w(this));
        this.n1 = EnumC14332b.a;
        this.o1 = -1;
        this.q1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Tj2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14330hk2.Pa(this.a);
            }
        });
        this.x1 = new SX7();
        this.z1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Uj2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14330hk2.Lb();
            }
        });
        this.C1 = System.currentTimeMillis();
    }

    static /* synthetic */ void Ab(C14330hk2 c14330hk2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        c14330hk2.zb(z2);
    }

    private final void Bb(final InterfaceC14603iB2 interfaceC14603iB2) {
        final String name;
        if (C14330hk2.class.isAnonymousClass()) {
            name = C14330hk2.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C14330hk2.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        F5().z(name);
        F5().H1(name, this, new InterfaceC13295fz2() { // from class: ir.nasim.Sj2
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                C14330hk2.Cb(this.a, name, interfaceC14603iB2, str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Cb(C14330hk2 c14330hk2, String str, InterfaceC14603iB2 interfaceC14603iB2, String str2, Bundle bundle) {
        OP5 op5;
        AbstractC13042fc3.i(c14330hk2, "this$0");
        AbstractC13042fc3.i(str, "$resultKey");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onResult");
        AbstractC13042fc3.i(str2, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        c14330hk2.F5().y(str);
        c14330hk2.F5().z(str);
        int i2 = bundle.getInt("feed_report_title_result_key", 0);
        if (Build.VERSION.SDK_INT >= 33) {
            op5 = (OP5) bundle.getSerializable("feed_report_type_result_key", OP5.class);
        } else {
            Serializable serializable = bundle.getSerializable("feed_report_type_result_key");
            op5 = serializable instanceof OP5 ? (OP5) serializable : null;
        }
        if (op5 == null) {
            return;
        }
        interfaceC14603iB2.invoke(Integer.valueOf(i2), op5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Eb(C14330hk2 c14330hk2, C11458d25 c11458d25, OP5 op5, List list, C5886Lg2 c5886Lg2, String str) {
        AbstractC13042fc3.i(c14330hk2, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(op5, "$type");
        AbstractC13042fc3.i(list, "$messages");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        AbstractC13042fc3.i(str, "reportDescription");
        c14330hk2.Ya().Z1(c11458d25, str, op5, list, c5886Lg2);
        return C19938rB7.a;
    }

    private final void Fa() {
        ComposeView composeView = Ra().b;
        if (C8386Vt0.u6()) {
            composeView.setContent(AbstractC19242q11.c(114317982, true, new c(composeView)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Gb(UA2 ua2, int i2, OP5 op5) {
        AbstractC13042fc3.i(op5, "reportType");
        if (ua2 != null) {
            ua2.invoke(op5);
        }
        return C19938rB7.a;
    }

    private final InterfaceC13138fj2 Ha() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hb(List list, C11458d25 c11458d25, C5886Lg2 c5886Lg2, XH6 xh6) {
        if (list.contains(new C11458d25(W25.a, Ya().D1()))) {
            C5679Kj2.f2(Ya(), c11458d25.getPeerId(), K5.h, XH6.d, null, null, c5886Lg2, 24, null);
        } else {
            C5679Kj2.f2(Ya(), c11458d25.getPeerId(), K5.e, xh6, null, null, c5886Lg2, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ia(C11458d25 c11458d25, List list, C4743Gj2 c4743Gj2, J44 j44, final UA2 ua2) {
        final ClipData clipDataNewPlainText;
        final C12889fL5 c12889fL5 = new C12889fL5();
        if (c4743Gj2 != null) {
            String strA = Sa().a(j44, false, c4743Gj2.g(), "https://ble.ir/");
            c12889fL5.a = strA;
            clipDataNewPlainText = ClipData.newPlainText("Post Link", strA);
        } else {
            clipDataNewPlainText = null;
        }
        Ua().a(this, c11458d25, list, false, list.size() == 1, new SA2() { // from class: ir.nasim.Zj2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14330hk2.Ja();
            }
        }, new SA2() { // from class: ir.nasim.ak2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14330hk2.Ka(c12889fL5, clipDataNewPlainText, this);
            }
        }, new SA2() { // from class: ir.nasim.bk2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14330hk2.La();
            }
        }, new SA2() { // from class: ir.nasim.ck2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14330hk2.Ma(c12889fL5, this);
            }
        }, new UA2() { // from class: ir.nasim.dk2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C14330hk2.Oa(ua2, (List) obj);
            }
        });
    }

    private final void Ib() {
        ib();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ja() {
        return C19938rB7.a;
    }

    private final void Jb() {
        Ra().d.addOnScrollListener(new s());
        Ra().d.addOnChildAttachStateChangeListener(new t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClipData Ka(C12889fL5 c12889fL5, ClipData clipData, C14330hk2 c14330hk2) {
        AbstractC13042fc3.i(c12889fL5, "$postLink");
        AbstractC13042fc3.i(c14330hk2, "this$0");
        String str = (String) c12889fL5.a;
        if (str != null) {
            C4851Gv2 c4851Gv2 = C4851Gv2.a;
            FragmentActivity fragmentActivityQ7 = c14330hk2.Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            c4851Gv2.a(str, fragmentActivityQ7);
        }
        return clipData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kb(EnumC14332b enumC14332b) {
        if (enumC14332b == null) {
            return;
        }
        Ya().z1().g(enumC14332b == EnumC14332b.a ? 0.0f : 1.0f);
        Ya().l2(enumC14332b);
        LinearLayoutManager linearLayoutManager = this.v1;
        if (linearLayoutManager == null) {
            AbstractC13042fc3.y("linearLayoutManager");
            linearLayoutManager = null;
        }
        int iD2 = linearLayoutManager.d2();
        LinearLayoutManager linearLayoutManager2 = this.v1;
        if (linearLayoutManager2 == null) {
            AbstractC13042fc3.y("linearLayoutManager");
            linearLayoutManager2 = null;
        }
        int iG2 = linearLayoutManager2.g2();
        if (iD2 == -1 || iG2 == -1 || iD2 > iG2) {
            return;
        }
        while (true) {
            RecyclerView.C cFindViewHolderForAdapterPosition = Ra().d.findViewHolderForAdapterPosition(iD2);
            C15372jT7 c15372jT7 = cFindViewHolderForAdapterPosition instanceof C15372jT7 ? (C15372jT7) cFindViewHolderForAdapterPosition : null;
            if (c15372jT7 != null) {
                c15372jT7.U3(enumC14332b);
            }
            if (iD2 == iG2) {
                return;
            } else {
                iD2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 La() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C22890vz6 Lb() {
        return new C22890vz6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ma(C12889fL5 c12889fL5, final C14330hk2 c14330hk2) {
        AbstractC13042fc3.i(c12889fL5, "$postLink");
        AbstractC13042fc3.i(c14330hk2, "this$0");
        String str = (String) c12889fL5.a;
        if (str != null) {
            C4851Gv2.c(C4851Gv2.a, str, null, new UA2() { // from class: ir.nasim.gk2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C14330hk2.Na(this.a, (Intent) obj);
                }
            }, 2, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mb(C8755Xe4 c8755Xe4, boolean z2) {
        C22042ua0.A9(this, C6622Oh2.INSTANCE.a(c8755Xe4, ((Number) Ya().y1().getValue()).intValue(), z2, null), false, null, 6, null);
        qb();
        Q7().B0().H1("feed_full_screen_result_key", p6(), new InterfaceC13295fz2() { // from class: ir.nasim.Yj2
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                C14330hk2.Ob(this.a, str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Na(C14330hk2 c14330hk2, Intent intent) {
        AbstractC13042fc3.i(c14330hk2, "this$0");
        AbstractC13042fc3.i(intent, "it");
        c14330hk2.n8(intent);
        return C19938rB7.a;
    }

    static /* synthetic */ void Nb(C14330hk2 c14330hk2, C8755Xe4 c8755Xe4, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        c14330hk2.Mb(c8755Xe4, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Oa(UA2 ua2, List list) {
        AbstractC13042fc3.i(ua2, "$onSuccess");
        AbstractC13042fc3.i(list, "it");
        ua2.invoke(list);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ob(C14330hk2 c14330hk2, String str, Bundle bundle) {
        AbstractC13042fc3.i(c14330hk2, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "<unused var>");
        c14330hk2.rb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 Pa(C14330hk2 c14330hk2) {
        View viewO6;
        AbstractC13042fc3.i(c14330hk2, "this$0");
        Fragment fragmentU5 = c14330hk2.U5();
        if (fragmentU5 == null || (viewO6 = fragmentU5.o6()) == null) {
            return null;
        }
        return new C17468n10(viewO6, null, 0, 6, null);
    }

    private final void Pb(InterfaceC14603iB2 interfaceC14603iB2) {
        String name;
        Bb(interfaceC14603iB2);
        InterfaceC24908zP5 interfaceC24908zP5Wa = Wa();
        if (C14330hk2.class.isAnonymousClass()) {
            name = C14330hk2.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C14330hk2.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        InterfaceC24908zP5.b(interfaceC24908zP5Wa, name, "feed_report_title_result_key", "feed_report_type_result_key", null, 8, null).L8(F5(), null);
    }

    private final int Qa(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        String name;
        int iD2 = linearLayoutManager.d2();
        int iG2 = linearLayoutManager.g2();
        if (iD2 == iG2 && iD2 == 0) {
            return 0;
        }
        recyclerView.getGlobalVisibleRect(new Rect());
        int i2 = -1;
        if (iD2 <= iG2) {
            int i3 = 0;
            while (true) {
                View viewD = linearLayoutManager.D(iD2);
                if (viewD != null) {
                    double dZa = Za(viewD);
                    if (dZa > 45.0d && dZa > i3) {
                        i3 = (int) dZa;
                        if (C14330hk2.class.isAnonymousClass()) {
                            name = C14330hk2.class.getName();
                            int length = name.length();
                            AbstractC13042fc3.f(name);
                            if (length > 23) {
                                name = name.substring(name.length() - 23, name.length());
                                AbstractC13042fc3.h(name, "substring(...)");
                            }
                        } else {
                            name = C14330hk2.class.getSimpleName();
                            int length2 = name.length();
                            AbstractC13042fc3.f(name);
                            if (length2 > 23) {
                                name = name.substring(0, 23);
                                AbstractC13042fc3.h(name, "substring(...)");
                            }
                        }
                        C19406qI3.g(name, "visible item, pos: " + iD2 + ", percentage: " + dZa, new Object[0]);
                        i2 = iD2;
                    }
                }
                if (iD2 == iG2) {
                    break;
                }
                iD2++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qb(String str) {
        String name;
        try {
            C17468n10 c17468n10Ta = Ta();
            if (c17468n10Ta != null) {
                c17468n10Ta.o(str);
            }
            Ya().a2();
        } catch (Exception e2) {
            if (C14330hk2.class.isAnonymousClass()) {
                name = C14330hk2.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C14330hk2.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.j(name, "showSnackBar error: " + e2.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13877gy2 Ra() {
        Object objA = this.i1.a(this, E1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C13877gy2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rb(RecyclerView recyclerView, int i2) {
        RecyclerView.p layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        if (linearLayoutManager.d2() > i2) {
            linearLayoutManager.E2(i2, 0);
        }
        linearLayoutManager.E2(0, 0);
    }

    private final void Sb() {
        RecyclerView recyclerView = Ra().d;
        AbstractC13042fc3.h(recyclerView, "rvFeeds");
        LY7 ly7 = new LY7(recyclerView);
        RecyclerView recyclerView2 = Ra().d;
        AbstractC13042fc3.h(recyclerView2, "rvFeeds");
        ly7.k(recyclerView2, new UA2() { // from class: ir.nasim.Vj2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C14330hk2.Tb(this.a, (C5886Lg2) obj);
            }
        });
    }

    private final C17468n10 Ta() {
        return (C17468n10) this.q1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Tb(C14330hk2 c14330hk2, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c14330hk2, "this$0");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC10533bm0.d(AbstractC19224pz3.a(c14330hk2), C12366eV1.b(), null, c14330hk2.new y(c5886Lg2, null), 2, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ub() {
        SX7 sx7 = this.x1;
        RecyclerView recyclerView = Ra().d;
        AbstractC13042fc3.h(recyclerView, "rvFeeds");
        sx7.l(recyclerView, new z(Ya()), new A(Ya()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C15372jT7 Va() {
        RecyclerView recyclerView = Ra().d;
        RecyclerView recyclerView2 = Ra().d;
        AbstractC13042fc3.h(recyclerView2, "rvFeeds");
        LinearLayoutManager linearLayoutManager = this.v1;
        if (linearLayoutManager == null) {
            AbstractC13042fc3.y("linearLayoutManager");
            linearLayoutManager = null;
        }
        RecyclerView.C cFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(Qa(recyclerView2, linearLayoutManager));
        if (cFindViewHolderForAdapterPosition instanceof C15372jT7) {
            return (C15372jT7) cFindViewHolderForAdapterPosition;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vb() {
        if (this.o1 != -1) {
            Ya().s2();
            Kb(this.n1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 Wb(Context context) {
        return AbstractC6459Nq2.f(new B(context, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C22890vz6 Xa() {
        return (C22890vz6) this.z1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5679Kj2 Ya() {
        return (C5679Kj2) this.m1.getValue();
    }

    private final double Za(View view) {
        double dHeight = (r0.height() / view.getMeasuredHeight()) * 100;
        if (view.getLocalVisibleRect(new Rect())) {
            return dHeight;
        }
        return 0.0d;
    }

    public static /* synthetic */ void bb(C14330hk2 c14330hk2, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z3 = false;
        }
        c14330hk2.ab(z2, z3);
    }

    private final void db(int i2) {
        String name;
        String name2;
        String name3;
        String name4;
        RecyclerView.C cFindViewHolderForAdapterPosition = Ra().d.findViewHolderForAdapterPosition(i2);
        if (cFindViewHolderForAdapterPosition == null) {
            if (C14330hk2.class.isAnonymousClass()) {
                name4 = C14330hk2.class.getName();
                int length = name4.length();
                AbstractC13042fc3.f(name4);
                if (length > 23) {
                    name4 = name4.substring(name4.length() - 23, name4.length());
                    AbstractC13042fc3.h(name4, "substring(...)");
                }
            } else {
                name4 = C14330hk2.class.getSimpleName();
                int length2 = name4.length();
                AbstractC13042fc3.f(name4);
                if (length2 > 23) {
                    name4 = name4.substring(0, 23);
                    AbstractC13042fc3.h(name4, "substring(...)");
                }
            }
            C19406qI3.g(name4, "findViewHolderForAdapterPosition is null for position: " + i2, new Object[0]);
            return;
        }
        C15372jT7 c15372jT7 = cFindViewHolderForAdapterPosition instanceof C15372jT7 ? (C15372jT7) cFindViewHolderForAdapterPosition : null;
        if (c15372jT7 == null) {
            return;
        }
        if (C14330hk2.class.isAnonymousClass()) {
            name = C14330hk2.class.getName();
            int length3 = name.length();
            AbstractC13042fc3.f(name);
            if (length3 > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C14330hk2.class.getSimpleName();
            int length4 = name.length();
            AbstractC13042fc3.f(name);
            if (length4 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.g(name, "holder type is: " + ((C15372jT7) cFindViewHolderForAdapterPosition).M(), new Object[0]);
        if (C15372jT7.class.isAnonymousClass()) {
            name2 = C15372jT7.class.getName();
            int length5 = name2.length();
            AbstractC13042fc3.f(name2);
            if (length5 > 23) {
                name2 = name2.substring(name2.length() - 23, name2.length());
                AbstractC13042fc3.h(name2, "substring(...)");
            }
        } else {
            name2 = C15372jT7.class.getSimpleName();
            int length6 = name2.length();
            AbstractC13042fc3.f(name2);
            if (length6 > 23) {
                name2 = name2.substring(0, 23);
                AbstractC13042fc3.h(name2, "substring(...)");
            }
        }
        C19406qI3.g(name2, "setting up player and setting surface view", new Object[0]);
        hb();
        Kb(this.n1);
        if (C15372jT7.class.isAnonymousClass()) {
            name3 = C15372jT7.class.getName();
            int length7 = name3.length();
            AbstractC13042fc3.f(name3);
            if (length7 > 23) {
                name3 = name3.substring(name3.length() - 23, name3.length());
                AbstractC13042fc3.h(name3, "substring(...)");
            }
        } else {
            name3 = C15372jT7.class.getSimpleName();
            int length8 = name3.length();
            AbstractC13042fc3.f(name3);
            if (length8 > 23) {
                name3 = name3.substring(0, 23);
                AbstractC13042fc3.h(name3, "substring(...)");
            }
        }
        C19406qI3.g(name3, "loading video", new Object[0]);
        Ya().T1(c15372jT7.c4(), c15372jT7.g4());
        c15372jT7.O4(Ya().z1());
        this.p1 = c15372jT7;
    }

    private final InterfaceC13730gj3 eb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new e(null), 3, null);
    }

    private final InterfaceC13730gj3 fb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new f(null), 3, null);
    }

    private final InterfaceC13730gj3 gb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new g(null), 3, null);
    }

    private final InterfaceC13730gj3 hb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new h(null), 3, null);
    }

    private final InterfaceC13730gj3 ib() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new i(null), 3, null);
    }

    private final InterfaceC13730gj3 jb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new j(null), 3, null);
    }

    private final InterfaceC13730gj3 kb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), C12366eV1.c(), null, new k(null), 2, null);
    }

    private final InterfaceC13730gj3 lb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new l(null), 3, null);
    }

    private final void mb() {
        eb();
        lb();
        fb();
    }

    private final void nb() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), C12366eV1.c(), null, new m(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ob(C14330hk2 c14330hk2) {
        AbstractC13042fc3.i(c14330hk2, "this$0");
        C6119Mg2 c6119Mg2 = c14330hk2.t1;
        if (c6119Mg2 == null) {
            AbstractC13042fc3.y("feedAdapter");
            c6119Mg2 = null;
        }
        c6119Mg2.J();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pb(C14330hk2 c14330hk2) {
        AbstractC13042fc3.i(c14330hk2, "this$0");
        C6119Mg2 c6119Mg2 = c14330hk2.t1;
        if (c6119Mg2 == null) {
            AbstractC13042fc3.y("feedAdapter");
            c6119Mg2 = null;
        }
        c6119Mg2.notifyDataSetChanged();
        return C19938rB7.a;
    }

    private final void qb() {
        Ya().z1().s(2);
        InterfaceC13730gj3 interfaceC13730gj3 = this.B1;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        if (Ya().z1().i()) {
            return;
        }
        Ya().z1().x(0L);
    }

    private final void rb() {
        C15372jT7 c15372jT7 = this.p1;
        if (c15372jT7 != null) {
            c15372jT7.O4(Ya().z1());
        }
        InterfaceC2037k interfaceC2037kZ1 = Ya().z1();
        interfaceC2037kZ1.s(0);
        this.B1 = hb();
        interfaceC2037kZ1.q();
    }

    private final InterfaceC13730gj3 tb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new n(null), 3, null);
    }

    private final void ub(boolean z2) {
        ab(false, z2);
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new o(null), 3, null);
    }

    private final void vb(RecyclerView recyclerView, int i2, float f2) {
        RecyclerView.p layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        new r(f2, recyclerView.getContext());
        if (linearLayoutManager.d2() > i2) {
            linearLayoutManager.E2(i2, 0);
        }
        linearLayoutManager.A1(0);
    }

    public static /* synthetic */ void xb(C14330hk2 c14330hk2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        c14330hk2.wb(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yb(C14330hk2 c14330hk2) {
        AbstractC13042fc3.i(c14330hk2, "this$0");
        c14330hk2.y1 = false;
    }

    private final void zb(boolean z2) {
        C6119Mg2 c6119Mg2 = this.t1;
        if (c6119Mg2 == null) {
            AbstractC13042fc3.y("feedAdapter");
            c6119Mg2 = null;
        }
        c6119Mg2.G();
        ub(z2);
        this.C1 = System.currentTimeMillis();
    }

    public final void Db(final List list, final OP5 op5, final C11458d25 c11458d25, final C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(op5, "type");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        C24398yZ.k(contextS7, interfaceC18633oz3P6, op5.j(), false, null, new UA2() { // from class: ir.nasim.ek2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C14330hk2.Eb(this.a, c11458d25, op5, list, c5886Lg2, (String) obj);
            }
        }, 16, null);
    }

    public final void Fb(final UA2 ua2) {
        Pb(new InterfaceC14603iB2() { // from class: ir.nasim.fk2
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C14330hk2.Gb(ua2, ((Integer) obj).intValue(), (OP5) obj2);
            }
        });
    }

    public final void Ga() {
        Fragment fragmentU5 = U5();
        C6614Og3 c6614Og3 = fragmentU5 instanceof C6614Og3 ? (C6614Og3) fragmentU5 : null;
        if (c6614Og3 != null && c6614Og3.D6() && D6()) {
            Ya().z1().q();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        C6119Mg2 c6119Mg2 = new C6119Mg2(Ya().A1(), Ha(), Ya().C1());
        this.t1 = c6119Mg2;
        this.u1 = c6119Mg2.N(new C13729gj2(new SA2() { // from class: ir.nasim.Wj2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14330hk2.ob(this.a);
            }
        }));
        C15225jD4.b().a(this, C15225jD4.F);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        C16731lm1 c16731lm1 = new C16731lm1(S7(), AbstractC14035hE5.Theme_Bale_Feed);
        this.w1 = c16731lm1;
        C13877gy2 c13877gy2C = C13877gy2.c(layoutInflater.cloneInContext(c16731lm1), viewGroup, false);
        AbstractC13042fc3.h(c13877gy2C, "inflate(...)");
        C20837sh2.a.e(new SA2() { // from class: ir.nasim.Xj2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14330hk2.pb(this.a);
            }
        });
        Object systemService = S7().getSystemService("window");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.r1 = point.x;
        this.s1 = point.y;
        FrameLayout root = c13877gy2C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this.p1 = null;
    }

    public final C15629ju1 Sa() {
        C15629ju1 c15629ju1 = this.l1;
        if (c15629ju1 != null) {
            return c15629ju1;
        }
        AbstractC13042fc3.y("createPostLinkUseCase");
        return null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        Ub();
        C15225jD4.b().e(this, C15225jD4.F);
        Ra().d.setAdapter(null);
        C20837sh2.a.e(null);
        this.p1 = null;
    }

    public final InterfaceC6762Ow2 Ua() {
        InterfaceC6762Ow2 interfaceC6762Ow2 = this.k1;
        if (interfaceC6762Ow2 != null) {
            return interfaceC6762Ow2;
        }
        AbstractC13042fc3.y("forwardNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void W6(boolean z2) {
        String name;
        super.W6(z2);
        if (C14330hk2.class.isAnonymousClass()) {
            name = C14330hk2.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C14330hk2.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.g(name, "onHiddenChanged, isHidden: " + z2, new Object[0]);
        if (!z2) {
            cb();
        } else {
            Ya().z1().D(false);
            Ya().z1().h();
        }
    }

    public final InterfaceC24908zP5 Wa() {
        InterfaceC24908zP5 interfaceC24908zP5 = this.j1;
        if (interfaceC24908zP5 != null) {
            return interfaceC24908zP5;
        }
        AbstractC13042fc3.y("reportNavigator");
        return null;
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void a1() {
        String name;
        super.a1();
        Ya().z1().h();
        if (C14330hk2.class.isAnonymousClass()) {
            name = C14330hk2.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C14330hk2.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.g(name, "onBalePause", new Object[0]);
    }

    public final void ab(boolean z2, boolean z3) {
        LinearLayoutManager linearLayoutManager = null;
        if (z2) {
            RecyclerView recyclerView = Ra().d;
            AbstractC13042fc3.h(recyclerView, "rvFeeds");
            LinearLayoutManager linearLayoutManager2 = this.v1;
            if (linearLayoutManager2 == null) {
                AbstractC13042fc3.y("linearLayoutManager");
            } else {
                linearLayoutManager = linearLayoutManager2;
            }
            if (Qa(recyclerView, linearLayoutManager) != 0) {
                RecyclerView recyclerView2 = Ra().d;
                AbstractC13042fc3.h(recyclerView2, "rvFeeds");
                vb(recyclerView2, 10, 1.0f);
            } else {
                RecyclerView recyclerView3 = Ra().d;
                AbstractC13042fc3.h(recyclerView3, "rvFeeds");
                Rb(recyclerView3, 10);
            }
        } else {
            LinearLayoutManager linearLayoutManager3 = this.v1;
            if (linearLayoutManager3 == null) {
                AbstractC13042fc3.y("linearLayoutManager");
            } else {
                linearLayoutManager = linearLayoutManager3;
            }
            linearLayoutManager.A1(0);
        }
        this.h1.o2();
        if (z3) {
            this.h1.t1();
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        Ya().z1().h();
        Ya().o1();
        Ub();
    }

    public final void cb() {
        String name;
        String name2;
        String name3;
        String name4;
        String name5;
        Fragment fragmentU5;
        FragmentManager fragmentManagerV5;
        List listC0;
        String name6;
        if (C14330hk2.class.isAnonymousClass()) {
            name = C14330hk2.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C14330hk2.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.g(name, "exo playbackstate: " + Ya().z1().p(), new Object[0]);
        RecyclerView recyclerView = Ra().d;
        AbstractC13042fc3.h(recyclerView, "rvFeeds");
        LinearLayoutManager linearLayoutManager = this.v1;
        Boolean boolValueOf = null;
        if (linearLayoutManager == null) {
            AbstractC13042fc3.y("linearLayoutManager");
            linearLayoutManager = null;
        }
        int iQa = Qa(recyclerView, linearLayoutManager);
        if (iQa <= -1) {
            if (C14330hk2.class.isAnonymousClass()) {
                name6 = C14330hk2.class.getName();
                int length3 = name6.length();
                AbstractC13042fc3.f(name6);
                if (length3 > 23) {
                    name6 = name6.substring(name6.length() - 23, name6.length());
                    AbstractC13042fc3.h(name6, "substring(...)");
                }
            } else {
                name6 = C14330hk2.class.getSimpleName();
                int length4 = name6.length();
                AbstractC13042fc3.f(name6);
                if (length4 > 23) {
                    name6 = name6.substring(0, 23);
                    AbstractC13042fc3.h(name6, "substring(...)");
                }
            }
            C19406qI3.g(name6, "target position -1 and video holder is: " + this.p1, new Object[0]);
            C15372jT7 c15372jT7 = this.p1;
            if (c15372jT7 == null || !c15372jT7.w4()) {
                return;
            }
            this.o1 = -1;
            C15372jT7 c15372jT72 = this.p1;
            if (c15372jT72 != null) {
                c15372jT72.E4();
            }
            Ya().z1().stop();
            Ya().z1().h();
            return;
        }
        if (iQa != this.o1 || Ya().z1().p() == 1) {
            this.o1 = iQa;
            if (C14330hk2.class.isAnonymousClass()) {
                name2 = C14330hk2.class.getName();
                int length5 = name2.length();
                AbstractC13042fc3.f(name2);
                if (length5 > 23) {
                    name2 = name2.substring(name2.length() - 23, name2.length());
                    AbstractC13042fc3.h(name2, "substring(...)");
                }
            } else {
                name2 = C14330hk2.class.getSimpleName();
                int length6 = name2.length();
                AbstractC13042fc3.f(name2);
                if (length6 > 23) {
                    name2 = name2.substring(0, 23);
                    AbstractC13042fc3.h(name2, "substring(...)");
                }
            }
            C19406qI3.g(name2, "play position target: " + iQa, new Object[0]);
            db(iQa);
            return;
        }
        if (C14330hk2.class.isAnonymousClass()) {
            name3 = C14330hk2.class.getName();
            int length7 = name3.length();
            AbstractC13042fc3.f(name3);
            if (length7 > 23) {
                name3 = name3.substring(name3.length() - 23, name3.length());
                AbstractC13042fc3.h(name3, "substring(...)");
            }
        } else {
            name3 = C14330hk2.class.getSimpleName();
            int length8 = name3.length();
            AbstractC13042fc3.f(name3);
            if (length8 > 23) {
                name3 = name3.substring(0, 23);
                AbstractC13042fc3.h(name3, "substring(...)");
            }
        }
        C19406qI3.g(name3, "video is already playing so return, pos: " + iQa, new Object[0]);
        if (Ya().z1().i()) {
            return;
        }
        if (Ya().z1().a() != null) {
            if (C14330hk2.class.isAnonymousClass()) {
                name4 = C14330hk2.class.getName();
                int length9 = name4.length();
                AbstractC13042fc3.f(name4);
                if (length9 > 23) {
                    name4 = name4.substring(name4.length() - 23, name4.length());
                    AbstractC13042fc3.h(name4, "substring(...)");
                }
            } else {
                name4 = C14330hk2.class.getSimpleName();
                int length10 = name4.length();
                AbstractC13042fc3.f(name4);
                if (length10 > 23) {
                    name4 = name4.substring(0, 23);
                    AbstractC13042fc3.h(name4, "substring(...)");
                }
            }
            C19406qI3.g(name4, "player error detected loading video", new Object[0]);
            C15372jT7 c15372jT73 = this.p1;
            if (c15372jT73 != null) {
                Ya().T1(c15372jT73.c4(), c15372jT73.g4());
                return;
            }
            return;
        }
        if (C14330hk2.class.isAnonymousClass()) {
            name5 = C14330hk2.class.getName();
            int length11 = name5.length();
            AbstractC13042fc3.f(name5);
            if (length11 > 23) {
                name5 = name5.substring(name5.length() - 23, name5.length());
                AbstractC13042fc3.h(name5, "substring(...)");
            }
        } else {
            name5 = C14330hk2.class.getSimpleName();
            int length12 = name5.length();
            AbstractC13042fc3.f(name5);
            if (length12 > 23) {
                name5 = name5.substring(0, 23);
                AbstractC13042fc3.h(name5, "substring(...)");
            }
        }
        C19406qI3.g(name5, "no player error, calling exoplyer.play()", new Object[0]);
        if (D6()) {
            Fragment fragmentU52 = U5();
            if (fragmentU52 != null && (fragmentU5 = fragmentU52.U5()) != null && (fragmentManagerV5 = fragmentU5.V5()) != null && (listC0 = fragmentManagerV5.C0()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listC0) {
                    if (obj instanceof MW6) {
                        arrayList.add(obj);
                    }
                }
                boolValueOf = Boolean.valueOf(!arrayList.isEmpty());
            }
            if (boolValueOf == null || boolValueOf.booleanValue() || !B6() || w6()) {
                return;
            }
            Ya().z1().q();
        }
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int i2, Object... objArr) {
        AbstractC13042fc3.i(objArr, "args");
        if (i2 == C15225jD4.F) {
            Ub();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        C16731lm1 c16731lm1 = this.w1;
        C6119Mg2 c6119Mg2 = null;
        if (c16731lm1 == null) {
            AbstractC13042fc3.y("contextThemeWrapper");
            c16731lm1 = null;
        }
        this.v1 = new LinearLayoutManager(c16731lm1, 1, false);
        RecyclerView recyclerView = Ra().d;
        LinearLayoutManager linearLayoutManager = this.v1;
        if (linearLayoutManager == null) {
            AbstractC13042fc3.y("linearLayoutManager");
            linearLayoutManager = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = Ra().d;
        androidx.recyclerview.widget.f fVar = this.u1;
        if (fVar == null) {
            AbstractC13042fc3.y("feedConcatAdapter");
            fVar = null;
        }
        recyclerView2.setAdapter(fVar);
        C6119Mg2 c6119Mg22 = this.t1;
        if (c6119Mg22 == null) {
            AbstractC13042fc3.y("feedAdapter");
        } else {
            c6119Mg2 = c6119Mg22;
        }
        c6119Mg2.E();
        SX7 sx7 = this.x1;
        RecyclerView recyclerView3 = Ra().d;
        AbstractC13042fc3.h(recyclerView3, "rvFeeds");
        sx7.j(recyclerView3, new p(Ya()), new q(Ya()));
        Kb(this.n1);
        Ya().m2();
        Jb();
        Ib();
        jb();
        cb();
        gb();
        mb();
        nb();
        tb();
        Fa();
        Sb();
        kb();
    }

    public final void sb() {
        Ya().z1().D(false);
        Ub();
    }

    public final void wb(boolean z2) {
        String name;
        if (C14330hk2.class.isAnonymousClass()) {
            name = C14330hk2.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C14330hk2.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.g(name, "refresh requested disabling feed item touch", new Object[0]);
        this.y1 = true;
        Ra().d.postDelayed(new Runnable() { // from class: ir.nasim.Rj2
            @Override // java.lang.Runnable
            public final void run() {
                C14330hk2.yb(this.a);
            }
        }, 500L);
        Ya().s1();
        zb(z2);
        db(0);
    }
}
