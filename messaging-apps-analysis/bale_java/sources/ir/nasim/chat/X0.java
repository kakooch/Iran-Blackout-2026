package ir.nasim.chat;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC9203Yx6;
import ir.nasim.C17428mw7;
import ir.nasim.C19406qI3;
import ir.nasim.C21356tW7;
import ir.nasim.C8948Xx6;
import ir.nasim.ED1;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.P64;
import ir.nasim.animation.view.transition.sharedelement.CapturedSharedElement;
import ir.nasim.animation.view.transition.sharedelement.Corners;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class X0 extends AbstractC9203Yx6 implements DefaultLifecycleObserver {
    public static final a f = new a(null);
    public static final int g = 8;
    private final FragmentActivity b;
    private final RecyclerView c;
    private boolean d;
    private final HashMap e;

    public static final class a {
        private a() {
        }

        public final X0 a(FragmentActivity fragmentActivity, RecyclerView recyclerView) {
            AbstractC13042fc3.i(fragmentActivity, "activity");
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            X0 x0 = new X0(fragmentActivity, recyclerView, null);
            x0.n();
            return x0;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ X0(FragmentActivity fragmentActivity, RecyclerView recyclerView, ED1 ed1) {
        this(fragmentActivity, recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        this.b.getLifecycle().a(this);
        this.b.O0(this);
    }

    private final void o(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        Rect rect = new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight());
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        if (AbstractC13042fc3.d(rect, rect2)) {
            return;
        }
        int i2 = rect2.left;
        int i3 = iArr[0];
        int i4 = rect2.top;
        int i5 = iArr[1];
        view.setClipBounds(new Rect(i2 - i3, i4 - i5, rect2.right - i3, rect2.bottom - i5));
    }

    private final void p() {
        this.e.clear();
        this.b.getLifecycle().d(this);
        this.b.O0(null);
    }

    private final List q() {
        List<C8948Xx6> listG;
        ArrayList arrayList = new ArrayList();
        int childCount = this.c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.c.getChildAt(i);
            RecyclerView.C childViewHolder = this.c.getChildViewHolder(childAt);
            P64 p64 = childViewHolder instanceof P64 ? (P64) childViewHolder : null;
            if (p64 != null) {
                Rect rect = new Rect();
                childAt.getGlobalVisibleRect(rect);
                if (p64.l().intersect(rect) && (listG = p64.g()) != null) {
                    for (C8948Xx6 c8948Xx6 : listG) {
                        View viewA = c8948Xx6.a();
                        Corners cornersB = c8948Xx6.b();
                        String strJ = AbstractC12990fW7.J(viewA);
                        if (strJ == null) {
                            break;
                        }
                        arrayList.add(new C17428mw7(viewA, strJ, cornersB));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.AbstractC9203Yx6
    public Parcelable b(View view, Matrix matrix, RectF rectF) {
        AbstractC13042fc3.i(view, "sharedElement");
        AbstractC13042fc3.i(matrix, "viewToGlobalMatrix");
        AbstractC13042fc3.i(rectF, "screenBounds");
        o(view);
        Parcelable parcelableB = super.b(view, matrix, rectF);
        if (parcelableB == null) {
            return null;
        }
        Rect clipBounds = view.getClipBounds();
        Corners corners = (Corners) this.e.remove(view);
        if (corners == null) {
            corners = new Corners(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }
        CapturedSharedElement capturedSharedElement = new CapturedSharedElement(corners, clipBounds, parcelableB);
        C19406qI3.a("ChatSharedElementCallback", "onCaptureSharedElementSnapshot(" + capturedSharedElement + Separators.RPAREN, new Object[0]);
        return capturedSharedElement;
    }

    @Override // ir.nasim.AbstractC9203Yx6
    public View d(Context context, Parcelable parcelable) {
        AbstractC13042fc3.i(context, "context");
        if (!(parcelable instanceof CapturedSharedElement)) {
            return super.d(context, parcelable);
        }
        CapturedSharedElement capturedSharedElement = (CapturedSharedElement) parcelable;
        View viewD = super.d(context, capturedSharedElement.getParcelable());
        if (viewD == null) {
            return null;
        }
        viewD.setClipBounds(capturedSharedElement.getClipBounds());
        viewD.setOutlineProvider(new C21356tW7(capturedSharedElement.getCorners()));
        viewD.setClipToOutline(true);
        return viewD;
    }

    @Override // ir.nasim.AbstractC9203Yx6
    public void e(List list, Map map) {
        Object next;
        AbstractC13042fc3.i(list, "names");
        AbstractC13042fc3.i(map, "sharedElements");
        C19406qI3.a("ChatSharedElementCallback", "onMapSharedElements(" + list + ", " + map + Separators.RPAREN, new Object[0]);
        List listQ = q();
        if (this.d) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Iterator it2 = listQ.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next = it2.next();
                        if (AbstractC13042fc3.d((String) ((C17428mw7) next).b(), str)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                C17428mw7 c17428mw7 = (C17428mw7) next;
                if (c17428mw7 != null) {
                    View view = (View) c17428mw7.a();
                    Corners corners = (Corners) c17428mw7.c();
                    map.put(str, view);
                    this.e.put(view, corners);
                }
            }
        } else {
            List list2 = listQ;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                arrayList.add((String) ((C17428mw7) it3.next()).g());
            }
            list.addAll(arrayList);
        }
        C19406qI3.a("ChatSharedElementCallback", "onMapSharedElements(" + list + ", " + map + Separators.RPAREN, new Object[0]);
        if (this.d) {
            int childCount = this.c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.c.getChildAt(i);
                RecyclerView.C childViewHolder = this.c.getChildViewHolder(childAt);
                P64 p64 = childViewHolder instanceof P64 ? (P64) childViewHolder : null;
                if (p64 != null) {
                    Rect rect = new Rect();
                    childAt.getGlobalVisibleRect(rect);
                    if (p64.l().intersect(rect) && p64.g() != null) {
                        p64.e();
                    }
                }
            }
        }
    }

    @Override // ir.nasim.AbstractC9203Yx6
    public void g(List list, List list2, List list3) {
        AbstractC13042fc3.i(list, "sharedElementNames");
        AbstractC13042fc3.i(list2, "sharedElements");
        AbstractC13042fc3.i(list3, "sharedElementSnapshots");
        int i = 0;
        C19406qI3.a("ChatSharedElementCallback", "onSharedElementEnd()", new Object[0]);
        super.g(list, list2, list3);
        if (this.d) {
            p();
            int childCount = this.c.getChildCount();
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = this.c.getChildAt(i);
                RecyclerView.C childViewHolder = this.c.getChildViewHolder(childAt);
                P64 p64 = childViewHolder instanceof P64 ? (P64) childViewHolder : null;
                if (p64 != null) {
                    Rect rect = new Rect();
                    childAt.getGlobalVisibleRect(rect);
                    if (p64.l().intersect(rect) && p64.g() != null) {
                        p64.n();
                    }
                }
                i++;
            }
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setClipBounds(null);
            }
        }
    }

    @Override // ir.nasim.AbstractC9203Yx6
    public void h(List list, List list2, List list3) {
        AbstractC13042fc3.i(list, "sharedElementNames");
        AbstractC13042fc3.i(list2, "sharedElements");
        AbstractC13042fc3.i(list3, "sharedElementSnapshots");
        C19406qI3.a("ChatSharedElementCallback", "onSharedElementStart()", new Object[0]);
        super.h(list, list2, list3);
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            View view = (View) list2.get(i);
            View view2 = (View) AbstractC15401jX0.t0(list3, i);
            view.setClipBounds(view2 != null ? view2.getClipBounds() : null);
        }
    }

    @Override // ir.nasim.AbstractC9203Yx6
    public void i(List list, List list2, AbstractC9203Yx6.a aVar) {
        AbstractC13042fc3.i(list, "sharedElementNames");
        AbstractC13042fc3.i(list2, "sharedElements");
        AbstractC13042fc3.i(aVar, "listener");
        C19406qI3.a("ChatSharedElementCallback", "onSharedElementsArrived(" + list2 + Separators.RPAREN, new Object[0]);
        super.i(list, list2, aVar);
        if (this.d) {
            return;
        }
        this.d = true;
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setClipBounds(null);
        }
        int childCount = this.c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.c.getChildAt(i);
            RecyclerView.C childViewHolder = this.c.getChildViewHolder(childAt);
            P64 p64 = childViewHolder instanceof P64 ? (P64) childViewHolder : null;
            if (p64 != null) {
                Rect rect = new Rect();
                childAt.getGlobalVisibleRect(rect);
                if (p64.l().intersect(rect) && p64.g() != null) {
                    p64.u();
                }
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
        AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        p();
    }

    private X0(FragmentActivity fragmentActivity, RecyclerView recyclerView) {
        this.b = fragmentActivity;
        this.c = recyclerView;
        this.e = new HashMap();
    }
}
