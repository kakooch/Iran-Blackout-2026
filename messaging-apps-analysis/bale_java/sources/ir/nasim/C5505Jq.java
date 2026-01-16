package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.Fragment;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C5505Jq;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.Jq, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5505Jq {
    public static final C5505Jq a = new C5505Jq();

    /* renamed from: ir.nasim.Jq$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ DialogInterface.OnCancelListener e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        /* renamed from: ir.nasim.Jq$a$a, reason: collision with other inner class name */
        static final class C0451a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;
            final /* synthetic */ int b;

            C0451a(int i, int i2) {
                this.a = i;
                this.b = i2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.v0(UY6.c(this.a, interfaceC22053ub1, 0), null, FV4.c(this.b, interfaceC22053ub1, 0), null, C24381yX0.b.i(), interfaceC22053ub1, 27648, 2);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Jq$a$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(UY6.c(this.a, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(int i, int i2, UA2 ua2, UA2 ua22, DialogInterface.OnCancelListener onCancelListener, int i3, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = ua2;
            this.d = ua22;
            this.e = onCancelListener;
            this.f = i3;
            this.g = i4;
            this.h = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(UA2 ua2, Dialog dialog) {
            AbstractC13042fc3.i(ua2, "$positiveCallback");
            AbstractC13042fc3.i(dialog, "$dialog");
            ua2.invoke(dialog);
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(UA2 ua2, Dialog dialog) {
            AbstractC13042fc3.i(ua2, "$negativeCallback");
            AbstractC13042fc3.i(dialog, "$dialog");
            ua2.invoke(dialog);
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            String strC = UY6.c(this.a, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(this.b, interfaceC22053ub1, 0);
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1050416205, true, new C0451a(this.f, this.g), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1037159733, true, new b(this.h), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-13644793);
            boolean zV = interfaceC22053ub1.V(this.c) | interfaceC22053ub1.D(dialog);
            final UA2 ua2 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Hq
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C5505Jq.a.d(ua2, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-13635897);
            boolean zV2 = interfaceC22053ub1.V(this.d) | interfaceC22053ub1.D(dialog);
            final UA2 ua22 = this.d;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Iq
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C5505Jq.a.f(ua22, dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC18060o11E, c0905b, interfaceC18060o11E2, cVar, aVar, sa2, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
            dialog.setOnCancelListener(this.e);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    private C5505Jq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(Fragment fragment, int i, UA2 ua2, Dialog dialog) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(dialog, "it");
        C7183Qq.s().g("read_phone_state_asked", true);
        fragment.P7(new String[]{"android.permission.READ_PHONE_STATE"}, i);
        if (ua2 != null) {
            ua2.invoke(EnumC23179wU5.a);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(UA2 ua2, Dialog dialog) {
        AbstractC13042fc3.i(dialog, "it");
        if (ua2 != null) {
            ua2.invoke(EnumC23179wU5.c);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(Fragment fragment, UA2 ua2, Dialog dialog) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(dialog, "it");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragment.Q7().getPackageName(), null));
        fragment.Q7().startActivity(intent);
        if (ua2 != null) {
            ua2.invoke(EnumC23179wU5.b);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(UA2 ua2, Dialog dialog) {
        AbstractC13042fc3.i(dialog, "it");
        if (ua2 != null) {
            ua2.invoke(EnumC23179wU5.c);
        }
        return C19938rB7.a;
    }

    public static final boolean E() {
        return AbstractC4043Dl1.a(C5721Ko.a.d(), "android.permission.CAMERA") == 0;
    }

    public static final boolean F() {
        return AbstractC4043Dl1.a(C5721Ko.a.d(), "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public static final boolean G() {
        return AbstractC4043Dl1.a(C5721Ko.a.d(), "android.permission.RECORD_AUDIO") == 0;
    }

    public static final boolean H() {
        return Build.VERSION.SDK_INT < 31 || AbstractC4043Dl1.a(C5721Ko.a.d(), "android.permission.READ_PHONE_STATE") == 0;
    }

    public static final void I(String str) {
        AbstractC13042fc3.i(str, "permission");
        C7183Qq.s().putInt("count_asked_" + str, n(str) + 1);
    }

    public static final void J(Fragment fragment, int i, UA2 ua2) {
        AbstractC13042fc3.i(fragment, "fragment");
        if (!E()) {
            a.o(fragment, i, ua2);
        } else if (ua2 != null) {
            ua2.invoke(EnumC23179wU5.d);
        }
    }

    public static final void K(Fragment fragment, int i, UA2 ua2) {
        AbstractC13042fc3.i(fragment, "fragment");
        if (!G()) {
            a.t(fragment, i, ua2);
        } else if (ua2 != null) {
            ua2.invoke(EnumC23179wU5.d);
        }
    }

    public static final void L(Fragment fragment, int i, UA2 ua2) {
        AbstractC13042fc3.i(fragment, "fragment");
        if (!H()) {
            a.y(fragment, i, ua2);
        } else if (ua2 != null) {
            ua2.invoke(EnumC23179wU5.d);
        }
    }

    public static final void M(String str, boolean z) {
        AbstractC13042fc3.i(str, "permission");
        C7183Qq.p().g("should_ask_" + str, z);
    }

    private final void N(Fragment fragment, int i, int i2, int i3, UA2 ua2, int i4, UA2 ua22, int i5, DialogInterface.OnCancelListener onCancelListener) {
        Context contextS7 = fragment.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AbstractC21375tZ.c(contextS7, fragment, null, AbstractC19242q11.c(1164378071, true, new a(i4, i5, ua2, ua22, onCancelListener, i2, i, i3)), 4, null).show();
    }

    static /* synthetic */ void O(C5505Jq c5505Jq, Fragment fragment, int i, int i2, int i3, UA2 ua2, int i4, UA2 ua22, int i5, DialogInterface.OnCancelListener onCancelListener, int i6, Object obj) {
        c5505Jq.N(fragment, i, i2, i3, ua2, i4, ua22, i5, (i6 & 256) != 0 ? null : onCancelListener);
    }

    private static final int n(String str) {
        return C7183Qq.s().getInt("count_asked_" + str, 0);
    }

    private final void o(final Fragment fragment, final int i, final UA2 ua2) {
        if (X5.z(fragment.Q7(), "android.permission.CAMERA") || !C7183Qq.s().h("is_camera_permission_asked", false)) {
            O(this, fragment, KB5.camera, AbstractC12217eE5.camera_permission_title, AbstractC12217eE5.video_call_permission_desctiption, new UA2() { // from class: ir.nasim.Bq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.p(fragment, i, ua2, (Dialog) obj);
                }
            }, AbstractC12217eE5.permission_ok, new UA2() { // from class: ir.nasim.Cq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.q((Dialog) obj);
                }
            }, AbstractC12217eE5.permission_deny, null, 256, null);
        } else {
            O(this, fragment, KB5.bold_camera, AbstractC12217eE5.camera_permission_title, AbstractC12217eE5.video_call_permission_desctiption, new UA2() { // from class: ir.nasim.Dq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.r(fragment, ua2, (Dialog) obj);
                }
            }, AbstractC12217eE5.permission_go_to_settings, new UA2() { // from class: ir.nasim.Eq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.s((Dialog) obj);
                }
            }, AbstractC12217eE5.permission_deny, null, 256, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(Fragment fragment, int i, UA2 ua2, Dialog dialog) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(dialog, "it");
        C7183Qq.s().g("is_camera_permission_asked", true);
        fragment.P7(new String[]{"android.permission.CAMERA"}, i);
        if (ua2 != null) {
            ua2.invoke(EnumC23179wU5.a);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(Dialog dialog) {
        AbstractC13042fc3.i(dialog, "it");
        dialog.dismiss();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(Fragment fragment, UA2 ua2, Dialog dialog) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(dialog, "it");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragment.Q7().getPackageName(), null));
        fragment.Q7().startActivity(intent);
        if (ua2 != null) {
            ua2.invoke(EnumC23179wU5.b);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(Dialog dialog) {
        AbstractC13042fc3.i(dialog, "it");
        dialog.dismiss();
        return C19938rB7.a;
    }

    private final void t(final Fragment fragment, final int i, UA2 ua2) {
        if (X5.z(fragment.Q7(), "android.permission.RECORD_AUDIO") || !C7183Qq.s().h("is_voice_permission_asked", false)) {
            O(this, fragment, KB5.ic_microphone, AbstractC12217eE5.voice_permission_title, AbstractC12217eE5.voice_call_permission_desctiption, new UA2() { // from class: ir.nasim.uq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.u(fragment, i, (Dialog) obj);
                }
            }, AbstractC12217eE5.permission_ok, new UA2() { // from class: ir.nasim.yq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.v((Dialog) obj);
                }
            }, AbstractC12217eE5.permission_deny, null, 256, null);
        } else {
            O(this, fragment, KB5.ic_microphone, AbstractC12217eE5.voice_permission_title, AbstractC12217eE5.voice_call_permission_desctiption, new UA2() { // from class: ir.nasim.zq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.w(fragment, (Dialog) obj);
                }
            }, AbstractC12217eE5.permission_go_to_settings, new UA2() { // from class: ir.nasim.Aq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.x((Dialog) obj);
                }
            }, AbstractC12217eE5.permission_deny, null, 256, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(Fragment fragment, int i, Dialog dialog) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(dialog, "it");
        C7183Qq.s().g("is_voice_permission_asked", true);
        fragment.P7(new String[]{"android.permission.RECORD_AUDIO", "android.permission.VIBRATE"}, i);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(Dialog dialog) {
        AbstractC13042fc3.i(dialog, "it");
        dialog.dismiss();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(Fragment fragment, Dialog dialog) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(dialog, "it");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragment.Q7().getPackageName(), null));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(Dialog dialog) {
        AbstractC13042fc3.i(dialog, "it");
        dialog.dismiss();
        return C19938rB7.a;
    }

    private final void y(final Fragment fragment, final int i, final UA2 ua2) {
        if (X5.z(fragment.Q7(), "android.permission.READ_PHONE_STATE") || !C7183Qq.s().h("read_phone_state_asked", false)) {
            O(this, fragment, KB5.permission_read_phone_state, AbstractC12217eE5.call_phone_state_permission_title, AbstractC12217eE5.call_phone_state_permission_description, new UA2() { // from class: ir.nasim.Fq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.A(fragment, i, ua2, (Dialog) obj);
                }
            }, AbstractC12217eE5.permission_ok, new UA2() { // from class: ir.nasim.Gq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.B(ua2, (Dialog) obj);
                }
            }, AbstractC12217eE5.permission_deny, null, 256, null);
        } else {
            N(fragment, KB5.permission_read_phone_state, AbstractC12217eE5.call_phone_state_permission_title, AbstractC12217eE5.call_phone_state_permission_description, new UA2() { // from class: ir.nasim.vq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.C(fragment, ua2, (Dialog) obj);
                }
            }, AbstractC12217eE5.permission_go_to_settings, new UA2() { // from class: ir.nasim.wq
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5505Jq.D(ua2, (Dialog) obj);
                }
            }, AbstractC12217eE5.permission_deny, new DialogInterface.OnCancelListener() { // from class: ir.nasim.xq
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    C5505Jq.z(ua2, dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(UA2 ua2, DialogInterface dialogInterface) {
        if (ua2 != null) {
            ua2.invoke(EnumC23179wU5.c);
        }
    }
}
