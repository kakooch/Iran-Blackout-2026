package ir.eitaa.ui.Components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.SecureDocument;
import ir.eitaa.tgnet.TLObject;

/* loaded from: classes3.dex */
public class BackupImageView extends View {
    protected int height;
    protected ImageReceiver imageReceiver;
    protected int width;

    public BackupImageView(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
        this.imageReceiver = new ImageReceiver(this);
    }

    public void setOrientation(int angle, boolean center) {
        this.imageReceiver.setOrientation(angle, center);
    }

    public void setImage(SecureDocument secureDocument, String filter) {
        setImage(ImageLocation.getForSecureDocument(secureDocument), filter, null, null, null, null, null, 0, null);
    }

    public void setImage(ImageLocation imageLocation, String imageFilter, String ext, Drawable thumb, Object parentObject) {
        setImage(imageLocation, imageFilter, null, null, thumb, null, ext, 0, parentObject);
    }

    public void setImage(ImageLocation imageLocation, String imageFilter, Drawable thumb, Object parentObject) {
        setImage(imageLocation, imageFilter, null, null, thumb, null, null, 0, parentObject);
    }

    public void setImage(ImageLocation mediaLocation, String mediaFilter, ImageLocation imageLocation, String imageFilter, Drawable thumb, Object parentObject) {
        this.imageReceiver.setImage(mediaLocation, mediaFilter, imageLocation, imageFilter, null, null, thumb, 0, null, parentObject, 1);
    }

    public void setImage(ImageLocation imageLocation, String imageFilter, Drawable thumb, int size, Object parentObject) {
        setImage(imageLocation, imageFilter, null, null, thumb, null, null, size, parentObject);
    }

    public void setForUserOrChat(TLObject object, AvatarDrawable avatarDrawable) {
        this.imageReceiver.setForUserOrChat(object, avatarDrawable);
    }

    public void setForUserOrChat(TLObject object, AvatarDrawable avatarDrawable, Object parent) {
        this.imageReceiver.setForUserOrChat(object, avatarDrawable, parent);
    }

    public void setImageMedia(ImageLocation mediaLocation, String mediaFilter, ImageLocation imageLocation, String imageFilter, Bitmap thumbBitmap, int size, int cacheType, Object parentObject) {
        BackupImageView backupImageView;
        BitmapDrawable bitmapDrawable;
        if (thumbBitmap != null) {
            backupImageView = this;
            bitmapDrawable = new BitmapDrawable((Resources) null, thumbBitmap);
        } else {
            backupImageView = this;
            bitmapDrawable = null;
        }
        backupImageView.imageReceiver.setImage(mediaLocation, mediaFilter, imageLocation, imageFilter, null, null, bitmapDrawable, size, null, parentObject, cacheType);
    }

    public void setImage(ImageLocation imageLocation, String imageFilter, ImageLocation thumbLocation, String thumbFilter, int size, Object parentObject) {
        setImage(imageLocation, imageFilter, thumbLocation, thumbFilter, null, null, null, size, parentObject);
    }

    public void setImage(String path, String filter, Drawable thumb) {
        setImage(ImageLocation.getForPath(path), filter, null, null, thumb, null, null, 0, null);
    }

    public void setImage(String path, String filter, String thumbPath, String thumbFilter) {
        setImage(ImageLocation.getForPath(path), filter, ImageLocation.getForPath(thumbPath), thumbFilter, null, null, null, 0, null);
    }

    public void setImage(ImageLocation imageLocation, String imageFilter, ImageLocation thumbLocation, String thumbFilter, Drawable thumb, Bitmap thumbBitmap, String ext, int size, Object parentObject) {
        BackupImageView backupImageView;
        Drawable bitmapDrawable;
        if (thumbBitmap != null) {
            backupImageView = this;
            bitmapDrawable = new BitmapDrawable((Resources) null, thumbBitmap);
        } else {
            backupImageView = this;
            bitmapDrawable = thumb;
        }
        backupImageView.imageReceiver.setImage(imageLocation, imageFilter, thumbLocation, thumbFilter, bitmapDrawable, size, ext, parentObject, 0);
    }

    public void setImage(ImageLocation imageLocation, String imageFilter, ImageLocation thumbLocation, String thumbFilter, String ext, int size, int cacheType, Object parentObject) {
        this.imageReceiver.setImage(imageLocation, imageFilter, thumbLocation, thumbFilter, null, size, ext, parentObject, cacheType);
    }

    public void setImageMedia(ImageLocation mediaLocation, String mediaFilter, ImageLocation imageLocation, String imageFilter, ImageLocation thumbLocation, String thumbFilter, String ext, int size, int cacheType, Object parentObject) {
        this.imageReceiver.setImage(mediaLocation, mediaFilter, imageLocation, imageFilter, thumbLocation, thumbFilter, null, size, ext, parentObject, cacheType);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.imageReceiver.setImageBitmap(bitmap);
    }

    public void setImageResource(int resId) {
        this.imageReceiver.setImageBitmap(getResources().getDrawable(resId));
        invalidate();
    }

    public void setImageResource(int resId, int color) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(resId);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        }
        this.imageReceiver.setImageBitmap(drawable);
        invalidate();
    }

    public void setImageDrawable(Drawable drawable) {
        this.imageReceiver.setImageBitmap(drawable);
    }

    public void setLayerNum(int value) {
        this.imageReceiver.setLayerNum(value);
    }

    public void setRoundRadius(int value) {
        this.imageReceiver.setRoundRadius(value);
        invalidate();
    }

    public void setRoundRadius(int tl, int tr, int bl, int br) {
        this.imageReceiver.setRoundRadius(tl, tr, bl, br);
        invalidate();
    }

    public int[] getRoundRadius() {
        return this.imageReceiver.getRoundRadius();
    }

    public void setAspectFit(boolean value) {
        this.imageReceiver.setAspectFit(value);
    }

    public ImageReceiver getImageReceiver() {
        return this.imageReceiver;
    }

    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.imageReceiver.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.imageReceiver.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.width != -1 && this.height != -1) {
            ImageReceiver imageReceiver = this.imageReceiver;
            float width = (getWidth() - this.width) / 2;
            int height = getHeight();
            imageReceiver.setImageCoords(width, (height - r3) / 2, this.width, this.height);
        } else {
            this.imageReceiver.setImageCoords(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.imageReceiver.draw(canvas);
    }
}
