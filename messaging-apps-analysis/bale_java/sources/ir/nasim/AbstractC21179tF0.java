package ir.nasim;

/* renamed from: ir.nasim.tF0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21179tF0 {

    /* renamed from: ir.nasim.tF0$a */
    public static final class a implements InterfaceC19824r02 {
        final /* synthetic */ YZ1 a;

        a(YZ1 yz1) {
            this.a = yz1;
        }

        @Override // ir.nasim.InterfaceC19824r02
        public void a(float[] fArr) {
            this.a.e().r(fArr);
        }

        @Override // ir.nasim.InterfaceC19824r02
        public void b(float f, float f2, float f3, float f4, int i) {
            this.a.e().b(f, f2, f3, f4, i);
        }

        @Override // ir.nasim.InterfaceC19824r02
        public void c(float f, float f2) {
            this.a.e().c(f, f2);
        }

        @Override // ir.nasim.InterfaceC19824r02
        public void d(V05 v05, int i) {
            this.a.e().d(v05, i);
        }

        @Override // ir.nasim.InterfaceC19824r02
        public void f(float f, float f2, long j) {
            UE0 ue0E = this.a.e();
            int i = (int) (j >> 32);
            int i2 = (int) (j & 4294967295L);
            ue0E.c(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
            ue0E.e(f, f2);
            ue0E.c(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
        }

        @Override // ir.nasim.InterfaceC19824r02
        public void g(float f, long j) {
            UE0 ue0E = this.a.e();
            int i = (int) (j >> 32);
            int i2 = (int) (j & 4294967295L);
            ue0E.c(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
            ue0E.l(f);
            ue0E.c(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
        }

        @Override // ir.nasim.InterfaceC19824r02
        public void h(float f, float f2, float f3, float f4) {
            UE0 ue0E = this.a.e();
            YZ1 yz1 = this.a;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j() >> 32)) - (f3 + f);
            long jD = OD6.d((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j() & 4294967295L)) - (f4 + f2)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
            if (!(Float.intBitsToFloat((int) (jD >> 32)) >= 0.0f && Float.intBitsToFloat((int) (jD & 4294967295L)) >= 0.0f)) {
                L73.a("Width and height must be greater than or equal to zero");
            }
            yz1.g(jD);
            ue0E.c(f, f2);
        }

        public long j() {
            return this.a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC19824r02 b(YZ1 yz1) {
        return new a(yz1);
    }
}
