package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class I40 extends RecyclerView.h {
    private final d d;
    private ArrayList e;
    private a f;
    private c g;

    public interface a {
        void u4(H40 h40);
    }

    public interface b {
    }

    public interface c {
        void W4(H40 h40);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class d {
        public static final d a = new d("SELECT_MODE", 0);
        public static final d b = new d("MANAGEMENT_MODE", 1);
        private static final /* synthetic */ d[] c;
        private static final /* synthetic */ F92 d;

        static {
            d[] dVarArrA = a();
            c = dVarArrA;
            d = G92.a(dVarArrA);
        }

        private d(String str, int i) {
        }

        private static final /* synthetic */ d[] a() {
            return new d[]{a, b};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) c.clone();
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public I40(d dVar) {
        AbstractC13042fc3.i(dVar, "type");
        this.d = dVar;
        this.e = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(U40 u40, int i) {
        AbstractC13042fc3.i(u40, "holder");
        Object obj = this.e.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        u40.J0((H40) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public U40 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        int i2 = e.a[this.d.ordinal()];
        if (i2 == 1) {
            return U40.z.b(viewGroup, this.f, this.g);
        }
        if (i2 == 2) {
            return U40.z.a(viewGroup, this.f, this.g, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void C(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.e = arrayList;
    }

    public final void D(a aVar) {
        this.f = aVar;
    }

    public final void E(c cVar) {
        this.g = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.size();
    }

    public final ArrayList z() {
        return this.e;
    }
}
