package ir.eitaa.ui.Cells;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.LocationController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.ShareLocationDrawable;

/* loaded from: classes3.dex */
public class SendLocationCell extends FrameLayout {
    private SimpleTextView accurateTextView;
    private int currentAccount;
    private long dialogId;
    private ImageView imageView;
    private Runnable invalidateRunnable;
    private RectF rect;
    private final Theme.ResourcesProvider resourcesProvider;
    private SimpleTextView titleTextView;

    public SendLocationCell(Context context, boolean live, Theme.ResourcesProvider resourcesProvider) throws Resources.NotFoundException {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.invalidateRunnable = new Runnable() { // from class: ir.eitaa.ui.Cells.SendLocationCell.1
            @Override // java.lang.Runnable
            public void run() {
                SendLocationCell.this.invalidate(((int) r0.rect.left) - 5, ((int) SendLocationCell.this.rect.top) - 5, ((int) SendLocationCell.this.rect.right) + 5, ((int) SendLocationCell.this.rect.bottom) + 5);
                AndroidUtilities.runOnUIThread(SendLocationCell.this.invalidateRunnable, 1000L);
            }
        };
        this.resourcesProvider = resourcesProvider;
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setTag(live ? "location_sendLiveLocationBackgroundlocation_sendLiveLocationIcon" : "location_sendLocationBackgroundlocation_sendLocationIcon");
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(42.0f), getThemedColor(live ? "location_sendLiveLocationBackground" : "location_sendLocationBackground"), getThemedColor(live ? "location_sendLiveLocationBackground" : "location_sendLocationBackground"));
        if (live) {
            this.rect = new RectF();
            ShareLocationDrawable shareLocationDrawable = new ShareLocationDrawable(context, 4);
            shareLocationDrawable.setColorFilter(new PorterDuffColorFilter(getThemedColor("location_sendLiveLocationIcon"), PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableCreateSimpleSelectorCircleDrawable, shareLocationDrawable);
            combinedDrawable.setCustomSize(AndroidUtilities.dp(42.0f), AndroidUtilities.dp(42.0f));
            this.imageView.setBackgroundDrawable(combinedDrawable);
            AndroidUtilities.runOnUIThread(this.invalidateRunnable, 1000L);
            setWillNotDraw(false);
        } else {
            Drawable drawable = getResources().getDrawable(R.drawable.pin);
            drawable.setColorFilter(new PorterDuffColorFilter(getThemedColor("location_sendLocationIcon"), PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable2 = new CombinedDrawable(drawableCreateSimpleSelectorCircleDrawable, drawable);
            combinedDrawable2.setCustomSize(AndroidUtilities.dp(42.0f), AndroidUtilities.dp(42.0f));
            combinedDrawable2.setIconSize(AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f));
            this.imageView.setBackgroundDrawable(combinedDrawable2);
        }
        ImageView imageView2 = this.imageView;
        boolean z = LocaleController.isRTL;
        addView(imageView2, LayoutHelper.createFrame(42, 42.0f, (z ? 5 : 3) | 48, z ? 0.0f : 15.0f, 12.0f, z ? 15.0f : 0.0f, 0.0f));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.titleTextView = simpleTextView;
        simpleTextView.setTextSize(16);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.titleTextView.setTag(live ? "location_sendLiveLocationText" : "location_sendLocationText");
        this.titleTextView.setTextColor(getThemedColor(live ? "location_sendLiveLocationText" : "location_sendLocationText"));
        this.titleTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        SimpleTextView simpleTextView2 = this.titleTextView;
        boolean z2 = LocaleController.isRTL;
        addView(simpleTextView2, LayoutHelper.createFrame(-1, 24.0f, (z2 ? 5 : 3) | 48, z2 ? 16.0f : 73.0f, 8.0f, z2 ? 73.0f : 16.0f, 0.0f));
        SimpleTextView simpleTextView3 = new SimpleTextView(context);
        this.accurateTextView = simpleTextView3;
        simpleTextView3.setTextSize(14);
        this.accurateTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.accurateTextView.setTextColor(getThemedColor("windowBackgroundWhiteGrayText3"));
        this.accurateTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        SimpleTextView simpleTextView4 = this.accurateTextView;
        boolean z3 = LocaleController.isRTL;
        addView(simpleTextView4, LayoutHelper.createFrame(-1, 20.0f, (z3 ? 5 : 3) | 48, z3 ? 16.0f : 73.0f, 37.0f, z3 ? 73.0f : 16.0f, 0.0f));
    }

    private ImageView getImageView() {
        return this.imageView;
    }

    public void setHasLocation(boolean value) {
        if (LocationController.getInstance(this.currentAccount).getSharingLocationInfo(this.dialogId) == null) {
            this.titleTextView.setAlpha(value ? 1.0f : 0.5f);
            this.accurateTextView.setAlpha(value ? 1.0f : 0.5f);
            this.imageView.setAlpha(value ? 1.0f : 0.5f);
        }
        checkText();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(66.0f), 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AndroidUtilities.cancelRunOnUIThread(this.invalidateRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.rect != null) {
            AndroidUtilities.runOnUIThread(this.invalidateRunnable, 1000L);
        }
    }

    public void setText(String title, String text) {
        this.titleTextView.setText(title);
        this.accurateTextView.setText(text);
    }

    public void setDialogId(long did) {
        this.dialogId = did;
        checkText();
    }

    private void checkText() {
        LocationController.SharingLocationInfo sharingLocationInfo = LocationController.getInstance(this.currentAccount).getSharingLocationInfo(this.dialogId);
        if (sharingLocationInfo != null) {
            String string = LocaleController.getString("StopLiveLocation", R.string.StopLiveLocation);
            int i = sharingLocationInfo.messageObject.messageOwner.edit_date;
            setText(string, LocaleController.formatLocationUpdateDate(i != 0 ? i : r0.date));
            return;
        }
        setText(LocaleController.getString("SendLiveLocation", R.string.SendLiveLocation), LocaleController.getString("SendLiveLocationInfo", R.string.SendLiveLocationInfo));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int currentTime;
        int i;
        LocationController.SharingLocationInfo sharingLocationInfo = LocationController.getInstance(this.currentAccount).getSharingLocationInfo(this.dialogId);
        if (sharingLocationInfo != null && (i = sharingLocationInfo.stopTime) >= (currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime())) {
            float fAbs = Math.abs(i - currentTime) / sharingLocationInfo.period;
            if (LocaleController.isRTL) {
                this.rect.set(AndroidUtilities.dp(13.0f), AndroidUtilities.dp(18.0f), AndroidUtilities.dp(43.0f), AndroidUtilities.dp(48.0f));
            } else {
                this.rect.set(getMeasuredWidth() - AndroidUtilities.dp(43.0f), AndroidUtilities.dp(18.0f), getMeasuredWidth() - AndroidUtilities.dp(13.0f), AndroidUtilities.dp(48.0f));
            }
            int themedColor = getThemedColor("location_liveLocationProgress");
            Theme.chat_radialProgress2Paint.setColor(themedColor);
            Theme.chat_livePaint.setColor(themedColor);
            canvas.drawArc(this.rect, -90.0f, fAbs * (-360.0f), false, Theme.chat_radialProgress2Paint);
            String locationLeftTime = LocaleController.formatLocationLeftTime(Math.abs(sharingLocationInfo.stopTime - currentTime));
            canvas.drawText(locationLeftTime, this.rect.centerX() - (Theme.chat_livePaint.measureText(locationLeftTime) / 2.0f), AndroidUtilities.dp(37.0f), Theme.chat_livePaint);
        }
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
