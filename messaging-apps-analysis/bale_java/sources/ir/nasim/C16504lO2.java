package ir.nasim;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.lO2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C16504lO2 extends AbstractC17902nl0 {
    private final CopyOnWriteArrayList a = new CopyOnWriteArrayList();
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;

    public C16504lO2() {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.b(1);
        Iterator it = c19084pl0.l(2).iterator();
        while (it.hasNext()) {
            this.a.add(new C15913kO2((byte[]) it.next()));
        }
        this.c = c19084pl0.b(3);
        this.d = c19084pl0.b(4);
    }

    public CopyOnWriteArrayList q() {
        return this.a;
    }

    public boolean r() {
        return this.b;
    }

    public void s(boolean z) {
        this.c = z;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.b);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            c19675ql0.i(2, (C15913kO2) it.next());
        }
        c19675ql0.a(3, this.c);
        c19675ql0.a(4, this.d);
    }

    public void u(boolean z) {
        this.b = z;
    }

    public void w(boolean z) {
        this.d = z;
    }

    public C16504lO2(byte[] bArr) {
        super.load(bArr);
    }
}
