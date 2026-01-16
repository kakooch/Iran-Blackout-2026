package ir.nasim.chat;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC8628Wu;
import ir.nasim.C11458d25;
import ir.nasim.C14819iX7;
import ir.nasim.C18614ox2;
import ir.nasim.C18987pb3;
import ir.nasim.C19938rB7;
import ir.nasim.C25226zw5;
import ir.nasim.C6502Nu;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.chat.C11204a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001'B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006*²\u0006\u0014\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u00048\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/chat/a;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "", "groups", "Lir/nasim/rB7;", "x8", "(Ljava/util/List;)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "b1", "Ljava/util/List;", "Lir/nasim/Nu;", "c1", "Lir/nasim/Yu3;", "y8", "()Lir/nasim/Nu;", "viewModel", "Lir/nasim/ox2;", "d1", "Lir/nasim/bW7;", "w8", "()Lir/nasim/ox2;", "binding", "e1", "a", "Lir/nasim/iL2;", "sharedGroups", "chat_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.chat.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11204a extends i1 {

    /* renamed from: b1, reason: from kotlin metadata */
    private List groups;

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C6502Nu.class), new c(this), new d(null, this), new e(this));

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new f(), AbstractC20046rN7.c());
    static final /* synthetic */ InterfaceC5239Im3[] f1 = {AbstractC10882cM5.i(new C25226zw5(C11204a.class, "binding", "getBinding()Lir/nasim/chat/databinding/FragmentAnonymousContactSharedGroupBinding;", 0))};

    /* renamed from: e1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int g1 = 8;

    /* renamed from: ir.nasim.chat.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C11204a a(List list) {
            AbstractC13042fc3.i(list, "groups");
            C11204a c11204a = new C11204a();
            Bundle bundle = new Bundle();
            bundle.putIntegerArrayList("SHARED_GROUPS", new ArrayList<>(list));
            c11204a.a8(bundle);
            return c11204a;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.chat.a$b */
    static final class b implements InterfaceC14603iB2 {
        b() {
        }

        private static final List d(InterfaceC9664aL6 interfaceC9664aL6) {
            return (List) interfaceC9664aL6.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C11204a c11204a) {
            AbstractC13042fc3.i(c11204a, "this$0");
            c11204a.Q7().onBackPressed();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(C11458d25 c11458d25) {
            AbstractC13042fc3.i(c11458d25, "it");
            C18987pb3.x1(C18987pb3.a, c11458d25, null, null, false, null, null, false, null, null, false, null, 2046, null);
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            List listD = d(AbstractC10222bH6.b(C11204a.this.y8().S0(), null, interfaceC22053ub1, 0, 1));
            if (listD == null) {
                return;
            }
            final C11204a c11204a = C11204a.this;
            interfaceC22053ub1.W(484784896);
            boolean zD = interfaceC22053ub1.D(c11204a);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.chat.b
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C11204a.b.f(c11204a);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(484788793);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.chat.c
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C11204a.b.h((C11458d25) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC8628Wu.e(null, sa2, listD, (UA2) objB2, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.chat.a$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    /* renamed from: ir.nasim.chat.a$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    /* renamed from: ir.nasim.chat.a$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    /* renamed from: ir.nasim.chat.a$f */
    public static final class f extends AbstractC8614Ws3 implements UA2 {
        public f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C18614ox2.a(fragment.V7());
        }
    }

    private final C18614ox2 w8() {
        Object objA = this.binding.a(this, f1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C18614ox2) objA;
    }

    private final void x8(List groups) {
        if (groups != null) {
            y8().T0(groups);
        }
        w8().b.setContent(AbstractC19242q11.c(959478936, true, new b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6502Nu y8() {
        return (C6502Nu) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.groups = bundleE5.getIntegerArrayList("SHARED_GROUPS");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C18614ox2 c18614ox2C = C18614ox2.c(Q5(), container, false);
        AbstractC13042fc3.h(c18614ox2C, "inflate(...)");
        return c18614ox2C.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        x8(this.groups);
    }
}
