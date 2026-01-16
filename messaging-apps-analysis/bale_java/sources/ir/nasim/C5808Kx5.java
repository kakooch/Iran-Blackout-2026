package ir.nasim;

import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* renamed from: ir.nasim.Kx5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C5808Kx5 implements InterfaceC17709nQ7 {
    private boolean a = false;
    private boolean b = false;
    private C24510yk2 c;
    private final C5106Hx5 d;

    C5808Kx5(C5106Hx5 c5106Hx5) {
        this.d = c5106Hx5;
    }

    private void a() {
        if (this.a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.a = true;
    }

    void b(C24510yk2 c24510yk2, boolean z) {
        this.a = false;
        this.c = c24510yk2;
        this.b = z;
    }

    @Override // ir.nasim.InterfaceC17709nQ7
    public InterfaceC17709nQ7 d(String str) throws IOException {
        a();
        this.d.g(this.c, str, this.b);
        return this;
    }

    @Override // ir.nasim.InterfaceC17709nQ7
    public InterfaceC17709nQ7 e(boolean z) {
        a();
        this.d.l(this.c, z, this.b);
        return this;
    }
}
