package ir.nasim;

import android.webkit.MimeTypeMap;
import ir.nasim.InterfaceC22734vk2;
import java.io.File;
import okio.Path;

/* renamed from: ir.nasim.rl2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20286rl2 implements InterfaceC22734vk2 {
    private final File a;

    /* renamed from: ir.nasim.rl2$a */
    public static final class a implements InterfaceC22734vk2.a {
        @Override // ir.nasim.InterfaceC22734vk2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC22734vk2 a(File file, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            return new C20286rl2(file);
        }
    }

    public C20286rl2(File file) {
        this.a = file;
    }

    @Override // ir.nasim.InterfaceC22734vk2
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        return new WH6(AbstractC11466d33.d(Path.Companion.get$default(Path.INSTANCE, this.a, false, 1, (Object) null), null, null, null, 14, null), MimeTypeMap.getSingleton().getMimeTypeFromExtension(AbstractC12542en2.q(this.a)), EnumC21699tz1.c);
    }
}
