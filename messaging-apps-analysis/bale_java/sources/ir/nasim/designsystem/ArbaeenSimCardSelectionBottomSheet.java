package ir.nasim.designsystem;

import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.C14486i0;
import ir.nasim.C19406qI3;
import ir.nasim.C20865sk0;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.designsystem.ArbaeenSimCardSelectionBottomSheet;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u0017R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lir/nasim/designsystem/ArbaeenSimCardSelectionBottomSheet;", "Lir/nasim/m0;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "code", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Lir/nasim/rB7;", "g", "()V", "", "simSlot", "e", "(I)V", "ussd", "Landroid/net/Uri;", "j", "(Ljava/lang/String;)Landroid/net/Uri;", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "a", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "", "b", "[Ljava/lang/String;", "simSlotNames", "c", "Lir/nasim/i0;", "getAbol", "()Lir/nasim/i0;", "setAbol", "Lir/nasim/sk0;", "d", "Lir/nasim/sk0;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ArbaeenSimCardSelectionBottomSheet extends FrameLayout implements InterfaceC16866m0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final String code;

    /* renamed from: b, reason: from kotlin metadata */
    private final String[] simSlotNames;

    /* renamed from: c, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: d, reason: from kotlin metadata */
    private C20865sk0 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArbaeenSimCardSelectionBottomSheet(Context context, String str) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "code");
        this.code = str;
        this.simSlotNames = new String[]{"extra_asus_dial_use_dualsim", "com.android.phone.extra.slot", "slot", "simslot", "sim_slot", "subscription", "Subscription", "phone", "com.android.phone.DialingMode", "simSlot", "slot_id", "simId", "simnum", "phone_type", "slotId", "slotIdx"};
        C20865sk0 c20865sk0C = C20865sk0.c(LayoutInflater.from(context), this, true);
        AbstractC13042fc3.h(c20865sk0C, "inflate(...)");
        this.binding = c20865sk0C;
        g();
    }

    private final void e(int simSlot) {
        String name;
        String name2;
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(j(this.code));
        intent.addFlags(268435456);
        intent.putExtra("com.android.phone.force.slot", true);
        intent.putExtra("Cdma_Supp", true);
        try {
            for (String str : this.simSlotNames) {
                intent.putExtra(str, simSlot);
            }
            Object systemService = getContext().getSystemService("telecom");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
            List<PhoneAccountHandle> callCapablePhoneAccounts = ((TelecomManager) systemService).getCallCapablePhoneAccounts();
            if (callCapablePhoneAccounts != null && callCapablePhoneAccounts.size() > simSlot) {
                intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", callCapablePhoneAccounts.get(simSlot));
            }
        } catch (Exception e) {
            if (ArbaeenSimCardSelectionBottomSheet.class.isAnonymousClass()) {
                name = ArbaeenSimCardSelectionBottomSheet.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = ArbaeenSimCardSelectionBottomSheet.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e);
        }
        try {
            getContext().startActivity(intent);
            C14486i0 c14486i0 = this.abol;
            if (c14486i0 != null) {
                c14486i0.g();
            }
        } catch (Exception e2) {
            if (ArbaeenSimCardSelectionBottomSheet.class.isAnonymousClass()) {
                name2 = ArbaeenSimCardSelectionBottomSheet.class.getName();
                int length3 = name2.length();
                AbstractC13042fc3.f(name2);
                if (length3 > 23) {
                    name2 = name2.substring(name2.length() - 23, name2.length());
                    AbstractC13042fc3.h(name2, "substring(...)");
                }
            } else {
                name2 = ArbaeenSimCardSelectionBottomSheet.class.getSimpleName();
                int length4 = name2.length();
                AbstractC13042fc3.f(name2);
                if (length4 > 23) {
                    name2 = name2.substring(0, 23);
                    AbstractC13042fc3.h(name2, "substring(...)");
                }
            }
            C19406qI3.d(name2, e2);
        }
    }

    private final void g() {
        this.binding.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zH
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArbaeenSimCardSelectionBottomSheet.h(this.a, view);
            }
        });
        this.binding.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.AH
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArbaeenSimCardSelectionBottomSheet.i(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ArbaeenSimCardSelectionBottomSheet arbaeenSimCardSelectionBottomSheet, View view) {
        AbstractC13042fc3.i(arbaeenSimCardSelectionBottomSheet, "this$0");
        arbaeenSimCardSelectionBottomSheet.e(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ArbaeenSimCardSelectionBottomSheet arbaeenSimCardSelectionBottomSheet, View view) {
        AbstractC13042fc3.i(arbaeenSimCardSelectionBottomSheet, "this$0");
        arbaeenSimCardSelectionBottomSheet.e(1);
    }

    private final Uri j(String ussd) {
        StringBuilder sb = new StringBuilder();
        if (!AbstractC20153rZ6.S(ussd, "tel:", false, 2, null)) {
            sb.append("tel:");
        }
        char[] charArray = ussd.toCharArray();
        AbstractC13042fc3.h(charArray, "toCharArray(...)");
        for (char c : charArray) {
            if (c == '#') {
                sb.append(Uri.encode(Separators.POUND));
            } else {
                sb.append(c);
            }
        }
        return Uri.parse(sb.toString());
    }

    public final C14486i0 getAbol() {
        return this.abol;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setAbol(C14486i0 c14486i0) {
        this.abol = c14486i0;
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }
}
