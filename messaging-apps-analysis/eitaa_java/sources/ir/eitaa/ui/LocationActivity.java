package ir.eitaa.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.helper.MapHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_GetLocationAuthHash;
import ir.eitaa.tgnet.TLRPC$TL_UserPayHash;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Adapters.LocationActivityAdapter;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.LocationCell;
import ir.eitaa.ui.Cells.LocationDirectionCell;
import ir.eitaa.ui.Cells.LocationLoadingCell;
import ir.eitaa.ui.Cells.LocationPoweredCell;
import ir.eitaa.ui.Cells.SendLocationCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.SharingLiveLocationCell;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.HintView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.MapPlaceholderDrawable;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.UndoView;
import java.net.URLEncoder;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class LocationActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private LocationActivityAdapter adapter;
    private AnimatorSet animatorSet;
    private LocationActivityDelegate delegate;
    private long dialogId;
    private ImageView emptyImageView;
    private TextView emptySubtitleTextView;
    private TextView emptyTitleTextView;
    private LinearLayout emptyView;
    private HintView hintView;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private ImageView locationButton;
    private int locationType;
    private MapHelper mapHelper;
    private WebView mapView;
    private FrameLayout mapViewClip;
    private boolean mapsInitialized;
    private Runnable markAsReadRunnable;
    private View markerImageView;
    private int markerTop;
    private MessageObject messageObject;
    private Location myLocation;
    private boolean onResumeCalled;
    private ActionBarMenuItem otherItem;
    private MapOverlayView overlayView;
    private View shadow;
    private Drawable shadowDrawable;
    private Runnable updateRunnable;
    private boolean userLocationMoved;
    private float yOffset;
    private UndoView[] undoView = new UndoView[2];
    private boolean checkGpsEnabled = true;
    private boolean checkPermission = true;
    private boolean checkBackgroundPermission = true;
    private int overScrollHeight = (AndroidUtilities.displaySize.x - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.dp(66.0f);

    public static class LiveLocation {
    }

    public interface LocationActivityDelegate {
    }

    public class MapOverlayView extends FrameLayout {
    }

    static /* synthetic */ boolean lambda$createView$1(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent event) {
        return false;
    }

    public LocationActivity(int type) {
        this.locationType = type;
        AndroidUtilities.fixGoogleMapsBug();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getNotificationCenter().addObserver(this, NotificationCenter.closeChats);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.locationPermissionGranted);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.locationPermissionGranted);
        getNotificationCenter().removeObserver(this, NotificationCenter.closeChats);
        UndoView[] undoViewArr = this.undoView;
        if (undoViewArr[0] != null) {
            undoViewArr[0].hide(true, 0);
        }
        LocationActivityAdapter locationActivityAdapter = this.adapter;
        if (locationActivityAdapter != null) {
            locationActivityAdapter.destroy();
        }
        Runnable runnable = this.updateRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.updateRunnable = null;
        }
        Runnable runnable2 = this.markAsReadRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.markAsReadRunnable = null;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout frameLayout;
        LocationActivityAdapter locationActivityAdapter = this.adapter;
        if (locationActivityAdapter != null) {
            locationActivityAdapter.destroy();
        }
        this.actionBar.setBackgroundColor(Theme.getColor("dialogBackground"));
        this.actionBar.setTitleColor(Theme.getColor("dialogTextBlack"));
        this.actionBar.setItemsColor(Theme.getColor("dialogTextBlack"), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor("dialogButtonSelector"), false);
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setAddToContainer(false);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.LocationActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    LocationActivity.this.finishFragment();
                    return;
                }
                if (id == 1) {
                    try {
                        double d = LocationActivity.this.messageObject.messageOwner.media.geo.lat;
                        double d2 = LocationActivity.this.messageObject.messageOwner.media.geo._long;
                        LocationActivity.this.getParentActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:" + d + "," + d2 + "?q=" + d + "," + d2)));
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
            }
        });
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        this.actionBar.setTitle(LocaleController.getString("ChatLocation", R.string.ChatLocation));
        if (this.messageObject != null) {
            ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_other);
            this.otherItem = actionBarMenuItemAddItem;
            actionBarMenuItemAddItem.addSubItem(1, R.drawable.msg_openin, LocaleController.getString("OpenInExternalApp", R.string.OpenInExternalApp));
            this.otherItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        }
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.LocationActivity.2
            private boolean first = true;

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                if (changed) {
                    LocationActivity.this.fixLayoutInternal(this.first);
                    this.first = false;
                } else {
                    LocationActivity.this.updateClipView(true);
                }
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                if (child == ((BaseFragment) LocationActivity.this).actionBar && ((BaseFragment) LocationActivity.this).parentLayout != null) {
                    ((BaseFragment) LocationActivity.this).parentLayout.drawHeaderShadow(canvas, ((BaseFragment) LocationActivity.this).actionBar.getMeasuredHeight());
                }
                return zDrawChild;
            }
        };
        this.fragmentView = frameLayout2;
        FrameLayout frameLayout3 = frameLayout2;
        frameLayout2.setBackgroundColor(Theme.getColor("dialogBackground"));
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogBackground"), PorterDuff.Mode.MULTIPLY));
        final Rect rect = new Rect();
        this.shadowDrawable.getPadding(rect);
        int i = this.locationType;
        if (i == 0 || i == 1) {
            layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(21.0f) + rect.top);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(6.0f) + rect.top);
        }
        FrameLayout.LayoutParams layoutParams2 = layoutParams;
        layoutParams2.gravity = 83;
        FrameLayout frameLayout4 = new FrameLayout(context) { // from class: ir.eitaa.ui.LocationActivity.3
        };
        this.mapViewClip = frameLayout4;
        frameLayout4.setBackgroundDrawable(new MapPlaceholderDrawable());
        Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(40.0f), Theme.getColor("location_actionBackground"), Theme.getColor("location_actionPressedBackground"));
        this.locationButton = new ImageView(context);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(40.0f), Theme.getColor("location_actionBackground"), Theme.getColor("location_actionPressedBackground"));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            Drawable drawableMutate2 = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate2.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate2, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
            frameLayout = frameLayout3;
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            int[] iArr = {android.R.attr.state_pressed};
            ImageView imageView = this.locationButton;
            Property property = View.TRANSLATION_Z;
            frameLayout = frameLayout3;
            stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.locationButton, (Property<ImageView, Float>) property, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.locationButton.setStateListAnimator(stateListAnimator);
            this.locationButton.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.LocationActivity.4
                @Override // android.view.ViewOutlineProvider
                @SuppressLint({"NewApi"})
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
                }
            });
        }
        this.locationButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        this.locationButton.setImageResource(R.drawable.location_current);
        this.locationButton.setScaleType(ImageView.ScaleType.CENTER);
        this.locationButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("location_actionActiveIcon"), PorterDuff.Mode.MULTIPLY));
        this.locationButton.setTag("location_actionActiveIcon");
        this.locationButton.setContentDescription(LocaleController.getString("AccDescrMyLocation", R.string.AccDescrMyLocation));
        FrameLayout.LayoutParams layoutParamsCreateFrame = LayoutHelper.createFrame(i2 >= 21 ? 40 : 44, i2 >= 21 ? 40.0f : 44.0f, 85, 0.0f, 0.0f, 12.0f, 12.0f);
        layoutParamsCreateFrame.bottomMargin += layoutParams2.height - rect.top;
        this.mapViewClip.addView(this.locationButton, layoutParamsCreateFrame);
        this.locationButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LocationActivity$nU9sllUQQXHM6wnCloD7NKE2uxY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$0$LocationActivity(view);
            }
        });
        HintView hintView = new HintView(context, 6, true);
        this.hintView = hintView;
        hintView.setVisibility(4);
        this.hintView.setShowingDuration(4000L);
        this.mapViewClip.addView(this.hintView, LayoutHelper.createFrame(-2, -2.0f, 51, 10.0f, 0.0f, 10.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.emptyView = linearLayout;
        linearLayout.setOrientation(1);
        this.emptyView.setGravity(1);
        this.emptyView.setPadding(0, AndroidUtilities.dp(160.0f), 0, 0);
        this.emptyView.setVisibility(8);
        FrameLayout frameLayout5 = frameLayout;
        frameLayout5.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$LocationActivity$zUgUzkKICuzBgBbN8NVv1PonI4E
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return LocationActivity.lambda$createView$1(view, motionEvent);
            }
        });
        ImageView imageView2 = new ImageView(context);
        this.emptyImageView = imageView2;
        imageView2.setImageResource(R.drawable.location_empty);
        this.emptyImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogEmptyImage"), PorterDuff.Mode.MULTIPLY));
        this.emptyView.addView(this.emptyImageView, LayoutHelper.createLinear(-2, -2));
        TextView textView = new TextView(context);
        this.emptyTitleTextView = textView;
        textView.setTextColor(Theme.getColor("dialogEmptyText"));
        this.emptyTitleTextView.setGravity(17);
        this.emptyTitleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.emptyTitleTextView.setTextSize(1, 17.0f);
        this.emptyTitleTextView.setText(LocaleController.getString("NoPlacesFound", R.string.NoPlacesFound));
        this.emptyView.addView(this.emptyTitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 11, 0, 0));
        TextView textView2 = new TextView(context);
        this.emptySubtitleTextView = textView2;
        textView2.setTextColor(Theme.getColor("dialogEmptyText"));
        this.emptySubtitleTextView.setGravity(17);
        this.emptySubtitleTextView.setTextSize(1, 15.0f);
        this.emptySubtitleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        this.emptyView.addView(this.emptySubtitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 6, 0, 0));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        LocationActivityAdapter locationActivityAdapter2 = new LocationActivityAdapter(context, this.locationType, this.dialogId, false, null) { // from class: ir.eitaa.ui.LocationActivity.5
            @Override // ir.eitaa.ui.Adapters.LocationActivityAdapter
            protected void onDirectionClick() {
                Activity parentActivity;
                if (Build.VERSION.SDK_INT < 23 || (parentActivity = LocationActivity.this.getParentActivity()) == null || parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    try {
                        if (LocationActivity.this.messageObject != null) {
                            double d = LocationActivity.this.messageObject.messageOwner.media.geo.lat;
                            double d2 = LocationActivity.this.messageObject.messageOwner.media.geo._long;
                            LocationActivity.this.getParentActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:" + d + "," + d2 + "?q=" + d + "," + d2)));
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        FileLog.e(e);
                        return;
                    }
                }
                LocationActivity.this.showPermissionAlert(true);
            }
        };
        this.adapter = locationActivityAdapter2;
        recyclerListView.setAdapter(locationActivityAdapter2);
        this.adapter.setUpdateRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LocationActivity$SfqClUqBJh11ZVkhW_2_aImfdqw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$2$LocationActivity();
            }
        });
        this.listView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        frameLayout5.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.LocationActivity.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LocationActivity.this.updateClipView(false);
            }
        });
        ((DefaultItemAnimator) this.listView.getItemAnimator()).setDelayAnimations(false);
        this.adapter.setOverScrollHeight(this.overScrollHeight);
        frameLayout5.addView(this.mapViewClip, LayoutHelper.createFrame(-1, -1, 51));
        WebView webView = new WebView(context) { // from class: ir.eitaa.ui.LocationActivity.7
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                MotionEvent motionEvent;
                if (LocationActivity.this.yOffset != 0.0f) {
                    ev = MotionEvent.obtain(ev);
                    ev.offsetLocation(0.0f, (-LocationActivity.this.yOffset) / 2.0f);
                    motionEvent = ev;
                } else {
                    motionEvent = null;
                }
                boolean zDispatchTouchEvent = super.dispatchTouchEvent(ev);
                if (motionEvent != null) {
                    motionEvent.recycle();
                }
                return zDispatchTouchEvent;
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (LocationActivity.this.messageObject == null) {
                    if (ev.getAction() == 0) {
                        if (LocationActivity.this.animatorSet != null) {
                            LocationActivity.this.animatorSet.cancel();
                        }
                        LocationActivity.this.animatorSet = new AnimatorSet();
                        LocationActivity.this.animatorSet.setDuration(200L);
                        LocationActivity.this.animatorSet.playTogether(ObjectAnimator.ofFloat(LocationActivity.this.markerImageView, (Property<View, Float>) View.TRANSLATION_Y, LocationActivity.this.markerTop - AndroidUtilities.dp(10.0f)));
                        LocationActivity.this.animatorSet.start();
                    } else if (ev.getAction() == 1) {
                        if (LocationActivity.this.animatorSet != null) {
                            LocationActivity.this.animatorSet.cancel();
                        }
                        LocationActivity.this.yOffset = 0.0f;
                        LocationActivity.this.animatorSet = new AnimatorSet();
                        LocationActivity.this.animatorSet.setDuration(200L);
                        LocationActivity.this.animatorSet.playTogether(ObjectAnimator.ofFloat(LocationActivity.this.markerImageView, (Property<View, Float>) View.TRANSLATION_Y, LocationActivity.this.markerTop));
                        LocationActivity.this.animatorSet.start();
                        LocationActivity.this.adapter.fetchLocationAddress();
                    }
                    if (ev.getAction() == 2 && !LocationActivity.this.userLocationMoved) {
                        LocationActivity.this.locationButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("location_actionIcon"), PorterDuff.Mode.MULTIPLY));
                        LocationActivity.this.locationButton.setTag("location_actionIcon");
                        LocationActivity.this.userLocationMoved = true;
                    }
                }
                return super.onInterceptTouchEvent(ev);
            }
        };
        this.mapView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.mapView.setWebViewClient(new WebViewClient() { // from class: ir.eitaa.ui.LocationActivity.8
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (LocationActivity.this.mapsInitialized) {
                    return;
                }
                LocationActivity.this.mapsInitialized = true;
                LocationActivity.this.onMapInit();
            }
        });
        ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(new TLRPC$TL_GetLocationAuthHash(), new RequestDelegate() { // from class: ir.eitaa.ui.LocationActivity.9
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, final TLRPC$TL_error error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.LocationActivity.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (error == null) {
                            try {
                                LocationActivity.this.mapView.postUrl(MessagesController.getInstance(UserConfig.selectedAccount).mapHostUrl, ("hash=" + URLEncoder.encode(((TLRPC$TL_UserPayHash) response).hash, "UTF-8")).getBytes());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
        MessageObject messageObject = this.messageObject;
        if (messageObject != null) {
            this.adapter.setMessageObject(messageObject);
        }
        for (int i3 = 0; i3 < 2; i3++) {
            this.undoView[i3] = new UndoView(context);
            this.undoView[i3].setAdditionalTranslationY(AndroidUtilities.dp(10.0f));
            if (Build.VERSION.SDK_INT >= 21) {
                this.undoView[i3].setTranslationZ(AndroidUtilities.dp(5.0f));
            }
            this.mapViewClip.addView(this.undoView[i3], LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        }
        View view = new View(context) { // from class: ir.eitaa.ui.LocationActivity.10
            private RectF rect = new RectF();

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                LocationActivity.this.shadowDrawable.setBounds(-rect.left, 0, getMeasuredWidth() + rect.right, getMeasuredHeight());
                LocationActivity.this.shadowDrawable.draw(canvas);
                if (LocationActivity.this.locationType == 0 || LocationActivity.this.locationType == 1) {
                    int iDp = AndroidUtilities.dp(36.0f);
                    this.rect.set((getMeasuredWidth() - iDp) / 2, rect.top + AndroidUtilities.dp(10.0f), (getMeasuredWidth() + iDp) / 2, r1 + AndroidUtilities.dp(4.0f));
                    int color = Theme.getColor("key_sheet_scrollUp");
                    Color.alpha(color);
                    Theme.dialogs_onlineCirclePaint.setColor(color);
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), Theme.dialogs_onlineCirclePaint);
                }
            }
        };
        this.shadow = view;
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(AndroidUtilities.dp(6.0f));
        }
        this.mapViewClip.addView(this.shadow, layoutParams2);
        frameLayout5.addView(this.actionBar);
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$LocationActivity(View view) {
        MapHelper mapHelper;
        Activity parentActivity;
        if (Build.VERSION.SDK_INT >= 23 && (parentActivity = getParentActivity()) != null && parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            showPermissionAlert(false);
            return;
        }
        if (!checkGpsEnabled() || (mapHelper = this.mapHelper) == null) {
            return;
        }
        if (!mapHelper.isLocationTrackingStarted || mapHelper.currentLocation == null) {
            mapHelper.startLocationTracking();
        }
        MapHelper mapHelper2 = this.mapHelper;
        Location location = mapHelper2.currentLocation;
        this.myLocation = location;
        if (this.messageObject == null || location == null) {
            return;
        }
        mapHelper2.moveToUserLocation();
        this.adapter.setGpsLocation(this.mapHelper.currentLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$LocationActivity() {
        updateClipView(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMapInit() {
        MapHelper mapHelper = new MapHelper(getParentActivity(), this.mapView);
        this.mapHelper = mapHelper;
        mapHelper.startLocationTracking();
        this.mapHelper.setDelegate(new MapHelper.LocationDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LocationActivity$5o5kfNGJtA_ptOdFnqW17hVQF98
            @Override // ir.eitaa.helper.MapHelper.LocationDelegate
            public final void onLocationAvailability(Location location) {
                this.f$0.lambda$onMapInit$3$LocationActivity(location);
            }
        });
        MessageObject messageObject = this.messageObject;
        if (messageObject != null) {
            this.mapHelper.addMark(new MapHelper.LngLat(Double.valueOf(messageObject.messageOwner.media.geo.lat), Double.valueOf(this.messageObject.messageOwner.media.geo._long)), true);
        }
        if (!this.checkGpsEnabled || getParentActivity() == null) {
            return;
        }
        this.checkGpsEnabled = false;
        checkGpsEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onMapInit$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onMapInit$3$LocationActivity(Location location) {
        this.adapter.setGpsLocation(location);
    }

    private boolean checkGpsEnabled() {
        if (!getParentActivity().getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
            return true;
        }
        try {
            if (!((LocationManager) ApplicationLoader.applicationContext.getSystemService("location")).isProviderEnabled("gps")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("GpsDisabledAlertTitle", R.string.GpsDisabledAlertTitle));
                builder.setMessage(LocaleController.getString("GpsDisabledAlertText", R.string.GpsDisabledAlertText));
                builder.setPositiveButton(LocaleController.getString("ConnectingToProxyEnable", R.string.ConnectingToProxyEnable), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LocationActivity$rX3RqWsRZG5SKKU5vY-ZNBZXe1c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$checkGpsEnabled$4$LocationActivity(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                showDialog(builder.create());
                return false;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkGpsEnabled$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkGpsEnabled$4$LocationActivity(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        try {
            getParentActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPermissionAlert(boolean byButton) {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (byButton) {
            builder.setMessage(LocaleController.getString("PermissionNoLocationPosition", R.string.PermissionNoLocationPosition));
        } else {
            builder.setMessage(LocaleController.getString("PermissionNoLocation", R.string.PermissionNoLocation));
        }
        builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LocationActivity$UyPVfnpsvM6X4ABi7NXemU3j5FQ
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPermissionAlert$5$LocationActivity(dialogInterface, i);
            }
        });
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPermissionAlert$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPermissionAlert$5$LocationActivity(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            getParentActivity().startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (!isOpen || backward) {
            return;
        }
        try {
            if (this.mapView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mapView.getParent()).removeView(this.mapView);
            }
        } catch (Exception unused) {
        }
        FrameLayout frameLayout = this.mapViewClip;
        if (frameLayout != null) {
            frameLayout.addView(this.mapView, 0, LayoutHelper.createFrame(-1, this.overScrollHeight + AndroidUtilities.dp(10.0f), 51));
            if (this.overlayView != null) {
                try {
                    throw null;
                } catch (Exception unused2) {
                    this.mapViewClip.addView(this.overlayView, 1, LayoutHelper.createFrame(-1, this.overScrollHeight + AndroidUtilities.dp(10.0f), 51));
                }
            }
            updateClipView(false);
            return;
        }
        View view = this.fragmentView;
        if (view != null) {
            ((FrameLayout) view).addView(this.mapView, 0, LayoutHelper.createFrame(-1, -1, 51));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateClipView(boolean fromLayout) {
        int y;
        int iMin;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(0);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            y = (int) viewHolderFindViewHolderForAdapterPosition.itemView.getY();
            iMin = this.overScrollHeight + Math.min(y, 0);
        } else {
            y = -this.mapViewClip.getMeasuredHeight();
            iMin = 0;
        }
        if (((FrameLayout.LayoutParams) this.mapViewClip.getLayoutParams()) != null) {
            if (iMin <= 0) {
                if (this.mapView.getVisibility() == 0) {
                    this.mapView.setVisibility(4);
                    this.mapViewClip.setVisibility(4);
                    if (this.overlayView != null) {
                        throw null;
                    }
                }
            } else if (this.mapView.getVisibility() == 4) {
                this.mapView.setVisibility(0);
                this.mapViewClip.setVisibility(0);
                if (this.overlayView != null) {
                    throw null;
                }
            }
            this.mapViewClip.setTranslationY(Math.min(0, y));
            int i = -y;
            int i2 = i / 2;
            this.mapView.setTranslationY(Math.max(0, i2));
            if (this.overlayView != null) {
                Math.max(0, i2);
                throw null;
            }
            int i3 = this.overScrollHeight;
            int i4 = this.locationType;
            float fMin = Math.min(i3 - AndroidUtilities.dp(64 + ((i4 == 0 || i4 == 1) ? 30 : 10)), i);
            HintView hintView = this.hintView;
            if (hintView != null) {
                hintView.setExtraTranslationY(fMin);
            }
            View view = this.markerImageView;
            if (view != null) {
                int iDp = (i - AndroidUtilities.dp(view.getTag() == null ? 48.0f : 69.0f)) + (iMin / 2);
                this.markerTop = iDp;
                view.setTranslationY(iDp);
            }
            if (fromLayout) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mapView.getLayoutParams();
            if (layoutParams != null && layoutParams.height != this.overScrollHeight + AndroidUtilities.dp(10.0f)) {
                layoutParams.height = this.overScrollHeight + AndroidUtilities.dp(10.0f);
                this.mapView.setLayoutParams(layoutParams);
            }
            if (this.overlayView != null) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal(final boolean resume) {
        if (this.listView != null) {
            int currentActionBarHeight = (this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight();
            int measuredHeight = this.fragmentView.getMeasuredHeight();
            if (measuredHeight == 0) {
                return;
            }
            int i = this.locationType;
            if (i != 6 && i == 2) {
                this.overScrollHeight = (measuredHeight - AndroidUtilities.dp(73.0f)) - currentActionBarHeight;
            } else {
                this.overScrollHeight = (measuredHeight - AndroidUtilities.dp(66.0f)) - currentActionBarHeight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.listView.getLayoutParams();
            layoutParams.topMargin = currentActionBarHeight;
            this.listView.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mapViewClip.getLayoutParams();
            layoutParams2.topMargin = currentActionBarHeight;
            layoutParams2.height = this.overScrollHeight;
            this.mapViewClip.setLayoutParams(layoutParams2);
            this.adapter.setOverScrollHeight(this.overScrollHeight);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mapView.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.height = this.overScrollHeight + AndroidUtilities.dp(10.0f);
                this.mapView.setLayoutParams(layoutParams3);
            }
            if (this.overlayView != null) {
                throw null;
            }
            this.adapter.notifyDataSetChanged();
            if (resume) {
                int i2 = this.locationType;
                final int i3 = i2 == 3 ? 73 : (i2 == 1 || i2 == 2) ? 66 : 0;
                this.layoutManager.scrollToPositionWithOffset(0, -AndroidUtilities.dp(i3));
                updateClipView(false);
                this.listView.post(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LocationActivity$OuyU026QH15E9TkS-KPTxEzDepg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$fixLayoutInternal$6$LocationActivity(i3);
                    }
                });
                return;
            }
            updateClipView(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fixLayoutInternal$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fixLayoutInternal$6$LocationActivity(int i) {
        this.layoutManager.scrollToPositionWithOffset(0, -AndroidUtilities.dp(i));
        updateClipView(false);
    }

    public void setMessageObject(MessageObject message) {
        this.messageObject = message;
        this.dialogId = message.getDialogId();
    }

    public void setDialogId(long did) {
        this.dialogId = did;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        MapHelper mapHelper;
        if (id == NotificationCenter.closeChats) {
            removeSelfFromStack();
            return;
        }
        if (id != NotificationCenter.locationPermissionGranted || (mapHelper = this.mapHelper) == null) {
            return;
        }
        try {
            mapHelper.startLocationTracking();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        MapHelper mapHelper = this.mapHelper;
        if (mapHelper != null && this.mapsInitialized) {
            try {
                mapHelper.onPause();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        UndoView[] undoViewArr = this.undoView;
        if (undoViewArr[0] != null) {
            undoViewArr[0].hide(true, 0);
        }
        this.onResumeCalled = false;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView[] undoViewArr = this.undoView;
        if (undoViewArr[0] != null) {
            undoViewArr[0].hide(true, 0);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        Activity parentActivity;
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
        MapHelper mapHelper = this.mapHelper;
        if (mapHelper != null && this.mapsInitialized) {
            try {
                mapHelper.onResume();
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        this.onResumeCalled = true;
        fixLayoutInternal(true);
        if (this.checkPermission && Build.VERSION.SDK_INT >= 23 && (parentActivity = getParentActivity()) != null) {
            this.checkPermission = false;
            if (parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                parentActivity.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2);
            }
        }
        Runnable runnable = this.markAsReadRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            AndroidUtilities.runOnUIThread(this.markAsReadRunnable, 5000L);
        }
    }

    public void setDelegate(LocationActivityDelegate delegate) {
        this.delegate = delegate;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LocationActivity$6B3UPYpp4JaES-MbVb2fQee-UHM
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$7$LocationActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        for (int i = 0; i < this.undoView.length; i++) {
            arrayList.add(new ThemeDescription(this.undoView[i], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "undo_background"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"undoImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_cancelColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"undoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_cancelColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"subinfoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"textPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"progressPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "BODY", "undo_background"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Wibe Big", "undo_background"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Wibe Big 3", "undo_infoColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Wibe Small", "undo_infoColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Body Main.**", "undo_infoColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Body Top.**", "undo_infoColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Line.**", "undo_infoColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Curve Big.**", "undo_infoColor"));
            arrayList.add(new ThemeDescription(this.undoView[i], 0, new Class[]{UndoView.class}, new String[]{"leftImageView"}, "Curve Small.**", "undo_infoColor"));
        }
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, themeDescriptionDelegate, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "dialogButtonSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "chat_messagePanelHint"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuItemIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.emptyImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "dialogEmptyImage"));
        arrayList.add(new ThemeDescription(this.emptyTitleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "dialogEmptyText"));
        arrayList.add(new ThemeDescription(this.emptySubtitleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "dialogEmptyText"));
        arrayList.add(new ThemeDescription(this.shadow, 0, null, null, null, null, "key_sheet_scrollUp"));
        arrayList.add(new ThemeDescription(this.locationButton, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "location_actionIcon"));
        arrayList.add(new ThemeDescription(this.locationButton, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "location_actionActiveIcon"));
        arrayList.add(new ThemeDescription(this.locationButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "location_actionBackground"));
        arrayList.add(new ThemeDescription(this.locationButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "location_actionPressedBackground"));
        arrayList.add(new ThemeDescription(null, 0, null, null, Theme.avatarDrawables, themeDescriptionDelegate, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, null, "location_liveLocationProgress"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, null, "location_placeLocationBackground"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, null, "dialog_liveLocationProgress"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "location_sendLocationIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "location_sendLiveLocationIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "location_sendLocationBackground"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "location_sendLiveLocationBackground"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SendLocationCell.class}, new String[]{"accurateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "location_sendLiveLocationText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SendLocationCell.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "location_sendLocationText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationDirectionCell.class}, new String[]{"buttonTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_buttonText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, new Class[]{LocationDirectionCell.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addButton"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{LocationDirectionCell.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addButtonPressed"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogTextBlue2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{LocationCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationCell.class}, new String[]{"addressTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharingLiveLocationCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharingLiveLocationCell.class}, new String[]{"distanceTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationLoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationLoadingCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationLoadingCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationPoweredCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{LocationPoweredCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogEmptyImage"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LocationPoweredCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogEmptyText"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$7$LocationActivity() {
        this.shadowDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogBackground"), PorterDuff.Mode.MULTIPLY));
        this.shadow.invalidate();
    }
}
