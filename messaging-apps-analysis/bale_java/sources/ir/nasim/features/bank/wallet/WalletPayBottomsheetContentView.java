package ir.nasim.features.bank.wallet;

import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.WalletOuterClass$ResponseGetPaymentTokenByCard;
import ai.bale.proto.WalletOuterClass$ResponseVerifyPeer;
import ai.bale.proto.WalletOuterClass$ResponseVerifyQRCode;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Bitmap;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13130fi4;
import ir.nasim.AbstractC13554gQ7;
import ir.nasim.AbstractC17457n0;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC23348wm0;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C11458d25;
import ir.nasim.C11461d28;
import ir.nasim.C13932h38;
import ir.nasim.C14486i0;
import ir.nasim.C17944np2;
import ir.nasim.C18626oy5;
import ir.nasim.C19406qI3;
import ir.nasim.C21231tK7;
import ir.nasim.C21753u45;
import ir.nasim.C22055ub3;
import ir.nasim.C22889vz5;
import ir.nasim.C4705Gf0;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.C6510Nu7;
import ir.nasim.EnumC17422mw1;
import ir.nasim.EnumC9549a90;
import ir.nasim.InterfaceC12737f70;
import ir.nasim.InterfaceC13373g70;
import ir.nasim.InterfaceC14756iQ7;
import ir.nasim.InterfaceC15419jZ0;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.InterfaceC21596to4;
import ir.nasim.InterfaceC23769xU5;
import ir.nasim.J44;
import ir.nasim.KV0;
import ir.nasim.NI7;
import ir.nasim.TA5;
import ir.nasim.U38;
import ir.nasim.VL3;
import ir.nasim.W38;
import ir.nasim.X06;
import ir.nasim.XV4;
import ir.nasim.XY6;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.features.bank.BankiMoneyAmountView;
import ir.nasim.features.bank.wallet.WalletPayBottomsheetContentView;
import ir.nasim.features.root.AbstractC13089g;
import ir.nasim.features.root.RootActivity;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import org.xbill.DNS.Type;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001SB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J7\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010\u0012J\u0019\u0010 \u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010\u0012J\u000f\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b#\u0010\u0012J\u000f\u0010$\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010\u0012J\u000f\u0010%\u001a\u00020\u000fH\u0003¢\u0006\u0004\b%\u0010\u0012J\u0017\u0010'\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0016H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0016H\u0002¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020\u000fH\u0002¢\u0006\u0004\b,\u0010\u0012J\u000f\u0010-\u001a\u00020\u000fH\u0002¢\u0006\u0004\b-\u0010\u0012J\u0019\u0010/\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u000fH\u0002¢\u0006\u0004\b1\u0010\u0012J\u000f\u00102\u001a\u00020\u000fH\u0002¢\u0006\u0004\b2\u0010\u0012J\u000f\u00103\u001a\u00020\u000fH\u0002¢\u0006\u0004\b3\u0010\u0012J\u000f\u00104\u001a\u00020\u000fH\u0002¢\u0006\u0004\b4\u0010\u0012J\u000f\u00105\u001a\u00020\u000fH\u0002¢\u0006\u0004\b5\u0010\u0012J\u000f\u00106\u001a\u00020\u000fH\u0002¢\u0006\u0004\b6\u0010\u0012J\u001f\u0010;\u001a\u00020\u000f2\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J+\u0010?\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010>\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\bC\u0010DJ\u0017\u0010C\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010E¢\u0006\u0004\bC\u0010FJ\r\u0010G\u001a\u00020\u000f¢\u0006\u0004\bG\u0010\u0012J\u001d\u0010H\u001a\u00020\u000f2\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209¢\u0006\u0004\bH\u0010<J\u0019\u0010K\u001a\u00020\u000f2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bK\u0010LJ\u0019\u0010O\u001a\u00020\u000f2\b\u0010N\u001a\u0004\u0018\u00010MH\u0017¢\u0006\u0004\bO\u0010PJ\u001d\u0010Q\u001a\u00020\u000f2\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209¢\u0006\u0004\bQ\u0010<R\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001c\u0010Y\u001a\n V*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR$\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010LR\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020_8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010f\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010;R\u0016\u0010i\u001a\u00020g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010GR\u0014\u0010k\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\bj\u0010+R\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR$\u0010>\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010X\u001a\u0004\bq\u0010r\"\u0004\bs\u0010*R\u0018\u0010u\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010XR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010!R&\u0010\u0081\u0001\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001¨\u0006\u0089\u0001"}, d2 = {"Lir/nasim/features/bank/wallet/WalletPayBottomsheetContentView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Lme/dm7/barcodescanner/zxing/ZXingScannerView$b;", "Lir/nasim/to4;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", TokenNames.O, TokenNames.K, "()V", "t0", "u0", "D0", "", "token", "endpoint", "terminalId", "merchantId", "", "amount", TokenNames.V, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "h0", TokenNames.X, "(Ljava/lang/Long;)V", "e0", "J0", "c0", "j0", "walletUrl", TokenNames.L, "(Ljava/lang/String;)Ljava/lang/String;", "H0", "(Ljava/lang/String;)V", TokenNames.I, "q0", "p0", "tabPosition", "b0", "(Ljava/lang/Integer;)V", TokenNames.R, TokenNames.T, TokenNames.U, "H", "I0", "N", "Lir/nasim/J44;", "currentMessage", "Lir/nasim/d25;", "peer", "J", "(Lir/nasim/J44;Lir/nasim/d25;)V", "toWalletName", "walletId", "a0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lai/bale/proto/WalletOuterClass$ResponseVerifyQRCode;", "res", "setPic", "(Lai/bale/proto/WalletOuterClass$ResponseVerifyQRCode;)V", "Lai/bale/proto/WalletOuterClass$ResponseVerifyPeer;", "(Lai/bale/proto/WalletOuterClass$ResponseVerifyPeer;)V", "Z", "W", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "Lir/nasim/X06;", "rawResult", "p", "(Lir/nasim/X06;)V", "Q", "Lir/nasim/h38;", "a", "Lir/nasim/h38;", "binding", "kotlin.jvm.PlatformType", "b", "Ljava/lang/String;", "TAG", "c", "Lir/nasim/i0;", "getAbol", "()Lir/nasim/i0;", "setAbol", "Landroid/view/View;", "d", "Landroid/view/View;", "activeView", "e", "view", "f", "walletAmountRialBalance", "", "g", "payWithWallet", "h", "SHARE_REQUEST_CODE", "Lir/nasim/Nu7;", "i", "Lir/nasim/Nu7;", "viewModel", "j", "getWalletId", "()Ljava/lang/String;", "setWalletId", "k", "defaultWalletId", "l", "Ljava/lang/Long;", "getAmount", "()Ljava/lang/Long;", "setAmount", "m", "Lir/nasim/J44;", "getMsg", "()Lir/nasim/J44;", "setMsg", "(Lir/nasim/J44;)V", "msg", "n", "Lir/nasim/d25;", "msgPeer", "Lir/nasim/xU5;", "o", "Lir/nasim/xU5;", "requestPermissionsResultListener", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class WalletPayBottomsheetContentView extends RelativeLayout implements InterfaceC16866m0, ZXingScannerView.b, InterfaceC21596to4 {
    public static final int q = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final C13932h38 binding;

    /* renamed from: b, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: c, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: d, reason: from kotlin metadata */
    private View activeView;

    /* renamed from: e, reason: from kotlin metadata */
    private View view;

    /* renamed from: f, reason: from kotlin metadata */
    private long walletAmountRialBalance;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean payWithWallet;

    /* renamed from: h, reason: from kotlin metadata */
    private final int SHARE_REQUEST_CODE;

    /* renamed from: i, reason: from kotlin metadata */
    private final C6510Nu7 viewModel;

    /* renamed from: j, reason: from kotlin metadata */
    private String walletId;

    /* renamed from: k, reason: from kotlin metadata */
    private String defaultWalletId;

    /* renamed from: l, reason: from kotlin metadata */
    private Long amount;

    /* renamed from: m, reason: from kotlin metadata */
    private J44 msg;

    /* renamed from: n, reason: from kotlin metadata */
    private C11458d25 msgPeer;

    /* renamed from: o, reason: from kotlin metadata */
    private InterfaceC23769xU5 requestPermissionsResultListener;

    public static final class b implements InterfaceC15419jZ0 {
        final /* synthetic */ InterfaceC12737f70 b;

        b(InterfaceC12737f70 interfaceC12737f70) {
            this.b = interfaceC12737f70;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(WalletOuterClass$ResponseVerifyQRCode walletOuterClass$ResponseVerifyQRCode) {
            WalletPayBottomsheetContentView.this.N();
            View view = null;
            if ((walletOuterClass$ResponseVerifyQRCode != null ? walletOuterClass$ResponseVerifyQRCode.getTargetUserId() : null) != null) {
                VL3 vl3G = AbstractC5969Lp4.g();
                AbstractC13042fc3.f(walletOuterClass$ResponseVerifyQRCode.getTargetUserId());
                C21231tK7 c21231tK7 = (C21231tK7) vl3G.n(r3.getValue());
                if (c21231tK7 != null) {
                    String str = (String) c21231tK7.q().b();
                    if (str == null) {
                        str = (String) c21231tK7.r().b();
                    }
                    View view2 = WalletPayBottomsheetContentView.this.view;
                    if (view2 == null) {
                        AbstractC13042fc3.y("view");
                    } else {
                        view = view2;
                    }
                    ((TextView) view.findViewById(BC5.wallet_pay_verify_owner_value)).setText(str);
                    return;
                }
            }
            View view3 = WalletPayBottomsheetContentView.this.view;
            if (view3 == null) {
                AbstractC13042fc3.y("view");
                view3 = null;
            }
            ((TextView) view3.findViewById(BC5.wallet_pay_verify_owner_value)).setText(walletOuterClass$ResponseVerifyQRCode != null ? walletOuterClass$ResponseVerifyQRCode.getTargetWalletName() : null);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            String name;
            WalletPayBottomsheetContentView.this.N();
            C14486i0 abol = WalletPayBottomsheetContentView.this.getAbol();
            if (abol != null) {
                abol.g();
            }
            if (b.class.isAnonymousClass()) {
                name = b.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = b.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "Failed to pay", exc);
            this.b.e(AbstractC12217eE5.wallet_pay_qr_invalid, AbstractC12217eE5.wallet_pay_qr_invalid_title, null);
        }
    }

    public static final class c implements InterfaceC15419jZ0 {
        final /* synthetic */ Long b;

        c(Long l) {
            this.b = l;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(WalletOuterClass$ResponseVerifyQRCode walletOuterClass$ResponseVerifyQRCode) {
            WalletPayBottomsheetContentView.this.N();
            WalletPayBottomsheetContentView.this.setPic(walletOuterClass$ResponseVerifyQRCode);
            WalletPayBottomsheetContentView.this.findViewById(BC5.wallet_pay_tab_views).setVisibility(8);
            WalletPayBottomsheetContentView.this.findViewById(BC5.wallet_pay_transfer_type_view).setVisibility(0);
            Long l = this.b;
            if (l != null) {
                ((BankiMoneyAmountView) WalletPayBottomsheetContentView.this.findViewById(BC5.wallet_pay_transfer_type_amount)).setFixedAmount(String.valueOf(l.longValue()));
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            String name;
            InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
            Context context = WalletPayBottomsheetContentView.this.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            InterfaceC12737f70 interfaceC12737f70A = aVar.a(context);
            WalletPayBottomsheetContentView.this.N();
            if (c.class.isAnonymousClass()) {
                name = c.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = c.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "Failed to pay", exc);
            interfaceC12737f70A.e(AbstractC12217eE5.wallet_pay_qr_invalid, AbstractC12217eE5.wallet_pay_qr_invalid_title, null);
            C14486i0 abol = WalletPayBottomsheetContentView.this.getAbol();
            if (abol != null) {
                abol.g();
            }
        }
    }

    public static final class d implements InterfaceC15419jZ0 {
        d() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(WalletOuterClass$ResponseVerifyQRCode walletOuterClass$ResponseVerifyQRCode) {
            WalletPayBottomsheetContentView.this.N();
            WalletPayBottomsheetContentView.this.setPic(walletOuterClass$ResponseVerifyQRCode);
            WalletPayBottomsheetContentView.this.findViewById(BC5.wallet_pay_tab_views).setVisibility(8);
            WalletPayBottomsheetContentView.this.findViewById(BC5.wallet_pay_transfer_type_view).setVisibility(0);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            String name;
            InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
            Context context = WalletPayBottomsheetContentView.this.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            InterfaceC12737f70 interfaceC12737f70A = aVar.a(context);
            WalletPayBottomsheetContentView.this.N();
            if (d.class.isAnonymousClass()) {
                name = d.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = d.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "Failed to pay", exc);
            interfaceC12737f70A.e(AbstractC12217eE5.wallet_pay_qr_invalid, AbstractC12217eE5.wallet_pay_qr_invalid_title, null);
        }
    }

    public static final class e implements InterfaceC23769xU5 {
        e() {
        }

        @Override // ir.nasim.InterfaceC23769xU5
        public void a(int i, String[] strArr, int[] iArr) {
            AbstractC13042fc3.i(strArr, "permissions");
            AbstractC13042fc3.i(iArr, "grantResults");
            if (i == 8) {
                if ((!(iArr.length == 0)) && iArr[0] == 0) {
                    WalletPayBottomsheetContentView walletPayBottomsheetContentView = WalletPayBottomsheetContentView.this;
                    walletPayBottomsheetContentView.activeView = walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_scan_barcode_view);
                    View view = WalletPayBottomsheetContentView.this.activeView;
                    if (view == null) {
                        AbstractC13042fc3.y("activeView");
                        view = null;
                    }
                    view.setVisibility(0);
                    ((ZXingScannerView) WalletPayBottomsheetContentView.this.findViewById(BC5.wallet_pay_scanner)).f();
                    WalletPayBottomsheetContentView.this.J0();
                }
            }
        }
    }

    public static final class f implements TabLayout.d {
        f() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            WalletPayBottomsheetContentView.this.b0(gVar != null ? Integer.valueOf(gVar.h()) : null);
            if (gVar != null && gVar.h() == 0) {
                WalletPayBottomsheetContentView.this.R();
            } else {
                if (gVar == null || gVar.h() != 1) {
                    return;
                }
                ((ZXingScannerView) WalletPayBottomsheetContentView.this.findViewById(BC5.wallet_pay_scanner)).h();
                WalletPayBottomsheetContentView.this.U();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    public static final class g implements InterfaceC15419jZ0 {
        final /* synthetic */ long b;
        final /* synthetic */ InterfaceC12737f70 c;

        g(long j, InterfaceC12737f70 interfaceC12737f70) {
            this.b = j;
            this.c = interfaceC12737f70;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(WalletOuterClass$ResponseGetPaymentTokenByCard walletOuterClass$ResponseGetPaymentTokenByCard) {
            WalletPayBottomsheetContentView.this.N();
            if (walletOuterClass$ResponseGetPaymentTokenByCard != null) {
                WalletPayBottomsheetContentView walletPayBottomsheetContentView = WalletPayBottomsheetContentView.this;
                String token = walletOuterClass$ResponseGetPaymentTokenByCard.getToken();
                AbstractC13042fc3.h(token, "getToken(...)");
                String endpoint = walletOuterClass$ResponseGetPaymentTokenByCard.getEndpoint();
                AbstractC13042fc3.h(endpoint, "getEndpoint(...)");
                String terminalId = walletOuterClass$ResponseGetPaymentTokenByCard.getTerminalId();
                AbstractC13042fc3.h(terminalId, "getTerminalId(...)");
                String merchantId = walletOuterClass$ResponseGetPaymentTokenByCard.getMerchantId();
                AbstractC13042fc3.h(merchantId, "getMerchantId(...)");
                walletPayBottomsheetContentView.V(token, endpoint, terminalId, merchantId, this.b);
                C14486i0 abol = WalletPayBottomsheetContentView.this.getAbol();
                if (abol != null) {
                    abol.g();
                }
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            WalletPayBottomsheetContentView.this.N();
            InterfaceC12737f70 interfaceC12737f70 = this.c;
            int i = AbstractC12217eE5.bank_operation_failed;
            interfaceC12737f70.e(i, i, null);
        }
    }

    public static final class h implements InterfaceC15419jZ0 {
        final /* synthetic */ InterfaceC12737f70 b;

        h(InterfaceC12737f70 interfaceC12737f70) {
            this.b = interfaceC12737f70;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Misc$ResponseVoid misc$ResponseVoid) {
            WalletPayBottomsheetContentView.this.N();
            C14486i0 abol = WalletPayBottomsheetContentView.this.getAbol();
            if (abol != null) {
                abol.g();
            }
            InterfaceC12737f70 interfaceC12737f70 = this.b;
            int i = AbstractC12217eE5.bank_operation_succeed;
            InterfaceC12737f70.k(interfaceC12737f70, i, i, null, 4, null);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            WalletPayBottomsheetContentView.this.N();
            C14486i0 abol = WalletPayBottomsheetContentView.this.getAbol();
            if (abol != null) {
                abol.g();
            }
            InterfaceC12737f70 interfaceC12737f70 = this.b;
            int i = AbstractC12217eE5.bank_operation_failed;
            InterfaceC12737f70.f(interfaceC12737f70, i, i, null, 4, null);
        }
    }

    public static final class i implements InterfaceC15419jZ0 {
        final /* synthetic */ InterfaceC12737f70 b;

        i(InterfaceC12737f70 interfaceC12737f70) {
            this.b = interfaceC12737f70;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Misc$ResponseVoid misc$ResponseVoid) {
            WalletPayBottomsheetContentView.this.N();
            C14486i0 abol = WalletPayBottomsheetContentView.this.getAbol();
            if (abol != null) {
                abol.g();
            }
            InterfaceC12737f70 interfaceC12737f70 = this.b;
            int i = AbstractC12217eE5.bank_operation_succeed;
            InterfaceC12737f70.k(interfaceC12737f70, i, i, null, 4, null);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            WalletPayBottomsheetContentView.this.N();
            C14486i0 abol = WalletPayBottomsheetContentView.this.getAbol();
            if (abol != null) {
                abol.g();
            }
            InterfaceC12737f70 interfaceC12737f70 = this.b;
            int i = AbstractC12217eE5.bank_operation_failed;
            InterfaceC12737f70.f(interfaceC12737f70, i, i, null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletPayBottomsheetContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        C13932h38 c13932h38D = C13932h38.d(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c13932h38D, "inflate(...)");
        this.binding = c13932h38D;
        this.TAG = WalletPayBottomsheetContentView.class.getName();
        this.payWithWallet = true;
        this.SHARE_REQUEST_CODE = 10001;
        this.viewModel = new C6510Nu7(C5735Kp4.w().i().Y());
        O(context);
    }

    private static final boolean A0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, InterfaceC12737f70 interfaceC12737f70) {
        if (((BankiMoneyAmountView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_transfer_type_amount)).getAmount() <= walletPayBottomsheetContentView.walletAmountRialBalance || !walletPayBottomsheetContentView.payWithWallet) {
            return true;
        }
        interfaceC12737f70.i(AbstractC12217eE5.wallet_pay_amount_is_not_suffcient, AbstractC12217eE5.bank_operation_failed, null);
        ((BankiMoneyAmountView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_transfer_type_amount)).requestFocus();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        C14486i0 c14486i0 = walletPayBottomsheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        Context context = walletPayBottomsheetContentView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        WalletChargeBottomsheetContentView walletChargeBottomsheetContentView = new WalletChargeBottomsheetContentView(context);
        C14486i0 c14486i0 = walletPayBottomsheetContentView.abol;
        if (c14486i0 != null) {
            C14486i0.i(c14486i0, walletChargeBottomsheetContentView, false, 2, null);
        }
        walletChargeBottomsheetContentView.setAbolInstance(walletPayBottomsheetContentView.abol);
    }

    private final void D0() {
        InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        final InterfaceC12737f70 interfaceC12737f70A = aVar.a(context);
        ((BaleButton) findViewById(BC5.ok_button87)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.R28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.E0(this.a, interfaceC12737f70A, view);
            }
        });
        ((TextView) findViewById(BC5.wallet_pay_verify_bottomsheet_close)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.S28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.F0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, InterfaceC12737f70 interfaceC12737f70, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        AbstractC13042fc3.i(interfaceC12737f70, "$bankingDialogFactory");
        walletPayBottomsheetContentView.I0();
        String string = ((EditText) walletPayBottomsheetContentView.findViewById(BC5.et_wallet_pay_regarding)).getText().toString();
        long amount = ((BankiMoneyAmountView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_transfer_type_amount)).getAmount();
        EnumC17422mw1 enumC17422mw1 = EnumC17422mw1.RIAL;
        if (walletPayBottomsheetContentView.msg == null) {
            walletPayBottomsheetContentView.viewModel.t(walletPayBottomsheetContentView.defaultWalletId, walletPayBottomsheetContentView.walletId, amount, enumC17422mw1, string).a(walletPayBottomsheetContentView.new h(interfaceC12737f70));
            return;
        }
        C6510Nu7 c6510Nu7 = walletPayBottomsheetContentView.viewModel;
        String str = walletPayBottomsheetContentView.defaultWalletId;
        C11458d25 c11458d25 = walletPayBottomsheetContentView.msgPeer;
        AbstractC13042fc3.f(c11458d25);
        J44 j44 = walletPayBottomsheetContentView.msg;
        AbstractC13042fc3.f(j44);
        long jI = j44.i();
        J44 j442 = walletPayBottomsheetContentView.msg;
        AbstractC13042fc3.f(j442);
        c6510Nu7.r(str, c11458d25, jI, j442.h(), walletPayBottomsheetContentView.amount, string).a(walletPayBottomsheetContentView.new i(interfaceC12737f70));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        C14486i0 c14486i0 = walletPayBottomsheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    private final void H() {
        Object systemService = getContext().getSystemService("input_method");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View view = this.view;
        if (view == null) {
            AbstractC13042fc3.y("view");
            view = null;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private final void H0(String walletUrl) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", walletUrl);
        intent.setType("text/plain");
        Context context = getContext();
        AbstractC13042fc3.g(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).startActivityForResult(Intent.createChooser(intent, String.valueOf(AbstractC12217eE5.share_certificate)), this.SHARE_REQUEST_CODE);
    }

    private final void I(String walletUrl) {
        Context context = getContext();
        AbstractC13042fc3.f(context);
        Object systemService = context.getSystemService("clipboard");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("WalletId", walletUrl));
        if (KV0.b()) {
            Toast.makeText(getContext(), AbstractC12217eE5.toast_wallet_id_copied, 1).show();
        }
    }

    private final void I0() {
        findViewById(BC5.loading_shadow_1).setVisibility(0);
        findViewById(BC5.progress_bar_view_1).setVisibility(0);
    }

    private final void J(J44 currentMessage, C11458d25 peer) {
        this.msg = currentMessage;
        this.msgPeer = peer;
        InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        InterfaceC12737f70 interfaceC12737f70A = aVar.a(context);
        findViewById(BC5.wallet_pay_tab_views).setVisibility(8);
        findViewById(BC5.wallet_pay_transfer_type_view).setVisibility(8);
        findViewById(BC5.wallet_pay_verify_view).setVisibility(0);
        View view = this.view;
        View view2 = null;
        if (view == null) {
            AbstractC13042fc3.y("view");
            view = null;
        }
        ((TextView) view.findViewById(BC5.wallet_pay_verify_amount_value)).setText(XY6.e(XY6.c(String.valueOf(this.amount), (char) 0, 2, null)) + " ریال");
        View view3 = this.view;
        if (view3 == null) {
            AbstractC13042fc3.y("view");
        } else {
            view2 = view3;
        }
        ((TextView) view2.findViewById(BC5.wallet_pay_verify_wallet_id_title_value)).setText(this.walletId);
        H();
        I0();
        this.viewModel.u(this.walletId).a(new b(interfaceC12737f70A));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0() {
        InterfaceC23769xU5 interfaceC23769xU5 = this.requestPermissionsResultListener;
        if (interfaceC23769xU5 != null) {
            C5735Kp4.w().k().ua(interfaceC23769xU5);
        }
        this.requestPermissionsResultListener = null;
    }

    private final void K() {
        this.binding.e.c.setTypeface(C6011Lu2.i());
        this.binding.e.g.setTypeface(C6011Lu2.k());
        this.binding.e.e.b.setTypeface(C6011Lu2.i());
        this.binding.e.e.k.setTypeface(C6011Lu2.k());
        this.binding.e.e.f.setTypeface(C6011Lu2.k());
        this.binding.e.e.h.setTypeface(C6011Lu2.k());
        this.binding.e.e.c.setTypeface(C6011Lu2.k());
        this.binding.e.d.j.setTypeface(C6011Lu2.k());
        ((TextView) findViewById(BC5.wallet_pay_with_wallet_id_text)).setTypeface(C6011Lu2.i());
        ((AppCompatTextView) findViewById(BC5.wallet_pay_code)).setTypeface(C6011Lu2.k());
        ((TextView) findViewById(BC5.wallet_pay_regarding)).setTypeface(C6011Lu2.k());
        ((TextView) findViewById(BC5.wallet_pay_wallet_id_pay_with_scanner_text)).setTypeface(C6011Lu2.i());
        ((BaleButton) findViewById(BC5.enter_barcode_ok_button)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_transfer_type_bottomsheet_title)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_transfer_type_bottomsheet_close)).setTypeface(C6011Lu2.k());
        ((TextView) findViewById(BC5.wallet_pay_transfer_type_money_receiver_title)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_transfer_type_money_receiver_value)).setTypeface(C6011Lu2.k());
        ((TextView) findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_title)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_description)).setTypeface(C6011Lu2.k());
        ((TextView) findViewById(BC5.wallet_pay_amount_money_wallet_balance_title)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_amount_money_wallet_balance_value)).setTypeface(C6011Lu2.k());
        ((TextView) findViewById(BC5.wallet_pay_amount_money_wallet_balance_rial)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_amount_money_wallet_charge)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_verify_bottomsheet_title)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_verify_bottomsheet_close)).setTypeface(C6011Lu2.k());
        ((TextView) findViewById(BC5.wallet_pay_verify_amount_title)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_verify_amount_value)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_verify_owner_title)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_verify_owner_value)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_verify_wallet_id_title)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_verify_wallet_id_title_value)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_verify_source_title)).setTypeface(C6011Lu2.i());
        ((TextView) findViewById(BC5.wallet_pay_verify_source_wallet)).setTypeface(C6011Lu2.k());
        ((TextInputEditText) findViewById(BC5.et_wallet_pay_wallet_id)).setTypeface(C6011Lu2.k());
        ((TextView) findViewById(BC5.wallet_pay_verify_transfer_fee_description)).setTypeface(C6011Lu2.i());
    }

    private final String L(String walletUrl) {
        return walletUrl.subSequence(AbstractC20762sZ6.r0(walletUrl, Separators.SLASH, 0, false, 6, null) + 1, walletUrl.length()).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(WalletPayBottomsheetContentView walletPayBottomsheetContentView) throws IOException {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        ((ZXingScannerView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_scanner)).o(walletPayBottomsheetContentView);
        ((ZXingScannerView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_scanner)).setAutoFocus(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        findViewById(BC5.loading_shadow_1).setVisibility(8);
        findViewById(BC5.progress_bar_view_1).setVisibility(8);
    }

    private final void O(Context context) {
        this.view = this.binding.getRoot();
        c0();
        t0();
        u0();
        D0();
        e0();
        K();
        this.viewModel.j().f(new InterfaceC14756iQ7() { // from class: ir.nasim.M28
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                WalletPayBottomsheetContentView.P(this.a, (String) obj, abstractC13554gQ7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(WalletPayBottomsheetContentView walletPayBottomsheetContentView, String str, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        walletPayBottomsheetContentView.defaultWalletId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        FragmentActivity fragmentActivityQ7 = abstractC13089gK.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C21753u45 c21753u45 = C21753u45.a;
        if (!c21753u45.R(fragmentActivityQ7)) {
            AbstractC13042fc3.f(abstractC13089gK);
            C21753u45.k0(c21753u45, abstractC13089gK, 8, C21753u45.d.f, Integer.valueOf(AbstractC12217eE5.cameraBarCodeScanner_permission_desctiption), null, 16, null);
            return;
        }
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            ((ImageView) findViewById(BC5.wallet_pay_bottomsheet_flashlight)).setVisibility(0);
            ((ImageView) findViewById(BC5.wallet_pay_bottomsheet_flashlight)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.T28
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WalletPayBottomsheetContentView.S(this.a, view);
                }
            });
        }
        View viewFindViewById = findViewById(BC5.wallet_pay_scan_barcode_view);
        this.activeView = viewFindViewById;
        if (viewFindViewById == null) {
            AbstractC13042fc3.y("activeView");
            viewFindViewById = null;
        }
        viewFindViewById.setVisibility(0);
        ((ZXingScannerView) findViewById(BC5.wallet_pay_scanner)).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(WalletPayBottomsheetContentView walletPayBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        ((ZXingScannerView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_scanner)).j();
    }

    private final void T() {
        View viewFindViewById = findViewById(BC5.wallet_pay_enter_barcode_view);
        this.activeView = viewFindViewById;
        if (viewFindViewById == null) {
            AbstractC13042fc3.y("activeView");
            viewFindViewById = null;
        }
        viewFindViewById.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        View viewFindViewById = findViewById(BC5.wallet_pay_my_barcode_view);
        this.activeView = viewFindViewById;
        if (viewFindViewById == null) {
            AbstractC13042fc3.y("activeView");
            viewFindViewById = null;
        }
        viewFindViewById.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(String token, String endpoint, String terminalId, String merchantId, long amount) {
        try {
            C21231tK7 c21231tK7C = AbstractC5969Lp4.c();
            AbstractC13042fc3.f(c21231tK7C);
            long jA = ((NI7) ((ArrayList) c21231tK7C.u().b()).get(0)).a();
            StringBuilder sb = new StringBuilder();
            sb.append(jA);
            String string = sb.toString();
            if (AbstractC20153rZ6.S(string, "9811", false, 2, null)) {
                AbstractC13042fc3.h(string.substring(4), "substring(...)");
            } else if (AbstractC20153rZ6.S(string, "98", false, 2, null)) {
                AbstractC13042fc3.h(string.substring(2), "substring(...)");
            }
        } catch (Exception unused) {
        }
        RootActivity.Companion.i(RootActivity.INSTANCE, null, "action_set_payment_original_token_and_set_payment_end_point", AbstractC23348wm0.b(new XV4("arg_payment_original_token", token), new XV4("arg_payment_end_point", endpoint)), 1, null);
        C22055ub3.a.o("https://sadad.shaparak.ir/VPG/Purchase?Token=" + token, C5721Ko.a.d());
    }

    private final void X(Long amount) {
        H();
        I0();
        this.payWithWallet = true;
        this.viewModel.u(this.walletId).a(new c(amount));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(Integer tabPosition) {
        View view = this.activeView;
        if (view == null) {
            AbstractC13042fc3.y("activeView");
            view = null;
        }
        view.setVisibility(8);
        H();
        if (tabPosition != null && tabPosition.intValue() == 1) {
            return;
        }
        ((ImageView) findViewById(BC5.wallet_pay_bottomsheet_flashlight)).setVisibility(8);
        ((ZXingScannerView) findViewById(BC5.wallet_pay_scanner)).h();
    }

    private final void c0() {
        setBackgroundColor(AbstractC4043Dl1.c(getContext(), TA5.c5));
        this.binding.e.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.N28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.d0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        C14486i0 c14486i0 = walletPayBottomsheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    private final void e0() {
        e eVar = new e();
        C5735Kp4.w().k().ta(eVar);
        this.requestPermissionsResultListener = eVar;
    }

    private final void h0() {
        ((TextInputEditText) findViewById(BC5.et_wallet_pay_wallet_id)).setRawInputType(2);
        ((BaleButton) findViewById(BC5.enter_barcode_ok_button)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.e38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.i0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        walletPayBottomsheetContentView.walletId = String.valueOf(((TextInputEditText) walletPayBottomsheetContentView.findViewById(BC5.et_wallet_pay_wallet_id)).getText());
        Editable text = ((TextInputEditText) walletPayBottomsheetContentView.findViewById(BC5.et_wallet_pay_wallet_id)).getText();
        if (text != null && !AbstractC20762sZ6.n0(text)) {
            walletPayBottomsheetContentView.Z();
            return;
        }
        InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
        Context context = walletPayBottomsheetContentView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        aVar.a(context).i(AbstractC12217eE5.wallet_pay_merchant_id_dialog_is_null, AbstractC12217eE5.bank_operation_failed, null);
        ((TextInputEditText) walletPayBottomsheetContentView.findViewById(BC5.et_wallet_pay_wallet_id)).requestFocus();
    }

    private final void j0() {
        final C11461d28 c11461d28Y = AbstractC5969Lp4.d().Y().Y();
        final C22889vz5 c22889vz5 = new C22889vz5();
        c11461d28Y.B().f(new InterfaceC14756iQ7() { // from class: ir.nasim.f38
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                WalletPayBottomsheetContentView.l0(c11461d28Y, c22889vz5, this, (String) obj, abstractC13554gQ7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(C11461d28 c11461d28, final C22889vz5 c22889vz5, final WalletPayBottomsheetContentView walletPayBottomsheetContentView, String str, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c22889vz5, "$writer");
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        if (str == null || str.length() == 0) {
            return;
        }
        final int i2 = C5495Jo7.a.J2() ? -1 : -16777216;
        W38 w38 = (W38) c11461d28.E().n(str.hashCode());
        if (w38 == null) {
            return;
        }
        w38.e().f(new InterfaceC14756iQ7() { // from class: ir.nasim.U28
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ72) {
                WalletPayBottomsheetContentView.m0(c22889vz5, i2, walletPayBottomsheetContentView, (String) obj, abstractC13554gQ72);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(C22889vz5 c22889vz5, int i2, final WalletPayBottomsheetContentView walletPayBottomsheetContentView, final String str, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c22889vz5, "$writer");
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        C4705Gf0 c4705Gf0A = c22889vz5.a(str, EnumC9549a90.QR_CODE, Type.TSIG, Type.TSIG);
        int iM = c4705Gf0A.m();
        int i3 = c4705Gf0A.i();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iM, i3, Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        for (int i4 = 0; i4 < iM; i4++) {
            for (int i5 = 0; i5 < i3; i5++) {
                bitmapCreateBitmap.setPixel(i4, i5, c4705Gf0A.e(i4, i5) ? i2 : 0);
            }
        }
        ((ImageView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_my_barcode_image)).setImageBitmap(bitmapCreateBitmap);
        ((ImageView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_my_barcode_image)).setScaleType(ImageView.ScaleType.FIT_XY);
        ((TextView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_my_barcode_link)).setText(str);
        ((CardView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_my_barcode_link_share_card_view)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.V28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.n0(this.a, str, view);
            }
        });
        ((TextView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_my_barcode_link)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.W28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.o0(this.a, str, view);
            }
        });
        TextView textView = walletPayBottomsheetContentView.binding.e.e.b;
        AbstractC13042fc3.f(str);
        textView.setText(XY6.e(walletPayBottomsheetContentView.L(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, String str, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        AbstractC13042fc3.f(str);
        walletPayBottomsheetContentView.H0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, String str, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        AbstractC13042fc3.f(str);
        walletPayBottomsheetContentView.I(str);
    }

    private final void p0() {
        ((ZXingScannerView) findViewById(BC5.wallet_pay_scanner)).setAspectTolerance(0.5f);
        ((ZXingScannerView) findViewById(BC5.wallet_pay_scanner)).setResultHandler(this);
        C14486i0 c14486i0 = this.abol;
        if (c14486i0 != null) {
            c14486i0.l(new C14486i0.b() { // from class: ir.nasim.Q28
                @Override // ir.nasim.C14486i0.b
                public final void onDismiss() {
                    WalletPayBottomsheetContentView.setupScanner$lambda$19(this.a);
                }
            });
        }
    }

    private final void q0() {
        this.activeView = findViewById(BC5.wallet_pay_my_barcode_view);
        U();
        ((TabLayout) findViewById(BC5.wallet_pay_tabs)).setVisibility(0);
        ((TabLayout) findViewById(BC5.wallet_pay_tabs)).e(((TabLayout) findViewById(BC5.wallet_pay_tabs)).B().x(AbstractC12217eE5.wallet_pay_tabs_scan_barcode));
        ((TabLayout) findViewById(BC5.wallet_pay_tabs)).e(((TabLayout) findViewById(BC5.wallet_pay_tabs)).B().x(AbstractC12217eE5.wallet_pay_tabs_my_barcode));
        TabLayout.g gVarY = ((TabLayout) findViewById(BC5.wallet_pay_tabs)).y(1);
        if (gVarY != null) {
            gVarY.n();
        }
        ((TabLayout) findViewById(BC5.wallet_pay_tabs)).d(new f());
        findViewById(BC5.wallet_pay_with_wallet_id).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.O28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.r0(this.a, view);
            }
        });
        ((ConstraintLayout) findViewById(BC5.wallet_pay_wallet_id_pay_with_scanner)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.P28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.s0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        walletPayBottomsheetContentView.b0(null);
        walletPayBottomsheetContentView.binding.e.c.setText(walletPayBottomsheetContentView.getResources().getString(AbstractC12217eE5.wallet_pay_verify_title));
        ((TabLayout) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_tabs)).setVisibility(8);
        ((ZXingScannerView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_scanner)).h();
        walletPayBottomsheetContentView.T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        ((TabLayout) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_tabs)).setVisibility(0);
        walletPayBottomsheetContentView.b0(null);
        walletPayBottomsheetContentView.binding.e.c.setText(walletPayBottomsheetContentView.getResources().getString(AbstractC12217eE5.wallet_pay_title));
        walletPayBottomsheetContentView.R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupScanner$lambda$19(WalletPayBottomsheetContentView walletPayBottomsheetContentView) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        ((ZXingScannerView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_scanner)).h();
    }

    private final void t0() {
        q0();
        j0();
        p0();
        h0();
    }

    private final void u0() {
        InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        final InterfaceC12737f70 interfaceC12737f70A = aVar.a(context);
        ((ConstraintLayout) findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_wallet_inside)).setSelected(true);
        this.viewModel.i().f(new InterfaceC14756iQ7() { // from class: ir.nasim.Y28
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                WalletPayBottomsheetContentView.v0(this.a, (Long) obj, abstractC13554gQ7);
            }
        });
        ((ConstraintLayout) findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_card_inside)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Z28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                WalletPayBottomsheetContentView.w0(this.a, view);
            }
        });
        ((ConstraintLayout) findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_wallet_inside)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.a38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                WalletPayBottomsheetContentView.x0(this.a, view);
            }
        });
        ((BaleButton) findViewById(BC5.transfer_type_ok_button)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.b38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.y0(this.a, interfaceC12737f70A, view);
            }
        });
        ((TextView) findViewById(BC5.wallet_pay_transfer_type_bottomsheet_close)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.c38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.B0(this.a, view);
            }
        });
        ((TextView) findViewById(BC5.wallet_pay_amount_money_wallet_charge)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.d38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletPayBottomsheetContentView.C0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, Long l, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        if (l != null) {
            walletPayBottomsheetContentView.walletAmountRialBalance = l.longValue();
        }
        ((TextView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_wallet_balance_value)).setText(XY6.d(String.valueOf(l)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, View view) throws Resources.NotFoundException {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        walletPayBottomsheetContentView.payWithWallet = false;
        view.setSelected(true);
        ((ConstraintLayout) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_wallet_inside)).setSelected(false);
        int color = walletPayBottomsheetContentView.getContext().getResources().getColor(TA5.secondary);
        int color2 = walletPayBottomsheetContentView.getContext().getResources().getColor(TA5.c9);
        ((ImageView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_card_icon)).setColorFilter(color);
        ((TextView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_card_title)).setTextColor(color);
        ((ImageView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_wallet_icon)).setColorFilter(color2);
        ((TextView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_wallet_title)).setTextColor(color2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, View view) throws Resources.NotFoundException {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        walletPayBottomsheetContentView.payWithWallet = true;
        view.setSelected(true);
        ((ConstraintLayout) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_card_inside)).setSelected(false);
        int color = walletPayBottomsheetContentView.getContext().getResources().getColor(TA5.c9);
        int color2 = walletPayBottomsheetContentView.getContext().getResources().getColor(TA5.secondary);
        ((ImageView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_card_icon)).setColorFilter(color);
        ((TextView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_card_title)).setTextColor(color);
        ((ImageView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_wallet_icon)).setColorFilter(color2);
        ((TextView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_amount_money_receiver_transfer_type_wallet_title)).setTextColor(color2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(WalletPayBottomsheetContentView walletPayBottomsheetContentView, InterfaceC12737f70 interfaceC12737f70, View view) {
        AbstractC13042fc3.i(walletPayBottomsheetContentView, "this$0");
        AbstractC13042fc3.i(interfaceC12737f70, "$bankingDialog");
        walletPayBottomsheetContentView.amount = Long.valueOf(((BankiMoneyAmountView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_transfer_type_amount)).getAmount());
        if (z0(walletPayBottomsheetContentView) && A0(walletPayBottomsheetContentView, interfaceC12737f70) && walletPayBottomsheetContentView.walletId != null) {
            if (walletPayBottomsheetContentView.payWithWallet) {
                walletPayBottomsheetContentView.a0(((TextView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_transfer_type_money_receiver_value)).getText().toString(), String.valueOf(walletPayBottomsheetContentView.amount), walletPayBottomsheetContentView.walletId);
                return;
            }
            walletPayBottomsheetContentView.I0();
            long amount = ((BankiMoneyAmountView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_transfer_type_amount)).getAmount();
            walletPayBottomsheetContentView.viewModel.s(walletPayBottomsheetContentView.walletId, amount, "").a(walletPayBottomsheetContentView.new g(amount, interfaceC12737f70));
        }
    }

    private static final boolean z0(WalletPayBottomsheetContentView walletPayBottomsheetContentView) {
        if (((BankiMoneyAmountView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_transfer_type_amount)).t0()) {
            return true;
        }
        ((BankiMoneyAmountView) walletPayBottomsheetContentView.findViewById(BC5.wallet_pay_transfer_type_amount)).w0();
        return false;
    }

    public final void Q(J44 currentMessage, C11458d25 peer) {
        AbstractC13042fc3.i(currentMessage, "currentMessage");
        AbstractC13042fc3.i(peer, "peer");
        J(currentMessage, peer);
    }

    public final void W(J44 currentMessage, C11458d25 peer) {
        AbstractC13042fc3.i(currentMessage, "currentMessage");
        AbstractC13042fc3.i(peer, "peer");
        this.msg = currentMessage;
        this.msgPeer = peer;
        Long lValueOf = null;
        AbstractC17457n0 abstractC17457n0F = currentMessage != null ? currentMessage.F() : null;
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PurchaseContent");
        C18626oy5 c18626oy5 = (C18626oy5) abstractC17457n0F;
        if (c18626oy5.u() instanceof C17944np2) {
            AbstractC13130fi4 abstractC13130fi4U = c18626oy5.u();
            AbstractC13042fc3.g(abstractC13130fi4U, "null cannot be cast to non-null type ir.nasim.core.modules.banking.FixedMoneyRequestAmount");
            lValueOf = Long.valueOf(((C17944np2) abstractC13130fi4U).c());
        }
        X(lValueOf);
    }

    public final void Z() {
        H();
        I0();
        this.viewModel.u(this.walletId).a(new d());
    }

    public final void a0(String toWalletName, String amount, String walletId) {
        H();
        View view = this.view;
        View view2 = null;
        if (view == null) {
            AbstractC13042fc3.y("view");
            view = null;
        }
        ((TextView) view.findViewById(BC5.wallet_pay_verify_owner_value)).setText(toWalletName);
        View view3 = this.view;
        if (view3 == null) {
            AbstractC13042fc3.y("view");
            view3 = null;
        }
        ((TextView) view3.findViewById(BC5.wallet_pay_verify_amount_value)).setText(XY6.e(XY6.c(amount, (char) 0, 2, null)) + " ریال");
        View view4 = this.view;
        if (view4 == null) {
            AbstractC13042fc3.y("view");
        } else {
            view2 = view4;
        }
        ((TextView) view2.findViewById(BC5.wallet_pay_verify_wallet_id_title_value)).setText(XY6.e(walletId));
        findViewById(BC5.wallet_pay_transfer_type_view).setVisibility(8);
        findViewById(BC5.wallet_pay_verify_view).setVisibility(0);
    }

    public final C14486i0 getAbol() {
        return this.abol;
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final J44 getMsg() {
        return this.msg;
    }

    public final String getWalletId() {
        return this.walletId;
    }

    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView.b
    public void p(X06 rawResult) throws Resources.NotFoundException {
        String strF = rawResult != null ? rawResult.f() : null;
        AbstractC13042fc3.f(strF);
        if (!U38.b(strF)) {
            Toast.makeText(getContext(), AbstractC12217eE5.wallet_pay_qr_invalid, 0);
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.X28
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    WalletPayBottomsheetContentView.M(this.a);
                }
            }, 2000L);
        } else {
            this.walletId = U38.a(strF);
            ((ZXingScannerView) findViewById(BC5.wallet_pay_scanner)).h();
            Z();
        }
    }

    public final void setAbol(C14486i0 c14486i0) {
        this.abol = c14486i0;
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }

    public final void setAmount(Long l) {
        this.amount = l;
    }

    public final void setMsg(J44 j44) {
        this.msg = j44;
    }

    public final void setPic(WalletOuterClass$ResponseVerifyQRCode res) {
        if ((res != null ? res.getTargetUserId() : null) != null) {
            VL3 vl3G = AbstractC5969Lp4.g();
            AbstractC13042fc3.f(res.getTargetUserId());
            C21231tK7 c21231tK7 = (C21231tK7) vl3G.n(r2.getValue());
            if (c21231tK7 != null) {
                String str = (String) c21231tK7.q().b();
                if (str == null) {
                    str = (String) c21231tK7.r().b();
                }
                ((TextView) findViewById(BC5.wallet_pay_transfer_type_money_receiver_value)).setText(str);
                ((AvatarViewGlide) findViewById(BC5.wallet_pay_transfer_type_money_receiver_pic)).B(22.0f, true);
                AvatarViewGlide.u((AvatarViewGlide) findViewById(BC5.wallet_pay_transfer_type_money_receiver_pic), c21231tK7, null, 2, null);
                return;
            }
        }
        ((TextView) findViewById(BC5.wallet_pay_transfer_type_money_receiver_value)).setText(res != null ? res.getTargetWalletName() : null);
    }

    public final void setWalletId(String str) {
        this.walletId = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletPayBottomsheetContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        C13932h38 c13932h38D = C13932h38.d(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c13932h38D, "inflate(...)");
        this.binding = c13932h38D;
        this.TAG = WalletPayBottomsheetContentView.class.getName();
        this.payWithWallet = true;
        this.SHARE_REQUEST_CODE = 10001;
        this.viewModel = new C6510Nu7(C5735Kp4.w().i().Y());
        O(context);
    }

    public final void setPic(WalletOuterClass$ResponseVerifyPeer res) {
        if ((res != null ? res.getTargetUserId() : null) != null) {
            VL3 vl3G = AbstractC5969Lp4.g();
            AbstractC13042fc3.f(res.getTargetUserId());
            C21231tK7 c21231tK7 = (C21231tK7) vl3G.n(r2.getValue());
            if (c21231tK7 != null) {
                String str = (String) c21231tK7.q().b();
                if (str == null) {
                    str = (String) c21231tK7.r().b();
                }
                ((TextView) findViewById(BC5.wallet_pay_transfer_type_money_receiver_value)).setText(str);
                ((AvatarViewGlide) findViewById(BC5.wallet_pay_transfer_type_money_receiver_pic)).B(22.0f, true);
                AvatarViewGlide.u((AvatarViewGlide) findViewById(BC5.wallet_pay_transfer_type_money_receiver_pic), c21231tK7, null, 2, null);
                return;
            }
        }
        ((TextView) findViewById(BC5.wallet_pay_transfer_type_money_receiver_value)).setText(res != null ? res.getTargetWalletName() : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletPayBottomsheetContentView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        C13932h38 c13932h38D = C13932h38.d(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c13932h38D, "inflate(...)");
        this.binding = c13932h38D;
        this.TAG = WalletPayBottomsheetContentView.class.getName();
        this.payWithWallet = true;
        this.SHARE_REQUEST_CODE = 10001;
        this.viewModel = new C6510Nu7(C5735Kp4.w().i().Y());
        O(context);
    }
}
