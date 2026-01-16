package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ScrollingTabContainerView;

/* loaded from: classes.dex */
public interface PB1 {
    boolean a();

    boolean b();

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    void g(int i);

    Context getContext();

    CharSequence getTitle();

    Menu h();

    int i();

    C23798xX7 j(int i, long j);

    ViewGroup k();

    void l(boolean z);

    void m();

    void n(boolean z);

    void o();

    void p(ScrollingTabContainerView scrollingTabContainerView);

    void q(int i);

    void r(j.a aVar, e.a aVar2);

    int s();

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setMenu(Menu menu, j.a aVar);

    void setMenuPrepared();

    void setVisibility(int i);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t();
}
