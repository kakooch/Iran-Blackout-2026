package ir.nasim;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* renamed from: ir.nasim.yB7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C24190yB7 extends H90 {
    private static Logger e = Logger.getLogger(C24190yB7.class.getName());
    private ByteBuffer d;

    @Override // ir.nasim.H90
    public void e(ByteBuffer byteBuffer) {
        this.d = (ByteBuffer) byteBuffer.slice().limit(c());
    }

    public String toString() {
        return "UnknownDescriptor{tag=" + this.a + ", sizeOfInstance=" + this.b + ", data=" + this.d + '}';
    }
}
