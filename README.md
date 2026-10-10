<picture>
  <source media="(prefers-color-scheme: light)" srcset="assets/banner/hero-v2-light.svg">
  <img alt="SYNTHWERK-IDENTITY. It knows who you are. And what you paid for. Orgs, roles, entitlements. Status: rewrite." src="assets/banner/hero-v2-dark.svg" width="100%">
</picture>

<p align="center">

[![status: rewrite planned](https://img.shields.io/badge/status-rewrite_planned-10b981?style=flat-square&labelColor=0a0a0b)](#-05-status) [![VM. flagship](https://img.shields.io/badge/VM.-flagship-6366f1?style=flat-square&labelColor=0a0a0b)](https://github.com/VelimirMueller) [![stack: Go 1.27](https://img.shields.io/badge/stack-Go_1.27-a1a1aa?style=flat-square&labelColor=0a0a0b)](#-05-status) [![license: MIT](https://img.shields.io/badge/license-MIT-a1a1aa?style=flat-square&labelColor=0a0a0b)](LICENSE)

</p>

> It knows who you are. And what you paid for.

```text
 █████  ██  ██  ██  ██  ██████  ██  ██  ██   ██  ██████  █████   ██  ██
██      ██  ██  ███ ██    ██    ██  ██  ██   ██  ██      ██  ██  ██ ██
 ████    ████   ██████    ██    ██████  ██ █ ██  █████   █████   ████    █████
    ██    ██    ██ ███    ██    ██  ██  ███████  ██      ██ ██   ██ ██
█████     ██    ██  ██    ██    ██  ██   ██ ██   ██████  ██  ██  ██  ██
██████  █████   ██████  ██  ██  ██████  ██████  ██████  ██  ██
  ██    ██  ██  ██      ███ ██    ██      ██      ██    ██  ██
  ██    ██  ██  █████   ██████    ██      ██      ██     ████
  ██    ██  ██  ██      ██ ███    ██      ██      ██      ██
██████  █████   ██████  ██  ██    ██    ██████    ██      ██    ██

 ------  orgs · roles · entitlements · paywall --------------------------
```

**synthwerk-identity** owns organisations, roles, entitlements and the paywall for the synthwerk services.
Zitadel says who you are. This service decides what that is worth.

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="assets/readme/stats-v2-dark.svg">
  <img alt="0 LOGIN FORMS WRITTEN HERE. 1 ENTITLEMENTS TABLE FROM STRIPE. 3 CALLERS: STUDIO, WIDGETS, SDK. E2 REWRITE EPIC ON THE MAP" src="assets/readme/stats-v2-light.svg" width="100%">
</picture>

<br>

## // 01 WHAT IT DOES

<img alt="01 WHAT IT DOES. FRONT DOOR. ALSO THE CASH REGISTER." src="assets/readme/divider-what-v2.svg" width="100%">

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="assets/readme/features-v2-dark.svg">
  <img alt="WHO GETS IN: Organisations, roles and entitlements, owned here. Zitadel v4 does the login: OIDC, passkeys, MFA. WHAT THEY PAID FOR: Stripe events become one entitlements table. The paywall reads that table. WHO ASKS: Studio, widgets and SDK apps call this service. It answers with identity events on the NATS bus" src="assets/readme/features-v2-light.svg" width="100%">
</picture>

- Owns organisations, roles and entitlements for every synthwerk service.
- Zitadel v4 does the login: OIDC, passkeys, MFA. No login form lives here.
- Turns Stripe events into one entitlements table. The paywall reads that table.
- Emits identity events on the NATS bus. The other services trust them.

<br>

## // 02 QUICK START

<img alt="02 QUICK START. TWO FILES. BOTH ARE GOOD." src="assets/readme/divider-start-v2.svg" width="100%">

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="assets/readme/start-v2-dark.svg">
  <img alt="Terminal: $ gh repo clone VelimirMueller/synthwerk-identity | $ cd synthwerk-identity | $ ls | LICENSE  README.md | # the code is the rewrite. epic E2." src="assets/readme/start-v2-light.svg" width="100%">
</picture>

```bash
gh repo clone VelimirMueller/synthwerk-identity
cd synthwerk-identity
ls
```

- Output: `LICENSE  README.md`. That is the whole tree.
- No service runs from this repo yet. `main` carries the Synthwerk skeleton.
- The rewrite is epic **E2 Identity**, planned on the [synthwerk map](https://github.com/VelimirMueller/synthwerk).

<br>

## // 03 HOW IT WORKS

<img alt="03 HOW IT WORKS. WHO CHECKS WHOM, IN ORDER." src="assets/readme/divider-how-v2.svg" width="100%">

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="assets/readme/flow-v2-dark.svg">
  <img alt="CLIENTS -> IDENTITY -> ZITADEL V4 -> POSTGRES · NATS. Stripe webhooks come in. One entitlements table comes out." src="assets/readme/flow-v2-light.svg" width="100%">
</picture>

```text
 studio ──┐
 widgets ─┼──> identity ──> Zitadel v4 (OIDC, passkeys, MFA)
 sdk ─────┘       │
                  ├──> Postgres (orgs, roles, entitlements)
                  └──> NATS bus (identity events)

 stripe events ──> one entitlements table ──> the paywall
```

- Clients are synthwerk-studio, synthwerk-widgets and the SDK apps. They ask, identity answers.
- The rewrite targets Go 1.27.

<br>

## // 04 USAGE

<img alt="04 USAGE. SHORT, LIKE THE REPO." src="assets/readme/divider-usage-v2.svg" width="100%">

### Where it fits

- Ecosystem map: [synthwerk](https://github.com/VelimirMueller/synthwerk). One repo per role. Start there.
- Shared CI, lint configs and templates: [synthwerk-blueprint](https://github.com/VelimirMueller/synthwerk-blueprint).
- This repo was renamed. The old URL still redirects here.

### Legacy code

- The tag [`legacy-final`](../../tree/legacy-final) keeps the old service: a Kotlin/Quarkus prototype with hard-coded users and no tokens.
- Branching, when the code returns: `main` deploys to dev, a `vX.Y.Z` tag to stg, an approved digest to prd.

<br>

## // 05 STATUS

<img alt="05 STATUS. MOSTLY PLANS. CLEARLY LABELLED." src="assets/readme/divider-status-v2.svg" width="100%">

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="assets/readme/status-v2-dark.svg">
  <img alt="Rewrite (epic E2 Identity): planned. main branch: skeleton, no code. legacy-final tag: Kotlin/Quarkus prototype. Login: Zitadel v4: OIDC, passkeys, MFA. Branching: dev, stg by tag, prd by digest" src="assets/readme/status-v2-light.svg" width="100%">
</picture>

```text
[ STATUS ]  rewrite planned, epic E2 identity
[ WORKS   ]  the README. the LICENSE.
[ NEXT    ]  the service itself, in Go
```

No test command yet. No CHANGELOG yet. There is no code to test.
When the rewrite lands, this section gets honest numbers.

<br>

```text
-- EOF ------------------------------------ ACCESS GRANTED, EVENTUALLY --
```

---

<sub>VM. studio / flagship · open source · look per <code>vm-brand</code> playbook · [MIT](LICENSE) © 2025 Velimir Müller</sub>
