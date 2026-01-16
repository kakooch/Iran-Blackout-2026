package ir.nasim;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: ir.nasim.iL3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14698iL3 implements InterfaceC13106fg0 {
    private static final Bitmap.Config k = Bitmap.Config.ARGB_8888;
    private final InterfaceC18842pL3 a;
    private final Set b;
    private final long c;
    private final a d;
    private long e;
    private long f;
    private int g;
    private int h;
    private int i;
    private int j;

    /* renamed from: ir.nasim.iL3$a */
    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    C14698iL3(long j, InterfaceC18842pL3 interfaceC18842pL3, Set set) {
        this.c = j;
        this.e = j;
        this.a = interfaceC18842pL3;
        this.b = set;
        this.d = new b();
    }

    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static Bitmap g(int i, int i2, Bitmap.Config config) {
        if (config == null) {
            config = k;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.g + ", misses=" + this.h + ", puts=" + this.i + ", evictions=" + this.j + ", currentSize=" + this.f + ", maxSize=" + this.e + "\nStrategy=" + this.a);
    }

    private void j() {
        q(this.e);
    }

    private static Set k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static InterfaceC18842pL3 l() {
        return new TD6();
    }

    private synchronized Bitmap m(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapD;
        try {
            f(config);
            bitmapD = this.a.d(i, i2, config != null ? config : k);
            if (bitmapD == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.a.b(i, i2, config));
                }
                this.h++;
            } else {
                this.g++;
                this.f -= this.a.e(bitmapD);
                this.d.a(bitmapD);
                p(bitmapD);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.a.b(i, i2, config));
            }
            h();
        } catch (Throwable th) {
            throw th;
        }
        return bitmapD;
    }

    private static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j) {
        while (this.f > j) {
            try {
                Bitmap bitmapRemoveLast = this.a.removeLast();
                if (bitmapRemoveLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        i();
                    }
                    this.f = 0L;
                    return;
                }
                this.d.a(bitmapRemoveLast);
                this.f -= this.a.e(bitmapRemoveLast);
                this.j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.a.a(bitmapRemoveLast));
                }
                h();
                bitmapRemoveLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC13106fg0
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40 || i >= 20) {
            b();
        } else if (i >= 20 || i == 15) {
            q(n() / 2);
        }
    }

    @Override // ir.nasim.InterfaceC13106fg0
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // ir.nasim.InterfaceC13106fg0
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.a.e(bitmap) <= this.e && this.b.contains(bitmap.getConfig())) {
                int iE = this.a.e(bitmap);
                this.a.c(bitmap);
                this.d.b(bitmap);
                this.i++;
                this.f += iE;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.a.a(bitmap));
                }
                h();
                j();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.a.a(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC13106fg0
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapM = m(i, i2, config);
        if (bitmapM == null) {
            return g(i, i2, config);
        }
        bitmapM.eraseColor(0);
        return bitmapM;
    }

    @Override // ir.nasim.InterfaceC13106fg0
    public Bitmap e(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapM = m(i, i2, config);
        return bitmapM == null ? g(i, i2, config) : bitmapM;
    }

    public long n() {
        return this.e;
    }

    public C14698iL3(long j) {
        this(j, l(), k());
    }

    /* renamed from: ir.nasim.iL3$b */
    private static final class b implements a {
        b() {
        }

        @Override // ir.nasim.C14698iL3.a
        public void a(Bitmap bitmap) {
        }

        @Override // ir.nasim.C14698iL3.a
        public void b(Bitmap bitmap) {
        }
    }
}
