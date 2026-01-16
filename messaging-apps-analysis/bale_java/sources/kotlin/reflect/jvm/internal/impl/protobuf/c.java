package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: classes8.dex */
class c extends k {
    private final int d;
    private final int e;

    private class b implements d.a {
        private int a;
        private final int b;

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(j());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte j() {
            int i = this.a;
            if (i >= this.b) {
                throw new NoSuchElementException();
            }
            byte[] bArr = c.this.b;
            this.a = i + 1;
            return bArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b() {
            int iQ = c.this.Q();
            this.a = iQ;
            this.b = iQ + c.this.size();
        }
    }

    c(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Offset too small: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 < 0) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Length too small: ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i + i2 <= bArr.length) {
            this.d = i;
            this.e = i2;
            return;
        }
        StringBuilder sb3 = new StringBuilder(48);
        sb3.append("Offset+Length too large: ");
        sb3.append(i);
        sb3.append("+");
        sb3.append(i2);
        throw new IllegalArgumentException(sb3.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.k
    protected int Q() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.k, java.lang.Iterable
    /* renamed from: S */
    public d.a iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.k, kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.k, kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void v(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.b, Q() + i, bArr, i2, i3);
    }
}
