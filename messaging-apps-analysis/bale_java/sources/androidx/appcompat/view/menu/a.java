package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a implements j {
    protected Context a;
    protected Context b;
    protected e c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    private j.a f;
    private int g;
    private int h;
    protected k i;
    private int j;

    public a(Context context, int i, int i2) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        this.g = i;
        this.h = i2;
    }

    protected void b(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.i).addView(view, i);
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(e eVar, boolean z) {
        j.a aVar = this.f;
        if (aVar != null) {
            aVar.c(eVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean d(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void e(j.a aVar) {
        this.f = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.e] */
    @Override // androidx.appcompat.view.menu.j
    public boolean g(m mVar) {
        j.a aVar = this.f;
        m mVar2 = mVar;
        if (aVar == null) {
            return false;
        }
        if (mVar == null) {
            mVar2 = this.c;
        }
        return aVar.d(mVar2);
    }

    @Override // androidx.appcompat.view.menu.j
    public int getId() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public void i(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.c;
        int i = 0;
        if (eVar != null) {
            eVar.t();
            ArrayList arrayListG = this.c.G();
            int size = arrayListG.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = (g) arrayListG.get(i3);
                if (t(i2, gVar)) {
                    View childAt = viewGroup.getChildAt(i2);
                    g itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                    View viewQ = q(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        viewQ.setPressed(false);
                        viewQ.jumpDrawablesToCurrentState();
                    }
                    if (viewQ != childAt) {
                        b(viewQ, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!o(viewGroup, i)) {
                i++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean k(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void l(Context context, e eVar) {
        this.b = context;
        this.e = LayoutInflater.from(context);
        this.c = eVar;
    }

    public abstract void m(g gVar, k.a aVar);

    public k.a n(ViewGroup viewGroup) {
        return (k.a) this.d.inflate(this.h, viewGroup, false);
    }

    protected boolean o(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public j.a p() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View q(g gVar, View view, ViewGroup viewGroup) {
        k.a aVarN = view instanceof k.a ? (k.a) view : n(viewGroup);
        m(gVar, aVarN);
        return (View) aVarN;
    }

    public k r(ViewGroup viewGroup) {
        if (this.i == null) {
            k kVar = (k) this.d.inflate(this.g, viewGroup, false);
            this.i = kVar;
            kVar.a(this.c);
            i(true);
        }
        return this.i;
    }

    public void s(int i) {
        this.j = i;
    }

    public abstract boolean t(int i, g gVar);
}
