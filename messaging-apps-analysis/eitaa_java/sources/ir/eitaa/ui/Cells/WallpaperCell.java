package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_wallPaper;
import ir.eitaa.tgnet.TLRPC$WallPaperSettings;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CheckBox;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.MotionBackgroundDrawable;
import ir.eitaa.ui.WallpapersListActivity;
import java.io.File;

/* loaded from: classes3.dex */
public class WallpaperCell extends FrameLayout {
    private Paint backgroundPaint;
    private Drawable checkDrawable;
    private Paint circlePaint;
    private int currentType;
    private Paint framePaint;
    private boolean isBottom;
    private boolean isTop;
    private int spanCount;
    private WallpaperView[] wallpaperViews;

    protected void onWallpaperClick(Object wallPaper, int index) {
    }

    protected boolean onWallpaperLongClick(Object wallPaper, int index) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class WallpaperView extends FrameLayout {
        private AnimatorSet animator;
        private CheckBox checkBox;
        private Object currentWallpaper;
        private BackupImageView imageView;
        private ImageView imageView2;
        private boolean isSelected;
        private View selector;

        public WallpaperView(Context context) {
            super(context);
            setWillNotDraw(false);
            BackupImageView backupImageView = new BackupImageView(context) { // from class: ir.eitaa.ui.Cells.WallpaperCell.WallpaperView.1
                @Override // ir.eitaa.ui.Components.BackupImageView, android.view.View
                protected void onDraw(Canvas canvas) {
                    super.onDraw(canvas);
                    if ((WallpaperView.this.currentWallpaper instanceof WallpapersListActivity.ColorWallpaper) || (WallpaperView.this.currentWallpaper instanceof WallpapersListActivity.FileWallpaper)) {
                        canvas.drawLine(1.0f, 0.0f, getMeasuredWidth() - 1, 0.0f, WallpaperCell.this.framePaint);
                        canvas.drawLine(0.0f, 0.0f, 0.0f, getMeasuredHeight(), WallpaperCell.this.framePaint);
                        canvas.drawLine(getMeasuredWidth() - 1, 0.0f, getMeasuredWidth() - 1, getMeasuredHeight(), WallpaperCell.this.framePaint);
                        canvas.drawLine(1.0f, getMeasuredHeight() - 1, getMeasuredWidth() - 1, getMeasuredHeight() - 1, WallpaperCell.this.framePaint);
                    }
                    if (WallpaperView.this.isSelected) {
                        WallpaperCell.this.circlePaint.setColor(Theme.serviceMessageColorBackup);
                        int measuredWidth = getMeasuredWidth() / 2;
                        int measuredHeight = getMeasuredHeight() / 2;
                        canvas.drawCircle(measuredWidth, measuredHeight, AndroidUtilities.dp(20.0f), WallpaperCell.this.circlePaint);
                        WallpaperCell.this.checkDrawable.setBounds(measuredWidth - (WallpaperCell.this.checkDrawable.getIntrinsicWidth() / 2), measuredHeight - (WallpaperCell.this.checkDrawable.getIntrinsicHeight() / 2), measuredWidth + (WallpaperCell.this.checkDrawable.getIntrinsicWidth() / 2), measuredHeight + (WallpaperCell.this.checkDrawable.getIntrinsicHeight() / 2));
                        WallpaperCell.this.checkDrawable.draw(canvas);
                    }
                }
            };
            this.imageView = backupImageView;
            addView(backupImageView, LayoutHelper.createFrame(-1, -1, 51));
            ImageView imageView = new ImageView(context);
            this.imageView2 = imageView;
            imageView.setImageResource(R.drawable.ic_gallery_background);
            this.imageView2.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView2, LayoutHelper.createFrame(-1, -1, 51));
            View view = new View(context);
            this.selector = view;
            view.setBackgroundDrawable(Theme.getSelectorDrawable(false));
            addView(this.selector, LayoutHelper.createFrame(-1, -1.0f));
            CheckBox checkBox = new CheckBox(context, R.drawable.round_check2);
            this.checkBox = checkBox;
            checkBox.setVisibility(4);
            this.checkBox.setColor(Theme.getColor("checkbox"), Theme.getColor("checkboxCheck"));
            addView(this.checkBox, LayoutHelper.createFrame(22, 22.0f, 53, 0.0f, 2.0f, 2.0f, 0.0f));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.selector.drawableHotspotChanged(event.getX(), event.getY());
            }
            return super.onTouchEvent(event);
        }

        public void setWallpaper(Object object, Object selectedWallpaper, Drawable themedWallpaper, boolean themed) {
            TLRPC$PhotoSize tLRPC$PhotoSize;
            int patternColor;
            int patternColor2;
            this.currentWallpaper = object;
            this.imageView.setVisibility(0);
            this.imageView2.setVisibility(4);
            this.imageView.setBackgroundDrawable(null);
            this.imageView.getImageReceiver().setColorFilter(null);
            this.imageView.getImageReceiver().setAlpha(1.0f);
            this.imageView.getImageReceiver().setBlendMode(null);
            this.imageView.getImageReceiver().setGradientBitmap(null);
            this.isSelected = object == selectedWallpaper;
            if (object instanceof TLRPC$TL_wallPaper) {
                TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) object;
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_wallPaper.document.thumbs, 100);
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_wallPaper.document.thumbs, 320);
                tLRPC$PhotoSize = closestPhotoSizeWithSize2 != closestPhotoSizeWithSize ? closestPhotoSizeWithSize2 : null;
                int i = tLRPC$PhotoSize != null ? tLRPC$PhotoSize.size : tLRPC$TL_wallPaper.document.size;
                if (!tLRPC$TL_wallPaper.pattern) {
                    if (tLRPC$PhotoSize != null) {
                        this.imageView.setImage(ImageLocation.getForDocument(tLRPC$PhotoSize, tLRPC$TL_wallPaper.document), "100_100", ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$TL_wallPaper.document), "100_100_b", "jpg", i, 1, tLRPC$TL_wallPaper);
                        return;
                    } else {
                        this.imageView.setImage(ImageLocation.getForDocument(tLRPC$TL_wallPaper.document), "100_100", ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$TL_wallPaper.document), "100_100_b", "jpg", i, 1, tLRPC$TL_wallPaper);
                        return;
                    }
                }
                TLRPC$WallPaperSettings tLRPC$WallPaperSettings = tLRPC$TL_wallPaper.settings;
                if (tLRPC$WallPaperSettings.third_background_color != 0) {
                    TLRPC$WallPaperSettings tLRPC$WallPaperSettings2 = tLRPC$TL_wallPaper.settings;
                    MotionBackgroundDrawable motionBackgroundDrawable = new MotionBackgroundDrawable(tLRPC$WallPaperSettings2.background_color, tLRPC$WallPaperSettings2.second_background_color, tLRPC$WallPaperSettings2.third_background_color, tLRPC$WallPaperSettings2.fourth_background_color, true);
                    if (tLRPC$TL_wallPaper.settings.intensity >= 0 || !Theme.getActiveTheme().isDark()) {
                        this.imageView.setBackground(motionBackgroundDrawable);
                        if (Build.VERSION.SDK_INT >= 29) {
                            this.imageView.getImageReceiver().setBlendMode(BlendMode.SOFT_LIGHT);
                        }
                    } else {
                        this.imageView.getImageReceiver().setGradientBitmap(motionBackgroundDrawable.getBitmap());
                    }
                    TLRPC$WallPaperSettings tLRPC$WallPaperSettings3 = tLRPC$TL_wallPaper.settings;
                    patternColor2 = MotionBackgroundDrawable.getPatternColor(tLRPC$WallPaperSettings3.background_color, tLRPC$WallPaperSettings3.second_background_color, tLRPC$WallPaperSettings3.third_background_color, tLRPC$WallPaperSettings3.fourth_background_color);
                } else {
                    this.imageView.setBackgroundColor(Theme.getWallpaperColor(tLRPC$WallPaperSettings.background_color));
                    patternColor2 = AndroidUtilities.getPatternColor(tLRPC$TL_wallPaper.settings.background_color);
                }
                if (Build.VERSION.SDK_INT < 29 || tLRPC$TL_wallPaper.settings.third_background_color == 0) {
                    this.imageView.getImageReceiver().setColorFilter(new PorterDuffColorFilter(AndroidUtilities.getPatternColor(patternColor2), PorterDuff.Mode.SRC_IN));
                }
                if (tLRPC$PhotoSize != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$PhotoSize, tLRPC$TL_wallPaper.document), "100_100", ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$TL_wallPaper.document), null, "jpg", i, 1, tLRPC$TL_wallPaper);
                } else {
                    this.imageView.setImage(ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$TL_wallPaper.document), "100_100", null, null, "jpg", i, 1, tLRPC$TL_wallPaper);
                }
                this.imageView.getImageReceiver().setAlpha(Math.abs(tLRPC$TL_wallPaper.settings.intensity) / 100.0f);
                return;
            }
            if (object instanceof WallpapersListActivity.ColorWallpaper) {
                WallpapersListActivity.ColorWallpaper colorWallpaper = (WallpapersListActivity.ColorWallpaper) object;
                if (colorWallpaper.path != null || colorWallpaper.pattern != null || "d".equals(colorWallpaper.slug)) {
                    if (colorWallpaper.gradientColor2 != 0) {
                        MotionBackgroundDrawable motionBackgroundDrawable2 = new MotionBackgroundDrawable(colorWallpaper.color, colorWallpaper.gradientColor1, colorWallpaper.gradientColor2, colorWallpaper.gradientColor3, true);
                        if (colorWallpaper.intensity >= 0.0f) {
                            this.imageView.setBackground(new MotionBackgroundDrawable(colorWallpaper.color, colorWallpaper.gradientColor1, colorWallpaper.gradientColor2, colorWallpaper.gradientColor3, true));
                            if (Build.VERSION.SDK_INT >= 29) {
                                this.imageView.getImageReceiver().setBlendMode(BlendMode.SOFT_LIGHT);
                            }
                        } else {
                            this.imageView.getImageReceiver().setGradientBitmap(motionBackgroundDrawable2.getBitmap());
                        }
                        patternColor = MotionBackgroundDrawable.getPatternColor(colorWallpaper.color, colorWallpaper.gradientColor1, colorWallpaper.gradientColor2, colorWallpaper.gradientColor3);
                    } else {
                        patternColor = AndroidUtilities.getPatternColor(colorWallpaper.color);
                    }
                    if ("d".equals(colorWallpaper.slug)) {
                        if (colorWallpaper.defaultCache == null) {
                            colorWallpaper.defaultCache = SvgHelper.getBitmap(R.raw.eitaa_bg3, 100, 180, -16777216);
                        }
                        this.imageView.setImageBitmap(colorWallpaper.defaultCache);
                        this.imageView.getImageReceiver().setAlpha(Math.abs(colorWallpaper.intensity));
                        return;
                    }
                    File file = colorWallpaper.path;
                    if (file != null) {
                        this.imageView.setImage(file.getAbsolutePath(), "100_100", null);
                        return;
                    }
                    TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(colorWallpaper.pattern.document.thumbs, 100);
                    this.imageView.setImage(ImageLocation.getForDocument(closestPhotoSizeWithSize3, colorWallpaper.pattern.document), "100_100", null, null, "jpg", closestPhotoSizeWithSize3 != null ? closestPhotoSizeWithSize3.size : colorWallpaper.pattern.document.size, 1, colorWallpaper.pattern);
                    this.imageView.getImageReceiver().setAlpha(Math.abs(colorWallpaper.intensity));
                    if (Build.VERSION.SDK_INT < 29 || colorWallpaper.gradientColor2 == 0) {
                        this.imageView.getImageReceiver().setColorFilter(new PorterDuffColorFilter(AndroidUtilities.getPatternColor(patternColor), PorterDuff.Mode.SRC_IN));
                        return;
                    }
                    return;
                }
                this.imageView.setImageBitmap(null);
                if (colorWallpaper.isGradient) {
                    this.imageView.setBackground(new MotionBackgroundDrawable(colorWallpaper.color, colorWallpaper.gradientColor1, colorWallpaper.gradientColor2, colorWallpaper.gradientColor3, true));
                    return;
                } else if (colorWallpaper.gradientColor1 != 0) {
                    this.imageView.setBackground(new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{colorWallpaper.color | (-16777216), colorWallpaper.gradientColor1 | (-16777216)}));
                    return;
                } else {
                    this.imageView.setBackgroundColor(colorWallpaper.color | (-16777216));
                    return;
                }
            }
            if (object instanceof WallpapersListActivity.FileWallpaper) {
                WallpapersListActivity.FileWallpaper fileWallpaper = (WallpapersListActivity.FileWallpaper) object;
                File file2 = fileWallpaper.originalPath;
                if (file2 != null) {
                    this.imageView.setImage(file2.getAbsolutePath(), "100_100", null);
                    return;
                }
                File file3 = fileWallpaper.path;
                if (file3 != null) {
                    this.imageView.setImage(file3.getAbsolutePath(), "100_100", null);
                    return;
                } else if ("t".equals(fileWallpaper.slug)) {
                    BackupImageView backupImageView = this.imageView;
                    backupImageView.setImageDrawable(Theme.getThemedWallpaper(true, backupImageView));
                    return;
                } else {
                    this.imageView.setImageResource(fileWallpaper.thumbResId);
                    return;
                }
            }
            if (object instanceof MediaController.SearchImage) {
                MediaController.SearchImage searchImage = (MediaController.SearchImage) object;
                TLRPC$Photo tLRPC$Photo = searchImage.photo;
                if (tLRPC$Photo != null) {
                    TLRPC$PhotoSize closestPhotoSizeWithSize4 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, 100);
                    TLRPC$PhotoSize closestPhotoSizeWithSize5 = FileLoader.getClosestPhotoSizeWithSize(searchImage.photo.sizes, 320);
                    tLRPC$PhotoSize = closestPhotoSizeWithSize5 != closestPhotoSizeWithSize4 ? closestPhotoSizeWithSize5 : null;
                    this.imageView.setImage(ImageLocation.getForPhoto(tLRPC$PhotoSize, searchImage.photo), "100_100", ImageLocation.getForPhoto(closestPhotoSizeWithSize4, searchImage.photo), "100_100_b", "jpg", tLRPC$PhotoSize != null ? tLRPC$PhotoSize.size : 0, 1, searchImage);
                    return;
                }
                this.imageView.setImage(searchImage.thumbUrl, "100_100", null);
                return;
            }
            this.isSelected = false;
        }

        public void setChecked(final boolean checked, boolean animated) {
            if (this.checkBox.getVisibility() != 0) {
                this.checkBox.setVisibility(0);
            }
            this.checkBox.setChecked(checked, animated);
            AnimatorSet animatorSet = this.animator;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.animator = null;
            }
            if (animated) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.animator = animatorSet2;
                Animator[] animatorArr = new Animator[2];
                BackupImageView backupImageView = this.imageView;
                float[] fArr = new float[1];
                fArr[0] = checked ? 0.8875f : 1.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(backupImageView, "scaleX", fArr);
                BackupImageView backupImageView2 = this.imageView;
                float[] fArr2 = new float[1];
                fArr2[0] = checked ? 0.8875f : 1.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(backupImageView2, "scaleY", fArr2);
                animatorSet2.playTogether(animatorArr);
                this.animator.setDuration(200L);
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.WallpaperCell.WallpaperView.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (WallpaperView.this.animator == null || !WallpaperView.this.animator.equals(animation)) {
                            return;
                        }
                        WallpaperView.this.animator = null;
                        if (checked) {
                            return;
                        }
                        WallpaperView.this.setBackgroundColor(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        if (WallpaperView.this.animator == null || !WallpaperView.this.animator.equals(animation)) {
                            return;
                        }
                        WallpaperView.this.animator = null;
                    }
                });
                this.animator.start();
            } else {
                this.imageView.setScaleX(checked ? 0.8875f : 1.0f);
                this.imageView.setScaleY(checked ? 0.8875f : 1.0f);
            }
            invalidate();
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            this.imageView.invalidate();
        }

        @Override // android.view.View
        public void clearAnimation() {
            super.clearAnimation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.animator = null;
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (!this.checkBox.isChecked() && this.imageView.getImageReceiver().hasBitmapImage() && this.imageView.getImageReceiver().getCurrentAlpha() == 1.0f) {
                return;
            }
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), WallpaperCell.this.backgroundPaint);
        }
    }

    public WallpaperCell(Context context) {
        super(context);
        this.spanCount = 3;
        this.wallpaperViews = new WallpaperView[5];
        final int i = 0;
        while (true) {
            WallpaperView[] wallpaperViewArr = this.wallpaperViews;
            if (i < wallpaperViewArr.length) {
                final WallpaperView wallpaperView = new WallpaperView(context);
                wallpaperViewArr[i] = wallpaperView;
                addView(wallpaperView);
                wallpaperView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$WallpaperCell$zfIfOOTp4aaOOCLaZ9q4XM0G5Ig
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$new$0$WallpaperCell(wallpaperView, i, view);
                    }
                });
                wallpaperView.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$WallpaperCell$9MRuYaNuBOQ6gAPcTNnWv-1cdHA
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return this.f$0.lambda$new$1$WallpaperCell(wallpaperView, i, view);
                    }
                });
                i++;
            } else {
                Paint paint = new Paint();
                this.framePaint = paint;
                paint.setColor(855638016);
                this.circlePaint = new Paint(1);
                this.checkDrawable = context.getResources().getDrawable(R.drawable.background_selected).mutate();
                Paint paint2 = new Paint();
                this.backgroundPaint = paint2;
                paint2.setColor(Theme.getColor("sharedMedia_photoPlaceholder"));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$WallpaperCell(WallpaperView wallpaperView, int i, View view) {
        onWallpaperClick(wallpaperView.currentWallpaper, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$1$WallpaperCell(WallpaperView wallpaperView, int i, View view) {
        return onWallpaperLongClick(wallpaperView.currentWallpaper, i);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int iDp = size - AndroidUtilities.dp(((this.spanCount - 1) * 6) + 28);
        int i = iDp / this.spanCount;
        int iDp2 = this.currentType == 0 ? AndroidUtilities.dp(180.0f) : i;
        int i2 = 0;
        setMeasuredDimension(size, (this.isTop ? AndroidUtilities.dp(14.0f) : 0) + iDp2 + AndroidUtilities.dp(this.isBottom ? 14.0f : 6.0f));
        while (true) {
            int i3 = this.spanCount;
            if (i2 >= i3) {
                return;
            }
            this.wallpaperViews[i2].measure(View.MeasureSpec.makeMeasureSpec(i2 == i3 + (-1) ? iDp : i, 1073741824), View.MeasureSpec.makeMeasureSpec(iDp2, 1073741824));
            iDp -= i;
            i2++;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int iDp = AndroidUtilities.dp(14.0f);
        int iDp2 = this.isTop ? AndroidUtilities.dp(14.0f) : 0;
        for (int i = 0; i < this.spanCount; i++) {
            int measuredWidth = this.wallpaperViews[i].getMeasuredWidth();
            WallpaperView[] wallpaperViewArr = this.wallpaperViews;
            wallpaperViewArr[i].layout(iDp, iDp2, iDp + measuredWidth, wallpaperViewArr[i].getMeasuredHeight() + iDp2);
            iDp += measuredWidth + AndroidUtilities.dp(6.0f);
        }
    }

    public void setParams(int columns, boolean top, boolean bottom) {
        this.spanCount = columns;
        this.isTop = top;
        this.isBottom = bottom;
        int i = 0;
        while (true) {
            WallpaperView[] wallpaperViewArr = this.wallpaperViews;
            if (i >= wallpaperViewArr.length) {
                return;
            }
            wallpaperViewArr[i].setVisibility(i < columns ? 0 : 8);
            this.wallpaperViews[i].clearAnimation();
            i++;
        }
    }

    public void setWallpaper(int type, int index, Object wallpaper, Object selectedWallpaper, Drawable themedWallpaper, boolean themed) {
        this.currentType = type;
        if (wallpaper == null) {
            this.wallpaperViews[index].setVisibility(8);
            this.wallpaperViews[index].clearAnimation();
        } else {
            this.wallpaperViews[index].setVisibility(0);
            this.wallpaperViews[index].setWallpaper(wallpaper, selectedWallpaper, themedWallpaper, themed);
        }
    }

    public void setChecked(int index, final boolean checked, final boolean animated) {
        this.wallpaperViews[index].setChecked(checked, animated);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        for (int i = 0; i < this.spanCount; i++) {
            this.wallpaperViews[i].invalidate();
        }
    }
}
