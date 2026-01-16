package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import ir.nasim.VU3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.uS0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C21970uS0 {
    private final Map a = new HashMap();
    private final Set b = new HashSet();
    private b c;
    private boolean d;
    private boolean e;

    /* renamed from: ir.nasim.uS0$a */
    class a implements VU3.a {
        a() {
        }

        @Override // ir.nasim.VU3.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(VU3 vu3, boolean z) {
            if (!z) {
                C21970uS0 c21970uS0 = C21970uS0.this;
                if (!c21970uS0.r(vu3, c21970uS0.e)) {
                    return;
                }
            } else if (!C21970uS0.this.g(vu3)) {
                return;
            }
            C21970uS0.this.m();
        }
    }

    /* renamed from: ir.nasim.uS0$b */
    public interface b {
        void a(Set set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(VU3 vu3) {
        int id = vu3.getId();
        if (this.b.contains(Integer.valueOf(id))) {
            return false;
        }
        VU3 vu32 = (VU3) this.a.get(Integer.valueOf(k()));
        if (vu32 != null) {
            r(vu32, false);
        }
        boolean zAdd = this.b.add(Integer.valueOf(id));
        if (!vu3.isChecked()) {
            vu3.setChecked(true);
        }
        return zAdd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(VU3 vu3, boolean z) {
        int id = vu3.getId();
        if (!this.b.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z && this.b.size() == 1 && this.b.contains(Integer.valueOf(id))) {
            vu3.setChecked(true);
            return false;
        }
        boolean zRemove = this.b.remove(Integer.valueOf(id));
        if (vu3.isChecked()) {
            vu3.setChecked(false);
        }
        return zRemove;
    }

    public void e(VU3 vu3) {
        this.a.put(Integer.valueOf(vu3.getId()), vu3);
        if (vu3.isChecked()) {
            g(vu3);
        }
        vu3.setInternalOnCheckedChangeListener(new a());
    }

    public void f(int i) {
        VU3 vu3 = (VU3) this.a.get(Integer.valueOf(i));
        if (vu3 != null && g(vu3)) {
            m();
        }
    }

    public void h() {
        boolean z = !this.b.isEmpty();
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            r((VU3) it.next(), false);
        }
        if (z) {
            m();
        }
    }

    public Set i() {
        return new HashSet(this.b);
    }

    public List j(ViewGroup viewGroup) {
        Set setI = i();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof VU3) && setI.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int k() {
        if (!this.d || this.b.isEmpty()) {
            return -1;
        }
        return ((Integer) this.b.iterator().next()).intValue();
    }

    public boolean l() {
        return this.d;
    }

    public void n(VU3 vu3) {
        vu3.setInternalOnCheckedChangeListener(null);
        this.a.remove(Integer.valueOf(vu3.getId()));
        this.b.remove(Integer.valueOf(vu3.getId()));
    }

    public void o(b bVar) {
        this.c = bVar;
    }

    public void p(boolean z) {
        this.e = z;
    }

    public void q(boolean z) {
        if (this.d != z) {
            this.d = z;
            h();
        }
    }
}
