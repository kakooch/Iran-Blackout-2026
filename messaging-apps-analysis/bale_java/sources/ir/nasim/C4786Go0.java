package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import ir.nasim.InterfaceC9624aH2;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* renamed from: ir.nasim.Go0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4786Go0 implements HW5 {
    private static final a f = new a();
    private static final b g = new b();
    private final Context a;
    private final List b;
    private final b c;
    private final a d;
    private final WG2 e;

    /* renamed from: ir.nasim.Go0$a */
    static class a {
        a() {
        }

        InterfaceC9624aH2 a(InterfaceC9624aH2.a aVar, C21199tH2 c21199tH2, ByteBuffer byteBuffer, int i) {
            return new OJ6(aVar, c21199tH2, byteBuffer, i);
        }
    }

    /* renamed from: ir.nasim.Go0$b */
    static class b {
        private final Queue a = YM7.g(0);

        b() {
        }

        synchronized C21873uH2 a(ByteBuffer byteBuffer) {
            C21873uH2 c21873uH2;
            try {
                c21873uH2 = (C21873uH2) this.a.poll();
                if (c21873uH2 == null) {
                    c21873uH2 = new C21873uH2();
                }
            } catch (Throwable th) {
                throw th;
            }
            return c21873uH2.p(byteBuffer);
        }

        synchronized void b(C21873uH2 c21873uH2) {
            c21873uH2.a();
            this.a.offer(c21873uH2);
        }
    }

    public C4786Go0(Context context, List list, InterfaceC13106fg0 interfaceC13106fg0, LJ lj) {
        this(context, list, interfaceC13106fg0, lj, g, f);
    }

    private C13468gH2 c(ByteBuffer byteBuffer, int i, int i2, C21873uH2 c21873uH2, HL4 hl4) {
        long jB = EI3.b();
        try {
            C21199tH2 c21199tH2C = c21873uH2.c();
            if (c21199tH2C.b() > 0 && c21199tH2C.c() == 0) {
                Bitmap.Config config = hl4.c(AbstractC23059wH2.a) == EnumC18159oB1.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                InterfaceC9624aH2 interfaceC9624aH2A = this.d.a(this.e, c21199tH2C, byteBuffer, e(c21199tH2C, i, i2));
                interfaceC9624aH2A.c(config);
                interfaceC9624aH2A.a();
                Bitmap nextFrame = interfaceC9624aH2A.getNextFrame();
                if (nextFrame == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + EI3.a(jB));
                    }
                    return null;
                }
                C13468gH2 c13468gH2 = new C13468gH2(new C11598dH2(this.a, interfaceC9624aH2A, C23600xB7.c(), i, i2, nextFrame));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + EI3.a(jB));
                }
                return c13468gH2;
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + EI3.a(jB));
            }
        }
    }

    private static int e(C21199tH2 c21199tH2, int i, int i2) {
        int iMin = Math.min(c21199tH2.a() / i2, c21199tH2.d() / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + c21199tH2.d() + "x" + c21199tH2.a() + "]");
        }
        return iMax;
    }

    @Override // ir.nasim.HW5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C13468gH2 a(ByteBuffer byteBuffer, int i, int i2, HL4 hl4) {
        C21873uH2 c21873uH2A = this.c.a(byteBuffer);
        try {
            return c(byteBuffer, i, i2, c21873uH2A, hl4);
        } finally {
            this.c.b(c21873uH2A);
        }
    }

    @Override // ir.nasim.HW5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, HL4 hl4) {
        return !((Boolean) hl4.c(AbstractC23059wH2.b)).booleanValue() && com.bumptech.glide.load.a.g(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    C4786Go0(Context context, List list, InterfaceC13106fg0 interfaceC13106fg0, LJ lj, b bVar, a aVar) {
        this.a = context.getApplicationContext();
        this.b = list;
        this.d = aVar;
        this.e = new WG2(interfaceC13106fg0, lj);
        this.c = bVar;
    }
}
