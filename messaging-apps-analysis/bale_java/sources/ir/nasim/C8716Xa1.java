package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import ir.nasim.C20576sF0;

/* renamed from: ir.nasim.Xa1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8716Xa1 extends View.DragShadowBuilder {
    private final WH1 a;
    private final long b;
    private final UA2 c;

    public /* synthetic */ C8716Xa1(WH1 wh1, long j, UA2 ua2, ED1 ed1) {
        this(wh1, j, ua2);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        C20576sF0 c20576sF0 = new C20576sF0();
        WH1 wh1 = this.a;
        long j = this.b;
        EnumC12613eu3 enumC12613eu3 = EnumC12613eu3.a;
        UE0 ue0B = AbstractC7624Sn.b(canvas);
        UA2 ua2 = this.c;
        C20576sF0.a aVarE = c20576sF0.E();
        WH1 wh1A = aVarE.a();
        EnumC12613eu3 enumC12613eu3B = aVarE.b();
        UE0 ue0C = aVarE.c();
        long jD = aVarE.d();
        C20576sF0.a aVarE2 = c20576sF0.E();
        aVarE2.j(wh1);
        aVarE2.k(enumC12613eu3);
        aVarE2.i(ue0B);
        aVarE2.l(j);
        ue0B.n();
        ua2.invoke(c20576sF0);
        ue0B.i();
        C20576sF0.a aVarE3 = c20576sF0.E();
        aVarE3.j(wh1A);
        aVarE3.k(enumC12613eu3B);
        aVarE3.i(ue0C);
        aVarE3.l(jD);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point point, Point point2) {
        WH1 wh1 = this.a;
        point.set(wh1.B0(wh1.o1(Float.intBitsToFloat((int) (this.b >> 32)))), wh1.B0(wh1.o1(Float.intBitsToFloat((int) (this.b & 4294967295L)))));
        point2.set(point.x / 2, point.y / 2);
    }

    private C8716Xa1(WH1 wh1, long j, UA2 ua2) {
        this.a = wh1;
        this.b = j;
        this.c = ua2;
    }
}
