package ir.nasim;

import android.app.Activity;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Rect;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import ir.nasim.C18922pU2;
import ir.nasim.InterfaceC7920Tt2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Ve2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8253Ve2 {
    public static final C8253Ve2 a = new C8253Ve2();

    private C8253Ve2() {
    }

    private final boolean c(Activity activity, C3565Bk0 c3565Bk0) {
        Rect rectA = Ca8.a.a(activity).a();
        if (c3565Bk0.e()) {
            return false;
        }
        if (c3565Bk0.d() != rectA.width() && c3565Bk0.a() != rectA.height()) {
            return false;
        }
        if (c3565Bk0.d() >= rectA.width() || c3565Bk0.a() >= rectA.height()) {
            return (c3565Bk0.d() == rectA.width() && c3565Bk0.a() == rectA.height()) ? false : true;
        }
        return false;
    }

    public final InterfaceC7920Tt2 a(Activity activity, FoldingFeature foldingFeature) {
        C18922pU2.b bVarA;
        InterfaceC7920Tt2.b bVar;
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(foldingFeature, "oemFeature");
        int type = foldingFeature.getType();
        if (type == 1) {
            bVarA = C18922pU2.b.b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = C18922pU2.b.b.b();
        }
        int state = foldingFeature.getState();
        if (state == 1) {
            bVar = InterfaceC7920Tt2.b.c;
        } else {
            if (state != 2) {
                return null;
            }
            bVar = InterfaceC7920Tt2.b.d;
        }
        Rect bounds = foldingFeature.getBounds();
        AbstractC13042fc3.h(bounds, "oemFeature.bounds");
        if (!c(activity, new C3565Bk0(bounds))) {
            return null;
        }
        Rect bounds2 = foldingFeature.getBounds();
        AbstractC13042fc3.h(bounds2, "oemFeature.bounds");
        return new C18922pU2(new C3565Bk0(bounds2), bVarA, bVar);
    }

    public final C25010za8 b(Activity activity, WindowLayoutInfo windowLayoutInfo) {
        InterfaceC7920Tt2 interfaceC7920Tt2A;
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(windowLayoutInfo, ParameterNames.INFO);
        List<FoldingFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        AbstractC13042fc3.h(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature foldingFeature : displayFeatures) {
            if (foldingFeature instanceof FoldingFeature) {
                C8253Ve2 c8253Ve2 = a;
                AbstractC13042fc3.h(foldingFeature, "feature");
                interfaceC7920Tt2A = c8253Ve2.a(activity, foldingFeature);
            } else {
                interfaceC7920Tt2A = null;
            }
            if (interfaceC7920Tt2A != null) {
                arrayList.add(interfaceC7920Tt2A);
            }
        }
        return new C25010za8(arrayList);
    }
}
