package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.O98;
import ir.nasim.X2;
import ir.nasim.YC5;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class a implements androidx.appcompat.view.menu.j {
    int A;
    private NavigationMenuView a;
    LinearLayout b;
    private j.a c;
    androidx.appcompat.view.menu.e d;
    private int e;
    c f;
    LayoutInflater g;
    ColorStateList i;
    ColorStateList k;
    ColorStateList l;
    Drawable m;
    RippleDrawable n;
    int o;
    int p;
    int q;
    int r;
    int s;
    int t;
    int u;
    int v;
    boolean w;
    private int y;
    private int z;
    int h = 0;
    int j = 0;
    boolean x = true;
    private int B = -1;
    final View.OnClickListener D = new ViewOnClickListenerC0185a();

    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0185a implements View.OnClickListener {
        ViewOnClickListenerC0185a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            a.this.V(true);
            androidx.appcompat.view.menu.g itemData = ((NavigationMenuItemView) view).getItemData();
            a aVar = a.this;
            boolean zO = aVar.d.O(itemData, aVar, 0);
            if (itemData != null && itemData.isCheckable() && zO) {
                a.this.f.I(itemData);
            } else {
                z = false;
            }
            a.this.V(false);
            if (z) {
                a.this.i(false);
            }
        }
    }

    private static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    private class c extends RecyclerView.h {
        private final ArrayList d = new ArrayList();
        private androidx.appcompat.view.menu.g e;
        private boolean f;

        c() {
            G();
        }

        private void G() {
            if (this.f) {
                return;
            }
            boolean z = true;
            this.f = true;
            this.d.clear();
            this.d.add(new d());
            int size = a.this.d.G().size();
            int i = -1;
            int i2 = 0;
            boolean z2 = false;
            int size2 = 0;
            while (i2 < size) {
                androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) a.this.d.G().get(i2);
                if (gVar.isChecked()) {
                    I(gVar);
                }
                if (gVar.isCheckable()) {
                    gVar.t(false);
                }
                if (gVar.hasSubMenu()) {
                    SubMenu subMenu = gVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i2 != 0) {
                            this.d.add(new f(a.this.A, 0));
                        }
                        this.d.add(new g(gVar));
                        int size3 = this.d.size();
                        int size4 = subMenu.size();
                        int i3 = 0;
                        boolean z3 = false;
                        while (i3 < size4) {
                            androidx.appcompat.view.menu.g gVar2 = (androidx.appcompat.view.menu.g) subMenu.getItem(i3);
                            if (gVar2.isVisible()) {
                                if (!z3 && gVar2.getIcon() != null) {
                                    z3 = z;
                                }
                                if (gVar2.isCheckable()) {
                                    gVar2.t(false);
                                }
                                if (gVar.isChecked()) {
                                    I(gVar);
                                }
                                this.d.add(new g(gVar2));
                            }
                            i3++;
                            z = true;
                        }
                        if (z3) {
                            z(size3, this.d.size());
                        }
                    }
                } else {
                    int groupId = gVar.getGroupId();
                    if (groupId != i) {
                        size2 = this.d.size();
                        z2 = gVar.getIcon() != null;
                        if (i2 != 0) {
                            size2++;
                            ArrayList arrayList = this.d;
                            int i4 = a.this.A;
                            arrayList.add(new f(i4, i4));
                        }
                    } else if (!z2 && gVar.getIcon() != null) {
                        z(size2, this.d.size());
                        z2 = true;
                    }
                    g gVar3 = new g(gVar);
                    gVar3.b = z2;
                    this.d.add(gVar3);
                    i = groupId;
                }
                i2++;
                z = true;
            }
            this.f = false;
        }

        private void z(int i, int i2) {
            while (i < i2) {
                ((g) this.d.get(i)).b = true;
                i++;
            }
        }

        public Bundle A() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.g gVar = this.e;
            if (gVar != null) {
                bundle.putInt("android:menu:checked", gVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                e eVar = (e) this.d.get(i);
                if (eVar instanceof g) {
                    androidx.appcompat.view.menu.g gVarA = ((g) eVar).a();
                    View actionView = gVarA != null ? gVarA.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(gVarA.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public androidx.appcompat.view.menu.g B() {
            return this.e;
        }

        int C() {
            int i = a.this.b.getChildCount() == 0 ? 0 : 1;
            for (int i2 = 0; i2 < a.this.f.getItemCount(); i2++) {
                if (a.this.f.getItemViewType(i2) == 0) {
                    i++;
                }
            }
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(l lVar, int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        return;
                    }
                    f fVar = (f) this.d.get(i);
                    lVar.a.setPadding(a.this.s, fVar.b(), a.this.t, fVar.a());
                    return;
                }
                TextView textView = (TextView) lVar.a;
                textView.setText(((g) this.d.get(i)).a().getTitle());
                int i2 = a.this.h;
                if (i2 != 0) {
                    AbstractC15575jo7.p(textView, i2);
                }
                textView.setPadding(a.this.u, textView.getPaddingTop(), a.this.v, textView.getPaddingBottom());
                ColorStateList colorStateList = a.this.i;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                    return;
                }
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.a;
            navigationMenuItemView.setIconTintList(a.this.l);
            int i3 = a.this.j;
            if (i3 != 0) {
                navigationMenuItemView.setTextAppearance(i3);
            }
            ColorStateList colorStateList2 = a.this.k;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = a.this.m;
            AbstractC12990fW7.t0(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = a.this.n;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) this.d.get(i);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.b);
            a aVar = a.this;
            int i4 = aVar.o;
            int i5 = aVar.p;
            navigationMenuItemView.setPadding(i4, i5, i4, i5);
            navigationMenuItemView.setIconPadding(a.this.q);
            a aVar2 = a.this;
            if (aVar2.w) {
                navigationMenuItemView.setIconSize(aVar2.r);
            }
            navigationMenuItemView.setMaxLines(a.this.y);
            navigationMenuItemView.c(gVar.a(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public l onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                a aVar = a.this;
                return new i(aVar.g, viewGroup, aVar.D);
            }
            if (i == 1) {
                return new k(a.this.g, viewGroup);
            }
            if (i == 2) {
                return new j(a.this.g, viewGroup);
            }
            if (i != 3) {
                return null;
            }
            return new b(a.this.b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.a).D();
            }
        }

        public void H(Bundle bundle) {
            androidx.appcompat.view.menu.g gVarA;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.g gVarA2;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.f = true;
                int size = this.d.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    e eVar = (e) this.d.get(i2);
                    if ((eVar instanceof g) && (gVarA2 = ((g) eVar).a()) != null && gVarA2.getItemId() == i) {
                        I(gVarA2);
                        break;
                    }
                    i2++;
                }
                this.f = false;
                G();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.d.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    e eVar2 = (e) this.d.get(i3);
                    if ((eVar2 instanceof g) && (gVarA = ((g) eVar2).a()) != null && (actionView = gVarA.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(gVarA.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void I(androidx.appcompat.view.menu.g gVar) {
            if (this.e == gVar || !gVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.g gVar2 = this.e;
            if (gVar2 != null) {
                gVar2.setChecked(false);
            }
            this.e = gVar;
            gVar.setChecked(true);
        }

        public void J(boolean z) {
            this.f = z;
        }

        public void K() {
            G();
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return this.d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemViewType(int i) {
            e eVar = (e) this.d.get(i);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }
    }

    private static class d implements e {
        d() {
        }
    }

    private interface e {
    }

    private static class f implements e {
        private final int a;
        private final int b;

        public f(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    private static class g implements e {
        private final androidx.appcompat.view.menu.g a;
        boolean b;

        g(androidx.appcompat.view.menu.g gVar) {
            this.a = gVar;
        }

        public androidx.appcompat.view.menu.g a() {
            return this.a;
        }
    }

    private class h extends v {
        h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.v, ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            x2.r0(X2.e.a(a.this.f.C(), 0, false));
        }
    }

    private static class i extends l {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(YC5.design_navigation_item, viewGroup, false));
            this.a.setOnClickListener(onClickListener);
        }
    }

    private static class j extends l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(YC5.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class k extends l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(YC5.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class l extends RecyclerView.C {
        public l(View view) {
            super(view);
        }
    }

    private void W() {
        int i2 = (this.b.getChildCount() == 0 && this.x) ? this.z : 0;
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    public int A() {
        return this.u;
    }

    public View B(int i2) {
        View viewInflate = this.g.inflate(i2, (ViewGroup) this.b, false);
        b(viewInflate);
        return viewInflate;
    }

    public void C(boolean z) {
        if (this.x != z) {
            this.x = z;
            W();
        }
    }

    public void D(androidx.appcompat.view.menu.g gVar) {
        this.f.I(gVar);
    }

    public void E(int i2) {
        this.t = i2;
        i(false);
    }

    public void F(int i2) {
        this.s = i2;
        i(false);
    }

    public void G(int i2) {
        this.e = i2;
    }

    public void H(Drawable drawable) {
        this.m = drawable;
        i(false);
    }

    public void I(RippleDrawable rippleDrawable) {
        this.n = rippleDrawable;
        i(false);
    }

    public void J(int i2) {
        this.o = i2;
        i(false);
    }

    public void K(int i2) {
        this.q = i2;
        i(false);
    }

    public void L(int i2) {
        if (this.r != i2) {
            this.r = i2;
            this.w = true;
            i(false);
        }
    }

    public void M(ColorStateList colorStateList) {
        this.l = colorStateList;
        i(false);
    }

    public void N(int i2) {
        this.y = i2;
        i(false);
    }

    public void O(int i2) {
        this.j = i2;
        i(false);
    }

    public void P(ColorStateList colorStateList) {
        this.k = colorStateList;
        i(false);
    }

    public void Q(int i2) {
        this.p = i2;
        i(false);
    }

    public void R(int i2) {
        this.B = i2;
        NavigationMenuView navigationMenuView = this.a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    public void S(ColorStateList colorStateList) {
        this.i = colorStateList;
        i(false);
    }

    public void T(int i2) {
        this.u = i2;
        i(false);
    }

    public void U(int i2) {
        this.h = i2;
        i(false);
    }

    public void V(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.J(z);
        }
    }

    public void b(View view) {
        this.b.addView(view);
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
        j.a aVar = this.c;
        if (aVar != null) {
            aVar.c(eVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean d(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void f(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f.H(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(m mVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public int getId() {
        return this.e;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable h() {
        Bundle bundle = new Bundle();
        if (this.a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.A());
        }
        if (this.b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.K();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean j() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean k(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void l(Context context, androidx.appcompat.view.menu.e eVar) {
        this.g = LayoutInflater.from(context);
        this.d = eVar;
        this.A = context.getResources().getDimensionPixelOffset(AbstractC12799fB5.design_navigation_separator_vertical_padding);
    }

    public void m(O98 o98) {
        int iM = o98.m();
        if (this.z != iM) {
            this.z = iM;
            W();
        }
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, o98.j());
        AbstractC12990fW7.g(this.b, o98);
    }

    public androidx.appcompat.view.menu.g n() {
        return this.f.B();
    }

    public int o() {
        return this.t;
    }

    public int p() {
        return this.s;
    }

    public int q() {
        return this.b.getChildCount();
    }

    public Drawable r() {
        return this.m;
    }

    public int s() {
        return this.o;
    }

    public int t() {
        return this.q;
    }

    public int u() {
        return this.y;
    }

    public ColorStateList v() {
        return this.k;
    }

    public ColorStateList w() {
        return this.l;
    }

    public int x() {
        return this.p;
    }

    public androidx.appcompat.view.menu.k y(ViewGroup viewGroup) {
        if (this.a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.g.inflate(YC5.design_navigation_menu, viewGroup, false);
            this.a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.a));
            if (this.f == null) {
                this.f = new c();
            }
            int i2 = this.B;
            if (i2 != -1) {
                this.a.setOverScrollMode(i2);
            }
            this.b = (LinearLayout) this.g.inflate(YC5.design_navigation_item_header, (ViewGroup) this.a, false);
            this.a.setAdapter(this.f);
        }
        return this.a;
    }

    public int z() {
        return this.v;
    }
}
