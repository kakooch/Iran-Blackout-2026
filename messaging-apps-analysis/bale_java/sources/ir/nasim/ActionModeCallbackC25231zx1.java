package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import ir.nasim.C9475a16;
import ir.nasim.chat.inputbar.BarEditText;

/* renamed from: ir.nasim.zx1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ActionModeCallbackC25231zx1 implements ActionMode.Callback {
    public static final a e = new a(null);
    public static final int f = 8;
    private final BarEditText a;
    private final InterfaceC14603iB2 b;
    private int c;
    private int d;

    /* renamed from: ir.nasim.zx1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public ActionModeCallbackC25231zx1(BarEditText barEditText, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "showAddLinkDialog");
        this.a = barEditText;
        this.b = interfaceC14603iB2;
        this.c = -1;
        this.d = -1;
    }

    private final boolean b(String str, int i, boolean z) {
        if (z) {
            if (i > 0) {
                Character chT1 = AbstractC22039uZ6.t1(str, i - 1);
                if (chT1 != null ? Character.isLetterOrDigit(chT1.charValue()) : false) {
                    return true;
                }
            }
        } else if (i < str.length()) {
            Character chT12 = AbstractC22039uZ6.t1(str, i);
            if (chT12 != null ? Character.isLetterOrDigit(chT12.charValue()) : false) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence c(String str) {
        AbstractC13042fc3.i(str, "it");
        if (AbstractC20153rZ6.S(str, "- [ ]", false, 2, null) || AbstractC20153rZ6.S(str, "- [x]", false, 2, null) || AbstractC20153rZ6.S(str, "- [X]", false, 2, null) || AbstractC20762sZ6.n0(str)) {
            return str;
        }
        return "- [ ] " + str;
    }

    private final boolean d(BarEditText barEditText, Menu menu) {
        if (barEditText == null) {
            return false;
        }
        this.c = barEditText.getSelectionStart();
        int selectionEnd = barEditText.getSelectionEnd();
        this.d = selectionEnd;
        int i = this.c;
        if (i != -1 && selectionEnd != -1) {
            if (i != selectionEnd) {
                menu.add(1, 25, 196608, barEditText.getContext().getString(DD5.features_chat_bold));
                menu.add(1, 26, 196608, barEditText.getContext().getString(DD5.features_chat_italic));
                menu.add(1, 28, 196608, barEditText.getContext().getString(DD5.features_chat_link));
            }
            if (C8386Vt0.z5()) {
                menu.add(1, 27, 196608, barEditText.getContext().getString(DD5.features_chat_checkbox));
            }
        }
        return true;
    }

    private final boolean e(BarEditText barEditText) {
        if (barEditText == null) {
            return false;
        }
        this.c = barEditText.getSelectionStart();
        this.d = barEditText.getSelectionEnd();
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        Object objB;
        Object objB2;
        Object objB3;
        AbstractC13042fc3.i(actionMode, "mode");
        AbstractC13042fc3.i(menuItem, "item");
        BarEditText barEditText = this.a;
        if (barEditText == null) {
            return false;
        }
        int selectionStart = barEditText.getSelectionStart();
        int selectionEnd = barEditText.getSelectionEnd();
        String string = barEditText.getText().toString();
        String strSubstring = string.substring(selectionStart, selectionEnd);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        String str = b(string, selectionStart, true) ? Separators.SP : "";
        String str2 = b(string, selectionEnd, false) ? Separators.SP : "";
        if (selectionStart == -1 || selectionEnd == -1) {
            return false;
        }
        switch (menuItem.getItemId()) {
            case 25:
                try {
                    C9475a16.a aVar = C9475a16.b;
                    String strSubstring2 = string.substring(0, selectionStart);
                    AbstractC13042fc3.h(strSubstring2, "substring(...)");
                    String strSubstring3 = string.substring(selectionEnd);
                    AbstractC13042fc3.h(strSubstring3, "substring(...)");
                    barEditText.setText(strSubstring2 + str + Separators.STAR + strSubstring + Separators.STAR + str2 + strSubstring3);
                    barEditText.setSelection(selectionStart, selectionEnd + 2 + str.length());
                    actionMode.finish();
                    objB2 = C9475a16.b(C19938rB7.a);
                } catch (Throwable th) {
                    C9475a16.a aVar2 = C9475a16.b;
                    objB2 = C9475a16.b(AbstractC10685c16.a(th));
                }
                return C9475a16.j(objB2);
            case 26:
                try {
                    C9475a16.a aVar3 = C9475a16.b;
                    String strSubstring4 = string.substring(0, selectionStart);
                    AbstractC13042fc3.h(strSubstring4, "substring(...)");
                    String strSubstring5 = string.substring(selectionEnd);
                    AbstractC13042fc3.h(strSubstring5, "substring(...)");
                    barEditText.setText(strSubstring4 + str + "_" + strSubstring + "_" + str2 + strSubstring5);
                    barEditText.setSelection(selectionStart, selectionEnd + 2 + str.length());
                    actionMode.finish();
                    objB3 = C9475a16.b(C19938rB7.a);
                } catch (Throwable th2) {
                    C9475a16.a aVar4 = C9475a16.b;
                    objB3 = C9475a16.b(AbstractC10685c16.a(th2));
                }
                return C9475a16.j(objB3);
            case 27:
                try {
                    C9475a16.a aVar5 = C9475a16.b;
                    int iQ0 = AbstractC20762sZ6.q0(string, '\n', selectionStart - 1, false, 4, null);
                    int i = iQ0 == -1 ? 0 : iQ0 + 1;
                    int iK0 = AbstractC20762sZ6.k0(string, '\n', selectionEnd, false, 4, null);
                    if (iK0 == -1) {
                        iK0 = string.length();
                    }
                    String strSubstring6 = string.substring(0, i);
                    AbstractC13042fc3.h(strSubstring6, "substring(...)");
                    String strSubstring7 = string.substring(i, iK0);
                    AbstractC13042fc3.h(strSubstring7, "substring(...)");
                    String strSubstring8 = string.substring(iK0);
                    AbstractC13042fc3.h(strSubstring8, "substring(...)");
                    String strA0 = AbstractC15401jX0.A0(AbstractC20762sZ6.N0(strSubstring7, new String[]{Separators.RETURN}, false, 0, 6, null), Separators.RETURN, null, null, 0, null, new UA2() { // from class: ir.nasim.yx1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return ActionModeCallbackC25231zx1.c((String) obj);
                        }
                    }, 30, null);
                    barEditText.setText(strSubstring6 + strA0 + strSubstring8);
                    barEditText.setSelection(selectionStart, i + strA0.length());
                    actionMode.finish();
                    objB = C9475a16.b(C19938rB7.a);
                } catch (Throwable th3) {
                    C9475a16.a aVar6 = C9475a16.b;
                    objB = C9475a16.b(AbstractC10685c16.a(th3));
                }
                return C9475a16.j(objB);
            case 28:
                this.b.invoke(Integer.valueOf(selectionStart), Integer.valueOf(selectionEnd));
                actionMode.finish();
                return true;
            default:
                return false;
        }
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        AbstractC13042fc3.i(actionMode, "mode");
        AbstractC13042fc3.i(menu, "menu");
        return d(this.a, menu);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        AbstractC13042fc3.i(actionMode, "mode");
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        AbstractC13042fc3.i(actionMode, "mode");
        AbstractC13042fc3.i(menu, "menu");
        return e(this.a);
    }
}
