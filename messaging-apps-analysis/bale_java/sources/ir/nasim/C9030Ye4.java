package ir.nasim;

import ir.nasim.C11057cf4;
import ir.nasim.InterfaceC10467bf4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ye4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9030Ye4 implements InterfaceC8344Vo3 {
    private final OK a;
    private final C3411At4 b;
    private final C11057cf4 c;

    public C9030Ye4(OK ok, C3411At4 c3411At4, C11057cf4 c11057cf4) {
        AbstractC13042fc3.i(ok, "original");
        AbstractC13042fc3.i(c3411At4, "newDownloaderMigrator");
        AbstractC13042fc3.i(c11057cf4, "migrationDownloadRepository");
        this.a = ok;
        this.b = c3411At4;
        this.c = c11057cf4;
    }

    private final void k(List list) {
        List<C10405bZ1> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (C10405bZ1 c10405bZ1 : list2) {
            arrayList.add(new C11057cf4.b(this.c.i(c10405bZ1.getFileSize(), c10405bZ1.q(), c10405bZ1.getFileId()), c10405bZ1.q()));
        }
        if (!arrayList.isEmpty()) {
            this.c.d(new InterfaceC10467bf4.a(arrayList));
        }
    }

    private final void l(C10405bZ1 c10405bZ1) {
        C11057cf4 c11057cf4 = this.c;
        c11057cf4.d(new InterfaceC10467bf4.a(AbstractC9766aX0.e(new C11057cf4.b(c11057cf4.i(c10405bZ1.getFileSize(), c10405bZ1.q(), c10405bZ1.getFileId()), c10405bZ1.q()))));
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public C6517Nv5 a(long j) {
        return this.a.a(j);
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public void b(long j) {
        this.a.b(j);
        if (C8386Vt0.a.S3()) {
            Object value = this.b.g().getValue();
            EnumC13691gf4 enumC13691gf4 = EnumC13691gf4.c;
            if (value != enumC13691gf4) {
                this.b.d(j);
            }
            if (this.b.g().getValue() == enumC13691gf4) {
                this.c.d(new InterfaceC10467bf4.b(AbstractC9766aX0.e(Long.valueOf(j))));
            }
        }
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public void c(List list) {
        AbstractC13042fc3.i(list, "values");
        this.a.c(list);
        if (C8386Vt0.a.S3()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.b.c((C10405bZ1) it.next());
            }
            if (this.b.g().getValue() == EnumC13691gf4.c) {
                k(list);
            }
        }
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public void clear() {
        this.a.clear();
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public List f(List list) {
        return this.a.f(list);
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public C6517Nv5 g(List list) {
        return this.a.g(list);
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public C6517Nv5 h() {
        return this.a.h();
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(C10405bZ1 c10405bZ1) {
        AbstractC13042fc3.i(c10405bZ1, "item");
        this.a.e(c10405bZ1);
        if (C8386Vt0.a.S3()) {
            this.b.c(c10405bZ1);
            if (this.b.g().getValue() == EnumC13691gf4.c) {
                l(c10405bZ1);
            }
        }
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C10405bZ1 d(long j) {
        return (C10405bZ1) this.a.n(j);
    }
}
