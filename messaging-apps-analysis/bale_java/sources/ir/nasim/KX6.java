package ir.nasim;

import ir.nasim.story.model.LinkWidget;
import ir.nasim.story.model.PostWidget;
import ir.nasim.story.model.StoryWidget;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes7.dex */
public final class KX6 implements InterfaceC14123hO3 {
    private final KS2 a;

    public KX6(KS2 ks2) {
        AbstractC13042fc3.i(ks2, "gson");
        this.a = ks2;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public HX6 a(JX6 jx6) {
        HX6 hx6;
        AbstractC13042fc3.i(jx6, "input");
        try {
            StoryWidget storyWidgetC = jx6.c();
            if (storyWidgetC instanceof StoryWidget.LinkWidget) {
                String strB = jx6.b();
                EnumC9168Yt7 enumC9168Yt7 = EnumC9168Yt7.b;
                KS2 ks2 = this.a;
                String strA = ((StoryWidget.LinkWidget) jx6.c()).a();
                if (strA == null) {
                    strA = "";
                }
                String strT = ks2.t(new LinkWidget(strA, ((StoryWidget.LinkWidget) jx6.c()).getTitle()));
                AbstractC13042fc3.h(strT, "toJson(...)");
                hx6 = new HX6(0, strB, enumC9168Yt7, strT, jx6.a(), ((StoryWidget.LinkWidget) jx6.c()).getWidgetCoordinates(), 1, null);
            } else {
                if (!(storyWidgetC instanceof StoryWidget.PostWidget)) {
                    if (AbstractC13042fc3.d(storyWidgetC, StoryWidget.Unknown.a)) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                String strB2 = jx6.b();
                EnumC9168Yt7 enumC9168Yt72 = EnumC9168Yt7.d;
                String strT2 = this.a.t(new PostWidget(((StoryWidget.PostWidget) jx6.c()).getLink()));
                AbstractC13042fc3.h(strT2, "toJson(...)");
                hx6 = new HX6(0, strB2, enumC9168Yt72, strT2, jx6.a(), ((StoryWidget.PostWidget) jx6.c()).getWidgetCoordinates(), 1, null);
            }
            return hx6;
        } catch (Exception unused) {
            return null;
        }
    }
}
