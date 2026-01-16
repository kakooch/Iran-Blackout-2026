package ir.nasim.auth.auth.newlogin;

import android.app.UiModeManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager$UssdResponseCallback;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.Task;
import ir.nasim.A6;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10721c52;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC10940cT0;
import ir.nasim.AbstractC10983cX7;
import ir.nasim.AbstractC11557dC6;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13040fc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC16633lc3;
import ir.nasim.AbstractC17543n85;
import ir.nasim.AbstractC18122o73;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19329q98;
import ir.nasim.AbstractC19662qj7;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21784u76;
import ir.nasim.AbstractC21903uK5;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC22248uu6;
import ir.nasim.AbstractC22569vT0;
import ir.nasim.AbstractC23348wm0;
import ir.nasim.AbstractC24206yD5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC6747Ou5;
import ir.nasim.AbstractC8002Uc3;
import ir.nasim.AbstractC8216Va1;
import ir.nasim.AbstractC8354Vp4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC8654Ww7;
import ir.nasim.AbstractC8854Xp4;
import ir.nasim.AbstractC9129Yp4;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.C12561ep1;
import ir.nasim.C13923h3;
import ir.nasim.C14565i73;
import ir.nasim.C14725iN3;
import ir.nasim.C14819iX7;
import ir.nasim.C15218jC6;
import ir.nasim.C15721k36;
import ir.nasim.C17213mb2;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C21093t6;
import ir.nasim.C21753u45;
import ir.nasim.C23553x7;
import ir.nasim.C24147y73;
import ir.nasim.C24316yP7;
import ir.nasim.C24834zH3;
import ir.nasim.C5495Jo7;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.C7183Qq;
import ir.nasim.C7713Sw7;
import ir.nasim.C8120Up4;
import ir.nasim.C8588Wp4;
import ir.nasim.EB2;
import ir.nasim.EV2;
import ir.nasim.EnumC18608ow5;
import ir.nasim.EnumC9389Zs3;
import ir.nasim.FP7;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC13497gK4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14681iJ4;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC15814kD2;
import ir.nasim.InterfaceC16733lm3;
import ir.nasim.InterfaceC16978mB2;
import ir.nasim.InterfaceC18160oB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC20600sH6;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5757Ks;
import ir.nasim.InterfaceC8898Xu3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.LP;
import ir.nasim.M10;
import ir.nasim.N76;
import ir.nasim.PH3;
import ir.nasim.R01;
import ir.nasim.RA5;
import ir.nasim.SA2;
import ir.nasim.SF6;
import ir.nasim.SQ;
import ir.nasim.TB6;
import ir.nasim.TC2;
import ir.nasim.UA2;
import ir.nasim.VI3;
import ir.nasim.VW7;
import ir.nasim.W75;
import ir.nasim.ZY6;
import ir.nasim.auth.auth.newlogin.IntroActivity;
import ir.nasim.auth.smsretriever.SMSRetrieverBroadcastReceiver;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.payment.view.fragment.y;
import ir.nasim.features.root.RootActivity;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001/\b\u0007\u0018\u0000 t2\u00020\u0001:\u0001uB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u000eJ\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\"\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020$H\u0002¢\u0006\u0004\b(\u0010)J#\u0010-\u001a\u00020\b2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\b0*H\u0002¢\u0006\u0004\b-\u0010.J#\u00100\u001a\u00020/2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\b0*H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u0004\u0018\u00010+2\u0006\u00102\u001a\u00020+H\u0002¢\u0006\u0004\b3\u00104J+\u00107\u001a\u00020\b2\u0006\u00105\u001a\u00020+2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\b0*H\u0002¢\u0006\u0004\b7\u00108J+\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020+2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\b0*H\u0003¢\u0006\u0004\b:\u00108J#\u0010;\u001a\u00020\b2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\b0*H\u0003¢\u0006\u0004\b;\u0010.J\u000f\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\b<\u0010\u0003J\u000f\u0010=\u001a\u00020\bH\u0002¢\u0006\u0004\b=\u0010\u0003J\u000f\u0010>\u001a\u00020\bH\u0002¢\u0006\u0004\b>\u0010\u0003J\u0017\u0010A\u001a\u00020\b2\u0006\u0010@\u001a\u00020?H\u0015¢\u0006\u0004\bA\u0010BJ\u0019\u0010E\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010CH\u0014¢\u0006\u0004\bE\u0010FJ-\u0010L\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u001e2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020+0H2\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MR\"\u0010U\u001a\u00020N8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR(\u0010^\u001a\b\u0012\u0004\u0012\u00020W0V8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R$\u0010f\u001a\u0010\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020\u001a\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u00109\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010`R\"\u0010j\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\b0*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u001b\u0010\f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010l\u001a\u0004\bq\u0010r¨\u0006z²\u0006\f\u0010v\u001a\u00020+8\nX\u008a\u0084\u0002²\u0006\u0012\u0010y\u001a\b\u0012\u0004\u0012\u00020x0w8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/auth/auth/newlogin/IntroActivity;", "Lir/nasim/designsystem/base/activity/BaseActivity;", "<init>", "()V", "Lir/nasim/jC6;", "viewModel", "Lir/nasim/sH6;", "keyboardController", "Lir/nasim/rB7;", "a3", "(Lir/nasim/jC6;Lir/nasim/sH6;)V", "Lir/nasim/y73;", "initPhoneNumberViewModel", "c3", "(Lir/nasim/y73;)V", "W2", "(Lir/nasim/y73;Lir/nasim/sH6;)V", "Landroidx/navigation/e;", "navController", "X2", "(Lir/nasim/y73;Landroidx/navigation/e;)V", "Z2", "Y2", "b3", "d3", "o3", "", "isLight", "D3", "(Z)V", "", "theme", "Landroid/content/res/Configuration;", "configuration", "V2", "(ILandroid/content/res/Configuration;)V", "Lir/nasim/Zs3;", "language", "C3", "(Lir/nasim/Zs3;)V", "k3", "()Lir/nasim/Zs3;", "Lkotlin/Function1;", "", "onCodeRetriever", "E3", "(Lir/nasim/UA2;)V", "ir/nasim/auth/auth/newlogin/IntroActivity$j", "e3", "(Lir/nasim/UA2;)Lir/nasim/auth/auth/newlogin/IntroActivity$j;", DialogEntity.COLUMN_MESSAGE, "i3", "(Ljava/lang/String;)Ljava/lang/String;", "code", "validate", "y3", "(Ljava/lang/String;Lir/nasim/UA2;)V", "ussdCode", "f3", "z3", "w3", "v3", "A3", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lir/nasim/kD2;", "L0", "Lir/nasim/kD2;", "l3", "()Lir/nasim/kD2;", "setGalleryNavigator", "(Lir/nasim/kD2;)V", "galleryNavigator", "Lir/nasim/Xu3;", "Lir/nasim/k36;", "M0", "Lir/nasim/Xu3;", "r3", "()Lir/nasim/Xu3;", "setRootBeer", "(Lir/nasim/Xu3;)V", "rootBeer", "N0", "Ljava/lang/String;", "externalFile", "Lir/nasim/iN3;", "Landroid/net/Uri;", "O0", "Lir/nasim/iN3;", "launcherPickPhotoFromCamera", "P0", "Q0", "Lir/nasim/UA2;", "validateCode", "R0", "Lir/nasim/Yu3;", "m3", "()Lir/nasim/y73;", "Landroid/telephony/TelephonyManager;", "S0", "t3", "()Landroid/telephony/TelephonyManager;", "telephonyManager", "T0", "a", "emailState", "", "Landroid/telephony/SubscriptionInfo;", "subscriptionManagerList", "authentication_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class IntroActivity extends Hilt_IntroActivity {
    public static final int U0 = 8;

    /* renamed from: L0, reason: from kotlin metadata */
    public InterfaceC15814kD2 galleryNavigator;

    /* renamed from: M0, reason: from kotlin metadata */
    public InterfaceC8898Xu3 rootBeer;

    /* renamed from: N0, reason: from kotlin metadata */
    private String externalFile;

    /* renamed from: O0, reason: from kotlin metadata */
    private C14725iN3 launcherPickPhotoFromCamera;

    /* renamed from: P0, reason: from kotlin metadata */
    private String ussdCode;

    /* renamed from: Q0, reason: from kotlin metadata */
    private UA2 validateCode = new UA2() { // from class: ir.nasim.oc3
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return IntroActivity.M3((String) obj);
        }
    };

    /* renamed from: R0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 initPhoneNumberViewModel = new F(AbstractC10882cM5.b(C24147y73.class), new n(this), new m(this), new o(null, this));

    /* renamed from: S0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 telephonyManager = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pc3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return IntroActivity.L3(this.a);
        }
    });

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C24147y73 c;
        final /* synthetic */ InterfaceC20600sH6 d;
        final /* synthetic */ IntroActivity e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(((C14565i73) this.c).h());
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C14565i73 c14565i73, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c14565i73, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$b$b, reason: collision with other inner class name */
        static final class C0873b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ InterfaceC20600sH6 d;
            final /* synthetic */ IntroActivity e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0873b(InterfaceC20600sH6 interfaceC20600sH6, IntroActivity introActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC20600sH6;
                this.e = introActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0873b c0873b = new C0873b(this.d, this.e, interfaceC20295rm1);
                c0873b.c = ((Boolean) obj).booleanValue();
                return c0873b;
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
                if (this.c) {
                    InterfaceC20600sH6 interfaceC20600sH6 = this.d;
                    if (interfaceC20600sH6 != null) {
                        interfaceC20600sH6.b();
                    }
                    this.e.finish();
                    C5735Kp4.w().F();
                    Intent intent = new Intent(this.e, (Class<?>) RootActivity.class);
                    intent.putExtras(AbstractC23348wm0.b(AbstractC4616Fw7.a("arg_open_from_intro_activity", AbstractC6392Nk0.a(true))));
                    this.e.startActivity(intent);
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0873b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C24147y73 c24147y73, InterfaceC20600sH6 interfaceC20600sH6, IntroActivity introActivity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c24147y73;
            this.d = interfaceC20600sH6;
            this.e = introActivity;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.X(this.c.x1(), new a(null)));
                C0873b c0873b = new C0873b(this.d, this.e, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, c0873b, this) == objE) {
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

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C24147y73 c;
        final /* synthetic */ androidx.navigation.e d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(((C24316yP7) this.c).h());
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C24316yP7 c24316yP7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c24316yP7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ androidx.navigation.e d;
            final /* synthetic */ C24147y73 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(androidx.navigation.e eVar, C24147y73 c24147y73, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = eVar;
                this.e = c24147y73;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(androidx.navigation.n nVar) {
                androidx.navigation.n.e(nVar, 0, null, 2, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, interfaceC20295rm1);
                bVar.c = ((Boolean) obj).booleanValue();
                return bVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return w(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c) {
                    this.d.R(VI3.e.a.a(), new UA2() { // from class: ir.nasim.auth.auth.newlogin.a
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return IntroActivity.c.b.y((androidx.navigation.n) obj2);
                        }
                    });
                    this.e.K1();
                }
                return C19938rB7.a;
            }

            public final Object w(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C24147y73 c24147y73, androidx.navigation.e eVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c24147y73;
            this.d = eVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.X(this.c.A1(), new a(null)));
                b bVar = new b(this.d, this.c, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, bVar, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C24147y73 c;
        final /* synthetic */ androidx.navigation.e d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ androidx.navigation.e d;
            final /* synthetic */ C24147y73 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(androidx.navigation.e eVar, C24147y73 c24147y73, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = eVar;
                this.e = c24147y73;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((C14565i73) this.c).k()) {
                    androidx.navigation.e.S(this.d, VI3.f.a.a(), null, null, 6, null);
                    this.e.L1();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C14565i73 c14565i73, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c14565i73, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C24147y73 c24147y73, androidx.navigation.e eVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c24147y73;
            this.d = eVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6X1 = this.c.x1();
                a aVar = new a(this.d, this.c, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6X1, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C24147y73 c;
        final /* synthetic */ androidx.navigation.e d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ androidx.navigation.e d;
            final /* synthetic */ C24147y73 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(androidx.navigation.e eVar, C24147y73 c24147y73, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = eVar;
                this.e = c24147y73;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((C24316yP7) this.c).p()) {
                    androidx.navigation.e.S(this.d, VI3.f.a.a(), null, null, 6, null);
                    this.e.L1();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C24316yP7 c24316yP7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c24316yP7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C24147y73 c24147y73, androidx.navigation.e eVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c24147y73;
            this.d = eVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6A1 = this.c.A1();
                a aVar = new a(this.d, this.c, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6A1, aVar, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C15218jC6 c;
        final /* synthetic */ InterfaceC20600sH6 d;
        final /* synthetic */ IntroActivity e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(((TB6) this.c).g());
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(TB6 tb6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(tb6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ InterfaceC20600sH6 d;
            final /* synthetic */ IntroActivity e;
            final /* synthetic */ C15218jC6 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC20600sH6 interfaceC20600sH6, IntroActivity introActivity, C15218jC6 c15218jC6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC20600sH6;
                this.e = introActivity;
                this.f = c15218jC6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, this.f, interfaceC20295rm1);
                bVar.c = ((Boolean) obj).booleanValue();
                return bVar;
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
                if (this.c) {
                    InterfaceC20600sH6 interfaceC20600sH6 = this.d;
                    if (interfaceC20600sH6 != null) {
                        interfaceC20600sH6.b();
                    }
                    this.e.finish();
                    C5735Kp4.w().F();
                    IntroActivity introActivity = this.e;
                    Intent intent = new Intent(this.e, (Class<?>) RootActivity.class);
                    intent.putExtras(AbstractC23348wm0.b(AbstractC4616Fw7.a("arg_open_from_intro_activity", AbstractC6392Nk0.a(true))));
                    intent.putExtras(AbstractC23348wm0.b(AbstractC4616Fw7.a("arg_open_from_signup", AbstractC6392Nk0.a(true))));
                    introActivity.startActivity(intent);
                    this.f.g1();
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C15218jC6 c15218jC6, InterfaceC20600sH6 interfaceC20600sH6, IntroActivity introActivity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c15218jC6;
            this.d = interfaceC20600sH6;
            this.e = introActivity;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.X(this.c.e1(), new a(null)));
                b bVar = new b(this.d, this.e, this.c, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, bVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C24147y73 c;
        final /* synthetic */ androidx.navigation.e d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ androidx.navigation.e d;
            final /* synthetic */ C24147y73 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(androidx.navigation.e eVar, C24147y73 c24147y73, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = eVar;
                this.e = c24147y73;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((C14565i73) this.c).i()) {
                    androidx.navigation.e.S(this.d, VI3.d.c.b.a(), null, null, 6, null);
                    this.e.J1();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C14565i73 c14565i73, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c14565i73, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C24147y73 c24147y73, androidx.navigation.e eVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c24147y73;
            this.d = eVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6X1 = this.c.x1();
                a aVar = new a(this.d, this.c, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6X1, aVar, this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C24147y73 c;
        final /* synthetic */ IntroActivity d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return ((C24316yP7) this.c).d();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C24316yP7 c24316yP7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c24316yP7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ IntroActivity d;
            final /* synthetic */ C24147y73 e;

            /* synthetic */ class a extends EB2 implements UA2 {
                a(Object obj) {
                    super(1, obj, C24147y73.class, "updateValidationCode", "updateValidationCode(Ljava/lang/String;)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y((String) obj);
                    return C19938rB7.a;
                }

                public final void y(String str) {
                    AbstractC13042fc3.i(str, "p0");
                    ((C24147y73) this.receiver).n2(str);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(IntroActivity introActivity, C24147y73 c24147y73, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = introActivity;
                this.e = c24147y73;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                String str = (String) this.c;
                if (!AbstractC20762sZ6.n0(str)) {
                    this.d.validateCode = new a(this.e);
                    IntroActivity introActivity = this.d;
                    introActivity.y3(str, introActivity.validateCode);
                    this.e.o2();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C24147y73 c24147y73, IntroActivity introActivity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c24147y73;
            this.d = introActivity;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.X(this.c.A1(), new a(null));
                b bVar = new b(this.d, this.c, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2X, bVar, this) == objE) {
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

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C24147y73 c;
        final /* synthetic */ IntroActivity d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ IntroActivity d;
            final /* synthetic */ C24147y73 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(IntroActivity introActivity, C24147y73 c24147y73, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = introActivity;
                this.e = c24147y73;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((C24316yP7) this.c).n()) {
                    this.d.finish();
                    C5735Kp4.w().F();
                    IntroActivity introActivity = this.d;
                    Intent intent = new Intent(this.d, (Class<?>) RootActivity.class);
                    intent.putExtras(AbstractC23348wm0.b(AbstractC4616Fw7.a("arg_open_from_intro_activity", AbstractC6392Nk0.a(true))));
                    introActivity.startActivity(intent);
                    this.e.J1();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C24316yP7 c24316yP7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c24316yP7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C24147y73 c24147y73, IntroActivity introActivity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c24147y73;
            this.d = introActivity;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6A1 = this.c.A1();
                a aVar = new a(this.d, this.c, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6A1, aVar, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class j implements N76 {
        final /* synthetic */ UA2 b;

        j(UA2 ua2) {
            this.b = ua2;
        }

        @Override // ir.nasim.N76
        public void a(String str) {
            String name;
            if (str != null) {
                if (j.class.isAnonymousClass()) {
                    name = j.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = j.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.a(name, str, new Object[0]);
            }
        }

        @Override // ir.nasim.N76
        public void b(String str) {
            String strI3;
            if (str == null || (strI3 = IntroActivity.this.i3(str)) == null) {
                return;
            }
            this.b.invoke(strI3);
        }
    }

    public static final class k extends TelephonyManager$UssdResponseCallback {
        final /* synthetic */ UA2 a;

        k(UA2 ua2) {
            this.a = ua2;
        }

        public void onReceiveUssdResponse(TelephonyManager telephonyManager, String str, CharSequence charSequence) {
            AbstractC13042fc3.i(telephonyManager, "telephonyManager");
            AbstractC13042fc3.i(str, "request");
            AbstractC13042fc3.i(charSequence, "response");
            super.onReceiveUssdResponse(telephonyManager, str, charSequence);
            this.a.invoke(ZY6.a(charSequence.toString()));
        }

        public void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String str, int i) {
            String name;
            AbstractC13042fc3.i(telephonyManager, "telephonyManager");
            AbstractC13042fc3.i(str, "request");
            super.onReceiveUssdResponseFailed(telephonyManager, str, i);
            if (k.class.isAnonymousClass()) {
                name = k.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = k.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.b(name, "failed ussd with code " + i + " and " + str);
        }
    }

    static final class l implements InterfaceC14603iB2 {
        final /* synthetic */ int b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ IntroActivity a;
            final /* synthetic */ int b;

            /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$a, reason: collision with other inner class name */
            static final class C0874a implements InterfaceC16978mB2 {
                final /* synthetic */ IntroActivity a;
                final /* synthetic */ int b;
                final /* synthetic */ C8588Wp4 c;

                C0874a(IntroActivity introActivity, int i, C8588Wp4 c8588Wp4) {
                    this.a = introActivity;
                    this.b = i;
                    this.c = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i(IntroActivity introActivity, int i) {
                    AbstractC13042fc3.i(introActivity, "this$0");
                    Configuration configuration = introActivity.getApplicationContext().getResources().getConfiguration();
                    AbstractC13042fc3.h(configuration, "getConfiguration(...)");
                    introActivity.V2(i, configuration);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 k(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, VI3.a.a.a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 n(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    C17213mb2.g(C17213mb2.a, "start_button_click", null, 2, null);
                    boolean zH = C7183Qq.p().h("PREF_KEY_IS_IN_SING_UP", false);
                    String strE = C7183Qq.p().e("PREF_KEY_TRANSACTION_HASH");
                    if (!zH || strE == null) {
                        c8588Wp4.R(new VI3.d().a(), new UA2() { // from class: ir.nasim.auth.auth.newlogin.k
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return IntroActivity.l.a.C0874a.p((androidx.navigation.n) obj);
                            }
                        });
                    } else {
                        c8588Wp4.R(VI3.e.a.a(), new UA2() { // from class: ir.nasim.auth.auth.newlogin.j
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return IntroActivity.l.a.C0874a.o((androidx.navigation.n) obj);
                            }
                        });
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 o(androidx.navigation.n nVar) {
                    AbstractC13042fc3.i(nVar, "$this$navigate");
                    androidx.navigation.n.e(nVar, 0, null, 2, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 p(androidx.navigation.n nVar) {
                    AbstractC13042fc3.i(nVar, "$this$navigate");
                    androidx.navigation.n.e(nVar, 0, null, 2, null);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    h((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }

                public final void h(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    interfaceC22053ub1.W(1005445725);
                    boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.e(this.b);
                    final IntroActivity introActivity = this.a;
                    final int i2 = this.b;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.auth.auth.newlogin.g
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return IntroActivity.l.a.C0874a.i(introActivity, i2);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1005487870);
                    boolean zD2 = interfaceC22053ub1.D(this.c);
                    final C8588Wp4 c8588Wp4 = this.c;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.auth.auth.newlogin.h
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return IntroActivity.l.a.C0874a.k(c8588Wp4);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    SA2 sa22 = (SA2) objB2;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1005452284);
                    boolean zD3 = interfaceC22053ub1.D(this.c);
                    final C8588Wp4 c8588Wp42 = this.c;
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new SA2() { // from class: ir.nasim.auth.auth.newlogin.i
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return IntroActivity.l.a.C0874a.n(c8588Wp42);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC8002Uc3.h(sa2, sa22, (SA2) objB3, interfaceC22053ub1, 0, 0);
                }
            }

            static final class b implements InterfaceC16978mB2 {
                final /* synthetic */ IntroActivity a;
                final /* synthetic */ InterfaceC20600sH6 b;

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$b$a, reason: collision with other inner class name */
                static final class C0875a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ IntroActivity c;
                    final /* synthetic */ C15218jC6 d;
                    final /* synthetic */ InterfaceC20600sH6 e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0875a(IntroActivity introActivity, C15218jC6 c15218jC6, InterfaceC20600sH6 interfaceC20600sH6, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = introActivity;
                        this.d = c15218jC6;
                        this.e = interfaceC20600sH6;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0875a(this.c, this.d, this.e, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        this.c.a3(this.d, this.e);
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0875a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$b$b, reason: collision with other inner class name */
                /* synthetic */ class C0876b extends EB2 implements SA2 {
                    C0876b(Object obj) {
                        super(0, obj, IntroActivity.class, "getPicture", "getPicture()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((IntroActivity) this.receiver).o3();
                    }
                }

                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C15218jC6.class, "updateName", "updateName(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C15218jC6) this.receiver).l1(str);
                    }
                }

                /* synthetic */ class d extends EB2 implements UA2 {
                    d(Object obj) {
                        super(1, obj, C15218jC6.class, "signUp", "signUp(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C15218jC6) this.receiver).k1(str);
                    }
                }

                b(IntroActivity introActivity, InterfaceC20600sH6 interfaceC20600sH6) {
                    this.a = introActivity;
                    this.b = interfaceC20600sH6;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(IntroActivity introActivity, final C15218jC6 c15218jC6, boolean z) {
                    String str;
                    AbstractC13042fc3.i(introActivity, "this$0");
                    AbstractC13042fc3.i(c15218jC6, "$viewModel");
                    if (z && (str = introActivity.externalFile) != null && str.length() > 0 && new File(str).exists()) {
                        AbstractC17543n85.a(null, introActivity, introActivity.externalFile, 1, false, new AbstractC17543n85.b() { // from class: ir.nasim.auth.auth.newlogin.m
                            @Override // ir.nasim.AbstractC17543n85.b
                            public final void a(String str2, String str3) {
                                IntroActivity.l.a.b.f(c15218jC6, str2, str3);
                            }
                        });
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void f(C15218jC6 c15218jC6, String str, String str2) {
                    AbstractC13042fc3.i(c15218jC6, "$viewModel");
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    c15218jC6.h1(str);
                }

                public final void c(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    interfaceC22053ub1.A(-550968255);
                    InterfaceC15408jX7 interfaceC15408jX7A = C24834zH3.a.a(interfaceC22053ub1, 8);
                    if (interfaceC15408jX7A == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    G.c cVarA = EV2.a(interfaceC15408jX7A, interfaceC22053ub1, 8);
                    interfaceC22053ub1.A(564614654);
                    VW7 vw7A = AbstractC10983cX7.a(C15218jC6.class, interfaceC15408jX7A, null, cVarA, interfaceC22053ub1, 4168, 0);
                    interfaceC22053ub1.U();
                    interfaceC22053ub1.U();
                    final C15218jC6 c15218jC6 = (C15218jC6) vw7A;
                    IntroActivity introActivity = this.a;
                    C21093t6 c21093t6 = new C21093t6();
                    interfaceC22053ub1.W(1005505558);
                    boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(c15218jC6);
                    final IntroActivity introActivity2 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.auth.auth.newlogin.l
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return IntroActivity.l.a.b.d(introActivity2, c15218jC6, ((Boolean) obj).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    introActivity.launcherPickPhotoFromCamera = A6.a(c21093t6, (UA2) objB, interfaceC22053ub1, 0);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(1005541450);
                    boolean zD2 = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(c15218jC6) | interfaceC22053ub1.V(this.b);
                    IntroActivity introActivity3 = this.a;
                    InterfaceC20600sH6 interfaceC20600sH6 = this.b;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0875a(introActivity3, c15218jC6, interfaceC20600sH6, null);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 6);
                    AbstractC6747Ou5 abstractC6747Ou5F = ((TB6) AbstractC10222bH6.b(c15218jC6.e1(), null, interfaceC22053ub1, 0, 1).getValue()).f();
                    Object obj = this.a;
                    interfaceC22053ub1.W(1005550635);
                    boolean zD3 = interfaceC22053ub1.D(obj);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new C0876b(obj);
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB3);
                    String strE = ((TB6) AbstractC10222bH6.b(c15218jC6.e1(), null, interfaceC22053ub1, 0, 1).getValue()).e();
                    interfaceC22053ub1.W(1005555380);
                    boolean zD4 = interfaceC22053ub1.D(c15218jC6);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new c(c15218jC6);
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB4);
                    boolean zH = ((TB6) AbstractC10222bH6.b(c15218jC6.e1(), null, interfaceC22053ub1, 0, 1).getValue()).h();
                    LP lpD = ((TB6) AbstractC10222bH6.b(c15218jC6.e1(), null, interfaceC22053ub1, 0, 1).getValue()).d();
                    interfaceC22053ub1.W(1005563440);
                    boolean zD5 = interfaceC22053ub1.D(c15218jC6);
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                        objB5 = new d(c15218jC6);
                        interfaceC22053ub1.s(objB5);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC11557dC6.i(abstractC6747Ou5F, sa2, strE, ua2, zH, lpD, (UA2) ((InterfaceC16733lm3) objB5), interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    c((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            static final class c implements InterfaceC16978mB2 {
                final /* synthetic */ IntroActivity a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$c$a, reason: collision with other inner class name */
                static final class C0877a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ IntroActivity c;
                    final /* synthetic */ C8588Wp4 d;

                    /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$c$a$a, reason: collision with other inner class name */
                    /* synthetic */ class C0878a extends EB2 implements UA2 {
                        C0878a(Object obj) {
                            super(1, obj, C24147y73.class, "updateValidationCode", "updateValidationCode(Ljava/lang/String;)V", 0);
                        }

                        @Override // ir.nasim.UA2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            y((String) obj);
                            return C19938rB7.a;
                        }

                        public final void y(String str) {
                            AbstractC13042fc3.i(str, "p0");
                            ((C24147y73) this.receiver).n2(str);
                        }
                    }

                    /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$c$a$b */
                    /* synthetic */ class b extends EB2 implements UA2 {
                        b(Object obj) {
                            super(1, obj, C24147y73.class, "updateValidationCode", "updateValidationCode(Ljava/lang/String;)V", 0);
                        }

                        @Override // ir.nasim.UA2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            y((String) obj);
                            return C19938rB7.a;
                        }

                        public final void y(String str) {
                            AbstractC13042fc3.i(str, "p0");
                            ((C24147y73) this.receiver).n2(str);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0877a(IntroActivity introActivity, C8588Wp4 c8588Wp4, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = introActivity;
                        this.d = c8588Wp4;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0877a(this.c, this.d, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        this.c.validateCode = new C0878a(this.c.m3());
                        IntroActivity introActivity = this.c;
                        introActivity.X2(introActivity.m3(), this.d);
                        this.c.E3(new b(this.c.m3()));
                        IntroActivity introActivity2 = this.c;
                        introActivity2.c3(introActivity2.m3());
                        IntroActivity introActivity3 = this.c;
                        introActivity3.Z2(introActivity3.m3(), this.d);
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0877a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* synthetic */ class b extends EB2 implements UA2 {
                    b(Object obj) {
                        super(1, obj, C24147y73.class, "updateValidationCode", "updateValidationCode(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C24147y73) this.receiver).n2(str);
                    }
                }

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$c$c, reason: collision with other inner class name */
                /* synthetic */ class C0879c extends EB2 implements SA2 {
                    C0879c(Object obj) {
                        super(0, obj, C24147y73.class, "updateCountDown", "updateCountDown()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((C24147y73) this.receiver).a2();
                    }
                }

                /* synthetic */ class d extends C23553x7 implements InterfaceC18160oB2 {
                    d(Object obj) {
                        super(5, obj, C24147y73.class, "startAuth", "startAuth(Lir/nasim/auth/auth/newlogin/screens/model/PhoneData;JLjava/util/List;Lir/nasim/core/modules/auth/entity/AuthSendCodeType;ZZ)V", 0);
                    }

                    public final void a(W75 w75, long j, List list, SQ sq, boolean z) {
                        AbstractC13042fc3.i(w75, "p0");
                        AbstractC13042fc3.i(sq, "p3");
                        C24147y73.W1((C24147y73) this.a, w75, j, list, sq, z, false, 32, null);
                    }

                    @Override // ir.nasim.InterfaceC18160oB2
                    public /* bridge */ /* synthetic */ Object s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                        a((W75) obj, ((Number) obj2).longValue(), (List) obj3, (SQ) obj4, ((Boolean) obj5).booleanValue());
                        return C19938rB7.a;
                    }
                }

                /* synthetic */ class e extends EB2 implements UA2 {
                    e(Object obj) {
                        super(1, obj, C24147y73.class, "validateCode", "validateCode(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C24147y73) this.receiver).p2(str);
                    }
                }

                /* synthetic */ class f extends EB2 implements SA2 {
                    f(Object obj) {
                        super(0, obj, C24147y73.class, "restoreError", "restoreError()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((C24147y73) this.receiver).I1();
                    }
                }

                /* synthetic */ class g extends EB2 implements SA2 {
                    g(Object obj) {
                        super(0, obj, IntroActivity.class, "saveLogs", "saveLogs()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((IntroActivity) this.receiver).A3();
                    }
                }

                c(IntroActivity introActivity, C8588Wp4 c8588Wp4) {
                    this.a = introActivity;
                    this.b = c8588Wp4;
                }

                public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(2045237465);
                    boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                    IntroActivity introActivity = this.a;
                    C8588Wp4 c8588Wp4 = this.b;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0877a(introActivity, c8588Wp4, null);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
                    Integer numG = ((C24316yP7) AbstractC10222bH6.b(this.a.m3().A1(), null, interfaceC22053ub1, 0, 1).getValue()).g();
                    String strL = ((C24316yP7) AbstractC10222bH6.b(this.a.m3().A1(), null, interfaceC22053ub1, 0, 1).getValue()).l();
                    String strM = ((C24316yP7) AbstractC10222bH6.b(this.a.m3().A1(), null, interfaceC22053ub1, 0, 1).getValue()).m();
                    C24147y73 c24147y73M3 = this.a.m3();
                    interfaceC22053ub1.W(2045273452);
                    boolean zD2 = interfaceC22053ub1.D(c24147y73M3);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new b(c24147y73M3);
                        interfaceC22053ub1.s(objB2);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB2;
                    interfaceC22053ub1.Q();
                    int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(((C24316yP7) AbstractC10222bH6.b(this.a.m3().A1(), null, interfaceC22053ub1, 0, 1).getValue()).j());
                    C24147y73 c24147y73M32 = this.a.m3();
                    interfaceC22053ub1.W(2045285927);
                    boolean zD3 = interfaceC22053ub1.D(c24147y73M32);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new C0879c(c24147y73M32);
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB3;
                    interfaceC22053ub1.Q();
                    C24147y73 c24147y73M33 = this.a.m3();
                    interfaceC22053ub1.W(2045288865);
                    boolean zD4 = interfaceC22053ub1.D(c24147y73M33);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new d(c24147y73M33);
                        interfaceC22053ub1.s(objB4);
                    }
                    InterfaceC18160oB2 interfaceC18160oB2 = (InterfaceC18160oB2) objB4;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(2045297110);
                    List listF1 = AbstractC15401jX0.f1(((C24316yP7) AbstractC10222bH6.b(this.a.m3().A1(), null, interfaceC22053ub1, 0, 1).getValue()).c(), 2);
                    IntroActivity introActivity2 = this.a;
                    if (listF1.isEmpty()) {
                        listF1 = AbstractC9766aX0.e(((C24316yP7) AbstractC10222bH6.b(introActivity2.m3().A1(), null, interfaceC22053ub1, 0, 1).getValue()).i());
                    }
                    List list = listF1;
                    interfaceC22053ub1.Q();
                    W75 w75E = ((C14565i73) AbstractC10222bH6.b(this.a.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).e();
                    long jD = ((C14565i73) AbstractC10222bH6.b(this.a.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).d();
                    LP lpE = ((C24316yP7) AbstractC10222bH6.b(this.a.m3().A1(), null, interfaceC22053ub1, 0, 1).getValue()).e();
                    LP lpC = ((C14565i73) AbstractC10222bH6.b(this.a.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    boolean zO = ((C24316yP7) AbstractC10222bH6.b(this.a.m3().A1(), null, interfaceC22053ub1, 0, 1).getValue()).o();
                    C24147y73 c24147y73M34 = this.a.m3();
                    interfaceC22053ub1.W(2045324036);
                    boolean zD5 = interfaceC22053ub1.D(c24147y73M34);
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                        objB5 = new e(c24147y73M34);
                        interfaceC22053ub1.s(objB5);
                    }
                    InterfaceC16733lm3 interfaceC16733lm33 = (InterfaceC16733lm3) objB5;
                    interfaceC22053ub1.Q();
                    SQ sqK = ((C24316yP7) AbstractC10222bH6.b(this.a.m3().A1(), null, interfaceC22053ub1, 0, 1).getValue()).k();
                    C24147y73 c24147y73M35 = this.a.m3();
                    interfaceC22053ub1.W(2045331076);
                    boolean zD6 = interfaceC22053ub1.D(c24147y73M35);
                    Object objB6 = interfaceC22053ub1.B();
                    if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                        objB6 = new f(c24147y73M35);
                        interfaceC22053ub1.s(objB6);
                    }
                    InterfaceC16733lm3 interfaceC16733lm34 = (InterfaceC16733lm3) objB6;
                    interfaceC22053ub1.Q();
                    String strG = ((C14565i73) AbstractC10222bH6.b(this.a.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).g();
                    IntroActivity introActivity3 = this.a;
                    interfaceC22053ub1.W(2045338248);
                    boolean zD7 = interfaceC22053ub1.D(introActivity3);
                    Object objB7 = interfaceC22053ub1.B();
                    if (zD7 || objB7 == InterfaceC22053ub1.a.a()) {
                        objB7 = new g(introActivity3);
                        interfaceC22053ub1.s(objB7);
                    }
                    interfaceC22053ub1.Q();
                    FP7.b(this.b, numG, strL, strM, (UA2) interfaceC16733lm3, seconds, (SA2) interfaceC16733lm32, interfaceC18160oB2, list, w75E, jD, lpE, lpC, (SA2) interfaceC16733lm34, zO, (UA2) interfaceC16733lm33, sqK, strG, (SA2) ((InterfaceC16733lm3) objB7), interfaceC22053ub1, 0, 0, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            static final class d implements InterfaceC16978mB2 {
                final /* synthetic */ IntroActivity a;
                final /* synthetic */ InterfaceC20600sH6 b;
                final /* synthetic */ C8588Wp4 c;

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$d$a, reason: collision with other inner class name */
                static final class C0880a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ IntroActivity c;
                    final /* synthetic */ InterfaceC20600sH6 d;
                    final /* synthetic */ C8588Wp4 e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0880a(IntroActivity introActivity, InterfaceC20600sH6 interfaceC20600sH6, C8588Wp4 c8588Wp4, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = introActivity;
                        this.d = interfaceC20600sH6;
                        this.e = c8588Wp4;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0880a(this.c, this.d, this.e, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        IntroActivity introActivity = this.c;
                        introActivity.W2(introActivity.m3(), this.d);
                        IntroActivity introActivity2 = this.c;
                        introActivity2.b3(introActivity2.m3(), this.e);
                        IntroActivity introActivity3 = this.c;
                        introActivity3.Y2(introActivity3.m3(), this.e);
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0880a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* synthetic */ class b extends EB2 implements UA2 {
                    b(Object obj) {
                        super(1, obj, C24147y73.class, "updatePhoneNumber", "updatePhoneNumber(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C24147y73) this.receiver).h2(str);
                    }
                }

                /* synthetic */ class c extends EB2 implements SA2 {
                    c(Object obj) {
                        super(0, obj, IntroActivity.class, "saveLogs", "saveLogs()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((IntroActivity) this.receiver).A3();
                    }
                }

                d(IntroActivity introActivity, InterfaceC20600sH6 interfaceC20600sH6, C8588Wp4 c8588Wp4) {
                    this.a = introActivity;
                    this.b = interfaceC20600sH6;
                    this.c = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(IntroActivity introActivity, W75 w75, long j, List list, boolean z) {
                    AbstractC13042fc3.i(introActivity, "this$0");
                    AbstractC13042fc3.i(w75, "phoneData");
                    C24147y73.W1(introActivity.m3(), w75, j, list, null, false, z, 24, null);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(2045345304);
                    boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(this.c);
                    IntroActivity introActivity = this.a;
                    InterfaceC20600sH6 interfaceC20600sH6 = this.b;
                    C8588Wp4 c8588Wp4 = this.c;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0880a(introActivity, interfaceC20600sH6, c8588Wp4, null);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
                    C8588Wp4 c8588Wp42 = this.c;
                    String strD = ((C14565i73) AbstractC10222bH6.b(this.a.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).e().d();
                    String strC = ((C14565i73) AbstractC10222bH6.b(this.a.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).e().c();
                    String strE = ((C14565i73) AbstractC10222bH6.b(this.a.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).e().e();
                    String strF = ((C14565i73) AbstractC10222bH6.b(this.a.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).e().f();
                    C24147y73 c24147y73M3 = this.a.m3();
                    interfaceC22053ub1.W(2045374697);
                    boolean zD2 = interfaceC22053ub1.D(c24147y73M3);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new b(c24147y73M3);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB2);
                    interfaceC22053ub1.W(2045378249);
                    boolean zD3 = interfaceC22053ub1.D(this.a);
                    final IntroActivity introActivity2 = this.a;
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new InterfaceC16978mB2() { // from class: ir.nasim.auth.auth.newlogin.n
                            @Override // ir.nasim.InterfaceC16978mB2
                            public final Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                                return IntroActivity.l.a.d.c(introActivity2, (W75) obj, ((Long) obj2).longValue(), (List) obj3, ((Boolean) obj4).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16978mB2 interfaceC16978mB2 = (InterfaceC16978mB2) objB3;
                    interfaceC22053ub1.Q();
                    LP lpC = ((C14565i73) AbstractC10222bH6.b(this.a.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    boolean zJ = ((C14565i73) AbstractC10222bH6.b(this.a.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).j();
                    IntroActivity introActivity3 = this.a;
                    interfaceC22053ub1.W(2045401128);
                    boolean zD4 = interfaceC22053ub1.D(introActivity3);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new c(introActivity3);
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC18122o73.c(c8588Wp42, strD, strC, strE, strF, ua2, interfaceC16978mB2, lpC, zJ, (SA2) ((InterfaceC16733lm3) objB4), interfaceC22053ub1, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    b((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            static final class e implements InterfaceC16978mB2 {
                final /* synthetic */ C8588Wp4 a;
                final /* synthetic */ IntroActivity b;

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$e$a, reason: collision with other inner class name */
                /* synthetic */ class C0881a extends EB2 implements UA2 {
                    C0881a(Object obj) {
                        super(1, obj, C24147y73.class, "updateSearchQuery", "updateSearchQuery(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C24147y73) this.receiver).i2(str);
                    }
                }

                /* synthetic */ class b extends EB2 implements InterfaceC15796kB2 {
                    b(Object obj) {
                        super(3, obj, C24147y73.class, "updateCountryCode", "updateCountryCode(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        y((String) obj, (String) obj2, (String) obj3);
                        return C19938rB7.a;
                    }

                    public final void y(String str, String str2, String str3) {
                        AbstractC13042fc3.i(str, "p0");
                        AbstractC13042fc3.i(str2, "p1");
                        ((C24147y73) this.receiver).c2(str, str2, str3);
                    }
                }

                e(C8588Wp4 c8588Wp4, IntroActivity introActivity) {
                    this.a = c8588Wp4;
                    this.b = introActivity;
                }

                public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C12561ep1 c12561ep1D = VI3.d.a.b.d();
                    C8588Wp4 c8588Wp4 = this.a;
                    String strF = ((C14565i73) AbstractC10222bH6.b(this.b.m3().x1(), null, interfaceC22053ub1, 0, 1).getValue()).f();
                    C24147y73 c24147y73M3 = this.b.m3();
                    interfaceC22053ub1.W(2045417225);
                    boolean zD = interfaceC22053ub1.D(c24147y73M3);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0881a(c24147y73M3);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB);
                    C24147y73 c24147y73M32 = this.b.m3();
                    interfaceC22053ub1.W(2045419689);
                    boolean zD2 = interfaceC22053ub1.D(c24147y73M32);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new b(c24147y73M32);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10940cT0.d(c12561ep1D, c8588Wp4, strF, ua2, (InterfaceC15796kB2) ((InterfaceC16733lm3) objB2), interfaceC22053ub1, C12561ep1.b);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            static final class f implements InterfaceC16978mB2 {
                final /* synthetic */ C8588Wp4 a;
                final /* synthetic */ IntroActivity b;

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$f$a, reason: collision with other inner class name */
                /* synthetic */ class C0882a extends C23553x7 implements SA2 {
                    C0882a(Object obj) {
                        super(0, obj, C8588Wp4.class, "popBackStack", "popBackStack()Z", 8);
                    }

                    public final void a() {
                        ((C8588Wp4) this.a).V();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* synthetic */ class b extends EB2 implements UA2 {
                    b(Object obj) {
                        super(1, obj, C24147y73.class, "updateTwoFAPassword", "updateTwoFAPassword(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C24147y73) this.receiver).l2(str);
                    }
                }

                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C24147y73.class, "updateErrorTwoFAPassword", "updateErrorTwoFAPassword(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        ((C24147y73) this.receiver).f2(str);
                    }
                }

                f(C8588Wp4 c8588Wp4, IntroActivity introActivity) {
                    this.a = c8588Wp4;
                    this.b = introActivity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(IntroActivity introActivity, String str) {
                    AbstractC13042fc3.i(introActivity, "this$0");
                    AbstractC13042fc3.i(str, "it");
                    introActivity.m3().s2(str);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 h(IntroActivity introActivity, final C8588Wp4 c8588Wp4) {
                    AbstractC13042fc3.i(introActivity, "this$0");
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    introActivity.m3().f2(null);
                    introActivity.m3().H1(new SA2() { // from class: ir.nasim.auth.auth.newlogin.q
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return IntroActivity.l.a.f.i(c8588Wp4);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, new VI3.c().a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                public final void d(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C8588Wp4 c8588Wp4 = this.a;
                    interfaceC22053ub1.W(1005770426);
                    boolean zD = interfaceC22053ub1.D(c8588Wp4);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0882a(c8588Wp4);
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    String strG = ((C7713Sw7) AbstractC10222bH6.b(this.b.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).g();
                    C24147y73 c24147y73M3 = this.b.m3();
                    interfaceC22053ub1.W(1005776588);
                    boolean zD2 = interfaceC22053ub1.D(c24147y73M3);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new b(c24147y73M3);
                        interfaceC22053ub1.s(objB2);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB2;
                    interfaceC22053ub1.Q();
                    String strE = ((C7713Sw7) AbstractC10222bH6.b(this.b.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).e();
                    C24147y73 c24147y73M32 = this.b.m3();
                    interfaceC22053ub1.W(1005800113);
                    boolean zD3 = interfaceC22053ub1.D(c24147y73M32);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new c(c24147y73M32);
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB3;
                    interfaceC22053ub1.Q();
                    boolean zJ = ((C7713Sw7) AbstractC10222bH6.b(this.b.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).j();
                    interfaceC22053ub1.W(1005795249);
                    boolean zD4 = interfaceC22053ub1.D(this.b);
                    final IntroActivity introActivity = this.b;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new UA2() { // from class: ir.nasim.auth.auth.newlogin.o
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return IntroActivity.l.a.f.f(introActivity, (String) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    UA2 ua2 = (UA2) objB4;
                    interfaceC22053ub1.Q();
                    UA2 ua22 = (UA2) interfaceC16733lm3;
                    interfaceC22053ub1.W(1005783345);
                    boolean zD5 = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
                    final IntroActivity introActivity2 = this.b;
                    final C8588Wp4 c8588Wp42 = this.a;
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                        objB5 = new SA2() { // from class: ir.nasim.auth.auth.newlogin.p
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return IntroActivity.l.a.f.h(introActivity2, c8588Wp42);
                            }
                        };
                        interfaceC22053ub1.s(objB5);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC8654Ww7.d(sa2, ua2, strG, ua22, strE, (SA2) objB5, (UA2) interfaceC16733lm32, zJ, interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    d((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            static final class g implements InterfaceC16978mB2 {
                final /* synthetic */ IntroActivity a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$g$a, reason: collision with other inner class name */
                /* synthetic */ class C0883a extends C23553x7 implements SA2 {
                    C0883a(Object obj) {
                        super(0, obj, C8588Wp4.class, "popBackStack", "popBackStack()Z", 8);
                    }

                    public final void a() {
                        ((C8588Wp4) this.a).V();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* synthetic */ class b extends EB2 implements UA2 {
                    b(Object obj) {
                        super(1, obj, C24147y73.class, "updateTwoFARecoveryCode", "updateTwoFARecoveryCode(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C24147y73) this.receiver).m2(str);
                    }
                }

                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C24147y73.class, "updateErrorTwoFAPassword", "updateErrorTwoFAPassword(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        ((C24147y73) this.receiver).f2(str);
                    }
                }

                /* synthetic */ class d extends C23553x7 implements SA2 {
                    d(Object obj) {
                        super(0, obj, C24147y73.class, "updateEmailCodeCountDown", "updateEmailCodeCountDown(Z)V", 0);
                    }

                    public final void a() {
                        C24147y73.e2((C24147y73) this.a, false, 1, null);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                public static final class e implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$g$e$a, reason: collision with other inner class name */
                    public static final class C0884a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$g$e$a$a, reason: collision with other inner class name */
                        public static final class C0885a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C0885a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C0884a.this.a(null, this);
                            }
                        }

                        public C0884a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                                boolean r0 = r6 instanceof ir.nasim.auth.auth.newlogin.IntroActivity.l.a.g.e.C0884a.C0885a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.auth.auth.newlogin.IntroActivity$l$a$g$e$a$a r0 = (ir.nasim.auth.auth.newlogin.IntroActivity.l.a.g.e.C0884a.C0885a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.auth.auth.newlogin.IntroActivity$l$a$g$e$a$a r0 = new ir.nasim.auth.auth.newlogin.IntroActivity$l$a$g$e$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.Sw7 r5 = (ir.nasim.C7713Sw7) r5
                                java.lang.String r5 = r5.h()
                                if (r5 == 0) goto L47
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.auth.auth.newlogin.IntroActivity.l.a.g.e.C0884a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public e(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C0884a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                g(IntroActivity introActivity, C8588Wp4 c8588Wp4) {
                    this.a = introActivity;
                    this.b = c8588Wp4;
                }

                private static final String h(InterfaceC9664aL6 interfaceC9664aL6) {
                    return (String) interfaceC9664aL6.getValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i(final IntroActivity introActivity) {
                    AbstractC13042fc3.i(introActivity, "this$0");
                    introActivity.m3().H1(new SA2() { // from class: ir.nasim.auth.auth.newlogin.u
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return IntroActivity.l.a.g.k(introActivity);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 k(IntroActivity introActivity) {
                    AbstractC13042fc3.i(introActivity, "this$0");
                    introActivity.m3().d2(true);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 n(IntroActivity introActivity, final C8588Wp4 c8588Wp4) {
                    AbstractC13042fc3.i(introActivity, "this$0");
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    introActivity.m3().t2(((C7713Sw7) introActivity.m3().y1().getValue()).c(), new SA2() { // from class: ir.nasim.auth.auth.newlogin.t
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return IntroActivity.l.a.g.o(c8588Wp4);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 o(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, VI3.c.C0700c.b.a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    f((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }

                public final void f(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    InterfaceC9664aL6 interfaceC9664aL6A = AbstractC10222bH6.a(new e(this.a.m3().y1()), "", null, interfaceC22053ub1, 48, 2);
                    if (h(interfaceC9664aL6A).length() > 0) {
                        C8588Wp4 c8588Wp4 = this.b;
                        interfaceC22053ub1.W(2045486745);
                        boolean zD = interfaceC22053ub1.D(c8588Wp4);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new C0883a(c8588Wp4);
                            interfaceC22053ub1.s(objB);
                        }
                        SA2 sa2 = (SA2) objB;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(2045489592);
                        boolean zD2 = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                        final IntroActivity introActivity = this.a;
                        final C8588Wp4 c8588Wp42 = this.b;
                        Object objB2 = interfaceC22053ub1.B();
                        if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                            objB2 = new SA2() { // from class: ir.nasim.auth.auth.newlogin.r
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return IntroActivity.l.a.g.n(introActivity, c8588Wp42);
                                }
                            };
                            interfaceC22053ub1.s(objB2);
                        }
                        SA2 sa22 = (SA2) objB2;
                        interfaceC22053ub1.Q();
                        String strH = h(interfaceC9664aL6A);
                        String strC = ((C7713Sw7) AbstractC10222bH6.b(this.a.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                        C24147y73 c24147y73M3 = this.a.m3();
                        interfaceC22053ub1.W(2045510543);
                        boolean zD3 = interfaceC22053ub1.D(c24147y73M3);
                        Object objB3 = interfaceC22053ub1.B();
                        if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                            objB3 = new b(c24147y73M3);
                            interfaceC22053ub1.s(objB3);
                        }
                        interfaceC22053ub1.Q();
                        UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB3);
                        String strE = ((C7713Sw7) AbstractC10222bH6.b(this.a.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).e();
                        C24147y73 c24147y73M32 = this.a.m3();
                        interfaceC22053ub1.W(2045517424);
                        boolean zD4 = interfaceC22053ub1.D(c24147y73M32);
                        Object objB4 = interfaceC22053ub1.B();
                        if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                            objB4 = new c(c24147y73M32);
                            interfaceC22053ub1.s(objB4);
                        }
                        interfaceC22053ub1.Q();
                        UA2 ua22 = (UA2) ((InterfaceC16733lm3) objB4);
                        boolean zJ = ((C7713Sw7) AbstractC10222bH6.b(this.a.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).j();
                        interfaceC22053ub1.W(2045524982);
                        boolean zD5 = interfaceC22053ub1.D(this.a);
                        final IntroActivity introActivity2 = this.a;
                        Object objB5 = interfaceC22053ub1.B();
                        if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                            objB5 = new SA2() { // from class: ir.nasim.auth.auth.newlogin.s
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return IntroActivity.l.a.g.i(introActivity2);
                                }
                            };
                            interfaceC22053ub1.s(objB5);
                        }
                        SA2 sa23 = (SA2) objB5;
                        interfaceC22053ub1.Q();
                        int i2 = ((C7713Sw7) AbstractC10222bH6.b(this.a.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).i();
                        C24147y73 c24147y73M33 = this.a.m3();
                        interfaceC22053ub1.W(2045539632);
                        boolean zD6 = interfaceC22053ub1.D(c24147y73M33);
                        Object objB6 = interfaceC22053ub1.B();
                        if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                            objB6 = new d(c24147y73M33);
                            interfaceC22053ub1.s(objB6);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC21903uK5.d(sa2, sa22, strH, strC, ua2, strE, ua22, zJ, sa23, i2, (SA2) objB6, interfaceC22053ub1, 0, 0, 0);
                    }
                }
            }

            static final class h implements InterfaceC16978mB2 {
                final /* synthetic */ C8588Wp4 a;
                final /* synthetic */ IntroActivity b;

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$h$a, reason: collision with other inner class name */
                /* synthetic */ class C0886a extends C23553x7 implements SA2 {
                    C0886a(Object obj) {
                        super(0, obj, C8588Wp4.class, "popBackStack", "popBackStack()Z", 8);
                    }

                    public final void a() {
                        ((C8588Wp4) this.a).V();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* synthetic */ class b extends EB2 implements UA2 {
                    b(Object obj) {
                        super(1, obj, C24147y73.class, "updateSetNewPassword", "updateSetNewPassword(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C24147y73) this.receiver).j2(str);
                    }
                }

                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C24147y73.class, "updateSetNewPasswordError", "updateSetNewPasswordError(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C24147y73) this.receiver).k2(str);
                    }
                }

                h(C8588Wp4 c8588Wp4, IntroActivity introActivity) {
                    this.a = c8588Wp4;
                    this.b = introActivity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, VI3.c.a.b.a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C8588Wp4 c8588Wp4 = this.a;
                    interfaceC22053ub1.W(2045550105);
                    boolean zD = interfaceC22053ub1.D(c8588Wp4);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0886a(c8588Wp4);
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    String strD = ((C7713Sw7) AbstractC10222bH6.b(this.b.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).f().d();
                    String strC = ((C7713Sw7) AbstractC10222bH6.b(this.b.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).f().c();
                    C24147y73 c24147y73M3 = this.b.m3();
                    interfaceC22053ub1.W(2045568300);
                    boolean zD2 = interfaceC22053ub1.D(c24147y73M3);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new b(c24147y73M3);
                        interfaceC22053ub1.s(objB2);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB2;
                    interfaceC22053ub1.Q();
                    C24147y73 c24147y73M32 = this.b.m3();
                    interfaceC22053ub1.W(2045571185);
                    boolean zD3 = interfaceC22053ub1.D(c24147y73M32);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new c(c24147y73M32);
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB3;
                    interfaceC22053ub1.Q();
                    boolean zJ = ((C7713Sw7) AbstractC10222bH6.b(this.b.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).j();
                    interfaceC22053ub1.W(2045552545);
                    boolean zD4 = interfaceC22053ub1.D(this.a);
                    final C8588Wp4 c8588Wp42 = this.a;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.auth.auth.newlogin.v
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return IntroActivity.l.a.h.c(c8588Wp42);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC22248uu6.e(sa2, (SA2) objB4, strD, (UA2) interfaceC16733lm3, strC, (UA2) interfaceC16733lm32, false, null, zJ, interfaceC22053ub1, 0, 192);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    b((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            static final class i implements InterfaceC16978mB2 {
                final /* synthetic */ C8588Wp4 a;
                final /* synthetic */ IntroActivity b;

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$i$a, reason: collision with other inner class name */
                /* synthetic */ class C0887a extends C23553x7 implements SA2 {
                    C0887a(Object obj) {
                        super(0, obj, C8588Wp4.class, "popBackStack", "popBackStack()Z", 8);
                    }

                    public final void a() {
                        ((C8588Wp4) this.a).V();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* synthetic */ class b extends EB2 implements UA2 {
                    b(Object obj) {
                        super(1, obj, C24147y73.class, "updateConfirmSetNewPassword", "updateConfirmSetNewPassword(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C24147y73) this.receiver).Y1(str);
                    }
                }

                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C24147y73.class, "updateConfirmSetNewPasswordError", "updateConfirmSetNewPasswordError(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C24147y73) this.receiver).Z1(str);
                    }
                }

                i(C8588Wp4 c8588Wp4, IntroActivity introActivity) {
                    this.a = c8588Wp4;
                    this.b = introActivity;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(IntroActivity introActivity) {
                    AbstractC13042fc3.i(introActivity, "this$0");
                    introActivity.m3().R1(((C7713Sw7) introActivity.m3().y1().getValue()).d().d());
                    return C19938rB7.a;
                }

                public final void b(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C8588Wp4 c8588Wp4 = this.a;
                    interfaceC22053ub1.W(2045584729);
                    boolean zD = interfaceC22053ub1.D(c8588Wp4);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0887a(c8588Wp4);
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    String strD = ((C7713Sw7) AbstractC10222bH6.b(this.b.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).d().d();
                    String strC = ((C7713Sw7) AbstractC10222bH6.b(this.b.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).d().c();
                    C24147y73 c24147y73M3 = this.b.m3();
                    interfaceC22053ub1.W(2045607347);
                    boolean zD2 = interfaceC22053ub1.D(c24147y73M3);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new b(c24147y73M3);
                        interfaceC22053ub1.s(objB2);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB2;
                    interfaceC22053ub1.Q();
                    C24147y73 c24147y73M32 = this.b.m3();
                    interfaceC22053ub1.W(2045610456);
                    boolean zD3 = interfaceC22053ub1.D(c24147y73M32);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new c(c24147y73M32);
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB3;
                    interfaceC22053ub1.Q();
                    String strD2 = ((C7713Sw7) AbstractC10222bH6.b(this.b.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).f().d();
                    boolean zJ = ((C7713Sw7) AbstractC10222bH6.b(this.b.m3().y1(), null, interfaceC22053ub1, 0, 1).getValue()).j();
                    interfaceC22053ub1.W(2045587293);
                    boolean zD4 = interfaceC22053ub1.D(this.b);
                    final IntroActivity introActivity = this.b;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.auth.auth.newlogin.w
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return IntroActivity.l.a.i.c(introActivity);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC22248uu6.e(sa2, (SA2) objB4, strD, (UA2) interfaceC16733lm3, strC, (UA2) interfaceC16733lm32, true, strD2, zJ, interfaceC22053ub1, 1572864, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    b((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            static final class j implements InterfaceC16978mB2 {
                final /* synthetic */ IntroActivity a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.auth.auth.newlogin.IntroActivity$l$a$j$a, reason: collision with other inner class name */
                /* synthetic */ class C0888a extends EB2 implements UA2 {
                    C0888a(Object obj) {
                        super(1, obj, IntroActivity.class, "setLanguage", "setLanguage(Lir/nasim/features/settings/Language;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((EnumC9389Zs3) obj);
                        return C19938rB7.a;
                    }

                    public final void y(EnumC9389Zs3 enumC9389Zs3) {
                        AbstractC13042fc3.i(enumC9389Zs3, "p0");
                        ((IntroActivity) this.receiver).C3(enumC9389Zs3);
                    }
                }

                j(IntroActivity introActivity, C8588Wp4 c8588Wp4) {
                    this.a = introActivity;
                    this.b = c8588Wp4;
                }

                public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    EnumC9389Zs3 enumC9389Zs3K3 = this.a.k3();
                    C8588Wp4 c8588Wp4 = this.b;
                    IntroActivity introActivity = this.a;
                    interfaceC22053ub1.W(1005972972);
                    boolean zD = interfaceC22053ub1.D(introActivity);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0888a(introActivity);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC22569vT0.c(enumC9389Zs3K3, c8588Wp4, (UA2) ((InterfaceC16733lm3) objB), interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            a(IntroActivity introActivity, int i2) {
                this.a = introActivity;
                this.b = i2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.compose.animation.j i(androidx.compose.animation.d dVar) {
                AbstractC13042fc3.i(dVar, "$this$NavHost");
                return androidx.compose.animation.j.a.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.compose.animation.h k(androidx.compose.animation.d dVar) {
                AbstractC13042fc3.i(dVar, "$this$NavHost");
                return androidx.compose.animation.h.a.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(final IntroActivity introActivity, int i2, final C8588Wp4 c8588Wp4, final InterfaceC20600sH6 interfaceC20600sH6, C8120Up4 c8120Up4) {
                AbstractC13042fc3.i(introActivity, "this$0");
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                AbstractC13042fc3.i(c8120Up4, "$this$NavHost");
                AbstractC8354Vp4.c(c8120Up4, VI3.b.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(2074504797, true, new C0874a(introActivity, i2, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, VI3.e.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(510415686, true, new b(introActivity, interfaceC20600sH6)), 126, null);
                AbstractC8354Vp4.f(c8120Up4, VI3.d.b.b.a(), new VI3.d().a(), null, null, null, null, null, null, new UA2() { // from class: ir.nasim.auth.auth.newlogin.e
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return IntroActivity.l.a.o(introActivity, c8588Wp4, interfaceC20600sH6, (C8120Up4) obj);
                    }
                }, 252, null);
                AbstractC8354Vp4.c(c8120Up4, VI3.f.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(339576229, true, new f(c8588Wp4, introActivity)), 126, null);
                AbstractC8354Vp4.f(c8120Up4, VI3.c.b.b.a(), new VI3.c().a(), null, null, null, null, null, null, new UA2() { // from class: ir.nasim.auth.auth.newlogin.f
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return IntroActivity.l.a.p(introActivity, c8588Wp4, (C8120Up4) obj);
                    }
                }, 252, null);
                AbstractC8354Vp4.c(c8120Up4, VI3.a.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(168736772, true, new j(introActivity, c8588Wp4)), 126, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(IntroActivity introActivity, C8588Wp4 c8588Wp4, InterfaceC20600sH6 interfaceC20600sH6, C8120Up4 c8120Up4) {
                AbstractC13042fc3.i(introActivity, "this$0");
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                AbstractC13042fc3.i(c8120Up4, "$this$navigation");
                AbstractC8354Vp4.c(c8120Up4, VI3.d.c.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(1656375122, true, new c(introActivity, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, VI3.d.b.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(82107, true, new d(introActivity, interfaceC20600sH6, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, VI3.d.a.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1454243174, true, new e(c8588Wp4, introActivity)), 126, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(IntroActivity introActivity, C8588Wp4 c8588Wp4, C8120Up4 c8120Up4) {
                AbstractC13042fc3.i(introActivity, "this$0");
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                AbstractC13042fc3.i(c8120Up4, "$this$navigation");
                AbstractC8354Vp4.c(c8120Up4, VI3.c.b.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1880243461, true, new g(introActivity, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, VI3.c.C0700c.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(-144964060, true, new h(c8588Wp4, introActivity)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, VI3.c.a.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1887187901, true, new i(c8588Wp4, introActivity)), 126, null);
                return C19938rB7.a;
            }

            public final void h(InterfaceC22053ub1 interfaceC22053ub1, int i2) throws Resources.NotFoundException {
                if ((i2 & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final InterfaceC20600sH6 interfaceC20600sH6 = (InterfaceC20600sH6) interfaceC22053ub1.H(AbstractC13040fc1.r());
                final C8588Wp4 c8588Wp4E = AbstractC8854Xp4.e(new androidx.navigation.p[0], interfaceC22053ub1, 0);
                String strA = C13923h3.a.t() ? new VI3.d().a() : VI3.b.a.a();
                UA2 ua2E = AbstractC8216Va1.e(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(1683673081);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = new UA2() { // from class: ir.nasim.auth.auth.newlogin.b
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return IntroActivity.l.a.i((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1683675194);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.auth.auth.newlogin.c
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return IntroActivity.l.a.k((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                UA2 ua2H = AbstractC8216Va1.h(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(1683695372);
                boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.e(this.b) | interfaceC22053ub1.D(c8588Wp4E) | interfaceC22053ub1.V(interfaceC20600sH6);
                final IntroActivity introActivity = this.a;
                final int i3 = this.b;
                Object objB3 = interfaceC22053ub1.B();
                if (zD || objB3 == aVar.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.auth.auth.newlogin.d
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return IntroActivity.l.a.n(introActivity, i3, c8588Wp4E, interfaceC20600sH6, (C8120Up4) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC9129Yp4.b(c8588Wp4E, strA, null, null, null, ua2E, ua2, ua22, ua2H, (UA2) objB3, interfaceC22053ub1, 14155776, 28);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
                h((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        l(int i) {
            this.b = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(964922751, true, new a(IntroActivity.this, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.n3();
        }
    }

    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return this.e.d1();
        }
    }

    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ ComponentActivity f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(SA2 sa2, ComponentActivity componentActivity) {
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
    public final void A3() {
        m3().N1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C3(EnumC9389Zs3 language) {
        if (k3() != language) {
            Context applicationContext = getApplicationContext();
            AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
            PH3.i(applicationContext, language.toString());
            if (Build.VERSION.SDK_INT < 33) {
                recreate();
            }
        }
    }

    private final void D3(boolean isLight) {
        if (Build.VERSION.SDK_INT < 31) {
            androidx.appcompat.app.b.N(isLight ? 1 : 2);
            return;
        }
        UiModeManager uiModeManager = (UiModeManager) AbstractC4043Dl1.l(this, UiModeManager.class);
        if (uiModeManager != null) {
            uiModeManager.setApplicationNightMode(isLight ? 1 : 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E3(final UA2 onCodeRetriever) {
        Task taskZ = SF6.a(this).z();
        final UA2 ua2 = new UA2() { // from class: ir.nasim.sc3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return IntroActivity.F3(this.a, onCodeRetriever, (Void) obj);
            }
        };
        taskZ.f(new InterfaceC13497gK4() { // from class: ir.nasim.tc3
            @Override // ir.nasim.InterfaceC13497gK4
            public final void onSuccess(Object obj) {
                IntroActivity.H3(ua2, obj);
            }
        }).d(new InterfaceC14681iJ4() { // from class: ir.nasim.uc3
            @Override // ir.nasim.InterfaceC14681iJ4
            public final void a(Exception exc) {
                IntroActivity.K3(this.a, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F3(IntroActivity introActivity, UA2 ua2, Void r2) {
        AbstractC13042fc3.i(introActivity, "this$0");
        AbstractC13042fc3.i(ua2, "$onCodeRetriever");
        SMSRetrieverBroadcastReceiver.INSTANCE.a(introActivity.e3(ua2));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H3(UA2 ua2, Object obj) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K3(IntroActivity introActivity, Exception exc) {
        String name;
        AbstractC13042fc3.i(introActivity, "this$0");
        AbstractC13042fc3.i(exc, "it");
        if (introActivity.getClass().isAnonymousClass()) {
            name = IntroActivity.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = IntroActivity.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.d(name, exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TelephonyManager L3(IntroActivity introActivity) {
        AbstractC13042fc3.i(introActivity, "this$0");
        Object systemService = introActivity.getSystemService("phone");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        return (TelephonyManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M3(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V2(int theme, Configuration configuration) {
        if (theme == 2) {
            C5495Jo7.K2(1, this);
            C7183Qq.q(EnumC18608ow5.d).putInt("Theme_Pref", 1);
            D3(false);
            configuration.uiMode = 16;
        } else {
            C5495Jo7.K2(2, this);
            C7183Qq.q(EnumC18608ow5.d).putInt("Theme_Pref", 2);
            D3(true);
            configuration.uiMode = 32;
        }
        getApplicationContext().getResources().getConfiguration().setTo(configuration);
        recreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W2(C24147y73 initPhoneNumberViewModel, InterfaceC20600sH6 keyboardController) {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new b(initPhoneNumberViewModel, keyboardController, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X2(C24147y73 initPhoneNumberViewModel, androidx.navigation.e navController) {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new c(initPhoneNumberViewModel, navController, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y2(C24147y73 initPhoneNumberViewModel, androidx.navigation.e navController) {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new d(initPhoneNumberViewModel, navController, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z2(C24147y73 initPhoneNumberViewModel, androidx.navigation.e navController) {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new e(initPhoneNumberViewModel, navController, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a3(C15218jC6 viewModel, InterfaceC20600sH6 keyboardController) {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new f(viewModel, keyboardController, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b3(C24147y73 initPhoneNumberViewModel, androidx.navigation.e navController) {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new g(initPhoneNumberViewModel, navController, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c3(C24147y73 initPhoneNumberViewModel) {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new h(initPhoneNumberViewModel, this, null), 3, null);
    }

    private final void d3(C24147y73 initPhoneNumberViewModel) {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new i(initPhoneNumberViewModel, this, null), 3, null);
    }

    private final j e3(UA2 onCodeRetriever) {
        return new j(onCodeRetriever);
    }

    private final void f3(String ussdCode, UA2 validate) {
        String name;
        InterfaceC9173Yu3 interfaceC9173Yu3A = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rc3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return IntroActivity.g3(this.a);
            }
        });
        Handler handler = new Handler();
        Iterator it = h3(interfaceC9173Yu3A).iterator();
        while (it.hasNext()) {
            try {
                t3().createForSubscriptionId(((SubscriptionInfo) it.next()).getSubscriptionId()).sendUssdRequest(ussdCode, AbstractC16633lc3.a(new k(validate)), handler);
            } catch (Exception e2) {
                if (IntroActivity.class.isAnonymousClass()) {
                    name = IntroActivity.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = IntroActivity.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.b(name, e2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g3(IntroActivity introActivity) {
        AbstractC13042fc3.i(introActivity, "this$0");
        if (AbstractC4043Dl1.a(introActivity, "android.permission.READ_PHONE_STATE") != 0) {
            return AbstractC10360bX0.m();
        }
        Object systemService = introActivity.getSystemService("telephony_subscription_service");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.telephony.SubscriptionManager");
        List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) systemService).getActiveSubscriptionInfoList();
        return activeSubscriptionInfoList == null ? AbstractC10360bX0.m() : activeSubscriptionInfoList;
    }

    private static final List h3(InterfaceC9173Yu3 interfaceC9173Yu3) {
        return (List) interfaceC9173Yu3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i3(String message) {
        String string = getString(AbstractC24206yD5.banking_input_acceptable_digits);
        AbstractC13042fc3.h(string, "getString(...)");
        Matcher matcher = Pattern.compile("\\b([" + string + "]{6})\\b").matcher(message);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EnumC9389Zs3 k3() {
        String strD = PH3.d();
        EnumC9389Zs3 enumC9389Zs3 = EnumC9389Zs3.b;
        if (AbstractC13042fc3.d(strD, enumC9389Zs3.toString())) {
            return enumC9389Zs3;
        }
        EnumC9389Zs3 enumC9389Zs32 = EnumC9389Zs3.d;
        if (AbstractC13042fc3.d(strD, enumC9389Zs32.toString())) {
            return enumC9389Zs32;
        }
        EnumC9389Zs3 enumC9389Zs33 = EnumC9389Zs3.c;
        return AbstractC13042fc3.d(strD, enumC9389Zs33.toString()) ? enumC9389Zs33 : EnumC9389Zs3.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C24147y73 m3() {
        return (C24147y73) this.initPhoneNumberViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o3() {
        if (AbstractC4043Dl1.a(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            C21753u45.O0(C21753u45.a, this, 13, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
        } else {
            w3();
        }
    }

    private final TelephonyManager t3() {
        return (TelephonyManager) this.telephonyManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u3(IntroActivity introActivity, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(introActivity, "this$0");
        introActivity.finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void v3() {
        /*
            r3 = this;
            java.lang.String r0 = r3.externalFile
            if (r0 == 0) goto L24
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            java.lang.String r0 = r3.getPackageName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = ".provider"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.net.Uri r0 = androidx.core.content.FileProvider.h(r3, r0, r1)
            if (r0 != 0) goto L26
        L24:
            android.net.Uri r0 = android.net.Uri.EMPTY
        L26:
            ir.nasim.iN3 r1 = r3.launcherPickPhotoFromCamera
            if (r1 == 0) goto L30
            ir.nasim.AbstractC13042fc3.f(r0)
            r1.a(r0)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.auth.auth.newlogin.IntroActivity.v3():void");
    }

    private final void w3() {
        y.Companion companion = y.INSTANCE;
        com.google.android.material.bottomsheet.b bVarB = InterfaceC15814kD2.b(l3(), AbstractC5969Lp4.f(), ExPeerType.GROUP, "GALLERY_RES_KEY", new TC2.a(false, false, false, null, 15, null), false, 16, null);
        FragmentManager fragmentManagerB0 = B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        companion.b(bVarB, fragmentManagerB0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y3(String code, UA2 validate) {
        this.ussdCode = code;
        if (AbstractC4043Dl1.a(this, "android.permission.CALL_PHONE") != 0 || AbstractC4043Dl1.a(this, "android.permission.READ_PHONE_STATE") != 0) {
            C21753u45.O0(C21753u45.a, this, 1978, null, new C21753u45.d[]{C21753u45.d.q, C21753u45.d.r}, 4, null);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            z3(validate);
            return;
        }
        String str = this.ussdCode;
        if (str != null) {
            AbstractC20507s76.b(str);
        }
    }

    private final void z3(UA2 validate) {
        String str;
        if (t3().getSimState() != 5 || (str = this.ussdCode) == null) {
            return;
        }
        f3(str, validate);
    }

    public final InterfaceC15814kD2 l3() {
        InterfaceC15814kD2 interfaceC15814kD2 = this.galleryNavigator;
        if (interfaceC15814kD2 != null) {
            return interfaceC15814kD2;
        }
        AbstractC13042fc3.y("galleryNavigator");
        return null;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        C6011Lu2.m(this);
        PH3.h(this);
        getWindow().setStatusBarColor(AbstractC4043Dl1.c(this, RA5.background));
        getWindow().setNavigationBarColor(AbstractC4043Dl1.c(this, RA5.background));
        AbstractC19329q98.b(getWindow(), true);
        super.onCreate(savedInstanceState);
        int iL1 = C5495Jo7.l1(this);
        d3(m3());
        View decorView = getWindow().getDecorView();
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        decorView.setSystemUiVisibility(C5495Jo7.a.J2() ? systemUiVisibility & (-8193) : systemUiVisibility | 8192);
        if (AbstractC19662qj7.a(getApplication()) || (AbstractC21784u76.d() && !AbstractC21784u76.b() && ((C15721k36) r3().get()).r())) {
            if (AbstractC21784u76.a()) {
                return;
            } else {
                new AlertDialog.a(this).m(getString(AbstractC12217eE5.no_browser_founded_title)).i(getString(AbstractC12217eE5.error_tamper)).d(false, false).l(getString(AbstractC12217eE5.dialog_ok), new DialogInterface.OnClickListener() { // from class: ir.nasim.qc3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        IntroActivity.u3(this.a, dialogInterface, i2);
                    }
                }).a().show();
            }
        }
        R01.b(this, null, AbstractC19242q11.c(255967364, true, new l(iL1)), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a8  */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onNewIntent(android.content.Intent r25) {
        /*
            r24 = this;
            java.lang.String r0 = "intent"
            r1 = r25
            ir.nasim.AbstractC13042fc3.i(r1, r0)
            android.net.Uri r0 = r25.getData()
            if (r0 == 0) goto Lae
            java.lang.String r2 = r0.toString()
            java.lang.String r3 = "toString(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r3)
            r3 = 2
            r4 = 0
            java.lang.String r5 = "/sign-up/from-telegram/"
            r6 = 0
            boolean r2 = ir.nasim.AbstractC14836iZ6.X(r2, r5, r6, r3, r4)
            if (r2 == 0) goto La8
            java.lang.String r2 = r0.getLastPathSegment()
            java.lang.String r3 = "-1"
            boolean r2 = ir.nasim.AbstractC13042fc3.d(r2, r3)
            if (r2 != 0) goto La8
            ir.nasim.y73 r2 = r24.m3()
            ir.nasim.bL6 r2 = r2.A1()
            java.lang.Object r2 = r2.getValue()
            ir.nasim.yP7 r2 = (ir.nasim.C24316yP7) r2
            java.lang.String r2 = r2.l()
            int r2 = r2.length()
            if (r2 != 0) goto L94
            ir.nasim.y73 r2 = r24.m3()
            ir.nasim.yP7 r15 = new ir.nasim.yP7
            r3 = r15
            android.content.Context r4 = r24.getApplicationContext()
            int r5 = ir.nasim.AbstractC12217eE5.ussd_validation_text
            ir.nasim.y73 r6 = r24.m3()
            java.lang.String r6 = r6.w1()
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r4 = r4.getString(r5, r6)
            java.lang.String r5 = "getString(...)"
            ir.nasim.AbstractC13042fc3.h(r4, r5)
            java.lang.String r5 = ir.nasim.AbstractC12152e76.b(r4)
            int r4 = ir.nasim.KB5.sms_login
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r21 = 32761(0x7ff9, float:4.5908E-41)
            r22 = 0
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r16 = 0
            r23 = r15
            r15 = r16
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r18, r19, r20, r21, r22)
            r3 = r23
            r2.g2(r3)
        L94:
            java.lang.String r0 = r0.getLastPathSegment()
            if (r0 == 0) goto La8
            java.lang.String r0 = ir.nasim.ZY6.a(r0)
            if (r0 == 0) goto La8
            r2 = r24
            ir.nasim.UA2 r3 = r2.validateCode
            r3.invoke(r0)
            goto Laa
        La8:
            r2 = r24
        Laa:
            super.onNewIntent(r25)
            goto Lb0
        Lae:
            r2 = r24
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.auth.auth.newlogin.IntroActivity.onNewIntent(android.content.Intent):void");
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 12) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                v3();
                return;
            }
            return;
        }
        if (requestCode == 13) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                w3();
                return;
            }
            return;
        }
        if (requestCode != 1978) {
            return;
        }
        if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
            if (Build.VERSION.SDK_INT >= 26) {
                z3(this.validateCode);
                return;
            }
            String str = this.ussdCode;
            if (str != null) {
                AbstractC20507s76.b(str);
            }
        }
    }

    public final InterfaceC8898Xu3 r3() {
        InterfaceC8898Xu3 interfaceC8898Xu3 = this.rootBeer;
        if (interfaceC8898Xu3 != null) {
            return interfaceC8898Xu3;
        }
        AbstractC13042fc3.y("rootBeer");
        return null;
    }
}
