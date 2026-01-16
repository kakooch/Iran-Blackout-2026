package ir.eitaa.ui.Components;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$PageBlock;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupedPhotosListView extends View implements GestureDetector.OnGestureListener {
    private boolean animateAllLine;
    private boolean animateBackground;
    private int animateToDX;
    private int animateToDXStart;
    private int animateToItem;
    private boolean animateToItemFast;
    private boolean animationsEnabled;
    private Paint backgroundPaint;
    private long currentGroupId;
    private int currentImage;
    private float currentItemProgress;
    private ArrayList<Object> currentObjects;
    public ArrayList<ImageLocation> currentPhotos;
    private GroupedPhotosListViewDelegate delegate;
    private float drawAlpha;
    private int drawDx;
    private GestureDetector gestureDetector;
    private boolean hasPhotos;
    private ValueAnimator hideAnimator;
    private boolean ignoreChanges;
    private ArrayList<ImageReceiver> imagesToDraw;
    private int itemHeight;
    private int itemSpacing;
    private int itemWidth;
    private int itemY;
    private long lastUpdateTime;
    private float moveLineProgress;
    private boolean moving;
    private int nextImage;
    private float nextItemProgress;
    private int nextPhotoScrolling;
    private android.widget.Scroller scroll;
    private boolean scrolling;
    private ValueAnimator showAnimator;
    private boolean stopedScrolling;
    private ArrayList<ImageReceiver> unusedReceivers;

    public interface GroupedPhotosListViewDelegate {
        long getAvatarsDialogId();

        int getCurrentAccount();

        int getCurrentIndex();

        ArrayList<MessageObject> getImagesArr();

        ArrayList<ImageLocation> getImagesArrLocations();

        List<TLRPC$PageBlock> getPageBlockArr();

        Object getParentObject();

        int getSlideshowMessageId();

        void onShowAnimationStart();

        void onStopScrolling();

        void setCurrentIndex(int index);

        boolean validGroupId(long groupId);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent e) {
    }

    public GroupedPhotosListView(Context context, int paddingTop) {
        super(context);
        this.backgroundPaint = new Paint();
        this.unusedReceivers = new ArrayList<>();
        this.imagesToDraw = new ArrayList<>();
        this.currentPhotos = new ArrayList<>();
        this.currentObjects = new ArrayList<>();
        this.currentItemProgress = 1.0f;
        this.nextItemProgress = 0.0f;
        this.animateToItem = -1;
        this.animationsEnabled = true;
        this.nextPhotoScrolling = -1;
        this.animateBackground = true;
        this.gestureDetector = new GestureDetector(context, this);
        this.scroll = new android.widget.Scroller(context);
        this.itemWidth = AndroidUtilities.dp(42.0f);
        this.itemHeight = AndroidUtilities.dp(56.0f);
        this.itemSpacing = AndroidUtilities.dp(1.0f);
        this.itemY = paddingTop;
        this.backgroundPaint.setColor(2130706432);
    }

    public void clear() {
        this.currentPhotos.clear();
        this.currentObjects.clear();
        this.imagesToDraw.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x024f  */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v6, types: [ir.eitaa.messenger.MessageObject] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void fillList() {
        /*
            Method dump skipped, instructions count: 933
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.GroupedPhotosListView.fillList():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fillList$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fillList$0$GroupedPhotosListView(ValueAnimator valueAnimator) {
        this.drawAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fillList$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fillList$1$GroupedPhotosListView(ValueAnimator valueAnimator) {
        this.drawAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void setMoveProgress(float progress) {
        if (this.scrolling || this.animateToItem >= 0) {
            return;
        }
        if (progress > 0.0f) {
            this.nextImage = this.currentImage - 1;
        } else {
            this.nextImage = this.currentImage + 1;
        }
        int i = this.nextImage;
        if (i >= 0 && i < this.currentPhotos.size()) {
            this.currentItemProgress = 1.0f - Math.abs(progress);
        } else {
            this.currentItemProgress = 1.0f;
        }
        this.nextItemProgress = 1.0f - this.currentItemProgress;
        this.moving = progress != 0.0f;
        invalidate();
        if (this.currentPhotos.isEmpty()) {
            return;
        }
        if (progress >= 0.0f || this.currentImage != this.currentPhotos.size() - 1) {
            if (progress <= 0.0f || this.currentImage != 0) {
                int i2 = (int) (progress * (this.itemWidth + this.itemSpacing));
                this.drawDx = i2;
                fillImages(true, i2);
            }
        }
    }

    private ImageReceiver getFreeReceiver() {
        ImageReceiver imageReceiver;
        if (this.unusedReceivers.isEmpty()) {
            imageReceiver = new ImageReceiver(this);
        } else {
            imageReceiver = this.unusedReceivers.get(0);
            this.unusedReceivers.remove(0);
        }
        this.imagesToDraw.add(imageReceiver);
        imageReceiver.setCurrentAccount(this.delegate.getCurrentAccount());
        return imageReceiver;
    }

    private void fillImages(boolean move, int dx) {
        int iMax;
        int iMin;
        Object parentObject;
        Object parentObject2;
        if (!move && !this.imagesToDraw.isEmpty()) {
            this.unusedReceivers.addAll(this.imagesToDraw);
            this.imagesToDraw.clear();
            this.moving = false;
            this.moveLineProgress = 1.0f;
            this.currentItemProgress = 1.0f;
            this.nextItemProgress = 0.0f;
        }
        invalidate();
        if (getMeasuredWidth() == 0 || this.currentPhotos.isEmpty()) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (this.itemWidth / 2);
        if (move) {
            int size = this.imagesToDraw.size();
            int i = 0;
            iMax = Integer.MIN_VALUE;
            iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
            while (i < size) {
                ImageReceiver imageReceiver = this.imagesToDraw.get(i);
                int param = imageReceiver.getParam();
                int i2 = param - this.currentImage;
                int i3 = this.itemWidth;
                int i4 = (i2 * (this.itemSpacing + i3)) + measuredWidth2 + dx;
                if (i4 > measuredWidth || i4 + i3 < 0) {
                    this.unusedReceivers.add(imageReceiver);
                    this.imagesToDraw.remove(i);
                    size--;
                    i--;
                }
                iMin = Math.min(iMin, param - 1);
                iMax = Math.max(iMax, param + 1);
                i++;
            }
        } else {
            iMax = this.currentImage;
            iMin = iMax - 1;
        }
        if (iMax != Integer.MIN_VALUE) {
            int size2 = this.currentPhotos.size();
            while (iMax < size2) {
                int i5 = ((iMax - this.currentImage) * (this.itemWidth + this.itemSpacing)) + measuredWidth2 + dx;
                if (i5 >= measuredWidth) {
                    break;
                }
                ImageLocation imageLocation = this.currentPhotos.get(iMax);
                ImageReceiver freeReceiver = getFreeReceiver();
                freeReceiver.setImageCoords(i5, this.itemY, this.itemWidth, this.itemHeight);
                if (this.currentObjects.get(0) instanceof MessageObject) {
                    parentObject2 = this.currentObjects.get(iMax);
                } else if (this.currentObjects.get(0) instanceof TLRPC$PageBlock) {
                    parentObject2 = this.delegate.getParentObject();
                } else {
                    parentObject2 = "avatar_" + this.delegate.getAvatarsDialogId();
                }
                freeReceiver.setImage(null, null, imageLocation, "80_80", 0, null, parentObject2, 1);
                freeReceiver.setParam(iMax);
                iMax++;
            }
        }
        if (iMin != Integer.MAX_VALUE) {
            while (iMin >= 0) {
                int i6 = iMin - this.currentImage;
                int i7 = this.itemWidth;
                int i8 = (i6 * (this.itemSpacing + i7)) + measuredWidth2 + dx + i7;
                if (i8 <= 0) {
                    break;
                }
                ImageLocation imageLocation2 = this.currentPhotos.get(iMin);
                ImageReceiver freeReceiver2 = getFreeReceiver();
                freeReceiver2.setImageCoords(i8, this.itemY, this.itemWidth, this.itemHeight);
                if (this.currentObjects.get(0) instanceof MessageObject) {
                    parentObject = this.currentObjects.get(iMin);
                } else if (this.currentObjects.get(0) instanceof TLRPC$PageBlock) {
                    parentObject = this.delegate.getParentObject();
                } else {
                    parentObject = "avatar_" + this.delegate.getAvatarsDialogId();
                }
                freeReceiver2.setImage(null, null, imageLocation2, "80_80", 0, null, parentObject, 1);
                freeReceiver2.setParam(iMin);
                iMin--;
            }
        }
        ValueAnimator valueAnimator = this.showAnimator;
        if (valueAnimator == null || valueAnimator.isStarted()) {
            return;
        }
        this.showAnimator.start();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e) {
        if (!this.scroll.isFinished()) {
            this.scroll.abortAnimation();
        }
        this.animateToItem = -1;
        this.animateToItemFast = false;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        int currentIndex = this.delegate.getCurrentIndex();
        ArrayList<ImageLocation> imagesArrLocations = this.delegate.getImagesArrLocations();
        ArrayList<MessageObject> imagesArr = this.delegate.getImagesArr();
        List<TLRPC$PageBlock> pageBlockArr = this.delegate.getPageBlockArr();
        stopScrolling();
        int size = this.imagesToDraw.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            ImageReceiver imageReceiver = this.imagesToDraw.get(i);
            if (imageReceiver.isInsideImage(e.getX(), e.getY())) {
                int param = imageReceiver.getParam();
                if (param < 0 || param >= this.currentObjects.size()) {
                    return true;
                }
                if (imagesArr != null && !imagesArr.isEmpty()) {
                    int iIndexOf = imagesArr.indexOf((MessageObject) this.currentObjects.get(param));
                    if (currentIndex == iIndexOf) {
                        return true;
                    }
                    this.moveLineProgress = 1.0f;
                    this.animateAllLine = true;
                    this.delegate.setCurrentIndex(iIndexOf);
                } else if (pageBlockArr != null && !pageBlockArr.isEmpty()) {
                    int iIndexOf2 = pageBlockArr.indexOf((TLRPC$PageBlock) this.currentObjects.get(param));
                    if (currentIndex == iIndexOf2) {
                        return true;
                    }
                    this.moveLineProgress = 1.0f;
                    this.animateAllLine = true;
                    this.delegate.setCurrentIndex(iIndexOf2);
                } else if (imagesArrLocations != null && !imagesArrLocations.isEmpty()) {
                    int iIndexOf3 = imagesArrLocations.indexOf((ImageLocation) this.currentObjects.get(param));
                    if (currentIndex == iIndexOf3) {
                        return true;
                    }
                    this.moveLineProgress = 1.0f;
                    this.animateAllLine = true;
                    this.delegate.setCurrentIndex(iIndexOf3);
                }
            } else {
                i++;
            }
        }
        return false;
    }

    private void updateAfterScroll() {
        int i;
        int i2;
        int i3;
        int i4 = this.drawDx;
        int iAbs = Math.abs(i4);
        int i5 = this.itemWidth;
        int i6 = this.itemSpacing;
        int iIndexOf = -1;
        if (iAbs > (i5 / 2) + i6) {
            if (i4 > 0) {
                i2 = i4 - ((i5 / 2) + i6);
                i3 = 1;
            } else {
                i2 = i4 + (i5 / 2) + i6;
                i3 = -1;
            }
            i = i3 + (i2 / (i5 + (i6 * 2)));
        } else {
            i = 0;
        }
        this.nextPhotoScrolling = this.currentImage - i;
        int currentIndex = this.delegate.getCurrentIndex();
        ArrayList<ImageLocation> imagesArrLocations = this.delegate.getImagesArrLocations();
        ArrayList<MessageObject> imagesArr = this.delegate.getImagesArr();
        List<TLRPC$PageBlock> pageBlockArr = this.delegate.getPageBlockArr();
        int i7 = this.nextPhotoScrolling;
        if (currentIndex != i7 && i7 >= 0 && i7 < this.currentPhotos.size()) {
            Object obj = this.currentObjects.get(this.nextPhotoScrolling);
            if (imagesArr != null && !imagesArr.isEmpty()) {
                iIndexOf = imagesArr.indexOf((MessageObject) obj);
            } else if (pageBlockArr != null && !pageBlockArr.isEmpty()) {
                iIndexOf = pageBlockArr.indexOf((TLRPC$PageBlock) obj);
            } else if (imagesArrLocations != null && !imagesArrLocations.isEmpty()) {
                iIndexOf = imagesArrLocations.indexOf((ImageLocation) obj);
            }
            if (iIndexOf >= 0) {
                this.ignoreChanges = true;
                this.delegate.setCurrentIndex(iIndexOf);
            }
        }
        if (!this.scrolling) {
            this.scrolling = true;
            this.stopedScrolling = false;
        }
        fillImages(true, this.drawDx);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        this.drawDx = (int) (this.drawDx - distanceX);
        int minScrollX = getMinScrollX();
        int maxScrollX = getMaxScrollX();
        int i = this.drawDx;
        if (i < minScrollX) {
            this.drawDx = minScrollX;
        } else if (i > maxScrollX) {
            this.drawDx = maxScrollX;
        }
        updateAfterScroll();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.scroll.abortAnimation();
        if (this.currentPhotos.size() < 10) {
            return false;
        }
        this.scroll.fling(this.drawDx, 0, Math.round(velocityX), 0, getMinScrollX(), getMaxScrollX(), 0, 0);
        return false;
    }

    private void stopScrolling() {
        this.scrolling = false;
        if (!this.scroll.isFinished()) {
            this.scroll.abortAnimation();
        }
        int i = this.nextPhotoScrolling;
        if (i >= 0 && i < this.currentObjects.size()) {
            this.stopedScrolling = true;
            this.animateToItemFast = false;
            int i2 = this.nextPhotoScrolling;
            this.animateToItem = i2;
            this.nextImage = i2;
            this.animateToDX = (this.currentImage - i2) * (this.itemWidth + this.itemSpacing);
            this.animateToDXStart = this.drawDx;
            this.moveLineProgress = 1.0f;
            this.nextPhotoScrolling = -1;
            GroupedPhotosListViewDelegate groupedPhotosListViewDelegate = this.delegate;
            if (groupedPhotosListViewDelegate != null) {
                groupedPhotosListViewDelegate.onStopScrolling();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.currentPhotos.isEmpty() && getAlpha() == 1.0f) {
            z = this.gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
            if (this.scrolling && event.getAction() == 1 && this.scroll.isFinished()) {
                stopScrolling();
            }
        }
        return z;
    }

    private int getMinScrollX() {
        return (-((this.currentPhotos.size() - this.currentImage) - 1)) * (this.itemWidth + (this.itemSpacing * 2));
    }

    private int getMaxScrollX() {
        return this.currentImage * (this.itemWidth + (this.itemSpacing * 2));
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        fillImages(false, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int iMax;
        int iMax2;
        TLRPC$PhotoSize tLRPC$PhotoSize;
        TLRPC$PhotoSize tLRPC$PhotoSize2;
        if (this.hasPhotos || !this.imagesToDraw.isEmpty()) {
            float f = this.drawAlpha;
            if (!this.animateBackground) {
                f = this.hasPhotos ? 1.0f : 0.0f;
            }
            this.backgroundPaint.setAlpha((int) (f * 127.0f));
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.backgroundPaint);
            if (this.imagesToDraw.isEmpty()) {
                return;
            }
            int size = this.imagesToDraw.size();
            int i = this.drawDx;
            int i2 = (int) (this.itemWidth * 2.0f);
            int iDp = AndroidUtilities.dp(8.0f);
            ImageLocation imageLocation = this.currentPhotos.get(this.currentImage);
            if (imageLocation != null && (tLRPC$PhotoSize2 = imageLocation.photoSize) != null) {
                iMax = Math.max(this.itemWidth, (int) (tLRPC$PhotoSize2.w * (this.itemHeight / tLRPC$PhotoSize2.h)));
            } else {
                iMax = this.itemHeight;
            }
            int iMin = Math.min(i2, iMax);
            float f2 = iDp * 2;
            float f3 = this.currentItemProgress;
            int i3 = (int) (f2 * f3);
            int i4 = this.itemWidth + ((int) ((iMin - r10) * f3)) + i3;
            int i5 = this.nextImage;
            if (i5 >= 0 && i5 < this.currentPhotos.size()) {
                ImageLocation imageLocation2 = this.currentPhotos.get(this.nextImage);
                if (imageLocation2 != null && (tLRPC$PhotoSize = imageLocation2.photoSize) != null) {
                    iMax2 = Math.max(this.itemWidth, (int) (tLRPC$PhotoSize.w * (this.itemHeight / tLRPC$PhotoSize.h)));
                } else {
                    iMax2 = this.itemHeight;
                }
            } else {
                iMax2 = this.itemWidth;
            }
            int iMin2 = Math.min(i2, iMax2);
            float f4 = this.nextItemProgress;
            int i6 = (int) (f2 * f4);
            float f5 = i;
            int i7 = (int) (f5 + ((((iMin2 + i6) - r11) / 2) * f4 * (this.nextImage > this.currentImage ? -1 : 1)));
            int i8 = this.itemWidth + ((int) ((iMin2 - r11) * f4)) + i6;
            int measuredWidth = (getMeasuredWidth() - i4) / 2;
            for (int i9 = 0; i9 < size; i9++) {
                ImageReceiver imageReceiver = this.imagesToDraw.get(i9);
                int param = imageReceiver.getParam();
                int i10 = this.currentImage;
                if (param == i10) {
                    imageReceiver.setImageX(measuredWidth + i7 + (i3 / 2));
                    imageReceiver.setImageWidth(i4 - i3);
                } else {
                    int i11 = this.nextImage;
                    if (i11 < i10) {
                        if (param >= i10) {
                            imageReceiver.setImageX(measuredWidth + i4 + this.itemSpacing + (((imageReceiver.getParam() - this.currentImage) - 1) * (this.itemWidth + this.itemSpacing)) + i7);
                        } else if (param <= i11) {
                            int param2 = (imageReceiver.getParam() - this.currentImage) + 1;
                            int i12 = this.itemWidth;
                            int i13 = this.itemSpacing;
                            imageReceiver.setImageX((((param2 * (i12 + i13)) + measuredWidth) - (i13 + i8)) + i7);
                        } else {
                            imageReceiver.setImageX(((imageReceiver.getParam() - this.currentImage) * (this.itemWidth + this.itemSpacing)) + measuredWidth + i7);
                        }
                    } else if (param < i10) {
                        imageReceiver.setImageX(((imageReceiver.getParam() - this.currentImage) * (this.itemWidth + this.itemSpacing)) + measuredWidth + i7);
                    } else if (param <= i11) {
                        imageReceiver.setImageX(measuredWidth + i4 + this.itemSpacing + (((imageReceiver.getParam() - this.currentImage) - 1) * (this.itemWidth + this.itemSpacing)) + i7);
                    } else {
                        int i14 = measuredWidth + i4 + this.itemSpacing;
                        int param3 = (imageReceiver.getParam() - this.currentImage) - 2;
                        int i15 = this.itemWidth;
                        int i16 = this.itemSpacing;
                        imageReceiver.setImageX(i14 + (param3 * (i15 + i16)) + i16 + i8 + i7);
                    }
                    if (param == this.nextImage) {
                        imageReceiver.setImageWidth(i8 - i6);
                        imageReceiver.setImageX((int) (imageReceiver.getImageX() + (i6 / 2)));
                    } else {
                        imageReceiver.setImageWidth(this.itemWidth);
                    }
                }
                imageReceiver.setAlpha(this.drawAlpha);
                imageReceiver.draw(canvas);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.lastUpdateTime;
            if (j > 17) {
                j = 17;
            }
            this.lastUpdateTime = jCurrentTimeMillis;
            int i17 = this.animateToItem;
            if (i17 >= 0) {
                float f6 = this.moveLineProgress;
                if (f6 > 0.0f) {
                    float f7 = j;
                    float f8 = f6 - (f7 / (this.animateToItemFast ? 100.0f : 200.0f));
                    this.moveLineProgress = f8;
                    if (i17 == this.currentImage) {
                        float f9 = this.currentItemProgress;
                        if (f9 < 1.0f) {
                            float f10 = f9 + (f7 / 200.0f);
                            this.currentItemProgress = f10;
                            if (f10 > 1.0f) {
                                this.currentItemProgress = 1.0f;
                            }
                        }
                        this.drawDx = this.animateToDXStart + ((int) Math.ceil(this.currentItemProgress * (this.animateToDX - r1)));
                    } else {
                        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.EASE_OUT;
                        this.nextItemProgress = cubicBezierInterpolator.getInterpolation(1.0f - f8);
                        if (this.stopedScrolling) {
                            float f11 = this.currentItemProgress;
                            if (f11 > 0.0f) {
                                float f12 = f11 - (f7 / 200.0f);
                                this.currentItemProgress = f12;
                                if (f12 < 0.0f) {
                                    this.currentItemProgress = 0.0f;
                                }
                            }
                            this.drawDx = this.animateToDXStart + ((int) Math.ceil(r5 * (this.animateToDX - r1)));
                        } else {
                            this.currentItemProgress = cubicBezierInterpolator.getInterpolation(this.moveLineProgress);
                            this.drawDx = (int) Math.ceil(this.nextItemProgress * this.animateToDX);
                        }
                    }
                    if (this.moveLineProgress <= 0.0f) {
                        this.currentImage = this.animateToItem;
                        this.moveLineProgress = 1.0f;
                        this.currentItemProgress = 1.0f;
                        this.nextItemProgress = 0.0f;
                        this.moving = false;
                        this.stopedScrolling = false;
                        this.drawDx = 0;
                        this.animateToItem = -1;
                        this.animateToItemFast = false;
                    }
                }
                fillImages(true, this.drawDx);
                invalidate();
            }
            if (this.scrolling) {
                float f13 = this.currentItemProgress;
                if (f13 > 0.0f) {
                    float f14 = f13 - (j / 200.0f);
                    this.currentItemProgress = f14;
                    if (f14 < 0.0f) {
                        this.currentItemProgress = 0.0f;
                    }
                    invalidate();
                }
            }
            if (this.scroll.isFinished()) {
                return;
            }
            if (this.scroll.computeScrollOffset()) {
                this.drawDx = this.scroll.getCurrX();
                updateAfterScroll();
                invalidate();
            }
            if (this.scroll.isFinished()) {
                stopScrolling();
            }
        }
    }

    public void setDelegate(GroupedPhotosListViewDelegate groupedPhotosListViewDelegate) {
        this.delegate = groupedPhotosListViewDelegate;
    }

    public boolean hasPhotos() {
        ValueAnimator valueAnimator;
        return this.hasPhotos && this.hideAnimator == null && (this.drawAlpha > 0.0f || !this.animateBackground || ((valueAnimator = this.showAnimator) != null && valueAnimator.isStarted()));
    }

    public void setAnimationsEnabled(boolean animationsEnabled) {
        if (this.animationsEnabled != animationsEnabled) {
            this.animationsEnabled = animationsEnabled;
            if (animationsEnabled) {
                return;
            }
            ValueAnimator valueAnimator = this.showAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.showAnimator = null;
            }
            ValueAnimator valueAnimator2 = this.hideAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.hideAnimator = null;
            }
            this.drawAlpha = 0.0f;
            invalidate();
        }
    }

    public void setAnimateBackground(boolean animateBackground) {
        this.animateBackground = animateBackground;
    }

    public void reset() {
        this.hasPhotos = false;
        if (this.animationsEnabled) {
            this.drawAlpha = 0.0f;
        }
    }
}
