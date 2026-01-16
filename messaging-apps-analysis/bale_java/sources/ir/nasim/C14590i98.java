package ir.nasim;

import android.gov.nist.core.Separators;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.i98, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14590i98 {
    static int g;
    int b;
    int d;
    ArrayList a = new ArrayList();
    boolean c = false;
    ArrayList e = null;
    private int f = -1;

    /* renamed from: ir.nasim.i98$a */
    class a {
        WeakReference a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;

        public a(C16651le1 c16651le1, C8963Xz3 c8963Xz3, int i) {
            this.a = new WeakReference(c16651le1);
            this.b = c8963Xz3.x(c16651le1.Q);
            this.c = c8963Xz3.x(c16651le1.R);
            this.d = c8963Xz3.x(c16651le1.S);
            this.e = c8963Xz3.x(c16651le1.T);
            this.f = c8963Xz3.x(c16651le1.U);
            this.g = i;
        }
    }

    public C14590i98(int i) {
        int i2 = g;
        g = i2 + 1;
        this.b = i2;
        this.d = i;
    }

    private String e() {
        int i = this.d;
        return i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown";
    }

    private int j(C8963Xz3 c8963Xz3, ArrayList arrayList, int i) {
        int iX;
        int iX2;
        C17242me1 c17242me1 = (C17242me1) ((C16651le1) arrayList.get(0)).N();
        c8963Xz3.D();
        c17242me1.g(c8963Xz3, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((C16651le1) arrayList.get(i2)).g(c8963Xz3, false);
        }
        if (i == 0 && c17242me1.g1 > 0) {
            AbstractC11605dI0.b(c17242me1, c8963Xz3, arrayList, 0);
        }
        if (i == 1 && c17242me1.h1 > 0) {
            AbstractC11605dI0.b(c17242me1, c8963Xz3, arrayList, 1);
        }
        try {
            c8963Xz3.z();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.e = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.e.add(new a((C16651le1) arrayList.get(i3), c8963Xz3, i));
        }
        if (i == 0) {
            iX = c8963Xz3.x(c17242me1.Q);
            iX2 = c8963Xz3.x(c17242me1.S);
            c8963Xz3.D();
        } else {
            iX = c8963Xz3.x(c17242me1.R);
            iX2 = c8963Xz3.x(c17242me1.T);
            c8963Xz3.D();
        }
        return iX2 - iX;
    }

    public boolean a(C16651le1 c16651le1) {
        if (this.a.contains(c16651le1)) {
            return false;
        }
        this.a.add(c16651le1);
        return true;
    }

    public void b(ArrayList arrayList) {
        int size = this.a.size();
        if (this.f != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                C14590i98 c14590i98 = (C14590i98) arrayList.get(i);
                if (this.f == c14590i98.b) {
                    g(this.d, c14590i98);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public int f(C8963Xz3 c8963Xz3, int i) {
        if (this.a.size() == 0) {
            return 0;
        }
        return j(c8963Xz3, this.a, i);
    }

    public void g(int i, C14590i98 c14590i98) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            C16651le1 c16651le1 = (C16651le1) it.next();
            c14590i98.a(c16651le1);
            if (i == 0) {
                c16651le1.S0 = c14590i98.c();
            } else {
                c16651le1.T0 = c14590i98.c();
            }
        }
        this.f = c14590i98.b;
    }

    public void h(boolean z) {
        this.c = z;
    }

    public void i(int i) {
        this.d = i;
    }

    public String toString() {
        String str = e() + " [" + this.b + "] <";
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            str = str + Separators.SP + ((C16651le1) it.next()).v();
        }
        return str + " >";
    }
}
