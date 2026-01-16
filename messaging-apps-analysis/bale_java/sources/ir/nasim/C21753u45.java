package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C21753u45;
import ir.nasim.InterfaceC19114po0;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: ir.nasim.u45, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21753u45 {
    public static final C21753u45 a = new C21753u45();
    public static final int b = 0;

    /* renamed from: ir.nasim.u45$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (!AbstractC20762sZ6.n0(this.a)) {
                interfaceC22053ub1.W(-924244165);
                AbstractC19555qZ.v0(this.a, null, FV4.c(this.b, interfaceC22053ub1, 0), null, C24381yX0.b.i(), interfaceC22053ub1, 27648, 2);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-923947185);
                AbstractC24667z03.b(FV4.c(this.b, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.m(androidx.compose.ui.e.a, C17784nZ1.q(56.0f)), C24381yX0.b.i(), interfaceC22053ub1, 3504, 0);
                interfaceC22053ub1.Q();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.u45$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.u45$c */
    public static final class c {
        public static final c c = new c("REQUEST_CONTACTS_IN_DIALOGS_CONTAINER_FRAGMENT", 0, "request_contacts_in_dialogs_fragment", 1);
        public static final c d = new c("REQUEST_CONTACTS_IN_CONTACTS_FRAGMENT", 1, "request_contacts_in_contacts_fragment", 3);
        private static final /* synthetic */ c[] e;
        private static final /* synthetic */ F92 f;
        private final String a;
        private final int b;

        static {
            c[] cVarArrA = a();
            e = cVarArrA;
            f = G92.a(cVarArrA);
        }

        private c(String str, int i, String str2, int i2) {
            this.a = str2;
            this.b = i2;
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{c, d};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) e.clone();
        }

        public final int j() {
            return this.b;
        }

        public final String p() {
            return this.a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.u45$d */
    public static final class d {
        public static final a e;
        public static final d f = new d("CAMERA", 0, "android.permission.CAMERA", KB5.ic_permission_camera, AbstractC12217eE5.camera_permission_title, AbstractC12217eE5.camera_video_permission_description);
        public static final d g = new d("CAMERA_TAKE_PHOTO", 1, "android.permission.CAMERA", KB5.ic_permission_camera, AbstractC12217eE5.camera_permission_title, AbstractC12217eE5.camera_video_permission_description_for_take_profile);
        public static final d h = new d("READ_CONTACTS", 2, "android.permission.READ_CONTACTS", KB5.ic_contact, AbstractC12217eE5.empty_text, AbstractC12217eE5.contact_permission_desctiption);
        public static final d i = new d("WRITE_CONTACTS", 3, "android.permission.WRITE_CONTACTS", KB5.ic_contact, AbstractC12217eE5.empty_text, AbstractC12217eE5.contact_permission_desctiption);
        public static final d j;
        public static final d k;
        public static final d l;
        public static final d m;
        public static final d n;
        public static final d o;
        public static final d p;
        public static final d q;
        public static final d r;
        public static final d s;
        public static final d t;
        public static final d u;
        public static final d v;
        public static final d w;
        private static final /* synthetic */ d[] x;
        private static final /* synthetic */ F92 y;
        private final String a;
        private final int b;
        private final int c;
        private final int d;

        /* renamed from: ir.nasim.u45$d$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        static {
            d dVar = new d("READ_EXTERNAL_STORAGE", 4, "android.permission.READ_EXTERNAL_STORAGE", KB5.ic_storage_permission_56, AbstractC12217eE5.storage_permission_title, AbstractC12217eE5.external_storage_permission_desctiption);
            j = dVar;
            k = new d("READ_MEDIA_IMAGES", 5, "android.permission.READ_MEDIA_IMAGES", dVar.b, dVar.c, dVar.d);
            l = new d("READ_MEDIA_VIDEO", 6, "android.permission.READ_MEDIA_VIDEO", dVar.b, dVar.c, dVar.d);
            m = new d("WRITE_EXTERNAL_STORAGE", 7, "android.permission.WRITE_EXTERNAL_STORAGE", KB5.ic_storage_permission_56, AbstractC12217eE5.storage_permission_title, AbstractC12217eE5.external_storage_permission_desctiption);
            n = new d("ACCESS_FINE_LOCATION", 8, "android.permission.ACCESS_FINE_LOCATION", KB5.location, AbstractC12217eE5.location_permission_title, AbstractC12217eE5.location_permission_description);
            o = new d("ACCESS_COARSE_LOCATION", 9, "android.permission.ACCESS_COARSE_LOCATION", KB5.location, AbstractC12217eE5.location_permission_title, AbstractC12217eE5.location_permission_description);
            p = new d("CALL_PHONE", 10, "android.permission.CALL_PHONE", KB5.ic_contact, AbstractC12217eE5.phone_permission_title, AbstractC12217eE5.ussd_call_phone_permission_default_desctiption);
            q = new d("CALL_USSD", 11, "android.permission.CALL_PHONE", KB5.permission_read_phone_state, AbstractC12217eE5.call_phone_state_permission_title, AbstractC12217eE5.call_ussd_phone_permission_default_desctiption);
            r = new d("READ_PHONE_STATE", 12, "android.permission.READ_PHONE_STATE", KB5.ic_contact, AbstractC12217eE5.phone_permission_title, AbstractC12217eE5.ussd_call_phone_permission_default_desctiption);
            s = new d("RECORD_AUDIO", 13, "android.permission.RECORD_AUDIO", KB5.ic_permission_voice, AbstractC12217eE5.voice_permission_title, AbstractC12217eE5.record_audio_permission_desctiption);
            t = new d("CALL_PHONE_SHARED_MEDIA", 14, "android.permission.CALL_PHONE", KB5.ic_contact, AbstractC12217eE5.phone_permission_title, AbstractC12217eE5.ussd_call_phone_permission_for_call);
            u = new d("PHONE_STATE", 15, "android.permission.READ_PHONE_STATE", KB5.permission_read_phone_state, AbstractC12217eE5.call_phone_state_permission_title, AbstractC12217eE5.call_phone_state_permission_description);
            v = new d("BLUETOOTH", 16, "android.permission.BLUETOOTH_CONNECT", KB5.ic_call_bluetooth_selected, AbstractC12217eE5.bluetooth_permission_title, AbstractC12217eE5.call_bluetooth_permission_desctiption);
            w = new d("SHARE_SCREEN", 17, "android.permission.BLUETOOTH_CONNECT", KB5.ic_call_bluetooth_selected, AbstractC12217eE5.bluetooth_permission_title, AbstractC12217eE5.call_bluetooth_permission_desctiption);
            d[] dVarArrA = a();
            x = dVarArrA;
            y = G92.a(dVarArrA);
            e = new a(null);
        }

        private d(String str, int i2, String str2, int i3, int i4, int i5) {
            this.a = str2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
        }

        private static final /* synthetic */ d[] a() {
            return new d[]{f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) x.clone();
        }

        public final int j() {
            return this.d;
        }

        public final int p() {
            return this.b;
        }

        public final String q() {
            return this.a;
        }

        public final int r() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.u45$e */
    static final class e implements InterfaceC14603iB2 {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        e(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (!AbstractC20762sZ6.n0(this.a)) {
                interfaceC22053ub1.W(1753441284);
                AbstractC19555qZ.v0(this.a, null, FV4.c(this.b, interfaceC22053ub1, 0), null, C24381yX0.b.i(), interfaceC22053ub1, 27648, 2);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(1753738264);
                AbstractC24667z03.b(FV4.c(this.b, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.m(androidx.compose.ui.e.a, C17784nZ1.q(56.0f)), C24381yX0.b.i(), interfaceC22053ub1, 3504, 0);
                interfaceC22053ub1.Q();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.u45$f */
    static final class f implements InterfaceC14603iB2 {
        final /* synthetic */ String a;

        f(String str) {
            this.a = str;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.u45$g */
    public static final class g {
        public static final g e = new g("CAMERA", 0, new String[]{"android.permission.CAMERA"}, KB5.ic_permission_camera, AbstractC12217eE5.camera_permission_title, AbstractC12217eE5.web_view_request_camera_permission_description);
        public static final g f = new g("RECORD_AUDIO", 1, new String[]{"android.permission.RECORD_AUDIO"}, KB5.ic_permission_voice, AbstractC12217eE5.voice_permission_title, AbstractC12217eE5.web_view_request_microphone_permission_description);
        public static final g g = new g("LOCATION", 2, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, KB5.location, AbstractC12217eE5.location_permission_modal_title, AbstractC12217eE5.web_view_request_geolocation_permission_description);
        public static final g h = new g("CAMERA_AND_RECORD_AUDIO", 3, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, KB5.ic_permission_camera, AbstractC12217eE5.camera_and_voice_permission_title, AbstractC12217eE5.web_view_request_camera_and_microphone_permission_description);
        private static final /* synthetic */ g[] i;
        private static final /* synthetic */ F92 j;
        private final String[] a;
        private final int b;
        private final int c;
        private final int d;

        static {
            g[] gVarArrA = a();
            i = gVarArrA;
            j = G92.a(gVarArrA);
        }

        private g(String str, int i2, String[] strArr, int i3, int i4, int i5) {
            this.a = strArr;
            this.b = i3;
            this.c = i4;
            this.d = i5;
        }

        private static final /* synthetic */ g[] a() {
            return new g[]{e, f, g, h};
        }

        public static g valueOf(String str) {
            return (g) Enum.valueOf(g.class, str);
        }

        public static g[] values() {
            return (g[]) i.clone();
        }

        public final int j() {
            return this.d;
        }

        public final int p() {
            return this.b;
        }

        public final String[] q() {
            return this.a;
        }

        public final int r() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.u45$h */
    static final class h implements InterfaceC15796kB2 {
        final /* synthetic */ Integer a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ SA2 g;

        h(Integer num, int i, int i2, int i3, int i4, SA2 sa2, SA2 sa22) {
            this.a = num;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = sa2;
            this.g = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(SA2 sa2, Dialog dialog) {
            AbstractC13042fc3.i(sa2, "$onAccept");
            AbstractC13042fc3.i(dialog, "$dialog");
            sa2.invoke();
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(SA2 sa2, Dialog dialog) {
            AbstractC13042fc3.i(sa2, "$onReject");
            AbstractC13042fc3.i(dialog, "$dialog");
            sa2.invoke();
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(SA2 sa2, Dialog dialog) {
            AbstractC13042fc3.i(sa2, "$onAccept");
            AbstractC13042fc3.i(dialog, "$dialog");
            sa2.invoke();
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void d(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            if (this.a == null) {
                interfaceC22053ub1.W(1373205206);
                C21753u45 c21753u45 = C21753u45.a;
                String strC = UY6.c(this.b, interfaceC22053ub1, 0);
                int i2 = this.c;
                String strC2 = UY6.c(this.d, interfaceC22053ub1, 0);
                String strC3 = UY6.c(this.e, interfaceC22053ub1, 0);
                interfaceC22053ub1.W(2122516222);
                boolean zV = interfaceC22053ub1.V(this.f) | interfaceC22053ub1.D(dialog);
                final SA2 sa2 = this.f;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.x45
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C21753u45.h.i(sa2, dialog);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                c21753u45.L(strC, i2, strC2, strC3, (SA2) objB, interfaceC22053ub1, 196608);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(1372578479);
            C21753u45 c21753u452 = C21753u45.a;
            String strC4 = UY6.c(this.b, interfaceC22053ub1, 0);
            int i3 = this.c;
            String strC5 = UY6.c(this.d, interfaceC22053ub1, 0);
            String strC6 = UY6.c(this.e, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(2122495806);
            boolean zV2 = interfaceC22053ub1.V(this.f) | interfaceC22053ub1.D(dialog);
            final SA2 sa22 = this.f;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.v45
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C21753u45.h.f(sa22, dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa23 = (SA2) objB2;
            interfaceC22053ub1.Q();
            String strC7 = UY6.c(this.a.intValue(), interfaceC22053ub1, 0);
            interfaceC22053ub1.W(2122502174);
            boolean zV3 = interfaceC22053ub1.V(this.g) | interfaceC22053ub1.D(dialog);
            final SA2 sa24 = this.g;
            Object objB3 = interfaceC22053ub1.B();
            if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.w45
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C21753u45.h.h(sa24, dialog);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            c21753u452.J(strC4, i3, strC5, strC6, sa23, strC7, (SA2) objB3, interfaceC22053ub1, 12582912);
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    private C21753u45() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A0(SA2 sa2, Activity activity, d dVar, int i) {
        AbstractC13042fc3.i(sa2, "$onRationaleAccept");
        AbstractC13042fc3.i(activity, "$activity");
        AbstractC13042fc3.i(dVar, "$permission");
        sa2.invoke();
        X5.w(activity, new String[]{dVar.q()}, i);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F0(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onRationaleAccept");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G0(Activity activity, SA2 sa2) {
        AbstractC13042fc3.i(activity, "$activity");
        AbstractC13042fc3.i(sa2, "$sendToSetting");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivity(intent);
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(C21753u45 c21753u45, String str, int i, String str2, String str3, SA2 sa2, String str4, SA2 sa22, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c21753u45, "$tmp0_rcvr");
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(str2, "$description");
        AbstractC13042fc3.i(str3, "$positiveTitle");
        AbstractC13042fc3.i(sa2, "$onAccept");
        AbstractC13042fc3.i(str4, "$negativeTitle");
        AbstractC13042fc3.i(sa22, "$onReject");
        c21753u45.J(str, i, str2, str3, sa2, str4, sa22, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M(C21753u45 c21753u45, String str, int i, String str2, String str3, SA2 sa2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c21753u45, "$tmp0_rcvr");
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(str2, "$description");
        AbstractC13042fc3.i(str3, "$positiveTitle");
        AbstractC13042fc3.i(sa2, "$onAccept");
        c21753u45.L(str, i, str2, str3, sa2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private final void N(Context context, InterfaceC18633oz3 interfaceC18633oz3, int i, int i2, int i3, int i4, Integer num, SA2 sa2, SA2 sa22) {
        AbstractC21375tZ.c(context, interfaceC18633oz3, null, AbstractC19242q11.c(-1094474370, true, new h(num, i2, i, i3, i4, sa2, sa22)), 4, null).show();
    }

    static /* synthetic */ void O(C21753u45 c21753u45, Context context, InterfaceC18633oz3 interfaceC18633oz3, int i, int i2, int i3, int i4, Integer num, SA2 sa2, SA2 sa22, int i5, Object obj) {
        c21753u45.N(context, interfaceC18633oz3, i, i2, i3, i4, (i5 & 64) != 0 ? null : num, sa2, (i5 & 256) != 0 ? new SA2() { // from class: ir.nasim.T35
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.P();
            }
        } : sa22);
    }

    public static /* synthetic */ void O0(C21753u45 c21753u45, Activity activity, int i, SA2 sa2, d[] dVarArr, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.W35
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.Y0();
                }
            };
        }
        c21753u45.J0(activity, i, sa2, dVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P() {
        return C19938rB7.a;
    }

    public static /* synthetic */ void P0(C21753u45 c21753u45, Activity activity, int i, Integer num, SA2 sa2, d[] dVarArr, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.L35
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.S0();
                }
            };
        }
        c21753u45.K0(activity, i, num2, sa2, dVarArr);
    }

    public static final boolean Q(Context context) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC4043Dl1.a(context, "android.permission.CALL_PHONE") == 0;
    }

    public static /* synthetic */ void Q0(C21753u45 c21753u45, Fragment fragment, int i, SA2 sa2, d[] dVarArr, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.n45
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.Z0();
                }
            };
        }
        c21753u45.M0(fragment, i, sa2, dVarArr);
    }

    public static /* synthetic */ void R0(C21753u45 c21753u45, Fragment fragment, int i, Integer num, SA2 sa2, SA2 sa22, d[] dVarArr, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.V35
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.U0();
                }
            };
        }
        SA2 sa23 = sa2;
        if ((i2 & 16) != 0) {
            sa22 = new SA2() { // from class: ir.nasim.X35
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.V0();
                }
            };
        }
        c21753u45.N0(fragment, i, num2, sa23, sa22, dVarArr);
    }

    public static final boolean S(Context context) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC4043Dl1.a(context, "android.permission.READ_CONTACTS") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T0(SA2 sa2, Activity activity, d[] dVarArr, int i) {
        AbstractC13042fc3.i(sa2, "$onRationaleAccept");
        AbstractC13042fc3.i(activity, "$activity");
        AbstractC13042fc3.i(dVarArr, "$permissions");
        sa2.invoke();
        ArrayList arrayList = new ArrayList(dVarArr.length);
        for (d dVar : dVarArr) {
            arrayList.add(dVar.q());
        }
        X5.w(activity, (String[]) arrayList.toArray(new String[0]), i);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U0() {
        return C19938rB7.a;
    }

    public static final boolean V(Context context) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC4043Dl1.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W0(SA2 sa2, Fragment fragment, d[] dVarArr, int i) {
        AbstractC13042fc3.i(sa2, "$onRationaleAccept");
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(dVarArr, "$permissions");
        sa2.invoke();
        ArrayList arrayList = new ArrayList(dVarArr.length);
        for (d dVar : dVarArr) {
            arrayList.add(dVar.q());
        }
        fragment.P7((String[]) arrayList.toArray(new String[0]), i);
        return C19938rB7.a;
    }

    public static final boolean X(Context context) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC4043Dl1.a(context, "android.permission.READ_PHONE_STATE") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X0(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "$fragment");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragment.S7().getPackageName(), null));
        fragment.n8(intent);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z0() {
        return C19938rB7.a;
    }

    public static /* synthetic */ void a0(C21753u45 c21753u45, Context context, SA2 sa2, int i, Object obj) {
        if ((i & 2) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.h45
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.b0();
                }
            };
        }
        c21753u45.Z(context, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c1() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d1() {
        return C19938rB7.a;
    }

    public static /* synthetic */ void g1(C21753u45 c21753u45, Activity activity, d dVar, Integer num, SA2 sa2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            sa2 = null;
        }
        c21753u45.f1(activity, dVar, num, sa2);
    }

    public static /* synthetic */ void h0(C21753u45 c21753u45, Activity activity, int i, d dVar, SA2 sa2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.a45
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.t0();
                }
            };
        }
        c21753u45.c0(activity, i, dVar, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h1(SA2 sa2, Activity activity) {
        AbstractC13042fc3.i(activity, "$activity");
        if (sa2 != null) {
            sa2.invoke();
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivity(intent);
        return C19938rB7.a;
    }

    public static /* synthetic */ void i0(C21753u45 c21753u45, Activity activity, int i, d dVar, Integer num, SA2 sa2, SA2 sa22, SA2 sa23, boolean z, int i2, Object obj) {
        c21753u45.d0(activity, i, dVar, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? new SA2() { // from class: ir.nasim.q45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.x0();
            }
        } : sa2, (i2 & 32) != 0 ? new SA2() { // from class: ir.nasim.r45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.y0();
            }
        } : sa22, (i2 & 64) != 0 ? new SA2() { // from class: ir.nasim.s45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.z0();
            }
        } : sa23, (i2 & 128) != 0 ? true : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i1(SA2 sa2) {
        if (sa2 != null) {
            sa2.invoke();
        }
        return C19938rB7.a;
    }

    public static /* synthetic */ void j0(C21753u45 c21753u45, Fragment fragment, int i, d dVar, SA2 sa2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.U35
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.w0();
                }
            };
        }
        c21753u45.e0(fragment, i, dVar, sa2);
    }

    public static /* synthetic */ void k0(C21753u45 c21753u45, Fragment fragment, int i, d dVar, Integer num, SA2 sa2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i2 & 16) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.p45
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.s0();
                }
            };
        }
        c21753u45.f0(fragment, i, dVar, num2, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m0(Activity activity, SA2 sa2) {
        AbstractC13042fc3.i(activity, "$activity");
        AbstractC13042fc3.i(sa2, "$sendToSetting");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivity(intent);
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q0(SA2 sa2, Fragment fragment, d dVar, int i) {
        AbstractC13042fc3.i(sa2, "$onRationaleAccept");
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(dVar, "$permission");
        sa2.invoke();
        fragment.P7(new String[]{dVar.q()}, i);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r0(Fragment fragment, SA2 sa2) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(sa2, "$sendToSetting");
        C21753u45 c21753u45 = a;
        Context contextS7 = fragment.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        c21753u45.Z(contextS7, sa2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u0(SA2 sa2, Fragment fragment, d dVar, int i) {
        AbstractC13042fc3.i(sa2, "$onRationaleAccept");
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(dVar, "$permission");
        sa2.invoke();
        fragment.P7(new String[]{dVar.q()}, i);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v0(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "$fragment");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragment.S7().getPackageName(), null));
        fragment.n8(intent);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z0() {
        return C19938rB7.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B0(final Activity activity, d dVar, Integer num, final SA2 sa2, SA2 sa22, final SA2 sa23, boolean z) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(dVar, "permission");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        AbstractC13042fc3.i(sa22, "onReject");
        AbstractC13042fc3.i(sa23, "sendToSetting");
        if (X5.z(activity, dVar.q())) {
            N(activity, (InterfaceC18633oz3) activity, dVar.p(), z ? dVar.r() : AbstractC12217eE5.empty_text, num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_go_to_settings, null, new SA2() { // from class: ir.nasim.l45
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.G0(activity, sa23);
                }
            }, sa22);
            return;
        }
        N(activity, (InterfaceC18633oz3) activity, dVar.p(), z ? dVar.r() : AbstractC12217eE5.empty_text, num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_ok, Integer.valueOf(AbstractC12217eE5.permission_deny), new SA2() { // from class: ir.nasim.k45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.F0(sa2);
            }
        }, sa22);
    }

    public final void H0(Activity activity, int i, d dVar, SA2 sa2) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(dVar, "permission");
        AbstractC13042fc3.i(sa2, "sendToSetting");
        if (!X5.z(activity, dVar.q())) {
            X5.w(activity, new String[]{dVar.q()}, i);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivity(intent);
        sa2.invoke();
    }

    public final void I0(Fragment fragment, int i, d dVar, SA2 sa2) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(dVar, "permission");
        AbstractC13042fc3.i(sa2, "sendToSetting");
        if (!X5.z(fragment.Q7(), dVar.q())) {
            fragment.P7(new String[]{dVar.q()}, i);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragment.S7().getPackageName(), null));
        FragmentActivity fragmentActivityA5 = fragment.A5();
        if (fragmentActivityA5 != null) {
            fragmentActivityA5.startActivity(intent);
        }
        sa2.invoke();
    }

    public final void J(final String str, final int i, final String str2, final String str3, final SA2 sa2, final String str4, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(str3, "positiveTitle");
        AbstractC13042fc3.i(sa2, "onAccept");
        AbstractC13042fc3.i(str4, "negativeTitle");
        AbstractC13042fc3.i(sa22, "onReject");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1213382728);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(str3) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= interfaceC22053ub1J.V(str4) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 1048576 : 524288;
        }
        if ((599187 & i3) == 599186 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC19555qZ.F(AbstractC19242q11.e(-1272945828, true, new a(str, i), interfaceC22053ub1J, 54), AbstractC10289bP1.b.C0905b.b, AbstractC19242q11.e(-800606182, true, new b(str2), interfaceC22053ub1J, 54), AbstractC10289bP1.a.c.a, InterfaceC19114po0.b.a.a, sa2, str3, InterfaceC19114po0.b.C1454b.a, sa22, str4, null, interfaceC22053ub12, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | ((i3 << 3) & 458752) | ((i3 << 9) & 3670016) | (InterfaceC19114po0.b.C1454b.b << 21) | (234881024 & (i3 << 6)) | ((i3 << 12) & 1879048192), 0, 1024);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.m45
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C21753u45.K(this.a, str, i, str2, str3, sa2, str4, sa22, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void J0(Activity activity, int i, SA2 sa2, d... dVarArr) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        AbstractC13042fc3.i(dVarArr, "permissions");
        K0(activity, i, null, sa2, (d[]) Arrays.copyOf(dVarArr, dVarArr.length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K0(final Activity activity, final int i, Integer num, final SA2 sa2, final d... dVarArr) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        AbstractC13042fc3.i(dVarArr, "permissions");
        d dVar = (d) AbstractC10242bK.b0(dVarArr);
        for (d dVar2 : dVarArr) {
            if (X5.z(activity, dVar2.q())) {
                g1(this, activity, dVar, num, null, 8, null);
                return;
            }
        }
        O(this, activity, (InterfaceC18633oz3) activity, dVar.p(), dVar.r(), num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_ok, Integer.valueOf(AbstractC12217eE5.permission_deny), new SA2() { // from class: ir.nasim.o45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.T0(sa2, activity, dVarArr, i);
            }
        }, null, 256, null);
    }

    public final void L(final String str, final int i, final String str2, final String str3, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(str3, "positiveTitle");
        AbstractC13042fc3.i(sa2, "onAccept");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(596802934);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(str3) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 16384 : 8192;
        }
        if ((i3 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC19555qZ.T(AbstractC19242q11.e(-1795547899, true, new e(str, i), interfaceC22053ub1J, 54), !AbstractC20762sZ6.n0(str) ? AbstractC10289bP1.b.C0905b.b : AbstractC10289bP1.b.a.b, AbstractC19242q11.e(1094227719, true, new f(str2), interfaceC22053ub1J, 54), AbstractC10289bP1.a.c.a, null, InterfaceC19114po0.b.C1454b.a, sa2, str3, interfaceC22053ub1J, (AbstractC10289bP1.b.a << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.C1454b.b << 15) | (3670016 & (i3 << 6)) | ((i3 << 12) & 29360128), 16);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.g45
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C21753u45.M(this.a, str, i, str2, str3, sa2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void L0(Activity activity, int i, d... dVarArr) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(dVarArr, "permissions");
        P0(this, activity, i, null, null, dVarArr, 12, null);
    }

    public final void M0(Fragment fragment, int i, SA2 sa2, d... dVarArr) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        AbstractC13042fc3.i(dVarArr, "permissions");
        R0(this, fragment, i, null, sa2, null, (d[]) Arrays.copyOf(dVarArr, dVarArr.length), 16, null);
    }

    public final void N0(final Fragment fragment, final int i, Integer num, final SA2 sa2, SA2 sa22, final d... dVarArr) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        AbstractC13042fc3.i(sa22, "onReject");
        AbstractC13042fc3.i(dVarArr, "permissions");
        d dVar = (d) AbstractC10242bK.b0(dVarArr);
        for (d dVar2 : dVarArr) {
            if (X5.z(fragment.Q7(), dVar2.q())) {
                Context contextS7 = fragment.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                N(contextS7, fragment, dVar.p(), dVar.r(), num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_go_to_settings, null, new SA2() { // from class: ir.nasim.M35
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C21753u45.X0(fragment);
                    }
                }, sa22);
                return;
            }
        }
        Context contextS72 = fragment.S7();
        AbstractC13042fc3.h(contextS72, "requireContext(...)");
        N(contextS72, fragment, dVar.p(), dVar.r(), num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_ok, Integer.valueOf(AbstractC12217eE5.permission_deny), new SA2() { // from class: ir.nasim.t45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.W0(sa2, fragment, dVarArr, i);
            }
        }, sa22);
    }

    public final boolean R(Context context) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC4043Dl1.a(context, "android.permission.CAMERA") == 0;
    }

    public final boolean T() {
        return C5721Ko.a.d().checkSelfPermission("android.permission.READ_CONTACTS") == 0;
    }

    public final boolean U(Context context) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC4043Dl1.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public final boolean W(Context context, String[] strArr) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(strArr, "manifestName");
        for (String str : strArr) {
            if (AbstractC4043Dl1.a(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean Y(Activity activity, d dVar) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(dVar, "permission");
        return X5.z(activity, dVar.q());
    }

    public final void Z(Context context, SA2 sa2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(sa2, "sendToSetting");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        context.startActivity(intent);
        sa2.invoke();
    }

    public final void a1(Fragment fragment, int i, c cVar, Integer num, SA2 sa2, SA2 sa22, d... dVarArr) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(cVar, "permissionCountPreference");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        AbstractC13042fc3.i(sa22, "onReject");
        AbstractC13042fc3.i(dVarArr, "permissions");
        int i2 = C7183Qq.s().getInt(cVar.p(), 0);
        if (i2 < cVar.j()) {
            N0(fragment, i, num, sa2, sa22, (d[]) Arrays.copyOf(dVarArr, dVarArr.length));
            C7183Qq.s().putInt(cVar.p(), i2 + 1);
        }
    }

    public final void c0(Activity activity, int i, d dVar, SA2 sa2) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(dVar, "permission");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        i0(this, activity, i, dVar, null, sa2, null, null, false, 224, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d0(final Activity activity, final int i, final d dVar, Integer num, final SA2 sa2, SA2 sa22, final SA2 sa23, boolean z) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(dVar, "permission");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        AbstractC13042fc3.i(sa22, "onReject");
        AbstractC13042fc3.i(sa23, "sendToSetting");
        if (X5.z(activity, dVar.q())) {
            N(activity, (InterfaceC18633oz3) activity, dVar.p(), z ? dVar.r() : AbstractC12217eE5.empty_text, num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_go_to_settings, null, new SA2() { // from class: ir.nasim.O35
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.m0(activity, sa23);
                }
            }, sa22);
            return;
        }
        N(activity, (InterfaceC18633oz3) activity, dVar.p(), z ? dVar.r() : AbstractC12217eE5.empty_text, num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_ok, Integer.valueOf(AbstractC12217eE5.permission_deny), new SA2() { // from class: ir.nasim.N35
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.A0(sa2, activity, dVar, i);
            }
        }, sa22);
    }

    public final void e0(Fragment fragment, int i, d dVar, SA2 sa2) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(dVar, "permission");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        f0(fragment, i, dVar, null, sa2);
    }

    public final boolean e1(Activity activity, String[] strArr) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(strArr, "manifestName");
        for (String str : strArr) {
            if (AbstractC4043Dl1.a(activity, str) != 0 && X5.z(activity, str)) {
                return true;
            }
        }
        return false;
    }

    public final void f0(final Fragment fragment, final int i, final d dVar, Integer num, final SA2 sa2) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(dVar, "permission");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        if (X5.z(fragment.Q7(), dVar.q())) {
            Context contextS7 = fragment.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            O(this, contextS7, fragment, dVar.p(), dVar.r(), num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_go_to_settings, null, new SA2() { // from class: ir.nasim.Q35
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.v0(fragment);
                }
            }, null, 256, null);
        } else {
            Context contextS72 = fragment.S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            O(this, contextS72, fragment, dVar.p(), dVar.r(), num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_ok, Integer.valueOf(AbstractC12217eE5.permission_deny), new SA2() { // from class: ir.nasim.P35
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.u0(sa2, fragment, dVar, i);
                }
            }, null, 256, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f1(final Activity activity, d dVar, Integer num, final SA2 sa2) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(dVar, "permission");
        N(activity, (InterfaceC18633oz3) activity, dVar.p(), dVar.r(), num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_go_to_settings, null, new SA2() { // from class: ir.nasim.R35
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.h1(sa2, activity);
            }
        }, new SA2() { // from class: ir.nasim.S35
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.i1(sa2);
            }
        });
    }

    public final void g0(final Fragment fragment, final int i, final d dVar, Integer num, final SA2 sa2, SA2 sa22, final SA2 sa23, boolean z) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(dVar, "permission");
        AbstractC13042fc3.i(sa2, "onRationaleAccept");
        AbstractC13042fc3.i(sa22, "onReject");
        AbstractC13042fc3.i(sa23, "sendToSetting");
        if (X5.z(fragment.Q7(), dVar.q())) {
            Context contextS7 = fragment.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            N(contextS7, fragment, dVar.p(), z ? dVar.r() : AbstractC12217eE5.empty_text, num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_go_to_settings, null, new SA2() { // from class: ir.nasim.j45
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21753u45.r0(fragment, sa23);
                }
            }, sa22);
            return;
        }
        Context contextS72 = fragment.S7();
        AbstractC13042fc3.h(contextS72, "requireContext(...)");
        N(contextS72, fragment, dVar.p(), z ? dVar.r() : AbstractC12217eE5.empty_text, num != null ? num.intValue() : dVar.j(), AbstractC12217eE5.permission_ok, Integer.valueOf(AbstractC12217eE5.permission_deny), new SA2() { // from class: ir.nasim.i45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.q0(sa2, fragment, dVar, i);
            }
        }, sa22);
    }
}
