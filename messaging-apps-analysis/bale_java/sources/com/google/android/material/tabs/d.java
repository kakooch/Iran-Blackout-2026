package com.google.android.material.tabs;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class d {
    private final TabLayout a;
    private final ViewPager2 b;
    private final boolean c;
    private final boolean d;
    private final b e;
    private RecyclerView.h f;
    private boolean g;
    private c h;
    private TabLayout.d i;
    private RecyclerView.j j;

    private class a extends RecyclerView.j {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void a() throws Resources.NotFoundException {
            d.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void b(int i, int i2) throws Resources.NotFoundException {
            d.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void c(int i, int i2, Object obj) throws Resources.NotFoundException {
            d.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2) throws Resources.NotFoundException {
            d.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void e(int i, int i2, int i3) throws Resources.NotFoundException {
            d.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void f(int i, int i2) throws Resources.NotFoundException {
            d.this.c();
        }
    }

    public interface b {
        void a(TabLayout.g gVar, int i);
    }

    private static class c extends ViewPager2.i {
        private final WeakReference a;
        private int b;
        private int c;

        c(TabLayout tabLayout) {
            this.a = new WeakReference(tabLayout);
            d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void b(int i, float f, int i2) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                tabLayout.setScrollPosition(i, f, i3 != 2 || this.b == 1, (i3 == 2 && this.b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.c;
            tabLayout.J(tabLayout.y(i), i2 == 0 || (i2 == 2 && this.b == 0));
        }

        void d() {
            this.c = 0;
            this.b = 0;
        }
    }

    /* renamed from: com.google.android.material.tabs.d$d, reason: collision with other inner class name */
    private static class C0188d implements TabLayout.d {
        private final ViewPager2 a;
        private final boolean b;

        C0188d(ViewPager2 viewPager2, boolean z) {
            this.a = viewPager2;
            this.b = z;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            this.a.setCurrentItem(gVar.h(), this.b);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    public d(TabLayout tabLayout, ViewPager2 viewPager2, b bVar) {
        this(tabLayout, viewPager2, true, bVar);
    }

    public void a() {
        if (this.g) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        RecyclerView.h adapter = this.b.getAdapter();
        this.f = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        this.g = true;
        c cVar = new c(this.a);
        this.h = cVar;
        this.b.k(cVar);
        C0188d c0188d = new C0188d(this.b, this.d);
        this.i = c0188d;
        this.a.d(c0188d);
        if (this.c) {
            a aVar = new a();
            this.j = aVar;
            this.f.registerAdapterDataObserver(aVar);
        }
        c();
        this.a.setScrollPosition(this.b.getCurrentItem(), 0.0f, true);
    }

    public void b() {
        RecyclerView.h hVar;
        if (this.c && (hVar = this.f) != null) {
            hVar.unregisterAdapterDataObserver(this.j);
            this.j = null;
        }
        this.a.G(this.i);
        this.b.r(this.h);
        this.i = null;
        this.h = null;
        this.f = null;
        this.g = false;
    }

    void c() throws Resources.NotFoundException {
        this.a.E();
        RecyclerView.h hVar = this.f;
        if (hVar != null) {
            int itemCount = hVar.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                TabLayout.g gVarB = this.a.B();
                this.e.a(gVarB, i);
                this.a.g(gVarB, false);
            }
            if (itemCount > 0) {
                int iMin = Math.min(this.b.getCurrentItem(), this.a.getTabCount() - 1);
                if (iMin != this.a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.a;
                    tabLayout.I(tabLayout.y(iMin));
                }
            }
        }
    }

    public d(TabLayout tabLayout, ViewPager2 viewPager2, boolean z, b bVar) {
        this(tabLayout, viewPager2, z, true, bVar);
    }

    public d(TabLayout tabLayout, ViewPager2 viewPager2, boolean z, boolean z2, b bVar) {
        this.a = tabLayout;
        this.b = viewPager2;
        this.c = z;
        this.d = z2;
        this.e = bVar;
    }
}
