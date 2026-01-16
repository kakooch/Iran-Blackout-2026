package ir.nasim;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.nl, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17901nl extends AbstractC10505bj2 {
    public static final b L0 = new b(null);
    public static final int M0 = 8;
    private static final a N0 = new a();
    private final ViewGroup G0;
    private final C14970in2 H0;
    private final InterfaceC14123hO3 I0;
    private AbstractC15520jj2.b J0;
    private final C6358Ng2 K0;

    /* renamed from: ir.nasim.nl$a */
    public static final class a implements InterfaceC21561tl {
        a() {
        }

        @Override // ir.nasim.InterfaceC21561tl
        public void b(long j, String str, long j2, long j3) {
            AbstractC13042fc3.i(str, "mimeType");
        }
    }

    /* renamed from: ir.nasim.nl$b */
    public static final class b {
        private b() {
        }

        public final C17901nl a(ViewGroup viewGroup, C14970in2 c14970in2, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC13138fj2 interfaceC13138fj2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(c14970in2, "filesModule");
            AbstractC13042fc3.i(interfaceC14123hO3, "mediaMessageToAbsContentMapper");
            AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
            C11268cj2 c11268cj2C = C11268cj2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c11268cj2C, "inflate(...)");
            return new C17901nl(viewGroup, c14970in2, interfaceC14123hO3, c11268cj2C, interfaceC13138fj2);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.nl$c */
    /* synthetic */ class c extends EB2 implements UA2 {
        c(Object obj) {
            super(1, obj, C4041Dl.class, "getItemWidthAndHeight", "getItemWidthAndHeight(I)Lkotlin/Pair;", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return y(((Number) obj).intValue());
        }

        public final XV4 y(int i) {
            return ((C4041Dl) this.receiver).l(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17901nl(ViewGroup viewGroup, C14970in2 c14970in2, InterfaceC14123hO3 interfaceC14123hO3, C11268cj2 c11268cj2, InterfaceC13138fj2 interfaceC13138fj2) {
        super(c11268cj2, interfaceC13138fj2);
        AbstractC13042fc3.i(viewGroup, "parent");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(interfaceC14123hO3, "mediaMessageToAbsContentMapper");
        AbstractC13042fc3.i(c11268cj2, "binding");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        this.G0 = viewGroup;
        this.H0 = c14970in2;
        this.I0 = interfaceC14123hO3;
        ViewStub viewStub = c11268cj2.g;
        viewStub.setLayoutResource(HC5.feed_album_holder);
        viewStub.setInflatedId(viewStub.getId());
        this.K0 = C6358Ng2.a(viewStub.inflate());
    }

    private final void N3(AbstractC15520jj2.b bVar) {
        int i = !O3(((AbstractC15520jj2.a) AbstractC15401jX0.q0(bVar.c())).b()) ? 1 : 0;
        C4041Dl c4041Dl = new C4041Dl(i, bVar.c().size(), this.G0.getWidth(), (int) (this.G0.getHeight() * 0.55d), this.a.getContext().getResources().getDimensionPixelSize(VA5.album_content_item_separation));
        C8538Wk c8538Wk = new C8538Wk(new c(c4041Dl), N0, this.H0);
        this.K0.b.setAdapter(c8538Wk);
        RecyclerView recyclerView = this.K0.b;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.a.getContext(), c4041Dl.r(), i, false);
        gridLayoutManager.k3(c4041Dl);
        recyclerView.setLayoutManager(gridLayoutManager);
        c8538Wk.C(bVar.c());
    }

    private static final boolean O3(AbstractC15520jj2.d dVar) {
        return dVar.g() < dVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P3(C17901nl c17901nl, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c17901nl, "this$0");
        return c17901nl.q1().onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S3(C17901nl c17901nl, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(c17901nl, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(view, "it");
        c17901nl.b3(c4743Gj2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T3(C17901nl c17901nl, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(c17901nl, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(view, "it");
        c17901nl.Y2(new C8755Xe4(c4743Gj2.f().I0().getPeerId(), c4743Gj2.e().e(), c4743Gj2.e().m(), 0, 8, null), c4743Gj2.e());
        return C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC10505bj2
    public void E2(AbstractC15520jj2 abstractC15520jj2) {
        AbstractC13042fc3.i(abstractC15520jj2, "feedMessage");
        super.E2(abstractC15520jj2);
        AbstractC15520jj2.b bVar = (AbstractC15520jj2.b) abstractC15520jj2;
        this.J0 = bVar;
        t3(abstractC15520jj2);
        N3(bVar);
        this.K0.b.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.kl
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C17901nl.P3(this.a, view, motionEvent);
            }
        });
        final C4743Gj2 c4743Gj2F3 = f3();
        if (c4743Gj2F3 != null) {
            RecyclerView recyclerView = this.K0.b;
            AbstractC13042fc3.h(recyclerView, "albumRv");
            AbstractC10505bj2.v3(this, recyclerView, 0L, 0.0f, new UA2() { // from class: ir.nasim.ll
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C17901nl.S3(this.a, c4743Gj2F3, (View) obj);
                }
            }, new UA2() { // from class: ir.nasim.ml
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C17901nl.T3(this.a, c4743Gj2F3, (View) obj);
                }
            }, 3, null);
        }
    }

    @Override // ir.nasim.AbstractC13019fa0
    public AbstractC17457n0 T0() {
        C5886Lg2 c5886Lg2E;
        Long lH;
        C5886Lg2 c5886Lg2E2;
        C17901nl c17901nl = this;
        AbstractC15520jj2.b bVar = c17901nl.J0;
        if (bVar == null) {
            AbstractC13042fc3.y("albumMessage");
            bVar = null;
        }
        List<AbstractC15520jj2.a> listC = bVar.c();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listC, 10));
        for (AbstractC15520jj2.a aVar : listC) {
            long jC = aVar.c();
            long jA = aVar.a();
            long jA2 = aVar.a();
            C4743Gj2 c4743Gj2F3 = f3();
            int iN = (c4743Gj2F3 == null || (c5886Lg2E2 = c4743Gj2F3.e()) == null) ? 0 : c5886Lg2E2.n();
            EnumC23558x74 enumC23558x74 = EnumC23558x74.UNKNOWN;
            AbstractC17457n0 abstractC17457n0 = (AbstractC17457n0) c17901nl.I0.a(aVar.b());
            C4743Gj2 c4743Gj2F32 = f3();
            arrayList.add(new J44(jC, jA, jA2, iN, enumC23558x74, abstractC17457n0, null, 0, null, null, 0L, null, null, false, Long.valueOf((c4743Gj2F32 == null || (c5886Lg2E = c4743Gj2F32.e()) == null || (lH = c5886Lg2E.h()) == null) ? AbstractC17026mG5.a.k() : lH.longValue()), null, false, null, null, 507840, null));
            c17901nl = this;
        }
        return new C11907dl(arrayList);
    }

    @Override // ir.nasim.AbstractC13019fa0
    public void c1() {
        LottieAnimationView lottieAnimationView = this.K0.d;
        AbstractC13042fc3.h(lottieAnimationView, "feedReactionAnim");
        lottieAnimationView.setVisibility(0);
        this.K0.d.x();
    }

    @Override // ir.nasim.AbstractC13019fa0
    public boolean n1() {
        AbstractC15520jj2.b bVar = this.J0;
        if (bVar == null) {
            AbstractC13042fc3.y("albumMessage");
            bVar = null;
        }
        return !AbstractC20762sZ6.n0(((AbstractC15520jj2.a) AbstractC15401jX0.q0(bVar.c())).b().c());
    }

    @Override // ir.nasim.AbstractC10505bj2
    public void t3(AbstractC15520jj2 abstractC15520jj2) {
        C12800fB6 c12800fB6H3;
        AbstractC13042fc3.i(abstractC15520jj2, DialogEntity.COLUMN_MESSAGE);
        this.K0.c.setMovementMethod(t1());
        CharSequence charSequenceE = p1().e(AbstractC13155fl.a((AbstractC15520jj2.b) abstractC15520jj2));
        if (charSequenceE == null || (c12800fB6H3 = h3()) == null) {
            return;
        }
        TextView textView = this.K0.c;
        AbstractC13042fc3.h(textView, "feedAlbumText");
        c12800fB6H3.t(textView, charSequenceE, false);
    }
}
