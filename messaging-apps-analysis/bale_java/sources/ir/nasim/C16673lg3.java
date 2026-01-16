package ir.nasim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.AbstractC22943w5;
import ir.nasim.E5;
import ir.nasim.F5;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.lg3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C16673lg3 extends RecyclerView.C {
    private final C5696Kl1 u;
    private final SA2 v;
    private final InterfaceC20315ro1 w;
    private final InterfaceC9173Yu3 x;
    private final InterfaceC9173Yu3 y;
    public static final b z = new b(null);
    public static final int A = 8;

    /* renamed from: ir.nasim.lg3$a */
    public static final class a extends RecyclerView.o {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
            AbstractC13042fc3.i(rect, "outRect");
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(recyclerView, "parent");
            AbstractC13042fc3.i(zVar, "state");
            if (recyclerView.getChildAdapterPosition(view) != 0) {
                if (JF5.g()) {
                    rect.set(-C22078ud6.a(8.0f), 0, 0, 0);
                } else {
                    rect.set(0, 0, -C22078ud6.a(8.0f), 0);
                }
            }
        }
    }

    /* renamed from: ir.nasim.lg3$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.lg3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ F5 c;
        final /* synthetic */ C16673lg3 d;

        /* renamed from: ir.nasim.lg3$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C16673lg3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C16673lg3 c16673lg3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c16673lg3;
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
                this.d.Z0().C(AbstractC15401jX0.n0((List) this.c));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.lg3$c$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C16673lg3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C16673lg3 c16673lg3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c16673lg3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.Z0().C(AbstractC15401jX0.n0((List) this.c));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(F5 f5, C16673lg3 c16673lg3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = f5;
            this.d = c16673lg3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC10258bL6 interfaceC10258bL6A;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                F5 f5 = this.c;
                if (f5 instanceof F5.b) {
                    InterfaceC10258bL6 interfaceC10258bL6A2 = ((F5.b) f5).getIcon().a();
                    if (interfaceC10258bL6A2 != null) {
                        a aVar = new a(this.d, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC10258bL6A2, aVar, this) == objE) {
                            return objE;
                        }
                    }
                } else if ((f5 instanceof F5.d) && (interfaceC10258bL6A = ((F5.d) f5).getIcon().a()) != null) {
                    b bVar = new b(this.d, null);
                    this.b = 2;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6A, bVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
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

    /* renamed from: ir.nasim.lg3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC22943w5 c;
        final /* synthetic */ TextView d;
        final /* synthetic */ C16673lg3 e;

        /* renamed from: ir.nasim.lg3$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ int c;
            final /* synthetic */ TextView d;
            final /* synthetic */ C16673lg3 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TextView textView, C16673lg3 c16673lg3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = textView;
                this.e = c16673lg3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = ((Number) obj).intValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).intValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                int i = this.c;
                C19406qI3.a("ItemViewHolder", "count in holder for seen: " + i, new Object[0]);
                TextView textView = this.d;
                String strB = AbstractC12152e76.b(String.valueOf(i));
                Context context = this.e.u.getRoot().getContext();
                String string = context != null ? context.getString(UD5.seen_string) : null;
                if (string == null) {
                    string = "";
                }
                textView.setText(strB + Separators.SP + string);
                if (i != 0) {
                    LinearLayout linearLayout = this.e.u.b;
                    AbstractC13042fc3.h(linearLayout, "contextItem");
                    if (linearLayout.getVisibility() != 0) {
                        C16673lg3 c16673lg3 = this.e;
                        LinearLayout linearLayout2 = c16673lg3.u.b;
                        AbstractC13042fc3.h(linearLayout2, "contextItem");
                        C16673lg3.W0(c16673lg3, linearLayout2, 0L, 1, null);
                    }
                }
                return C19938rB7.a;
            }

            public final Object n(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Integer.valueOf(i), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC22943w5 abstractC22943w5, TextView textView, C16673lg3 c16673lg3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = abstractC22943w5;
            this.d = textView;
            this.e = c16673lg3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6A = ((AbstractC22943w5.a) this.c).a();
                a aVar = new a(this.d, this.e, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6A, aVar, this) == objE) {
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

    /* JADX WARN: Illegal instructions before constructor call */
    public C16673lg3(C5696Kl1 c5696Kl1, SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c5696Kl1, "binding");
        AbstractC13042fc3.i(sa2, "onItemClick");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        MaterialCardView root = c5696Kl1.getRoot();
        if (root == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        super(root);
        this.u = c5696Kl1;
        this.v = sa2;
        this.w = interfaceC20315ro1;
        this.x = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ig3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C16673lg3.a1(this.a);
            }
        });
        this.y = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jg3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C16673lg3.c1();
            }
        });
        c5696Kl1.getRoot().setLayoutDirection(JF5.g() ? 1 : 2);
        c5696Kl1.f.setTypeface(C6011Lu2.k());
        c5696Kl1.c.setTypeface(C6011Lu2.k());
        c5696Kl1.e.setLayoutManager(new LinearLayoutManager(c5696Kl1.getRoot().getContext(), 0, true));
        c5696Kl1.e.addItemDecoration(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N0(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            return view.performClick();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(C16673lg3 c16673lg3, F5 f5, View view) {
        AbstractC13042fc3.i(c16673lg3, "this$0");
        AbstractC13042fc3.i(f5, "$item");
        c16673lg3.v.invoke();
        f5.c().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(C16673lg3 c16673lg3, F5 f5, View view) {
        AbstractC13042fc3.i(c16673lg3, "this$0");
        AbstractC13042fc3.i(f5, "$item");
        c16673lg3.v.invoke();
        f5.c().invoke();
    }

    private final void S0(C5696Kl1 c5696Kl1, String str) {
        TextView textView = c5696Kl1.c;
        textView.setText(str);
        AbstractC13042fc3.f(textView);
        textView.setVisibility((str == null || str.length() == 0) ^ true ? 0 : 8);
    }

    private final void T0(C5696Kl1 c5696Kl1, E5 e5) {
        AppCompatImageView appCompatImageView = c5696Kl1.d;
        if (e5 instanceof E5.c) {
            E5.c cVar = (E5.c) e5;
            ((com.bumptech.glide.g) ((com.bumptech.glide.g) Y0().y(cVar.a()).f0(cVar.b())).y0(new LH0(), new P46((int) ((4 * AbstractC3742Cd6.c()) + 0.5d)))).Q0(appCompatImageView);
        } else if (e5 instanceof E5.a) {
            appCompatImageView.setImageResource(((E5.a) e5).a());
        } else {
            if (!(e5 instanceof E5.b)) {
                throw new NoWhenBranchMatchedException();
            }
            appCompatImageView.setImageResource(((E5.b) e5).b());
        }
    }

    private final void U0(C5696Kl1 c5696Kl1, AbstractC22943w5 abstractC22943w5) {
        TextView textView = c5696Kl1.f;
        if (abstractC22943w5 instanceof AbstractC22943w5.c) {
            textView.setText(((AbstractC22943w5.c) abstractC22943w5).a());
            return;
        }
        if (abstractC22943w5 instanceof AbstractC22943w5.b) {
            textView.setText(((AbstractC22943w5.b) abstractC22943w5).a());
        } else {
            if (!(abstractC22943w5 instanceof AbstractC22943w5.a)) {
                throw new NoWhenBranchMatchedException();
            }
            this.u.b.setVisibility(8);
            AbstractC10533bm0.d(this.w, C12366eV1.c(), null, new d(abstractC22943w5, textView, this, null), 2, null);
        }
    }

    private final void V0(final View view, long j) {
        Object parent = view.getParent();
        AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.View");
        view.measure(View.MeasureSpec.makeMeasureSpec(((View) parent).getWidth(), 1073741824), 0);
        int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        view.setVisibility(0);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, measuredHeight);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.kg3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C16673lg3.X0(view, valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(j);
        valueAnimatorOfInt.start();
    }

    static /* synthetic */ void W0(C16673lg3 c16673lg3, View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 100;
        }
        c16673lg3.V0(view, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(View view, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(view, "$this_expandVertically");
        AbstractC13042fc3.i(valueAnimator, "animation");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        view.requestLayout();
    }

    private final com.bumptech.glide.h Y0() {
        return (com.bumptech.glide.h) this.x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17035mH5 Z0() {
        return (C17035mH5) this.y.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bumptech.glide.h a1(C16673lg3 c16673lg3) {
        AbstractC13042fc3.i(c16673lg3, "this$0");
        return com.bumptech.glide.b.u(c16673lg3.u.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17035mH5 c1() {
        return new C17035mH5();
    }

    public final void Q0(final F5 f5) {
        AbstractC13042fc3.i(f5, "item");
        C5696Kl1 c5696Kl1 = this.u;
        T0(c5696Kl1, f5.getIcon());
        U0(c5696Kl1, f5.getTitle());
        S0(c5696Kl1, f5.a());
        if ((f5 instanceof F5.b) || (f5 instanceof F5.d)) {
            RecyclerView recyclerView = c5696Kl1.e;
            AbstractC13042fc3.h(recyclerView, "recyclerView");
            recyclerView.setVisibility(0);
            c5696Kl1.e.setAdapter(Z0());
            AbstractC10533bm0.d(this.w, C12366eV1.c(), null, new c(f5, this, null), 2, null);
            c5696Kl1.e.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.fg3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return C16673lg3.N0(view, motionEvent);
                }
            });
            c5696Kl1.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.gg3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C16673lg3.O0(this.a, f5, view);
                }
            });
        } else {
            RecyclerView recyclerView2 = c5696Kl1.e;
            AbstractC13042fc3.h(recyclerView2, "recyclerView");
            recyclerView2.setVisibility(8);
        }
        c5696Kl1.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.hg3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16673lg3.P0(this.a, f5, view);
            }
        });
    }
}
