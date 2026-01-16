package ir.nasim.features.map.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.layout.q;
import androidx.compose.foundation.layout.t;
import androidx.compose.ui.e;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.tasks.Task;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC12251eI3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15226jD5;
import ir.nasim.AbstractC17932no0;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC19954rD5;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.BC5;
import ir.nasim.C10282bO3;
import ir.nasim.C12860fI3;
import ir.nasim.C14819iX7;
import ir.nasim.C15153j6;
import ir.nasim.C18684p44;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C24725z61;
import ir.nasim.C5495Jo7;
import ir.nasim.G10;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC13497gK4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14681iJ4;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC24259yJ4;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB2;
import ir.nasim.KB5;
import ir.nasim.M10;
import ir.nasim.OD0;
import ir.nasim.PH3;
import ir.nasim.SA2;
import ir.nasim.TA5;
import ir.nasim.UA2;
import ir.nasim.UJ2;
import ir.nasim.UY6;
import ir.nasim.X5;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.features.map.ui.MapActivity;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001MB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u0013\u0010\t\u001a\u00020\u0005*\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010&\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0014¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0005H\u0014¢\u0006\u0004\b)\u0010\u0004J)\u0010-\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010+H\u0015¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u0019\u00105\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u000103H\u0014¢\u0006\u0004\b5\u00106R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00109\u001a\u0004\bD\u0010ER\u001d\u0010K\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u00109\u001a\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lir/nasim/features/map/ui/MapActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lir/nasim/yJ4;", "<init>", "()V", "Lir/nasim/rB7;", "L1", "o2", "Lir/nasim/components/appbar/view/BaleToolbar;", "k2", "(Lir/nasim/components/appbar/view/BaleToolbar;)V", "q2", "n2", "M1", "Lkotlin/Function0;", "block", "a2", "(Lir/nasim/SA2;)V", "", "b2", "()Z", "v2", "x2", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lir/nasim/UJ2;", "googleMap", "d", "(Lir/nasim/UJ2;)V", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/content/Context;", "base", "attachBaseContext", "(Landroid/content/Context;)V", "Lir/nasim/KB2;", "Z", "Lir/nasim/Yu3;", "T1", "()Lir/nasim/KB2;", "fusedLocationClient", "Lir/nasim/bO3;", "z0", "Y1", "()Lir/nasim/bO3;", "viewModel", "Lir/nasim/j6;", "A0", "S1", "()Lir/nasim/j6;", "binding", "Lcom/google/android/gms/maps/SupportMapFragment;", "B0", "W1", "()Lcom/google/android/gms/maps/SupportMapFragment;", "mapFragment", "C0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes3.dex */
public final class MapActivity extends Hilt_MapActivity implements InterfaceC24259yJ4 {
    public static final int D0 = 8;

    /* renamed from: Z, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 fusedLocationClient = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.BN3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return MapActivity.Q1(this.a);
        }
    });

    /* renamed from: z0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = new F(AbstractC10882cM5.b(C10282bO3.class), new j(this), new i(this), new k(null, this));

    /* renamed from: A0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 binding = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.CN3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return MapActivity.K1(this.a);
        }
    });

    /* renamed from: B0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 mapFragment = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.DN3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return MapActivity.d2(this.a);
        }
    });

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ MapActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MapActivity mapActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = mapActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c && this.d.b2()) {
                    this.d.S1().d.setImageDrawable(AbstractC4043Dl1.f(this.d, KB5.location_on));
                } else {
                    this.d.S1().d.setImageDrawable(AbstractC4043Dl1.f(this.d, KB5.location_off));
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MapActivity.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6X0 = MapActivity.this.Y1().X0();
                a aVar = new a(MapActivity.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6X0, aVar, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ Exception a;
        final /* synthetic */ MapActivity b;

        c(Exception exc, MapActivity mapActivity) {
            this.a = exc;
            this.b = mapActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, Exception exc, MapActivity mapActivity) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(exc, "$exception");
            AbstractC13042fc3.i(mapActivity, "this$0");
            dialog.dismiss();
            try {
                ((ResolvableApiException) exc).b(mapActivity, 102);
            } catch (IntentSender.SendIntentException unused) {
                C19406qI3.b("Map Activity", "Error startResolutionForResult For location");
            }
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
            C24725z61 c24725z61 = C24725z61.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c24725z61.a();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c24725z61.b();
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(962808436);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
            final Exception exc = this.a;
            final MapActivity mapActivity = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.map.ui.a
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return MapActivity.c.d(dialog, exc, mapActivity);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strC = UY6.c(AbstractC12217eE5.enable_log_dialog_positive_btn, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(962828175);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.features.map.ui.b
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return MapActivity.c.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2A, c0905b, interfaceC14603iB2B, cVar, aVar, sa2, strC, c1454b, (SA2) objB2, UY6.c(AbstractC12217eE5.dialog_enable_notification_negative_button, interfaceC22053ub1, 0), null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
            dialog.setCanceledOnTouchOutside(true);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC15796kB2 {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(MapActivity mapActivity, Dialog dialog) {
            AbstractC13042fc3.i(mapActivity, "this$0");
            AbstractC13042fc3.i(dialog, "$it");
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", mapActivity.getPackageName(), null));
            dialog.dismiss();
            mapActivity.startActivity(intent);
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
            C24725z61 c24725z61 = C24725z61.a;
            InterfaceC14603iB2 interfaceC14603iB2C = c24725z61.c();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2D = c24725z61.d();
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(400752724);
            boolean zD = interfaceC22053ub1.D(MapActivity.this) | interfaceC22053ub1.D(dialog);
            final MapActivity mapActivity = MapActivity.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.map.ui.c
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return MapActivity.d.d(mapActivity, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strC = UY6.c(AbstractC12217eE5.permission_go_to_settings, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(400777139);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.features.map.ui.d
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return MapActivity.d.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2C, c0905b, interfaceC14603iB2D, cVar, aVar, sa2, strC, c1454b, (SA2) objB2, UY6.c(AbstractC12217eE5.dialog_enable_notification_negative_button, interfaceC22053ub1, 0), null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
            dialog.setCanceledOnTouchOutside(true);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class e implements InterfaceC15796kB2 {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, MapActivity mapActivity) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(mapActivity, "this$0");
            dialog.dismiss();
            X5.w(mapActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 101);
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
            C24725z61 c24725z61 = C24725z61.a;
            InterfaceC14603iB2 interfaceC14603iB2E = c24725z61.e();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2F = c24725z61.f();
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(400816117);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(MapActivity.this);
            final MapActivity mapActivity = MapActivity.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.map.ui.e
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return MapActivity.e.d(dialog, mapActivity);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strC = UY6.c(AbstractC12217eE5.dialog_ok, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(400838067);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.features.map.ui.f
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return MapActivity.e.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2E, c0905b, interfaceC14603iB2F, cVar, aVar, sa2, strC, c1454b, (SA2) objB2, UY6.c(AbstractC12217eE5.dialog_enable_notification_negative_button, interfaceC22053ub1, 0), null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
            dialog.setCanceledOnTouchOutside(true);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UJ2 d;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ UJ2 a;

            a(UJ2 uj2) {
                this.a = uj2;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Number) obj).intValue(), interfaceC20295rm1);
            }

            public final Object b(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                if (i == 1) {
                    this.a.f(1);
                    this.a.h(false);
                } else if (i == 3) {
                    this.a.f(1);
                    this.a.h(true);
                } else if (i == 4) {
                    this.a.f(4);
                    this.a.h(false);
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(UJ2 uj2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = uj2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MapActivity.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6V0 = MapActivity.this.Y1().V0();
                a aVar = new a(this.d);
                this.b = 1;
                if (interfaceC10258bL6V0.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g implements InterfaceC14603iB2 {
        final /* synthetic */ UJ2 a;
        final /* synthetic */ MapActivity b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ UJ2 a;
            final /* synthetic */ MapActivity b;

            a(UJ2 uj2, MapActivity mapActivity) {
                this.a = uj2;
                this.b = mapActivity;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(UJ2 uj2, MapActivity mapActivity) {
                AbstractC13042fc3.i(uj2, "$googleMap");
                AbstractC13042fc3.i(mapActivity, "this$0");
                Intent intent = new Intent();
                intent.putExtra("latitude", uj2.b().a.a);
                intent.putExtra("longitude", uj2.b().a.b);
                intent.putExtra("locationType", 1);
                mapActivity.setResult(-1, intent);
                mapActivity.finish();
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                G10 g10 = G10.a;
                int i2 = G10.b;
                androidx.compose.ui.e eVarH = t.h(q.i(androidx.compose.foundation.b.d(aVar, g10.a(interfaceC22053ub1, i2).r(), null, 2, null), g10.c(interfaceC22053ub1, i2).b().c()), 0.0f, 1, null);
                interfaceC22053ub1.W(861327455);
                boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                final UJ2 uj2 = this.a;
                final MapActivity mapActivity = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.features.map.ui.g
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return MapActivity.g.a.c(uj2, mapActivity);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC17932no0.y(eVarH, (SA2) objB, InterfaceC19114po0.b.a.a, null, UY6.c(AbstractC12217eE5.send_location, interfaceC22053ub1, 0), null, interfaceC22053ub1, InterfaceC19114po0.b.a.b << 6, 40);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        g(UJ2 uj2, MapActivity mapActivity) {
            this.a = uj2;
            this.b = mapActivity;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-74306856, true, new a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UJ2 d;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ MapActivity a;
            final /* synthetic */ UJ2 b;

            a(MapActivity mapActivity, UJ2 uj2) {
                this.a = mapActivity;
                this.b = uj2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(UJ2 uj2, Location location) {
                AbstractC13042fc3.i(uj2, "$googleMap");
                if (location != null) {
                    uj2.a(OD0.a(new LatLng(location.getLatitude(), location.getLongitude()), 16.0f));
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void i(UA2 ua2, Object obj) {
                AbstractC13042fc3.i(ua2, "$tmp0");
                ua2.invoke(obj);
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return g(((Boolean) obj).booleanValue(), interfaceC20295rm1);
            }

            public final Object g(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                if (AbstractC4043Dl1.a(this.a, "android.permission.ACCESS_FINE_LOCATION") != 0 && AbstractC4043Dl1.a(this.a, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                    return C19938rB7.a;
                }
                Task taskG = this.a.T1().g();
                final UJ2 uj2 = this.b;
                final UA2 ua2 = new UA2() { // from class: ir.nasim.features.map.ui.h
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return MapActivity.h.a.h(uj2, (Location) obj);
                    }
                };
                taskG.f(new InterfaceC13497gK4() { // from class: ir.nasim.features.map.ui.i
                    @Override // ir.nasim.InterfaceC13497gK4
                    public final void onSuccess(Object obj) {
                        MapActivity.h.a.i(ua2, obj);
                    }
                });
                LatLng latLng = (LatLng) this.a.Y1().U0().getValue();
                if (latLng != null) {
                    this.b.a(OD0.a(latLng, 16.0f));
                }
                this.a.Y1().Z0(false);
                return C19938rB7.a;
            }
        }

        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.features.map.ui.MapActivity$h$b$a$a, reason: collision with other inner class name */
                public static final class C1175a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1175a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.features.map.ui.MapActivity.h.b.a.C1175a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.features.map.ui.MapActivity$h$b$a$a r0 = (ir.nasim.features.map.ui.MapActivity.h.b.a.C1175a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.features.map.ui.MapActivity$h$b$a$a r0 = new ir.nasim.features.map.ui.MapActivity$h$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L48
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        r2 = r5
                        java.lang.Boolean r2 = (java.lang.Boolean) r2
                        boolean r2 = r2.booleanValue()
                        if (r2 == 0) goto L48
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.map.ui.MapActivity.h.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(UJ2 uj2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = uj2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MapActivity.this.new h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(MapActivity.this.Y1().W0());
                a aVar = new a(MapActivity.this, this.d);
                this.b = 1;
                if (bVar.b(aVar, this) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.n3();
        }
    }

    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return this.e.d1();
        }
    }

    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ ComponentActivity f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SA2 sa2, ComponentActivity componentActivity) {
            super(0);
            this.e = sa2;
            this.f = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            return (sa2 == null || (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) == null) ? this.f.p3() : abstractC20375ru1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15153j6 K1(MapActivity mapActivity) {
        AbstractC13042fc3.i(mapActivity, "this$0");
        return C15153j6.c(mapActivity.getLayoutInflater());
    }

    private final void L1() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new b(null), 3, null);
    }

    private final void M1() {
        Task taskE = AbstractC12251eI3.b(this).e(new LocationSettingsRequest.a().a(AbstractC9766aX0.e(Y1().T0())).c(true).b());
        AbstractC13042fc3.h(taskE, "checkLocationSettings(...)");
        final UA2 ua2 = new UA2() { // from class: ir.nasim.GN3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return MapActivity.N1(this.a, (C12860fI3) obj);
            }
        };
        taskE.f(new InterfaceC13497gK4() { // from class: ir.nasim.HN3
            @Override // ir.nasim.InterfaceC13497gK4
            public final void onSuccess(Object obj) {
                MapActivity.O1(ua2, obj);
            }
        });
        taskE.d(new InterfaceC14681iJ4() { // from class: ir.nasim.wN3
            @Override // ir.nasim.InterfaceC14681iJ4
            public final void a(Exception exc) {
                MapActivity.P1(this.a, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N1(MapActivity mapActivity, C12860fI3 c12860fI3) {
        AbstractC13042fc3.i(mapActivity, "this$0");
        if (AbstractC4043Dl1.a(mapActivity, "android.permission.ACCESS_FINE_LOCATION") != 0 && AbstractC4043Dl1.a(mapActivity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return C19938rB7.a;
        }
        mapActivity.Y1().Z0(true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(UA2 ua2, Object obj) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(MapActivity mapActivity, Exception exc) {
        AbstractC13042fc3.i(mapActivity, "this$0");
        AbstractC13042fc3.i(exc, "exception");
        if (exc instanceof ResolvableApiException) {
            AbstractC21375tZ.c(mapActivity, mapActivity, null, AbstractC19242q11.c(1745459950, true, new c(exc, mapActivity)), 4, null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KB2 Q1(MapActivity mapActivity) {
        AbstractC13042fc3.i(mapActivity, "this$0");
        return AbstractC12251eI3.a(mapActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C15153j6 S1() {
        Object value = this.binding.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (C15153j6) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KB2 T1() {
        Object value = this.fusedLocationClient.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (KB2) value;
    }

    private final SupportMapFragment W1() {
        return (SupportMapFragment) this.mapFragment.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10282bO3 Y1() {
        return (C10282bO3) this.viewModel.getValue();
    }

    private final void a2(SA2 block) {
        if (AbstractC4043Dl1.a(this, "android.permission.ACCESS_COARSE_LOCATION") == 0 || AbstractC4043Dl1.a(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            block.invoke();
        } else if (X5.z(this, "android.permission.ACCESS_COARSE_LOCATION") || X5.z(this, "android.permission.ACCESS_FINE_LOCATION")) {
            AbstractC21375tZ.c(this, this, null, AbstractC19242q11.c(-2009999989, true, new d()), 4, null).show();
        } else {
            AbstractC21375tZ.c(this, this, null, AbstractC19242q11.c(385883156, true, new e()), 4, null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b2() {
        return AbstractC4043Dl1.a(this, "android.permission.ACCESS_COARSE_LOCATION") == 0 || AbstractC4043Dl1.a(this, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportMapFragment d2(MapActivity mapActivity) {
        AbstractC13042fc3.i(mapActivity, "this$0");
        Fragment fragmentO0 = mapActivity.B0().o0(BC5.map_view);
        if (fragmentO0 instanceof SupportMapFragment) {
            return (SupportMapFragment) fragmentO0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f2(MapActivity mapActivity) {
        AbstractC13042fc3.i(mapActivity, "this$0");
        mapActivity.M1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(final MapActivity mapActivity, View view) {
        AbstractC13042fc3.i(mapActivity, "this$0");
        mapActivity.a2(new SA2() { // from class: ir.nasim.FN3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return MapActivity.i2(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i2(MapActivity mapActivity) {
        AbstractC13042fc3.i(mapActivity, "this$0");
        mapActivity.M1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(UJ2 uj2) {
        AbstractC13042fc3.i(uj2, "it");
        uj2.g(true);
    }

    private final void k2(final BaleToolbar baleToolbar) {
        final ArrayList arrayList = new ArrayList();
        String string = getString(AbstractC12217eE5.normal_map);
        AbstractC13042fc3.h(string, "getString(...)");
        int i2 = ((Number) Y1().V0().getValue()).intValue() == 1 ? KB5.selected_map : 0;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        C18684p44 c18684p44 = new C18684p44(1, string, 0, c5495Jo7.d2(), 0, i2, 4, null);
        String string2 = getString(AbstractC12217eE5.traffic_map);
        AbstractC13042fc3.h(string2, "getString(...)");
        C18684p44 c18684p442 = new C18684p44(3, string2, 0, c5495Jo7.d2(), 0, ((Number) Y1().V0().getValue()).intValue() == 3 ? KB5.selected_map : 0, 4, null);
        String string3 = getString(AbstractC12217eE5.satellite_map);
        AbstractC13042fc3.h(string3, "getString(...)");
        C18684p44 c18684p443 = new C18684p44(4, string3, 0, c5495Jo7.d2(), 0, ((Number) Y1().V0().getValue()).intValue() == 4 ? KB5.selected_map : 0, 4, null);
        arrayList.add(c18684p44);
        arrayList.add(c18684p443);
        arrayList.add(c18684p442);
        baleToolbar.l0(BC5.more_item, arrayList, new AdapterView.OnItemClickListener() { // from class: ir.nasim.yN3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
                MapActivity.l2(arrayList, this, baleToolbar, adapterView, view, i3, j2);
            }
        });
        baleToolbar.getPopupWindow().setInputMethodMode(2);
        baleToolbar.getPopupWindow().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(ArrayList arrayList, MapActivity mapActivity, BaleToolbar baleToolbar, AdapterView adapterView, View view, int i2, long j2) {
        AbstractC13042fc3.i(arrayList, "$itemList");
        AbstractC13042fc3.i(mapActivity, "this$0");
        AbstractC13042fc3.i(baleToolbar, "$this_popUpWindow");
        Object obj = arrayList.get(i2);
        AbstractC13042fc3.h(obj, "get(...)");
        int iA = ((C18684p44) obj).a();
        if (iA == 1) {
            mapActivity.Y1().a1(1);
            try {
                baleToolbar.getPopupWindow().dismiss();
                return;
            } catch (Exception e2) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e2);
                return;
            }
        }
        if (iA == 3) {
            mapActivity.Y1().a1(3);
            try {
                baleToolbar.getPopupWindow().dismiss();
                return;
            } catch (Exception e3) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e3);
                return;
            }
        }
        if (iA != 4) {
            return;
        }
        mapActivity.Y1().a1(4);
        try {
            baleToolbar.getPopupWindow().dismiss();
        } catch (Exception e4) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e4);
        }
    }

    private final void n2() {
        Window window = getWindow();
        window.addFlags(RecyclerView.UNDEFINED_DURATION);
        window.clearFlags(67108864);
        if (C5495Jo7.a.J2()) {
            window.setStatusBarColor(AbstractC4043Dl1.c(this, TA5.app_bar_dark));
        } else {
            window.setStatusBarColor(AbstractC4043Dl1.c(this, TA5.app_bar_light));
        }
    }

    private final void o2() {
        final BaleToolbar baleToolbar = S1().f;
        BaleToolbar.setHasBackButton$default(baleToolbar, this, true, false, 4, null);
        baleToolbar.setTitle(getString(AbstractC12217eE5.media_location));
        baleToolbar.y(AbstractC15226jD5.more_menu);
        baleToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.xN3
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MapActivity.p2(this.a, baleToolbar, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p2(MapActivity mapActivity, BaleToolbar baleToolbar, MenuItem menuItem) {
        AbstractC13042fc3.i(mapActivity, "this$0");
        AbstractC13042fc3.i(baleToolbar, "$this_apply");
        if (menuItem.getItemId() != BC5.more_item) {
            return false;
        }
        mapActivity.k2(baleToolbar);
        return true;
    }

    private final void q2() {
        SupportMapFragment supportMapFragmentW1 = W1();
        if (supportMapFragmentW1 != null) {
            supportMapFragmentW1.r8(this);
        }
        SupportMapFragment supportMapFragmentW12 = W1();
        if (supportMapFragmentW12 != null) {
            supportMapFragmentW12.r8(new InterfaceC24259yJ4() { // from class: ir.nasim.EN3
                @Override // ir.nasim.InterfaceC24259yJ4
                public final void d(UJ2 uj2) {
                    MapActivity.r2(this.a, uj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(MapActivity mapActivity, UJ2 uj2) {
        AbstractC13042fc3.i(mapActivity, "this$0");
        AbstractC13042fc3.i(uj2, "it");
        uj2.c().a(false);
        uj2.f(((Number) mapActivity.Y1().V0().getValue()).intValue());
        uj2.d(OD0.a(new LatLng(35.7219d, 51.3347d), 16.0f));
        try {
            if (C5495Jo7.a.J2()) {
                uj2.e(MapStyleOptions.P(mapActivity, AbstractC19954rD5.map_style_dark));
            }
        } catch (Exception unused) {
            C19406qI3.b("Map Activity", "Error while set night mode");
        }
        if (AbstractC4043Dl1.a(mapActivity, "android.permission.ACCESS_FINE_LOCATION") == 0 && AbstractC4043Dl1.a(mapActivity, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            uj2.g(true);
        }
    }

    private final void v2() {
        if (AbstractC4043Dl1.a(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || AbstractC4043Dl1.a(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            T1().b(Y1().T0(), Y1().S0(), Looper.getMainLooper());
        }
    }

    private final void x2() {
        T1().d(Y1().S0());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base != null ? PH3.h(base) : null);
    }

    @Override // ir.nasim.InterfaceC24259yJ4
    public void d(UJ2 googleMap) {
        AbstractC13042fc3.i(googleMap, "googleMap");
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new f(googleMap, null), 3, null);
        S1().c.setContent(AbstractC19242q11.c(2128304925, true, new g(googleMap, this)));
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new h(googleMap, null), 3, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 102 && resultCode == -1) {
            if (AbstractC4043Dl1.a(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || AbstractC4043Dl1.a(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                Y1().Z0(true);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        PH3.h(this);
    }

    @Override // ir.nasim.features.map.ui.Hilt_MapActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        PH3.h(this);
        setTheme(AbstractC23035wE5.Theme_Bale_Base);
        super.onCreate(savedInstanceState);
        setContentView(S1().getRoot());
        n2();
        q2();
        o2();
        L1();
        a2(new SA2() { // from class: ir.nasim.zN3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return MapActivity.f2(this.a);
            }
        });
        S1().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.AN3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MapActivity.g2(this.a, view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0 && AbstractC4043Dl1.a(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                M1();
                if (AbstractC4043Dl1.a(this, "android.permission.ACCESS_FINE_LOCATION") == 0 && AbstractC4043Dl1.a(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    Fragment fragmentO0 = B0().o0(BC5.map_view);
                    SupportMapFragment supportMapFragment = fragmentO0 instanceof SupportMapFragment ? (SupportMapFragment) fragmentO0 : null;
                    if (supportMapFragment != null) {
                        supportMapFragment.r8(new InterfaceC24259yJ4() { // from class: ir.nasim.vN3
                            @Override // ir.nasim.InterfaceC24259yJ4
                            public final void d(UJ2 uj2) {
                                MapActivity.j2(uj2);
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        v2();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        x2();
        super.onStop();
    }
}
