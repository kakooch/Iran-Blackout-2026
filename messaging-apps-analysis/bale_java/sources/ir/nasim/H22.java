package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class H22 extends N0 {
    private static final /* synthetic */ InterfaceC5446Jj3.a v = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a w = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a x = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a y = null;

    static {
        n();
    }

    public H22() {
        super("esds");
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("ESDescriptorBox.java", H22.class);
        v = c20224rf2.f("method-execution", c20224rf2.e("1", "getEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor"), 33);
        w = c20224rf2.f("method-execution", c20224rf2.e("1", "setEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 37);
        x = c20224rf2.f("method-execution", c20224rf2.e("1", "equals", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "java.lang.Object", "o", "", "boolean"), 42);
        y = c20224rf2.f("method-execution", c20224rf2.e("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "int"), 53);
    }

    public boolean equals(Object obj) {
        C18943pW5.b().c(C20224rf2.d(x, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ByteBuffer byteBuffer = this.o;
        ByteBuffer byteBuffer2 = ((H22) obj).o;
        return byteBuffer == null ? byteBuffer2 == null : byteBuffer.equals(byteBuffer2);
    }

    public int hashCode() {
        C18943pW5.b().c(C20224rf2.c(y, this, this));
        ByteBuffer byteBuffer = this.o;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }
}
