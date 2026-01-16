package ir.nasim;

import android.content.res.Resources;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder;

/* renamed from: ir.nasim.sT6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final /* synthetic */ class RunnableC20708sT6 implements Runnable {
    public final /* synthetic */ StoryRecorder a;

    public /* synthetic */ RunnableC20708sT6(StoryRecorder storyRecorder) {
        this.a = storyRecorder;
    }

    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException {
        this.a.H3();
    }
}
