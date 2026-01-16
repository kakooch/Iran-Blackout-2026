package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import ir.nasim.features.imageloader.GlideAppModule;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final GlideAppModule a = new GlideAppModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: ir.nasim.features.imageloader.GlideAppModule");
        }
    }

    @Override // ir.nasim.AbstractC9209Yy3
    public void a(Context context, b bVar, Registry registry) {
        this.a.a(context, bVar, registry);
    }

    @Override // ir.nasim.AbstractC13438gE
    public void b(Context context, c cVar) {
        this.a.b(context, cVar);
    }

    @Override // ir.nasim.AbstractC13438gE
    public boolean c() {
        return this.a.c();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public Set d() {
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a e() {
        return new a();
    }
}
