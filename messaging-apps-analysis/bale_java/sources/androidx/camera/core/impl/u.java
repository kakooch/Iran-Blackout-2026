package androidx.camera.core.impl;

import androidx.camera.core.impl.j;
import java.util.Set;

/* loaded from: classes.dex */
public interface u extends j {
    @Override // androidx.camera.core.impl.j
    default Object a(j.a aVar) {
        return getConfig().a(aVar);
    }

    @Override // androidx.camera.core.impl.j
    default boolean b(j.a aVar) {
        return getConfig().b(aVar);
    }

    @Override // androidx.camera.core.impl.j
    default void c(String str, j.b bVar) {
        getConfig().c(str, bVar);
    }

    @Override // androidx.camera.core.impl.j
    default Object d(j.a aVar, j.c cVar) {
        return getConfig().d(aVar, cVar);
    }

    @Override // androidx.camera.core.impl.j
    default Set e() {
        return getConfig().e();
    }

    @Override // androidx.camera.core.impl.j
    default Set f(j.a aVar) {
        return getConfig().f(aVar);
    }

    @Override // androidx.camera.core.impl.j
    default Object g(j.a aVar, Object obj) {
        return getConfig().g(aVar, obj);
    }

    j getConfig();

    @Override // androidx.camera.core.impl.j
    default j.c h(j.a aVar) {
        return getConfig().h(aVar);
    }
}
