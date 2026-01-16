package ir.nasim;

import com.google.android.exoplayer2.source.TrackGroupArray;

/* renamed from: ir.nasim.nE1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17595nE1 implements RF3 {
    private final UB1 a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final int f;
    private final boolean g;
    private final long h;
    private final boolean i;
    private int j;
    private boolean k;

    /* renamed from: ir.nasim.nE1$a */
    public static final class a {
        private UB1 a;
        private int b = 50000;
        private int c = 50000;
        private int d = 2500;
        private int e = 5000;
        private int f = -1;
        private boolean g = false;
        private int h = 0;
        private boolean i = false;
        private boolean j;

        public C17595nE1 a() {
            AbstractC20011rK.g(!this.j);
            this.j = true;
            if (this.a == null) {
                this.a = new UB1(true, 65536);
            }
            return new C17595nE1(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }

        public a b(UB1 ub1) {
            AbstractC20011rK.g(!this.j);
            this.a = ub1;
            return this;
        }

        public a c(int i, int i2, int i3, int i4) {
            AbstractC20011rK.g(!this.j);
            C17595nE1.k(i3, 0, "bufferForPlaybackMs", "0");
            C17595nE1.k(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
            C17595nE1.k(i, i3, "minBufferMs", "bufferForPlaybackMs");
            C17595nE1.k(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            C17595nE1.k(i2, i, "maxBufferMs", "minBufferMs");
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            return this;
        }

        public a d(boolean z) {
            AbstractC20011rK.g(!this.j);
            this.g = z;
            return this;
        }

        public a e(int i) {
            AbstractC20011rK.g(!this.j);
            this.f = i;
            return this;
        }
    }

    public C17595nE1() {
        this(new UB1(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(int i, int i2, String str, String str2) {
        AbstractC20011rK.b(i >= i2, str + " cannot be less than " + str2);
    }

    private static int m(int i) {
        switch (i) {
            case -2:
                return 0;
            case -1:
            default:
                throw new IllegalArgumentException();
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
        }
    }

    private void n(boolean z) {
        int i = this.f;
        if (i == -1) {
            i = 13107200;
        }
        this.j = i;
        this.k = false;
        if (z) {
            this.a.g();
        }
    }

    @Override // ir.nasim.RF3
    public boolean a() {
        return this.i;
    }

    @Override // ir.nasim.RF3
    public void b() {
        n(false);
    }

    @Override // ir.nasim.RF3
    public long c() {
        return this.h;
    }

    @Override // ir.nasim.RF3
    public boolean d(long j, float f, boolean z, long j2) {
        long jD0 = AbstractC9683aN7.d0(j, f);
        long jMin = z ? this.e : this.d;
        if (j2 != -9223372036854775807L) {
            jMin = Math.min(j2 / 2, jMin);
        }
        return jMin <= 0 || jD0 >= jMin || (!this.g && this.a.f() >= this.j);
    }

    @Override // ir.nasim.RF3
    public InterfaceC19684qm e() {
        return this.a;
    }

    @Override // ir.nasim.RF3
    public void f() {
        n(true);
    }

    @Override // ir.nasim.RF3
    public void g(com.google.android.exoplayer2.D0[] d0Arr, TrackGroupArray trackGroupArray, InterfaceC13679ge2[] interfaceC13679ge2Arr) {
        int iL = this.f;
        if (iL == -1) {
            iL = l(d0Arr, interfaceC13679ge2Arr);
        }
        this.j = iL;
        this.a.h(iL);
    }

    @Override // ir.nasim.RF3
    public void h() {
        n(true);
    }

    @Override // ir.nasim.RF3
    public boolean i(long j, long j2, float f) {
        boolean z = true;
        boolean z2 = this.a.f() >= this.j;
        long jMin = this.b;
        if (f > 1.0f) {
            jMin = Math.min(AbstractC9683aN7.Y(jMin, f), this.c);
        }
        if (j2 < Math.max(jMin, 500000L)) {
            if (!this.g && z2) {
                z = false;
            }
            this.k = z;
            if (!z && j2 < 500000) {
                AbstractC18815pI3.k("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.c || z2) {
            this.k = false;
        }
        return this.k;
    }

    protected int l(com.google.android.exoplayer2.D0[] d0Arr, InterfaceC13679ge2[] interfaceC13679ge2Arr) {
        int iM = 0;
        for (int i = 0; i < d0Arr.length; i++) {
            if (interfaceC13679ge2Arr[i] != null) {
                iM += m(d0Arr[i].g());
            }
        }
        return Math.max(13107200, iM);
    }

    protected C17595nE1(UB1 ub1, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        k(i3, 0, "bufferForPlaybackMs", "0");
        k(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        k(i, i3, "minBufferMs", "bufferForPlaybackMs");
        k(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        k(i2, i, "maxBufferMs", "minBufferMs");
        k(i6, 0, "backBufferDurationMs", "0");
        this.a = ub1;
        this.b = AbstractC9683aN7.B0(i);
        this.c = AbstractC9683aN7.B0(i2);
        this.d = AbstractC9683aN7.B0(i3);
        this.e = AbstractC9683aN7.B0(i4);
        this.f = i5;
        this.j = i5 == -1 ? 13107200 : i5;
        this.g = z;
        this.h = AbstractC9683aN7.B0(i6);
        this.i = z2;
    }
}
