package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import ir.nasim.InterfaceC20475s44;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements InterfaceC20475s44 {
    private static Method A0;
    private InterfaceC20475s44 z0;

    public static class MenuDropDownListView extends s {
        final int n;
        final int o;
        private InterfaceC20475s44 p;
        private MenuItem q;

        static class a {
            static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.n = 21;
                this.o = 22;
            } else {
                this.n = 22;
                this.o = 21;
            }
        }

        @Override // androidx.appcompat.widget.s
        public /* bridge */ /* synthetic */ int d(int i, int i2, int i3, int i4, int i5) {
            return super.d(i, i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.s
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i) {
            return super.e(motionEvent, i);
        }

        @Override // androidx.appcompat.widget.s, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.s, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.s, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.s, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.s, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.d dVar;
            int headersCount;
            int iPointToPosition;
            int i;
            if (this.p != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    dVar = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
                } else {
                    dVar = (androidx.appcompat.view.menu.d) adapter;
                    headersCount = 0;
                }
                androidx.appcompat.view.menu.g item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= dVar.getCount()) ? null : dVar.getItem(i);
                MenuItem menuItem = this.q;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.e eVarB = dVar.b();
                    if (menuItem != null) {
                        this.p.o(eVarB, menuItem);
                    }
                    this.q = item;
                    if (item != null) {
                        this.p.e(eVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.n) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i != this.o) {
                return super.onKeyDown(i, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.d) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.d) adapter).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.s, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(InterfaceC20475s44 interfaceC20475s44) {
            this.p = interfaceC20475s44;
        }

        @Override // androidx.appcompat.widget.s, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static class a {
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    static class b {
        static void a(PopupWindow popupWindow, boolean z) {
            popupWindow.setTouchModal(z);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                A0 = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void R(Object obj) {
        a.a(this.J, (Transition) obj);
    }

    public void S(Object obj) {
        a.b(this.J, (Transition) obj);
    }

    public void T(InterfaceC20475s44 interfaceC20475s44) {
        this.z0 = interfaceC20475s44;
    }

    public void U(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.J, z);
            return;
        }
        Method method = A0;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // ir.nasim.InterfaceC20475s44
    public void e(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        InterfaceC20475s44 interfaceC20475s44 = this.z0;
        if (interfaceC20475s44 != null) {
            interfaceC20475s44.e(eVar, menuItem);
        }
    }

    @Override // ir.nasim.InterfaceC20475s44
    public void o(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        InterfaceC20475s44 interfaceC20475s44 = this.z0;
        if (interfaceC20475s44 != null) {
            interfaceC20475s44.o(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    s s(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}
