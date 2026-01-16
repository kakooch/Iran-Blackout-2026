package ir.nasim.features.media.Actionbar;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14433hu3;
import ir.nasim.C22078ud6;
import ir.nasim.C4658Fz7;
import ir.nasim.C5161Id6;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.JF5;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class ActionBar extends FrameLayout {
    private ImageView a;
    private SimpleTextView b;
    private ActionBarMenu c;
    private boolean d;
    private boolean e;
    private CharSequence f;
    private boolean g;
    protected boolean h;
    protected int i;
    protected ir.nasim.features.media.Actionbar.b j;
    public CopyOnWriteArrayList k;
    private boolean l;
    private boolean m;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActionBar actionBar = ActionBar.this;
            if (actionBar.h) {
                actionBar.b();
                return;
            }
            Iterator it = actionBar.k.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.b(-1);
                }
            }
        }
    }

    public static class b {
        public boolean a() {
            return true;
        }

        public abstract void b(int i);
    }

    public ActionBar(Context context) {
        super(context);
        this.d = true;
        this.e = true;
        this.g = true;
        this.k = new CopyOnWriteArrayList();
        this.l = false;
        this.m = true;
    }

    private void c() {
        if (this.a != null) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        this.a = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.a.setBackgroundDrawable(AbstractC4310Eo7.b(this.i));
        this.a.setPadding(C22078ud6.a(1.0f), 0, 0, 0);
        addView(this.a, C14433hu3.c(100, 54, 51));
        this.a.setOnClickListener(new a());
    }

    private void e() {
        this.l = false;
        if (this.b != null) {
            return;
        }
        SimpleTextView simpleTextView = new SimpleTextView(getContext());
        this.b = simpleTextView;
        simpleTextView.setGravity(3);
        this.b.setTextColor(C5495Jo7.a.i());
        this.b.setTypeface(C6011Lu2.i());
        this.b.setPadding(0, 0, 0, 0);
        addView(this.b, 0, C14433hu3.c(-2, -2, 49));
    }

    public static int getCurrentActionBarHeight() {
        return C5161Id6.k() ? C22078ud6.a(64.0f) : C5721Ko.b.getResources().getConfiguration().orientation == 2 ? C22078ud6.a(48.0f) : C22078ud6.a(56.0f);
    }

    public void a(b bVar) {
        if (bVar == null || this.k.contains(bVar)) {
            return;
        }
        this.k.add(bVar);
    }

    public void b() {
        ActionBarMenu actionBarMenu;
        if (!this.h || (actionBarMenu = this.c) == null) {
            return;
        }
        actionBarMenu.e();
    }

    public ActionBarMenu d() {
        ActionBarMenu actionBarMenu = this.c;
        if (actionBarMenu != null) {
            return actionBarMenu;
        }
        ActionBarMenu actionBarMenu2 = new ActionBarMenu(getContext(), this);
        this.c = actionBarMenu2;
        addView(actionBarMenu2, 0, C14433hu3.c(-2, -1, 5));
        return this.c;
    }

    public void f() {
        ActionBarMenu actionBarMenu = this.c;
        if (actionBarMenu != null) {
            actionBarMenu.i();
        }
    }

    protected void g() {
        ActionBarMenu actionBarMenu = this.c;
        if (actionBarMenu != null) {
            actionBarMenu.f();
        }
    }

    public boolean getAddToContainer() {
        return this.d;
    }

    public boolean getCastShadows() {
        return this.g;
    }

    public String getTitle() {
        SimpleTextView simpleTextView = this.b;
        if (simpleTextView == null) {
            return null;
        }
        return simpleTextView.getText().toString();
    }

    protected void h(boolean z) {
        this.h = z;
        SimpleTextView simpleTextView = this.b;
        if (simpleTextView != null) {
            simpleTextView.setVisibility(z ? 4 : 0);
        }
        int childCount = this.c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.c.getChildAt(i);
            if (childAt instanceof ActionBarMenuItemImp) {
                ActionBarMenuItemImp actionBarMenuItemImp = (ActionBarMenuItemImp) childAt;
                if (!actionBarMenuItemImp.e() && !actionBarMenuItemImp.C()) {
                    actionBarMenuItemImp.setVisibility(z ? 4 : 0);
                }
            }
        }
        this.a.getDrawable();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void i(b bVar) {
        this.k.remove(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011b  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.Actionbar.ActionBar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        SimpleTextView simpleTextView;
        int size = View.MeasureSpec.getSize(i);
        int currentActionBarHeight = getCurrentActionBarHeight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(currentActionBarHeight, 1073741824);
        setMeasuredDimension(size, currentActionBarHeight + AbstractC7426Rr.H());
        ImageView imageView = this.a;
        if (imageView != null && imageView.getVisibility() != 8) {
            this.a.measure(View.MeasureSpec.makeMeasureSpec(C22078ud6.a(54.0f), 1073741824), iMakeMeasureSpec);
        }
        ActionBarMenu actionBarMenu = this.c;
        if (actionBarMenu != null && actionBarMenu.getVisibility() != 8) {
            this.c.measure(this.h ? View.MeasureSpec.makeMeasureSpec(size, 1073741824) : View.MeasureSpec.makeMeasureSpec(size, RecyclerView.UNDEFINED_DURATION), iMakeMeasureSpec);
        }
        SimpleTextView simpleTextView2 = this.b;
        if (simpleTextView2 != null && simpleTextView2.getVisibility() != 8 && (simpleTextView = this.b) != null && simpleTextView.getVisibility() != 8 && !this.l) {
            this.b.setTextSize((C5161Id6.k() || getResources().getConfiguration().orientation != 2) ? 19 : 14);
            this.b.measure(View.MeasureSpec.makeMeasureSpec(C22078ud6.a(200.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(C22078ud6.a(24.0f), RecyclerView.UNDEFINED_DURATION));
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8 && childAt != this.b && childAt != this.c && childAt != this.a) {
                measureChildWithMargins(childAt, i, 0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824), 0);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent) || this.e;
    }

    public void setBackButtonImage(int i) {
        if (this.a == null) {
            c();
        }
        boolean z = i != 0;
        this.a.setVisibility(z ? 0 : 8);
        this.a.setImageResource(i);
        ActionBarMenu actionBarMenu = this.c;
        if (actionBarMenu == null || !z) {
            return;
        }
        actionBarMenu.g();
    }

    public void setBackButtonOnClickListener(View.OnClickListener onClickListener) {
        if (this.a == null) {
            c();
        }
        this.a.setOnClickListener(onClickListener);
    }

    public void setItemsBackgroundColor(int i) {
        this.i = i;
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setBackgroundDrawable(AbstractC4310Eo7.b(i));
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null && this.b == null) {
            e();
        }
        SimpleTextView simpleTextView = this.b;
        if (simpleTextView != null) {
            this.f = charSequence;
            simpleTextView.setVisibility((charSequence == null || this.h) ? 4 : 0);
            if (charSequence == null || !(charSequence.toString().equals(getContext().getString(AbstractC12217eE5.dialogs_connection_state_connecting)) || charSequence.toString().equals(getContext().getString(AbstractC12217eE5.dialogs_connection_state_updating)) || charSequence.toString().equals(getContext().getString(AbstractC12217eE5.dialogs_connection_state_wait_for_network)))) {
                this.b.setRightDrawable(null);
                this.b.setLeftDrawable(null);
                this.b.setText(charSequence);
            } else if (!JF5.g()) {
                this.b.setText(charSequence);
                this.b.setLeftDrawable(null);
            } else {
                this.b.setLeftDrawable(new C4658Fz7());
                this.b.setLeftDrawableTopPadding(AbstractC7426Rr.z(4.0f));
                this.b.setText(charSequence);
                this.b.setRightDrawable(null);
            }
        }
    }

    public void setTitleCenter(boolean z) {
        this.m = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    public void setTitleOverlayText(String str) {
        String str2 = str;
        if (this.j.d == null) {
            return;
        }
        if (str == null) {
            str2 = this.f;
        }
        if (str2 != null && this.b == null) {
            e();
        }
        SimpleTextView simpleTextView = this.b;
        if (simpleTextView != null) {
            simpleTextView.setVisibility((str2 == null || this.h) ? 4 : 0);
            this.b.setText(str2);
        }
    }
}
