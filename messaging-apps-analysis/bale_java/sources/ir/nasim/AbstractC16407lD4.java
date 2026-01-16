package ir.nasim;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import ir.nasim.D55;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: ir.nasim.lD4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16407lD4 {

    /* renamed from: ir.nasim.lD4$a */
    public static class a {
        final Bundle a;
        private IconCompat b;
        private final C18862pN5[] c;
        private final C18862pN5[] d;
        private boolean e;
        boolean f;
        private final int g;
        private final boolean h;
        public int i;
        public CharSequence j;
        public PendingIntent k;
        private boolean l;

        /* renamed from: ir.nasim.lD4$a$a, reason: collision with other inner class name */
        public static final class C1367a {
            private final IconCompat a;
            private final CharSequence b;
            private final PendingIntent c;
            private boolean d;
            private final Bundle e;
            private ArrayList f;
            private int g;
            private boolean h;
            private boolean i;
            private boolean j;

            public C1367a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            private void c() {
                if (this.i && this.c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C1367a a(C18862pN5 c18862pN5) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                if (c18862pN5 != null) {
                    this.f.add(c18862pN5);
                }
                return this;
            }

            public a b() {
                c();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = this.f;
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        C18862pN5 c18862pN5 = (C18862pN5) it.next();
                        if (c18862pN5.k()) {
                            arrayList.add(c18862pN5);
                        } else {
                            arrayList2.add(c18862pN5);
                        }
                    }
                }
                return new a(this.a, this.b, this.c, this.e, arrayList2.isEmpty() ? null : (C18862pN5[]) arrayList2.toArray(new C18862pN5[arrayList2.size()]), arrayList.isEmpty() ? null : (C18862pN5[]) arrayList.toArray(new C18862pN5[arrayList.size()]), this.d, this.g, this.h, this.i, this.j);
            }

            public C1367a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i != 0 ? IconCompat.m(null, "", i) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            private C1367a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C18862pN5[] c18862pN5Arr, boolean z, int i, boolean z2, boolean z3, boolean z4) {
                this.d = true;
                this.h = true;
                this.a = iconCompat;
                this.b = e.e(charSequence);
                this.c = pendingIntent;
                this.e = bundle;
                this.f = c18862pN5Arr == null ? null : new ArrayList(Arrays.asList(c18862pN5Arr));
                this.d = z;
                this.g = i;
                this.h = z2;
                this.i = z3;
                this.j = z4;
            }
        }

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.m(null, "", i) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.e;
        }

        public Bundle c() {
            return this.a;
        }

        public IconCompat d() {
            int i;
            if (this.b == null && (i = this.i) != 0) {
                this.b = IconCompat.m(null, "", i);
            }
            return this.b;
        }

        public C18862pN5[] e() {
            return this.c;
        }

        public int f() {
            return this.g;
        }

        public boolean g() {
            return this.f;
        }

        public CharSequence h() {
            return this.j;
        }

        public boolean i() {
            return this.l;
        }

        public boolean j() {
            return this.h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C18862pN5[] c18862pN5Arr, C18862pN5[] c18862pN5Arr2, boolean z, int i, boolean z2, boolean z3, boolean z4) {
            this.f = true;
            this.b = iconCompat;
            if (iconCompat != null && iconCompat.q() == 2) {
                this.i = iconCompat.o();
            }
            this.j = e.e(charSequence);
            this.k = pendingIntent;
            this.a = bundle == null ? new Bundle() : bundle;
            this.c = c18862pN5Arr;
            this.d = c18862pN5Arr2;
            this.e = z;
            this.g = i;
            this.f = z2;
            this.h = z3;
            this.l = z4;
        }
    }

    /* renamed from: ir.nasim.lD4$b */
    public static class b extends j {
        private IconCompat e;
        private IconCompat f;
        private boolean g;
        private CharSequence h;
        private boolean i;

        /* renamed from: ir.nasim.lD4$b$a */
        private static class a {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* renamed from: ir.nasim.lD4$b$b, reason: collision with other inner class name */
        private static class C1368b {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            static void c(Notification.BigPictureStyle bigPictureStyle, boolean z) {
                bigPictureStyle.showBigPictureWhenCollapsed(z);
            }
        }

        private static IconCompat n(Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (parcelable instanceof Icon) {
                return IconCompat.d((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.i((Bitmap) parcelable);
            }
            return null;
        }

        public static IconCompat q(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable("android.picture");
            return parcelable != null ? n(parcelable) : n(bundle.getParcelable("android.pictureIcon"));
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        public void b(InterfaceC10184bD4 interfaceC10184bD4) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(interfaceC10184bD4.a()).setBigContentTitle(this.b);
            IconCompat iconCompat = this.e;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    C1368b.a(bigContentTitle, this.e.x(interfaceC10184bD4 instanceof C19362qD4 ? ((C19362qD4) interfaceC10184bD4).f() : null));
                } else if (iconCompat.q() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.e.n());
                }
            }
            if (this.g) {
                if (this.f == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    a.a(bigContentTitle, this.f.x(interfaceC10184bD4 instanceof C19362qD4 ? ((C19362qD4) interfaceC10184bD4).f() : null));
                }
            }
            if (this.d) {
                bigContentTitle.setSummaryText(this.c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                C1368b.c(bigContentTitle, this.i);
                C1368b.b(bigContentTitle, this.h);
            }
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected String h() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected void l(Bundle bundle) {
            super.l(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.f = n(bundle.getParcelable("android.largeIcon.big"));
                this.g = true;
            }
            this.e = q(bundle);
            this.i = bundle.getBoolean("android.showBigPictureWhenCollapsed");
        }

        public b o(Bitmap bitmap) {
            this.f = bitmap == null ? null : IconCompat.i(bitmap);
            this.g = true;
            return this;
        }

        public b p(Bitmap bitmap) {
            this.e = bitmap == null ? null : IconCompat.i(bitmap);
            return this;
        }
    }

    /* renamed from: ir.nasim.lD4$c */
    public static class c extends j {
        private CharSequence e;

        @Override // ir.nasim.AbstractC16407lD4.j
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        public void b(InterfaceC10184bD4 interfaceC10184bD4) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(interfaceC10184bD4.a()).setBigContentTitle(this.b).bigText(this.e);
            if (this.d) {
                bigTextStyleBigText.setSummaryText(this.c);
            }
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected String h() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected void l(Bundle bundle) {
            super.l(bundle);
            this.e = bundle.getCharSequence("android.bigText");
        }

        public c n(CharSequence charSequence) {
            this.e = e.e(charSequence);
            return this;
        }
    }

    /* renamed from: ir.nasim.lD4$d */
    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    /* renamed from: ir.nasim.lD4$f */
    public static class f extends j {
        private int e;
        private D55 f;
        private PendingIntent g;
        private PendingIntent h;
        private PendingIntent i;
        private boolean j;
        private Integer k;
        private Integer l;
        private IconCompat m;
        private CharSequence n;

        /* renamed from: ir.nasim.lD4$f$a */
        static class a {
            static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        /* renamed from: ir.nasim.lD4$f$d */
        static class d {
            static Notification.CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            static Notification.CallStyle b(Person person, PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            static Notification.CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            static Notification.CallStyle d(Notification.CallStyle callStyle, int i) {
                return callStyle.setAnswerButtonColorHint(i);
            }

            static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z) {
                return builder.setAuthenticationRequired(z);
            }

            static Notification.CallStyle f(Notification.CallStyle callStyle, int i) {
                return callStyle.setDeclineButtonColorHint(i);
            }

            static Notification.CallStyle g(Notification.CallStyle callStyle, boolean z) {
                return callStyle.setIsVideo(z);
            }

            static Notification.CallStyle h(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            static Notification.CallStyle i(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        public f() {
        }

        public static f n(D55 d55, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
            Objects.requireNonNull(pendingIntent, "declineIntent is required");
            Objects.requireNonNull(pendingIntent2, "answerIntent is required");
            return new f(1, d55, null, pendingIntent, pendingIntent2);
        }

        private String p() {
            int i = this.e;
            if (i == 1) {
                return this.a.a.getResources().getString(AbstractC10194bE5.call_notification_incoming_text);
            }
            if (i == 2) {
                return this.a.a.getResources().getString(AbstractC10194bE5.call_notification_ongoing_text);
            }
            if (i != 3) {
                return null;
            }
            return this.a.a.getResources().getString(AbstractC10194bE5.call_notification_screening_text);
        }

        private boolean q(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        private a r(int i, int i2, Integer num, int i3, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(AbstractC4043Dl1.c(this.a.a, i3));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.a.a.getResources().getString(i2));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a aVarB = new a.C1367a(IconCompat.l(this.a.a, i), spannableStringBuilder, pendingIntent).b();
            aVarB.c().putBoolean("key_action_priority", true);
            return aVarB;
        }

        private a s() {
            int i = EB5.ic_call_answer_video;
            int i2 = EB5.ic_call_answer;
            PendingIntent pendingIntent = this.g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z = this.j;
            return r(z ? i : i2, z ? AbstractC10194bE5.call_notification_answer_video_action : AbstractC10194bE5.call_notification_answer_action, this.k, NA5.call_notification_answer_color, pendingIntent);
        }

        private a t() {
            int i = EB5.ic_call_decline;
            PendingIntent pendingIntent = this.h;
            return pendingIntent == null ? r(i, AbstractC10194bE5.call_notification_hang_up_action, this.l, NA5.call_notification_decline_color, this.i) : r(i, AbstractC10194bE5.call_notification_decline_action, this.l, NA5.call_notification_decline_color, pendingIntent);
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", this.e);
            bundle.putBoolean("android.callIsVideo", this.j);
            D55 d55 = this.f;
            if (d55 != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("android.callPerson", c.b(d55.k()));
                } else {
                    bundle.putParcelable("android.callPersonCompat", d55.l());
                }
            }
            IconCompat iconCompat = this.m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", b.a(iconCompat.x(this.a.a)));
            }
            bundle.putCharSequence("android.verificationText", this.n);
            bundle.putParcelable("android.answerIntent", this.g);
            bundle.putParcelable("android.declineIntent", this.h);
            bundle.putParcelable("android.hangUpIntent", this.i);
            Integer num = this.k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        public void b(InterfaceC10184bD4 interfaceC10184bD4) {
            int i = Build.VERSION.SDK_INT;
            CharSequence charSequenceP = null;
            callStyleA = null;
            Notification.CallStyle callStyleA = null;
            charSequenceP = null;
            if (i < 31) {
                Notification.Builder builderA = interfaceC10184bD4.a();
                D55 d55 = this.f;
                builderA.setContentTitle(d55 != null ? d55.f() : null);
                Bundle bundle = this.a.D;
                if (bundle != null && bundle.containsKey("android.text")) {
                    charSequenceP = this.a.D.getCharSequence("android.text");
                }
                if (charSequenceP == null) {
                    charSequenceP = p();
                }
                builderA.setContentText(charSequenceP);
                D55 d552 = this.f;
                if (d552 != null) {
                    if (d552.d() != null) {
                        b.c(builderA, this.f.d().x(this.a.a));
                    }
                    if (i >= 28) {
                        c.a(builderA, this.f.k());
                    } else {
                        a.a(builderA, this.f.g());
                    }
                }
                a.b(builderA, "call");
                return;
            }
            int i2 = this.e;
            if (i2 == 1) {
                callStyleA = d.a(this.f.k(), this.h, this.g);
            } else if (i2 == 2) {
                callStyleA = d.b(this.f.k(), this.i);
            } else if (i2 == 3) {
                callStyleA = d.c(this.f.k(), this.i, this.g);
            } else if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.e));
            }
            if (callStyleA != null) {
                callStyleA.setBuilder(interfaceC10184bD4.a());
                Integer num = this.k;
                if (num != null) {
                    d.d(callStyleA, num.intValue());
                }
                Integer num2 = this.l;
                if (num2 != null) {
                    d.f(callStyleA, num2.intValue());
                }
                d.i(callStyleA, this.n);
                IconCompat iconCompat = this.m;
                if (iconCompat != null) {
                    d.h(callStyleA, iconCompat.x(this.a.a));
                }
                d.g(callStyleA, this.j);
            }
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected String h() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected void l(Bundle bundle) {
            super.l(bundle);
            this.e = bundle.getInt("android.callType");
            this.j = bundle.getBoolean("android.callIsVideo");
            if (Build.VERSION.SDK_INT >= 28 && bundle.containsKey("android.callPerson")) {
                this.f = D55.a(AbstractC18180oD4.a(bundle.getParcelable("android.callPerson")));
            } else if (bundle.containsKey("android.callPersonCompat")) {
                this.f = D55.b(bundle.getBundle("android.callPersonCompat"));
            }
            if (bundle.containsKey("android.verificationIcon")) {
                this.m = IconCompat.d((Icon) bundle.getParcelable("android.verificationIcon"));
            } else if (bundle.containsKey("android.verificationIconCompat")) {
                this.m = IconCompat.a(bundle.getBundle("android.verificationIconCompat"));
            }
            this.n = bundle.getCharSequence("android.verificationText");
            this.g = (PendingIntent) bundle.getParcelable("android.answerIntent");
            this.h = (PendingIntent) bundle.getParcelable("android.declineIntent");
            this.i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
            this.k = bundle.containsKey("android.answerColor") ? Integer.valueOf(bundle.getInt("android.answerColor")) : null;
            this.l = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
        }

        public ArrayList o() {
            a aVarT = t();
            a aVarS = s();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(aVarT);
            ArrayList<a> arrayList2 = this.a.b;
            int i = 2;
            if (arrayList2 != null) {
                for (a aVar : arrayList2) {
                    if (aVar.j()) {
                        arrayList.add(aVar);
                    } else if (!q(aVar) && i > 1) {
                        arrayList.add(aVar);
                        i--;
                    }
                    if (aVarS != null && i == 1) {
                        arrayList.add(aVarS);
                        i--;
                    }
                }
            }
            if (aVarS != null && i >= 1) {
                arrayList.add(aVarS);
            }
            return arrayList;
        }

        private f(int i, D55 d55, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3) {
            if (d55 == null || TextUtils.isEmpty(d55.f())) {
                throw new IllegalArgumentException("person must have a non-empty a name");
            }
            this.e = i;
            this.f = d55;
            this.g = pendingIntent3;
            this.h = pendingIntent2;
            this.i = pendingIntent;
        }

        /* renamed from: ir.nasim.lD4$f$b */
        static class b {
            static Notification.Action.Builder b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            static void c(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }

            static Parcelable a(Icon icon) {
                return icon;
            }
        }

        /* renamed from: ir.nasim.lD4$f$c */
        static class c {
            static Notification.Builder a(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }

            static Parcelable b(Person person) {
                return person;
            }
        }
    }

    /* renamed from: ir.nasim.lD4$g */
    public static class g extends j {

        /* renamed from: ir.nasim.lD4$g$a */
        static class a {
            static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        public void b(InterfaceC10184bD4 interfaceC10184bD4) {
            interfaceC10184bD4.a().setStyle(a.a());
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected String h() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        public RemoteViews i(InterfaceC10184bD4 interfaceC10184bD4) {
            return null;
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        public RemoteViews j(InterfaceC10184bD4 interfaceC10184bD4) {
            return null;
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        public RemoteViews k(InterfaceC10184bD4 interfaceC10184bD4) {
            return null;
        }
    }

    /* renamed from: ir.nasim.lD4$h */
    public static class h extends j {
        private ArrayList e = new ArrayList();

        @Override // ir.nasim.AbstractC16407lD4.j
        public void b(InterfaceC10184bD4 interfaceC10184bD4) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(interfaceC10184bD4.a()).setBigContentTitle(this.b);
            if (this.d) {
                bigContentTitle.setSummaryText(this.c);
            }
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine((CharSequence) it.next());
            }
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected String h() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected void l(Bundle bundle) {
            super.l(bundle);
            this.e.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.e, bundle.getCharSequenceArray("android.textLines"));
            }
        }

        public h n(CharSequence charSequence) {
            this.b = e.e(charSequence);
            return this;
        }

        public h o(CharSequence charSequence) {
            this.c = e.e(charSequence);
            this.d = true;
            return this;
        }
    }

    /* renamed from: ir.nasim.lD4$j */
    public static abstract class j {
        protected e a;
        CharSequence b;
        CharSequence c;
        boolean d = false;

        static j c(String str) {
            if (str == null) {
                return null;
            }
            switch (str) {
                case "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle":
                    return new g();
                case "androidx.core.app.NotificationCompat$BigPictureStyle":
                    return new b();
                case "androidx.core.app.NotificationCompat$CallStyle":
                    return new f();
                case "androidx.core.app.NotificationCompat$InboxStyle":
                    return new h();
                case "androidx.core.app.NotificationCompat$BigTextStyle":
                    return new c();
                case "androidx.core.app.NotificationCompat$MessagingStyle":
                    return new i();
                default:
                    return null;
            }
        }

        private static j d(String str) {
            if (str == null) {
                return null;
            }
            if (str.equals(Notification.BigPictureStyle.class.getName())) {
                return new b();
            }
            if (str.equals(Notification.BigTextStyle.class.getName())) {
                return new c();
            }
            if (str.equals(Notification.InboxStyle.class.getName())) {
                return new h();
            }
            if (str.equals(Notification.MessagingStyle.class.getName())) {
                return new i();
            }
            if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                return new g();
            }
            return null;
        }

        static j e(Bundle bundle) {
            j jVarC = c(bundle.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
            return jVarC != null ? jVarC : (bundle.containsKey("android.selfDisplayName") || bundle.containsKey("android.messagingStyleUser")) ? new i() : (bundle.containsKey("android.picture") || bundle.containsKey("android.pictureIcon")) ? new b() : bundle.containsKey("android.bigText") ? new c() : bundle.containsKey("android.textLines") ? new h() : bundle.containsKey("android.callType") ? new f() : d(bundle.getString("android.template"));
        }

        static j f(Bundle bundle) {
            j jVarE = e(bundle);
            if (jVarE == null) {
                return null;
            }
            try {
                jVarE.l(bundle);
                return jVarE;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        public static j g(Notification notification) {
            Bundle bundleA = AbstractC16407lD4.a(notification);
            if (bundleA == null) {
                return null;
            }
            return f(bundleA);
        }

        public void a(Bundle bundle) {
            if (this.d) {
                bundle.putCharSequence("android.summaryText", this.c);
            }
            CharSequence charSequence = this.b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strH = h();
            if (strH != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strH);
            }
        }

        public abstract void b(InterfaceC10184bD4 interfaceC10184bD4);

        protected String h() {
            return null;
        }

        public RemoteViews i(InterfaceC10184bD4 interfaceC10184bD4) {
            return null;
        }

        public RemoteViews j(InterfaceC10184bD4 interfaceC10184bD4) {
            return null;
        }

        public RemoteViews k(InterfaceC10184bD4 interfaceC10184bD4) {
            return null;
        }

        protected void l(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.c = bundle.getCharSequence("android.summaryText");
                this.d = true;
            }
            this.b = bundle.getCharSequence("android.title.big");
        }

        public void m(e eVar) {
            if (this.a != eVar) {
                this.a = eVar;
                if (eVar != null) {
                    eVar.M(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static Bitmap b(Context context, Bitmap bitmap) throws Resources.NotFoundException {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(AbstractC9573aB5.compat_notification_large_icon_max_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(AbstractC9573aB5.compat_notification_large_icon_max_height);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * dMin), (int) Math.ceil(bitmap.getHeight() * dMin), true);
    }

    /* renamed from: ir.nasim.lD4$i */
    public static class i extends j {
        private final List e = new ArrayList();
        private final List f = new ArrayList();
        private D55 g;
        private CharSequence h;
        private Boolean i;

        /* renamed from: ir.nasim.lD4$i$a */
        static class a {
            static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            static Notification.MessagingStyle b(CharSequence charSequence) {
                return new Notification.MessagingStyle(charSequence);
            }

            static Notification.MessagingStyle c(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        /* renamed from: ir.nasim.lD4$i$b */
        static class b {
            static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        /* renamed from: ir.nasim.lD4$i$c */
        static class c {
            static Notification.MessagingStyle a(Person person) {
                return new Notification.MessagingStyle(person);
            }

            static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z) {
                return messagingStyle.setGroupConversation(z);
            }
        }

        i() {
        }

        public static i o(Notification notification) {
            j jVarG = j.g(notification);
            if (jVarG instanceof i) {
                return (i) jVarG;
            }
            return null;
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.g.f());
            bundle.putBundle("android.messagingStyleUser", this.g.l());
            bundle.putCharSequence("android.hiddenConversationTitle", this.h);
            if (this.h != null && this.i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.h);
            }
            if (!this.e.isEmpty()) {
                bundle.putParcelableArray("android.messages", d.a(this.e));
            }
            if (!this.f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", d.a(this.f));
            }
            Boolean bool = this.i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        public void b(InterfaceC10184bD4 interfaceC10184bD4) {
            t(r());
            Notification.MessagingStyle messagingStyleA = Build.VERSION.SDK_INT >= 28 ? c.a(this.g.k()) : a.b(this.g.f());
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                a.a(messagingStyleA, ((d) it.next()).k());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Iterator it2 = this.f.iterator();
                while (it2.hasNext()) {
                    b.a(messagingStyleA, ((d) it2.next()).k());
                }
            }
            if (this.i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                a.c(messagingStyleA, this.h);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                c.b(messagingStyleA, this.i.booleanValue());
            }
            messagingStyleA.setBuilder(interfaceC10184bD4.a());
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected String h() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @Override // ir.nasim.AbstractC16407lD4.j
        protected void l(Bundle bundle) {
            super.l(bundle);
            this.e.clear();
            if (bundle.containsKey("android.messagingStyleUser")) {
                this.g = D55.b(bundle.getBundle("android.messagingStyleUser"));
            } else {
                this.g = new D55.c().f(bundle.getString("android.selfDisplayName")).a();
            }
            CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
            this.h = charSequence;
            if (charSequence == null) {
                this.h = bundle.getCharSequence("android.hiddenConversationTitle");
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
            if (parcelableArray != null) {
                this.e.addAll(d.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
            if (parcelableArray2 != null) {
                this.f.addAll(d.f(parcelableArray2));
            }
            if (bundle.containsKey("android.isGroupConversation")) {
                this.i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
            }
        }

        public i n(d dVar) {
            if (dVar != null) {
                this.e.add(dVar);
                if (this.e.size() > 25) {
                    this.e.remove(0);
                }
            }
            return this;
        }

        public List p() {
            return this.e;
        }

        public D55 q() {
            return this.g;
        }

        public boolean r() {
            e eVar = this.a;
            if (eVar != null && eVar.a.getApplicationInfo().targetSdkVersion < 28 && this.i == null) {
                return this.h != null;
            }
            Boolean bool = this.i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public i s(CharSequence charSequence) {
            this.h = charSequence;
            return this;
        }

        public i t(boolean z) {
            this.i = Boolean.valueOf(z);
            return this;
        }

        public i(D55 d55) {
            if (!TextUtils.isEmpty(d55.f())) {
                this.g = d55;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        /* renamed from: ir.nasim.lD4$i$d */
        public static final class d {
            private final CharSequence a;
            private final long b;
            private final D55 c;
            private Bundle d = new Bundle();
            private String e;
            private Uri f;

            /* renamed from: ir.nasim.lD4$i$d$a */
            static class a {
                static Notification.MessagingStyle.Message a(CharSequence charSequence, long j, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j, charSequence2);
                }

                static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            public d(CharSequence charSequence, long j, D55 d55) {
                this.a = charSequence;
                this.b = j;
                this.c = d55;
            }

            static Bundle[] a(List list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = ((d) list.get(i)).l();
                }
                return bundleArr;
            }

            static d e(Bundle bundle) {
                try {
                    if (bundle.containsKey(ParameterNames.TEXT) && bundle.containsKey("time")) {
                        d dVar = new d(bundle.getCharSequence(ParameterNames.TEXT), bundle.getLong("time"), bundle.containsKey("person") ? D55.b(bundle.getBundle("person")) : (!bundle.containsKey("sender_person") || Build.VERSION.SDK_INT < 28) ? bundle.containsKey("sender") ? new D55.c().f(bundle.getCharSequence("sender")).a() : null : D55.a(AbstractC18180oD4.a(bundle.getParcelable("sender_person"))));
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            dVar.j(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                        }
                        if (bundle.containsKey("extras")) {
                            dVar.d().putAll(bundle.getBundle("extras"));
                        }
                        return dVar;
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            static List f(Parcelable[] parcelableArr) {
                d dVarE;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (Parcelable parcelable : parcelableArr) {
                    if ((parcelable instanceof Bundle) && (dVarE = e((Bundle) parcelable)) != null) {
                        arrayList.add(dVarE);
                    }
                }
                return arrayList;
            }

            private Bundle l() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.a;
                if (charSequence != null) {
                    bundle.putCharSequence(ParameterNames.TEXT, charSequence);
                }
                bundle.putLong("time", this.b);
                D55 d55 = this.c;
                if (d55 != null) {
                    bundle.putCharSequence("sender", d55.f());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", b.a(this.c.k()));
                    } else {
                        bundle.putBundle("person", this.c.l());
                    }
                }
                String str = this.e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            public String b() {
                return this.e;
            }

            public Uri c() {
                return this.f;
            }

            public Bundle d() {
                return this.d;
            }

            public D55 g() {
                return this.c;
            }

            public CharSequence h() {
                return this.a;
            }

            public long i() {
                return this.b;
            }

            public d j(String str, Uri uri) {
                this.e = str;
                this.f = uri;
                return this;
            }

            Notification.MessagingStyle.Message k() {
                Notification.MessagingStyle.Message messageA;
                D55 d55G = g();
                if (Build.VERSION.SDK_INT >= 28) {
                    messageA = b.b(h(), i(), d55G != null ? d55G.k() : null);
                } else {
                    messageA = a.a(h(), i(), d55G != null ? d55G.f() : null);
                }
                if (b() != null) {
                    a.b(messageA, b(), c());
                }
                return messageA;
            }

            /* renamed from: ir.nasim.lD4$i$d$b */
            static class b {
                static Notification.MessagingStyle.Message b(CharSequence charSequence, long j, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j, person);
                }

                static Parcelable a(Person person) {
                    return person;
                }
            }
        }
    }

    /* renamed from: ir.nasim.lD4$e */
    public static class e {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        C18224oI3 N;
        long O;
        int P;
        int Q;
        boolean R;
        Notification S;
        boolean T;
        Object U;
        public ArrayList V;
        public Context a;
        public ArrayList b;
        public ArrayList c;
        ArrayList d;
        CharSequence e;
        CharSequence f;
        PendingIntent g;
        PendingIntent h;
        RemoteViews i;
        IconCompat j;
        CharSequence k;
        int l;
        int m;
        boolean n;
        boolean o;
        j p;
        CharSequence q;
        CharSequence r;
        CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;

        /* renamed from: ir.nasim.lD4$e$a */
        static class a {
            static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i) {
                return builder.setContentType(i);
            }

            static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i) {
                return builder.setLegacyStreamType(i);
            }

            static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i) {
                return builder.setUsage(i);
            }
        }

        public e(Context context, String str) {
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.P = 0;
            this.Q = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.m = 0;
            this.V = new ArrayList();
            this.R = true;
        }

        protected static CharSequence e(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void u(int i, boolean z) {
            if (z) {
                Notification notification = this.S;
                notification.flags = i | notification.flags;
            } else {
                Notification notification2 = this.S;
                notification2.flags = (~i) & notification2.flags;
            }
        }

        public e A(int i, int i2, int i3) {
            Notification notification = this.S;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            notification.flags = ((i2 == 0 || i3 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e B(boolean z) {
            this.z = z;
            return this;
        }

        public e C(int i) {
            this.l = i;
            return this;
        }

        public e D(boolean z) {
            u(2, z);
            return this;
        }

        public e E(boolean z) {
            u(8, z);
            return this;
        }

        public e F(int i) {
            this.m = i;
            return this;
        }

        public e G(int i, int i2, boolean z) {
            this.t = i;
            this.u = i2;
            this.v = z;
            return this;
        }

        public e H(C15791kA6 c15791kA6) {
            if (c15791kA6 == null) {
                return this;
            }
            this.M = c15791kA6.f();
            if (this.N == null) {
                if (c15791kA6.h() != null) {
                    this.N = c15791kA6.h();
                } else if (c15791kA6.f() != null) {
                    this.N = new C18224oI3(c15791kA6.f());
                }
            }
            if (this.e == null) {
                n(c15791kA6.n());
            }
            return this;
        }

        public e I(boolean z) {
            this.n = z;
            return this;
        }

        public e J(boolean z) {
            this.T = z;
            return this;
        }

        public e K(int i) {
            this.S.icon = i;
            return this;
        }

        public e L(Uri uri) {
            Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder builderE = a.e(a.c(a.b(), 4), 5);
            this.S.audioAttributes = a.a(builderE);
            return this;
        }

        public e M(j jVar) {
            if (this.p != jVar) {
                this.p = jVar;
                if (jVar != null) {
                    jVar.m(this);
                }
            }
            return this;
        }

        public e N(CharSequence charSequence) {
            this.q = e(charSequence);
            return this;
        }

        public e O(CharSequence charSequence) {
            this.S.tickerText = e(charSequence);
            return this;
        }

        public e P(boolean z) {
            this.o = z;
            return this;
        }

        public e Q(long[] jArr) {
            this.S.vibrate = jArr;
            return this;
        }

        public e R(int i) {
            this.F = i;
            return this;
        }

        public e S(long j) {
            this.S.when = j;
            return this;
        }

        public e a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.b.add(new a(i, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.b.add(aVar);
            }
            return this;
        }

        public Notification c() {
            return new C19362qD4(this).c();
        }

        public Bundle d() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public e f(boolean z) {
            u(16, z);
            return this;
        }

        public e g(int i) {
            this.L = i;
            return this;
        }

        public e h(String str) {
            this.C = str;
            return this;
        }

        public e i(String str) {
            this.K = str;
            return this;
        }

        public e j(int i) {
            this.E = i;
            return this;
        }

        public e k(boolean z) {
            this.A = z;
            this.B = true;
            return this;
        }

        public e l(PendingIntent pendingIntent) {
            this.g = pendingIntent;
            return this;
        }

        public e m(CharSequence charSequence) {
            this.f = e(charSequence);
            return this;
        }

        public e n(CharSequence charSequence) {
            this.e = e(charSequence);
            return this;
        }

        public e o(RemoteViews remoteViews) {
            this.I = remoteViews;
            return this;
        }

        public e p(RemoteViews remoteViews) {
            this.H = remoteViews;
            return this;
        }

        public e q(RemoteViews remoteViews) {
            this.J = remoteViews;
            return this;
        }

        public e r(int i) {
            Notification notification = this.S;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e s(PendingIntent pendingIntent) {
            this.S.deleteIntent = pendingIntent;
            return this;
        }

        public e t(Bundle bundle) {
            this.D = bundle;
            return this;
        }

        public e v(PendingIntent pendingIntent, boolean z) {
            this.h = pendingIntent;
            u(128, z);
            return this;
        }

        public e w(String str) {
            this.w = str;
            return this;
        }

        public e x(int i) {
            this.P = i;
            return this;
        }

        public e y(boolean z) {
            this.x = z;
            return this;
        }

        public e z(Bitmap bitmap) {
            this.j = bitmap == null ? null : IconCompat.i(AbstractC16407lD4.b(this.a, bitmap));
            return this;
        }

        public e(Context context) {
            this(context, null);
        }
    }
}
