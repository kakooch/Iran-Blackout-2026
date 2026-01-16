package ir.nasim;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class NX6 extends AbstractC21897uK {
    public NX6(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // ir.nasim.InterfaceC8666Wy1
    public Class a() {
        return InputStream.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21897uK
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21897uK
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public InputStream f(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
