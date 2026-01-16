package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.messenger.camera.CameraController;
import ir.eitaa.messenger.camera.CameraSession;
import ir.eitaa.messenger.camera.CameraView;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.PhotoAttachCameraCell;
import ir.eitaa.ui.Cells.PhotoAttachPermissionCell;
import ir.eitaa.ui.Cells.PhotoAttachPhotoCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.ChatAttachAlert;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.RecyclerViewItemRangeSelector;
import ir.eitaa.ui.Components.ShutterButton;
import ir.eitaa.ui.Components.ZoomControlView;
import ir.eitaa.ui.PhotoViewer;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class ChatAttachAlertPhotoLayout extends ChatAttachAlert.AttachAlertLayout implements NotificationCenter.NotificationCenterDelegate {
    private static boolean mediaFromExternalCamera;
    private PhotoAttachAdapter adapter;
    float additionCloseCameraY;
    private int alertOnlyOnce;
    private int[] animateCameraValues;
    float animationClipBottom;
    float animationClipLeft;
    float animationClipRight;
    float animationClipTop;
    private int animationIndex;
    private boolean cameraAnimationInProgress;
    private PhotoAttachAdapter cameraAttachAdapter;
    private Drawable cameraDrawable;
    boolean cameraExpanded;
    private FrameLayout cameraIcon;
    private AnimatorSet cameraInitAnimation;
    private float cameraOpenProgress;
    private boolean cameraOpened;
    private FrameLayout cameraPanel;
    private LinearLayoutManager cameraPhotoLayoutManager;
    private RecyclerListView cameraPhotoRecyclerView;
    private boolean cameraPhotoRecyclerViewIgnoreLayout;
    private CameraView cameraView;
    private float[] cameraViewLocation;
    private float cameraViewOffsetBottomY;
    private float cameraViewOffsetX;
    private float cameraViewOffsetY;
    private float cameraZoom;
    private boolean canSaveCameraPreview;
    private boolean cancelTakingPhotos;
    private boolean checkCameraWhenShown;
    private TextView counterTextView;
    private float currentPanTranslationY;
    private int currentSelectedCount;
    private boolean deviceHasGoodCamera;
    private boolean dragging;
    private TextView dropDown;
    private ArrayList<MediaController.AlbumEntry> dropDownAlbums;
    private ActionBarMenuItem dropDownContainer;
    private Drawable dropDownDrawable;
    private boolean flashAnimationInProgress;
    private ImageView[] flashModeButton;
    boolean forceDarkTheme;
    private MediaController.AlbumEntry galleryAlbumEntry;
    private int gridExtraSpace;
    private RecyclerListView gridView;
    private android.graphics.Rect hitRect;
    private boolean ignoreLayout;
    private DecelerateInterpolator interpolator;
    private boolean isHidden;
    private RecyclerViewItemRangeSelector itemRangeSelector;
    private int itemSize;
    private int itemsPerRow;
    private int lastItemSize;
    private int lastNotifyWidth;
    private float lastY;
    private GridLayoutManager layoutManager;
    private boolean loading;
    private boolean maybeStartDraging;
    private boolean mediaEnabled;
    private boolean noCameraPermissions;
    private boolean noGalleryPermissions;
    private PhotoViewer.PhotoViewerProvider photoViewerProvider;
    private float pinchStartDistance;
    private boolean pressed;
    private EmptyTextProgressView progressView;
    private TextView recordTime;
    private boolean requestingPermissions;
    private MediaController.AlbumEntry selectedAlbumEntry;
    private boolean shouldSelect;
    private ShutterButton shutterButton;
    private ImageView switchCameraButton;
    private boolean takingPhoto;
    private TextView tooltipTextView;
    private Runnable videoRecordRunnable;
    private int videoRecordTime;
    private int[] viewPosition;
    private AnimatorSet zoomControlAnimation;
    private Runnable zoomControlHideRunnable;
    private ZoomControlView zoomControlView;
    private boolean zoomWas;
    private boolean zooming;
    private static ArrayList<Object> cameraPhotos = new ArrayList<>();
    private static HashMap<Object, Object> selectedPhotos = new HashMap<>();
    private static ArrayList<Object> selectedPhotosOrder = new ArrayList<>();
    private static int lastImageId = -1;

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int needsActionBar() {
        return 1;
    }

    static /* synthetic */ int access$2608(ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout) {
        int i = chatAttachAlertPhotoLayout.videoRecordTime;
        chatAttachAlertPhotoLayout.videoRecordTime = i + 1;
        return i;
    }

    static /* synthetic */ int access$3210() {
        int i = lastImageId;
        lastImageId = i - 1;
        return i;
    }

    private class BasePhotoProvider extends PhotoViewer.EmptyPhotoViewerProvider {
        private BasePhotoProvider() {
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean isPhotoChecked(int index) {
            MediaController.PhotoEntry photoEntryAtPosition = ChatAttachAlertPhotoLayout.this.getPhotoEntryAtPosition(index);
            return photoEntryAtPosition != null && ChatAttachAlertPhotoLayout.selectedPhotos.containsKey(Integer.valueOf(photoEntryAtPosition.imageId));
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public int setPhotoChecked(int index, VideoEditedInfo videoEditedInfo) {
            MediaController.PhotoEntry photoEntryAtPosition;
            boolean z;
            if ((ChatAttachAlertPhotoLayout.this.parentAlert.maxSelectedPhotos >= 0 && ChatAttachAlertPhotoLayout.selectedPhotos.size() >= ChatAttachAlertPhotoLayout.this.parentAlert.maxSelectedPhotos && !isPhotoChecked(index)) || (photoEntryAtPosition = ChatAttachAlertPhotoLayout.this.getPhotoEntryAtPosition(index)) == null) {
                return -1;
            }
            int iAddToSelectedPhotos = ChatAttachAlertPhotoLayout.this.addToSelectedPhotos(photoEntryAtPosition, -1);
            if (iAddToSelectedPhotos == -1) {
                iAddToSelectedPhotos = ChatAttachAlertPhotoLayout.selectedPhotosOrder.indexOf(Integer.valueOf(photoEntryAtPosition.imageId));
                z = true;
            } else {
                photoEntryAtPosition.editedInfo = null;
                z = false;
            }
            photoEntryAtPosition.editedInfo = videoEditedInfo;
            int childCount = ChatAttachAlertPhotoLayout.this.gridView.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = ChatAttachAlertPhotoLayout.this.gridView.getChildAt(i);
                if ((childAt instanceof PhotoAttachPhotoCell) && ((Integer) childAt.getTag()).intValue() == index) {
                    ChatAttachAlert chatAttachAlert = ChatAttachAlertPhotoLayout.this.parentAlert;
                    if ((chatAttachAlert.baseFragment instanceof ChatActivity) && chatAttachAlert.allowOrder) {
                        ((PhotoAttachPhotoCell) childAt).setChecked(iAddToSelectedPhotos, z, false);
                    } else {
                        ((PhotoAttachPhotoCell) childAt).setChecked(-1, z, false);
                    }
                } else {
                    i++;
                }
            }
            int childCount2 = ChatAttachAlertPhotoLayout.this.cameraPhotoRecyclerView.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount2) {
                    break;
                }
                View childAt2 = ChatAttachAlertPhotoLayout.this.cameraPhotoRecyclerView.getChildAt(i2);
                if ((childAt2 instanceof PhotoAttachPhotoCell) && ((Integer) childAt2.getTag()).intValue() == index) {
                    ChatAttachAlert chatAttachAlert2 = ChatAttachAlertPhotoLayout.this.parentAlert;
                    if ((chatAttachAlert2.baseFragment instanceof ChatActivity) && chatAttachAlert2.allowOrder) {
                        ((PhotoAttachPhotoCell) childAt2).setChecked(iAddToSelectedPhotos, z, false);
                    } else {
                        ((PhotoAttachPhotoCell) childAt2).setChecked(-1, z, false);
                    }
                } else {
                    i2++;
                }
            }
            ChatAttachAlertPhotoLayout.this.parentAlert.updateCountButton(z ? 1 : 2);
            return iAddToSelectedPhotos;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public int getSelectedCount() {
            return ChatAttachAlertPhotoLayout.selectedPhotos.size();
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public ArrayList<Object> getSelectedPhotosOrder() {
            return ChatAttachAlertPhotoLayout.selectedPhotosOrder;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public HashMap<Object, Object> getSelectedPhotos() {
            return ChatAttachAlertPhotoLayout.selectedPhotos;
        }
    }

    private void updateCheckedPhotoIndices() {
        if (this.parentAlert.baseFragment instanceof ChatActivity) {
            int childCount = this.gridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gridView.getChildAt(i);
                if (childAt instanceof PhotoAttachPhotoCell) {
                    PhotoAttachPhotoCell photoAttachPhotoCell = (PhotoAttachPhotoCell) childAt;
                    MediaController.PhotoEntry photoEntryAtPosition = getPhotoEntryAtPosition(((Integer) photoAttachPhotoCell.getTag()).intValue());
                    if (photoEntryAtPosition != null) {
                        photoAttachPhotoCell.setNum(selectedPhotosOrder.indexOf(Integer.valueOf(photoEntryAtPosition.imageId)));
                    }
                }
            }
            int childCount2 = this.cameraPhotoRecyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                View childAt2 = this.cameraPhotoRecyclerView.getChildAt(i2);
                if (childAt2 instanceof PhotoAttachPhotoCell) {
                    PhotoAttachPhotoCell photoAttachPhotoCell2 = (PhotoAttachPhotoCell) childAt2;
                    MediaController.PhotoEntry photoEntryAtPosition2 = getPhotoEntryAtPosition(((Integer) photoAttachPhotoCell2.getTag()).intValue());
                    if (photoEntryAtPosition2 != null) {
                        photoAttachPhotoCell2.setNum(selectedPhotosOrder.indexOf(Integer.valueOf(photoEntryAtPosition2.imageId)));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaController.PhotoEntry getPhotoEntryAtPosition(int position) {
        if (position < 0) {
            return null;
        }
        int size = cameraPhotos.size();
        if (position < size) {
            return (MediaController.PhotoEntry) cameraPhotos.get(position);
        }
        int i = position - size;
        if (i < this.selectedAlbumEntry.photos.size()) {
            return this.selectedAlbumEntry.photos.get(i);
        }
        return null;
    }

    private ArrayList<Object> getAllPhotosArray() {
        if (this.selectedAlbumEntry != null) {
            if (!cameraPhotos.isEmpty()) {
                ArrayList<Object> arrayList = new ArrayList<>(this.selectedAlbumEntry.photos.size() + cameraPhotos.size());
                arrayList.addAll(cameraPhotos);
                arrayList.addAll(this.selectedAlbumEntry.photos);
                return arrayList;
            }
            return this.selectedAlbumEntry.photos;
        }
        if (!cameraPhotos.isEmpty()) {
            return cameraPhotos;
        }
        return new ArrayList<>(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatAttachAlertPhotoLayout(ChatAttachAlert chatAttachAlert, Context context, boolean z, final Theme.ResourcesProvider resourcesProvider) {
        super(chatAttachAlert, context, resourcesProvider);
        this.flashModeButton = new ImageView[2];
        this.cameraViewLocation = new float[2];
        this.viewPosition = new int[2];
        this.animateCameraValues = new int[5];
        this.interpolator = new DecelerateInterpolator(1.5f);
        this.hitRect = new android.graphics.Rect();
        int iDp = AndroidUtilities.dp(80.0f);
        this.itemSize = iDp;
        this.lastItemSize = iDp;
        this.itemsPerRow = 3;
        this.loading = true;
        this.animationIndex = -1;
        this.photoViewerProvider = new BasePhotoProvider() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.1
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public boolean cancelButtonPressed() {
                return false;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
                PhotoAttachPhotoCell cellForIndex = ChatAttachAlertPhotoLayout.this.getCellForIndex(index);
                if (cellForIndex == null) {
                    return null;
                }
                int[] iArr = new int[2];
                cellForIndex.getImageView().getLocationInWindow(iArr);
                if (Build.VERSION.SDK_INT < 26) {
                    iArr[0] = iArr[0] - ChatAttachAlertPhotoLayout.this.parentAlert.getLeftInset();
                }
                PhotoViewer.PlaceProviderObject placeProviderObject = new PhotoViewer.PlaceProviderObject();
                placeProviderObject.viewX = iArr[0];
                placeProviderObject.viewY = iArr[1];
                placeProviderObject.parentView = ChatAttachAlertPhotoLayout.this.gridView;
                ImageReceiver imageReceiver = cellForIndex.getImageView().getImageReceiver();
                placeProviderObject.imageReceiver = imageReceiver;
                placeProviderObject.thumb = imageReceiver.getBitmapSafe();
                placeProviderObject.scale = cellForIndex.getScale();
                placeProviderObject.clipBottomAddition = (int) ChatAttachAlertPhotoLayout.this.parentAlert.getClipLayoutBottom();
                cellForIndex.showCheck(false);
                return placeProviderObject;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void updatePhotoAtIndex(int index) {
                PhotoAttachPhotoCell cellForIndex = ChatAttachAlertPhotoLayout.this.getCellForIndex(index);
                if (cellForIndex != null) {
                    cellForIndex.getImageView().setOrientation(0, true);
                    MediaController.PhotoEntry photoEntryAtPosition = ChatAttachAlertPhotoLayout.this.getPhotoEntryAtPosition(index);
                    if (photoEntryAtPosition == null) {
                        return;
                    }
                    if (photoEntryAtPosition.thumbPath != null) {
                        cellForIndex.getImageView().setImage(photoEntryAtPosition.thumbPath, null, Theme.chat_attachEmptyDrawable);
                        return;
                    }
                    if (photoEntryAtPosition.path != null) {
                        cellForIndex.getImageView().setOrientation(photoEntryAtPosition.orientation, true);
                        if (photoEntryAtPosition.isVideo) {
                            cellForIndex.getImageView().setImage("vthumb://" + photoEntryAtPosition.imageId + ":" + photoEntryAtPosition.path, null, Theme.chat_attachEmptyDrawable);
                            return;
                        }
                        cellForIndex.getImageView().setImage("thumb://" + photoEntryAtPosition.imageId + ":" + photoEntryAtPosition.path, null, Theme.chat_attachEmptyDrawable);
                        return;
                    }
                    cellForIndex.getImageView().setImageDrawable(Theme.chat_attachEmptyDrawable);
                }
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public ImageReceiver.BitmapHolder getThumbForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index) {
                PhotoAttachPhotoCell cellForIndex = ChatAttachAlertPhotoLayout.this.getCellForIndex(index);
                if (cellForIndex != null) {
                    return cellForIndex.getImageView().getImageReceiver().getBitmapSafe();
                }
                return null;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void willSwitchFromPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index) {
                PhotoAttachPhotoCell cellForIndex = ChatAttachAlertPhotoLayout.this.getCellForIndex(index);
                if (cellForIndex != null) {
                    cellForIndex.showCheck(true);
                }
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void willHidePhotoViewer() {
                int childCount = ChatAttachAlertPhotoLayout.this.gridView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = ChatAttachAlertPhotoLayout.this.gridView.getChildAt(i);
                    if (childAt instanceof PhotoAttachPhotoCell) {
                        ((PhotoAttachPhotoCell) childAt).showCheck(true);
                    }
                }
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void sendButtonPressed(int index, VideoEditedInfo videoEditedInfo, boolean notify, int scheduleDate, boolean forceDocument) {
                MediaController.PhotoEntry photoEntryAtPosition = ChatAttachAlertPhotoLayout.this.getPhotoEntryAtPosition(index);
                if (photoEntryAtPosition != null) {
                    photoEntryAtPosition.editedInfo = videoEditedInfo;
                }
                if (ChatAttachAlertPhotoLayout.selectedPhotos.isEmpty() && photoEntryAtPosition != null) {
                    ChatAttachAlertPhotoLayout.this.addToSelectedPhotos(photoEntryAtPosition, -1);
                }
                ChatAttachAlertPhotoLayout.this.parentAlert.applyCaption();
                ChatAttachAlertPhotoLayout.this.parentAlert.delegate.didPressedButton(7, true, notify, scheduleDate, forceDocument);
            }
        };
        this.forceDarkTheme = z;
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.albumsDidLoad);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.cameraInitied);
        FrameLayout container = chatAttachAlert.getContainer();
        this.cameraDrawable = context.getResources().getDrawable(R.drawable.instant_camera).mutate();
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, this.parentAlert.actionBar.createMenu(), 0, 0, resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.2
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem, android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                info.setText(ChatAttachAlertPhotoLayout.this.dropDown.getText());
            }
        };
        this.dropDownContainer = actionBarMenuItem;
        actionBarMenuItem.setSubMenuOpenSide(1);
        int i = 0;
        Object[] objArr = 0;
        this.parentAlert.actionBar.addView(this.dropDownContainer, 0, LayoutHelper.createFrame(-2, -1.0f, 51, AndroidUtilities.isTablet() ? 64.0f : 56.0f, 0.0f, 40.0f, 0.0f));
        this.dropDownContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$SsR_XWOgCiqePUdtnZ5G-RKUic0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$ChatAttachAlertPhotoLayout(view);
            }
        });
        TextView textView = new TextView(context);
        this.dropDown = textView;
        textView.setImportantForAccessibility(2);
        this.dropDown.setGravity(3);
        this.dropDown.setSingleLine(true);
        this.dropDown.setLines(1);
        this.dropDown.setMaxLines(1);
        this.dropDown.setEllipsize(TextUtils.TruncateAt.END);
        this.dropDown.setTextColor(getThemedColor("dialogTextBlack"));
        this.dropDown.setText(LocaleController.getString("ChatGallery", R.string.ChatGallery));
        this.dropDown.setTypeface(AndroidUtilities.getFontFamily(true));
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.ic_arrow_drop_down).mutate();
        this.dropDownDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogTextBlack"), PorterDuff.Mode.MULTIPLY));
        this.dropDown.setCompoundDrawablePadding(AndroidUtilities.dp(4.0f));
        this.dropDown.setPadding(0, 0, AndroidUtilities.dp(10.0f), 0);
        this.dropDownContainer.addView(this.dropDown, LayoutHelper.createFrame(-2, -2.0f, 16, 16.0f, 0.0f, 0.0f, 0.0f));
        checkCamera(false);
        this.parentAlert.selectedMenuItem.addSubItem(0, LocaleController.getString("SendWithoutGrouping", R.string.SendWithoutGrouping));
        this.parentAlert.selectedMenuItem.addSubItem(1, LocaleController.getString("SendWithoutCompression", R.string.SendWithoutCompression));
        this.parentAlert.selectedMenuItem.addSubItem(2, R.drawable.msg_openin, LocaleController.getString("OpenInExternalApp", R.string.OpenInExternalApp));
        RecyclerListView recyclerListView = new RecyclerListView(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.3
            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                if (e.getAction() != 0 || e.getY() >= ChatAttachAlertPhotoLayout.this.parentAlert.scrollOffsetY[0] - AndroidUtilities.dp(80.0f)) {
                    return super.onTouchEvent(e);
                }
                return false;
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent e) {
                if (e.getAction() != 0 || e.getY() >= ChatAttachAlertPhotoLayout.this.parentAlert.scrollOffsetY[0] - AndroidUtilities.dp(80.0f)) {
                    return super.onInterceptTouchEvent(e);
                }
                return false;
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                super.onLayout(changed, l, t, r, b);
                PhotoViewer.getInstance().checkCurrentImageVisibility();
            }
        };
        this.gridView = recyclerListView;
        PhotoAttachAdapter photoAttachAdapter = new PhotoAttachAdapter(context, true);
        this.adapter = photoAttachAdapter;
        recyclerListView.setAdapter(photoAttachAdapter);
        this.adapter.createCache();
        this.gridView.setClipToPadding(false);
        this.gridView.setItemAnimator(null);
        this.gridView.setLayoutAnimation(null);
        this.gridView.setVerticalScrollBarEnabled(false);
        this.gridView.setGlowColor(getThemedColor("dialogScrollGlow"));
        addView(this.gridView, LayoutHelper.createFrame(-1, -1.0f));
        this.gridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (ChatAttachAlertPhotoLayout.this.gridView.getChildCount() <= 0) {
                    return;
                }
                ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout = ChatAttachAlertPhotoLayout.this;
                chatAttachAlertPhotoLayout.parentAlert.updateLayout(chatAttachAlertPhotoLayout, true, dy);
                if (dy != 0) {
                    ChatAttachAlertPhotoLayout.this.checkCameraViewPosition();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                RecyclerListView.Holder holder;
                if (newState == 0) {
                    int iDp2 = AndroidUtilities.dp(13.0f);
                    ActionBarMenuItem actionBarMenuItem2 = ChatAttachAlertPhotoLayout.this.parentAlert.selectedMenuItem;
                    int iDp3 = iDp2 + (actionBarMenuItem2 != null ? AndroidUtilities.dp(actionBarMenuItem2.getAlpha() * 26.0f) : 0);
                    int backgroundPaddingTop = ChatAttachAlertPhotoLayout.this.parentAlert.getBackgroundPaddingTop();
                    if (((ChatAttachAlertPhotoLayout.this.parentAlert.scrollOffsetY[0] - backgroundPaddingTop) - iDp3) + backgroundPaddingTop >= ActionBar.getCurrentActionBarHeight() || (holder = (RecyclerListView.Holder) ChatAttachAlertPhotoLayout.this.gridView.findViewHolderForAdapterPosition(0)) == null || holder.itemView.getTop() <= AndroidUtilities.dp(7.0f)) {
                        return;
                    }
                    ChatAttachAlertPhotoLayout.this.gridView.smoothScrollBy(0, holder.itemView.getTop() - AndroidUtilities.dp(7.0f));
                }
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, this.itemSize) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.5
            @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.5.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateDyToMakeVisible(View view, int snapPreference) {
                        return super.calculateDyToMakeVisible(view, snapPreference) - (ChatAttachAlertPhotoLayout.this.gridView.getPaddingTop() - AndroidUtilities.dp(7.0f));
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int calculateTimeForDeceleration(int dx) {
                        return super.calculateTimeForDeceleration(dx) * 2;
                    }
                };
                linearSmoothScroller.setTargetPosition(position);
                startSmoothScroll(linearSmoothScroller);
            }
        };
        this.layoutManager = gridLayoutManager;
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.6
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                if (position == ChatAttachAlertPhotoLayout.this.adapter.itemsCount - 1) {
                    return ChatAttachAlertPhotoLayout.this.layoutManager.getSpanCount();
                }
                return ChatAttachAlertPhotoLayout.this.itemSize + (position % ChatAttachAlertPhotoLayout.this.itemsPerRow != ChatAttachAlertPhotoLayout.this.itemsPerRow + (-1) ? AndroidUtilities.dp(5.0f) : 0);
            }
        });
        this.gridView.setLayoutManager(this.layoutManager);
        this.gridView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$ift0uFLMJPTih-1sArzjYuTGJ48
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) throws InterruptedException, Resources.NotFoundException {
                this.f$0.lambda$new$1$ChatAttachAlertPhotoLayout(resourcesProvider, view, i2);
            }
        });
        this.gridView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$-TwkckOODdTJWFleEsiihc_JY-c
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i2) {
                return this.f$0.lambda$new$2$ChatAttachAlertPhotoLayout(view, i2);
            }
        });
        RecyclerViewItemRangeSelector recyclerViewItemRangeSelector = new RecyclerViewItemRangeSelector(new RecyclerViewItemRangeSelector.RecyclerViewItemRangeSelectorDelegate() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.7
            @Override // ir.eitaa.ui.Components.RecyclerViewItemRangeSelector.RecyclerViewItemRangeSelectorDelegate
            public void setSelected(View view, int index, boolean selected) {
                if (selected == ChatAttachAlertPhotoLayout.this.shouldSelect && (view instanceof PhotoAttachPhotoCell)) {
                    ((PhotoAttachPhotoCell) view).callDelegate();
                }
            }

            @Override // ir.eitaa.ui.Components.RecyclerViewItemRangeSelector.RecyclerViewItemRangeSelectorDelegate
            public boolean isSelected(int index) {
                MediaController.PhotoEntry photo = ChatAttachAlertPhotoLayout.this.adapter.getPhoto(index);
                return photo != null && ChatAttachAlertPhotoLayout.selectedPhotos.containsKey(Integer.valueOf(photo.imageId));
            }

            @Override // ir.eitaa.ui.Components.RecyclerViewItemRangeSelector.RecyclerViewItemRangeSelectorDelegate
            public boolean isIndexSelectable(int index) {
                return ChatAttachAlertPhotoLayout.this.adapter.getItemViewType(index) == 0;
            }

            @Override // ir.eitaa.ui.Components.RecyclerViewItemRangeSelector.RecyclerViewItemRangeSelectorDelegate
            public void onStartStopSelection(boolean z2) {
                ChatAttachAlertPhotoLayout.this.alertOnlyOnce = z2 ? 1 : 0;
                ChatAttachAlertPhotoLayout.this.gridView.hideSelector(true);
            }
        });
        this.itemRangeSelector = recyclerViewItemRangeSelector;
        this.gridView.addOnItemTouchListener(recyclerViewItemRangeSelector);
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context, null, resourcesProvider);
        this.progressView = emptyTextProgressView;
        emptyTextProgressView.setText(LocaleController.getString("NoPhotos", R.string.NoPhotos));
        this.progressView.setOnTouchListener(null);
        this.progressView.setTextSize(20);
        addView(this.progressView, LayoutHelper.createFrame(-1, 80.0f));
        if (this.loading) {
            this.progressView.showProgress();
        } else {
            this.progressView.showTextView();
        }
        final Paint paint = new Paint(1);
        paint.setColor(-2468275);
        TextView textView2 = new TextView(context) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.8
            float alpha = 0.0f;
            boolean isIncr;

            @Override // android.widget.TextView, android.view.View
            protected void onDraw(Canvas canvas) {
                paint.setAlpha((int) ((this.alpha * 130.0f) + 125.0f));
                if (!this.isIncr) {
                    float f = this.alpha - 0.026666667f;
                    this.alpha = f;
                    if (f <= 0.0f) {
                        this.alpha = 0.0f;
                        this.isIncr = true;
                    }
                } else {
                    float f2 = this.alpha + 0.026666667f;
                    this.alpha = f2;
                    if (f2 >= 1.0f) {
                        this.alpha = 1.0f;
                        this.isIncr = false;
                    }
                }
                super.onDraw(canvas);
                canvas.drawCircle(AndroidUtilities.dp(14.0f), getMeasuredHeight() / 2, AndroidUtilities.dp(4.0f), paint);
                invalidate();
            }
        };
        this.recordTime = textView2;
        AndroidUtilities.updateViewVisibilityAnimated(textView2, false, 1.0f, false);
        this.recordTime.setBackgroundResource(R.drawable.system);
        this.recordTime.getBackground().setColorFilter(new PorterDuffColorFilter(1711276032, PorterDuff.Mode.MULTIPLY));
        this.recordTime.setTextSize(1, 15.0f);
        this.recordTime.setTypeface(AndroidUtilities.getFontFamily(true));
        this.recordTime.setAlpha(0.0f);
        this.recordTime.setTextColor(-1);
        this.recordTime.setPadding(AndroidUtilities.dp(24.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(5.0f));
        container.addView(this.recordTime, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 16.0f, 0.0f, 0.0f));
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.9
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                int measuredWidth;
                int measuredHeight;
                int iDp2;
                int measuredHeight2;
                int measuredWidth2;
                int iDp3;
                if (getMeasuredWidth() == AndroidUtilities.dp(126.0f)) {
                    measuredWidth = getMeasuredWidth() / 2;
                    measuredHeight = getMeasuredHeight() / 2;
                    measuredWidth2 = getMeasuredWidth() / 2;
                    int i2 = measuredHeight / 2;
                    iDp3 = measuredHeight + i2 + AndroidUtilities.dp(17.0f);
                    measuredHeight2 = i2 - AndroidUtilities.dp(17.0f);
                    iDp2 = measuredWidth2;
                } else {
                    measuredWidth = getMeasuredWidth() / 2;
                    measuredHeight = (getMeasuredHeight() / 2) - AndroidUtilities.dp(13.0f);
                    int i3 = measuredWidth / 2;
                    int iDp4 = measuredWidth + i3 + AndroidUtilities.dp(17.0f);
                    iDp2 = i3 - AndroidUtilities.dp(17.0f);
                    measuredHeight2 = (getMeasuredHeight() / 2) - AndroidUtilities.dp(13.0f);
                    measuredWidth2 = iDp4;
                    iDp3 = measuredHeight2;
                }
                int measuredHeight3 = (getMeasuredHeight() - ChatAttachAlertPhotoLayout.this.tooltipTextView.getMeasuredHeight()) - AndroidUtilities.dp(12.0f);
                if (getMeasuredWidth() == AndroidUtilities.dp(126.0f)) {
                    ChatAttachAlertPhotoLayout.this.tooltipTextView.layout(measuredWidth - (ChatAttachAlertPhotoLayout.this.tooltipTextView.getMeasuredWidth() / 2), getMeasuredHeight(), (ChatAttachAlertPhotoLayout.this.tooltipTextView.getMeasuredWidth() / 2) + measuredWidth, getMeasuredHeight() + ChatAttachAlertPhotoLayout.this.tooltipTextView.getMeasuredHeight());
                } else {
                    ChatAttachAlertPhotoLayout.this.tooltipTextView.layout(measuredWidth - (ChatAttachAlertPhotoLayout.this.tooltipTextView.getMeasuredWidth() / 2), measuredHeight3, (ChatAttachAlertPhotoLayout.this.tooltipTextView.getMeasuredWidth() / 2) + measuredWidth, ChatAttachAlertPhotoLayout.this.tooltipTextView.getMeasuredHeight() + measuredHeight3);
                }
                ChatAttachAlertPhotoLayout.this.shutterButton.layout(measuredWidth - (ChatAttachAlertPhotoLayout.this.shutterButton.getMeasuredWidth() / 2), measuredHeight - (ChatAttachAlertPhotoLayout.this.shutterButton.getMeasuredHeight() / 2), measuredWidth + (ChatAttachAlertPhotoLayout.this.shutterButton.getMeasuredWidth() / 2), measuredHeight + (ChatAttachAlertPhotoLayout.this.shutterButton.getMeasuredHeight() / 2));
                ChatAttachAlertPhotoLayout.this.switchCameraButton.layout(measuredWidth2 - (ChatAttachAlertPhotoLayout.this.switchCameraButton.getMeasuredWidth() / 2), iDp3 - (ChatAttachAlertPhotoLayout.this.switchCameraButton.getMeasuredHeight() / 2), measuredWidth2 + (ChatAttachAlertPhotoLayout.this.switchCameraButton.getMeasuredWidth() / 2), iDp3 + (ChatAttachAlertPhotoLayout.this.switchCameraButton.getMeasuredHeight() / 2));
                for (int i4 = 0; i4 < 2; i4++) {
                    ChatAttachAlertPhotoLayout.this.flashModeButton[i4].layout(iDp2 - (ChatAttachAlertPhotoLayout.this.flashModeButton[i4].getMeasuredWidth() / 2), measuredHeight2 - (ChatAttachAlertPhotoLayout.this.flashModeButton[i4].getMeasuredHeight() / 2), (ChatAttachAlertPhotoLayout.this.flashModeButton[i4].getMeasuredWidth() / 2) + iDp2, (ChatAttachAlertPhotoLayout.this.flashModeButton[i4].getMeasuredHeight() / 2) + measuredHeight2);
                }
            }

            @Override // android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
                ChatAttachAlert chatAttachAlert2 = ChatAttachAlertPhotoLayout.this.parentAlert;
                if (chatAttachAlert2 != null) {
                    chatAttachAlert2.setOverlayNavBarColor(ColorUtils.setAlphaComponent(-16777216, (int) (alpha * 255.0f)));
                }
            }
        };
        this.cameraPanel = frameLayout;
        frameLayout.setVisibility(8);
        this.cameraPanel.setAlpha(0.0f);
        container.addView(this.cameraPanel, LayoutHelper.createFrame(-1, 126, 83));
        TextView textView3 = new TextView(context);
        this.counterTextView = textView3;
        textView3.setBackgroundResource(R.drawable.photos_rounded);
        this.counterTextView.setVisibility(8);
        this.counterTextView.setTextColor(-1);
        this.counterTextView.setGravity(17);
        this.counterTextView.setPivotX(0.0f);
        this.counterTextView.setPivotY(0.0f);
        this.counterTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.counterTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.photos_arrow, 0);
        this.counterTextView.setCompoundDrawablePadding(AndroidUtilities.dp(4.0f));
        this.counterTextView.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
        container.addView(this.counterTextView, LayoutHelper.createFrame(-2, 38.0f, 51, 0.0f, 0.0f, 0.0f, 116.0f));
        this.counterTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$2UQcat4zZ5s3q3m2IlojX0LrJQE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws InterruptedException, Resources.NotFoundException {
                this.f$0.lambda$new$3$ChatAttachAlertPhotoLayout(view);
            }
        });
        ZoomControlView zoomControlView = new ZoomControlView(context);
        this.zoomControlView = zoomControlView;
        zoomControlView.setVisibility(8);
        this.zoomControlView.setAlpha(0.0f);
        container.addView(this.zoomControlView, LayoutHelper.createFrame(-2, 50.0f, 51, 0.0f, 0.0f, 0.0f, 116.0f));
        this.zoomControlView.setDelegate(new ZoomControlView.ZoomControlViewDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$57rYgNPnD7cEAoD6rwuD1DCK4bU
            @Override // ir.eitaa.ui.Components.ZoomControlView.ZoomControlViewDelegate
            public final void didSetZoom(float f) {
                this.f$0.lambda$new$4$ChatAttachAlertPhotoLayout(f);
            }
        });
        ShutterButton shutterButton = new ShutterButton(context);
        this.shutterButton = shutterButton;
        this.cameraPanel.addView(shutterButton, LayoutHelper.createFrame(84, 84, 17));
        this.shutterButton.setDelegate(new AnonymousClass10(container));
        this.shutterButton.setFocusable(true);
        this.shutterButton.setContentDescription(LocaleController.getString("AccDescrShutter", R.string.AccDescrShutter));
        ImageView imageView = new ImageView(context);
        this.switchCameraButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.cameraPanel.addView(this.switchCameraButton, LayoutHelper.createFrame(48, 48, 21));
        this.switchCameraButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$98s61uZC0fJQc9rlwSEmeoBan4s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws InterruptedException {
                this.f$0.lambda$new$5$ChatAttachAlertPhotoLayout(view);
            }
        });
        this.switchCameraButton.setContentDescription(LocaleController.getString("AccDescrSwitchCamera", R.string.AccDescrSwitchCamera));
        for (int i2 = 0; i2 < 2; i2++) {
            this.flashModeButton[i2] = new ImageView(context);
            this.flashModeButton[i2].setScaleType(ImageView.ScaleType.CENTER);
            this.flashModeButton[i2].setVisibility(4);
            this.cameraPanel.addView(this.flashModeButton[i2], LayoutHelper.createFrame(48, 48, 51));
            this.flashModeButton[i2].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$YW2yyoqwlqGZXu-0Ybg2TrqzWKg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$6$ChatAttachAlertPhotoLayout(view);
                }
            });
            this.flashModeButton[i2].setContentDescription("flash mode " + i2);
        }
        TextView textView4 = new TextView(context);
        this.tooltipTextView = textView4;
        textView4.setTextSize(1, 15.0f);
        this.tooltipTextView.setTextColor(-1);
        this.tooltipTextView.setText(LocaleController.getString("TapForVideo", R.string.TapForVideo));
        this.tooltipTextView.setShadowLayer(AndroidUtilities.dp(3.33333f), 0.0f, AndroidUtilities.dp(0.666f), 1275068416);
        this.tooltipTextView.setPadding(AndroidUtilities.dp(6.0f), 0, AndroidUtilities.dp(6.0f), 0);
        this.cameraPanel.addView(this.tooltipTextView, LayoutHelper.createFrame(-2, -2.0f, 81, 0.0f, 0.0f, 0.0f, 16.0f));
        RecyclerListView recyclerListView2 = new RecyclerListView(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.13
            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (ChatAttachAlertPhotoLayout.this.cameraPhotoRecyclerViewIgnoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.cameraPhotoRecyclerView = recyclerListView2;
        recyclerListView2.setVerticalScrollBarEnabled(true);
        RecyclerListView recyclerListView3 = this.cameraPhotoRecyclerView;
        PhotoAttachAdapter photoAttachAdapter2 = new PhotoAttachAdapter(context, false);
        this.cameraAttachAdapter = photoAttachAdapter2;
        recyclerListView3.setAdapter(photoAttachAdapter2);
        this.cameraAttachAdapter.createCache();
        this.cameraPhotoRecyclerView.setClipToPadding(false);
        this.cameraPhotoRecyclerView.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
        this.cameraPhotoRecyclerView.setItemAnimator(null);
        this.cameraPhotoRecyclerView.setLayoutAnimation(null);
        this.cameraPhotoRecyclerView.setOverScrollMode(2);
        this.cameraPhotoRecyclerView.setVisibility(4);
        this.cameraPhotoRecyclerView.setAlpha(0.0f);
        container.addView(this.cameraPhotoRecyclerView, LayoutHelper.createFrame(-1, 80.0f));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, i, objArr == true ? 1 : 0) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.14
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        this.cameraPhotoLayoutManager = linearLayoutManager;
        this.cameraPhotoRecyclerView.setLayoutManager(linearLayoutManager);
        this.cameraPhotoRecyclerView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$8eUtnHBY7695m8LqQNuAcpI5s_c
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i3) {
                ChatAttachAlertPhotoLayout.lambda$new$7(view, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ChatAttachAlertPhotoLayout(View view) {
        this.dropDownContainer.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ChatAttachAlertPhotoLayout(Theme.ResourcesProvider resourcesProvider, View view, int i) throws InterruptedException, Resources.NotFoundException {
        BaseFragment baseFragment;
        ChatActivity chatActivity;
        int i2;
        if (!this.mediaEnabled || (baseFragment = this.parentAlert.baseFragment) == null || baseFragment.getParentActivity() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.adapter.needCamera && this.selectedAlbumEntry == this.galleryAlbumEntry && i == 0 && this.noCameraPermissions) {
                try {
                    this.parentAlert.baseFragment.getParentActivity().requestPermissions(new String[]{"android.permission.CAMERA"}, 18);
                    return;
                } catch (Exception unused) {
                    return;
                }
            } else if (this.noGalleryPermissions) {
                try {
                    this.parentAlert.baseFragment.getParentActivity().requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
        }
        if (i != 0 || this.selectedAlbumEntry != this.galleryAlbumEntry) {
            if (this.selectedAlbumEntry == this.galleryAlbumEntry) {
                i--;
            }
            int i3 = i;
            ArrayList<Object> allPhotosArray = getAllPhotosArray();
            if (i3 < 0 || i3 >= allPhotosArray.size()) {
                return;
            }
            PhotoViewer.getInstance().setParentActivity(this.parentAlert.baseFragment.getParentActivity(), resourcesProvider);
            PhotoViewer.getInstance().setParentAlert(this.parentAlert);
            PhotoViewer photoViewer = PhotoViewer.getInstance();
            ChatAttachAlert chatAttachAlert = this.parentAlert;
            photoViewer.setMaxSelectedPhotos(chatAttachAlert.maxSelectedPhotos, chatAttachAlert.allowOrder);
            ChatAttachAlert chatAttachAlert2 = this.parentAlert;
            if (chatAttachAlert2.avatarPicker != 0) {
                chatActivity = null;
                i2 = 1;
            } else {
                BaseFragment baseFragment2 = chatAttachAlert2.baseFragment;
                if (baseFragment2 instanceof ChatActivity) {
                    chatActivity = (ChatActivity) baseFragment2;
                    i2 = 0;
                } else {
                    chatActivity = null;
                    i2 = 4;
                }
            }
            if (!chatAttachAlert2.delegate.needEnterComment()) {
                AndroidUtilities.hideKeyboard(this.parentAlert.baseFragment.getFragmentView().findFocus());
                AndroidUtilities.hideKeyboard(this.parentAlert.getContainer().findFocus());
            }
            PhotoViewer.getInstance().openPhotoForSelect(allPhotosArray, i3, i2, false, this.photoViewerProvider, chatActivity);
            return;
        }
        if (SharedConfig.inappCamera) {
            openCamera(true);
            return;
        }
        ChatAttachAlert.ChatAttachViewDelegate chatAttachViewDelegate = this.parentAlert.delegate;
        if (chatAttachViewDelegate != null) {
            chatAttachViewDelegate.didPressedButton(0, false, true, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$2$ChatAttachAlertPhotoLayout(View view, int i) {
        if (i == 0 && this.selectedAlbumEntry == this.galleryAlbumEntry) {
            ChatAttachAlert.ChatAttachViewDelegate chatAttachViewDelegate = this.parentAlert.delegate;
            if (chatAttachViewDelegate != null) {
                chatAttachViewDelegate.didPressedButton(0, false, true, 0, false);
            }
            return true;
        }
        if (!(view instanceof PhotoAttachPhotoCell)) {
            return false;
        }
        RecyclerViewItemRangeSelector recyclerViewItemRangeSelector = this.itemRangeSelector;
        boolean z = !((PhotoAttachPhotoCell) view).isChecked();
        this.shouldSelect = z;
        recyclerViewItemRangeSelector.setIsActive(view, true, i, z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$ChatAttachAlertPhotoLayout(View view) throws InterruptedException, Resources.NotFoundException {
        if (this.cameraView == null) {
            return;
        }
        openPhotoViewer(null, false, false);
        CameraController.getInstance().stopPreview(this.cameraView.getCameraSession());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$ChatAttachAlertPhotoLayout(float f) {
        CameraView cameraView = this.cameraView;
        if (cameraView != null) {
            this.cameraZoom = f;
            cameraView.setZoom(f);
        }
        showZoomControls(true, true);
    }

    /* renamed from: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout$10, reason: invalid class name */
    class AnonymousClass10 implements ShutterButton.ShutterButtonDelegate {
        private File outputFile;
        final /* synthetic */ FrameLayout val$container;
        private boolean zoomingWas;

        AnonymousClass10(final FrameLayout val$container) {
            this.val$container = val$container;
        }

        @Override // ir.eitaa.ui.Components.ShutterButton.ShutterButtonDelegate
        public boolean shutterLongPressed() {
            BaseFragment baseFragment;
            ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout = ChatAttachAlertPhotoLayout.this;
            ChatAttachAlert chatAttachAlert = chatAttachAlertPhotoLayout.parentAlert;
            if ((chatAttachAlert.avatarPicker != 2 && !(chatAttachAlert.baseFragment instanceof ChatActivity)) || chatAttachAlertPhotoLayout.takingPhoto || (baseFragment = ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment) == null || baseFragment.getParentActivity() == null || ChatAttachAlertPhotoLayout.this.cameraView == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 23 || ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment.getParentActivity().checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
                for (int i = 0; i < 2; i++) {
                    ChatAttachAlertPhotoLayout.this.flashModeButton[i].animate().alpha(0.0f).translationX(AndroidUtilities.dp(30.0f)).setDuration(150L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
                }
                ViewPropertyAnimator duration = ChatAttachAlertPhotoLayout.this.switchCameraButton.animate().alpha(0.0f).translationX(-AndroidUtilities.dp(30.0f)).setDuration(150L);
                CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
                duration.setInterpolator(cubicBezierInterpolator).start();
                ChatAttachAlertPhotoLayout.this.tooltipTextView.animate().alpha(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
                BaseFragment baseFragment2 = ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment;
                this.outputFile = AndroidUtilities.generateVideoPath((baseFragment2 instanceof ChatActivity) && ((ChatActivity) baseFragment2).isSecretChat());
                AndroidUtilities.updateViewVisibilityAnimated(ChatAttachAlertPhotoLayout.this.recordTime, true);
                ChatAttachAlertPhotoLayout.this.recordTime.setText(AndroidUtilities.formatLongDuration(0));
                ChatAttachAlertPhotoLayout.this.videoRecordTime = 0;
                ChatAttachAlertPhotoLayout.this.videoRecordRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$10$VXH1HzFYqLCerf12WCDcJZLF42A
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$shutterLongPressed$0$ChatAttachAlertPhotoLayout$10();
                    }
                };
                AndroidUtilities.lockOrientation(ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment.getParentActivity());
                CameraController cameraController = CameraController.getInstance();
                CameraSession cameraSession = ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession();
                File file = this.outputFile;
                ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout2 = ChatAttachAlertPhotoLayout.this;
                cameraController.recordVideo(cameraSession, file, chatAttachAlertPhotoLayout2.parentAlert.avatarPicker != 0, new CameraController.VideoTakeCallback() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$10$FVSnVXM7nhXFfEHnwV9zsYhCWrY
                    @Override // ir.eitaa.messenger.camera.CameraController.VideoTakeCallback
                    public final void onFinishVideoRecording(String str, long j) throws InterruptedException, Resources.NotFoundException {
                        this.f$0.lambda$shutterLongPressed$1$ChatAttachAlertPhotoLayout$10(str, j);
                    }
                }, new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$10$4QY5vgdb_DBCpIJPw1zT2bs_W68
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$shutterLongPressed$2$ChatAttachAlertPhotoLayout$10();
                    }
                }, chatAttachAlertPhotoLayout2.cameraView);
                ChatAttachAlertPhotoLayout.this.shutterButton.setState(ShutterButton.State.RECORDING, true);
                ChatAttachAlertPhotoLayout.this.cameraView.runHaptic();
                return true;
            }
            ChatAttachAlertPhotoLayout.this.requestingPermissions = true;
            ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment.getParentActivity().requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 21);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$shutterLongPressed$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$shutterLongPressed$0$ChatAttachAlertPhotoLayout$10() {
            if (ChatAttachAlertPhotoLayout.this.videoRecordRunnable == null) {
                return;
            }
            ChatAttachAlertPhotoLayout.access$2608(ChatAttachAlertPhotoLayout.this);
            ChatAttachAlertPhotoLayout.this.recordTime.setText(AndroidUtilities.formatLongDuration(ChatAttachAlertPhotoLayout.this.videoRecordTime));
            AndroidUtilities.runOnUIThread(ChatAttachAlertPhotoLayout.this.videoRecordRunnable, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$shutterLongPressed$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$shutterLongPressed$1$ChatAttachAlertPhotoLayout$10(String str, long j) throws InterruptedException, Resources.NotFoundException {
            if (this.outputFile != null) {
                ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout = ChatAttachAlertPhotoLayout.this;
                if (chatAttachAlertPhotoLayout.parentAlert.baseFragment == null || chatAttachAlertPhotoLayout.cameraView == null) {
                    return;
                }
                boolean unused = ChatAttachAlertPhotoLayout.mediaFromExternalCamera = false;
                MediaController.PhotoEntry photoEntry = new MediaController.PhotoEntry(0, ChatAttachAlertPhotoLayout.access$3210(), 0L, this.outputFile.getAbsolutePath(), 0, true, 0, 0, 0L);
                photoEntry.duration = (int) j;
                photoEntry.thumbPath = str;
                ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout2 = ChatAttachAlertPhotoLayout.this;
                if (chatAttachAlertPhotoLayout2.parentAlert.avatarPicker != 0 && chatAttachAlertPhotoLayout2.cameraView.isFrontface()) {
                    MediaController.CropState cropState = new MediaController.CropState();
                    photoEntry.cropState = cropState;
                    cropState.mirrored = true;
                    cropState.freeform = false;
                    cropState.lockedAspectRatio = 1.0f;
                }
                ChatAttachAlertPhotoLayout.this.openPhotoViewer(photoEntry, false, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$shutterLongPressed$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$shutterLongPressed$2$ChatAttachAlertPhotoLayout$10() {
            AndroidUtilities.runOnUIThread(ChatAttachAlertPhotoLayout.this.videoRecordRunnable, 1000L);
        }

        @Override // ir.eitaa.ui.Components.ShutterButton.ShutterButtonDelegate
        public void shutterCancel() throws InterruptedException {
            File file = this.outputFile;
            if (file != null) {
                file.delete();
                this.outputFile = null;
            }
            ChatAttachAlertPhotoLayout.this.resetRecordState();
            CameraController.getInstance().stopVideoRecording(ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession(), true);
        }

        @Override // ir.eitaa.ui.Components.ShutterButton.ShutterButtonDelegate
        public void shutterReleased() throws InterruptedException {
            if (ChatAttachAlertPhotoLayout.this.takingPhoto || ChatAttachAlertPhotoLayout.this.cameraView == null || ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession() == null) {
                return;
            }
            boolean z = true;
            if (ChatAttachAlertPhotoLayout.this.shutterButton.getState() == ShutterButton.State.RECORDING) {
                ChatAttachAlertPhotoLayout.this.resetRecordState();
                CameraController.getInstance().stopVideoRecording(ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession(), false);
                ChatAttachAlertPhotoLayout.this.shutterButton.setState(ShutterButton.State.DEFAULT, true);
                return;
            }
            BaseFragment baseFragment = ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment;
            final File fileGeneratePicturePath = AndroidUtilities.generatePicturePath((baseFragment instanceof ChatActivity) && ((ChatActivity) baseFragment).isSecretChat(), null);
            final boolean zIsSameTakePictureOrientation = ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession().isSameTakePictureOrientation();
            CameraSession cameraSession = ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession();
            ChatAttachAlert chatAttachAlert = ChatAttachAlertPhotoLayout.this.parentAlert;
            if (!(chatAttachAlert.baseFragment instanceof ChatActivity) && chatAttachAlert.avatarPicker != 2) {
                z = false;
            }
            cameraSession.setFlipFront(z);
            ChatAttachAlertPhotoLayout.this.takingPhoto = CameraController.getInstance().takePicture(fileGeneratePicturePath, ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession(), new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$10$aq5ShGR0RIqU4vgVe11nINTo2JE
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException, Resources.NotFoundException {
                    this.f$0.lambda$shutterReleased$3$ChatAttachAlertPhotoLayout$10(fileGeneratePicturePath, zIsSameTakePictureOrientation);
                }
            });
            ChatAttachAlertPhotoLayout.this.cameraView.startTakePictureAnimation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$shutterReleased$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$shutterReleased$3$ChatAttachAlertPhotoLayout$10(File file, boolean z) throws InterruptedException, Resources.NotFoundException {
            int i;
            ChatAttachAlertPhotoLayout.this.takingPhoto = false;
            if (file == null || ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment == null) {
                return;
            }
            try {
                int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 1);
                i = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
            } catch (Exception e) {
                FileLog.e(e);
                i = 0;
            }
            boolean unused = ChatAttachAlertPhotoLayout.mediaFromExternalCamera = false;
            MediaController.PhotoEntry photoEntry = new MediaController.PhotoEntry(0, ChatAttachAlertPhotoLayout.access$3210(), 0L, file.getAbsolutePath(), i, false, 0, 0, 0L);
            photoEntry.canDeleteAfter = true;
            ChatAttachAlertPhotoLayout.this.openPhotoViewer(photoEntry, z, false);
        }

        @Override // ir.eitaa.ui.Components.ShutterButton.ShutterButtonDelegate
        public boolean onTranslationChanged(float x, float y) {
            boolean z = this.val$container.getWidth() < this.val$container.getHeight();
            float f = z ? x : y;
            float f2 = z ? y : x;
            if (!this.zoomingWas && Math.abs(f) > Math.abs(f2)) {
                return ChatAttachAlertPhotoLayout.this.zoomControlView.getTag() == null;
            }
            if (f2 < 0.0f) {
                ChatAttachAlertPhotoLayout.this.showZoomControls(true, true);
                ChatAttachAlertPhotoLayout.this.zoomControlView.setZoom((-f2) / AndroidUtilities.dp(200.0f), true);
                this.zoomingWas = true;
                return false;
            }
            if (this.zoomingWas) {
                ChatAttachAlertPhotoLayout.this.zoomControlView.setZoom(0.0f, true);
            }
            if (x == 0.0f && y == 0.0f) {
                this.zoomingWas = false;
            }
            if (this.zoomingWas) {
                return false;
            }
            return (x == 0.0f && y == 0.0f) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$ChatAttachAlertPhotoLayout(View view) throws InterruptedException {
        CameraView cameraView;
        if (this.takingPhoto || (cameraView = this.cameraView) == null || !cameraView.isInitied()) {
            return;
        }
        this.canSaveCameraPreview = false;
        this.cameraView.switchCamera();
        this.cameraView.startSwitchingAnimation();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.switchCameraButton, (Property<ImageView, Float>) View.SCALE_X, 0.0f).setDuration(100L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ChatAttachAlertPhotoLayout.this.switchCameraButton.setImageResource((ChatAttachAlertPhotoLayout.this.cameraView == null || !ChatAttachAlertPhotoLayout.this.cameraView.isFrontface()) ? R.drawable.camera_revert2 : R.drawable.camera_revert1);
                ObjectAnimator.ofFloat(ChatAttachAlertPhotoLayout.this.switchCameraButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f).setDuration(100L).start();
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$6$ChatAttachAlertPhotoLayout(final View view) {
        CameraView cameraView;
        if (this.flashAnimationInProgress || (cameraView = this.cameraView) == null || !cameraView.isInitied() || !this.cameraOpened) {
            return;
        }
        String currentFlashMode = this.cameraView.getCameraSession().getCurrentFlashMode();
        String nextFlashMode = this.cameraView.getCameraSession().getNextFlashMode();
        if (currentFlashMode.equals(nextFlashMode)) {
            return;
        }
        this.cameraView.getCameraSession().setCurrentFlashMode(nextFlashMode);
        this.flashAnimationInProgress = true;
        ImageView[] imageViewArr = this.flashModeButton;
        final ImageView imageView = imageViewArr[0] == view ? imageViewArr[1] : imageViewArr[0];
        imageView.setVisibility(0);
        setCameraFlashModeIcon(imageView, nextFlashMode);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, AndroidUtilities.dp(48.0f)), ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f), 0.0f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.ALPHA, 0.0f, 1.0f));
        animatorSet.setDuration(220L);
        animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ChatAttachAlertPhotoLayout.this.flashAnimationInProgress = false;
                view.setVisibility(4);
                imageView.sendAccessibilityEvent(8);
            }
        });
        animatorSet.start();
    }

    static /* synthetic */ void lambda$new$7(View view, int i) {
        if (view instanceof PhotoAttachPhotoCell) {
            ((PhotoAttachPhotoCell) view).callDelegate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int addToSelectedPhotos(MediaController.PhotoEntry object, int index) {
        Integer numValueOf = Integer.valueOf(object.imageId);
        if (selectedPhotos.containsKey(numValueOf)) {
            selectedPhotos.remove(numValueOf);
            int iIndexOf = selectedPhotosOrder.indexOf(numValueOf);
            if (iIndexOf >= 0) {
                selectedPhotosOrder.remove(iIndexOf);
            }
            updatePhotosCounter(false);
            updateCheckedPhotoIndices();
            if (index >= 0) {
                object.reset();
                this.photoViewerProvider.updatePhotoAtIndex(index);
            }
            return iIndexOf;
        }
        selectedPhotos.put(numValueOf, object);
        selectedPhotosOrder.add(numValueOf);
        updatePhotosCounter(true);
        return -1;
    }

    private void clearSelectedPhotos() {
        if (!selectedPhotos.isEmpty()) {
            Iterator<Map.Entry<Object, Object>> it = selectedPhotos.entrySet().iterator();
            while (it.hasNext()) {
                ((MediaController.PhotoEntry) it.next().getValue()).reset();
            }
            selectedPhotos.clear();
            selectedPhotosOrder.clear();
        }
        if (!cameraPhotos.isEmpty()) {
            int size = cameraPhotos.size();
            for (int i = 0; i < size; i++) {
                MediaController.PhotoEntry photoEntry = (MediaController.PhotoEntry) cameraPhotos.get(i);
                new File(photoEntry.path).delete();
                if (photoEntry.imagePath != null) {
                    new File(photoEntry.imagePath).delete();
                }
                if (photoEntry.thumbPath != null) {
                    new File(photoEntry.thumbPath).delete();
                }
            }
            cameraPhotos.clear();
        }
        this.adapter.notifyDataSetChanged();
        this.cameraAttachAdapter.notifyDataSetChanged();
    }

    private void updateAlbumsDropDown() {
        ArrayList<MediaController.AlbumEntry> arrayList;
        this.dropDownContainer.removeAllSubItems();
        if (this.mediaEnabled) {
            ChatAttachAlert chatAttachAlert = this.parentAlert;
            if ((chatAttachAlert.baseFragment instanceof ChatActivity) || chatAttachAlert.avatarPicker == 2) {
                arrayList = MediaController.allMediaAlbums;
            } else {
                arrayList = MediaController.allPhotoAlbums;
            }
            ArrayList<MediaController.AlbumEntry> arrayList2 = new ArrayList<>(arrayList);
            this.dropDownAlbums = arrayList2;
            Collections.sort(arrayList2, new $$Lambda$ChatAttachAlertPhotoLayout$aroft5fFQtH2UOMzBgs1UaEN2Q0(arrayList));
        } else {
            this.dropDownAlbums = new ArrayList<>();
        }
        if (this.dropDownAlbums.isEmpty()) {
            this.dropDown.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.dropDown.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.dropDownDrawable, (Drawable) null);
        int size = this.dropDownAlbums.size();
        for (int i = 0; i < size; i++) {
            this.dropDownContainer.addSubItem(i + 10, this.dropDownAlbums.get(i).bucketName);
        }
    }

    static /* synthetic */ int lambda$updateAlbumsDropDown$8(ArrayList arrayList, MediaController.AlbumEntry albumEntry, MediaController.AlbumEntry albumEntry2) {
        int iIndexOf;
        int iIndexOf2;
        int i = albumEntry.bucketId;
        if (i == 0 && albumEntry2.bucketId != 0) {
            return -1;
        }
        if ((i == 0 || albumEntry2.bucketId != 0) && (iIndexOf = arrayList.indexOf(albumEntry)) <= (iIndexOf2 = arrayList.indexOf(albumEntry2))) {
            return iIndexOf < iIndexOf2 ? -1 : 0;
        }
        return 1;
    }

    private boolean processTouchEvent(MotionEvent event) {
        CameraView cameraView;
        if (event == null) {
            return false;
        }
        if ((!this.pressed && event.getActionMasked() == 0) || event.getActionMasked() == 5) {
            this.zoomControlView.getHitRect(this.hitRect);
            if (this.zoomControlView.getTag() != null && this.hitRect.contains((int) event.getX(), (int) event.getY())) {
                return false;
            }
            if (!this.takingPhoto && !this.dragging) {
                if (event.getPointerCount() == 2) {
                    this.pinchStartDistance = (float) Math.hypot(event.getX(1) - event.getX(0), event.getY(1) - event.getY(0));
                    this.zooming = true;
                } else {
                    this.maybeStartDraging = true;
                    this.lastY = event.getY();
                    this.zooming = false;
                }
                this.zoomWas = false;
                this.pressed = true;
            }
        } else if (this.pressed) {
            if (event.getActionMasked() == 2) {
                if (this.zooming && event.getPointerCount() == 2 && !this.dragging) {
                    float fHypot = (float) Math.hypot(event.getX(1) - event.getX(0), event.getY(1) - event.getY(0));
                    if (this.zoomWas) {
                        if (this.cameraView != null) {
                            float fDp = (fHypot - this.pinchStartDistance) / AndroidUtilities.dp(100.0f);
                            this.pinchStartDistance = fHypot;
                            float f = this.cameraZoom + fDp;
                            this.cameraZoom = f;
                            if (f < 0.0f) {
                                this.cameraZoom = 0.0f;
                            } else if (f > 1.0f) {
                                this.cameraZoom = 1.0f;
                            }
                            this.zoomControlView.setZoom(this.cameraZoom, false);
                            this.parentAlert.getSheetContainer().invalidate();
                            this.cameraView.setZoom(this.cameraZoom);
                            showZoomControls(true, true);
                        }
                    } else if (Math.abs(fHypot - this.pinchStartDistance) >= AndroidUtilities.getPixelsInCM(0.4f, false)) {
                        this.pinchStartDistance = fHypot;
                        this.zoomWas = true;
                    }
                } else {
                    float y = event.getY();
                    float f2 = y - this.lastY;
                    if (this.maybeStartDraging) {
                        if (Math.abs(f2) > AndroidUtilities.getPixelsInCM(0.4f, false)) {
                            this.maybeStartDraging = false;
                            this.dragging = true;
                        }
                    } else if (this.dragging && (cameraView = this.cameraView) != null) {
                        cameraView.setTranslationY(cameraView.getTranslationY() + f2);
                        this.lastY = y;
                        this.zoomControlView.setTag(null);
                        Runnable runnable = this.zoomControlHideRunnable;
                        if (runnable != null) {
                            AndroidUtilities.cancelRunOnUIThread(runnable);
                            this.zoomControlHideRunnable = null;
                        }
                        if (this.cameraPanel.getTag() == null) {
                            this.cameraPanel.setTag(1);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(ObjectAnimator.ofFloat(this.cameraPanel, (Property<FrameLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.zoomControlView, (Property<ZoomControlView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.counterTextView, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.flashModeButton[0], (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.flashModeButton[1], (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.cameraPhotoRecyclerView, (Property<RecyclerListView, Float>) View.ALPHA, 0.0f));
                            animatorSet.setDuration(220L);
                            animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
                            animatorSet.start();
                        }
                    }
                }
            } else if (event.getActionMasked() == 3 || event.getActionMasked() == 1 || event.getActionMasked() == 6) {
                this.pressed = false;
                this.zooming = false;
                if (this.dragging) {
                    this.dragging = false;
                    CameraView cameraView2 = this.cameraView;
                    if (cameraView2 != null) {
                        if (Math.abs(cameraView2.getTranslationY()) > this.cameraView.getMeasuredHeight() / 6.0f) {
                            closeCamera(true);
                        } else {
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.cameraView, (Property<CameraView, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(this.cameraPanel, (Property<FrameLayout, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.counterTextView, (Property<TextView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.flashModeButton[0], (Property<ImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.flashModeButton[1], (Property<ImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.cameraPhotoRecyclerView, (Property<RecyclerListView, Float>) View.ALPHA, 1.0f));
                            animatorSet2.setDuration(250L);
                            animatorSet2.setInterpolator(this.interpolator);
                            animatorSet2.start();
                            this.cameraPanel.setTag(null);
                        }
                    }
                } else {
                    CameraView cameraView3 = this.cameraView;
                    if (cameraView3 != null && !this.zoomWas) {
                        cameraView3.getLocationOnScreen(this.viewPosition);
                        this.cameraView.focusToPoint((int) (event.getRawX() - this.viewPosition[0]), (int) (event.getRawY() - this.viewPosition[1]));
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetRecordState() {
        if (this.parentAlert.baseFragment == null) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            this.flashModeButton[i].animate().alpha(1.0f).translationX(0.0f).setDuration(150L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
        }
        ViewPropertyAnimator duration = this.switchCameraButton.animate().alpha(1.0f).translationX(0.0f).setDuration(150L);
        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
        duration.setInterpolator(cubicBezierInterpolator).start();
        this.tooltipTextView.animate().alpha(1.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
        AndroidUtilities.updateViewVisibilityAnimated(this.recordTime, false);
        AndroidUtilities.cancelRunOnUIThread(this.videoRecordRunnable);
        this.videoRecordRunnable = null;
        AndroidUtilities.unlockOrientation(this.parentAlert.baseFragment.getParentActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openPhotoViewer(MediaController.PhotoEntry entry, final boolean sameTakePictureOrientation, boolean external) throws InterruptedException, Resources.NotFoundException {
        ChatActivity chatActivity;
        int i;
        ArrayList<Object> allPhotosArray;
        int size;
        if (entry != null) {
            cameraPhotos.add(entry);
            selectedPhotos.put(Integer.valueOf(entry.imageId), entry);
            selectedPhotosOrder.add(Integer.valueOf(entry.imageId));
            this.parentAlert.updateCountButton(0);
            this.adapter.notifyDataSetChanged();
            this.cameraAttachAdapter.notifyDataSetChanged();
        }
        if (entry != null && !external && cameraPhotos.size() > 1) {
            updatePhotosCounter(false);
            if (this.cameraView != null) {
                this.zoomControlView.setZoom(0.0f, false);
                this.cameraZoom = 0.0f;
                this.cameraView.setZoom(0.0f);
                CameraController.getInstance().startPreview(this.cameraView.getCameraSession());
                return;
            }
            return;
        }
        if (cameraPhotos.isEmpty()) {
            return;
        }
        this.cancelTakingPhotos = true;
        PhotoViewer.getInstance().setParentActivity(this.parentAlert.baseFragment.getParentActivity(), this.resourcesProvider);
        PhotoViewer.getInstance().setParentAlert(this.parentAlert);
        PhotoViewer photoViewer = PhotoViewer.getInstance();
        ChatAttachAlert chatAttachAlert = this.parentAlert;
        photoViewer.setMaxSelectedPhotos(chatAttachAlert.maxSelectedPhotos, chatAttachAlert.allowOrder);
        ChatAttachAlert chatAttachAlert2 = this.parentAlert;
        int i2 = chatAttachAlert2.avatarPicker;
        if (i2 != 0) {
            chatActivity = null;
            i = 1;
        } else {
            BaseFragment baseFragment = chatAttachAlert2.baseFragment;
            if (baseFragment instanceof ChatActivity) {
                chatActivity = (ChatActivity) baseFragment;
                i = 2;
            } else {
                chatActivity = null;
                i = 5;
            }
        }
        if (i2 != 0) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.add(entry);
            allPhotosArray = arrayList;
            size = 0;
        } else {
            allPhotosArray = getAllPhotosArray();
            size = cameraPhotos.size() - 1;
        }
        PhotoViewer.getInstance().openPhotoForSelect(allPhotosArray, size, i, false, new AnonymousClass15(sameTakePictureOrientation), chatActivity);
    }

    /* renamed from: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout$15, reason: invalid class name */
    class AnonymousClass15 extends BasePhotoProvider {
        final /* synthetic */ boolean val$sameTakePictureOrientation;

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean canScrollAway() {
            return false;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public ImageReceiver.BitmapHolder getThumbForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index) {
            return null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass15(final boolean val$sameTakePictureOrientation) {
            super();
            this.val$sameTakePictureOrientation = val$sameTakePictureOrientation;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean cancelButtonPressed() {
            if (ChatAttachAlertPhotoLayout.this.cameraOpened && ChatAttachAlertPhotoLayout.this.cameraView != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$15$G3idODK04cgY2-T9x-CQc6epES8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$cancelButtonPressed$0$ChatAttachAlertPhotoLayout$15();
                    }
                }, 1000L);
                ChatAttachAlertPhotoLayout.this.zoomControlView.setZoom(0.0f, false);
                ChatAttachAlertPhotoLayout.this.cameraZoom = 0.0f;
                ChatAttachAlertPhotoLayout.this.cameraView.setZoom(0.0f);
                CameraController.getInstance().startPreview(ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession());
            }
            if (ChatAttachAlertPhotoLayout.this.cancelTakingPhotos && ChatAttachAlertPhotoLayout.cameraPhotos.size() == 1) {
                int size = ChatAttachAlertPhotoLayout.cameraPhotos.size();
                for (int i = 0; i < size; i++) {
                    MediaController.PhotoEntry photoEntry = (MediaController.PhotoEntry) ChatAttachAlertPhotoLayout.cameraPhotos.get(i);
                    new File(photoEntry.path).delete();
                    if (photoEntry.imagePath != null) {
                        new File(photoEntry.imagePath).delete();
                    }
                    if (photoEntry.thumbPath != null) {
                        new File(photoEntry.thumbPath).delete();
                    }
                }
                ChatAttachAlertPhotoLayout.cameraPhotos.clear();
                ChatAttachAlertPhotoLayout.selectedPhotosOrder.clear();
                ChatAttachAlertPhotoLayout.selectedPhotos.clear();
                ChatAttachAlertPhotoLayout.this.counterTextView.setVisibility(4);
                ChatAttachAlertPhotoLayout.this.cameraPhotoRecyclerView.setVisibility(8);
                ChatAttachAlertPhotoLayout.this.adapter.notifyDataSetChanged();
                ChatAttachAlertPhotoLayout.this.cameraAttachAdapter.notifyDataSetChanged();
                ChatAttachAlertPhotoLayout.this.parentAlert.updateCountButton(0);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$cancelButtonPressed$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$cancelButtonPressed$0$ChatAttachAlertPhotoLayout$15() {
            if (ChatAttachAlertPhotoLayout.this.cameraView == null || ChatAttachAlertPhotoLayout.this.parentAlert.isDismissed() || Build.VERSION.SDK_INT < 21) {
                return;
            }
            ChatAttachAlertPhotoLayout.this.cameraView.setSystemUiVisibility(1028);
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void needAddMorePhotos() {
            ChatAttachAlertPhotoLayout.this.cancelTakingPhotos = false;
            if (!ChatAttachAlertPhotoLayout.mediaFromExternalCamera) {
                if (!ChatAttachAlertPhotoLayout.this.cameraOpened) {
                    ChatAttachAlertPhotoLayout.this.openCamera(false);
                }
                ChatAttachAlertPhotoLayout.this.counterTextView.setVisibility(0);
                ChatAttachAlertPhotoLayout.this.cameraPhotoRecyclerView.setVisibility(0);
                ChatAttachAlertPhotoLayout.this.counterTextView.setAlpha(1.0f);
                ChatAttachAlertPhotoLayout.this.updatePhotosCounter(false);
                return;
            }
            ChatAttachAlertPhotoLayout.this.parentAlert.delegate.didPressedButton(0, true, true, 0, false);
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void sendButtonPressed(int index, VideoEditedInfo videoEditedInfo, boolean notify, int scheduleDate, boolean forceDocument) {
            if (ChatAttachAlertPhotoLayout.cameraPhotos.isEmpty() || ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment == null) {
                return;
            }
            if (videoEditedInfo != null && index >= 0 && index < ChatAttachAlertPhotoLayout.cameraPhotos.size()) {
                ((MediaController.PhotoEntry) ChatAttachAlertPhotoLayout.cameraPhotos.get(index)).editedInfo = videoEditedInfo;
            }
            BaseFragment baseFragment = ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment;
            if (!(baseFragment instanceof ChatActivity) || !((ChatActivity) baseFragment).isSecretChat()) {
                int size = ChatAttachAlertPhotoLayout.cameraPhotos.size();
                for (int i = 0; i < size; i++) {
                    AndroidUtilities.addMediaToGallery(((MediaController.PhotoEntry) ChatAttachAlertPhotoLayout.cameraPhotos.get(i)).path);
                }
            }
            ChatAttachAlertPhotoLayout.this.parentAlert.applyCaption();
            ChatAttachAlertPhotoLayout.this.closeCamera(false);
            ChatAttachAlertPhotoLayout.this.parentAlert.delegate.didPressedButton(forceDocument ? 4 : 8, true, notify, scheduleDate, forceDocument);
            ChatAttachAlertPhotoLayout.cameraPhotos.clear();
            ChatAttachAlertPhotoLayout.selectedPhotosOrder.clear();
            ChatAttachAlertPhotoLayout.selectedPhotos.clear();
            ChatAttachAlertPhotoLayout.this.adapter.notifyDataSetChanged();
            ChatAttachAlertPhotoLayout.this.cameraAttachAdapter.notifyDataSetChanged();
            ChatAttachAlertPhotoLayout.this.parentAlert.dismiss();
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean scaleToFill() {
            BaseFragment baseFragment = ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment;
            if (baseFragment == null || baseFragment.getParentActivity() == null) {
                return false;
            }
            return this.val$sameTakePictureOrientation || Settings.System.getInt(ChatAttachAlertPhotoLayout.this.parentAlert.baseFragment.getParentActivity().getContentResolver(), "accelerometer_rotation", 0) == 1;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void willHidePhotoViewer() {
            int childCount = ChatAttachAlertPhotoLayout.this.gridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ChatAttachAlertPhotoLayout.this.gridView.getChildAt(i);
                if (childAt instanceof PhotoAttachPhotoCell) {
                    PhotoAttachPhotoCell photoAttachPhotoCell = (PhotoAttachPhotoCell) childAt;
                    photoAttachPhotoCell.showImage();
                    photoAttachPhotoCell.showCheck(true);
                }
            }
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean canCaptureMorePhotos() {
            return ChatAttachAlertPhotoLayout.this.parentAlert.maxSelectedPhotos != 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showZoomControls(boolean show, boolean animated) {
        if ((this.zoomControlView.getTag() != null && show) || (this.zoomControlView.getTag() == null && !show)) {
            if (show) {
                Runnable runnable = this.zoomControlHideRunnable;
                if (runnable != null) {
                    AndroidUtilities.cancelRunOnUIThread(runnable);
                }
                Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$5Djq3TmlW0qUhkJHCs5psQ5DATE
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$showZoomControls$9$ChatAttachAlertPhotoLayout();
                    }
                };
                this.zoomControlHideRunnable = runnable2;
                AndroidUtilities.runOnUIThread(runnable2, 2000L);
                return;
            }
            return;
        }
        AnimatorSet animatorSet = this.zoomControlAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.zoomControlView.setTag(show ? 1 : null);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.zoomControlAnimation = animatorSet2;
        animatorSet2.setDuration(180L);
        AnimatorSet animatorSet3 = this.zoomControlAnimation;
        Animator[] animatorArr = new Animator[1];
        ZoomControlView zoomControlView = this.zoomControlView;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(zoomControlView, (Property<ZoomControlView, Float>) property, fArr);
        animatorSet3.playTogether(animatorArr);
        this.zoomControlAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.16
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ChatAttachAlertPhotoLayout.this.zoomControlAnimation = null;
            }
        });
        this.zoomControlAnimation.start();
        if (show) {
            Runnable runnable3 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$HXfMzcgkB8wbPf2kHvu_SnwR1p8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showZoomControls$10$ChatAttachAlertPhotoLayout();
                }
            };
            this.zoomControlHideRunnable = runnable3;
            AndroidUtilities.runOnUIThread(runnable3, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showZoomControls$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showZoomControls$9$ChatAttachAlertPhotoLayout() {
        showZoomControls(false, true);
        this.zoomControlHideRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showZoomControls$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showZoomControls$10$ChatAttachAlertPhotoLayout() {
        showZoomControls(false, true);
        this.zoomControlHideRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePhotosCounter(boolean added) {
        if (this.counterTextView == null || this.parentAlert.avatarPicker != 0) {
            return;
        }
        Iterator<Map.Entry<Object, Object>> it = selectedPhotos.entrySet().iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (((MediaController.PhotoEntry) it.next().getValue()).isVideo) {
                z = true;
            } else {
                z2 = true;
            }
            if (z && z2) {
                break;
            }
        }
        int iMax = Math.max(1, selectedPhotos.size());
        if (z && z2) {
            this.counterTextView.setText(LocaleController.formatPluralString("Media", selectedPhotos.size()).toUpperCase());
            if (iMax != this.currentSelectedCount || added) {
                this.parentAlert.selectedTextView.setText(LocaleController.formatPluralString("MediaSelected", iMax));
            }
        } else if (z) {
            this.counterTextView.setText(LocaleController.formatPluralString("Videos", selectedPhotos.size()).toUpperCase());
            if (iMax != this.currentSelectedCount || added) {
                this.parentAlert.selectedTextView.setText(LocaleController.formatPluralString("VideosSelected", iMax));
            }
        } else {
            this.counterTextView.setText(LocaleController.formatPluralString("Photos", selectedPhotos.size()).toUpperCase());
            if (iMax != this.currentSelectedCount || added) {
                this.parentAlert.selectedTextView.setText(LocaleController.formatPluralString("PhotosSelected", iMax));
            }
        }
        this.currentSelectedCount = iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PhotoAttachPhotoCell getCellForIndex(int index) {
        int childCount = this.gridView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gridView.getChildAt(i);
            if (childAt.getTop() < this.gridView.getMeasuredHeight() - this.parentAlert.getClipLayoutBottom() && (childAt instanceof PhotoAttachPhotoCell)) {
                PhotoAttachPhotoCell photoAttachPhotoCell = (PhotoAttachPhotoCell) childAt;
                if (((Integer) photoAttachPhotoCell.getImageView().getTag()).intValue() == index) {
                    return photoAttachPhotoCell;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCameraFlashModeIcon(ImageView imageView, String mode) {
        mode.hashCode();
        switch (mode) {
            case "on":
                imageView.setImageResource(R.drawable.flash_on);
                imageView.setContentDescription(LocaleController.getString("AccDescrCameraFlashOn", R.string.AccDescrCameraFlashOn));
                break;
            case "off":
                imageView.setImageResource(R.drawable.flash_off);
                imageView.setContentDescription(LocaleController.getString("AccDescrCameraFlashOff", R.string.AccDescrCameraFlashOff));
                break;
            case "auto":
                imageView.setImageResource(R.drawable.flash_auto);
                imageView.setContentDescription(LocaleController.getString("AccDescrCameraFlashAuto", R.string.AccDescrCameraFlashAuto));
                break;
        }
    }

    public void checkCamera(boolean request) {
        PhotoAttachAdapter photoAttachAdapter;
        BaseFragment baseFragment = this.parentAlert.baseFragment;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        boolean z = this.deviceHasGoodCamera;
        boolean z2 = this.noCameraPermissions;
        if (!SharedConfig.inappCamera) {
            this.deviceHasGoodCamera = false;
        } else if (Build.VERSION.SDK_INT >= 23) {
            boolean z3 = this.parentAlert.baseFragment.getParentActivity().checkSelfPermission("android.permission.CAMERA") != 0;
            this.noCameraPermissions = z3;
            if (z3) {
                if (request) {
                    try {
                        this.parentAlert.baseFragment.getParentActivity().requestPermissions(new String[]{"android.permission.CAMERA"}, 17);
                    } catch (Exception unused) {
                    }
                }
                this.deviceHasGoodCamera = false;
            } else {
                if (request || SharedConfig.hasCameraCache) {
                    CameraController.getInstance().initCamera(null);
                }
                this.deviceHasGoodCamera = CameraController.getInstance().isCameraInitied();
            }
        } else {
            if (request || SharedConfig.hasCameraCache) {
                CameraController.getInstance().initCamera(null);
            }
            this.deviceHasGoodCamera = CameraController.getInstance().isCameraInitied();
        }
        if ((z != this.deviceHasGoodCamera || z2 != this.noCameraPermissions) && (photoAttachAdapter = this.adapter) != null) {
            photoAttachAdapter.notifyDataSetChanged();
        }
        if (this.parentAlert.isShowing() && this.deviceHasGoodCamera) {
            ChatAttachAlert chatAttachAlert = this.parentAlert;
            if (chatAttachAlert.baseFragment == null || chatAttachAlert.getBackDrawable().getAlpha() == 0 || this.cameraOpened) {
                return;
            }
            showCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamera(boolean animated) {
        CameraView cameraView = this.cameraView;
        if (cameraView == null || this.cameraInitAnimation != null || !cameraView.isInitied() || this.parentAlert.isDismissed()) {
            return;
        }
        ChatAttachAlert chatAttachAlert = this.parentAlert;
        int i = 0;
        if (chatAttachAlert.avatarPicker == 2 || (chatAttachAlert.baseFragment instanceof ChatActivity)) {
            this.tooltipTextView.setVisibility(0);
        } else {
            this.tooltipTextView.setVisibility(8);
        }
        if (cameraPhotos.isEmpty()) {
            this.counterTextView.setVisibility(4);
            this.cameraPhotoRecyclerView.setVisibility(8);
        } else {
            this.counterTextView.setVisibility(0);
            this.cameraPhotoRecyclerView.setVisibility(0);
        }
        if (this.parentAlert.commentTextView.isKeyboardVisible() && isFocusable()) {
            this.parentAlert.commentTextView.closeKeyboard();
        }
        this.zoomControlView.setVisibility(0);
        this.zoomControlView.setAlpha(0.0f);
        this.cameraPanel.setVisibility(0);
        this.cameraPanel.setTag(null);
        int[] iArr = this.animateCameraValues;
        iArr[0] = 0;
        int i2 = this.itemSize;
        iArr[1] = i2;
        iArr[2] = i2;
        this.additionCloseCameraY = 0.0f;
        this.cameraExpanded = true;
        this.cameraView.setFpsLimit(-1);
        if (animated) {
            setCameraOpenProgress(0.0f);
            this.cameraAnimationInProgress = true;
            this.animationIndex = NotificationCenter.getInstance(this.parentAlert.currentAccount).setAnimationInProgress(this.animationIndex, null);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this, "cameraOpenProgress", 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.cameraPanel, (Property<FrameLayout, Float>) View.ALPHA, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.counterTextView, (Property<TextView, Float>) View.ALPHA, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.cameraPhotoRecyclerView, (Property<RecyclerListView, Float>) View.ALPHA, 1.0f));
            int i3 = 0;
            while (true) {
                if (i3 >= 2) {
                    break;
                }
                if (this.flashModeButton[i3].getVisibility() == 0) {
                    arrayList.add(ObjectAnimator.ofFloat(this.flashModeButton[i3], (Property<ImageView, Float>) View.ALPHA, 1.0f));
                    break;
                }
                i3++;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setDuration(350L);
            animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.17
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    NotificationCenter.getInstance(ChatAttachAlertPhotoLayout.this.parentAlert.currentAccount).onAnimationFinish(ChatAttachAlertPhotoLayout.this.animationIndex);
                    ChatAttachAlertPhotoLayout.this.cameraAnimationInProgress = false;
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 < 21 || ChatAttachAlertPhotoLayout.this.cameraView == null) {
                        if (ChatAttachAlertPhotoLayout.this.cameraView != null) {
                            ChatAttachAlertPhotoLayout.this.cameraView.invalidate();
                        }
                    } else {
                        ChatAttachAlertPhotoLayout.this.cameraView.invalidateOutline();
                    }
                    if (ChatAttachAlertPhotoLayout.this.cameraOpened) {
                        ChatAttachAlertPhotoLayout.this.parentAlert.delegate.onCameraOpened();
                    }
                    if (i4 < 21 || ChatAttachAlertPhotoLayout.this.cameraView == null) {
                        return;
                    }
                    ChatAttachAlertPhotoLayout.this.cameraView.setSystemUiVisibility(1028);
                }
            });
            animatorSet.start();
        } else {
            setCameraOpenProgress(1.0f);
            this.cameraPanel.setAlpha(1.0f);
            this.counterTextView.setAlpha(1.0f);
            this.cameraPhotoRecyclerView.setAlpha(1.0f);
            while (true) {
                if (i >= 2) {
                    break;
                }
                if (this.flashModeButton[i].getVisibility() == 0) {
                    this.flashModeButton[i].setAlpha(1.0f);
                    break;
                }
                i++;
            }
            this.parentAlert.delegate.onCameraOpened();
            if (Build.VERSION.SDK_INT >= 21) {
                this.cameraView.setSystemUiVisibility(1028);
            }
        }
        this.cameraOpened = true;
        this.cameraView.setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 19) {
            this.gridView.setImportantForAccessibility(4);
        }
    }

    public void loadGalleryPhotos() {
        MediaController.AlbumEntry albumEntry;
        ChatAttachAlert chatAttachAlert = this.parentAlert;
        if ((chatAttachAlert.baseFragment instanceof ChatActivity) || chatAttachAlert.avatarPicker == 2) {
            albumEntry = MediaController.allMediaAlbumEntry;
        } else {
            albumEntry = MediaController.allPhotosAlbumEntry;
        }
        if (albumEntry != null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        MediaController.loadGalleryPhotosAlbums(0);
    }

    public void showCamera() {
        ChatAttachAlert chatAttachAlert = this.parentAlert;
        if (chatAttachAlert.paused || !this.mediaEnabled) {
            return;
        }
        if (this.cameraView == null) {
            CameraView cameraView = new CameraView(chatAttachAlert.baseFragment.getParentActivity(), this.parentAlert.openWithFrontFaceCamera) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.18
                @Override // ir.eitaa.messenger.camera.CameraView, android.view.ViewGroup, android.view.View
                protected void dispatchDraw(Canvas canvas) {
                    if (Build.VERSION.SDK_INT < 21) {
                        if (!ChatAttachAlertPhotoLayout.this.cameraAnimationInProgress) {
                            if (!ChatAttachAlertPhotoLayout.this.cameraAnimationInProgress && !ChatAttachAlertPhotoLayout.this.cameraOpened) {
                                AndroidUtilities.rectTmp.set(ChatAttachAlertPhotoLayout.this.cameraViewOffsetX, ChatAttachAlertPhotoLayout.this.cameraViewOffsetY, getMeasuredWidth(), getMeasuredHeight());
                            } else {
                                AndroidUtilities.rectTmp.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                            }
                        } else {
                            RectF rectF = AndroidUtilities.rectTmp;
                            ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout = ChatAttachAlertPhotoLayout.this;
                            float f = chatAttachAlertPhotoLayout.animationClipLeft + (chatAttachAlertPhotoLayout.cameraViewOffsetX * (1.0f - ChatAttachAlertPhotoLayout.this.cameraOpenProgress));
                            ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout2 = ChatAttachAlertPhotoLayout.this;
                            float f2 = chatAttachAlertPhotoLayout2.animationClipTop + (chatAttachAlertPhotoLayout2.cameraViewOffsetY * (1.0f - ChatAttachAlertPhotoLayout.this.cameraOpenProgress));
                            ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout3 = ChatAttachAlertPhotoLayout.this;
                            rectF.set(f, f2, chatAttachAlertPhotoLayout3.animationClipRight, chatAttachAlertPhotoLayout3.animationClipBottom);
                        }
                        canvas.save();
                        canvas.clipRect(AndroidUtilities.rectTmp);
                        super.dispatchDraw(canvas);
                        canvas.restore();
                        return;
                    }
                    super.dispatchDraw(canvas);
                }
            };
            this.cameraView = cameraView;
            BaseFragment baseFragment = this.parentAlert.baseFragment;
            cameraView.setRecordFile(AndroidUtilities.generateVideoPath((baseFragment instanceof ChatActivity) && ((ChatActivity) baseFragment).isSecretChat()));
            this.cameraView.setFocusable(true);
            this.cameraView.setFpsLimit(30);
            if (Build.VERSION.SDK_INT >= 21) {
                new Path();
                this.cameraView.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.19
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        if (!ChatAttachAlertPhotoLayout.this.cameraAnimationInProgress) {
                            if (!ChatAttachAlertPhotoLayout.this.cameraAnimationInProgress && !ChatAttachAlertPhotoLayout.this.cameraOpened) {
                                int iDp = AndroidUtilities.dp(ChatAttachAlertPhotoLayout.this.parentAlert.cornerRadius * 8.0f);
                                outline.setRoundRect((int) ChatAttachAlertPhotoLayout.this.cameraViewOffsetX, (int) ChatAttachAlertPhotoLayout.this.cameraViewOffsetY, view.getMeasuredWidth() + iDp, view.getMeasuredHeight() + iDp, iDp);
                                return;
                            } else {
                                outline.setRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                                return;
                            }
                        }
                        RectF rectF = AndroidUtilities.rectTmp;
                        ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout = ChatAttachAlertPhotoLayout.this;
                        float f = chatAttachAlertPhotoLayout.animationClipLeft + (chatAttachAlertPhotoLayout.cameraViewOffsetX * (1.0f - ChatAttachAlertPhotoLayout.this.cameraOpenProgress));
                        ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout2 = ChatAttachAlertPhotoLayout.this;
                        float f2 = chatAttachAlertPhotoLayout2.animationClipTop + (chatAttachAlertPhotoLayout2.cameraViewOffsetY * (1.0f - ChatAttachAlertPhotoLayout.this.cameraOpenProgress));
                        ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout3 = ChatAttachAlertPhotoLayout.this;
                        rectF.set(f, f2, chatAttachAlertPhotoLayout3.animationClipRight, chatAttachAlertPhotoLayout3.animationClipBottom);
                        outline.setRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    }
                });
                this.cameraView.setClipToOutline(true);
            }
            this.cameraView.setContentDescription(LocaleController.getString("AccDescrInstantCamera", R.string.AccDescrInstantCamera));
            FrameLayout container = this.parentAlert.getContainer();
            CameraView cameraView2 = this.cameraView;
            int i = this.itemSize;
            container.addView(cameraView2, 1, new FrameLayout.LayoutParams(i, i));
            this.cameraView.setDelegate(new CameraView.CameraViewDelegate() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.20
                @Override // ir.eitaa.messenger.camera.CameraView.CameraViewDelegate
                public void onCameraCreated(Camera camera) {
                }

                @Override // ir.eitaa.messenger.camera.CameraView.CameraViewDelegate
                public void onCameraInit() {
                    if (ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession().getCurrentFlashMode().equals(ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession().getNextFlashMode())) {
                        for (int i2 = 0; i2 < 2; i2++) {
                            ChatAttachAlertPhotoLayout.this.flashModeButton[i2].setVisibility(4);
                            ChatAttachAlertPhotoLayout.this.flashModeButton[i2].setAlpha(0.0f);
                            ChatAttachAlertPhotoLayout.this.flashModeButton[i2].setTranslationY(0.0f);
                        }
                    } else {
                        ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout = ChatAttachAlertPhotoLayout.this;
                        chatAttachAlertPhotoLayout.setCameraFlashModeIcon(chatAttachAlertPhotoLayout.flashModeButton[0], ChatAttachAlertPhotoLayout.this.cameraView.getCameraSession().getCurrentFlashMode());
                        int i3 = 0;
                        while (i3 < 2) {
                            ChatAttachAlertPhotoLayout.this.flashModeButton[i3].setVisibility(i3 == 0 ? 0 : 4);
                            ChatAttachAlertPhotoLayout.this.flashModeButton[i3].setAlpha((i3 == 0 && ChatAttachAlertPhotoLayout.this.cameraOpened) ? 1.0f : 0.0f);
                            ChatAttachAlertPhotoLayout.this.flashModeButton[i3].setTranslationY(0.0f);
                            i3++;
                        }
                    }
                    ChatAttachAlertPhotoLayout.this.switchCameraButton.setImageResource(ChatAttachAlertPhotoLayout.this.cameraView.isFrontface() ? R.drawable.camera_revert1 : R.drawable.camera_revert2);
                    ChatAttachAlertPhotoLayout.this.switchCameraButton.setVisibility(ChatAttachAlertPhotoLayout.this.cameraView.hasFrontFaceCamera() ? 0 : 4);
                    if (ChatAttachAlertPhotoLayout.this.cameraOpened) {
                        return;
                    }
                    ChatAttachAlertPhotoLayout.this.cameraInitAnimation = new AnimatorSet();
                    ChatAttachAlertPhotoLayout.this.cameraInitAnimation.playTogether(ObjectAnimator.ofFloat(ChatAttachAlertPhotoLayout.this.cameraView, (Property<CameraView, Float>) View.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(ChatAttachAlertPhotoLayout.this.cameraIcon, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f));
                    ChatAttachAlertPhotoLayout.this.cameraInitAnimation.setDuration(180L);
                    ChatAttachAlertPhotoLayout.this.cameraInitAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.20.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (animation.equals(ChatAttachAlertPhotoLayout.this.cameraInitAnimation)) {
                                ChatAttachAlertPhotoLayout.this.canSaveCameraPreview = true;
                                ChatAttachAlertPhotoLayout.this.cameraInitAnimation = null;
                                if (ChatAttachAlertPhotoLayout.this.isHidden) {
                                    return;
                                }
                                int childCount = ChatAttachAlertPhotoLayout.this.gridView.getChildCount();
                                for (int i4 = 0; i4 < childCount; i4++) {
                                    View childAt = ChatAttachAlertPhotoLayout.this.gridView.getChildAt(i4);
                                    if (childAt instanceof PhotoAttachCameraCell) {
                                        childAt.setVisibility(4);
                                        return;
                                    }
                                }
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            ChatAttachAlertPhotoLayout.this.cameraInitAnimation = null;
                        }
                    });
                    ChatAttachAlertPhotoLayout.this.cameraInitAnimation.start();
                }
            });
            if (this.cameraIcon == null) {
                FrameLayout frameLayout = new FrameLayout(this.parentAlert.baseFragment.getParentActivity()) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.21
                    @Override // android.view.View
                    protected void onDraw(Canvas canvas) {
                        int intrinsicWidth = ChatAttachAlertPhotoLayout.this.cameraDrawable.getIntrinsicWidth();
                        int intrinsicHeight = ChatAttachAlertPhotoLayout.this.cameraDrawable.getIntrinsicHeight();
                        int i2 = (ChatAttachAlertPhotoLayout.this.itemSize - intrinsicWidth) / 2;
                        int i3 = (ChatAttachAlertPhotoLayout.this.itemSize - intrinsicHeight) / 2;
                        if (ChatAttachAlertPhotoLayout.this.cameraViewOffsetY != 0.0f) {
                            i3 = (int) (i3 - ChatAttachAlertPhotoLayout.this.cameraViewOffsetY);
                        }
                        ChatAttachAlertPhotoLayout.this.cameraDrawable.setBounds(i2, i3, intrinsicWidth + i2, intrinsicHeight + i3);
                        ChatAttachAlertPhotoLayout.this.cameraDrawable.draw(canvas);
                    }
                };
                this.cameraIcon = frameLayout;
                frameLayout.setWillNotDraw(false);
                this.cameraIcon.setClipChildren(true);
            }
            FrameLayout container2 = this.parentAlert.getContainer();
            FrameLayout frameLayout2 = this.cameraIcon;
            int i2 = this.itemSize;
            container2.addView(frameLayout2, 2, new FrameLayout.LayoutParams(i2, i2));
            this.cameraView.setAlpha(this.mediaEnabled ? 1.0f : 0.2f);
            this.cameraView.setEnabled(this.mediaEnabled);
            this.cameraIcon.setAlpha(this.mediaEnabled ? 1.0f : 0.2f);
            this.cameraIcon.setEnabled(this.mediaEnabled);
            if (this.isHidden) {
                this.cameraView.setVisibility(8);
                this.cameraIcon.setVisibility(8);
            }
            checkCameraViewPosition();
            invalidate();
        }
        ZoomControlView zoomControlView = this.zoomControlView;
        if (zoomControlView != null) {
            zoomControlView.setZoom(0.0f, false);
            this.cameraZoom = 0.0f;
        }
        this.cameraView.setTranslationX(this.cameraViewLocation[0]);
        this.cameraView.setTranslationY(this.cameraViewLocation[1] + this.currentPanTranslationY);
        this.cameraIcon.setTranslationX(this.cameraViewLocation[0]);
        this.cameraIcon.setTranslationY(this.cameraViewLocation[1] + this.cameraViewOffsetY + this.currentPanTranslationY);
    }

    public void hideCamera(boolean async) {
        if (!this.deviceHasGoodCamera || this.cameraView == null) {
            return;
        }
        saveLastCameraBitmap();
        int childCount = this.gridView.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = this.gridView.getChildAt(i);
            if (childAt instanceof PhotoAttachCameraCell) {
                childAt.setVisibility(0);
                ((PhotoAttachCameraCell) childAt).updateBitmap();
                break;
            }
            i++;
        }
        this.cameraView.destroy(async, null);
        AnimatorSet animatorSet = this.cameraInitAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.cameraInitAnimation = null;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$23y06GHo793ugleDQUtwqiy-Ymk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hideCamera$11$ChatAttachAlertPhotoLayout();
            }
        }, 300L);
        this.canSaveCameraPreview = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hideCamera$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hideCamera$11$ChatAttachAlertPhotoLayout() {
        this.parentAlert.getContainer().removeView(this.cameraView);
        this.parentAlert.getContainer().removeView(this.cameraIcon);
        this.cameraView = null;
        this.cameraIcon = null;
    }

    private void saveLastCameraBitmap() {
        if (this.canSaveCameraPreview) {
            try {
                Bitmap bitmap = this.cameraView.getTextureView().getBitmap();
                if (bitmap != null) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), this.cameraView.getMatrix(), true);
                    bitmap.recycle();
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, 80, (int) (bitmapCreateBitmap.getHeight() / (bitmapCreateBitmap.getWidth() / 80.0f)), true);
                    if (bitmapCreateScaledBitmap != null) {
                        if (bitmapCreateScaledBitmap != bitmapCreateBitmap) {
                            bitmapCreateBitmap.recycle();
                        }
                        Utilities.blurBitmap(bitmapCreateScaledBitmap, 7, 1, bitmapCreateScaledBitmap.getWidth(), bitmapCreateScaledBitmap.getHeight(), bitmapCreateScaledBitmap.getRowBytes());
                        bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 87, new FileOutputStream(new File(ApplicationLoader.getFilesDirFixed(), "cthumb.jpg")));
                        bitmapCreateScaledBitmap.recycle();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:27|(1:29)|30|(1:36)(1:35)|(2:38|(4:49|50|(1:54)|55)(7:40|(1:42)|43|(1:45)|(0)|50|(3:52|54|55)(0)))(1:56)|(1:62)|63|103|100|64|(4:108|65|(2:67|68)|69)|102|83|106|84|88|114) */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0198, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0199, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x014a -> B:102:0x0163). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResultFragment(int r29, android.content.Intent r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.onActivityResultFragment(int, android.content.Intent, java.lang.String):void");
    }

    public void closeCamera(boolean animated) {
        if (this.takingPhoto || this.cameraView == null) {
            return;
        }
        int[] iArr = this.animateCameraValues;
        int i = this.itemSize;
        iArr[1] = i;
        iArr[2] = i;
        Runnable runnable = this.zoomControlHideRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.zoomControlHideRunnable = null;
        }
        if (animated) {
            this.additionCloseCameraY = this.cameraView.getTranslationY();
            this.cameraAnimationInProgress = true;
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this, "cameraOpenProgress", 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.cameraPanel, (Property<FrameLayout, Float>) View.ALPHA, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.zoomControlView, (Property<ZoomControlView, Float>) View.ALPHA, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.counterTextView, (Property<TextView, Float>) View.ALPHA, 0.0f));
            arrayList.add(ObjectAnimator.ofFloat(this.cameraPhotoRecyclerView, (Property<RecyclerListView, Float>) View.ALPHA, 0.0f));
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    break;
                }
                if (this.flashModeButton[i2].getVisibility() == 0) {
                    arrayList.add(ObjectAnimator.ofFloat(this.flashModeButton[i2], (Property<ImageView, Float>) View.ALPHA, 0.0f));
                    break;
                }
                i2++;
            }
            this.animationIndex = NotificationCenter.getInstance(this.parentAlert.currentAccount).setAnimationInProgress(this.animationIndex, null);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setDuration(220L);
            animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.22
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    NotificationCenter.getInstance(ChatAttachAlertPhotoLayout.this.parentAlert.currentAccount).onAnimationFinish(ChatAttachAlertPhotoLayout.this.animationIndex);
                    ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout = ChatAttachAlertPhotoLayout.this;
                    chatAttachAlertPhotoLayout.cameraExpanded = false;
                    chatAttachAlertPhotoLayout.setCameraOpenProgress(0.0f);
                    ChatAttachAlertPhotoLayout.this.cameraAnimationInProgress = false;
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 < 21 || ChatAttachAlertPhotoLayout.this.cameraView == null) {
                        if (ChatAttachAlertPhotoLayout.this.cameraView != null) {
                            ChatAttachAlertPhotoLayout.this.cameraView.invalidate();
                        }
                    } else {
                        ChatAttachAlertPhotoLayout.this.cameraView.invalidateOutline();
                    }
                    ChatAttachAlertPhotoLayout.this.cameraOpened = false;
                    if (ChatAttachAlertPhotoLayout.this.cameraPanel != null) {
                        ChatAttachAlertPhotoLayout.this.cameraPanel.setVisibility(8);
                    }
                    if (ChatAttachAlertPhotoLayout.this.zoomControlView != null) {
                        ChatAttachAlertPhotoLayout.this.zoomControlView.setVisibility(8);
                        ChatAttachAlertPhotoLayout.this.zoomControlView.setTag(null);
                    }
                    if (ChatAttachAlertPhotoLayout.this.cameraPhotoRecyclerView != null) {
                        ChatAttachAlertPhotoLayout.this.cameraPhotoRecyclerView.setVisibility(8);
                    }
                    if (ChatAttachAlertPhotoLayout.this.cameraView != null) {
                        ChatAttachAlertPhotoLayout.this.cameraView.setFpsLimit(30);
                        if (i3 >= 21) {
                            ChatAttachAlertPhotoLayout.this.cameraView.setSystemUiVisibility(Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV);
                        }
                    }
                }
            });
            animatorSet.start();
        } else {
            this.cameraExpanded = false;
            setCameraOpenProgress(0.0f);
            this.animateCameraValues[0] = 0;
            setCameraOpenProgress(0.0f);
            this.cameraPanel.setAlpha(0.0f);
            this.cameraPanel.setVisibility(8);
            this.zoomControlView.setAlpha(0.0f);
            this.zoomControlView.setTag(null);
            this.zoomControlView.setVisibility(8);
            this.cameraPhotoRecyclerView.setAlpha(0.0f);
            this.counterTextView.setAlpha(0.0f);
            this.cameraPhotoRecyclerView.setVisibility(8);
            int i3 = 0;
            while (true) {
                if (i3 >= 2) {
                    break;
                }
                if (this.flashModeButton[i3].getVisibility() == 0) {
                    this.flashModeButton[i3].setAlpha(0.0f);
                    break;
                }
                i3++;
            }
            this.cameraOpened = false;
            this.cameraView.setFpsLimit(30);
            if (Build.VERSION.SDK_INT >= 21) {
                this.cameraView.setSystemUiVisibility(Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV);
            }
        }
        this.cameraView.setImportantForAccessibility(0);
        if (Build.VERSION.SDK_INT >= 19) {
            this.gridView.setImportantForAccessibility(0);
        }
    }

    @Keep
    public void setCameraOpenProgress(float value) {
        int i;
        int i2;
        if (this.cameraView == null) {
            return;
        }
        this.cameraOpenProgress = value;
        int[] iArr = this.animateCameraValues;
        float f = iArr[1];
        float f2 = iArr[2];
        android.graphics.Point point = AndroidUtilities.displaySize;
        int i3 = point.x;
        int i4 = point.y;
        float width = (this.parentAlert.getContainer().getWidth() - this.parentAlert.getLeftInset()) - this.parentAlert.getRightInset();
        float height = this.parentAlert.getContainer().getHeight() - this.parentAlert.getBottomInset();
        float[] fArr = this.cameraViewLocation;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = this.additionCloseCameraY;
        if (value == 0.0f) {
            this.cameraIcon.setTranslationX(fArr[0]);
            this.cameraIcon.setTranslationY(this.cameraViewLocation[1] + this.cameraViewOffsetY);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cameraView.getLayoutParams();
        float textureHeight = this.cameraView.getTextureHeight(f, f2) / this.cameraView.getTextureHeight(width, height);
        float f6 = f2 / height;
        float f7 = f / width;
        if (this.cameraExpanded) {
            i = (int) width;
            i2 = (int) height;
            float f8 = 1.0f - value;
            float f9 = (textureHeight * f8) + value;
            this.cameraView.getTextureView().setScaleX(f9);
            this.cameraView.getTextureView().setScaleY(f9);
            float f10 = ((1.0f - ((f6 * f8) + value)) * height) / 2.0f;
            float f11 = f3 * f8;
            this.cameraView.setTranslationX((f11 + (value * 0.0f)) - (((1.0f - ((f7 * f8) + value)) * width) / 2.0f));
            float f12 = f4 * f8;
            this.cameraView.setTranslationY(((f5 * value) + f12) - f10);
            this.animationClipTop = f12 - this.cameraView.getTranslationY();
            this.animationClipBottom = (((f4 + f2) * f8) - this.cameraView.getTranslationY()) + (height * value);
            this.animationClipLeft = f11 - this.cameraView.getTranslationX();
            this.animationClipRight = (((f3 + f) * f8) - this.cameraView.getTranslationX()) + (width * value);
        } else {
            i = (int) f;
            i2 = (int) f2;
            this.cameraView.getTextureView().setScaleX(1.0f);
            this.cameraView.getTextureView().setScaleY(1.0f);
            this.animationClipTop = 0.0f;
            this.animationClipBottom = height;
            this.animationClipLeft = 0.0f;
            this.animationClipRight = width;
            this.cameraView.setTranslationX(f3);
            this.cameraView.setTranslationY(f4);
        }
        if (value <= 0.5f) {
            this.cameraIcon.setAlpha(1.0f - (value / 0.5f));
        } else {
            this.cameraIcon.setAlpha(0.0f);
        }
        if (layoutParams.width != i || layoutParams.height != i2) {
            layoutParams.width = i;
            layoutParams.height = i2;
            this.cameraView.requestLayout();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.cameraView.invalidateOutline();
        } else {
            this.cameraView.invalidate();
        }
    }

    @Keep
    public float getCameraOpenProgress() {
        return this.cameraOpenProgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCameraViewPosition() {
        TextView textView;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            CameraView cameraView = this.cameraView;
            if (cameraView != null) {
                cameraView.invalidateOutline();
            }
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = this.gridView.findViewHolderForAdapterPosition(this.itemsPerRow - 1);
            if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                viewHolderFindViewHolderForAdapterPosition2.itemView.invalidateOutline();
            }
            if ((!this.adapter.needCamera || !this.deviceHasGoodCamera || this.selectedAlbumEntry != this.galleryAlbumEntry) && (viewHolderFindViewHolderForAdapterPosition = this.gridView.findViewHolderForAdapterPosition(0)) != null) {
                viewHolderFindViewHolderForAdapterPosition.itemView.invalidateOutline();
            }
        }
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 != null) {
            cameraView2.invalidate();
        }
        if (i >= 23 && (textView = this.recordTime) != null) {
            ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).topMargin = getRootWindowInsets() == null ? AndroidUtilities.dp(16.0f) : getRootWindowInsets().getSystemWindowInsetTop() + AndroidUtilities.dp(2.0f);
        }
        if (this.deviceHasGoodCamera) {
            int childCount = this.gridView.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = this.gridView.getChildAt(i2);
                if (childAt instanceof PhotoAttachCameraCell) {
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 < 19 || childAt.isAttachedToWindow()) {
                        float y = childAt.getY() + this.gridView.getY() + getY();
                        float y2 = this.parentAlert.getSheetContainer().getY() + y;
                        float x = childAt.getX() + this.gridView.getX() + getX() + this.parentAlert.getSheetContainer().getX();
                        if (i3 >= 23) {
                            x -= getRootWindowInsets().getSystemWindowInsetLeft();
                        }
                        float currentActionBarHeight = ((i3 < 21 || this.parentAlert.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight) + ActionBar.getCurrentActionBarHeight();
                        float f = y < currentActionBarHeight ? currentActionBarHeight - y : 0.0f;
                        if (f != this.cameraViewOffsetY) {
                            this.cameraViewOffsetY = f;
                            CameraView cameraView3 = this.cameraView;
                            if (cameraView3 != null) {
                                if (i3 >= 21) {
                                    cameraView3.invalidateOutline();
                                } else {
                                    cameraView3.invalidate();
                                }
                            }
                            FrameLayout frameLayout = this.cameraIcon;
                            if (frameLayout != null) {
                                frameLayout.invalidate();
                            }
                        }
                        float measuredHeight = (int) ((this.parentAlert.getSheetContainer().getMeasuredHeight() - this.parentAlert.buttonsRecyclerView.getMeasuredHeight()) + this.parentAlert.buttonsRecyclerView.getTranslationY());
                        if (childAt.getMeasuredHeight() + y > measuredHeight) {
                            this.cameraViewOffsetBottomY = (y + childAt.getMeasuredHeight()) - measuredHeight;
                        } else {
                            this.cameraViewOffsetBottomY = 0.0f;
                        }
                        float[] fArr = this.cameraViewLocation;
                        fArr[0] = x;
                        fArr[1] = y2;
                        applyCameraViewPosition();
                        return;
                    }
                } else {
                    i2++;
                }
            }
            if (this.cameraViewOffsetY != 0.0f || this.cameraViewOffsetX != 0.0f) {
                this.cameraViewOffsetX = 0.0f;
                this.cameraViewOffsetY = 0.0f;
                CameraView cameraView4 = this.cameraView;
                if (cameraView4 != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        cameraView4.invalidateOutline();
                    } else {
                        cameraView4.invalidate();
                    }
                }
                FrameLayout frameLayout2 = this.cameraIcon;
                if (frameLayout2 != null) {
                    frameLayout2.invalidate();
                }
            }
            this.cameraViewLocation[0] = AndroidUtilities.dp(-400.0f);
            this.cameraViewLocation[1] = 0.0f;
            applyCameraViewPosition();
        }
    }

    private void applyCameraViewPosition() {
        CameraView cameraView = this.cameraView;
        if (cameraView != null) {
            if (!this.cameraOpened) {
                cameraView.setTranslationX(this.cameraViewLocation[0]);
                this.cameraView.setTranslationY(this.cameraViewLocation[1] + this.currentPanTranslationY);
            }
            this.cameraIcon.setTranslationX(this.cameraViewLocation[0]);
            this.cameraIcon.setTranslationY(this.cameraViewLocation[1] + this.cameraViewOffsetY + this.currentPanTranslationY);
            int i = this.itemSize;
            if (!this.cameraOpened) {
                this.cameraView.setClipTop((int) this.cameraViewOffsetY);
                this.cameraView.setClipBottom((int) this.cameraViewOffsetBottomY);
                final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cameraView.getLayoutParams();
                if (layoutParams.height != i || layoutParams.width != i) {
                    layoutParams.width = i;
                    layoutParams.height = i;
                    this.cameraView.setLayoutParams(layoutParams);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$OXJs740mN98HFamMkOGadGxePDQ
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$applyCameraViewPosition$12$ChatAttachAlertPhotoLayout(layoutParams);
                        }
                    });
                }
            }
            int i2 = this.itemSize;
            int i3 = (int) (i2 - this.cameraViewOffsetX);
            int i4 = (int) ((i2 - this.cameraViewOffsetY) - this.cameraViewOffsetBottomY);
            final FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cameraIcon.getLayoutParams();
            if (layoutParams2.height == i4 && layoutParams2.width == i3) {
                return;
            }
            layoutParams2.width = i3;
            layoutParams2.height = i4;
            this.cameraIcon.setLayoutParams(layoutParams2);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$bKMszT1WiRY0tgPRt8na4aGqfMk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$applyCameraViewPosition$13$ChatAttachAlertPhotoLayout(layoutParams2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyCameraViewPosition$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyCameraViewPosition$12$ChatAttachAlertPhotoLayout(FrameLayout.LayoutParams layoutParams) {
        CameraView cameraView = this.cameraView;
        if (cameraView != null) {
            cameraView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyCameraViewPosition$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyCameraViewPosition$13$ChatAttachAlertPhotoLayout(FrameLayout.LayoutParams layoutParams) {
        FrameLayout frameLayout = this.cameraIcon;
        if (frameLayout != null) {
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    public HashMap<Object, Object> getSelectedPhotos() {
        return selectedPhotos;
    }

    public ArrayList<Object> getSelectedPhotosOrder() {
        return selectedPhotosOrder;
    }

    public void checkStorage() {
        if (!this.noGalleryPermissions || Build.VERSION.SDK_INT < 23) {
            return;
        }
        boolean z = this.parentAlert.baseFragment.getParentActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0;
        this.noGalleryPermissions = z;
        if (!z) {
            loadGalleryPhotos();
        }
        this.adapter.notifyDataSetChanged();
        this.cameraAttachAdapter.notifyDataSetChanged();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void scrollToTop() {
        this.gridView.smoothScrollToPosition(0);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onMenuItemClick(int id) {
        TLRPC$Chat currentChat;
        if ((id == 0 || id == 1) && this.parentAlert.maxSelectedPhotos > 0 && selectedPhotosOrder.size() > 1) {
            BaseFragment baseFragment = this.parentAlert.baseFragment;
            if ((baseFragment instanceof ChatActivity) && (currentChat = ((ChatActivity) baseFragment).getCurrentChat()) != null && !ChatObject.hasAdminRights(currentChat) && currentChat.slowmode_enabled) {
                AlertsCreator.createSimpleAlert(getContext(), LocaleController.getString("Slowmode", R.string.Slowmode), LocaleController.getString("SlowmodeSendError", R.string.SlowmodeSendError), this.resourcesProvider).show();
                return;
            }
        }
        if (id == 0) {
            ChatAttachAlert chatAttachAlert = this.parentAlert;
            if (chatAttachAlert.editingMessageObject == null) {
                BaseFragment baseFragment2 = chatAttachAlert.baseFragment;
                if ((baseFragment2 instanceof ChatActivity) && ((ChatActivity) baseFragment2).isInScheduleMode()) {
                    AlertsCreator.createScheduleDatePickerDialog(getContext(), ((ChatActivity) this.parentAlert.baseFragment).getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$c2mhcJC3AvVsmU5v8dTYZYDAuZ4
                        @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                        public final void didSelectDate(boolean z, int i) {
                            this.f$0.lambda$onMenuItemClick$14$ChatAttachAlertPhotoLayout(z, i);
                        }
                    }, this.resourcesProvider);
                    return;
                }
            }
            this.parentAlert.applyCaption();
            this.parentAlert.delegate.didPressedButton(7, false, true, 0, false);
            return;
        }
        if (id == 1) {
            ChatAttachAlert chatAttachAlert2 = this.parentAlert;
            if (chatAttachAlert2.editingMessageObject == null) {
                BaseFragment baseFragment3 = chatAttachAlert2.baseFragment;
                if ((baseFragment3 instanceof ChatActivity) && ((ChatActivity) baseFragment3).isInScheduleMode()) {
                    AlertsCreator.createScheduleDatePickerDialog(getContext(), ((ChatActivity) this.parentAlert.baseFragment).getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$FAx0WwtUa3Y6F0_VqaSsBG_t8rY
                        @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                        public final void didSelectDate(boolean z, int i) {
                            this.f$0.lambda$onMenuItemClick$15$ChatAttachAlertPhotoLayout(z, i);
                        }
                    }, this.resourcesProvider);
                    return;
                }
            }
            this.parentAlert.applyCaption();
            this.parentAlert.delegate.didPressedButton(4, true, true, 0, false);
            return;
        }
        if (id != 2) {
            if (id >= 10) {
                MediaController.AlbumEntry albumEntry = this.dropDownAlbums.get(id - 10);
                this.selectedAlbumEntry = albumEntry;
                if (albumEntry == this.galleryAlbumEntry) {
                    this.dropDown.setText(LocaleController.getString("ChatGallery", R.string.ChatGallery));
                } else {
                    this.dropDown.setText(albumEntry.bucketName);
                }
                this.adapter.notifyDataSetChanged();
                this.cameraAttachAdapter.notifyDataSetChanged();
                this.layoutManager.scrollToPositionWithOffset(0, (-this.gridView.getPaddingTop()) + AndroidUtilities.dp(7.0f));
                return;
            }
            return;
        }
        try {
            ChatAttachAlert chatAttachAlert3 = this.parentAlert;
            if ((chatAttachAlert3.baseFragment instanceof ChatActivity) || chatAttachAlert3.avatarPicker == 2) {
                Intent intent = new Intent();
                intent.setType("video/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                intent.putExtra("android.intent.extra.sizeLimit", FileLoader.MAX_FILE_SIZE);
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                Intent intentCreateChooser = Intent.createChooser(intent2, null);
                intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent});
                ChatAttachAlert chatAttachAlert4 = this.parentAlert;
                if (chatAttachAlert4.avatarPicker != 0) {
                    chatAttachAlert4.baseFragment.startActivityForResult(intentCreateChooser, 14);
                } else {
                    chatAttachAlert4.baseFragment.startActivityForResult(intentCreateChooser, 1);
                }
            } else {
                Intent intent3 = new Intent("android.intent.action.PICK");
                intent3.setType("image/*");
                ChatAttachAlert chatAttachAlert5 = this.parentAlert;
                if (chatAttachAlert5.avatarPicker != 0) {
                    chatAttachAlert5.baseFragment.startActivityForResult(intent3, 14);
                } else {
                    chatAttachAlert5.baseFragment.startActivityForResult(intent3, 1);
                }
            }
            this.parentAlert.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onMenuItemClick$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onMenuItemClick$14$ChatAttachAlertPhotoLayout(boolean z, int i) {
        this.parentAlert.applyCaption();
        this.parentAlert.delegate.didPressedButton(7, false, z, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onMenuItemClick$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onMenuItemClick$15$ChatAttachAlertPhotoLayout(boolean z, int i) {
        this.parentAlert.applyCaption();
        this.parentAlert.delegate.didPressedButton(4, true, z, i, false);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getSelectedItemsCount() {
        return selectedPhotosOrder.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void onSelectedItemsCountChanged(int r6) {
        /*
            r5 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r6 <= r2) goto L12
            ir.eitaa.ui.Components.ChatAttachAlert r3 = r5.parentAlert
            ir.eitaa.messenger.MessageObject r4 = r3.editingMessageObject
            if (r4 == 0) goto Lc
            goto L12
        Lc:
            ir.eitaa.ui.ActionBar.ActionBarMenuItem r2 = r3.selectedMenuItem
            r2.showSubItem(r1)
            goto L31
        L12:
            ir.eitaa.ui.Components.ChatAttachAlert r3 = r5.parentAlert
            ir.eitaa.ui.ActionBar.ActionBarMenuItem r3 = r3.selectedMenuItem
            r3.hideSubItem(r1)
            if (r6 != 0) goto L2a
            ir.eitaa.ui.Components.ChatAttachAlert r1 = r5.parentAlert
            ir.eitaa.ui.ActionBar.ActionBarMenuItem r1 = r1.selectedMenuItem
            r1.showSubItem(r0)
            ir.eitaa.ui.Components.ChatAttachAlert r1 = r5.parentAlert
            ir.eitaa.ui.ActionBar.ActionBarMenuItem r1 = r1.selectedMenuItem
            r1.hideSubItem(r2)
            goto L31
        L2a:
            ir.eitaa.ui.Components.ChatAttachAlert r1 = r5.parentAlert
            ir.eitaa.ui.ActionBar.ActionBarMenuItem r1 = r1.selectedMenuItem
            r1.showSubItem(r2)
        L31:
            if (r6 == 0) goto L3a
            ir.eitaa.ui.Components.ChatAttachAlert r6 = r5.parentAlert
            ir.eitaa.ui.ActionBar.ActionBarMenuItem r6 = r6.selectedMenuItem
            r6.hideSubItem(r0)
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.onSelectedItemsCountChanged(int):void");
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void applyCaption(String text) {
        Object obj = selectedPhotos.get(Integer.valueOf(((Integer) selectedPhotosOrder.get(0)).intValue()));
        if (obj instanceof MediaController.PhotoEntry) {
            ((MediaController.PhotoEntry) obj).caption = text;
        } else if (obj instanceof MediaController.SearchImage) {
            ((MediaController.SearchImage) obj).caption = text;
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onDestroy() {
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.cameraInitied);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.albumsDidLoad);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onPause() throws InterruptedException {
        ShutterButton shutterButton = this.shutterButton;
        if (shutterButton == null) {
            return;
        }
        if (!this.requestingPermissions) {
            if (this.cameraView != null && shutterButton.getState() == ShutterButton.State.RECORDING) {
                resetRecordState();
                CameraController.getInstance().stopVideoRecording(this.cameraView.getCameraSession(), false);
                this.shutterButton.setState(ShutterButton.State.DEFAULT, true);
            }
            if (this.cameraOpened) {
                closeCamera(false);
            }
            hideCamera(true);
            return;
        }
        if (this.cameraView != null && shutterButton.getState() == ShutterButton.State.RECORDING) {
            this.shutterButton.setState(ShutterButton.State.DEFAULT, true);
        }
        this.requestingPermissions = false;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onResume() {
        if (!this.parentAlert.isShowing() || this.parentAlert.isDismissed()) {
            return;
        }
        checkCamera(false);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getListTopPadding() {
        return this.gridView.getPaddingTop();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getCurrentItemTop() {
        if (this.gridView.getChildCount() <= 0) {
            RecyclerListView recyclerListView = this.gridView;
            recyclerListView.setTopGlowOffset(recyclerListView.getPaddingTop());
            this.progressView.setTranslationY(0.0f);
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        View childAt = this.gridView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.gridView.findContainingViewHolder(childAt);
        int top = childAt.getTop();
        int iDp = AndroidUtilities.dp(7.0f);
        if (top < AndroidUtilities.dp(7.0f) || holder == null || holder.getAdapterPosition() != 0) {
            top = iDp;
        }
        this.progressView.setTranslationY(((((getMeasuredHeight() - top) - AndroidUtilities.dp(50.0f)) - this.progressView.getMeasuredHeight()) / 2) + top);
        this.gridView.setTopGlowOffset(top);
        return top;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getFirstOffset() {
        return getListTopPadding() + AndroidUtilities.dp(56.0f);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void checkColors() {
        FrameLayout frameLayout = this.cameraIcon;
        if (frameLayout != null) {
            frameLayout.invalidate();
        }
        String str = this.forceDarkTheme ? "voipgroup_actionBarItems" : "dialogTextBlack";
        Theme.setDrawableColor(this.cameraDrawable, getThemedColor("dialogCameraIcon"));
        this.progressView.setTextColor(getThemedColor("emptyListPlaceholder"));
        this.gridView.setGlowColor(getThemedColor("dialogScrollGlow"));
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.gridView.findViewHolderForAdapterPosition(0);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            View view = viewHolderFindViewHolderForAdapterPosition.itemView;
            if (view instanceof PhotoAttachCameraCell) {
                ((PhotoAttachCameraCell) view).getImageView().setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogCameraIcon"), PorterDuff.Mode.MULTIPLY));
            }
        }
        this.dropDown.setTextColor(getThemedColor(str));
        this.dropDownContainer.setPopupItemsColor(getThemedColor(this.forceDarkTheme ? "voipgroup_actionBarItems" : "actionBarDefaultSubmenuItem"), false);
        this.dropDownContainer.setPopupItemsColor(getThemedColor(this.forceDarkTheme ? "voipgroup_actionBarItems" : "actionBarDefaultSubmenuItem"), true);
        this.dropDownContainer.redrawPopup(getThemedColor(this.forceDarkTheme ? "voipgroup_actionBarUnscrolled" : "actionBarDefaultSubmenuBackground"));
        Theme.setDrawableColor(this.dropDownDrawable, getThemedColor(str));
    }

    void onInit(boolean hasMedia) {
        this.mediaEnabled = hasMedia;
        CameraView cameraView = this.cameraView;
        if (cameraView != null) {
            cameraView.setAlpha(hasMedia ? 1.0f : 0.2f);
            this.cameraView.setEnabled(this.mediaEnabled);
        }
        FrameLayout frameLayout = this.cameraIcon;
        if (frameLayout != null) {
            frameLayout.setAlpha(this.mediaEnabled ? 1.0f : 0.2f);
            this.cameraIcon.setEnabled(this.mediaEnabled);
        }
        ChatAttachAlert chatAttachAlert = this.parentAlert;
        BaseFragment baseFragment = chatAttachAlert.baseFragment;
        if ((baseFragment instanceof ChatActivity) && chatAttachAlert.avatarPicker == 0) {
            this.galleryAlbumEntry = MediaController.allMediaAlbumEntry;
            if (this.mediaEnabled) {
                this.progressView.setText(LocaleController.getString("NoPhotos", R.string.NoPhotos));
            } else {
                TLRPC$Chat currentChat = ((ChatActivity) baseFragment).getCurrentChat();
                if (ChatObject.isActionBannedByDefault(currentChat, 7)) {
                    this.progressView.setText(LocaleController.getString("GlobalAttachMediaRestricted", R.string.GlobalAttachMediaRestricted));
                } else if (AndroidUtilities.isBannedForever(currentChat.banned_rights)) {
                    this.progressView.setText(LocaleController.formatString("AttachMediaRestrictedForever", R.string.AttachMediaRestrictedForever, new Object[0]));
                } else {
                    this.progressView.setText(LocaleController.formatString("AttachMediaRestricted", R.string.AttachMediaRestricted, LocaleController.formatDateForBan(currentChat.banned_rights.until_date)));
                }
            }
        } else if (chatAttachAlert.avatarPicker == 2) {
            this.galleryAlbumEntry = MediaController.allMediaAlbumEntry;
        } else {
            this.galleryAlbumEntry = MediaController.allPhotosAlbumEntry;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.noGalleryPermissions = this.parentAlert.baseFragment.getParentActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0;
        }
        if (this.galleryAlbumEntry != null) {
            for (int i = 0; i < Math.min(100, this.galleryAlbumEntry.photos.size()); i++) {
                this.galleryAlbumEntry.photos.get(i).reset();
            }
        }
        clearSelectedPhotos();
        updatePhotosCounter(false);
        this.cameraPhotoLayoutManager.scrollToPositionWithOffset(0, MediaController.VIDEO_BITRATE_480);
        this.layoutManager.scrollToPositionWithOffset(0, MediaController.VIDEO_BITRATE_480);
        this.dropDown.setText(LocaleController.getString("ChatGallery", R.string.ChatGallery));
        MediaController.AlbumEntry albumEntry = this.galleryAlbumEntry;
        this.selectedAlbumEntry = albumEntry;
        if (albumEntry != null) {
            this.loading = false;
            EmptyTextProgressView emptyTextProgressView = this.progressView;
            if (emptyTextProgressView != null) {
                emptyTextProgressView.showTextView();
            }
        }
        updateAlbumsDropDown();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onButtonsTranslationYUpdated() {
        checkCameraViewPosition();
        invalidate();
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        if (this.parentAlert.getSheetAnimationType() == 1) {
            float f = (translationY / 40.0f) * (-0.1f);
            int childCount = this.gridView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gridView.getChildAt(i);
                if (childAt instanceof PhotoAttachCameraCell) {
                    PhotoAttachCameraCell photoAttachCameraCell = (PhotoAttachCameraCell) childAt;
                    float f2 = 1.0f + f;
                    photoAttachCameraCell.getImageView().setScaleX(f2);
                    photoAttachCameraCell.getImageView().setScaleY(f2);
                } else if (childAt instanceof PhotoAttachPhotoCell) {
                    PhotoAttachPhotoCell photoAttachPhotoCell = (PhotoAttachPhotoCell) childAt;
                    float f3 = 1.0f + f;
                    photoAttachPhotoCell.getCheckBox().setScaleX(f3);
                    photoAttachPhotoCell.getCheckBox().setScaleY(f3);
                }
            }
        }
        super.setTranslationY(translationY);
        this.parentAlert.getSheetContainer().invalidate();
        invalidate();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onShow() {
        clearSelectedPhotos();
        this.parentAlert.actionBar.setTitle("");
        this.layoutManager.scrollToPositionWithOffset(0, 0);
        this.dropDownContainer.setVisibility(0);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onShown() {
        this.isHidden = false;
        CameraView cameraView = this.cameraView;
        if (cameraView != null) {
            cameraView.setVisibility(0);
        }
        FrameLayout frameLayout = this.cameraIcon;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        if (this.cameraView != null) {
            int childCount = this.gridView.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = this.gridView.getChildAt(i);
                if (childAt instanceof PhotoAttachCameraCell) {
                    childAt.setVisibility(4);
                    break;
                }
                i++;
            }
        }
        if (this.checkCameraWhenShown) {
            this.checkCameraWhenShown = false;
            checkCamera(true);
        }
    }

    public void setCheckCameraWhenShown(boolean checkCameraWhenShown) {
        this.checkCameraWhenShown = checkCameraWhenShown;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onHideShowProgress(float progress) {
        CameraView cameraView = this.cameraView;
        if (cameraView != null) {
            cameraView.setAlpha(progress);
            this.cameraIcon.setAlpha(progress);
            if (progress != 0.0f && this.cameraView.getVisibility() != 0) {
                this.cameraView.setVisibility(0);
                this.cameraIcon.setVisibility(0);
            } else {
                if (progress != 0.0f || this.cameraView.getVisibility() == 4) {
                    return;
                }
                this.cameraView.setVisibility(4);
                this.cameraIcon.setVisibility(4);
            }
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    public void onHide() {
        this.isHidden = true;
        this.dropDownContainer.setVisibility(8);
        int childCount = this.gridView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gridView.getChildAt(i);
            if (childAt instanceof PhotoAttachCameraCell) {
                childAt.setVisibility(0);
                saveLastCameraBitmap();
                ((PhotoAttachCameraCell) childAt).updateBitmap();
                return;
            }
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onHidden() {
        CameraView cameraView = this.cameraView;
        if (cameraView != null) {
            cameraView.setVisibility(8);
            this.cameraIcon.setVisibility(8);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = right - left;
        if (this.lastNotifyWidth != i) {
            this.lastNotifyWidth = i;
            PhotoAttachAdapter photoAttachAdapter = this.adapter;
            if (photoAttachAdapter != null) {
                photoAttachAdapter.notifyDataSetChanged();
            }
        }
        super.onLayout(changed, left, top, right, bottom);
        checkCameraViewPosition();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f1  */
    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPreMeasure(int r6, int r7) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.onPreMeasure(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPreMeasure$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPreMeasure$16$ChatAttachAlertPhotoLayout() {
        this.adapter.notifyDataSetChanged();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    boolean canDismissWithTouchOutside() {
        return !this.cameraOpened;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onContainerTranslationUpdated(float currentPanTranslationY) {
        this.currentPanTranslationY = currentPanTranslationY;
        checkCameraViewPosition();
        invalidate();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onOpenAnimationEnd() {
        checkCamera(true);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onDismissWithButtonClick(int item) {
        hideCamera((item == 0 || item == 2) ? false : true);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    public boolean onDismiss() {
        if (this.cameraAnimationInProgress) {
            return true;
        }
        if (this.cameraOpened) {
            closeCamera(true);
            return true;
        }
        hideCamera(true);
        return false;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    public boolean onSheetKeyDown(int keyCode, KeyEvent event) {
        if (!this.cameraOpened) {
            return false;
        }
        if (keyCode != 24 && keyCode != 25 && keyCode != 79 && keyCode != 85) {
            return false;
        }
        this.shutterButton.getDelegate().shutterReleased();
        return true;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    public boolean onContainerViewTouchEvent(MotionEvent event) {
        if (this.cameraAnimationInProgress) {
            return true;
        }
        if (this.cameraOpened) {
            return processTouchEvent(event);
        }
        return false;
    }

    public boolean onCustomMeasure(View view, int width, int height) {
        boolean z = width < height;
        FrameLayout frameLayout = this.cameraIcon;
        if (view == frameLayout) {
            frameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.itemSize, 1073741824), View.MeasureSpec.makeMeasureSpec((int) ((this.itemSize - this.cameraViewOffsetBottomY) - this.cameraViewOffsetY), 1073741824));
            return true;
        }
        CameraView cameraView = this.cameraView;
        if (view == cameraView) {
            if (this.cameraOpened && !this.cameraAnimationInProgress) {
                cameraView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                return true;
            }
        } else {
            FrameLayout frameLayout2 = this.cameraPanel;
            if (view == frameLayout2) {
                if (z) {
                    frameLayout2.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(126.0f), 1073741824));
                } else {
                    frameLayout2.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(126.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                }
                return true;
            }
            ZoomControlView zoomControlView = this.zoomControlView;
            if (view == zoomControlView) {
                if (z) {
                    zoomControlView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824));
                } else {
                    zoomControlView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                }
                return true;
            }
            RecyclerListView recyclerListView = this.cameraPhotoRecyclerView;
            if (view == recyclerListView) {
                this.cameraPhotoRecyclerViewIgnoreLayout = true;
                if (z) {
                    recyclerListView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824));
                    if (this.cameraPhotoLayoutManager.getOrientation() != 0) {
                        this.cameraPhotoRecyclerView.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
                        this.cameraPhotoLayoutManager.setOrientation(0);
                        this.cameraAttachAdapter.notifyDataSetChanged();
                    }
                } else {
                    recyclerListView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                    if (this.cameraPhotoLayoutManager.getOrientation() != 1) {
                        this.cameraPhotoRecyclerView.setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
                        this.cameraPhotoLayoutManager.setOrientation(1);
                        this.cameraAttachAdapter.notifyDataSetChanged();
                    }
                }
                this.cameraPhotoRecyclerViewIgnoreLayout = false;
                return true;
            }
        }
        return false;
    }

    protected boolean onCustomLayout(View view, int left, int top, int right, int bottom) {
        int iDp;
        int measuredWidth;
        int i = right - left;
        int i2 = bottom - top;
        boolean z = i < i2;
        if (view == this.cameraPanel) {
            if (z) {
                if (this.cameraPhotoRecyclerView.getVisibility() == 0) {
                    this.cameraPanel.layout(0, bottom - AndroidUtilities.dp(222.0f), i, bottom - AndroidUtilities.dp(96.0f));
                } else {
                    this.cameraPanel.layout(0, bottom - AndroidUtilities.dp(126.0f), i, bottom);
                }
            } else if (this.cameraPhotoRecyclerView.getVisibility() == 0) {
                this.cameraPanel.layout(right - AndroidUtilities.dp(222.0f), 0, right - AndroidUtilities.dp(96.0f), i2);
            } else {
                this.cameraPanel.layout(right - AndroidUtilities.dp(126.0f), 0, right, i2);
            }
            return true;
        }
        if (view == this.zoomControlView) {
            if (z) {
                if (this.cameraPhotoRecyclerView.getVisibility() == 0) {
                    this.zoomControlView.layout(0, bottom - AndroidUtilities.dp(310.0f), i, bottom - AndroidUtilities.dp(260.0f));
                } else {
                    this.zoomControlView.layout(0, bottom - AndroidUtilities.dp(176.0f), i, bottom - AndroidUtilities.dp(126.0f));
                }
            } else if (this.cameraPhotoRecyclerView.getVisibility() == 0) {
                this.zoomControlView.layout(right - AndroidUtilities.dp(310.0f), 0, right - AndroidUtilities.dp(260.0f), i2);
            } else {
                this.zoomControlView.layout(right - AndroidUtilities.dp(176.0f), 0, right - AndroidUtilities.dp(126.0f), i2);
            }
            return true;
        }
        TextView textView = this.counterTextView;
        if (view == textView) {
            if (z) {
                iDp = (i - textView.getMeasuredWidth()) / 2;
                measuredWidth = bottom - AndroidUtilities.dp(167.0f);
                this.counterTextView.setRotation(0.0f);
                if (this.cameraPhotoRecyclerView.getVisibility() == 0) {
                    measuredWidth -= AndroidUtilities.dp(96.0f);
                }
            } else {
                iDp = right - AndroidUtilities.dp(167.0f);
                measuredWidth = (i2 / 2) + (this.counterTextView.getMeasuredWidth() / 2);
                this.counterTextView.setRotation(-90.0f);
                if (this.cameraPhotoRecyclerView.getVisibility() == 0) {
                    iDp -= AndroidUtilities.dp(96.0f);
                }
            }
            TextView textView2 = this.counterTextView;
            textView2.layout(iDp, measuredWidth, textView2.getMeasuredWidth() + iDp, this.counterTextView.getMeasuredHeight() + measuredWidth);
            return true;
        }
        if (view != this.cameraPhotoRecyclerView) {
            return false;
        }
        if (z) {
            int iDp2 = i2 - AndroidUtilities.dp(88.0f);
            view.layout(0, iDp2, view.getMeasuredWidth(), view.getMeasuredHeight() + iDp2);
        } else {
            int iDp3 = (left + i) - AndroidUtilities.dp(88.0f);
            view.layout(iDp3, 0, view.getMeasuredWidth() + iDp3, view.getMeasuredHeight());
        }
        return true;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.albumsDidLoad) {
            if (this.adapter != null) {
                ChatAttachAlert chatAttachAlert = this.parentAlert;
                if ((chatAttachAlert.baseFragment instanceof ChatActivity) || chatAttachAlert.avatarPicker == 2) {
                    this.galleryAlbumEntry = MediaController.allMediaAlbumEntry;
                } else {
                    this.galleryAlbumEntry = MediaController.allPhotosAlbumEntry;
                }
                if (this.selectedAlbumEntry != null) {
                    int i = 0;
                    while (true) {
                        if (i >= MediaController.allMediaAlbums.size()) {
                            break;
                        }
                        MediaController.AlbumEntry albumEntry = MediaController.allMediaAlbums.get(i);
                        int i2 = albumEntry.bucketId;
                        MediaController.AlbumEntry albumEntry2 = this.selectedAlbumEntry;
                        if (i2 == albumEntry2.bucketId && albumEntry.videoOnly == albumEntry2.videoOnly) {
                            this.selectedAlbumEntry = albumEntry;
                            break;
                        }
                        i++;
                    }
                } else {
                    this.selectedAlbumEntry = this.galleryAlbumEntry;
                }
                this.loading = false;
                this.progressView.showTextView();
                this.adapter.notifyDataSetChanged();
                this.cameraAttachAdapter.notifyDataSetChanged();
                if (!selectedPhotosOrder.isEmpty() && this.galleryAlbumEntry != null) {
                    int size = selectedPhotosOrder.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        Integer num = (Integer) selectedPhotosOrder.get(i3);
                        Object obj = selectedPhotos.get(num);
                        MediaController.PhotoEntry photoEntry = this.galleryAlbumEntry.photosByIds.get(num.intValue());
                        if (photoEntry != null) {
                            if (obj instanceof MediaController.PhotoEntry) {
                                photoEntry.copyFrom((MediaController.PhotoEntry) obj);
                            }
                            selectedPhotos.put(num, photoEntry);
                        }
                    }
                }
                updateAlbumsDropDown();
                return;
            }
            return;
        }
        if (id == NotificationCenter.cameraInitied) {
            checkCamera(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class PhotoAttachAdapter extends RecyclerListView.SelectionAdapter {
        private int itemsCount;
        private Context mContext;
        private boolean needCamera;
        private ArrayList<RecyclerListView.Holder> viewsCache = new ArrayList<>(8);

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        public PhotoAttachAdapter(Context context, boolean camera) {
            this.mContext = context;
            this.needCamera = camera;
        }

        public void createCache() {
            for (int i = 0; i < 8; i++) {
                this.viewsCache.add(createHolder());
            }
        }

        public RecyclerListView.Holder createHolder() {
            PhotoAttachPhotoCell photoAttachPhotoCell = new PhotoAttachPhotoCell(this.mContext, ChatAttachAlertPhotoLayout.this.resourcesProvider);
            if (Build.VERSION.SDK_INT >= 21 && this == ChatAttachAlertPhotoLayout.this.adapter) {
                photoAttachPhotoCell.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.PhotoAttachAdapter.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        int iIntValue = ((Integer) ((PhotoAttachPhotoCell) view).getTag()).intValue();
                        if (PhotoAttachAdapter.this.needCamera && ChatAttachAlertPhotoLayout.this.selectedAlbumEntry == ChatAttachAlertPhotoLayout.this.galleryAlbumEntry) {
                            iIntValue++;
                        }
                        if (iIntValue != 0) {
                            if (iIntValue == ChatAttachAlertPhotoLayout.this.itemsPerRow - 1) {
                                int iDp = AndroidUtilities.dp(ChatAttachAlertPhotoLayout.this.parentAlert.cornerRadius * 8.0f);
                                outline.setRoundRect(-iDp, 0, view.getMeasuredWidth(), view.getMeasuredHeight() + iDp, iDp);
                                return;
                            } else {
                                outline.setRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                                return;
                            }
                        }
                        int iDp2 = AndroidUtilities.dp(ChatAttachAlertPhotoLayout.this.parentAlert.cornerRadius * 8.0f);
                        outline.setRoundRect(0, 0, view.getMeasuredWidth() + iDp2, view.getMeasuredHeight() + iDp2, iDp2);
                    }
                });
                photoAttachPhotoCell.setClipToOutline(true);
            }
            photoAttachPhotoCell.setDelegate(new PhotoAttachPhotoCell.PhotoAttachPhotoCellDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertPhotoLayout$PhotoAttachAdapter$INJ7mTQGdE8cepCL3l-B8mi2MfI
                @Override // ir.eitaa.ui.Cells.PhotoAttachPhotoCell.PhotoAttachPhotoCellDelegate
                public final void onCheckClick(PhotoAttachPhotoCell photoAttachPhotoCell2) {
                    this.f$0.lambda$createHolder$0$ChatAttachAlertPhotoLayout$PhotoAttachAdapter(photoAttachPhotoCell2);
                }
            });
            return new RecyclerListView.Holder(photoAttachPhotoCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$createHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$createHolder$0$ChatAttachAlertPhotoLayout$PhotoAttachAdapter(PhotoAttachPhotoCell photoAttachPhotoCell) {
            TLRPC$Chat currentChat;
            if (ChatAttachAlertPhotoLayout.this.mediaEnabled && ChatAttachAlertPhotoLayout.this.parentAlert.avatarPicker == 0) {
                int iIntValue = ((Integer) photoAttachPhotoCell.getTag()).intValue();
                MediaController.PhotoEntry photoEntry = photoAttachPhotoCell.getPhotoEntry();
                boolean z = !ChatAttachAlertPhotoLayout.selectedPhotos.containsKey(Integer.valueOf(photoEntry.imageId));
                if (z && ChatAttachAlertPhotoLayout.this.parentAlert.maxSelectedPhotos >= 0) {
                    int size = ChatAttachAlertPhotoLayout.selectedPhotos.size();
                    ChatAttachAlert chatAttachAlert = ChatAttachAlertPhotoLayout.this.parentAlert;
                    if (size >= chatAttachAlert.maxSelectedPhotos) {
                        if (chatAttachAlert.allowOrder) {
                            BaseFragment baseFragment = chatAttachAlert.baseFragment;
                            if (!(baseFragment instanceof ChatActivity) || (currentChat = ((ChatActivity) baseFragment).getCurrentChat()) == null || ChatObject.hasAdminRights(currentChat) || !currentChat.slowmode_enabled || ChatAttachAlertPhotoLayout.this.alertOnlyOnce == 2) {
                                return;
                            }
                            AlertsCreator.createSimpleAlert(ChatAttachAlertPhotoLayout.this.getContext(), LocaleController.getString("Slowmode", R.string.Slowmode), LocaleController.getString("SlowmodeSelectSendError", R.string.SlowmodeSelectSendError), ChatAttachAlertPhotoLayout.this.resourcesProvider).show();
                            if (ChatAttachAlertPhotoLayout.this.alertOnlyOnce == 1) {
                                ChatAttachAlertPhotoLayout.this.alertOnlyOnce = 2;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                int size2 = z ? ChatAttachAlertPhotoLayout.selectedPhotosOrder.size() : -1;
                ChatAttachAlert chatAttachAlert2 = ChatAttachAlertPhotoLayout.this.parentAlert;
                if ((chatAttachAlert2.baseFragment instanceof ChatActivity) && chatAttachAlert2.allowOrder) {
                    photoAttachPhotoCell.setChecked(size2, z, true);
                } else {
                    photoAttachPhotoCell.setChecked(-1, z, true);
                }
                ChatAttachAlertPhotoLayout.this.addToSelectedPhotos(photoEntry, iIntValue);
                if (this == ChatAttachAlertPhotoLayout.this.cameraAttachAdapter) {
                    if (ChatAttachAlertPhotoLayout.this.adapter.needCamera && ChatAttachAlertPhotoLayout.this.selectedAlbumEntry == ChatAttachAlertPhotoLayout.this.galleryAlbumEntry) {
                        iIntValue++;
                    }
                    ChatAttachAlertPhotoLayout.this.adapter.notifyItemChanged(iIntValue);
                } else {
                    ChatAttachAlertPhotoLayout.this.cameraAttachAdapter.notifyItemChanged(iIntValue);
                }
                ChatAttachAlertPhotoLayout.this.parentAlert.updateCountButton(z ? 1 : 2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MediaController.PhotoEntry getPhoto(int position) {
            if (this.needCamera && ChatAttachAlertPhotoLayout.this.selectedAlbumEntry == ChatAttachAlertPhotoLayout.this.galleryAlbumEntry) {
                position--;
            }
            return ChatAttachAlertPhotoLayout.this.getPhotoEntryAtPosition(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 3) {
                        return;
                    }
                    PhotoAttachPermissionCell photoAttachPermissionCell = (PhotoAttachPermissionCell) holder.itemView;
                    photoAttachPermissionCell.setItemSize(ChatAttachAlertPhotoLayout.this.itemSize);
                    photoAttachPermissionCell.setType((this.needCamera && ChatAttachAlertPhotoLayout.this.noCameraPermissions && position == 0) ? 0 : 1);
                    return;
                }
                PhotoAttachCameraCell photoAttachCameraCell = (PhotoAttachCameraCell) holder.itemView;
                if (ChatAttachAlertPhotoLayout.this.cameraView != null && ChatAttachAlertPhotoLayout.this.cameraView.isInitied() && !ChatAttachAlertPhotoLayout.this.isHidden) {
                    photoAttachCameraCell.setVisibility(4);
                } else {
                    photoAttachCameraCell.setVisibility(0);
                }
                photoAttachCameraCell.setItemSize(ChatAttachAlertPhotoLayout.this.itemSize);
                return;
            }
            if (this.needCamera && ChatAttachAlertPhotoLayout.this.selectedAlbumEntry == ChatAttachAlertPhotoLayout.this.galleryAlbumEntry) {
                position--;
            }
            PhotoAttachPhotoCell photoAttachPhotoCell = (PhotoAttachPhotoCell) holder.itemView;
            if (this == ChatAttachAlertPhotoLayout.this.adapter) {
                photoAttachPhotoCell.setItemSize(ChatAttachAlertPhotoLayout.this.itemSize);
            } else {
                photoAttachPhotoCell.setIsVertical(ChatAttachAlertPhotoLayout.this.cameraPhotoLayoutManager.getOrientation() == 1);
            }
            if (ChatAttachAlertPhotoLayout.this.parentAlert.avatarPicker != 0) {
                photoAttachPhotoCell.getCheckBox().setVisibility(8);
            }
            MediaController.PhotoEntry photoEntryAtPosition = ChatAttachAlertPhotoLayout.this.getPhotoEntryAtPosition(position);
            photoAttachPhotoCell.setPhotoEntry(photoEntryAtPosition, this.needCamera && ChatAttachAlertPhotoLayout.this.selectedAlbumEntry == ChatAttachAlertPhotoLayout.this.galleryAlbumEntry, position == getItemCount() - 1);
            ChatAttachAlert chatAttachAlert = ChatAttachAlertPhotoLayout.this.parentAlert;
            if (!(chatAttachAlert.baseFragment instanceof ChatActivity) || !chatAttachAlert.allowOrder) {
                photoAttachPhotoCell.setChecked(-1, ChatAttachAlertPhotoLayout.selectedPhotos.containsKey(Integer.valueOf(photoEntryAtPosition.imageId)), false);
            } else {
                photoAttachPhotoCell.setChecked(ChatAttachAlertPhotoLayout.selectedPhotosOrder.indexOf(Integer.valueOf(photoEntryAtPosition.imageId)), ChatAttachAlertPhotoLayout.selectedPhotos.containsKey(Integer.valueOf(photoEntryAtPosition.imageId)), false);
            }
            photoAttachPhotoCell.getImageView().setTag(Integer.valueOf(position));
            photoAttachPhotoCell.setTag(Integer.valueOf(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == 0) {
                if (!this.viewsCache.isEmpty()) {
                    RecyclerListView.Holder holder = this.viewsCache.get(0);
                    this.viewsCache.remove(0);
                    return holder;
                }
                return createHolder();
            }
            if (viewType != 1) {
                if (viewType == 2) {
                    return new RecyclerListView.Holder(new View(this.mContext) { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.PhotoAttachAdapter.3
                        @Override // android.view.View
                        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(ChatAttachAlertPhotoLayout.this.gridExtraSpace, 1073741824));
                        }
                    });
                }
                return new RecyclerListView.Holder(new PhotoAttachPermissionCell(this.mContext, ChatAttachAlertPhotoLayout.this.resourcesProvider));
            }
            PhotoAttachCameraCell photoAttachCameraCell = new PhotoAttachCameraCell(this.mContext, ChatAttachAlertPhotoLayout.this.resourcesProvider);
            if (Build.VERSION.SDK_INT >= 21) {
                photoAttachCameraCell.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.ChatAttachAlertPhotoLayout.PhotoAttachAdapter.2
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        int iDp = AndroidUtilities.dp(ChatAttachAlertPhotoLayout.this.parentAlert.cornerRadius * 8.0f);
                        outline.setRoundRect(0, 0, view.getMeasuredWidth() + iDp, view.getMeasuredHeight() + iDp, iDp);
                    }
                });
                photoAttachCameraCell.setClipToOutline(true);
            }
            return new RecyclerListView.Holder(photoAttachCameraCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
            if (view instanceof PhotoAttachCameraCell) {
                ((PhotoAttachCameraCell) view).updateBitmap();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (!ChatAttachAlertPhotoLayout.this.mediaEnabled) {
                return 1;
            }
            int i = (this.needCamera && ChatAttachAlertPhotoLayout.this.selectedAlbumEntry == ChatAttachAlertPhotoLayout.this.galleryAlbumEntry) ? 1 : 0;
            if (ChatAttachAlertPhotoLayout.this.noGalleryPermissions && this == ChatAttachAlertPhotoLayout.this.adapter) {
                i++;
            }
            int size = i + ChatAttachAlertPhotoLayout.cameraPhotos.size();
            if (ChatAttachAlertPhotoLayout.this.selectedAlbumEntry != null) {
                size += ChatAttachAlertPhotoLayout.this.selectedAlbumEntry.photos.size();
            }
            if (this == ChatAttachAlertPhotoLayout.this.adapter) {
                size++;
            }
            this.itemsCount = size;
            return size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (!ChatAttachAlertPhotoLayout.this.mediaEnabled) {
                return 2;
            }
            if (this.needCamera && position == 0 && ChatAttachAlertPhotoLayout.this.selectedAlbumEntry == ChatAttachAlertPhotoLayout.this.galleryAlbumEntry) {
                return ChatAttachAlertPhotoLayout.this.noCameraPermissions ? 3 : 1;
            }
            if (this == ChatAttachAlertPhotoLayout.this.adapter && position == this.itemsCount - 1) {
                return 2;
            }
            return ChatAttachAlertPhotoLayout.this.noGalleryPermissions ? 3 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            if (this == ChatAttachAlertPhotoLayout.this.adapter) {
                ChatAttachAlertPhotoLayout.this.progressView.setVisibility((!(getItemCount() == 1 && ChatAttachAlertPhotoLayout.this.selectedAlbumEntry == null) && ChatAttachAlertPhotoLayout.this.mediaEnabled) ? 4 : 0);
            }
        }
    }
}
