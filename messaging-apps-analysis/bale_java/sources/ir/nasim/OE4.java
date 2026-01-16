package ir.nasim;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.core.graphics.drawable.IconCompat;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.AbstractC6544Ny5;
import ir.nasim.AbstractC9599aE4;
import ir.nasim.B00;
import ir.nasim.C21165tD4;
import ir.nasim.D55;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.pinMessages.PinMessageEntity;
import ir.nasim.features.MainActivity;
import ir.nasim.features.firebase.newPush.handler.TrampolineActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class OE4 extends AbstractC6360Ng4 {
    public static final a t = new a(null);
    public static final int u = 8;
    private final C9057Yh4 m;
    private final Map n;
    private final InterfaceC9173Yu3 o;
    private HD4 p;
    private CE4 q;
    private C15958kT2 r;
    private final InterfaceC9173Yu3 s;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
    }

    public static final class c {
        private final int a;
        private final long b;

        public c(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public final long a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "OtherAccountPushReceived(peerId=" + this.a + ", date=" + this.b + Separators.RPAREN;
        }
    }

    public static final class d {
        private final Map a;

        public d(Map map) {
            AbstractC13042fc3.i(map, "data");
            this.a = map;
        }

        public final Map a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "PushReceived(data=" + this.a + Separators.RPAREN;
        }
    }

    public static final class e {
        private final AbstractC4398Ey5 a;

        public e(AbstractC4398Ey5 abstractC4398Ey5) {
            AbstractC13042fc3.i(abstractC4398Ey5, "pushNotification");
            this.a = abstractC4398Ey5;
        }

        public final AbstractC4398Ey5 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && AbstractC13042fc3.d(this.a, ((e) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "PushReceivedNew(pushNotification=" + this.a + Separators.RPAREN;
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C21165tD4 c;
        final /* synthetic */ OE4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C21165tD4 c21165tD4, OE4 oe4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c21165tD4;
            this.d = oe4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objC;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                FileReference fileReferenceB = this.c.b();
                C14970in2 c14970in2D = this.d.M0().D();
                AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
                this.b = 1;
                objC = AbstractC9915am2.c(fileReferenceB, c14970in2D, this);
                if (objC == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objC = ((C9475a16) obj).l();
            }
            return C9475a16.a(objC);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class g implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((AbstractC16407lD4.i.d) obj).i()), Long.valueOf(((AbstractC16407lD4.i.d) obj2).i()));
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C21231tK7 c;
        final /* synthetic */ OE4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C21231tK7 c21231tK7, OE4 oe4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c21231tK7;
            this.d = oe4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AvatarImage imageDefaultSize;
            FileReference fileReference;
            Object objC;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Avatar avatar = (Avatar) this.c.h().b();
                if (avatar == null || (imageDefaultSize = avatar.getImageDefaultSize()) == null || (fileReference = imageDefaultSize.getFileReference()) == null) {
                    return null;
                }
                C14970in2 c14970in2D = this.d.M0().D();
                AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
                this.b = 1;
                objC = AbstractC9915am2.c(fileReference, c14970in2D, this);
                if (objC == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objC = ((C9475a16) obj).l();
            }
            return C9475a16.a(objC);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OE4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        this.m = c9057Yh4;
        this.n = new LinkedHashMap();
        this.o = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.HE4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return OE4.k0();
            }
        });
        this.s = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.IE4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return OE4.o1();
            }
        });
    }

    private final C11458d25 A0(Intent intent) {
        String stringExtra = intent.getStringExtra("peerType");
        String stringExtra2 = intent.getStringExtra("update_peer_user_id");
        W25 w25 = AbstractC13042fc3.d(stringExtra, "2") ? W25.b : W25.a;
        AbstractC13042fc3.f(stringExtra2);
        return new C11458d25(w25, Integer.parseInt(stringExtra2));
    }

    private final void A1(String str, int i, long j) {
        if (!AbstractC13042fc3.d(str, "SUMMARY_SAPTA_NOTIFICATION_TAG")) {
            B00.a aVar = B00.b;
            C5721Ko c5721Ko = C5721Ko.a;
            B00 b00A = aVar.a(c5721Ko.d());
            b00A.z(new AbstractC16407lD4.h());
            b00A.t(true);
            b00A.r("group_message");
            b00A.h("msg");
            b00A.s(2);
            b00A.v(t0(c5721Ko.d()));
            b00A.B(j);
            b00A.y(KB5.ic_stat_white_notif_icon);
            b00A.g(true);
            J0().notify(str, i, b00A.e());
            return;
        }
        C5721Ko c5721Ko2 = C5721Ko.a;
        String string = c5721Ko2.d().getString(AbstractC12217eE5.pfm_tab);
        AbstractC13042fc3.h(string, "getString(...)");
        B00 b00A2 = B00.b.a(c5721Ko2.d());
        b00A2.k(string);
        b00A2.j(string);
        b00A2.v(t0(c5721Ko2.d()));
        b00A2.B(j);
        AbstractC16407lD4.h hVarO = new AbstractC16407lD4.h().n(string).o(string);
        AbstractC13042fc3.h(hVarO, "setSummaryText(...)");
        b00A2.z(hVarO);
        b00A2.y(KB5.ic_stat_white_notif_icon);
        b00A2.g(true);
        b00A2.r("group_sapta");
        b00A2.t(true);
        J0().notify(str, i, b00A2.e());
    }

    private final Intent B0(Map map) {
        Intent intentR0 = r0();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str2 != null) {
                intentR0.putExtra(str, str2);
            }
        }
        return intentR0;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void B1(ir.nasim.C21165tD4 r22, android.content.Context r23, android.content.Intent r24) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 647
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OE4.B1(ir.nasim.tD4, android.content.Context, android.content.Intent):void");
    }

    private final int C0(int i) {
        StatusBarNotification[] activeNotifications = J0().getActiveNotifications();
        AbstractC13042fc3.h(activeNotifications, "getActiveNotifications(...)");
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            String groupKey = statusBarNotification.getGroupKey();
            AbstractC13042fc3.h(groupKey, "getGroupKey(...)");
            if (AbstractC20762sZ6.X(groupKey, String.valueOf(i), false, 2, null)) {
                arrayList.add(statusBarNotification);
            }
        }
        if (arrayList.isEmpty()) {
            return 0;
        }
        return ((StatusBarNotification) AbstractC15401jX0.q0(arrayList)).getNotification().extras.getInt("counter", 0);
    }

    private final void C1(Context context, C21165tD4 c21165tD4, PendingIntent pendingIntent, C8455Wa6 c8455Wa6) {
        B00 b00A = B00.b.a(context);
        VP4 vp4 = VP4.a;
        b00A.n(vp4.b(context, c8455Wa6));
        b00A.o(vp4.d(context, c8455Wa6));
        b00A.m(vp4.c(context, c21165tD4.e().getPeerId(), c8455Wa6));
        b00A.k(vp4.k());
        b00A.j(vp4.h(c8455Wa6));
        b00A.z(new AbstractC16407lD4.g());
        b00A.y(KB5.ic_stat_white_notif_icon);
        b00A.B(Long.parseLong(c21165tD4.c()));
        b00A.g(true);
        b00A.r("group_sapta");
        b00A.v(pendingIntent);
        b00A.p(String.valueOf(c21165tD4.e().u()));
        if (AbstractC9599aE4.a.u()) {
            F1(context);
        }
        p1(b00A, c21165tD4.c(), 270066638);
        if (z1()) {
            A1("SUMMARY_SAPTA_NOTIFICATION_TAG", 1, Long.parseLong(c21165tD4.c()));
        }
    }

    private final AbstractC16407lD4.i D0(C21165tD4 c21165tD4) {
        StatusBarNotification[] statusBarNotificationArrB = GE4.b(J0());
        ArrayList<StatusBarNotification> arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
            String groupKey = statusBarNotification.getGroupKey();
            AbstractC13042fc3.h(groupKey, "getGroupKey(...)");
            if (AbstractC20762sZ6.X(groupKey, "group_message", false, 2, null)) {
                arrayList.add(statusBarNotification);
            }
        }
        for (StatusBarNotification statusBarNotification2 : arrayList) {
            if (AbstractC13042fc3.d(statusBarNotification2.getNotification().extras.getString(PinMessageEntity.COLS_PEER_UNIQUE_ID), String.valueOf(c21165tD4.e().u()))) {
                return AbstractC16407lD4.i.o(statusBarNotification2.getNotification());
            }
        }
        return null;
    }

    private final void D1(C21165tD4 c21165tD4, Context context, Intent intent, J44 j44) throws NumberFormatException {
        PendingIntent pendingIntentU0 = u0(intent, context);
        C8455Wa6 c8455Wa6A = C8455Wa6.h.a(j44);
        if (c8455Wa6A != null) {
            C1(context, c21165tD4, pendingIntentU0, c8455Wa6A);
        } else {
            B1(c21165tD4, context, intent);
        }
    }

    private final Notification E0(int i) {
        Notification notification = null;
        for (StatusBarNotification statusBarNotification : GE4.b(J0())) {
            if (statusBarNotification.getId() == i) {
                notification = statusBarNotification.getNotification();
            }
        }
        return notification;
    }

    private final void E1(AbstractC16407lD4.i iVar, int i) {
        String strF;
        Notification notificationE0 = E0(i);
        B00.a aVar = B00.b;
        C5721Ko c5721Ko = C5721Ko.a;
        B00 b00A = aVar.a(c5721Ko.d());
        b00A.f(notificationE0);
        b00A.z(iVar);
        b00A.i(AbstractC4043Dl1.c(c5721Ko.d(), TA5.notification_primary));
        b00A.y(KB5.ic_stat_white_notif_icon);
        b00A.g(true);
        b00A.r("group_message");
        b00A.u(true);
        SA6 sa6 = SA6.a;
        Context contextD = c5721Ko.d();
        String strValueOf = String.valueOf(i);
        D55 d55Q = iVar.q();
        AbstractC13042fc3.h(d55Q, "getUser(...)");
        C15791kA6 c15791kA6A = sa6.a(contextD, strValueOf, d55Q);
        if (c15791kA6A != null) {
            strF = c15791kA6A.f();
            b00A.x(c15791kA6A);
        } else {
            strF = "";
        }
        J0().notify(i, b00A.e());
        if (strF.length() > 0) {
            sa6.b(AbstractC9766aX0.e(strF));
        }
    }

    private final InterfaceC14123hO3 F0() {
        return (InterfaceC14123hO3) this.o.getValue();
    }

    private final void F1(Context context) {
        if (AbstractC9599aE4.a.u()) {
            new C11976ds().b(context);
        }
    }

    private final String G0(StatusBarNotification statusBarNotification) {
        return statusBarNotification.getNotification().extras.getString(DialogEntity.COLUMN_EX_PEER_TYPE);
    }

    private final ZN2 H0(C21165tD4 c21165tD4) {
        C14733iO2 c14733iO2 = (C14733iO2) this.m.E().Y1().n(c21165tD4.e().getPeerId());
        if (c14733iO2 != null) {
            return c14733iO2.q();
        }
        return null;
    }

    private final C14733iO2 I0(long j) {
        return (C14733iO2) this.m.E().Y1().n(j);
    }

    private final NotificationManager J0() {
        return (NotificationManager) this.s.getValue();
    }

    private final String K0(String str) {
        if (AbstractC20762sZ6.X(str, "@all", false, 2, null)) {
            String string = C5721Ko.a.d().getString(AbstractC12217eE5.notif_mention_all);
            AbstractC13042fc3.f(string);
            return string;
        }
        String string2 = C5721Ko.a.d().getString(AbstractC12217eE5.notif_mention, q0(str));
        AbstractC13042fc3.f(string2);
        return string2;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.AbstractC16407lD4.i L0(ir.nasim.C11458d25 r11, long r12, java.lang.String r14) {
        /*
            r10 = this;
            android.app.NotificationManager r0 = r10.J0()
            android.service.notification.StatusBarNotification[] r0 = ir.nasim.GE4.b(r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.length
            r3 = 0
            r4 = r3
        L10:
            if (r4 >= r2) goto L24
            r5 = r0[r4]
            int r6 = r5.getId()
            int r7 = r11.getPeerId()
            if (r6 != r7) goto L21
            r1.add(r5)
        L21:
            int r4 = r4 + 1
            goto L10
        L24:
            boolean r0 = r1.isEmpty()
            r2 = 0
            if (r0 == 0) goto L2c
            return r2
        L2c:
            java.lang.Object r0 = r1.get(r3)
            android.service.notification.StatusBarNotification r0 = (android.service.notification.StatusBarNotification) r0
            android.app.Notification r0 = r0.getNotification()
            ir.nasim.lD4$i r0 = ir.nasim.AbstractC16407lD4.i.o(r0)
            if (r0 == 0) goto Lff
            java.util.List r1 = r0.p()
            int r1 = r1.size()
        L44:
            if (r3 >= r1) goto Lff
            java.util.List r4 = r0.p()
            java.lang.Object r4 = r4.get(r3)
            ir.nasim.lD4$i$d r4 = (ir.nasim.AbstractC16407lD4.i.d) r4
            long r5 = r4.i()
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 != 0) goto Lfb
            android.os.Bundle r5 = r4.d()
            java.lang.String r6 = "pushType"
            java.lang.String r5 = r5.getString(r6)
            java.lang.String r6 = "REPLY"
            boolean r5 = ir.nasim.AbstractC13042fc3.d(r5, r6)
            if (r5 == 0) goto L6f
            java.lang.String r5 = r10.R0(r14)
            goto Ldc
        L6f:
            boolean r5 = r11.z()
            if (r5 == 0) goto Ldb
            ir.nasim.Yh4 r5 = r10.m
            ir.nasim.bQ2 r5 = r5.E()
            ir.nasim.VL3 r5 = r5.Y1()
            int r6 = r11.getPeerId()
            long r6 = (long) r6
            ir.nasim.id0 r5 = r5.n(r6)
            ir.nasim.iO2 r5 = (ir.nasim.C14733iO2) r5
            if (r5 == 0) goto L91
            ir.nasim.ZN2 r5 = r5.q()
            goto L92
        L91:
            r5 = r2
        L92:
            ir.nasim.ZN2 r6 = ir.nasim.ZN2.GROUP
            if (r5 != r6) goto Ldb
            ir.nasim.tK7 r5 = ir.nasim.AbstractC5969Lp4.c()
            if (r5 == 0) goto Ldb
            ir.nasim.bZ6 r5 = r5.s()
            if (r5 == 0) goto Ldb
            java.lang.Object r5 = r5.b()
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto Ldb
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r6 = r14.toLowerCase(r6)
            java.lang.String r7 = "toLowerCase(...)"
            ir.nasim.AbstractC13042fc3.h(r6, r7)
            ir.nasim.sM5 r7 = new ir.nasim.sM5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "@("
            r8.append(r9)
            r8.append(r5)
            java.lang.String r5 = "|all)(:|\\s+|$)"
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r7.<init>(r5)
            boolean r5 = r7.a(r6)
            if (r5 == 0) goto Ldb
            java.lang.String r5 = r10.K0(r14)
            goto Ldc
        Ldb:
            r5 = r14
        Ldc:
            ir.nasim.lD4$i$d r6 = new ir.nasim.lD4$i$d
            long r7 = r4.i()
            ir.nasim.D55 r9 = r4.g()
            r6.<init>(r5, r7, r9)
            android.os.Bundle r5 = r6.d()
            android.os.Bundle r4 = r4.d()
            r5.putAll(r4)
            java.util.List r4 = r0.p()
            r4.set(r3, r6)
        Lfb:
            int r3 = r3 + 1
            goto L44
        Lff:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OE4.L0(ir.nasim.d25, long, java.lang.String):ir.nasim.lD4$i");
    }

    private final int N0(int i) {
        AbstractC16407lD4.i iVarO;
        List listP;
        StatusBarNotification[] statusBarNotificationArrB = GE4.b(J0());
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
            String key = statusBarNotification.getKey();
            AbstractC13042fc3.h(key, "getKey(...)");
            if (AbstractC20762sZ6.X(key, String.valueOf(i), false, 2, null)) {
                arrayList.add(statusBarNotification);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            String groupKey = ((StatusBarNotification) obj).getGroupKey();
            AbstractC13042fc3.h(groupKey, "getGroupKey(...)");
            if (AbstractC20762sZ6.X(groupKey, "group_message", false, 2, null)) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        if (!it.hasNext() || (iVarO = AbstractC16407lD4.i.o(((StatusBarNotification) it.next()).getNotification())) == null || (listP = iVarO.p()) == null) {
            return 0;
        }
        return listP.size();
    }

    private final D55 O0(C21165tD4 c21165tD4, AbstractC16407lD4.i iVar) {
        long jH = c21165tD4.h();
        Iterator it = iVar.p().iterator();
        while (it.hasNext()) {
            D55 d55G = ((AbstractC16407lD4.i.d) it.next()).g();
            if (AbstractC13042fc3.d(String.valueOf(jH), d55G != null ? d55G.e() : null)) {
                return d55G;
            }
        }
        D55 d55A = new D55.c().e(String.valueOf(jH)).f(T0(jH)).c(IconCompat.i(S0(jH))).a();
        AbstractC13042fc3.h(d55A, "build(...)");
        return d55A;
    }

    private final String P0(AbstractC16407lD4.i.d dVar) {
        return dVar.d().getString("pushType");
    }

    private final String Q0(String str, String str2) {
        String string = C5721Ko.a.d().getString(AbstractC12217eE5.notif_private_reaction, str2, q0(str));
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final String R0(String str) {
        String string = C5721Ko.a.d().getString(AbstractC12217eE5.notif_reply, q0(str));
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final Bitmap S0(long j) {
        C9475a16 c9475a16;
        String strT0 = T0(j);
        C21231tK7 c21231tK7U0 = U0(j);
        if (c21231tK7U0 != null && (c9475a16 = (C9475a16) AbstractC9913am0.b(null, new h(c21231tK7U0, this, null), 1, null)) != null) {
            Object objL = c9475a16.l();
            if (C9475a16.j(objL)) {
                return C16670lg0.d(c21231tK7U0.o(), strT0, (String) objL);
            }
            C9475a16.a(objL);
        }
        return C16670lg0.f(strT0, (int) j);
    }

    private final String T0(long j) {
        if (m1(j)) {
            String string = C5721Ko.a.d().getString(AbstractC12217eE5.f71me);
            AbstractC13042fc3.f(string);
            return string;
        }
        C21231tK7 c21231tK7U0 = U0(j);
        String string2 = c21231tK7U0 != null ? (String) c21231tK7U0.r().b() : C5721Ko.a.d().getString(AbstractC12217eE5.all_default_user_title);
        AbstractC13042fc3.f(string2);
        return string2;
    }

    private final C21231tK7 U0(long j) {
        return (C21231tK7) this.m.W().o0().n(j);
    }

    private final void W0(Map map) {
        C15958kT2 c15958kT2 = this.r;
        if (c15958kT2 == null) {
            AbstractC13042fc3.y("handlePushDatabase");
            c15958kT2 = null;
        }
        if (!c15958kT2.f(map)) {
            C19406qI3.j("stashHandler", "handlePushDatabase.handle return false, so return", new Object[0]);
            return;
        }
        Intent intentB0 = B0(map);
        C11458d25 c11458d25A0 = A0(intentB0);
        String stringExtra = intentB0.getStringExtra("messageDates");
        if (XY6.m(stringExtra)) {
            C19406qI3.j("stashHandler", "handleDeleteUpdate messageDatesString is null, so return", new Object[0]);
            return;
        }
        long[] jArr = (long[]) new KS2().k(stringExtra, long[].class);
        if (jArr == null) {
            jArr = new long[0];
        }
        t1(c11458d25A0, jArr);
    }

    private final void X0(Map map) throws NumberFormatException {
        if (map.containsKey("messageDates")) {
            map.put("messageDate", map.get("messageDates"));
        }
        C15958kT2 c15958kT2 = this.r;
        C15958kT2 c15958kT22 = null;
        if (c15958kT2 == null) {
            AbstractC13042fc3.y("handlePushDatabase");
            c15958kT2 = null;
        }
        if (!c15958kT2.f(map)) {
            C19406qI3.j("stashHandler", "handlePushDatabase.handle return false, so return", new Object[0]);
            return;
        }
        C15958kT2 c15958kT23 = this.r;
        if (c15958kT23 == null) {
            AbstractC13042fc3.y("handlePushDatabase");
        } else {
            c15958kT22 = c15958kT23;
        }
        C12118e42 c12118e42G = c15958kT22.g();
        p0(map);
        if (c12118e42G.b()) {
            Z0(map);
            C19406qI3.j("stashHandler", "handleEditUpdate: converted edit push to message push", new Object[0]);
            return;
        }
        if (AbstractC13042fc3.d(c12118e42G.a(), "EDIT") && !c12118e42G.c()) {
            C19406qI3.j("stashHandler", "handleEditUpdate: prevPushType == edit - not newest - return", new Object[0]);
            return;
        }
        Intent intentB0 = B0(map);
        String stringExtra = intentB0.getStringExtra("messageDate");
        if (XY6.m(stringExtra)) {
            C19406qI3.a("stashHandler", ":handleEditUpdate messageDateString is null, so return", new Object[0]);
            return;
        }
        C21165tD4.a aVar = C21165tD4.l;
        C11458d25 c11458d25A = aVar.a(intentB0);
        AbstractC16407lD4.i iVarL0 = L0(c11458d25A, stringExtra != null ? Long.parseLong(stringExtra) : 0L, aVar.f(c11458d25A, intentB0));
        if (iVarL0 != null) {
            E1(iVarL0, c11458d25A.getPeerId());
        }
    }

    private final void Y0(String str, AbstractC16407lD4.i.d dVar, StatusBarNotification statusBarNotification) {
        if (AbstractC13042fc3.d(str, "CHANNEL") && n1(dVar.i(), 7)) {
            GE4.e(J0(), statusBarNotification.getId(), null, 2, null);
        }
    }

    private final void Z0(Map map) throws NumberFormatException {
        C19406qI3.a("stashHandler", "handleMessagePush start", new Object[0]);
        if (!map.containsKey("peer_user_id")) {
            C19406qI3.a("stashHandler", "handleMessagePush return because it does not contains peer_user_id", new Object[0]);
            return;
        }
        C19406qI3.a("stashHandler", "handleMessagePush , peerId: " + map.get("peer_user_id"), new Object[0]);
        Intent intentB0 = B0(map);
        C21165tD4 c21165tD4B = C21165tD4.l.b(intentB0);
        AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
        int peerId = c21165tD4B.e().getPeerId();
        String str = (String) map.get("threadMessageRID");
        if (!aVar.q(peerId, str != null ? AbstractC19562qZ6.q(str) : null)) {
            if (c21165tD4B.e().getPeerId() == 270066638) {
                d1(c21165tD4B, C5721Ko.a.d(), intentB0);
            } else {
                B1(c21165tD4B, C5721Ko.a.d(), intentB0);
            }
            C19406qI3.a("stashHandler", "handleMessagePush end", new Object[0]);
            return;
        }
        C19406qI3.j("stashHandler", "handleMessagePush: current peer is opened, so return and don't display push. peerId: " + c21165tD4B.e().getPeerId(), new Object[0]);
    }

    private final void a1(String str, String str2, AbstractC16407lD4.i.d dVar, StatusBarNotification statusBarNotification) {
        if (AbstractC13042fc3.d(str, TokenNames.MESSAGE)) {
            Y0(str2, dVar, statusBarNotification);
        } else if (AbstractC13042fc3.d(str, "STORY")) {
            h1(dVar, statusBarNotification);
        }
    }

    private final void b1(Map map) throws NumberFormatException {
        String str = (String) map.get(DialogEntity.COLUMN_EX_PEER_TYPE);
        if (AbstractC13042fc3.d(str, "1") || AbstractC13042fc3.d(str, "2")) {
            String str2 = (String) map.get("isSet");
            if (str2 != null ? Boolean.parseBoolean(str2) : false) {
                map.put("peer_user_id", map.get("peerId"));
                map.put("baseMessage", map.get("apiMessage"));
                map.put("MessageRID", map.get("messageRid"));
                long[] jArr = (long[]) new KS2().k((String) map.get("userIds"), long[].class);
                if (jArr == null) {
                    jArr = new long[0];
                }
                if (jArr.length == 0) {
                    C19406qI3.a("stashHandler", "handleReactionPush userIds is empty so returned!", new Object[0]);
                    return;
                } else {
                    map.put("senderUserId", String.valueOf(jArr[0]));
                    Z0(map);
                    return;
                }
            }
            String str3 = (String) map.get("peerId");
            if (str3 == null) {
                return;
            }
            C11458d25 c11458d25 = new C11458d25(W25.a, Integer.parseInt(str3));
            String str4 = (String) map.get("messageDate");
            long j = str4 != null ? Long.parseLong(str4) : 0L;
            if (j != 0) {
                t1(c11458d25, new long[]{j});
                return;
            }
            C19406qI3.a("stashHandler", "Dislike reaction ignored, because its date is: " + j, new Object[0]);
        }
    }

    private final void c1(Map map) {
        if (GE4.b(J0()).length == 0) {
            return;
        }
        GE4.e(J0(), A0(B0(map)).getPeerId(), null, 2, null);
    }

    private final void d1(final C21165tD4 c21165tD4, final Context context, final Intent intent) throws NumberFormatException {
        if (c21165tD4.c().length() == 0) {
            C19406qI3.j("stashHandler", "handleSaptaNotification, messageDate empty, so return", new Object[0]);
        } else if (c21165tD4.d().length() != 0) {
            this.m.G().w0(c21165tD4.e(), Long.parseLong(c21165tD4.c()), Long.parseLong(c21165tD4.d())).m0(new InterfaceC24449ye1() { // from class: ir.nasim.ME4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) throws NumberFormatException {
                    OE4.e1(this.a, c21165tD4, context, intent, (J44) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.NE4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) throws NumberFormatException {
                    OE4.f1(c21165tD4, this, context, intent, (Exception) obj);
                }
            });
        } else {
            C19406qI3.j("stashHandler", "handleSaptaNotification, messageRid empty, so show regular message push", new Object[0]);
            B1(c21165tD4, context, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(OE4 oe4, C21165tD4 c21165tD4, Context context, Intent intent, J44 j44) throws NumberFormatException {
        AbstractC13042fc3.i(oe4, "this$0");
        AbstractC13042fc3.i(c21165tD4, "$notificationData");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(intent, "$intent");
        AbstractC13042fc3.f(j44);
        oe4.D1(c21165tD4, context, intent, j44);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(C21165tD4 c21165tD4, OE4 oe4, Context context, Intent intent, Exception exc) throws NumberFormatException {
        AbstractC13042fc3.i(c21165tD4, "$notificationData");
        AbstractC13042fc3.i(oe4, "this$0");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(intent, "$intent");
        C19406qI3.j("stashHandler", "handleSaptaNotification, findMessage failed, so show regular message push\nmessage date : " + c21165tD4.c() + "\n message rid : " + c21165tD4.d(), new Object[0]);
        oe4.B1(c21165tD4, context, intent);
    }

    private final void h1(AbstractC16407lD4.i.d dVar, StatusBarNotification statusBarNotification) {
        if (n1(dVar.i(), 1)) {
            GE4.e(J0(), statusBarNotification.getId(), null, 2, null);
        }
    }

    private final void i1(final Map map) throws NumberFormatException {
        String str;
        if (((String) map.get("storyId")) == null || (str = (String) map.get("peerId")) == null) {
            return;
        }
        long j = Long.parseLong(str);
        String str2 = (String) map.get(DialogEntity.COLUMN_EX_PEER_TYPE);
        if ((AbstractC13042fc3.d(str2, "3") || AbstractC13042fc3.d(str2, "2")) && !this.m.S().B5(EnumC4716Gg2.s)) {
            return;
        }
        String str3 = (String) map.get("action");
        String str4 = (String) map.get("isSet");
        boolean z = str4 != null ? Boolean.parseBoolean(str4) : false;
        if (AbstractC13042fc3.d(str3, "SEEN") || !z) {
            C11458d25 c11458d25 = new C11458d25(AbstractC13042fc3.d(str2, "3") ? W25.b : W25.a, (int) j);
            String str5 = (String) map.get("storyDate");
            if ((str5 != null ? Long.parseLong(str5) : 0L) != 0) {
                GE4.e(J0(), c11458d25.getPeerId(), null, 2, null);
                return;
            } else {
                C19406qI3.a("stashHandler", "story notification ignored", new Object[0]);
                return;
            }
        }
        map.put("peer_user_id", String.valueOf(j));
        map.put("senderUserId", String.valueOf(j));
        map.put("peerType", str2);
        map.put(ParameterNames.TEXT, map.get("title"));
        map.put("messageDate", map.get("storyDate"));
        if (AbstractC13042fc3.d(str3, "LIKE")) {
            if (this.m.S().B5(EnumC4716Gg2.r)) {
                map.put("peer_user_id", String.valueOf(this.m.w().p()));
                map.put(ParameterNames.ICON, map.get("action"));
                map.put("title", C5721Ko.a.d().getString(AbstractC12217eE5.story_notification_title));
                Z0(map);
                return;
            }
            return;
        }
        if (AbstractC13042fc3.d(str2, "1")) {
            this.m.W().o0().k(j).m0(new InterfaceC24449ye1() { // from class: ir.nasim.JE4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) throws NumberFormatException {
                    OE4.k1(map, this, map, (C21231tK7) obj);
                }
            });
        } else if (AbstractC13042fc3.d(str2, "3")) {
            this.m.E().Y1().k(j).m0(new InterfaceC24449ye1() { // from class: ir.nasim.KE4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) throws NumberFormatException {
                    OE4.j1(map, this, map, (C14733iO2) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(Map map, OE4 oe4, Map map2, C14733iO2 c14733iO2) throws NumberFormatException {
        String str;
        C10410bZ6 c10410bZ6V;
        AbstractC13042fc3.i(map, "$pushData");
        AbstractC13042fc3.i(oe4, "this$0");
        AbstractC13042fc3.i(map2, "$data");
        if (c14733iO2 == null || (c10410bZ6V = c14733iO2.v()) == null || (str = (String) c10410bZ6V.b()) == null) {
            str = "";
        }
        map.put("title", str);
        oe4.Z0(map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC14123hO3 k0() {
        return ((BD4) C92.a(C5721Ko.a.d(), BD4.class)).R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(Map map, OE4 oe4, Map map2, C21231tK7 c21231tK7) throws NumberFormatException {
        String str;
        C10410bZ6 c10410bZ6R;
        AbstractC13042fc3.i(map, "$pushData");
        AbstractC13042fc3.i(oe4, "this$0");
        AbstractC13042fc3.i(map2, "$data");
        if (c21231tK7 == null || (c10410bZ6R = c21231tK7.r()) == null || (str = (String) c10410bZ6R.b()) == null) {
            str = "";
        }
        map.put("title", str);
        oe4.Z0(map2);
    }

    private final boolean l0(C21165tD4 c21165tD4) {
        if (AbstractC13042fc3.d(c21165tD4.f(), "REACTION") || AbstractC13042fc3.d(c21165tD4.f(), "STORY")) {
            return true;
        }
        Long l = (Long) AbstractC5969Lp4.d().P(c21165tD4.e()).h().b();
        Long lQ = AbstractC19562qZ6.q(c21165tD4.c());
        return lQ == null || l == null || lQ.longValue() > l.longValue();
    }

    private final boolean l1(C21165tD4 c21165tD4) {
        if (!SA6.a.c() || c21165tD4.e().s() != W25.b) {
            return false;
        }
        C14733iO2 c14733iO2I0 = I0(c21165tD4.e().getPeerId());
        return (c14733iO2I0 != null ? c14733iO2I0.q() : null) == ZN2.GROUP;
    }

    private final boolean m0(String str) {
        return !AbstractC13042fc3.d(str, "STORY");
    }

    private final boolean m1(long j) {
        return j == ((long) this.m.w().p());
    }

    private final boolean n0(C21165tD4 c21165tD4) {
        C14733iO2 c14733iO2I0;
        boolean z = !AbstractC13042fc3.d(c21165tD4.f(), "STORY");
        if (c21165tD4.e().s() != W25.b || (c14733iO2I0 = I0(c21165tD4.e().getPeerId())) == null) {
            return z;
        }
        return z && c14733iO2I0.q() == ZN2.GROUP;
    }

    private final boolean n1(long j, int i) {
        return TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - j) > ((long) i);
    }

    private final void o0() {
        for (StatusBarNotification statusBarNotification : AbstractC10242bK.f1(GE4.b(J0()))) {
            AbstractC16407lD4.i iVarZ0 = z0(statusBarNotification);
            if (iVarZ0 != null) {
                List listP = iVarZ0.p();
                AbstractC13042fc3.h(listP, "getMessages(...)");
                List<AbstractC16407lD4.i.d> list = listP;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (AbstractC16407lD4.i.d dVar : list) {
                        AbstractC13042fc3.f(dVar);
                        String strP0 = P0(dVar);
                        if (AbstractC15401jX0.i0(AbstractC10360bX0.p(TokenNames.MESSAGE, "STORY"), strP0)) {
                            if (!n1(dVar.i(), AbstractC13042fc3.d(strP0, "STORY") ? 1 : 7)) {
                                break;
                            }
                        }
                    }
                }
                List<AbstractC16407lD4.i.d> listP2 = iVarZ0.p();
                AbstractC13042fc3.h(listP2, "getMessages(...)");
                for (AbstractC16407lD4.i.d dVar2 : listP2) {
                    AbstractC13042fc3.f(dVar2);
                    a1(P0(dVar2), G0(statusBarNotification), dVar2, statusBarNotification);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager o1() {
        Object systemService = C5721Ko.a.d().getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    private final void p0(Map map) {
        String str = (String) map.get("editedText");
        String str2 = (String) map.get("update_peer_user_id");
        map.remove("editedText");
        map.remove("update_peer_user_id");
        map.put(ParameterNames.TEXT, str);
        map.put("peer_user_id", str2);
    }

    private final void p1(B00 b00, String str, int i) {
        J0().notify(str, i, b00.e());
    }

    private final String q0(String str) {
        String strK = new C20644sM5("[\\t\\n\\r]+").k(str, Separators.SP);
        if (strK.length() <= 20) {
            return strK;
        }
        return ((Object) strK.subSequence(0, 19)) + "...";
    }

    private final void q1(Map map) throws NumberFormatException {
        C19406qI3.a("PushHandler", "onPushReceived type: " + map.get("pushType"), new Object[0]);
        String str = (String) map.get("pushType");
        if (str != null) {
            C15958kT2 c15958kT2 = null;
            switch (str.hashCode()) {
                case -84882903:
                    if (str.equals("REACTION")) {
                        b1(map);
                        return;
                    }
                    return;
                case 2060894:
                    if (str.equals("CALL")) {
                        g1(map);
                        return;
                    }
                    return;
                case 2123274:
                    if (str.equals("EDIT")) {
                        X0(map);
                        return;
                    }
                    return;
                case 2511254:
                    if (str.equals("READ")) {
                        c1(map);
                        return;
                    }
                    return;
                case 77863626:
                    if (!str.equals("REPLY")) {
                        return;
                    }
                    break;
                case 79233237:
                    if (str.equals("STORY")) {
                        i1(map);
                        return;
                    }
                    return;
                case 1668327882:
                    if (!str.equals("MENTION")) {
                        return;
                    }
                    break;
                case 1672907751:
                    if (str.equals(TokenNames.MESSAGE)) {
                        C15958kT2 c15958kT22 = this.r;
                        if (c15958kT22 == null) {
                            AbstractC13042fc3.y("handlePushDatabase");
                        } else {
                            c15958kT2 = c15958kT22;
                        }
                        if (c15958kT2.f(map)) {
                            Z0(map);
                            return;
                        } else {
                            C19406qI3.j("stashHandler", "handleMessagePush return false, so return", new Object[0]);
                            return;
                        }
                    }
                    return;
                case 2012838315:
                    if (str.equals("DELETE")) {
                        W0(map);
                        return;
                    }
                    return;
                default:
                    return;
            }
            C15958kT2 c15958kT23 = this.r;
            if (c15958kT23 == null) {
                AbstractC13042fc3.y("handlePushDatabase");
            } else {
                c15958kT2 = c15958kT23;
            }
            if (c15958kT2.f(map)) {
                Z0(map);
            } else {
                C19406qI3.j("stashHandler", "handleMessagePush PUSH_TYPE_MENTION or PUSH_TYPE_REPLY return because of database.", new Object[0]);
            }
        }
    }

    private final Intent r0() {
        Intent intent = new Intent(C5721Ko.a.d(), (Class<?>) MainActivity.class);
        intent.addFlags(67108864);
        return intent;
    }

    private final void r1(AbstractC4398Ey5 abstractC4398Ey5) {
        C19406qI3.a("PushHandler", "onPushReceivedNew type: " + abstractC4398Ey5.c().name(), new Object[0]);
        w1(abstractC4398Ey5);
        try {
            C3696By5 c3696By5 = new C3696By5();
            HD4 hd4 = this.p;
            CE4 ce4 = null;
            if (hd4 == null) {
                AbstractC13042fc3.y("notificationRecordDao");
                hd4 = null;
            }
            CE4 ce42 = this.q;
            if (ce42 == null) {
                AbstractC13042fc3.y("notificationUIManager");
            } else {
                ce4 = ce42;
            }
            AbstractC3457Ay5 abstractC3457Ay5A = c3696By5.a(abstractC4398Ey5, hd4, ce4);
            if (abstractC3457Ay5A != null) {
                abstractC3457Ay5A.d();
                C19406qI3.a("PushHandler", "onPushReceivedNew notification handled successfully", new Object[0]);
                return;
            }
            C19406qI3.a("PushHandler", "onPushReceivedNew there is no handler for push type: " + abstractC4398Ey5.c().name(), new Object[0]);
        } catch (Exception e2) {
            C19406qI3.a("PushHandler", "onPushReceivedNew exception handling notification: " + e2.getMessage(), new Object[0]);
        }
    }

    private final AbstractC16407lD4.i s0(C21165tD4 c21165tD4) {
        String strJ = c21165tD4.j();
        if (strJ != null && AbstractC13042fc3.d(strJ, "LIKE")) {
            D55 d55A = new D55.c().c(IconCompat.l(C5721Ko.a.d(), KB5.ic_story_like_notification)).f(c21165tD4.l()).a();
            AbstractC13042fc3.h(d55A, "build(...)");
            AbstractC16407lD4.i iVarS = new AbstractC16407lD4.i(d55A).s(c21165tD4.l());
            AbstractC13042fc3.h(iVarS, "setConversationTitle(...)");
            return iVarS;
        }
        FileReference fileReferenceB = c21165tD4.b();
        if ((fileReferenceB != null ? Long.valueOf(fileReferenceB.getFileId()) : null) != null) {
            Object objL = ((C9475a16) AbstractC9913am0.b(null, new f(c21165tD4, this, null), 1, null)).l();
            if (C9475a16.j(objL)) {
                D55 d55A2 = new D55.c().c(IconCompat.i(C16670lg0.h(C16670lg0.d(c21165tD4.e().getPeerId(), c21165tD4.l(), (String) objL)))).f(c21165tD4.l()).a();
                AbstractC13042fc3.h(d55A2, "build(...)");
                return new AbstractC16407lD4.i(d55A2);
            }
        }
        D55 d55A3 = new D55.c().c(IconCompat.i(C16670lg0.h(C16670lg0.f(c21165tD4.l(), c21165tD4.e().getPeerId())))).f(c21165tD4.l()).a();
        AbstractC13042fc3.h(d55A3, "build(...)");
        return new AbstractC16407lD4.i(d55A3);
    }

    private final void s1(c cVar) {
        V0(cVar.b(), cVar.a());
    }

    private final PendingIntent t0(Context context) {
        Intent intent = new Intent(C5721Ko.a.d(), (Class<?>) MainActivity.class);
        intent.addFlags(67108864);
        intent.setAction("OPEN_APP");
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 33554432);
        AbstractC13042fc3.h(activity, "getActivity(...)");
        return activity;
    }

    private final void t1(C11458d25 c11458d25, long[] jArr) {
        AbstractC16407lD4.i iVarU1 = u1(c11458d25, jArr);
        if (iVarU1 == null || iVarU1.p().isEmpty()) {
            GE4.e(J0(), c11458d25.getPeerId(), null, 2, null);
        } else {
            E1(iVarU1, c11458d25.getPeerId());
        }
    }

    private final PendingIntent u0(Intent intent, Context context) {
        int time = (int) new Date().getTime();
        intent.setAction("ir.nasim.intent.NOTIFICATION" + time);
        PendingIntent activity = PendingIntent.getActivity(context, time, intent, 33554432);
        AbstractC13042fc3.h(activity, "getActivity(...)");
        return activity;
    }

    private final AbstractC16407lD4.i u1(C11458d25 c11458d25, final long[] jArr) {
        AbstractC16407lD4.i iVarO;
        StatusBarNotification[] statusBarNotificationArrB = GE4.b(J0());
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
            if (statusBarNotification.getId() == c11458d25.getPeerId()) {
                arrayList.add(statusBarNotification);
            }
        }
        if (arrayList.isEmpty() || (iVarO = AbstractC16407lD4.i.o(((StatusBarNotification) arrayList.get(0)).getNotification())) == null) {
            return null;
        }
        List listP = iVarO.p();
        AbstractC13042fc3.h(listP, "getMessages(...)");
        AbstractC13610gX0.K(listP, new UA2() { // from class: ir.nasim.LE4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(OE4.v1(jArr, (AbstractC16407lD4.i.d) obj));
            }
        });
        return iVarO;
    }

    private final PendingIntent v0(int i, long j) {
        C5721Ko c5721Ko = C5721Ko.a;
        Intent intent = new Intent(c5721Ko.d(), (Class<?>) TrampolineActivity.class);
        intent.setAction("ir.nasim.intent.NOTIFICATION" + ((int) new Date().getTime()));
        intent.putExtra("PEER_ID", i);
        intent.putExtra("DATE", j);
        PendingIntent activity = PendingIntent.getActivity(c5721Ko.d(), 0, intent, 335544320);
        AbstractC13042fc3.h(activity, "getActivity(...)");
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v1(long[] jArr, AbstractC16407lD4.i.d dVar) {
        AbstractC13042fc3.i(jArr, "$datesForDelete");
        return AbstractC10242bK.T(jArr, dVar.d().getLong("messageDate"));
    }

    private final PendingIntent w0(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://ble.ir/story-fragment"));
        if (z) {
            intent.putExtra("STORY_ID_EXTRA", str);
        }
        PendingIntent activity = PendingIntent.getActivity(C5721Ko.a.d(), 100093, intent, 201326592);
        AbstractC13042fc3.h(activity, "getActivity(...)");
        return activity;
    }

    private final void w1(AbstractC4398Ey5 abstractC4398Ey5) {
        try {
            Intent intentA = abstractC4398Ey5.a();
            Bundle extras = intentA.getExtras();
            Object obj = extras != null ? extras.get("pushType") : null;
            EnumC13889gz5 enumC13889gz5 = obj instanceof EnumC13889gz5 ? (EnumC13889gz5) obj : null;
            if (enumC13889gz5 == null) {
                enumC13889gz5 = EnumC13889gz5.b;
            }
            String stringExtra = intentA.getStringExtra("peer_user_id");
            if (stringExtra == null && (stringExtra = intentA.getStringExtra("update_peer_user_id")) == null) {
                stringExtra = "0";
            }
            int iN0 = N0(Integer.parseInt(stringExtra));
            String stringExtra2 = intentA.getStringExtra("storyId");
            if (stringExtra2 == null) {
                stringExtra2 = "0";
            }
            String stringExtra3 = intentA.getStringExtra("MessageRID");
            if (stringExtra3 == null) {
                stringExtra3 = "0";
            }
            String stringExtra4 = intentA.getStringExtra("peerType");
            if (stringExtra4 == null) {
                stringExtra4 = "0";
            }
            long longExtra = intentA.getLongExtra("messageDate", 0L);
            String str = abstractC4398Ey5.d() instanceof AbstractC6544Ny5.a ? "client" : "firebase";
            String str2 = stringExtra3 + longExtra;
            List listP = AbstractC10360bX0.p(EnumC13889gz5.d, EnumC13889gz5.c, EnumC13889gz5.e);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("push_type", Integer.valueOf(enumC13889gz5.ordinal()));
            linkedHashMap.put("event_type", str);
            if (!AbstractC13042fc3.d(stringExtra, "0")) {
                linkedHashMap.put("peer_id", Integer.valueOf(Integer.parseInt(stringExtra)));
            }
            if (!AbstractC13042fc3.d(stringExtra4, "0")) {
                linkedHashMap.put("peer_type", Integer.valueOf(Integer.parseInt(stringExtra4)));
            }
            if (!AbstractC13042fc3.d(stringExtra2, "0")) {
                linkedHashMap.put("story_id", Integer.valueOf(Integer.parseInt(stringExtra2)));
            }
            if (AbstractC13042fc3.d(stringExtra3, "0") || longExtra == 0 || listP.contains(enumC13889gz5)) {
                return;
            }
            linkedHashMap.put(DialogEntity.COLUMN_RID, Long.valueOf(Long.parseLong(stringExtra3)));
            linkedHashMap.put("msg_date", Integer.valueOf((int) longExtra));
            linkedHashMap.put("notif_id", str2);
            linkedHashMap.put("group_count", Integer.valueOf(iN0));
            if (this.n.get(str2) == null) {
                C3343Am.i("receive_notification", linkedHashMap);
            }
            this.n.put(str2, Boolean.TRUE);
        } catch (Exception e2) {
            C19406qI3.c("stashHandler", "sendReceivedPushEvent", e2);
        }
    }

    private final PendingIntent x0(C21165tD4 c21165tD4, Intent intent, Context context) {
        if (AbstractC13042fc3.d("STORY", c21165tD4.f())) {
            String stringExtra = intent.getStringExtra("storyId");
            if (stringExtra == null) {
                stringExtra = "";
            }
            return w0(context, stringExtra, AbstractC13042fc3.d(intent.getStringExtra("action"), "LIKE"));
        }
        StatusBarNotification[] statusBarNotificationArrB = GE4.b(J0());
        ArrayList<StatusBarNotification> arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
            String groupKey = statusBarNotification.getGroupKey();
            AbstractC13042fc3.h(groupKey, "getGroupKey(...)");
            if (AbstractC20762sZ6.X(groupKey, "group_message", false, 2, null)) {
                arrayList.add(statusBarNotification);
            }
        }
        for (StatusBarNotification statusBarNotification2 : arrayList) {
            Bundle bundle = statusBarNotification2.getNotification().extras;
            if (AbstractC13042fc3.d(bundle.getString(PinMessageEntity.COLS_PEER_UNIQUE_ID), String.valueOf(c21165tD4.e().u())) && AbstractC13042fc3.d(bundle.getString("pushType"), "REACTION")) {
                PendingIntent pendingIntent = statusBarNotification2.getNotification().contentIntent;
                AbstractC13042fc3.h(pendingIntent, "contentIntent");
                return pendingIntent;
            }
        }
        return u0(intent, context);
    }

    private final boolean x1(String str) {
        return (AbstractC13042fc3.d(str, "REACTION") || AbstractC13042fc3.d(str, "MENTION") || AbstractC13042fc3.d(str, "REPLY")) ? false : true;
    }

    private final void y0(String str, C21165tD4 c21165tD4, D55 d55, B00 b00, AbstractC16407lD4.i iVar, String str2, Uri uri, String str3) throws NumberFormatException {
        CharSequence charSequenceH;
        AbstractC16407lD4.i.d dVar = new AbstractC16407lD4.i.d(str, c21165tD4.i(), d55);
        dVar.j(str3, uri);
        long j = Long.parseLong(c21165tD4.c());
        dVar.d().putLong("messageDate", j);
        dVar.d().putString("pushType", c21165tD4.f());
        iVar.n(dVar);
        if (dVar.c() != null && (charSequenceH = dVar.h()) != null && (!AbstractC20762sZ6.n0(charSequenceH))) {
            AbstractC16407lD4.i.d dVar2 = new AbstractC16407lD4.i.d(dVar.h(), dVar.i(), dVar.g());
            dVar2.d().putLong("messageDate", j);
            dVar2.d().putString("pushType", c21165tD4.f());
            iVar.n(dVar2);
        }
        try {
            List listP = iVar.p();
            AbstractC13042fc3.h(listP, "getMessages(...)");
            if (listP.size() > 1) {
                AbstractC12992fX0.B(listP, new g());
            }
        } catch (Exception e2) {
            C19406qI3.c("stashHandler", "Error in sorting push messages, peerId: " + c21165tD4.e().getPeerId(), e2);
        }
        b00.z(iVar);
        if (AbstractC9599aE4.a.u()) {
            F1(C5721Ko.a.d());
        }
        C19406qI3.a("stashHandler", "notify notification, peerId: " + c21165tD4.e().getPeerId(), new Object[0]);
        J0().notify(c21165tD4.e().getPeerId(), b00.e());
        if (str2.length() > 0) {
            SA6.a.b(AbstractC9766aX0.e(str2));
        }
        if (z1()) {
            A1("summaryTag", 0, Long.parseLong(c21165tD4.c()));
        }
    }

    private final boolean y1(String str) {
        boolean zX1 = x1(str);
        if (zX1) {
            return AbstractC5969Lp4.d().o0(this.m.v().E().h().b() == EnumC19739qr4.MOBILE);
        }
        return zX1;
    }

    private final AbstractC16407lD4.i z0(StatusBarNotification statusBarNotification) {
        return AbstractC16407lD4.i.o(statusBarNotification.getNotification());
    }

    private final boolean z1() {
        return true;
    }

    public final C9057Yh4 M0() {
        return this.m;
    }

    public final void V0(int i, long j) {
        int iC0 = C0(i) + 1;
        String strT0 = T0(i);
        PendingIntent pendingIntentV0 = v0(i, j);
        C5721Ko c5721Ko = C5721Ko.a;
        String string = c5721Ko.d().getString(AbstractC12217eE5.other_account_notif, GY6.a(String.valueOf(iC0)), strT0);
        AbstractC13042fc3.h(string, "getString(...)");
        B00 b00A = B00.b.a(c5721Ko.d());
        b00A.k(string);
        b00A.z(new AbstractC16407lD4.h());
        b00A.l(iC0);
        b00A.y(KB5.ic_stat_white_notif_icon);
        b00A.B(j);
        b00A.g(true);
        b00A.r(String.valueOf(i));
        b00A.v(pendingIntentV0);
        p1(b00A, "", i);
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof d) {
            q1(((d) obj).a());
            return;
        }
        if (obj instanceof e) {
            r1(((e) obj).a());
            return;
        }
        if (obj instanceof c) {
            if (C8386Vt0.c7()) {
                s1((c) obj);
            }
        } else if (obj instanceof b) {
            E00.e(E00.a, null, 1, null);
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        this.r = C15958kT2.e.a(new B86(AbstractC13215fr.b.b()));
        this.p = ((TC4) C92.a(C5721Ko.a.d(), TC4.class)).l0();
        this.q = new CE4(J0(), this.m, F0());
        o0();
    }

    private final void g1(Map map) {
    }
}
