package org.rbmain.ui.Adapters;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$MessagesFilter;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterDocument;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterMusic;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterPhotoVideo;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterRoundVoice;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterUrl;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class FiltersView extends RecyclerListView {
    DiffUtil.Callback diffUtilsCallback;
    LinearLayoutManager layoutManager;
    private ArrayList<MediaFilterData> oldItems;
    private ArrayList<MediaFilterData> usersFilters;
    public static final MediaFilterData[] filters = {new MediaFilterData(R.drawable.search_media_filled, R.string.SharedMediaTab2, new TLRPC$TL_inputMessagesFilterPhotoVideo(), 0), new MediaFilterData(R.drawable.search_links_filled, R.string.SharedLinksTab2, new TLRPC$TL_inputMessagesFilterUrl(), 2), new MediaFilterData(R.drawable.search_files_filled, R.string.SharedFilesTab2, new TLRPC$TL_inputMessagesFilterDocument(), 1), new MediaFilterData(R.drawable.search_music_filled, R.string.SharedMusicTab2, new TLRPC$TL_inputMessagesFilterMusic(), 3), new MediaFilterData(R.drawable.search_voice_filled, R.string.SharedVoiceTab2, new TLRPC$TL_inputMessagesFilterRoundVoice(), 5)};
    private static final Pattern yearPatter = Pattern.compile("20[0-9]{1,2}");
    private static final Pattern monthYearOrDayPatter = Pattern.compile("(\\w{3,}) ([0-9]{0,4})");
    private static final Pattern yearOrDayAndMonthPatter = Pattern.compile("([0-9]{0,4}) (\\w{2,})");
    private static final Pattern shortDate = Pattern.compile("^([0-9]{1,4})(\\.| |/|\\-)([0-9]{1,4})$");
    private static final Pattern longDate = Pattern.compile("^([0-9]{1,2})(\\.| |/|\\-)([0-9]{1,2})(\\.| |/|\\-)([0-9]{1,4})$");
    private static final int[] numberOfDaysEachMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public FiltersView(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context, resourcesProvider);
        this.usersFilters = new ArrayList<>();
        this.oldItems = new ArrayList<>();
        this.diffUtilsCallback = new DiffUtil.Callback() { // from class: org.rbmain.ui.Adapters.FiltersView.4
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                return true;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return FiltersView.this.oldItems.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return FiltersView.this.usersFilters.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                MediaFilterData mediaFilterData = (MediaFilterData) FiltersView.this.oldItems.get(i);
                MediaFilterData mediaFilterData2 = (MediaFilterData) FiltersView.this.usersFilters.get(i2);
                if (mediaFilterData.isSameType(mediaFilterData2)) {
                    int i3 = mediaFilterData.filterType;
                    if (i3 == 4) {
                        TLObject tLObject = mediaFilterData.chat;
                        if (tLObject instanceof TLRPC$User) {
                            TLObject tLObject2 = mediaFilterData2.chat;
                            if (tLObject2 instanceof TLRPC$User) {
                                return ((TLRPC$User) tLObject).id == ((TLRPC$User) tLObject2).id;
                            }
                        }
                        if (tLObject instanceof TLRPC$Chat) {
                            TLObject tLObject3 = mediaFilterData2.chat;
                            return (tLObject3 instanceof TLRPC$Chat) && ((TLRPC$Chat) tLObject).id == ((TLRPC$Chat) tLObject3).id;
                        }
                    } else {
                        if (i3 == 6) {
                            return mediaFilterData.title.equals(mediaFilterData2.title);
                        }
                        if (i3 == 7) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: org.rbmain.ui.Adapters.FiltersView.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
                if (FiltersView.this.isEnabled()) {
                    return;
                }
                accessibilityNodeInfoCompat.setVisibleToUser(false);
            }
        };
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        setLayoutManager(this.layoutManager);
        setAdapter(new Adapter());
        addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: org.rbmain.ui.Adapters.FiltersView.2
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                super.getItemOffsets(rect, view, recyclerView, state);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                rect.left = AndroidUtilities.dp(8.0f);
                if (childAdapterPosition == state.getItemCount() - 1) {
                    rect.right = AndroidUtilities.dp(10.0f);
                }
                if (childAdapterPosition == 0) {
                    rect.left = AndroidUtilities.dp(10.0f);
                }
            }
        });
        setItemAnimator(new DefaultItemAnimator(this) { // from class: org.rbmain.ui.Adapters.FiltersView.3
            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected long getAddAnimationDelay(long j, long j2, long j3) {
                return 0L;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
            public long getAddDuration() {
                return 220L;
            }

            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected long getMoveAnimationDelay() {
                return 0L;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
            public long getMoveDuration() {
                return 220L;
            }

            @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
            public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
                boolean zAnimateAdd = super.animateAdd(viewHolder);
                if (zAnimateAdd) {
                    viewHolder.itemView.setScaleX(0.0f);
                    viewHolder.itemView.setScaleY(0.0f);
                }
                return zAnimateAdd;
            }

            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            public void animateAddImpl(final RecyclerView.ViewHolder viewHolder) {
                final View view = viewHolder.itemView;
                final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                this.mAddAnimations.add(viewHolder);
                viewPropertyAnimatorAnimate.alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(getAddDuration()).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Adapters.FiltersView.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        dispatchAddStarting(viewHolder);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        view.setAlpha(1.0f);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        viewPropertyAnimatorAnimate.setListener(null);
                        dispatchAddFinished(viewHolder);
                        ((DefaultItemAnimator) AnonymousClass3.this).mAddAnimations.remove(viewHolder);
                        dispatchFinishedWhenDone();
                    }
                }).start();
            }

            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected void animateRemoveImpl(final RecyclerView.ViewHolder viewHolder) {
                final View view = viewHolder.itemView;
                final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                this.mRemoveAnimations.add(viewHolder);
                viewPropertyAnimatorAnimate.setDuration(getRemoveDuration()).alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Adapters.FiltersView.3.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        dispatchRemoveStarting(viewHolder);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        viewPropertyAnimatorAnimate.setListener(null);
                        view.setAlpha(1.0f);
                        view.setTranslationX(0.0f);
                        view.setTranslationY(0.0f);
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f);
                        dispatchRemoveFinished(viewHolder);
                        ((DefaultItemAnimator) AnonymousClass3.this).mRemoveAnimations.remove(viewHolder);
                        dispatchFinishedWhenDone();
                    }
                }).start();
            }
        });
        setWillNotDraw(false);
        setHideIfEmpty(false);
        setSelectorRadius(AndroidUtilities.dp(28.0f));
        setSelectorDrawableColor(getThemedColor(Theme.key_listSelector));
    }

    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(44.0f), 1073741824));
    }

    public MediaFilterData getFilterAt(int i) {
        if (this.usersFilters.isEmpty()) {
            return filters[i];
        }
        return this.usersFilters.get(i);
    }

    public void setUsersAndDates(ArrayList<Object> arrayList, ArrayList<DateData> arrayList2, boolean z) {
        String name;
        this.oldItems.clear();
        this.oldItems.addAll(this.usersFilters);
        this.usersFilters.clear();
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof TLRPC$User) {
                    TLRPC$User tLRPC$User = (TLRPC$User) obj;
                    if (UserConfig.getInstance(UserConfig.selectedAccount).getCurrentUser().id == tLRPC$User.id) {
                        name = LocaleController.getString("SavedMessages", R.string.SavedMessages);
                    } else {
                        name = ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name, 10);
                    }
                    MediaFilterData mediaFilterData = new MediaFilterData(R.drawable.search_users_filled, name, (TLRPC$MessagesFilter) null, 4);
                    mediaFilterData.setUser(tLRPC$User);
                    this.usersFilters.add(mediaFilterData);
                } else if (obj instanceof TLRPC$Chat) {
                    TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) obj;
                    String str = tLRPC$Chat.title;
                    if (str.length() > 12) {
                        str = String.format("%s...", str.substring(0, 10));
                    }
                    MediaFilterData mediaFilterData2 = new MediaFilterData(R.drawable.search_users_filled, str, (TLRPC$MessagesFilter) null, 4);
                    mediaFilterData2.setUser(tLRPC$Chat);
                    this.usersFilters.add(mediaFilterData2);
                }
            }
        }
        if (arrayList2 != null) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                DateData dateData = arrayList2.get(i2);
                MediaFilterData mediaFilterData3 = new MediaFilterData(R.drawable.search_date_filled, dateData.title, (TLRPC$MessagesFilter) null, 6);
                mediaFilterData3.setDate(dateData);
                this.usersFilters.add(mediaFilterData3);
            }
        }
        if (z) {
            this.usersFilters.add(new MediaFilterData(R.drawable.chats_archive, R.string.ArchiveSearchFilter, (TLRPC$MessagesFilter) null, 7));
        }
        if (getAdapter() != null) {
            UpdateCallback updateCallback = new UpdateCallback(getAdapter());
            DiffUtil.calculateDiff(this.diffUtilsCallback).dispatchUpdatesTo(updateCallback);
            if (this.usersFilters.isEmpty() || !updateCallback.changed) {
                return;
            }
            this.layoutManager.scrollToPositionWithOffset(0, 0);
        }
    }

    public static void fillTipDates(String str, ArrayList<DateData> arrayList) throws NumberFormatException {
        arrayList.clear();
        if (str == null) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.length() < 3) {
            return;
        }
        if (LocaleController.getString("SearchTipToday", R.string.SearchTipToday).toLowerCase().startsWith(strTrim) || "today".startsWith(strTrim)) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            int i3 = calendar.get(5);
            calendar.set(i, i2, i3, 0, 0, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.set(i, i2, i3 + 1, 0, 0, 0);
            arrayList.add(new DateData(LocaleController.getString("SearchTipToday", R.string.SearchTipToday), timeInMillis, calendar.getTimeInMillis() - 1));
            return;
        }
        if (LocaleController.getString("SearchTipYesterday", R.string.SearchTipYesterday).toLowerCase().startsWith(strTrim) || "yesterday".startsWith(strTrim)) {
            Calendar calendar2 = Calendar.getInstance();
            int i4 = calendar2.get(1);
            int i5 = calendar2.get(2);
            int i6 = calendar2.get(5);
            calendar2.set(i4, i5, i6, 0, 0, 0);
            long timeInMillis2 = calendar2.getTimeInMillis() - 86400000;
            calendar2.set(i4, i5, i6 + 1, 0, 0, 0);
            arrayList.add(new DateData(LocaleController.getString("SearchTipYesterday", R.string.SearchTipYesterday), timeInMillis2, calendar2.getTimeInMillis() - 86400001));
            return;
        }
        int dayOfWeek = getDayOfWeek(strTrim);
        if (dayOfWeek >= 0) {
            Calendar calendar3 = Calendar.getInstance();
            long timeInMillis3 = calendar3.getTimeInMillis();
            calendar3.set(7, dayOfWeek);
            if (calendar3.getTimeInMillis() > timeInMillis3) {
                calendar3.setTimeInMillis(calendar3.getTimeInMillis() - 604800000);
            }
            int i7 = calendar3.get(1);
            int i8 = calendar3.get(2);
            int i9 = calendar3.get(5);
            calendar3.set(i7, i8, i9, 0, 0, 0);
            long timeInMillis4 = calendar3.getTimeInMillis();
            calendar3.set(i7, i8, i9 + 1, 0, 0, 0);
            arrayList.add(new DateData(LocaleController.getInstance().formatterWeekLong.format(timeInMillis4), timeInMillis4, calendar3.getTimeInMillis() - 1));
            return;
        }
        Matcher matcher = shortDate.matcher(strTrim);
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(3);
            int i10 = Integer.parseInt(strGroup);
            int i11 = Integer.parseInt(strGroup2);
            if (i10 <= 0 || i10 > 31) {
                if (i10 < 2013 || i11 > 12) {
                    return;
                }
                createForMonthYear(arrayList, i11 - 1, i10);
                return;
            }
            if (i11 >= 2013 && i10 <= 12) {
                createForMonthYear(arrayList, i10 - 1, i11);
                return;
            } else {
                if (i11 <= 12) {
                    createForDayMonth(arrayList, i10 - 1, i11 - 1);
                    return;
                }
                return;
            }
        }
        Matcher matcher2 = longDate.matcher(strTrim);
        if (matcher2.matches()) {
            String strGroup3 = matcher2.group(1);
            String strGroup4 = matcher2.group(3);
            String strGroup5 = matcher2.group(5);
            if (matcher2.group(2).equals(matcher2.group(4))) {
                int i12 = Integer.parseInt(strGroup3);
                int i13 = Integer.parseInt(strGroup4) - 1;
                int i14 = Integer.parseInt(strGroup5);
                if (i14 >= 10 && i14 <= 99) {
                    i14 += 2000;
                }
                int i15 = Calendar.getInstance().get(1);
                if (!validDateForMont(i12 - 1, i13) || i14 < 2013 || i14 > i15) {
                    return;
                }
                Calendar calendar4 = Calendar.getInstance();
                int i16 = i14;
                calendar4.set(i16, i13, i12, 0, 0, 0);
                long timeInMillis5 = calendar4.getTimeInMillis();
                calendar4.set(i16, i13, i12 + 1, 0, 0, 0);
                arrayList.add(new DateData(LocaleController.getInstance().formatterYearMax.format(timeInMillis5), timeInMillis5, calendar4.getTimeInMillis() - 1));
                return;
            }
            return;
        }
        if (yearPatter.matcher(strTrim).matches()) {
            int iIntValue = Integer.valueOf(strTrim).intValue();
            int i17 = Calendar.getInstance().get(1);
            if (iIntValue < 2013) {
                while (i17 >= 2013) {
                    Calendar calendar5 = Calendar.getInstance();
                    calendar5.set(i17, 0, 1, 0, 0, 0);
                    long timeInMillis6 = calendar5.getTimeInMillis();
                    calendar5.set(i17 + 1, 0, 1, 0, 0, 0);
                    arrayList.add(new DateData(Integer.toString(i17), timeInMillis6, calendar5.getTimeInMillis() - 1));
                    i17--;
                }
                return;
            }
            if (iIntValue <= i17) {
                Calendar calendar6 = Calendar.getInstance();
                calendar6.set(iIntValue, 0, 1, 0, 0, 0);
                long timeInMillis7 = calendar6.getTimeInMillis();
                calendar6.set(iIntValue + 1, 0, 1, 0, 0, 0);
                arrayList.add(new DateData(Integer.toString(iIntValue), timeInMillis7, calendar6.getTimeInMillis() - 1));
                return;
            }
            return;
        }
        Matcher matcher3 = monthYearOrDayPatter.matcher(strTrim);
        if (matcher3.matches()) {
            String strGroup6 = matcher3.group(1);
            String strGroup7 = matcher3.group(2);
            int month = getMonth(strGroup6);
            if (month >= 0) {
                int iIntValue2 = Integer.valueOf(strGroup7).intValue();
                if (iIntValue2 > 0 && iIntValue2 <= 31) {
                    createForDayMonth(arrayList, iIntValue2 - 1, month);
                    return;
                } else if (iIntValue2 >= 2013) {
                    createForMonthYear(arrayList, month, iIntValue2);
                    return;
                }
            }
        }
        Matcher matcher4 = yearOrDayAndMonthPatter.matcher(strTrim);
        if (matcher4.matches()) {
            String strGroup8 = matcher4.group(1);
            int month2 = getMonth(matcher4.group(2));
            if (month2 >= 0) {
                int iIntValue3 = Integer.valueOf(strGroup8).intValue();
                if (iIntValue3 > 0 && iIntValue3 <= 31) {
                    createForDayMonth(arrayList, iIntValue3 - 1, month2);
                    return;
                } else if (iIntValue3 >= 2013) {
                    createForMonthYear(arrayList, month2, iIntValue3);
                }
            }
        }
        if (TextUtils.isEmpty(strTrim) || strTrim.length() <= 2) {
            return;
        }
        int month3 = getMonth(strTrim);
        long timeInMillis8 = Calendar.getInstance().getTimeInMillis();
        if (month3 >= 0) {
            for (int i18 = Calendar.getInstance().get(1); i18 >= 2013; i18--) {
                Calendar calendar7 = Calendar.getInstance();
                calendar7.set(i18, month3, 1, 0, 0, 0);
                long timeInMillis9 = calendar7.getTimeInMillis();
                if (timeInMillis9 <= timeInMillis8) {
                    calendar7.add(2, 1);
                    arrayList.add(new DateData(LocaleController.getInstance().formatterMonthYear.format(timeInMillis9), timeInMillis9, calendar7.getTimeInMillis() - 1));
                }
            }
        }
    }

    private static void createForMonthYear(ArrayList<DateData> arrayList, int i, int i2) {
        int i3 = Calendar.getInstance().get(1);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (i2 < 2013 || i2 > i3) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i2, i, 1, 0, 0, 0);
        long timeInMillis2 = calendar.getTimeInMillis();
        if (timeInMillis2 > timeInMillis) {
            return;
        }
        calendar.add(2, 1);
        arrayList.add(new DateData(LocaleController.getInstance().formatterMonthYear.format(timeInMillis2), timeInMillis2, calendar.getTimeInMillis() - 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void createForDayMonth(java.util.ArrayList<org.rbmain.ui.Adapters.FiltersView.DateData> r26, int r27, int r28) {
        /*
            r0 = r26
            r1 = r27
            boolean r2 = validDateForMont(r27, r28)
            if (r2 == 0) goto La9
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            r3 = 1
            int r2 = r2.get(r3)
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            long r4 = r4.getTimeInMillis()
            java.util.Calendar r6 = java.util.GregorianCalendar.getInstance()
            java.util.GregorianCalendar r6 = (java.util.GregorianCalendar) r6
            r14 = r2
        L22:
            r7 = 2013(0x7dd, float:2.821E-42)
            if (r14 < r7) goto La9
            r15 = r28
            if (r15 != r3) goto L35
            r7 = 28
            if (r1 != r7) goto L35
            boolean r7 = r6.isLeapYear(r14)
            if (r7 != 0) goto L35
            goto L4e
        L35:
            java.util.Calendar r16 = java.util.Calendar.getInstance()
            int r10 = r1 + 1
            r11 = 0
            r12 = 0
            r13 = 0
            r7 = r16
            r8 = r14
            r9 = r28
            r7.set(r8, r9, r10, r11, r12, r13)
            long r12 = r16.getTimeInMillis()
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 <= 0) goto L51
        L4e:
            r24 = r4
            goto La2
        L51:
            int r10 = r1 + 2
            r11 = 0
            r17 = 0
            r18 = 0
            r7 = r16
            r8 = r14
            r9 = r28
            r24 = r4
            r3 = r12
            r12 = r17
            r13 = r18
            r7.set(r8, r9, r10, r11, r12, r13)
            long r7 = r16.getTimeInMillis()
            r9 = 1
            long r21 = r7 - r9
            if (r14 != r2) goto L8a
            org.rbmain.ui.Adapters.FiltersView$DateData r5 = new org.rbmain.ui.Adapters.FiltersView$DateData
            org.rbmain.messenger.LocaleController r7 = org.rbmain.messenger.LocaleController.getInstance()
            org.rbmain.messenger.time.FastDateFormat r7 = r7.formatterDayMonth
            java.lang.String r18 = r7.format(r3)
            r23 = 0
            r17 = r5
            r19 = r3
            r17.<init>(r18, r19, r21)
            r0.add(r5)
            goto La2
        L8a:
            org.rbmain.ui.Adapters.FiltersView$DateData r5 = new org.rbmain.ui.Adapters.FiltersView$DateData
            org.rbmain.messenger.LocaleController r7 = org.rbmain.messenger.LocaleController.getInstance()
            org.rbmain.messenger.time.FastDateFormat r7 = r7.formatterYearMax
            java.lang.String r18 = r7.format(r3)
            r23 = 0
            r17 = r5
            r19 = r3
            r17.<init>(r18, r19, r21)
            r0.add(r5)
        La2:
            int r14 = r14 + (-1)
            r4 = r24
            r3 = 1
            goto L22
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Adapters.FiltersView.createForDayMonth(java.util.ArrayList, int, int):void");
    }

    private static boolean validDateForMont(int i, int i2) {
        return i2 >= 0 && i2 < 12 && i >= 0 && i < numberOfDaysEachMonth[i2];
    }

    public static int getDayOfWeek(String str) {
        Calendar calendar = Calendar.getInstance();
        if (str.length() <= 3) {
            return -1;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        int i = 0;
        while (i < 7) {
            calendar.set(7, i);
            if (LocaleController.getInstance().formatterWeekLong.format(calendar.getTime()).toLowerCase().startsWith(str) || simpleDateFormat.format(calendar.getTime()).toLowerCase().startsWith(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int getMonth(String str) {
        String[] strArr = {LocaleController.getString("January", R.string.January).toLowerCase(), LocaleController.getString("February", R.string.February).toLowerCase(), LocaleController.getString("March", R.string.March).toLowerCase(), LocaleController.getString("April", R.string.April).toLowerCase(), LocaleController.getString("May", R.string.May).toLowerCase(), LocaleController.getString("June", R.string.June).toLowerCase(), LocaleController.getString("July", R.string.July).toLowerCase(), LocaleController.getString("August", R.string.August).toLowerCase(), LocaleController.getString("September", R.string.September).toLowerCase(), LocaleController.getString("October", R.string.October).toLowerCase(), LocaleController.getString("November", R.string.November).toLowerCase(), LocaleController.getString("December", R.string.December).toLowerCase()};
        String[] strArr2 = new String[12];
        Calendar calendar = Calendar.getInstance();
        for (int i = 1; i <= 12; i++) {
            calendar.set(0, 0, 0, 0, 0, 0);
            calendar.set(2, i);
            strArr2[i - 1] = calendar.getDisplayName(2, 2, Locale.ENGLISH).toLowerCase();
        }
        for (int i2 = 0; i2 < 12; i2++) {
            if (strArr2[i2].startsWith(str) || strArr[i2].startsWith(str)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, getMeasuredHeight() - 1, getMeasuredWidth(), getMeasuredHeight(), Theme.dividerPaint);
    }

    public void updateColors() {
        getRecycledViewPool().clear();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof FilterView) {
                ((FilterView) childAt).updateColors();
            }
        }
        for (int i2 = 0; i2 < getCachedChildCount(); i2++) {
            View cachedChildAt = getCachedChildAt(i2);
            if (cachedChildAt instanceof FilterView) {
                ((FilterView) cachedChildAt).updateColors();
            }
        }
        for (int i3 = 0; i3 < getAttachedScrapChildCount(); i3++) {
            View attachedScrapChildAt = getAttachedScrapChildAt(i3);
            if (attachedScrapChildAt instanceof FilterView) {
                ((FilterView) attachedScrapChildAt).updateColors();
            }
        }
        setSelectorDrawableColor(getThemedColor(Theme.key_listSelector));
    }

    private class Adapter extends RecyclerListView.SelectionAdapter {
        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        private Adapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ViewHolder viewHolder = new ViewHolder(FiltersView.this, new FilterView(viewGroup.getContext(), ((RecyclerListView) FiltersView.this).resourcesProvider));
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, AndroidUtilities.dp(32.0f));
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = AndroidUtilities.dp(6.0f);
            viewHolder.itemView.setLayoutParams(layoutParams);
            return viewHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
            ((ViewHolder) viewHolder).filterView.setData((MediaFilterData) FiltersView.this.usersFilters.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return FiltersView.this.usersFilters.size();
        }
    }

    public static class FilterView extends FrameLayout {
        BackupImageView avatarImageView;
        MediaFilterData data;
        private final Theme.ResourcesProvider resourcesProvider;
        CombinedDrawable thumbDrawable;
        TextView titleView;

        public FilterView(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context);
            this.resourcesProvider = resourcesProvider;
            BackupImageView backupImageView = new BackupImageView(context);
            this.avatarImageView = backupImageView;
            addView(backupImageView, LayoutHelper.createFrame(32, 32.0f));
            TextView textView = new TextView(context);
            this.titleView = textView;
            textView.setTextSize(1, 14.0f);
            addView(this.titleView, LayoutHelper.createFrame(-2, -2.0f, 16, 38.0f, 0.0f, 16.0f, 0.0f));
            updateColors();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateColors() {
            setBackground(Theme.createRoundRectDrawable(AndroidUtilities.dp(28.0f), getThemedColor(Theme.key_groupcreate_spanBackground)));
            this.titleView.setTextColor(getThemedColor(Theme.key_windowBackgroundWhiteBlackText));
            CombinedDrawable combinedDrawable = this.thumbDrawable;
            if (combinedDrawable != null) {
                if (this.data.filterType == 7) {
                    Theme.setCombinedDrawableColor(combinedDrawable, getThemedColor(Theme.key_avatar_backgroundArchived), false);
                    Theme.setCombinedDrawableColor(this.thumbDrawable, getThemedColor(Theme.key_avatar_actionBarIconBlue), true);
                } else {
                    Theme.setCombinedDrawableColor(combinedDrawable, getThemedColor(Theme.key_avatar_backgroundBlue), false);
                    Theme.setCombinedDrawableColor(this.thumbDrawable, getThemedColor(Theme.key_avatar_actionBarIconBlue), true);
                }
            }
        }

        public void setData(MediaFilterData mediaFilterData) throws Resources.NotFoundException {
            this.data = mediaFilterData;
            this.avatarImageView.getImageReceiver().clearImage();
            if (mediaFilterData.filterType == 7) {
                CombinedDrawable combinedDrawableCreateCircleDrawableWithIcon = Theme.createCircleDrawableWithIcon(AndroidUtilities.dp(32.0f), R.drawable.chats_archive);
                this.thumbDrawable = combinedDrawableCreateCircleDrawableWithIcon;
                combinedDrawableCreateCircleDrawableWithIcon.setIconSize(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f));
                Theme.setCombinedDrawableColor(this.thumbDrawable, getThemedColor(Theme.key_avatar_backgroundArchived), false);
                Theme.setCombinedDrawableColor(this.thumbDrawable, getThemedColor(Theme.key_avatar_actionBarIconBlue), true);
                this.avatarImageView.setImageDrawable(this.thumbDrawable);
                this.titleView.setText(mediaFilterData.title);
                return;
            }
            CombinedDrawable combinedDrawableCreateCircleDrawableWithIcon2 = Theme.createCircleDrawableWithIcon(AndroidUtilities.dp(32.0f), mediaFilterData.iconResFilled);
            this.thumbDrawable = combinedDrawableCreateCircleDrawableWithIcon2;
            Theme.setCombinedDrawableColor(combinedDrawableCreateCircleDrawableWithIcon2, getThemedColor(Theme.key_avatar_backgroundBlue), false);
            CombinedDrawable combinedDrawable = this.thumbDrawable;
            int i = Theme.key_avatar_actionBarIconBlue;
            Theme.setCombinedDrawableColor(combinedDrawable, getThemedColor(i), true);
            if (mediaFilterData.filterType == 4) {
                TLObject tLObject = mediaFilterData.chat;
                if (tLObject instanceof TLRPC$User) {
                    TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                    if (UserConfig.getInstance(UserConfig.selectedAccount).getCurrentUser().id == tLRPC$User.id) {
                        CombinedDrawable combinedDrawableCreateCircleDrawableWithIcon3 = Theme.createCircleDrawableWithIcon(AndroidUtilities.dp(32.0f), R.drawable.chats_saved);
                        combinedDrawableCreateCircleDrawableWithIcon3.setIconSize(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f));
                        Theme.setCombinedDrawableColor(combinedDrawableCreateCircleDrawableWithIcon3, getThemedColor(Theme.key_avatar_backgroundSaved), false);
                        Theme.setCombinedDrawableColor(combinedDrawableCreateCircleDrawableWithIcon3, getThemedColor(i), true);
                        this.avatarImageView.setImageDrawable(combinedDrawableCreateCircleDrawableWithIcon3);
                    } else {
                        this.avatarImageView.getImageReceiver().setRoundRadius(AndroidUtilities.dp(16.0f));
                        this.avatarImageView.getImageReceiver().setForUserOrChat(tLRPC$User, this.thumbDrawable);
                    }
                } else if (tLObject instanceof TLRPC$Chat) {
                    this.avatarImageView.getImageReceiver().setRoundRadius(AndroidUtilities.dp(16.0f));
                    this.avatarImageView.getImageReceiver().setForUserOrChat((TLRPC$Chat) tLObject, this.thumbDrawable);
                }
            } else {
                this.avatarImageView.setImageDrawable(this.thumbDrawable);
            }
            this.titleView.setText(mediaFilterData.title);
        }

        protected int getThemedColor(int i) {
            return Theme.getColor(i, this.resourcesProvider);
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        FilterView filterView;

        public ViewHolder(FiltersView filtersView, FilterView filterView) {
            super(filterView);
            this.filterView = filterView;
        }
    }

    public static class MediaFilterData {
        public TLObject chat;
        public DateData dateData;
        public final TLRPC$MessagesFilter filter;
        public final int filterType;
        public final int iconResFilled;
        public boolean removable = true;
        private String title;
        public int titleResId;

        public MediaFilterData(int i, String str, TLRPC$MessagesFilter tLRPC$MessagesFilter, int i2) {
            this.iconResFilled = i;
            this.title = str;
            this.filter = tLRPC$MessagesFilter;
            this.filterType = i2;
        }

        public MediaFilterData(int i, int i2, TLRPC$MessagesFilter tLRPC$MessagesFilter, int i3) {
            this.iconResFilled = i;
            this.titleResId = i2;
            this.filter = tLRPC$MessagesFilter;
            this.filterType = i3;
        }

        public String getTitle() {
            String str = this.title;
            return str != null ? str : LocaleController.getString(this.titleResId);
        }

        public void setUser(TLObject tLObject) {
            this.chat = tLObject;
        }

        public boolean isSameType(MediaFilterData mediaFilterData) {
            if (this.filterType == mediaFilterData.filterType) {
                return true;
            }
            return isMedia() && mediaFilterData.isMedia();
        }

        public boolean isMedia() {
            int i = this.filterType;
            return i == 0 || i == 1 || i == 2 || i == 3 || i == 5;
        }

        public void setDate(DateData dateData) {
            this.dateData = dateData;
        }
    }

    public static class DateData {
        public final long maxDate;
        public final long minDate;
        public final String title;

        private DateData(String str, long j, long j2) {
            this.title = str;
            this.minDate = j;
            this.maxDate = j2;
        }
    }

    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this, 0, null, null, null, null, Theme.key_graySection));
        arrayList.add(new ThemeDescription(this, 0, null, null, null, null, Theme.key_graySectionText));
        return arrayList;
    }

    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    private static class UpdateCallback implements ListUpdateCallback {
        final RecyclerView.Adapter adapter;
        boolean changed;

        private UpdateCallback(RecyclerView.Adapter adapter) {
            this.adapter = adapter;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i2) {
            this.changed = true;
            this.adapter.notifyItemRangeInserted(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            this.changed = true;
            this.adapter.notifyItemRangeRemoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i2) {
            this.changed = true;
            this.adapter.notifyItemMoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            this.adapter.notifyItemRangeChanged(i, i2, obj);
        }
    }
}
