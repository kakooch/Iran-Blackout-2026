package ir.nasim;

import ai.bale.proto.MagazineStruct$FeedMessageContainer;
import ai.bale.proto.MagazineStruct$SimilarMessageContainer;
import ir.nasim.C6613Og2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.xC6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC23608xC6 {
    public static final List a(List list) {
        AbstractC13042fc3.i(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (C6613Og2.b.b.a(((MagazineStruct$FeedMessageContainer) obj).getMessage().getValueCase().name()) != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final List b(List list) {
        AbstractC13042fc3.i(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (C6613Og2.b.b.a(((MagazineStruct$SimilarMessageContainer) obj).getMessage().getMessage().getValueCase().name()) != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
