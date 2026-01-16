package ir.nasim;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.nasim.C19528qW;
import ir.nasim.HW;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.RW;
import ir.nasim.premium.ui.badge.BadgeView;

/* loaded from: classes.dex */
public abstract class RW extends RecyclerView.C {

    public static final class a extends RW {
        private final InterfaceC18633oz3 u;
        private final BadgeView v;
        private final UA2 w;
        private InterfaceC13730gj3 x;

        /* renamed from: ir.nasim.RW$a$a, reason: collision with other inner class name */
        static final class C0598a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ HW.a c;
            final /* synthetic */ BadgeView d;

            /* renamed from: ir.nasim.RW$a$a$a, reason: collision with other inner class name */
            static final class C0599a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ BadgeView d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0599a(BadgeView badgeView, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = badgeView;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0599a c0599a = new C0599a(this.d, interfaceC20295rm1);
                    c0599a.c = obj;
                    return c0599a;
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
                        badgeView.a(str, bVar.b(), bVar.b());
                        this.d.b();
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0599a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0598a(HW.a aVar, BadgeView badgeView, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aVar;
                this.d = badgeView;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0598a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2D = this.c.d();
                    C0599a c0599a = new C0599a(this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2D, c0599a, this) == objE) {
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
                return ((C0598a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC18633oz3 interfaceC18633oz3, BadgeView badgeView, UA2 ua2) {
            super(badgeView, null);
            AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
            AbstractC13042fc3.i(badgeView, "badgeView");
            AbstractC13042fc3.i(ua2, "onEmojiSelectedListener");
            this.u = interfaceC18633oz3;
            this.v = badgeView;
            this.w = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void F0(a aVar, HW.a aVar2, View view) {
            AbstractC13042fc3.i(aVar, "this$0");
            AbstractC13042fc3.i(aVar2, "$item");
            aVar.w.invoke(aVar2);
        }

        @Override // ir.nasim.RW
        /* renamed from: E0, reason: merged with bridge method [inline-methods] */
        public void C0(final HW.a aVar) {
            AbstractC13042fc3.i(aVar, "item");
            BadgeView badgeView = this.v;
            InterfaceC13730gj3 interfaceC13730gj3 = this.x;
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            this.x = AbstractC10533bm0.d(AbstractC19224pz3.a(this.u), null, null, new C0598a(aVar, badgeView, null), 3, null);
            this.v.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.QW
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RW.a.F0(this.a, aVar, view);
                }
            });
        }

        public final void H0() {
            this.v.b();
        }

        public final void J0() {
            this.v.d();
        }

        @Override // ir.nasim.RW
        public void a() throws InterruptedException {
            InterfaceC13730gj3 interfaceC13730gj3 = this.x;
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            this.x = null;
            this.v.f();
        }
    }

    public static final class b extends RW {
        private final TextView u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TextView textView) {
            super(textView, null);
            AbstractC13042fc3.i(textView, "textView");
            this.u = textView;
        }

        @Override // ir.nasim.RW
        /* renamed from: D0, reason: merged with bridge method [inline-methods] */
        public void C0(HW.b bVar) {
            AbstractC13042fc3.i(bVar, "item");
            this.u.setText(JF5.g() ? bVar.d() : bVar.c());
        }

        @Override // ir.nasim.RW
        public void a() {
            this.u.setText("");
        }
    }

    public static final class c extends RW {
        private final ShimmerFrameLayout u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ShimmerFrameLayout shimmerFrameLayout) {
            super(shimmerFrameLayout, null);
            AbstractC13042fc3.i(shimmerFrameLayout, "shimmerLayout");
            this.u = shimmerFrameLayout;
        }

        @Override // ir.nasim.RW
        /* renamed from: D0, reason: merged with bridge method [inline-methods] */
        public void C0(HW.c.b bVar) {
            AbstractC13042fc3.i(bVar, "item");
            this.u.e();
        }

        @Override // ir.nasim.RW
        public void a() {
            this.u.f();
        }
    }

    public static final class d extends RW {
        private final BadgeView u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(BadgeView badgeView) {
            super(badgeView, null);
            AbstractC13042fc3.i(badgeView, "badgeView");
            this.u = badgeView;
        }

        @Override // ir.nasim.RW
        /* renamed from: D0, reason: merged with bridge method [inline-methods] */
        public void C0(HW.c.a aVar) {
            AbstractC13042fc3.i(aVar, "item");
            this.u.c();
        }

        @Override // ir.nasim.RW
        public void a() throws InterruptedException {
            this.u.e();
            this.u.f();
        }
    }

    public /* synthetic */ RW(View view, ED1 ed1) {
        this(view);
    }

    public abstract void C0(HW hw);

    public abstract void a();

    private RW(View view) {
        super(view);
    }
}
