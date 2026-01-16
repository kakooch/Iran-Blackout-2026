package ir.nasim;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.cP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10905cP1 extends AbstractC20423rz2 {
    private List l;
    private InterfaceC18012nw0 m;
    private RecyclerView.t n;
    private InterfaceC4557Fq2 o;
    private UA2 p;
    private InterfaceC4557Fq2 q;

    /* renamed from: ir.nasim.cP1$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BJ6.values().length];
            try {
                iArr[BJ6.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BJ6.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10905cP1(Fragment fragment, List list, InterfaceC18012nw0 interfaceC18012nw0, RecyclerView.t tVar, InterfaceC4557Fq2 interfaceC4557Fq2, UA2 ua2, InterfaceC4557Fq2 interfaceC4557Fq22) {
        super(fragment);
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(list, "tabs");
        AbstractC13042fc3.i(interfaceC4557Fq2, "toolbarActionFlow");
        AbstractC13042fc3.i(ua2, "getAppBarState");
        AbstractC13042fc3.i(interfaceC4557Fq22, "appBarUIIsCloseState");
        this.l = list;
        this.m = interfaceC18012nw0;
        this.n = tVar;
        this.o = interfaceC4557Fq2;
        this.p = ua2;
        this.q = interfaceC4557Fq22;
    }

    @Override // ir.nasim.AbstractC20423rz2
    public boolean A(long j) {
        List list = this.l;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((AJ6) it.next()).a() == j) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.AbstractC20423rz2
    public Fragment B(int i) {
        AJ6 aj6 = (AJ6) this.l.get(i);
        int i2 = a.a[aj6.b().ordinal()];
        Fragment fragmentA = null;
        if (i2 == 1) {
            InterfaceC18012nw0 interfaceC18012nw0 = this.m;
            if (interfaceC18012nw0 != null) {
                fragmentA = interfaceC18012nw0.a(this.o, this.p, this.q);
            }
        } else if (i2 != 2) {
            fragmentA = new Fragment();
        } else {
            RecyclerView.t tVar = this.n;
            if (tVar != null) {
                fragmentA = C14166hT1.B1.a(aj6.a(), tVar);
            }
        }
        return fragmentA == null ? new Fragment() : fragmentA;
    }

    public final void T() {
        this.n = null;
        this.m = null;
        this.l = AbstractC10360bX0.m();
    }

    public final void U(InterfaceC13346g43 interfaceC13346g43) {
        AbstractC13042fc3.i(interfaceC13346g43, "newTabs");
        this.l = interfaceC13346g43;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.l.size();
    }

    @Override // ir.nasim.AbstractC20423rz2, androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i) {
        return ((AJ6) this.l.get(i)).a();
    }
}
