package ir.eitaa.ui.ActionBar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.FiltersView;
import ir.eitaa.ui.Components.RLottieDrawable;

/* loaded from: classes3.dex */
public class ActionBarMenu extends LinearLayout {
    protected boolean isActionMode;
    protected ActionBar parentActionBar;

    public ActionBarMenu(Context context, ActionBar layer) {
        super(context);
        setOrientation(0);
        this.parentActionBar = layer;
    }

    protected void updateItemsBackgroundColor() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                childAt.setBackgroundDrawable(Theme.createSelectorDrawable(this.isActionMode ? this.parentActionBar.itemsActionModeBackgroundColor : this.parentActionBar.itemsBackgroundColor));
            }
        }
    }

    protected void updateItemsColor() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).setIconColor(this.isActionMode ? this.parentActionBar.itemsActionModeColor : this.parentActionBar.itemsColor);
            }
        }
    }

    public ActionBarMenuItem addItem(int id, Drawable drawable) {
        return addItem(id, 0, null, this.isActionMode ? this.parentActionBar.itemsActionModeBackgroundColor : this.parentActionBar.itemsBackgroundColor, drawable, AndroidUtilities.dp(48.0f), null);
    }

    public ActionBarMenuItem addItem(int id, int icon) {
        return addItem(id, icon, this.isActionMode ? this.parentActionBar.itemsActionModeBackgroundColor : this.parentActionBar.itemsBackgroundColor, null);
    }

    public ActionBarMenuItem addItem(int id, int icon, Theme.ResourcesProvider resourcesProvider) {
        return addItem(id, icon, this.isActionMode ? this.parentActionBar.itemsActionModeBackgroundColor : this.parentActionBar.itemsBackgroundColor, resourcesProvider);
    }

    public ActionBarMenuItem addItem(int id, CharSequence text) {
        return addItem(id, 0, text, this.isActionMode ? this.parentActionBar.itemsActionModeBackgroundColor : this.parentActionBar.itemsBackgroundColor, null, 0, text);
    }

    public ActionBarMenuItem addItem(int id, int icon, int backgroundColor, Theme.ResourcesProvider resourcesProvider) {
        return addItem(id, icon, null, backgroundColor, null, AndroidUtilities.dp(48.0f), null, resourcesProvider);
    }

    public ActionBarMenuItem addItemWithWidth(int id, int icon, int width) {
        return addItem(id, icon, null, this.isActionMode ? this.parentActionBar.itemsActionModeBackgroundColor : this.parentActionBar.itemsBackgroundColor, null, width, null);
    }

    public ActionBarMenuItem addItemWithWidth(int id, int icon, int width, CharSequence title) {
        return addItem(id, icon, null, this.isActionMode ? this.parentActionBar.itemsActionModeBackgroundColor : this.parentActionBar.itemsBackgroundColor, null, width, title);
    }

    public ActionBarMenuItem addItem(int id, int icon, CharSequence text, int backgroundColor, Drawable drawable, int width, CharSequence title) {
        return addItem(id, icon, text, backgroundColor, drawable, width, title, null);
    }

    public ActionBarMenuItem addItem(int id, int icon, CharSequence text, int backgroundColor, Drawable drawable, int width, CharSequence title, Theme.ResourcesProvider resourcesProvider) {
        int i = width;
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(getContext(), this, backgroundColor, this.isActionMode ? this.parentActionBar.itemsActionModeColor : this.parentActionBar.itemsColor, text != null, resourcesProvider);
        actionBarMenuItem.setTag(Integer.valueOf(id));
        if (text != null) {
            actionBarMenuItem.textView.setText(text);
            if (i == 0) {
                i = -2;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -1);
            int iDp = AndroidUtilities.dp(14.0f);
            layoutParams.rightMargin = iDp;
            layoutParams.leftMargin = iDp;
            addView(actionBarMenuItem, layoutParams);
        } else {
            if (drawable != null) {
                if (drawable instanceof RLottieDrawable) {
                    actionBarMenuItem.iconView.setAnimation((RLottieDrawable) drawable);
                } else {
                    actionBarMenuItem.iconView.setImageDrawable(drawable);
                }
            } else if (icon != 0) {
                actionBarMenuItem.iconView.setImageResource(icon);
            }
            addView(actionBarMenuItem, new LinearLayout.LayoutParams(i, -1));
        }
        actionBarMenuItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ActionBarMenu$XtgHI_wlOmS3U7BURpKCpP-kPtY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$addItem$0$ActionBarMenu(view);
            }
        });
        if (title != null) {
            actionBarMenuItem.setContentDescription(title);
        }
        return actionBarMenuItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addItem$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addItem$0$ActionBarMenu(View view) {
        ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) view;
        if (actionBarMenuItem.hasSubMenu()) {
            if (this.parentActionBar.actionBarMenuOnItemClick.canOpenMenu()) {
                actionBarMenuItem.toggleSubMenu();
            }
        } else if (actionBarMenuItem.isSearchField()) {
            this.parentActionBar.onSearchFieldVisibilityChanged(actionBarMenuItem.toggleSearch(true));
        } else {
            onItemClick(((Integer) view.getTag()).intValue());
        }
    }

    public void hideAllPopupMenus() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).closeSubMenu();
            }
        }
    }

    protected void setPopupItemsColor(int color, boolean icon) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).setPopupItemsColor(color, icon);
            }
        }
    }

    protected void setPopupItemsSelectorColor(int color) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).setPopupItemsSelectorColor(color);
            }
        }
    }

    protected void redrawPopup(int color) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).redrawPopup(color);
            }
        }
    }

    public void onItemClick(int id) {
        ActionBar.ActionBarMenuOnItemClick actionBarMenuOnItemClick = this.parentActionBar.actionBarMenuOnItemClick;
        if (actionBarMenuOnItemClick != null) {
            actionBarMenuOnItemClick.onItemClick(id);
        }
    }

    public void clearItems() {
        removeAllViews();
    }

    public void onMenuButtonPressed() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.getVisibility() != 0) {
                    continue;
                } else if (actionBarMenuItem.hasSubMenu()) {
                    actionBarMenuItem.toggleSubMenu();
                    return;
                } else if (actionBarMenuItem.overrideMenuClick) {
                    onItemClick(((Integer) actionBarMenuItem.getTag()).intValue());
                    return;
                }
            }
        }
    }

    public void closeSearchField(boolean closeKeyboard) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.isSearchField() && actionBarMenuItem.isSearchFieldVisible()) {
                    ActionBarMenuItem.ActionBarMenuItemSearchListener actionBarMenuItemSearchListener = actionBarMenuItem.listener;
                    if (actionBarMenuItemSearchListener == null || actionBarMenuItemSearchListener.canCollapseSearch()) {
                        this.parentActionBar.onSearchFieldVisibilityChanged(false);
                        actionBarMenuItem.toggleSearch(closeKeyboard);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void setSearchTextColor(int color, boolean placeholder) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.isSearchField()) {
                    if (placeholder) {
                        actionBarMenuItem.getSearchField().setHintTextColor(color);
                        return;
                    } else {
                        actionBarMenuItem.getSearchField().setTextColor(color);
                        return;
                    }
                }
            }
        }
    }

    public void setSearchFieldText(String text) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.isSearchField()) {
                    actionBarMenuItem.setSearchFieldText(text, false);
                    actionBarMenuItem.getSearchField().setSelection(text.length());
                }
            }
        }
    }

    public void onSearchPressed() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.isSearchField()) {
                    actionBarMenuItem.onSearchPressed();
                }
            }
        }
    }

    public void openSearchField(boolean toggle, String text, boolean animated) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.isSearchField()) {
                    if (toggle) {
                        this.parentActionBar.onSearchFieldVisibilityChanged(actionBarMenuItem.toggleSearch(true));
                    }
                    actionBarMenuItem.setSearchFieldText(text, animated);
                    actionBarMenuItem.getSearchField().setSelection(text.length());
                    return;
                }
            }
        }
    }

    public void setFilter(FiltersView.MediaFilterData filter) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.isSearchField()) {
                    actionBarMenuItem.addSearchFilter(filter);
                    return;
                }
            }
        }
    }

    public ActionBarMenuItem getItem(int id) {
        View viewFindViewWithTag = findViewWithTag(Integer.valueOf(id));
        if (viewFindViewWithTag instanceof ActionBarMenuItem) {
            return (ActionBarMenuItem) viewFindViewWithTag;
        }
        return null;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setEnabled(enabled);
        }
    }

    public int getItemsMeasuredWidth() {
        int childCount = getChildCount();
        int measuredWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
        return measuredWidth;
    }

    public boolean searchFieldVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ActionBarMenuItem actionBarMenuItem = (ActionBarMenuItem) childAt;
                if (actionBarMenuItem.getSearchContainer() != null && actionBarMenuItem.getSearchContainer().getVisibility() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void translateXItems(int offset) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionBarMenuItem) {
                ((ActionBarMenuItem) childAt).setTransitionOffset(offset);
            }
        }
    }
}
