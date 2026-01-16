package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class t {
    protected final RecyclerView.p a;
    private int b;
    final Rect c;

    class a extends t {
        a(RecyclerView.p pVar) {
            super(pVar, null);
        }

        @Override // androidx.recyclerview.widget.t
        public int d(View view) {
            return this.a.U(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.a.T(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.a.S(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int g(View view) {
            return this.a.R(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int h() {
            return this.a.p0();
        }

        @Override // androidx.recyclerview.widget.t
        public int i() {
            return this.a.p0() - this.a.g0();
        }

        @Override // androidx.recyclerview.widget.t
        public int j() {
            return this.a.g0();
        }

        @Override // androidx.recyclerview.widget.t
        public int k() {
            return this.a.q0();
        }

        @Override // androidx.recyclerview.widget.t
        public int l() {
            return this.a.Y();
        }

        @Override // androidx.recyclerview.widget.t
        public int m() {
            return this.a.f0();
        }

        @Override // androidx.recyclerview.widget.t
        public int n() {
            return (this.a.p0() - this.a.f0()) - this.a.g0();
        }

        @Override // androidx.recyclerview.widget.t
        public int p(View view) {
            this.a.o0(view, true, this.c);
            return this.c.right;
        }

        @Override // androidx.recyclerview.widget.t
        public int q(View view) {
            this.a.o0(view, true, this.c);
            return this.c.left;
        }

        @Override // androidx.recyclerview.widget.t
        public void r(int i) {
            this.a.F0(i);
        }
    }

    class b extends t {
        b(RecyclerView.p pVar) {
            super(pVar, null);
        }

        @Override // androidx.recyclerview.widget.t
        public int d(View view) {
            return this.a.P(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.a.S(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.a.T(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int g(View view) {
            return this.a.V(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int h() {
            return this.a.X();
        }

        @Override // androidx.recyclerview.widget.t
        public int i() {
            return this.a.X() - this.a.e0();
        }

        @Override // androidx.recyclerview.widget.t
        public int j() {
            return this.a.e0();
        }

        @Override // androidx.recyclerview.widget.t
        public int k() {
            return this.a.Y();
        }

        @Override // androidx.recyclerview.widget.t
        public int l() {
            return this.a.q0();
        }

        @Override // androidx.recyclerview.widget.t
        public int m() {
            return this.a.h0();
        }

        @Override // androidx.recyclerview.widget.t
        public int n() {
            return (this.a.X() - this.a.h0()) - this.a.e0();
        }

        @Override // androidx.recyclerview.widget.t
        public int p(View view) {
            this.a.o0(view, true, this.c);
            return this.c.bottom;
        }

        @Override // androidx.recyclerview.widget.t
        public int q(View view) {
            this.a.o0(view, true, this.c);
            return this.c.top;
        }

        @Override // androidx.recyclerview.widget.t
        public void r(int i) {
            this.a.G0(i);
        }
    }

    /* synthetic */ t(RecyclerView.p pVar, a aVar) {
        this(pVar);
    }

    public static t a(RecyclerView.p pVar) {
        return new a(pVar);
    }

    public static t b(RecyclerView.p pVar, int i) {
        if (i == 0) {
            return a(pVar);
        }
        if (i == 1) {
            return c(pVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static t c(RecyclerView.p pVar) {
        return new b(pVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return n() - this.b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i);

    public void s() {
        this.b = n();
    }

    private t(RecyclerView.p pVar) {
        this.b = RecyclerView.UNDEFINED_DURATION;
        this.c = new Rect();
        this.a = pVar;
    }
}
