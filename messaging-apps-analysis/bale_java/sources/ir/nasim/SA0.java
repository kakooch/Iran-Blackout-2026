package ir.nasim;

import android.content.Context;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class SA0 implements InterfaceC11560dD0 {
    private final Context a;
    private final MC0 b;
    private final LD0 c;
    private final KD0 d;
    private final C17585nD0 e;
    private final List f;
    private final C21341tV1 g;
    private final long h;
    private final Map i = new HashMap();

    public SA0(Context context, LD0 ld0, ED0 ed0, long j) {
        this.a = context;
        this.c = ld0;
        C17585nD0 c17585nD0B = C17585nD0.b(context, ld0.c());
        this.e = c17585nD0B;
        this.g = C21341tV1.c(context);
        this.f = e(DD0.b(this, ed0));
        RA0 ra0 = new RA0(c17585nD0B);
        this.b = ra0;
        KD0 kd0 = new KD0(ra0, 1);
        this.d = kd0;
        ra0.a(kd0);
        this.h = j;
    }

    private List e(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.equals("0") || str.equals("1")) {
                arrayList.add(str);
            } else if (AbstractC13430gD0.a(this.e, str)) {
                arrayList.add(str);
            } else {
                PI3.a("Camera2CameraFactory", "Camera " + str + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC11560dD0
    public InterfaceC15221jD0 a(String str) {
        if (this.f.contains(str)) {
            return new C14601iB0(this.a, this.e, str, f(str), this.b, this.d, this.c.b(), this.c.c(), this.g, this.h);
        }
        throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
    }

    @Override // ir.nasim.InterfaceC11560dD0
    public Set b() {
        return new LinkedHashSet(this.f);
    }

    @Override // ir.nasim.InterfaceC11560dD0
    public MC0 d() {
        return this.b;
    }

    C18749pB0 f(String str) throws CameraUnavailableException {
        try {
            C18749pB0 c18749pB0 = (C18749pB0) this.i.get(str);
            if (c18749pB0 != null) {
                return c18749pB0;
            }
            C18749pB0 c18749pB02 = new C18749pB0(str, this.e);
            this.i.put(str, c18749pB02);
            return c18749pB02;
        } catch (CameraAccessExceptionCompat e) {
            throw MD0.a(e);
        }
    }

    @Override // ir.nasim.InterfaceC11560dD0
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C17585nD0 c() {
        return this.e;
    }
}
