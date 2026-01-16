package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.gov.nist.core.LexerCore;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.x;
import androidx.lifecycle.j;
import ir.nasim.A44;
import ir.nasim.AC5;
import ir.nasim.AI4;
import ir.nasim.AbstractC18108o6;
import ir.nasim.AbstractC22357v6;
import ir.nasim.AbstractC23070wI4;
import ir.nasim.AbstractC24133y6;
import ir.nasim.AbstractC6771Ox2;
import ir.nasim.B6;
import ir.nasim.C14819iX7;
import ir.nasim.C17236md5;
import ir.nasim.C19290q6;
import ir.nasim.C20490s6;
import ir.nasim.C23660xI4;
import ir.nasim.C4404Ez2;
import ir.nasim.C6665Ol4;
import ir.nasim.C7289Rb6;
import ir.nasim.DJ4;
import ir.nasim.InterfaceC13295fz2;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC15879kK4;
import ir.nasim.InterfaceC17502n44;
import ir.nasim.InterfaceC17517n6;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.InterfaceC7258Qy2;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.OJ4;
import ir.nasim.TV;
import ir.nasim.YI4;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class FragmentManager {
    private static boolean U = false;
    static boolean V = true;
    Fragment A;
    private AbstractC22357v6 F;
    private AbstractC22357v6 G;
    private AbstractC22357v6 H;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private ArrayList O;
    private ArrayList P;
    private ArrayList Q;
    private t R;
    private C4404Ez2.c S;
    private boolean b;
    private ArrayList e;
    private C23660xI4 g;
    private androidx.fragment.app.p x;
    private AbstractC6771Ox2 y;
    private Fragment z;
    private final ArrayList a = new ArrayList();
    private final w c = new w();
    ArrayList d = new ArrayList();
    private final androidx.fragment.app.q f = new androidx.fragment.app.q(this);
    C1957a h = null;
    boolean i = false;
    private final AbstractC23070wI4 j = new b(false);
    private final AtomicInteger k = new AtomicInteger();
    private final Map l = Collections.synchronizedMap(new HashMap());
    private final Map m = Collections.synchronizedMap(new HashMap());
    private final Map n = Collections.synchronizedMap(new HashMap());
    ArrayList o = new ArrayList();
    private final r p = new r(this);
    private final CopyOnWriteArrayList q = new CopyOnWriteArrayList();
    private final InterfaceC25043ze1 r = new InterfaceC25043ze1() { // from class: ir.nasim.qy2
        @Override // ir.nasim.InterfaceC25043ze1
        public final void accept(Object obj) {
            this.a.a1((Configuration) obj);
        }
    };
    private final InterfaceC25043ze1 s = new InterfaceC25043ze1() { // from class: ir.nasim.ry2
        @Override // ir.nasim.InterfaceC25043ze1
        public final void accept(Object obj) {
            this.a.b1((Integer) obj);
        }
    };
    private final InterfaceC25043ze1 t = new InterfaceC25043ze1() { // from class: ir.nasim.sy2
        @Override // ir.nasim.InterfaceC25043ze1
        public final void accept(Object obj) {
            this.a.c1((C6665Ol4) obj);
        }
    };
    private final InterfaceC25043ze1 u = new InterfaceC25043ze1() { // from class: ir.nasim.ty2
        @Override // ir.nasim.InterfaceC25043ze1
        public final void accept(Object obj) {
            this.a.d1((C17236md5) obj);
        }
    };
    private final A44 v = new c();
    int w = -1;
    private androidx.fragment.app.o B = null;
    private androidx.fragment.app.o C = new d();
    private G D = null;
    private G E = new e();
    ArrayDeque I = new ArrayDeque();
    private Runnable T = new f();

    class a implements InterfaceC17517n6 {
        a() {
        }

        @Override // ir.nasim.InterfaceC17517n6
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.I.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfo.a;
            int i2 = launchedFragmentInfo.b;
            Fragment fragmentI = FragmentManager.this.c.i(str);
            if (fragmentI != null) {
                fragmentI.g7(i2, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    class b extends AbstractC23070wI4 {
        b(boolean z) {
            super(z);
        }

        @Override // ir.nasim.AbstractC23070wI4
        public void c() {
            if (FragmentManager.Q0(3)) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            if (FragmentManager.V) {
                FragmentManager.this.t();
            }
        }

        @Override // ir.nasim.AbstractC23070wI4
        public void d() {
            if (FragmentManager.Q0(3)) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            FragmentManager.this.M0();
        }

        @Override // ir.nasim.AbstractC23070wI4
        public void e(TV tv) {
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            FragmentManager fragmentManager = FragmentManager.this;
            if (fragmentManager.h != null) {
                Iterator it = fragmentManager.B(new ArrayList(Collections.singletonList(FragmentManager.this.h)), 0, 1).iterator();
                while (it.hasNext()) {
                    ((F) it.next()).A(tv);
                }
                Iterator it2 = FragmentManager.this.o.iterator();
                while (it2.hasNext()) {
                    ((n) it2.next()).c(tv);
                }
            }
        }

        @Override // ir.nasim.AbstractC23070wI4
        public void f(TV tv) {
            if (FragmentManager.Q0(3)) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = " + FragmentManager.V + " fragment manager " + FragmentManager.this);
            }
            if (FragmentManager.V) {
                FragmentManager.this.e0();
                FragmentManager.this.r1();
            }
        }
    }

    class c implements A44 {
        c() {
        }

        @Override // ir.nasim.A44
        public void a(Menu menu) {
            FragmentManager.this.R(menu);
        }

        @Override // ir.nasim.A44
        public void b(Menu menu) {
            FragmentManager.this.V(menu);
        }

        @Override // ir.nasim.A44
        public boolean c(MenuItem menuItem) {
            return FragmentManager.this.Q(menuItem);
        }

        @Override // ir.nasim.A44
        public void d(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.J(menu, menuInflater);
        }
    }

    class d extends androidx.fragment.app.o {
        d() {
        }

        @Override // androidx.fragment.app.o
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.D0().g(FragmentManager.this.D0().k(), str, null);
        }
    }

    class e implements G {
        e() {
        }

        @Override // androidx.fragment.app.G
        public F a(ViewGroup viewGroup) {
            return new C1959c(viewGroup);
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.h0(true);
        }
    }

    class g implements androidx.lifecycle.n {
        final /* synthetic */ String a;
        final /* synthetic */ InterfaceC13295fz2 b;
        final /* synthetic */ androidx.lifecycle.j c;

        g(String str, InterfaceC13295fz2 interfaceC13295fz2, androidx.lifecycle.j jVar) {
            this.a = str;
            this.b = interfaceC13295fz2;
            this.c = jVar;
        }

        @Override // androidx.lifecycle.n
        public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
            Bundle bundle;
            if (aVar == j.a.ON_START && (bundle = (Bundle) FragmentManager.this.m.get(this.a)) != null) {
                this.b.a(this.a, bundle);
                FragmentManager.this.y(this.a);
            }
            if (aVar == j.a.ON_DESTROY) {
                this.c.d(this);
                FragmentManager.this.n.remove(this.a);
            }
        }
    }

    class h implements InterfaceC7258Qy2 {
        final /* synthetic */ Fragment a;

        h(Fragment fragment) {
            this.a = fragment;
        }

        @Override // ir.nasim.InterfaceC7258Qy2
        public void d(FragmentManager fragmentManager, Fragment fragment) {
            this.a.K6(fragment);
        }
    }

    class i implements InterfaceC17517n6 {
        i() {
        }

        @Override // ir.nasim.InterfaceC17517n6
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.I.pollLast();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfo.a;
            int i = launchedFragmentInfo.b;
            Fragment fragmentI = FragmentManager.this.c.i(str);
            if (fragmentI != null) {
                fragmentI.H6(i, activityResult.getResultCode(), activityResult.getData());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    class j implements InterfaceC17517n6 {
        j() {
        }

        @Override // ir.nasim.InterfaceC17517n6
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.I.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfo.a;
            int i = launchedFragmentInfo.b;
            Fragment fragmentI = FragmentManager.this.c.i(str);
            if (fragmentI != null) {
                fragmentI.H6(i, activityResult.getResultCode(), activityResult.getData());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    static class k extends AbstractC18108o6 {
        k() {
        }

        @Override // ir.nasim.AbstractC18108o6
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent fillInIntent = intentSenderRequest.getFillInIntent();
            if (fillInIntent != null && (bundleExtra = fillInIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                fillInIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (fillInIntent.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.getIntentSender()).b(null).c(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // ir.nasim.AbstractC18108o6
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public static abstract class l {
        public void a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void d(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void e(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void f(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void g(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void h(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void i(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void j(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void k(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void l(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void n(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    private static class m implements InterfaceC13295fz2 {
        private final androidx.lifecycle.j a;
        private final InterfaceC13295fz2 b;
        private final androidx.lifecycle.n c;

        m(androidx.lifecycle.j jVar, InterfaceC13295fz2 interfaceC13295fz2, androidx.lifecycle.n nVar) {
            this.a = jVar;
            this.b = interfaceC13295fz2;
            this.c = nVar;
        }

        @Override // ir.nasim.InterfaceC13295fz2
        public void a(String str, Bundle bundle) {
            this.b.a(str, bundle);
        }

        public boolean b(j.b bVar) {
            return this.a.b().j(bVar);
        }

        public void c() {
            this.a.d(this.c);
        }
    }

    interface o {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    private class p implements o {
        final String a;
        final int b;
        final int c;

        p(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.o
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = FragmentManager.this.A;
            if (fragment == null || this.b >= 0 || this.a != null || !fragment.F5().m1()) {
                return FragmentManager.this.p1(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    class q implements o {
        q() {
        }

        @Override // androidx.fragment.app.FragmentManager.o
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            boolean zQ1 = FragmentManager.this.q1(arrayList, arrayList2);
            if (!FragmentManager.this.o.isEmpty() && arrayList.size() > 0) {
                boolean zBooleanValue = ((Boolean) arrayList2.get(arrayList.size() - 1)).booleanValue();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(FragmentManager.this.u0((C1957a) it.next()));
                }
                Iterator it2 = FragmentManager.this.o.iterator();
                while (it2.hasNext()) {
                    n nVar = (n) it2.next();
                    Iterator it3 = linkedHashSet.iterator();
                    while (it3.hasNext()) {
                        nVar.b((Fragment) it3.next(), zBooleanValue);
                    }
                }
            }
            return zQ1;
        }
    }

    private Set A() {
        HashSet hashSet = new HashSet();
        Iterator it = this.c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((u) it.next()).k().A0;
            if (viewGroup != null) {
                hashSet.add(F.v(viewGroup, I0()));
            }
        }
        return hashSet;
    }

    private ViewGroup A0(Fragment fragment) {
        ViewGroup viewGroup = fragment.A0;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.A > 0 && this.y.i()) {
            View viewH = this.y.h(fragment.A);
            if (viewH instanceof ViewGroup) {
                return (ViewGroup) viewH;
            }
        }
        return null;
    }

    static int B1(int i2) {
        int i3 = 4097;
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 8194) {
            i3 = 8197;
            if (i2 == 8197) {
                return LexerCore.IPV6;
            }
            if (i2 == 4099) {
                return 4099;
            }
            if (i2 != 4100) {
                return 0;
            }
        }
        return i3;
    }

    static Fragment K0(View view) {
        Object tag = view.getTag(AC5.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void K1(Fragment fragment) {
        ViewGroup viewGroupA0 = A0(fragment);
        if (viewGroupA0 == null || fragment.H5() + fragment.K5() + fragment.X5() + fragment.Y5() <= 0) {
            return;
        }
        if (viewGroupA0.getTag(AC5.visible_removing_fragment_view_tag) == null) {
            viewGroupA0.setTag(AC5.visible_removing_fragment_view_tag, fragment);
        }
        ((Fragment) viewGroupA0.getTag(AC5.visible_removing_fragment_view_tag)).g8(fragment.W5());
    }

    private void M1() {
        Iterator it = this.c.k().iterator();
        while (it.hasNext()) {
            j1((u) it.next());
        }
    }

    private void N1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C("FragmentManager"));
        androidx.fragment.app.p pVar = this.x;
        if (pVar != null) {
            try {
                pVar.p("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            d0("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    private void P1() {
        synchronized (this.a) {
            try {
                if (!this.a.isEmpty()) {
                    this.j.j(true);
                    if (Q0(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z = w0() > 0 && V0(this.z);
                if (Q0(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z);
                }
                this.j.j(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean Q0(int i2) {
        return U || Log.isLoggable("FragmentManager", i2);
    }

    private boolean R0(Fragment fragment) {
        return (fragment.Y && fragment.Z) || fragment.x.u();
    }

    private void S(Fragment fragment) {
        if (fragment == null || !fragment.equals(m0(fragment.f))) {
            return;
        }
        fragment.F7();
    }

    private boolean S0() {
        Fragment fragment = this.z;
        if (fragment == null) {
            return true;
        }
        return fragment.u6() && this.z.V5().S0();
    }

    private void Z(int i2) {
        try {
            this.b = true;
            this.c.d(i2);
            g1(i2, false);
            Iterator it = A().iterator();
            while (it.hasNext()) {
                ((F) it.next()).q();
            }
            this.b = false;
            h0(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0() {
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((n) it.next()).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a1(Configuration configuration) {
        if (S0()) {
            G(configuration, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(Integer num) {
        if (S0() && num.intValue() == 80) {
            M(false);
        }
    }

    private void c0() {
        if (this.N) {
            this.N = false;
            M1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(C6665Ol4 c6665Ol4) {
        if (S0()) {
            N(c6665Ol4.a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1(C17236md5 c17236md5) {
        if (S0()) {
            U(c17236md5.a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        Iterator it = A().iterator();
        while (it.hasNext()) {
            ((F) it.next()).q();
        }
    }

    private void g0(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.x == null) {
            if (!this.M) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.x.n().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            v();
        }
        if (this.O == null) {
            this.O = new ArrayList();
            this.P = new ArrayList();
        }
    }

    private static void j0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        while (i2 < i3) {
            C1957a c1957a = (C1957a) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                c1957a.y(-1);
                c1957a.E();
            } else {
                c1957a.y(1);
                c1957a.D();
            }
            i2++;
        }
    }

    private void k0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        boolean z = ((C1957a) arrayList.get(i2)).r;
        ArrayList arrayList3 = this.Q;
        if (arrayList3 == null) {
            this.Q = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.Q.addAll(this.c.o());
        Fragment fragmentH0 = H0();
        boolean z2 = false;
        for (int i4 = i2; i4 < i3; i4++) {
            C1957a c1957a = (C1957a) arrayList.get(i4);
            fragmentH0 = !((Boolean) arrayList2.get(i4)).booleanValue() ? c1957a.F(this.Q, fragmentH0) : c1957a.I(this.Q, fragmentH0);
            z2 = z2 || c1957a.i;
        }
        this.Q.clear();
        if (!z && this.w >= 1) {
            for (int i5 = i2; i5 < i3; i5++) {
                Iterator it = ((C1957a) arrayList.get(i5)).c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((x.a) it.next()).b;
                    if (fragment != null && fragment.v != null) {
                        this.c.r(C(fragment));
                    }
                }
            }
        }
        j0(arrayList, arrayList2, i2, i3);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
        if (z2 && !this.o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(u0((C1957a) it2.next()));
            }
            if (this.h == null) {
                Iterator it3 = this.o.iterator();
                while (it3.hasNext()) {
                    n nVar = (n) it3.next();
                    Iterator it4 = linkedHashSet.iterator();
                    while (it4.hasNext()) {
                        nVar.b((Fragment) it4.next(), zBooleanValue);
                    }
                }
                Iterator it5 = this.o.iterator();
                while (it5.hasNext()) {
                    n nVar2 = (n) it5.next();
                    Iterator it6 = linkedHashSet.iterator();
                    while (it6.hasNext()) {
                        nVar2.a((Fragment) it6.next(), zBooleanValue);
                    }
                }
            }
        }
        for (int i6 = i2; i6 < i3; i6++) {
            C1957a c1957a2 = (C1957a) arrayList.get(i6);
            if (zBooleanValue) {
                for (int size = c1957a2.c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = ((x.a) c1957a2.c.get(size)).b;
                    if (fragment2 != null) {
                        C(fragment2).m();
                    }
                }
            } else {
                Iterator it7 = c1957a2.c.iterator();
                while (it7.hasNext()) {
                    Fragment fragment3 = ((x.a) it7.next()).b;
                    if (fragment3 != null) {
                        C(fragment3).m();
                    }
                }
            }
        }
        g1(this.w, true);
        for (F f2 : B(arrayList, i2, i3)) {
            f2.D(zBooleanValue);
            f2.z();
            f2.n();
        }
        while (i2 < i3) {
            C1957a c1957a3 = (C1957a) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue() && c1957a3.v >= 0) {
                c1957a3.v = -1;
            }
            c1957a3.H();
            i2++;
        }
        if (z2) {
            z1();
        }
    }

    private int n0(String str, int i2, boolean z) {
        if (this.d.isEmpty()) {
            return -1;
        }
        if (str == null && i2 < 0) {
            if (z) {
                return 0;
            }
            return this.d.size() - 1;
        }
        int size = this.d.size() - 1;
        while (size >= 0) {
            C1957a c1957a = (C1957a) this.d.get(size);
            if ((str != null && str.equals(c1957a.G())) || (i2 >= 0 && i2 == c1957a.v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z) {
            if (size == this.d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            C1957a c1957a2 = (C1957a) this.d.get(size - 1);
            if ((str == null || !str.equals(c1957a2.G())) && (i2 < 0 || i2 != c1957a2.v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    private boolean o1(String str, int i2, int i3) {
        h0(false);
        g0(true);
        Fragment fragment = this.A;
        if (fragment != null && i2 < 0 && str == null && fragment.F5().m1()) {
            return true;
        }
        boolean zP1 = p1(this.O, this.P, str, i2, i3);
        if (zP1) {
            this.b = true;
            try {
                x1(this.O, this.P);
            } finally {
                w();
            }
        }
        P1();
        c0();
        this.c.b();
        return zP1;
    }

    public static FragmentManager r0(View view) {
        FragmentActivity fragmentActivity;
        Fragment fragmentS0 = s0(view);
        if (fragmentS0 != null) {
            if (fragmentS0.u6()) {
                return fragmentS0.F5();
            }
            throw new IllegalStateException("The Fragment " + fragmentS0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                fragmentActivity = null;
                break;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.B0();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    static Fragment s0(View view) {
        while (view != null) {
            Fragment fragmentK0 = K0(view);
            if (fragmentK0 != null) {
                return fragmentK0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void t0() {
        Iterator it = A().iterator();
        while (it.hasNext()) {
            ((F) it.next()).r();
        }
    }

    private void v() {
        if (X0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private boolean v0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return false;
            }
            try {
                int size = this.a.size();
                boolean zA = false;
                for (int i2 = 0; i2 < size; i2++) {
                    zA |= ((o) this.a.get(i2)).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.a.clear();
                this.x.n().removeCallbacks(this.T);
            }
        }
    }

    private void w() {
        this.b = false;
        this.P.clear();
        this.O.clear();
    }

    private void x() {
        androidx.fragment.app.p pVar = this.x;
        if (pVar instanceof InterfaceC15408jX7 ? this.c.p().Z0() : pVar.k() instanceof Activity ? !((Activity) this.x.k()).isChangingConfigurations() : true) {
            Iterator it = this.l.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((BackStackState) it.next()).a.iterator();
                while (it2.hasNext()) {
                    this.c.p().S0((String) it2.next(), false);
                }
            }
        }
    }

    private t x0(Fragment fragment) {
        return this.R.V0(fragment);
    }

    private void x1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!((C1957a) arrayList.get(i2)).r) {
                if (i3 != i2) {
                    k0(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((C1957a) arrayList.get(i3)).r) {
                        i3++;
                    }
                }
                k0(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            k0(arrayList, arrayList2, i3, size);
        }
    }

    private void z1() {
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            ((n) this.o.get(i2)).e();
        }
    }

    void A1(Parcelable parcelable) {
        u uVar;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.x.k().getClassLoader());
                this.m.put(str.substring(7), bundle2);
            }
        }
        HashMap map = new HashMap();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.x.k().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.c.x(map);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        this.c.v();
        Iterator it = fragmentManagerState.a.iterator();
        while (it.hasNext()) {
            Bundle bundleB = this.c.B((String) it.next(), null);
            if (bundleB != null) {
                Fragment fragmentU0 = this.R.U0(((FragmentState) bundleB.getParcelable("state")).b);
                if (fragmentU0 != null) {
                    if (Q0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentU0);
                    }
                    uVar = new u(this.p, this.c, fragmentU0, bundleB);
                } else {
                    uVar = new u(this.p, this.c, this.x.k().getClassLoader(), B0(), bundleB);
                }
                Fragment fragmentK = uVar.k();
                fragmentK.b = bundleB;
                fragmentK.v = this;
                if (Q0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentK.f + "): " + fragmentK);
                }
                uVar.o(this.x.k().getClassLoader());
                this.c.r(uVar);
                uVar.t(this.w);
            }
        }
        for (Fragment fragment : this.R.X0()) {
            if (!this.c.c(fragment.f)) {
                if (Q0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.a);
                }
                this.R.a1(fragment);
                fragment.v = this;
                u uVar2 = new u(this.p, this.c, fragment);
                uVar2.t(1);
                uVar2.m();
                fragment.m = true;
                uVar2.m();
            }
        }
        this.c.w(fragmentManagerState.b);
        if (fragmentManagerState.c != null) {
            this.d = new ArrayList(fragmentManagerState.c.length);
            int i2 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.c;
                if (i2 >= backStackRecordStateArr.length) {
                    break;
                }
                C1957a c1957aB = backStackRecordStateArr[i2].b(this);
                if (Q0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + c1957aB.v + "): " + c1957aB);
                    PrintWriter printWriter = new PrintWriter(new C("FragmentManager"));
                    c1957aB.C("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(c1957aB);
                i2++;
            }
        } else {
            this.d = new ArrayList();
        }
        this.k.set(fragmentManagerState.d);
        String str3 = fragmentManagerState.e;
        if (str3 != null) {
            Fragment fragmentM0 = m0(str3);
            this.A = fragmentM0;
            S(fragmentM0);
        }
        ArrayList arrayList = fragmentManagerState.f;
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                this.l.put((String) arrayList.get(i3), (BackStackState) fragmentManagerState.g.get(i3));
            }
        }
        this.I = new ArrayDeque(fragmentManagerState.h);
    }

    Set B(ArrayList arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator it = ((C1957a) arrayList.get(i2)).c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((x.a) it.next()).b;
                if (fragment != null && (viewGroup = fragment.A0) != null) {
                    hashSet.add(F.u(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    public androidx.fragment.app.o B0() {
        androidx.fragment.app.o oVar = this.B;
        if (oVar != null) {
            return oVar;
        }
        Fragment fragment = this.z;
        return fragment != null ? fragment.v.B0() : this.C;
    }

    u C(Fragment fragment) {
        u uVarN = this.c.n(fragment.f);
        if (uVarN != null) {
            return uVarN;
        }
        u uVar = new u(this.p, this.c, fragment);
        uVar.o(this.x.k().getClassLoader());
        uVar.t(this.w);
        return uVar;
    }

    public List C0() {
        return this.c.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public Bundle Y0() {
        BackStackRecordState[] backStackRecordStateArr;
        Bundle bundle = new Bundle();
        t0();
        e0();
        h0(true);
        this.K = true;
        this.R.b1(true);
        ArrayList arrayListY = this.c.y();
        HashMap mapM = this.c.m();
        if (!mapM.isEmpty()) {
            ArrayList arrayListZ = this.c.z();
            int size = this.d.size();
            if (size > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i2 = 0; i2 < size; i2++) {
                    backStackRecordStateArr[i2] = new BackStackRecordState((C1957a) this.d.get(i2));
                    if (Q0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.d.get(i2));
                    }
                }
            } else {
                backStackRecordStateArr = null;
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.a = arrayListY;
            fragmentManagerState.b = arrayListZ;
            fragmentManagerState.c = backStackRecordStateArr;
            fragmentManagerState.d = this.k.get();
            Fragment fragment = this.A;
            if (fragment != null) {
                fragmentManagerState.e = fragment.f;
            }
            fragmentManagerState.f.addAll(this.l.keySet());
            fragmentManagerState.g.addAll(this.l.values());
            fragmentManagerState.h = new ArrayList(this.I);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.m.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.m.get(str));
            }
            for (String str2 : mapM.keySet()) {
                bundle.putBundle("fragment_" + str2, (Bundle) mapM.get(str2));
            }
        } else if (Q0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    void D(Fragment fragment) {
        if (Q0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.G) {
            return;
        }
        fragment.G = true;
        if (fragment.l) {
            if (Q0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.c.u(fragment);
            if (R0(fragment)) {
                this.J = true;
            }
            K1(fragment);
        }
    }

    public androidx.fragment.app.p D0() {
        return this.x;
    }

    public Fragment.SavedState D1(Fragment fragment) {
        u uVarN = this.c.n(fragment.f);
        if (uVarN == null || !uVarN.k().equals(fragment)) {
            N1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return uVarN.q();
    }

    void E() {
        this.K = false;
        this.L = false;
        this.R.b1(false);
        Z(4);
    }

    LayoutInflater.Factory2 E0() {
        return this.f;
    }

    void E1() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.x.n().removeCallbacks(this.T);
                    this.x.n().post(this.T);
                    P1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void F() {
        this.K = false;
        this.L = false;
        this.R.b1(false);
        Z(0);
    }

    r F0() {
        return this.p;
    }

    void F1(Fragment fragment, boolean z) {
        ViewGroup viewGroupA0 = A0(fragment);
        if (viewGroupA0 == null || !(viewGroupA0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupA0).setDrawDisappearingViewsLast(!z);
    }

    void G(Configuration configuration, boolean z) {
        if (z && (this.x instanceof YI4)) {
            N1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.p7(configuration);
                if (z) {
                    fragment.x.G(configuration, true);
                }
            }
        }
    }

    Fragment G0() {
        return this.z;
    }

    public final void G1(String str, Bundle bundle) {
        m mVar = (m) this.n.get(str);
        if (mVar == null || !mVar.b(j.b.STARTED)) {
            this.m.put(str, bundle);
        } else {
            mVar.a(str, bundle);
        }
        if (Q0(2)) {
            Log.v("FragmentManager", "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    boolean H(MenuItem menuItem) {
        if (this.w < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && fragment.q7(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Fragment H0() {
        return this.A;
    }

    public final void H1(String str, InterfaceC18633oz3 interfaceC18633oz3, InterfaceC13295fz2 interfaceC13295fz2) {
        androidx.lifecycle.j lifecycle = interfaceC18633oz3.getLifecycle();
        if (lifecycle.b() == j.b.DESTROYED) {
            return;
        }
        g gVar = new g(str, interfaceC13295fz2, lifecycle);
        m mVar = (m) this.n.put(str, new m(lifecycle, interfaceC13295fz2, gVar));
        if (mVar != null) {
            mVar.c();
        }
        if (Q0(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + interfaceC13295fz2);
        }
        lifecycle.a(gVar);
    }

    void I() {
        this.K = false;
        this.L = false;
        this.R.b1(false);
        Z(1);
    }

    G I0() {
        G g2 = this.D;
        if (g2 != null) {
            return g2;
        }
        Fragment fragment = this.z;
        return fragment != null ? fragment.v.I0() : this.E;
    }

    void I1(Fragment fragment, j.b bVar) {
        if (fragment.equals(m0(fragment.f)) && (fragment.w == null || fragment.v == this)) {
            fragment.L0 = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    boolean J(Menu menu, MenuInflater menuInflater) {
        if (this.w < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && U0(fragment) && fragment.s7(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = (Fragment) this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.S6();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public C4404Ez2.c J0() {
        return this.S;
    }

    void J1(Fragment fragment) {
        if (fragment == null || (fragment.equals(m0(fragment.f)) && (fragment.w == null || fragment.v == this))) {
            Fragment fragment2 = this.A;
            this.A = fragment;
            S(fragment2);
            S(this.A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void K() {
        this.M = true;
        h0(true);
        e0();
        x();
        Z(-1);
        Object obj = this.x;
        if (obj instanceof InterfaceC15879kK4) {
            ((InterfaceC15879kK4) obj).l(this.s);
        }
        Object obj2 = this.x;
        if (obj2 instanceof YI4) {
            ((YI4) obj2).o(this.r);
        }
        Object obj3 = this.x;
        if (obj3 instanceof DJ4) {
            ((DJ4) obj3).c(this.t);
        }
        Object obj4 = this.x;
        if (obj4 instanceof OJ4) {
            ((OJ4) obj4).w(this.u);
        }
        Object obj5 = this.x;
        if ((obj5 instanceof InterfaceC17502n44) && this.z == null) {
            ((InterfaceC17502n44) obj5).e(this.v);
        }
        this.x = null;
        this.y = null;
        this.z = null;
        if (this.g != null) {
            this.j.h();
            this.g = null;
        }
        AbstractC22357v6 abstractC22357v6 = this.F;
        if (abstractC22357v6 != null) {
            abstractC22357v6.c();
            this.G.c();
            this.H.c();
        }
    }

    void L() {
        Z(1);
    }

    C14819iX7 L0(Fragment fragment) {
        return this.R.Y0(fragment);
    }

    void L1(Fragment fragment) {
        if (Q0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.D) {
            fragment.D = false;
            fragment.H0 = !fragment.H0;
        }
    }

    void M(boolean z) {
        if (z && (this.x instanceof InterfaceC15879kK4)) {
            N1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.y7();
                if (z) {
                    fragment.x.M(true);
                }
            }
        }
    }

    void M0() {
        this.i = true;
        h0(true);
        this.i = false;
        if (!V || this.h == null) {
            if (this.j.g()) {
                if (Q0(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                m1();
                return;
            } else {
                if (Q0(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                this.g.l();
                return;
            }
        }
        if (!this.o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(u0(this.h));
            Iterator it = this.o.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    nVar.a((Fragment) it2.next(), true);
                }
            }
        }
        Iterator it3 = this.h.c.iterator();
        while (it3.hasNext()) {
            Fragment fragment = ((x.a) it3.next()).b;
            if (fragment != null) {
                fragment.n = false;
            }
        }
        Iterator it4 = B(new ArrayList(Collections.singletonList(this.h)), 0, 1).iterator();
        while (it4.hasNext()) {
            ((F) it4.next()).f();
        }
        Iterator it5 = this.h.c.iterator();
        while (it5.hasNext()) {
            Fragment fragment2 = ((x.a) it5.next()).b;
            if (fragment2 != null && fragment2.A0 == null) {
                C(fragment2).m();
            }
        }
        this.h = null;
        P1();
        if (Q0(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.j.g() + " for  FragmentManager " + this);
        }
    }

    void N(boolean z, boolean z2) {
        if (z2 && (this.x instanceof DJ4)) {
            N1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.z7(z);
                if (z2) {
                    fragment.x.N(z, true);
                }
            }
        }
    }

    void N0(Fragment fragment) {
        if (Q0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.D) {
            return;
        }
        fragment.D = true;
        fragment.H0 = true ^ fragment.H0;
        K1(fragment);
    }

    void O(Fragment fragment) {
        Iterator it = this.q.iterator();
        while (it.hasNext()) {
            ((InterfaceC7258Qy2) it.next()).d(this, fragment);
        }
    }

    void O0(Fragment fragment) {
        if (fragment.l && R0(fragment)) {
            this.J = true;
        }
    }

    public void O1(l lVar) {
        this.p.p(lVar);
    }

    void P() {
        for (Fragment fragment : this.c.l()) {
            if (fragment != null) {
                fragment.W6(fragment.w6());
                fragment.x.P();
            }
        }
    }

    public boolean P0() {
        return this.M;
    }

    boolean Q(MenuItem menuItem) {
        if (this.w < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && fragment.A7(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void R(Menu menu) {
        if (this.w < 1) {
            return;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.B7(menu);
            }
        }
    }

    void T() {
        Z(5);
    }

    boolean T0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.w6();
    }

    void U(boolean z, boolean z2) {
        if (z2 && (this.x instanceof OJ4)) {
            N1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.D7(z);
                if (z2) {
                    fragment.x.U(z, true);
                }
            }
        }
    }

    boolean U0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.y6();
    }

    boolean V(Menu menu) {
        boolean z = false;
        if (this.w < 1) {
            return false;
        }
        for (Fragment fragment : this.c.o()) {
            if (fragment != null && U0(fragment) && fragment.E7(menu)) {
                z = true;
            }
        }
        return z;
    }

    boolean V0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.v;
        return fragment.equals(fragmentManager.H0()) && V0(fragmentManager.z);
    }

    void W() {
        P1();
        S(this.A);
    }

    boolean W0(int i2) {
        return this.w >= i2;
    }

    void X() {
        this.K = false;
        this.L = false;
        this.R.b1(false);
        Z(7);
    }

    public boolean X0() {
        return this.K || this.L;
    }

    void Y() {
        this.K = false;
        this.L = false;
        this.R.b1(false);
        Z(5);
    }

    void a0() {
        this.L = true;
        this.R.b1(true);
        Z(4);
    }

    void b0() {
        Z(2);
    }

    public void d0(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = (Fragment) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        int size2 = this.d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size2; i3++) {
                C1957a c1957a = (C1957a) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(c1957a.toString());
                c1957a.B(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.k.get());
        synchronized (this.a) {
            try {
                int size3 = this.a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size3; i4++) {
                        o oVar = (o) this.a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(oVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.y);
        if (this.z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.K);
        printWriter.print(" mStopped=");
        printWriter.print(this.L);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.M);
        if (this.J) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.J);
        }
    }

    void e1(Fragment fragment, String[] strArr, int i2) {
        if (this.H == null) {
            this.x.s(fragment, strArr, i2);
            return;
        }
        this.I.addLast(new LaunchedFragmentInfo(fragment.f, i2));
        this.H.a(strArr);
    }

    void f0(o oVar, boolean z) {
        if (!z) {
            if (this.x == null) {
                if (!this.M) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            v();
        }
        synchronized (this.a) {
            try {
                if (this.x == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(oVar);
                    E1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void f1(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (this.F == null) {
            this.x.v(fragment, intent, i2, bundle);
            return;
        }
        this.I.addLast(new LaunchedFragmentInfo(fragment.f, i2));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.F.a(intent);
    }

    void g1(int i2, boolean z) {
        androidx.fragment.app.p pVar;
        if (this.x == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.w) {
            this.w = i2;
            this.c.t();
            M1();
            if (this.J && (pVar = this.x) != null && this.w == 7) {
                pVar.x();
                this.J = false;
            }
        }
    }

    boolean h0(boolean z) {
        C1957a c1957a;
        g0(z);
        boolean z2 = false;
        if (!this.i && (c1957a = this.h) != null) {
            c1957a.u = false;
            c1957a.z();
            if (Q0(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h + " as part of execPendingActions for actions " + this.a);
            }
            this.h.A(false, false);
            this.a.add(0, this.h);
            Iterator it = this.h.c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((x.a) it.next()).b;
                if (fragment != null) {
                    fragment.n = false;
                }
            }
            this.h = null;
        }
        while (v0(this.O, this.P)) {
            z2 = true;
            this.b = true;
            try {
                x1(this.O, this.P);
            } finally {
                w();
            }
        }
        P1();
        c0();
        this.c.b();
        return z2;
    }

    void h1() {
        if (this.x == null) {
            return;
        }
        this.K = false;
        this.L = false;
        this.R.b1(false);
        for (Fragment fragment : this.c.o()) {
            if (fragment != null) {
                fragment.F6();
            }
        }
    }

    void i0(o oVar, boolean z) {
        if (z && (this.x == null || this.M)) {
            return;
        }
        g0(z);
        C1957a c1957a = this.h;
        boolean z2 = false;
        if (c1957a != null) {
            c1957a.u = false;
            c1957a.z();
            if (Q0(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.h + " as part of execSingleAction for action " + oVar);
            }
            this.h.A(false, false);
            boolean zA = this.h.a(this.O, this.P);
            Iterator it = this.h.c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((x.a) it.next()).b;
                if (fragment != null) {
                    fragment.n = false;
                }
            }
            this.h = null;
            z2 = zA;
        }
        boolean zA2 = oVar.a(this.O, this.P);
        if (z2 || zA2) {
            this.b = true;
            try {
                x1(this.O, this.P);
            } finally {
                w();
            }
        }
        P1();
        c0();
        this.c.b();
    }

    public final void i1(FragmentContainerView fragmentContainerView) {
        View view;
        for (u uVar : this.c.k()) {
            Fragment fragmentK = uVar.k();
            if (fragmentK.A == fragmentContainerView.getId() && (view = fragmentK.B0) != null && view.getParent() == null) {
                fragmentK.A0 = fragmentContainerView;
                uVar.b();
                uVar.m();
            }
        }
    }

    void j1(u uVar) {
        Fragment fragmentK = uVar.k();
        if (fragmentK.C0) {
            if (this.b) {
                this.N = true;
            } else {
                fragmentK.C0 = false;
                uVar.m();
            }
        }
    }

    void k(C1957a c1957a) {
        this.d.add(c1957a);
    }

    public void k1() {
        f0(new p(null, -1, 0), false);
    }

    u l(Fragment fragment) {
        String str = fragment.K0;
        if (str != null) {
            C4404Ez2.f(fragment, str);
        }
        if (Q0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        u uVarC = C(fragment);
        fragment.v = this;
        this.c.r(uVarC);
        if (!fragment.G) {
            this.c.a(fragment);
            fragment.m = false;
            if (fragment.B0 == null) {
                fragment.H0 = false;
            }
            if (R0(fragment)) {
                this.J = true;
            }
        }
        return uVarC;
    }

    public boolean l0() {
        boolean zH0 = h0(true);
        t0();
        return zH0;
    }

    void l1(int i2, int i3, boolean z) {
        if (i2 >= 0) {
            f0(new p(null, i2, i3), z);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public void m(InterfaceC7258Qy2 interfaceC7258Qy2) {
        this.q.add(interfaceC7258Qy2);
    }

    Fragment m0(String str) {
        return this.c.f(str);
    }

    public boolean m1() {
        return o1(null, -1, 0);
    }

    public void n(n nVar) {
        this.o.add(nVar);
    }

    public boolean n1(int i2, int i3) {
        if (i2 >= 0) {
            return o1(null, i2, i3);
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    void o(Fragment fragment) {
        this.R.P0(fragment);
    }

    public Fragment o0(int i2) {
        return this.c.g(i2);
    }

    int p() {
        return this.k.getAndIncrement();
    }

    public Fragment p0(String str) {
        return this.c.h(str);
    }

    boolean p1(ArrayList arrayList, ArrayList arrayList2, String str, int i2, int i3) {
        int iN0 = n0(str, i2, (i3 & 1) != 0);
        if (iN0 < 0) {
            return false;
        }
        for (int size = this.d.size() - 1; size >= iN0; size--) {
            arrayList.add((C1957a) this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void q(androidx.fragment.app.p pVar, AbstractC6771Ox2 abstractC6771Ox2, Fragment fragment) {
        String str;
        if (this.x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.x = pVar;
        this.y = abstractC6771Ox2;
        this.z = fragment;
        if (fragment != null) {
            m(new h(fragment));
        } else if (pVar instanceof InterfaceC7258Qy2) {
            m((InterfaceC7258Qy2) pVar);
        }
        if (this.z != null) {
            P1();
        }
        if (pVar instanceof AI4) {
            AI4 ai4 = (AI4) pVar;
            C23660xI4 c23660xI4Z2 = ai4.z2();
            this.g = c23660xI4Z2;
            InterfaceC18633oz3 interfaceC18633oz3 = ai4;
            if (fragment != null) {
                interfaceC18633oz3 = fragment;
            }
            c23660xI4Z2.h(interfaceC18633oz3, this.j);
        }
        if (fragment != null) {
            this.R = fragment.v.x0(fragment);
        } else if (pVar instanceof InterfaceC15408jX7) {
            this.R = t.W0(((InterfaceC15408jX7) pVar).d1());
        } else {
            this.R = new t(false);
        }
        this.R.b1(X0());
        this.c.A(this.R);
        Object obj = this.x;
        if ((obj instanceof InterfaceC7760Tb6) && fragment == null) {
            C7289Rb6 c7289Rb6V1 = ((InterfaceC7760Tb6) obj).v1();
            c7289Rb6V1.h("android:support:fragments", new C7289Rb6.c() { // from class: ir.nasim.uy2
                @Override // ir.nasim.C7289Rb6.c
                public final Bundle b() {
                    return this.a.Y0();
                }
            });
            Bundle bundleB = c7289Rb6V1.b("android:support:fragments");
            if (bundleB != null) {
                A1(bundleB);
            }
        }
        Object obj2 = this.x;
        if (obj2 instanceof B6) {
            AbstractC24133y6 abstractC24133y6F = ((B6) obj2).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.f + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.F = abstractC24133y6F.l(str2 + "StartActivityForResult", new C20490s6(), new i());
            this.G = abstractC24133y6F.l(str2 + "StartIntentSenderForResult", new k(), new j());
            this.H = abstractC24133y6F.l(str2 + "RequestPermissions", new C19290q6(), new a());
        }
        Object obj3 = this.x;
        if (obj3 instanceof YI4) {
            ((YI4) obj3).B(this.r);
        }
        Object obj4 = this.x;
        if (obj4 instanceof InterfaceC15879kK4) {
            ((InterfaceC15879kK4) obj4).b(this.s);
        }
        Object obj5 = this.x;
        if (obj5 instanceof DJ4) {
            ((DJ4) obj5).a(this.t);
        }
        Object obj6 = this.x;
        if (obj6 instanceof OJ4) {
            ((OJ4) obj6).t(this.u);
        }
        Object obj7 = this.x;
        if ((obj7 instanceof InterfaceC17502n44) && fragment == null) {
            ((InterfaceC17502n44) obj7).C(this.v);
        }
    }

    Fragment q0(String str) {
        return this.c.i(str);
    }

    boolean q1(ArrayList arrayList, ArrayList arrayList2) {
        if (Q0(2)) {
            Log.v("FragmentManager", "FragmentManager has the following pending actions inside of prepareBackStackState: " + this.a);
        }
        if (this.d.isEmpty()) {
            Log.i("FragmentManager", "Ignoring call to start back stack pop because the back stack is empty.");
            return false;
        }
        ArrayList arrayList3 = this.d;
        C1957a c1957a = (C1957a) arrayList3.get(arrayList3.size() - 1);
        this.h = c1957a;
        Iterator it = c1957a.c.iterator();
        while (it.hasNext()) {
            Fragment fragment = ((x.a) it.next()).b;
            if (fragment != null) {
                fragment.n = true;
            }
        }
        return p1(arrayList, arrayList2, null, -1, 0);
    }

    void r(Fragment fragment) {
        if (Q0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.G) {
            fragment.G = false;
            if (fragment.l) {
                return;
            }
            this.c.a(fragment);
            if (Q0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (R0(fragment)) {
                this.J = true;
            }
        }
    }

    void r1() {
        f0(new q(), false);
    }

    public x s() {
        return new C1957a(this);
    }

    public void s1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.v != this) {
            N1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.f);
    }

    void t() {
        if (Q0(3)) {
            Log.d("FragmentManager", "cancelBackStackTransition for transition " + this.h);
        }
        C1957a c1957a = this.h;
        if (c1957a != null) {
            c1957a.u = false;
            c1957a.z();
            this.h.s(true, new Runnable() { // from class: ir.nasim.vy2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.Z0();
                }
            });
            this.h.h();
            this.i = true;
            l0();
            this.i = false;
            this.h = null;
        }
    }

    public void t1(l lVar, boolean z) {
        this.p.o(lVar, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.z;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.z)));
            sb.append("}");
        } else {
            androidx.fragment.app.p pVar = this.x;
            if (pVar != null) {
                sb.append(pVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.x)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    boolean u() {
        boolean zR0 = false;
        for (Fragment fragment : this.c.l()) {
            if (fragment != null) {
                zR0 = R0(fragment);
            }
            if (zR0) {
                return true;
            }
        }
        return false;
    }

    Set u0(C1957a c1957a) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < c1957a.c.size(); i2++) {
            Fragment fragment = ((x.a) c1957a.c.get(i2)).b;
            if (fragment != null && c1957a.i) {
                hashSet.add(fragment);
            }
        }
        return hashSet;
    }

    void u1(Fragment fragment) {
        if (Q0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.u);
        }
        boolean z = !fragment.x6();
        if (!fragment.G || z) {
            this.c.u(fragment);
            if (R0(fragment)) {
                this.J = true;
            }
            fragment.m = true;
            K1(fragment);
        }
    }

    public void v1(InterfaceC7258Qy2 interfaceC7258Qy2) {
        this.q.remove(interfaceC7258Qy2);
    }

    public int w0() {
        return this.d.size() + (this.h != null ? 1 : 0);
    }

    public void w1(n nVar) {
        this.o.remove(nVar);
    }

    public final void y(String str) {
        this.m.remove(str);
        if (Q0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    AbstractC6771Ox2 y0() {
        return this.y;
    }

    void y1(Fragment fragment) {
        this.R.a1(fragment);
    }

    public final void z(String str) {
        m mVar = (m) this.n.remove(str);
        if (mVar != null) {
            mVar.c();
        }
        if (Q0(2)) {
            Log.v("FragmentManager", "Clearing FragmentResultListener for key " + str);
        }
    }

    public Fragment z0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentM0 = m0(string);
        if (fragmentM0 == null) {
            N1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentM0;
    }

    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();
        String a;
        int b;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i) {
                return new LaunchedFragmentInfo[i];
            }
        }

        LaunchedFragmentInfo(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeInt(this.b);
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readInt();
        }
    }

    public interface n {
        default void a(Fragment fragment, boolean z) {
        }

        default void b(Fragment fragment, boolean z) {
        }

        default void d() {
        }

        void e();

        default void c(TV tv) {
        }
    }
}
