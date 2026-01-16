package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$TL_chatInviteExported;
import org.rbmain.tgnet.TLRPC$TL_contact;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messages_exportChatInvite;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Adapters.SearchAdapterHelper;
import org.rbmain.ui.Cells.GroupCreateSectionCell;
import org.rbmain.ui.Cells.GroupCreateUserCell;
import org.rbmain.ui.Cells.ManageChatTextCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.UsersAlertBase;
import org.rbmain.ui.GroupCreateActivity;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes5.dex */
public class InviteMembersBottomSheet extends UsersAlertBase implements NotificationCenter.NotificationCenterDelegate {
    private int additionalHeight;
    private int chatId;
    private ArrayList<TLObject> contacts;
    private int contactsEndRow;
    private int contactsStartRow;
    private int copyLinkRow;
    private AnimatorSet currentAnimation;
    private GroupCreateSpan currentDeletingSpan;
    private AnimatorSet currentDoneButtonAnimation;
    private GroupCreateActivity.ContactsAddActivityDelegate delegate;
    private InviteMembersBottomSheetDelegate dialogsDelegate;
    private ArrayList<TLRPC$Dialog> dialogsServerOnly;
    private int emptyRow;
    boolean enterEventSent;
    private final ImageView floatingButton;
    private SparseArray<TLObject> ignoreUsers;
    TLRPC$TL_chatInviteExported invite;
    private int lastRow;
    boolean linkGenerating;
    private int maxSize;
    private int noContactsStubRow;
    private BaseFragment parentFragment;
    private int rowCount;
    private int scrollViewH;
    private SearchAdapter searchAdapter;
    private int searchAdditionalHeight;
    private SparseArray<GroupCreateSpan> selectedContacts;
    private View.OnClickListener spanClickListener;
    private boolean spanEnter;
    private final SpansContainer spansContainer;
    private ValueAnimator spansEnterAnimator;
    private float spansEnterProgress;
    private final ScrollView spansScrollView;
    private float touchSlop;
    float y;

    public interface InviteMembersBottomSheetDelegate {
        void didSelectDialogs(ArrayList<Long> arrayList);
    }

    public InviteMembersBottomSheet(final Context context, int i, final SparseArray<TLObject> sparseArray, final int i2, final BaseFragment baseFragment) {
        super(context, false, i);
        this.contacts = new ArrayList<>();
        this.selectedContacts = new SparseArray<>();
        this.spansEnterProgress = 0.0f;
        this.spanClickListener = new View.OnClickListener() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupCreateSpan groupCreateSpan = (GroupCreateSpan) view;
                if (groupCreateSpan.isDeleting()) {
                    InviteMembersBottomSheet.this.currentDeletingSpan = null;
                    InviteMembersBottomSheet.this.selectedContacts.remove(groupCreateSpan.getUid());
                    InviteMembersBottomSheet.this.spansContainer.removeSpan(groupCreateSpan);
                    InviteMembersBottomSheet.this.spansCountChanged(true);
                    AndroidUtilities.updateVisibleRows(InviteMembersBottomSheet.this.listView);
                    return;
                }
                if (InviteMembersBottomSheet.this.currentDeletingSpan != null) {
                    InviteMembersBottomSheet.this.currentDeletingSpan.cancelDeleteAnimation();
                }
                InviteMembersBottomSheet.this.currentDeletingSpan = groupCreateSpan;
                groupCreateSpan.startDeleteAnimation();
            }
        };
        this.ignoreUsers = sparseArray;
        this.needSnapToTop = false;
        this.parentFragment = baseFragment;
        this.chatId = i2;
        this.searchView.searchEditText.setHint(LocaleController.getString("SearchForChats", R.string.SearchForChats));
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        SearchAdapter searchAdapter = new SearchAdapter();
        this.searchAdapter = searchAdapter;
        this.searchListViewAdapter = searchAdapter;
        RecyclerListView recyclerListView = this.listView;
        ListAdapter listAdapter = new ListAdapter();
        this.listViewAdapter = listAdapter;
        recyclerListView.setAdapter(listAdapter);
        ArrayList<TLRPC$TL_contact> arrayList = ContactsController.getInstance(i).contacts;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(arrayList.get(i3).user_id));
            if (user != null && !user.self && !user.deleted) {
                this.contacts.add(user);
            }
        }
        SpansContainer spansContainer = new SpansContainer(context);
        this.spansContainer = spansContainer;
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$$ExternalSyntheticLambda8
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i4) {
                this.f$0.lambda$new$0(i2, baseFragment, sparseArray, context, view, i4);
            }
        });
        this.listView.setItemAnimator(new ItemAnimator(this));
        updateRows();
        ScrollView scrollView = new ScrollView(context) { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.2
            @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i4, int i5) {
                int size = View.MeasureSpec.getSize(i4);
                int size2 = View.MeasureSpec.getSize(i5);
                if (AndroidUtilities.isTablet() || size2 > size) {
                    InviteMembersBottomSheet.this.maxSize = AndroidUtilities.dp(144.0f);
                } else {
                    InviteMembersBottomSheet.this.maxSize = AndroidUtilities.dp(56.0f);
                }
                super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(InviteMembersBottomSheet.this.maxSize, Integer.MIN_VALUE));
            }
        };
        this.spansScrollView = scrollView;
        scrollView.setVisibility(8);
        scrollView.setClipChildren(false);
        scrollView.addView(spansContainer);
        this.containerView.addView(scrollView);
        ImageView imageView = new ImageView(context);
        this.floatingButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor(Theme.key_chats_actionBackground), Theme.getColor(Theme.key_chats_actionPressedBackground));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 21) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        imageView.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chats_actionIcon), PorterDuff.Mode.MULTIPLY));
        imageView.setImageResource(R.drawable.floating_check);
        if (i4 >= 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(new int[]{android.R.attr.state_pressed}, ObjectAnimator.ofFloat(imageView, "translationZ", AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(imageView, "translationZ", AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            imageView.setStateListAnimator(stateListAnimator);
            imageView.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.3
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2(context, i2, view);
            }
        });
        imageView.setVisibility(4);
        imageView.setScaleX(0.0f);
        imageView.setScaleY(0.0f);
        imageView.setAlpha(0.0f);
        imageView.setContentDescription(LocaleController.getString("Next", R.string.Next));
        this.containerView.addView(imageView, LayoutHelper.createFrame(i4 >= 21 ? 56 : 60, i4 < 21 ? 60 : 56, 85, 14.0f, 14.0f, 14.0f, 14.0f));
        ((ViewGroup.MarginLayoutParams) this.emptyView.getLayoutParams()).topMargin = AndroidUtilities.dp(20.0f);
        ((ViewGroup.MarginLayoutParams) this.emptyView.getLayoutParams()).leftMargin = AndroidUtilities.dp(4.0f);
        ((ViewGroup.MarginLayoutParams) this.emptyView.getLayoutParams()).rightMargin = AndroidUtilities.dp(4.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i, BaseFragment baseFragment, SparseArray sparseArray, Context context, View view, int i2) {
        String str;
        TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported;
        int i3;
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        SearchAdapter searchAdapter = this.searchAdapter;
        TLObject object = null;
        if (adapter != searchAdapter) {
            if (i2 == this.copyLinkRow) {
                TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(i));
                TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount).getChatFull(i);
                if (chat != null && !TextUtils.isEmpty(chat.username)) {
                    str = "https://rubika.ir/" + chat.username;
                } else if (chatFull != null && (tLRPC$TL_chatInviteExported = chatFull.exported_invite) != null) {
                    str = tLRPC$TL_chatInviteExported.link;
                } else {
                    generateLink();
                    str = null;
                }
                if (str == null) {
                    return;
                }
                ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", str));
                dismiss();
                BulletinFactory.createCopyLinkBulletin(baseFragment).show();
            } else if (i2 >= this.contactsStartRow && i2 < this.contactsEndRow) {
                object = ((ListAdapter) this.listViewAdapter).getObject(i2);
            }
        } else {
            int size = searchAdapter.searchResult.size();
            int size2 = this.searchAdapter.searchAdapterHelper.getGlobalSearch().size();
            int size3 = this.searchAdapter.searchAdapterHelper.getLocalServerSearch().size();
            int i4 = i2 - 1;
            if (i4 >= 0 && i4 < size) {
                object = (TLObject) this.searchAdapter.searchResult.get(i4);
            } else if (i4 >= size && i4 < size3 + size) {
                object = this.searchAdapter.searchAdapterHelper.getLocalServerSearch().get(i4 - size);
            } else if (i4 > size + size3 && i4 <= size2 + size + size3) {
                object = this.searchAdapter.searchAdapterHelper.getGlobalSearch().get(((i4 - size) - size3) - 1);
            }
            if (this.dialogsDelegate != null) {
                this.searchView.closeSearch();
            }
        }
        if (object != null) {
            if (object instanceof TLRPC$User) {
                i3 = ((TLRPC$User) object).id;
            } else {
                i3 = object instanceof TLRPC$Chat ? -((TLRPC$Chat) object).id : 0;
            }
            if (sparseArray == null || sparseArray.indexOfKey(i3) < 0) {
                if (i3 != 0) {
                    if (this.selectedContacts.indexOfKey(i3) >= 0) {
                        GroupCreateSpan groupCreateSpan = this.selectedContacts.get(i3);
                        this.selectedContacts.remove(i3);
                        this.spansContainer.removeSpan(groupCreateSpan);
                    } else {
                        GroupCreateSpan groupCreateSpan2 = new GroupCreateSpan(context, object);
                        groupCreateSpan2.setOnClickListener(this.spanClickListener);
                        this.selectedContacts.put(i3, groupCreateSpan2);
                        this.spansContainer.addSpan(groupCreateSpan2, true);
                    }
                }
                spansCountChanged(true);
                AndroidUtilities.updateVisibleRows(this.listView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Context context, int i, View view) {
        Activity activityFindActivity;
        if ((this.dialogsDelegate == null && this.selectedContacts.size() == 0) || (activityFindActivity = AndroidUtilities.findActivity(context)) == null) {
            return;
        }
        if (this.dialogsDelegate != null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < this.selectedContacts.size(); i2++) {
                arrayList.add(Long.valueOf(this.selectedContacts.keyAt(i2)));
            }
            this.dialogsDelegate.didSelectDialogs(arrayList);
            dismiss();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activityFindActivity);
        if (this.selectedContacts.size() == 1) {
            builder.setTitle(LocaleController.getString("AddOneMemberAlertTitle", R.string.AddOneMemberAlertTitle));
        } else {
            builder.setTitle(LocaleController.formatString("AddMembersAlertTitle", R.string.AddMembersAlertTitle, LocaleController.formatPluralString("Members", this.selectedContacts.size())));
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < this.selectedContacts.size(); i3++) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(this.selectedContacts.keyAt(i3)));
            if (user != null) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("**");
                sb.append(ContactsController.formatName(user.first_name, user.last_name));
                sb.append("**");
            }
        }
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(i));
        if (this.selectedContacts.size() > 5) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(AndroidUtilities.replaceTags(LocaleController.formatString("AddMembersAlertNamesText", R.string.AddMembersAlertNamesText, LocaleController.formatPluralString("Members", this.selectedContacts.size()), chat.title)));
            String str = String.format("%d", Integer.valueOf(this.selectedContacts.size()));
            int iIndexOf = TextUtils.indexOf(spannableStringBuilder, str);
            if (iIndexOf >= 0) {
                spannableStringBuilder.setSpan(new TypefaceSpan(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM)), iIndexOf, str.length() + iIndexOf, 33);
            }
            builder.setMessage(spannableStringBuilder);
        } else {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("AddMembersAlertNamesText", R.string.AddMembersAlertNamesText, sb, chat.title)));
        }
        builder.setPositiveButton(LocaleController.getString("Add", R.string.Add), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                this.f$0.lambda$new$1(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.create();
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(DialogInterface dialogInterface, int i) {
        onAddToGroupDone(0);
    }

    private void onAddToGroupDone(int i) {
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.selectedContacts.size(); i2++) {
            arrayList.add(MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(this.selectedContacts.keyAt(i2))));
        }
        GroupCreateActivity.ContactsAddActivityDelegate contactsAddActivityDelegate = this.delegate;
        if (contactsAddActivityDelegate != null) {
            contactsAddActivityDelegate.didSelectUsers(arrayList, i);
        }
        dismiss();
    }

    @Override // org.rbmain.ui.Components.UsersAlertBase, org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.dialogsNeedReload);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSelectedContacts(java.util.ArrayList<java.lang.Long> r12) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.InviteMembersBottomSheet.setSelectedContacts(java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void spansCountChanged(boolean z) {
        final boolean z2 = this.selectedContacts.size() > 0;
        if (this.spanEnter != z2) {
            ValueAnimator valueAnimator = this.spansEnterAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.spansEnterAnimator.cancel();
            }
            this.spanEnter = z2;
            if (z2) {
                this.spansScrollView.setVisibility(0);
            }
            if (z) {
                float[] fArr = new float[2];
                fArr[0] = this.spansEnterProgress;
                fArr[1] = z2 ? 1.0f : 0.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
                this.spansEnterAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f$0.lambda$spansCountChanged$3(valueAnimator2);
                    }
                });
                this.spansEnterAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        InviteMembersBottomSheet.this.spansEnterProgress = z2 ? 1.0f : 0.0f;
                        ((BottomSheet) InviteMembersBottomSheet.this).containerView.invalidate();
                        if (z2) {
                            return;
                        }
                        InviteMembersBottomSheet.this.spansScrollView.setVisibility(8);
                    }
                });
                this.spansEnterAnimator.setDuration(150L);
                this.spansEnterAnimator.start();
                if (!this.spanEnter && this.dialogsDelegate == null) {
                    AnimatorSet animatorSet = this.currentDoneButtonAnimation;
                    if (animatorSet != null) {
                        animatorSet.cancel();
                    }
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.currentDoneButtonAnimation = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.SCALE_X, 0.0f), ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.SCALE_Y, 0.0f), ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                    this.currentDoneButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            InviteMembersBottomSheet.this.floatingButton.setVisibility(4);
                        }
                    });
                    this.currentDoneButtonAnimation.setDuration(180L);
                    this.currentDoneButtonAnimation.start();
                    return;
                }
                AnimatorSet animatorSet3 = this.currentDoneButtonAnimation;
                if (animatorSet3 != null) {
                    animatorSet3.cancel();
                }
                this.currentDoneButtonAnimation = new AnimatorSet();
                this.floatingButton.setVisibility(0);
                this.currentDoneButtonAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) View.ALPHA, 1.0f));
                this.currentDoneButtonAnimation.setDuration(180L);
                this.currentDoneButtonAnimation.start();
                return;
            }
            this.spansEnterProgress = z2 ? 1.0f : 0.0f;
            this.containerView.invalidate();
            if (!z2) {
                this.spansScrollView.setVisibility(8);
            }
            AnimatorSet animatorSet4 = this.currentDoneButtonAnimation;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
            if (!this.spanEnter && this.dialogsDelegate == null) {
                this.floatingButton.setScaleY(0.0f);
                this.floatingButton.setScaleX(0.0f);
                this.floatingButton.setAlpha(0.0f);
                this.floatingButton.setVisibility(4);
                return;
            }
            this.floatingButton.setScaleY(1.0f);
            this.floatingButton.setScaleX(1.0f);
            this.floatingButton.setAlpha(1.0f);
            this.floatingButton.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$spansCountChanged$3(ValueAnimator valueAnimator) {
        this.spansEnterProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.containerView.invalidate();
    }

    private void updateRows() {
        this.contactsStartRow = -1;
        this.contactsEndRow = -1;
        this.noContactsStubRow = -1;
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.emptyRow = 0;
        if (this.dialogsDelegate == null) {
            this.rowCount = i + 1;
            this.copyLinkRow = i;
            if (this.contacts.size() != 0) {
                int i2 = this.rowCount;
                this.contactsStartRow = i2;
                int size = i2 + this.contacts.size();
                this.rowCount = size;
                this.contactsEndRow = size;
            } else {
                int i3 = this.rowCount;
                this.rowCount = i3 + 1;
                this.noContactsStubRow = i3;
            }
        } else {
            this.copyLinkRow = -1;
            if (this.dialogsServerOnly.size() != 0) {
                int i4 = this.rowCount;
                this.contactsStartRow = i4;
                int size2 = i4 + this.dialogsServerOnly.size();
                this.rowCount = size2;
                this.contactsEndRow = size2;
            } else {
                int i5 = this.rowCount;
                this.rowCount = i5 + 1;
                this.noContactsStubRow = i5;
            }
        }
        int i6 = this.rowCount;
        this.rowCount = i6 + 1;
        this.lastRow = i6;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.dialogsNeedReload && this.dialogsDelegate != null && this.dialogsServerOnly.isEmpty()) {
            this.dialogsServerOnly = new ArrayList<>(MessagesController.getInstance(this.currentAccount).dialogsServerOnly);
            this.listViewAdapter.notifyDataSetChanged();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private ListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View groupCreateUserCell;
            Context context = viewGroup.getContext();
            if (i != 2) {
                int i2 = 0;
                if (i == 3) {
                    groupCreateUserCell = new GroupCreateUserCell(context, 1, 0, InviteMembersBottomSheet.this.dialogsDelegate != null);
                } else if (i == 4) {
                    groupCreateUserCell = new View(context);
                } else if (i != 5) {
                    ManageChatTextCell manageChatTextCell = new ManageChatTextCell(context);
                    manageChatTextCell.setText(LocaleController.getString("VoipGroupCopyInviteLink", R.string.VoipGroupCopyInviteLink), null, R.drawable.msg_link, 7, true);
                    int i3 = Theme.key_dialogTextBlue2;
                    manageChatTextCell.setColors(i3, i3);
                    groupCreateUserCell = manageChatTextCell;
                } else {
                    StickerEmptyView stickerEmptyView = new StickerEmptyView(this, context, null, i2) { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.ListAdapter.2
                        @Override // org.rbmain.ui.Components.StickerEmptyView, android.view.ViewGroup, android.view.View
                        protected void onAttachedToWindow() {
                            super.onAttachedToWindow();
                            this.stickerView.getImageReceiver().startAnimation();
                        }
                    };
                    stickerEmptyView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    stickerEmptyView.subtitle.setVisibility(8);
                    if (InviteMembersBottomSheet.this.dialogsDelegate != null) {
                        stickerEmptyView.title.setText(LocaleController.getString("FilterNoChats", R.string.FilterNoChats));
                    } else {
                        stickerEmptyView.title.setText(LocaleController.getString("NoContacts", R.string.NoContacts));
                    }
                    stickerEmptyView.setAnimateLayoutChange(true);
                    groupCreateUserCell = stickerEmptyView;
                }
            } else {
                groupCreateUserCell = new View(context) { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.ListAdapter.1
                    @Override // android.view.View
                    protected void onMeasure(int i4, int i5) {
                        super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f) + InviteMembersBottomSheet.this.additionalHeight, 1073741824));
                    }
                };
            }
            return new RecyclerListView.Holder(groupCreateUserCell);
        }

        public TLObject getObject(int i) {
            if (InviteMembersBottomSheet.this.dialogsDelegate == null) {
                return (TLObject) InviteMembersBottomSheet.this.contacts.get(i - InviteMembersBottomSheet.this.contactsStartRow);
            }
            int i2 = (int) ((TLRPC$Dialog) InviteMembersBottomSheet.this.dialogsServerOnly.get(i - InviteMembersBottomSheet.this.contactsStartRow)).id;
            return i2 > 0 ? MessagesController.getInstance(((BottomSheet) InviteMembersBottomSheet.this).currentAccount).getUser(Integer.valueOf(i2)) : MessagesController.getInstance(((BottomSheet) InviteMembersBottomSheet.this).currentAccount).getChat(Integer.valueOf(-i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int i2;
            int i3;
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 2) {
                viewHolder.itemView.requestLayout();
                return;
            }
            if (itemViewType != 3) {
                return;
            }
            GroupCreateUserCell groupCreateUserCell = (GroupCreateUserCell) viewHolder.itemView;
            TLObject object = getObject(i);
            Object object2 = groupCreateUserCell.getObject();
            if (object2 instanceof TLRPC$User) {
                i2 = ((TLRPC$User) object2).id;
            } else {
                i2 = object2 instanceof TLRPC$Chat ? -((TLRPC$Chat) object2).id : 0;
            }
            groupCreateUserCell.setObject(object, null, null, i != InviteMembersBottomSheet.this.contactsEndRow);
            if (object instanceof TLRPC$User) {
                i3 = ((TLRPC$User) object).id;
            } else {
                i3 = object instanceof TLRPC$Chat ? -((TLRPC$Chat) object).id : 0;
            }
            if (i3 != 0) {
                if (InviteMembersBottomSheet.this.ignoreUsers == null || InviteMembersBottomSheet.this.ignoreUsers.indexOfKey(i3) < 0) {
                    groupCreateUserCell.setChecked(InviteMembersBottomSheet.this.selectedContacts.indexOfKey(i3) >= 0, i2 == i3);
                    groupCreateUserCell.setCheckBoxEnabled(true);
                } else {
                    groupCreateUserCell.setChecked(true, false);
                    groupCreateUserCell.setCheckBoxEnabled(false);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == InviteMembersBottomSheet.this.copyLinkRow) {
                return 1;
            }
            if (i == InviteMembersBottomSheet.this.emptyRow) {
                return 2;
            }
            if (i >= InviteMembersBottomSheet.this.contactsStartRow && i < InviteMembersBottomSheet.this.contactsEndRow) {
                return 3;
            }
            if (i == InviteMembersBottomSheet.this.lastRow) {
                return 4;
            }
            return i == InviteMembersBottomSheet.this.noContactsStubRow ? 5 : 0;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 3 || viewHolder.getItemViewType() == 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return InviteMembersBottomSheet.this.rowCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private int currentItemsCount;
        private final SearchAdapterHelper searchAdapterHelper;
        private ArrayList<Object> searchResult = new ArrayList<>();
        private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
        private Runnable searchRunnable;

        public SearchAdapter() {
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(false);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$SearchAdapter$$ExternalSyntheticLambda4
                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ boolean canApplySearchResults(int i) {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public final void onDataSetChanged(int i) {
                    this.f$0.lambda$new$0(i);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(int i) {
            InviteMembersBottomSheet.this.showItemsAnimated(this.currentItemsCount - 1);
            if (this.searchRunnable == null && !this.searchAdapterHelper.isSearchInProgress() && getItemCount() <= 2) {
                InviteMembersBottomSheet.this.emptyView.showProgress(false, true);
            }
            notifyDataSetChanged();
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View groupCreateUserCell;
            Context context = viewGroup.getContext();
            if (i == 1) {
                groupCreateUserCell = new GroupCreateUserCell(context, 1, 0, false);
            } else if (i == 2) {
                groupCreateUserCell = new View(context) { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.SearchAdapter.1
                    @Override // android.view.View
                    protected void onMeasure(int i2, int i3) {
                        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f) + InviteMembersBottomSheet.this.additionalHeight + InviteMembersBottomSheet.this.searchAdditionalHeight, 1073741824));
                    }
                };
            } else if (i != 4) {
                groupCreateUserCell = new GroupCreateSectionCell(context);
            } else {
                groupCreateUserCell = new View(context);
            }
            return new RecyclerListView.Holder(groupCreateUserCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r10, int r11) {
            /*
                Method dump skipped, instructions count: 379
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.InviteMembersBottomSheet.SearchAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == 0) {
                return 2;
            }
            if (i == this.currentItemsCount - 1) {
                return 4;
            }
            return i + (-1) == this.searchResult.size() + this.searchAdapterHelper.getLocalServerSearch().size() ? 0 : 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = this.searchResult.size();
            int size2 = this.searchAdapterHelper.getLocalServerSearch().size();
            int size3 = this.searchAdapterHelper.getGlobalSearch().size();
            int i = size + size2;
            if (size3 != 0) {
                i += size3 + 1;
            }
            int i2 = i + 2;
            this.currentItemsCount = i2;
            return i2;
        }

        private void updateSearchResults(final ArrayList<Object> arrayList, final ArrayList<CharSequence> arrayList2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$SearchAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$1(arrayList, arrayList2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$1(ArrayList arrayList, ArrayList arrayList2) {
            this.searchRunnable = null;
            this.searchResult = arrayList;
            this.searchResultNames = arrayList2;
            this.searchAdapterHelper.mergeResults(arrayList);
            InviteMembersBottomSheet.this.showItemsAnimated(this.currentItemsCount - 1);
            notifyDataSetChanged();
            if (this.searchAdapterHelper.isSearchInProgress() || getItemCount() > 2) {
                return;
            }
            InviteMembersBottomSheet.this.emptyView.showProgress(false, true);
        }

        public void searchDialogs(final String str) {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            this.searchResult.clear();
            this.searchResultNames.clear();
            this.searchAdapterHelper.mergeResults(null);
            this.searchAdapterHelper.queryServerSearch(null, true, false, false, false, false, 0, false, 0, 0);
            notifyDataSetChanged();
            if (!TextUtils.isEmpty(str)) {
                RecyclerView.Adapter adapter = InviteMembersBottomSheet.this.listView.getAdapter();
                InviteMembersBottomSheet inviteMembersBottomSheet = InviteMembersBottomSheet.this;
                RecyclerListView.SelectionAdapter selectionAdapter = inviteMembersBottomSheet.searchListViewAdapter;
                if (adapter != selectionAdapter) {
                    inviteMembersBottomSheet.listView.setAdapter(selectionAdapter);
                }
                InviteMembersBottomSheet.this.emptyView.showProgress(true, false);
                DispatchQueue dispatchQueue = Utilities.searchQueue;
                Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$SearchAdapter$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$searchDialogs$4(str);
                    }
                };
                this.searchRunnable = runnable;
                dispatchQueue.postRunnable(runnable, 300L);
                return;
            }
            RecyclerView.Adapter adapter2 = InviteMembersBottomSheet.this.listView.getAdapter();
            InviteMembersBottomSheet inviteMembersBottomSheet2 = InviteMembersBottomSheet.this;
            RecyclerListView.SelectionAdapter selectionAdapter2 = inviteMembersBottomSheet2.listViewAdapter;
            if (adapter2 != selectionAdapter2) {
                inviteMembersBottomSheet2.listView.setAdapter(selectionAdapter2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchDialogs$4(final String str) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$SearchAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$3(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchDialogs$3(final String str) {
            this.searchAdapterHelper.queryServerSearch(str, true, InviteMembersBottomSheet.this.dialogsDelegate != null, true, InviteMembersBottomSheet.this.dialogsDelegate != null, false, 0, false, 0, 0);
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$SearchAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$2(str);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0130 A[LOOP:1: B:29:0x0094->B:54:0x0130, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00e0 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$searchDialogs$2(java.lang.String r18) {
            /*
                Method dump skipped, instructions count: 324
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.InviteMembersBottomSheet.SearchAdapter.lambda$searchDialogs$2(java.lang.String):void");
        }
    }

    @Override // org.rbmain.ui.Components.UsersAlertBase
    protected void onSearchViewTouched(MotionEvent motionEvent, final EditTextBoldCursor editTextBoldCursor) throws Resources.NotFoundException {
        if (motionEvent.getAction() == 0) {
            this.y = this.scrollOffsetY;
            return;
        }
        if (motionEvent.getAction() != 1 || Math.abs(this.scrollOffsetY - this.y) >= this.touchSlop || this.enterEventSent) {
            return;
        }
        Activity activityFindActivity = AndroidUtilities.findActivity(getContext());
        BaseFragment baseFragment = null;
        if (activityFindActivity instanceof LaunchActivity) {
            LaunchActivity launchActivity = (LaunchActivity) activityFindActivity;
            baseFragment = launchActivity.getActionBarLayout().fragmentsStack.get(launchActivity.getActionBarLayout().fragmentsStack.size() - 1);
        }
        if (baseFragment instanceof ChatActivity) {
            boolean zNeedEnterText = ((ChatActivity) baseFragment).needEnterText();
            this.enterEventSent = true;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSearchViewTouched$5(editTextBoldCursor);
                }
            }, zNeedEnterText ? 200L : 0L);
        } else {
            this.enterEventSent = true;
            setFocusable(true);
            editTextBoldCursor.requestFocus();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidUtilities.showKeyboard(editTextBoldCursor);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSearchViewTouched$5(final EditTextBoldCursor editTextBoldCursor) {
        setFocusable(true);
        editTextBoldCursor.requestFocus();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AndroidUtilities.showKeyboard(editTextBoldCursor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SpansContainer extends ViewGroup {
        boolean addAnimation;
        private boolean animationStarted;
        private ArrayList<Animator> animators;
        private View removingSpan;

        public SpansContainer(Context context) {
            super(context);
            this.animators = new ArrayList<>();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
            int childCount = getChildCount();
            int size = View.MeasureSpec.getSize(i);
            int iDp = size - AndroidUtilities.dp(26.0f);
            int iDp2 = AndroidUtilities.dp(10.0f);
            int iDp3 = AndroidUtilities.dp(10.0f);
            int measuredWidth = 0;
            int measuredWidth2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof GroupCreateSpan) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
                    if (childAt != this.removingSpan && childAt.getMeasuredWidth() + measuredWidth > iDp) {
                        iDp2 += childAt.getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                        measuredWidth = 0;
                    }
                    if (childAt.getMeasuredWidth() + measuredWidth2 > iDp) {
                        iDp3 += childAt.getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                        measuredWidth2 = 0;
                    }
                    int iDp4 = AndroidUtilities.dp(13.0f) + measuredWidth;
                    if (!this.animationStarted) {
                        View view = this.removingSpan;
                        if (childAt == view) {
                            childAt.setTranslationX(AndroidUtilities.dp(13.0f) + measuredWidth2);
                            childAt.setTranslationY(iDp3);
                        } else if (view != null) {
                            float f = iDp4;
                            if (childAt.getTranslationX() != f) {
                                this.animators.add(ObjectAnimator.ofFloat(childAt, (Property<View, Float>) View.TRANSLATION_X, f));
                            }
                            float f2 = iDp2;
                            if (childAt.getTranslationY() != f2) {
                                this.animators.add(ObjectAnimator.ofFloat(childAt, (Property<View, Float>) View.TRANSLATION_Y, f2));
                            }
                        } else {
                            childAt.setTranslationX(iDp4);
                            childAt.setTranslationY(iDp2);
                        }
                    }
                    if (childAt != this.removingSpan) {
                        measuredWidth += childAt.getMeasuredWidth() + AndroidUtilities.dp(9.0f);
                    }
                    measuredWidth2 += childAt.getMeasuredWidth() + AndroidUtilities.dp(9.0f);
                }
            }
            int iDp5 = iDp3 + AndroidUtilities.dp(42.0f);
            final int iDp6 = iDp2 + AndroidUtilities.dp(42.0f);
            int iMin = InviteMembersBottomSheet.this.dialogsDelegate != null ? InviteMembersBottomSheet.this.spanEnter ? Math.min(InviteMembersBottomSheet.this.maxSize, iDp6) : 0 : Math.max(0, Math.min(InviteMembersBottomSheet.this.maxSize, iDp6) - AndroidUtilities.dp(52.0f));
            int i4 = InviteMembersBottomSheet.this.searchAdditionalHeight;
            InviteMembersBottomSheet inviteMembersBottomSheet = InviteMembersBottomSheet.this;
            inviteMembersBottomSheet.searchAdditionalHeight = (inviteMembersBottomSheet.dialogsDelegate != null || InviteMembersBottomSheet.this.selectedContacts.size() <= 0) ? 0 : AndroidUtilities.dp(56.0f);
            if (iMin != InviteMembersBottomSheet.this.additionalHeight || i4 != InviteMembersBottomSheet.this.searchAdditionalHeight) {
                InviteMembersBottomSheet.this.additionalHeight = iMin;
                if (InviteMembersBottomSheet.this.listView.getAdapter() != null && InviteMembersBottomSheet.this.listView.getAdapter().getItemCount() > 0 && (viewHolderFindViewHolderForAdapterPosition = InviteMembersBottomSheet.this.listView.findViewHolderForAdapterPosition(0)) != null) {
                    InviteMembersBottomSheet.this.listView.getAdapter().notifyItemChanged(0);
                    InviteMembersBottomSheet.this.layoutManager.scrollToPositionWithOffset(0, viewHolderFindViewHolderForAdapterPosition.itemView.getTop() - InviteMembersBottomSheet.this.listView.getPaddingTop());
                }
            }
            int iMin2 = Math.min(InviteMembersBottomSheet.this.maxSize, iDp6);
            if (InviteMembersBottomSheet.this.scrollViewH != iMin2) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(InviteMembersBottomSheet.this.scrollViewH, iMin2);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$SpansContainer$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onMeasure$0(valueAnimator);
                    }
                });
                this.animators.add(valueAnimatorOfInt);
            }
            if (this.addAnimation && iDp6 > InviteMembersBottomSheet.this.maxSize) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$SpansContainer$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onMeasure$1(iDp6);
                    }
                });
            } else if (!this.addAnimation && InviteMembersBottomSheet.this.spansScrollView.getScrollY() + InviteMembersBottomSheet.this.spansScrollView.getMeasuredHeight() > iDp6) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$SpansContainer$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onMeasure$2(iDp6);
                    }
                });
            }
            if (!this.animationStarted && InviteMembersBottomSheet.this.currentAnimation != null) {
                InviteMembersBottomSheet.this.currentAnimation.playTogether(this.animators);
                InviteMembersBottomSheet.this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.SpansContainer.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        InviteMembersBottomSheet.this.currentAnimation = null;
                        SpansContainer.this.requestLayout();
                    }
                });
                InviteMembersBottomSheet.this.currentAnimation.start();
                this.animationStarted = true;
            }
            if (InviteMembersBottomSheet.this.currentAnimation == null) {
                InviteMembersBottomSheet.this.scrollViewH = iMin2;
                ((BottomSheet) InviteMembersBottomSheet.this).containerView.invalidate();
            }
            setMeasuredDimension(size, Math.max(iDp6, iDp5));
            InviteMembersBottomSheet.this.listView.setTranslationY(0.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMeasure$0(ValueAnimator valueAnimator) {
            InviteMembersBottomSheet.this.scrollViewH = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ((BottomSheet) InviteMembersBottomSheet.this).containerView.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMeasure$1(int i) {
            InviteMembersBottomSheet.this.spansScrollView.smoothScrollTo(0, i - InviteMembersBottomSheet.this.maxSize);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMeasure$2(int i) {
            InviteMembersBottomSheet.this.spansScrollView.smoothScrollTo(0, i - InviteMembersBottomSheet.this.maxSize);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        public void addSpan(GroupCreateSpan groupCreateSpan, boolean z) {
            this.addAnimation = true;
            InviteMembersBottomSheet.this.selectedContacts.put(groupCreateSpan.getUid(), groupCreateSpan);
            if (InviteMembersBottomSheet.this.currentAnimation != null) {
                InviteMembersBottomSheet.this.currentAnimation.setupEndValues();
                InviteMembersBottomSheet.this.currentAnimation.cancel();
            }
            this.animationStarted = false;
            if (z) {
                InviteMembersBottomSheet.this.currentAnimation = new AnimatorSet();
                InviteMembersBottomSheet.this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.SpansContainer.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        InviteMembersBottomSheet.this.currentAnimation = null;
                        SpansContainer.this.animationStarted = false;
                    }
                });
                InviteMembersBottomSheet.this.currentAnimation.setDuration(150L);
                InviteMembersBottomSheet.this.currentAnimation.setInterpolator(CubicBezierInterpolator.DEFAULT);
                this.animators.clear();
                this.animators.add(ObjectAnimator.ofFloat(groupCreateSpan, (Property<GroupCreateSpan, Float>) View.SCALE_X, 0.01f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(groupCreateSpan, (Property<GroupCreateSpan, Float>) View.SCALE_Y, 0.01f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(groupCreateSpan, (Property<GroupCreateSpan, Float>) View.ALPHA, 0.0f, 1.0f));
            }
            addView(groupCreateSpan);
        }

        public void removeSpan(final GroupCreateSpan groupCreateSpan) {
            this.addAnimation = false;
            InviteMembersBottomSheet.this.selectedContacts.remove(groupCreateSpan.getUid());
            groupCreateSpan.setOnClickListener(null);
            if (InviteMembersBottomSheet.this.currentAnimation != null) {
                InviteMembersBottomSheet.this.currentAnimation.setupEndValues();
                InviteMembersBottomSheet.this.currentAnimation.cancel();
            }
            this.animationStarted = false;
            InviteMembersBottomSheet.this.currentAnimation = new AnimatorSet();
            InviteMembersBottomSheet.this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.SpansContainer.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SpansContainer.this.removeView(groupCreateSpan);
                    SpansContainer.this.removingSpan = null;
                    InviteMembersBottomSheet.this.currentAnimation = null;
                    SpansContainer.this.animationStarted = false;
                }
            });
            InviteMembersBottomSheet.this.currentAnimation.setDuration(150L);
            this.removingSpan = groupCreateSpan;
            this.animators.clear();
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, (Property<View, Float>) View.SCALE_X, 1.0f, 0.01f));
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, (Property<View, Float>) View.SCALE_Y, 1.0f, 0.01f));
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f));
            requestLayout();
        }
    }

    @Override // org.rbmain.ui.Components.UsersAlertBase
    protected UsersAlertBase.ContainerView createContainerView(Context context) {
        return new UsersAlertBase.ContainerView(context) { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet.6
            float animateToEmptyViewOffset;
            float deltaOffset;
            float emptyViewOffset;
            Paint paint = new Paint();
            private VerticalPositionAutoAnimator verticalPositionAutoAnimator;

            @Override // android.view.ViewGroup
            public void onViewAdded(View view) {
                if (view == InviteMembersBottomSheet.this.floatingButton && this.verticalPositionAutoAnimator == null) {
                    this.verticalPositionAutoAnimator = VerticalPositionAutoAnimator.attach(view);
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                VerticalPositionAutoAnimator verticalPositionAutoAnimator = this.verticalPositionAutoAnimator;
                if (verticalPositionAutoAnimator != null) {
                    verticalPositionAutoAnimator.ignoreNextLayout();
                }
            }

            @Override // org.rbmain.ui.Components.UsersAlertBase.ContainerView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                InviteMembersBottomSheet inviteMembersBottomSheet = InviteMembersBottomSheet.this;
                InviteMembersBottomSheet.this.spansScrollView.setTranslationY((inviteMembersBottomSheet.scrollOffsetY - ((BottomSheet) inviteMembersBottomSheet).backgroundPaddingTop) + AndroidUtilities.dp(6.0f) + AndroidUtilities.dp(64.0f));
                float f = InviteMembersBottomSheet.this.additionalHeight + InviteMembersBottomSheet.this.searchAdditionalHeight;
                if (InviteMembersBottomSheet.this.emptyView.getVisibility() != 0) {
                    this.emptyViewOffset = f;
                    this.animateToEmptyViewOffset = f;
                } else if (this.animateToEmptyViewOffset != f) {
                    this.animateToEmptyViewOffset = f;
                    this.deltaOffset = (f - this.emptyViewOffset) * 0.10666667f;
                }
                float f2 = this.emptyViewOffset;
                float f3 = this.animateToEmptyViewOffset;
                if (f2 != f3) {
                    float f4 = this.deltaOffset;
                    float f5 = f2 + f4;
                    this.emptyViewOffset = f5;
                    if (f4 > 0.0f && f5 > f3) {
                        this.emptyViewOffset = f3;
                    } else if (f4 < 0.0f && f5 < f3) {
                        this.emptyViewOffset = f3;
                    } else {
                        invalidate();
                    }
                }
                InviteMembersBottomSheet.this.emptyView.setTranslationY(r0.scrollOffsetY + this.emptyViewOffset);
                super.dispatchDraw(canvas);
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                if (view == InviteMembersBottomSheet.this.spansScrollView) {
                    canvas.save();
                    canvas.clipRect(0.0f, view.getY() - AndroidUtilities.dp(4.0f), getMeasuredWidth(), view.getY() + InviteMembersBottomSheet.this.scrollViewH + 1.0f);
                    canvas.drawColor(ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_windowBackgroundWhite), (int) (InviteMembersBottomSheet.this.spansEnterProgress * 255.0f)));
                    this.paint.setColor(ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_divider), (int) (InviteMembersBottomSheet.this.spansEnterProgress * 255.0f)));
                    canvas.drawRect(0.0f, view.getY() + InviteMembersBottomSheet.this.scrollViewH, getMeasuredWidth(), view.getY() + InviteMembersBottomSheet.this.scrollViewH + 1.0f, this.paint);
                    boolean zDrawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return zDrawChild;
                }
                return super.drawChild(canvas, view, j);
            }
        };
    }

    @Override // org.rbmain.ui.Components.UsersAlertBase
    protected void search(String str) {
        this.searchAdapter.searchDialogs(str);
    }

    public void setDelegate(GroupCreateActivity.ContactsAddActivityDelegate contactsAddActivityDelegate) {
        this.delegate = contactsAddActivityDelegate;
    }

    public void setDelegate(InviteMembersBottomSheetDelegate inviteMembersBottomSheetDelegate, ArrayList<Long> arrayList) {
        this.dialogsDelegate = inviteMembersBottomSheetDelegate;
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.dialogsNeedReload);
        this.dialogsServerOnly = new ArrayList<>(MessagesController.getInstance(this.currentAccount).dialogsServerOnly);
        updateRows();
    }

    private class ItemAnimator extends DefaultItemAnimator {
        public ItemAnimator(InviteMembersBottomSheet inviteMembersBottomSheet) {
            this.translationInterpolator = CubicBezierInterpolator.DEFAULT;
            setMoveDuration(150L);
            setAddDuration(150L);
            setRemoveDuration(150L);
            inviteMembersBottomSheet.setShowWithoutAnimation(false);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        super.dismissInternal();
        if (this.enterEventSent) {
            Activity activityFindActivity = AndroidUtilities.findActivity(getContext());
            if (activityFindActivity instanceof LaunchActivity) {
                LaunchActivity launchActivity = (LaunchActivity) activityFindActivity;
                BaseFragment baseFragment = launchActivity.getActionBarLayout().fragmentsStack.get(launchActivity.getActionBarLayout().fragmentsStack.size() - 1);
                if (baseFragment instanceof ChatActivity) {
                    ((ChatActivity) baseFragment).onEditTextDialogClose(true, true);
                }
            }
        }
    }

    private void generateLink() {
        if (this.linkGenerating) {
            return;
        }
        this.linkGenerating = true;
        TLRPC$TL_messages_exportChatInvite tLRPC$TL_messages_exportChatInvite = new TLRPC$TL_messages_exportChatInvite();
        tLRPC$TL_messages_exportChatInvite.legacy_revoke_permanent = true;
        tLRPC$TL_messages_exportChatInvite.peer = MessagesController.getInstance(this.currentAccount).getInputPeer(-this.chatId);
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_exportChatInvite, new RequestDelegate() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$$ExternalSyntheticLambda7
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$generateLink$8(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateLink$8(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.InviteMembersBottomSheet$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateLink$7(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateLink$7(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            this.invite = (TLRPC$TL_chatInviteExported) tLObject;
            TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount).getChatFull(this.chatId);
            if (chatFull != null) {
                chatFull.exported_invite = this.invite;
            }
            if (this.invite.link == null) {
                return;
            }
            ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", this.invite.link));
            BulletinFactory.createCopyLinkBulletin(this.parentFragment).show();
            dismiss();
        }
        this.linkGenerating = false;
    }
}
