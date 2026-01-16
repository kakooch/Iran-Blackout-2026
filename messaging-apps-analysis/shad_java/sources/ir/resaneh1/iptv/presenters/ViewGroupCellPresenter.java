package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.UIView.UI_MP4PlayerView;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.fragment.DynamicPageFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.CardViewObject;
import ir.resaneh1.iptv.model.ColorObject;
import ir.resaneh1.iptv.model.ImageViewObject;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.LinkViewObject;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MenuOptionObject;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.RequestDataDynamicPage;
import ir.resaneh1.iptv.model.SimpleViewObject;
import ir.resaneh1.iptv.model.SizeObject;
import ir.resaneh1.iptv.model.TextViewObject;
import ir.resaneh1.iptv.model.ViewDataObject;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.model.ViewObjectAttr;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.ArrayViewGroupPresenter;
import ir.resaneh1.iptv.presenters.RecyclerViewListPresenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.Components.BackupImageView;

/* loaded from: classes3.dex */
public class ViewGroupCellPresenter extends AbstractPresenter<ViewDataObject, MyViewHolder> {
    public static int textSize = 13;
    public DynamicPageFragment dynamicPageFragment;
    public int heightPx;
    public boolean isGrid;
    public boolean isInHorizontalView;
    public boolean isMatchWidth;
    public boolean isNeedMargin;
    Context mContext;
    private int maxSizeProgressInDp;
    private int minSizeProgressInDp;
    View.OnClickListener onLinkClickListener;
    View.OnClickListener onObjectAttrClick;
    public float textSizeScale;
    private ViewGroupObject viewGroupObject;
    public int widthPx;

    public enum PlayStateEnum {
        init,
        subscribedAndPause,
        play
    }

    public ViewGroupCellPresenter(Context context, boolean z, ViewGroupObject viewGroupObject) {
        super(context);
        this.textSizeScale = 1.0f;
        this.widthPx = -1;
        this.heightPx = -1;
        this.isGrid = true;
        this.isMatchWidth = false;
        this.maxSizeProgressInDp = 45;
        this.minSizeProgressInDp = 16;
        this.isNeedMargin = false;
        this.onLinkClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Link link;
                try {
                    link = (Link) view.getTag(R.id.viewTag2);
                } catch (Exception unused) {
                    link = null;
                }
                if (link == null || ApplicationLoader.applicationActivity == null) {
                    return;
                }
                new MainClickHandler().onLinkClick(ApplicationLoader.applicationActivity.getLastFragment(), link);
            }
        };
        this.onObjectAttrClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewObjectAttr viewObjectAttr;
                ViewDataObject viewDataObject;
                if (ViewGroupCellPresenter.this.dynamicPageFragment == null) {
                    return;
                }
                MyViewHolder myViewHolder = null;
                try {
                    viewObjectAttr = (ViewObjectAttr) view.getTag(R.id.viewTagObjectAttr);
                } catch (Exception unused) {
                    viewObjectAttr = null;
                }
                try {
                    viewDataObject = (ViewDataObject) view.getTag(R.id.viewTagClickedObject);
                } catch (Exception unused2) {
                    viewDataObject = null;
                }
                try {
                    myViewHolder = (MyViewHolder) view.getTag(R.id.viewTagHolder);
                } catch (Exception unused3) {
                }
                if (myViewHolder == null || viewObjectAttr == null || viewDataObject == null) {
                    return;
                }
                final LoadingObject loadingObject = new LoadingObject();
                ViewObjectAttr.LoadingTypeEnum loadingTypeEnum = viewObjectAttr.loading_type;
                if (loadingTypeEnum == ViewObjectAttr.LoadingTypeEnum.Center) {
                    loadingObject.createLoadingDialog(true, new DialogInterface.OnCancelListener(this) { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.6.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            DisposableObserver disposableObserver = loadingObject.requestDisposable;
                            if (disposableObserver != null) {
                                disposableObserver.dispose();
                            }
                        }
                    });
                } else if (loadingTypeEnum == ViewObjectAttr.LoadingTypeEnum.Inline && myViewHolder.itemNameProgressViewMap.get(viewObjectAttr.itemName) == null) {
                    ViewGroupCellPresenter.this.addProgressViewToMapAndSetObserverIfNeeded(myViewHolder, view, viewObjectAttr, viewDataObject);
                }
                ViewObjectAttr.ClickTypeEnum clickTypeEnum = viewObjectAttr.click_type;
                if (clickTypeEnum != null && clickTypeEnum == ViewObjectAttr.ClickTypeEnum.Menu) {
                    if (viewObjectAttr.menu != null) {
                        ViewGroupCellPresenter.this.showMenu(view, viewObjectAttr, loadingObject);
                    }
                } else {
                    DynamicPageFragment dynamicPageFragment = ViewGroupCellPresenter.this.dynamicPageFragment;
                    if (dynamicPageFragment != null) {
                        dynamicPageFragment.handleObjectAttrClick(viewObjectAttr, viewDataObject, loadingObject);
                    }
                }
            }
        };
        this.mContext = context;
        this.viewGroupObject = viewGroupObject;
        this.isInHorizontalView = z;
        if (viewGroupObject.type == ViewGroupObject.TypeEnum.List) {
            this.isGrid = false;
        }
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onViewRecycled(MyViewHolder myViewHolder) {
        super.onViewRecycled((ViewGroupCellPresenter) myViewHolder);
        if (myViewHolder.disposablePlay != null) {
            myViewHolder.disposablePlay.dispose();
        }
        myViewHolder.playState = PlayStateEnum.init;
        UI_MP4PlayerView uI_MP4PlayerView = myViewHolder.mp4PlayerView;
        if (uI_MP4PlayerView != null) {
            uI_MP4PlayerView.stopPlayer();
        }
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate;
        MyLog.e("ViewGroupCellPresenter", "onCreateViewHolder");
        if (this.viewGroupObject.is_card_view) {
            viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.view_cell_cardview, viewGroup, false);
        } else {
            viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.view_cell, viewGroup, false);
        }
        MyViewHolder myViewHolder = new MyViewHolder(this, viewInflate);
        if ((viewGroup instanceof RecyclerView) && this.viewGroupObject.hasVideo()) {
            MainAdapter mainAdapter = (MainAdapter) ((RecyclerView) viewGroup).getAdapter();
            if (myViewHolder.parentLifecycle == null) {
                myViewHolder.setParentLifeCycleObservable(mainAdapter.getLifecycle());
            }
            myViewHolder.disposableLifeCycle = new CompositeDisposable();
        }
        myViewHolder.itemView.setTag(R.id.viewTag2, viewGroup);
        refreshSize();
        makeViewIfNeeded(myViewHolder);
        setSize(myViewHolder);
        return myViewHolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void setTextDetails(ir.resaneh1.iptv.model.ViewObjectAttr r8, ir.resaneh1.iptv.model.TextViewObject r9, android.widget.TextView r10) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.setTextDetails(ir.resaneh1.iptv.model.ViewObjectAttr, ir.resaneh1.iptv.model.TextViewObject, android.widget.TextView):void");
    }

    void makeViewIfNeeded(MyViewHolder myViewHolder) {
        TextView textView;
        float f;
        CardViewObject.ShadowTypeEnum shadowTypeEnum;
        int iDp;
        if (this.viewGroupObject.toString().equals(myViewHolder.identifier)) {
            return;
        }
        MyLog.e("ViewGroupCellPresenter", "makeViewIfNeeded");
        myViewHolder.identifier = this.viewGroupObject.toString();
        myViewHolder.frameLayout.setTag(myViewHolder);
        ViewGroupObject viewGroupObject = this.viewGroupObject;
        if (viewGroupObject.is_card_view) {
            if (viewGroupObject.card_view == null) {
                viewGroupObject.card_view = new CardViewObject(new ColorObject(255, 255, 255), CardViewObject.ShadowTypeEnum.Small, 0.1f);
            }
            ColorObject colorObject = this.viewGroupObject.card_view.background_color;
            if (colorObject != null) {
                myViewHolder.cardView.setCardBackgroundColor(colorObject.getColor());
            }
            CardViewObject.ShadowObject shadowObject = this.viewGroupObject.card_view.shadow;
            if (shadowObject != null && (shadowTypeEnum = shadowObject.type) != CardViewObject.ShadowTypeEnum.None) {
                if (shadowTypeEnum == CardViewObject.ShadowTypeEnum.Small) {
                    iDp = AndroidUtilities.dp(2.0f);
                } else if (shadowTypeEnum == CardViewObject.ShadowTypeEnum.Medium) {
                    iDp = AndroidUtilities.dp(4.0f);
                } else {
                    if (shadowTypeEnum == CardViewObject.ShadowTypeEnum.Big) {
                        iDp = AndroidUtilities.dp(8.0f);
                    }
                    f = 0.0f;
                    myViewHolder.cardView.setCardElevation(f);
                    myViewHolder.cardView.setRadius(this.viewGroupObject.card_view.corner_size * this.widthPx);
                }
                f = iDp;
                myViewHolder.cardView.setCardElevation(f);
                myViewHolder.cardView.setRadius(this.viewGroupObject.card_view.corner_size * this.widthPx);
            } else {
                f = 0.0f;
                myViewHolder.cardView.setCardElevation(f);
                myViewHolder.cardView.setRadius(this.viewGroupObject.card_view.corner_size * this.widthPx);
            }
        }
        if (this.isMatchWidth || this.isNeedMargin) {
            int iDp2 = AndroidUtilities.dp(this.viewGroupObject.h_space * 100.0f);
            if (myViewHolder.itemView.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) myViewHolder.itemView.getLayoutParams()).setMargins(iDp2, AndroidUtilities.dp(this.viewGroupObject.v_space * 100.0f), iDp2, AndroidUtilities.dp(0.0f));
            }
        } else if (!this.isInHorizontalView && myViewHolder.itemView.getLayoutParams() != null) {
            ((ViewGroup.MarginLayoutParams) myViewHolder.itemView.getLayoutParams()).setMargins(AndroidUtilities.dp(0.0f), AndroidUtilities.dp(this.viewGroupObject.v_space * 100.0f), AndroidUtilities.dp(0.0f), AndroidUtilities.dp(0.0f));
        }
        myViewHolder.frameLayout.removeAllViews();
        myViewHolder.imageViews = new HashMap();
        ArrayList<ImageViewObject> arrayList = this.viewGroupObject.images;
        if (arrayList != null) {
            Iterator<ImageViewObject> it = arrayList.iterator();
            while (it.hasNext()) {
                ImageViewObject next = it.next();
                BackupImageView backupImageView = new BackupImageView(this.mContext);
                myViewHolder.imageViews.put(next.item_name, backupImageView);
                myViewHolder.frameLayout.addView(backupImageView);
                ((FrameLayout.LayoutParams) backupImageView.getLayoutParams()).setMargins(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            }
        }
        myViewHolder.textViews = new HashMap();
        ArrayList<TextViewObject> arrayList2 = this.viewGroupObject.texts;
        if (arrayList2 != null) {
            Iterator<TextViewObject> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                TextViewObject next2 = it2.next();
                if (next2.is_editable && this.dynamicPageFragment != null) {
                    textView = new EditText(this.mContext);
                    textView.setTag(R.id.viewTag_background, textView.getBackground());
                    setEditTextStyle(textView, next2.text_edit_style, next2.text_edit_style_color);
                    textView.setTag(R.id.viewTagKeyListener, textView.getKeyListener());
                    textView.setOnEditorActionListener(new TextView.OnEditorActionListener(this) { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.1
                        @Override // android.widget.TextView.OnEditorActionListener
                        public boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                            if (i != 4 && i != 5) {
                                return false;
                            }
                            AndroidUtilities.hideKeyboard(textView2);
                            return true;
                        }
                    });
                } else {
                    textView = new TextView(this.mContext);
                }
                if (next2.has_placeholder) {
                    textView.setText(next2.placeholder_text + BuildConfig.FLAVOR);
                }
                myViewHolder.textViews.put(next2.item_name, textView);
                setTextDetails(null, next2, textView);
                myViewHolder.frameLayout.addView(textView);
            }
        }
        myViewHolder.linkFrameViews = new HashMap();
        ArrayList<LinkViewObject> arrayList3 = this.viewGroupObject.links;
        if (arrayList3 != null) {
            Iterator<LinkViewObject> it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                LinkViewObject next3 = it3.next();
                FrameLayout frameLayout = new FrameLayout(this.mContext);
                frameLayout.setOnClickListener(this.onLinkClickListener);
                myViewHolder.linkFrameViews.put(next3.item_name, frameLayout);
                myViewHolder.frameLayout.addView(frameLayout);
            }
        }
    }

    private void setEditTextStyle(TextView textView, TextViewObject.StyleEnum styleEnum, ColorObject colorObject) {
        if (styleEnum == null || styleEnum == TextViewObject.StyleEnum.Normal) {
            textView.setBackgroundColor(ApplicationLoader.applicationContext.getResources().getColor(R.color.transparent));
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        if (styleEnum == TextViewObject.StyleEnum.Line) {
            try {
                Drawable drawable = (Drawable) textView.getTag(R.id.viewTag_background);
                if (drawable != null) {
                    textView.setBackground(drawable);
                }
                textView.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(6.0f));
                if (colorObject != null) {
                    textView.getBackground().setColorFilter(colorObject.getColor(), PorterDuff.Mode.SRC_ATOP);
                } else {
                    textView.getBackground().setColorFilter(ApplicationLoader.applicationContext.getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, ViewDataObject viewDataObject) {
        Map<String, FrameLayout> map;
        ArrayList<TextViewObject> arrayList;
        String str;
        TextViewObject.HeightTypeEnum heightTypeEnum;
        CharSequence charSequence;
        ArrayList<ImageViewObject> arrayList2;
        super.onBindViewHolder((ViewGroupCellPresenter) myViewHolder, (MyViewHolder) viewDataObject);
        MyLog.e("ViewGroupCellPresenter", "onBindViewHolder");
        refreshSize();
        makeViewIfNeeded(myViewHolder);
        if (myViewHolder.frameLayout.getLayoutParams().width != this.widthPx || myViewHolder.frameLayout.getLayoutParams().height != this.heightPx) {
            setSize(myViewHolder);
        }
        if (viewDataObject.images == null) {
            viewDataObject.images = new HashMap();
        }
        int i = 4;
        if (viewDataObject.images != null && (arrayList2 = this.viewGroupObject.images) != null) {
            Iterator<ImageViewObject> it = arrayList2.iterator();
            while (it.hasNext()) {
                ImageViewObject next = it.next();
                try {
                    if (myViewHolder.imageViews.containsKey(next.item_name)) {
                        BackupImageView backupImageView = myViewHolder.imageViews.get(next.item_name);
                        if (myViewHolder.itemNameProgressViewMap.get(next.item_name) != null) {
                            myViewHolder.itemNameProgressViewMap.get(next.item_name).setVisibility(i);
                        }
                        if (viewDataObject.images.containsKey(next.item_name)) {
                            ImageViewObject.TypeEnum typeEnum = next.type;
                            if (typeEnum == null) {
                                if (next.has_placeholder) {
                                    GlideHelper.loadForDynamicView(this.mContext, backupImageView, viewDataObject.images.get(next.item_name), R.drawable.transparent, next.placeholder_url);
                                } else {
                                    GlideHelper.loadForDynamicView(this.mContext, backupImageView, viewDataObject.images.get(next.item_name), R.drawable.transparent);
                                }
                            } else if (typeEnum == ImageViewObject.TypeEnum.Circle) {
                                if (next.has_placeholder) {
                                    GlideHelper.loadCircleForDynamicView(this.mContext, backupImageView, viewDataObject.images.get(next.item_name), R.drawable.transparent, next.placeholder_url);
                                } else {
                                    GlideHelper.loadCircleForDynamicView(this.mContext, backupImageView, viewDataObject.images.get(next.item_name), R.drawable.transparent);
                                }
                            } else if (typeEnum == ImageViewObject.TypeEnum.Rectangle) {
                                int i2 = (int) (next.corner * this.widthPx * 2.9f);
                                if (i2 > 0) {
                                    int iPxToDp = DimensionHelper.pxToDp(this.context, i2);
                                    if (next.has_placeholder) {
                                        GlideHelper.loadRoundedCornerForDynamicView(this.mContext, backupImageView, viewDataObject.images.get(next.item_name), iPxToDp, R.drawable.transparent, next.placeholder_url);
                                    } else {
                                        GlideHelper.loadRoundedCornerForDynamicView(this.mContext, backupImageView, viewDataObject.images.get(next.item_name), iPxToDp, R.drawable.transparent);
                                    }
                                } else if (next.has_placeholder) {
                                    GlideHelper.loadForDynamicView(this.mContext, backupImageView, viewDataObject.images.get(next.item_name), R.drawable.transparent, next.placeholder_url);
                                } else {
                                    GlideHelper.loadForDynamicView(this.mContext, backupImageView, viewDataObject.images.get(next.item_name), R.drawable.transparent);
                                }
                            }
                        } else if (next.has_placeholder) {
                            ImageViewObject.TypeEnum typeEnum2 = next.type;
                            if (typeEnum2 == null) {
                                GlideHelper.loadForDynamicView(this.mContext, backupImageView, next.placeholder_url, R.drawable.transparent);
                            } else if (typeEnum2 == ImageViewObject.TypeEnum.Circle) {
                                GlideHelper.loadCircleForDynamicView(this.mContext, backupImageView, next.placeholder_url, R.drawable.transparent);
                            } else if (typeEnum2 == ImageViewObject.TypeEnum.Rectangle) {
                                int i3 = (int) (next.corner * this.widthPx * 2.9f);
                                if (i3 > 0) {
                                    GlideHelper.loadRoundedCornerForDynamicView(this.mContext, backupImageView, next.placeholder_url, DimensionHelper.pxToDp(this.context, i3), R.drawable.transparent);
                                } else {
                                    GlideHelper.loadForDynamicView(this.mContext, backupImageView, next.placeholder_url, R.drawable.transparent);
                                }
                            }
                        } else {
                            GlideHelper.loadForDynamicView(this.context, backupImageView, BuildConfig.FLAVOR, R.drawable.transparent);
                        }
                        Map<String, ViewObjectAttr> map2 = viewDataObject.images_attr;
                        if (map2 != null && map2.containsKey(next.item_name)) {
                            ViewObjectAttr viewObjectAttr = viewDataObject.images_attr.get(next.item_name);
                            viewObjectAttr.itemName = next.item_name;
                            backupImageView.setTag(R.id.viewTagObjectAttr, viewObjectAttr);
                            backupImageView.setTag(R.id.viewTagClickedObject, viewDataObject);
                            backupImageView.setTag(R.id.viewTagHolder, myViewHolder);
                            backupImageView.setOnClickListener(this.onObjectAttrClick);
                            if (viewObjectAttr.isLoading && viewObjectAttr.loading_type == ViewObjectAttr.LoadingTypeEnum.Inline) {
                                addProgressViewToMapAndSetObserverIfNeeded(myViewHolder, backupImageView, viewObjectAttr, (ViewDataObject) myViewHolder.item);
                                myViewHolder.itemNameProgressViewMap.get(viewObjectAttr.itemName).setVisibility(0);
                            }
                            if (viewObjectAttr.is_hide) {
                                backupImageView.setVisibility(8);
                            } else {
                                backupImageView.setVisibility(0);
                            }
                        } else {
                            backupImageView.setTag(R.id.viewTagObjectAttr, null);
                            backupImageView.setTag(R.id.viewTagClickedObject, null);
                            backupImageView.setTag(R.id.viewTagHolder, null);
                            backupImageView.setOnClickListener(null);
                            backupImageView.setVisibility(0);
                        }
                    }
                } catch (Exception unused) {
                }
                i = 4;
            }
        }
        if (this.viewGroupObject.hasVideo() && ((ViewDataObject) myViewHolder.item).hasVideo()) {
            subscribeToPlay(myViewHolder);
        } else {
            UI_MP4PlayerView uI_MP4PlayerView = myViewHolder.mp4PlayerView;
            if (uI_MP4PlayerView != null) {
                uI_MP4PlayerView.stopPlayer();
                PlayerView playerView = myViewHolder.mp4PlayerView.exoPlayerView;
                if (playerView != null) {
                    playerView.setVisibility(4);
                }
            }
        }
        if (viewDataObject.texts != null && (arrayList = this.viewGroupObject.texts) != null) {
            Iterator<TextViewObject> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                TextViewObject next2 = it2.next();
                if (myViewHolder.textViews.containsKey(next2.item_name)) {
                    if (myViewHolder.itemNameProgressViewMap.get(next2.item_name) != null) {
                        myViewHolder.itemNameProgressViewMap.get(next2.item_name).setVisibility(4);
                    }
                    if (myViewHolder.editTextChangeDisposableMap.get(next2.item_name) != null) {
                        myViewHolder.editTextChangeDisposableMap.get(next2.item_name).dispose();
                    }
                    if (myViewHolder.requestTextChangeDisposableMap.get(next2.item_name) != null) {
                        myViewHolder.requestTextChangeDisposableMap.get(next2.item_name).dispose();
                    }
                    TextView textView = myViewHolder.textViews.get(next2.item_name);
                    textView.setHint(BuildConfig.FLAVOR);
                    Map<String, ViewObjectAttr> map3 = viewDataObject.texts_attr;
                    if (map3 != null && map3.containsKey(next2.item_name)) {
                        ViewObjectAttr viewObjectAttr2 = viewDataObject.texts_attr.get(next2.item_name);
                        viewObjectAttr2.itemName = next2.item_name;
                        if (next2.is_editable && !viewObjectAttr2.text_edit_read_only) {
                            textView.setTag(R.id.viewTagObjectAttr, null);
                            textView.setTag(R.id.viewTagClickedObject, null);
                            textView.setOnClickListener(null);
                        } else {
                            textView.setTag(R.id.viewTagObjectAttr, viewObjectAttr2);
                            textView.setTag(R.id.viewTagHolder, myViewHolder);
                            textView.setTag(R.id.viewTagClickedObject, viewDataObject);
                            textView.setOnClickListener(this.onObjectAttrClick);
                            if (viewObjectAttr2.isLoading && viewObjectAttr2.loading_type == ViewObjectAttr.LoadingTypeEnum.Inline) {
                                addProgressViewToMapAndSetObserverIfNeeded(myViewHolder, textView, viewObjectAttr2, (ViewDataObject) myViewHolder.item);
                                myViewHolder.itemNameProgressViewMap.get(viewObjectAttr2.itemName).setVisibility(0);
                            }
                        }
                        if (next2.is_editable && viewObjectAttr2.text_edit_read_only) {
                            textView.setKeyListener(null);
                        } else if (textView.getTag(R.id.viewTagKeyListener) != null && (textView.getTag(R.id.viewTagKeyListener) instanceof KeyListener)) {
                            textView.setKeyListener((KeyListener) textView.getTag(R.id.viewTagKeyListener));
                        }
                        if (next2.is_editable && (charSequence = viewObjectAttr2.text_edit_hint) != null) {
                            textView.setHint(charSequence);
                        } else {
                            textView.setHint(BuildConfig.FLAVOR);
                        }
                        if (next2.is_editable && (textView instanceof EditText) && viewObjectAttr2.text_edit_change_delay > 0) {
                            setupRxListener(myViewHolder, next2.item_name, (EditText) textView, viewObjectAttr2);
                        }
                        if (viewObjectAttr2.is_hide) {
                            textView.setVisibility(8);
                        } else {
                            textView.setVisibility(0);
                        }
                        setTextDetails(viewObjectAttr2, next2, textView);
                    } else {
                        textView.setTag(R.id.viewTagObjectAttr, null);
                        textView.setTag(R.id.viewTagClickedObject, null);
                        textView.setOnClickListener(null);
                        setTextDetails(null, next2, textView);
                        textView.setVisibility(0);
                        if (textView.getTag(R.id.viewTagKeyListener) != null && (textView.getTag(R.id.viewTagKeyListener) instanceof KeyListener)) {
                            textView.setKeyListener((KeyListener) textView.getTag(R.id.viewTagKeyListener));
                        }
                        textView.setHint(BuildConfig.FLAVOR);
                    }
                    if (viewDataObject.texts.containsKey(next2.item_name)) {
                        str = viewDataObject.texts.get(next2.item_name);
                    } else {
                        str = next2.has_placeholder ? next2.placeholder_text : BuildConfig.FLAVOR;
                    }
                    textView.setText(str);
                    if (this.dynamicPageFragment != null && (heightTypeEnum = next2.height_type) != null && heightTypeEnum != TextViewObject.HeightTypeEnum.Fix) {
                        setHeightByType(next2, textView, str);
                    }
                }
            }
        }
        if (viewDataObject.links == null || (map = myViewHolder.linkFrameViews) == null) {
            return;
        }
        for (String str2 : map.keySet()) {
            FrameLayout frameLayout = myViewHolder.linkFrameViews.get(str2);
            if (myViewHolder.itemNameProgressViewMap.get(str2) != null) {
                myViewHolder.itemNameProgressViewMap.get(str2).setVisibility(4);
            }
            if (viewDataObject.links.containsKey(str2)) {
                frameLayout.setTag(R.id.viewTag2, viewDataObject.links.get(str2));
            } else {
                frameLayout.setTag(R.id.viewTag2, null);
            }
            Map<String, ViewObjectAttr> map4 = viewDataObject.links_attr;
            if (map4 != null && map4.containsKey(str2)) {
                ViewObjectAttr viewObjectAttr3 = viewDataObject.links_attr.get(str2);
                viewObjectAttr3.itemName = str2;
                frameLayout.setTag(R.id.viewTagObjectAttr, viewObjectAttr3);
                frameLayout.setTag(R.id.viewTagClickedObject, viewDataObject);
                frameLayout.setTag(R.id.viewTagHolder, myViewHolder);
                if (viewObjectAttr3.click_type != ViewObjectAttr.ClickTypeEnum.None) {
                    frameLayout.setOnClickListener(this.onObjectAttrClick);
                } else {
                    frameLayout.setOnClickListener(this.onLinkClickListener);
                }
                if (viewObjectAttr3.isLoading && viewObjectAttr3.loading_type == ViewObjectAttr.LoadingTypeEnum.Inline) {
                    addProgressViewToMapAndSetObserverIfNeeded(myViewHolder, frameLayout, viewObjectAttr3, (ViewDataObject) myViewHolder.item);
                    myViewHolder.itemNameProgressViewMap.get(viewObjectAttr3.itemName).setVisibility(0);
                }
                if (viewObjectAttr3.is_hide) {
                    frameLayout.setVisibility(8);
                } else {
                    frameLayout.setVisibility(0);
                }
            } else {
                frameLayout.setTag(R.id.viewTagObjectAttr, null);
                frameLayout.setTag(R.id.viewTagClickedObject, null);
                frameLayout.setTag(R.id.viewTagHolder, null);
                frameLayout.setOnClickListener(this.onLinkClickListener);
                frameLayout.setVisibility(0);
            }
        }
    }

    private void refreshSize() {
        if (this.isMatchWidth) {
            int screenWidth = DimensionHelper.getScreenWidth((Activity) this.mContext) - (AndroidUtilities.dp(this.viewGroupObject.h_space * 100.0f) * 2);
            this.widthPx = screenWidth;
            SizeObject sizeObject = this.viewGroupObject.size;
            if (sizeObject != null) {
                this.heightPx = (int) (sizeObject.getHWRatio() * this.widthPx);
                return;
            } else {
                this.heightPx = screenWidth;
                return;
            }
        }
        if (this.widthPx < 0) {
            this.widthPx = this.viewGroupObject.size.getWidthPx();
        }
        if (this.heightPx < 0) {
            this.heightPx = this.viewGroupObject.size.getHeightPx();
        }
    }

    public void setSize(MyViewHolder myViewHolder) {
        int screenWidth;
        if (this.isGrid) {
            screenWidth = this.widthPx;
        } else {
            screenWidth = DimensionHelper.getScreenWidth((Activity) this.mContext) - (AndroidUtilities.dp(this.viewGroupObject.h_space * 100.0f) * 2);
        }
        myViewHolder.frameLayout.getLayoutParams().width = screenWidth;
        ViewGroup.LayoutParams layoutParams = myViewHolder.frameLayout.getLayoutParams();
        int i = this.heightPx;
        layoutParams.height = i;
        boolean z = false;
        if (i != this.viewGroupObject.size.getHeightPx()) {
            float fPxToDp = DimensionHelper.pxToDp(this.context, this.heightPx) / DimensionHelper.pxToDp(this.context, this.viewGroupObject.size.getHeightPx());
            if (fPxToDp > 1.0f) {
                this.textSizeScale = fPxToDp;
                z = true;
            } else {
                this.textSizeScale = 1.0f;
            }
            MyLog.e("ViewGroupCellPresenter", "scale " + fPxToDp);
        }
        ArrayList<ImageViewObject> arrayList = this.viewGroupObject.images;
        if (arrayList != null) {
            Iterator<ImageViewObject> it = arrayList.iterator();
            while (it.hasNext()) {
                SimpleViewObject simpleViewObject = (ImageViewObject) it.next();
                if (myViewHolder.imageViews.containsKey(simpleViewObject.item_name)) {
                    setSizeAndPosition(simpleViewObject, myViewHolder.imageViews.get(simpleViewObject.item_name), this.widthPx);
                }
            }
        }
        ArrayList<TextViewObject> arrayList2 = this.viewGroupObject.texts;
        if (arrayList2 != null) {
            Iterator<TextViewObject> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                TextViewObject next = it2.next();
                if (myViewHolder.textViews.containsKey(next.item_name)) {
                    TextView textView = myViewHolder.textViews.get(next.item_name);
                    if (z) {
                        if (next.font == 0.0f) {
                            next.font = 1.0f;
                        }
                        textView.setTextSize(1, next.font * textSize * this.textSizeScale);
                    }
                    setSizeAndPosition(next, textView, this.widthPx);
                }
            }
        }
        ArrayList<LinkViewObject> arrayList3 = this.viewGroupObject.links;
        if (arrayList3 != null) {
            Iterator<LinkViewObject> it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                SimpleViewObject simpleViewObject2 = (LinkViewObject) it3.next();
                if (myViewHolder.linkFrameViews.containsKey(simpleViewObject2.item_name)) {
                    setSizeAndPosition(simpleViewObject2, myViewHolder.linkFrameViews.get(simpleViewObject2.item_name), this.widthPx);
                }
            }
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<ViewDataObject> {
        public CardView cardView;
        CompositeDisposable compositeDisposable;
        public PresenterFragment.LifeCycleState currentState;
        private Disposable disposableLifeCycle;
        private Disposable disposablePlay;
        Map<String, Disposable> editTextChangeDisposableMap;
        FrameLayout frameLayout;
        public String identifier;
        Map<String, BackupImageView> imageViews;
        Map<String, FrameLayout> itemNameProgressViewMap;
        Map<String, FrameLayout> linkFrameViews;
        public UI_MP4PlayerView mp4PlayerView;
        private BehaviorSubject<PresenterFragment.LifeCycleState> parentLifecycle;
        public PlayStateEnum playState;
        Map<String, Disposable> requestTextChangeDisposableMap;
        Map<String, TextView> textViews;

        public MyViewHolder(ViewGroupCellPresenter viewGroupCellPresenter, View view) {
            super(view);
            this.identifier = "asdas";
            this.playState = PlayStateEnum.init;
            this.frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
            this.cardView = (CardView) view.findViewById(R.id.cardView);
            this.compositeDisposable = new CompositeDisposable();
            this.editTextChangeDisposableMap = new HashMap();
            this.requestTextChangeDisposableMap = new HashMap();
            this.itemNameProgressViewMap = new HashMap();
        }

        public void setParentLifeCycleObservable(BehaviorSubject<PresenterFragment.LifeCycleState> behaviorSubject) {
            this.parentLifecycle = behaviorSubject;
        }
    }

    public void setSizeAndPositionForGrid(SimpleViewObject simpleViewObject, View view, float f) {
        float fChangeAndGetScaleSizeByWidthPx = this.viewGroupObject.size.changeAndGetScaleSizeByWidthPx(f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AndroidUtilities.dp((simpleViewObject.x2 - simpleViewObject.x1) * fChangeAndGetScaleSizeByWidthPx), AndroidUtilities.dp((simpleViewObject.y2 - simpleViewObject.y1) * fChangeAndGetScaleSizeByWidthPx));
        float fDp = AndroidUtilities.dp(simpleViewObject.y1 * fChangeAndGetScaleSizeByWidthPx);
        float fDp2 = AndroidUtilities.dp(simpleViewObject.x1 * fChangeAndGetScaleSizeByWidthPx);
        layoutParams.gravity = 53;
        layoutParams.setMargins(0, (int) fDp, (int) fDp2, 0);
        view.setLayoutParams(layoutParams);
    }

    public void setHeightByType(TextViewObject textViewObject, TextView textView, String str) {
        View view;
        final RecyclerViewListPresenter.MyViewHolder myViewHolder;
        int i;
        View view2;
        MyLog.e("ViewGroupCellPresenter", "setHeightByType");
        try {
            if (textView instanceof EditText) {
                if (this.isInHorizontalView) {
                    return;
                }
                TextViewObject.HeightTypeEnum heightTypeEnum = textViewObject.height_type;
                if (heightTypeEnum == TextViewObject.HeightTypeEnum.DynamicTextView || heightTypeEnum == TextViewObject.HeightTypeEnum.DynamicView) {
                    ((FrameLayout.LayoutParams) textView.getLayoutParams()).height = -2;
                    if (textViewObject.dynamic_height_bottom_space > 0.0f) {
                        try {
                            ((FrameLayout.LayoutParams) textView.getLayoutParams()).bottomMargin = AndroidUtilities.dp((int) (r10 * 100.0f));
                        } catch (Exception unused) {
                        }
                    }
                    if (textViewObject.height_type != TextViewObject.HeightTypeEnum.DynamicView || (view2 = (View) textView.getParent()) == null) {
                        return;
                    }
                    view2.setMinimumHeight(view2.getLayoutParams().height);
                    view2.getLayoutParams().height = -2;
                    View view3 = (View) view2.getParent();
                    view3.getLayoutParams().height = -2;
                    view3.invalidate();
                    View view4 = (View) view3.getParent();
                    if (view4 == null) {
                        view4 = (View) view3.getTag(R.id.viewTag2);
                    }
                    if (view4 == null || !(view4.getTag() instanceof ArrayViewGroupPresenter.MyViewHolder)) {
                        return;
                    }
                    ArrayViewGroupPresenter.MyViewHolder myViewHolder2 = (ArrayViewGroupPresenter.MyViewHolder) view4.getTag();
                    myViewHolder2.itemView.getLayoutParams().height = -2;
                    myViewHolder2.frameLayout.getLayoutParams().height = -2;
                    myViewHolder2.frameLayout.invalidate();
                    myViewHolder2.itemView.invalidate();
                    return;
                }
                return;
            }
            TextViewObject.HeightTypeEnum heightTypeEnum2 = textViewObject.height_type;
            if ((heightTypeEnum2 == TextViewObject.HeightTypeEnum.DynamicTextView || heightTypeEnum2 == TextViewObject.HeightTypeEnum.DynamicView) && str != null) {
                int textHeight = DimensionHelper.getTextHeight(str, textView);
                int i2 = textView.getLayoutParams().height;
                MyLog.e("ViewGroupCellPresenter", "setHeightByType heightNew" + textHeight);
                textView.getLayoutParams().height = textHeight;
                if (textViewObject.dynamic_height_bottom_space > 0.0f) {
                    try {
                        ((FrameLayout.LayoutParams) textView.getLayoutParams()).bottomMargin = AndroidUtilities.dp((int) (r1 * 100.0f));
                    } catch (Exception unused2) {
                    }
                }
                TextViewObject.HeightTypeEnum heightTypeEnum3 = textViewObject.height_type;
                if (heightTypeEnum3 == TextViewObject.HeightTypeEnum.DynamicTextView) {
                    int i3 = ((((FrameLayout.LayoutParams) textView.getLayoutParams()).topMargin + textHeight) + ((FrameLayout.LayoutParams) textView.getLayoutParams()).bottomMargin) - ((View) textView.getParent()).getLayoutParams().height;
                    if (i3 <= 0 || (i = textHeight - i3) <= 0) {
                        return;
                    }
                    textView.getLayoutParams().height = i;
                    return;
                }
                if (heightTypeEnum3 == TextViewObject.HeightTypeEnum.DynamicView) {
                    MyLog.e("ViewGroupCellPresenter", "setHeightByType dynamicView");
                    View view5 = (View) textView.getParent();
                    int i4 = view5.getLayoutParams().height;
                    int i5 = ((FrameLayout.LayoutParams) textView.getLayoutParams()).topMargin;
                    int i6 = ((FrameLayout.LayoutParams) textView.getLayoutParams()).bottomMargin;
                    if (Build.VERSION.SDK_INT < 21 && (((ViewGroup) view5.getParent()) instanceof CardView)) {
                        textHeight = (int) (textHeight + (((CardView) view5.getParent()).getRadius() * 2.0f));
                    }
                    int i7 = i5 + textHeight + i6;
                    if (i7 - i4 > 0) {
                        MyLog.e("ViewGroupCellPresenter", "setHeightByType diff>0");
                        view5.getLayoutParams().height = i7;
                        view5.invalidate();
                        View view6 = (View) view5.getParent();
                        view6.getLayoutParams().height = i7;
                        view6.invalidate();
                        View view7 = (View) view6.getParent();
                        if (view7 == null) {
                            view7 = (View) view6.getTag(R.id.viewTag2);
                        }
                        if (view7 != null) {
                            if (view7.getTag() instanceof ArrayViewGroupPresenter.MyViewHolder) {
                                ArrayViewGroupPresenter.MyViewHolder myViewHolder3 = (ArrayViewGroupPresenter.MyViewHolder) view7.getTag();
                                int i8 = myViewHolder3.itemView.getLayoutParams().height;
                                int iDp = i7 + AndroidUtilities.dp(myViewHolder3.viewGroupObject.v_space * 100.0f);
                                if (i8 < iDp) {
                                    myViewHolder3.itemView.getLayoutParams().height = iDp;
                                    myViewHolder3.frameLayout.getLayoutParams().height = iDp;
                                    return;
                                }
                                return;
                            }
                            if (!(view7 instanceof RecyclerView) || (view = (View) view7.getParent()) == null || !(view instanceof FrameLayout) || (myViewHolder = (RecyclerViewListPresenter.MyViewHolder) view.getTag()) == null) {
                                return;
                            }
                            Titem titem = myViewHolder.item;
                            float f = ((RecyclerViewListObject) titem).listInput.itemType == ListInput.ItemType.viewTag ? 8.0f + (((RecyclerViewListObject) titem).listInput.viewTagObject.view.row_space * 100.0f) : 8.0f;
                            int paddingTop = myViewHolder.recyclerView.getPaddingTop();
                            int i9 = myViewHolder.recyclerView.getLayoutParams().height;
                            int iDp2 = AndroidUtilities.dp(f) + i7 + paddingTop;
                            MyLog.e("ViewGroupCellPresenter", "setHeightByType old new" + i9 + " " + iDp2);
                            if (i9 < iDp2) {
                                MyLog.e("ViewGroupCellPresenter", "setHeightByType invalidate");
                                ((RecyclerViewListObject) myViewHolder.item).itemHeight = i7;
                                myViewHolder.recyclerView.getLayoutParams().height = iDp2;
                                new Handler().postDelayed(new Runnable(this) { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        myViewHolder.itemView.invalidate();
                                        myViewHolder.itemView.requestLayout();
                                    }
                                }, 100L);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused3) {
        }
    }

    public void setSizeAndPositionForRow(SimpleViewObject simpleViewObject, View view, float f) {
        float f2;
        float fChangeAndGetScaleSizeByWidthPx = this.viewGroupObject.size.changeAndGetScaleSizeByWidthPx(f);
        int iDp = AndroidUtilities.dp((simpleViewObject.x2 - simpleViewObject.x1) * fChangeAndGetScaleSizeByWidthPx);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDp, AndroidUtilities.dp((simpleViewObject.y2 - simpleViewObject.y1) * fChangeAndGetScaleSizeByWidthPx));
        float fDp = AndroidUtilities.dp(simpleViewObject.y1 * fChangeAndGetScaleSizeByWidthPx);
        float fDp2 = AndroidUtilities.dp(simpleViewObject.x1 * fChangeAndGetScaleSizeByWidthPx);
        int screenWidth = DimensionHelper.getScreenWidth((Activity) this.mContext) - (AndroidUtilities.dp(this.viewGroupObject.h_space * 100.0f) * 2);
        if (this.viewGroupObject.size != null) {
            float widthPx = screenWidth / r4.getWidthPx();
            float widthPx2 = this.viewGroupObject.size.getWidthPx();
            float f3 = widthPx * widthPx2;
            SimpleViewObject.AlignTypeEnum alignTypeEnum = simpleViewObject.align_type;
            if (alignTypeEnum != null && alignTypeEnum != SimpleViewObject.AlignTypeEnum.None && alignTypeEnum != SimpleViewObject.AlignTypeEnum.Right) {
                if (alignTypeEnum == SimpleViewObject.AlignTypeEnum.Middle) {
                    f2 = (f3 - widthPx2) / 2.0f;
                } else if (alignTypeEnum == SimpleViewObject.AlignTypeEnum.Left) {
                    f2 = f3 - widthPx2;
                } else if (alignTypeEnum == SimpleViewObject.AlignTypeEnum.Span) {
                    layoutParams.width = (int) (f3 - (widthPx2 - iDp));
                }
                fDp2 += f2;
            }
        }
        layoutParams.gravity = 53;
        layoutParams.setMargins(0, (int) fDp, (int) fDp2, 0);
        view.setLayoutParams(layoutParams);
    }

    public void setSizeAndPosition(SimpleViewObject simpleViewObject, View view, float f) {
        if (this.isGrid) {
            setSizeAndPositionForGrid(simpleViewObject, view, f);
        } else {
            setSizeAndPositionForRow(simpleViewObject, view, f);
        }
    }

    public void setPlayerIfNeeded(MyViewHolder myViewHolder) {
        if (myViewHolder.mp4PlayerView == null) {
            UI_MP4PlayerView uI_MP4PlayerView = new UI_MP4PlayerView();
            myViewHolder.mp4PlayerView = uI_MP4PlayerView;
            uI_MP4PlayerView.createView((Activity) this.context);
            myViewHolder.frameLayout.addView(myViewHolder.mp4PlayerView.exoPlayerView);
            setLifeCycleObserverIfNeeded(myViewHolder);
        }
    }

    private void setLifeCycleObserverIfNeeded(final MyViewHolder myViewHolder) {
        if (myViewHolder.parentLifecycle == null || myViewHolder.disposableLifeCycle != null) {
            return;
        }
        myViewHolder.disposableLifeCycle = (Disposable) myViewHolder.parentLifecycle.subscribeWith(new DisposableObserver<PresenterFragment.LifeCycleState>() { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.4
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(PresenterFragment.LifeCycleState lifeCycleState) {
                MyLog.e("ViewGroupCellPresenter", lifeCycleState.name());
                MyViewHolder myViewHolder2 = myViewHolder;
                myViewHolder2.currentState = lifeCycleState;
                if (lifeCycleState == PresenterFragment.LifeCycleState.resume) {
                    if (ViewGroupCellPresenter.this.viewGroupObject.hasVideo() && ((ViewDataObject) myViewHolder.item).hasVideo()) {
                        MyViewHolder myViewHolder3 = myViewHolder;
                        if (myViewHolder3.playState == PlayStateEnum.init) {
                            ViewGroupCellPresenter.this.subscribeToPlay(myViewHolder3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (lifeCycleState == PresenterFragment.LifeCycleState.pause) {
                    myViewHolder2.playState = PlayStateEnum.init;
                    if (myViewHolder2.disposablePlay != null) {
                        myViewHolder.disposablePlay.dispose();
                    }
                    UI_MP4PlayerView uI_MP4PlayerView = myViewHolder.mp4PlayerView;
                    if (uI_MP4PlayerView != null) {
                        uI_MP4PlayerView.stopPlayer();
                        return;
                    }
                    return;
                }
                if (lifeCycleState == PresenterFragment.LifeCycleState.destroy || lifeCycleState == PresenterFragment.LifeCycleState.lowMemory) {
                    UI_MP4PlayerView uI_MP4PlayerView2 = myViewHolder2.mp4PlayerView;
                    if (uI_MP4PlayerView2 != null) {
                        uI_MP4PlayerView2.stopAndReleasePlayer();
                    }
                    if (myViewHolder.disposableLifeCycle != null) {
                        myViewHolder.disposableLifeCycle.dispose();
                    }
                    if (myViewHolder.disposablePlay != null) {
                        myViewHolder.disposablePlay.dispose();
                    }
                    CompositeDisposable compositeDisposable = myViewHolder.compositeDisposable;
                    if (compositeDisposable != null) {
                        compositeDisposable.dispose();
                    }
                }
            }
        });
    }

    public void play(MyViewHolder myViewHolder) {
        setPlayerIfNeeded(myViewHolder);
        if (myViewHolder.currentState == PresenterFragment.LifeCycleState.resume) {
            PlayStateEnum playStateEnum = myViewHolder.playState;
            PlayStateEnum playStateEnum2 = PlayStateEnum.play;
            if (playStateEnum == playStateEnum2) {
                return;
            }
            if (((ViewDataObject) myViewHolder.item).hasVideo()) {
                myViewHolder.playState = playStateEnum2;
                myViewHolder.mp4PlayerView.playMP4(((ViewDataObject) myViewHolder.item).url);
            } else {
                myViewHolder.mp4PlayerView.stopPlayer();
                myViewHolder.playState = PlayStateEnum.subscribedAndPause;
            }
        }
    }

    public void subscribeToPlay(final MyViewHolder myViewHolder) {
        if (myViewHolder.disposablePlay != null) {
            myViewHolder.disposablePlay.dispose();
        }
        myViewHolder.playState = PlayStateEnum.subscribedAndPause;
        myViewHolder.disposablePlay = (Disposable) Observable.timer(300L, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.5
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                MyViewHolder myViewHolder2 = myViewHolder;
                if (myViewHolder2.playState != PlayStateEnum.play) {
                    ViewGroupCellPresenter.this.play(myViewHolder2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProgressViewToMapAndSetObserverIfNeeded(final MyViewHolder myViewHolder, View view, final ViewObjectAttr viewObjectAttr, final ViewDataObject viewDataObject) {
        FrameLayout frameLayoutAddProgressContainerToView;
        Observable observableCreate = Observable.create(new ObservableOnSubscribe<Boolean>(this) { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.7
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                MyLog.e("ViewGroupCellPresenter", "subscribe");
                viewDataObject.progressViewDisposableMap.put(viewObjectAttr.itemName, observableEmitter);
            }
        });
        MyLog.e("ViewGroupCellPresenter", "holder" + ((ViewDataObject) myViewHolder.item).object_data_id + " " + viewDataObject.object_data_id);
        myViewHolder.compositeDisposable.add((Disposable) observableCreate.observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Boolean>(this) { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.8
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Boolean bool) {
                viewObjectAttr.isLoading = bool.booleanValue();
                Titem titem = myViewHolder.item;
                if (((ViewDataObject) titem).object_data_id != null && ((ViewDataObject) titem).object_data_id.equals(viewDataObject.object_data_id)) {
                    if (bool.booleanValue()) {
                        myViewHolder.itemNameProgressViewMap.get(viewObjectAttr.itemName).setVisibility(0);
                    } else {
                        myViewHolder.itemNameProgressViewMap.get(viewObjectAttr.itemName).setVisibility(4);
                    }
                }
                MyLog.e("ViewGroupCellPresenter", bool + BuildConfig.FLAVOR + ((ViewDataObject) myViewHolder.item).object_data_id + " " + viewDataObject.object_data_id);
            }
        }));
        if (myViewHolder.itemNameProgressViewMap.get(viewObjectAttr.itemName) != null || (frameLayoutAddProgressContainerToView = addProgressContainerToView(view)) == null) {
            return;
        }
        myViewHolder.itemNameProgressViewMap.put(viewObjectAttr.itemName, frameLayoutAddProgressContainerToView);
    }

    public void showMenu(View view, final ViewObjectAttr viewObjectAttr, final LoadingObject loadingObject) {
        final ArrayList<MenuOptionObject> arrayList = viewObjectAttr.menu;
        PopupMenu popupMenu = new PopupMenu(this.context, view, 0, R.attr.actionOverflowMenuStyle, 0);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        popupMenu.getMenuInflater().inflate(R.menu.dynamic_view, popupMenu.getMenu());
        popupMenu.setGravity(17);
        Iterator<MenuOptionObject> it = arrayList.iterator();
        while (it.hasNext()) {
            MenuOptionObject next = it.next();
            popupMenu.getMenu().add(1, arrayList.indexOf(next), arrayList.indexOf(next), next.text);
        }
        final ViewDataObject viewDataObject = (ViewDataObject) view.getTag(R.id.viewTagClickedObject);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.9
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId < 0 || itemId >= arrayList.size()) {
                    return true;
                }
                MenuOptionObject menuOptionObject = (MenuOptionObject) arrayList.get(menuItem.getItemId());
                DynamicPageFragment dynamicPageFragment = ViewGroupCellPresenter.this.dynamicPageFragment;
                if (dynamicPageFragment == null) {
                    return true;
                }
                dynamicPageFragment.handleMenuClick(viewObjectAttr, menuOptionObject.track_id, viewDataObject, loadingObject);
                return true;
            }
        });
        popupMenu.show();
    }

    public static class LoadingObject {
        public LoadingDialog loadingDialog;
        public DisposableObserver requestDisposable;

        public void createLoadingDialog(boolean z, DialogInterface.OnCancelListener onCancelListener) {
            LoadingDialog loadingDialog = new LoadingDialog(ApplicationLoader.applicationActivity);
            this.loadingDialog = loadingDialog;
            loadingDialog.setCancelable(z);
            if (onCancelListener != null) {
                this.loadingDialog.setOnCancelListener(onCancelListener);
            }
            hideLoading();
        }

        public void showLoading() {
            LoadingDialog loadingDialog = this.loadingDialog;
            if (loadingDialog != null) {
                loadingDialog.show();
            }
        }

        public void hideLoading() {
            LoadingDialog loadingDialog = this.loadingDialog;
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
            DisposableObserver disposableObserver = this.requestDisposable;
            if (disposableObserver != null) {
                disposableObserver.dispose();
                this.requestDisposable = null;
            }
        }
    }

    public FrameLayout addProgressContainerToView(View view) {
        int iPxToDp = DimensionHelper.pxToDp(this.mContext, Math.min(view.getWidth(), view.getHeight()));
        int i = this.maxSizeProgressInDp;
        if (iPxToDp > i) {
            iPxToDp = i;
        }
        int i2 = this.minSizeProgressInDp;
        if (iPxToDp < i2) {
            iPxToDp = i2;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                int iIndexOfChild = viewGroup.indexOfChild(view);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                FrameLayout frameLayout = new FrameLayout(ApplicationLoader.applicationActivity);
                frameLayout.setLayoutParams(layoutParams);
                viewGroup.addView(frameLayout, iIndexOfChild + 1);
                UIProgressBarNewStyle.addToFrame(ApplicationLoader.applicationActivity, frameLayout, iPxToDp);
                frameLayout.setVisibility(4);
                return frameLayout;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private void setupRxListener(final MyViewHolder myViewHolder, final String str, EditText editText, final ViewObjectAttr viewObjectAttr) {
        setLifeCycleObserverIfNeeded(myViewHolder);
        if (myViewHolder.editTextChangeDisposableMap.get(str) != null) {
            myViewHolder.editTextChangeDisposableMap.get(str).dispose();
        }
        Disposable disposableSubscribe = RxTextView.textChanges(editText).skip(2L).map(new Function<CharSequence, Object>(this) { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter.10
            @Override // io.reactivex.functions.Function
            public Object apply(CharSequence charSequence) throws Exception {
                return charSequence.toString().toLowerCase();
            }
        }).debounce(viewObjectAttr.text_edit_change_delay, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: ir.resaneh1.iptv.presenters.ViewGroupCellPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$setupRxListener$0(myViewHolder, str, viewObjectAttr, obj);
            }
        });
        myViewHolder.editTextChangeDisposableMap.put(str, disposableSubscribe);
        myViewHolder.compositeDisposable.add(disposableSubscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupRxListener$0(MyViewHolder myViewHolder, String str, ViewObjectAttr viewObjectAttr, Object obj) throws Exception {
        try {
            ((ViewDataObject) myViewHolder.item).texts.put(str, obj.toString());
        } catch (Exception unused) {
        }
        if (myViewHolder.requestTextChangeDisposableMap.get(str) != null) {
            myViewHolder.requestTextChangeDisposableMap.get(str).dispose();
        }
        DynamicPageFragment dynamicPageFragment = this.dynamicPageFragment;
        if (dynamicPageFragment != null) {
            String str2 = dynamicPageFragment.getDataUrl;
        }
        RequestDataDynamicPage requestDataDynamicPage = new RequestDataDynamicPage(viewObjectAttr.track_id);
        requestDataDynamicPage.setForTextEdit(obj.toString());
        DynamicPageFragment dynamicPageFragment2 = this.dynamicPageFragment;
        if (dynamicPageFragment2 != null) {
            dynamicPageFragment2.handleSendData(requestDataDynamicPage, viewObjectAttr, null, (ViewDataObject) myViewHolder.item, null);
        }
    }
}
