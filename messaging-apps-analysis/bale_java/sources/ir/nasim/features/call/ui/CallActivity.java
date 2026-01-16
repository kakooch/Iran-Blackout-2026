package ir.nasim.features.call.ui;

import android.R;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.Icon;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Rational;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.x;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13040fc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13837gu0;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC18583ou0;
import ir.nasim.AbstractC19174pu0;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19329q98;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC22357v6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9220Yz5;
import ir.nasim.C11458d25;
import ir.nasim.C12767fA0;
import ir.nasim.C14819iX7;
import ir.nasim.C17448mz0;
import ir.nasim.C17468n10;
import ir.nasim.C18039nz0;
import ir.nasim.C18987pb3;
import ir.nasim.C19406qI3;
import ir.nasim.C19598qd3;
import ir.nasim.C19938rB7;
import ir.nasim.C20384rv0;
import ir.nasim.C20490s6;
import ir.nasim.C21753u45;
import ir.nasim.C24939zT0;
import ir.nasim.C4858Gw0;
import ir.nasim.C5721Ko;
import ir.nasim.C7252Qx5;
import ir.nasim.C8386Vt0;
import ir.nasim.C9215Yz0;
import ir.nasim.EB2;
import ir.nasim.ED1;
import ir.nasim.EnumC12613eu3;
import ir.nasim.EnumC25128zm6;
import ir.nasim.EnumC4196Ec1;
import ir.nasim.G35;
import ir.nasim.HG1;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16733lm3;
import ir.nasim.InterfaceC17517n6;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC22976w82;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5812Ky0;
import ir.nasim.InterfaceC6775Ox6;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J35;
import ir.nasim.KB5;
import ir.nasim.M10;
import ir.nasim.NY;
import ir.nasim.OM4;
import ir.nasim.R01;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UY6;
import ir.nasim.features.call.ui.CallActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u0002:\u0002\u0083\u0001B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b0\u0010/J\u0017\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0005H\u0002¢\u0006\u0004\b5\u0010\u0004J\u000f\u00106\u001a\u00020\u0005H\u0002¢\u0006\u0004\b6\u0010\u0004J\u000f\u00108\u001a\u000207H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u000207H\u0002¢\u0006\u0004\b:\u00109J\u000f\u0010;\u001a\u00020\u0005H\u0003¢\u0006\u0004\b;\u0010\u0004J\u000f\u0010<\u001a\u00020\u0005H\u0002¢\u0006\u0004\b<\u0010\u0004J\u000f\u0010=\u001a\u00020\u0005H\u0002¢\u0006\u0004\b=\u0010\u0004J\u000f\u0010>\u001a\u00020\u0005H\u0002¢\u0006\u0004\b>\u0010\u0004J\u000f\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\b?\u0010\u0004J\u0017\u0010B\u001a\u00020\u00052\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u0019\u0010F\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010DH\u0014¢\u0006\u0004\bF\u0010GJ-\u0010M\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00072\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0I2\u0006\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0005H\u0014¢\u0006\u0004\bO\u0010\u0004J\u000f\u0010P\u001a\u00020\u0005H\u0016¢\u0006\u0004\bP\u0010\u0004J\u000f\u0010Q\u001a\u00020\u0005H\u0014¢\u0006\u0004\bQ\u0010\u0004J\u001f\u0010U\u001a\u00020\u00052\u0006\u0010R\u001a\u0002072\u0006\u0010T\u001a\u00020SH\u0017¢\u0006\u0004\bU\u0010VR\"\u0010^\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010f\u001a\u00020_8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001b\u0010l\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u001b\u0010q\u001a\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010i\u001a\u0004\bo\u0010pR\u001b\u0010v\u001a\u00020r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010i\u001a\u0004\bt\u0010uR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020@0w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b|\u0010}R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001¨\u0006\u0084\u0001"}, d2 = {"Lir/nasim/features/call/ui/CallActivity;", "Lir/nasim/designsystem/base/activity/BaseFragmentActivity;", "", "<init>", "()V", "Lir/nasim/rB7;", "Z2", "", "userId", "E3", "(I)V", "", ParameterNames.TEXT, "d3", "(Ljava/lang/String;)V", "userIdentity", "userName", "O3", "(Ljava/lang/String;Ljava/lang/String;)V", "Lir/nasim/mz0$a;", "callState", "b3", "(Lir/nasim/mz0$a;)V", "m3", "()Ljava/lang/Integer;", "", "delay", "g3", "(J)V", "Lir/nasim/OM4;", "reason", "v3", "(Lir/nasim/OM4;)V", "Lir/nasim/gj3;", "z3", "()Lir/nasim/gj3;", "Lir/nasim/J35;", "permissionState", "w3", "(Lir/nasim/J35;)V", "Lir/nasim/J35$a;", "permission", "P3", "(Lir/nasim/J35$a;)V", "Lir/nasim/u45$d;", "permissionType", "F3", "(Lir/nasim/u45$d;)V", "V3", "Lir/nasim/zm6;", "currentDevice", "A3", "(Lir/nasim/zm6;)V", "D3", "U3", "", "f3", "()Z", "y3", "e3", "a3", "c3", "N3", "C3", "Landroid/content/Intent;", "intent", "u3", "(Landroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onStop", "onBackPressed", "onUserLeaveHint", "isInPictureInPictureMode", "Landroid/content/res/Configuration;", "newConfig", "onPictureInPictureModeChanged", "(ZLandroid/content/res/Configuration;)V", "Lir/nasim/Ky0;", "L0", "Lir/nasim/Ky0;", "i3", "()Lir/nasim/Ky0;", "setCallScreen", "(Lir/nasim/Ky0;)V", "callScreen", "Lir/nasim/w82;", "M0", "Lir/nasim/w82;", "k3", "()Lir/nasim/w82;", "setEndGroupCallDialogNavigator", "(Lir/nasim/w82;)V", "endGroupCallDialogNavigator", "Lir/nasim/fA0;", "N0", "Lir/nasim/Yu3;", "r3", "()Lir/nasim/fA0;", "viewModel", "Lir/nasim/zT0;", "O0", "o3", "()Lir/nasim/zT0;", "speakerBottomSheet", "Lir/nasim/n10;", "P0", "t3", "()Lir/nasim/n10;", "voiceCallErrorsSnackBar", "Lir/nasim/v6;", "Q0", "Lir/nasim/v6;", "screenCaptureIntentLauncher", "Landroid/content/ClipboardManager;", "R0", "Landroid/content/ClipboardManager;", "clipboard", "S0", "Lir/nasim/gj3;", "finishActivityJob", "T0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class CallActivity extends Hilt_CallActivity {

    /* renamed from: T0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int U0 = 8;

    /* renamed from: L0, reason: from kotlin metadata */
    public InterfaceC5812Ky0 callScreen;

    /* renamed from: M0, reason: from kotlin metadata */
    public InterfaceC22976w82 endGroupCallDialogNavigator;

    /* renamed from: N0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = new F(AbstractC10882cM5.b(C12767fA0.class), new h(this), new g(this), new i(null, this));

    /* renamed from: O0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 speakerBottomSheet = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.yu0
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return CallActivity.d4(this.a);
        }
    });

    /* renamed from: P0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 voiceCallErrorsSnackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.zu0
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return CallActivity.g4(this.a);
        }
    });

    /* renamed from: Q0, reason: from kotlin metadata */
    private final AbstractC22357v6 screenCaptureIntentLauncher = t0(new C20490s6(), new InterfaceC17517n6() { // from class: ir.nasim.Au0
        @Override // ir.nasim.InterfaceC17517n6
        public final void a(Object obj) {
            CallActivity.M3(this.a, (ActivityResult) obj);
        }
    });

    /* renamed from: R0, reason: from kotlin metadata */
    private ClipboardManager clipboard;

    /* renamed from: S0, reason: from kotlin metadata */
    private InterfaceC13730gj3 finishActivityJob;

    /* renamed from: ir.nasim.features.call.ui.CallActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final Intent a(Context context) {
            AbstractC13042fc3.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) CallActivity.class);
            intent.setFlags(402653184);
            return intent;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C21753u45.d.values().length];
            try {
                iArr[C21753u45.d.s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C21753u45.d.f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C21753u45.d.u.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[C21753u45.d.v.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[C21753u45.d.w.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    static final class c implements InterfaceC14603iB2 {

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ CallActivity a;

            /* renamed from: ir.nasim.features.call.ui.CallActivity$c$a$a, reason: collision with other inner class name */
            static final class C1154a implements InterfaceC14603iB2 {
                final /* synthetic */ CallActivity a;

                /* renamed from: ir.nasim.features.call.ui.CallActivity$c$a$a$a, reason: collision with other inner class name */
                /* synthetic */ class C1155a extends EB2 implements UA2 {
                    C1155a(Object obj) {
                        super(1, obj, CallActivity.class, "openBottomSheet", "openBottomSheet(Lir/nasim/features/call/audioManager/SelectableAudioDevice;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((EnumC25128zm6) obj);
                        return C19938rB7.a;
                    }

                    public final void y(EnumC25128zm6 enumC25128zm6) {
                        AbstractC13042fc3.i(enumC25128zm6, "p0");
                        ((CallActivity) this.receiver).A3(enumC25128zm6);
                    }
                }

                /* renamed from: ir.nasim.features.call.ui.CallActivity$c$a$a$b */
                /* synthetic */ class b extends EB2 implements SA2 {
                    b(Object obj) {
                        super(0, obj, CallActivity.class, "openInvite", "openInvite()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((CallActivity) this.receiver).D3();
                    }
                }

                /* renamed from: ir.nasim.features.call.ui.CallActivity$c$a$a$c, reason: collision with other inner class name */
                /* synthetic */ class C1156c extends EB2 implements UA2 {
                    C1156c(Object obj) {
                        super(1, obj, CallActivity.class, "handleOutGoingFailures", "handleOutGoingFailures(Lir/nasim/features/call/data/OutGoingCallFailure;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((OM4) obj);
                        return C19938rB7.a;
                    }

                    public final void y(OM4 om4) {
                        ((CallActivity) this.receiver).v3(om4);
                    }
                }

                /* renamed from: ir.nasim.features.call.ui.CallActivity$c$a$a$d */
                /* synthetic */ class d extends EB2 implements UA2 {
                    d(Object obj) {
                        super(1, obj, CallActivity.class, "openUserChat", "openUserChat(I)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y(((Number) obj).intValue());
                        return C19938rB7.a;
                    }

                    public final void y(int i) {
                        ((CallActivity) this.receiver).E3(i);
                    }
                }

                /* renamed from: ir.nasim.features.call.ui.CallActivity$c$a$a$e */
                /* synthetic */ class e extends EB2 implements InterfaceC14603iB2 {
                    e(Object obj) {
                        super(2, obj, CallActivity.class, "showKickUserDialog", "showKickUserDialog(Ljava/lang/String;Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        y((String) obj, (String) obj2);
                        return C19938rB7.a;
                    }

                    public final void y(String str, String str2) {
                        AbstractC13042fc3.i(str, "p0");
                        AbstractC13042fc3.i(str2, "p1");
                        ((CallActivity) this.receiver).O3(str, str2);
                    }
                }

                /* renamed from: ir.nasim.features.call.ui.CallActivity$c$a$a$f */
                /* synthetic */ class f extends EB2 implements SA2 {
                    f(Object obj) {
                        super(0, obj, CallActivity.class, "copyCallLink", "copyCallLink()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((CallActivity) this.receiver).c3();
                    }
                }

                /* renamed from: ir.nasim.features.call.ui.CallActivity$c$a$a$g */
                /* synthetic */ class g extends EB2 implements SA2 {
                    g(Object obj) {
                        super(0, obj, CallActivity.class, "shareLink", "shareLink()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((CallActivity) this.receiver).N3();
                    }
                }

                /* renamed from: ir.nasim.features.call.ui.CallActivity$c$a$a$h */
                /* synthetic */ class h extends EB2 implements UA2 {
                    h(Object obj) {
                        super(1, obj, CallActivity.class, "copyToClipBoard", "copyToClipBoard(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((CallActivity) this.receiver).d3(str);
                    }
                }

                C1154a(CallActivity callActivity) {
                    this.a = callActivity;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    InterfaceC5812Ky0 interfaceC5812Ky0I3 = this.a.i3();
                    InterfaceC10258bL6 interfaceC10258bL6D = C18039nz0.a.d();
                    CallActivity callActivity = this.a;
                    interfaceC22053ub1.W(127791463);
                    boolean zD = interfaceC22053ub1.D(callActivity);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C1155a(callActivity);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB);
                    CallActivity callActivity2 = this.a;
                    interfaceC22053ub1.W(127792834);
                    boolean zD2 = interfaceC22053ub1.D(callActivity2);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new b(callActivity2);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB2);
                    Integer numM3 = this.a.m3();
                    CallActivity callActivity3 = this.a;
                    interfaceC22053ub1.W(127795374);
                    boolean zD3 = interfaceC22053ub1.D(callActivity3);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new C1156c(callActivity3);
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua22 = (UA2) ((InterfaceC16733lm3) objB3);
                    CallActivity callActivity4 = this.a;
                    interfaceC22053ub1.W(127796964);
                    boolean zD4 = interfaceC22053ub1.D(callActivity4);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new d(callActivity4);
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua23 = (UA2) ((InterfaceC16733lm3) objB4);
                    CallActivity callActivity5 = this.a;
                    interfaceC22053ub1.W(127798250);
                    boolean zD5 = interfaceC22053ub1.D(callActivity5);
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                        objB5 = new e(callActivity5);
                        interfaceC22053ub1.s(objB5);
                    }
                    interfaceC22053ub1.Q();
                    InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) ((InterfaceC16733lm3) objB5);
                    CallActivity callActivity6 = this.a;
                    interfaceC22053ub1.W(127799716);
                    boolean zD6 = interfaceC22053ub1.D(callActivity6);
                    Object objB6 = interfaceC22053ub1.B();
                    if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                        objB6 = new f(callActivity6);
                        interfaceC22053ub1.s(objB6);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa22 = (SA2) ((InterfaceC16733lm3) objB6);
                    CallActivity callActivity7 = this.a;
                    interfaceC22053ub1.W(127800993);
                    boolean zD7 = interfaceC22053ub1.D(callActivity7);
                    Object objB7 = interfaceC22053ub1.B();
                    if (zD7 || objB7 == InterfaceC22053ub1.a.a()) {
                        objB7 = new g(callActivity7);
                        interfaceC22053ub1.s(objB7);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa23 = (SA2) ((InterfaceC16733lm3) objB7);
                    CallActivity callActivity8 = this.a;
                    interfaceC22053ub1.W(127802183);
                    boolean zD8 = interfaceC22053ub1.D(callActivity8);
                    Object objB8 = interfaceC22053ub1.B();
                    if (zD8 || objB8 == InterfaceC22053ub1.a.a()) {
                        objB8 = new h(callActivity8);
                        interfaceC22053ub1.s(objB8);
                    }
                    interfaceC22053ub1.Q();
                    interfaceC5812Ky0I3.a(interfaceC10258bL6D, ua2, sa2, numM3, ua22, ua23, interfaceC14603iB2, sa22, sa23, (UA2) ((InterfaceC16733lm3) objB8), interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(CallActivity callActivity) {
                this.a = callActivity;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-151373710, true, new C1154a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-431443022, true, new a(CallActivity.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ CallActivity d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, CallActivity callActivity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = callActivity;
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
                long j = this.c;
                this.b = 1;
                if (HG1.b(j, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            if (!this.d.isFinishing()) {
                this.d.finish();
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
        private /* synthetic */ Object c;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallActivity c;

            /* renamed from: ir.nasim.features.call.ui.CallActivity$e$a$a, reason: collision with other inner class name */
            static final class C1157a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                private /* synthetic */ Object c;
                final /* synthetic */ CallActivity d;

                /* renamed from: ir.nasim.features.call.ui.CallActivity$e$a$a$a, reason: collision with other inner class name */
                static final class C1158a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ CallActivity c;

                    /* renamed from: ir.nasim.features.call.ui.CallActivity$e$a$a$a$a, reason: collision with other inner class name */
                    static final class C1159a implements InterfaceC4806Gq2 {
                        final /* synthetic */ CallActivity a;

                        C1159a(CallActivity callActivity) {
                            this.a = callActivity;
                        }

                        @Override // ir.nasim.InterfaceC4806Gq2
                        /* renamed from: b, reason: merged with bridge method [inline-methods] */
                        public final Object a(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                            this.a.b3(c17448mz0.e());
                            return C19938rB7.a;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1158a(CallActivity callActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = callActivity;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1158a(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            InterfaceC10258bL6 interfaceC10258bL6D = C18039nz0.a.d();
                            C1159a c1159a = new C1159a(this.c);
                            this.b = 1;
                            if (interfaceC10258bL6D.b(c1159a, this) == objE) {
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
                        return ((C1158a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.features.call.ui.CallActivity$e$a$a$b */
                static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ CallActivity c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    b(CallActivity callActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = callActivity;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new b(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        this.c.a3();
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.features.call.ui.CallActivity$e$a$a$c */
                static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ CallActivity c;

                    /* renamed from: ir.nasim.features.call.ui.CallActivity$e$a$a$c$a, reason: collision with other inner class name */
                    static final class C1160a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        /* synthetic */ Object c;
                        final /* synthetic */ CallActivity d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C1160a(CallActivity callActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.d = callActivity;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            C1160a c1160a = new C1160a(this.d, interfaceC20295rm1);
                            c1160a.c = obj;
                            return c1160a;
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            AbstractC14862ic3.e();
                            if (this.b != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                            this.d.w3((J35) this.c);
                            return C19938rB7.a;
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        /* renamed from: n, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(J35 j35, InterfaceC20295rm1 interfaceC20295rm1) {
                            return ((C1160a) create(j35, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* renamed from: ir.nasim.features.call.ui.CallActivity$e$a$a$c$b */
                    public static final class b implements InterfaceC4557Fq2 {
                        final /* synthetic */ InterfaceC4557Fq2 a;

                        /* renamed from: ir.nasim.features.call.ui.CallActivity$e$a$a$c$b$a, reason: collision with other inner class name */
                        public static final class C1161a implements InterfaceC4806Gq2 {
                            final /* synthetic */ InterfaceC4806Gq2 a;

                            /* renamed from: ir.nasim.features.call.ui.CallActivity$e$a$a$c$b$a$a, reason: collision with other inner class name */
                            public static final class C1162a extends AbstractC22163um1 {
                                /* synthetic */ Object a;
                                int b;

                                public C1162a(InterfaceC20295rm1 interfaceC20295rm1) {
                                    super(interfaceC20295rm1);
                                }

                                @Override // ir.nasim.E90
                                public final Object invokeSuspend(Object obj) {
                                    this.a = obj;
                                    this.b |= RecyclerView.UNDEFINED_DURATION;
                                    return C1161a.this.a(null, this);
                                }
                            }

                            public C1161a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                                    boolean r0 = r6 instanceof ir.nasim.features.call.ui.CallActivity.e.a.C1157a.c.b.C1161a.C1162a
                                    if (r0 == 0) goto L13
                                    r0 = r6
                                    ir.nasim.features.call.ui.CallActivity$e$a$a$c$b$a$a r0 = (ir.nasim.features.call.ui.CallActivity.e.a.C1157a.c.b.C1161a.C1162a) r0
                                    int r1 = r0.b
                                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                    r3 = r1 & r2
                                    if (r3 == 0) goto L13
                                    int r1 = r1 - r2
                                    r0.b = r1
                                    goto L18
                                L13:
                                    ir.nasim.features.call.ui.CallActivity$e$a$a$c$b$a$a r0 = new ir.nasim.features.call.ui.CallActivity$e$a$a$c$b$a$a
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
                                    ir.nasim.Yz0 r5 = (ir.nasim.C9215Yz0) r5
                                    ir.nasim.J35 r5 = r5.j()
                                    if (r5 == 0) goto L47
                                    r0.b = r3
                                    java.lang.Object r5 = r6.a(r5, r0)
                                    if (r5 != r1) goto L47
                                    return r1
                                L47:
                                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                    return r5
                                */
                                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.ui.CallActivity.e.a.C1157a.c.b.C1161a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                            }
                        }

                        public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                            this.a = interfaceC4557Fq2;
                        }

                        @Override // ir.nasim.InterfaceC4557Fq2
                        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                            Object objB = this.a.b(new C1161a(interfaceC4806Gq2), interfaceC20295rm1);
                            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    c(CallActivity callActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = callActivity;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new c(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new b(this.c.r3().I1()));
                            C1160a c1160a = new C1160a(this.c, null);
                            this.b = 1;
                            if (AbstractC6459Nq2.l(interfaceC4557Fq2V, c1160a, this) == objE) {
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

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1157a(CallActivity callActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = callActivity;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1157a c1157a = new C1157a(this.d, interfaceC20295rm1);
                    c1157a.c = obj;
                    return c1157a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1158a(this.d, null), 3, null);
                    AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(this.d, null), 3, null);
                    AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c(this.d, null), 3, null);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1157a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(CallActivity callActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    CallActivity callActivity = this.c;
                    j.b bVar = j.b.STARTED;
                    C1157a c1157a = new C1157a(callActivity, null);
                    this.b = 1;
                    if (w.b(callActivity, bVar, c1157a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ CallActivity d;

            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ CallActivity c;

                /* renamed from: ir.nasim.features.call.ui.CallActivity$e$b$a$a, reason: collision with other inner class name */
                static final class C1163a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;
                    final /* synthetic */ CallActivity d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1163a(CallActivity callActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = callActivity;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1163a c1163a = new C1163a(this.d, interfaceC20295rm1);
                        c1163a.c = obj;
                        return c1163a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        if (((C9215Yz0) this.c).t()) {
                            this.d.C3();
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(C9215Yz0 c9215Yz0, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1163a) create(c9215Yz0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(CallActivity callActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = callActivity;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC10258bL6 interfaceC10258bL6I1 = this.c.r3().I1();
                        C1163a c1163a = new C1163a(this.c, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC10258bL6I1, c1163a, this) == objE) {
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
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.features.call.ui.CallActivity$e$b$b, reason: collision with other inner class name */
            static final class C1164b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;

                C1164b(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1164b(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    C20384rv0.a.t();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1164b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(CallActivity callActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = callActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
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
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(this.d, null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1164b(null), 3, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = CallActivity.this.new e(interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new a(CallActivity.this, null), 3, null);
                CallActivity callActivity = CallActivity.this;
                j.b bVar = j.b.RESUMED;
                b bVar2 = new b(callActivity, null);
                this.b = 1;
                if (w.b(callActivity, bVar, bVar2, this) == objE) {
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

    static final class f implements InterfaceC15796kB2 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ CallActivity a;

            a(CallActivity callActivity) {
                this.a = callActivity;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String string = this.a.getString(AbstractC12217eE5.kick_user_dialog_title);
                AbstractC13042fc3.h(string, "getString(...)");
                AbstractC19555qZ.B0(string, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ CallActivity a;
            final /* synthetic */ String b;

            b(CallActivity callActivity, String str) {
                this.a = callActivity;
                this.b = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String string = this.a.getString(AbstractC12217eE5.kick_user_dialog_description, this.b);
                AbstractC13042fc3.h(string, "getString(...)");
                AbstractC19555qZ.e0(string, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        f(String str, String str2) {
            this.b = str;
            this.c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(CallActivity callActivity, String str, Dialog dialog, boolean z) {
            AbstractC13042fc3.i(callActivity, "this$0");
            AbstractC13042fc3.i(str, "$userIdentity");
            AbstractC13042fc3.i(dialog, "$dialog");
            callActivity.r3().a2(str, z);
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
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            String string = CallActivity.this.getString(AbstractC12217eE5.kick_user_dialog_kick_btn);
            AbstractC13042fc3.h(string, "getString(...)");
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC = UY6.c(AbstractC12217eE5.dialog_cancel, interfaceC22053ub1, 0);
            String strC2 = UY6.c(AbstractC12217eE5.kick_user_dialog_check_box, interfaceC22053ub1, 0);
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1548517122, true, new a(CallActivity.this), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-1765699392, true, new b(CallActivity.this, this.c), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(760685162);
            boolean zD = interfaceC22053ub1.D(CallActivity.this) | interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(dialog);
            final CallActivity callActivity = CallActivity.this;
            final String str = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.features.call.ui.a
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return CallActivity.f.d(callActivity, str, dialog, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(760701250);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.features.call.ui.b
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return CallActivity.f.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.I(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, ua2, string, c1454b, (SA2) objB2, strC, null, strC2, false, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 5120);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.n3();
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return this.e.d1();
        }
    }

    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ ComponentActivity f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SA2 sa2, ComponentActivity componentActivity) {
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
    public final void A3(EnumC25128zm6 currentDevice) {
        o3().X8(currentDevice);
        o3().K8(B0(), o3().j6());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C3() {
        x xVarS = B0().s();
        int i2 = AbstractC9220Yz5.slide_in_right;
        int i3 = AbstractC9220Yz5.empty_transition;
        xVarS.t(i2, i3, i3, AbstractC9220Yz5.slide_out_right).e(k3().getDialog(), "end").h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D3() {
        if (r3().x1()) {
            new C19598qd3().L8(B0(), o3().j6());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E3(int userId) {
        C18987pb3 c18987pb3 = C18987pb3.a;
        C11458d25 c11458d25E = C11458d25.E(userId);
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        c18987pb3.w1(c11458d25E, null, true);
        onBackPressed();
    }

    private final void F3(final C21753u45.d permissionType) {
        int i2 = b.a[permissionType.ordinal()];
        if (i2 == 1) {
            C21753u45.a.H0(this, 1009, permissionType, new SA2() { // from class: ir.nasim.Cu0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CallActivity.L3(this.a, permissionType);
                }
            });
            return;
        }
        if (i2 == 2) {
            C21753u45.a.H0(this, 1010, permissionType, new SA2() { // from class: ir.nasim.Du0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CallActivity.H3(this.a, permissionType);
                }
            });
            return;
        }
        if (i2 == 3) {
            C21753u45.a.H0(this, 1011, permissionType, new SA2() { // from class: ir.nasim.Eu0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CallActivity.K3(this.a, permissionType);
                }
            });
            return;
        }
        C19406qI3.a("VoiceCallActivity", "permission <" + permissionType + "> not handled ", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H3(CallActivity callActivity, C21753u45.d dVar) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        callActivity.r3().p2(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K3(CallActivity callActivity, C21753u45.d dVar) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        callActivity.r3().p2(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L3(CallActivity callActivity, C21753u45.d dVar) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        callActivity.r3().p2(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M3(CallActivity callActivity, ActivityResult activityResult) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(activityResult, "result");
        int resultCode = activityResult.getResultCode();
        Intent data = activityResult.getData();
        if (resultCode != -1 || data == null) {
            return;
        }
        callActivity.r3().J2(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N3() {
        r3().E2(new InterfaceC6775Ox6.e(0, 1, null));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", r3().K1());
        startActivity(Intent.createChooser(intent, getString(AbstractC12217eE5.nasim_share_call_link)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O3(String userIdentity, String userName) {
        AbstractC21375tZ.c(this, this, null, AbstractC19242q11.c(-964155033, true, new f(userIdentity, userName)), 4, null).show();
    }

    private final void P3(final J35.a permission) {
        G35 g35A = permission.a();
        if (AbstractC13042fc3.d(g35A, G35.a.a)) {
            F3((C21753u45.d) AbstractC15401jX0.q0(permission.b()));
            return;
        }
        if (!(g35A instanceof G35.b)) {
            throw new NoWhenBranchMatchedException();
        }
        final C21753u45.d dVar = (C21753u45.d) AbstractC15401jX0.s0(permission.b());
        if (dVar == null) {
            return;
        }
        boolean zY = C21753u45.a.Y(this, dVar);
        NY nyF = new NY(this).p(((G35.b) permission.a()).b()).E(4).k(4).F(true).h(((G35.b) permission.a()).a()).v(new View.OnClickListener() { // from class: ir.nasim.wu0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallActivity.S3(this.a, dVar, view);
            }
        }).f(false);
        if (zY) {
            nyF.w(AbstractC12217eE5.permission_go_to_settings);
        } else {
            nyF.w(AbstractC12217eE5.permission_ok).t(AbstractC12217eE5.permission_deny).s(new View.OnClickListener() { // from class: ir.nasim.xu0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CallActivity.T3(this.a, permission, view);
                }
            });
        }
        nyF.a().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S3(CallActivity callActivity, C21753u45.d dVar, View view) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(dVar, "$firstPermission");
        callActivity.F3(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T3(CallActivity callActivity, J35.a aVar, View view) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(aVar, "$permission");
        callActivity.r3().p2((C21753u45.d) AbstractC15401jX0.q0(aVar.b()), false);
    }

    private final void U3() {
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
            Object systemService = getSystemService("keyguard");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            ((KeyguardManager) systemService).requestDismissKeyguard(this, null);
        } else {
            getWindow().addFlags(6815744);
        }
        getWindow().addFlags(128);
    }

    private final void V3(final C21753u45.d permissionType) {
        int i2 = b.a[permissionType.ordinal()];
        if (i2 == 1) {
            C21753u45.i0(C21753u45.a, this, 1009, permissionType, Integer.valueOf(AbstractC12217eE5.voice_call_permission_desctiption), null, new SA2() { // from class: ir.nasim.qu0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CallActivity.W3(this.a, permissionType);
                }
            }, new SA2() { // from class: ir.nasim.ru0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CallActivity.X3(this.a, permissionType);
                }
            }, false, 16, null);
            return;
        }
        if (i2 == 2) {
            C21753u45.i0(C21753u45.a, this, 1010, permissionType, Integer.valueOf(AbstractC12217eE5.video_call_permission_desctiption), null, new SA2() { // from class: ir.nasim.su0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CallActivity.Y3(this.a, permissionType);
                }
            }, null, false, 80, null);
            return;
        }
        if (i2 == 3) {
            C21753u45.i0(C21753u45.a, this, 1011, permissionType, Integer.valueOf(AbstractC12217eE5.call_phone_state_permission_description), null, new SA2() { // from class: ir.nasim.tu0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CallActivity.a4(this.a, permissionType);
                }
            }, new SA2() { // from class: ir.nasim.uu0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CallActivity.b4(this.a, permissionType);
                }
            }, false, 16, null);
            return;
        }
        if (i2 == 4) {
            C21753u45.i0(C21753u45.a, this, 1020, permissionType, Integer.valueOf(AbstractC12217eE5.call_bluetooth_permission_desctiption), null, new SA2() { // from class: ir.nasim.vu0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CallActivity.c4(this.a, permissionType);
                }
            }, null, false, 208, null);
            return;
        }
        if (i2 != 5) {
            C19406qI3.a("VoiceCallActivity", "permission <" + permissionType + "> not handled ", new Object[0]);
            return;
        }
        Object systemService = getSystemService("media_projection");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
        AbstractC22357v6 abstractC22357v6 = this.screenCaptureIntentLauncher;
        Intent intentCreateScreenCaptureIntent = ((MediaProjectionManager) systemService).createScreenCaptureIntent();
        AbstractC13042fc3.h(intentCreateScreenCaptureIntent, "createScreenCaptureIntent(...)");
        abstractC22357v6.a(intentCreateScreenCaptureIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W3(CallActivity callActivity, C21753u45.d dVar) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        callActivity.r3().p2(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X3(CallActivity callActivity, C21753u45.d dVar) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        callActivity.r3().p2(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y3(CallActivity callActivity, C21753u45.d dVar) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        callActivity.r3().p2(dVar, false);
        return C19938rB7.a;
    }

    private final void Z2() {
        R01.b(this, null, AbstractC19242q11.c(660000375, true, new c()), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a3() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (Build.VERSION.SDK_INT >= 31 && AbstractC4043Dl1.a(C5721Ko.a.d(), "android.permission.READ_PHONE_STATE") != 0) {
            linkedHashSet.add(C21753u45.d.u);
        }
        if (AbstractC4043Dl1.a(C5721Ko.a.d(), "android.permission.RECORD_AUDIO") != 0) {
            linkedHashSet.add(C21753u45.d.s);
        }
        r3().s2(linkedHashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 a4(CallActivity callActivity, C21753u45.d dVar) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        callActivity.r3().p2(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b3(C17448mz0.a callState) {
        if (callState == C17448mz0.a.n || callState == C17448mz0.a.o) {
            g3(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b4(CallActivity callActivity, C21753u45.d dVar) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        callActivity.r3().p2(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c3() {
        r3().E2(new InterfaceC6775Ox6.b(0, 1, null));
        Object systemService = getSystemService("clipboard");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Call Link", r3().K1()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c4(CallActivity callActivity, C21753u45.d dVar) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(dVar, "$permissionType");
        callActivity.r3().p2(dVar, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d3(String text) {
        if (this.clipboard == null) {
            Object systemService = getSystemService("clipboard");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            this.clipboard = (ClipboardManager) systemService;
        }
        ClipboardManager clipboardManager = this.clipboard;
        if (clipboardManager == null) {
            AbstractC13042fc3.y("clipboard");
            clipboardManager = null;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("flag", text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C24939zT0 d4(final CallActivity callActivity) {
        AbstractC13042fc3.i(callActivity, "this$0");
        C24939zT0 c24939zT0 = new C24939zT0();
        c24939zT0.Y8(new UA2() { // from class: ir.nasim.Bu0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return CallActivity.e4(this.a, (EnumC25128zm6) obj);
            }
        });
        return c24939zT0;
    }

    private final void e3() {
        ArrayList arrayList = new ArrayList();
        AbstractC13837gu0.a();
        arrayList.add(AbstractC18583ou0.a(Icon.createWithResource(this, R.color.transparent), "Empty", "Empty", PendingIntent.getActivity(this, 0, new Intent(), 201326592)));
        enterPictureInPictureMode(AbstractC19174pu0.a().setAspectRatio(new Rational(12, 16)).setActions(arrayList).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e4(CallActivity callActivity, EnumC25128zm6 enumC25128zm6) {
        AbstractC13042fc3.i(callActivity, "this$0");
        AbstractC13042fc3.i(enumC25128zm6, "onAudioDeviceChange");
        callActivity.r3().z1(enumC25128zm6);
        return C19938rB7.a;
    }

    private final boolean f3() {
        if (Build.VERSION.SDK_INT >= 26 && getPackageManager().hasSystemFeature("android.software.picture_in_picture") && y3()) {
            C18039nz0 c18039nz0 = C18039nz0.a;
            if (((C17448mz0) c18039nz0.d().getValue()).s() && !((C17448mz0) c18039nz0.d().getValue()).m()) {
                return true;
            }
        }
        return false;
    }

    private final void g3(long delay) {
        if (this.finishActivityJob != null) {
            return;
        }
        this.finishActivityJob = AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new d(delay, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 g4(CallActivity callActivity) {
        AbstractC13042fc3.i(callActivity, "this$0");
        View rootView = callActivity.getWindow().getDecorView().getRootView();
        AbstractC13042fc3.h(rootView, "getRootView(...)");
        C17468n10 c17468n10 = new C17468n10(rootView, null, 0, 6, null);
        c17468n10.m(3000);
        return c17468n10;
    }

    static /* synthetic */ void h3(CallActivity callActivity, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 3000;
        }
        callActivity.g3(j);
    }

    public static final Intent l3(Context context) {
        return INSTANCE.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer m3() {
        if (!AbstractC5969Lp4.e().S().B5(EnumC4196Ec1.A0)) {
            return null;
        }
        List listP = AbstractC10360bX0.p(Integer.valueOf(KB5.call_nowruz_one), Integer.valueOf(KB5.call_nowruz_two), Integer.valueOf(KB5.call_nowruz_three), Integer.valueOf(KB5.call_nowruz_four), Integer.valueOf(KB5.call_nowruz_five));
        C18039nz0 c18039nz0 = C18039nz0.a;
        c18039nz0.l(c18039nz0.b() + 1);
        return (Integer) listP.get(c18039nz0.b() % listP.size());
    }

    private final C24939zT0 o3() {
        return (C24939zT0) this.speakerBottomSheet.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C12767fA0 r3() {
        return (C12767fA0) this.viewModel.getValue();
    }

    private final C17468n10 t3() {
        return (C17468n10) this.voiceCallErrorsSnackBar.getValue();
    }

    private final void u3(Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != 438844311) {
                if (iHashCode != 1072244419) {
                    if (iHashCode != 1175237740 || !action.equals("answer_voice_call")) {
                        return;
                    }
                } else if (!action.equals("answer_video_call")) {
                    return;
                }
            } else if (!action.equals("ACTION_JOIN_VOICE_CALL")) {
                return;
            }
            r3().V0(intent.getLongExtra("call_id", -1L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v3(OM4 reason) {
        String string = AbstractC13042fc3.d(reason, OM4.c.a) ? getString(AbstractC12217eE5.voice_call_failed_not_approved) : AbstractC13042fc3.d(reason, OM4.b.a) ? getString(AbstractC12217eE5.voice_call_failed_flood_wait) : AbstractC13042fc3.d(reason, OM4.f.a) ? getString(AbstractC12217eE5.voice_call_failed_switch) : reason instanceof OM4.g ? getString(AbstractC12217eE5.voice_call_failed_unknown) : AbstractC13042fc3.d(reason, OM4.d.a) ? getString(AbstractC12217eE5.voice_call_failed_room_limit) : AbstractC13042fc3.d(reason, OM4.a.a) ? getString(AbstractC12217eE5.voice_call_failed_depricated) : AbstractC13042fc3.d(reason, OM4.e.a) ? getString(AbstractC12217eE5.voice_call_failed_permission_denied) : null;
        if (string == null) {
            g3(0L);
        } else {
            t3().o(string);
            h3(this, 0L, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w3(J35 permissionState) {
        if (permissionState instanceof J35.a) {
            P3((J35.a) permissionState);
        } else {
            if (!(permissionState instanceof J35.b)) {
                throw new NoWhenBranchMatchedException();
            }
            V3(((J35.b) permissionState).a());
        }
    }

    private final boolean y3() {
        AppOpsManager appOpsManager = (AppOpsManager) getSystemService("appops");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return false;
        }
        if (i2 >= 29) {
            if (appOpsManager == null || appOpsManager.unsafeCheckOpNoThrow("android:picture_in_picture", Process.myUid(), getPackageName()) != 0) {
                return false;
            }
        } else if (appOpsManager == null || appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    private final InterfaceC13730gj3 z3() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new e(null), 3, null);
    }

    public final InterfaceC5812Ky0 i3() {
        InterfaceC5812Ky0 interfaceC5812Ky0 = this.callScreen;
        if (interfaceC5812Ky0 != null) {
            return interfaceC5812Ky0;
        }
        AbstractC13042fc3.y("callScreen");
        return null;
    }

    public final InterfaceC22976w82 k3() {
        InterfaceC22976w82 interfaceC22976w82 = this.endGroupCallDialogNavigator;
        if (interfaceC22976w82 != null) {
            return interfaceC22976w82;
        }
        AbstractC13042fc3.y("endGroupCallDialogNavigator");
        return null;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!f3() || ((C17448mz0) C18039nz0.a.d().getValue()).e() == C17448mz0.a.n) {
            super.onBackPressed();
        } else {
            e3();
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseFragmentActivity, ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AbstractC19329q98.b(getWindow(), true);
        Z2();
        U3();
        Intent intent = getIntent();
        AbstractC13042fc3.h(intent, "getIntent(...)");
        u3(intent);
        if (savedInstanceState == null) {
            getWindow().setFlags(512, 512);
        }
        z3();
        if (C8386Vt0.a.Y6()) {
            List listN = AbstractC5270Ip7.a.n();
            if (!(listN instanceof Collection) || !listN.isEmpty()) {
                Iterator it = listN.iterator();
                while (it.hasNext()) {
                    if (((AbstractC5270Ip7.c) it.next()) instanceof C4858Gw0) {
                        return;
                    }
                }
            }
            AbstractC5270Ip7.a.o(new C4858Gw0());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        r3().W2(isInPictureInPictureMode);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Integer numD0;
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        Integer numD02 = AbstractC10242bK.d0(grantResults);
        boolean z = numD02 != null && numD02.intValue() == 0;
        if (requestCode != 1020) {
            switch (requestCode) {
                case 1009:
                    r3().p2(C21753u45.d.s, z);
                    break;
                case 1010:
                    r3().p2(C21753u45.d.f, z);
                    break;
                case 1011:
                    r3().p2(C21753u45.d.u, z);
                    break;
                default:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                    break;
            }
        } else {
            r3().p2(C21753u45.d.v, z);
        }
        if (requestCode == 1011) {
            Integer numD03 = AbstractC10242bK.d0(grantResults);
            if (numD03 != null && numD03.intValue() == 0) {
                C20384rv0.a.Q("android.permission.READ_PHONE_STATE");
            } else {
                C20384rv0.a.A();
            }
        }
        if (requestCode == 1020 && (numD0 = AbstractC10242bK.d0(grantResults)) != null && numD0.intValue() == 0) {
            C20384rv0.a.Q("android.permission.BLUETOOTH_CONNECT");
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        C20384rv0.a.u();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onUserLeaveHint() {
        if (f3()) {
            e3();
        }
    }
}
