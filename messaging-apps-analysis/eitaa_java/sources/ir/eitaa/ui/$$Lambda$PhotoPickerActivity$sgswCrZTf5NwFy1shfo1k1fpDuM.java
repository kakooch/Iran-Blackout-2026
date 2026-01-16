package ir.eitaa.ui;

import ir.eitaa.ui.Components.AlertsCreator;

/* compiled from: lambda */
/* renamed from: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$sgswCrZTf5NwFy1shfo1k1fpDuM, reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$PhotoPickerActivity$sgswCrZTf5NwFy1shfo1k1fpDuM implements AlertsCreator.ScheduleDatePickerDelegate {
    public final /* synthetic */ PhotoPickerActivity f$0;

    public /* synthetic */ $$Lambda$PhotoPickerActivity$sgswCrZTf5NwFy1shfo1k1fpDuM(PhotoPickerActivity photoPickerActivity) {
        this.f$0 = photoPickerActivity;
    }

    @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
    public final void didSelectDate(boolean z, int i) {
        this.f$0.sendSelectedPhotos(z, i);
    }
}
