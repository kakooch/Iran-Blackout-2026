package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.media.RingtoneManager;
import android.net.Uri;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;

/* renamed from: ir.nasim.aE4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC9599aE4 {
    public static final a a = new a(null);
    private static int b = -1;
    private static long c = -1;
    private static final InterfaceC9173Yu3 d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ZD4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return AbstractC9599aE4.h();
        }
    });

    /* renamed from: ir.nasim.aE4$a */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ Object h(a aVar, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return aVar.g(z, z2, interfaceC20295rm1);
        }

        private final String j(Context context, Uri uri) {
            String title = RingtoneManager.getRingtone(context, uri).getTitle(context);
            if (title.equals(String.valueOf(AbstractC19954rD5.notification))) {
                CharSequence text = context.getText(AbstractC12217eE5.default_sound);
                AbstractC13042fc3.g(text, "null cannot be cast to non-null type kotlin.String");
                title = (String) text;
            }
            AbstractC13042fc3.f(title);
            return title;
        }

        public static /* synthetic */ Uri n(a aVar, AbstractC24063xz abstractC24063xz, int i, Object obj) {
            if ((i & 1) != 0) {
                abstractC24063xz = null;
            }
            return aVar.m(abstractC24063xz);
        }

        public static /* synthetic */ Object p(a aVar, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return aVar.o(z, interfaceC20295rm1);
        }

        public final void A(long j) {
            AbstractC9599aE4.c = j;
        }

        public final void B(Uri uri) {
            C7183Qq.q(EnumC18608ow5.e).putString("NOTIFICATION_DEFAULT_SOUND", String.valueOf(uri));
        }

        public final void C(boolean z) {
            C7183Qq.q(EnumC18608ow5.e).g("notif_sound_enabled", z);
        }

        public final void a(Context context) {
            AbstractC13042fc3.i(context, "context");
            AD4.e(context).d();
        }

        public final void b() {
            l().T6(!r());
        }

        public final void c() {
            l().a7(!s());
        }

        public final void d() {
            l().q7(!u());
        }

        public final void e() {
            l().n7(!t());
        }

        public final void f() {
            l().D7(!v());
        }

        public final Object g(boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            XU6 xu6 = z2 ? XU6.UserConfigKey_LikeStoryNotification : XU6.UserConfigKey_ContactsStoryNotification;
            C6287Mz c6287MzS = AbstractC5969Lp4.e().s();
            AbstractC13042fc3.h(c6287MzS, "getApiModule(...)");
            Object objC = new CR6(c6287MzS).c(xu6, z, interfaceC20295rm1);
            return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
        }

        public final long i() {
            return AbstractC9599aE4.c;
        }

        public final CharSequence k() {
            Context contextD = C5721Ko.a.d();
            CharSequence text = contextD.getText(AbstractC12217eE5.not_sound_subtitle);
            AbstractC13042fc3.h(text, "getText(...)");
            Uri uriN = n(this, null, 1, null);
            if (uriN == null) {
                return text;
            }
            String strJ = j(contextD, uriN);
            if (!AbstractC13042fc3.d(strJ.toString(), "null")) {
                return strJ;
            }
            String string = contextD.getString(AbstractC12217eE5.mute_icon_content_description);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }

        public final SettingsModule l() {
            return (SettingsModule) AbstractC9599aE4.d.getValue();
        }

        public final Uri m(AbstractC24063xz abstractC24063xz) {
            if (abstractC24063xz != null && ((abstractC24063xz instanceof C21001sy) || (abstractC24063xz instanceof C22874vy))) {
                return Uri.parse("android.resource://" + C5721Ko.a.d().getPackageName() + Separators.SLASH + AbstractC19954rD5.coin);
            }
            String strE = C7183Qq.q(EnumC18608ow5.e).e("NOTIFICATION_DEFAULT_SOUND");
            if (strE == null) {
                if (!w()) {
                    return null;
                }
                strE = "android.resource://" + C5721Ko.a.d().getPackageName() + Separators.SLASH + AbstractC19954rD5.notification;
            }
            return Uri.parse(strE);
        }

        public final Object o(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(XU6.UserConfigKey_LikeStoryNotification);
            } else {
                arrayList.add(XU6.UserConfigKey_ContactsStoryNotification);
            }
            C6287Mz c6287MzS = AbstractC5969Lp4.e().s();
            AbstractC13042fc3.h(c6287MzS, "getApiModule(...)");
            return new CR6(c6287MzS).b(arrayList, interfaceC20295rm1);
        }

        public final boolean q(int i, Long l) {
            return (l != null && AbstractC9599aE4.a.i() == l.longValue()) || AbstractC9599aE4.b == i;
        }

        public final boolean r() {
            return l().D5();
        }

        public final boolean s() {
            return l().E5();
        }

        public final boolean t() {
            return l().J5();
        }

        public final boolean u() {
            return l().L5();
        }

        public final boolean v() {
            return l().N5();
        }

        public final boolean w() {
            return C7183Qq.q(EnumC18608ow5.e).h("notif_sound_enabled", true);
        }

        public final boolean x() {
            String str = n(this, null, 1, null) + "isSoundEnabled:" + w() + "isLEDLightEnabled:" + s();
            EnumC18608ow5 enumC18608ow5 = EnumC18608ow5.e;
            String strE = C7183Qq.q(enumC18608ow5).e("PUSH_SETTING_HASH");
            String strA = AbstractC15318jN7.a(str);
            if (strA.equals(strE)) {
                return false;
            }
            C7183Qq.q(enumC18608ow5).putString("PUSH_SETTING_HASH", strA);
            return true;
        }

        public final void y() {
            AbstractC9599aE4.b = -1;
        }

        public final void z(int i) {
            AbstractC9599aE4.b = i;
            AbstractC9599aE4.c = -1L;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final void g(Context context) {
        a.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SettingsModule h() {
        return ((InterfaceC9291Zh4) C92.a(C5721Ko.a.d(), InterfaceC9291Zh4.class)).b1();
    }
}
