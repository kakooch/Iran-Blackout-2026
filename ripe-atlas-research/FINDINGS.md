# Iran Internet Infrastructure - RIPE Atlas Findings

**Date:** 2026-01-15
**Probe:** [25407](https://atlas.ripe.net/probes/25407/) (AS14593, Tehran)

---

## Q3: DNS Upstream Behavior

**Answer:** DNS is poisoned at the network level.

| Location | Query | Resolver | Answer | Measurement |
|----------|-------|----------|--------|-------------|
| Iran | telegram.org | 8.8.8.8 | `10.10.34.36` ❌ | [149088147](https://atlas.ripe.net/measurements/149088147/) |
| Iran | telegram.org | 1.1.1.1 | `10.10.34.36` ❌ | [149088147](https://atlas.ripe.net/measurements/149088147/) |
| Global | telegram.org | 8.8.8.8 | `149.154.167.99` ✓ | [149083552](https://atlas.ripe.net/measurements/149083552/) |

`10.10.34.36` is Iran's national block page IP.

---

## Q4: ICMP to ArvanCloud

**Answer:** Yes, reachable internally at 3.5ms.

| Target | RTT | Measurement |
|--------|-----|-------------|
| 185.143.232.1 (ArvanCloud) | 3.46ms | [149088153](https://atlas.ripe.net/measurements/149088153/) |
| 185.53.142.188 (sibapp.com) | 8.8ms | [149088159](https://atlas.ripe.net/measurements/149088159/) |
| 8.8.8.8 (Google DNS) | 61.1ms | [149088004](https://atlas.ripe.net/measurements/149088004/) |

---

## Unanswered

| Question | Why |
|----------|-----|
| Q1: Fake google.com cert | ArvanCloud not reachable externally ([149083401](https://atlas.ripe.net/measurements/149083401/)) |
| Q2: Whitelisted domain TLS | Same limitation |
| Q5-Q6: Bale/Ita, STUN | Requires pcap from inside Iran |

---

Only 1 active probe in Iran. All 12 anchors disconnected on 2026-01-15.
