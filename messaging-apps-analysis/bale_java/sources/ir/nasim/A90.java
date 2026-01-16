package ir.nasim;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C15225jD4;
import ir.nasim.C19024pf0;

/* loaded from: classes5.dex */
public abstract class A90 extends AV1 implements C15225jD4.b {
    private D90 l1;
    private final boolean m1;
    private final boolean n1;
    private View o1;
    private int p1;
    private C19024pf0 q1;

    class b implements InterfaceC14756iQ7 {
        b() {
        }

        @Override // ir.nasim.InterfaceC14756iQ7
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Boolean bool, AbstractC13554gQ7 abstractC13554gQ7) {
            if (A90.this.o1 != null) {
                if (bool.booleanValue()) {
                    A90.this.o1.setVisibility(0);
                } else {
                    A90.this.o1.setVisibility(8);
                }
            }
        }
    }

    class c implements SearchView.m {
        c() {
        }

        @Override // androidx.appcompat.widget.SearchView.m
        public boolean a(String str) {
            A90.this.ra(str);
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.m
        public boolean b(String str) {
            return false;
        }
    }

    public A90(boolean z, boolean z2, int i) {
        this.m1 = z;
        this.n1 = z2;
        this.p1 = i;
    }

    @Override // androidx.fragment.app.Fragment
    public void P6(Menu menu, MenuInflater menuInflater) {
        super.P6(menu, menuInflater);
        if (this.m1) {
            menuInflater.inflate(AbstractC15226jD5.compose, menu);
            ((SearchView) menu.findItem(BC5.contacts_search).getActionView()).setOnQueryTextListener(new c());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this.l1.n();
    }

    @Override // ir.nasim.AV1, ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        if (ba() != null) {
            ba().B();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void W6(boolean z) {
        super.W6(z);
        if (z) {
            this.l1.n();
        }
    }

    @Override // ir.nasim.AV1, ir.nasim.AbstractC22588vV1.e
    public void X0() {
        super.X0();
        this.l1.m();
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int i, Object... objArr) {
        if (i == C15225jD4.i) {
            int childCount = ca().getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RecyclerView.C cFindContainingViewHolder = ca().findContainingViewHolder(ca().getChildAt(i2));
                if (cFindContainingViewHolder instanceof C11849df1) {
                    ((C11849df1) cFindContainingViewHolder).P0();
                }
            }
        }
    }

    protected void qa() {
        View view = new View(A5());
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, C22078ud6.a(8.0f)));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        view.setBackgroundColor(c5495Jo7.O0());
        S9(view, false);
        View view2 = new View(A5());
        view2.setLayoutParams(new FrameLayout.LayoutParams(-1, C22078ud6.a(4.0f)));
        view2.setBackgroundColor(c5495Jo7.O0());
        Q9(view2);
    }

    public void ra(String str) {
        if (str == null) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            da().d0(false);
            C19406qI3.a("BaseContactFragment", "Called initTop from BaseContactFragment -> filter", new Object[0]);
        } else {
            da().b0(strTrim, false);
            C19406qI3.a("BaseContactFragment", "Called initSearch from BaseContactFragment -> filter", new Object[0]);
        }
        C13708gh1 c13708gh1 = (C13708gh1) ba();
        if (c13708gh1 != null) {
            c13708gh1.S(strTrim.toLowerCase());
        }
    }

    AbstractC22588vV1 sa() {
        return this.q1;
    }

    public Integer[] ta() {
        return ((C13708gh1) ba()).K();
    }

    public int ua() {
        return ((C13708gh1) ba()).getSelectedCount();
    }

    public boolean va(int i) {
        return ((C13708gh1) ba()).M(i);
    }

    protected View wa(int i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C19024pf0 c19024pf0X1 = AbstractC5969Lp4.d().X1();
        this.q1 = c19024pf0X1;
        View viewFa = fa(layoutInflater, viewGroup, i, c19024pf0X1, false);
        View viewFindViewById = viewFa.findViewById(BC5.collection);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewFindViewById.setBackgroundColor(c5495Jo7.n());
        View viewFindViewById2 = viewFa.findViewById(BC5.empty_collection_text);
        this.o1 = viewFindViewById2;
        if (viewFindViewById2 != null && (viewFindViewById2 instanceof TextView)) {
            ((TextView) viewFindViewById2.findViewById(BC5.empty_collection_text)).setTextColor(c5495Jo7.g0());
        }
        ka(false);
        View view = new View(A5());
        view.setBackgroundColor(c5495Jo7.n());
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        S9(view, false);
        qa();
        this.q1.B0(new a());
        if (this.o1 != null) {
            if (((Boolean) AbstractC5969Lp4.d().O().i().b()).booleanValue()) {
                this.o1.setVisibility(0);
            } else {
                this.o1.setVisibility(8);
            }
        }
        this.l1 = new D90(this);
        s8(AbstractC5969Lp4.d().O().i(), new b());
        viewFa.setBackgroundColor(c5495Jo7.n());
        return viewFa;
    }

    public void xa(int i) {
        ((C13708gh1) ba()).R(i);
    }

    public void ya(int i) {
        ((C13708gh1) ba()).T(i);
    }

    class a implements C19024pf0.b {
        a() {
        }

        @Override // ir.nasim.C19024pf0.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(C3512Be1 c3512Be1, int i) {
            A90.this.l1.l(c3512Be1, i);
        }

        @Override // ir.nasim.C19024pf0.b
        public void b() {
        }
    }
}
