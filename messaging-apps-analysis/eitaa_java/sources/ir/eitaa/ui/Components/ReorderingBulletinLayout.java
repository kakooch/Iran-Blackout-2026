package ir.eitaa.ui.Components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.Bulletin;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class ReorderingBulletinLayout extends Bulletin.SimpleLayout {
    private final ReorderingHintDrawable hintDrawable;

    public ReorderingBulletinLayout(Context context, String text, Theme.ResourcesProvider resourcesProvider) {
        super(context, resourcesProvider);
        this.textView.setText(text);
        this.textView.setTranslationY(-1.0f);
        ImageView imageView = this.imageView;
        ReorderingHintDrawable reorderingHintDrawable = new ReorderingHintDrawable();
        this.hintDrawable = reorderingHintDrawable;
        imageView.setImageDrawable(reorderingHintDrawable);
    }

    @Override // ir.eitaa.ui.Components.Bulletin.Layout
    protected void onEnterTransitionEnd() {
        super.onEnterTransitionEnd();
        this.hintDrawable.startAnimation();
    }

    @Override // ir.eitaa.ui.Components.Bulletin.Layout
    protected void onExitTransitionEnd() {
        super.onExitTransitionEnd();
        this.hintDrawable.resetAnimation();
    }
}
