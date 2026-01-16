package ir.nasim;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Ug8 {
    private final Rm8 a;

    public Ug8(Rm8 rm8) {
        this.a = rm8;
    }

    public static final int b(AssetManager assetManager, File file) {
        int iIntValue = ((Integer) com.google.android.play.core.splitinstall.internal.c.d(assetManager, "addAssetPath", Integer.class, String.class, file.getPath())).intValue();
        Log.d("SplitCompat", "addAssetPath completed with " + iIntValue);
        return iIntValue;
    }

    public final synchronized void a(Context context, Set set) {
        AssetManager assets = context.getAssets();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            b(assets, (File) it.next());
        }
    }
}
