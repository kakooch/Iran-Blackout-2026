package ir.nasim;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.kO2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C15913kO2 extends AbstractC17902nl0 {
    private String a;
    private String b;
    private CopyOnWriteArrayList c;

    public C15913kO2(String str, String str2, CopyOnWriteArrayList copyOnWriteArrayList) {
        new CopyOnWriteArrayList();
        this.a = str;
        this.b = str2;
        this.c = copyOnWriteArrayList;
    }

    public String getKey() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c.clear();
        Iterator it = c19084pl0.l(3).iterator();
        while (it.hasNext()) {
            this.c.add(C25254zz6.q((byte[]) it.next()));
        }
    }

    public CopyOnWriteArrayList q() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.o(1, this.a);
        c19675ql0.o(2, this.b);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            c19675ql0.i(3, (C25254zz6) it.next());
        }
    }

    public C15913kO2(byte[] bArr) {
        this.c = new CopyOnWriteArrayList();
        load(bArr);
    }
}
