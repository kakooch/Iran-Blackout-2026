package ir.nasim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class D90 extends AbstractC4177Ea0 {
    private static final ExecutorService m = SZ.k("S_pre_subscribe");
    private int f;
    private HashSet g;
    private ArrayList h;
    private C14268he0 i;
    private A90 j;
    public int k;
    public int l;

    public D90(A90 a90) {
        super(a90);
        this.i = C14268he0.l();
        this.k = 40;
        this.l = 40;
        this.j = a90;
        i();
    }

    private boolean h(ArrayList arrayList) {
        if (arrayList.size() <= 0) {
            return false;
        }
        AbstractC5969Lp4.d().d1(arrayList);
        this.g.addAll(arrayList);
        return true;
    }

    private void i() {
        this.f = this.j.sa().r();
        this.g = new HashSet();
        this.h = new ArrayList();
        this.i.g().f(20L, TimeUnit.MILLISECONDS, AbstractC8858Xq.c()).h(new InterfaceC23859xe1() { // from class: ir.nasim.B90
            @Override // ir.nasim.InterfaceC23859xe1
            public final void accept(Object obj) {
                this.a.j((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(Integer num) {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        ArrayList arrayList = new ArrayList();
        while (this.f < this.l && this.j.sa().r() > this.f) {
            C3512Be1 c3512Be1 = (C3512Be1) this.j.sa().o(this.f);
            if (!this.g.contains(Integer.valueOf(c3512Be1.r()))) {
                arrayList.add(Integer.valueOf(c3512Be1.r()));
            }
            this.f++;
        }
        this.l += this.k;
        h(arrayList);
    }

    private void o() {
        if (h(new ArrayList(this.h))) {
            ArrayList arrayList = this.h;
            arrayList.removeAll(arrayList);
        }
    }

    void l(C3512Be1 c3512Be1, int i) {
        int iR = c3512Be1.r();
        if (this.g.contains(Integer.valueOf(iR))) {
            return;
        }
        this.h.add(Integer.valueOf(iR));
        this.i.e(Integer.valueOf(i));
    }

    void m() {
        m.execute(new Runnable() { // from class: ir.nasim.C90
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k();
            }
        });
    }

    void n() {
        if (this.g.size() > 0) {
            AbstractC5969Lp4.d().c1(new ArrayList(this.g));
            HashSet hashSet = this.g;
            hashSet.removeAll(hashSet);
        }
    }
}
