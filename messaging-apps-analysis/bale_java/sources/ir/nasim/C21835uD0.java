package ir.nasim;

import com.google.android.exoplayer2.AbstractC2027f;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.uD0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21835uD0 extends AbstractC2027f {
    private final DecoderInputBuffer n;
    private final EW4 o;
    private long p;
    private InterfaceC21161tD0 q;
    private long r;

    public C21835uD0() {
        super(6);
        this.n = new DecoderInputBuffer(1);
        this.o = new EW4();
    }

    private float[] Y(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.o.Q(byteBuffer.array(), byteBuffer.limit());
        this.o.S(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = Float.intBitsToFloat(this.o.s());
        }
        return fArr;
    }

    private void Z() {
        InterfaceC21161tD0 interfaceC21161tD0 = this.q;
        if (interfaceC21161tD0 != null) {
            interfaceC21161tD0.c();
        }
    }

    @Override // com.google.android.exoplayer2.D0
    public void B(long j, long j2) {
        while (!j() && this.r < 100000 + j) {
            this.n.p();
            if (V(J(), this.n, 0) != -4 || this.n.u()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.n;
            this.r = decoderInputBuffer.e;
            if (this.q != null && !decoderInputBuffer.t()) {
                this.n.A();
                float[] fArrY = Y((ByteBuffer) AbstractC9683aN7.j(this.n.c));
                if (fArrY != null) {
                    ((InterfaceC21161tD0) AbstractC9683aN7.j(this.q)).b(this.r - this.p, fArrY);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void O() {
        Z();
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void Q(long j, boolean z) {
        this.r = Long.MIN_VALUE;
        Z();
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void U(com.google.android.exoplayer2.X[] xArr, long j, long j2) {
        this.p = j2;
    }

    @Override // ir.nasim.InterfaceC24899zO5
    public int b(com.google.android.exoplayer2.X x) {
        return "application/x-camera-motion".equals(x.l) ? InterfaceC24899zO5.a(4) : InterfaceC24899zO5.a(0);
    }

    @Override // com.google.android.exoplayer2.D0
    public boolean d() {
        return j();
    }

    @Override // com.google.android.exoplayer2.D0, ir.nasim.InterfaceC24899zO5
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.exoplayer2.D0
    public boolean h() {
        return true;
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f, com.google.android.exoplayer2.A0.b
    public void q(int i, Object obj) {
        if (i == 8) {
            this.q = (InterfaceC21161tD0) obj;
        } else {
            super.q(i, obj);
        }
    }
}
