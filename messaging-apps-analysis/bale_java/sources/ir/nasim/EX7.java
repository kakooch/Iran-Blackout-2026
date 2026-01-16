package ir.nasim;

import android.view.View;
import androidx.compose.ui.platform.AbstractComposeView;

/* loaded from: classes2.dex */
public interface EX7 {
    default AbstractComposeView getSubCompositionView() {
        return null;
    }

    default View getViewRoot() {
        return null;
    }
}
