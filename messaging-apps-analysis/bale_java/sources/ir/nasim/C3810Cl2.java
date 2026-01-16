package ir.nasim;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC8666Wy1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ir.nasim.Cl2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C3810Cl2 implements InterfaceC13701gg4 {
    private final d a;

    /* renamed from: ir.nasim.Cl2$a */
    public static class a implements InterfaceC14292hg4 {
        private final d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public final InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C3810Cl2(this.a);
        }
    }

    /* renamed from: ir.nasim.Cl2$b */
    public static class b extends a {

        /* renamed from: ir.nasim.Cl2$b$a */
        class a implements d {
            a() {
            }

            @Override // ir.nasim.C3810Cl2.d
            public Class a() {
                return ParcelFileDescriptor.class;
            }

            @Override // ir.nasim.C3810Cl2.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // ir.nasim.C3810Cl2.d
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor c(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* renamed from: ir.nasim.Cl2$d */
    public interface d {
        Class a();

        void b(Object obj);

        Object c(File file);
    }

    /* renamed from: ir.nasim.Cl2$e */
    public static class e extends a {

        /* renamed from: ir.nasim.Cl2$e$a */
        class a implements d {
            a() {
            }

            @Override // ir.nasim.C3810Cl2.d
            public Class a() {
                return InputStream.class;
            }

            @Override // ir.nasim.C3810Cl2.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // ir.nasim.C3810Cl2.d
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(File file) {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public C3810Cl2(d dVar) {
        this.a = dVar;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(File file, int i, int i2, HL4 hl4) {
        return new InterfaceC13701gg4.a(new C22456vG4(file), new c(file, this.a));
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }

    /* renamed from: ir.nasim.Cl2$c */
    private static final class c implements InterfaceC8666Wy1 {
        private final File a;
        private final d b;
        private Object c;

        c(File file, d dVar) {
            this.a = file;
            this.b = dVar;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public Class a() {
            return this.b.a();
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void b() {
            Object obj = this.c;
            if (obj != null) {
                try {
                    this.b.b(obj);
                } catch (IOException unused) {
                }
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
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
                aVar.c(e);
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void cancel() {
        }
    }
}
