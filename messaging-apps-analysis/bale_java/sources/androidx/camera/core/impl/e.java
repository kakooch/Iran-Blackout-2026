package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.w;
import ir.nasim.C15116j22;

/* loaded from: classes.dex */
final class e extends w {
    private final Size b;
    private final C15116j22 c;
    private final Range d;
    private final j e;
    private final boolean f;

    static final class b extends w.a {
        private Size a;
        private C15116j22 b;
        private Range c;
        private j d;
        private Boolean e;

        @Override // androidx.camera.core.impl.w.a
        public w a() {
            String str = "";
            if (this.a == null) {
                str = " resolution";
            }
            if (this.b == null) {
                str = str + " dynamicRange";
            }
            if (this.c == null) {
                str = str + " expectedFrameRateRange";
            }
            if (this.e == null) {
                str = str + " zslDisabled";
            }
            if (str.isEmpty()) {
                return new e(this.a, this.b, this.c, this.d, this.e.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.core.impl.w.a
        public w.a b(C15116j22 c15116j22) {
            if (c15116j22 == null) {
                throw new NullPointerException("Null dynamicRange");
            }
            this.b = c15116j22;
            return this;
        }

        @Override // androidx.camera.core.impl.w.a
        public w.a c(Range range) {
            if (range == null) {
                throw new NullPointerException("Null expectedFrameRateRange");
            }
            this.c = range;
            return this;
        }

        @Override // androidx.camera.core.impl.w.a
        public w.a d(j jVar) {
            this.d = jVar;
            return this;
        }

        @Override // androidx.camera.core.impl.w.a
        public w.a e(Size size) {
            if (size == null) {
                throw new NullPointerException("Null resolution");
            }
            this.a = size;
            return this;
        }

        @Override // androidx.camera.core.impl.w.a
        public w.a f(boolean z) {
            this.e = Boolean.valueOf(z);
            return this;
        }

        b() {
        }

        private b(w wVar) {
            this.a = wVar.e();
            this.b = wVar.b();
            this.c = wVar.c();
            this.d = wVar.d();
            this.e = Boolean.valueOf(wVar.f());
        }
    }

    @Override // androidx.camera.core.impl.w
    public C15116j22 b() {
        return this.c;
    }

    @Override // androidx.camera.core.impl.w
    public Range c() {
        return this.d;
    }

    @Override // androidx.camera.core.impl.w
    public j d() {
        return this.e;
    }

    @Override // androidx.camera.core.impl.w
    public Size e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        j jVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.b.equals(wVar.e()) && this.c.equals(wVar.b()) && this.d.equals(wVar.c()) && ((jVar = this.e) != null ? jVar.equals(wVar.d()) : wVar.d() == null) && this.f == wVar.f();
    }

    @Override // androidx.camera.core.impl.w
    public boolean f() {
        return this.f;
    }

    @Override // androidx.camera.core.impl.w
    public w.a g() {
        return new b(this);
    }

    public int hashCode() {
        int iHashCode = (((((this.b.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        j jVar = this.e;
        return ((iHashCode ^ (jVar == null ? 0 : jVar.hashCode())) * 1000003) ^ (this.f ? 1231 : 1237);
    }

    public String toString() {
        return "StreamSpec{resolution=" + this.b + ", dynamicRange=" + this.c + ", expectedFrameRateRange=" + this.d + ", implementationOptions=" + this.e + ", zslDisabled=" + this.f + "}";
    }

    private e(Size size, C15116j22 c15116j22, Range range, j jVar, boolean z) {
        this.b = size;
        this.c = c15116j22;
        this.d = range;
        this.e = jVar;
        this.f = z;
    }
}
