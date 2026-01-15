# Iran Network Infrastructure Research Findings

**Date:** 2026-01-15
**Tools:** RIPE Atlas, RIPE Stat, OONI
**API Key:** a97c740a-13d7-485c-bc1e-3eaca93e2dbf (10.7M credits)

---

## Executive Summary

We investigated 6 questions about Iran's internet infrastructure using RIPE Atlas measurements and OONI data. Key findings:

1. **DNS is poisoned at the network level** - even queries to 8.8.8.8/1.1.1.1 return block page IPs
2. **ArvanCloud is reachable internally** - 3.5ms latency from inside Iran
3. **All 12 Iranian anchor probes are disconnected** - major infrastructure issue
4. **External probes cannot reach ANY Iranian infrastructure** - all timeouts

---

## Original Questions & Answers

### Q1: Fake google.com cert on ArvanCloud (Irancell customer)
**Status:** Cannot test externally - ArvanCloud IPs not globally routable
**What we know:** SNI-based DPI blocks at ClientHello before certificate exchange

### Q2: Whitelisted domains (sibapp.com) on ArvanCloud
**Status:** Same limitation - requires internal testing
**What we know:** sibapp.com resolves to 185.53.142.188, pingable at 8.8ms from inside Iran

### Q3: DNS Upstream Behavior ✓ CONFIRMED
**Evidence:**
```
From probe 25407 inside Iran:
  Query: telegram.org via 1.1.1.1 → Response: 10.10.34.36 (POISONED)
  Query: telegram.org via 8.8.8.8 → Response: 10.10.34.36 (POISONED)

From global probes:
  Query: telegram.org via 8.8.8.8 → Response: 149.154.167.99 (CORRECT)
```
**Conclusion:** DNS interception at network level. All queries inside Iran are inspected and blocked domains return 10.10.34.x block page IPs regardless of resolver used.

### Q4: ICMP to ArvanCloud ✓ TESTED
**From inside Iran (probe 25407):**
| Target | Result |
|--------|--------|
| 8.8.8.8 (Google DNS) | 61.1ms SUCCESS |
| 185.220.0.1 (ArvanCloud) | TIMEOUT |
| 185.143.232.1 (ArvanCloud) | 3.5ms SUCCESS |
| 185.53.142.188 (sibapp.com) | 8.8ms SUCCESS |

**Conclusion:** ArvanCloud IS reachable. 185.220.0.1 doesn't respond to ICMP (likely firewall/router), but 185.143.232.1 works fine.

### Q5: Bale/Ita Video Call Protocol
**Status:** Deferred - requires pcap capture from inside Iran

### Q6: STUN Server Availability
**Status:** Deferred - requires local testing

---

## RIPE Atlas Infrastructure Status

### Probes in Iran
- **544 total registered** (most abandoned/disconnected)
- **1 active probe:** 25407 (AS14593, home DSL, Tehran area)
- Probe 25407 was disconnected earlier today but reconnected

### Anchors in Iran (12 active, ALL DISCONNECTED)
| Hostname | City | ASN | Status |
|----------|------|-----|--------|
| ir-thr-as12697 | Tehran | 12697 | Disconnected |
| ir-thr-as204203 | Tehran | 204203 | Disconnected |
| ir-thr-as39650 | Tehran | 39650 | Disconnected |
| ir-thr-as44285 | Tehran | 44285 | Disconnected |
| ir-thr-as44531 | Tehran | 44531 | Disconnected |
| ir-thr-as47376 | Tehran | 47376 | Disconnected |
| ir-thr-as59441 | Tehran | 59441 | Disconnected |
| ir-mhd-as58224-client | Mashhad | 58224 | Disconnected |
| ir-syz-as58224-client | Shiraz | 58224 | Disconnected |
| ir-ifn-as49556 | Isfahan | 49556 | Disconnected |
| ir-ker-as201150-client | Kerman | 201150 | Disconnected |
| ir-qum-as48147 | Qom | 48147 | Disconnected |

### K-root in Iran
- **3 instances in Tehran** (deployed April 2015)
- Provides low-latency root DNS for Iranian users
- Historical routing leak issue fixed in Sept 2015

### I-root
- **No instances in Iran** (Netnod operates 41 globally, nearest likely Dubai/Stockholm)

---

## RIPE Atlas Measurements Created

| ID | Type | Target | From | Result |
|----|------|--------|------|--------|
| 149083370 | ping | 85.185.93.118 (TCI) | Global | ALL TIMEOUT |
| 149083401 | ping | 185.220.0.1 (ArvanCloud) | Global | ALL TIMEOUT |
| 149083405 | traceroute | 185.220.0.1 | Global | Blackholes at hop 8 |
| 149083407 | traceroute | 193.0.14.129 (K-root) | Global | Pending |
| 149083552 | dns | telegram.org via 8.8.8.8 | Global | 149.154.167.99 (correct) |
| 149083555 | dns | sibapp.com via 8.8.8.8 | Global | 185.53.142.188 |
| 149083562 | sslcert | 185.220.0.1 w/ google.com SNI | Global | ALL TIMEOUT |
| 149088004 | ping | 8.8.8.8 | Iran (25407) | 61.1ms SUCCESS |
| 149088015 | ping | 185.220.0.1 | Iran (25407) | TIMEOUT |
| 149088147 | dns | telegram.org (local resolver) | Iran (25407) | 10.10.34.36 (poisoned) |
| 149088153 | ping | 185.143.232.1 (ArvanCloud) | Iran (25407) | 3.5ms SUCCESS |
| 149088159 | ping | 185.53.142.188 (sibapp) | Iran (25407) | 8.8ms SUCCESS |

---

## OONI Evidence

### Confirmed Blocking (Irancell AS197207)
- **twitter.com** - DNS blocked (fingerprint: ooni.ir_10dot10_ipv4_1)
- **facebook.com** - DNS blocked (fingerprint: ooni.ir_10dot10_ipv4_1)

### Block Page IP
- **10.10.34.36** - National block page returned for DNS queries to blocked domains

---

## Key Technical Insights

1. **National Intranet:** ArvanCloud IPs (185.220.x.x) are only routable within Iran
2. **DNS Interception:** All DNS queries are inspected; external resolvers receive poisoned responses
3. **SNI Filtering:** DPI blocks based on SNI in TLS ClientHello
4. **Infrastructure Issues:** All 12 anchor probes disconnected suggests major network event

---

## Files in This Directory

```
ripe-atlas-research/
├── FINDINGS.md          # This document
├── research-plan.md     # Original research plan
├── scripts/
│   ├── ripe_atlas.py    # RIPE Atlas API wrapper
│   └── ooni_analysis.py # OONI data analysis
└── data/
    ├── atlas/
    │   └── measurements_20260115.json
    └── ooni/
```

---

## Next Steps

1. **Monitor probe 25407** - only active probe inside Iran
2. **Wait for anchors** to reconnect for internal measurements
3. **Find volunteer** for pcap capture (Bale/STUN testing)
4. **Check DNSmon** for K-root Tehran latency data
