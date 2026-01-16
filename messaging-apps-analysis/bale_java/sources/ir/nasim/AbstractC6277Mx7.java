package ir.nasim;

import com.google.gson.JsonIOException;
import java.io.IOException;

/* renamed from: ir.nasim.Mx7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC6277Mx7 {

    /* renamed from: ir.nasim.Mx7$a */
    class a extends AbstractC6277Mx7 {
        a() {
        }

        @Override // ir.nasim.AbstractC6277Mx7
        public Object b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() != EnumC16723ll3.NULL) {
                return AbstractC6277Mx7.this.b(c12523el3);
            }
            c12523el3.u();
            return null;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        public void d(C22155ul3 c22155ul3, Object obj) throws IOException {
            if (obj == null) {
                c22155ul3.s();
            } else {
                AbstractC6277Mx7.this.d(c22155ul3, obj);
            }
        }
    }

    public final AbstractC6277Mx7 a() {
        return new a();
    }

    public abstract Object b(C12523el3 c12523el3);

    public final AbstractC22735vk3 c(Object obj) {
        try {
            C19678ql3 c19678ql3 = new C19678ql3();
            d(c19678ql3, obj);
            return c19678ql3.e0();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public abstract void d(C22155ul3 c22155ul3, Object obj);
}
