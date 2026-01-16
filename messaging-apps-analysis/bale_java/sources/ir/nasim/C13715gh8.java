package ir.nasim;

import android.net.Uri;
import com.google.android.gms.internal.gtm.zzbv;
import java.util.ListIterator;

/* renamed from: ir.nasim.gh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C13715gh8 extends AbstractC16197kr8 {
    private final zzbv d;
    private boolean e;

    public C13715gh8(zzbv zzbvVar) {
        super(zzbvVar.zzd(), zzbvVar.zzr());
        this.d = zzbvVar;
    }

    public final C10571bp8 b() {
        C10571bp8 c10571bp8 = new C10571bp8(this.b);
        c10571bp8.c(this.d.zzh().zza());
        c10571bp8.c(this.d.zzk().zza());
        a(c10571bp8);
        return c10571bp8;
    }

    final zzbv c() {
        return this.d;
    }

    public final void d(String str) {
        AbstractC3795Cj5.f(str);
        Uri uriA = Aj8.a(str);
        ListIterator listIterator = this.b.b().listIterator();
        while (listIterator.hasNext()) {
            if (uriA.equals(((InterfaceC11394cv8) listIterator.next()).c())) {
                listIterator.remove();
            }
        }
        this.b.b().add(new Aj8(this.d, str));
    }

    public final void e(boolean z) {
        this.e = z;
    }
}
