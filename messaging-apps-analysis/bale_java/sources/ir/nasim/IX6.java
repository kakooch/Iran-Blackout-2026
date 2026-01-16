package ir.nasim;

import ir.nasim.story.model.LinkWidget;
import ir.nasim.story.model.PostWidget;
import ir.nasim.story.model.StoryWidget;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes7.dex */
public final class IX6 implements InterfaceC14123hO3 {
    private final KS2 a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC9168Yt7.values().length];
            try {
                iArr[EnumC9168Yt7.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC9168Yt7.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC9168Yt7.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC9168Yt7.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC9168Yt7.f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    public IX6(KS2 ks2) {
        AbstractC13042fc3.i(ks2, "gson");
        this.a = ks2;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JX6 a(HX6 hx6) {
        StoryWidget linkWidget;
        StoryWidget storyWidget;
        AbstractC13042fc3.i(hx6, "input");
        try {
            int i = a.a[hx6.e().ordinal()];
            if (i == 1) {
                LinkWidget linkWidget2 = (LinkWidget) this.a.k(hx6.f(), LinkWidget.class);
                String link = linkWidget2.getLink();
                String title = linkWidget2.getTitle();
                List listA = hx6.a();
                if (listA == null) {
                    listA = AbstractC10360bX0.m();
                }
                linkWidget = new StoryWidget.LinkWidget(link, title, listA);
            } else {
                if (i != 2) {
                    if (i != 3 && i != 4 && i != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    storyWidget = StoryWidget.Unknown.a;
                    return new JX6(hx6.d(), hx6.b(), storyWidget);
                }
                String link2 = ((PostWidget) this.a.k(hx6.f(), PostWidget.class)).getLink();
                List listA2 = hx6.a();
                if (listA2 == null) {
                    listA2 = AbstractC10360bX0.m();
                }
                linkWidget = new StoryWidget.PostWidget(link2, listA2);
            }
            storyWidget = linkWidget;
            return new JX6(hx6.d(), hx6.b(), storyWidget);
        } catch (Exception e) {
            C19406qI3.b("Story", "StoryWidgetEntityToWidgetDataMapper: " + e);
            return new JX6(hx6.d(), hx6.b(), StoryWidget.Unknown.a);
        }
    }
}
