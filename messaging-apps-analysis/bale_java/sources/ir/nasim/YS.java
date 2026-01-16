package ir.nasim;

import android.content.Context;

/* loaded from: classes2.dex */
final class YS extends AbstractC18584ou1 {
    private final Context a;
    private final QV0 b;
    private final QV0 c;
    private final String d;

    YS(Context context, QV0 qv0, QV0 qv02, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.a = context;
        if (qv0 == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.b = qv0;
        if (qv02 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.c = qv02;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.d = str;
    }

    @Override // ir.nasim.AbstractC18584ou1
    public Context b() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC18584ou1
    public String c() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC18584ou1
    public QV0 d() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC18584ou1
    public QV0 e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC18584ou1)) {
            return false;
        }
        AbstractC18584ou1 abstractC18584ou1 = (AbstractC18584ou1) obj;
        return this.a.equals(abstractC18584ou1.b()) && this.b.equals(abstractC18584ou1.e()) && this.c.equals(abstractC18584ou1.d()) && this.d.equals(abstractC18584ou1.c());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.a + ", wallClock=" + this.b + ", monotonicClock=" + this.c + ", backendName=" + this.d + "}";
    }
}
