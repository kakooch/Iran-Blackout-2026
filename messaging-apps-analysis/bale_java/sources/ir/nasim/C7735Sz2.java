package ir.nasim;

import java.io.EOFException;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Source;

/* renamed from: ir.nasim.Sz2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7735Sz2 extends ForwardingSource {
    private static final a b = new a(null);
    private static final ByteString c = ByteString.INSTANCE.decodeHex("0021F904");
    private final Buffer a;

    /* renamed from: ir.nasim.Sz2$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C7735Sz2(Source source) {
        super(source);
        this.a = new Buffer();
    }

    private final long a(Buffer buffer, long j) {
        return AbstractC23053wG5.f(this.a.read(buffer, j), 0L);
    }

    private final long indexOf(ByteString byteString) {
        long jIndexOf = -1;
        while (true) {
            jIndexOf = this.a.indexOf(byteString.getByte(0), jIndexOf + 1);
            if (jIndexOf == -1 || (request(byteString.size()) && this.a.rangeEquals(jIndexOf, byteString))) {
                break;
            }
        }
        return jIndexOf;
    }

    private final boolean request(long j) {
        if (this.a.size() >= j) {
            return true;
        }
        long size = j - this.a.size();
        return super.read(this.a, size) == size;
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer buffer, long j) throws EOFException {
        request(j);
        if (this.a.size() == 0) {
            return j == 0 ? 0L : -1L;
        }
        long jA = 0;
        while (true) {
            long jIndexOf = indexOf(c);
            if (jIndexOf == -1) {
                break;
            }
            jA += a(buffer, jIndexOf + 4);
            if (request(5L) && this.a.getByte(4L) == 0 && (((C7743Sz7.h(this.a.getByte(2L)) & 255) << 8) | (C7743Sz7.h(this.a.getByte(1L)) & 255)) < 2) {
                buffer.writeByte((int) this.a.getByte(0L));
                buffer.writeByte(10);
                buffer.writeByte(0);
                this.a.skip(3L);
            }
        }
        if (jA < j) {
            jA += a(buffer, j - jA);
        }
        if (jA == 0) {
            return -1L;
        }
        return jA;
    }
}
