package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import java.util.Comparator;

/* loaded from: classes2.dex */
class S3 implements j$.util.t {
    int a;
    final int b;
    int c;
    final int d;
    Object[] e;
    final /* synthetic */ C0121a4 f;

    S3(C0121a4 c0121a4, int i, int i2, int i3, int i4) {
        this.f = c0121a4;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        Object[][] objArr = c0121a4.f;
        this.e = objArr == null ? c0121a4.e : objArr[i];
    }

    @Override // j$.util.t
    public boolean a(Consumer consumer) {
        consumer.getClass();
        int i = this.a;
        int i2 = this.b;
        if (i >= i2 && (i != i2 || this.c >= this.d)) {
            return false;
        }
        Object[] objArr = this.e;
        int i3 = this.c;
        this.c = i3 + 1;
        consumer.accept(objArr[i3]);
        if (this.c == this.e.length) {
            this.c = 0;
            int i4 = this.a + 1;
            this.a = i4;
            Object[][] objArr2 = this.f.f;
            if (objArr2 != null && i4 <= this.b) {
                this.e = objArr2[i4];
            }
        }
        return true;
    }

    @Override // j$.util.t
    public int characteristics() {
        return 16464;
    }

    @Override // j$.util.t
    public long estimateSize() {
        int i = this.a;
        int i2 = this.b;
        if (i == i2) {
            return this.d - this.c;
        }
        long[] jArr = this.f.d;
        return ((jArr[i2] + this.d) - jArr[i]) - this.c;
    }

    @Override // j$.util.t
    public void forEachRemaining(Consumer consumer) {
        int i;
        consumer.getClass();
        int i2 = this.a;
        int i3 = this.b;
        if (i2 < i3 || (i2 == i3 && this.c < this.d)) {
            int i4 = this.c;
            while (true) {
                i = this.b;
                if (i2 >= i) {
                    break;
                }
                Object[] objArr = this.f.f[i2];
                while (i4 < objArr.length) {
                    consumer.accept(objArr[i4]);
                    i4++;
                }
                i4 = 0;
                i2++;
            }
            Object[] objArr2 = this.a == i ? this.e : this.f.f[i];
            int i5 = this.d;
            while (i4 < i5) {
                consumer.accept(objArr2[i4]);
                i4++;
            }
            this.a = this.b;
            this.c = this.d;
        }
    }

    @Override // j$.util.t
    public Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // j$.util.t
    public /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0102a.e(this);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0102a.f(this, i);
    }

    @Override // j$.util.t
    public j$.util.t trySplit() {
        int i = this.a;
        int i2 = this.b;
        if (i < i2) {
            C0121a4 c0121a4 = this.f;
            int i3 = i2 - 1;
            S3 s3 = new S3(c0121a4, i, i3, this.c, c0121a4.f[i3].length);
            int i4 = this.b;
            this.a = i4;
            this.c = 0;
            this.e = this.f.f[i4];
            return s3;
        }
        if (i != i2) {
            return null;
        }
        int i5 = this.d;
        int i6 = this.c;
        int i7 = (i5 - i6) / 2;
        if (i7 == 0) {
            return null;
        }
        j$.util.t tVarM = j$.util.J.m(this.e, i6, i6 + i7, 1040);
        this.c += i7;
        return tVarM;
    }
}
