package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Movie;
import ir.nasim.CB1;
import java.io.IOException;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: classes2.dex */
public final class ZG2 implements CB1 {
    public static final a d = new a(null);
    private final AbstractC10086b33 a;
    private final IL4 b;
    private final boolean c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C20541sB1 invoke() throws IOException {
            BufferedSource bufferedSourceBuffer = ZG2.this.c ? Okio.buffer(new C7735Sz2(ZG2.this.a.c())) : ZG2.this.a.c();
            try {
                Movie movieDecodeStream = Movie.decodeStream(bufferedSourceBuffer.inputStream());
                YV0.a(bufferedSourceBuffer, null);
                if (movieDecodeStream == null || movieDecodeStream.width() <= 0 || movieDecodeStream.height() <= 0) {
                    throw new IllegalStateException("Failed to decode GIF.".toString());
                }
                C22146uk4 c22146uk4 = new C22146uk4(movieDecodeStream, (movieDecodeStream.isOpaque() && ZG2.this.b.d()) ? Bitmap.Config.RGB_565 : AbstractC14485i.b(ZG2.this.b.f()) ? Bitmap.Config.ARGB_8888 : ZG2.this.b.f(), ZG2.this.b.n());
                Integer numD = AbstractC15268jI2.d(ZG2.this.b.l());
                c22146uk4.e(numD != null ? numD.intValue() : -1);
                SA2 sa2C = AbstractC15268jI2.c(ZG2.this.b.l());
                SA2 sa2B = AbstractC15268jI2.b(ZG2.this.b.l());
                if (sa2C != null || sa2B != null) {
                    c22146uk4.c(AbstractC14485i.a(sa2C, sa2B));
                }
                AbstractC15268jI2.a(ZG2.this.b.l());
                c22146uk4.d(null);
                return new C20541sB1(c22146uk4, false);
            } finally {
            }
        }
    }

    public ZG2(AbstractC10086b33 abstractC10086b33, IL4 il4, boolean z) {
        this.a = abstractC10086b33;
        this.b = il4;
        this.c = z;
    }

    @Override // ir.nasim.CB1
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC7757Tb3.c(null, new c(), interfaceC20295rm1, 1, null);
    }

    public static final class b implements CB1.a {
        private final boolean a;

        public b(boolean z) {
            this.a = z;
        }

        @Override // ir.nasim.CB1.a
        public CB1 a(WH6 wh6, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            if (YG2.a(C21144tB1.a, wh6.c().c())) {
                return new ZG2(wh6.c(), il4, this.a);
            }
            return null;
        }

        public boolean equals(Object obj) {
            return obj instanceof b;
        }

        public int hashCode() {
            return b.class.hashCode();
        }

        public /* synthetic */ b(boolean z, int i, ED1 ed1) {
            this((i & 1) != 0 ? true : z);
        }
    }
}
