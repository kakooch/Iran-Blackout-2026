package ir.eitaa.messenger;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.Keep;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RecyclableDrawable;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class ImageReceiver implements NotificationCenter.NotificationCenterDelegate {
    public static final int DEFAULT_CROSSFADE_DURATION = 150;
    private static final int TYPE_CROSSFDADE = 2;
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_MEDIA = 3;
    public static final int TYPE_THUMB = 1;
    private boolean allowDecodeSingleFrame;
    private boolean allowStartAnimation;
    private boolean allowStartLottieAnimation;
    private int animateFromIsPressed;
    private boolean animationReadySent;
    private int autoRepeat;
    private RectF bitmapRect;
    private Object blendMode;
    private boolean canceledLoading;
    private boolean centerRotation;
    private ColorFilter colorFilter;
    private ComposeShader composeShader;
    private byte crossfadeAlpha;
    private int crossfadeDuration;
    private Drawable crossfadeImage;
    private String crossfadeKey;
    private BitmapShader crossfadeShader;
    private boolean crossfadeWithOldImage;
    private boolean crossfadeWithThumb;
    private boolean crossfadingWithThumb;
    private int currentAccount;
    private float currentAlpha;
    private int currentCacheType;
    private String currentExt;
    private int currentGuid;
    private Drawable currentImageDrawable;
    private String currentImageFilter;
    private String currentImageKey;
    private ImageLocation currentImageLocation;
    private boolean currentKeyQuality;
    private int currentLayerNum;
    private Drawable currentMediaDrawable;
    private String currentMediaFilter;
    private String currentMediaKey;
    private ImageLocation currentMediaLocation;
    private int currentOpenedLayerFlags;
    private Object currentParentObject;
    private int currentSize;
    private Drawable currentThumbDrawable;
    private String currentThumbFilter;
    private String currentThumbKey;
    private ImageLocation currentThumbLocation;
    private ImageReceiverDelegate delegate;
    private RectF drawRegion;
    private long endTime;
    private boolean forceCrossfade;
    private boolean forceLoding;
    private boolean forcePreview;
    private Bitmap gradientBitmap;
    private BitmapShader gradientShader;
    private boolean ignoreImageSet;
    private float imageH;
    private int imageOrientation;
    private BitmapShader imageShader;
    private int imageTag;
    private float imageW;
    private float imageX;
    private float imageY;
    private boolean invalidateAll;
    private boolean isAspectFit;
    private int isPressed;
    private boolean isRoundRect;
    private boolean isRoundVideo;
    private boolean isVisible;
    private long lastUpdateAlphaTime;
    private Bitmap legacyBitmap;
    private Canvas legacyCanvas;
    private Paint legacyPaint;
    private BitmapShader legacyShader;
    private boolean manualAlphaAnimator;
    private BitmapShader mediaShader;
    private int mediaTag;
    private boolean needsQualityThumb;
    private float overrideAlpha;
    private int param;
    private View parentView;
    private float pressedProgress;
    private TLRPC$Document qulityThumbDocument;
    private Paint roundPaint;
    private Path roundPath;
    private int[] roundRadius;
    private RectF roundRect;
    private SetImageBackup setImageBackup;
    private Matrix shaderMatrix;
    private boolean shouldGenerateQualityThumb;
    private float sideClip;
    private long startTime;
    private Drawable staticThumbDrawable;
    private ImageLocation strippedLocation;
    private int thumbOrientation;
    private BitmapShader thumbShader;
    private int thumbTag;
    private String uniqKeyPrefix;
    private boolean useRoundForThumb;
    private boolean useSharedAnimationQueue;
    private static PorterDuffColorFilter selectedColorFilter = new PorterDuffColorFilter(-2236963, PorterDuff.Mode.MULTIPLY);
    private static PorterDuffColorFilter selectedGroupColorFilter = new PorterDuffColorFilter(-4473925, PorterDuff.Mode.MULTIPLY);
    private static float[] radii = new float[8];

    public interface ImageReceiverDelegate {

        /* renamed from: ir.eitaa.messenger.ImageReceiver$ImageReceiverDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onAnimationReady(ImageReceiverDelegate imageReceiverDelegate, ImageReceiver imageReceiver) {
            }
        }

        void didSetImage(ImageReceiver imageReceiver, boolean set, boolean thumb, boolean memCache);

        void onAnimationReady(ImageReceiver imageReceiver);
    }

    private boolean hasRoundRadius() {
        return true;
    }

    public static class BitmapHolder {
        public Bitmap bitmap;
        public Drawable drawable;
        private String key;
        public int orientation;
        private boolean recycleOnRelease;

        public BitmapHolder(Bitmap b, String k, int o) {
            this.bitmap = b;
            this.key = k;
            this.orientation = o;
            if (k != null) {
                ImageLoader.getInstance().incrementUseCount(this.key);
            }
        }

        public BitmapHolder(Drawable d, String k, int o) {
            this.drawable = d;
            this.key = k;
            this.orientation = o;
            if (k != null) {
                ImageLoader.getInstance().incrementUseCount(this.key);
            }
        }

        public BitmapHolder(Bitmap b) {
            this.bitmap = b;
            this.recycleOnRelease = true;
        }

        public int getWidth() {
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                return bitmap.getWidth();
            }
            return 0;
        }

        public int getHeight() {
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                return bitmap.getHeight();
            }
            return 0;
        }

        public boolean isRecycled() {
            Bitmap bitmap = this.bitmap;
            return bitmap == null || bitmap.isRecycled();
        }

        public void release() {
            Bitmap bitmap;
            if (this.key == null) {
                if (this.recycleOnRelease && (bitmap = this.bitmap) != null) {
                    bitmap.recycle();
                }
                this.bitmap = null;
                this.drawable = null;
                return;
            }
            boolean zDecrementUseCount = ImageLoader.getInstance().decrementUseCount(this.key);
            if (!ImageLoader.getInstance().isInMemCache(this.key, false) && zDecrementUseCount) {
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                } else {
                    Drawable drawable = this.drawable;
                    if (drawable != null) {
                        if (drawable instanceof RLottieDrawable) {
                            ((RLottieDrawable) drawable).recycle();
                        } else if (drawable instanceof AnimatedFileDrawable) {
                            ((AnimatedFileDrawable) drawable).recycle();
                        } else if (drawable instanceof BitmapDrawable) {
                            ((BitmapDrawable) drawable).getBitmap().recycle();
                        }
                    }
                }
            }
            this.key = null;
            this.bitmap = null;
            this.drawable = null;
        }
    }

    private static class SetImageBackup {
        public int cacheType;
        public String ext;
        public String imageFilter;
        public ImageLocation imageLocation;
        public String mediaFilter;
        public ImageLocation mediaLocation;
        public Object parentObject;
        public int size;
        public Drawable thumb;
        public String thumbFilter;
        public ImageLocation thumbLocation;

        private SetImageBackup() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isSet() {
            return (this.imageLocation == null && this.thumbLocation == null && this.mediaLocation == null && this.thumb == null) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isWebfileSet() {
            ImageLocation imageLocation;
            ImageLocation imageLocation2;
            ImageLocation imageLocation3 = this.imageLocation;
            return ((imageLocation3 == null || (imageLocation3.webFile == null && imageLocation3.path == null)) && ((imageLocation = this.thumbLocation) == null || (imageLocation.webFile == null && imageLocation.path == null)) && ((imageLocation2 = this.mediaLocation) == null || (imageLocation2.webFile == null && imageLocation2.path == null))) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.imageLocation = null;
            this.thumbLocation = null;
            this.mediaLocation = null;
            this.thumb = null;
        }
    }

    public ImageReceiver() {
        this(null);
    }

    public ImageReceiver(View view) {
        this.allowStartAnimation = true;
        this.allowStartLottieAnimation = true;
        this.autoRepeat = 1;
        this.drawRegion = new RectF();
        this.isVisible = true;
        this.roundRadius = new int[4];
        this.roundRect = new RectF();
        this.bitmapRect = new RectF();
        this.shaderMatrix = new Matrix();
        this.roundPath = new Path();
        this.overrideAlpha = 1.0f;
        this.crossfadeAlpha = (byte) 1;
        this.crossfadeDuration = DEFAULT_CROSSFADE_DURATION;
        this.parentView = view;
        this.roundPaint = new Paint(3);
        this.currentAccount = UserConfig.selectedAccount;
    }

    public void cancelLoadImage() {
        this.forceLoding = false;
        ImageLoader.getInstance().cancelLoadingForImageReceiver(this, true);
        this.canceledLoading = true;
    }

    public void setForceLoading(boolean value) {
        this.forceLoding = value;
    }

    public boolean isForceLoding() {
        return this.forceLoding;
    }

    public void setStrippedLocation(ImageLocation location) {
        this.strippedLocation = location;
    }

    public void setIgnoreImageSet(boolean value) {
        this.ignoreImageSet = value;
    }

    public ImageLocation getStrippedLocation() {
        return this.strippedLocation;
    }

    public void setImage(ImageLocation imageLocation, String imageFilter, Drawable thumb, String ext, Object parentObject, int cacheType) {
        setImage(imageLocation, imageFilter, null, null, thumb, 0, ext, parentObject, cacheType);
    }

    public void setImage(ImageLocation imageLocation, String imageFilter, Drawable thumb, int size, String ext, Object parentObject, int cacheType) {
        setImage(imageLocation, imageFilter, null, null, thumb, size, ext, parentObject, cacheType);
    }

    public void setImage(String imagePath, String imageFilter, Drawable thumb, String ext, int size) {
        setImage(ImageLocation.getForPath(imagePath), imageFilter, null, null, thumb, size, ext, null, 1);
    }

    public void setImage(TLRPC$PhotoSize photoSize, String imageFilter, Drawable thumb, String ext, int size) {
        setImage(ImageLocation.getForObject(photoSize, photoSize.location), imageFilter, null, null, thumb, size, ext, null, 1);
    }

    public void setImage(ImageLocation imageLocation, String imageFilter, ImageLocation thumbLocation, String thumbFilter, String ext, Object parentObject, int cacheType) {
        setImage(imageLocation, imageFilter, thumbLocation, thumbFilter, null, 0, ext, parentObject, cacheType);
    }

    public void setImage(ImageLocation imageLocation, String imageFilter, ImageLocation thumbLocation, String thumbFilter, int size, String ext, Object parentObject, int cacheType) {
        setImage(imageLocation, imageFilter, thumbLocation, thumbFilter, null, size, ext, parentObject, cacheType);
    }

    public void setForUserOrChat(TLObject object, Drawable avatarDrawable) {
        setForUserOrChat(object, avatarDrawable, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a A[PHI: r1
      0x001a: PHI (r1v9 android.graphics.drawable.BitmapDrawable) = (r1v2 android.graphics.drawable.BitmapDrawable), (r1v10 android.graphics.drawable.BitmapDrawable) binds: [B:17:0x002e, B:9:0x0018] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setForUserOrChat(ir.eitaa.tgnet.TLObject r10, android.graphics.drawable.Drawable r11, java.lang.Object r12) {
        /*
            r9 = this;
            if (r12 != 0) goto L3
            r12 = r10
        L3:
            r0 = 1
            r9.setUseRoundForThumbDrawable(r0)
            r1 = 0
            boolean r2 = r10 instanceof ir.eitaa.tgnet.TLRPC$User
            r3 = 0
            if (r2 == 0) goto L1f
            r2 = r10
            ir.eitaa.tgnet.TLRPC$User r2 = (ir.eitaa.tgnet.TLRPC$User) r2
            ir.eitaa.tgnet.TLRPC$UserProfilePhoto r2 = r2.photo
            if (r2 == 0) goto L1b
            android.graphics.drawable.BitmapDrawable r1 = r2.strippedBitmap
            byte[] r2 = r2.stripped_thumb
            if (r2 == 0) goto L1b
        L1a:
            r3 = 1
        L1b:
            r8 = r3
            r3 = r1
            r1 = r8
            goto L33
        L1f:
            boolean r2 = r10 instanceof ir.eitaa.tgnet.TLRPC$Chat
            if (r2 == 0) goto L31
            r2 = r10
            ir.eitaa.tgnet.TLRPC$Chat r2 = (ir.eitaa.tgnet.TLRPC$Chat) r2
            ir.eitaa.tgnet.TLRPC$ChatPhoto r2 = r2.photo
            if (r2 == 0) goto L31
            android.graphics.drawable.BitmapDrawable r1 = r2.strippedBitmap
            byte[] r2 = r2.stripped_thumb
            if (r2 == 0) goto L1b
            goto L1a
        L31:
            r3 = r1
            r1 = 0
        L33:
            if (r3 == 0) goto L43
            ir.eitaa.messenger.ImageLocation r1 = ir.eitaa.messenger.ImageLocation.getForUserOrChat(r10, r0)
            r4 = 0
            r6 = 0
            java.lang.String r2 = "50_50"
            r0 = r9
            r5 = r12
            r0.setImage(r1, r2, r3, r4, r5, r6)
            goto L68
        L43:
            if (r1 == 0) goto L5a
            ir.eitaa.messenger.ImageLocation r1 = ir.eitaa.messenger.ImageLocation.getForUserOrChat(r10, r0)
            r0 = 2
            ir.eitaa.messenger.ImageLocation r3 = ir.eitaa.messenger.ImageLocation.getForUserOrChat(r10, r0)
            r7 = 0
            java.lang.String r2 = "50_50"
            java.lang.String r4 = "50_50"
            r0 = r9
            r5 = r11
            r6 = r12
            r0.setImage(r1, r2, r3, r4, r5, r6, r7)
            goto L68
        L5a:
            ir.eitaa.messenger.ImageLocation r1 = ir.eitaa.messenger.ImageLocation.getForUserOrChat(r10, r0)
            r4 = 0
            r6 = 0
            java.lang.String r2 = "50_50"
            r0 = r9
            r3 = r11
            r5 = r12
            r0.setImage(r1, r2, r3, r4, r5, r6)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageReceiver.setForUserOrChat(ir.eitaa.tgnet.TLObject, android.graphics.drawable.Drawable, java.lang.Object):void");
    }

    public void setImage(ImageLocation fileLocation, String fileFilter, ImageLocation thumbLocation, String thumbFilter, Drawable thumb, Object parentObject, int cacheType) {
        setImage(null, null, fileLocation, fileFilter, thumbLocation, thumbFilter, thumb, 0, null, parentObject, cacheType);
    }

    public void setImage(ImageLocation fileLocation, String fileFilter, ImageLocation thumbLocation, String thumbFilter, Drawable thumb, int size, String ext, Object parentObject, int cacheType) {
        setImage(null, null, fileLocation, fileFilter, thumbLocation, thumbFilter, thumb, size, ext, parentObject, cacheType);
    }

    public void setImage(ImageLocation mediaLocation, String mediaFilter, ImageLocation imageLocation, String imageFilter, ImageLocation thumbLocation, String thumbFilter, Drawable thumb, int size, String ext, Object parentObject, int cacheType) {
        String str;
        boolean z;
        boolean z2;
        Drawable drawable;
        boolean z3;
        boolean z4;
        String str2;
        SetImageBackup setImageBackup;
        ImageLocation imageLocation2 = mediaLocation;
        ImageLocation imageLocation3 = imageLocation;
        if (this.ignoreImageSet) {
            return;
        }
        if (this.crossfadeWithOldImage && (setImageBackup = this.setImageBackup) != null && setImageBackup.isWebfileSet()) {
            setBackupImage();
        }
        SetImageBackup setImageBackup2 = this.setImageBackup;
        if (setImageBackup2 != null) {
            setImageBackup2.clear();
        }
        if (imageLocation3 == null && thumbLocation == null && imageLocation2 == null) {
            for (int i = 0; i < 4; i++) {
                recycleBitmap(null, i);
            }
            this.currentImageLocation = null;
            this.currentImageFilter = null;
            this.currentImageKey = null;
            this.currentMediaLocation = null;
            this.currentMediaFilter = null;
            this.currentMediaKey = null;
            this.currentThumbLocation = null;
            this.currentThumbFilter = null;
            this.currentThumbKey = null;
            this.currentMediaDrawable = null;
            this.mediaShader = null;
            this.currentImageDrawable = null;
            this.imageShader = null;
            this.composeShader = null;
            this.thumbShader = null;
            this.crossfadeShader = null;
            this.legacyShader = null;
            this.legacyCanvas = null;
            Bitmap bitmap = this.legacyBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.legacyBitmap = null;
            }
            this.currentExt = ext;
            this.currentParentObject = null;
            this.currentCacheType = 0;
            this.staticThumbDrawable = thumb;
            this.currentAlpha = 1.0f;
            this.currentSize = 0;
            if (thumb instanceof SvgHelper.SvgDrawable) {
                ((SvgHelper.SvgDrawable) thumb).setParent(this);
            }
            ImageLoader.getInstance().cancelLoadingForImageReceiver(this, true);
            View view = this.parentView;
            if (view != null) {
                if (this.invalidateAll) {
                    view.invalidate();
                } else {
                    float f = this.imageX;
                    float f2 = this.imageY;
                    view.invalidate((int) f, (int) f2, (int) (f + this.imageW), (int) (f2 + this.imageH));
                }
            }
            ImageReceiverDelegate imageReceiverDelegate = this.delegate;
            if (imageReceiverDelegate != null) {
                Drawable drawable2 = this.currentImageDrawable;
                imageReceiverDelegate.didSetImage(this, (drawable2 == null && this.currentThumbDrawable == null && this.staticThumbDrawable == null && this.currentMediaDrawable == null) ? false : true, drawable2 == null && this.currentMediaDrawable == null, false);
                return;
            }
            return;
        }
        String key = imageLocation3 != null ? imageLocation3.getKey(parentObject, null, false) : null;
        if (key == null && imageLocation3 != null) {
            imageLocation3 = null;
        }
        this.currentKeyQuality = false;
        if (key == null && this.needsQualityThumb && ((parentObject instanceof MessageObject) || this.qulityThumbDocument != null)) {
            TLRPC$Document document = this.qulityThumbDocument;
            if (document == null) {
                document = ((MessageObject) parentObject).getDocument();
            }
            if (document != null && document.dc_id != 0 && document.id != 0) {
                key = "q_" + document.dc_id + "_" + document.id;
                this.currentKeyQuality = true;
            }
        }
        if (key != null && imageFilter != null) {
            key = key + "@" + imageFilter;
        }
        if (this.uniqKeyPrefix != null) {
            key = this.uniqKeyPrefix + key;
        }
        String key2 = imageLocation2 != null ? imageLocation2.getKey(parentObject, null, false) : null;
        if (key2 == null && imageLocation2 != null) {
            imageLocation2 = null;
        }
        if (key2 != null && mediaFilter != null) {
            key2 = key2 + "@" + mediaFilter;
        }
        if ((key2 == null && (str2 = this.currentImageKey) != null && str2.equals(key)) || ((str = this.currentMediaKey) != null && str.equals(key2))) {
            ImageReceiverDelegate imageReceiverDelegate2 = this.delegate;
            if (imageReceiverDelegate2 != null) {
                Drawable drawable3 = this.currentImageDrawable;
                boolean z5 = (drawable3 == null && this.currentThumbDrawable == null && this.staticThumbDrawable == null && this.currentMediaDrawable == null) ? false : true;
                if (drawable3 == null && this.currentMediaDrawable == null) {
                    z3 = false;
                    z4 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
                imageReceiverDelegate2.didSetImage(this, z5, z4, z3);
            }
            if (!this.canceledLoading) {
                return;
            }
        }
        ImageLocation imageLocation4 = this.strippedLocation;
        if (imageLocation4 == null) {
            imageLocation4 = imageLocation2 != null ? imageLocation2 : imageLocation3;
        }
        if (imageLocation4 == null) {
            imageLocation4 = thumbLocation;
        }
        String key3 = thumbLocation != null ? thumbLocation.getKey(parentObject, imageLocation4, false) : null;
        if (key3 != null && thumbFilter != null) {
            key3 = key3 + "@" + thumbFilter;
        }
        if (this.crossfadeWithOldImage) {
            Drawable drawable4 = this.currentMediaDrawable;
            if (drawable4 != null) {
                if (drawable4 instanceof AnimatedFileDrawable) {
                    ((AnimatedFileDrawable) drawable4).stop();
                }
                recycleBitmap(key3, 1);
                recycleBitmap(null, 2);
                recycleBitmap(key2, 0);
                this.crossfadeImage = this.currentMediaDrawable;
                this.crossfadeShader = this.mediaShader;
                this.crossfadeKey = this.currentImageKey;
                this.crossfadingWithThumb = false;
                this.currentMediaDrawable = null;
                this.currentMediaKey = null;
            } else if (this.currentImageDrawable != null) {
                recycleBitmap(key3, 1);
                recycleBitmap(null, 2);
                recycleBitmap(key2, 3);
                this.crossfadeShader = this.imageShader;
                this.crossfadeImage = this.currentImageDrawable;
                this.crossfadeKey = this.currentImageKey;
                this.crossfadingWithThumb = false;
                this.currentImageDrawable = null;
                this.currentImageKey = null;
            } else if (this.currentThumbDrawable != null) {
                recycleBitmap(key, 0);
                recycleBitmap(null, 2);
                recycleBitmap(key2, 3);
                this.crossfadeShader = this.thumbShader;
                this.crossfadeImage = this.currentThumbDrawable;
                this.crossfadeKey = this.currentThumbKey;
                this.crossfadingWithThumb = false;
                this.currentThumbDrawable = null;
                this.currentThumbKey = null;
            } else if (this.staticThumbDrawable != null) {
                recycleBitmap(key, 0);
                recycleBitmap(key3, 1);
                recycleBitmap(null, 2);
                recycleBitmap(key2, 3);
                this.crossfadeShader = this.thumbShader;
                this.crossfadeImage = this.staticThumbDrawable;
                this.crossfadingWithThumb = false;
                this.crossfadeKey = null;
                this.currentThumbDrawable = null;
                this.currentThumbKey = null;
            } else {
                recycleBitmap(key, 0);
                recycleBitmap(key3, 1);
                recycleBitmap(null, 2);
                recycleBitmap(key2, 3);
                this.crossfadeShader = null;
            }
        } else {
            recycleBitmap(key, 0);
            recycleBitmap(key3, 1);
            recycleBitmap(null, 2);
            recycleBitmap(key2, 3);
            this.crossfadeShader = null;
        }
        this.currentImageLocation = imageLocation3;
        this.currentImageFilter = imageFilter;
        this.currentImageKey = key;
        this.currentMediaLocation = imageLocation2;
        this.currentMediaFilter = mediaFilter;
        this.currentMediaKey = key2;
        this.currentThumbLocation = thumbLocation;
        this.currentThumbFilter = thumbFilter;
        this.currentThumbKey = key3;
        this.currentParentObject = parentObject;
        this.currentExt = ext;
        this.currentSize = size;
        this.currentCacheType = cacheType;
        this.staticThumbDrawable = thumb;
        this.imageShader = null;
        this.composeShader = null;
        this.thumbShader = null;
        this.mediaShader = null;
        this.legacyShader = null;
        this.legacyCanvas = null;
        Bitmap bitmap2 = this.legacyBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.legacyBitmap = null;
        }
        if (this.useRoundForThumb && (drawable = this.staticThumbDrawable) != null) {
            updateDrawableRadius(drawable);
        }
        this.currentAlpha = 1.0f;
        Drawable drawable5 = this.staticThumbDrawable;
        if (drawable5 instanceof SvgHelper.SvgDrawable) {
            ((SvgHelper.SvgDrawable) drawable5).setParent(this);
        }
        ImageReceiverDelegate imageReceiverDelegate3 = this.delegate;
        if (imageReceiverDelegate3 != null) {
            Drawable drawable6 = this.currentImageDrawable;
            boolean z6 = (drawable6 == null && this.currentThumbDrawable == null && this.staticThumbDrawable == null && this.currentMediaDrawable == null) ? false : true;
            if (drawable6 == null && this.currentMediaDrawable == null) {
                z = false;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            imageReceiverDelegate3.didSetImage(this, z6, z2, z);
        }
        ImageLoader.getInstance().loadImageForImageReceiver(this);
        View view2 = this.parentView;
        if (view2 != null) {
            if (this.invalidateAll) {
                view2.invalidate();
            } else {
                float f3 = this.imageX;
                float f4 = this.imageY;
                view2.invalidate((int) f3, (int) f4, (int) (f3 + this.imageW), (int) (f4 + this.imageH));
            }
        }
        this.isRoundVideo = (parentObject instanceof MessageObject) && ((MessageObject) parentObject).isRoundVideo();
    }

    public boolean canInvertBitmap() {
        return (this.currentMediaDrawable instanceof ExtendedBitmapDrawable) || (this.currentImageDrawable instanceof ExtendedBitmapDrawable) || (this.currentThumbDrawable instanceof ExtendedBitmapDrawable) || (this.staticThumbDrawable instanceof ExtendedBitmapDrawable);
    }

    public void setColorFilter(ColorFilter filter) {
        this.colorFilter = filter;
    }

    public void setDelegate(ImageReceiverDelegate delegate) {
        this.delegate = delegate;
    }

    public void setPressed(int value) {
        this.isPressed = value;
    }

    public boolean getPressed() {
        return this.isPressed != 0;
    }

    public void setOrientation(int angle, boolean center) {
        while (angle < 0) {
            angle += 360;
        }
        while (angle > 360) {
            angle -= 360;
        }
        this.thumbOrientation = angle;
        this.imageOrientation = angle;
        this.centerRotation = center;
    }

    public void setInvalidateAll(boolean value) {
        this.invalidateAll = value;
    }

    public Drawable getStaticThumb() {
        return this.staticThumbDrawable;
    }

    public int getAnimatedOrientation() {
        AnimatedFileDrawable animation = getAnimation();
        if (animation != null) {
            return animation.getOrientation();
        }
        return 0;
    }

    public int getOrientation() {
        return this.imageOrientation;
    }

    public void setLayerNum(int value) {
        this.currentLayerNum = value;
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap != null ? new BitmapDrawable((Resources) null, bitmap) : null);
    }

    public void setImageBitmap(Drawable bitmap) {
        boolean z = true;
        ImageLoader.getInstance().cancelLoadingForImageReceiver(this, true);
        if (!this.crossfadeWithOldImage) {
            for (int i = 0; i < 4; i++) {
                recycleBitmap(null, i);
            }
        } else if (this.currentImageDrawable != null) {
            recycleBitmap(null, 1);
            recycleBitmap(null, 2);
            recycleBitmap(null, 3);
            this.crossfadeShader = this.imageShader;
            this.crossfadeImage = this.currentImageDrawable;
            this.crossfadeKey = this.currentImageKey;
            this.crossfadingWithThumb = true;
        } else if (this.currentThumbDrawable != null) {
            recycleBitmap(null, 0);
            recycleBitmap(null, 2);
            recycleBitmap(null, 3);
            this.crossfadeShader = this.thumbShader;
            this.crossfadeImage = this.currentThumbDrawable;
            this.crossfadeKey = this.currentThumbKey;
            this.crossfadingWithThumb = true;
        } else if (this.staticThumbDrawable != null) {
            recycleBitmap(null, 0);
            recycleBitmap(null, 1);
            recycleBitmap(null, 2);
            recycleBitmap(null, 3);
            this.crossfadeShader = this.thumbShader;
            this.crossfadeImage = this.staticThumbDrawable;
            this.crossfadingWithThumb = true;
            this.crossfadeKey = null;
        } else {
            for (int i2 = 0; i2 < 4; i2++) {
                recycleBitmap(null, i2);
            }
            this.crossfadeShader = null;
        }
        Drawable drawable = this.staticThumbDrawable;
        if (drawable instanceof RecyclableDrawable) {
            ((RecyclableDrawable) drawable).recycle();
        }
        if (bitmap instanceof AnimatedFileDrawable) {
            AnimatedFileDrawable animatedFileDrawable = (AnimatedFileDrawable) bitmap;
            animatedFileDrawable.setParentView(this.parentView);
            animatedFileDrawable.setUseSharedQueue(this.useSharedAnimationQueue);
            if (this.allowStartAnimation && this.currentOpenedLayerFlags == 0) {
                animatedFileDrawable.start();
            }
            animatedFileDrawable.setAllowDecodeSingleFrame(this.allowDecodeSingleFrame);
        } else if (bitmap instanceof RLottieDrawable) {
            RLottieDrawable rLottieDrawable = (RLottieDrawable) bitmap;
            rLottieDrawable.addParentView(this.parentView);
            if (this.allowStartLottieAnimation && (!rLottieDrawable.isHeavyDrawable() || this.currentOpenedLayerFlags == 0)) {
                rLottieDrawable.start();
            }
            rLottieDrawable.setAllowDecodeSingleFrame(true);
        }
        this.staticThumbDrawable = bitmap;
        updateDrawableRadius(bitmap);
        this.currentMediaLocation = null;
        this.currentMediaFilter = null;
        this.currentMediaDrawable = null;
        this.currentMediaKey = null;
        this.mediaShader = null;
        this.currentImageLocation = null;
        this.currentImageFilter = null;
        this.currentImageDrawable = null;
        this.currentImageKey = null;
        this.imageShader = null;
        this.composeShader = null;
        this.legacyShader = null;
        this.legacyCanvas = null;
        Bitmap bitmap2 = this.legacyBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.legacyBitmap = null;
        }
        this.currentThumbLocation = null;
        this.currentThumbFilter = null;
        this.currentThumbKey = null;
        this.currentKeyQuality = false;
        this.currentExt = null;
        this.currentSize = 0;
        this.currentCacheType = 0;
        this.currentAlpha = 1.0f;
        SetImageBackup setImageBackup = this.setImageBackup;
        if (setImageBackup != null) {
            setImageBackup.clear();
        }
        ImageReceiverDelegate imageReceiverDelegate = this.delegate;
        if (imageReceiverDelegate != null) {
            imageReceiverDelegate.didSetImage(this, (this.currentThumbDrawable == null && this.staticThumbDrawable == null) ? false : true, true, false);
        }
        View view = this.parentView;
        if (view != null) {
            if (this.invalidateAll) {
                view.invalidate();
            } else {
                float f = this.imageX;
                float f2 = this.imageY;
                view.invalidate((int) f, (int) f2, (int) (f + this.imageW), (int) (f2 + this.imageH));
            }
        }
        if (this.forceCrossfade && this.crossfadeWithOldImage && this.crossfadeImage != null) {
            this.currentAlpha = 0.0f;
            this.lastUpdateAlphaTime = System.currentTimeMillis();
            if (this.currentThumbDrawable == null && this.staticThumbDrawable == null) {
                z = false;
            }
            this.crossfadeWithThumb = z;
        }
    }

    private void setDrawableShader(Drawable drawable, BitmapShader shader) {
        if (drawable == this.currentThumbDrawable || drawable == this.staticThumbDrawable) {
            this.thumbShader = shader;
            return;
        }
        if (drawable == this.currentMediaDrawable) {
            this.mediaShader = shader;
            return;
        }
        if (drawable == this.currentImageDrawable) {
            this.imageShader = shader;
            if (this.gradientShader == null || !(drawable instanceof BitmapDrawable)) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                this.composeShader = new ComposeShader(this.gradientShader, this.imageShader, PorterDuff.Mode.DST_IN);
                return;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            int width = bitmapDrawable.getBitmap().getWidth();
            int height = bitmapDrawable.getBitmap().getHeight();
            Bitmap bitmap = this.legacyBitmap;
            if (bitmap != null && bitmap.getWidth() == width && this.legacyBitmap.getHeight() == height) {
                return;
            }
            Bitmap bitmap2 = this.legacyBitmap;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.legacyBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            this.legacyCanvas = new Canvas(this.legacyBitmap);
            Bitmap bitmap3 = this.legacyBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.legacyShader = new BitmapShader(bitmap3, tileMode, tileMode);
            if (this.legacyPaint == null) {
                Paint paint = new Paint();
                this.legacyPaint = paint;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            }
        }
    }

    private void updateDrawableRadius(Drawable drawable) {
        if ((hasRoundRadius() || this.gradientShader != null) && (drawable instanceof BitmapDrawable)) {
            if (drawable instanceof RLottieDrawable) {
                return;
            }
            if (drawable instanceof AnimatedFileDrawable) {
                ((AnimatedFileDrawable) drawable).setRoundRadius(this.roundRadius);
                return;
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            setDrawableShader(drawable, new BitmapShader(bitmap, tileMode, tileMode));
            return;
        }
        setDrawableShader(drawable, null);
    }

    public void clearImage() {
        for (int i = 0; i < 4; i++) {
            recycleBitmap(null, i);
        }
        ImageLoader.getInstance().cancelLoadingForImageReceiver(this, true);
    }

    public void onDetachedFromWindow() {
        if (this.currentImageLocation != null || this.currentMediaLocation != null || this.currentThumbLocation != null || this.staticThumbDrawable != null) {
            if (this.setImageBackup == null) {
                this.setImageBackup = new SetImageBackup();
            }
            SetImageBackup setImageBackup = this.setImageBackup;
            setImageBackup.mediaLocation = this.currentMediaLocation;
            setImageBackup.mediaFilter = this.currentMediaFilter;
            setImageBackup.imageLocation = this.currentImageLocation;
            setImageBackup.imageFilter = this.currentImageFilter;
            setImageBackup.thumbLocation = this.currentThumbLocation;
            setImageBackup.thumbFilter = this.currentThumbFilter;
            setImageBackup.thumb = this.staticThumbDrawable;
            setImageBackup.size = this.currentSize;
            setImageBackup.ext = this.currentExt;
            setImageBackup.cacheType = this.currentCacheType;
            setImageBackup.parentObject = this.currentParentObject;
        }
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReplacedPhotoInMemCache);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.stopAllHeavyOperations);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.startAllHeavyOperations);
        if (this.staticThumbDrawable != null) {
            this.staticThumbDrawable = null;
            this.thumbShader = null;
        }
        clearImage();
        if (this.isPressed == 0) {
            this.pressedProgress = 0.0f;
        }
    }

    private boolean setBackupImage() {
        SetImageBackup setImageBackup = this.setImageBackup;
        if (setImageBackup == null || !setImageBackup.isSet()) {
            return false;
        }
        SetImageBackup setImageBackup2 = this.setImageBackup;
        this.setImageBackup = null;
        setImage(setImageBackup2.mediaLocation, setImageBackup2.mediaFilter, setImageBackup2.imageLocation, setImageBackup2.imageFilter, setImageBackup2.thumbLocation, setImageBackup2.thumbFilter, setImageBackup2.thumb, setImageBackup2.size, setImageBackup2.ext, setImageBackup2.parentObject, setImageBackup2.cacheType);
        setImageBackup2.clear();
        this.setImageBackup = setImageBackup2;
        RLottieDrawable lottieAnimation = getLottieAnimation();
        if (lottieAnimation == null || !this.allowStartLottieAnimation) {
            return true;
        }
        if (lottieAnimation.isHeavyDrawable() && this.currentOpenedLayerFlags != 0) {
            return true;
        }
        lottieAnimation.start();
        return true;
    }

    public boolean onAttachedToWindow() {
        int currentHeavyOperationFlags = NotificationCenter.getGlobalInstance().getCurrentHeavyOperationFlags();
        this.currentOpenedLayerFlags = currentHeavyOperationFlags;
        this.currentOpenedLayerFlags = currentHeavyOperationFlags & (this.currentLayerNum ^ (-1));
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReplacedPhotoInMemCache);
        NotificationCenter globalInstance = NotificationCenter.getGlobalInstance();
        int i = NotificationCenter.stopAllHeavyOperations;
        globalInstance.addObserver(this, i);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.startAllHeavyOperations);
        if (setBackupImage()) {
            return true;
        }
        RLottieDrawable lottieAnimation = getLottieAnimation();
        if (lottieAnimation != null && this.allowStartLottieAnimation && (!lottieAnimation.isHeavyDrawable() || this.currentOpenedLayerFlags == 0)) {
            lottieAnimation.start();
        }
        AnimatedFileDrawable animation = getAnimation();
        if (animation != null && this.allowStartAnimation && this.currentOpenedLayerFlags == 0) {
            animation.stop();
        }
        if (NotificationCenter.getGlobalInstance().isAnimationInProgress()) {
            didReceivedNotification(i, this.currentAccount, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
        }
        return false;
    }

    private void drawDrawable(Canvas canvas, Drawable drawable, int alpha, BitmapShader shader, int orientation) {
        if (this.isPressed == 0) {
            float f = this.pressedProgress;
            if (f != 0.0f) {
                float f2 = f - 0.10666667f;
                this.pressedProgress = f2;
                if (f2 < 0.0f) {
                    this.pressedProgress = 0.0f;
                }
                View view = this.parentView;
                if (view != null) {
                    view.invalidate();
                }
            }
        }
        int i = this.isPressed;
        if (i != 0) {
            this.pressedProgress = 1.0f;
            this.animateFromIsPressed = i;
        }
        float f3 = this.pressedProgress;
        if (f3 == 0.0f || f3 == 1.0f) {
            drawDrawable(canvas, drawable, alpha, shader, orientation, i);
        } else {
            drawDrawable(canvas, drawable, alpha, shader, orientation, i);
            drawDrawable(canvas, drawable, (int) (alpha * this.pressedProgress), shader, orientation, this.animateFromIsPressed);
        }
    }

    public void setUseRoundForThumbDrawable(boolean value) {
        this.useRoundForThumb = value;
    }

    private void drawDrawable(Canvas canvas, Drawable drawable, int alpha, BitmapShader shader, int orientation, int isPressed) {
        Paint paint;
        int intrinsicHeight;
        int intrinsicWidth;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (shader != null) {
                paint = this.roundPaint;
            } else {
                paint = bitmapDrawable.getPaint();
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                Object obj = this.blendMode;
                if (obj != null && this.gradientShader == null) {
                    paint.setBlendMode((BlendMode) obj);
                } else {
                    paint.setBlendMode(null);
                }
            }
            boolean z = (paint == null || paint.getColorFilter() == null) ? false : true;
            if (z && isPressed == 0) {
                if (shader != null) {
                    this.roundPaint.setColorFilter(null);
                } else if (this.staticThumbDrawable != drawable) {
                    bitmapDrawable.setColorFilter(null);
                }
            } else if (!z && isPressed != 0) {
                if (isPressed == 1) {
                    if (shader != null) {
                        this.roundPaint.setColorFilter(selectedColorFilter);
                    } else {
                        bitmapDrawable.setColorFilter(selectedColorFilter);
                    }
                } else if (shader != null) {
                    this.roundPaint.setColorFilter(selectedGroupColorFilter);
                } else {
                    bitmapDrawable.setColorFilter(selectedGroupColorFilter);
                }
            }
            ColorFilter colorFilter = this.colorFilter;
            if (colorFilter != null && this.gradientShader == null) {
                if (shader != null) {
                    this.roundPaint.setColorFilter(colorFilter);
                } else {
                    bitmapDrawable.setColorFilter(colorFilter);
                }
            }
            boolean z2 = bitmapDrawable instanceof AnimatedFileDrawable;
            if (z2 || (bitmapDrawable instanceof RLottieDrawable)) {
                int i2 = orientation % 360;
                if (i2 == 90 || i2 == 270) {
                    intrinsicHeight = bitmapDrawable.getIntrinsicHeight();
                    intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
                } else {
                    intrinsicHeight = bitmapDrawable.getIntrinsicWidth();
                    intrinsicWidth = bitmapDrawable.getIntrinsicHeight();
                }
            } else {
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (bitmap != null && bitmap.isRecycled()) {
                    return;
                }
                int i3 = orientation % 360;
                if (i3 == 90 || i3 == 270) {
                    intrinsicHeight = bitmap.getHeight();
                    intrinsicWidth = bitmap.getWidth();
                } else {
                    intrinsicHeight = bitmap.getWidth();
                    intrinsicWidth = bitmap.getHeight();
                }
            }
            float f = this.imageW;
            float f2 = this.sideClip;
            float f3 = f - (f2 * 2.0f);
            float f4 = this.imageH;
            float f5 = f4 - (f2 * 2.0f);
            float f6 = f == 0.0f ? 1.0f : intrinsicHeight / f3;
            float f7 = f4 == 0.0f ? 1.0f : intrinsicWidth / f5;
            if (shader != null) {
                if (this.isAspectFit) {
                    float fMax = Math.max(f6, f7);
                    int i4 = (int) (intrinsicWidth / fMax);
                    RectF rectF = this.drawRegion;
                    float f8 = this.imageX;
                    float f9 = this.imageW;
                    float f10 = (int) (intrinsicHeight / fMax);
                    float f11 = this.imageY;
                    float f12 = this.imageH;
                    float f13 = i4;
                    rectF.set(((f9 - f10) / 2.0f) + f8, f11 + ((f12 - f13) / 2.0f), f8 + ((f9 + f10) / 2.0f), f11 + ((f12 + f13) / 2.0f));
                    if (!this.isVisible) {
                        return;
                    }
                    this.roundPaint.setShader(shader);
                    this.shaderMatrix.reset();
                    Matrix matrix = this.shaderMatrix;
                    RectF rectF2 = this.drawRegion;
                    matrix.setTranslate(rectF2.left, rectF2.top);
                    float f14 = 1.0f / fMax;
                    this.shaderMatrix.preScale(f14, f14);
                    shader.setLocalMatrix(this.shaderMatrix);
                    this.roundPaint.setAlpha(alpha);
                    this.roundRect.set(this.drawRegion);
                    if (this.isRoundRect) {
                        try {
                            RectF rectF3 = this.roundRect;
                            int[] iArr = this.roundRadius;
                            canvas.drawRoundRect(rectF3, iArr[0], iArr[0], this.roundPaint);
                            return;
                        } catch (Exception e) {
                            onBitmapException(bitmapDrawable);
                            FileLog.e(e);
                            return;
                        }
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 < this.roundRadius.length) {
                            float[] fArr = radii;
                            int i6 = i5 * 2;
                            fArr[i6] = r0[i5];
                            fArr[i6 + 1] = r0[i5];
                            i5++;
                        } else {
                            this.roundPath.reset();
                            this.roundPath.addRoundRect(this.roundRect, radii, Path.Direction.CW);
                            this.roundPath.close();
                            canvas.drawPath(this.roundPath, this.roundPaint);
                            return;
                        }
                    }
                } else {
                    if (this.legacyCanvas != null) {
                        this.roundRect.set(0.0f, 0.0f, this.legacyBitmap.getWidth(), this.legacyBitmap.getHeight());
                        this.legacyCanvas.drawBitmap(this.gradientBitmap, (Rect) null, this.roundRect, (Paint) null);
                        this.legacyCanvas.drawBitmap(bitmapDrawable.getBitmap(), (Rect) null, this.roundRect, this.legacyPaint);
                    }
                    if (shader == this.imageShader && this.gradientShader != null) {
                        ComposeShader composeShader = this.composeShader;
                        if (composeShader != null) {
                            this.roundPaint.setShader(composeShader);
                        } else {
                            this.roundPaint.setShader(this.legacyShader);
                        }
                    } else {
                        this.roundPaint.setShader(shader);
                    }
                    float fMin = 1.0f / Math.min(f6, f7);
                    RectF rectF4 = this.roundRect;
                    float f15 = this.imageX;
                    float f16 = this.sideClip;
                    float f17 = this.imageY;
                    rectF4.set(f15 + f16, f17 + f16, (f15 + this.imageW) - f16, (f17 + this.imageH) - f16);
                    if (Math.abs(f6 - f7) > 5.0E-4f) {
                        float f18 = intrinsicHeight / f7;
                        if (f18 > f3) {
                            RectF rectF5 = this.drawRegion;
                            float f19 = this.imageX;
                            float f20 = (int) f18;
                            float f21 = this.imageY;
                            rectF5.set(f19 - ((f20 - f3) / 2.0f), f21, f19 + ((f20 + f3) / 2.0f), f21 + f5);
                        } else {
                            int i7 = (int) (intrinsicWidth / f6);
                            RectF rectF6 = this.drawRegion;
                            float f22 = this.imageX;
                            float f23 = this.imageY;
                            float f24 = i7;
                            rectF6.set(f22, f23 - ((f24 - f5) / 2.0f), f22 + f3, f23 + ((f24 + f5) / 2.0f));
                        }
                    } else {
                        RectF rectF7 = this.drawRegion;
                        float f25 = this.imageX;
                        float f26 = this.imageY;
                        rectF7.set(f25, f26, f25 + f3, f26 + f5);
                    }
                    if (!this.isVisible) {
                        return;
                    }
                    this.shaderMatrix.reset();
                    Matrix matrix2 = this.shaderMatrix;
                    RectF rectF8 = this.drawRegion;
                    float f27 = rectF8.left;
                    float f28 = this.sideClip;
                    matrix2.setTranslate(f27 + f28, rectF8.top + f28);
                    if (orientation == 90) {
                        this.shaderMatrix.preRotate(90.0f);
                        this.shaderMatrix.preTranslate(0.0f, -this.drawRegion.width());
                    } else if (orientation == 180) {
                        this.shaderMatrix.preRotate(180.0f);
                        this.shaderMatrix.preTranslate(-this.drawRegion.width(), -this.drawRegion.height());
                    } else if (orientation == 270) {
                        this.shaderMatrix.preRotate(270.0f);
                        this.shaderMatrix.preTranslate(-this.drawRegion.height(), 0.0f);
                    }
                    this.shaderMatrix.preScale(fMin, fMin);
                    if (this.isRoundVideo) {
                        float f29 = (f3 + (AndroidUtilities.roundMessageInset * 2)) / f3;
                        this.shaderMatrix.postScale(f29, f29, this.drawRegion.centerX(), this.drawRegion.centerY());
                    }
                    BitmapShader bitmapShader = this.legacyShader;
                    if (bitmapShader != null) {
                        bitmapShader.setLocalMatrix(this.shaderMatrix);
                    }
                    shader.setLocalMatrix(this.shaderMatrix);
                    if (this.composeShader != null) {
                        int width = this.gradientBitmap.getWidth();
                        int height = this.gradientBitmap.getHeight();
                        float f30 = this.imageW == 0.0f ? 1.0f : width / f3;
                        float f31 = this.imageH == 0.0f ? 1.0f : height / f5;
                        if (Math.abs(f30 - f31) > 5.0E-4f) {
                            float f32 = width / f31;
                            if (f32 > f3) {
                                width = (int) f32;
                                RectF rectF9 = this.drawRegion;
                                float f33 = this.imageX;
                                float f34 = width;
                                float f35 = this.imageY;
                                rectF9.set(f33 - ((f34 - f3) / 2.0f), f35, f33 + ((f34 + f3) / 2.0f), f35 + f5);
                            } else {
                                height = (int) (height / f30);
                                RectF rectF10 = this.drawRegion;
                                float f36 = this.imageX;
                                float f37 = this.imageY;
                                float f38 = height;
                                rectF10.set(f36, f37 - ((f38 - f5) / 2.0f), f36 + f3, f37 + ((f38 + f5) / 2.0f));
                            }
                        } else {
                            RectF rectF11 = this.drawRegion;
                            float f39 = this.imageX;
                            float f40 = this.imageY;
                            rectF11.set(f39, f40, f39 + f3, f40 + f5);
                        }
                        float fMin2 = 1.0f / Math.min(this.imageW == 0.0f ? 1.0f : width / f3, this.imageH == 0.0f ? 1.0f : height / f5);
                        this.shaderMatrix.reset();
                        Matrix matrix3 = this.shaderMatrix;
                        RectF rectF12 = this.drawRegion;
                        float f41 = rectF12.left;
                        float f42 = this.sideClip;
                        matrix3.setTranslate(f41 + f42, rectF12.top + f42);
                        this.shaderMatrix.preScale(fMin2, fMin2);
                        this.gradientShader.setLocalMatrix(this.shaderMatrix);
                    }
                    this.roundPaint.setAlpha(alpha);
                    if (this.isRoundRect) {
                        try {
                            RectF rectF13 = this.roundRect;
                            int[] iArr2 = this.roundRadius;
                            canvas.drawRoundRect(rectF13, iArr2[0], iArr2[0], this.roundPaint);
                            return;
                        } catch (Exception e2) {
                            onBitmapException(bitmapDrawable);
                            FileLog.e(e2);
                            return;
                        }
                    }
                    int i8 = 0;
                    while (true) {
                        if (i8 < this.roundRadius.length) {
                            float[] fArr2 = radii;
                            int i9 = i8 * 2;
                            fArr2[i9] = r0[i8];
                            fArr2[i9 + 1] = r0[i8];
                            i8++;
                        } else {
                            this.roundPath.reset();
                            this.roundPath.addRoundRect(this.roundRect, radii, Path.Direction.CW);
                            this.roundPath.close();
                            canvas.drawPath(this.roundPath, this.roundPaint);
                            return;
                        }
                    }
                }
            } else {
                if (this.isAspectFit) {
                    float fMax2 = Math.max(f6, f7);
                    canvas.save();
                    RectF rectF14 = this.drawRegion;
                    float f43 = this.imageX;
                    float f44 = this.imageW;
                    float f45 = (int) (intrinsicHeight / fMax2);
                    float f46 = this.imageY;
                    float f47 = this.imageH;
                    float f48 = (int) (intrinsicWidth / fMax2);
                    rectF14.set(((f44 - f45) / 2.0f) + f43, ((f47 - f48) / 2.0f) + f46, f43 + ((f44 + f45) / 2.0f), f46 + ((f47 + f48) / 2.0f));
                    RectF rectF15 = this.drawRegion;
                    bitmapDrawable.setBounds((int) rectF15.left, (int) rectF15.top, (int) rectF15.right, (int) rectF15.bottom);
                    if (bitmapDrawable instanceof AnimatedFileDrawable) {
                        RectF rectF16 = this.drawRegion;
                        ((AnimatedFileDrawable) bitmapDrawable).setActualDrawRect(rectF16.left, rectF16.top, rectF16.width(), this.drawRegion.height());
                    }
                    if (this.isVisible) {
                        try {
                            bitmapDrawable.setAlpha(alpha);
                            bitmapDrawable.draw(canvas);
                        } catch (Exception e3) {
                            onBitmapException(bitmapDrawable);
                            FileLog.e(e3);
                        }
                    }
                    canvas.restore();
                    return;
                }
                if (Math.abs(f6 - f7) > 1.0E-5f) {
                    canvas.save();
                    float f49 = this.imageX;
                    float f50 = this.imageY;
                    canvas.clipRect(f49, f50, this.imageW + f49, this.imageH + f50);
                    int i10 = orientation % 360;
                    if (i10 != 0) {
                        if (this.centerRotation) {
                            canvas.rotate(orientation, this.imageW / 2.0f, this.imageH / 2.0f);
                        } else {
                            canvas.rotate(orientation, 0.0f, 0.0f);
                        }
                    }
                    float f51 = intrinsicHeight / f7;
                    float f52 = this.imageW;
                    if (f51 > f52) {
                        RectF rectF17 = this.drawRegion;
                        float f53 = this.imageX;
                        float f54 = (int) f51;
                        float f55 = this.imageY;
                        rectF17.set(f53 - ((f54 - f52) / 2.0f), f55, f53 + ((f54 + f52) / 2.0f), this.imageH + f55);
                    } else {
                        int i11 = (int) (intrinsicWidth / f6);
                        RectF rectF18 = this.drawRegion;
                        float f56 = this.imageX;
                        float f57 = this.imageY;
                        float f58 = i11;
                        float f59 = this.imageH;
                        rectF18.set(f56, f57 - ((f58 - f59) / 2.0f), f52 + f56, f57 + ((f58 + f59) / 2.0f));
                    }
                    if (z2) {
                        ((AnimatedFileDrawable) bitmapDrawable).setActualDrawRect(this.imageX, this.imageY, this.imageW, this.imageH);
                    }
                    if (i10 == 90 || i10 == 270) {
                        float fWidth = this.drawRegion.width() / 2.0f;
                        float fHeight = this.drawRegion.height() / 2.0f;
                        float fCenterX = this.drawRegion.centerX();
                        float fCenterY = this.drawRegion.centerY();
                        bitmapDrawable.setBounds((int) (fCenterX - fHeight), (int) (fCenterY - fWidth), (int) (fCenterX + fHeight), (int) (fCenterY + fWidth));
                    } else {
                        RectF rectF19 = this.drawRegion;
                        bitmapDrawable.setBounds((int) rectF19.left, (int) rectF19.top, (int) rectF19.right, (int) rectF19.bottom);
                    }
                    if (this.isVisible) {
                        if (i >= 29) {
                            try {
                                if (this.blendMode != null) {
                                    bitmapDrawable.getPaint().setBlendMode((BlendMode) this.blendMode);
                                } else {
                                    bitmapDrawable.getPaint().setBlendMode(null);
                                }
                            } catch (Exception e4) {
                                onBitmapException(bitmapDrawable);
                                FileLog.e(e4);
                            }
                        }
                        bitmapDrawable.setAlpha(alpha);
                        bitmapDrawable.draw(canvas);
                    }
                    canvas.restore();
                    return;
                }
                canvas.save();
                int i12 = orientation % 360;
                if (i12 != 0) {
                    if (this.centerRotation) {
                        canvas.rotate(orientation, this.imageW / 2.0f, this.imageH / 2.0f);
                    } else {
                        canvas.rotate(orientation, 0.0f, 0.0f);
                    }
                }
                RectF rectF20 = this.drawRegion;
                float f60 = this.imageX;
                float f61 = this.imageY;
                rectF20.set(f60, f61, this.imageW + f60, this.imageH + f61);
                if (this.isRoundVideo) {
                    RectF rectF21 = this.drawRegion;
                    int i13 = AndroidUtilities.roundMessageInset;
                    rectF21.inset(-i13, -i13);
                }
                if (z2) {
                    ((AnimatedFileDrawable) bitmapDrawable).setActualDrawRect(this.imageX, this.imageY, this.imageW, this.imageH);
                }
                if (i12 == 90 || i12 == 270) {
                    float fWidth2 = this.drawRegion.width() / 2.0f;
                    float fHeight2 = this.drawRegion.height() / 2.0f;
                    float fCenterX2 = this.drawRegion.centerX();
                    float fCenterY2 = this.drawRegion.centerY();
                    bitmapDrawable.setBounds((int) (fCenterX2 - fHeight2), (int) (fCenterY2 - fWidth2), (int) (fCenterX2 + fHeight2), (int) (fCenterY2 + fWidth2));
                } else {
                    RectF rectF22 = this.drawRegion;
                    bitmapDrawable.setBounds((int) rectF22.left, (int) rectF22.top, (int) rectF22.right, (int) rectF22.bottom);
                }
                if (this.isVisible) {
                    if (i >= 29) {
                        try {
                            if (this.blendMode != null) {
                                bitmapDrawable.getPaint().setBlendMode((BlendMode) this.blendMode);
                            } else {
                                bitmapDrawable.getPaint().setBlendMode(null);
                            }
                        } catch (Exception e5) {
                            onBitmapException(bitmapDrawable);
                            FileLog.e(e5);
                        }
                    }
                    bitmapDrawable.setAlpha(alpha);
                    bitmapDrawable.draw(canvas);
                }
                canvas.restore();
            }
        } else {
            if (this.isAspectFit) {
                int intrinsicWidth2 = drawable.getIntrinsicWidth();
                int intrinsicHeight2 = drawable.getIntrinsicHeight();
                float f62 = this.imageW;
                float f63 = this.sideClip;
                float f64 = f62 - (f63 * 2.0f);
                float f65 = this.imageH;
                float fMax3 = Math.max(f62 == 0.0f ? 1.0f : intrinsicWidth2 / f64, f65 == 0.0f ? 1.0f : intrinsicHeight2 / (f65 - (f63 * 2.0f)));
                int i14 = (int) (intrinsicWidth2 / fMax3);
                int i15 = (int) (intrinsicHeight2 / fMax3);
                RectF rectF23 = this.drawRegion;
                float f66 = this.imageX;
                float f67 = this.imageW;
                float f68 = i14;
                float f69 = this.imageY;
                float f70 = this.imageH;
                float f71 = i15;
                rectF23.set(((f67 - f68) / 2.0f) + f66, ((f70 - f71) / 2.0f) + f69, f66 + ((f67 + f68) / 2.0f), f69 + ((f70 + f71) / 2.0f));
            } else {
                RectF rectF24 = this.drawRegion;
                float f72 = this.imageX;
                float f73 = this.imageY;
                rectF24.set(f72, f73, this.imageW + f72, this.imageH + f73);
            }
            RectF rectF25 = this.drawRegion;
            drawable.setBounds((int) rectF25.left, (int) rectF25.top, (int) rectF25.right, (int) rectF25.bottom);
            if (this.isVisible) {
                try {
                    drawable.setAlpha(alpha);
                    drawable.draw(canvas);
                } catch (Exception e6) {
                    FileLog.e(e6);
                }
            }
        }
    }

    public void setBlendMode(Object mode) {
        this.blendMode = mode;
        invalidate();
    }

    public void setGradientBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.gradientShader == null || this.gradientBitmap != bitmap) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.gradientShader = new BitmapShader(bitmap, tileMode, tileMode);
                updateDrawableRadius(this.currentImageDrawable);
            }
            this.isRoundRect = true;
        } else {
            this.gradientShader = null;
            this.composeShader = null;
            this.legacyShader = null;
            this.legacyCanvas = null;
            Bitmap bitmap2 = this.legacyBitmap;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.legacyBitmap = null;
            }
        }
        this.gradientBitmap = bitmap;
    }

    private void onBitmapException(Drawable bitmapDrawable) {
        if (bitmapDrawable == this.currentMediaDrawable && this.currentMediaKey != null) {
            ImageLoader.getInstance().removeImage(this.currentMediaKey);
            this.currentMediaKey = null;
        } else if (bitmapDrawable == this.currentImageDrawable && this.currentImageKey != null) {
            ImageLoader.getInstance().removeImage(this.currentImageKey);
            this.currentImageKey = null;
        } else if (bitmapDrawable == this.currentThumbDrawable && this.currentThumbKey != null) {
            ImageLoader.getInstance().removeImage(this.currentThumbKey);
            this.currentThumbKey = null;
        }
        setImage(this.currentMediaLocation, this.currentMediaFilter, this.currentImageLocation, this.currentImageFilter, this.currentThumbLocation, this.currentThumbFilter, this.currentThumbDrawable, this.currentSize, this.currentExt, this.currentParentObject, this.currentCacheType);
    }

    private void checkAlphaAnimation(boolean skip) {
        if (this.manualAlphaAnimator || this.currentAlpha == 1.0f) {
            return;
        }
        if (!skip) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.lastUpdateAlphaTime;
            if (jCurrentTimeMillis > 18) {
                jCurrentTimeMillis = 18;
            }
            float f = this.currentAlpha + (jCurrentTimeMillis / this.crossfadeDuration);
            this.currentAlpha = f;
            if (f > 1.0f) {
                this.currentAlpha = 1.0f;
                if (this.crossfadeImage != null) {
                    recycleBitmap(null, 2);
                    this.crossfadeShader = null;
                }
            }
        }
        this.lastUpdateAlphaTime = System.currentTimeMillis();
        View view = this.parentView;
        if (view != null) {
            if (this.invalidateAll) {
                view.invalidate();
                return;
            }
            float f2 = this.imageX;
            float f3 = this.imageY;
            view.invalidate((int) f2, (int) f3, (int) (f2 + this.imageW), (int) (f3 + this.imageH));
        }
    }

    public void skipDraw() {
        RLottieDrawable lottieAnimation = getLottieAnimation();
        if (lottieAnimation != null) {
            lottieAnimation.setCurrentParentView(this.parentView);
            lottieAnimation.updateCurrentFrame();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0177 A[Catch: Exception -> 0x0193, TryCatch #0 {Exception -> 0x0193, blocks: (B:7:0x0021, B:9:0x002c, B:17:0x003f, B:19:0x0046, B:28:0x005e, B:30:0x0063, B:33:0x0069, B:57:0x00b3, B:59:0x00b7, B:62:0x00bd, B:110:0x016c, B:114:0x0173, B:64:0x00d0, B:66:0x00d8, B:68:0x00dc, B:71:0x00e1, B:73:0x00e5, B:76:0x00ea, B:79:0x00f0, B:95:0x0115, B:97:0x0119, B:100:0x011e, B:102:0x012a, B:104:0x0140, B:106:0x0144, B:101:0x0123, B:80:0x00f3, B:82:0x00f7, B:83:0x00fa, B:85:0x00fe, B:87:0x0103, B:89:0x0107, B:90:0x010a, B:92:0x010e, B:107:0x0147, B:108:0x015b, B:115:0x0177, B:117:0x017b, B:119:0x018f, B:36:0x0074, B:39:0x007a, B:41:0x007e, B:42:0x0087, B:44:0x008b, B:46:0x008f, B:48:0x0097, B:50:0x009d, B:51:0x00a2, B:53:0x00a6, B:23:0x0051, B:25:0x0055, B:27:0x005b, B:12:0x0034), top: B:130:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3 A[Catch: Exception -> 0x0193, TryCatch #0 {Exception -> 0x0193, blocks: (B:7:0x0021, B:9:0x002c, B:17:0x003f, B:19:0x0046, B:28:0x005e, B:30:0x0063, B:33:0x0069, B:57:0x00b3, B:59:0x00b7, B:62:0x00bd, B:110:0x016c, B:114:0x0173, B:64:0x00d0, B:66:0x00d8, B:68:0x00dc, B:71:0x00e1, B:73:0x00e5, B:76:0x00ea, B:79:0x00f0, B:95:0x0115, B:97:0x0119, B:100:0x011e, B:102:0x012a, B:104:0x0140, B:106:0x0144, B:101:0x0123, B:80:0x00f3, B:82:0x00f7, B:83:0x00fa, B:85:0x00fe, B:87:0x0103, B:89:0x0107, B:90:0x010a, B:92:0x010e, B:107:0x0147, B:108:0x015b, B:115:0x0177, B:117:0x017b, B:119:0x018f, B:36:0x0074, B:39:0x007a, B:41:0x007e, B:42:0x0087, B:44:0x008b, B:46:0x008f, B:48:0x0097, B:50:0x009d, B:51:0x00a2, B:53:0x00a6, B:23:0x0051, B:25:0x0055, B:27:0x005b, B:12:0x0034), top: B:130:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean draw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageReceiver.draw(android.graphics.Canvas):boolean");
    }

    public void setManualAlphaAnimator(boolean value) {
        this.manualAlphaAnimator = value;
    }

    @Keep
    public float getCurrentAlpha() {
        return this.currentAlpha;
    }

    @Keep
    public void setCurrentAlpha(float value) {
        this.currentAlpha = value;
    }

    public Drawable getDrawable() {
        Drawable drawable = this.currentMediaDrawable;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = this.currentImageDrawable;
        if (drawable2 != null) {
            return drawable2;
        }
        Drawable drawable3 = this.currentThumbDrawable;
        if (drawable3 != null) {
            return drawable3;
        }
        Drawable drawable4 = this.staticThumbDrawable;
        if (drawable4 != null) {
            return drawable4;
        }
        return null;
    }

    public Bitmap getBitmap() {
        AnimatedFileDrawable animation = getAnimation();
        RLottieDrawable lottieAnimation = getLottieAnimation();
        if (lottieAnimation != null && lottieAnimation.hasBitmap()) {
            return lottieAnimation.getAnimatedBitmap();
        }
        if (animation != null && animation.hasBitmap()) {
            return animation.getAnimatedBitmap();
        }
        Drawable drawable = this.currentMediaDrawable;
        if ((drawable instanceof BitmapDrawable) && !(drawable instanceof AnimatedFileDrawable) && !(drawable instanceof RLottieDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Drawable drawable2 = this.currentImageDrawable;
        if ((drawable2 instanceof BitmapDrawable) && !(drawable2 instanceof AnimatedFileDrawable) && !(drawable instanceof RLottieDrawable)) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        Drawable drawable3 = this.currentThumbDrawable;
        if ((drawable3 instanceof BitmapDrawable) && !(drawable3 instanceof AnimatedFileDrawable) && !(drawable instanceof RLottieDrawable)) {
            return ((BitmapDrawable) drawable3).getBitmap();
        }
        Drawable drawable4 = this.staticThumbDrawable;
        if (drawable4 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable4).getBitmap();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.eitaa.messenger.ImageReceiver.BitmapHolder getBitmapSafe() {
        /*
            r5 = this;
            ir.eitaa.ui.Components.AnimatedFileDrawable r0 = r5.getAnimation()
            ir.eitaa.ui.Components.RLottieDrawable r1 = r5.getLottieAnimation()
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L19
            boolean r4 = r1.hasBitmap()
            if (r4 == 0) goto L19
            android.graphics.Bitmap r0 = r1.getAnimatedBitmap()
        L16:
            r1 = r2
            goto L8b
        L19:
            if (r0 == 0) goto L37
            boolean r1 = r0.hasBitmap()
            if (r1 == 0) goto L37
            android.graphics.Bitmap r1 = r0.getAnimatedBitmap()
            int r3 = r0.getOrientation()
            if (r3 == 0) goto L35
            ir.eitaa.messenger.ImageReceiver$BitmapHolder r0 = new ir.eitaa.messenger.ImageReceiver$BitmapHolder
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1)
            r0.<init>(r1, r2, r3)
            return r0
        L35:
            r0 = r1
            goto L16
        L37:
            android.graphics.drawable.Drawable r0 = r5.currentMediaDrawable
            boolean r1 = r0 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 == 0) goto L4e
            boolean r1 = r0 instanceof ir.eitaa.ui.Components.AnimatedFileDrawable
            if (r1 != 0) goto L4e
            boolean r1 = r0 instanceof ir.eitaa.ui.Components.RLottieDrawable
            if (r1 != 0) goto L4e
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            android.graphics.Bitmap r0 = r0.getBitmap()
            java.lang.String r1 = r5.currentMediaKey
            goto L8b
        L4e:
            android.graphics.drawable.Drawable r1 = r5.currentImageDrawable
            boolean r4 = r1 instanceof android.graphics.drawable.BitmapDrawable
            if (r4 == 0) goto L65
            boolean r4 = r1 instanceof ir.eitaa.ui.Components.AnimatedFileDrawable
            if (r4 != 0) goto L65
            boolean r4 = r0 instanceof ir.eitaa.ui.Components.RLottieDrawable
            if (r4 != 0) goto L65
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            android.graphics.Bitmap r0 = r1.getBitmap()
            java.lang.String r1 = r5.currentImageKey
            goto L8b
        L65:
            android.graphics.drawable.Drawable r1 = r5.currentThumbDrawable
            boolean r4 = r1 instanceof android.graphics.drawable.BitmapDrawable
            if (r4 == 0) goto L7c
            boolean r4 = r1 instanceof ir.eitaa.ui.Components.AnimatedFileDrawable
            if (r4 != 0) goto L7c
            boolean r0 = r0 instanceof ir.eitaa.ui.Components.RLottieDrawable
            if (r0 != 0) goto L7c
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            android.graphics.Bitmap r0 = r1.getBitmap()
            java.lang.String r1 = r5.currentThumbKey
            goto L8b
        L7c:
            android.graphics.drawable.Drawable r0 = r5.staticThumbDrawable
            boolean r1 = r0 instanceof android.graphics.drawable.BitmapDrawable
            if (r1 == 0) goto L89
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            android.graphics.Bitmap r0 = r0.getBitmap()
            goto L16
        L89:
            r0 = r2
            r1 = r0
        L8b:
            if (r0 == 0) goto L92
            ir.eitaa.messenger.ImageReceiver$BitmapHolder r2 = new ir.eitaa.messenger.ImageReceiver$BitmapHolder
            r2.<init>(r0, r1, r3)
        L92:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageReceiver.getBitmapSafe():ir.eitaa.messenger.ImageReceiver$BitmapHolder");
    }

    public BitmapHolder getDrawableSafe() {
        String str;
        String str2;
        Drawable drawable = this.currentMediaDrawable;
        if ((drawable instanceof BitmapDrawable) && !(drawable instanceof AnimatedFileDrawable) && !(drawable instanceof RLottieDrawable)) {
            str = this.currentMediaKey;
        } else {
            Drawable drawable2 = this.currentImageDrawable;
            if ((drawable2 instanceof BitmapDrawable) && !(drawable2 instanceof AnimatedFileDrawable) && !(drawable instanceof RLottieDrawable)) {
                str2 = this.currentImageKey;
            } else {
                drawable2 = this.currentThumbDrawable;
                if ((drawable2 instanceof BitmapDrawable) && !(drawable2 instanceof AnimatedFileDrawable) && !(drawable instanceof RLottieDrawable)) {
                    str2 = this.currentThumbKey;
                } else {
                    drawable = this.staticThumbDrawable;
                    if (drawable instanceof BitmapDrawable) {
                        str = null;
                    } else {
                        drawable = null;
                        str = null;
                    }
                }
            }
            Drawable drawable3 = drawable2;
            str = str2;
            drawable = drawable3;
        }
        if (drawable != null) {
            return new BitmapHolder(drawable, str, 0);
        }
        return null;
    }

    public Bitmap getThumbBitmap() {
        Drawable drawable = this.currentThumbDrawable;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Drawable drawable2 = this.staticThumbDrawable;
        if (drawable2 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        return null;
    }

    public BitmapHolder getThumbBitmapSafe() {
        Bitmap bitmap;
        String str;
        Drawable drawable = this.currentThumbDrawable;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            str = this.currentThumbKey;
        } else {
            Drawable drawable2 = this.staticThumbDrawable;
            if (drawable2 instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable2).getBitmap();
                str = null;
            } else {
                bitmap = null;
                str = null;
            }
        }
        if (bitmap != null) {
            return new BitmapHolder(bitmap, str, 0);
        }
        return null;
    }

    public int getBitmapWidth() {
        getDrawable();
        AnimatedFileDrawable animation = getAnimation();
        if (animation != null) {
            int i = this.imageOrientation;
            return (i % 360 == 0 || i % 360 == 180) ? animation.getIntrinsicWidth() : animation.getIntrinsicHeight();
        }
        RLottieDrawable lottieAnimation = getLottieAnimation();
        if (lottieAnimation != null) {
            return lottieAnimation.getIntrinsicWidth();
        }
        Bitmap bitmap = getBitmap();
        if (bitmap == null) {
            Drawable drawable = this.staticThumbDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicWidth();
            }
            return 1;
        }
        int i2 = this.imageOrientation;
        return (i2 % 360 == 0 || i2 % 360 == 180) ? bitmap.getWidth() : bitmap.getHeight();
    }

    public int getBitmapHeight() {
        getDrawable();
        AnimatedFileDrawable animation = getAnimation();
        if (animation != null) {
            int i = this.imageOrientation;
            return (i % 360 == 0 || i % 360 == 180) ? animation.getIntrinsicHeight() : animation.getIntrinsicWidth();
        }
        RLottieDrawable lottieAnimation = getLottieAnimation();
        if (lottieAnimation != null) {
            return lottieAnimation.getIntrinsicHeight();
        }
        Bitmap bitmap = getBitmap();
        if (bitmap == null) {
            Drawable drawable = this.staticThumbDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicHeight();
            }
            return 1;
        }
        int i2 = this.imageOrientation;
        return (i2 % 360 == 0 || i2 % 360 == 180) ? bitmap.getHeight() : bitmap.getWidth();
    }

    public void setVisible(boolean value, boolean invalidate) {
        if (this.isVisible == value) {
            return;
        }
        this.isVisible = value;
        if (invalidate) {
            invalidate();
        }
    }

    public void invalidate() {
        View view = this.parentView;
        if (view == null) {
            return;
        }
        if (this.invalidateAll) {
            view.invalidate();
            return;
        }
        float f = this.imageX;
        float f2 = this.imageY;
        view.invalidate((int) f, (int) f2, (int) (f + this.imageW), (int) (f2 + this.imageH));
    }

    public void getParentPosition(int[] position) {
        View view = this.parentView;
        if (view == null) {
            return;
        }
        view.getLocationInWindow(position);
    }

    public boolean getVisible() {
        return this.isVisible;
    }

    @Keep
    public void setAlpha(float value) {
        this.overrideAlpha = value;
    }

    @Keep
    public float getAlpha() {
        return this.overrideAlpha;
    }

    public void setCrossfadeAlpha(byte value) {
        this.crossfadeAlpha = value;
    }

    public boolean hasImageSet() {
        return (this.currentImageDrawable == null && this.currentMediaDrawable == null && this.currentThumbDrawable == null && this.staticThumbDrawable == null && this.currentImageKey == null && this.currentMediaKey == null) ? false : true;
    }

    public boolean hasBitmapImage() {
        return (this.currentImageDrawable == null && this.currentThumbDrawable == null && this.staticThumbDrawable == null && this.currentMediaDrawable == null) ? false : true;
    }

    public boolean hasNotThumb() {
        return (this.currentImageDrawable == null && this.currentMediaDrawable == null) ? false : true;
    }

    public boolean hasStaticThumb() {
        return this.staticThumbDrawable != null;
    }

    public void setAspectFit(boolean value) {
        this.isAspectFit = value;
    }

    public boolean isAspectFit() {
        return this.isAspectFit;
    }

    public void setParentView(View view) {
        this.parentView = view;
        AnimatedFileDrawable animation = getAnimation();
        if (animation != null) {
            animation.setParentView(this.parentView);
        }
    }

    public void setImageX(int x) {
        this.imageX = x;
    }

    public void setImageY(float y) {
        this.imageY = y;
    }

    public void setImageWidth(int width) {
        this.imageW = width;
    }

    public void setImageCoords(float x, float y, float width, float height) {
        this.imageX = x;
        this.imageY = y;
        this.imageW = width;
        this.imageH = height;
    }

    public void setSideClip(float value) {
        this.sideClip = value;
    }

    public float getCenterX() {
        return this.imageX + (this.imageW / 2.0f);
    }

    public float getCenterY() {
        return this.imageY + (this.imageH / 2.0f);
    }

    public float getImageX() {
        return this.imageX;
    }

    public float getImageX2() {
        return this.imageX + this.imageW;
    }

    public float getImageY() {
        return this.imageY;
    }

    public float getImageY2() {
        return this.imageY + this.imageH;
    }

    public float getImageWidth() {
        return this.imageW;
    }

    public float getImageHeight() {
        return this.imageH;
    }

    public float getImageAspectRatio() {
        float fWidth;
        float fHeight;
        if (this.imageOrientation % 180 != 0) {
            fWidth = this.drawRegion.height();
            fHeight = this.drawRegion.width();
        } else {
            fWidth = this.drawRegion.width();
            fHeight = this.drawRegion.height();
        }
        return fWidth / fHeight;
    }

    public String getExt() {
        return this.currentExt;
    }

    public boolean isInsideImage(float x, float y) {
        float f = this.imageX;
        if (x >= f && x <= f + this.imageW) {
            float f2 = this.imageY;
            if (y >= f2 && y <= f2 + this.imageH) {
                return true;
            }
        }
        return false;
    }

    public RectF getDrawRegion() {
        return this.drawRegion;
    }

    public int getNewGuid() {
        int i = this.currentGuid + 1;
        this.currentGuid = i;
        return i;
    }

    public String getImageKey() {
        return this.currentImageKey;
    }

    public String getMediaKey() {
        return this.currentMediaKey;
    }

    public String getThumbKey() {
        return this.currentThumbKey;
    }

    public int getSize() {
        return this.currentSize;
    }

    public ImageLocation getMediaLocation() {
        return this.currentMediaLocation;
    }

    public ImageLocation getImageLocation() {
        return this.currentImageLocation;
    }

    public ImageLocation getThumbLocation() {
        return this.currentThumbLocation;
    }

    public String getMediaFilter() {
        return this.currentMediaFilter;
    }

    public String getImageFilter() {
        return this.currentImageFilter;
    }

    public String getThumbFilter() {
        return this.currentThumbFilter;
    }

    public int getCacheType() {
        return this.currentCacheType;
    }

    public void setForcePreview(boolean value) {
        this.forcePreview = value;
    }

    public void setForceCrossfade(boolean value) {
        this.forceCrossfade = value;
    }

    public boolean isForcePreview() {
        return this.forcePreview;
    }

    public void setRoundRadius(int value) {
        setRoundRadius(new int[]{value, value, value, value});
    }

    public void setRoundRadius(int tl, int tr, int bl, int br) {
        setRoundRadius(new int[]{tl, tr, bl, br});
    }

    public void setRoundRadius(int[] value) {
        int i = value[0];
        this.isRoundRect = true;
        int i2 = 0;
        boolean z = false;
        while (true) {
            int[] iArr = this.roundRadius;
            if (i2 >= iArr.length) {
                break;
            }
            if (iArr[i2] != value[i2]) {
                z = true;
            }
            if (i != value[i2]) {
                this.isRoundRect = false;
            }
            iArr[i2] = value[i2];
            i2++;
        }
        if (z) {
            Drawable drawable = this.currentImageDrawable;
            if (drawable != null && this.imageShader == null) {
                updateDrawableRadius(drawable);
            }
            Drawable drawable2 = this.currentMediaDrawable;
            if (drawable2 != null && this.mediaShader == null) {
                updateDrawableRadius(drawable2);
            }
            if (this.thumbShader == null) {
                Drawable drawable3 = this.currentThumbDrawable;
                if (drawable3 != null) {
                    updateDrawableRadius(drawable3);
                    return;
                }
                Drawable drawable4 = this.staticThumbDrawable;
                if (drawable4 != null) {
                    updateDrawableRadius(drawable4);
                }
            }
        }
    }

    public void setCurrentAccount(int value) {
        this.currentAccount = value;
    }

    public int[] getRoundRadius() {
        return this.roundRadius;
    }

    public Object getParentObject() {
        return this.currentParentObject;
    }

    public void setNeedsQualityThumb(boolean value) {
        this.needsQualityThumb = value;
    }

    public void setQualityThumbDocument(TLRPC$Document document) {
        this.qulityThumbDocument = document;
    }

    public TLRPC$Document getQulityThumbDocument() {
        return this.qulityThumbDocument;
    }

    public void setCrossfadeWithOldImage(boolean value) {
        this.crossfadeWithOldImage = value;
    }

    public boolean isNeedsQualityThumb() {
        return this.needsQualityThumb;
    }

    public boolean isCurrentKeyQuality() {
        return this.currentKeyQuality;
    }

    public int getCurrentAccount() {
        return this.currentAccount;
    }

    public void setShouldGenerateQualityThumb(boolean value) {
        this.shouldGenerateQualityThumb = value;
    }

    public boolean isShouldGenerateQualityThumb() {
        return this.shouldGenerateQualityThumb;
    }

    public void setAllowStartAnimation(boolean value) {
        this.allowStartAnimation = value;
    }

    public boolean getAllowStartAnimation() {
        return this.allowStartAnimation;
    }

    public void setAllowStartLottieAnimation(boolean value) {
        this.allowStartLottieAnimation = value;
    }

    public void setAllowDecodeSingleFrame(boolean value) {
        this.allowDecodeSingleFrame = value;
    }

    public void setAutoRepeat(int value) {
        this.autoRepeat = value;
        RLottieDrawable lottieAnimation = getLottieAnimation();
        if (lottieAnimation != null) {
            lottieAnimation.setAutoRepeat(value);
        }
    }

    public void setUseSharedAnimationQueue(boolean value) {
        this.useSharedAnimationQueue = value;
    }

    public boolean isAllowStartAnimation() {
        return this.allowStartAnimation;
    }

    public void startAnimation() {
        AnimatedFileDrawable animation = getAnimation();
        if (animation != null) {
            animation.setUseSharedQueue(this.useSharedAnimationQueue);
            animation.start();
            return;
        }
        RLottieDrawable lottieAnimation = getLottieAnimation();
        if (lottieAnimation == null || lottieAnimation.isRunning()) {
            return;
        }
        lottieAnimation.restart();
    }

    public void stopAnimation() {
        AnimatedFileDrawable animation = getAnimation();
        if (animation != null) {
            animation.stop();
            return;
        }
        RLottieDrawable lottieAnimation = getLottieAnimation();
        if (lottieAnimation == null || lottieAnimation.isRunning()) {
            return;
        }
        lottieAnimation.stop();
    }

    public boolean isAnimationRunning() {
        AnimatedFileDrawable animation = getAnimation();
        return animation != null && animation.isRunning();
    }

    public AnimatedFileDrawable getAnimation() {
        Drawable drawable = this.currentMediaDrawable;
        if (drawable instanceof AnimatedFileDrawable) {
            return (AnimatedFileDrawable) drawable;
        }
        Drawable drawable2 = this.currentImageDrawable;
        if (drawable2 instanceof AnimatedFileDrawable) {
            return (AnimatedFileDrawable) drawable2;
        }
        Drawable drawable3 = this.currentThumbDrawable;
        if (drawable3 instanceof AnimatedFileDrawable) {
            return (AnimatedFileDrawable) drawable3;
        }
        Drawable drawable4 = this.staticThumbDrawable;
        if (drawable4 instanceof AnimatedFileDrawable) {
            return (AnimatedFileDrawable) drawable4;
        }
        return null;
    }

    public RLottieDrawable getLottieAnimation() {
        Drawable drawable = this.currentMediaDrawable;
        if (drawable instanceof RLottieDrawable) {
            return (RLottieDrawable) drawable;
        }
        Drawable drawable2 = this.currentImageDrawable;
        if (drawable2 instanceof RLottieDrawable) {
            return (RLottieDrawable) drawable2;
        }
        Drawable drawable3 = this.currentThumbDrawable;
        if (drawable3 instanceof RLottieDrawable) {
            return (RLottieDrawable) drawable3;
        }
        Drawable drawable4 = this.staticThumbDrawable;
        if (drawable4 instanceof RLottieDrawable) {
            return (RLottieDrawable) drawable4;
        }
        return null;
    }

    protected int getTag(int type) {
        if (type == 1) {
            return this.thumbTag;
        }
        if (type == 3) {
            return this.mediaTag;
        }
        return this.imageTag;
    }

    protected void setTag(int value, int type) {
        if (type == 1) {
            this.thumbTag = value;
        } else if (type == 3) {
            this.mediaTag = value;
        } else {
            this.imageTag = value;
        }
    }

    public void setParam(int value) {
        this.param = value;
    }

    public int getParam() {
        return this.param;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean setImageBitmapByKey(android.graphics.drawable.Drawable r8, java.lang.String r9, int r10, boolean r11, int r12) {
        /*
            Method dump skipped, instructions count: 555
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ImageReceiver.setImageBitmapByKey(android.graphics.drawable.Drawable, java.lang.String, int, boolean, int):boolean");
    }

    public void setMediaStartEndTime(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        Drawable drawable = this.currentMediaDrawable;
        if (drawable instanceof AnimatedFileDrawable) {
            ((AnimatedFileDrawable) drawable).setStartEndTime(startTime, endTime);
        }
    }

    private void recycleBitmap(String newKey, int type) {
        String str;
        Drawable drawable;
        String replacedKey;
        if (type == 3) {
            str = this.currentMediaKey;
            drawable = this.currentMediaDrawable;
        } else if (type == 2) {
            str = this.crossfadeKey;
            drawable = this.crossfadeImage;
        } else if (type == 1) {
            str = this.currentThumbKey;
            drawable = this.currentThumbDrawable;
        } else {
            str = this.currentImageKey;
            drawable = this.currentImageDrawable;
        }
        if (str != null && ((str.startsWith("-") || str.startsWith("strippedmessage-")) && (replacedKey = ImageLoader.getInstance().getReplacedKey(str)) != null)) {
            str = replacedKey;
        }
        if (drawable instanceof RLottieDrawable) {
            ((RLottieDrawable) drawable).removeParentView(this.parentView);
        }
        if (str != null && ((newKey == null || !newKey.equals(str)) && drawable != null)) {
            if (drawable instanceof RLottieDrawable) {
                RLottieDrawable rLottieDrawable = (RLottieDrawable) drawable;
                boolean zDecrementUseCount = ImageLoader.getInstance().decrementUseCount(str);
                if (!ImageLoader.getInstance().isInMemCache(str, true) && zDecrementUseCount) {
                    rLottieDrawable.recycle();
                }
            } else if (drawable instanceof AnimatedFileDrawable) {
                ((AnimatedFileDrawable) drawable).recycle();
            } else if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                boolean zDecrementUseCount2 = ImageLoader.getInstance().decrementUseCount(str);
                if (!ImageLoader.getInstance().isInMemCache(str, false) && zDecrementUseCount2) {
                    bitmap.recycle();
                }
            }
        }
        if (type == 3) {
            this.currentMediaKey = null;
            this.currentMediaDrawable = null;
        } else if (type == 2) {
            this.crossfadeKey = null;
            this.crossfadeImage = null;
        } else if (type == 1) {
            this.currentThumbDrawable = null;
            this.currentThumbKey = null;
        } else {
            this.currentImageDrawable = null;
            this.currentImageKey = null;
        }
    }

    public void setCrossfadeDuration(int duration) {
        this.crossfadeDuration = duration;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        int i;
        if (id == NotificationCenter.didReplacedPhotoInMemCache) {
            String str = (String) args[0];
            String str2 = this.currentMediaKey;
            if (str2 != null && str2.equals(str)) {
                this.currentMediaKey = (String) args[1];
                this.currentMediaLocation = (ImageLocation) args[2];
                SetImageBackup setImageBackup = this.setImageBackup;
                if (setImageBackup != null) {
                    setImageBackup.mediaLocation = (ImageLocation) args[2];
                }
            }
            String str3 = this.currentImageKey;
            if (str3 != null && str3.equals(str)) {
                this.currentImageKey = (String) args[1];
                this.currentImageLocation = (ImageLocation) args[2];
                SetImageBackup setImageBackup2 = this.setImageBackup;
                if (setImageBackup2 != null) {
                    setImageBackup2.imageLocation = (ImageLocation) args[2];
                }
            }
            String str4 = this.currentThumbKey;
            if (str4 == null || !str4.equals(str)) {
                return;
            }
            this.currentThumbKey = (String) args[1];
            this.currentThumbLocation = (ImageLocation) args[2];
            SetImageBackup setImageBackup3 = this.setImageBackup;
            if (setImageBackup3 != null) {
                setImageBackup3.thumbLocation = (ImageLocation) args[2];
                return;
            }
            return;
        }
        if (id == NotificationCenter.stopAllHeavyOperations) {
            Integer num = (Integer) args[0];
            if (this.currentLayerNum >= num.intValue()) {
                return;
            }
            int iIntValue = num.intValue() | this.currentOpenedLayerFlags;
            this.currentOpenedLayerFlags = iIntValue;
            if (iIntValue != 0) {
                RLottieDrawable lottieAnimation = getLottieAnimation();
                if (lottieAnimation != null && lottieAnimation.isHeavyDrawable()) {
                    lottieAnimation.stop();
                }
                AnimatedFileDrawable animation = getAnimation();
                if (animation != null) {
                    animation.stop();
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.startAllHeavyOperations) {
            Integer num2 = (Integer) args[0];
            if (this.currentLayerNum >= num2.intValue() || (i = this.currentOpenedLayerFlags) == 0) {
                return;
            }
            int iIntValue2 = (num2.intValue() ^ (-1)) & i;
            this.currentOpenedLayerFlags = iIntValue2;
            if (iIntValue2 == 0) {
                RLottieDrawable lottieAnimation2 = getLottieAnimation();
                if (this.allowStartLottieAnimation && lottieAnimation2 != null && lottieAnimation2.isHeavyDrawable()) {
                    lottieAnimation2.start();
                }
                AnimatedFileDrawable animation2 = getAnimation();
                if (!this.allowStartAnimation || animation2 == null) {
                    return;
                }
                animation2.start();
            }
        }
    }

    public void startCrossfadeFromStaticThumb(Bitmap thumb) {
        this.currentThumbKey = null;
        this.currentThumbDrawable = null;
        this.thumbShader = null;
        BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources) null, thumb);
        this.staticThumbDrawable = bitmapDrawable;
        this.crossfadeWithThumb = true;
        this.currentAlpha = 0.0f;
        updateDrawableRadius(bitmapDrawable);
    }

    public void setUniqKeyPrefix(String prefix) {
        this.uniqKeyPrefix = prefix;
    }

    public String getUniqKeyPrefix() {
        return this.uniqKeyPrefix;
    }
}
