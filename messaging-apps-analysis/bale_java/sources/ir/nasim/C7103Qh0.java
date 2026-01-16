package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: ir.nasim.Qh0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C7103Qh0 extends AbstractC17902nl0 {
    private HashSet a;

    public C7103Qh0() {
        this.a = new HashSet();
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iM = c19084pl0.m(1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iM; i++) {
            arrayList.add(new C16910m43());
        }
        this.a.addAll(c19084pl0.p(1, arrayList));
    }

    public HashSet q() {
        return this.a;
    }

    public boolean r(C16910m43 c16910m43) {
        return this.a.contains(c16910m43);
    }

    public void s(C16910m43 c16910m43) {
        this.a.add(c16910m43);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            c19675ql0.i(1, (C16910m43) it.next());
        }
    }

    public void u(C16910m43 c16910m43) {
        this.a.remove(c16910m43);
    }

    public C7103Qh0(byte[] bArr) {
        this.a = new HashSet();
        try {
            super.load(bArr);
        } catch (IOException e) {
            C19406qI3.c("BookImportStorage", "BookImportStorage()", e);
            this.a = new HashSet();
        }
    }
}
