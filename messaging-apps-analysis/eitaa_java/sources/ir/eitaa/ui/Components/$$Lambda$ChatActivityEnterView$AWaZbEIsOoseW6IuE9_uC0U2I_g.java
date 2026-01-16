package ir.eitaa.ui.Components;

import ir.eitaa.ui.Components.AlertsCreator;
import java.io.IOException;

/* compiled from: lambda */
/* renamed from: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$AWaZbEIsOoseW6IuE9_uC0U2I_g, reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$ChatActivityEnterView$AWaZbEIsOoseW6IuE9_uC0U2I_g implements AlertsCreator.ScheduleDatePickerDelegate {
    public final /* synthetic */ ChatActivityEnterView f$0;

    public /* synthetic */ $$Lambda$ChatActivityEnterView$AWaZbEIsOoseW6IuE9_uC0U2I_g(ChatActivityEnterView chatActivityEnterView) {
        this.f$0 = chatActivityEnterView;
    }

    @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
    public final void didSelectDate(boolean z, int i) throws InterruptedException, IOException {
        this.f$0.sendMessageInternal(z, i);
    }
}
