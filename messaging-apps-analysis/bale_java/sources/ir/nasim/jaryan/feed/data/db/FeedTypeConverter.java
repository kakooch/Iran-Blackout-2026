package ir.nasim.jaryan.feed.data.db;

import com.google.gson.reflect.TypeToken;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.C15759k74;
import ir.nasim.C4026Dj2;
import ir.nasim.CW4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KS2;
import ir.nasim.SA2;
import ir.nasim.jaryan.feed.data.db.FeedTypeConverter;
import java.util.List;

/* loaded from: classes6.dex */
public final class FeedTypeConverter {
    private final InterfaceC9173Yu3 a = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Fj2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return FeedTypeConverter.f();
        }
    });

    private final KS2 e() {
        return (KS2) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KS2 f() {
        return new KS2();
    }

    public final String b(C4026Dj2 c4026Dj2) {
        AbstractC13042fc3.i(c4026Dj2, "reactions");
        String strT = e().t(c4026Dj2);
        AbstractC13042fc3.h(strT, "toJson(...)");
        return strT;
    }

    public final C4026Dj2 c(String str) {
        AbstractC13042fc3.i(str, "jsonReaction");
        Object objL = e().l(str, new TypeToken<C4026Dj2>() { // from class: ir.nasim.jaryan.feed.data.db.FeedTypeConverter$fromJsonFeedTag$type$1
        }.d());
        AbstractC13042fc3.h(objL, "fromJson(...)");
        return (C4026Dj2) objL;
    }

    public final List d(String str) {
        AbstractC13042fc3.i(str, "jsonReaction");
        Object objL = e().l(str, new TypeToken<List<? extends C15759k74>>() { // from class: ir.nasim.jaryan.feed.data.db.FeedTypeConverter$fromJsonReactions$type$1
        }.d());
        AbstractC13042fc3.h(objL, "fromJson(...)");
        return (List) objL;
    }

    public final CW4 g(String str) {
        return (CW4) e().k(str, CW4.class);
    }

    public final String h(CW4 cw4) {
        String strT = e().t(cw4);
        AbstractC13042fc3.h(strT, "toJson(...)");
        return strT;
    }

    public final String i(List list) {
        AbstractC13042fc3.i(list, "reactions");
        String strT = e().t(list);
        AbstractC13042fc3.h(strT, "toJson(...)");
        return strT;
    }
}
