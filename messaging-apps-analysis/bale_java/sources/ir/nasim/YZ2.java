package ir.nasim;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.RenderView;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public interface YZ2 {
    void B();

    boolean a();

    boolean c(MotionEvent motionEvent);

    void e(boolean z);

    Bitmap f(ArrayList arrayList, Bitmap[] bitmapArr);

    default int getAdditionalBottom() {
        return 0;
    }

    default int getAdditionalTop() {
        return 0;
    }

    View getCancelView();

    long getLcm();

    List getMasks();

    float getOffsetTranslationY();

    RenderView getRenderView();

    /* JADX WARN: Multi-variable type inference failed */
    default View getView() {
        if (this instanceof View) {
            return (View) this;
        }
        throw new IllegalArgumentException("You should override getView() if you're not inheriting from it.");
    }

    void init();

    int j(boolean z);

    void o(PhotoViewer photoViewer, Activity activity, Runnable runnable);

    float p();

    void setOffsetTranslationY(float f, float f2, int i, boolean z);

    void setOnDoneButtonClickedListener(Runnable runnable);

    void setTransform(float f, float f2, float f3, float f4, float f5);

    void shutdown();

    boolean x();

    default void r() {
    }

    default void m(boolean z) {
    }

    default void setOffsetTranslationX(float f) {
    }
}
