package ir.nasim;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.oa8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18391oa8 {
    private final e a;

    /* renamed from: ir.nasim.oa8$a */
    private static class a extends e {
        protected final Window a;
        private final C21877uH6 b;

        a(Window window, C21877uH6 c21877uH6) {
            this.a = window;
            this.b = c21877uH6;
        }

        private void f(int i) {
            if (i == 1) {
                g(4);
            } else if (i == 2) {
                g(2);
            } else {
                if (i != 8) {
                    return;
                }
                this.b.a();
            }
        }

        private void i(int i) {
            if (i == 1) {
                j(4);
                k(1024);
            } else if (i == 2) {
                j(2);
            } else {
                if (i != 8) {
                    return;
                }
                this.b.b();
            }
        }

        @Override // ir.nasim.C18391oa8.e
        void a(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    f(i2);
                }
            }
        }

        @Override // ir.nasim.C18391oa8.e
        void d(int i) {
            if (i == 0) {
                j(6144);
                return;
            }
            if (i == 1) {
                j(4096);
                g(2048);
            } else {
                if (i != 2) {
                    return;
                }
                j(2048);
                g(4096);
            }
        }

        @Override // ir.nasim.C18391oa8.e
        void e(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    i(i2);
                }
            }
        }

        protected void g(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        protected void h(int i) {
            this.a.addFlags(i);
        }

        protected void j(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        protected void k(int i) {
            this.a.clearFlags(i);
        }
    }

    /* renamed from: ir.nasim.oa8$b */
    private static class b extends a {
        b(Window window, C21877uH6 c21877uH6) {
            super(window, c21877uH6);
        }

        @Override // ir.nasim.C18391oa8.e
        public void c(boolean z) {
            if (!z) {
                j(8192);
                return;
            }
            k(67108864);
            h(RecyclerView.UNDEFINED_DURATION);
            g(8192);
        }
    }

    /* renamed from: ir.nasim.oa8$c */
    private static class c extends b {
        c(Window window, C21877uH6 c21877uH6) {
            super(window, c21877uH6);
        }

        @Override // ir.nasim.C18391oa8.e
        public void b(boolean z) {
            if (!z) {
                j(16);
                return;
            }
            k(134217728);
            h(RecyclerView.UNDEFINED_DURATION);
            g(16);
        }
    }

    public C18391oa8(Window window, View view) {
        C21877uH6 c21877uH6 = new C21877uH6(view);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.a = new d(window, this, c21877uH6);
        } else if (i >= 26) {
            this.a = new c(window, c21877uH6);
        } else {
            this.a = new b(window, c21877uH6);
        }
    }

    public void a(int i) {
        this.a.a(i);
    }

    public void b(boolean z) {
        this.a.b(z);
    }

    public void c(boolean z) {
        this.a.c(z);
    }

    public void d(int i) {
        this.a.d(i);
    }

    public void e(int i) {
        this.a.e(i);
    }

    /* renamed from: ir.nasim.oa8$d */
    private static class d extends e {
        final C18391oa8 a;
        final WindowInsetsController b;
        final C21877uH6 c;
        private final C24792zC6 d;
        protected Window e;

        d(Window window, C18391oa8 c18391oa8, C21877uH6 c21877uH6) {
            this(window.getInsetsController(), c18391oa8, c21877uH6);
            this.e = window;
        }

        @Override // ir.nasim.C18391oa8.e
        void a(int i) {
            if ((i & 8) != 0) {
                this.c.a();
            }
            this.b.hide(i & (-9));
        }

        @Override // ir.nasim.C18391oa8.e
        public void b(boolean z) {
            if (z) {
                if (this.e != null) {
                    f(16);
                }
                this.b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.e != null) {
                    g(16);
                }
                this.b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // ir.nasim.C18391oa8.e
        public void c(boolean z) {
            if (z) {
                if (this.e != null) {
                    f(8192);
                }
                this.b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.e != null) {
                    g(8192);
                }
                this.b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // ir.nasim.C18391oa8.e
        void d(int i) {
            this.b.setSystemBarsBehavior(i);
        }

        @Override // ir.nasim.C18391oa8.e
        void e(int i) {
            if ((i & 8) != 0) {
                this.c.b();
            }
            this.b.show(i & (-9));
        }

        protected void f(int i) {
            View decorView = this.e.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        protected void g(int i) {
            View decorView = this.e.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        d(WindowInsetsController windowInsetsController, C18391oa8 c18391oa8, C21877uH6 c21877uH6) {
            this.d = new C24792zC6();
            this.b = windowInsetsController;
            this.a = c18391oa8;
            this.c = c21877uH6;
        }
    }

    /* renamed from: ir.nasim.oa8$e */
    private static class e {
        e() {
        }

        abstract void a(int i);

        public abstract void c(boolean z);

        abstract void d(int i);

        abstract void e(int i);

        public void b(boolean z) {
        }
    }
}
