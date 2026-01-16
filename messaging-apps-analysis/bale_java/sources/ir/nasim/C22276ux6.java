package ir.nasim;

import android.graphics.Path;
import java.util.List;

/* renamed from: ir.nasim.ux6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C22276ux6 extends AbstractC24408ya0 {
    private final C14465hx6 i;
    private final Path j;
    private Path k;
    private Path l;
    private List m;

    public C22276ux6(List list) {
        super(list);
        this.i = new C14465hx6();
        this.j = new Path();
    }

    @Override // ir.nasim.AbstractC24408ya0
    protected boolean p() {
        List list = this.m;
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Path i(C24561yp3 c24561yp3, float f) {
        C14465hx6 c14465hx6 = (C14465hx6) c24561yp3.b;
        C14465hx6 c14465hx62 = (C14465hx6) c24561yp3.c;
        this.i.c(c14465hx6, c14465hx62 == null ? c14465hx6 : c14465hx62, f);
        C14465hx6 c14465hx6D = this.i;
        List list = this.m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c14465hx6D = ((InterfaceC23462wx6) this.m.get(size)).d(c14465hx6D);
            }
        }
        AbstractC7323Rf4.h(c14465hx6D, this.j);
        if (this.e == null) {
            return this.j;
        }
        if (this.k == null) {
            this.k = new Path();
            this.l = new Path();
        }
        AbstractC7323Rf4.h(c14465hx6, this.k);
        if (c14465hx62 != null) {
            AbstractC7323Rf4.h(c14465hx62, this.l);
        }
        C13505gL3 c13505gL3 = this.e;
        float f2 = c24561yp3.g;
        float fFloatValue = c24561yp3.h.floatValue();
        Path path = this.k;
        return (Path) c13505gL3.b(f2, fFloatValue, path, c14465hx62 == null ? path : this.l, f, e(), f());
    }

    public void s(List list) {
        this.m = list;
    }
}
