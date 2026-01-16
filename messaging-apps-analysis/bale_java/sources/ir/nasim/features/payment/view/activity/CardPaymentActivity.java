package ir.nasim.features.payment.view.activity;

import ai.bale.proto.SapOuterClass$ResponseGetCardInfo;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.x;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC19902r80;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9083Yk3;
import ir.nasim.AbstractC9220Yz5;
import ir.nasim.BC5;
import ir.nasim.C11458d25;
import ir.nasim.C12275eL0;
import ir.nasim.C14733iO2;
import ir.nasim.C16731lm1;
import ir.nasim.C18902pS0;
import ir.nasim.C18987pb3;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20644sM5;
import ir.nasim.C21231tK7;
import ir.nasim.C22042ua0;
import ir.nasim.C23572x88;
import ir.nasim.C3343Am;
import ir.nasim.C4382Ew7;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.C7183Qq;
import ir.nasim.C8054Ui1;
import ir.nasim.C8542Wk3;
import ir.nasim.ED1;
import ir.nasim.EnumC18608ow5;
import ir.nasim.EnumC4716Gg2;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.GY6;
import ir.nasim.InterfaceC11677dQ0;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15419jZ0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.PH3;
import ir.nasim.V5;
import ir.nasim.W06;
import ir.nasim.W25;
import ir.nasim.X25;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.bank.mybank.webview.a;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import ir.nasim.features.payment.view.fragment.B;
import ir.nasim.features.payment.view.fragment.C13072e;
import ir.nasim.features.payment.view.fragment.C13073f;
import ir.nasim.features.payment.view.fragment.C13080m;
import ir.nasim.features.payment.view.fragment.K;
import ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13070c;
import ir.nasim.features.root.G;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 ¡\u00012\u00020\u00012\u00020\u0002:\u0006¢\u0001£\u0001¤\u0001B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u001a\u001a\u00020\u00072\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\tJ)\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u0016J\u0019\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010!J/\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0002¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010+\u001a\u00020\u0007H\u0002¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0007H\u0002¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0007H\u0002¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0007H\u0002¢\u0006\u0004\b1\u0010\u0004J\u0017\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u001f\u00108\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0007H\u0014¢\u0006\u0004\b:\u0010\u0004J\u0019\u0010=\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010;H\u0014¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020?H\u0014¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0007H\u0014¢\u0006\u0004\bC\u0010\u0004J\u000f\u0010D\u001a\u00020\u0007H\u0014¢\u0006\u0004\bD\u0010\u0004J\u0019\u0010G\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0007H\u0016¢\u0006\u0004\bI\u0010\u0004J)\u0010M\u001a\u00020\u00072\u0006\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020.2\b\u0010L\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0004\bM\u0010NJ\u0015\u0010O\u001a\u00020\u00072\u0006\u00103\u001a\u000202¢\u0006\u0004\bO\u00105J\u0017\u0010P\u001a\u00020\u00072\u0006\u00103\u001a\u000202H\u0014¢\u0006\u0004\bP\u00105J\u001d\u0010U\u001a\u00020\u00072\u0006\u0010R\u001a\u00020Q2\u0006\u0010T\u001a\u00020S¢\u0006\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bX\u0010YR$\u0010b\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bd\u0010eR\"\u0010n\u001a\u00020g8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010v\u001a\u00020o8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010~\u001a\u00020w8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R)\u0010\u0086\u0001\u001a\u00020\u007f8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R*\u0010\u008e\u0001\u001a\u00030\u0087\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R*\u0010\u0096\u0001\u001a\u00030\u008f\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0019\u0010 \u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001¨\u0006¥\u0001"}, d2 = {"Lir/nasim/features/payment/view/activity/CardPaymentActivity;", "Lir/nasim/designsystem/base/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "botDeepLink", "Lir/nasim/rB7;", "d3", "(Ljava/lang/String;)V", "g3", "l3", "h3", "Landroid/net/Uri;", "uri", "", "S2", "(Landroid/net/Uri;)Z", "cardId", "transactionId", "publicKey", "B2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Z2", "(Ljava/lang/Exception;)V", "a3", "key", "V2", "stringBody", "J2", "(Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/Response;", "response", "responseBody", "T2", "(Lokhttp3/Response;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "k3", "i3", "e3", "m3", "f3", "W2", "b3", "", "O2", "()I", "c3", "Landroid/content/Intent;", "intent", "P2", "(Landroid/content/Intent;)V", "startParam", "nick", "Y2", "(Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "newBase", "attachBaseContext", "(Landroid/content/Context;)V", "onStart", "onStop", "Landroid/view/View;", "view", "onClick", "(Landroid/view/View;)V", "onBackPressed", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Q2", "onNewIntent", "Lir/nasim/d25;", "peer", "Lir/nasim/features/root/G$a;", "checkPeer", "x2", "(Lir/nasim/d25;Lir/nasim/features/root/G$a;)V", "Lir/nasim/V5;", "L0", "Lir/nasim/V5;", "binding", "Lir/nasim/features/payment/view/activity/CardPaymentActivity$b;", "M0", "Lir/nasim/features/payment/view/activity/CardPaymentActivity$b;", "getOnBackPressClickListener", "()Lir/nasim/features/payment/view/activity/CardPaymentActivity$b;", "setOnBackPressClickListener", "(Lir/nasim/features/payment/view/activity/CardPaymentActivity$b;)V", "onBackPressClickListener", "Lir/nasim/ua0;", "N0", "Lir/nasim/ua0;", "starterFragment", "Lir/nasim/pS0;", "O0", "Lir/nasim/pS0;", "I2", "()Lir/nasim/pS0;", "setCheckMigrateCardsUseCase", "(Lir/nasim/pS0;)V", "checkMigrateCardsUseCase", "Lir/nasim/core/modules/banking/BankingModule;", "P0", "Lir/nasim/core/modules/banking/BankingModule;", "A2", "()Lir/nasim/core/modules/banking/BankingModule;", "setBankingModule", "(Lir/nasim/core/modules/banking/BankingModule;)V", "bankingModule", "Lir/nasim/core/modules/settings/SettingsModule;", "Q0", "Lir/nasim/core/modules/settings/SettingsModule;", "K2", "()Lir/nasim/core/modules/settings/SettingsModule;", "setSettingsModule", "(Lir/nasim/core/modules/settings/SettingsModule;)V", "settingsModule", "Lir/nasim/dQ0;", "R0", "Lir/nasim/dQ0;", "H2", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "Lir/nasim/Ui1;", "S0", "Lir/nasim/Ui1;", "getContactModule", "()Lir/nasim/Ui1;", "setContactModule", "(Lir/nasim/Ui1;)V", "contactModule", "Lir/nasim/x88;", "T0", "Lir/nasim/x88;", "getWebViewModule", "()Lir/nasim/x88;", "setWebViewModule", "(Lir/nasim/x88;)V", "webViewModule", "Lir/nasim/features/payment/view/activity/CardPaymentActivity$c;", "U0", "Lir/nasim/features/payment/view/activity/CardPaymentActivity$c;", "operationType", "V0", "Ljava/lang/String;", "supportBotDeepLink", "W0", "Z", "isSecureWindowEnabled", "X0", "b", "a", "c", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class CardPaymentActivity extends Hilt_CardPaymentActivity implements View.OnClickListener {

    /* renamed from: X0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int Y0 = 8;
    private static boolean Z0;

    /* renamed from: L0, reason: from kotlin metadata */
    private V5 binding;

    /* renamed from: M0, reason: from kotlin metadata */
    private b onBackPressClickListener;

    /* renamed from: N0, reason: from kotlin metadata */
    private C22042ua0 starterFragment;

    /* renamed from: O0, reason: from kotlin metadata */
    public C18902pS0 checkMigrateCardsUseCase;

    /* renamed from: P0, reason: from kotlin metadata */
    public BankingModule bankingModule;

    /* renamed from: Q0, reason: from kotlin metadata */
    public SettingsModule settingsModule;

    /* renamed from: R0, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: S0, reason: from kotlin metadata */
    public C8054Ui1 contactModule;

    /* renamed from: T0, reason: from kotlin metadata */
    public C23572x88 webViewModule;

    /* renamed from: U0, reason: from kotlin metadata */
    private c operationType;

    /* renamed from: V0, reason: from kotlin metadata */
    private String supportBotDeepLink;

    /* renamed from: W0, reason: from kotlin metadata */
    private boolean isSecureWindowEnabled = true;

    /* renamed from: ir.nasim.features.payment.view.activity.CardPaymentActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void f(Companion companion, Context context, Uri uri, int i, Object obj) {
            if ((i & 2) != 0) {
                uri = null;
            }
            companion.e(context, uri);
        }

        public final boolean a() {
            return CardPaymentActivity.Z0;
        }

        public final boolean b(Intent intent) {
            String queryParameter;
            Uri data = Uri.parse("");
            if (intent != null) {
                data = intent.getData();
            }
            if (data == null) {
                return false;
            }
            try {
                queryParameter = data.getQueryParameter("key_id");
            } catch (Exception e) {
                C19406qI3.c("CardPaymentActivity ", "Exception in isFromShaparak", e);
                queryParameter = null;
            }
            return (!data.getPathSegments().containsAll(AbstractC10360bX0.p(ConstantDeviceInfo.APP_PLATFORM, "shaparak")) || queryParameter == null || queryParameter.length() == 0) ? false : true;
        }

        public final boolean c(Uri uri) {
            if (uri == null) {
                return false;
            }
            String queryParameter = uri.getQueryParameter("key_id");
            return (!uri.getPathSegments().containsAll(AbstractC10360bX0.p(ConstantDeviceInfo.APP_PLATFORM, "shaparak")) || queryParameter == null || queryParameter.length() == 0) ? false : true;
        }

        public final void d(Context context) {
            AbstractC13042fc3.i(context, "context");
            if (a()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) CardPaymentActivity.class);
            intent.putExtra("TYPE_PARAM", "BALANCE");
            context.startActivity(intent);
            C3343Am.g("new_balance_open");
        }

        public final void e(Context context, Uri uri) {
            AbstractC13042fc3.i(context, "context");
            if (a()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) CardPaymentActivity.class);
            intent.putExtra("TYPE_PARAM", "CARD_MANAGEMENT");
            intent.setData(uri);
            context.startActivity(intent);
            C3343Am.g("new_card_management_open");
        }

        public final void g(Context context) {
            AbstractC13042fc3.i(context, "context");
            if (a()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) CardPaymentActivity.class);
            intent.putExtra("TYPE_PARAM", "CARD_TO_CARD");
            context.startActivity(intent);
        }

        public final void h(Context context, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "destination");
            if (a()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) CardPaymentActivity.class);
            intent.putExtra("DESTINATION_CARD_PARAM", str);
            intent.putExtra("TYPE_PARAM", "CARD_TO_CARD");
            context.startActivity(intent);
            C3343Am.g("c2c_open_by_destination_card");
        }

        public final void i(Context context, long j) {
            AbstractC13042fc3.i(context, "context");
            if (a()) {
                return;
            }
            C11458d25 c11458d25R = C11458d25.r(j);
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            boolean z = c11458d25R.s() == W25.a;
            Intent intent = new Intent(context, (Class<?>) CardPaymentActivity.class);
            if (z && c11458d25R.getPeerId() != AbstractC5969Lp4.f()) {
                intent.putExtra("PEER_ID_PARAM", c11458d25R.u());
            }
            intent.putExtra("TYPE_PARAM", "CARD_TO_CARD");
            context.startActivity(intent);
        }

        public final void j(Context context, long j, ExPeerType exPeerType, boolean z) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            if (a()) {
                return;
            }
            C11458d25 c11458d25R = C11458d25.r(j);
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            Intent intent = new Intent(context, (Class<?>) CardPaymentActivity.class);
            intent.putExtra("PEER_ID_PARAM", c11458d25R.u());
            intent.putExtra("EX_PEER_TYPE_PARAM", exPeerType.getValue());
            intent.putExtra("TYPE_PARAM", "CREATE_MONEY_REQUEST");
            intent.putExtra("from_my_bank", z);
            context.startActivity(intent);
            C3343Am.g("new_create_money_request_open");
        }

        public final void k(Context context, String str, Long l, byte[] bArr, HistoryMessageData historyMessageData) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "destination");
            AbstractC13042fc3.i(bArr, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(historyMessageData, "messageData");
            if (a()) {
                return;
            }
            C11458d25 c11458d25R = C11458d25.r(historyMessageData.getPeer());
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            Intent intent = new Intent(context, (Class<?>) CardPaymentActivity.class);
            intent.putExtra("DESTINATION_CARD_PARAM", str);
            if (l != null) {
                intent.putExtra("AMOUNT_PARAM", l.longValue());
            }
            intent.putExtra("MESSAGE_DATA", historyMessageData);
            intent.putExtra("TYPE_PARAM", "PAY_CROWDFUNDING");
            intent.putExtra("PEER_ID_PARAM", c11458d25R.u());
            intent.putExtra("MESSAGE_PARAM", bArr);
            context.startActivity(intent);
            C3343Am.g("new_pay_money_request_open");
        }

        public final void l(Context context, String str, Long l, byte[] bArr, HistoryMessageData historyMessageData) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "destination");
            AbstractC13042fc3.i(bArr, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(historyMessageData, "messageData");
            if (a()) {
                return;
            }
            C11458d25 c11458d25R = C11458d25.r(historyMessageData.getPeer());
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            Intent intent = new Intent(context, (Class<?>) CardPaymentActivity.class);
            intent.putExtra("DESTINATION_CARD_PARAM", str);
            if (l != null) {
                intent.putExtra("AMOUNT_PARAM", l.longValue());
            }
            intent.putExtra("TYPE_PARAM", "PAY_MONEY_REQUEST");
            intent.putExtra("PEER_ID_PARAM", c11458d25R.u());
            intent.putExtra("MESSAGE_PARAM", bArr);
            intent.putExtra("MESSAGE_DATA", historyMessageData);
            context.startActivity(intent);
            C3343Am.g("new_pay_money_request_open");
        }

        public final void m(Context context) {
            AbstractC13042fc3.i(context, "context");
            if (a()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) CardPaymentActivity.class);
            intent.putExtra("TYPE_PARAM", "STATEMENT");
            context.startActivity(intent);
            C3343Am.g("new_statement_open");
        }

        public final void n(Context context, byte[] bArr, int i) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(bArr, DialogEntity.COLUMN_MESSAGE);
            if (a()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) CardPaymentActivity.class);
            intent.putExtra("TYPE_PARAM", "WALLET_REQUEST");
            intent.putExtra("MESSAGE_PARAM", bArr);
            intent.putExtra("randomId", i);
            context.startActivity(intent);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public interface b {
        boolean B1();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class c {
        public static final c a = new c("CARD_TO_CARD", 0);
        public static final c b = new c("CREATE_MONEY_REQUEST", 1);
        public static final c c = new c("PAY_MONEY_REQUEST", 2);
        public static final c d = new c("PAY_CROWDFUNDING", 3);
        public static final c e = new c("BALANCE", 4);
        public static final c f = new c("STATEMENT", 5);
        public static final c g = new c("CARD_MANAGEMENT", 6);
        public static final c h = new c("WALLET_REQUEST", 7);
        private static final /* synthetic */ c[] i;
        private static final /* synthetic */ F92 j;

        static {
            c[] cVarArrA = a();
            i = cVarArrA;
            j = G92.a(cVarArrA);
        }

        private c(String str, int i2) {
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{a, b, c, d, e, f, g, h};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) i.clone();
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[c.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[c.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[c.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[c.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[c.h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[c.g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = iArr;
        }
    }

    public static final class e implements Callback {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        e(String str, String str2) {
            this.b = str;
            this.c = str2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(iOException, "e");
            C19406qI3.d("NON_FATAL_EXCEPTION", iOException);
            C22042ua0 c22042ua0 = CardPaymentActivity.this.starterFragment;
            if (c22042ua0 == null) {
                AbstractC13042fc3.y("starterFragment");
                c22042ua0 = null;
            }
            c22042ua0.H6(2, 0, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            byte[] bArrBytes;
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(response, "response");
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null || (bArrBytes = responseBodyBody.bytes()) == null) {
                bArrBytes = new byte[0];
            }
            CardPaymentActivity.this.T2(response, new String(bArrBytes, C12275eL0.b), this.b, this.c);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CardPaymentActivity.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18902pS0 c18902pS0I2 = CardPaymentActivity.this.I2();
                this.b = 1;
                if (c18902pS0I2.f(this) == objE) {
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

    public static final class g implements InterfaceC15419jZ0 {
        final /* synthetic */ String b;

        public static final class a implements G.a {
            final /* synthetic */ CardPaymentActivity a;
            final /* synthetic */ C11458d25 b;
            final /* synthetic */ String c;

            a(CardPaymentActivity cardPaymentActivity, C11458d25 c11458d25, String str) {
                this.a = cardPaymentActivity;
                this.b = c11458d25;
                this.c = str;
            }

            @Override // ir.nasim.features.root.G.a
            public void a(ExPeerType exPeerType) {
                AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
                Fragment fragmentB = InterfaceC11677dQ0.b(this.a.H2(), this.b, exPeerType, Long.valueOf(r4.getPeerId()), null, false, null, null, null, null, 0L, null, null, this.c, false, null, null, null, null, null, false, null, null, null, null, null, false, null, 134213624, null);
                x xVarS = this.a.B0().s();
                int i = AbstractC9220Yz5.slide_in_right;
                int i2 = AbstractC9220Yz5.empty_transition;
                xVarS.t(i, i2, i2, AbstractC9220Yz5.slide_out_right).c(BC5.content_frame, fragmentB, "supportBotFragment").g(null).h();
            }
        }

        g(String str) {
            this.b = str;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C4382Ew7 c4382Ew7) {
            C21231tK7[] c21231tK7Arr;
            C21231tK7 c21231tK7;
            if (c4382Ew7 == null || (c21231tK7Arr = (C21231tK7[]) c4382Ew7.a()) == null || (c21231tK7 = c21231tK7Arr[0]) == null) {
                return;
            }
            C11458d25 c11458d25E = C11458d25.E(c21231tK7.o());
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            CardPaymentActivity cardPaymentActivity = CardPaymentActivity.this;
            cardPaymentActivity.x2(c11458d25E, new a(cardPaymentActivity, c11458d25E, this.b));
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            AbstractC13042fc3.i(exc, "e");
        }
    }

    private final void B2(final String cardId, final String transactionId, final String publicKey) {
        A2().w1(transactionId, cardId).m0(new InterfaceC24449ye1() { // from class: ir.nasim.jH0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                CardPaymentActivity.D2(this.a, publicKey, (SapOuterClass$ResponseGetCardInfo) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.kH0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                CardPaymentActivity.E2(this.a, transactionId, cardId, publicKey, (Exception) obj);
            }
        });
    }

    static /* synthetic */ void C2(CardPaymentActivity cardPaymentActivity, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        cardPaymentActivity.B2(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D2(CardPaymentActivity cardPaymentActivity, String str, SapOuterClass$ResponseGetCardInfo sapOuterClass$ResponseGetCardInfo) {
        AbstractC13042fc3.i(cardPaymentActivity, "this$0");
        cardPaymentActivity.a3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(final CardPaymentActivity cardPaymentActivity, String str, String str2, final String str3, final Exception exc) {
        AbstractC13042fc3.i(cardPaymentActivity, "this$0");
        AbstractC13042fc3.i(str, "$transactionId");
        AbstractC13042fc3.i(str2, "$cardId");
        AbstractC13042fc3.i(exc, "e");
        if (GY6.f(exc)) {
            cardPaymentActivity.A2().w1(str, str2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.nH0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    CardPaymentActivity.F2(this.a, str3, (SapOuterClass$ResponseGetCardInfo) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.oH0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    CardPaymentActivity.G2(this.a, exc, (Exception) obj);
                }
            });
        } else {
            cardPaymentActivity.Z2(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(CardPaymentActivity cardPaymentActivity, String str, SapOuterClass$ResponseGetCardInfo sapOuterClass$ResponseGetCardInfo) {
        AbstractC13042fc3.i(cardPaymentActivity, "this$0");
        cardPaymentActivity.a3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G2(CardPaymentActivity cardPaymentActivity, Exception exc, Exception exc2) {
        AbstractC13042fc3.i(cardPaymentActivity, "this$0");
        AbstractC13042fc3.i(exc, "$e");
        cardPaymentActivity.Z2(exc);
    }

    private final String J2(String stringBody) {
        C8542Wk3 c8542Wk3O = AbstractC9083Yk3.c(stringBody).o();
        if (c8542Wk3O.L("status").i() != 1) {
            return null;
        }
        return c8542Wk3O.L("keyData").v();
    }

    private final int O2() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", ConstantDeviceInfo.APP_PLATFORM);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P2(Intent intent) {
        List listM;
        List listM2;
        Set<String> queryParameterNames;
        String strValueOf = String.valueOf(intent.getData());
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strValueOf.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        String str = null;
        if (AbstractC20762sZ6.X(lowerCase, Separators.QUESTION, false, 2, null)) {
            C18987pb3 c18987pb3 = C18987pb3.a;
            if (AbstractC20762sZ6.X(lowerCase, c18987pb3.F(), false, 2, null) || c18987pb3.x(strValueOf).length > 1) {
                try {
                    new URL(strValueOf);
                    List listM3 = new C20644sM5("[?]").m(strValueOf, 0);
                    if (listM3.isEmpty()) {
                        listM = AbstractC10360bX0.m();
                    } else {
                        ListIterator listIterator = listM3.listIterator(listM3.size());
                        while (listIterator.hasPrevious()) {
                            if (((String) listIterator.previous()).length() != 0) {
                                listM = AbstractC15401jX0.f1(listM3, listIterator.nextIndex() + 1);
                                break;
                            }
                        }
                        listM = AbstractC10360bX0.m();
                    }
                    List listM4 = new C20644sM5(Separators.SLASH).m(((String[]) listM.toArray(new String[0]))[0], 0);
                    if (listM4.isEmpty()) {
                        listM2 = AbstractC10360bX0.m();
                    } else {
                        ListIterator listIterator2 = listM4.listIterator(listM4.size());
                        while (listIterator2.hasPrevious()) {
                            if (((String) listIterator2.previous()).length() != 0) {
                                listM2 = AbstractC15401jX0.f1(listM4, listIterator2.nextIndex() + 1);
                                break;
                            }
                        }
                        listM2 = AbstractC10360bX0.m();
                    }
                    String[] strArr = (String[]) listM2.toArray(new String[0]);
                    String str2 = strArr[strArr.length - 1];
                    Uri data = intent.getData();
                    if (data != null && (queryParameterNames = data.getQueryParameterNames()) != null) {
                        Iterator<T> it = queryParameterNames.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object next = it.next();
                            if (AbstractC20153rZ6.D((String) next, "start", false)) {
                                str = next;
                                break;
                            }
                        }
                        str = str;
                    }
                    if (str != null) {
                        Y2(str, str2);
                    }
                } catch (MalformedURLException e2) {
                    C19406qI3.a("CardPaymentActivity ", "error(handleJoinWithParam): " + e2.getMessage(), new Object[0]);
                }
            }
        }
    }

    private final boolean S2(Uri uri) {
        try {
            try {
                C22042ua0 c22042ua0 = this.starterFragment;
                if (c22042ua0 == null) {
                    AbstractC13042fc3.y("starterFragment");
                    c22042ua0 = null;
                }
                c22042ua0.H6(3, -1, null);
                String queryParameter = uri.getQueryParameter("key_id");
                String string = C7183Qq.p().getString("last_request_for_shaparak_migration_id", "");
                AbstractC13042fc3.h(string, "getString(...)");
                String string2 = C7183Qq.p().getString("last_request_for_shaparak_migration_transactionid", "");
                AbstractC13042fc3.h(string2, "getString(...)");
                if (string2.length() == 0 || string.length() == 0) {
                    Z2(new Exception(""));
                } else if (AbstractC19902r80.a().booleanValue()) {
                    C2(this, string, string2, null, 4, null);
                } else {
                    V2(queryParameter, string, string2);
                }
                return false;
            } catch (Exception e2) {
                C22042ua0 c22042ua02 = this.starterFragment;
                if (c22042ua02 == null) {
                    AbstractC13042fc3.y("starterFragment");
                    c22042ua02 = null;
                }
                c22042ua02.H6(3, 0, null);
                C19406qI3.d("NON_FATAL_EXCEPTION", e2);
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T2(Response response, final String responseBody, final String transactionId, final String cardId) {
        if (response.isSuccessful()) {
            AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.mH0
                @Override // java.lang.Runnable
                public final void run() {
                    CardPaymentActivity.U2(this.a, responseBody, cardId, transactionId);
                }
            });
            return;
        }
        C22042ua0 c22042ua0 = this.starterFragment;
        if (c22042ua0 == null) {
            AbstractC13042fc3.y("starterFragment");
            c22042ua0 = null;
        }
        c22042ua0.H6(2, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(CardPaymentActivity cardPaymentActivity, String str, String str2, String str3) {
        AbstractC13042fc3.i(cardPaymentActivity, "this$0");
        AbstractC13042fc3.i(str, "$responseBody");
        AbstractC13042fc3.i(str2, "$cardId");
        AbstractC13042fc3.i(str3, "$transactionId");
        String strJ2 = cardPaymentActivity.J2(str);
        if (strJ2 == null) {
            C22042ua0 c22042ua0 = cardPaymentActivity.starterFragment;
            if (c22042ua0 == null) {
                AbstractC13042fc3.y("starterFragment");
                c22042ua0 = null;
            }
            c22042ua0.H6(2, 0, null);
            return;
        }
        if (!C7183Qq.q(EnumC18608ow5.g).h("last_request_is_reactivate", true)) {
            cardPaymentActivity.B2(str2, str3, strJ2);
            return;
        }
        C22042ua0 c22042ua02 = cardPaymentActivity.starterFragment;
        if (c22042ua02 == null) {
            AbstractC13042fc3.y("starterFragment");
            c22042ua02 = null;
        }
        c22042ua02.H6(2, -1, null);
    }

    private final void V2(String key, String cardId, String transactionId) {
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType mediaType = MediaType.INSTANCE.parse("application/json; charset=utf-8");
        Request requestBuild = new Request.Builder().url("https://tsm.shaparak.ir/mobileApp/getKey").post(RequestBody.INSTANCE.create("{\"transactionId\":\"" + transactionId + "\",\"keyId\":\"" + key + "\"}", mediaType)).build();
        try {
            C19406qI3.a("CardPaymentActivity ", "call httpRequest for get shaparak key ", new Object[0]);
            okHttpClient.newCall(requestBuild).enqueue(new e(transactionId, cardId));
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    private final void W2() {
        b3();
        V5 v5 = this.binding;
        V5 v52 = null;
        if (v5 == null) {
            AbstractC13042fc3.y("binding");
            v5 = null;
        }
        v5.b.setOnClickListener(this);
        V5 v53 = this.binding;
        if (v53 == null) {
            AbstractC13042fc3.y("binding");
            v53 = null;
        }
        v53.i.setTypeface(C6011Lu2.i());
        V5 v54 = this.binding;
        if (v54 == null) {
            AbstractC13042fc3.y("binding");
            v54 = null;
        }
        v54.b.setTypeface(C6011Lu2.k());
        V5 v55 = this.binding;
        if (v55 == null) {
            AbstractC13042fc3.y("binding");
            v55 = null;
        }
        v55.k.setTypeface(C6011Lu2.i());
        V5 v56 = this.binding;
        if (v56 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            v52 = v56;
        }
        v52.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lH0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardPaymentActivity.X2(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X2(CardPaymentActivity cardPaymentActivity, View view) {
        AbstractC13042fc3.i(cardPaymentActivity, "this$0");
        cardPaymentActivity.c3();
    }

    private final void Y2(String startParam, String nick) {
        AbstractC5969Lp4.e().H().I(nick).a(new g(startParam));
    }

    private final void Z2(Exception e2) {
        C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        C22042ua0 c22042ua0 = this.starterFragment;
        if (c22042ua0 == null) {
            AbstractC13042fc3.y("starterFragment");
            c22042ua0 = null;
        }
        c22042ua0.H6(2, 0, null);
    }

    private final void a3(String publicKey) {
        if (publicKey != null) {
            AbstractC19902r80.i(publicKey);
        }
        C22042ua0 c22042ua0 = this.starterFragment;
        if (c22042ua0 == null) {
            AbstractC13042fc3.y("starterFragment");
            c22042ua0 = null;
        }
        c22042ua0.H6(2, -1, null);
        C7183Qq.p().putString("last_request_for_shaparak_migration_id", "");
        C7183Qq.p().putString("last_request_for_shaparak_migration_transactionid", "");
    }

    private final void b3() {
        V5 v5 = this.binding;
        V5 v52 = null;
        if (v5 == null) {
            AbstractC13042fc3.y("binding");
            v5 = null;
        }
        ViewGroup.LayoutParams layoutParams = v5.h.getLayoutParams();
        AbstractC13042fc3.h(layoutParams, "getLayoutParams(...)");
        layoutParams.height = O2();
        V5 v53 = this.binding;
        if (v53 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            v52 = v53;
        }
        v52.h.setLayoutParams(layoutParams);
    }

    private final void c3() {
        String str = this.supportBotDeepLink;
        if (str == null || str.length() == 0 || AbstractC13042fc3.d(this.supportBotDeepLink, "0")) {
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.supportBotDeepLink));
        intent.setAction("android.intent.action.VIEW");
        P2(intent);
    }

    private final void d3(String botDeepLink) {
        if (botDeepLink.length() <= 0 || AbstractC13042fc3.d(botDeepLink, "0")) {
            return;
        }
        V5 v5 = this.binding;
        if (v5 == null) {
            AbstractC13042fc3.y("binding");
            v5 = null;
        }
        v5.g.setVisibility(0);
        this.supportBotDeepLink = botDeepLink;
    }

    private final void e3() {
        V5 v5 = this.binding;
        C22042ua0 c22042ua0 = null;
        if (v5 == null) {
            AbstractC13042fc3.y("binding");
            v5 = null;
        }
        v5.i.setText(getString(AbstractC12217eE5.card_payment_card_balance));
        this.starterFragment = new ViewOnClickListenerC13070c();
        x xVarS = B0().s();
        int i = BC5.fragment_container;
        C22042ua0 c22042ua02 = this.starterFragment;
        if (c22042ua02 == null) {
            AbstractC13042fc3.y("starterFragment");
        } else {
            c22042ua0 = c22042ua02;
        }
        xVarS.q(i, c22042ua0).i();
    }

    private final void f3() {
        V5 v5 = this.binding;
        C22042ua0 c22042ua0 = null;
        if (v5 == null) {
            AbstractC13042fc3.y("binding");
            v5 = null;
        }
        v5.i.setText(getString(AbstractC12217eE5.card_payment_cards_managment));
        this.starterFragment = new C13072e();
        x xVarS = B0().s();
        int i = BC5.fragment_container;
        C22042ua0 c22042ua02 = this.starterFragment;
        if (c22042ua02 == null) {
            AbstractC13042fc3.y("starterFragment");
        } else {
            c22042ua0 = c22042ua02;
        }
        xVarS.q(i, c22042ua0).i();
    }

    private final void g3() {
        B.Companion companion = B.INSTANCE;
        C22042ua0 c22042ua0 = null;
        this.starterFragment = B.Companion.b(companion, null, null, 3, null);
        if (getIntent().hasExtra("PEER_ID_PARAM")) {
            Bundle extras = getIntent().getExtras();
            AbstractC13042fc3.f(extras);
            this.starterFragment = B.Companion.b(companion, Long.valueOf(extras.getLong("PEER_ID_PARAM")), null, 2, null);
        } else if (getIntent().hasExtra("DESTINATION_CARD_PARAM")) {
            Bundle extras2 = getIntent().getExtras();
            AbstractC13042fc3.f(extras2);
            this.starterFragment = companion.a(null, extras2.getString("DESTINATION_CARD_PARAM"));
        }
        x xVarS = B0().s();
        int i = BC5.fragment_container;
        C22042ua0 c22042ua02 = this.starterFragment;
        if (c22042ua02 == null) {
            AbstractC13042fc3.y("starterFragment");
        } else {
            c22042ua0 = c22042ua02;
        }
        xVarS.q(i, c22042ua0).i();
    }

    private final void h3() {
        C22042ua0 c22042ua0A;
        Bundle extras = getIntent().getExtras();
        AbstractC13042fc3.f(extras);
        long j = extras.getLong("PEER_ID_PARAM");
        Bundle extras2 = getIntent().getExtras();
        C22042ua0 c22042ua0 = null;
        Boolean boolValueOf = extras2 != null ? Boolean.valueOf(extras2.getBoolean("from_my_bank", false)) : null;
        V5 v5 = this.binding;
        if (v5 == null) {
            AbstractC13042fc3.y("binding");
            v5 = null;
        }
        v5.i.setText(getString(AbstractC12217eE5.card_payment_money_request));
        if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.c4)) {
            c22042ua0A = C13073f.INSTANCE.a(j);
        } else {
            c22042ua0A = C13080m.INSTANCE.a(j, boolValueOf != null ? boolValueOf.booleanValue() : false);
        }
        this.starterFragment = c22042ua0A;
        x xVarS = B0().s();
        int i = BC5.fragment_container;
        C22042ua0 c22042ua02 = this.starterFragment;
        if (c22042ua02 == null) {
            AbstractC13042fc3.y("starterFragment");
        } else {
            c22042ua0 = c22042ua02;
        }
        xVarS.q(i, c22042ua0).i();
    }

    private final void i3() {
        Long lValueOf;
        String string;
        Long lValueOf2;
        HistoryMessageData historyMessageData;
        byte[] byteArray;
        C22042ua0 c22042ua0 = null;
        if (getIntent().hasExtra("AMOUNT_PARAM")) {
            Bundle extras = getIntent().getExtras();
            AbstractC13042fc3.f(extras);
            lValueOf = Long.valueOf(extras.getLong("AMOUNT_PARAM"));
        } else {
            lValueOf = null;
        }
        if (getIntent().hasExtra("DESTINATION_CARD_PARAM")) {
            Bundle extras2 = getIntent().getExtras();
            AbstractC13042fc3.f(extras2);
            string = extras2.getString("DESTINATION_CARD_PARAM");
        } else {
            string = null;
        }
        if (getIntent().hasExtra("PEER_ID_PARAM")) {
            Bundle extras3 = getIntent().getExtras();
            AbstractC13042fc3.f(extras3);
            lValueOf2 = Long.valueOf(extras3.getLong("PEER_ID_PARAM"));
        } else {
            lValueOf2 = null;
        }
        if (getIntent().hasExtra("MESSAGE_DATA")) {
            Bundle extras4 = getIntent().getExtras();
            AbstractC13042fc3.f(extras4);
            historyMessageData = (HistoryMessageData) extras4.getParcelable("MESSAGE_DATA");
        } else {
            historyMessageData = null;
        }
        if (getIntent().hasExtra("MESSAGE_PARAM")) {
            Bundle extras5 = getIntent().getExtras();
            AbstractC13042fc3.f(extras5);
            byteArray = extras5.getByteArray("MESSAGE_PARAM");
        } else {
            byteArray = null;
        }
        if (string == null || lValueOf2 == null || byteArray == null) {
            finish();
        }
        B.Companion companion = B.INSTANCE;
        AbstractC13042fc3.f(string);
        AbstractC13042fc3.f(lValueOf2);
        long jLongValue = lValueOf2.longValue();
        AbstractC13042fc3.f(byteArray);
        this.starterFragment = companion.c(lValueOf, string, jLongValue, byteArray, historyMessageData);
        x xVarS = B0().s();
        int i = BC5.fragment_container;
        C22042ua0 c22042ua02 = this.starterFragment;
        if (c22042ua02 == null) {
            AbstractC13042fc3.y("starterFragment");
        } else {
            c22042ua0 = c22042ua02;
        }
        xVarS.q(i, c22042ua0).i();
    }

    private final void k3() {
        Long lValueOf;
        String string;
        HistoryMessageData historyMessageData;
        Long lValueOf2;
        byte[] byteArray;
        C22042ua0 c22042ua0 = null;
        if (getIntent().hasExtra("AMOUNT_PARAM")) {
            Bundle extras = getIntent().getExtras();
            AbstractC13042fc3.f(extras);
            lValueOf = Long.valueOf(extras.getLong("AMOUNT_PARAM"));
        } else {
            lValueOf = null;
        }
        if (getIntent().hasExtra("DESTINATION_CARD_PARAM")) {
            Bundle extras2 = getIntent().getExtras();
            AbstractC13042fc3.f(extras2);
            string = extras2.getString("DESTINATION_CARD_PARAM");
        } else {
            string = null;
        }
        if (!getIntent().hasExtra("MESSAGE_DATA")) {
            historyMessageData = null;
        } else if (Build.VERSION.SDK_INT >= 33) {
            Bundle extras3 = getIntent().getExtras();
            AbstractC13042fc3.f(extras3);
            Object parcelable = extras3.getParcelable("MESSAGE_DATA", HistoryMessageData.class);
            AbstractC13042fc3.f(parcelable);
            historyMessageData = (HistoryMessageData) parcelable;
        } else {
            Bundle extras4 = getIntent().getExtras();
            AbstractC13042fc3.f(extras4);
            Parcelable parcelable2 = extras4.getParcelable("MESSAGE_DATA");
            AbstractC13042fc3.f(parcelable2);
            historyMessageData = (HistoryMessageData) parcelable2;
        }
        if (getIntent().hasExtra("PEER_ID_PARAM")) {
            Bundle extras5 = getIntent().getExtras();
            AbstractC13042fc3.f(extras5);
            lValueOf2 = Long.valueOf(extras5.getLong("PEER_ID_PARAM"));
        } else {
            lValueOf2 = null;
        }
        if (getIntent().hasExtra("MESSAGE_PARAM")) {
            Bundle extras6 = getIntent().getExtras();
            AbstractC13042fc3.f(extras6);
            byteArray = extras6.getByteArray("MESSAGE_PARAM");
        } else {
            byteArray = null;
        }
        if (string == null || lValueOf2 == null || byteArray == null) {
            finish();
        }
        B.Companion companion = B.INSTANCE;
        AbstractC13042fc3.f(string);
        AbstractC13042fc3.f(byteArray);
        this.starterFragment = companion.d(lValueOf, string, byteArray, historyMessageData);
        x xVarS = B0().s();
        int i = BC5.fragment_container;
        C22042ua0 c22042ua02 = this.starterFragment;
        if (c22042ua02 == null) {
            AbstractC13042fc3.y("starterFragment");
        } else {
            c22042ua0 = c22042ua02;
        }
        xVarS.q(i, c22042ua0).i();
    }

    private final void l3() {
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("MESSAGE_PARAM");
        int intExtra = getIntent().getIntExtra("randomId", 0);
        V5 v5 = this.binding;
        C22042ua0 c22042ua0 = null;
        if (v5 == null) {
            AbstractC13042fc3.y("binding");
            v5 = null;
        }
        v5.j.setVisibility(8);
        if (byteArrayExtra != null) {
            this.starterFragment = a.r1.c(K2().Y4(), byteArrayExtra, intExtra, false);
            x xVarS = B0().s();
            int i = BC5.fragment_container;
            C22042ua0 c22042ua02 = this.starterFragment;
            if (c22042ua02 == null) {
                AbstractC13042fc3.y("starterFragment");
            } else {
                c22042ua0 = c22042ua02;
            }
            xVarS.q(i, c22042ua0).i();
        }
    }

    private final void m3() {
        V5 v5 = this.binding;
        C22042ua0 c22042ua0 = null;
        if (v5 == null) {
            AbstractC13042fc3.y("binding");
            v5 = null;
        }
        v5.i.setText(getString(AbstractC12217eE5.card_payment_card_statement));
        this.starterFragment = new K();
        x xVarS = B0().s();
        int i = BC5.fragment_container;
        C22042ua0 c22042ua02 = this.starterFragment;
        if (c22042ua02 == null) {
            AbstractC13042fc3.y("starterFragment");
        } else {
            c22042ua0 = c22042ua02;
        }
        xVarS.q(i, c22042ua0).i();
    }

    public final BankingModule A2() {
        BankingModule bankingModule = this.bankingModule;
        if (bankingModule != null) {
            return bankingModule;
        }
        AbstractC13042fc3.y("bankingModule");
        return null;
    }

    public final InterfaceC11677dQ0 H2() {
        InterfaceC11677dQ0 interfaceC11677dQ0 = this.chatNavigator;
        if (interfaceC11677dQ0 != null) {
            return interfaceC11677dQ0;
        }
        AbstractC13042fc3.y("chatNavigator");
        return null;
    }

    public final C18902pS0 I2() {
        C18902pS0 c18902pS0 = this.checkMigrateCardsUseCase;
        if (c18902pS0 != null) {
            return c18902pS0;
        }
        AbstractC13042fc3.y("checkMigrateCardsUseCase");
        return null;
    }

    public final SettingsModule K2() {
        SettingsModule settingsModule = this.settingsModule;
        if (settingsModule != null) {
            return settingsModule;
        }
        AbstractC13042fc3.y("settingsModule");
        return null;
    }

    public final void Q2(Intent intent) {
        AbstractC13042fc3.i(intent, "intent");
        Uri data = intent.getData();
        if (data != null) {
            String queryParameter = data.getQueryParameter("key_id");
            if (queryParameter != null) {
                String lowerCase = queryParameter.toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                if (!AbstractC13042fc3.d(lowerCase, "null")) {
                    S2(data);
                    return;
                }
            }
            C22042ua0 c22042ua0 = this.starterFragment;
            if (c22042ua0 == null) {
                AbstractC13042fc3.y("starterFragment");
                c22042ua0 = null;
            }
            c22042ua0.H6(2, 0, null);
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        AbstractC13042fc3.i(newBase, "newBase");
        super.attachBaseContext(PH3.b(PH3.a, newBase, null, 1, null));
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5003 || requestCode == 5004 || requestCode == 20011) {
            C22042ua0 c22042ua0 = this.starterFragment;
            if (c22042ua0 == null) {
                AbstractC13042fc3.y("starterFragment");
                c22042ua0 = null;
            }
            c22042ua0.H6(requestCode, resultCode, data);
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Window window;
        b bVar = this.onBackPressClickListener;
        boolean zB1 = bVar != null ? bVar.B1() : true;
        if (B0().w0() <= 0) {
            finish();
        } else if (zB1) {
            if (B0().w0() == 1 && (window = getWindow()) != null) {
                window.addFlags(8192);
            }
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        V5 v5 = this.binding;
        if (v5 == null) {
            AbstractC13042fc3.y("binding");
            v5 = null;
        }
        if (AbstractC13042fc3.d(view, v5.b)) {
            onBackPressed();
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Window window;
        C5735Kp4.w().L();
        super.onCreate(savedInstanceState);
        C16731lm1 c16731lm1 = new C16731lm1(this, AbstractC23035wE5.Theme_Bale_Base);
        String stringExtra = getIntent().getStringExtra("TYPE_PARAM");
        if (stringExtra == null) {
            stringExtra = "";
        }
        c cVarValueOf = c.valueOf(stringExtra);
        this.operationType = cVarValueOf;
        if (cVarValueOf != c.h && (window = getWindow()) != null) {
            window.addFlags(8192);
        }
        V5 v5C = V5.c(getLayoutInflater().cloneInContext(c16731lm1));
        this.binding = v5C;
        Object obj = null;
        if (v5C == null) {
            AbstractC13042fc3.y("binding");
            v5C = null;
        }
        setContentView(v5C.getRoot());
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new f(null), 3, null);
        W2();
        if (savedInstanceState == null && getIntent().getExtras() != null && getIntent().hasExtra("TYPE_PARAM")) {
            c cVar = this.operationType;
            switch (cVar == null ? -1 : d.a[cVar.ordinal()]) {
                case 1:
                    g3();
                    d3(K2().P0());
                    break;
                case 2:
                    h3();
                    d3(K2().z1());
                    break;
                case 3:
                    k3();
                    d3(K2().x3());
                    break;
                case 4:
                    i3();
                    d3(K2().w3());
                    break;
                case 5:
                    e3();
                    d3(K2().W0());
                    break;
                case 6:
                    m3();
                    d3(K2().Y0());
                    break;
                case 7:
                    l3();
                    break;
                case 8:
                    f3();
                    d3(K2().X0());
                    break;
            }
        }
        if (this.starterFragment == null) {
            f3();
            if (INSTANCE.b(getIntent())) {
                Intent intent = getIntent();
                AbstractC13042fc3.h(intent, "getIntent(...)");
                Q2(intent);
            }
        }
        C22042ua0 c22042ua0 = this.starterFragment;
        if (c22042ua0 == null) {
            AbstractC13042fc3.y("starterFragment");
            c22042ua0 = null;
        }
        if (c22042ua0 instanceof b) {
            C22042ua0 c22042ua02 = this.starterFragment;
            if (c22042ua02 == null) {
                AbstractC13042fc3.y("starterFragment");
            } else {
                obj = c22042ua02;
            }
            this.onBackPressClickListener = (b) obj;
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(8192);
        }
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onNewIntent(android.content.Intent r2) {
        /*
            r1 = this;
            java.lang.String r0 = "intent"
            ir.nasim.AbstractC13042fc3.i(r2, r0)
            super.onNewIntent(r2)
            ir.nasim.ua0 r0 = r1.starterFragment
            if (r0 == 0) goto L1a
            if (r0 != 0) goto L14
            java.lang.String r0 = "starterFragment"
            ir.nasim.AbstractC13042fc3.y(r0)
            r0 = 0
        L14:
            boolean r0 = r0.h9()
            if (r0 == 0) goto L1d
        L1a:
            r1.f3()
        L1d:
            ir.nasim.features.payment.view.activity.CardPaymentActivity$a r0 = ir.nasim.features.payment.view.activity.CardPaymentActivity.INSTANCE
            boolean r0 = r0.b(r2)
            if (r0 == 0) goto L28
            r1.Q2(r2)
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.activity.CardPaymentActivity.onNewIntent(android.content.Intent):void");
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        Z0 = true;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Z0 = false;
    }

    public final void x2(C11458d25 peer, G.a checkPeer) {
        C14733iO2 c14733iO2;
        AbstractC13042fc3.i(peer, "peer");
        AbstractC13042fc3.i(checkPeer, "checkPeer");
        ExPeerType exPeerTypeA = X25.a(peer);
        if (exPeerTypeA == null) {
            return;
        }
        if (!peer.z() || (c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(peer.getPeerId())) == null || c14733iO2.E().b() != W06.PRIVATE || ((Boolean) c14733iO2.F().b()).booleanValue()) {
            checkPeer.a(exPeerTypeA);
        }
    }
}
