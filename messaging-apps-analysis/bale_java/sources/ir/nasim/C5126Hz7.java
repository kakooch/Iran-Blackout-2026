package ir.nasim;

import ir.nasim.C4409Ez7;

/* renamed from: ir.nasim.Hz7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5126Hz7 extends AbstractC21707u0 implements D48 {
    private C9057Yh4 b;
    private C9528a7 c;

    public C5126Hz7(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.b = c9057Yh4;
        this.c = C4409Ez7.e0(c9057Yh4);
    }

    public void A(C11458d25 c11458d25, int i) {
        if (c11458d25.s() == W25.a) {
            this.c.d(new C4409Ez7.d(i, EnumC5360Iz7.c));
        } else if (c11458d25.s() == W25.b) {
            this.c.d(new C4409Ez7.c(c11458d25.getPeerId(), i, EnumC5360Iz7.c));
        }
    }

    public void B(C11458d25 c11458d25, int i, EnumC5360Iz7 enumC5360Iz7) {
        if (c11458d25.s() != W25.a) {
            if (c11458d25.s() == W25.b) {
                this.c.d(new C4409Ez7.a(c11458d25.getPeerId(), i, enumC5360Iz7));
            }
        } else {
            long j = i;
            if (this.b.W().p0().d(j) == null || ((C17637nI7) this.b.W().p0().d(j)).o0()) {
                return;
            }
            this.c.d(new C4409Ez7.b(i, enumC5360Iz7));
        }
    }

    public void C(C11458d25 c11458d25, int i, EnumC5360Iz7 enumC5360Iz7) {
        if (c11458d25.s() == W25.a) {
            this.c.d(new C4409Ez7.d(i, enumC5360Iz7));
        } else if (c11458d25.s() == W25.b) {
            this.c.d(new C4409Ez7.c(c11458d25.getPeerId(), i, enumC5360Iz7));
        }
    }

    @Override // ir.nasim.D48
    public boolean d(AbstractC20556sC7 abstractC20556sC7, long j) {
        if (abstractC20556sC7 instanceof IF7) {
            IF7 if7 = (IF7) abstractC20556sC7;
            B(if7.a(), if7.c(), if7.b());
            return true;
        }
        if (!(abstractC20556sC7 instanceof KF7)) {
            return false;
        }
        KF7 kf7 = (KF7) abstractC20556sC7;
        C(kf7.a(), kf7.c(), kf7.b());
        return true;
    }
}
