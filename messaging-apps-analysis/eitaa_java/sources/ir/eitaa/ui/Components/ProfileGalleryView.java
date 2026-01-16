package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.Components.CircularViewPager;
import ir.eitaa.ui.PinchToZoomHelper;
import ir.eitaa.ui.ProfileActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ProfileGalleryView extends CircularViewPager implements NotificationCenter.NotificationCenterDelegate {
    private ViewPagerAdapter adapter;
    private final Callback callback;
    private TLRPC$ChatFull chatInfo;
    private boolean createThumbFromParent;
    ImageLocation curreantUploadingThumbLocation;
    private int currentAccount;
    ImageLocation currentUploadingImageLocation;
    private long dialogId;
    private final PointF downPoint;
    private boolean forceResetPosition;
    private boolean hasActiveVideo;
    private int imagesLayerNum;
    private ArrayList<ImageLocation> imagesLocations;
    private ArrayList<Integer> imagesLocationsSizes;
    private ArrayList<Float> imagesUploadProgress;
    private boolean invalidateWithParent;
    private boolean isDownReleased;
    private final boolean isProfileFragment;
    private boolean isScrollingListView;
    private boolean isSwipingViewPager;
    private final ActionBar parentActionBar;
    private final int parentClassGuid;
    private final RecyclerListView parentListView;
    Path path;
    private ArrayList<TLRPC$Photo> photos;
    PinchToZoomHelper pinchToZoomHelper;
    private ImageLocation prevImageLocation;
    private final SparseArray<RadialProgress2> radialProgresses;
    float[] radii;
    RectF rect;
    private int roundBottomRadius;
    private int roundTopRadius;
    private boolean scrolledByUser;
    private int settingMainPhoto;
    private ArrayList<String> thumbsFileNames;
    private ArrayList<ImageLocation> thumbsLocations;
    private final int touchSlop;
    private ImageLocation uploadingImageLocation;
    private ArrayList<String> videoFileNames;
    private ArrayList<ImageLocation> videoLocations;

    public interface Callback {
        void onDown(boolean left);

        void onPhotosLoaded();

        void onRelease();

        void onVideoSet();
    }

    public void setHasActiveVideo(boolean hasActiveVideo) {
        this.hasActiveVideo = hasActiveVideo;
    }

    public View findVideoActiveView() {
        if (!this.hasActiveVideo) {
            return null;
        }
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TextureStubView) {
                return childAt;
            }
        }
        return null;
    }

    private static class Item {
        private AvatarImageView imageView;
        boolean isActiveVideo;
        private View textureViewStubView;

        private Item() {
        }
    }

    public ProfileGalleryView(Context context, ActionBar parentActionBar, RecyclerListView parentListView, Callback callback) throws Resources.NotFoundException {
        super(context);
        this.downPoint = new PointF();
        this.isScrollingListView = true;
        this.isSwipingViewPager = true;
        this.currentAccount = UserConfig.selectedAccount;
        this.path = new Path();
        this.rect = new RectF();
        this.radii = new float[8];
        this.videoFileNames = new ArrayList<>();
        this.thumbsFileNames = new ArrayList<>();
        this.photos = new ArrayList<>();
        this.videoLocations = new ArrayList<>();
        this.imagesLocations = new ArrayList<>();
        this.thumbsLocations = new ArrayList<>();
        this.imagesLocationsSizes = new ArrayList<>();
        this.imagesUploadProgress = new ArrayList<>();
        this.radialProgresses = new SparseArray<>();
        this.createThumbFromParent = true;
        setOffscreenPageLimit(2);
        this.isProfileFragment = false;
        this.parentListView = parentListView;
        this.parentClassGuid = ConnectionsManager.generateClassGuid();
        this.parentActionBar = parentActionBar;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.callback = callback;
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ir.eitaa.ui.Components.ProfileGalleryView.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ImageLocation imageLocation;
                if (positionOffsetPixels == 0) {
                    int realPosition = ProfileGalleryView.this.adapter.getRealPosition(position);
                    if (ProfileGalleryView.this.hasActiveVideo) {
                        realPosition--;
                    }
                    ProfileGalleryView.this.getCurrentItemView();
                    int childCount = ProfileGalleryView.this.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = ProfileGalleryView.this.getChildAt(i);
                        if (childAt instanceof BackupImageView) {
                            int realPosition2 = ProfileGalleryView.this.adapter.getRealPosition(ProfileGalleryView.this.adapter.imageViews.indexOf(childAt));
                            if (ProfileGalleryView.this.hasActiveVideo) {
                                realPosition2--;
                            }
                            ImageReceiver imageReceiver = ((BackupImageView) childAt).getImageReceiver();
                            boolean allowStartAnimation = imageReceiver.getAllowStartAnimation();
                            if (realPosition2 == realPosition) {
                                if (!allowStartAnimation) {
                                    imageReceiver.setAllowStartAnimation(true);
                                    imageReceiver.startAnimation();
                                }
                                ImageLocation imageLocation2 = (ImageLocation) ProfileGalleryView.this.videoLocations.get(realPosition2);
                                if (imageLocation2 != null) {
                                    FileLoader.getInstance(ProfileGalleryView.this.currentAccount).setForceStreamLoadingFile(imageLocation2.location, "mp4");
                                }
                            } else if (allowStartAnimation) {
                                AnimatedFileDrawable animation = imageReceiver.getAnimation();
                                if (animation != null && (imageLocation = (ImageLocation) ProfileGalleryView.this.videoLocations.get(realPosition2)) != null) {
                                    animation.seekTo(imageLocation.videoSeekTo, false, true);
                                }
                                imageReceiver.setAllowStartAnimation(false);
                                imageReceiver.stopAnimation();
                            }
                        }
                    }
                }
            }
        });
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext(), null, parentActionBar);
        this.adapter = viewPagerAdapter;
        setAdapter((CircularViewPager.Adapter) viewPagerAdapter);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.dialogPhotosLoaded);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoaded);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoadProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.reloadDialogPhotos);
    }

    public void setImagesLayerNum(int value) {
        this.imagesLayerNum = value;
    }

    public ProfileGalleryView(Context context, long dialogId, ActionBar parentActionBar, RecyclerListView parentListView, ProfileActivity.AvatarImageView parentAvatarImageView, int parentClassGuid, Callback callback) throws Resources.NotFoundException {
        super(context);
        this.downPoint = new PointF();
        this.isScrollingListView = true;
        this.isSwipingViewPager = true;
        this.currentAccount = UserConfig.selectedAccount;
        this.path = new Path();
        this.rect = new RectF();
        this.radii = new float[8];
        this.videoFileNames = new ArrayList<>();
        this.thumbsFileNames = new ArrayList<>();
        this.photos = new ArrayList<>();
        this.videoLocations = new ArrayList<>();
        this.imagesLocations = new ArrayList<>();
        this.thumbsLocations = new ArrayList<>();
        this.imagesLocationsSizes = new ArrayList<>();
        this.imagesUploadProgress = new ArrayList<>();
        this.radialProgresses = new SparseArray<>();
        this.createThumbFromParent = true;
        setVisibility(8);
        setOverScrollMode(2);
        setOffscreenPageLimit(2);
        this.isProfileFragment = true;
        this.dialogId = dialogId;
        this.parentListView = parentListView;
        this.parentClassGuid = parentClassGuid;
        this.parentActionBar = parentActionBar;
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext(), parentAvatarImageView, parentActionBar);
        this.adapter = viewPagerAdapter;
        setAdapter((CircularViewPager.Adapter) viewPagerAdapter);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.callback = callback;
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ir.eitaa.ui.Components.ProfileGalleryView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ImageLocation imageLocation;
                if (positionOffsetPixels == 0) {
                    int realPosition = ProfileGalleryView.this.adapter.getRealPosition(position);
                    ProfileGalleryView.this.getCurrentItemView();
                    int childCount = ProfileGalleryView.this.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = ProfileGalleryView.this.getChildAt(i);
                        if (childAt instanceof BackupImageView) {
                            int realPosition2 = ProfileGalleryView.this.adapter.getRealPosition(ProfileGalleryView.this.adapter.imageViews.indexOf(childAt));
                            ImageReceiver imageReceiver = ((BackupImageView) childAt).getImageReceiver();
                            boolean allowStartAnimation = imageReceiver.getAllowStartAnimation();
                            if (realPosition2 == realPosition) {
                                if (!allowStartAnimation) {
                                    imageReceiver.setAllowStartAnimation(true);
                                    imageReceiver.startAnimation();
                                }
                                ImageLocation imageLocation2 = (ImageLocation) ProfileGalleryView.this.videoLocations.get(realPosition2);
                                if (imageLocation2 != null) {
                                    FileLoader.getInstance(ProfileGalleryView.this.currentAccount).setForceStreamLoadingFile(imageLocation2.location, "mp4");
                                }
                            } else if (allowStartAnimation) {
                                AnimatedFileDrawable animation = imageReceiver.getAnimation();
                                if (animation != null && (imageLocation = (ImageLocation) ProfileGalleryView.this.videoLocations.get(realPosition2)) != null) {
                                    animation.seekTo(imageLocation.videoSeekTo, false, true);
                                }
                                imageReceiver.setAllowStartAnimation(false);
                                imageReceiver.stopAnimation();
                            }
                        }
                    }
                }
            }
        });
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.dialogPhotosLoaded);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoaded);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoadProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.reloadDialogPhotos);
        MessagesController.getInstance(this.currentAccount).loadDialogPhotos(dialogId, 80, 0, true, parentClassGuid);
    }

    public void onDestroy() {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.dialogPhotosLoaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoadProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.reloadDialogPhotos);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof BackupImageView) {
                BackupImageView backupImageView = (BackupImageView) childAt;
                if (backupImageView.getImageReceiver().hasStaticThumb()) {
                    Drawable drawable = backupImageView.getImageReceiver().getDrawable();
                    if (drawable instanceof AnimatedFileDrawable) {
                        ((AnimatedFileDrawable) drawable).removeSecondParentView(backupImageView);
                    }
                }
            }
        }
    }

    public void setAnimatedFileMaybe(AnimatedFileDrawable drawable) {
        if (drawable == null || this.adapter == null) {
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof BackupImageView) {
                ViewPagerAdapter viewPagerAdapter = this.adapter;
                if (viewPagerAdapter.getRealPosition(viewPagerAdapter.imageViews.indexOf(childAt)) == 0) {
                    BackupImageView backupImageView = (BackupImageView) childAt;
                    AnimatedFileDrawable animation = backupImageView.getImageReceiver().getAnimation();
                    if (animation != drawable) {
                        if (animation != null) {
                            animation.removeSecondParentView(backupImageView);
                        }
                        backupImageView.setImageDrawable(drawable);
                        drawable.addSecondParentView(this);
                        drawable.setInvalidateParentViewWithSecond(true);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent ev) throws Resources.NotFoundException {
        int extraCount;
        if (this.adapter == null) {
            return false;
        }
        if (this.parentListView.getScrollState() != 0 && !this.isScrollingListView && this.isSwipingViewPager) {
            this.isSwipingViewPager = false;
            MotionEvent motionEventObtain = MotionEvent.obtain(ev);
            motionEventObtain.setAction(3);
            super.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            return false;
        }
        int action = ev.getAction();
        if (this.pinchToZoomHelper != null && getCurrentItemView() != null) {
            if (action != 0 && this.isDownReleased && !this.pinchToZoomHelper.isInOverlayMode()) {
                this.pinchToZoomHelper.checkPinchToZoom(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0), this, getCurrentItemView().getImageReceiver(), null);
            } else if (this.pinchToZoomHelper.checkPinchToZoom(ev, this, getCurrentItemView().getImageReceiver(), null)) {
                if (!this.isDownReleased) {
                    this.isDownReleased = true;
                    this.callback.onRelease();
                }
                return true;
            }
        }
        if (action == 0) {
            this.isScrollingListView = true;
            this.isSwipingViewPager = true;
            this.scrolledByUser = true;
            this.downPoint.set(ev.getX(), ev.getY());
            if (this.adapter.getCount() > 1) {
                this.callback.onDown(ev.getX() < ((float) getWidth()) / 3.0f);
            }
            this.isDownReleased = false;
        } else if (action == 1) {
            if (!this.isDownReleased) {
                int count = this.adapter.getCount();
                int currentItem = getCurrentItem();
                if (count > 1) {
                    if (ev.getX() > getWidth() / 3.0f) {
                        extraCount = this.adapter.getExtraCount();
                        int i = currentItem + 1;
                        if (i < count - extraCount) {
                            extraCount = i;
                        }
                    } else {
                        int i2 = (-1) + currentItem;
                        extraCount = i2 < this.adapter.getExtraCount() ? (count - r3) - 1 : i2;
                    }
                    this.callback.onRelease();
                    setCurrentItem(extraCount, false);
                }
            }
        } else if (action == 2) {
            float x = ev.getX() - this.downPoint.x;
            float y = ev.getY() - this.downPoint.y;
            boolean z = Math.abs(y) >= ((float) this.touchSlop) || Math.abs(x) >= ((float) this.touchSlop);
            if (z) {
                this.isDownReleased = true;
                this.callback.onRelease();
            }
            boolean z2 = this.isSwipingViewPager;
            if (z2 && this.isScrollingListView) {
                if (z) {
                    if (Math.abs(y) > Math.abs(x)) {
                        this.isSwipingViewPager = false;
                        MotionEvent motionEventObtain2 = MotionEvent.obtain(ev);
                        motionEventObtain2.setAction(3);
                        super.onTouchEvent(motionEventObtain2);
                        motionEventObtain2.recycle();
                    } else {
                        this.isScrollingListView = false;
                        MotionEvent motionEventObtain3 = MotionEvent.obtain(ev);
                        motionEventObtain3.setAction(3);
                        this.parentListView.onTouchEvent(motionEventObtain3);
                        motionEventObtain3.recycle();
                    }
                }
            } else if (z2 && !canScrollHorizontally(-1) && x > this.touchSlop) {
                return false;
            }
        }
        boolean zOnTouchEvent = this.isScrollingListView ? this.parentListView.onTouchEvent(ev) : false;
        if (this.isSwipingViewPager) {
            zOnTouchEvent |= super.onTouchEvent(ev);
        }
        if (action == 1 || action == 3) {
            this.isScrollingListView = false;
            this.isSwipingViewPager = false;
        }
        return zOnTouchEvent;
    }

    public void setChatInfo(TLRPC$ChatFull chatFull) {
        this.chatInfo = chatFull;
        if (this.photos.isEmpty() || this.photos.get(0) != null || this.chatInfo == null || !FileLoader.isSamePhoto((TLRPC$FileLocation) this.imagesLocations.get(0).location, this.chatInfo.chat_photo)) {
            return;
        }
        this.photos.set(0, this.chatInfo.chat_photo);
        if (!this.chatInfo.chat_photo.video_sizes.isEmpty()) {
            TLRPC$VideoSize tLRPC$VideoSize = this.chatInfo.chat_photo.video_sizes.get(0);
            this.videoLocations.set(0, ImageLocation.getForPhoto(tLRPC$VideoSize, this.chatInfo.chat_photo));
            this.videoFileNames.set(0, FileLoader.getAttachFileName(tLRPC$VideoSize));
            this.callback.onPhotosLoaded();
        } else {
            this.videoLocations.set(0, null);
            this.videoFileNames.add(0, null);
        }
        this.imagesUploadProgress.set(0, null);
        this.adapter.notifyDataSetChanged();
    }

    public boolean initIfEmpty(ImageLocation imageLocation, ImageLocation thumbLocation) {
        if (imageLocation == null || thumbLocation == null || this.settingMainPhoto != 0) {
            return false;
        }
        ImageLocation imageLocation2 = this.prevImageLocation;
        if (imageLocation2 == null || imageLocation2.location.local_id != imageLocation.location.local_id) {
            if (!this.imagesLocations.isEmpty()) {
                this.prevImageLocation = imageLocation;
                MessagesController.getInstance(this.currentAccount).loadDialogPhotos(this.dialogId, 80, 0, true, this.parentClassGuid);
                return true;
            }
            MessagesController.getInstance(this.currentAccount).loadDialogPhotos(this.dialogId, 80, 0, true, this.parentClassGuid);
        }
        if (!this.imagesLocations.isEmpty()) {
            return false;
        }
        this.prevImageLocation = imageLocation;
        this.thumbsFileNames.add(null);
        this.videoFileNames.add(null);
        this.imagesLocations.add(imageLocation);
        this.thumbsLocations.add(thumbLocation);
        this.videoLocations.add(null);
        this.photos.add(null);
        this.imagesLocationsSizes.add(-1);
        this.imagesUploadProgress.add(null);
        getAdapter().notifyDataSetChanged();
        return true;
    }

    public void addUploadingImage(ImageLocation imageLocation, ImageLocation thumbLocation) {
        this.prevImageLocation = imageLocation;
        this.thumbsFileNames.add(0, null);
        this.videoFileNames.add(0, null);
        this.imagesLocations.add(0, imageLocation);
        this.thumbsLocations.add(0, thumbLocation);
        this.videoLocations.add(0, null);
        this.photos.add(0, null);
        this.imagesLocationsSizes.add(0, -1);
        this.imagesUploadProgress.add(0, Float.valueOf(0.0f));
        this.adapter.notifyDataSetChanged();
        resetCurrentItem();
        this.currentUploadingImageLocation = imageLocation;
        this.curreantUploadingThumbLocation = thumbLocation;
    }

    public void removeUploadingImage(ImageLocation imageLocation) {
        this.uploadingImageLocation = imageLocation;
        this.currentUploadingImageLocation = null;
        this.curreantUploadingThumbLocation = null;
    }

    public ImageLocation getImageLocation(int index) {
        if (index < 0 || index >= this.imagesLocations.size()) {
            return null;
        }
        ImageLocation imageLocation = this.videoLocations.get(index);
        return imageLocation != null ? imageLocation : this.imagesLocations.get(index);
    }

    public ImageLocation getRealImageLocation(int index) {
        if (index < 0 || index >= this.imagesLocations.size()) {
            return null;
        }
        return this.imagesLocations.get(index);
    }

    public boolean hasImages() {
        return !this.imagesLocations.isEmpty();
    }

    public BackupImageView getCurrentItemView() {
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter == null || viewPagerAdapter.objects.isEmpty()) {
            return null;
        }
        return ((Item) this.adapter.objects.get(getCurrentItem())).imageView;
    }

    public boolean isLoadingCurrentVideo() {
        BackupImageView currentItemView;
        if (this.videoLocations.get(this.hasActiveVideo ? getRealPosition() - 1 : getRealPosition()) == null || (currentItemView = getCurrentItemView()) == null) {
            return false;
        }
        AnimatedFileDrawable animation = currentItemView.getImageReceiver().getAnimation();
        return animation == null || !animation.hasBitmap();
    }

    public float getCurrentItemProgress() {
        AnimatedFileDrawable animation;
        BackupImageView currentItemView = getCurrentItemView();
        if (currentItemView == null || (animation = currentItemView.getImageReceiver().getAnimation()) == null) {
            return 0.0f;
        }
        return animation.getCurrentProgress();
    }

    public boolean isCurrentItemVideo() {
        int realPosition = getRealPosition();
        if (this.hasActiveVideo) {
            if (realPosition == 0) {
                return false;
            }
            realPosition--;
        }
        return this.videoLocations.get(realPosition) != null;
    }

    public ImageLocation getCurrentVideoLocation(ImageLocation thumbLocation, ImageLocation imageLocation) {
        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated;
        if (thumbLocation == null) {
            return null;
        }
        int i = 0;
        while (i < 2) {
            ArrayList<ImageLocation> arrayList = i == 0 ? this.thumbsLocations : this.imagesLocations;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ImageLocation imageLocation2 = arrayList.get(i2);
                if (imageLocation2 != null && (tLRPC$TL_fileLocationToBeDeprecated = imageLocation2.location) != null) {
                    int i3 = imageLocation2.dc_id;
                    if (i3 == thumbLocation.dc_id) {
                        int i4 = tLRPC$TL_fileLocationToBeDeprecated.local_id;
                        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated2 = thumbLocation.location;
                        if (i4 != tLRPC$TL_fileLocationToBeDeprecated2.local_id || tLRPC$TL_fileLocationToBeDeprecated.volume_id != tLRPC$TL_fileLocationToBeDeprecated2.volume_id) {
                        }
                        return this.videoLocations.get(i2);
                    }
                    if (i3 == imageLocation.dc_id) {
                        int i5 = tLRPC$TL_fileLocationToBeDeprecated.local_id;
                        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated3 = imageLocation.location;
                        if (i5 == tLRPC$TL_fileLocationToBeDeprecated3.local_id && tLRPC$TL_fileLocationToBeDeprecated.volume_id == tLRPC$TL_fileLocationToBeDeprecated3.volume_id) {
                            return this.videoLocations.get(i2);
                        }
                    } else {
                        continue;
                    }
                }
            }
            i++;
        }
        return null;
    }

    public void resetCurrentItem() {
        setCurrentItem(this.adapter.getExtraCount(), false);
    }

    public int getRealCount() {
        int size = this.photos.size();
        return this.hasActiveVideo ? size + 1 : size;
    }

    public int getRealPosition(int position) {
        return this.adapter.getRealPosition(position);
    }

    public int getRealPosition() {
        return this.adapter.getRealPosition(getCurrentItem());
    }

    public TLRPC$Photo getPhoto(int index) {
        if (index < 0 || index >= this.photos.size()) {
            return null;
        }
        return this.photos.get(index);
    }

    public boolean removePhotoAtIndex(int index) {
        if (index < 0 || index >= this.photos.size()) {
            return false;
        }
        this.photos.remove(index);
        this.thumbsFileNames.remove(index);
        this.videoFileNames.remove(index);
        this.videoLocations.remove(index);
        this.imagesLocations.remove(index);
        this.thumbsLocations.remove(index);
        this.imagesLocationsSizes.remove(index);
        this.radialProgresses.delete(index);
        this.imagesUploadProgress.remove(index);
        if (index == 0 && !this.imagesLocations.isEmpty()) {
            this.prevImageLocation = this.imagesLocations.get(0);
        }
        this.adapter.notifyDataSetChanged();
        return this.photos.isEmpty();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (this.parentListView.getScrollState() != 0) {
            return false;
        }
        if (getParent() != null && getParent().getParent() != null) {
            getParent().getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(-1));
        }
        return super.onInterceptTouchEvent(e);
    }

    private void loadNeighboringThumbs() {
        int size = this.thumbsLocations.size();
        if (size <= 1) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= (size <= 2 ? 1 : 2)) {
                return;
            }
            FileLoader.getInstance(this.currentAccount).loadFile(this.thumbsLocations.get(i == 0 ? 1 : size - 1), null, null, 0, 1);
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x020b  */
    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r17, int r18, java.lang.Object... r19) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ProfileGalleryView.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    public class ViewPagerAdapter extends CircularViewPager.Adapter {
        private final Context context;
        private final ActionBar parentActionBar;
        private BackupImageView parentAvatarImageView;
        private final Paint placeholderPaint;
        private final ArrayList<Item> objects = new ArrayList<>();
        private final ArrayList<BackupImageView> imageViews = new ArrayList<>();

        public ViewPagerAdapter(Context context, ProfileActivity.AvatarImageView parentAvatarImageView, ActionBar parentActionBar) {
            this.context = context;
            this.parentAvatarImageView = parentAvatarImageView;
            this.parentActionBar = parentActionBar;
            Paint paint = new Paint(1);
            this.placeholderPaint = paint;
            paint.setColor(-16777216);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.objects.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            Item item = (Item) object;
            return item.isActiveVideo ? view == item.textureViewStubView : view == item.imageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object object) {
            int iIndexOf = this.objects.indexOf((Item) object);
            if (iIndexOf == -1) {
                return -2;
            }
            return iIndexOf;
        }

        /* JADX WARN: Removed duplicated region for block: B:79:0x0292  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0295  */
        @Override // androidx.viewpager.widget.PagerAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.eitaa.ui.Components.ProfileGalleryView.Item instantiateItem(android.view.ViewGroup r24, int r25) {
            /*
                Method dump skipped, instructions count: 840
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ProfileGalleryView.ViewPagerAdapter.instantiateItem(android.view.ViewGroup, int):ir.eitaa.ui.Components.ProfileGalleryView$Item");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            Item item = (Item) object;
            if (item.textureViewStubView != null) {
                container.removeView(item.textureViewStubView);
            }
            if (item.isActiveVideo) {
                return;
            }
            AvatarImageView avatarImageView = item.imageView;
            if (avatarImageView.getImageReceiver().hasStaticThumb()) {
                Drawable drawable = avatarImageView.getImageReceiver().getDrawable();
                if (drawable instanceof AnimatedFileDrawable) {
                    ((AnimatedFileDrawable) drawable).removeSecondParentView(avatarImageView);
                }
            }
            avatarImageView.setRoundRadius(0);
            container.removeView(avatarImageView);
            avatarImageView.getImageReceiver().cancelLoadImage();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            return (getRealPosition(position) + 1) + "/" + (getCount() - (getExtraCount() * 2));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            for (int i = 0; i < this.imageViews.size(); i++) {
                if (this.imageViews.get(i) != null) {
                    this.imageViews.get(i).getImageReceiver().cancelLoadImage();
                }
            }
            this.objects.clear();
            this.imageViews.clear();
            int size = ProfileGalleryView.this.imagesLocations.size();
            if (ProfileGalleryView.this.hasActiveVideo) {
                size++;
            }
            int extraCount = size + (getExtraCount() * 2);
            for (int i2 = 0; i2 < extraCount; i2++) {
                this.objects.add(new Item());
                this.imageViews.add(null);
            }
            super.notifyDataSetChanged();
        }

        @Override // ir.eitaa.ui.Components.CircularViewPager.Adapter
        public int getExtraCount() {
            int size = ProfileGalleryView.this.imagesLocations.size();
            if (ProfileGalleryView.this.hasActiveVideo) {
                size++;
            }
            if (size >= 2) {
                return ProfileGalleryView.this.getOffscreenPageLimit();
            }
            return 0;
        }
    }

    public void setData(long dialogId) {
        setData(dialogId, false);
    }

    public void setData(long dialogId, boolean forceReset) {
        if (this.dialogId == dialogId && !forceReset) {
            resetCurrentItem();
            return;
        }
        this.forceResetPosition = true;
        this.adapter.notifyDataSetChanged();
        reset();
        this.dialogId = dialogId;
        if (dialogId != 0) {
            MessagesController.getInstance(this.currentAccount).loadDialogPhotos(dialogId, 80, 0, true, this.parentClassGuid);
        }
    }

    private void reset() {
        this.videoFileNames.clear();
        this.thumbsFileNames.clear();
        this.photos.clear();
        this.videoLocations.clear();
        this.imagesLocations.clear();
        this.thumbsLocations.clear();
        this.imagesLocationsSizes.clear();
        this.imagesUploadProgress.clear();
        this.adapter.notifyDataSetChanged();
        this.uploadingImageLocation = null;
    }

    public void setRoundRadius(int topRadius, int bottomRadius) {
        this.roundTopRadius = topRadius;
        this.roundBottomRadius = bottomRadius;
        if (this.adapter != null) {
            for (int i = 0; i < this.adapter.objects.size(); i++) {
                if (((Item) this.adapter.objects.get(i)).imageView != null) {
                    AvatarImageView avatarImageView = ((Item) this.adapter.objects.get(i)).imageView;
                    int i2 = this.roundTopRadius;
                    int i3 = this.roundBottomRadius;
                    avatarImageView.setRoundRadius(i2, i2, i3, i3);
                }
            }
        }
    }

    public void setParentAvatarImage(BackupImageView parentImageView) {
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.parentAvatarImageView = parentImageView;
        }
    }

    public void setUploadProgress(ImageLocation imageLocation, float p) {
        if (imageLocation == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.imagesLocations.size()) {
                break;
            }
            if (this.imagesLocations.get(i) == imageLocation) {
                this.imagesUploadProgress.set(i, Float.valueOf(p));
                if (this.radialProgresses.get(i) != null) {
                    this.radialProgresses.get(i).setProgress(p, true);
                }
            } else {
                i++;
            }
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).invalidate();
        }
    }

    public void setCreateThumbFromParent(boolean createThumbFromParent) {
        this.createThumbFromParent = createThumbFromParent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class AvatarImageView extends BackupImageView {
        private long firstDrawTime;
        public boolean isVideo;
        private final Paint placeholderPaint;
        private final int position;
        private RadialProgress2 radialProgress;
        private ValueAnimator radialProgressHideAnimator;
        private float radialProgressHideAnimatorStartValue;
        private final int radialProgressSize;

        public AvatarImageView(Context context, int position, Paint placeholderPaint) {
            super(context);
            this.radialProgressSize = AndroidUtilities.dp(64.0f);
            this.firstDrawTime = -1L;
            this.position = position;
            this.placeholderPaint = placeholderPaint;
            setLayerNum(ProfileGalleryView.this.imagesLayerNum);
        }

        @Override // android.view.View
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            if (this.radialProgress != null) {
                int currentActionBarHeight = (ProfileGalleryView.this.parentActionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight();
                int iDp2 = AndroidUtilities.dp2(80.0f);
                RadialProgress2 radialProgress2 = this.radialProgress;
                int i = this.radialProgressSize;
                int i2 = (h - currentActionBarHeight) - iDp2;
                radialProgress2.setProgressRect((w - i) / 2, ((i2 - i) / 2) + currentActionBarHeight, (w + i) / 2, currentActionBarHeight + ((i2 + i) / 2));
            }
        }

        @Override // ir.eitaa.ui.Components.BackupImageView, android.view.View
        protected void onDraw(Canvas canvas) {
            PinchToZoomHelper pinchToZoomHelper = ProfileGalleryView.this.pinchToZoomHelper;
            if (pinchToZoomHelper == null || !pinchToZoomHelper.isInOverlayMode()) {
                if (this.radialProgress != null) {
                    final int realPosition = ProfileGalleryView.this.getRealPosition(this.position);
                    if (ProfileGalleryView.this.hasActiveVideo) {
                        realPosition--;
                    }
                    Drawable drawable = getImageReceiver().getDrawable();
                    long j = 0;
                    if (!(realPosition >= ProfileGalleryView.this.imagesUploadProgress.size() || ProfileGalleryView.this.imagesUploadProgress.get(realPosition) == null ? !(drawable == null || (this.isVideo && (!(drawable instanceof AnimatedFileDrawable) || ((AnimatedFileDrawable) drawable).getDurationMs() <= 0))) : ((Float) ProfileGalleryView.this.imagesUploadProgress.get(realPosition)).floatValue() >= 1.0f)) {
                        if (this.firstDrawTime < 0) {
                            this.firstDrawTime = System.currentTimeMillis();
                        } else {
                            long jCurrentTimeMillis = System.currentTimeMillis() - this.firstDrawTime;
                            long j2 = this.isVideo ? 250L : 750L;
                            if (jCurrentTimeMillis <= 250 + j2 && jCurrentTimeMillis > j2) {
                                this.radialProgress.setOverrideAlpha(CubicBezierInterpolator.DEFAULT.getInterpolation((jCurrentTimeMillis - j2) / 250.0f));
                            }
                        }
                        if (ProfileGalleryView.this.invalidateWithParent) {
                            invalidate();
                        } else {
                            postInvalidateOnAnimation();
                        }
                        invalidate();
                    } else if (this.radialProgressHideAnimator == null) {
                        if (this.radialProgress.getProgress() < 1.0f) {
                            this.radialProgress.setProgress(1.0f, true);
                            j = 100;
                        }
                        this.radialProgressHideAnimatorStartValue = this.radialProgress.getOverrideAlpha();
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        this.radialProgressHideAnimator = valueAnimatorOfFloat;
                        valueAnimatorOfFloat.setStartDelay(j);
                        this.radialProgressHideAnimator.setDuration((long) (this.radialProgressHideAnimatorStartValue * 250.0f));
                        this.radialProgressHideAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                        this.radialProgressHideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ProfileGalleryView$AvatarImageView$rWlKAjP7vwy0iLqbyp5nLj5bu8c
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                this.f$0.lambda$onDraw$0$ProfileGalleryView$AvatarImageView(valueAnimator);
                            }
                        });
                        this.radialProgressHideAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ProfileGalleryView.AvatarImageView.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                AvatarImageView.this.radialProgress = null;
                                ProfileGalleryView.this.radialProgresses.delete(realPosition);
                            }
                        });
                        this.radialProgressHideAnimator.start();
                    }
                    if (ProfileGalleryView.this.roundTopRadius != 0 || ProfileGalleryView.this.roundBottomRadius != 0) {
                        if (ProfileGalleryView.this.roundTopRadius == ProfileGalleryView.this.roundBottomRadius) {
                            ProfileGalleryView.this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
                            canvas.drawRoundRect(ProfileGalleryView.this.rect, r0.roundTopRadius, ProfileGalleryView.this.roundTopRadius, this.placeholderPaint);
                        } else {
                            ProfileGalleryView.this.path.reset();
                            ProfileGalleryView.this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
                            for (int i = 0; i < 4; i++) {
                                ProfileGalleryView.this.radii[i] = r0.roundTopRadius;
                                ProfileGalleryView.this.radii[i + 4] = r0.roundBottomRadius;
                            }
                            ProfileGalleryView profileGalleryView = ProfileGalleryView.this;
                            profileGalleryView.path.addRoundRect(profileGalleryView.rect, profileGalleryView.radii, Path.Direction.CW);
                            canvas.drawPath(ProfileGalleryView.this.path, this.placeholderPaint);
                        }
                    } else {
                        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.placeholderPaint);
                    }
                }
                super.onDraw(canvas);
                RadialProgress2 radialProgress2 = this.radialProgress;
                if (radialProgress2 == null || radialProgress2.getOverrideAlpha() <= 0.0f) {
                    return;
                }
                this.radialProgress.draw(canvas);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onDraw$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onDraw$0$ProfileGalleryView$AvatarImageView(ValueAnimator valueAnimator) {
            this.radialProgress.setOverrideAlpha(AndroidUtilities.lerp(this.radialProgressHideAnimatorStartValue, 0.0f, valueAnimator.getAnimatedFraction()));
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            if (ProfileGalleryView.this.invalidateWithParent) {
                ProfileGalleryView.this.invalidate();
            }
        }
    }

    public void setPinchToZoomHelper(PinchToZoomHelper pinchToZoomHelper) {
        this.pinchToZoomHelper = pinchToZoomHelper;
    }

    public void setInvalidateWithParent(boolean invalidateWithParent) {
        this.invalidateWithParent = invalidateWithParent;
    }

    private class TextureStubView extends View {
        public TextureStubView(Context context) {
            super(context);
        }
    }
}
