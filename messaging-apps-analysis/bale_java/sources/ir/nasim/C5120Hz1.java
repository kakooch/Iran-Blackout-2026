package ir.nasim;

import android.util.Base64;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC8666Wy1;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ir.nasim.Hz1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5120Hz1 implements InterfaceC13701gg4 {
    private final a a;

    /* renamed from: ir.nasim.Hz1$a */
    public interface a {
        Class a();

        void b(Object obj);

        Object c(String str);
    }

    /* renamed from: ir.nasim.Hz1$c */
    public static final class c implements InterfaceC14292hg4 {
        private final a a = new a();

        /* renamed from: ir.nasim.Hz1$c$a */
        class a implements a {
            a() {
            }

            @Override // ir.nasim.C5120Hz1.a
            public Class a() {
                return InputStream.class;
            }

            @Override // ir.nasim.C5120Hz1.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // ir.nasim.C5120Hz1.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C5120Hz1(this.a);
        }
    }

    public C5120Hz1(a aVar) {
        this.a = aVar;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    public boolean a(Object obj) {
        return obj.toString().startsWith("data:image");
    }

    @Override // ir.nasim.InterfaceC13701gg4
    public InterfaceC13701gg4.a b(Object obj, int i, int i2, HL4 hl4) {
        return new InterfaceC13701gg4.a(new C22456vG4(obj), new b(obj.toString(), this.a));
    }

    /* renamed from: ir.nasim.Hz1$b */
    private static final class b implements InterfaceC8666Wy1 {
        private final String a;
        private final a b;
        private Object c;

        b(String str, a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public Class a() {
            return this.b.a();
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void b() {
            try {
                this.b.b(this.c);
            } catch (IOException unused) {
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public EnumC21012sz1 d() {
            return EnumC21012sz1.LOCAL;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
            try {
                Object objC = this.b.c(this.a);
                this.c = objC;
                aVar.f(objC);
            } catch (IllegalArgumentException e) {
                aVar.c(e);
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void cancel() {
        }
    }
}
