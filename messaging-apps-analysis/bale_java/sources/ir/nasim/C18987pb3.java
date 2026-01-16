package ir.nasim;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC12888fL4;
import ir.nasim.C14486i0;
import ir.nasim.C18987pb3;
import ir.nasim.InterfaceC10156bA3;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView;
import ir.nasim.features.bank.FastChargeBottomSheetContentView;
import ir.nasim.features.bank.mybank.webview.a;
import ir.nasim.features.bank.wallet.WalletPayBottomsheetContentView;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import ir.nasim.features.pfm.PFMActivity;
import ir.nasim.features.pfm.entity.PFMTransaction;
import ir.nasim.features.root.AbstractC13089g;
import ir.nasim.features.root.C13090h;
import ir.nasim.features.root.EmptyStateOnboardingItemAction;
import ir.nasim.features.root.RootActivity;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* renamed from: ir.nasim.pb3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18987pb3 {
    public static final C18987pb3 a = new C18987pb3();
    private static final InterfaceC9173Yu3 b;
    private static final InterfaceC9173Yu3 c;
    private static final InterfaceC9173Yu3 d;
    private static final InterfaceC9173Yu3 e;
    private static final InterfaceC9173Yu3 f;
    private static final InterfaceC9173Yu3 g;
    private static final InterfaceC9173Yu3 h;
    private static final NotificationManager i;
    private static KS2 j;
    private static final String[] k;
    private static final String l;
    private static final String m;
    private static final String[] n;
    private static final String[] o;
    private static final String[] p;
    public static final int q;

    /* renamed from: ir.nasim.pb3$a */
    public static final class a implements InterfaceC15419jZ0 {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            if (num == null) {
                return;
            }
            C18987pb3 c18987pb3 = C18987pb3.a;
            C11458d25 c11458d25Y = C11458d25.y(num.intValue());
            AbstractC13042fc3.h(c11458d25Y, "group(...)");
            C18987pb3.x1(c18987pb3, c11458d25Y, null, null, false, null, null, false, null, null, false, null, 2046, null);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            AbstractC13042fc3.i(exc, "e");
            Toast.makeText(this.a, UN2.a(exc, ZN2.GROUP), 0).show();
        }
    }

    /* renamed from: ir.nasim.pb3$b */
    public static final class b implements InterfaceC15419jZ0 {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(C4382Ew7 c4382Ew7, String str) {
            C21231tK7[] c21231tK7Arr;
            C21231tK7 c21231tK7;
            if (c4382Ew7 == null) {
                return;
            }
            Object[] objArr = (Object[]) c4382Ew7.b();
            if (objArr == null || objArr.length == 0) {
                Object[] objArr2 = (Object[]) c4382Ew7.a();
                if (objArr2 == null || objArr2.length == 0 || (c21231tK7Arr = (C21231tK7[]) c4382Ew7.a()) == null || (c21231tK7 = (C21231tK7) AbstractC10242bK.e0(c21231tK7Arr)) == null || !c21231tK7.y()) {
                    return;
                }
                C18987pb3 c18987pb3 = C18987pb3.a;
                C11458d25 c11458d25E = C11458d25.E(c21231tK7.o());
                AbstractC13042fc3.h(c11458d25E, "user(...)");
                c18987pb3.v1(c11458d25E, str);
                return;
            }
            Object objB = c4382Ew7.b();
            AbstractC13042fc3.h(objB, "getT2(...)");
            C14733iO2 c14733iO2 = (C14733iO2) AbstractC10242bK.e0((Object[]) objB);
            if (c14733iO2 == null) {
                return;
            }
            if (((Boolean) c14733iO2.F().b()).booleanValue() || c14733iO2.q() == ZN2.CHANNEL) {
                C11458d25 c11458d25Y = C11458d25.y(c14733iO2.r());
                AbstractC13042fc3.h(c11458d25Y, "group(...)");
                C18987pb3.a.v1(c11458d25Y, str);
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(final C4382Ew7 c4382Ew7) {
            final String str = this.a;
            AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.qb3
                @Override // java.lang.Runnable
                public final void run() {
                    C18987pb3.b.d(c4382Ew7, str);
                }
            });
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            AbstractC13042fc3.i(exc, "e");
            throw new RuntimeException(exc);
        }
    }

    /* renamed from: ir.nasim.pb3$c */
    public static final class c implements InterfaceC15419jZ0 {
        final /* synthetic */ URL a;

        c(URL url) {
            this.a = url;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C4382Ew7 c4382Ew7) {
            C21231tK7[] c21231tK7Arr;
            C21231tK7 c21231tK7;
            if (c4382Ew7 == null || (c21231tK7Arr = (C21231tK7[]) c4382Ew7.a()) == null || (c21231tK7 = (C21231tK7) AbstractC10242bK.e0(c21231tK7Arr)) == null) {
                return;
            }
            C11458d25 c11458d25E = C11458d25.E(c21231tK7.o());
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
            long peerId = c11458d25E.getPeerId();
            String query = this.a.getQuery();
            AbstractC13042fc3.h(query, "getQuery(...)");
            abstractC13089gK.T9(c11458d25E, peerId, Separators.SLASH + AbstractC20153rZ6.M(query, Separators.EQUALS, Separators.SP, false, 4, null));
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            AbstractC13042fc3.i(exc, "e");
        }
    }

    /* renamed from: ir.nasim.pb3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Intent c;
        final /* synthetic */ Map d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Intent intent, Map map, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = intent;
            this.d = map;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String lowerCase;
            ExPeerType exPeerType;
            String strName;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C9615aG2 c9615aG2 = (C9615aG2) C18987pb3.f.getValue();
                String stringExtra = this.c.getStringExtra("buttonActionCommand");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                this.b = 1;
                obj = c9615aG2.e(stringExtra, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC10156bA3 interfaceC10156bA3 = (InterfaceC10156bA3) obj;
            Map map = this.d;
            ExPeer exPeerC = interfaceC10156bA3.c();
            XV4 xv4A = AbstractC4616Fw7.a("peer_id", AbstractC6392Nk0.d(exPeerC != null ? exPeerC.getPeerId() : 0));
            if (interfaceC10156bA3 instanceof InterfaceC10156bA3.a) {
                lowerCase = "external_url";
            } else if (interfaceC10156bA3 instanceof C12179eA3) {
                lowerCase = "deep_link";
            } else {
                ExPeer exPeerC2 = interfaceC10156bA3.c();
                if (exPeerC2 == null || (exPeerType = exPeerC2.getExPeerType()) == null || (strName = exPeerType.name()) == null) {
                    lowerCase = null;
                } else {
                    lowerCase = strName.toLowerCase(Locale.ROOT);
                    AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                }
            }
            map.putAll(AbstractC20051rO3.n(xv4A, AbstractC4616Fw7.a("peer_type", lowerCase != null ? lowerCase : "")));
            C3343Am.i("push", this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static {
        InterfaceC9173Yu3 interfaceC9173Yu3A = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Va3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18987pb3.Z1();
            }
        });
        b = interfaceC9173Yu3A;
        c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.gb3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18987pb3.L();
            }
        });
        d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.hb3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18987pb3.c2();
            }
        });
        e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ib3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18987pb3.V1();
            }
        });
        f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jb3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18987pb3.f1();
            }
        });
        g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.kb3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18987pb3.y();
            }
        });
        h = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.lb3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18987pb3.w();
            }
        });
        Object systemService = C5721Ko.a.d().getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        i = (NotificationManager) systemService;
        k = new String[]{"https://ble.ir/", "http://ble.ir/", "nasim://", "bale://", "ble.ir"};
        l = Separators.SLASH + ((SettingsModule) interfaceC9173Yu3A.getValue()).n1() + Separators.SLASH;
        m = ((SettingsModule) interfaceC9173Yu3A.getValue()).I0();
        n = new String[]{"http://ble.ir/mybank-gift-packet", "https://ble.ir/mybank-gift-packet", "bale://ble.ir/mybank-gift-packet", "ble://ble.ir/mybank-gift-packet"};
        o = new String[]{"http://ble.ir/mybank-money-request", "https://ble.ir/mybank-money-request", "bale://ble.ir/mybank-money-request", "ble://ble.ir/mybank-money-request"};
        p = new String[]{"http://ble.ir/mybank-crowdfunding", "https://ble.ir/mybank-crowdfunding", "bale://ble.ir/mybank-crowdfunding", "ble://ble.ir/mybank-crowdfunding"};
        q = 8;
    }

    private C18987pb3() {
    }

    private final boolean A(String str) {
        for (String str2 : n) {
            if (AbstractC20153rZ6.D(str, str2, true)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(String str, String str2, Activity activity, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(activity, "$activity");
        C18987pb3 c18987pb3 = a;
        AbstractC13042fc3.f(c4382Ew7);
        ExPeer exPeerI = c18987pb3.I(c4382Ew7);
        if (exPeerI == null) {
            return;
        }
        InterfaceC11677dQ0 interfaceC11677dQ0G = c18987pb3.G();
        C11458d25 c11458d25 = new C11458d25(exPeerI);
        ExPeerType exPeerType = exPeerI.getExPeerType();
        AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
        ExPeerType exPeerType2 = exPeerI.getExPeerType();
        ExPeerType exPeerType3 = ExPeerType.BOT;
        c18987pb3.b2(activity, InterfaceC11677dQ0.b(interfaceC11677dQ0G, c11458d25, exPeerType, null, null, false, null, null, null, null, 0L, null, null, exPeerType2 == exPeerType3 ? str : null, false, null, null, null, null, null, false, null, null, null, null, (exPeerI.getExPeerType() == ExPeerType.PRIVATE || exPeerI.getExPeerType() == exPeerType3) ? str2 : null, false, null, 117436412, null));
    }

    private final boolean A1(C11458d25 c11458d25, Long l2, Long l3, boolean z, String str, String str2, boolean z2, boolean z3, C11458d25 c11458d252, Boolean bool, boolean z4, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction) {
        AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        if (abstractC13089gK == null) {
            return false;
        }
        if (!abstractC13089gK.Q7().isFinishing() && !abstractC13089gK.h9()) {
            abstractC13089gK.Z9(c11458d25, l2, l3, z, str, str2, z2, z3, c11458d252, bool, z4, emptyStateOnboardingItemAction);
            return true;
        }
        abstractC13089gK.pa(c11458d25);
        abstractC13089gK.oa(null);
        return true;
    }

    private final boolean B(String str) {
        for (String str2 : o) {
            if (AbstractC20153rZ6.D(str, str2, true)) {
                return true;
            }
        }
        return false;
    }

    private static final String B0(String str) {
        String str2 = AbstractC20762sZ6.S0(str, '@', false, 2, null) ? str : null;
        if (str2 == null) {
            return str;
        }
        String str3 = Separators.SP + str2;
        return str3 == null ? str : str3;
    }

    static /* synthetic */ boolean B1(C18987pb3 c18987pb3, C11458d25 c11458d25, Long l2, Long l3, boolean z, String str, String str2, boolean z2, boolean z3, C11458d25 c11458d252, Boolean bool, boolean z4, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction, int i2, Object obj) {
        return c18987pb3.A1(c11458d25, l2, l3, z, str, str2, z2, z3, c11458d252, bool, z4, (i2 & 2048) != 0 ? EmptyStateOnboardingItemAction.NotOpened.e : emptyStateOnboardingItemAction);
    }

    private final boolean C(Set set, String str) {
        Set set2 = set;
        if ((set2 instanceof Collection) && set2.isEmpty()) {
            return false;
        }
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            if (AbstractC20153rZ6.D((String) it.next(), str, true)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean C0(android.content.Intent r17) throws java.lang.NumberFormatException {
        /*
            r16 = this;
            android.net.Uri r0 = r17.getData()
            r1 = 0
            if (r0 == 0) goto La7
            java.lang.String r2 = r0.toString()
            java.lang.String r3 = "toString(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r3)
            java.lang.String r3 = "chat"
            r4 = 2
            r5 = 0
            boolean r2 = ir.nasim.AbstractC14836iZ6.X(r2, r3, r1, r4, r5)
            if (r2 == 0) goto La7
            java.lang.String r2 = "uid"
            java.lang.String r2 = r0.getQueryParameter(r2)
            java.lang.String r3 = "threadId"
            java.lang.String r0 = r0.getQueryParameter(r3)
            if (r2 == 0) goto La7
            if (r0 == 0) goto La7
            ir.nasim.sM5 r3 = new ir.nasim.sM5
            java.lang.String r4 = "_"
            r3.<init>(r4)
            java.util.List r0 = r3.m(r0, r1)
            boolean r3 = r0.isEmpty()
            r4 = 1
            if (r3 != 0) goto L63
            int r3 = r0.size()
            java.util.ListIterator r3 = r0.listIterator(r3)
        L44:
            boolean r6 = r3.hasPrevious()
            if (r6 == 0) goto L63
            java.lang.Object r6 = r3.previous()
            java.lang.String r6 = (java.lang.String) r6
            int r6 = r6.length()
            if (r6 != 0) goto L57
            goto L44
        L57:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            int r3 = r3.nextIndex()
            int r3 = r3 + r4
            java.util.List r0 = ir.nasim.ZW0.f1(r0, r3)
            goto L67
        L63:
            java.util.List r0 = ir.nasim.ZW0.m()
        L67:
            java.util.Collection r0 = (java.util.Collection) r0
            java.lang.String[] r3 = new java.lang.String[r1]
            java.lang.Object[] r0 = r0.toArray(r3)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r3 = r0.length
            if (r3 != 0) goto L76
            r3 = r4
            goto L77
        L76:
            r3 = r1
        L77:
            r3 = r3 ^ r4
            if (r3 == 0) goto L7d
            r3 = r0[r1]
            goto L7e
        L7d:
            r3 = r5
        L7e:
            int r6 = r0.length
            if (r6 <= r4) goto L83
            r5 = r0[r4]
        L83:
            if (r3 == 0) goto La7
            if (r5 == 0) goto La7
            long r0 = java.lang.Long.parseLong(r2)
            long r10 = java.lang.Long.parseLong(r5)
            long r8 = java.lang.Long.parseLong(r3)
            ir.nasim.d25 r0 = ir.nasim.C11458d25.r(r0)
            int r7 = r0.getPeerId()
            r14 = 16
            r15 = 0
            r12 = 1
            r13 = 0
            r6 = r16
            boolean r0 = m1(r6, r7, r8, r10, r12, r13, r14, r15)
            return r0
        La7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18987pb3.C0(android.content.Intent):boolean");
    }

    private final boolean D(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (!URLUtil.isValidUrl(str)) {
            Locale locale = Locale.getDefault();
            AbstractC13042fc3.h(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            if (!AbstractC20153rZ6.S(lowerCase, "ble:", false, 2, null)) {
                return false;
            }
        }
        return true;
    }

    private final boolean D0(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || intent.getAction() == null || !AbstractC13042fc3.d(intent.getAction(), "EXTRA_ACTION_OPEN_PEER")) {
            return false;
        }
        C11458d25 c11458d25R = C11458d25.r(extras.getLong("chat_peer", 0L));
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        long j2 = extras.getLong("chat_rid", 0L);
        long j3 = extras.getLong("chat_sort_key", 0L);
        boolean z = extras.getBoolean("chat_shouldLoadMessage", false);
        String string = extras.getString("chat_jaryan_tab_type", null);
        String string2 = extras.getString("chat_message", null);
        if (c11458d25R.getPeerId() == 0) {
            return false;
        }
        p1(this, c11458d25R, Long.valueOf(j2), Long.valueOf(j3), z, string2, string, false, false, 192, null);
        return true;
    }

    private final void D1(String str, Activity activity) {
        List listM;
        List listM2;
        if (str == null || str.length() == 0) {
            return;
        }
        String[] strArr = null;
        if (AbstractC20762sZ6.X(str, "join", false, 2, null)) {
            List listM3 = new C20644sM5("/join/").m(str, 0);
            if (listM3.isEmpty()) {
                listM2 = AbstractC10360bX0.m();
                strArr = (String[]) listM2.toArray(new String[0]);
            } else {
                ListIterator listIterator = listM3.listIterator(listM3.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listM2 = AbstractC15401jX0.f1(listM3, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listM2 = AbstractC10360bX0.m();
                strArr = (String[]) listM2.toArray(new String[0]);
            }
        } else if (AbstractC20762sZ6.X(str, "token", false, 2, null)) {
            List listM4 = new C20644sM5(" =").m(str, 0);
            if (listM4.isEmpty()) {
                listM = AbstractC10360bX0.m();
                strArr = (String[]) listM.toArray(new String[0]);
            } else {
                ListIterator listIterator2 = listM4.listIterator(listM4.size());
                while (listIterator2.hasPrevious()) {
                    if (((String) listIterator2.previous()).length() != 0) {
                        listM = AbstractC15401jX0.f1(listM4, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                listM = AbstractC10360bX0.m();
                strArr = (String[]) listM.toArray(new String[0]);
            }
        }
        if (strArr == null || strArr.length == 0) {
            return;
        }
        final String str2 = strArr[strArr.length - 1];
        C19406qI3.a("Source_Join_Cause", "intent handler openInviteLink()", new Object[0]);
        AbstractC13042fc3.g(activity, "null cannot be cast to non-null type ir.nasim.designsystem.base.activity.BaseActivity");
        ((BaseActivity) activity).F1(new InterfaceC14830iZ0() { // from class: ir.nasim.db3
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                C18987pb3.E1(str2, interfaceC15419jZ0);
            }
        }, AbstractC12217eE5.invite_link_title, new a(activity));
    }

    private final Integer E(String str) {
        String[] strArr;
        List listM;
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase, "/uid#/", false, 2, null)) {
            List listM2 = new C20644sM5("/uid#/").m(lowerCase, 0);
            if (listM2.isEmpty()) {
                listM = AbstractC10360bX0.m();
                strArr = (String[]) listM.toArray(new String[0]);
            } else {
                ListIterator listIterator = listM2.listIterator(listM2.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listM = AbstractC15401jX0.f1(listM2, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listM = AbstractC10360bX0.m();
                strArr = (String[]) listM.toArray(new String[0]);
            }
        } else {
            strArr = null;
        }
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(strArr[strArr.length - 1]));
    }

    private final boolean E0(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            String string = data.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            if (AbstractC20762sZ6.X(string, "create-channel", false, 2, null)) {
                AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
                if (abstractC13089gK == null || abstractC13089gK.h9()) {
                    return true;
                }
                abstractC13089gK.ra();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(String str, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "callback");
        ((C10299bQ2) c.getValue()).n2(str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.eb3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C18987pb3.F1(interfaceC15419jZ0, (Integer) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.fb3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C18987pb3.G1(interfaceC15419jZ0, (Exception) obj);
            }
        });
    }

    private final boolean F0(Activity activity) {
        try {
            InterfaceC9173Yu3 interfaceC9173Yu3 = e;
            if (!((InterfaceC3570Bk5) interfaceC9173Yu3.getValue()).h("is_manage_card_clicked", false)) {
                ((InterfaceC3570Bk5) interfaceC9173Yu3.getValue()).g("is_manage_card_clicked", true);
            }
            CardPaymentActivity.INSTANCE.e(activity, null);
            return true;
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(InterfaceC15419jZ0 interfaceC15419jZ0, Integer num) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        interfaceC15419jZ0.a(num);
    }

    private final InterfaceC11677dQ0 G() {
        return (InterfaceC11677dQ0) h.getValue();
    }

    private final boolean G0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(InterfaceC15419jZ0 interfaceC15419jZ0, Exception exc) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        interfaceC15419jZ0.onError(exc);
    }

    private final C8054Ui1 H() {
        return (C8054Ui1) g.getValue();
    }

    private final boolean H0(Intent intent) {
        if (intent == null || !AbstractC13042fc3.d("ir.nasim.OPEN_ACCOUNT", intent.getAction())) {
            return false;
        }
        C22042ua0.A9(C5735Kp4.w().k(), InterfaceC7981Ua0.INSTANCE.a().d(), false, null, 6, null);
        return true;
    }

    private final void H1(String str, boolean z) {
        List listM;
        List listM2;
        if (str == null || str.length() == 0) {
            return;
        }
        String[] strArr = null;
        if (AbstractC20762sZ6.X(str, "join", false, 2, null)) {
            List listM3 = new C20644sM5("/join/").m(str, 0);
            if (listM3.isEmpty()) {
                listM2 = AbstractC10360bX0.m();
                strArr = (String[]) listM2.toArray(new String[0]);
            } else {
                ListIterator listIterator = listM3.listIterator(listM3.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listM2 = AbstractC15401jX0.f1(listM3, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listM2 = AbstractC10360bX0.m();
                strArr = (String[]) listM2.toArray(new String[0]);
            }
        } else if (AbstractC20762sZ6.X(str, "token", false, 2, null)) {
            List listM4 = new C20644sM5(" =").m(str, 0);
            if (listM4.isEmpty()) {
                listM = AbstractC10360bX0.m();
                strArr = (String[]) listM.toArray(new String[0]);
            } else {
                ListIterator listIterator2 = listM4.listIterator(listM4.size());
                while (listIterator2.hasPrevious()) {
                    if (((String) listIterator2.previous()).length() != 0) {
                        listM = AbstractC15401jX0.f1(listM4, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                listM = AbstractC10360bX0.m();
                strArr = (String[]) listM.toArray(new String[0]);
            }
        }
        if (strArr == null || strArr.length == 0) {
            return;
        }
        String str2 = strArr[strArr.length - 1];
        Bundle bundle = new Bundle();
        bundle.putString("INVITE_WITH_TOKEN_ARG", str2);
        bundle.putBoolean("INVITE_FROM_OUT_OF_BALE_ARG", !z);
        RootActivity.INSTANCE.h(C5721Ko.a.d(), "INVITE_WITH_TOKEN", bundle);
    }

    private final ExPeer I(C4382Ew7 c4382Ew7) {
        Object[] objArr = (Object[]) c4382Ew7.a();
        if (objArr != null && objArr.length != 0) {
            Object objA = c4382Ew7.a();
            AbstractC13042fc3.h(objA, "getT1(...)");
            ExPeerType exPeerTypeN = ((C21231tK7) AbstractC10242bK.b0((Object[]) objA)).n();
            Object objA2 = c4382Ew7.a();
            AbstractC13042fc3.h(objA2, "getT1(...)");
            return new ExPeer(exPeerTypeN, ((C21231tK7) AbstractC10242bK.b0((Object[]) objA2)).o());
        }
        Object[] objArr2 = (Object[]) c4382Ew7.b();
        if (objArr2 == null || objArr2.length == 0) {
            return null;
        }
        Object objB = c4382Ew7.b();
        AbstractC13042fc3.h(objB, "getT2(...)");
        ExPeerType exPeerTypeP = ((C14733iO2) AbstractC10242bK.b0((Object[]) objB)).p();
        Object objB2 = c4382Ew7.b();
        AbstractC13042fc3.h(objB2, "getT2(...)");
        return new ExPeer(exPeerTypeP, ((C14733iO2) AbstractC10242bK.b0((Object[]) objB2)).r());
    }

    private final boolean I0(Uri uri) {
        String strA = AbstractC7546Se2.a(uri, "url");
        if (strA == null) {
            return false;
        }
        String str = null;
        if (!(!AbstractC20762sZ6.n0(strA))) {
            strA = null;
        }
        if (strA == null) {
            return false;
        }
        String strA2 = AbstractC7546Se2.a(uri, ParameterNames.TEXT);
        Intent intent = new Intent("android.intent.action.SEND");
        if (strA2 != null) {
            str = Separators.RETURN + strA2;
        }
        if (str == null) {
            str = "";
        }
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", strA + str);
        RootActivity.INSTANCE.g(C5721Ko.a.d(), intent);
        return true;
    }

    private final void I1(String str, String str2) {
        InterfaceC15501jh3 interfaceC15501jh3Y0 = ((InterfaceC20169rb3) C92.a(C5721Ko.a.d(), InterfaceC20169rb3.class)).Y0();
        if (str == null) {
            str = "";
        }
        if (str2 == null || str2.length() == 0) {
            C22042ua0.w9(C5735Kp4.w().k(), interfaceC15501jh3Y0.a(str, EnumC8772Xg3.b), false, null, 6, null);
        } else {
            C22042ua0.w9(C5735Kp4.w().k(), interfaceC15501jh3Y0.a(str, EnumC8772Xg3.valueOf(str2)), false, null, 6, null);
        }
    }

    private final String J(Intent intent) {
        if (intent != null && intent.getAction() != null && AbstractC13042fc3.d(intent.getAction(), "android.intent.action.VIEW") && intent.getData() != null) {
            return String.valueOf(intent.getData());
        }
        if (intent == null || intent.getExtras() == null) {
            return "";
        }
        Bundle extras = intent.getExtras();
        if ((extras != null ? extras.getString("firebase_banking_command") : null) == null) {
            return "";
        }
        Bundle extras2 = intent.getExtras();
        String string = extras2 != null ? extras2.getString("firebase_banking_command") : null;
        return string == null ? "" : string;
    }

    private final void J0() {
        C5735Kp4.w().k().fa();
    }

    private final String K() {
        String strC = ((InterfaceC15767k82) C92.a(C5721Ko.a.d(), InterfaceC15767k82.class)).z().c("bale_source", "");
        return strC == null ? "" : strC;
    }

    private final void K0() {
        C5735Kp4.w().k().ga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10299bQ2 L() {
        Context context = AbstractC14047hG.a;
        AbstractC13042fc3.h(context, "applicationContext");
        return ((InterfaceC9291Zh4) C92.a(context, InterfaceC9291Zh4.class)).m0();
    }

    private final void L0(String str) {
        AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        if (abstractC13089gK != null) {
            abstractC13089gK.da(str);
        }
    }

    public static final void L1(EnumC14097hL4 enumC14097hL4) {
        AbstractC13042fc3.i(enumC14097hL4, "openedPFMFrom");
        Bundle bundle = new Bundle();
        bundle.putString("arg_pfm_from", enumC14097hL4.toString());
        RootActivity.INSTANCE.h(C5721Ko.a.d(), "action_open_pfm", bundle);
    }

    private final boolean M(Intent intent) {
        return C0(intent) || E0(intent) || s0(intent) || V0(intent) || R0(intent) || r0(intent) || j1(intent) || N(intent) || D0(intent) || t0(intent) || H0(intent) || U(intent) || y0(intent) || y0(intent);
    }

    private final boolean M0(Uri uri, ExPeer exPeer, Activity activity) {
        String strA = AbstractC7546Se2.a(uri, "startapp");
        if (strA == null) {
            return false;
        }
        EnumC23552x68 enumC23552x68A = EnumC23552x68.a.a(AbstractC7546Se2.a(uri, "mode"));
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.isEmpty()) {
            return false;
        }
        String str = pathSegments.get(0);
        AbstractC13042fc3.f(pathSegments);
        String str2 = (String) AbstractC15401jX0.t0(pathSegments, 1);
        if (!(activity instanceof RootActivity)) {
            C19406qI3.a("IntentHandler", "Activity must be RootActivity", new Object[0]);
            return false;
        }
        AbstractC13042fc3.f(str);
        ((RootActivity) activity).O4(str, str2, strA, enumC23552x68A, exPeer);
        return true;
    }

    private final void M1(String str, Activity activity) {
        if (activity != null) {
            C14486i0 c14486i0A = C14486i0.f.a((AppCompatActivity) activity);
            WalletPayBottomsheetContentView walletPayBottomsheetContentView = new WalletPayBottomsheetContentView(activity);
            walletPayBottomsheetContentView.setAbolInstance(c14486i0A);
            walletPayBottomsheetContentView.setWalletId(str);
            walletPayBottomsheetContentView.Z();
            c14486i0A.o(walletPayBottomsheetContentView);
        }
    }

    private final boolean N(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null && extras.getBoolean("app_shortcut_intent", false)) {
            C11458d25 c11458d25R = C11458d25.r(extras.getLong("chat_peer", 0L));
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            if (c11458d25R.getPeerId() != 0) {
                v1(c11458d25R, "/start");
                return true;
            }
        }
        return false;
    }

    private final boolean N0(Activity activity, EnumC13506gL4 enumC13506gL4, PFMTransaction pFMTransaction) {
        activity.startActivity(PFMActivity.INSTANCE.b(activity, EnumC14097hL4.c, enumC13506gL4, pFMTransaction));
        return true;
    }

    private final void N1(String str, String str2) {
        AbstractC5969Lp4.d().I(str).a(new b(str2));
    }

    private final boolean O() {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.cb3
            @Override // java.lang.Runnable
            public final void run() {
                C18987pb3.P();
            }
        });
        return true;
    }

    private final boolean O0(Uri uri, Activity activity) {
        if (!C8386Vt0.a.X8()) {
            return false;
        }
        AbstractC13042fc3.g(activity, "null cannot be cast to non-null type ir.nasim.features.root.RootActivity");
        String string = uri.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        ((RootActivity) activity).C4(string);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0130 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0193 A[Catch: Exception -> 0x01e0, TryCatch #0 {Exception -> 0x01e0, blocks: (B:62:0x0189, B:64:0x0193, B:66:0x01ae), top: B:70:0x0189 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean O1(java.lang.String r15) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18987pb3.O1(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P() {
        C22042ua0.A9(C5735Kp4.w().k(), new SG(), false, null, 6, null);
    }

    private final boolean P0(Intent intent, Activity activity) {
        Bundle extras;
        String string;
        if (intent.getAction() == null || !AbstractC13042fc3.d(intent.getAction(), "bale.ai.payment") || (extras = intent.getExtras()) == null || (string = extras.getString("token")) == null) {
            return false;
        }
        if (extras.getBoolean("result", false)) {
            AbstractC13042fc3.g(activity, "null cannot be cast to non-null type ir.nasim.features.root.RootActivity");
            ((RootActivity) activity).U3();
            return true;
        }
        AbstractC13042fc3.g(activity, "null cannot be cast to non-null type ir.nasim.features.root.RootActivity");
        ((RootActivity) activity).f3(string);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(long j2, long j3, C14733iO2[] c14733iO2Arr) {
        C14733iO2 c14733iO2;
        C14697iL2 c14697iL2;
        AbstractC13042fc3.f(c14733iO2Arr);
        if (c14733iO2Arr.length == 0 || (c14733iO2 = (C14733iO2) AbstractC10242bK.e0(c14733iO2Arr)) == null || (c14697iL2 = (C14697iL2) ((C10299bQ2) c.getValue()).X1().d(c14733iO2.r())) == null) {
            return;
        }
        C18987pb3 c18987pb3 = a;
        C11458d25 c11458d25Y = C11458d25.y(c14697iL2.p0());
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        x1(c18987pb3, c11458d25Y, Long.valueOf(j2), Long.valueOf(j3), true, null, null, false, null, null, false, null, 2032, null);
    }

    private final boolean Q(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (!D(strJ) || !c1(strJ)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase, "mybank/p1", false, 2, null)) {
            C14486i0.a aVar = C14486i0.f;
            AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
            Context baseContext = activity.getBaseContext();
            AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
            if (!C4100Dr4.a(baseContext)) {
                Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
                return true;
            }
            String strQ4 = ((SettingsModule) b.getValue()).Q4();
            if (strQ4.length() > 0) {
                c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, strQ4, c14486i0A, null, null, 32, null));
                return true;
            }
        }
        return false;
    }

    private final boolean Q0(Intent intent) {
        String strJ = J(intent);
        if (strJ.length() > 0) {
            return O1(strJ);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(int i2, long j2, long j3, C14505i18 c14505i18) {
        if (((C14697iL2) AbstractC5969Lp4.d().Y().E().X1().d(i2)) != null) {
            C18987pb3 c18987pb3 = a;
            C11458d25 c11458d25Y = C11458d25.y(i2);
            AbstractC13042fc3.h(c11458d25Y, "group(...)");
            x1(c18987pb3, c11458d25Y, Long.valueOf(j2), Long.valueOf(j3), true, null, null, false, null, null, false, null, 2032, null);
        }
    }

    private final boolean R(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (!D(strJ) || !c1(strJ)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        Locale locale2 = Locale.getDefault();
        AbstractC13042fc3.h(locale2, "getDefault(...)");
        String lowerCase2 = "mybank/P2Ppayment".toLowerCase(locale2);
        AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase, lowerCase2, false, 2, null)) {
            C14486i0.a aVar = C14486i0.f;
            AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
            Context baseContext = activity.getBaseContext();
            AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
            if (!C4100Dr4.a(baseContext)) {
                Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
                return true;
            }
            String strR4 = ((SettingsModule) b.getValue()).R4();
            if (strR4.length() > 0) {
                c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, strR4, c14486i0A, null, null, 32, null));
                return true;
            }
        }
        return false;
    }

    private final boolean R0(Intent intent) {
        String strJ = J(intent);
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (!AbstractC20762sZ6.X(lowerCase, "/uid#/", false, 2, null)) {
            return false;
        }
        S1(strJ);
        return true;
    }

    private final void R1(Activity activity) {
        CardPaymentActivity.INSTANCE.d(activity);
    }

    private final boolean S(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (!D(strJ) || !c1(strJ)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase, "mybank/wallet", false, 2, null)) {
            C14486i0.a aVar = C14486i0.f;
            AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
            Context baseContext = activity.getBaseContext();
            AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
            if (!C4100Dr4.a(baseContext)) {
                Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
                return true;
            }
            String strS4 = ((SettingsModule) b.getValue()).S4();
            if (strS4.length() > 0) {
                c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, strS4, c14486i0A, null, null, 32, null));
                return true;
            }
        }
        return false;
    }

    private final boolean S0(Activity activity) {
        R1(activity);
        return true;
    }

    private final void S1(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        T1(E(str));
    }

    private final boolean T(Intent intent, Activity activity) {
        String strJ = J(intent);
        CardPaymentActivity.Companion aVar = CardPaymentActivity.INSTANCE;
        if (aVar.b(intent)) {
            aVar.e(activity, intent.getData());
            return true;
        }
        if (d1(strJ)) {
            return W(strJ, activity);
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase, "banking-remain", false, 2, null)) {
            return S0(activity);
        }
        Locale locale2 = Locale.getDefault();
        AbstractC13042fc3.h(locale2, "getDefault(...)");
        String lowerCase2 = strJ.toLowerCase(locale2);
        AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase2, "banking-my-bank-page", false, 2, null)) {
            return p0(strJ);
        }
        Locale locale3 = Locale.getDefault();
        AbstractC13042fc3.h(locale3, "getDefault(...)");
        String lowerCase3 = strJ.toLowerCase(locale3);
        AbstractC13042fc3.h(lowerCase3, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase3, "market-market-page", false, 2, null)) {
            return o0();
        }
        Locale locale4 = Locale.getDefault();
        AbstractC13042fc3.h(locale4, "getDefault(...)");
        String lowerCase4 = strJ.toLowerCase(locale4);
        AbstractC13042fc3.h(lowerCase4, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase4, "banking-vitrine", false, 2, null)) {
            return c0(true);
        }
        Locale locale5 = Locale.getDefault();
        AbstractC13042fc3.h(locale5, "getDefault(...)");
        String lowerCase5 = strJ.toLowerCase(locale5);
        AbstractC13042fc3.h(lowerCase5, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase5, "feed-page", false, 2, null)) {
            return h0(false);
        }
        Locale locale6 = Locale.getDefault();
        AbstractC13042fc3.h(locale6, "getDefault(...)");
        String lowerCase6 = strJ.toLowerCase(locale6);
        AbstractC13042fc3.h(lowerCase6, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase6, "banking-fast-charge", false, 2, null)) {
            return d0(activity);
        }
        Locale locale7 = Locale.getDefault();
        AbstractC13042fc3.h(locale7, "getDefault(...)");
        String lowerCase7 = strJ.toLowerCase(locale7);
        AbstractC13042fc3.h(lowerCase7, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase7, "banking-card-statement", false, 2, null)) {
            return V(activity);
        }
        Locale locale8 = Locale.getDefault();
        AbstractC13042fc3.h(locale8, "getDefault(...)");
        String lowerCase8 = strJ.toLowerCase(locale8);
        AbstractC13042fc3.h(lowerCase8, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase8, "banking-cards", false, 2, null)) {
            return F0(activity);
        }
        Locale locale9 = Locale.getDefault();
        AbstractC13042fc3.h(locale9, "getDefault(...)");
        String lowerCase9 = strJ.toLowerCase(locale9);
        AbstractC13042fc3.h(lowerCase9, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase9, "open_pfm_text", false, 2, null)) {
            if (intent.hasExtra("extra_transaction")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("extra_transaction");
                if (parcelableExtra instanceof PFMTransaction) {
                    Object systemService = C5721Ko.a.d().getSystemService("notification");
                    AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                    PFMTransaction pFMTransaction = (PFMTransaction) parcelableExtra;
                    GE4.d((NotificationManager) systemService, 270066638, String.valueOf(pFMTransaction.getDate()));
                    HashMap map = new HashMap();
                    map.put("action_type", 5);
                    map.put("accounting_type", Integer.valueOf(pFMTransaction.getTransactionType() == EnumC18897pR4.c ? 0 : 1));
                    map.put("notif_row", 3);
                    map.put("notif_coulumn", 2);
                    map.put("is_notif", Boolean.TRUE);
                    map.put("amount", Long.valueOf(Long.parseLong(pFMTransaction.getAmount())));
                    map.put("transaction_date", Long.valueOf(pFMTransaction.getDate()));
                    C3343Am.i("pfm_label_page", map);
                    return N0(activity, EnumC13506gL4.b, pFMTransaction);
                }
            }
            return N0(activity, EnumC13506gL4.b, null);
        }
        Locale locale10 = Locale.getDefault();
        AbstractC13042fc3.h(locale10, "getDefault(...)");
        String lowerCase10 = strJ.toLowerCase(locale10);
        AbstractC13042fc3.h(lowerCase10, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase10, "open_pfm_diagram", false, 2, null)) {
            return N0(activity, EnumC13506gL4.a, null);
        }
        Locale locale11 = Locale.getDefault();
        AbstractC13042fc3.h(locale11, "getDefault(...)");
        String lowerCase11 = strJ.toLowerCase(locale11);
        AbstractC13042fc3.h(lowerCase11, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase11, "arbaeen-help", false, 2, null)) {
            return O();
        }
        if (AbstractC20153rZ6.D(strJ, "https://ble.ir/story-fragment", true)) {
            String stringExtra = intent.getStringExtra("STORY_ID_EXTRA");
            if (stringExtra != null) {
                L0(stringExtra);
            } else {
                q1(1, null, false);
            }
            return true;
        }
        if (AbstractC20762sZ6.V(strJ, "story/add", true)) {
            K0();
            return true;
        }
        if (AbstractC20762sZ6.V(strJ, "story/stories-world", true)) {
            J0();
            return true;
        }
        if (AbstractC20762sZ6.V(strJ, "call/link-call", true)) {
            x0();
            return true;
        }
        if (A(strJ)) {
            K1(EnumC17964nr2.a);
            return true;
        }
        if (B(strJ)) {
            K1(EnumC17964nr2.b);
            return true;
        }
        if (!z(strJ)) {
            return false;
        }
        K1(EnumC17964nr2.c);
        return true;
    }

    private final boolean T0(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (strJ.length() == 0 || Uri.parse(strJ).getScheme() == null || !AbstractC13042fc3.d(Uri.parse(strJ).getScheme(), "rapsa")) {
            return false;
        }
        C14486i0.a aVar = C14486i0.f;
        AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
        Context baseContext = activity.getBaseContext();
        AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
        if (!C4100Dr4.a(baseContext)) {
            Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
            return true;
        }
        String strZ4 = ((SettingsModule) b.getValue()).Z4();
        if (strZ4.length() <= 0) {
            return false;
        }
        Uri.Builder builderBuildUpon = Uri.parse(strZ4).buildUpon();
        builderBuildUpon.appendQueryParameter("link", Uri.parse(strJ).toString());
        String string = builderBuildUpon.build().toString();
        AbstractC13042fc3.h(string, "toString(...)");
        c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, string, c14486i0A, null, null, 32, null));
        return true;
    }

    private final boolean U(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return false;
        }
        String strValueOf = String.valueOf(intent.getData());
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strValueOf.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (!AbstractC20762sZ6.X(lowerCase, "meet.bale.ai/i/", false, 2, null) && !AbstractC20762sZ6.X(lowerCase, "call.bale.ai/i/", false, 2, null)) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_CALL_LINK_INTENT", lowerCase);
        g1(bundle);
        return true;
    }

    private final boolean U0(Intent intent, Activity activity) {
        Uri uriBuild;
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String str = String.format("^/services/%s(?:\\?.*)?$", Arrays.copyOf(new Object[]{"bazoo"}, 1));
        AbstractC13042fc3.h(str, "format(...)");
        C20644sM5 c20644sM5 = new C20644sM5(str);
        String path = data.getPath();
        if (path == null) {
            path = "";
        }
        if (!c20644sM5.g(path)) {
            return false;
        }
        q1(AbstractC13089g.e1, null, false);
        Uri uri = Uri.parse(((SettingsModule) b.getValue()).k0());
        Set<String> queryParameterNames = data.getQueryParameterNames();
        if (queryParameterNames != null) {
            Set<String> set = queryParameterNames;
            if (set.isEmpty()) {
                set = null;
            }
            Set<String> set2 = set;
            if (set2 != null) {
                Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
                for (String str2 : set2) {
                    String queryParameter = data.getQueryParameter(str2);
                    builderClearQuery = queryParameter != null ? builderClearQuery.appendQueryParameter(str2, queryParameter) : null;
                }
                if (builderClearQuery != null && (uriBuild = builderClearQuery.build()) != null) {
                    uri = uriBuild;
                }
            }
        }
        AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        a.C1119a c1119a = ir.nasim.features.bank.mybank.webview.a.r1;
        String string = uri.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        C22042ua0.w9(abstractC13089gK, a.C1119a.b(c1119a, string, false, 2, null), false, null, 6, null);
        return true;
    }

    private final boolean U1(URL url, String str) {
        AbstractC5969Lp4.e().H().I(str).a(new c(url));
        return true;
    }

    private final boolean V(Activity activity) {
        h1(activity);
        return true;
    }

    private final boolean V0(Intent intent) {
        String action;
        ArrayList arrayList;
        String strValueOf;
        if (intent == null || (action = intent.getAction()) == null) {
            return false;
        }
        if (C8386Vt0.ra() && (AbstractC13042fc3.d(action, "android.intent.action.SEND") || AbstractC13042fc3.d(action, "android.intent.action.SEND_MULTIPLE"))) {
            RootActivity.INSTANCE.g(C5721Ko.a.d(), intent);
            return true;
        }
        String type = intent.getType();
        String str = null;
        if (AbstractC13042fc3.d(action, "android.intent.action.SEND")) {
            String stringExtra = AbstractC13042fc3.d("text/plain", type) ? intent.getStringExtra("android.intent.extra.TEXT") : null;
            if (stringExtra != null || intent.getParcelableExtra("android.intent.extra.STREAM") == null) {
                strValueOf = null;
                str = stringExtra;
                arrayList = null;
            } else {
                strValueOf = String.valueOf(intent.getParcelableExtra("android.intent.extra.STREAM"));
                str = stringExtra;
                arrayList = null;
            }
        } else if (AbstractC13042fc3.d(action, "android.intent.action.SEND_MULTIPLE")) {
            arrayList = new ArrayList();
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            if (parcelableArrayListExtra != null) {
                Iterator it = parcelableArrayListExtra.iterator();
                AbstractC13042fc3.h(it, "iterator(...)");
                while (it.hasNext()) {
                    arrayList.add(((Uri) it.next()).toString());
                }
            }
            strValueOf = null;
        } else {
            arrayList = null;
            strValueOf = null;
        }
        if (str == null && strValueOf == null && arrayList == null) {
            return false;
        }
        RootActivity.INSTANCE.g(C5721Ko.a.d(), intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC3570Bk5 V1() {
        Context context = AbstractC14047hG.a;
        AbstractC13042fc3.h(context, "applicationContext");
        return ((InterfaceC9291Zh4) C92.a(context, InterfaceC9291Zh4.class)).E0();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean W(java.lang.String r11, android.app.Activity r12) {
        /*
            r10 = this;
            r0 = 0
            java.lang.String r1 = "uniqr"
            r2 = 0
            r3 = 2
            boolean r0 = ir.nasim.AbstractC14836iZ6.S(r11, r1, r2, r3, r0)
            r1 = 1
            if (r0 == 0) goto L21
            r8 = 6
            r9 = 0
            java.lang.String r5 = "BCN"
            r6 = 0
            r7 = 0
            r4 = r11
            int r0 = ir.nasim.AbstractC14836iZ6.l0(r4, r5, r6, r7, r8, r9)
            java.lang.String r11 = r11.substring(r0)
            java.lang.String r0 = "substring(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r0)
            goto L6f
        L21:
            ir.nasim.sM5 r0 = new ir.nasim.sM5
            java.lang.String r4 = "-"
            r0.<init>(r4)
            java.util.List r11 = r0.m(r11, r2)
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L59
            int r0 = r11.size()
            java.util.ListIterator r0 = r11.listIterator(r0)
        L3a:
            boolean r4 = r0.hasPrevious()
            if (r4 == 0) goto L59
            java.lang.Object r4 = r0.previous()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r4.length()
            if (r4 != 0) goto L4d
            goto L3a
        L4d:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            int r0 = r0.nextIndex()
            int r0 = r0 + r1
            java.util.List r11 = ir.nasim.ZW0.f1(r11, r0)
            goto L5d
        L59:
            java.util.List r11 = ir.nasim.ZW0.m()
        L5d:
            java.util.Collection r11 = (java.util.Collection) r11
            java.lang.String[] r0 = new java.lang.String[r2]
            java.lang.Object[] r11 = r11.toArray(r0)
            java.lang.String[] r11 = (java.lang.String[]) r11
            int r0 = r11.length
            if (r0 != r3) goto L6d
            r11 = r11[r1]
            goto L6f
        L6d:
            java.lang.String r11 = ""
        L6f:
            boolean r0 = r12 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto Lab
            java.lang.String r0 = "normal"
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r11, r0)
            java.lang.String r2 = "c2c_open_from_intent_url"
            if (r0 == 0) goto L86
            ir.nasim.features.payment.view.activity.CardPaymentActivity$a r11 = ir.nasim.features.payment.view.activity.CardPaymentActivity.INSTANCE
            r11.g(r12)
            ir.nasim.C3343Am.g(r2)
            goto Laa
        L86:
            boolean r0 = r10.b1(r11)
            if (r0 == 0) goto L95
            ir.nasim.features.payment.view.activity.CardPaymentActivity$a r0 = ir.nasim.features.payment.view.activity.CardPaymentActivity.INSTANCE
            r0.h(r12, r11)
            ir.nasim.C3343Am.g(r2)
            goto Laa
        L95:
            ir.nasim.features.payment.view.activity.CardPaymentActivity$a r0 = ir.nasim.features.payment.view.activity.CardPaymentActivity.INSTANCE     // Catch: java.lang.Exception -> La2
            long r3 = java.lang.Long.parseLong(r11)     // Catch: java.lang.Exception -> La2
            r0.i(r12, r3)     // Catch: java.lang.Exception -> La2
            ir.nasim.C3343Am.g(r2)     // Catch: java.lang.Exception -> La2
            goto Laa
        La2:
            ir.nasim.features.payment.view.activity.CardPaymentActivity$a r11 = ir.nasim.features.payment.view.activity.CardPaymentActivity.INSTANCE
            r11.g(r12)
            ir.nasim.C3343Am.g(r2)
        Laa:
            return r1
        Lab:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18987pb3.W(java.lang.String, android.app.Activity):boolean");
    }

    private final boolean W0(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (!D(strJ) || !c1(strJ)) {
            return false;
        }
        String strSubstring = strJ.substring(AbstractC20762sZ6.r0(strJ, Separators.SLASH, 0, false, 6, null) + 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        if (!AbstractC20153rZ6.D(strSubstring, "transactions", true)) {
            return false;
        }
        C14486i0.a aVar = C14486i0.f;
        AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
        Context baseContext = activity.getBaseContext();
        AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
        if (!C4100Dr4.a(baseContext)) {
            Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
            return true;
        }
        c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, ((SettingsModule) b.getValue()).c5(), c14486i0A, null, null, 32, null));
        return true;
    }

    private final void W1(Intent intent) {
        if (intent == null || !AbstractC13042fc3.d(intent.getStringExtra("google.c.a.m_l"), "marketing")) {
            return;
        }
        try {
            XV4 xv4A = AbstractC4616Fw7.a("action_type", 2);
            String stringExtra = intent.getStringExtra("title");
            String str = "";
            if (stringExtra == null) {
                stringExtra = "";
            }
            XV4 xv4A2 = AbstractC4616Fw7.a("message_type", stringExtra);
            String stringExtra2 = intent.getStringExtra(ParameterNames.TEXT);
            if (stringExtra2 != null) {
                str = stringExtra2;
            }
            AbstractC10533bm0.d(C17050mJ2.a, C12366eV1.a(), null, new d(intent, AbstractC20051rO3.p(xv4A, xv4A2, AbstractC4616Fw7.a("msg_info", str)), null), 2, null);
        } catch (Exception e2) {
            C19406qI3.b("IntentHandler", e2.getMessage());
        }
    }

    private final boolean X(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (!D(strJ) || !c1(strJ)) {
            return false;
        }
        String strSubstring = strJ.substring(AbstractC20762sZ6.r0(strJ, Separators.SLASH, 0, false, 6, null) + 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        if (!AbstractC20153rZ6.D(strSubstring, "cashout", true)) {
            return false;
        }
        C14486i0.a aVar = C14486i0.f;
        AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
        Context baseContext = activity.getBaseContext();
        AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
        if (!C4100Dr4.a(baseContext)) {
            Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
            return true;
        }
        c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, ((SettingsModule) b.getValue()).T4(), c14486i0A, null, null, 32, null));
        return true;
    }

    private final boolean X0(Intent intent, Activity activity) {
        Uri data = intent.getData();
        if (data != null && data.getScheme() == null && !URLUtil.isValidUrl(data.toString())) {
            if (URLUtil.isValidUrl("http://" + data)) {
                intent.setData(Uri.parse("http://" + data));
            }
        }
        return T0(intent, activity) || l0(intent) || T(intent, activity) || U0(intent, activity) || P0(intent, activity) || i0(intent, activity) || a1(intent, activity) || g0(intent, activity) || Q0(intent) || Z0(intent, activity) || n0(intent) || m0(intent, activity) || a0(intent, activity) || Y(intent, activity) || Z(intent, activity) || b0(intent, activity) || W0(intent, activity) || X(intent, activity) || Y0(intent, activity) || S(intent, activity) || R(intent, activity) || Q(intent, activity) || j0(intent, activity);
    }

    private final void X1(Intent intent, String str) {
        String stringExtra;
        if (intent != null) {
            try {
                HashMap map = new HashMap();
                String stringExtra2 = intent.getStringExtra("peer_user_id");
                String stringExtra3 = intent.getStringExtra("peerType");
                if (stringExtra2 == null || stringExtra3 == null || (stringExtra = intent.getStringExtra("pushType")) == null) {
                    return;
                }
                EnumC13889gz5 enumC13889gz5ValueOf = EnumC13889gz5.valueOf(stringExtra);
                String stringExtra4 = intent.getStringExtra("MessageRID");
                long j2 = stringExtra4 != null ? Long.parseLong(stringExtra4) : -1L;
                String stringExtra5 = intent.getStringExtra("storyId");
                long longExtra = intent.getLongExtra("messageDate", 1L);
                StringBuilder sb = new StringBuilder();
                sb.append(j2);
                sb.append(longExtra);
                String string = sb.toString();
                map.put("push_type", Integer.valueOf(enumC13889gz5ValueOf.ordinal()));
                map.put("event_type", str);
                map.put("peer_id", Integer.valueOf(Integer.parseInt(stringExtra2)));
                map.put("peer_type", Integer.valueOf(Integer.parseInt(stringExtra3)));
                if (stringExtra5 != null) {
                    map.put("story_id", Integer.valueOf(Integer.parseInt(stringExtra5)));
                }
                map.put("msg_date", Long.valueOf(longExtra));
                map.put(DialogEntity.COLUMN_RID, Long.valueOf(j2));
                map.put("notif_id", string);
                C3343Am.i("click_notification", map);
            } catch (Exception e2) {
                C19406qI3.b("IntentHandler", e2.getMessage());
            }
        }
    }

    private final boolean Y(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (!D(strJ) || !c1(strJ)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase, "club/carousel", false, 2, null)) {
            C14486i0.a aVar = C14486i0.f;
            AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
            Context baseContext = activity.getBaseContext();
            AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
            if (!C4100Dr4.a(baseContext)) {
                Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
                return true;
            }
            String strU4 = ((SettingsModule) b.getValue()).U4();
            if (strU4.length() > 0) {
                c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, strU4, c14486i0A, null, null, 32, null));
                return true;
            }
        }
        return false;
    }

    private final boolean Y0(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (!D(strJ) || !c1(strJ)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (!AbstractC20762sZ6.X(lowerCase, "upgrade", false, 2, null)) {
            return false;
        }
        C14486i0.a aVar = C14486i0.f;
        AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
        Context baseContext = activity.getBaseContext();
        AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
        if (!C4100Dr4.a(baseContext)) {
            Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
            return true;
        }
        c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, ((SettingsModule) b.getValue()).d5(), c14486i0A, null, null, 32, null));
        return true;
    }

    private final void Y1(String str) {
        ((InterfaceC15767k82) C92.a(C5721Ko.a.d(), InterfaceC15767k82.class)).z().f("bale_source", str);
    }

    private final boolean Z(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (!D(strJ) || !c1(strJ)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase, "club/p1", false, 2, null)) {
            C14486i0.a aVar = C14486i0.f;
            AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
            Context baseContext = activity.getBaseContext();
            AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
            if (!C4100Dr4.a(baseContext)) {
                Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
                return true;
            }
            String strV4 = ((SettingsModule) b.getValue()).V4();
            if (strV4.length() > 0) {
                c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, strV4, c14486i0A, null, null, 32, null));
                return true;
            }
        }
        return false;
    }

    private final boolean Z0(Intent intent, Activity activity) {
        String host;
        Uri data = intent.getData();
        if (data != null && (host = data.getHost()) != null && !AbstractC20762sZ6.n0(host)) {
            String str = m;
            Locale locale = Locale.getDefault();
            AbstractC13042fc3.h(locale, "getDefault(...)");
            String lowerCase = host.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            if (AbstractC20762sZ6.X(str, lowerCase, false, 2, null)) {
                Set<String> queryParameterNames = data.getQueryParameterNames();
                ExPeer exPeer = (ExPeer) AbstractC7984Ua3.a(intent, "intent_extra_ex_peer_id_key", ExPeer.class);
                AbstractC13042fc3.f(queryParameterNames);
                if (C(queryParameterNames, "startapp") && M0(data, exPeer, activity)) {
                    return true;
                }
                if (C(queryParameterNames, "digital_id") && O0(data, activity)) {
                    return true;
                }
                if (C(queryParameterNames, "profile") && G0()) {
                    return true;
                }
                if (data.getPathSegments().size() == 1) {
                    if (C(queryParameterNames, "url")) {
                        List<String> pathSegments = data.getPathSegments();
                        AbstractC13042fc3.h(pathSegments, "getPathSegments(...)");
                        if (AbstractC13042fc3.d(AbstractC15401jX0.s0(pathSegments), "share") && I0(data)) {
                            return true;
                        }
                    }
                    if (z0(data, activity)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SettingsModule Z1() {
        Context context = AbstractC14047hG.a;
        AbstractC13042fc3.h(context, "applicationContext");
        return ((InterfaceC9291Zh4) C92.a(context, InterfaceC9291Zh4.class)).b1();
    }

    private final boolean a0(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (!D(strJ) || !c1(strJ)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (AbstractC20762sZ6.X(lowerCase, "club/referral", false, 2, null)) {
            C14486i0.a aVar = C14486i0.f;
            AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
            Context baseContext = activity.getBaseContext();
            AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
            if (!C4100Dr4.a(baseContext)) {
                Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
                return true;
            }
            String strW4 = ((SettingsModule) b.getValue()).W4();
            if (strW4.length() > 0) {
                c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, strW4, c14486i0A, null, null, 32, null));
                return true;
            }
        }
        return false;
    }

    private final boolean a1(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (strJ == null || !U38.b(strJ)) {
            return false;
        }
        M1(U38.a(strJ), activity);
        return true;
    }

    private final void a2(Activity activity) {
        C14486i0.a aVar = C14486i0.f;
        AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
        FastChargeBottomSheetContentView fastChargeBottomSheetContentView = new FastChargeBottomSheetContentView(activity);
        fastChargeBottomSheetContentView.setAbolInstance(c14486i0A);
        c14486i0A.o(fastChargeBottomSheetContentView);
    }

    private final boolean b0(Intent intent, Activity activity) {
        String strJ = J(intent);
        if (!D(strJ) || !c1(strJ)) {
            return false;
        }
        String strSubstring = strJ.substring(AbstractC20762sZ6.r0(strJ, Separators.SLASH, 0, false, 6, null) + 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        if (!AbstractC20153rZ6.D(strSubstring, "club", true)) {
            return false;
        }
        C14486i0.a aVar = C14486i0.f;
        AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
        Context baseContext = activity.getBaseContext();
        AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
        if (!C4100Dr4.a(baseContext)) {
            Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
            return true;
        }
        c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, ((SettingsModule) b.getValue()).X4(), c14486i0A, null, null, 32, null));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean b1(java.lang.String r10) {
        /*
            r9 = this;
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r1 = "getDefault(...)"
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            java.lang.String r2 = "BCN"
            java.lang.String r0 = r2.toLowerCase(r0)
            java.lang.String r2 = "toLowerCase(...)"
            ir.nasim.AbstractC13042fc3.h(r0, r2)
            java.lang.String r3 = "substring(...)"
            r4 = 0
            r5 = 2
            r6 = 0
            if (r10 == 0) goto L3a
            java.util.Locale r7 = java.util.Locale.getDefault()
            ir.nasim.AbstractC13042fc3.h(r7, r1)
            java.lang.String r7 = r10.toLowerCase(r7)
            ir.nasim.AbstractC13042fc3.h(r7, r2)
            java.lang.String r8 = "pan:"
            boolean r7 = ir.nasim.AbstractC14836iZ6.S(r7, r8, r6, r5, r4)
            if (r7 == 0) goto L3a
            r0 = 4
            java.lang.String r10 = r10.substring(r0)
            ir.nasim.AbstractC13042fc3.h(r10, r3)
            goto L69
        L3a:
            if (r10 == 0) goto L69
            java.util.Locale r7 = java.util.Locale.getDefault()
            ir.nasim.AbstractC13042fc3.h(r7, r1)
            java.lang.String r1 = r10.toLowerCase(r7)
            ir.nasim.AbstractC13042fc3.h(r1, r2)
            boolean r1 = ir.nasim.AbstractC14836iZ6.S(r1, r0, r6, r5, r4)
            if (r1 == 0) goto L69
            int r1 = r0.length()     // Catch: java.lang.Exception -> L63
            int r0 = r0.length()     // Catch: java.lang.Exception -> L63
            int r0 = r0 + 16
            java.lang.String r0 = r10.substring(r1, r0)     // Catch: java.lang.Exception -> L63
            ir.nasim.AbstractC13042fc3.h(r0, r3)     // Catch: java.lang.Exception -> L63
            r10 = r0
            goto L69
        L63:
            r0 = move-exception
            java.lang.String r1 = "IntentHandler"
            ir.nasim.C19406qI3.d(r1, r0)
        L69:
            ir.nasim.Y50 r10 = ir.nasim.AbstractC19902r80.d(r10)
            ir.nasim.Y50 r0 = ir.nasim.Y50.d
            if (r10 == r0) goto L72
            r6 = 1
        L72:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18987pb3.b1(java.lang.String):boolean");
    }

    private final boolean b2(Activity activity, Fragment fragment) {
        if (!(activity instanceof AppCompatActivity)) {
            C19406qI3.a("IntentHandler", "Activity must be AppCompatActivity", new Object[0]);
            return false;
        }
        androidx.fragment.app.x xVarS = ((AppCompatActivity) activity).B0().s();
        int i2 = AbstractC9220Yz5.slide_in_right;
        int i3 = AbstractC9220Yz5.empty_transition;
        xVarS.t(i2, i3, i3, AbstractC9220Yz5.slide_out_right).c(BC5.content_frame, fragment, null).g(null).h();
        return true;
    }

    private final boolean c1(String str) {
        String host = Uri.parse(str).getHost();
        if (host == null) {
            return false;
        }
        return AbstractC20762sZ6.X(host, "bale.ai", false, 2, null) || AbstractC20762sZ6.X(host, "ble.ir", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C23572x88 c2() {
        Context context = AbstractC14047hG.a;
        AbstractC13042fc3.h(context, "applicationContext");
        return ((InterfaceC9291Zh4) C92.a(context, InterfaceC9291Zh4.class)).G();
    }

    private final boolean d0(Activity activity) {
        a2(activity);
        return true;
    }

    private final boolean d1(String str) {
        if (str == null) {
            return false;
        }
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return AbstractC20153rZ6.C(lowerCase, "/c2c", false, 2, null) || (AbstractC20153rZ6.S(str, "uniqr", false, 2, null) && AbstractC20762sZ6.X(str, "BCN", false, 2, null));
    }

    private final void e0(final Activity activity) throws Resources.NotFoundException {
        InterfaceC12737f70 interfaceC12737f70A = InterfaceC13373g70.a.a(activity);
        String string = activity.getResources().getString(AbstractC12217eE5.fast_charge_permission_done_message);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = activity.getResources().getString(AbstractC12217eE5.fast_charge_permission_done_title);
        AbstractC13042fc3.h(string2, "getString(...)");
        String string3 = activity.getResources().getString(AbstractC12217eE5.choose_charge);
        AbstractC13042fc3.h(string3, "getString(...)");
        interfaceC12737f70A.d(string, string2, string3, new SA2() { // from class: ir.nasim.ab3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18987pb3.f0(activity);
            }
        });
    }

    public static final boolean e1(Context context, String str, Integer num) {
        AbstractC13042fc3.i(context, "ctx");
        AbstractC13042fc3.i(str, "data");
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if ((AbstractC20762sZ6.X(lowerCase, l, false, 2, null) || a.x(str).length > 1) && AbstractC20762sZ6.X(str, "join/", false, 2, null)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            String string = UUID.randomUUID().toString();
            AbstractC13042fc3.h(string, "toString(...)");
            String strSubstring = AbstractC20153rZ6.M(string, "-", "", false, 4, null).substring(0, 30);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            a.Y1(strSubstring);
            if (num != null) {
                intent.setFlags(num.intValue());
            }
            intent.putExtra("bale_source_extra", strSubstring);
            try {
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                    return true;
                }
                C19406qI3.b("IntentHandler", "No app found to handle this URL");
                return false;
            } catch (Exception e2) {
                C19406qI3.b("IntentHandler", "No app found to handle this URL with Exception: " + e2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f0(Activity activity) {
        AbstractC13042fc3.i(activity, "$activity");
        a.a2(activity);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9615aG2 f1() {
        Context context = AbstractC14047hG.a;
        AbstractC13042fc3.h(context, "applicationContext");
        return ((InterfaceC9291Zh4) C92.a(context, InterfaceC9291Zh4.class)).o0();
    }

    private final boolean g0(Intent intent, Activity activity) throws Resources.NotFoundException {
        String strJ = J(intent);
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (!AbstractC20762sZ6.X(lowerCase, "/#$/fast-charge/after-login", false, 2, null)) {
            return false;
        }
        e0(activity);
        return true;
    }

    private final void g1(Bundle bundle) {
        AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        if (abstractC13089gK != null) {
            abstractC13089gK.P9();
            abstractC13089gK.V9(bundle);
        }
    }

    private final boolean h0(boolean z) {
        q1(AbstractC13089g.d1, "FEED", z);
        return true;
    }

    private final void h1(Activity activity) {
        CardPaymentActivity.INSTANCE.m(activity);
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean i0(android.content.Intent r28, android.app.Activity r29) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18987pb3.i0(android.content.Intent, android.app.Activity):boolean");
    }

    public static final boolean i1(String str, Activity activity) {
        String[] strArrX;
        List listM;
        List listM2;
        if (str != null && str.length() != 0) {
            Locale locale = Locale.getDefault();
            AbstractC13042fc3.h(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            if (AbstractC20762sZ6.X(lowerCase, "/c/", false, 2, null)) {
                List listM3 = new C20644sM5("/c/").m(lowerCase, 0);
                if (listM3.isEmpty()) {
                    listM2 = AbstractC10360bX0.m();
                    strArrX = (String[]) listM2.toArray(new String[0]);
                } else {
                    ListIterator listIterator = listM3.listIterator(listM3.size());
                    while (listIterator.hasPrevious()) {
                        if (((String) listIterator.previous()).length() != 0) {
                            listM2 = AbstractC15401jX0.f1(listM3, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                    listM2 = AbstractC10360bX0.m();
                    strArrX = (String[]) listM2.toArray(new String[0]);
                }
            } else {
                String str2 = l;
                if (AbstractC20762sZ6.X(lowerCase, str2, false, 2, null)) {
                    List listM4 = new C20644sM5(str2).m(lowerCase, 0);
                    if (listM4.isEmpty()) {
                        listM = AbstractC10360bX0.m();
                        strArrX = (String[]) listM.toArray(new String[0]);
                    } else {
                        ListIterator listIterator2 = listM4.listIterator(listM4.size());
                        while (listIterator2.hasPrevious()) {
                            if (((String) listIterator2.previous()).length() != 0) {
                                listM = AbstractC15401jX0.f1(listM4, listIterator2.nextIndex() + 1);
                                break;
                            }
                        }
                        listM = AbstractC10360bX0.m();
                        strArrX = (String[]) listM.toArray(new String[0]);
                    }
                } else {
                    strArrX = a.x(lowerCase);
                }
            }
            if (strArrX.length > 1) {
                String strSubstring = strArrX[strArrX.length - 1];
                if (AbstractC20762sZ6.X(strSubstring, Separators.QUESTION, false, 2, null)) {
                    strSubstring = strSubstring.substring(0, AbstractC20762sZ6.k0(strSubstring, '?', 0, false, 6, null));
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                }
                C5735Kp4.w().J(activity, strSubstring, null);
                return true;
            }
        }
        return false;
    }

    private final boolean j0(Intent intent, Activity activity) {
        if (C8386Vt0.K6()) {
            String strJ = J(intent);
            if (strJ.length() == 0 || !AbstractC20153rZ6.S(strJ, "ble://bale.ai", false, 2, null)) {
                return false;
            }
            String strD2 = ((SettingsModule) b.getValue()).d2();
            KS2 ks2 = j;
            if (ks2 == null) {
                ks2 = new KS2();
            }
            j = ks2;
            try {
                C13149fk3 c13149fk3J = AbstractC9083Yk3.c(strD2).j();
                AbstractC13042fc3.f(c13149fk3J);
                Iterator it = c13149fk3J.iterator();
                while (it.hasNext()) {
                    C8542Wk3 c8542Wk3O = ((AbstractC22735vk3) it.next()).o();
                    AbstractC22735vk3 abstractC22735vk3L = c8542Wk3O.L("link");
                    String strV = abstractC22735vk3L != null ? abstractC22735vk3L.v() : null;
                    AbstractC22735vk3 abstractC22735vk3L2 = c8542Wk3O.L(ConstantDeviceInfo.APP_PLATFORM);
                    String strV2 = abstractC22735vk3L2 != null ? abstractC22735vk3L2.v() : null;
                    if (strV != null && strV2 != null && AbstractC13042fc3.d(strV, strJ)) {
                        C14486i0.a aVar = C14486i0.f;
                        AbstractC13042fc3.g(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                        C14486i0 c14486i0A = aVar.a((AppCompatActivity) activity);
                        Context baseContext = activity.getBaseContext();
                        AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
                        if (C4100Dr4.a(baseContext)) {
                            c14486i0A.o(new BottomSheetWebView(activity, (BaseActivity) activity, strV2, c14486i0A, null, null, 32, null));
                            return true;
                        }
                        Toast.makeText(activity.getBaseContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
                        return true;
                    }
                }
            } catch (Exception e2) {
                C19406qI3.c("IntentHandler", "failed to parse generic deep link config ", e2);
            }
        }
        return false;
    }

    private final boolean j1(Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null || !AbstractC20762sZ6.X(action, "ir.nasim.openchat", false, 2, null)) {
            return false;
        }
        String strSubstring = action.substring(17);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        final C11458d25 c11458d25R = C11458d25.r(Long.parseLong(strSubstring));
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        C5735Kp4.w().k().P9();
        new Handler().postDelayed(new Runnable() { // from class: ir.nasim.mb3
            @Override // java.lang.Runnable
            public final void run() {
                C18987pb3.k1(c11458d25R);
            }
        }, 100L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        x1(a, c11458d25, null, null, false, null, null, false, null, null, false, null, 2046, null);
    }

    private final boolean l0(Intent intent) {
        Uri data;
        if (intent != null && (data = intent.getData()) != null) {
            String string = data.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            if (AbstractC20762sZ6.X(string, "ble.ir/search_content", false, 2, null)) {
                I1(data.getQueryParameter("query"), data.getQueryParameter("tab"));
                return true;
            }
        }
        return false;
    }

    private final boolean m0(Intent intent, Activity activity) {
        String strJ = J(intent);
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (!AbstractC20762sZ6.X(lowerCase, l, false, 2, null) && x(strJ).length <= 1) {
            return false;
        }
        if (!AbstractC20762sZ6.X(strJ, "join/", false, 2, null)) {
            return i1(strJ, activity);
        }
        C19406qI3.a("Source_Join_Cause", "intent handler handleJoin()", new Object[0]);
        H1(strJ, v(intent));
        return true;
    }

    public static /* synthetic */ boolean m1(C18987pb3 c18987pb3, int i2, long j2, long j3, boolean z, HQ0 hq0, int i3, Object obj) {
        return c18987pb3.l1(i2, j2, j3, z, (i3 & 16) != 0 ? HQ0.b : hq0);
    }

    private final boolean n0(Intent intent) {
        List listM;
        List listM2;
        String strJ = J(intent);
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strJ.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (!AbstractC20762sZ6.X(lowerCase, Separators.QUESTION, false, 2, null)) {
            return false;
        }
        if (!AbstractC20762sZ6.X(lowerCase, l, false, 2, null) && x(strJ).length <= 1) {
            return false;
        }
        try {
            URL url = new URL(strJ);
            List listM3 = new C20644sM5("[?]").m(strJ, 0);
            if (listM3.isEmpty()) {
                listM = AbstractC10360bX0.m();
            } else {
                ListIterator listIterator = listM3.listIterator(listM3.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listM = AbstractC15401jX0.f1(listM3, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listM = AbstractC10360bX0.m();
            }
            List listM4 = new C20644sM5(Separators.SLASH).m(((String[]) listM.toArray(new String[0]))[0], 0);
            if (listM4.isEmpty()) {
                listM2 = AbstractC10360bX0.m();
            } else {
                ListIterator listIterator2 = listM4.listIterator(listM4.size());
                while (listIterator2.hasPrevious()) {
                    if (((String) listIterator2.previous()).length() != 0) {
                        listM2 = AbstractC15401jX0.f1(listM4, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                listM2 = AbstractC10360bX0.m();
            }
            String[] strArr = (String[]) listM2.toArray(new String[0]);
            String str = (String) AbstractC10242bK.n0(strArr, strArr.length - 1);
            if (str == null || url.getQuery() == null) {
                return false;
            }
            return U1(url, str);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    private final boolean o0() {
        q1(AbstractC13089g.d1, "MARKET", true);
        return true;
    }

    private final boolean o1(C11458d25 c11458d25, Long l2, Long l3, boolean z, String str, String str2, boolean z2, boolean z3, boolean z4) {
        return B1(this, c11458d25, l2, l3, z, str, str2, z2, z3, null, null, z4, null, 2048, null);
    }

    private final boolean p0(final String str) {
        int iL0;
        String strS2 = ((SettingsModule) b.getValue()).S2();
        if (AbstractC20762sZ6.X(str, strS2, false, 2, null) && C8386Vt0.y7() && (iL0 = AbstractC20762sZ6.l0(str, strS2, 0, false, 6, null)) > 0) {
            String strSubstring = str.substring(iL0);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            C5721Ko c5721Ko = C5721Ko.a;
            Intent intentA = ((AD3) C92.a(c5721Ko.d(), AD3.class)).D().a(c5721Ko.d(), strSubstring, AbstractC12888fL4.b.b);
            intentA.setFlags(268435456);
            c5721Ko.d().startActivity(intentA);
            return true;
        }
        q1(AbstractC13089g.e1, null, true);
        try {
            AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
            AbstractC13042fc3.g(abstractC13089gK, "null cannot be cast to non-null type ir.nasim.features.root.RootFragmentImp");
            final InterfaceC17936no4 myBankFragmentPageInterface = ((C13090h) abstractC13089gK).getMyBankFragmentPageInterface();
            if (myBankFragmentPageInterface != null) {
                AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.bb3
                    @Override // java.lang.Runnable
                    public final void run() {
                        C18987pb3.q0(myBankFragmentPageInterface, str);
                    }
                }, 500L);
            }
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
        return true;
    }

    public static /* synthetic */ boolean p1(C18987pb3 c18987pb3, C11458d25 c11458d25, Long l2, Long l3, boolean z, String str, String str2, boolean z2, boolean z3, int i2, Object obj) {
        return c18987pb3.n1(c11458d25, l2, l3, z, str, str2, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? false : z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(InterfaceC17936no4 interfaceC17936no4, String str) {
        AbstractC13042fc3.i(str, "$intentData");
        interfaceC17936no4.n2(str);
    }

    private final boolean r0(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null && extras.getBoolean("notification_intent", false)) {
            C11458d25 c11458d25R = C11458d25.r(extras.getLong("chat_peer", 0L));
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            if (c11458d25R.getPeerId() != 0) {
                X1(intent, "client");
                String string = extras.getString("chat_message", null);
                if (string == null) {
                    x1(this, c11458d25R, null, null, false, null, null, false, null, null, false, null, 2046, null);
                    return true;
                }
                v1(c11458d25R, string);
                return true;
            }
        }
        return false;
    }

    private final boolean s0(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            String string = data.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            if (AbstractC20762sZ6.X(string, "ai-tab", false, 2, null)) {
                AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
                if (abstractC13089gK == null || abstractC13089gK.h9()) {
                    return true;
                }
                abstractC13089gK.ha(data.getQuery());
                return true;
            }
        }
        return false;
    }

    private final boolean t0(Intent intent) {
        Uri data = intent.getData();
        if (data != null && AbstractC13042fc3.d("android.intent.action.VIEW", intent.getAction())) {
            try {
                Cursor cursorQuery = C5721Ko.a.d().getContentResolver().query(data, null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    final int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("data1"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("mimetype"));
                    if (string != null) {
                        int iHashCode = string.hashCode();
                        if (iHashCode != -981979821) {
                            if (iHashCode != -32250234) {
                                if (iHashCode == 447990913 && string.equals("vnd.android.cursor.item/vnd.ir.nasim.profile") && i2 != 0) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(Integer.valueOf(i2));
                                    AbstractC5969Lp4.d().V0(arrayList).m0(new InterfaceC24449ye1() { // from class: ir.nasim.nb3
                                        @Override // ir.nasim.InterfaceC24449ye1
                                        public final void apply(Object obj) {
                                            C18987pb3.u0(i2, (C14505i18) obj);
                                        }
                                    });
                                    return true;
                                }
                            } else if (string.equals("vnd.android.cursor.item/vnd.ir.nasim.call") && i2 != 0) {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(Integer.valueOf(i2));
                                AbstractC5969Lp4.d().V0(arrayList2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.ob3
                                    @Override // ir.nasim.InterfaceC24449ye1
                                    public final void apply(Object obj) {
                                        C18987pb3.v0(i2, (C14505i18) obj);
                                    }
                                });
                                return true;
                            }
                        } else if (string.equals("vnd.android.cursor.item/vnd.ir.nasim.video") && i2 != 0) {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(Integer.valueOf(i2));
                            AbstractC5969Lp4.d().V0(arrayList3).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Wa3
                                @Override // ir.nasim.InterfaceC24449ye1
                                public final void apply(Object obj) {
                                    C18987pb3.w0(i2, (C14505i18) obj);
                                }
                            });
                            return true;
                        }
                    }
                }
            } catch (Exception e2) {
                C19406qI3.d("IntentHandler", e2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(int i2, C14505i18 c14505i18) {
        C11458d25 c11458d25R = C11458d25.r(i2);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        x1(a, c11458d25R, null, null, false, null, null, false, null, null, false, null, 2046, null);
    }

    private final boolean v(Intent intent) {
        String stringExtra = intent.getStringExtra("bale_source_extra");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String strK = K();
        return (AbstractC20762sZ6.n0(stringExtra) ^ true) && (AbstractC20762sZ6.n0(strK) ^ true) && AbstractC13042fc3.d(strK, stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(int i2, C14505i18 c14505i18) {
        C11458d25 c11458d25R = C11458d25.r(i2);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        C20384rv0.b0(c11458d25R.getPeerId(), false);
        C5074Hu0.a.d(EnumC22288uz0.f, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC11677dQ0 w() {
        Context context = AbstractC14047hG.a;
        AbstractC13042fc3.h(context, "applicationContext");
        return ((InterfaceC12320eQ0) C92.a(context, InterfaceC12320eQ0.class)).W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(int i2, C14505i18 c14505i18) {
        C11458d25 c11458d25R = C11458d25.r(i2);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        C20384rv0.b0(c11458d25R.getPeerId(), true);
        C5074Hu0.a.d(EnumC22288uz0.f, true);
    }

    private final void x0() {
        C5735Kp4.w().k().U9();
    }

    public static /* synthetic */ boolean x1(C18987pb3 c18987pb3, C11458d25 c11458d25, Long l2, Long l3, boolean z, String str, String str2, boolean z2, C11458d25 c11458d252, Boolean bool, boolean z3, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction, int i2, Object obj) {
        return c18987pb3.u1(c11458d25, (i2 & 2) != 0 ? null : l2, (i2 & 4) != 0 ? null : l3, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? null : str2, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? null : c11458d252, (i2 & 256) == 0 ? bool : null, (i2 & 512) == 0 ? z3 : false, (i2 & 1024) != 0 ? EmptyStateOnboardingItemAction.NotOpened.e : emptyStateOnboardingItemAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C8054Ui1 y() {
        Context context = AbstractC14047hG.a;
        AbstractC13042fc3.h(context, "applicationContext");
        return ((InterfaceC9291Zh4) C92.a(context, InterfaceC9291Zh4.class)).m();
    }

    private final boolean y0(Intent intent) {
        if (intent == null || intent.getData() == null || !AbstractC20762sZ6.X(String.valueOf(intent.getData()), "call/logs", false, 2, null)) {
            return false;
        }
        g1(new Bundle());
        return true;
    }

    private final boolean z(String str) {
        for (String str2 : p) {
            if (AbstractC20153rZ6.D(str, str2, true)) {
                return true;
            }
        }
        return false;
    }

    private final boolean z0(Uri uri, final Activity activity) {
        List<String> pathSegments = uri.getPathSegments();
        AbstractC13042fc3.h(pathSegments, "getPathSegments(...)");
        String str = (String) AbstractC15401jX0.s0(pathSegments);
        if (str == null) {
            return false;
        }
        String strA = AbstractC7546Se2.a(uri, ParameterNames.TEXT);
        final String strB0 = strA != null ? B0(strA) : null;
        final String strA2 = AbstractC7546Se2.a(uri, "start");
        H().h0(str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Za3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C18987pb3.A0(strA2, strB0, activity, (C4382Ew7) obj);
            }
        });
        return true;
    }

    public static final boolean z1(C11458d25 c11458d25, Long l2, Long l3, boolean z, String str, C11458d25 c11458d252, Boolean bool) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return x1(a, c11458d25, l2, l3, z, null, str, false, c11458d252, bool, false, null, 1536, null);
    }

    public final void C1(Context context, String str, String str2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "fileName");
        C5721Ko.a.d().startActivity(C22055ub3.i(context, str, str2));
    }

    public final String F() {
        return l;
    }

    public final boolean J1(String str, Context context) {
        if (str != null && context != null && D(str)) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).setFlags(268435456));
                return true;
            } catch (Exception e2) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            }
        }
        return false;
    }

    public final void K1(EnumC17964nr2 enumC17964nr2) {
        AbstractC13042fc3.i(enumC17964nr2, "type");
        AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        int iOrdinal = enumC17964nr2.ordinal();
        EnumC17964nr2 enumC17964nr22 = EnumC17964nr2.b;
        if (iOrdinal == enumC17964nr22.ordinal()) {
            if (C7183Qq.p().h("should_show_money_request_intro", true)) {
                C22042ua0.A9(abstractC13089gK, C19058pi4.INSTANCE.a(), false, null, 6, null);
                return;
            } else {
                C22042ua0.A9(abstractC13089gK, C9919am6.INSTANCE.b(enumC17964nr22.ordinal()), false, null, 6, null);
                return;
            }
        }
        int iOrdinal2 = enumC17964nr2.ordinal();
        EnumC17964nr2 enumC17964nr23 = EnumC17964nr2.c;
        if (iOrdinal2 == enumC17964nr23.ordinal()) {
            if (C7183Qq.p().h("should_show_crowdfunding_intro", true)) {
                C22042ua0.A9(abstractC13089gK, C7455Ru1.INSTANCE.a(), false, null, 6, null);
                return;
            } else {
                C22042ua0.A9(abstractC13089gK, C9919am6.INSTANCE.b(enumC17964nr23.ordinal()), false, null, 6, null);
                return;
            }
        }
        int iOrdinal3 = enumC17964nr2.ordinal();
        EnumC17964nr2 enumC17964nr24 = EnumC17964nr2.a;
        if (iOrdinal3 == enumC17964nr24.ordinal()) {
            if (C7183Qq.p().h("should_show_gift_intro", true)) {
                C22042ua0.A9(abstractC13089gK, C18223oI2.INSTANCE.a(), false, null, 6, null);
            } else {
                C22042ua0.A9(abstractC13089gK, C9919am6.INSTANCE.b(enumC17964nr24.ordinal()), false, null, 6, null);
            }
        }
    }

    public final void T1(Integer num) {
        if (num == null || AbstractC5969Lp4.g().n(num.intValue()) == null) {
            return;
        }
        C22042ua0.A9(C5735Kp4.w().k(), C24137y63.b(num.intValue()), false, null, 6, null);
    }

    public final boolean c0(boolean z) {
        q1(AbstractC13089g.d1, "DISCOVER", z);
        return true;
    }

    public final boolean k0(Intent intent, Activity activity) {
        String host;
        AbstractC13042fc3.i(activity, "activity");
        if (intent == null) {
            return false;
        }
        Uri data = intent.getData();
        if (data != null && (host = data.getHost()) != null && AbstractC20762sZ6.X(host, "deep", false, 2, null) && data.getQueryParameterNames() != null) {
            for (String str : data.getQueryParameterNames()) {
                intent.putExtra(str, data.getQueryParameter(str));
            }
        }
        try {
            if (!M(intent)) {
                if (!X0(intent, activity)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            C19406qI3.b("IntentHandler", "Error in handleIntent: " + e2.getMessage());
            return false;
        }
    }

    public final boolean l1(int i2, long j2, long j3, boolean z, HQ0 hq0) {
        AbstractC13042fc3.i(hq0, "spot");
        AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        if (abstractC13089gK == null || abstractC13089gK.Q7().isFinishing() || abstractC13089gK.h9()) {
            return false;
        }
        abstractC13089gK.W9(i2, j2, j3, z, hq0);
        return true;
    }

    public final boolean n1(C11458d25 c11458d25, Long l2, Long l3, boolean z, String str, String str2, boolean z2, boolean z3) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return o1(c11458d25, l2, l3, z, str, str2, false, z2, z3);
    }

    public final void q1(int i2, String str, boolean z) {
        AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        if (abstractC13089gK != null) {
            if (str != null) {
                abstractC13089gK.ja(str, z);
            }
            abstractC13089gK.P9();
            abstractC13089gK.ia(i2);
        }
    }

    public final boolean r1(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return x1(this, c11458d25, null, null, false, null, null, false, null, null, false, null, 2046, null);
    }

    public final boolean s1(C11458d25 c11458d25, Long l2, Long l3) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return x1(this, c11458d25, l2, l3, false, null, null, false, null, null, false, null, 2040, null);
    }

    public final boolean t1(C11458d25 c11458d25, Long l2, Long l3, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return x1(this, c11458d25, l2, l3, z, null, null, false, null, null, false, null, 2032, null);
    }

    public final boolean u1(C11458d25 c11458d25, Long l2, Long l3, boolean z, String str, String str2, boolean z2, C11458d25 c11458d252, Boolean bool, boolean z3, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(emptyStateOnboardingItemAction, "emptyStateOnboardingItemAction");
        return A1(c11458d25, l2, l3, z, str, str2, true, z2, c11458d252, bool, z3, emptyStateOnboardingItemAction);
    }

    public final boolean v1(C11458d25 c11458d25, String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return x1(this, c11458d25, null, null, false, str, null, false, null, null, false, null, 1536, null);
    }

    public final boolean w1(C11458d25 c11458d25, String str, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        o1(c11458d25, null, null, false, null, str, z, false, false);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059 A[LOOP:0: B:3:0x000c->B:17:0x0059, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c A[EDGE_INSN: B:20:0x005c->B:18:0x005c BREAK  A[LOOP:0: B:3:0x000c->B:17:0x0059], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String[] x(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "url"
            ir.nasim.AbstractC13042fc3.i(r9, r0)
            r0 = 0
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String[] r2 = ir.nasim.C18987pb3.k
            int r3 = r2.length
            r4 = r0
        Lc:
            if (r4 >= r3) goto L5c
            r1 = r2[r4]
            ir.nasim.sM5 r5 = new ir.nasim.sM5
            r5.<init>(r1)
            java.util.List r1 = r5.m(r9, r0)
            boolean r5 = r1.isEmpty()
            r6 = 1
            if (r5 != 0) goto L47
            int r5 = r1.size()
            java.util.ListIterator r5 = r1.listIterator(r5)
        L28:
            boolean r7 = r5.hasPrevious()
            if (r7 == 0) goto L47
            java.lang.Object r7 = r5.previous()
            java.lang.String r7 = (java.lang.String) r7
            int r7 = r7.length()
            if (r7 != 0) goto L3b
            goto L28
        L3b:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            int r5 = r5.nextIndex()
            int r5 = r5 + r6
            java.util.List r1 = ir.nasim.ZW0.f1(r1, r5)
            goto L4b
        L47:
            java.util.List r1 = ir.nasim.ZW0.m()
        L4b:
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.String[] r5 = new java.lang.String[r0]
            java.lang.Object[] r1 = r1.toArray(r5)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r5 = r1.length
            if (r5 <= r6) goto L59
            goto L5c
        L59:
            int r4 = r4 + 1
            goto Lc
        L5c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18987pb3.x(java.lang.String):java.lang.String[]");
    }

    public final boolean y1(C11458d25 c11458d25, Long l2, Long l3, boolean z, String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return x1(this, c11458d25, l2, l3, z, null, str, false, null, null, false, null, 1536, null);
    }
}
