package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C20096rT3;
import ir.nasim.core.modules.market.model.MarketSlideItem;
import ir.nasim.core.modules.market.model.MarketSlider;
import ir.nasim.market.util.SpeedyLinearLayoutManager;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: ir.nasim.sT3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20705sT3 extends RecyclerView.C implements C20096rT3.a {
    public static final a A = new a(null);
    public static final int B = 8;
    private final C6350Nf3 u;
    private final C20096rT3.a v;
    private final C20096rT3 w;
    private final C22545vQ3 x;
    private Timer y;
    private androidx.recyclerview.widget.u z;

    /* renamed from: ir.nasim.sT3$a */
    public static final class a {
        private a() {
        }

        public final C20705sT3 a(ViewGroup viewGroup, C20096rT3.a aVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C6350Nf3 c6350Nf3C = C6350Nf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c6350Nf3C, "inflate(...)");
            return new C20705sT3(c6350Nf3C, aVar);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.sT3$b */
    public static final class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.b(recyclerView, i, i2);
            int iComputeHorizontalScrollOffset = (int) ((C20705sT3.this.u.c.computeHorizontalScrollOffset() / C20705sT3.this.u.c.getChildAt(0).getMeasuredWidth()) + 0.5f);
            ArrayList arrayListZ = C20705sT3.this.x.z();
            C20705sT3 c20705sT3 = C20705sT3.this;
            int i3 = 0;
            for (Object obj : arrayListZ) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    AbstractC10360bX0.w();
                }
                ((Boolean) obj).booleanValue();
                c20705sT3.x.z().set(i3, Boolean.valueOf(i3 == iComputeHorizontalScrollOffset));
                i3 = i4;
            }
            C20705sT3.this.x.notifyDataSetChanged();
        }
    }

    /* renamed from: ir.nasim.sT3$c */
    public static final class c extends RecyclerView.t {
        final /* synthetic */ MarketSlider b;

        c(MarketSlider marketSlider) {
            this.b = marketSlider;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            androidx.recyclerview.widget.u uVar = C20705sT3.this.z;
            if (uVar != null) {
                RecyclerView recyclerView2 = C20705sT3.this.u.c;
                AbstractC13042fc3.h(recyclerView2, "slider");
                this.b.setSliderPosition(BG6.a(uVar, recyclerView2));
            }
            super.b(recyclerView, i, i2);
        }
    }

    /* renamed from: ir.nasim.sT3$d */
    public static final class d extends TimerTask {
        final /* synthetic */ MarketSlider a;
        final /* synthetic */ C20705sT3 b;

        public d(MarketSlider marketSlider, C20705sT3 c20705sT3) {
            this.a = marketSlider;
            this.b = c20705sT3;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.a.getSliderPosition() + 1 == this.b.w.B().size()) {
                this.a.setSliderPosition(0);
            } else {
                this.a.setSliderPosition(this.a.getSliderPosition() + 1);
            }
            this.b.u.c.smoothScrollToPosition(this.a.getSliderPosition());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20705sT3(C6350Nf3 c6350Nf3, C20096rT3.a aVar) {
        super(c6350Nf3.getRoot());
        AbstractC13042fc3.i(c6350Nf3, "binding");
        this.u = c6350Nf3;
        this.v = aVar;
        this.w = new C20096rT3();
        this.x = new C22545vQ3();
    }

    private final ArrayList J0(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < i) {
            arrayList.add(Boolean.valueOf(i3 == i2));
            i3++;
        }
        AbstractC14812iX0.b0(arrayList);
        return arrayList;
    }

    private final void L0(MarketSlider marketSlider) {
        if (this.w.B().size() <= 1) {
            this.u.b.setVisibility(8);
            return;
        }
        this.x.C(J0(this.w.B().size(), marketSlider.getSliderPosition()));
        this.u.b.setAdapter(this.x);
        this.x.notifyDataSetChanged();
        this.u.c.addOnScrollListener(new b());
        this.u.b.setVisibility(0);
    }

    private final void M0(MarketSlider marketSlider) {
        this.u.c.setLayoutManager(new SpeedyLinearLayoutManager(this.a.getContext(), 0, false));
        this.u.c.setAdapter(this.w);
        this.w.H(this);
        androidx.recyclerview.widget.u uVar = new androidx.recyclerview.widget.u();
        this.z = uVar;
        uVar.b(this.u.c);
        this.u.c.addOnScrollListener(new c(marketSlider));
    }

    private final void N0(MarketSlider marketSlider) {
        this.w.B().clear();
        this.w.B().addAll(marketSlider.getSlides());
        this.w.notifyDataSetChanged();
        L0(marketSlider);
        this.u.c.scrollToPosition(marketSlider.getSliderPosition());
        Timer timer = this.y;
        if (timer != null) {
            timer.cancel();
        }
        Timer timerA = AbstractC4811Gq7.a("main", false);
        timerA.scheduleAtFixedRate(new d(marketSlider, this), 7000L, 7000L);
        this.y = timerA;
    }

    public final void H0(MarketSlider marketSlider) {
        AbstractC13042fc3.i(marketSlider, "marketSlider");
        M0(marketSlider);
        N0(marketSlider);
    }

    public final void O0() {
        Timer timer = this.y;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = this.y;
        if (timer2 != null) {
            timer2.purge();
        }
        this.y = null;
        this.u.c.setOnFlingListener(null);
        this.z = null;
    }

    @Override // ir.nasim.C20096rT3.a
    public void U4(MarketSlideItem marketSlideItem) {
        AbstractC13042fc3.i(marketSlideItem, "item");
        C20096rT3.a aVar = this.v;
        if (aVar != null) {
            aVar.U4(marketSlideItem);
        }
    }
}
