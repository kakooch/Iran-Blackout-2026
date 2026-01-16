package ir.resaneh1.iptv.fragment;

import android.text.SpannableString;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.model.EmojiSliderObject;
import ir.resaneh1.iptv.model.RubinoClockObject;
import ir.resaneh1.iptv.model.RubinoDateObject;
import ir.resaneh1.iptv.model.RubinoEmojiObject;
import ir.resaneh1.iptv.model.RubinoHashTagObject;
import ir.resaneh1.iptv.model.RubinoMentionObject;
import ir.resaneh1.iptv.model.StoryEntityItem;
import ir.resaneh1.iptv.model.StoryEntityItemArray;
import ir.resaneh1.iptv.model.StoryLinkObject;
import ir.resaneh1.iptv.model.StoryTextAttributeObject;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.RubinoEntityArrayEmojiPresenter;
import ir.resaneh1.iptv.story.ClockSticker;
import ir.resaneh1.iptv.story.DateSticker;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.EmojiData;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes3.dex */
public class RubinoStickerAndWidgetListFragment extends PresenterFragment implements NotificationCenter.NotificationCenterDelegate {
    RubinoEntityArrayEmojiPresenter.SelectItemListner selectItemListener;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_just_recycler;
    }

    public RubinoStickerAndWidgetListFragment(RubinoEntityArrayEmojiPresenter.SelectItemListner selectItemListner) {
        this.selectItemListener = selectItemListner;
        this.isForceBlackTheme = true;
        this.fragmentName = "RubinoStickerAndWidgetListFragment";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        return super.onFragmentCreate();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        super.onFragmentDestroy();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        initWithVerticalLinearLayoutManager();
        this.progressBar.setVisibility(4);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.RubinoStickerAndWidgetListFragment.1
            RubinoEntityArrayEmojiPresenter presenter1;
            RubinoEntityArrayEmojiPresenter presenter2;

            {
                this.presenter1 = new RubinoEntityArrayEmojiPresenter(RubinoStickerAndWidgetListFragment.this.mContext, AndroidUtilities.dp(12.0f), 3, RubinoStickerAndWidgetListFragment.this.selectItemListener);
                this.presenter2 = new RubinoEntityArrayEmojiPresenter(RubinoStickerAndWidgetListFragment.this.mContext, AndroidUtilities.dp(4.0f), 6, RubinoStickerAndWidgetListFragment.this.selectItemListener);
            }

            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.rubinoEntityArraySticker) {
                    return this.presenter1;
                }
                if (presenterItemType == PresenterItemType.rubinoEntityArrayEmoji) {
                    return this.presenter2;
                }
                return MainPresenterSelector.getInstance(RubinoStickerAndWidgetListFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, new OnPresenterItemClickListener(this) { // from class: ir.resaneh1.iptv.fragment.RubinoStickerAndWidgetListFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                abstractViewHolder.item.getPresenterType();
                PresenterItemType presenterItemType = PresenterItemType.rubinoEntityArraySticker;
            }
        }, null);
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        this.mainRecyclerView.setFadingEdgeLength(AndroidUtilities.dp(40.0f));
        this.mainRecyclerView.setVerticalFadingEdgeEnabled(true);
    }

    public void updateArray(ArrayList<StoryEntityItemArray> arrayList) {
        this.progressBar.setVisibility(4);
        this.mainArrayList.clear();
        this.mainArrayList.addAll(arrayList);
        this.mainAdapter.notifyDataSetChanged();
    }

    public void createTestEntity(final Long l) {
        final ArrayList arrayList = new ArrayList();
        ((PresenterFragment) this).compositeDisposable.add((Disposable) Observable.just(1L).observeOn(Schedulers.io()).doOnNext(new Consumer<Long>() { // from class: ir.resaneh1.iptv.fragment.RubinoStickerAndWidgetListFragment.5
            @Override // io.reactivex.functions.Consumer
            public void accept(Long l2) throws Exception {
                PresenterItemType presenterItemType = PresenterItemType.rubinoEntityArraySticker;
                StoryEntityItemArray storyEntityItemArray = new StoryEntityItemArray(presenterItemType);
                storyEntityItemArray.array = new ArrayList<>();
                StoryEntityItem storyEntityItem = new StoryEntityItem();
                storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.hashtagPreview;
                StoryTextAttributeObject.BackGroundType backGroundType = StoryTextAttributeObject.BackGroundType.rounded;
                StoryTextAttributeObject.TextFontEnum textFontEnum = StoryTextAttributeObject.TextFontEnum.classic;
                StoryTextAttributeObject.TextAlignmentEnum textAlignmentEnum = StoryTextAttributeObject.TextAlignmentEnum.center;
                RubinoHashTagObject rubinoHashTagObject = new RubinoHashTagObject(new StoryTextAttributeObject(backGroundType, textFontEnum, textAlignmentEnum, 18, -1, StoryTextAttributeObject.TextColorTypeEnum.twoColorPink));
                storyEntityItem.hashTagObject = rubinoHashTagObject;
                rubinoHashTagObject.textAttributeObject.spannableString = new SpannableString("#HASHTAG");
                storyEntityItem.hashTagObject.textAttributeObject.textSizeInDp = 20;
                storyEntityItemArray.array.add(storyEntityItem);
                StoryEntityItem storyEntityItem2 = new StoryEntityItem();
                storyEntityItem2.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.mentionPreview;
                RubinoMentionObject rubinoMentionObject = new RubinoMentionObject(new StoryTextAttributeObject(backGroundType, textFontEnum, textAlignmentEnum, 18, -1, StoryTextAttributeObject.TextColorTypeEnum.twoColorOrange));
                storyEntityItem2.mentionObject = rubinoMentionObject;
                rubinoMentionObject.textAttributeObject.spannableString = new SpannableString("@MENTION");
                storyEntityItem2.mentionObject.textAttributeObject.textSizeInDp = 20;
                storyEntityItemArray.array.add(storyEntityItem2);
                StoryEntityItem storyEntityItem3 = new StoryEntityItem();
                storyEntityItem3.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.pollPreview;
                storyEntityItemArray.array.add(storyEntityItem3);
                arrayList.add(storyEntityItemArray);
                StoryEntityItemArray storyEntityItemArray2 = new StoryEntityItemArray(presenterItemType);
                storyEntityItemArray2.array = new ArrayList<>();
                StoryEntityItem storyEntityItem4 = new StoryEntityItem();
                storyEntityItem4.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.emojiSliderPreview;
                storyEntityItem4.emojiSliderObject = new EmojiSliderObject();
                storyEntityItemArray2.array.add(storyEntityItem4);
                StoryEntityItem storyEntityItem5 = new StoryEntityItem();
                storyEntityItem5.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.linkPreview;
                storyEntityItem5.storyLinkObject = new StoryLinkObject();
                storyEntityItem5.linkTextAttribute = new StoryTextAttributeObject(backGroundType, textFontEnum, textAlignmentEnum, 24, -1, StoryTextAttributeObject.TextColorTypeEnum.twoColorBlue);
                storyEntityItem5.storyLinkObject.text = LocaleController.getString(R.string.rubinoStoryLinkDefault);
                storyEntityItemArray2.array.add(storyEntityItem5);
                if (l.longValue() > 0) {
                    StoryEntityItem storyEntityItem6 = new StoryEntityItem();
                    if (System.currentTimeMillis() - l.longValue() < 86400000) {
                        storyEntityItem6.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.clockPreview;
                        storyEntityItem6.clockObject = new RubinoClockObject(ClockSticker.ClockMode.TEXTUAL_GRAY, l.longValue(), 80);
                    } else {
                        storyEntityItem6.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.datePreview;
                        storyEntityItem6.dateObject = new RubinoDateObject(DateSticker.DateTheme.WHITE, l.longValue(), 80);
                    }
                    storyEntityItemArray2.array.add(storyEntityItem6);
                }
                arrayList.add(storyEntityItemArray2);
                new StoryEntityItemArray(presenterItemType).array = new ArrayList<>();
                arrayList.addAll(RubinoStickerAndWidgetListFragment.this.getEmojiArray());
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Long>() { // from class: ir.resaneh1.iptv.fragment.RubinoStickerAndWidgetListFragment.4
            @Override // io.reactivex.functions.Consumer
            public void accept(Long l2) throws Exception {
                RubinoStickerAndWidgetListFragment.this.updateArray(arrayList);
            }
        }).subscribeWith(new DisposableObserver<Long>(this) { // from class: ir.resaneh1.iptv.fragment.RubinoStickerAndWidgetListFragment.3
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l2) {
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<StoryEntityItemArray> getEmojiArray() {
        ArrayList<StoryEntityItemArray> arrayList = new ArrayList<>();
        StoryEntityItemArray storyEntityItemArray = new StoryEntityItemArray(PresenterItemType.rubinoEntityArrayEmoji);
        storyEntityItemArray.array = new ArrayList<>();
        arrayList.add(storyEntityItemArray);
        int i = 0;
        for (String[] strArr : EmojiData.dataColored) {
            for (String str : strArr) {
                if (i == 6) {
                    storyEntityItemArray = new StoryEntityItemArray(PresenterItemType.rubinoEntityArrayEmoji);
                    storyEntityItemArray.array = new ArrayList<>();
                    arrayList.add(storyEntityItemArray);
                    i = 0;
                }
                StoryEntityItem storyEntityItem = new StoryEntityItem();
                storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.emoji;
                storyEntityItem.emojiObject = new RubinoEmojiObject(str);
                storyEntityItemArray.array.add(storyEntityItem);
                i++;
            }
        }
        return arrayList;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        MainAdapter mainAdapter;
        if (i != NotificationCenter.emojiDidLoad || (mainAdapter = this.mainAdapter) == null) {
            return;
        }
        mainAdapter.notifyDataSetChanged();
    }
}
