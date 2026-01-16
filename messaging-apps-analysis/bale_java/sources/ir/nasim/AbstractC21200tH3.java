package ir.nasim;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import ir.nasim.InterfaceC8666Wy1;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: ir.nasim.tH3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21200tH3 implements InterfaceC8666Wy1 {
    private final Uri a;
    private final ContentResolver b;
    private Object c;

    public AbstractC21200tH3(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.a = uri;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public void b() {
        Object obj = this.c;
        if (obj != null) {
            try {
                c(obj);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract void c(Object obj);

    @Override // ir.nasim.InterfaceC8666Wy1
    public EnumC21012sz1 d() {
        return EnumC21012sz1.LOCAL;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public final void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
        try {
            Object objF = f(this.a, this.b);
            this.c = objF;
            aVar.f(objF);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            aVar.c(e);
        }
    }

    protected abstract Object f(Uri uri, ContentResolver contentResolver);

    @Override // ir.nasim.InterfaceC8666Wy1
    public void cancel() {
    }
}
