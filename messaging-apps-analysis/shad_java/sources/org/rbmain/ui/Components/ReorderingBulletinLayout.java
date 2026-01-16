package org.rbmain.ui.Components;

import android.content.Context;
import android.widget.ImageView;
import org.rbmain.ui.Components.Bulletin;

/* loaded from: classes5.dex */
public class ReorderingBulletinLayout extends Bulletin.SimpleLayout {
    private final ReorderingHintDrawable hintDrawable;

    public ReorderingBulletinLayout(Context context, String str) {
        super(context, null);
        this.textView.setText(str);
        this.textView.setTranslationY(-1.0f);
        ImageView imageView = this.imageView;
        ReorderingHintDrawable reorderingHintDrawable = new ReorderingHintDrawable();
        this.hintDrawable = reorderingHintDrawable;
        imageView.setImageDrawable(reorderingHintDrawable);
    }

    @Override // org.rbmain.ui.Components.Bulletin.Layout
    protected void onEnterTransitionEnd() {
        super.onEnterTransitionEnd();
        this.hintDrawable.startAnimation();
    }

    @Override // org.rbmain.ui.Components.Bulletin.Layout
    protected void onExitTransitionEnd() {
        super.onExitTransitionEnd();
        this.hintDrawable.resetAnimation();
    }
}
