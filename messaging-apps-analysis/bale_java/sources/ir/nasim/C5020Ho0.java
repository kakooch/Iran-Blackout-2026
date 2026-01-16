package ir.nasim;

import com.bumptech.glide.load.data.a;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.Ho0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5020Ho0 implements com.bumptech.glide.load.data.a {
    private final ByteBuffer a;

    /* renamed from: ir.nasim.Ho0$a */
    public static class a implements a.InterfaceC0146a {
        @Override // com.bumptech.glide.load.data.a.InterfaceC0146a
        public Class a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0146a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.load.data.a b(ByteBuffer byteBuffer) {
            return new C5020Ho0(byteBuffer);
        }
    }

    public C5020Ho0(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ByteBuffer c() {
        this.a.position(0);
        return this.a;
    }

    @Override // com.bumptech.glide.load.data.a
    public void b() {
    }
}
