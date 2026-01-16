package ir.resaneh1.iptv.helper;

import org.rbmain.ui.Components.Point;

/* loaded from: classes3.dex */
public class TouchHelper {
    public static boolean isClick(Point point, Point point2) {
        return Math.abs(point.x - point2.x) <= 50.0f && Math.abs(point.y - point2.y) <= 50.0f;
    }
}
