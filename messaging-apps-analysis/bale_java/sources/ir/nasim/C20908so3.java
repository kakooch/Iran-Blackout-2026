package ir.nasim;

import android.view.KeyEvent;

/* renamed from: ir.nasim.so3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20908so3 {
    private final KeyEvent a;

    private /* synthetic */ C20908so3(KeyEvent keyEvent) {
        this.a = keyEvent;
    }

    public static final /* synthetic */ C20908so3 a(KeyEvent keyEvent) {
        return new C20908so3(keyEvent);
    }

    public static boolean c(KeyEvent keyEvent, Object obj) {
        return (obj instanceof C20908so3) && AbstractC13042fc3.d(keyEvent, ((C20908so3) obj).f());
    }

    public static int d(KeyEvent keyEvent) {
        return keyEvent.hashCode();
    }

    public static String e(KeyEvent keyEvent) {
        return "KeyEvent(nativeKeyEvent=" + keyEvent + ')';
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ KeyEvent f() {
        return this.a;
    }

    public int hashCode() {
        return d(this.a);
    }

    public String toString() {
        return e(this.a);
    }

    public static KeyEvent b(KeyEvent keyEvent) {
        return keyEvent;
    }
}
