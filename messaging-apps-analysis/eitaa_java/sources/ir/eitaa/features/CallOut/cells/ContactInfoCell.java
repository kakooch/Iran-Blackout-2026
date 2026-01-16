package ir.eitaa.features.CallOut.cells;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes.dex */
public class ContactInfoCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private ImageReceiver avatarImage;
    private ContactsController.Contact currentContact;
    private CharSequence currentName;
    private boolean isSmall;
    private SimpleTextView nameTextView;
    private SimpleTextView statusTextView;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public ContactInfoCell(Context context, boolean isSmall) {
        super(context);
        this.isSmall = isSmall;
        setWillNotDraw(false);
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.avatarImage = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.dp(isSmall ? 20.0f : 24.0f));
        this.avatarDrawable = new AvatarDrawable();
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(!isSmall));
        this.nameTextView.setTextSize(isSmall ? 14 : 17);
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        if (isSmall) {
            SimpleTextView simpleTextView2 = this.nameTextView;
            boolean z = LocaleController.isRTL;
            addView(simpleTextView2, LayoutHelper.createFrame(-1, -2.0f, (z ? 5 : 3) | 48, z ? 28.0f : 52.0f, 0.0f, z ? 52.0f : 28.0f, 0.0f));
        } else {
            SimpleTextView simpleTextView3 = this.nameTextView;
            boolean z2 = LocaleController.isRTL;
            addView(simpleTextView3, LayoutHelper.createFrame(-1, 24.0f, (z2 ? 5 : 3) | 48, z2 ? 28.0f : 72.0f, 7.0f, z2 ? 72.0f : 28.0f, 0.0f));
        }
        SimpleTextView simpleTextView4 = new SimpleTextView(context);
        this.statusTextView = simpleTextView4;
        simpleTextView4.setTextSize(isSmall ? 12 : 16);
        this.statusTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.statusTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        this.statusTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        if (isSmall) {
            this.statusTextView.setPadding(0, 4, 0, 0);
            SimpleTextView simpleTextView5 = this.statusTextView;
            boolean z3 = LocaleController.isRTL;
            addView(simpleTextView5, LayoutHelper.createFrame(-1, -2.0f, (z3 ? 3 : 5) | 16, z3 ? 28.0f : 52.0f, 0.0f, z3 ? 52.0f : 28.0f, 0.0f));
            return;
        }
        SimpleTextView simpleTextView6 = this.statusTextView;
        boolean z4 = LocaleController.isRTL;
        addView(simpleTextView6, LayoutHelper.createFrame(-1, 20.0f, (z4 ? 5 : 3) | 48, z4 ? 28.0f : 72.0f, 32.0f, z4 ? 72.0f : 28.0f, 0.0f));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.avatarImage.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.avatarImage.onAttachedToWindow();
    }

    public void setUser(ContactsController.Contact contact, CharSequence searchLabel) {
        CharSequence charSequence;
        this.currentContact = contact;
        if (!this.isSmall) {
            charSequence = searchLabel;
            this.currentName = charSequence;
        } else {
            charSequence = searchLabel;
            TLRPC$User tLRPC$User = contact.user;
            if (tLRPC$User != null) {
                this.currentName = UserObject.getUserName(tLRPC$User);
            } else {
                this.currentName = ContactsController.formatName(contact.first_name, contact.last_name);
            }
        }
        ContactsController.Contact contact2 = this.currentContact;
        if (contact2 == null) {
            return;
        }
        TLRPC$User tLRPC$User2 = contact2.user;
        if (tLRPC$User2 != null) {
            this.avatarDrawable.setInfo(tLRPC$User2);
            this.avatarImage.setImage(ImageLocation.getForUserOrChat(this.currentContact.user, 1), "50_50", ImageLocation.getForUserOrChat(this.currentContact.user, 2), "50_50", this.avatarDrawable, this.currentContact.user, 0);
        } else {
            this.avatarDrawable.setInfo(contact2.contact_id, contact2.first_name, contact2.last_name);
            this.avatarImage.setImage(ImageLocation.getForUserOrChat(null, 1), "50_50", ImageLocation.getForUserOrChat(null, 2), "50_50", this.avatarDrawable, (Object) null, 0);
        }
        CharSequence charSequence2 = this.currentName;
        if (charSequence2 != null) {
            this.nameTextView.setText(charSequence2, true);
        } else {
            SimpleTextView simpleTextView = this.nameTextView;
            ContactsController.Contact contact3 = this.currentContact;
            simpleTextView.setText(ContactsController.formatName(contact3.first_name, contact3.last_name));
        }
        ContactsController.Contact contact4 = this.currentContact;
        int i = contact4.imported;
        if (i > 0) {
            this.statusTextView.setText(LocaleController.formatPluralString("Eitaa Contacts", i));
        } else {
            this.statusTextView.setText(this.isSmall ? charSequence : contact4.phones.get(0));
        }
    }

    public ContactsController.Contact getContact() {
        return this.currentContact;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.isSmall ? 52.0f : 72.0f), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int iDp = AndroidUtilities.dp(this.isSmall ? 35.0f : 50.0f);
        int iDp2 = AndroidUtilities.dp(11.0f);
        ImageReceiver imageReceiver = this.avatarImage;
        float f = LocaleController.isRTL ? (right - iDp) - iDp2 : left + iDp2;
        float f2 = iDp;
        imageReceiver.setImageCoords(f, this.isSmall ? 5.0f : 11.0f, f2, f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        this.avatarImage.draw(canvas);
        canvas.restore();
        super.onDraw(canvas);
    }
}
