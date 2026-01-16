package androidx.camera.core.impl;

import androidx.camera.core.impl.DeferrableSurface;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.InterfaceFutureC15215jC3;
import ir.nasim.MB2;
import ir.nasim.WB2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class k {

    class a implements MB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ AbstractC16967mA0.a b;

        a(boolean z, AbstractC16967mA0.a aVar) {
            this.a = z;
            this.b = aVar;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List list) {
            AbstractC4980Hj5.g(list);
            ArrayList arrayList = new ArrayList(list);
            if (this.a) {
                arrayList.removeAll(Collections.singleton(null));
            }
            this.b.c(arrayList);
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            if (th instanceof TimeoutException) {
                this.b.f(th);
            } else {
                this.b.c(Collections.emptyList());
            }
        }
    }

    public static void c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((DeferrableSurface) it.next()).e();
        }
    }

    public static void d(List list) throws DeferrableSurface.SurfaceClosedException {
        if (list.isEmpty()) {
            return;
        }
        int i = 0;
        do {
            try {
                ((DeferrableSurface) list.get(i)).l();
                i++;
            } catch (DeferrableSurface.SurfaceClosedException e) {
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    ((DeferrableSurface) list.get(i2)).e();
                }
                throw e;
            }
        } while (i < list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object f(final InterfaceFutureC15215jC3 interfaceFutureC15215jC3, Executor executor, boolean z, Collection collection, AbstractC16967mA0.a aVar) {
        aVar.a(new Runnable() { // from class: ir.nasim.xG1
            @Override // java.lang.Runnable
            public final void run() {
                interfaceFutureC15215jC3.cancel(true);
            }
        }, executor);
        WB2.g(interfaceFutureC15215jC3, new a(z, aVar), executor);
        return "surfaceList[" + collection + "]";
    }

    public static InterfaceFutureC15215jC3 g(final Collection collection, final boolean z, long j, final Executor executor, ScheduledExecutorService scheduledExecutorService) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(WB2.t(((DeferrableSurface) it.next()).j()));
        }
        final InterfaceFutureC15215jC3 interfaceFutureC15215jC3S = WB2.s(j, scheduledExecutorService, WB2.x(arrayList));
        return AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.wG1
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return androidx.camera.core.impl.k.f(interfaceFutureC15215jC3S, executor, z, collection, aVar);
            }
        });
    }
}
