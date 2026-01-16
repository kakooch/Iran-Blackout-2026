package j$.util.stream;

import j$.util.t;
import org.rbmain.messenger.LiteMode;

/* renamed from: j$.util.stream.y3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0257y3 extends Q {
    final /* synthetic */ long l;
    final /* synthetic */ long m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0257y3(AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i, long j, long j2) {
        super(abstractC0128c, enumC0151f4, i);
        this.l = j;
        this.m = j2;
    }

    @Override // j$.util.stream.AbstractC0128c
    A1 F0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, j$.util.function.m mVar) {
        long jR0 = abstractC0256y2.r0(tVar);
        return (jR0 <= 0 || !tVar.hasCharacteristics(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM)) ? !EnumC0145e4.ORDERED.d(abstractC0256y2.t0()) ? AbstractC0251x2.f(this, O0((t.a) abstractC0256y2.x0(tVar), this.l, this.m, jR0), true) : (A1) new A3(this, abstractC0256y2, tVar, mVar, this.l, this.m).invoke() : AbstractC0251x2.f(abstractC0256y2, B3.b(abstractC0256y2.s0(), tVar, this.l, this.m), true);
    }

    @Override // j$.util.stream.AbstractC0128c
    j$.util.t G0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        long jR0 = abstractC0256y2.r0(tVar);
        if (jR0 > 0 && tVar.hasCharacteristics(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM)) {
            t.a aVar = (t.a) abstractC0256y2.x0(tVar);
            long j = this.l;
            return new v4(aVar, j, B3.d(j, this.m));
        }
        return !EnumC0145e4.ORDERED.d(abstractC0256y2.t0()) ? O0((t.a) abstractC0256y2.x0(tVar), this.l, this.m, jR0) : ((A1) new A3(this, abstractC0256y2, tVar, new j$.util.function.m() { // from class: j$.util.stream.w3
            @Override // j$.util.function.m
            public final Object apply(int i) {
                return new Double[i];
            }
        }, this.l, this.m).invoke()).spliterator();
    }

    @Override // j$.util.stream.AbstractC0128c
    InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        return new C0252x3(this, interfaceC0192m3);
    }

    t.a O0(t.a aVar, long j, long j2, long j3) {
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
        return new F4(aVar, j4, jMin);
    }
}
