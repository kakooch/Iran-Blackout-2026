package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class L75 extends AbstractC17902nl0 implements HB3 {
    public static final InterfaceC17311ml0 d = new a();
    private long a;
    private String b;
    private List c;

    class a implements InterfaceC17311ml0 {
        a() {
        }

        @Override // ir.nasim.InterfaceC17311ml0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public L75 a() {
            return new L75();
        }
    }

    public L75(long j, String str, List list) {
        new ArrayList();
        this.a = j;
        this.b = str;
        this.c = list;
    }

    @Override // ir.nasim.HB3
    public long a() {
        return this.a;
    }

    public String getName() {
        return this.b;
    }

    @Override // ir.nasim.HB3
    public long j() {
        return this.a;
    }

    @Override // ir.nasim.HB3
    public String p() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        Iterator it = c19084pl0.l(3).iterator();
        while (it.hasNext()) {
            this.c.add((O75) AbstractC16720ll0.b(new O75(), (byte[]) it.next()));
        }
    }

    public List q() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.o(2, this.b);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            c19675ql0.i(3, (O75) it.next());
        }
    }

    public L75() {
        this.c = new ArrayList();
    }
}
