package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class PhotoPickerAlbumsCell extends FrameLayout {
    private MediaController.AlbumEntry[] albumEntries;
    private AlbumView[] albumViews;
    private int albumsCount;
    private Paint backgroundPaint;
    private PhotoPickerAlbumsCellDelegate delegate;

    public interface PhotoPickerAlbumsCellDelegate {
        void didSelectAlbum(MediaController.AlbumEntry albumEntry);
    }

    private class AlbumView extends FrameLayout {
        private TextView countTextView;
        private BackupImageView imageView;
        private TextView nameTextView;
        private View selector;

        public AlbumView(Context context) {
            super(context);
            BackupImageView backupImageView = new BackupImageView(context);
            this.imageView = backupImageView;
            addView(backupImageView, LayoutHelper.createFrame(-1, -1.0f));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setBackgroundResource(R.drawable.album_shadow);
            addView(linearLayout, LayoutHelper.createFrame(-1, 60, 83));
            TextView textView = new TextView(context);
            this.nameTextView = textView;
            textView.setTextSize(1, 13.0f);
            this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.nameTextView.setTextColor(-1);
            this.nameTextView.setSingleLine(true);
            this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.nameTextView.setMaxLines(1);
            this.nameTextView.setGravity(80);
            linearLayout.addView(this.nameTextView, LayoutHelper.createLinear(0, -1, 1.0f, 8, 0, 0, 5));
            TextView textView2 = new TextView(context);
            this.countTextView = textView2;
            textView2.setTextSize(1, 13.0f);
            this.countTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.countTextView.setTextColor(-1);
            this.countTextView.setSingleLine(true);
            this.countTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.countTextView.setMaxLines(1);
            this.countTextView.setGravity(80);
            linearLayout.addView(this.countTextView, LayoutHelper.createLinear(-2, -1, 4.0f, 0.0f, 7.0f, 5.0f));
            View view = new View(context);
            this.selector = view;
            view.setBackgroundDrawable(Theme.getSelectorDrawable(false));
            addView(this.selector, LayoutHelper.createFrame(-1, -1.0f));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.selector.drawableHotspotChanged(event.getX(), event.getY());
            }
            return super.onTouchEvent(event);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.imageView.getImageReceiver().hasNotThumb() && this.imageView.getImageReceiver().getCurrentAlpha() == 1.0f) {
                return;
            }
            PhotoPickerAlbumsCell.this.backgroundPaint.setColor(Theme.getColor("chat_attachPhotoBackground"));
            canvas.drawRect(0.0f, 0.0f, this.imageView.getMeasuredWidth(), this.imageView.getMeasuredHeight(), PhotoPickerAlbumsCell.this.backgroundPaint);
        }
    }

    public PhotoPickerAlbumsCell(Context context) {
        super(context);
        this.backgroundPaint = new Paint();
        this.albumEntries = new MediaController.AlbumEntry[4];
        this.albumViews = new AlbumView[4];
        for (int i = 0; i < 4; i++) {
            this.albumViews[i] = new AlbumView(context);
            addView(this.albumViews[i]);
            this.albumViews[i].setVisibility(4);
            this.albumViews[i].setTag(Integer.valueOf(i));
            this.albumViews[i].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$PhotoPickerAlbumsCell$o-k30mFJkCMrwxLNGXoNXi2gTho
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$PhotoPickerAlbumsCell(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$PhotoPickerAlbumsCell(View view) {
        PhotoPickerAlbumsCellDelegate photoPickerAlbumsCellDelegate = this.delegate;
        if (photoPickerAlbumsCellDelegate != null) {
            photoPickerAlbumsCellDelegate.didSelectAlbum(this.albumEntries[((Integer) view.getTag()).intValue()]);
        }
    }

    public void setAlbumsCount(int count) {
        int i = 0;
        while (true) {
            AlbumView[] albumViewArr = this.albumViews;
            if (i < albumViewArr.length) {
                albumViewArr[i].setVisibility(i < count ? 0 : 4);
                i++;
            } else {
                this.albumsCount = count;
                return;
            }
        }
    }

    public void setDelegate(PhotoPickerAlbumsCellDelegate delegate) {
        this.delegate = delegate;
    }

    public void setAlbum(int a, MediaController.AlbumEntry albumEntry) {
        this.albumEntries[a] = albumEntry;
        if (albumEntry != null) {
            AlbumView albumView = this.albumViews[a];
            albumView.imageView.setOrientation(0, true);
            MediaController.PhotoEntry photoEntry = albumEntry.coverPhoto;
            if (photoEntry == null || photoEntry.path == null) {
                albumView.imageView.setImageDrawable(Theme.chat_attachEmptyDrawable);
            } else {
                albumView.imageView.setOrientation(albumEntry.coverPhoto.orientation, true);
                if (albumEntry.coverPhoto.isVideo) {
                    albumView.imageView.setImage("vthumb://" + albumEntry.coverPhoto.imageId + ":" + albumEntry.coverPhoto.path, null, Theme.chat_attachEmptyDrawable);
                } else {
                    albumView.imageView.setImage("thumb://" + albumEntry.coverPhoto.imageId + ":" + albumEntry.coverPhoto.path, null, Theme.chat_attachEmptyDrawable);
                }
            }
            albumView.nameTextView.setText(albumEntry.bucketName);
            albumView.countTextView.setText(String.format("%d", Integer.valueOf(albumEntry.photos.size())));
            return;
        }
        this.albumViews[a].setVisibility(4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iDp;
        if (AndroidUtilities.isTablet()) {
            iDp = ((AndroidUtilities.dp(490.0f) - AndroidUtilities.dp(12.0f)) - ((this.albumsCount - 1) * AndroidUtilities.dp(4.0f))) / this.albumsCount;
        } else {
            iDp = ((AndroidUtilities.displaySize.x - AndroidUtilities.dp(12.0f)) - ((this.albumsCount - 1) * AndroidUtilities.dp(4.0f))) / this.albumsCount;
        }
        for (int i = 0; i < this.albumsCount; i++) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.albumViews[i].getLayoutParams();
            layoutParams.topMargin = AndroidUtilities.dp(4.0f);
            layoutParams.leftMargin = (AndroidUtilities.dp(4.0f) + iDp) * i;
            layoutParams.width = iDp;
            layoutParams.height = iDp;
            layoutParams.gravity = 51;
            this.albumViews[i].setLayoutParams(layoutParams);
        }
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(4.0f) + iDp, 1073741824));
    }
}
