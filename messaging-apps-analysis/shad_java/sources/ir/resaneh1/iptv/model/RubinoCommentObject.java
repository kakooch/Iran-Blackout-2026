package ir.resaneh1.iptv.model;

import android.text.SpannableString;
import android.text.style.ImageSpan;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.Disposable;
import ir.appp.rghapp.components.RubinoUsernameSpan;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.Rubino;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class RubinoCommentObject {
    private static final int MAX_CHAR = 200;
    private static final int MAX_LINE = 2;
    public Rubino.CommentFromServer comment;
    public transient SpannableString contentSpannableString;
    public transient int currentAccount;
    private transient String dateString;
    public transient Disposable getReplyDisposable;
    public transient boolean isContentMoreThanMax;
    public boolean isRepliesHidden;
    public boolean isReplyLoading;
    public int itemCount;
    public transient String likeCountString;
    public String maxIdReply;
    public RubinoCommentObject parentComment;
    private transient RubinoProfileObject profile;
    public int replyArrayEndRow;
    public int replyArrayStartRow;
    public int replyHideRow;
    public int replyLoadingRow;
    public int rnd;
    public boolean isReply = false;
    public boolean isLiked = false;
    public boolean isLocal = false;
    public transient ArrayList<RubinoCommentObject> replyArray = new ArrayList<>();
    public boolean hasContinueReply = false;

    public void updateRows() {
        this.replyLoadingRow = -1;
        this.replyHideRow = -1;
        this.replyArrayStartRow = -1;
        this.replyArrayEndRow = -1;
        this.itemCount = 1;
        if (this.isRepliesHidden) {
            this.itemCount = 1 + 1;
            this.replyLoadingRow = 1;
            return;
        }
        if (this.hasContinueReply) {
            this.itemCount = 1 + 1;
            this.replyLoadingRow = 1;
        }
        if (this.replyArray.size() > 0) {
            if (!this.hasContinueReply) {
                int i = this.itemCount;
                this.itemCount = i + 1;
                this.replyHideRow = i;
            }
            int i2 = this.itemCount;
            this.replyArrayStartRow = i2;
            int size = i2 + this.replyArray.size();
            this.itemCount = size;
            this.replyArrayEndRow = size;
        }
    }

    public RubinoProfileObject getProfileTryFromMap() {
        RubinoProfileObject rubinoProfileObject = RubinoController.getInstance(this.currentAccount).profileMap.get(this.comment.profile_id);
        if (rubinoProfileObject != null) {
            this.profile = rubinoProfileObject;
            return rubinoProfileObject;
        }
        return this.profile;
    }

    public void createProfile() {
        if (this.comment == null || this.profile != null) {
            return;
        }
        RubinoProfileObject rubinoProfileObject = new RubinoProfileObject();
        this.profile = rubinoProfileObject;
        Rubino.CommentFromServer commentFromServer = this.comment;
        rubinoProfileObject.id = commentFromServer.profile_id;
        String str = commentFromServer.full_profile_thumbnail_url;
        rubinoProfileObject.full_thumbnail_url = str;
        rubinoProfileObject.full_photo_url = str;
        String str2 = commentFromServer.profile_username;
        rubinoProfileObject.username = str2 != null ? str2.toLowerCase() : null;
    }

    public void deleteReply(RubinoCommentObject rubinoCommentObject) {
        ArrayList<RubinoCommentObject> arrayList = this.replyArray;
        if (arrayList != null) {
            Iterator<RubinoCommentObject> it = arrayList.iterator();
            while (it.hasNext()) {
                RubinoCommentObject next = it.next();
                boolean z = rubinoCommentObject.isLocal;
                if ((z && next.rnd == rubinoCommentObject.rnd) || (!z && next.comment.id.equals(rubinoCommentObject.comment.id))) {
                    this.replyArray.remove(next);
                    break;
                }
            }
        }
        updateRows();
    }

    public void onReplyLoaded(ArrayList<RubinoCommentObject> arrayList) {
        this.replyArray.addAll(arrayList);
        this.maxIdReply = arrayList.get(arrayList.size() - 1).comment.id;
        this.hasContinueReply = this.replyArray.size() < this.comment.reply_count;
        updateRows();
    }

    public void replaceLocalReply(RubinoCommentObject rubinoCommentObject, RubinoCommentObject rubinoCommentObject2) {
        ArrayList<RubinoCommentObject> arrayList = this.replyArray;
        if (arrayList != null) {
            int iIndexOf = -1;
            Iterator<RubinoCommentObject> it = arrayList.iterator();
            while (it.hasNext()) {
                RubinoCommentObject next = it.next();
                boolean z = rubinoCommentObject.isLocal;
                if ((z && next.rnd == rubinoCommentObject.rnd) || (!z && next.comment.id.equals(rubinoCommentObject.comment.id))) {
                    iIndexOf = this.replyArray.indexOf(next);
                    this.replyArray.remove(next);
                    break;
                }
            }
            if (iIndexOf > 0) {
                this.replyArray.add(iIndexOf, rubinoCommentObject2);
            } else {
                if (this.replyArray.size() == 0) {
                    this.maxIdReply = rubinoCommentObject2.comment.id;
                }
                this.replyArray.add(0, rubinoCommentObject2);
            }
            updateRows();
        }
    }

    public void addTopReplyArray(RubinoCommentObject rubinoCommentObject) {
        rubinoCommentObject.isReply = true;
        this.comment.reply_count++;
        if (this.isRepliesHidden) {
            this.replyArray.clear();
            this.hasContinueReply = this.replyArray.size() < this.comment.reply_count;
            this.isRepliesHidden = false;
        }
        if (this.replyArray.size() == 0) {
            this.maxIdReply = rubinoCommentObject.comment.id;
        }
        this.replyArray.add(0, rubinoCommentObject);
        updateRows();
    }

    public int getNotLoadedReplyCount() {
        return this.comment.reply_count - this.replyArray.size();
    }

    public RubinoCommentObject getReply(int i) {
        ArrayList<RubinoCommentObject> arrayList = this.replyArray;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.replyArray.get((this.replyArray.size() - i) - 1);
    }

    public int getReplyIndex(RubinoCommentObject rubinoCommentObject) {
        ArrayList<RubinoCommentObject> arrayList = this.replyArray;
        if (arrayList == null || arrayList.size() == 0) {
            return -1;
        }
        if (this.isRepliesHidden) {
            return this.replyLoadingRow;
        }
        return ((this.replyArray.size() - 1) - this.replyArray.indexOf(rubinoCommentObject)) + this.replyArrayStartRow;
    }

    public String getPersianDate() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.comment.create_date.longValue() * 1000);
            this.dateString = DateFormatUtils.getAgoTimeRubino(calendar.getTime());
        } catch (Exception unused) {
            this.dateString = BuildConfig.FLAVOR;
        }
        return this.dateString;
    }

    public void createContent() {
        Rubino.CommentFromServer commentFromServer = this.comment;
        if (commentFromServer != null) {
            this.contentSpannableString = getNameAndTextWithHashtagSpan(commentFromServer.content);
            checkContentLineAndChar();
        }
    }

    public void createLikeCountString() {
        if (this.comment != null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(NumberUtils.toCuteStringWithKOrM(this.comment.likes_count + BuildConfig.FLAVOR));
            sb2.append(" ");
            sb.append(NumberUtils.toPersian(sb2.toString()));
            sb.append(LocaleController.getString(R.string.rubinoLike));
            this.likeCountString = sb.toString();
            return;
        }
        this.likeCountString = BuildConfig.FLAVOR;
    }

    private SpannableString getNameAndTextWithHashtagSpan(String str) {
        String str2;
        ImageSpan imageSpanVerifyOrSale;
        String str3;
        RubinoProfileObject profileTryFromMap = getProfileTryFromMap();
        boolean z = profileTryFromMap != null && profileTryFromMap.is_verified;
        boolean z2 = profileTryFromMap != null && profileTryFromMap.sale_permission;
        Rubino.CommentFromServer commentFromServer = this.comment;
        String str4 = BuildConfig.FLAVOR;
        if (commentFromServer != null && (str3 = commentFromServer.profile_username) != null) {
            str4 = str3;
        }
        if (z || z2) {
            str2 = str4 + "   " + str;
        } else {
            str2 = str4 + " " + str;
        }
        SpannableString spannableString = new SpannableString(str2);
        if (ApplicationLoader.applicationActivity != null) {
            spannableString.setSpan(new RubinoUsernameSpan(Theme.getColor(Theme.key_rubinoBlackColor), str4), 0, str4.length(), 17);
            if ((z || z2) && (imageSpanVerifyOrSale = RubinoController.getInstance(this.currentAccount).getImageSpanVerifyOrSale(z, z2, 16, 0)) != null) {
                int length = str4.length() + 1;
                spannableString.setSpan(imageSpanVerifyOrSale, length, length + 1, 17);
            }
        }
        Rubino.addMentionAndHashtags(spannableString);
        return spannableString;
    }

    public void setComment(Rubino.CommentFromServer commentFromServer, int i) {
        this.comment = commentFromServer;
        this.currentAccount = i;
        this.isLocal = false;
        createContent();
        createLikeCountString();
        createProfile();
        this.hasContinueReply = commentFromServer.reply_count > 0;
        updateRows();
    }

    private void checkContentLineAndChar() {
        String str;
        Rubino.CommentFromServer commentFromServer = this.comment;
        if (commentFromServer == null || (str = commentFromServer.content) == null) {
            return;
        }
        if (str.length() > 200) {
            this.isContentMoreThanMax = true;
        } else if (countLines(this.comment.content) > 2) {
            this.isContentMoreThanMax = true;
        }
    }

    public void setLocalComment(int i, String str, int i2) {
        Rubino.CommentFromServer commentFromServer = new Rubino.CommentFromServer();
        commentFromServer.content = str;
        this.currentAccount = i;
        RubinoProfileObject rubinoCurrentProfileObject = AppRubinoPreferences.getInstance(i).getRubinoCurrentProfileObject();
        commentFromServer.profile_id = rubinoCurrentProfileObject.id;
        commentFromServer.profile_username = rubinoCurrentProfileObject.username;
        commentFromServer.full_profile_thumbnail_url = rubinoCurrentProfileObject.full_thumbnail_url;
        this.isLocal = true;
        this.rnd = i2;
        this.comment = commentFromServer;
        createContent();
        createLikeCountString();
        this.hasContinueReply = false;
        updateRows();
    }

    private static int countLines(String str) {
        return str.split("\r\n|\r|\n").length;
    }
}
