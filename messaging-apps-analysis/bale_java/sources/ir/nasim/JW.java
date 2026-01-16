package ir.nasim;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC5909Li7;
import ir.nasim.C19528qW;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.JW;
import ir.nasim.premium.ui.badge.BadgeView;

/* loaded from: classes.dex */
public abstract class JW extends RecyclerView.C {

    public static final class a extends JW {
        private final BadgeView u;
        private final InterfaceC18633oz3 v;
        private final InterfaceC14603iB2 w;
        private InterfaceC13730gj3 x;

        /* renamed from: ir.nasim.JW$a$a, reason: collision with other inner class name */
        static final class C0445a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ AbstractC5909Li7.a c;
            final /* synthetic */ BadgeView d;

            /* renamed from: ir.nasim.JW$a$a$a, reason: collision with other inner class name */
            static final class C0446a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ AbstractC5909Li7.a c;
                final /* synthetic */ BadgeView d;

                /* renamed from: ir.nasim.JW$a$a$a$a, reason: collision with other inner class name */
                static final class C0447a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;
                    final /* synthetic */ BadgeView d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0447a(BadgeView badgeView, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = badgeView;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C0447a c0447a = new C0447a(this.d, interfaceC20295rm1);
                        c0447a.c = obj;
                        return c0447a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        String str = (String) this.c;
                        if (str == null || AbstractC20762sZ6.n0(str)) {
                            this.d.c();
                        } else {
                            this.d.e();
                            BadgeView badgeView = this.d;
                            C19528qW.b bVar = C19528qW.p;
                            badgeView.a(str, bVar.d(), bVar.d());
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0447a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0446a(AbstractC5909Li7.a aVar, BadgeView badgeView, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = aVar;
                    this.d = badgeView;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0446a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2A = this.c.a();
                        C0447a c0447a = new C0447a(this.d, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2A, c0447a, this) == objE) {
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
                public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0446a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0445a(AbstractC5909Li7.a aVar, BadgeView badgeView, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aVar;
                this.d = badgeView;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0445a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(this.c.a());
                    C0446a c0446a = new C0446a(this.c, this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2F, c0446a, this) == objE) {
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
                return ((C0445a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BadgeView badgeView, InterfaceC18633oz3 interfaceC18633oz3, InterfaceC14603iB2 interfaceC14603iB2) {
            super(badgeView, null);
            AbstractC13042fc3.i(badgeView, "parentView");
            AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
            AbstractC13042fc3.i(interfaceC14603iB2, "onTabSelected");
            this.u = badgeView;
            this.v = interfaceC18633oz3;
            this.w = interfaceC14603iB2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void F0(a aVar, AbstractC5909Li7.a aVar2, View view) {
            AbstractC13042fc3.i(aVar, "this$0");
            AbstractC13042fc3.i(aVar2, "$item");
            aVar.w.invoke(aVar2, Integer.valueOf(aVar.K()));
        }

        @Override // ir.nasim.JW
        /* renamed from: E0, reason: merged with bridge method [inline-methods] */
        public void C0(final AbstractC5909Li7.a aVar, int i) {
            AbstractC13042fc3.i(aVar, "item");
            BadgeView badgeView = this.u;
            InterfaceC13730gj3 interfaceC13730gj3 = this.x;
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            this.x = AbstractC10533bm0.d(AbstractC19224pz3.a(this.v), null, null, new C0445a(aVar, badgeView, null), 3, null);
            this.u.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IW
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    JW.a.F0(this.a, aVar, view);
                }
            });
        }

        @Override // ir.nasim.JW
        public void a() throws InterruptedException {
            InterfaceC13730gj3 interfaceC13730gj3 = this.x;
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            this.x = null;
            this.u.f();
        }
    }

    public static final class b extends JW {
        private final BadgeView u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BadgeView badgeView) {
            super(badgeView, null);
            AbstractC13042fc3.i(badgeView, "badgeView");
            this.u = badgeView;
        }

        @Override // ir.nasim.JW
        /* renamed from: D0, reason: merged with bridge method [inline-methods] */
        public void C0(AbstractC5909Li7.b bVar, int i) {
            AbstractC13042fc3.i(bVar, "item");
            this.u.c();
        }

        @Override // ir.nasim.JW
        public void a() throws InterruptedException {
            this.u.e();
            this.u.f();
        }
    }

    public /* synthetic */ JW(BadgeView badgeView, ED1 ed1) {
        this(badgeView);
    }

    public abstract void C0(AbstractC5909Li7 abstractC5909Li7, int i);

    public abstract void a();

    private JW(BadgeView badgeView) {
        super(badgeView);
    }
}
