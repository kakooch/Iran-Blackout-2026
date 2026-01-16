package ir.nasim;

import ir.nasim.InterfaceC19490qR6;
import ir.nasim.story.model.StoryWidget;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.rR6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20081rR6 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List a(InterfaceC19490qR6 interfaceC19490qR6) {
        AbstractC13042fc3.i(interfaceC19490qR6, "input");
        ArrayList arrayList = new ArrayList();
        if (AbstractC13042fc3.d(interfaceC19490qR6, InterfaceC19490qR6.a.a)) {
            arrayList.add(StoryWidget.Unknown.a);
        } else {
            if (!(interfaceC19490qR6 instanceof InterfaceC19490qR6.b)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC19490qR6.b bVar = (InterfaceC19490qR6.b) interfaceC19490qR6;
            String strB = bVar.b();
            String strC = bVar.c();
            if (strC == null) {
                strC = "";
            }
            arrayList.add(new StoryWidget.LinkWidget(strB, strC, null, 4, null));
        }
        return arrayList;
    }
}
