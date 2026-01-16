package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C14486i0;
import ir.nasim.C7695Su7;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001LB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u0019\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0003R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006M"}, d2 = {"Lir/nasim/Su7;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/Be1;", "contact", "Lir/nasim/rB7;", "ta", "(Lir/nasim/Be1;)V", "sa", "ma", "", "description", "ea", "(Ljava/lang/String;)V", "na", "ia", "pa", "search", "ja", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "c7", "Lir/nasim/Hz2;", "h1", "Lir/nasim/bW7;", "fa", "()Lir/nasim/Hz2;", "binding", "", "i1", "Z", "la", "()Z", "setGroup", "(Z)V", "isGroup", "", "j1", TokenNames.I, "ga", "()I", "setGId", "(I)V", "gId", "Lir/nasim/fh1;", "k1", "Lir/nasim/fh1;", "contactsAdapter", "Lir/nasim/ak1;", "l1", "Lir/nasim/Yu3;", "ha", "()Lir/nasim/ak1;", "viewModel", "Lir/nasim/n10;", "m1", "Lir/nasim/n10;", "snackBar", "Lir/nasim/gj3;", "n1", "Lir/nasim/gj3;", "job", "o1", "a", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Su7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C7695Su7 extends XX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new g(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private boolean isGroup;

    /* renamed from: j1, reason: from kotlin metadata */
    private int gId;

    /* renamed from: k1, reason: from kotlin metadata */
    private C13117fh1 contactsAdapter;

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: m1, reason: from kotlin metadata */
    private C17468n10 snackBar;

    /* renamed from: n1, reason: from kotlin metadata */
    private InterfaceC13730gj3 job;
    static final /* synthetic */ InterfaceC5239Im3[] p1 = {AbstractC10882cM5.i(new C25226zw5(C7695Su7.class, "binding", "getBinding()Lir/nasim/sharedmedia/databinding/FragmentTransferringOwnerBinding;", 0))};

    /* renamed from: o1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q1 = 8;

    /* renamed from: ir.nasim.Su7$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C7695Su7 a(int i, boolean z) {
            C7695Su7 c7695Su7 = new C7695Su7();
            Bundle bundle = new Bundle();
            bundle.putInt("gid", i);
            bundle.putBoolean("is_group", z);
            c7695Su7.a8(bundle);
            return c7695Su7;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Su7$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ String a;

        /* renamed from: ir.nasim.Su7$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC14603iB2 interfaceC14603iB2D = C20766sa1.a.d();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-607722701, true, new a(this.a), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(1399748459);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Tu7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C7695Su7.b.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC14603iB2D, cVar, interfaceC18060o11E, cVar2, null, null, (SA2) objB, RD5.understand, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Su7$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7695Su7.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(550L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C7695Su7.this.fa().f.setVisibility(8);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Su7$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* renamed from: ir.nasim.Su7$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C7695Su7 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C7695Su7 c7695Su7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c7695Su7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    NT4 nt4 = (NT4) this.c;
                    C13117fh1 c13117fh1 = this.d.contactsAdapter;
                    if (c13117fh1 == null) {
                        AbstractC13042fc3.y("contactsAdapter");
                        c13117fh1 = null;
                    }
                    this.b = 1;
                    if (c13117fh1.L(nt4, this) == objE) {
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
            public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7695Su7.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2U0 = C7695Su7.this.ha().U0(this.d);
                a aVar = new a(C7695Su7.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2U0, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Su7$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Su7$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C7695Su7 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C7695Su7 c7695Su7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c7695Su7;
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
                AbstractC13460gG3 abstractC13460gG3D = ((C13628gZ0) this.c).d();
                if (abstractC13460gG3D instanceof AbstractC13460gG3.b) {
                    this.d.fa().f.setVisibility(0);
                    this.d.fa().c.setVisibility(8);
                    this.d.fa().b.setVisibility(0);
                } else if (abstractC13460gG3D instanceof AbstractC13460gG3.c) {
                    C13117fh1 c13117fh1 = this.d.contactsAdapter;
                    if (c13117fh1 == null) {
                        AbstractC13042fc3.y("contactsAdapter");
                        c13117fh1 = null;
                    }
                    if (c13117fh1.getItemCount() == 0) {
                        this.d.fa().c.setVisibility(0);
                        this.d.fa().b.setVisibility(8);
                    } else {
                        this.d.fa().c.setVisibility(8);
                        this.d.fa().b.setVisibility(0);
                    }
                    this.d.ia();
                } else {
                    this.d.ia();
                    this.d.fa().c.setVisibility(0);
                    this.d.fa().b.setVisibility(8);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C13628gZ0 c13628gZ0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c13628gZ0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7695Su7.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13117fh1 c13117fh1 = C7695Su7.this.contactsAdapter;
                if (c13117fh1 == null) {
                    AbstractC13042fc3.y("contactsAdapter");
                    c13117fh1 = null;
                }
                InterfaceC4557Fq2 interfaceC4557Fq2E = c13117fh1.E();
                a aVar = new a(C7695Su7.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2E, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Su7$g */
    public static final class g extends AbstractC8614Ws3 implements UA2 {
        public g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C5121Hz2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Su7$h */
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

    /* renamed from: ir.nasim.Su7$i */
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

    /* renamed from: ir.nasim.Su7$j */
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

    /* renamed from: ir.nasim.Su7$k */
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

    /* renamed from: ir.nasim.Su7$l */
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

    /* renamed from: ir.nasim.Su7$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C3512Be1 d;

        /* renamed from: ir.nasim.Su7$m$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ C7695Su7 a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ String d;

            /* renamed from: ir.nasim.Su7$m$a$a, reason: collision with other inner class name */
            static final class C0633a implements InterfaceC14603iB2 {
                final /* synthetic */ int a;

                C0633a(int i) {
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

            /* renamed from: ir.nasim.Su7$m$a$b */
            static final class b implements InterfaceC14603iB2 {
                final /* synthetic */ String a;

                b(String str) {
                    this.a = str;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                    } else {
                        AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                    }
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C7695Su7 c7695Su7, int i, int i2, String str) {
                this.a = c7695Su7;
                this.b = i;
                this.c = i2;
                this.d = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(Dialog dialog, final C7695Su7 c7695Su7) {
                AbstractC13042fc3.i(dialog, "$it");
                AbstractC13042fc3.i(c7695Su7, "this$0");
                dialog.dismiss();
                c7695Su7.ha().W0(c7695Su7.getGId()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Wu7
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        C7695Su7.m.a.i(c7695Su7, (C14505i18) obj);
                    }
                }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Xu7
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        C7695Su7.m.a.k(c7695Su7, (Exception) obj);
                    }
                });
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void i(C7695Su7 c7695Su7, C14505i18 c14505i18) {
                AbstractC13042fc3.i(c7695Su7, "this$0");
                c7695Su7.ma();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void k(C7695Su7 c7695Su7, Exception exc) {
                AbstractC13042fc3.i(c7695Su7, "this$0");
                c7695Su7.ea(UN2.a(exc, c7695Su7.getIsGroup() ? ZN2.GROUP : ZN2.CHANNEL));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(Dialog dialog, C7695Su7 c7695Su7) {
                AbstractC13042fc3.i(dialog, "$it");
                AbstractC13042fc3.i(c7695Su7, "this$0");
                dialog.dismiss();
                c7695Su7.Q7().onBackPressed();
                return C19938rB7.a;
            }

            public final void f(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(dialog, "it");
                InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1078256476, true, new C0633a(this.c), interfaceC22053ub1, 54);
                AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1942026590, true, new b(this.d), interfaceC22053ub1, 54);
                AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
                interfaceC22053ub1.W(-1148330917);
                boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.a);
                final C7695Su7 c7695Su7 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Uu7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C7695Su7.m.a.h(dialog, c7695Su7);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                int i2 = this.b;
                InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                interfaceC22053ub1.W(-1148309641);
                boolean zD2 = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.a);
                final C7695Su7 c7695Su72 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Vu7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C7695Su7.m.a.n(dialog, c7695Su72);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC19555qZ.E(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, RD5.dialog_cancel, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 1024);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                f((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(C3512Be1 c3512Be1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c3512Be1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7695Su7.this.new m(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(150L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            int i2 = C7695Su7.this.getIsGroup() ? RD5.alert_leave_group_title : RD5.leave_channel;
            C7695Su7 c7695Su7 = C7695Su7.this;
            String strH6 = c7695Su7.h6(c7695Su7.getIsGroup() ? RD5.group : RD5.channel);
            AbstractC13042fc3.h(strH6, "getString(...)");
            String strH62 = C7695Su7.this.h6(RD5.trnsfer_owner_success_and_leave);
            AbstractC13042fc3.h(strH62, "getString(...)");
            String name = this.d.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            String strM = AbstractC20153rZ6.M(AbstractC20153rZ6.M(strH62, "{0}", name, false, 4, null), "{1}", strH6, false, 4, null);
            int i3 = C7695Su7.this.getIsGroup() ? RD5.alert_leave_group_title : RD5.leave_channel;
            Context contextS7 = C7695Su7.this.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = C7695Su7.this.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-902829952, true, new a(C7695Su7.this, i3, i2, strM)), 4, null).show();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Su7$n */
    static final class n implements InterfaceC15796kB2 {
        final /* synthetic */ Dialog b;

        n(Dialog dialog) {
            this.b = dialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C7695Su7 c7695Su7) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(c7695Su7, "this$0");
            dialog.dismiss();
            C14486i0.a aVar = C14486i0.f;
            FragmentActivity fragmentActivityQ7 = c7695Su7.Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            C14486i0 c14486i0A = aVar.a(fragmentActivityQ7);
            Context contextS7 = c7695Su7.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            FragmentActivity fragmentActivityQ72 = c7695Su7.Q7();
            AbstractC13042fc3.g(fragmentActivityQ72, "null cannot be cast to non-null type ir.nasim.designsystem.base.activity.BaseActivity");
            c14486i0A.o(new BottomSheetWebView(contextS7, (BaseActivity) fragmentActivityQ72, "https://tooshle.bale.ai/channel_report?channel_id=" + C11458d25.y(c7695Su7.getGId()).u(), c14486i0A, null, null, 32, null));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog, Dialog dialog2) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(dialog2, "$transferOwnerDialog");
            dialog.dismiss();
            dialog2.show();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            String strC = UY6.c(RD5.alert_group_receive_income_notice_yes, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(RD5.alert_group_receive_income_notice_no, interfaceC22053ub1, 0);
            C20766sa1 c20766sa1 = C20766sa1.a;
            InterfaceC14603iB2 interfaceC14603iB2B = c20766sa1.b();
            InterfaceC14603iB2 interfaceC14603iB2C = c20766sa1.c();
            interfaceC22053ub1.W(-1196494009);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C7695Su7.this);
            final C7695Su7 c7695Su7 = C7695Su7.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Yu7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C7695Su7.n.d(dialog, c7695Su7);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1196471999);
            boolean zD2 = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.b);
            final Dialog dialog2 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Zu7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C7695Su7.n.f(dialog, dialog2);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2B, cVar, interfaceC14603iB2C, cVar2, aVar, sa2, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Su7$o */
    static final class o implements InterfaceC15796kB2 {
        final /* synthetic */ C3512Be1 b;
        final /* synthetic */ String c;

        /* renamed from: ir.nasim.Su7$o$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        o(C3512Be1 c3512Be1, String str) {
            this.b = c3512Be1;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(final C7695Su7 c7695Su7, final C3512Be1 c3512Be1, Dialog dialog) {
            AbstractC13042fc3.i(c7695Su7, "this$0");
            AbstractC13042fc3.i(c3512Be1, "$contact");
            AbstractC13042fc3.i(dialog, "$it");
            c7695Su7.ha().Z0(c7695Su7.getGId(), c3512Be1.r(), c7695Su7.getIsGroup(), new UA2() { // from class: ir.nasim.cv7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C7695Su7.o.h(c7695Su7, c3512Be1, (C9475a16) obj);
                }
            });
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(C7695Su7 c7695Su7, C3512Be1 c3512Be1, C9475a16 c9475a16) {
            AbstractC13042fc3.i(c7695Su7, "this$0");
            AbstractC13042fc3.i(c3512Be1, "$contact");
            Object objL = c9475a16.l();
            if (C9475a16.j(objL)) {
                c7695Su7.sa(c3512Be1);
                AbstractC18623oy2.c(c7695Su7, "profile_transferred_owner_ship", AbstractC23348wm0.b(AbstractC4616Fw7.a("transferred", Boolean.TRUE)));
            }
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                c7695Su7.ea(UN2.a(thE, c7695Su7.getIsGroup() ? ZN2.GROUP : ZN2.CHANNEL));
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void d(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            int i2 = RD5.alert_group_owner_yes;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            int i3 = RD5.dialog_cancel;
            InterfaceC14603iB2 interfaceC14603iB2A = C20766sa1.a.a();
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(391891185, true, new a(this.c), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-1196546724);
            boolean zD = interfaceC22053ub1.D(C7695Su7.this) | interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(dialog);
            final C7695Su7 c7695Su7 = C7695Su7.this;
            final C3512Be1 c3512Be1 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.av7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C7695Su7.o.f(c7695Su7, c3512Be1, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1196553558);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.bv7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C7695Su7.o.i(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC18060o11E, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, i3, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public C7695Su7() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new i(new h(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C9894ak1.class), new j(interfaceC9173Yu3B), new k(null, interfaceC9173Yu3B), new l(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea(String description) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1747934430, true, new b(description)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5121Hz2 fa() {
        Object objA = this.binding.a(this, p1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C5121Hz2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C9894ak1 ha() {
        return (C9894ak1) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new c(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja(String search) {
        InterfaceC13730gj3 interfaceC13730gj3 = this.job;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.job = AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new d(search, null), 3, null);
    }

    static /* synthetic */ void ka(C7695Su7 c7695Su7, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        c7695Su7.ja(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ma() {
        AbstractC18623oy2.c(this, "success_leave", AbstractC23348wm0.a());
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        j9(fragmentActivityQ7);
    }

    private final void na() {
        this.contactsAdapter = new C13117fh1(new UA2() { // from class: ir.nasim.Ou7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7695Su7.oa(this.a, (C3512Be1) obj);
            }
        });
        RecyclerView recyclerView = fa().b;
        C13117fh1 c13117fh1 = this.contactsAdapter;
        if (c13117fh1 == null) {
            AbstractC13042fc3.y("contactsAdapter");
            c13117fh1 = null;
        }
        recyclerView.setAdapter(c13117fh1);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new e(null), 3, null);
        ka(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oa(C7695Su7 c7695Su7, C3512Be1 c3512Be1) {
        AbstractC13042fc3.i(c7695Su7, "this$0");
        AbstractC13042fc3.i(c3512Be1, "it");
        c7695Su7.ta(c3512Be1);
        return C19938rB7.a;
    }

    private final void pa() {
        LinearLayout root = fa().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.k(fa().getRoot());
        c17468n10.m(4000);
        this.snackBar = c17468n10;
        fa().e.setTypeface(C6011Lu2.k());
        BaleToolbar baleToolbar = fa().k;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        fa().j.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.Pu7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C7695Su7.qa(this.a, view, z);
            }
        });
        fa().i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Qu7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C7695Su7.ra(this.a, view);
            }
        });
        EditText editText = fa().j;
        AbstractC13042fc3.h(editText, "searchTxt");
        editText.addTextChangedListener(new f());
        fa().b.setLayoutManager(new LinearLayoutManager(S7()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(C7695Su7 c7695Su7, View view, boolean z) {
        AbstractC13042fc3.i(c7695Su7, "this$0");
        if (z) {
            c7695Su7.fa().h.setStrokeColor(C5495Jo7.a.u2());
        } else {
            c7695Su7.fa().h.setStrokeColor(C5495Jo7.a.B2());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(C7695Su7 c7695Su7, View view) {
        AbstractC13042fc3.i(c7695Su7, "this$0");
        c7695Su7.fa().j.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa(C3512Be1 contact) {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new m(contact, null), 3, null);
    }

    private final void ta(C3512Be1 contact) {
        String strH6 = h6(this.isGroup ? RD5.group : RD5.channel);
        AbstractC13042fc3.h(strH6, "getString(...)");
        String strH62 = h6(RD5.alert_transfeer_owner_text);
        AbstractC13042fc3.h(strH62, "getString(...)");
        String strM = AbstractC20153rZ6.M(strH62, "{0}", strH6, false, 4, null);
        String name = contact.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        String strM2 = AbstractC20153rZ6.M(strM, "{1}", name, false, 4, null);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        final Dialog dialogC = AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(2077492115, true, new o(contact, strM2)), 4, null);
        Context contextS72 = S7();
        AbstractC13042fc3.h(contextS72, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P62 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P62, "getViewLifecycleOwner(...)");
        final Dialog dialogC2 = AbstractC21375tZ.c(contextS72, interfaceC18633oz3P62, null, AbstractC19242q11.c(-767904009, true, new n(dialogC)), 4, null);
        ha().Y0(this.gId, this.isGroup, new UA2() { // from class: ir.nasim.Ru7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7695Su7.ua(dialogC2, dialogC, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ua(Dialog dialog, Dialog dialog2, boolean z) {
        AbstractC13042fc3.i(dialog, "$receiveIncomeNoticeDialog");
        AbstractC13042fc3.i(dialog2, "$transferOwnerDialog");
        if (z) {
            dialog.show();
        } else {
            dialog2.show();
        }
        return C19938rB7.a;
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.isGroup = bundleE5.getBoolean("is_group", false);
            this.gId = bundleE5.getInt("gid", 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.inflate(QC5.fragment_transferring_owner, container, false);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        fa().j.clearFocus();
        C23381wp3.f(fa().j);
    }

    /* renamed from: ga, reason: from getter */
    public final int getGId() {
        return this.gId;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        pa();
        na();
    }

    /* renamed from: la, reason: from getter */
    public final boolean getIsGroup() {
        return this.isGroup;
    }

    /* renamed from: ir.nasim.Su7$f */
    public static final class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 0) {
                C7695Su7.this.fa().i.setImageResource(AbstractC22412vB5.ba_appbar_close_1);
                C7695Su7.this.fa().i.setClickable(true);
            } else {
                C7695Su7.this.fa().i.setImageResource(AbstractC22412vB5.drawable_market_search);
                C7695Su7.this.fa().i.setClickable(false);
            }
            C7695Su7.this.ja(String.valueOf(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
