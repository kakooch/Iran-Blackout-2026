package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.helper.MxbHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CheckBox2;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class InviteUserCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private CheckBox2 checkBox;
    private ContactsController.Contact currentContact;
    private CharSequence currentName;
    private ImageView mxbButton;
    private MxbHelper.MxbDelegate mxbDelegate;
    private SimpleTextView nameTextView;
    private SimpleTextView statusTextView;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public InviteUserCell(Context context, boolean needCheck) {
        super(context);
        this.avatarDrawable = new AvatarDrawable();
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(24.0f));
        View view = this.avatarImageView;
        boolean z = LocaleController.isRTL;
        addView(view, LayoutHelper.createFrame(50, 50.0f, (z ? 5 : 3) | 48, z ? 0.0f : 11.0f, 11.0f, z ? 11.0f : 0.0f, 0.0f));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.matap_ic);
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
        boolean z2 = LocaleController.isRTL;
        addView(imageView, LayoutHelper.createFrame(24, 24.0f, (z2 ? 5 : 3) | 48, z2 ? 28.0f : 72.0f, 10.0f, z2 ? 72.0f : 28.0f, 0.0f));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.nameTextView.setTextSize(17);
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view2 = this.nameTextView;
        boolean z3 = LocaleController.isRTL;
        addView(view2, LayoutHelper.createFrame(-1, 24.0f, (z3 ? 5 : 3) | 48, z3 ? 28.0f : R.styleable.AppCompatTheme_textColorAlertDialogListItem, 14.0f, z3 ? R.styleable.AppCompatTheme_textColorAlertDialogListItem : 28.0f, 0.0f));
        SimpleTextView simpleTextView2 = new SimpleTextView(context);
        this.statusTextView = simpleTextView2;
        simpleTextView2.setTextSize(16);
        this.statusTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.statusTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view3 = this.statusTextView;
        boolean z4 = LocaleController.isRTL;
        addView(view3, LayoutHelper.createFrame(-1, 20.0f, (z4 ? 5 : 3) | 48, z4 ? 28.0f : 72.0f, 39.0f, z4 ? 72.0f : 28.0f, 0.0f));
        int iDp = AndroidUtilities.dp(4.0f);
        ImageView imageView2 = new ImageView(context);
        this.mxbButton = imageView2;
        imageView2.setImageResource(R.drawable.matap_ic);
        this.mxbButton.setPadding(iDp, iDp, iDp, iDp);
        this.mxbButton.setBackgroundDrawable(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 50)));
        this.mxbButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.InviteUserCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (InviteUserCell.this.mxbDelegate != null) {
                    InviteUserCell.this.mxbDelegate.onMxbPressed(InviteUserCell.this.currentContact.phones.get(0));
                }
            }
        });
        addView(this.mxbButton, LayoutHelper.createFrame(32, 32.0f, (LocaleController.isRTL ? 3 : 5) | 16, 16.0f, 0.0f, 16.0f, 0.0f));
        if (needCheck) {
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setColor(null, "windowBackgroundWhite", "checkboxCheck");
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(3);
            View view4 = this.checkBox;
            boolean z5 = LocaleController.isRTL;
            addView(view4, LayoutHelper.createFrame(24, 24.0f, (z5 ? 5 : 3) | 48, z5 ? 0.0f : 40.0f, 40.0f, z5 ? 39.0f : 0.0f, 0.0f));
        }
    }

    public void setUser(ContactsController.Contact contact, CharSequence name, boolean showMxb) {
        this.currentContact = contact;
        this.currentName = name;
        if (showMxb) {
            this.mxbButton.setVisibility(0);
        } else {
            this.mxbButton.setVisibility(4);
        }
        update(0);
    }

    public void setChecked(boolean checked, boolean animated) {
        this.checkBox.setChecked(checked, animated);
    }

    public ContactsController.Contact getContact() {
        return this.currentContact;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(72.0f), 1073741824));
    }

    public void recycle() {
        this.avatarImageView.getImageReceiver().cancelLoadImage();
    }

    public void update(int mask) {
        ContactsController.Contact contact = this.currentContact;
        if (contact == null) {
            return;
        }
        this.avatarDrawable.setInfo(contact.contact_id, contact.first_name, contact.last_name);
        CharSequence charSequence = this.currentName;
        if (charSequence != null) {
            this.nameTextView.setText(charSequence, true);
        } else {
            SimpleTextView simpleTextView = this.nameTextView;
            ContactsController.Contact contact2 = this.currentContact;
            simpleTextView.setText(ContactsController.formatName(contact2.first_name, contact2.last_name));
        }
        this.statusTextView.setTag("windowBackgroundWhiteGrayText");
        this.statusTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        ContactsController.Contact contact3 = this.currentContact;
        int i = contact3.imported;
        if (i > 0) {
            this.statusTextView.setText(LocaleController.formatPluralString("Eitaa Contacts", i));
        } else {
            this.statusTextView.setText(contact3.phones.get(0));
        }
        this.avatarImageView.setImageDrawable(this.avatarDrawable);
    }

    public void setMxbDelegate(MxbHelper.MxbDelegate mxbDelegate) {
        this.mxbDelegate = mxbDelegate;
    }
}
