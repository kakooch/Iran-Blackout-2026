package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.request.NullRequestDataException;
import ir.nasim.FT1;

/* renamed from: ir.nasim.qV5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19525qV5 {
    private final InterfaceC18663p23 a;
    private final I47 b;
    private final InterfaceC17740nU2 c;

    public C19525qV5(InterfaceC18663p23 interfaceC18663p23, I47 i47, II3 ii3) {
        this.a = interfaceC18663p23;
        this.b = i47;
        this.c = AbstractC15092j.a(ii3);
    }

    private final boolean b(IL4 il4) {
        return !AbstractC10667c.d(il4.f()) || this.c.a();
    }

    private final boolean d(W23 w23, PD6 pd6) {
        if (AbstractC10667c.d(w23.j())) {
            return c(w23, w23.j()) && this.c.b(pd6);
        }
        return true;
    }

    private final boolean e(W23 w23) {
        return w23.O().isEmpty() || AbstractC10242bK.U(AbstractC18638p.o(), w23.j());
    }

    public final C12412ea2 a(W23 w23, Throwable th) {
        Drawable drawableT;
        if (!(th instanceof NullRequestDataException) || (drawableT = w23.u()) == null) {
            drawableT = w23.t();
        }
        return new C12412ea2(drawableT, w23, th);
    }

    public final boolean c(W23 w23, Bitmap.Config config) {
        if (!AbstractC10667c.d(config)) {
            return true;
        }
        if (!w23.h()) {
            return false;
        }
        w23.M();
        return true;
    }

    public final IL4 f(W23 w23, PD6 pd6) {
        Bitmap.Config configJ = (e(w23) && d(w23, pd6)) ? w23.j() : Bitmap.Config.ARGB_8888;
        FT1 ft1D = pd6.d();
        FT1.b bVar = FT1.b.a;
        return new IL4(w23.l(), configJ, w23.k(), pd6, (AbstractC13042fc3.d(ft1D, bVar) || AbstractC13042fc3.d(pd6.c(), bVar)) ? EnumC14254hc6.b : w23.J(), AbstractC16865m.a(w23), w23.i() && w23.O().isEmpty() && configJ != Bitmap.Config.ALPHA_8, w23.I(), w23.r(), w23.x(), w23.L(), w23.E(), w23.C(), w23.s(), w23.D());
    }

    public final KQ5 g(W23 w23, InterfaceC13730gj3 interfaceC13730gj3) {
        androidx.lifecycle.j jVarZ = w23.z();
        w23.M();
        return new C6063Ma0(jVarZ, interfaceC13730gj3);
    }

    public final IL4 h(IL4 il4) {
        boolean z;
        Bitmap.Config config;
        EnumC16760lp0 enumC16760lp0;
        Bitmap.Config configF = il4.f();
        EnumC16760lp0 enumC16760lp0K = il4.k();
        boolean z2 = true;
        if (b(il4)) {
            z = false;
            config = configF;
        } else {
            config = Bitmap.Config.ARGB_8888;
            z = true;
        }
        if (!il4.k().j() || this.b.b()) {
            enumC16760lp0 = enumC16760lp0K;
            z2 = z;
        } else {
            enumC16760lp0 = EnumC16760lp0.f;
        }
        return z2 ? il4.a((16381 & 1) != 0 ? il4.a : null, (16381 & 2) != 0 ? il4.b : config, (16381 & 4) != 0 ? il4.c : null, (16381 & 8) != 0 ? il4.d : null, (16381 & 16) != 0 ? il4.e : null, (16381 & 32) != 0 ? il4.f : false, (16381 & 64) != 0 ? il4.g : false, (16381 & 128) != 0 ? il4.h : false, (16381 & 256) != 0 ? il4.i : null, (16381 & 512) != 0 ? il4.j : null, (16381 & 1024) != 0 ? il4.k : null, (16381 & 2048) != 0 ? il4.l : null, (16381 & 4096) != 0 ? il4.m : null, (16381 & 8192) != 0 ? il4.n : null, (16381 & 16384) != 0 ? il4.o : enumC16760lp0) : il4;
    }
}
