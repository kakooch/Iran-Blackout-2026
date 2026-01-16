package ir.nasim;

import android.graphics.Bitmap;
import ir.nasim.C16602lZ1;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class OX6 implements HW5 {
    private final C16602lZ1 a;
    private final LJ b;

    static class a implements C16602lZ1.b {
        private final OK5 a;
        private final C8460Wb2 b;

        a(OK5 ok5, C8460Wb2 c8460Wb2) {
            this.a = ok5;
            this.b = c8460Wb2;
        }

        @Override // ir.nasim.C16602lZ1.b
        public void a(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap) throws IOException {
            IOException iOExceptionA = this.b.a();
            if (iOExceptionA != null) {
                if (bitmap == null) {
                    throw iOExceptionA;
                }
                interfaceC13106fg0.c(bitmap);
                throw iOExceptionA;
            }
        }

        @Override // ir.nasim.C16602lZ1.b
        public void b() {
            this.a.b();
        }
    }

    public OX6(C16602lZ1 c16602lZ1, LJ lj) {
        this.a = c16602lZ1;
        this.b = lj;
    }

    @Override // ir.nasim.HW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DW5 a(InputStream inputStream, int i, int i2, HL4 hl4) {
        boolean z;
        OK5 ok5;
        if (inputStream instanceof OK5) {
            ok5 = (OK5) inputStream;
            z = false;
        } else {
            z = true;
            ok5 = new OK5(inputStream, this.b);
        }
        C8460Wb2 c8460Wb2B = C8460Wb2.b(ok5);
        try {
            return this.a.f(new C23713xO3(c8460Wb2B), i, i2, hl4, new a(ok5, c8460Wb2B));
        } finally {
            c8460Wb2B.c();
            if (z) {
                ok5.c();
            }
        }
    }

    @Override // ir.nasim.HW5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, HL4 hl4) {
        return this.a.p(inputStream);
    }
}
