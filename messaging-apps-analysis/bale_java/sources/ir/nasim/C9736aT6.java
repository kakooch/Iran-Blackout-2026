package ir.nasim;

import ai.bale.proto.StoryStruct$Coordinate;
import ai.bale.proto.StoryStruct$Widget;
import ir.nasim.database.model.story.WidgetCoordinate;
import ir.nasim.story.model.StoryWidget;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.aT6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C9736aT6 implements InterfaceC14123hO3 {
    private final QQ6 a;

    /* renamed from: ir.nasim.aT6$a */
    public interface a {
        C9736aT6 a(QQ6 qq6);
    }

    /* renamed from: ir.nasim.aT6$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[StoryStruct$Widget.b.values().length];
            try {
                iArr[StoryStruct$Widget.b.LINK_WIDGET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StoryStruct$Widget.b.POST_WIDGET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StoryStruct$Widget.b.POLL_WIDGET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StoryStruct$Widget.b.RESTORY_WIDGET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StoryStruct$Widget.b.TRAIT_NOT_SET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    public C9736aT6(QQ6 qq6) {
        AbstractC13042fc3.i(qq6, "storyItem");
        this.a = qq6;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JX6 a(StoryStruct$Widget storyStruct$Widget) {
        StoryWidget linkWidget;
        AbstractC13042fc3.i(storyStruct$Widget, "input");
        try {
            List<StoryStruct$Coordinate> coordinatesList = storyStruct$Widget.getPosition().getCoordinatesList();
            AbstractC13042fc3.h(coordinatesList, "getCoordinatesList(...)");
            List<StoryStruct$Coordinate> list = coordinatesList;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (StoryStruct$Coordinate storyStruct$Coordinate : list) {
                arrayList.add(new WidgetCoordinate(storyStruct$Coordinate.getX(), storyStruct$Coordinate.getY()));
            }
            StoryStruct$Widget.b traitCase = storyStruct$Widget.getTraitCase();
            int i = traitCase == null ? -1 : b.a[traitCase.ordinal()];
            if (i == -1) {
                linkWidget = StoryWidget.Unknown.a;
            } else if (i == 1) {
                String link = storyStruct$Widget.getLinkWidget().getLink();
                AbstractC13042fc3.h(link, "getLink(...)");
                String title = storyStruct$Widget.getLinkWidget().getTitle();
                AbstractC13042fc3.h(title, "getTitle(...)");
                linkWidget = new StoryWidget.LinkWidget(link, title, arrayList);
            } else if (i != 2) {
                if (i != 3 && i != 4 && i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                linkWidget = StoryWidget.Unknown.a;
            } else {
                String link2 = storyStruct$Widget.getPostWidget().getLink();
                AbstractC13042fc3.h(link2, "getLink(...)");
                linkWidget = new StoryWidget.PostWidget(link2, arrayList);
            }
            return new JX6(this.a.l(), this.a.a(48L), linkWidget);
        } catch (Exception unused) {
            return new JX6(this.a.l(), this.a.a(48L), StoryWidget.Unknown.a);
        }
    }
}
