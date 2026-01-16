package ir.nasim;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.UG2;
import ir.nasim.features.smiles.widget.GifRecyclerItemView;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public final class UG2 extends androidx.recyclerview.widget.q {
    public static final b i = new b(null);
    public static final int j = 8;
    private final UA2 f;
    private final UA2 g;
    private final Map h;

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UG2(UA2 ua2, UA2 ua22) {
        super(new C10834cH2());
        AbstractC13042fc3.i(ua2, "onGifClicked");
        AbstractC13042fc3.i(ua22, "onGifLongClicked");
        this.f = ua2;
        this.g = ua22;
        this.h = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(UG2 ug2, long j2, InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(ug2, "this$0");
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        ug2.h.put(Long.valueOf(j2), interfaceC3346Am2.getDescriptor());
        return C19938rB7.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i2) {
        AbstractC13042fc3.i(aVar, "holder");
        QG2 qg2 = (QG2) A(i2);
        if (qg2 != null) {
            aVar.H0(qg2, (String) this.h.get(Long.valueOf(qg2.c().getFileId())));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return new a(this, new GifRecyclerItemView(context, null, 0, 6, null), this.f, this.g, new InterfaceC14603iB2() { // from class: ir.nasim.RG2
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return UG2.I(this.a, ((Long) obj).longValue(), (InterfaceC3346Am2) obj2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(a aVar) {
        AbstractC13042fc3.i(aVar, "holder");
        super.onViewRecycled(aVar);
        aVar.a();
    }

    public final class a extends RecyclerView.C {
        private final GifRecyclerItemView u;
        private final UA2 v;
        private final UA2 w;
        private final InterfaceC14603iB2 x;
        private InterfaceC13730gj3 y;
        final /* synthetic */ UG2 z;

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ QG2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(QG2 qg2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = qg2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return a.this.new b(this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.b = 1;
                    if (HG1.b(200L, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                a.this.w.invoke(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(UG2 ug2, GifRecyclerItemView gifRecyclerItemView, UA2 ua2, UA2 ua22, InterfaceC14603iB2 interfaceC14603iB2) {
            super(gifRecyclerItemView);
            AbstractC13042fc3.i(gifRecyclerItemView, "gifRecyclerItemView");
            AbstractC13042fc3.i(ua2, "onGifClickedListener");
            AbstractC13042fc3.i(ua22, "onGifLongClickedListener");
            AbstractC13042fc3.i(interfaceC14603iB2, "onGifDownloaded");
            this.z = ug2;
            this.u = gifRecyclerItemView;
            this.v = ua2;
            this.w = ua22;
            this.x = interfaceC14603iB2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void J0(a aVar, QG2 qg2, UG2 ug2, View view) {
            AbstractC13042fc3.i(aVar, "this$0");
            AbstractC13042fc3.i(qg2, "$gif");
            AbstractC13042fc3.i(ug2, "this$1");
            UA2 ua2 = aVar.v;
            qg2.h((String) ug2.h.get(Long.valueOf(qg2.c().getFileId())));
            ua2.invoke(qg2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean L0(a aVar, QG2 qg2, View view, MotionEvent motionEvent) {
            InterfaceC13730gj3 interfaceC13730gj3;
            AbstractC13042fc3.i(aVar, "this$0");
            AbstractC13042fc3.i(qg2, "$gif");
            Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
            if (numValueOf != null && numValueOf.intValue() == 0) {
                aVar.y = AbstractC10533bm0.d(AbstractC20906so1.a(C12366eV1.c()), null, null, aVar.new b(qg2, null), 3, null);
                return false;
            }
            if ((numValueOf != null && numValueOf.intValue() == 2) || (interfaceC13730gj3 = aVar.y) == null) {
                return false;
            }
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            return false;
        }

        public final void H0(final QG2 qg2, String str) {
            AbstractC13042fc3.i(qg2, "gif");
            GifRecyclerItemView gifRecyclerItemView = this.u;
            final UG2 ug2 = this.z;
            if (str != null) {
                gifRecyclerItemView.f(str);
            } else {
                gifRecyclerItemView.a(qg2.c(), new C0677a(qg2));
            }
            this.u.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.SG2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UG2.a.J0(this.a, qg2, ug2, view);
                }
            });
            this.u.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.TG2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return UG2.a.L0(this.a, qg2, view, motionEvent);
                }
            });
        }

        public final void a() {
            this.u.l();
        }

        /* renamed from: ir.nasim.UG2$a$a, reason: collision with other inner class name */
        public static final class C0677a implements InterfaceC8091Um2 {
            final /* synthetic */ QG2 b;

            C0677a(QG2 qg2) {
                this.b = qg2;
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
                a.this.x.invoke(Long.valueOf(this.b.c().getFileId()), interfaceC3346Am2);
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void e() {
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void c(float f) {
            }
        }
    }
}
