package ir.nasim;

import ir.nasim.InterfaceC5446Jj3;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class N0 extends R0 {
    private static Logger p;
    private static final /* synthetic */ InterfaceC5446Jj3.a q = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a r = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a s = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a t = null;
    private static final /* synthetic */ InterfaceC5446Jj3.a u = null;
    protected H90 n;
    protected ByteBuffer o;

    static {
        n();
        p = Logger.getLogger(N0.class.getName());
    }

    public N0(String str) {
        super(str);
    }

    private static /* synthetic */ void n() {
        C20224rf2 c20224rf2 = new C20224rf2("AbstractDescriptorBox.java", N0.class);
        q = c20224rf2.f("method-execution", c20224rf2.e("1", "getData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.nio.ByteBuffer"), 42);
        r = c20224rf2.f("method-execution", c20224rf2.e("1", "getDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor"), 58);
        s = c20224rf2.f("method-execution", c20224rf2.e("1", "getDescriptorAsString", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.lang.String"), 62);
        t = c20224rf2.f("method-execution", c20224rf2.e("1", "setDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor", "descriptor", "", "void"), 66);
        u = c20224rf2.f("method-execution", c20224rf2.e("1", "setData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "java.nio.ByteBuffer", "data", "", "void"), 70);
    }

    @Override // ir.nasim.D0
    public void a(ByteBuffer byteBuffer) {
        q(byteBuffer);
        this.o = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        try {
            this.o.rewind();
            this.n = AbstractC18798pG4.a(-1, this.o);
        } catch (IOException e) {
            p.log(Level.WARNING, "Error parsing ObjectDescriptor", (Throwable) e);
        } catch (IndexOutOfBoundsException e2) {
            p.log(Level.WARNING, "Error parsing ObjectDescriptor", (Throwable) e2);
        }
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        t(byteBuffer);
        this.o.rewind();
        byteBuffer.put(this.o);
    }

    @Override // ir.nasim.D0
    protected long c() {
        return this.o.limit() + 4;
    }

    public void u(ByteBuffer byteBuffer) {
        C18943pW5.b().c(C20224rf2.d(u, this, this, byteBuffer));
        this.o = byteBuffer;
    }
}
