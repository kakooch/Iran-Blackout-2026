package ir.nasim;

import ai.bale.proto.StoryStruct$Coordinate;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19490qR6;
import ir.nasim.database.model.story.WidgetCoordinate;
import ir.nasim.story.model.StoryWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.sR6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20690sR6 implements InterfaceC14123hO3 {
    private final List c(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            WidgetCoordinate widgetCoordinate = (WidgetCoordinate) it.next();
            GeneratedMessageLite generatedMessageLiteA = StoryStruct$Coordinate.newBuilder().A(widgetCoordinate.getX()).B(widgetCoordinate.getY()).a();
            AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
            arrayList.add(generatedMessageLiteA);
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC19490qR6 a(StoryWidget.LinkWidget linkWidget) {
        if (linkWidget == null) {
            return InterfaceC19490qR6.a.a;
        }
        String strA = linkWidget.a();
        if (strA == null) {
            strA = "";
        }
        return new InterfaceC19490qR6.b(strA, c(linkWidget.getWidgetCoordinates()), linkWidget.getTitle());
    }
}
