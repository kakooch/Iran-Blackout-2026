package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationBadge;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolveUsername;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolvedPeer;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeImageSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_getInlineBotResults;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WebDocument;
import ir.eitaa.tgnet.TLRPC$messages_BotResults;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.DividerCell;
import ir.eitaa.ui.Cells.PhotoAttachPhotoCell;
import ir.eitaa.ui.Cells.SharedDocumentCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.EditTextCaption;
import ir.eitaa.ui.Components.EditTextEmoji;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.RecyclerViewItemRangeSelector;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import ir.eitaa.ui.PhotoViewer;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class PhotoPickerActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int alertOnlyOnce;
    private boolean allowCaption;
    private boolean allowIndices;
    private AnimatorSet animatorSet;
    private CharSequence caption;
    private ChatActivity chatActivity;
    protected EditTextEmoji commentTextView;
    private PhotoPickerActivityDelegate delegate;
    private final String dialogBackgroundKey;
    private EmptyTextProgressView emptyView;
    private final boolean forceDarckTheme;
    protected FrameLayout frameLayout2;
    private int imageReqId;
    private String initialSearchString;
    private boolean isDocumentsPicker;
    private ActionBarMenuSubItem[] itemCells;
    private RecyclerViewItemRangeSelector itemRangeSelector;
    private String lastSearchImageString;
    private String lastSearchString;
    private int lastSearchToken;
    private GridLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private boolean listSort;
    private RecyclerListView listView;
    private int maxSelectedPhotos;
    private String nextImagesSearchOffset;
    private PhotoPickerActivitySearchDelegate searchDelegate;
    private ActionBarMenuItem searchItem;
    private boolean searching;
    private boolean searchingUser;
    private int selectPhotoType;
    private MediaController.AlbumEntry selectedAlbum;
    protected View selectedCountView;
    private HashMap<Object, Object> selectedPhotos;
    private ArrayList<Object> selectedPhotosOrder;
    private final String selectorKey;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout sendPopupLayout;
    private ActionBarPopupWindow sendPopupWindow;
    private boolean sendPressed;
    protected View shadow;
    private boolean shouldSelect;
    private ActionBarMenuSubItem showAsListItem;
    private SizeNotifierFrameLayout sizeNotifierFrameLayout;
    private final String textKey;
    private int type;
    private ImageView writeButton;
    protected FrameLayout writeButtonContainer;
    private Drawable writeButtonDrawable;
    private ArrayList<MediaController.SearchImage> searchResult = new ArrayList<>();
    private HashMap<String, MediaController.SearchImage> searchResultKeys = new HashMap<>();
    private HashMap<String, MediaController.SearchImage> searchResultUrls = new HashMap<>();
    private ArrayList<String> recentSearches = new ArrayList<>();
    private boolean imageSearchEndReached = true;
    private boolean allowOrder = true;
    private int itemSize = 100;
    private int itemsPerRow = 3;
    private TextPaint textPaint = new TextPaint(1);
    private RectF rect = new RectF();
    private Paint paint = new Paint(1);
    private boolean needsBottomLayout = true;
    private PhotoViewer.PhotoViewerProvider provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.PhotoPickerActivity.1
        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean scaleToFill() {
            return false;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
            PhotoAttachPhotoCell cellForIndex = PhotoPickerActivity.this.getCellForIndex(index);
            if (cellForIndex == null) {
                return null;
            }
            BackupImageView imageView = cellForIndex.getImageView();
            int[] iArr = new int[2];
            imageView.getLocationInWindow(iArr);
            PhotoViewer.PlaceProviderObject placeProviderObject = new PhotoViewer.PlaceProviderObject();
            placeProviderObject.viewX = iArr[0];
            placeProviderObject.viewY = iArr[1] - (Build.VERSION.SDK_INT >= 21 ? 0 : AndroidUtilities.statusBarHeight);
            placeProviderObject.parentView = PhotoPickerActivity.this.listView;
            ImageReceiver imageReceiver = imageView.getImageReceiver();
            placeProviderObject.imageReceiver = imageReceiver;
            placeProviderObject.thumb = imageReceiver.getBitmapSafe();
            placeProviderObject.scale = cellForIndex.getScale();
            cellForIndex.showCheck(false);
            return placeProviderObject;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void updatePhotoAtIndex(int index) {
            PhotoAttachPhotoCell cellForIndex = PhotoPickerActivity.this.getCellForIndex(index);
            if (cellForIndex != null) {
                if (PhotoPickerActivity.this.selectedAlbum == null) {
                    cellForIndex.setPhotoEntry((MediaController.SearchImage) PhotoPickerActivity.this.searchResult.get(index), true, false);
                    return;
                }
                BackupImageView imageView = cellForIndex.getImageView();
                imageView.setOrientation(0, true);
                MediaController.PhotoEntry photoEntry = PhotoPickerActivity.this.selectedAlbum.photos.get(index);
                String str = photoEntry.thumbPath;
                if (str != null) {
                    imageView.setImage(str, null, Theme.chat_attachEmptyDrawable);
                    return;
                }
                if (photoEntry.path != null) {
                    imageView.setOrientation(photoEntry.orientation, true);
                    if (photoEntry.isVideo) {
                        imageView.setImage("vthumb://" + photoEntry.imageId + ":" + photoEntry.path, null, Theme.chat_attachEmptyDrawable);
                        return;
                    }
                    imageView.setImage("thumb://" + photoEntry.imageId + ":" + photoEntry.path, null, Theme.chat_attachEmptyDrawable);
                    return;
                }
                imageView.setImageDrawable(Theme.chat_attachEmptyDrawable);
            }
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean allowCaption() {
            return PhotoPickerActivity.this.allowCaption;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public ImageReceiver.BitmapHolder getThumbForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index) {
            PhotoAttachPhotoCell cellForIndex = PhotoPickerActivity.this.getCellForIndex(index);
            if (cellForIndex != null) {
                return cellForIndex.getImageView().getImageReceiver().getBitmapSafe();
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void willSwitchFromPhoto(ir.eitaa.messenger.MessageObject r4, ir.eitaa.tgnet.TLRPC$FileLocation r5, int r6) {
            /*
                r3 = this;
                ir.eitaa.ui.PhotoPickerActivity r4 = ir.eitaa.ui.PhotoPickerActivity.this
                ir.eitaa.ui.Components.RecyclerListView r4 = ir.eitaa.ui.PhotoPickerActivity.access$100(r4)
                int r4 = r4.getChildCount()
                r5 = 0
            Lb:
                if (r5 >= r4) goto L5d
                ir.eitaa.ui.PhotoPickerActivity r0 = ir.eitaa.ui.PhotoPickerActivity.this
                ir.eitaa.ui.Components.RecyclerListView r0 = ir.eitaa.ui.PhotoPickerActivity.access$100(r0)
                android.view.View r0 = r0.getChildAt(r5)
                java.lang.Object r1 = r0.getTag()
                if (r1 != 0) goto L1e
                goto L5a
            L1e:
                r1 = r0
                ir.eitaa.ui.Cells.PhotoAttachPhotoCell r1 = (ir.eitaa.ui.Cells.PhotoAttachPhotoCell) r1
                java.lang.Object r0 = r0.getTag()
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                ir.eitaa.ui.PhotoPickerActivity r2 = ir.eitaa.ui.PhotoPickerActivity.this
                ir.eitaa.messenger.MediaController$AlbumEntry r2 = ir.eitaa.ui.PhotoPickerActivity.access$200(r2)
                if (r2 == 0) goto L44
                if (r0 < 0) goto L5a
                ir.eitaa.ui.PhotoPickerActivity r2 = ir.eitaa.ui.PhotoPickerActivity.this
                ir.eitaa.messenger.MediaController$AlbumEntry r2 = ir.eitaa.ui.PhotoPickerActivity.access$200(r2)
                java.util.ArrayList<ir.eitaa.messenger.MediaController$PhotoEntry> r2 = r2.photos
                int r2 = r2.size()
                if (r0 < r2) goto L53
                goto L5a
            L44:
                if (r0 < 0) goto L5a
                ir.eitaa.ui.PhotoPickerActivity r2 = ir.eitaa.ui.PhotoPickerActivity.this
                java.util.ArrayList r2 = ir.eitaa.ui.PhotoPickerActivity.access$300(r2)
                int r2 = r2.size()
                if (r0 < r2) goto L53
                goto L5a
            L53:
                if (r0 != r6) goto L5a
                r4 = 1
                r1.showCheck(r4)
                goto L5d
            L5a:
                int r5 = r5 + 1
                goto Lb
            L5d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoPickerActivity.AnonymousClass1.willSwitchFromPhoto(ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$FileLocation, int):void");
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void willHidePhotoViewer() {
            int childCount = PhotoPickerActivity.this.listView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = PhotoPickerActivity.this.listView.getChildAt(i);
                if (childAt instanceof PhotoAttachPhotoCell) {
                    ((PhotoAttachPhotoCell) childAt).showCheck(true);
                }
            }
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean isPhotoChecked(int index) {
            return PhotoPickerActivity.this.selectedAlbum != null ? index >= 0 && index < PhotoPickerActivity.this.selectedAlbum.photos.size() && PhotoPickerActivity.this.selectedPhotos.containsKey(Integer.valueOf(PhotoPickerActivity.this.selectedAlbum.photos.get(index).imageId)) : index >= 0 && index < PhotoPickerActivity.this.searchResult.size() && PhotoPickerActivity.this.selectedPhotos.containsKey(((MediaController.SearchImage) PhotoPickerActivity.this.searchResult.get(index)).id);
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public int setPhotoUnchecked(Object object) {
            Object objValueOf;
            if (object instanceof MediaController.PhotoEntry) {
                objValueOf = Integer.valueOf(((MediaController.PhotoEntry) object).imageId);
            } else {
                objValueOf = object instanceof MediaController.SearchImage ? ((MediaController.SearchImage) object).id : null;
            }
            if (objValueOf == null || !PhotoPickerActivity.this.selectedPhotos.containsKey(objValueOf)) {
                return -1;
            }
            PhotoPickerActivity.this.selectedPhotos.remove(objValueOf);
            int iIndexOf = PhotoPickerActivity.this.selectedPhotosOrder.indexOf(objValueOf);
            if (iIndexOf >= 0) {
                PhotoPickerActivity.this.selectedPhotosOrder.remove(iIndexOf);
            }
            if (PhotoPickerActivity.this.allowIndices) {
                PhotoPickerActivity.this.updateCheckedPhotoIndices();
            }
            return iIndexOf;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public int setPhotoChecked(int index, VideoEditedInfo videoEditedInfo) {
            int iAddToSelectedPhotos;
            boolean z;
            if (PhotoPickerActivity.this.selectedAlbum != null) {
                if (index < 0 || index >= PhotoPickerActivity.this.selectedAlbum.photos.size()) {
                    return -1;
                }
                MediaController.PhotoEntry photoEntry = PhotoPickerActivity.this.selectedAlbum.photos.get(index);
                iAddToSelectedPhotos = PhotoPickerActivity.this.addToSelectedPhotos(photoEntry, -1);
                if (iAddToSelectedPhotos == -1) {
                    photoEntry.editedInfo = videoEditedInfo;
                    iAddToSelectedPhotos = PhotoPickerActivity.this.selectedPhotosOrder.indexOf(Integer.valueOf(photoEntry.imageId));
                    z = true;
                } else {
                    photoEntry.editedInfo = null;
                    z = false;
                }
            } else {
                if (index < 0 || index >= PhotoPickerActivity.this.searchResult.size()) {
                    return -1;
                }
                MediaController.SearchImage searchImage = (MediaController.SearchImage) PhotoPickerActivity.this.searchResult.get(index);
                iAddToSelectedPhotos = PhotoPickerActivity.this.addToSelectedPhotos(searchImage, -1);
                if (iAddToSelectedPhotos == -1) {
                    searchImage.editedInfo = videoEditedInfo;
                    iAddToSelectedPhotos = PhotoPickerActivity.this.selectedPhotosOrder.indexOf(searchImage.id);
                    z = true;
                } else {
                    searchImage.editedInfo = null;
                    z = false;
                }
            }
            int childCount = PhotoPickerActivity.this.listView.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = PhotoPickerActivity.this.listView.getChildAt(i);
                if (((Integer) childAt.getTag()).intValue() == index) {
                    ((PhotoAttachPhotoCell) childAt).setChecked(PhotoPickerActivity.this.allowIndices ? iAddToSelectedPhotos : -1, z, false);
                } else {
                    i++;
                }
            }
            PhotoPickerActivity.this.updatePhotosButton(z ? 1 : 2);
            PhotoPickerActivity.this.delegate.selectedPhotosChanged();
            return iAddToSelectedPhotos;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean cancelButtonPressed() {
            PhotoPickerActivity.this.delegate.actionButtonPressed(true, true, 0);
            PhotoPickerActivity.this.finishFragment();
            return true;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public int getSelectedCount() {
            return PhotoPickerActivity.this.selectedPhotos.size();
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void sendButtonPressed(int index, VideoEditedInfo videoEditedInfo, boolean notify, int scheduleDate, boolean forceDocument) {
            if (PhotoPickerActivity.this.selectedPhotos.isEmpty()) {
                if (PhotoPickerActivity.this.selectedAlbum != null) {
                    if (index < 0 || index >= PhotoPickerActivity.this.selectedAlbum.photos.size()) {
                        return;
                    }
                    MediaController.PhotoEntry photoEntry = PhotoPickerActivity.this.selectedAlbum.photos.get(index);
                    photoEntry.editedInfo = videoEditedInfo;
                    PhotoPickerActivity.this.addToSelectedPhotos(photoEntry, -1);
                } else {
                    if (index < 0 || index >= PhotoPickerActivity.this.searchResult.size()) {
                        return;
                    }
                    MediaController.SearchImage searchImage = (MediaController.SearchImage) PhotoPickerActivity.this.searchResult.get(index);
                    searchImage.editedInfo = videoEditedInfo;
                    PhotoPickerActivity.this.addToSelectedPhotos(searchImage, -1);
                }
            }
            PhotoPickerActivity.this.sendSelectedPhotos(notify, scheduleDate);
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public ArrayList<Object> getSelectedPhotosOrder() {
            return PhotoPickerActivity.this.selectedPhotosOrder;
        }

        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public HashMap<Object, Object> getSelectedPhotos() {
            return PhotoPickerActivity.this.selectedPhotos;
        }
    };

    public interface PhotoPickerActivityDelegate {

        /* renamed from: ir.eitaa.ui.PhotoPickerActivity$PhotoPickerActivityDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onOpenInPressed(PhotoPickerActivityDelegate photoPickerActivityDelegate) {
            }
        }

        void actionButtonPressed(boolean canceled, boolean notify, int scheduleDate);

        void onCaptionChanged(CharSequence caption);

        void onOpenInPressed();

        void selectedPhotosChanged();
    }

    public interface PhotoPickerActivitySearchDelegate {
        void shouldClearRecentSearch();

        void shouldSearchText(String text);
    }

    static /* synthetic */ boolean lambda$createView$3(View view, MotionEvent motionEvent) {
        return true;
    }

    public PhotoPickerActivity(int type, MediaController.AlbumEntry selectedAlbum, HashMap<Object, Object> selectedPhotos, ArrayList<Object> selectedPhotosOrder, int selectPhotoType, boolean allowCaption, ChatActivity chatActivity, boolean forceDarkTheme) {
        this.selectedAlbum = selectedAlbum;
        this.selectedPhotos = selectedPhotos;
        this.selectedPhotosOrder = selectedPhotosOrder;
        this.type = type;
        this.selectPhotoType = selectPhotoType;
        this.chatActivity = chatActivity;
        this.allowCaption = allowCaption;
        this.forceDarckTheme = forceDarkTheme;
        if (selectedAlbum == null) {
            loadRecentSearch();
        }
        if (forceDarkTheme) {
            this.dialogBackgroundKey = "voipgroup_dialogBackground";
            this.textKey = "voipgroup_actionBarItems";
            this.selectorKey = "voipgroup_actionBarItemsSelector";
        } else {
            this.dialogBackgroundKey = "dialogBackground";
            this.textKey = "dialogTextBlack";
            this.selectorKey = "dialogButtonSelector";
        }
    }

    public void setDocumentsPicker(boolean value) {
        this.isDocumentsPicker = value;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.closeChats);
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.closeChats);
        if (this.imageReqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.imageReqId, true);
            this.imageReqId = 0;
        }
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onDestroy();
        }
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        int i;
        this.listSort = false;
        this.actionBar.setBackgroundColor(Theme.getColor(this.dialogBackgroundKey));
        this.actionBar.setTitleColor(Theme.getColor(this.textKey));
        this.actionBar.setItemsColor(Theme.getColor(this.textKey), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(this.selectorKey), false);
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        MediaController.AlbumEntry albumEntry = this.selectedAlbum;
        if (albumEntry != null) {
            this.actionBar.setTitle(albumEntry.bucketName);
        } else {
            int i2 = this.type;
            if (i2 == 0) {
                this.actionBar.setTitle(LocaleController.getString("SearchImagesTitle", R.string.SearchImagesTitle));
            } else if (i2 == 1) {
                this.actionBar.setTitle(LocaleController.getString("SearchGifsTitle", R.string.SearchGifsTitle));
            }
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.PhotoPickerActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    PhotoPickerActivity.this.finishFragment();
                    return;
                }
                if (id != 1) {
                    if (id == 2) {
                        if (PhotoPickerActivity.this.delegate != null) {
                            PhotoPickerActivity.this.delegate.onOpenInPressed();
                        }
                        PhotoPickerActivity.this.finishFragment();
                        return;
                    }
                    return;
                }
                PhotoPickerActivity photoPickerActivity = PhotoPickerActivity.this;
                photoPickerActivity.listSort = true ^ photoPickerActivity.listSort;
                if (PhotoPickerActivity.this.listSort) {
                    PhotoPickerActivity.this.listView.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
                } else {
                    PhotoPickerActivity.this.listView.setPadding(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(50.0f));
                }
                PhotoPickerActivity.this.listView.stopScroll();
                PhotoPickerActivity.this.layoutManager.scrollToPositionWithOffset(0, 0);
                PhotoPickerActivity.this.listAdapter.notifyDataSetChanged();
            }
        });
        if (this.isDocumentsPicker) {
            ActionBarMenuItem actionBarMenuItemAddItem = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_other);
            actionBarMenuItemAddItem.setSubMenuDelegate(new ActionBarMenuItem.ActionBarSubMenuItemDelegate() { // from class: ir.eitaa.ui.PhotoPickerActivity.3
                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarSubMenuItemDelegate
                public void onHideSubMenu() {
                }

                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarSubMenuItemDelegate
                public void onShowSubMenu() {
                    int i3;
                    String str;
                    ActionBarMenuSubItem actionBarMenuSubItem = PhotoPickerActivity.this.showAsListItem;
                    if (PhotoPickerActivity.this.listSort) {
                        i3 = R.string.ShowAsGrid;
                        str = "ShowAsGrid";
                    } else {
                        i3 = R.string.ShowAsList;
                        str = "ShowAsList";
                    }
                    actionBarMenuSubItem.setText(LocaleController.getString(str, i3));
                    PhotoPickerActivity.this.showAsListItem.setIcon(PhotoPickerActivity.this.listSort ? R.drawable.msg_media : R.drawable.msg_list);
                }
            });
            this.showAsListItem = actionBarMenuItemAddItem.addSubItem(1, R.drawable.msg_list, LocaleController.getString("ShowAsList", R.string.ShowAsList));
            actionBarMenuItemAddItem.addSubItem(2, R.drawable.msg_openin, LocaleController.getString("OpenInExternalApp", R.string.OpenInExternalApp));
        }
        if (this.selectedAlbum == null) {
            ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.PhotoPickerActivity.4
                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchExpand() {
                }

                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public boolean canCollapseSearch() {
                    PhotoPickerActivity.this.finishFragment();
                    return false;
                }

                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onTextChanged(EditText editText) {
                    if (editText.getText().length() == 0) {
                        PhotoPickerActivity.this.searchResult.clear();
                        PhotoPickerActivity.this.searchResultKeys.clear();
                        PhotoPickerActivity.this.lastSearchString = null;
                        PhotoPickerActivity.this.imageSearchEndReached = true;
                        PhotoPickerActivity.this.searching = false;
                        if (PhotoPickerActivity.this.imageReqId != 0) {
                            ConnectionsManager.getInstance(((BaseFragment) PhotoPickerActivity.this).currentAccount).cancelRequest(PhotoPickerActivity.this.imageReqId, true);
                            PhotoPickerActivity.this.imageReqId = 0;
                        }
                        PhotoPickerActivity.this.emptyView.setText(LocaleController.getString("NoRecentSearches", R.string.NoRecentSearches));
                        PhotoPickerActivity.this.updateSearchInterface();
                    }
                }

                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchPressed(EditText editText) {
                    PhotoPickerActivity.this.processSearch(editText);
                }
            });
            this.searchItem = actionBarMenuItemSearchListener;
            EditTextBoldCursor searchField = actionBarMenuItemSearchListener.getSearchField();
            searchField.setTextColor(Theme.getColor(this.textKey));
            searchField.setCursorColor(Theme.getColor(this.textKey));
            searchField.setHintTextColor(Theme.getColor("chat_messagePanelHint"));
        }
        if (this.selectedAlbum == null) {
            int i3 = this.type;
            if (i3 == 0) {
                this.searchItem.setSearchFieldHint(LocaleController.getString("SearchImagesTitle", R.string.SearchImagesTitle));
            } else if (i3 == 1) {
                this.searchItem.setSearchFieldHint(LocaleController.getString("SearchGifsTitle", R.string.SearchGifsTitle));
            }
        }
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(context);
        this.sizeNotifierFrameLayout = anonymousClass5;
        anonymousClass5.setBackgroundColor(Theme.getColor(this.dialogBackgroundKey));
        this.fragmentView = this.sizeNotifierFrameLayout;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setPadding(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(50.0f));
        this.listView.setClipToPadding(false);
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        RecyclerListView recyclerListView2 = this.listView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4) { // from class: ir.eitaa.ui.PhotoPickerActivity.6
            @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        this.layoutManager = gridLayoutManager;
        recyclerListView2.setLayoutManager(gridLayoutManager);
        this.layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.PhotoPickerActivity.7
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                if (PhotoPickerActivity.this.listAdapter.getItemViewType(position) == 1 || PhotoPickerActivity.this.listSort || (PhotoPickerActivity.this.selectedAlbum == null && TextUtils.isEmpty(PhotoPickerActivity.this.lastSearchString))) {
                    return PhotoPickerActivity.this.layoutManager.getSpanCount();
                }
                return PhotoPickerActivity.this.itemSize + (position % PhotoPickerActivity.this.itemsPerRow != PhotoPickerActivity.this.itemsPerRow - 1 ? AndroidUtilities.dp(5.0f) : 0);
            }
        });
        this.sizeNotifierFrameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listAdapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        this.listView.setGlowColor(Theme.getColor(this.dialogBackgroundKey));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$Dm7ebQqWj8WGH6-4V-xbX_sFWBE
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i4) throws InterruptedException, Resources.NotFoundException {
                this.f$0.lambda$createView$1$PhotoPickerActivity(view, i4);
            }
        });
        if (this.maxSelectedPhotos != 1) {
            this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$iXYXtkG1OM_oJT1IpXYdtpV1JPU
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
                public final boolean onItemClick(View view, int i4) {
                    return this.f$0.lambda$createView$2$PhotoPickerActivity(view, i4);
                }
            });
        }
        RecyclerViewItemRangeSelector recyclerViewItemRangeSelector = new RecyclerViewItemRangeSelector(new RecyclerViewItemRangeSelector.RecyclerViewItemRangeSelectorDelegate() { // from class: ir.eitaa.ui.PhotoPickerActivity.8
            @Override // ir.eitaa.ui.Components.RecyclerViewItemRangeSelector.RecyclerViewItemRangeSelectorDelegate
            public void setSelected(View view, int index, boolean selected) {
                if (selected == PhotoPickerActivity.this.shouldSelect && (view instanceof PhotoAttachPhotoCell)) {
                    ((PhotoAttachPhotoCell) view).callDelegate();
                }
            }

            @Override // ir.eitaa.ui.Components.RecyclerViewItemRangeSelector.RecyclerViewItemRangeSelectorDelegate
            public boolean isSelected(int index) {
                Object objValueOf;
                if (PhotoPickerActivity.this.selectedAlbum != null) {
                    objValueOf = Integer.valueOf(PhotoPickerActivity.this.selectedAlbum.photos.get(index).imageId);
                } else {
                    objValueOf = ((MediaController.SearchImage) PhotoPickerActivity.this.searchResult.get(index)).id;
                }
                return PhotoPickerActivity.this.selectedPhotos.containsKey(objValueOf);
            }

            @Override // ir.eitaa.ui.Components.RecyclerViewItemRangeSelector.RecyclerViewItemRangeSelectorDelegate
            public boolean isIndexSelectable(int index) {
                return PhotoPickerActivity.this.listAdapter.getItemViewType(index) == 0;
            }

            @Override // ir.eitaa.ui.Components.RecyclerViewItemRangeSelector.RecyclerViewItemRangeSelectorDelegate
            public void onStartStopSelection(boolean z) {
                PhotoPickerActivity.this.alertOnlyOnce = z ? 1 : 0;
                if (z) {
                    ((BaseFragment) PhotoPickerActivity.this).parentLayout.requestDisallowInterceptTouchEvent(true);
                }
                PhotoPickerActivity.this.listView.hideSelector(true);
            }
        });
        this.itemRangeSelector = recyclerViewItemRangeSelector;
        if (this.maxSelectedPhotos != 1) {
            this.listView.addOnItemTouchListener(recyclerViewItemRangeSelector);
        }
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.setTextColor(-7104099);
        this.emptyView.setProgressBarColor(-11371101);
        if (this.selectedAlbum != null) {
            this.emptyView.setShowAtCenter(false);
            this.emptyView.setText(LocaleController.getString("NoPhotos", R.string.NoPhotos));
        } else {
            this.emptyView.setShowAtTop(true);
            this.emptyView.setPadding(0, AndroidUtilities.dp(200.0f), 0, 0);
            this.emptyView.setText(LocaleController.getString("NoRecentSearches", R.string.NoRecentSearches));
        }
        this.sizeNotifierFrameLayout.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, this.selectPhotoType != PhotoAlbumPickerActivity.SELECT_TYPE_ALL ? 0.0f : 48.0f));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.PhotoPickerActivity.9
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 1) {
                    AndroidUtilities.hideKeyboard(PhotoPickerActivity.this.getParentActivity().getCurrentFocus());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (PhotoPickerActivity.this.selectedAlbum == null) {
                    int iFindFirstVisibleItemPosition = PhotoPickerActivity.this.layoutManager.findFirstVisibleItemPosition();
                    int iAbs = iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(PhotoPickerActivity.this.layoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1;
                    if (iAbs <= 0 || iFindFirstVisibleItemPosition + iAbs <= PhotoPickerActivity.this.layoutManager.getItemCount() - 2 || PhotoPickerActivity.this.searching || PhotoPickerActivity.this.imageSearchEndReached) {
                        return;
                    }
                    PhotoPickerActivity photoPickerActivity = PhotoPickerActivity.this;
                    photoPickerActivity.searchImages(photoPickerActivity.type == 1, PhotoPickerActivity.this.lastSearchString, PhotoPickerActivity.this.nextImagesSearchOffset, true);
                }
            }
        });
        if (this.selectedAlbum == null) {
            updateSearchInterface();
        }
        if (this.needsBottomLayout) {
            View view = new View(context);
            this.shadow = view;
            view.setBackgroundResource(R.drawable.header_shadow_reverse);
            this.shadow.setTranslationY(AndroidUtilities.dp(48.0f));
            this.sizeNotifierFrameLayout.addView(this.shadow, LayoutHelper.createFrame(-1, 3.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            this.frameLayout2 = frameLayout;
            frameLayout.setBackgroundColor(Theme.getColor(this.dialogBackgroundKey));
            this.frameLayout2.setVisibility(4);
            this.frameLayout2.setTranslationY(AndroidUtilities.dp(48.0f));
            this.sizeNotifierFrameLayout.addView(this.frameLayout2, LayoutHelper.createFrame(-1, 48, 83));
            this.frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$F9cFIHszguPpRP7PuXYp7unF_G0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return PhotoPickerActivity.lambda$createView$3(view2, motionEvent);
                }
            });
            EditTextEmoji editTextEmoji = this.commentTextView;
            if (editTextEmoji != null) {
                editTextEmoji.onDestroy();
            }
            this.commentTextView = new EditTextEmoji(context, this.sizeNotifierFrameLayout, null, 1);
            this.commentTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(MessagesController.getInstance(UserConfig.selectedAccount).maxCaptionLength)});
            this.commentTextView.setHint(LocaleController.getString("AddCaption", R.string.AddCaption));
            this.commentTextView.onResume();
            EditTextCaption editText = this.commentTextView.getEditText();
            editText.setMaxLines(1);
            editText.setSingleLine(true);
            this.frameLayout2.addView(this.commentTextView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 84.0f, 0.0f));
            CharSequence charSequence = this.caption;
            if (charSequence != null) {
                this.commentTextView.setText(charSequence);
            }
            this.commentTextView.getEditText().addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.PhotoPickerActivity.10
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    if (PhotoPickerActivity.this.delegate != null) {
                        PhotoPickerActivity.this.delegate.onCaptionChanged(s);
                    }
                }
            });
            FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.PhotoPickerActivity.11
                @Override // android.view.View
                public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                    super.onInitializeAccessibilityNodeInfo(info);
                    info.setText(LocaleController.formatPluralString("AccDescrSendPhotos", PhotoPickerActivity.this.selectedPhotos.size()));
                    info.setClassName(Button.class.getName());
                    info.setLongClickable(true);
                    info.setClickable(true);
                }
            };
            this.writeButtonContainer = frameLayout2;
            frameLayout2.setFocusable(true);
            this.writeButtonContainer.setFocusableInTouchMode(true);
            this.writeButtonContainer.setVisibility(4);
            this.writeButtonContainer.setScaleX(0.2f);
            this.writeButtonContainer.setScaleY(0.2f);
            this.writeButtonContainer.setAlpha(0.0f);
            this.sizeNotifierFrameLayout.addView(this.writeButtonContainer, LayoutHelper.createFrame(60, 60.0f, 85, 0.0f, 0.0f, 12.0f, 10.0f));
            this.writeButton = new ImageView(context);
            int iDp = AndroidUtilities.dp(56.0f);
            int color = Theme.getColor("dialogFloatingButton");
            int i4 = Build.VERSION.SDK_INT;
            this.writeButtonDrawable = Theme.createSimpleSelectorCircleDrawable(iDp, color, Theme.getColor(i4 >= 21 ? "dialogFloatingButtonPressed" : "dialogFloatingButton"));
            if (i4 < 21) {
                Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
                drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
                CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, this.writeButtonDrawable, 0, 0);
                combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                this.writeButtonDrawable = combinedDrawable;
            }
            this.writeButton.setBackgroundDrawable(this.writeButtonDrawable);
            this.writeButton.setImageResource(R.drawable.attach_send);
            this.writeButton.setImportantForAccessibility(2);
            this.writeButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogFloatingIcon"), PorterDuff.Mode.MULTIPLY));
            this.writeButton.setScaleType(ImageView.ScaleType.CENTER);
            if (i4 >= 21) {
                this.writeButton.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.PhotoPickerActivity.12
                    @Override // android.view.ViewOutlineProvider
                    @SuppressLint({"NewApi"})
                    public void getOutline(View view2, Outline outline) {
                        outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                    }
                });
            }
            this.writeButtonContainer.addView(this.writeButton, LayoutHelper.createFrame(i4 >= 21 ? 56 : 60, i4 >= 21 ? 56.0f : 60.0f, 51, i4 >= 21 ? 2.0f : 0.0f, 0.0f, 0.0f, 0.0f));
            this.writeButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$EepweOvEEzUWYz9VTQMMlX6hQdI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$createView$4$PhotoPickerActivity(view2);
                }
            });
            this.writeButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$TZIrP45XX5eojiRQKostRehKC_o
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return this.f$0.lambda$createView$7$PhotoPickerActivity(view2);
                }
            });
            this.textPaint.setTextSize(AndroidUtilities.dp(12.0f));
            this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
            View view2 = new View(context) { // from class: ir.eitaa.ui.PhotoPickerActivity.14
                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    String str = String.format("%d", Integer.valueOf(Math.max(1, PhotoPickerActivity.this.selectedPhotosOrder.size())));
                    int iMax = Math.max(AndroidUtilities.dp(16.0f) + ((int) Math.ceil(PhotoPickerActivity.this.textPaint.measureText(str))), AndroidUtilities.dp(24.0f));
                    int measuredWidth = getMeasuredWidth() / 2;
                    int measuredHeight = getMeasuredHeight() / 2;
                    PhotoPickerActivity.this.textPaint.setColor(Theme.getColor("dialogRoundCheckBoxCheck"));
                    PhotoPickerActivity.this.paint.setColor(Theme.getColor(PhotoPickerActivity.this.dialogBackgroundKey));
                    int i5 = iMax / 2;
                    PhotoPickerActivity.this.rect.set(measuredWidth - i5, 0.0f, i5 + measuredWidth, getMeasuredHeight());
                    canvas.drawRoundRect(PhotoPickerActivity.this.rect, AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), PhotoPickerActivity.this.paint);
                    PhotoPickerActivity.this.paint.setColor(Theme.getColor("dialogRoundCheckBox"));
                    PhotoPickerActivity.this.rect.set(r5 + AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), r2 - AndroidUtilities.dp(2.0f), getMeasuredHeight() - AndroidUtilities.dp(2.0f));
                    canvas.drawRoundRect(PhotoPickerActivity.this.rect, AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), PhotoPickerActivity.this.paint);
                    canvas.drawText(str, measuredWidth - (r1 / 2), AndroidUtilities.dp(16.2f), PhotoPickerActivity.this.textPaint);
                }
            };
            this.selectedCountView = view2;
            view2.setAlpha(0.0f);
            this.selectedCountView.setScaleX(0.2f);
            this.selectedCountView.setScaleY(0.2f);
            this.sizeNotifierFrameLayout.addView(this.selectedCountView, LayoutHelper.createFrame(42, 24.0f, 85, 0.0f, 0.0f, -2.0f, 9.0f));
            if (this.selectPhotoType != PhotoAlbumPickerActivity.SELECT_TYPE_ALL) {
                this.commentTextView.setVisibility(8);
            }
        }
        this.allowIndices = (this.selectedAlbum != null || (i = this.type) == 0 || i == 1) && this.allowOrder;
        this.listView.setEmptyView(this.emptyView);
        updatePhotosButton(0);
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.PhotoPickerActivity$5, reason: invalid class name */
    class AnonymousClass5 extends SizeNotifierFrameLayout {
        private boolean ignoreLayout;
        private int lastItemSize;
        private int lastNotifyWidth;

        AnonymousClass5(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(heightMeasureSpec);
            int size2 = View.MeasureSpec.getSize(widthMeasureSpec);
            if (AndroidUtilities.isTablet()) {
                PhotoPickerActivity.this.itemsPerRow = 4;
            } else {
                Point point = AndroidUtilities.displaySize;
                if (point.x > point.y) {
                    PhotoPickerActivity.this.itemsPerRow = 4;
                } else {
                    PhotoPickerActivity.this.itemsPerRow = 3;
                }
            }
            this.ignoreLayout = true;
            PhotoPickerActivity.this.itemSize = ((size2 - AndroidUtilities.dp(12.0f)) - AndroidUtilities.dp(10.0f)) / PhotoPickerActivity.this.itemsPerRow;
            if (this.lastItemSize != PhotoPickerActivity.this.itemSize) {
                this.lastItemSize = PhotoPickerActivity.this.itemSize;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$5$WmCjiFErmAZT7klOvtFd68icHII
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onMeasure$0$PhotoPickerActivity$5();
                    }
                });
            }
            if (PhotoPickerActivity.this.listSort) {
                PhotoPickerActivity.this.layoutManager.setSpanCount(1);
            } else {
                PhotoPickerActivity.this.layoutManager.setSpanCount((PhotoPickerActivity.this.itemSize * PhotoPickerActivity.this.itemsPerRow) + (AndroidUtilities.dp(5.0f) * (PhotoPickerActivity.this.itemsPerRow - 1)));
            }
            this.ignoreLayout = false;
            onMeasureInternal(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onMeasure$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onMeasure$0$PhotoPickerActivity$5() {
            PhotoPickerActivity.this.listAdapter.notifyDataSetChanged();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void onMeasureInternal(int r13, int r14) {
            /*
                Method dump skipped, instructions count: 277
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoPickerActivity.AnonymousClass5.onMeasureInternal(int, int):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0104  */
        @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 283
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoPickerActivity.AnonymousClass5.onLayout(boolean, int, int, int, int):void");
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$PhotoPickerActivity(View view, int i) throws InterruptedException, Resources.NotFoundException {
        ArrayList<Object> arrayList;
        int i2;
        if (this.selectedAlbum == null && this.searchResult.isEmpty()) {
            if (i < this.recentSearches.size()) {
                String str = this.recentSearches.get(i);
                PhotoPickerActivitySearchDelegate photoPickerActivitySearchDelegate = this.searchDelegate;
                if (photoPickerActivitySearchDelegate != null) {
                    photoPickerActivitySearchDelegate.shouldSearchText(str);
                    return;
                }
                this.searchItem.getSearchField().setText(str);
                this.searchItem.getSearchField().setSelection(str.length());
                processSearch(this.searchItem.getSearchField());
                return;
            }
            if (i == this.recentSearches.size() + 1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("ClearSearchAlertTitle", R.string.ClearSearchAlertTitle));
                builder.setMessage(LocaleController.getString("ClearSearchAlert", R.string.ClearSearchAlert));
                builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$rF9AFPj-a7zuYzsT5jRCAz_pa3g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$createView$0$PhotoPickerActivity(dialogInterface, i3);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder.create();
                showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor("dialogTextRed2"));
                    return;
                }
                return;
            }
            return;
        }
        MediaController.AlbumEntry albumEntry = this.selectedAlbum;
        if (albumEntry != null) {
            arrayList = albumEntry.photos;
        } else {
            arrayList = this.searchResult;
        }
        ArrayList<Object> arrayList2 = arrayList;
        if (i < 0 || i >= arrayList2.size()) {
            return;
        }
        ActionBarMenuItem actionBarMenuItem = this.searchItem;
        if (actionBarMenuItem != null) {
            AndroidUtilities.hideKeyboard(actionBarMenuItem.getSearchField());
        }
        if (this.listSort) {
            onListItemClick(view, arrayList2.get(i));
            return;
        }
        int i3 = this.selectPhotoType;
        if (i3 == PhotoAlbumPickerActivity.SELECT_TYPE_AVATAR || i3 == PhotoAlbumPickerActivity.SELECT_TYPE_AVATAR_VIDEO) {
            i2 = 1;
        } else if (i3 == PhotoAlbumPickerActivity.SELECT_TYPE_WALLPAPER) {
            i2 = 3;
        } else if (i3 == PhotoAlbumPickerActivity.SELECT_TYPE_QR) {
            i2 = 10;
        } else {
            i2 = this.chatActivity == null ? 4 : 0;
        }
        PhotoViewer.getInstance().setParentActivity(getParentActivity());
        PhotoViewer.getInstance().setMaxSelectedPhotos(this.maxSelectedPhotos, this.allowOrder);
        PhotoViewer.getInstance().openPhotoForSelect(arrayList2, i, i2, this.isDocumentsPicker, this.provider, this.chatActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$PhotoPickerActivity(DialogInterface dialogInterface, int i) {
        PhotoPickerActivitySearchDelegate photoPickerActivitySearchDelegate = this.searchDelegate;
        if (photoPickerActivitySearchDelegate != null) {
            photoPickerActivitySearchDelegate.shouldClearRecentSearch();
        } else {
            clearRecentSearch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$2$PhotoPickerActivity(View view, int i) {
        if (this.listSort) {
            onListItemClick(view, this.selectedAlbum.photos.get(i));
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
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$PhotoPickerActivity(View view) {
        ChatActivity chatActivity = this.chatActivity;
        if (chatActivity != null && chatActivity.isInScheduleMode()) {
            AlertsCreator.createScheduleDatePickerDialog(getParentActivity(), this.chatActivity.getDialogId(), new $$Lambda$PhotoPickerActivity$sgswCrZTf5NwFy1shfo1k1fpDuM(this));
        } else {
            sendSelectedPhotos(true, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$7$PhotoPickerActivity(View view) {
        ChatActivity chatActivity = this.chatActivity;
        if (chatActivity != null && this.maxSelectedPhotos != 1) {
            chatActivity.getCurrentChat();
            TLRPC$User currentUser = this.chatActivity.getCurrentUser();
            if (this.sendPopupLayout == null) {
                ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getParentActivity());
                this.sendPopupLayout = actionBarPopupWindowLayout;
                actionBarPopupWindowLayout.setAnimationEnabled(false);
                this.sendPopupLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.PhotoPickerActivity.13
                    private Rect popupRect = new Rect();

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getActionMasked() != 0 || PhotoPickerActivity.this.sendPopupWindow == null || !PhotoPickerActivity.this.sendPopupWindow.isShowing()) {
                            return false;
                        }
                        v.getHitRect(this.popupRect);
                        if (this.popupRect.contains((int) event.getX(), (int) event.getY())) {
                            return false;
                        }
                        PhotoPickerActivity.this.sendPopupWindow.dismiss();
                        return false;
                    }
                });
                this.sendPopupLayout.setDispatchKeyEventListener(new ActionBarPopupWindow.OnDispatchKeyEventListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$Oys-l0i12mLZhxt8IhZCCgaq7Ws
                    @Override // ir.eitaa.ui.ActionBar.ActionBarPopupWindow.OnDispatchKeyEventListener
                    public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                        this.f$0.lambda$createView$5$PhotoPickerActivity(keyEvent);
                    }
                });
                this.sendPopupLayout.setShownFromBotton(false);
                this.itemCells = new ActionBarMenuSubItem[2];
                final int i = 0;
                while (i < 2) {
                    if ((i != 0 || this.chatActivity.canScheduleMessage()) && (i != 1 || !UserObject.isUserSelf(currentUser))) {
                        this.itemCells[i] = new ActionBarMenuSubItem(getParentActivity(), i == 0, i == 1);
                        if (i == 0) {
                            if (UserObject.isUserSelf(currentUser)) {
                                this.itemCells[i].setTextAndIcon(LocaleController.getString("SetReminder", R.string.SetReminder), R.drawable.msg_schedule);
                            } else {
                                this.itemCells[i].setTextAndIcon(LocaleController.getString("ScheduleMessage", R.string.ScheduleMessage), R.drawable.msg_schedule);
                            }
                        } else {
                            this.itemCells[i].setTextAndIcon(LocaleController.getString("SendWithoutSound", R.string.SendWithoutSound), R.drawable.input_notify_off);
                        }
                        this.itemCells[i].setMinimumWidth(AndroidUtilities.dp(196.0f));
                        this.sendPopupLayout.addView((View) this.itemCells[i], LayoutHelper.createLinear(-1, 48));
                        this.itemCells[i].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$hmKRb140h5X3_75M2a1hAZECrE8
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                this.f$0.lambda$createView$6$PhotoPickerActivity(i, view2);
                            }
                        });
                    }
                    i++;
                }
                this.sendPopupLayout.setupRadialSelectors(Theme.getColor(this.selectorKey));
                ActionBarPopupWindow actionBarPopupWindow = new ActionBarPopupWindow(this.sendPopupLayout, -2, -2);
                this.sendPopupWindow = actionBarPopupWindow;
                actionBarPopupWindow.setAnimationEnabled(false);
                this.sendPopupWindow.setAnimationStyle(R.style.PopupContextAnimation2);
                this.sendPopupWindow.setOutsideTouchable(true);
                this.sendPopupWindow.setClippingEnabled(true);
                this.sendPopupWindow.setInputMethodMode(2);
                this.sendPopupWindow.setSoftInputMode(0);
                this.sendPopupWindow.getContentView().setFocusableInTouchMode(true);
            }
            this.sendPopupLayout.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
            this.sendPopupWindow.setFocusable(true);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            this.sendPopupWindow.showAtLocation(view, 51, ((iArr[0] + view.getMeasuredWidth()) - this.sendPopupLayout.getMeasuredWidth()) + AndroidUtilities.dp(8.0f), (iArr[1] - this.sendPopupLayout.getMeasuredHeight()) - AndroidUtilities.dp(2.0f));
            this.sendPopupWindow.dimBehind();
            view.performHapticFeedback(3, 2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$PhotoPickerActivity(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.sendPopupWindow) != null && actionBarPopupWindow.isShowing()) {
            this.sendPopupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$PhotoPickerActivity(int i, View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.sendPopupWindow;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.sendPopupWindow.dismiss();
        }
        if (i == 0) {
            AlertsCreator.createScheduleDatePickerDialog(getParentActivity(), this.chatActivity.getDialogId(), new $$Lambda$PhotoPickerActivity$sgswCrZTf5NwFy1shfo1k1fpDuM(this));
        } else {
            sendSelectedPhotos(true, 0);
        }
    }

    public void setLayoutViews(FrameLayout f2, FrameLayout button, View count, View s, EditTextEmoji emoji) {
        this.frameLayout2 = f2;
        this.writeButtonContainer = button;
        this.commentTextView = emoji;
        this.selectedCountView = count;
        this.shadow = s;
        this.needsBottomLayout = false;
    }

    private void applyCaption() {
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji == null || editTextEmoji.length() <= 0) {
            return;
        }
        Object obj = this.selectedPhotos.get(this.selectedPhotosOrder.get(0));
        if (obj instanceof MediaController.PhotoEntry) {
            ((MediaController.PhotoEntry) obj).caption = this.commentTextView.getText().toString();
        } else if (obj instanceof MediaController.SearchImage) {
            ((MediaController.SearchImage) obj).caption = this.commentTextView.getText().toString();
        }
    }

    private void onListItemClick(View view, Object item) {
        boolean z = addToSelectedPhotos(item, -1) == -1;
        if (view instanceof SharedDocumentCell) {
            ((SharedDocumentCell) view).setChecked(this.selectedPhotosOrder.contains(Integer.valueOf(this.selectedAlbum.photos.get(((Integer) view.getTag()).intValue()).imageId)), true);
        }
        updatePhotosButton(z ? 1 : 2);
        this.delegate.selectedPhotosChanged();
    }

    public void clearRecentSearch() {
        this.recentSearches.clear();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        saveRecentSearch();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onResume();
        }
        ActionBarMenuItem actionBarMenuItem = this.searchItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.openSearch(true);
            if (!TextUtils.isEmpty(this.initialSearchString)) {
                this.searchItem.setSearchFieldText(this.initialSearchString, false);
                this.initialSearchString = null;
                processSearch(this.searchItem.getSearchField());
            }
            getParentActivity().getWindow().setSoftInputMode(SharedConfig.smoothKeyboard ? 32 : 16);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.closeChats) {
            removeSelfFromStack();
        }
    }

    public RecyclerListView getListView() {
        return this.listView;
    }

    public void setCaption(CharSequence text) {
        this.caption = text;
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji != null) {
            editTextEmoji.setText(text);
        }
    }

    public void setInitialSearchString(String text) {
        this.initialSearchString = text;
    }

    private void saveRecentSearch() {
        SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("web_recent_search", 0).edit();
        editorEdit.clear();
        editorEdit.putInt(NotificationBadge.NewHtcHomeBadger.COUNT, this.recentSearches.size());
        int size = this.recentSearches.size();
        for (int i = 0; i < size; i++) {
            editorEdit.putString("recent" + i, this.recentSearches.get(i));
        }
        editorEdit.commit();
    }

    private void loadRecentSearch() {
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("web_recent_search", 0);
        int i = sharedPreferences.getInt(NotificationBadge.NewHtcHomeBadger.COUNT, 0);
        for (int i2 = 0; i2 < i; i2++) {
            String string = sharedPreferences.getString("recent" + i2, null);
            if (string == null) {
                return;
            }
            this.recentSearches.add(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSearch(EditText editText) {
        if (editText.getText().length() == 0) {
            return;
        }
        String string = editText.getText().toString();
        int size = this.recentSearches.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (this.recentSearches.get(i).equalsIgnoreCase(string)) {
                this.recentSearches.remove(i);
                break;
            }
            i++;
        }
        this.recentSearches.add(0, string);
        while (this.recentSearches.size() > 20) {
            ArrayList<String> arrayList = this.recentSearches;
            arrayList.remove(arrayList.size() - 1);
        }
        saveRecentSearch();
        this.searchResult.clear();
        this.searchResultKeys.clear();
        this.imageSearchEndReached = true;
        searchImages(this.type == 1, string, "", true);
        this.lastSearchString = string;
        if (string.length() == 0) {
            this.lastSearchString = null;
            this.emptyView.setText(LocaleController.getString("NoRecentSearches", R.string.NoRecentSearches));
        } else {
            this.emptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
        }
        updateSearchInterface();
    }

    private boolean showCommentTextView(final boolean show, boolean animated) {
        if (this.commentTextView == null) {
            return false;
        }
        if (show == (this.frameLayout2.getTag() != null)) {
            return false;
        }
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.frameLayout2.setTag(show ? 1 : null);
        if (this.commentTextView.getEditText().isFocused()) {
            AndroidUtilities.hideKeyboard(this.commentTextView.getEditText());
        }
        this.commentTextView.hidePopup(true);
        if (show) {
            this.frameLayout2.setVisibility(0);
            this.writeButtonContainer.setVisibility(0);
        }
        if (animated) {
            this.animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            FrameLayout frameLayout = this.writeButtonContainer;
            Property property = View.SCALE_X;
            float[] fArr = new float[1];
            fArr[0] = show ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr));
            FrameLayout frameLayout2 = this.writeButtonContainer;
            Property property2 = View.SCALE_Y;
            float[] fArr2 = new float[1];
            fArr2[0] = show ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2));
            FrameLayout frameLayout3 = this.writeButtonContainer;
            Property property3 = View.ALPHA;
            float[] fArr3 = new float[1];
            fArr3[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout3, (Property<FrameLayout, Float>) property3, fArr3));
            View view = this.selectedCountView;
            Property property4 = View.SCALE_X;
            float[] fArr4 = new float[1];
            fArr4[0] = show ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) property4, fArr4));
            View view2 = this.selectedCountView;
            Property property5 = View.SCALE_Y;
            float[] fArr5 = new float[1];
            fArr5[0] = show ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) property5, fArr5));
            View view3 = this.selectedCountView;
            Property property6 = View.ALPHA;
            float[] fArr6 = new float[1];
            fArr6[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(view3, (Property<View, Float>) property6, fArr6));
            FrameLayout frameLayout4 = this.frameLayout2;
            Property property7 = View.TRANSLATION_Y;
            float[] fArr7 = new float[1];
            fArr7[0] = show ? 0.0f : AndroidUtilities.dp(48.0f);
            arrayList.add(ObjectAnimator.ofFloat(frameLayout4, (Property<FrameLayout, Float>) property7, fArr7));
            View view4 = this.shadow;
            Property property8 = View.TRANSLATION_Y;
            float[] fArr8 = new float[1];
            fArr8[0] = show ? 0.0f : AndroidUtilities.dp(48.0f);
            arrayList.add(ObjectAnimator.ofFloat(view4, (Property<View, Float>) property8, fArr8));
            this.animatorSet.playTogether(arrayList);
            this.animatorSet.setInterpolator(new DecelerateInterpolator());
            this.animatorSet.setDuration(180L);
            this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoPickerActivity.15
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (animation.equals(PhotoPickerActivity.this.animatorSet)) {
                        if (!show) {
                            PhotoPickerActivity.this.frameLayout2.setVisibility(4);
                            PhotoPickerActivity.this.writeButtonContainer.setVisibility(4);
                        }
                        PhotoPickerActivity.this.animatorSet = null;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (animation.equals(PhotoPickerActivity.this.animatorSet)) {
                        PhotoPickerActivity.this.animatorSet = null;
                    }
                }
            });
            this.animatorSet.start();
        } else {
            this.writeButtonContainer.setScaleX(show ? 1.0f : 0.2f);
            this.writeButtonContainer.setScaleY(show ? 1.0f : 0.2f);
            this.writeButtonContainer.setAlpha(show ? 1.0f : 0.0f);
            this.selectedCountView.setScaleX(show ? 1.0f : 0.2f);
            this.selectedCountView.setScaleY(show ? 1.0f : 0.2f);
            this.selectedCountView.setAlpha(show ? 1.0f : 0.0f);
            this.frameLayout2.setTranslationY(show ? 0.0f : AndroidUtilities.dp(48.0f));
            this.shadow.setTranslationY(show ? 0.0f : AndroidUtilities.dp(48.0f));
            if (!show) {
                this.frameLayout2.setVisibility(4);
                this.writeButtonContainer.setVisibility(4);
            }
        }
        return true;
    }

    public void setMaxSelectedPhotos(int value, boolean order) {
        this.maxSelectedPhotos = value;
        this.allowOrder = order;
        if (value <= 0 || this.type != 1) {
            return;
        }
        this.maxSelectedPhotos = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCheckedPhotoIndices() {
        if (this.allowIndices) {
            int childCount = this.listView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof PhotoAttachPhotoCell) {
                    PhotoAttachPhotoCell photoAttachPhotoCell = (PhotoAttachPhotoCell) childAt;
                    Integer num = (Integer) childAt.getTag();
                    MediaController.AlbumEntry albumEntry = this.selectedAlbum;
                    if (albumEntry != null) {
                        photoAttachPhotoCell.setNum(this.allowIndices ? this.selectedPhotosOrder.indexOf(Integer.valueOf(albumEntry.photos.get(num.intValue()).imageId)) : -1);
                    } else {
                        photoAttachPhotoCell.setNum(this.allowIndices ? this.selectedPhotosOrder.indexOf(this.searchResult.get(num.intValue()).id) : -1);
                    }
                } else if (childAt instanceof SharedDocumentCell) {
                    ((SharedDocumentCell) childAt).setChecked(this.selectedPhotosOrder.indexOf(Integer.valueOf(this.selectedAlbum.photos.get(((Integer) childAt.getTag()).intValue()).imageId)) != 0, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.eitaa.ui.Cells.PhotoAttachPhotoCell getCellForIndex(int r6) {
        /*
            r5 = this;
            ir.eitaa.ui.Components.RecyclerListView r0 = r5.listView
            int r0 = r0.getChildCount()
            r1 = 0
        L7:
            if (r1 >= r0) goto L3f
            ir.eitaa.ui.Components.RecyclerListView r2 = r5.listView
            android.view.View r2 = r2.getChildAt(r1)
            boolean r3 = r2 instanceof ir.eitaa.ui.Cells.PhotoAttachPhotoCell
            if (r3 == 0) goto L3c
            ir.eitaa.ui.Cells.PhotoAttachPhotoCell r2 = (ir.eitaa.ui.Cells.PhotoAttachPhotoCell) r2
            java.lang.Object r3 = r2.getTag()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            ir.eitaa.messenger.MediaController$AlbumEntry r4 = r5.selectedAlbum
            if (r4 == 0) goto L2e
            if (r3 < 0) goto L3c
            java.util.ArrayList<ir.eitaa.messenger.MediaController$PhotoEntry> r4 = r4.photos
            int r4 = r4.size()
            if (r3 < r4) goto L39
            goto L3c
        L2e:
            if (r3 < 0) goto L3c
            java.util.ArrayList<ir.eitaa.messenger.MediaController$SearchImage> r4 = r5.searchResult
            int r4 = r4.size()
            if (r3 < r4) goto L39
            goto L3c
        L39:
            if (r3 != r6) goto L3c
            return r2
        L3c:
            int r1 = r1 + 1
            goto L7
        L3f:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoPickerActivity.getCellForIndex(int):ir.eitaa.ui.Cells.PhotoAttachPhotoCell");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int addToSelectedPhotos(Object object, int index) {
        Object objValueOf;
        boolean z = object instanceof MediaController.PhotoEntry;
        if (z) {
            objValueOf = Integer.valueOf(((MediaController.PhotoEntry) object).imageId);
        } else {
            objValueOf = object instanceof MediaController.SearchImage ? ((MediaController.SearchImage) object).id : null;
        }
        if (objValueOf == null) {
            return -1;
        }
        if (this.selectedPhotos.containsKey(objValueOf)) {
            this.selectedPhotos.remove(objValueOf);
            int iIndexOf = this.selectedPhotosOrder.indexOf(objValueOf);
            if (iIndexOf >= 0) {
                this.selectedPhotosOrder.remove(iIndexOf);
            }
            if (this.allowIndices) {
                updateCheckedPhotoIndices();
            }
            if (index >= 0) {
                if (z) {
                    ((MediaController.PhotoEntry) object).reset();
                } else if (object instanceof MediaController.SearchImage) {
                    ((MediaController.SearchImage) object).reset();
                }
                this.provider.updatePhotoAtIndex(index);
            }
            return iIndexOf;
        }
        this.selectedPhotos.put(objValueOf, object);
        this.selectedPhotosOrder.add(objValueOf);
        return -1;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        ActionBarMenuItem actionBarMenuItem;
        if (!isOpen || (actionBarMenuItem = this.searchItem) == null) {
            return;
        }
        AndroidUtilities.showKeyboard(actionBarMenuItem.getSearchField());
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji != null && editTextEmoji.isPopupShowing()) {
            this.commentTextView.hidePopup(true);
            return false;
        }
        return super.onBackPressed();
    }

    public void updatePhotosButton(int animated) {
        if (this.selectedPhotos.size() == 0) {
            this.selectedCountView.setPivotX(0.0f);
            this.selectedCountView.setPivotY(0.0f);
            showCommentTextView(false, animated != 0);
            return;
        }
        this.selectedCountView.invalidate();
        if (!showCommentTextView(true, animated != 0) && animated != 0) {
            this.selectedCountView.setPivotX(AndroidUtilities.dp(21.0f));
            this.selectedCountView.setPivotY(AndroidUtilities.dp(12.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            Animator[] animatorArr = new Animator[2];
            View view = this.selectedCountView;
            Property property = View.SCALE_X;
            float[] fArr = new float[2];
            fArr[0] = animated == 1 ? 1.1f : 0.9f;
            fArr[1] = 1.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
            View view2 = this.selectedCountView;
            Property property2 = View.SCALE_Y;
            float[] fArr2 = new float[2];
            fArr2[0] = animated != 1 ? 0.9f : 1.1f;
            fArr2[1] = 1.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property2, fArr2);
            animatorSet.playTogether(animatorArr);
            animatorSet.setInterpolator(new OvershootInterpolator());
            animatorSet.setDuration(180L);
            animatorSet.start();
            return;
        }
        this.selectedCountView.setPivotX(0.0f);
        this.selectedCountView.setPivotY(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSearchInterface() {
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        if (this.searching && this.searchResult.isEmpty()) {
            this.emptyView.showProgress();
        } else {
            this.emptyView.showTextView();
        }
    }

    private void searchBotUser(final boolean gif) {
        if (this.searchingUser) {
            return;
        }
        this.searchingUser = true;
        TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
        MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
        tLRPC$TL_contacts_resolveUsername.username = gif ? messagesController.gifSearchBot : messagesController.imageSearchBot;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$X7Jc7gX6RNf63v7WIObDyRNd7Ng
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$searchBotUser$9$PhotoPickerActivity(gif, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchBotUser$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchBotUser$9$PhotoPickerActivity(final boolean z, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$5zrU0bDeAmZc4bZdw6BaBK4z5qs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchBotUser$8$PhotoPickerActivity(tLObject, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchBotUser$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchBotUser$8$PhotoPickerActivity(TLObject tLObject, boolean z) {
        TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
        MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$TL_contacts_resolvedPeer.users, false);
        MessagesController.getInstance(this.currentAccount).putChats(tLRPC$TL_contacts_resolvedPeer.chats, false);
        MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(tLRPC$TL_contacts_resolvedPeer.users, tLRPC$TL_contacts_resolvedPeer.chats, true, true);
        String str = this.lastSearchImageString;
        this.lastSearchImageString = null;
        searchImages(z, str, "", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchImages(final boolean gif, final String query, final String offset, boolean searchUser) {
        if (this.searching) {
            this.searching = false;
            if (this.imageReqId != 0) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.imageReqId, true);
                this.imageReqId = 0;
            }
        }
        this.lastSearchImageString = query;
        this.searching = true;
        MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
        MessagesController messagesController2 = MessagesController.getInstance(this.currentAccount);
        TLObject userOrChat = messagesController.getUserOrChat(gif ? messagesController2.gifSearchBot : messagesController2.imageSearchBot);
        if (!(userOrChat instanceof TLRPC$User)) {
            if (searchUser) {
                searchBotUser(gif);
                return;
            }
            return;
        }
        final TLRPC$User tLRPC$User = (TLRPC$User) userOrChat;
        TLRPC$TL_messages_getInlineBotResults tLRPC$TL_messages_getInlineBotResults = new TLRPC$TL_messages_getInlineBotResults();
        if (query == null) {
            query = "";
        }
        tLRPC$TL_messages_getInlineBotResults.query = query;
        tLRPC$TL_messages_getInlineBotResults.bot = MessagesController.getInstance(this.currentAccount).getInputUser(tLRPC$User);
        tLRPC$TL_messages_getInlineBotResults.offset = offset;
        ChatActivity chatActivity = this.chatActivity;
        if (chatActivity != null) {
            long dialogId = chatActivity.getDialogId();
            if (DialogObject.isEncryptedDialog(dialogId)) {
                tLRPC$TL_messages_getInlineBotResults.peer = new TLRPC$TL_inputPeerEmpty();
            } else {
                tLRPC$TL_messages_getInlineBotResults.peer = getMessagesController().getInputPeer(dialogId);
            }
        } else {
            tLRPC$TL_messages_getInlineBotResults.peer = new TLRPC$TL_inputPeerEmpty();
        }
        final int i = this.lastSearchToken + 1;
        this.lastSearchToken = i;
        this.imageReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getInlineBotResults, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$mfEM2Alxe5cYZ9TLAwcviT2xAEU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$searchImages$11$PhotoPickerActivity(i, gif, tLRPC$User, tLObject, tLRPC$TL_error);
            }
        });
        ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(this.imageReqId, this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchImages$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchImages$11$PhotoPickerActivity(final int i, final boolean z, final TLRPC$User tLRPC$User, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerActivity$gUC9-m4wHJ9vWH4DQUNwhZABlzw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchImages$10$PhotoPickerActivity(i, tLObject, z, tLRPC$User);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchImages$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchImages$10$PhotoPickerActivity(int i, TLObject tLObject, boolean z, TLRPC$User tLRPC$User) {
        int i2;
        TLRPC$Photo tLRPC$Photo;
        TLRPC$PhotoSize closestPhotoSizeWithSize;
        if (i != this.lastSearchToken) {
            return;
        }
        int size = this.searchResult.size();
        if (tLObject != null) {
            TLRPC$messages_BotResults tLRPC$messages_BotResults = (TLRPC$messages_BotResults) tLObject;
            this.nextImagesSearchOffset = tLRPC$messages_BotResults.next_offset;
            int size2 = tLRPC$messages_BotResults.results.size();
            i2 = 0;
            for (int i3 = 0; i3 < size2; i3++) {
                TLRPC$BotInlineResult tLRPC$BotInlineResult = tLRPC$messages_BotResults.results.get(i3);
                if ((z || "photo".equals(tLRPC$BotInlineResult.type)) && ((!z || "gif".equals(tLRPC$BotInlineResult.type)) && !this.searchResultKeys.containsKey(tLRPC$BotInlineResult.id))) {
                    MediaController.SearchImage searchImage = new MediaController.SearchImage();
                    if (z && tLRPC$BotInlineResult.document != null) {
                        for (int i4 = 0; i4 < tLRPC$BotInlineResult.document.attributes.size(); i4++) {
                            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$BotInlineResult.document.attributes.get(i4);
                            if ((tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeImageSize) || (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo)) {
                                searchImage.width = tLRPC$DocumentAttribute.w;
                                searchImage.height = tLRPC$DocumentAttribute.h;
                                break;
                            }
                        }
                        searchImage.document = tLRPC$BotInlineResult.document;
                        searchImage.size = 0;
                        TLRPC$Photo tLRPC$Photo2 = tLRPC$BotInlineResult.photo;
                        if (tLRPC$Photo2 != null && (closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo2.sizes, this.itemSize, true)) != null) {
                            tLRPC$BotInlineResult.document.thumbs.add(closestPhotoSizeWithSize);
                            tLRPC$BotInlineResult.document.flags |= 1;
                        }
                    } else if (!z && (tLRPC$Photo = tLRPC$BotInlineResult.photo) != null) {
                        TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, AndroidUtilities.getPhotoSize());
                        TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$BotInlineResult.photo.sizes, 320);
                        if (closestPhotoSizeWithSize2 != null) {
                            searchImage.width = closestPhotoSizeWithSize2.w;
                            searchImage.height = closestPhotoSizeWithSize2.h;
                            searchImage.photoSize = closestPhotoSizeWithSize2;
                            searchImage.photo = tLRPC$BotInlineResult.photo;
                            searchImage.size = closestPhotoSizeWithSize2.size;
                            searchImage.thumbPhotoSize = closestPhotoSizeWithSize3;
                        }
                    } else if (tLRPC$BotInlineResult.content != null) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= tLRPC$BotInlineResult.content.attributes.size()) {
                                break;
                            }
                            TLRPC$DocumentAttribute tLRPC$DocumentAttribute2 = tLRPC$BotInlineResult.content.attributes.get(i5);
                            if (tLRPC$DocumentAttribute2 instanceof TLRPC$TL_documentAttributeImageSize) {
                                searchImage.width = tLRPC$DocumentAttribute2.w;
                                searchImage.height = tLRPC$DocumentAttribute2.h;
                                break;
                            }
                            i5++;
                        }
                        TLRPC$WebDocument tLRPC$WebDocument = tLRPC$BotInlineResult.thumb;
                        if (tLRPC$WebDocument != null) {
                            searchImage.thumbUrl = tLRPC$WebDocument.url;
                        } else {
                            searchImage.thumbUrl = null;
                        }
                        TLRPC$WebDocument tLRPC$WebDocument2 = tLRPC$BotInlineResult.content;
                        searchImage.imageUrl = tLRPC$WebDocument2.url;
                        searchImage.size = z ? 0 : tLRPC$WebDocument2.size;
                    }
                    searchImage.id = tLRPC$BotInlineResult.id;
                    searchImage.type = z ? 1 : 0;
                    searchImage.inlineResult = tLRPC$BotInlineResult;
                    HashMap<String, String> map = new HashMap<>();
                    searchImage.params = map;
                    map.put("id", tLRPC$BotInlineResult.id);
                    searchImage.params.put("query_id", "" + tLRPC$messages_BotResults.query_id);
                    searchImage.params.put("bot_name", tLRPC$User.username);
                    this.searchResult.add(searchImage);
                    this.searchResultKeys.put(searchImage.id, searchImage);
                    i2++;
                }
            }
            this.imageSearchEndReached = size == this.searchResult.size() || this.nextImagesSearchOffset == null;
        } else {
            i2 = 0;
        }
        this.searching = false;
        if (i2 != 0) {
            this.listAdapter.notifyItemRangeInserted(size, i2);
        } else if (this.imageSearchEndReached) {
            this.listAdapter.notifyItemRemoved(this.searchResult.size() - 1);
        }
        if (this.searching && this.searchResult.isEmpty()) {
            this.emptyView.showProgress();
        } else {
            this.emptyView.showTextView();
        }
    }

    public void setDelegate(PhotoPickerActivityDelegate photoPickerActivityDelegate) {
        this.delegate = photoPickerActivityDelegate;
    }

    public void setSearchDelegate(PhotoPickerActivitySearchDelegate photoPickerActivitySearchDelegate) {
        this.searchDelegate = photoPickerActivitySearchDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSelectedPhotos(boolean notify, int scheduleDate) {
        if (this.selectedPhotos.isEmpty() || this.delegate == null || this.sendPressed) {
            return;
        }
        applyCaption();
        this.sendPressed = true;
        this.delegate.actionButtonPressed(false, notify, scheduleDate);
        if (this.selectPhotoType != PhotoAlbumPickerActivity.SELECT_TYPE_WALLPAPER) {
            finishFragment();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            if (PhotoPickerActivity.this.selectedAlbum == null) {
                return TextUtils.isEmpty(PhotoPickerActivity.this.lastSearchString) ? holder.getItemViewType() == 3 : holder.getAdapterPosition() < PhotoPickerActivity.this.searchResult.size();
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (PhotoPickerActivity.this.selectedAlbum == null) {
                if (PhotoPickerActivity.this.searchResult.isEmpty()) {
                    if (!TextUtils.isEmpty(PhotoPickerActivity.this.lastSearchString) || PhotoPickerActivity.this.recentSearches.isEmpty()) {
                        return 0;
                    }
                    return PhotoPickerActivity.this.recentSearches.size() + 2;
                }
                return PhotoPickerActivity.this.searchResult.size() + (!PhotoPickerActivity.this.imageSearchEndReached ? 1 : 0);
            }
            return PhotoPickerActivity.this.selectedAlbum.photos.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout sharedDocumentCell;
            FrameLayout frameLayout;
            if (i != 0) {
                if (i == 1) {
                    FrameLayout frameLayout2 = new FrameLayout(this.mContext);
                    frameLayout2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                    RadialProgressView radialProgressView = new RadialProgressView(this.mContext);
                    radialProgressView.setProgressColor(-11371101);
                    frameLayout2.addView(radialProgressView, LayoutHelper.createFrame(-1, -1.0f));
                    frameLayout = frameLayout2;
                } else if (i == 2) {
                    sharedDocumentCell = new SharedDocumentCell(this.mContext, 1);
                } else if (i == 3) {
                    TextCell textCell = new TextCell(this.mContext, 23, true);
                    textCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                    frameLayout = textCell;
                    if (PhotoPickerActivity.this.forceDarckTheme) {
                        textCell.textView.setTextColor(Theme.getColor(PhotoPickerActivity.this.textKey));
                        textCell.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("voipgroup_mutedIcon"), PorterDuff.Mode.MULTIPLY));
                        frameLayout = textCell;
                    }
                } else {
                    DividerCell dividerCell = new DividerCell(this.mContext);
                    dividerCell.setForceDarkTheme(PhotoPickerActivity.this.forceDarckTheme);
                    sharedDocumentCell = dividerCell;
                }
                sharedDocumentCell = frameLayout;
            } else {
                PhotoAttachPhotoCell photoAttachPhotoCell = new PhotoAttachPhotoCell(this.mContext, null);
                photoAttachPhotoCell.setDelegate(new PhotoAttachPhotoCell.PhotoAttachPhotoCellDelegate() { // from class: ir.eitaa.ui.PhotoPickerActivity.ListAdapter.1
                    private void checkSlowMode() {
                        TLRPC$Chat currentChat;
                        if (!PhotoPickerActivity.this.allowOrder || PhotoPickerActivity.this.chatActivity == null || (currentChat = PhotoPickerActivity.this.chatActivity.getCurrentChat()) == null || ChatObject.hasAdminRights(currentChat) || !currentChat.slowmode_enabled || PhotoPickerActivity.this.alertOnlyOnce == 2) {
                            return;
                        }
                        AlertsCreator.showSimpleAlert(PhotoPickerActivity.this, LocaleController.getString("Slowmode", R.string.Slowmode), LocaleController.getString("SlowmodeSelectSendError", R.string.SlowmodeSelectSendError));
                        if (PhotoPickerActivity.this.alertOnlyOnce == 1) {
                            PhotoPickerActivity.this.alertOnlyOnce = 2;
                        }
                    }

                    @Override // ir.eitaa.ui.Cells.PhotoAttachPhotoCell.PhotoAttachPhotoCellDelegate
                    public void onCheckClick(PhotoAttachPhotoCell v) {
                        boolean z;
                        int iIntValue = ((Integer) v.getTag()).intValue();
                        int size = -1;
                        if (PhotoPickerActivity.this.selectedAlbum != null) {
                            MediaController.PhotoEntry photoEntry = PhotoPickerActivity.this.selectedAlbum.photos.get(iIntValue);
                            z = !PhotoPickerActivity.this.selectedPhotos.containsKey(Integer.valueOf(photoEntry.imageId));
                            if (!z || PhotoPickerActivity.this.maxSelectedPhotos <= 0 || PhotoPickerActivity.this.selectedPhotos.size() < PhotoPickerActivity.this.maxSelectedPhotos) {
                                if (PhotoPickerActivity.this.allowIndices && z) {
                                    size = PhotoPickerActivity.this.selectedPhotosOrder.size();
                                }
                                v.setChecked(size, z, true);
                                PhotoPickerActivity.this.addToSelectedPhotos(photoEntry, iIntValue);
                            } else {
                                checkSlowMode();
                                return;
                            }
                        } else {
                            AndroidUtilities.hideKeyboard(PhotoPickerActivity.this.getParentActivity().getCurrentFocus());
                            MediaController.SearchImage searchImage = (MediaController.SearchImage) PhotoPickerActivity.this.searchResult.get(iIntValue);
                            z = !PhotoPickerActivity.this.selectedPhotos.containsKey(searchImage.id);
                            if (!z || PhotoPickerActivity.this.maxSelectedPhotos <= 0 || PhotoPickerActivity.this.selectedPhotos.size() < PhotoPickerActivity.this.maxSelectedPhotos) {
                                if (PhotoPickerActivity.this.allowIndices && z) {
                                    size = PhotoPickerActivity.this.selectedPhotosOrder.size();
                                }
                                v.setChecked(size, z, true);
                                PhotoPickerActivity.this.addToSelectedPhotos(searchImage, iIntValue);
                            } else {
                                checkSlowMode();
                                return;
                            }
                        }
                        PhotoPickerActivity.this.updatePhotosButton(z ? 1 : 2);
                        PhotoPickerActivity.this.delegate.selectedPhotosChanged();
                    }
                });
                photoAttachPhotoCell.getCheckFrame().setVisibility(PhotoPickerActivity.this.selectPhotoType != PhotoAlbumPickerActivity.SELECT_TYPE_ALL ? 8 : 0);
                sharedDocumentCell = photoAttachPhotoCell;
            }
            return new RecyclerListView.Holder(sharedDocumentCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            boolean zIsShowingImage;
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                PhotoAttachPhotoCell photoAttachPhotoCell = (PhotoAttachPhotoCell) holder.itemView;
                photoAttachPhotoCell.setItemSize(PhotoPickerActivity.this.itemSize);
                BackupImageView imageView = photoAttachPhotoCell.getImageView();
                photoAttachPhotoCell.setTag(Integer.valueOf(position));
                imageView.setOrientation(0, true);
                if (PhotoPickerActivity.this.selectedAlbum != null) {
                    MediaController.PhotoEntry photoEntry = PhotoPickerActivity.this.selectedAlbum.photos.get(position);
                    photoAttachPhotoCell.setPhotoEntry(photoEntry, true, false);
                    photoAttachPhotoCell.setChecked(PhotoPickerActivity.this.allowIndices ? PhotoPickerActivity.this.selectedPhotosOrder.indexOf(Integer.valueOf(photoEntry.imageId)) : -1, PhotoPickerActivity.this.selectedPhotos.containsKey(Integer.valueOf(photoEntry.imageId)), false);
                    zIsShowingImage = PhotoViewer.isShowingImage(photoEntry.path);
                } else {
                    MediaController.SearchImage searchImage = (MediaController.SearchImage) PhotoPickerActivity.this.searchResult.get(position);
                    photoAttachPhotoCell.setPhotoEntry(searchImage, true, false);
                    photoAttachPhotoCell.getVideoInfoContainer().setVisibility(4);
                    photoAttachPhotoCell.setChecked(PhotoPickerActivity.this.allowIndices ? PhotoPickerActivity.this.selectedPhotosOrder.indexOf(searchImage.id) : -1, PhotoPickerActivity.this.selectedPhotos.containsKey(searchImage.id), false);
                    zIsShowingImage = PhotoViewer.isShowingImage(searchImage.getPathToAttach());
                }
                imageView.getImageReceiver().setVisible(!zIsShowingImage, true);
                photoAttachPhotoCell.getCheckBox().setVisibility((PhotoPickerActivity.this.selectPhotoType != PhotoAlbumPickerActivity.SELECT_TYPE_ALL || zIsShowingImage) ? 8 : 0);
                return;
            }
            if (itemViewType == 1) {
                ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -1;
                    layoutParams.height = PhotoPickerActivity.this.itemSize;
                    holder.itemView.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (itemViewType == 2) {
                MediaController.PhotoEntry photoEntry2 = PhotoPickerActivity.this.selectedAlbum.photos.get(position);
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) holder.itemView;
                sharedDocumentCell.setPhotoEntry(photoEntry2);
                sharedDocumentCell.setChecked(PhotoPickerActivity.this.selectedPhotos.containsKey(Integer.valueOf(photoEntry2.imageId)), false);
                sharedDocumentCell.setTag(Integer.valueOf(position));
                return;
            }
            if (itemViewType != 3) {
                return;
            }
            TextCell textCell = (TextCell) holder.itemView;
            if (position < PhotoPickerActivity.this.recentSearches.size()) {
                textCell.setTextAndIcon((String) PhotoPickerActivity.this.recentSearches.get(position), R.drawable.menu_recent, false);
            } else {
                textCell.setTextAndIcon(LocaleController.getString("ClearRecentHistory", R.string.ClearRecentHistory), R.drawable.menu_clear_recent, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (PhotoPickerActivity.this.listSort) {
                return 2;
            }
            if (PhotoPickerActivity.this.selectedAlbum != null) {
                return 0;
            }
            return PhotoPickerActivity.this.searchResult.isEmpty() ? position == PhotoPickerActivity.this.recentSearches.size() ? 4 : 3 : position < PhotoPickerActivity.this.searchResult.size() ? 0 : 1;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.sizeNotifierFrameLayout, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, this.dialogBackgroundKey));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, this.dialogBackgroundKey));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, this.textKey));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, this.textKey));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, this.selectorKey));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, this.textKey));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "chat_messagePanelHint"));
        ActionBarMenuItem actionBarMenuItem = this.searchItem;
        arrayList.add(new ThemeDescription(actionBarMenuItem != null ? actionBarMenuItem.getSearchField() : null, ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, this.textKey));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, this.dialogBackgroundKey));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, null, new Drawable[]{Theme.chat_attachEmptyDrawable}, null, "chat_attachEmptyImage"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, null, null, null, "chat_attachPhotoBackground"));
        return arrayList;
    }
}
