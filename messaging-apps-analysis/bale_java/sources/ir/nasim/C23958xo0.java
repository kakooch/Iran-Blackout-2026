package ir.nasim;

import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC8666Wy1;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.xo0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C23958xo0 implements InterfaceC13701gg4 {
    private final b a;

    /* renamed from: ir.nasim.xo0$a */
    public static class a implements InterfaceC14292hg4 {

        /* renamed from: ir.nasim.xo0$a$a, reason: collision with other inner class name */
        class C1775a implements b {
            C1775a() {
            }

            @Override // ir.nasim.C23958xo0.b
            public Class a() {
                return ByteBuffer.class;
            }

            @Override // ir.nasim.C23958xo0.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C23958xo0(new C1775a());
        }
    }

    /* renamed from: ir.nasim.xo0$b */
    public interface b {
        Class a();

        Object b(byte[] bArr);
    }

    /* renamed from: ir.nasim.xo0$d */
    public static class d implements InterfaceC14292hg4 {

        /* renamed from: ir.nasim.xo0$d$a */
        class a implements b {
            a() {
            }

            @Override // ir.nasim.C23958xo0.b
            public Class a() {
                return InputStream.class;
            }

            @Override // ir.nasim.C23958xo0.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C23958xo0(new a());
        }
    }

    public C23958xo0(b bVar) {
        this.a = bVar;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(byte[] bArr, int i, int i2, HL4 hl4) {
        return new InterfaceC13701gg4.a(new C22456vG4(bArr), new c(bArr, this.a));
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(byte[] bArr) {
        return true;
    }

    /* renamed from: ir.nasim.xo0$c */
    private static class c implements InterfaceC8666Wy1 {
        private final byte[] a;
        private final b b;

        c(byte[] bArr, b bVar) {
            this.a = bArr;
            this.b = bVar;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public Class a() {
            return this.b.a();
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public EnumC21012sz1 d() {
            return EnumC21012sz1.LOCAL;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
            aVar.f(this.b.b(this.a));
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void b() {
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void cancel() {
        }
    }
}
