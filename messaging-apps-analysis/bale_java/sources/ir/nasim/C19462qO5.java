package ir.nasim;

import android.graphics.PointF;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: ir.nasim.qO5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C19462qO5 {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public double f;
    private int g;
    private int h;
    private ByteBuffer i;

    public boolean a(PointF pointF, float f, float f2, float f3, int i) {
        if ((i != -1 && i >= this.h) || this.i.position() == this.i.limit()) {
            g();
            return false;
        }
        if (i != -1) {
            this.i.position(i * 20);
        }
        this.i.putFloat(pointF.x);
        this.i.putFloat(pointF.y);
        this.i.putFloat(f);
        this.i.putFloat(f2);
        this.i.putFloat(f3);
        return true;
    }

    public void b(int i) {
        int i2 = this.g + i;
        if (i2 > this.h || this.i == null) {
            g();
        }
        this.g = i2;
    }

    public int c() {
        return this.g;
    }

    public void d() {
        this.g = 0;
        if (this.i != null) {
            return;
        }
        this.h = 256;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(256 * 5 * 4);
        this.i = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        this.i.position(0);
    }

    public float e() {
        return this.i.getFloat();
    }

    public void f() {
        this.g = 0;
        this.f = 0.0d;
        ByteBuffer byteBuffer = this.i;
        if (byteBuffer != null) {
            byteBuffer.position(0);
        }
    }

    public void g() {
        if (this.i != null) {
            this.i = null;
        }
        int iMax = Math.max(this.h * 2, 256);
        this.h = iMax;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iMax * 20);
        this.i = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        this.i.position(0);
    }

    public void h(int i) {
        ByteBuffer byteBuffer = this.i;
        if (byteBuffer == null || i < 0 || i >= this.h) {
            return;
        }
        byteBuffer.position(i * 20);
    }
}
