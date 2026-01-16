package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC22588vV1;
import ir.nasim.C20603sI0;

/* renamed from: ir.nasim.tf0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC21435tf0 extends RecyclerView.h {
    protected C19024pf0 d;
    private AbstractC22588vV1.a e;
    protected C4311Ep f;

    /* renamed from: ir.nasim.tf0$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C20603sI0.a.values().length];
            a = iArr;
            try {
                iArr[C20603sI0.a.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[C20603sI0.a.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[C20603sI0.a.MOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[C20603sI0.a.REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AbstractC21435tf0(C19024pf0 c19024pf0) {
        this(c19024pf0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(C4311Ep c4311Ep) {
        this.f = c4311Ep;
        while (true) {
            C20603sI0 c20603sI0C = c4311Ep.c();
            if (c20603sI0C == null) {
                this.f = null;
                return;
            }
            int i = a.a[c20603sI0C.g().ordinal()];
            if (i == 1) {
                notifyItemRangeInserted(c20603sI0C.d(), c20603sI0C.f());
            } else if (i == 2) {
                notifyItemRangeChanged(c20603sI0C.d(), c20603sI0C.f());
            } else if (i == 3) {
                notifyItemMoved(c20603sI0C.d(), c20603sI0C.c());
            } else if (i == 4) {
                notifyItemRangeRemoved(c20603sI0C.d(), c20603sI0C.f());
            }
        }
    }

    protected AbstractC22588vV1.a A() {
        return new AbstractC22588vV1.a() { // from class: ir.nasim.sf0
            @Override // ir.nasim.AbstractC22588vV1.a
            public final void a(C4311Ep c4311Ep) {
                this.a.F(c4311Ep);
            }
        };
    }

    public void B() {
        H();
        this.d.j();
    }

    protected AbstractC17902nl0 C(int i) {
        C4311Ep c4311Ep = this.f;
        return c4311Ep != null ? (AbstractC17902nl0) c4311Ep.a(i) : (AbstractC17902nl0) this.d.o(i);
    }

    public Object D() {
        return this.d.q();
    }

    public boolean E() {
        return this.d.e0();
    }

    public abstract void G(RecyclerView.C c, int i, AbstractC17902nl0 abstractC17902nl0);

    public void H() {
        this.d.t(this.e);
    }

    public void I() {
        this.d.h(this.e);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        C4311Ep c4311Ep = this.f;
        return c4311Ep != null ? c4311Ep.b() : this.d.r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i) {
        return ((HB3) C(i)).a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public final void onBindViewHolder(RecyclerView.C c, int i) {
        this.d.D0(i);
        G(c, i, C(i));
    }

    public AbstractC21435tf0(C19024pf0 c19024pf0, boolean z) {
        this.f = null;
        this.d = c19024pf0;
        setHasStableIds(true);
        this.e = A();
        if (z) {
            I();
        }
    }
}
