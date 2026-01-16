package ir.resaneh1.iptv.helper;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.SizeObject;
import ir.resaneh1.iptv.model.TagObject;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.model.ViewTagObject;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class DimensionHelper {
    static Boolean needFullScreen;

    public static float getStoryHWRatio() {
        return 1.7777778f;
    }

    public static int getStoryHeight() {
        return 1280;
    }

    public static int getStoryWidth() {
        return 720;
    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static boolean isShowstoryNeedFullScreen() {
        Boolean bool = needFullScreen;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            if (ApplicationLoader.applicationActivity.topCutoutHeight > 0) {
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if ((i == 26 || i == 27) && AndroidUtilities.dp(24.0f) < AndroidUtilities.statusBarHeight) {
                Boolean bool2 = Boolean.FALSE;
                needFullScreen = bool2;
                return bool2.booleanValue();
            }
            if (getScreenMaxDimension(ApplicationLoader.applicationActivity) - ((int) (getScreenMinDimension(ApplicationLoader.applicationActivity) * getStoryHWRatio())) > AndroidUtilities.dp(100.0f)) {
                needFullScreen = Boolean.FALSE;
            } else {
                needFullScreen = Boolean.TRUE;
            }
            return needFullScreen.booleanValue();
        } catch (Exception unused) {
            return true;
        }
    }

    public static float getStoryViewHeightPx(Activity activity) {
        return getStoryViewWidthPx(activity) * getStoryHWRatio();
    }

    public static float getStoryViewWidthPx(Activity activity) {
        return getScreenMinDimension(activity);
    }

    public static int getScreenMinDimension(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static int getScreenMaxDimension(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static int getScreenStatusBarHeightIfNoCutoutAndNoNeedFullScreen() {
        if (ApplicationLoader.applicationActivity.topCutoutHeight != 0 || isShowstoryNeedFullScreen()) {
            return 0;
        }
        return AndroidUtilities.statusBarHeight;
    }

    public static int pxToDp(Context context, float f) {
        return (int) (f / context.getResources().getDisplayMetrics().density);
    }

    public static int dpToPx(Context context, float f) {
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }

    public static int calculateNoOfColumns(Context context, int i) {
        float f = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = (int) (f / i);
        MyLog.e("DimensionHelper", "calculateNoOfColumns:1 " + f + " " + i2 + " " + i);
        return i2;
    }

    public static int calculateSpaceBasedOnColumns(Context context, int i) {
        float f = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = (int) (f - (i * r0));
        MyLog.e("DimensionHelper", "calculateNoOfColumns:2 " + f + " " + ((int) (f / i)) + " " + i + " " + i2);
        return i2;
    }

    public static int calculateItemWidthBasedOnColumns(Context context, int i, int i2) {
        float f = context.getResources().getDisplayMetrics().widthPixels;
        float f2 = i2;
        int i3 = (int) (((f - f2) / i) - f2);
        MyLog.e("DimensionHelper", "calculateNoOfColumns:3 " + f + " " + i2 + " " + i3 + " " + i);
        return i3;
    }

    public static int getItemImageWidth(Context context, ListInput listInput) {
        ViewGroupObject viewGroupObject;
        SizeObject sizeObject;
        ArrayList<? extends PresenterItem> arrayList;
        ViewGroupObject viewGroupObject2;
        SizeObject sizeObject2;
        ListInput.ItemType itemType = listInput.itemType;
        if (itemType == ListInput.ItemType.tag) {
            TagObject tagObject = listInput.tagObject;
            TagObject.TagType tagType = tagObject.type;
            if (tagType == TagObject.TagType.vod_film) {
                return context.getResources().getDimensionPixelOffset(R.dimen.cell_vod_width);
            }
            if (tagType == TagObject.TagType.aod_track) {
                return context.getResources().getDimensionPixelOffset(R.dimen.cell_aod_width);
            }
            if (tagType == TagObject.TagType.course) {
                return context.getResources().getDimensionPixelOffset(R.dimen.cell_lms_width);
            }
            if (tagType == TagObject.TagType.virtual_channel) {
                return (int) context.getResources().getDimension(R.dimen.cell_virtualchannelabs_width);
            }
            if (tagType == TagObject.TagType.app) {
                return (int) context.getResources().getDimension(R.dimen.cell_app_width);
            }
            if (tagType == TagObject.TagType.item_link) {
                return (int) context.getResources().getDimension(R.dimen.cell_virtualchannelabs_width);
            }
            TagObject.TagType tagType2 = TagObject.TagType.operator;
            if (tagType == tagType2) {
                return (int) context.getResources().getDimension(R.dimen.cell_operator_width);
            }
            if (tagType == TagObject.TagType.tv_episode) {
                return (int) context.getResources().getDimension(R.dimen.cell_tv_episode_width);
            }
            if (tagType == tagType2) {
                return (int) context.getResources().getDimension(R.dimen.cell_operator_width);
            }
            if (tagType == TagObject.TagType.tv_channel) {
                return (int) context.getResources().getDimension(R.dimen.cell_tv_channel_width);
            }
            if (tagType == TagObject.TagType.vchannel_item) {
                return (int) context.getResources().getDimension(R.dimen.cell_vchannel_item_width);
            }
            if (tagType == TagObject.TagType.instaPost) {
                return (int) context.getResources().getDimension(R.dimen.insta_post_cell_width);
            }
            if (tagType == TagObject.TagType.dynamicView && (viewGroupObject2 = tagObject.viewObject) != null && (sizeObject2 = viewGroupObject2.size) != null) {
                return sizeObject2.getWidthPx();
            }
        } else if (itemType == ListInput.ItemType.viewTag || itemType == ListInput.ItemType.searchViewTag) {
            ViewTagObject viewTagObject = listInput.viewTagObject;
            if (viewTagObject != null && (viewGroupObject = viewTagObject.view) != null && (sizeObject = viewGroupObject.size) != null) {
                return sizeObject.getWidthPx();
            }
        } else if (itemType == ListInput.ItemType.array && (arrayList = listInput.arrayList) != null && arrayList.size() > 0) {
            if (listInput.arrayList.get(0).getPresenterType() == PresenterItemType.ImageObject) {
                return (int) context.getResources().getDimension(R.dimen.cell_image_width);
            }
            if (listInput.arrayList.get(0).getPresenterType() == PresenterItemType.tv_channel) {
                return (int) context.getResources().getDimension(R.dimen.cell_tv_channel_width);
            }
        } else if (listInput.itemType == ListInput.ItemType.instaTopProfiles) {
            return (int) context.getResources().getDimension(R.dimen.cell_insta_top_profile_width);
        }
        return getScreenMinDimension((Activity) context);
    }

    public static int getItemImageHeight(Context context, ListInput listInput) {
        ViewGroupObject viewGroupObject;
        SizeObject sizeObject;
        ArrayList<? extends PresenterItem> arrayList;
        ViewGroupObject viewGroupObject2;
        SizeObject sizeObject2;
        ListInput.ItemType itemType = listInput.itemType;
        if (itemType == ListInput.ItemType.tag) {
            TagObject tagObject = listInput.tagObject;
            TagObject.TagType tagType = tagObject.type;
            if (tagType == TagObject.TagType.vod_film) {
                return (int) context.getResources().getDimension(R.dimen.cell_vod_height);
            }
            if (tagType == TagObject.TagType.aod_track) {
                return (int) context.getResources().getDimension(R.dimen.cell_aod_height);
            }
            if (tagType == TagObject.TagType.course) {
                return (int) context.getResources().getDimension(R.dimen.cell_lms_height);
            }
            if (tagType == TagObject.TagType.virtual_channel) {
                return (int) context.getResources().getDimension(R.dimen.cell_virtualchannelabs_height);
            }
            if (tagType == TagObject.TagType.app) {
                return (int) context.getResources().getDimension(R.dimen.cell_app_height);
            }
            if (tagType == TagObject.TagType.item_link) {
                return (int) context.getResources().getDimension(R.dimen.cell_virtualchannelabs_height);
            }
            TagObject.TagType tagType2 = TagObject.TagType.operator;
            if (tagType == tagType2) {
                return (int) context.getResources().getDimension(R.dimen.cell_operator_height);
            }
            if (tagType == TagObject.TagType.tv_episode) {
                return (int) context.getResources().getDimension(R.dimen.cell_tv_episode_height);
            }
            if (tagType == tagType2) {
                return (int) context.getResources().getDimension(R.dimen.cell_operator_height);
            }
            if (tagType == TagObject.TagType.tv_channel) {
                return (int) context.getResources().getDimension(R.dimen.cell_tv_channel_height);
            }
            if (tagType == TagObject.TagType.vchannel_item) {
                return (int) context.getResources().getDimension(R.dimen.cell_vchannel_item_height);
            }
            if (tagType == TagObject.TagType.instaPost) {
                return (int) context.getResources().getDimension(R.dimen.insta_post_cell_height);
            }
            if (tagType == TagObject.TagType.dynamicView && (viewGroupObject2 = tagObject.viewObject) != null && (sizeObject2 = viewGroupObject2.size) != null) {
                return sizeObject2.getHeightPx();
            }
        } else if (itemType == ListInput.ItemType.viewTag || itemType == ListInput.ItemType.searchViewTag) {
            ViewTagObject viewTagObject = listInput.viewTagObject;
            if (viewTagObject != null && (viewGroupObject = viewTagObject.view) != null && (sizeObject = viewGroupObject.size) != null) {
                return sizeObject.getHeightPx();
            }
        } else if (itemType == ListInput.ItemType.array && (arrayList = listInput.arrayList) != null && arrayList.size() > 0) {
            if (listInput.arrayList.get(0).getPresenterType() == PresenterItemType.ImageObject) {
                return (int) context.getResources().getDimension(R.dimen.cell_image_height);
            }
            if (listInput.arrayList.get(0).getPresenterType() == PresenterItemType.tv_channel) {
                return (int) context.getResources().getDimension(R.dimen.cell_tv_channel_height);
            }
        } else if (listInput.itemType == ListInput.ItemType.instaTopProfiles) {
            return (int) context.getResources().getDimension(R.dimen.cell_insta_top_profile_height);
        }
        return AndroidUtilities.dp(40.0f);
    }

    public static int getItemHeight(Context context, ListInput listInput) {
        ViewGroupObject viewGroupObject;
        SizeObject sizeObject;
        int itemImageHeight;
        int iDp;
        ArrayList<? extends PresenterItem> arrayList;
        TagObject.TagType tagType;
        ViewGroupObject viewGroupObject2;
        SizeObject sizeObject2;
        ListInput.ItemType itemType = listInput.itemType;
        if (itemType == ListInput.ItemType.tag) {
            TagObject tagObject = listInput.tagObject;
            TagObject.TagType tagType2 = tagObject.type;
            if (tagType2 == TagObject.TagType.vod_film || tagType2 == TagObject.TagType.aod_track) {
                itemImageHeight = getItemImageHeight(context, listInput);
                iDp = AndroidUtilities.dp(60.0f);
            } else if (tagType2 == TagObject.TagType.virtual_channel) {
                itemImageHeight = getItemImageHeight(context, listInput);
                iDp = AndroidUtilities.dp(40.0f);
            } else if (tagType2 == TagObject.TagType.app) {
                itemImageHeight = getItemImageHeight(context, listInput);
                iDp = AndroidUtilities.dp(60.0f);
            } else if (tagType2 == TagObject.TagType.item_link) {
                itemImageHeight = getItemImageHeight(context, listInput);
                iDp = AndroidUtilities.dp(40.0f);
            } else if (tagType2 == TagObject.TagType.course || tagType2 == (tagType = TagObject.TagType.operator)) {
                itemImageHeight = getItemImageHeight(context, listInput);
                iDp = AndroidUtilities.dp(60.0f);
            } else if (tagType2 == TagObject.TagType.tv_episode) {
                itemImageHeight = getItemImageHeight(context, listInput);
                iDp = AndroidUtilities.dp(70.0f);
            } else if (tagType2 == tagType || tagType2 == TagObject.TagType.tv_channel) {
                itemImageHeight = getItemImageHeight(context, listInput);
                iDp = AndroidUtilities.dp(40.0f);
            } else {
                if (tagType2 == TagObject.TagType.vchannel_item) {
                    return getItemImageHeight(context, listInput);
                }
                if (tagType2 == TagObject.TagType.instaPost) {
                    return getItemImageHeight(context, listInput);
                }
                if (tagType2 == TagObject.TagType.dynamicView && (viewGroupObject2 = tagObject.viewObject) != null && (sizeObject2 = viewGroupObject2.size) != null) {
                    return sizeObject2.getHeightPx();
                }
                return AndroidUtilities.dp(40.0f);
            }
            return itemImageHeight + iDp;
        }
        if (itemType == ListInput.ItemType.viewTag || itemType == ListInput.ItemType.searchViewTag) {
            ViewTagObject viewTagObject = listInput.viewTagObject;
            if (viewTagObject != null && (viewGroupObject = viewTagObject.view) != null && (sizeObject = viewGroupObject.size) != null) {
                return sizeObject.getHeightPx();
            }
        } else if (itemType == ListInput.ItemType.array && (arrayList = listInput.arrayList) != null && arrayList.size() > 0) {
            if (listInput.arrayList.get(0).getPresenterType() == PresenterItemType.ImageObject) {
                return getItemImageHeight(context, listInput);
            }
            if (listInput.arrayList.get(0).getPresenterType() == PresenterItemType.tv_channel) {
                itemImageHeight = getItemImageHeight(context, listInput);
                iDp = AndroidUtilities.dp(40.0f);
                return itemImageHeight + iDp;
            }
            if (listInput.arrayList.get(0).getPresenterType() == PresenterItemType.time) {
                return AndroidUtilities.dp(40.0f);
            }
        } else if (listInput.itemType == ListInput.ItemType.instaTopProfiles) {
            itemImageHeight = getItemImageHeight(context, listInput);
            iDp = AndroidUtilities.dp(40.0f);
            return itemImageHeight + iDp;
        }
        return AndroidUtilities.dp(40.0f);
    }

    public static int getItemWidth(Context context, ListInput listInput) {
        ViewGroupObject viewGroupObject;
        SizeObject sizeObject;
        ViewGroupObject viewGroupObject2;
        SizeObject sizeObject2;
        ListInput.ItemType itemType = listInput.itemType;
        if (itemType == ListInput.ItemType.tag) {
            TagObject tagObject = listInput.tagObject;
            TagObject.TagType tagType = tagObject.type;
            if (tagType == TagObject.TagType.vchannel_item) {
                return getItemImageWidth(context, listInput);
            }
            if (tagType == TagObject.TagType.instaPost) {
                return getItemImageWidth(context, listInput);
            }
            if (tagType == TagObject.TagType.dynamicView && (viewGroupObject2 = tagObject.viewObject) != null && (sizeObject2 = viewGroupObject2.size) != null) {
                return sizeObject2.getWidthPx();
            }
            return getItemImageWidth(context, listInput) + AndroidUtilities.dp(8.0f);
        }
        if (itemType == ListInput.ItemType.viewTag || itemType == ListInput.ItemType.searchViewTag) {
            ViewTagObject viewTagObject = listInput.viewTagObject;
            if (viewTagObject != null && (viewGroupObject = viewTagObject.view) != null && (sizeObject = viewGroupObject.size) != null) {
                return sizeObject.getWidthPx();
            }
        } else if (itemType == ListInput.ItemType.instaTopProfiles) {
            return getItemImageWidth(context, listInput) + AndroidUtilities.dp(8.0f);
        }
        return getScreenMinDimension((Activity) context);
    }

    public static int getItemWidth(Context context, PresenterItemType presenterItemType) {
        return getItemImageWidth(context, presenterItemType) + AndroidUtilities.dp(8.0f);
    }

    public static int getItemImageWidth(Context context, PresenterItemType presenterItemType) {
        if (presenterItemType == PresenterItemType.Operator) {
            return context.getResources().getDimensionPixelOffset(R.dimen.cell_operator_width);
        }
        return AndroidUtilities.dp(40.0f);
    }

    public static int getItemImageHeight(Context context, PresenterItemType presenterItemType) {
        if (presenterItemType == PresenterItemType.Operator) {
            return context.getResources().getDimensionPixelOffset(R.dimen.cell_operator_height);
        }
        return AndroidUtilities.dp(40.0f);
    }

    public static int getInstaPostMaxWidth(Context context) {
        return getScreenMinDimension((Activity) context);
    }

    public static int getHeaderHeight(Context context) {
        float fDp = AndroidUtilities.dp(1000.0f);
        Activity activity = (Activity) context;
        if (fDp > getScreenMinDimension(activity)) {
            fDp = getScreenMinDimension(activity);
        }
        return (int) ((fDp * 9.0f) / 16.0f);
    }

    public static int getViewScaleSizePxt(float f) {
        if (ApplicationLoader.applicationActivity == null) {
            return 100;
        }
        float screenMinDimension = getScreenMinDimension(ApplicationLoader.applicationActivity) * 0.9f;
        if (AndroidUtilities.dp(100 * f) <= screenMinDimension) {
            return 100;
        }
        return (int) (screenMinDimension / AndroidUtilities.dp(f));
    }

    public static int getTextHeight(CharSequence charSequence, TextView textView) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(textView.getTextSize());
        textPaint.setColor(-16777216);
        textPaint.setTypeface(textView.getTypeface());
        return new StaticLayout(charSequence, textPaint, textView.getLayoutParams().width, Layout.Alignment.ALIGN_NORMAL, textView.getLineSpacingMultiplier(), 0.0f, true).getHeight();
    }
}
