package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.net.Uri;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C24398yZ;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;

/* renamed from: ir.nasim.yZ, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24398yZ {
    public static final C24398yZ a = new C24398yZ();

    /* renamed from: ir.nasim.yZ$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* renamed from: ir.nasim.yZ$a$a, reason: collision with other inner class name */
        static final class C1790a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            C1790a(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.z0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.yZ$a$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.c0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, int i, int i2) {
            this.a = sa2;
            this.b = i;
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, SA2 sa2) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(sa2, "$openCall");
            dialog.dismiss();
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1871520120, true, new C1790a(this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-1974816314, true, new b(this.c), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(-1418068032);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.wZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.a.d(dialog, sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.dialog_confirm;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-1418060227);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.xZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.a.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, sa22, i2, c1454b, (SA2) objB2, AbstractC12217eE5.dialog_cancel, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yZ$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ Activity a;

        b(Activity activity) {
            this.a = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Activity activity, Dialog dialog) {
            AbstractC13042fc3.i(activity, "$activity");
            AbstractC13042fc3.i(dialog, "$dialog");
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + activity.getApplicationContext().getPackageName()));
                activity.startActivity(intent);
            } catch (Exception e) {
                C19406qI3.a("BaleDialogsCreator", e.getMessage(), new Object[0]);
            }
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            String strC = UY6.c(AbstractC12217eE5.background_restriction_open_settings, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(AbstractC12217eE5.background_restriction_not_now, interfaceC22053ub1, 0);
            C14508i21 c14508i21 = C14508i21.a;
            InterfaceC14603iB2 interfaceC14603iB2D = c14508i21.d();
            InterfaceC14603iB2 interfaceC14603iB2E = c14508i21.e();
            interfaceC22053ub1.W(-1994359496);
            boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(dialog);
            final Activity activity = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.zZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.b.d(activity, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1994337666);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.AZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.b.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2D, c0905b, interfaceC14603iB2E, cVar, aVar, sa2, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yZ$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        /* renamed from: ir.nasim.yZ$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (!AbstractC20762sZ6.n0(this.a)) {
                    interfaceC22053ub1.W(1972158531);
                    AbstractC19555qZ.v0(this.a, null, FV4.c(KB5.alert, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).p(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(1971807735);
                    AbstractC24667z03.b(FV4.c(KB5.alert, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.m(androidx.compose.ui.e.a, C17784nZ1.q(56.0f)), G10.a.a(interfaceC22053ub1, G10.b).p(), interfaceC22053ub1, 432, 0);
                    interfaceC22053ub1.Q();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.yZ$c$b */
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

        c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-2047387780, true, new a(this.a), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-1363427074, true, new b(this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(1020391012);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.BZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.c.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, c1454b, (SA2) objB, UY6.c(AbstractC12217eE5.understand, interfaceC22053ub1, 0), interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 15) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 16);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yZ$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ String b;

        /* renamed from: ir.nasim.yZ$d$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            a(String str) {
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

        d(SA2 sa2, String str) {
            this.a = sa2;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, SA2 sa2) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(sa2, "$onOkButtonClicked");
            dialog.dismiss();
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(SA2 sa2, DialogInterface dialogInterface) {
            AbstractC13042fc3.i(sa2, "$onOkButtonClicked");
            sa2.invoke();
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC14603iB2 interfaceC14603iB2I = C14508i21.a.i();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1849985901, true, new a(this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(1020475820);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.CZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.d.d(dialog, sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC14603iB2I, cVar, interfaceC18060o11E, cVar2, null, c1454b, (SA2) objB, UY6.c(AbstractC12217eE5.understand, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.C1454b.b << 15), 16);
            interfaceC22053ub1.W(1020482631);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa22 = this.a;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new DialogInterface.OnDismissListener() { // from class: ir.nasim.DZ
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        C24398yZ.d.f(sa22, dialogInterface);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) objB2);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yZ$e */
    static final class e implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;

        e(SA2 sa2) {
            this.a = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2, Dialog dialog) {
            AbstractC13042fc3.i(sa2, "$onOkButtonClicked");
            AbstractC13042fc3.i(dialog, "$it");
            try {
                sa2.invoke();
            } catch (Exception e) {
                e.printStackTrace();
            }
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            C14508i21 c14508i21 = C14508i21.a;
            InterfaceC14603iB2 interfaceC14603iB2J = c14508i21.j();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c14508i21.b();
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(-2141275652);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(dialog);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.EZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.e.d(sa2, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.call_full_screen_intent_permission_dialog_action;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-2141261892);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.FZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.e.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2J, c0905b, interfaceC14603iB2B, cVar, aVar, sa22, i2, c1454b, (SA2) objB2, AbstractC12217eE5.dialog_negative_button_cancel, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
            dialog.setCanceledOnTouchOutside(true);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yZ$f */
    static final class f implements InterfaceC15796kB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ Context c;
        final /* synthetic */ int d;

        /* renamed from: ir.nasim.yZ$f$a */
        /* synthetic */ class a extends EB2 implements SA2 {
            a(Object obj) {
                super(0, obj, Dialog.class, "dismiss", "dismiss()V", 0);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                y();
                return C19938rB7.a;
            }

            public final void y() {
                ((Dialog) this.receiver).dismiss();
            }
        }

        /* renamed from: ir.nasim.yZ$f$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ Context a;
            final /* synthetic */ int b;

            b(Context context, int i) {
                this.a = context;
                this.b = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                Context context = this.a;
                String string = context.getString(AbstractC12217eE5.report_details_dialog_title, context.getString(this.b));
                AbstractC13042fc3.h(string, "getString(...)");
                AbstractC19555qZ.v0(string, null, FV4.c(KB5.alert, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).p(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.yZ$f$c */
        static final class c implements InterfaceC14603iB2 {
            final /* synthetic */ Context a;
            final /* synthetic */ InterfaceC9102Ym4 b;

            c(Context context, InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = context;
                this.b = interfaceC9102Ym4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$inputText$delegate");
                AbstractC13042fc3.i(str, "it");
                f.h(interfaceC9102Ym4, str);
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String string = this.a.getString(AbstractC12217eE5.report_details_dialog_description);
                AbstractC13042fc3.h(string, "getString(...)");
                String strF = f.f(this.b);
                interfaceC22053ub1.W(-1953293316);
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.b;
                Object objB = interfaceC22053ub1.B();
                if (objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.HZ
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C24398yZ.f.c.c(interfaceC9102Ym4, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                String string2 = this.a.getString(AbstractC12217eE5.report_details_dialog_inputbar_label);
                AbstractC13042fc3.h(string2, "getString(...)");
                String string3 = this.a.getString(AbstractC12217eE5.report_details_dialog_inputbar_hint);
                AbstractC13042fc3.h(string3, "getString(...)");
                AbstractC19555qZ.i0(string, strF, (UA2) objB, string2, string3, 255, interfaceC22053ub1, 196992, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        f(boolean z, UA2 ua2, Context context, int i) {
            this.a = z;
            this.b = ua2;
            this.c = context;
            this.d = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (String) interfaceC9102Ym4.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            interfaceC9102Ym4.setValue(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(UA2 ua2, Dialog dialog, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(ua2, "$onPositiveButtonClicked");
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$inputText$delegate");
            ua2.invoke(AbstractC20762sZ6.n1(f(interfaceC9102Ym4)).toString());
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void d(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            interfaceC22053ub1.W(-897199962);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d("", null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            InterfaceC19114po0 interfaceC19114po0 = (!AbstractC20762sZ6.n0(f(interfaceC9102Ym4)) || this.a) ? InterfaceC19114po0.b.a.a : InterfaceC19114po0.a.C1453a.a;
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            int i2 = AbstractC12217eE5.report_details_dialog_positive_button;
            int i3 = AbstractC12217eE5.dialog_negative_button_cancel;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-897155078);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == aVar.a()) {
                objB2 = new a(dialog);
                interfaceC22053ub1.s(objB2);
            }
            InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB2;
            interfaceC22053ub1.Q();
            AbstractC10289bP1.a.C0904a c0904a = AbstractC10289bP1.a.C0904a.a;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(303715057, true, new b(this.c, this.d), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1690031791, true, new c(this.c, interfaceC9102Ym4), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-897164383);
            boolean zV = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(dialog);
            final UA2 ua2 = this.b;
            Object objB3 = interfaceC22053ub1.B();
            if (zV || objB3 == aVar.a()) {
                objB3 = new SA2() { // from class: ir.nasim.GZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.f.i(ua2, dialog, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC18060o11E, c0905b, interfaceC18060o11E2, c0904a, interfaceC19114po0, (SA2) objB3, i2, c1454b, (SA2) interfaceC16733lm3, i3, null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.C0904a.b << 9) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yZ$g */
    static final class g implements InterfaceC15796kB2 {
        final /* synthetic */ Activity a;

        g(Activity activity) {
            this.a = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, Activity activity) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(activity, "$activity");
            dialog.dismiss();
            try {
                try {
                    activity.startActivity(C15456jc8.a.a());
                } catch (Exception unused) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + C5721Ko.a.d().getPackageName()));
                    activity.startActivity(intent);
                }
            } catch (Exception e) {
                C19406qI3.j("BaleDialogsCreator", "Error in createShowOnLockScreenDialog: " + e.getMessage(), new Object[0]);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            String strC = UY6.c(AbstractC12217eE5.background_restriction_open_settings, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(AbstractC12217eE5.background_restriction_not_now, interfaceC22053ub1, 0);
            C14508i21 c14508i21 = C14508i21.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c14508i21.a();
            InterfaceC14603iB2 interfaceC14603iB2C = c14508i21.c();
            interfaceC22053ub1.W(2099024660);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.a);
            final Activity activity = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.IZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.g.d(dialog, activity);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(2099055697);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.JZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.g.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2A, c0905b, interfaceC14603iB2C, cVar, aVar, sa2, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yZ$h */
    static final class h implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* renamed from: ir.nasim.yZ$h$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.v0(this.a, null, FV4.c(KB5.ic_success_dialog, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).I(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.yZ$h$b */
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

        h(SA2 sa2, String str, String str2) {
            this.a = sa2;
            this.b = str;
            this.c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(SA2 sa2, DialogInterface dialogInterface) {
            AbstractC13042fc3.i(sa2, "$onOkButtonClicked");
            sa2.invoke();
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-945841171, true, new a(this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-963128721, true, new b(this.c), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(1050098559);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.KZ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24398yZ.h.d(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, c1454b, (SA2) objB, UY6.c(AbstractC12217eE5.understand, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.C1454b.b << 15), 16);
            interfaceC22053ub1.W(1050104130);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new DialogInterface.OnDismissListener() { // from class: ir.nasim.LZ
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        C24398yZ.h.f(sa2, dialogInterface);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) objB2);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    private C24398yZ() {
    }

    public static final Dialog c(Context context, InterfaceC18633oz3 interfaceC18633oz3) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        return AbstractC21375tZ.c(context, interfaceC18633oz3, null, C14508i21.a.h(), 4, null);
    }

    public static final ML1 e(Context context, String str, List list, SA2 sa2) throws Resources.NotFoundException {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(list, "descriptionItems");
        AbstractC13042fc3.i(sa2, "onOkButtonClicked");
        String string = context.getResources().getString(AbstractC12217eE5.new_version_changes);
        AbstractC13042fc3.h(string, "getString(...)");
        return new ML1(context, str, list, string, sa2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC21375tZ.c(activity, (InterfaceC18633oz3) activity, null, AbstractC19242q11.c(1474029376, true, new b(activity)), 4, null).show();
    }

    public static final void g(Context context, InterfaceC18633oz3 interfaceC18633oz3, String str, SA2 sa2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(sa2, "onOkButtonClicked");
        AbstractC21375tZ.c(context, interfaceC18633oz3, null, AbstractC19242q11.c(-45857186, true, new d(sa2, str)), 4, null).show();
    }

    public static final void h(Context context, InterfaceC18633oz3 interfaceC18633oz3, String str, String str2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, ParameterNames.TEXT);
        AbstractC21375tZ.c(context, interfaceC18633oz3, null, AbstractC19242q11.c(329929645, true, new c(str, str2)), 4, null).show();
    }

    public static final void j(Context context, InterfaceC18633oz3 interfaceC18633oz3, int i, boolean z, final SA2 sa2, UA2 ua2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(ua2, "onPositiveButtonClicked");
        Dialog dialogC = AbstractC21375tZ.c(context, interfaceC18633oz3, null, AbstractC19242q11.c(-1688601267, true, new f(z, ua2, context, i)), 4, null);
        dialogC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.nasim.uZ
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                C24398yZ.l(sa2, dialogInterface);
            }
        });
        dialogC.setCancelable(true);
        dialogC.show();
    }

    public static /* synthetic */ void k(Context context, InterfaceC18633oz3 interfaceC18633oz3, int i, boolean z, SA2 sa2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            sa2 = null;
        }
        j(context, interfaceC18633oz3, i, z2, sa2, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SA2 sa2, DialogInterface dialogInterface) {
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC21375tZ.c(activity, (InterfaceC18633oz3) activity, null, AbstractC19242q11.c(-478941137, true, new g(activity)), 4, null).show();
    }

    public static final void n(Context context, InterfaceC18633oz3 interfaceC18633oz3, String str, String str2, SA2 sa2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(sa2, "onOkButtonClicked");
        AbstractC21375tZ.c(context, interfaceC18633oz3, null, AbstractC19242q11.c(-70461794, true, new h(sa2, str, str2)), 4, null).show();
    }

    public static /* synthetic */ void o(Context context, InterfaceC18633oz3 interfaceC18633oz3, String str, String str2, SA2 sa2, int i, Object obj) {
        if ((i & 16) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.vZ
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24398yZ.p();
                }
            };
        }
        n(context, interfaceC18633oz3, str, str2, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p() {
        return C19938rB7.a;
    }

    public final void d(Context context, InterfaceC18633oz3 interfaceC18633oz3, int i, int i2, SA2 sa2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(sa2, "openCall");
        AbstractC21375tZ.c(context, interfaceC18633oz3, null, AbstractC19242q11.c(1640882148, true, new a(sa2, i, i2)), 4, null).show();
    }

    public final void i(Context context, InterfaceC18633oz3 interfaceC18633oz3, SA2 sa2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(sa2, "onOkButtonClicked");
        AbstractC21375tZ.c(context, interfaceC18633oz3, null, AbstractC19242q11.c(1756671807, true, new e(sa2)), 4, null).show();
    }
}
