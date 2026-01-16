package ir.nasim;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import ir.nasim.H5;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class U17 extends ActionMode {
    final Context a;
    final H5 b;

    public static class a implements H5.a {
        final ActionMode.Callback a;
        final Context b;
        final ArrayList c = new ArrayList();
        final C24792zC6 d = new C24792zC6();

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = (Menu) this.d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            C44 c44 = new C44(this.b, (W17) menu);
            this.d.put(menu, c44);
            return c44;
        }

        @Override // ir.nasim.H5.a
        public boolean a(H5 h5, Menu menu) {
            return this.a.onCreateActionMode(e(h5), f(menu));
        }

        @Override // ir.nasim.H5.a
        public boolean b(H5 h5, Menu menu) {
            return this.a.onPrepareActionMode(e(h5), f(menu));
        }

        @Override // ir.nasim.H5.a
        public boolean c(H5 h5, MenuItem menuItem) {
            return this.a.onActionItemClicked(e(h5), new MenuItemC21752u44(this.b, (Y17) menuItem));
        }

        @Override // ir.nasim.H5.a
        public void d(H5 h5) {
            this.a.onDestroyActionMode(e(h5));
        }

        public ActionMode e(H5 h5) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                U17 u17 = (U17) this.c.get(i);
                if (u17 != null && u17.b == h5) {
                    return u17;
                }
            }
            U17 u172 = new U17(this.b, h5);
            this.c.add(u172);
            return u172;
        }
    }

    public U17(Context context, H5 h5) {
        this.a = context;
        this.b = h5;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new C44(this.a, (W17) this.b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.b.s(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.b.n(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.b.q(i);
    }
}
