package org.rbmain.messenger;

import java.io.IOException;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes4.dex */
public final /* synthetic */ class MessagesController$$ExternalSyntheticLambda180 implements Runnable {
    public static final /* synthetic */ MessagesController$$ExternalSyntheticLambda180 INSTANCE = new MessagesController$$ExternalSyntheticLambda180();

    private /* synthetic */ MessagesController$$ExternalSyntheticLambda180() {
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Theme.checkAutoNightThemeConditions();
    }
}
