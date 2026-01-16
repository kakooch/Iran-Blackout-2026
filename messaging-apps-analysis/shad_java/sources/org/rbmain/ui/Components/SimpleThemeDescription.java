package org.rbmain.ui.Components;

import java.util.ArrayList;
import org.rbmain.ui.ActionBar.ThemeDescription;

/* loaded from: classes5.dex */
public class SimpleThemeDescription {
    public static ThemeDescription createThemeDescription(ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate, int i) {
        return new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, i);
    }

    public static ArrayList<ThemeDescription> createThemeDescriptions(ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate, int... iArr) {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>(iArr.length);
        for (int i : iArr) {
            arrayList.add(createThemeDescription(themeDescriptionDelegate, i));
        }
        return arrayList;
    }
}
