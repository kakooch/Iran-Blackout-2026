package io.sentry.android.core.internal.gestures;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.internal.gestures.b;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class i {
    private static final int[] a = new int[2];

    static io.sentry.internal.gestures.b a(SentryAndroidOptions sentryAndroidOptions, View view, float f, float f2, b.a aVar) {
        List<io.sentry.internal.gestures.a> gestureTargetLocators = sentryAndroidOptions.getGestureTargetLocators();
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        io.sentry.internal.gestures.b bVar = null;
        while (linkedList.size() > 0) {
            View view2 = (View) linkedList.poll();
            if (d(view2, f, f2)) {
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        linkedList.add(viewGroup.getChildAt(i));
                    }
                }
                for (int i2 = 0; i2 < gestureTargetLocators.size(); i2++) {
                    io.sentry.internal.gestures.b bVarA = gestureTargetLocators.get(i2).a(view2, f, f2, aVar);
                    if (bVarA != null) {
                        if (aVar == b.a.CLICKABLE) {
                            bVar = bVarA;
                        } else if (aVar == b.a.SCROLLABLE) {
                            return bVarA;
                        }
                    }
                }
            }
        }
        return bVar;
    }

    public static String b(View view) {
        int id = view.getId();
        if (id == -1 || c(id)) {
            throw new Resources.NotFoundException();
        }
        Resources resources = view.getContext().getResources();
        return resources != null ? resources.getResourceEntryName(id) : "";
    }

    private static boolean c(int i) {
        return ((-16777216) & i) == 0 && (i & 16777215) != 0;
    }

    private static boolean d(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        int[] iArr = a;
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return f >= ((float) i) && f <= ((float) (i + view.getWidth())) && f2 >= ((float) i2) && f2 <= ((float) (i2 + view.getHeight()));
    }
}
