package ir.nasim.features.imageloader;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.Registry;
import com.bumptech.glide.b;
import com.caverock.androidsvg.g;
import ir.nasim.A37;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13438gE;
import ir.nasim.C24701z37;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lir/nasim/features/imageloader/GlideAppModule;", "Lir/nasim/gE;", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/bumptech/glide/b;", "glide", "Lcom/bumptech/glide/Registry;", "registry", "Lir/nasim/rB7;", "a", "(Landroid/content/Context;Lcom/bumptech/glide/b;Lcom/bumptech/glide/Registry;)V", "", "c", "()Z", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class GlideAppModule extends AbstractC13438gE {
    @Override // ir.nasim.AbstractC9209Yy3
    public void a(Context context, b glide, Registry registry) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(glide, "glide");
        AbstractC13042fc3.i(registry, "registry");
        registry.q(g.class, PictureDrawable.class, new A37()).d(InputStream.class, g.class, new C24701z37());
    }

    @Override // ir.nasim.AbstractC13438gE
    public boolean c() {
        return false;
    }
}
