package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class EG6 extends RecyclerView.t {
    private final androidx.recyclerview.widget.y a;
    private a b;
    private b c;
    private int d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final a a = new a("NOTIFY_ON_SCROLL", 0);
        public static final a b = new a("NOTIFY_ON_SCROLL_STATE_IDLE", 1);
        private static final /* synthetic */ a[] c;
        private static final /* synthetic */ F92 d;

        static {
            a[] aVarArrA = a();
            c = aVarArrA;
            d = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) c.clone();
        }
    }

    public interface b {
        void a(int i);
    }

    public EG6(androidx.recyclerview.widget.y yVar, a aVar, b bVar) {
        AbstractC13042fc3.i(yVar, "snapHelper");
        AbstractC13042fc3.i(aVar, "behavior");
        this.a = yVar;
        this.b = aVar;
        this.c = bVar;
        this.d = -1;
    }

    private final void c(RecyclerView recyclerView) {
        int iA = BG6.a(this.a, recyclerView);
        if (this.d != iA) {
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(iA);
            }
            this.d = iA;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        if (this.b == a.b && i == 0) {
            c(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, int i, int i2) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        if (this.b == a.a) {
            c(recyclerView);
        }
    }
}
