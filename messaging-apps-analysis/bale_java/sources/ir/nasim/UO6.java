package ir.nasim;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes7.dex */
public class UO6 {
    private final int a;
    public XO6 j;
    SharedPreferences k;
    final C22031uY7 l;
    String m;
    private boolean n;
    private int o;
    private int p;
    private final C23220wZ1 q;
    private String r;
    final Runnable z;
    private final ArrayList b = new ArrayList();
    private final ArrayList c = new ArrayList();
    private final HashMap d = new HashMap();
    public C23078wJ3 e = new C23078wJ3();
    private ArrayList f = new ArrayList();
    private ArrayList g = new ArrayList();
    private C21892uJ3 h = new C21892uJ3();
    private C23078wJ3 i = new C23078wJ3();
    private boolean s = true;
    private boolean t = true;
    HashSet u = new HashSet();
    HashSet v = new HashSet();
    C21892uJ3 w = new C21892uJ3();
    private final HashMap[] x = new HashMap[2];
    private final Comparator y = new Comparator() { // from class: ir.nasim.RO6
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            UO6 uo6 = this.a;
            AbstractC18350oW3.a(obj);
            AbstractC18350oW3.a(obj2);
            return uo6.j(null, null);
        }
    };

    public UO6(final int i) {
        this.m = "";
        this.a = i;
        this.j = new XO6(i);
        SharedPreferences sharedPreferencesO = ir.nasim.tgwidgets.editor.messenger.C.n(i).o();
        this.k = sharedPreferencesO;
        this.m = sharedPreferencesO.getString("last_stories_state", "");
        this.r = this.k.getString("last_stories_state_hidden", "");
        this.p = this.k.getInt("total_stores_hidden", 0);
        this.o = this.k.getInt("total_stores", 0);
        this.n = this.k.getBoolean("read_loaded", false);
        this.l = new C22031uY7(this, i);
        this.j.c(new InterfaceC23269we1() { // from class: ir.nasim.SO6
            @Override // ir.nasim.InterfaceC23269we1
            public final void accept(Object obj) {
                this.a.h((C23078wJ3) obj);
            }
        });
        this.z = new Runnable() { // from class: ir.nasim.TO6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i(i);
            }
        };
        this.q = new C23220wZ1(i);
    }

    private void d(ArrayList arrayList) {
        if (arrayList.size() <= 0) {
            return;
        }
        AbstractC18350oW3.a(arrayList.get(0));
        ir.nasim.tgwidgets.editor.messenger.C.n(this.a);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(C23078wJ3 c23078wJ3) {
        this.e = c23078wJ3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(int i) {
        k(this.f);
        k(this.g);
        ir.nasim.tgwidgets.editor.messenger.E.k(i).s(ir.nasim.tgwidgets.editor.messenger.E.U3, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int j(AbstractC24485yh7 abstractC24485yh7, AbstractC24485yh7 abstractC24485yh72) {
        throw null;
    }

    private void k(ArrayList arrayList) {
        d(arrayList);
        Collections.sort(arrayList, this.y);
    }

    public C23220wZ1 e() {
        return this.q;
    }

    public int f() {
        AbstractC18350oW3.a(this.h.f(C22477vI7.j(this.a).c));
        return this.b.size();
    }

    public AbstractC24485yh7 g(long j) {
        AbstractC18350oW3.a(this.h.f(j));
        return null;
    }
}
