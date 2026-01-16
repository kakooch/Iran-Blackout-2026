package ir.nasim;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.IOException;

/* renamed from: ir.nasim.el2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12522el2 extends AbstractC21897uK {
    public C12522el2(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public Class a() {
        return AssetFileDescriptor.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21897uK
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void c(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21897uK
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public AssetFileDescriptor f(AssetManager assetManager, String str) {
        return assetManager.openFd(str);
    }
}
