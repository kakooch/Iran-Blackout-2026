package ir.nasim;

/* loaded from: classes3.dex */
final class zv8 implements Runnable {
    final /* synthetic */ PI6 a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ Ev8 d;

    zv8(Ev8 ev8, PI6 pi6, int i, int i2) {
        this.d = ev8;
        this.a = pi6;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ev8 ev8 = this.d;
        PI6 pi6 = this.a;
        ev8.h(new Wg8(pi6.d(), this.b, this.c, pi6.a(), pi6.f(), pi6.h(), pi6.g(), pi6.c(), pi6.i()));
    }
}
