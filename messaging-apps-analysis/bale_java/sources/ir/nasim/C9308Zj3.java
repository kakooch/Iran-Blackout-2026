package ir.nasim;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.Zj3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9308Zj3 implements InterfaceC9262Ze2 {
    private InterfaceC10465bf2 b;
    private int c;
    private int d;
    private int e;
    private MotionPhotoMetadata g;
    private InterfaceC9845af2 h;
    private C11629dK6 i;
    private C3569Bk4 j;
    private final EW4 a = new EW4(6);
    private long f = -1;

    private void c(InterfaceC9845af2 interfaceC9845af2) {
        this.a.O(2);
        interfaceC9845af2.m(this.a.e(), 0, 2);
        interfaceC9845af2.h(this.a.L() - 2);
    }

    private void f() {
        h(new Metadata.Entry[0]);
        ((InterfaceC10465bf2) AbstractC20011rK.e(this.b)).s();
        this.b.o(new InterfaceC22148uk6.b(-9223372036854775807L));
        this.c = 6;
    }

    private static MotionPhotoMetadata g(String str, long j) {
        C14334hk4 c14334hk4A;
        if (j == -1 || (c14334hk4A = AbstractC20200rc8.a(str)) == null) {
            return null;
        }
        return c14334hk4A.a(j);
    }

    private void h(Metadata.Entry... entryArr) {
        ((InterfaceC10465bf2) AbstractC20011rK.e(this.b)).b(1024, 4).c(new X.b().M("image/jpeg").Z(new Metadata(entryArr)).G());
    }

    private int i(InterfaceC9845af2 interfaceC9845af2) {
        this.a.O(2);
        interfaceC9845af2.m(this.a.e(), 0, 2);
        return this.a.L();
    }

    private void j(InterfaceC9845af2 interfaceC9845af2) {
        this.a.O(2);
        interfaceC9845af2.readFully(this.a.e(), 0, 2);
        int iL = this.a.L();
        this.d = iL;
        if (iL == 65498) {
            if (this.f != -1) {
                this.c = 4;
                return;
            } else {
                f();
                return;
            }
        }
        if ((iL < 65488 || iL > 65497) && iL != 65281) {
            this.c = 1;
        }
    }

    private void k(InterfaceC9845af2 interfaceC9845af2) {
        String strZ;
        if (this.d == 65505) {
            EW4 ew4 = new EW4(this.e);
            interfaceC9845af2.readFully(ew4.e(), 0, this.e);
            if (this.g == null && "http://ns.adobe.com/xap/1.0/".equals(ew4.z()) && (strZ = ew4.z()) != null) {
                MotionPhotoMetadata motionPhotoMetadataG = g(strZ, interfaceC9845af2.getLength());
                this.g = motionPhotoMetadataG;
                if (motionPhotoMetadataG != null) {
                    this.f = motionPhotoMetadataG.d;
                }
            }
        } else {
            interfaceC9845af2.k(this.e);
        }
        this.c = 0;
    }

    private void l(InterfaceC9845af2 interfaceC9845af2) {
        this.a.O(2);
        interfaceC9845af2.readFully(this.a.e(), 0, 2);
        this.e = this.a.L() - 2;
        this.c = 2;
    }

    private void m(InterfaceC9845af2 interfaceC9845af2) {
        if (!interfaceC9845af2.c(this.a.e(), 0, 1, true)) {
            f();
            return;
        }
        interfaceC9845af2.e();
        if (this.j == null) {
            this.j = new C3569Bk4();
        }
        C11629dK6 c11629dK6 = new C11629dK6(interfaceC9845af2, this.f);
        this.i = c11629dK6;
        if (!this.j.d(c11629dK6)) {
            f();
        } else {
            this.j.b(new C12272eK6(this.f, (InterfaceC10465bf2) AbstractC20011rK.e(this.b)));
            n();
        }
    }

    private void n() {
        h((Metadata.Entry) AbstractC20011rK.e(this.g));
        this.c = 5;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        if (j == 0) {
            this.c = 0;
            this.j = null;
        } else if (this.c == 5) {
            ((C3569Bk4) AbstractC20011rK.e(this.j)).a(j, j2);
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.b = interfaceC10465bf2;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        if (i(interfaceC9845af2) != 65496) {
            return false;
        }
        int i = i(interfaceC9845af2);
        this.d = i;
        if (i == 65504) {
            c(interfaceC9845af2);
            this.d = i(interfaceC9845af2);
        }
        if (this.d != 65505) {
            return false;
        }
        interfaceC9845af2.h(2);
        this.a.O(6);
        interfaceC9845af2.m(this.a.e(), 0, 6);
        return this.a.H() == 1165519206 && this.a.L() == 0;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        int i = this.c;
        if (i == 0) {
            j(interfaceC9845af2);
            return 0;
        }
        if (i == 1) {
            l(interfaceC9845af2);
            return 0;
        }
        if (i == 2) {
            k(interfaceC9845af2);
            return 0;
        }
        if (i == 4) {
            long position = interfaceC9845af2.getPosition();
            long j = this.f;
            if (position != j) {
                c8292Vi5.a = j;
                return 1;
            }
            m(interfaceC9845af2);
            return 0;
        }
        if (i != 5) {
            if (i == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.i == null || interfaceC9845af2 != this.h) {
            this.h = interfaceC9845af2;
            this.i = new C11629dK6(interfaceC9845af2, this.f);
        }
        int iE = ((C3569Bk4) AbstractC20011rK.e(this.j)).e(this.i, c8292Vi5);
        if (iE == 1) {
            c8292Vi5.a += this.f;
        }
        return iE;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
        C3569Bk4 c3569Bk4 = this.j;
        if (c3569Bk4 != null) {
            c3569Bk4.release();
        }
    }
}
