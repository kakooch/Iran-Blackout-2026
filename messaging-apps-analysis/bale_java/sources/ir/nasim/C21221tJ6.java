package ir.nasim;

import com.google.gson.reflect.TypeToken;
import java.sql.Timestamp;
import java.util.Date;

/* renamed from: ir.nasim.tJ6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C21221tJ6 extends AbstractC6277Mx7 {
    static final InterfaceC6537Nx7 b = new a();
    private final AbstractC6277Mx7 a;

    /* renamed from: ir.nasim.tJ6$a */
    class a implements InterfaceC6537Nx7 {
        a() {
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.c() == Timestamp.class) {
                return new C21221tJ6(ks2.n(Date.class), aVar);
            }
            return null;
        }
    }

    /* synthetic */ C21221tJ6(AbstractC6277Mx7 abstractC6277Mx7, a aVar) {
        this(abstractC6277Mx7);
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Timestamp b(C12523el3 c12523el3) {
        Date date = (Date) this.a.b(c12523el3);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(C22155ul3 c22155ul3, Timestamp timestamp) {
        this.a.d(c22155ul3, timestamp);
    }

    private C21221tJ6(AbstractC6277Mx7 abstractC6277Mx7) {
        this.a = abstractC6277Mx7;
    }
}
