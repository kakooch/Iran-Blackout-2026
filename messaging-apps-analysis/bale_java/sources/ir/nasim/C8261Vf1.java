package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC16080kg1;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C8261Vf1;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.O98;
import ir.nasim.OA2;
import ir.nasim.XL4;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 q2\u00020\u0001:\u0001rB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J%\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u0013\u0010\u001d\u001a\u00020\u0004*\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0003J+\u0010)\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002¢\u0006\u0004\b+\u0010,J\u001d\u0010-\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002¢\u0006\u0004\b-\u0010,J\u000f\u0010/\u001a\u00020.H\u0003¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00042\u0006\u0010 \u001a\u000201H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\tH\u0002¢\u0006\u0004\b4\u00105J+\u0010=\u001a\u00020<2\u0006\u00107\u001a\u0002062\b\u00109\u001a\u0004\u0018\u0001082\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b=\u0010>J!\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020<2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\tH\u0016¢\u0006\u0004\bB\u00105R\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010RR\"\u0010[\u001a\u00020T8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010c\u001a\u00020\\8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010k\u001a\u00020d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010p\u001a\u0010\u0012\f\u0012\n m*\u0004\u0018\u00010.0.0l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010o¨\u0006s²\u0006\u0012\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/Vf1;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "Fa", "Da", "Ra", "Ca", "", "isEmptyQuery", "", "Lir/nasim/wY;", "selectedContact", "pa", "(ZLjava/util/List;Lir/nasim/ub1;I)V", "Lir/nasim/Wp4;", "navController", "ka", "(ZLir/nasim/Wp4;Ljava/util/List;Lir/nasim/ub1;I)V", "Lir/nasim/sx3;", "lazyPagingItems", "ga", "(Lir/nasim/sx3;Lir/nasim/ub1;I)V", "ia", "(Ljava/util/List;Lir/nasim/ub1;I)V", "Oa", "ab", "Lir/nasim/components/appbar/view/BaleToolbar;", "Pa", "(Lir/nasim/components/appbar/view/BaleToolbar;)V", "", "it", "isGroup", "createGroup", "Va", "(IZZ)V", "Ea", "Lkotlin/Function0;", "makeGroupWithoutMember", "permissionGrant", "bb", "(Lir/nasim/SA2;Lir/nasim/SA2;)V", "Ya", "(Lir/nasim/SA2;)V", "cb", "", "Ka", "(Lir/nasim/ub1;I)Ljava/lang/String;", "Landroid/app/Dialog;", "Xa", "(Landroid/app/Dialog;)V", "Na", "()Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "a", "Lir/nasim/Lx2;", "h1", "Lir/nasim/bW7;", "Ha", "()Lir/nasim/Lx2;", "binding", "Lir/nasim/Eg1;", "i1", "Lir/nasim/Yu3;", "Ma", "()Lir/nasim/Eg1;", "viewModel", "Lir/nasim/n10;", "j1", "La", "()Lir/nasim/n10;", "snackBar", "Lir/nasim/dQ0;", "k1", "Lir/nasim/dQ0;", "Ia", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "Lir/nasim/ae3;", "l1", "Lir/nasim/ae3;", "Ja", "()Lir/nasim/ae3;", "setInviteNavigator", "(Lir/nasim/ae3;)V", "inviteNavigator", "Lir/nasim/yb;", "m1", "Lir/nasim/yb;", "Ga", "()Lir/nasim/yb;", "setAdminsAccessFragmentNavigator", "(Lir/nasim/yb;)V", "adminsAccessFragmentNavigator", "Lir/nasim/v6;", "kotlin.jvm.PlatformType", "n1", "Lir/nasim/v6;", "requestPermissionLauncher", "o1", "b", "contact_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Vf1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8261Vf1 extends AbstractC13603gW2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new r(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: j1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 snackBar;

    /* renamed from: k1, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: l1, reason: from kotlin metadata */
    public InterfaceC9836ae3 inviteNavigator;

    /* renamed from: m1, reason: from kotlin metadata */
    public InterfaceC24417yb adminsAccessFragmentNavigator;

    /* renamed from: n1, reason: from kotlin metadata */
    private final AbstractC22357v6 requestPermissionLauncher;
    static final /* synthetic */ InterfaceC5239Im3[] p1 = {AbstractC10882cM5.i(new C25226zw5(C8261Vf1.class, "binding", "getBinding()Lir/nasim/contact/databinding/FragmentContactListSelectionBinding;", 0))};

    /* renamed from: o1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q1 = 8;

    /* renamed from: ir.nasim.Vf1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C20996sx3 c;
        final /* synthetic */ C8261Vf1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C20996sx3 c20996sx3, C8261Vf1 c8261Vf1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c20996sx3;
            this.d = c8261Vf1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (AbstractC13042fc3.d(this.c.i().d(), AbstractC13460gG3.b.b)) {
                this.d.Ma().S2(new AbstractC17858ng6.a(false, true, false, 5, null));
            } else {
                this.d.Ma().S2(new AbstractC17858ng6.a(false, false, false, 5, null));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vf1$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C8261Vf1 a(String str, String str2, String str3, String str4, ZN2 zn2, PM2 pm2, EnumC6357Ng1 enumC6357Ng1, Integer num, boolean z, boolean z2, Integer num2, boolean z3, List list) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(zn2, "groupType");
            AbstractC13042fc3.i(enumC6357Ng1, "contactSelectionType");
            AbstractC13042fc3.i(list, "groupMembers");
            C8261Vf1 c8261Vf1 = new C8261Vf1();
            c8261Vf1.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("groupTitle", str), AbstractC4616Fw7.a("groupDescription", str2), AbstractC4616Fw7.a("channelId", str3), AbstractC4616Fw7.a("avatarPath", str4), AbstractC4616Fw7.a("groupTypeKey", zn2), AbstractC4616Fw7.a("groupRestriction", pm2), AbstractC4616Fw7.a("contactSelectionType", enumC6357Ng1), AbstractC4616Fw7.a("groupIdArg", num), AbstractC4616Fw7.a("amIAdminArg", Boolean.valueOf(z)), AbstractC4616Fw7.a("AmIOwnerArg", Boolean.valueOf(z2)), AbstractC4616Fw7.a("MEMBER_COUNT", num2), AbstractC4616Fw7.a("OPEN_FROM_CHAT", Boolean.valueOf(z3)), AbstractC4616Fw7.a("MEMBER_LIST_ARG", list)));
            return c8261Vf1;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Vf1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C9023Yd6 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C9023Yd6 c9023Yd6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c9023Yd6;
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
                C9023Yd6 c9023Yd6 = this.c;
                int iN = c9023Yd6.n();
                this.b = 1;
                if (C9023Yd6.l(c9023Yd6, iN, null, this, 2, null) == objE) {
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

    /* renamed from: ir.nasim.Vf1$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ List a;
        final /* synthetic */ C8261Vf1 b;

        d(List list, C8261Vf1 c8261Vf1) {
            this.a = list;
            this.b = c8261Vf1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8261Vf1 c8261Vf1, C23209wY c23209wY) {
            AbstractC13042fc3.i(c8261Vf1, "this$0");
            AbstractC13042fc3.i(c23209wY, "it");
            c8261Vf1.Ma().P2(c23209wY);
            return C19938rB7.a;
        }

        public final void b(InterfaceC16782lr2 interfaceC16782lr2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC16782lr2, "$this$FlowRow");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            List list = this.a;
            interfaceC22053ub1.W(130116561);
            boolean zD = interfaceC22053ub1.D(this.b);
            final C8261Vf1 c8261Vf1 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Wf1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8261Vf1.d.c(c8261Vf1, (C23209wY) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC8513Wh1.b(list, (UA2) objB, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC16782lr2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vf1$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C20996sx3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C20996sx3 c20996sx3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c20996sx3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8261Vf1.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C4232Eg1 c4232Eg1Ma = C8261Vf1.this.Ma();
            C11066cg3<C23209wY> c11066cg3H = this.d.h();
            ArrayList arrayList = new ArrayList();
            for (C23209wY c23209wY : c11066cg3H) {
                Integer numD = c23209wY != null ? AbstractC6392Nk0.d(c23209wY.a()) : null;
                if (numD != null) {
                    arrayList.add(numD);
                }
            }
            c4232Eg1Ma.P1(arrayList);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vf1$f */
    static final class f implements InterfaceC15796kB2 {
        final /* synthetic */ List b;

        f(List list) {
            this.b = list;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C8261Vf1.this.ia(this.b, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vf1$g */
    /* synthetic */ class g extends EB2 implements UA2 {
        g(Object obj) {
            super(1, obj, C4232Eg1.class, "selectOrRemoveContact", "selectOrRemoveContact(Lir/nasim/contact/contactlistselection/model/BaleContactItem;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((C23209wY) obj);
            return C19938rB7.a;
        }

        public final void y(C23209wY c23209wY) {
            AbstractC13042fc3.i(c23209wY, "p0");
            ((C4232Eg1) this.receiver).P2(c23209wY);
        }
    }

    /* renamed from: ir.nasim.Vf1$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8261Vf1.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C8261Vf1.this.Ma().E2();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vf1$i */
    static final class i implements InterfaceC15796kB2 {
        final /* synthetic */ List b;

        i(List list) {
            this.b = list;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C8261Vf1.this.ia(this.b, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vf1$j */
    /* synthetic */ class j extends EB2 implements UA2 {
        j(Object obj) {
            super(1, obj, C4232Eg1.class, "selectOrRemoveContact", "selectOrRemoveContact(Lir/nasim/contact/contactlistselection/model/BaleContactItem;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((C23209wY) obj);
            return C19938rB7.a;
        }

        public final void y(C23209wY c23209wY) {
            AbstractC13042fc3.i(c23209wY, "p0");
            ((C4232Eg1) this.receiver).P2(c23209wY);
        }
    }

    /* renamed from: ir.nasim.Vf1$k */
    public /* synthetic */ class k {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC6357Ng1.values().length];
            try {
                iArr[EnumC6357Ng1.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC6357Ng1.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC6357Ng1.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Vf1$l */
    static final class l implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Vf1$l$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C8261Vf1 a;

            /* renamed from: ir.nasim.Vf1$l$a$a, reason: collision with other inner class name */
            static final class C0707a implements InterfaceC16978mB2 {
                final /* synthetic */ C8261Vf1 a;
                final /* synthetic */ boolean b;
                final /* synthetic */ C8588Wp4 c;
                final /* synthetic */ InterfaceC9664aL6 d;

                C0707a(C8261Vf1 c8261Vf1, boolean z, C8588Wp4 c8588Wp4, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = c8261Vf1;
                    this.b = z;
                    this.c = c8588Wp4;
                    this.d = interfaceC9664aL6;
                }

                public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    this.a.ka(this.b, this.c, a.h(this.d), interfaceC22053ub1, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Vf1$l$a$b */
            static final class b implements InterfaceC16978mB2 {
                final /* synthetic */ C8261Vf1 a;
                final /* synthetic */ boolean b;
                final /* synthetic */ InterfaceC9664aL6 c;

                b(C8261Vf1 c8261Vf1, boolean z, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = c8261Vf1;
                    this.b = z;
                    this.c = interfaceC9664aL6;
                }

                public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    this.a.pa(this.b, a.h(this.c), interfaceC22053ub1, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            a(C8261Vf1 c8261Vf1) {
                this.a = c8261Vf1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final List h(InterfaceC9664aL6 interfaceC9664aL6) {
                return (List) interfaceC9664aL6.getValue();
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
            public static final C19938rB7 n(C8261Vf1 c8261Vf1, boolean z, C8588Wp4 c8588Wp4, InterfaceC9664aL6 interfaceC9664aL6, C8120Up4 c8120Up4) {
                AbstractC13042fc3.i(c8261Vf1, "this$0");
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                AbstractC13042fc3.i(interfaceC9664aL6, "$selectedContact$delegate");
                AbstractC13042fc3.i(c8120Up4, "$this$NavHost");
                AbstractC8354Vp4.c(c8120Up4, AbstractC16080kg1.a.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(1847540459, true, new C0707a(c8261Vf1, z, c8588Wp4, interfaceC9664aL6)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC16080kg1.b.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1171758174, true, new b(c8261Vf1, z, interfaceC9664aL6)), 126, null);
                return C19938rB7.a;
            }

            public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(this.a.Ma().s2(), null, null, null, interfaceC22053ub1, 0, 7);
                final boolean z = true;
                CharSequence charSequence = (CharSequence) AbstractC10222bH6.b(this.a.Ma().p2(), null, interfaceC22053ub1, 0, 1).getValue();
                if (charSequence != null && charSequence.length() != 0) {
                    z = false;
                }
                final C8588Wp4 c8588Wp4E = AbstractC8854Xp4.e(new androidx.navigation.p[0], interfaceC22053ub1, 0);
                String strA = AbstractC16080kg1.a.a.a();
                UA2 ua2E = AbstractC8216Va1.e(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-1917241139);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = new UA2() { // from class: ir.nasim.Xf1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8261Vf1.l.a.i((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-1917239154);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.Yf1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8261Vf1.l.a.k((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                UA2 ua2H = AbstractC8216Va1.h(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-1917235562);
                boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.a(z) | interfaceC22053ub1.D(c8588Wp4E) | interfaceC22053ub1.V(interfaceC9664aL6C);
                final C8261Vf1 c8261Vf1 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD || objB3 == aVar.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.Zf1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8261Vf1.l.a.n(c8261Vf1, z, c8588Wp4E, interfaceC9664aL6C, (C8120Up4) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC9129Yp4.b(c8588Wp4E, strA, null, null, null, ua2E, ua2, ua22, ua2H, (UA2) objB3, interfaceC22053ub1, 14155824, 28);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
                f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        l() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-195933943, true, new a(C8261Vf1.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vf1$m */
    static final class m implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Vf1$m$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C8261Vf1 a;

            /* renamed from: ir.nasim.Vf1$m$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0708a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC6357Ng1.values().length];
                    try {
                        iArr[EnumC6357Ng1.a.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC6357Ng1.b.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnumC6357Ng1.c.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            a(C8261Vf1 c8261Vf1) {
                this.a = c8261Vf1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(boolean z, final C8261Vf1 c8261Vf1) {
                AbstractC13042fc3.i(c8261Vf1, "this$0");
                if (!z) {
                    int i = C0708a.a[c8261Vf1.Ma().a2().ordinal()];
                    if (i == 1) {
                        c8261Vf1.Ma().K1(new UA2() { // from class: ir.nasim.bg1
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8261Vf1.m.a.h(c8261Vf1, ((Integer) obj).intValue());
                            }
                        });
                    } else if (i == 2) {
                        c8261Vf1.Ra();
                    } else {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        C4232Eg1.H2(c8261Vf1.Ma(), false, new UA2() { // from class: ir.nasim.cg1
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8261Vf1.m.a.i(c8261Vf1, ((Integer) obj).intValue());
                            }
                        }, 1, null);
                    }
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(C8261Vf1 c8261Vf1, int i) {
                AbstractC13042fc3.i(c8261Vf1, "this$0");
                C8261Vf1.Wa(c8261Vf1, i, c8261Vf1.Ma().g2() == ZN2.GROUP, false, 4, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(C8261Vf1 c8261Vf1, int i) {
                AbstractC13042fc3.i(c8261Vf1, "this$0");
                c8261Vf1.Va(i, c8261Vf1.Ma().g2() == ZN2.GROUP, true);
                return C19938rB7.a;
            }

            public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                InterfaceC19114po0 interfaceC19114po0;
                final C8261Vf1 c8261Vf1;
                String strH6;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
                G10 g10 = G10.a;
                int i2 = G10.b;
                androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarH, g10.a(interfaceC22053ub1, i2).r(), null, 2, null);
                C8261Vf1 c8261Vf12 = this.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
                final boolean zBooleanValue = ((Boolean) AbstractC10222bH6.b(c8261Vf12.Ma().j2(), null, interfaceC22053ub1, 0, 1).getValue()).booleanValue();
                androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i2).b().c()), 0.0f, 1, null);
                interfaceC22053ub1.W(75092526);
                if (zBooleanValue) {
                    interfaceC19114po0 = OA2.a.b;
                } else {
                    interfaceC22053ub1.W(75096365);
                    boolean z = (c8261Vf12.Ma().a2() == EnumC6357Ng1.a || c8261Vf12.Ma().a2() == EnumC6357Ng1.b) && ((List) AbstractC10222bH6.b(c8261Vf12.Ma().s2(), null, interfaceC22053ub1, 0, 1).getValue()).isEmpty();
                    interfaceC22053ub1.Q();
                    interfaceC19114po0 = z ? InterfaceC19114po0.a.C1453a.a : InterfaceC19114po0.b.a.a;
                }
                interfaceC22053ub1.Q();
                int i3 = C0708a.a[c8261Vf12.Ma().a2().ordinal()];
                if (i3 == 1) {
                    c8261Vf1 = c8261Vf12;
                    strH6 = c8261Vf1.h6(AbstractC12217eE5.group_add_title);
                } else if (i3 == 2) {
                    c8261Vf1 = c8261Vf12;
                    strH6 = c8261Vf1.h6(AbstractC12217eE5.contact_picker_group_add_admin);
                } else {
                    if (i3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (c8261Vf12.Ma().g2() == ZN2.GROUP) {
                        c8261Vf1 = c8261Vf12;
                        strH6 = c8261Vf1.h6(AbstractC12217eE5.create_group_title);
                    } else {
                        c8261Vf1 = c8261Vf12;
                        strH6 = c8261Vf1.h6(AbstractC12217eE5.create_channel_title);
                    }
                }
                String str = strH6;
                AbstractC13042fc3.f(str);
                interfaceC22053ub1.W(75065206);
                boolean zA = interfaceC22053ub1.a(zBooleanValue) | interfaceC22053ub1.D(c8261Vf1);
                Object objB = interfaceC22053ub1.B();
                if (zA || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.ag1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C8261Vf1.m.a.f(zBooleanValue, c8261Vf1);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC17932no0.y(eVarH2, (SA2) objB, interfaceC19114po0, null, str, "COMPOSE_NODE_LIST_SELECTION_CONFIRM_BUTTON_TAG", interfaceC22053ub1, 196608, 8);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        m() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-399769603, true, new a(C8261Vf1.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vf1$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Vf1$n$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C8261Vf1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8261Vf1 c8261Vf1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c8261Vf1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
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
                this.d.La().o((String) this.c);
                this.d.Ma().I2();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8261Vf1.this.new n(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(C8261Vf1.this.Ma().t2());
                a aVar = new a(C8261Vf1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2F, aVar, this) == objE) {
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
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vf1$o */
    static final class o implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Vf1$o$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;
            final /* synthetic */ C8261Vf1 b;

            /* renamed from: ir.nasim.Vf1$o$a$a, reason: collision with other inner class name */
            static final class C0709a implements InterfaceC14603iB2 {
                final /* synthetic */ String a;
                final /* synthetic */ C8261Vf1 b;

                /* renamed from: ir.nasim.Vf1$o$a$a$a, reason: collision with other inner class name */
                static final class C0710a implements InterfaceC14603iB2 {
                    final /* synthetic */ String a;
                    final /* synthetic */ C8261Vf1 b;

                    /* renamed from: ir.nasim.Vf1$o$a$a$a$a, reason: collision with other inner class name */
                    static final class C0711a implements InterfaceC14603iB2 {
                        final /* synthetic */ String a;
                        final /* synthetic */ C8261Vf1 b;

                        /* renamed from: ir.nasim.Vf1$o$a$a$a$a$a, reason: collision with other inner class name */
                        /* synthetic */ class C0712a extends EB2 implements UA2 {
                            C0712a(Object obj) {
                                super(1, obj, C4232Eg1.class, "setQuery", "setQuery(Ljava/lang/String;)V", 0);
                            }

                            @Override // ir.nasim.UA2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                y((String) obj);
                                return C19938rB7.a;
                            }

                            public final void y(String str) {
                                ((C4232Eg1) this.receiver).R2(str);
                            }
                        }

                        /* renamed from: ir.nasim.Vf1$o$a$a$a$a$b */
                        /* synthetic */ class b extends EB2 implements UA2 {
                            b(Object obj) {
                                super(1, obj, C4232Eg1.class, "setStateForSearch", "setStateForSearch(Lir/nasim/components/appbar/searchbar/SearchFocusState;)V", 0);
                            }

                            @Override // ir.nasim.UA2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                y((AbstractC17858ng6) obj);
                                return C19938rB7.a;
                            }

                            public final void y(AbstractC17858ng6 abstractC17858ng6) {
                                AbstractC13042fc3.i(abstractC17858ng6, "p0");
                                ((C4232Eg1) this.receiver).S2(abstractC17858ng6);
                            }
                        }

                        C0711a(String str, C8261Vf1 c8261Vf1) {
                            this.a = str;
                            this.b = c8261Vf1;
                        }

                        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                                interfaceC22053ub1.L();
                                return;
                            }
                            String strC = UY6.c(AbstractC12217eE5.search_hint_chat, interfaceC22053ub1, 0);
                            String str = this.a;
                            if (str == null) {
                                str = "";
                            }
                            String str2 = str;
                            C4232Eg1 c4232Eg1Ma = this.b.Ma();
                            interfaceC22053ub1.W(-303202851);
                            boolean zD = interfaceC22053ub1.D(c4232Eg1Ma);
                            Object objB = interfaceC22053ub1.B();
                            if (zD || objB == InterfaceC22053ub1.a.a()) {
                                objB = new C0712a(c4232Eg1Ma);
                                interfaceC22053ub1.s(objB);
                            }
                            InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB;
                            interfaceC22053ub1.Q();
                            C4232Eg1 c4232Eg1Ma2 = this.b.Ma();
                            interfaceC22053ub1.W(-303196058);
                            boolean zD2 = interfaceC22053ub1.D(c4232Eg1Ma2);
                            Object objB2 = interfaceC22053ub1.B();
                            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                                objB2 = new b(c4232Eg1Ma2);
                                interfaceC22053ub1.s(objB2);
                            }
                            interfaceC22053ub1.Q();
                            AbstractC17858ng6 abstractC17858ng6 = (AbstractC17858ng6) AbstractC10222bH6.a(this.b.Ma().r2(), AbstractC17858ng6.b.b, null, interfaceC22053ub1, AbstractC17858ng6.b.c << 3, 2).getValue();
                            AbstractC16075kf6.j(strC, str2, (UA2) interfaceC16733lm3, true, (UA2) ((InterfaceC16733lm3) objB2), abstractC17858ng6, true, null, null, null, null, interfaceC22053ub1, (AbstractC17858ng6.a << 15) | 1575936, 0, 1920);
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                            return C19938rB7.a;
                        }
                    }

                    C0710a(String str, C8261Vf1 c8261Vf1) {
                        this.a = str;
                        this.b = c8261Vf1;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1, G10.b).b().u(), 0.0f, 2, null);
                        InterfaceC12529em interfaceC12529emE = InterfaceC12529em.a.e();
                        String str = this.a;
                        C8261Vf1 c8261Vf1 = this.b;
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
                        AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(1226094976, true, new C0711a(str, c8261Vf1), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                        interfaceC22053ub1.u();
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Vf1$o$a$a$b */
                static final class b implements InterfaceC14603iB2 {
                    final /* synthetic */ C8261Vf1 a;

                    b(C8261Vf1 c8261Vf1) {
                        this.a = c8261Vf1;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(C8261Vf1 c8261Vf1) {
                        AbstractC13042fc3.i(c8261Vf1, "this$0");
                        c8261Vf1.a();
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
                        final C8261Vf1 c8261Vf1 = this.a;
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
                        androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j());
                        interfaceC22053ub1.W(1085132222);
                        boolean zD = interfaceC22053ub1.D(c8261Vf1);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.dg1
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C8261Vf1.o.a.C0709a.b.c(c8261Vf1);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC24077y03.b(C02.e(new SV(false), interfaceC22053ub1, 0), UY6.c(AbstractC12217eE5.submit_return, interfaceC22053ub1, 0), androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null), g10.a(interfaceC22053ub1, i2).G(), interfaceC22053ub1, 0, 0);
                        interfaceC22053ub1.u();
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C0709a(String str, C8261Vf1 c8261Vf1) {
                    this.a = str;
                    this.b = c8261Vf1;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    A98 a98A = AbstractC21393ta8.a(0, 0, 0, 0);
                    androidx.compose.ui.e eVarB = androidx.compose.foundation.layout.t.b(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(56), 1, null);
                    C17388ms7 c17388ms7A = C17979ns7.a.a(interfaceC22053ub1, C17979ns7.g);
                    ED.a(AbstractC19242q11.e(1354638726, true, new C0710a(this.a, this.b), interfaceC22053ub1, 54), eVarB, AbstractC19242q11.e(1977420868, true, new b(this.b), interfaceC22053ub1, 54), null, 0.0f, a98A, c17388ms7A.b((30 & 1) != 0 ? c17388ms7A.a : G10.a.a(interfaceC22053ub1, G10.b).q(), (30 & 2) != 0 ? c17388ms7A.b : 0L, (30 & 4) != 0 ? c17388ms7A.c : 0L, (30 & 8) != 0 ? c17388ms7A.d : 0L, (30 & 16) != 0 ? c17388ms7A.e : 0L), null, interfaceC22053ub1, 438, 152);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(String str, C8261Vf1 c8261Vf1) {
                this.a = str;
                this.b = c8261Vf1;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-1052755701, true, new C0709a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        o() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-215570997, true, new a((String) AbstractC10222bH6.b(C8261Vf1.this.Ma().p2(), null, interfaceC22053ub1, 0, 1).getValue(), C8261Vf1.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vf1$p */
    static final class p implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 b;

        /* renamed from: ir.nasim.Vf1$p$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C8261Vf1 a;

            a(C8261Vf1 c8261Vf1) {
                this.a = c8261Vf1;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a.Ka(interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        p(SA2 sa2) {
            this.b = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C8261Vf1 c8261Vf1) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(c8261Vf1, "this$0");
            dialog.dismiss();
            c8261Vf1.requestPermissionLauncher.a("android.permission.READ_CONTACTS");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C8261Vf1 c8261Vf1, SA2 sa2, Dialog dialog) {
            AbstractC13042fc3.i(c8261Vf1, "this$0");
            AbstractC13042fc3.i(sa2, "$makeGroupWithoutMember");
            AbstractC13042fc3.i(dialog, "$it");
            if (c8261Vf1.Ma().a2() == EnumC6357Ng1.c) {
                sa2.invoke();
            }
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            String strC;
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC14603iB2 interfaceC14603iB2C = C22925w31.a.c();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1379158683, true, new a(C8261Vf1.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(152836635);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C8261Vf1.this);
            final C8261Vf1 c8261Vf1 = C8261Vf1.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.eg1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8261Vf1.p.d(dialog, c8261Vf1);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strC2 = UY6.c(AbstractC12217eE5.dialog_ok, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(152846929);
            boolean zD2 = interfaceC22053ub1.D(C8261Vf1.this) | interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(dialog);
            final C8261Vf1 c8261Vf12 = C8261Vf1.this;
            final SA2 sa22 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.fg1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8261Vf1.p.f(c8261Vf12, sa22, dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa23 = (SA2) objB2;
            interfaceC22053ub1.Q();
            if (C8261Vf1.this.Ma().a2() == EnumC6357Ng1.c) {
                interfaceC22053ub1.W(443622615);
                strC = AbstractC5969Lp4.a(UY6.c(AbstractC12217eE5.group_with_out_member, interfaceC22053ub1, 0), C8261Vf1.this.Ma().g2());
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(443750645);
                strC = UY6.c(AbstractC12217eE5.dialog_negative_button_cancel, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            }
            String str = strC;
            AbstractC13042fc3.f(str);
            AbstractC19555qZ.F(interfaceC14603iB2C, c0905b, interfaceC18060o11E, cVar, aVar, sa2, strC2, c1454b, sa23, str, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
            dialog.setCanceledOnTouchOutside(true);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vf1$q */
    static final class q implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 b;

        /* renamed from: ir.nasim.Vf1$q$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C8261Vf1 a;

            a(C8261Vf1 c8261Vf1) {
                this.a = c8261Vf1;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a.Ka(interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        q(SA2 sa2) {
            this.b = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C8261Vf1 c8261Vf1, Dialog dialog) {
            AbstractC13042fc3.i(c8261Vf1, "this$0");
            AbstractC13042fc3.i(dialog, "$it");
            c8261Vf1.Xa(dialog);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C8261Vf1 c8261Vf1, SA2 sa2, Dialog dialog) {
            AbstractC13042fc3.i(c8261Vf1, "this$0");
            AbstractC13042fc3.i(sa2, "$makeGroupWithoutMember");
            AbstractC13042fc3.i(dialog, "$it");
            if (c8261Vf1.Ma().a2() == EnumC6357Ng1.c) {
                sa2.invoke();
            }
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            String strC;
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC14603iB2 interfaceC14603iB2D = C22925w31.a.d();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1804398904, true, new a(C8261Vf1.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(712842395);
            boolean zD = interfaceC22053ub1.D(C8261Vf1.this) | interfaceC22053ub1.D(dialog);
            final C8261Vf1 c8261Vf1 = C8261Vf1.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.gg1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8261Vf1.q.d(c8261Vf1, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strC2 = UY6.c(AbstractC12217eE5.permission_go_to_settings, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(712849450);
            boolean zD2 = interfaceC22053ub1.D(C8261Vf1.this) | interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(dialog);
            final C8261Vf1 c8261Vf12 = C8261Vf1.this;
            final SA2 sa22 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.hg1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8261Vf1.q.f(c8261Vf12, sa22, dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa23 = (SA2) objB2;
            interfaceC22053ub1.Q();
            if (C8261Vf1.this.Ma().a2() == EnumC6357Ng1.c) {
                interfaceC22053ub1.W(623831582);
                strC = AbstractC5969Lp4.a(UY6.c(AbstractC12217eE5.group_with_out_member, interfaceC22053ub1, 0), C8261Vf1.this.Ma().g2());
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(623959612);
                strC = UY6.c(AbstractC12217eE5.dialog_negative_button_cancel, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            }
            String str = strC;
            AbstractC13042fc3.f(str);
            AbstractC19555qZ.F(interfaceC14603iB2D, c0905b, interfaceC18060o11E, cVar, aVar, sa2, strC2, c1454b, sa23, str, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
            dialog.setCanceledOnTouchOutside(true);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Vf1$r */
    public static final class r extends AbstractC8614Ws3 implements UA2 {
        public r() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C6038Lx2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Vf1$s */
    public static final class s extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Vf1$t */
    public static final class t extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Vf1$u */
    public static final class u extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Vf1$v */
    public static final class v extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Vf1$w */
    public static final class w extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C8261Vf1() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new t(new s(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C4232Eg1.class), new u(interfaceC9173Yu3B), new v(null, interfaceC9173Yu3B), new w(this, interfaceC9173Yu3B));
        this.snackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.If1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8261Vf1.db(this.a);
            }
        });
        AbstractC22357v6 abstractC22357v6N7 = N7(new C19881r6(), new InterfaceC17517n6() { // from class: ir.nasim.Jf1
            @Override // ir.nasim.InterfaceC17517n6
            public final void a(Object obj) {
                C8261Vf1.Za(this.a, (Boolean) obj);
            }
        });
        AbstractC13042fc3.h(abstractC22357v6N7, "registerForActivityResult(...)");
        this.requestPermissionLauncher = abstractC22357v6N7;
    }

    private final void Ca() {
        Ha().d.setContent(AbstractC19242q11.c(-651885276, true, new l()));
    }

    private final void Da() {
        ComposeView composeView = Ha().e;
        AbstractC13042fc3.f(composeView);
        composeView.setVisibility(0);
        composeView.setContent(AbstractC19242q11.c(1857894040, true, new m()));
    }

    private final void Ea() {
        Fragment fragmentP0 = V5().p0("GroupTypeMakerFragment");
        if (fragmentP0 != null) {
            l9(fragmentP0, true);
        }
        l9(this, true);
    }

    private final void Fa() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new n(null), 3, null);
    }

    private final C6038Lx2 Ha() {
        Object objA = this.binding.a(this, p1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C6038Lx2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Ka(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        String strC;
        interfaceC22053ub1.W(1816174491);
        int i3 = k.a[Ma().a2().ordinal()];
        if (i3 == 1) {
            interfaceC22053ub1.W(932368623);
            strC = UY6.c(AbstractC12217eE5.contact_permission_add_modal_desc, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (i3 == 2) {
            interfaceC22053ub1.W(932372015);
            strC = UY6.c(AbstractC12217eE5.contact_permission_add_admin_desc, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else {
            if (i3 != 3) {
                interfaceC22053ub1.W(932366372);
                interfaceC22053ub1.Q();
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1.W(932376224);
            strC = AbstractC5969Lp4.a(UY6.c(AbstractC12217eE5.contact_permission_modal_desc, interfaceC22053ub1, 0), Ma().g2());
            AbstractC13042fc3.h(strC, "formatGroupType(...)");
            interfaceC22053ub1.Q();
        }
        interfaceC22053ub1.Q();
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17468n10 La() {
        return (C17468n10) this.snackBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4232Eg1 Ma() {
        return (C4232Eg1) this.viewModel.getValue();
    }

    private final boolean Na() {
        return AbstractC4043Dl1.a(S7(), "android.permission.READ_CONTACTS") == 0;
    }

    private final void Oa() {
        AbstractC19329q98.a(Q7().getWindow(), Ha().d).a(O98.m.d());
    }

    private final void Pa(BaleToolbar baleToolbar) {
        Ha().c.setVisibility(8);
        baleToolbar.y(AbstractC13435gD5.context_menu_selection_list);
        ComposeView composeView = Ha().c;
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-273135194, true, new o()));
        composeView.h();
        baleToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.Hf1
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return C8261Vf1.Qa(this.a, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Qa(C8261Vf1 c8261Vf1, MenuItem menuItem) {
        AbstractC13042fc3.i(c8261Vf1, "this$0");
        if (menuItem.getItemId() != AbstractC10176bC5.search_contacts) {
            return false;
        }
        c8261Vf1.Ha().c.setVisibility(0);
        c8261Vf1.Ha().c.g();
        c8261Vf1.Ha().f.setVisibility(8);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ra() {
        Ea();
        Integer numC2 = Ma().c2();
        Iterable iterable = (Iterable) Ma().s2().getValue();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((C23209wY) it.next()).a()));
        }
        Integer num = (Integer) AbstractC15401jX0.s0(arrayList);
        if (numC2 == null || num == null) {
            C19406qI3.b("ContactListSelectionFragment", "onAddAdminClicked return because groupId: " + numC2 + " or selectedPeerId: " + num + " is null");
            return;
        }
        InterfaceC24417yb interfaceC24417ybGa = Ga();
        Iterable iterable2 = (Iterable) Ma().s2().getValue();
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(iterable2, 10));
        Iterator it2 = iterable2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(((C23209wY) it2.next()).a()));
        }
        C22042ua0.A9(this, interfaceC24417ybGa.a(((Number) AbstractC15401jX0.q0(arrayList2)).intValue(), numC2.intValue(), true, null, Ma().W1()), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Sa(final C8261Vf1 c8261Vf1) {
        AbstractC13042fc3.i(c8261Vf1, "this$0");
        c8261Vf1.Ma().G2(true, new UA2() { // from class: ir.nasim.Mf1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8261Vf1.Ta(this.a, ((Integer) obj).intValue());
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ta(C8261Vf1 c8261Vf1, int i2) {
        AbstractC13042fc3.i(c8261Vf1, "this$0");
        c8261Vf1.Va(i2, c8261Vf1.Ma().g2() == ZN2.GROUP, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ua(C8261Vf1 c8261Vf1) {
        AbstractC13042fc3.i(c8261Vf1, "this$0");
        c8261Vf1.Ma().N2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Va(int it, boolean isGroup, boolean createGroup) {
        Fragment fragmentB;
        Ea();
        if (Ma().l2()) {
            List listC0 = V5().C0();
            List listC02 = V5().C0();
            AbstractC13042fc3.h(listC02, "getFragments(...)");
            Object obj = listC0.get(AbstractC10360bX0.o(listC02) - 1);
            AbstractC13042fc3.h(obj, "get(...)");
            l9((Fragment) obj, true);
        }
        if (isGroup) {
            InterfaceC11677dQ0 interfaceC11677dQ0Ia = Ia();
            C11458d25 c11458d25Y = C11458d25.y(it);
            AbstractC13042fc3.h(c11458d25Y, "group(...)");
            ExPeerType exPeerType = Ma().g2() == ZN2.GROUP ? ExPeerType.GROUP : ExPeerType.CHANNEL;
            String strB = ((C11046ce3) Ma().h2().getValue()).b();
            List listC = ((C11046ce3) Ma().h2().getValue()).c();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listC, 10));
            Iterator it2 = listC.iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(((C11458d25) it2.next()).getPeerId()));
            }
            fragmentB = InterfaceC11677dQ0.b(interfaceC11677dQ0Ia, c11458d25Y, exPeerType, null, null, false, null, null, null, null, 0L, null, null, null, false, null, null, null, strB, arrayList, createGroup && Ma().g2() == ZN2.GROUP, null, null, null, null, null, false, null, 133300220, null);
        } else {
            InterfaceC11677dQ0 interfaceC11677dQ0Ia2 = Ia();
            C11458d25 c11458d25Y2 = C11458d25.y(it);
            AbstractC13042fc3.h(c11458d25Y2, "group(...)");
            fragmentB = InterfaceC11677dQ0.b(interfaceC11677dQ0Ia2, c11458d25Y2, Ma().g2() == ZN2.GROUP ? ExPeerType.GROUP : ExPeerType.CHANNEL, null, null, false, null, null, null, null, 0L, null, null, null, false, null, null, null, null, null, false, null, null, null, null, null, false, null, 134217724, null);
        }
        C22042ua0.A9(this, fragmentB, false, null, 6, null);
    }

    static /* synthetic */ void Wa(C8261Vf1 c8261Vf1, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        c8261Vf1.Va(i2, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xa(Dialog it) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", Q7().getPackageName(), null));
        it.dismiss();
        n8(intent);
    }

    private final void Ya(SA2 makeGroupWithoutMember) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(1218699453, true, new p(makeGroupWithoutMember)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Za(C8261Vf1 c8261Vf1, Boolean bool) {
        AbstractC13042fc3.i(c8261Vf1, "this$0");
        AbstractC13042fc3.i(bool, "isGranted");
        if (bool.booleanValue()) {
            c8261Vf1.Ma().N2();
        }
    }

    private final void ab() {
        String strH6;
        BaleToolbar baleToolbar = Ha().f;
        int i2 = k.a[Ma().a2().ordinal()];
        if (i2 == 1) {
            strH6 = h6(AbstractC12217eE5.group_add_title);
        } else if (i2 == 2) {
            strH6 = h6(AbstractC12217eE5.contact_picker_group_add_admin);
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            strH6 = h6(Ma().g2() == ZN2.GROUP ? AbstractC12217eE5.create_group : AbstractC12217eE5.create_channel);
        }
        baleToolbar.setTitle(strH6);
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        AbstractC13042fc3.f(baleToolbar);
        Pa(baleToolbar);
    }

    private final void bb(SA2 makeGroupWithoutMember, SA2 permissionGrant) {
        if (Na()) {
            permissionGrant.invoke();
        } else if (X5.z(Q7(), "android.permission.READ_CONTACTS")) {
            cb(makeGroupWithoutMember);
        } else {
            Ya(makeGroupWithoutMember);
        }
    }

    private final void cb(SA2 makeGroupWithoutMember) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(1627564902, true, new q(makeGroupWithoutMember)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 db(C8261Vf1 c8261Vf1) {
        AbstractC13042fc3.i(c8261Vf1, "this$0");
        ComposeView composeView = c8261Vf1.Ha().d;
        AbstractC13042fc3.h(composeView, "composeView");
        return new C17468n10(composeView, c8261Vf1.Ha().e, 0, 4, null);
    }

    private final void ga(final C20996sx3 c20996sx3, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1665856916);
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? interfaceC22053ub1J.V(c20996sx3) : interfaceC22053ub1J.D(c20996sx3) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C13628gZ0 c13628gZ0I = c20996sx3.i();
            interfaceC22053ub1J.W(-1637367124);
            boolean zD = ((i3 & 14) == 4 || ((i3 & 8) != 0 && interfaceC22053ub1J.D(c20996sx3))) | interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c20996sx3, this, null);
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(c13628gZ0I, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Tf1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C8261Vf1.ha(this.a, c20996sx3, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ha(C8261Vf1 c8261Vf1, C20996sx3 c20996sx3, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c8261Vf1, "$tmp1_rcvr");
        AbstractC13042fc3.i(c20996sx3, "$lazyPagingItems");
        c8261Vf1.ga(c20996sx3, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia(final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1603017600);
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
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
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
            interfaceC22053ub1J.W(-1232885841);
            if (!list.isEmpty()) {
                C9023Yd6 c9023Yd6C = AbstractC8014Ud6.c(0, interfaceC22053ub1J, 0, 1);
                InterfaceC10258bL6 interfaceC10258bL6S2 = Ma().s2();
                interfaceC22053ub1J.W(-1232881864);
                boolean zV = interfaceC22053ub1J.V(c9023Yd6C);
                Object objB = interfaceC22053ub1J.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new c(c9023Yd6C, null);
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                AbstractC10721c52.e(interfaceC10258bL6S2, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 0);
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.t.k(aVar, 0.0f, C17784nZ1.q(104), 1, null), 0.0f, 1, null);
                G10 g10 = G10.a;
                int i4 = G10.b;
                AbstractC12582er2.b(AbstractC8014Ud6.g(androidx.compose.foundation.layout.q.k(eVarH, g10.c(interfaceC22053ub1J, i4).b().c(), 0.0f, 2, null), c9023Yd6C, true, null, false, 12, null), c24254yJ.g(), c24254yJ.h(), null, 0, 0, AbstractC19242q11.e(1111088202, true, new d(list, this), interfaceC22053ub1J, 54), interfaceC22053ub1J, 1573296, 56);
                ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1J, i4).A(), interfaceC22053ub1J, 6, 2);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Uf1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C8261Vf1.ja(this.a, list, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ja(C8261Vf1 c8261Vf1, List list, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c8261Vf1, "$tmp0_rcvr");
        AbstractC13042fc3.i(list, "$selectedContact");
        c8261Vf1.ia(list, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ka(final boolean z, final C8588Wp4 c8588Wp4, final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1791637143);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(c8588Wp4) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(list) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
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
            final C20996sx3 c20996sx3B = AbstractC21683tx3.b(Ma().o2(), null, interfaceC22053ub1J, 0, 1);
            ga(c20996sx3B, interfaceC22053ub1J, C20996sx3.f | ((i3 >> 6) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
            if ((c20996sx3B.i().d() instanceof AbstractC13460gG3.c) && c20996sx3B.i().a().a() && c20996sx3B.g() == 0) {
                interfaceC22053ub1J.W(1343433807);
                C72.b(z, false, interfaceC22053ub1J, i3 & 14, 2);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(1343588621);
                interfaceC22053ub1J.W(736076210);
                if (Ma().a2() == EnumC6357Ng1.a) {
                    C13628gZ0 c13628gZ0I = c20996sx3B.i();
                    interfaceC22053ub1J.W(736080377);
                    boolean zD = interfaceC22053ub1J.D(this) | interfaceC22053ub1J.D(c20996sx3B);
                    Object objB = interfaceC22053ub1J.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new e(c20996sx3B, null);
                        interfaceC22053ub1J.s(objB);
                    }
                    interfaceC22053ub1J.Q();
                    AbstractC10721c52.e(c13628gZ0I, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 0);
                }
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.W(736088476);
                boolean zD2 = interfaceC22053ub1J.D(this) | interfaceC22053ub1J.D(c8588Wp4) | interfaceC22053ub1J.D(list) | interfaceC22053ub1J.D(c20996sx3B);
                Object objB2 = interfaceC22053ub1J.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.Nf1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C8261Vf1.la(this.a, c20996sx3B, list, c8588Wp4, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB2, interfaceC22053ub1J, 0, 511);
                interfaceC22053ub1J.Q();
            }
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Of1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C8261Vf1.oa(this.a, z, c8588Wp4, list, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 la(final C8261Vf1 c8261Vf1, C20996sx3 c20996sx3, List list, final C8588Wp4 c8588Wp4, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(c8261Vf1, "this$0");
        AbstractC13042fc3.i(c20996sx3, "$lazyPagingItems");
        AbstractC13042fc3.i(list, "$selectedContact");
        AbstractC13042fc3.i(c8588Wp4, "$navController");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        EnumC6357Ng1 enumC6357Ng1A2 = c8261Vf1.Ma().a2();
        EnumC6357Ng1 enumC6357Ng1 = EnumC6357Ng1.a;
        if (enumC6357Ng1A2 == enumC6357Ng1) {
            AbstractC8486We1.a(interfaceC15069ix3, c8261Vf1.Ma().g2(), new SA2() { // from class: ir.nasim.Rf1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C8261Vf1.ma(this.a);
                }
            });
        }
        if (c8261Vf1.Ma().A2()) {
            AbstractC8486We1.b(interfaceC15069ix3, new SA2() { // from class: ir.nasim.Sf1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C8261Vf1.na(c8588Wp4);
                }
            });
        }
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, C22925w31.a.b(), 3, null);
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(393252111, true, c8261Vf1.new f(list)), 3, null);
        AbstractC4706Gf1.i(interfaceC15069ix3, c20996sx3, list, c8261Vf1.Ma().a2() == enumC6357Ng1, c8261Vf1.Ma().Y1(), new g(c8261Vf1.Ma()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ma(C8261Vf1 c8261Vf1) {
        AbstractC13042fc3.i(c8261Vf1, "this$0");
        Integer numC2 = c8261Vf1.Ma().c2();
        if (numC2 != null) {
            int iIntValue = numC2.intValue();
            InterfaceC9836ae3 interfaceC9836ae3Ja = c8261Vf1.Ja();
            ZN2 zn2G2 = c8261Vf1.Ma().g2();
            Boolean boolV1 = c8261Vf1.Ma().V1();
            C22042ua0.A9(c8261Vf1, interfaceC9836ae3Ja.a(iIntValue, boolV1 != null ? boolV1.booleanValue() : false, c8261Vf1.Ma().W1(), zn2G2), false, null, 6, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 na(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
        AbstractC13042fc3.i(c8588Wp4, "$navController");
        androidx.navigation.e.S(c8588Wp4, AbstractC16080kg1.b.a.a(), null, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oa(C8261Vf1 c8261Vf1, boolean z, C8588Wp4 c8588Wp4, List list, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c8261Vf1, "$tmp0_rcvr");
        AbstractC13042fc3.i(c8588Wp4, "$navController");
        AbstractC13042fc3.i(list, "$selectedContact");
        c8261Vf1.ka(z, c8588Wp4, list, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa(final boolean z, final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1667734853);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(list) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1J.W(-2088339507);
            boolean zD = interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new h(null);
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 6);
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            XL4 xl4 = (XL4) AbstractC10222bH6.b(Ma().m2(), null, interfaceC22053ub1J, 0, 1).getValue();
            if (xl4 instanceof XL4.a) {
                interfaceC22053ub1J.W(-79532391);
                String strC = UY6.c(AbstractC12217eE5.auth_error_unknown, interfaceC22053ub1J, 0);
                androidx.compose.ui.e eVarH = hVar.h(aVar, aVar2.e());
                G10 g10 = G10.a;
                int i4 = G10.b;
                AbstractC9105Ym7.b(strC, androidx.compose.foundation.layout.q.i(eVarH, g10.c(interfaceC22053ub1J, i4).b().c()), g10.a(interfaceC22053ub1J, i4).t(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i4).a(), interfaceC22053ub1J, 0, 0, 65528);
                interfaceC22053ub1J.Q();
            } else if (AbstractC13042fc3.d(xl4, XL4.b.a)) {
                interfaceC22053ub1J.W(-79016520);
                interfaceC22053ub1J.Q();
            } else if (AbstractC13042fc3.d(xl4, XL4.c.a)) {
                interfaceC22053ub1J.W(-78953156);
                AbstractC10628bv5.a(hVar.h(aVar, aVar2.e()), G10.a.a(interfaceC22053ub1J, G10.b).I(), 0.0f, 0L, 0, interfaceC22053ub1J, 0, 28);
                interfaceC22053ub1J.Q();
            } else {
                if (!(xl4 instanceof XL4.d)) {
                    interfaceC22053ub1J.W(-2080777217);
                    interfaceC22053ub1J.Q();
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC22053ub1J.W(-78621797);
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), aVar2.k(), interfaceC22053ub1J, 0);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
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
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                final List listA = ((XL4.d) xl4).a();
                if (listA.isEmpty()) {
                    interfaceC22053ub1J.W(1923125439);
                    C72.b(z, true, interfaceC22053ub1J, (i3 & 14) | 48, 0);
                    interfaceC22053ub1J.Q();
                } else {
                    interfaceC22053ub1J.W(1923272131);
                    interfaceC22053ub1J.W(-1461978372);
                    boolean zD2 = interfaceC22053ub1J.D(this) | interfaceC22053ub1J.D(list) | interfaceC22053ub1J.D(listA);
                    Object objB2 = interfaceC22053ub1J.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new UA2() { // from class: ir.nasim.Pf1
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C8261Vf1.qa(listA, list, this, (InterfaceC15069ix3) obj);
                            }
                        };
                        interfaceC22053ub1J.s(objB2);
                    }
                    interfaceC22053ub1J.Q();
                    AbstractC12623ev3.b(null, null, null, false, null, null, null, false, null, (UA2) objB2, interfaceC22053ub1J, 0, 511);
                    interfaceC22053ub1J.Q();
                }
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.Q();
            }
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Qf1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C8261Vf1.ra(this.a, z, list, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(List list, List list2, C8261Vf1 c8261Vf1, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$items");
        AbstractC13042fc3.i(list2, "$selectedContact");
        AbstractC13042fc3.i(c8261Vf1, "this$0");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, C22925w31.a.a(), 3, null);
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-579421616, true, c8261Vf1.new i(list2)), 3, null);
        AbstractC4706Gf1.k(interfaceC15069ix3, list, list2, c8261Vf1.Ma().a2() == EnumC6357Ng1.a, c8261Vf1.Ma().Y1(), new j(c8261Vf1.Ma()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(C8261Vf1 c8261Vf1, boolean z, List list, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c8261Vf1, "$tmp1_rcvr");
        AbstractC13042fc3.i(list, "$selectedContact");
        c8261Vf1.pa(z, list, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public final InterfaceC24417yb Ga() {
        InterfaceC24417yb interfaceC24417yb = this.adminsAccessFragmentNavigator;
        if (interfaceC24417yb != null) {
            return interfaceC24417yb;
        }
        AbstractC13042fc3.y("adminsAccessFragmentNavigator");
        return null;
    }

    public final InterfaceC11677dQ0 Ia() {
        InterfaceC11677dQ0 interfaceC11677dQ0 = this.chatNavigator;
        if (interfaceC11677dQ0 != null) {
            return interfaceC11677dQ0;
        }
        AbstractC13042fc3.y("chatNavigator");
        return null;
    }

    public final InterfaceC9836ae3 Ja() {
        InterfaceC9836ae3 interfaceC9836ae3 = this.inviteNavigator;
        if (interfaceC9836ae3 != null) {
            return interfaceC9836ae3;
        }
        AbstractC13042fc3.y("inviteNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C6038Lx2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        ComposeView composeView = Ha().c;
        AbstractC13042fc3.h(composeView, "composeToolbar");
        if (composeView.getVisibility() != 0) {
            return super.a();
        }
        Ha().c.setVisibility(8);
        Ha().f.setVisibility(0);
        Ha().c.h();
        Ma().R2(null);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Oa();
        ab();
        Ca();
        Da();
        bb(new SA2() { // from class: ir.nasim.Kf1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8261Vf1.Sa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Lf1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8261Vf1.Ua(this.a);
            }
        });
        Fa();
    }
}
