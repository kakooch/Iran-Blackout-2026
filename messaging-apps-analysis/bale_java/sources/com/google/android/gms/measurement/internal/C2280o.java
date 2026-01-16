package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import ir.nasim.AbstractC4043Dl1;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.measurement.internal.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2280o extends AbstractC2218b2 {
    private long c;
    private String d;
    private AccountManager e;
    private Boolean f;
    private long g;

    C2280o(H1 h1) {
        super(h1);
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2218b2
    protected final boolean j() {
        Calendar calendar = Calendar.getInstance();
        this.c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.d = language.toLowerCase(locale2) + "-" + locale.getCountry().toLowerCase(locale2);
        return false;
    }

    final long o() {
        h();
        return this.g;
    }

    public final long p() {
        k();
        return this.c;
    }

    public final String q() {
        k();
        return this.d;
    }

    final void r() {
        h();
        this.f = null;
        this.g = 0L;
    }

    final boolean s() throws OperationCanceledException, IOException, AuthenticatorException {
        Account[] result;
        h();
        long jCurrentTimeMillis = this.a.c().currentTimeMillis();
        if (jCurrentTimeMillis - this.g > 86400000) {
            this.f = null;
        }
        Boolean bool = this.f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (AbstractC4043Dl1.a(this.a.f(), "android.permission.GET_ACCOUNTS") != 0) {
            this.a.b().y().a("Permission error checking for dasher/unicorn accounts");
            this.g = jCurrentTimeMillis;
            this.f = Boolean.FALSE;
            return false;
        }
        if (this.e == null) {
            this.e = AccountManager.get(this.a.f());
        }
        try {
            result = this.e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
        } catch (AuthenticatorException e) {
            e = e;
            this.a.b().t().b("Exception checking account types", e);
            this.g = jCurrentTimeMillis;
            this.f = Boolean.FALSE;
            return false;
        } catch (OperationCanceledException e2) {
            e = e2;
            this.a.b().t().b("Exception checking account types", e);
            this.g = jCurrentTimeMillis;
            this.f = Boolean.FALSE;
            return false;
        } catch (IOException e3) {
            e = e3;
            this.a.b().t().b("Exception checking account types", e);
            this.g = jCurrentTimeMillis;
            this.f = Boolean.FALSE;
            return false;
        }
        if (result != null && result.length > 0) {
            this.f = Boolean.TRUE;
            this.g = jCurrentTimeMillis;
            return true;
        }
        Account[] result2 = this.e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
        if (result2 != null && result2.length > 0) {
            this.f = Boolean.TRUE;
            this.g = jCurrentTimeMillis;
            return true;
        }
        this.g = jCurrentTimeMillis;
        this.f = Boolean.FALSE;
        return false;
    }
}
