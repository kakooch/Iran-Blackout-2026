package j$.util.stream;

import org.rbmain.messenger.LiteMode;

/* renamed from: j$.util.stream.p3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0210p3 extends AbstractC0132c3 {
    final /* synthetic */ long l;
    final /* synthetic */ long m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0210p3(AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, long j, long j2) {
        super(abstractC0128c, enumC0151f4, i);
        this.l = j;
        this.m = j2;
    }

    @Override // j$.util.stream.AbstractC0128c
    A1 F0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, j$.util.function.m mVar) {
        long jR0 = abstractC0256y2.r0(tVar);
        return (jR0 <= 0 || !tVar.hasCharacteristics(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM)) ? !EnumC0145e4.ORDERED.d(abstractC0256y2.t0()) ? AbstractC0251x2.e(this, M0(abstractC0256y2.x0(tVar), this.l, this.m, jR0), true, mVar) : (A1) new A3(this, abstractC0256y2, tVar, mVar, this.l, this.m).invoke() : AbstractC0251x2.e(abstractC0256y2, B3.b(abstractC0256y2.s0(), tVar, this.l, this.m), true, mVar);
    }

    @Override // j$.util.stream.AbstractC0128c
    j$.util.t G0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        long jR0 = abstractC0256y2.r0(tVar);
        if (jR0 > 0 && tVar.hasCharacteristics(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM)) {
            j$.util.t tVarX0 = abstractC0256y2.x0(tVar);
            long j = this.l;
            return new D4(tVarX0, j, B3.d(j, this.m));
        }
        return !EnumC0145e4.ORDERED.d(abstractC0256y2.t0()) ? M0(abstractC0256y2.x0(tVar), this.l, this.m, jR0) : ((A1) new A3(this, abstractC0256y2, tVar, new j$.util.function.m() { // from class: j$.util.stream.n3
            @Override // j$.util.function.m
            public final Object apply(int i) {
                return new Object[i];
            }
        }, this.l, this.m).invoke()).spliterator();
    }

    @Override // j$.util.stream.AbstractC0128c
    InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        return new C0204o3(this, interfaceC0192m3);
    }

    j$.util.t M0(j$.util.t tVar, long j, long j2, long j3) {
        long j4;
        long jMin;
        if (j <= j3) {
            long j5 = j3 - j;
            jMin = j2 >= 0 ? Math.min(j2, j5) : j5;
            j4 = 0;
        } else {
            j4 = j;
            jMin = j2;
        }
        return new J4(tVar, j4, jMin);
    }
}
