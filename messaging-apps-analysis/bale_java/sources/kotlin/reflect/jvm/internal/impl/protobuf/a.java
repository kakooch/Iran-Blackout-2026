package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.l;

/* loaded from: classes8.dex */
public abstract class a implements l {
    protected int a = 0;

    UninitializedMessageException c() {
        return new UninitializedMessageException(this);
    }

    public void d(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream codedOutputStreamI = CodedOutputStream.I(outputStream, CodedOutputStream.t(CodedOutputStream.u(serializedSize) + serializedSize));
        codedOutputStreamI.n0(serializedSize);
        b(codedOutputStreamI);
        codedOutputStreamI.H();
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC1828a implements l.a {
        protected static UninitializedMessageException c(l lVar) {
            return new UninitializedMessageException(lVar);
        }

        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a$a, reason: collision with other inner class name */
        static final class C1829a extends FilterInputStream {
            private int a;

            C1829a(InputStream inputStream, int i) {
                super(inputStream);
                this.a = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.a <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i >= 0) {
                    this.a--;
                }
                return i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) throws IOException {
                long jSkip = super.skip(Math.min(j, this.a));
                if (jSkip >= 0) {
                    this.a = (int) (this.a - jSkip);
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.a;
                if (i3 <= 0) {
                    return -1;
                }
                int i4 = super.read(bArr, i, Math.min(i2, i3));
                if (i4 >= 0) {
                    this.a -= i4;
                }
                return i4;
            }
        }
    }
}
