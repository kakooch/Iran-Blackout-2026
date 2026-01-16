package ir.nasim;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import ir.nasim.AbstractC16407lD4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.qD4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C19362qD4 implements InterfaceC10184bD4 {
    private final Context a;
    private final Notification.Builder b;
    private final AbstractC16407lD4.e c;
    private RemoteViews d;
    private RemoteViews e;
    private final List f = new ArrayList();
    private final Bundle g = new Bundle();
    private int h;
    private RemoteViews i;

    /* renamed from: ir.nasim.qD4$a */
    static class a {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder e(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i, charSequence, pendingIntent);
        }

        static String f(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z) {
            return builder.setGroupSummary(z);
        }

        static Notification.Builder i(Notification.Builder builder, boolean z) {
            return builder.setLocalOnly(z);
        }

        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* renamed from: ir.nasim.qD4$b */
    static class b {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i) {
            return builder.setColor(i);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i) {
            return builder.setVisibility(i);
        }
    }

    /* renamed from: ir.nasim.qD4$c */
    static class c {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* renamed from: ir.nasim.qD4$d */
    static class d {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
            return builder.setAllowGeneratedReplies(z);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    /* renamed from: ir.nasim.qD4$e */
    static class e {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i) {
            return builder.setBadgeIconType(i);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z) {
            return builder.setColorized(z);
        }

        static Notification.Builder d(Notification.Builder builder, int i) {
            return builder.setGroupAlertBehavior(i);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j) {
            return builder.setTimeoutAfter(j);
        }
    }

    /* renamed from: ir.nasim.qD4$f */
    static class f {
        static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, int i) {
            return builder.setSemanticAction(i);
        }
    }

    /* renamed from: ir.nasim.qD4$g */
    static class g {
        static Notification.Builder a(Notification.Builder builder, boolean z) {
            return builder.setAllowSystemGeneratedContextualActions(z);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z) {
            return builder.setContextual(z);
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    /* renamed from: ir.nasim.qD4$h */
    static class h {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
            return builder.setAuthenticationRequired(z);
        }

        static Notification.Builder b(Notification.Builder builder, int i) {
            return builder.setForegroundServiceBehavior(i);
        }
    }

    C19362qD4(AbstractC16407lD4.e eVar) {
        int i;
        this.c = eVar;
        Context context = eVar.a;
        this.a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.b = e.a(context, eVar.K);
        } else {
            this.b = new Notification.Builder(eVar.a);
        }
        Notification notification = eVar.S;
        this.b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.e).setContentText(eVar.f).setContentInfo(eVar.k).setContentIntent(eVar.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.h, (notification.flags & 128) != 0).setNumber(eVar.l).setProgress(eVar.t, eVar.u, eVar.v);
        Notification.Builder builder = this.b;
        IconCompat iconCompat = eVar.j;
        c.b(builder, iconCompat == null ? null : iconCompat.x(context));
        this.b.setSubText(eVar.q).setUsesChronometer(eVar.o).setPriority(eVar.m);
        AbstractC16407lD4.j jVar = eVar.p;
        if (jVar instanceof AbstractC16407lD4.f) {
            Iterator it = ((AbstractC16407lD4.f) jVar).o().iterator();
            while (it.hasNext()) {
                b((AbstractC16407lD4.a) it.next());
            }
        } else {
            Iterator it2 = eVar.b.iterator();
            while (it2.hasNext()) {
                b((AbstractC16407lD4.a) it2.next());
            }
        }
        Bundle bundle = eVar.D;
        if (bundle != null) {
            this.g.putAll(bundle);
        }
        int i2 = Build.VERSION.SDK_INT;
        this.d = eVar.H;
        this.e = eVar.I;
        this.b.setShowWhen(eVar.n);
        a.i(this.b, eVar.z);
        a.g(this.b, eVar.w);
        a.j(this.b, eVar.y);
        a.h(this.b, eVar.x);
        this.h = eVar.P;
        b.b(this.b, eVar.C);
        b.c(this.b, eVar.E);
        b.f(this.b, eVar.F);
        b.d(this.b, eVar.G);
        b.e(this.b, notification.sound, notification.audioAttributes);
        List listE = i2 < 28 ? e(g(eVar.c), eVar.V) : eVar.V;
        if (listE != null && !listE.isEmpty()) {
            Iterator it3 = listE.iterator();
            while (it3.hasNext()) {
                b.a(this.b, (String) it3.next());
            }
        }
        this.i = eVar.J;
        if (eVar.d.size() > 0) {
            Bundle bundle2 = eVar.d().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i3 = 0; i3 < eVar.d.size(); i3++) {
                bundle4.putBundle(Integer.toString(i3), AbstractC19953rD4.a((AbstractC16407lD4.a) eVar.d.get(i3)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            eVar.d().putBundle("android.car.EXTENSIONS", bundle2);
            this.g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i4 = Build.VERSION.SDK_INT;
        Object obj = eVar.U;
        if (obj != null) {
            c.c(this.b, obj);
        }
        this.b.setExtras(eVar.D);
        d.e(this.b, eVar.s);
        RemoteViews remoteViews = eVar.H;
        if (remoteViews != null) {
            d.c(this.b, remoteViews);
        }
        RemoteViews remoteViews2 = eVar.I;
        if (remoteViews2 != null) {
            d.b(this.b, remoteViews2);
        }
        RemoteViews remoteViews3 = eVar.J;
        if (remoteViews3 != null) {
            d.d(this.b, remoteViews3);
        }
        if (i4 >= 26) {
            e.b(this.b, eVar.L);
            e.e(this.b, eVar.r);
            e.f(this.b, eVar.M);
            e.g(this.b, eVar.O);
            e.d(this.b, eVar.P);
            if (eVar.B) {
                e.c(this.b, eVar.A);
            }
            if (!TextUtils.isEmpty(eVar.K)) {
                this.b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i4 >= 28) {
            Iterator it4 = eVar.c.iterator();
            while (it4.hasNext()) {
                f.a(this.b, ((D55) it4.next()).k());
            }
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            g.a(this.b, eVar.R);
            g.b(this.b, AbstractC16407lD4.d.a(null));
            C18224oI3 c18224oI3 = eVar.N;
            if (c18224oI3 != null) {
                g.d(this.b, c18224oI3.c());
            }
        }
        if (i5 >= 31 && (i = eVar.Q) != 0) {
            h.b(this.b, i);
        }
        if (eVar.T) {
            if (this.c.x) {
                this.h = 2;
            } else {
                this.h = 1;
            }
            this.b.setVibrate(null);
            this.b.setSound(null);
            int i6 = notification.defaults & (-4);
            notification.defaults = i6;
            this.b.setDefaults(i6);
            if (i5 >= 26) {
                if (TextUtils.isEmpty(this.c.w)) {
                    a.g(this.b, "silent");
                }
                e.d(this.b, this.h);
            }
        }
    }

    private void b(AbstractC16407lD4.a aVar) {
        IconCompat iconCompatD = aVar.d();
        Notification.Action.Builder builderA = c.a(iconCompatD != null ? iconCompatD.w() : null, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : C18862pN5.b(aVar.e())) {
                a.c(builderA, remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i = Build.VERSION.SDK_INT;
        d.a(builderA, aVar.b());
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i >= 28) {
            f.b(builderA, aVar.f());
        }
        if (i >= 29) {
            g.c(builderA, aVar.j());
        }
        if (i >= 31) {
            h.a(builderA, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        a.b(builderA, bundle);
        a.a(this.b, a.d(builderA));
    }

    private static List e(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        PJ pj = new PJ(list.size() + list2.size());
        pj.addAll(list);
        pj.addAll(list2);
        return new ArrayList(pj);
    }

    private static List g(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((D55) it.next()).j());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    @Override // ir.nasim.InterfaceC10184bD4
    public Notification.Builder a() {
        return this.b;
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsK;
        RemoteViews remoteViewsI;
        AbstractC16407lD4.j jVar = this.c.p;
        if (jVar != null) {
            jVar.b(this);
        }
        RemoteViews remoteViewsJ = jVar != null ? jVar.j(this) : null;
        Notification notificationD = d();
        if (remoteViewsJ != null) {
            notificationD.contentView = remoteViewsJ;
        } else {
            RemoteViews remoteViews = this.c.H;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (jVar != null && (remoteViewsI = jVar.i(this)) != null) {
            notificationD.bigContentView = remoteViewsI;
        }
        if (jVar != null && (remoteViewsK = this.c.p.k(this)) != null) {
            notificationD.headsUpContentView = remoteViewsK;
        }
        if (jVar != null && (bundleA = AbstractC16407lD4.a(notificationD)) != null) {
            jVar.a(bundleA);
        }
        return notificationD;
    }

    protected Notification d() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.b.build();
        }
        Notification notificationBuild = this.b.build();
        if (this.h != 0) {
            if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) != 0 && this.h == 2) {
                h(notificationBuild);
            }
            if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) == 0 && this.h == 1) {
                h(notificationBuild);
            }
        }
        return notificationBuild;
    }

    Context f() {
        return this.a;
    }
}
