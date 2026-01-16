package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class Scene {
    private Runnable mExitAction;
    private ViewGroup mSceneRoot;

    public void exit() {
        Runnable runnable;
        if (getCurrentScene(this.mSceneRoot) != this || (runnable = this.mExitAction) == null) {
            return;
        }
        runnable.run();
    }

    static void setCurrentScene(View view, Scene scene) {
        view.setTag(R$id.transition_current_scene, scene);
    }

    static Scene getCurrentScene(View view) {
        return (Scene) view.getTag(R$id.transition_current_scene);
    }
}
