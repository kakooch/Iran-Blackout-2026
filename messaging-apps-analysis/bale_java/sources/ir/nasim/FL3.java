package ir.nasim;

import android.media.MediaCodec;
import android.media.MediaFormat;
import ir.nasim.C14234ha6;
import ir.nasim.C16040kc1;
import ir.nasim.C17368mq7;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes7.dex */
public class FL3 {
    private a a = null;
    private C3803Ck4 b = null;
    private FileOutputStream c = null;
    private FileChannel d = null;
    private long e = 0;
    private long f = 0;
    private boolean g = true;
    private HashMap h = new HashMap();
    private ByteBuffer i = null;
    private boolean j;

    private static class a implements InterfaceC4984Hk0 {
        private InterfaceC12511ek1 a;
        private long b;
        private long c;

        private boolean c(long j) {
            return j + 8 < 4294967296L;
        }

        public long a() {
            return this.b;
        }

        public long b() {
            return this.c;
        }

        public void d(long j) {
            this.b = j;
        }

        public void e(long j) {
            this.c = j;
        }

        @Override // ir.nasim.InterfaceC4984Hk0
        public long f() {
            return this.b + 16;
        }

        @Override // ir.nasim.InterfaceC4984Hk0
        public void g(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            long jF = f();
            if (c(jF)) {
                AbstractC5869Le3.g(byteBufferAllocate, jF);
            } else {
                AbstractC5869Le3.g(byteBufferAllocate, 1L);
            }
            byteBufferAllocate.put(AbstractC5401Je3.l("mdat"));
            if (c(jF)) {
                byteBufferAllocate.put(new byte[8]);
            } else {
                AbstractC5869Le3.i(byteBufferAllocate, jF);
            }
            byteBufferAllocate.rewind();
            writableByteChannel.write(byteBufferAllocate);
        }

        @Override // ir.nasim.InterfaceC4984Hk0
        public void k(InterfaceC12511ek1 interfaceC12511ek1) {
            this.a = interfaceC12511ek1;
        }

        private a() {
            this.b = 1073741824L;
            this.c = 0L;
        }
    }

    private void o() throws IOException {
        long jPosition = this.d.position();
        this.d.position(this.a.b());
        this.a.g(this.d);
        this.d.position(jPosition);
        this.a.e(0L);
        this.a.d(0L);
        this.c.flush();
        this.c.getFD().sync();
    }

    public static long p(long j, long j2) {
        return j2 == 0 ? j : p(j2, j % j2);
    }

    public int a(MediaFormat mediaFormat, boolean z) {
        return this.b.b(mediaFormat, z);
    }

    protected void b(C22239ut7 c22239ut7, C13643ga6 c13643ga6) {
        int[] iArrI = c22239ut7.i();
        if (iArrI == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        C16040kc1.a aVar = null;
        for (int i : iArrI) {
            if (aVar == null || aVar.b() != i) {
                aVar = new C16040kc1.a(1, i);
                arrayList.add(aVar);
            } else {
                aVar.c(aVar.a() + 1);
            }
        }
        C16040kc1 c16040kc1 = new C16040kc1();
        c16040kc1.u(arrayList);
        c13643ga6.a(c16040kc1);
    }

    protected C4770Gm2 c(boolean z) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso2");
        linkedList.add(z ? "hvc1" : "avc1");
        linkedList.add("mp41");
        return new C4770Gm2("isom", 512L, linkedList);
    }

    public FL3 d(C3803Ck4 c3803Ck4, boolean z, boolean z2) throws IOException {
        this.b = c3803Ck4;
        FileOutputStream fileOutputStream = new FileOutputStream(c3803Ck4.c());
        this.c = fileOutputStream;
        this.d = fileOutputStream.getChannel();
        C4770Gm2 c4770Gm2C = c(z2);
        c4770Gm2C.g(this.d);
        long jF = this.e + c4770Gm2C.f();
        this.e = jF;
        this.f += jF;
        this.j = z;
        this.a = new a();
        this.i = ByteBuffer.allocateDirect(4);
        return this;
    }

    protected C21556tk4 e(C3803Ck4 c3803Ck4) {
        C21556tk4 c21556tk4 = new C21556tk4();
        C22736vk4 c22736vk4 = new C22736vk4();
        c22736vk4.B(new Date());
        c22736vk4.E(new Date());
        c22736vk4.D(BV3.j);
        long jR = r(c3803Ck4);
        Iterator it = c3803Ck4.f().iterator();
        long j = 0;
        while (it.hasNext()) {
            C22239ut7 c22239ut7 = (C22239ut7) it.next();
            c22239ut7.t();
            long jD = (c22239ut7.d() * jR) / c22239ut7.n();
            if (jD > j) {
                j = jD;
            }
        }
        c22736vk4.C(j);
        c22736vk4.G(jR);
        c22736vk4.F(c3803Ck4.f().size() + 1);
        c21556tk4.a(c22736vk4);
        Iterator it2 = c3803Ck4.f().iterator();
        while (it2.hasNext()) {
            c21556tk4.a(m((C22239ut7) it2.next(), c3803Ck4));
        }
        return c21556tk4;
    }

    protected InterfaceC4984Hk0 f(C22239ut7 c22239ut7) {
        C13643ga6 c13643ga6 = new C13643ga6();
        i(c22239ut7, c13643ga6);
        l(c22239ut7, c13643ga6);
        b(c22239ut7, c13643ga6);
        j(c22239ut7, c13643ga6);
        h(c22239ut7, c13643ga6);
        k(c22239ut7, c13643ga6);
        g(c22239ut7, c13643ga6);
        return c13643ga6;
    }

    protected void g(C22239ut7 c22239ut7, C13643ga6 c13643ga6) {
        ArrayList arrayList = new ArrayList();
        Iterator it = c22239ut7.l().iterator();
        long jB = -1;
        while (it.hasNext()) {
            C11773da6 c11773da6 = (C11773da6) it.next();
            long jA = c11773da6.a();
            if (jB != -1 && jB != jA) {
                jB = -1;
            }
            if (jB == -1) {
                arrayList.add(Long.valueOf(jA));
            }
            jB = c11773da6.b() + jA;
        }
        long[] jArr = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        UL6 ul6 = new UL6();
        ul6.v(jArr);
        c13643ga6.a(ul6);
    }

    protected void h(C22239ut7 c22239ut7, C13643ga6 c13643ga6) {
        C14234ha6 c14234ha6 = new C14234ha6();
        c14234ha6.v(new LinkedList());
        int size = c22239ut7.l().size();
        int i = -1;
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            C11773da6 c11773da6 = (C11773da6) c22239ut7.l().get(i4);
            long jA = c11773da6.a() + c11773da6.b();
            i3++;
            if (i4 == size - 1 || jA != ((C11773da6) c22239ut7.l().get(i4 + 1)).a()) {
                if (i != i3) {
                    c14234ha6.u().add(new C14234ha6.a(i2, i3, 1L));
                    i = i3;
                }
                i2++;
                i3 = 0;
            }
        }
        c13643ga6.a(c14234ha6);
    }

    protected void i(C22239ut7 c22239ut7, C13643ga6 c13643ga6) {
        c13643ga6.a(c22239ut7.j());
    }

    protected void j(C22239ut7 c22239ut7, C13643ga6 c13643ga6) {
        long[] jArrM = c22239ut7.m();
        if (jArrM == null || jArrM.length <= 0) {
            return;
        }
        C16323l47 c16323l47 = new C16323l47();
        c16323l47.u(jArrM);
        c13643ga6.a(c16323l47);
    }

    protected void k(C22239ut7 c22239ut7, C13643ga6 c13643ga6) {
        C13025fa6 c13025fa6 = new C13025fa6();
        c13025fa6.w((long[]) this.h.get(c22239ut7));
        c13643ga6.a(c13025fa6);
    }

    protected void l(C22239ut7 c22239ut7, C13643ga6 c13643ga6) {
        ArrayList arrayList = new ArrayList();
        C17368mq7.a aVar = null;
        for (long j : c22239ut7.k()) {
            if (aVar == null || aVar.b() != j) {
                aVar = new C17368mq7.a(1L, j);
                arrayList.add(aVar);
            } else {
                aVar.c(aVar.a() + 1);
            }
        }
        C17368mq7 c17368mq7 = new C17368mq7();
        c17368mq7.u(arrayList);
        c13643ga6.a(c17368mq7);
    }

    protected C24015xt7 m(C22239ut7 c22239ut7, C3803Ck4 c3803Ck4) {
        C24015xt7 c24015xt7 = new C24015xt7();
        C4121Dt7 c4121Dt7 = new C4121Dt7();
        c4121Dt7.G(true);
        c4121Dt7.I(true);
        c4121Dt7.J(true);
        if (c22239ut7.r()) {
            c4121Dt7.L(BV3.j);
        } else {
            c4121Dt7.L(c3803Ck4.e());
        }
        c4121Dt7.D(0);
        c4121Dt7.E(c22239ut7.c());
        c4121Dt7.F((c22239ut7.d() * r(c3803Ck4)) / c22239ut7.n());
        c4121Dt7.H(c22239ut7.f());
        c4121Dt7.P(c22239ut7.q());
        c4121Dt7.K(0);
        c4121Dt7.M(new Date());
        c4121Dt7.N(c22239ut7.o() + 1);
        c4121Dt7.O(c22239ut7.p());
        c24015xt7.a(c4121Dt7);
        C17759nW3 c17759nW3 = new C17759nW3();
        c24015xt7.a(c17759nW3);
        C18950pX3 c18950pX3 = new C18950pX3();
        c18950pX3.z(c22239ut7.c());
        c18950pX3.A(c22239ut7.d());
        c18950pX3.C(c22239ut7.n());
        c18950pX3.B("eng");
        c17759nW3.a(c18950pX3);
        C18322oT2 c18322oT2 = new C18322oT2();
        c18322oT2.x(c22239ut7.r() ? "SoundHandle" : "VideoHandle");
        c18322oT2.w(c22239ut7.e());
        c17759nW3.a(c18322oT2);
        C19541qX3 c19541qX3 = new C19541qX3();
        c19541qX3.a(c22239ut7.h());
        C8952Xy1 c8952Xy1 = new C8952Xy1();
        C19222pz1 c19222pz1 = new C19222pz1();
        c8952Xy1.a(c19222pz1);
        C8432Vy1 c8432Vy1 = new C8432Vy1();
        c8432Vy1.r(1);
        c19222pz1.a(c8432Vy1);
        c19541qX3.a(c8952Xy1);
        c19541qX3.a(f(c22239ut7));
        c17759nW3.a(c19541qX3);
        return c24015xt7;
    }

    public long n() {
        if (this.a.a() != 0) {
            o();
        }
        Iterator it = this.b.f().iterator();
        while (it.hasNext()) {
            C22239ut7 c22239ut7 = (C22239ut7) it.next();
            ArrayList arrayListL = c22239ut7.l();
            int size = arrayListL.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = ((C11773da6) arrayListL.get(i)).b();
            }
            this.h.put(c22239ut7, jArr);
        }
        e(this.b).g(this.d);
        this.c.flush();
        this.c.getFD().sync();
        long jPosition = this.d.position();
        this.d.close();
        this.c.close();
        return jPosition;
    }

    public long q(int i) {
        return this.b.d(i);
    }

    public long r(C3803Ck4 c3803Ck4) {
        long jN = !c3803Ck4.f().isEmpty() ? ((C22239ut7) c3803Ck4.f().iterator().next()).n() : 0L;
        Iterator it = c3803Ck4.f().iterator();
        while (it.hasNext()) {
            jN = p(((C22239ut7) it.next()).n(), jN);
        }
        return jN;
    }

    public long s(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, boolean z) {
        boolean z2;
        if (this.g) {
            this.a.d(0L);
            this.a.g(this.d);
            this.a.e(this.e);
            this.e += 16;
            this.f += 16;
            this.g = false;
        }
        a aVar = this.a;
        aVar.d(aVar.a() + bufferInfo.size);
        long j = this.f + bufferInfo.size;
        this.f = j;
        if (j >= 32768) {
            z2 = true;
            if (this.j) {
                o();
                this.g = true;
            }
            this.f = 0L;
        } else {
            z2 = false;
        }
        this.b.a(i, this.e, bufferInfo);
        if (z) {
            this.i.position(0);
            this.i.putInt(bufferInfo.size - 4);
            this.i.position(0);
            this.d.write(this.i);
            byteBuffer.position(bufferInfo.offset + 4);
        } else {
            byteBuffer.position(bufferInfo.offset);
        }
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        this.d.write(byteBuffer);
        this.e += bufferInfo.size;
        if (!z2) {
            return 0L;
        }
        this.c.flush();
        this.c.getFD().sync();
        return this.d.position();
    }
}
