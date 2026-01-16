package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.D;
import ir.nasim.C19958rE0;
import ir.nasim.C24773zB0;
import ir.nasim.GB0;
import ir.nasim.InterfaceC11560dD0;
import ir.nasim.XC0;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class Camera2Config {

    public static final class DefaultProvider implements C19958rE0.b {
        @Override // ir.nasim.C19958rE0.b
        public C19958rE0 getCameraXConfig() {
            return Camera2Config.c();
        }
    }

    public static C19958rE0 c() {
        InterfaceC11560dD0.a aVar = new InterfaceC11560dD0.a() { // from class: ir.nasim.wB0
            @Override // ir.nasim.InterfaceC11560dD0.a
            public final InterfaceC11560dD0 a(Context context, LD0 ld0, ED0 ed0, long j) {
                return new SA0(context, ld0, ed0, j);
            }
        };
        XC0.a aVar2 = new XC0.a() { // from class: ir.nasim.xB0
            @Override // ir.nasim.XC0.a
            public final XC0 a(Context context, Object obj, Set set) {
                return Camera2Config.d(context, obj, set);
            }
        };
        return new C19958rE0.a().c(aVar).d(aVar2).g(new D.c() { // from class: ir.nasim.yB0
            @Override // androidx.camera.core.impl.D.c
            public final androidx.camera.core.impl.D a(Context context) {
                return Camera2Config.e(context);
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XC0 d(Context context, Object obj, Set set) throws InitializationException {
        try {
            return new C24773zB0(context, obj, set);
        } catch (CameraUnavailableException e) {
            throw new InitializationException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ D e(Context context) {
        return new GB0(context);
    }
}
