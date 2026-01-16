package ir.nasim;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Size;
import android.view.View;
import android.widget.CompoundButton;

/* loaded from: classes5.dex */
public final class NY {
    public static final a O = new a(null);
    public static final int P = 8;
    public int A;
    public boolean B;
    public String C;
    public CompoundButton.OnCheckedChangeListener D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public String I;
    public int J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public Context a;
    public boolean b;
    public int c;
    public Size d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public CharSequence i;
    public int j;
    public CharSequence k;
    public int l;
    public String m;
    public String n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;
    public View.OnClickListener r;
    public DialogInterface.OnDismissListener s;
    public DialogInterface.OnCancelListener t;
    public String u;
    public String v;
    public String w;
    public View x;
    public boolean y;
    public int z;

    public static final class a {
        private a() {
        }

        public final int a() {
            return 4;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public NY(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.f = -1;
        this.g = -1;
        this.p = true;
        this.y = true;
        this.z = -1;
        this.A = -1;
        this.E = true;
        this.F = true;
        this.J = 20;
        this.L = true;
        this.M = 100;
    }

    public final NY A(int i) {
        this.i = this.a.getResources().getString(i);
        return this;
    }

    public final NY B(CharSequence charSequence) {
        this.i = charSequence;
        return this;
    }

    public final NY C(int i) {
        this.v = this.a.getString(i);
        return this;
    }

    public final NY D(String str) {
        this.v = str;
        return this;
    }

    public final NY E(int i) {
        this.j = i;
        return this;
    }

    public final NY F(boolean z) {
        this.b = z;
        return this;
    }

    public final MY a() {
        return new MY(this, true);
    }

    public final MY b(boolean z) {
        return new MY(this, z);
    }

    public final NY c(boolean z) {
        this.F = z;
        return this;
    }

    public final NY d(boolean z) {
        this.G = z;
        return this;
    }

    public final NY e(boolean z) {
        this.y = z;
        return this;
    }

    public final NY f(boolean z) {
        this.o = z;
        return this;
    }

    public final NY g(String str, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.C = str;
        this.D = onCheckedChangeListener;
        return this;
    }

    public final NY h(int i) {
        this.k = this.a.getResources().getString(i);
        return this;
    }

    public final NY i(CharSequence charSequence) {
        this.k = charSequence;
        return this;
    }

    public final NY j(boolean z) {
        this.E = z;
        return this;
    }

    public final NY k(int i) {
        this.l = i;
        return this;
    }

    public final NY l(boolean z) {
        this.B = z;
        return this;
    }

    public final NY m(int i) {
        this.J = i;
        return this;
    }

    public final NY n(int i) {
        this.w = this.a.getString(i);
        return this;
    }

    public final NY o(String str) {
        this.w = str;
        return this;
    }

    public final NY p(int i) {
        this.c = i;
        return this;
    }

    public final NY q(int i) {
        return r(i, i);
    }

    public final NY r(int i, int i2) {
        this.d = new Size(i, i2);
        return this;
    }

    public final NY s(View.OnClickListener onClickListener) {
        this.r = onClickListener;
        return this;
    }

    public final NY t(int i) {
        this.n = this.a.getResources().getString(i);
        return this;
    }

    public final NY u(String str) {
        this.n = str;
        return this;
    }

    public final NY v(View.OnClickListener onClickListener) {
        this.q = onClickListener;
        return this;
    }

    public final NY w(int i) {
        this.m = this.a.getResources().getString(i);
        return this;
    }

    public final NY x(String str) {
        this.m = str;
        return this;
    }

    public final NY y(int i) {
        this.z = i;
        return this;
    }

    public final NY z(String str) {
        this.I = str;
        return this;
    }
}
