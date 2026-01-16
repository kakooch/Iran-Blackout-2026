package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.annotations.DoNotInline;
import java.io.File;
import kotlin.Metadata;

@DoNotInline
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lio/appmetrica/analytics/impl/G6;", "Lio/appmetrica/analytics/impl/F6;", "Landroid/content/Context;", "context", "", "simpleName", "Ljava/io/File;", "a", "Lio/appmetrica/analytics/impl/Yf;", "Lio/appmetrica/analytics/impl/Yf;", "relativePathFormer", "<init>", "(Lio/appmetrica/analytics/impl/Yf;)V", "analytics_binaryProdRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class G6 implements F6 {

    /* renamed from: a, reason: from kotlin metadata */
    private final Yf relativePathFormer;

    public G6(Yf yf) {
        this.relativePathFormer = yf;
    }

    @Override // io.appmetrica.analytics.impl.F6
    public File a(Context context, String simpleName) {
        return new File(context.getNoBackupFilesDir(), this.relativePathFormer.a(simpleName));
    }
}
