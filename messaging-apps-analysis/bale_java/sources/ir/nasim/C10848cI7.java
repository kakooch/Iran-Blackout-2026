package ir.nasim;

import android.content.ContentResolver;
import android.net.Uri;
import ir.nasim.InterfaceC13701gg4;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: ir.nasim.cI7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C10848cI7 implements InterfaceC13701gg4 {
    private static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));
    private final c a;

    /* renamed from: ir.nasim.cI7$a */
    public static final class a implements InterfaceC14292hg4, c {
        private final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // ir.nasim.C10848cI7.c
        public InterfaceC8666Wy1 a(Uri uri) {
            return new C20620sK(this.a, uri);
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C10848cI7(this);
        }
    }

    /* renamed from: ir.nasim.cI7$b */
    public static class b implements InterfaceC14292hg4, c {
        private final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // ir.nasim.C10848cI7.c
        public InterfaceC8666Wy1 a(Uri uri) {
            return new C13749gl2(this.a, uri);
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C10848cI7(this);
        }
    }

    /* renamed from: ir.nasim.cI7$c */
    public interface c {
        InterfaceC8666Wy1 a(Uri uri);
    }

    /* renamed from: ir.nasim.cI7$d */
    public static class d implements InterfaceC14292hg4, c {
        private final ContentResolver a;

        public d(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // ir.nasim.C10848cI7.c
        public InterfaceC8666Wy1 a(Uri uri) {
            return new WX6(this.a, uri);
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new C10848cI7(this);
        }
    }

    public C10848cI7(c cVar) {
        this.a = cVar;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(Uri uri, int i, int i2, HL4 hl4) {
        return new InterfaceC13701gg4.a(new C22456vG4(uri), this.a.a(uri));
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
