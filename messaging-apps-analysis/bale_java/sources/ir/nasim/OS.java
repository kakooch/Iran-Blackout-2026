package ir.nasim;

import ir.nasim.YV;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class OS extends YV {
    private final Iterable a;
    private final byte[] b;

    static final class b extends YV.a {
        private Iterable a;
        private byte[] b;

        b() {
        }

        @Override // ir.nasim.YV.a
        public YV a() {
            String str = "";
            if (this.a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new OS(this.a, this.b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.YV.a
        public YV.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.a = iterable;
            return this;
        }

        @Override // ir.nasim.YV.a
        public YV.a c(byte[] bArr) {
            this.b = bArr;
            return this;
        }
    }

    @Override // ir.nasim.YV
    public Iterable b() {
        return this.a;
    }

    @Override // ir.nasim.YV
    public byte[] c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof YV)) {
            return false;
        }
        YV yv = (YV) obj;
        if (this.a.equals(yv.b())) {
            if (Arrays.equals(this.b, yv instanceof OS ? ((OS) yv).b : yv.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.a + ", extras=" + Arrays.toString(this.b) + "}";
    }

    private OS(Iterable iterable, byte[] bArr) {
        this.a = iterable;
        this.b = bArr;
    }
}
