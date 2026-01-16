package ir.nasim;

import android.content.res.Resources;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder;

/* renamed from: ir.nasim.lT6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final /* synthetic */ class RunnableC16553lT6 implements Runnable {
    public final /* synthetic */ StoryRecorder a;

    public /* synthetic */ RunnableC16553lT6(StoryRecorder storyRecorder) {
        this.a = storyRecorder;
    }

    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException {
        this.a.s2();
    }
}
