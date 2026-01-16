package org.rbmain.ui.Components;

import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatInvite;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class AvatarDrawable extends Drawable {
    private int alpha;
    private float archivedAvatarProgress;
    private int avatarType;
    private int color;
    private int color2;
    private boolean drawDeleted;
    private LinearGradient gradient;
    private int gradientBottom;
    private int gradientColor1;
    private int gradientColor2;
    private boolean hasGradient;
    private boolean invalidateTextLayout;
    private TextPaint namePaint;
    private boolean needApplyColorAccent;
    private Theme.ResourcesProvider resourcesProvider;
    private int roundRadius;
    private float scaleSize;
    private StringBuilder stringBuilder;
    private float textHeight;
    private StaticLayout textLayout;
    private float textLeft;
    private float textWidth;

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setProfile(boolean z) {
    }

    public AvatarDrawable() {
        this((Theme.ResourcesProvider) null);
    }

    public AvatarDrawable(Theme.ResourcesProvider resourcesProvider) {
        this.scaleSize = 1.0f;
        this.stringBuilder = new StringBuilder(5);
        this.roundRadius = -1;
        this.alpha = 255;
        this.resourcesProvider = resourcesProvider;
        TextPaint textPaint = new TextPaint(1);
        this.namePaint = textPaint;
        textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.namePaint.setTextSize(AndroidUtilities.dp(18.0f));
    }

    public AvatarDrawable(TLRPC$User tLRPC$User) {
        this(tLRPC$User, false);
    }

    public AvatarDrawable(TLRPC$Chat tLRPC$Chat) {
        this(tLRPC$Chat, false);
    }

    public AvatarDrawable(TLRPC$User tLRPC$User, boolean z) {
        this();
        if (tLRPC$User != null) {
            setInfo(tLRPC$User.id, tLRPC$User.first_name, tLRPC$User.last_name, null);
            this.drawDeleted = UserObject.isDeleted(tLRPC$User);
        }
    }

    public AvatarDrawable(TLRPC$Chat tLRPC$Chat, boolean z) {
        this();
        if (tLRPC$Chat != null) {
            setInfo(tLRPC$Chat.id, tLRPC$Chat.title, null, null);
        }
    }

    public static int getColorIndex(long j) {
        return (j < 0 || j >= 7) ? (int) Math.abs(j % Theme.keys_avatar_background.length) : (int) j;
    }

    public static int getColorForId(long j) {
        return Theme.getColor(Theme.keys_avatar_background[getColorIndex(j)]);
    }

    public static int getButtonColorForId(long j, Theme.ResourcesProvider resourcesProvider) {
        return Theme.getColor(Theme.key_avatar_actionBarSelectorBlue, resourcesProvider);
    }

    public static int getButtonColorForId(long j) {
        return getButtonColorForId(j, null);
    }

    public static int getIconColorForId(long j) {
        return Theme.getColor(Theme.key_avatar_actionBarIconBlue);
    }

    public static int getProfileColorForId(long j, Theme.ResourcesProvider resourcesProvider) {
        return Theme.getColor(Theme.keys_avatar_background[getColorIndex(j)], resourcesProvider);
    }

    public static int getProfileColorForId(long j) {
        return getProfileColorForId(j, null);
    }

    public static int getProfileTextColorForId(long j) {
        return Theme.getColor(Theme.key_avatar_subtitleInProfileBlue);
    }

    public static int getProfileBackColorForId(long j) {
        return Theme.getColor(Theme.key_avatar_backgroundActionBarBlue);
    }

    public static int getNameColorNameForId(long j) {
        return Theme.keys_avatar_nameInMessage[getColorIndex(j)];
    }

    public void setInfo(TLRPC$User tLRPC$User) {
        if (tLRPC$User != null) {
            setInfo(tLRPC$User.id, tLRPC$User.first_name, tLRPC$User.last_name, null);
            this.drawDeleted = UserObject.isDeleted(tLRPC$User);
        }
    }

    public void setInfo(TLObject tLObject) {
        if (tLObject instanceof TLRPC$User) {
            setInfo((TLRPC$User) tLObject);
        } else if (tLObject instanceof TLRPC$Chat) {
            setInfo((TLRPC$Chat) tLObject);
        } else if (tLObject instanceof TLRPC$ChatInvite) {
            setInfo((TLRPC$ChatInvite) tLObject);
        }
    }

    public void setScaleSize(float f) {
        this.scaleSize = f;
    }

    public void setSmallSize(boolean z) {
        if (z) {
            this.scaleSize = 0.8f;
        } else {
            this.scaleSize = 1.0f;
        }
    }

    public void setAvatarType(int i) {
        this.avatarType = i;
        boolean z = false;
        if (i == 13) {
            this.hasGradient = false;
            int color = Theme.getColor(Theme.key_chats_actionBackground);
            this.color2 = color;
            this.color = color;
        } else if (i == 2) {
            this.hasGradient = false;
            int themedColor = getThemedColor(Theme.key_avatar_backgroundArchivedHidden);
            this.color2 = themedColor;
            this.color = themedColor;
        } else if (i == 12 || i == 1 || i == 14) {
            this.hasGradient = true;
            this.color = getThemedColor(Theme.key_avatar_backgroundSaved);
            this.color2 = getThemedColor(Theme.key_avatar_background2Saved);
        } else if (i == 3 || i == 4) {
            this.hasGradient = true;
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(5L)]);
            this.color2 = getThemedColor(Theme.keys_avatar_background2[getColorIndex(5L)]);
        } else if (i == 5) {
            this.hasGradient = true;
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(4L)]);
            this.color2 = getThemedColor(Theme.keys_avatar_background2[getColorIndex(4L)]);
        } else if (i == 6) {
            this.hasGradient = true;
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(3L)]);
            this.color2 = getThemedColor(Theme.keys_avatar_background2[getColorIndex(3L)]);
        } else if (i == 7) {
            this.hasGradient = true;
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(1L)]);
            this.color2 = getThemedColor(Theme.keys_avatar_background2[getColorIndex(1L)]);
        } else if (i == 8) {
            this.hasGradient = true;
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(0L)]);
            this.color2 = getThemedColor(Theme.keys_avatar_background2[getColorIndex(0L)]);
        } else if (i == 9) {
            this.hasGradient = true;
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(6L)]);
            this.color2 = getThemedColor(Theme.keys_avatar_background2[getColorIndex(6L)]);
        } else if (i == 10) {
            this.hasGradient = true;
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(5L)]);
            this.color2 = getThemedColor(Theme.keys_avatar_background2[getColorIndex(5L)]);
        } else {
            this.hasGradient = true;
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(4L)]);
            this.color2 = getThemedColor(Theme.keys_avatar_background2[getColorIndex(4L)]);
        }
        int i2 = this.avatarType;
        if (i2 != 2 && i2 != 1 && i2 != 12 && i2 != 14) {
            z = true;
        }
        this.needApplyColorAccent = z;
    }

    public void setArchivedAvatarHiddenProgress(float f) {
        this.archivedAvatarProgress = f;
    }

    public int getAvatarType() {
        return this.avatarType;
    }

    public void setInfo(TLRPC$Chat tLRPC$Chat) {
        if (tLRPC$Chat != null) {
            setInfo(tLRPC$Chat.id, tLRPC$Chat.title, null, null);
        }
    }

    public void setInfo(TLRPC$ChatInvite tLRPC$ChatInvite) {
        if (tLRPC$ChatInvite != null) {
            setInfo(0L, tLRPC$ChatInvite.title, null, null);
        }
    }

    public void setColor(int i) {
        this.hasGradient = false;
        this.color2 = i;
        this.color = i;
        this.needApplyColorAccent = false;
    }

    public void setTextSize(int i) {
        this.namePaint.setTextSize(i);
    }

    public void setInfo(long j, String str, String str2) {
        setInfo(j, str, str2, null);
    }

    public int getColor() {
        return this.needApplyColorAccent ? Theme.changeColorAccent(this.color) : this.color;
    }

    public int getColor2() {
        return this.needApplyColorAccent ? Theme.changeColorAccent(this.color2) : this.color2;
    }

    private String takeFirstCharacter(String str) {
        ArrayList<Emoji.EmojiSpanRange> emojis = Emoji.parseEmojis(str);
        if (emojis != null && !emojis.isEmpty() && emojis.get(0).start == 0) {
            return str.substring(0, emojis.get(0).end);
        }
        return str.substring(0, str.offsetByCodePoints(0, Math.min(str.codePointCount(0, str.length()), 1)));
    }

    public void setInfo(long j, String str, String str2, String str3) {
        this.hasGradient = true;
        this.invalidateTextLayout = true;
        this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(j)]);
        this.color2 = getThemedColor(Theme.keys_avatar_background2[getColorIndex(j)]);
        this.needApplyColorAccent = j == 5;
        this.avatarType = 0;
        this.drawDeleted = false;
        if (str == null || str.length() == 0) {
            str = str2;
            str2 = null;
        }
        this.stringBuilder.setLength(0);
        if (str3 != null) {
            this.stringBuilder.append(str3);
            return;
        }
        if (str != null && str.length() > 0) {
            this.stringBuilder.append(takeFirstCharacter(str));
        }
        if (str2 != null && str2.length() > 0) {
            int iLastIndexOf = str2.lastIndexOf(32);
            if (iLastIndexOf >= 0) {
                str2 = str2.substring(iLastIndexOf + 1);
            }
            if (Build.VERSION.SDK_INT > 17) {
                this.stringBuilder.append("\u200c");
            }
            this.stringBuilder.append(takeFirstCharacter(str2));
            return;
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) == ' ' && length != str.length() - 1 && str.charAt(length + 1) != ' ') {
                int length2 = this.stringBuilder.length();
                if (Build.VERSION.SDK_INT > 17) {
                    this.stringBuilder.append("\u200c");
                }
                this.stringBuilder.append(takeFirstCharacter(str.substring(length2)));
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x022a  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instructions count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.AvatarDrawable.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.alpha = i;
    }

    private int getThemedColor(int i) {
        return Theme.getColor(i, this.resourcesProvider);
    }

    public void setRoundRadius(int i) {
        this.roundRadius = i;
    }
}
