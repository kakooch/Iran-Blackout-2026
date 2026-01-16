package ir.nasim;

import android.content.res.AssetManager;
import android.util.Log;
import ir.nasim.InterfaceC8666Wy1;
import java.io.IOException;

/* renamed from: ir.nasim.uK, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21897uK implements InterfaceC8666Wy1 {
    private final String a;
    private final AssetManager b;
    private Object c;

    public AbstractC21897uK(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.a = str;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public void b() {
        Object obj = this.c;
        if (obj == null) {
            return;
        }
        try {
            c(obj);
        } catch (IOException unused) {
        }
    }

    protected abstract void c(Object obj);

    @Override // ir.nasim.InterfaceC8666Wy1
    public EnumC21012sz1 d() {
        return EnumC21012sz1.LOCAL;
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
        try {
            Object objF = f(this.b, this.a);
            this.c = objF;
            aVar.f(objF);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            aVar.c(e);
        }
    }

    protected abstract Object f(AssetManager assetManager, String str);

    @Override // ir.nasim.InterfaceC8666Wy1
    public void cancel() {
    }
}
