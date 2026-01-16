package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.AbstractC1965a;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.JZ0;
import ir.nasim.OA7;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 92\u00020\u0001:\u0001:B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\u0010J\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001b\u00104\u001a\u00020/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006=²\u0006\f\u0010<\u001a\u00020;8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/JZ0;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "wa", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Aa", "(Lir/nasim/ub1;I)V", "", "checked", "isLoading", "hasDiscussionGroup", "isMember", "na", "(ZZZZLir/nasim/ub1;I)V", "qa", "(ZLir/nasim/ub1;I)V", "ka", "ga", "sa", "ua", "(ZZLir/nasim/ub1;I)V", "Lir/nasim/OZ0;", "h1", "Lir/nasim/OZ0;", "za", "()Lir/nasim/OZ0;", "setViewmodelFactory", "(Lir/nasim/OZ0;)V", "viewmodelFactory", "Lir/nasim/B34;", "i1", "Lir/nasim/B34;", "xa", "()Lir/nasim/B34;", "setMembersAccessFragmentNavigator", "(Lir/nasim/B34;)V", "membersAccessFragmentNavigator", "Lir/nasim/NZ0;", "j1", "Lir/nasim/Yu3;", "ya", "()Lir/nasim/NZ0;", "viewmodel", "Lir/nasim/bU0;", "k1", "Lir/nasim/bU0;", "loadingFragment", "l1", "a", "Lir/nasim/OA7;", "uiState", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class JZ0 extends AbstractC12985fW2 {

    /* renamed from: l1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    public OZ0 viewmodelFactory;

    /* renamed from: i1, reason: from kotlin metadata */
    public B34 membersAccessFragmentNavigator;

    /* renamed from: j1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewmodel;

    /* renamed from: k1, reason: from kotlin metadata */
    private final C10333bU0 loadingFragment;

    /* renamed from: ir.nasim.JZ0$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final JZ0 a(int i) {
            JZ0 jz0 = new JZ0();
            Bundle bundle = new Bundle();
            bundle.putInt("arg_group_id", i);
            jz0.a8(bundle);
            return jz0;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* synthetic */ class b extends EB2 implements SA2 {
        b(Object obj) {
            super(0, obj, FragmentActivity.class, "onBackPressed", "onBackPressed()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((FragmentActivity) this.receiver).onBackPressed();
        }
    }

    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ JZ0 b;
        final /* synthetic */ boolean c;

        c(boolean z, JZ0 jz0, boolean z2) {
            this.a = z;
            this.b = jz0;
            this.c = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(JZ0 jz0, boolean z) {
            AbstractC13042fc3.i(jz0, "this$0");
            if (z) {
                jz0.ya().h1();
            } else {
                jz0.ya().f1();
            }
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            boolean z = this.a;
            interfaceC22053ub1.W(-1373422556);
            boolean zD = interfaceC22053ub1.D(this.b);
            final JZ0 jz0 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.KZ0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return JZ0.c.c(jz0, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            B10.e(z, (UA2) objB, null, false, this.c, interfaceC22053ub1, 0, 12);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC14603iB2 {

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ JZ0 a;

            a(JZ0 jz0) {
                this.a = jz0;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.Aa(interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        d() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-945738927, true, new a(JZ0.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public static final class i extends AbstractC1965a {
        i(Bundle bundle) {
            super(JZ0.this, bundle);
        }

        @Override // androidx.lifecycle.AbstractC1965a
        protected VW7 f(String str, Class cls, androidx.lifecycle.y yVar) {
            AbstractC13042fc3.i(str, "key");
            AbstractC13042fc3.i(cls, "modelClass");
            AbstractC13042fc3.i(yVar, "handle");
            OZ0 oz0Za = JZ0.this.za();
            Bundle bundleE5 = JZ0.this.E5();
            NZ0 nz0A = oz0Za.a(bundleE5 != null ? bundleE5.getInt("arg_group_id") : 0);
            AbstractC13042fc3.g(nz0A, "null cannot be cast to non-null type T of ir.nasim.features.conversation.comment.CommentSettingsFragment.viewmodel_delegate$lambda$0.<no name provided>.create");
            return nz0A;
        }
    }

    public JZ0() {
        SA2 sa2 = new SA2() { // from class: ir.nasim.vZ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return JZ0.Fa(this.a);
            }
        };
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new f(new e(this)));
        this.viewmodel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(NZ0.class), new g(interfaceC9173Yu3B), new h(null, interfaceC9173Yu3B), sa2);
        this.loadingFragment = new C10333bU0();
    }

    private static final OA7 Ba(InterfaceC9664aL6 interfaceC9664aL6) {
        return (OA7) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ca(JZ0 jz0, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jz0, "$tmp0_rcvr");
        jz0.Aa(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Da(JZ0 jz0, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jz0, "$tmp2_rcvr");
        jz0.Aa(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ea(JZ0 jz0, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jz0, "$tmp4_rcvr");
        jz0.Aa(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final G.c Fa(JZ0 jz0) {
        AbstractC13042fc3.i(jz0, "this$0");
        return jz0.new i(jz0.E5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.C19938rB7 ha(final ir.nasim.JZ0 r18, boolean r19) {
        /*
            r0 = r18
            java.lang.String r1 = "this$0"
            ir.nasim.AbstractC13042fc3.i(r0, r1)
            ir.nasim.NZ0 r1 = r18.ya()
            ir.nasim.iO2 r1 = r1.V0()
            r2 = 0
            if (r1 == 0) goto L1f
            ir.nasim.qQ7 r1 = r1.m()
            if (r1 == 0) goto L1f
            java.lang.Object r1 = r1.b()
            ir.nasim.y45 r1 = (ir.nasim.C24119y45) r1
            goto L20
        L1f:
            r1 = r2
        L20:
            java.lang.String r3 = "requireView(...)"
            java.lang.String r4 = "getString(...)"
            if (r1 == 0) goto Lc1
            ir.nasim.NZ0 r1 = r18.ya()
            ir.nasim.iO2 r1 = r1.V0()
            if (r1 == 0) goto L3d
            ir.nasim.qQ7 r1 = r1.z()
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r1.b()
            r2 = r1
            ir.nasim.y45 r2 = (ir.nasim.C24119y45) r2
        L3d:
            if (r2 != 0) goto L41
            goto Lc1
        L41:
            if (r19 == 0) goto L65
            ir.nasim.NZ0 r1 = r18.ya()
            ir.nasim.iO2 r1 = r1.V0()
            if (r1 == 0) goto Le0
            ir.nasim.B34 r2 = r18.xa()
            int r1 = r1.r()
            r3 = 1
            androidx.fragment.app.Fragment r1 = r2.a(r1, r3)
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r18
            ir.nasim.C22042ua0.A9(r0, r1, r2, r3, r4, r5)
            goto Le0
        L65:
            ir.nasim.n10 r1 = new ir.nasim.n10
            android.view.View r7 = r18.V7()
            ir.nasim.AbstractC13042fc3.h(r7, r3)
            r10 = 6
            r11 = 0
            r8 = 0
            r9 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)
            int r2 = ir.nasim.AbstractC12217eE5.for_change_permission_join_to_group
            ir.nasim.NZ0 r3 = r18.ya()
            ir.nasim.iO2 r3 = r3.V0()
            if (r3 == 0) goto L90
            ir.nasim.bZ6 r3 = r3.v()
            if (r3 == 0) goto L90
            java.lang.Object r3 = r3.b()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L99
        L90:
            int r3 = ir.nasim.AbstractC12217eE5.group
            java.lang.String r3 = r0.h6(r3)
            ir.nasim.AbstractC13042fc3.h(r3, r4)
        L99:
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r7 = r0.i6(r2, r3)
            ir.nasim.AbstractC13042fc3.h(r7, r4)
            ir.nasim.gG6$a r2 = new ir.nasim.gG6$a
            int r3 = ir.nasim.AbstractC12217eE5.call_bar_join
            java.lang.String r9 = r0.h6(r3)
            ir.nasim.zZ0 r12 = new ir.nasim.zZ0
            r12.<init>()
            r13 = 2
            r14 = 0
            r10 = 0
            r11 = 0
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r10 = 4
            r11 = 0
            r9 = 0
            r6 = r1
            ir.nasim.C17468n10.p(r6, r7, r8, r9, r10, r11)
            goto Le0
        Lc1:
            ir.nasim.n10 r1 = new ir.nasim.n10
            android.view.View r13 = r18.V7()
            ir.nasim.AbstractC13042fc3.h(r13, r3)
            r16 = 6
            r17 = 0
            r14 = 0
            r15 = 0
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            int r2 = ir.nasim.AbstractC12217eE5.auth_error_unknown
            java.lang.String r0 = r0.h6(r2)
            ir.nasim.AbstractC13042fc3.h(r0, r4)
            r1.o(r0)
        Le0:
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.JZ0.ha(ir.nasim.JZ0, boolean):ir.nasim.rB7");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ia(JZ0 jz0) {
        AbstractC13042fc3.i(jz0, "this$0");
        jz0.ya().c1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ja(JZ0 jz0, boolean z, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jz0, "$tmp3_rcvr");
        jz0.ga(z, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 la(boolean z, JZ0 jz0) {
        AbstractC13042fc3.i(jz0, "this$0");
        if (z) {
            C14733iO2 c14733iO2V0 = jz0.ya().V0();
            if (c14733iO2V0 != null) {
                C18987pb3 c18987pb3 = C18987pb3.a;
                C11458d25 c11458d25Y = C11458d25.y(c14733iO2V0.r());
                AbstractC13042fc3.h(c11458d25Y, "group(...)");
                C18987pb3.x1(c18987pb3, c11458d25Y, null, null, false, null, null, false, null, null, false, null, 2046, null);
            }
        } else {
            jz0.ya().c1();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ma(JZ0 jz0, boolean z, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jz0, "$tmp1_rcvr");
        jz0.ka(z, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oa(JZ0 jz0, boolean z, boolean z2, boolean z3, boolean z4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jz0, "$tmp1_rcvr");
        jz0.na(z, z2, z3, z4, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(JZ0 jz0, boolean z, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jz0, "$tmp0_rcvr");
        jz0.qa(z, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ta(JZ0 jz0, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jz0, "$tmp0_rcvr");
        jz0.sa(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(JZ0 jz0, boolean z, boolean z2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jz0, "$tmp0_rcvr");
        jz0.ua(z, z2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private final void wa() {
        String str;
        C10410bZ6 c10410bZ6V;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        String strH6 = h6(AbstractC12217eE5.comment_enabled_successfully);
        AbstractC13042fc3.h(strH6, "getString(...)");
        int i2 = AbstractC12217eE5.comments_send_to_group;
        C14733iO2 c14733iO2V0 = ya().V0();
        if (c14733iO2V0 == null || (c10410bZ6V = c14733iO2V0.v()) == null || (str = (String) c10410bZ6V.b()) == null) {
            str = "";
        }
        String strI6 = i6(i2, str);
        AbstractC13042fc3.h(strI6, "getString(...)");
        C24398yZ.o(contextS7, interfaceC18633oz3P6, strH6, strI6, null, 16, null);
    }

    public final void Aa(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        Integer num;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(979222389);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(ya().a1(), null, interfaceC22053ub1J, 0, 1);
            if (Ba(interfaceC9664aL6B) instanceof OA7.d) {
                C10333bU0 c10333bU0 = this.loadingFragment;
                FragmentManager fragmentManagerV5 = V5();
                AbstractC13042fc3.h(fragmentManagerV5, "getParentFragmentManager(...)");
                AbstractC16494lN1.b(c10333bU0, fragmentManagerV5);
                InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
                if (interfaceC20208rd6M != null) {
                    interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.AZ0
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return JZ0.Ca(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            AbstractC16494lN1.a(this.loadingFragment);
            if (Ba(interfaceC9664aL6B) instanceof OA7.a) {
                Q7().onBackPressed();
                InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
                if (interfaceC20208rd6M2 != null) {
                    interfaceC20208rd6M2.a(new InterfaceC14603iB2() { // from class: ir.nasim.BZ0
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return JZ0.Da(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            boolean zT0 = ya().T0();
            boolean z = Ba(interfaceC9664aL6B) instanceof OA7.e;
            C19482qQ7 c19482qQ7O = ya().Z0().o();
            na(zT0, z, ((c19482qQ7O == null || (num = (Integer) c19482qQ7O.b()) == null) ? 0 : num.intValue()) != 0, ya().b1(), interfaceC22053ub1J, (i3 << 12) & 57344);
        }
        InterfaceC20208rd6 interfaceC20208rd6M3 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M3 != null) {
            interfaceC20208rd6M3.a(new InterfaceC14603iB2() { // from class: ir.nasim.CZ0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return JZ0.Ea(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setContent(AbstractC19242q11.c(414673324, true, new d()));
        return composeView;
    }

    public final void ga(final boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        long jX;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2025754573);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (z) {
                interfaceC22053ub1J.W(-824825089);
                jX = G10.a.a(interfaceC22053ub1J, G10.b).B();
            } else {
                interfaceC22053ub1J.W(-824824001);
                jX = G10.a.a(interfaceC22053ub1J, G10.b).x();
            }
            interfaceC22053ub1J.Q();
            long j = jX;
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarC = androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), null, false, 3, null);
            interfaceC22053ub1J.W(-824817741);
            boolean zD = interfaceC22053ub1J.D(this) | ((i3 & 14) == 4);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.IZ0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return JZ0.ha(this.a, z);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            float f2 = 12;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.e.f(eVarC, false, null, null, (SA2) objB, 7, null), C17784nZ1.q(f2), C17784nZ1.q(16));
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            EV4 ev4C = FV4.c(KB5.admin, interfaceC22053ub1J, 0);
            AbstractC24975zX0.a aVar3 = AbstractC24975zX0.b;
            float f3 = 24;
            AbstractC11456d23.b(ev4C, "", androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f3)), null, null, 0.0f, AbstractC24975zX0.a.b(aVar3, j, 0, 2, null), interfaceC22053ub1J, 432, 56);
            String strH6 = h6(AbstractC12217eE5.set_comment_permissions);
            AbstractC13042fc3.h(strH6, "getString(...)");
            G10 g10 = G10.a;
            int i4 = G10.b;
            C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1J, i4).a();
            interfaceC22053ub1J.W(105398158);
            long jF = z ? g10.a(interfaceC22053ub1J, i4).F() : j;
            interfaceC22053ub1J.Q();
            AbstractC9105Ym7.b(strH6, androidx.compose.foundation.layout.q.k(aVar, C17784nZ1.q(f2), 0.0f, 2, null), jF, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7A, interfaceC22053ub1J, 48, 0, 65528);
            ZH6.a(L66.b(m66, aVar, 1.0f, false, 2, null), interfaceC22053ub1J, 0);
            AbstractC11456d23.b(FV4.c(KB5.ic_backward_arrow, interfaceC22053ub1J, 0), "", androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.m(aVar, C17784nZ1.q(4), 0.0f, 0.0f, 0.0f, 14, null), C17784nZ1.q(f3)), null, null, 0.0f, AbstractC24975zX0.a.b(aVar3, j, 0, 2, null), interfaceC22053ub1J, 432, 56);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.wZ0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return JZ0.ja(this.a, z, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void ka(final boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        String string;
        C10410bZ6 c10410bZ6V;
        String str;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2111675753);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i2;
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
            androidx.compose.ui.e eVarC = androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), null, false, 3, null);
            interfaceC22053ub1J.W(-1766198448);
            boolean zD = ((i3 & 14) == 4) | interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.xZ0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return JZ0.la(z, this);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            float f2 = 12;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.e.f(eVarC, false, null, null, (SA2) objB, 7, null), C17784nZ1.q(f2), C17784nZ1.q(16));
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            EV4 ev4C = FV4.c(KB5.three_user, interfaceC22053ub1J, 0);
            AbstractC24975zX0.a aVar3 = AbstractC24975zX0.b;
            G10 g10 = G10.a;
            int i4 = G10.b;
            AbstractC11456d23.b(ev4C, null, androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(24)), null, null, 0.0f, AbstractC24975zX0.a.b(aVar3, g10.a(interfaceC22053ub1J, i4).B(), 0, 2, null), interfaceC22053ub1J, 432, 56);
            int iB = AbstractC23365wn7.a.b();
            C14733iO2 c14733iO2V0 = ya().V0();
            if (c14733iO2V0 == null || (c10410bZ6V = c14733iO2V0.v()) == null || (str = (String) c10410bZ6V.b()) == null || (string = AbstractC20762sZ6.n1(str).toString()) == null) {
                string = "";
            }
            AbstractC9105Ym7.b(string, L66.b(m66, androidx.compose.foundation.layout.q.k(aVar, C17784nZ1.q(f2), 0.0f, 2, null), 1.0f, false, 2, null), g10.a(interfaceC22053ub1J, i4).F(), 0L, null, null, null, 0L, null, null, 0L, iB, false, 1, 1, null, g10.d(interfaceC22053ub1J, i4).a(), interfaceC22053ub1J, 0, 27696, 38904);
            String strH6 = h6(z ? AbstractC12217eE5.visit_the_group : AbstractC12217eE5.join_to_group);
            AbstractC13042fc3.h(strH6, "getString(...)");
            AbstractC9105Ym7.b(strH6, androidx.compose.foundation.layout.q.j(AbstractC9287Zh0.e(aVar, AbstractC11256ci0.a(C17784nZ1.q(1), g10.a(interfaceC22053ub1J, i4).I()), N46.d(C17784nZ1.q(8))), C17784nZ1.q(f2), C17784nZ1.q(6)), g10.a(interfaceC22053ub1J, i4).I(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i4).c(), interfaceC22053ub1J, 0, 0, 65528);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.yZ0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return JZ0.ma(this.a, z, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void na(final boolean z, final boolean z2, final boolean z3, final boolean z4, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-92382174);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.a(z2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.a(z3) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.a(z4) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 16384 : 8192;
        }
        int i4 = i3;
        if ((i4 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC12529em.b bVarK = InterfaceC12529em.a.k();
            C24254yJ.m mVarH = C24254yJ.a.h();
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i5 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarF, g10.a(interfaceC22053ub1J, i5).r(), null, 2, null);
            interfaceC22053ub1J.W(-919535944);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB == aVar2.a()) {
                objB = new SA2() { // from class: ir.nasim.DZ0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return JZ0.pa();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarD2 = androidx.compose.foundation.e.d(eVarD, null, null, true, null, null, (SA2) objB, 24, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, bVarK, interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD2);
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
            String strH6 = h6(AbstractC12217eE5.comment);
            AbstractC13042fc3.h(strH6, "getString(...)");
            FragmentActivity fragmentActivityQ7 = Q7();
            interfaceC22053ub1J.W(205263125);
            boolean zD = interfaceC22053ub1J.D(fragmentActivityQ7);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD || objB2 == aVar2.a()) {
                objB2 = new b(fragmentActivityQ7);
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC21639ts7.i(strH6, null, (SA2) ((InterfaceC16733lm3) objB2), null, null, null, null, interfaceC22053ub1J, 0, 122);
            if (z && ya().W0() && !z2) {
                wa();
            }
            ua(z, z2, interfaceC22053ub1J, (i4 & 14) | (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | ((i4 >> 6) & 896));
            sa(interfaceC22053ub1J, (i4 >> 12) & 14);
            String strH62 = h6(AbstractC12217eE5.enable_comment_description);
            AbstractC13042fc3.h(strH62, "getString(...)");
            AbstractC9105Ym7.b(strH62, androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.a(interfaceC22053ub1J, i5).y(), null, 2, null), C17784nZ1.q(12), C17784nZ1.q(8)), null, false, 3, null), g10.a(interfaceC22053ub1J, i5).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i5).c(), interfaceC22053ub1J, 0, 0, 65528);
            interfaceC22053ub1J.W(205286560);
            if (z3) {
                int i6 = i4 >> 9;
                qa(z4, interfaceC22053ub1J, (i6 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i6 & 14));
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.EZ0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return JZ0.oa(this.a, z, z2, z3, z4, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void qa(final boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(317542705);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            int i4 = (i3 & 14) | (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            ka(z, interfaceC22053ub1J, i4);
            int i5 = (i3 >> 3) & 14;
            sa(interfaceC22053ub1J, i5);
            ga(z, interfaceC22053ub1J, i4);
            sa(interfaceC22053ub1J, i5);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.HZ0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return JZ0.ra(this.a, z, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void sa(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1727057043);
        if ((i2 & 1) == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC9758aW1.a(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.a(interfaceC22053ub1J, G10.b).A(), C17784nZ1.q(1), 0.0f, interfaceC22053ub1J, 390, 8);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.FZ0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return JZ0.ta(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void ua(final boolean z, final boolean z2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1455494637);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.a(z2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.q.j(aVar, C17784nZ1.q(12), C17784nZ1.q(14)), null, false, 3, null), 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            G10 g10 = G10.a;
            int i4 = G10.b;
            long jB = g10.a(interfaceC22053ub1J, i4).B();
            String strH6 = h6(AbstractC12217eE5.ability_to_write_comment);
            AbstractC13042fc3.h(strH6, "getString(...)");
            AbstractC9105Ym7.b(strH6, null, jB, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i4).c(), interfaceC22053ub1J, 0, 0, 65530);
            ZH6.a(L66.b(m66, aVar, 1.0f, false, 2, null), interfaceC22053ub1J, 0);
            ZV1.c(androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(24)), C17784nZ1.q(8), 0.0f, 2, null), C17784nZ1.q(2), g10.a(interfaceC22053ub1J, i4).A(), interfaceC22053ub1J, 54, 0);
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(1325860625, true, new c(z, this, z2), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.GZ0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return JZ0.va(this.a, z, z2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final B34 xa() {
        B34 b34 = this.membersAccessFragmentNavigator;
        if (b34 != null) {
            return b34;
        }
        AbstractC13042fc3.y("membersAccessFragmentNavigator");
        return null;
    }

    public final NZ0 ya() {
        return (NZ0) this.viewmodel.getValue();
    }

    public final OZ0 za() {
        OZ0 oz0 = this.viewmodelFactory;
        if (oz0 != null) {
            return oz0;
        }
        AbstractC13042fc3.y("viewmodelFactory");
        return null;
    }
}
