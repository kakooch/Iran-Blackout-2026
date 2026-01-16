package ir.nasim;

import com.google.zxing.NotFoundException;

/* renamed from: ir.nasim.Ne0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6338Ne0 {
    private final AbstractC6099Me0 a;
    private C4705Gf0 b;

    public C6338Ne0(AbstractC6099Me0 abstractC6099Me0) {
        if (abstractC6099Me0 == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.a = abstractC6099Me0;
    }

    public C4705Gf0 a() {
        if (this.b == null) {
            this.b = this.a.b();
        }
        return this.b;
    }

    public C3988Df0 b(int i, C3988Df0 c3988Df0) {
        return this.a.c(i, c3988Df0);
    }

    public int c() {
        return this.a.d();
    }

    public int d() {
        return this.a.f();
    }

    public boolean e() {
        return this.a.e().f();
    }

    public C6338Ne0 f() {
        return new C6338Ne0(this.a.a(this.a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
