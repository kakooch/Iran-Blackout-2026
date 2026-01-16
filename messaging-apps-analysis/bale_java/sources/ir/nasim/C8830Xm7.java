package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Xm7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C8830Xm7 extends AbstractC25155zp3 {

    /* renamed from: ir.nasim.Xm7$a */
    class a extends C13505gL3 {
        final /* synthetic */ UK3 d;
        final /* synthetic */ C13505gL3 e;
        final /* synthetic */ AW1 f;
        final /* synthetic */ C8830Xm7 g;

        a(C8830Xm7 c8830Xm7, UK3 uk3, C13505gL3 c13505gL3, AW1 aw1) {
            this.d = uk3;
            this.e = c13505gL3;
            this.f = aw1;
            this.g = c8830Xm7;
        }

        @Override // ir.nasim.C13505gL3
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AW1 a(UK3 uk3) {
            this.d.h(uk3.f(), uk3.a(), ((AW1) uk3.g()).a, ((AW1) uk3.b()).a, uk3.d(), uk3.c(), uk3.e());
            String str = (String) this.e.a(this.d);
            AW1 aw1 = (AW1) (uk3.c() == 1.0f ? uk3.b() : uk3.g());
            this.f.a(str, aw1.b, aw1.c, aw1.d, aw1.e, aw1.f, aw1.g, aw1.h, aw1.i, aw1.j, aw1.k, aw1.l, aw1.m);
            return this.f;
        }
    }

    public C8830Xm7(List list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public AW1 i(C24561yp3 c24561yp3, float f) {
        Object obj;
        C13505gL3 c13505gL3 = this.e;
        if (c13505gL3 == null) {
            return (f != 1.0f || (obj = c24561yp3.c) == null) ? (AW1) c24561yp3.b : (AW1) obj;
        }
        float f2 = c24561yp3.g;
        Float f3 = c24561yp3.h;
        float fFloatValue = f3 == null ? Float.MAX_VALUE : f3.floatValue();
        Object obj2 = c24561yp3.b;
        AW1 aw1 = (AW1) obj2;
        Object obj3 = c24561yp3.c;
        return (AW1) c13505gL3.b(f2, fFloatValue, aw1, obj3 == null ? (AW1) obj2 : (AW1) obj3, f, d(), f());
    }

    public void s(C13505gL3 c13505gL3) {
        super.o(new a(this, new UK3(), c13505gL3, new AW1()));
    }
}
