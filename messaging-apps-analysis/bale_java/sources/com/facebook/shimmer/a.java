package com.facebook.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import ir.nasim.BE5;

/* loaded from: classes2.dex */
public class a {
    final float[] a = new float[4];
    final int[] b = new int[4];
    final RectF c = new RectF();
    int d = 0;
    int e = -1;
    int f = 1291845631;
    int g = 0;
    int h = 0;
    int i = 0;
    float j = 1.0f;
    float k = 1.0f;
    float l = 0.0f;
    float m = 0.5f;
    float n = 20.0f;
    boolean o = true;
    boolean p = true;
    boolean q = true;
    int r = -1;
    int s = 1;
    long t = 1000;
    long u;

    /* renamed from: com.facebook.shimmer.a$a, reason: collision with other inner class name */
    public static class C0157a extends b {
        public C0157a() {
            this.a.q = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.shimmer.a.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public C0157a d() {
            return this;
        }
    }

    public static abstract class b {
        final a a = new a();

        private static float b(float f, float f2, float f3) {
            return Math.min(f2, Math.max(f, f3));
        }

        public a a() {
            this.a.b();
            this.a.c();
            return this.a;
        }

        b c(TypedArray typedArray) {
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_clip_to_children)) {
                g(typedArray.getBoolean(BE5.ShimmerFrameLayout_shimmer_clip_to_children, this.a.o));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_auto_start)) {
                e(typedArray.getBoolean(BE5.ShimmerFrameLayout_shimmer_auto_start, this.a.p));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_base_alpha)) {
                f(typedArray.getFloat(BE5.ShimmerFrameLayout_shimmer_base_alpha, 0.3f));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_highlight_alpha)) {
                n(typedArray.getFloat(BE5.ShimmerFrameLayout_shimmer_highlight_alpha, 1.0f));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_duration)) {
                j(typedArray.getInt(BE5.ShimmerFrameLayout_shimmer_duration, (int) this.a.t));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_repeat_count)) {
                p(typedArray.getInt(BE5.ShimmerFrameLayout_shimmer_repeat_count, this.a.r));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_repeat_delay)) {
                q(typedArray.getInt(BE5.ShimmerFrameLayout_shimmer_repeat_delay, (int) this.a.u));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_repeat_mode)) {
                r(typedArray.getInt(BE5.ShimmerFrameLayout_shimmer_repeat_mode, this.a.s));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_direction)) {
                int i = typedArray.getInt(BE5.ShimmerFrameLayout_shimmer_direction, this.a.d);
                if (i == 1) {
                    h(1);
                } else if (i == 2) {
                    h(2);
                } else if (i != 3) {
                    h(0);
                } else {
                    h(3);
                }
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_shape)) {
                if (typedArray.getInt(BE5.ShimmerFrameLayout_shimmer_shape, this.a.g) != 1) {
                    s(0);
                } else {
                    s(1);
                }
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_dropoff)) {
                i(typedArray.getFloat(BE5.ShimmerFrameLayout_shimmer_dropoff, this.a.m));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_fixed_width)) {
                l(typedArray.getDimensionPixelSize(BE5.ShimmerFrameLayout_shimmer_fixed_width, this.a.h));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_fixed_height)) {
                k(typedArray.getDimensionPixelSize(BE5.ShimmerFrameLayout_shimmer_fixed_height, this.a.i));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_intensity)) {
                o(typedArray.getFloat(BE5.ShimmerFrameLayout_shimmer_intensity, this.a.l));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_width_ratio)) {
                u(typedArray.getFloat(BE5.ShimmerFrameLayout_shimmer_width_ratio, this.a.j));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_height_ratio)) {
                m(typedArray.getFloat(BE5.ShimmerFrameLayout_shimmer_height_ratio, this.a.k));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_tilt)) {
                t(typedArray.getFloat(BE5.ShimmerFrameLayout_shimmer_tilt, this.a.n));
            }
            return d();
        }

        protected abstract b d();

        public b e(boolean z) {
            this.a.p = z;
            return d();
        }

        public b f(float f) {
            int iB = (int) (b(0.0f, 1.0f, f) * 255.0f);
            a aVar = this.a;
            aVar.f = (iB << 24) | (aVar.f & 16777215);
            return d();
        }

        public b g(boolean z) {
            this.a.o = z;
            return d();
        }

        public b h(int i) {
            this.a.d = i;
            return d();
        }

        public b i(float f) {
            if (f >= 0.0f) {
                this.a.m = f;
                return d();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f);
        }

        public b j(long j) {
            if (j >= 0) {
                this.a.t = j;
                return d();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j);
        }

        public b k(int i) {
            if (i >= 0) {
                this.a.i = i;
                return d();
            }
            throw new IllegalArgumentException("Given invalid height: " + i);
        }

        public b l(int i) {
            if (i >= 0) {
                this.a.h = i;
                return d();
            }
            throw new IllegalArgumentException("Given invalid width: " + i);
        }

        public b m(float f) {
            if (f >= 0.0f) {
                this.a.k = f;
                return d();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f);
        }

        public b n(float f) {
            int iB = (int) (b(0.0f, 1.0f, f) * 255.0f);
            a aVar = this.a;
            aVar.e = (iB << 24) | (aVar.e & 16777215);
            return d();
        }

        public b o(float f) {
            if (f >= 0.0f) {
                this.a.l = f;
                return d();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f);
        }

        public b p(int i) {
            this.a.r = i;
            return d();
        }

        public b q(long j) {
            if (j >= 0) {
                this.a.u = j;
                return d();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j);
        }

        public b r(int i) {
            this.a.s = i;
            return d();
        }

        public b s(int i) {
            this.a.g = i;
            return d();
        }

        public b t(float f) {
            this.a.n = f;
            return d();
        }

        public b u(float f) {
            if (f >= 0.0f) {
                this.a.j = f;
                return d();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f);
        }
    }

    public static class c extends b {
        public c() {
            this.a.q = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.facebook.shimmer.a.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public c c(TypedArray typedArray) {
            super.c(typedArray);
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_base_color)) {
                x(typedArray.getColor(BE5.ShimmerFrameLayout_shimmer_base_color, this.a.f));
            }
            if (typedArray.hasValue(BE5.ShimmerFrameLayout_shimmer_highlight_color)) {
                y(typedArray.getColor(BE5.ShimmerFrameLayout_shimmer_highlight_color, this.a.e));
            }
            return d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.shimmer.a.b
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public c d() {
            return this;
        }

        public c x(int i) {
            a aVar = this.a;
            aVar.f = (i & 16777215) | (aVar.f & (-16777216));
            return d();
        }

        public c y(int i) {
            this.a.e = i;
            return d();
        }
    }

    a() {
    }

    int a(int i) {
        int i2 = this.i;
        return i2 > 0 ? i2 : Math.round(this.k * i);
    }

    void b() {
        if (this.g != 1) {
            int[] iArr = this.b;
            int i = this.f;
            iArr[0] = i;
            int i2 = this.e;
            iArr[1] = i2;
            iArr[2] = i2;
            iArr[3] = i;
            return;
        }
        int[] iArr2 = this.b;
        int i3 = this.e;
        iArr2[0] = i3;
        iArr2[1] = i3;
        int i4 = this.f;
        iArr2[2] = i4;
        iArr2[3] = i4;
    }

    void c() {
        if (this.g != 1) {
            this.a[0] = Math.max(((1.0f - this.l) - this.m) / 2.0f, 0.0f);
            this.a[1] = Math.max(((1.0f - this.l) - 0.001f) / 2.0f, 0.0f);
            this.a[2] = Math.min(((this.l + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.a[3] = Math.min(((this.l + 1.0f) + this.m) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.l, 1.0f);
        this.a[2] = Math.min(this.l + this.m, 1.0f);
        this.a[3] = 1.0f;
    }

    int d(int i) {
        int i2 = this.h;
        return i2 > 0 ? i2 : Math.round(this.j * i);
    }
}
