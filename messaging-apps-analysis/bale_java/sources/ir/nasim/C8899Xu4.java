package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC3769Cg6;
import ir.nasim.C24254yJ;
import ir.nasim.C6399Nk7;
import ir.nasim.C8899Xu4;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.core.model.webapp.WebAppArguments;
import ir.nasim.core.model.webapp.WebAppType;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.mxp.entity.PuppetGroup;
import ir.nasim.features.mxp.entity.PuppetUser;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u0000 {2\u00020\u0001:\u0001|B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\n\u0010\u000bJW\u0010\u0017\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018JW\u0010\u0019\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u0018Je\u0010\u001c\u001a\u00020\u0004*\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0018\u00010\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u0004H\u0003¢\u0006\u0004\b#\u0010\u000bJ\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b*\u0010)J\u0019\u0010+\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b+\u0010)J!\u0010.\u001a\u00020\u0004*\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u001aH\u0003¢\u0006\u0004\b1\u00102J!\u00104\u001a\u00020\u0004*\u00020,2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0002¢\u0006\u0004\b4\u0010/J\u0013\u00105\u001a\u00020\u0004*\u00020,H\u0002¢\u0006\u0004\b5\u00106JO\u0010?\u001a\u00020\u00042\b\b\u0001\u00108\u001a\u0002072\b\b\u0001\u00109\u001a\u0002072\b\b\u0001\u0010:\u001a\u0002072\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0;\"\u00020\u001a2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040=H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0004H\u0002¢\u0006\u0004\bA\u0010\u0003J\u001b\u0010C\u001a\u00020\u0004*\u00020,2\u0006\u0010B\u001a\u000207H\u0002¢\u0006\u0004\bC\u0010DJ+\u0010L\u001a\u00020K2\u0006\u0010F\u001a\u00020E2\b\u0010H\u001a\u0004\u0018\u00010G2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bL\u0010MJ!\u0010O\u001a\u00020\u00042\u0006\u0010N\u001a\u00020K2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0004H\u0016¢\u0006\u0004\bQ\u0010\u0003J\u000f\u0010R\u001a\u00020\u0004H\u0016¢\u0006\u0004\bR\u0010\u0003J\u000f\u0010S\u001a\u00020\u0004H\u0016¢\u0006\u0004\bS\u0010\u0003J\u000f\u0010T\u001a\u00020\u0004H\u0016¢\u0006\u0004\bT\u0010\u0003J5\u0010W\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u001a2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040=H\u0007¢\u0006\u0004\bW\u0010XJ\u0015\u0010Z\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\r¢\u0006\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001b\u0010g\u001a\u00020b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\"\u0010o\u001a\u00020h8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010w\u001a\u00020p8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0016\u0010z\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010y¨\u0006\u0085\u0001²\u0006\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\nX\u008a\u0084\u0002²\u0006\u0012\u0010~\u001a\b\u0012\u0004\u0012\u00020}0\u00108\nX\u008a\u0084\u0002²\u0006\u0012\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\nX\u008a\u0084\u0002²\u0006\u0012\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\nX\u008a\u0084\u0002²\u0006 \u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0018\u00010\u00138\nX\u008a\u0084\u0002²\u0006\u0014\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u007f\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002²\u0006\u000f\u0010\u0080\u0001\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002²\u0006\u000f\u0010\u0081\u0001\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002²\u0006\u000f\u0010\u0082\u0001\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0084\u0001\u001a\u00030\u0083\u00018\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/Xu4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "Cb", "", "durationTime", "Rb", "(J)V", "ta", "(Lir/nasim/ub1;I)V", "Lir/nasim/sx3;", "Lir/nasim/Cg6;", "localSearch", "messageSearch", "", "Lir/nasim/Cg6$j;", "searchMxp", "", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "remotePeerSearch", "", "Fb", "(Lir/nasim/sx3;Lir/nasim/sx3;Ljava/util/List;Ljava/util/Map;)Z", "Gb", "", "query", "Da", "(Lir/nasim/Xu4;Lir/nasim/sx3;Ljava/lang/String;Ljava/util/Map;Lir/nasim/sx3;Ljava/util/List;Lir/nasim/ub1;I)V", "Lir/nasim/d25;", "peer", "Kb", "(Lir/nasim/d25;)V", "Nb", "pa", "Lir/nasim/features/mxp/entity/PuppetGroup;", "puppetGroup", "Lb", "(Lir/nasim/features/mxp/entity/PuppetGroup;)V", "Hb", "(Lir/nasim/sx3;)Z", "Ib", "Eb", "Lir/nasim/ix3;", "recommendedGroup", "Qb", "(Lir/nasim/ix3;Ljava/util/List;)V", ParameterNames.TEXT, "ra", "(Ljava/lang/String;Lir/nasim/ub1;I)V", "recentSearch", "Ob", "Ub", "(Lir/nasim/ix3;)V", "", "titleResourceId", "descriptionResourceId", "yesResId", "", "formatArgs", "Lkotlin/Function0;", "onInfoClickListener", "Tb", "(III[Ljava/lang/String;Lir/nasim/SA2;)V", "Db", "count", "Sb", "(Lir/nasim/ix3;I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "S0", "c7", "a1", "isExpanded", "onToggle", "Za", "(Ljava/lang/String;Ljava/lang/Boolean;Lir/nasim/SA2;Lir/nasim/ub1;II)V", "searchEntity", "xb", "(Lir/nasim/Cg6;)Z", "Lir/nasim/Ny2;", "h1", "Lir/nasim/bW7;", "yb", "()Lir/nasim/Ny2;", "binding", "Lir/nasim/aw4;", "i1", "Lir/nasim/Yu3;", "Ab", "()Lir/nasim/aw4;", "viewModel", "Lir/nasim/m68;", "j1", "Lir/nasim/m68;", "Bb", "()Lir/nasim/m68;", "setWebAppNavigator", "(Lir/nasim/m68;)V", "webAppNavigator", "Lir/nasim/dQ0;", "k1", "Lir/nasim/dQ0;", "zb", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "l1", "J", "startTime", "m1", "a", "Lir/nasim/Es7;", "topPeers", "isGlobalPrivatesExpanded", "isGlobalGroupsExpanded", "isGlobalChannelsExpanded", "isGlobalBotsExpanded", "", "rotationAngle", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Xu4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C8899Xu4 extends AbstractC14203hX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new N(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: j1, reason: from kotlin metadata */
    public InterfaceC16935m68 webAppNavigator;

    /* renamed from: k1, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: l1, reason: from kotlin metadata */
    private long startTime;
    static final /* synthetic */ InterfaceC5239Im3[] n1 = {AbstractC10882cM5.i(new C25226zw5(C8899Xu4.class, "binding", "getBinding()Lir/nasim/databinding/FragmentNewSearchBinding;", 0))};

    /* renamed from: m1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int o1 = 8;

    /* renamed from: ir.nasim.Xu4$A */
    static final class A implements InterfaceC16978mB2 {
        final /* synthetic */ C20996sx3 a;
        final /* synthetic */ C8899Xu4 b;
        final /* synthetic */ String c;

        A(C20996sx3 c20996sx3, C8899Xu4 c8899Xu4, String str) {
            this.a = c20996sx3;
            this.b = c8899Xu4;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(C8899Xu4 c8899Xu4, AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            c8899Xu4.Ab().w1(abstractC3769Cg6);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C8899Xu4 c8899Xu4, C11458d25 c11458d25) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(c11458d25, "peer");
            c8899Xu4.Kb(c11458d25);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(C8899Xu4 c8899Xu4, C11458d25 c11458d25) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(c11458d25, "peer");
            c8899Xu4.Cb();
            c8899Xu4.Nb(c11458d25);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(C8899Xu4 c8899Xu4, String str, int i, AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            C10020aw4 c10020aw4Ab = c8899Xu4.Ab();
            XV4 xv4A = AbstractC4616Fw7.a("action_type", 2);
            XV4 xv4A2 = AbstractC4616Fw7.a("peer_type", Integer.valueOf(abstractC3769Cg6.d().s().ordinal() + 1));
            XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(abstractC3769Cg6.d().getPeerId()));
            String str2 = "";
            XV4 xv4A4 = AbstractC4616Fw7.a("query_text", str == null ? "" : str);
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.c) {
                str2 = "user";
            } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.g) {
                str2 = "group";
            } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.b) {
                str2 = "channel";
            } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.a) {
                str2 = "bot";
            }
            c10020aw4Ab.m2("chat_search", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, AbstractC4616Fw7.a("event_type", str2), AbstractC4616Fw7.a("index", Integer.valueOf(i))));
            c8899Xu4.Cb();
            c8899Xu4.Ab().v1(abstractC3769Cg6.d());
            if (((Boolean) c8899Xu4.Ab().T1().getValue()).booleanValue() && c8899Xu4.xb(abstractC3769Cg6)) {
                c8899Xu4.Ab().s2(abstractC3769Cg6);
                return C19938rB7.a;
            }
            if (abstractC3769Cg6.d().C()) {
                C18987pb3.x1(C18987pb3.a, abstractC3769Cg6.d(), null, null, false, null, null, false, null, null, false, null, 2046, null);
            } else {
                C18987pb3.a.y1(abstractC3769Cg6.d(), null, null, false, "search");
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            f((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }

        public final void f(InterfaceC6988Pv3 interfaceC6988Pv3, final int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            int i4 = i3;
            if ((i4 & 147) == 146 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.f(i);
            if (abstractC3769Cg6 == null) {
                return;
            }
            final C8899Xu4 c8899Xu4 = this.b;
            final String str = this.c;
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.d) {
                return;
            }
            interfaceC22053ub1.W(-841713910);
            if (!(abstractC3769Cg6 instanceof AbstractC3769Cg6.h)) {
                androidx.compose.ui.e eVarD = InterfaceC6988Pv3.d(interfaceC6988Pv3, androidx.compose.ui.e.a, null, null, null, 2, null);
                boolean zBooleanValue = ((Boolean) c8899Xu4.Ab().T1().getValue()).booleanValue();
                boolean zContains = c8899Xu4.Ab().K1().contains(abstractC3769Cg6);
                interfaceC22053ub1.W(1922240397);
                boolean zD = interfaceC22053ub1.D(c8899Xu4);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.pv4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.A.h(c8899Xu4, (AbstractC3769Cg6) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1922227890);
                boolean zD2 = interfaceC22053ub1.D(c8899Xu4);
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.qv4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.A.i(c8899Xu4, (C11458d25) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1922233563);
                boolean zD3 = interfaceC22053ub1.D(c8899Xu4);
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.rv4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.A.k(c8899Xu4, (C11458d25) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                UA2 ua23 = (UA2) objB3;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1922254678);
                boolean zD4 = interfaceC22053ub1.D(c8899Xu4) | interfaceC22053ub1.V(str) | ((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
                Object objB4 = interfaceC22053ub1.B();
                if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new UA2() { // from class: ir.nasim.sv4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.A.n(c8899Xu4, str, i, (AbstractC3769Cg6) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC14904ig6.o(abstractC3769Cg6, str, eVarD, ua2, null, ua22, ua23, zBooleanValue, zContains, (UA2) objB4, interfaceC22053ub1, 0, 16);
            }
            interfaceC22053ub1.Q();
        }
    }

    /* renamed from: ir.nasim.Xu4$B */
    static final class B implements InterfaceC16978mB2 {
        final /* synthetic */ C20996sx3 a;
        final /* synthetic */ C8899Xu4 b;
        final /* synthetic */ String c;

        B(C20996sx3 c20996sx3, C8899Xu4 c8899Xu4, String str) {
            this.a = c20996sx3;
            this.b = c8899Xu4;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C8899Xu4 c8899Xu4, C11458d25 c11458d25) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(c11458d25, "peer");
            c8899Xu4.Kb(c11458d25);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(C8899Xu4 c8899Xu4, C11458d25 c11458d25) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(c11458d25, "peer");
            c8899Xu4.Nb(c11458d25);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C8899Xu4 c8899Xu4, String str, int i, AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            C10020aw4 c10020aw4Ab = c8899Xu4.Ab();
            XV4 xv4A = AbstractC4616Fw7.a("action_type", 2);
            XV4 xv4A2 = AbstractC4616Fw7.a("peer_type", Integer.valueOf(abstractC3769Cg6.d().s().ordinal() + 1));
            XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(abstractC3769Cg6.d().getPeerId()));
            String str2 = "";
            XV4 xv4A4 = AbstractC4616Fw7.a("query_text", str == null ? "" : str);
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.c) {
                str2 = "user";
            } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.g) {
                str2 = "group";
            } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.b) {
                str2 = "channel";
            } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.a) {
                str2 = "bot";
            }
            c10020aw4Ab.m2("chat_search", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, AbstractC4616Fw7.a("event_type", str2), AbstractC4616Fw7.a("index", Integer.valueOf(i))));
            c8899Xu4.Ab().v1(abstractC3769Cg6.d());
            if (abstractC3769Cg6.d().C()) {
                C18987pb3.x1(C18987pb3.a, abstractC3769Cg6.d(), null, null, false, null, null, false, null, null, false, null, 2046, null);
            } else {
                C18987pb3.a.y1(abstractC3769Cg6.d(), null, null, false, "search");
            }
            return C19938rB7.a;
        }

        public final void d(InterfaceC6988Pv3 interfaceC6988Pv3, final int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            int i4 = i3;
            if ((i4 & 147) == 146 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.f(i);
            if (abstractC3769Cg6 == null) {
                return;
            }
            final C8899Xu4 c8899Xu4 = this.b;
            final String str = this.c;
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.d) {
                return;
            }
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.h) {
                interfaceC22053ub1.W(-536478862);
                c8899Xu4.ra(UY6.c(((AbstractC3769Cg6.h) abstractC3769Cg6).f(), interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(-536290258);
            androidx.compose.ui.e eVarD = InterfaceC6988Pv3.d(interfaceC6988Pv3, androidx.compose.ui.e.a, null, null, null, 2, null);
            interfaceC22053ub1.W(1922369554);
            boolean zD = interfaceC22053ub1.D(c8899Xu4);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.tv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.B.f(c8899Xu4, (C11458d25) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1922375172);
            boolean zD2 = interfaceC22053ub1.D(c8899Xu4);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.uv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.B.h(c8899Xu4, (C11458d25) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            UA2 ua22 = (UA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1922382805);
            boolean zD3 = interfaceC22053ub1.D(c8899Xu4) | interfaceC22053ub1.V(str) | ((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB3 = interfaceC22053ub1.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.vv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.B.i(c8899Xu4, str, i, (AbstractC3769Cg6) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC14904ig6.o(abstractC3769Cg6, str, eVarD, null, null, ua2, ua22, false, false, (UA2) objB3, interfaceC22053ub1, 0, 408);
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            d((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$C */
    static final class C implements InterfaceC15796kB2 {
        final /* synthetic */ List a;
        final /* synthetic */ C8899Xu4 b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        C(List list, C8899Xu4 c8899Xu4, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = list;
            this.b = c8899Xu4;
            this.c = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8899Xu4 c8899Xu4, List list, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(list, "$globalGroup");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isGlobalPrivatesExpanded$delegate");
            c8899Xu4.Ab().m2("global_search_show_more_click", AbstractC20051rO3.n(AbstractC4616Fw7.a("mode", C8899Xu4.Ea(interfaceC9102Ym4) ? "less" : "more"), AbstractC4616Fw7.a("initial_size", Integer.valueOf(list.size())), AbstractC4616Fw7.a("category_id", 1)));
            C8899Xu4.Fa(interfaceC9102Ym4, !C8899Xu4.Ea(interfaceC9102Ym4));
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (this.a.size() <= this.b.Ab().E1()) {
                interfaceC22053ub1.W(-532331372);
                this.b.ra(UY6.c(AbstractC12217eE5.global_search_private, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(-533447961);
            C8899Xu4 c8899Xu4 = this.b;
            String strC = UY6.c(AbstractC12217eE5.global_search_private, interfaceC22053ub1, 0);
            Boolean boolValueOf = Boolean.valueOf(C8899Xu4.Ea(this.c));
            interfaceC22053ub1.W(1922463808);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
            final C8899Xu4 c8899Xu42 = this.b;
            final List list = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.wv4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8899Xu4.C.c(c8899Xu42, list, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            c8899Xu4.Za(strC, boolValueOf, (SA2) objB, interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$D */
    static final class D implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC9102Ym4 b;
        final /* synthetic */ List c;
        final /* synthetic */ String d;

        /* renamed from: ir.nasim.Xu4$D$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ List a;
            final /* synthetic */ int b;
            final /* synthetic */ String c;
            final /* synthetic */ C8899Xu4 d;

            a(List list, int i, String str, C8899Xu4 c8899Xu4) {
                this.a = list;
                this.b = i;
                this.c = str;
                this.d = c8899Xu4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C8899Xu4 c8899Xu4, String str, int i, AbstractC3769Cg6 abstractC3769Cg6) {
                AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
                AbstractC13042fc3.i(abstractC3769Cg6, "it");
                c8899Xu4.Ab().m2("chat_search", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", 2), AbstractC4616Fw7.a("peer_type", Integer.valueOf(abstractC3769Cg6.d().s().ordinal() + 1)), AbstractC4616Fw7.a("peer_id", Integer.valueOf(abstractC3769Cg6.d().getPeerId())), AbstractC4616Fw7.a("query_text", str == null ? "" : str), AbstractC4616Fw7.a("event_type", "jostojuye sarsari goorooh"), AbstractC4616Fw7.a("index", Integer.valueOf(i))));
                c8899Xu4.Cb();
                c8899Xu4.Ab().v1(abstractC3769Cg6.d());
                C18987pb3.x1(C18987pb3.a, abstractC3769Cg6.d(), null, null, false, null, null, false, null, null, false, null, 2046, null);
                return C19938rB7.a;
            }

            public final void b(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
                AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(this.b);
                String str = this.c;
                interfaceC22053ub1.W(-118959503);
                boolean zD = interfaceC22053ub1.D(this.d) | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.e(this.b);
                final C8899Xu4 c8899Xu4 = this.d;
                final String str2 = this.c;
                final int i2 = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.xv4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.D.a.c(c8899Xu4, str2, i2, (AbstractC3769Cg6) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC14904ig6.o(abstractC3769Cg6, str, null, null, null, null, null, false, false, (UA2) objB, interfaceC22053ub1, 0, 508);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        D(InterfaceC9102Ym4 interfaceC9102Ym4, List list, String str) {
            this.b = interfaceC9102Ym4;
            this.c = list;
            this.d = str;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC22231ut.f(C8899Xu4.Ea(this.b) || ((long) i) < C8899Xu4.this.Ab().E1(), null, androidx.compose.animation.f.m(null, null, false, null, 15, null), androidx.compose.animation.f.y(null, null, false, null, 15, null), null, AbstractC19242q11.e(-773663332, true, new a(this.c, i, this.d, C8899Xu4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 200064, 18);
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$E */
    static final class E implements InterfaceC15796kB2 {
        final /* synthetic */ List a;
        final /* synthetic */ C8899Xu4 b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        E(List list, C8899Xu4 c8899Xu4, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = list;
            this.b = c8899Xu4;
            this.c = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8899Xu4 c8899Xu4, List list, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(list, "$globalGroup");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isGlobalGroupsExpanded$delegate");
            c8899Xu4.Ab().m2("global_search_show_more_click", AbstractC20051rO3.n(AbstractC4616Fw7.a("mode", C8899Xu4.Ga(interfaceC9102Ym4) ? "less" : "more"), AbstractC4616Fw7.a("initial_size", Integer.valueOf(list.size())), AbstractC4616Fw7.a("category_id", 2)));
            C8899Xu4.Ha(interfaceC9102Ym4, !C8899Xu4.Ga(interfaceC9102Ym4));
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (this.a.size() <= this.b.Ab().E1()) {
                interfaceC22053ub1.W(-528712618);
                this.b.ra(UY6.c(AbstractC12217eE5.global_search_group, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(-529819535);
            C8899Xu4 c8899Xu4 = this.b;
            String strC = UY6.c(AbstractC12217eE5.global_search_group, interfaceC22053ub1, 0);
            Boolean boolValueOf = Boolean.valueOf(C8899Xu4.Ga(this.c));
            interfaceC22053ub1.W(1922580730);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
            final C8899Xu4 c8899Xu42 = this.b;
            final List list = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.yv4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8899Xu4.E.c(c8899Xu42, list, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            c8899Xu4.Za(strC, boolValueOf, (SA2) objB, interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$F */
    static final class F implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC9102Ym4 b;
        final /* synthetic */ List c;
        final /* synthetic */ String d;

        /* renamed from: ir.nasim.Xu4$F$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ List a;
            final /* synthetic */ int b;
            final /* synthetic */ String c;
            final /* synthetic */ C8899Xu4 d;

            /* renamed from: ir.nasim.Xu4$F$a$a, reason: collision with other inner class name */
            /* synthetic */ class C0772a extends C23553x7 implements UA2 {
                C0772a(Object obj) {
                    super(1, obj, C10020aw4.class, "joinPublicGroup", "joinPublicGroup(Lir/nasim/core/modules/profile/entity/Peer;Z)Lkotlinx/coroutines/Job;", 8);
                }

                public final void a(C11458d25 c11458d25) {
                    AbstractC13042fc3.i(c11458d25, "p0");
                    C10020aw4.W1((C10020aw4) this.a, c11458d25, false, 2, null);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((C11458d25) obj);
                    return C19938rB7.a;
                }
            }

            a(List list, int i, String str, C8899Xu4 c8899Xu4) {
                this.a = list;
                this.b = i;
                this.c = str;
                this.d = c8899Xu4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C8899Xu4 c8899Xu4, String str, int i, AbstractC3769Cg6 abstractC3769Cg6) {
                AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
                AbstractC13042fc3.i(abstractC3769Cg6, "it");
                C10020aw4 c10020aw4Ab = c8899Xu4.Ab();
                XV4 xv4A = AbstractC4616Fw7.a("action_type", 2);
                XV4 xv4A2 = AbstractC4616Fw7.a("peer_type", Integer.valueOf(abstractC3769Cg6.d().s().ordinal() + 1));
                XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(abstractC3769Cg6.d().getPeerId()));
                if (str == null) {
                    str = "";
                }
                c10020aw4Ab.m2("chat_search", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a("query_text", str), AbstractC4616Fw7.a("event_type", "jostojuye sarsari goorooh"), AbstractC4616Fw7.a("index", Integer.valueOf(i))));
                c8899Xu4.Cb();
                c8899Xu4.Ab().v1(abstractC3769Cg6.d());
                C18987pb3.a.y1(abstractC3769Cg6.d(), null, null, false, "search");
                return C19938rB7.a;
            }

            public final void b(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
                AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(this.b);
                String str = this.c;
                C10020aw4 c10020aw4Ab = this.d.Ab();
                interfaceC22053ub1.W(-118839755);
                boolean zD = interfaceC22053ub1.D(c10020aw4Ab);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C0772a(c10020aw4Ab);
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-118836134);
                boolean zD2 = interfaceC22053ub1.D(this.d) | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.e(this.b);
                final C8899Xu4 c8899Xu4 = this.d;
                final String str2 = this.c;
                final int i2 = this.b;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.zv4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.F.a.c(c8899Xu4, str2, i2, (AbstractC3769Cg6) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC14904ig6.o(abstractC3769Cg6, str, null, null, ua2, null, null, false, false, (UA2) objB2, interfaceC22053ub1, 0, 492);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        F(InterfaceC9102Ym4 interfaceC9102Ym4, List list, String str) {
            this.b = interfaceC9102Ym4;
            this.c = list;
            this.d = str;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC22231ut.f(C8899Xu4.Ga(this.b) || ((long) i) < C8899Xu4.this.Ab().E1(), null, androidx.compose.animation.f.m(null, null, false, null, 15, null), androidx.compose.animation.f.y(null, null, false, null, 15, null), null, AbstractC19242q11.e(1325757573, true, new a(this.c, i, this.d, C8899Xu4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 200064, 18);
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$G */
    static final class G implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Xu4$G$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C8899Xu4 a;
            final /* synthetic */ InterfaceC9664aL6 b;

            /* renamed from: ir.nasim.Xu4$G$a$a, reason: collision with other inner class name */
            static final class C0773a implements InterfaceC14603iB2 {
                final /* synthetic */ C8899Xu4 a;
                final /* synthetic */ InterfaceC9664aL6 b;

                /* renamed from: ir.nasim.Xu4$G$a$a$a, reason: collision with other inner class name */
                static final class C0774a implements InterfaceC14603iB2 {
                    final /* synthetic */ C8899Xu4 a;
                    final /* synthetic */ InterfaceC9664aL6 b;

                    /* renamed from: ir.nasim.Xu4$G$a$a$a$a, reason: collision with other inner class name */
                    static final class C0775a implements InterfaceC14603iB2 {
                        final /* synthetic */ C8899Xu4 a;
                        final /* synthetic */ InterfaceC9664aL6 b;

                        /* renamed from: ir.nasim.Xu4$G$a$a$a$a$a, reason: collision with other inner class name */
                        /* synthetic */ class C0776a extends EB2 implements UA2 {
                            C0776a(Object obj) {
                                super(1, obj, C10020aw4.class, "setQuery", "setQuery(Ljava/lang/String;)V", 0);
                            }

                            @Override // ir.nasim.UA2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                y((String) obj);
                                return C19938rB7.a;
                            }

                            public final void y(String str) {
                                ((C10020aw4) this.receiver).o2(str);
                            }
                        }

                        /* renamed from: ir.nasim.Xu4$G$a$a$a$a$b */
                        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                            int b;
                            /* synthetic */ Object c;

                            b(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(2, interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                                b bVar = new b(interfaceC20295rm1);
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
                                return ((C13723gi6) this.c).f();
                            }

                            @Override // ir.nasim.InterfaceC14603iB2
                            /* renamed from: n, reason: merged with bridge method [inline-methods] */
                            public final Object invoke(C13723gi6 c13723gi6, InterfaceC20295rm1 interfaceC20295rm1) {
                                return ((b) create(c13723gi6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                            }
                        }

                        /* renamed from: ir.nasim.Xu4$G$a$a$a$a$c */
                        /* synthetic */ class c extends EB2 implements UA2 {
                            c(Object obj) {
                                super(1, obj, C10020aw4.class, "setSearchState", "setSearchState(Lir/nasim/components/appbar/searchbar/SearchFocusState;)V", 0);
                            }

                            @Override // ir.nasim.UA2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                y((AbstractC17858ng6) obj);
                                return C19938rB7.a;
                            }

                            public final void y(AbstractC17858ng6 abstractC17858ng6) {
                                AbstractC13042fc3.i(abstractC17858ng6, "p0");
                                ((C10020aw4) this.receiver).p2(abstractC17858ng6);
                            }
                        }

                        C0775a(C8899Xu4 c8899Xu4, InterfaceC9664aL6 interfaceC9664aL6) {
                            this.a = c8899Xu4;
                            this.b = interfaceC9664aL6;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final C19938rB7 c(C8899Xu4 c8899Xu4) {
                            AbstractC13042fc3.i(c8899Xu4, "this$0");
                            c8899Xu4.Ab().j2();
                            return C19938rB7.a;
                        }

                        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                                interfaceC22053ub1.L();
                                return;
                            }
                            if (!((Boolean) this.a.Ab().T1().getValue()).booleanValue()) {
                                interfaceC22053ub1.W(-1639429070);
                                String strJ1 = this.a.Ab().J1();
                                String strC = G.c(this.b);
                                if (strC == null) {
                                    strC = "";
                                }
                                String str = strC;
                                Object objAb = this.a.Ab();
                                interfaceC22053ub1.W(778407045);
                                boolean zD = interfaceC22053ub1.D(objAb);
                                Object objB = interfaceC22053ub1.B();
                                if (zD || objB == InterfaceC22053ub1.a.a()) {
                                    objB = new C0776a(objAb);
                                    interfaceC22053ub1.s(objB);
                                }
                                InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB;
                                interfaceC22053ub1.Q();
                                InterfaceC10258bL6 interfaceC10258bL6P1 = this.a.Ab().P1();
                                interfaceC22053ub1.W(778415015);
                                Object objB2 = interfaceC22053ub1.B();
                                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                                if (objB2 == aVar.a()) {
                                    objB2 = new b(null);
                                    interfaceC22053ub1.s(objB2);
                                }
                                interfaceC22053ub1.Q();
                                AbstractC17858ng6 abstractC17858ng6 = (AbstractC17858ng6) AbstractC10222bH6.a(AbstractC6459Nq2.X(interfaceC10258bL6P1, (InterfaceC14603iB2) objB2), AbstractC17858ng6.b.b, null, interfaceC22053ub1, AbstractC17858ng6.b.c << 3, 2).getValue();
                                Object objAb2 = this.a.Ab();
                                interfaceC22053ub1.W(778421291);
                                boolean zD2 = interfaceC22053ub1.D(objAb2);
                                Object objB3 = interfaceC22053ub1.B();
                                if (zD2 || objB3 == aVar.a()) {
                                    objB3 = new c(objAb2);
                                    interfaceC22053ub1.s(objB3);
                                }
                                interfaceC22053ub1.Q();
                                AbstractC16075kf6.j(strJ1, str, (UA2) interfaceC16733lm3, true, (UA2) ((InterfaceC16733lm3) objB3), abstractC17858ng6, true, null, null, null, null, interfaceC22053ub1, (AbstractC17858ng6.a << 15) | 1575936, 0, 1920);
                                interfaceC22053ub1.Q();
                                return;
                            }
                            interfaceC22053ub1.W(-1638587761);
                            e.a aVar2 = androidx.compose.ui.e.a;
                            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), C17784nZ1.q(4), 0.0f, 0.0f, 0.0f, 14, null);
                            C24254yJ.f fVarO = C24254yJ.a.o(C17784nZ1.q(16));
                            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
                            final C8899Xu4 c8899Xu4 = this.a;
                            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarO, cVarI, interfaceC22053ub1, 54);
                            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
                            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                            SA2 sa2A = aVar3.a();
                            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                                AbstractC6797Pa1.c();
                            }
                            interfaceC22053ub1.G();
                            if (interfaceC22053ub1.h()) {
                                interfaceC22053ub1.g(sa2A);
                            } else {
                                interfaceC22053ub1.r();
                            }
                            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
                            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                                interfaceC22053ub1A.s(Integer.valueOf(iA));
                                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                            }
                            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                            M66 m66 = M66.a;
                            interfaceC22053ub1.W(-282170563);
                            boolean zD3 = interfaceC22053ub1.D(c8899Xu4);
                            Object objB4 = interfaceC22053ub1.B();
                            if (zD3 || objB4 == InterfaceC22053ub1.a.a()) {
                                objB4 = new SA2() { // from class: ir.nasim.Av4
                                    @Override // ir.nasim.SA2
                                    public final Object invoke() {
                                        return C8899Xu4.G.a.C0773a.C0774a.C0775a.c(c8899Xu4);
                                    }
                                };
                                interfaceC22053ub1.s(objB4);
                            }
                            interfaceC22053ub1.Q();
                            AbstractC11456d23.b(FV4.c(KB5.pin, interfaceC22053ub1, 0), null, androidx.compose.foundation.e.f(aVar2, false, null, null, (SA2) objB4, 7, null), null, null, 0.0f, AbstractC24975zX0.a.b(AbstractC24975zX0.b, G10.a.a(interfaceC22053ub1, G10.b).G(), 0, 2, null), interfaceC22053ub1, 48, 56);
                            interfaceC22053ub1.u();
                            interfaceC22053ub1.Q();
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                            return C19938rB7.a;
                        }
                    }

                    C0774a(C8899Xu4 c8899Xu4, InterfaceC9664aL6 interfaceC9664aL6) {
                        this.a = c8899Xu4;
                        this.b = interfaceC9664aL6;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1, G10.b).b().u(), 0.0f, 2, null);
                        InterfaceC12529em interfaceC12529emE = InterfaceC12529em.a.e();
                        C8899Xu4 c8899Xu4 = this.a;
                        InterfaceC9664aL6 interfaceC9664aL6 = this.b;
                        InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emE, false);
                        int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                        InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                        androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
                        InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                        SA2 sa2A = aVar.a();
                        if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                            AbstractC6797Pa1.c();
                        }
                        interfaceC22053ub1.G();
                        if (interfaceC22053ub1.h()) {
                            interfaceC22053ub1.g(sa2A);
                        } else {
                            interfaceC22053ub1.r();
                        }
                        InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                        DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                        DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                        InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                        if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                            interfaceC22053ub1A.s(Integer.valueOf(iA));
                            interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                        }
                        DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                        androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                        AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(1331951393, true, new C0775a(c8899Xu4, interfaceC9664aL6), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                        interfaceC22053ub1.u();
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Xu4$G$a$a$b */
                static final class b implements InterfaceC14603iB2 {
                    final /* synthetic */ C8899Xu4 a;

                    /* renamed from: ir.nasim.Xu4$G$a$a$b$a, reason: collision with other inner class name */
                    static final class C0777a implements InterfaceC14603iB2 {
                        final /* synthetic */ C8899Xu4 a;

                        C0777a(C8899Xu4 c8899Xu4) {
                            this.a = c8899Xu4;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final C19938rB7 c(C8899Xu4 c8899Xu4) {
                            AbstractC13042fc3.i(c8899Xu4, "this$0");
                            c8899Xu4.Ab().z1();
                            return C19938rB7.a;
                        }

                        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                                interfaceC22053ub1.L();
                                return;
                            }
                            C24254yJ.f fVarO = C24254yJ.a.o(C17784nZ1.q(12));
                            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
                            final C8899Xu4 c8899Xu4 = this.a;
                            e.a aVar = androidx.compose.ui.e.a;
                            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarO, cVarI, interfaceC22053ub1, 54);
                            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                            SA2 sa2A = aVar2.a();
                            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                                AbstractC6797Pa1.c();
                            }
                            interfaceC22053ub1.G();
                            if (interfaceC22053ub1.h()) {
                                interfaceC22053ub1.g(sa2A);
                            } else {
                                interfaceC22053ub1.r();
                            }
                            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
                            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                                interfaceC22053ub1A.s(Integer.valueOf(iA));
                                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                            }
                            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                            M66 m66 = M66.a;
                            String strV = XY6.v(String.valueOf(c8899Xu4.Ab().K1().size()));
                            G10 g10 = G10.a;
                            int i2 = G10.b;
                            AbstractC9339Zm7.b(strV, null, g10.a(interfaceC22053ub1, i2).G(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65530);
                            interfaceC22053ub1.W(-282072421);
                            boolean zD = interfaceC22053ub1.D(c8899Xu4);
                            Object objB = interfaceC22053ub1.B();
                            if (zD || objB == InterfaceC22053ub1.a.a()) {
                                objB = new SA2() { // from class: ir.nasim.Cv4
                                    @Override // ir.nasim.SA2
                                    public final Object invoke() {
                                        return C8899Xu4.G.a.C0773a.b.C0777a.c(c8899Xu4);
                                    }
                                };
                                interfaceC22053ub1.s(objB);
                            }
                            interfaceC22053ub1.Q();
                            AbstractC11456d23.b(FV4.c(KB5.message_button_cancel, interfaceC22053ub1, 0), null, androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB, 7, null), null, null, 0.0f, AbstractC24975zX0.a.b(AbstractC24975zX0.b, g10.a(interfaceC22053ub1, i2).G(), 0, 2, null), interfaceC22053ub1, 48, 56);
                            interfaceC22053ub1.u();
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                            return C19938rB7.a;
                        }
                    }

                    b(C8899Xu4 c8899Xu4) {
                        this.a = c8899Xu4;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(C8899Xu4 c8899Xu4) {
                        AbstractC13042fc3.i(c8899Xu4, "this$0");
                        c8899Xu4.Q7().onBackPressed();
                        return C19938rB7.a;
                    }

                    public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        e.a aVar = androidx.compose.ui.e.a;
                        androidx.compose.ui.e eVarD = androidx.compose.foundation.layout.t.d(aVar, 0.0f, 1, null);
                        G10 g10 = G10.a;
                        int i2 = G10.b;
                        androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(eVarD, g10.c(interfaceC22053ub1, i2).b().c(), 0.0f, 0.0f, 0.0f, 14, null);
                        InterfaceC12529em interfaceC12529emE = InterfaceC12529em.a.e();
                        final C8899Xu4 c8899Xu4 = this.a;
                        InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emE, false);
                        int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                        InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                        androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
                        InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                        SA2 sa2A = aVar2.a();
                        if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                            AbstractC6797Pa1.c();
                        }
                        interfaceC22053ub1.G();
                        if (interfaceC22053ub1.h()) {
                            interfaceC22053ub1.g(sa2A);
                        } else {
                            interfaceC22053ub1.r();
                        }
                        InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                        DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
                        DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                        InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                        if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                            interfaceC22053ub1A.s(Integer.valueOf(iA));
                            interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                        }
                        DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                        androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                        if (((Boolean) c8899Xu4.Ab().T1().getValue()).booleanValue()) {
                            interfaceC22053ub1.W(-541070305);
                            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(1804748987, true, new C0777a(c8899Xu4), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                            interfaceC22053ub1.Q();
                        } else {
                            interfaceC22053ub1.W(-541976869);
                            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j());
                            interfaceC22053ub1.W(-156022952);
                            boolean zD = interfaceC22053ub1.D(c8899Xu4);
                            Object objB = interfaceC22053ub1.B();
                            if (zD || objB == InterfaceC22053ub1.a.a()) {
                                objB = new SA2() { // from class: ir.nasim.Bv4
                                    @Override // ir.nasim.SA2
                                    public final Object invoke() {
                                        return C8899Xu4.G.a.C0773a.b.c(c8899Xu4);
                                    }
                                };
                                interfaceC22053ub1.s(objB);
                            }
                            interfaceC22053ub1.Q();
                            AbstractC24077y03.b(C02.e(new SV(false), interfaceC22053ub1, 0), UY6.c(AbstractC12217eE5.submit_return, interfaceC22053ub1, 0), androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null), g10.a(interfaceC22053ub1, i2).G(), interfaceC22053ub1, 0, 0);
                            interfaceC22053ub1.Q();
                        }
                        interfaceC22053ub1.u();
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C0773a(C8899Xu4 c8899Xu4, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = c8899Xu4;
                    this.b = interfaceC9664aL6;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    A98 a98A = AbstractC21393ta8.a(0, 0, 0, 0);
                    androidx.compose.ui.e eVarB = androidx.compose.foundation.layout.t.b(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(56), 1, null);
                    C17388ms7 c17388ms7A = C17979ns7.a.a(interfaceC22053ub1, C17979ns7.g);
                    ED.a(AbstractC19242q11.e(112445223, true, new C0774a(this.a, this.b), interfaceC22053ub1, 54), eVarB, AbstractC19242q11.e(-1727110683, true, new b(this.a), interfaceC22053ub1, 54), null, 0.0f, a98A, c17388ms7A.b((30 & 1) != 0 ? c17388ms7A.a : G10.a.a(interfaceC22053ub1, G10.b).q(), (30 & 2) != 0 ? c17388ms7A.b : 0L, (30 & 4) != 0 ? c17388ms7A.c : 0L, (30 & 8) != 0 ? c17388ms7A.d : 0L, (30 & 16) != 0 ? c17388ms7A.e : 0L), null, interfaceC22053ub1, 438, 152);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C8899Xu4 c8899Xu4, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = c8899Xu4;
                this.b = interfaceC9664aL6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(1937692844, true, new C0773a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        G() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String c(InterfaceC9664aL6 interfaceC9664aL6) {
            return (String) interfaceC9664aL6.getValue();
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1077527916, true, new a(C8899Xu4.this, AbstractC10222bH6.b(C8899Xu4.this.Ab().H1(), null, interfaceC22053ub1, 0, 1)), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$H */
    static final class H implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Xu4$H$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C8899Xu4 a;

            a(C8899Xu4 c8899Xu4) {
                this.a = c8899Xu4;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.a(interfaceC22053ub1, G10.b).r(), null, 2, null);
                InterfaceC12529em interfaceC12529emM = InterfaceC12529em.a.m();
                C8899Xu4 c8899Xu4 = this.a;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emM, false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                c8899Xu4.ta(interfaceC22053ub1, 0);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        H() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1491893182, true, new a(C8899Xu4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$I */
    static final class I implements InterfaceC15796kB2 {
        I() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(final C8899Xu4 c8899Xu4) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            int i = AbstractC12217eE5.recent_search_remove_all_modal_yes;
            c8899Xu4.Tb(i, AbstractC12217eE5.recent_search_clear_modal_description, i, new String[0], new SA2() { // from class: ir.nasim.Ev4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C8899Xu4.I.f(c8899Xu4);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C8899Xu4 c8899Xu4) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            c8899Xu4.Ab().x1();
            return C19938rB7.a;
        }

        public final void c(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(aVar, g10.a(interfaceC22053ub1, i2).y(), null, 2, null), g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().u());
            final C8899Xu4 c8899Xu4 = C8899Xu4.this;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            String strC = UY6.c(AbstractC12217eE5.search_menu_recent, interfaceC22053ub1, 0);
            C9348Zn7 c9348Zn7O = g10.d(interfaceC22053ub1, i2).o();
            C6399Nk7.a aVar3 = C6399Nk7.b;
            AbstractC9339Zm7.b(strC, L66.b(m66, aVar, 1.0f, false, 2, null), g10.a(interfaceC22053ub1, i2).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7O.b((16744447 & 1) != 0 ? c9348Zn7O.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7O.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7O.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7O.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7O.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7O.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7O.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7O.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7O.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7O.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7O.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7O.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7O.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7O.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7O.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7O.b.h() : aVar3.f(), (16744447 & 65536) != 0 ? c9348Zn7O.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7O.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7O.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7O.c : null, (16744447 & 1048576) != 0 ? c9348Zn7O.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7O.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7O.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7O.b.k() : null), interfaceC22053ub1, 0, 0, 65528);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().c()), interfaceC22053ub1, 0);
            String strC2 = UY6.c(AbstractC12217eE5.market_search_clear_all, interfaceC22053ub1, 0);
            C9348Zn7 c9348Zn7E = g10.d(interfaceC22053ub1, i2).e();
            C9348Zn7 c9348Zn7B = c9348Zn7E.b((16744447 & 1) != 0 ? c9348Zn7E.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7E.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7E.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7E.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7E.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7E.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7E.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7E.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7E.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7E.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7E.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7E.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7E.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7E.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7E.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7E.b.h() : aVar3.b(), (16744447 & 65536) != 0 ? c9348Zn7E.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7E.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7E.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7E.c : null, (16744447 & 1048576) != 0 ? c9348Zn7E.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7E.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7E.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7E.b.k() : null);
            interfaceC22053ub1.W(347564937);
            boolean zD = interfaceC22053ub1.D(c8899Xu4);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Dv4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8899Xu4.I.d(c8899Xu4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC9339Zm7.b(strC2, androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB, 7, null), g10.a(interfaceC22053ub1, i2).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7B, interfaceC22053ub1, 0, 0, 65528);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$J */
    static final class J implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ C8899Xu4 b;

        J(List list, C8899Xu4 c8899Xu4) {
            this.a = list;
            this.b = c8899Xu4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(final C8899Xu4 c8899Xu4, final AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            c8899Xu4.Tb(AbstractC12217eE5.recent_search_item_remove_modal_title, AbstractC12217eE5.recent_search_item_remove_modal_description, AbstractC12217eE5.recent_search_remove_modal_yes, new String[0], new SA2() { // from class: ir.nasim.Jv4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C8899Xu4.J.k(abstractC3769Cg6, c8899Xu4);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(AbstractC3769Cg6 abstractC3769Cg6, C8899Xu4 c8899Xu4) {
            AbstractC13042fc3.i(abstractC3769Cg6, "$it");
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            Long lB = abstractC3769Cg6.b();
            if (lB != null) {
                c8899Xu4.Ab().y1(lB.longValue());
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(C8899Xu4 c8899Xu4, C11458d25 c11458d25) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            AbstractC13042fc3.i(c11458d25, "it");
            c8899Xu4.Kb(c11458d25);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(C8899Xu4 c8899Xu4, C11458d25 c11458d25) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            AbstractC13042fc3.i(c11458d25, "it");
            c8899Xu4.Nb(c11458d25);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p(C8899Xu4 c8899Xu4, AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            c8899Xu4.Cb();
            if (abstractC3769Cg6.d().C()) {
                C18987pb3.x1(C18987pb3.a, abstractC3769Cg6.d(), null, null, false, null, null, false, null, null, false, null, 2046, null);
            } else {
                C18987pb3.a.y1(abstractC3769Cg6.d(), null, null, false, "search");
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            h((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }

        public final void h(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
            } else {
                i3 = i2;
            }
            if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(i);
            interfaceC22053ub1.W(1648305548);
            boolean zD = interfaceC22053ub1.D(this.b);
            final C8899Xu4 c8899Xu4 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Fv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.J.i(c8899Xu4, (AbstractC3769Cg6) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1648300721);
            boolean zD2 = interfaceC22053ub1.D(this.b);
            final C8899Xu4 c8899Xu42 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.Gv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.J.n(c8899Xu42, (C11458d25) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            UA2 ua22 = (UA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1648303114);
            boolean zD3 = interfaceC22053ub1.D(this.b);
            final C8899Xu4 c8899Xu43 = this.b;
            Object objB3 = interfaceC22053ub1.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.Hv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.J.o(c8899Xu43, (C11458d25) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            UA2 ua23 = (UA2) objB3;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1648317300);
            boolean zD4 = interfaceC22053ub1.D(this.b);
            final C8899Xu4 c8899Xu44 = this.b;
            Object objB4 = interfaceC22053ub1.B();
            if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new UA2() { // from class: ir.nasim.Iv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.J.p(c8899Xu44, (AbstractC3769Cg6) obj);
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            AbstractC14904ig6.o(abstractC3769Cg6, null, null, ua2, null, ua22, ua23, false, false, (UA2) objB4, interfaceC22053ub1, 0, 406);
        }
    }

    /* renamed from: ir.nasim.Xu4$K */
    static final class K implements InterfaceC15796kB2 {
        K() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C8899Xu4.this.ra(UY6.c(AbstractC12217eE5.recommended_groups, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$L */
    static final class L implements InterfaceC16978mB2 {
        final /* synthetic */ List a;

        L(List list) {
            this.a = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            C18987pb3.a.y1(abstractC3769Cg6.d(), null, null, false, "recommendation_group_search");
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
            } else {
                i3 = i2;
            }
            if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(i);
            interfaceC22053ub1.W(1547645245);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Kv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.L.c((AbstractC3769Cg6) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC14904ig6.o(abstractC3769Cg6, null, null, null, null, null, null, false, false, (UA2) objB, interfaceC22053ub1, 805306368, 510);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$M */
    static final class M implements InterfaceC15796kB2 {
        final /* synthetic */ int a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ String[] e;

        /* renamed from: ir.nasim.Xu4$M$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(UY6.c(this.a, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Xu4$M$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ int a;
            final /* synthetic */ String[] b;

            b(int i, String[] strArr) {
                this.a = i;
                this.b = strArr;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                int i2 = this.a;
                String[] strArr = this.b;
                AbstractC19555qZ.e0(UY6.d(i2, Arrays.copyOf(strArr, strArr.length), interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        M(int i, SA2 sa2, int i2, int i3, String[] strArr) {
            this.a = i;
            this.b = sa2;
            this.c = i2;
            this.d = i3;
            this.e = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, SA2 sa2) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(sa2, "$onInfoClickListener");
            dialog.dismiss();
            sa2.invoke();
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
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            String strC = UY6.c(this.a, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(AbstractC12217eE5.dialog_negative_button_cancel, interfaceC22053ub1, 0);
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1050919451, true, new a(this.c), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-901630503, true, new b(this.d, this.e), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(461335407);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.V(this.b);
            final SA2 sa2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Lv4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8899Xu4.M.d(dialog, sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(461343845);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Mv4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8899Xu4.M.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC18060o11E, c0905b, interfaceC18060o11E2, cVar, aVar, sa22, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$N */
    public static final class N extends AbstractC8614Ws3 implements UA2 {
        public N() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C6541Ny2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Xu4$O */
    public static final class O extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public O(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Xu4$P */
    public static final class P extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public P(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Xu4$Q */
    public static final class Q extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Q(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Xu4$R */
    public static final class R extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public R(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Xu4$S */
    public static final class S extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public S(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Xu4$T */
    static final class T implements InterfaceC15796kB2 {
        T() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C8899Xu4 c8899Xu4) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            c8899Xu4.Ab().i2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C8899Xu4 c8899Xu4) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            c8899Xu4.Ab().r2(false);
            return C19938rB7.a;
        }

        public final void c(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (((Boolean) AbstractC10222bH6.b(C8899Xu4.this.Ab().L1(), null, interfaceC22053ub1, 0, 1).getValue()).booleanValue()) {
                e.a aVar = androidx.compose.ui.e.a;
                G10 g10 = G10.a;
                int i2 = G10.b;
                androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.c(androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i2).b().c()), g10.a(interfaceC22053ub1, i2).y(), N46.d(g10.c(interfaceC22053ub1, i2).b().c())), g10.c(interfaceC22053ub1, i2).b().c(), C17784nZ1.q(7.0f));
                InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                InterfaceC12529em.c cVarI = aVar2.i();
                final C8899Xu4 c8899Xu4 = C8899Xu4.this;
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), cVarI, interfaceC22053ub1, 48);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
                InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar3.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                M66 m66 = M66.a;
                AbstractC24077y03.b(FV4.c(KB5.check_list, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j()), g10.a(interfaceC22053ub1, i2).a(), interfaceC22053ub1, 48, 0);
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().n()), interfaceC22053ub1, 0);
                String strC = UY6.c(AbstractC12217eE5.search_menu_global, interfaceC22053ub1, 0);
                C9348Zn7 c9348Zn7H = g10.d(interfaceC22053ub1, i2).h();
                AbstractC9339Zm7.b(strC, L66.b(m66, aVar, 1.0f, false, 2, null), g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 2, 0, null, c9348Zn7H.b((16744447 & 1) != 0 ? c9348Zn7H.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7H.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7H.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7H.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7H.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7H.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7H.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7H.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7H.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7H.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7H.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7H.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7H.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7H.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7H.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7H.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7H.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7H.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7H.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7H.c : null, (16744447 & 1048576) != 0 ? c9348Zn7H.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7H.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7H.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7H.b.k() : null), interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 57336);
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().r()), interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-604369840);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
                if (objB == aVar4.a()) {
                    objB = AbstractC23831xb3.a();
                    interfaceC22053ub1.s(objB);
                }
                InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-604365881);
                boolean zD = interfaceC22053ub1.D(c8899Xu4);
                Object objB2 = interfaceC22053ub1.B();
                if (zD || objB2 == aVar4.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Nv4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C8899Xu4.T.d(c8899Xu4);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarJ2 = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.e.d(aVar, interfaceC18507om4, null, false, null, null, (SA2) objB2, 28, null), g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().r());
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ2);
                SA2 sa2A2 = aVar3.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A2);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar3.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                String strC2 = UY6.c(AbstractC12217eE5.submit_group_global, interfaceC22053ub1, 0);
                C9348Zn7 c9348Zn7P = g10.d(interfaceC22053ub1, i2).p();
                AbstractC9339Zm7.b(strC2, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7P.b((16744447 & 1) != 0 ? c9348Zn7P.a.g() : g10.a(interfaceC22053ub1, i2).I(), (16744447 & 2) != 0 ? c9348Zn7P.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7P.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7P.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7P.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7P.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7P.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7P.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7P.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7P.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7P.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7P.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7P.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7P.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7P.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7P.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7P.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7P.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7P.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7P.c : null, (16744447 & 1048576) != 0 ? c9348Zn7P.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7P.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7P.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7P.b.k() : null), interfaceC22053ub1, 0, 0, 65534);
                interfaceC22053ub1.u();
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().r()), interfaceC22053ub1, 0);
                androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j());
                interfaceC22053ub1.W(-604334096);
                Object objB3 = interfaceC22053ub1.B();
                if (objB3 == aVar4.a()) {
                    objB3 = AbstractC23831xb3.a();
                    interfaceC22053ub1.s(objB3);
                }
                InterfaceC18507om4 interfaceC18507om42 = (InterfaceC18507om4) objB3;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-604330124);
                boolean zD2 = interfaceC22053ub1.D(c8899Xu4);
                Object objB4 = interfaceC22053ub1.B();
                if (zD2 || objB4 == aVar4.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.Ov4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C8899Xu4.T.f(c8899Xu4);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarD = androidx.compose.foundation.e.d(eVarT, interfaceC18507om42, null, false, null, null, (SA2) objB4, 28, null);
                InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
                SA2 sa2A3 = aVar3.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A3);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G2, aVar3.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
                AbstractC24077y03.b(FV4.c(KB5.close, interfaceC22053ub1, 0), UY6.c(AbstractC12217eE5.gift_dialogs_back, interfaceC22053ub1, 0), null, g10.a(interfaceC22053ub1, i2).B(), interfaceC22053ub1, 0, 4);
                interfaceC22053ub1.u();
                interfaceC22053ub1.u();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$a, reason: case insensitive filesystem and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C8899Xu4 a(String str) {
            AbstractC13042fc3.i(str, "searchHint");
            C8899Xu4 c8899Xu4 = new C8899Xu4();
            c8899Xu4.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("NEW_SEARCH_HINT", str)));
            return c8899Xu4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Xu4$b, reason: case insensitive filesystem */
    static final class C8901b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C8901b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8899Xu4.this.new C8901b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C8899Xu4.this.Ab().p2(new AbstractC17858ng6.a(false, false, false, 5, null));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8901b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xu4$c, reason: case insensitive filesystem */
    static final class C8902c implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9664aL6 b;

        C8902c(InterfaceC9664aL6 interfaceC9664aL6) {
            this.b = interfaceC9664aL6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C8899Xu4 c8899Xu4, C4346Es7 c4346Es7, int i) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            AbstractC13042fc3.i(c4346Es7, "topPeer");
            c8899Xu4.Ab().n2(c4346Es7.b().s().name(), c4346Es7.b().getPeerId(), c4346Es7.c(), i, 1);
            C18987pb3.x1(C18987pb3.a, new C11458d25(W25.a, c4346Es7.b().getPeerId()), null, null, false, null, null, false, null, null, false, null, 2046, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(final C8899Xu4 c8899Xu4, final C4346Es7 c4346Es7, final int i) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            AbstractC13042fc3.i(c4346Es7, "topPeer");
            c8899Xu4.Tb(AbstractC12217eE5.delete_suggestion, AbstractC12217eE5.delete_peer_description, AbstractC12217eE5.story_delete_button, new String[]{c4346Es7.d()}, new SA2() { // from class: ir.nasim.av4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C8899Xu4.C8902c.i(c8899Xu4, c4346Es7, i);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C8899Xu4 c8899Xu4, C4346Es7 c4346Es7, int i) {
            AbstractC13042fc3.i(c8899Xu4, "this$0");
            AbstractC13042fc3.i(c4346Es7, "$topPeer");
            c8899Xu4.Ab().n2(c4346Es7.b().s().name(), c4346Es7.b().getPeerId(), c4346Es7.c(), i, 2);
            c8899Xu4.Ab().l2(c4346Es7.b());
            return C19938rB7.a;
        }

        public final void d(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            List listZa = C8899Xu4.za(this.b);
            interfaceC22053ub1.W(-1579056337);
            boolean zD = interfaceC22053ub1.D(C8899Xu4.this);
            final C8899Xu4 c8899Xu4 = C8899Xu4.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new InterfaceC14603iB2() { // from class: ir.nasim.Yu4
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return C8899Xu4.C8902c.f(c8899Xu4, (C4346Es7) obj, ((Integer) obj2).intValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1579036308);
            boolean zD2 = interfaceC22053ub1.D(C8899Xu4.this);
            final C8899Xu4 c8899Xu42 = C8899Xu4.this;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new InterfaceC14603iB2() { // from class: ir.nasim.Zu4
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return C8899Xu4.C8902c.h(c8899Xu42, (C4346Es7) obj, ((Integer) obj2).intValue());
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC6232Ms7.k(null, listZa, interfaceC14603iB2, (InterfaceC14603iB2) objB2, C8899Xu4.this.Ab().O1(), interfaceC22053ub1, 0, 1);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$d, reason: case insensitive filesystem */
    static final class C8903d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ C8899Xu4 d;
        final /* synthetic */ InterfaceC9664aL6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8903d(InterfaceC9664aL6 interfaceC9664aL6, C8899Xu4 c8899Xu4, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9664aL6;
            this.d = c8899Xu4;
            this.e = interfaceC9664aL62;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C8903d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Map mapVa = C8899Xu4.va(this.c);
            if (mapVa != null) {
                C8899Xu4 c8899Xu4 = this.d;
                InterfaceC9664aL6 interfaceC9664aL6 = this.e;
                String strUa = C8899Xu4.ua(interfaceC9664aL6);
                if ((strUa != null ? strUa.length() : 0) >= 3) {
                    C10020aw4 c10020aw4Ab = c8899Xu4.Ab();
                    Object objM = mapVa.get(ExPeerType.GROUP);
                    if (objM == null) {
                        objM = AbstractC10360bX0.m();
                    }
                    XV4 xv4A = AbstractC4616Fw7.a("group_query_result", AbstractC6392Nk0.d(((List) objM).size()));
                    Object objM2 = mapVa.get(ExPeerType.CHANNEL);
                    if (objM2 == null) {
                        objM2 = AbstractC10360bX0.m();
                    }
                    XV4 xv4A2 = AbstractC4616Fw7.a("channel_query_result", AbstractC6392Nk0.d(((List) objM2).size()));
                    String strUa2 = C8899Xu4.ua(interfaceC9664aL6);
                    if (strUa2 == null) {
                        strUa2 = "";
                    }
                    c10020aw4Ab.m2("chat_search", AbstractC20051rO3.n(xv4A, xv4A2, AbstractC4616Fw7.a("query_text", strUa2), AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(0))));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8903d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xu4$e, reason: case insensitive filesystem */
    static final class C8904e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C8904e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8899Xu4.this.new C8904e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C8899Xu4.this.Ab().p2(new AbstractC17858ng6.a(false, true, false, 5, null));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8904e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xu4$f, reason: case insensitive filesystem */
    static final class C8905f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        C8905f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C8905f c8905f = new C8905f(interfaceC20295rm1);
            c8905f.c = obj;
            return c8905f;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return ((C13723gi6) this.c).c();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C13723gi6 c13723gi6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8905f) create(c13723gi6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xu4$g, reason: case insensitive filesystem */
    static final class C8906g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        C8906g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C8906g c8906g = new C8906g(interfaceC20295rm1);
            c8906g.c = obj;
            return c8906g;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return ((C13723gi6) this.c).d();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C13723gi6 c13723gi6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8906g) create(c13723gi6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xu4$h, reason: case insensitive filesystem */
    static final class C8907h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        C8907h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C8907h c8907h = new C8907h(interfaceC20295rm1);
            c8907h.c = obj;
            return c8907h;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return ((C13723gi6) this.c).e();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C13723gi6 c13723gi6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8907h) create(c13723gi6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xu4$i, reason: case insensitive filesystem */
    static final class C8908i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        C8908i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C8908i c8908i = new C8908i(interfaceC20295rm1);
            c8908i.c = obj;
            return c8908i;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return ((C13723gi6) this.c).g();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C13723gi6 c13723gi6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8908i) create(c13723gi6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xu4$j, reason: case insensitive filesystem */
    static final class C8909j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        C8909j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8899Xu4.this.new C8909j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C8899Xu4.this.Ab().p2(new AbstractC17858ng6.a(false, false, false, 5, null));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C8909j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xu4$k, reason: case insensitive filesystem */
    static final class C8910k implements InterfaceC15796kB2 {
        final /* synthetic */ List a;
        final /* synthetic */ C8899Xu4 b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        C8910k(List list, C8899Xu4 c8899Xu4, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = list;
            this.b = c8899Xu4;
            this.c = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8899Xu4 c8899Xu4, List list, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(list, "$globalChannel");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isGlobalChannelsExpanded$delegate");
            c8899Xu4.Ab().m2("global_search_show_more_click", AbstractC20051rO3.n(AbstractC4616Fw7.a("mode", C8899Xu4.Ia(interfaceC9102Ym4) ? "less" : "more"), AbstractC4616Fw7.a("initial_size", Integer.valueOf(list.size())), AbstractC4616Fw7.a("category_id", 3)));
            C8899Xu4.Ja(interfaceC9102Ym4, !C8899Xu4.Ia(interfaceC9102Ym4));
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (this.a.size() <= this.b.Ab().E1()) {
                interfaceC22053ub1.W(-524552108);
                this.b.ra(UY6.c(AbstractC12217eE5.global_search_channel, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(-525670619);
            C8899Xu4 c8899Xu4 = this.b;
            String strC = UY6.c(AbstractC12217eE5.global_search_channel, interfaceC22053ub1, 0);
            Boolean boolValueOf = Boolean.valueOf(C8899Xu4.Ia(this.c));
            interfaceC22053ub1.W(1922714690);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
            final C8899Xu4 c8899Xu42 = this.b;
            final List list = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.bv4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8899Xu4.C8910k.c(c8899Xu42, list, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            c8899Xu4.Za(strC, boolValueOf, (SA2) objB, interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$l, reason: case insensitive filesystem */
    static final class C8911l implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC9102Ym4 b;
        final /* synthetic */ List c;
        final /* synthetic */ String d;

        /* renamed from: ir.nasim.Xu4$l$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ List a;
            final /* synthetic */ int b;
            final /* synthetic */ String c;
            final /* synthetic */ C8899Xu4 d;

            /* renamed from: ir.nasim.Xu4$l$a$a, reason: collision with other inner class name */
            /* synthetic */ class C0778a extends C23553x7 implements UA2 {
                C0778a(Object obj) {
                    super(1, obj, C10020aw4.class, "joinPublicGroup", "joinPublicGroup(Lir/nasim/core/modules/profile/entity/Peer;Z)Lkotlinx/coroutines/Job;", 8);
                }

                public final void a(C11458d25 c11458d25) {
                    AbstractC13042fc3.i(c11458d25, "p0");
                    C10020aw4.W1((C10020aw4) this.a, c11458d25, false, 2, null);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((C11458d25) obj);
                    return C19938rB7.a;
                }
            }

            a(List list, int i, String str, C8899Xu4 c8899Xu4) {
                this.a = list;
                this.b = i;
                this.c = str;
                this.d = c8899Xu4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C8899Xu4 c8899Xu4, String str, int i, AbstractC3769Cg6 abstractC3769Cg6) {
                AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
                AbstractC13042fc3.i(abstractC3769Cg6, "it");
                C10020aw4 c10020aw4Ab = c8899Xu4.Ab();
                XV4 xv4A = AbstractC4616Fw7.a("action_type", 2);
                XV4 xv4A2 = AbstractC4616Fw7.a("peer_type", Integer.valueOf(abstractC3769Cg6.d().s().ordinal() + 1));
                XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(abstractC3769Cg6.d().getPeerId()));
                if (str == null) {
                    str = "";
                }
                c10020aw4Ab.m2("chat_search", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a("query_text", str), AbstractC4616Fw7.a("event_type", "jostojuye sarsari kanal"), AbstractC4616Fw7.a("index", Integer.valueOf(i + 1))));
                c8899Xu4.Cb();
                c8899Xu4.Ab().v1(abstractC3769Cg6.d());
                C18987pb3.a.y1(abstractC3769Cg6.d(), null, null, false, "search");
                return C19938rB7.a;
            }

            public final void b(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
                AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(this.b);
                String str = this.c;
                C10020aw4 c10020aw4Ab = this.d.Ab();
                interfaceC22053ub1.W(-118705227);
                boolean zD = interfaceC22053ub1.D(c10020aw4Ab);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C0778a(c10020aw4Ab);
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-118701600);
                boolean zD2 = interfaceC22053ub1.D(this.d) | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.e(this.b);
                final C8899Xu4 c8899Xu4 = this.d;
                final String str2 = this.c;
                final int i2 = this.b;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.cv4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.C8911l.a.c(c8899Xu4, str2, i2, (AbstractC3769Cg6) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC14904ig6.o(abstractC3769Cg6, str, null, null, ua2, null, null, false, false, (UA2) objB2, interfaceC22053ub1, 0, 492);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        C8911l(InterfaceC9102Ym4 interfaceC9102Ym4, List list, String str) {
            this.b = interfaceC9102Ym4;
            this.c = list;
            this.d = str;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC22231ut.f(C8899Xu4.Ia(this.b) || ((long) i) < C8899Xu4.this.Ab().E1(), null, androidx.compose.animation.f.m(null, null, false, null, 15, null), androidx.compose.animation.f.y(null, null, false, null, 15, null), null, AbstractC19242q11.e(357796644, true, new a(this.c, i, this.d, C8899Xu4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 200064, 18);
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$m, reason: case insensitive filesystem */
    static final class C8912m implements InterfaceC15796kB2 {
        final /* synthetic */ List a;
        final /* synthetic */ C8899Xu4 b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        C8912m(List list, C8899Xu4 c8899Xu4, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = list;
            this.b = c8899Xu4;
            this.c = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8899Xu4 c8899Xu4, List list, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(list, "$globalBot");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isGlobalBotsExpanded$delegate");
            c8899Xu4.Ab().m2("global_search_show_more_click", AbstractC20051rO3.n(AbstractC4616Fw7.a("mode", C8899Xu4.Ka(interfaceC9102Ym4) ? "less" : "more"), AbstractC4616Fw7.a("initial_size", Integer.valueOf(list.size())), AbstractC4616Fw7.a("category_id", 4)));
            C8899Xu4.La(interfaceC9102Ym4, !C8899Xu4.Ka(interfaceC9102Ym4));
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (this.a.size() <= this.b.Ab().E1()) {
                interfaceC22053ub1.W(-520414600);
                this.b.ra(UY6.c(AbstractC12217eE5.global_search_bot, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(-521509923);
            C8899Xu4 c8899Xu4 = this.b;
            String strC = UY6.c(AbstractC12217eE5.global_search_bot, interfaceC22053ub1, 0);
            Boolean boolValueOf = Boolean.valueOf(C8899Xu4.Ka(this.c));
            interfaceC22053ub1.W(1922848658);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
            final C8899Xu4 c8899Xu42 = this.b;
            final List list = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.dv4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8899Xu4.C8912m.c(c8899Xu42, list, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            c8899Xu4.Za(strC, boolValueOf, (SA2) objB, interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$n, reason: case insensitive filesystem */
    static final class C8913n implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC9102Ym4 b;
        final /* synthetic */ List c;
        final /* synthetic */ String d;

        /* renamed from: ir.nasim.Xu4$n$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ List a;
            final /* synthetic */ int b;
            final /* synthetic */ String c;
            final /* synthetic */ C8899Xu4 d;

            a(List list, int i, String str, C8899Xu4 c8899Xu4) {
                this.a = list;
                this.b = i;
                this.c = str;
                this.d = c8899Xu4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(C8899Xu4 c8899Xu4, C11458d25 c11458d25) {
                AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
                AbstractC13042fc3.i(c11458d25, "peer");
                c8899Xu4.Kb(c11458d25);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(C8899Xu4 c8899Xu4, C11458d25 c11458d25) {
                AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
                AbstractC13042fc3.i(c11458d25, "peer");
                c8899Xu4.Nb(c11458d25);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(C8899Xu4 c8899Xu4, AbstractC3769Cg6 abstractC3769Cg6) {
                AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
                AbstractC13042fc3.i(abstractC3769Cg6, "it");
                c8899Xu4.Cb();
                c8899Xu4.Ab().v1(abstractC3769Cg6.d());
                C18987pb3.x1(C18987pb3.a, abstractC3769Cg6.d(), null, null, false, null, null, false, null, null, false, null, 2046, null);
                return C19938rB7.a;
            }

            public final void d(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
                AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(this.b);
                String str = this.c;
                interfaceC22053ub1.W(-118575846);
                boolean zD = interfaceC22053ub1.D(this.d);
                final C8899Xu4 c8899Xu4 = this.d;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.ev4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.C8913n.a.f(c8899Xu4, (C11458d25) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-118569677);
                boolean zD2 = interfaceC22053ub1.D(this.d);
                final C8899Xu4 c8899Xu42 = this.d;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.fv4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.C8913n.a.h(c8899Xu42, (C11458d25) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-118564290);
                boolean zD3 = interfaceC22053ub1.D(this.d);
                final C8899Xu4 c8899Xu43 = this.d;
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.gv4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.C8913n.a.i(c8899Xu43, (AbstractC3769Cg6) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC14904ig6.o(abstractC3769Cg6, str, null, null, null, ua2, ua22, false, false, (UA2) objB3, interfaceC22053ub1, 0, 412);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                d((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        C8913n(InterfaceC9102Ym4 interfaceC9102Ym4, List list, String str) {
            this.b = interfaceC9102Ym4;
            this.c = list;
            this.d = str;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC22231ut.f(C8899Xu4.Ka(this.b) || ((long) i) < C8899Xu4.this.Ab().E1(), null, androidx.compose.animation.f.m(null, null, false, null, 15, null), androidx.compose.animation.f.y(null, null, false, null, 15, null), null, AbstractC19242q11.e(-610164285, true, new a(this.c, i, this.d, C8899Xu4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 200064, 18);
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$o, reason: case insensitive filesystem */
    static final class C8914o implements InterfaceC15796kB2 {
        C8914o() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C8899Xu4.this.ra(UY6.c(AbstractC12217eE5.global_search_private, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$p, reason: case insensitive filesystem */
    static final class C8915p implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ String b;
        final /* synthetic */ C8899Xu4 c;

        C8915p(List list, String str, C8899Xu4 c8899Xu4) {
            this.a = list;
            this.b = str;
            this.c = c8899Xu4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8899Xu4 c8899Xu4, String str, int i, AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            c8899Xu4.Ab().m2("chat_search", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", 2), AbstractC4616Fw7.a("peer_type", Integer.valueOf(abstractC3769Cg6.d().s().ordinal() + 1)), AbstractC4616Fw7.a("peer_id", Integer.valueOf(abstractC3769Cg6.d().getPeerId())), AbstractC4616Fw7.a("query_text", str == null ? "" : str), AbstractC4616Fw7.a("event_type", "jostojuye sarsari goorooh"), AbstractC4616Fw7.a("index", Integer.valueOf(i))));
            c8899Xu4.Cb();
            c8899Xu4.Ab().v1(abstractC3769Cg6.d());
            C18987pb3.x1(C18987pb3.a, abstractC3769Cg6.d(), null, null, false, null, null, false, null, null, false, null, 2046, null);
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, final int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
            } else {
                i3 = i2;
            }
            if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(i);
            String str = this.b;
            interfaceC22053ub1.W(1922956022);
            boolean zD = ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1.D(this.c) | interfaceC22053ub1.V(this.b);
            final C8899Xu4 c8899Xu4 = this.c;
            final String str2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.hv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.C8915p.c(c8899Xu4, str2, i, (AbstractC3769Cg6) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC14904ig6.o(abstractC3769Cg6, str, null, null, null, null, null, false, false, (UA2) objB, interfaceC22053ub1, 0, 508);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$q, reason: case insensitive filesystem */
    static final class C8916q implements InterfaceC15796kB2 {
        C8916q() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C8899Xu4.this.ra(UY6.c(AbstractC12217eE5.global_search_group, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$r, reason: case insensitive filesystem */
    static final class C8917r implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ String b;
        final /* synthetic */ C8899Xu4 c;

        /* renamed from: ir.nasim.Xu4$r$a */
        /* synthetic */ class a extends C23553x7 implements UA2 {
            a(Object obj) {
                super(1, obj, C10020aw4.class, "joinPublicGroup", "joinPublicGroup(Lir/nasim/core/modules/profile/entity/Peer;Z)Lkotlinx/coroutines/Job;", 8);
            }

            public final void a(C11458d25 c11458d25) {
                AbstractC13042fc3.i(c11458d25, "p0");
                C10020aw4.W1((C10020aw4) this.a, c11458d25, false, 2, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C11458d25) obj);
                return C19938rB7.a;
            }
        }

        C8917r(List list, String str, C8899Xu4 c8899Xu4) {
            this.a = list;
            this.b = str;
            this.c = c8899Xu4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8899Xu4 c8899Xu4, String str, int i, AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            C10020aw4 c10020aw4Ab = c8899Xu4.Ab();
            XV4 xv4A = AbstractC4616Fw7.a("action_type", 2);
            XV4 xv4A2 = AbstractC4616Fw7.a("peer_type", Integer.valueOf(abstractC3769Cg6.d().s().ordinal() + 1));
            XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(abstractC3769Cg6.d().getPeerId()));
            if (str == null) {
                str = "";
            }
            c10020aw4Ab.m2("chat_search", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a("query_text", str), AbstractC4616Fw7.a("event_type", "jostojuye sarsari goorooh"), AbstractC4616Fw7.a("index", Integer.valueOf(i))));
            c8899Xu4.Cb();
            c8899Xu4.Ab().v1(abstractC3769Cg6.d());
            C18987pb3.a.y1(abstractC3769Cg6.d(), null, null, false, "search");
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, final int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
            } else {
                i3 = i2;
            }
            if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(i);
            String str = this.b;
            C10020aw4 c10020aw4Ab = this.c.Ab();
            interfaceC22053ub1.W(1923019638);
            boolean zD = interfaceC22053ub1.D(c10020aw4Ab);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c10020aw4Ab);
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1923023048);
            boolean zD2 = ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1.D(this.c) | interfaceC22053ub1.V(this.b);
            final C8899Xu4 c8899Xu4 = this.c;
            final String str2 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.iv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.C8917r.c(c8899Xu4, str2, i, (AbstractC3769Cg6) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC14904ig6.o(abstractC3769Cg6, str, null, null, ua2, null, null, false, false, (UA2) objB2, interfaceC22053ub1, 0, 492);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$s, reason: case insensitive filesystem */
    static final class C8918s implements InterfaceC15796kB2 {
        C8918s() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C8899Xu4.this.ra(UY6.c(AbstractC12217eE5.global_search_channel, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$t, reason: case insensitive filesystem */
    static final class C8919t implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ String b;
        final /* synthetic */ C8899Xu4 c;

        /* renamed from: ir.nasim.Xu4$t$a */
        /* synthetic */ class a extends C23553x7 implements UA2 {
            a(Object obj) {
                super(1, obj, C10020aw4.class, "joinPublicGroup", "joinPublicGroup(Lir/nasim/core/modules/profile/entity/Peer;Z)Lkotlinx/coroutines/Job;", 8);
            }

            public final void a(C11458d25 c11458d25) {
                AbstractC13042fc3.i(c11458d25, "p0");
                C10020aw4.W1((C10020aw4) this.a, c11458d25, false, 2, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C11458d25) obj);
                return C19938rB7.a;
            }
        }

        C8919t(List list, String str, C8899Xu4 c8899Xu4) {
            this.a = list;
            this.b = str;
            this.c = c8899Xu4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8899Xu4 c8899Xu4, String str, int i, AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            C10020aw4 c10020aw4Ab = c8899Xu4.Ab();
            XV4 xv4A = AbstractC4616Fw7.a("action_type", 2);
            XV4 xv4A2 = AbstractC4616Fw7.a("peer_type", Integer.valueOf(abstractC3769Cg6.d().s().ordinal() + 1));
            XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(abstractC3769Cg6.d().getPeerId()));
            if (str == null) {
                str = "";
            }
            c10020aw4Ab.m2("chat_search", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a("query_text", str), AbstractC4616Fw7.a("event_type", "jostojuye sarsari kanal"), AbstractC4616Fw7.a("index", Integer.valueOf(i + 1))));
            c8899Xu4.Cb();
            c8899Xu4.Ab().v1(abstractC3769Cg6.d());
            C18987pb3.a.y1(abstractC3769Cg6.d(), null, null, false, "search");
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, final int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
            } else {
                i3 = i2;
            }
            if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(i);
            String str = this.b;
            C10020aw4 c10020aw4Ab = this.c.Ab();
            interfaceC22053ub1.W(1923096566);
            boolean zD = interfaceC22053ub1.D(c10020aw4Ab);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c10020aw4Ab);
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1923099982);
            boolean zD2 = ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1.D(this.c) | interfaceC22053ub1.V(this.b);
            final C8899Xu4 c8899Xu4 = this.c;
            final String str2 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.jv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.C8919t.c(c8899Xu4, str2, i, (AbstractC3769Cg6) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC14904ig6.o(abstractC3769Cg6, str, null, null, ua2, null, null, false, false, (UA2) objB2, interfaceC22053ub1, 0, 492);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$u */
    static final class u implements InterfaceC15796kB2 {
        u() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C8899Xu4.this.ra(UY6.c(AbstractC12217eE5.search_chats, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$v */
    static final class v implements InterfaceC15796kB2 {
        v() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C8899Xu4.this.ra(UY6.c(AbstractC12217eE5.global_search_bot, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$w */
    static final class w implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ String b;
        final /* synthetic */ C8899Xu4 c;

        w(List list, String str, C8899Xu4 c8899Xu4) {
            this.a = list;
            this.b = str;
            this.c = c8899Xu4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C8899Xu4 c8899Xu4, C11458d25 c11458d25) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(c11458d25, "peer");
            c8899Xu4.Kb(c11458d25);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(C8899Xu4 c8899Xu4, C11458d25 c11458d25) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(c11458d25, "peer");
            c8899Xu4.Nb(c11458d25);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C8899Xu4 c8899Xu4, AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            c8899Xu4.Cb();
            c8899Xu4.Ab().v1(abstractC3769Cg6.d());
            C18987pb3.x1(C18987pb3.a, abstractC3769Cg6.d(), null, null, false, null, null, false, null, null, false, null, 2046, null);
            return C19938rB7.a;
        }

        public final void d(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
            } else {
                i3 = i2;
            }
            if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(i);
            String str = this.b;
            interfaceC22053ub1.W(1923169395);
            boolean zD = interfaceC22053ub1.D(this.c);
            final C8899Xu4 c8899Xu4 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.kv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.w.f(c8899Xu4, (C11458d25) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1923175180);
            boolean zD2 = interfaceC22053ub1.D(this.c);
            final C8899Xu4 c8899Xu42 = this.c;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.lv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.w.h(c8899Xu42, (C11458d25) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            UA2 ua22 = (UA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1923180175);
            boolean zD3 = interfaceC22053ub1.D(this.c);
            final C8899Xu4 c8899Xu43 = this.c;
            Object objB3 = interfaceC22053ub1.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.mv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.w.i(c8899Xu43, (AbstractC3769Cg6) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC14904ig6.o(abstractC3769Cg6, str, null, null, null, ua2, ua22, false, false, (UA2) objB3, interfaceC22053ub1, 0, 412);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            d((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$x */
    static final class x implements InterfaceC15796kB2 {
        x() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C8899Xu4.this.ra(UY6.c(AbstractC12217eE5.mxp_search_result_header, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$y */
    static final class y implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ String b;
        final /* synthetic */ C8899Xu4 c;

        y(List list, String str, C8899Xu4 c8899Xu4) {
            this.a = list;
            this.b = str;
            this.c = c8899Xu4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8899Xu4 c8899Xu4, AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.j) {
                c8899Xu4.Lb(((AbstractC3769Cg6.j) abstractC3769Cg6).f());
            }
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i3 & 147) == 146 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.get(i);
            String str = this.b;
            androidx.compose.ui.e eVarD = InterfaceC6988Pv3.d(interfaceC6988Pv3, androidx.compose.ui.e.a, null, null, null, 2, null);
            interfaceC22053ub1.W(-840719832);
            boolean zD = interfaceC22053ub1.D(this.c);
            final C8899Xu4 c8899Xu4 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.nv4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.y.c(c8899Xu4, (AbstractC3769Cg6) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC14904ig6.o(abstractC3769Cg6, str, eVarD, null, null, null, null, false, false, (UA2) objB, interfaceC22053ub1, 0, 504);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xu4$z */
    static final class z implements InterfaceC16978mB2 {
        final /* synthetic */ C20996sx3 a;
        final /* synthetic */ C8899Xu4 b;
        final /* synthetic */ String c;

        z(C20996sx3 c20996sx3, C8899Xu4 c8899Xu4, String str) {
            this.a = c20996sx3;
            this.b = c8899Xu4;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8899Xu4 c8899Xu4, String str, int i, AbstractC3769Cg6 abstractC3769Cg6) {
            AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
            AbstractC13042fc3.i(abstractC3769Cg6, "it");
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.i) {
                AbstractC3769Cg6.i iVar = (AbstractC3769Cg6.i) abstractC3769Cg6;
                c8899Xu4.Ab().m2("chat_search", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", 2), AbstractC4616Fw7.a("peer_type", Integer.valueOf(iVar.d().s().ordinal() + 1)), AbstractC4616Fw7.a("peer_id", Integer.valueOf(iVar.d().getPeerId())), AbstractC4616Fw7.a("query_text", str == null ? "" : str), AbstractC4616Fw7.a("event_type", DialogEntity.COLUMN_MESSAGE), AbstractC4616Fw7.a("index", Integer.valueOf(i))));
                c8899Xu4.Cb();
                c8899Xu4.Ab().v1(iVar.d());
                if (iVar.d().C()) {
                    C18987pb3.x1(C18987pb3.a, iVar.d(), Long.valueOf(iVar.h()), Long.valueOf(iVar.g()), true, null, null, false, null, null, false, null, 2032, null);
                } else {
                    C18987pb3.a.y1(iVar.d(), Long.valueOf(iVar.h()), Long.valueOf(iVar.g()), true, "search");
                }
            }
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, final int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
            } else {
                i3 = i2;
            }
            if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) this.a.f(i);
            if (abstractC3769Cg6 == null) {
                return;
            }
            final C8899Xu4 c8899Xu4 = this.b;
            final String str = this.c;
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.d) {
                return;
            }
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.h) {
                interfaceC22053ub1.W(-509476870);
                c8899Xu4.ra(UY6.c(((AbstractC3769Cg6.h) abstractC3769Cg6).f(), interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(-509304231);
            interfaceC22053ub1.W(1923239066);
            boolean zD = interfaceC22053ub1.D(c8899Xu4) | interfaceC22053ub1.V(str) | ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.ov4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.z.c(c8899Xu4, str, i, (AbstractC3769Cg6) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC14904ig6.o(abstractC3769Cg6, str, null, null, null, null, null, false, false, (UA2) objB, interfaceC22053ub1, 0, 508);
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public C8899Xu4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new P(new O(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C10020aw4.class), new Q(interfaceC9173Yu3B), new R(null, interfaceC9173Yu3B), new S(this, interfaceC9173Yu3B));
    }

    private static final List Aa(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10020aw4 Ab() {
        return (C10020aw4) this.viewModel.getValue();
    }

    private static final List Ba(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ca(C8899Xu4 c8899Xu4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(c8899Xu4, "this$0");
        AbstractC13042fc3.i(interfaceC9664aL6, "$topPeers$delegate");
        AbstractC13042fc3.i(interfaceC9664aL62, "$recentSearch$delegate");
        AbstractC13042fc3.i(interfaceC9664aL63, "$recommendedGroup$delegate");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, J61.a.a(), 3, null);
        if (C8386Vt0.Lb() && (!za(interfaceC9664aL6).isEmpty())) {
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(122302325, true, c8899Xu4.new C8902c(interfaceC9664aL6)), 3, null);
        }
        if (!Aa(interfaceC9664aL62).isEmpty()) {
            c8899Xu4.Ob(interfaceC15069ix3, Aa(interfaceC9664aL62));
        }
        if (C8386Vt0.a.L9()) {
            c8899Xu4.Ub(interfaceC15069ix3);
            if (!Ba(interfaceC9664aL63).isEmpty()) {
                c8899Xu4.Qb(interfaceC15069ix3, Ba(interfaceC9664aL63));
            }
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Cb() {
        C23381wp3.f(yb().getRoot());
    }

    private final void Da(final C8899Xu4 c8899Xu4, final C20996sx3 c20996sx3, final String str, final Map map, final C20996sx3 c20996sx32, final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1953240891);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c8899Xu4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(c20996sx3) : interfaceC22053ub1J.D(c20996sx3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(map) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (i & 32768) == 0 ? interfaceC22053ub1J.V(c20996sx32) : interfaceC22053ub1J.D(c20996sx32) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(list) ? 131072 : 65536;
        }
        if ((74899 & i2) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub1J.W(-216878794);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-216875818);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB2);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-216872778);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB3);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym43 = (InterfaceC9102Ym4) objB3;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-216869866);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar.a()) {
                objB4 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB4);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym44 = (InterfaceC9102Ym4) objB4;
            interfaceC22053ub1J.Q();
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1J.W(-216867105);
            boolean zD = interfaceC22053ub1J.D(c8899Xu4);
            Object objB5 = interfaceC22053ub1J.B();
            if (zD || objB5 == aVar.a()) {
                objB5 = c8899Xu4.new C8909j(null);
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB5, interfaceC22053ub1J, 6);
            boolean z2 = true;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            interfaceC22053ub1J.W(-216825983);
            boolean zD2 = interfaceC22053ub1J.D(c8899Xu4) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32 || ((i2 & 64) != 0 && interfaceC22053ub1J.D(c20996sx3))) | ((i2 & 896) == 256) | interfaceC22053ub1J.D(map) | interfaceC22053ub1J.D(list);
            if ((57344 & i2) != 16384 && ((i2 & 32768) == 0 || !interfaceC22053ub1J.D(c20996sx32))) {
                z2 = false;
            }
            boolean z3 = zD2 | z2;
            Object objB6 = interfaceC22053ub1J.B();
            if (z3 || objB6 == aVar.a()) {
                interfaceC22053ub12 = interfaceC22053ub1J;
                UA2 ua2 = new UA2() { // from class: ir.nasim.Uu4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.Ma(this.a, c20996sx3, map, list, c20996sx32, str, interfaceC9102Ym4, interfaceC9102Ym42, interfaceC9102Ym43, interfaceC9102Ym44, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub12.s(ua2);
                objB6 = ua2;
            } else {
                interfaceC22053ub12 = interfaceC22053ub1J;
            }
            interfaceC22053ub12.Q();
            AbstractC12623ev3.b(eVarF, null, null, false, null, null, null, false, null, (UA2) objB6, interfaceC22053ub12, 6, 510);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Vu4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C8899Xu4.Ya(this.a, c8899Xu4, c20996sx3, str, map, c20996sx32, list, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private final void Db() {
        yb().c.g();
        ComposeView composeView = yb().c;
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(458402631, true, new G()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ea(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private final boolean Eb(C20996sx3 c20996sx3) {
        return c20996sx3.i().d() instanceof AbstractC13460gG3.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z2) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z2));
    }

    private final boolean Fb(C20996sx3 localSearch, C20996sx3 messageSearch, List searchMxp, Map remotePeerSearch) {
        return Hb(localSearch) && Hb(messageSearch) && searchMxp != null && searchMxp.isEmpty() && remotePeerSearch != null && remotePeerSearch.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ga(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private final boolean Gb(C20996sx3 localSearch, C20996sx3 messageSearch, List searchMxp, Map remotePeerSearch) {
        return Ib(localSearch) || !(!Eb(messageSearch) || searchMxp == null || remotePeerSearch == null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z2) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z2));
    }

    private final boolean Hb(C20996sx3 c20996sx3) {
        return (c20996sx3.i().d() instanceof AbstractC13460gG3.c) && c20996sx3.i().a().a() && c20996sx3.g() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ia(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private final boolean Ib(C20996sx3 c20996sx3) {
        return (c20996sx3.i().d() instanceof AbstractC13460gG3.c) && c20996sx3.g() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z2) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z2));
    }

    public static final C8899Xu4 Jb(String str) {
        return INSTANCE.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ka(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kb(C11458d25 peer) {
        C22042ua0.A9(this, InterfaceC11677dQ0.b(zb(), peer, ExPeerType.BOT, null, null, false, null, null, null, null, 0L, null, null, "", false, null, null, null, null, null, false, null, null, null, null, null, false, null, 134213628, null), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z2) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lb(PuppetGroup puppetGroup) {
        C19100pm6 c19100pm6A = C19100pm6.s1.a(puppetGroup);
        c19100pm6A.Z8(new UA2() { // from class: ir.nasim.Ou4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8899Xu4.Mb(this.a, (PuppetUser) obj);
            }
        });
        c19100pm6A.L8(V5(), "mxpContactBottomSheet-globalSearch");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ma(C8899Xu4 c8899Xu4, final C20996sx3 c20996sx3, Map map, final List list, C20996sx3 c20996sx32, String str, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, InterfaceC9102Ym4 interfaceC9102Ym44, InterfaceC15069ix3 interfaceC15069ix3) {
        boolean z2;
        AbstractC13042fc3.i(c8899Xu4, "$this_SearchList");
        AbstractC13042fc3.i(c20996sx3, "$localSearch");
        AbstractC13042fc3.i(c20996sx32, "$messageSearch");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isGlobalPrivatesExpanded$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym42, "$isGlobalGroupsExpanded$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym43, "$isGlobalChannelsExpanded$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym44, "$isGlobalBotsExpanded$delegate");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        if (c8899Xu4.Ib(c20996sx3)) {
            if (C8386Vt0.J8()) {
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-2025437542, true, c8899Xu4.new u()), 3, null);
                InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), new UA2() { // from class: ir.nasim.Cu4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.Na(c20996sx3, ((Integer) obj).intValue());
                    }
                }, null, AbstractC19242q11.c(-150511695, true, new A(c20996sx3, c8899Xu4, str)), 4, null);
            } else {
                InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), new UA2() { // from class: ir.nasim.Eu4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.Oa(c20996sx3, ((Integer) obj).intValue());
                    }
                }, null, AbstractC19242q11.c(1912968776, true, new B(c20996sx3, c8899Xu4, str)), 4, null);
            }
        }
        if (map == null || list == null || !c8899Xu4.Eb(c20996sx32)) {
            c8899Xu4.Sb(interfaceC15069ix3, 10);
        } else {
            if (C8386Vt0.J8()) {
                ExPeerType exPeerType = ExPeerType.PRIVATE;
                if (map.containsKey(exPeerType)) {
                    Object objL = AbstractC20051rO3.l(map, exPeerType);
                    if (!(!((List) objL).isEmpty())) {
                        objL = null;
                    }
                    final List list2 = (List) objL;
                    if (list2 != null) {
                        z2 = true;
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(511084731, true, new C(list2, c8899Xu4, interfaceC9102Ym4)), 3, null);
                        InterfaceC15069ix3.g(interfaceC15069ix3, list2.size(), new UA2() { // from class: ir.nasim.Fu4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8899Xu4.Pa(list2, ((Integer) obj).intValue());
                            }
                        }, null, AbstractC19242q11.c(-1901221692, true, c8899Xu4.new D(interfaceC9102Ym4, list2, str)), 4, null);
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = true;
                }
                ExPeerType exPeerType2 = ExPeerType.GROUP;
                if (map.containsKey(exPeerType2)) {
                    Object objL2 = AbstractC20051rO3.l(map, exPeerType2);
                    if (!(((List) objL2).isEmpty() ^ z2)) {
                        objL2 = null;
                    }
                    final List list3 = (List) objL2;
                    if (list3 != null) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-981935132, z2, new E(list3, c8899Xu4, interfaceC9102Ym42)), 3, null);
                        InterfaceC15069ix3.g(interfaceC15069ix3, list3.size(), new UA2() { // from class: ir.nasim.Gu4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8899Xu4.Qa(list3, ((Integer) obj).intValue());
                            }
                        }, null, AbstractC19242q11.c(73932205, z2, c8899Xu4.new F(interfaceC9102Ym42, list3, str)), 4, null);
                    }
                }
                ExPeerType exPeerType3 = ExPeerType.CHANNEL;
                if (map.containsKey(exPeerType3)) {
                    Object objL3 = AbstractC20051rO3.l(map, exPeerType3);
                    if (!(((List) objL3).isEmpty() ^ z2)) {
                        objL3 = null;
                    }
                    final List list4 = (List) objL3;
                    if (list4 != null) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1949896061, z2, new C8910k(list4, c8899Xu4, interfaceC9102Ym43)), 3, null);
                        InterfaceC15069ix3.g(interfaceC15069ix3, list4.size(), new UA2() { // from class: ir.nasim.Hu4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8899Xu4.Ra(list4, ((Integer) obj).intValue());
                            }
                        }, null, AbstractC19242q11.c(-894028724, z2, c8899Xu4.new C8911l(interfaceC9102Ym43, list4, str)), 4, null);
                    }
                }
                ExPeerType exPeerType4 = ExPeerType.BOT;
                if (map.containsKey(exPeerType4)) {
                    Object objL4 = AbstractC20051rO3.l(map, exPeerType4);
                    final List list5 = (List) (((List) objL4).isEmpty() ^ z2 ? objL4 : null);
                    if (list5 != null) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1377110306, z2, new C8912m(list5, c8899Xu4, interfaceC9102Ym44)), 3, null);
                        InterfaceC15069ix3.g(interfaceC15069ix3, list5.size(), new UA2() { // from class: ir.nasim.Iu4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8899Xu4.Sa(list5, ((Integer) obj).intValue());
                            }
                        }, null, AbstractC19242q11.c(-1861989653, z2, c8899Xu4.new C8913n(interfaceC9102Ym44, list5, str)), 4, null);
                    }
                }
            } else {
                z2 = true;
                ExPeerType exPeerType5 = ExPeerType.PRIVATE;
                if (map.containsKey(exPeerType5)) {
                    Object objL5 = AbstractC20051rO3.l(map, exPeerType5);
                    if (!(!((List) objL5).isEmpty())) {
                        objL5 = null;
                    }
                    final List list6 = (List) objL5;
                    if (list6 != null) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1293015506, true, c8899Xu4.new C8914o()), 3, null);
                        InterfaceC15069ix3.g(interfaceC15069ix3, list6.size(), new UA2() { // from class: ir.nasim.Ju4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8899Xu4.Ta(list6, ((Integer) obj).intValue());
                            }
                        }, null, AbstractC19242q11.c(-814520293, true, new C8915p(list6, str, c8899Xu4)), 4, null);
                    }
                }
                ExPeerType exPeerType6 = ExPeerType.GROUP;
                if (map.containsKey(exPeerType6)) {
                    Object objL6 = AbstractC20051rO3.l(map, exPeerType6);
                    if (!(!((List) objL6).isEmpty())) {
                        objL6 = null;
                    }
                    final List list7 = (List) objL6;
                    if (list7 != null) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(531686203, true, c8899Xu4.new C8916q()), 3, null);
                        InterfaceC15069ix3.g(interfaceC15069ix3, list7.size(), new UA2() { // from class: ir.nasim.Ku4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8899Xu4.Ua(list7, ((Integer) obj).intValue());
                            }
                        }, null, AbstractC19242q11.c(-1880620220, true, new C8917r(list7, str, c8899Xu4)), 4, null);
                    }
                }
                ExPeerType exPeerType7 = ExPeerType.CHANNEL;
                if (map.containsKey(exPeerType7)) {
                    Object objL7 = AbstractC20051rO3.l(map, exPeerType7);
                    if (!(!((List) objL7).isEmpty())) {
                        objL7 = null;
                    }
                    final List list8 = (List) objL7;
                    if (list8 != null) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(360846746, true, c8899Xu4.new C8918s()), 3, null);
                        InterfaceC15069ix3.g(interfaceC15069ix3, list8.size(), new UA2() { // from class: ir.nasim.Mu4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8899Xu4.Va(list8, ((Integer) obj).intValue());
                            }
                        }, null, AbstractC19242q11.c(-2051459677, true, new C8919t(list8, str, c8899Xu4)), 4, null);
                    }
                }
                ExPeerType exPeerType8 = ExPeerType.BOT;
                if (map.containsKey(exPeerType8)) {
                    Object objL8 = AbstractC20051rO3.l(map, exPeerType8);
                    final List list9 = (List) (((List) objL8).isEmpty() ^ true ? objL8 : null);
                    if (list9 != null) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(190007289, true, c8899Xu4.new v()), 3, null);
                        InterfaceC15069ix3.g(interfaceC15069ix3, list9.size(), new UA2() { // from class: ir.nasim.Nu4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8899Xu4.Wa(list9, ((Integer) obj).intValue());
                            }
                        }, null, AbstractC19242q11.c(2072668162, true, new w(list9, str, c8899Xu4)), 4, null);
                    }
                }
            }
            if (list.isEmpty() ^ z2) {
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1110947116, z2, c8899Xu4.new x()), 3, null);
                InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), new UA2() { // from class: ir.nasim.Du4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8899Xu4.Xa(list, ((Integer) obj).intValue());
                    }
                }, null, AbstractC19242q11.c(1258842819, z2, new y(list, str, c8899Xu4)), 4, null);
            }
            InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx32.g(), null, null, AbstractC19242q11.c(463817301, z2, new z(c20996sx32, c8899Xu4, str)), 6, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Mb(C8899Xu4 c8899Xu4, PuppetUser puppetUser) {
        AbstractC13042fc3.i(c8899Xu4, "this$0");
        AbstractC13042fc3.i(puppetUser, "it");
        c8899Xu4.Q7().onBackPressed();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Na(C20996sx3 c20996sx3, int i) {
        String str;
        AbstractC13042fc3.i(c20996sx3, "$localSearch");
        AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) c20996sx3.f(i);
        if (abstractC3769Cg6 != null) {
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.h) {
                AbstractC3769Cg6.h hVar = (AbstractC3769Cg6.h) abstractC3769Cg6;
                str = hVar.f() + Separators.SP + hVar.d().u() + " H " + i;
            } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.d) {
                str = AbstractC17026mG5.a.k() + " L S NULL";
            } else {
                str = abstractC3769Cg6.d().u() + " L " + i;
            }
            if (str != null) {
                return str;
            }
        }
        return AbstractC17026mG5.a.k() + " L S NULL";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nb(C11458d25 peer) {
        C22042ua0.w9(this, Bb().a(new WebAppArguments(peer.getPeerId(), new WebAppType.Main(null), H48.i, AbstractC17026mG5.a.f(), null, null, null, false, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null)), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Oa(C20996sx3 c20996sx3, int i) {
        String str;
        AbstractC13042fc3.i(c20996sx3, "$localSearch");
        AbstractC3769Cg6 abstractC3769Cg6 = (AbstractC3769Cg6) c20996sx3.f(i);
        if (abstractC3769Cg6 != null) {
            if (abstractC3769Cg6 instanceof AbstractC3769Cg6.h) {
                AbstractC3769Cg6.h hVar = (AbstractC3769Cg6.h) abstractC3769Cg6;
                str = hVar.f() + Separators.SP + hVar.d().u() + " H " + i;
            } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.d) {
                str = AbstractC17026mG5.a.k() + " L S NULL";
            } else {
                str = abstractC3769Cg6.d().u() + " L " + i;
            }
            if (str != null) {
                return str;
            }
        }
        return AbstractC17026mG5.a.k() + " L S NULL";
    }

    private final void Ob(InterfaceC15069ix3 interfaceC15069ix3, final List list) {
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(42655364, true, new I()), 3, null);
        InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), new UA2() { // from class: ir.nasim.Wu4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8899Xu4.Pb(list, ((Integer) obj).intValue());
            }
        }, null, AbstractC19242q11.c(674130893, true, new J(list, this)), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Pa(List list, int i) {
        AbstractC13042fc3.i(list, "$globalGroup");
        return ((AbstractC3769Cg6) list.get(i)).d().u() + " R P";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Pb(List list, int i) {
        AbstractC13042fc3.i(list, "$recentSearch");
        if ((list.get(i) instanceof AbstractC3769Cg6.h) || (list.get(i) instanceof AbstractC3769Cg6.d)) {
            return AbstractC17026mG5.a.k() + " recentSearch Header";
        }
        return ((AbstractC3769Cg6) list.get(i)).e() + " + " + ((AbstractC3769Cg6) list.get(i)).d().u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Qa(List list, int i) {
        AbstractC13042fc3.i(list, "$globalGroup");
        return ((AbstractC3769Cg6) list.get(i)).d().u() + " R G";
    }

    private final void Qb(InterfaceC15069ix3 interfaceC15069ix3, List list) {
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1752138461, true, new K()), 3, null);
        InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), null, null, AbstractC19242q11.c(-89506324, true, new L(list)), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Ra(List list, int i) {
        AbstractC13042fc3.i(list, "$globalChannel");
        return ((AbstractC3769Cg6) list.get(i)).d().u() + " R C";
    }

    private final void Rb(long durationTime) {
        if (durationTime > 0) {
            Ab().m2("chat_search_duration", AbstractC19460qO3.g(AbstractC4616Fw7.a("duration_seconds", Long.valueOf(durationTime))));
            this.startTime = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Sa(List list, int i) {
        AbstractC13042fc3.i(list, "$globalBot");
        return ((AbstractC3769Cg6) list.get(i)).d().u() + " R B";
    }

    private final void Sb(InterfaceC15069ix3 interfaceC15069ix3, int i) {
        J61 j61 = J61.a;
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, j61.b(), 3, null);
        InterfaceC15069ix3.g(interfaceC15069ix3, i, null, null, j61.c(), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Ta(List list, int i) {
        AbstractC13042fc3.i(list, "$globalGroup");
        return ((AbstractC3769Cg6) list.get(i)).d().u() + " R P";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Tb(int titleResourceId, int descriptionResourceId, int yesResId, String[] formatArgs, SA2 onInfoClickListener) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1604039561, true, new M(yesResId, onInfoClickListener, titleResourceId, descriptionResourceId, formatArgs)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Ua(List list, int i) {
        AbstractC13042fc3.i(list, "$globalGroup");
        return ((AbstractC3769Cg6) list.get(i)).d().u() + " R G";
    }

    private final void Ub(InterfaceC15069ix3 interfaceC15069ix3) {
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-886279786, true, new T()), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Va(List list, int i) {
        AbstractC13042fc3.i(list, "$globalChannel");
        return ((AbstractC3769Cg6) list.get(i)).d().u() + " R C";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Wa(List list, int i) {
        AbstractC13042fc3.i(list, "$globalBot");
        return ((AbstractC3769Cg6) list.get(i)).d().u() + " R B";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Xa(List list, int i) {
        return ((AbstractC3769Cg6.j) list.get(i)).f() + " Mx";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ya(C8899Xu4 c8899Xu4, C8899Xu4 c8899Xu42, C20996sx3 c20996sx3, String str, Map map, C20996sx3 c20996sx32, List list, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c8899Xu4, "$tmp6_rcvr");
        AbstractC13042fc3.i(c8899Xu42, "$this_SearchList");
        AbstractC13042fc3.i(c20996sx3, "$localSearch");
        AbstractC13042fc3.i(c20996sx32, "$messageSearch");
        c8899Xu4.Da(c8899Xu42, c20996sx3, str, map, c20996sx32, list, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ab() {
        return C19938rB7.a;
    }

    private static final float bb(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 cb(SA2 sa2) {
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 db(C8899Xu4 c8899Xu4, String str, Boolean bool, SA2 sa2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c8899Xu4, "$tmp1_rcvr");
        c8899Xu4.Za(str, bool, sa2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private final void pa(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-574336624);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.b(), InterfaceC12529em.a.g(), interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1J.W(-221516092);
            boolean zD = interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new C8901b(null);
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 6);
            EV4 ev4C = FV4.c(KB5.not_results_found, interfaceC22053ub1J, 0);
            String strC = UY6.c(AbstractC12217eE5.market_search_no_result, interfaceC22053ub1J, 0);
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC24077y03.b(ev4C, strC, androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(48.0f)), g10.a(interfaceC22053ub1J, i3).B(), interfaceC22053ub1J, 384, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i3).b().j()), interfaceC22053ub1J, 0);
            AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.market_search_no_result, interfaceC22053ub1J, 0), null, g10.a(interfaceC22053ub1J, i3).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i3).l(), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Bu4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C8899Xu4.qa(this.a, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(C8899Xu4 c8899Xu4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c8899Xu4, "$tmp0_rcvr");
        c8899Xu4.pa(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra(final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1338666280);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(eVarH, g10.a(interfaceC22053ub1J, i3).y(), null, 2, null), g10.c(interfaceC22053ub1J, i3).b().c(), g10.c(interfaceC22053ub1J, i3).b().u());
            C9348Zn7 c9348Zn7O = g10.d(interfaceC22053ub1J, i3).o();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9339Zm7.b(str, eVarJ, g10.a(interfaceC22053ub1J, i3).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7O.b((16744447 & 1) != 0 ? c9348Zn7O.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7O.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7O.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7O.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7O.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7O.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7O.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7O.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7O.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7O.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7O.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7O.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7O.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7O.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7O.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7O.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7O.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7O.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7O.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7O.c : null, (16744447 & 1048576) != 0 ? c9348Zn7O.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7O.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7O.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7O.b.k() : null), interfaceC22053ub12, i2 & 14, 0, 65528);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Tu4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C8899Xu4.sa(this.a, str, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sa(C8899Xu4 c8899Xu4, String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c8899Xu4, "$tmp0_rcvr");
        AbstractC13042fc3.i(str, "$text");
        c8899Xu4.ra(str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(352046378);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(Ab().H1(), null, interfaceC22053ub1J, 0, 1);
            final InterfaceC9664aL6 interfaceC9664aL6B2 = AbstractC10222bH6.b(Ab().N1(), null, interfaceC22053ub1J, 0, 1);
            String strUa = ua(interfaceC9664aL6B);
            if (strUa == null || strUa.length() == 0) {
                interfaceC22053ub12 = interfaceC22053ub1J;
                interfaceC22053ub12.W(1733290866);
                InterfaceC10258bL6 interfaceC10258bL6P1 = Ab().P1();
                interfaceC22053ub12.W(-498277924);
                Object objB = interfaceC22053ub12.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = new C8905f(null);
                    interfaceC22053ub12.s(objB);
                }
                interfaceC22053ub12.Q();
                final InterfaceC9664aL6 interfaceC9664aL6A = AbstractC10222bH6.a(AbstractC6459Nq2.X(interfaceC10258bL6P1, (InterfaceC14603iB2) objB), AbstractC10360bX0.m(), null, interfaceC22053ub12, 48, 2);
                InterfaceC10258bL6 interfaceC10258bL6P12 = Ab().P1();
                interfaceC22053ub12.W(-498273285);
                Object objB2 = interfaceC22053ub12.B();
                if (objB2 == aVar.a()) {
                    objB2 = new C8906g(null);
                    interfaceC22053ub12.s(objB2);
                }
                interfaceC22053ub12.Q();
                final InterfaceC9664aL6 interfaceC9664aL6A2 = AbstractC10222bH6.a(AbstractC6459Nq2.X(interfaceC10258bL6P12, (InterfaceC14603iB2) objB2), AbstractC10360bX0.m(), null, interfaceC22053ub12, 48, 2);
                androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
                interfaceC22053ub12.W(-498263617);
                boolean zV = interfaceC22053ub12.V(interfaceC9664aL6B2) | interfaceC22053ub12.D(this) | interfaceC22053ub12.V(interfaceC9664aL6A) | interfaceC22053ub12.V(interfaceC9664aL6A2);
                Object objB3 = interfaceC22053ub12.B();
                if (zV || objB3 == aVar.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.Au4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8899Xu4.Ca(this.a, interfaceC9664aL6B2, interfaceC9664aL6A, interfaceC9664aL6A2, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub12.s(objB3);
                }
                interfaceC22053ub12.Q();
                AbstractC12623ev3.b(eVarF, null, null, false, null, null, null, false, null, (UA2) objB3, interfaceC22053ub12, 6, 510);
                interfaceC22053ub12.Q();
            } else {
                interfaceC22053ub1J.W(1736449487);
                C20996sx3 c20996sx3B = AbstractC21683tx3.b(Ab().F1(), null, interfaceC22053ub1J, 0, 1);
                C20996sx3 c20996sx3B2 = AbstractC21683tx3.b(Ab().G1(), null, interfaceC22053ub1J, 0, 1);
                InterfaceC10258bL6 interfaceC10258bL6P13 = Ab().P1();
                interfaceC22053ub1J.W(-498168799);
                Object objB4 = interfaceC22053ub1J.B();
                InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
                if (objB4 == aVar2.a()) {
                    objB4 = new C8907h(null);
                    interfaceC22053ub1J.s(objB4);
                }
                interfaceC22053ub1J.Q();
                InterfaceC9664aL6 interfaceC9664aL6A3 = AbstractC10222bH6.a(AbstractC6459Nq2.X(interfaceC10258bL6P13, (InterfaceC14603iB2) objB4), null, null, interfaceC22053ub1J, 48, 2);
                Map mapVa = va(interfaceC9664aL6A3);
                interfaceC22053ub1J.W(-498164493);
                boolean zV2 = interfaceC22053ub1J.V(interfaceC9664aL6A3) | interfaceC22053ub1J.V(interfaceC9664aL6B) | interfaceC22053ub1J.D(this);
                Object objB5 = interfaceC22053ub1J.B();
                if (zV2 || objB5 == aVar2.a()) {
                    objB5 = new C8903d(interfaceC9664aL6A3, this, interfaceC9664aL6B, null);
                    interfaceC22053ub1J.s(objB5);
                }
                interfaceC22053ub1J.Q();
                AbstractC10721c52.e(mapVa, (InterfaceC14603iB2) objB5, interfaceC22053ub1J, 0);
                InterfaceC10258bL6 interfaceC10258bL6P14 = Ab().P1();
                interfaceC22053ub1J.W(-498140738);
                Object objB6 = interfaceC22053ub1J.B();
                if (objB6 == aVar2.a()) {
                    objB6 = new C8908i(null);
                    interfaceC22053ub1J.s(objB6);
                }
                interfaceC22053ub1J.Q();
                InterfaceC9664aL6 interfaceC9664aL6A4 = AbstractC10222bH6.a(AbstractC6459Nq2.X(interfaceC10258bL6P14, (InterfaceC14603iB2) objB6), null, null, interfaceC22053ub1J, 48, 2);
                if (Fb(c20996sx3B, c20996sx3B2, wa(interfaceC9664aL6A4), va(interfaceC9664aL6A3))) {
                    interfaceC22053ub1J.W(1737768754);
                    pa(interfaceC22053ub1J, i2 & 14);
                    interfaceC22053ub1J.Q();
                } else if (Gb(c20996sx3B, c20996sx3B2, wa(interfaceC9664aL6A4), va(interfaceC9664aL6A3))) {
                    interfaceC22053ub1J.W(1738014429);
                    String strUa2 = ua(interfaceC9664aL6B);
                    Map mapVa2 = va(interfaceC9664aL6A3);
                    List listWa = wa(interfaceC9664aL6A4);
                    int i3 = C20996sx3.f;
                    Da(this, c20996sx3B, strUa2, mapVa2, c20996sx3B2, listWa, interfaceC22053ub1J, (i2 & 14) | (i3 << 3) | (i3 << 12) | ((i2 << 18) & 3670016));
                    interfaceC22053ub1J.Q();
                } else {
                    interfaceC22053ub1J.W(1738244325);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1J.W(-498115822);
                    boolean zD = interfaceC22053ub1J.D(this);
                    Object objB7 = interfaceC22053ub1J.B();
                    if (zD || objB7 == aVar2.a()) {
                        objB7 = new C8904e(null);
                        interfaceC22053ub1J.s(objB7);
                    }
                    interfaceC22053ub1J.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB7, interfaceC22053ub1J, 6);
                    interfaceC22053ub1J.W(-498111458);
                    boolean zD2 = interfaceC22053ub1J.D(this);
                    Object objB8 = interfaceC22053ub1J.B();
                    if (zD2 || objB8 == aVar2.a()) {
                        objB8 = new UA2() { // from class: ir.nasim.Lu4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8899Xu4.xa(this.a, (InterfaceC15069ix3) obj);
                            }
                        };
                        interfaceC22053ub1J.s(objB8);
                    }
                    interfaceC22053ub1J.Q();
                    interfaceC22053ub12 = interfaceC22053ub1J;
                    AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB8, interfaceC22053ub12, 0, 511);
                    interfaceC22053ub12.Q();
                    interfaceC22053ub12.Q();
                }
                interfaceC22053ub12 = interfaceC22053ub1J;
                interfaceC22053ub12.Q();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Pu4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C8899Xu4.ya(this.a, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ua(InterfaceC9664aL6 interfaceC9664aL6) {
        return (String) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map va(InterfaceC9664aL6 interfaceC9664aL6) {
        return (Map) interfaceC9664aL6.getValue();
    }

    private static final List wa(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 xa(C8899Xu4 c8899Xu4, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(c8899Xu4, "this$0");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        c8899Xu4.Sb(interfaceC15069ix3, 10);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(C8899Xu4 c8899Xu4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c8899Xu4, "$tmp8_rcvr");
        c8899Xu4.ta(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private final C6541Ny2 yb() {
        Object objA = this.binding.a(this, n1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C6541Ny2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List za(InterfaceC9664aL6 interfaceC9664aL6) {
        return (List) interfaceC9664aL6.getValue();
    }

    public final InterfaceC16935m68 Bb() {
        InterfaceC16935m68 interfaceC16935m68 = this.webAppNavigator;
        if (interfaceC16935m68 != null) {
            return interfaceC16935m68;
        }
        AbstractC13042fc3.y("webAppNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout constraintLayoutB = C6541Ny2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        return constraintLayoutB;
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void S0() {
        super.S0();
        this.startTime = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0241  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Za(java.lang.String r72, java.lang.Boolean r73, ir.nasim.SA2 r74, ir.nasim.InterfaceC22053ub1 r75, final int r76, final int r77) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8899Xu4.Za(java.lang.String, java.lang.Boolean, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void a1() {
        super.a1();
        if (this.startTime > 0) {
            Rb((SystemClock.elapsedRealtime() - this.startTime) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        if (this.startTime > 0) {
            Rb((SystemClock.elapsedRealtime() - this.startTime) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        this.startTime = SystemClock.elapsedRealtime();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        Ab().Q1();
        Db();
        ComposeView composeView = yb().d;
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-339713529, true, new H()));
    }

    public final boolean xb(AbstractC3769Cg6 searchEntity) {
        AbstractC13042fc3.i(searchEntity, "searchEntity");
        return (searchEntity instanceof AbstractC3769Cg6.c) || ((searchEntity instanceof AbstractC3769Cg6.g) && ((AbstractC3769Cg6.g) searchEntity).h()) || ((searchEntity instanceof AbstractC3769Cg6.b) && ((AbstractC3769Cg6.b) searchEntity).h());
    }

    public final InterfaceC11677dQ0 zb() {
        InterfaceC11677dQ0 interfaceC11677dQ0 = this.chatNavigator;
        if (interfaceC11677dQ0 != null) {
            return interfaceC11677dQ0;
        }
        AbstractC13042fc3.y("chatNavigator");
        return null;
    }
}
