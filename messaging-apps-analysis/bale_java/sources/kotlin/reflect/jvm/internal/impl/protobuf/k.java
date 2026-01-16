package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: classes8.dex */
class k extends d {
    protected final byte[] b;
    private int c = 0;

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
            try {
                byte[] bArr = k.this.b;
                int i = this.a;
                this.a = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b() {
            this.a = 0;
            this.b = k.this.size();
        }
    }

    k(byte[] bArr) {
        this.b = bArr;
    }

    static int R(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean A() {
        int iQ = Q();
        return o.f(this.b, iQ, size() + iQ);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int C(int i, int i2, int i3) {
        return R(i, this.b, Q() + i2, i3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int D(int i, int i2, int i3) {
        int iQ = Q() + i2;
        return o.g(i, this.b, iQ, i3 + iQ);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int E() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String I(String str) {
        return new String(this.b, Q(), size(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void O(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.b, Q() + i, i2);
    }

    boolean P(k kVar, int i, int i2) {
        if (i2 > kVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i + i2 > kVar.size()) {
            int size2 = kVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.b;
        byte[] bArr2 = kVar.b;
        int iQ = Q() + i2;
        int iQ2 = Q();
        int iQ3 = kVar.Q() + i;
        while (iQ2 < iQ) {
            if (bArr[iQ2] != bArr2[iQ3]) {
                return false;
            }
            iQ2++;
            iQ3++;
        }
        return true;
    }

    protected int Q() {
        return 0;
    }

    @Override // java.lang.Iterable
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public d.a iterator() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) || size() != ((d) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof k) {
            return P((k) obj, 0, size());
        }
        if (obj instanceof m) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 49);
        sb.append("Has a new type of ByteString been created? Found ");
        sb.append(strValueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    public int hashCode() {
        int iC = this.c;
        if (iC == 0) {
            int size = size();
            iC = C(size, 0, size);
            if (iC == 0) {
                iC = 1;
            }
            this.c = iC;
        }
        return iC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.b.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void v(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.b, i, bArr, i2, i3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int w() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean x() {
        return true;
    }
}
