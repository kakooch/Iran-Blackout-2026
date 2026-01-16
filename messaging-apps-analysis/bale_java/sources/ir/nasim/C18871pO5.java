package ir.nasim;

import android.graphics.PointF;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: ir.nasim.pO5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C18871pO5 {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public double g;
    private int h;
    private int i;
    private ByteBuffer j;

    public boolean a(PointF pointF, float f, float f2, float f3, int i) {
        if ((i != -1 && i >= this.i) || this.j.position() == this.j.limit()) {
            g();
            return false;
        }
        if (i != -1) {
            this.j.position(i * 20);
        }
        this.j.putFloat(pointF.x);
        this.j.putFloat(pointF.y);
        this.j.putFloat(f);
        this.j.putFloat(f2);
        this.j.putFloat(f3);
        return true;
    }

    public void b(int i) {
        int i2 = this.h + i;
        if (i2 > this.i || this.j == null) {
            g();
        }
        this.h = i2;
    }

    public int c() {
        return this.h;
    }

    public void d() {
        this.h = 0;
        if (this.j != null) {
            return;
        }
        this.i = 256;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(256 * 5 * 4);
        this.j = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        this.j.position(0);
    }

    public float e() {
        return this.j.getFloat();
    }

    public void f() {
        this.h = 0;
        this.g = 0.0d;
        ByteBuffer byteBuffer = this.j;
        if (byteBuffer != null) {
            byteBuffer.position(0);
        }
    }

    public void g() {
        if (this.j != null) {
            this.j = null;
        }
        int iMax = Math.max(this.i * 2, 256);
        this.i = iMax;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iMax * 20);
        this.j = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        this.j.position(0);
    }

    public void h(int i) {
        ByteBuffer byteBuffer = this.j;
        if (byteBuffer == null || i < 0 || i >= this.i) {
            return;
        }
        byteBuffer.position(i * 20);
    }
}
