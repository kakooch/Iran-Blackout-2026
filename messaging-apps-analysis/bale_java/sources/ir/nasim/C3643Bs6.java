package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7190Qq6;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C3643Bs6;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20370rt6;
import ir.nasim.TR;
import ir.nasim.components.appbar.view.DrawerToolbar;
import ir.nasim.core.modules.banking.entity.MyBankData;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.designsystem.WalletMoreOptionsBottomsheetContentView;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u0000 \u009c\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u009d\u0001\u009e\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010 \u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J/\u0010&\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010)Jw\u00104\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001e2\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u0002¢\u0006\u0004\b4\u00105J#\u00107\u001a\u0002062\b\u0010+\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b7\u00108J#\u00109\u001a\u0002062\b\u0010+\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b9\u00108J\u0017\u0010;\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020:H\u0002¢\u0006\u0004\b;\u0010<J!\u0010?\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u001e2\u0006\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b?\u0010@J+\u0010H\u001a\u00020G2\u0006\u0010B\u001a\u00020A2\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\u000b2\u0006\u0010J\u001a\u000206H\u0016¢\u0006\u0004\bK\u0010LJ!\u0010N\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020G2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u000bH\u0016¢\u0006\u0004\bP\u0010\u0006J\u000f\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u001eH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u000bH\u0016¢\u0006\u0004\bW\u0010\u0006J\u0017\u0010X\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\bX\u0010)J\u0017\u0010Y\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\bY\u0010)J\u000f\u0010Z\u001a\u00020\u000bH\u0016¢\u0006\u0004\bZ\u0010\u0006R\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\\\u0010]R\u001b\u0010d\u001a\u00020_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR$\u0010l\u001a\u0004\u0018\u00010e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010nR\u0016\u0010t\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010sR\"\u0010~\u001a\u00020w8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R)\u0010\u0086\u0001\u001a\u00020\u007f8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R*\u0010\u008e\u0001\u001a\u00030\u0087\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R*\u0010\u0096\u0001\u001a\u00030\u008f\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R \u0010\u009b\u0001\u001a\u00030\u0097\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0098\u0001\u0010a\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001¨\u0006¤\u0001²\u0006\u000e\u0010 \u0001\u001a\u00030\u009f\u00018\nX\u008a\u0084\u0002²\u0006\u000f\u0010¡\u0001\u001a\u0002068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010£\u0001\u001a\u00030¢\u00018\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/Bs6;", "Lir/nasim/ua0;", "Lir/nasim/no4;", "Lir/nasim/designsystem/WalletMoreOptionsBottomsheetContentView$a;", "Lir/nasim/to4;", "<init>", "()V", "Lir/nasim/rt6$g;", "walletSection", "Lir/nasim/px3;", "listState", "Lir/nasim/rB7;", "aa", "(Lir/nasim/rt6$g;Lir/nasim/px3;Lir/nasim/ub1;I)V", "", "urlString", "Wa", "(Ljava/lang/String;)Ljava/lang/String;", "Ca", "Ha", "Va", "url", "Lir/nasim/features/bank/mybank/webview/a;", "za", "(Ljava/lang/String;)Lir/nasim/features/bank/mybank/webview/a;", "wa", "()Lir/nasim/features/bank/mybank/webview/a;", "Lir/nasim/Bs6$c;", "servicesWebViewType", "urlParameter", "", "focusedSectionID", "Sa", "(Lir/nasim/Bs6$c;Ljava/lang/String;Ljava/lang/Integer;)V", "Lir/nasim/ot6;", "navigationType", "navigationCategoryID", "navigationDestinationUrl", "La", "(Lir/nasim/ot6;Ljava/lang/Integer;Ljava/lang/String;)V", "Na", "(Ljava/lang/String;)V", "action", "peerId", "peerType", "title", "eventKey", "badge", "serviceId", "", "Lir/nasim/core/modules/banking/entity/MyBankData$Item;", "menuItems", "Oa", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "", "Ja", "(Ljava/lang/Integer;Ljava/lang/Integer;)Z", "Ka", "", "Qa", "(J)V", "Landroid/content/Context;", "context", "Ra", "(Ljava/lang/Integer;Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", ParameterNames.HIDDEN, "W6", "(Z)V", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "Landroidx/fragment/app/Fragment;", "J0", "()Landroidx/fragment/app/Fragment;", "paddingValueInDp", "F2", "(I)V", "x1", "n2", "w4", "R6", "Lir/nasim/Iy2;", "h1", "Lir/nasim/Iy2;", "binding", "Lir/nasim/Nt6;", "i1", "Lir/nasim/Yu3;", "Ba", "()Lir/nasim/Nt6;", "viewModel", "Lir/nasim/designsystem/base/activity/BaseActivity;", "j1", "Lir/nasim/designsystem/base/activity/BaseActivity;", "ya", "()Lir/nasim/designsystem/base/activity/BaseActivity;", "setParent", "(Lir/nasim/designsystem/base/activity/BaseActivity;)V", "parent", "k1", "Lir/nasim/features/bank/mybank/webview/a;", "servicesWebViewFragment", "l1", "botsWebViewFragment", "m1", TokenNames.I, "appbarHeight", "n1", "composeViewHeight", "Lir/nasim/x88;", "o1", "Lir/nasim/x88;", "getWebViewModule", "()Lir/nasim/x88;", "setWebViewModule", "(Lir/nasim/x88;)V", "webViewModule", "Lir/nasim/dQ0;", "p1", "Lir/nasim/dQ0;", "xa", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "Lir/nasim/wR;", "q1", "Lir/nasim/wR;", "ua", "()Lir/nasim/wR;", "setAuthenticatorNavigator", "(Lir/nasim/wR;)V", "authenticatorNavigator", "Lir/nasim/wb0;", "r1", "Lir/nasim/wb0;", "va", "()Lir/nasim/wb0;", "setBaseSettingsNavigator", "(Lir/nasim/wb0;)V", "baseSettingsNavigator", "Lir/nasim/n10;", "s1", "Aa", "()Lir/nasim/n10;", "snackBar", "t1", "a", "c", "Lir/nasim/Gt6;", "uiState", "showBadgeDescriptionDialog", "", "pageAlpha", "services_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Bs6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3643Bs6 extends KX2 implements InterfaceC17936no4, WalletMoreOptionsBottomsheetContentView.a, InterfaceC21596to4 {
    public static final int u1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private C5346Iy2 binding;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: j1, reason: from kotlin metadata */
    private BaseActivity parent;

    /* renamed from: k1, reason: from kotlin metadata */
    private ir.nasim.features.bank.mybank.webview.a servicesWebViewFragment;

    /* renamed from: l1, reason: from kotlin metadata */
    private ir.nasim.features.bank.mybank.webview.a botsWebViewFragment;

    /* renamed from: m1, reason: from kotlin metadata */
    private int appbarHeight;

    /* renamed from: n1, reason: from kotlin metadata */
    private int composeViewHeight;

    /* renamed from: o1, reason: from kotlin metadata */
    public C23572x88 webViewModule;

    /* renamed from: p1, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: q1, reason: from kotlin metadata */
    public InterfaceC23146wR authenticatorNavigator;

    /* renamed from: r1, reason: from kotlin metadata */
    public InterfaceC23238wb0 baseSettingsNavigator;

    /* renamed from: s1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 snackBar;

    /* renamed from: ir.nasim.Bs6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19206px3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C19206px3 c19206px3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c19206px3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3643Bs6.this.new b(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0067 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008a A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r10.b
                r2 = 0
                r3 = 3
                r4 = 1
                r5 = 0
                r6 = 4
                r7 = 2
                if (r1 == 0) goto L2e
                if (r1 == r4) goto L2a
                if (r1 == r7) goto L26
                if (r1 == r3) goto L22
                if (r1 != r6) goto L1a
                ir.nasim.AbstractC10685c16.b(r11)
                goto L8b
            L1a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L22:
                ir.nasim.AbstractC10685c16.b(r11)
                goto L68
            L26:
                ir.nasim.AbstractC10685c16.b(r11)
                goto L5d
            L2a:
                ir.nasim.AbstractC10685c16.b(r11)
                goto L48
            L2e:
                ir.nasim.AbstractC10685c16.b(r11)
                ir.nasim.Bs6 r11 = ir.nasim.C3643Bs6.this
                ir.nasim.Nt6 r11 = ir.nasim.C3643Bs6.ha(r11)
                boolean r11 = r11.L1()
                if (r11 == 0) goto L94
                r10.b = r4
                r8 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r11 = ir.nasim.HG1.b(r8, r10)
                if (r11 != r0) goto L48
                return r0
            L48:
                ir.nasim.px3 r11 = r10.d
                r1 = 1056964608(0x3f000000, float:0.5)
                r4 = 1142292480(0x44160000, float:600.0)
                ir.nasim.pJ6 r1 = ir.nasim.AbstractC5999Lt.j(r1, r4, r5, r6, r5)
                r10.b = r7
                r4 = 1133903872(0x43960000, float:300.0)
                java.lang.Object r11 = ir.nasim.AbstractC7778Td6.a(r11, r4, r1, r10)
                if (r11 != r0) goto L5d
                return r0
            L5d:
                r10.b = r3
                r3 = 50
                java.lang.Object r11 = ir.nasim.HG1.b(r3, r10)
                if (r11 != r0) goto L68
                return r0
            L68:
                ir.nasim.px3 r11 = r10.d
                ir.nasim.cw1 r1 = new ir.nasim.cw1
                r3 = 1050924810(0x3ea3d70a, float:0.32)
                r4 = 1065353216(0x3f800000, float:1.0)
                r8 = 1059648963(0x3f28f5c3, float:0.66)
                r9 = 1062333317(0x3f51eb85, float:0.82)
                r1.<init>(r8, r9, r3, r4)
                r3 = 500(0x1f4, float:7.0E-43)
                ir.nasim.Rw7 r1 = ir.nasim.AbstractC5999Lt.l(r3, r2, r1, r7, r5)
                r10.b = r6
                r3 = -1013579776(0xffffffffc3960000, float:-300.0)
                java.lang.Object r11 = ir.nasim.AbstractC7778Td6.a(r11, r3, r1, r10)
                if (r11 != r0) goto L8b
                return r0
            L8b:
                ir.nasim.Bs6 r11 = ir.nasim.C3643Bs6.this
                ir.nasim.Nt6 r11 = ir.nasim.C3643Bs6.ha(r11)
                r11.Y1(r2)
            L94:
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3643Bs6.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Bs6$c */
    public static final class c {
        public static final c a = new c("AllServices", 0);
        public static final c b = new c("AllBots", 1);
        private static final /* synthetic */ c[] c;
        private static final /* synthetic */ F92 d;

        static {
            c[] cVarArrA = a();
            c = cVarArrA;
            d = G92.a(cVarArrA);
        }

        private c(String str, int i) {
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{a, b};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) c.clone();
        }
    }

    /* renamed from: ir.nasim.Bs6$d */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC8439Vz.values().length];
            try {
                iArr[EnumC8439Vz.URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC8439Vz.PEER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC8439Vz.USSD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC8439Vz.CARD2CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC8439Vz.CARD_BALANCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC8439Vz.PFM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC8439Vz.INVOICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC8439Vz.MONEY_REQUEST.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EnumC8439Vz.CROWDFUNDING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EnumC8439Vz.GIFT_PACKET.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EnumC8439Vz.INTENT_URL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[EnumC8439Vz.MENU.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[EnumC8439Vz.UNSUPPORTED_VALUE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[EnumC8439Vz.BILL.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[EnumC8439Vz.UNKNOWN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC18579ot6.values().length];
            try {
                iArr2[EnumC18579ot6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[EnumC18579ot6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[EnumC18579ot6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.Bs6$e */
    public static final class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            C3643Bs6.this.composeViewHeight = view.getHeight();
        }
    }

    /* renamed from: ir.nasim.Bs6$f */
    public static final class f implements View.OnLayoutChangeListener {
        public f() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            C3643Bs6.this.appbarHeight = view.getHeight();
        }
    }

    /* renamed from: ir.nasim.Bs6$g */
    public static final class g implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ C3643Bs6 b;

        public g(View view, C3643Bs6 c3643Bs6) {
            this.a = view;
            this.b = c3643Bs6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.Va();
        }
    }

    /* renamed from: ir.nasim.Bs6$h */
    static final class h implements InterfaceC14603iB2 {
        final /* synthetic */ ComposeView b;

        /* renamed from: ir.nasim.Bs6$h$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC9664aL6 a;
            final /* synthetic */ C3643Bs6 b;
            final /* synthetic */ ComposeView c;
            final /* synthetic */ float d;
            final /* synthetic */ float e;
            final /* synthetic */ InterfaceC9102Ym4 f;

            /* renamed from: ir.nasim.Bs6$h$a$a, reason: collision with other inner class name */
            static final class C0302a implements InterfaceC14603iB2 {
                final /* synthetic */ InterfaceC9664aL6 a;
                final /* synthetic */ C3643Bs6 b;
                final /* synthetic */ ComposeView c;
                final /* synthetic */ float d;
                final /* synthetic */ float e;
                final /* synthetic */ InterfaceC9102Ym4 f;

                /* renamed from: ir.nasim.Bs6$h$a$a$a, reason: collision with other inner class name */
                static final class C0303a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ InterfaceC9664aL6 c;
                    final /* synthetic */ C3643Bs6 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0303a(InterfaceC9664aL6 interfaceC9664aL6, C3643Bs6 c3643Bs6, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = interfaceC9664aL6;
                        this.d = c3643Bs6;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0303a(this.c, this.d, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        String strE = h.f(this.c).e();
                        if (strE != null) {
                            C3643Bs6 c3643Bs6 = this.d;
                            c3643Bs6.Aa().o(strE);
                            c3643Bs6.Ba().T1();
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0303a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$b */
                static final class b implements InterfaceC15796kB2 {
                    final /* synthetic */ InterfaceC20370rt6.g a;
                    final /* synthetic */ SA2 b;
                    final /* synthetic */ SA2 c;
                    final /* synthetic */ C3643Bs6 d;

                    b(InterfaceC20370rt6.g gVar, SA2 sa2, SA2 sa22, C3643Bs6 c3643Bs6) {
                        this.a = gVar;
                        this.b = sa2;
                        this.c = sa22;
                        this.d = c3643Bs6;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(C3643Bs6 c3643Bs6) {
                        AbstractC13042fc3.i(c3643Bs6, "this$0");
                        c3643Bs6.Ca();
                        return C19938rB7.a;
                    }

                    public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                        if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(4), 0.0f, 0.0f, 13, null);
                        QJ2 qj2E = this.a.e();
                        SA2 sa2 = this.b;
                        SA2 sa22 = this.c;
                        interfaceC22053ub1.W(784675475);
                        boolean zD = interfaceC22053ub1.D(this.d);
                        final C3643Bs6 c3643Bs6 = this.d;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.ht6
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C3643Bs6.h.a.C0302a.b.c(c3643Bs6);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10081b28.o(qj2E, eVarM, sa2, sa22, (SA2) objB, interfaceC22053ub1, 3504, 0);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$c */
                static final class c implements InterfaceC15796kB2 {
                    final /* synthetic */ InterfaceC20370rt6.g a;
                    final /* synthetic */ SA2 b;
                    final /* synthetic */ SA2 c;

                    c(InterfaceC20370rt6.g gVar, SA2 sa2, SA2 sa22) {
                        this.a = gVar;
                        this.b = sa2;
                        this.c = sa22;
                    }

                    public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                        if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else {
                            AbstractC10081b28.u(androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(4), 0.0f, 0.0f, 13, null), this.a.g(), this.b, this.c, interfaceC22053ub1, 3462, 0);
                        }
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$d */
                static final class d implements InterfaceC15796kB2 {
                    final /* synthetic */ SA2 a;

                    d(SA2 sa2) {
                        this.a = sa2;
                    }

                    public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                        if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else {
                            AbstractC12239eH0.g(androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(4), 0.0f, 0.0f, 13, null), this.a, interfaceC22053ub1, 54, 0);
                        }
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$e */
                static final class e implements InterfaceC14603iB2 {
                    final /* synthetic */ InterfaceC20370rt6.e a;
                    final /* synthetic */ SA2 b;

                    e(InterfaceC20370rt6.e eVar, SA2 sa2) {
                        this.a = eVar;
                        this.b = sa2;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else if (this.a.d() != EnumC19170pt6.d) {
                            CW.e(androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, C17784nZ1.q(12), 0.0f, 0.0f, 0.0f, 14, null), this.a.d().j(), this.a.d().q(), this.a.d().r(), this.b, interfaceC22053ub1, 24582, 0);
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$f */
                static final class f implements SA2 {
                    final /* synthetic */ InterfaceC14603iB2 a;
                    final /* synthetic */ C6472Nr6 b;
                    final /* synthetic */ int c;

                    f(InterfaceC14603iB2 interfaceC14603iB2, C6472Nr6 c6472Nr6, int i) {
                        this.a = interfaceC14603iB2;
                        this.b = c6472Nr6;
                        this.c = i;
                    }

                    public final void a() {
                        this.a.invoke(this.b, Integer.valueOf(this.c));
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$g */
                static final class g implements SA2 {
                    final /* synthetic */ InterfaceC14603iB2 a;
                    final /* synthetic */ C6472Nr6 b;
                    final /* synthetic */ int c;

                    g(InterfaceC14603iB2 interfaceC14603iB2, C6472Nr6 c6472Nr6, int i) {
                        this.a = interfaceC14603iB2;
                        this.b = c6472Nr6;
                        this.c = i;
                    }

                    public final void a() {
                        this.a.invoke(this.b, Integer.valueOf(this.c));
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$h, reason: collision with other inner class name */
                static final class C0304h implements InterfaceC14603iB2 {
                    final /* synthetic */ SA2 a;
                    final /* synthetic */ InterfaceC9664aL6 b;

                    C0304h(SA2 sa2, InterfaceC9664aL6 interfaceC9664aL6) {
                        this.a = sa2;
                        this.b = interfaceC9664aL6;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else if (h.f(this.b).f()) {
                            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, C17784nZ1.q(12), 0.0f, 0.0f, 0.0f, 14, null);
                            EnumC19170pt6 enumC19170pt6 = EnumC19170pt6.e;
                            CW.e(eVarM, enumC19170pt6.j(), enumC19170pt6.q(), enumC19170pt6.r(), this.a, interfaceC22053ub1, 24582, 0);
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$i */
                static final class i implements SA2 {
                    final /* synthetic */ InterfaceC14603iB2 a;
                    final /* synthetic */ int b;
                    final /* synthetic */ C7112Qi0 c;

                    i(InterfaceC14603iB2 interfaceC14603iB2, int i, C7112Qi0 c7112Qi0) {
                        this.a = interfaceC14603iB2;
                        this.b = i;
                        this.c = c7112Qi0;
                    }

                    public final void a() {
                        this.a.invoke(Integer.valueOf(this.b), this.c);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$j */
                static final class j implements InterfaceC14603iB2 {
                    final /* synthetic */ InterfaceC20370rt6.c a;
                    final /* synthetic */ SA2 b;

                    j(InterfaceC20370rt6.c cVar, SA2 sa2) {
                        this.a = cVar;
                        this.b = sa2;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else if (this.a.d() != EnumC19170pt6.d) {
                            CW.e(androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, C17784nZ1.q(12), 0.0f, 0.0f, 0.0f, 14, null), this.a.d().j(), this.a.d().q(), this.a.d().r(), this.b, interfaceC22053ub1, 24582, 0);
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$k */
                static final class k implements SA2 {
                    final /* synthetic */ C3643Bs6 a;
                    final /* synthetic */ InterfaceC20370rt6.c b;
                    final /* synthetic */ C7112Qi0 c;
                    final /* synthetic */ int d;

                    k(C3643Bs6 c3643Bs6, InterfaceC20370rt6.c cVar, C7112Qi0 c7112Qi0, int i) {
                        this.a = c3643Bs6;
                        this.b = cVar;
                        this.c = c7112Qi0;
                        this.d = i;
                    }

                    public final void a() {
                        this.a.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 6, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : Integer.valueOf(this.d + 1), (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(this.b.j()), (2262 & 512) != 0 ? null : Integer.valueOf(this.c.b()), (2262 & 1024) != 0 ? null : Integer.valueOf(ExPeerType.PRIVATE.getValue()), (2262 & 2048) == 0 ? null : null);
                        this.a.Qa(this.c.b());
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$l */
                static final class l implements InterfaceC14603iB2 {
                    final /* synthetic */ InterfaceC9102Ym4 a;

                    l(InterfaceC9102Ym4 interfaceC9102Ym4) {
                        this.a = interfaceC9102Ym4;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(InterfaceC9102Ym4 interfaceC9102Ym4) {
                        AbstractC13042fc3.i(interfaceC9102Ym4, "$showBadgeDescriptionDialog$delegate");
                        h.i(interfaceC9102Ym4, false);
                        return C19938rB7.a;
                    }

                    public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        C18140o91 c18140o91 = C18140o91.a;
                        InterfaceC14603iB2 interfaceC14603iB2A = c18140o91.a();
                        AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                        InterfaceC14603iB2 interfaceC14603iB2B = c18140o91.b();
                        AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                        InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                        interfaceC22053ub1.W(-1741840867);
                        final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.it6
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C3643Bs6.h.a.C0302a.l.c(interfaceC9102Ym4);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC19555qZ.T(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, null, c1454b, (SA2) objB, UY6.c(AbstractC12217eE5.dialog_ok, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 1573254 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.C1454b.b << 15), 16);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$m */
                public static final class m extends AbstractC8614Ws3 implements UA2 {
                    public static final m e = new m();

                    public m() {
                        super(1);
                    }

                    @Override // ir.nasim.UA2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Void invoke(Object obj) {
                        return null;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$n */
                public static final class n extends AbstractC8614Ws3 implements UA2 {
                    final /* synthetic */ UA2 e;
                    final /* synthetic */ List f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public n(UA2 ua2, List list) {
                        super(1);
                        this.e = ua2;
                        this.f = list;
                    }

                    public final Object a(int i) {
                        return this.e.invoke(this.f.get(i));
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return a(((Number) obj).intValue());
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$o */
                public static final class o extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                    final /* synthetic */ List e;
                    final /* synthetic */ SA2 f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public o(List list, SA2 sa2) {
                        super(4);
                        this.e = list;
                        this.f = sa2;
                    }

                    public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                        int i3;
                        if ((i2 & 6) == 0) {
                            i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
                        } else {
                            i3 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                        }
                        if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                        }
                        N50 n50 = (N50) this.e.get(i);
                        interfaceC22053ub1.W(121082879);
                        E40.g(n50.c(), n50.a(), n50.d(), n50.b(), this.f, interfaceC22053ub1, 24576, 0);
                        interfaceC22053ub1.Q();
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.P();
                        }
                    }

                    @Override // ir.nasim.InterfaceC16978mB2
                    public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                        a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$p */
                public static final class p extends AbstractC8614Ws3 implements UA2 {
                    final /* synthetic */ List e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public p(List list) {
                        super(1);
                        this.e = list;
                    }

                    public final Object a(int i) {
                        this.e.get(i);
                        return null;
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return a(((Number) obj).intValue());
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$q */
                public static final class q extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                    final /* synthetic */ List e;
                    final /* synthetic */ InterfaceC14603iB2 f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public q(List list, InterfaceC14603iB2 interfaceC14603iB2) {
                        super(4);
                        this.e = list;
                        this.f = interfaceC14603iB2;
                    }

                    public final void a(InterfaceC19187pv3 interfaceC19187pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                        int i3;
                        String strG;
                        StringBuilder sb;
                        String string;
                        String strF;
                        StringBuilder sb2;
                        if ((i2 & 6) == 0) {
                            i3 = (interfaceC22053ub1.V(interfaceC19187pv3) ? 4 : 2) | i2;
                        } else {
                            i3 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                        }
                        if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.Q(1229287273, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:579)");
                        }
                        Object obj = this.e.get(i);
                        int i4 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 14);
                        C6472Nr6 c6472Nr6 = (C6472Nr6) obj;
                        interfaceC22053ub1.W(-1433760437);
                        String strN = c6472Nr6.n();
                        if (C5495Jo7.a.J2()) {
                            String strC = c6472Nr6.c();
                            if (strC == null || strC.length() == 0) {
                                strF = c6472Nr6.f();
                                if (strF == null) {
                                    strF = c6472Nr6.g();
                                }
                                sb2 = new StringBuilder();
                            } else {
                                strF = c6472Nr6.c();
                                sb2 = new StringBuilder();
                            }
                            sb2.append(strF);
                            sb2.append(".svg");
                            string = sb2.toString();
                        } else {
                            String strD = c6472Nr6.d();
                            if (strD == null || strD.length() == 0) {
                                strG = c6472Nr6.g();
                                sb = new StringBuilder();
                            } else {
                                strG = c6472Nr6.d();
                                sb = new StringBuilder();
                            }
                            sb.append(strG);
                            sb.append(".svg");
                            string = sb.toString();
                        }
                        String str = string;
                        interfaceC22053ub1.W(785057622);
                        boolean zD = interfaceC22053ub1.D(c6472Nr6) | ((((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.e(i)) || (i4 & 48) == 32);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new g(this.f, c6472Nr6, i);
                            interfaceC22053ub1.s(objB);
                        }
                        SA2 sa2 = (SA2) objB;
                        interfaceC22053ub1.Q();
                        String strB = c6472Nr6.b();
                        AbstractC13313g10.o(strN, str, sa2, (strB == null || strB.length() == 0 || !c6472Nr6.m()) ? AbstractC7190Qq6.b.a : AbstractC7190Qq6.a.a, interfaceC22053ub1, 0, 0);
                        interfaceC22053ub1.Q();
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.P();
                        }
                    }

                    @Override // ir.nasim.InterfaceC16978mB2
                    public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                        a((InterfaceC19187pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$r */
                public static final class r extends AbstractC8614Ws3 implements UA2 {
                    final /* synthetic */ InterfaceC14603iB2 e;
                    final /* synthetic */ List f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public r(InterfaceC14603iB2 interfaceC14603iB2, List list) {
                        super(1);
                        this.e = interfaceC14603iB2;
                        this.f = list;
                    }

                    public final Object a(int i) {
                        return this.e.invoke(Integer.valueOf(i), this.f.get(i));
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return a(((Number) obj).intValue());
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$s */
                public static final class s extends AbstractC8614Ws3 implements UA2 {
                    final /* synthetic */ List e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public s(List list) {
                        super(1);
                        this.e = list;
                    }

                    public final Object a(int i) {
                        this.e.get(i);
                        return null;
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return a(((Number) obj).intValue());
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$t */
                public static final class t extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                    final /* synthetic */ List e;
                    final /* synthetic */ InterfaceC14603iB2 f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public t(List list, InterfaceC14603iB2 interfaceC14603iB2) {
                        super(4);
                        this.e = list;
                        this.f = interfaceC14603iB2;
                    }

                    public final void a(InterfaceC19187pv3 interfaceC19187pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                        int i3;
                        if ((i2 & 6) == 0) {
                            i3 = i2 | (interfaceC22053ub1.V(interfaceC19187pv3) ? 4 : 2);
                        } else {
                            i3 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                        }
                        if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.Q(1229287273, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:579)");
                        }
                        Object obj = this.e.get(i);
                        int i4 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 14);
                        C7112Qi0 c7112Qi0 = (C7112Qi0) obj;
                        interfaceC22053ub1.W(-1419532646);
                        androidx.compose.ui.e eVarB = InterfaceC19187pv3.b(interfaceC19187pv3, androidx.compose.ui.e.a, null, null, null, 7, null);
                        String strC = c7112Qi0.c();
                        Avatar avatarA = c7112Qi0.a();
                        interfaceC22053ub1.W(785503315);
                        boolean zD = interfaceC22053ub1.D(c7112Qi0) | ((((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.e(i)) || (i4 & 48) == 32);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new i(this.f, i, c7112Qi0);
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC5443Jj0.j(strC, eVarB, avatarA, (SA2) objB, interfaceC22053ub1, 0, 0);
                        interfaceC22053ub1.Q();
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.P();
                        }
                    }

                    @Override // ir.nasim.InterfaceC16978mB2
                    public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                        a((InterfaceC19187pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$u */
                public static final class u extends AbstractC8614Ws3 implements UA2 {
                    final /* synthetic */ InterfaceC14603iB2 e;
                    final /* synthetic */ List f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public u(InterfaceC14603iB2 interfaceC14603iB2, List list) {
                        super(1);
                        this.e = interfaceC14603iB2;
                        this.f = list;
                    }

                    public final Object a(int i) {
                        return this.e.invoke(Integer.valueOf(i), this.f.get(i));
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return a(((Number) obj).intValue());
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$v */
                public static final class v extends AbstractC8614Ws3 implements UA2 {
                    final /* synthetic */ List e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public v(List list) {
                        super(1);
                        this.e = list;
                    }

                    public final Object a(int i) {
                        this.e.get(i);
                        return null;
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return a(((Number) obj).intValue());
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$w */
                public static final class w extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                    final /* synthetic */ List e;
                    final /* synthetic */ C3643Bs6 f;
                    final /* synthetic */ InterfaceC20370rt6.c g;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public w(List list, C3643Bs6 c3643Bs6, InterfaceC20370rt6.c cVar) {
                        super(4);
                        this.e = list;
                        this.f = c3643Bs6;
                        this.g = cVar;
                    }

                    public final void a(InterfaceC19187pv3 interfaceC19187pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                        int i3;
                        if ((i2 & 6) == 0) {
                            i3 = i2 | (interfaceC22053ub1.V(interfaceC19187pv3) ? 4 : 2);
                        } else {
                            i3 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                        }
                        if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.Q(1229287273, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:579)");
                        }
                        Object obj = this.e.get(i);
                        int i4 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 14);
                        C7112Qi0 c7112Qi0 = (C7112Qi0) obj;
                        interfaceC22053ub1.W(-1413053026);
                        androidx.compose.ui.e eVarB = InterfaceC19187pv3.b(interfaceC19187pv3, androidx.compose.ui.e.a, null, null, null, 7, null);
                        String strC = c7112Qi0.c();
                        Avatar avatarA = c7112Qi0.a();
                        interfaceC22053ub1.W(785712335);
                        boolean zD = interfaceC22053ub1.D(this.f) | interfaceC22053ub1.V(this.g) | interfaceC22053ub1.D(c7112Qi0) | ((((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.e(i)) || (i4 & 48) == 32);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new k(this.f, this.g, c7112Qi0, i);
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC5443Jj0.j(strC, eVarB, avatarA, (SA2) objB, interfaceC22053ub1, 0, 0);
                        interfaceC22053ub1.Q();
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.P();
                        }
                    }

                    @Override // ir.nasim.InterfaceC16978mB2
                    public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                        a((InterfaceC19187pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$x */
                public static final class x extends AbstractC8614Ws3 implements UA2 {
                    final /* synthetic */ List e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public x(List list) {
                        super(1);
                        this.e = list;
                    }

                    public final Object a(int i) {
                        this.e.get(i);
                        return null;
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return a(((Number) obj).intValue());
                    }
                }

                /* renamed from: ir.nasim.Bs6$h$a$a$y */
                public static final class y extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                    final /* synthetic */ List e;
                    final /* synthetic */ InterfaceC14603iB2 f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public y(List list, InterfaceC14603iB2 interfaceC14603iB2) {
                        super(4);
                        this.e = list;
                        this.f = interfaceC14603iB2;
                    }

                    public final void a(InterfaceC19187pv3 interfaceC19187pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                        int i3;
                        String strG;
                        StringBuilder sb;
                        String string;
                        String strF;
                        StringBuilder sb2;
                        if ((i2 & 6) == 0) {
                            i3 = (interfaceC22053ub1.V(interfaceC19187pv3) ? 4 : 2) | i2;
                        } else {
                            i3 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                        }
                        if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.Q(1229287273, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:579)");
                        }
                        Object obj = this.e.get(i);
                        int i4 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 14);
                        C6472Nr6 c6472Nr6 = (C6472Nr6) obj;
                        interfaceC22053ub1.W(-1404570062);
                        String strN = c6472Nr6.n();
                        if (C5495Jo7.a.J2()) {
                            String strC = c6472Nr6.c();
                            if (strC == null || strC.length() == 0) {
                                strF = c6472Nr6.f();
                                if (strF == null) {
                                    strF = c6472Nr6.g();
                                }
                                sb2 = new StringBuilder();
                            } else {
                                strF = c6472Nr6.c();
                                sb2 = new StringBuilder();
                            }
                            sb2.append(strF);
                            sb2.append(".svg");
                            string = sb2.toString();
                        } else {
                            String strD = c6472Nr6.d();
                            if (strD == null || strD.length() == 0) {
                                strG = c6472Nr6.g();
                                sb = new StringBuilder();
                            } else {
                                strG = c6472Nr6.d();
                                sb = new StringBuilder();
                            }
                            sb.append(strG);
                            sb.append(".svg");
                            string = sb.toString();
                        }
                        String str = string;
                        interfaceC22053ub1.W(785999247);
                        boolean zD = interfaceC22053ub1.D(c6472Nr6) | ((((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.e(i)) || (i4 & 48) == 32);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new f(this.f, c6472Nr6, i);
                            interfaceC22053ub1.s(objB);
                        }
                        SA2 sa2 = (SA2) objB;
                        interfaceC22053ub1.Q();
                        String strB = c6472Nr6.b();
                        AbstractC13313g10.o(strN, str, sa2, (strB == null || strB.length() == 0 || !c6472Nr6.m()) ? AbstractC7190Qq6.b.a : AbstractC7190Qq6.a.a, interfaceC22053ub1, 0, 0);
                        interfaceC22053ub1.Q();
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.P();
                        }
                    }

                    @Override // ir.nasim.InterfaceC16978mB2
                    public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                        a((InterfaceC19187pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                        return C19938rB7.a;
                    }
                }

                C0302a(InterfaceC9664aL6 interfaceC9664aL6, C3643Bs6 c3643Bs6, ComposeView composeView, float f2, float f3, InterfaceC9102Ym4 interfaceC9102Ym4) {
                    this.a = interfaceC9664aL6;
                    this.b = c3643Bs6;
                    this.c = composeView;
                    this.d = f2;
                    this.e = f3;
                    this.f = interfaceC9102Ym4;
                }

                private static final float P(InterfaceC9664aL6 interfaceC9664aL6) {
                    return ((Number) interfaceC9664aL6.getValue()).floatValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 Q(C3643Bs6 c3643Bs6) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    c3643Bs6.Ba().v1();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 R(ComposeView composeView) {
                    AbstractC13042fc3.i(composeView, "$this_apply");
                    CardPaymentActivity.Companion companion = CardPaymentActivity.INSTANCE;
                    Context context = composeView.getContext();
                    AbstractC13042fc3.h(context, "getContext(...)");
                    CardPaymentActivity.Companion.f(companion, context, null, 2, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 S(InterfaceC20370rt6.g gVar, SA2 sa2, SA2 sa22, C3643Bs6 c3643Bs6, SA2 sa23, SA2 sa24, SA2 sa25, InterfaceC15069ix3 interfaceC15069ix3) {
                    AbstractC13042fc3.i(gVar, "$walletSection");
                    AbstractC13042fc3.i(sa2, "$onGoldWalletClick");
                    AbstractC13042fc3.i(sa22, "$onRetryFetchGoldWalletBalanceClicked");
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(sa23, "$onMoreOptionsClick");
                    AbstractC13042fc3.i(sa24, "$onRetryFetchWalletBalanceClicked");
                    AbstractC13042fc3.i(sa25, "$onCardClick");
                    AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyRow");
                    if (C8386Vt0.a.Q6()) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1560772278, true, new b(gVar, sa2, sa22, c3643Bs6)), 3, null);
                    }
                    InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(687382235, true, new c(gVar, sa23, sa24)), 3, null);
                    List listD = gVar.d();
                    if (listD != null) {
                        interfaceC15069ix3.a(listD.size(), null, new n(m.e, listD), AbstractC19242q11.c(-632812321, true, new o(listD, sa25)));
                    }
                    List listD2 = gVar.d();
                    if (listD2 == null || listD2.isEmpty()) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1494787155, true, new d(sa25)), 3, null);
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 T(C3643Bs6 c3643Bs6, InterfaceC20370rt6.f fVar, C12596es6 c12596es6) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(fVar, "$shortcutSection");
                    AbstractC13042fc3.i(c12596es6, "shortcutUI");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : c12596es6.f(), (2262 & 8) != 0 ? null : 2, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : null, (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(fVar.b()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    if (c12596es6.e() == 0) {
                        C3643Bs6.Ta(c3643Bs6, c.b, null, null, 6, null);
                    } else {
                        c3643Bs6.Sa(c.a, "&category=" + c12596es6.e(), Integer.valueOf(c12596es6.e()));
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 U(UA2 ua2, C12596es6 c12596es6) {
                    AbstractC13042fc3.i(ua2, "$onShortcutClick");
                    AbstractC13042fc3.i(c12596es6, "shortcutUI");
                    ua2.invoke(c12596es6);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 V(C3643Bs6 c3643Bs6, InterfaceC20370rt6.d dVar) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(dVar, "$customServicesSection");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 5, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : null, (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(dVar.b()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    C3643Bs6.Ta(c3643Bs6, c.a, null, null, 6, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 W(C3643Bs6 c3643Bs6, C6472Nr6 c6472Nr6, int i2) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(c6472Nr6, "item");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : c6472Nr6.n(), (2262 & 8) != 0 ? null : 3, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : Integer.valueOf(i2 + 1), (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(c6472Nr6.l()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    c3643Bs6.Oa(c6472Nr6.a(), c6472Nr6.o(), c6472Nr6.j(), c6472Nr6.k(), c6472Nr6.n(), c6472Nr6.e(), c6472Nr6.b(), Integer.valueOf(c6472Nr6.h()), c6472Nr6.i());
                    String strB = c6472Nr6.b();
                    if (strB != null && strB.length() != 0) {
                        c3643Bs6.Ba().q1(c6472Nr6.h());
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 X(InterfaceC20370rt6.d dVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC4369Ev3 interfaceC4369Ev3) {
                    AbstractC13042fc3.i(dVar, "$customServicesSection");
                    AbstractC13042fc3.i(interfaceC14603iB2, "$onCardClick");
                    AbstractC13042fc3.i(interfaceC4369Ev3, "$this$LazyVerticalGrid");
                    List listC = dVar.c();
                    if (listC != null) {
                        interfaceC4369Ev3.e(listC.size(), null, null, new p(listC), AbstractC19242q11.c(1229287273, true, new q(listC, interfaceC14603iB2)));
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 Y(C3643Bs6 c3643Bs6, InterfaceC20370rt6.a aVar, C5746Kq6 c5746Kq6, int i2) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(aVar, "$bannerSection");
                    AbstractC13042fc3.i(c5746Kq6, "serviceBannerUI");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 8, (2262 & 16) != 0 ? null : Integer.valueOf(c5746Kq6.c()), (2262 & 32) != 0 ? null : Integer.valueOf(i2 + 1), (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(aVar.c()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    C3643Bs6.Pa(c3643Bs6, c5746Kq6.a(), c5746Kq6.f(), Integer.valueOf(c5746Kq6.d()), Integer.valueOf(c5746Kq6.e()), null, null, null, null, null, 496, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 Z(float f2, float f3, C3643Bs6 c3643Bs6, InterfaceC20370rt6.a aVar, InterfaceC11379cu3 interfaceC11379cu3, int i2, int i3) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(aVar, "$bannerSection");
                    AbstractC13042fc3.i(interfaceC11379cu3, "layoutCoordinates");
                    if (interfaceC11379cu3.b()) {
                        int i4 = ((int) f2) - 150;
                        int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (AbstractC12000du3.e(interfaceC11379cu3) & 4294967295L));
                        if (iIntBitsToFloat >= 0 && iIntBitsToFloat < i4) {
                            int i5 = (int) f3;
                            int iIntBitsToFloat2 = (int) Float.intBitsToFloat((int) (AbstractC12000du3.e(interfaceC11379cu3) >> 32));
                            if (iIntBitsToFloat2 >= 0 && iIntBitsToFloat2 < i5) {
                                Object obj = c3643Bs6.Ba().C1().get(Integer.valueOf(i2));
                                Boolean bool = Boolean.TRUE;
                                if (!AbstractC13042fc3.d(obj, bool)) {
                                    c3643Bs6.Ba().C1().put(Integer.valueOf(i2), bool);
                                    c3643Bs6.Ba().V1("services_view", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 2, (2262 & 16) != 0 ? null : Integer.valueOf(i3), (2262 & 32) != 0 ? null : Integer.valueOf(i2 + 1), (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(aVar.c()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                                }
                            }
                        }
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 a0(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC11379cu3 interfaceC11379cu3, int i2, int i3) {
                    AbstractC13042fc3.i(interfaceC15796kB2, "$onBannerGloballyPositioned");
                    AbstractC13042fc3.i(interfaceC11379cu3, "layoutCoordinates");
                    interfaceC15796kB2.q(interfaceC11379cu3, Integer.valueOf(i2), Integer.valueOf(i3));
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 b0(C3643Bs6 c3643Bs6, ComposeView composeView) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(composeView, "$this_apply");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 1, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : null, (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : null, (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    c3643Bs6.Ba().x1();
                    c3643Bs6.w1(composeView.getContext(), c3643Bs6.getParent(), c3643Bs6);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c0(C3643Bs6 c3643Bs6, InterfaceC20370rt6.b bVar) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(bVar, "$botsVitrineSection");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 5, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : null, (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(bVar.c()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    C3643Bs6.Ta(c3643Bs6, c.b, null, null, 6, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d0(C3643Bs6 c3643Bs6, InterfaceC20370rt6.b bVar, int i2, C7112Qi0 c7112Qi0) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(bVar, "$botsVitrineSection");
                    AbstractC13042fc3.i(c7112Qi0, "bot");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 6, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : Integer.valueOf(i2 + 1), (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(bVar.c()), (2262 & 512) != 0 ? null : Integer.valueOf(c7112Qi0.b()), (2262 & 1024) != 0 ? null : Integer.valueOf(ExPeerType.PRIVATE.getValue()), (2262 & 2048) == 0 ? null : null);
                    c3643Bs6.Qa(c7112Qi0.b());
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 e0(C3643Bs6 c3643Bs6, InterfaceC20370rt6.b bVar, InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(bVar, "$botsVitrineSection");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$showBadgeDescriptionDialog$delegate");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 4, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : null, (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : EnumC19170pt6.e, (2262 & 256) != 0 ? null : Integer.valueOf(bVar.c()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    h.i(interfaceC9102Ym4, true);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f0(float f2, C3643Bs6 c3643Bs6, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC11379cu3 interfaceC11379cu3) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(interfaceC9664aL6, "$uiState$delegate");
                    AbstractC13042fc3.i(interfaceC11379cu3, "it");
                    if (interfaceC11379cu3.b() && h.f(interfaceC9664aL6).c() == EnumC17988nt6.c && !h.f(interfaceC9664aL6).h()) {
                        int i2 = (int) f2;
                        int iIntBitsToFloat = ((int) Float.intBitsToFloat((int) (AbstractC12000du3.e(interfaceC11379cu3) & 4294967295L))) + (c3643Bs6.appbarHeight * 2) + C22078ud6.a(200.0f);
                        if (iIntBitsToFloat >= 0 && iIntBitsToFloat < i2) {
                            c3643Bs6.Ba().h2(new UA2() { // from class: ir.nasim.Xs6
                                @Override // ir.nasim.UA2
                                public final Object invoke(Object obj) {
                                    return C3643Bs6.h.a.C0302a.g0((C4837Gt6) obj);
                                }
                            });
                            c3643Bs6.Ba().V1("services_view", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 1, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : null, (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : null, (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                            c3643Bs6.Ba().S1();
                        }
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C4837Gt6 g0(C4837Gt6 c4837Gt6) {
                    AbstractC13042fc3.i(c4837Gt6, "state");
                    return C4837Gt6.b(c4837Gt6, null, null, 0, true, false, null, 55, null);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 h0(UA2 ua2, InterfaceC11379cu3 interfaceC11379cu3) {
                    AbstractC13042fc3.i(ua2, "$onListTitleGloballyPositioned");
                    AbstractC13042fc3.i(interfaceC11379cu3, "it");
                    ua2.invoke(interfaceC11379cu3);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i0(InterfaceC20370rt6.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC4369Ev3 interfaceC4369Ev3) {
                    AbstractC13042fc3.i(bVar, "$botsVitrineSection");
                    AbstractC13042fc3.i(interfaceC14603iB2, "$onItemClick");
                    AbstractC13042fc3.i(interfaceC4369Ev3, "$this$LazyVerticalGrid");
                    List listB = bVar.b();
                    if (listB != null) {
                        interfaceC4369Ev3.e(listB.size(), new r(new InterfaceC14603iB2() { // from class: ir.nasim.Ws6
                            @Override // ir.nasim.InterfaceC14603iB2
                            public final Object invoke(Object obj, Object obj2) {
                                return C3643Bs6.h.a.C0302a.j0(((Integer) obj).intValue(), (C7112Qi0) obj2);
                            }
                        }, listB), null, new s(listB), AbstractC19242q11.c(1229287273, true, new t(listB, interfaceC14603iB2)));
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Object j0(int i2, C7112Qi0 c7112Qi0) {
                    AbstractC13042fc3.i(c7112Qi0, "item");
                    return Integer.valueOf(c7112Qi0.b());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 k0(C3643Bs6 c3643Bs6, InterfaceC20370rt6.c cVar) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(cVar, "$botsVitrineExtraSection");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 5, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : null, (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(cVar.j()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? c3643Bs6.Wa(cVar.h()) : null);
                    c3643Bs6.La(cVar.i(), Integer.valueOf(cVar.g()), cVar.h());
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 l0(C3643Bs6 c3643Bs6) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    c3643Bs6.Ba().U1(2);
                    c3643Bs6.Ba().v1();
                    c3643Bs6.Na(c3643Bs6.Ba().K1());
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 m0(C3643Bs6 c3643Bs6, InterfaceC20370rt6.c cVar) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(cVar, "$botsVitrineExtraSection");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 4, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : null, (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : cVar.d(), (2262 & 256) != 0 ? null : Integer.valueOf(cVar.j()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 n0(InterfaceC20370rt6.c cVar, C3643Bs6 c3643Bs6, InterfaceC4369Ev3 interfaceC4369Ev3) {
                    AbstractC13042fc3.i(cVar, "$botsVitrineExtraSection");
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(interfaceC4369Ev3, "$this$LazyVerticalGrid");
                    List listE = cVar.e();
                    if (listE != null) {
                        interfaceC4369Ev3.e(listE.size(), new u(new InterfaceC14603iB2() { // from class: ir.nasim.Zs6
                            @Override // ir.nasim.InterfaceC14603iB2
                            public final Object invoke(Object obj, Object obj2) {
                                return C3643Bs6.h.a.C0302a.o0(((Integer) obj).intValue(), (C7112Qi0) obj2);
                            }
                        }, listE), null, new v(listE), AbstractC19242q11.c(1229287273, true, new w(listE, c3643Bs6, cVar)));
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Object o0(int i2, C7112Qi0 c7112Qi0) {
                    AbstractC13042fc3.i(c7112Qi0, "item");
                    return Integer.valueOf(c7112Qi0.b());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 p0(C3643Bs6 c3643Bs6, InterfaceC20370rt6.e eVar) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(eVar, "$serviceItemsExtraSection");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 5, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : null, (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(eVar.h()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    C3643Bs6.Ma(c3643Bs6, eVar.g(), Integer.valueOf(eVar.f()), null, 4, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 q0(C3643Bs6 c3643Bs6, C6472Nr6 c6472Nr6, int i2) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(c6472Nr6, "item");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : c6472Nr6.n(), (2262 & 8) != 0 ? null : 3, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : Integer.valueOf(i2 + 1), (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : null, (2262 & 256) != 0 ? null : Integer.valueOf(c6472Nr6.l()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    c3643Bs6.Oa(c6472Nr6.a(), c6472Nr6.o(), c6472Nr6.j(), c6472Nr6.k(), c6472Nr6.n(), c6472Nr6.e(), c6472Nr6.b(), Integer.valueOf(c6472Nr6.h()), c6472Nr6.i());
                    String strB = c6472Nr6.b();
                    if (strB != null && strB.length() != 0) {
                        c3643Bs6.Ba().q1(c6472Nr6.h());
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 r0(C3643Bs6 c3643Bs6, InterfaceC20370rt6.e eVar) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    AbstractC13042fc3.i(eVar, "$serviceItemsExtraSection");
                    c3643Bs6.Ba().V1("services_click_action", (2262 & 2) != 0 ? null : null, (2262 & 4) != 0 ? null : null, (2262 & 8) != 0 ? null : 4, (2262 & 16) != 0 ? null : null, (2262 & 32) != 0 ? null : null, (2262 & 64) != 0 ? null : null, (2262 & 128) != 0 ? null : eVar.d(), (2262 & 256) != 0 ? null : Integer.valueOf(eVar.h()), (2262 & 512) != 0 ? null : null, (2262 & 1024) != 0 ? null : null, (2262 & 2048) == 0 ? null : null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 s0(InterfaceC20370rt6.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC4369Ev3 interfaceC4369Ev3) {
                    AbstractC13042fc3.i(eVar, "$serviceItemsExtraSection");
                    AbstractC13042fc3.i(interfaceC14603iB2, "$onCardClick");
                    AbstractC13042fc3.i(interfaceC4369Ev3, "$this$LazyVerticalGrid");
                    List listI = eVar.i();
                    if (listI != null) {
                        interfaceC4369Ev3.e(listI.size(), null, null, new x(listI), AbstractC19242q11.c(1229287273, true, new y(listI, interfaceC14603iB2)));
                    }
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 t0(C3643Bs6 c3643Bs6) {
                    AbstractC13042fc3.i(c3643Bs6, "this$0");
                    c3643Bs6.Ba().x1();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 u0() {
                    return C19938rB7.a;
                }

                /*  JADX ERROR: Type inference failed
                    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
                    */
                public final void O(ir.nasim.InterfaceC22053ub1 r51, int r52) {
                    /*
                        Method dump skipped, instructions count: 2965
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3643Bs6.h.a.C0302a.O(ir.nasim.ub1, int):void");
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    O((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(InterfaceC9664aL6 interfaceC9664aL6, C3643Bs6 c3643Bs6, ComposeView composeView, float f, float f2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = interfaceC9664aL6;
                this.b = c3643Bs6;
                this.c = composeView;
                this.d = f;
                this.e = f2;
                this.f = interfaceC9102Ym4;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(1249919919, true, new C0302a(this.a, this.b, this.c, this.d, this.e, this.f), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        h(ComposeView composeView) {
            this.b = composeView;
        }

        public static final /* synthetic */ C4837Gt6 a(InterfaceC9664aL6 interfaceC9664aL6) {
            return f(interfaceC9664aL6);
        }

        public static final /* synthetic */ boolean b(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return h(interfaceC9102Ym4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C4837Gt6 f(InterfaceC9664aL6 interfaceC9664aL6) {
            return (C4837Gt6) interfaceC9664aL6.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean h(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            interfaceC9102Ym4.setValue(Boolean.valueOf(z));
        }

        public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(C3643Bs6.this.Ba().O1(), null, null, null, interfaceC22053ub1, 0, 7);
            interfaceC22053ub1.W(1483250509);
            float fW1 = ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).w1(C17784nZ1.q(((Configuration) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f())).screenHeightDp));
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1483255244);
            float fW12 = ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).w1(C17784nZ1.q(((Configuration) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f())).screenWidthDp));
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1483259489);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            M10.f(false, AbstractC19242q11.e(354610927, true, new a(interfaceC9664aL6C, C3643Bs6.this, this.b, fW1, fW12, (InterfaceC9102Ym4) objB), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Bs6$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3643Bs6.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(2500L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            if (C3643Bs6.this.servicesWebViewFragment == null) {
                C3643Bs6 c3643Bs6 = C3643Bs6.this;
                c3643Bs6.servicesWebViewFragment = ir.nasim.features.bank.mybank.webview.a.r1.a(c3643Bs6.Ba().B1(), false);
            }
            if (C3643Bs6.this.botsWebViewFragment == null) {
                C3643Bs6 c3643Bs62 = C3643Bs6.this;
                c3643Bs62.botsWebViewFragment = ir.nasim.features.bank.mybank.webview.a.r1.a(c3643Bs62.Ba().A1(), false);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs6$j */
    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Bs6$k */
    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Bs6$l */
    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Bs6$m */
    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.Bs6$n */
    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C3643Bs6() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new k(new j(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C6490Nt6.class), new l(interfaceC9173Yu3B), new m(null, interfaceC9173Yu3B), new n(this, interfaceC9173Yu3B));
        this.snackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.vs6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3643Bs6.Xa(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17468n10 Aa() {
        return (C17468n10) this.snackBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6490Nt6 Ba() {
        return (C6490Nt6) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ca() {
        Ba().U1(3);
        Ba().Z1(new SA2() { // from class: ir.nasim.xs6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3643Bs6.Da(this.a);
            }
        }, new UA2() { // from class: ir.nasim.ys6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C3643Bs6.Ea(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.zs6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C3643Bs6.Fa(this.a, (UA2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Da(C3643Bs6 c3643Bs6) {
        AbstractC13042fc3.i(c3643Bs6, "this$0");
        C22042ua0.w9(c3643Bs6, InterfaceC23146wR.a(c3643Bs6.ua(), "AuthenticationResult_Key", new TR.c(c3643Bs6.Ba().J1()), true, false, null, 24, null), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ea(C3643Bs6 c3643Bs6, boolean z) {
        AbstractC13042fc3.i(c3643Bs6, "this$0");
        c3643Bs6.Ba().U1(z ? 4 : 5);
        C22042ua0.w9(c3643Bs6, InterfaceC23146wR.c(c3643Bs6.ua(), "AuthenticationResult_Key", new TR.c(c3643Bs6.Ba().J1()), false, z, null, 20, null), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Fa(C3643Bs6 c3643Bs6, final UA2 ua2) {
        AbstractC13042fc3.i(c3643Bs6, "this$0");
        AbstractC13042fc3.i(ua2, "doOnResult");
        c3643Bs6.Q7().B0().H1("AuthenticationResult_Key", c3643Bs6.p6(), new InterfaceC13295fz2() { // from class: ir.nasim.As6
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                C3643Bs6.Ga(ua2, str, bundle);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ga(UA2 ua2, String str, Bundle bundle) {
        AbstractC13042fc3.i(ua2, "$doOnResult");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "result");
        ua2.invoke(Boolean.valueOf(bundle.getBoolean("AuthenticationResult_Key", false)));
    }

    private final void Ha() {
        C5346Iy2 c5346Iy2 = this.binding;
        C5346Iy2 c5346Iy22 = null;
        if (c5346Iy2 == null) {
            AbstractC13042fc3.y("binding");
            c5346Iy2 = null;
        }
        c5346Iy2.f.setColorFilter(VM3.a.a().c().b());
        C5346Iy2 c5346Iy23 = this.binding;
        if (c5346Iy23 == null) {
            AbstractC13042fc3.y("binding");
            c5346Iy23 = null;
        }
        DrawerToolbar drawerToolbar = c5346Iy23.d;
        AbstractC13042fc3.h(drawerToolbar, "bankToolbar");
        drawerToolbar.setNavigationDrawerFragment(Ba().u1());
        drawerToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ts6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C3643Bs6.Ia(this.a, view);
            }
        });
        C5346Iy2 c5346Iy24 = this.binding;
        if (c5346Iy24 == null) {
            AbstractC13042fc3.y("binding");
            c5346Iy24 = null;
        }
        c5346Iy24.g.setTextColor(C5495Jo7.a.i());
        C5346Iy2 c5346Iy25 = this.binding;
        if (c5346Iy25 == null) {
            AbstractC13042fc3.y("binding");
            c5346Iy25 = null;
        }
        c5346Iy25.g.setTypeface(C6011Lu2.i());
        C5346Iy2 c5346Iy26 = this.binding;
        if (c5346Iy26 == null) {
            AbstractC13042fc3.y("binding");
            c5346Iy26 = null;
        }
        c5346Iy26.g.setPadding(0, 0, 0, 0);
        C5346Iy2 c5346Iy27 = this.binding;
        if (c5346Iy27 == null) {
            AbstractC13042fc3.y("binding");
            c5346Iy27 = null;
        }
        c5346Iy27.g.setTextSize((C5161Id6.k() || b6().getConfiguration().orientation != 2) ? 19.0f : 14.0f);
        C5346Iy2 c5346Iy28 = this.binding;
        if (c5346Iy28 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c5346Iy22 = c5346Iy28;
        }
        c5346Iy22.g.measure(View.MeasureSpec.makeMeasureSpec(C22078ud6.a(200.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(C22078ud6.a(24.0f), RecyclerView.UNDEFINED_DURATION));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(C3643Bs6 c3643Bs6, View view) {
        AbstractC13042fc3.i(c3643Bs6, "this$0");
        c3643Bs6.x9(c3643Bs6.va().d());
    }

    private final boolean Ja(Integer peerId, Integer peerType) {
        return (peerId == null || peerType == null || peerType.intValue() != 1) ? false : true;
    }

    private final boolean Ka(Integer peerId, Integer peerType) {
        return (peerId == null || peerType == null || peerType.intValue() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void La(EnumC18579ot6 navigationType, Integer navigationCategoryID, String navigationDestinationUrl) {
        String str;
        if (navigationDestinationUrl != null && !AbstractC20762sZ6.n0(navigationDestinationUrl)) {
            C22042ua0.A9(this, ir.nasim.features.bank.mybank.webview.a.r1.a(navigationDestinationUrl, false), false, null, 6, null);
            return;
        }
        int i2 = d.b[navigationType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                Ta(this, c.b, null, null, 6, null);
                return;
            }
            c cVar = c.a;
            if (navigationCategoryID != null) {
                str = "&category=" + navigationCategoryID;
            } else {
                str = null;
            }
            Sa(cVar, str, navigationCategoryID);
        }
    }

    static /* synthetic */ void Ma(C3643Bs6 c3643Bs6, EnumC18579ot6 enumC18579ot6, Integer num, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        c3643Bs6.La(enumC18579ot6, num, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Na(String urlString) {
        if (AbstractC20762sZ6.n0(urlString)) {
            InterfaceC11677dQ0 interfaceC11677dQ0Xa = xa();
            C11458d25 c11458d25R = C11458d25.r(Ba().I1());
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            C22042ua0.A9(this, InterfaceC11677dQ0.b(interfaceC11677dQ0Xa, c11458d25R, ExPeerType.BOT, null, null, false, null, null, null, null, 0L, null, null, "gold", false, null, null, null, null, null, false, null, null, null, null, null, false, null, 134213628, null), false, null, 6, null);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(urlString));
        C18987pb3 c18987pb3 = C18987pb3.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c18987pb3.k0(intent, fragmentActivityQ7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oa(int action, String url, Integer peerId, Integer peerType, String title, String eventKey, String badge, Integer serviceId, List menuItems) {
        try {
            EnumC8439Vz enumC8439VzJ = EnumC8439Vz.j(action);
            switch (enumC8439VzJ == null ? -1 : d.a[enumC8439VzJ.ordinal()]) {
                case 1:
                    if (url != null) {
                        w4(url);
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (!Ja(peerId, peerType)) {
                        if (Ka(peerId, peerType)) {
                            Context contextS7 = S7();
                            AbstractC13042fc3.h(contextS7, "requireContext(...)");
                            Ra(peerId, contextS7);
                            break;
                        }
                    } else if (peerId != null) {
                        Qa(peerId.intValue());
                        break;
                    }
                    break;
                case 4:
                    e4(this.parent);
                    break;
                case 5:
                    k0(S7());
                    break;
                case 6:
                    m4();
                    break;
                case 7:
                    P1(S7(), this.parent);
                    break;
                case 8:
                    C18987pb3.a.K1(EnumC17964nr2.b);
                    break;
                case 9:
                    C18987pb3.a.K1(EnumC17964nr2.c);
                    break;
                case 10:
                    C18987pb3.a.K1(EnumC17964nr2.a);
                    break;
                case 11:
                    if (url != null) {
                        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                        Context contextS72 = S7();
                        AbstractC13042fc3.h(contextS72, "requireContext(...)");
                        Uri uri = Uri.parse(url);
                        AbstractC13042fc3.h(uri, "parse(...)");
                        aVar.A(contextS72, uri);
                        break;
                    }
                    break;
                case 12:
                    BaseActivity baseActivity = this.parent;
                    if (baseActivity != null && title != null) {
                        d2(baseActivity, new C22186uo4(title, null, eventKey, serviceId, null, Integer.valueOf(action), false, false, badge, false, null, null, null, new MyBankData.Payload(null, null, null, null, false, (ArrayList) menuItems, 16, null), null, 24274, null));
                        break;
                    }
                    break;
            }
        } catch (IOException e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    static /* synthetic */ void Pa(C3643Bs6 c3643Bs6, int i2, String str, Integer num, Integer num2, String str2, String str3, String str4, Integer num3, List list, int i3, Object obj) {
        c3643Bs6.Oa(i2, str, num, num2, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? null : num3, (i3 & 256) != 0 ? null : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qa(long peerId) {
        s4(C11458d25.r(peerId));
    }

    private final void Ra(Integer peerId, Context context) {
        if (peerId != null) {
            g0(peerId.intValue(), context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa(c servicesWebViewType, String urlParameter, Integer focusedSectionID) {
        ir.nasim.features.bank.mybank.webview.a aVarWa;
        StringBuilder sb = new StringBuilder();
        c cVar = c.a;
        C6490Nt6 c6490Nt6Ba = Ba();
        sb.append(servicesWebViewType == cVar ? c6490Nt6Ba.B1() : c6490Nt6Ba.A1());
        if (urlParameter != null) {
            sb.append(urlParameter);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        if (!C8386Vt0.na()) {
            C22042ua0.A9(this, ir.nasim.features.bank.mybank.webview.a.r1.a(string, false), false, null, 6, null);
            return;
        }
        if (servicesWebViewType == cVar) {
            ir.nasim.features.bank.mybank.webview.a aVarZa = za(string);
            if (aVarZa != null) {
                aVarZa.za(focusedSectionID);
                C22042ua0.A9(this, aVarZa, false, null, 6, null);
                return;
            }
            return;
        }
        if (servicesWebViewType != c.b || (aVarWa = wa()) == null) {
            return;
        }
        aVarWa.za(focusedSectionID);
        C22042ua0.A9(this, aVarWa, false, null, 6, null);
    }

    static /* synthetic */ void Ta(C3643Bs6 c3643Bs6, c cVar, String str, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        c3643Bs6.Sa(cVar, str, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ua(C3643Bs6 c3643Bs6, String str) {
        AbstractC13042fc3.i(c3643Bs6, "this$0");
        AbstractC13042fc3.i(str, "$url");
        c3643Bs6.f0(c3643Bs6.Q7(), c3643Bs6.parent, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Va() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new i(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Wa(String urlString) {
        try {
            C9475a16.a aVar = C9475a16.b;
            URL url = new URL(urlString);
            StringBuilder sb = new StringBuilder();
            String path = url.getPath();
            AbstractC13042fc3.h(path, "getPath(...)");
            sb.append(AbstractC20762sZ6.C0(path, Separators.SLASH));
            String query = url.getQuery();
            if (query != null && query.length() != 0) {
                sb.append(Separators.QUESTION + url.getQuery());
            }
            String string = sb.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            return string;
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            Object objB = C9475a16.b(AbstractC10685c16.a(th));
            if (C9475a16.g(objB)) {
                objB = null;
            }
            Object obj = (Void) objB;
            return obj != null ? (String) obj : "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 Xa(C3643Bs6 c3643Bs6) {
        AbstractC13042fc3.i(c3643Bs6, "this$0");
        C5346Iy2 c5346Iy2 = c3643Bs6.binding;
        C5346Iy2 c5346Iy22 = null;
        if (c5346Iy2 == null) {
            AbstractC13042fc3.y("binding");
            c5346Iy2 = null;
        }
        ConstraintLayout root = c5346Iy2.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.m(3000);
        C5346Iy2 c5346Iy23 = c3643Bs6.binding;
        if (c5346Iy23 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c5346Iy22 = c5346Iy23;
        }
        c17468n10.k(c5346Iy22.b);
        return c17468n10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(final InterfaceC20370rt6.g gVar, final C19206px3 c19206px3, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1700055724);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(gVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(c19206px3) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else if (gVar.e().c() != null) {
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1J.W(-868125850);
            boolean zD = ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new b(c19206px3, null);
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ws6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C3643Bs6.ba(this.a, gVar, c19206px3, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ba(C3643Bs6 c3643Bs6, InterfaceC20370rt6.g gVar, C19206px3 c19206px3, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c3643Bs6, "$tmp1_rcvr");
        AbstractC13042fc3.i(gVar, "$walletSection");
        AbstractC13042fc3.i(c19206px3, "$listState");
        c3643Bs6.aa(gVar, c19206px3, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final /* synthetic */ void ca(C3643Bs6 c3643Bs6, InterfaceC20370rt6.g gVar, C19206px3 c19206px3, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        c3643Bs6.aa(gVar, c19206px3, interfaceC22053ub1, i2);
    }

    private final ir.nasim.features.bank.mybank.webview.a wa() {
        if (this.botsWebViewFragment == null) {
            this.botsWebViewFragment = ir.nasim.features.bank.mybank.webview.a.r1.a(Ba().A1(), false);
        }
        return this.botsWebViewFragment;
    }

    private final ir.nasim.features.bank.mybank.webview.a za(String url) {
        if (this.servicesWebViewFragment == null) {
            this.servicesWebViewFragment = ir.nasim.features.bank.mybank.webview.a.r1.a(url, false);
        }
        return this.servicesWebViewFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this.parent = (BaseActivity) A5();
        C5346Iy2 c5346Iy2C = C5346Iy2.c(inflater, container, false);
        this.binding = c5346Iy2C;
        if (c5346Iy2C == null) {
            AbstractC13042fc3.y("binding");
            c5346Iy2C = null;
        }
        ConstraintLayout root = c5346Iy2C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this.servicesWebViewFragment = null;
        this.botsWebViewFragment = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void W6(boolean hidden) {
        super.W6(hidden);
        if (hidden) {
            return;
        }
        Ba().y1();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        this.parent = (BaseActivity) A5();
        Ba().c2();
        Ba().x1();
        Ba().v1();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        C5346Iy2 c5346Iy2 = this.binding;
        C5346Iy2 c5346Iy22 = null;
        if (c5346Iy2 == null) {
            AbstractC13042fc3.y("binding");
            c5346Iy2 = null;
        }
        ComposeView composeView = c5346Iy2.e;
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-1658403724, true, new h(composeView)));
        Ha();
        if (C8386Vt0.na()) {
            C5346Iy2 c5346Iy23 = this.binding;
            if (c5346Iy23 == null) {
                AbstractC13042fc3.y("binding");
                c5346Iy23 = null;
            }
            ConstraintLayout root = c5346Iy23.getRoot();
            AbstractC13042fc3.h(root, "getRoot(...)");
            OK4.a(root, new g(root, this));
        }
        C5346Iy2 c5346Iy24 = this.binding;
        if (c5346Iy24 == null) {
            AbstractC13042fc3.y("binding");
            c5346Iy24 = null;
        }
        ComposeView composeView2 = c5346Iy24.e;
        AbstractC13042fc3.h(composeView2, "composeView");
        if (!composeView2.isLaidOut() || composeView2.isLayoutRequested()) {
            composeView2.addOnLayoutChangeListener(new e());
        } else {
            this.composeViewHeight = composeView2.getHeight();
        }
        C5346Iy2 c5346Iy25 = this.binding;
        if (c5346Iy25 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c5346Iy22 = c5346Iy25;
        }
        DrawerToolbar drawerToolbar = c5346Iy22.d;
        AbstractC13042fc3.h(drawerToolbar, "bankToolbar");
        if (!drawerToolbar.isLaidOut() || drawerToolbar.isLayoutRequested()) {
            drawerToolbar.addOnLayoutChangeListener(new f());
        } else {
            this.appbarHeight = drawerToolbar.getHeight();
        }
        Ba().U1(1);
    }

    @Override // ir.nasim.InterfaceC17936no4
    public void n2(String url) {
        EnumC8439Vz enumC8439VzJ;
        AbstractC13042fc3.i(url, "url");
        String str = null;
        if (!AbstractC20153rZ6.S(url, "http", false, 2, null)) {
            str = "https://" + url;
        }
        if (str == null) {
            str = url;
        }
        Uri uri = Uri.parse(str);
        String queryParameter = uri.getQueryParameter("type");
        if (queryParameter == null || (enumC8439VzJ = EnumC8439Vz.j(Integer.parseInt(queryParameter))) == null) {
            return;
        }
        try {
            switch (d.a[enumC8439VzJ.ordinal()]) {
                case 1:
                    String queryParameter2 = uri.getQueryParameter("url");
                    if (queryParameter2 != null) {
                        w4(queryParameter2);
                    } else {
                        C19406qI3.d("NON_FATAL_EXCEPTION", new Exception(url));
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    return;
                case 2:
                case 3:
                    String queryParameter3 = uri.getQueryParameter("payloadType");
                    String queryParameter4 = uri.getQueryParameter("uid");
                    String queryParameter5 = uri.getQueryParameter("messageId");
                    String queryParameter6 = uri.getQueryParameter("messageDate");
                    if (queryParameter3 != null && Integer.parseInt(queryParameter3) == 1 && queryParameter4 != null) {
                        s4(C11458d25.r(Long.parseLong(queryParameter4)));
                    } else if (queryParameter3 != null && Integer.parseInt(queryParameter3) == 2 && queryParameter4 != null && queryParameter5 != null && queryParameter6 != null) {
                        o5(C11458d25.r(Long.parseLong(queryParameter4)), Long.valueOf(Long.parseLong(queryParameter5)), Long.valueOf(Long.parseLong(queryParameter6)));
                    } else if (queryParameter3 == null || Integer.parseInt(queryParameter3) != 2 || queryParameter4 == null) {
                        C19406qI3.d("NON_FATAL_EXCEPTION", new Exception(url));
                    } else {
                        g0(Long.parseLong(queryParameter4), S7());
                    }
                    C19938rB7 c19938rB72 = C19938rB7.a;
                    return;
                case 4:
                    e4(this.parent);
                    C19938rB7 c19938rB73 = C19938rB7.a;
                    return;
                case 5:
                    f2(S7(), this.parent);
                    C19938rB7 c19938rB74 = C19938rB7.a;
                    return;
                case 6:
                    m4();
                    C19938rB7 c19938rB75 = C19938rB7.a;
                    return;
                case 7:
                    P1(S7(), this.parent);
                    C19938rB7 c19938rB76 = C19938rB7.a;
                    return;
                case 8:
                    C18987pb3.a.K1(EnumC17964nr2.b);
                    C19938rB7 c19938rB77 = C19938rB7.a;
                    return;
                case 9:
                    C18987pb3.a.K1(EnumC17964nr2.c);
                    C19938rB7 c19938rB78 = C19938rB7.a;
                    return;
                case 10:
                    C18987pb3.a.K1(EnumC17964nr2.a);
                    C19938rB7 c19938rB79 = C19938rB7.a;
                    return;
                case 11:
                    String queryParameter7 = uri.getQueryParameter("url");
                    String queryParameter8 = uri.getQueryParameter("url");
                    if (queryParameter7 != null) {
                        if (queryParameter8 != null) {
                            Y(S7(), Uri.parse(queryParameter7), Boolean.valueOf(Boolean.parseBoolean(queryParameter8)));
                            break;
                        } else {
                            Y(S7(), Uri.parse(queryParameter7), Boolean.FALSE);
                            break;
                        }
                    } else {
                        return;
                    }
            }
            C19938rB7 c19938rB710 = C19938rB7.a;
        } catch (IOException e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            C19938rB7 c19938rB711 = C19938rB7.a;
        }
    }

    public final InterfaceC23146wR ua() {
        InterfaceC23146wR interfaceC23146wR = this.authenticatorNavigator;
        if (interfaceC23146wR != null) {
            return interfaceC23146wR;
        }
        AbstractC13042fc3.y("authenticatorNavigator");
        return null;
    }

    public final InterfaceC23238wb0 va() {
        InterfaceC23238wb0 interfaceC23238wb0 = this.baseSettingsNavigator;
        if (interfaceC23238wb0 != null) {
            return interfaceC23238wb0;
        }
        AbstractC13042fc3.y("baseSettingsNavigator");
        return null;
    }

    @Override // ir.nasim.designsystem.WalletMoreOptionsBottomsheetContentView.a
    public void w4(final String url) {
        AbstractC13042fc3.i(url, "url");
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.us6
            @Override // java.lang.Runnable
            public final void run() {
                C3643Bs6.Ua(this.a, url);
            }
        }, 100L);
    }

    @Override // ir.nasim.InterfaceC17936no4
    public void x1() {
        Ba().x1();
        Ba().v1();
    }

    public final InterfaceC11677dQ0 xa() {
        InterfaceC11677dQ0 interfaceC11677dQ0 = this.chatNavigator;
        if (interfaceC11677dQ0 != null) {
            return interfaceC11677dQ0;
        }
        AbstractC13042fc3.y("chatNavigator");
        return null;
    }

    /* renamed from: ya, reason: from getter */
    public final BaseActivity getParent() {
        return this.parent;
    }

    @Override // ir.nasim.InterfaceC17936no4
    public Fragment J0() {
        return this;
    }

    @Override // ir.nasim.InterfaceC17936no4
    public void F2(int paddingValueInDp) {
    }
}
