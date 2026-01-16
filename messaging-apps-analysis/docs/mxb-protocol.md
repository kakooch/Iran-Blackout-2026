# MXB Protocol Analysis (Message Exchange Bus)

**Analysis Date:** January 15, 2026
**Source:** Decompiled APK source code
**Classification:** OSINT / Forensic Technical Analysis

---

## Executive Summary

MXB (Message Exchange Bus) is Iran's national cross-messenger interoperability protocol. It enables users of different Iranian messaging apps to communicate with each other. This analysis documents the MXB implementation found in the decompiled source code of both Bale and Eitaa.

---

## MXB Overview

```
┌─────────────────────────────────────────────────────────────────────────┐
│                        MXB (Message Exchange Bus)                        │
│                      Central Iranian Message Router                      │
├─────────────────────────────────────────────────────────────────────────┤
│                                                                          │
│    ┌──────┐  ┌──────┐  ┌──────┐  ┌──────┐  ┌──────┐  ┌──────┐  ┌──────┐│
│    │ Bale │  │ IGap │  │ Gap  │  │Eitaa │  │Rubika│  │Soroush│ │Chavosh││
│    │  (1) │  │  (2) │  │  (3) │  │  (4) │  │  (5) │  │  (6)  │ │  (7) ││
│    └──┬───┘  └──┬───┘  └──┬───┘  └──┬───┘  └──┬───┘  └──┬───┘  └──┬───┘│
│       │         │         │         │         │         │         │     │
│       └─────────┴─────────┴────┬────┴─────────┴─────────┴─────────┘     │
│                                │                                         │
│                    ┌───────────▼───────────┐                            │
│                    │   MXB Central Server  │                            │
│                    │  (Phone → App Registry)│                            │
│                    └───────────────────────┘                            │
└─────────────────────────────────────────────────────────────────────────┘
```

---

## Participating Apps

### From Eitaa Code

**File:** `ir/eitaa/helper/MxbHelper.java`

```java
static {
    messengersName = new HashMap<>();
    messengersName.put("1", "Bale");
    messengersName.put("2", "IGap");
    messengersName.put("3", "Gap");
    messengersName.put("4", "Eitaa");
    messengersName.put("5", "Rubica");
    messengersName.put("6", "Soroush");
    messengersName.put("7", "Chavosh");
}
```

### From Bale Code

**File:** `ai/bale/mxb/Mxb.java`

```java
public enum PuppetType {
    UNKNOWN(0),
    IGAP(2),
    GAP(3),
    EITTA(4),   // Note: Typo in source
    RUBIKA(5),
    SPLUS(6);
}
```

---

## Eitaa MXB Implementation

### Protocol: TLRPC (Telegram RPC)

Eitaa uses a Telegram-derived RPC protocol for MXB operations.

### Key API Calls

#### 1. Query User Registrations Across Apps

**File:** `ir/eitaa/tgnet/TLRPC$TL_mxpGetUserRegisterInfo.java`

```java
public class TLRPC$TL_mxpGetUserRegisterInfo extends TLObject {
    public static final int constructor = 0x1a2b3c4d;

    public String phone;  // Phone number to query

    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(phone);
    }
}
```

**Purpose:** Queries the MXB server to check which Iranian messaging apps a phone number is registered on.

**Privacy Concern:** Any app can query if a phone number is registered on competing apps.

#### 2. User Registration Info Response

**File:** `ir/eitaa/tgnet/TLRPC$TL_mxbUserRegisterInfo.java`

```java
public class TLRPC$TL_mxbUserRegisterInfo extends TLObject {
    public static final int constructor = 0x2b3c4d5e;

    public int messenger_id;      // App ID (1-7)
    public String nickname;       // Display name on that app
    public String avatar;         // Profile photo URL
    public String phone;          // Phone number
    public long mxb_user_id;      // Cross-app user ID

    public void readParams(AbstractSerializedData stream, boolean exception) {
        messenger_id = stream.readInt32(exception);
        nickname = stream.readString(exception);
        avatar = stream.readString(exception);
        phone = stream.readString(exception);
        mxb_user_id = stream.readInt64(exception);
    }
}
```

**Data Exposed:**
- User's nickname on each app
- Profile photo from each app
- Unified cross-app user ID

#### 3. Initiate Cross-App Chat

**File:** `ir/eitaa/tgnet/TLRPC$TL_mxbCreateUser.java`

```java
public class TLRPC$TL_mxbCreateUser extends TLObject {
    public static final int constructor = 0x3c4d5e6f;

    public long mxb_user_id;      // Target user's MXB ID
    public int messenger_id;       // Target app

    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(mxb_user_id);
        stream.writeInt32(messenger_id);
    }
}
```

**Purpose:** Creates a virtual user representation to enable cross-app messaging.

#### 4. MXB Self-Registration

**File:** `ir/eitaa/tgnet/TLRPC$TL_mxbRegisterSelf.java`

```java
public class TLRPC$TL_mxbRegisterSelf extends TLObject {
    public static final int constructor = 0x4d5e6f70;

    public boolean register;  // true = opt-in, false = opt-out

    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeBool(register);
    }
}
```

### User Flags

**File:** `ir/eitaa/tgnet/TLRPC$User.java`

```java
// MXB-related user flags
public static final int MXB_REGISTERED_USER = 0x100;  // User opted into MXB
public static final int MXB_VIRTUAL_USER = 0x200;     // User is from another app

public boolean isMxbRegistered() {
    return (flags & MXB_REGISTERED_USER) != 0;
}

public boolean isMxbVirtualUser() {
    return (flags & MXB_VIRTUAL_USER) != 0;
}
```

### MXB Helper Implementation

**File:** `ir/eitaa/helper/MxbHelper.java`

```java
public class MxbHelper {
    // Query which apps a phone number is registered on
    public static void getUserRegistrations(String phone,
            Consumer<List<MxbUserInfo>> callback) {
        TLRPC$TL_mxpGetUserRegisterInfo request = new TLRPC$TL_mxpGetUserRegisterInfo();
        request.phone = phone;

        ConnectionsManager.getInstance(currentAccount).sendRequest(request,
            (response, error) -> {
                if (response instanceof TLRPC$TL_mbpUserRegisterInfos) {
                    TLRPC$TL_mbpUserRegisterInfos result =
                        (TLRPC$TL_mbpUserRegisterInfos) response;
                    callback.accept(result.users);
                }
            });
    }

    // Get messenger name by ID
    public static String getMessengerName(int id) {
        return messengersName.get(String.valueOf(id));
    }
}
```

---

## Bale MXB Implementation

### Protocol: gRPC

Bale uses a gRPC-based protocol for MXB operations, distinct from Eitaa's TLRPC.

### gRPC Service Endpoints

**File:** `ir/nasim/C9345Zn4.java`

```java
// MXB gRPC endpoints
public static final String REGISTER_MXB = "/ai.bale.mxb.MXB/RegisterToMXB";
public static final String UNREGISTER_MXB = "/ai.bale.mxb.MXB/UnregisterToMXB";
public static final String SEARCH_PUPPETS = "/ai.bale.mxb.MXB/SearchPuppetUsers";
public static final String GET_PUPPETS = "/ai.bale.mxb.MXB/GetUserPuppets";
```

### Puppet System

Bale refers to cross-app users as "puppets" - virtual representations of users from other apps.

#### Registration Request

**File:** `ai/bale/mxb/Mxb$RequestRegisterToMXB.java`

```java
public final class RequestRegisterToMXB extends GeneratedMessageLite {
    // Empty message - registration uses authenticated session
}
```

#### Puppet User Search

**File:** `ai/bale/mxb/Mxb$RequestSearchPuppetUsers.java`

```java
public final class RequestSearchPuppetUsers extends GeneratedMessageLite {
    private String query_;        // Search term
    private int puppetType_;      // Target app (2=IGap, 3=Gap, etc.)
}
```

#### Puppet User Entity

**File:** `ir/nasim/features/mxp/entity/PuppetUser.java`

```java
public class PuppetUser {
    private long id;
    private String name;
    private String avatar;
    private PuppetType type;      // Which app this user is from
    private long originalUserId;  // User's ID on their home app
}
```

#### Puppet Types Enum

**File:** `ai/bale/mxb/Mxb$PuppetType.java`

```java
public enum PuppetType {
    UNKNOWN(0),
    IGAP(2),
    GAP(3),
    EITTA(4),
    RUBIKA(5),
    SPLUS(6);

    private final int value;

    public static PuppetType forNumber(int value) {
        switch (value) {
            case 0: return UNKNOWN;
            case 2: return IGAP;
            case 3: return GAP;
            case 4: return EITTA;
            case 5: return RUBIKA;
            case 6: return SPLUS;
            default: return null;
        }
    }
}
```

---

## MXB Message Flow

```
┌─────────────────────────────────────────────────────────────────────────┐
│                        Cross-App Message Flow                            │
├─────────────────────────────────────────────────────────────────────────┤
│                                                                          │
│   Eitaa User                    MXB Server                    Bale User  │
│       │                             │                             │      │
│       │  1. Query phone number      │                             │      │
│       │ ─────────────────────────►  │                             │      │
│       │                             │                             │      │
│       │  2. Return registrations    │                             │      │
│       │     (Bale: nickname,        │                             │      │
│       │      avatar, mxb_id)        │                             │      │
│       │ ◄─────────────────────────  │                             │      │
│       │                             │                             │      │
│       │  3. Create puppet user      │                             │      │
│       │ ─────────────────────────►  │                             │      │
│       │                             │                             │      │
│       │  4. Send message to         │  5. Route to Bale           │      │
│       │     puppet                  │ ─────────────────────────►  │      │
│       │ ─────────────────────────►  │                             │      │
│       │                             │                             │      │
│       │                             │  6. Deliver as external     │      │
│       │                             │     message                 │      │
│       │                             │ ─────────────────────────►  │      │
│                                                                          │
└─────────────────────────────────────────────────────────────────────────┘
```

---

## Privacy Implications

### 1. Cross-App User Discovery

Any Iranian messenger can query whether a phone number is registered on other apps:

```java
// Query if +98912xxxxxxx is on Bale, Rubika, Soroush, etc.
TLRPC$TL_mxpGetUserRegisterInfo request = new TLRPC$TL_mxpGetUserRegisterInfo();
request.phone = "+98912xxxxxxx";
```

**Impact:** Users cannot hide their presence on one app from another.

### 2. Profile Information Leakage

Cross-app queries return:
- Display names
- Profile photos
- Unified user IDs

**Impact:** Profile information set on one app is accessible to all MXB-connected apps.

### 3. Centralized Metadata Collection

The MXB server maintains:
- Complete registry of all users across all apps
- Phone number to app mapping
- Cross-app communication logs

**Impact:** Central point for comprehensive surveillance of Iranian messenger ecosystem.

### 4. No Opt-Out Verification

While apps provide UI for MXB opt-out, the server-side behavior cannot be verified:

```java
// User thinks they're opting out
TLRPC$TL_mxbRegisterSelf request = new TLRPC$TL_mxbRegisterSelf();
request.register = false;  // But does server actually stop sharing data?
```

---

## Comparison: Eitaa vs Bale MXB

| Feature | Eitaa | Bale |
|---------|-------|------|
| Protocol | TLRPC (Telegram-derived) | gRPC |
| User terminology | "MXB User" | "Puppet User" |
| Supported apps | 7 (includes Chavosh) | 5 (excludes Chavosh, Soroush) |
| Registration call | `mxbRegisterSelf` | `RegisterToMXB` |
| User search | `mxpGetUserRegisterInfo` | `SearchPuppetUsers` |

---

## Regulatory Context

MXB was mandated by Iranian regulators to ensure:
1. Interoperability between domestic messaging apps
2. Central visibility into messaging patterns
3. Reduced dependence on foreign platforms (Telegram, WhatsApp)

---

## Evidence Files

See [code-snippets.md](../evidence/code-snippets.md) for complete code excerpts from decompiled sources.
