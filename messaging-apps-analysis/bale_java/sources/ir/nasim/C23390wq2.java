package ir.nasim;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.PopupMenu;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import java.util.Arrays;

/* renamed from: ir.nasim.wq2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C23390wq2 extends ActionMode {
    private final Context a;
    private final ActionMode.Callback2 b;
    private final Menu c;
    private final Rect d;
    private final Rect e;
    private final Rect f;
    private final int[] g;
    private final int[] h;
    private final int[] i;
    private final Rect j;
    private final Rect k;
    private final Rect l;
    private final View m;
    private final Point n;
    private final int o;
    private final Runnable p = new a();
    private final Runnable q = new b();
    private ir.nasim.tgwidgets.editor.ui.ActionBar.f r;
    private c s;

    /* renamed from: ir.nasim.wq2$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C23390wq2.this.g()) {
                C23390wq2.this.s.d(false);
                C23390wq2.this.s.g();
            }
        }
    }

    /* renamed from: ir.nasim.wq2$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C23390wq2.this.g()) {
                C23390wq2.this.s.c(false);
                C23390wq2.this.s.g();
            }
        }
    }

    /* renamed from: ir.nasim.wq2$c */
    private static final class c {
        private final ir.nasim.tgwidgets.editor.ui.ActionBar.f a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e = true;
        private boolean f;
        private long g;

        public c(ir.nasim.tgwidgets.editor.ui.ActionBar.f fVar) {
            this.a = fVar;
        }

        public void a() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = true;
            this.f = true;
        }

        public void b() {
            this.f = false;
            this.a.r();
        }

        public void c(boolean z) {
            this.b = z;
        }

        public void d(boolean z) {
            boolean z2 = System.currentTimeMillis() - this.g > 500;
            if (!z || z2) {
                this.c = z;
            }
        }

        public void e(boolean z) {
            this.d = z;
        }

        public void f(boolean z) {
            this.e = z;
        }

        public void g() {
            if (this.f) {
                if (this.b || this.c || this.d || !this.e) {
                    this.a.v();
                } else {
                    this.a.D();
                    this.g = System.currentTimeMillis();
                }
            }
        }
    }

    public C23390wq2(Context context, ActionMode.Callback2 callback2, View view, ir.nasim.tgwidgets.editor.ui.ActionBar.f fVar) {
        this.a = context;
        this.b = callback2;
        PopupMenu popupMenu = new PopupMenu(context, null);
        this.c = popupMenu.getMenu();
        setType(1);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: ir.nasim.uq2
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.a.h(menuItem);
            }
        });
        this.d = new Rect();
        this.e = new Rect();
        this.f = new Rect();
        int[] iArr = new int[2];
        this.g = iArr;
        this.h = new int[2];
        this.i = new int[2];
        this.j = new Rect();
        this.k = new Rect();
        this.l = new Rect();
        this.m = view;
        view.getLocationOnScreen(iArr);
        this.o = AbstractC21455b.F(20.0f);
        this.n = new Point();
        l(fVar);
    }

    private static boolean e(Rect rect, Rect rect2) {
        return rect.left <= rect2.right && rect2.left <= rect.right && rect.top <= rect2.bottom && rect2.top <= rect.bottom;
    }

    private boolean f() {
        ((WindowManager) this.a.getSystemService(WindowManager.class)).getDefaultDisplay().getRealSize(this.n);
        Rect rect = this.l;
        Point point = this.n;
        rect.set(0, 0, point.x, point.y);
        return e(this.e, this.l) && e(this.e, this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.m.getWindowVisibility() == 0 && this.m.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean h(MenuItem menuItem) {
        return this.b.onActionItemClicked(this, menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean i(MenuItem menuItem) {
        return this.b.onActionItemClicked(this, menuItem);
    }

    private void j() {
        this.e.set(this.d);
        ViewParent parent = this.m.getParent();
        if (parent instanceof ViewGroup) {
            parent.getChildVisibleRect(this.m, this.e, null);
            Rect rect = this.e;
            int[] iArr = this.i;
            rect.offset(iArr[0], iArr[1]);
        } else {
            Rect rect2 = this.e;
            int[] iArr2 = this.g;
            rect2.offset(iArr2[0], iArr2[1]);
        }
        if (f()) {
            this.s.e(false);
            Rect rect3 = this.e;
            rect3.set(Math.max(rect3.left, this.j.left), Math.max(this.e.top, this.j.top), Math.min(this.e.right, this.j.right), Math.min(this.e.bottom, this.j.bottom + this.o));
            if (!this.e.equals(this.f)) {
                this.m.removeCallbacks(this.p);
                this.s.d(true);
                this.m.postDelayed(this.p, 50L);
                this.r.A(this.e);
                this.r.F();
            }
        } else {
            this.s.e(true);
            this.e.setEmpty();
        }
        this.s.g();
        this.f.set(this.e);
    }

    private void k() {
        this.r.r();
        this.s.b();
        this.m.removeCallbacks(this.p);
        this.m.removeCallbacks(this.q);
    }

    private void l(ir.nasim.tgwidgets.editor.ui.ActionBar.f fVar) {
        ir.nasim.tgwidgets.editor.ui.ActionBar.f fVarC = fVar.B(this.c).C(new MenuItem.OnMenuItemClickListener() { // from class: ir.nasim.vq2
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.a.i(menuItem);
            }
        });
        this.r = fVarC;
        c cVar = new c(fVarC);
        this.s = cVar;
        cVar.a();
    }

    @Override // android.view.ActionMode
    public void finish() {
        k();
        this.b.onDestroyActionMode(this);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return null;
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return this.c;
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new MenuInflater(this.a);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return null;
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return null;
    }

    @Override // android.view.ActionMode
    public void hide(long j) {
        if (j == -1) {
            j = ViewConfiguration.getDefaultActionModeHideDuration();
        }
        long jMin = Math.min(3000L, j);
        this.m.removeCallbacks(this.q);
        if (jMin <= 0) {
            this.q.run();
            return;
        }
        this.s.c(true);
        this.s.g();
        this.m.postDelayed(this.q, jMin);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.onPrepareActionMode(this, this.c);
        invalidateContentRect();
    }

    @Override // android.view.ActionMode
    public void invalidateContentRect() {
        this.b.onGetContentRect(this, this.m, this.d);
        Rect rect = this.d;
        if (rect.left == 0 && rect.right == 0) {
            rect.left = 1;
            rect.right = 1;
        }
        j();
    }

    public void m() {
        this.m.getLocationOnScreen(this.g);
        this.m.getRootView().getLocationOnScreen(this.i);
        this.m.getGlobalVisibleRect(this.j);
        Rect rect = this.j;
        int[] iArr = this.i;
        rect.offset(iArr[0], iArr[1]);
        if (Arrays.equals(this.g, this.h) && this.j.equals(this.k)) {
            return;
        }
        j();
        int[] iArr2 = this.h;
        int[] iArr3 = this.g;
        iArr2[0] = iArr3[0];
        iArr2[1] = iArr3[1];
        this.k.set(this.j);
    }

    @Override // android.view.ActionMode
    public void onWindowFocusChanged(boolean z) {
        this.s.f(z);
        this.s.g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
    }
}
