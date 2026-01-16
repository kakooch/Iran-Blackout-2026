package ir.nasim.features.media.Actionbar;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.C19406qI3;
import ir.nasim.C3971Dd1;

/* loaded from: classes6.dex */
public abstract class b {
    protected View c;
    protected ActionBarLayout d;
    protected ActionBar e;
    protected int f;
    private boolean a = false;
    protected Dialog b = null;
    protected boolean g = true;
    protected boolean h = false;

    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.b = null;
        }
    }

    public b() {
        this.f = 0;
        this.f = C3971Dd1.c().a();
    }

    protected ActionBar a(Context context) {
        ActionBar actionBar = new ActionBar(context);
        actionBar.setBackgroundColor(-11371101);
        actionBar.setItemsBackgroundColor(-12554860);
        return actionBar;
    }

    public abstract View b(Context context);

    public boolean c() {
        return true;
    }

    public void d() {
        e(true);
    }

    public void e(boolean z) {
        ActionBarLayout actionBarLayout;
        if (this.a || (actionBarLayout = this.d) == null) {
            return;
        }
        actionBarLayout.A(z);
    }

    public Activity f() {
        ActionBarLayout actionBarLayout = this.d;
        if (actionBarLayout != null) {
            return actionBarLayout.y;
        }
        return null;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return true;
    }

    public void i() {
        try {
            Dialog dialog = this.b;
            if (dialog != null && dialog.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
        }
        ActionBar actionBar = this.e;
        if (actionBar != null) {
            actionBar.g();
        }
    }

    public void j(Configuration configuration) {
    }

    protected AnimatorSet k() {
        return null;
    }

    public boolean l() {
        return true;
    }

    public void m() {
        this.a = true;
        ActionBar actionBar = this.e;
        if (actionBar != null) {
            actionBar.setEnabled(false);
        }
    }

    public void n() {
        ActionBar actionBar = this.e;
        if (actionBar != null) {
            actionBar.g();
        }
        try {
            Dialog dialog = this.b;
            if (dialog != null && dialog.isShowing() && c()) {
                this.b.dismiss();
                this.b = null;
            }
        } catch (Exception e) {
            C19406qI3.d("baleMessages", e);
        }
    }

    public void o() {
    }

    protected void p(boolean z) {
    }

    public boolean q(b bVar) {
        ActionBarLayout actionBarLayout = this.d;
        return actionBarLayout != null && actionBarLayout.L(bVar);
    }

    public void r() {
        ActionBarLayout actionBarLayout;
        if (this.a || (actionBarLayout = this.d) == null) {
            return;
        }
        actionBarLayout.O(this);
    }

    protected void s(ActionBarLayout actionBarLayout) {
        if (this.d != actionBarLayout) {
            this.d = actionBarLayout;
            View view = this.c;
            if (view != null) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    try {
                        viewGroup.removeView(this.c);
                    } catch (Exception e) {
                        C19406qI3.d("baleMessages", e);
                    }
                }
                ActionBarLayout actionBarLayout2 = this.d;
                if (actionBarLayout2 != null && actionBarLayout2.getContext() != this.c.getContext()) {
                    this.c = null;
                }
            }
            ActionBar actionBar = this.e;
            if (actionBar != null) {
                ViewGroup viewGroup2 = (ViewGroup) actionBar.getParent();
                if (viewGroup2 != null) {
                    try {
                        viewGroup2.removeView(this.e);
                    } catch (Exception e2) {
                        C19406qI3.d("baleMessages", e2);
                    }
                }
                ActionBarLayout actionBarLayout3 = this.d;
                if (actionBarLayout3 != null && actionBarLayout3.getContext() != this.e.getContext()) {
                    this.e = null;
                }
            }
            ActionBarLayout actionBarLayout4 = this.d;
            if (actionBarLayout4 == null || this.e != null) {
                return;
            }
            ActionBar actionBarA = a(actionBarLayout4.getContext());
            this.e = actionBarA;
            actionBarA.j = this;
        }
    }

    public Dialog t(Dialog dialog) {
        return u(dialog, false);
    }

    public Dialog u(Dialog dialog, boolean z) {
        ActionBarLayout actionBarLayout;
        if (dialog != null && (actionBarLayout = this.d) != null && !actionBarLayout.m && !actionBarLayout.j && (z || !actionBarLayout.y())) {
            try {
                Dialog dialog2 = this.b;
                if (dialog2 != null) {
                    dialog2.dismiss();
                    this.b = null;
                }
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
            try {
                this.b = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.b.setOnDismissListener(new a());
                this.b.show();
                return this.b;
            } catch (Exception e2) {
                C19406qI3.d("baleMessages", e2);
            }
        }
        return null;
    }
}
