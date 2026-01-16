package ir.nasim;

import android.app.Activity;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.internal.AbstractC2061e;
import com.google.android.gms.common.api.internal.AbstractC2064h;
import com.google.android.gms.common.api.internal.C2060d;
import com.google.android.gms.common.api.internal.C2063g;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.ik8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14946ik8 extends com.google.android.gms.common.api.b implements KB2 {
    static final a.g k;
    public static final com.google.android.gms.common.api.a l;

    static {
        a.g gVar = new a.g();
        k = gVar;
        l = new com.google.android.gms.common.api.a("LocationServices.API", new C11284ck8(), gVar);
    }

    public C14946ik8(Activity activity) {
        super(activity, l, (a.d) a.d.P, b.a.c);
    }

    private final Task z(final LocationRequest locationRequest, C2060d c2060d) {
        final C13745gk8 c13745gk8 = new C13745gk8(this, c2060d, new InterfaceC12518ek8() { // from class: ir.nasim.Qi8
            @Override // ir.nasim.InterfaceC12518ek8
            public final void a(com.google.android.gms.internal.location.i iVar, C2060d.a aVar, boolean z, C4982Hj7 c4982Hj7) {
                iVar.m0(aVar, z, c4982Hj7);
            }
        });
        return m(C2063g.a().b(new InterfaceC13525gN5() { // from class: ir.nasim.Ui8
            @Override // ir.nasim.InterfaceC13525gN5
            public final void accept(Object obj, Object obj2) {
                com.google.android.gms.common.api.a aVar = C14946ik8.l;
                ((com.google.android.gms.internal.location.i) obj).p0(c13745gk8, locationRequest, (C4982Hj7) obj2);
            }
        }).d(c13745gk8).e(c2060d).c(2436).a());
    }

    @Override // ir.nasim.KB2
    public final Task b(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            AbstractC3795Cj5.k(looper, "invalid null looper");
        }
        return z(locationRequest, AbstractC2061e.a(locationCallback, looper, LocationCallback.class.getSimpleName()));
    }

    @Override // ir.nasim.KB2
    public final Task d(LocationCallback locationCallback) {
        return n(AbstractC2061e.b(locationCallback, LocationCallback.class.getSimpleName()), 2418).h(new Executor() { // from class: ir.nasim.Zj8
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        }, new InterfaceC20886sm1() { // from class: ir.nasim.Ij8
            @Override // ir.nasim.InterfaceC20886sm1
            public final Object a(Task task) {
                com.google.android.gms.common.api.a aVar = C14946ik8.l;
                return null;
            }
        });
    }

    @Override // ir.nasim.KB2
    public final Task g() {
        return l(AbstractC2064h.a().b(new InterfaceC13525gN5() { // from class: ir.nasim.Lj8
            @Override // ir.nasim.InterfaceC13525gN5
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.internal.location.i) obj).o0(new LastLocationRequest.a().a(), (C4982Hj7) obj2);
            }
        }).e(2414).a());
    }
}
