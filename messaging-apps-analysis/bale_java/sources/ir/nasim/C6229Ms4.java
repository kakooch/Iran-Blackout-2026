package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import androidx.lifecycle.j;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C21753u45;
import ir.nasim.C22023uY;
import ir.nasim.C6229Ms4;
import ir.nasim.EF2;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.PI7;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.components.appbar.view.DrawerToolbar;
import ir.nasim.database.entity.ContactEntity;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import ir.nasim.features.mxp.entity.PuppetGroup;
import ir.nasim.features.root.EmptyStateOnboardingItemAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u0082\u00012\u00020\u0001:\u0001GB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\n\u001a\u00020\u0004*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u0004*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0019\u0010\u0010\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\f0\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\f0\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010 \u001a\u00020\u0004*\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010%\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b'\u0010(J'\u0010,\u001a\u00020#*\u00020#2\b\b\u0001\u0010*\u001a\u00020)2\b\b\u0001\u0010+\u001a\u00020)H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010\u0003J\u000f\u0010/\u001a\u00020\u000fH\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\u0004H\u0002¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u0010\u0003J\u001f\u00106\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\f2\u0006\u00105\u001a\u00020\u000fH\u0002¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020)H\u0002¢\u0006\u0004\b9\u0010:J+\u0010B\u001a\u00020A2\u0006\u0010<\u001a\u00020;2\b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bB\u0010CJ!\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020A2\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u000fH\u0016¢\u0006\u0004\bG\u00100J\u0019\u0010H\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0004H\u0016¢\u0006\u0004\bJ\u0010\u0003J/\u0010P\u001a\u00020\u00042\u0006\u00108\u001a\u00020)2\u000e\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u00020L0K2\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bP\u0010QJ\u0015\u0010T\u001a\u00020\u00042\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001b\u0010a\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\"\u0010i\u001a\u00020b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010q\u001a\u00020j8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010y\u001a\u00020r8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001b\u0010~\u001a\u00020z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010X\u001a\u0004\b|\u0010}R\u001d\u0010\u0081\u0001\u001a\u00020z8BX\u0082\u0084\u0002¢\u0006\r\n\u0004\b\u007f\u0010X\u001a\u0005\b\u0080\u0001\u0010}¨\u0006\u008b\u0001²\u0006\r\u0010\u0083\u0001\u001a\u00020\u000f8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0085\u0001\u001a\u00030\u0084\u00018\nX\u008a\u0084\u0002²\u0006\r\u0010\u0086\u0001\u001a\u00020\u000f8\nX\u008a\u0084\u0002²\u0006\u000f\u0010\u0087\u0001\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0089\u0001\u001a\u00030\u0088\u00018\nX\u008a\u0084\u0002²\u0006\u0011\u0010\u008a\u0001\u001a\u0004\u0018\u00010\f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lir/nasim/Ms4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "za", "Lir/nasim/ix3;", "Lir/nasim/sx3;", "Lir/nasim/M75;", "phoneContacts", "Ja", "(Lir/nasim/ix3;Lir/nasim/sx3;)V", "Lir/nasim/uY;", ContactEntity.TABLE_NAME, "na", "", "Da", "(Lir/nasim/sx3;)Z", "Pa", "Ra", "contact", "qa", "(Lir/nasim/uY;)V", "item", "Ma", "(Lir/nasim/M75;)V", "Ka", "Aa", "Lir/nasim/gj3;", "Ta", "()Lir/nasim/gj3;", "Lir/nasim/components/appbar/view/BaleToolbar;", "Ba", "(Lir/nasim/components/appbar/view/BaleToolbar;)V", "Ea", "Landroid/view/MenuItem;", "menuItem", "Fa", "(Landroid/view/MenuItem;)Lir/nasim/gj3;", "Ga", "(Landroid/view/MenuItem;)V", "", "iconResId", "titleResId", "Oa", "(Landroid/view/MenuItem;II)Landroid/view/MenuItem;", "Xa", "ya", "()Z", "Qa", "pa", "Ia", "Ha", "isVideo", "Ua", "(Lir/nasim/uY;Z)V", "requestCode", "La", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "a", "M6", "(Landroid/os/Bundle;)V", "j7", "", "", "permissions", "", "grantResults", "g7", "(I[Ljava/lang/String;[I)V", "Lir/nasim/Pf2;", "fabricEventType", "Na", "(Lir/nasim/Pf2;)V", "Lir/nasim/tt4;", "h1", "Lir/nasim/Yu3;", "xa", "()Lir/nasim/tt4;", "viewModel", "Lir/nasim/Ky2;", "i1", "Lir/nasim/bW7;", "ra", "()Lir/nasim/Ky2;", "binding", "Lir/nasim/aO2;", "j1", "Lir/nasim/aO2;", "ta", "()Lir/nasim/aO2;", "setGroupTypeMakerNavigator", "(Lir/nasim/aO2;)V", "groupTypeMakerNavigator", "Lir/nasim/mj6;", "k1", "Lir/nasim/mj6;", "va", "()Lir/nasim/mj6;", "setSecurityNavigator", "(Lir/nasim/mj6;)V", "securityNavigator", "Lir/nasim/DK4;", "l1", "Lir/nasim/DK4;", "ua", "()Lir/nasim/DK4;", "setOnBoardingNavigator", "(Lir/nasim/DK4;)V", "onBoardingNavigator", "Lir/nasim/n10;", "m1", "wa", "()Lir/nasim/n10;", "snackBar", "n1", "sa", "callErrorsSnackBar", "o1", "permissionGranted", "Lir/nasim/EF2;", "contactState", "refreshLoading", "firstTimeLoadContact", "Lir/nasim/Gg1;", "sortType", "longPressItemClick", "contact_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Ms4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6229Ms4 extends AbstractC13612gX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;

    /* renamed from: j1, reason: from kotlin metadata */
    public InterfaceC9687aO2 groupTypeMakerNavigator;

    /* renamed from: k1, reason: from kotlin metadata */
    public InterfaceC17297mj6 securityNavigator;

    /* renamed from: l1, reason: from kotlin metadata */
    public DK4 onBoardingNavigator;

    /* renamed from: m1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 snackBar;

    /* renamed from: n1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 callErrorsSnackBar;
    static final /* synthetic */ InterfaceC5239Im3[] p1 = {AbstractC10882cM5.i(new C25226zw5(C6229Ms4.class, "binding", "getBinding()Lir/nasim/contact/databinding/FragmentNewContactsBinding;", 0))};

    /* renamed from: o1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q1 = 8;

    /* renamed from: ir.nasim.Ms4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C6229Ms4 a(boolean z, EnumC6843Pf2 enumC6843Pf2) {
            AbstractC13042fc3.i(enumC6843Pf2, "contactsFragmentNavigationEvent");
            C6229Ms4 c6229Ms4 = new C6229Ms4();
            c6229Ms4.Na(enumC6843Pf2);
            Bundle bundle = new Bundle();
            bundle.putBoolean("IS_FROM_CALL", z);
            c6229Ms4.a8(bundle);
            return c6229Ms4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ms4$b */
    static final class b implements InterfaceC16978mB2 {
        final /* synthetic */ C20996sx3 a;
        final /* synthetic */ C6229Ms4 b;

        b(C20996sx3 c20996sx3, C6229Ms4 c6229Ms4) {
            this.a = c20996sx3;
            this.b = c6229Ms4;
        }

        private static final C22023uY k(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (C22023uY) interfaceC9102Ym4.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$longPressItemClick$delegate");
            x(interfaceC9102Ym4, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(C6229Ms4 c6229Ms4, C22023uY c22023uY) {
            AbstractC13042fc3.i(c6229Ms4, "this$0");
            AbstractC13042fc3.i(c22023uY, "it");
            c6229Ms4.qa(c22023uY);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p(C6229Ms4 c6229Ms4, C22023uY c22023uY) {
            AbstractC13042fc3.i(c6229Ms4, "this$0");
            AbstractC13042fc3.i(c22023uY, "it");
            c6229Ms4.Ka(c22023uY);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(C6229Ms4 c6229Ms4, C22023uY c22023uY) {
            AbstractC13042fc3.i(c6229Ms4, "this$0");
            AbstractC13042fc3.i(c22023uY, "$baleContactItem");
            c6229Ms4.Ua(c22023uY, false);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(int i) {
            C18987pb3 c18987pb3 = C18987pb3.a;
            C11458d25 c11458d25E = C11458d25.E(i);
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            c18987pb3.w1(c11458d25E, null, false);
            C3343Am.g("contacts_click_on_a_contact");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 w(C22023uY c22023uY, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(c22023uY, "$baleContactItem");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$longPressItemClick$delegate");
            x(interfaceC9102Ym4, c22023uY);
            return C19938rB7.a;
        }

        private static final void x(InterfaceC9102Ym4 interfaceC9102Ym4, C22023uY c22023uY) {
            interfaceC9102Ym4.setValue(c22023uY);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            i((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }

        public final void i(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            String strY;
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
            final C22023uY c22023uY = (C22023uY) this.a.f(i);
            if (c22023uY == null) {
                return;
            }
            final C6229Ms4 c6229Ms4 = this.b;
            PI7 pi7F = c22023uY.f();
            interfaceC22053ub1.W(1396337468);
            if (c22023uY.g()) {
                strY = UY6.c(AbstractC12217eE5.members_adapter_bot_online_status, interfaceC22053ub1, 0);
            } else {
                Context contextS7 = c6229Ms4.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                strY = C14593iA1.y(contextS7, pi7F, false, 4, null);
            }
            String str = strY;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-187695512);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(null, null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            e.a aVar2 = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar2);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarD = InterfaceC6988Pv3.d(interfaceC6988Pv3, aVar2, null, null, null, 7, null);
            C23546x62 c23546x62B = AbstractC8970Ya1.b(c22023uY.e(), 0L, 1, null);
            String strE = c22023uY.e();
            int iC = c22023uY.c();
            boolean zG = c22023uY.g();
            boolean z = (pi7F != null ? pi7F.u() : null) == PI7.a.ONLINE;
            C22023uY.a aVarD = c22023uY.d();
            C22023uY.a.C1635a c1635a = aVarD instanceof C22023uY.a.C1635a ? (C22023uY.a.C1635a) aVarD : null;
            EV4 ev4H = AvatarAsyncImagePainterKt.h(c1635a != null ? c1635a.a() : null, null, false, 0, interfaceC22053ub1, 0, 14);
            boolean zN1 = c6229Ms4.xa().N1();
            int iF = AbstractC5969Lp4.f();
            EV4 ev4C = FV4.c(AbstractC15799kB5.ic_saved_message, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(620344580);
            boolean zD = interfaceC22053ub1.D(c6229Ms4) | interfaceC22053ub1.V(c22023uY);
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Ns4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C6229Ms4.b.t(c6229Ms4, c22023uY);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa2 = (SA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(620355336);
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar.a()) {
                objB3 = new UA2() { // from class: ir.nasim.Os4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C6229Ms4.b.v(((Integer) obj).intValue());
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            UA2 ua2 = (UA2) objB3;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(620362722);
            boolean zV = interfaceC22053ub1.V(c22023uY);
            Object objB4 = interfaceC22053ub1.B();
            if (zV || objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.Ps4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C6229Ms4.b.w(c22023uY, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            AbstractC24459yf1.o(eVarD, strE, c23546x62B, iC, ev4H, str, z, zG, sa2, zN1, iF, ev4C, ua2, (SA2) objB4, interfaceC22053ub1, 0, 384, 0);
            C22023uY c22023uYK = k(interfaceC9102Ym4);
            interfaceC22053ub1.W(620368315);
            if (c22023uYK != null) {
                if (c22023uYK.c() == AbstractC5969Lp4.f()) {
                    x(interfaceC9102Ym4, null);
                } else {
                    interfaceC22053ub1.W(1376604386);
                    Object objB5 = interfaceC22053ub1.B();
                    if (objB5 == aVar.a()) {
                        objB5 = new SA2() { // from class: ir.nasim.Qs4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C6229Ms4.b.n(interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub1.s(objB5);
                    }
                    SA2 sa22 = (SA2) objB5;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1376606737);
                    boolean zD2 = interfaceC22053ub1.D(c6229Ms4);
                    Object objB6 = interfaceC22053ub1.B();
                    if (zD2 || objB6 == aVar.a()) {
                        objB6 = new UA2() { // from class: ir.nasim.Rs4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C6229Ms4.b.o(c6229Ms4, (C22023uY) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB6);
                    }
                    UA2 ua22 = (UA2) objB6;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1376610875);
                    boolean zD3 = interfaceC22053ub1.D(c6229Ms4);
                    Object objB7 = interfaceC22053ub1.B();
                    if (zD3 || objB7 == aVar.a()) {
                        objB7 = new UA2() { // from class: ir.nasim.Ss4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C6229Ms4.b.p(c6229Ms4, (C22023uY) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB7);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC13618gY.d(c22023uYK, sa22, ua22, (UA2) objB7, interfaceC22053ub1, 48);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
            C19938rB7 c19938rB72 = C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ms4$c */
    static final class c implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Ms4$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C6229Ms4 a;

            /* renamed from: ir.nasim.Ms4$c$a$a, reason: collision with other inner class name */
            static final class C0514a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C19206px3 c;
                final /* synthetic */ C6229Ms4 d;

                /* renamed from: ir.nasim.Ms4$c$a$a$a, reason: collision with other inner class name */
                static final class C0515a implements InterfaceC4806Gq2 {
                    final /* synthetic */ C6229Ms4 a;

                    C0515a(C6229Ms4 c6229Ms4) {
                        this.a = c6229Ms4;
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                        this.a.xa().X1(list);
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0514a(C19206px3 c19206px3, C6229Ms4 c6229Ms4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c19206px3;
                    this.d = c6229Ms4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final List y(C19206px3 c19206px3) {
                    List listI = c19206px3.x().i();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = listI.iterator();
                    while (it.hasNext()) {
                        Object key = ((InterfaceC7948Tw3) it.next()).getKey();
                        Integer num = key instanceof Integer ? (Integer) key : null;
                        if (num != null) {
                            arrayList.add(num);
                        }
                    }
                    return arrayList;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0514a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        final C19206px3 c19206px3 = this.c;
                        InterfaceC4557Fq2 interfaceC4557Fq2S = AbstractC6459Nq2.s(AbstractC10222bH6.r(new SA2() { // from class: ir.nasim.Xs4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C6229Ms4.c.a.C0514a.y(c19206px3);
                            }
                        }), 50L);
                        C0515a c0515a = new C0515a(this.d);
                        this.b = 1;
                        if (interfaceC4557Fq2S.b(c0515a, this) == objE) {
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
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0514a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Ms4$c$a$b */
            static final class b implements InterfaceC15796kB2 {
                final /* synthetic */ ZY0 a;
                final /* synthetic */ C6229Ms4 b;

                /* renamed from: ir.nasim.Ms4$c$a$b$a, reason: collision with other inner class name */
                static final class C0516a implements InterfaceC15796kB2 {
                    final /* synthetic */ C6229Ms4 a;

                    C0516a(C6229Ms4 c6229Ms4) {
                        this.a = c6229Ms4;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 h(C6229Ms4 c6229Ms4) {
                        AbstractC13042fc3.i(c6229Ms4, "this$0");
                        C22042ua0.A9(c6229Ms4, c6229Ms4.ta().a(ZN2.CHANNEL), false, "GroupTypeMakerFragment", 2, null);
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 i(C6229Ms4 c6229Ms4) {
                        AbstractC13042fc3.i(c6229Ms4, "this$0");
                        C22042ua0.A9(c6229Ms4, c6229Ms4.ta().a(ZN2.GROUP), false, "GroupTypeMakerFragment", 2, null);
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 k(C6229Ms4 c6229Ms4) {
                        AbstractC13042fc3.i(c6229Ms4, "this$0");
                        C22042ua0.A9(c6229Ms4, C8386Vt0.a.m8() ? new C13973h8() : new CH4(), false, null, 6, null);
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 n(C6229Ms4 c6229Ms4) {
                        AbstractC13042fc3.i(c6229Ms4, "this$0");
                        C22042ua0.A9(c6229Ms4, C10265bM4.INSTANCE.a(), false, null, 6, null);
                        return C19938rB7.a;
                    }

                    public final void f(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
                        interfaceC22053ub1.W(-1253343772);
                        boolean zD = interfaceC22053ub1.D(this.a);
                        final C6229Ms4 c6229Ms4 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.Ys4
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C6229Ms4.c.a.b.C0516a.h(c6229Ms4);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        SA2 sa2 = (SA2) objB;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(-1253328030);
                        boolean zD2 = interfaceC22053ub1.D(this.a);
                        final C6229Ms4 c6229Ms42 = this.a;
                        Object objB2 = interfaceC22053ub1.B();
                        if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                            objB2 = new SA2() { // from class: ir.nasim.Zs4
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C6229Ms4.c.a.b.C0516a.i(c6229Ms42);
                                }
                            };
                            interfaceC22053ub1.s(objB2);
                        }
                        SA2 sa22 = (SA2) objB2;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(-1253312279);
                        boolean zD3 = interfaceC22053ub1.D(this.a);
                        final C6229Ms4 c6229Ms43 = this.a;
                        Object objB3 = interfaceC22053ub1.B();
                        if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                            objB3 = new SA2() { // from class: ir.nasim.at4
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C6229Ms4.c.a.b.C0516a.k(c6229Ms43);
                                }
                            };
                            interfaceC22053ub1.s(objB3);
                        }
                        SA2 sa23 = (SA2) objB3;
                        interfaceC22053ub1.Q();
                        boolean zP1 = this.a.xa().P1();
                        String strX1 = this.a.xa().x1();
                        interfaceC22053ub1.W(-1253287701);
                        boolean zD4 = interfaceC22053ub1.D(this.a);
                        final C6229Ms4 c6229Ms44 = this.a;
                        Object objB4 = interfaceC22053ub1.B();
                        if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                            objB4 = new SA2() { // from class: ir.nasim.bt4
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C6229Ms4.c.a.b.C0516a.n(c6229Ms44);
                                }
                            };
                            interfaceC22053ub1.s(objB4);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC9027Ye1.b(sa2, sa22, sa23, zP1, strX1, (SA2) objB4, interfaceC22053ub1, 0);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        f((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                b(ZY0 zy0, C6229Ms4 c6229Ms4) {
                    this.a = zy0;
                    this.b = c6229Ms4;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    ZY0 zy0 = this.a;
                    interfaceC22053ub1.W(1605942819);
                    boolean z = false;
                    if (!this.b.xa().N1() && !((Boolean) AbstractC10222bH6.b(this.b.xa().H1(), null, interfaceC22053ub1, 0, 1).getValue()).booleanValue()) {
                        z = true;
                    }
                    interfaceC22053ub1.Q();
                    AbstractC22231ut.d(zy0, z, null, androidx.compose.animation.f.m(null, null, false, null, 15, null), androidx.compose.animation.f.y(null, null, false, null, 15, null), null, AbstractC19242q11.e(540255543, true, new C0516a(this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 1600512, 18);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Ms4$c$a$c, reason: collision with other inner class name */
            static final class C0517c implements InterfaceC15796kB2 {
                final /* synthetic */ C6229Ms4 a;
                final /* synthetic */ InterfaceC9664aL6 b;

                /* renamed from: ir.nasim.Ms4$c$a$c$a, reason: collision with other inner class name */
                /* synthetic */ class C0518a extends EB2 implements SA2 {
                    C0518a(Object obj) {
                        super(0, obj, C6229Ms4.class, "showRefreshDialog", "showRefreshDialog()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((C6229Ms4) this.receiver).Ra();
                    }
                }

                C0517c(C6229Ms4 c6229Ms4, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = c6229Ms4;
                    this.b = interfaceC9664aL6;
                }

                private static final EnumC4715Gg1 b(InterfaceC9664aL6 interfaceC9664aL6) {
                    return (EnumC4715Gg1) interfaceC9664aL6.getValue();
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    EnumC4715Gg1 enumC4715Gg1B = b(AbstractC10222bH6.b(this.a.xa().J1(), null, interfaceC22053ub1, 0, 1));
                    boolean zT = a.t(this.b);
                    C6229Ms4 c6229Ms4 = this.a;
                    interfaceC22053ub1.W(1606029831);
                    boolean zD = interfaceC22053ub1.D(c6229Ms4);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0518a(c6229Ms4);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC8270Vg1.d(enumC4715Gg1B, zT, (SA2) ((InterfaceC16733lm3) objB), interfaceC22053ub1, 0);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Ms4$c$a$d */
            static final class d implements InterfaceC15796kB2 {
                final /* synthetic */ C6229Ms4 a;

                d(C6229Ms4 c6229Ms4) {
                    this.a = c6229Ms4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C11458d25 c11458d25, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction) {
                    AbstractC13042fc3.i(c11458d25, "peer");
                    AbstractC13042fc3.i(emptyStateOnboardingItemAction, "emptyStateOnboardingItemAction");
                    C18987pb3.x1(C18987pb3.a, c11458d25, null, null, false, null, null, false, null, null, false, emptyStateOnboardingItemAction, 1022, null);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    InterfaceC15796kB2 interfaceC15796kB2D = this.a.ua().d();
                    interfaceC22053ub1.W(1606093461);
                    Object objB = interfaceC22053ub1.B();
                    if (objB == InterfaceC22053ub1.a.a()) {
                        objB = new InterfaceC14603iB2() { // from class: ir.nasim.ct4
                            @Override // ir.nasim.InterfaceC14603iB2
                            public final Object invoke(Object obj, Object obj2) {
                                return C6229Ms4.c.a.d.c((C11458d25) obj, (EmptyStateOnboardingItemAction) obj2);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    interfaceC15796kB2D.q((InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            a(C6229Ms4 c6229Ms4) {
                this.a = c6229Ms4;
            }

            private static final boolean i(InterfaceC9664aL6 interfaceC9664aL6) {
                return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
            }

            private static final EF2 k(InterfaceC9664aL6 interfaceC9664aL6) {
                return (EF2) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(final C6229Ms4 c6229Ms4, C20996sx3 c20996sx3, C20996sx3 c20996sx32, ZY0 zy0, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(c6229Ms4, "this$0");
                AbstractC13042fc3.i(c20996sx3, "$contacts");
                AbstractC13042fc3.i(c20996sx32, "$phoneContacts");
                AbstractC13042fc3.i(zy0, "$this_Column");
                AbstractC13042fc3.i(interfaceC9664aL6, "$refreshLoading$delegate");
                AbstractC13042fc3.i(interfaceC9664aL62, "$contactState$delegate");
                AbstractC13042fc3.i(interfaceC9664aL63, "$permissionGranted$delegate");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$firstTimeLoadContact$delegate");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-948555681, true, new b(zy0, c6229Ms4)), 3, null);
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(2022209878, true, new C0517c(c6229Ms4, interfaceC9664aL6)), 3, null);
                if (k(interfaceC9664aL62) instanceof EF2.d) {
                    if (c6229Ms4.Da(c20996sx3) && i(interfaceC9664aL63)) {
                        AbstractC9322Zl.b(interfaceC15069ix3, new SA2() { // from class: ir.nasim.Ts4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C6229Ms4.c.a.o(c6229Ms4);
                            }
                        });
                    } else if (!c6229Ms4.Da(c20996sx3) || i(interfaceC9664aL63)) {
                        c6229Ms4.na(interfaceC15069ix3, c20996sx3);
                        if (w(interfaceC9102Ym4) || ((c20996sx3.i().d() instanceof AbstractC13460gG3.c) && c20996sx3.i().a().a())) {
                            x(interfaceC9102Ym4, true);
                            c6229Ms4.Ja(interfaceC15069ix3, c20996sx32);
                        }
                    } else {
                        AbstractC9322Zl.a(interfaceC15069ix3, new SA2() { // from class: ir.nasim.Us4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C6229Ms4.c.a.p(c6229Ms4);
                            }
                        });
                    }
                    if (c6229Ms4.Pa(c20996sx3)) {
                        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-163642667, true, new d(c6229Ms4)), 3, null);
                    }
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(C6229Ms4 c6229Ms4) {
                AbstractC13042fc3.i(c6229Ms4, "this$0");
                c6229Ms4.Ra();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(C6229Ms4 c6229Ms4) {
                AbstractC13042fc3.i(c6229Ms4, "this$0");
                C21753u45.Q0(C21753u45.a, c6229Ms4, 1088, null, new C21753u45.d[]{C21753u45.d.h, C21753u45.d.i}, 4, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean t(InterfaceC9664aL6 interfaceC9664aL6) {
                return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final InterfaceC9102Ym4 v() {
                return AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
            }

            private static final boolean w(InterfaceC9102Ym4 interfaceC9102Ym4) {
                return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
            }

            private static final void x(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
                interfaceC9102Ym4.setValue(Boolean.valueOf(z));
            }

            public final void h(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.ui.e.a, G10.a.a(interfaceC22053ub1, G10.b).r(), null, 2, null);
                final C6229Ms4 c6229Ms4 = this.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                final C9784aZ0 c9784aZ0 = C9784aZ0.a;
                final InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(c6229Ms4.xa().A1(), null, interfaceC22053ub1, 0, 1);
                final InterfaceC9664aL6 interfaceC9664aL6B2 = AbstractC10222bH6.b(c6229Ms4.xa().v1(), null, interfaceC22053ub1, 0, 1);
                final InterfaceC9664aL6 interfaceC9664aL6B3 = AbstractC10222bH6.b(c6229Ms4.xa().F1(), null, interfaceC22053ub1, 0, 1);
                final C20996sx3 c20996sx3B = AbstractC21683tx3.b(c6229Ms4.xa().z1(), null, interfaceC22053ub1, 0, 1);
                final C20996sx3 c20996sx3B2 = AbstractC21683tx3.b(c6229Ms4.xa().B1(), null, interfaceC22053ub1, 0, 1);
                Object[] objArr = new Object[0];
                interfaceC22053ub1.W(-1027533360);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
                if (objB == aVar2.a()) {
                    objB = new SA2() { // from class: ir.nasim.Vs4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C6229Ms4.c.a.v();
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
                C19206px3 c19206px3B = AbstractC19797qx3.b(0, 0, interfaceC22053ub1, 0, 3);
                interfaceC22053ub1.W(-1027528884);
                boolean zV = interfaceC22053ub1.V(c19206px3B) | interfaceC22053ub1.D(c6229Ms4);
                Object objB2 = interfaceC22053ub1.B();
                if (zV || objB2 == aVar2.a()) {
                    objB2 = new C0514a(c19206px3B, c6229Ms4, null);
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(c19206px3B, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-1027514338);
                boolean zD = interfaceC22053ub1.D(c6229Ms4) | interfaceC22053ub1.V(interfaceC9664aL6B3) | interfaceC22053ub1.V(interfaceC9664aL6B2) | interfaceC22053ub1.D(c20996sx3B) | interfaceC22053ub1.V(interfaceC9664aL6B) | interfaceC22053ub1.V(interfaceC9102Ym4) | interfaceC22053ub1.D(c20996sx3B2);
                Object objB3 = interfaceC22053ub1.B();
                if (zD || objB3 == aVar2.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.Ws4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C6229Ms4.c.a.n(c6229Ms4, c20996sx3B, c20996sx3B2, c9784aZ0, interfaceC9664aL6B3, interfaceC9664aL6B2, interfaceC9664aL6B, interfaceC9102Ym4, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(null, c19206px3B, null, false, null, null, null, false, null, (UA2) objB3, interfaceC22053ub1, 0, 509);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                h((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1470796372, true, new a(C6229Ms4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ms4$d */
    static final class d implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Ms4$d$a */
        /* synthetic */ class a extends EB2 implements UA2 {
            a(Object obj) {
                super(1, obj, C21646tt4.class, "setQuery", "setQuery(Ljava/lang/String;)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((String) obj);
                return C19938rB7.a;
            }

            public final void y(String str) {
                AbstractC13042fc3.i(str, "p0");
                ((C21646tt4) this.receiver).c2(str);
            }
        }

        /* renamed from: ir.nasim.Ms4$d$b */
        /* synthetic */ class b extends C23553x7 implements SA2 {
            b(Object obj) {
                super(0, obj, C6229Ms4.class, "onBackPressed", "onBackPressed()Z", 8);
            }

            public final void a() {
                ((C6229Ms4) this.a).a();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        d() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String str = (String) AbstractC10222bH6.b(C6229Ms4.this.xa().E1(), null, interfaceC22053ub1, 0, 1).getValue();
            C21646tt4 c21646tt4Xa = C6229Ms4.this.xa();
            interfaceC22053ub1.W(-1997146382);
            boolean zD = interfaceC22053ub1.D(c21646tt4Xa);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c21646tt4Xa);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB);
            C6229Ms4 c6229Ms4 = C6229Ms4.this;
            interfaceC22053ub1.W(-1997145714);
            boolean zD2 = interfaceC22053ub1.D(c6229Ms4);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new b(c6229Ms4);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC3760Cf6.b(str, ua2, (SA2) objB2, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ms4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Ms4$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6229Ms4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6229Ms4 c6229Ms4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6229Ms4;
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
                XV4 xv4 = (XV4) this.c;
                C19100pm6.s1.a(new PuppetGroup((String) xv4.e(), (List) xv4.f())).L8(this.d.F5(), "mxpContactBottomSheet");
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(xv4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6229Ms4.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(C6229Ms4.this.xa().D1());
                a aVar = new a(C6229Ms4.this, null);
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ms4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MenuItem d;

        /* renamed from: ir.nasim.Ms4$f$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C6229Ms4 c;
            final /* synthetic */ MenuItem d;

            /* renamed from: ir.nasim.Ms4$f$a$a, reason: collision with other inner class name */
            static final class C0519a implements InterfaceC4806Gq2 {
                final /* synthetic */ C6229Ms4 a;
                final /* synthetic */ MenuItem b;

                C0519a(C6229Ms4 c6229Ms4, MenuItem menuItem) {
                    this.a = c6229Ms4;
                    this.b = menuItem;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(EnumC4715Gg1 enumC4715Gg1, InterfaceC20295rm1 interfaceC20295rm1) {
                    this.a.Oa(this.b, enumC4715Gg1.j(), enumC4715Gg1.p());
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6229Ms4 c6229Ms4, MenuItem menuItem, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c6229Ms4;
                this.d = menuItem;
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
                    InterfaceC10258bL6 interfaceC10258bL6K1 = this.c.xa().K1();
                    C0519a c0519a = new C0519a(this.c, this.d);
                    this.b = 1;
                    if (interfaceC10258bL6K1.b(c0519a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(MenuItem menuItem, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = menuItem;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6229Ms4.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6229Ms4 c6229Ms4 = C6229Ms4.this;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(c6229Ms4, this.d, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c6229Ms4, bVar, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Ms4$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MenuItem d;

        /* renamed from: ir.nasim.Ms4$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C6229Ms4 c;
            final /* synthetic */ MenuItem d;

            /* renamed from: ir.nasim.Ms4$g$a$a, reason: collision with other inner class name */
            static final class C0520a implements InterfaceC4806Gq2 {
                final /* synthetic */ MenuItem a;
                final /* synthetic */ C6229Ms4 b;

                C0520a(MenuItem menuItem, C6229Ms4 c6229Ms4) {
                    this.a = menuItem;
                    this.b = c6229Ms4;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
                }

                public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    MenuItem menuItem = this.a;
                    C6229Ms4 c6229Ms4 = this.b;
                    XV4 xv4 = z ? new XV4(c6229Ms4.xa().J1().getValue(), AbstractC6392Nk0.d(SA5.white)) : new XV4(EnumC4715Gg1.d, AbstractC6392Nk0.d(SA5.n100));
                    int iC = AbstractC4043Dl1.c(c6229Ms4.S7(), ((Number) xv4.f()).intValue());
                    if (Build.VERSION.SDK_INT >= 26) {
                        menuItem.setIconTintList(ColorStateList.valueOf(iC));
                    } else {
                        Drawable icon = menuItem.getIcon();
                        if (icon != null) {
                            icon.setTint(iC);
                        }
                    }
                    c6229Ms4.Oa(menuItem, ((EnumC4715Gg1) xv4.e()).j(), ((EnumC4715Gg1) xv4.e()).p());
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6229Ms4 c6229Ms4, MenuItem menuItem, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c6229Ms4;
                this.d = menuItem;
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
                    InterfaceC10258bL6 interfaceC10258bL6U1 = this.c.xa().u1();
                    C0520a c0520a = new C0520a(this.d, this.c);
                    this.b = 1;
                    if (interfaceC10258bL6U1.b(c0520a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(MenuItem menuItem, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = menuItem;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6229Ms4.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6229Ms4 c6229Ms4 = C6229Ms4.this;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(c6229Ms4, this.d, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c6229Ms4, bVar, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Ms4$h */
    static final class h implements InterfaceC16978mB2 {
        final /* synthetic */ C20996sx3 a;
        final /* synthetic */ C6229Ms4 b;

        h(C20996sx3 c20996sx3, C6229Ms4 c6229Ms4) {
            this.a = c20996sx3;
            this.b = c6229Ms4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C6229Ms4 c6229Ms4, M75 m75) {
            AbstractC13042fc3.i(c6229Ms4, "this$0");
            AbstractC13042fc3.i(m75, "$it");
            c6229Ms4.Ma(m75);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C6229Ms4 c6229Ms4, String str, String str2) {
            AbstractC13042fc3.i(c6229Ms4, "this$0");
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "phone");
            c6229Ms4.xa().C1(str, str2);
            return C19938rB7.a;
        }

        public final void c(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            final M75 m75 = (M75) this.a.f(i);
            if (m75 == null) {
                return;
            }
            final C6229Ms4 c6229Ms4 = this.b;
            String strB = m75.b();
            int iA = (int) m75.a();
            EV4 ev4H = AvatarAsyncImagePainterKt.h(null, null, false, 0, interfaceC22053ub1, 6, 14);
            String strC = m75.c();
            interfaceC22053ub1.W(-732864984);
            boolean zD = interfaceC22053ub1.D(c6229Ms4) | interfaceC22053ub1.V(m75);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.et4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C6229Ms4.h.d(c6229Ms4, m75);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-732861713);
            boolean zD2 = interfaceC22053ub1.D(c6229Ms4);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new InterfaceC14603iB2() { // from class: ir.nasim.ft4
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return C6229Ms4.h.f(c6229Ms4, (String) obj, (String) obj2);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC24459yf1.w(null, strB, iA, strC, ev4H, sa2, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0, 1);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            c((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ms4$j */
    static final class j implements InterfaceC15796kB2 {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C6229Ms4 c6229Ms4) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(c6229Ms4, "this$0");
            dialog.dismiss();
            c6229Ms4.xa().L1();
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
            interfaceC22053ub1.W(820358515);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C6229Ms4.this);
            final C6229Ms4 c6229Ms4 = C6229Ms4.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.gt4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C6229Ms4.j.d(dialog, c6229Ms4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(820362376);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.ht4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C6229Ms4.j.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC18853pM5.b(sa2, (SA2) objB2, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ms4$k */
    public static final class k extends AbstractC8614Ws3 implements UA2 {
        public k() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C5814Ky2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Ms4$l */
    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Ms4$m */
    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Ms4$n */
    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Ms4$o */
    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Ms4$p */
    public static final class p extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Ms4$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            q qVar = C6229Ms4.this.new q(interfaceC20295rm1);
            qVar.c = obj;
            return qVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x003b -> B:14:0x003e). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.b
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r5.c
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r6)
                goto L3e
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1b:
                ir.nasim.AbstractC10685c16.b(r6)
                java.lang.Object r6 = r5.c
                ir.nasim.ro1 r6 = (ir.nasim.InterfaceC20315ro1) r6
                r1 = r6
            L23:
                boolean r6 = ir.nasim.AbstractC20906so1.g(r1)
                if (r6 == 0) goto L48
                ir.nasim.Ms4 r6 = ir.nasim.C6229Ms4.this
                ir.nasim.tt4 r6 = ir.nasim.C6229Ms4.ca(r6)
                long r3 = r6.w1()
                r5.c = r1
                r5.b = r2
                java.lang.Object r6 = ir.nasim.HG1.b(r3, r5)
                if (r6 != r0) goto L3e
                return r0
            L3e:
                ir.nasim.Ms4 r6 = ir.nasim.C6229Ms4.this
                ir.nasim.tt4 r6 = ir.nasim.C6229Ms4.ca(r6)
                r6.i2()
                goto L23
            L48:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6229Ms4.q.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ms4$r */
    /* synthetic */ class r extends EB2 implements UA2 {
        r(Object obj) {
            super(1, obj, C6229Ms4.class, "requestStartCallPermission", "requestStartCallPermission(I)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y(((Number) obj).intValue());
            return C19938rB7.a;
        }

        public final void y(int i) {
            ((C6229Ms4) this.receiver).La(i);
        }
    }

    public C6229Ms4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new m(new l(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C21646tt4.class), new n(interfaceC9173Yu3B), new o(null, interfaceC9173Yu3B), new p(this, interfaceC9173Yu3B));
        this.binding = AbstractC6056Lz2.f(this, new k(), AbstractC20046rN7.c());
        this.snackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Hs4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6229Ms4.Sa(this.a);
            }
        });
        this.callErrorsSnackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Is4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6229Ms4.ma(this.a);
            }
        });
    }

    private final void Aa() {
        DrawerToolbar drawerToolbar = ra().e;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(drawerToolbar, fragmentActivityQ7, true, false, 4, null);
        AbstractC13042fc3.f(drawerToolbar);
        Ba(drawerToolbar);
    }

    private final void Ba(BaleToolbar baleToolbar) {
        ra().b.setVisibility(8);
        baleToolbar.y(AbstractC13435gD5.contacts_menu);
        ComposeView composeView = ra().b;
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(89549793, true, new d()));
        composeView.h();
        MenuItem menuItemFindItem = ra().e.getMenu().findItem(AbstractC10176bC5.sort_contacts);
        if (menuItemFindItem != null) {
            Ga(menuItemFindItem);
            Fa(menuItemFindItem);
        }
        baleToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.Js4
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return C6229Ms4.Ca(this.a, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ca(C6229Ms4 c6229Ms4, MenuItem menuItem) {
        AbstractC13042fc3.i(c6229Ms4, "this$0");
        int itemId = menuItem.getItemId();
        if (itemId == AbstractC10176bC5.search_contacts) {
            c6229Ms4.ra().b.setVisibility(0);
            c6229Ms4.ra().b.g();
            c6229Ms4.ra().e.setVisibility(8);
            c6229Ms4.xa().d2(true);
        } else {
            if (itemId != AbstractC10176bC5.sort_contacts) {
                return false;
            }
            c6229Ms4.Xa();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Da(C20996sx3 c20996sx3) {
        return (c20996sx3.i().d() instanceof AbstractC13460gG3.c) && c20996sx3.i().a().a() && c20996sx3.g() == 0;
    }

    private final void Ea() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new e(null), 3, null);
    }

    private final InterfaceC13730gj3 Fa(MenuItem menuItem) {
        return AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new f(menuItem, null), 3, null);
    }

    private final void Ga(MenuItem menuItem) {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new g(menuItem, null), 3, null);
    }

    private final void Ha() {
        xa().l2(false);
        if (m8("android.permission.READ_CONTACTS")) {
            return;
        }
        C5505Jq.M("android.permission.READ_CONTACTS", false);
        C5505Jq.M("android.permission.READ_CONTACTS_fragment", false);
    }

    private final void Ia() {
        xa().W1();
        xa().l2(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja(InterfaceC15069ix3 interfaceC15069ix3, C20996sx3 c20996sx3) {
        if (c20996sx3.g() > 0) {
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, I61.a.a(), 3, null);
        }
        InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), null, null, AbstractC19242q11.c(-803929780, true, new h(c20996sx3, this)), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ka(C22023uY contact) {
        xa().a2(contact.c()).a(new i(contact));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void La(int requestCode) {
        if (requestCode == 1011 || requestCode == 1012) {
            C5505Jq.L(this, requestCode, null);
            return;
        }
        if (requestCode == 1014) {
            C5505Jq.J(this, requestCode, null);
        } else if (requestCode == 1019 || requestCode == 1020) {
            C5505Jq.K(this, requestCode, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma(M75 item) {
        n8(C20778sb3.a.a(item.c(), Y8(ED5.invitation_via_sms)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MenuItem Oa(MenuItem menuItem, int i2, int i3) {
        menuItem.setIcon(AbstractC4043Dl1.f(S7(), i2));
        menuItem.setTitle(h6(i3));
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Pa(C20996sx3 c20996sx3) {
        return (c20996sx3.i().d() instanceof AbstractC13460gG3.c) && c20996sx3.i().a().a() && C8386Vt0.i6() && c20996sx3.g() <= 15;
    }

    private final void Qa() {
        if (ya()) {
            xa().l2(true);
        } else {
            pa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ra() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(350177135, true, new j()), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 Sa(C6229Ms4 c6229Ms4) {
        AbstractC13042fc3.i(c6229Ms4, "this$0");
        ConstraintLayout root = c6229Ms4.ra().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return new C17468n10(root, null, 0, 6, null);
    }

    private final InterfaceC13730gj3 Ta() {
        return AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new q(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ua(C22023uY contact, boolean isVideo) {
        xa().e2(contact);
        C11458d25 c11458d25E = C11458d25.E(contact.c());
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        C20384rv0 c20384rv0 = C20384rv0.a;
        C20384rv0.c0(c11458d25E.getPeerId(), isVideo, new SA2() { // from class: ir.nasim.Ks4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6229Ms4.Va(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Ls4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6229Ms4.Wa(this.a);
            }
        }, new r(this));
        C5074Hu0.a.d(EnumC22288uz0.e, isVideo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Va(C6229Ms4 c6229Ms4) {
        AbstractC13042fc3.i(c6229Ms4, "this$0");
        C17468n10 c17468n10Sa = c6229Ms4.sa();
        String strH6 = c6229Ms4.h6(ED5.not_possible_to_use_when_calling);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10Sa.o(strH6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Wa(C6229Ms4 c6229Ms4) {
        AbstractC13042fc3.i(c6229Ms4, "this$0");
        FragmentActivity fragmentActivityQ7 = c6229Ms4.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C24398yZ.c(fragmentActivityQ7, c6229Ms4).show();
        return C19938rB7.a;
    }

    private final void Xa() {
        if (((Boolean) xa().u1().getValue()).booleanValue()) {
            xa().j2();
            return;
        }
        C17468n10 c17468n10Wa = wa();
        String strH6 = h6(ED5.change_privacy_setting_to_sort_contacts_by_last_seen);
        AbstractC13042fc3.h(strH6, "getString(...)");
        C17468n10.p(c17468n10Wa, strH6, new AbstractC13463gG6.a(h6(ED5.settings_setting), null, false, new SA2() { // from class: ir.nasim.Fs4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6229Ms4.Ya(this.a);
            }
        }, 2, null), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ya(C6229Ms4 c6229Ms4) {
        AbstractC13042fc3.i(c6229Ms4, "this$0");
        C22042ua0.A9(c6229Ms4, C8386Vt0.Z9() ? c6229Ms4.va().a() : new C4747Gj6(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 ma(C6229Ms4 c6229Ms4) {
        AbstractC13042fc3.i(c6229Ms4, "this$0");
        ConstraintLayout root = c6229Ms4.ra().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.m(4000);
        return c17468n10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na(InterfaceC15069ix3 interfaceC15069ix3, C20996sx3 c20996sx3) {
        InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), AbstractC13259fv3.a(c20996sx3, new UA2() { // from class: ir.nasim.Gs4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6229Ms4.oa((C22023uY) obj);
            }
        }), null, AbstractC19242q11.c(-280170566, true, new b(c20996sx3, this)), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object oa(C22023uY c22023uY) {
        AbstractC13042fc3.i(c22023uY, "it");
        return Integer.valueOf(c22023uY.c());
    }

    private final void pa() {
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
        } : null, C21753u45.d.h, C21753u45.d.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa(C22023uY contact) {
        int iC = contact.c();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        n8(C22055ub3.c(iC, contextS7));
    }

    private final C5814Ky2 ra() {
        Object objA = this.binding.a(this, p1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C5814Ky2) objA;
    }

    private final C17468n10 sa() {
        return (C17468n10) this.callErrorsSnackBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17468n10 wa() {
        return (C17468n10) this.snackBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C21646tt4 xa() {
        return (C21646tt4) this.viewModel.getValue();
    }

    private final boolean ya() {
        return AbstractC4043Dl1.a(S7(), "android.permission.READ_CONTACTS") == 0;
    }

    private final void za() {
        ComposeView composeView = ra().c;
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(1317679001, true, new c()));
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Qa();
    }

    public final void Na(EnumC6843Pf2 fabricEventType) {
        AbstractC13042fc3.i(fabricEventType, "fabricEventType");
        HashMap map = new HashMap();
        map.put("origin", Integer.valueOf(fabricEventType.j()));
        C3343Am.i("open_contacts", map);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C5814Ky2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        if (ra().b.getVisibility() != 0) {
            return super.a();
        }
        xa().c2("");
        xa().d2(false);
        ra().b.setVisibility(8);
        ra().e.setVisibility(0);
        ra().b.h();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int requestCode, String[] permissions, int[] grantResults) {
        C22023uY c22023uY;
        C22023uY c22023uY2;
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        if (requestCode != 1011) {
            if (requestCode != 1012 && requestCode != 1014) {
                if (requestCode == 1088) {
                    Integer numD0 = AbstractC10242bK.d0(grantResults);
                    if (numD0 != null && numD0.intValue() == 0) {
                        Ia();
                        return;
                    } else {
                        Ha();
                        return;
                    }
                }
                if (requestCode != 1019) {
                    if (requestCode != 1020) {
                        super.g7(requestCode, permissions, grantResults);
                        return;
                    }
                }
            }
            Integer numD02 = AbstractC10242bK.d0(grantResults);
            if (numD02 == null || numD02.intValue() != 0 || (c22023uY2 = (C22023uY) xa().I1().getValue()) == null) {
                return;
            }
            Ua(c22023uY2, true);
            return;
        }
        Integer numD03 = AbstractC10242bK.d0(grantResults);
        if (numD03 == null || numD03.intValue() != 0 || (c22023uY = (C22023uY) xa().I1().getValue()) == null) {
            return;
        }
        Ua(c22023uY, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void j7() {
        super.j7();
        xa().l2(ya());
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        Aa();
        za();
        Ea();
        Ta();
        xa().V1();
    }

    public final InterfaceC9687aO2 ta() {
        InterfaceC9687aO2 interfaceC9687aO2 = this.groupTypeMakerNavigator;
        if (interfaceC9687aO2 != null) {
            return interfaceC9687aO2;
        }
        AbstractC13042fc3.y("groupTypeMakerNavigator");
        return null;
    }

    public final DK4 ua() {
        DK4 dk4 = this.onBoardingNavigator;
        if (dk4 != null) {
            return dk4;
        }
        AbstractC13042fc3.y("onBoardingNavigator");
        return null;
    }

    public final InterfaceC17297mj6 va() {
        InterfaceC17297mj6 interfaceC17297mj6 = this.securityNavigator;
        if (interfaceC17297mj6 != null) {
            return interfaceC17297mj6;
        }
        AbstractC13042fc3.y("securityNavigator");
        return null;
    }

    /* renamed from: ir.nasim.Ms4$i */
    public static final class i implements InterfaceC15419jZ0 {
        final /* synthetic */ C22023uY b;

        i(C22023uY c22023uY) {
            this.b = c22023uY;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C6229Ms4.this.wa().o("Failed to remove " + this.b.e() + " from your contacts");
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
        }
    }
}
