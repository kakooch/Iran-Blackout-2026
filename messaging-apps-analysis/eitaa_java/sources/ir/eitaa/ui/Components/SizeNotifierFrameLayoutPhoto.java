package ir.eitaa.ui.Components;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class SizeNotifierFrameLayoutPhoto extends FrameLayout {
    private SizeNotifierFrameLayoutPhotoDelegate delegate;
    private int keyboardHeight;
    private android.graphics.Rect rect;
    private boolean useSmoothKeyboard;
    private boolean withoutWindow;

    public interface SizeNotifierFrameLayoutPhotoDelegate {
        void onSizeChanged(int keyboardHeight, boolean isWidthGreater);
    }

    public SizeNotifierFrameLayoutPhoto(Context context, boolean smoothKeyboard) {
        super(context);
        this.rect = new android.graphics.Rect();
        this.useSmoothKeyboard = smoothKeyboard;
    }

    public void setDelegate(SizeNotifierFrameLayoutPhotoDelegate sizeNotifierFrameLayoutPhotoDelegate) {
        this.delegate = sizeNotifierFrameLayoutPhotoDelegate;
    }

    public void setWithoutWindow(boolean value) {
        this.withoutWindow = value;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        notifyHeightChanged();
    }

    public int getKeyboardHeight() {
        View rootView = getRootView();
        getWindowVisibleDisplayFrame(this.rect);
        if (this.withoutWindow) {
            int height = (rootView.getHeight() - (this.rect.top != 0 ? AndroidUtilities.statusBarHeight : 0)) - AndroidUtilities.getViewInset(rootView);
            android.graphics.Rect rect = this.rect;
            return height - (rect.bottom - rect.top);
        }
        int height2 = (((Activity) rootView.getContext()).getWindow().getDecorView().getHeight() - AndroidUtilities.getViewInset(rootView)) - rootView.getBottom();
        if (height2 <= Math.max(AndroidUtilities.dp(10.0f), AndroidUtilities.statusBarHeight)) {
            return 0;
        }
        return height2;
    }

    public void notifyHeightChanged() {
        if (this.delegate != null) {
            this.keyboardHeight = getKeyboardHeight();
            android.graphics.Point point = AndroidUtilities.displaySize;
            final boolean z = point.x > point.y;
            post(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SizeNotifierFrameLayoutPhoto$hhODyrkJvkJovrSWBAWojDnt1OI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$notifyHeightChanged$0$SizeNotifierFrameLayoutPhoto(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$notifyHeightChanged$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$notifyHeightChanged$0$SizeNotifierFrameLayoutPhoto(boolean z) {
        SizeNotifierFrameLayoutPhotoDelegate sizeNotifierFrameLayoutPhotoDelegate = this.delegate;
        if (sizeNotifierFrameLayoutPhotoDelegate != null) {
            sizeNotifierFrameLayoutPhotoDelegate.onSizeChanged(this.keyboardHeight, z);
        }
    }
}
