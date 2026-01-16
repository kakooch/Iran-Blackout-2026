package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ir.nasim.Pe0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6832Pe0 implements InterfaceC5968Lp3 {
    private final InputStream a;

    private C6832Pe0(InputStream inputStream) {
        this.a = inputStream;
    }

    public static InterfaceC5968Lp3 b(byte[] bArr) {
        return new C6832Pe0(new ByteArrayInputStream(bArr));
    }

    @Override // ir.nasim.InterfaceC5968Lp3
    public C13976h82 a() throws IOException {
        try {
            return C13976h82.W(this.a, C2352n.b());
        } finally {
            this.a.close();
        }
    }

    @Override // ir.nasim.InterfaceC5968Lp3
    public C5032Hp3 read() throws IOException {
        try {
            return C5032Hp3.b0(this.a, C2352n.b());
        } finally {
            this.a.close();
        }
    }
}
