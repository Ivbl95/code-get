# capacitor-code-get

Codeget plugin

## Install

```bash
npm install capacitor-code-get
npx cap sync
```

## API

<docgen-index>

* [`checkUpdates(...)`](#checkupdates)
* [`installUpdates()`](#installupdates)
* [`rejectUpdates()`](#rejectupdates)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### checkUpdates(...)

```typescript
checkUpdates(options: { update_channel: string; current_app_version: string; platform: string; }) => Promise<unknown>
```

| Param         | Type                                                                                    |
| ------------- | --------------------------------------------------------------------------------------- |
| **`options`** | <code>{ update_channel: string; current_app_version: string; platform: string; }</code> |

**Returns:** <code>Promise&lt;unknown&gt;</code>

--------------------


### installUpdates()

```typescript
installUpdates() => Promise<unknown>
```

**Returns:** <code>Promise&lt;unknown&gt;</code>

--------------------


### rejectUpdates()

```typescript
rejectUpdates() => Promise<unknown>
```

**Returns:** <code>Promise&lt;unknown&gt;</code>

--------------------

</docgen-api>
