package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.RtlGridLayoutManager;
import ir.resaneh1.iptv.model.GalleryResultObject;
import ir.resaneh1.iptv.model.RubinoGalleryObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.RubinoGalleryCellPresenter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class StoryGalleryFragment extends PresenterFragment {
    private static int requestCode = 1033;
    private DisposableObserver loadDataObservable;
    private OnGalleryListener onGalleryListener;
    private boolean permissionsWasGranted;
    RubinoGalleryCellPresenter presenter;
    float screenHeight;
    float screenWidth;
    private TextView titleTextView;
    private static String[] neededPermissions = {"android.permission.READ_EXTERNAL_STORAGE"};
    private static Comparator<RubinoGalleryObject> comparator = new Comparator<RubinoGalleryObject>() { // from class: ir.resaneh1.iptv.fragment.StoryGalleryFragment.7
        @Override // java.util.Comparator
        public int compare(RubinoGalleryObject rubinoGalleryObject, RubinoGalleryObject rubinoGalleryObject2) {
            return rubinoGalleryObject.dateAdded > rubinoGalleryObject2.dateAdded ? -1 : 1;
        }
    };

    public interface OnGalleryListener {
        void onGalleryLoaded(ArrayList<RubinoGalleryObject> arrayList);

        void onSelectItem(RubinoGalleryObject rubinoGalleryObject);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.story_gallery;
    }

    public StoryGalleryFragment() {
        this.isForceBlackTheme = true;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.titleTextView = (TextView) findViewById(R.id.textView);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        if (this.mainArrayList.size() == 0) {
            boolean zCheckPermissions = checkPermissions(false);
            this.permissionsWasGranted = zCheckPermissions;
            if (zCheckPermissions) {
                loadData(GalleryHelper.queryAndParseGalleryObject(true, true));
            }
        }
        super.onResume();
    }

    public void checkPermissionAndLoadIfNeeded() {
        if (this.mainArrayList.size() == 0) {
            boolean zCheckPermissions = checkPermissions(true);
            this.permissionsWasGranted = zCheckPermissions;
            if (zCheckPermissions) {
                loadData(GalleryHelper.queryAndParseGalleryObject(true, true));
            }
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.swipeBackEnabled = false;
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            this.isFullScreen = true;
        }
        this.needLockOrientation = true;
        this.titleTextView.setText(LocaleController.getString(R.string.gallery));
        this.presenter = new RubinoGalleryCellPresenter(this.mContext);
        this.screenWidth = DimensionHelper.getScreenMinDimension((Activity) this.mContext);
        this.screenHeight = DimensionHelper.getScreenMaxDimension((Activity) this.mContext);
        this.presenter.width = (int) ((this.screenWidth / 3) - AndroidUtilities.dp(2.0f));
        this.presenter.whRatio = this.screenWidth / this.screenHeight;
        this.mainRecyclerView.setBackgroundColor(this.mContext.getResources().getColor(R.color.black));
        float screenMinDimension = DimensionHelper.getScreenMinDimension((Activity) this.mContext);
        int i = this.presenter.width;
        int iDp = ((int) (screenMinDimension - (i * ((int) (screenMinDimension / i))))) - AndroidUtilities.dp(2.0f);
        RtlGridLayoutManager rtlGridLayoutManager = new RtlGridLayoutManager(this.mContext, 3);
        this.mainRecyclerView.setPadding(0, 0, (iDp / 2) + AndroidUtilities.dp(2.0f), 0);
        this.mainRecyclerView.setLayoutManager(rtlGridLayoutManager);
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.StoryGalleryFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.rubinoGallery) {
                    return StoryGalleryFragment.this.presenter;
                }
                return null;
            }
        }, new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryGalleryFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                if (StoryGalleryFragment.this.onGalleryListener == null || !(abstractViewHolder instanceof RubinoGalleryCellPresenter.ViewHolder)) {
                    return;
                }
                StoryGalleryFragment.this.onGalleryListener.onSelectItem((RubinoGalleryObject) abstractViewHolder.item);
            }
        }, null);
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        final ArrayList arrayList = new ArrayList();
        arrayList.add(LocaleController.getString(R.string.gallery));
        arrayList.add(LocaleController.getString(R.string.images));
        arrayList.add(LocaleController.getString(R.string.videos));
        this.titleTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryGalleryFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StoryGalleryFragment storyGalleryFragment = StoryGalleryFragment.this;
                storyGalleryFragment.showMenu(storyGalleryFragment.titleTextView, arrayList);
            }
        });
        this.progressBar.setVisibility(0);
    }

    public void setOnGalleryListener(OnGalleryListener onGalleryListener) {
        this.onGalleryListener = onGalleryListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData(Observable<GalleryResultObject> observable) {
        DisposableObserver disposableObserver = this.loadDataObservable;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        DisposableObserver disposableObserver2 = (DisposableObserver) observable.observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<GalleryResultObject>() { // from class: ir.resaneh1.iptv.fragment.StoryGalleryFragment.4
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(GalleryResultObject galleryResultObject) {
                StoryGalleryFragment.this.progressBar.setVisibility(4);
                StoryGalleryFragment.this.mainArrayList.clear();
                if (galleryResultObject != null && galleryResultObject.galleryObjectArray != null) {
                    if (StoryGalleryFragment.this.onGalleryListener != null) {
                        StoryGalleryFragment.this.onGalleryListener.onGalleryLoaded(galleryResultObject.galleryObjectArray);
                    }
                    StoryGalleryFragment.this.mainArrayList.addAll(galleryResultObject.galleryObjectArray);
                }
                StoryGalleryFragment.this.mainAdapter.notifyDataSetChanged();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                StoryGalleryFragment.this.progressBar.setVisibility(4);
            }
        });
        this.loadDataObservable = disposableObserver2;
        ((PresenterFragment) this).compositeDisposable.add(disposableObserver2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMenu(View view, final ArrayList<String> arrayList) {
        PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(ApplicationLoader.applicationActivity, R.style.PopupMenu), view);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        popupMenu.inflate(R.menu.dynamic_view);
        popupMenu.setGravity(17);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            popupMenu.getMenu().add(1, arrayList.indexOf(next), arrayList.indexOf(next), next);
        }
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() { // from class: ir.resaneh1.iptv.fragment.StoryGalleryFragment.5
            @Override // androidx.appcompat.widget.PopupMenu.OnDismissListener
            public void onDismiss(PopupMenu popupMenu2) {
                StoryGalleryFragment storyGalleryFragment = StoryGalleryFragment.this;
                storyGalleryFragment.toggleFullscreenSwitch(storyGalleryFragment.isFullScreen);
                StoryGalleryFragment.this.lockOrientationPortrait();
            }
        });
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryGalleryFragment.6
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId >= 0 && itemId < arrayList.size()) {
                    int itemId2 = menuItem.getItemId();
                    StoryGalleryFragment.this.titleTextView.setText((String) arrayList.get(itemId2));
                    if (itemId2 == 0) {
                        StoryGalleryFragment.this.loadData(GalleryHelper.queryAndParseGalleryObject(true, true));
                    } else if (itemId2 == 1) {
                        StoryGalleryFragment.this.loadData(GalleryHelper.queryAndParseGalleryObject(true, false));
                    } else if (itemId2 == 2) {
                        StoryGalleryFragment.this.loadData(GalleryHelper.queryAndParseGalleryObject(false, true));
                    }
                }
                return true;
            }
        });
        popupMenu.show();
    }

    public static class GalleryHelper {
        private static final String[] projectionPhotos;
        private static final String[] projectionVideo;

        static {
            String[] strArr = new String[4];
            strArr[0] = "_id";
            strArr[1] = "_data";
            int i = Build.VERSION.SDK_INT;
            strArr[2] = i > 28 ? "date_modified" : "datetaken";
            strArr[3] = "duration";
            projectionVideo = strArr;
            String[] strArr2 = new String[6];
            strArr2[0] = "_id";
            strArr2[1] = "bucket_id";
            strArr2[2] = "bucket_display_name";
            strArr2[3] = "_data";
            strArr2[4] = i <= 28 ? "datetaken" : "date_modified";
            strArr2[5] = "orientation";
            projectionPhotos = strArr2;
        }

        public static Observable<GalleryResultObject> queryAndParseGalleryObject(final boolean z, final boolean z2) {
            final ArrayList arrayList = new ArrayList();
            return Observable.timer(100L, TimeUnit.MILLISECONDS).doOnNext(new Consumer<Long>() { // from class: ir.resaneh1.iptv.fragment.StoryGalleryFragment.GalleryHelper.2
                /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:47:0x00ad  */
                /* JADX WARN: Removed duplicated region for block: B:80:0x013a  */
                @Override // io.reactivex.functions.Consumer
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void accept(java.lang.Long r19) throws java.lang.Exception {
                    /*
                        Method dump skipped, instructions count: 324
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.StoryGalleryFragment.GalleryHelper.AnonymousClass2.accept(java.lang.Long):void");
                }
            }).observeOn(AndroidSchedulers.mainThread()).flatMap(new Function<Long, ObservableSource<GalleryResultObject>>() { // from class: ir.resaneh1.iptv.fragment.StoryGalleryFragment.GalleryHelper.1
                @Override // io.reactivex.functions.Function
                public ObservableSource<GalleryResultObject> apply(Long l) throws Exception {
                    GalleryResultObject galleryResultObject = new GalleryResultObject();
                    galleryResultObject.galleryObjectArray = arrayList;
                    return Observable.just(galleryResultObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RubinoGalleryObject parseVideo(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("_data");
        int columnIndex3 = cursor.getColumnIndex("duration");
        int columnIndex4 = cursor.getColumnIndex(Build.VERSION.SDK_INT > 28 ? "date_modified" : "datetaken");
        String string = cursor.getString(columnIndex2);
        if (string == null || string.length() == 0) {
            return null;
        }
        RubinoGalleryObject rubinoGalleryObject = new RubinoGalleryObject();
        rubinoGalleryObject.path = cursor.getString(columnIndex2);
        rubinoGalleryObject.dateAdded = cursor.getLong(columnIndex4);
        rubinoGalleryObject.isVideo = true;
        rubinoGalleryObject.galleryObjectId = cursor.getInt(columnIndex);
        if (columnIndex3 >= 0) {
            rubinoGalleryObject.duration = cursor.getLong(columnIndex3);
        }
        return rubinoGalleryObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RubinoGalleryObject parseImage(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("_data");
        int columnIndex3 = cursor.getColumnIndex(Build.VERSION.SDK_INT > 28 ? "date_modified" : "datetaken");
        String string = cursor.getString(columnIndex2);
        if (string == null || string.length() == 0) {
            return null;
        }
        RubinoGalleryObject rubinoGalleryObject = new RubinoGalleryObject();
        rubinoGalleryObject.path = cursor.getString(columnIndex2);
        rubinoGalleryObject.dateAdded = cursor.getLong(columnIndex3);
        rubinoGalleryObject.isVideo = false;
        rubinoGalleryObject.galleryObjectId = cursor.getInt(columnIndex);
        return rubinoGalleryObject;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        int i2 = requestCode;
        if (i == i2 && iArr != null && iArr.length > 0 && iArr[0] == 0) {
            if (this.permissionsWasGranted) {
                return;
            }
            this.permissionsWasGranted = true;
            loadData(GalleryHelper.queryAndParseGalleryObject(true, true));
            return;
        }
        if (i == i2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
            builder.setTitle(LocaleController.getString(R.string.AppName));
            builder.setMessage(LocaleController.formatString(R.string.StoryPermissionStorage, LocaleController.getString(R.string.AppName)));
            builder.setNegativeButton(LocaleController.getString(R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryGalleryFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    StoryGalleryFragment.lambda$onRequestPermissionsResultFragment$0(dialogInterface, i3);
                }
            });
            builder.setPositiveButton(LocaleController.getString(R.string.OK), null);
            builder.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onRequestPermissionsResultFragment$0(DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            ApplicationLoader.applicationActivity.startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static boolean checkPermissions(boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
        if (launchActivity == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : neededPermissions) {
            if (ContextCompat.checkSelfPermission(launchActivity, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            return true;
        }
        if (z) {
            launchActivity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), requestCode);
        }
        return false;
    }
}
