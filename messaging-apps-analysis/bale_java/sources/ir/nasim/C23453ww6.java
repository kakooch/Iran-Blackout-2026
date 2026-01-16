package ir.nasim;

import ir.nasim.C19791qw6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ww6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23453ww6 extends AbstractC17902nl0 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final List a = new ArrayList();

    /* renamed from: ir.nasim.ww6$a */
    public static final class a {
        private a() {
        }

        public final C23453ww6 a(byte[] bArr) {
            AbstractC13042fc3.i(bArr, "data");
            AbstractC17902nl0 abstractC17902nl0B = AbstractC16720ll0.b(new C23453ww6(), bArr);
            AbstractC13042fc3.h(abstractC17902nl0B, "parse(...)");
            return (C23453ww6) abstractC17902nl0B;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) throws IOException {
        AbstractC13042fc3.i(c19084pl0, "values");
        List listL = c19084pl0.l(1);
        AbstractC13042fc3.h(listL, "getRepeatedBytes(...)");
        int size = listL.size();
        for (int i = 0; i < size; i++) {
            List list = this.a;
            C19791qw6.a aVar = C19791qw6.c;
            Object obj = listL.get(i);
            AbstractC13042fc3.h(obj, "get(...)");
            list.add(aVar.a((byte[]) obj));
        }
    }

    public final List q() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            c19675ql0.i(1, (C19791qw6) it.next());
        }
    }
}
