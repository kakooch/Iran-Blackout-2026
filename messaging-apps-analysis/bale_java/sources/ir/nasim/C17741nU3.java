package ir.nasim;

import android.content.Context;
import android.widget.TextView;
import ir.nasim.AU3;
import ir.nasim.AbstractC17150mU3;
import ir.nasim.C18332oU3;
import ir.nasim.C23177wU3;
import ir.nasim.C23767xU3;
import ir.nasim.HW4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.nU3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C17741nU3 implements AbstractC17150mU3.a {
    private final Context a;
    private final List b = new ArrayList(3);
    private TextView.BufferType c = TextView.BufferType.SPANNABLE;
    private boolean d = true;

    C17741nU3(Context context) {
        this.a = context;
    }

    private static List c(List list) {
        return new CM5(list).e();
    }

    @Override // ir.nasim.AbstractC17150mU3.a
    public AbstractC17150mU3 a() {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
        }
        List<InterfaceC21991uU3> listC = c(this.b);
        HW4.a aVar = new HW4.a();
        C23767xU3.a aVarD = C23767xU3.d(this.a);
        C18332oU3.a aVar2 = new C18332oU3.a();
        AU3.a aVar3 = new AU3.a();
        C23177wU3.a aVar4 = new C23177wU3.a();
        for (InterfaceC21991uU3 interfaceC21991uU3 : listC) {
            interfaceC21991uU3.d(aVar);
            interfaceC21991uU3.a(aVarD);
            interfaceC21991uU3.e(aVar2);
            interfaceC21991uU3.i(aVar3);
            interfaceC21991uU3.f(aVar4);
        }
        C18332oU3 c18332oU3H = aVar2.h(aVarD.z(), aVar4.a());
        return new C19514qU3(this.c, null, aVar.f(), AbstractC24951zU3.b(aVar3, c18332oU3H), c18332oU3H, Collections.unmodifiableList(listC), this.d);
    }

    @Override // ir.nasim.AbstractC17150mU3.a
    public AbstractC17150mU3.a b(InterfaceC21991uU3 interfaceC21991uU3) {
        this.b.add(interfaceC21991uU3);
        return this;
    }
}
