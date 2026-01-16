package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.AbstractC2027f;
import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C21664tv2;
import ir.nasim.C24452ye4;
import ir.nasim.InterfaceC22086ue4;
import ir.nasim.InterfaceC22676ve4;
import ir.nasim.InterfaceC24899zO5;
import ir.nasim.InterfaceC3749Ce4;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class a extends AbstractC2027f implements Handler.Callback {
    private final InterfaceC22676ve4 n;
    private final InterfaceC3749Ce4 o;
    private final Handler p;
    private final C24452ye4 q;
    private final boolean r;
    private InterfaceC22086ue4 s;
    private boolean t;
    private boolean u;
    private long v;
    private Metadata w;
    private long x;

    public a(InterfaceC3749Ce4 interfaceC3749Ce4, Looper looper) {
        this(interfaceC3749Ce4, looper, InterfaceC22676ve4.a);
    }

    private void Y(Metadata metadata, List list) {
        for (int i = 0; i < metadata.e(); i++) {
            X xZ = metadata.d(i).Z();
            if (xZ == null || !this.n.b(xZ)) {
                list.add(metadata.d(i));
            } else {
                InterfaceC22086ue4 interfaceC22086ue4A = this.n.a(xZ);
                byte[] bArr = (byte[]) AbstractC20011rK.e(metadata.d(i).R1());
                this.q.p();
                this.q.z(bArr.length);
                ((ByteBuffer) AbstractC9683aN7.j(this.q.c)).put(bArr);
                this.q.A();
                Metadata metadataA = interfaceC22086ue4A.a(this.q);
                if (metadataA != null) {
                    Y(metadataA, list);
                }
            }
        }
    }

    private long Z(long j) {
        AbstractC20011rK.g(j != -9223372036854775807L);
        AbstractC20011rK.g(this.x != -9223372036854775807L);
        return j - this.x;
    }

    private void a0(Metadata metadata) {
        Handler handler = this.p;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            b0(metadata);
        }
    }

    private void b0(Metadata metadata) {
        this.o.o(metadata);
    }

    private boolean c0(long j) {
        boolean z;
        Metadata metadata = this.w;
        if (metadata == null || (!this.r && metadata.b > Z(j))) {
            z = false;
        } else {
            a0(this.w);
            this.w = null;
            z = true;
        }
        if (this.t && this.w == null) {
            this.u = true;
        }
        return z;
    }

    private void d0() {
        if (this.t || this.w != null) {
            return;
        }
        this.q.p();
        C21664tv2 c21664tv2J = J();
        int iV = V(c21664tv2J, this.q, 0);
        if (iV != -4) {
            if (iV == -5) {
                this.v = ((X) AbstractC20011rK.e(c21664tv2J.b)).p;
            }
        } else {
            if (this.q.u()) {
                this.t = true;
                return;
            }
            C24452ye4 c24452ye4 = this.q;
            c24452ye4.i = this.v;
            c24452ye4.A();
            Metadata metadataA = ((InterfaceC22086ue4) AbstractC9683aN7.j(this.s)).a(this.q);
            if (metadataA != null) {
                ArrayList arrayList = new ArrayList(metadataA.e());
                Y(metadataA, arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                this.w = new Metadata(Z(this.q.e), arrayList);
            }
        }
    }

    @Override // com.google.android.exoplayer2.D0
    public void B(long j, long j2) {
        boolean zC0 = true;
        while (zC0) {
            d0();
            zC0 = c0(j);
        }
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void O() {
        this.w = null;
        this.s = null;
        this.x = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void Q(long j, boolean z) {
        this.w = null;
        this.t = false;
        this.u = false;
    }

    @Override // com.google.android.exoplayer2.AbstractC2027f
    protected void U(X[] xArr, long j, long j2) {
        this.s = this.n.a(xArr[0]);
        Metadata metadata = this.w;
        if (metadata != null) {
            this.w = metadata.c((metadata.b + this.x) - j2);
        }
        this.x = j2;
    }

    @Override // ir.nasim.InterfaceC24899zO5
    public int b(X x) {
        if (this.n.b(x)) {
            return InterfaceC24899zO5.a(x.Y == 0 ? 4 : 2);
        }
        return InterfaceC24899zO5.a(0);
    }

    @Override // com.google.android.exoplayer2.D0
    public boolean d() {
        return this.u;
    }

    @Override // com.google.android.exoplayer2.D0, ir.nasim.InterfaceC24899zO5
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // com.google.android.exoplayer2.D0
    public boolean h() {
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        b0((Metadata) message.obj);
        return true;
    }

    public a(InterfaceC3749Ce4 interfaceC3749Ce4, Looper looper, InterfaceC22676ve4 interfaceC22676ve4) {
        this(interfaceC3749Ce4, looper, interfaceC22676ve4, false);
    }

    public a(InterfaceC3749Ce4 interfaceC3749Ce4, Looper looper, InterfaceC22676ve4 interfaceC22676ve4, boolean z) {
        super(5);
        this.o = (InterfaceC3749Ce4) AbstractC20011rK.e(interfaceC3749Ce4);
        this.p = looper == null ? null : AbstractC9683aN7.u(looper, this);
        this.n = (InterfaceC22676ve4) AbstractC20011rK.e(interfaceC22676ve4);
        this.r = z;
        this.q = new C24452ye4();
        this.x = -9223372036854775807L;
    }
}
