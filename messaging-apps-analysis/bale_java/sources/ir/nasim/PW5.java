package ir.nasim;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import ir.nasim.InterfaceC13701gg4;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class PW5 implements InterfaceC13701gg4 {
    private final InterfaceC13701gg4 a;
    private final Resources b;

    public static final class a implements InterfaceC14292hg4 {
        private final Resources a;

        public a(Resources resources) {
            this.a = resources;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new PW5(this.a, c23932xl4.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements InterfaceC14292hg4 {
        private final Resources a;

        public b(Resources resources) {
            this.a = resources;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new PW5(this.a, c23932xl4.d(Uri.class, InputStream.class));
        }
    }

    public static class c implements InterfaceC14292hg4 {
        private final Resources a;

        public c(Resources resources) {
            this.a = resources;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new PW5(this.a, C21824uB7.c());
        }
    }

    public PW5(Resources resources, InterfaceC13701gg4 interfaceC13701gg4) {
        this.b = resources;
        this.a = interfaceC13701gg4;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + '/' + this.b.getResourceTypeName(num.intValue()) + '/' + this.b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            return null;
        }
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(Integer num, int i, int i2, HL4 hl4) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.a.b(uriD, i, i2, hl4);
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }
}
