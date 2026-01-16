package ir.nasim;

import java.nio.ByteBuffer;

/* renamed from: ir.nasim.gz1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13885gz1 {
    private final ByteBuffer a;
    private final int b;

    public C13885gz1(ByteBuffer byteBuffer, int i) {
        AbstractC13042fc3.i(byteBuffer, "data");
        this.a = byteBuffer;
        this.b = i;
    }

    public final ByteBuffer a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13885gz1)) {
            return false;
        }
        C13885gz1 c13885gz1 = (C13885gz1) obj;
        return AbstractC13042fc3.d(this.a, c13885gz1.a) && this.b == c13885gz1.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "DataPacketItem(data=" + this.a + ", sequence=" + this.b + ')';
    }
}
