package ir.nasim;

import androidx.camera.core.impl.CameraControlInternal;
import ir.nasim.AbstractC15273jI7;
import java.util.Collection;

/* renamed from: ir.nasim.jD0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC15221jD0 extends HB0, AbstractC15273jI7.b {

    /* renamed from: ir.nasim.jD0$a */
    public enum a {
        RELEASED(false),
        RELEASING(true),
        CLOSED(false),
        PENDING_OPEN(false),
        CLOSING(true),
        OPENING(true),
        OPEN(true),
        CONFIGURED(true);

        private final boolean a;

        a(boolean z) {
            this.a = z;
        }

        boolean j() {
            return this.a;
        }
    }

    @Override // ir.nasim.HB0
    default InterfaceC14021hD0 a() {
        return j();
    }

    CameraControlInternal b();

    default androidx.camera.core.impl.f d() {
        return AbstractC21826uC0.a();
    }

    void h(Collection collection);

    void i(Collection collection);

    InterfaceC14623iD0 j();

    default boolean l() {
        return a().d() == 0;
    }

    HG4 o();

    default boolean p() {
        return true;
    }

    default void e(boolean z) {
    }

    default void n(androidx.camera.core.impl.f fVar) {
    }

    default void q(boolean z) {
    }
}
