package ir.resaneh1.iptv.presenter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidMessenger.utilites.MessengerLinkHandler;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.aaap.messengercore.model.ObjectInfo;
import ir.aaap.messengercore.model.ProductMessageData;
import ir.appp.messenger.SendPostHelper;
import ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity;
import ir.appp.ui.ActionBar.RubinoSharePostDialog;
import ir.appp.wallet.WalletActivity;
import ir.appp.wallet.WalletController;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIView.UILinearLayout;
import ir.resaneh1.iptv.activity.HomeFragment;
import ir.resaneh1.iptv.activity.MainTabFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.apiMessanger.ApiServerException;
import ir.resaneh1.iptv.barcode.BarcodeHelper;
import ir.resaneh1.iptv.dialog.JustLinearLayoutDialog;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.fragment.BasketDetailsFragment;
import ir.resaneh1.iptv.fragment.DetailFragment;
import ir.resaneh1.iptv.fragment.DynamicPageFragment;
import ir.resaneh1.iptv.fragment.EPGFragment;
import ir.resaneh1.iptv.fragment.ImageListFragment;
import ir.resaneh1.iptv.fragment.JJMatchDetailFragment;
import ir.resaneh1.iptv.fragment.ListFragment;
import ir.resaneh1.iptv.fragment.NewsDetailFragment;
import ir.resaneh1.iptv.fragment.RubinoAddPostFragment;
import ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment;
import ir.resaneh1.iptv.fragment.messanger.RubinoSettingsActivity;
import ir.resaneh1.iptv.fragment.messanger.StorySettingsActivity;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity;
import ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity;
import ir.resaneh1.iptv.fragment.rubino.RubinoProfileActivity;
import ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.SendStoryHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.messanger.RubikaNotificationManager;
import ir.resaneh1.iptv.model.AODObjectAbs;
import ir.resaneh1.iptv.model.BannerObjectAbs;
import ir.resaneh1.iptv.model.ChildLockCheck;
import ir.resaneh1.iptv.model.ClickLinkTrackInput;
import ir.resaneh1.iptv.model.ClubSetttingItem;
import ir.resaneh1.iptv.model.CommandDataInLink;
import ir.resaneh1.iptv.model.CourseAbs;
import ir.resaneh1.iptv.model.DynamicPageCommandObject;
import ir.resaneh1.iptv.model.ExploreDataInLink;
import ir.resaneh1.iptv.model.GoLinkData;
import ir.resaneh1.iptv.model.ImageLinkObject;
import ir.resaneh1.iptv.model.ImageObject;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.InstaSetBlockProfileInput;
import ir.resaneh1.iptv.model.JJMatchObject;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.LinkItem;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.NewsObject;
import ir.resaneh1.iptv.model.OperatorObject;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoNewEventObject;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.ScrollViewListObject;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.model.TVChannelAbs;
import ir.resaneh1.iptv.model.TagObject;
import ir.resaneh1.iptv.model.TvEpisodeObjectAbs;
import ir.resaneh1.iptv.model.VODObjectAbs;
import ir.resaneh1.iptv.model.ViewDataObject;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.model.ViewTagObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenters.BannerItemPresenter;
import ir.resaneh1.iptv.presenters.ClubSettingPresenter;
import ir.resaneh1.iptv.presenters.RubinoMyProfilesRowInSettingPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.LaunchActivity;
import retrofit2.Call;

/* loaded from: classes.dex */
public class MainClickHandler {
    private static volatile MainClickHandler Instance;

    public void onClick(BaseFragment baseFragment, AbstractPresenter.AbstractViewHolder abstractViewHolder) {
        MyLog.e("MainClickHandler", "onClick: " + abstractViewHolder.item.getPresenterType());
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.basket) {
            baseFragment.presentFragment(new BasketDetailsFragment(abstractViewHolder.item.getId()));
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.jjMatch) {
            baseFragment.presentFragment(new JJMatchDetailFragment((JJMatchObject) abstractViewHolder.item));
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.news) {
            baseFragment.presentFragment(new NewsDetailFragment((NewsObject) abstractViewHolder.item));
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.itemLink) {
            onLinkClick(baseFragment, ((LinkItem) abstractViewHolder.item).link);
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.vod) {
            VODObjectAbs vODObjectAbs = (VODObjectAbs) abstractViewHolder.item;
            if (!vODObjectAbs.is_series) {
                baseFragment.presentFragment(new DetailFragment((VODObjectAbs) abstractViewHolder.item));
                return;
            }
            TagObject tagObject = new TagObject();
            tagObject.type = TagObject.TagType.vod_film;
            tagObject.tag_id = vODObjectAbs.film_id;
            ListInput listInput = new ListInput(tagObject);
            listInput.title = vODObjectAbs.fa_name;
            baseFragment.presentFragment(new ListFragment(listInput));
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.tv_episode) {
            baseFragment.presentFragment(new DetailFragment((TvEpisodeObjectAbs) abstractViewHolder.item));
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.aod) {
            AODObjectAbs aODObjectAbs = (AODObjectAbs) abstractViewHolder.item;
            if (!aODObjectAbs.is_album) {
                baseFragment.presentFragment(new DetailFragment((AODObjectAbs) abstractViewHolder.item));
                return;
            }
            TagObject tagObject2 = new TagObject();
            tagObject2.type = TagObject.TagType.aod_track;
            tagObject2.tag_id = aODObjectAbs.track_id;
            ListInput listInput2 = new ListInput(tagObject2);
            listInput2.title = aODObjectAbs.name;
            baseFragment.presentFragment(new ListFragment(listInput2));
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.tv_channel) {
            baseFragment.presentFragment(new EPGFragment((TVChannelAbs) abstractViewHolder.item));
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.course) {
            MyLog.e("MainClickHandler", "onClick:2 " + abstractViewHolder.item.getPresenterType());
            baseFragment.presentFragment(new DetailFragment((CourseAbs) abstractViewHolder.item));
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.Operator) {
            if (((OperatorObject) abstractViewHolder.item).is_active) {
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setPage(((OperatorObject) abstractViewHolder.item).page_name);
                baseFragment.presentFragment(homeFragment);
                return;
            }
            ToastiLikeSnack.showL(baseFragment.getContext(), LocaleController.getString("need_premium_access", R.string.need_premium_access));
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.Banner) {
            MyLog.e("MainClickHandler", "onClick:2 " + abstractViewHolder.item.getPresenterType());
            onLinkClick(baseFragment, ((BannerObjectAbs) ((BannerItemPresenter.MyViewHolder) abstractViewHolder).item).link);
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.clubSettingItem) {
            ClubSetttingItem clubSetttingItem = (ClubSetttingItem) ((ClubSettingPresenter.ViewHolder) abstractViewHolder).item;
            ArrayList<ClubSetttingItem> arrayList = clubSetttingItem.items;
            if (arrayList != null && arrayList.size() > 0) {
                ListInput listInput3 = new ListInput(clubSetttingItem.items);
                listInput3.title = clubSetttingItem.text1;
                ListFragment listFragment = new ListFragment(listInput3);
                listFragment.isGrid = false;
                baseFragment.presentFragment(listFragment);
                return;
            }
            Link link = clubSetttingItem.link;
            if (link != null) {
                onLinkClick(baseFragment, link);
                return;
            }
            return;
        }
        if (abstractViewHolder.item.getPresenterType() == PresenterItemType.superLinkItem) {
            onLinkClick(baseFragment, ((Link.SuperLinkViewObject) abstractViewHolder.item).link);
        }
    }

    private void messengerClick(BaseFragment baseFragment, Link link) {
        getMessengerLinkHandler().onMessengerLinkClick(baseFragment, (Link) ApplicationLoader.getGson().fromJson(ApplicationLoader.getGson().toJson(link), Link.class));
    }

    public void getWalletByShareLinkClick(String str) {
        if (str == null) {
            return;
        }
        BaseFragment baseFragment = null;
        try {
            if (ApplicationLoader.applicationActivity != null && ApplicationLoader.applicationActivity.getLastFragment() != null) {
                BaseFragment lastFragment = ApplicationLoader.applicationActivity.getLastFragment();
                if (lastFragment != null) {
                    baseFragment = lastFragment;
                }
            }
        } catch (Exception unused) {
        }
        if (baseFragment == null) {
            return;
        }
        WalletController.getInstance(UserConfig.selectedAccount).getWalletByShareLink(str, baseFragment);
    }

    public void handleWalletAction(String str) {
        if (TextUtils.isEmpty(str) || ApplicationLoader.applicationActivity == null || !str.equals("refreshwallet") || (ApplicationLoader.applicationActivity.getLastFragment() instanceof WalletActivity)) {
            return;
        }
        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new WalletActivity());
    }

    public void onLinkClick(Link link) {
        onLinkClick(null, link);
    }

    public void onLinkClick(final BaseFragment baseFragment, final Link link) {
        if (link == null) {
            return;
        }
        try {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.presenter.MainClickHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    Link link2;
                    Link link3 = link;
                    Link link4 = link3.if_supperted_link;
                    if (link4 != null || link3.not_supperted_link != null) {
                        boolean zOnLinkClickInternal = link4 != null ? MainClickHandler.this.onLinkClickInternal(baseFragment, link4, false) : false;
                        if (!zOnLinkClickInternal) {
                            MainClickHandler mainClickHandler = MainClickHandler.this;
                            BaseFragment baseFragment2 = baseFragment;
                            Link link5 = link;
                            zOnLinkClickInternal = mainClickHandler.onLinkClickInternal(baseFragment2, link5, link5.not_supperted_link == null);
                        }
                        if (zOnLinkClickInternal || (link2 = link.not_supperted_link) == null) {
                            return;
                        }
                        MainClickHandler.this.onLinkClickInternal(baseFragment, link2, true);
                        return;
                    }
                    MainClickHandler.this.onLinkClickInternal(baseFragment, link3, true);
                }
            });
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x082f A[Catch: Exception -> 0x0833, TRY_LEAVE, TryCatch #3 {Exception -> 0x0833, blocks: (B:15:0x0025, B:18:0x002c, B:20:0x0030, B:21:0x0033, B:23:0x003a, B:405:0x082f, B:24:0x0044, B:26:0x0048, B:28:0x004c, B:30:0x0050, B:31:0x005c, B:33:0x0060, B:34:0x006a, B:36:0x006e, B:37:0x0078, B:39:0x007c, B:41:0x0080, B:43:0x0086, B:45:0x008e, B:46:0x0093, B:48:0x0097, B:49:0x009c, B:51:0x00a0, B:52:0x00a5, B:53:0x00aa, B:56:0x00b0, B:58:0x00b4, B:60:0x00b8, B:61:0x00bd, B:64:0x00c3, B:66:0x00c7, B:68:0x00cb, B:69:0x00d6, B:71:0x00da, B:73:0x00de, B:74:0x00e7, B:76:0x00eb, B:78:0x00ef, B:80:0x00f3, B:81:0x0103, B:83:0x0107, B:85:0x010b, B:87:0x010f, B:89:0x0113, B:90:0x0125, B:93:0x012b, B:95:0x012f, B:98:0x0134, B:99:0x0147, B:101:0x014b, B:102:0x0183, B:104:0x0187, B:106:0x018b, B:108:0x0193, B:109:0x019f, B:111:0x01a3, B:112:0x01af, B:114:0x01b3, B:115:0x01bf, B:117:0x01c3, B:118:0x01cf, B:120:0x01d3, B:121:0x01df, B:123:0x01e3, B:125:0x01e7, B:127:0x01eb, B:129:0x01ef, B:132:0x01f4, B:134:0x0204, B:135:0x0218, B:138:0x021e, B:140:0x0222, B:142:0x0226, B:145:0x022d, B:146:0x023d, B:148:0x0241, B:149:0x0248, B:151:0x024c, B:153:0x0252, B:155:0x0256, B:156:0x026f, B:157:0x0274, B:159:0x0278, B:161:0x027c, B:162:0x028e, B:164:0x0292, B:166:0x0296, B:168:0x029a, B:169:0x02a8, B:171:0x02ac, B:173:0x02b0, B:174:0x02c0, B:175:0x02ca, B:177:0x02ce, B:179:0x02d2, B:180:0x02d7, B:182:0x02db, B:184:0x02df, B:185:0x02e4, B:187:0x02e8, B:189:0x02ee, B:191:0x02f2, B:193:0x02f8, B:194:0x031e, B:195:0x033d, B:197:0x0341, B:199:0x0345, B:201:0x034b, B:203:0x034f, B:204:0x037f, B:206:0x0383, B:209:0x038b, B:211:0x0398, B:213:0x039c, B:214:0x03ca, B:216:0x03ce, B:218:0x03d6, B:221:0x03e3, B:222:0x03eb, B:224:0x03ef, B:227:0x03fc, B:228:0x0404, B:230:0x0408, B:233:0x0415, B:234:0x041d, B:236:0x0421, B:237:0x0431, B:239:0x0435, B:240:0x0443, B:242:0x0447, B:243:0x0494, B:245:0x0498, B:247:0x049c, B:249:0x04b9, B:256:0x04dc, B:258:0x04f0, B:260:0x04f4, B:262:0x04fc, B:263:0x050e, B:251:0x04c3, B:253:0x04d5, B:255:0x04d9, B:264:0x051c, B:266:0x0520, B:268:0x0524, B:269:0x0534, B:271:0x0538, B:273:0x053c, B:275:0x056b, B:277:0x0571, B:279:0x057f, B:281:0x058f, B:283:0x05a3, B:284:0x05a8, B:285:0x05be, B:286:0x05c3, B:288:0x05c7, B:290:0x05cd, B:291:0x05d9, B:292:0x05de, B:294:0x05e2, B:296:0x05e8, B:297:0x05ef, B:298:0x05f4, B:300:0x05f8, B:302:0x05fe, B:303:0x060f, B:304:0x0614, B:306:0x0618, B:308:0x061e, B:309:0x063b, B:310:0x0640, B:312:0x0644, B:314:0x064a, B:316:0x0658, B:318:0x0668, B:320:0x067c, B:321:0x0681, B:322:0x0697, B:323:0x069c, B:325:0x06a0, B:327:0x06a4, B:328:0x06b2, B:329:0x06bc, B:331:0x06c0, B:332:0x06cc, B:334:0x06d0, B:335:0x06d5, B:337:0x06d9, B:338:0x06e3, B:340:0x06e7, B:341:0x06f1, B:343:0x06f5, B:344:0x06ff, B:346:0x0703, B:347:0x070d, B:349:0x0711, B:350:0x071b, B:352:0x071f, B:353:0x0729, B:355:0x072d, B:356:0x0732, B:358:0x0736, B:360:0x074d, B:361:0x075e, B:363:0x0764, B:364:0x0769, B:366:0x076f, B:367:0x0774, B:369:0x077a, B:371:0x0781, B:372:0x078d, B:374:0x0793, B:376:0x0797, B:378:0x07a1, B:379:0x07ad, B:380:0x07b2, B:382:0x07b6, B:385:0x07bb, B:391:0x07e2, B:390:0x07de, B:394:0x07eb, B:396:0x07ef, B:397:0x0818, B:399:0x081c, B:401:0x0828, B:388:0x07da), top: B:418:0x0025, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onLinkClickInternal(org.rbmain.ui.ActionBar.BaseFragment r19, final ir.resaneh1.iptv.model.Link r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 2105
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.presenter.MainClickHandler.onLinkClickInternal(org.rbmain.ui.ActionBar.BaseFragment, ir.resaneh1.iptv.model.Link, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onLinkClickInternal$0(int i, Link link, String str) {
        String str2 = link.barcodescan_data.type + BuildConfig.FLAVOR;
        Link.BarcodescanData barcodescanData = link.barcodescan_data;
        BarcodeHelper.requestBarcodeAction(i, str2, str, null, null, barcodescanData.success_payment_return_link, barcodescanData.success_payment_return_text);
    }

    private void addRubinoStory() {
        try {
            if (RubinoController.getInstance(UserConfig.selectedAccount).hasPermissionAddStory()) {
                ApplicationLoader.applicationActivity.getLastFragment().presentFragment(new StoryCameraAndGalleryFragment());
            }
        } catch (Exception unused) {
        }
    }

    private void addRubinoLive() {
        if (RubinoController.getInstance(UserConfig.selectedAccount).hasPermissionAddLive()) {
            try {
                StoryCameraAndGalleryFragment storyCameraAndGalleryFragment = new StoryCameraAndGalleryFragment();
                storyCameraAndGalleryFragment.initTypeLive = true;
                ApplicationLoader.applicationActivity.getLastFragment().presentFragment(storyCameraAndGalleryFragment);
            } catch (Exception unused) {
            }
        }
    }

    private void onCommandsInDynamicPageClick(CommandDataInLink commandDataInLink) {
        ArrayList<DynamicPageCommandObject> arrayList;
        if (commandDataInLink == null || (arrayList = commandDataInLink.commands) == null || arrayList.size() <= 0) {
            return;
        }
        BaseFragment lastFragment = ApplicationLoader.applicationActivity.getLastFragment();
        if (lastFragment instanceof DynamicPageFragment) {
            ((DynamicPageFragment) lastFragment).doCommands(commandDataInLink.commands, new ViewDataObject(), null);
        }
    }

    private void callClickLinkTrack(BaseFragment baseFragment, String str) {
        Disposable disposable = (Disposable) ApiRequestMessangerRx.getInstance(AndroidUtilities.getCurrentAccountTemporary()).clickLinkTrack(new ClickLinkTrackInput(str)).subscribeWith(new DisposableObserver<MessangerOutput>(this) { // from class: ir.resaneh1.iptv.presenter.MainClickHandler.10
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) {
            }
        });
        if (baseFragment == null || !(baseFragment instanceof PresenterFragment)) {
            return;
        }
        ((PresenterFragment) baseFragment).compositeDisposable.add(disposable);
    }

    public void onTextShare(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        try {
            ApplicationLoader.applicationActivity.startActivity(Intent.createChooser(intent, LocaleController.getString("share_with", R.string.share_with)));
        } catch (Exception unused) {
            ToastiLikeSnack.showL(ApplicationLoader.applicationActivity, LocaleController.getString("no_app_to_share", R.string.no_app_to_share));
        }
    }

    public void openRubinoTab() {
        BaseFragment baseFragment;
        if (ApplicationLoader.applicationActivity != null) {
            ArrayList<BaseFragment> arrayList = ApplicationLoader.applicationActivity.getActionBarLayout().fragmentsStack;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                try {
                    baseFragment = arrayList.get(size);
                } catch (Exception unused) {
                }
                if (!(baseFragment instanceof MainTabFragment)) {
                    baseFragment.finishFragment(false);
                } else {
                    ((MainTabFragment) baseFragment).selectRubino();
                    return;
                }
            }
        }
    }

    public void openExploreTab(ExploreDataInLink exploreDataInLink) {
        BaseFragment baseFragment;
        if (ApplicationLoader.applicationActivity != null) {
            ArrayList<BaseFragment> arrayList = ApplicationLoader.applicationActivity.getActionBarLayout().fragmentsStack;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                try {
                    baseFragment = arrayList.get(size);
                } catch (Exception unused) {
                }
                if (!(baseFragment instanceof MainTabFragment)) {
                    baseFragment.finishFragment(false);
                } else {
                    ((MainTabFragment) baseFragment).selectExploreTab(exploreDataInLink);
                    return;
                }
            }
        }
    }

    public void changeRubinoProfile(RubinoProfileObject rubinoProfileObject) {
        changeRubinoProfile(rubinoProfileObject, false);
    }

    public void changeRubinoProfile(RubinoProfileObject rubinoProfileObject, boolean z) {
        RubinoController.getInstance(UserConfig.selectedAccount).clear();
        StoryController.getInstance(UserConfig.selectedAccount).clear();
        SendStoryHelper.getInstance(UserConfig.selectedAccount).clear();
        SendPostHelper.getInstance(UserConfig.selectedAccount).clear();
        AppRubinoPreferences.getInstance(UserConfig.selectedAccount).setRubinoCurrentProfileObject(rubinoProfileObject);
        if (ApplicationLoader.applicationActivity != null) {
            ArrayList<BaseFragment> arrayList = ApplicationLoader.applicationActivity.getActionBarLayout().fragmentsStack;
            if (arrayList.get(0) instanceof MainTabFragment) {
                MainTabFragment mainTabFragment = (MainTabFragment) arrayList.get(0);
                mainTabFragment.reCreateExploreTab();
                mainTabFragment.reCreateRubinoTab();
                openRubinoTab();
                if (z) {
                    ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoProfileActivity(rubinoProfileObject));
                }
            }
        }
    }

    public void openChatTab() {
        BaseFragment baseFragment;
        if (ApplicationLoader.applicationActivity != null) {
            ArrayList<BaseFragment> arrayList = ApplicationLoader.applicationActivity.getActionBarLayout().fragmentsStack;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                try {
                    baseFragment = arrayList.get(size);
                } catch (Exception unused) {
                }
                if (!(baseFragment instanceof MainTabFragment)) {
                    baseFragment.finishFragment(false);
                } else {
                    ((MainTabFragment) baseFragment).selectChatTab();
                    return;
                }
            }
        }
    }

    public void openSettingTab() {
        BaseFragment baseFragment;
        if (ApplicationLoader.applicationActivity != null) {
            ArrayList<BaseFragment> arrayList = ApplicationLoader.applicationActivity.getActionBarLayout().fragmentsStack;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                try {
                    baseFragment = arrayList.get(size);
                } catch (Exception unused) {
                }
                if (!(baseFragment instanceof MainTabFragment)) {
                    baseFragment.finishFragment(false);
                } else {
                    ((MainTabFragment) baseFragment).selectSettings();
                    return;
                }
            }
        }
    }

    public void openProfileOrRubinoTab(InstaProfileObject instaProfileObject) {
        openProfileOrRubinoTab(RubinoProfileObject.createFromOldObject(instaProfileObject));
    }

    public void openProfileOrRubinoTab(RubinoProfileObject rubinoProfileObject) {
        if (rubinoProfileObject == null) {
            return;
        }
        if (AppRubinoPreferences.getInstance(AndroidUtilities.getCurrentAccountTemporary()).getRubinoCurrentProfileObject() != null && !AppRubinoPreferences.getInstance(AndroidUtilities.getCurrentAccountTemporary()).getRubinoCurrentProfileObject().id.isEmpty()) {
            onRubinoProfileClick(rubinoProfileObject);
        } else {
            openRubinoTab();
        }
    }

    public void openRubinoPost(String str, String str2, boolean z) {
        if (!ChildLockCheck.canOpenRubinoWithAlert() || str == null || str2 == null) {
            return;
        }
        if (!AppRubinoPreferences.getInstance(AndroidUtilities.getCurrentAccountTemporary()).getRubinoCurrentProfileObject().id.isEmpty()) {
            if (ApplicationLoader.applicationActivity == null || z) {
                return;
            }
            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostListActivity(str, str2));
            return;
        }
        openRubinoTab();
    }

    public void openRubinoPost(RubinoPostObject rubinoPostObject, boolean z) {
        Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
        openRubinoPost(postObjectFromServer.id, postObjectFromServer.profile_id, z);
    }

    public void openRubinoStory(final StoryObject storyObject, final RubinoProfileObject rubinoProfileObject, final float f, final float f2) {
        if (ChildLockCheck.canOpenRubinoWithAlert() && storyObject != null) {
            if (!AppRubinoPreferences.getInstance(AndroidUtilities.getCurrentAccountTemporary()).getRubinoCurrentProfileObject().id.isEmpty()) {
                if (ApplicationLoader.applicationActivity != null) {
                    final int i = UserConfig.selectedAccount;
                    return;
                }
                return;
            }
            openRubinoTab();
        }
    }

    public void onInstaHashTagClicked(String str) {
        if (ChildLockCheck.canOpenRubinoWithAlert()) {
            String strReplace = str.replace("#", BuildConfig.FLAVOR);
            if (ApplicationLoader.applicationActivity != null) {
                ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoPostGridActivity(strReplace));
            }
        }
    }

    public void onInstaUsernameClicked(String str) {
        if (ApplicationLoader.applicationActivity != null) {
            onInstaUsernameClicked(ApplicationLoader.applicationActivity.mainCompositeDisposable, str);
        }
    }

    public void onInstaUsernameClicked(CompositeDisposable compositeDisposable, String str) {
        if (ChildLockCheck.canOpenRubinoWithAlert()) {
            String strReplace = str.replace("@", BuildConfig.FLAVOR);
            if (ApplicationLoader.applicationActivity != null) {
                final LoadingDialog loadingDialog = new LoadingDialog(ApplicationLoader.applicationActivity);
                final DisposableObserver disposableObserver = (DisposableObserver) ApiRequestMessangerRx.getInstance(AndroidUtilities.getCurrentAccountTemporary()).rubinoIsExistUsername(new Rubino.IsExistUsernameInput(strReplace)).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.IsExistUsernameOutput>>() { // from class: ir.resaneh1.iptv.presenter.MainClickHandler.15
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(MessangerOutput<Rubino.IsExistUsernameOutput> messangerOutput) {
                        loadingDialog.dismiss();
                        Rubino.IsExistUsernameOutput isExistUsernameOutput = messangerOutput.data;
                        if (isExistUsernameOutput.exist) {
                            MainClickHandler.this.openProfileOrRubinoTab(isExistUsernameOutput.profile);
                        } else {
                            ToastiLikeSnack.showS(ApplicationLoader.applicationActivity, LocaleController.getString(R.string.user_not_exist));
                        }
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        loadingDialog.dismiss();
                        if (th instanceof ApiServerException) {
                            ApiServerException apiServerException = (ApiServerException) th;
                            if (apiServerException.status_det == MessangerOutput.EnumStatusDet.USERNAME_NOT_EXIST && apiServerException.status == MessangerOutput.EnumStatus.ERROR_ACTION) {
                                MainClickHandler.this.openRubinoTab();
                            }
                        }
                    }
                });
                compositeDisposable.add(disposableObserver);
                loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ir.resaneh1.iptv.presenter.MainClickHandler.16
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        disposableObserver.dispose();
                    }
                });
            }
        }
    }

    public void onRubinoProfileClick(InstaProfileObject instaProfileObject) {
        onRubinoProfileClick(RubinoProfileObject.createFromOldObject(instaProfileObject));
    }

    public void onRubinoProfileClick(RubinoProfileObject rubinoProfileObject) {
        if (ChildLockCheck.canOpenRubinoWithAlert() && ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoProfileActivity(rubinoProfileObject));
        }
    }

    public void onInstaEventClick(RubinoNewEventObject rubinoNewEventObject) {
        ArrayList<RubinoProfileObject> arrayList;
        if (ChildLockCheck.canOpenRubinoWithAlert()) {
            RubikaNotificationManager.getInstance(AndroidUtilities.getCurrentAccountTemporary()).clearNotificationInsta(rubinoNewEventObject);
            if (rubinoNewEventObject.getPresenterType() == PresenterItemType.instaNotifLikeComment || rubinoNewEventObject.getPresenterType() == PresenterItemType.instaNotifLikePost || rubinoNewEventObject.getPresenterType() == PresenterItemType.instaNotifCommentPost || rubinoNewEventObject.getPresenterType() == PresenterItemType.instaNotifCommentReply || rubinoNewEventObject.getPresenterType() == PresenterItemType.instaNotifSale || rubinoNewEventObject.getPresenterType() == PresenterItemType.instaNotifPurchase) {
                if (ApplicationLoader.applicationActivity == null || rubinoNewEventObject.post_id == null) {
                    return;
                }
                openRubinoPost(rubinoNewEventObject.getPostObject(UserConfig.selectedAccount), false);
                return;
            }
            if ((rubinoNewEventObject.getPresenterType() == PresenterItemType.instaNotifRequest || rubinoNewEventObject.getPresenterType() == PresenterItemType.instaNotifYouFollowing || rubinoNewEventObject.getPresenterType() == PresenterItemType.instaNotifFollowing) && ApplicationLoader.applicationActivity != null && (arrayList = rubinoNewEventObject.owners) != null && arrayList.size() == 1) {
                onRubinoProfileClick(rubinoNewEventObject.owners.get(0));
            }
        }
    }

    public void onRubinoEventClick(Rubino.NewEventObject newEventObject) {
        ArrayList<RubinoProfileObject> arrayList;
        if (!ChildLockCheck.canOpenRubinoWithAlert() || newEventObject == null || newEventObject.event == null) {
            return;
        }
        try {
            RubikaNotificationManager rubikaNotificationManager = RubikaNotificationManager.getInstance(AndroidUtilities.getCurrentAccountTemporary());
            Rubino.NewEventFromServerObject newEventFromServerObject = newEventObject.event;
            rubikaNotificationManager.clearNotificationRubino(newEventFromServerObject.id, newEventFromServerObject.profile_id);
        } catch (Exception unused) {
        }
        Rubino.NotifEnum notifEnum = newEventObject.event.model;
        if (notifEnum == Rubino.NotifEnum.LikeComment || notifEnum == Rubino.NotifEnum.LikePost || notifEnum == Rubino.NotifEnum.CommentPost || notifEnum == Rubino.NotifEnum.CommentReply || notifEnum == Rubino.NotifEnum.Sale || notifEnum == Rubino.NotifEnum.Purchase || notifEnum == Rubino.NotifEnum.TagPost) {
            if (ApplicationLoader.applicationActivity == null || newEventObject.event.post_id == null) {
                return;
            }
            RubinoPostObject rubinoPostObject = new RubinoPostObject();
            Rubino.PostObjectFromServer postObjectFromServer = new Rubino.PostObjectFromServer();
            Rubino.NewEventFromServerObject newEventFromServerObject2 = newEventObject.event;
            postObjectFromServer.id = newEventFromServerObject2.post_id;
            postObjectFromServer.profile_id = newEventFromServerObject2.post_profile_id;
            postObjectFromServer.file_type = newEventFromServerObject2.post_type;
            postObjectFromServer.full_thumbnail_url = newEventFromServerObject2.full_post_thumbnail_url;
            rubinoPostObject.setPost(postObjectFromServer, UserConfig.selectedAccount);
            openRubinoPost(rubinoPostObject, false);
            return;
        }
        if ((notifEnum == Rubino.NotifEnum.Request || notifEnum == Rubino.NotifEnum.YouFollowing || notifEnum == Rubino.NotifEnum.FollowingYou) && ApplicationLoader.applicationActivity != null && (arrayList = newEventObject.event.owners) != null && arrayList.size() == 1) {
            onRubinoProfileClick(newEventObject.event.owners.get(0));
        }
    }

    public void sendSms(String str, String str2) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        try {
            ApplicationLoader.applicationActivity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void callNumber(String str) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
            intent.addFlags(268435456);
            ApplicationLoader.applicationActivity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public boolean openUrl(String str) {
        return getMessengerLinkHandler().openUrl(str);
    }

    public void sendEmail(String str) {
        try {
            ApplicationLoader.applicationActivity.startActivity(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + str).buildUpon().build()), null));
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public void shareStringOrLink(Context context, String str) {
        shareStringOrLink(str);
    }

    public void shareStringOrLink(String str) {
        try {
            if (ApplicationLoader.applicationActivity != null) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.addFlags(MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM);
                intent.putExtra("android.intent.extra.TEXT", str);
                ApplicationLoader.applicationActivity.startActivity(Intent.createChooser(intent, LocaleController.getString("rubinoShare", R.string.rubinoShare)));
            }
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public void onMoreViewListClick(ViewTagObject viewTagObject) {
        if (viewTagObject == null || viewTagObject.view == null) {
            return;
        }
        ListFragment listFragment = new ListFragment(new ListInput(viewTagObject));
        listFragment.isHorizontal = false;
        ViewGroupObject viewGroupObject = viewTagObject.view;
        if (viewGroupObject != null) {
            ViewGroupObject.TypeEnum typeEnum = viewGroupObject.type;
            if (typeEnum == ViewGroupObject.TypeEnum.Normal) {
                listFragment.isGrid = true;
            } else if (typeEnum == ViewGroupObject.TypeEnum.List) {
                listFragment.isGrid = false;
            }
        }
        if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(listFragment);
        }
    }

    public static void goBackIfPossible(int i, ArrayList<DynamicPageCommandObject> arrayList) {
        GoLinkData goLinkData;
        BaseFragment baseFragment;
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        ArrayList<BaseFragment> arrayList2 = ApplicationLoader.applicationActivity.getActionBarLayout().fragmentsStack;
        int i2 = 1;
        for (int size = arrayList2.size() - 2; size >= 0 && (i == 0 || i2 < i); size--) {
            i2++;
            try {
                baseFragment = arrayList2.get(size);
            } catch (Exception unused) {
            }
            if (baseFragment instanceof MainTabFragment) {
                break;
            }
            baseFragment.removeSelfFromStack();
        }
        BaseFragment lastFragment = ApplicationLoader.applicationActivity.getLastFragment();
        if (lastFragment != null && !(lastFragment instanceof MainTabFragment)) {
            lastFragment.finishFragment(false);
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        BaseFragment lastFragment2 = ApplicationLoader.applicationActivity.getLastFragment();
        if (lastFragment2 instanceof DynamicPageFragment) {
            ((DynamicPageFragment) lastFragment2).doCommands(arrayList, new ViewDataObject(), null);
            return;
        }
        Iterator<DynamicPageCommandObject> it = arrayList.iterator();
        while (it.hasNext()) {
            DynamicPageCommandObject next = it.next();
            if (next.type == DynamicPageCommandObject.TypeEnum.GoLink && (goLinkData = next.go_link_data) != null && goLinkData.link != null) {
                try {
                    new MainClickHandler().onLinkClick(null, next.go_link_data.link);
                } catch (Exception unused2) {
                }
            }
        }
    }

    public void openImageViewer(BaseFragment baseFragment, ArrayList<ImageLinkObject> arrayList, String str, int i) {
        ArrayList arrayList2 = new ArrayList();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ImageLinkObject imageLinkObject = arrayList.get(size);
            arrayList2.add(new ImageObject(imageLinkObject.image_url, imageLinkObject.link));
        }
        ScrollViewListObject scrollViewListObject = new ScrollViewListObject((ArrayList<PresenterItem>) arrayList2, MainPresenterSelector.getInstance(ApplicationLoader.applicationContext));
        scrollViewListObject.onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.presenter.MainClickHandler.19
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                Titem titem = abstractViewHolder.item;
                if (!(titem instanceof ImageObject) || ((ImageObject) titem).link == null) {
                    return;
                }
                MainClickHandler.this.onLinkClick(null, ((ImageObject) titem).link);
            }
        };
        if (i < 0) {
            i = 0;
        }
        scrollViewListObject.lastPosition = (arrayList2.size() - 1) - (i < arrayList2.size() ? i : 0);
        baseFragment.presentFragment(new ImageListFragment(scrollViewListObject, str));
    }

    public MessengerLinkHandler getMessengerLinkHandler() {
        return AccountInstance.getInstance(UserConfig.selectedAccount).getMessengerLinkHandler();
    }

    public void openChat(ObjectInfo objectInfo) {
        if (objectInfo != null) {
            getMessengerLinkHandler().openChat(getLastFragment(), objectInfo.objectGuid, objectInfo.objectType, 0L, false, false);
        }
    }

    public BaseFragment getLastFragment() {
        if (ApplicationLoader.applicationActivity == null || ApplicationLoader.applicationActivity.getActionBarLayout() == null || ApplicationLoader.applicationActivity.getActionBarLayout().getLastFragment() == null) {
            return null;
        }
        return ApplicationLoader.applicationActivity.getActionBarLayout().getLastFragment();
    }

    public void onMessengerUsernameClicked(String str) {
        onMessengerUsernameClicked(str, false, false, null, null);
    }

    public void onMessengerUsernameClicked(String str, boolean z, boolean z2, String str2, String str3) {
        getMessengerLinkHandler().onMessengerUsernameClicked(getLastFragment(), str, z, z2, str2, str3);
    }

    public void onCopyClicked(String str) {
        onCopyClicked(str, null);
    }

    public void onCopyClicked(String str, String str2) {
        if (str == null) {
            return;
        }
        try {
            ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", str));
            String string = LocaleController.getString("copyied", R.string.copyied);
            if (str2 == null) {
                str2 = string;
            }
            ToastiLikeSnack.showMessageLikeToast(str2);
        } catch (Exception unused) {
        }
    }

    public void onInstaBlockClick(InstaProfileObject instaProfileObject, Context context, final View view) {
        final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(context, BuildConfig.FLAVOR);
        final InstaSetBlockProfileInput instaSetBlockProfileInput = new InstaSetBlockProfileInput(instaProfileObject.id);
        if (instaProfileObject.isBlocked) {
            instaSetBlockProfileInput.action = InstaSetBlockProfileInput.BlockActionEnum.Unblock;
            threeButtonDialog.textView.setText("آیا می خواهید این پروفایل را از مسدود بودن خارج کنید؟");
        } else {
            instaSetBlockProfileInput.action = InstaSetBlockProfileInput.BlockActionEnum.Block;
            threeButtonDialog.textView.setText("آیا می خواهید این پروفایل را مسدود کنید؟");
        }
        threeButtonDialog.button1.setText("بله");
        threeButtonDialog.button2.setText("انصراف");
        threeButtonDialog.button1.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenter.MainClickHandler.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                View view3 = view;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                threeButtonDialog.dismiss();
                ApiRequestMessanger.getInstance(UserConfig.selectedAccount).instaSetBlockProfile(instaSetBlockProfileInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.presenter.MainClickHandler.20.1
                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onResponse(Call call, Object obj) {
                        View view4 = view;
                        if (view4 != null) {
                            view4.setVisibility(4);
                        }
                        if (ApplicationLoader.applicationActivity != null) {
                            ApplicationLoader.applicationActivity.onBackPressed();
                        }
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onFailure(Call call, Throwable th) {
                        View view4 = view;
                        if (view4 != null) {
                            view4.setVisibility(4);
                        }
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onError(MessangerOutput messangerOutput) {
                        View view4 = view;
                        if (view4 != null) {
                            view4.setVisibility(4);
                        }
                    }
                });
            }
        });
        threeButtonDialog.button2.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenter.MainClickHandler.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                threeButtonDialog.dismiss();
            }
        });
        threeButtonDialog.show();
    }

    private void showProfileListDialog(final BaseFragment baseFragment, final boolean z) {
        LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
        if (launchActivity == null) {
            return;
        }
        UILinearLayout uILinearLayout = new UILinearLayout();
        uILinearLayout.createView(launchActivity);
        uILinearLayout.linearLayout.setBackgroundColor(Theme.getColor(Theme.key_dialogBackground));
        uILinearLayout.linearLayout.removeAllViews();
        RubinoMyProfilesRowInSettingPresenter rubinoMyProfilesRowInSettingPresenter = new RubinoMyProfilesRowInSettingPresenter(launchActivity);
        ArrayList<RubinoProfileObject> arrayList = AppRubinoPreferences.getInstance(AndroidUtilities.getCurrentAccountTemporary()).getProfilesOutput2().profiles;
        TextView textView = new TextView(launchActivity);
        textView.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView.setGravity(5);
        textView.setTextSize(1, 13.0f);
        textView.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
        textView.setText(LocaleController.getString("rubinoPleaseSelectAPage", R.string.rubinoPleaseSelectAPage));
        uILinearLayout.linearLayout.addView(textView);
        Iterator<RubinoProfileObject> it = arrayList.iterator();
        while (it.hasNext()) {
            RubinoProfileObject next = it.next();
            if (next.isDefault()) {
                uILinearLayout.linearLayout.addView(rubinoMyProfilesRowInSettingPresenter.createViewHolderAndBind(RubinoProfileObject.convertToOldObject(next)).itemView, 1);
            } else {
                uILinearLayout.linearLayout.addView(rubinoMyProfilesRowInSettingPresenter.createViewHolderAndBind(RubinoProfileObject.convertToOldObject(next)).itemView);
            }
        }
        final JustLinearLayoutDialog justLinearLayoutDialog = new JustLinearLayoutDialog(launchActivity, uILinearLayout.view);
        rubinoMyProfilesRowInSettingPresenter.onItemSelected = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenter.MainClickHandler.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JustLinearLayoutDialog justLinearLayoutDialog2 = justLinearLayoutDialog;
                if (justLinearLayoutDialog2 != null) {
                    justLinearLayoutDialog2.dismiss();
                }
                RubinoMyProfilesRowInSettingPresenter.ViewHolder viewHolder = (RubinoMyProfilesRowInSettingPresenter.ViewHolder) view.getTag();
                if (((InstaProfileObject) viewHolder.item).getPresenterType() == PresenterItemType.instaProfile) {
                    if (z) {
                        baseFragment.presentFragment(new StorySettingsActivity((InstaProfileObject) viewHolder.item));
                    } else {
                        baseFragment.presentFragment(new RubinoSettingsActivity((InstaProfileObject) viewHolder.item));
                    }
                }
            }
        };
        justLinearLayoutDialog.show();
    }

    public void directPost(RubinoPostObject rubinoPostObject) {
        try {
            ApplicationLoader.applicationActivity.getLastFragment().showDialog(new RubinoSharePostDialog(UserConfig.selectedAccount, ApplicationLoader.applicationActivity, rubinoPostObject, null));
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public void directStory(StoryObject storyObject) {
        ApplicationLoader.applicationActivity.getLastFragment().showDialog(new RubinoSharePostDialog(UserConfig.selectedAccount, ApplicationLoader.applicationActivity, null, storyObject));
    }

    public void openProductDetail(ProductMessageData productMessageData) {
        if (productMessageData == null) {
            return;
        }
        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new ProductDetailFragment(productMessageData.store_id, productMessageData.product_id));
    }

    public void addRubinoPost() {
        final BaseFragment lastFragment;
        final BaseFragment rubinoAddPostFragment;
        if (ApplicationLoader.applicationActivity == null || (lastFragment = ApplicationLoader.applicationActivity.getLastFragment()) == null || !RubinoController.getInstance(UserConfig.selectedAccount).hasPermissionAddPost()) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                rubinoAddPostFragment = new RGHAddPostActivity();
            } else {
                rubinoAddPostFragment = new RubinoAddPostFragment();
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.presenter.MainClickHandler$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    lastFragment.presentFragment(rubinoAddPostFragment);
                }
            });
        } catch (Exception unused) {
        }
    }

    public static MainClickHandler getInstance() {
        if (Instance == null) {
            synchronized (MessagesController.class) {
                if (Instance == null) {
                    Instance = new MainClickHandler();
                }
            }
        }
        return Instance;
    }
}
