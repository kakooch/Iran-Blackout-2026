package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.ui.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC19503qT1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.C21753u45;
import ir.nasim.C24254yJ;
import ir.nasim.C9919am6;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import ir.nasim.features.payment.view.activity.CrowdfundingActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u0083\u00012\u00020\u0001:\u0002\u0084\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J-\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\"\u0010#J/\u0010+\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0007¢\u0006\u0004\b-\u0010\u000fJ\u000f\u0010.\u001a\u00020\u0004H\u0007¢\u0006\u0004\b.\u0010\u000fJ!\u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020\u0012H\u0007¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u0010\u0003J\u000f\u00105\u001a\u00020\u0004H\u0007¢\u0006\u0004\b5\u0010\u000fJ\u000f\u00106\u001a\u00020\u0004H\u0007¢\u0006\u0004\b6\u0010\u000fJ!\u0010:\u001a\u00020\u00042\u0006\u00107\u001a\u00020'2\b\b\u0002\u00109\u001a\u000208H\u0007¢\u0006\u0004\b:\u0010;J\u001d\u0010>\u001a\u00020\u00042\f\u0010=\u001a\b\u0012\u0004\u0012\u00020/0<H\u0007¢\u0006\u0004\b>\u0010?J)\u0010A\u001a\u00020\u00042\f\u0010=\u001a\b\u0012\u0004\u0012\u00020/0<2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010'H\u0007¢\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bE\u0010FR\"\u0010N\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010U\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR0\u0010^\u001a\u0010\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020\u0004\u0018\u00010V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R(\u0010f\u001a\b\u0012\u0004\u0012\u00020'0_8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR0\u0010j\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0004\u0018\u00010V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010Y\u001a\u0004\bh\u0010[\"\u0004\bi\u0010]R0\u0010n\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u0004\u0018\u00010V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010Y\u001a\u0004\bl\u0010[\"\u0004\bm\u0010]R(\u0010r\u001a\b\u0012\u0004\u0012\u00020$0_8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010a\u001a\u0004\bp\u0010c\"\u0004\bq\u0010eR\u001b\u0010w\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u001b\u0010}\u001a\u00020x8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u001e\u0010\u0082\u0001\u001a\u00020~8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0004\b\u007f\u0010t\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0085\u0001"}, d2 = {"Lir/nasim/am6;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "lb", "Lir/nasim/Ef6;", "Za", "()Lir/nasim/Ef6;", "qb", "Ya", "ob", "nb", "hb", "Ea", "(Lir/nasim/ub1;I)V", "Ca", "Ga", "", "gb", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "R6", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "", "", "permissions", "", "grantResults", "g7", "(I[Ljava/lang/String;[I)V", "Ra", "Ia", "Lir/nasim/jO2;", "entity", "isGroup", "Ka", "(Lir/nasim/jO2;ZLir/nasim/ub1;II)V", "h7", "wa", "sa", "description", "Landroidx/compose/ui/e;", "modifier", "Pa", "(Ljava/lang/String;Landroidx/compose/ui/e;Lir/nasim/ub1;II)V", "", "entities", "pa", "(Ljava/util/List;Lir/nasim/ub1;I)V", "title", "za", "(Ljava/util/List;Ljava/lang/String;Lir/nasim/ub1;II)V", "Lir/nasim/HT4;", "state", "Na", "(Lir/nasim/HT4;Lir/nasim/ub1;I)V", "Lir/nasim/nr2;", "h1", "Lir/nasim/nr2;", "cb", "()Lir/nasim/nr2;", "setFlowType", "(Lir/nasim/nr2;)V", "flowType", "i1", "Ljava/lang/Integer;", "getHandlerPeerId", "()Ljava/lang/Integer;", "setHandlerPeerId", "(Ljava/lang/Integer;)V", "handlerPeerId", "Lkotlin/Function1;", "Lir/nasim/Be1;", "j1", "Lir/nasim/UA2;", "bb", "()Lir/nasim/UA2;", "setContactOnClick", "(Lir/nasim/UA2;)V", "contactOnClick", "Lir/nasim/Ym4;", "k1", "Lir/nasim/Ym4;", "eb", "()Lir/nasim/Ym4;", "setSearchQuery", "(Lir/nasim/Ym4;)V", "searchQuery", "l1", "getChannelOnClick", "setChannelOnClick", "channelOnClick", "m1", "getGroupOnClick", "setGroupOnClick", "groupOnClick", "n1", "getErrorState", "setErrorState", "errorState", "o1", "Lir/nasim/Yu3;", "db", "()Ljava/lang/String;", "readContactsPermission", "Lir/nasim/iz2;", "p1", "Lir/nasim/bW7;", "ab", "()Lir/nasim/iz2;", "binding", "Lir/nasim/lo4;", "q1", "fb", "()Lir/nasim/lo4;", "viewModel", "r1", "d", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.am6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9919am6 extends JX2 {

    /* renamed from: j1, reason: from kotlin metadata */
    private UA2 contactOnClick;

    /* renamed from: l1, reason: from kotlin metadata */
    private UA2 channelOnClick;

    /* renamed from: m1, reason: from kotlin metadata */
    private UA2 groupOnClick;

    /* renamed from: q1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;
    static final /* synthetic */ InterfaceC5239Im3[] s1 = {AbstractC10882cM5.i(new C25226zw5(C9919am6.class, "binding", "getBinding()Lir/nasim/databinding/FragmentSelectChatBinding;", 0))};

    /* renamed from: r1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int t1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private EnumC17964nr2 flowType = EnumC17964nr2.a;

    /* renamed from: i1, reason: from kotlin metadata */
    private Integer handlerPeerId = -1;

    /* renamed from: k1, reason: from kotlin metadata */
    private InterfaceC9102Ym4 searchQuery = AbstractC13472gH6.d("", null, 2, null);

    /* renamed from: n1, reason: from kotlin metadata */
    private InterfaceC9102Ym4 errorState = AbstractC13472gH6.d(0, null, 2, null);

    /* renamed from: o1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 readContactsPermission = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Vl6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C9919am6.pb();
        }
    });

    /* renamed from: p1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new u(), AbstractC20046rN7.c());

    /* renamed from: ir.nasim.am6$a */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        public a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.am6$b */
    public static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(UA2 ua2, List list) {
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

    /* renamed from: ir.nasim.am6$c */
    public static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ C9919am6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List list, C9919am6 c9919am6) {
            super(4);
            this.e = list;
            this.f = c9919am6;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
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
            C15322jO2 c15322jO2 = (C15322jO2) this.e.get(i);
            interfaceC22053ub1.W(-1802318513);
            this.f.Ka(c15322jO2, false, interfaceC22053ub1, 48, 0);
            F27.a(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.b.d(androidx.compose.ui.e.a, WX0.a(IA5.color6_2, interfaceC22053ub1, 0), null, 2, null), 0.0f, 1, null), null, 0L, 0L, 0.0f, 0.0f, null, C13394g91.a.b(), interfaceC22053ub1, 12582912, 126);
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

    /* renamed from: ir.nasim.am6$d, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final EnumC17964nr2 a(int i) {
            for (EnumC17964nr2 enumC17964nr2 : EnumC17964nr2.values()) {
                if (enumC17964nr2.ordinal() == i) {
                    return enumC17964nr2;
                }
            }
            return null;
        }

        public final C9919am6 b(int i) {
            C9919am6 c9919am6 = new C9919am6();
            Bundle bundle = new Bundle();
            bundle.putInt("ir.nasim.features.bank.mybank.flow.type", i);
            c9919am6.a8(bundle);
            return c9919am6;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.am6$e */
    static final class e implements InterfaceC16978mB2 {
        final /* synthetic */ C20996sx3 a;
        final /* synthetic */ C9919am6 b;

        e(C20996sx3 c20996sx3, C9919am6 c9919am6) {
            this.a = c20996sx3;
            this.b = c9919am6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C9919am6 c9919am6, C3512Be1 c3512Be1) {
            AbstractC13042fc3.i(c9919am6, "this$0");
            AbstractC13042fc3.i(c3512Be1, "contact");
            UA2 contactOnClick = c9919am6.getContactOnClick();
            if (contactOnClick != null) {
                contactOnClick.invoke(c3512Be1);
            }
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
            C20996sx3 c20996sx3 = this.a;
            final C9919am6 c9919am6 = this.b;
            C3512Be1 c3512Be1 = (C3512Be1) c20996sx3.f(i);
            interfaceC22053ub1.W(1796059330);
            if (c3512Be1 != null) {
                interfaceC22053ub1.W(2090010722);
                boolean zD = interfaceC22053ub1.D(c9919am6);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.bm6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C9919am6.e.c(c9919am6, (C3512Be1) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC6339Ne1.h(c3512Be1, (UA2) objB, interfaceC22053ub1, 0);
            }
            interfaceC22053ub1.Q();
            F27.a(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.b.d(androidx.compose.ui.e.a, WX0.a(IA5.color6_2, interfaceC22053ub1, 0), null, 2, null), 0.0f, 1, null), null, 0L, 0L, 0.0f, 0.0f, null, C13394g91.a.a(), interfaceC22053ub1, 12582912, 126);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.am6$f */
    static final class f implements InterfaceC15796kB2 {
        f() {
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(l66, "$this$Button");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strH6 = C9919am6.this.h6(AbstractC12217eE5.contacts_active_read_contacts_permission);
            AbstractC13042fc3.h(strH6, "getString(...)");
            AbstractC9339Zm7.b(strH6, androidx.compose.ui.e.a, WX0.a(IA5.color3, interfaceC22053ub1, 0), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, C15386jV3.a.c(interfaceC22053ub1, C15386jV3.b).h(), interfaceC22053ub1, 48, 0, 65016);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.am6$g */
    static final class g implements InterfaceC14603iB2 {
        final /* synthetic */ C15322jO2 b;

        g(C15322jO2 c15322jO2) {
            this.b = c15322jO2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C9919am6.this.Ka(this.b, true, interfaceC22053ub1, 48, 0);
                ZV1.a(androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, C17784nZ1.q(72), 0.0f, 0.0f, 0.0f, 14, null), C17784nZ1.q(1), WX0.a(IA5.color1, interfaceC22053ub1, 0), interfaceC22053ub1, 54, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.am6$h */
    public static final class h extends AbstractC8614Ws3 implements UA2 {
        public static final h e = new h();

        public h() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.am6$i */
    public static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(UA2 ua2, List list) {
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

    /* renamed from: ir.nasim.am6$j */
    public static final class j extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ C9919am6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(List list, C9919am6 c9919am6) {
            super(4);
            this.e = list;
            this.f = c9919am6;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
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
            C15322jO2 c15322jO2 = (C15322jO2) this.e.get(i);
            interfaceC22053ub1.W(1614704240);
            F27.a(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.b.d(androidx.compose.ui.e.a, WX0.a(IA5.color6_2, interfaceC22053ub1, 0), null, 2, null), 0.0f, 1, null), null, 0L, 0L, 0.0f, 0.0f, null, AbstractC19242q11.e(-684628959, true, this.f.new g(c15322jO2), interfaceC22053ub1, 54), interfaceC22053ub1, 12582912, 126);
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

    /* renamed from: ir.nasim.am6$k */
    static final class k implements InterfaceC15796kB2 {
        final /* synthetic */ C12889fL5 a;

        k(C12889fL5 c12889fL5) {
            this.a = c12889fL5;
        }

        public final void a(List list, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(list, "tabPositions");
            float f = 18;
            C8528Wi7.a.a(FV0.a(KT4.b(androidx.compose.ui.e.a, (HT4) this.a.a, list, null, 4, null), N46.f(C17784nZ1.q(f), C17784nZ1.q(f), 0.0f, 0.0f, 12, null)), C17784nZ1.q(4), WX0.a(IA5.secondary_2, interfaceC22053ub1, 0), interfaceC22053ub1, (C8528Wi7.c << 9) | 48, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((List) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.am6$l */
    static final class l implements InterfaceC14603iB2 {
        final /* synthetic */ C12889fL5 a;
        final /* synthetic */ C12889fL5 b;
        final /* synthetic */ InterfaceC20315ro1 c;

        /* renamed from: ir.nasim.am6$l$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12889fL5 c;
            final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12889fL5 c12889fL5, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12889fL5;
                this.d = i;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    HT4 ht4 = (HT4) this.c.a;
                    int i2 = this.d;
                    this.b = 1;
                    if (HT4.j(ht4, i2, 0.0f, this, 2, null) == objE) {
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

        /* renamed from: ir.nasim.am6$l$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ C12889fL5 a;
            final /* synthetic */ int b;
            final /* synthetic */ C12889fL5 c;

            b(C12889fL5 c12889fL5, int i, C12889fL5 c12889fL52) {
                this.a = c12889fL5;
                this.b = i;
                this.c = c12889fL52;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                long jA;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                Object obj = ((List) this.a.a).get(this.b);
                AbstractC13042fc3.h(obj, "get(...)");
                String str = (String) obj;
                C9348Zn7 c9348Zn7I = C15386jV3.a.c(interfaceC22053ub1, C15386jV3.b).i();
                if (((HT4) this.c.a).k() == this.b) {
                    interfaceC22053ub1.W(-1507356125);
                    jA = WX0.a(IA5.secondary_2, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(-1507228312);
                    jA = WX0.a(IA5.color8, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                }
                AbstractC9339Zm7.b(str, null, jA, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7I, interfaceC22053ub1, 0, 0, 65530);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        l(C12889fL5 c12889fL5, C12889fL5 c12889fL52, InterfaceC20315ro1 interfaceC20315ro1) {
            this.a = c12889fL5;
            this.b = c12889fL52;
            this.c = interfaceC20315ro1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC20315ro1 interfaceC20315ro1, C12889fL5 c12889fL5, int i) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(c12889fL5, "$pagerState");
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c12889fL5, i, null), 3, null);
            return C19938rB7.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C12889fL5 c12889fL5 = this.a;
            Iterable iterable = (Iterable) c12889fL5.a;
            final C12889fL5 c12889fL52 = this.b;
            final InterfaceC20315ro1 interfaceC20315ro1 = this.c;
            int i2 = 0;
            final int i3 = 0;
            for (Object obj : iterable) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    AbstractC10360bX0.w();
                }
                AbstractC6142Mi7.b(i3 == ((HT4) c12889fL52.a).k() ? 1 : i2, new SA2() { // from class: ir.nasim.cm6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C9919am6.l.c(interfaceC20315ro1, c12889fL52, i3);
                    }
                }, null, false, AbstractC19242q11.e(1366899628, true, new b(c12889fL5, i3, c12889fL52), interfaceC22053ub1, 54), null, WX0.a(IA5.secondary, interfaceC22053ub1, i2), 0L, null, interfaceC22053ub1, 24576, 428);
                i3 = i4;
                c12889fL5 = c12889fL5;
                i2 = i2;
                interfaceC20315ro1 = interfaceC20315ro1;
                c12889fL52 = c12889fL52;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.am6$m */
    static final class m implements InterfaceC14603iB2 {
        final /* synthetic */ C15322jO2 a;
        final /* synthetic */ C9919am6 b;
        final /* synthetic */ boolean c;

        m(C15322jO2 c15322jO2, C9919am6 c9919am6, boolean z) {
            this.a = c15322jO2;
            this.b = c9919am6;
            this.c = z;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            float f = 12;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f), C17784nZ1.q(f), 0.0f, C17784nZ1.q(11), 4, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC12529em.c cVarI = aVar2.i();
            C15322jO2 c15322jO2 = this.a;
            C9919am6 c9919am6 = this.b;
            boolean z = this.c;
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), cVarI, interfaceC22053ub1, 48);
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
            AbstractC6339Ne1.d((int) c15322jO2.c(), c15322jO2.e(), c15322jO2.a(), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarM2 = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(10), 0.0f, 0.0f, 0.0f, 14, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1, 48);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM2);
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            InterfaceC12529em.c cVarI2 = aVar2.i();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.g(), cVarI2, interfaceC22053ub1, 48);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            AbstractC11456d23.b(FV4.c(z ? KB5.group_icon : KB5.channel_icon, interfaceC22053ub1, 0), "", null, null, null, 0.0f, AbstractC24975zX0.a.b(AbstractC24975zX0.b, WX0.a(IA5.color9, interfaceC22053ub1, 0), 0, 2, null), interfaceC22053ub1, 48, 60);
            String strE = c15322jO2.e();
            int iB = AbstractC23365wn7.a.b();
            C15386jV3 c15386jV3 = C15386jV3.a;
            int i2 = C15386jV3.b;
            AbstractC9339Zm7.b(strE, androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(androidx.compose.foundation.layout.t.C(aVar, null, false, 3, null), 0.0f, 1, null), C17784nZ1.q(4), 0.0f, C17784nZ1.q(f), 0.0f, 10, null), WX0.a(IA5.color9, interfaceC22053ub1, 0), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, iB, false, 1, 0, null, c15386jV3.c(interfaceC22053ub1, i2).n(), interfaceC22053ub1, 48, 3120, 54776);
            interfaceC22053ub1.u();
            AbstractC9339Zm7.b(GY6.a(String.valueOf(c15322jO2.d())) + Separators.SP + c9919am6.h6(AbstractC12217eE5.member), androidx.compose.foundation.layout.t.C(aVar, null, false, 3, null), WX0.a(IA5.color8, interfaceC22053ub1, 0), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c15386jV3.c(interfaceC22053ub1, i2).o(), interfaceC22053ub1, 48, 0, 65528);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.am6$n */
    static final class n implements InterfaceC16978mB2 {
        n() {
        }

        public final void a(InterfaceC21983uT4 interfaceC21983uT4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC21983uT4, "$this$HorizontalPager");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (C9919am6.this.getFlowType() == EnumC17964nr2.c) {
                interfaceC22053ub1.W(1417240535);
                if (i == 0) {
                    interfaceC22053ub1.W(1417289887);
                    C9919am6.this.Ca(interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                } else if (i != 1) {
                    interfaceC22053ub1.W(1417472105);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(1417381089);
                    C9919am6.this.Ga(interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                }
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(1417542320);
            if (i == 0) {
                interfaceC22053ub1.W(1417590463);
                C9919am6.this.Ea(interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else if (i == 1) {
                interfaceC22053ub1.W(1417681727);
                C9919am6.this.Ca(interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else if (i != 2) {
                interfaceC22053ub1.W(1417851328);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(1417772929);
                C9919am6.this.Ga(interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            }
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC21983uT4) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.am6$o */
    public /* synthetic */ class o {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC17964nr2.values().length];
            try {
                iArr[EnumC17964nr2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC17964nr2.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC17964nr2.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.am6$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9919am6.this.new q(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C9919am6 c9919am6 = C9919am6.this;
            c9919am6.n9(c9919am6, false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.am6$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9919am6.this.new r(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C9919am6 c9919am6 = C9919am6.this;
            c9919am6.n9(c9919am6, false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.am6$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9919am6.this.new s(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C9919am6 c9919am6 = C9919am6.this;
            c9919am6.n9(c9919am6, false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.am6$t */
    static final class t implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.am6$t$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C9919am6 a;

            /* renamed from: ir.nasim.am6$t$a$a, reason: collision with other inner class name */
            static final class C0850a implements InterfaceC14603iB2 {
                final /* synthetic */ C9919am6 a;

                C0850a(C9919am6 c9919am6) {
                    this.a = c9919am6;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    this.a.qb();
                    this.a.Ra(interfaceC22053ub1, 0);
                    this.a.Ia(interfaceC22053ub1, 0);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C9919am6 c9919am6) {
                this.a = c9919am6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    M10.f(false, AbstractC19242q11.e(71961240, true, new C0850a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        t() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(1035470003, true, new a(C9919am6.this), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.am6$u */
    public static final class u extends AbstractC8614Ws3 implements UA2 {
        public u() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C15086iz2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.am6$v */
    public static final class v extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.am6$w */
    public static final class w extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.am6$x */
    public static final class x extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.am6$y */
    public static final class y extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.am6$z */
    public static final class z extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C9919am6() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new w(new v(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C16754lo4.class), new x(interfaceC9173Yu3B), new y(null, interfaceC9173Yu3B), new z(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Aa(List list, C9919am6 c9919am6, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$entities");
        AbstractC13042fc3.i(c9919am6, "this$0");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        interfaceC15069ix3.a(list.size(), null, new i(h.e, list), AbstractC19242q11.c(-632812321, true, new j(list, c9919am6)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ba(C9919am6 c9919am6, List list, String str, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        AbstractC13042fc3.i(list, "$entities");
        c9919am6.za(list, str, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ca(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(381079359);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC9664aL6 interfaceC9664aL6A = AbstractC10222bH6.a(fb().b1(), AbstractC19503qT1.a.a, null, interfaceC22053ub1J, 48, 2);
            AbstractC19503qT1 abstractC19503qT1 = (AbstractC19503qT1) interfaceC9664aL6A.getValue();
            if (!(abstractC19503qT1 instanceof AbstractC19503qT1.a) && (abstractC19503qT1 instanceof AbstractC19503qT1.c)) {
                Object value = interfaceC9664aL6A.getValue();
                AbstractC13042fc3.g(value, "null cannot be cast to non-null type ir.nasim.features.bank.mybank.flow.DialogsState.Success<kotlin.collections.List<ir.nasim.features.bank.mybank.flow.Group_Channel>>");
                pa((List) ((AbstractC19503qT1.c) value).a(), interfaceC22053ub1J, (i3 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.El6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9919am6.Da(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Da(C9919am6 c9919am6, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        c9919am6.Ca(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1013214462);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else if (((Boolean) fb().f1().getValue()).booleanValue()) {
            interfaceC22053ub1J.W(2022277265);
            sa(interfaceC22053ub1J, i3 & 14);
            interfaceC22053ub1J.Q();
        } else {
            interfaceC22053ub1J.W(2022320386);
            wa(interfaceC22053ub1J, i3 & 14);
            interfaceC22053ub1J.Q();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Zl6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9919am6.Fa(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Fa(C9919am6 c9919am6, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        c9919am6.Ea(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ga(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1803933245);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC9664aL6 interfaceC9664aL6A = AbstractC10222bH6.a(fb().e1(), AbstractC19503qT1.a.a, null, interfaceC22053ub1J, 48, 2);
            AbstractC19503qT1 abstractC19503qT1 = (AbstractC19503qT1) interfaceC9664aL6A.getValue();
            if (!(abstractC19503qT1 instanceof AbstractC19503qT1.a) && (abstractC19503qT1 instanceof AbstractC19503qT1.c)) {
                Object value = interfaceC9664aL6A.getValue();
                AbstractC13042fc3.g(value, "null cannot be cast to non-null type ir.nasim.features.bank.mybank.flow.DialogsState.Success<kotlin.collections.List<ir.nasim.features.bank.mybank.flow.Group_Channel>>");
                za((List) ((AbstractC19503qT1.c) value).a(), null, interfaceC22053ub1J, (i3 << 6) & 896, 2);
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Yl6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9919am6.Ha(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ha(C9919am6 c9919am6, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        c9919am6.Ga(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ja(C9919am6 c9919am6, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        c9919am6.Ia(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 La(C9919am6 c9919am6, C15322jO2 c15322jO2, boolean z2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c9919am6, "$tmp1_rcvr");
        AbstractC13042fc3.i(c15322jO2, "$entity");
        c9919am6.Ka(c15322jO2, z2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ma(boolean z2, C9919am6 c9919am6, C15322jO2 c15322jO2) {
        UA2 ua2;
        AbstractC13042fc3.i(c9919am6, "this$0");
        AbstractC13042fc3.i(c15322jO2, "$entity");
        if (!z2 ? (ua2 = c9919am6.channelOnClick) != null : (ua2 = c9919am6.groupOnClick) != null) {
            ua2.invoke(c15322jO2);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Oa(C9919am6 c9919am6, HT4 ht4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        AbstractC13042fc3.i(ht4, "$state");
        c9919am6.Na(ht4, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Qa(C9919am6 c9919am6, String str, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        AbstractC13042fc3.i(str, "$description");
        c9919am6.Pa(str, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Sa(C9919am6 c9919am6, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        c9919am6.Ra(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private final void Ya() {
        C21753u45.a.a1(this, 1088, C21753u45.c.d, (56 & 8) != 0 ? null : null, (56 & 16) != 0 ? new SA2() { // from class: ir.nasim.e45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.c1();
            }
        } : null, (56 & 32) != 0 ? new SA2() { // from class: ir.nasim.f45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.d1();
            }
        } : null, C21753u45.d.h);
    }

    private final InterfaceC4228Ef6 Za() {
        return new p();
    }

    private final String db() {
        return (String) this.readContactsPermission.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C16754lo4 fb() {
        return (C16754lo4) this.viewModel.getValue();
    }

    private final boolean gb() {
        return AbstractC4043Dl1.a(S7(), db()) == 0;
    }

    private final void hb() {
        this.contactOnClick = new UA2() { // from class: ir.nasim.Dl6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C9919am6.ib(this.a, (C3512Be1) obj);
            }
        };
        this.channelOnClick = new UA2() { // from class: ir.nasim.Ol6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C9919am6.jb(this.a, (C15322jO2) obj);
            }
        };
        this.groupOnClick = new UA2() { // from class: ir.nasim.Sl6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C9919am6.kb(this.a, (C15322jO2) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ib(C9919am6 c9919am6, C3512Be1 c3512Be1) {
        AbstractC13042fc3.i(c9919am6, "this$0");
        AbstractC13042fc3.i(c3512Be1, "contact");
        int i2 = o.a[c9919am6.flowType.ordinal()];
        if (i2 == 1) {
            C5735Kp4.w().s(C11458d25.E(c3512Be1.r()));
            AbstractC23658xI2.d(c9919am6.S7(), c9919am6.Q7());
        } else if (i2 == 2) {
            CardPaymentActivity.Companion companion = CardPaymentActivity.INSTANCE;
            Context contextS7 = c9919am6.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            companion.j(contextS7, c3512Be1.r(), ExPeerType.PRIVATE, true);
        }
        try {
            AbstractC10533bm0.d(AbstractC16751lo1.a(c9919am6), null, null, c9919am6.new q(null), 3, null);
        } catch (Exception unused) {
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 jb(C9919am6 c9919am6, C15322jO2 c15322jO2) {
        AbstractC13042fc3.i(c9919am6, "this$0");
        AbstractC13042fc3.i(c15322jO2, "value");
        int i2 = o.a[c9919am6.flowType.ordinal()];
        if (i2 == 1) {
            C5735Kp4.w().s(C11458d25.y((int) c15322jO2.c()));
            AbstractC23658xI2.d(c9919am6.S7(), c9919am6.Q7());
        } else if (i2 == 2) {
            CardPaymentActivity.Companion companion = CardPaymentActivity.INSTANCE;
            Context contextS7 = c9919am6.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            companion.j(contextS7, c15322jO2.c(), ExPeerType.CHANNEL, true);
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            CrowdfundingActivity.Companion companion2 = CrowdfundingActivity.INSTANCE;
            Context contextS72 = c9919am6.S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            companion2.a(contextS72, c15322jO2.c(), true);
        }
        try {
            AbstractC10533bm0.d(AbstractC16751lo1.a(c9919am6), null, null, c9919am6.new r(null), 3, null);
        } catch (Exception unused) {
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 kb(C9919am6 c9919am6, C15322jO2 c15322jO2) {
        AbstractC13042fc3.i(c9919am6, "this$0");
        AbstractC13042fc3.i(c15322jO2, "value");
        if (c15322jO2.b()) {
            int i2 = o.a[c9919am6.flowType.ordinal()];
            if (i2 == 1) {
                C5735Kp4.w().s(C11458d25.y((int) c15322jO2.c()));
                AbstractC23658xI2.d(c9919am6.S7(), c9919am6.Q7());
            } else if (i2 == 2) {
                CardPaymentActivity.Companion companion = CardPaymentActivity.INSTANCE;
                Context contextS7 = c9919am6.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                companion.j(contextS7, c15322jO2.c(), ExPeerType.GROUP, true);
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                CrowdfundingActivity.Companion companion2 = CrowdfundingActivity.INSTANCE;
                Context contextS72 = c9919am6.S7();
                AbstractC13042fc3.h(contextS72, "requireContext(...)");
                companion2.a(contextS72, C11458d25.y((int) c15322jO2.c()).u(), true);
            }
        } else {
            InterfaceC9102Ym4 interfaceC9102Ym4 = c9919am6.errorState;
            interfaceC9102Ym4.setValue(Integer.valueOf(((Number) interfaceC9102Ym4.getValue()).intValue() + 1));
        }
        try {
            AbstractC10533bm0.d(AbstractC16751lo1.a(c9919am6), null, null, c9919am6.new s(null), 3, null);
        } catch (Exception unused) {
        }
        return C19938rB7.a;
    }

    private final void lb() {
        String strH6;
        ab().d.y(AbstractC15226jD5.dialog_container_new);
        BaleToolbar baleToolbar = ab().d;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        ab().d.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.Ul6
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return C9919am6.mb(this.a, menuItem);
            }
        });
        String strH62 = h6(AbstractC12217eE5.destination);
        int i2 = o.a[this.flowType.ordinal()];
        if (i2 == 1) {
            strH6 = h6(AbstractC12217eE5.gift_packet);
        } else if (i2 == 2) {
            strH6 = h6(AbstractC12217eE5.money_request);
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            strH6 = h6(AbstractC12217eE5.crowd_funding);
        }
        ab().d.setTitle(strH62 + Separators.SP + strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mb(C9919am6 c9919am6, MenuItem menuItem) {
        AbstractC13042fc3.i(c9919am6, "this$0");
        if (menuItem.getItemId() != BC5.search) {
            return false;
        }
        BaleToolbar baleToolbar = c9919am6.ab().d;
        String strH6 = c9919am6.h6(AbstractC12217eE5.chat_menu_search);
        AbstractC13042fc3.h(strH6, "getString(...)");
        baleToolbar.setHasSearchButton(strH6, c9919am6.Za(), true);
        return true;
    }

    private final void nb() {
        fb().g1(false);
        if (m8(db())) {
            return;
        }
        C5505Jq.M(db(), false);
        C5505Jq.M("android.permission.READ_CONTACTS_fragment", false);
    }

    private final void ob() {
        fb().g1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String pb() {
        return "android.permission.READ_CONTACTS";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(List list, C9919am6 c9919am6, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$entities");
        AbstractC13042fc3.i(c9919am6, "this$0");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        interfaceC15069ix3.a(list.size(), null, new b(a.e, list), AbstractC19242q11.c(-632812321, true, new c(list, c9919am6)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qb() {
        if (gb()) {
            fb().g1(true);
        } else {
            Ya();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(C9919am6 c9919am6, List list, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        AbstractC13042fc3.i(list, "$entities");
        c9919am6.pa(list, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ta(C20996sx3 c20996sx3, C9919am6 c9919am6, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(c20996sx3, "$data");
        AbstractC13042fc3.i(c9919am6, "this$0");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), AbstractC13259fv3.a(c20996sx3, new UA2() { // from class: ir.nasim.Pl6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C9919am6.ua((C3512Be1) obj);
            }
        }), null, AbstractC19242q11.c(1603806940, true, new e(c20996sx3, c9919am6)), 4, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ua(C3512Be1 c3512Be1) {
        AbstractC13042fc3.i(c3512Be1, "it");
        return Integer.valueOf(c3512Be1.r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(C9919am6 c9919am6, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        c9919am6.sa(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 xa(C9919am6 c9919am6) {
        AbstractC13042fc3.i(c9919am6, "this$0");
        C21753u45.j0(C21753u45.a, c9919am6, 7, C21753u45.d.h, null, 8, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(C9919am6 c9919am6, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c9919am6, "$tmp0_rcvr");
        c9919am6.wa(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public final void Ia(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1250778310);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C12889fL5 c12889fL5 = new C12889fL5();
            c12889fL5.a = JT4.a(0, interfaceC22053ub1J, 6, 0);
            C12889fL5 c12889fL52 = new C12889fL5();
            c12889fL52.a = AbstractC10360bX0.p(h6(AbstractC12217eE5.privat), h6(AbstractC12217eE5.channel), h6(AbstractC12217eE5.group));
            interfaceC22053ub1J.W(951886188);
            if (this.flowType == EnumC17964nr2.c) {
                c12889fL5.a = JT4.a(0, interfaceC22053ub1J, 6, 0);
                c12889fL52.a = AbstractC10360bX0.p(h6(AbstractC12217eE5.channel), h6(AbstractC12217eE5.group));
            }
            interfaceC22053ub1J.Q();
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB;
            C24254yJ.m mVarH = C24254yJ.a.h();
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, InterfaceC12529em.a.k(), interfaceC22053ub1J, 6);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
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
            AbstractC9069Yi7.a(((HT4) c12889fL5.a).k(), null, WX0.a(IA5.color5, interfaceC22053ub1J, 0), 0L, AbstractC19242q11.e(1953768312, true, new k(c12889fL5), interfaceC22053ub1J, 54), null, AbstractC19242q11.e(-959762056, true, new l(c12889fL52, c12889fL5, interfaceC20315ro1), interfaceC22053ub1J, 54), interfaceC22053ub1J, 1597440, 42);
            Na((HT4) c12889fL5.a, interfaceC22053ub1J, (i3 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Tl6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9919am6.Ja(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Ka(final ir.nasim.C15322jO2 r26, boolean r27, ir.nasim.InterfaceC22053ub1 r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9919am6.Ka(ir.nasim.jO2, boolean, ir.nasim.ub1, int, int):void");
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        EnumC17964nr2 enumC17964nr2A = INSTANCE.a(R7().getInt("ir.nasim.features.bank.mybank.flow.type"));
        if (enumC17964nr2A == null) {
            enumC17964nr2A = EnumC17964nr2.a;
        }
        this.flowType = enumC17964nr2A;
        this.handlerPeerId = Integer.valueOf(R7().getInt("HANDLER_PEER_ID"));
    }

    public final void Na(final HT4 ht4, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(ht4, "state");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(182062105);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(ht4) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC12351eT4.a(3, androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.b.d(androidx.compose.ui.e.a, WX0.a(IA5.color4, interfaceC22053ub1J, 0), null, 2, null), 0.0f, 1, null), null, false, 3, null), ht4, false, 0.0f, null, null, null, null, false, AbstractC19242q11.e(-180773388, true, new n(), interfaceC22053ub1J, 54), interfaceC22053ub1J, ((i3 << 6) & 896) | 6, 6, 1016);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Xl6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9919am6.Oa(this.a, ht4, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Pa(final java.lang.String r28, androidx.compose.ui.e r29, ir.nasim.InterfaceC22053ub1 r30, final int r31, final int r32) {
        /*
            r27 = this;
            r0 = r28
            java.lang.String r1 = "description"
            ir.nasim.AbstractC13042fc3.i(r0, r1)
            r1 = -584107511(0xffffffffdd2f3a09, float:-7.891509E17)
            r2 = r30
            ir.nasim.ub1 r15 = r2.j(r1)
            r1 = r32 & 1
            if (r1 == 0) goto L17
            r1 = r31 | 6
            goto L29
        L17:
            r1 = r31 & 6
            if (r1 != 0) goto L27
            boolean r1 = r15.V(r0)
            if (r1 == 0) goto L23
            r1 = 4
            goto L24
        L23:
            r1 = 2
        L24:
            r1 = r31 | r1
            goto L29
        L27:
            r1 = r31
        L29:
            r2 = r32 & 2
            if (r2 == 0) goto L33
            r1 = r1 | 48
        L2f:
            r3 = r29
        L31:
            r4 = r1
            goto L46
        L33:
            r3 = r31 & 48
            if (r3 != 0) goto L2f
            r3 = r29
            boolean r4 = r15.V(r3)
            if (r4 == 0) goto L42
            r4 = 32
            goto L44
        L42:
            r4 = 16
        L44:
            r1 = r1 | r4
            goto L31
        L46:
            r1 = r4 & 19
            r5 = 18
            if (r1 != r5) goto L59
            boolean r1 = r15.k()
            if (r1 != 0) goto L53
            goto L59
        L53:
            r15.L()
            r26 = r15
            goto Lb0
        L59:
            if (r2 == 0) goto L5f
            androidx.compose.ui.e$a r1 = androidx.compose.ui.e.a
            r13 = r1
            goto L60
        L5f:
            r13 = r3
        L60:
            r1 = 0
            r2 = 0
            r3 = 1
            androidx.compose.ui.e r1 = androidx.compose.foundation.layout.t.h(r13, r1, r3, r2)
            r2 = 12
            float r2 = (float) r2
            float r2 = ir.nasim.C17784nZ1.q(r2)
            androidx.compose.ui.e r1 = androidx.compose.foundation.layout.q.i(r1, r2)
            int r2 = ir.nasim.IA5.color8
            r3 = 0
            long r2 = ir.nasim.WX0.a(r2, r15, r3)
            ir.nasim.jV3 r5 = ir.nasim.C15386jV3.a
            int r6 = ir.nasim.C15386jV3.b
            ir.nasim.Kz7 r5 = r5.c(r15, r6)
            ir.nasim.Zn7 r20 = r5.o()
            r22 = r4 & 14
            r23 = 0
            r24 = 65528(0xfff8, float:9.1824E-41)
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r25 = r13
            r13 = r16
            r16 = 0
            r26 = r15
            r15 = r16
            r17 = 0
            r18 = 0
            r19 = 0
            r0 = r28
            r21 = r26
            ir.nasim.AbstractC9339Zm7.b(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r3 = r25
        Lb0:
            ir.nasim.rd6 r6 = r26.m()
            if (r6 == 0) goto Lc7
            ir.nasim.Nl6 r7 = new ir.nasim.Nl6
            r0 = r7
            r1 = r27
            r2 = r28
            r4 = r31
            r5 = r32
            r0.<init>()
            r6.a(r7)
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9919am6.Pa(java.lang.String, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.inflate(AbstractC12208eD5.fragment_select_chat, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
    }

    public final void Ra(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-8213084);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else if (((Number) this.errorState.getValue()).intValue() != 0) {
            LinearLayout root = ab().getRoot();
            AbstractC13042fc3.h(root, "getRoot(...)");
            C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
            String strH6 = h6(AbstractC12217eE5.send_message_access_is_denied_in_this_group);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c17468n10.o(strH6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Wl6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9919am6.Sa(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final C15086iz2 ab() {
        Object objA = this.binding.a(this, s1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C15086iz2) objA;
    }

    /* renamed from: bb, reason: from getter */
    public final UA2 getContactOnClick() {
        return this.contactOnClick;
    }

    /* renamed from: cb, reason: from getter */
    public final EnumC17964nr2 getFlowType() {
        return this.flowType;
    }

    /* renamed from: eb, reason: from getter */
    public final InterfaceC9102Ym4 getSearchQuery() {
        return this.searchQuery;
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        if (requestCode != 1088) {
            super.g7(requestCode, permissions, grantResults);
            return;
        }
        Integer numD0 = AbstractC10242bK.d0(grantResults);
        if (numD0 != null && numD0.intValue() == 0) {
            ob();
        } else {
            nb();
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        fb().g1(gb());
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        hb();
        lb();
        fb().g1(gb());
        ab().b.setContent(AbstractC19242q11.c(1921748979, true, new t()));
    }

    public final void pa(final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(list, "entities");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(150103083);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVarD = androidx.compose.foundation.layout.t.d(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            String strH6 = h6(AbstractC12217eE5.channel_list_in_bale);
            AbstractC13042fc3.h(strH6, "getString(...)");
            Pa(strH6, null, interfaceC22053ub1J, (i3 << 3) & 896, 2);
            interfaceC22053ub1J.W(-325484529);
            boolean zD = interfaceC22053ub1J.D(list) | interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Ll6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C9919am6.qa(list, this, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, ua2, interfaceC22053ub12, 0, 511);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ml6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9919am6.ra(this.a, list, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void sa(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(487876848);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            final C20996sx3 c20996sx3B = AbstractC21683tx3.b(fb().c1((String) this.searchQuery.getValue()), null, interfaceC22053ub1J, 0, 1);
            androidx.compose.ui.e eVarD = androidx.compose.foundation.layout.t.d(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            String strH6 = h6(AbstractC12217eE5.contacts_list_in_bale);
            AbstractC13042fc3.h(strH6, "getString(...)");
            Pa(strH6, null, interfaceC22053ub1J, (i3 << 6) & 896, 2);
            interfaceC22053ub1J.W(-1231703902);
            boolean zD = interfaceC22053ub1J.D(c20996sx3B) | interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Hl6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C9919am6.ta(c20996sx3B, this, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, ua2, interfaceC22053ub12, 0, 511);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Il6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9919am6.va(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void wa(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1045952629);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            float f2 = 16;
            float f3 = 12;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.layout.t.d(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.j(aVar, C17784nZ1.q(f2), C17784nZ1.q(f3)), 0.0f, 1, null), 0.0f, 1, null);
            C24254yJ.m mVarH = C24254yJ.a.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(androidx.compose.foundation.b.d(FV0.a(aVar, N46.d(C17784nZ1.q(f3))), WX0.a(IA5.color3, interfaceC22053ub1J, 0), null, 2, null), C17784nZ1.q(f2)), 0.0f, 1, null), C17784nZ1.q(160));
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            AbstractC11456d23.b(FV4.c(KB5.alert_icon, interfaceC22053ub1J, 0), "", FV0.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(40)), N46.g()), aVar2.o(), null, 0.0f, null, interfaceC22053ub1J, 3120, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            String strH6 = h6(AbstractC12217eE5.contacts_permission_needed_btn);
            AbstractC13042fc3.h(strH6, "getString(...)");
            float f4 = 48;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(hVar.h(aVar, aVar2.o()), C17784nZ1.q(f4), 0.0f, 0.0f, 0.0f, 14, null);
            C15386jV3 c15386jV3 = C15386jV3.a;
            int i4 = C15386jV3.b;
            AbstractC9339Zm7.b(strH6, eVarM, WX0.a(IA5.color9, interfaceC22053ub1J, 0), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c15386jV3.c(interfaceC22053ub1J, i4).i(), interfaceC22053ub1J, 0, 0, 65528);
            String strH62 = h6(AbstractC12217eE5.contacts_permission_card_description);
            AbstractC13042fc3.h(strH62, "getString(...)");
            AbstractC9339Zm7.b(strH62, androidx.compose.foundation.layout.q.m(hVar.h(aVar, aVar2.o()), C17784nZ1.q(f4), C17784nZ1.q(26), 0.0f, 0.0f, 12, null), WX0.a(IA5.color8, interfaceC22053ub1J, 0), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c15386jV3.c(interfaceC22053ub1J, i4).c(), interfaceC22053ub1J, 0, 0, 65528);
            androidx.compose.ui.e eVarB = AbstractC6033Lw6.b(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(hVar.h(aVar, aVar2.b()), 0.0f, 1, null), C17784nZ1.q(f4)), C17784nZ1.q(0), null, false, 0L, 0L, 30, null);
            C5947Ln0 c5947Ln0B = C6679On0.a.b(WX0.a(IA5.secondary, interfaceC22053ub1J, 0), 0L, 0L, 0L, interfaceC22053ub1J, C6679On0.o << 12, 14);
            M46 m46D = N46.d(C17784nZ1.q(8));
            interfaceC22053ub1J.W(1158899094);
            boolean zD = interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Fl6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C9919am6.xa(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC16159ko0.a((SA2) objB, eVarB, false, m46D, c5947Ln0B, null, null, null, null, AbstractC19242q11.e(2004533985, true, new f(), interfaceC22053ub1J, 54), interfaceC22053ub1J, 805306368, 484);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Gl6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9919am6.ya(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void za(final java.util.List r24, java.lang.String r25, ir.nasim.InterfaceC22053ub1 r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9919am6.za(java.util.List, java.lang.String, ir.nasim.ub1, int, int):void");
    }

    /* renamed from: ir.nasim.am6$p */
    public static final class p implements InterfaceC4228Ef6 {
        p() {
        }

        @Override // ir.nasim.InterfaceC4228Ef6
        public void a(String str) {
            AbstractC13042fc3.i(str, "query");
        }

        @Override // ir.nasim.InterfaceC4228Ef6
        public void b() {
            C9919am6.this.ab().d.y(AbstractC15226jD5.dialog_container_new);
            BaleToolbar baleToolbar = C9919am6.this.ab().d;
            FragmentActivity fragmentActivityQ7 = C9919am6.this.Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        }

        @Override // ir.nasim.InterfaceC4228Ef6
        public void d(String str) {
            AbstractC13042fc3.i(str, "query");
            C9919am6.this.fb().a1(str);
            C9919am6.this.getSearchQuery().setValue(str);
        }

        @Override // ir.nasim.InterfaceC4228Ef6
        public void c() {
        }
    }
}
