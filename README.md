# Secret ID Economy & Government Mod (Fabric 1.20.1)

A feature-rich roleplay, economy, and government management mod for Minecraft Fabric 1.20.1. This mod introduces a unique identity system, a fixed-supply economy, a taxation framework, and real-world data fetching via Google Sheets!

## Features

### 1. Secret ID System
* Every player is assigned a unique, randomly generated **6-character alphanumeric Secret ID** upon joining.
* IDs are completely private. Only the player and Server Admins know who owns which ID.
* All financial transactions (sending money) are done using these IDs, ensuring complete anonymity in the economy.

### 2. Fixed-Supply Economy & Treasury
* The economy is designed with a **fixed supply** of exactly `1,000,000 AK Lira`.
* New players do not spawn with money. The entire supply initially sits in the **State Treasury**.
* The **President** can distribute funds to the public by sending money from the Treasury to citizens' Secret IDs.

### 3. Government Roles & Administration
* Admins can assign roles to players (e.g., `PRESIDENT`, `MAYOR`, `MP`).
* The President has exclusive access to manage the State Treasury, mint/withdraw funds, and manage taxes.

### 4. Advanced Tax System
* The President can enact new global taxes by defining a 3-letter tax code and an amount (e.g., `/vergi ekle KDV 500`).
* Taxes are automatically recorded as debt for all citizens.
* Citizens can pay their taxes in installments. All paid taxes go directly back into the State Treasury, keeping the economy balanced.

### 5. Real-Time Cloud Data Integration
* The mod fetches live economic data (Inflation, Growth, Export, etc.) and exchange rates directly from a live **Google Sheets** document.
* The President can view detailed state economy data, and citizens can view live, real-world exchange rates via in-game commands.

## Commands

### Citizen Commands
* `/myid` - View your personal Secret ID.
* `/balance` - Check your current balance.
* `/pay <target_secret_id> <amount>` - Transfer money to another citizen anonymously.
* `/borc` - View your unpaid taxes and outstanding debts.
* `/vergi ode <tax_code> <amount>` - Pay your taxes (supports partial/installment payments).
* `/govexchangerate` - Fetch live currency exchange rates from the cloud.

### President Commands
* `/hazine` - View the total amount of money currently in the State Treasury.
* `/hazine gonder <target_secret_id> <amount>` - Transfer money from the Treasury to a citizen.
* `/hazine cek <amount>` - Withdraw money from the Treasury to your personal account.
* `/vergi ekle <tax_code> <amount>` - Create a new tax or update an existing one.
* `/govdata <your_secret_id> [date]` - Fetch confidential state economic data from the cloud.

### Admin Commands (Requires Permission Level 2)
* `/setid <player_name> <new_id>` - Manually change a player's Secret ID.
* `/setrole <target_secret_id> <role>` - Assign a government role to a player (`NONE`, `PRESIDENT`, `MAYOR`, `MP`).

## Setup & Installation
1. Install [Fabric Loader](https://fabricmc.net/) for Minecraft 1.20.1.
2. Place the compiled `.jar` file into your server's or client's `mods` folder.
3. Enjoy your new fully-fledged government roleplay experience!

## Development
This mod is built using the Fabric API. To compile the mod from source:
```bash
./gradlew build
```
The compiled jar will be located in the `build/libs/` directory.
