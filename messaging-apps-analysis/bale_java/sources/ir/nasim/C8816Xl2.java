package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.view.View;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.InterfaceC17445my6;
import ir.nasim.O98;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u001b\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u001a²\u0006\f\u0010\u0019\u001a\u00020\u00188\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/Xl2;", "Lir/nasim/Ha0;", "Lir/nasim/my6$c;", "Lir/nasim/Ym2;", "<init>", "()V", "Lir/nasim/rB7;", "oa", "Lir/nasim/gj3;", "pa", "()Lir/nasim/gj3;", "Lir/nasim/Fq2;", "Lir/nasim/NT4;", "aa", "()Lir/nasim/Fq2;", "", "W9", "()I", "X9", "Lir/nasim/OT4;", "V9", "()Lir/nasim/OT4;", "o1", "a", "", "query", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Xl2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C8816Xl2 extends IW2<InterfaceC17445my6.c, C9100Ym2> {

    /* renamed from: o1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: ir.nasim.Xl2$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C8816Xl2 a() {
            return new C8816Xl2();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Xl2$c */
    static final class c implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Xl2$c$a */
        /* synthetic */ class a extends EB2 implements UA2 {
            a(Object obj) {
                super(1, obj, C8671Wy6.class, "setFileSearchQuery", "setFileSearchQuery(Ljava/lang/String;)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((String) obj);
                return C19938rB7.a;
            }

            public final void y(String str) {
                AbstractC13042fc3.i(str, "p0");
                ((C8671Wy6) this.receiver).w4(str);
            }
        }

        /* renamed from: ir.nasim.Xl2$c$b */
        /* synthetic */ class b extends EB2 implements UA2 {
            b(Object obj) {
                super(1, obj, C8671Wy6.class, "setStateForSearchFiles", "setStateForSearchFiles(Lir/nasim/components/appbar/searchbar/SearchFocusState;)V", 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                y((AbstractC17858ng6) obj);
                return C19938rB7.a;
            }

            public final void y(AbstractC17858ng6 abstractC17858ng6) {
                AbstractC13042fc3.i(abstractC17858ng6, "p0");
                ((C8671Wy6) this.receiver).B4(abstractC17858ng6);
            }
        }

        /* renamed from: ir.nasim.Xl2$c$c, reason: collision with other inner class name */
        static final class C0766c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20996sx3 c;
            final /* synthetic */ C8816Xl2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0766c(C20996sx3 c20996sx3, C8816Xl2 c8816Xl2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20996sx3;
                this.d = c8816Xl2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0766c(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC13460gG3 abstractC13460gG3D = this.c.i().d();
                if (abstractC13460gG3D instanceof AbstractC13460gG3.a) {
                    this.d.ca();
                    this.d.ba().B4(new AbstractC17858ng6.a(false, false, false, 5, null));
                } else if (AbstractC13042fc3.d(abstractC13460gG3D, AbstractC13460gG3.b.b)) {
                    this.d.ba().B4(new AbstractC17858ng6.a(false, true, false, 5, null));
                } else {
                    if (!(abstractC13460gG3D instanceof AbstractC13460gG3.c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (this.c.i().e().d().a() && this.c.g() == 0) {
                        this.d.S9();
                    } else {
                        this.d.ca();
                    }
                    this.d.ba().B4(new AbstractC17858ng6.a(false, false, false, 5, null));
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0766c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c() {
        }

        private static final String b(InterfaceC9664aL6 interfaceC9664aL6) {
            return (String) interfaceC9664aL6.getValue();
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(C8816Xl2.this.ba().g3(), null, interfaceC22053ub1, 0, 1);
            String strC = UY6.c(RD5.search_hint_file, interfaceC22053ub1, 0);
            String strB = b(interfaceC9664aL6B);
            Object objBa = C8816Xl2.this.ba();
            interfaceC22053ub1.W(-438118609);
            boolean zD = interfaceC22053ub1.D(objBa);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(objBa);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB);
            Object objBa2 = C8816Xl2.this.ba();
            interfaceC22053ub1.W(-438115053);
            boolean zD2 = interfaceC22053ub1.D(objBa2);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new b(objBa2);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC16075kf6.j(strC, strB, ua2, false, (UA2) ((InterfaceC16733lm3) objB2), (AbstractC17858ng6) AbstractC10222bH6.a(C8816Xl2.this.ba().C3(), AbstractC17858ng6.b.b, null, interfaceC22053ub1, AbstractC17858ng6.b.c << 3, 2).getValue(), false, null, null, null, null, interfaceC22053ub1, (AbstractC17858ng6.a << 15) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0, 1984);
            if (b(interfaceC9664aL6B).length() > 0) {
                C20996sx3 c20996sx3B = AbstractC21683tx3.b(C8816Xl2.this.aa(), null, interfaceC22053ub1, 0, 1);
                C13628gZ0 c13628gZ0I = c20996sx3B.i();
                interfaceC22053ub1.W(-438101728);
                boolean zD3 = interfaceC22053ub1.D(c20996sx3B) | interfaceC22053ub1.V(C8816Xl2.this);
                C8816Xl2 c8816Xl2 = C8816Xl2.this;
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new C0766c(c20996sx3B, c8816Xl2, null);
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(c13628gZ0I, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xl2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Xl2$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C8816Xl2 d;

            /* renamed from: ir.nasim.Xl2$d$a$a, reason: collision with other inner class name */
            public static final class C0767a extends RecyclerView.t {
                final /* synthetic */ C8816Xl2 a;
                final /* synthetic */ AbstractC17858ng6 b;

                C0767a(C8816Xl2 c8816Xl2, AbstractC17858ng6 abstractC17858ng6) {
                    this.a = c8816Xl2;
                    this.b = abstractC17858ng6;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.t
                public void b(RecyclerView recyclerView, int i, int i2) {
                    AbstractC13042fc3.i(recyclerView, "recyclerView");
                    if (Math.abs(i2) <= ((int) ((4 * AbstractC3742Cd6.c()) + 0.5d)) || i2 <= 0) {
                        return;
                    }
                    AbstractC19329q98.a(this.a.Q7().getWindow(), this.a.U9().h).a(O98.m.d());
                    this.a.ba().B4(AbstractC17858ng6.a.b((AbstractC17858ng6.a) this.b, true, false, false, 6, null));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8816Xl2 c8816Xl2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c8816Xl2;
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
                    this.d.U9().f.addOnScrollListener(new C0767a(this.d, abstractC17858ng6));
                } else {
                    this.d.U9().f.clearOnScrollListeners();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC17858ng6 abstractC17858ng6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(abstractC17858ng6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8816Xl2.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6C3 = C8816Xl2.this.ba().C3();
                a aVar = new a(C8816Xl2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6C3, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Xl2$e */
    /* synthetic */ class e extends C23553x7 implements UA2 {
        e(Object obj) {
            super(1, obj, C8671Wy6.class, "openFileItem", "openFileItem(Lir/nasim/sharedmedia/data/model/SharedMediaContent;)Lkotlinx/coroutines/Job;", 8);
        }

        public final void a(InterfaceC17445my6 interfaceC17445my6) {
            AbstractC13042fc3.i(interfaceC17445my6, "p0");
            ((C8671Wy6) this.a).h4(interfaceC17445my6);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17445my6) obj);
            return C19938rB7.a;
        }
    }

    private final void oa() {
        ComposeView composeView = U9().h;
        AbstractC13042fc3.h(composeView, "searchFile");
        composeView.setVisibility(0);
        ComposeView composeView2 = U9().h;
        AbstractC13042fc3.h(composeView2, "searchFile");
        if (composeView2.isAttachedToWindow()) {
            U9().h.setContent(AbstractC19242q11.c(-1165026714, true, new c()));
        } else {
            composeView2.addOnAttachStateChangeListener(new b(composeView2, this));
        }
    }

    private final InterfaceC13730gj3 pa() {
        return AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(C8816Xl2 c8816Xl2, boolean z) {
        AbstractC13042fc3.i(c8816Xl2, "this$0");
        c8816Xl2.ba().x4(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(C8816Xl2 c8816Xl2, InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(c8816Xl2, "this$0");
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        c8816Xl2.ba().f4(interfaceC17445my6);
        return C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public OT4 V9() {
        if (C8386Vt0.a.X9()) {
            pa();
            oa();
        }
        return new C3594Bn2(ba().Z3(), null, new UA2() { // from class: ir.nasim.Vl2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8816Xl2.qa(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.Wl2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8816Xl2.ra(this.a, (InterfaceC17445my6) obj);
            }
        }, new e(ba()), 2, null);
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public int W9() {
        return AbstractC22412vB5.folder;
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public int X9() {
        return (((CharSequence) ba().g3().getValue()).length() != 0 || C8386Vt0.a.X9()) ? RD5.invite_search_file_empty_state : RD5.not_exist_file;
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public InterfaceC4557Fq2 aa() {
        return ba().e3();
    }

    /* renamed from: ir.nasim.Xl2$b */
    public static final class b implements View.OnAttachStateChangeListener {
        final /* synthetic */ View a;
        final /* synthetic */ C8816Xl2 b;

        public b(View view, C8816Xl2 c8816Xl2) {
            this.a = view;
            this.b = c8816Xl2;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            this.b.U9().h.setContent(AbstractC19242q11.c(-1165026714, true, this.b.new c()));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
