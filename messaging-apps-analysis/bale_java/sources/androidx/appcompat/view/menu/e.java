package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.J5;
import ir.nasim.W17;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class e implements W17 {
    private static final int[] A = {1, 4, 5, 3, 2, 0};
    private final Context a;
    private final Resources b;
    private boolean c;
    private boolean d;
    private a e;
    private ContextMenu.ContextMenuInfo m;
    CharSequence n;
    Drawable o;
    View p;
    private g x;
    private boolean z;
    private int l = 0;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private ArrayList v = new ArrayList();
    private CopyOnWriteArrayList w = new CopyOnWriteArrayList();
    private boolean y = false;
    private ArrayList f = new ArrayList();
    private ArrayList g = new ArrayList();
    private boolean h = true;
    private ArrayList i = new ArrayList();
    private ArrayList j = new ArrayList();
    private boolean k = true;

    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    public interface b {
        boolean d(g gVar);
    }

    public e(Context context) {
        this.a = context;
        this.b = context.getResources();
        f0(true);
    }

    private static int D(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = A;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void P(int i, boolean z) {
        if (i < 0 || i >= this.f.size()) {
            return;
        }
        this.f.remove(i);
        if (z) {
            M(true);
        }
    }

    private void a0(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resourcesE = E();
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i > 0) {
                this.n = resourcesE.getText(i);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i2 > 0) {
                this.o = AbstractC4043Dl1.f(w(), i2);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        M(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.a
            boolean r3 = ir.nasim.AbstractC20736sW7.l(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.f0(boolean):void");
    }

    private g g(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new g(this, i, i2, i3, i4, charSequence, i5);
    }

    private void i(boolean z) {
        if (this.w.isEmpty()) {
            return;
        }
        h0();
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.w.remove(weakReference);
            } else {
                jVar.i(z);
            }
        }
        g0();
    }

    private void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.w.isEmpty()) {
            return;
        }
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.w.remove(weakReference);
            } else {
                int id = jVar.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    jVar.f(parcelable);
                }
            }
        }
    }

    private void k(Bundle bundle) {
        Parcelable parcelableH;
        if (this.w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.w.remove(weakReference);
            } else {
                int id = jVar.getId();
                if (id > 0 && (parcelableH = jVar.h()) != null) {
                    sparseArray.put(id, parcelableH);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    private boolean l(m mVar, j jVar) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean zG = jVar != null ? jVar.g(mVar) : false;
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null) {
                this.w.remove(weakReference);
            } else if (!zG) {
                zG = jVar2.g(mVar);
            }
        }
        return zG;
    }

    private static int p(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((g) arrayList.get(size)).f() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.p;
    }

    public ArrayList B() {
        t();
        return this.j;
    }

    boolean C() {
        return this.t;
    }

    Resources E() {
        return this.b;
    }

    public e F() {
        return this;
    }

    public ArrayList G() {
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            g gVar = (g) this.f.get(i);
            if (gVar.isVisible()) {
                this.g.add(gVar);
            }
        }
        this.h = false;
        this.k = true;
        return this.g;
    }

    public boolean H() {
        return this.y;
    }

    boolean I() {
        return this.c;
    }

    public boolean J() {
        return this.d;
    }

    void K(g gVar) {
        this.k = true;
        M(true);
    }

    void L(g gVar) {
        this.h = true;
        M(true);
    }

    public void M(boolean z) {
        if (this.q) {
            this.r = true;
            if (z) {
                this.s = true;
                return;
            }
            return;
        }
        if (z) {
            this.h = true;
            this.k = true;
        }
        i(z);
    }

    public boolean N(MenuItem menuItem, int i) {
        return O(menuItem, null, i);
    }

    public boolean O(MenuItem menuItem, j jVar, int i) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean zK = gVar.k();
        J5 j5A = gVar.a();
        boolean z = j5A != null && j5A.a();
        if (gVar.j()) {
            zK |= gVar.expandActionView();
            if (zK) {
                e(true);
            }
        } else if (gVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                e(false);
            }
            if (!gVar.hasSubMenu()) {
                gVar.x(new m(w(), this, gVar));
            }
            m mVar = (m) gVar.getSubMenu();
            if (z) {
                j5A.e(mVar);
            }
            zK |= l(mVar, jVar);
            if (!zK) {
                e(true);
            }
        } else if ((i & 1) == 0) {
            e(true);
        }
        return zK;
    }

    public void Q(j jVar) {
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.w.remove(weakReference);
            }
        }
    }

    public void R(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(v());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).R(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void S(Bundle bundle) {
        j(bundle);
    }

    public void T(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).T(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void U(Bundle bundle) {
        k(bundle);
    }

    public void V(a aVar) {
        this.e = aVar;
    }

    public e W(int i) {
        this.l = i;
        return this;
    }

    void X(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f.size();
        h0();
        for (int i = 0; i < size; i++) {
            g gVar = (g) this.f.get(i);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        g0();
    }

    protected e Y(int i) {
        a0(0, null, i, null, null);
        return this;
    }

    protected e Z(Drawable drawable) {
        a0(0, null, 0, drawable, null);
        return this;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int iD = D(i3);
        g gVarG = g(i, i2, i3, iD, charSequence, this.l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.m;
        if (contextMenuInfo != null) {
            gVarG.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f;
        arrayList.add(p(arrayList, iD), gVarG);
        M(true);
        return gVarG;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(j jVar) {
        c(jVar, this.a);
    }

    protected e b0(int i) {
        a0(i, null, 0, null, null);
        return this;
    }

    public void c(j jVar, Context context) {
        this.w.add(new WeakReference(jVar));
        jVar.l(context, this);
        this.k = true;
    }

    protected e c0(CharSequence charSequence) {
        a0(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.x;
        if (gVar != null) {
            f(gVar);
        }
        this.f.clear();
        M(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        M(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    protected e d0(View view) {
        a0(0, null, 0, null, view);
        return this;
    }

    public final void e(boolean z) {
        if (this.u) {
            return;
        }
        this.u = true;
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.w.remove(weakReference);
            } else {
                jVar.c(this, z);
            }
        }
        this.u = false;
    }

    public void e0(boolean z) {
        this.z = z;
    }

    public boolean f(g gVar) {
        boolean zK = false;
        if (!this.w.isEmpty() && this.x == gVar) {
            h0();
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                j jVar = (j) weakReference.get();
                if (jVar == null) {
                    this.w.remove(weakReference);
                } else {
                    zK = jVar.k(this, gVar);
                    if (zK) {
                        break;
                    }
                }
            }
            g0();
            if (zK) {
                this.x = null;
            }
        }
        return zK;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getItemId() == i) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (menuItemFindItem = gVar.getSubMenu().findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public void g0() {
        this.q = false;
        if (this.r) {
            this.r = false;
            M(this.s);
        }
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return (MenuItem) this.f.get(i);
    }

    boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    public void h0() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.r = false;
        this.s = false;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((g) this.f.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return r(i, keyEvent) != null;
    }

    public boolean m(g gVar) {
        boolean zD = false;
        if (this.w.isEmpty()) {
            return false;
        }
        h0();
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.w.remove(weakReference);
            } else {
                zD = jVar.d(this, gVar);
                if (zD) {
                    break;
                }
            }
        }
        g0();
        if (zD) {
            this.x = gVar;
        }
        return zD;
    }

    public int n(int i) {
        return o(i, 0);
    }

    public int o(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (((g) this.f.get(i2)).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return N(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        g gVarR = r(i, keyEvent);
        boolean zN = gVarR != null ? N(gVarR, i2) : false;
        if ((i2 & 2) != 0) {
            e(true);
        }
        return zN;
    }

    public int q(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((g) this.f.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    g r(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.v;
        arrayList.clear();
        s(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (g) arrayList.get(0);
        }
        boolean zI = I();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) arrayList.get(i2);
            char alphabeticShortcut = zI ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zI && alphabeticShortcut == '\b' && i == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iN = n(i);
        if (iN >= 0) {
            int size = this.f.size() - iN;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((g) this.f.get(iN)).getGroupId() != i) {
                    break;
                }
                P(iN, false);
                i2 = i3;
            }
            M(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        P(q(i), true);
    }

    void s(List list, int i, KeyEvent keyEvent) {
        boolean zI = I();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) this.f.get(i2);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).s(list, i, keyEvent);
                }
                char alphabeticShortcut = zI ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zI ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zI && alphabeticShortcut == '\b' && i == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getGroupId() == i) {
                gVar.t(z2);
                gVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.y = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getGroupId() == i) {
                gVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getGroupId() == i && gVar.y(z)) {
                z2 = true;
            }
        }
        if (z2) {
            M(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.c = z;
        M(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f.size();
    }

    public void t() {
        ArrayList arrayListG = G();
        if (this.k) {
            Iterator it = this.w.iterator();
            boolean zJ = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                j jVar = (j) weakReference.get();
                if (jVar == null) {
                    this.w.remove(weakReference);
                } else {
                    zJ |= jVar.j();
                }
            }
            if (zJ) {
                this.i.clear();
                this.j.clear();
                int size = arrayListG.size();
                for (int i = 0; i < size; i++) {
                    g gVar = (g) arrayListG.get(i);
                    if (gVar.l()) {
                        this.i.add(gVar);
                    } else {
                        this.j.add(gVar);
                    }
                }
            } else {
                this.i.clear();
                this.j.clear();
                this.j.addAll(G());
            }
            this.k = false;
        }
    }

    public ArrayList u() {
        t();
        return this.i;
    }

    protected String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.a;
    }

    public g x() {
        return this.x;
    }

    public Drawable y() {
        return this.o;
    }

    public CharSequence z() {
        return this.n;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.b.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.b.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        g gVar = (g) a(i, i2, i3, charSequence);
        m mVar = new m(this.a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.b.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.b.getString(i4));
    }
}
