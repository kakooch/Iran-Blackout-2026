package ir.eitaa.ui.Components;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class AvatarDrawable extends Drawable {
    private int alpha;
    private float archivedAvatarProgress;
    private int avatarType;
    private int color;
    private boolean drawDeleted;
    private boolean isProfile;
    private TextPaint namePaint;
    private boolean needApplyColorAccent;
    private Theme.ResourcesProvider resourcesProvider;
    private boolean smallSize;
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
    public void setColorFilter(ColorFilter cf) {
    }

    public AvatarDrawable() {
        this((Theme.ResourcesProvider) null);
    }

    public AvatarDrawable(Theme.ResourcesProvider resourcesProvider) {
        this.stringBuilder = new StringBuilder(5);
        this.alpha = 255;
        this.resourcesProvider = resourcesProvider;
        TextPaint textPaint = new TextPaint(1);
        this.namePaint = textPaint;
        textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.namePaint.setTextSize(AndroidUtilities.dp(18.0f));
    }

    public AvatarDrawable(TLRPC$User user) {
        this(user, false);
    }

    public AvatarDrawable(TLRPC$Chat chat) {
        this(chat, false);
    }

    public AvatarDrawable(TLRPC$User user, boolean profile) {
        this();
        this.isProfile = profile;
        if (user != null) {
            setInfo(user.id, user.first_name, user.last_name, null);
            this.drawDeleted = UserObject.isDeleted(user);
        }
    }

    public AvatarDrawable(TLRPC$Chat chat, boolean profile) {
        this();
        this.isProfile = profile;
        if (chat != null) {
            setInfo(chat.id, chat.title, null, null);
        }
    }

    public void setProfile(boolean value) {
        this.isProfile = value;
    }

    private static int getColorIndex(long id) {
        return (id < 0 || id >= 7) ? (int) Math.abs(id % Theme.keys_avatar_background.length) : (int) id;
    }

    public static int getColorForId(long id) {
        return Theme.getColor(Theme.keys_avatar_background[getColorIndex(id)]);
    }

    public static int getButtonColorForId(long id) {
        return Theme.getColor("avatar_actionBarSelectorBlue");
    }

    public static int getIconColorForId(long id) {
        return Theme.getColor("avatar_actionBarIconBlue");
    }

    public static int getProfileColorForId(long id) {
        return Theme.getColor(Theme.keys_avatar_background[getColorIndex(id)]);
    }

    public static int getProfileTextColorForId(long id) {
        return Theme.getColor("avatar_subtitleInProfileBlue");
    }

    public static int getProfileBackColorForId(long id) {
        return Theme.getColor("avatar_backgroundActionBarBlue");
    }

    public static String getNameColorNameForId(long id) {
        return Theme.keys_avatar_nameInMessage[getColorIndex(id)];
    }

    public void setInfo(TLRPC$User user) {
        if (user != null) {
            setInfo(user.id, user.first_name, user.last_name, null);
            this.drawDeleted = UserObject.isDeleted(user);
        }
    }

    public void setInfo(TLObject object) {
        if (object instanceof TLRPC$User) {
            setInfo((TLRPC$User) object);
        } else if (object instanceof TLRPC$Chat) {
            setInfo((TLRPC$Chat) object);
        }
    }

    public void setSmallSize(boolean value) {
        this.smallSize = value;
    }

    public void setAvatarType(int value) {
        this.avatarType = value;
        if (value == 2) {
            this.color = getThemedColor("avatar_backgroundArchivedHidden");
        } else if (value == 12 || value == 1) {
            this.color = getThemedColor("avatar_backgroundSaved");
        } else if (value == 3 || value == 4) {
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(5L)]);
        } else if (value == 5) {
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(4L)]);
        } else if (value == 6) {
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(3L)]);
        } else if (value == 7) {
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(1L)]);
        } else if (value == 8) {
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(0L)]);
        } else if (value == 9) {
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(6L)]);
        } else if (value == 10 || value == 13) {
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(5L)]);
        } else if (value == 14) {
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(3L)]);
        } else if (value == 15) {
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(1L)]);
        } else {
            this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(4L)]);
        }
        int i = this.avatarType;
        this.needApplyColorAccent = (i == 2 || i == 1 || i == 12) ? false : true;
    }

    public void setArchivedAvatarHiddenProgress(float progress) {
        this.archivedAvatarProgress = progress;
    }

    public int getAvatarType() {
        return this.avatarType;
    }

    public void setInfo(TLRPC$Chat chat) {
        if (chat != null) {
            setInfo(chat.id, chat.title, null, null);
        }
    }

    public void setColor(int value) {
        this.color = value;
        this.needApplyColorAccent = false;
    }

    public void setTextSize(int size) {
        this.namePaint.setTextSize(size);
    }

    public void setInfo(long id, String firstName, String lastName) {
        setInfo(id, firstName, lastName, null);
    }

    public int getColor() {
        return this.needApplyColorAccent ? Theme.changeColorAccent(this.color) : this.color;
    }

    public void setInfo(long id, String firstName, String lastName, String custom) {
        this.color = getThemedColor(Theme.keys_avatar_background[getColorIndex(id)]);
        this.needApplyColorAccent = id == 5;
        this.avatarType = 0;
        this.drawDeleted = false;
        if (firstName == null || firstName.length() == 0) {
            firstName = lastName;
            lastName = null;
        }
        this.stringBuilder.setLength(0);
        if (custom != null) {
            this.stringBuilder.append(custom);
        } else {
            if (firstName != null && firstName.length() > 0) {
                this.stringBuilder.appendCodePoint(firstName.codePointAt(0));
            }
            if (lastName != null && lastName.length() > 0) {
                Integer numValueOf = null;
                for (int length = lastName.length() - 1; length >= 0 && (numValueOf == null || lastName.charAt(length) != ' '); length--) {
                    numValueOf = Integer.valueOf(lastName.codePointAt(length));
                }
                if (Build.VERSION.SDK_INT > 17) {
                    this.stringBuilder.append("\u200c");
                }
                this.stringBuilder.appendCodePoint(numValueOf.intValue());
            } else if (firstName != null && firstName.length() > 0) {
                int length2 = firstName.length() - 1;
                while (true) {
                    if (length2 < 0) {
                        break;
                    }
                    if (firstName.charAt(length2) == ' ' && length2 != firstName.length() - 1) {
                        int i = length2 + 1;
                        if (firstName.charAt(i) != ' ') {
                            if (Build.VERSION.SDK_INT > 17) {
                                this.stringBuilder.append("\u200c");
                            }
                            this.stringBuilder.appendCodePoint(firstName.codePointAt(i));
                        }
                    }
                    length2--;
                }
            }
        }
        if (this.stringBuilder.length() > 0) {
            try {
                StaticLayout staticLayout = new StaticLayout(this.stringBuilder.toString().toUpperCase(), this.namePaint, AndroidUtilities.dp(100.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                this.textLayout = staticLayout;
                if (staticLayout.getLineCount() > 0) {
                    this.textLeft = this.textLayout.getLineLeft(0);
                    this.textWidth = this.textLayout.getLineWidth(0);
                    this.textHeight = this.textLayout.getLineBottom(0);
                    return;
                }
                return;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        this.textLayout = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x01d3  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r11) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AvatarDrawable.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
