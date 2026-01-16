package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.gov.nist.core.Separators;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC4373Ev7;
import ir.nasim.AbstractC8958Xy7;
import ir.nasim.C21892uJ3;
import ir.nasim.KJ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes2.dex */
public abstract class Transition implements Cloneable {
    private static final int[] Y = {2, 1, 3, 4};
    private static final PathMotion Z = new a();
    private static ThreadLocal z0 = new ThreadLocal();
    AbstractC4373Ev7 D;
    private e G;
    private KJ H;
    private ArrayList t;
    private ArrayList u;
    private String a = getClass().getName();
    private long b = -1;
    long c = -1;
    private TimeInterpolator d = null;
    ArrayList e = new ArrayList();
    ArrayList f = new ArrayList();
    private ArrayList g = null;
    private ArrayList h = null;
    private ArrayList i = null;
    private ArrayList j = null;
    private ArrayList k = null;
    private ArrayList l = null;
    private ArrayList m = null;
    private ArrayList n = null;
    private ArrayList o = null;
    private u p = new u();
    private u q = new u();
    TransitionSet r = null;
    private int[] s = Y;
    boolean v = false;
    ArrayList w = new ArrayList();
    private int x = 0;
    private boolean y = false;
    private boolean z = false;
    private ArrayList A = null;
    private ArrayList B = new ArrayList();
    private PathMotion J = Z;

    class a extends PathMotion {
        a() {
        }

        @Override // androidx.transition.PathMotion
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ KJ a;

        b(KJ kj) {
            this.a = kj;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            Transition.this.w.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Transition.this.w.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Transition.this.s();
            animator.removeListener(this);
        }
    }

    private static class d {
        View a;
        String b;
        t c;
        J d;
        Transition e;

        d(View view, String str, Transition transition, J j, t tVar) {
            this.a = view;
            this.b = str;
            this.c = tVar;
            this.d = j;
            this.e = transition;
        }
    }

    public static abstract class e {
        public abstract Rect a(Transition transition);
    }

    public interface f {
        void a(Transition transition);

        void b(Transition transition);

        void c(Transition transition);

        void d(Transition transition);

        void e(Transition transition);
    }

    public Transition() {
    }

    private static KJ A() {
        KJ kj = (KJ) z0.get();
        if (kj != null) {
            return kj;
        }
        KJ kj2 = new KJ();
        z0.set(kj2);
        return kj2;
    }

    private static boolean J(int i) {
        return i >= 1 && i <= 4;
    }

    private static boolean L(t tVar, t tVar2, String str) {
        Object obj = tVar.a.get(str);
        Object obj2 = tVar2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void M(KJ kj, KJ kj2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) sparseArray.valueAt(i);
            if (view2 != null && K(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i))) != null && K(view)) {
                t tVar = (t) kj.get(view2);
                t tVar2 = (t) kj2.get(view);
                if (tVar != null && tVar2 != null) {
                    this.t.add(tVar);
                    this.u.add(tVar2);
                    kj.remove(view2);
                    kj2.remove(view);
                }
            }
        }
    }

    private void N(KJ kj, KJ kj2) {
        t tVar;
        for (int size = kj.size() - 1; size >= 0; size--) {
            View view = (View) kj.g(size);
            if (view != null && K(view) && (tVar = (t) kj2.remove(view)) != null && K(tVar.b)) {
                this.t.add((t) kj.i(size));
                this.u.add(tVar);
            }
        }
    }

    private void O(KJ kj, KJ kj2, C21892uJ3 c21892uJ3, C21892uJ3 c21892uJ32) {
        View view;
        int iO = c21892uJ3.o();
        for (int i = 0; i < iO; i++) {
            View view2 = (View) c21892uJ3.p(i);
            if (view2 != null && K(view2) && (view = (View) c21892uJ32.f(c21892uJ3.k(i))) != null && K(view)) {
                t tVar = (t) kj.get(view2);
                t tVar2 = (t) kj2.get(view);
                if (tVar != null && tVar2 != null) {
                    this.t.add(tVar);
                    this.u.add(tVar2);
                    kj.remove(view2);
                    kj2.remove(view);
                }
            }
        }
    }

    private void Q(KJ kj, KJ kj2, KJ kj3, KJ kj4) {
        View view;
        int size = kj3.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) kj3.k(i);
            if (view2 != null && K(view2) && (view = (View) kj4.get(kj3.g(i))) != null && K(view)) {
                t tVar = (t) kj.get(view2);
                t tVar2 = (t) kj2.get(view);
                if (tVar != null && tVar2 != null) {
                    this.t.add(tVar);
                    this.u.add(tVar2);
                    kj.remove(view2);
                    kj2.remove(view);
                }
            }
        }
    }

    private void R(u uVar, u uVar2) {
        KJ kj = new KJ(uVar.a);
        KJ kj2 = new KJ(uVar2.a);
        int i = 0;
        while (true) {
            int[] iArr = this.s;
            if (i >= iArr.length) {
                d(kj, kj2);
                return;
            }
            int i2 = iArr[i];
            if (i2 == 1) {
                N(kj, kj2);
            } else if (i2 == 2) {
                Q(kj, kj2, uVar.d, uVar2.d);
            } else if (i2 == 3) {
                M(kj, kj2, uVar.b, uVar2.b);
            } else if (i2 == 4) {
                O(kj, kj2, uVar.c, uVar2.c);
            }
            i++;
        }
    }

    private static int[] T(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(strTrim)) {
                iArr[i] = 3;
            } else if ("instance".equalsIgnoreCase(strTrim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(strTrim)) {
                iArr[i] = 2;
            } else if ("itemId".equalsIgnoreCase(strTrim)) {
                iArr[i] = 4;
            } else {
                if (!strTrim.isEmpty()) {
                    throw new InflateException("Unknown match type in matchOrder: '" + strTrim + Separators.QUOTE);
                }
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            }
            i++;
        }
        return iArr;
    }

    private void Z(Animator animator, KJ kj) {
        if (animator != null) {
            animator.addListener(new b(kj));
            h(animator);
        }
    }

    private void d(KJ kj, KJ kj2) {
        for (int i = 0; i < kj.size(); i++) {
            t tVar = (t) kj.k(i);
            if (K(tVar.b)) {
                this.t.add(tVar);
                this.u.add(null);
            }
        }
        for (int i2 = 0; i2 < kj2.size(); i2++) {
            t tVar2 = (t) kj2.k(i2);
            if (K(tVar2.b)) {
                this.u.add(tVar2);
                this.t.add(null);
            }
        }
    }

    private static void e(u uVar, View view, t tVar) {
        uVar.a.put(view, tVar);
        int id = view.getId();
        if (id >= 0) {
            if (uVar.b.indexOfKey(id) >= 0) {
                uVar.b.put(id, null);
            } else {
                uVar.b.put(id, view);
            }
        }
        String strJ = AbstractC12990fW7.J(view);
        if (strJ != null) {
            if (uVar.d.containsKey(strJ)) {
                uVar.d.put(strJ, null);
            } else {
                uVar.d.put(strJ, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (uVar.c.h(itemIdAtPosition) < 0) {
                    AbstractC12990fW7.z0(view, true);
                    uVar.c.l(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) uVar.c.f(itemIdAtPosition);
                if (view2 != null) {
                    AbstractC12990fW7.z0(view2, false);
                    uVar.c.l(itemIdAtPosition, null);
                }
            }
        }
    }

    private static boolean f(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void k(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (((Class) this.k.get(i)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    t tVar = new t(view);
                    if (z) {
                        m(tVar);
                    } else {
                        i(tVar);
                    }
                    tVar.c.add(this);
                    l(tVar);
                    if (z) {
                        e(this.p, view, tVar);
                    } else {
                        e(this.q, view, tVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (((Class) this.o.get(i2)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                k(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public long B() {
        return this.b;
    }

    public List C() {
        return this.e;
    }

    public List D() {
        return this.g;
    }

    public List E() {
        return this.h;
    }

    public List F() {
        return this.f;
    }

    public String[] G() {
        return null;
    }

    public t H(View view, boolean z) {
        TransitionSet transitionSet = this.r;
        if (transitionSet != null) {
            return transitionSet.H(view, z);
        }
        return (t) (z ? this.p : this.q).a.get(view);
    }

    public boolean I(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return false;
        }
        String[] strArrG = G();
        if (strArrG == null) {
            Iterator it = tVar.a.keySet().iterator();
            while (it.hasNext()) {
                if (L(tVar, tVar2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrG) {
            if (!L(tVar, tVar2, str)) {
            }
        }
        return false;
        return true;
    }

    boolean K(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (((Class) this.k.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.l != null && AbstractC12990fW7.J(view) != null && this.l.contains(AbstractC12990fW7.J(view))) {
            return false;
        }
        if ((this.e.size() == 0 && this.f.size() == 0 && (((arrayList = this.h) == null || arrayList.isEmpty()) && ((arrayList2 = this.g) == null || arrayList2.isEmpty()))) || this.e.contains(Integer.valueOf(id)) || this.f.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.g;
        if (arrayList6 != null && arrayList6.contains(AbstractC12990fW7.J(view))) {
            return true;
        }
        if (this.h != null) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                if (((Class) this.h.get(i2)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void U(View view) {
        if (this.z) {
            return;
        }
        for (int size = this.w.size() - 1; size >= 0; size--) {
            AbstractC1978a.b((Animator) this.w.get(size));
        }
        ArrayList arrayList = this.A;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.A.clone();
            int size2 = arrayList2.size();
            for (int i = 0; i < size2; i++) {
                ((f) arrayList2.get(i)).c(this);
            }
        }
        this.y = true;
    }

    void V(ViewGroup viewGroup) {
        d dVar;
        this.t = new ArrayList();
        this.u = new ArrayList();
        R(this.p, this.q);
        KJ kjA = A();
        int size = kjA.size();
        J jD = B.d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = (Animator) kjA.g(i);
            if (animator != null && (dVar = (d) kjA.get(animator)) != null && dVar.a != null && jD.equals(dVar.d)) {
                t tVar = dVar.c;
                View view = dVar.a;
                t tVarH = H(view, true);
                t tVarX = x(view, true);
                if (tVarH == null && tVarX == null) {
                    tVarX = (t) this.q.a.get(view);
                }
                if ((tVarH != null || tVarX != null) && dVar.e.I(tVar, tVarX)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        kjA.remove(animator);
                    }
                }
            }
        }
        r(viewGroup, this.p, this.q, this.t, this.u);
        a0();
    }

    public Transition W(f fVar) {
        ArrayList arrayList = this.A;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.A.size() == 0) {
            this.A = null;
        }
        return this;
    }

    public Transition X(View view) {
        this.f.remove(view);
        return this;
    }

    public void Y(View view) {
        if (this.y) {
            if (!this.z) {
                for (int size = this.w.size() - 1; size >= 0; size--) {
                    AbstractC1978a.c((Animator) this.w.get(size));
                }
                ArrayList arrayList = this.A;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.A.clone();
                    int size2 = arrayList2.size();
                    for (int i = 0; i < size2; i++) {
                        ((f) arrayList2.get(i)).a(this);
                    }
                }
            }
            this.y = false;
        }
    }

    protected void a0() {
        j0();
        KJ kjA = A();
        Iterator it = this.B.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (kjA.containsKey(animator)) {
                j0();
                Z(animator, kjA);
            }
        }
        this.B.clear();
        s();
    }

    public Transition b(f fVar) {
        if (this.A == null) {
            this.A = new ArrayList();
        }
        this.A.add(fVar);
        return this;
    }

    public Transition b0(long j) {
        this.c = j;
        return this;
    }

    public Transition c(View view) {
        this.f.add(view);
        return this;
    }

    public void c0(e eVar) {
        this.G = eVar;
    }

    protected void cancel() {
        for (int size = this.w.size() - 1; size >= 0; size--) {
            ((Animator) this.w.get(size)).cancel();
        }
        ArrayList arrayList = this.A;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.A.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((f) arrayList2.get(i)).e(this);
        }
    }

    public Transition e0(TimeInterpolator timeInterpolator) {
        this.d = timeInterpolator;
        return this;
    }

    public void f0(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.s = Y;
            return;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (!J(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (f(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.s = (int[]) iArr.clone();
    }

    public void g0(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.J = Z;
        } else {
            this.J = pathMotion;
        }
    }

    public String getName() {
        return this.a;
    }

    protected void h(Animator animator) {
        if (animator == null) {
            s();
            return;
        }
        if (t() >= 0) {
            animator.setDuration(t());
        }
        if (B() >= 0) {
            animator.setStartDelay(B() + animator.getStartDelay());
        }
        if (w() != null) {
            animator.setInterpolator(w());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void h0(AbstractC4373Ev7 abstractC4373Ev7) {
        this.D = abstractC4373Ev7;
    }

    public abstract void i(t tVar);

    public Transition i0(long j) {
        this.b = j;
        return this;
    }

    protected void j0() {
        if (this.x == 0) {
            ArrayList arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((f) arrayList2.get(i)).b(this);
                }
            }
            this.z = false;
        }
        this.x++;
    }

    String k0(String str) {
        String str2 = str + getClass().getSimpleName() + Separators.AT + Integer.toHexString(hashCode()) + ": ";
        if (this.c != -1) {
            str2 = str2 + "dur(" + this.c + ") ";
        }
        if (this.b != -1) {
            str2 = str2 + "dly(" + this.b + ") ";
        }
        if (this.d != null) {
            str2 = str2 + "interp(" + this.d + ") ";
        }
        if (this.e.size() <= 0 && this.f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.e.size() > 0) {
            for (int i = 0; i < this.e.size(); i++) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.e.get(i);
            }
        }
        if (this.f.size() > 0) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f.get(i2);
            }
        }
        return str3 + Separators.RPAREN;
    }

    void l(t tVar) {
        String[] strArrB;
        if (this.D == null || tVar.a.isEmpty() || (strArrB = this.D.b()) == null) {
            return;
        }
        for (String str : strArrB) {
            if (!tVar.a.containsKey(str)) {
                this.D.a(tVar);
                return;
            }
        }
    }

    public abstract void m(t tVar);

    void n(ViewGroup viewGroup, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        KJ kj;
        o(z);
        if ((this.e.size() > 0 || this.f.size() > 0) && (((arrayList = this.g) == null || arrayList.isEmpty()) && ((arrayList2 = this.h) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.e.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.e.get(i)).intValue());
                if (viewFindViewById != null) {
                    t tVar = new t(viewFindViewById);
                    if (z) {
                        m(tVar);
                    } else {
                        i(tVar);
                    }
                    tVar.c.add(this);
                    l(tVar);
                    if (z) {
                        e(this.p, viewFindViewById, tVar);
                    } else {
                        e(this.q, viewFindViewById, tVar);
                    }
                }
            }
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                View view = (View) this.f.get(i2);
                t tVar2 = new t(view);
                if (z) {
                    m(tVar2);
                } else {
                    i(tVar2);
                }
                tVar2.c.add(this);
                l(tVar2);
                if (z) {
                    e(this.p, view, tVar2);
                } else {
                    e(this.q, view, tVar2);
                }
            }
        } else {
            k(viewGroup, z);
        }
        if (z || (kj = this.H) == null) {
            return;
        }
        int size = kj.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.p.d.remove((String) this.H.g(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.p.d.put((String) this.H.k(i4), view2);
            }
        }
    }

    void o(boolean z) {
        if (z) {
            this.p.a.clear();
            this.p.b.clear();
            this.p.c.c();
        } else {
            this.q.a.clear();
            this.q.b.clear();
            this.q.c.c();
        }
    }

    @Override // 
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.B = new ArrayList();
            transition.p = new u();
            transition.q = new u();
            transition.t = null;
            transition.u = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator q(ViewGroup viewGroup, t tVar, t tVar2) {
        return null;
    }

    protected void r(ViewGroup viewGroup, u uVar, u uVar2, ArrayList arrayList, ArrayList arrayList2) {
        Animator animatorQ;
        int i;
        View view;
        Animator animator;
        t tVar;
        Animator animator2;
        t tVar2;
        KJ kjA = A();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long jMin = Long.MAX_VALUE;
        int i2 = 0;
        while (i2 < size) {
            t tVar3 = (t) arrayList.get(i2);
            t tVar4 = (t) arrayList2.get(i2);
            if (tVar3 != null && !tVar3.c.contains(this)) {
                tVar3 = null;
            }
            if (tVar4 != null && !tVar4.c.contains(this)) {
                tVar4 = null;
            }
            if (!(tVar3 == null && tVar4 == null) && ((tVar3 == null || tVar4 == null || I(tVar3, tVar4)) && (animatorQ = q(viewGroup, tVar3, tVar4)) != null)) {
                if (tVar4 != null) {
                    view = tVar4.b;
                    String[] strArrG = G();
                    if (strArrG != null && strArrG.length > 0) {
                        tVar2 = new t(view);
                        i = size;
                        t tVar5 = (t) uVar2.a.get(view);
                        if (tVar5 != null) {
                            int i3 = 0;
                            while (i3 < strArrG.length) {
                                Map map = tVar2.a;
                                String str = strArrG[i3];
                                map.put(str, tVar5.a.get(str));
                                i3++;
                                strArrG = strArrG;
                            }
                        }
                        int size2 = kjA.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size2) {
                                animator2 = animatorQ;
                                break;
                            }
                            d dVar = (d) kjA.get((Animator) kjA.g(i4));
                            if (dVar.c != null && dVar.a == view && dVar.b.equals(getName()) && dVar.c.equals(tVar2)) {
                                animator2 = null;
                                break;
                            }
                            i4++;
                        }
                    } else {
                        i = size;
                        animator2 = animatorQ;
                        tVar2 = null;
                    }
                    animator = animator2;
                    tVar = tVar2;
                } else {
                    i = size;
                    view = tVar3.b;
                    animator = animatorQ;
                    tVar = null;
                }
                if (animator != null) {
                    AbstractC4373Ev7 abstractC4373Ev7 = this.D;
                    if (abstractC4373Ev7 != null) {
                        long jC = abstractC4373Ev7.c(viewGroup, this, tVar3, tVar4);
                        sparseIntArray.put(this.B.size(), (int) jC);
                        jMin = Math.min(jC, jMin);
                    }
                    kjA.put(animator, new d(view, getName(), this, B.d(viewGroup), tVar));
                    this.B.add(animator);
                    jMin = jMin;
                }
            } else {
                i = size;
            }
            i2++;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                Animator animator3 = (Animator) this.B.get(sparseIntArray.keyAt(i5));
                animator3.setStartDelay((sparseIntArray.valueAt(i5) - jMin) + animator3.getStartDelay());
            }
        }
    }

    protected void s() {
        int i = this.x - 1;
        this.x = i;
        if (i == 0) {
            ArrayList arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).d(this);
                }
            }
            for (int i3 = 0; i3 < this.p.c.o(); i3++) {
                View view = (View) this.p.c.p(i3);
                if (view != null) {
                    AbstractC12990fW7.z0(view, false);
                }
            }
            for (int i4 = 0; i4 < this.q.c.o(); i4++) {
                View view2 = (View) this.q.c.p(i4);
                if (view2 != null) {
                    AbstractC12990fW7.z0(view2, false);
                }
            }
            this.z = true;
        }
    }

    public long t() {
        return this.c;
    }

    public String toString() {
        return k0("");
    }

    public Rect u() {
        e eVar = this.G;
        if (eVar == null) {
            return null;
        }
        return eVar.a(this);
    }

    public e v() {
        return this.G;
    }

    public TimeInterpolator w() {
        return this.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return (androidx.transition.t) r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.transition.t x(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            androidx.transition.TransitionSet r0 = r5.r
            if (r0 == 0) goto L9
            androidx.transition.t r6 = r0.x(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.t
            goto L10
        Le:
            java.util.ArrayList r0 = r5.u
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            androidx.transition.t r4 = (androidx.transition.t) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList r6 = r5.u
            goto L36
        L34:
            java.util.ArrayList r6 = r5.t
        L36:
            java.lang.Object r6 = r6.get(r3)
            r1 = r6
            androidx.transition.t r1 = (androidx.transition.t) r1
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.x(android.view.View, boolean):androidx.transition.t");
    }

    public PathMotion y() {
        return this.J;
    }

    public AbstractC4373Ev7 z() {
        return this.D;
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long jG = AbstractC8958Xy7.g(typedArrayObtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (jG >= 0) {
            b0(jG);
        }
        long jG2 = AbstractC8958Xy7.g(typedArrayObtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (jG2 > 0) {
            i0(jG2);
        }
        int iH = AbstractC8958Xy7.h(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (iH > 0) {
            e0(AnimationUtils.loadInterpolator(context, iH));
        }
        String strI = AbstractC8958Xy7.i(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strI != null) {
            f0(T(strI));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
