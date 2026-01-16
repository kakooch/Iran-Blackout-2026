package ir.nasim;

import ir.nasim.InterfaceC22734vk2;
import java.nio.ByteBuffer;
import okio.Buffer;

/* renamed from: ir.nasim.Eo0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4303Eo0 implements InterfaceC22734vk2 {
    private final ByteBuffer a;
    private final IL4 b;

    /* renamed from: ir.nasim.Eo0$a */
    public static final class a implements InterfaceC22734vk2.a {
        @Override // ir.nasim.InterfaceC22734vk2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC22734vk2 a(ByteBuffer byteBuffer, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            return new C4303Eo0(byteBuffer, il4);
        }
    }

    public C4303Eo0(ByteBuffer byteBuffer, IL4 il4) {
        this.a = byteBuffer;
        this.b = il4;
    }

    @Override // ir.nasim.InterfaceC22734vk2
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        try {
            Buffer buffer = new Buffer();
            buffer.write(this.a);
            this.a.position(0);
            return new WH6(AbstractC11466d33.a(buffer, this.b.g()), null, EnumC21699tz1.b);
        } catch (Throwable th) {
            this.a.position(0);
            throw th;
        }
    }
}
