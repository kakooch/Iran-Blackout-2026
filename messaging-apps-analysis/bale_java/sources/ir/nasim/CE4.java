package ir.nasim;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.core.graphics.drawable.IconCompat;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.B00;
import ir.nasim.D55;
import ir.nasim.VP4;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.pinMessages.PinMessageEntity;
import ir.nasim.features.MainActivity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class CE4 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final NotificationManager a;
    private final C9057Yh4 b;
    private final InterfaceC14123hO3 c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[VP4.a.values().length];
            try {
                iArr[VP4.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VP4.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference c;
        final /* synthetic */ CE4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(FileReference fileReference, CE4 ce4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = fileReference;
            this.d = ce4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objC;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                FileReference fileReference = this.c;
                C14970in2 c14970in2D = this.d.b.D();
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class d implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((AbstractC16407lD4.i.d) obj).i()), Long.valueOf(((AbstractC16407lD4.i.d) obj2).i()));
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C14733iO2 c;
        final /* synthetic */ CE4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C14733iO2 c14733iO2, CE4 ce4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c14733iO2;
            this.d = ce4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, interfaceC20295rm1);
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
                Avatar avatar = (Avatar) this.c.j().b();
                if (avatar == null || (imageDefaultSize = avatar.getImageDefaultSize()) == null || (fileReference = imageDefaultSize.getFileReference()) == null) {
                    return null;
                }
                C14970in2 c14970in2D = this.d.b.D();
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C21231tK7 c;
        final /* synthetic */ CE4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C21231tK7 c21231tK7, CE4 ce4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c21231tK7;
            this.d = ce4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, interfaceC20295rm1);
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
                C14970in2 c14970in2D = this.d.b.D();
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public CE4(NotificationManager notificationManager, C9057Yh4 c9057Yh4, InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(notificationManager, "manager");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(interfaceC14123hO3, "apiMessageMapper");
        this.a = notificationManager;
        this.b = c9057Yh4;
        this.c = interfaceC14123hO3;
    }

    private final String B(C11458d25 c11458d25, String str, long j) {
        if (AbstractC5969Lp4.d().B0() && str != null && str.length() > 0) {
            return c11458d25.z() ? H(c11458d25.getPeerId(), str, j) : str;
        }
        String string = C5721Ko.a.d().getString(AbstractC12217eE5.notification_privacy_title);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final String D(AbstractC5961Lo5 abstractC5961Lo5) {
        C10410bZ6 c10410bZ6R;
        String str;
        C10410bZ6 c10410bZ6V;
        String str2;
        if (T(abstractC5961Lo5)) {
            String string = C5721Ko.a.d().getString(AbstractC12217eE5.reply_to_comment, abstractC5961Lo5.m());
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        String strM = abstractC5961Lo5.m();
        if (strM.length() > 0) {
            return strM;
        }
        if (abstractC5961Lo5.h().z()) {
            C14733iO2 c14733iO2T = t(abstractC5961Lo5.h().getPeerId());
            if (c14733iO2T != null && (c10410bZ6V = c14733iO2T.v()) != null && (str2 = (String) c10410bZ6V.b()) != null) {
                return str2;
            }
            String string2 = C5721Ko.a.d().getString(AbstractC12217eE5.all_default_group_title);
            AbstractC13042fc3.h(string2, "getString(...)");
            return string2;
        }
        C21231tK7 c21231tK7L = L(abstractC5961Lo5.h());
        if (c21231tK7L != null && (c10410bZ6R = c21231tK7L.r()) != null && (str = (String) c10410bZ6R.b()) != null) {
            return str;
        }
        String string3 = C5721Ko.a.d().getString(AbstractC12217eE5.all_default_user_title);
        AbstractC13042fc3.h(string3, "getString(...)");
        return string3;
    }

    private final D55 E(AbstractC5961Lo5 abstractC5961Lo5, AbstractC16407lD4.i iVar, boolean z) {
        long jI = abstractC5961Lo5.i();
        Iterator it = iVar.p().iterator();
        while (it.hasNext()) {
            D55 d55G = ((AbstractC16407lD4.i.d) it.next()).g();
            if (AbstractC13042fc3.d(String.valueOf(jI), d55G != null ? d55G.e() : null)) {
                return d55G;
            }
        }
        D55 d55A = new D55.c().e(String.valueOf(jI)).f(J(jI, z)).c(IconCompat.i(I(jI, z))).a();
        AbstractC13042fc3.h(d55A, "build(...)");
        return d55A;
    }

    private final String F(String str, String str2, int i, boolean z) {
        if (z) {
            String string = C5721Ko.a.d().getString(AbstractC12217eE5.notif_group_reaction, XY6.v(String.valueOf(i)), h(str));
            AbstractC13042fc3.f(string);
            return string;
        }
        String string2 = C5721Ko.a.d().getString(AbstractC12217eE5.notif_private_reaction, str2, h(str));
        AbstractC13042fc3.f(string2);
        return string2;
    }

    private final String G(String str) {
        String string = C5721Ko.a.d().getString(AbstractC12217eE5.notif_reply, h(str));
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final String H(int i, String str, long j) {
        C14733iO2 c14733iO2T;
        if (Build.VERSION.SDK_INT >= 29 || (c14733iO2T = t(i)) == null || c14733iO2T.q() != ZN2.GROUP) {
            return str;
        }
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(j);
        if (c21231tK7 != null) {
            return ((String) c21231tK7.r().b()) + ": " + str;
        }
        String string = C5721Ko.a.d().getString(AbstractC12217eE5.all_default_user_title);
        AbstractC13042fc3.h(string, "getString(...)");
        return string + ": " + str;
    }

    private final Bitmap I(long j, boolean z) {
        C9475a16 c9475a16;
        C9475a16 c9475a162;
        String strJ = J(j, z);
        if (z) {
            C14733iO2 c14733iO2U = u(j);
            if (c14733iO2U != null && (c9475a162 = (C9475a16) AbstractC9913am0.b(null, new e(c14733iO2U, this, null), 1, null)) != null) {
                Object objL = c9475a162.l();
                if (C9475a16.j(objL)) {
                    return C16670lg0.d(c14733iO2U.r(), strJ, (String) objL);
                }
                C9475a16.a(objL);
            }
        } else {
            C21231tK7 c21231tK7K = K(j);
            if (c21231tK7K != null && (c9475a16 = (C9475a16) AbstractC9913am0.b(null, new f(c21231tK7K, this, null), 1, null)) != null) {
                Object objL2 = c9475a16.l();
                if (C9475a16.j(objL2)) {
                    return C16670lg0.d(c21231tK7K.o(), strJ, (String) objL2);
                }
                C9475a16.a(objL2);
            }
        }
        return C16670lg0.f(strJ, (int) j);
    }

    private final String J(long j, boolean z) {
        String string;
        if (V(j)) {
            String string2 = C5721Ko.a.d().getString(AbstractC12217eE5.f71me);
            AbstractC13042fc3.f(string2);
            return string2;
        }
        if (z) {
            C14733iO2 c14733iO2U = u(j);
            string = c14733iO2U != null ? (String) c14733iO2U.v().b() : C5721Ko.a.d().getString(AbstractC12217eE5.all_default_user_title);
        } else {
            C21231tK7 c21231tK7K = K(j);
            string = c21231tK7K != null ? (String) c21231tK7K.r().b() : C5721Ko.a.d().getString(AbstractC12217eE5.all_default_user_title);
        }
        AbstractC13042fc3.f(string);
        return string;
    }

    private final C21231tK7 K(long j) {
        return (C21231tK7) this.b.W().o0().n(j);
    }

    private final C21231tK7 L(C11458d25 c11458d25) {
        return (C21231tK7) AbstractC5969Lp4.g().n(c11458d25.getPeerId());
    }

    private final boolean M(NotificationManager notificationManager, VP4.a aVar) {
        String str;
        String str2;
        int i;
        int i2 = b.a[aVar.ordinal()];
        boolean z = false;
        if (i2 == 1) {
            str = "group_sapta";
            str2 = "SUMMARY_SAPTA_NOTIFICATION_TAG";
            i = 1;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = "group_message";
            str2 = "summaryTag";
            i = 0;
        }
        StatusBarNotification[] statusBarNotificationArrB = GE4.b(notificationManager);
        ArrayList<StatusBarNotification> arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
            String groupKey = statusBarNotification.getGroupKey();
            AbstractC13042fc3.h(groupKey, "getGroupKey(...)");
            if (AbstractC20762sZ6.X(groupKey, str, false, 2, null)) {
                arrayList.add(statusBarNotification);
            }
        }
        if (arrayList.size() == 1) {
            for (StatusBarNotification statusBarNotification2 : arrayList) {
                notificationManager.cancel(statusBarNotification2.getTag(), statusBarNotification2.getId());
            }
            return true;
        }
        if (arrayList.size() == 2) {
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((StatusBarNotification) it.next()).getId() == i) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                notificationManager.cancel(str2, i);
            }
        }
        return z;
    }

    private final void O(final AbstractC5961Lo5 abstractC5961Lo5, final Context context) {
        if (abstractC5961Lo5.f() == 0) {
            C19406qI3.j("NotificationUIManager", "handleSaptaNotification, messageDate empty, so return", new Object[0]);
        } else if (abstractC5961Lo5.g().length() != 0) {
            this.b.G().w0(abstractC5961Lo5.h(), abstractC5961Lo5.f(), Long.parseLong(abstractC5961Lo5.g())).m0(new InterfaceC24449ye1() { // from class: ir.nasim.AE4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    CE4.P(this.a, abstractC5961Lo5, context, (J44) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.BE4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    CE4.Q(abstractC5961Lo5, this, context, (Exception) obj);
                }
            });
        } else {
            C19406qI3.j("NotificationUIManager", "handleSaptaNotification, messageRid empty, so show regular message push", new Object[0]);
            e0(abstractC5961Lo5, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(CE4 ce4, AbstractC5961Lo5 abstractC5961Lo5, Context context, J44 j44) {
        AbstractC13042fc3.i(ce4, "this$0");
        AbstractC13042fc3.i(abstractC5961Lo5, "$messagePushNotification");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.f(j44);
        ce4.g0(abstractC5961Lo5, context, j44);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(AbstractC5961Lo5 abstractC5961Lo5, CE4 ce4, Context context, Exception exc) {
        AbstractC13042fc3.i(abstractC5961Lo5, "$messagePushNotification");
        AbstractC13042fc3.i(ce4, "this$0");
        AbstractC13042fc3.i(context, "$context");
        C19406qI3.j("NotificationUIManager", "handleSaptaNotification, findMessage failed, so show regular message push\nmessage date : " + abstractC5961Lo5.f() + "\n message rid : " + abstractC5961Lo5.g(), new Object[0]);
        ce4.e0(abstractC5961Lo5, context);
    }

    public static /* synthetic */ void S(CE4 ce4, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        ce4.R(i, str);
    }

    private final boolean T(AbstractC5961Lo5 abstractC5961Lo5) {
        if (abstractC5961Lo5 instanceof C14566i74) {
            C14566i74 c14566i74 = (C14566i74) abstractC5961Lo5;
            if (c14566i74.n() != null && c14566i74.c() == EnumC13889gz5.j) {
                return true;
            }
        }
        return false;
    }

    private final boolean U(AbstractC5961Lo5 abstractC5961Lo5) {
        if (T(abstractC5961Lo5)) {
            return true;
        }
        if (!SA6.a.c() || abstractC5961Lo5.h().s() != W25.b) {
            return false;
        }
        C14733iO2 c14733iO2U = u(abstractC5961Lo5.h().getPeerId());
        return (c14733iO2U != null ? c14733iO2U.q() : null) == ZN2.GROUP;
    }

    private final boolean V(long j) {
        return j == ((long) this.b.w().p());
    }

    public static /* synthetic */ void X(CE4 ce4, C11458d25 c11458d25, long[] jArr, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        ce4.W(c11458d25, jArr, l);
    }

    private final AbstractC16407lD4.i Y(C11458d25 c11458d25, final long[] jArr, Long l) {
        AbstractC16407lD4.i iVarO;
        int iLongValue = l != null ? (int) l.longValue() : c11458d25.getPeerId();
        StatusBarNotification[] statusBarNotificationArrB = GE4.b(this.a);
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
            if (statusBarNotification.getId() == iLongValue) {
                arrayList.add(statusBarNotification);
            }
        }
        if (arrayList.isEmpty() || (iVarO = AbstractC16407lD4.i.o(((StatusBarNotification) arrayList.get(0)).getNotification())) == null) {
            return null;
        }
        List listP = iVarO.p();
        AbstractC13042fc3.h(listP, "getMessages(...)");
        AbstractC13610gX0.K(listP, new UA2() { // from class: ir.nasim.zE4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CE4.Z(jArr, (AbstractC16407lD4.i.d) obj));
            }
        });
        return iVarO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z(long[] jArr, AbstractC16407lD4.i.d dVar) {
        AbstractC13042fc3.i(jArr, "$datesForDelete");
        return AbstractC10242bK.T(jArr, dVar.d().getLong("messageDate"));
    }

    private final boolean a0(String str) {
        return (AbstractC13042fc3.d(str, "REACTION") || AbstractC13042fc3.d(str, "MENTION") || AbstractC13042fc3.d(str, "REPLY")) ? false : true;
    }

    private final boolean b0(String str) {
        boolean zA0 = a0(str);
        if (zA0) {
            return AbstractC5969Lp4.d().o0(this.b.v().E().h().b() == EnumC19739qr4.MOBILE);
        }
        return zA0;
    }

    private final boolean c0() {
        return true;
    }

    private final void d0(String str, int i, long j) {
        if (!AbstractC13042fc3.d(str, "SUMMARY_SAPTA_NOTIFICATION_TAG")) {
            B00.a aVar = B00.b;
            C5721Ko c5721Ko = C5721Ko.a;
            B00 b00A = aVar.a(c5721Ko.d());
            b00A.z(new AbstractC16407lD4.h());
            b00A.t(true);
            b00A.r("group_message");
            b00A.h("msg");
            b00A.s(2);
            b00A.v(j(c5721Ko.d()));
            b00A.B(j);
            b00A.y(KB5.ic_stat_white_notif_icon);
            b00A.g(true);
            this.a.notify(str, i, b00A.e());
            return;
        }
        C5721Ko c5721Ko2 = C5721Ko.a;
        String string = c5721Ko2.d().getString(AbstractC12217eE5.pfm_tab);
        AbstractC13042fc3.h(string, "getString(...)");
        B00 b00A2 = B00.b.a(c5721Ko2.d());
        b00A2.k(string);
        b00A2.j(string);
        b00A2.v(j(c5721Ko2.d()));
        b00A2.B(j);
        AbstractC16407lD4.h hVarO = new AbstractC16407lD4.h().n(string).o(string);
        AbstractC13042fc3.h(hVarO, "setSummaryText(...)");
        b00A2.z(hVarO);
        b00A2.y(KB5.ic_stat_white_notif_icon);
        b00A2.g(true);
        b00A2.r("group_sapta");
        b00A2.t(true);
        this.a.notify(str, i, b00A2.e());
    }

    private final boolean e(AbstractC5961Lo5 abstractC5961Lo5) {
        if (abstractC5961Lo5.c() == EnumC13889gz5.f || abstractC5961Lo5.c() == EnumC13889gz5.g) {
            return true;
        }
        Long l = (Long) AbstractC5969Lp4.d().P(abstractC5961Lo5.h()).h().b();
        return l == null || abstractC5961Lo5.f() > l.longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void e0(ir.nasim.AbstractC5961Lo5 r25, android.content.Context r26) {
        /*
            Method dump skipped, instructions count: 803
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CE4.e0(ir.nasim.Lo5, android.content.Context):void");
    }

    private final boolean f(String str) {
        return !AbstractC13042fc3.d(str, "STORY");
    }

    private final void f0(Context context, AbstractC5961Lo5 abstractC5961Lo5, PendingIntent pendingIntent, C8455Wa6 c8455Wa6) {
        B00 b00A = B00.b.a(context);
        VP4 vp4 = VP4.a;
        b00A.n(vp4.b(context, c8455Wa6));
        b00A.o(vp4.d(context, c8455Wa6));
        b00A.m(vp4.c(context, abstractC5961Lo5.h().getPeerId(), c8455Wa6));
        b00A.k(vp4.k());
        b00A.j(vp4.h(c8455Wa6));
        b00A.z(new AbstractC16407lD4.g());
        b00A.y(KB5.ic_stat_white_notif_icon);
        b00A.B(abstractC5961Lo5.f());
        b00A.g(true);
        b00A.r("group_sapta");
        b00A.v(pendingIntent);
        b00A.p(String.valueOf(abstractC5961Lo5.h().u()));
        if (AbstractC9599aE4.a.u()) {
            i0(context);
        }
        this.a.notify(String.valueOf(abstractC5961Lo5.f()), 270066638, b00A.e());
        if (c0()) {
            d0("SUMMARY_SAPTA_NOTIFICATION_TAG", 1, abstractC5961Lo5.f());
        }
    }

    private final boolean g(C11458d25 c11458d25, EnumC13889gz5 enumC13889gz5) {
        C14733iO2 c14733iO2U;
        boolean z = false;
        if (enumC13889gz5 == EnumC13889gz5.j) {
            return false;
        }
        boolean z2 = !AbstractC13042fc3.d(enumC13889gz5.name(), "STORY");
        if (c11458d25.s() != W25.b || (c14733iO2U = u(c11458d25.getPeerId())) == null) {
            return z2;
        }
        if (z2 && c14733iO2U.q() == ZN2.GROUP) {
            z = true;
        }
        return z;
    }

    private final void g0(AbstractC5961Lo5 abstractC5961Lo5, Context context, J44 j44) {
        PendingIntent pendingIntentK = k(abstractC5961Lo5.a(), context);
        C8455Wa6 c8455Wa6A = C8455Wa6.h.a(j44);
        if (c8455Wa6A != null) {
            f0(context, abstractC5961Lo5, pendingIntentK, c8455Wa6A);
        } else {
            e0(abstractC5961Lo5, context);
        }
    }

    private final String h(String str) {
        String strK = new C20644sM5("[\\t\\n\\r]+").k(AbstractC5730Kp.f(str, null, null, null).toString(), Separators.SP);
        if (strK.length() <= 20) {
            return strK;
        }
        return ((Object) strK.subSequence(0, 19)) + "...";
    }

    private final AbstractC16407lD4.i i(AbstractC5961Lo5 abstractC5961Lo5) {
        String strK = abstractC5961Lo5.k();
        FileReference fileReferenceZ = z(abstractC5961Lo5.h());
        String strD = D(abstractC5961Lo5);
        if (strK != null && AbstractC13042fc3.d(strK, "LIKE")) {
            D55 d55A = new D55.c().c(IconCompat.l(C5721Ko.a.d(), KB5.ic_story_like_notification)).f(strD).a();
            AbstractC13042fc3.h(d55A, "build(...)");
            AbstractC16407lD4.i iVarS = new AbstractC16407lD4.i(d55A).s(strD);
            AbstractC13042fc3.h(iVarS, "setConversationTitle(...)");
            return iVarS;
        }
        if ((fileReferenceZ != null ? Long.valueOf(fileReferenceZ.getFileId()) : null) != null) {
            Object objL = ((C9475a16) AbstractC9913am0.b(null, new c(fileReferenceZ, this, null), 1, null)).l();
            if (C9475a16.j(objL)) {
                D55 d55A2 = new D55.c().c(IconCompat.i(C16670lg0.h(C16670lg0.d(abstractC5961Lo5.h().getPeerId(), strD, (String) objL)))).f(strD).a();
                AbstractC13042fc3.h(d55A2, "build(...)");
                return new AbstractC16407lD4.i(d55A2);
            }
        }
        D55 d55A3 = new D55.c().c(IconCompat.i(C16670lg0.h(C16670lg0.f(strD, abstractC5961Lo5.h().getPeerId())))).f(strD).a();
        AbstractC13042fc3.h(d55A3, "build(...)");
        return new AbstractC16407lD4.i(d55A3);
    }

    private final void i0(Context context) {
        if (AbstractC9599aE4.a.u()) {
            new C11976ds().b(context);
        }
    }

    private final PendingIntent j(Context context) {
        Intent intent = new Intent(C5721Ko.a.d(), (Class<?>) MainActivity.class);
        intent.addFlags(67108864);
        intent.setAction("OPEN_APP");
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 33554432);
        AbstractC13042fc3.h(activity, "getActivity(...)");
        return activity;
    }

    private final PendingIntent k(Intent intent, Context context) {
        int time = (int) new Date().getTime();
        intent.setAction("ir.nasim.intent.NOTIFICATION" + time);
        PendingIntent activity = PendingIntent.getActivity(context, time, intent, 33554432);
        AbstractC13042fc3.h(activity, "getActivity(...)");
        return activity;
    }

    private final PendingIntent l(Context context, String str, boolean z) {
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

    private final PendingIntent m(AbstractC5961Lo5 abstractC5961Lo5, Intent intent, Context context) {
        if (AbstractC13042fc3.d("STORY", abstractC5961Lo5.c().name())) {
            String stringExtra = intent.getStringExtra("storyId");
            if (stringExtra == null) {
                stringExtra = "";
            }
            return l(context, stringExtra, AbstractC13042fc3.d(intent.getStringExtra("action"), "LIKE"));
        }
        StatusBarNotification[] statusBarNotificationArrB = GE4.b(this.a);
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
            if (AbstractC13042fc3.d(bundle.getString(PinMessageEntity.COLS_PEER_UNIQUE_ID), String.valueOf(abstractC5961Lo5.h().u())) && AbstractC13042fc3.d(bundle.getString("pushType"), "REACTION")) {
                PendingIntent pendingIntent = statusBarNotification2.getNotification().contentIntent;
                AbstractC13042fc3.h(pendingIntent, "contentIntent");
                return pendingIntent;
            }
        }
        return k(intent, context);
    }

    private final void n(String str, AbstractC5961Lo5 abstractC5961Lo5, D55 d55, B00 b00, AbstractC16407lD4.i iVar, String str2, Uri uri, String str3) {
        int peerId;
        CharSequence charSequenceH;
        AbstractC16407lD4.i.d dVar = new AbstractC16407lD4.i.d(str, abstractC5961Lo5.j(), d55);
        dVar.j(str3, uri);
        long jF = abstractC5961Lo5.f();
        dVar.d().putLong("messageDate", jF);
        dVar.d().putString("pushType", abstractC5961Lo5.c().name());
        dVar.d().putString("MessageRID", abstractC5961Lo5.g());
        iVar.n(dVar);
        if (dVar.c() != null && (charSequenceH = dVar.h()) != null && (!AbstractC20762sZ6.n0(charSequenceH))) {
            AbstractC16407lD4.i.d dVar2 = new AbstractC16407lD4.i.d(dVar.h(), dVar.i(), dVar.g());
            dVar2.d().putLong("messageDate", jF);
            dVar2.d().putString("pushType", abstractC5961Lo5.c().name());
            iVar.n(dVar2);
        }
        try {
            List listP = iVar.p();
            AbstractC13042fc3.h(listP, "getMessages(...)");
            if (listP.size() > 1) {
                AbstractC12992fX0.B(listP, new d());
            }
        } catch (Exception e2) {
            C19406qI3.c("NotificationUIManager", "Error in sorting push messages, peerId: " + abstractC5961Lo5.h().getPeerId(), e2);
        }
        b00.z(iVar);
        if (AbstractC9599aE4.a.u()) {
            i0(C5721Ko.a.d());
        }
        C19406qI3.a("NotificationUIManager", "notify notification, peerId: " + abstractC5961Lo5.h().getPeerId(), new Object[0]);
        if (T(abstractC5961Lo5)) {
            AbstractC13042fc3.g(abstractC5961Lo5, "null cannot be cast to non-null type ir.nasim.features.firebase.newPush.model.MessagePushNotification");
            C22033uZ0 c22033uZ0N = ((C14566i74) abstractC5961Lo5).n();
            peerId = (int) (c22033uZ0N != null ? c22033uZ0N.c() : 0L);
        } else {
            peerId = abstractC5961Lo5.h().getPeerId();
        }
        this.a.notify(peerId, b00.e());
        if (str2.length() > 0) {
            SA6.a.b(AbstractC9766aX0.e(str2));
        }
        if (c0()) {
            d0("summaryTag", 0, abstractC5961Lo5.f());
        }
    }

    private final AbstractC16407lD4.i p(AbstractC5961Lo5 abstractC5961Lo5) {
        XV4 xv4A;
        if (T(abstractC5961Lo5)) {
            AbstractC13042fc3.g(abstractC5961Lo5, "null cannot be cast to non-null type ir.nasim.features.firebase.newPush.model.MessagePushNotification");
            C22033uZ0 c22033uZ0N = ((C14566i74) abstractC5961Lo5).n();
            xv4A = AbstractC4616Fw7.a("threadMessageRID", String.valueOf(c22033uZ0N != null ? c22033uZ0N.c() : 0L));
        } else {
            xv4A = AbstractC4616Fw7.a(PinMessageEntity.COLS_PEER_UNIQUE_ID, String.valueOf(abstractC5961Lo5.h().u()));
        }
        String str = (String) xv4A.a();
        String str2 = (String) xv4A.b();
        StatusBarNotification[] statusBarNotificationArrB = GE4.b(this.a);
        ArrayList<StatusBarNotification> arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
            String groupKey = statusBarNotification.getGroupKey();
            AbstractC13042fc3.h(groupKey, "getGroupKey(...)");
            if (AbstractC20762sZ6.X(groupKey, "group_message", false, 2, null)) {
                arrayList.add(statusBarNotification);
            }
        }
        for (StatusBarNotification statusBarNotification2 : arrayList) {
            if (AbstractC13042fc3.d(statusBarNotification2.getNotification().extras.getString(str), str2)) {
                return AbstractC16407lD4.i.o(statusBarNotification2.getNotification());
            }
        }
        return null;
    }

    private final Notification q(int i) {
        Notification notification = null;
        for (StatusBarNotification statusBarNotification : GE4.b(this.a)) {
            if (statusBarNotification.getId() == i) {
                notification = statusBarNotification.getNotification();
            }
        }
        return notification;
    }

    private final ZN2 s(C11458d25 c11458d25) {
        C14733iO2 c14733iO2 = (C14733iO2) this.b.E().Y1().n(c11458d25.getPeerId());
        if (c14733iO2 != null) {
            return c14733iO2.q();
        }
        return null;
    }

    private final C14733iO2 t(int i) {
        return (C14733iO2) AbstractC5969Lp4.b().n(i);
    }

    private final C14733iO2 u(long j) {
        return (C14733iO2) this.b.E().Y1().n(j);
    }

    private final String v(String str) {
        if (AbstractC20762sZ6.X(str, "@all", false, 2, null)) {
            String string = C5721Ko.a.d().getString(AbstractC12217eE5.notif_mention_all, h(str));
            AbstractC13042fc3.f(string);
            return string;
        }
        String string2 = C5721Ko.a.d().getString(AbstractC12217eE5.notif_mention, h(str));
        AbstractC13042fc3.f(string2);
        return string2;
    }

    public static /* synthetic */ AbstractC16407lD4.i x(CE4 ce4, C11458d25 c11458d25, long j, String str, C22033uZ0 c22033uZ0, int i, Object obj) {
        if ((i & 8) != 0) {
            c22033uZ0 = null;
        }
        return ce4.w(c11458d25, j, str, c22033uZ0);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.core.modules.file.entity.FileReference z(ir.nasim.C11458d25 r3) {
        /*
            r2 = this;
            boolean r0 = r3.z()
            r1 = 0
            if (r0 == 0) goto L20
            int r3 = r3.getPeerId()
            ir.nasim.iO2 r3 = r2.t(r3)
            if (r3 == 0) goto L1e
            ir.nasim.qQ7 r3 = r3.j()
            if (r3 == 0) goto L1e
            java.lang.Object r3 = r3.b()
            ir.nasim.core.modules.profile.entity.Avatar r3 = (ir.nasim.core.modules.profile.entity.Avatar) r3
            goto L32
        L1e:
            r3 = r1
            goto L32
        L20:
            ir.nasim.tK7 r3 = r2.L(r3)
            if (r3 == 0) goto L1e
            ir.nasim.qQ7 r3 = r3.h()
            if (r3 == 0) goto L1e
            java.lang.Object r3 = r3.b()
            ir.nasim.core.modules.profile.entity.Avatar r3 = (ir.nasim.core.modules.profile.entity.Avatar) r3
        L32:
            if (r3 == 0) goto L3e
            ir.nasim.core.modules.profile.entity.AvatarImage r3 = r3.getImageDefaultSize()
            if (r3 == 0) goto L3e
            ir.nasim.core.modules.file.entity.FileReference r1 = r3.getFileReference()
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CE4.z(ir.nasim.d25):ir.nasim.core.modules.file.entity.FileReference");
    }

    public final AbstractC16407lD4.i A(C11458d25 c11458d25, long j, String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, "editText");
        Object obj = null;
        if (j != 0) {
            StatusBarNotification[] statusBarNotificationArrB = GE4.b(this.a);
            ArrayList arrayList = new ArrayList();
            for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
                if (statusBarNotification.getId() == c11458d25.getPeerId()) {
                    arrayList.add(statusBarNotification);
                }
            }
            AbstractC16407lD4.i iVarO = AbstractC16407lD4.i.o(((StatusBarNotification) arrayList.get(0)).getNotification());
            if (iVarO != null) {
                List listP = iVarO.p();
                AbstractC13042fc3.h(listP, "getMessages(...)");
                Iterator it = listP.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String string = ((AbstractC16407lD4.i.d) next).d().getString("MessageRID");
                    Long lQ = string != null ? AbstractC19562qZ6.q(string) : null;
                    if (lQ != null && lQ.longValue() != 0 && lQ.longValue() == j) {
                        obj = next;
                        break;
                    }
                }
                AbstractC16407lD4.i.d dVar = (AbstractC16407lD4.i.d) obj;
                if (dVar != null) {
                    AbstractC16407lD4.i.d dVar2 = new AbstractC16407lD4.i.d(str, dVar.i(), dVar.g());
                    dVar2.d().putAll(dVar.d());
                    iVarO.p().set(iVarO.p().indexOf(dVar), dVar2);
                }
                return iVarO;
            }
        }
        return null;
    }

    public final List C(C11458d25 c11458d25, long j) {
        AbstractC13042fc3.i(c11458d25, "peer");
        if (j == 0) {
            return AbstractC10360bX0.m();
        }
        StatusBarNotification[] statusBarNotificationArrB = GE4.b(this.a);
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
            if (statusBarNotification.getId() == c11458d25.getPeerId()) {
                arrayList.add(statusBarNotification);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AbstractC16407lD4.i iVarO = AbstractC16407lD4.i.o(((StatusBarNotification) it.next()).getNotification());
            if (iVarO != null) {
                arrayList2.add(iVarO);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            List listP = ((AbstractC16407lD4.i) it2.next()).p();
            AbstractC13042fc3.h(listP, "getMessages(...)");
            AbstractC13610gX0.D(arrayList3, listP);
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            String string = ((AbstractC16407lD4.i.d) obj).d().getString("MessageRID");
            Long lQ = string != null ? AbstractC19562qZ6.q(string) : null;
            if (lQ != null && lQ.longValue() != 0 && lQ.longValue() == j) {
                arrayList4.add(obj);
            }
        }
        return arrayList4;
    }

    public final void N(AbstractC5961Lo5 abstractC5961Lo5) {
        C22033uZ0 c22033uZ0N;
        AbstractC13042fc3.i(abstractC5961Lo5, "presentablePushNotification");
        Long lValueOf = null;
        C14566i74 c14566i74 = abstractC5961Lo5 instanceof C14566i74 ? (C14566i74) abstractC5961Lo5 : null;
        if (c14566i74 != null && (c22033uZ0N = c14566i74.n()) != null) {
            lValueOf = Long.valueOf(c22033uZ0N.c());
        }
        if (!AbstractC9599aE4.a.q(abstractC5961Lo5.h().getPeerId(), lValueOf)) {
            if (abstractC5961Lo5.h().getPeerId() == 270066638) {
                O(abstractC5961Lo5, C5721Ko.a.d());
            } else {
                e0(abstractC5961Lo5, C5721Ko.a.d());
            }
            C19406qI3.a("PushHandler", "handleMessagePush end", new Object[0]);
            return;
        }
        C19406qI3.j("PushHandler", "handleMessagePush: current peer is opened, so return and don't display push. peerUserId: " + abstractC5961Lo5.h().getPeerId(), new Object[0]);
    }

    public final void R(int i, String str) {
        C19406qI3.a("NotificationUIManager", "hideNotification", new Object[0]);
        if (i == 270066638) {
            GE4.f(this.a, str);
        } else if (!GE4.g(this.a, i)) {
            C19406qI3.a("NotificationUIManager", "hideNotification, isPushExist is false so return!", new Object[0]);
        } else {
            if (M(this.a, VP4.a.b)) {
                return;
            }
            this.a.cancel(i);
        }
    }

    public final void W(C11458d25 c11458d25, long[] jArr, Long l) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(jArr, "messageDates");
        AbstractC16407lD4.i iVarY = Y(c11458d25, jArr, l);
        int iLongValue = l != null ? (int) l.longValue() : c11458d25.getPeerId();
        if (iVarY == null || iVarY.p().isEmpty()) {
            GE4.e(this.a, iLongValue, null, 2, null);
        } else {
            h0(iVarY, iLongValue);
        }
    }

    public final void h0(AbstractC16407lD4.i iVar, int i) {
        String strF;
        AbstractC13042fc3.i(iVar, "messagingStyle");
        Notification notificationQ = q(i);
        B00.a aVar = B00.b;
        C5721Ko c5721Ko = C5721Ko.a;
        B00 b00A = aVar.a(c5721Ko.d());
        b00A.f(notificationQ);
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
        this.a.notify(i, b00A.e());
        if (strF.length() > 0) {
            sa6.b(AbstractC9766aX0.e(strF));
        }
    }

    public final ExPeerType o(C11458d25 c11458d25) {
        C14733iO2 c14733iO2;
        if (c11458d25 == null) {
            return null;
        }
        if (c11458d25.C()) {
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c11458d25.getPeerId());
            if (c21231tK7 != null) {
                return c21231tK7.n();
            }
            return null;
        }
        if (!c11458d25.z() || (c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c11458d25.getPeerId())) == null) {
            return null;
        }
        return c14733iO2.p();
    }

    public final StatusBarNotification[] r() {
        try {
            return this.a.getActiveNotifications();
        } catch (Exception unused) {
            return new StatusBarNotification[0];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.AbstractC16407lD4.i w(ir.nasim.C11458d25 r11, long r12, java.lang.String r14, ir.nasim.C22033uZ0 r15) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CE4.w(ir.nasim.d25, long, java.lang.String, ir.nasim.uZ0):ir.nasim.lD4$i");
    }

    public final String y(C11458d25 c11458d25, GH5 gh5) {
        String strL;
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(gh5, "pushNotification");
        ED4 ed4 = new ED4(false, false, b0(gh5.c().name()), false, false);
        AbstractC24063xz abstractC24063xzE = gh5.e();
        DD4 dd4A = abstractC24063xzE != null ? ((CD4) this.c.a(abstractC24063xzE)).a(C5721Ko.a.d(), this.b, -1L, ZN2.GROUP, ed4.c(), gh5.l()) : null;
        if (dd4A == null || (strL = dd4A.c()) == null) {
            strL = gh5.l();
        }
        gh5.y(strL);
        return F(B(c11458d25, gh5.l(), Long.parseLong(gh5.p())), null, gh5.v(), true);
    }
}
