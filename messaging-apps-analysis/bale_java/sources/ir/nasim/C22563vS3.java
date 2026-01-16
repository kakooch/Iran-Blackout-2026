package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C13122fh6;
import ir.nasim.C22563vS3;
import ir.nasim.C22698vg6;
import ir.nasim.C9059Yh6;
import ir.nasim.C9293Zh6;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.core.modules.market.model.SearchSuggestionRow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001QB\t\b\u0007¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0012H\u0002¢\u0006\u0004\b#\u0010\u0007J\u000f\u0010$\u001a\u00020\u0000H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0000H\u0002¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\u0000H\u0002¢\u0006\u0004\b'\u0010%J\u000f\u0010(\u001a\u00020\u0012H\u0002¢\u0006\u0004\b(\u0010\u0007J\u000f\u0010)\u001a\u00020\u0000H\u0002¢\u0006\u0004\b)\u0010%J\u000f\u0010*\u001a\u00020\u0000H\u0002¢\u0006\u0004\b*\u0010%J\u0017\u0010-\u001a\u00020\u00122\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u001f\u00102\u001a\u00020\u00122\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020+H\u0002¢\u0006\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006R"}, d2 = {"Lir/nasim/vS3;", "Lir/nasim/ua0;", "Lir/nasim/Zh6$a;", "Lir/nasim/fh6$b;", "Lir/nasim/fh6$d;", "Lir/nasim/Yh6$a;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lir/nasim/rB7;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/core/modules/market/model/SearchSuggestionRow;", "item", "n5", "(Lir/nasim/core/modules/market/model/SearchSuggestionRow;)V", "Lir/nasim/core/modules/market/model/SearchSuggestion;", "k5", "(Lir/nasim/core/modules/market/model/SearchSuggestion;)V", "Lir/nasim/vg6$b;", "peer", "z1", "(Lir/nasim/vg6$b;)V", "Lir/nasim/vg6$d;", "r2", "(Lir/nasim/vg6$d;)V", "fa", "ma", "()Lir/nasim/vS3;", "na", "ea", "ha", "oa", "ja", "", "term", "wa", "(Ljava/lang/String;)V", "", "id", "nick", "qa", "(ILjava/lang/String;)V", "", "h1", "Z", "isChannelLoading", "Lir/nasim/Ay2;", "i1", "Lir/nasim/bW7;", "ga", "()Lir/nasim/Ay2;", "binding", "Lir/nasim/lT3;", "j1", "Lir/nasim/Yu3;", "ia", "()Lir/nasim/lT3;", "viewModel", "Lir/nasim/Zh6;", "k1", "Lir/nasim/Zh6;", "suggestionRowAdapter", "Lir/nasim/Ff6;", "l1", "Lir/nasim/Ff6;", "searchCategoriesAdapter", "Lir/nasim/uO3;", "m1", "Lir/nasim/uO3;", "suggestionDecorator", "n1", "a", "market_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.vS3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C22563vS3 extends YW2 implements C9293Zh6.a, C13122fh6.b, C13122fh6.d, C9059Yh6.a {

    /* renamed from: h1, reason: from kotlin metadata */
    private boolean isChannelLoading;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new g(), AbstractC20046rN7.c());

    /* renamed from: j1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: k1, reason: from kotlin metadata */
    private final C9293Zh6 suggestionRowAdapter;

    /* renamed from: l1, reason: from kotlin metadata */
    private final C4462Ff6 searchCategoriesAdapter;

    /* renamed from: m1, reason: from kotlin metadata */
    private final C21937uO3 suggestionDecorator;
    static final /* synthetic */ InterfaceC5239Im3[] o1 = {AbstractC10882cM5.i(new C25226zw5(C22563vS3.class, "binding", "getBinding()Lir/nasim/market/databinding/FragmentMarketSearchBinding;", 0))};

    /* renamed from: n1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int p1 = 8;

    /* renamed from: ir.nasim.vS3$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C22563vS3 a() {
            return new C22563vS3();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.vS3$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SearchSuggestion.a.values().length];
            try {
                iArr[SearchSuggestion.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SearchSuggestion.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.vS3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.vS3$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C22563vS3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C22563vS3 c22563vS3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c22563vS3;
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
                this.d.suggestionRowAdapter.C((ArrayList) this.c);
                this.d.suggestionRowAdapter.notifyDataSetChanged();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ArrayList arrayList, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(arrayList, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22563vS3.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6Z0 = C22563vS3.this.ia().Z0();
                a aVar = new a(C22563vS3.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6Z0, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.vS3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.vS3$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C22563vS3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C22563vS3 c22563vS3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c22563vS3;
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
                this.d.searchCategoriesAdapter.B((List) this.c);
                this.d.searchCategoriesAdapter.notifyDataSetChanged();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22563vS3.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6Y0 = C22563vS3.this.ia().Y0();
                a aVar = new a(C22563vS3.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6Y0, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.vS3$f */
    static final class f implements InterfaceC15796kB2 {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C22563vS3 c22563vS3, Dialog dialog) {
            AbstractC13042fc3.i(c22563vS3, "this$0");
            AbstractC13042fc3.i(dialog, "$dialog");
            c22563vS3.ia().c1();
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
            int i2 = JD5.market_search_clear_recent_list_dialog_yes;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            int i3 = JD5.market_search_clear_recent_list_dialog_no;
            B61 b61 = B61.a;
            InterfaceC14603iB2 interfaceC14603iB2A = b61.a();
            InterfaceC14603iB2 interfaceC14603iB2B = b61.b();
            interfaceC22053ub1.W(-16621630);
            boolean zD = interfaceC22053ub1.D(C22563vS3.this) | interfaceC22053ub1.D(dialog);
            final C22563vS3 c22563vS3 = C22563vS3.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.wS3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C22563vS3.f.d(c22563vS3, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-16612240);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.xS3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C22563vS3.f.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, i3, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vS3$g */
    public static final class g extends AbstractC8614Ws3 implements UA2 {
        public g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C3454Ay2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.vS3$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.vS3$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.vS3$j */
    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.vS3$k */
    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.vS3$l */
    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C22563vS3() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new i(new h(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C16550lT3.class), new j(interfaceC9173Yu3B), new k(null, interfaceC9173Yu3B), new l(this, interfaceC9173Yu3B));
        this.suggestionRowAdapter = new C9293Zh6();
        this.searchCategoriesAdapter = new C4462Ff6(new UA2() { // from class: ir.nasim.pS3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C22563vS3.va(this.a, (C4711Gf6) obj);
            }
        });
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        this.suggestionDecorator = new C21937uO3(aVar.f(4.0f), aVar.f(12.0f), aVar.f(28.0f), 0, 0, 24, null);
    }

    private final C22563vS3 ea() {
        ga().i.setAdapter(this.suggestionRowAdapter);
        ga().i.addItemDecoration(this.suggestionDecorator);
        ha();
        return this;
    }

    private final void fa() {
        ia().a1();
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new c(null), 3, null);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3454Ay2 ga() {
        Object objA = this.binding.a(this, o1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C3454Ay2) objA;
    }

    private final void ha() {
        ia().b1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C16550lT3 ia() {
        return (C16550lT3) this.viewModel.getValue();
    }

    private final C22563vS3 ja() {
        EditText editText = ga().f;
        AbstractC13042fc3.h(editText, "editTxt");
        editText.addTextChangedListener(new e());
        ga().f.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.rS3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return C22563vS3.ka(this.a, textView, i2, keyEvent);
            }
        });
        ga().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sS3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C22563vS3.la(this.a, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ka(C22563vS3 c22563vS3, TextView textView, int i2, KeyEvent keyEvent) {
        AbstractC13042fc3.i(c22563vS3, "this$0");
        if (!AbstractC20762sZ6.n0(textView.getText().toString())) {
            c22563vS3.ia().X0(new SearchSuggestion(SearchSuggestion.a.a, textView.getText().toString(), null, null, null, null, null, 124, null));
            c22563vS3.ha();
            EditText editText = c22563vS3.ga().f;
            AbstractC13042fc3.h(editText, "editTxt");
            AbstractC24706z42.a(editText);
            c22563vS3.wa(textView.getText().toString());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(C22563vS3 c22563vS3, View view) {
        AbstractC13042fc3.i(c22563vS3, "this$0");
        c22563vS3.ga().f.setText((CharSequence) null);
    }

    private final C22563vS3 ma() {
        ga().h.setTypeface(C6011Lu2.i());
        return this;
    }

    private final C22563vS3 na() {
        C9293Zh6 c9293Zh6 = this.suggestionRowAdapter;
        c9293Zh6.D(this);
        c9293Zh6.F(this);
        ga().d.setAdapter(this.searchCategoriesAdapter);
        return this;
    }

    private final C22563vS3 oa() {
        ga().j.setNavigationOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qS3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C22563vS3.pa(this.a, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(C22563vS3 c22563vS3, View view) {
        AbstractC13042fc3.i(c22563vS3, "this$0");
        C22042ua0.m9(c22563vS3, c22563vS3, false, 2, null);
    }

    private final void qa(int id, final String nick) {
        if (this.isChannelLoading) {
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (C4100Dr4.a(contextS7)) {
            this.isChannelLoading = true;
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            final ProgressDialog progressDialogE = C8920Xu5.e(contextS72, true);
            progressDialogE.setCancelable(false);
            AbstractC5969Lp4.b().k(id).m0(new InterfaceC24449ye1() { // from class: ir.nasim.nS3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C22563vS3.ra(this.a, nick, progressDialogE, (C14733iO2) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.oS3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C22563vS3.ta(nick, this, progressDialogE, (Exception) obj);
                }
            });
            return;
        }
        LinearLayout linearLayoutB = ga().getRoot();
        AbstractC13042fc3.h(linearLayoutB, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(linearLayoutB, null, 0, 6, null);
        c17468n10.k(ga().getRoot());
        String strH6 = h6(AbstractC12217eE5.card_payment_please_check_your_internet_conenction);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10.o(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(final C22563vS3 c22563vS3, String str, ProgressDialog progressDialog, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(c22563vS3, "this$0");
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        if (c14733iO2 != null) {
            C11458d25 c11458d25 = new C11458d25(W25.b, c14733iO2.r());
            C5735Kp4.w().o(c11458d25);
            C18987pb3.x1(C18987pb3.a, c11458d25, null, null, false, null, null, false, null, null, false, null, 2046, null);
        } else {
            C5735Kp4.w().J(c22563vS3.S7(), str, "market");
        }
        C8920Xu5.c();
        progressDialog.dismiss();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.tS3
            @Override // java.lang.Runnable
            public final void run() {
                C22563vS3.sa(this.a);
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(C22563vS3 c22563vS3) {
        AbstractC13042fc3.i(c22563vS3, "this$0");
        c22563vS3.isChannelLoading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(String str, final C22563vS3 c22563vS3, ProgressDialog progressDialog, Exception exc) {
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(c22563vS3, "this$0");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        if (str.length() > 0) {
            C5735Kp4.w().J(c22563vS3.S7(), str, "market");
        }
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
        C8920Xu5.c();
        progressDialog.dismiss();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.uS3
            @Override // java.lang.Runnable
            public final void run() {
                C22563vS3.ua(this.a);
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(C22563vS3 c22563vS3) {
        AbstractC13042fc3.i(c22563vS3, "this$0");
        c22563vS3.isChannelLoading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(C22563vS3 c22563vS3, C4711Gf6 c4711Gf6) {
        AbstractC13042fc3.i(c22563vS3, "this$0");
        AbstractC13042fc3.i(c4711Gf6, "searchCategory");
        c22563vS3.wa(c4711Gf6.b());
        return C19938rB7.a;
    }

    private final void wa(String term) {
        C22042ua0.m9(this, this, false, 2, null);
        C22042ua0.A9(this, ES3.l1.a(term), false, null, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        LinearLayout linearLayoutB = C3454Ay2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(linearLayoutB, "getRoot(...)");
        return linearLayoutB;
    }

    @Override // ir.nasim.C9059Yh6.a
    public void k5(SearchSuggestion item) {
        AbstractC13042fc3.i(item, "item");
        EditText editText = ga().f;
        AbstractC13042fc3.h(editText, "editTxt");
        AbstractC24706z42.a(editText);
        int iIndexOf = ((SearchSuggestionRow) this.suggestionRowAdapter.z().get(0)).getItems().indexOf(item);
        SearchSuggestion.a action = item.getAction();
        int i2 = action == null ? -1 : b.a[action.ordinal()];
        if (i2 == -1) {
            String term = item.getTerm();
            if (term == null) {
                term = "";
            }
            wa(term);
        } else if (i2 == 1) {
            String term2 = item.getTerm();
            if (term2 != null) {
                new C15494jg6(term2, null, Integer.valueOf(iIndexOf), null, null, 1, null, 90, null).a();
            }
            C22042ua0.m9(this, this, false, 2, null);
            String term3 = item.getTerm();
            if (term3 != null) {
                C22042ua0.A9(this, ES3.l1.a(term3), false, null, 6, null);
            }
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            SearchSuggestion.Peer peer = item.getPeer();
            if (peer != null) {
                new C15494jg6(peer.getTitle(), null, Integer.valueOf(iIndexOf), null, Integer.valueOf(peer.getId()), 1, null, 74, null).a();
                qa(peer.getId(), peer.getNick());
            }
        }
        if (item.getAction() != null) {
            ia().X0(item);
            ha();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        oa().ma().ja().na().ea();
        EditText editText = ga().f;
        AbstractC13042fc3.h(editText, "editTxt");
        AbstractC24706z42.b(editText);
        fa();
    }

    @Override // ir.nasim.C9293Zh6.a
    public void n5(SearchSuggestionRow item) {
        AbstractC13042fc3.i(item, "item");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(422439142, true, new f()), 4, null).show();
    }

    @Override // ir.nasim.C13122fh6.d
    public void r2(C22698vg6.d peer) {
        AbstractC13042fc3.i(peer, "peer");
        EditText editText = ga().f;
        AbstractC13042fc3.h(editText, "editTxt");
        AbstractC24706z42.a(editText);
        ia();
        SearchSuggestion.a aVar = SearchSuggestion.a.a;
        throw null;
    }

    @Override // ir.nasim.C13122fh6.b
    public void z1(C22698vg6.b peer) {
        AbstractC13042fc3.i(peer, "peer");
        EditText editText = ga().f;
        AbstractC13042fc3.h(editText, "editTxt");
        AbstractC24706z42.a(editText);
        ia().X0(new SearchSuggestion(SearchSuggestion.a.b, peer.f(), "tv", new SearchSuggestion.Peer(peer.e(), peer.f(), peer.d()), null, null, null, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null));
        qa(peer.d(), peer.e());
    }

    /* renamed from: ir.nasim.vS3$e */
    public static final class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() == 0) {
                C22563vS3.this.ga().i.setVisibility(0);
                C22563vS3.this.ga().d.setVisibility(8);
            } else {
                C22563vS3.this.ga().i.setVisibility(8);
                C22563vS3.this.ga().d.setVisibility(0);
            }
            C22563vS3.this.ia().d1(String.valueOf(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
