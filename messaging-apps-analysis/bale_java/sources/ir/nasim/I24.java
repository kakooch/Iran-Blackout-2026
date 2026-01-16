package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenTypes;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.C10087b34;
import ir.nasim.C14486i0;
import ir.nasim.GY;
import ir.nasim.I24;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.O98;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 `2\u00020\u0001:\u0001aB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\rJ\u000f\u0010\u001a\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001a\u0010\u0003J-\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0003R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010O\u001a\u00020H8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010W\u001a\u00020P8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010_\u001a\u00020X8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006b"}, d2 = {"Lir/nasim/I24;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "Aa", "Lir/nasim/Q14;", "member", "Landroid/view/View;", "anchorView", "oa", "(Lir/nasim/Q14;Landroid/view/View;)V", "wa", "(Lir/nasim/Q14;)V", "Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, "Ba", "(Lir/nasim/Q14;Lir/nasim/core/modules/profile/entity/ExPeerType;)V", "Lir/nasim/wM2;", "groupMember", "", "gid", "uid", "Ca", "(Lir/nasim/wM2;II)V", "Da", "xa", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "T6", "R6", "Lir/nasim/Fy2;", "h1", "Lir/nasim/bW7;", "ia", "()Lir/nasim/Fy2;", "binding", "", "i1", "Z", "loadInitialMember", "Lir/nasim/Wy6;", "j1", "Lir/nasim/Yu3;", "na", "()Lir/nasim/Wy6;", "viewModel", "Lir/nasim/Vi1;", "k1", "Lir/nasim/Vi1;", "ja", "()Lir/nasim/Vi1;", "setContactNavigator", "(Lir/nasim/Vi1;)V", "contactNavigator", "Lir/nasim/q24;", "l1", "Lir/nasim/q24;", "ka", "()Lir/nasim/q24;", "setMemberAccessNavigator", "(Lir/nasim/q24;)V", "memberAccessNavigator", "Lir/nasim/yb;", "m1", "Lir/nasim/yb;", "ha", "()Lir/nasim/yb;", "setAdminsAccessFragmentNavigator", "(Lir/nasim/yb;)V", "adminsAccessFragmentNavigator", "Lir/nasim/c34;", "n1", "Lir/nasim/c34;", "ma", "()Lir/nasim/c34;", "setMemberToGroupMemberMapper", "(Lir/nasim/c34;)V", "memberToGroupMemberMapper", "Lir/nasim/b34$a;", "o1", "Lir/nasim/b34$a;", "la", "()Lir/nasim/b34$a;", "setMemberStateBinderFactory", "(Lir/nasim/b34$a;)V", "memberStateBinderFactory", "p1", "a", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class I24 extends AbstractC10978cX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new i(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private boolean loadInitialMember;

    /* renamed from: j1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: k1, reason: from kotlin metadata */
    public InterfaceC8288Vi1 contactNavigator;

    /* renamed from: l1, reason: from kotlin metadata */
    public InterfaceC19255q24 memberAccessNavigator;

    /* renamed from: m1, reason: from kotlin metadata */
    public InterfaceC24417yb adminsAccessFragmentNavigator;

    /* renamed from: n1, reason: from kotlin metadata */
    public C10703c34 memberToGroupMemberMapper;

    /* renamed from: o1, reason: from kotlin metadata */
    public C10087b34.a memberStateBinderFactory;
    static final /* synthetic */ InterfaceC5239Im3[] q1 = {AbstractC10882cM5.i(new C25226zw5(I24.class, "binding", "getBinding()Lir/nasim/sharedmedia/databinding/FragmentMemberProfileBinding;", 0))};

    /* renamed from: p1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int r1 = 8;

    /* renamed from: ir.nasim.I24$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final I24 a() {
            return new I24();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ Q14 b;
        final /* synthetic */ String c;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ I24 a;

            a(I24 i24) {
                this.a = i24;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(UY6.c(this.a.na().d3() == ExPeerType.CHANNEL ? RD5.channel_context_remove_admin : RD5.group_context_remove_admin, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.I24$b$b, reason: collision with other inner class name */
        static final class C0407b implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            C0407b(String str) {
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

        b(Q14 q14, String str) {
            this.b = q14;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, I24 i24, Q14 q14) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(i24, "this$0");
            AbstractC13042fc3.i(q14, "$member");
            dialog.dismiss();
            i24.na().o4(q14.f());
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
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            String strC = UY6.c(RD5.context_remove_admin, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(RD5.dialog_cancel, interfaceC22053ub1, 0);
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-132514094, true, new a(I24.this), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-100876972, true, new C0407b(this.c), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-669723254);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(I24.this) | interfaceC22053ub1.V(this.b);
            final I24 i24 = I24.this;
            final Q14 q14 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.J24
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return I24.b.d(dialog, i24, q14);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-669713651);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.K24
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return I24.b.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, sa2, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ I24 d;

            /* renamed from: ir.nasim.I24$c$a$a, reason: collision with other inner class name */
            public static final class C0408a extends RecyclerView.t {
                final /* synthetic */ I24 a;
                final /* synthetic */ AbstractC17858ng6 b;

                C0408a(I24 i24, AbstractC17858ng6 abstractC17858ng6) {
                    this.a = i24;
                    this.b = abstractC17858ng6;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.t
                public void b(RecyclerView recyclerView, int i, int i2) {
                    AbstractC13042fc3.i(recyclerView, "recyclerView");
                    if (Math.abs(i2) <= ((int) ((4 * AbstractC3742Cd6.c()) + 0.5d)) || i2 <= 0) {
                        return;
                    }
                    AbstractC19329q98.a(this.a.Q7().getWindow(), this.a.ia().i).a(O98.m.d());
                    this.a.na().A4(AbstractC17858ng6.a.b((AbstractC17858ng6.a) this.b, true, false, false, 6, null));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(I24 i24, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = i24;
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
                AbstractC17858ng6 abstractC17858ng6 = (AbstractC17858ng6) this.c;
                if (abstractC17858ng6 instanceof AbstractC17858ng6.a) {
                    this.d.ia().g.addOnScrollListener(new C0408a(this.d, abstractC17858ng6));
                } else {
                    this.d.ia().g.clearOnScrollListeners();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC17858ng6 abstractC17858ng6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(abstractC17858ng6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.I24$c$b$a$a, reason: collision with other inner class name */
                public static final class C0409a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0409a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.I24.c.b.a.C0409a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.I24$c$b$a$a r0 = (ir.nasim.I24.c.b.a.C0409a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.I24$c$b$a$a r0 = new ir.nasim.I24$c$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.fi6 r5 = (ir.nasim.C13132fi6) r5
                        ir.nasim.ng6 r5 = r5.c()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.I24.c.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return I24.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(I24.this.na().D3());
                a aVar = new a(I24.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
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

    static final class d implements InterfaceC14603iB2 {

        /* synthetic */ class a extends EB2 implements UA2 {
            a(Object obj) {
                super(1, obj, C8671Wy6.class, "setQuery", "setQuery(Ljava/lang/String;)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((String) obj);
                return C19938rB7.a;
            }

            public final void y(String str) {
                AbstractC13042fc3.i(str, "p0");
                ((C8671Wy6) this.receiver).y4(str);
            }
        }

        /* synthetic */ class b extends EB2 implements UA2 {
            b(Object obj) {
                super(1, obj, C8671Wy6.class, "setStateForSearch", "setStateForSearch(Lir/nasim/components/appbar/searchbar/SearchFocusState;)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((AbstractC17858ng6) obj);
                return C19938rB7.a;
            }

            public final void y(AbstractC17858ng6 abstractC17858ng6) {
                AbstractC13042fc3.i(abstractC17858ng6, "p0");
                ((C8671Wy6) this.receiver).A4(abstractC17858ng6);
            }
        }

        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.I24$d$c$a$a, reason: collision with other inner class name */
                public static final class C0410a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0410a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.I24.d.c.a.C0410a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.I24$d$c$a$a r0 = (ir.nasim.I24.d.c.a.C0410a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.I24$d$c$a$a r0 = new ir.nasim.I24$d$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.fi6 r5 = (ir.nasim.C13132fi6) r5
                        ir.nasim.ng6 r5 = r5.c()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.I24.d.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        d() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(RD5.search_hint_member, interfaceC22053ub1, 0);
            String str = (String) AbstractC10222bH6.b(I24.this.na().A3(), null, interfaceC22053ub1, 0, 1).getValue();
            C8671Wy6 c8671Wy6Na = I24.this.na();
            interfaceC22053ub1.W(332674349);
            boolean zD = interfaceC22053ub1.D(c8671Wy6Na);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c8671Wy6Na);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB);
            C8671Wy6 c8671Wy6Na2 = I24.this.na();
            interfaceC22053ub1.W(332677334);
            boolean zD2 = interfaceC22053ub1.D(c8671Wy6Na2);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new b(c8671Wy6Na2);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC16075kf6.j(strC, str, ua2, false, (UA2) ((InterfaceC16733lm3) objB2), (AbstractC17858ng6) AbstractC10222bH6.a(new c(I24.this.na().D3()), AbstractC17858ng6.b.b, null, interfaceC22053ub1, AbstractC17858ng6.b.c << 3, 2).getValue(), false, null, null, null, null, interfaceC22053ub1, (AbstractC17858ng6.a << 15) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0, 1984);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ G34 d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ G34 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(G34 g34, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = g34;
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
                    G34 g34 = this.d;
                    this.b = 1;
                    if (g34.L(nt4, this) == objE) {
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
        e(G34 g34, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = g34;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return I24.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2U3 = I24.this.na().u3();
                a aVar = new a(this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2U3, aVar, this) == objE) {
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

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ I24 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(I24 i24, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = i24;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                boolean z = this.c;
                RecyclerView recyclerView = this.d.ia().g;
                AbstractC13042fc3.h(recyclerView, "memberContainer");
                recyclerView.setVisibility(z ^ true ? 0 : 8);
                LinearLayout linearLayout = this.d.ia().e;
                AbstractC13042fc3.h(linearLayout, "emptyPlaceHolder");
                linearLayout.setVisibility(z ? 0 : 8);
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.I24$f$b$a$a, reason: collision with other inner class name */
                public static final class C0411a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0411a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.I24.f.b.a.C0411a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.I24$f$b$a$a r0 = (ir.nasim.I24.f.b.a.C0411a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.I24$f$b$a$a r0 = new ir.nasim.I24$f$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.fi6 r5 = (ir.nasim.C13132fi6) r5
                        boolean r5 = r5.d()
                        java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.I24.f.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return I24.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(I24.this.na().D3());
                a aVar = new a(I24.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
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

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ G34 c;
        final /* synthetic */ I24 d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ I24 d;

            /* renamed from: ir.nasim.I24$g$a$a, reason: collision with other inner class name */
            static final class C0412a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ I24 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0412a(I24 i24, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = i24;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0412a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    C24119y45 c24119y45W3 = this.c.na().w3();
                    if (c24119y45W3 != null) {
                        I24 i24 = this.c;
                        if (c24119y45W3.i()) {
                            i24.ia().b.setVisibility(0);
                        } else {
                            i24.ia().b.setVisibility(8);
                        }
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0412a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(I24 i24, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = i24;
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
                    if (this.d.loadInitialMember) {
                        return C19938rB7.a;
                    }
                    this.d.ia().d.setVisibility(8);
                    this.d.ia().i.setVisibility(8);
                    this.d.ia().f.setVisibility(0);
                    this.d.ia().g.setVisibility(8);
                    this.d.ia().b.setVisibility(8);
                } else if (abstractC13460gG3D instanceof AbstractC13460gG3.c) {
                    this.d.ia().d.setVisibility(0);
                    this.d.ia().i.setVisibility(0);
                    this.d.ia().f.setVisibility(8);
                    this.d.ia().g.setVisibility(0);
                    this.d.loadInitialMember = true;
                    AbstractC10533bm0.d(AbstractC16751lo1.a(this.d), null, null, new C0412a(this.d, null), 3, null);
                } else {
                    this.d.ia().d.setVisibility(8);
                    this.d.ia().i.setVisibility(8);
                    this.d.ia().f.setVisibility(0);
                    this.d.ia().g.setVisibility(8);
                    this.d.ia().b.setVisibility(8);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C13628gZ0 c13628gZ0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c13628gZ0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(G34 g34, I24 i24, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = g34;
            this.d = i24;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2E = this.c.E();
                a aVar = new a(this.d, null);
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h implements InterfaceC15796kB2 {
        final /* synthetic */ Q14 b;
        final /* synthetic */ ExPeerType c;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ ExPeerType a;

            a(ExPeerType exPeerType) {
                this.a = exPeerType;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.v0(UY6.c(this.a == ExPeerType.GROUP ? RD5.group_context_remove : RD5.delete_from_channel, interfaceC22053ub1, 0), null, FV4.c(AbstractC22412vB5.alert, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).p(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ ExPeerType a;
            final /* synthetic */ Q14 b;

            b(ExPeerType exPeerType, Q14 q14) {
                this.a = exPeerType;
                this.b = q14;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(UY6.d(this.a == ExPeerType.GROUP ? RD5.alert_member_profile_fragment_group_remove_text : RD5.alert_member_profile_fragment_channel_remove_text, new Object[]{this.b.e()}, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        h(Q14 q14, ExPeerType exPeerType) {
            this.b = q14;
            this.c = exPeerType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(I24 i24, Q14 q14, Dialog dialog) {
            AbstractC13042fc3.i(i24, "this$0");
            AbstractC13042fc3.i(q14, "$member");
            AbstractC13042fc3.i(dialog, "$dialog");
            i24.na().b4(q14);
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
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            String strC = UY6.c(RD5.alert_group_remove_yes, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(RD5.dialog_negative_button_cancel, interfaceC22053ub1, 0);
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-682976775, true, new a(this.c), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(983931, true, new b(this.c, this.b), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-1062409186);
            boolean zD = interfaceC22053ub1.D(I24.this) | interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(dialog);
            final I24 i24 = I24.this;
            final Q14 q14 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.L24
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return I24.h.d(i24, q14, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1062399831);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.M24
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return I24.h.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC18060o11E, c0905b, interfaceC18060o11E2, cVar, aVar, sa2, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class i extends AbstractC8614Ws3 implements UA2 {
        public i() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C4644Fy2.a(fragment.V7());
        }
    }

    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    static final class n implements InterfaceC15796kB2 {
        final /* synthetic */ Dialog b;

        n(Dialog dialog) {
            this.b = dialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, I24 i24) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(i24, "this$0");
            dialog.dismiss();
            C14486i0.a aVar = C14486i0.f;
            FragmentActivity fragmentActivityQ7 = i24.Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            C14486i0 c14486i0A = aVar.a(fragmentActivityQ7);
            Context contextS7 = i24.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            FragmentActivity fragmentActivityQ72 = i24.Q7();
            AbstractC13042fc3.g(fragmentActivityQ72, "null cannot be cast to non-null type ir.nasim.designsystem.base.activity.BaseActivity");
            c14486i0A.o(new BottomSheetWebView(contextS7, (BaseActivity) fragmentActivityQ72, "https://tooshle.bale.ai/channel_report?channel_id=" + i24.na().v3().u(), c14486i0A, null, null, 32, null));
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
            C61 c61 = C61.a;
            InterfaceC14603iB2 interfaceC14603iB2B = c61.b();
            InterfaceC14603iB2 interfaceC14603iB2C = c61.c();
            interfaceC22053ub1.W(2119376815);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(I24.this);
            final I24 i24 = I24.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.N24
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return I24.n.d(dialog, i24);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(2119398794);
            boolean zD2 = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.b);
            final Dialog dialog2 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.O24
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return I24.n.f(dialog, dialog2);
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

    static final class o implements InterfaceC15796kB2 {
        final /* synthetic */ Q14 b;
        final /* synthetic */ String c;

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

        o(Q14 q14, String str) {
            this.b = q14;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, I24 i24, Q14 q14) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(i24, "this$0");
            AbstractC13042fc3.i(q14, "$member");
            dialog.dismiss();
            i24.na().w2(q14.f(), q14.e());
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
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            String strC = UY6.c(RD5.alert_group_owner_yes, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(RD5.dialog_cancel, interfaceC22053ub1, 0);
            InterfaceC14603iB2 interfaceC14603iB2A = C61.a.a();
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1855296141, true, new a(this.c), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(2119336049);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(I24.this) | interfaceC22053ub1.V(this.b);
            final I24 i24 = I24.this;
            final Q14 q14 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.P24
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return I24.o.d(dialog, i24, q14);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(2119346583);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Q24
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return I24.o.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2A, cVar, interfaceC18060o11E, cVar2, aVar, sa2, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public I24() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new j(new SA2() { // from class: ir.nasim.x24
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return I24.Fa(this.a);
            }
        }));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C8671Wy6.class), new k(interfaceC9173Yu3B), new l(null, interfaceC9173Yu3B), new m(this, interfaceC9173Yu3B));
    }

    private final void Aa() {
        C4644Fy2 c4644Fy2Ia = ia();
        c4644Fy2Ia.h.setTypeface(C6011Lu2.k());
        c4644Fy2Ia.c.setColorFilter(C5495Jo7.a.u2());
    }

    private final void Ba(Q14 member, ExPeerType exPeerType) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(1686584861, true, new h(member, exPeerType)), 4, null).show();
    }

    private final void Ca(C23104wM2 groupMember, int gid, int uid) {
        if (groupMember.j()) {
            C22042ua0.A9(this, ha().a(groupMember.f(), na().v3().getPeerId(), false, groupMember, na().W3()), false, null, 6, null);
        } else {
            C22042ua0.A9(this, ka().a(groupMember, gid, uid), false, null, 6, null);
        }
    }

    private final void Da(Q14 member) {
        String strH6 = h6(na().d3() == ExPeerType.GROUP ? RD5.group : RD5.channel);
        AbstractC13042fc3.h(strH6, "getString(...)");
        String strH62 = h6(RD5.alert_transfeer_owner_text);
        AbstractC13042fc3.h(strH62, "getString(...)");
        String strM = AbstractC20153rZ6.M(AbstractC20153rZ6.M(strH62, "{0}", strH6, false, 4, null), "{1}", member.e(), false, 4, null);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        final Dialog dialogC = AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(1734431889, true, new o(member, strM)), 4, null);
        Context contextS72 = S7();
        AbstractC13042fc3.h(contextS72, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P62 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P62, "getViewLifecycleOwner(...)");
        final Dialog dialogC2 = AbstractC21375tZ.c(contextS72, interfaceC18633oz3P62, null, AbstractC19242q11.c(2043969709, true, new n(dialogC)), 4, null);
        na().H4(new UA2() { // from class: ir.nasim.H24
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return I24.Ea(dialogC2, dialogC, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ea(Dialog dialog, Dialog dialog2, boolean z) {
        AbstractC13042fc3.i(dialog, "$receiveIncomeNoticeDialog");
        AbstractC13042fc3.i(dialog2, "$transferOwnerDialog");
        if (z) {
            dialog.show();
        } else {
            dialog2.show();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC15408jX7 Fa(I24 i24) {
        AbstractC13042fc3.i(i24, "this$0");
        Fragment fragmentU7 = i24.U7();
        AbstractC13042fc3.h(fragmentU7, "requireParentFragment(...)");
        return fragmentU7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4644Fy2 ia() {
        Object objA = this.binding.a(this, q1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C4644Fy2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C8671Wy6 na() {
        return (C8671Wy6) this.viewModel.getValue();
    }

    private final void oa(final Q14 member, View anchorView) {
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        AbstractC8081Ul1.b.k(bVar, RD5.show_profile, AbstractC22412vB5.profile, null, new SA2() { // from class: ir.nasim.B24
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return I24.pa(this.a, member);
            }
        }, 4, null);
        if (na().e2(member)) {
            AbstractC8081Ul1.b.k(bVar, RD5.group_context_edit_access, AbstractC22412vB5.edit, null, new SA2() { // from class: ir.nasim.C24
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return I24.qa(this.a, member);
                }
            }, 4, null);
        }
        if (na().h2(member)) {
            AbstractC8081Ul1.b.k(bVar, RD5.select_as_admin, AbstractC22412vB5.admin, null, new SA2() { // from class: ir.nasim.D24
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return I24.ra(this.a, member);
                }
            }, 4, null);
        }
        if (na().l2(member)) {
            AbstractC8081Ul1.b.k(bVar, na().d3() == ExPeerType.CHANNEL ? RD5.channel_context_remove_admin : RD5.group_context_remove_admin, AbstractC22412vB5.remove, null, new SA2() { // from class: ir.nasim.E24
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return I24.ta(this.a, member);
                }
            }, 4, null);
        }
        if (na().m2(member)) {
            AbstractC8081Ul1.b.k(bVar, RD5.alert_group_owner_yes, AbstractC22412vB5.transfer_of_ownership, null, new SA2() { // from class: ir.nasim.F24
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return I24.ua(this.a, member);
                }
            }, 4, null);
        }
        if (na().i2(member)) {
            AbstractC8081Ul1.b.d(bVar, na().d3() == ExPeerType.GROUP ? RD5.group_context_remove : RD5.delete_from_channel, AbstractC22412vB5.delete_card_icon, null, new SA2() { // from class: ir.nasim.G24
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return I24.va(this.a, member);
                }
            }, 4, null);
        }
        if (bVar.o(RD5.show_profile)) {
            ia().i.clearFocus();
            C18987pb3.a.T1(Integer.valueOf(member.f()));
        } else {
            View rootView = ia().getRoot().getRootView();
            AbstractC13042fc3.g(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            new GY.a(anchorView, (ViewGroup) rootView, null, 4, null).d(true).h(AbstractC5770Kt3.a()).b(bVar).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa(I24 i24, Q14 q14) {
        AbstractC13042fc3.i(i24, "this$0");
        AbstractC13042fc3.i(q14, "$member");
        i24.ia().i.clearFocus();
        C18987pb3.a.T1(Integer.valueOf(q14.f()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(I24 i24, Q14 q14) {
        AbstractC13042fc3.i(i24, "this$0");
        AbstractC13042fc3.i(q14, "$member");
        i24.Ca(i24.ma().a(q14), i24.na().v3().getPeerId(), q14.f());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(final I24 i24, Q14 q14) {
        AbstractC13042fc3.i(i24, "this$0");
        AbstractC13042fc3.i(q14, "$member");
        C22042ua0.A9(i24, i24.ha().a(q14.f(), i24.na().v3().getPeerId(), true, i24.ma().a(q14), i24.na().W3()), false, null, 6, null);
        i24.Q7().B0().H1("add_new_admin_request", i24.p6(), new InterfaceC13295fz2() { // from class: ir.nasim.y24
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                I24.sa(this.a, str, bundle);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(I24 i24, String str, Bundle bundle) {
        AbstractC13042fc3.i(i24, "this$0");
        AbstractC13042fc3.i(str, "requestKey");
        AbstractC13042fc3.i(bundle, "bundle");
        if (str.hashCode() == 1132715298 && str.equals("add_new_admin_request")) {
            i24.na().Q3(bundle.getBoolean("extra_new_admin_added"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ta(I24 i24, Q14 q14) {
        AbstractC13042fc3.i(i24, "this$0");
        AbstractC13042fc3.i(q14, "$member");
        i24.wa(q14);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ua(I24 i24, Q14 q14) {
        AbstractC13042fc3.i(i24, "this$0");
        AbstractC13042fc3.i(q14, "$member");
        i24.Da(q14);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(I24 i24, Q14 q14) {
        AbstractC13042fc3.i(i24, "this$0");
        AbstractC13042fc3.i(q14, "$member");
        i24.Ba(q14, i24.na().d3());
        return C19938rB7.a;
    }

    private final void wa(Q14 member) {
        String strA = AbstractC5969Lp4.a(h6(AbstractC12217eE5.alert_group_remove_admin_text), na().d3() == ExPeerType.GROUP ? ZN2.GROUP : ZN2.CHANNEL);
        AbstractC13042fc3.h(strA, "formatGroupType(...)");
        String strM = AbstractC20153rZ6.M(strA, "{0}", member.e(), false, 4, null);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(529472758, true, new b(member, strM)), 4, null).show();
    }

    private final void xa() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new c(null), 3, null);
        ia().i.setContent(AbstractC19242q11.c(989165652, true, new d()));
        final G34 g34 = new G34(new InterfaceC14603iB2() { // from class: ir.nasim.z24
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return I24.ya(this.a, (Q14) obj, (View) obj2);
            }
        }, la());
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new e(g34, null), 3, null);
        AbstractC16751lo1.c(this, j.b.STARTED, new f(null));
        ia().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.A24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                I24.za(this.a, g34, view);
            }
        });
        ia().g.setAdapter(g34);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new g(g34, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(I24 i24, Q14 q14, View view) {
        AbstractC13042fc3.i(i24, "this$0");
        AbstractC13042fc3.i(q14, "member");
        AbstractC13042fc3.i(view, "anchor");
        i24.oa(q14, view);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(I24 i24, G34 g34, View view) {
        AbstractC13042fc3.i(i24, "this$0");
        AbstractC13042fc3.i(g34, "$adapter");
        InterfaceC8288Vi1 interfaceC8288Vi1Ja = i24.ja();
        String strA = AbstractC5969Lp4.a(i24.h6(RD5.group_add_title), i24.na().d3() == ExPeerType.GROUP ? ZN2.GROUP : ZN2.CHANNEL);
        AbstractC13042fc3.h(strA, "formatGroupType(...)");
        EnumC6357Ng1 enumC6357Ng1 = EnumC6357Ng1.a;
        List listF = g34.K().f();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listF, 10));
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((Q14) it.next()).i()));
        }
        ZN2 zn2 = i24.na().d3() == ExPeerType.GROUP ? ZN2.GROUP : ZN2.CHANNEL;
        int peerId = i24.na().v3().getPeerId();
        boolean zS3 = i24.na().S3();
        boolean z = i24.na().i3().x() == AbstractC5969Lp4.c().o();
        Integer numValueOf = Integer.valueOf(i24.na().n3());
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        C22042ua0.A9(i24, InterfaceC8288Vi1.c(interfaceC8288Vi1Ja, strA, null, null, null, zn2, false, enumC6357Ng1, Integer.valueOf(peerId), zS3, z, numValueOf, false, arrayList, TokenTypes.CSEQ, null), false, null, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.cloneInContext(new C16731lm1(S7(), AbstractC15235jE5.Theme_Bale_Base)).inflate(QC5.fragment_member_profile, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        ia().g.setAdapter(null);
        super.R6();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        ia().g.setAdapter(null);
        ia().g.clearOnScrollListeners();
        super.T6();
    }

    public final InterfaceC24417yb ha() {
        InterfaceC24417yb interfaceC24417yb = this.adminsAccessFragmentNavigator;
        if (interfaceC24417yb != null) {
            return interfaceC24417yb;
        }
        AbstractC13042fc3.y("adminsAccessFragmentNavigator");
        return null;
    }

    public final InterfaceC8288Vi1 ja() {
        InterfaceC8288Vi1 interfaceC8288Vi1 = this.contactNavigator;
        if (interfaceC8288Vi1 != null) {
            return interfaceC8288Vi1;
        }
        AbstractC13042fc3.y("contactNavigator");
        return null;
    }

    public final InterfaceC19255q24 ka() {
        InterfaceC19255q24 interfaceC19255q24 = this.memberAccessNavigator;
        if (interfaceC19255q24 != null) {
            return interfaceC19255q24;
        }
        AbstractC13042fc3.y("memberAccessNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Aa();
        xa();
    }

    public final C10087b34.a la() {
        C10087b34.a aVar = this.memberStateBinderFactory;
        if (aVar != null) {
            return aVar;
        }
        AbstractC13042fc3.y("memberStateBinderFactory");
        return null;
    }

    public final C10703c34 ma() {
        C10703c34 c10703c34 = this.memberToGroupMemberMapper;
        if (c10703c34 != null) {
            return c10703c34;
        }
        AbstractC13042fc3.y("memberToGroupMemberMapper");
        return null;
    }
}
