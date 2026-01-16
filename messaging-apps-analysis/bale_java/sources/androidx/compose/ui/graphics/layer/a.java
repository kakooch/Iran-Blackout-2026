package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C21226tK2;
import ir.nasim.C24381yX0;
import ir.nasim.EnumC12613eu3;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.ON5;
import ir.nasim.UA2;
import ir.nasim.UE0;
import ir.nasim.WH1;

/* loaded from: classes2.dex */
public interface a {
    public static final C0064a a = C0064a.a;

    /* renamed from: androidx.compose.ui.graphics.layer.a$a, reason: collision with other inner class name */
    public static final class C0064a {
        static final /* synthetic */ C0064a a = new C0064a();
        private static final UA2 b = C0065a.e;

        /* renamed from: androidx.compose.ui.graphics.layer.a$a$a, reason: collision with other inner class name */
        static final class C0065a extends AbstractC8614Ws3 implements UA2 {
            public static final C0065a e = new C0065a();

            C0065a() {
                super(1);
            }

            public final void a(InterfaceC17460n02 interfaceC17460n02) {
                InterfaceC17460n02.C1(interfaceC17460n02, C24381yX0.b.h(), 0L, 0L, 0.0f, null, null, 0, 126, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC17460n02) obj);
                return C19938rB7.a;
            }
        }

        private C0064a() {
        }

        public final UA2 a() {
            return b;
        }
    }

    float A();

    void B(float f);

    Matrix C();

    default boolean D() {
        return false;
    }

    void E(boolean z);

    void F(Outline outline, long j);

    float G();

    float H();

    float I();

    void J(WH1 wh1, EnumC12613eu3 enumC12613eu3, C21226tK2 c21226tK2, UA2 ua2);

    float K();

    void L(long j);

    void M(UE0 ue0);

    void N(int i);

    float O();

    float a();

    AbstractC24975zX0 b();

    void c(float f);

    void d();

    void e(float f);

    void f(ON5 on5);

    void g(float f);

    default boolean h() {
        return true;
    }

    void i(float f);

    void j(float f);

    void k(float f);

    void l(float f);

    void m(float f);

    void n(float f);

    int o();

    ON5 p();

    int q();

    float r();

    float s();

    void t(int i, int i2, long j);

    long u();

    void v(long j);

    float w();

    void x(boolean z);

    void y(long j);

    long z();
}
