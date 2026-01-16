package ir.nasim;

import android.util.Log;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC8666Wy1;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.Fo0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4537Fo0 implements InterfaceC13701gg4 {

    /* renamed from: ir.nasim.Fo0$b */
    public static class b implements InterfaceC14292hg4 {
        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C4537Fo0();
        }
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(File file, int i, int i2, HL4 hl4) {
        return new InterfaceC13701gg4.a(new C22456vG4(file), new a(file));
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }

    /* renamed from: ir.nasim.Fo0$a */
    private static final class a implements InterfaceC8666Wy1 {
        private final File a;

        a(File file) {
            this.a = file;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public Class a() {
            return ByteBuffer.class;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public EnumC21012sz1 d() {
            return EnumC21012sz1.LOCAL;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
            try {
                aVar.f(AbstractC5254Io0.a(this.a));
            } catch (IOException e) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                aVar.c(e);
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void b() {
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void cancel() {
        }
    }
}
