package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC8375Vr7;
import ir.nasim.C20480s5;
import ir.nasim.InterfaceC13418gB6;
import ir.nasim.J5;
import ir.nasim.PC5;
import java.util.ArrayList;

/* loaded from: classes.dex */
class ActionMenuPresenter extends androidx.appcompat.view.menu.a implements J5.a {
    c A;
    private b B;
    final f D;
    int G;
    d k;
    private Drawable l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private final SparseBooleanArray x;
    e y;
    a z;

    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
        }
    }

    private class a extends androidx.appcompat.view.menu.i {
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false, AbstractC15790kA5.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.g) mVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.k;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).i : view2);
            }
            j(ActionMenuPresenter.this.D);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.z = null;
            actionMenuPresenter.G = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public InterfaceC13418gB6 a() {
            a aVar = ActionMenuPresenter.this.z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    private class c implements Runnable {
        private e a;

        public c(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).c != null) {
                ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).i;
            if (view != null && view.getWindowToken() != null && this.a.m()) {
                ActionMenuPresenter.this.y = this.a;
            }
            ActionMenuPresenter.this.A = null;
        }
    }

    private class d extends AppCompatImageView implements ActionMenuView.a {

        class a extends t {
            final /* synthetic */ ActionMenuPresenter j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.j = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.t
            public InterfaceC13418gB6 b() {
                e eVar = ActionMenuPresenter.this.y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.t
            public boolean c() {
                ActionMenuPresenter.this.N();
                return true;
            }

            @Override // androidx.appcompat.widget.t
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.A != null) {
                    return false;
                }
                actionMenuPresenter.E();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, AbstractC15790kA5.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            AbstractC8375Vr7.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.N();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                AbstractC21710u02.f(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    private class e extends androidx.appcompat.view.menu.i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z) {
            super(context, eVar, view, z, AbstractC15790kA5.actionOverflowMenuStyle);
            h(8388613);
            j(ActionMenuPresenter.this.D);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            if (((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).c != null) {
                ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).c.close();
            }
            ActionMenuPresenter.this.y = null;
            super.e();
        }
    }

    private class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
            if (eVar instanceof androidx.appcompat.view.menu.m) {
                eVar.F().e(false);
            }
            j.a aVarP = ActionMenuPresenter.this.p();
            if (aVarP != null) {
                aVarP.c(eVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).c) {
                return false;
            }
            ActionMenuPresenter.this.G = ((androidx.appcompat.view.menu.m) eVar).getItem().getItemId();
            j.a aVarP = ActionMenuPresenter.this.p();
            if (aVarP != null) {
                return aVarP.d(eVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, PC5.abc_action_menu_layout, PC5.abc_action_menu_item_layout);
        this.x = new SparseBooleanArray();
        this.D = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View C(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean B() {
        return E() | F();
    }

    public Drawable D() {
        d dVar = this.k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.m) {
            return this.l;
        }
        return null;
    }

    public boolean E() {
        Object obj;
        c cVar = this.A;
        if (cVar != null && (obj = this.i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.A = null;
            return true;
        }
        e eVar = this.y;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean F() {
        a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean G() {
        return this.A != null || H();
    }

    public boolean H() {
        e eVar = this.y;
        return eVar != null && eVar.d();
    }

    public void I(Configuration configuration) {
        if (!this.s) {
            this.r = C20480s5.b(this.b).d();
        }
        androidx.appcompat.view.menu.e eVar = this.c;
        if (eVar != null) {
            eVar.M(true);
        }
    }

    public void J(boolean z) {
        this.v = z;
    }

    public void K(ActionMenuView actionMenuView) {
        this.i = actionMenuView;
        actionMenuView.a(this.c);
    }

    public void L(Drawable drawable) {
        d dVar = this.k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.m = true;
            this.l = drawable;
        }
    }

    public void M(boolean z) {
        this.n = z;
        this.o = true;
    }

    public boolean N() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.n || H() || (eVar = this.c) == null || this.i == null || this.A != null || eVar.B().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.b, this.c, this.k, true));
        this.A = cVar;
        ((View) this.i).post(cVar);
        return true;
    }

    @Override // ir.nasim.J5.a
    public void a(boolean z) {
        if (z) {
            super.g(null);
            return;
        }
        androidx.appcompat.view.menu.e eVar = this.c;
        if (eVar != null) {
            eVar.e(false);
        }
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
        B();
        super.c(eVar, z);
    }

    @Override // androidx.appcompat.view.menu.j
    public void f(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).a) > 0 && (menuItemFindItem = this.c.findItem(i)) != null) {
            g((androidx.appcompat.view.menu.m) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean g(androidx.appcompat.view.menu.m mVar) {
        boolean z = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.m mVar2 = mVar;
        while (mVar2.i0() != this.c) {
            mVar2 = (androidx.appcompat.view.menu.m) mVar2.i0();
        }
        View viewC = C(mVar2.getItem());
        if (viewC == null) {
            return false;
        }
        this.G = mVar.getItem().getItemId();
        int size = mVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = mVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        a aVar = new a(this.b, mVar, viewC);
        this.z = aVar;
        aVar.g(z);
        this.z.k();
        super.g(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable h() {
        SavedState savedState = new SavedState();
        savedState.a = this.G;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void i(boolean z) {
        super.i(z);
        ((View) this.i).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.c;
        boolean z2 = false;
        if (eVar != null) {
            ArrayList arrayListU = eVar.u();
            int size = arrayListU.size();
            for (int i = 0; i < size; i++) {
                J5 j5A = ((androidx.appcompat.view.menu.g) arrayListU.get(i)).a();
                if (j5A != null) {
                    j5A.h(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.c;
        ArrayList arrayListB = eVar2 != null ? eVar2.B() : null;
        if (this.n && arrayListB != null) {
            int size2 = arrayListB.size();
            if (size2 == 1) {
                z2 = !((androidx.appcompat.view.menu.g) arrayListB.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.k == null) {
                this.k = new d(this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.k.getParent();
            if (viewGroup != this.i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                actionMenuView.addView(this.k, actionMenuView.F());
            }
        } else {
            d dVar = this.k;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.k);
                }
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.j
    public boolean j() {
        ArrayList arrayListG;
        int size;
        int i;
        int iL;
        boolean z;
        int i2;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.e eVar = actionMenuPresenter.c;
        View view = null;
        ?? r3 = 0;
        if (eVar != null) {
            arrayListG = eVar.G();
            size = arrayListG.size();
        } else {
            arrayListG = null;
            size = 0;
        }
        int i3 = actionMenuPresenter.r;
        int i4 = actionMenuPresenter.q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.i;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) arrayListG.get(i7);
            if (gVar.o()) {
                i5++;
            } else if (gVar.n()) {
                i6++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.v && gVar.isActionViewExpanded()) {
                i3 = 0;
            }
        }
        if (actionMenuPresenter.n && (z2 || i6 + i5 > i3)) {
            i3--;
        }
        int i8 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.t) {
            int i9 = actionMenuPresenter.w;
            iL = i4 / i9;
            i = i9 + ((i4 % i9) / iL);
        } else {
            i = 0;
            iL = 0;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            androidx.appcompat.view.menu.g gVar2 = (androidx.appcompat.view.menu.g) arrayListG.get(i10);
            if (gVar2.o()) {
                View viewQ = actionMenuPresenter.q(gVar2, view, viewGroup);
                if (actionMenuPresenter.t) {
                    iL -= ActionMenuView.L(viewQ, i, iL, iMakeMeasureSpec, r3);
                } else {
                    viewQ.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewQ.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                z = r3;
                i2 = size;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i8 > 0 || z3) && i4 > 0 && (!actionMenuPresenter.t || iL > 0);
                boolean z5 = z4;
                i2 = size;
                if (z4) {
                    View viewQ2 = actionMenuPresenter.q(gVar2, null, viewGroup);
                    if (actionMenuPresenter.t) {
                        int iL2 = ActionMenuView.L(viewQ2, i, iL, iMakeMeasureSpec, 0);
                        iL -= iL2;
                        if (iL2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewQ2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z6 = z5;
                    int measuredWidth2 = viewQ2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z4 = z6 & (!actionMenuPresenter.t ? i4 + i11 <= 0 : i4 < 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i12 = 0; i12 < i10; i12++) {
                        androidx.appcompat.view.menu.g gVar3 = (androidx.appcompat.view.menu.g) arrayListG.get(i12);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i8++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z4) {
                    i8--;
                }
                gVar2.u(z4);
                z = false;
            } else {
                z = r3;
                i2 = size;
                gVar2.u(z);
            }
            i10++;
            r3 = z;
            size = i2;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void l(Context context, androidx.appcompat.view.menu.e eVar) {
        super.l(context, eVar);
        Resources resources = context.getResources();
        C20480s5 c20480s5B = C20480s5.b(context);
        if (!this.o) {
            this.n = c20480s5B.h();
        }
        if (!this.u) {
            this.p = c20480s5B.c();
        }
        if (!this.s) {
            this.r = c20480s5B.d();
        }
        int measuredWidth = this.p;
        if (this.n) {
            if (this.k == null) {
                d dVar = new d(this.a);
                this.k = dVar;
                if (this.m) {
                    dVar.setImageDrawable(this.l);
                    this.l = null;
                    this.m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.k.getMeasuredWidth();
        } else {
            this.k = null;
        }
        this.q = measuredWidth;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a
    public void m(androidx.appcompat.view.menu.g gVar, k.a aVar) {
        aVar.c(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.i);
        if (this.B == null) {
            this.B = new b();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean o(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.k) {
            return false;
        }
        return super.o(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.a
    public View q(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.q(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.k r(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.k kVar = this.i;
        androidx.appcompat.view.menu.k kVarR = super.r(viewGroup);
        if (kVar != kVarR) {
            ((ActionMenuView) kVarR).setPresenter(this);
        }
        return kVarR;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean t(int i, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }
}
