package org.rbmain.ui;

import org.rbmain.ui.ThemePreviewActivity;

/* loaded from: classes4.dex */
public final /* synthetic */ class WallpapersListActivity$$ExternalSyntheticLambda7 implements ThemePreviewActivity.WallpaperActivityDelegate {
    public final /* synthetic */ WallpapersListActivity f$0;

    public /* synthetic */ WallpapersListActivity$$ExternalSyntheticLambda7(WallpapersListActivity wallpapersListActivity) {
        this.f$0 = wallpapersListActivity;
    }

    @Override // org.rbmain.ui.ThemePreviewActivity.WallpaperActivityDelegate
    public final void didSetNewBackground() {
        this.f$0.removeSelfFromStack();
    }
}
