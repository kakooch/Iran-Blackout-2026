package androidx.camera.extensions;

import androidx.camera.extensions.impl.InitializerImpl;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.BD0;
import ir.nasim.PI3;

/* loaded from: classes.dex */
public final class ExtensionsManager {
    private static final Object c = new Object();
    private static ExtensionsManager d;
    private final ExtensionsAvailability a;
    private final b b;

    /* renamed from: androidx.camera.extensions.ExtensionsManager$1, reason: invalid class name */
    class AnonymousClass1 implements InitializerImpl.OnExtensionsInitializedCallback {
        final /* synthetic */ BD0 val$cameraProvider;
        final /* synthetic */ AbstractC16967mA0.a val$completer;

        AnonymousClass1(AbstractC16967mA0.a aVar, BD0 bd0) {
            this.val$completer = aVar;
            this.val$cameraProvider = bd0;
        }

        public void onFailure(int i) {
            PI3.c("ExtensionsManager", "Failed to initialize extensions");
            this.val$completer.c(ExtensionsManager.a(ExtensionsAvailability.LIBRARY_UNAVAILABLE_ERROR_LOADING, this.val$cameraProvider));
        }

        public void onSuccess() {
            PI3.a("ExtensionsManager", "Successfully initialized extensions");
            this.val$completer.c(ExtensionsManager.a(ExtensionsAvailability.LIBRARY_AVAILABLE, this.val$cameraProvider));
        }
    }

    /* renamed from: androidx.camera.extensions.ExtensionsManager$2, reason: invalid class name */
    class AnonymousClass2 implements InitializerImpl.OnExtensionsDeinitializedCallback {
        final /* synthetic */ AbstractC16967mA0.a val$completer;

        AnonymousClass2(AbstractC16967mA0.a aVar) {
            this.val$completer = aVar;
        }

        public void onFailure(int i) {
            this.val$completer.f(new Exception("Failed to deinitialize extensions."));
        }

        public void onSuccess() {
            this.val$completer.c(null);
        }
    }

    enum ExtensionsAvailability {
        LIBRARY_AVAILABLE,
        LIBRARY_UNAVAILABLE_ERROR_LOADING,
        LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION,
        NONE
    }

    private ExtensionsManager(ExtensionsAvailability extensionsAvailability, BD0 bd0) {
        this.a = extensionsAvailability;
        this.b = new b(bd0);
    }

    static ExtensionsManager a(ExtensionsAvailability extensionsAvailability, BD0 bd0) {
        synchronized (c) {
            try {
                ExtensionsManager extensionsManager = d;
                if (extensionsManager != null) {
                    return extensionsManager;
                }
                ExtensionsManager extensionsManager2 = new ExtensionsManager(extensionsAvailability, bd0);
                d = extensionsManager2;
                return extensionsManager2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
